//Ian Garrett, Assignment7, igarrett@uoregon.edu, CIS 212 Fall 2014

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
	// Variables used to control size parameters
	private static final long max_COUNT = 2000000;
	private static int producePrint_INTERVAL = 1000;
	private static int consumePrint_INTERVAL = 1000;
	private static int producePrint_COUNT = 0;
	private static int consumePrint_COUNT = 0;
	private static int produce_SUM = 0;
	private static int consume_SUM = 0;
	
	//PART 1
	public static void main(String[] args) {
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(100000);
		ProducerRunnable producer = new ProducerRunnable(queue);
		ConsumerRunnable consumer = new ConsumerRunnable(queue);
		
		//PART 4
		ExecutorService executor = Executors.newCachedThreadPool();	
		executor.execute(producer);
		executor.execute(consumer);
		executor.shutdown();
	}
	
	//PART 2 Producer Class
	private static class ProducerRunnable implements Runnable {
		private BlockingQueue<String> _queue;
		
		public ProducerRunnable(BlockingQueue<String> queue) {
			_queue = queue;
		}
		
		@Override
		public synchronized void run() {
			for (int i = 0; i < max_COUNT; ++i) {
				
				//generates random strings
				UUID id = UUID.randomUUID();
				String newRandomString = id.toString();

				
				try {
					Thread.yield();
					
					_queue.put(newRandomString);
					
					//System.out.println("Produced: " + newRandomString);// test statement
					
				} catch (InterruptedException ex) {
					System.err.println("Interrupted: " + ex);
				}
				
				producePrint_COUNT ++;
				if (producePrint_COUNT >= producePrint_INTERVAL){
					produce_SUM += producePrint_COUNT;
					System.out.println(produce_SUM + " Strings produced");
					producePrint_COUNT = 0;
				}
			}
			
			System.out.println("\nProduction Compete\n");
		}
	}
	
	//PART 3 Consumer Class
	private static class ConsumerRunnable implements Runnable {
		private BlockingQueue<String> _queue;
		
		public ConsumerRunnable(BlockingQueue<String> queue) {
			_queue = queue;
		}

		@Override
		public synchronized void run() {
			String largestString = null; //how to do this without
			for (int i = 0; i < max_COUNT; ++i) {
						
				try {
					Thread.sleep(1);
					
					String n = _queue.take();
				
					//System.out.println("Consumed: " + n);// test statement
					
					if (largestString == null){
						largestString = n;
					}
					else{
						if (n.compareTo(largestString)>0)
							largestString = n;
					}
				} catch (InterruptedException ex) {
					System.err.println("Interrupted: " + ex);
				}	
				
				consumePrint_COUNT ++;
				if (consumePrint_COUNT >= consumePrint_INTERVAL){
					consume_SUM += consumePrint_COUNT;
					System.out.println(consume_SUM + " Strings consumed");
					consumePrint_COUNT = 0;
				}
			}		
			System.out.println("\nConsumption Complete\n");
			
			//End program procedure
			System.out.println("----------------------------------------------------");
			System.out.println("Largest String: " + largestString);
			if (produce_SUM == consume_SUM){
				System.out.println("\nThreading Synronization Achieved: # of String produced = # of Strings consumed" );
			}
			else
				System.out.println("\nThreading Synronization NOT Achieved: # of String produced != # of Strings consumed" );
		}
	}
 }