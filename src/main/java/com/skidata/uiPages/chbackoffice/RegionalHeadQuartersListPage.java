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
public class RegionalHeadQuartersListPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;


	public static final Logger log = Logger.getLogger(RegionalHeadQuartersListPage.class.getName());



	//Class constructor
	public RegionalHeadQuartersListPage(WebDriver driver,ExtentTest test) {
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

	@FindBy(xpath = "//div[@id='ssp_regionalhq_tenant']/span/span/span")
	public WebElement TenantDropDown;

	@FindBy(xpath = "//p[@class='ng-scope' and @translate='Regional headoffices list']")
	public WebElement Regionalhqlistpageheader;

	@FindBy(xpath = "//li[@id='ssp_regionalhq_add']")
	public WebElement Add_ButtonLabel;

	@FindBy(xpath = "//li[@id='ssp_regionalhq_edit']")
	public WebElement Edit_ButtonLabel;

	@FindBy(xpath = "//li[@id='ssp_regionalhq_delete']")
	public WebElement Delete_ButtonLabel;

	@FindBy(xpath = "//li[@id='ssp_regionalhq_activate']")
	public WebElement Activate_ButtonLabel;

	@FindBy(xpath = "//li[@id='ssp_regionalhq_deactivate']")
	public WebElement DeActivate_ButtonLabel;

	@FindBy(xpath = "//li[@id='ssp_regionalhq_refresh']")
	public WebElement Refresh_ButtonLabel;

	@FindBy(xpath = "//li[@id='ssp_regionalhq_reset']")
	public WebElement Reset_ButtonLabel;

	@FindBy(xpath = "//li[@id='ssp_regionalhq_employees']")
	public WebElement Employees_ButtonLabel;

	@FindBy(xpath = "//span[@translate='SSPRegionalHeadQuarter.GridColumnHeader-Name']")
	public WebElement NameColumn;

	@FindBy(xpath = "//span[@translate='SSPRegionalHeadQuarter.GridColumnHeader-locale']")
	public WebElement LocaleColumn;

	@FindBy(xpath = "//span[@translate='SSPRegionalHeadQuarter.GridColumnHeader-timeZone']")
	public WebElement TimeZoneColumn;

	@FindBy(xpath = "//span[@translate='SSPRegionalHeadQuarter.GridColumnHeader-address']")
	public WebElement AddressColumn;

	@FindBy(xpath = "//span[@translate='SSPRegionalHeadQuarter.GridColumnHeader-status']")
	public WebElement StatusColumn;

	@FindBy(xpath = "//span[@class='k-window-title' and text()='Confirm']")
	public WebElement ConfirmDeleteDialoglabel;

	@FindBy(xpath = "//p[@class='ng-scope' and @translate='SSPRegionalHeadQuarter.RegionalHeadQuarterForm-ConfirmDeleteRegionalHeadQuarter']")
	public WebElement deleteconfirmationMessage;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonYes']")
	public WebElement YesButtoninDeleteConfirmation;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonNo']")
	public WebElement NoButtoninDeleteConfirmation;

	@FindBy(xpath = "//span[@class='k-icon k-i-close']")
	public WebElement closeXiconinDeleteConfirmationPopup;

	@FindBy(xpath = "//div[@class='k-window-titlebar k-header']//span[@class='k-window-title']")
	public WebElement ConfirmPopUpHeader;

	@FindBy(xpath = "//p[@translate='SSPRegionalHeadQuarter.RegionalHeadQuarterForm-ConfirmDeactivateRegionalHeadQuarter']")
	public WebElement DeactivateRHQMessage;

	@FindBy(xpath = "//p[@translate='SSPRegionalHeadQuarter.RegionalHeadQuarterForm-ConfirmActivateRegionalHeadQuarter']")
	public WebElement ActivateRHQMessage;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonYes']")
	public WebElement YesButton;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonNo']")
	public WebElement NoButton;

	@FindBy(xpath = "//span[@class='k-icon k-i-close' and text()='Close']")
	public WebElement XButtontocloseConfirmpopup;

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
		Thread.sleep(6000);
		clickElementUsingJavaScript(selectTenant);
		log("Tenant is selected");
	}

	/**
	 * Click on the + Add new Headquarter
	 */
	public void clickonAddRegionalHeadquarter() {
		wh.waitForElementToBeClickable(Add_ButtonLabel, driver, 10);
		clickElementUsingJavaScript(Add_ButtonLabel);

	}

	public String verifyIconLabelRegionalHQlistPage(String _Addlabel,String _Editlabel,String _Deletelabel,String _Activatelabel,
			String _Deactivatelabel,String _Refreshlabel,String _Resetlabel,String _Employeeslabel) {

		status="FAIL";
		wh.waitForElementToBeVisible(Add_ButtonLabel, driver, 10);

		if(Add_ButtonLabel.getText().equals(_Addlabel)) {
			log(Add_ButtonLabel.getText() +" label is displayed in Regional HQlist page");
			if(Edit_ButtonLabel.getText().equals(_Editlabel)) {
				log(Edit_ButtonLabel.getText() +" label is displayed in Regional HQlist page");
				if(Delete_ButtonLabel.getText().equals(_Deletelabel)) {
					log(Delete_ButtonLabel.getText() +" label is displayed in Regional HQlist page");
					if(Activate_ButtonLabel.getText().equals(_Activatelabel)) {
						log(Activate_ButtonLabel.getText() +" label is displayed in Regional HQlist page");
						if(DeActivate_ButtonLabel.getText().equals(_Deactivatelabel)) {
							log(DeActivate_ButtonLabel.getText() +" label is displayed in Regional HQlist page");
							if(Refresh_ButtonLabel.getText().equals(_Refreshlabel)) {
								log(Refresh_ButtonLabel.getText() +" label is displayed in Regional HQlist page");
								if(Reset_ButtonLabel.getText().equals(_Resetlabel)) {
									log(Reset_ButtonLabel.getText() +" label is displayed in Regional HQlist page");
									if(Employees_ButtonLabel.getText().equals(_Employeeslabel)) {
										log(Employees_ButtonLabel.getText() +" label is displayed in Regional HQlist page");
										status="PASS";
										takeScreenShot();
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

	public String verifyRegionalHQListPageHeader(String _RegionalHQlistPageHeader) {

		status="FAIL";
		if(Regionalhqlistpageheader.getText().equals(_RegionalHQlistPageHeader)) {
			log("Header of the regional hq list is displayed as => "+_RegionalHQlistPageHeader);
			status="PASS";

		}
		return status;


	}

	public String verifyTableColumnHeaders(String _NameCol,String _LocaleCol,String _Timezonecol,String _Addresscol,String _Statuscol) {
		status="FAIL";

		if(NameColumn.getText().equals(_NameCol)) {
			log("Column displayed in the table ->"+NameColumn.getText());
			if(LocaleColumn.getText().equals(_LocaleCol)) {
				log("Column displayed in the table ->"+LocaleColumn.getText());
				if(TimeZoneColumn.getText().equals(_Timezonecol)) {
					log("Column displayed in the table ->"+TimeZoneColumn.getText());
					if(AddressColumn.getText().equals(_Addresscol)) {
						log("Column displayed in the table ->"+AddressColumn.getText());
						if(StatusColumn.getText().equals(_Statuscol)) {
							log("Column displayed in the table ->"+StatusColumn.getText());
							status="PASS";
							takeScreenShot();

						}
					}
				}
			}
		}
		return status;

	}

	public String searchAndSelectRegionalHeadquarterCreated(String _CreatedRegionalHqName,String _CreatedRegionalHQlocale,
			String _CreatedRegionalHqTimeZone,String _CreatedRegionalHqAddress,String _CreatedRegionalHqStatus) throws InterruptedException {

		status = "FAIL";
		Thread.sleep(10000);

		List<WebElement> tenantRows = driver.findElements(By.xpath("//div[@class='ng-scope k-grid k-widget' and @kendo-grid='model.regionalHeadQuartersGrid']//tbody//tr"));
		log("No of rows found for regional headquarters list is "+tenantRows.size());
		for(int i=0;i<tenantRows.size();i++) {
			int j=i+1;

			WebElement NameColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[1]"));
			WebElement LocaleColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[2]"));
			WebElement TimeZoneColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[3]"));
			WebElement AddressColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[4]"));
		

			if(NameColumnValue.getText().equals(_CreatedRegionalHqName)) {		
				log(LocaleColumnValue.getText());
				if(LocaleColumnValue.getText().equals(_CreatedRegionalHQlocale)) {
					log(NameColumnValue.getText()+" "+LocaleColumnValue.getText()+" "+TimeZoneColumnValue.getText()+" "+AddressColumnValue.getText()+" -> is displayed in the Table");
					log(AddressColumnValue.getText());

					if(AddressColumnValue.getText().equals(_CreatedRegionalHqAddress)) {
						log("Address displayed as ->"+AddressColumnValue.getText());
							driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]")).click();
							log("Regional Headquarter is -> "+_CreatedRegionalHqName+" is Searched and Selected ");
							status ="PASS";
						
					}
				}
			}
		}

		return status;

	}

	public void clickonEdit() {
		wh.waitForElementToBeClickable(Edit_ButtonLabel, driver, 10);
		Edit_ButtonLabel.click();
		log("Clicked on the Edit button");

	}

	public void clickonDelete() {

		wh.waitForElementToBeClickable(Delete_ButtonLabel, driver, 10);
		Delete_ButtonLabel.click();
		log("Clicked on the Delete button");
		takeScreenShot();
	}

	public String verifyConfirmDeletePopUpLabelsAndClickX(String _ConfirmMessageRHQDelete,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
		status="FAIL";
		log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
		if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
			log("Message is displayed -> "+deleteconfirmationMessage.getText());
			if(deleteconfirmationMessage.getText().equals(_ConfirmMessageRHQDelete)) {
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


	public String verifyConfirmDeletePopUpLabelsAndClickNo(String _ConfirmMessageRHQDelete,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
		status="FAIL";
		log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
		if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
			log("Message is displayed -> "+deleteconfirmationMessage.getText());
			if(deleteconfirmationMessage.getText().equals(_ConfirmMessageRHQDelete)) {
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


	public String verifyConfirmDeletePopUpLabelsAndClickYes(String _ConfirmMessageRHQDelete,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
		status="FAIL";
		log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
		if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
			log("Message is displayed -> "+deleteconfirmationMessage.getText());
			if(deleteconfirmationMessage.getText().equals(_ConfirmMessageRHQDelete)) {
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


	public void clickonDeactivate() {
		wh.waitForElementToBeVisible(DeActivate_ButtonLabel, driver, 10);
		DeActivate_ButtonLabel.click();
		log("clicked on the Deactivate icon");
		takeScreenShot();

	}

	public void clickonActivate() {
		takeScreenShot();
		Activate_ButtonLabel.click();
		log("clicked on Activate");

	}


	public String verifyDeactivateDialogPopup(String _ConfirmPopupHeader,String _DeactivateConfirmationMsg,String _YesButtonLabel,String _NoButtonlabel) {

		status="FAIL";
		wh.waitForElementToBeVisible(ConfirmPopUpHeader, driver, 10);
		if(ConfirmPopUpHeader.getText().equals(_ConfirmPopupHeader)) {
			if(DeactivateRHQMessage.getText().equals(_DeactivateConfirmationMsg)) {
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



	public String verifyRegionalHeadquarterStatus(String _ActiveOrDeactive) throws InterruptedException {
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

	public void clickonDeactivateNoButton() {
		takeScreenShot();
		NoButton.click();
		log("clicked on No button in the Deactivate Regional headquarter confirm dialog");


	}

	public void clickonDeactivateXToClose() {
		takeScreenShot();
		XButtontocloseConfirmpopup.click();
		log("clicked on the X to close the confirm dialog");

	}

	public void clickonDeactivateYes() {
		takeScreenShot();
		YesButton.click();
		log("clicked on the Yes to Deactivate Regional headquarter");

	}


	public void clickonActivateNoButton() {
		takeScreenShot();
		wh.waitForElementToBeClickable(NoButton, driver, 10);
		NoButton.click();
		log("clicked on No button in the Activate Regional headquarter confirm dialog");

	}

	public void clickonActivateXToClose() {
		takeScreenShot();
		XButtontocloseConfirmpopup.click();
		log("clicked on the X to close the confirm dialog");

	}

	public void clickonActivateYes() {
		takeScreenShot();
		YesButton.click();
		log("clicked on the Yes to Activate Regional headquarter");

	}


	public String verifyActivateDialogPopup(String _ConfirmPopupHeader,String _ActivateConfirmationMsg,String _YesButtonLabel,String _NoButtonlabel) throws InterruptedException {

		status="FAIL";
		Thread.sleep(5000);
		if(ConfirmPopUpHeader.getText().equals(_ConfirmPopupHeader)) {
			log(ConfirmPopUpHeader.getText()+" is displayed in UI");
			if(ActivateRHQMessage.getText().equals(_ActivateConfirmationMsg)) {
				log(ActivateRHQMessage.getText()+" is displayed in UI");
				if(YesButton.getText().equals(_YesButtonLabel)) {
					log(YesButton.getText()+" is displayed in UI");
					if(NoButton.getText().equals(_NoButtonlabel)) {
						log(NoButton.getText()+" is displayed in UI");
						status="PASS";
						takeScreenShot();
					}
				}
			}
		}
		return status;

	}







}