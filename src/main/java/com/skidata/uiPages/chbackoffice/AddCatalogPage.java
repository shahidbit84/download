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

public class AddCatalogPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status;


	public static final Logger log = Logger.getLogger(AddFacilitiesPage.class.getName());



	//Class constructor
	public AddCatalogPage(WebDriver driver,ExtentTest test) {
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
	
	@FindBy(xpath = "//div[contains(@v-label,'CH.SelectTenant')]/div/div//span/span[@class='k-dropdown-wrap k-state-default']")
	public WebElement TenantDropDown;

	@FindBy(xpath = "//*[@id='catalog_add_page']/div[2]/div/form/div/div/div/vsm-rebind/input")
	public WebElement Name_inputfield;

	

	@FindBy(xpath = "//li[@id='ssp_catalogs_add_save']")
	public WebElement catalogSave;
	
	@FindBy(xpath = "//li[@id='ssp_catalogs_add_cancel']")
	public WebElement catalogCancel;


	//****************************************************************************************************************

	public void selectLocale(String _LocaleValue) {
		driver.findElement(By.xpath("//div[@id='ssp_facility_add_locale']/span/span']")).click();
		WebElement locale = driver.findElement(By.xpath("//li[text()='"+_LocaleValue+"']"));
		clickElementUsingJavaScript(locale);
	}

//	/**
//	 * Method to select the sales channel
//	 * @param supported_language
//	 * @throws InterruptedException
//	 * @throws AWTException 
//	 * @throws r 
//	 */
//	public void addSelectedSalesChannel(String _SalesChannel) throws InterruptedException, AWTException {
//
//		log("Select the supported language");
//
//		String[] items = _SalesChannel.split(",");
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
//		takeScreenShot();
//
//	}

	/**
	 * Method to add the catalog 
	 * @throws InterruptedException 
	 */
	public void addCatalogDetails(String _Name) throws InterruptedException {

//		wh.waitForElementToBeInvisible(Name_inputfield, driver, 20);
		Thread.sleep(4000);
		Name_inputfield.sendKeys(_Name);
		log("catalog name entered");
		
		
	}
	
//	/**
//	 * Method to assign the sales channel to the catalog
//	 * @param _salesChannelName
//	 * @throws InterruptedException 
//	 * @throws AWTException 
//	 */
//	public void selectSalesChannel(String _salesChannelName) throws InterruptedException, AWTException {
//		Thread.sleep(2000);
//		addSelectedSalesChannel(_salesChannelName);
//	
//	}
	
	/**
	 * To save the facilities
	 */

	public void clickonSave() throws InterruptedException {
		wh.waitForElementToBeClickable(catalogSave, driver, 10);
		catalogSave.click();
		Thread.sleep(8000);

	}


}
