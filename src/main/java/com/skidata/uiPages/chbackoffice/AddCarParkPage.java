/**
 *
 */
package com.skidata.uiPages.chbackoffice;

import java.awt.AWTException;

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
 * @author Sreelakshmi
 * 
 */
public class AddCarParkPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;


	public static final Logger log = Logger.getLogger(AddCarParkPage.class.getName());



	//Class constructor
	public AddCarParkPage(WebDriver driver,ExtentTest test) {
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

	@FindBy(xpath = "//div[contains(@v-label,'SSPCarPark.FormLabel-Facility')]//div//span[text()='--- Select ---']")
	public WebElement FacilityDropdown;


	@FindBy(xpath = "//input[@ng-model='model.carPark.name']")
	public WebElement Name_inputfield;

	@FindBy(xpath = "//input[@ng-model='model.carPark.bays']")
	public WebElement Bays_inputfield;

	@FindBy(xpath = "//input[@ng-model='model.carPark.latitude']")
	public WebElement Latitude_inputfield;

	@FindBy(xpath = "//input[@ng-model='model.carPark.longitude']")
	public WebElement Longitude_inputfield;


	@FindBy(xpath = "//li[@id='ssp_carpark_add_save']")
	public WebElement Save;

	@FindBy(xpath = "//div[@class='task-close ng-scope']")
	public WebElement taskcloseicon;
	
	/**
	 * Method to click on X task header Control icon
	 */
	public void clickonXtaskHeaderControlicon() {
		taskcloseicon.click();
		log("clicked on the X icon in the Task Header label");
		takeScreenShot();
	}
	
	//****************************************************************************************************************

	public void selectLocale(String _LocaleValue) {
		driver.findElement(By.xpath("//div[contains(@v-label,'SSPUnits.LocaleSelector-LabelName')]//span[@class='k-widget k-dropdown k-header ng-scope']")).click();
		WebElement locale = driver.findElement(By.xpath("//li[text()='"+_LocaleValue+"']"));
		clickElementUsingJavaScript(locale);
	}





	/**
	 * Click on the + Add new car park
	 * @throws InterruptedException 
	 * @throws AWTException 
	 */
	public void addCarParkdetails(String _FacilityValueCarPark,String _Name,String _Bays,String _Latitude,String _Longitude) throws InterruptedException, AWTException {

		FacilityDropdown.click();

		WebElement FacilityValue = driver.findElement(By.xpath("//li[@class='k-item ng-scope' and text()='"+_FacilityValueCarPark+"']"));
		wh.waitForElementToBeVisible(FacilityValue, driver, 10);
		clickElementUsingJavaScript(FacilityValue);
		log("Selected the facility value as "+_FacilityValueCarPark);
		
		Name_inputfield.sendKeys(_Name);
		mkh.pressTabKeyAndRelease();

		try {
			log("Entered the Name as "+_Name);
			Bays_inputfield.sendKeys(_Bays);
			mkh.pressTabKeyAndRelease();

			log("Entered the Bays as "+_Bays);
			Latitude_inputfield.sendKeys(_Latitude);
			mkh.pressTabKeyAndRelease();

			log("Entered the Latitude as "+_Latitude);
			Longitude_inputfield.sendKeys(_Longitude);
			mkh.pressTabKeyAndRelease();

			log("Entered the Longitude as "+_Longitude);

		}catch(Exception e) {

		}
	}

	public void clickonSave() {
		wh.waitForElementToBeClickable(Save, driver, 10);
		Save.click();

	}

}
