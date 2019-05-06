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
public class AddArticlePage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;


	public static final Logger log = Logger.getLogger(AddArticlePage.class.getName());



	//Class constructor
	public AddArticlePage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

	}


	/**
	 ******************************************************************************************************
	 * Web Elements of Add Article page
	 ******************************************************************************************************
	 */
	
	@FindBy(xpath = "//span[@class='v-label' and text()='LOADING...']")
	public WebElement loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;

	@FindBy(xpath = "//div[contains(@v-label,'SSPCarPark.FormLabel-Facility')]//div//span[text()='--- Select ---']")
	public WebElement FacilityDropdown;

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

	@FindBy(xpath = "//li[@id='ssp_article_add_save']")
	public WebElement Save;

	@FindBy(xpath = "//li[@id='ssp_article_add_cancel']")
	public WebElement Cancel;

	@FindBy(xpath = "//div[contains(@v-label,'SSPArticle.ArticleForm-selectProduct')]//div//span[@class='k-dropdown-wrap k-state-default']")
	public WebElement SelectProductDD;
	
	@FindBy(xpath = "//div[@class='task-close ng-scope']")
	public WebElement taskcloseicon;

	@FindBy(xpath = "//p[@class='ng-scope' and @translate='SSPArticle.AddArticleHeader']")
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
	 * Method to verify Icon Labels and Header in Add Article page
	 * @param _SaveLabel
	 * @param _CancelLabel
	 * @param _PageHeaderAddArticle
	 * @param _ArticleName
	 * @param _PageHeaderAfterEnteringName
	 * @return
	 * @throws InterruptedException 
	 */
	public String verifyIconLabelsAndHeader(String _SaveLabel,String _CancelLabel,String _PageHeaderAddArticle,String _ArticleName,String _PageHeaderAfterEnteringName) throws InterruptedException {
		status="FAIL";
		if(Save.getText().equals(_SaveLabel)) {
			log("Save button is displayed ");
			if(Cancel.getText().equals(_CancelLabel)) {
				log("Cancel button is displayed");
				
				if(pageHeader.getText().equals(_PageHeaderAddArticle)) {
					log("Header displayed as "+pageHeader.getText());
					ArticleName_inputfield.sendKeys(_ArticleName);
					log("Entered the Article Name as "+_ArticleName);
					log(pageHeader.getText());
			
					Thread.sleep(3000);
					if(pageHeader.getText().equals(_PageHeaderAfterEnteringName)) {
						log("Page header is updated as "+pageHeader.getText());
						takeScreenShot();
						status="PASS";
					}
				}
				
			}
		}
		return status;
	}

	public void addArticleDetails(String _Name,String _Description) throws InterruptedException, AWTException {

		wh.waitForElementToBeClickable(ArticleName_inputfield, driver, 10);
		ArticleName_inputfield.sendKeys(_Name);
		log("Entered the Name as "+_Name);
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
	
	public void clickonAddLocalizedDescription() {
		wh.waitForElementToBeVisible(ProductDescriptionLocalizedEarthIcon, driver, 10);
		clickElementUsingJavaScript(ProductDescriptionLocalizedEarthIcon);
		log("Clicked on the Add localized Description icon");
		takeScreenShot();

	}

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

	
	
	
	

}