package com.skidata.uiPages.chbackoffice;

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

public class AddTenantAnalyticspage extends TestBase {

	
	String uniqueNo=null;
	String TenantUniqueName=null;
	DateAndUniqueNoGenerateHelper date = new DateAndUniqueNoGenerateHelper();
	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);



	public static final Logger log = Logger.getLogger(AddTenantPage.class.getName());
	String status=null;


	//Class constructor
	public AddTenantAnalyticspage(WebDriver driver,ExtentTest test) {
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

	
	@FindBy(xpath = "//span[@id='ssp_tenant_analytics_window_wnd_title']")
	public WebElement AnanlyticsWindowTitle;
	

	@FindBy(xpath = "//label[@for='checkbox2b6247d3-c812-4a97-8bbd-13cd79c97196']")
	public WebElement AnanlyticsCheckbox;
	

	@FindBy(xpath = "//span[@aria-owns= 'ssp_tenant_analytics_type_listbox']")
	public WebElement AnanlyticsServicename_InputField;

	@FindBy(xpath = "//textarea[@v-model='model.analytics.trackingCode']")
	public WebElement TrackingCode_InputField;
	
	@FindBy(xpath = "//div[@v-model='model.analytics.anonymizeIp']")
	public WebElement AnonymizeIp_Checkbox;
	
	@FindBy(xpath = "//div[@v-on-click='saveAnalytics()']")
	public WebElement Savebutton;

	@FindBy(xpath = "//div[@v-on-click='closeAnalyticsWindow()']")
	public WebElement Cancelbutton;
	
//	---------------------------------label xpath
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPTenant.AnalyticsForm-EnableAnalytics']")
	public WebElement AnanlyticsEnableAnanlytics_label;

	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPTenant.AnalyticsForm-ServiceName']")
	public WebElement AnanlyticsServicename_label;

	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPTenant.AnalyticsForm-Code']")
	public WebElement AnanlyticsTrackingCode_label;

	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPTenant.AnalyticsForm-AnonymizeIP']")
	public WebElement AnanlyticsAnonymizeIP_label;

	
	
	
//	
//	
//	

	/**
	 * Method to click on Save button icon
	 */
	public void clickonSave() {
		wh.waitForElementToBeClickable(Savebutton, driver, 10);
		Savebutton.click();
		log("clicked on the Save button");
		takeScreenShot();
	}

	
	/**
	 * Function to click the checkbox to configure analytics
	 * @throws InterruptedException 
	 *
	 */
public void clickOnEnableAnalytics() throws InterruptedException {
	Thread.sleep(1000);
	AnanlyticsCheckbox.click();
	log("Clicked on enable analytics check box");
	takeScreenShot();
}
	
public void clickOnEnableAnonymizeIp() throws InterruptedException {
	AnonymizeIp_Checkbox.click();
	Thread.sleep(2000);
	log("Clicked on enable anonymize IP");
	takeScreenShot();
}

	
	/**
	 * To cancel the analytics popup.
	 */
	public void clickonCancel() {
		wh.waitForElementToBeClickable(Cancelbutton, driver, 10);
		Cancelbutton.click();
		log("clicked on the Cancel button");
		takeScreenShot();

	}
	
	/**
	 * Method to click/ select the Newly created Teannt
	 * 
	 */
	
	public void singleclickOnNewlycreatedTenant(String _NewlyCreatedTenant){
		driver.findElement(By.xpath("//span[text()='"+_NewlyCreatedTenant+"']")).click();
		log("clicked on the Newly created Tenant");
		takeScreenShot();
		
	}

	/**
	 * To add the analytics details
	 * @param _ServiceName
	 * @param _TrackingCode
	 * @throws InterruptedException
	 */
      public void addAnanlyticsDetails(String _ServiceName,String _TrackingCode) throws InterruptedException {
    	  clickOnEnableAnalytics();
    	  AnanlyticsServicename_InputField.click();
    	  WebElement serviceName = driver.findElement(By.xpath("//li[contains(text(),'"+_ServiceName+"')]"));
  		clickElementUsingJavaScript(serviceName);
  		TrackingCode_InputField.sendKeys(_TrackingCode);	
  		clickOnEnableAnonymizeIp();
  }
	
      
      /**
       * to verify the icon labels available in the popup.
       * @param _PopupLabel
       * @param _SaveLabel
       * @param _CancelLabel
       * @return
       */
      public String verifypopupLabel(String _PopupLabel,String _SaveLabel, String _CancelLabel) {
    	  status="FAIL";
  		if(AnanlyticsWindowTitle.getText().equals(_PopupLabel)) {
  			log("Analyticslabel is displayed as " +AnanlyticsWindowTitle.getText());
  			if(Savebutton.getText().equals(_SaveLabel)) {
  				log("Savebutton is displayed as " +Savebutton.getText());
  				if(Cancelbutton.getText().equals(_CancelLabel)) {
  					log("Cancelbutton is displayed as " +Cancelbutton.getText());				
  								status="PASS";
  								takeScreenShot();
  				}
  			}
  		}
  		return status;

      }
      
      /**
       * To verify the form fields
       * @param _PopupLabel
       * @param _SaveLabel
       * @param _CancelLabel
       * @return
       */
      public String verifyFormFields(String _enableAnalyticsLabel,String _ServiceNameLabel, String _TrackingCodeLabel,String _AnonymizeIP) {
    	  status="FAIL";
  		if(AnanlyticsEnableAnanlytics_label.getText().equals(_enableAnalyticsLabel)) {
  			log("AnanlyticsEnableAnanlytics_label is displayed as " +AnanlyticsEnableAnanlytics_label.getText());
  			if(AnanlyticsServicename_label.getText().equals(_ServiceNameLabel)) {
  				log("AnanlyticsServicename_label is displayed as " +AnanlyticsServicename_label.getText());
  				if(AnanlyticsTrackingCode_label.getText().equals(_TrackingCodeLabel)) {
  					log("AnanlyticsTrackingCode_label is displayed as " +AnanlyticsTrackingCode_label.getText());		
  					if(AnanlyticsAnonymizeIP_label.getText().equals(_AnonymizeIP)) {
  	  					log("AnanlyticsAnonymizeIP_label is displayed as " +AnanlyticsAnonymizeIP_label.getText());		
  								status="PASS";
  								takeScreenShot();
  					}
  				}
  			}
  		}
  		return status;

      }
      
      
	//****************************************************************************************************************


	
}






