/**
 *
 */
package com.skidata.uiPages.portal;

import java.awt.AWTException;
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
import com.skidata.helperclasses.MouseKeyboardHelper;
import com.skidata.helperclasses.WaitHelper;
import com.skidata.testBase.TestBase;

/**
 * @author shmo
 * 
 */
public class SspMyParkersPage extends TestBase {



	String status=null;


	public static final Logger log = Logger.getLogger(SspMyParkersPage.class.getName());



	//Class constructor
	public SspMyParkersPage(WebDriver driver,ExtentTest test) {
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


	


	public void clickonHomeIcon() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(label_HomeIcon, driver, 20);
		label_HomeIcon.click();
		log("Clicked on the Home Icon");
	}

	
	@FindBy(how=How.XPATH,using ="//h1[@data-i18n='_MyParkers_']")
	WebElement header_MyParkers;
	
	@FindBy(how=How.XPATH,using ="//div[@class='emptyMsg ng-scope']")
	WebElement label_emptyPakerMessage;
	
	
	
	public String verifyLabelsInMyParkers(String _HeaderMyParkers,String _EmptyParkerMessage) {
		status="FAIL";
		
		 log(header_MyParkers.getText()+" is displayed");
		log(label_emptyPakerMessage.getText()+" is displayed");
		
		if(header_MyParkers.getText().equals(_HeaderMyParkers)) {
		   log(header_MyParkers.getText()+" is displayed");
			if(label_emptyPakerMessage.getText().equals(_EmptyParkerMessage)) {
				log(label_emptyPakerMessage.getText()+" is displayed");
				
						status="PASS";
						takeScreenShot();
						
					}
				}
		
		return status;
		
		
	}
	
	////
	
	/*My parker lables and link*/
	
	@FindBy(how=How.XPATH,using ="//h4[@class='ng-scope' and @translate='_AssignedToDrivers_']")
	WebElement pageHeader_Myparkers;
	
	@FindBy(how=How.XPATH,using ="//div[@translate='_AddDriver_']")
	WebElement link_Add_Parker;
	
	@FindBy(how=How.XPATH,using ="//p[@class='ng-scope' and @translate='_DriverInfo_']")
	WebElement pageHeader_text_message_Myparkers;
	
	public String verifyPage_HeaderAndLabel(String _PageHeader,String _PageHeader2,String _PageHeader3) throws InterruptedException {
		status="FAIL";
		Thread.sleep(1000);
		if(pageHeader_Myparkers.getText().equals(_PageHeader)) {
			log(pageHeader_Myparkers.getText()+" is displayed");
			if(link_Add_Parker.getText().equals(_PageHeader2)) 
				log(link_Add_Parker.getText()+" is displayed");
			    if(pageHeader_text_message_Myparkers.getText().equals(_PageHeader3)) 
				   log(pageHeader_text_message_Myparkers.getText()+" is displayed");
			
				takeScreenShot();
				status="PASS";
			}	
		
		return status;
	}
	
	

////







	@FindBy(how=How.XPATH,using ="//a[@ui-sref='.parkers']//div")
	WebElement link_MyParkers;
	public void clickOnMyParkers() {
		link_MyParkers.click();
		log("Clicked on My Parkers link");
		takeScreenShot();
		
	}




	@FindBy(how=How.XPATH,using ="//div[@translate='_AddDriver_']")
	WebElement link_AddParker;
	public void clickOnAddPerson() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(link_AddParker, driver, 20);
		clickElementUsingJavaScript(link_AddParker);
	
		log("Clicked on the Add parker link to add parker");
		takeScreenShot();
		
	}
	
	
	

	
	
	/*Click on add parker*/
	

//	@FindBy(how=How.XPATH,using ="//div[@data-i18n='_AddParker_']")
//	WebElement link_AddParker;
//	public void clickOnAddPerson() {
//		WaitHelper wh = new WaitHelper(driver, test);
//		wh.waitForElementToBeClickable(link_AddParker, driver, 20);
//		clickElementUsingJavaScript(link_AddParker);
//	
//		log("Clicked on the Add person link to add parker");
//		takeScreenShot();
//		
//	}





	@FindBy(how=How.XPATH,using ="//input[@id='optionsRadios1']")
	WebElement radio_FamilyParkerOption;
	
	@FindBy(how=How.XPATH,using ="//input[@id='optionsRadios2']")
	WebElement radio_FriendParkerOption;
	
	@FindBy(how=How.XPATH,using ="//input[@id='fullName']")
	WebElement input_Name;
	
	
	@FindBy(how=How.XPATH,using ="//input[@id='input_1']")
	WebElement input_Email;
	
	@FindBy(how=How.XPATH,using ="//input[@id='input_2']")
	WebElement input_Phone;
	
	@FindBy(how=How.XPATH,using ="//input[@id='input_3']")
	WebElement input_Street;
	
	@FindBy(how=How.XPATH,using ="//input[@id='input_4']")
	WebElement input_HouseNumber;
	
	@FindBy(how=How.XPATH,using ="//input[@id='input_5']")
	WebElement input_PostCode;
	
	@FindBy(how=How.XPATH,using ="//input[@id='input_6']")
	WebElement input_City;
	
	@FindBy(how=How.XPATH,using ="//input[@id='input_7']")
	WebElement input_State;
	
	@FindBy(how=How.XPATH,using ="//*[@id='country']//md-select-value")
	WebElement CountryDropDown;
	
	
	
	
	@FindBy(how=How.XPATH,using ="//input[@id='license']")
	WebElement LicensePlate;
	
	
	@FindBy(how=How.XPATH,using ="//input[@id='carType']")
	WebElement CarType;
	
	@FindBy(how=How.XPATH,using ="//input[@type='email']")
	WebElement editinput_Email;
	
	@FindBy(how=How.XPATH,using ="//input[@data-ng-model='parkerObject.contactNumber.number']")
	WebElement editinput_Phone;
	
	@FindBy(how=How.XPATH,using ="//input[@data-ng-model='parkerObject.address.streetNumber']")
	WebElement editinput_Street;
	
	@FindBy(how=How.XPATH,using ="//input[@data-ng-model='parkerObject.address.route']")
	WebElement editinput_HouseNumber;
	
	@FindBy(how=How.XPATH,using ="//input[@data-ng-model='parkerObject.address.postalCode']")
	WebElement editinput_PostCode;
	
	@FindBy(how=How.XPATH,using ="//input[@data-ng-model='parkerObject.address.county']")
	WebElement editinput_City;
	
	@FindBy(how=How.XPATH,using ="//input[@data-ng-model='parkerObject.address.province']")
	WebElement editinput_State;
	
	
	
	public void addParkerDetails(String _FamilyOrFriendParkerType,String _Name,String _Email,String _Phone,String _Street,
			String _HouseNumber,String _PostCode,String _City,String _State,String _Country,String _LicensePlate,String _CarType) throws InterruptedException {
		
		if(_FamilyOrFriendParkerType.equalsIgnoreCase("Family")) {
			radio_FamilyParkerOption.click();
			log("Selected Family radio button");
			
		}else if(_FamilyOrFriendParkerType.equalsIgnoreCase("Friends")){
			radio_FriendParkerOption.click();
			log("Selected Friends radio button");
		}
		else {
			radio_FamilyParkerOption.click();
			log("Selected Family radio button");
		}
		
	    input_Name.sendKeys(_Name);
		input_Email.sendKeys(_Email);
		input_Phone.sendKeys(_Phone);
		input_Street.sendKeys(_Street);
		input_HouseNumber.sendKeys(_HouseNumber);
		input_PostCode.sendKeys(_PostCode);
		input_City.sendKeys(_City);
		input_State.sendKeys(_State);
		
		Thread.sleep(4000);
		clickElementUsingJavaScript(CountryDropDown);
		
		
		Thread.sleep(4000);
	
		WebElement countryvalue = driver.findElement(By.xpath("//md-option[contains(@value,'"+_Country+"')]"));
		
		
        clickElementUsingJavaScript(countryvalue);
        Thread.sleep(4000);
		
		LicensePlate.sendKeys(_LicensePlate);
		Thread.sleep(4000);
		CarType.sendKeys(_CarType);
		Thread.sleep(4000);
		takeScreenShot();
	}




	
	
	
	
	

	
	@FindBy(how=How.XPATH,using ="//button[@class='add' and @type='submit']")
	WebElement button_Add;
	public void clickOnAdd() throws InterruptedException, AWTException {
	
		
	     MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver, test);

	     mkh.pressEnterKeyAndRelease();
	     log("Clicked on the Add button");

		
		
	}
	
	
	
	
	
	
	@FindBy(how=How.XPATH,using ="//button[@class='add' and @type='button']")
	WebElement EditParker_Update_Button;
	public void clickOnUpdate() throws InterruptedException {
		Thread.sleep(2000);
		EditParker_Update_Button.click();
		takeScreenShot();
		log("Clicked on the Update button");
		
		
	}


	public String verifyParkerCreationSuccessMsg(String _SuccessMessage) throws InterruptedException{
	
		status="FAIL";
		Thread.sleep(2000);
		String t = driver.findElement(By.xpath("//div[@class='msg ng-binding']")).getText();
		
		//String concat = t.replaceAll("\n", "");
		
		if(t.equals(_SuccessMessage)) {
			status="PASS";
			log( t+" is displayed after creation of parker");
			takeScreenShot();
		}
		return status;
		
		
		
	}
	
	
	public String verifyParkerUpdationSuccessMsg(String _SuccessMessage) throws InterruptedException{
		
		status="FAIL";
		Thread.sleep(2000);
		String t = driver.findElement(By.xpath("//div[@class='msg ng-binding']")).getText();
		
		//String concat = t.replaceAll("\n", "");
		
		if(t.equals(_SuccessMessage)) {
			status="PASS";
			log( t+" is displayed after creation of parker");
			takeScreenShot();
		}
		return status;
		
		
		
	}
	
	
	
	
	public String verifyParkerDeletionSuccessMsg(String _SuccessMessage) throws InterruptedException{
		
		status="FAIL";
		Thread.sleep(2000);
		String t = driver.findElement(By.xpath("//div[@class='msg ng-binding']")).getText();
		
		//String concat = t.replaceAll("\n", "");
		
		if(t.equals(_SuccessMessage)) {
			status="PASS";
			log( t+" is displayed after creation of parker");
			takeScreenShot();
		}
		return status;
		
		
		
	}



	@FindBy(how=How.XPATH,using ="//dropdown[@class='select-dropdown ng-isolate-scope']//button[1]")
	WebElement filterParkerDropDown;
	
	public String verifyDefaultDropDownParkerfilterValue(String _defaultFilterValue) {
		status="FAIL";
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(filterParkerDropDown, driver, 10);
		
		
		
		if(filterParkerDropDown.getText().equals(_defaultFilterValue)){
			status="PASS";
			log(filterParkerDropDown.getText()+" is displayed as the default value");
			takeScreenShot();
		}
		return status;
		
	}




	@FindBy(how=How.XPATH,using ="//div[@class='family']//span[@data-ng-bind='parker.parkerType|initCap']")
	WebElement parkerType;
	
	@FindBy(how=How.XPATH,using ="//div[@class='family']//span[@data-ng-bind='parker.parkerFullName']")
	WebElement parkerFullName;
	
	@FindBy(how=How.XPATH,using ="//div[@class='family']//span[@data-ng-bind='parker.contactNumber.number | nullCheck']")
	WebElement parkerContactNumber;
	
	
	@FindBy(how=How.XPATH,using ="//div[@class='address']//span[@data-ng-bind='parker.address.route |nullCheck']")
	WebElement parkerHouseNo;
	
	@FindBy(how=How.XPATH,using ="//div[@class='address']//span[@data-ng-bind='parker.address.streetNumber| nullCheck']")
	WebElement parkerStreetNumber;
	
	@FindBy(how=How.XPATH,using ="//div[@class='address']//span[@data-ng-bind='parker.address.postalCode| nullCheck']")
	WebElement parkerPostalCode;
	
	@FindBy(how=How.XPATH,using ="//div[@class='address']//span[@data-ng-bind='parker.address.county| nullCheck']")
	WebElement parkerCity;
	
	@FindBy(how=How.XPATH,using ="//div[@class='address']//span[@data-ng-bind='parker.address.province | nullCheck']")
	WebElement parkerProvince;
	
	@FindBy(how=How.XPATH,using ="//div[@class='address']//span[@data-ng-bind='parker.address.country | nullCheck']")
	WebElement parkerCountry;
	
	@FindBy(how=How.XPATH,using ="//div[@class='vehicle-details']//span[@data-ng-bind='parker.identification.typeValue | nullCheck']")
	WebElement parkerVechileType;
	
	@FindBy(how=How.XPATH,using ="//div[@class='vehicle-details']//span[@data-ng-bind='parker.identification.value | nullCheck']")
	WebElement parkerVechileIdentification;
	
	@FindBy(how=How.XPATH,using ="//div[@class='vehicle-details']//span[@data-i18n='_NotAParker_']")
	WebElement notAParkerYet;
	
	public String verifyCreatedParkerDetails(String _FamilyOrFriendParkerType,String _Name,String _Phone,
			String _HouseNumber,String _Street,String _PostCode,
			String _City,String _State,String _Country,String _CarType,String _LicensePlate) {
	status="FAIL";
	

	

	
	if(parkerType.getText().equals(_FamilyOrFriendParkerType)) {
		log(parkerType.getText()+" is displayed ");
		
		if(parkerFullName.getText().equals(_Name)) {
			log(parkerFullName.getText()+" is displayed ");
			
			log(parkerContactNumber.getText());
			if(parkerContactNumber.getText().equals(_Phone)) {
				log(parkerContactNumber.getText()+" is displayed ");
				
				if(parkerHouseNo.getText().equals(_HouseNumber)) {
					log(parkerHouseNo.getText()+" is displayed ");
				
						if(parkerStreetNumber.getText().equals(_Street)) {
							log(parkerStreetNumber.getText()+" is displayed ");
							
							if(parkerPostalCode.getText().equals(_PostCode)) {
								log(parkerPostalCode.getText()+" is displayed ");
					
								if(parkerCity.getText().equals(_City)) {
									log(parkerCity.getText()+" is displayed ");
								
									if(parkerProvince.getText().equals(_State)) {
										log(parkerProvince.getText()+" is displayed ");
										
										if(parkerCountry.getText().equals(_Country)) {
											log(parkerCountry.getText()+" is displayed ");
										
											log(parkerVechileType.getText());
											if(parkerVechileType.getText().equals(_CarType)) {
											
												log(parkerVechileIdentification.getText());
												if(parkerVechileIdentification.getText().equals(_LicensePlate)) {
													log(parkerVechileIdentification.getText()+" is displayed ");
												
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
	
	
	public String verifyEditedParkerDetails(String _FamilyOrFriendParkerType,String _Name,String _Phone,
			String _HouseNumber,String _Street,String _PostCode,
			String _City,String _State,String _Country,String _CarType,String _LicensePlate) {
	status="FAIL";
	

	

	
	if(parkerType.getText().equals(_FamilyOrFriendParkerType)) {
		log(parkerType.getText()+" is displayed ");
		
		if(parkerFullName.getText().equals(_Name)) {
			log(parkerFullName.getText()+" is displayed ");
			
			log(parkerContactNumber.getText());
			if(parkerContactNumber.getText().equals(_Phone)) {
				log(parkerContactNumber.getText()+" is displayed ");
				
				if(parkerHouseNo.getText().equals(_HouseNumber)) {
					log(parkerHouseNo.getText()+" is displayed ");
				
						if(parkerStreetNumber.getText().equals(_Street)) {
							log(parkerStreetNumber.getText()+" is displayed ");
							
							if(parkerPostalCode.getText().equals(_PostCode)) {
								log(parkerPostalCode.getText()+" is displayed ");
					
								if(parkerCity.getText().equals(_City)) {
									log(parkerCity.getText()+" is displayed ");
								
									if(parkerProvince.getText().equals(_State)) {
										log(parkerProvince.getText()+" is displayed ");
										
										if(parkerCountry.getText().equals(_Country)) {
											log(parkerCountry.getText()+" is displayed ");
										
											log(parkerVechileType.getText());
											if(parkerVechileType.getText().equals(_CarType)) {
											
												log(parkerVechileIdentification.getText());
												if(parkerVechileIdentification.getText().equals(_LicensePlate)) {
													log(parkerVechileIdentification.getText()+" is displayed ");
												
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



	@FindBy(how=How.XPATH,using ="//button[@class='selected-item button-label dropdown-toggle']")
	WebElement DropDown_AllFamilyAndFriends;
	
	public void clickonShowDropDown() {
		
		DropDown_AllFamilyAndFriends.click();
		log("Clicked on the All Family & Friends drop down");
		takeScreenShot();
		
	}





	public void filterParker(String _FilterBy) {
		
		if(_FilterBy.equals("All Family & Friends")) {
			driver.findElement(By.xpath("//*[@id='dropDownListContent']/li[1]/a")).click();
			log("Filtered by All Family & Friends");
			takeScreenShot();
			
		}else if(_FilterBy.equals("Only Family")) {
			driver.findElement(By.xpath("//*[@id='dropDownListContent']/li[2]/a")).click();
			log("Filtered by Only Family");
			takeScreenShot();
		}else if(_FilterBy.equals("Only Friends")) {
			driver.findElement(By.xpath("//*[@id='dropDownListContent']/li[3]/a")).click();
			log("Filtered by Only Friends");
			takeScreenShot();
		}else {
			log("NO value in Show has matched");
		}
		
		
	}



	@FindBy(how=How.XPATH,using ="//a[@data-ng-click='deleteParker(parker)']//div")
	WebElement deleteParker_icon;

	@FindBy(how=How.XPATH,using ="//h1[@class='ng-binding']")
	WebElement deleteConfirmationMessage;
	
	public void clickOnDeleteParkerIcon() throws InterruptedException {

		Thread.sleep(3000);
		clickElementUsingJavaScript(deleteParker_icon);
		
		log("Clicked on the Delete parker icon");
		
		takeScreenShot();
		
		
		
	}

	public String verifyDeleteConfirmationMessage(String _DeleteConfirmation) {

		status="FAIL";
		
//		WaitHelper wh = new WaitHelper(driver, test);
//		
//        WebElement ConfMsg = driver.findElement(By.xpath("//h1[@class='ng-binding' and text()='"+_DeleteConfirmation+"']"));
//		
//		wh.waitForElementToBeVisible(ConfMsg, driver, 10);
		
		
		if(deleteConfirmationMessage.getText().equals(_DeleteConfirmation)) {
			log(deleteConfirmationMessage.getText()+" is displayed");
			takeScreenShot();
			status="PASS";
		}
		return status;
		
		
	}
	
	@FindBy(how=How.XPATH,using =".//*[@id='btnCancel']")
	WebElement NoButton;
	public void clickOnNoDeleteConfirmationPopUp() throws InterruptedException {
		Thread.sleep(2000);
	
		NoButton.click();
		log("Clicked on the No button");
		takeScreenShot();
		
	}
	
	




	@FindBy(how=How.XPATH,using ="//button[@id='btnCancel']")
	WebElement btnCancel;
	public void clickonCancelbutton_DeleteParkerConfirmation() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(btnCancel, driver, 30);
	
		clickElementUsingJavaScript(btnCancel);
		log("clicked on the Cancel button");
		takeScreenShot();
		
		
	}




	@FindBy(how=How.XPATH,using ="//button[@id='btnOk']")
	WebElement btnDelete;
	public void clickonDeletebutton_DeleteParkerConfirmation() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(btnDelete, driver, 30);
		
		clickElementUsingJavaScript(btnDelete);
		log("clicked on the Delete button in Delete Confirmation");
		takeScreenShot();
	}




	@FindBy(how=How.XPATH,using ="//div[@translate='_CancelIdentificationForm_']")
	WebElement Cancel;
	public void clickOnCancel() throws InterruptedException {
		Thread.sleep(2000);
		Cancel.click();
		takeScreenShot();
		log("Clicked on the Cancel button, Parker Details Popup Closed");
	}




	@FindBy(how=How.XPATH,using ="//div[@class='ssp-icon_pen_edit']")
	WebElement EditParker;
	public void clickOnEditParker() {
		EditParker.click();
		log("Clicked on Edit parker");
		takeScreenShot();
		
	}



	
	
	public void editParkerDetails(String _FamilyOrFriendParkerType,String _Name,String _Email,String _Phone,String _Street,
			String _HouseNumber,String _PostCode,String _City,String _State,String _Country,String _LicensePlate,String _CarType) throws InterruptedException {
		
		if(_FamilyOrFriendParkerType.equalsIgnoreCase("Family")) {
			radio_FamilyParkerOption.click();
			log("Selected Family radio button");
			
		}else if(_FamilyOrFriendParkerType.equalsIgnoreCase("Friends")){
			radio_FriendParkerOption.click();
			log("Selected Friends radio button");
		}
		else {
			radio_FamilyParkerOption.click();
			log("Selected Family radio button");
		}
		input_Name.clear();
	    input_Name.sendKeys(_Name);
	    editinput_Email.clear();
	    editinput_Email.sendKeys(_Email);
	    editinput_Phone.clear();
	    editinput_Phone.sendKeys(_Phone);
	    editinput_Street.clear();
	    editinput_Street.sendKeys(_Street);
	    editinput_HouseNumber.clear();
	    editinput_HouseNumber.sendKeys(_HouseNumber);
	    editinput_PostCode.clear();
	    editinput_PostCode.sendKeys(_PostCode);
	    editinput_City.clear();
	    editinput_City.sendKeys(_City);
	    editinput_State.clear();
	    editinput_State.sendKeys(_State);
		
		Thread.sleep(4000);
		clickElementUsingJavaScript(CountryDropDown);
		
		
		Thread.sleep(4000);
	
		WebElement countryvalue = driver.findElement(By.xpath("//md-option[contains(@value,'"+_Country+"')]"));
		
		
        clickElementUsingJavaScript(countryvalue);
        Thread.sleep(4000);
        LicensePlate.clear();
		LicensePlate.sendKeys(_LicensePlate);
		Thread.sleep(4000);
		CarType.clear();
		CarType.sendKeys(_CarType);
		Thread.sleep(4000);
		takeScreenShot();
	}



	/*Verify all fields are available for parkers*/
	

	@FindBy(how=How.XPATH,using =".//*[@id='driverName']")
	WebElement Add_parker_Name_field;
	
	@FindBy(how=How.XPATH,using =".//*[@id='driverEmail']")
	WebElement Add_parker_Email_field;
	
	@FindBy(how=How.XPATH,using ="//button[@class='add' and @type='submit']")
	WebElement Add_parker_Add_Button;
	
	@FindBy(how=How.XPATH,using ="//button[@class='cancel' and @type='button']")
	WebElement Add_parker_Cancel_Button;
	
	public String verifyAvailbleParkersFieldsInParkerDetailsForm(String _ParkerName_field,String _ParkerEmail_field) throws InterruptedException{
		status="FAIL";
		Thread.sleep(3000);
		if(Add_parker_Name_field.getAttribute("id").equals(_ParkerName_field)){
			log(Add_parker_Name_field.getAttribute("id")+"--> parker name field is displayed for parker Details form");
			if(Add_parker_Email_field.getAttribute("id").equals(_ParkerEmail_field)){
				log(Add_parker_Email_field.getAttribute("id")+"--> parker E-mail field is displayed for parker Details form");
				
								
					status="PASS";
				}
			}
								
			
		return status;

 }
	
	/*Verify Add & Cancel buttons in add parker details*/
	
	public String verify_Add_and_Cancel_Buttons_InParkerDetailsForm(String _AddButton,String _CancelButton) throws InterruptedException{
		status="FAIL";
		Thread.sleep(2000);
		if(Add_parker_Add_Button.getAttribute("class").equals(_AddButton)){
			log(Add_parker_Add_Button.getAttribute("class")+"--> ADD button is displayed in parker Details form");
			if(Add_parker_Cancel_Button.getAttribute("class").equals(_CancelButton)){
				log(Add_parker_Cancel_Button.getAttribute("class")+"--> CANCEL button is displayed in parker Details form");
				
				
				status="PASS";
				}
			}
								
			
		return status;

 }
	
	@FindBy(how=How.XPATH,using ="//button[@type='submit']")
	WebElement Add_Parker_Details_Button;
	public void clickOnAdd_parker_Details() throws InterruptedException {
		Thread.sleep(2000);
		Add_Parker_Details_Button.click();
		takeScreenShot();
		log("Clicked on the Add button");
		
		
	}
	
	
	/*Verify footer text in add parker details*/
	
	@FindBy(how=How.XPATH,using ="//div[@translate='_AddDriverInfo1_']")
	WebElement parker_footer_message1;
	
	@FindBy(how=How.XPATH,using ="//div[@translate='_AddDriverInfo2_']")
	WebElement parker_footer_message2;
	
	public String verifyParker_DetailsPage_footer_text(String _PageFooter1,String _PageFooter2) throws InterruptedException {
		status="FAIL";
		Thread.sleep(2000);
		if(parker_footer_message1.getText().equals(_PageFooter1)) {
			log(parker_footer_message1.getText()+" is displayed");
			if(parker_footer_message2.getText().equals(_PageFooter2)) 
				log(parker_footer_message2.getText()+" is displayed");
				takeScreenShot();
				status="PASS";
			}	
		
		return status;
	}



/*Enter parker details*/
	
	
	public void EnterParkerDetails(String _ParkerName,String _ParkerEmail) throws InterruptedException {
		
		Thread.sleep(3000);
		Add_parker_Name_field.click();
		Add_parker_Name_field.sendKeys(_ParkerName);
		log("Entered Parker Name");
		Thread.sleep(1000);
		Add_parker_Email_field.click();
		Add_parker_Email_field.sendKeys(_ParkerEmail);
		log("Entered Parker Email");
		takeScreenShot();

	}
	
	
	/*Verify added parker details*/
	
	@FindBy(how=How.XPATH,using ="//span[@class='name ng-binding']")
	WebElement Added_Parker_Name;
	
	@FindBy(how=How.XPATH,using ="//span[@class='email ng-binding']")
	WebElement Added_Parker_Email;
	
	@FindBy(how=How.XPATH,using ="//div[@class='identificationname ng-binding']")
	WebElement Added_IdentificationType;
	
	@FindBy(how=How.XPATH,using ="//span[@class='identificationname ng-binding']")
	WebElement Added_IdentificationValue;
	
	
	public String verify_AddedParkerDetails(String _AddedParkerName, String _AddedParkerEmail,String _IdentificationType,String _Id) throws InterruptedException {
		status="FAIL";
		
		
		WebElement loader = driver.findElement(By.xpath("//div[@class='loader']"));
		
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeInvisible(loader, driver, 15);
		
		
	if(Added_Parker_Name.getText().equals(_AddedParkerName)) {
		log(Added_Parker_Name.getText()+ " name is displayed in my parker details");
		if(Added_Parker_Email.getText().equals(_AddedParkerEmail)) {
			log(Added_Parker_Email.getText()+ " email is displayed in my parker details");

			if(Added_IdentificationType.getText().equals(_IdentificationType+":")) {
				log(Added_IdentificationType.getText()+ " Identification Type is displayed in my parker details");
				if(Added_IdentificationValue.getText().equals(_Id)) {
					log(Added_IdentificationValue.getText()+ "  id is displayed in my parker details");
					status="PASS";
					takeScreenShot();
				}
			}
		}
		
	}
	return status;
	
}
	
	
	public String verify_AddedParkerDetails_MyParkersPg(String _AddedParkerName, String _AddedParkerEmail) throws InterruptedException {
		status="FAIL";
		
		
		WebElement loader = driver.findElement(By.xpath("//div[@class='loader']"));
		
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeInvisible(loader, driver, 15);
		
		
	if(Added_Parker_Name.getText().equals(_AddedParkerName)) {
		log(Added_Parker_Name.getText()+ " name is displayed in my parker details");
		if(Added_Parker_Email.getText().equals(_AddedParkerEmail)) {
			log(Added_Parker_Email.getText()+ " email is displayed in my parker details");

					status="PASS";
					takeScreenShot();
		}
		
	}
	return status;
	
}
	
	/*Clicked On Edit Parker*/
	
	@FindBy(how=How.XPATH,using ="//span[@class='ssp-icon_pen_edit']")
	WebElement editParker;
	
	public void clickOnEdit_Parker() throws InterruptedException {
		
		
	WebElement loader = driver.findElement(By.xpath("//div[@class='loader']"));
		
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeInvisible(loader, driver, 15);
		
		editParker.click();
		log("Clicked on the Edit Parker Icon");
		takeScreenShot();
		
	}
	
	@FindBy(how=How.XPATH,using =".//*[@id='driverEditName']")
	WebElement editParker_Name;
	
	public void editParkerDetails(String _ParkerName) throws InterruptedException {
		Thread.sleep(2000);
		editParker_Name.clear();
		editParker_Name.sendKeys(_ParkerName);
		log("Parker Name Successfully Edited");
		
		Thread.sleep(2000);
		EditParker_Update_Button.click();
		takeScreenShot();
	}
	
	/*Clicked On Delete Parker Icon*/
	
	@FindBy(how=How.XPATH,using ="//span[@class='ssp-icon_trash']")
	WebElement deleteParkerIcon;
	public void clickOnDeleteParkerIcon_() throws InterruptedException {
		    
			deleteParkerIcon.click();
		    log("Clicked on the delete Parker icon ");
		    takeScreenShot();
		
		
	}
	
	@FindBy(how=How.XPATH,using =".//*[@id='btnOk']")
	WebElement YesButton;
	public void clickOnYesDeleteConfirmationPopUp() throws InterruptedException {
		Thread.sleep(2000);
	
		YesButton.click();
		log("Clicked on the Yes button");
		takeScreenShot();
		
	}
	

	public String verifyParkerDeleted() throws InterruptedException {
	status="FAIL";
	Thread.sleep(3000);
		List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@id,'add')]"));
		if(rows.size()==0) {
			status="PASS";
			log("No Parker rows are found");
			takeScreenShot();
		}
		return status;
	}
	
	/*Clicked On "X" Button In Delete Confirmation Popup*/
	
	@FindBy(how=How.XPATH,using ="//i[@class='ssp-icon_close']")
	WebElement X_Button;
	public void clickOn_X_DeleteConfirmationPopUp() throws InterruptedException {
		Thread.sleep(2000);
	
		X_Button.click();
		log("Clicked on the X button In Delete Confirmation PopUp");
		takeScreenShot();
		
	}
	
	
	/*Email Error Message Displayed In Add Parker Details Form*/
	
	@FindBy(how=How.XPATH,using ="//div[@class='md-input-message-animation ng-binding ng-scope'][contains(text(),'Please check the email address')]")
	WebElement Email_Error_Message;
	
	@FindBy(how=How.XPATH,using ="//span[@translate='_AddDriver_']")
	WebElement ParkerText;
	
	public String Verify_Parker_Email_Error_Message(String _ParkerEmailErrorMassage) throws InterruptedException {
		status="FAIL";
		Thread.sleep(1000);
		ParkerText.click();
		
		if(Email_Error_Message.getText().equals(_ParkerEmailErrorMassage)) {
			log("Error message for Enter Valid Email in Parker Details Form -->"+ Email_Error_Message.getText());
		
			status="PASS";
		}
		return status;
		
	}
	
	
	/*Verify Discard Confirmation PopUp*/
	
	@FindBy(how=How.XPATH,using ="//h1[@class='ng-binding']")
	WebElement Discard_Confirmation_Popup;
	public String verify_Discard_ConfirmationMessage(String _DiscardConfirmation) throws InterruptedException {
		Thread.sleep(3000);

		status="FAIL";
		
		if(deleteConfirmationMessage.getText().equals(_DiscardConfirmation)) {
			log(deleteConfirmationMessage.getText()+" is displayed");
			takeScreenShot();
			status="PASS";
		}
		return status;
		
		
	}
	
	@FindBy(how=How.XPATH,using ="//button[@id='btnOk']")
	WebElement YesButton_;
	public void clickOnYesDiscardConfirmationPopUp_() throws InterruptedException {
		Thread.sleep(2000);
	
		YesButton_.click();
		log("Clicked on the Yes button In Discard Confirmation Popup, Page navigated to Dashboard Page");
		takeScreenShot();
		
	}
	
	@FindBy(how=How.XPATH,using ="//button[@id='btnCancel']")
	WebElement NoButton_;
	public void clickOnNoDiscardConfirmationPopUp_() throws InterruptedException {
		Thread.sleep(2000);
	
		NoButton_.click();
		log("Clicked on the No button In Discard Confirmation Popup");
		takeScreenShot();
		
	}
	
	

	

}