package pageObj;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.DriverUtility;

public class CAccSmokePObj extends Base {
 
		public CAccSmokePObj() {
			PageFactory.initElements(driver, this);
		}

		@FindBy(how = How.XPATH, using = "//input[@id='email_create']")
		private WebElement createEmailAddress;

		@FindBy(how = How.XPATH, using = "//form[@id='create-account_form']//span[1]")
		private WebElement createAnAccount;

		@FindBy(how = How.XPATH, using = "//input[@id='id_gender2']")
		private WebElement mrsTitle;

		@FindBy(how = How.XPATH, using = "//input[@id='id_gender1']")
		private WebElement mrTitle;

		@FindBy(how = How.XPATH, using = "//input[@id='customer_firstname']")
		private WebElement firstName;

		@FindBy(how = How.XPATH, using = "//input[@id='customer_lastname']")
		private WebElement lastName;

		@FindBy(how = How.XPATH, using = "//input[@id='email']")
		private WebElement email;

		@FindBy(how = How.XPATH, using = "//input[@id='passwd']")
		private WebElement password;

		@FindBy(how = How.XPATH, using = "//select[@id='days']")
		private WebElement days;

		@FindBy(how = How.XPATH, using = "//select[@id='months']")
		private WebElement month;

		@FindBy(how = How.XPATH, using = "//select[@id='years']")
		private WebElement year;

		@FindBy(how = How.XPATH, using = "//input[@id='newsletter']")
		private WebElement signUpforNews;

		@FindBy(how = How.XPATH, using = "//input[@id='optin']")
		private WebElement receiveSpecialOffers;

		@FindBy(how = How.XPATH, using = "//span[contains(text(),'Register')]")
		private WebElement registerButton;

		public void enterCreateEmail(String email) {
			createEmailAddress.sendKeys(email);
		}

		public void clickOnCreateAnAccount() {
			createAnAccount.click();
		}

		public void selectTitle(String title) {

			if (title.equalsIgnoreCase("mr")) {
				mrTitle.click();
			} else
				mrsTitle.click();

		}

		public void fillPersonalInformation(String fName, String lname, String pass, String emailValue) {
			firstName.sendKeys(fName);
			lastName.sendKeys(lname);
			DriverUtility.clearText(email);
			email.sendKeys(emailValue);
			password.sendKeys(pass);

		}

		public void dateOFBirthInfo(String dayValue, String monthValue, String yearValue) {
			DriverUtility.SelectByValue(days, dayValue);
			DriverUtility.SelectByValue(month, monthValue);
			DriverUtility.SelectByValue(year, yearValue);

		}
		
		public void registerAccount() {
			signUpforNews.click();
			receiveSpecialOffers.click();
			registerButton.click();
			
		}
		
		public boolean createEmailAddressisPresent() {
			 boolean emailPresent = DriverUtility.isElementDisplayed(createEmailAddress);
			  return emailPresent;
		}
		
		public boolean createAnAccountisPresent() {
			 boolean createAnAccountPresent = DriverUtility.isElementDisplayed(createAnAccount);
			  return createAnAccountPresent;
		}
		
		public boolean mrsTitleisPresent() {
			 boolean mrsTitlePresent = DriverUtility.isElementDisplayed(mrsTitle);
			  return mrsTitlePresent;
		}
		public boolean mrTitleisPresent() {
			 boolean mrTitlePresent = DriverUtility.isElementDisplayed(mrTitle);
			  return mrTitlePresent;
		}
		public boolean firstNameisPresent() {
			 boolean firstNamePresent = DriverUtility.isElementDisplayed(firstName);
			  return firstNamePresent;
		}
		public boolean lastNameisPresent() {
			 boolean lastNamePresent = DriverUtility.isElementDisplayed(lastName);
			  return lastNamePresent;
		}
		public boolean emailisPresent() {
			 boolean emailIDPresent = DriverUtility.isElementDisplayed(email);
			  return emailIDPresent;
		}
		public boolean passwordisPresent() {
			 boolean passwordPresent = DriverUtility.isElementDisplayed(password);
			  return passwordPresent;
		}
		public boolean daysisPresent() {
			 boolean daysPresent = DriverUtility.isElementDisplayed(days);
			  return daysPresent;
		}
		public boolean monthisPresent() {
			 boolean monthPresent = DriverUtility.isElementDisplayed(month);
			  return monthPresent;
		}
		public boolean yearisPresent() {
			 boolean yearPresent = DriverUtility.isElementDisplayed(year);
			  return yearPresent;
		}
		public boolean signUpforNewsisPresent() {
			 boolean signUpforNewsPresent = DriverUtility.isElementDisplayed(signUpforNews);
			  return signUpforNewsPresent;
		}
		public boolean receiveSpecialOffersisPresent() {
			 boolean receiveSpecialOffersPresent = DriverUtility.isElementDisplayed(receiveSpecialOffers);
			  return receiveSpecialOffersPresent;
		}
		public boolean registerButtonisPresent() {
			 boolean registerButtonPresent = DriverUtility.isElementDisplayed(registerButton);
			  return registerButtonPresent;
		}
		
		
		
		

	}


