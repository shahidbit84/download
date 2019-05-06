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
public class SalesChannelListPage extends TestBase {
	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;


	public static final Logger log = Logger.getLogger(SalesChannelListPage.class.getName());



	public SalesChannelListPage(WebDriver driver,ExtentTest test) {
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

	@FindBy(xpath = "//span[@translate='VSMCommon.ProgressLoading']")
	public WebElement loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;

	@FindBy(xpath = "//div[@id='ssp_saleschannel_tenant']/span/span/span")
	public WebElement TenantDropDown;

	@FindBy(xpath = "//*[@id='ssp_saleschannel_add']")
	public WebElement SalesChannelListPage_Addiconlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='CH.ButtonEdit']")
	public WebElement SalesChannelListPage_Editiconlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='CH.ButtonConfirmDelete']")
	public WebElement SalesChannelListPage_Deleteiconlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='CH.ButtonActivate']")
	public WebElement SalesChannelListPage_Activateiconlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='CH.ButtonDeActivate']")
	public WebElement SalesChannelListPage_Deactivateiconlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPSalesChannel.ToolbarConfigure']")
	public WebElement SalesChannelListPage_Configureiconlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='CH.buttonRefresh']")
	public WebElement SalesChannelListPage_Refreshlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='CH.ButtonReset']")
	public WebElement SalesChannelListPage_Resetlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPSalesChannel.ToolbarGetEmployees']")
	public WebElement SalesChannelListPage_Employeeslabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPSalesChannel.ToolbarGetArticles']")
	public WebElement SalesChannelListPage_Articleslabel;

	@FindBy(xpath = "//p[@class='ng-scope' and @translate='Sales channels list']")
	public WebElement SalesChannelListPage_Header;


	@FindBy(xpath = "//*[@id='ssp_saleschannel_captions']")
	public WebElement SalesChannelListPage_Captionslabel;


	@FindBy(xpath = "//div[12]//div[@class='k-window-titlebar k-header']//span[@class='k-window-title']")
	public WebElement ConfirmPopUpHeaderDeactivate;

	@FindBy(xpath = "//div[14]//div[@class='k-window-titlebar k-header']//span[@class='k-window-title']")
	public WebElement ConfirmPopUpHeaderActivate;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='CH.ButtonActivate']")
	public WebElement Activate_ButtonLabel;

	@FindBy(xpath = "//p[@translate='SSPSalesChannel.SalesChannelForm-ConfirmDeactivateSalesChannel']")
	public WebElement DeactivateSaleschannelMessage;

	@FindBy(xpath = "//p[@translate='SSPSalesChannel.SalesChannelForm-ConfirmActivateSalesChannel']")
	public WebElement ActivateSaleschannelMessage;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonYes']")
	public WebElement YesButton;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonNo']")
	public WebElement NoButton;

	@FindBy(xpath = "//html/body/div[14]/div[1]/div/a/span")
	public WebElement XButtontocloseConfirmpopup;

	@FindBy(xpath = "//span[@translate='SSPSalesChannel.ToolbarConfigureTheme']")
	public WebElement SalesChannelListPage_ConfigureThemelabel;

	@FindBy(xpath = "//li[@id='ssp_saleschannel_basedomain']")
	public WebElement SalesChannelListPage_BaseDomainlabel;

	@FindBy(xpath = "//span[@translate='SSPSalesChannel.ToolbarConfigureIdentification']")
	public WebElement SalesChannelListPage_Identificationlabel;

	@FindBy(xpath = "//span[@translate='SSPSalesChannel.ToolbarConfigureTermsAndConds']")
	public WebElement SalesChannelListPage_termsAndConditionlabel;

	@FindBy(xpath = "//*[@id='ssp_saleschannel_window_basedomain']//input[@ng-model='model.baseDomain']")
	public WebElement SalesChannelListPage_baseDomain_URL;

	@FindBy(xpath = "//*[@id='ssp_saleschannel_window_basedomain']/div//button[@translate='CH.ButtonSave']")
	public WebElement SalesChannelListPage_baseDomain_save;

	@FindBy(xpath = "//*[@id='ssp_saleschannel_window_terms']//input[@ng-model='model.termsAndConds']")
	public WebElement SalesChannelListPage_TermsAndCondition;

	@FindBy(xpath = "//*[@id='ssp_saleschannel_window_terms']//input[@ng-model='model.privacyPolicy']")
	public WebElement SalesChannelListPage_PrivacyPolicy;

	@FindBy(xpath = "//*[@id='ssp_saleschannel_window_terms']//div/button[@translate='CH.ButtonSave']")
	public WebElement SalesChannelListPage_PrivacyPolicySave;

	@FindBy(xpath = "//*[@id='ssp_saleschannel_window_terms']//div/button[@translate='CH.ButtonCancel']")
	public WebElement SalesChannelListPage_PrivacyPolicyCancel;


	@FindBy(xpath = "//*[@id='ssp_saleschannel_window_identifications']")
	public WebElement SalesChannelListPage_IdentificationCancel;


	@FindBy(xpath = "//*[@id='ssp_saleschannel_caption']//button[@translate='CH.ButtonCancel']")
	public WebElement SalesChannelListPage_captionCancel;


	@FindBy(xpath = "//*[@id='ssp_saleschannel_caption']//div//input[@v-model='model.selectedSalesChannel.headingsList1']")
	public WebElement SalesChannelListPage_captionHeading1;

	@FindBy(xpath = "//*[@id='ssp_saleschannel_caption']//textarea[@v-model='model.selectedSalesChannel.headingsList2']")
	public WebElement SalesChannelListPage_captionHeading2;

	@FindBy(xpath = "//*[@id='ssp_saleschannel_caption']//button[@translate='CH.ButtonSave']")
	public WebElement SalesChannelListPage_captionSave;



	@FindBy(xpath = "//span[@class='k-window-title' and text()='Confirm']")
	public WebElement ConfirmDeleteDialoglabel;

	@FindBy(xpath = "//p[@translate='SSPSalesChannel.SalesChannelForm-ConfirmDeleteSalesChannel']")
	public WebElement deleteconfirmationMessage;


	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonYes']")
	public WebElement YesButtoninDeleteConfirmation;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonNo']")
	public WebElement NoButtoninDeleteConfirmation;


	@FindBy(xpath = "//span[@class='k-icon k-i-close']")
	public WebElement closeXiconinDeleteConfirmationPopup;

	@FindBy(xpath = "//li[@id='ssp_saleschannel_terms']")
	public WebElement Configurationfooterinformationpopup;

	@FindBy(xpath = "//div[@id='//li[@id='ssp_saleschannel_terms']")
	public WebElement Footerinformationbutton;

	@FindBy(xpath = "//div[@id='//div[@class='v-toolbar-overflow-button v-flexbox v-flexbox-horizontal']")
	public WebElement saleschannelsettingdropdown;

	@FindBy(xpath = "//div[@class='k-animation-container']//div[@class='v-group ng-scope']//li[@id='ssp_saleschannel_terms']")
	public WebElement Configurefooterinformationinsettings;

	@FindBy(xpath = "//span[text()='FAQs url'][1]/../..//input")
	public WebElement FaqUrls;

	@FindBy(xpath = "//span[text()='Terms of use url'][1]/../..//input")
	public WebElement TermsofuseUrls;

	@FindBy(xpath = "//span[text()='Terms and conditions url'][1]/../..//input")
	public WebElement TermandconditionsUrls;

	@FindBy(xpath = "//span[text()='Privacy policy url'][1]/../..//input")
	public WebElement PrivacypolicyUrls;

	@FindBy(xpath = "//div[@id='ssp_saleschannel_window_terms']//button[text()='Save']")
	public WebElement Saveconfigurationfooterinformation;

	@FindBy(xpath = "//li[@id='ssp_saleschannel_settings']")
	public WebElement SaleschannelSettingbutton;

	@FindBy(xpath = "//label[@class='ng-isolate-scope']/span[text()='Base domain'][1]")
	public WebElement BaseDomainTab;

	@FindBy(xpath = "//span[text()='Base domain']/../..//input")
	public WebElement BaseDomainTextFiled;

	@FindBy(xpath = "//span[text()='Base domain']/../../../..//button[text()='Save']")
	public WebElement SaveButtonInBaseDomain;

	@FindBy(xpath = "//span[text()='FAQs url']/../../../..//button[text()='Save']")
	public WebElement SaveButtonInBFooterinformation;


	@FindBy(xpath = "//span[text()='Information']/../..//button[text()='OK']")
	public WebElement ConfirmationOkButtonInSaleschannelsettings;

	@FindBy(xpath = "//span[text()='Cancel'][1]")
	public WebElement CancelButtonInSaleschannelsettings;


	/**
	 * visibility for loading
	 */
	public void waitforInvisibilityOfLoading() {
		waitForElementInVisiblity(driver, 30, loadingprogress);
		log("loading progress completed");
	}


	/**
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnRefreshButton() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		SalesChannelListPage_Refreshlabel.click();
		log("Clicked on Refresh icon");
		takeScreenShot();
		log("Page is refreshed");
	}

	/**
	 * Method to click on the Add button in the Tenants list page to Add a new Tenant
	 */
	public void clickonAddSalesChannelIcon() {
		waitforInvisibilityOfLoading();
		wh.waitForElementToBeClickable(SalesChannelListPage_Addiconlabel, driver, 10);
		clickElementUsingJavaScript(SalesChannelListPage_Addiconlabel);
		log("Clicked on the Add icon label in the Sales channel list page");
		takeScreenShot();
	}

	/**
	 * Method to click the delete button in the list
	 *
	 */

	public void clickOnDeleteSalesChannel() {
		waitforInvisibilityOfLoading();
		wh.waitForElementToBeClickable(SalesChannelListPage_Deleteiconlabel, driver, 10);
		clickElementUsingJavaScript(SalesChannelListPage_Deleteiconlabel);
		log("Clicked on the delete icon label in the Sales channel list page");
		takeScreenShot();

	}


	/**
	 * To select the tenant
	 * @param _TenantName
	 * @throws InterruptedException
	 */
	public void selectTenant(String _TenantName) throws InterruptedException {
		//clickElementUsingJavaScript(TenantDropDown);
		clickElementUsingJavaScript(TenantDropDown);
		WebElement selectTenant = driver.findElement(By.xpath("//ul[@id='saleschannel_list_page_tenant_list_listbox']//li[@class='k-item ng-scope' and text()='"+_TenantName+"']"));
		Thread.sleep(3000);
		clickElementUsingJavaScript(selectTenant);
	}


	/**
	 * Identification button click
	 * @throws InterruptedException
	 */
	public void clickIdentification() throws InterruptedException {
		clickElementUsingJavaScript(SalesChannelListPage_Identificationlabel);
		Thread.sleep(3000);
	}

	/**
	 * Identification cancel button
	 * @throws InterruptedException
	 */
	public void clickIdentificationCancel() throws InterruptedException
	{
		Thread.sleep(3000);
		clickElementUsingJavaScript(SalesChannelListPage_IdentificationCancel);
	}

	/**
	 * Click caption button
	 * @throws InterruptedException
	 */
	public void clickCaption() throws InterruptedException {
		Thread.sleep(3000);
		clickElementUsingJavaScript(SalesChannelListPage_Captionslabel);
	}


	/**
	 * Caption page cancel functionality
	 */
	public void clickCaptionCancel() {

		clickElementUsingJavaScript(SalesChannelListPage_captionCancel);
	}



	/**
	 * To search and select the sale channel created	
	 * @param _CreatedSalesChannelName
	 * @param _CreatedSalesChannellocale
	 * @param _CreatedSalesChannelStatus
	 * @return
	 * @throws InterruptedException
	 */
	public String searchAndSelectSalesChannelCreated(String _CreatedSalesChannelName,String _CreatedSalesChannellocale,String _CreatedSalesChannelStatus) throws InterruptedException {
		status = "FAIL";
		Thread.sleep(8000);

		List<WebElement> saleschannels = driver.findElements(By.xpath("//div[@class='ng-scope k-grid k-widget' and @kendo-grid='model.salesChannelsGrid']//tbody//tr"));
		log("No of rows found for sales channel list is "+saleschannels.size());


		for(int i=0;i<saleschannels.size();i++) {
			int j=i+1;

			WebElement NameColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[1]"));
			WebElement LocaleColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[2]"));
			WebElement StatusColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[5]"));



			if(NameColumnValue.getText().equals(_CreatedSalesChannelName)) {		
				log(LocaleColumnValue.getText());
				//				log(_CreatedSalesChannellocale);
				if(LocaleColumnValue.getText().equals(_CreatedSalesChannellocale)) {
					log(NameColumnValue.getText()+" "+LocaleColumnValue.getText()+" "+StatusColumnValue.getText()+" -> is displayed in the Table");
					if(StatusColumnValue.getText().equals(_CreatedSalesChannelStatus)) {
						log("Status displayed as ->"+StatusColumnValue.getText());
						driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]")).click();
						log("SalesChannel is -> "+_CreatedSalesChannelName+" is Searched and Selected ");
						status ="PASS";
						takeScreenShot();
					}
				}
			}
		}

		return status;
	}



	/**
	 * To search and select the domain url already configured
	 * @param _DomainURL
	 * @return
	 * @throws InterruptedException
	 */
	public String searchAndSelectSalesChannelDomainURLCreated(String _DomainURL,String _Demodomainurl) throws InterruptedException {
		status = "PASS";
		Thread.sleep(5000);

		List<WebElement> saleschannels = driver.findElements(By.xpath("//div[@class='ng-scope k-grid k-widget' and @kendo-grid='model.salesChannelsGrid']//tbody//tr"));
		log("No of rows found for sales channel list is "+saleschannels.size());


		for(int i=0;i<saleschannels.size();i++) {
			int j=i+1;

			WebElement DomainNameColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td/span[@ng-bind='dataItem.baseDomain']"));
			System.out.println(DomainNameColumnValue.getText());
			System.out.println(_DomainURL);
			if(DomainNameColumnValue.getText().equals(_DomainURL)) {
				log("DomainURL displayed as ->"+DomainNameColumnValue.getText());
				driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td/span[@ng-bind='dataItem.baseDomain']")).click();
				log("SalesChannel is -> "+_DomainURL+" is Searched and Selected ");
				status ="PASS";
				takeScreenShot();

				//click on settings
				SaleschannelSettingbutton.click();
				Thread.sleep(2000);
				//click on Base domain tab
				BaseDomainTab.click();
				//click on base domain url text filed
				BaseDomainTextFiled.click();
				//clear base domain
				BaseDomainTextFiled.clear();
				//enter base domain url
				BaseDomainTextFiled.sendKeys(_Demodomainurl);

				//select save button
				SaveButtonInBaseDomain.click();
				Thread.sleep(1000);
				//select Ok in base domain confirmation pop-up
				ConfirmationOkButtonInSaleschannelsettings.click();

				//				clickonBasedomainIcon();
				//				editDomainURL(_Demodomainurl);
				//				status ="PASS";
				//				takeScreenShot();
				driver.findElement(By.xpath("//span[text()='Cancel'][1]")).click();
				Thread.sleep(2000);
				break;

			}

		}

		return status;

	}


	/**
	 * Edit of sales channel.
	 */
	public void clickonEdit() {
		wh.waitForElementToBeClickable(SalesChannelListPage_Editiconlabel, driver, 10);
		SalesChannelListPage_Editiconlabel.click();
		log("Clicked on Edit");

	}

	/**
	 * To verify sales channel header list page
	 * @param _SalesChannelListPage_Header
	 * @return
	 */
	public String verifyPageHeaderSalesChannelListPage(String _SalesChannelListPage_Header) {
		status="FAIL";
		if(SalesChannelListPage_Header.getText().equals(_SalesChannelListPage_Header)) {
			status="PASS";
			log("Page header is displayed as ->"+_SalesChannelListPage_Header);
			takeScreenShot();
		}
		return status;
	}

	/**
	 * To deactivate the sales channel
	 */
	public void clickonDeactivate() {
		wh.waitForElementToBeClickable(SalesChannelListPage_Deactivateiconlabel, driver, 10);
		SalesChannelListPage_Deactivateiconlabel.click();
		log("Clicked on the Deactivate icon");
		takeScreenShot();
	}

	/*
	 * 
	 * deactivate dialog verification
	 */
	public String verifyDeactivateDialogPopup(String _ConfirmPopupHeader,String _DeactivateConfirmationMsg,String _YesButtonLabel,String _NoButtonlabel) throws InterruptedException {

		status="FAIL";
		Thread.sleep(4000);
		//		if(ConfirmPopUpHeaderDeactivate.getText().equals(_ConfirmPopupHeader)) {
		//			log(ConfirmPopUpHeaderDeactivate.getText()+" is displayed in UI");
		if(DeactivateSaleschannelMessage.getText().equals(_DeactivateConfirmationMsg)) {
			if(YesButton.getText().equals(_YesButtonLabel)) {
				if(NoButton.getText().equals(_NoButtonlabel)) {
					status="PASS";
					takeScreenShot();
				}
			}
		}

		return status;

	}

	/**
	 * To verify activate of sales channel
	 * @param _ConfirmPopupHeader
	 * @param _ActivateConfirmationMsg
	 * @param _YesButtonLabel
	 * @param _NoButtonlabel
	 * @return
	 * @throws InterruptedException
	 */
	public String verifyActivateDialogPopup(String _ConfirmPopupHeader,String _ActivateConfirmationMsg,String _YesButtonLabel,String _NoButtonlabel) throws InterruptedException {

		status="FAIL";
		Thread.sleep(5000);
		//		if(ConfirmPopUpHeaderActivate.getText().equals(_ConfirmPopupHeader)) {
		//			log(ConfirmPopUpHeaderActivate.getText()+" is displayed in UI");
		if(ActivateSaleschannelMessage.getText().equals(_ActivateConfirmationMsg)) {
			log(ActivateSaleschannelMessage.getText()+" is displayed in UI");
			if(YesButton.getText().equals(_YesButtonLabel)) {
				log(YesButton.getText()+" is displayed in UI");
				if(NoButton.getText().equals(_NoButtonlabel)) {
					log(NoButton.getText()+" is displayed in UI");
					status="PASS";
					takeScreenShot();
				}
			}
		}
		return status;
	}


	/**
	 * To click 'x' on deactivate popup
	 */
	public void clickonDeactivateXToClose() {
		takeScreenShot();
		XButtontocloseConfirmpopup.click();
		log("clicked on the X to close the confirm dialog");

	}

	/**
	 * To click 'yes' in the deactivation confirmation popup.
	 */
	public void clickonDeactivateYes() {
		takeScreenShot();
		YesButton.click();
		log("clicked on the Yes to Deactivate Sales channel");

	}


	/**
	 * To click 'no' button in activate dialog box
	 */
	public void clickonActivateNoButton() {
		takeScreenShot();
		wh.waitForElementToBeClickable(NoButton, driver, 10);
		NoButton.click();
		log("clicked on No button in the Activate Sales channel confirm dialog");

	}

	/**
	 * Click on 'x' in activate dialog box
	 */
	public void clickonActivateXToClose() {
		takeScreenShot();
		XButtontocloseConfirmpopup.click();
		log("clicked on the X to close the confirm dialog");

	}

	public void clickonActivateYes() {
		takeScreenShot();
		YesButton.click();
		log("clicked on the Yes to Activate Sales channel");

	}

	public void clickonDeactivateNoButton() {
		takeScreenShot();
		NoButton.click();
		log("clicked on No button in the Deactivate Sales channel confirm dialog");


	}

	public void clickonActivate() {
		takeScreenShot();
		Activate_ButtonLabel.click();
		log("clicked on Activate");

	}

	public String verifyConfiguresubIconLabels(String _Themelabel,String _Basedomainlabel,String _Identificationslabel) {
		status="FAIL";


		if(SalesChannelListPage_ConfigureThemelabel.getText().equals(_Themelabel)) {
			log(SalesChannelListPage_ConfigureThemelabel.getText()+" is displayed in UI");
			if(SalesChannelListPage_BaseDomainlabel.getText().equals(_Basedomainlabel)) {
				log(SalesChannelListPage_BaseDomainlabel.getText()+" is displayed in UI");
				if(SalesChannelListPage_Identificationlabel.getText().equals(_Identificationslabel)) {
					log(SalesChannelListPage_Identificationlabel.getText()+" is displayed in UI");
					status="PASS";
					takeScreenShot();
					log("Configure sub icon labels are displayed in page");
				}
			}
		}
		return status;

	}

	public String verifySalesChannelListPageIconLabels(String _Addlabel, String _Editlabel, String _Deletelabel,String _Activatelabbel,
			String _Deactivatelabel,String _Configurelabel,String _Refreshlabel,String _Resetlabel,String _Employeeslable,String _Articleslabel) {
		status="FAIL";

		if(SalesChannelListPage_Addiconlabel.getText().equals(_Addlabel)) {
			log(SalesChannelListPage_Addiconlabel.getText()+" label is displayed in UI");
			if(SalesChannelListPage_Editiconlabel.getText().equals(_Editlabel)) {
				log(SalesChannelListPage_Editiconlabel.getText()+" label is displayed in UI");
				if(SalesChannelListPage_Deleteiconlabel.getText().equals(_Deletelabel)) {
					log(SalesChannelListPage_Deleteiconlabel.getText()+" label is displayed in UI");
					if(SalesChannelListPage_Configureiconlabel.getText().equals(_Configurelabel)) {
						log(SalesChannelListPage_Configureiconlabel.getText()+" label is displayed in UI");
						if(SalesChannelListPage_Refreshlabel.getText().equals(_Refreshlabel)) {
							log(SalesChannelListPage_Refreshlabel.getText()+" label is displayed in UI");
							if(SalesChannelListPage_Employeeslabel.getText().equals(_Employeeslable)) {
								log(SalesChannelListPage_Employeeslabel.getText()+" label is displayed in UI");
								if(SalesChannelListPage_Articleslabel.getText().equals(_Articleslabel)) {
									log(SalesChannelListPage_Articleslabel.getText()+" label is displayed in UI");
									status="PASS";
									takeScreenShot();
								}
							}
						}
					}
				}
			}
		}

		return status;
	}

	public void clickonRefresh() throws InterruptedException {
		takeScreenShot();
		SalesChannelListPage_Refreshlabel.click();
		log("clicked on Refresh");
		takeScreenShot();
		Thread.sleep(3000);

	}

	public void clickonThemeIcon() {
		takeScreenShot();
		SalesChannelListPage_ConfigureThemelabel.click();
		log("clicked on Theme icon");
		wh.waitForElementToBeInvisible(loadingprogress, driver, 10);
		takeScreenShot();


	}

	public void clickonBasedomainIcon() throws InterruptedException {
		boolean Basedomain = SalesChannelListPage_BaseDomainlabel.isDisplayed();
		if(Basedomain==true)
		{
			wh.waitForElementToBeClickable(SalesChannelListPage_BaseDomainlabel, driver, 10);
			Thread.sleep(3000);
			SalesChannelListPage_BaseDomainlabel.click();
			log("Clicked on the Base domain icon");
			takeScreenShot();
		}
		else
		{
			driver.findElement(By.xpath("//div[@class='v-toolbar-overflow-button v-flexbox v-flexbox-horizontal']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='k-animation-container']//div[@class='v-group ng-scope']//li[@id='ssp_saleschannel_basedomain']")).click();
			Thread.sleep(2000);
			log("Clicked on the Base domain icon");
			takeScreenShot();
		}

	}



	public void enterDomainURL(String _URL) throws InterruptedException {

		//click on settings
		SaleschannelSettingbutton.click();
		log("Selected setting button in sales channel");
		Thread.sleep(2000);
		//click on Base domain tab
		BaseDomainTab.click();
		//click on base domain url text filed
		BaseDomainTextFiled.click();
		//clear base domain
		BaseDomainTextFiled.clear();
		//enter base domain url
		BaseDomainTextFiled.sendKeys(_URL);
		log("Entered the base domain in sales channel for respective tenant");
		//select save button
		SaveButtonInBaseDomain.click();
		Thread.sleep(1000);
		//select Ok in base domain confirmation pop-up
		ConfirmationOkButtonInSaleschannelsettings.click();
		log("Saved the base domain");
		Thread.sleep(2000);

	}
	public void editDomainURL(String _EditURL) {
		SalesChannelListPage_baseDomain_URL.clear();
		SalesChannelListPage_baseDomain_URL.sendKeys(_EditURL);
		takeScreenShot();
		SalesChannelListPage_baseDomain_save.click();
		log("Demo Base domain saved to sales channel to use original base domain for new tenant");

	}

	public void termsAndCondition() {
		wh.waitForElementToBeClickable(SalesChannelListPage_termsAndConditionlabel,driver,10);
		takeScreenShot();
		SalesChannelListPage_termsAndConditionlabel.click();
		log("Terms and consition button clicked");
	}



	public void enterTermsAndCondition(String _termsURL,String _PrivacyStatement) throws InterruptedException {

		SalesChannelListPage_TermsAndCondition.sendKeys(_termsURL);
		Thread.sleep(2000);

		SalesChannelListPage_PrivacyPolicy.sendKeys(_PrivacyStatement);
		Thread.sleep(3000);

		SalesChannelListPage_PrivacyPolicySave.click();

	}


	/**
	 * To configure the home page
	 * @param _heading1
	 * @param _heading2
	 * @throws InterruptedException
	 */
	public void enterHomePageCaptionDetails(String _heading1, String _heading2) throws InterruptedException {
		SalesChannelListPage_captionHeading1.sendKeys(_heading1);
		Thread.sleep(2000);

		SalesChannelListPage_captionHeading2.sendKeys(_heading2);
		Thread.sleep(3000);

		SalesChannelListPage_captionSave.click();
		log("Home page caption saved");
	}

	public String verifyConfirmDeletePopUpLabelsAndClickX(String _DeleteSalesChannelConfirmMsg,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
		status="FAIL";
		log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
		if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
			log("Message is displayed -> "+deleteconfirmationMessage.getText());
			if(deleteconfirmationMessage.getText().equals(_DeleteSalesChannelConfirmMsg)) {
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

	public String verifyConfirmDeletePopUpLabelsAndClickNo(String _SalesChannelName,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
		status="FAIL";
		log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
		if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
			log("Message is displayed -> "+deleteconfirmationMessage.getText());
			if(deleteconfirmationMessage.getText().equals("Do you want to delete sales channel '"+_SalesChannelName+"'?")) {
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

	public String verifyConfirmDeletePopUpLabelsAndClickYes(String _SalesChannelName,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
		status="FAIL";
		log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
		if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
			log("Message is displayed -> "+deleteconfirmationMessage.getText());
			if(deleteconfirmationMessage.getText().equals("Do you want to delete sales channel '"+_SalesChannelName+"'?")) {
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


	public String enterFooterinformationDetails(String _FAQs,String _TermsofUse,String _termsandConditions,String _Privacypolicy) throws InterruptedException {
		status="FAIL";

		//click on settings
		//driver.findElement(By.xpath("//li[@id='ssp_saleschannel_settings']")).click();
		//select footer information tab
		driver.findElement(By.xpath("//label[@class='ng-isolate-scope']/span[text()='Footer information'][1]")).click();
		takeScreenShot();
		log("Enter footer information URLs in respective text fileds");
		Thread.sleep(1000);
		FaqUrls.sendKeys(_FAQs);
		log("Footer information for FAQs URL is entered");

		TermsofuseUrls.sendKeys(_TermsofUse);
		log("Footer information for Terms of use URL is entered");

		TermandconditionsUrls.sendKeys(_termsandConditions);
		log("Footer information for Terms and conditions URL is entered");

		PrivacypolicyUrls.sendKeys(_Privacypolicy);
		Thread.sleep(1000);
		log("Footer information for Privacy policy URL is entered");
		takeScreenShot();

		SaveButtonInBFooterinformation.click();
		Thread.sleep(1000);
		ConfirmationOkButtonInSaleschannelsettings.click();
		log("Saved the Footer informations");
		status="PASS";
		CancelButtonInSaleschannelsettings.click();

		return status;
	}






}




