package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	
	public static String[][] get(String filename) {
		String[][] dataTable = null;
		
		// Create the Java file
		File file = new File(filename);
		try {
			// Create the Excel file
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook xlBook = new XSSFWorkbook(fis);
			XSSFSheet xlSheet = xlBook.getSheetAt(0);
			
			// Extract number of rows and columns
			int rows = xlSheet.getLastRowNum() + 1;
			int cols = xlSheet.getRow(0).getLastCellNum();
			System.out.println("DATASET: " + rows + "x" + cols);
			dataTable = new String[rows][cols];
			
			// Iterate excel sheet
			for (int i=0; i<rows; i++) {
				XSSFRow xlRow = xlSheet.getRow(i);
				for (int j=0; j<cols; j++) {
					XSSFCell xlCell = xlRow.getCell(j);
					// Add to dataset
					dataTable[i][j] = xlCell.toString();
				}
			}
			
			// Close the excel file
			fis.close();
			
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File Not Found\n" + e.getMessage());
		} catch (IOException e) {
			System.out.println("ERROR: Could Not Read Excel File\n" + e.getMessage());
		}
		
		return dataTable;
	}
	
	public static void getXLS() {
		// ...
	}

}
