package siduduzo.voss.tests;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import siduduzo.voss.pages.CsvDataProviders;

public class FillOutFormPageTest extends BaseTest {
	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void fillOutForms(Map<String, String> testData) throws IOException {

		// I am reading these from the csv file -
		// src/test/resources/dataproviders/homepagetest/verifyHomePage.csv
		String testID = testData.get("testID");
		String testDescription = testData.get("testDescription");
		String homeTitle = testData.get("homeTitle");
		String firstName = testData.get("firstName");
		String firstMessage = testData.get("firstMessage");
		String cap = testData.get("cap");
		String expectedMessage = testData.get("expectedMessage");
		String expectedMCount = testData.get("expectedMCount");
		System.out.println("Starting Test Case ID " + testID + ", " + testDescription);
		fillOutFormsPage.openFormPage(homeTitle).fillFormScreenshot().fillFirstForm(firstName, firstMessage,expectedMessage).fillsecondForm(firstName, firstMessage,expectedMessage,expectedMCount);
	}

}