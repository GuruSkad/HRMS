package hrms.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import hrms.qa.base.TestBase;

public class TestUtil  extends TestBase{
	
	public static final long WAIT_TIMEOUT = 20;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String TESTDATA_SHEET_PATH = "C:/Users/ArunKumar/eclipse-workspace"
			+ "/HRMS/Skad_HRMS/src/main/java/hrms/qa/TestData/TestData.xlsx";
	
	static Sheet sheet;
	static Workbook book;
	
	public static Object[][] addTestData(String sheetname) {
	    FileInputStream fis = null;
	    File file = null;
	    
	    try {
	        file = new File(TESTDATA_SHEET_PATH);
	        fis = new FileInputStream(file);
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    
	    try {
	        book = new XSSFWorkbook(fis);  // Open the workbook
	    } catch (EncryptedDocumentException | IOException e) {
	        e.printStackTrace();
	    }
	    
	    sheet = book.getSheet(sheetname);  // Get the sheet by name
	    
	    // Initialize 2D array to store the data
	    int rowCount = sheet.getPhysicalNumberOfRows();  // Number of rows
	    int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();  // Number of cells in first row
	    
	    Object data[][] = new Object[rowCount - 1][cellCount]; // Start from 1 to skip header row
	    
	    // Loop through rows and cells
	    for (int i = 1; i < rowCount; i++) {  // Start from 1 to skip the header row
	        for (int k = 0; k < cellCount; k++) {
	            Cell cell = sheet.getRow(i).getCell(k);
	            
	            if (cell == null) {
	                data[i - 1][k] = "";  // Assign empty string if the cell is null
	            } else {
	                data[i - 1][k] = cell.toString();  // Convert cell value to string
	            }
	        }
	    }
	    
	    return data;  // Return the 2D data array
	}

	
	    public static void takeScreenshotAtEndOfTest() throws IOException {
	    	
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
	}
	


}
