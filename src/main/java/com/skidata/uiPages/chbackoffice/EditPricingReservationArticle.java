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
public class EditPricingReservationArticle extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;


	public static final Logger log = Logger.getLogger(EditPricingReservationArticle.class.getName());



	//Class constructor
	public EditPricingReservationArticle(WebDriver driver,ExtentTest test) {
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

	@FindBy(xpath = "//input[@v-model='model.article.name']")
	public WebElement ArticleName_inputfield;

	@FindBy(xpath = "//*[@id='price_component_page']//input")
	public WebElement input_Amount;
	
	@FindBy(xpath = "//*[@id='price_component_page']//input[2]")
	public WebElement input_Amount2;
	
	
	@FindBy(xpath = "//div[contains(@v-label,'SSPArticle.ArticleForm-Currency')]//div//span[@class='k-select']")
	public WebElement dropdown_currency;
	
	
	@FindBy(xpath = "//*[@id='price_component_page']//span[@translate='CH.ButtonSave']")
	public WebElement button_Save;
	
	public void enterBasePriceDetails(String _Amount,String _Currency,String _AdditionalPricingComponent) throws InterruptedException {
		
		Thread.sleep(4000);
		
		input_Amount.sendKeys("000");
		input_Amount2.clear();
		input_Amount2.sendKeys(_Amount);
		
		log("Amount entered is "+_Amount);
		
		dropdown_currency.click();
		Thread.sleep(4000);;
		 WebElement currency = driver.findElement(By.xpath("//li[text()='"+_Currency+"']"));
		 clickElementUsingJavaScript(currency);
		 log("Selected the currency "+currency);
		 takeScreenShot();
	}

	public void clickOnSave() {
		button_Save.click();
		log("Clicked on the save button in the Edit pricing page ");
		takeScreenShot();
		
	}

	
	


}