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

public class EditCatalogPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status;


	public static final Logger log = Logger.getLogger(AddFacilitiesPage.class.getName());



	//Class constructor
	public EditCatalogPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='task-close ng-scope']")
	public WebElement taskcloseicon;
	
	public void clickonXtaskHeaderControlicon() {
		taskcloseicon.click();
		log("clicked on the X icon in the Task Header label");
		takeScreenShot();
	}

	//****************************************************************************************************************
	@FindBy(xpath = "//div[@class='v-progress-window ng-scope k-window-content k-content']//span[@translate='VSMCommon.ProgressLoading']")
	public WebElement loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;
	
	@FindBy(xpath = "//div[contains(@v-label,'CH.SelectTenant')]/div/div//span/span[@class='k-dropdown-wrap k-state-default']")
	public WebElement TenantDropDown;

	@FindBy(xpath = "//*[@id='catalog_add_page']/div[2]/div/form/div/div/div/vsm-rebind/input")
	public WebElement Name_inputfield;

	

	@FindBy(xpath = "//li[@id='ssp_catalogs_edit_save']")
	public WebElement catalogUpdate;
	
	@FindBy(xpath = "//li[@id='ssp_catalogs_edit_cancel']")
	public WebElement catalogCancel;


	//****************************************************************************************************************

	public void selectLocale(String _LocaleValue) {
		driver.findElement(By.xpath("//div[@id='ssp_facility_add_locale']/span/span']")).click();
		WebElement locale = driver.findElement(By.xpath("//li[text()='"+_LocaleValue+"']"));
		clickElementUsingJavaScript(locale);
	}


	/**
	 * Method to add the facilities 
	 * @throws InterruptedException 
	 */
	public void editCatalogDetails(String _editedName) throws InterruptedException {

		Name_inputfield.clear();
//		wh.waitForElementToBeInvisible(Name_inputfield, driver, 20);
		Thread.sleep(4000);
		Name_inputfield.sendKeys(_editedName);
		log("catalog name edited");
		
		
	}
	
	/**
	 * Method to add the facilities 
	 * @throws InterruptedException 
	 */
	public void cloneCatalogDetails(String _clonnedName) throws InterruptedException {
		Name_inputfield.clear();
//		wh.waitForElementToBeInvisible(Name_inputfield, driver, 20);
		Thread.sleep(4000);
		Name_inputfield.sendKeys(_clonnedName);
		log("clonned catalog name entered");
		
		
	}
	/**
	 * To save the facilities
	 */

	public void clickonSave() throws InterruptedException {
		wh.waitForElementToBeClickable(catalogUpdate, driver, 10);
		catalogUpdate.click();
		Thread.sleep(8000);

	}

	public String searchAndSelectCatalogClonned(String _ClonnedCatalogName) throws InterruptedException {
		status = "FAIL";
		Thread.sleep(8000);

		List<WebElement> catalogs = driver.findElements(By.xpath("//div[@class='ng-scope k-grid k-widget' and @kendo-grid='model.catalogsGrid']//tbody//tr"));
		log("No of rows found for catalog list is "+catalogs.size());

		
		for(int i=0;i<catalogs.size();i++) {
			int j=i+1;

			WebElement NameColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[1]"));
			
			if(NameColumnValue.getText().equals(_ClonnedCatalogName)) {		
				log(_ClonnedCatalogName);
						driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]")).click();
						log("Catalog is -> "+_ClonnedCatalogName+" is Searched and Selected ");
						status ="PASS";
						takeScreenShot();
				
			}
		}

		return status;



	}

}