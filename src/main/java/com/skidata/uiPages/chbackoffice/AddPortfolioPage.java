/**
 *
 */
package com.skidata.uiPages.chbackoffice;

import java.awt.AWTException;

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

public class AddPortfolioPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;


	public static final Logger log = Logger.getLogger(AddPortfolioPage.class.getName());



	//Class constructor
	public AddPortfolioPage(WebDriver driver,ExtentTest test) {
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


	@FindBy(xpath = "//input[@v-model='model.portfolio.name']")
	public WebElement PortfolioName_inputfield;

	@FindBy(xpath = "//textarea[@v-model='model.portfolio.description']")
	public WebElement PortfolioDescription_inputfield;

	@FindBy(xpath = "//input[@v-model='model.portfolio.sysKey']")
	public WebElement SysKey_inputfield;

	@FindBy(xpath = "//div[contains(@v-label,'SSPPortfolio.LocaleSelector-LabelName')]//div//span[@class='k-input ng-scope']")
	public WebElement LocaleDropDown;

	@FindBy(xpath = "//li[@id='ssp_portfolio_add_save']")
	public WebElement Save;

	@FindBy(xpath = "//li[@id='ssp_portfolio_add_cancel']")
	public WebElement Cancel;
	
	@FindBy(xpath = "//p[@translate='SSPPortfolio.ApplicationHeader-AddPortfolio']")
	public WebElement AddportfolioHeader;
	
	
	
	
	@FindBy(xpath = "//div[@v-model='model.portfolio.localizedNames']//div[@id='button-icon']")
	public WebElement PortfolioNameLocalizedEarthIcon;
	
	@FindBy(xpath = "//div[@v-model='model.portfolio.localizedDescriptions']//div[@id='button-icon']")
	public WebElement PortfolioDescriptionLocalizedEarthIcon;
	
	@FindBy(xpath = "//div[contains(@k-title,'Add localized names')]//div[contains(@v-label,'CHPortal.LocaleLabel')]//span[@class='k-input ng-scope']")
	public WebElement AddlocalizedNamesPopUP_localeDropdown;
	
	@FindBy(xpath = "//div[contains(@ k-title,'Add localized descriptions')]//div[contains(@v-label,'CHPortal.LocaleLabel')]//span[@class='k-input ng-scope']")
	public WebElement AddlocalizedDescriptionPopUP_localeDropdown;
	
	
	@FindBy(xpath = "//input[@v-locale='ui.locale.locale']")
	public WebElement AddlocalizedNamesPopUP_LocalizedNamesInputfield;
	
	@FindBy(xpath = "//div[contains(@k-title,'Add localized descriptions')]//textarea")
	public WebElement AddlocalizedNamesPopUP_LocalizedDescriptionInputfield;
	
	@FindBy(xpath = "//div[contains(@k-title,'Add localized names')]//button[@translate='VSMKendoMessages.SAVE']")
	public WebElement SaveLocalizedNames;
	
	@FindBy(xpath = "//div[contains(@k-title,'Add localized descriptions')]//button[@translate='VSMKendoMessages.SAVE']")
	public WebElement SaveLocalizeddescriptions;
	

	/**
	 * Click on the + Add new portfolio
	 * @throws InterruptedException 
	 * @throws AWTException 
	 */
	public void addPortfoliodetails(String _Name,String _Description,String _Syskey) throws InterruptedException, AWTException {

		wh.waitForElementToBeClickable(PortfolioName_inputfield, driver, 10);
		PortfolioName_inputfield.sendKeys(_Name);
		log("Entered the Name as "+_Name);
		PortfolioDescription_inputfield.sendKeys(_Description);
		log("Entered the Description");
		wh.waitForElementToBeClickable(SysKey_inputfield, driver, 10);
		SysKey_inputfield.clear();
		Thread.sleep(3000);
		SysKey_inputfield.sendKeys(_Syskey);
		log("Entered the data in syskey input field");
		takeScreenShot();
	}
	
	/**
	 * Method to save the portfolio
	 * @throws InterruptedException
	 */

	public void clickonSave() throws InterruptedException {
		Thread.sleep(5000);
		Save.click();

	}

	/**
	 * To set the tenant locale in the dropdown
	 * @param _TenantLocale
	 * @throws InterruptedException
	 */
	public void selectTenantLocale(String _TenantLocale) throws InterruptedException {
		
		clickElementUsingJavaScript(LocaleDropDown);
		WebElement selectTenantLocale = driver.findElement(By.xpath("//ul[@class='k-list k-reset']//li[contains(@class,'k-item ng-scope') and text()='"+_TenantLocale+"']"));
		Thread.sleep(3000);
		clickElementUsingJavaScript(selectTenantLocale);
		Thread.sleep(5000);
	}
	
	/**
	 * to verify the labels and headers
	 * @param _SavelabelAddportfolio
	 * @param _CancellabelAddportfolio
	 * @param _HeaderAddportfolios
	 * @return
	 */

	public String verifyIconLabelsAndHeader(String _SavelabelAddportfolio,String _CancellabelAddportfolio,String _HeaderAddportfolios) {
	status="FAIL";
	
	if(Save.getText().equals(_SavelabelAddportfolio)) {
		log("Save button is displayed");
		if(Cancel.getText().equals(_CancellabelAddportfolio)) {
			log("Cancel button is displayed");
			if(AddportfolioHeader.getText().equals(_HeaderAddportfolios)) {
				log(AddportfolioHeader.getText()+" header is displayed in UI");
		
			status="PASS";
			takeScreenShot();
			}
		}
	}
	return status;
		
	}
	
/**
 * To add the localized name for a portfolio.
 */
	public void clickonAddLocalizedName() {
		PortfolioNameLocalizedEarthIcon.click();
		log("Clicked on the Add localized names icon");
		takeScreenShot();
		
	}
	
	/**
	 * To add the localized description
	 */
	public void clickonAddLocalizedDescription() {
		wh.waitForElementToBeVisible(PortfolioDescriptionLocalizedEarthIcon, driver, 10);
		clickElementUsingJavaScript(PortfolioDescriptionLocalizedEarthIcon);
		log("Clicked on the Add localized Description icon");
		takeScreenShot();
		
	}

	/**
	 * To verify the localized header popup
	 * @param _AddlocalizedNamesPopUpHeader
	 * @return
	 * @throws InterruptedException
	 * @author shmo
	 */
	public String verifyHeaderandIcons_AddlocalizedNamesPopUp(String _AddlocalizedNamesPopUpHeader) throws InterruptedException {
	     status="FAIL";
		    int popup = driver.findElements(By.xpath("//span[@class='k-window-title' and text()='"+_AddlocalizedNamesPopUpHeader+"']")).size();
		if(popup==1) {
			status="PASS";
		}
		return status;
	}
	
	/**
	 * To verify rge localized description popup.
	 */
	public String verifyHeaderandIcons_AddlocalizedDescriptionPopUp(String _AddlocalizedDescriptionPopUpHeader) throws InterruptedException {
	     status="FAIL";
		    int popup = driver.findElements(By.xpath("//span[@class='k-window-title' and text()='"+_AddlocalizedDescriptionPopUpHeader+"']")).size();
		if(popup==1) {
			status="PASS";
		}
		return status;
	}
	
/**
 * To verify the localized names details 
 * @param _localeForAddlocalizedNames
 * @param _LocalizedName
 * @throws InterruptedException
 */
	public void addlocalizednamesDetails(String _localeForAddlocalizedNames,String _LocalizedName) throws InterruptedException {
		AddlocalizedNamesPopUP_localeDropdown.click();
		
		 WebElement localevalue = driver.findElement(By.xpath("//div[8]/div/div[3]/ul/li[text()='"+_localeForAddlocalizedNames+"']"));
		wh.waitForElementToBeVisible(localevalue, driver, 10);
		Thread.sleep(4000);
		localevalue.click();
		log("Selected the locale of Add localized names as "+_localeForAddlocalizedNames);
		AddlocalizedNamesPopUP_LocalizedNamesInputfield.sendKeys(_LocalizedName);
		takeScreenShot();
		SaveLocalizedNames.click();
		log("Clicked on Save");
	}

	/**
	 * To verify the localized
	 * @param _localeForAddlocalizedDescription
	 * @param _LocalizedNameDescription
	 * @throws InterruptedException
	 */
	public void addlocalizedDescriptionDetails(String _localeForAddlocalizedDescription,String _LocalizedNameDescription) throws InterruptedException {
		AddlocalizedDescriptionPopUP_localeDropdown.click();
		
		WebElement localevalue = driver.findElement(By.xpath("//div[10]/div/div[3]/ul/li[text()='"+_localeForAddlocalizedDescription+"']"));
		Thread.sleep(4000);
		localevalue.click();
		log("Selected the locale of Add localized names as "+_localeForAddlocalizedDescription);
		AddlocalizedNamesPopUP_LocalizedDescriptionInputfield.sendKeys(_LocalizedNameDescription);
		takeScreenShot();
		SaveLocalizeddescriptions.click();
		log("Clicked on Save");
		
		
	}

}