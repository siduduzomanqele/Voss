package siduduzo.voss.tests;

import java.io.IOException;
import java.util.Map;
import org.testng.annotations.Test;

import siduduzo.voss.pages.*;

public class HomePageTest extends BaseTest {
	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void verifyHomePage(Map<String, String> testData) throws IOException {

		// I am reading these from the csv file -
		// src/test/resources/dataproviders/homepagetest/verifyHomePage.csv
		String testID = testData.get("testID");
		String testDescription = testData.get("testDescription");
		String text = testData.get("text");

		System.out.println("Starting Test Case ID " + testID + ", " + testDescription);
		homePage.openHomePage().takeHomeScreenShot().verifyTitle(text);
	}

}
