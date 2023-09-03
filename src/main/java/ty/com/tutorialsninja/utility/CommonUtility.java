package ty.com.tutorialsninja.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CommonUtility {

	public static final int implicit_Wait_Time=20;
	public static final int implicit_PageLoad_Time=20;


	public static String generateEmailWithTimeStamp() {
		Date date=new Date();
		String correctDate = date.toString().replaceAll(" ", "_").replaceAll(":", "-");
		return "manoj"+correctDate+"@gmail.com"; 
	}

	public static String RanmdomNumber() {
		Random ran=new Random(9);
		String tenDigit = ran.toString().replaceAll("java.util.Random@", "");

		return tenDigit+"90";
	}

	public static Object[][] getTestDataFromExcel(String sheetName) {
		 
	    XSSFWorkbook workbook = null;
		File file=new File(System.getProperty("user.dir")+"\\src\\main\\java\\ty\\com\\tutorialsninja\\testdata\\TutorialsNinjaTestData.xlsx");


		try{
			FileInputStream fileExcel=new FileInputStream(file);
			workbook=new XSSFWorkbook(fileExcel);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);

		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();

		Object[][] data=new Object[rows][cols];
		for (int i = 0; i < rows; i++) {
			XSSFRow row = sheet.getRow(i+1);
			for (int j = 0; j < cols; j++) {
				XSSFCell cell = row.getCell(j);	
				CellType cellType = cell.getCellType();
				switch (cellType) {
				case STRING:
					data[i][j]=cell.getStringCellValue();
					break;

				case NUMERIC:
					data[i][j]=Integer.toString((int)cell.getNumericCellValue());
					break;

				case BOOLEAN:
					data[i][j]=cell.getBooleanCellValue();
					break;
				case BLANK:
					break;
				case ERROR:
					break;
				case FORMULA:
					break;
				case _NONE:
					break;
				default:
					break;
				}
			}
		}
		return data;
	}

	public static String captureScreenshot(WebDriver driver,String testName) {
		File srcSreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//driver should be public in in executed or methods classes or will get null pointer exception
		String screenshotDestination = System.getProperty("user.dir")+"\\screenshot\\"+testName+".png";
		
		try {
			FileHandler.copy(srcSreenShot, new File(screenshotDestination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotDestination;
	}
	
}
