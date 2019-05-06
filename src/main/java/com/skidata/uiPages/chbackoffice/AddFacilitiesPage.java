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
 * @author Sreelakshmi
 * 
 */
public class AddFacilitiesPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status;


	public static final Logger log = Logger.getLogger(AddFacilitiesPage.class.getName());



	//Class constructor
	public AddFacilitiesPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='task-close ng-scope']")
	public WebElement taskcloseicon;
	
	public void clickonXtaskHeaderControlicon() {
		taskcloseicon.click();
		log("clicked on the X icon in the Task Header label");
		takeScreenShot();
	}

	//****************************************************************************************************************
	@FindBy(xpath = "//div[@class='v-progress-window ng-scope k-window-content k-content']//span[@translate='VSMCommon.ProgressLoading']")
	public WebElement loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;

	@FindBy(xpath = "//*[@id='facility_add_page']//vsm-rebind/span/span[1]/span[1]")
	public WebElement ParentDropdown;

	@FindBy(xpath = "//div[contains(@v-label,'CH.SelectTenant')]/div/div//span/span[@class='k-dropdown-wrap k-state-default']")
	public WebElement TenantDropDown;

	@FindBy(xpath = "//input[@ng-model='model.facility.name']")
	public WebElement Name_inputfield;

	@FindBy(xpath = "//textarea[@ng-model='inputValue' and @v-model='model.facility.localizedDescription']")
	public WebElement Description_textarea;

	@FindBy(xpath = "//div[contains(@v-label,'SSPFacility.FormLabel-BaseLocale')]/div/div//span[text()='--- Select ---']")
	public WebElement Baselocale_dropdown;

	@FindBy(xpath = "//div[contains(@v-label,'SSPFacility.FormLabel-SecondaryCurrencies')]//div[@v-data-source='model.secondaryCurrencies']//div[2]")
	public WebElement Secondarycurrencies_DropDown;

	@FindBy(xpath = "//input[@on-place-changed='addressSelected()' and  @placeholder='Enter a location']")
	public WebElement Searchaddress_inputfield;

	@FindBy(xpath = "//input[@id='buildingNumber' and @ ng-model='model.facility.manualAddress.buildingNumber']")
	public WebElement buildingNumber;

	@FindBy(xpath = "//input[@id='buildingName' and @ ng-model='model.facility.manualAddress.buildingName']")
	public WebElement buildingName;

	@FindBy(xpath = "//input[@id='streetNumber' and @ ng-model='model.facility.manualAddress.streetNumber']")
	public WebElement streetNumber;

	@FindBy(xpath = "//input[@id='streetName' and @ ng-model='model.facility.manualAddress.streetName']")
	public WebElement streetName;

	@FindBy(xpath = "//input[@id='route' and @ ng-model='model.facility.manualAddress.route']")
	public WebElement route;

	@FindBy(xpath = "//input[@id='subLocality' and @ ng-model='model.facility.manualAddress.subLocality']")
	public WebElement subLocality;

	@FindBy(xpath = "//input[@id='locality' and @ ng-model='model.facility.manualAddress.locality']")
	public WebElement locality;

	@FindBy(xpath = "//input[@id='county' and @ ng-model='model.facility.manualAddress.county']")
	public WebElement county;

	@FindBy(xpath = "//input[@id='province' and @ ng-model='model.facility.manualAddress.province']")
	public WebElement province;
	@FindBy(xpath = "//input[@id='country' and @ ng-model='model.facility.manualAddress.country']")
	public WebElement country;

	@FindBy(xpath = "//input[@id='postalCode' and @ ng-model='model.facility.manualAddress.postalCode']")
	public WebElement postalCode;


	@FindBy(xpath = "//*[@id='ssp_facility_add_save']")
	public WebElement Save;
	
	
	@FindBy(xpath = "//li[@id='ssp_facility_add_cancel']")
	public WebElement FacilityAddCancel;
	
	
	


	//****************************************************************************************************************

	public void selectLocale(String _LocaleValue) {
		driver.findElement(By.xpath("//div[@id='ssp_facility_add_locale']/span/span']")).click();
		WebElement locale = driver.findElement(By.xpath("//li[text()='"+_LocaleValue+"']"));
		clickElementUsingJavaScript(locale);
	}


	/**
	 * Method to add the facilities 
	 * @throws InterruptedException 
	 */
	public void addFacilitiesdetails(String ParentUnit,String _Name,String _Description,String _BaseLocale,String _BaseCurrency,String _SecondaryCurrency) throws InterruptedException {

//		wh.waitForElementToBeInvisible(loadingprogress, driver, 20);
		
		ParentDropdown.click();
		Thread.sleep(4000);
//		WebElement parentunitValue = driver.findElement(By.xpath("//li[@class='k-item ng-scope' and text()='"+ParentUnit+"']"));
//		wh.waitForElementToBeVisible(parentunitValue, driver, 10);
//		clickElementUsingJavaScript(parentunitValue);
		
		List<WebElement> parentunitValue = driver.findElements(By.xpath("//li[@class='k-item ng-scope' and text()='"+ParentUnit+"']"));
		
		if(parentunitValue.size()>1) {
			Thread.sleep(2000);
			clickElementUsingJavaScript(parentunitValue.get(parentunitValue.size()-1));
		}


		Name_inputfield.sendKeys(_Name);
		Description_textarea.sendKeys(_Description);

		clickElementUsingJavaScript(Baselocale_dropdown);
		WebElement baselocale = driver.findElement(By.xpath("//li[@class='k-item ng-scope' and text()='"+_BaseLocale+"']"));
		clickElementUsingJavaScript(baselocale);

		WebElement basecurrency = driver.findElement(By.xpath("//div[contains(@v-label,'SSPFacility.FormLabel-BaseCurrency')]//option[text()='"+_BaseCurrency+"']"));
		Thread.sleep(4000);
		clickElementUsingJavaScript(basecurrency);

		
		WebElement basecurrValueToSelect = driver.findElement(By.xpath("//ul[@id='facility_add_page_facility_currency_listbox']/li[contains(text(),'"+_BaseCurrency+"')]"));
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
		Thread.sleep(4000);
		
	}

	//****************************************************************************************************************

	/**
	 * To add the address for the facility searched in the input.
	 * @param _SearchAddress
	 * @param _Buildingnumber
	 * @param _BuildingName
	 * @param _StreetNo
	 * @param _StreetName
	 * @param _Route
	 * @param _Sublocality
	 * @param _Locality
	 * @param _County
	 * @param _Province
	 * @param _Country
	 * @param _Pin
	 * @throws AWTException
	 * @throws InterruptedException
	 */
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
	
	/**
	 * To save the facilities
	 */

	public void clickonSave() throws InterruptedException {
		wh.waitForElementToBeClickable(Save, driver, 10);
		Save.click();
		Thread.sleep(8000);

	}

	/**
	 * To cancel the add facility form
	 * @throws InterruptedException
	 */
	public void clickOnCancel() throws InterruptedException {
		wh.waitForElementToBeClickable(FacilityAddCancel, driver, 10);
		FacilityAddCancel.click();
		Thread.sleep(8000);
		
	}

}
