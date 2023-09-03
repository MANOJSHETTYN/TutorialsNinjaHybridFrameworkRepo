package ty.com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	
	//Locators or objects
	@FindBy(xpath="//input[@name=\"search\"]")
	private WebElement searchField;
	
	@FindBy(xpath="//div[@id=\"search\"]/descendant::button")
	private WebElement searchBtn;
	
	@FindBy(linkText="HP LP3065")
	private WebElement actualProductDisplayed;
	
	@FindBy(xpath="//input[@id=\"button-search\"]/following-sibling::p")
	private WebElement actualProductDisplayedForNonExistingProductAndWithoutProvidingAnyProducts;
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void enterSearchField(String products) {
		searchField.sendKeys(products);
	}
	
	public void clkOnSearchBtn() {
		searchBtn.click();
	}
	
	public void searchProduct(String products) {
		searchField.sendKeys(products);
		searchBtn.click();

	}
	
	
	public boolean actualProductDisplayed() {
		boolean actualProductDisplays = actualProductDisplayed.isDisplayed();
		return actualProductDisplays;
	}
	
	public String actualProductDisplayedForNonExistingProductAndWithoutProvidingAnyProducts() {
		String actualProductDisplayedForNonExistingProductAndWithoutProvidingAnyProduct = actualProductDisplayedForNonExistingProductAndWithoutProvidingAnyProducts.getText();
		return actualProductDisplayedForNonExistingProductAndWithoutProvidingAnyProduct;
	}
	
}
