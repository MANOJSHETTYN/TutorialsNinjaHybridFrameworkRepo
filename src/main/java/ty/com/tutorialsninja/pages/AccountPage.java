package ty.com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;

	@FindBy(linkText = "Edit your account information")
	private WebElement editAccountInformation;
	
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean myAccountPageLoginSuccessfull() {
		boolean correctAccountInoformation = editAccountInformation.isDisplayed(); 
		return correctAccountInoformation;
	}
}
