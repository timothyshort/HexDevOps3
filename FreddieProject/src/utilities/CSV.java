package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV {
	
	// reading CSV - comma separated value
	public static List<String[]> get(String filename) {
		// define data structure
		List<String[]> dataSet = new ArrayList<String[]>();
		
		// 1. Create the file (in Java)
		File file = new File(filename);
		
		try {
			// 2. Open the file
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			// 3. Read the file
			String line;
			while ((line = br.readLine()) != null) {
				// Parse by character (comma)
				String[] record = line.split(",");
				
				// Add record to data set
				dataSet.add(record);
			}
			
			// 4. Close the file
			br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File Not Found.");
		} catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		
		System.out.println("Finished Reading File. Records: " + dataSet.size());
		return dataSet;
	}

}
