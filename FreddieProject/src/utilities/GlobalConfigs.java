package utilities;

public class GlobalConfigs {
	
	public static final String ROOT_URL = "http://sdettraining.com/projects/";
	
	public static final String TESTDATA_DIR = "C:\\HexawareTraining\\Cohort3\\Selenium-BDD\\Workspace\\FreddieProject\\test-data\\";
	public static final String BROWSERS_DIR = "C:\\HexawareTraining\\Materials\\Software\\Selenium-BDD\\";
	public static final String SCREENSHOT_DIR = "C:\\HexawareTraining\\Cohort3\\Selenium-BDD\\Workspace\\FreddieProject\\screenshots\\";
	
	public static final String DB_PROTOCOL = "jdbc:sqlserver://";
	public static final String DB_SERVER = "sql2k801.discountasp.net";
	public static final String DB_NAME = "SQL2008_841902_tr";
	public static final String DB_USER = "SQL2008_841902_tr_user";
	public static final String DB_PASSWORD = "";
	
	public static final String DB_CONNSTRING = DB_PROTOCOL + DB_SERVER +
			";databasename=" + DB_NAME + ";username=" + DB_USER + ";password=" + DB_PASSWORD;

}
