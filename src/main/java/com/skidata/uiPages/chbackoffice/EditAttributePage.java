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
public class EditAttributePage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;


	public static final Logger log = Logger.getLogger(EditAttributePage.class.getName());



	//Class constructor
	public EditAttributePage(WebDriver driver,ExtentTest test) {
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


	@FindBy(xpath = "//input[@v-model='model.attribute.name']")
	public WebElement AttributeName_inputfield;

	@FindBy(xpath = "//textarea[@v-model='model.attribute.description']")
	public WebElement AttributeDescription_inputfield;

	@FindBy(xpath = "//input[@v-model='model.attribute.sysKey']")
	public WebElement AttributeSysKey_inputfield;

	@FindBy(xpath = "//div[contains(@v-label,'SSPPortfolio.LocaleSelector-LabelName')]//div//span[@class='k-input ng-scope']")
	public WebElement LocaleDropDown;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and  @translate='CH.ButtonSave']")
	public WebElement Save;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and  @translate='CH.ButtonCancel']")
	public WebElement Cancel;
	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and  @translate='CH.ButtonConfirmDelete']")
	public WebElement Delete;
	
	@FindBy(xpath = "//*[@id='app']/div[1]/div[2]/p")
	public WebElement EditAttributePageHeader;
	
	
	
	
	@FindBy(xpath = "//div[@v-model='model.attribute.localizedAttributeNames']//div[@id='button-icon']")
	public WebElement AttributeNameLocalizedEarthIcon;
	
	@FindBy(xpath = "//div[@v-model='model.attribute.localizedAttributeDescriptions']//div[@id='button-icon']")
	public WebElement AttributeDescriptionLocalizedEarthIcon;
	
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
	
	
	@FindBy(xpath = "//div[contains(@v-label,'SSPPortfolio.PortfolioForm-attributeGroups')]//span[@class='k-input ng-scope']")
	public WebElement dropDownList_Attributegroups;
	


	/**
	 * Click on the + Add new Headquarter
	 * @throws InterruptedException 
	 * @throws AWTException 
	 */
	public void editAttributeDetails(String _Name,String _Description,String _Syskey) throws InterruptedException, AWTException {

		wh.waitForElementToBeClickable(AttributeName_inputfield, driver, 10);
		AttributeName_inputfield.clear();
		AttributeName_inputfield.sendKeys(_Name);
		log("Entered the Name as "+_Name);
		AttributeDescription_inputfield.clear();
		AttributeDescription_inputfield.sendKeys(_Description);
		log("Entered the Description");
		wh.waitForElementToBeClickable(AttributeSysKey_inputfield, driver, 10);
	
		AttributeSysKey_inputfield.clear();
		Thread.sleep(3000);
		AttributeSysKey_inputfield.sendKeys(_Syskey);
		log("Entered the data in syskey input field");
		takeScreenShot();
	}

	public void clickonSave() throws InterruptedException {
		Thread.sleep(5000);
		Save.click();

	}

	public void selectTenantLocale(String _TenantLocale) throws InterruptedException {
		
		clickElementUsingJavaScript(LocaleDropDown);
		WebElement selectTenantLocale = driver.findElement(By.xpath("//ul[@class='k-list k-reset']//li[contains(@class,'k-item ng-scope') and text()='"+_TenantLocale+"']"));
		Thread.sleep(3000);
		clickElementUsingJavaScript(selectTenantLocale);
		Thread.sleep(5000);
	}

//	public String verifyIconLabelsAndHeader(String _SavelabelAddportfolio,String _CancellabelAddportfolio,String _HeaderAddportfolios) {
//	status="FAIL";
//	
//	if(Save.getText().equals(_SavelabelAddportfolio)) {
//		log("Save button is displayed");
//		if(Cancel.getText().equals(_CancellabelAddportfolio)) {
//			log("Cancel button is displayed");
//			if(AddportfolioHeader.getText().equals(_HeaderAddportfolios)) {
//				log(AddportfolioHeader.getText()+" header is displayed in UI");
//		
//			status="PASS";
//			takeScreenShot();
//			}
//		}
//	}
//	return status;
//		
//	}
//
	public void clickonAddLocalizedName() {
		AttributeNameLocalizedEarthIcon.click();
		log("Clicked on the Add localized names icon");
		takeScreenShot();
		
	}
	
	public void clickonAddLocalizedDescription() {
		wh.waitForElementToBeVisible(AttributeDescriptionLocalizedEarthIcon, driver, 10);
		clickElementUsingJavaScript(AttributeDescriptionLocalizedEarthIcon);
		log("Clicked on the Add localized Description icon");
		takeScreenShot();
		
	}

	public String verifyHeaderandIcons_AddlocalizedNamesPopUp(String _AddlocalizedNamesPopUpHeader) throws InterruptedException {
	     status="FAIL";
		    int popup = driver.findElements(By.xpath("//div[16]//span[@class='k-window-title' and text()='"+_AddlocalizedNamesPopUpHeader+"']")).size();
		if(popup==1) {
			status="PASS";
		}
		return status;
	}
//	
//	public String verifyHeaderandIcons_AddlocalizedDescriptionPopUp(String _AddlocalizedDescriptionPopUpHeader) throws InterruptedException {
//	     status="FAIL";
//		    int popup = driver.findElements(By.xpath("//span[@class='k-window-title' and text()='"+_AddlocalizedDescriptionPopUpHeader+"']")).size();
//		if(popup==1) {
//			status="PASS";
//		}
//		return status;
//	}
//
	public void editlocalizednamesDetails(String _localeForAddlocalizedNames,String _LocalizedName) throws InterruptedException {
//		AddlocalizedNamesPopUP_localeDropdown.click();
//		
//		WebElement localevalue = driver.findElement(By.xpath("//div[24]/div/div[3]/ul/li[text()='"+_localeForAddlocalizedNames+"']"));
//		wh.waitForElementToBeVisible(localevalue, driver, 10);
//		Thread.sleep(4000);
//		localevalue.click();
//		log("Selected the locale of Add localized names as "+_localeForAddlocalizedNames);
		AddlocalizedNamesPopUP_LocalizedNamesInputfield.clear();
		AddlocalizedNamesPopUP_LocalizedNamesInputfield.sendKeys(_LocalizedName);
		takeScreenShot();
		SaveLocalizedNames.click();
		log("Clicked on Save");
		
	}

	public void editlocalizedDescriptionDetails(String _localeForAddlocalizedDescription,String _LocalizedNameDescription) throws InterruptedException {
//		AddlocalizedDescriptionPopUP_localeDropdown.click();
//		
//		WebElement localevalue = driver.findElement(By.xpath("//div[10]/div/div[3]/ul/li[text()='"+_localeForAddlocalizedDescription+"']"));
//		Thread.sleep(4000);
//		localevalue.click();
//		log("Selected the locale of Add localized names as "+_localeForAddlocalizedDescription);
		AddlocalizedNamesPopUP_LocalizedDescriptionInputfield.clear();
		AddlocalizedNamesPopUP_LocalizedDescriptionInputfield.sendKeys(_LocalizedNameDescription);
		takeScreenShot();
		SaveLocalizeddescriptions.click();
		log("Clicked on Save");
		
		
	}

	public String verifyIconLabelsAndHeader(String _Savelabel, String _Cancellabel, String _Deletelabel, String _pageHeaderEditAttribute) {
		status="FAIL";
		
		if(Save.getText().equals(_Savelabel)) {
			log("Save button is displayed");
			if(Cancel.getText().equals(_Cancellabel)) {
				log("Cancel button is displayed");
				if(Delete.getText().equals(_Deletelabel)) {
					log(Delete.getText()+" button is displayed in UI");
					if(EditAttributePageHeader.getText().equals(_pageHeaderEditAttribute)) {
						log(EditAttributePageHeader.getText()+" header is displayed in UI");
					
						status="PASS";
						takeScreenShot();
					}
			
				}
			}
		}
		return status;
	 }

	
	public void addAttributeGroupDetails(String attributeGroupValue) {
		clickElementUsingJavaScript(dropDownList_Attributegroups);
		log("clicked on the Attributes groups drop down list");
		WebElement dropDownValue = driver.findElement(By.xpath("//div[@class='k-list-scroller']//div[@class='ng-scope ng-isolate-scope' and @v-model='dataItem.localizedAttributeGroupNames']//span[@class='v-label ng-scope'and text()='"+attributeGroupValue+"']"));
		clickElementUsingJavaScript(dropDownValue);
		log("Selected the value as "+attributeGroupValue);
		
	}

				

}