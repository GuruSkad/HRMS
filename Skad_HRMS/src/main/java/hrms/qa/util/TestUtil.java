package hrms.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import hrms.qa.base.TestBase;

public class TestUtil  extends TestBase{
	
	public static final long WAIT_TIMEOUT = 30;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String TESTDATA_SHEET_PATH = "C:/Users/ArunKumar/eclipse-workspace"
			+ "/HRMS/Skad_HRMS/src/main/java/hrms/qa/TestData/TestData.xlsx";
			
	static Sheet sheet;
	static Workbook book;
	
	public static Object[][] addTestData(String sheetname) {
		FileInputStream fis = null;
		File file;
		
			try {
				file = new File(TESTDATA_SHEET_PATH);
				fis = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
			try {
				book = new XSSFWorkbook(fis);
			} catch (EncryptedDocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			
			sheet = book.getSheet(sheetname);
			
			
			Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(i).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					
				}
			}
			return data;
		}
	


}
