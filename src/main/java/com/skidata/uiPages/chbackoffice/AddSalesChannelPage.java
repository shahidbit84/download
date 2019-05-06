/**
 *
 */
package com.skidata.uiPages.chbackoffice;

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
public class AddSalesChannelPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;


	public static final Logger log = Logger.getLogger(AddSalesChannelPage.class.getName());



	//Class constructor
	public AddSalesChannelPage(WebDriver driver,ExtentTest test) {
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
	@FindBy(xpath = "//div[@class='v-progress-window ng-scope k-window-content k-content']//span[@translate='VSMCommon.ProgressLoading']")
	public WebElement loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;

	@FindBy(xpath = "//*[@id='saleschannel_add_page']//vsm-rebind/span/span[1]/span[1]")
	public WebElement ParentDropdown;
	

	
	@FindBy(xpath = "//div[contains(@v-label,'CH.SelectTenant')]/div/div//span/span[@class='k-dropdown-wrap k-state-default']")
	public WebElement TenantDropDown;

	@FindBy(xpath = "//input[@ng-model='model.salesChannel.name']")
	public WebElement Name_inputfield;

	@FindBy(xpath = "//textarea[@ng-model='inputValue' and @v-model='model.salesChannel.localizedDescription']")
	public WebElement Description_textarea;

	@FindBy(xpath = "//div[contains(@v-label,'SSPSalesChannel.SalesChannelForm-baseLocale')]/div/div//span[text()='--- Select ---']")
	public WebElement Baselocale_dropdown;

	@FindBy(xpath = "//div[contains(@v-label,'SSPSalesChannel.SalesChannelForm-secondaryCurrencies')]//div[@v-data-source='model.secondaryCurrencies']//div[2]")
	public WebElement Secondarycurrencies_DropDown;


	@FindBy(xpath = "//li[@id='ssp_saleschannel_add_save']")
	public WebElement Save;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and  @translate='CH.ButtonEdit']")
	public WebElement Edit;


	@FindBy(xpath = "//li[@id='ssp_saleschannel_add_cancel']")
	public WebElement Cancel;

	@FindBy(xpath = "//p[@translate='SSPSalesChannel.ApplicationHeader-AddSalesChannel']")
	public WebElement AddSalesChannelPageHeader;

	//****************************************************************************************************************

	public void selectLocale(String _LocaleValue) {
		driver.findElement(By.xpath("//div[@id='ssp_saleschannel_add_locale']/span/span']")).click();
		WebElement locale = driver.findElement(By.xpath("//li[text()='"+_LocaleValue+"']"));
		clickElementUsingJavaScript(locale);
	}


	/**
	 * 
	 * @throws InterruptedException 
	 */
	public void addSalesChanneldetails(String ParentSalesChannel,String _Name,String _Description,String _BaseLocale,String _BaseCurrency,String _SecondaryCurrency) throws InterruptedException {

//		wh.waitForElementToBeInvisible(ParentDropdown, driver, 20);
		ParentDropdown.click();
		Thread.sleep(5000);
	

		
		//WebElement parentunitValue = driver.findElement(By.xpath("//li[@class='k-item ng-scope'and text()='AUS_RHQ']"));
	    
		List<WebElement> parentunitValue = driver.findElements(By.xpath("//li[@class='k-item ng-scope'and text()='"+ParentSalesChannel+"']"));
		
		if(parentunitValue.size()>0) {
		
			Thread.sleep(3000);
			clickElementUsingJavaScript(parentunitValue.get(parentunitValue.size()-1));
			
		}
		
//		Thread.sleep(2000);
//
//		clickElementUsingJavaScript(parentunitValue);


		Name_inputfield.sendKeys(_Name);
		Description_textarea.sendKeys(_Description);

		clickElementUsingJavaScript(Baselocale_dropdown);
		WebElement baselocale = driver.findElement(By.xpath("//li[@class='k-item ng-scope' and text()='"+_BaseLocale+"']"));
		clickElementUsingJavaScript(baselocale);


		WebElement basecurrency = driver.findElement(By.xpath("//div[contains(@v-label,'SSPSalesChannel.SalesChannelForm-baseCurrency')]//option[text()='"+_BaseCurrency+"']"));
		Thread.sleep(3000);
		clickElementUsingJavaScript(basecurrency);
		Thread.sleep(3000);
		WebElement basecurrValueToSelect = driver.findElement(By.xpath("//ul[@id='saleschannel_add_page_currency_listbox']//li[contains(text(),'"+_BaseCurrency+"')]"));
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


	public void clickonSave() {
		wh.waitForElementToBeClickable(Save, driver, 10);
		Save.click();
		log("clicked on Save");
		takeScreenShot();

	}

	public void clickonEdit() {
		wh.waitForElementToBeClickable(Edit, driver, 10);
		Edit.click();
		log("clicked on Edit");
		takeScreenShot();
	}




	public String verifyPageHeaderAddSalesChannel(String _AddSalesChannelPageHeader) {
		status="FAIL";
		if(AddSalesChannelPageHeader.getText().equals(_AddSalesChannelPageHeader)) {
			status="PASS";
			log("Page header is displayed as ->"+_AddSalesChannelPageHeader);
			takeScreenShot();
		}
		return status;


	}


	public void clickonCancel() {
		wh.waitForElementToBeClickable(Cancel, driver, 10);
		Cancel.click();
		log("clicked on Cancel");
		takeScreenShot();

	}



}

