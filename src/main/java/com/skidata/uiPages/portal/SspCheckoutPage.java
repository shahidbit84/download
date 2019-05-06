/**
 *
 */
package com.skidata.uiPages.portal;

import java.awt.AWTException;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.helperclasses.DateAndUniqueNoGenerateHelper;
import com.skidata.helperclasses.JavaScriptHelper;
import com.skidata.helperclasses.WaitHelper;
import com.skidata.testBase.TestBase;

/**
 * @author shmo
 * 
 */
public class SspCheckoutPage extends TestBase {



	String status=null;


	public static final Logger log = Logger.getLogger(SspCheckoutPage.class.getName());

	JavaScriptHelper js;

	//Class constructor
	public SspCheckoutPage(WebDriver driver,ExtentTest test) {
		this.test=test;
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}


	@FindBys({	
		@FindBy(how=How.ID, using="logo"),
	})	public List<WebElement> allElementsInList_LogoImage;

	@FindBy(how=How.XPATH,using ="//a[@id='goToHome1']/div")
	WebElement label_HomeIcon;

	@FindBy(how=How.XPATH,using ="//a[@id='goToCart1']/div")
	WebElement label_CartIcon;

	@FindBy(how=How.XPATH,using ="//a[@id='goToLogin']/div")
	WebElement label_LoginIcon;

	@FindBy(how=How.XPATH,using ="//div[@class='emptyCartMsg']//h2")
	WebElement label_EmptyCartMsg;

	@FindBy(how=How.XPATH,using ="//button[@id='btnGoToCheckOut']")
	WebElement button_CHECKOUT;

	@FindBy(how=How.XPATH,using ="//a[@id='login']/div")
	WebElement link_Login_InCheckoutPage;

	@FindBy(how=How.XPATH,using ="//div[@id='mydiv']//div[@class='loader']")
	WebElement loader;


	@FindBy(how=How.XPATH,using ="//a[@id='goToProducts']/div")
	WebElement link_ContinueShopping;

    @FindBy(how=How.XPATH, using ="//div[@class='noIdentifications ng-scope' and @translate='_CheckOutNoIdentifications_']")
    WebElement Identification_BarCode_Generate_Text;


	/**
	 *****************************************************************************************************************
	 * Method to verify the Page Title
	 * @param _PageTitle
	 * @return
	 * @throws InterruptedException 
	 *****************************************************************************************************************
	 */
	public String verifyPageTitle(String _PageTitle) throws InterruptedException {
		status="FAIL";
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeInvisible(loader, driver, 20);
		Thread.sleep(5000);
		log(driver.getTitle());
		if(driver.getTitle().equals(_PageTitle)) {
			log("Title of the page is "+driver.getTitle());
			status="PASS";
			//takeScreenShot();
		}
		return status;
	}

	/**
	 *****************************************************************************************************************
	 * Method to verify if logo is displayed in UI
	 * @return PASS or FAIL
	 * @throws InterruptedException 
	 *****************************************************************************************************************
	 */
	public String verifyLogoDisplayed() throws InterruptedException {
		status="FAIL";

		if(allElementsInList_LogoImage.size()==1) {
			log("Logo image is displayed in Product List page");
			WebElement logo = driver.findElement(By.id("logo"));
			highlightWebElement(driver, logo);
			takeScreenShot();
			status="PASS";
		}
		return status;


	}




	public void clickonContinueShoppingLink() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeInvisible(loader, driver, 30);
		link_ContinueShopping.click();
		log("clicked on < Continue shopping link");
		takeScreenShot();

	}



	public void clickOnLoginLinkInCheckoutScreen() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(link_Login_InCheckoutPage, driver, 30);
		clickElementUsingJavaScript(link_Login_InCheckoutPage);
		log("Clicked on the Login link in the Checkout page");
		takeScreenShot();

	}

	public String verifyContinueShoppingLink(String _ContinueShoppingLink) throws InterruptedException {
		status="FAIL";
		if(link_ContinueShopping.getText().equals(_ContinueShoppingLink)) {
			status="PASS";
			takeScreenShot();
			log(link_ContinueShopping.getText()+" is displayed in UI");
		}
		return status;
	}




	@FindBy(how=How.XPATH,using ="//form[@id='paymentForm']//h1")
	WebElement pageHeader_Checkout;

	@FindBy(how=How.XPATH,using ="//h2[@translate='_YourDetails_']")
	WebElement label_YourDetails;

	@FindBy(how=How.XPATH,using ="//a[@class='already-registred ng-binding' and @id='alRegistered']")
	WebElement label_AreYouAlreadyregistered;

	@FindBy(how=How.XPATH,using ="//a[@id='login']/div")
	WebElement link_Login;

	@FindBy(how=How.XPATH,using ="//label[@class='checkbox-inline add-address-optionally ng-binding']//*[@id='addAddressOptionally']")
	WebElement label_AddAddressOptionally;

	@FindBy(how=How.XPATH,using ="//h2[@translate='_Identification_']")
	WebElement label_Identification;



	@FindBy(how=How.XPATH,using ="//button[@id='btnPay']")
	WebElement button_Pay;

	@FindBy(how=How.XPATH,using ="//div[@class='termAndConditions']//label[@class='checkbox-inline-tc-pp']//div//a[@class='ng-binding'][contains(text(),'Terms & Conditions')]")
	WebElement label_TermsAndCondition;
	@FindBy(how=How.XPATH,using ="//div[@class='termAndConditions']//label[@class='checkbox-inline-tc-pp']//div//a[@class='ng-binding'][contains(text(),'Privacy Policy')]")
	WebElement label_PrivacyPolicy;
	
	public String verifyLabelsInCheckoutPageForReservation(String _CheckoutHeader,String _LabelYourDetails,String _LabelAreyouregistered,
			String _LoginLinkText,String _AddAddressOptionally,String _IdentificationLabel,String _TermsAndCondition,String _PrivacyPolicy) {

		status="FAIL";
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeInvisible(loader, driver, 20);
		if(pageHeader_Checkout.getText().equals(_CheckoutHeader)) {
			log(pageHeader_Checkout.getText()+" is displayed in UI");
			if(label_YourDetails.getText().equals(_LabelYourDetails)) {
				log(label_YourDetails.getText()+" is displayed in UI");
				if(label_AreYouAlreadyregistered.getText().equals(_LabelAreyouregistered)) {
					log(label_AreYouAlreadyregistered.getText()+" is displayed in UI");
					if(link_Login.getText().equals(_LoginLinkText)) {
						log(link_Login.getText()+" is displayed in UI");
						log(label_AddAddressOptionally.getText());
						
							if(label_Identification.getText().equals(_IdentificationLabel)) {
								log(label_Identification.getText()+" is displayed in UI");
								
//								if(label_TermsAndCondition.getText().equals(_TermsAndCondition))
//									log(label_TermsAndCondition.getText()+" is displayed in UI");
//									if(label_PrivacyPolicy.getText().equals(_PrivacyPolicy)) {
//										log(label_PrivacyPolicy.getText()+" is displayed in UI");
									status="PASS";
									takeScreenShot();
								}
							}
						}
					}
				}
//			}
	
		return status;

	}




	@FindBy(how=How.XPATH,using ="//h3[@translate='_BookingSummary_']")
	WebElement label_BookingSummary;

	@FindBy(how=How.XPATH,using ="//*[@class='all-taxes']//h3")
	WebElement label_ValueAddedTax;

	@FindBy(how=How.XPATH,using ="//h3[@translate='_GrossPrice_']")
	WebElement label_GrossPrice;

	@FindBy(how=How.XPATH,using ="//div[@translate='_BackToCart_']")
	WebElement label_BackToCart;



	public String verifyLabelsInCheckoutPageBookingSummary(String _BookingsummaryLabel,String _ValueAddedTaxesLabel,
			String _TotalLabel,String _label_BackToCart) {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeInvisible(loader, driver, 30);
		log(label_BookingSummary.getText());
		//		log(label_ValueAddedTax.getText()); Product not stable to automate as change is happening 17-06-2018
		//		log(label_GrossPrice.getText());

		status="FAIL";
		if(label_BookingSummary.getText().equals(_BookingsummaryLabel)) {
			log(label_BookingSummary.getText()+" is displayed");
			//	if(label_ValueAddedTax.getText().equals(_ValueAddedTaxesLabel)) {
			//				log(label_ValueAddedTax.getText()+" is displayed");
				//		if(label_GrossPrice.getText().equals(_TotalLabel)) {
			//					log(label_GrossPrice.getText()+" is displayed");

			if(label_BackToCart.getText().equals(_label_BackToCart)) {
				log("label "+label_BackToCart.getText()+" is displayed ");
				status="PASS";
				takeScreenShot();
			}


		}
		//}
		//}
		return status;


	}

	@FindBy(how=How.XPATH,using ="//input[@id='txtEmail']")
	WebElement input_Email;

	public void enterEmailId(String _EmailId) throws InterruptedException {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeInvisible(loader, driver, 10);
		Thread.sleep(5000);
		sendKeys(input_Email, _EmailId);

		log("Entered the email as "+_EmailId);
		//takeScreenShot();

	}

	@FindBy(how=How.XPATH,using ="//md-select[@id='idnDrpAccessMediaType']")
	WebElement dropdown_Identification;

	@FindBy(how=How.ID,using ="idnTxtField1")
	WebElement input_IdentificationValueField;

	public void addIdentification(String _Identification,String _IdentificationValue) throws InterruptedException {

		clickElementUsingJavaScript(dropdown_Identification);
		List<WebElement> list = driver.findElements(By.xpath("//md-option[contains(@id,'select_option_')]"));

		for(int i=0;i<list.size();i++) {


			if(driver.findElement(By.xpath("//md-option[contains(@id,'select_option_')]")).getText().equals(_Identification)) {
				driver.findElement(By.xpath("//md-option[contains(@id,'select_option_')]")).click();
				log("Selected the value from Drop down as "+_Identification);
				input_IdentificationValueField.click();
				Thread.sleep(2000);
				input_IdentificationValueField.sendKeys(_IdentificationValue);
				log("Entered the Identification value "+_IdentificationValue);
				break;
			}


		}

	}

	public void clickOnPay() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(button_Pay, driver, 20);
		clickElementUsingJavaScript(button_Pay);
		log("Clicked on the PAY button");

	}

	@FindBy(how=How.XPATH,using ="//div[@class='add-another-identification-link']")
	WebElement link_AddAnotherIdentification;
	
	@FindBy(how=How.XPATH,using ="//h2[@translate='_Identification_']")
	WebElement identificationslabel;
	
	
	public String verifyAddAnotherIdentificationLinkDisplayed(String _AddAnotherIdentification) {
		status="FAIL";
		identificationslabel.click();
		
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementVisiblity(driver, 20, link_AddAnotherIdentification);

		if(link_AddAnotherIdentification.getText().equals(_AddAnotherIdentification)) {
			log(link_AddAnotherIdentification.getText()+" is displayed in UI");
			takeScreenShot();
			status="PASS";
		}
		return status;

	}

	public void clickOnAddAnotherIdentification() {
		
		identificationslabel.click();
		
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(link_AddAnotherIdentification, driver, 30);
		
		link_AddAnotherIdentification.click();
		
		log("Clicked on Add another Identification");
		takeScreenShot();

	}

	@FindBy(how=How.XPATH,using ="//*[@id='idnDrpAccessMediaType0']")
	WebElement dropdown_AccessMediaType;

	public String addIdentificationDetails_SingleProduct_Old(String _AdditionalIdentification) throws InterruptedException, AWTException {
		status="FAIL";

		log("Enter Identifications details");
		WebElement input_IdentificationValueFieldID;
		String uniqueNo;

		WebElement dropDown = driver.findElement(By.xpath("//*[@id='idnDrpAccessMediaType0']"));
		clickElementUsingJavaScript(dropDown);
		Thread.sleep(2000);
		String iD = driver.findElement(By.xpath("//*[@id='idnDrpAccessMediaType0']")).getAttribute("aria-owns");
		WebElement selectID = driver.findElement(By.xpath("//*[@id='"+iD+"']//md-option//div[1][contains(text(),'"+_AdditionalIdentification+"')]"));

		clickElementUsingJavaScript(selectID);
		Thread.sleep(2000);

		log("Selected the id as "+_AdditionalIdentification);

		Thread.sleep(3000);
		DateAndUniqueNoGenerateHelper dateAndUniqNo = new DateAndUniqueNoGenerateHelper();

		if(_AdditionalIdentification.equals("Skidata keycard")) {
			//input_IdentificationValueField.click();
			//Thread.sleep(2000);
			uniqueNo =dateAndUniqNo.generateUniqueNo();

			input_IdentificationValueFieldID = driver.findElement(By.xpath("//*[@id='idnTxtField10']"));
			sendKeys(input_IdentificationValueFieldID, uniqueNo);
			log("Identification entered as "+uniqueNo);
			return uniqueNo;


		}else if(_AdditionalIdentification.equals("Deister Tag")) {

			Thread.sleep(2000);
			uniqueNo =dateAndUniqNo.generateUniqueNo();

			input_IdentificationValueFieldID = driver.findElement(By.xpath("//*[@id='idnTxtField10']"));
			sendKeys(input_IdentificationValueFieldID, uniqueNo);
			log("Identification entered as "+uniqueNo);
			return uniqueNo;

		}else if(_AdditionalIdentification.equals("Mifare card")) {

			Thread.sleep(2000);
			uniqueNo ="MIC"+dateAndUniqNo.generateUniqueNo();
			input_IdentificationValueFieldID = driver.findElement(By.xpath("//*[@id='idnTxtField10']"));
			sendKeys(input_IdentificationValueFieldID, uniqueNo);
			log("Identification entered as "+uniqueNo);
			return uniqueNo;

		}
		else if(_AdditionalIdentification.equals("Skidata")) {

			Thread.sleep(2000);
			uniqueNo =dateAndUniqNo.generateUniqueNo();
			driver.findElement(By.xpath("//*[@id='idnTxtField10']")).sendKeys(uniqueNo);
			Thread.sleep(2000);
			log("Identification entered as "+uniqueNo);
			return uniqueNo;
		}
		else if(_AdditionalIdentification.equals("NFC")) {

			Thread.sleep(2000);
			uniqueNo ="NFC"+dateAndUniqNo.generateUniqueNo();
			driver.findElement(By.xpath("//*[@id='idnTxtField10']")).sendKeys(uniqueNo);
			Thread.sleep(2000);
			log("Identification entered as "+uniqueNo);
			return uniqueNo;
		}
		else if(_AdditionalIdentification.equals("Grafos Pinpad")) {
			Thread.sleep(2000);
			log("Grafos Pinpad selected");
			return null;

		}
		else if(_AdditionalIdentification.equals("License plate")) {
			uniqueNo ="LP"+dateAndUniqNo.generateUniqueNo();
			driver.findElement(By.xpath("//*[@id='idnCarType0']")).sendKeys("BMW");
			pressTab();
			driver.findElement(By.xpath("//*[@id='idnTxtField10']")).sendKeys(uniqueNo);
			Thread.sleep(2000);
			log("License Plate selected");
			return uniqueNo;

		}
		else {
			log("No Common Id is displayed for the products selected");
			return null;
		}





	}
	
	
	
	//////////////////////////////////////
	
	
	  @FindBy(how=How.XPATH, using ="//div[@class='noIdentifications ng-scope' and @translate='_CheckOutNoIdentifications_']")
	    WebElement Identification_BarCode_Generate_Text_2;
	
	public String addIdentificationDetails_SingleProduct(String _AdditionalIdentification) throws InterruptedException, AWTException {
		status="FAIL";
		
		
		int elementfound = driver.findElements(By.xpath("//div[@class='noIdentifications ng-scope' and @translate='_CheckOutNoIdentifications_']")).size();

		
		if(elementfound>0) {
			log("Use this e-ticket to access the reservation is displayed");
		}
		
		//
		else {	
			
		log("Enter Identifications details");
		WebElement input_IdentificationValueFieldID;
		String uniqueNo;

		WebElement dropDown = driver.findElement(By.xpath("//*[@id='idnDrpAccessMediaType0']"));
		clickElementUsingJavaScript(dropDown);
		Thread.sleep(2000);
		String iD = driver.findElement(By.xpath("//*[@id='idnDrpAccessMediaType0']")).getAttribute("aria-owns");
		WebElement selectID = driver.findElement(By.xpath("//*[@id='"+iD+"']//md-option//div[1][contains(text(),'"+_AdditionalIdentification+"')]"));

		clickElementUsingJavaScript(selectID);
		Thread.sleep(2000);

		log("Selected the id as "+_AdditionalIdentification);

		Thread.sleep(3000);
		DateAndUniqueNoGenerateHelper dateAndUniqNo = new DateAndUniqueNoGenerateHelper();

		if(_AdditionalIdentification.equals("Skidata keycard")) {
			//input_IdentificationValueField.click();
			//Thread.sleep(2000);
			uniqueNo =dateAndUniqNo.generateUniqueNo();

			input_IdentificationValueFieldID = driver.findElement(By.xpath("//*[@id='idnTxtField10']"));
			sendKeys(input_IdentificationValueFieldID, uniqueNo);
			log("Identification entered as "+uniqueNo);
			return uniqueNo;


		}else if(_AdditionalIdentification.equals("Deister Tag")) {

			Thread.sleep(2000);
			uniqueNo =dateAndUniqNo.generateUniqueNo();

			input_IdentificationValueFieldID = driver.findElement(By.xpath("//*[@id='idnTxtField10']"));
			sendKeys(input_IdentificationValueFieldID, uniqueNo);
			log("Identification entered as "+uniqueNo);
			return uniqueNo;

		}else if(_AdditionalIdentification.equals("Mifare card")) {

			Thread.sleep(2000);
			uniqueNo ="MIC"+dateAndUniqNo.generateUniqueNo();
			input_IdentificationValueFieldID = driver.findElement(By.xpath("//*[@id='idnTxtField10']"));
			sendKeys(input_IdentificationValueFieldID, uniqueNo);
			log("Identification entered as "+uniqueNo);
			return uniqueNo;

		}
		else if(_AdditionalIdentification.equals("Skidata")) {

			Thread.sleep(2000);
			uniqueNo =dateAndUniqNo.generateUniqueNo();
			driver.findElement(By.xpath("//*[@id='idnTxtField10']")).sendKeys(uniqueNo);
			Thread.sleep(2000);
			log("Identification entered as "+uniqueNo);
			return uniqueNo;
		}
		else if(_AdditionalIdentification.equals("NFC")) {

			Thread.sleep(2000);
			uniqueNo ="NFC"+dateAndUniqNo.generateUniqueNo();
			driver.findElement(By.xpath("//*[@id='idnTxtField10']")).sendKeys(uniqueNo);
			Thread.sleep(2000);
			log("Identification entered as "+uniqueNo);
			return uniqueNo;
		}
		else if(_AdditionalIdentification.equals("Grafos Pinpad")) {
			Thread.sleep(2000);
			log("Grafos Pinpad selected");
			return null;

		}
		else if(_AdditionalIdentification.equals("License plate")) {
			uniqueNo ="LP"+dateAndUniqNo.generateUniqueNo();
			driver.findElement(By.xpath("//*[@id='idnCarType0']")).sendKeys("BMW");
			pressTab();
			driver.findElement(By.xpath("//*[@id='idnTxtField10']")).sendKeys(uniqueNo);
			Thread.sleep(2000);
			log("License Plate selected");
			return uniqueNo;

		}
		
		
		else {
			log("No Common Id is displayed for the products selected");
			
			return null;
		}
		
		}
		return status;

	}
	////////////////////////////////////////////////////////////
	
	

	public String addIdentificationDetails(String _AdditionalIdentification) throws InterruptedException {
		status="FAIL";
		String uniqueNo;

		List<WebElement> accessMediaType = driver.findElements(By.xpath("//md-select[@id='idnDrpAccessMediaType']"));

		if(accessMediaType.size()==1) {



			clickElementUsingJavaScript(dropdown_Identification);
			Thread.sleep(5000);
			DateAndUniqueNoGenerateHelper dateAndUniqNo = new DateAndUniqueNoGenerateHelper();


			List<WebElement> displayedAdditionalIdnt = driver.findElements(By.xpath("//md-option[contains(@id,'select_option_')]"));
			for(int j =0;j<displayedAdditionalIdnt.size();j++) {
				if(displayedAdditionalIdnt.get(j).getText().equals(_AdditionalIdentification)) {
					displayedAdditionalIdnt.get(j).click();
					log(_AdditionalIdentification+" is selected");
					break;
				}
			}

			if(_AdditionalIdentification.equals("Skidata keycard")) {
				input_IdentificationValueField.click();
				Thread.sleep(2000);
				uniqueNo =dateAndUniqNo.generateUniqueNo();
				sendKeys(input_IdentificationValueField, uniqueNo);

				log("Identification entered as "+uniqueNo);
				return uniqueNo;

			}else if(_AdditionalIdentification.equals("Deister Tag")) {
				input_IdentificationValueField.click();
				Thread.sleep(2000);
				uniqueNo =dateAndUniqNo.generateUniqueNo();
				sendKeys(input_IdentificationValueField, uniqueNo);
				log("Identification entered as "+uniqueNo);
				return uniqueNo;
			}else if(_AdditionalIdentification.equals("License plate")) {
				input_IdentificationValueField.click();
				Thread.sleep(2000);
				uniqueNo ="LP"+dateAndUniqNo.generateUniqueNo();
				sendKeys(input_IdentificationValueField, uniqueNo);
				log("Identification entered as "+uniqueNo);
				return uniqueNo;
			}else if(_AdditionalIdentification.equals("Mifare card")) {
				input_IdentificationValueField.click();
				Thread.sleep(2000);
				uniqueNo ="MIC"+dateAndUniqNo.generateUniqueNo();
				sendKeys(input_IdentificationValueField, uniqueNo);
				log("Identification entered as "+uniqueNo);
				return uniqueNo;
			}
			else if(_AdditionalIdentification.equals("Skidata")) {
				input_IdentificationValueField.click();
				Thread.sleep(2000);
				uniqueNo =dateAndUniqNo.generateUniqueNo();
				sendKeys(input_IdentificationValueField, uniqueNo);
				log("Identification entered as "+uniqueNo);
				return uniqueNo;
			}
			else if(_AdditionalIdentification.equals("NFC")) {
				input_IdentificationValueField.click();
				Thread.sleep(2000);
				uniqueNo ="NFC"+dateAndUniqNo.generateUniqueNo();
				sendKeys(input_IdentificationValueField, uniqueNo);
				log("Identification entered as "+uniqueNo);
				return uniqueNo;
			}
			else if(_AdditionalIdentification.equals("Grafos Pinpad")) {
				Thread.sleep(2000);
				log("Grafos Pinpad selected");
				return null;
			}else {
				return null;
			}

		}else {
			log("No Common Id is displayed for the products selected");
			return null;
		}






	}

	public String addIdentificationDetails(String _AdditionalIdentification,String _IDValue) throws InterruptedException {
		status="FAIL";

		clickElementUsingJavaScript(dropdown_Identification);
		Thread.sleep(5000);

		List<WebElement> displayedAdditionalIdnt = driver.findElements(By.xpath("//md-option[contains(@id,'select_option_')]"));
		for(int j =0;j<displayedAdditionalIdnt.size();j++) {
			if(displayedAdditionalIdnt.get(j).getText().equals(_AdditionalIdentification)) {
				displayedAdditionalIdnt.get(j).click();
				log(_AdditionalIdentification+" is selected");
				break;
			}
		}

		if(_AdditionalIdentification.equals("Skidata keycard")) {
			input_IdentificationValueField.click();
			Thread.sleep(3000);
			sendKeys(input_IdentificationValueField, _IDValue);

			Thread.sleep(3000);
			log("Identification entered as "+_IDValue);
			return _IDValue;

		}else if(_AdditionalIdentification.equals("Deister Tag")) {
			input_IdentificationValueField.click();
			Thread.sleep(3000);
			sendKeys(input_IdentificationValueField, _IDValue);

			log("Identification entered as "+_IDValue);
			return _IDValue;
		}else if(_AdditionalIdentification.equals("License plate")) {
			input_IdentificationValueField.click();
			Thread.sleep(3000);
			sendKeys(input_IdentificationValueField, _IDValue);

			log("Identification entered as "+_IDValue);
			return _IDValue;
		}else if(_AdditionalIdentification.equals("Mifare card")) {
			input_IdentificationValueField.click();
			Thread.sleep(3000);
			sendKeys(input_IdentificationValueField, _IDValue);

			log("Identification entered as "+_IDValue);
			return _IDValue;
		}else {
			return null;
		}







	}

	public void deleteAllAddedIdentifications() {

		List<WebElement> deleteIcons = driver.findElements(By.xpath("//span[@class='ssp-icon_trash']"));

		for(int i=0;i<deleteIcons.size();i++) {
			driver.findElement(By.xpath("//span[@class='ssp-icon_trash']")).click();
			log("Deleted the Identification");
		}

	}

	@FindBy(how=How.XPATH,using ="//a[@translate='_Cancel_']")
	WebElement link_Cancel;
	public void clickonCancelAddIdentification() {
		link_Cancel.click();
		log("Clicked on the Cancel Button");
		takeScreenShot();

	}


	public String verifyBookingSummary_ProductName_ProductPrice(String _ExpectedProdName,String _ExpectedProdPrice) {

		status="FAIL";

		String bookingSummary_ProdName = driver.findElement(By.xpath("//div[@class='products-detail']//h3")).getText();
		String bookingSummary_ProdPrice= driver.findElement(By.xpath("//div[@class='products-detail']//div[@class='price ng-binding']")).getText();
		if(bookingSummary_ProdName.equals(_ExpectedProdName)) {
			log("Product name is displayed as "+bookingSummary_ProdName);
			if(bookingSummary_ProdPrice.equals(_ExpectedProdPrice)) {
				log("Product price is displayed as "+bookingSummary_ProdPrice);
				takeScreenShot();
				status="PASS";
			}
		}
		return status;


	}

	public String verifyFromToValuesInBookingSummary(String fromTimeExpected, String toTimeExpected) {
		status="FAIL";

		String fromdateMonthYear = driver.findElement(By.xpath("//div[@class='products-detail']//div[1][@class='date-time']//div[@class='date ng-binding']")).getText();

		String fromseparator= driver.findElement(By.xpath("//div[@class='products-detail']//div[1][@class='date-time']//span[@class='separator']")).getText();

		String fromtime= driver.findElement(By.xpath("//div[@class='products-detail']//div[1][@class='date-time']//div[@class='time ng-binding']")).getText();

		String actualFromDateTimeInBookingSummary =fromdateMonthYear+" "+fromseparator+" "+fromtime;

		String todateMonthYear = driver.findElement(By.xpath("//div[@class='products-detail']//div[2][@class='date-time']//div[@class='date ng-binding']")).getText();

		String toseparator= driver.findElement(By.xpath("//div[@class='products-detail']//div[2][@class='date-time']//span[@class='separator']")).getText();

		String totime= driver.findElement(By.xpath("//div[@class='products-detail']//div[2][@class='date-time']//div[@class='time ng-binding']")).getText();

		String actualToDateTimeInBookingSummary =todateMonthYear+" "+toseparator+" "+totime;


		if(actualFromDateTimeInBookingSummary.equals(fromTimeExpected)) {
			if(actualToDateTimeInBookingSummary.equals(toTimeExpected)) {
				log("FROM: "+actualFromDateTimeInBookingSummary +" is displayed in booking summary");
				log("TO: "+actualToDateTimeInBookingSummary +" is displayed in booking summary");
				takeScreenShot();
				status="PASS";
			}
		}



		return status;
	}

	public String verifyValueAddedTaxes_AndTotalAmountInBookingSummary(String _TotalValue) {
		status ="FAIL";

		WebElement prices = driver.findElement(By.xpath("//div[@class='total-price']//div[@data-ng-bind='summaryInfo.totalPrice']"));


		if(prices.getText().equals(_TotalValue)) {
			log("Total value is ->"+prices.getText());
			status="PASS";
			takeScreenShot();
		}

		return status;
	}



	@FindBy(how=How.XPATH,using ="//div[@data-i18n='_BackToCart_']")
	WebElement link_BackToCart;
	public void clickOnBackToCart() {
		link_BackToCart.click();
		log("Clicked on Back to Cart");

	}

	@FindBy(how=How.XPATH,using ="//div[@class='md-input-message-animation ng-binding ng-scope']")
	WebElement errorMessage_InvalidId;

	




	public String verifyErrorMsgForInvalidIdValue(String _IDValue,String _ErrorMessage) {
		status="FAIL";

		String[] idValuesToCheck = _IDValue.split("---");

		for(int i=0;i<idValuesToCheck.length;i++) {
			input_IdentificationValueField.sendKeys(idValuesToCheck[i]);
			status="FAIL";
			if((errorMessage_InvalidId.getText()).equals(_ErrorMessage)) {
				log((errorMessage_InvalidId.getText())+" is displayed for id "+idValuesToCheck[i]);

				input_IdentificationValueField.clear();
				if((errorMessage_InvalidId.getText()).equals(_ErrorMessage)) {
					status="PASS";
				}

			}else {
				return status;
			}

		}
		return status;

	}





	public String selectAccessMediaType_verifyErrorMsg_SingleProd(String _AdditionalIdentification,String _IdValue,String _ErrorMsg) throws InterruptedException, AWTException {

		status="FAIL";

		WebElement input_IdentificationValueFieldID;


		WebElement dropDown = driver.findElement(By.xpath("//*[@id='idnDrpAccessMediaType0']"));
		clickElementUsingJavaScript(dropDown);
		Thread.sleep(2000);
		String iD = driver.findElement(By.xpath("//*[@id='idnDrpAccessMediaType0']")).getAttribute("aria-owns");
		WebElement selectID = driver.findElement(By.xpath("//*[@id='"+iD+"']//md-option//div[1][contains(text(),'"+_AdditionalIdentification+"')]"));

		clickElementUsingJavaScript(selectID);
		Thread.sleep(2000);

		log("Selected the id as "+_AdditionalIdentification);

		Thread.sleep(3000);

		String[] idValuesToCheck = _IdValue.split("---");


		if(_AdditionalIdentification.equals(_AdditionalIdentification)) {

			input_IdentificationValueFieldID = driver.findElement(By.xpath("//*[@id='idnTxtField10']"));

			for(int i=0;i<idValuesToCheck.length;i++) {
				sendKeys(input_IdentificationValueFieldID, idValuesToCheck[i]);
				status="FAIL";
                driver.findElement(By.xpath("//h2[@translate='_Identification_']")).click();
				if((errorMessage_InvalidId.getText()).equals(_ErrorMsg)) {
					log((errorMessage_InvalidId.getText())+" is displayed for id "+idValuesToCheck[i]);
					status="PASS";
					input_IdentificationValueFieldID.clear();
				}else {
					status="FAIL";
					break;

				}
			}


		}

		else if(_AdditionalIdentification.equals("Deister Tag")) {

			input_IdentificationValueFieldID = driver.findElement(By.xpath("//*[@id='idnTxtField10']"));

			for(int i=0;i<idValuesToCheck.length;i++) {
				sendKeys(input_IdentificationValueFieldID, idValuesToCheck[i]);
				status="FAIL";

				if((errorMessage_InvalidId.getText()).equals(_ErrorMsg)) {
					log((errorMessage_InvalidId.getText())+" is displayed for id "+idValuesToCheck[i]);
					status="PASS";
					input_IdentificationValueFieldID.clear();
				}else {
					status="FAIL";
					break;

				}
			}

		}else if(_AdditionalIdentification.equals("Mifare card")) {

			input_IdentificationValueFieldID = driver.findElement(By.xpath("//*[@id='idnTxtField10']"));

			for(int i=0;i<idValuesToCheck.length;i++) {
				sendKeys(input_IdentificationValueFieldID, idValuesToCheck[i]);
				status="FAIL";

				if((errorMessage_InvalidId.getText()).equals(_ErrorMsg)) {
					log((errorMessage_InvalidId.getText())+" is displayed for id "+idValuesToCheck[i]);
					status="PASS";
					input_IdentificationValueFieldID.clear();
				}else {
					status="FAIL";
					break;

				}
			}

		}
		else if(_AdditionalIdentification.equals("Skidata")) {

			input_IdentificationValueFieldID = driver.findElement(By.xpath("//*[@id='idnTxtField10']"));

			for(int i=0;i<idValuesToCheck.length;i++) {
				sendKeys(input_IdentificationValueFieldID, idValuesToCheck[i]);
				status="FAIL";

				if((errorMessage_InvalidId.getText()).equals(_ErrorMsg)) {
					log((errorMessage_InvalidId.getText())+" is displayed for id "+idValuesToCheck[i]);
					status="PASS";
					input_IdentificationValueFieldID.clear();
				}else {
					status="FAIL";
					break;

				}
			}
		}
		else if(_AdditionalIdentification.equals("NFC")) {

			input_IdentificationValueFieldID = driver.findElement(By.xpath("//*[@id='idnTxtField10']"));

			for(int i=0;i<idValuesToCheck.length;i++) {
				sendKeys(input_IdentificationValueFieldID, idValuesToCheck[i]);
				status="FAIL";

				if((errorMessage_InvalidId.getText()).equals(_ErrorMsg)) {
					log((errorMessage_InvalidId.getText())+" is displayed for id "+idValuesToCheck[i]);
					status="PASS";
					input_IdentificationValueFieldID.clear();
				}else {
					status="FAIL";
					break;

				}
			}
		}

		else if(_AdditionalIdentification.equals("License plate")) {

			driver.findElement(By.xpath("//*[@id='idnCarType0']")).sendKeys("BMW");
			pressTab();

			input_IdentificationValueFieldID = driver.findElement(By.xpath("//*[@id='idnTxtField10']"));

			for(int i=0;i<idValuesToCheck.length;i++) {
				sendKeys(input_IdentificationValueFieldID, idValuesToCheck[i]);
				status="FAIL";

				if((errorMessage_InvalidId.getText()).equals(_ErrorMsg)) {
					log((errorMessage_InvalidId.getText())+" is displayed for id "+idValuesToCheck[i]);
					status="PASS";
					input_IdentificationValueFieldID.clear();
				}else {
					status="FAIL";
					break;

				}
			}

		}
		else {
			log("No Common Id is displayed for the products selected");
			return null;
		}


		return status;
	}










	@FindBy(how=How.XPATH,using ="//*[@id='addAddressOptionally']//div")
	WebElement checkBox_AddAddress;
	/**
	 * Method to click on the Add Address (Optionally) checkbox in the checkout page
	 */
	public void clickonAddAddress_Optionally() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(checkBox_AddAddress, driver, 30);
		clickElementUsingJavaScript(checkBox_AddAddress);
		log("Clicked on the Add Address(Optionally) checkbox");
		//takeScreenShot();

	}

	@FindBy(how=How.XPATH,using ="//md-radio-button[@value='PRIVATE']")
	WebElement radioButton_PrivatePerson;
	@FindBy(how=How.XPATH,using ="//input[@id='name']")
	WebElement input_Name_PrivatePerson;
	@FindBy(how=How.XPATH,using ="//*[@id='country' and @data-ng-model='PaymentCtrl.addAddress.country']")
	WebElement dropDown_Country;
	@FindBy(how=How.XPATH,using ="//input[@type='text' and @ng-required='searchRequired']")
	WebElement input_Address;
	@FindBy(how=How.XPATH,using ="//input[@id='phone']")
	WebElement input_Phone;

	@FindBy(how=How.XPATH,using ="//*[@id='addAddressToProfile']/div[1]")
	WebElement checkbox_AddtomyAddress;

	/**
	 * Method to input the Name,Country,Address and Phone for a Private Person - Add Address
	 * @param _Name
	 * @param _Country
	 * @param _Address
	 * @param _Phone
	 * @throws Exception 
	 */
	public void enterPrivatePersonDetails(String _Name,String _Country,String _Address,String _Phone) throws Exception {

		clickElementUsingJavaScript(radioButton_PrivatePerson);
		WaitHelper wh = new WaitHelper(driver, test);
		waitForPageLoadToComplete();
		log("Clicked on the "+radioButton_PrivatePerson.getText()+" label");
		wh.waitForElementToBeClickable(input_Name_PrivatePerson, driver, 10);
		input_Name_PrivatePerson.click();
		sendKeys(input_Name_PrivatePerson, _Name);

		clickElementUsingJavaScript(dropDown_Country);
		log("Clicked on the country dropdown");

		
		
		 List<WebElement> countries = driver.findElements(By.xpath("//md-option[@ng-repeat='country in PaymentCtrl.countryList']//div[@class='md-text ng-binding']"));
		 
		
			if(countries.size()>0) {
			for(int i=0;i<countries.size();i++) {
			
				if((countries.get(i).getText()).equals(_Country)){
					
					clickElementUsingJavaScript(countries.get(i));
					System.out.println(countries.get(i).getText());
					Thread.sleep(3000);
					break;
				}
			}
		}
			else {
				log("Country is not in the list");
				throw new Exception("Country is not in the List");
				
			}
	

		log("Selected country is "+_Country);

		sendKeys(input_Address, _Address.substring(0, 10));
		WebElement addresstoSelect = driver.findElement(By.xpath("//li[contains(@id,'typeahead-')][1]/a/div/div"));
		wh.waitForElementToBeVisible(addresstoSelect, driver, 10);
		
		clickElementUsingJavaScript(addresstoSelect);
		
		log("Entered the Address as "+ _Address);

		clickElementUsingJavaScript(input_Phone);
		input_Phone.sendKeys(_Phone);
		log("Entered the PhoneNo as "+ _Phone);

		takeScreenShot();

		js = new JavaScriptHelper(driver, test);
		js.scrollDownVertically();

	}





	@FindBy(how=How.XPATH,using ="//md-radio-button[@value='COMPANY']")
	WebElement radioButton_Company;
	@FindBy(how=How.XPATH,using ="//input[@id='companyName']")
	WebElement input_Name_Company;
	@FindBy(how=How.XPATH,using ="//input[@id='otherInformation']")
	WebElement input_OtherInformation;
	@FindBy(how=How.XPATH,using ="//input[@id='vat']")
	WebElement input_VATNO;
	@FindBy(how=How.XPATH,using ="//*[@id='country' and @data-ng-model='PaymentCtrl.addAddress.country']")
	WebElement dropDown_CountryCompany;

	/**
	 * Method to input the Name,Country,Address and Phone for a Private Person - Add Address
	 * @param _Name
	 * @param _Country
	 * @param _Address
	 * @param _Phone
	 * @throws Exception 
	 */
	public void enterCompanyDetails(String _CompanyName,String _OtherInformation,String _Vat,String _Country,String _Address,String _Phone) throws Exception {

		clickElementUsingJavaScript(radioButton_Company);
		WaitHelper wh = new WaitHelper(driver, test);
		waitForPageLoadToComplete();

		log("Clicked on the "+radioButton_Company.getText()+" label");
		wh.waitForElementToBeClickable(input_Name_Company, driver, 10);
		input_Name_Company.click();
		sendKeys(input_Name_Company, _CompanyName);

		input_OtherInformation.click();
		sendKeys(input_OtherInformation, _OtherInformation);

		input_VATNO.click();
		sendKeys(input_VATNO, _Vat);

		clickElementUsingJavaScript(dropDown_Country);
		log("Clicked on the country dropdown");
		
		 List<WebElement> countries = driver.findElements(By.xpath("//md-option[@ng-repeat='country in PaymentCtrl.countryList']//div[@class='md-text ng-binding']"));
		 
			
			if(countries.size()>0) {
			for(int i=0;i<countries.size();i++) {
			
				if((countries.get(i).getText()).equals(_Country)){
					
					clickElementUsingJavaScript(countries.get(i));
					System.out.println(countries.get(i).getText());
					Thread.sleep(3000);
					break;
				}
			}
		}
			else {
				log("Country is not in the list");
				throw new Exception("Country is not in the List");
				
			}

		log("Selected country is "+_Country);

		sendKeys(input_Address, _Address.substring(0, 10));
		WebElement addresstoSelect = driver.findElement(By.xpath("//li[contains(@id,'typeahead-')][1]/a/div/div"));
		wh.waitForElementToBeVisible(addresstoSelect, driver, 10);
		
		clickElementUsingJavaScript(addresstoSelect);
		
		log("Entered the Address as "+ _Address);

		input_Phone.click();
		input_Phone.sendKeys(_Phone);
		log("Entered the PhoneNo as "+ _Phone);



		takeScreenShot();

		js= new JavaScriptHelper(driver, test);
		js.scrollDownVertically();

	}







	@FindBy(how=How.XPATH,using ="//a[@id='enterAddrManuallyLink']")
	WebElement link_EnterAddressManually;

	@FindBy(how=How.XPATH,using ="//input[@id='addressLine1']")
	WebElement input_AddressLine1;

	@FindBy(how=How.XPATH,using ="//input[@id='addressLine2']")
	WebElement input_AddressLine2;

	@FindBy(how=How.XPATH,using ="//input[@id='city']")
	WebElement input_TownOrCity;

	@FindBy(how=How.XPATH,using ="//input[@id='state']")
	WebElement input_State;

	@FindBy(how=How.XPATH,using ="//input[@id='postCode']")
	WebElement input_Postcode;

	public void enterPrivatePersonAddressComplete(String _Name,String _Country,String _Address,String _Phone,
			String _AddressLine1, String _AddressLine2, String _Town, String _State,
			String _Postcode) throws Exception {
		clickElementUsingJavaScript(radioButton_PrivatePerson);
		WaitHelper wh = new WaitHelper(driver, test);
		waitForPageLoadToComplete();
		log("Clicked on the "+radioButton_PrivatePerson.getText()+" label");
		wh.waitForElementToBeClickable(input_Name_PrivatePerson, driver, 10);
		input_Name_PrivatePerson.click();
		sendKeys(input_Name_PrivatePerson, _Name);

		clickElementUsingJavaScript(dropDown_Country);
		log("Clicked on the country dropdown");

		
		
		 List<WebElement> countries = driver.findElements(By.xpath("//md-option[@ng-repeat='country in PaymentCtrl.countryList']//div[@class='md-text ng-binding']"));
		 
		
			if(countries.size()>0) {
			for(int i=0;i<countries.size();i++) {
			
				if((countries.get(i).getText()).equals(_Country)){
					
					clickElementUsingJavaScript(countries.get(i));
					System.out.println(countries.get(i).getText());
					Thread.sleep(3000);
					break;
				}
			}
		}
			else {
				log("Country is not in the list");
				throw new Exception("Country is not in the List");
				
			}
	

		log("Selected country is "+_Country);
		
		input_Phone.click();
		input_Phone.sendKeys(_Phone);
		log("Entered the PhoneNo as "+ _Phone);
		

		link_EnterAddressManually.click();

		wh.waitForElementToBeClickable(input_AddressLine1, driver, 10);
		input_AddressLine1.clear();
		sendKeys(input_AddressLine1, _AddressLine1);
		log("Entered the Address Line1 "+_AddressLine1);

		wh.waitForElementToBeClickable(input_AddressLine1, driver, 10);
		sendKeys(input_AddressLine2, _AddressLine2);
		log("Entered the Address Line2 "+_AddressLine2);

		wh.waitForElementToBeClickable(input_TownOrCity, driver, 10);
		sendKeys(input_TownOrCity, _Town);
		log("Entered the Town or City as "+_Town);

		wh.waitForElementToBeClickable(input_State, driver, 10);
		sendKeys(input_State, _State);
		log("Entered the State or Province as "+_State);

		wh.waitForElementToBeClickable(input_Postcode, driver, 10);
		sendKeys(input_Postcode, _Postcode);
		log("Entered the Postcode as "+_Postcode);




		takeScreenShot();
		JavaScriptHelper js = new JavaScriptHelper(driver, test);
		js.scrollDownVertically();


	}



	public void enterCompanyAddressComplete(String _CompanyName,String _OtherInformation,String _Vat,String _Country,String _Address,String _Phone,
			String _AddressLine1, String _AddressLine2, String _Town, String _State,
			String _Postcode) throws Exception {

		WaitHelper wh = new WaitHelper(driver, test);
		clickElementUsingJavaScript(radioButton_Company);
		waitForPageLoadToComplete();

		log("Clicked on the "+radioButton_Company.getText()+" label");



		wh.waitForElementToBeInvisible(loader, driver, 10);
		wh.waitForElementToBeClickable(input_Name_Company, driver, 20);


		sendKeys(input_Name_Company, _CompanyName);

		input_OtherInformation.click();
		sendKeys(input_OtherInformation, _OtherInformation);

		input_VATNO.click();
		sendKeys(input_VATNO, _Vat);

		clickElementUsingJavaScript(dropDown_Country);
		log("Clicked on the country dropdown");

		
		
		 List<WebElement> countries = driver.findElements(By.xpath("//md-option[@ng-repeat='country in PaymentCtrl.countryList']//div[@class='md-text ng-binding']"));
		 
		
			if(countries.size()>0) {
			for(int i=0;i<countries.size();i++) {
			
				if((countries.get(i).getText()).equals(_Country)){
					
					clickElementUsingJavaScript(countries.get(i));
					System.out.println(countries.get(i).getText());
					Thread.sleep(3000);
					break;
				}
			}
		}
			else {
				log("Country is not in the list");
				throw new Exception("Country is not in the List");
				
			}
	

		log("Selected country is "+_Country);
		
		input_Phone.click();
		input_Phone.sendKeys(_Phone);
		log("Entered the PhoneNo as "+ _Phone);
		

		link_EnterAddressManually.click();

		wh.waitForElementToBeClickable(input_AddressLine1, driver, 10);
		input_AddressLine1.clear();
		sendKeys(input_AddressLine1, _AddressLine1);
		log("Entered the Address Line1 "+_AddressLine1);

		wh.waitForElementToBeClickable(input_AddressLine1, driver, 10);
		sendKeys(input_AddressLine2, _AddressLine2);
		log("Entered the Address Line2 "+_AddressLine2);

		wh.waitForElementToBeClickable(input_TownOrCity, driver, 10);
		sendKeys(input_TownOrCity, _Town);
		log("Entered the Town or City as "+_Town);

		wh.waitForElementToBeClickable(input_State, driver, 10);
		sendKeys(input_State, _State);
		log("Entered the State or Province as "+_State);

		wh.waitForElementToBeClickable(input_Postcode, driver, 10);
		sendKeys(input_Postcode, _Postcode);
		log("Entered the Postcode as "+_Postcode);




		takeScreenShot();
		JavaScriptHelper js = new JavaScriptHelper(driver, test);
		js.scrollDownVertically();


	}


	@FindBy(how=How.XPATH,using ="//*[@id='addAddressToProfile']/div[1]")
	WebElement checkbox_addAddressToProfileCheckbox;
	public void clickonAddToMyAddress() {

		checkbox_addAddressToProfileCheckbox.click();

	}

	@FindBy(how=How.XPATH,using ="//md-checkbox[@id='iamnotparker']/div")
	WebElement checkbox_IamnottheParker;
	@FindBy(how=How.XPATH,using ="//input[@id='txtParkerName']")
	WebElement txtParkerName;
	@FindBy(how=How.XPATH,using ="//input[@id='txtParkerEmail']")
	WebElement txtParkerEmail;
	@FindBy(how=How.XPATH,using ="//input[@id='txtParkerIdentification']")
	WebElement txtParkerIdentification;
	public void addIamNotTheParkerDetails(String _ParkerName,String _ParkerEmail,String _ParkerCarIdentification) {
		WaitHelper wh = new WaitHelper(driver, test);
		clickElementUsingJavaScript(checkbox_IamnottheParker);
		log("clicked on the checkbox Iam not the Parker");

		wh.waitForElementToBeClickable(txtParkerName, driver, 10);
		sendKeys(txtParkerName, _ParkerName);
		wh.waitForElementToBeClickable(txtParkerEmail, driver, 10);
		sendKeys(txtParkerEmail, _ParkerEmail);
		wh.waitForElementToBeClickable(txtParkerIdentification, driver, 10);
		sendKeys(txtParkerIdentification, _ParkerCarIdentification);

		takeScreenShot();


	}

	@FindBy(how=How.XPATH,using ="//*[@id='paymentForm']//div[@class='noIdentificationInput ng-scope']")
	WebElement msg_GrafosPinpad;

	public String verifyIdentificationMessage(String msgForGrafosPinpad) {

		status="FAIL";

		if(msg_GrafosPinpad.getText().equals(msgForGrafosPinpad)) {
			log(msg_GrafosPinpad.getText()+" is displayed in UI");
			status="PASS";
		}
		return status;


	}

	@FindBy(how=How.XPATH,using ="//div[@class='termAndConditions']")
	WebElement termsAndConditions;
	public String verifyTermsAndConditionsBeforePay(String _TermsAndConditions) {

		status="FAIL";
		if(termsAndConditions.getText().equals(_TermsAndConditions)) {
			status="PASS";
			log(termsAndConditions.getText()+" is displayed in UI");

		}
		return status;

	}


	@FindBy(how=How.XPATH,using ="//div[@class='md-input-message-animation ng-binding ng-scope' and @ng-message='required']")
	WebElement blankIDMSG;
	public String verifyErrorMessageForBlankID(String _BlankIdMessage) throws InterruptedException {

		status="FAIL";

		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(blankIDMSG, driver, 10);

		if(blankIDMSG.getText().equals(_BlankIdMessage)) {
			log(blankIDMSG.getText());
			status="PASS";
			takeScreenShot();

		}
		return status;
	}

	public String verifyReservationAccessMessageGrafosPinpad(String _Message) {

		status="FAIL";
		String textmsg = driver.findElement(By.xpath("//div[@class='noIdentificationInput ng-scope']")).getText();
		if(_Message.equals(textmsg)) {
			log(textmsg+ " is displayed in UI");
			status="PASS";
		}

		return status;
	}

	public String verifyGrafosPinPadIsDisabled(String Identification) throws InterruptedException {
		status="FAIL";
		WebElement dropDown = driver.findElement(By.xpath("//*[@id='idnDrpAccessMediaType0']"));
		clickElementUsingJavaScript(dropDown);
		Thread.sleep(2000);
		String iD = driver.findElement(By.xpath("//*[@id='idnDrpAccessMediaType0']")).getAttribute("aria-owns");
		WebElement selectID = driver.findElement(By.xpath("//*[@id='"+iD+"']//div[@class='md-text ng-binding' and contains(text(),'"+Identification+"')]//ancestor::md-option"));
		if(selectID.getAttribute("aria-disabled").contains("true")) {
			status="PASS";
		}

		return status;


	}
	
	@FindBy(how=How.XPATH,using ="//p[@translate='_IAmNotParker_']")
	WebElement Iam_NotTheParker_Message;
	
	@FindBy(how=How.XPATH,using ="//label[@data-i18n='_SelectAParker_']")
	WebElement Select_Parker_HeaderText;
	
	@FindBy(how=How.XPATH,using ="//md-checkbox[@id='iamnotparker0']//div[@class='md-container']")
	WebElement Iam_NotTheParker_CheckBox;
	
	/**
	 * Method to click on i am not the parker checkbox in the checkout page
	 */
	public void clickonIamNotTheParker() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(Iam_NotTheParker_CheckBox, driver, 30);
		clickElementUsingJavaScript(Iam_NotTheParker_CheckBox);
		log("Clicked on the Iam not the parker checkbox");

	}
	
	
	
	@FindBy(how=How.XPATH,using ="//span[@class='md-select-icon']")
	WebElement SelectTheParker_Dropdown;
	
	@FindBy(how=How.XPATH,using ="//input[@id='txtParkerName0']")
	WebElement SelectTheParker_Name;
	
	@FindBy(how=How.XPATH,using ="//input[@id='txtParkerEmail0']")
	WebElement SelectTheParker_Email;
	
	public String verifyAvailbleParkersFieldsIn_IamNotTheParkerDetailsForm(String _ParkerName_field,String _ParkerEmail_field) throws InterruptedException{
		status="FAIL";
		Thread.sleep(3000);
		if(SelectTheParker_Name.getAttribute("id").equals(_ParkerName_field)){
			log(SelectTheParker_Name.getAttribute("id")+"--> parker name field is displayed for i am not the parker Details form");
			if(SelectTheParker_Email.getAttribute("id").equals(_ParkerEmail_field)){
				log(SelectTheParker_Email.getAttribute("id")+"--> parker E-mail field is displayed for i am not the parker Details form");
				
								
					status="PASS";
				}
			}
								
			
		return status;

 }
	
	public String verifyIamNotTheParker_text(String _IamNotheParkerMessage) throws InterruptedException {
		status="FAIL";
		Thread.sleep(2000);
		if(Iam_NotTheParker_Message.getText().equals(_IamNotheParkerMessage)) {
			log(Iam_NotTheParker_Message.getText()+" is displayed");
				takeScreenShot();
				status="PASS";
			}	
		
		return status;
	}
	
//	public String verifySelectParker_text(String _SelectParkerText) throws InterruptedException {
//		status="FAIL";
//		Thread.sleep(2000);
//		if(Select_Parker_HeaderText.getText().equals(_SelectParkerText)) {
//			log(Select_Parker_HeaderText.getText()+" is displayed");
//				takeScreenShot();
//				status="PASS";
//			}	
//		
//		return status;
//	}

   public void EnterIamNotTheParkerDetails(String _ParkerName,String _ParkerEmail) throws InterruptedException {
		
		Thread.sleep(3000);
		SelectTheParker_Name.click();
		SelectTheParker_Name.sendKeys(_ParkerName);
		log("Entered Parker Name");
		Thread.sleep(2000);
		SelectTheParker_Email.click();
		SelectTheParker_Email.sendKeys(_ParkerEmail);
		log("Entered Parker Email");
		takeScreenShot();

	}
	
@FindBy(how=How.XPATH,using ="//md-select[@id='idnDrpAccessMediaType0parker']")
WebElement IdentificationDropdown_Parker;

@FindBy(how=How.XPATH,using ="//input[@id='idnTxtField10parker' and @name='idnTxtField10parker']")
WebElement IdentificationAccessMediaValue_Parker;

	
   public void addIdentificationDetails_AfterAdding_Parker(String _Identificationtype,String _IdentificationValue) throws InterruptedException {
	   IdentificationDropdown_Parker.click();
	log("clicked on the Identifications dropDown");
	Thread.sleep(5000);	
	driver.findElement(By.xpath("//md-option[contains(@id,'select_option')]//div[contains(text(),'"+_Identificationtype+"')]")).click();
	Thread.sleep(4000);
	
	if(!(_Identificationtype.contains("Grafos Pinpad")))
	{
	IdentificationAccessMediaValue_Parker.sendKeys(_IdentificationValue);
	}
	log("all details entered successfully in Identification fields");
	takeScreenShot();
}
   
   
   @FindBy(how=How.XPATH,using ="//md-option[@id='select_option_12' and @ng-value='parker']")
	WebElement Added_Parker_Details;
 
	
	
	public String verify_SavedParkerDetails(String Saved_ParkerName) throws InterruptedException {
		status="FAIL";
		Thread.sleep(3000);
		SelectTheParker_Dropdown.click();
		Thread.sleep(2000);
	  if(Added_Parker_Details.getText().equals(Saved_ParkerName)) {
		log(Added_Parker_Details.getText()+" is displayed in i am not the parker dropdown");
			 
			 status="PASS";
			takeScreenShot();
		}
	
	return status;
	
}
	

		public void clickOnPay_InPopUpConfirmation() {
				WebElement chargePopUpPayButton = driver.findElement(By.xpath("//*[@id='btnOk']"));
				WaitHelper wh = new WaitHelper(driver, test);
				wh.waitForElementToBeVisible(chargePopUpPayButton, driver, 10);
				clickElementUsingJavaScript(chargePopUpPayButton);
				
			} 
		
		public String emailCreation() throws InterruptedException, AWTException {
			
			Thread.sleep(1000);
			DateAndUniqueNoGenerateHelper date=new DateAndUniqueNoGenerateHelper();
			
			String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        Random rnd = new Random();
	        char cha = alphabet.charAt(rnd.nextInt(alphabet.length()));
	        char cha2 = alphabet.charAt(rnd.nextInt(alphabet.length()));
			
			String uniqueNo = date.generateUniqueNo();
			log("unique no is generated "+uniqueNo);
		
	        String UniqueEmail = "sample"+cha+uniqueNo+cha2+"@mailinator.com";
		
			return UniqueEmail;
			//return _TenantName;
		}
		
		
		/*Clicked on Terms & conditions and Privacy policy check_box in checkout page*/
		
		 @FindBy(how=How.XPATH,using ="//md-checkbox[@id='termsAndConditionsCheck']//div[@class='md-container']")
			WebElement TermsAndCondition_Checkbox;
		
		  @FindBy(how=How.XPATH,using ="//md-checkbox[@id='privacyPolicyCheck']//div[@class='md-container']")
			WebElement PrivacyPolicy_Checkbox;
		  
		 
		public void clickon_TermsAndCondition_And_PrivacyPolicy_Checkbox() {
			WaitHelper wh = new WaitHelper(driver, test);
			wh.waitForElementToBeClickable(TermsAndCondition_Checkbox, driver, 20);
			clickElementUsingJavaScript(TermsAndCondition_Checkbox);
			log("Clicked on I agree to terms and conditions checkbox");
			clickElementUsingJavaScript(PrivacyPolicy_Checkbox);
			log("Clicked on I agree to Privacy Policy checkbox");
			takeScreenShot();

		}
		
		@FindBy(how=How.XPATH,using ="//a[@class='ng-binding'][contains(text(),'Terms & Conditions')]")
		WebElement termsAndConditions_In_Checkoutpage;
		
		@FindBy(how=How.XPATH,using ="//a[@class='ng-binding'][contains(text(),'Privacy Policy')]")
		WebElement PrivacyPolicy_In_Checkoutpage;
		
		@FindBy(how=How.XPATH,using ="//div[@class='termAndConditions']//label[1]//div[1]//span[1]")
		WebElement IAgreeto_TermsAndCondition;
		
		@FindBy(how=How.XPATH,using ="//div[@class='termAndConditions']//label[2]//div[1]//span[1]")
		WebElement IAgreeto_PrivacyPolicy;
		
		public String verifyTermsAndConditions_And_PrivacyPolicy(String _IagreeTermsAndCondition,String _TermsAndConditions,String _IagreePrivacypolicy, String PrivacyPolicy) throws InterruptedException {
			status="FAIL";
			Thread.sleep(1000);
			if(IAgreeto_TermsAndCondition.getText().equals(_IagreeTermsAndCondition)) {
				log(IAgreeto_TermsAndCondition.getText()+" is displayed");
				if(termsAndConditions_In_Checkoutpage.getText().equals(_TermsAndConditions)) 
					log(termsAndConditions_In_Checkoutpage.getText()+" is displayed");
				        if(IAgreeto_PrivacyPolicy.getText().equals(_IagreePrivacypolicy))
					       log(IAgreeto_PrivacyPolicy.getText()+" is displayed");
					           if(PrivacyPolicy_In_Checkoutpage.getText().equals(PrivacyPolicy)) {
						          log(PrivacyPolicy_In_Checkoutpage.getText()+" is displayed");
					
						          takeScreenShot();
					status="PASS";
				}	
			}
			return status;
		}

		public void addIdentificationDetails_MultipleProduct(String _AdditionalIdentification) throws InterruptedException, AWTException {
			status="FAIL";
			String uniqueNo=null;
			
			 List<WebElement> noOfIdentifications = driver.findElements(By.xpath("//h2[@translate='_Identification_']"));
			
			for(int i=0;i<noOfIdentifications.size();i++) {
				
				log("Enter Identifications details");
				WebElement input_IdentificationValueFieldID;
				
				
				WebElement dropDown = driver.findElement(By.xpath("//*[@id='idnDrpAccessMediaType"+i+"']"));
				clickElementUsingJavaScript(dropDown);
				Thread.sleep(2000);
				String iD = driver.findElement(By.xpath("//*[@id='idnDrpAccessMediaType"+i+"']")).getAttribute("aria-owns");
				WebElement selectID = driver.findElement(By.xpath("//*[@id='"+iD+"']//md-option//div[1][contains(text(),'"+_AdditionalIdentification+"')]"));

				clickElementUsingJavaScript(selectID);
				Thread.sleep(2000);

				log("Selected the id as "+_AdditionalIdentification);

				Thread.sleep(3000);
				DateAndUniqueNoGenerateHelper dateAndUniqNo = new DateAndUniqueNoGenerateHelper();
				
				
				
				if(_AdditionalIdentification.equals("Skidata keycard")) {
					//input_IdentificationValueField.click();
					//Thread.sleep(2000);
					uniqueNo =dateAndUniqNo.generateUniqueNo();

					input_IdentificationValueFieldID = driver.findElement(By.xpath("//*[@id='idnTxtField1"+i+"']"));
					sendKeys(input_IdentificationValueFieldID, uniqueNo);
					log("Identification entered as "+uniqueNo);
					


				}else if(_AdditionalIdentification.equals("Deister Tag")) {

					Thread.sleep(2000);
					uniqueNo =dateAndUniqNo.generateUniqueNo();

					input_IdentificationValueFieldID = driver.findElement(By.xpath("//*[@id='idnTxtField1"+i+"']"));
					sendKeys(input_IdentificationValueFieldID, uniqueNo);
					log("Identification entered as "+uniqueNo);
					

				}else if(_AdditionalIdentification.equals("Mifare card")) {

					Thread.sleep(2000);
					uniqueNo ="MIC"+dateAndUniqNo.generateUniqueNo();
					input_IdentificationValueFieldID = driver.findElement(By.xpath("//*[@id='idnTxtField1"+i+"']"));
					sendKeys(input_IdentificationValueFieldID, uniqueNo);
					log("Identification entered as "+uniqueNo);
				

				}
				else if(_AdditionalIdentification.equals("Skidata")) {

					Thread.sleep(2000);
					uniqueNo =dateAndUniqNo.generateUniqueNo();
					driver.findElement(By.xpath("//*[@id='idnTxtField1"+i+"']")).sendKeys(uniqueNo);
					Thread.sleep(2000);
					log("Identification entered as "+uniqueNo);
					
				}
				else if(_AdditionalIdentification.equals("NFC")) {

					Thread.sleep(2000);
					uniqueNo ="NFC"+dateAndUniqNo.generateUniqueNo();
					driver.findElement(By.xpath("//*[@id='idnTxtField1"+i+"']")).sendKeys(uniqueNo);
					Thread.sleep(2000);
					log("Identification entered as "+uniqueNo);
				
				}
				else if(_AdditionalIdentification.equals("Grafos Pinpad")) {
					Thread.sleep(2000);
					log("Grafos Pinpad selected");
					

				}
				else if(_AdditionalIdentification.equals("License plate")) {
					uniqueNo ="LP"+dateAndUniqNo.generateUniqueNo();
					driver.findElement(By.xpath("//*[@id='idnCarType"+i+"']")).sendKeys("BMW");
					pressTab();
					driver.findElement(By.xpath("//*[@id='idnTxtField1"+i+"']")).sendKeys(uniqueNo);
					Thread.sleep(2000);
					log("License Plate selected");
				

				}
				else {
					log("No Common Id is displayed for the products selected");
					
				}
				
			
			}
			
			
	

		}

	
		

}