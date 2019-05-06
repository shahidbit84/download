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
 * @author sreelakshmi	
 * 
 */
public class NotificationConfigurationListPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status;


	public static final Logger log = Logger.getLogger(NotificationConfigurationListPage.class.getName());



	//Class constructor
	public NotificationConfigurationListPage(WebDriver driver,ExtentTest test) {
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

	@FindBy(xpath = "//li[@id='ssp_emailconfig_refresh']")
	public WebElement Refresh_ButtonLabel;

	@FindBy(xpath = "//li[@id='ssp_emailconfig_add']")
	public WebElement Add_ButtonLabel;

	@FindBy(xpath = "//li[@id='ssp_emailconfig_edit']")
	public WebElement Edit_ButtonLabel;

	@FindBy(xpath = "//li[@id='ssp_emailconfig_delete']")
	public WebElement Delete_ButtonLabel;

	@FindBy(xpath = "//li[@id='ssp_emailconfig_activate']")
	public WebElement Activate_ButtonLabel;

	@FindBy(xpath = "//li[@id='ssp_emailconfig_deactivate']")
	public WebElement Deactivate_ButtonLabel;

	//-------------------------------------------------------------------------

	@FindBy(xpath = "//span[@translate='SSPEmailConfig.GridColumnHeader-Name']")
	public WebElement NameColumHeaderlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope'][contains(text(),'Type')]")
	public WebElement TypeColumHeaderlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope'][contains(text(),'Visibility')]")
	public WebElement VisibilityColumHeaderlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope'][contains(text(),'System/user')]")
	public WebElement SystemColumHeaderlabel;

	@FindBy(xpath = "//span[@class='v-label ng-scope'][contains(text(),'Status')]")
	public WebElement StatusColumHeaderlabel;

	@FindBy(xpath = ".//*[@id='ssp-configurationMenu']")
	public WebElement ConfigurationApp;

	@FindBy(xpath = "//button[text()='Notification type mapping']")
	public WebElement NotificationTypeMapping;

	@FindBy(xpath = ".//*[@id='ssp_notification_add']")
	public WebElement AddButtonInNotification;

	@FindBy(xpath = "//span[@translate='SSPNotification.NotificationForm-Name' and text()='Name']/../..//input")
	public WebElement AddNotificationName;

	@FindBy(xpath = "//span[text()='Domain event']/../..//span[text()='--- Select ---']")
	public WebElement DomainEventDropdown;

	@FindBy(xpath = "//span[text()='Configuration']/../..//span[text()='--- Select ---']")
	public WebElement ConfigurationDropdown;

	@FindBy(xpath = "//span[text()='Template']/../..//span[text()='--- Select ---']")
	public WebElement TemplateDropdown;

	@FindBy(xpath = "//*[@id='ssp_notification_add_save']/label/span[1]")
	public WebElement AddNotificationSaveButton;

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
	public String verifyIconLabelsinNotificationConfigurationPage(String _AddLabelNotifyConfigurationpage,String _EditlabelNotifyConfigurationpage,String _DeleteabelNotifyConfigurationpage,
			String _RefreshlabelNotifyConfigurationpage,String _ActivateLabelNotifyConfigurationPage, String _DeactivateNotifyConfigurationPage) throws InterruptedException {
		status="FAIL";

		if(Add_ButtonLabel.getText().equals(_AddLabelNotifyConfigurationpage)){
			log(Add_ButtonLabel.getText()+" label is displayed in the notification type mapping page");
			if(Edit_ButtonLabel.getText().equals(_EditlabelNotifyConfigurationpage)) {
				log(Edit_ButtonLabel.getText()+" label is displayed in the notification type mapping  page");
				if(Delete_ButtonLabel.getText().equals(_DeleteabelNotifyConfigurationpage)) {
					log(Delete_ButtonLabel.getText()+" label is displayed in the notification type mapping  page");
					if(Refresh_ButtonLabel.getText().equals(_RefreshlabelNotifyConfigurationpage)) {
						log(Refresh_ButtonLabel.getText()+" label is displayed in the notification type mapping  page");
						if(Activate_ButtonLabel.getText().equals(_ActivateLabelNotifyConfigurationPage)) {
							log(Activate_ButtonLabel.getText()+" label is displayed in the notification type mapping  page");
							if(Deactivate_ButtonLabel.getText().equals(_DeactivateNotifyConfigurationPage)) {
								log(Deactivate_ButtonLabel.getText()+" label is displayed in the notification type mapping  page");
								Thread.sleep(3000);
								takeScreenShot();
								status="PASS";
							}
						}
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
			log("TypeColumHeaderlabel is displayed as " +TypeColumHeaderlabel.getText());
			if(VisibilityColumHeaderlabel.getText().equals(_DomainEventColHeader)) {
				log("VisibilityColumHeaderlabel is displayed as " +VisibilityColumHeaderlabel.getText());
				if(SystemColumHeaderlabel.getText().equals(_ConfigurationColHeader)) {
					log("SystemColumHeaderlabel is displayed as " +SystemColumHeaderlabel.getText());
					if(StatusColumHeaderlabel.getText().equals(_TemplateColHeader)) {
						log("StatusColumHeaderlabel is displayed as " +StatusColumHeaderlabel.getText());
						status="PASS";
						takeScreenShot();
					}
				}
			}
		}
		return status;

	}

	/**
	 * Method to configure the email notifications .
	 * @param _Name,_DomainEvents,_configuration,_Template
	 * @throws InterruptedException
	 */
	public String configureEmailNotifications(String _Name,String _DomainEvents,String _configuration,String _Template) throws InterruptedException {

		Thread.sleep(3000);
		String ConfigurationNames = _Name;
		String[] ConfigNames = ConfigurationNames.split(",");
		int ConfigNamesCount = ConfigNames.length;
		System.out.println("The number of items is: " + ConfigNamesCount);

		String ConfigureDomainEvents = _DomainEvents;
		String[] ConfigDomainEvents = ConfigureDomainEvents.split(",");
		int ConfigDomainCount = ConfigDomainEvents.length;
		System.out.println("The number of items is: " + ConfigDomainCount);

		String ConfigureTemplates = _Template;
		String[] ConfigTemplates = ConfigureTemplates.split(",");
		int ConfigTemplateCount = ConfigTemplates.length;
		System.out.println("The number of items is: " + ConfigTemplateCount);

		System.out.println(_configuration);

		for(int i=0; i<ConfigNamesCount; i++){
			String Name=ConfigNames[i];
			System.out.println(Name);

			String domainEvent=ConfigDomainEvents[i];
			System.out.println(domainEvent);

			String templatevalue=ConfigTemplates[i];
			System.out.println(templatevalue);

			//NotificationTypeMapping.click();
			Thread.sleep(2000);
			waitForElementToBeClickable(driver, 3000, AddButtonInNotification);

			//click on add button
			AddButtonInNotification.click();
			log("clicked on notification type mapping Add button");
			waitForElementToBeClickable(driver, 3000, AddNotificationName); 

			//enter the add notification name
			AddNotificationName.sendKeys(Name);
			log("Entered Notification name which is -->" +Name );


			//select Domain event 
			waitForElementToBeClickable(driver, 3000, DomainEventDropdown);
			DomainEventDropdown.click();


			@SuppressWarnings("unused")
			WebElement Domainevent=driver.findElement(By.xpath("//*[@id='notification_add_page_event_list_listbox']/li[contains(text(),'"+domainEvent+"')]"));

			//select the domain event in the drop down;
			List<WebElement> Domaineventname = driver.findElements(By.xpath("//*[@id='notification_add_page_event_list_listbox']/li[contains(text(),'"+domainEvent+"')]"));
			System.out.println(Domaineventname.size());
			System.out.println(Domaineventname.size() - 1);
			System.out.println(Domaineventname.get(Domaineventname.size() - 1));
			log("Need to select Domain event which is  -->" +domainEvent );

			//waitForTextAppear(driver,3000,domainEvent,Domainevent);
			Thread.sleep(1000);
			Domaineventname.get(Domaineventname.size() - 1).click();
			log("Selected domain event which is  -->" +domainEvent );

			System.out.println(Domaineventname.get(Domaineventname.size() - 1).getText());
			Thread.sleep(1000);

			//select configuration
			waitForElementToBeClickable(driver, 3000, ConfigurationDropdown);
			ConfigurationDropdown.click();

			@SuppressWarnings("unused")
			WebElement Configuration=driver.findElement(By.xpath("//*[@id='notification_add_page_account_list_listbox']/li[contains(text(),'"+_configuration+"')]"));
			List<WebElement> ConfigurationValue=driver.findElements(By.xpath("//*[@id='notification_add_page_account_list_listbox']/li[contains(text(),'"+_configuration+"')]"));
			log("Need to select Configuration event which is  -->" +_configuration );

			
			Thread.sleep(1000);
			ConfigurationValue.get(ConfigurationValue.size() - 1).click();
			log("Selected Configuration which is  -->" +_configuration );
			Thread.sleep(1000);

			//select Templates 
			waitForElementToBeClickable(driver, 3000, TemplateDropdown);
			TemplateDropdown.click();
			Thread.sleep(1000);

			if(templatevalue.contentEquals("INVOICE_GENERATED")){
				log("Need to select template which is  -->" +templatevalue);
				driver.findElement(By.xpath(".//*[@id='notification_add_page_template_list_listbox']/li[contains(text(),'"+templatevalue+"')][1]")).click();
				log("Selected template which is  -->" +templatevalue );
			}
			else{
				List<WebElement> template=driver.findElements(By.xpath(".//*[@id='notification_add_page_template_list_listbox']/li[contains(text(),'"+templatevalue+"')]"));
				log("Need to select template which is  -->" +templatevalue);
				template.get(template.size() - 1).click();
				log("Selected template which is  -->" +templatevalue );
				Thread.sleep(2000);
			}

			AddNotificationSaveButton.click();
			log("Saved the e-mail configuration done for the domain event -->" +domainEvent);

			waitForElementToBeClickable(driver, 3000, AddButtonInNotification);
		}
		return status = "PASS";

	}


}


