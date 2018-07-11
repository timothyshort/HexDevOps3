package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSV {
	
	public static void get() {
		// reading CSV - comma separated value
		String filename = "C:\\HexawareTraining\\Cohort3\\Selenium-BDD\\Workspace\\FreddieProject\\test-data\\LoginData.txt";
		
		// 1. Create the file (in Java)
		File file = new File(filename);
		
		try {
			// 2. Open the file
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			// 3. Read the file
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			// 4. Close the file
			br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File Not Found.");
		} catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}

}
