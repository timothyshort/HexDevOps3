package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import utilities.GlobalConfigs;

public class Readers {

	public static void main(String[] args) throws Exception {
		// List<String[]> data = utilities.CSV.get("C:\\HexawareTraining\\Cohort3\\Selenium-BDD\\Workspace\\FreddieProject\\test-data\\LoginData.txt");
		// String[][] data = utilities.Excel.get(GlobalConfigs.TESTDATA_DIR + "NewAccountData.xlsx");
		// String[][] data = utilities.Database.getSQLServer("SELECT * FROM MortgageLoanTestData");
		
		String[][] data = utilities.XML.getByXpath(GlobalConfigs.TESTDATA_DIR + "ShoppingCartData.xml");
		
		
		// Iterate dataset
		for (String[] record : data) {
			System.out.print("[ ");
			for (String field : record) {
				System.out.print(field + ", ");
			}
			System.out.println("]");
		}
		
	}
	
	static void readFile() {
		// reading CSV - comma separated value
		String filename = "C:\\HexawareTraining\\Cohort3\\Selenium-BDD\\Workspace\\FreddieProject\\test-data\\LoginData.txt";
		
		// 1. Create the file (in Java)
		File file = new File(filename);
		
		// 2. Open the file
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			// 3. Read the file
			try {
				System.out.println(br.readLine());
			} catch (IOException e) {
				System.out.println("ERROR: Could Not Read Line");
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File Not Found.");
		} finally {
			// 4. Close the file
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("Closing resource");
			}
		}
	}

}
