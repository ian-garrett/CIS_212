//Ian Garrett, Assignment5, igarrett@uoregon.edu, CIS 212 Fall 2014
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main{
	static ArrayList<Entry> data=new ArrayList<Entry>();
	static ArrayList<Entry> data1=new ArrayList<Entry>();
	static JLabel selectLabel = new JLabel(" ");
	static JLabel mergeLabel = new JLabel(" "); 
	
	//Merge begin (SOURCE: textbook assigned for this course, chapter 19)
	public static void sort(){
		data1 = new ArrayList<Entry>();
		for (int i=0; i < data.size(); i++)
			data1.add(data.get(i));
		sortArray(0, data1.size()-1);
		
		
	}
	public static void sortArray(int low, int high){
		if ((high-low) >= 1){
			int middle1 = (low + high)/2;
			int middle2 = middle1 + 1;
			
			sortArray(low, middle1);
			sortArray(middle2, high);
			
			merge(low, middle1, middle2, high);
		}
	}
	
	public static void merge(int left, int middle1, int middle2, int right){
		int leftIndex = left;
		int rightIndex = middle2;
		int combinedIndex = left;
		ArrayList<Entry> combined = new ArrayList<Entry>(data1);
		
		
		
		
		while (leftIndex <= middle1 && rightIndex <= right){
			if (data1.get(leftIndex).getName().compareTo(data1.get(rightIndex).getName()) <= 0){
				combined.set(combinedIndex++,data1.get(leftIndex++));
			}
			else{
				combined.set(combinedIndex++,data1.get(rightIndex++));
			}
		
		}
		if (leftIndex == middle2){
			while (rightIndex <= right)
				combined.set(combinedIndex++,data1.get(rightIndex++));

		}
		else{
			while (leftIndex <= middle1)
				combined.set(combinedIndex++,data1.get(leftIndex++));
		}
		
		for (int i = left; i <= right; i++)
			data1.set(i,combined.get(i));
		
		
		
	}
	//merge end
	
	//Main program, brings everything together 
	public static void main(String[] args) {
		Reader r = new Reader();
		r.readFile();
		data = r.getData(); //How do i bring this into Main above?
		
		//Create GUI
		JFrame frame = new JFrame("Assignment 5");
		frame.setLayout(new BorderLayout());
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2,2));
		frame.add(buttonPanel);
		
		//Buttons
		JButton selectButton =  new JButton("Selection Sort");
		selectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				ArrayList<Entry> sortedList;
				long selectionSort_start = System.nanoTime();
				sortedList = SelectionSorter.selectionSort(data);
				long selectionSort_time = System.nanoTime() -selectionSort_start;
				String selectionTime = String.valueOf(selectionSort_time/1000000000.0);
				if (Checker.check(sortedList))
					selectLabel.setText(selectionTime); 
				else
					selectLabel.setText("Error");
			}
		});
		
		JButton mergeButton = new JButton("Merge Sort");
		mergeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				long mergeSort_start = System.nanoTime();
				sort();
				long mergeSort_time = System.nanoTime() -mergeSort_start;
				String mergeTime = String.valueOf(mergeSort_time/1000000000.0);
				if (Checker.check(data1))
					mergeLabel.setText(mergeTime); 
				else
					mergeLabel.setText("Error");
			}
		});
	
		//Assemble GUI
		buttonPanel.add(selectButton);
		buttonPanel.add(selectLabel);
		buttonPanel.add(mergeButton);
		buttonPanel.add(mergeLabel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setVisible(true);
	}
	
	//Creates reader object and assigns it to data
	public Main(){
		Reader r = new Reader();
		r.readFile();
		data = r.getData();
		}
	
	//Shows entries, used for testing
	public static void showData(ArrayList<Entry> sortedlist){
		int current;
		for (current = 0; current < sortedlist.size(); current++){
			Entry dataLine=sortedlist.get(current);
			System.out.println(dataLine.getName());
			System.out.println(dataLine.getPhoneNumber());
		}
	}
	

	//Reader class, imports and parses data from .txt file appropriately
	public static class Reader{ 
		private ArrayList<Entry> data=new ArrayList<Entry>();
		int current=0;
		
		public void readFile(){		
		    try {
		    
		    	BufferedReader brFile = new BufferedReader(
		    			new FileReader("phoneBook.txt"));
		    	
		        String line = brFile.readLine();
		        
		        while (line != null) {
		        		String[] parts=line.split(" ");
		        		Entry entr = new Entry(parts[1]+" "+parts[2], parts[0]);
		        		getData().add(entr);
		            line = brFile.readLine();
		        }	       
		        brFile.close();
		    }
		    catch(Exception e){
		    	System.err.print("File reading error!");
		    	System.err.print(e.getMessage());
		    }
		    
		}
		

		ArrayList<Entry> getData() {
			return data;
		}
		
	}
	
	//Entry class, class of objects used to populate data array	
	public static class Entry{
		private String _name;
		private String _phoneNumber;
		
		public Entry(String name,String phoneNumber){
			_name = name;
			_phoneNumber = phoneNumber;
		}
		
		public String getName(){
			return _name;
		}
		
		public String getPhoneNumber(){
			return _phoneNumber;
		}
	}
	//Selection sort (SOURCE: textbook assigned for this course, chapter 19)
	public static class SelectionSorter{
		public static void swap(int first, int second, ArrayList<Entry> list){
			Entry temporary = list.get(first);
			list.set((first),list.get(second));
			list.set((second),temporary);
		}
		public static ArrayList<Entry> selectionSort(ArrayList<Entry> unsortedList){
			ArrayList<Entry> dataCopy=new ArrayList<Entry>(unsortedList);
			int smallest;
			for (int i = 0; i < dataCopy.size(); i++){
				smallest = i;
				for (int index = i +1; index < dataCopy.size(); index++) {
					if ((dataCopy.get(index).getName().compareTo(dataCopy.get(smallest).getName())) < 0){
						smallest = index;
					}
				}
				swap(i, smallest, dataCopy);
			}
			return dataCopy;
			
		}
	}
	
	//Checks if ArrayList<Entry> is sorted
	public static class Checker{ // 
		public static boolean check(ArrayList<Entry> sortedList){
			boolean result = true;
			int i;
			for (i=1; i < (sortedList.size()); i++){
				if ((sortedList.get(i-1).getName().compareTo(sortedList.get(i).getName()))>0){
					result = false;
				}
			}
			return result;
		}
		
	}
}