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
public class SspAddressesPage extends TestBase {

	
	
	String status=null;


	public static final Logger log = Logger.getLogger(SspAddressesPage.class.getName());



	//Class constructor
	public SspAddressesPage(WebDriver driver,ExtentTest test) {
		this.test=test;
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}


	/**
	 ******************************************************************************************************
	 * Web Elements of Portal address Page
	 ******************************************************************************************************
	 */

	@FindBy(xpath = "//span[@class='v-label' and text()='LOADING...']")
	public WebElement loadingprogress;


	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;

	@FindBys({	
		@FindBy(how=How.ID, using="logo"),
	})	public List<WebElement> allElementsInList_LogoImage;

	@FindBy(how=How.XPATH,using ="//div[text()='Addresses']")
	WebElement link_Address;

	@FindBy(how=How.XPATH,using ="//div[@translate='_AddAddress_']")
	WebElement link_AddBillingAddresses;


	@FindBy(how=How.XPATH,using ="//form[@id='addNewAddressForm']")
	WebElement form_AddMyAddressform;

	@FindBy(how=How.XPATH,using ="//md-radio-button[@aria-checked='true']")
	WebElement radiobutton_DefaultPrivateperson;

	@FindBy(how=How.XPATH,using ="//div[contains(text(),'Private Person')]")
	WebElement label_Privateperson;

	@FindBy(how=How.XPATH,using ="//md-radio-button[@value='COMPANY']")
	WebElement label_Company;

	@FindBy(how=How.XPATH,using ="//input[@id='name']")
	WebElement textbox_Privatename;

	@FindBy(how=How.XPATH,using ="//md-select[@id='country']")
	WebElement dropDownlist_country;

	@FindBy(how=How.XPATH,using ="//input[@type='text' and @ng-required='searchRequired']")
	WebElement textbox_address;

	@FindBy(how=How.XPATH,using ="//input[@id='phone']")
	WebElement textbox_phone;

	@FindBy(how=How.XPATH,using ="//input[@id='addressLine1']")
	WebElement textbox_addressline1;

	@FindBy(how=How.XPATH,using ="//input[@id='addressLine2']")
	WebElement textbox_addressline2;

	@FindBy(how=How.XPATH,using ="//input[@id='city']")
	WebElement textbox_TownOrCity;

	@FindBy(how=How.XPATH,using ="//input[@id='state']")
	WebElement textbox_StateOrProvince;

	@FindBy(how=How.XPATH,using ="//input[@id='postCode']")
	WebElement textbox_PostCode;

	@FindBy(how=How.XPATH,using ="//button[@type='submit']")
	WebElement button_ADDButton;

	@FindBy(how=How.XPATH,using ="//span[@class='ssp-icon_close']")
	WebElement button_CancelXButton;

	@FindBy(how=How.XPATH,using ="//a[@id='enterAddrManuallyLink']")
	WebElement link_Enteraddressmanually;

	@FindBy(how=How.XPATH,using =".//*[@id='companyName']")
	WebElement textbox_comapanyName;

	@FindBy(how=How.XPATH,using =".//*[@id='otherInformation']")
	WebElement textbox_otherinformation;

	@FindBy(how=How.XPATH,using =".//*[@id='vat']")
	WebElement textbox_vat;

	@FindBy(how=How.XPATH,using ="//h1['Are you sure you want to delete ?']")
	WebElement label_aresurewanttodelete;


	@FindBys({	
		@FindBy(how=How.XPATH, using="//div[@class='billing-details ng-scope']"),
	})	public List<WebElement> list_NumberOfaddressInAddressPage;

	@FindBy(how=How.XPATH,using =".//*[@id='btnOk']")
	WebElement button_YES;


	/**
	 *****************************************************************************************************************
	 * Method to verify the Page Title
	 * @param _PageTitle
	 * @return
	 *****************************************************************************************************************
	 */
	public String verifyPageTitle(String _PageTitle) {
		status="FAIL";
		
		driver.getTitle();
		log(_PageTitle);
	
		if(driver.getTitle().equals(_PageTitle)) {
			log("Title of the page is "+driver.getTitle());
			status="PASS";
			takeScreenShot();
		}
		return status;
	}


	@FindBy(how=How.XPATH,using ="//h2[@class='ng-scope' and @translate='_YouDoNotHaveAnyAddresses_']")
	WebElement pageHeader;

	@FindBy(how=How.XPATH,using ="//span[@translate='_AddAddress_']")
	WebElement link_AddBillingAddress;
	
	@FindBy(how=How.XPATH,using ="//p[@class='ng-scope' and @translate='_PleaseClickToAddAddresses_']")
	WebElement pageHeader2;


	public String verifyPageHeaderAndLabel(String _PageHeader,String _PageHeader2,String _AddBillinAddressLabel) throws InterruptedException {
		status="FAIL";
		Thread.sleep(1000);
		if(pageHeader.getText().equals(_PageHeader)) {
			log(pageHeader.getText()+" is displayed");
			if(pageHeader2.getText().equals(_PageHeader2)) 
				log(pageHeader2.getText()+" is displayed");
			if(link_AddBillingAddress.getText().equals(_AddBillinAddressLabel)) {
				log(link_AddBillingAddress.getText()+" is displayed");
				takeScreenShot();
				status="PASS";
			}	
		}
		return status;
	}

	public void clickOnAddress() {
		link_Address.click();
		log("clicked on Address");
		takeScreenShot();	
	}

	public void clickOnAddbillingAddresses() {
		link_AddBillingAddresses.click();
		log("clicked on Add my addresses link to get the address form");
		takeScreenShot();	
	}

	public void clickOnCompanygAddresses() {
		label_Company.click();
		log("clicked on Company address option");
		takeScreenShot();	
	}


	public String verifyAddbillingAddressFormdisplayed(String _AddAddressForm,String _DefaultPrivatePersonAddress){
		status="FAIL";

		if(form_AddMyAddressform.getAttribute("id").equals(_AddAddressForm)){
			log(form_AddMyAddressform.getAttribute("id")+"--> Address form is displayed");
			takeScreenShot();
			if(radiobutton_DefaultPrivateperson.getAttribute("class").contains(_DefaultPrivatePersonAddress)){
				log(radiobutton_DefaultPrivateperson.getAttribute("class")+"-> Private person is default selected in add address form options");
				takeScreenShot();
				status="PASS";
			}
		}
		return status;
	}

	/**
	 * This method to verify all the private persons avaialble fields in hte address form as well as in the enter address manually.
	 * @throws InterruptedException 
	 */
	public String verifyAvailbleAddreessFiledsInPrivatePersonsAddressForm(String _PrivateName,String _Contry,String _Address,String _Phone,String _AddressLine1,String _AddressLine2,
			String _TownOrCity,String _StateOrProvince,String _Postcode) throws InterruptedException{
		status="FAIL";

		if(textbox_Privatename.getAttribute("id").equals(_PrivateName)){
			log(textbox_Privatename.getAttribute("id")+"--> Name text field is displayed in private person address form");
			if(dropDownlist_country.getAttribute("id").equals(_Contry)){
				log(dropDownlist_country.getAttribute("id")+"--> Country drop down is displayed in private person address form");
				if(textbox_address.getAttribute("id").equals(_Address)){
					log(textbox_address.getAttribute("id")+"--> Address text field is displayed in private person address form");
					if(textbox_phone.getAttribute("id").equals(_Phone)){
						log(textbox_phone.getAttribute("id")+"--> Phone text field is displayed in private person address form");
						Thread.sleep(500);
						link_Enteraddressmanually.click();
						Thread.sleep(500);
						if(textbox_addressline1.getAttribute("id").equals(_AddressLine1)){
							log(textbox_addressline1.getAttribute("id")+"--> Address line 1  text field is displayed in private person address form");
							if(textbox_addressline2.getAttribute("id").equals(_AddressLine2)){
								log(textbox_addressline2.getAttribute("id")+"--> Address line 2  text field is displayed in private person address form");
								if(textbox_TownOrCity.getAttribute("id").equals(_TownOrCity)){
									log(textbox_TownOrCity.getAttribute("id")+"--> Town Or City text field is displayed in private person address form");
									if(textbox_StateOrProvince.getAttribute("id").equals(_StateOrProvince)){
										log(textbox_StateOrProvince.getAttribute("id")+"--> State Or Province text field is displayed in private person address form");
										if(textbox_PostCode.getAttribute("id").equals(_Postcode)){
											log(textbox_PostCode.getAttribute("id")+"--> PostCode text field is displayed in private person address form");
											takeScreenShot();
											status="PASS";
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

	/**
	 * This method to verify all the Company persons avaialble fields in the address form as well as in the enter address manually.
	 * @throws InterruptedException 
	 */
	public String verifyAvailbleAddreessFiledsInCompanyAddressForm(String _CompanyName,String _Contry,String _OtherInformation,String _Vat,String _Address,String _Phone,String _AddressLine1,String _AddressLine2,
			String _TownOrCity,String _StateOrProvince,String _Postcode) throws InterruptedException{
		status="FAIL";

		if(textbox_comapanyName.getAttribute("id").equals(_CompanyName)){
			log(textbox_comapanyName.getAttribute("id")+"--> Name text field is displayed in Company person address form");
			if(dropDownlist_country.getAttribute("id").equals(_Contry)){
				log(dropDownlist_country.getAttribute("id")+"--> Country drop down is displayed in Company person address form");
				if(textbox_address.getAttribute("id").equals(_Address)){
					log(textbox_address.getAttribute("id")+"--> Address text field is displayed in Company person address form");
					if(textbox_phone.getAttribute("id").equals(_Phone)){
						log(textbox_phone.getAttribute("id")+"--> Phone text field is displayed in Company person address form");
						if(textbox_otherinformation.getAttribute("id").equals(_OtherInformation)){
							log(textbox_otherinformation.getAttribute("id")+"--> Other Information text field is displayed in Company person address form");
							if(textbox_vat.getAttribute("id").equals(_Vat)){
								log(textbox_vat.getAttribute("id")+"--> VAT text field is displayed in Company person address form");	
								Thread.sleep(500);
								link_Enteraddressmanually.click();
								Thread.sleep(500);
								if(textbox_addressline1.getAttribute("id").equals(_AddressLine1)){
									log(textbox_addressline1.getAttribute("id")+"--> Address line 1  text field is displayed in Company person address form");
									if(textbox_addressline2.getAttribute("id").equals(_AddressLine2)){
										log(textbox_addressline2.getAttribute("id")+"--> Address line 2  text field is displayed in Company person address form");
										if(textbox_TownOrCity.getAttribute("id").equals(_TownOrCity)){
											log(textbox_TownOrCity.getAttribute("id")+"--> Town Or City text field is displayed in Company person address form");
											if(textbox_StateOrProvince.getAttribute("id").equals(_StateOrProvince)){
												log(textbox_StateOrProvince.getAttribute("id")+"--> State Or Province text field is displayed in Company person address form");
												if(textbox_PostCode.getAttribute("id").equals(_Postcode)){
													log(textbox_PostCode.getAttribute("id")+"--> PostCode text field is displayed in Company person address form");
													takeScreenShot();
													status="PASS";
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

	public void clickOnADDButton() {
		button_ADDButton.click();
		log("clicked on ADD button");
        WebElement loader = driver.findElement(By.xpath("//div[@class='loader']"));
		
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeInvisible(loader, driver, 30);
		takeScreenShot();	
	}

	/**
	 * This method addes private person short addresses
	 * @throws InterruptedException 
	 */
	public void addPrivatePersonShortAddress(String _PrivatShortName ,String _PrivateCountry,String _PrivateShortAddress,String _PrivatePhone) throws InterruptedException{
		status="FAIL";
		
		textbox_Privatename.sendKeys(_PrivatShortName);
		log("Entered Private person Name");
		Thread.sleep(1000);

		dropDownlist_country.click();
		
		Thread.sleep(1000);
        List<WebElement> countries = driver.findElements(By.xpath("//div[@id='select_container_3']//*[@class='_md']//div[1]"));
		
		for(int i =0;i<countries.size();i++) {
			if((countries.get(i).getText()).equals(_PrivateCountry)){
				clickElementUsingJavaScript(countries.get(i));
				Thread.sleep(3000);
				break;
			}
		}
		
		Thread.sleep(3000);
		
		if(textbox_address.isDisplayed()) {
			textbox_address.sendKeys(_PrivateShortAddress.substring(0, 10));
			WebElement dropDownMenu_listOfAddress = driver.findElement(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']//a"));

			WaitHelper wh = new WaitHelper (driver , test);
			wh.waitForElementToBeVisible(dropDownMenu_listOfAddress, driver, 20);

			List<WebElement> searchResults = driver.findElements(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']//a"));
			for(int i=0;i<searchResults.size();i++) {
				int j=i+1;

				WebElement addressToSelect = driver.findElement(By.xpath("//ul[contains(@id,'typeahead')]//li["+j+"]//div[@class='ng-binding']"));
				if(addressToSelect.getText().equals(_PrivateShortAddress)) {
					addressToSelect.click();
					takeScreenShot();
					log("Address is selected from Search Result");
					break;

				}
			}
		
		}
		
	//	textbox_address.sendKeys(_PrivateShortAddress);
	//	log("Entered Private SHort Address");
		
		WaitHelper wh = new WaitHelper (driver , test);
		wh.waitForElementToBeClickable(textbox_phone, driver, 20);		
				
		textbox_phone.click();
		textbox_phone.sendKeys(_PrivatePhone);
		log("Entered Private person Phone");
		takeScreenShot();
		
		clickOnADDButton();
		
		status="PASS";
				
	}
			
		
	
		

	/**
	 * This method addes private person full addresses
	 * @throws InterruptedException 
	 */
	public void addPrivatePersonfullAddress(String _PrivatShortName,String _PrivateCountry,String _PrivateAddress1,String _Privateaddress2,String _Privatetown
			,String _PrivateStateOrProvince,String _Postcode,String _PrivatePhone) throws InterruptedException{
		status="FAIL";
		textbox_Privatename.sendKeys(_PrivatShortName);
		log("Entered Private person Name");

		dropDownlist_country.click();

        List<WebElement> countries = driver.findElements(By.xpath("//div[@id='select_container_3']//*[@class='_md']//div[1]"));
		
		for(int i =0;i<countries.size();i++) {
			if((countries.get(i).getText()).equals(_PrivateCountry)){
				clickElementUsingJavaScript(countries.get(i));
				Thread.sleep(3000);
				break;
			}
		}
		
//		WebElement countryvalue = driver.findElement(By.xpath("//md-option[contains(@value,'"+_PrivateCountry+"')]"));
//		clickElementUsingJavaScript(countryvalue);
		Thread.sleep(1000);

		link_Enteraddressmanually.click();
		Thread.sleep(1000);
		textbox_addressline1.sendKeys(_PrivateAddress1);
		log("Entered Private Address1");

		textbox_addressline2.sendKeys(_Privateaddress2);
		log("Entered Private Address2");

		textbox_TownOrCity.sendKeys(_Privatetown);
		log("Entered Private Town or City");

		textbox_StateOrProvince.sendKeys(_PrivateStateOrProvince);
		log("Entered Private State or Province");

		textbox_PostCode.sendKeys(_Postcode);
		log("Entered Private Postcode");

		textbox_phone.sendKeys(_PrivatePhone);
		log("Entered Private person Phone");
		takeScreenShot();
		clickOnADDButton();
		status="PASS";
	}

	/**
	 * This method addes Company short addresses
	 * @throws InterruptedException 
	 */
	public void addCompanyShortAddress(String _CopanyShortName,String _CompanyOtherInformation,String _CompanyVat,String _CompanyCountry,String _CompanyShortAddress,String _CompanyPhone) throws InterruptedException{
		status="FAIL";
		textbox_comapanyName.sendKeys(_CopanyShortName);
		log("Entered Company shortaddress Name");

		textbox_otherinformation.sendKeys(_CompanyOtherInformation);
		log("Entered Company Other information");

		textbox_vat.sendKeys(_CompanyVat);
		log("Entered Company VAT");

		dropDownlist_country.click();
		
       List<WebElement> countries = driver.findElements(By.xpath("//div[@id='select_container_3']//*[@class='_md']//div[1]"));
		
		for(int i =0;i<countries.size();i++) {
			if((countries.get(i).getText()).equals(_CompanyCountry)){
				clickElementUsingJavaScript(countries.get(i));
				Thread.sleep(3000);
				break;
			}
		}
		    
		
//		WebElement countryvalue = driver.findElement(By.xpath("//md-option[contains(@value,'"+_CompanyCountry+"')]"));
//		clickElementUsingJavaScript(countryvalue);
//		Thread.sleep(1000);
		
       Thread.sleep(3000);
		
		if(textbox_address.isDisplayed()) {
			textbox_address.sendKeys(_CompanyShortAddress.substring(0, 10));
			WebElement dropDownMenu_listOfAddress = driver.findElement(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']//a"));

			WaitHelper wh = new WaitHelper (driver , test);
			wh.waitForElementToBeVisible(dropDownMenu_listOfAddress, driver, 20);

			List<WebElement> searchResults = driver.findElements(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']//a"));
			for(int i=0;i<searchResults.size();i++) {
				int j=i+1;

				WebElement addressToSelect = driver.findElement(By.xpath("//ul[contains(@id,'typeahead')]//li["+j+"]//div[@class='ng-binding']"));
				if(addressToSelect.getText().equals(_CompanyShortAddress)) {
					addressToSelect.click();
					takeScreenShot();
					log("Address is selected from Search Result");
					break;

				}
			}
		
		}

//		textbox_address.sendKeys(_CompanyShortAddress);
//		log("Entered Company Short Address");

		WaitHelper wh = new WaitHelper (driver , test);
		wh.waitForElementToBeClickable(textbox_phone, driver, 20);	
		textbox_phone.sendKeys(_CompanyPhone);
		log("Entered Company Phone");
		takeScreenShot();
		clickOnADDButton();
		status="PASS";
	}

	/**
	 * This method addes Company full addresses
	 * @throws InterruptedException 
	 */
	public void addCompanyfullAddress(String _CompanyName,String _CompanyOtherInformation,String _CompanyVat,String _CompanyCountry,String _CompanyFullAddress1,String _CompanyFullAddress2,String _Companytown
			,String _CompanyStateOrProvince,String _CompanyPostcode,String _CompanyPhone) throws InterruptedException{
		status="FAIL";
		textbox_comapanyName.sendKeys(_CompanyName);
		log("Entered Company full address Name");

		textbox_otherinformation.sendKeys(_CompanyOtherInformation);
		log("Entered Company Other information");

		textbox_vat.sendKeys(_CompanyVat);
		log("Entered Company VAT");

		dropDownlist_country.click();
		
		
        List<WebElement> countries = driver.findElements(By.xpath("//div[@id='select_container_3']//*[@class='_md']//div[1]"));
		
		for(int i =0;i<countries.size();i++) {
			if((countries.get(i).getText()).equals(_CompanyCountry)){
				clickElementUsingJavaScript(countries.get(i));
				Thread.sleep(3000);
				break;
			}
		}
//		WebElement countryvalue = driver.findElement(By.xpath("//md-option[contains(@value,'"+_CompanyCountry+"')]"));
//		clickElementUsingJavaScript(countryvalue);
		Thread.sleep(1000);

		link_Enteraddressmanually.click();
		Thread.sleep(1000);

		textbox_addressline1.sendKeys(_CompanyFullAddress1);
		log("Entered Company full Address1");

		textbox_addressline2.sendKeys(_CompanyFullAddress2);
		log("Entered Company full Address2");

		textbox_TownOrCity.sendKeys(_Companytown);
		log("Entered Company full Address town");

		textbox_StateOrProvince.sendKeys(_CompanyStateOrProvince);
		log("Entered Company full Address State Or Province");

		textbox_PostCode.sendKeys(_CompanyPostcode);
		log("Entered Company full Address Post Code");

		textbox_phone.sendKeys(_CompanyPhone);
		log("Entered Company Phone");
		takeScreenShot();
		clickOnADDButton();
		status="PASS";
	}

	public void deleteaddresses() throws InterruptedException{
		Thread.sleep(5000);
		List<WebElement> address=list_NumberOfaddressInAddressPage;
		int elements=address.size();

		System.out.println(elements);
		for(int i=0; i< elements; i++){
			driver.findElement(By.xpath(".//*[@data-ng-repeat='item in addressList']['"+ i +"']//div[@class='controls']/a[contains(@data-ng-click,'openDeleteAddressDialog')]")).click();
			button_YES.click();
			//boolean IsAddressPresent=driver.findElement(By.xpath("//form[@id='editAddressForm']//div[@class='billing-details']"))..isDisplayed();
			boolean IsAddressPresent=driver.findElement(By.xpath(".//*[@data-ng-repeat='item in addressList']['"+ i +"']//div[@class='controls']/a[contains(@data-ng-click,'openDeleteAddressDialog')]")).isDisplayed();
			System.out.println(IsAddressPresent);

			if(IsAddressPresent==false){
				log("Successfully deleted the Created address");
			}
		}
	}

	@FindBy(how=How.XPATH,using ="//p[@id='viewAddrName']")
	WebElement AddrName;
	@FindBy(how=How.XPATH,using ="//p[@id='viewAddrPhone']")
	WebElement AddrPhone;
	@FindBy(how=How.XPATH,using ="//p[@id='viewAddrAddr1']")
	WebElement viewAddrAddr1;
	@FindBy(how=How.XPATH,using ="//p[@id='viewAddrAddr2']")
	WebElement viewAddrAddr2;
	@FindBy(how=How.XPATH,using ="//p[@id='viewAddrCity']")
	WebElement viewAddrCity;
	@FindBy(how=How.XPATH,using ="//p[@id='viewAddrState']")
	WebElement viewAddrState;
	@FindBy(how=How.XPATH,using ="//p[@id='viewAddrPostcode']")
	WebElement viewAddrPostcode;
	@FindBy(how=How.XPATH,using ="//p[@id='viewAddrCountry']")
	WebElement viewAddrCountry;
	public String verifySavedBillingAddresses_PrivatePerson(String _Name,String _Phone,String _AddressLine1,String _AddressLine2,
			String _City,String _State,String _Postcode,String _Country) {
		status="FAIL";

		if(AddrName.getText().equals(_Name)) {
			log("Saved Billing Name ->"+AddrName.getText());
			if(AddrPhone.getText().equals(_Phone)) {
				log("Saved Billing Phone ->"+AddrPhone.getText());
				if(viewAddrAddr1.getText().equals(_AddressLine1)) {
					log("Saved Billing AddressLine1 ->"+viewAddrAddr1.getText());
					if(viewAddrAddr2.getText().equals(_AddressLine2)) {
						log("Saved Billing AddressLine ->"+viewAddrAddr2.getText());
						if(viewAddrCity.getText().equals(_City)) {
							log("Saved Billing City ->"+viewAddrCity.getText());
							if(viewAddrState.getText().equals(_State)) {
								log("Saved Billing State ->"+viewAddrState.getText());
								if(viewAddrPostcode.getText().equals(_Postcode)) {
									log("Saved Billing Postcode ->"+viewAddrPostcode.getText());
									if(viewAddrCountry.getText().equals(_Country)) {
										log("Saved Billing Country ->"+viewAddrCountry.getText());
										status="PASS";
										log("Address saved success and displayed correctly");
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

	
	public String verifySavedBillingAddresses_Company(String _Name,String _Phone,String _AddressLine1,String _AddressLine2,
			String _City,String _State,String _Postcode,String _Country) {
		status="FAIL";
		if(AddrName.getText().equals(_Name)) {
			log("Saved Billing Name ->"+AddrName.getText());
			if(AddrPhone.getText().equals(_Phone)) {
				log("Saved Billing Phone ->"+AddrPhone.getText());
				if(viewAddrAddr1.getText().equals(_AddressLine1)) {
					log("Saved Billing AddressLine1 ->"+viewAddrAddr1.getText());
					if(viewAddrAddr2.getText().equals(_AddressLine2)) {
						log("Saved Billing AddressLine ->"+viewAddrAddr2.getText());
						if(viewAddrCity.getText().equals(_City)) {
							log("Saved Billing City ->"+viewAddrCity.getText());
							if(viewAddrState.getText().equals(_State)) {
								log("Saved Billing State ->"+viewAddrState.getText());
								if(viewAddrPostcode.getText().equals(_Postcode)) {
									log("Saved Billing Postcode ->"+viewAddrPostcode.getText());
									if(viewAddrCountry.getText().equals(_Country)) {
										log("Saved Billing Country ->"+viewAddrCountry.getText());
										status="PASS";
										log("Address saved success and displayed correctly");
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
	
	/*Entered Company Name*/
	
	public void Company_Name(String _CompanyName) throws InterruptedException{
		status="FAIL";
		Thread.sleep(1000);
		textbox_comapanyName.click();
		textbox_comapanyName.sendKeys(_CompanyName);
		log("Entered Company Name");
		
		status="PASS";
	}
	
	
	
	/*Entered Private Person Name*/
	
	public void Private_Name(String _PrivatShortName) throws InterruptedException{
		status="FAIL";
		Thread.sleep(1000);
		textbox_Privatename.click();
		textbox_Privatename.sendKeys(_PrivatShortName);
		log("Entered Private person Name");
		status="PASS";
	}
	
	/*Verify Discard Confirmation Message*/
	
	@FindBy(how=How.XPATH,using ="//h1[@class='ng-binding']")
	WebElement discardConfirmationMessage;
	public String verify_Discard_ConfirmationMessage(String _DiscardConfirmation) throws InterruptedException {
		Thread.sleep(3000);

		status="FAIL";
		
		if(discardConfirmationMessage.getText().equals(_DiscardConfirmation)) {
			log(discardConfirmationMessage.getText()+" is displayed");
			takeScreenShot();
			status="PASS";
		}
		return status;
		
		
	}
	
	/*Clicked On "X" Button In Discard Confirmation Popup*/
	
	@FindBy(how=How.XPATH,using ="//i[@class='ssp-icon_close']")
	WebElement X_Button;
	public void clickOn_X_DiscardConfirmationPopUp() throws InterruptedException {
		Thread.sleep(2000);
	
		X_Button.click();
		log("Clicked on the X button In Discard Confirmation PopUp");
		takeScreenShot();
		
	}
	
	/*Clicked On No Button In Discard Confirmation Popup*/
	
	@FindBy(how=How.XPATH,using =".//*[@id='btnCancel']")
	WebElement NoButton;
	public void clickOnNoDiscardConfirmationPopUp() throws InterruptedException {
		Thread.sleep(2000);
	
		NoButton.click();
		log("Clicked on the No button In Discard Confirmation Popup");
		takeScreenShot();
		
	}
	
	/*Clicked On Yes Button In Discard Confirmation Popup*/
	
	@FindBy(how=How.XPATH,using ="//button[@id='btnOk']")
	WebElement YesButton_;
	public void clickOnYesDiscardConfirmationPopUp_() throws InterruptedException {
		Thread.sleep(2000);
	
		YesButton_.click();
		log("Clicked on the Yes button In Discard Confirmation Popup, Page navigated to Dashboard Page");
		takeScreenShot();
		
	}
	
	@FindBy(how=How.XPATH,using ="//div[@class='col-xs-4 col-sm-3 col-md-3 col-lg-3 pl-0 pr-0 hidden-xs']//div[@class='ssp-icon_trash']")
	WebElement Delete__Address_link;
	public void clickOn_Delete_Address_Button() throws InterruptedException {
		
	    Thread.sleep(7000);
	    Delete__Address_link.click();
		log("Clicked on the Delete button");
		takeScreenShot();
		
	}
	
	
	/*Verify Delete Confirmation Message*/
	
	@FindBy(how=How.XPATH,using ="//h1[@class='ng-binding']")
	WebElement Delete_Confirmation_Message;
	public String verify_Delete_ConfirmationMessage(String _DeleteConfirmation) throws InterruptedException {
		Thread.sleep(3000);

		status="FAIL";
		
		if(Delete_Confirmation_Message.getText().equals(_DeleteConfirmation)) {
			log(Delete_Confirmation_Message.getText()+" is displayed");
			takeScreenShot();
			status="PASS";
		}
		return status;
		
		
	}
	
	
/*Clicked On "X" Button In Delete Confirmation Popup*/
	
	@FindBy(how=How.XPATH,using ="//i[@class='ssp-icon_close']")
	WebElement X_Button_In_Delete_Popup;
	public void clickOn_X_DeleteConfirmationPopUp() throws InterruptedException {
		Thread.sleep(2000);
	
		X_Button_In_Delete_Popup.click();
		log("Clicked on the X button In Delete Confirmation PopUp");
		takeScreenShot();
		
	}
	
	/*Clicked On No Button In Delete Confirmation Popup*/
	
	@FindBy(how=How.XPATH,using =".//*[@id='btnCancel']")
	WebElement NoButton_In_Delete_Popup;
	public void clickOnNoDeleteConfirmationPopUp() throws InterruptedException {
		Thread.sleep(2000);
	
		NoButton_In_Delete_Popup.click();
		log("Clicked on the No button In Delete Confirmation Popup");
		takeScreenShot();
		
	}
	
	/*Clicked On Yes Button In Delete Confirmation Popup*/
	
	@FindBy(how=How.XPATH,using ="//button[@id='btnOk']")
	WebElement YesButton_In_Delete_Popup;
	public void clickOnYesDeleteConfirmationPopUp() throws InterruptedException {
		Thread.sleep(2000);
	
		YesButton_In_Delete_Popup.click();
		log("Clicked on the Yes button In Delete Confirmation Popup");
		takeScreenShot();
		
	}
	
	
	/*Verify Address Delete Successfully*/
	
	@FindBy(how=How.XPATH,using =".//*[@id='parkersToast']/div/div[1]/div")
	WebElement DeletesuccessfulMessage;
	
	public String VerifyAddressDeleteSuccessfulMessage(String _SuccessfulMessage ) throws InterruptedException {
		status="FAIL";
		Thread.sleep(100);
		String AddressDeletesuccessfulMesseges=DeletesuccessfulMessage.getText().trim();
		if(AddressDeletesuccessfulMesseges.contains(_SuccessfulMessage)) {
			log("Address Deleted Successfully Message  -->"+ AddressDeletesuccessfulMesseges);
			status="PASS";
			takeScreenShot();
		}
		Thread.sleep(2000);
		return status;
	}
	
	/*Verify Address Added Successfully*/
	
	@FindBy(how=How.XPATH,using ="//strong[@class='ng-binding']")
	WebElement AddsuccessfulMessage;
	
	public String VerifyAddressAddSuccessfulMessage(String _SuccessfulMessage ) throws InterruptedException {
		status="FAIL";
		//Thread.sleep(100);
        WebElement loader = driver.findElement(By.xpath("//div[@class='loader']"));
		
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeInvisible(loader, driver, 30);
		
		wh.waitForElementToBeVisible(AddsuccessfulMessage, driver, 10);
		String AddressAddsuccessfulMesseges=AddsuccessfulMessage.getText().trim();
		if(AddressAddsuccessfulMesseges.contains(_SuccessfulMessage)) {
			log("Address Added Successfully Message  -->"+ AddressAddsuccessfulMesseges);
			status="PASS";
			takeScreenShot();
		}
		Thread.sleep(2000);
		return status;
	}

}



