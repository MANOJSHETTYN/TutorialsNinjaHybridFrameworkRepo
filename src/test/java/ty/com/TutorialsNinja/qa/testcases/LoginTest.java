package ty.com.TutorialsNinja.qa.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ty.com.tutorialsninja.base.Base;
import ty.com.tutorialsninja.pages.AccountPage;
import ty.com.tutorialsninja.pages.Homepage;
import ty.com.tutorialsninja.pages.LoginPage;
import ty.com.tutorialsninja.utility.CommonUtility;

public class LoginTest extends Base{
   LoginPage loginPage;
	
	public WebDriver driver;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void startUp() {
		driver=initializeBrowserOpenApplicationUrl(prop.getProperty("BrowserName"));
		Homepage homepage=new Homepage(driver);
		loginPage=homepage.navigateToLoginPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1,dataProvider = "VerifyLoginWithValidCredentials")
	public void verifyLoginWithValidCredentials(String email, String Password){

		AccountPage accountPage = loginPage.login(email, Password);
		Assert.assertTrue(accountPage.myAccountPageLoginSuccessfull(),"enter the correct information");
	}
	
	
	@DataProvider(name="VerifyLoginWithValidCredentials")
	public Object[][] loadTestData() {
		Object[][] data = CommonUtility.getTestDataFromExcel("Login");
		return data;
	}


	@Test(priority = 2)
	public void verifyLoginWithiInValidCredentialsInvalidEmilInvalidPassword() {
		
		loginPage.login(CommonUtility.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.actualWarningMessage().contains(dataProp.getProperty("expectedWarningMessage")),"Expected warning message is not displayed");
	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidEmilValidPassword() {
		
		loginPage.login(CommonUtility.generateEmailWithTimeStamp(), prop.getProperty("validPassword"));
		Assert.assertEquals(loginPage.actualWarningMessage(), dataProp.getProperty("expectedWarningMessage"),"Expected warning message is not displayed");
	}

	@Test(priority = 4)
	public void verifyLoginWithValidEmailAddressInvalidPassword() {
		
		loginPage.login(CommonUtility.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertEquals(loginPage.actualWarningMessage(), dataProp.getProperty("expectedWarningMessage"),"Expected warning message is not displayed");

	}

	@Test(priority = 5)
	public void verifyLoginWithoutProvidingCredentials() {
		
        loginPage.clkOnLoginBtn();
		Assert.assertEquals(loginPage.actualWarningMessage(), dataProp.getProperty("expectedWarningMessage"),"Expected warning message is not displayed");

	}

}
