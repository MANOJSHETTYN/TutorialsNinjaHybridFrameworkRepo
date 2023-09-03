package ty.com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
    WebDriver driver;
	
	@FindBy(xpath="//div[@id=\"content\"]/h1")
	private WebElement accountSuccessPage;

	public AccountSuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);//null pointer or stale element exception
	}
    
	public String actualAccountCreatedMessage() {
		String actualAccountCreatedMessage = accountSuccessPage.getText();
		return actualAccountCreatedMessage;
	}
	
}
