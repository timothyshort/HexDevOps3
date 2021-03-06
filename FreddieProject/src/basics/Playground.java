package basics;

import java.io.File;

public class Playground {

	public static void main(String[] args) {
		// arrayAndLoopsDemo();
		exceptionsDemo();
		// forEachDemo();
	}
	
	static void forEachDemo() {
		System.out.println("FOR EACH DEMO\n");
		
		String[] cities = {"New York", "Chicago", "San Fransisco", "Dallas", "Denver" };
		//for (int i=0; i< cities.length; i++) {
		//	System.out.println(cities[i]);
		//}
		
		for (String city : cities) {
			System.out.println(city);
		}
	}
	
	static void exceptionsDemo() {
		System.out.println("Exceptions...");
		int a=5;
		int b=0;
		
		try {
			int d = a/b;
			System.out.println(d);
		} catch (ArithmeticException err) {
			// System.out.println("Cannot divide by zero");
			
			// Show message in English terms
			System.out.println(err.getMessage());
			
			// Show exception and message
			System.out.println(err.toString());
			
			// Show the stack strace
			err.printStackTrace();
		} 
		
		/* String[] cities = {"New York", "Miami" };	
		try {
			System.out.println(cities[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index out of bounds");
		} catch (Exception e) {
			System.out.println("Error");
		} finally {
			System.out.println("This block always gets executed");
		}
		
		/*
		try {
		// open the file >> file does not exist?
		// read the file >> document not readable?
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} finally {
			// close the file
		}
		*/
		
		
		// String[] companies = { "Apple", "Google", "Netflix" };
		// System.out.println(companies[3]);
		
		System.out.println("Closing program");
	}
	
	static void arrayAndLoopsDemo() {
		System.out.println("This is the array demo");
		String[] cities = { "Reston", "Atlanta", "Pittsburgh" };
		
		int numberOfCities = cities.length;
		System.out.println("There are " + numberOfCities + " cities.");
		
		// initialize counter
		int counter = 0;
		do {
			// execute code
			// System.out.println(cities[counter]);
			
			// increment counter
			counter = counter+1;
		// loop condition
		} while (counter < numberOfCities);
		
		cities[2] = "Chicago";
		
		// for-loop
		System.out.println("***FOR LOOP***");
		for (int i=0; i<numberOfCities; i++) {
			System.out.println(cities[i]);
		}
	}

}
