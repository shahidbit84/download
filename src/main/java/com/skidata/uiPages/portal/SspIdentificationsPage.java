/**
 *
 */
package com.skidata.uiPages.portal;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.helperclasses.WaitHelper;
import com.skidata.testBase.TestBase;

/**
 * @author shmo
 * 
 */
public class SspIdentificationsPage extends TestBase {


	
	String status=null;


	public static final Logger log = Logger.getLogger(SspIdentificationsPage.class.getName());



	//Class constructor
	public SspIdentificationsPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

	}


	/**
	 ******************************************************************************************************
	 * Web Elements of PortalMainPage
	 ******************************************************************************************************
	 */

	@FindBy(xpath = "//span[@class='v-label' and text()='LOADING...']")
	public WebElement loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;

	@FindBys({	
		@FindBy(how=How.ID, using="logo"),
	})	public List<WebElement> allElementsInList_LogoImage;

	@FindBy(how=How.XPATH,using ="//a[@id='goToHome1']/div")
	WebElement label_HomeIcon;

	@FindBy(how=How.XPATH,using ="//a[@id='goToCart1']/div")
	WebElement label_CartIcon;

	


	/**
	 *****************************************************************************************************************
	 * Method to verify the Page Title
	 * @param _PageTitle
	 * @return
	 *****************************************************************************************************************
	 */
	public String verifyPageTitle(String _PageTitle) {
		status="FAIL";
		
		if(driver.getTitle().equals(_PageTitle)) {
			log("Title of the page is "+driver.getTitle());
			status="PASS";
			takeScreenShot();
		}
		return status;
	}


	@FindBy(how=How.XPATH,using ="//h2[@data-i18n='_Identifications_']")
	WebElement pageHeaderIdentification;
	
	@FindBy(how=How.XPATH,using ="//div[@translate='_AddIdentification_']")
	WebElement link_AddIdentification;
	public String verifyPageHeaderAndLabel(String _PageHeader,String _AddIdentifications) {
		
		status="FAIL";
		
		if(pageHeaderIdentification.getText().equals(_PageHeader)) {
			log(pageHeaderIdentification.getText()+" is displayed");
			if(link_AddIdentification.getText().equals(_AddIdentifications)) {
				log(link_AddIdentification.getText()+" is displayed");
				takeScreenShot();
				status="PASS";
			}
			
			
		}
		return status;
		
	}
	
	///
	
	@FindBy(how=How.XPATH,using ="//h2[@class='ng-scope' and @ translate='_Identifications_']")
	WebElement pageHeader_Identification;
	
	@FindBy(how=How.XPATH,using ="//div[@translate='_AddIdentification_']")
	WebElement link_Add_Identification;
	
	public String verifyPage_HeaderAndLabel(String _PageHeader,String _PageHeader2) throws InterruptedException {
		status="FAIL";
		Thread.sleep(2000);
		
		WebElement loader = driver.findElement(By.xpath("//div[@class='loader']"));
		
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeInvisible(loader, driver, 30);
		
		if(pageHeader_Identification.getText().equals(_PageHeader)) {
			log(pageHeader_Identification.getText()+" is displayed");
			if(link_Add_Identification.getText().equals(_PageHeader2)) 
				log(link_Add_Identification.getText()+" is displayed");
			
				takeScreenShot();
				status="PASS";
			}	
		
		return status;
	}
	
	///
	
	public void clickOnAddIdentification() {
		
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(link_Add_Identification, driver, 15);
		clickElementUsingJavaScript(link_Add_Identification);
		log("Clicked on the Add Identification");
		takeScreenShot();
	}


	@FindBy(how=How.XPATH,using ="//md-select[@ng-model='IdentificationsCtrl.identification']")
	WebElement dropDown_Identifications;

	@FindBy(how=How.XPATH,using ="//input[@id='idnTxtField']")
	WebElement input_IdentificationValue;
	
	public void addIdentificationDetails(String _Identificationtype,String _IdentificationValue) throws InterruptedException {
		dropDown_Identifications.click();
		log("clicked on the Identifications dropDown");
		takeScreenShot();
		Thread.sleep(5000);	
		driver.findElement(By.xpath("//md-option[contains(@id,'select_option')]//div[contains(text(),'"+_Identificationtype+"')]")).click();
		Thread.sleep(4000);
		input_IdentificationValue.sendKeys(_IdentificationValue);
		log("all details entered successfully in Identification fields");
		takeScreenShot();
	}
	
	
	@FindBy(how=How.XPATH,using ="//input[@id='idnCarType' and @name='idnCarType']")
	WebElement Identification_Car_Type;
	
	public void addIdentificationDetails_LicencePlate(String _Identificationtype,String _IdentificationValue,String _CarType) throws InterruptedException {
		dropDown_Identifications.click();
		log("clicked on the Identifications dropDown");
		takeScreenShot();
		Thread.sleep(5000);	
		driver.findElement(By.xpath("//md-option[contains(@id,'select_option')]//div[contains(text(),'"+_Identificationtype+"')]")).click();
		Thread.sleep(3000);
		Identification_Car_Type.sendKeys(_CarType);
		input_IdentificationValue.sendKeys(_IdentificationValue);
		log("all details entered successfully in Identification fields");
		takeScreenShot();
	}
	

	@FindBy(how=How.XPATH,using ="//input[@id='idnTxtEdit0']")
	WebElement editID;
	
	public void editIdentificationDetails(String _IdentificationValue) throws InterruptedException {
        WebElement loader = driver.findElement(By.xpath("//div[@class='loader']"));
		
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeInvisible(loader, driver, 30);
		
		editID.clear();
		editID.sendKeys(_IdentificationValue);
		takeScreenShot();
	}
	
	


	@FindBy(how=How.XPATH,using ="//button[@type='submit']")
	WebElement button_add;
	
	public void clickOnAdd() {
		button_add.click();
		log("Click on Add button");
		
	}

	@FindBy(how=How.XPATH,using ="//*[@id='add0']/div[2]//span[@data-ng-bind='item.identificationType.name']")
	WebElement identificationType_Name;
	
	@FindBy(how=How.XPATH,using ="//*[@id='add0']/div[2]//span[@data-ng-bind='item.type']")
	WebElement identificationType_Type;
	
	@FindBy(how=How.XPATH,using ="//*[@id='add0']/div[2]//span[@data-ng-bind='item.value']")
	WebElement identificationType_value;
	
	public String verifyAddedVerificationDetails(String _Identificationtype, String _IdentificationValue) {
		status="FAIL";
		
		if(identificationType_Name.getText().equals(_Identificationtype)) {
			log(identificationType_Name.getText()+" is displayed in UI");
			if(identificationType_value.getText().equals(_IdentificationValue)) {
				log(identificationType_value.getText()+" is displayed in UI");
				status="PASS";
				takeScreenShot();
			}
		}
		return status;
		
	}
	
	////
	@FindBy(how=How.XPATH,using =".//*[@id='add0']/div[1]/div/div[2]/div/div")
	WebElement _identificationType_Name;
	
	@FindBy(how=How.XPATH,using =".//*[@id='add0']/div[1]/div/div[2]/div/span")
	WebElement _identificationType_value;
	
	public String _verifyAddedVerificationDetails(String _Identificationtype_, String _IdentificationValue_) throws InterruptedException {
		status="FAIL";
		
WebElement loader = driver.findElement(By.xpath("//div[@class='loader']"));
		
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeInvisible(loader, driver, 30);
	if(_identificationType_Name.getText().equals(_Identificationtype_)) {
		log(_identificationType_Name.getText()+" is displayed in UI");
		if(_identificationType_value.getText().equals(_IdentificationValue_)) {
			log(_identificationType_value.getText()+" is displayed in UI");
			status="PASS";
			takeScreenShot();
		}
	}
	return status;
	
}
	
	
	
	
	////

	@FindBy(how=How.XPATH,using ="//span[@class='ssp-icon_pen_edit']")
	WebElement editIdentificationIcon;
	
	public void clickOnEditIdentifications() {
		

		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(editIdentificationIcon, driver, 30);
	
		clickElementUsingJavaScript(editIdentificationIcon);
		log("Clicked on the Edit Identification Icon");
		takeScreenShot();
		
	}

	@FindBy(how=How.XPATH,using ="//span[@translate='_Update_']")
	WebElement updateButton;
	
	public void clickOnUpdatebutton() throws InterruptedException {
        WebElement loader = driver.findElement(By.xpath("//div[@class='loader']"));
		
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeInvisible(loader, driver, 30);
		clickElementUsingJavaScript(updateButton);
	
		Thread.sleep(3000);
		log("Clicked on the Update button");
		
	}

	@FindBy(how=How.XPATH,using ="//span[@class='ssp-icon_trash']")
	WebElement deleteIdentificationIcon;
	public void clickOnDeleteIcon() throws InterruptedException {
    
		
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(deleteIdentificationIcon, driver, 30);
	
		clickElementUsingJavaScript(deleteIdentificationIcon);
		log("Clicked on the delete icon ");
		takeScreenShot();
		
		
	}

	@FindBy(how=How.XPATH,using ="//div[@class='modal-content']//h1")
	WebElement deleteConfirmationMessage;
	public String verifyDeleteConfirmationMessage(String _ConfirmationMessage) {
		status="FAIL";
		if(deleteConfirmationMessage.getText().equals(_ConfirmationMessage)) {
			log(deleteConfirmationMessage.getText()+" is displayed in UI");
			status="PASS";
			takeScreenShot();
		}
		return status;
	}

	@FindBy(how=How.XPATH,using ="//button[@id='btnCancel']")
	WebElement NoButton;
	public void clickOnNoDeleteConfirmationPopUp() throws InterruptedException {
		Thread.sleep(2000);
	
		NoButton.click();
		log("Clicked on the No button");
		takeScreenShot();
		
	}
	
	@FindBy(how=How.XPATH,using ="//button[@id='btnOk']")
	WebElement YesButton;
	public void clickOnYesDeleteConfirmationPopUp() throws InterruptedException {
		Thread.sleep(2000);
	
		YesButton.click();
		log("Clicked on the Yes button");
		takeScreenShot();
		
	}


	public String verifyIdentificationsDeleted() throws InterruptedException {
	status="FAIL";
	Thread.sleep(3000);
		List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@id,'add')]"));
		if(rows.size()==0) {
			status="PASS";
			log("No identifications rows are found");
			takeScreenShot();
		}
		return status;
	}
	



	
}