/**
 *
 */
package com.skidata.uiPages.portal;


import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.helperclasses.WaitHelper;
import com.skidata.testBase.TestBase;

/**
 * @author shmo
 * 
 */
public class SspLoginPage extends TestBase {

	
	
	String status=null;


	public static final Logger log = Logger.getLogger(SspLoginPage.class.getName());



	//Class constructor
	public SspLoginPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

	}


	/**
	 ******************************************************************************************************
	 * Web Elements of PortalMainPage
	 ******************************************************************************************************
	 */

	@FindBy(xpath = "//span[@class='v-label' and text()='LOADING...']")
	public WebElement loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;

	@FindBys({	
		@FindBy(how=How.ID, using="logo"),
	})	public List<WebElement> allElementsInList_LogoImage;

	@FindBy(how=How.XPATH,using ="//a[@id='goToHome1']/div")
	WebElement label_HomeIcon;

	@FindBy(how=How.XPATH,using ="//a[@id='goToCart1']/div")
	WebElement label_CartIcon;

	@FindBy(how=How.XPATH,using ="//a[@id='goToLogin']/div")
	WebElement label_LoginIcon;


	
	@FindBy(how=How.XPATH,using ="//input[@id='username']")
	WebElement input_Email;
	
	@FindBy(how=How.XPATH,using ="//input[@id='password']")
	WebElement input_Password;
	
	//button[@id='submit']
	@FindBy(how=How.XPATH,using ="//button[@id='submit']")
	WebElement button_Login;
	
	@FindBy(how=How.XPATH,using ="//span[text()='Sign up']")
	WebElement label_signUp;
	
	@FindBy(how=How.XPATH,using ="//div[@class='fb']//span")
	WebElement FBButtonInLoginPage;
	
	@FindBy(how=How.XPATH,using ="//div[@class='google']//span")
	WebElement GoogleButtonInLoginPage;
	
	@FindBy(how=How.XPATH,using ="//span[@data-i18n='_LogIn_']")
	WebElement LogInButtonInLogInPage;
	
	
	/**
	 *****************************************************************************************************************
	 * Method to verify the Page Title
	 * @param _PageTitle
	 * @return
	 *****************************************************************************************************************
	 */
	public String verifyPageTitle(String _PageTitle) {
		status="FAIL";

		if(driver.getTitle().equals(_PageTitle)) {
			log("Title of the page is "+driver.getTitle());
			status="PASS";
			takeScreenShot();
		}
		return status;
	}



	public void login(String _Email, String _Password) throws InterruptedException {
	status="FAIL";
	Thread.sleep(4000);
	WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(driver, 20, input_Email);
		input_Email.clear();
		input_Email.sendKeys(_Email);
		log("Entered email id as "+_Email);
		
		input_Password.clear();
		input_Password.sendKeys(_Password);
		
		log("Entered password as "+_Password);
		takeScreenShot();
		button_Login.click();
		log("Clicked on Login");
		takeScreenShot();
		
	}
	
	/**
	 * Method to click on FB button in Login  page
	 */
	public void clickonFBLinkButton() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(FBButtonInLoginPage, driver, 10);
		FBButtonInLoginPage.click();
		log("Clicked on the FB Sign Up link in Login Page");
		takeScreenShot();

	}
	
	/**
	 * Method to click on Google button in Login page
	 */
	public void clickonGoogleLinkButton() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(GoogleButtonInLoginPage, driver, 10);
		GoogleButtonInLoginPage.click();
		log("Clicked on the Google Sign Up link in Login Page");
		takeScreenShot();

	}
	
	@FindBy(how=How.XPATH,using ="//span[@translate='_SignUp_']")
	WebElement link_SignUp;
	
	public void clickOnSignUp() throws InterruptedException {
	
		Thread.sleep(5000);
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(link_SignUp, driver, 10);
		link_SignUp.click();
		
	}
	
	public void clickonLogInButton() throws InterruptedException {
		Thread.sleep(3000);
		LogInButtonInLogInPage.click();
		log("Clicked on the Login Button in Login Page");
		takeScreenShot();
	}
	
	
	@FindBy(how=How.XPATH,using ="//div[@class='ng-binding']")
	WebElement ForgotPassword_Link;
	
	public void clickonForgotPassword() throws InterruptedException {
		
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(ForgotPassword_Link, driver, 10);
		
		clickElementUsingJavaScript(ForgotPassword_Link);

		log("Clicked on the ForgotPassword In Login Page");
		takeScreenShot();

	}
	
	public String verifyPageTitle_ResetPasswordPage(String _PageTitle) {
		status="FAIL";
		
		if(driver.getTitle().equals(_PageTitle)) {
			log("Title of the Reset Password is "+driver.getTitle());
			status="PASS";
			takeScreenShot();
		}
		return status;
	}
	
	@FindBy(how=How.XPATH,using ="//h1[@class='ng-scope']")
	WebElement pageHeader_ResetPassword;
	
	@FindBy(how=How.XPATH,using ="//div[@class='reset-password-text ng-scope']")
	WebElement SubHeader_ResetPassword;
	
	@FindBy(how=How.XPATH,using ="//input[@id='userEmail']")
	WebElement Email_ResetField;
	
	//@FindBy(how=How.XPATH,using ="//button[@type='submit']")
	@FindBy(how=How.XPATH,using ="//span[contains(text(),'Send reset link')]")
	WebElement Link_sendReset;
	
	//@FindBy(how=How.XPATH,using ="//span[@class='fa fa-angle-left']")
	@FindBy(how=How.XPATH,using ="//span[contains(text(),'Back to login')]")	
	WebElement Link_BacktoLogin;
	
	public String verify_ResetPasswordPage_HeaderAndLabel(String _PageHeader,String _SubHeader) throws InterruptedException {
		status="FAIL";
		Thread.sleep(2000);
		if(pageHeader_ResetPassword.getText().equals(_PageHeader)) {
			log(pageHeader_ResetPassword.getText()+" is displayed");
			if(SubHeader_ResetPassword.getText().equals(_SubHeader)) 
				log(SubHeader_ResetPassword.getText()+" is displayed");
			      
				takeScreenShot();
				status="PASS";
			}	
		
		return status;
	}
	
	public String verifyAvailbleTextFieldInResetParkerPage(String _ResetEmail_field) throws InterruptedException{
		status="FAIL";
		Thread.sleep(3000);
		if(Email_ResetField.getAttribute("id").equals(_ResetEmail_field)){
			log(Email_ResetField.getAttribute("id")+"--> Email field is displayed In Reset Password Page");
			
								
					status="PASS";
				}
		
		return status;

 }
	
	public String verify_AvailableLinks_ResetPassword(String _ResendButton,String _BackToLogInButton) throws InterruptedException{
		status="FAIL";
		Thread.sleep(2000);
		/*if(Link_sendReset.getAttribute("class").equals(_ResendButton)){
			log(Link_sendReset.getAttribute("class")+"--> Send Reset Link button is displayed in Reset Password Page");
			if(Link_BacktoLogin.getAttribute("class").equals(_BackToLogInButton)){
				log(Link_BacktoLogin.getAttribute("class")+"--> Back to login button is displayed in Reset Password Page");
				
				
				status="PASS";
				}
			}*/		
		if(Link_sendReset.getText().equals(_ResendButton)){
			log(Link_sendReset.getText()+"--> Send Reset Link button is displayed in Reset Password Page");
			if(Link_BacktoLogin.getText().equals(_BackToLogInButton)){
				log(Link_BacktoLogin.getText()+"--> Back to login button is displayed in Reset Password Page");
								
				status="PASS";
				}					
		}
		return status;

 }
	

	
	public void clickonSendResetLink() throws InterruptedException {
		Thread.sleep(1000);
		Link_sendReset.click();
		log("Clicked on the Send Reset Link In Reset Password Page");
		takeScreenShot();

	}
	
	public void EnterEmailInResetPasswordPage(String _Email) throws InterruptedException {
		Thread.sleep(1000);
		Email_ResetField.click();
		Thread.sleep(1000);
		Email_ResetField.clear();
		Email_ResetField.sendKeys(_Email);
		log("Entered Email");
		Thread.sleep(1000);
        Link_sendReset.click();
        log("Clicked on the Send Reset Link In Reset Password Page");
        takeScreenShot();

	}
	
	/*Signup verification in email link for harakirimail.com*/
	
	@FindBy(how=How.XPATH,using ="//input[@id='inbox-name']")
	WebElement Inbox_harakirimail;
	
	@FindBy(how=How.XPATH,using ="//button[@id='getinbox']")
	WebElement goInbox_harakirimail_Link;
	
	@FindBy(how=How.XPATH,using ="//div[contains(text(),'Account Activation')]") //div[contains(text(),'sweb® eCom account activation')]
	WebElement harakirimail_receivedmail_Link;
	
	@FindBy(how=How.XPATH,using ="//a[contains(text(),'Click here to activate your account')]")
	WebElement harakirimail_receivedmail_Activation_Link;
	
	
	public void Verifysignup(String _Email) throws InterruptedException {
		Thread.sleep(20000);
		driver.navigate().to("https://harakirimail.com");
		log("page is navigating to harakirimail");
		WaitHelper wh = new WaitHelper(driver, test);
	//	wh.waitForElementToBeVisible(Inbox_harakirimail, driver, 10);
		Inbox_harakirimail.click();
		Inbox_harakirimail.sendKeys(_Email);
		log("entered email in harakirimail inbox field");
		Thread.sleep(1000);
		goInbox_harakirimail_Link.click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		harakirimail_receivedmail_Link.click();
		log("clicked on received mail for verification");
		wh.waitForElementToBeVisible(harakirimail_receivedmail_Activation_Link, driver, 10);
		harakirimail_receivedmail_Activation_Link.click();
		log("clicked on user activation link");
		
		log("Verified User Successfully");
		takeScreenShot();

	}
	
    /*Signup verification in email link for mailinator.com*/
	
	@FindBy(how=How.XPATH,using ="//input[@id='inboxfield']")
	WebElement Inbox_mailinator;
	
	@FindBy(how=How.XPATH,using ="//button[contains(text(),'Go!')]")
	WebElement goInbox_mailinator_Link;
	
	@FindBy(how=How.XPATH,using ="//td[contains(text(),'Sweb.ecom account activation')]")
	WebElement mailinator_receivedmail_Link;
	
	@FindBy(how=How.XPATH,using ="//a[contains(text(),'Click here to activate your account')]")
	WebElement mailinator_receivedmail_Activation_Link;
	
	public void Verifysignup_Mailinator(String _Email) throws InterruptedException {
		Thread.sleep(5000);
		driver.navigate().to("https://www.mailinator.com/");
		WaitHelper wh = new WaitHelper(driver, test);
	//	wh.waitForElementToBeVisible(Inbox_harakirimail, driver, 10);
		Inbox_mailinator.click();
		Inbox_mailinator.sendKeys(_Email);
		goInbox_mailinator_Link.click();
		Thread.sleep(15000);
		driver.navigate().refresh();
		mailinator_receivedmail_Link.click();
		wh.waitForElementToBeVisible(mailinator_receivedmail_Activation_Link, driver, 10);
		mailinator_receivedmail_Activation_Link.click();
		
		log("Verified User Successfully");
		takeScreenShot();

	}
	

	
}