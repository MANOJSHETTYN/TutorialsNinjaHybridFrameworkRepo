package ty.com.tutorialsninja.listners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ty.com.tutorialsninja.utility.CommonUtility;
import ty.com.tutorialsninja.utility.ExtentReporter;

public class MyListners implements ITestListener{
	ExtentReports extentReports;
	ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		extentReports = ExtentReporter.generateExtentReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName()+" Started Executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, result.getName()+" Got Successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		WebDriver driver=null;

		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		String screenshotDestination = CommonUtility.captureScreenshot(driver, result.getName());	
		extentTest.addScreenCaptureFromPath(screenshotDestination);// add screenshot to be added in reports that the reason
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName()+ "Got Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName()+" Got skipped");
	}


	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
		
		String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File fileExtentReport=new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(fileExtentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
