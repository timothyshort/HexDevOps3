package basics;

public class Playground {

	public static void main(String[] args) {
		arrayAndLoopsDemo();
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