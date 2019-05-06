/**
 *
 */
package com.skidata.uiPages.chbackoffice;

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
 * @author sreelakshmi	
 * 
 */
public class NotificationTypeListPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status;


	public static final Logger log = Logger.getLogger(NotificationTypeListPage.class.getName());



	//Class constructor
	public NotificationTypeListPage(WebDriver driver,ExtentTest test) {
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


	@FindBy(xpath = "//span[@class='v-label' and text()='LOADING...']")
	public WebElement loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;

	@FindBy(xpath = "//div[contains(@v-label,'CH.SelectTenant')]/div/div//span/span[@class='k-dropdown-wrap k-state-default']")
	public WebElement TenantDropDown;


	@FindBy(xpath = "//span[@translate='CH.buttonRefresh']")
	public WebElement Refresh_ButtonLabel;
	
	@FindBy(xpath = "//li[@id='ssp_notification_add']")
	public WebElement Add_ButtonLabel;
	
	@FindBy(xpath = "//li[@id='ssp_notification_edit']")
	public WebElement Edit_ButtonLabel;
	
	@FindBy(xpath = "//li[@id='ssp_notification_delete']")
	public WebElement Delete_ButtonLabel;
	
	//-------------------------------------------------------------------------
		@FindBy(xpath = "//span[@translate='SSPNotification.GridColumnHeader-Name']")
		public WebElement NameColumHeaderlabel;
		
		@FindBy(xpath = "//span[@class='v-label ng-scope'][contains(text(),'Domain event')]")
		public WebElement DomainEventColumHeaderlabel;
		
		@FindBy(xpath = "//span[@translate='SSPNotification.GridColumnHeader-configuration']")
		public WebElement ConfigurationColumHeaderlabel;
		
		@FindBy(xpath = "//span[@class='v-label ng-scope'][contains(text(),'Template')]")
		public WebElement TemplateColumHeaderlabel;
	/**
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnRefreshButton() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		Refresh_ButtonLabel.click();
		log("Clicked on Refresh icon");
		takeScreenShot();
		log("Page is refreshed");
		
	}
	
	
	
	public void clickOnAddButton() throws InterruptedException {
		// TODO Auto-generated method stub
				Thread.sleep(3000);
				Add_ButtonLabel.click();
				log("Clicked on add icon");
				takeScreenShot();
	}
	
	/**
	 * Method to select the Tenant from the Drop down.
	 * @param _TenantName
	 * @throws InterruptedException
	 */
	public void selectTenant(String _TenantName) throws InterruptedException {
		//clickElementUsingJavaScript(TenantDropDown);
		clickElementUsingJavaScript(TenantDropDown);
		WebElement selectTenant = driver.findElement(By.xpath("//ul[@class='k-list k-reset']//li[@class='k-item ng-scope' and text()='"+_TenantName+"']"));
		Thread.sleep(3000);
		clickElementUsingJavaScript(selectTenant);
	}

	
	/*8
	 * To validate the icon label available in the notification list
	 */
		public String verifyIconLabelsinNotificationMappingPage(String _AddLabelNotifyConfigurationpage,String _EditlabelNotifyConfigurationpage,String _DeletelabelNotifyConfigurationpage,
				String _RefreshlabelNotifyConfigurationpage) throws InterruptedException {
			status="FAIL";
			
			if(Add_ButtonLabel.getText().equals(_AddLabelNotifyConfigurationpage)){
				log(Add_ButtonLabel.getText()+" label is displayed in the notification type mapping page");
				if(Edit_ButtonLabel.getText().equals(_EditlabelNotifyConfigurationpage)) {
					log(Edit_ButtonLabel.getText()+" label is displayed in the notification type mapping  page");
					if(Delete_ButtonLabel.getText().equals(_DeletelabelNotifyConfigurationpage)) {
						log(Delete_ButtonLabel.getText()+" label is displayed in the notification type mapping  page");
						if(Refresh_ButtonLabel.getText().equals(_RefreshlabelNotifyConfigurationpage)) {
							log(Refresh_ButtonLabel.getText()+" label is displayed in the notification type mapping  page");
								Thread.sleep(3000);
								takeScreenShot();
								status="PASS";
						}
					}
				}
			}
			return status;
		
		}
		
		public String verifyApplicationHeaderAndTableLabels(String _NameColHeader,String _DomainEventColHeader,String _ConfigurationColHeader,
				String _TemplateColHeader) {
		
			status="FAIL";
				log("NameColumHeaderlabel is displayed as " +NameColumHeaderlabel.getText());
				if(NameColumHeaderlabel.getText().equals(_NameColHeader)) {
					log("DomainEventColumHeaderlabel is displayed as " +DomainEventColumHeaderlabel.getText());
					if(DomainEventColumHeaderlabel.getText().equals(_DomainEventColHeader)) {
						log("ConfigurationColumHeaderlabel is displayed as " +ConfigurationColumHeaderlabel.getText());
						if(ConfigurationColumHeaderlabel.getText().equals(_ConfigurationColHeader)) {
							log("TemplateColumHeaderlabel is displayed as " +TemplateColumHeaderlabel.getText());
							if(TemplateColumHeaderlabel.getText().equals(_TemplateColHeader)) {
									status="PASS";
									takeScreenShot();
							}
						}
					}
				}
			return status;
			
		}
	
//		public String verifyAddEditHeaderLabels(String _AddHeader,String _EditHeader,String _ConfigurationColHeader,
//				String _TemplateColHeader) {
//		
//			status="FAIL";
//				log("NameColumHeaderlabel is displayed as " +NameColumHeaderlabel.getText());
//				if(NameColumHeaderlabel.getText().equals(_NameColHeader)) {
//					log("DomainEventColumHeaderlabel is displayed as " +DomainEventColumHeaderlabel.getText());
//					if(DomainEventColumHeaderlabel.getText().equals(_DomainEventColHeader)) {
//						log("ConfigurationColumHeaderlabel is displayed as " +ConfigurationColumHeaderlabel.getText());
//						if(ConfigurationColumHeaderlabel.getText().equals(_ConfigurationColHeader)) {
//							log("TemplateColumHeaderlabel is displayed as " +TemplateColumHeaderlabel.getText());
//							if(TemplateColumHeaderlabel.getText().equals(_TemplateColHeader)) {
//									status="PASS";
//									takeScreenShot();
//							}
//						}
//					}
//				}
//			return status;
//			
//		}
	

}