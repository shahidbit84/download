/**
 *
 */
package com.skidata.uiPages.chbackoffice;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.helperclasses.MouseKeyboardHelper;
import com.skidata.helperclasses.WaitHelper;
import com.skidata.testBase.TestBase;

/**
 * @author shmo
 * Class containing the Web Element and method to login into the Chbackoffice application 
 */
public class LoginPageChbackOfficePage extends TestBase {
	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status = null;
	
	public LoginPageChbackOfficePage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

	}
	
	
	/**
	 ******************************************************************************************************
	 * Web Elements of the page
	 ******************************************************************************************************
	 */
	@FindBy(xpath = "//div[@class='task-close ng-scope']")
	public WebElement taskcloseicon;

	public static final Logger log = Logger.getLogger(LoginPageChbackOfficePage.class.getName());
	WaitHelper waithelper;

	//Tenant Name
	@FindBy(xpath = "//*[@id='username' and @placeholder='Email or Username']")
	public WebElement EmailorUsernamefield;

	//Login Name
	@FindBy(xpath = "//*[@id='password' and @placeholder='Password']")
	WebElement Passwordfield;

	//Login button
	@FindBy(xpath = "//button[@class='login-btn']")
	WebElement loginButton; 
	

	/**
	 * Method to click on X task header Control icon
	 */
	public void clickonXtaskHeaderControlicon() {
		taskcloseicon.click();
		log("clicked on the X icon in the Task Header label");
		takeScreenShot();
	}

	
	//Tenant Name
			@FindBy(xpath = "//input[@id='tenant']")
			WebElement Tenantfield;
	
	
	/*
	 * Method to Login into the application
	 */
	public void loginToApplication(String _Tenantname,String _EmailOrUsername,String _Password) throws InterruptedException, IOException {

		wh.waitForElementToBeClickable(EmailorUsernamefield, driver, 10);
		Tenantfield.sendKeys(_Tenantname);
		log("Entered Tenant Name as -> "+_Tenantname);
		
		EmailorUsernamefield.sendKeys(_EmailOrUsername);
		log("Entered Email or Username as -> "+_EmailOrUsername);

		Passwordfield.sendKeys(_Password);
		log("Entered Password as -> "+_Password);
		takeScreenShot();
		loginButton.click();   
		log("Clicked on the Login button");
		takeScreenShot(); 
	}
	
	

	



}
