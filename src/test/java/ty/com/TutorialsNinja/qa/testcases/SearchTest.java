package ty.com.TutorialsNinja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ty.com.tutorialsninja.base.Base;
import ty.com.tutorialsninja.pages.SearchPage;

public class SearchTest extends Base {
	public WebDriver driver;
	SearchPage searchPage;

	public SearchTest() {
		super();
	}

	@BeforeMethod
	public void startUp() {
		driver=initializeBrowserOpenApplicationUrl(prop.getProperty("BrowserName"));
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	@Test(priority = 1)
	public void verifySearchingWithExistingProduct() {

	    searchPage=new SearchPage(driver);
	    searchPage.searchProduct(dataProp.getProperty("ExistingProduct"));
		Assert.assertTrue(searchPage.actualProductDisplayed(),"Existing Product is not displayed");
	}

	@Test(priority = 2)
	public void verifySearchingWithNonExistingProduct() {
		
	    searchPage=new SearchPage(driver);
		searchPage.searchProduct(dataProp.getProperty("nonExistingProduct"));
		//Assert.assertEquals(searchPage.actualProductDisplayedForNonExistingProductAndWithoutProvidingAnyProducts(), "There is no product that matches the search criteria.","Message: There is no product that matches the search criteria. is not displayed");
		//Intensionally failing testcases
		Assert.assertEquals(searchPage.actualProductDisplayedForNonExistingProductAndWithoutProvidingAnyProducts(), "jackie","Message: There is no product that matches the search criteria. is not displayed");

	}

	@Test(priority = 3,dependsOnMethods = {"verifySearchingWithExistingProduct", "verifySearchingWithNonExistingProduct"})
	public void verifySearchingWithoutProvidingAnyProductName() {

		searchPage=new SearchPage(driver);
		searchPage.clkOnSearchBtn();
		Assert.assertEquals(searchPage.actualProductDisplayedForNonExistingProductAndWithoutProvidingAnyProducts(), dataProp.getProperty("expectedProductDisplayed"),"Message: There is no product that matches the search criteria. is not displayed");
	}



}
