package ty.com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
    
	//locators or objects
	@FindBy(xpath="//input[@name=\"email\"]")
	private WebElement emailTxtField;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	private WebElement passwordTxtField;
	
	@FindBy(xpath="//input[@value=\"Login\"]")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement actualWarningMessage;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this );
	}
	
	//Actions
	
	public void enteremailAddress(String email) {
		emailTxtField.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordTxtField.sendKeys(password);
	}
	
	public AccountPage clkOnLoginBtn() {
		loginBtn.click();
		return new AccountPage(driver);
	}
	
	public AccountPage login(String email,String password) {
		emailTxtField.sendKeys(email);
		passwordTxtField.sendKeys(password);
		loginBtn.click();
		return new AccountPage(driver);
	}
	
	public String actualWarningMessage() {
		String actualWarningMessages = actualWarningMessage.getText();
		return actualWarningMessages;
	}
	
}
