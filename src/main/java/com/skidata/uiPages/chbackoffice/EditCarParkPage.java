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
public class EditCarParkPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status;


	public static final Logger log = Logger.getLogger(EditCarParkPage.class.getName());



	//Class constructor
	public EditCarParkPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

	}



	//****************************************************************************************************************
	@FindBy(xpath = "//span[@class='v-label' and text()='LOADING...']")
	public WebElement loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;

	@FindBy(xpath = "//input[@ng-model='model.carPark.name']")
	public WebElement Name_inputfield;
	
	@FindBy(xpath = "//input[@ng-model='model.carPark.bays']")
	public WebElement Bays_inputfield;

	@FindBy(xpath = "//input[@ng-model='model.carPark.latitude']")
	public WebElement Latitude_inputfield;
	
	@FindBy(xpath = "//input[@ng-model='model.carPark.longitude']")
	public WebElement Longitude_inputfield;
	

	@FindBy(xpath = "//li[@id='ssp_carpark_edit_save']")
	public WebElement Save;
	
	@FindBy(xpath = "//li[@id='ssp_carpark_edit_cancel']")
	public WebElement Cancel;


	//****************************************************************************************************************

	public void selectLocale(String _LocaleValue) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(@v-label,'SSPUnits.LocaleSelector-LabelName')]//span[@class='k-widget k-dropdown k-header ng-scope']")).click();
		WebElement locale = driver.findElement(By.xpath("//li[text()='"+_LocaleValue+"']"));
		clickElementUsingJavaScript(locale);
	}





	/**
	 * Click on the + Add new car park
	 * @throws InterruptedException 
	 * @throws AWTException 
	 */
	public void editCarParkdetails(String _Bays,String _Latitude,String _Longitude) throws InterruptedException, AWTException {
		

//		WebElement FacilityValue = driver.findElement(By.xpath("//li[@class='k-item ng-scope' and text()='"+_FacilityValueCarPark+"']"));
//		wh.waitForElementToBeVisible(FacilityValue, driver, 10);
//		clickElementUsingJavaScript(FacilityValue);
//		log("Selected the facility value as "+_FacilityValueCarPark);
//		
//		Name_inputfield.clear();
		Thread.sleep(3000);

		mkh.pressTabKeyAndRelease();
		mkh.pressTabKeyAndRelease();
	
//		log("Entered the Name as "+_Name);
//		wh.waitForElementToBeClickable(Bays_inputfield, driver, 10);
		Bays_inputfield.clear();
		Bays_inputfield.sendKeys(_Bays);
		mkh.pressTabKeyAndRelease();
		
		log("Entered the Bays as "+_Bays);
		Bays_inputfield.clear();
		Latitude_inputfield.sendKeys(_Latitude);
		mkh.pressTabKeyAndRelease();
		
		log("Entered the Latitude as "+_Latitude);
		Longitude_inputfield.clear();
		Longitude_inputfield.sendKeys(_Longitude);
		mkh.pressTabKeyAndRelease();
		
		log("Entered the Longitude as "+_Longitude);
		
	}
	
	public String searchAndSelectCarParkEdited(String _createdCarParkName,String _EditedCarParkBays,String _EditedCarParkLatitude,String _EditedCarParkLongitude) throws InterruptedException {
		status = "FAIL";
		Thread.sleep(8000);

		List<WebElement> carParkRows = driver.findElements(By.xpath("//table[@class='k-selectable']/tbody/tr"));
		log("No of rows found for car park list is "+carParkRows.size());
		for(int i=0;i<carParkRows.size();i++) {
			int j=i+1;
			WebElement NameColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[1]"));
			WebElement BaysColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[2]"));
			WebElement latitude = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[3]"));
			WebElement longitude = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[4]"));
if(NameColumnValue.getText().equals(_createdCarParkName)) {			
				if(BaysColumnValue.getText().equals(_EditedCarParkBays)) {
					if(latitude.getText().equals(_EditedCarParkLatitude)) {
						if(longitude.getText().equals(_EditedCarParkLongitude)) {
						
					log(NameColumnValue.getText()+" "+BaysColumnValue.getText()+" "+latitude.getText()+" "+longitude.getText()+" -> is displayed in the Table");
					
						driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]")).click();
//						log("car park is -> "+_EditedCarParkName+" is Searched and Selected ");
						status ="PASS";
						return status;
						}
		}
				}
			}

		}
		
		return status;

	}
	public void clickonSave() {
		wh.waitForElementToBeClickable(Save, driver, 10);
		Save.click();

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

