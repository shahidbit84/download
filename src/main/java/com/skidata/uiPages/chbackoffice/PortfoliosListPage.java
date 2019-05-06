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
public class PortfoliosListPage extends TestBase {
	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;


	public static final Logger log = Logger.getLogger(PortfoliosListPage.class.getName());
	


	public PortfoliosListPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

	}
	


	/**
	 ******************************************************************************************************
	 * Web Elements of the page
	 ******************************************************************************************************
	 */

	@FindBy(xpath = "//span[@class='v-label' and translate='VSMCommon.ProgressLoading']")
	public WebElement loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;

	@FindBy(xpath = "//div[contains(@v-label,'CH.SelectTenant')]/div/div//span/span[@class='k-dropdown-wrap k-state-default']")
	public WebElement TenantDropDown;
	
	@FindBy(xpath = "//div[contains(@v-label,'SSPPortfolio.LocaleSelector-LabelName')]//div//span[@class='k-input ng-scope']")
	public WebElement LocaleDropDown;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='CH.ButtonAdd']")
	public WebElement PortfoliosListPage_Addiconlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='CH.ButtonEdit']")
	public WebElement PortfoliosListPage_Editiconlabel;
	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='CH.ButtonConfirmDelete']")
	public WebElement PortfoliosListPage_Deleteiconlabel;
	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='CH.buttonRefresh']")
	public WebElement PortfoliosListPage_Refreshiconlabel;

	@FindBy(xpath = "//p[@class='ng-scope' and  @translate='Portfolios List']")
	public WebElement PortfoliosListPage_header;
	
	@FindBy(xpath = "//span[@class='k-window-title' and text()='Confirm']")
	public WebElement ConfirmDeleteDialoglabel;

	@FindBy(xpath = "//p[@class='ng-scope' and @translate='SSPPortfolio.PortfolioForm-ConfirmDeletePortfolio']")
	public WebElement deleteconfirmationMessage;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonYes']")
	public WebElement YesButtoninDeleteConfirmation;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonNo']")
	public WebElement NoButtoninDeleteConfirmation;

	@FindBy(xpath = "//span[@class='k-icon k-i-close']")
	public WebElement closeXiconinDeleteConfirmationPopup;

	@FindBy(xpath = "//div[@class='task-close ng-scope']")
	public WebElement taskcloseicon;
	

	@FindBy(xpath = "//span[@translate='CH.buttonRefresh']")
	public WebElement Refresh_ButtonLabel;

	

	/**
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnRefreshButton() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		PortfoliosListPage_Refreshiconlabel.click();
		log("Clicked on Refresh icon");
		takeScreenShot();
		log("Page is refreshed");

	}

	/**
	 * Method to click on X task header Control icon
	 */
	public void clickonXtaskHeaderControlicon() {
		taskcloseicon.click();
		log("clicked on the X icon in the Task Header label");
		takeScreenShot();
	}
	
	
	
	
	public void waitforInvisibilityOfLoading() {
		waitForElementInVisiblity(driver, 10, loadingprogress);
		log("loading progress completed");
	}

	/**
	 * Method to click on the Add button in the Tenants list page to Add a new Tenant
	 */
	public void clickonAddPortfolioslIcon() {

		wh.waitForElementToBeClickable(PortfoliosListPage_Addiconlabel, driver, 10);
		clickElementUsingJavaScript(PortfoliosListPage_Addiconlabel);
		log("Clicked on the Add icon label in the Portfolios list page");
		takeScreenShot();
	}


	public void selectTenant(String _TenantName) throws InterruptedException {
		clickElementUsingJavaScript(TenantDropDown);
		WebElement selectTenant = driver.findElement(By.xpath("//ul[@class='k-list k-reset']//li[@class='k-item ng-scope' and text()='"+_TenantName+"']"));
		wh.waitForElementToBeClickable(selectTenant, driver, 30);
		clickElementUsingJavaScript(selectTenant);
	}

	public void selectTenantLocale(String _TenantLocale) throws InterruptedException {
		
		clickElementUsingJavaScript(LocaleDropDown);
		Thread.sleep(5000);
		WebElement selectTenantLocale = driver.findElement(By.xpath("//ul[@class='k-list k-reset']//li[contains(@class,'ng-scope') and text()='"+_TenantLocale+"']"));
		wh.waitForElementToBeVisible(selectTenantLocale, driver, 30);
		clickElementUsingJavaScript(selectTenantLocale);
	}
	
	
	
	public String verifyIconLabels(String _Addlabel,String _Editlabel,String _Deletelabel,String _Refreshlabel) {
		status="FAIL";
		if(PortfoliosListPage_Addiconlabel.getText().equals(_Addlabel)) {
			log(PortfoliosListPage_Addiconlabel.getText()+" is displayed in Portfolios list page");
			if(PortfoliosListPage_Editiconlabel.getText().equals(_Editlabel)) {
				log(PortfoliosListPage_Editiconlabel.getText()+" is displayed in Portfolios list page");
				if(PortfoliosListPage_Deleteiconlabel.getText().equals(_Deletelabel)) {
					log(PortfoliosListPage_Deleteiconlabel.getText()+" is displayed in Portfolios list page");
					if(PortfoliosListPage_Refreshiconlabel.getText().equals(_Refreshlabel)) {
						log(PortfoliosListPage_Refreshiconlabel.getText()+" is displayed in Portfolios list page");
						status="PASS";
						takeScreenShot();
						
					}
				}
			}
		}
		return status;
	
		
	}

	public String verifyHeaderAndTableColumns(String _PageHeader,String _NameColumn,String _DescriptionColumn) {
		status="FAIL";
		if(PortfoliosListPage_header.getText().equals(_PageHeader)) {
			
			WebElement namecolumn = driver.findElement(By.xpath("//span[@translate='SSPPortfolio.GridColumnPortfolioName']"));
			if(namecolumn.getText().equals(_NameColumn)) {
				log(namecolumn.getText() +" column is displayed");
				WebElement descriptionColumn = driver.findElement(By.xpath("//span[@translate='SSPPortfolio.GridColumnHeader-Description']"));
				
				if(descriptionColumn.getText().equals(_DescriptionColumn)) {
					log(descriptionColumn.getText() +" column is displayed");
					status="PASS";
					takeScreenShot();
				}
			}
		}
		return status;
		
	}




	public String searchAndSelectPortfolioCreated(String _PortfolioLocalizedName,String _PortfolioDescriptionName) throws InterruptedException {
		String status = "FAIL";


		Thread.sleep(10000);
		List<WebElement> portfolios = driver.findElements(By.xpath("//table[@class='k-selectable']//tbody//tr"));
		log("No of rows ="+portfolios.size());
		for(int i=0;i<portfolios.size();i++) {
			int j=i+1;


			WebElement NameColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[1]"));
			WebElement DescriptionColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[2]"));
			
			if(NameColumnValue.getText().equals(_PortfolioLocalizedName)) {		
				if(DescriptionColumnValue.getText().equals(_PortfolioDescriptionName)) {

						driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]")).click();
						log("Portfolio "+_PortfolioLocalizedName+"Searched and Selected ");
						status ="PASS";
						return status;
					}
				}
		}

		return status;

	}




	public void clickonDelete() {
		PortfoliosListPage_Deleteiconlabel.click();
		log("clicked on the delete icon");
		takeScreenShot();
		
		
	}

	
	public void clickonEdit() {
		PortfoliosListPage_Editiconlabel.click();
		log("clicked on the Edit icon");
		takeScreenShot();
		
		
	}



	public String verifyConfirmDeletePopUpLabelsAndClickX(String _ConfirmdeleteLabel,String _ConfirmMessage,String _YesbuttonText,String _NobuttonText) throws InterruptedException {
		status="FAIL";
	
		if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
			log("Message is displayed -> "+deleteconfirmationMessage.getText());
			if(deleteconfirmationMessage.getText().equals(_ConfirmMessage)) {
				log("Button Label is displayed -> "+YesButtoninDeleteConfirmation.getText());
				if(YesButtoninDeleteConfirmation.getText().equals(_YesbuttonText)) {
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




	public String verifyConfirmDeletePopUpLabelsAndClickNo(String _ConfirmdeleteLabel,String _ConfirmMessage,String _YesbuttonText,String _NobuttonText) throws InterruptedException {
		status="FAIL";
	
		if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
			log("Message is displayed -> "+deleteconfirmationMessage.getText());
			if(deleteconfirmationMessage.getText().equals(_ConfirmMessage)) {
				log("Button Label is displayed -> "+YesButtoninDeleteConfirmation.getText());
				if(YesButtoninDeleteConfirmation.getText().equals(_YesbuttonText)) {
					log("Button Label is displayed -> "+NoButtoninDeleteConfirmation.getText());
					if(NoButtoninDeleteConfirmation.getText().equals(_NobuttonText)) {
						takeScreenShot();
						wh.waitForElementToBeClickable(NoButtoninDeleteConfirmation, driver, 10);
						NoButtoninDeleteConfirmation.click();
						log("clicked on No button");
						status="PASS";

					}
				}
			}
		}
		return status;

	}




	public String verifyConfirmDeletePopUpLabelsAndClickYes(String _ConfirmdeleteLabel,String _ConfirmMessage,String _YesbuttonText,String _NobuttonText) throws InterruptedException {
		status="FAIL";
	
		if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
			log("Message is displayed -> "+deleteconfirmationMessage.getText());
			if(deleteconfirmationMessage.getText().equals(_ConfirmMessage)) {
				log("Button Label is displayed -> "+YesButtoninDeleteConfirmation.getText());
				if(YesButtoninDeleteConfirmation.getText().equals(_YesbuttonText)) {
					log("Button Label is displayed -> "+NoButtoninDeleteConfirmation.getText());
					if(NoButtoninDeleteConfirmation.getText().equals(_NobuttonText)) {
						takeScreenShot();
						wh.waitForElementToBeClickable(YesButtoninDeleteConfirmation, driver, 10);
						YesButtoninDeleteConfirmation.click();
						log("clicked on Yes button");
						status="PASS";

					}
				}
			}
		}
		return status;

	}


}




