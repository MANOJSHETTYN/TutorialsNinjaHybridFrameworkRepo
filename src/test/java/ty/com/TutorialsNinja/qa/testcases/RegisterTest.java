package ty.com.TutorialsNinja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ty.com.tutorialsninja.base.Base;
import ty.com.tutorialsninja.pages.AccountSuccessPage;
import ty.com.tutorialsninja.pages.Homepage;
import ty.com.tutorialsninja.pages.RegisterPage;
import ty.com.tutorialsninja.utility.CommonUtility;

public class RegisterTest extends Base{
	public WebDriver driver;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccesspage;
	
	public RegisterTest() {
		super();
	}
	
	@BeforeMethod
	public void startUp() {
		driver=initializeBrowserOpenApplicationUrl(prop.getProperty("BrowserName"));
		Homepage homePage=new Homepage(driver);
		registerPage=homePage.navigateToRegisterPage();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void validateRegisterAnAccountByMandatoryDetails() {
		
		accountSuccesspage=registerPage.registerWithMandatoryDetails(dataProp.getProperty("firstName"), dataProp.getProperty("lastname"), CommonUtility.generateEmailWithTimeStamp(), CommonUtility.RanmdomNumber(), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
        Assert.assertEquals(accountSuccesspage.actualAccountCreatedMessage(), dataProp.getProperty("expectedAccountCreatedMessage"), "Account is not created");
	}
	
	@Test(priority = 2)
	public void verifyRegisteringAccountByprovidingAllFields() {
		accountSuccesspage=registerPage.registerWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastname"), CommonUtility.generateEmailWithTimeStamp(), CommonUtility.RanmdomNumber(), prop.getProperty("validPassword"), prop.getProperty("validPassword"));        
        Assert.assertEquals(accountSuccesspage.actualAccountCreatedMessage(),dataProp.getProperty("expectedAccountCreatedMessage") , "Account is not created");
	}
	
	@Test(priority = 3)
	public void verifyRegisteringAccountByExistingAccountDetails() {
		registerPage.registerAccountWithExistingAccountDetails(dataProp.getProperty("firstName"), dataProp.getProperty("lastname"), dataProp.getProperty("existingAccountEmail"), CommonUtility.RanmdomNumber(), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertEquals(registerPage.actualExistingEmailMessage(), dataProp.getProperty("expectedExistingEmailMessage"), "Account created with existing Email");
	}
	
	@Test(priority = 4)
	public void verifyNotificationMessagesDisplayedForMandatoryFieldsDonProvideAnyFieldsInRegisterPageSubmit() {
		
		registerPage.clkOnSubmitBtn(); 
		registerPage.validationsdisplayedformandatoruDetailsNotProvided();
	}
}
