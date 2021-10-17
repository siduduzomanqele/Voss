package siduduzo.voss.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FakePricingPage extends BasePage {
	String loginurl = "https://ultimateqa.com/automation/";

	private By searchTextBox = By.className("et_pb_menu_page_id-216155");
	private By basicButton = By.className("et_pb_pricing_table_button");
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public FakePricingPage(WebDriver driver) {
		super(driver);

	}

	public FakePricingPage takePurchaseScreenShot() throws IOException {
		waitVisibility(searchTextBox);
		screenShot.takeSnapshot("Purchase_Screen");

		return this;
	}

	public FakePricingPage purchaseBasicPackage() {
		waitVisibility(basicButton);
		WebElement m = driver.findElement(By.xpath("//a[@href='#top'][1]"));
		m.click();
		return this;

	}

	public FakePricingPage openFakerPage(String homeTitle) {
		driver.get(loginurl);
		driver.manage().window().maximize();
		HomePage page = new HomePage(driver);
		page.verifyTitle(homeTitle);
		js.executeScript("document.getElementsByClassName('et_pb_text_inner')[0].getElementsByTagName('a')[2].click();");

		return this;
	}

}