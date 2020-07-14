package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import core.Base;
import pageObj.CreateAccPageObjForSmokeTest;
 
import utilities.DriverUtility;
import utilities.ExcelUtility;


@Listeners(utilities.TestNGListeners.class)

public class TestNGSmoke extends Base {
	
	
	 
	CreateAccPageObjForSmokeTest  createAccPageObjForST;
	
	@BeforeMethod
	public void beforeMethod() {
		Base.initializeDriver();
		logger.info("Browser opened successfully");

	}
	//invocationCount = 5
	@Test(dataProvider ="getInfoData")
	public void createAccount(String email, String title, String firstname, String lastname, String password, String day,
			String month, String year) {
		 
		createAccPageObjForST = new CreateAccPageObjForSmokeTest();
		SoftAssert softAssert = new SoftAssert();
		
		
		createAccPageObjForST.clickonSignIn();
		logger.info("User click on sign in");
		
		softAssert.assertTrue(createAccPageObjForST.isCreateEmailAddressDisplayed());
		DriverUtility.screenShot();
		
		createAccPageObjForST.enterCreateEmail(email);
		logger.info("User enter email");
		
		createAccPageObjForST.clickOnCreateAnAccount();
		logger.info("User click on create Account");
		
		softAssert.assertTrue(createAccPageObjForST.isPersonalInfoPageDisplayed());
		DriverUtility.screenShot();
		createAccPageObjForST.selectTitle(title);
		logger.info("User click on tilte");
		createAccPageObjForST.fillPersonalInformation(firstname, lastname, password, email);
		logger.info("User enter first , last name....");
		createAccPageObjForST.dateOFBirthInfo(day.substring(0, 1), month.substring(0, 1), year.substring(0, 4));
		logger.info("User select date of birth");
		
		softAssert.assertTrue(createAccPageObjForST.isRegisterButtonDisplayed());
		DriverUtility.screenShot();
		createAccPageObjForST.registerAccount();
		logger.info("User click on register");
		
		softAssert.assertAll();
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
