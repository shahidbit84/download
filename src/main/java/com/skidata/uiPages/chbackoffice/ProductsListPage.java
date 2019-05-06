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
public class ProductsListPage extends TestBase {
	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;


	public static final Logger log = Logger.getLogger(ProductsListPage.class.getName());
	


	public ProductsListPage(WebDriver driver,ExtentTest test) {
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

	@FindBy(xpath = "//div[contains(@v-label,'SSPProduct.LocaleSelector-LabelName')]//div//span[@class='k-input ng-scope']")
	public WebElement LocaleDropDown;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='CH.ButtonAdd']")
	public WebElement ProductsListPage_Addiconlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='CH.ButtonEdit']")
	public WebElement ProductsListPage_Editiconlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='CH.ButtonConfirmDelete']")
	public WebElement ProductsListPage_Deleteiconlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='CH.ButtonActivate']")
	public WebElement ProductsListPage_Activateiconlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='CH.ButtonDeActivate']")
	public WebElement ProductsListPage_Deactivateiconlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='CH.buttonRefresh']")
	public WebElement ProductsListPage_Refreshiconlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPProduct.ApplicationHeader-GetArticles']")
	public WebElement ProductsListPage_Articlesiconlabel;

	@FindBy(xpath = "//p[@class='ng-scope' and  @translate='SSPProduct.ApplicationHeader-productsList']")
	public WebElement ProductsListPage_PageHeader;

	@FindBy(xpath = "//span[@translate='SSPProduct.GridColumnProductName']")
	public WebElement NameCol;

	@FindBy(xpath = "//span[@translate='SSPProduct.GridColumnHeader-Description']")
	public WebElement DescriptionCol;

	@FindBy(xpath = "//span[@translate='SSPProduct.GridColumnHeader-Type']")
	public WebElement TypeCol;

	@FindBy(xpath = "//span[@translate='SSPProduct.GridColumnHeader-Status']")
	public WebElement StatusCol;

	@FindBy(xpath = "//div[@class='task-close ng-scope']")
	public WebElement taskcloseicon;

	@FindBy(xpath = "//*[@id='{{windowId}}_wnd_title']")
	public WebElement DeleteProductConfirmHeader;

	@FindBy(xpath = "//p[@translate ='SSPProduct.ProductForm-ConfirmDeleteProduct']")
	public WebElement DeleteProductConfirmMessage;

	@FindBy(xpath = "//button[@translate ='VSMCommon.ButtonYes']")
	public WebElement DeleteConfirm_YesButton;

	@FindBy(xpath = "//button[@translate ='VSMCommon.ButtonNo']")
	public WebElement DeleteConfirm_NoButton;

	@FindBy(xpath = "//span[@class='k-icon k-i-close']")
	public WebElement closeXiconinDeleteConfirmationPopup;

	@FindBy(xpath = "//div[@class='k-window-titlebar k-header']//span[@class='k-window-title']")
	public WebElement ConfirmPopUpHeader;

	@FindBy(xpath = "//p[@translate='SSPProduct.ProductForm-ConfirmDeactivateProduct']")
	public WebElement DeactivateProductMessage;

	@FindBy(xpath = "//p[@translate='SSPProduct.ProductForm-ConfirmActivateProduct']")
	public WebElement ActivateProductMessage;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonYes']")
	public WebElement YesButton;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonNo']")
	public WebElement NoButton;

	@FindBy(xpath = "//span[@class='k-icon k-i-close' and text()='Close']")
	public WebElement XButtontocloseConfirmpopup;


	/**
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnRefreshButton() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		ProductsListPage_Refreshiconlabel.click();
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
	public void clickonAddProductsIcon() {
		wh.waitForElementToBeVisible(ProductsListPage_Addiconlabel, driver, 10);
		clickElementUsingJavaScript(ProductsListPage_Addiconlabel);
		log("Clicked on the Add icon label in the Products list page");
		takeScreenShot();
	}

	/**
	 * Method to click on the edit button in the Tenants list page to Add a new Tenant
	 */

	public void clickonEditProductsIcon() {
		wh.waitForElementToBeVisible(ProductsListPage_Editiconlabel, driver, 10);
		clickElementUsingJavaScript(ProductsListPage_Editiconlabel);
		log("Clicked on the Edit icon label in the Products list page");
		takeScreenShot();
	}


	public void selectTenant(String _TenantName) throws InterruptedException {

		//clickElementUsingJavaScript(TenantDropDown);
		clickElementUsingJavaScript(TenantDropDown);
		WebElement selectTenant = driver.findElement(By.xpath("//ul[@class='k-list k-reset']//li[@class='k-item ng-scope' and text()='"+_TenantName+"']"));
		Thread.sleep(8000);
		clickElementUsingJavaScript(selectTenant);
	}

	public void selectTenantLocale(String _TenantLocale) throws InterruptedException {

		clickElementUsingJavaScript(LocaleDropDown);
		Thread.sleep(5000);
		WebElement selectTenantLocale = driver.findElement(By.xpath("//ul[@class='k-list k-reset']//li[contains(@class,'ng-scope') and text()='"+_TenantLocale+"']"));
		wh.waitForElementToBeVisible(selectTenantLocale, driver, 30);
		clickElementUsingJavaScript(selectTenantLocale);
	}

	public String verifyIconLabels(String _Addlabel, String _Editlabel, String _Deletelabel, String _Activatelabel, String _Deactivatelabel,
			String _Refreshlabel, String _Articleslabel) {
		status="FAIL";

		if(ProductsListPage_Addiconlabel.getText().equals(_Addlabel)) {
			log(ProductsListPage_Addiconlabel.getText()+" icon label displayed in UI");
			if(ProductsListPage_Editiconlabel.getText().equals(_Editlabel)) {
				log(ProductsListPage_Editiconlabel.getText()+" icon label displayed in UI");
				if(ProductsListPage_Deleteiconlabel.getText().equals(_Deletelabel)) {
					log(ProductsListPage_Deleteiconlabel.getText()+" icon label displayed in UI");
					if(ProductsListPage_Activateiconlabel.getText().equals(_Activatelabel)) {
						log(ProductsListPage_Activateiconlabel.getText()+" icon label displayed in UI");
						if(ProductsListPage_Deactivateiconlabel.getText().equals(_Deactivatelabel)) {
							log(ProductsListPage_Deactivateiconlabel.getText()+" icon label displayed in UI");
							if(ProductsListPage_Refreshiconlabel.getText().equals(_Refreshlabel)) {
								log(ProductsListPage_Refreshiconlabel.getText()+" icon label displayed in UI");
								if(ProductsListPage_Articlesiconlabel.getText().equals(_Articleslabel)) {
									log(ProductsListPage_Articlesiconlabel.getText()+" icon label displayed in UI");
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

	public String verifyHeaderAndTableColumns(String _ProductlistPageHeader, String _NameCol, String _DescriptionCol,String _TypeCol,String _StatusCol) {
		status="FAIL";
		log(ProductsListPage_PageHeader.getText()+ " is displayed in UI");
		if(ProductsListPage_PageHeader.getText().equals(_ProductlistPageHeader)) {
			log(ProductsListPage_PageHeader.getText()+ " is displayed in UI");
			if(NameCol.getText().equals(_NameCol)) {
				log(NameCol.getText()+ " column is displayed in UI");
				if(DescriptionCol.getText().equals(_DescriptionCol)) {
					log(DescriptionCol.getText()+ " column is displayed in UI");
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




	public String searchAndSelectProductCreated(String _Name, String _Description, String _Type, String _Status) throws InterruptedException {
		
		String status = "FAIL";

		Thread.sleep(10000);
		List<WebElement> tenantRows = driver.findElements(By.xpath("//table[@class='k-selectable']//tbody//tr"));
		log("No of rows ="+tenantRows.size());
		for(int i=0;i<tenantRows.size();i++) {
			int j=i+1;


			WebElement NameColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[1]"));
			WebElement DescriptionColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[2]"));
			WebElement TypeColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[3]"));
			WebElement StatusColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[4]"));

			if(NameColumnValue.getText().equals(_Name)) {		
				if(DescriptionColumnValue.getText().equals(_Description)) {
					if(TypeColumnValue.getText().equals(_Type)) {
						if(StatusColumnValue.getText().equals(_Status)) {
							driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]")).click();
							log("Product -> "+_Name+" Searched and Selected ");
							status ="PASS";
							return status;
						}
					}
				}
			}
		}
		return status;
	}

	public void clickonDelete() {

		wh.waitForElementToBeClickable(ProductsListPage_Deleteiconlabel, driver, 10);
		ProductsListPage_Deleteiconlabel.click();
		log("Clicked on the Delete icon");
		takeScreenShot();

	}

	public String verifyConfirmDeletePopUpLabelsAndClickX(String _DeleteProduct_ConfirmHeader,String _DeleteProduct_ConfirmationMessge,
			String _DeleteProduct_YesButton,String _DeleteProduct_NoButton) {
		status="FAIL";
		log(" Header Label is displayed -> "+DeleteProductConfirmHeader.getText());
		if(DeleteProductConfirmHeader.getText().equals(_DeleteProduct_ConfirmHeader)){
			log("Message is displayed -> "+DeleteProductConfirmMessage.getText());
			if(DeleteProductConfirmMessage.getText().equals(_DeleteProduct_ConfirmationMessge)) {
				log("Button Label is displayed -> "+DeleteConfirm_YesButton.getText());
				if(DeleteConfirm_YesButton.getText().equals(_DeleteProduct_YesButton)) {
					log("Button Label is displayed -> "+DeleteConfirm_NoButton.getText());
					if(DeleteConfirm_NoButton.getText().equals(_DeleteProduct_NoButton)) {
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

	public String verifyConfirmDeletePopUpLabelsAndClickNo(String _DeleteProduct_ConfirmHeader,String _DeleteProduct_ConfirmationMessge,
			String _DeleteProduct_YesButton,String _DeleteProduct_NoButton) {
		status="FAIL";
		log(" Header Label is displayed -> "+DeleteProductConfirmHeader.getText());
		if(DeleteProductConfirmHeader.getText().equals(_DeleteProduct_ConfirmHeader)){
			log("Message is displayed -> "+DeleteProductConfirmMessage.getText());
			if(DeleteProductConfirmMessage.getText().equals(_DeleteProduct_ConfirmationMessge)) {
				log("Button Label is displayed -> "+DeleteConfirm_YesButton.getText());
				if(DeleteConfirm_YesButton.getText().equals(_DeleteProduct_YesButton)) {
					log("Button Label is displayed -> "+DeleteConfirm_NoButton.getText());
					if(DeleteConfirm_NoButton.getText().equals(_DeleteProduct_NoButton)) {
						takeScreenShot();
						wh.waitForElementToBeClickable(DeleteConfirm_NoButton, driver, 10);
						DeleteConfirm_NoButton.click();
						log("clicked on Delete Confirm No Button");
						status="PASS";

					}
				}
			}
		}
		return status;

	}

	public String verifyConfirmDeletePopUpLabelsAndClickYes(String _DeleteProduct_ConfirmHeader,String _DeleteProduct_ConfirmationMessge,
			String _DeleteProduct_YesButton,String _DeleteProduct_NoButton) {
		status="FAIL";
		log(" Header Label is displayed -> "+DeleteProductConfirmHeader.getText());
		if(DeleteProductConfirmHeader.getText().equals(_DeleteProduct_ConfirmHeader)){
			log("Message is displayed -> "+DeleteProductConfirmMessage.getText());
			if(DeleteProductConfirmMessage.getText().equals(_DeleteProduct_ConfirmationMessge)) {
				log("Button Label is displayed -> "+DeleteConfirm_YesButton.getText());
				if(DeleteConfirm_YesButton.getText().equals(_DeleteProduct_YesButton)) {
					log("Button Label is displayed -> "+DeleteConfirm_NoButton.getText());
					if(DeleteConfirm_NoButton.getText().equals(_DeleteProduct_NoButton)) {
						takeScreenShot();
						wh.waitForElementToBeClickable(DeleteConfirm_YesButton, driver, 10);
						DeleteConfirm_YesButton.click();
						log("clicked on Delete Confirm Yes Button");
						status="PASS";

					}
				}
			}
		}
		return status;

	}

	public void clickonDeactivate() {
		wh.waitForElementToBeVisible(ProductsListPage_Deactivateiconlabel, driver, 10);
		ProductsListPage_Deactivateiconlabel.click();
		log("clicked on the Deactivate icon");
		takeScreenShot();

	}

	public String verifyDeactivateDialogPopupAndClickX(String _ConfirmPopupHeader,String _DeactivateConfirmationMsg,String _YesButtonLabel,String _NoButtonlabel) {
		status="FAIL";
		wh.waitForElementToBeVisible(ConfirmPopUpHeader, driver, 10);
		if(ConfirmPopUpHeader.getText().equals(_ConfirmPopupHeader)) {
			if(DeactivateProductMessage.getText().equals(_DeactivateConfirmationMsg)) {
				if(YesButton.getText().equals(_YesButtonLabel)) {
					if(NoButton.getText().equals(_NoButtonlabel)) {
						status="PASS";
						takeScreenShot();
						XButtontocloseConfirmpopup.click();
						log("Clicked on X to close the pop up");
					}
				}
			}
		}
		return status;

	}


	public String verifyDeactivateDialogPopupAndClickNo(String _ConfirmPopupHeader,String _DeactivateConfirmationMsg,String _YesButtonLabel,String _NoButtonlabel) {
		status="FAIL";
		wh.waitForElementToBeVisible(ConfirmPopUpHeader, driver, 10);
		if(ConfirmPopUpHeader.getText().equals(_ConfirmPopupHeader)) {
			if(DeactivateProductMessage.getText().equals(_DeactivateConfirmationMsg)) {
				if(YesButton.getText().equals(_YesButtonLabel)) {
					if(NoButton.getText().equals(_NoButtonlabel)) {
						status="PASS";
						takeScreenShot();
						NoButton.click();
						log("Clicked on No to close the pop up");
					}
				}
			}
		}
		return status;

	}

	public String verifyDeactivateDialogPopupAndClickYes(String _ConfirmPopupHeader,String _DeactivateConfirmationMsg,String _YesButtonLabel,String _NoButtonlabel) {
		status="FAIL";
		wh.waitForElementToBeVisible(ConfirmPopUpHeader, driver, 10);
		if(ConfirmPopUpHeader.getText().equals(_ConfirmPopupHeader)) {
			if(DeactivateProductMessage.getText().equals(_DeactivateConfirmationMsg)) {
				if(YesButton.getText().equals(_YesButtonLabel)) {
					if(NoButton.getText().equals(_NoButtonlabel)) {
						status="PASS";
						takeScreenShot();
						YesButton.click();
						log("Clicked on Yes to close the pop up and Deactivate");
					}
				}
			}
		}
		return status;

	}

	public void clickonActivate() {
		takeScreenShot();
		ProductsListPage_Activateiconlabel.click();
		log("clicked on Activate");

	}

	public String verifyActivateDialogPopupAndClickX(String _ConfirmPopupHeader,String _ActivateConfirmationMsg,String _YesButtonLabel,String _NoButtonlabel) throws InterruptedException {

		status="FAIL";
		Thread.sleep(5000);
		if(ConfirmPopUpHeader.getText().equals(_ConfirmPopupHeader)) {
			log(ConfirmPopUpHeader.getText()+" is displayed in UI");
			if(ActivateProductMessage.getText().equals(_ActivateConfirmationMsg)) {
				log(ActivateProductMessage.getText()+" is displayed in UI");
				if(YesButton.getText().equals(_YesButtonLabel)) {
					log(YesButton.getText()+" is displayed in UI");
					if(NoButton.getText().equals(_NoButtonlabel)) {
						log(NoButton.getText()+" is displayed in UI");
						status="PASS";
						XButtontocloseConfirmpopup.click();
						log("Click on the X to close the Activate dialog");
						takeScreenShot();
					}
				}
			}
		}
		return status;

	}

	public String verifyActivateDialogPopupAndClickNo(String _ConfirmPopupHeader,String _ActivateConfirmationMsg,String _YesButtonLabel,String _NoButtonlabel) throws InterruptedException {

		status="FAIL";
		Thread.sleep(5000);
		if(ConfirmPopUpHeader.getText().equals(_ConfirmPopupHeader)) {
			log(ConfirmPopUpHeader.getText()+" is displayed in UI");
			if(ActivateProductMessage.getText().equals(_ActivateConfirmationMsg)) {
				log(ActivateProductMessage.getText()+" is displayed in UI");
				if(YesButton.getText().equals(_YesButtonLabel)) {
					log(YesButton.getText()+" is displayed in UI");
					if(NoButton.getText().equals(_NoButtonlabel)) {
						log(NoButton.getText()+" is displayed in UI");
						status="PASS";
						NoButton.click();
						log("Click on the No to close the Activate dialog");
						takeScreenShot();
					}
				}
			}
		}
		return status;

	}

	public String verifyActivateDialogPopupAndClickYes(String _ConfirmPopupHeader,String _ActivateConfirmationMsg,String _YesButtonLabel,String _NoButtonlabel) throws InterruptedException {

		status="FAIL";
		Thread.sleep(5000);
		if(ConfirmPopUpHeader.getText().equals(_ConfirmPopupHeader)) {
			log(ConfirmPopUpHeader.getText()+" is displayed in UI");
			if(ActivateProductMessage.getText().equals(_ActivateConfirmationMsg)) {
				log(ActivateProductMessage.getText()+" is displayed in UI");
				if(YesButton.getText().equals(_YesButtonLabel)) {
					log(YesButton.getText()+" is displayed in UI");
					if(NoButton.getText().equals(_NoButtonlabel)) {
						log(NoButton.getText()+" is displayed in UI");
						status="PASS";
						YesButton.click();
						log("Click on the Yes to Activate product");
						takeScreenShot();
					}
				}
			}
		}
		return status;

	}

}






