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
public class ArticleListPage extends TestBase {
	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);


	public static final Logger log = Logger.getLogger(ArticleListPage.class.getName());
	String status=null;


	public ArticleListPage(WebDriver driver,ExtentTest test) {
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

	@FindBy(xpath = "//div[contains(@v-label,'SSPArticle.LocaleSelector-LabelName')]//div//span[@class='k-input ng-scope']")
	public WebElement LocaleDropDown;


	@FindBy(xpath = "//li[@id='ssp_article_add']")
	public WebElement Addiconlabel;

	
	@FindBy(xpath = "//li[@id='ssp_article_edit']")
	public WebElement Editiconlabel;

	@FindBy(xpath = "//li[@id='ssp_article_delete']")
	public WebElement Deleteiconlabel;

	@FindBy(xpath = "//li[@id='sssp_article_clone']")
	public WebElement Cloneiconlabel;

	@FindBy(xpath = "//li[@id='ssp_article_activate']")
	public WebElement Activateiconlabel;

	@FindBy(xpath = "//li[@id='ssp_article_deactivate']")
	public WebElement Deactivateiconlabel;

	@FindBy(xpath = "//li[@id='ssp_article_refresh']")
	public WebElement Refreshiconlabel;

	@FindBy(xpath = "//li[@id='ssp_article_reset']")
	public WebElement Reseticonlabel;

	@FindBy(xpath = "//p[@class='ng-scope' and  @translate='Articles list']")
	public WebElement PageHeader;

	@FindBy(xpath = "//span[@translate='SSPArticle.GridColumnHeader-Name']")
	public WebElement NameCol;

	@FindBy(xpath = "//span[@translate='SSPArticle.GridColumnHeader-product']")
	public WebElement ProductCol;

	@FindBy(xpath = "//span[@translate='SSPArticle.GridColumnHeader-ArticleType']")
	public WebElement TypeCol;

	@FindBy(xpath = "//span[@translate='SSPArticle.GridColumnHeader-Status']")
	public WebElement StatusCol;

	@FindBy(xpath = "//span[@class='k-window-title' and text()='Confirm']")
	public WebElement ConfirmDeleteDialoglabel;


	@FindBy(xpath = "//p[@class='ng-scope' and @translate='SSPArticle.ArticleForm-ConfirmDeleteArticle']")
	public WebElement deleteconfirmationMessage;


	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonYes']")
	public WebElement YesButtoninDeleteConfirmation;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonNo']")
	public WebElement NoButtoninDeleteConfirmation;


	@FindBy(xpath = "//span[@class='k-icon k-i-close']")
	public WebElement closeXiconinDeleteConfirmationPopup;


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
	public void clickonAddArticlesIcon() {
		waitforInvisibilityOfLoading();
		wh.waitForElementToBeClickable(Addiconlabel, driver, 10);
		clickElementUsingJavaScript(Addiconlabel);
		log("Clicked on the Add icon label in the Article list page");
		takeScreenShot();
	}


	public void selectTenant(String _TenantName) throws InterruptedException {

		waitforInvisibilityOfLoading();
		wh.waitForElementToBeVisible(TenantDropDown, driver, 20);
		clickElementUsingJavaScript(TenantDropDown);
		WebElement selectTenant = driver.findElement(By.xpath("//ul[@class='k-list k-reset']//li[@class='k-item ng-scope' and text()='"+_TenantName+"']"));
		selectTenant.click();
	}

	public void selectTenantLocale(String _TenantLocale) throws InterruptedException {

		clickElementUsingJavaScript(LocaleDropDown);
		Thread.sleep(5000);
		WebElement selectTenantLocale = driver.findElement(By.xpath("//ul[@class='k-list k-reset']//li[contains(@class,'ng-scope') and text()='"+_TenantLocale+"']"));
		wh.waitForElementToBeVisible(selectTenantLocale, driver, 30);
		clickElementUsingJavaScript(selectTenantLocale);
	}

	public String verifyIconLabels(String _Addlabel, String _Editlabel, String _Deletelabel, String _Clonelabel, String _Activatelabel,
			String _Deactivatelabel, String _Refreshlabel,String _Resetlabel) {
		status="FAIL";
		if(Addiconlabel.getText().equals(_Addlabel)) {
			log(Addiconlabel.getText()+" is displayed in UI");
			if(Editiconlabel.getText().equals(_Editlabel)) {
				log(Editiconlabel.getText()+" is displayed in UI");
				if(Deleteiconlabel.getText().equals(_Deletelabel)) {
					log(Deleteiconlabel.getText()+" is displayed in UI");
					if(Cloneiconlabel.getText().equals(_Clonelabel)) {
						log(Cloneiconlabel.getText()+" is displayed in UI");
						if(Activateiconlabel.getText().equals(_Activatelabel)) {
							log(Activateiconlabel.getText()+" is displayed in UI");
							if(Deactivateiconlabel.getText().equals(_Deactivatelabel)) {
								log(Deactivateiconlabel.getText()+" is displayed in UI");
								if(Refreshiconlabel.getText().equals(_Refreshlabel)) {
									log(Refreshiconlabel.getText()+" is displayed in UI");
									if(Reseticonlabel.getText().equals(_Resetlabel)) {
										log(Reseticonlabel.getText()+" is displayed in UI");
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

	public String verifyHeaderAndTableColumns(	String _ArticlelistpageHeader,String _NameCol, String _ProductCol, String _TypeCol, String _StatusCol) {
		status="FAIL";

		if(PageHeader.getText().equals(_ArticlelistpageHeader)) {
			log(PageHeader.getText()+ " is displayed in UI");
			if(NameCol.getText().equals(_NameCol)) {
				log(NameCol.getText()+ " column is displayed in UI");
				if(ProductCol.getText().equals(_ProductCol)) {
					log(ProductCol.getText()+ " column is displayed in UI");
					if(TypeCol.getText().equals(_TypeCol)) {
						log(TypeCol.getText()+ " column is displayed in UI");
						if(StatusCol.getText().equals(_StatusCol)) {
							log(StatusCol.getText()+ " column is displayed in UI");
							status="PASS";
							takeScreenShot();
						}
					}
				}
			}
		}

		return status;
	}

	public void clickonDelete() {
		wh.waitForElementToBeClickable(Deleteiconlabel, driver, 20);
		Deleteiconlabel.click();
		log("Clicked on the Delete icon");
		takeScreenShot();

	}


	public String verifyDeleteArticleConfirmationDialogAndClickX(String _ConfirmHeaderDeleteArticle,String _ConfirmMessageDeleteArticle,
			String _ConfirmYesButtonDeleteArticle,String _ConfirmNoButtonDeleteArticle) {
		status="FAIL";

		if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmHeaderDeleteArticle)){
			log("Message is displayed -> "+deleteconfirmationMessage.getText());
			if(deleteconfirmationMessage.getText().equals(_ConfirmMessageDeleteArticle)) {
				log("Button Label is displayed -> "+YesButtoninDeleteConfirmation.getText());
				if(YesButtoninDeleteConfirmation.getText().equals(_ConfirmYesButtonDeleteArticle)) {
					log("Button Label is displayed -> "+NoButtoninDeleteConfirmation.getText());
					if(NoButtoninDeleteConfirmation.getText().equals(_ConfirmNoButtonDeleteArticle)) {
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

	public String verifyDeleteArticleConfirmationDialogAndClickNo(String _ConfirmHeaderDeleteArticle,String _ConfirmMessageDeleteArticle,
			String _ConfirmYesButtonDeleteArticle,String _ConfirmNoButtonDeleteArticle) {
		status="FAIL";

		if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmHeaderDeleteArticle)){
			log("Message is displayed -> "+deleteconfirmationMessage.getText());
			if(deleteconfirmationMessage.getText().equals(_ConfirmMessageDeleteArticle)) {
				log("Button Label is displayed -> "+YesButtoninDeleteConfirmation.getText());
				if(YesButtoninDeleteConfirmation.getText().equals(_ConfirmYesButtonDeleteArticle)) {
					log("Button Label is displayed -> "+NoButtoninDeleteConfirmation.getText());
					if(NoButtoninDeleteConfirmation.getText().equals(_ConfirmNoButtonDeleteArticle)) {
						takeScreenShot();
						wh.waitForElementToBeClickable(closeXiconinDeleteConfirmationPopup, driver, 10);
						NoButtoninDeleteConfirmation.click();
						log("clicked on No button");
						status="PASS";

					}
				}
			}
		}
		return status;

	}

	public String verifyDeleteArticleConfirmationDialogAndClickYes(String _ConfirmHeaderDeleteArticle,String _ConfirmMessageDeleteArticle,
			String _ConfirmYesButtonDeleteArticle,String _ConfirmNoButtonDeleteArticle) {
		status="FAIL";

		if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmHeaderDeleteArticle)){
			log("Message is displayed -> "+deleteconfirmationMessage.getText());
			if(deleteconfirmationMessage.getText().equals(_ConfirmMessageDeleteArticle)) {
				log("Button Label is displayed -> "+YesButtoninDeleteConfirmation.getText());
				if(YesButtoninDeleteConfirmation.getText().equals(_ConfirmYesButtonDeleteArticle)) {
					log("Button Label is displayed -> "+NoButtoninDeleteConfirmation.getText());
					if(NoButtoninDeleteConfirmation.getText().equals(_ConfirmNoButtonDeleteArticle)) {
						takeScreenShot();
						wh.waitForElementToBeClickable(closeXiconinDeleteConfirmationPopup, driver, 10);
						YesButtoninDeleteConfirmation.click();
						log("clicked on Yes button");
						status="PASS";

					}
				}
			}
		}
		return status;

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

	public void clickonEdit() {
		wh.waitForElementToBeClickable(Editiconlabel, driver, 20);
		Editiconlabel.click();
		log("Edit icon is clicked");
		takeScreenShot();

	}

	public void clickonClone() {
		wh.waitForElementToBeClickable(Cloneiconlabel, driver, 20);
		Cloneiconlabel.click();
		log("Clone icon is clicked");
		takeScreenShot();

	}


	/**
	 * Method to Select the Facility 
	 * @param _FacilityName
	 * @param _Locale
	 * @throws InterruptedException 
	 */
	
	public String selectArticleFromTable(String _ArticleName,String _Product,String _Type,
			String _Facility,String _Status) throws InterruptedException {

		Thread.sleep(5000);
		status ="FAIL";
		List<WebElement> totalrows = driver.findElements(By.xpath("//div[@kendo-grid='model.articlesGrid']//div[@class='k-grid-content k-auto-scrollable']//tr"));
		log("no of ros"+totalrows.size());

		for(int i=0;i<totalrows.size();i++) {
			int j=i+1;
			WebElement Name = driver.findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr["+j+"]/td[1]"));
			WebElement Product = driver.findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr["+j+"]/td[2]"));
			WebElement Type = driver.findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr["+j+"]/td[3]"));
			WebElement Facility = driver.findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr["+j+"]/td[4]"));
			WebElement Status = driver.findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr["+j+"]/td[5]"));
			
			log(Name.getText()+Product.getText()+Type.getText()+Facility.getText()+Status.getText());

			if(Name.getText().equals(_ArticleName)) {
				if(Product.getText().equals(_Product)) {
					if(Type.getText().equals(_Type)){
						
						if(Facility.getText().equals(_Facility)) {
							if(Status.getText().equals(_Status)) {
								driver.findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr["+j+"]/td[1]")).click();
								status="PASS";
								log("Selected the Article  -> "+_ArticleName+ " "+_Product+" "+ _Type+" "+_Facility+" "+_Status);
								takeScreenShot();
							
							}
						}
					}
				}
			}

		}
		return status;


	}
	
	/**
	 * Method to Select the Facility 
	 * @param _FacilityName
	 * @param _Locale
	 * @throws InterruptedException 
	 */
	
	public String selectArticleAndEdit() throws InterruptedException {

		Thread.sleep(5000);
		status ="FAIL";
		List<WebElement> totalrows = driver.findElements(By.xpath("//div[@kendo-grid='model.articlesGrid']//div[@class='k-grid-content k-auto-scrollable']//tr"));
		log("no of ros"+totalrows.size());

		for(int i=0;i<totalrows.size();i++) {
			int j=i+1;
			
			WebElement Type = driver.findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr["+j+"]/td[3]"));
			
			if(Type.getText().equals("Subscription")) {
				
				
			}
			
			
		}
		return status;


	}



}




