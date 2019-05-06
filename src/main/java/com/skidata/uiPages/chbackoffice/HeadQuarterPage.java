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
public class HeadQuarterPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status = null;


	public static final Logger log = Logger.getLogger(HeadQuarterPage.class.getName());



	//Class constructor
	public HeadQuarterPage(WebDriver driver,ExtentTest test) {
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

	@FindBy(xpath ="//div[@id='ssp_headquarter_tenant']/span/span")	 	
	public WebElement TenantDropDown;

	@FindBy(xpath = "//li[@id='ssp_headquarter_add']")
	public WebElement Add_ButtonLabel;

	@FindBy(xpath = "//li[@id='ssp_headquarter_edit']")
	public WebElement Edit_ButtonLabel;

	@FindBy(xpath = "//li[@id='ssp_headquarter_activate']")
	public WebElement Activate_ButtonLabel;

	@FindBy(xpath = "//li[@id='ssp_headquarter_deactivate']")
	public WebElement DeActivate_ButtonLabel;

	@FindBy(xpath = "//li[@id='ssp_headquarter_refresh']")
	public WebElement Refresh_ButtonLabel;

	@FindBy(xpath = "//li[@id='ssp_headquarter_reset']")
	public WebElement Reset_ButtonLabel;

	@FindBy(xpath = "//li[@id='ssp_headquarter_employees']")
	public WebElement Employees_ButtonLabel;

	@FindBy(xpath = "//div[@class='k-window-titlebar k-header']//span[@class='k-window-title']")
	public WebElement ConfirmPopUpHeader;

	@FindBy(xpath = "//p[@translate='SSPHeadQuarter.HeadQuarterForm-ConfirmDeactivateHeadQuarter']")
	public WebElement DeactivateHQMessage;

	@FindBy(xpath = "//p[@translate='SSPHeadQuarter.HeadQuarterForm-ConfirmActivateHeadQuarter']")
	public WebElement ActivateHQMessage;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonYes']")
	public WebElement YesButton;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonNo']")
	public WebElement NoButton;

	@FindBy(xpath = "//span[@class='k-icon k-i-close' and text()='Close']")
	public WebElement XButtontocloseConfirmpopup;

	@FindBy(xpath = "//p[@class='ng-scope' and @translate='Add headquarter']")
	public WebElement AddheadquarterTitle;
	
	/**
	 * Method to select the Tenant from the Drop down.
	 * @param _TenantName
	 * @throws InterruptedExceptio
	 */
	public void selectTenant(String _TenantName) throws InterruptedException {
		//clickElementUsingJavaScript(TenantDropDown);
//		TenantDropDown.click();
		clickElementUsingJavaScript(TenantDropDown);
		WebElement selectTenant = driver.findElement(By.xpath("//ul[@class='k-list k-reset']//li[@class='k-item ng-scope' and text()='"+_TenantName+"']"));
		Thread.sleep(3000);
		clickElementUsingJavaScript(selectTenant);
		log("Tenant is selected");
	}

	/**
	 * To verify the add button hide for the tenant
	 * @return 
	 */
	
	public String verifyAddButtonHide(String _EditlabelHQpage,String _ActivatelabelHQpage,String _DeactivatelabelHQpage,
			String _RefreshlabelHQpage,String _ResetlabelHQpage,String _EmployesslabelHQpage) throws InterruptedException {
		status="FAIL";
			if(Edit_ButtonLabel.getText().equals(_EditlabelHQpage)) {
				log(Edit_ButtonLabel.getText()+" label is displayed in the Headquarter page");
				if(Activate_ButtonLabel.getText().equals(_ActivatelabelHQpage)) {
					log(Activate_ButtonLabel.getText()+" label is displayed in the Headquarter page");
					if(DeActivate_ButtonLabel.getText().equals(_DeactivatelabelHQpage)) {
						log(DeActivate_ButtonLabel.getText()+" label is displayed in the Headquarter page");
						if(Refresh_ButtonLabel.getText().equals(_RefreshlabelHQpage)) {
							log(Refresh_ButtonLabel.getText()+" label is displayed in the Headquarter page");
							if(Reset_ButtonLabel.getText().equals(_ResetlabelHQpage)) {
								log(Reset_ButtonLabel.getText()+" label is displayed in the Headquarter page");
								log(Employees_ButtonLabel.getText()+" label is displayed in the Headquarter page");
								if(Employees_ButtonLabel.getText().equals(_EmployesslabelHQpage)) {
									log(Employees_ButtonLabel.getText()+" label is displayed in the Headquarter page");
									Thread.sleep(3000);
									takeScreenShot();
									status="PASS";

								}
							}
						}
					}
			}
		}
		return status;

	}
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
	 * Click on the + Add new Headquarter
	 */
	public void clickonAdd() {
		wh.waitForElementToBeClickable(Add_ButtonLabel, driver, 10);
		Add_ButtonLabel.click();

	}

	public String searchAndSelectHeadquarterCreated(String _CreatedHeadquarterName, String _CreatedHeadquarterLocale,String _CreatedHeadquarterAddress) throws InterruptedException {
		status = "FAIL";
		Thread.sleep(8000);

		List<WebElement> tenantRows = driver.findElements(By.xpath("//table[@class='k-selectable']/tbody/tr"));
		log("No of rows found for headquarter list is "+tenantRows.size());
		for(int i=0;i<tenantRows.size();i++) {
			int j=i+1;


			WebElement NameColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[1]"));
			WebElement LocaleColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[2]"));
			WebElement TimeZone = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[3]"));
			WebElement Address = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[4]"));

			if(NameColumnValue.getText().equals(_CreatedHeadquarterName)) {		
				if(LocaleColumnValue.getText().equals(_CreatedHeadquarterLocale)) {
					log(NameColumnValue.getText()+" "+LocaleColumnValue.getText()+" "+TimeZone.getText()+" "+Address.getText()+" -> is displayed in the Table");
					log(Address.getText());

					if(Address.getText().equals(_CreatedHeadquarterAddress)) {

						driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]")).click();
						log("Headquarter is -> "+_CreatedHeadquarterName+" is Searched and Selected ");
						status ="PASS";
						return status;
					}
				}
			}

		}

		return status;

	}


	public String verifyIconLabelsinHeadquarterPage(String _AddLabelHQpage,String _EditlabelHQpage,String _ActivatelabelHQpage,String _DeactivatelabelHQpage,
			String _RefreshlabelHQpage,String _ResetlabelHQpage,String _EmployesslabelHQpage) throws InterruptedException {
		status="FAIL";

		if(Add_ButtonLabel.getText().equals(_AddLabelHQpage)){
			log(Add_ButtonLabel.getText()+" label is displayed in the Headquarter page");
			if(Edit_ButtonLabel.getText().equals(_EditlabelHQpage)) {
				log(Edit_ButtonLabel.getText()+" label is displayed in the Headquarter page");
				if(Activate_ButtonLabel.getText().equals(_ActivatelabelHQpage)) {
					log(Activate_ButtonLabel.getText()+" label is displayed in the Headquarter page");
					if(DeActivate_ButtonLabel.getText().equals(_DeactivatelabelHQpage)) {
						log(DeActivate_ButtonLabel.getText()+" label is displayed in the Headquarter page");
						if(Refresh_ButtonLabel.getText().equals(_RefreshlabelHQpage)) {
							log(Refresh_ButtonLabel.getText()+" label is displayed in the Headquarter page");
							if(Reset_ButtonLabel.getText().equals(_ResetlabelHQpage)) {
								log(Reset_ButtonLabel.getText()+" label is displayed in the Headquarter page");
								log(Employees_ButtonLabel.getText()+" label is displayed in the Headquarter page");
								if(Employees_ButtonLabel.getText().equals(_EmployesslabelHQpage)) {
									log(Employees_ButtonLabel.getText()+" label is displayed in the Headquarter page");
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

	public void clickonDeactivate() {
		DeActivate_ButtonLabel.click();
		log("clicked on the Deactivate icon");
		takeScreenShot();

	}

	public String verifyDeactivateDialogPopup(String _ConfirmPopupHeader,String _DeactivateConfirmationMsg,String _YesButtonLabel,String _NoButtonlabel) {

		status="FAIL";
		wh.waitForElementToBeVisible(ConfirmPopUpHeader, driver, 10);
		if(ConfirmPopUpHeader.getText().equals(_ConfirmPopupHeader)) {
			if(DeactivateHQMessage.getText().equals(_DeactivateConfirmationMsg)) {
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

	public void clickonDeactivateNoButton() {
		takeScreenShot();
		NoButton.click();
		log("clicked on No button in the Deactivate headquarter confirm dialog");


	}

	public void clickonDeactivateXToClose() {
		takeScreenShot();
		XButtontocloseConfirmpopup.click();
		log("clicked on the X to close the confirm dialog");

	}

	public void clickonDeactivateYes() {
		takeScreenShot();
		YesButton.click();
		log("clicked on the Yes to Deactivate Headquarter");

	}

	public String verifyHeadquarterStatus(String _ActiveOrDeactive) throws InterruptedException {
		status="FAIL";
		Thread.sleep(5000);
		WebElement ActiveOrDeactive = driver.findElement(By.xpath("//table[@class='k-selectable']//tr//td[5]"));
		if(ActiveOrDeactive.getText().equals(_ActiveOrDeactive)) {
			status="PASS";
			takeScreenShot();
			log("Status of the Headquarter is -> "+ActiveOrDeactive.getText());
		}
		return status;

	}

	public void clickonActivate() {
		takeScreenShot();
		Activate_ButtonLabel.click();
		log("clicked on Activate");

	}


	public String verifyActivateDialogPopup(String _ConfirmPopupHeader,String _ActivateConfirmationMsg,String _YesButtonLabel,String _NoButtonlabel) throws InterruptedException {

		status="FAIL";
		Thread.sleep(5000);
		if(ConfirmPopUpHeader.getText().equals(_ConfirmPopupHeader)) {
			if(ActivateHQMessage.getText().equals(_ActivateConfirmationMsg)) {
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
		log("clicked on No button in the Activate headquarter confirm dialog");

	}

	public void clickonActivateXToClose() {
		takeScreenShot();
		XButtontocloseConfirmpopup.click();
		log("clicked on the X to close the confirm dialog");

	}

	public void clickonActivateYes() {
		takeScreenShot();
		YesButton.click();
		log("clicked on the Yes to Activate Headquarter");

	}

	public void clickonEdit() {
		takeScreenShot();
		Edit_ButtonLabel.click();
		log("clicked on the Edit button");

	}

}

