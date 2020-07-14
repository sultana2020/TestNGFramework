package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import core.Base;
import pageObj.HotelLoginPageObj;

public class TestNGAssertionConcepts extends Base {

	HotelLoginPageObj hotelLoginPageObj;
	
	@BeforeMethod
	public void beforeMethod() {
		Base.initializeDriver();
		logger.info("Browser opened successfully");
	}
	@Test
	public void assertionTest() {
		String title = driver.getTitle();
		String expectedTitle = "Tek School Hotel website";
		// hard Assertion
		Assert.assertEquals(title, expectedTitle);
		hotelLoginPageObj = new HotelLoginPageObj();
		hotelLoginPageObj.enterEmail(Base.getUserName());
		hotelLoginPageObj.enterPassword(Base.getPassword());
		hotelLoginPageObj.clickonSignInButton();
	}
	@Test
	public void sofAssertionConcept() {
		String title = driver.getTitle();
		String expectedTitle = "Tek School Hotel website";
	// add soft Assertion 
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(title, expectedTitle);
		hotelLoginPageObj = new HotelLoginPageObj();
		hotelLoginPageObj.clickonSignIn();
		hotelLoginPageObj.enterEmail(Base.getUserName());
		hotelLoginPageObj.enterPassword(Base.getPassword());
		hotelLoginPageObj.clickonSignInButton();
		softAssert.assertAll();
	}
	@AfterMethod
	public void afterMethod() {
		Base.tearDown();
		logger.info("Browser closed");
	}
	
}
