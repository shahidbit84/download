package com.skidata.uiPages.portal;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.testBase.TestBase;


/**
 * @author mavh
 * 
 */
public class SspResetPasswordPage extends TestBase {

	
	
	String status=null;


	public static final Logger log = Logger.getLogger(SspHomePage.class.getName());



	//Class constructor
	public SspResetPasswordPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

	}


	/**
	 ******************************************************************************************************
	 * Web Elements of PortalMainPage
	 ******************************************************************************************************
	 */

	@FindBy(xpath = "//div[@class='ng-binding']")
	public WebElement link_ForgotPassword;

	@FindBy(xpath = "//div[@class='fields']/h1")
	public WebElement label_ForgotPasswordHeader;

	@FindBy(xpath = "//div[@class='fields']/div[1]")
	public WebElement label_ForgotPasswordHeaderSubtitle;

	@FindBy(xpath = "//div[@class='form-group']/input")
	public WebElement textArea_ForgotPasswordTextPlaceholder;

	@FindBy(xpath = "//button[@class='sub']/span")
	public WebElement button_SendResetLink;

	@FindBy(xpath = "//span[@translate='_BackToLogin_']")
	public WebElement link_BackToLogin;

	@FindBy(xpath = "//span[@translate='_WrongEmail_']")
	public WebElement WrongEmailValidationMessage;


	/**
	 *****************************************************************************************************************
	 * Method to verify the Reset Password Page Title
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
	 * Method to select ForgotPassword Link in the Login page
	 * @param 
	 * @return
	 *****************************************************************************************************************
	 */

	public void SelectForgotPasswordInLoginPage() {
		link_ForgotPassword.click();
		log("Clicked on the Forgot Password link in login Page");
		takeScreenShot();
	}
	
	/**
	 *****************************************************************************************************************
	 * Method to select Send Reset Link in the Login page
	 * @param 
	 * @return
	 *****************************************************************************************************************
	 */

	public void SelectSendResetLink() {
		button_SendResetLink.click();
		log("Clicked on the SEND RESET LINK in Reset Password Page");
		takeScreenShot();
	}

	/**
	 *****************************************************************************************************************
	 * Method to verify the Reset Password Page Heading
	 * @param _PageHeading
	 * @return
	 *****************************************************************************************************************
	 */

	public String verifyResetPasswordHeading(String _PageHeading) {
		status="FAIL";
		
	
		
		
		if(label_ForgotPasswordHeader.getText().equals(_PageHeading)) {
			log("Reset Password Page Heading is  "+label_ForgotPasswordHeader.getText());
			status="PASS";
			takeScreenShot();
		}
		return status;
	}

	/**
	 *****************************************************************************************************************
	 * Method to verify the Reset Password Page Sub-Heading
	 * @param _PageSubHeading
	 * @return
	 *****************************************************************************************************************
	 */

	public String verifyResetPasswordHeadingSubheader(String _PageSubHeadings) {
		status="FAIL";
		if(label_ForgotPasswordHeaderSubtitle.getText().contains(_PageSubHeadings)) {
			log("Reset Password Page Sub-Heading is "+ label_ForgotPasswordHeaderSubtitle.getText());
			status="PASS";
			takeScreenShot();
		}
		return status;
	}

	/**
	 *****************************************************************************************************************
	 * Method to verify the Email Placeholder
	 * @param _EmailTextPlaceholder
	 * @return
	 *****************************************************************************************************************
	 */

	public String verifyEmailPlaceholder(String _EmailTextPlaceholder) {
		status="FAIL";
		if(textArea_ForgotPasswordTextPlaceholder.getAttribute("PlaceHolder").contains(_EmailTextPlaceholder)) {
			log("Reset Password Page Email text filed PlaceHolder is "+ textArea_ForgotPasswordTextPlaceholder.getAttribute("PlaceHolder"));
			status="PASS";
			takeScreenShot();
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
		textArea_ForgotPasswordTextPlaceholder.click();
		textArea_ForgotPasswordTextPlaceholder.sendKeys(_EmailInvalidValue);
		
		if(WrongEmailValidationMessage.getText().equals(_EmailErrorMessage)) {
			log("Error message for the Wrong Email in sign Up Page -->"+ WrongEmailValidationMessage.getText());
			status="PASS";
			takeScreenShot();
		}
		return status;
	}


	/**
	 *****************************************************************************************************************
	 * Method to Enter the Valid Email in the Email text field
	 * @param  _EmailvalidValue
	 * @return
	 *****************************************************************************************************************
	 */
	public void enterValidEmailInEmailtextfield(String _EmailvalidValue) {
		status="FAIL";
		textArea_ForgotPasswordTextPlaceholder.click();
		textArea_ForgotPasswordTextPlaceholder.sendKeys(_EmailvalidValue);
		status="PASS";
		takeScreenShot();	
	}
	
	/**
	 *****************************************************************************************************************
	 * Method to to select Back to login link
	 * @param  
	 * @return
	 *****************************************************************************************************************
	 */
	public void ClickOnBackToLoginLink() {
		status="FAIL";
		link_BackToLogin.click();
		status="PASS";
		takeScreenShot();	
	}
	
	
}
