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
public class AddSubscriptionPlanDetails extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;


	public static final Logger log = Logger.getLogger(AddSubscriptionPlanDetails.class.getName());



	//Class constructor
	public AddSubscriptionPlanDetails(WebDriver driver,ExtentTest test) {
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
	
	@FindBy(xpath = "//li[@id='ssp_article_addplan_parkingrate_add']/label/span[1]")
	public WebElement addParkingRate;
	
	
	@FindBy(xpath = "//li[@id='ssp_article_addplan_save']/label/span[1]")
	public WebElement Save;
	
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
		
		WebElement MinimumValidity = driver.findElement(By.xpath("//div[contains(@v-label,'SSPArticle.subscriptionFormColumnHeader-MinimumValidity')]//input"));
		MinimumValidity.sendKeys("5");
	}

	
	public void addFlatPlan() {
		clickElementUsingJavaScript(dropdown_PlanType);
		log("Clicked on the Plan type dropdown");
		
		WebElement FLAT = driver.findElement(By.xpath("//li[text()='FLAT']"));
		clickElementUsingJavaScript(FLAT);
		takeScreenShot();
		
		WebElement MinimumValidity = driver.findElement(By.xpath("//div[contains(@v-label,'SSPArticle.subscriptionFormColumnHeader-MinimumValidity')]//input"));
		MinimumValidity.sendKeys("5");
		
		WebElement flatPrice = driver.findElement(By.xpath("//div[contains(@v-label,'SSPArticle.subscriptionFormColumnHeader-Price')]//input"));
		flatPrice.sendKeys("3");
		
//		WebElement flatCurrencyDropDown = driver.findElement(By.xpath("//div[contains(@v-label,'SSPArticle.subscriptionFormColumnHeader-Price')]//span[2]"));
//		flatCurrencyDropDown.click();
		
		
		WebElement isDefaultPlan = driver.findElement(By.xpath("//*[@id='add_plan_page']/div[2]/div/form[1]/div[7]/div/div/div/label"));
		
		clickElementUsingJavaScript(isDefaultPlan);
	}



	public void clickOnAddParkingRate() {
		addParkingRate.click();
		log("Clicked on Add parking rate");
		takeScreenShot();
		
	}


	@FindBy(xpath = "//div[contains(@v-label,'SSPArticle.parkingRateFormColumnHeader-Start')]//input")
	public WebElement addParkingRate_Start;
	
	@FindBy(xpath = "//div[contains(@v-label,'SSPArticle.parkingRateFormColumnHeader-End')]//input")
	public WebElement addParkingRate_End;
	
	
	@FindBy(xpath = "//div[@v-model='model.parkingRate.endCanBeOfMoreType']")
	public WebElement MoreCheckbox;
	
	
	@FindBy(xpath = "//div[contains(@v-label,'SSPArticle.parkingRateFormColumnHeader-Price')]//input")
	public WebElement Price;
	
	
	@FindBy(xpath = "//div[contains(@v-label,'CH.ButtonSave')]")
	public WebElement button_Save_AddParkingRate;
	
	public void addParkingRateDetails() {
		addParkingRate_Start.sendKeys("0");
		addParkingRate_End.sendKeys("5");
		//MoreCheckbox.click();
		
		WebElement RateTypeDropDown = driver.findElement(By.xpath("//div[contains(@v-label,'SSPArticle.parkingRateFormColumnHeader-RateType')]//span[@class='k-select']"));
		RateTypeDropDown.click();
		
		
		WebElement RateType = driver.findElement(By.xpath("//li[text()='HOURS']"));
		wh.waitForElementToBeClickable(RateType, driver, 20);
		clickElementUsingJavaScript(RateType);
		log("Selected Rate type as ");
		
		Price.sendKeys("2");
		
		button_Save_AddParkingRate.click();
	}




	public void clickOnSave() {
		
		clickElementUsingJavaScript(Save);
		log("Clicked on Save in the Add subscription plan page");
		takeScreenShot();
		
	}


}