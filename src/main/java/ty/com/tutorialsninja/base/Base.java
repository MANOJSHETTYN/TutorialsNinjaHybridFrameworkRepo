package ty.com.tutorialsninja.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import ty.com.tutorialsninja.utility.CommonUtility;

public class Base {

	WebDriver driver;
	public static Properties prop;
	public static Properties dataProp;

	public Base() {
		prop=new Properties();
		File file=new File(System.getProperty("user.dir")+"\\src\\main\\java\\ty\\com\\tutorialsninja\\config\\config.properties");

		dataProp=new Properties();
		File file2=new File(System.getProperty("user.dir")+"\\src\\main\\java\\ty\\com\\tutorialsninja\\testdata\\testdata.properties");


		try {
			FileInputStream filetype=new FileInputStream(file);
			prop.load(filetype);
		} catch (Exception e) {
			e.printStackTrace();
		}


		try {
			FileInputStream fileType2=new FileInputStream(file2);
			dataProp.load(fileType2);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
	}

	public WebDriver initializeBrowserOpenApplicationUrl(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("edge")){
			driver=new EdgeDriver();
		}else if (browserName.equalsIgnoreCase("Safari")){
			driver=new SafariDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtility.implicit_Wait_Time));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtility.implicit_PageLoad_Time));
		driver.get(prop.getProperty("URL"));

		return this.driver;
	}
}
