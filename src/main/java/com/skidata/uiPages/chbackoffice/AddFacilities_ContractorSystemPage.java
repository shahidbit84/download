/**
 *
 */
package com.skidata.uiPages.chbackoffice;

import org.apache.log4j.Logger;
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
public class AddFacilities_ContractorSystemPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;


	public static final Logger log = Logger.getLogger(AddFacilities_ContractorSystemPage.class.getName());



	//Class constructor
	public AddFacilities_ContractorSystemPage(WebDriver driver,ExtentTest test) {
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



	@FindBy(xpath = "//input[@ng-model='model.contractor.name']")
	public WebElement Name_inputfield;


	@FindBy(xpath = "//input[@ng-model='model.contractor.baseUrl.url']")
	public WebElement URL_inputfield;


	@FindBy(xpath = "//input[@ng-model='model.contractor.dtaTenantName']")
	public WebElement Tenantname_inputfield;


	@FindBy(xpath = "//input[@ng-model='model.contractor.dtaSalesChannelName']")
	public WebElement SalesChannelname_inputfield;

	@FindBy(xpath = "//input[@ng-model='model.contractor.username']")
	public WebElement Username_inputfield;


	@FindBy(xpath = "//input[@ng-model='model.contractor.password']")
	public WebElement Password_inputfield;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and  @translate='SSPFacility.ToolBarLabel-TestConnectivity']")
	public WebElement TestConnectivity_iconlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and  @translate='SSPFacility.ToolBarLabel-ImportProducts']")
	public WebElement ImportProducts_iconlabel;


	@FindBy(xpath = "//p[@translate='SSPFacility.alertMessage-TestConnectivityPassed']")
	public WebElement ConnectivitySuccessMessage;


	@FindBy(xpath = "//p[@translate='SSPFacility.alertMessage-ConfirmImportProduct']")
	public WebElement ImportProductConfirmationMessage;

	
	@FindBy(xpath = "//input[@ng-model='model.notificationApiKey']")
	public WebElement Notification_inputField;
	
	@FindBy(xpath = "//span[@id='ssp_facility_contractor_window_notification_wnd_title']")
	public WebElement NotificationPopupHeader;

	
	@FindBy(xpath = "//button[@type='button'][contains(text(),'Save')]")
	public WebElement NotificationSave;
	
	@FindBy(xpath = "//button[@type='button'][contains(text(),'Cancel')]")
	public WebElement NotificationCancel;


	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonYes']")
	public WebElement YesButton_ImportProductConfirmation;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonNo']")
	public WebElement NoButton_ImportProductConfirmation;

	@FindBy(xpath = "//span[@class='v-label ng-scope'][contains(text(),'Notification')]")
	public WebElement Notification_iconlabel;

	@FindBy(xpath = "//p[@translate='SSPFacility.alertMessage-ProductImportTriggered']")
	public WebElement ProductImportTriggeredConfirmation;

	@FindBy(xpath = "//li[@id='ssp_facility_contractor_save']")
	public WebElement Save;


	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonOk']")
	public WebElement OKbutton;

	
	@FindBy(xpath = "//p[@translate='SSPFacility.alertMessage-SaveContractorSuccess']")
	public WebElement ContractorSaveMessage;
	
	//****************************************************************************************************************

/**
 * 
 * @param _ContractorSystemName
 * @param _ContractorSystemURL
 * @param _ContractorSystemTenantName
 * @param _ContractorSystemSalesChannelName
 * @param ContractorSystemUsername
 * @param ContractorSystemPassword
 */
	public void addContractorSystem(String _ContractorSystemName,String _ContractorSystemURL,String _ContractorSystemTenantName,String _ContractorSystemSalesChannelName,
			String ContractorSystemUsername,String ContractorSystemPassword) {
		wh.waitForElementToBeClickable(Name_inputfield, driver, 10);
		Name_inputfield.clear();
		Name_inputfield.sendKeys(_ContractorSystemName);
		log("entered the Name as "+_ContractorSystemName);
		URL_inputfield.clear();
		URL_inputfield.sendKeys(_ContractorSystemURL);
		log("entered the URL as "+_ContractorSystemURL);
		Tenantname_inputfield.clear();
		Tenantname_inputfield.sendKeys(_ContractorSystemTenantName);
		log("entered the Tenant Name as "+_ContractorSystemTenantName);
		SalesChannelname_inputfield.clear();
		SalesChannelname_inputfield.sendKeys(_ContractorSystemSalesChannelName);
		log("entered the Sales Channel Name as "+_ContractorSystemSalesChannelName);
		Username_inputfield.clear();
		Username_inputfield.sendKeys(ContractorSystemUsername);
		log("entered the User Name as "+ContractorSystemUsername);
		Password_inputfield.clear();
		Password_inputfield.sendKeys(ContractorSystemPassword);
		log("entered the Contractor System Password as "+ContractorSystemPassword);
		takeScreenShot();


	}

	/**
	 * 
	 * @throws InterruptedException
	 */

	public void clickonSave() throws InterruptedException {
		wh.waitForElementToBeClickable(Save, driver, 10);
		Save.click();
		Thread.sleep(8000);

	}
	/**
	 * To test the connectivity of the contractor system configured
	 */


	public void clickonTestConnectivity() {
		wh.waitForElementToBeClickable(TestConnectivity_iconlabel, driver, 10);
		TestConnectivity_iconlabel.click();
		log("Clicked on Test Connectivity icon");
		takeScreenShot();
	}
	
	public void clickOnNotification() {
		wh.waitForElementToBeClickable(Notification_iconlabel, driver, 10);
		Notification_iconlabel.click();
		log("Clicked on Notification icon");
		takeScreenShot();
	}
	
	
	
	/**
	 * Success message for the contractor system connectivity.
	 * @param _ContractorConnectivitySuccessMessage
	 * @return
	 */

	public String verifyContractorConnectivitySuccess(String _ContractorConnectivitySuccessMessage) {
		status="FAIL";
		wh.waitForElementToBeVisible(ConnectivitySuccessMessage, driver, 10);
		log(ConnectivitySuccessMessage.getText());
		log(_ContractorConnectivitySuccessMessage);
		if(ConnectivitySuccessMessage.getText().equals(_ContractorConnectivitySuccessMessage)) {
			status="PASS";
			takeScreenShot();
			OKbutton.click();

		}
		return status;
	}
	
	/**
	 * contractor system save message verification
	 * @param _ContractorSystemSave
	 * @return
	 */
	public String verifyContractorSystemSave(String _ContractorSystemSave) {
		status = "Fail";
		wh.waitForElementToBeVisible(ContractorSaveMessage, driver, 10);
		log(ContractorSaveMessage.getText());
		log(_ContractorSystemSave);
		if(ContractorSaveMessage.getText().equals(_ContractorSystemSave)) {
			status="PASS";
			takeScreenShot();
			OKbutton.click();
			
		}
		return status;
	}

	/**
	 * To import the products from the configured contractor system.
	 */

	public void clickonImportProducts() {
		wh.waitForElementToBeClickable(ImportProducts_iconlabel, driver, 10);
		ImportProducts_iconlabel.click();
		log("clicked on the Import products icon");
		takeScreenShot();
}

	/**
	 * Product import initiation confirmation message verification
	 * @param _ProductImportConfirmationMsg
	 * @param _ImportProcutsYesOrNo
	 * @return
	 */
	public String verifyImportProductsInitiation_andClickYesOrNo(String _ProductImportConfirmationMsg,String _ImportProcutsYesOrNo) {
		status="FAIL";
		wh.waitForElementToBeVisible(ImportProductConfirmationMessage, driver, 10);
		if(ImportProductConfirmationMessage.getText().equals(_ProductImportConfirmationMsg)) {
			log("Confirmation Message is displayed"+ImportProductConfirmationMessage.getText());
			takeScreenShot();
			if(_ImportProcutsYesOrNo.equalsIgnoreCase("yes")) {
				YesButton_ImportProductConfirmation.click();
				log("clicked on the Yes confirmation button for Product import");
				status="PASS";
			}
			else {
				NoButton_ImportProductConfirmation.click();
				log("clicked on the No confirmation button for Product import");
				status="PASS";
			}
		}
		return status;
	}

	/**
	 * Import product connectivity success message verification
	 * @param _ProductImportTriggeredConfirmation
	 * @return
	 */

	public String verifyImportProductConfirmationSuccess(String _ProductImportTriggeredConfirmation) {
		status="FAIL";
		wh.waitForElementToBeVisible(ProductImportTriggeredConfirmation, driver, 10);

		if(ProductImportTriggeredConfirmation.getText().equals(_ProductImportTriggeredConfirmation)) {
			log("Messaged Displayed in UI -> "+ProductImportTriggeredConfirmation);
			takeScreenShot();
			OKbutton.click();
			log("clicked on the OK button ");
			status="PASS";


		}
		return status;

	}
	
	/*
	 * 
	 * To set the notification
	 */
	public void SetNotification(String _NotificationInput) {
		wh.waitForElementToBeClickable(Notification_inputField, driver, 10);
		Notification_inputField.clear();
		Notification_inputField.sendKeys(_NotificationInput);	
	}
	
	public void clickNotificationsave() {
		wh.waitForElementToBeClickable(NotificationSave, driver, 10);
		NotificationSave.click();
		log("clicked on the save icon");
		takeScreenShot();
	}
	
	/*
	 * To cancel the notification popup
	 */
	public void clickNotificationCancel() {
	wh.waitForElementToBeClickable(NotificationCancel, driver, 10);
	NotificationCancel.click();
	log("clicked on cancel icon");
	takeScreenShot();
	}
}

