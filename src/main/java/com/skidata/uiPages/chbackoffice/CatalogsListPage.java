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
public class CatalogsListPage extends TestBase {
	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);



	public static final Logger log = Logger.getLogger(CatalogsListPage.class.getName());
	String status=null;


	public CatalogsListPage(WebDriver driver,ExtentTest test) {
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

	@FindBy(xpath = "//span[@translate='VSMCommon.ProgressLoading' and text()='Loading...']")
	public WebElement loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;

	@FindBy(xpath = "//div[contains(@v-label,'CH.SelectTenant')]/div/div//span/span[@class='k-dropdown-wrap k-state-default']")
	public WebElement TenantDropDown;
	
	@FindBy(xpath = "//div[contains(@v-label,'SSPCatalog.LocaleSelector-LabelName')]//div//span[@class='k-input ng-scope']")
	public WebElement LocaleDropDown;


	@FindBy(xpath = "//li[@id='ssp_catalogs_add']")
	public WebElement Addiconlabel;

	@FindBy(xpath = "//li[@id='ssp_catalogs_edit']")
	public WebElement Editiconlabel;
	
	@FindBy(xpath = "//li[@id='ssp_catalogs_delete']")
	public WebElement Deleteiconlabel;
	
	@FindBy(xpath = "//li[@id='ssp_catalogs_clone']")
	public WebElement Cloneiconlabel;
	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPCatalog.ToolbarLabel-Assign']")
	public WebElement Assigniconlabel;
	
	@FindBy(xpath = "//li[@id='ssp_catalogs_assign_saleschannel']")
	public WebElement AssignSaleschannelsiconlabel;
	
	@FindBy(xpath = "//li[@id='ssp_catalogs_assign_articles']")
	public WebElement Assignarticlesiconlabel;
	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPCatalog.ToolbarLabel-ViewAssigned']")
	public WebElement ViewAssignediconlabel;
	
	@FindBy(xpath = "//li[@id='ssp_catalogs_view_saleschannel']")
	public WebElement viewAssignedSalesChannel;
	
	@FindBy(xpath = "//li[@id='ssp_catalogs_view_articles']")
	public WebElement viewAssignedArticles;
	
		
	@FindBy(xpath = "//li[@id='ssp_catalogs_refresh']")
	public WebElement Refreshiconlabel;
	
	
	@FindBy(xpath = "//p[@translate='SSPCatalog.ApplicationHeader-catalogsList']")
	public WebElement PageHeader;
	
	@FindBy(xpath = "//span[@translate='SSPCatalog.GridColumnHeader-Name']")
	public WebElement NameCol;


	@FindBy(xpath = "//*[@id='ssp_catalogs_assignelist_cancel']")
	public WebElement ViewAssignCancel;


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
		Refreshiconlabel.click();
		log("Clicked on Refresh icon");
		takeScreenShot();
		log("Page is refreshed");

	}

	/**
	 * Method to click on the Add button in the Tenants list page to Add a new Tenant
	 */
	public void clickonAddCatalogIcon() {
		waitforInvisibilityOfLoading();
		wh.waitForElementToBeClickable(Addiconlabel, driver, 10);
		clickElementUsingJavaScript(Addiconlabel);
		log("Clicked on the Add icon label in the catalog list page");
		takeScreenShot();
	}

	/**
	 * Method to click on the edit button in the Tenants list page to Add a new Tenant
	 */
	public void clickonEditCatalogIcon() {
		waitforInvisibilityOfLoading();
		wh.waitForElementToBeClickable(Editiconlabel, driver, 10);
		clickElementUsingJavaScript(Editiconlabel);
		log("Clicked on the edit icon label in the catalog list page");
		takeScreenShot();
	}

	/**
	 * Method to click on the clone button in the Tenants list page to Add a new Tenant
	 */
	public void clickonCloneCatalogIcon() {
		waitforInvisibilityOfLoading();
		wh.waitForElementToBeClickable(Cloneiconlabel, driver, 10);
		clickElementUsingJavaScript(Cloneiconlabel);
		log("Clicked on the clone icon label in the catalog list page");
		takeScreenShot();
	}
	
	public void AssignSaleschannelsclick() {
		waitforInvisibilityOfLoading();
		wh.waitForElementToBeClickable(AssignSaleschannelsiconlabel, driver, 10);
		clickElementUsingJavaScript(AssignSaleschannelsiconlabel);
		log("Clicked on the assign sales channel icon label in the catalog list page");
		takeScreenShot();
		
	}
/**
 * To view the assigned sales channel to the catalog
 */
	public void viewAssignedSalesChannel() {
		waitforInvisibilityOfLoading();
		wh.waitForElementToBeClickable(viewAssignedSalesChannel, driver, 10);
		clickElementUsingJavaScript(viewAssignedSalesChannel);
		log("Clicked on the view assigned sales channel icon label in the catalog list page");
		takeScreenShot();
	}
	/**
	 * To view the assigned articles  to the catalog
	 */
		public void viewAssignedArticles() {
			waitforInvisibilityOfLoading();
			wh.waitForElementToBeClickable(viewAssignedSalesChannel, driver, 10);
			clickElementUsingJavaScript(viewAssignedSalesChannel);
			log("Clicked on the view assigned sales channel icon label in the catalog list page");
			takeScreenShot();
		}
		/**
		 * To cancel the view assign sales channel
		 */
		public void cancelViewChannel() {
			waitforInvisibilityOfLoading();
			wh.waitForElementToBeClickable(ViewAssignCancel, driver, 10);
			clickElementUsingJavaScript(ViewAssignCancel);
			log("Clicked on the cancel assigned sales channel icon  in the assign list page");
			takeScreenShot();
		}
		
		
		
	

	public void selectTenant(String _TenantName) throws InterruptedException {

		waitforInvisibilityOfLoading();
		//clickElementUsingJavaScript(TenantDropDown);
		clickElementUsingJavaScript(TenantDropDown);
		WebElement selectTenant = driver.findElement(By.xpath("//ul[@class='k-list k-reset']//li[@class='k-item ng-scope' and text()='"+_TenantName+"']"));
		
		clickElementUsingJavaScript(selectTenant);
		Thread.sleep(6000);
	}

	
	public void selectTenantLocale(String _TenantLocale) throws InterruptedException {
	
		clickElementUsingJavaScript(LocaleDropDown);
		WebElement selectTenantLocale = driver.findElement(By.xpath("//ul[@class='k-list k-reset']//li[contains(@class,'k-item ng-scope') and text()='"+_TenantLocale+"']"));
		Thread.sleep(3000);
		clickElementUsingJavaScript(selectTenantLocale);
	}

	public String verifyIconLabels(String _Addlabel, String _Editlabel, String _Deletelabel, String _Clonelabel, String _Assign,
			String _AssignSaleschannels, String _AssignArticles,String _ViewAssigned,String _ViewAssignedSalesChannels,String _ViewAssignedArticles,
			String _Refresh) {
	       status="FAIL";
	       if(Addiconlabel.getText().equals(_Addlabel)) {
	    	   log(Addiconlabel.getText()+" is displayed in UI");
	    	   if(Editiconlabel.getText().equals(_Editlabel)) {
	    		   log(Editiconlabel.getText()+" is displayed in UI");
	    		   if(Deleteiconlabel.getText().equals(_Deletelabel)) {
	    			   log(Deleteiconlabel.getText()+" is displayed in UI");
	    			   if(Cloneiconlabel.getText().equals(_Clonelabel)) {
	    				   log(Cloneiconlabel.getText()+" is displayed in UI");
	    				   if(Assigniconlabel.getText().equals(_Assign)) {
	    					   log(Assigniconlabel.getText()+" is displayed in UI");
	    					   if(AssignSaleschannelsiconlabel.getText().equals(_AssignSaleschannels)) {
	    						   log(AssignSaleschannelsiconlabel.getText()+" is displayed in UI");
	    						   if(Assignarticlesiconlabel.getText().equals(_AssignArticles)) {
	    							   log(Assignarticlesiconlabel.getText()+" is displayed in UI");
	    							   if(ViewAssignediconlabel.getText().equals(_ViewAssigned)) {
	    								   log(ViewAssignediconlabel.getText()+" is displayed in UI");
	    								  if(viewAssignedSalesChannel.getText().equals(_ViewAssignedSalesChannels)) {
	    									  log(viewAssignedSalesChannel.getText()+" is displayed in UI");
	    									  if(viewAssignedArticles.getText().equals(_ViewAssignedArticles)) {
	    										  log(viewAssignedArticles.getText()+" is displayed in UI");
	    										  if(Refreshiconlabel.getText().equals(_Refresh)) {
	    											  log(Refreshiconlabel.getText()+" is displayed in UI");
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
	    		   }
	    	   }
	       }
		return status;
		
	}

	
	
	
	public String verifyHeaderAndTableColumns(String _CatalogslistpageHeader,String _NameCol) {
		status="FAIL";

		if(PageHeader.getText().equals(_CatalogslistpageHeader)) {
			log(PageHeader.getText()+ " is displayed in UI");
			if(NameCol.getText().equals(_NameCol)) {
				log(NameCol.getText()+ " column is displayed in UI");
				
							status="PASS";
							takeScreenShot();
						}
					}
	
		return status;
	}
	
	
	
	public String searchAndSelectCatalogCreated(String _CreatedCatalogName) throws InterruptedException {
		status = "FAIL";
		Thread.sleep(8000);

		List<WebElement> catalogs = driver.findElements(By.xpath("//div[@class='ng-scope k-grid k-widget' and @kendo-grid='model.catalogsGrid']//tbody//tr"));
		log("No of rows found for catalog list is "+catalogs.size());

		
		for(int i=0;i<catalogs.size();i++) {
			int j=i+1;

			WebElement NameColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[1]"));
			
			if(NameColumnValue.getText().equals(_CreatedCatalogName)) {		
				log(_CreatedCatalogName);
						driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]")).click();
						log("Catalog is -> "+_CreatedCatalogName+" is Searched and Selected ");
						status ="PASS";
						takeScreenShot();
				
			}
		}

		return status;



	}

}




