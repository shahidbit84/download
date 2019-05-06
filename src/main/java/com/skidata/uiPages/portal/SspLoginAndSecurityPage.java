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
public class SspLoginAndSecurityPage extends TestBase {

	
	
	String status=null;


	public static final Logger log = Logger.getLogger(SspLoginAndSecurityPage.class.getName());



	//Class constructor
	public SspLoginAndSecurityPage(WebDriver driver,ExtentTest test) {
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
	
	@FindBy(how=How.XPATH,using ="//div[@class='form-validation-error-msg ng-scope' and @translate='_PasswordsDoNotMatch_']")
	WebElement Password_Error_Message;
	
	@FindBy(how=How.XPATH,using ="//input[@id='password']")
	WebElement Password;
	
	@FindBy(how=How.XPATH,using ="//input[@id='confirmPassword']")
	WebElement Confirm_Password;
	


	


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
	
	
	/*Verify Unregistered*/
	
	@FindBy(how=How.XPATH,using ="//div[@translate='_UnRegisterMyAccount_']")
	WebElement loginAndSecurity_Unregistered;
	
	@FindBy(how=How.XPATH,using ="//h1[@class='ng-binding']")
	WebElement Unregistered_PopUp_Message;
	
	public String unregistered_Popup(String _UnregisteredPopup)
	{
		
		status = "FAIL";
		
		WaitHelper wh = new WaitHelper (driver , test);
		wh.waitForElementToBeClickable(loginAndSecurity_Unregistered, driver, 20);
		clickElementUsingJavaScript (loginAndSecurity_Unregistered);
		log("Clicked on unregistered link in login & security page");
		
		wh.waitForElementToBeClickable(Unregistered_PopUp_Message, driver, 10);
		
		if(Unregistered_PopUp_Message.getText().equals(_UnregisteredPopup)) {
			log(Unregistered_PopUp_Message.getText()+" is displayed in unregistered popup");
			
			status= "PASS";
			takeScreenShot();
			
		}
		
		return status;
		

	}
	

	
     public String Unregisteredlink_LoginAndSecurityPg(String _Unregistered_Link) {
    	 
    	 status="FAIL";
    	 
    	 if(loginAndSecurity_Unregistered.getText().equals(_Unregistered_Link)) {
    		 log(loginAndSecurity_Unregistered.getText()+ "link is displayed in login & security page");
    		 
    		 status="PASS";
 
    	 }
    	 
		return status;
    	 
     }
	



	@FindBy(how=How.XPATH,using ="//h2[@class='ng-scope' and @translate='_ProfileSecurity_']")
	WebElement loginAndSecurityHeader;
	
	public String verifyHeader(String pageHeaderLoginAndSecurity) {
		status="FAIL";
		if(loginAndSecurityHeader.getText().equals(pageHeaderLoginAndSecurity)) {
			log(loginAndSecurityHeader.getText()+" is displayed in UI");
			status="PASS";
			takeScreenShot();
		}
		return status;
		
		
		
		
	}

	@FindBy(how=How.XPATH,using ="//input[@id='fullName']")
	WebElement input_Name;
	
	public void updateUserName(String _Name) throws InterruptedException {
		input_Name.click();
		input_Name.clear();
		Thread.sleep(3000);
		input_Name.sendKeys(_Name);
		log("Name is updated as "+" _Name");
		takeScreenShot();
		
	}
	
	@FindBy(how=How.XPATH,using ="//input[@id='firstName']")
	WebElement input_First_Name;
	
	public void updateUserFirstName(String _Name) throws InterruptedException {
		input_First_Name.click();
		input_First_Name.clear();
		Thread.sleep(2000);
		input_First_Name.sendKeys(_Name);
		log("First Name is updated as "+" First_Name");
		
	}
	
	@FindBy(how=How.XPATH,using ="//input[@id='lastName']")
	WebElement input_Last_Name;
	
	public void updateUserLastName(String _Name) throws InterruptedException {
		input_Last_Name.click();
		input_Last_Name.clear();
		Thread.sleep(2000);
		input_Last_Name.sendKeys(_Name);
		log("Last Name is updated as "+" Last_Name");
		
	}
	
	
	@FindBy(how=How.XPATH,using ="//input[@id='contact']")
	WebElement input_UserPhone;
	
	public void updateUserPhone(String _Phone) throws InterruptedException {
		input_UserPhone.click();
		input_UserPhone.clear();
		Thread.sleep(3000);
		input_UserPhone.sendKeys(_Phone);
		log("Phone is updated as "+" _Phone");
		takeScreenShot();
		
	}
	

	@FindBy(how=How.XPATH,using ="//span[@translate='_Update_']")
	WebElement buttonUpdate;
	
	public void clickOnUpdate() throws InterruptedException {
		Thread.sleep(2000);
		clickElementUsingJavaScript(buttonUpdate);
		log("Clicked on Update button");
		takeScreenShot();
		
	}

	

	public String verifyUpdationSuccessMsg(String _SuccessMessage) throws InterruptedException{
		
		status="FAIL";
		Thread.sleep(2000);
		String t = driver.findElement(By.xpath("//div[@id='securityToast']//div[@class='msg ng-binding']")).getText();
		
		log(t);
		//String concat = t.replaceAll("\n", "");
		
		if(t.equals(_SuccessMessage)) {
			status="PASS";
			log( t+" is displayed after User updation");
			takeScreenShot();
		}
		return status;
		
		
		
	}


	
	@FindBy(how=How.XPATH,using ="//input[@id='password']")
	WebElement password;
	
	@FindBy(how=How.XPATH,using ="//input[@name='oldpassword' and @id='oldpassword']")
	WebElement OldPassword;
	
	@FindBy(how=How.XPATH,using ="//input[@id='confirmPassword']")
	WebElement confirmPassword;
	
	public void updateUserPassword(String _OldPassword,String _password) {
		OldPassword.sendKeys(_OldPassword);
		password.sendKeys(_password);
		confirmPassword.sendKeys(_password);
	}
	
	
	/*Error Message Displayed For Password */
	
	public String Verify_Password_Error_Messages(String _PasswordErrorMassage ) throws InterruptedException {
		status="FAIL";
		
		Thread.sleep(1000);
		
		Password.sendKeys("12345");
		log("Entered Password");
		Confirm_Password.sendKeys("1234");
		log("Entered Confirm Password");
		
		if(Password_Error_Message.getText().equals(_PasswordErrorMassage)) {
			log("Error message displayed for Password in LogIn & Security Page -->"+ Password_Error_Message.getText());
		
			status="PASS";
		}
		return status;
		
	}
	
/*Verify Discard Confirmation Message*/
	
	@FindBy(how=How.XPATH,using ="//h1[@class='ng-binding']")
	WebElement discardConfirmationMessage;
	public String verify_Discard_ConfirmationMessage(String _DiscardConfirmation) throws InterruptedException {
		Thread.sleep(3000);

		status="FAIL";
		
		if(discardConfirmationMessage.getText().equals(_DiscardConfirmation)) {
			log(discardConfirmationMessage.getText()+" is displayed");
			takeScreenShot();
			status="PASS";
		}
		return status;
		
		
	}
	
/*Clicked On "X" Button In Discard Confirmation Popup*/
	
	@FindBy(how=How.XPATH,using ="//i[@class='ssp-icon_close']")
	WebElement X_Button;
	public void clickOn_X_DiscardConfirmationPopUp() throws InterruptedException {
		Thread.sleep(2000);
	
		X_Button.click();
		log("Clicked on the X button In Discard Confirmation PopUp");
		takeScreenShot();
		
	}
	
	/*Clicked On No Button In Discard Confirmation Popup*/
	
	@FindBy(how=How.XPATH,using =".//*[@id='btnCancel']")
	WebElement NoButton;
	public void clickOnNoDiscardConfirmationPopUp() throws InterruptedException {
		Thread.sleep(2000);
	
		NoButton.click();
		log("Clicked on the No button In Discard Confirmation Popup");
		takeScreenShot();
		
	}
	
	/*Clicked On Yes Button In Discard Confirmation Popup*/
	
	@FindBy(how=How.XPATH,using ="//button[@id='btnOk']")
	WebElement YesButton_;
	public void clickOnYesDiscardConfirmationPopUp_() throws InterruptedException {
		Thread.sleep(2000);
	
		YesButton_.click();
		log("Clicked on the Yes button In Discard Confirmation Popup, Page navigated to Dashboard Page");
		takeScreenShot();
		
	}
	
	/*Unregistered Popup buttons*/

	public void ClickOnAll_Buttons_On_Unregistered_Popup() {
	   
		WaitHelper wh = new WaitHelper(driver, test);
	    wh.waitForElementToBeClickable(X_Button, driver, 10);
	
	    clickElementUsingJavaScript(X_Button);
		log("X clicked on unregistered popup");
		 
		wh.waitForElementToBeClickable(loginAndSecurity_Unregistered, driver, 10);
		clickElementUsingJavaScript(loginAndSecurity_Unregistered);
		 
	    wh.waitForElementToBeClickable(NoButton, driver, 10);
		clickElementUsingJavaScript(NoButton);
		log("No button clicked on unregistered popup");
		  
		wh.waitForElementToBeClickable(loginAndSecurity_Unregistered, driver, 10);
		clickElementUsingJavaScript(loginAndSecurity_Unregistered);
		  
		wh.waitForElementToBeClickable(YesButton_, driver, 10);
		clickElementUsingJavaScript(YesButton_);
		log("Yes button clicked on unregistered popup");
		  
		WebElement loader = driver.findElement(By.xpath("//div[@class='loader']"));
		wh.waitForElementToBeInvisible(loader, driver, 30);
		
		log("User unregistered successfully");
		
	}


	
}