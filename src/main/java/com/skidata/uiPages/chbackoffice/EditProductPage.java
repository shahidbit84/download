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
public class EditProductPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;


	public static final Logger log = Logger.getLogger(EditProductPage.class.getName());



	//Class constructor
	public EditProductPage(WebDriver driver,ExtentTest test) {
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


	@FindBy(xpath = "//input[@v-model='model.product.name']")
	public WebElement ProductName_inputfield;

	@FindBy(xpath = "//textarea[@v-model='model.product.description']")
	public WebElement ProductDescription_inputfield;


	@FindBy(xpath = "//input[@v-model='model.portfolio.sysKey']")
	public WebElement SysKey_inputfield;

	@FindBy(xpath = "//div[contains(@v-label,'SSPPortfolio.LocaleSelector-LabelName')]//div//span[@class='k-input ng-scope']")
	public WebElement LocaleDropDown;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and  @translate='CH.ButtonSave']")
	public WebElement Save;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and  @translate='CH.ButtonCancel']")
	public WebElement Cancel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and  @translate='SSPProduct.ApplicationHeader-UploadImage']")
	public WebElement UploadImage;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and  @translate='SSPProduct.ApplicationHeader-AddTemplate']")
	public WebElement AddTemplate;
	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and  @translate='SSPProduct.ApplicationHeader-EditProperties']")
	public WebElement EditProperties;

	@FindBy(xpath = "//p[@translate='SSPProduct.EditProductHeader']")
	public WebElement EditProductPageHeader;

	
	
	
	@FindBy(xpath = "//div[@v-model='model.product.localizedNames']//div[@id='button-icon']")
	public WebElement ProductNameLocalizedEarthIcon;

	@FindBy(xpath = "//div[@v-model='model.product.localizedDescriptions']//div[@id='button-icon']")
	public WebElement ProductDescriptionLocalizedEarthIcon;

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


	public void clickonSave() throws InterruptedException {
		 wh.waitForElementToBeClickable(Save, driver, 10);
		clickElementUsingJavaScript(Save);

	}
	public void clickonCancel() throws InterruptedException {
	    wh.waitForElementToBeClickable(Cancel, driver, 10);
	    Cancel.click();

	}

	public void selectTenantLocale(String _TenantLocale) throws InterruptedException {

		clickElementUsingJavaScript(LocaleDropDown);
		WebElement selectTenantLocale = driver.findElement(By.xpath("//ul[@class='k-list k-reset']//li[contains(@class,'k-item ng-scope') and text()='"+_TenantLocale+"']"));
		Thread.sleep(3000);
		clickElementUsingJavaScript(selectTenantLocale);
		Thread.sleep(5000);
	}



	public String verifyIconLabelsAndHeader(String _SavelabelEditProduct,String _CancellabelEditProduct,String _UploadImageEditProduct,
			String _AddtemplateEditProduct,String _EditPropertiesEditProduct,String _EditProductPageHeader) {
		status="FAIL";

		if(Save.getText().equals(_SavelabelEditProduct)) {
			log("Save button is displayed");
			if(Cancel.getText().equals(_CancellabelEditProduct)) {
				log("Cancel button is displayed");
				if(UploadImage.getText().equals(_UploadImageEditProduct)) {
					log(UploadImage.getText()+" button is displayed");
					if(AddTemplate.getText().equals(_AddtemplateEditProduct)) {
						log(AddTemplate.getText()+" button is displayed");
						if(EditProperties.getText().equals(_EditPropertiesEditProduct)) {
							log(EditProperties.getText()+" button is displayed");
							if(EditProductPageHeader.getText().equals(_EditProductPageHeader)) {
								log(EditProductPageHeader.getText()+" Header is displayed");
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
	 * Add product details
	 * @throws InterruptedException 
	 * @throws AWTException 
	 */

	public void editProductdetails(String _Name,String _Description) throws InterruptedException, AWTException {

		wh.waitForElementToBeClickable(ProductName_inputfield, driver, 10);
		ProductName_inputfield.clear();
		ProductName_inputfield.sendKeys(_Name);
		log("Entered the Name as "+_Name);
		ProductDescription_inputfield.clear();
		ProductDescription_inputfield.sendKeys(_Description);
		log("Entered the Description");
		takeScreenShot();
	}


	



	public void clickonAddLocalizedName() {
		ProductNameLocalizedEarthIcon.click();
		log("Clicked on the Add localized names icon");
		takeScreenShot();

	}

	public void clickonAddLocalizedDescription() {
		wh.waitForElementToBeVisible(ProductDescriptionLocalizedEarthIcon, driver, 10);
		clickElementUsingJavaScript(ProductDescriptionLocalizedEarthIcon);
		log("Clicked on the Add localized Description icon");
		takeScreenShot();

	}

	public String verifyHeaderandIcons_AddlocalizedNamesPopUp(String _AddlocalizedNamesPopUpHeader) throws InterruptedException {
		status="FAIL";
		int popup = driver.findElements(By.xpath("//span[@class='k-window-title' and text()='"+_AddlocalizedNamesPopUpHeader+"']")).size();
		if(popup==1) {
			status="PASS";
		}
		return status;
	}

	public String verifyHeaderandIcons_AddlocalizedDescriptionPopUp(String _AddlocalizedDescriptionPopUpHeader) throws InterruptedException {
		status="FAIL";
		int popup = driver.findElements(By.xpath("//span[@class='k-window-title' and text()='"+_AddlocalizedDescriptionPopUpHeader+"']")).size();
		if(popup==1) {
			status="PASS";
		}
		return status;
	}

	public void editlocalizednamesDetails(String _localeForAddlocalizedNames,String _LocalizedName) throws InterruptedException {
//		AddlocalizedNamesPopUP_localeDropdown.click();
//		WebElement localevalue = driver.findElement(By.xpath("/html/body/div[11]/div/div[3]/ul/li[text()='"+_localeForAddlocalizedNames+"']"));
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
//		WebElement localevalue = driver.findElement(By.xpath("//div[13]/div/div[3]/ul/li[text()='"+_localeForAddlocalizedDescription+"']"));
//		Thread.sleep(4000);
//		localevalue.click();
//		log("Selected the locale of Add localized names as "+_localeForAddlocalizedDescription);
		AddlocalizedNamesPopUP_LocalizedDescriptionInputfield.clear();
		AddlocalizedNamesPopUP_LocalizedDescriptionInputfield.sendKeys(_LocalizedNameDescription);
		takeScreenShot();
		SaveLocalizeddescriptions.click();
		log("Clicked on Save");


	}
//
//	public void clickonAddAttributes() {
//		AddAttributes.click();
//		log("Clicked on the Add attributes icon");
//		takeScreenShot();
//		
//	}
//
//	public String verifyGeneralAttributesLabelsDisplayed(String generalAttributesLabel,String generalAttributes_Name,String generalAttributes_Description) {
//		wh.waitForElementToBeVisible(label_GeneralAttributes, driver, 10);
//		status="FAIL";
//		log(label_GeneralAttributes.getText());
//		if(label_GeneralAttributes.getText().equals(generalAttributesLabel)) {
//			label_GeneralAttributes.click();
//			log(label_GeneralAttributes.getText()+" is displayed in UI");
//			wh.waitForElementToBeVisible(columnLabel_GeneralAttributes_Name, driver, 10);
//			if(columnLabel_GeneralAttributes_Name.getText().equals(generalAttributes_Name)) {
//				log(columnLabel_GeneralAttributes_Name.getText()+" is displayed in UI");
//				if(columnLabel_GeneralAttributes_Description.getText().equals(generalAttributes_Description)) {
//					log(columnLabel_GeneralAttributes_Description.getText()+" is displayed in UI");
//					takeScreenShot();
//					status="PASS";
//				}
//			}
//		}
//		return status;
//		
//	}
//	
//	public String verifyGeneralAttributesLabelsDisplayedAfterDelete(String generalAttributesLabel,String generalAttributes_Name,String generalAttributes_Description) {
//		
//		status="FAIL";
//	
//		if(label_GeneralAttributes.getText().equals(generalAttributesLabel)) {
//			label_GeneralAttributes.click();
//			log(label_GeneralAttributes.getText()+" is displayed in UI");
//			wh.waitForElementToBeVisible(columnLabel_GeneralAttributes_Name, driver, 10);
//			if(columnLabel_GeneralAttributes_Name.getText().equals(generalAttributes_Name)) {
//				log(columnLabel_GeneralAttributes_Name.getText()+" is displayed in UI");
//				if(columnLabel_GeneralAttributes_Description.getText().equals(generalAttributes_Description)) {
//					log(columnLabel_GeneralAttributes_Description.getText()+" is displayed in UI");
//					takeScreenShot();
//					status="PASS";
//				}
//			}
//		}
//		return status;
//		
//	}
//
//	public String verifyAddedGeneralAttributesDisplayedAndClick(String generalAttributes_NameValue,String generalAttributes_DescriptionValue) {
//	status="FAIL";
//	if(value_GeneralAttributes_Name.getText().equals(generalAttributes_NameValue)) {
//		log(value_GeneralAttributes_Name.getText()+" is displayed in the Name of General attributes");
//		if(value_GeneralAttributes_Description.getText().equals(generalAttributes_DescriptionValue)) {
//			log(value_GeneralAttributes_Description.getText()+" is displayed in the Name of General attributes");
//			status="PASS";
//			takeScreenShot();
//			value_GeneralAttributes_Name.click();
//		}
//	}
//	return status;
//		
//	}
//
//	public void clickonEditAttributesIcon() {
//		wh.waitForElementToBeClickable(EditAttributes, driver, 10);
//		EditAttributes.click();
//		log("clicked on the Edit attributes icon");
//		takeScreenShot();
//		
//	}
//
//	public void clickonDelete() {
//		wh.waitForElementToBeClickable(Delete, driver, 10);
//		Delete.click();
//		log("clicked on the Delete icon");
//		takeScreenShot();
//
//		
//	}
//
//	public void clickonCancel() {
//		wh.waitForElementToBeClickable(Cancel, driver, 10);
//		Cancel.click();
//		log("clicked on cancel");
//		takeScreenShot();
//		
//	}
//
//	public String verifyDeleteAttributeConfirmationDialogAndClickX(String _ConfirmHeaderDeleteAttribute,String _ConfirmMessageDeleteAttribute,
//			String _ConfirmYesButtonDeleteAttribute,String _ConfirmNoButtonDeleteAttribute) {
//	status="FAIL";
//		wh.waitForElementToBeVisible(dialog_ConfirmDeleteAttributeHeader, driver, 10);
//		if(dialog_ConfirmDeleteAttributeHeader.getText().equals(_ConfirmHeaderDeleteAttribute)) {
//			log(dialog_ConfirmDeleteAttributeHeader.getText()+" is displayed in UI");
//			if(dialog_ConfirmDeleteAttributeMessage.getText().equals(_ConfirmMessageDeleteAttribute)) {
//				log(dialog_ConfirmDeleteAttributeMessage.getText()+" is displayed in UI");
//				if(dialog_button_ConfirmDeleteAttributeYes.getText().equals(_ConfirmYesButtonDeleteAttribute)) {
//					log(dialog_button_ConfirmDeleteAttributeYes.getText()+" is displayed in UI");
//					if(dialog_button_ConfirmDeleteAttributeNo.getText().equals(_ConfirmNoButtonDeleteAttribute)) {
//						log(dialog_button_ConfirmDeleteAttributeNo.getText()+" is displayed in UI");
//						status="PASS";
//						takeScreenShot();
//						driver.findElement(By.xpath("html/body/div[30]/div[1]/div/a/span")).click();
//					}
//				}
//			}
//		}
//		return status;
//		
//		
//	}
//	
//	public String verifyDeleteAttributeConfirmationDialogAndClickNo(String _ConfirmHeaderDeleteAttribute,String _ConfirmMessageDeleteAttribute,
//			String _ConfirmYesButtonDeleteAttribute,String _ConfirmNoButtonDeleteAttribute) {
//	status="FAIL";
//		wh.waitForElementToBeVisible(dialog_ConfirmDeleteAttributeHeader, driver, 10);
//		if(dialog_ConfirmDeleteAttributeHeader.getText().equals(_ConfirmHeaderDeleteAttribute)) {
//			log(dialog_ConfirmDeleteAttributeHeader.getText()+" is displayed in UI");
//			if(dialog_ConfirmDeleteAttributeMessage.getText().equals(_ConfirmMessageDeleteAttribute)) {
//				log(dialog_ConfirmDeleteAttributeMessage.getText()+" is displayed in UI");
//				if(dialog_button_ConfirmDeleteAttributeYes.getText().equals(_ConfirmYesButtonDeleteAttribute)) {
//					log(dialog_button_ConfirmDeleteAttributeYes.getText()+" is displayed in UI");
//					if(dialog_button_ConfirmDeleteAttributeNo.getText().equals(_ConfirmNoButtonDeleteAttribute)) {
//						log(dialog_button_ConfirmDeleteAttributeNo.getText()+" is displayed in UI");
//						status="PASS";
//						takeScreenShot();
//						dialog_button_ConfirmDeleteAttributeNo.click();
//						log("clicked on No");
//					}
//				}
//			}
//		}
//		return status;
//		
//		
//	}
//	
//	
//	public String verifyDeleteAttributeConfirmationDialogAndClickYes(String _ConfirmHeaderDeleteAttribute,String _ConfirmMessageDeleteAttribute,
//			String _ConfirmYesButtonDeleteAttribute,String _ConfirmNoButtonDeleteAttribute) {
//	status="FAIL";
//		wh.waitForElementToBeVisible(dialog_ConfirmDeleteAttributeHeader, driver, 10);
//		if(dialog_ConfirmDeleteAttributeHeader.getText().equals(_ConfirmHeaderDeleteAttribute)) {
//			log(dialog_ConfirmDeleteAttributeHeader.getText()+" is displayed in UI");
//			if(dialog_ConfirmDeleteAttributeMessage.getText().equals(_ConfirmMessageDeleteAttribute)) {
//				log(dialog_ConfirmDeleteAttributeMessage.getText()+" is displayed in UI");
//				if(dialog_button_ConfirmDeleteAttributeYes.getText().equals(_ConfirmYesButtonDeleteAttribute)) {
//					log(dialog_button_ConfirmDeleteAttributeYes.getText()+" is displayed in UI");
//					if(dialog_button_ConfirmDeleteAttributeNo.getText().equals(_ConfirmNoButtonDeleteAttribute)) {
//						log(dialog_button_ConfirmDeleteAttributeNo.getText()+" is displayed in UI");
//						status="PASS";
//						takeScreenShot();
//						dialog_button_ConfirmDeleteAttributeYes.click();
//						log("clicked on No");
//					}
//				}
//			}
//		}
//		return status;
//		
//		
//	}

}