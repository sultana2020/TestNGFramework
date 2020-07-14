package pageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.DriverUtility;

public class CreateAccPageObjForSmokeTest extends Base {
	
	public CreateAccPageObjForSmokeTest() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//span[@class='hide_xs']")
	private WebElement signIn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='email_create']")
	private WebElement createEmailAddress;

	@FindBy(how = How.XPATH, using = "//form[@id='create-account_form']//span[1]")
	private WebElement createAnAccount;
	
	@FindBy(how = How.XPATH, using = "//form[@id='account-creation_form']")
	private WebElement AccountCreationForm;
 
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

	 
	public void clickonSignIn() {
		signIn.click();
	}
	
	public boolean isCreateEmailAddressDisplayed() {
		boolean displayed = DriverUtility.isElementDisplayed(createEmailAddress);

		return displayed;
	}
	public void enterCreateEmail(String email) {
		createEmailAddress.sendKeys(email);
	}
	
	public void clickOnCreateAnAccount() {
		createAnAccount.click();
	}

	public boolean isPersonalInfoPageDisplayed() {
		boolean displayed = DriverUtility.isElementDisplayed(AccountCreationForm);

		return displayed;
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
	
	public boolean isRegisterButtonDisplayed() {
		boolean displayed = DriverUtility.isElementDisplayed(registerButton);

		return displayed;
	}
	
	public void registerAccount() {
		signUpforNews.click();
		receiveSpecialOffers.click();
		registerButton.click();
		
	}
	

}
