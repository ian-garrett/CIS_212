//Ian Garrett, igarrett@uoregon.edu, CIS 212 Fall 2014
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = 0;
		Scanner input = new Scanner (System.in);
		int number = 0;
		System.out.println("Enter a positive integer (-1 to print, -2 to reset, -3 to exit)");
		try {
			number = input.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println("Input must be an integer");
			String error_var = input.next();
		}
			
		while (number != -3) {
			if (number == -1)
				System.out.println("Sum: " + total);
			else if (number == -2)
				total = 0;
			else if (number >= 0)
				total += number;
			System.out.println("Enter a positive integer (-1 to print, -2 to reset, -3 to exit)");
			try {
				number = input.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("Input must be an integer");
				String error_var = input.next();
			}
		}
		
		System.out.println("Sum: " + total);
			
	}

}
