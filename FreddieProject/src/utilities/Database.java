package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	// returns data from a SQL Server DB
	public static String[][] getSQLServer(String query) throws Exception {
		System.out.println("Connecting to SQL Server database");
		String[][] data = null;
		
		// Write the connection string
		String databaseProtocol = "jdbc:sqlserver://";
		String databaseServer = "sql2k801.discountasp.net";
		String databaseName = "SQL2008_841902_tr";
		String databaseUsername = "SQL2008_841902_tr_user";
		
		System.out.println(GlobalConfigs.DB_CONNSTRING);
		Connection oConn = null;
		try {
			// 1. Connect to the database
			oConn = DriverManager.getConnection(GlobalConfigs.DB_CONNSTRING);
			System.out.println("---Connection success---");
		
		
		// 2. Prepare the Statement
		Statement oStatement = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		// 3. Return Result from Query
		ResultSet oResult = oStatement.executeQuery(query);
		
		// Define data structure size based on ResultSet
		oResult.last();
		int numRows = oResult.getRow();
		int numCols = findNumberOfColumns(oResult);
		// int numCols = oResult.getMetaData().getColumnCount();
		System.out.println("RESULT SET: " + numRows + "x" + numCols);
		data = new String[numRows][numCols];
		
		// 3. Iterate through result set
		oResult.beforeFirst();
		int row=0;
		while (oResult.next()) {
			for (int i=1; i<=numCols; i++) {
				// Pass data into local data structure
				data[row][i-1] = oResult.getString(i);
			}
			row++;
		}	
		
		} catch (SQLException e) {
			System.out.println("ERROR" + e.toString());
		}
			
		// 4. Close the connection
		finally {
			System.out.println("Closing the connection");
			if (!oConn.isClosed()) {
				oConn.close();
			}
		}
		
		return data;
	}
	
	// Finds the number of columns in a result set
	private static int findNumberOfColumns(ResultSet oResult) {
		int numCols = 0;
		while (1 !=0 ) {
			numCols++;
			try {
				oResult.getString(numCols+1);
			} catch (SQLException e) {
				break;
			}
		}
		return numCols;
	}

}
