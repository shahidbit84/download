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
 * The repository for swebWalletTenants App Main Page
 */
public class TenantsListPage extends TestBase {
	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;

	public static final Logger log = Logger.getLogger(TenantsListPage.class.getName());

	public TenantsListPage(WebDriver driver,ExtentTest test) {
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
		tenantsListPage_taskcloseicon.click();
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

	@FindBy(xpath = "//div[@class='task-header']//label[@class='ng-isolate-scope']/span[@class='v-label ng-scope']")
	public WebElement tenantsListPage_headerlabel;

	@FindBy(xpath = "//div[@class='task-settings']")
	public WebElement tenantsListPage_tasksettingsicon;

	@FindBy(xpath = "//div[@class='task-help']")
	public WebElement tenantsListPage_taskhelpicon;

	@FindBy(xpath = "//div[@class='task-fullscreen ng-scope']")
	public WebElement tenantsListPage_taskfullscreenicon;

	@FindBy(xpath = "//div[@class='task-close ng-scope']")
	public WebElement tenantsListPage_taskcloseicon;
//---------------------------------------------- fucntionality action bar's xpath------------------------------
	@FindBy(xpath = "//li[@id='ssp_tenant_add']")
	public WebElement tenantsListPage_Addiconlabel;

	@FindBy(xpath = "//li[@id='ssp_tenant_edit']")
	public WebElement tenantsListPage_Editiconlabel;

	@FindBy(xpath = "//li[@id='ssp_tenant_delete']")
	public WebElement tenantsListPage_Deleteiconlabel;

	@FindBy(xpath = "//li[@id='ssp_tenant_quick_setup']")
	public WebElement tenantsListPage_Quicksetupiconlabel;

	@FindBy(xpath = "//li[@id='ssp_tenant_details']")
	public WebElement tenantsListPage_Detailsiconlabel;

	@FindBy(xpath = "//li[@id='ssp_tenant_refresh']")
	public WebElement tenantsListPage_Refreshiconlabel;
		
	@FindBy(xpath = "//li[@id='ssp_tenant_analytics']")
	public WebElement tenantsListPage_Analyticsiconlabel;
	
	@FindBy(xpath = "//li[@id='ssp_tenant_retryTime']")
	public WebElement tenantsListPage_BookingRetryiconlabel;
	
	@FindBy(xpath = "//li[@id='ssp_tenant_booking']")
	public WebElement tenantsListPage_Bookingsiconlabel;
//---------------------------------------------------------Column header xpath---------------------------------	
	
	@FindBy(xpath = "//p[@translate='SSPTenant.ApplicationHeader-TenantsList']")
	public WebElement tenantsListPage_applicationHeader;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPTenant.GridColumnHeader-Name']")
	public WebElement NameColumHeaderlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPTenant.GridColumnHeader-Locale']")
	public WebElement LocaleColumHeaderlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPTenant.GridColumnHeader-Currency']")
	public WebElement CurrencyColumHeaderlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPTenant.GridColumnHeader-StartDate']")
	public WebElement StartDateColumHeaderlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPTenant.GridColumnHeader-EndDate']")
	public WebElement EndDateColumHeaderlabel;

	@FindBy(xpath = "//span[@class='k-window-title' and text()='Confirm']")
	public WebElement ConfirmDeleteDialoglabel;

	@FindBy(xpath = "//p[@class='ng-scope' and @translate='SSPTenant.TenantForm-ConfirmDeleteTenant']")
	public WebElement deleteconfirmationMessage;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonYes']")
	public WebElement YesButtoninDeleteConfirmation;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonNo']")
	public WebElement NoButtoninDeleteConfirmation;

	@FindBy(xpath = "//span[@class='k-icon k-i-close']")
	public WebElement closeXiconinDeleteConfirmationPopup;

	
	
	//path variables for tenant details page
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPTenant.GridColumnHeader-Name']")
	public WebElement TenantDetailsNameColumHeaderlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPTenant.GridColumnHeader-Type']")
	public WebElement TenantDetailsTypeColumHeaderlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPTenant.GridColumnHeader-TimeZone']")
	public WebElement TenantDetailsTimeZoneColumHeaderlabel;
	
	@FindBy(xpath = "//li[@id='ssp_tenant_details_cancel']")
	public WebElement tenantslistpage_detailsCancelIcon;
	
	@FindBy(xpath = "//li[@id='ssp_tenant_details_refresh']")
	public WebElement TenantDetailsRefreshlabel;
		

/**
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnRefreshButton() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		tenantsListPage_Refreshiconlabel.click();
		log("Clicked on Refresh icon");
		takeScreenShot();
		log("Page is refreshed");

	}

	
	/**
	 * To verify the tenant hierarchy when details button is clicked.
	 * @throws InterruptedException
	 */
	public void clickTenantdetails()throws InterruptedException{
		Thread.sleep(2000);
		tenantsListPage_Detailsiconlabel.click();
		log("Click on tenant details button");
		takeScreenShot();
	}
	
	/**
	 * To click the analytics button.
	 * @throws InterruptedException
	 */
	public void clickTenantAnalytics() throws InterruptedException {
		Thread.sleep(2000);
		tenantsListPage_Analyticsiconlabel.click();
		log("click on tenant analaytics page");
		takeScreenShot();
		
	}
	
	
	
	
	/**
	 * Method to verify the Task Header and Task control icon on the top
	 * @param _swebWalletTenants
	 * @param _Preferences
	 * @param _Help
	 * @param _Close
	 * @return
	 * @throws InterruptedException
	 */
	public String verifyTaskHeader_TaskControl_labelText(String _TenantsListPage_headerlabel, String _Preferences, String _Help,String _FullScreen, String _Close) throws InterruptedException {
		String status = "FAIL";
		log(tenantsListPage_headerlabel.getText() + " label is displayed");
		if (tenantsListPage_headerlabel.getText().equals(_TenantsListPage_headerlabel)) {
			log(tenantsListPage_tasksettingsicon.getAttribute("title") + " label is displayed");
			if (tenantsListPage_tasksettingsicon.getAttribute("title").equals(_Preferences)) {
				log(tenantsListPage_taskhelpicon.getAttribute("title") + " label is displayed");
				if (tenantsListPage_taskhelpicon.getAttribute("title").equals(_Help)) {
					log(tenantsListPage_taskfullscreenicon.getAttribute("title") + " label is displayed");
					if(tenantsListPage_taskfullscreenicon.getAttribute("title").equals(_FullScreen)){
						log(tenantsListPage_taskcloseicon.getAttribute("title") + " label is displayed");
						if (tenantsListPage_taskcloseicon.getAttribute("title").equals(_Close)) {

							status = "PASS";
							takeScreenShot();
						}
					}
				}
			}
		}
		return status;

	}

	/**
	 * Method to click on the Add button in the Tenants list page to Add a new Tenant
	 */
	public void clickonAddTenantIcon() {

		wh.waitForElementToBeClickable(tenantsListPage_Addiconlabel, driver, 10);
		clickElementUsingJavaScript(tenantsListPage_Addiconlabel);
		takeScreenShot();
	}
	

	/**
	 * Method will SearchForTenant Created and returns PASS if found and Selects it else it returns FAIL
	 * @param _TenantName
	 * @param _Locale
	 * @param _Currency
	 * @return
	 * @throws InterruptedException 
	 */
	public String searchAndSelectTenantCreated(String _TenantName, String _Locale,String _Currency) throws InterruptedException {
		String status = "FAIL";

		//		WebElement firstrow = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr/td[1]"));
		//		wh.waitForElementToBeVisible(firstrow, driver, 10);

		Thread.sleep(10000);
		List<WebElement> tenantRows = driver.findElements(By.xpath("//*[@id='overview_page']//table[@class='k-selectable']/tbody/tr"));
		log("No of rows ="+tenantRows.size());
		for(int i=0;i<tenantRows.size();i++) {
			int j=i+1;


			WebElement NameColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[1]"));
			WebElement LocaleColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[2]"));
			WebElement CurrencyColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[3]"));

			if(NameColumnValue.getText().equals(_TenantName)) {		
				if(LocaleColumnValue.getText().equals(_Locale)) {
					log(NameColumnValue.getText()+" "+LocaleColumnValue.getText()+" "+CurrencyColumnValue.getText()+" is displayed in the Table");
					if(CurrencyColumnValue.getText().equals(_Currency)) {

						driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]")).click();
						log("Tenant Name "+_TenantName+"Searched and Selected ");
						status ="PASS";
						return status;
					}
				}
			}

		}

		return status;

	}
	/**
	 * Method to click on the Quick setup icon
	 */
	public void clickonQuicksetup() {
		wh.waitForElementToBeClickable(tenantsListPage_Quicksetupiconlabel, driver, 10);
		clickElementUsingJavaScript(tenantsListPage_Quicksetupiconlabel);

	}

	/**
	 * Method will check for the icons in the Tenants list page icons are Add,Edit,Delete,Quicksetup,Details,Refresh
	 * @param _AddiconlabelText
	 * @param _EditiconlabelText
	 * @param _DeleteiconlabelText
	 * @param _QuicksetupiconlabelText
	 * @param _DetailsiconlabelText
	 * @param _RefreshiconlabelText
	 * @return
	 */
	public String verifyIconsAndLabelsInthePage(String _AddiconlabelText,String _EditiconlabelText,String _DeleteiconlabelText,String _QuicksetupiconlabelText,
			String _DetailsiconlabelText,String _RefreshiconlabelText) {
		status="FAIL";
		log("Icon label displayed is -> "+tenantsListPage_Addiconlabel.getText());
		if(tenantsListPage_Addiconlabel.getText().equals(_AddiconlabelText)) {
			log("Icon label displayed is -> "+tenantsListPage_Editiconlabel.getText());
			if(tenantsListPage_Editiconlabel.getText().equals(_EditiconlabelText)) {
				log("Icon label displayed is -> "+tenantsListPage_Deleteiconlabel.getText());
				if(tenantsListPage_Deleteiconlabel.getText().equals(_DeleteiconlabelText)) {
					log("Icon label displayed is -> "+tenantsListPage_Quicksetupiconlabel.getText());
					if(tenantsListPage_Quicksetupiconlabel.getText().equals(_QuicksetupiconlabelText)) {
						log("Icon label displayed is -> "+tenantsListPage_Detailsiconlabel.getText());
						if(tenantsListPage_Detailsiconlabel.getText().equals(_DetailsiconlabelText)) {
							log("Icon label displayed is -> "+tenantsListPage_Refreshiconlabel.getText());
							if(tenantsListPage_Refreshiconlabel.getText().equals(_RefreshiconlabelText)) {

								status = "PASS";
								takeScreenShot();
							}
						}
					}
				}
			}
		}
		return status;



	}
/**
 * Method to verify the Icon labels page header and labels in the table
 * @param _ApplicationHeaderLabel
 * @param _NameColHeader
 * @param _LocaleColHeader
 * @param _CurrencyColHeader
 * @param _StartdateColHeader
 * @param _EnddateColHeader
 * @return
 */
	public String verifyApplicationHeaderAndTableLabels(String _ApplicationHeaderLabel,String _NameColHeader,String _LocaleColHeader,String _CurrencyColHeader,
			String _StartdateColHeader,String _EnddateColHeader) {

		status="FAIL";
		log("tenantsListPage_applicationHeader is displayed as " +tenantsListPage_applicationHeader.getText());
		if(tenantsListPage_applicationHeader.getText().equals(_ApplicationHeaderLabel)) {
			log("NameColumHeaderlabel is displayed as " +NameColumHeaderlabel.getText());
			if(NameColumHeaderlabel.getText().equals(_NameColHeader)) {
				log("LocaleColumHeaderlabel is displayed as " +LocaleColumHeaderlabel.getText());
				if(LocaleColumHeaderlabel.getText().equals(_LocaleColHeader)) {
					log("CurrencyColumHeaderlabel is displayed as " +CurrencyColumHeaderlabel.getText());
					if(CurrencyColumHeaderlabel.getText().equals(_CurrencyColHeader)) {
						log("StartDateColumHeaderlabel is displayed as " +StartDateColumHeaderlabel.getText());
						if(StartDateColumHeaderlabel.getText().equals(_StartdateColHeader)) {
							log("EndDateColumHeaderlabel is displayed as " +EndDateColumHeaderlabel.getText());
							if(EndDateColumHeaderlabel.getText().equals(_EnddateColHeader)) {							
								status="PASS";
								takeScreenShot();
							}
						}
					}
				}
			}
		}
		return status;

	}

	/**
	 * Clicking on the Refresh button
	 * @throws InterruptedException
	 */
	public void clickonRefresh() throws InterruptedException {
		Thread.sleep(3000);
		tenantsListPage_Refreshiconlabel.click();
		log("Clicked on Refresh icon");
		takeScreenShot();
		log("Page is refreshed");

	}

	/**
	 * Clicking on the Refresh
	 */
	public void clickonDelete() {
		wh.waitForElementToBeClickable(tenantsListPage_Deleteiconlabel, driver, 10);
		clickElementUsingJavaScript(tenantsListPage_Deleteiconlabel);
		log("Clicked on the Delete icon ");
		takeScreenShot();

	}

	/**
	 * Verifying the dialog for Delete confirmation and clicking on X
	 * @param _TenantName
	 * @param _ConfirmdeleteLabel
	 * @param _yesbuttonText
	 * @param _NobuttonText
	 * @return
	 * @throws InterruptedException
	 */
	public String verifyConfirmDeletePopUpLabelsAndClickX(String _TenantName,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
		status="FAIL";
		log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
		if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
			log("Message is displayed -> "+deleteconfirmationMessage.getText());
			if(deleteconfirmationMessage.getText().equals("Do you want to delete tenant '"+_TenantName+"'?")) {
				log("Button Label is displayed -> "+YesButtoninDeleteConfirmation.getText());
				if(YesButtoninDeleteConfirmation.getText().equals(_yesbuttonText)) {
					log("Button Label is displayed -> "+NoButtoninDeleteConfirmation.getText());
					if(NoButtoninDeleteConfirmation.getText().equals(_NobuttonText)) {
						takeScreenShot();
						wh.waitForElementToBeClickable(closeXiconinDeleteConfirmationPopup, driver, 10);
						closeXiconinDeleteConfirmationPopup.click();
						log("clicked on X icon");
						status="PASS";

					}
				}
			}
		}
		return status;

	}

	/**
	 *  Verifying the dialog for Delete confirmation and clicking on No
	 * @param _TenantName
	 * @param _ConfirmdeleteLabel
	 * @param _yesbuttonText
	 * @param _NobuttonText
	 * @return
	 * @throws InterruptedException
	 */
	public String verifyConfirmDeletePopUpLabelsAndClickNo(String _TenantName,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
		status="FAIL";
		log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
		if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
			log("Message is displayed -> "+deleteconfirmationMessage.getText());
			if(deleteconfirmationMessage.getText().equals("Do you want to delete tenant '"+_TenantName+"'?")) {
				log("Button Label is displayed -> "+YesButtoninDeleteConfirmation.getText());
				if(YesButtoninDeleteConfirmation.getText().equals(_yesbuttonText)) {
					log("Button Label is displayed -> "+NoButtoninDeleteConfirmation.getText());
					if(NoButtoninDeleteConfirmation.getText().equals(_NobuttonText)) {
						takeScreenShot();
						wh.waitForElementToBeClickable(NoButtoninDeleteConfirmation, driver, 10);
						NoButtoninDeleteConfirmation.click();
						log("clicked on X icon");
						status="PASS";

					}
				}
			}
		}
		return status;

	}

	/**
	 *  Verifying the dialog for Delete confirmation and clicking on Yes
	 * @param _TenantName
	 * @param _ConfirmdeleteLabel
	 * @param _yesbuttonText
	 * @param _NobuttonText
	 * @return
	 * @throws InterruptedException
	 */
	public String verifyConfirmDeletePopUpLabelsAndClickYes(String _TenantName,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
		status="FAIL";
		log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
		if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
			log("Message is displayed -> "+deleteconfirmationMessage.getText());
			if(deleteconfirmationMessage.getText().equals("Do you want to delete tenant '"+_TenantName+"'?")) {
				log("Button Label is displayed -> "+YesButtoninDeleteConfirmation.getText());
				if(YesButtoninDeleteConfirmation.getText().equals(_yesbuttonText)) {
					log("Button Label is displayed -> "+NoButtoninDeleteConfirmation.getText());
					if(NoButtoninDeleteConfirmation.getText().equals(_NobuttonText)) {
						takeScreenShot();
						wh.waitForElementToBeClickable(YesButtoninDeleteConfirmation, driver, 10);
						YesButtoninDeleteConfirmation.click();
						log("clicked on yes icon");
						status="PASS";

					}
				}
			}
		}
		return status;

	}


/**
 * Confirmation by clicking on Yes to Delete 
 * @param _TenantName
 * @return
 * @throws InterruptedException
 */
	public String clickYesDeleteConfirmation(String _TenantName) throws InterruptedException {
		status="FAIL";
		takeScreenShot();
		if(deleteconfirmationMessage.getText().equals("Do you want to delete tenant '"+_TenantName+"'?")) {
			wh.waitForElementToBeClickable(YesButtoninDeleteConfirmation, driver, 10);
			YesButtoninDeleteConfirmation.click();
			log("clicked on yes icon");
			status="PASS";
		}
		return status;

	}

	/**
	 * Clicking on the Details icon
	 * @throws InterruptedException
	 */
	public void clickonDetails() throws InterruptedException {
		tenantsListPage_Detailsiconlabel.click();
		log("Clicked on Details icon");
		takeScreenShot();


	}

	/**
	 * Clicking on Edit
	 */
	public void clickonEdit() {
		tenantsListPage_Editiconlabel.click();
		log("Clicked on Edit icon");
		takeScreenShot();

	}
	


	/**
	 * 
	 * @param _NameColHeader
	 * @param _TypeColHeader
	 * @param _TimeZoneColHeader
	 * @param _StartdateColHeader
	 * @param _EnddateColHeader
	 * @return
	 */
	
	public String verifyTenantDetailsColumnHeader(String _NameColHeader,String _TypeColHeader,String _TimeZoneColHeader) {

		status="FAIL";
		if(TenantDetailsNameColumHeaderlabel.getText().equals(_NameColHeader)) {
			log("TenantDetailsNameColumHeaderlabel is displayed as " +TenantDetailsNameColumHeaderlabel.getText());
			if(TenantDetailsTypeColumHeaderlabel.getText().equals(_TypeColHeader)) {
				log("TenantDetailsTypeColumHeaderlabel is displayed as " +TenantDetailsTypeColumHeaderlabel.getText());
				if(TenantDetailsTimeZoneColumHeaderlabel.getText().equals(_TimeZoneColHeader)) {
					log("TenantDetailsTimeZoneColumHeaderlabel is displayed as " +TenantDetailsTimeZoneColumHeaderlabel.getText());				
								status="PASS";
								takeScreenShot();
				}
			}
		}
		return status;

	}

	/**
	 * To click the cancel in tenant details page
	 */
	public void clickDetailsCancel() {
		tenantslistpage_detailsCancelIcon.click();
		log("Clicked cancel in details page");
	}

	/**
	 * 
	 * @param _DetailsCancelButton
	 * @param _DetailsRefreshButton
	 * @return
	 */
public String VerifyTenantDetailsActionbar(String _DetailsCancelButton,String _DetailsRefreshButton) {
	status = "FAIL";
	
	if(tenantslistpage_detailsCancelIcon.getText().equals(_DetailsCancelButton)) {
		log("TenantDetailsCancelIcon is displayed as " +tenantslistpage_detailsCancelIcon.getText());
		if(TenantDetailsRefreshlabel.getText().equals(_DetailsRefreshButton)) {
			log("TenantDetailsRefreshlabel is displayed as " +TenantDetailsRefreshlabel.getText());			
							status="PASS";
							takeScreenShot();
		}
	}
	
	return status;
}

/**
 * Refresh button click in tenant details page
 */

public void clickDetailsRefreshButton() {
	TenantDetailsRefreshlabel.click();
	log("Clicked refresh in details page");
}


}




