package ty.com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ty.com.tutorialsninja.base.Base;

public class RegisterPage {
	WebDriver driver;

	@FindBy(name="firstname")
	private WebElement firstNameTxtField; 

	@FindBy(name="lastname")
	private WebElement lastNameTxtField;

	@FindBy(xpath="//input[@placeholder=\"E-Mail\"]")
	private WebElement emailTxtField;

	@FindBy(xpath="//input[@id=\"input-telephone\"]")
	private WebElement telephoneTxtField;

	@FindBy(xpath="//input[@id=\"input-password\"]")
	private WebElement passwordTxtField;

	@FindBy(xpath="//input[@id=\"input-confirm\"]")
	private WebElement confirmPasswordTxtField;

	@FindBy(xpath="//input[@type=\"checkbox\"]")
	private WebElement checkBoxField;

	@FindBy(xpath="//input[@type=\"submit\"]")
	private WebElement submitBtn;

	@FindBy(xpath="//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")
	private WebElement subscribe;

	@FindBy(xpath="//div[@class=\"alert alert-danger alert-dismissible\"]")
	private WebElement actualExistingEmailMessage;


	@FindBy(xpath="//div[@class=\"alert alert-danger alert-dismissible\"]")
	private WebElement actualPrivacyPolicyWarningMessage;


	@FindBy(xpath="//input[@id=\"input-firstname\"]/following-sibling::div")
	private WebElement actualFirstNameWarningMessage;


	@FindBy(xpath="//input[@id=\"input-lastname\"]/following-sibling::div")
	private WebElement actualLastNameWarningMessage;


	@FindBy(xpath="//input[@id=\"input-email\"]/following-sibling::div")
	private WebElement actualEmailWarningMessage;

	@FindBy(xpath="//input[@id=\"input-telephone\"]/following-sibling::div")
	private WebElement actualTelephoneWarningMessage;

	@FindBy(xpath="//input[@id=\"input-password\"]/following-sibling::div")
	private WebElement actualPasswordWarningMessage;

	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	//Action
	public void enterFirstName(String firstName) {
		firstNameTxtField.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameTxtField.sendKeys(lastName);
	}
	public void enterEmailAddress(String email) {
		emailTxtField.sendKeys(email);
	}
	public void enterTelephoneNumber(String telephonenumber) {
		telephoneTxtField.sendKeys(telephonenumber);
	}
	public void enterPassword(String password) {
		passwordTxtField.sendKeys(password);
	}
	public void enterConfirmPassword(String confirmPassword) {
		confirmPasswordTxtField.sendKeys(confirmPassword);
	}
	public void clkOncheckBoxField() {
		checkBoxField.click();
	}
	public AccountSuccessPage clkOnSubmitBtn() {
		submitBtn.click();
		return new AccountSuccessPage(driver);
	}

	public void clkOnSubScribe() {
		subscribe.click();
	}

	public String actualExistingEmailMessage() {
		String actualExistingEmailMessages = actualExistingEmailMessage.getText();
		return actualExistingEmailMessages;
	}

	public String actualPrivacyPolicyWarningMessage() {
		String actualPrivacyPolicyWarningMessages = actualPrivacyPolicyWarningMessage.getText();
		return actualPrivacyPolicyWarningMessages;
	}
	public String actualFirstNameWarningMessage() {
		String actualFirstNameWarningMessages = actualFirstNameWarningMessage.getText();
		return actualFirstNameWarningMessages;
	}
	public String actualLastNameWarningMessage() {
		String actualLastNameWarningMessages = actualLastNameWarningMessage.getText();
		return actualLastNameWarningMessages;
	}
	public String actualEmailWarningMessage() {
		String actualEmailWarningMessages = actualEmailWarningMessage.getText();
		return actualEmailWarningMessages;
	}
	public String actualTelephoneWarningMessage() {
		String actualTelephoneWarningMessages = actualTelephoneWarningMessage.getText();
		return actualTelephoneWarningMessages;
	}
	public String actualPasswordWarningMessage() {
		String actualPasswordWarningMessages = actualPasswordWarningMessage.getText();
		return actualPasswordWarningMessages;
	}

	public AccountSuccessPage registerWithMandatoryDetails(String firstName,String lastName,String email,String telephonenumber,String password,String confirmPassword ) {
		firstNameTxtField.sendKeys(firstName);
		lastNameTxtField.sendKeys(lastName);
		emailTxtField.sendKeys(email);
		telephoneTxtField.sendKeys(telephonenumber);
		passwordTxtField.sendKeys(password);
		confirmPasswordTxtField.sendKeys(confirmPassword);
		checkBoxField.click();
		submitBtn.click();
		return new AccountSuccessPage(driver);	
	}
	
	public AccountSuccessPage registerWithAllFields(String firstName,String lastName,String email,String telephonenumber,String password,String confirmPassword ) {
		firstNameTxtField.sendKeys(firstName);
		lastNameTxtField.sendKeys(lastName);
		emailTxtField.sendKeys(email);
		telephoneTxtField.sendKeys(telephonenumber);
		passwordTxtField.sendKeys(password);
		confirmPasswordTxtField.sendKeys(confirmPassword);
		subscribe.click();
		checkBoxField.click();
		submitBtn.click();
		return new AccountSuccessPage(driver);	
	}
	public void registerAccountWithExistingAccountDetails(String firstName,String lastName,String email,String telephonenumber,String password,String confirmPassword ) {
		firstNameTxtField.sendKeys(firstName);
		lastNameTxtField.sendKeys(lastName);
		emailTxtField.sendKeys(email);
		telephoneTxtField.sendKeys(telephonenumber);
		passwordTxtField.sendKeys(password);
		confirmPasswordTxtField.sendKeys(confirmPassword);
		checkBoxField.click();
		submitBtn.click();
	}
	
	public void validationsdisplayedformandatoruDetailsNotProvided() {
        
		Assert.assertEquals(actualPrivacyPolicyWarningMessage(), Base.dataProp.getProperty("expectedPrivacyPolicyWarningMessage"),"PrivacyPolicyWarningMessage is not displayed");
        
        Assert.assertEquals(actualFirstNameWarningMessage(), Base.dataProp.getProperty("expectedFirstNameWarningMessage"),"actualFirstNameWarningMessage is not displayed");
        
        Assert.assertEquals(actualLastNameWarningMessage(), Base.dataProp.getProperty("expectedLastNameWarningMessage"),"actualLastNameWarningMessage is not displayed");
        
        Assert.assertEquals(actualEmailWarningMessage(), Base.dataProp.getProperty("expectedEmailWarningMessage"),"actualEmailWarningMessage is not displayed");
        
        Assert.assertEquals(actualTelephoneWarningMessage(), Base.dataProp.getProperty("expectedTelephoneWarningMessage"),"actualTelephoneWarningMessage is not displayed");
        
        Assert.assertEquals(actualPasswordWarningMessage(), Base.dataProp.getProperty("expectedPasswordWarningMessage"),"actualPasswordWarningMessage is not displayed");
	}

}
