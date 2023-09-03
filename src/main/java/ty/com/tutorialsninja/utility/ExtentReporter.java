package ty.com.tutorialsninja.utility;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ty.com.tutorialsninja.base.Base;

public class ExtentReporter extends Base {

	
	public static ExtentReports generateExtentReport() {
	
		ExtentReports extentReport=new ExtentReports();
		File pathFile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter extentSparkReport=new ExtentSparkReporter(pathFile);
		
		extentSparkReport.config().setTheme(Theme.DARK);
		extentSparkReport.config().setReportName("TutorialsNinja test automation result");
		extentSparkReport.config().setDocumentTitle("Tutorials Ninja Automation Report");
		extentSparkReport.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(extentSparkReport);
		
		extentReport.setSystemInfo("Application URL", prop.getProperty("URL"));
		extentReport.setSystemInfo("Browser Name", prop.getProperty("BrowserName"));
		extentReport.setSystemInfo("Email", prop.getProperty("validEmail"));
		extentReport.setSystemInfo("Password", prop.getProperty("validPassword"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("User name", System.getProperty("user.name"));
		extentReport.setSystemInfo("JAVA Version", System.getProperty("java.version"));
		
		return extentReport;
	}
}
