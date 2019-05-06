package com.skidata.uiPages.portal;

import java.awt.AWTException;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.helperclasses.DateAndUniqueNoGenerateHelper;
import com.skidata.helperclasses.WaitHelper;
import com.skidata.testBase.TestBase;


/**
 * @author mavh
 * 
 */
public class SspSignUpPage extends TestBase {

	
	
	String status=null;


	public static final Logger log = Logger.getLogger(SspHomePage.class.getName());



	//Class constructor
	public SspSignUpPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

	}


	@FindBys({	
		@FindBy(how=How.ID, using="logo"),
	})	public List<WebElement> allElementsInList_LogoImage;

	@FindBy(how=How.XPATH,using ="//span[@translate='_SignUp_']")
	WebElement SignUpLinkInLoginPage;

	@FindBy(how=How.XPATH,using ="//h1[text()='Sign up']")
	WebElement SignUpTitle;

	@FindBy(how=How.XPATH,using ="//input[@id='email']")
	WebElement SignUpEmail;

	@FindBy(how=How.XPATH,using ="//input[@id='password']")
	WebElement SignUpPassword;

	@FindBy(how=How.XPATH,using ="//input[@id='confirmpassword']")
	WebElement SignUpConfirmPassword;

	@FindBy(how=How.XPATH,using ="//input[@id='password']/..//span")
	WebElement SignUpPasswordWarningMessage;

	@FindBy(how=How.XPATH,using ="//span[@translate='_WrongEmail_']")
	WebElement signUpEmailErrorMessage;


	@FindBy(how=How.XPATH,using ="//input[@id='confirmpassword']/..//span")
	WebElement SignUpConfirmPasswordErrorMessage;

	@FindBy(how=How.XPATH,using ="//button[@id='submit']")
	WebElement SignUpButtonInSignUpPage;

	@FindBy(how=How.XPATH,using ="//div[@class='fb']//span")
	WebElement FBButtonInSignUpPage;

	@FindBy(how=How.XPATH,using ="//div[@class='social-media-logins']//div[@class='fb']")
	WebElement FBButtonStatementInSignUpPage;

	@FindBy(how=How.XPATH,using ="//div[@class='google']//span")
	WebElement GoogleButtonInSignUpPage;

	@FindBy(how=How.XPATH,using ="//div[@class='social-media-logins']//div[@class='google']")
	WebElement GoogleButtonStatementInSignUpPage;
	
	@FindBy(how=How.XPATH,using ="//i[@class='ssp-icon_close']")
	WebElement SignUpPageCancelLink;
	
	@FindBy(how=How.XPATH,using ="//span[@translate='_Registered_']")
	WebElement SignUpsuccessfulMessage;
	
	@FindBy(how=How.XPATH,using ="//span[text()='User already exists. Please try to login using existing password']")
	WebElement SignUpUnsuccessfulMessage;
	
	@FindBy(how=How.XPATH,using ="//div[@class='help-block ng-scope' and @translate='_SalutationRequired_']")
	WebElement SallutationErrorMessage;
	
	@FindBy(how=How.XPATH,using ="//span[@translate='_WrongFirstName_']")
	WebElement FirstNameErrorMessage;
	
	@FindBy(how=How.XPATH,using ="//span[@translate='_WrongLastName_']")
	WebElement LastNameErrorMessage;
	
	@FindBy(how=How.XPATH,using ="//span[@translate='_ValidPasswordPattern_']")
	WebElement PasswordErrorMessage;
	
	@FindBy(how=How.XPATH,using ="//span[@translate='_ValidConfirmPassword_']")
	WebElement ConfirmPasswordErrorMessage;
	
	@FindBy(how=How.XPATH,using ="//span[@translate='_ValidPasswordPattern_']")
	WebElement MinimumCriteriaPasswordErrorMessage;
	
	@FindBy(how=How.XPATH,using ="//span[@class='help-block ng-scope']")
	WebElement ConfirmPassword_matched_Message;
	
	@FindBy(how=How.XPATH,using ="//md-select[@id='title' and @placeholder='Select salutation']")
	WebElement Salutation;
	
	@FindBy(how=How.XPATH, using ="//div[@translate='_CheckboxErrorMsg_']")
	WebElement TermsAndConditions_And_PrivacyPolicy_Error_Msg;
	
	
	@FindBy(how=How.XPATH,using="//h1[@class='text-center ng-scope' and @translate='_CheckYourEmailToActivate_']")
	WebElement CheckYourMail_PopUp_HeaderText;
	
	@FindBy(how=How.XPATH,using="//div[@translate='_WeHaveJustSentYouAnEmailPleaseCheckYourInbox_']")
	WebElement CheckYourMail_PopUp_UnderHeaderText;
	
	@FindBy(how=How.XPATH,using="//button[@type='button']")
	WebElement Ok_Button_CheckYourMailPopup;
	
	
	//span[text()='User already exists. Please try to login using existing password']
	

	/**
	 * Method to click on SignUp link in SignUp page
	 * @throws InterruptedException 
	 */
	public void clickonSingUpLink() throws InterruptedException {
		Thread.sleep(3000);
		SignUpButtonInSignUpPage.click();
		log("Clicked on the Sign Up Button in SignUp Page");
		takeScreenShot();
	}
	
	/*Clicked On SignUp Link In LogIn Up Page*/
	
	public void clickonSingUpInLogInPage() throws InterruptedException {
		Thread.sleep(3000);
		SignUpLinkInLoginPage.click();
		log("Clicked on the Sign Up link in login Page");
		takeScreenShot();

	}

	

	/**
	 *****************************************************************************************************************
	 * Method to verify the Sign Up Page Title
	 * @param _PageTitle
	 * @return
	 *****************************************************************************************************************
	 */

	public String verifyPageTitle(String _PageTitle) {
		status="FAIL";
		
		if(driver.getTitle().contains(_PageTitle)) {
			log("Title of the page is "+driver.getTitle());
			status="PASS";
			takeScreenShot();
		}
		return status;
	}

	/**
	 *****************************************************************************************************************
	 * Method to verify the Email, Password and Confirm Password text fields are available in the SignUp page
	 * @param _Email, _Password, _ConfirmPassword
	 * @return
	 *****************************************************************************************************************
	 */
	public String verifyTextFieldsInsingUpPage(String _Email,String _Password,String _ConfirmPassword) {
		status="FAIL";
		if(SignUpEmail.getAttribute("placeholder").equals(_Email)) {
			log("Email Text field exists in  Sign Up page is -->"+ SignUpEmail.getAttribute("placeholder"));
			if(SignUpPassword.getAttribute("placeholder").equals(_Password)){
				log("Password Text field exists in Sign Up page is -->"+ SignUpPassword.getAttribute("placeholder"));
				if(SignUpConfirmPassword.getAttribute("placeholder").equals(_ConfirmPassword)){
					log("Confirm Password Text field exists in Sign Up page is -->"+ SignUpConfirmPassword.getAttribute("placeholder"));
					status="PASS";
					takeScreenShot();
				}
			}
		}
		return status;
	}

	/**
	 *****************************************************************************************************************
	 * Method to verify the Error Message which appears by entering the value other then the Email
	 * @param _EmailErrorMessage, _EmailInvalidValue
	 * @return
	 *****************************************************************************************************************
	 */
	public String verifyEmailErrorMessage(String _EmailErrorMessage, String _EmailInvalidValue) {
		status="FAIL";
		SignUpEmail.click();
		SignUpEmail.sendKeys(_EmailInvalidValue);
		if(signUpEmailErrorMessage.getText().equals(_EmailErrorMessage)) {
			log("Error message for the Wrong Email in sign Up Page -->"+ signUpEmailErrorMessage.getText());
			status="PASS";
			takeScreenShot();
		}
		return status;
	}
	
	
	


	/**
	 *****************************************************************************************************************
	 * Method to verify the Minimum Password criteria in Sign up page
	 * @param _InvalidPassword, _PasswordMinCriteria
	 * @return
	 *****************************************************************************************************************
	 */
	public String verifyPasswordMinimumCriteria(String _InvalidPassword, String _PasswordMinCriteria ) {
		status="FAIL";
		SignUpPassword.click();
		System.out.println(_InvalidPassword);
		SignUpPassword.sendKeys(_InvalidPassword);
		if(SignUpPasswordWarningMessage.getText().equals(_PasswordMinCriteria)) {
			log("Minimum password criteria is displyed in sign Up Page -->"+ SignUpPasswordWarningMessage.getText());
			status="PASS";
			takeScreenShot();
		}
		return status;
	}

	/**
	 *****************************************************************************************************************
	 * Method to verify the Password validation message for Confirm password in Sign up page
	 * @param _InvalidPassword, _PasswordErrorMessage
	 * @return
	 *****************************************************************************************************************
	 */
	public String verifyErrorMessageInConfirmPassword(String _InvalidPassword, String _PasswordErrorMessage ) {
		status="FAIL";
		SignUpConfirmPassword.click();
		SignUpConfirmPassword.sendKeys(_InvalidPassword);
		String ConfirmPasswordvalidationMessage=SignUpConfirmPasswordErrorMessage.getText().trim();

		if(ConfirmPasswordvalidationMessage.contains(_PasswordErrorMessage)) {
			log("Confirm password message is displyed in sign Up Page -->"+ SignUpConfirmPasswordErrorMessage.getText());
			status="PASS";
			takeScreenShot();
		}
		return status;
	}


	/**
	 *****************************************************************************************************************
	 * Method to verify the Minimum Password criteria in Sign up page
	 * @param _FBStatement, _GoogleStatement
	 * @return
	 *****************************************************************************************************************
	 */
	public String verifysocialMediaLinksLinkFBandGoogle(String _FBStatement, String _GoogleStatement ) {
		status="FAIL";
		String FbButton=FBButtonInSignUpPage.getText();
		String FbbuttonStatement=FBButtonStatementInSignUpPage.getText().substring(13);
		String FbButtonCompleateStatement=FbButton +" "+ FbbuttonStatement;
		System.out.println(FbButtonCompleateStatement);

		String GoogleButton=GoogleButtonInSignUpPage.getText();
		String GoogleButtonStatement=GoogleButtonStatementInSignUpPage.getText().substring(13);
		String GoogleButtonCompleateStatement=GoogleButton+" "+GoogleButtonStatement;
		System.out.println(GoogleButtonCompleateStatement);


		if(FbButtonCompleateStatement.contains(_FBStatement)) {
			log("Social N/W Button for Facebook is present in Sign Up page that is -->"+ FbButtonCompleateStatement);{
				if(GoogleButtonCompleateStatement.contains(_GoogleStatement)) {
					log("Social N/W Button for Google is present in Sign Up page that is -->"+ GoogleButtonCompleateStatement);

					status="PASS";
					takeScreenShot();
				}
			}
		}
		return status;
	}
	
	/**
	 * Method to click on FB button in SignUp  page
	 */
	public void clickonFBLinkButton() {
		FBButtonInSignUpPage.click();
		log("Clicked on the FB Sign Up link in Sign Up Page");
		takeScreenShot();

	}
	
	/**
	 * Method to click on Google button in SignUp  page
	 */
	public void clickonGoogleLinkButton() {
		GoogleButtonInSignUpPage.click();
		log("Clicked on the Google Sign Up link in Sign Up Page");
		takeScreenShot();

	}
	
	/**
	 * Method to click on Sign Up page "X" Link
	 */
	public void ClickOnXinsignUppage() {
		SignUpPageCancelLink.click();
		log("Clicked on the "+'X'+" Sign Up link in Sign Up Page");
		takeScreenShot();

	}
	
	/**
	 * Method to Enter EmailId, PAssword and ConfirmPAssword
	 * @throws InterruptedException 
	 */
	@FindBy(how=How.XPATH,using ="//md-select[@id='title']")
	WebElement selectSalutation_dd;
	
	
	
	@FindBy(how=How.XPATH,using ="//input[@id='firstname']")
	WebElement firstname;
	@FindBy(how=How.XPATH,using ="//input[@id='lastname']")
	WebElement lastname;
	
	public void EnterSignUpDetails(String _salutation,String _FirstName,
			String _Lastname,String _Email, String _Password, String _ConfirmPassword) throws InterruptedException {
		Thread.sleep(3000);
		
		WaitHelper wh = new WaitHelper(driver, test);
		
		selectSalutation_dd.click();
		
		WebElement sal = driver.findElement(By.xpath("//md-option[@value='"+_salutation+"']"));
		
		wh.waitForElementToBeVisible(sal, driver, 10);
		
		clickElementUsingJavaScript(sal);
		
		sendKeys(firstname, _FirstName);
		sendKeys(lastname, _Lastname);
		sendKeys(SignUpEmail, _Email);
		sendKeys(SignUpPassword, _Password);
		sendKeys(SignUpConfirmPassword, _ConfirmPassword);
		
		
		log("all details successfully entered in Sign Up Page");
		takeScreenShot();

	}
	
	
	 @FindBy(how=How.XPATH,using ="//md-checkbox[@id='termsAndConditionsCheck']//div[@class='md-container']")
		WebElement TermsAndCondition_Checkbox;
	
	  @FindBy(how=How.XPATH,using ="//md-checkbox[@id='privacyPolicyCheck']//div[@class='md-container']")
		WebElement PrivacyPolicy_Checkbox;
	  
	 
	public void clickon_TermsAndCondition_And_PrivacyPolicy_Checkbox() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(TermsAndCondition_Checkbox, driver, 20);
		clickElementUsingJavaScript(TermsAndCondition_Checkbox);
		log("Clicked on I agree to terms and conditions checkbox");
		clickElementUsingJavaScript(PrivacyPolicy_Checkbox);
		log("Clicked on I agree to Privacy Policy checkbox");
		takeScreenShot();

	}
	
	/**
	 *****************************************************************************************************************
	 * Method to verify Successful signUp message in Sign UP page
	 * @param _SuccessfulMessage
	 * @return
	 * @throws InterruptedException 
	 *****************************************************************************************************************
	 */
	public String VerifySignUpSuccessfulMessage(String _SuccessfulMessage ) throws InterruptedException {
		status="FAIL";
		
	//	clickon_TermsAndCondition_And_PrivacyPolicy_Checkbox();
		
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(SignUpButtonInSignUpPage, driver, 10);
		
		SignUpButtonInSignUpPage.click();
		
		wh.waitForElementToBeVisible(SignUpsuccessfulMessage, driver, 10);
		String SignUpsuccessfulMesseges=SignUpsuccessfulMessage.getText().trim();
		if(SignUpsuccessfulMesseges.contains(_SuccessfulMessage)) {
			log("SignUp confirmation message  -->"+ SignUpsuccessfulMesseges);
			status="PASS";
			takeScreenShot();
		}
		Thread.sleep(2000);
		return status;
	}
	
	/**
	 *****************************************************************************************************************
	 * Method to verify UnSuccessful signUp message in Sign UP page
	 * @param _UnSuccessfulMessage
	 * @return
	 * @throws InterruptedException 
	 *****************************************************************************************************************
	 */
	public String VerifySignUpUnSuccessfulMessage(String _UnSuccessfulMessage ) throws InterruptedException {
		status="FAIL";
		
        clickon_TermsAndCondition_And_PrivacyPolicy_Checkbox();
		
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(SignUpButtonInSignUpPage, driver, 10);
		
		SignUpButtonInSignUpPage.click();
	
		wh.waitForElementToBeVisible(SignUpUnsuccessfulMessage, driver, 10);
		String SignUpUnsuccessfulMesseges=SignUpUnsuccessfulMessage.getText().trim();
        System.out.println(SignUpUnsuccessfulMesseges);
        System.out.println(_UnSuccessfulMessage);
        
		if(SignUpUnsuccessfulMesseges.contains(_UnSuccessfulMessage)) {
			log("Confirm password message is displyed in sign Up Page -->"+ SignUpUnsuccessfulMesseges);
			status="PASS";
			takeScreenShot();
		}
		return status;
	}

	
	
	/*Error Message Displayed For Wrong Email Input*/
	
	public String verifyEmailErrorMessage_1(String _salutation,String _FirstName,
			String _Lastname, String _Password, String _ConfirmPassword,String _EmailErrorMessage, String _EmailInvalidValue) throws InterruptedException {
		status="FAIL";
		
		WaitHelper wh = new WaitHelper(driver, test);
		
		selectSalutation_dd.click();
		
		WebElement sal = driver.findElement(By.xpath("//md-option[@class='ng-scope md-ink-ripple' and @value='"+_salutation+"']"));//md-option/div[@class='md-text' and text()='"+_salutation+"']
		
		wh.waitForElementToBeVisible(sal, driver, 10);
		
		clickElementUsingJavaScript(sal);
		
		sendKeys(firstname, _FirstName);
		sendKeys(lastname, _Lastname);
		sendKeys(SignUpPassword, _Password);
		sendKeys(SignUpConfirmPassword, _ConfirmPassword);
		
		log("First name,Last Name,Password,Confirm Password successfully entered in Sign Up Page");
		takeScreenShot();
	
		SignUpEmail.click();
		SignUpEmail.sendKeys(_EmailInvalidValue);
		log("Entered a invalid Email");
		Thread.sleep(1000);
		SignUpButtonInSignUpPage.click();
		
		if(signUpEmailErrorMessage.getText().equals(_EmailErrorMessage)) {
			log("Error message for the Wrong Email in sign Up Page -->"+ signUpEmailErrorMessage.getText());
			status="PASS";
		}
		return status;
	}
	
	/*Error Messages Displayed For All Mandatory Fields In SignUP Page*/
	
	public String Verify_SignUp_Mandatory_Fields_Error_Messages(String _salutationErrorMassage,
			String _LastnameErrorMessage,String _FirstnameErrorMessage,String _EmailErrorMessage, String _PasswordErrorMessage, String _ConfirmPasswordErrorMessage , String _TermsAndConditions_And_PrivacyPolicy_Error_Msg) throws InterruptedException {
		status="FAIL";
		
		SignUpButtonInSignUpPage.click();
		Thread.sleep(2000);
		
//		if(SallutationErrorMessage.getText().equals(_salutationErrorMassage)) {
//			log("Error message for Enter Salutation in sign Up Page -->"+ SallutationErrorMessage.getText());
			
		if(FirstNameErrorMessage.getText().equals(_FirstnameErrorMessage))
			log("Error message for Enter FirstName in sign Up Page -->"+ FirstNameErrorMessage.getText());
		
		if(LastNameErrorMessage.getText().equals(_LastnameErrorMessage))
			log("Error message for Enter LastName in sign Up Page -->"+ LastNameErrorMessage.getText());

		if(signUpEmailErrorMessage.getText().equals(_EmailErrorMessage))
			log("Error message for Enter Email in sign Up Page -->"+ signUpEmailErrorMessage.getText());
		
		if(PasswordErrorMessage.getText().equals(_PasswordErrorMessage))
			log("Error message for Enter Password in sign Up Page -->"+ PasswordErrorMessage.getText());
		
		if(ConfirmPasswordErrorMessage.getText().equals(_ConfirmPasswordErrorMessage))
			log("Error message for Enter ConfirmPassword in sign Up Page -->"+ ConfirmPasswordErrorMessage.getText());
		
		if(TermsAndConditions_And_PrivacyPolicy_Error_Msg.getText().equals(_TermsAndConditions_And_PrivacyPolicy_Error_Msg))
		   log("Error message for terms and condition and privacy policy in sign up page -->"+ TermsAndConditions_And_PrivacyPolicy_Error_Msg.getText());

			status="PASS";
	//	}
		return status;
		
	}
	
	/*Verify Minimum Criteria Error Message Displayed In SignUp Page for Invalid Password*/
	
	public String verifyPasswordMinimumCriteria_Message(String _salutation,String _FirstName,String _Lastname,String _Email, String _InvalidPassword,String _ConfirmPassword ,String _PasswordMinCriteria ) {
		status="FAIL";
		
        WaitHelper wh = new WaitHelper(driver, test);
		
		selectSalutation_dd.click();
		
		WebElement sal = driver.findElement(By.xpath("//md-option[@class='ng-scope md-ink-ripple' and @value='"+_salutation+"']"));//md-option/div[@class='md-text' and text()='"+_salutation+"']
		
		wh.waitForElementToBeVisible(sal, driver, 10);
		
		clickElementUsingJavaScript(sal);
		
		sendKeys(firstname, _FirstName);
		sendKeys(lastname, _Lastname);
		sendKeys(SignUpEmail, _Email);
		
		log("first name,last name,Email successfully entered in Sign Up Page");
		takeScreenShot();
	
		SignUpPassword.sendKeys(_InvalidPassword);
		log("Entered a invalid Password");
		SignUpConfirmPassword.sendKeys(_ConfirmPassword);
		log("Entered ConfirmPassword");
		SignUpButtonInSignUpPage.click();
		if(MinimumCriteriaPasswordErrorMessage.getText().equals(_PasswordMinCriteria)) {
			log("Minimum password criteria is displyed in sign Up Page -->"+ MinimumCriteriaPasswordErrorMessage.getText());
			status="PASS";
		}
		return status;
	}

	
	/*Error Message Displayed If Password Doesn't Matched*/
	
	public String verifyErrorMessageInConfirmPassword_message(String _InvalidPassword, String _InvalidConfirmPassword, String _PasswordErrorMessage ) throws InterruptedException {
		status="FAIL";
		SignUpPassword.sendKeys(_InvalidPassword);
		log("Entered a Password");
		SignUpConfirmPassword.sendKeys(_InvalidConfirmPassword);
		log("Entered a Confirm Password");
		Thread.sleep(2000);
		if(ConfirmPassword_matched_Message.getText().equals(_PasswordErrorMessage)) {
			log("Minimum password criteria is displyed in sign Up Page -->"+ ConfirmPassword_matched_Message.getText());
			status="PASS";
		}
		return status;
	}

	/*Verify available SignUp detail fields form in SignUp page*/
	
	 public String verifyAvailbleSignUpFieldsInSignUpDetailsForm(String _Salutation,String _firstname,String _lastname,String _signupemail,String _SignupPassword,String _SignUpConfirmPassword){
			status="FAIL";

//			if(Salutation.getAttribute("id").equals(_Salutation)){
//				log(Salutation.getAttribute("id")+"--> Salutation dropdown is displayed for select salutation in signUp Details form");
				if(firstname.getAttribute("id").equals(_firstname)){
					log(firstname.getAttribute("id")+"--> Firstname text field is displayed in signUp Details form");
					if(lastname.getAttribute("id").equals(_lastname)){
						log(lastname.getAttribute("id")+"--> Lastname text field is displayed in signUp Details form");
						if(SignUpEmail.getAttribute("id").equals(_signupemail)){
							log(SignUpEmail.getAttribute("id")+"--> Email text field is displayed in signUp Details form");
							if(SignUpPassword.getAttribute("id").equals(_SignupPassword)){
								log(SignUpPassword.getAttribute("id")+"--> Password text field is displayed in signUp Details form");
								if(SignUpConfirmPassword.getAttribute("id").equals(_SignUpConfirmPassword)){
									log(SignUpConfirmPassword.getAttribute("id")+"--> Confirm password text field is displayed in signUp Details form");
												
									         status="PASS";
											}
										}
									}
					            
					           }
				          }
			//         }
				             
			              
			return status;

	 }


	
	
	
	public String emailCreation() throws InterruptedException, AWTException {
		
		Thread.sleep(1000);
		DateAndUniqueNoGenerateHelper date=new DateAndUniqueNoGenerateHelper();
		
		String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        char cha = alphabet.charAt(rnd.nextInt(alphabet.length()));
        char cha2 = alphabet.charAt(rnd.nextInt(alphabet.length()));
		
		String uniqueNo = date.generateUniqueNo();
		log("unique no is generated "+uniqueNo);
	
        String UniqueEmail = cha+uniqueNo+cha2+"@mailinator.com";
	
		return UniqueEmail;
		//return _TenantName;
	}
	


public String emailCreationNew() throws InterruptedException, AWTException {
	
	Thread.sleep(1000);
	DateAndUniqueNoGenerateHelper date=new DateAndUniqueNoGenerateHelper();
	
	String alphabet = "0123456789abcdefghijklmnopqrstuvwxyz";
    Random rnd = new Random();
    char cha = alphabet.charAt(rnd.nextInt(alphabet.length()));
    char cha2 = alphabet.charAt(rnd.nextInt(alphabet.length()));
	
	String uniqueNo = date.generateUniqueNo();
	log("unique no is generated "+uniqueNo);

    String UniqueEmail = cha+uniqueNo+cha2;

	return UniqueEmail;
	//return _TenantName;
}



@FindBy(how=How.XPATH,using ="//button[@id='submit']")
WebElement link_SignUp;

public void clickOnSignUp() throws InterruptedException {
	clickon_TermsAndCondition_And_PrivacyPolicy_Checkbox();
	Thread.sleep(1000);
	WaitHelper wh = new WaitHelper(driver, test);
	wh.waitForElementToBeVisible(link_SignUp, driver, 10);
	link_SignUp.click();
	log("clicked on signup button in signup page");
	
   }

public String Verify_CheckYourMail_Popup_After_SignUpSuccessfully(String _HeaderOne, String HeaderTwo){
	
	status = "FAIL";
	
	WaitHelper wh = new WaitHelper(driver,test);
	wh.waitForElementToBeClickable(CheckYourMail_PopUp_HeaderText, driver, 30);
	
	if(CheckYourMail_PopUp_HeaderText.getText().equals(_HeaderOne)) {
		log(CheckYourMail_PopUp_HeaderText.getText()+ " is displayed in the popup");
		if(CheckYourMail_PopUp_UnderHeaderText.getText().equals(HeaderTwo)) 
			log(CheckYourMail_PopUp_UnderHeaderText.getText()+ " is displayed in the popup");
		
		Ok_Button_CheckYourMailPopup.click();
		log("Clicked on OK button in check your mail popup");
		log("popup closed");		
		status = "PASS";
	}
	
	   return status;
	}



}



