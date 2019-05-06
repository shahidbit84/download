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
 * @author shmo
 * 
 */
public class AddProductPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;


	public static final Logger log = Logger.getLogger(AddProductPage.class.getName());



	//Class constructor
	public AddProductPage(WebDriver driver,ExtentTest test) {
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
	public WebElement loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;


	@FindBy(xpath = "//input[@v-model='model.product.name']")
	public WebElement ProductName_inputfield;

	@FindBy(xpath = "//textarea[@v-model='model.product.description']")
	public WebElement ProductDescription_inputfield;


	@FindBy(xpath = "//div[contains(@v-label,'SSPProduct.LocaleSelector-LabelName')]//div//span[@class='k-input ng-scope']")
	public WebElement LocaleDropDown;

	@FindBy(xpath = "//li[@id='ssp_product_add_save']")
	public WebElement Save;

	@FindBy(xpath = "//li[@id='ssp_product_add_cancel']")
	public WebElement Cancel;

	@FindBy(xpath = "//p[@translate='SSPProduct.AddProductHeader']")
	public WebElement AddProductPageHeader;


	@FindBy(xpath = "//div[@v-model='model.product.localizedNames']//div[@id='button-icon']")
	public WebElement ProductNameLocalizedEarthIcon;

	@FindBy(xpath = "//div[@v-model='model.product.localizedDescriptions']//div[@id='button-icon']")
	public WebElement ProductDescriptionLocalizedEarthIcon;

	@FindBy(xpath = "//div[contains(@k-title,'Add localized names')]//div[contains(@v-label,'CHPortal.LocaleLabel')]//span[@class='k-input ng-scope']")
	public WebElement AddlocalizedNamesPopUP_localeDropdown;

	@FindBy(xpath = "//div[contains(@ k-title,'Add localized descriptions')]//div[contains(@v-label,'CHPortal.LocaleLabel')]//span[@class='k-input ng-scope']")
	public WebElement AddlocalizedDescriptionPopUP_localeDropdown;


	@FindBy(xpath = "//input[@v-locale='ui.locale.locale']")
	public WebElement AddlocalizedNamesPopUP_LocalizedNamesInputfield;

	@FindBy(xpath = "//div[contains(@k-title,'Add localized descriptions')]//textarea")
	public WebElement AddlocalizedNamesPopUP_LocalizedDescriptionInputfield;

	@FindBy(xpath = "//div[contains(@k-title,'Add localized names')]//button[@translate='VSMKendoMessages.SAVE']")
	public WebElement SaveLocalizedNames;

	@FindBy(xpath = "//div[contains(@k-title,'Add localized descriptions')]//button[@translate='VSMKendoMessages.SAVE']")
	public WebElement SaveLocalizeddescriptions;




	public void selectTenantLocale(String _TenantLocale) throws InterruptedException {

		clickElementUsingJavaScript(LocaleDropDown);
		WebElement selectTenantLocale = driver.findElement(By.xpath("//ul[@class='k-list k-reset']//li[contains(@class,'k-item ng-scope') and text()='"+_TenantLocale+"']"));
		Thread.sleep(8000);
		clickElementUsingJavaScript(selectTenantLocale);
		Thread.sleep(5000);
	}

	public String verifyIconLabelsAndHeader(String _SavelabelAddportfolio,String _CancellabelAddportfolio,String _HeaderAddProducts,
			String _AddProductName,String _HeaderAddProductAfterAddingName) {
		status="FAIL";

		if(Save.getText().equals(_SavelabelAddportfolio)) {
			log("Save button is displayed");
			if(Cancel.getText().equals(_CancellabelAddportfolio)) {
				log("Cancel button is displayed");

				if(AddProductPageHeader.getText().equals("Add product -  ")) {
					log(AddProductPageHeader.getText()+" header is displayed in UI");	
					ProductName_inputfield.sendKeys(_AddProductName);
					if(AddProductPageHeader.getText().trim().equals(_HeaderAddProductAfterAddingName.trim())) {
						log(AddProductPageHeader.getText()+" header is displayed in UI after Name is entered");
						status="PASS";
						takeScreenShot();
					}
				}
			}
		}
		return status;
	}


	/**
	 * Add product details
	 * @throws InterruptedException 
	 * @throws AWTException 
	 */

	public void addProductdetails(String _Name,String _Description) throws InterruptedException, AWTException {

		wh.waitForElementToBeClickable(ProductName_inputfield, driver, 10);
		ProductName_inputfield.sendKeys(_Name);
		log("Entered the Name as "+_Name);
		ProductDescription_inputfield.sendKeys(_Description);
		log("Entered the Description");
		takeScreenShot();
	}


	public void clickonAddLocalizedName() {
		ProductNameLocalizedEarthIcon.click();
		log("Clicked on the Add localized names icon");
		takeScreenShot();

	}

	public String verifyHeaderandIcons_AddlocalizedNamesPopUp(String _AddlocalizedNamesPopUpHeader) throws InterruptedException {
		status="FAIL";
		int popup = driver.findElements(By.xpath("//span[@class='k-window-title' and text()='"+_AddlocalizedNamesPopUpHeader+"']")).size();
		if(popup==1) {
			status="PASS";
		}
		return status;
	}


	public void addlocalizednamesDetails(String _localeForAddlocalizedNames,String _LocalizedName) throws InterruptedException {
		AddlocalizedNamesPopUP_localeDropdown.click();

		WebElement localevalue = driver.findElement(By.xpath("//div[8]/div/div[3]/ul/li[text()='"+_localeForAddlocalizedNames+"']"));
		wh.waitForElementToBeVisible(localevalue, driver, 10);
		Thread.sleep(4000);
		localevalue.click();
		log("Selected the locale of Add localized names as "+_localeForAddlocalizedNames);
		AddlocalizedNamesPopUP_LocalizedNamesInputfield.sendKeys(_LocalizedName);
		takeScreenShot();
		SaveLocalizedNames.click();
		log("Clicked on Save");

	}


	public void clickonAddLocalizedDescription() {
		wh.waitForElementToBeVisible(ProductDescriptionLocalizedEarthIcon, driver, 10);
		clickElementUsingJavaScript(ProductDescriptionLocalizedEarthIcon);
		log("Clicked on the Add localized Description icon");
		takeScreenShot();

	}

	public String verifyHeaderandIcons_AddlocalizedDescriptionPopUp(String _AddlocalizedDescriptionPopUpHeader) throws InterruptedException {
		status="FAIL";
		int popup = driver.findElements(By.xpath("//span[@class='k-window-title' and text()='"+_AddlocalizedDescriptionPopUpHeader+"']")).size();
		if(popup==1) {
			status="PASS";
		}
		return status;
	}

	public void addlocalizedDescriptionDetails(String _localeForAddlocalizedDescription,String _LocalizedNameDescription) throws InterruptedException {
		AddlocalizedDescriptionPopUP_localeDropdown.click();

		WebElement localevalue = driver.findElement(By.xpath("//div[10]/div/div[3]/ul/li[text()='"+_localeForAddlocalizedDescription+"']"));
		Thread.sleep(4000);
		localevalue.click();
		log("Selected the locale of Add localized names as "+_localeForAddlocalizedDescription);
		AddlocalizedNamesPopUP_LocalizedDescriptionInputfield.sendKeys(_LocalizedNameDescription);
		takeScreenShot();
		SaveLocalizeddescriptions.click();
		log("Clicked on Save");


	}



	public void clickonSave() throws InterruptedException {
		Thread.sleep(5000);
		Save.click();

	}


}