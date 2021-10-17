package siduduzo.voss.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import siduduzo.voss.commonutils.*;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	Screenshot screenShot;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 screenShot = new Screenshot(driver);

	}

	public void click(By elementLocation) {
		waitVisibility(elementLocation);
		driver.findElement(elementLocation).click();
	}

	public void typeText(By elementLocation, String text) {
		waitVisibility(elementLocation);
		driver.findElement(elementLocation).sendKeys(text);
	}

	public String readText(By elementLocation) {
		waitVisibility(elementLocation);

		return driver.findElement(elementLocation).getText();
	}

	public boolean isVisible(By elementLocation) {
		waitVisibility(elementLocation);
		if (driver.findElement(elementLocation).isDisplayed()) {
			return true;
		} else
			return false;
	}

	public void waitVisibility(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	
	public void elementTextDisplayed(String text)
	{
		
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '"+text+"')]")));
	}
	
	public int countText(String text)
	{
		
		int size = driver.findElements(By.xpath("//*[contains(text(), '"+text+"')]")).size();
		return size;
	}

}
