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
public class EditSalesChannelPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;


	public static final Logger log = Logger.getLogger(EditSalesChannelPage.class.getName());



	//Class constructor
	public EditSalesChannelPage(WebDriver driver,ExtentTest test) {
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


	@FindBy(xpath = "//li[@id='ssp_saleschannel_edit_save']")
	public WebElement Save;

	@FindBy(xpath = "//li[@id='ssp_saleschannel_edit_cancel']")
	public WebElement Cancel;

	@FindBy(xpath = "//div[@class='v-application-title ng-scope']//p")
	public WebElement EditSalesChannelPageHeader;

	//****************************************************************************************************************

	public void selectLocale(String _LocaleValue) {
		driver.findElement(By.xpath("//div[@id='ssp_saleschannel_edit_locale']/span/span']")).click();
		WebElement locale = driver.findElement(By.xpath("//li[text()='"+_LocaleValue+"']"));
		clickElementUsingJavaScript(locale);
	}


	/**
	 * 
	 * @throws InterruptedException 
	 */
	public void editSalesChanneldetails(String ParentUnit,String _Name,String _Description,String _BaseLocale,String _BaseCurrency,String _SecondaryCurrency) throws InterruptedException {

//		wh.waitForElementToBeInvisible(loadingprogress, driver, 20);
		Thread.sleep(6000);
		ParentDropdown.click();

		WebElement parentunitValue = driver.findElement(By.xpath("//li[@class='k-item ng-scope' and text()='"+ParentUnit+"']"));
		wh.waitForElementToBeVisible(parentunitValue, driver, 10);
		clickElementUsingJavaScript(parentunitValue);

		Name_inputfield.clear();
		Name_inputfield.sendKeys(_Name);

		Description_textarea.clear();
		Description_textarea.sendKeys(_Description);

		//		clickElementUsingJavaScript(Baselocale_dropdown);
		//		WebElement baselocale = driver.findElement(By.xpath("//li[@class='k-item ng-scope' and text()='"+_BaseLocale+"']"));
		//		clickElementUsingJavaScript(baselocale);
		//
		//
		//		WebElement basecurrency = driver.findElement(By.xpath("//div[contains(@v-label,'SSPSalesChannel.SalesChannelForm-baseCurrency')]//option[text()='"+_BaseCurrency+"']"));
		//		Thread.sleep(3000);
		//		clickElementUsingJavaScript(basecurrency);
		//
		//
		//		WebElement basecurrValueToSelect = driver.findElement(By.xpath("//li[@class='k-item ng-scope k-state-selected k-state-focused' and text()='"+_BaseCurrency+"']"));
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
		//		}
	}


	public void clickonSave() {
		wh.waitForElementToBeClickable(Save, driver, 10);
		Save.click();
		log("Clicked on Save");

	}


	public void clickonCancel() {
		wh.waitForElementToBeClickable(Cancel, driver, 10);
		Cancel.click();
		log("Clicked on Cancel");

	}


	public String verifyPageHeaderEditSalesChannel(String _EditSalesChannelPageHeader) {
		status="FAIL";
		if(EditSalesChannelPageHeader.getText().equals(_EditSalesChannelPageHeader)) {
			status="PASS";
			log("Page header is displayed as ->"+EditSalesChannelPageHeader);
			takeScreenShot();
		}
		return status;
	}


}

