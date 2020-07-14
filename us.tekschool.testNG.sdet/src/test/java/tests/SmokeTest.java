package tests;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import core.Base;
import pageObj.CAccSmokePObj;
import pageObj.HotelLoginPageObj;
import utilities.ExcelUtility;

@Listeners(utilities.TestNGListeners.class)

public class SmokeTest extends Base {
	
	HotelLoginPageObj hotelpageObj;
	CAccSmokePObj cAccSmokePObj;

	@BeforeMethod
	public void beforeMethod() {
		Base.initializeDriver();
		logger.info("Browser opened successfully");

	}

	@Test(dataProvider = "getInfoData")
	public void createAccount(String email, String title, String firstname, String lastname, String password,
			String day, String month, String year) {
		hotelpageObj = new HotelLoginPageObj();
		cAccSmokePObj = new CAccSmokePObj();
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertTrue(hotelpageObj.createSignInisPresent());
		hotelpageObj.clickonSignIn();
		logger.info("User clicked on Sign in");
		
		softAssert.assertTrue(cAccSmokePObj.createEmailAddressisPresent());
		softAssert.assertTrue(cAccSmokePObj.createAnAccountisPresent());
		cAccSmokePObj.enterCreateEmail(email);
		logger.info("User entered: " + email);
		cAccSmokePObj.clickOnCreateAnAccount();
		logger.info("User clicked on Create Account");
		
		softAssert.assertTrue(cAccSmokePObj.mrsTitleisPresent());
		softAssert.assertTrue(cAccSmokePObj.mrTitleisPresent());
		cAccSmokePObj.selectTitle(title);
		logger.info("User selected Title: " + title);
		
		softAssert.assertTrue(cAccSmokePObj.firstNameisPresent());
		softAssert.assertTrue(cAccSmokePObj.lastNameisPresent());
		softAssert.assertTrue(cAccSmokePObj.emailisPresent());
		softAssert.assertTrue(cAccSmokePObj.passwordisPresent());
		cAccSmokePObj.fillPersonalInformation(firstname, lastname, password, email);
		logger.info("User filled personal information");
		
		softAssert.assertTrue(cAccSmokePObj.daysisPresent());
		softAssert.assertTrue(cAccSmokePObj.monthisPresent());
		softAssert.assertTrue(cAccSmokePObj.yearisPresent());
		cAccSmokePObj.dateOFBirthInfo(day.substring(0, 1), month.substring(0, 1), year.substring(0, 4));
		logger.info("User filled DOB information ");
		
		softAssert.assertTrue(cAccSmokePObj.signUpforNewsisPresent());
		softAssert.assertTrue(cAccSmokePObj.receiveSpecialOffersisPresent());
		softAssert.assertTrue(cAccSmokePObj.registerButtonisPresent());
		cAccSmokePObj.registerAccount();
		logger.info("User clicked on Register Account");
		
		softAssert.assertAll();

	}

	@DataProvider()
	public Object[][] getInfoData() {
		Object data[][] = ExcelUtility.getExcelData("info");
		return data;
	}

	@AfterMethod
	public void afterMethod() {
		Base.tearDown();
		logger.info("Browser closed");

	}


}
