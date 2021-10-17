package siduduzo.voss.pages;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
	String loginurl = "https://courses.ultimateqa.com/users/sign_in";


	private By pageEmail = By.id("user[email]");
	private By pagePassword = By.id("user[password]");
	private By searchTextBox = By.name("q");


	public LoginPage(WebDriver driver) {
		super(driver);

	}

	public LoginPage takeLoginScreenShot() throws IOException {
		waitVisibility(pageEmail);
		screenShot.takeSnapshot("Login_Screen");

		return this;
	}

	public LoginPage login(String email, String password) {

		typeText(pageEmail, email);
		typeText(pagePassword, password);
		WebElement m = driver.findElement(By.className("button-primary"));
		m.click();
		return this;

	}
	public LoginPage logout() {

		waitVisibility(searchTextBox);
		WebElement c = driver.findElement(By.className("dropdown__toggle-button"));
		c.click();
		WebElement m = driver.findElement(By.xpath("//a[@href='/users/sign_out']"));
		m.click();
		return this;

	}

	public LoginPage openLoginPage() {
		driver.get(loginurl);
		driver.manage().window().maximize();
		waitVisibility(pageEmail);
		return this;
	}

}