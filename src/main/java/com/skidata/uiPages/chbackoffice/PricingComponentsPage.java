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
public class PricingComponentsPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;


	public static final Logger log = Logger.getLogger(PricingComponentsPage.class.getName());



	//Class constructor
	public PricingComponentsPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

	}

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

	/**
	 ******************************************************************************************************
	 * Web Elements of the page
	 ******************************************************************************************************
	 */

	@FindBy(xpath = "//span[@class='v-label' and text()='LOADING...']")
	public WebElement progressBar_loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement progressBar_savingprogress;

	@FindBy(xpath = "//*[@id='app']/div[1]/div[2]/p")
	public WebElement pageHeader_PricingComponents;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='Baseprice']")
	public WebElement label_Baseprice;

	@FindBy(xpath = "//div[contains(@v-label,'SSPArticle.ArticleForm-Amount')]//div//span//input")
	public WebElement inputField_Amount;

	@FindBy(xpath = "html/body/div[3]/div[2]/div/form/div[1]/div[3]/div/div/span/span/span[1]")
	public WebElement dropDown_Currency;


	@FindBy(xpath = "//span[@translate='CH.ButtonSave']")
	public WebElement button_Save;

	@FindBy(xpath = "//span[@translate='CH.ButtonCancel']")
	public WebElement button_Cancel;
	
	
	@FindBy(xpath = "//div[@v-on-click='addToArticle(model.selectedPriceComponent)']")
	public WebElement icon_PlusToAddCommissionOrDiscount;
	
	@FindBy(xpath = "//div[@ng-if='model.articlePriceComponents && model.articlePriceComponents.length > 0']/div[1]//input[1]")
	public WebElement input_Commission;
	
	
	@FindBy(xpath = "//div[@ng-if='model.articlePriceComponents && model.articlePriceComponents.length > 0']/div[2]//input[1]")
	public WebElement input_Discount;

	public String verifyIconAndHeaderLabel(String _PricingComponentPageHeader,String _BasePriceLabel,String _SaveButton,String _CancelButton) {
		status="FAIL";
		if(pageHeader_PricingComponents.getText().equals(_PricingComponentPageHeader)) {
			log(pageHeader_PricingComponents.getText()+" is displayed in UI");
			if(label_Baseprice.getText().equals(_BasePriceLabel)) {
				log(label_Baseprice.getText()+" is displayed in UI");
				if(button_Save.getText().equals(_SaveButton)) {
					log(button_Save.getText()+" is displayed in UI");
					if(button_Cancel.getText().equals(_CancelButton)) {
						log(button_Cancel.getText()+" is displayed in UI");
						status="PASS";
						takeScreenShot();
						status="PASS";
					}
				}
			}
		}
		return status;

	}

	public void addPricingDetailsCommissionAndDiscount(String _Amount,String _Currency,String _CommissionPercentage,String _DiscountPercentage) throws InterruptedException {
		status="FAIL";


		inputField_Amount.sendKeys(_Amount);
		log("Entered the Amount as "+_Amount);

		clickElementUsingJavaScript(dropDown_Currency);

		WebElement currency = driver.findElement(By.xpath("//li[text()='"+_Currency+"']"));
		Thread.sleep(5000);
		wh.waitForElementToBeClickable(currency, driver, 20);
		clickElementUsingJavaScript(currency);

		WebElement commissionDropDown = driver.findElement(By.xpath("//span[@class='k-input ng-scope' and text()='Commission']"));
		clickElementUsingJavaScript(commissionDropDown);
		WebElement commission = driver.findElement(By.xpath("//li[text()='Commission']"));

		Thread.sleep(8000);
		wh.waitForElementToBeClickable(commission, driver, 30);
		clickElementUsingJavaScript(commission);

		icon_PlusToAddCommissionOrDiscount.click();
		input_Commission.sendKeys(_CommissionPercentage);

		driver.findElement(By.xpath("//span[@class='k-input ng-scope' and text()='Discount']")).click();
		WebElement discount = driver.findElement(By.xpath("//li[text()='Discount']"));
		wh.waitForElementToBeClickable(discount, driver, 30);
		Thread.sleep(8000);
		clickElementUsingJavaScript(discount);
		icon_PlusToAddCommissionOrDiscount.click();
		input_Discount.sendKeys(_DiscountPercentage);
		
	}

	public void clickOnSave() {
		wh.waitForElementToBeClickable(button_Save, driver, 10);
		button_Save.click();
	}

	

}