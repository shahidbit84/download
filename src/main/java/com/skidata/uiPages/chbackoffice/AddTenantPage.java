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
public class AddTenantPage extends TestBase {

	
	String uniqueNo=null;
	String TenantUniqueName=null;
	DateAndUniqueNoGenerateHelper date = new DateAndUniqueNoGenerateHelper();
	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);



	public static final Logger log = Logger.getLogger(AddTenantPage.class.getName());
	String status=null;


	//Class constructor
	public AddTenantPage(WebDriver driver,ExtentTest test) {
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


	@FindBy(xpath = "//li[@id='ssp_tenant_add_save']")
	public WebElement Savebutton;

	@FindBy(xpath = "//li[@id='ssp_tenant_add_cancel']")
	public WebElement Cancelbutton;
	
//	@FindBy(xpath = "//div[@class='v-progress-window ng-scope k-window-content k-content']//span[@translate='VSMCommon.ProgressLoading']")
//	public WebElement loadingprogress;
//
//	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
//	public WebElement savingprogress;

	@FindBy(xpath = "//li[@id='ssp_tenant_psp']")
	public WebElement paymentserviceproviderButton;
	
	
	@FindBy(xpath = "//*[@id='ssp_tenant_psp_pspPaymentPageUrl']")
	public WebElement paymentPageURL;

	@FindBy(xpath = "//*[@id='ssp_tenant_psp_signatureKey']")
	public WebElement SignatureKey_inputfield;

	@FindBy(xpath = "//*[@id='ssp_tenant_psp_pspServiceUrl']")
	public WebElement PSPserviceURL_inputfield;

	@FindBy(xpath = "//*[@id='ssp_tenant_psp_loginId']")
	public WebElement LoginId_inputfield;

	@FindBy(xpath = "//*[@id='ssp_tenant_psp_password']")
	public WebElement Password_inputfield;
	
	@FindBy(xpath = "//*[@id='serviceURL']")
	public WebElement serviceURL_inputfield;
	
	@FindBy(xpath = "//*[@id='customerID']")
	public WebElement CustomerField_inputfield;
	
	
	@FindBy(xpath = "//input[@id='seamlessUrl']")
	public WebElement SeamlessURL_inputfield;
	
	
	@FindBy(xpath = "//input[@id='shopId']")
	public WebElement ShopId_inputfield;

	@FindBy(xpath = "//*[@id='BusinessCaseSignature']")
	public WebElement BusinessCaseSignature_inputfield;
	
	@FindBy(xpath = "//*[@id='PSPID']")
	public WebElement PSPID_inputfield;
	
	
	@FindBy(xpath = "//input[@id='PxPayKey']")
	public WebElement PxPayKey_inputfield;
	
	@FindBy(xpath = "//input[@id='PxPayUrl']")
	public WebElement PxPayUrl_inputfield;
	
	@FindBy(xpath = "//input[@id='PxPayUserId']")
	public WebElement PxPayUserId_inputfield;
	
	@FindBy(xpath = "//input[@id='PxPostKey']")
	public WebElement PxPostKey_inputfield;
	
	@FindBy(xpath = "//input[@id='PxPostUrl']")
	public WebElement PxPostUrl_inputfield;
	
	@FindBy(xpath = "//input[@id='PxPostUserId']")
	public WebElement PxPostUserId_inputfield;
	
	

	@FindBy(xpath = "//*[@id='ssp_tenant_cancel']")
	public WebElement Payment_cancel;


	@FindBy(xpath = "//*[@id='ssp_tenant_save']")
	public WebElement Payment_Save;


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
		//log("unique no is generated "+uniqueNo);
		wh.waitForElementToBeClickable(Name_inputfield, driver, 10);
		TenantUniqueName =_TenantName+uniqueNo;
//		TenantUniqueName =_TenantName;
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
	public String editTenantDetails(String _TenantName, String _Supportedlanguages,String _Baselanguage,String _SupportedCurrencies,String _BaseCurrency) throws InterruptedException, AWTException {
		uniqueNo = date.generateUniqueNo();
		log("unique no is generated "+uniqueNo);
		wh.waitForElementToBeClickable(Name_inputfield, driver, 10);
		TenantUniqueName =_TenantName+uniqueNo;
		Name_inputfield.clear();
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
	 * @throws InterruptedException 
	 */
	public void selectBaseCurrency(String _BaseCurrency) throws InterruptedException {
		wh.waitForElementToBeClickable(BasecurrencyDropDown, driver, 10);
		clickElementUsingJavaScript(BasecurrencyDropDown);
		log("Base currency drop down in clicked");
		WebElement basecurrencyToSelect = driver.findElement(By.xpath("//div/div[3]/ul/li/label[contains(@v-label,'"+_BaseCurrency+"')]"));
		Thread.sleep(2000);
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
	
	/**
	 * Method to click/ select the Newly created Teant
	 * 
	 */
	
	public void singleclickOnNewlycreatedTenant(String _NewlyCreatedTenant){
		driver.findElement(By.xpath("//span[text()='"+_NewlyCreatedTenant+"']")).click();
		log("clicked on the Newly created Tenant");
		takeScreenShot();
		
	}
	
	/**
	 * Method to add the wirecard payment service 
	 * @throws InterruptedException 
	 */
	public void addPaymentDetails(String _PaymenPageURL,String _SignatureKey,String _PSPServiceURL,String _LoginId,String _Password,String _CustomerID,
			String _ServiceURL,String _seamless_URL, String _BusinessCaseSignature, String _Mode, String _shopId) throws InterruptedException {

		Thread.sleep(3000);
		
		paymentPageURL.sendKeys(_PaymenPageURL);
		
		SignatureKey_inputfield.sendKeys(_SignatureKey);
		
		PSPserviceURL_inputfield.sendKeys(_PSPServiceURL);
		
		LoginId_inputfield.sendKeys(_LoginId);
		
		Password_inputfield.sendKeys(_Password);
		
		CustomerField_inputfield.sendKeys(_CustomerID);
		
		serviceURL_inputfield.sendKeys(_ServiceURL);
		
		SeamlessURL_inputfield.sendKeys(_seamless_URL);
		
		BusinessCaseSignature_inputfield.sendKeys(_BusinessCaseSignature);
		
		// select mode in PSP page of Addiitonl settings
		driver.findElement(By.xpath("//span[text()='mode']/../..//span[text()='select']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='"+_Mode+"']")).click();
		
		
		ShopId_inputfield.sendKeys(_shopId);
		
		Payment_Save.click();
	}
	
	/**
	 * Method to add the ingenico payment service 
	 * @throws InterruptedException 
	 */
	public void addIngenicoPaymentDetails(String _PaymenPageURL,String _SignatureKey,String _ServiceURL,String _LoginId,String _Password,String _PSPId) throws InterruptedException {

		Thread.sleep(3000);
		// select mode in PSP page of Addiitonl settings
		driver.findElement(By.xpath("//*[@id='payment_setup_page']//div[contains(@v-label,'SSPTenant.PspForm-moduleKey')]//span[@class='k-dropdown-wrap k-state-default']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'IngenicoPaymentService')]")).click();
				
	
		paymentPageURL.sendKeys(_PaymenPageURL);
		
		SignatureKey_inputfield.sendKeys(_SignatureKey);
		
		PSPserviceURL_inputfield.sendKeys(_ServiceURL);
		
		LoginId_inputfield.sendKeys(_LoginId);
		
		Password_inputfield.sendKeys(_Password);
	
		PSPID_inputfield.sendKeys(_PSPId);
		
	
		Payment_Save.click();
	}
	
	/**
	 * Method to add the paymentExpress  service 
	 * @throws InterruptedException 
	 */
	public void addPaymentExpressPaymentDetails(String _PaymenPageURL,String _PxPayKey,String _PxPayURL,String _PxPayUserId,String _PxPostKey,String _PxPostUrl,String _PxPostUserId) throws InterruptedException {

		Thread.sleep(3000);
		// select mode in PSP page of Addiitonl settings
		driver.findElement(By.xpath("//*[@id='payment_setup_page']//div[contains(@v-label,'SSPTenant.PspForm-moduleKey')]//span[@class='k-dropdown-wrap k-state-default']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'PaymentExpressPaymentService')]")).click();
				
	
		paymentPageURL.sendKeys(_PaymenPageURL);
		
		PxPayKey_inputfield.sendKeys(_PxPayKey);
		
		PxPayUrl_inputfield.sendKeys(_PxPayURL);
		
		PxPayUserId_inputfield.sendKeys(_PxPayUserId);
		
		PxPostKey_inputfield.sendKeys(_PxPostKey);
	
		PxPostUrl_inputfield.sendKeys(_PxPostUrl);
		
		PxPostUserId_inputfield.sendKeys(_PxPostUserId);
		
		
		Payment_Save.click();
	}
	
	
	//****************************************************************************************************************


	/**
	 * To cancel the payment page 
	 */
	public void clickOnCancel() {
		wh.waitForElementToBeClickable(Payment_cancel, driver, 10);
		Payment_cancel.click();
	}

	/**
	 * Click on Payment service Provider Button
	 */
	public void clickOnPaymentServiceProvider() {
		paymentserviceproviderButton.click();
	}
	
	
}






