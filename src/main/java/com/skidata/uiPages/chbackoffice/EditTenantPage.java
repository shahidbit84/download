/**
 *
 */
package com.skidata.uiPages.chbackoffice;

import java.awt.AWTException;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.helperclasses.DateAndUniqueNoGenerateHelper;
import com.skidata.helperclasses.MouseKeyboardHelper;
import com.skidata.helperclasses.WaitHelper;
import com.skidata.testBase.TestBase;

/**
 * @author shmo
 * The repository for swebWalletTenants App Main Page
 */
public class EditTenantPage extends TestBase {

	
	String uniqueNo=null;
	String TenantUniqueName=null;
	DateAndUniqueNoGenerateHelper date = new DateAndUniqueNoGenerateHelper();
	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);



	public static final Logger log = Logger.getLogger(EditTenantPage.class.getName());
	String status=null;


	//Class constructor
	public EditTenantPage(WebDriver driver,ExtentTest test) {
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

	@FindBy(xpath = "//input[@ng-model='ui.name']")
	public WebElement Name_inputfield;

	@FindBy(xpath = "//div[@class='v-multiselect ng-scope ng-isolate-scope' and @v-data-source='model.locales' and @v-selected-items='ui.supportedLanguages']")
	public WebElement Supported_languages_inputfield;

	@FindBy(xpath = "//div[contains(@v-label,'SSPTenant.TenantForm-BaseLanguage')]//span[@class='k-dropdown-wrap k-state-default']")
	public WebElement Baselanguage_selectDropDown;

	@FindBy(xpath = "//div[contains(@v-label,'SSPTenant.TenantForm-Currencies')]/div/div/div/div[2]/div")
	public WebElement SupportedCurrenciesDropDown;

	@FindBy(xpath = "//div[contains(@v-label,'SSPTenant.TenantForm-BaseCurrency')]/div/div/span/span/span")
	public WebElement BasecurrencyDropDown;


	@FindBy(xpath = "//li[@id='ssp_tenant_edit_save']")
	public WebElement Savebutton;

	@FindBy(xpath = "ssp_tenant_edit_cancel")
	public WebElement Cancelbutton;


	@FindBy(xpath = "//div[@class='v-application-title ng-scope']//p")
	public WebElement EditTenantpageHeader;

	/**
	 * Method to add the Tenant details
	 * @param _TenantName
	 * @param _Supportedlanguages
	 * @return 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	public String addTenantDetails(String _TenantName, String _Supportedlanguages,String _Baselanguage,String _SupportedCurrencies,String _BaseCurrency) throws InterruptedException, AWTException {
		uniqueNo = date.generateUniqueNo();
		log("unique no is generated "+uniqueNo);
		wh.waitForElementToBeClickable(Name_inputfield, driver, 10);
		TenantUniqueName =_TenantName+uniqueNo;
		Name_inputfield.sendKeys(TenantUniqueName);
		log("Entered Tenant Name As "+TenantUniqueName);
		addSupportedLanguages(_Supportedlanguages);

		selectBaseLanguage(_Baselanguage);
		addSupportedCurrencies(_SupportedCurrencies);
		selectBaseCurrency(_BaseCurrency);
		takeScreenShot();
		return TenantUniqueName;
	}


	/**
	 * Method to add the Tenant details
	 * @param _TenantName
	 * @param _Supportedlanguages
	 * @return 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	public void editTenantDetails(String _TenantName, String _Supportedlanguages,String _Baselanguage,String _SupportedCurrencies,String _BaseCurrency) throws InterruptedException, AWTException {
//		uniqueNo = date.generateUniqueNo();
//		log("unique no is generated "+uniqueNo);
//		wh.waitForElementToBeClickable(Name_inputfield, driver, 10);
//		TenantUniqueName =_TenantName+uniqueNo;
//		Name_inputfield.clear();
//		Name_inputfield.sendKeys(TenantUniqueName);
//		log("Entered Tenant Name As "+TenantUniqueName);

		addSupportedLanguages(_Supportedlanguages);

		selectBaseLanguage(_Baselanguage);
		addSupportedCurrencies(_SupportedCurrencies);
		selectBaseCurrency(_BaseCurrency);
		takeScreenShot();
		
	}

	/**
	 * Method to Add the supported languages
	 * @param supported_language
	 * @throws InterruptedException
	 * @throws AWTException 
	 * @throws r 
	 */
	public void addSupportedLanguages(String _Supported_language) throws InterruptedException, AWTException {

		log("Select the supported language");

		String[] items = _Supported_language.split(",");
		List<String> itemList = Arrays.asList(items);

		for (String temp : itemList) {
			Supported_languages_inputfield.click();
			log("clicked on the support language input field");
			WebElement lang = driver.findElement(By.xpath("//span[@class='v-label ng-scope' and  @translate='"+temp+"' and @translate-values='labelParameters']"));
			wh.waitForElementToBeClickable(lang, driver, 10);
			clickElementUsingJavaScript(lang);
			log("Selected the Language as "+temp);

		}
		takeScreenShot();

	}


	/**
	 * Method to Select the Base Language
	 * @param _BaseLang
	 */
	public void selectBaseLanguage(String _BaseLang) {
		clickElementUsingJavaScript(Baselanguage_selectDropDown);
		log("Base language select dropdown is clicked");
		WebElement baselangValueToSelect = driver.findElement(By.xpath("//div[@class='k-animation-container'][2]//div//ul//span[@class='v-label ng-scope' and text()='"+_BaseLang+"']"));	
		wh.waitForElementToBeClickable(baselangValueToSelect, driver, 10);
		clickElementUsingJavaScript(baselangValueToSelect);
		log("Base language value is selected as "+_BaseLang);
		takeScreenShot();

	}

	/**
	 * Method to Add Supported Currencies
	 * @param _Currencies
	 */
	public void addSupportedCurrencies(String _Currencies) {
		String[] items = _Currencies.split(",");
		List<String> itemList = Arrays.asList(items);
		for (String temp : itemList) {
			SupportedCurrenciesDropDown.click();
			WebElement currencyToSelect = driver.findElement(By.xpath("//span[text()='"+temp+"'][1]"));		
			wh.waitForElementToBeClickable(currencyToSelect, driver, 10);
			clickElementUsingJavaScript(currencyToSelect);
			log("The following currency is selected "+temp);


		}
		takeScreenShot();

	}

	/**
	 * Method to Select Base Currency
	 * @param _BaseCurrency
	 */
	public void selectBaseCurrency(String _BaseCurrency) {
		wh.waitForElementToBeClickable(BasecurrencyDropDown, driver, 10);
		clickElementUsingJavaScript(BasecurrencyDropDown);
		log("Base currency drop down in clicked");
		WebElement basecurrencyToSelect = driver.findElement(By.xpath("//div/div[3]/ul/li/label[contains(@v-label,'"+_BaseCurrency+"')]"));
		clickElementUsingJavaScript(basecurrencyToSelect);
		log("Base currency value selected as "+_BaseCurrency);
		takeScreenShot();
	}

	/**
	 * Method to click on Save button icon
	 */
	public void clickonSave() {
		wh.waitForElementToBeClickable(Savebutton, driver, 10);
		Savebutton.click();
		log("clicked on the Save button");
		takeScreenShot();
	}


	public void clickonCancel() {
		wh.waitForElementToBeClickable(Cancelbutton, driver, 10);
		Cancelbutton.click();
		log("clicked on the Cancel button");
		takeScreenShot();

	}







}

