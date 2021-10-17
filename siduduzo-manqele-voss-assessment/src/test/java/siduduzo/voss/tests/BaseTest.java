package siduduzo.voss.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

import siduduzo.voss.pages.*;

public class BaseTest {

	
	    WebDriver driver;
	    HomePage homePage;
	    LoginPage loginPage;
	    FakePricingPage  fakePricingPage;
	    FillOutFormsPage  fillOutFormsPage;

	    @BeforeClass
	    public void classLevelSetup() {
	    	WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();
	    }
	 
	    @BeforeMethod
	    public void methodLevelSetup() {
	        homePage = new HomePage(driver);
	        loginPage = new LoginPage(driver);
	        fakePricingPage = new FakePricingPage(driver);
	        fillOutFormsPage = new FillOutFormsPage(driver);
	        
	    }
	 
		/*
		 * @AfterClass public void teardown() { driver.quit(); }
		 */
	

}
