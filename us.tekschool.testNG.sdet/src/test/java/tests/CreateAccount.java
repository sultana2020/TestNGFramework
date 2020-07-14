package tests;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import core.Base;
import pageObj.CreateAccountPageObj;
import pageObj.HotelLoginPageObj;
import utilities.ExcelUtility;


@Listeners(utilities.TestNGListeners.class)

public class CreateAccount extends Base {
	
	HotelLoginPageObj hotelpageObj;
	CreateAccountPageObj createAccountPageObj;
	
	@BeforeMethod
	public void beforeMethod() {
		Base.initializeDriver();
		logger.info("Browser opened successfully");

	}
	
	@Test(dataProvider ="getInfoData")
	public void createAccount(String email, String title, String firstname, String lastname, String password, String day,
			String month, String year) {
		hotelpageObj = new HotelLoginPageObj();
		createAccountPageObj = new CreateAccountPageObj();
		hotelpageObj.clickonSignIn();
		logger.info("User click on sign in");
		createAccountPageObj.enterCreateEmail(email);
		logger.info("User enter email");
		createAccountPageObj.clickOnCreateAnAccount();
		logger.info("User click on create Account");
		createAccountPageObj.selectTitle(title);
		logger.info("User click on tilte");
		createAccountPageObj.fillPersonalInformation(firstname, lastname, password, email);
		logger.info("User enter first , last name....");
		createAccountPageObj.dateOFBirthInfo(day.substring(0, 1), month.substring(0, 1), year.substring(0, 4));
		logger.info("User select date of birth");
		createAccountPageObj.registerAccount();
		logger.info("User click on register");
	}
	
	@DataProvider()
	public Object [][] getInfoData(){
		Object data [][] = ExcelUtility.getExcelData("info");
		return data;
	}
	
	
	@AfterMethod
	public void afterMethod() {
		Base.tearDown();
		logger.info("Browser closed");

	}

}
