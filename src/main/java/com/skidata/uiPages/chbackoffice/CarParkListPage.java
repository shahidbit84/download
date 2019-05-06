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
 * The repository for swebWalletTenants App Main Page
 */
public class CarParkListPage extends TestBase {
	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
    


	public static final Logger log = Logger.getLogger(CarParkListPage.class.getName());
	String status;


	public CarParkListPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

	}

	//**************************************************************************************************

	@FindBy(xpath = "//span[@class='v-label' and translate='VSMCommon.ProgressLoading']")
	public WebElement loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;

	@FindBy(xpath = "//div[contains(@v-label,'CH.SelectTenant')]/div/div//span/span[@class='k-dropdown-wrap k-state-default']")
	public WebElement TenantDropDown;
	
	@FindBy(xpath = "//li[@id='ssp_carpark_add']")
	public WebElement CarParkListPage_Addiconlabel;
	
	@FindBy(xpath = "//li[@id='ssp_carpark_edit']")
	public WebElement CarParkListPage_Editiconlabel;
	
	
	@FindBy(xpath = "//div[@class='k-window-titlebar k-header']//span[@class='k-window-title']")
	public WebElement ConfirmPopUpHeader;


	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonYes']")
	public WebElement YesButton;
	
	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonNo']")
	public WebElement NoButton;

	@FindBy(xpath = "//span[@class='k-icon k-i-close' and text()='Close']")
	public WebElement XButtontocloseConfirmpopup;
	
	

	@FindBy(xpath = "//span[@class='k-window-title' and text()='Confirm']")
	public WebElement ConfirmDeleteDialoglabel;
	
	
	@FindBy(xpath = "//p[@class='ng-scope' and @translate='SSPUnits.UnitsForm-ConfirmDeleteUnits']")
	public WebElement deleteconfirmationMessage;
	
	
	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonYes']")
	public WebElement YesButtoninDeleteConfirmation;
	
	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonNo']")
	public WebElement NoButtoninDeleteConfirmation;
	
	
	@FindBy(xpath = "//span[@class='k-icon k-i-close']")
	public WebElement closeXiconinDeleteConfirmationPopup;
	
	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='CH.ButtonConfirmDelete']")
	public WebElement carparkListPage_Deleteiconlabel;
	
	@FindBy(xpath = "//li[@id='ssp_carpark_add']")
	public WebElement Add_ButtonLabel;
	
	@FindBy(xpath = "//li[@id='ssp_carpark_edit']")
	public WebElement Edit_ButtonLabel;
	
	
	@FindBy(xpath = "//li[@id='ssp_carpark_refresh']")
	public WebElement Refresh_ButtonLabel;
	
	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPCarPark.GridColumnHeader-Name']")
	public WebElement NameColumHeaderlabel;
	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPCarPark.GridColumnHeader-Bays']")
	public WebElement BaysColumHeaderlabel;
	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPCarPark.GridColumnHeader-Facility']")
	public WebElement FacilityColumHeaderlabel;
	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPUnits.GridColumnHeader-address']")
	public WebElement LatitudeColumHeaderlabel;
	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPCarPark.GridColumnHeader-Longitude']")
	public WebElement LongitudeColumHeaderlabel;
	
	
	
	public void waitforInvisibilityOfLoading() {
		waitForElementInVisiblity(driver, 10, loadingprogress);
		log("loading progress completed");
	}

	/**
	 * Method to click on the Add button in the Tenants list page to Add a new car Park
	 */
	public void clickonAddCarParkIcon() {
	
		wh.waitForElementToBeClickable(CarParkListPage_Addiconlabel, driver, 10);
		clickElementUsingJavaScript(CarParkListPage_Addiconlabel);
		log("Clicked on the Add icon label in the car park list page");
		takeScreenShot();
	}
	/**
	 * Method to click on the Add button in the Tenants list page to Add a new Tenant
	 */
	public void clickonEditCarParkIcon() {
	
		wh.waitForElementToBeClickable(CarParkListPage_Editiconlabel, driver, 10);
		clickElementUsingJavaScript(CarParkListPage_Editiconlabel);
		log("Clicked on the edit icon label in the car park list page");
		takeScreenShot();
	}
	
	// sreelakshmi 31-1-2018
		public String verifyIconLabelsinCarParkPage(String _AddLabelCarParkpage,String _EditlabelCarParkpage,String _RefreshlabelCarParkpage,
				String _DeleteCarParkPage) throws InterruptedException {
			status="FAIL";
			
			if(Add_ButtonLabel.getText().equals(_AddLabelCarParkpage)){
				log(Add_ButtonLabel.getText()+" label is displayed in the Car park page page");
				if(Edit_ButtonLabel.getText().equals(_EditlabelCarParkpage)) {
					log(Edit_ButtonLabel.getText()+" label is displayed in the Car park page");
							if(Refresh_ButtonLabel.getText().equals(_RefreshlabelCarParkpage)) {
								log(Refresh_ButtonLabel.getText()+" label is displayed in the car park page");
								if(carparkListPage_Deleteiconlabel.getText().equals(_DeleteCarParkPage)) {
									log(carparkListPage_Deleteiconlabel.getText()+" label is displayed in the car park page");
										Thread.sleep(3000);
										takeScreenShot();
										status="PASS";
							}		
					}
				}
			}
			return status;
		
		}
		
		public String verifyApplicationHeaderAndTableLabels(String _NameColHeader,String _BaysColHeader,String _FacilityColHeader,
				String _latitudeColHeader,String _LongitudeColHeader) {
		
			status="FAIL";
//			log("tenantsListPage_applicationHeader is displayed as " +UnitsListPage_applicationHeader.getText());
		
				log("NameColumHeaderlabel is displayed as " +NameColumHeaderlabel.getText());
				if(NameColumHeaderlabel.getText().equals(_NameColHeader)) {
					log("BaysColumHeaderlabel is displayed as " +BaysColumHeaderlabel.getText());
					if(BaysColumHeaderlabel.getText().equals(_BaysColHeader)) {
						log("FacilityColumHeaderlabel is displayed as " +FacilityColumHeaderlabel.getText());
						if(FacilityColumHeaderlabel.getText().equals(_FacilityColHeader)) {
							log("latitudeColumHeaderlabel is displayed as " +LatitudeColumHeaderlabel.getText());
							if(LatitudeColumHeaderlabel.getText().equals(_latitudeColHeader)) {
								log("LongitudeColumHeaderlabel is displayed as " +LongitudeColumHeaderlabel.getText());
								if(LongitudeColumHeaderlabel.getText().equals(_LongitudeColHeader)) {							
									status="PASS";
									takeScreenShot();
								}
							}
						}
					}
				}
			return status;
			
		}
	
	public void selectTenant(String _TenantName) throws InterruptedException {
		//clickElementUsingJavaScript(TenantDropDown);
		clickElementUsingJavaScript(TenantDropDown);
		WebElement selectTenant = driver.findElement(By.xpath("//ul[@class='k-list k-reset']//li[@class='k-item ng-scope' and text()='"+_TenantName+"']"));
		Thread.sleep(3000);
		clickElementUsingJavaScript(selectTenant);
	}
	
	
	public String searchAndSelectCarParkCreated(String _CreatedCarParkName, String _CreatedCarParkBays,String _CreatedCarParkLatitude,String _CreatedCarParkLongitude) throws InterruptedException {
		status = "FAIL";
		Thread.sleep(8000);

		List<WebElement> carParkRows = driver.findElements(By.xpath("//table[@class='k-selectable']/tbody/tr"));
		log("No of rows found for car park list is "+carParkRows.size());
		for(int i=0;i<carParkRows.size();i++) {
			int j=i+1;
			WebElement NameColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[1]"));
			WebElement BaysColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[2]"));
			WebElement latitude = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[3]"));
			WebElement longitude = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[4]"));

			if(NameColumnValue.getText().equals(_CreatedCarParkName)) {		
				if(BaysColumnValue.getText().equals(_CreatedCarParkBays)) {
					log(NameColumnValue.getText()+" "+BaysColumnValue.getText()+" "+latitude.getText()+" "+longitude.getText()+" -> is displayed in the Table");
					
						driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]")).click();
						log("car park is -> "+_CreatedCarParkName+" is Searched and Selected ");
						status ="PASS";
						return status;
				
				}
			}

		}
		
		return status;

	}
	

public void clickonDelete() {
	wh.waitForElementToBeClickable(carparkListPage_Deleteiconlabel, driver, 10);
	clickElementUsingJavaScript(carparkListPage_Deleteiconlabel);
	log("Clicked on the Delete icon ");
	takeScreenShot();
	
}

public String verifyConfirmDeletePopUpLabelsAndClickX(String _DeleteCarParkConfirmMsg,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
	status="FAIL";
	log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
	if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
		log("Message is displayed -> "+deleteconfirmationMessage.getText());
		if(deleteconfirmationMessage.getText().equals(_DeleteCarParkConfirmMsg)) {
			log("Button Label is displayed -> "+YesButtoninDeleteConfirmation.getText());
			if(YesButtoninDeleteConfirmation.getText().equals(_yesbuttonText)) {
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

public String verifyConfirmDeletePopUpLabelsAndClickNo(String _UnitName,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
	status="FAIL";
	log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
	if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
		log("Message is displayed -> "+deleteconfirmationMessage.getText());
		if(deleteconfirmationMessage.getText().equals("Do you want to delete unit '"+_UnitName+"'?")) {
			log("Button Label is displayed -> "+YesButtoninDeleteConfirmation.getText());
			if(YesButtoninDeleteConfirmation.getText().equals(_yesbuttonText)) {
				log("Button Label is displayed -> "+NoButtoninDeleteConfirmation.getText());
				if(NoButtoninDeleteConfirmation.getText().equals(_NobuttonText)) {
					takeScreenShot();
					wh.waitForElementToBeClickable(NoButtoninDeleteConfirmation, driver, 10);
					NoButtoninDeleteConfirmation.click();
					log("clicked on X icon");
					status="PASS";
					
				}
			}
		}
	}
	return status;

}

public String verifyConfirmDeletePopUpLabelsAndClickYes(String _UnitName,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
	status="FAIL";
	log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
	if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
		log("Message is displayed -> "+deleteconfirmationMessage.getText());
		if(deleteconfirmationMessage.getText().equals("Do you want to delete unit '"+_UnitName+"'?")) {
			log("Button Label is displayed -> "+YesButtoninDeleteConfirmation.getText());
			if(YesButtoninDeleteConfirmation.getText().equals(_yesbuttonText)) {
				log("Button Label is displayed -> "+NoButtoninDeleteConfirmation.getText());
				if(NoButtoninDeleteConfirmation.getText().equals(_NobuttonText)) {
					takeScreenShot();
					wh.waitForElementToBeClickable(YesButtoninDeleteConfirmation, driver, 10);
					YesButtoninDeleteConfirmation.click();
					log("clicked on yes icon");
					status="PASS";
					
				}
			}
		}
	}
	return status;

}


public String clickYesDeleteConfirmation(String _UnitName) throws InterruptedException {
	status="FAIL";
					takeScreenShot();
					if(deleteconfirmationMessage.getText().equals("Do you want to delete unit '"+_UnitName+"'?")) {
					wh.waitForElementToBeClickable(YesButtoninDeleteConfirmation, driver, 10);
					YesButtoninDeleteConfirmation.click();
					log("clicked on yes icon");
					status="PASS";
					}
					return status;


}
	
	

}




