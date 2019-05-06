/**
 *
 */
package com.skidata.uiPages.chbackoffice;

import java.awt.AWTException;
import java.io.IOException;
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
import com.skidata.util.ConstantValues;

/**
 * @author shmo
 * 
 */
public class EditArticlePage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;


	public static final Logger log = Logger.getLogger(EditArticlePage.class.getName());



	//Class constructor
	public EditArticlePage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

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

	@FindBy(xpath = "//input[@v-model='model.article.name']")
	public WebElement ArticleName_inputfield;

	@FindBy(xpath = "//textarea[@v-model='model.article.description']")
	public WebElement LocalizedDescription_inputfield;

	@FindBy(xpath = "//div[@v-model='model.article.localizedNames']//div[@class='v-button-icon v-25-multilingual-error']")
	public WebElement AddLocalizedNameIcon;

	@FindBy(xpath = "//div[@v-model='model.article.localizedDescriptions']//div[@class='v-button-icon v-25-multilingual-error']")
	public WebElement AddLocalizedDescriptionsIcon;

	@FindBy(xpath = "//div[contains(@v-label,'CHPortal.LocaleLabel')]//span[@class='k-dropdown-wrap k-state-default']")
	public WebElement LocaleDropdownSelect;

	@FindBy(xpath = "//div[contains(@k-title,'Add localized descriptions')]//div[contains(@v-label,'CHPortal.LocaleLabel')]//div//span/span[@class='k-input ng-scope']")
	public WebElement LocaleDropdownSelectforLocalizedDescriptionPopup;

	@FindBy(xpath = "//input[@v-locale='ui.locale.locale']")
	public WebElement LocalizedName_inputfield;

	@FindBy(xpath = "//div[contains(@k-title,'Add localized descriptions')]//textarea")
	public WebElement LocalizedDescriptiontextinpopup_inputfield;

	@FindBy(xpath = "//button[@translate='VSMKendoMessages.DONE']")
	public WebElement AddLocalizedName_DoneButton;

	@FindBy(xpath = "//div[contains(@k-title,'Add localized descriptions')]//button[@translate='VSMKendoMessages.DONE']")
	public WebElement AddLocalizedDescription_DoneButton;

	@FindBy(xpath = "//div[contains(@v-label,'SSPArticle.ArticleForm-selectProduct')]//div//span[@class='k-dropdown-wrap k-state-default']")
	public WebElement SelectProductDD;

	@FindBy(xpath = "//div[@class='task-close ng-scope']")
	public WebElement taskcloseicon;

	@FindBy(xpath = "//p[@class='ng-scope' and @translate='SSPArticle.EditArticleHeader']")
	public WebElement pageHeader;

	@FindBy(xpath = "//div[@v-model='model.article.localizedNames']//div[@id='button-icon']")
	public WebElement ProductNameLocalizedEarthIcon;

	@FindBy(xpath = "//div[@v-model='model.article.localizedDescriptions']//div[@id='button-icon']")
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

	@FindBy(xpath = "//li[@id='ssp_article_edit_save']")
	public WebElement Save;

	@FindBy(xpath = "//li[@id='ssp_article_edit_cancel']")
	public WebElement Cancel;

	@FindBy(xpath = "//li[@id='ssp_article_edit_upload_image']")
	public WebElement UploadImage;

	@FindBy(xpath = "//li[@id='ssp_article_edit_add_properties']")
	public WebElement AddProperties;

	@FindBy(xpath = "//li[@id='ssp_article_edit_update_properties']")
	public WebElement EditProperties;

	@FindBy(xpath = "//li[@id='ssp_article_edit_additional_articles']")
	public WebElement ManageAdditionalProperties;

	@FindBy(xpath = "//li[@id='ssp_article_edit_pricing']")
	public WebElement Pricing;
	
	@FindBy(xpath = "//li[@id='ssp_article_edit_subscription_plans']")
	public WebElement SubscriptionPlans;
	
	@FindBy(xpath = "//li[@id='ssp_saleschannel_theme_logo']")
	public WebElement CloneConfirmationMessage;
	
	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonOk']")
	public WebElement OKButton;

	@FindBy(xpath = "//input[@ v-model='model.newProperty.localizedAttributes']")
	public WebElement textField_PropertyName;
	
	@FindBy(xpath = "//textarea[@ v-model='model.newProperty.localizedDescriptions']")
	public WebElement textArea_PropertyDescription;
	
	@FindBy(xpath = "//div[@kendo-window='ui.addPropertyWindow']//div[contains(@v-label,'SSPArticle.LocaleSelector-LabelName')]//span[@class='k-input ng-scope']")
	public WebElement dropDownList_PropertyLocale;
	
	@FindBy(xpath = "//input[@v-model='model.newProperty.localizedMeasurementUnit']")
	public WebElement textField_PropertyMeasurementUnit;
	
	@FindBy(xpath = "//input[@v-model='model.newProperty.localizedValue']")
	public WebElement textField_PropertyValue;
	
	@FindBy(xpath = "//html/body/div[20]/div[2]/div/form/div[11]/div[1]/div/div/div/button")
	public WebElement button_SaveProperties;	
	
	@FindBy(xpath = "//span[@translate='SSPArticle.propertiesHeader-properties']")
	public WebElement labelDropDown_GeneralProperties;
	
	@FindBy(xpath = "//div[@kendo-grid='model.propertiesGrid']//tr//th[1]")
	public WebElement column_GeneralPropertiesName;
	
	@FindBy(xpath = "//div[@kendo-grid='model.propertiesGrid']//tr//th[2]")
	public WebElement column_GeneralPropertiesValue;
	
	@FindBy(xpath = "//div[@kendo-grid='model.propertiesGrid']//tr//th[3]")
	public WebElement column_GeneralPropertiesType;

	/**
	 * Method to click on X task header Control icon
	 */
	public void clickonXtaskHeaderControlicon() {
		taskcloseicon.click();
		log("clicked on the X icon in the Task Header label");
		takeScreenShot();
	}

	//****************************************************************************************************************

	public void selectLocale(String _LocaleValue) {

		driver.findElement(By.xpath("//div[contains(@v-label,'SSPArticle.LocaleSelector-LabelName')]//span[@class='k-widget k-dropdown k-header ng-scope']")).click();
		WebElement locale = driver.findElement(By.xpath("//li[text()='"+_LocaleValue+"']"));
		clickElementUsingJavaScript(locale);
	}


	/**
	 *
	 * @throws InterruptedException 
	 * @throws AWTException 
	 */
	public void addArticledetails(String _ArticleName,String _LocaleinputforallLocales,String _LocalizedNameforallLocales,String _Description,
			String LocalizedDescriptiontextinpopup,String _SelectProduct) throws InterruptedException, AWTException {

		ArticleName_inputfield.sendKeys(_ArticleName);
		log("Entered the Article name as "+_ArticleName);
		AddLocalizedNameIcon.click();
		Thread.sleep(3000);
		LocaleDropdownSelect.click();
		Thread.sleep(3000);
		WebElement locale = driver.findElement(By.xpath("//li[@class='k-item ng-scope k-state-selected k-state-focused' and text()='"+_LocaleinputforallLocales+"']"));
		Thread.sleep(3000);
		clickElementUsingJavaScript(locale);
		Thread.sleep(3000);
		LocalizedName_inputfield.sendKeys(_LocalizedNameforallLocales);
		Thread.sleep(3000);
		AddLocalizedName_DoneButton.click();

		clickElementUsingJavaScript(AddLocalizedDescriptionsIcon);
		Thread.sleep(3000);
		//LocaleDropdownSelectforLocalizedDescriptionPopup.click();
		Thread.sleep(3000);
		//		WebElement s = driver.findElement(By.xpath("//div[@class='k-animation-container']//ul[@class='k-list k-reset']//li[text()='English - Australia']"));
		//		Thread.sleep(4000);
		//		clickElementUsingJavaScript(s);

		LocalizedDescriptiontextinpopup_inputfield.sendKeys(LocalizedDescriptiontextinpopup);
		AddLocalizedDescription_DoneButton.click();

		LocalizedDescription_inputfield.sendKeys(_Description);

		wh.waitForElementToBeClickable(SelectProductDD, driver, 30);
		clickElementUsingJavaScript(SelectProductDD);

		WebElement productToSelect = driver.findElement(By.xpath("//li[@class='k-item ng-scope' and text()='"+_SelectProduct+"']"));
		Thread.sleep(5000);
		clickElementUsingJavaScript(productToSelect);
	}


	public void clickonSave() throws InterruptedException {

		wh.waitForElementToBeVisible(Save, driver, 10);
		Thread.sleep(3000);
		clickElementUsingJavaScript(Save);

	}

	/**
	 * Method to verify Icon Labels and Header in Edit Article page
	 * @param _SaveLabel
	 * @param _CancelLabel
	 * @param _PageHeaderAddArticle
	 * @param _ArticleName
	 * @param _PageHeaderAfterEnteringName
	 * @return
	 * @throws InterruptedException 
	 */
	public String verifyIconLabelsAndHeader(String _SaveLabel,String _CancelLabel,String _UploadImage,String _AddProperties
			,String _EditProperties,String _ManageAdditionalProperties,String _Pricing,String _PageHeader,String _Name,String _UpdatedHeader) throws InterruptedException {
		status="FAIL";
		if(Save.getText().equals(_SaveLabel)) {
			log("Save button is displayed ");
			if(Cancel.getText().equals(_CancelLabel)) {
				log("Cancel button is displayed");
				if(UploadImage.getText().equals(_UploadImage)) {
					log(UploadImage.getText()+" is displayed in UI");
					if(AddProperties.getText().equals(_AddProperties)) {
						log(AddProperties.getText()+" is displayed in UI");
						if(EditProperties.getText().equals(_EditProperties)) {
							log(EditProperties.getText()+" is displayed in UI");
							if(ManageAdditionalProperties.getText().equals(_ManageAdditionalProperties)) {
								log(ManageAdditionalProperties.getText()+" is displayed in UI");
								if(Pricing.getText().equals(_Pricing)) {
									log(Pricing.getText()+" is displayed in UI");
									log(pageHeader.getText());
									if(pageHeader.getText().equals(_PageHeader)) {
										log(pageHeader.getText()+" is displayed as header in UI");
										ArticleName_inputfield.clear();
										ArticleName_inputfield.sendKeys(_Name);
										if(pageHeader.getText().equals(_UpdatedHeader))
											log(pageHeader.getText()+" is displayed after edit of the Name");
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

	public void editArticleDetails(String _Name,String _Description) throws InterruptedException, AWTException {

		wh.waitForElementToBeClickable(ArticleName_inputfield, driver, 10);
		ArticleName_inputfield.clear();
		ArticleName_inputfield.sendKeys(_Name);
		log("Entered the Name as "+_Name);
		LocalizedDescription_inputfield.clear();
		LocalizedDescription_inputfield.sendKeys(_Description);
		log("Entered the Description");
		takeScreenShot();
	}

	public void clickonAddLocalizedName() {
		ProductNameLocalizedEarthIcon.click();
		log("Clicked on the Add localized names icon");
		takeScreenShot();

	}

	public void addlocalizednamesDetails(String _localeForAddlocalizedNames,String _LocalizedName) throws InterruptedException {
		AddlocalizedNamesPopUP_localeDropdown.click();

//		WebElement localevalue = driver.findElement(By.xpath("//div[8]/div/div[3]/ul/li[text()='"+_localeForAddlocalizedNames+"']"));
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

	public void clickonAddLocalizedDescription() {
		wh.waitForElementToBeVisible(ProductDescriptionLocalizedEarthIcon, driver, 10);
		clickElementUsingJavaScript(ProductDescriptionLocalizedEarthIcon);
		log("Clicked on the Add localized Description icon");
		takeScreenShot();

	}

	public void addlocalizedDescriptionDetails(String _localeForAddlocalizedDescription,String _LocalizedNameDescription) throws InterruptedException {
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

	public void SelectProductFromDropDown(String _SelectProductForArticle) {

		wh.waitForElementToBeClickable(SelectProductDD, driver, 20);
		clickElementUsingJavaScript(SelectProductDD);
		log("Clicked on the Select Product Drop Down ");

		WebElement dropdownProductValue = driver.findElement(By.xpath("//li[@class='k-item ng-scope' and text()='"+_SelectProductForArticle+"']"));
		wh.waitForElementToBeClickable(dropdownProductValue, driver, 10);
		clickElementUsingJavaScript(dropdownProductValue);
		log("Selected the product "+_SelectProductForArticle);
		takeScreenShot();
	}

	public String searchAndSelectArticleCreated(String _ArticleName,String _ProductNameOfArticle,String _Type,String _ArticleStatus) throws InterruptedException {
		String status = "FAIL";

		Thread.sleep(10000);
		List<WebElement> tenantRows = driver.findElements(By.xpath("//table[@class='k-selectable']//tbody//tr"));
		log("No of rows ="+tenantRows.size());
		for(int i=0;i<tenantRows.size();i++) {
			int j=i+1;


			WebElement NameColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[1]"));
			WebElement ProductColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[2]"));
			WebElement TypeColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[3]"));
			WebElement StatusColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[4]"));

			if(NameColumnValue.getText().equals(_ArticleName)) {	
				log(NameColumnValue.getText()+" is displayed in UI");
				if(ProductColumnValue.getText().equals(_ProductNameOfArticle)) {
					log(ProductColumnValue.getText()+" is displayed in UI");
					if(TypeColumnValue.getText().equals(_Type)) {
						log(TypeColumnValue.getText()+" is displayed in UI");
						if(StatusColumnValue.getText().equals(_ArticleStatus)) {
							log(StatusColumnValue.getText()+" is displayed in UI");
							driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]")).click();
							log("Product -> "+_ArticleName+" Searched and Selected ");
							status ="PASS";

						}
					}
				}
			}
		}
		return status;
	}

	public String verifyCloneConfirmationMessage(String _CloneInformationMessage) {
		status="FAIL";
		List<WebElement> window = driver.findElements(By.xpath("//span[@class='k-window-title' and text()='Information']"));
		if(window.size()==1) {
			log(CloneConfirmationMessage.getText());
			if(CloneConfirmationMessage.getText().equals(_CloneInformationMessage)) {
				log("Information message displayed as "+CloneConfirmationMessage.getText());
				takeScreenShot();
				OKButton.click();
				status="PASS";
				
			}
		}
		return status;
		
		
		
	}


		public void clickonAddProperties() {
			wh.waitForElementToBeVisible(AddProperties, driver, 10);
			clickElementUsingJavaScript(AddProperties);
			log("Clicked on the Add properties icon");
			takeScreenShot();

		}

		public void AddPropertiesToArticleAndSave(String _PropertyName,String _PropertyDescription,String _PropertyLocaleValue,String _PropertyMeasurementUnit,
				String _PropertyUnitValue,String _UploadImageForPropertyYesOrNo,String _Browser) throws IOException, AWTException, InterruptedException{
			wh.waitForElementToBeClickable(textField_PropertyName, driver, 30);
			textField_PropertyName.clear();
			textField_PropertyName.sendKeys(_PropertyName);
			log("Entered the Property Name as "+_PropertyName);
			
			textArea_PropertyDescription.clear();
			textArea_PropertyDescription.sendKeys(_PropertyDescription);
			log("Entered the Description as "+_PropertyDescription);
			
			//dropDownList_PropertyLocale.click();
			//WebElement localeValue = driver.findElement(By.xpath("html/body/div[15]/div/div[3]/ul/li[text()='"+_PropertyLocaleValue+"']"));
			//wh.waitForElementToBeClickable(localeValue, driver, 30);
			//clickElementUsingJavaScript(localeValue);
			//log("Property locale value selected as "+_PropertyLocaleValue);

			
			textField_PropertyMeasurementUnit.clear();
			textField_PropertyMeasurementUnit.sendKeys(_PropertyMeasurementUnit);
			log("Measurement unit is entered as "+_PropertyMeasurementUnit);
			
			textField_PropertyValue.clear();
			textField_PropertyValue.sendKeys(_PropertyUnitValue);
			log("Value is entered as "+_PropertyUnitValue);
			
			if(_UploadImageForPropertyYesOrNo.equalsIgnoreCase("YES")) {
				//button_Selectimage.click();
			//	uploadFile(_Browser, ConstantValues.LEFTLOGO_IMG);
				
				mkh.pressTabKeyAndRelease();
				mkh.pressEnterKeyAndRelease();
				uploadFile(_Browser, ConstantValues.LEFTLOGO_IMG);
				log("Image is uploaded");
				takeScreenShot();
				button_SaveProperties.click();
				log("Clicked on the Save button in the dialog pop up");
				Thread.sleep(5000);
			}
			
			
			
			
		}

		public String searchAndSelectPropertiesAdded(String _GeneralPropertiesLabel_EditArticle,String _NameColHeader_EditArticle_Properties,
				String _ValueColHeader_EditArticle_Properties,String _TypeColHeader_EditArticle_Properties,String _NamePropertyValue_EditArticlePage,
				String _ValuePropertyValue_EditArticlePage, String _TypePropertyValue_EditArticlePage) {
			
			status="FAIL";
			wh.waitForElementToBeClickable(labelDropDown_GeneralProperties, driver, 30);
			if(labelDropDown_GeneralProperties.getText().equals(_GeneralPropertiesLabel_EditArticle)) {
				log(labelDropDown_GeneralProperties.getText()+" is displayed in UI");
				wh.waitForElementToBeClickable(labelDropDown_GeneralProperties, driver, 30);
				labelDropDown_GeneralProperties.click();
				
				if(column_GeneralPropertiesName.getText().equals(_NameColHeader_EditArticle_Properties)) {
					log(column_GeneralPropertiesName.getText()+" is displayed in UI");
					
					if(column_GeneralPropertiesValue.getText().equals(_ValueColHeader_EditArticle_Properties)) {
						log(column_GeneralPropertiesValue.getText()+" is displayed in UI");
						
						if(column_GeneralPropertiesType.getText().equals(_TypeColHeader_EditArticle_Properties)) {
							log(column_GeneralPropertiesType.getText()+" is displayed in UI");
							
							List<WebElement> noOfRows = driver.findElements(By.xpath("//div[@kendo-grid='model.propertiesGrid']//tbody//tr"));
							for(int i=0;i<noOfRows.size();i++) {
								int j=i+1;
								WebElement nameColumnValue = driver.findElement(By.xpath("//div[@kendo-grid='model.propertiesGrid']//tbody//tr["+j+"]//td[1]//span[1]"));
								WebElement valueColumnValue = driver.findElement(By.xpath("//div[@kendo-grid='model.propertiesGrid']//tbody//tr["+j+"]//td[2]//span[1]"));
								WebElement typeColumnValue = driver.findElement(By.xpath("//div[@kendo-grid='model.propertiesGrid']//tbody//tr["+j+"]//td[3]//span[1]"));
								
								if(nameColumnValue.getText().equals(_NamePropertyValue_EditArticlePage)) {
									if(valueColumnValue.getText().equals(_ValuePropertyValue_EditArticlePage)) {
										if(typeColumnValue.getText().equals(_TypePropertyValue_EditArticlePage)) {
											status="PASS";
											takeScreenShot();
											log("Name column value displayed under General properties "+nameColumnValue.getText());
											log("Value column value displayed under General properties "+valueColumnValue.getText());
											log("Type column value displayed under General properties "+typeColumnValue.getText());
											driver.findElement(By.xpath("//div[@kendo-grid='model.propertiesGrid']//tbody//tr["+j+"]")).click();
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

		public void clickonPricing() {
			wh.waitForElementToBeClickable(Pricing, driver, 20);
			Pricing.click();
			log("clicked on Pricing icon");
			takeScreenShot();
			
		}

		public void clickonCancel() {
			wh.waitForElementToBeClickable(Cancel, driver, 20);
			Cancel.click();
			log("clicked on Cancel icon");
			takeScreenShot();
			
		}

		public void clickOnSubscriptionPlans() throws InterruptedException {
			Thread.sleep(5000);
			clickElementUsingJavaScript(SubscriptionPlans);
			log("Clicked on the Subscription plans icon");
			takeScreenShot();
			
		}
		
	




}