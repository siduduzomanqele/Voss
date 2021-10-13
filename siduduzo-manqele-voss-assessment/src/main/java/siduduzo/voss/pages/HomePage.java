package siduduzo.voss.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class HomePage extends BasePage {
	String url = "https://ultimateqa.com/automation/";

	private By pageTitle = By.id("Automation_Practice");

	
	

	public HomePage(WebDriver driver) {
		super(driver);

	}

    public HomePage takeHomeScreenShot() throws IOException {
        waitVisibility(pageTitle);
        screenShot.takeSnapshot("Home_Screen");

        return this;
    }

	public HomePage openHomePage() {
		driver.get(url);
		driver.manage().window().maximize();
		return this;
	}

	public HomePage verifyTitle(String text) {
		String title = readText(pageTitle);
		Assert.assertTrue(title.equals(text));

		return this;

	}

}
