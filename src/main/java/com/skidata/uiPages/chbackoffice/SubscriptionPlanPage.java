/**
 *
 */
package com.skidata.uiPages.chbackoffice;

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
 * 
 */
public class SubscriptionPlanPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;


	public static final Logger log = Logger.getLogger(SubscriptionPlanPage.class.getName());



	//Class constructor
	public SubscriptionPlanPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

	}
	


	/**
	 ******************************************************************************************************
	 * Web Elements of the page
	 ******************************************************************************************************
	 */

	@FindBy(xpath = "//span[@class='v-label' and text()='LOADING...']")
	public WebElement loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;

	
	@FindBy(xpath = "//*[@id='ssp_article_subscription_add']")
	public WebElement addSubscriptionPlanIcon;
	
	
	@FindBy(xpath = "//div[contains(@v-label,'SSPArticle.subscriptionFormColumnHeader-PlanType')]//div//span[@class='k-icon k-i-arrow-s']")
	public WebElement dropdown_PlanType;
	
	
	public void clickOnAddIcon() {
		addSubscriptionPlanIcon.click();
		log("clicked on the add subscription icon");
	}
	
	
	
	
	public void addPPUPlan() {
		clickElementUsingJavaScript(dropdown_PlanType);
		log("Clicked on the Plan type dropdown");
		
		WebElement PPU = driver.findElement(By.xpath("//li[text()='PPU']"));
		clickElementUsingJavaScript(PPU);
		takeScreenShot();
		
	}


	
	@FindBy(xpath = "//*[@id='ssp_article_subscription_cancel']")
	public WebElement cancel;
	public void clickOnCancel() {
	
		cancel.click();
		log("Clicked on the Cancel in the Subscription plan page.");
		
	}


}