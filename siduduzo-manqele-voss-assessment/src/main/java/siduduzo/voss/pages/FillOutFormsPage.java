package siduduzo.voss.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FillOutFormsPage extends BasePage {
	String loginurl = "https://ultimateqa.com/automation/";

	private By searchTextBox = By.className("et_pb_menu_page_id-216155");
	private By name_one = By.id("et_pb_contact_name_0");
	private By message_one = By.id("et_pb_contact_message_0");
	private By name_two = By.id("et_pb_contact_name_1");
	private By message_two = By.id("et_pb_contact_message_1");
	private By submitButton = By.name("et_builder_submit_button");
	private By captcha = By.name("et_pb_contact_captcha_1");
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public FillOutFormsPage(WebDriver driver) {
		super(driver);

	}

	public FillOutFormsPage fillFormScreenshot() throws IOException {
		waitVisibility(searchTextBox);
		screenShot.takeSnapshot("fillform_Screen");

		return this;
	}

	public FillOutFormsPage fillFirstForm(String firstName, String firstmessage,String expectedMessage) {
		waitVisibility(message_one);
		click(submitButton);
		typeText(name_one, firstName);
		typeText(message_one, firstmessage);
		click(submitButton);
		elementTextDisplayed(expectedMessage);
		return this;

	}
	
	public FillOutFormsPage fillsecondForm(String firstName, String firstmessage, String expectedMessage, String noOftime) {
		waitVisibility(message_two);
		typeText(name_two, firstName);
		typeText(message_two, firstmessage);
		String cap = Integer.toString(getCaptcha());
		typeText(captcha, cap);
		click(submitButton);
		
		// This is an unacceptable way of waiting for the process to complete, however the text "thanks for contacting us" already exist in this page. Therefore,
		// there is nothing else to wait for while submitting the form.
		try{
			Thread.sleep(3000);
			}
			catch(InterruptedException ie){
			}
		String noOftimes = Integer.toString(countText(expectedMessage));
		Assert.assertTrue(noOftimes.equals(noOftime));
		
		return this;

	}

	public FillOutFormsPage openFormPage(String homeTitle) {
		driver.get(loginurl);
		driver.manage().window().maximize();
		HomePage page = new HomePage(driver);
		page.verifyTitle(homeTitle);
		js.executeScript("document.getElementsByClassName('et_pb_text_inner')[0].getElementsByTagName('a')[3].click();");

		return this;
	}
	
	public int getCaptcha()
	{
		WebElement captchaText = driver.findElement(By.className("et_pb_contact_captcha_question"));
		String getCap = captchaText.getAttribute("innerHTML");
		String firstValue = getCap.split("[+]")[0];
		String secondValue = getCap.split("[+]")[1];
		String num1 = firstValue.replaceAll("\\s","");
		String num2 = secondValue.replaceAll("\\s","");
		int captcha =Integer.parseInt(num1) + Integer.parseInt(num2);
		return captcha;
		
	}
	


}