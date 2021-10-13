package siduduzo.voss.tests;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;


import siduduzo.voss.pages.*;

public class LoginPageTest extends BaseTest {
	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void testLogin(Map<String, String> testData) throws IOException {

		// I am reading these from the csv file -
		// src/test/resources/dataproviders/LoginPageTest/testLogin.csv
		String testID = testData.get("testID");
		String testDescription = testData.get("testDescription");
		String email = testData.get("email");
		String password = testData.get("password");
		System.out.println("Starting Test Case ID " + testID + ", " + testDescription);
		loginPage.openLoginPage().takeLoginScreenShot().login(email, password).takeLoginScreenShot().logout().takeLoginScreenShot();
		
	}

}
