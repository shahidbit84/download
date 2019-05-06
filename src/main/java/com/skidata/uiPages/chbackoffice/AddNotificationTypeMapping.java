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

public class AddNotificationTypeMapping extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status;


	public static final Logger log = Logger.getLogger(AddNotificationTypeMapping.class.getName());



	//Class constructor
	public AddNotificationTypeMapping(WebDriver driver,ExtentTest test) {
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

	@FindBy(xpath = "//div[@id='notification_add_page']//input[@v-model='model.notification.name']")
	public WebElement Name_inputfield;

	@FindBy(xpath = "//span[@class='k-widget k-dropdown k-header ng-scope k-invalid']")
	public WebElement DomainEvent_dropdown;
	
	@FindBy(xpath = "//span[@aria-owns='notification_add_page_account_list_listbox']//span[@contains(text(),'--- Select ---')]")
	public WebElement Configuration_dropdown;
	
	@FindBy(xpath = "//span[@aria-owns='notification_add_page_template_list_listbox']//span[@contains(text(),'--- Select ---')]")
	public WebElement Template_DropDown;

	


	@FindBy(xpath = "//li[@id='ssp_notification_add_save']")
	public WebElement NotificationSave;
	
	
	@FindBy(xpath = "//li[@id='ssp_notification_add_cancel']")
	public WebElement NotificationAddCancel;
	
	
	


	//****************************************************************************************************************

	public void selectLocale(String _LocaleValue) {
		driver.findElement(By.xpath("//div[@id='ssp_facility_add_locale']/span/span']")).click();
		WebElement locale = driver.findElement(By.xpath("//li[text()='"+_LocaleValue+"']"));
		clickElementUsingJavaScript(locale);
	}


	/**
	 * Method to add the notificationtype mapping  
	 * @return 
	 * @throws InterruptedException 
	 */
	public void addNotificationTypeDetails(String _NotificationName,String _DomainEvent,String _Configuration,String _Template) throws InterruptedException {

		wh.waitForElementToBeInvisible(loadingprogress, driver, 20);

		Name_inputfield.sendKeys(_NotificationName);
	
		clickElementUsingJavaScript(DomainEvent_dropdown);
		WebElement domainEvent = driver.findElement(By.xpath("//ul[@id='notification_add_page_event_list_listbox' and text()='"+_DomainEvent+"']"));
		clickElementUsingJavaScript(domainEvent);

		clickElementUsingJavaScript(Configuration_dropdown);
		WebElement configuration = driver.findElement(By.xpath("//ul[@id='notification_add_page_account_list_listbox' and text()='"+_Configuration+"')]"));
		clickElementUsingJavaScript(configuration);
		Thread.sleep(4000);
		
		clickElementUsingJavaScript(Template_DropDown);
		WebElement template = driver.findElement(By.xpath("//ul[@id='notification_add_page_template_list_listbox' and option[text()='"+_Template+"']"));
		clickElementUsingJavaScript(template);
		

	}

	//****************************************************************************************************************

	
	/**
	 * To save the facilities
	 */

	public void clickonSave() throws InterruptedException {
		wh.waitForElementToBeClickable(NotificationSave, driver, 10);
		NotificationSave.click();
		Thread.sleep(8000);

	}

	/**
	 * To cancel the add facility form
	 * @throws InterruptedException
	 */
	public void clickOnCancel() throws InterruptedException {
		wh.waitForElementToBeClickable(NotificationAddCancel, driver, 10);
		NotificationAddCancel.click();
		Thread.sleep(8000);
		
	}

}
