//Ian Garrett, Assignment2, igarrett@uoregon.edu, CIS 212 Fall 2014
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.InputMismatchException;
public class Main {
	
	public static void main(String[] args) {
		//Part 1
		
		int array_length = 0;
		Random random = new Random();
		Scanner input1 = new Scanner (System.in);
		try {
			System.out.println("Enter an array length: ");
			array_length = input1.nextInt();
		}
		catch (InputMismatchException exception){
			System.out.println("Please enter a valid integer");
			input1.close();
			input1.next();
		}
		
		System.out.println("Enter an array density: ");
		double density = input1.nextDouble();
		
		//Part 6
		long start_1 = System.nanoTime();
		int [] dense = createDenseArray(array_length, density);
		long dense_time = System.nanoTime() -start_1;
		
		long start_2 = System.nanoTime();
		ArrayList<Integer> sparse = createSparseArray(array_length, density);
		long sparse_time = System.nanoTime() -start_2;
		
		long start_3 = System.nanoTime();
		int sum1 = array_max(dense)[0];
		int sum2 = array_max(dense)[1];
		long array_max_time = System.nanoTime() -start_3;
		
		long start_4 = System.nanoTime();
		int sum3 = arraylist_max(sparse)[0];
		int sum4 = arraylist_max(sparse)[1];
		long sparse_max_time = System.nanoTime() -start_4;
		
		System.out.print("createDenseArray() length: ");
		System.out.print(array_length);
		System.out.print(" time: ");
	    System.out.println(dense_time);
	  		    
	    System.out.print("createSparseArray() length: ");
		System.out.print(sparse.size());
		System.out.print(" time: ");
	    System.out.println(sparse_time);
	    
	    System.out.print("findMax (array): ");
	    System.out.print(sum1);
	    System.out.print(" at: ");
	    System.out.println(sum2);
		System.out.print("dense findMax() time: ");
		System.out.println(array_max_time);
		
		System.out.print("findMax (list): ");
		System.out.print(sum3);
		System.out.print(" at: ");
		System.out.println(sum4);
		System.out.print("sparse findMax() time: ");
		System.out.println(sparse_max_time);
	}
	
	public static int[] createDenseArray(int array_length, double density){
		//Part 2
		
		int[] list1 = new int[array_length];
		for (int i =0; i < array_length; i++){
			double random = Math.random();
			if (random<density){
				Random randomnum = new Random();
				
				list1[i] = randomnum.nextInt(1000000);
			}
			else {
				list1[i] = 0;
			}
		}
		return list1;
	}
	
	public static ArrayList<Integer> createSparseArray(int array_length, double density){
		//Part 3
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		for (int i =0; i < array_length; i++){
			Random randomnum = new Random();
			double random = Math.random();
			if (random<density){
				list2.add(randomnum.nextInt(1000000));
			}
		}
		return list2;
	}

	public static int[] array_max(int[] dense){
		//Part 4
		
		int[] list1 = new int[2];
		int max = 0;
		int max_index=0;
		for (int i =0; i < dense.length; i++){
			if (dense[i]>max){
				max = dense[i];
				max_index = i;
			}
		list1[0]=max;
		list1[1]=max_index;
		}
		return list1;
	}
	
	public static int[] arraylist_max(ArrayList<Integer> sparse){
		//Part 5
		
		int[] list2 = new int[2];
		int max =0;
		int max_index=0;
		for (int i =0; i <sparse.size(); i++){
			if (sparse.get(i)>max){
				max = sparse.get(i);
				max_index = i;
			}
		list2[0]=max;
		list2[1]=max_index;
		}
		return list2;
	}
}