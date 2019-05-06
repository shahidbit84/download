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
public class FacilitiesListPage extends TestBase {
	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);



	public static final Logger log = Logger.getLogger(FacilitiesListPage.class.getName());
	String status = null;


	public FacilitiesListPage(WebDriver driver,ExtentTest test) {
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

	@FindBy(xpath = "//span[@class='v-label' and translate='VSMCommon.ProgressLoading']")
	public WebElement loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;

	@FindBy(xpath = "//div[@id='ssp_facility_tenant']/span/span/span")
	public WebElement TenantDropDown;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='CH.ButtonAdd']")
	public WebElement FacilitiesListPage_Addiconlabel;

	@FindBy(xpath = "//li[@id='ssp_facility_add']")
	public WebElement Add_ButtonLabel;
	
	@FindBy(xpath = "//li[@id='ssp_facility_edit']")
	public WebElement Edit_ButtonLabel;
	
	
	@FindBy(xpath = "//li[@id='ssp_facility_contractor']")
	public WebElement ContractorSystem_iconlabel;

	@FindBy(xpath = "//li[@id='ssp_facility_activate']")
	public WebElement Activate_ButtonLabel;
	
	@FindBy(xpath = "//li[@id='ssp_facility_deactivate']")
	public WebElement DeActivate_ButtonLabel;
	

	@FindBy(xpath = "//li[@id='ssp_facility_refresh']")
	public WebElement Refresh_ButtonLabel;
	

	@FindBy(xpath = "//div[@class='k-window-titlebar k-header']//span[@class='k-window-title']")
	public WebElement ConfirmPopUpHeader;

	@FindBy(xpath = "//p[@translate='SSPUnits.UnitsForm-ConfirmDeactivateUnits']")
	public WebElement DeactivateFacilityMessage;
	
	@FindBy(xpath = "//p[@translate='SSPUnits.UnitsForm-ConfirmActivateUnits']")
	public WebElement ActivateFacilityMessage;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonYes']")
	public WebElement YesButton;
	
	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonNo']")
	public WebElement NoButton;

	@FindBy(xpath = "//span[@class='k-icon k-i-close' and text()='Close']")
	public WebElement XButtontocloseConfirmpopup;
	
	
	@FindBy(xpath = "//li[@id='ssp_facility_delete']")
	public WebElement facilityListPage_Deleteiconlabel;
	
	
	@FindBy(xpath = "//span[@class='k-window-title' and text()='Confirm']")
	public WebElement ConfirmDeleteDialoglabel;
	
	@FindBy(xpath = "//li[@id='ssp_facility_reset']")
	public WebElement Reset_ButtonLabel;
	
	
	@FindBy(xpath = "//li[@id='ssp_facility_employees']")
	public WebElement Employees_ButtonLabel;
	
	@FindBy(xpath = "//p[@translate='SSPFacility.alertMessage-ConfirmDelete']")
	public WebElement deleteconfirmationMessage;
	
	
	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonYes']")
	public WebElement YesButtoninDeleteConfirmation;
	
	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonNo']")
	public WebElement NoButtoninDeleteConfirmation;
	
	
	
@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPUnits.GridColumnHeader-Name']")
public WebElement NameColumHeaderlabel;

@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPUnits.GridColumnHeader-locale']")
public WebElement LocaleColumHeaderlabel;

@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPUnits.GridColumnHeader-timeZone']")
public WebElement TimeZoneColumHeaderlabel;

@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPUnits.GridColumnHeader-address']")
public WebElement AddressColumHeaderlabel;

@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPUnits.GridColumnHeader-Status']")
public WebElement StatusColumHeaderlabel;

	
	
	@FindBy(xpath = "//span[@class='k-icon k-i-close']")
	public WebElement closeXiconinDeleteConfirmationPopup;

	/**
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnRefreshButton() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		Refresh_ButtonLabel.click();
		log("Clicked on Refresh icon");
		takeScreenShot();
		log("Page is refreshed");

	}

	public void waitforInvisibilityOfLoading() {
		waitForElementInVisiblity(driver, 10, loadingprogress);
		log("loading progress completed");
	}

	/**
	 * Method to click on the Add button in the Tenants list page to Add a new Tenant
	 */
	public void clickonAddFacilitiesIcon() {

		wh.waitForElementToBeClickable(FacilitiesListPage_Addiconlabel, driver, 10);
		clickElementUsingJavaScript(FacilitiesListPage_Addiconlabel);
		log("Clicked on the Add icon label in the facilities list page");
		takeScreenShot();
	}


	public void selectTenant(String _TenantName) throws InterruptedException {

		//clickElementUsingJavaScript(TenantDropDown);
		clickElementUsingJavaScript(TenantDropDown);
		WebElement selectTenant = driver.findElement(By.xpath("//ul[@class='k-list k-reset']//li[@class='k-item ng-scope' and text()='"+_TenantName+"']"));
		Thread.sleep(3000);
		clickElementUsingJavaScript(selectTenant);
	}
	
	public String searchAndSelectFacilityCreated(String _CreatedUnitName, String _CreatedUnitLocale,String _CreatedUnitAddress) throws InterruptedException {
		status = "FAIL";
		Thread.sleep(8000);
		List<WebElement> tenantRows = driver.findElements(By.xpath("//table[@class='k-selectable']/tbody/tr"));
		log("No of rows found for unit list is "+tenantRows.size());
		for(int i=0;i<tenantRows.size();i++) {
			int j=i+1;
			WebElement NameColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[1]"));
			WebElement LocaleColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[2]"));
			WebElement TimeZone = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[3]"));
			WebElement Address = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[4]"));

			if(NameColumnValue.getText().equals(_CreatedUnitName)) {		
				if(LocaleColumnValue.getText().equals(_CreatedUnitLocale)) {
					log(NameColumnValue.getText()+" "+LocaleColumnValue.getText()+" "+TimeZone.getText()+" "+Address.getText()+" -> is displayed in the Table");
					
					log(Address.getText());
					
					if(Address.getText().equals(_CreatedUnitAddress)) {
						
						driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]")).click();
						log("Unit is -> "+_CreatedUnitName+" is Searched and Selected ");
						status ="PASS";
						return status;
					}
				}
			}

		}
		
		return status;

	}
	
	public String verifyIconLabelsinFacilityPage(String _AddLabelFacilitypage,String _EditlabelFacilitypage,String _ActivatelabelFacilitypage,String _DeactivatelabelFacilitypage,
			String _contractorSystemPage,String _RefreshlabelFacilitypage,String _ResetlabelFacilitypage,String _EmployesslabelFacilitypage) throws InterruptedException {
		status="FAIL";
		
		if(Add_ButtonLabel.getText().equals(_AddLabelFacilitypage)){
			log(Add_ButtonLabel.getText()+" label is displayed in the facility page");
			if(Edit_ButtonLabel.getText().equals(_EditlabelFacilitypage)) {
				log(Edit_ButtonLabel.getText()+" label is displayed in the facility page");
				if(Activate_ButtonLabel.getText().equals(_ActivatelabelFacilitypage)) {
					log(Activate_ButtonLabel.getText()+" label is displayed in the facility page");
					if(DeActivate_ButtonLabel.getText().equals(_DeactivatelabelFacilitypage)) {
						log(DeActivate_ButtonLabel.getText()+" label is displayed in the facility page");
							if(ContractorSystem_iconlabel.getText().equals(_contractorSystemPage)) {
								log(ContractorSystem_iconlabel.getText() + " Label is displayed in facility page");
							if(Refresh_ButtonLabel.getText().equals(_RefreshlabelFacilitypage)) {
							log(Refresh_ButtonLabel.getText()+" label is displayed in the facility page");
								if(Reset_ButtonLabel.getText().equals(_ResetlabelFacilitypage)) {
									log(Reset_ButtonLabel.getText()+" label is displayed in the Units page");
									log(Employees_ButtonLabel.getText()+" label is displayed in the facility page");
									if(Employees_ButtonLabel.getText().equals(_EmployesslabelFacilitypage)) {
										log(Employees_ButtonLabel.getText()+" label is displayed in the facility page");
										Thread.sleep(3000);
										takeScreenShot();
										status="PASS";
										
									}
								}
							}
						}
					}
				}
			}
		}
		return status;
	
	}
	
	public String verifyApplicationHeaderAndTableLabels(String _NameColHeader,String _LocaleColHeader,String _timeZoneColHeader,
			String _AddressColHeader,String _StatusColHeader) {
	
		status="FAIL";
//		log("tenantsListPage_applicationHeader is displayed as " +UnitsListPage_applicationHeader.getText());
	
			log("NameColumHeaderlabel is displayed as " +NameColumHeaderlabel.getText());
			if(NameColumHeaderlabel.getText().equals(_NameColHeader)) {
				log("LocaleColumHeaderlabel is displayed as " +LocaleColumHeaderlabel.getText());
				if(LocaleColumHeaderlabel.getText().equals(_LocaleColHeader)) {
					log("TimeZoneColumHeaderlabel is displayed as " +TimeZoneColumHeaderlabel.getText());
					if(TimeZoneColumHeaderlabel.getText().equals(_timeZoneColHeader)) {
						log("AddressColumHeaderlabel is displayed as " +AddressColumHeaderlabel.getText());
						if(AddressColumHeaderlabel.getText().equals(_AddressColHeader)) {
							log("StatusColumHeaderlabel is displayed as " +StatusColumHeaderlabel.getText());
							if(StatusColumHeaderlabel.getText().equals(_StatusColHeader)) {							
								status="PASS";
								takeScreenShot();
							}
						}
					}
				}
			}
		return status;
		
	}

	/**
	 * Method to Select the Facility 
	 * @param _FacilityName
	 * @param _Locale
	 * @throws InterruptedException 
	 */
	@SuppressWarnings("unused")
	public String selectFacilityFromTable(String _FacilityName,String _Locale) throws InterruptedException {

		Thread.sleep(5000);
		status ="FAIL";
		List<WebElement> totalrows = driver.findElements(By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr"));
		log("no of ros"+totalrows.size());

		for(int i=0;i<totalrows.size();i++) {
			int j=i+1;
			WebElement Name = driver.findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr["+j+"]/td[1]"));
			WebElement Locale = driver.findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr["+j+"]/td[2]"));
			WebElement TimeZone = driver.findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr["+j+"]/td[3]"));
			WebElement Address = driver.findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr["+j+"]/td[4]"));
			WebElement Status = driver.findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr["+j+"]/td[5]"));

			if(Name.getText().equals(_FacilityName)) {
				if(Locale.getText().equals(_Locale)) {
					driver.findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr["+j+"]/td[1]")).click();
					status="PASS";
					log("Selected the row");
				}
			}

		}
		return status;


	}


	public void clickOnContractorSystem() {
		wh.waitForElementToBeClickable(ContractorSystem_iconlabel, driver, 10);
		ContractorSystem_iconlabel.click();
		log("clicked on the icon Contractor System");
		takeScreenShot();
	}

	public void clickonDeactivateNoButton() {
		takeScreenShot();
		NoButton.click();
		log("clicked on No button in the Deactivate unit confirm dialog");
		
		
	}

	public void clickonDeactivateXToClose() {
		takeScreenShot();
		XButtontocloseConfirmpopup.click();
		log("clicked on the X to close the confirm dialog");
		
	}

	public void clickonDeactivateYes() {
		takeScreenShot();
		YesButton.click();
		log("clicked on the Yes to Deactivate unit");
		
	}

	public String verifyUnitStatus(String _ActiveOrDeactive) throws InterruptedException {
		status="FAIL";
		Thread.sleep(5000);
		WebElement ActiveOrDeactive = driver.findElement(By.xpath("//table[@class='k-selectable']//tr//td[5]"));
		if(ActiveOrDeactive.getText().equals(_ActiveOrDeactive)) {
			status="PASS";
			takeScreenShot();
			log("Status of the selected unit is -> "+ActiveOrDeactive.getText());
		}
		return status;
		
	}

	public void clickonActivate() {
		takeScreenShot();
		Activate_ButtonLabel.click();
		log("clicked on Activate");
		
	}
	
	public void clickonDeactivate() {
		DeActivate_ButtonLabel.click();
		log("clicked on the Deactivate icon");
		takeScreenShot();
		
	}


	
	public String verifyActivateDialogPopup(String _ConfirmPopupHeader,String _ActivateConfirmationMsg,String _YesButtonLabel,String _NoButtonlabel) throws InterruptedException {
		
		status="FAIL";
		Thread.sleep(5000);
		if(ConfirmPopUpHeader.getText().equals(_ConfirmPopupHeader)) {
			if(ActivateFacilityMessage.getText().equals(_ActivateConfirmationMsg)) {
				if(YesButton.getText().equals(_YesButtonLabel)) {
					if(NoButton.getText().equals(_NoButtonlabel)) {
						status="PASS";
						takeScreenShot();
					}
				}
			}
		}
		return status;
	
	}
	
	public String verifyDeactivateDialogPopup(String _ConfirmPopupHeader,String _DeactivateConfirmationMsg,String _YesButtonLabel,String _NoButtonlabel) {
		
		status="FAIL";
		wh.waitForElementToBeVisible(ConfirmPopUpHeader, driver, 10);
		if(ConfirmPopUpHeader.getText().equals(_ConfirmPopupHeader)) {
			if(DeactivateFacilityMessage.getText().equals(_DeactivateConfirmationMsg)) {
				if(YesButton.getText().equals(_YesButtonLabel)) {
					if(NoButton.getText().equals(_NoButtonlabel)) {
						status="PASS";
						takeScreenShot();
					}
				}
			}
		}
		return status;
		
		
		
		
	
	}

	public void clickonActivateNoButton() {
		takeScreenShot();
		wh.waitForElementToBeClickable(NoButton, driver, 10);
		NoButton.click();
		log("clicked on No button in the Activate unit confirm dialog");
		
	}
	
	public void clickonActivateXToClose() {
		takeScreenShot();
		XButtontocloseConfirmpopup.click();
		log("clicked on the X to close the confirm dialog");
		
	}
	
	public void clickonActivateYes() {
		takeScreenShot();
		YesButton.click();
		log("clicked on the Yes to Activate unit");
		
	}


public void clickonDelete() {
	wh.waitForElementToBeClickable(facilityListPage_Deleteiconlabel, driver, 10);
	clickElementUsingJavaScript(facilityListPage_Deleteiconlabel);
	log("Clicked on the Delete icon ");
	takeScreenShot();
	
}
public String clickYesDeleteConfirmation(String _FacilityName) throws InterruptedException {
	status="FAIL";
					takeScreenShot();
					if(deleteconfirmationMessage.getText().equals("Do you want to delete facility '"+_FacilityName+"'?")) {
					wh.waitForElementToBeClickable(YesButtoninDeleteConfirmation, driver, 10);
					YesButtoninDeleteConfirmation.click();
					log("clicked on yes icon");
					status="PASS";
					}
					return status;


}
public String verifyConfirmDeletePopUpLabelsAndClickNo(String _FacilityName,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
	status="FAIL";
	log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
	if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
		log("Message is displayed -> "+deleteconfirmationMessage.getText());
		if(deleteconfirmationMessage.getText().equals("Do you want to delete facility '"+_FacilityName+"'?")) {
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

public String verifyConfirmDeletePopUpLabelsAndClickYes(String _FacilityName,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
	status="FAIL";
	log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
	if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
		log("Message is displayed -> "+deleteconfirmationMessage.getText());
		if(deleteconfirmationMessage.getText().equals("Do you want to delete facility '"+_FacilityName+"'?")) {
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

public String verifyConfirmDeletePopUpLabelsAndClickX(String _DeleteFacilityConfirmMsg,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
	status="FAIL";
	log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
	if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
		log("Message is displayed -> "+deleteconfirmationMessage.getText());
		if(deleteconfirmationMessage.getText().equals(_DeleteFacilityConfirmMsg)) {
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



}




