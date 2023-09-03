package ty.com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;

	
	//Locators or objects
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropDownmenu;
	
	@FindBy(linkText = "Login")
	private WebElement loginOptionOnMyAccount;
	
	@FindBy(xpath="//ul[@class=\"dropdown-menu dropdown-menu-right\"]/li[1]/a")
	private WebElement registerOptionOnMyAccount;
	
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);//here we can write this or Homepage.class	
	}
	
	//Actions
	public void clkOnMyAccount() {
		myAccountDropDownmenu.click();
	}
	
	public LoginPage clkOnLoginBtn() {
		loginOptionOnMyAccount.click();
		return new LoginPage(driver);
	}
	
	public LoginPage navigateToLoginPage() {
		myAccountDropDownmenu.click();
		loginOptionOnMyAccount.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage clkOnRegisterBtn() {
		registerOptionOnMyAccount.click();
		return new RegisterPage(driver);
	}
	public RegisterPage navigateToRegisterPage() {
		myAccountDropDownmenu.click();
		registerOptionOnMyAccount.click();
		return new RegisterPage(driver);
	}
	
}
