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
public class UnitslistPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;
	
	public static final Logger log = Logger.getLogger(UnitslistPage.class.getName());

	//Class constructor
	public UnitslistPage(WebDriver driver,ExtentTest test) {
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
	
	@FindBy(xpath = "//div[@id='ssp_units_tenant']/span/span/span")
	public WebElement TenantDropDown;
	
	
	@FindBy(xpath = "//li[@id='ssp_units_add']")
	public WebElement Add_ButtonLabel;
	
	@FindBy(xpath = "//li[@id='ssp_units_edit']")
	public WebElement Edit_ButtonLabel;
	
	@FindBy(xpath = "//li[@id='ssp_units_activate']")
	public WebElement Activate_ButtonLabel;
	
	@FindBy(xpath = "//li[@id='ssp_units_deactivate']")
	public WebElement DeActivate_ButtonLabel;
	
	@FindBy(xpath = "//li[@id='ssp_units_refresh']")
	public WebElement Refresh_ButtonLabel;
	
	@FindBy(xpath = "//li[@id='ssp_units_reset']")
	public WebElement Reset_ButtonLabel;
	
	@FindBy(xpath = "//li[@id='ssp_units_employees']")
	public WebElement Employees_ButtonLabel;
	
	@FindBy(xpath = "//li[@id='ssp_units_delete']")
	public WebElement unitsListPage_Deleteiconlabel;
	
		
	
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
	
	
	
	@FindBy(xpath = "//div[@class='k-window-titlebar k-header']//span[@class='k-window-title']")
	public WebElement ConfirmPopUpHeader;

	@FindBy(xpath = "//p[@translate='SSPUnits.UnitsForm-ConfirmDeactivateUnits']")
	public WebElement DeactivateUnitMessage;
	
	@FindBy(xpath = "//p[@translate='SSPUnits.UnitsForm-ConfirmActivateUnits']")
	public WebElement ActivateUnitMessage;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonYes']")
	public WebElement YesButton;
	
	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonNo']")
	public WebElement NoButton;

	@FindBy(xpath = "//span[@class='k-icon k-i-close' and text()='Close']")
	public WebElement XButtontocloseConfirmpopup;
	
	
	
	
	@FindBy(xpath = "//span[@class='k-window-title' and text()='Confirm']")
	public WebElement ConfirmDeleteDialoglabel;
	
	
	@FindBy(xpath = "//p[@class='ng-scope' and @translate='SSPUnits.UnitsForm-ConfirmDeleteUnits']")
	public WebElement deleteconfirmationMessage;
	
	
	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonYes']")
	public WebElement YesButtoninDeleteConfirmation;
	
	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonNo']")
	public WebElement NoButtoninDeleteConfirmation;
	
	
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

	/**
	 * Method to select the Tenant from the Drop down.
	 * @param _TenantName
	 * @throws InterruptedException
	 */
	public void selectTenant(String _TenantName) throws InterruptedException {
		//clickElementUsingJavaScript(TenantDropDown);
		clickElementUsingJavaScript(TenantDropDown);
		WebElement selectTenant = driver.findElement(By.xpath("//ul[@class='k-list k-reset']//li[@class='k-item ng-scope' and text()='"+_TenantName+"']"));
		Thread.sleep(3000);
		clickElementUsingJavaScript(selectTenant);
		log("Selected tenant as "+_TenantName);
		
	}

	/**
	 * Click on the + Add new units
	 */
	public void clickonAddUnitslist() {
		wh.waitForElementToBeClickable(Add_ButtonLabel, driver, 10);
		clickElementUsingJavaScript(Add_ButtonLabel);
		
	}
	
	
	/**
	 * Click on edit to edit the selected unit
	 */
	public void clickonEdit() {
		wh.waitForElementToBeClickable(Edit_ButtonLabel, driver, 10);
		clickElementUsingJavaScript(Edit_ButtonLabel);
		
	}
	
	
	public String searchAndSelectUnitCreated(String _CreatedUnitName, String _CreatedUnitLocale,String _CreatedUnitAddress) throws InterruptedException {
		status = "FAIL";
		Thread.sleep(8000);
		List<WebElement> unitsRows = driver.findElements(By.xpath("//div[@class='ng-scope k-grid k-widget' and @kendo-grid='model.unitsGrid']//tbody//tr"));
		log("No of rows found for unit list is "+unitsRows.size());
		for(int i=0;i<unitsRows.size();i++) {
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
	
	public String verifyIconLabelsinUnitsPage(String _AddLabelUnitpage,String _EditlabelUnitpage,String _ActivatelabelUnitpage,String _DeactivatelabelUnitpage,
			String _RefreshlabelUnitpage,String _ResetlabelUnitpage,String _EmployesslabelUnitpage) throws InterruptedException {
		status="FAIL";
		
		if(Add_ButtonLabel.getText().equals(_AddLabelUnitpage)){
			log(Add_ButtonLabel.getText()+" label is displayed in the Units page");
			if(Edit_ButtonLabel.getText().equals(_EditlabelUnitpage)) {
				log(Edit_ButtonLabel.getText()+" label is displayed in the Units page");
				if(Activate_ButtonLabel.getText().equals(_ActivatelabelUnitpage)) {
					log(Activate_ButtonLabel.getText()+" label is displayed in the Units page");
					if(DeActivate_ButtonLabel.getText().equals(_DeactivatelabelUnitpage)) {
						log(DeActivate_ButtonLabel.getText()+" label is displayed in the Units page");
						if(Refresh_ButtonLabel.getText().equals(_RefreshlabelUnitpage)) {
							log(Refresh_ButtonLabel.getText()+" label is displayed in the Units page");
							if(Reset_ButtonLabel.getText().equals(_ResetlabelUnitpage)) {
								log(Reset_ButtonLabel.getText()+" label is displayed in the Units page");
								log(Employees_ButtonLabel.getText()+" label is displayed in the Units page");
								if(Employees_ButtonLabel.getText().equals(_EmployesslabelUnitpage)) {
									log(Employees_ButtonLabel.getText()+" label is displayed in the Units page");
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
			if(ActivateUnitMessage.getText().equals(_ActivateConfirmationMsg)) {
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
			if(DeactivateUnitMessage.getText().equals(_DeactivateConfirmationMsg)) {
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
	wh.waitForElementToBeClickable(unitsListPage_Deleteiconlabel, driver, 10);
	clickElementUsingJavaScript(unitsListPage_Deleteiconlabel);
	log("Clicked on the Delete icon ");
	takeScreenShot();
	
}

public String verifyConfirmDeletePopUpLabelsAndClickX(String _DeleteUnitConfirmMsg,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
	status="FAIL";
	log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
	if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
		log("Message is displayed -> "+deleteconfirmationMessage.getText());
		if(deleteconfirmationMessage.getText().equals(_DeleteUnitConfirmMsg)) {
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

public String verifyConfirmDeletePopUpLabelsAndClickNo(String _UnitName,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
	status="FAIL";
	log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
	if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
		log("Message is displayed -> "+deleteconfirmationMessage.getText());
		if(deleteconfirmationMessage.getText().equals("Do you want to delete unit '"+_UnitName+"'?")) {
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

public String verifyConfirmDeletePopUpLabelsAndClickYes(String _UnitName,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
	status="FAIL";
	log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
	if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
		log("Message is displayed -> "+deleteconfirmationMessage.getText());
		if(deleteconfirmationMessage.getText().equals("Do you want to delete unit '"+_UnitName+"'?")) {
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


public String clickYesDeleteConfirmation(String _UnitName) throws InterruptedException {
	status="FAIL";
					takeScreenShot();
					if(deleteconfirmationMessage.getText().equals("Do you want to delete unit '"+_UnitName+"'?")) {
					wh.waitForElementToBeClickable(YesButtoninDeleteConfirmation, driver, 10);
					YesButtoninDeleteConfirmation.click();
					log("clicked on yes icon");
					status="PASS";
					}
					return status;


}
	
}
	