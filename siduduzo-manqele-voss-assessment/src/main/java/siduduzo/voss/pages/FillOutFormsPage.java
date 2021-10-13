package siduduzo.voss.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

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

	public FillOutFormsPage fillFirstForm(String firstName, String firstmessage) {
		waitVisibility(message_one);
		//click(submitButton);
		typeText(name_one, firstName);
		typeText(message_one, firstmessage);
		click(submitButton);
		
		return this;

	}
	
	public FillOutFormsPage fillsecondForm(String firstName, String firstmessage, String cap) {
		waitVisibility(message_two);
		//click(submitButton);
		typeText(name_two, firstName);
		typeText(message_two, firstmessage);
		/*
		 * Float num1 = Float.parseFloat(js.executeScript(
		 * "document.getElementsByTagName('input')[7].getAttribute('data-first_digit');"
		 * ).toString()); Float num2 = Float.parseFloat(js.executeScript(
		 * "document.getElementsByTagName('input')[7].getAttribute('data-second_digit');"
		 * ).toString()); Float total = num1 + num2;
		 */
		typeText(captcha, cap);
		click(submitButton);
		
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

}