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
public class EditRegionalHeadquarterPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;


	public static final Logger log = Logger.getLogger(EditRegionalHeadquarterPage.class.getName());



	//Class constructor
	public EditRegionalHeadquarterPage(WebDriver driver,ExtentTest test) {
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

	@FindBy(xpath = "//input[@ng-model='model.regional.name']")
	public WebElement Name_inputfield;

	@FindBy(xpath = "//textarea[@ng-model='inputValue' and @v-model='model.regional.localizedDescription']")
	public WebElement Description_textarea;

	@FindBy(xpath = "//div[contains(@v-label,'SSPRegionalHeadQuarter.RegionalHeadQuarterForm-baseLocale')]/div/div//span[text()='--- Select ---']")
	public WebElement Baselocale_dropdown;

	@FindBy(xpath = "//div[contains(@v-label,'SSPRegionalHeadQuarter.RegionalHeadQuarterForm-secondaryCurrencies')]//div[@v-data-source='model.secondaryCurrencies']//div[2]")
	public WebElement Secondarycurrencies_DropDown;

	@FindBy(xpath = "//input[@on-place-changed='addressSelected()' and  @placeholder='Enter a location']")
	public WebElement Searchaddress_inputfield;

	@FindBy(xpath = "//input[@id='buildingNumber' and @ ng-model='model.regional.manualAddress.buildingNumber']")
	public WebElement buildingNumber;

	@FindBy(xpath = "//input[@id='buildingName' and @ ng-model='model.regional.manualAddress.buildingName']")
	public WebElement buildingName;

	@FindBy(xpath = "//input[@id='streetNumber' and @ ng-model='model.regional.manualAddress.streetNumber']")
	public WebElement streetNumber;

	@FindBy(xpath = "//input[@id='streetName' and @ ng-model='model.regional.manualAddress.streetName']")
	public WebElement streetName;

	@FindBy(xpath = "//input[@id='route' and @ ng-model='model.regional.manualAddress.route']")
	public WebElement route;

	@FindBy(xpath = "//input[@id='subLocality' and @ ng-model='model.regional.manualAddress.subLocality']")
	public WebElement subLocality;

	@FindBy(xpath = "//input[@id='locality' and @ ng-model='model.regional.manualAddress.locality']")
	public WebElement locality;

	@FindBy(xpath = "//input[@id='county' and @ ng-model='model.regional.manualAddress.county']")
	public WebElement county;

	@FindBy(xpath = "//input[@id='province' and @ ng-model='model.regional.manualAddress.province']")
	public WebElement province;
	@FindBy(xpath = "//input[@id='country' and @ ng-model='model.regional.manualAddress.country']")
	public WebElement country;

	@FindBy(xpath = "//input[@id='postalCode' and @ ng-model='model.regional.manualAddress.postalCode']")
	public WebElement postalCode;

	@FindBy(xpath = "//li[@id='ssp_regionalhq_edit_save']")
	public WebElement Save;



	@FindBy(xpath = "//p[@translate='SSPRegionalHeadQuarter.ApplicationHeader-EditRegionalHeadQuarter']")
	public WebElement EditRegionalHqHeader;

	@FindBy(xpath = "//div[contains(@v-label,'SSPRegionalHeadQuarter.RegionalHeadQuarterForm-representatives')]//span[@class='k-input ng-scope']")
	public WebElement RepresentativesDropdown;

	@FindBy(xpath = "//li[@id='ssp_regionalhq_edit_cancel']")
	public WebElement Cancel;



	//****************************************************************************************************************

	public void selectLocale(String _LocaleValue) {
		driver.findElement(By.xpath("//div[contains(@v-label,'SSPRegionalHeadQuarter.LocaleSelector-LabelName')]//span[@class='k-widget k-dropdown k-header ng-scope']")).click();
		WebElement locale = driver.findElement(By.xpath("//li[text()='"+_LocaleValue+"']"));
		clickElementUsingJavaScript(locale);
	}





	/**
	 * Click on the + Add new Headquarter
	 * @throws InterruptedException 
	 */
	public void editRegionalHeadquarterDetails(String _Name,String _Description,String _RepresntativeValue) throws InterruptedException {

		Thread.sleep(8000);
		driver.findElement(By.xpath("//input[@ng-model='model.regional.name']"));
		Name_inputfield.clear();
		Name_inputfield.sendKeys(_Name);

		Description_textarea.clear();
		Description_textarea.sendKeys(_Description);

		RepresentativesDropdown.click();

		WebElement represntativesValueToSelect = driver.findElement(By.xpath("//li[@class='k-item ng-binding ng-scope' and text()='"+_RepresntativeValue+"']"));
		wh.waitForElementToBeClickable(represntativesValueToSelect, driver, 20);
		clickElementUsingJavaScript(represntativesValueToSelect);


		//		clickElementUsingJavaScript(Baselocale_dropdown);
		//		WebElement baselocale = driver.findElement(By.xpath("//li[@class='k-item ng-scope' and text()='"+_BaseLocale+"']"));
		//		clickElementUsingJavaScript(baselocale);
		//
		//		WebElement basecurrency = driver.findElement(By.xpath("//div[contains(@v-label,'SSPRegionalHeadQuarter.RegionalHeadQuarterForm-baseCurrency')]//option[text()='"+_BaseCurrency+"']"));
		//		Thread.sleep(3000);
		//		clickElementUsingJavaScript(basecurrency);
		//
		//
		//		WebElement basecurrValueToSelect = driver.findElement(By.xpath("//li[@class='k-item ng-scope k-state-selected k-state-focused' and text()='AUD']"));
		//		clickElementUsingJavaScript(basecurrValueToSelect);

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
		//
		//		}
	}

	//****************************************************************************************************************

	public void editEnterSearchAddress(String _SearchAddress,String _Buildingnumber,String _BuildingName,String _StreetNo,String _StreetName,
			String _Route,String _Sublocality,String _Locality,String _County,String _Province,String _Country,String _Pin) throws AWTException, InterruptedException
	{


		Searchaddress_inputfield.sendKeys(_SearchAddress);
		Thread.sleep(5000);
		//		MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver);
		//		mkh.pressDownArrowKeyAndRelease();
		//		Thread.sleep(3000);
		//		mkh.pressEnterKeyAndRelease();
		//		pressTab();

		WebElement searchresult = driver.findElement(By.xpath("//div[@class='pac-item']"));
		wh.waitForElementToBeVisible(searchresult, driver, 10);
		searchresult.click();
		wh.waitForElementToBeClickable(buildingNumber, driver, 10);
		Thread.sleep(3000);
		buildingNumber.clear();
		buildingNumber.sendKeys(_Buildingnumber);
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

	public void clickonSave() {
		wh.waitForElementToBeClickable(Save, driver, 10);
		Save.click();

	}





	public String verifyEditRegionalHqHeader(String _EditRegionalHqHeader) {
		status ="FAIL";
		if(EditRegionalHqHeader.getText().equals(_EditRegionalHqHeader)) {
			log(EditRegionalHqHeader.getText()+" is displayed as Header in UI");
			status="PASS";
			takeScreenShot();
		}
		return status;


	}





	public void clickonCancel() {
		wh.waitForElementToBeClickable(Cancel, driver, 10);
		Cancel.click();

	}





	public void clickonDelete() {
		wh.waitForElementToBeClickable(Cancel, driver, 10);
		Cancel.click();

	}


}
