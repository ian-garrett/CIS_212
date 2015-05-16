//Ian Garrett, Assignment8, igarrett@uoregon.edu, CIS 212 Fall 2014
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Server {
	private static final int PORT = 12345;
	private static String lastMessage = "You're the first to connect!";
	
	
	

	private ConcurrentLinkedQueue<ObjectSocket> _queue;
	
	public Server() {
		_queue = new ConcurrentLinkedQueue<ObjectSocket>();
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new AcceptRunnable());
		executorService.execute(new IORunnable());
		executorService.shutdown();
	}
	
	private class AcceptRunnable implements Runnable {
		@Override
		public void run() {
			try {
				System.out.println("creating server socket");
	
				ServerSocket serverSocket = new ServerSocket(PORT);
				
				boolean running = true;
				while (running) {
					System.out.println("waiting for connection");

					Socket socket = serverSocket.accept();
					_queue.offer(new ObjectSocket(socket));

					System.out.println("accepted connection");
				}				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private class IORunnable implements Runnable {
		@Override
		public void run() {
			boolean running = true;
			while (running) {
				for (ObjectSocket objectSocket : _queue) {
					ObjectInputStream inputStream = objectSocket.getInputStream();
					ObjectOutputStream outputStream = objectSocket.getOutputStream();	
					try {
						if (inputStream.available() > 0) {
							String message = inputStream.readUTF();
							outputStream.writeUTF(message);
					
							if (message.equals("shutdown")){
								System.out.println("\nSERVER HAS SHUT DOWN");
								running = false;
								
							}			
								try {
									outputStream.writeUTF("The last user entered: "+lastMessage+"\n");
									outputStream.flush();
									lastMessage = message;
								} catch (IOException ex) {
									System.out.println("WARNING: Failed to send to: " + objectSocket);
								}
				 			
						}
					} catch (IOException ex) {
						System.out.println("WARNING: Failed to read from: " + objectSocket);
					}
				}
			}
			
		}
	}
	
	private class ObjectSocket {
		private Socket _socket;
		private ObjectInputStream _inputStream;
		private ObjectOutputStream _outputStream;
		
		public ObjectSocket(Socket socket) {
			_socket = socket;
			try {
				_outputStream = new ObjectOutputStream(_socket.getOutputStream());
				_outputStream.flush();

				_inputStream = new ObjectInputStream(_socket.getInputStream());
			} catch (IOException ex) {
				ex.printStackTrace();	
			}
		}
		
		public ObjectInputStream getInputStream() {
			return _inputStream;
		}

		public ObjectOutputStream getOutputStream() {
			return _outputStream;
		}
	}
	
	public static void main(String[] args) {
		new Server();
	}
}