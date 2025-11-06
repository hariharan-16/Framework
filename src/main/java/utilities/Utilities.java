package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIMEOUT = 5;
	
	public static String invalidEmail() {
		Date date = new Date();
		return "harioz1515"+date.toString().replace(" ", "_").replace(":", "_");
	}
	
	public static String invalidPassword() {
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "_");
	}
	
	public static Object[][] getDataFromExcel(String sheetName) throws IOException{
		FileInputStream file = new FileInputStream("src/main/resources/testData/testData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		// HDD from excel file
		Object [][] data = new Object[rows][cols];
		for(int i=0; i<rows;i++) {
			XSSFRow row = sheet.getRow(i+1);
			for(int j=0; j<cols; j++) {
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				switch (cellType) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}
			}
		}
		
		return data;
	}
	
	public static String getScreenshot(WebDriver driver, String name) throws IOException {
		TakesScreenshot ss = (TakesScreenshot)driver;
		File temp = ss.getScreenshotAs(OutputType.FILE);
		File perm = new File("screenshot/"+name+".png");
		FileHandler.copy(temp, perm);
		
		return "screenshot/"+name+".png";
	}
}
