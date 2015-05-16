//Ian Garrett, igarrett@uoregon.edu
import java.util.HashSet;
import java.util.Set;
public class Main {
	public static void main(String[] strArray) {
		//Testing for OccurrenceSet with strings
		System.out.println("    OcurrenceSet.java TEST");
		System.out.println("");
		System.out.println("--------------------------------");
		System.out.println("	String tests");
		System.out.println("--------------------------------");
		OccurrenceSet<String> stringSet = new OccurrenceSet<String>();
		stringSet.add("hello");
		stringSet.add("hello");
		stringSet.add("world");
		stringSet.add("world");
		stringSet.add("world");
		stringSet.add("here");
		stringSet.add("I");
		stringSet.add("am");
		System.out.println("	initial results");
		System.out.println(stringSet);
		System.out.println("--------------------------------");
		
		//extra tests
		
		//Initial isEmpty() test
				System.out.println("	isEmpty()");
				System.out.println(stringSet.isEmpty());
		
		//addAll test
		System.out.println("	addAll test");
		Set<String> testA = new HashSet<String>();
		testA.add("I");
		testA.add("am");
		Set<String> testB = new HashSet<String>();
		testB.add("a");
		testB.add("computer");
		testB.add("man");
		System.out.println("	addAll ('I', 'am')");
		stringSet.addAll(testA);
		System.out.println(stringSet);
		stringSet.addAll(testB);
		System.out.println("	addAll ('a', 'computer', 'man')");
		System.out.println(stringSet);
		
		//remove and remove all test
		System.out.println("	remove ('computer')");
		stringSet.remove("computer");
		System.out.println(stringSet);
		System.out.println("	removeAll ('a', 'man')");
		stringSet.removeAll(testB);
		System.out.println(stringSet);
		
		//contains and containsAll tests
		System.out.println("	contains and contains all test");
		System.out.println(stringSet);
		System.out.println("	contains 'I'");
		System.out.println(stringSet.contains(new String("I")));
		System.out.println("	contains 'Mars'");
		System.out.println(stringSet.contains(new String("Mars")));
		System.out.println(stringSet);
		System.out.println("	containsAll ('I', 'am')");
		System.out.println(stringSet.containsAll(testA));
		System.out.println("	containsAll ('a', 'computer', 'man')");
		System.out.println(stringSet.containsAll(testB));
		
		//retains all tests
		System.out.println("	retainsAll test");
		System.out.println(stringSet);
		System.out.println("	retainsAll ('am', 'I')");
		System.out.println(stringSet.retainAll(testA));
		System.out.println(stringSet);
		
		//clear and isEmpty() tests
		System.out.println("	clear and isEmpty tests");
		System.out.println("	clear()");
		stringSet.clear();
		System.out.println(stringSet);
		System.out.println("	isEmpty()");
		System.out.println(stringSet.isEmpty());
		System.out.println("--------------------------------");
		
		//Testing for OccurrenceSet with integers
		
		System.out.println("	Integer tests");
		System.out.println("--------------------------------");
		OccurrenceSet<Integer> intSet = new OccurrenceSet<Integer>();
		intSet.add(1);
		intSet.add(3);
		intSet.add(5);
		intSet.add(5);
		intSet.add(3);
		intSet.add(3);
		intSet.add(3);
		intSet.add(2);
		System.out.println("	initial results");
		System.out.println(intSet);
		System.out.println("--------------------------------");
		
		//extra tests
		
		//Initial isEmpty() test
				System.out.println("	isEmpty()");
				System.out.println(intSet.isEmpty());
		
		//addAll test
		System.out.println("	addAll test");
		Set<Integer> testA2 = new HashSet<Integer>();
		testA2.add(1);
		testA2.add(2);
		Set<Integer> testB2 = new HashSet<Integer>();
		testB2.add(8);
		testB2.add(7);
		testB2.add(6);
		System.out.println("	addAll (1, 2)");
		intSet.addAll(testA2);
		System.out.println(intSet);
		intSet.addAll(testB2);
		System.out.println("	addAll (8, 7, 6)");
		System.out.println(intSet);
		
		//remove and remove all test
		System.out.println("	remove (8)");
		intSet.remove(8);
		System.out.println(intSet);
		System.out.println("	removeAll (7, 6)");
		intSet.removeAll(testB2);
		System.out.println(intSet);
		
		//contains and containsAll tests
		System.out.println(intSet);
		System.out.println("	contain and containsAll test");
		System.out.println("	contains 1");
		System.out.println(intSet.contains(new Integer(1)));
		System.out.println("	contains 16");
		System.out.println(intSet.contains(new Integer(16)));
		System.out.println(intSet);
		System.out.println("	containsAll (1, 2)");
		System.out.println(intSet.containsAll(testA2));
		System.out.println("	containsAll (8, 7, 6)");
		System.out.println(intSet.containsAll(testB2));
		
		//retainsAll test
		System.out.println("	retainsAll test");
		System.out.println(intSet);
		System.out.println("	retainsAll (1, 2)");
		System.out.println(intSet.retainAll(testA2));
		System.out.println(intSet);
		
		//clear and isEmpty() tests
		System.out.println("	clear and isEmpty tests");
		System.out.println("	clear()");
		intSet.clear();
		System.out.println(intSet);
		System.out.println("	isEmpty()");
		System.out.println(intSet.isEmpty());
		System.out.println("--------------------------------");
		System.out.println("	TEST COMPLETE");

		
	}
}
