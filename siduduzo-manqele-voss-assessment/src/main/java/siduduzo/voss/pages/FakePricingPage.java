package siduduzo.voss.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class FakePricingPage extends BasePage {
	String loginurl = "https://ultimateqa.com/automation/";

	private By searchTextBox = By.className("et_pb_menu_page_id-216155");
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
		js.executeScript("document.getElementsByClassName('et_pb_column et_pb_column_1_3 et_pb_column_2')[0].getElementsByTagName('a')[0].click;");
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