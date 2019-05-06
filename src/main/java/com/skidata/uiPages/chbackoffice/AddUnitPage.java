/**
 *
 */
package com.skidata.uiPages.chbackoffice;

import java.awt.AWTException;
import java.util.List;

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
public class AddUnitPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status;


	public static final Logger log = Logger.getLogger(AddUnitPage.class.getName());



	//Class constructor
	public AddUnitPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

	}



	//****************************************************************************************************************
	@FindBy(xpath = "//span[@class='v-label' and text()='LOADING...']")
	public WebElement loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;

	@FindBy(xpath = "//div[contains(@v-label,'SSPUnits.UnitsForm-parent')]/div/div//span[text()='--- Select ---']")
	public WebElement ParentDropdown;


	@FindBy(xpath = "//input[@ng-model='model.unit.name']")
	public WebElement Name_inputfield;

	@FindBy(xpath = "//textarea[@ng-model='inputValue' and @v-model='model.unit.localizedDescription']")
	public WebElement Description_textarea;

	@FindBy(xpath = "//div[contains(@v-label,'SSPUnits.UnitsForm-baseLocale')]/div/div//span[text()='--- Select ---']")
	public WebElement Baselocale_dropdown;

	@FindBy(xpath = "//div[contains(@v-label,'SSPUnits.UnitsForm-secondaryCurrencies')]//div[@v-data-source='model.secondaryCurrencies']//div[2]")
	public WebElement Secondarycurrencies_DropDown;

	@FindBy(xpath = "//input[@on-place-changed='addressSelected()' and  @placeholder='Enter a location']")
	public WebElement Searchaddress_inputfield;

	@FindBy(xpath = "//input[@id='buildingNumber' and @ ng-model='model.unit.manualAddress.buildingNumber']")
	public WebElement buildingNumber;

	@FindBy(xpath = "//input[@id='buildingName' and @ ng-model='model.unit.manualAddress.buildingName']")
	public WebElement buildingName;

	@FindBy(xpath = "//input[@id='streetNumber' and @ ng-model='model.unit.manualAddress.streetNumber']")
	public WebElement streetNumber;

	@FindBy(xpath = "//input[@id='streetName' and @ ng-model='model.unit.manualAddress.streetName']")
	public WebElement streetName;

	@FindBy(xpath = "//input[@id='route' and @ ng-model='model.unit.manualAddress.route']")
	public WebElement route;

	@FindBy(xpath = "//input[@id='subLocality' and @ ng-model='model.unit.manualAddress.subLocality']")
	public WebElement subLocality;

	@FindBy(xpath = "//input[@id='locality' and @ ng-model='model.unit.manualAddress.locality']")
	public WebElement locality;

	@FindBy(xpath = "//input[@id='county' and @ ng-model='model.unit.manualAddress.county']")
	public WebElement county;

	@FindBy(xpath = "//input[@id='province' and @ ng-model='model.unit.manualAddress.province']")
	public WebElement province;
	
	@FindBy(xpath = "//input[@id='country' and @ ng-model='model.unit.manualAddress.country']")
	public WebElement country;

	@FindBy(xpath = "//input[@id='postalCode' and @ ng-model='model.unit.manualAddress.postalCode']")
	public WebElement postalCode;

	@FindBy(xpath = "//li[@id='ssp_units_add_save']")
	public WebElement Save;
	
	@FindBy(xpath = "//li[@id='ssp_units_add_cancel']")
	public WebElement Cancel;


	//****************************************************************************************************************

	public void selectLocale(String _LocaleValue) {
		driver.findElement(By.xpath("//div[@id='ssp_units_add_locale']/span/span")).click();
		WebElement locale = driver.findElement(By.xpath("//li[text()='"+_LocaleValue+"']"));
		clickElementUsingJavaScript(locale);
	}





	/**
	 * Click on the + Add new Headquarter
	 * @throws InterruptedException 
	 */
	public void addUnitDetails(String ParentUnit,String _Name,String _Description,String _BaseLocale,String _BaseCurrency,String _SecondaryCurrency) throws InterruptedException {

		Thread.sleep(3000);
		ParentDropdown.click();

		WebElement parentunitValue = driver.findElement(By.xpath("//li[@class='k-item ng-scope' and text()='"+ParentUnit+"']"));
		wh.waitForElementToBeVisible(parentunitValue, driver, 10);
		clickElementUsingJavaScript(parentunitValue);


		Name_inputfield.sendKeys(_Name);
		Description_textarea.sendKeys(_Description);

		clickElementUsingJavaScript(Baselocale_dropdown);
		WebElement baselocale = driver.findElement(By.xpath("//li[@class='k-item ng-scope' and text()='"+_BaseLocale+"']"));
		clickElementUsingJavaScript(baselocale);

		
		WebElement basecurrency = driver.findElement(By.xpath("//div[contains(@v-label,'SSPUnits.UnitsForm-baseCurrency')]//option[text()='"+_BaseCurrency+"']"));
		Thread.sleep(3000);
		clickElementUsingJavaScript(basecurrency);

		WebElement basecurrValueToSelect = driver.findElement(By.xpath("//ul[@id='units_add_page_unit_currency_listbox']/li[contains(text(),'"+_BaseCurrency+"')]"));
		clickElementUsingJavaScript(basecurrValueToSelect);

		//		WebElement scv = driver.findElement(By.xpath("//li[@class='k-item ng-scope k-state-focused' and text()='"+_SecondaryCurrency+"']"));
		//		Thread.sleep(3000);
		//		clickElementUsingJavaScript(scv);

//		String[] items = _SecondaryCurrency.split(",");
//		List<String> itemList = Arrays.asList(items);
//		for (String temp : itemList) {
//			//Secondarycurrencies_DropDown.click();
//			WebElement seccurrencyToSelect = driver.findElement(By.xpath("//li[@class='k-item ng-scope k-state-focused' and text()='"+temp+"']"));		
//			//wh.waitForElementToBeClickable(seccurrencyToSelect, driver, 10);
//			clickElementUsingJavaScript(seccurrencyToSelect);
//			Thread.sleep(3000);
//			log("The following currency is selected "+temp);
//
//		}
	}

	//****************************************************************************************************************

	public void enterSearchAddress(String _SearchAddress,String _Buildingnumber,String _BuildingName,String _StreetNo,String _StreetName,
			String _Route,String _Sublocality,String _Locality,String _County,String _Province,String _Country,String _Pin) throws AWTException, InterruptedException
	{


		Searchaddress_inputfield.sendKeys(_SearchAddress);
		Thread.sleep(5000);
		//		MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver);
		//		mkh.pressDownArrowKeyAndRelease();
		//		Thread.sleep(3000);
		//		mkh.pressEnterKeyAndRelease();
		//		
		//		pressTab();
		
		
		List<WebElement> search = driver.findElements(By.xpath("//div[@class='pac-item']"));
		log(search.size()+ "are the elements for search results");
		
		if(search.size()==1) {

		WebElement searchresult = driver.findElement(By.xpath("//div[@class='pac-item']"));

		searchresult.click();

		}else {
			search.get(search.size()-1).click();
		}
		
		
		
		Thread.sleep(3000);
		buildingNumber.sendKeys(_Buildingnumber);
		Thread.sleep(3000);
		wh.waitForElementToBeClickable(buildingName, driver, 10);
		buildingName.clear();

		buildingName.sendKeys(_BuildingName);
		streetNumber.clear();

		streetNumber.sendKeys(_StreetNo);
		streetName.clear();

		streetName.sendKeys(_StreetName);
		route.clear();

		route.sendKeys(_Route);
		subLocality.clear();

		subLocality.sendKeys(_Sublocality);
		locality.clear();

		locality.sendKeys(_Locality);
		county.clear();

		county.sendKeys(_County);
		province.clear();

		province.sendKeys(_Province);
		country.clear();

		country.sendKeys(_Country);
		postalCode.clear();

		postalCode.sendKeys(_Pin);

		

	}

	public void clickonSave() throws InterruptedException {
		wh.waitForElementToBeClickable(Save, driver, 10);
		Save.click();
		Thread.sleep(3000);

	}

	public void clickonCancel() {
		wh.waitForElementToBeClickable(Save, driver, 10);
		Cancel.click();
		log("Clicked on Cancel");
		
	}














































































































	//	@FindBy(xpath = "//input[@ng-model='ui.name']")
	//	public WebElement Name_inputfield;
	//
	//	@FindBy(xpath = "//div[@class='v-multiselect ng-scope ng-isolate-scope' and @v-data-source='model.locales' and @v-selected-items='ui.supportedLanguages']")
	//	public WebElement Supported_languages_inputfield;
	//
	//	@FindBy(xpath = "//div[contains(@v-label,'SSPTenant.TenantForm-BaseLanguage')]//span[@class='k-dropdown-wrap k-state-default']")
	//	public WebElement Baselanguage_selectDropDown;
	//
	//	@FindBy(xpath = "//div[contains(@v-label,'SSPTenant.TenantForm-Currencies')]/div/div/div/div[2]/div")
	//	public WebElement SupportedCurrenciesDropDown;
	//
	//	@FindBy(xpath = "//div[contains(@v-label,'SSPTenant.TenantForm-BaseCurrency')]/div/div/span/span/span[1]")
	//	public WebElement BasecurrencyDropDown;
	//
	//	@FindBy(xpath = "//button[@class='ng-scope' and @translate='Next']")
	//	public WebElement Nextbutton;
	//
	//	@FindBy(xpath = "//input[@ng-model='ui.employeeId' and @name='employeeId']")
	//	public WebElement Employeeid_inputfield;
	//	
	//	@FindBy(xpath = "//input[@ng-model='ui.firstName' and @name='firstName']")
	//	public WebElement Firstname_inputfield;
	//	
	//	@FindBy(xpath = "//input[@ng-model='ui.middleName' and @name='middleName']")
	//	public WebElement Middlename_inputfield;
	//	
	//	@FindBy(xpath = "//input[@ng-model='ui.lastName' and @name='lastName']")
	//	public WebElement Lastname_inputfield;
	//	
	//	@FindBy(xpath = "//div[contains(@v-label,'SSPTenant.TenantForm-Gender')]//span[@class='k-dropdown-wrap k-state-default']")
	//	public WebElement Gender_DropDown;
	//
	//	@FindBy(xpath = "//li[@class='k-item ng-scope' and text()='Male']")
	//	public WebElement MaleGender;
	//	
	//	@FindBy(xpath = "//li[@class='k-item ng-scope' and text()='Female']")
	//	public WebElement FemaleGender;
	//
	//	@FindBy(xpath = "//input[@ng-model='ui.emailId' and @name='emailId']")
	//	public WebElement Emailid_inputfield;
	//
	//	@FindBy(xpath = "//div[contains(@v-label,'SSPTenant.TenantForm-Authorities')]//span[@class='k-dropdown-wrap k-state-default']")
	//	public WebElement AuthoritiesDropDown;
	//	
	//	@FindBy(xpath = "//input[@ng-model='ui.Password' and @name='Password']")
	//	public WebElement Password_inputfield;
	//
	//	@FindBy(xpath = "//button[@class='ng-scope' and @translate='Save']")
	//	public WebElement Savebutton;






























	//	
	//	//********************************************************************************************
	//	
	//	/**
	//	 * Method to add the Tenant details
	//	 * @param _TenantName
	//	 * @param _Supportedlanguages
	//	 * @throws InterruptedException
	//	 * @throws AWTException 
	//	 */
	//	public void addTenantDetails(String _TenantName, String _Supportedlanguages,String _Baselanguage,String _SupportedCurrencies,String _BaseCurrency) throws InterruptedException, AWTException {
	//		uniqueNo = date.generateUniqueNo();
	//		log("unique no is generated "+uniqueNo);
	//		wh.waitForElementToBeClickable(Name_inputfield, driver, 10);
	//		TenantUniqueName =_TenantName+uniqueNo;
	//		Name_inputfield.sendKeys(TenantUniqueName);
	//		log("Entered Tenant Name As "+TenantUniqueName);
	//		addSupportedLanguages(_Supportedlanguages);
	//		
	//		selectBaseLanguage(_Baselanguage);
	//		addSupportedCurrencies(_SupportedCurrencies);
	//		selectBaseCurrency(_BaseCurrency);
	//
	//	}
	//
	//	
	//	//********************************************************************************************
	//
	//	/**
	//	 * Method to Add the supported languages
	//	 * @param supported_language
	//	 * @throws InterruptedException
	//	 * @throws AWTException 
	//	 * @throws r 
	//	 */
	//	public void addSupportedLanguages(String _Supported_language) throws InterruptedException, AWTException {
	//
	//		log("Select the supported language");
	//
	//		String[] items = _Supported_language.split(",");
	//		List<String> itemList = Arrays.asList(items);
	//
	//		for (String temp : itemList) {
	//			Supported_languages_inputfield.click();
	//			log("clicked on the support language input field");
	//			WebElement lang = driver.findElement(By.xpath("//span[@class='v-label ng-scope' and  @translate='"+temp+"' and @translate-values='labelParameters']"));
	//			wh.waitForElementToBeClickable(lang, driver, 10);
	//			clickElementUsingJavaScript(lang);
	//			log("Selected the Language as "+temp);
	//			
	//		}
	//           
	//
	//	}
	//
	//	
	//	//********************************************************************************************
	//
	//	/**
	//	 * Method to Select the Base Language
	//	 * @param _BaseLang
	//	 */
	//	public void selectBaseLanguage(String _BaseLang) {
	//		clickElementUsingJavaScript(Baselanguage_selectDropDown);
	//		log("Base language select dropdown is clicked");
	//		WebElement baselangValueToSelect = driver.findElement(By.xpath("//div[@class='k-animation-container'][2]//div//ul//span[@class='v-label ng-scope' and text()='"+_BaseLang+"']"));	
	//		wh.waitForElementToBeClickable(baselangValueToSelect, driver, 10);
	//		clickElementUsingJavaScript(baselangValueToSelect);
	//		log("Base language value is selected as "+_BaseLang);
	//
	//	}
	//	
	//	//********************************************************************************************
	//
	//	/**
	//	 * Method to Add Supported Currencies
	//	 * @param _Currencies
	//	 */
	//	public void addSupportedCurrencies(String _Currencies) {
	//		String[] items = _Currencies.split(",");
	//		List<String> itemList = Arrays.asList(items);
	//		for (String temp : itemList) {
	//			SupportedCurrenciesDropDown.click();
	//			WebElement currencyToSelect = driver.findElement(By.xpath("//span[text()='"+temp+"'][1]"));		
	//			wh.waitForElementToBeClickable(currencyToSelect, driver, 10);
	//			clickElementUsingJavaScript(currencyToSelect);
	//			log("The following currency is selected "+temp);
	//
	//		}
	//
	//	}
	//	
	//	
	//	//********************************************************************************************
	//
	//	/**
	//	 * Method to Select Base Currency
	//	 * @param _BaseCurrency
	//	 */
	//	public void selectBaseCurrency(String _BaseCurrency) {
	//		wh.waitForElementToBeClickable(BasecurrencyDropDown, driver, 10);
	//		clickElementUsingJavaScript(BasecurrencyDropDown);
	//		log("Base currency drop down in clicked");
	//		WebElement basecurrencyToSelect = driver.findElement(By.xpath("//div/div[3]/ul/li/label[contains(@v-label,'"+_BaseCurrency+"')]"));
	//		clickElementUsingJavaScript(basecurrencyToSelect);
	//		log("Base currency value selected as "+_BaseCurrency);
	//	}
	//	
	//	
	//	//********************************************************************************************
	//	/**
	//	 * Method to click on Save button icon
	//	 */
	//	public void clickonNext() {
	//		
	//		clickElementUsingJavaScript(Nextbutton);
	//		log("clicked on the Next button");
	//	}
	//	
	//	
	//	//********************************************************************************************
	//	/**
	//	 * Method to click on save
	//	 */
	//	public void clickonSave() {
	//		
	//		clickElementUsingJavaScript(Savebutton);
	//		log("clicked on the Savebutton button");
	//	}
	//
	//	
	//	//********************************************************************************************
	//	/**
	//	 * Method to call and search for the tenant
	//	 * @param _TenantName 
	//	 * @param _Locale
	//	 * @param _Currency
	//	 * @return
	//	 */
	//	public String SearchTenantAfterCreated(String _TenantName,String _Locale,String _Currency) {
	//		TenantsListPage tenantlistpage = new TenantsListPage(driver);
	//		return tenantlistpage.searchAndSelectTenantCreated(_TenantName+uniqueNo, _Locale, _Currency);
	//	}
	//
	//	
	//	//********************************************************************************************
	//	/**
	//	 * Method to Add the Employee details in the Tenant Quick setup page
	//	 * @param _Employeeid
	//	 * @param _FirstName
	//	 * @param _MiddleName
	//	 * @param _LastName
	//	 * @param _Gender
	//	 * @param _Emailid
	//	 */
	//	public void addEmployeedetails(String _Employeeid,String _FirstName,String _MiddleName,String _LastName,String _Gender,String _Emailid) {
	//		wh.waitForElementToBeClickable(Employeeid_inputfield, driver, 10);
	//		Employeeid_inputfield.sendKeys(_Employeeid);
	//		log("Entered the Employee id "+ _Employeeid);
	//		Firstname_inputfield.sendKeys(_FirstName);
	//		log("Entered the Employee FirstName "+ _FirstName);
	//		Middlename_inputfield.sendKeys(_MiddleName);
	//		log("Entered the Employee MiddleName "+ _MiddleName);
	//		Lastname_inputfield.sendKeys(_LastName);
	//		log("Entered the Employee LastName "+ _LastName);
	//		
	//		clickElementUsingJavaScript(Gender_DropDown);
	//		if(_Gender.equalsIgnoreCase("Male")) {
	//		
	//			clickElementUsingJavaScript(MaleGender);
	//            log("Gender Selected as "+MaleGender);
	//		}else {
	//			
	//			clickElementUsingJavaScript(FemaleGender);
	//			log("Gender Selected as "+FemaleGender);
	//		}
	//		
	//		Emailid_inputfield.sendKeys(_Emailid);
	//		log("Entered the email id as "+_Emailid);
	//
	//	}
	//	
	//	//********************************************************************************************
	//	/**
	//	 * Method to Add account details
	//	 * @param _Authorities
	//	 * @param _Password
	//	 */
	//	public void addAccountDetails(String _Authorities,String _Password) {
	//		wh.waitForElementToBeClickable(AuthoritiesDropDown, driver, 10);
	//		clickElementUsingJavaScript(AuthoritiesDropDown);
	//		WebElement authoritiesToSelect = driver.findElement(By.xpath("//li[@class='k-item ng-scope' and text()='"+_Authorities+"']"));
	//		clickElementUsingJavaScript(authoritiesToSelect);
	//		Password_inputfield.sendKeys(_Password);
	//	}


}

