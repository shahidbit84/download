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
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.helperclasses.AlertHelper;
import com.skidata.helperclasses.WaitHelper;
import com.skidata.testBase.TestBase;

/**
 * @author shmo
 * 
 */
public class SspPspPage extends TestBase {


	
	String status=null;


	public static final Logger log = Logger.getLogger(SspPspPage.class.getName());



	//Class constructor
	public SspPspPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

	}


	@FindBys({	
		@FindBy(how=How.ID, using="logo"),
	})	public List<WebElement> allElementsInList_LogoImage;

	@FindBy(how=How.XPATH,using ="/html/body/div[1]/div/div/div[1]/div")
	WebElement WirecardGateWayPage;
	
	@FindBy(how=How.XPATH,using="/html/body/div[1]/div/div/div[1]/div[2]/form/fieldset/ul/li[4]/img")
	WebElement WirecardIdealPayment;
	
	@FindBy(how=How.XPATH,using="//*[@id='ABNAMROBANK']")
	WebElement WirecardABNamroBank;
	
	@FindBy(how=How.XPATH,using="//a[text()='Success']")
	WebElement WirecardABNamroBankSuccess;
	
	@FindBy(how=How.XPATH,using="//span[text()='Credit Card/Maestro SecureCode']")
	WebElement WirecardCreditcardMaestroSecureCode;
	
	@FindBy(how=How.XPATH,using="//input[@name='cardholder']")
	WebElement CreditcardMaestroSecureCodeCardHolder;
	
	@FindBy(how=How.XPATH,using="//a[@id='button_cancel']")
	WebElement WireCardHolderCancelButton;

	@FindBy(how=How.XPATH,using="//input[@name='pan']")
	WebElement CreditcardMaestroSecureCodeCardnumber;
	
	@FindBy(how=How.XPATH,using="//select[@id='expMonth']")
	WebElement CreditcardMaestroSecureCodeExpmonth;
	
	@FindBy(how=How.XPATH,using="//select[@id='expYear']")
	WebElement CreditcardMaestroSecureCodeExpyear;
	
	@FindBy(how=How.XPATH,using="//input[@name='cvc']")
	WebElement CreditcardMaestroSecureCodeCardSecuritycode;
	
	@FindBy(how=How.XPATH,using="//a[@id='button_next']")
	WebElement CreditcardMaestroSecureCodeNextButton;
	
	@FindBy(how=How.XPATH,using="//a[@class='btn btn-success']")
	WebElement CreditcardMaestroSecureCodeSuccessButton;
	
	@FindBy(how=How.XPATH,using="//li[@id='SEPA-DD']")
	WebElement WirecardSepaDirectDebit;
	
	@FindBy(how=How.XPATH,using=".//*[@id='bankAccountOwner']")
	WebElement SepaDirectDebitAccountOwner;
	
	@FindBy(how=How.XPATH,using=".//*[@id='bankAccountIBAN']")
	WebElement SepaDirectDebitIBAN;
	
	@FindBy(how=How.XPATH,using=".//*[@id='bankBIC']")
	WebElement SepaDirectDebitBIC;
	
	
	//--------------------------------- xpath for payment express card details-----------------------------------------
	@FindBy(how=How.XPATH,using="//input[@name='CardNumber']")
	WebElement PaymentExpressCreditcardMaestroCardHolderNumber;
	
	@FindBy(how=How.XPATH,using="//input[@name='CardHolderName']")
	WebElement PaymentExpressCreditcardMaestroCardHolderName;
	
	@FindBy(how=How.XPATH,using="//select[@id='DateExpiry_1']")
	WebElement PaymentExpressCreditcardMaestroCardHolderExpirationdate;
	
	@FindBy(how=How.XPATH,using="//select[@id='DateExpiry_2']")
	WebElement PaymentExpressCreditcardMaestroCardHolderExpirationYear;
	
	@FindBy(how=How.XPATH,using="//input[@name='Cvc2']")
	WebElement PaymentExpressCreditcardMaestroCardHolderCVV;
	
	@FindBy(how=How.XPATH,using="//button[@name='Add']")
	WebElement PaymentExpressCreditcardMaestroCardHolderSubmit;
	
	@FindBy(how=How.XPATH,using="//div[@id='clicked36864094']")
	WebElement PaymentExpressCreditcardMaestroCardHolderCancel;
	
	
	@FindBy(how=How.XPATH,using="//a[@id='36864722']")
	WebElement PaymentExpressCreditcardMaestroCardHolderPaymentNext;
	
//---------------------------------Ingenico xpath --------------------------------------------------------------------
	
	@FindBy(how=How.XPATH,using="//span[text()='Masterpass']")
	WebElement MasterpassCard;
		
	@FindBy(how=How.XPATH,using="//input[@id='Ecom_Payment_Card_Number']")
	WebElement IngenicoCreditcardMaestroCardHolderNumber;
		
	@FindBy(how=How.XPATH,using="//select[@id='Ecom_Payment_Card_ExpDate_Month']")
	WebElement IngenicoCreditcardMaestroCardHolderExpirationdate;
	
	@FindBy(how=How.XPATH,using="//select[@id='Ecom_Payment_Card_ExpDate_Year']")
	WebElement IngenicoCreditcardMaestroCardHolderExpirationYear;
	
	@FindBy(how=How.XPATH,using="//input[@id='Ecom_Payment_Card_Verification']")
	WebElement IngenicoCreditcardMaestroCardHolderCVV;
	
	@FindBy(how=How.XPATH,using="//input[@id='storealias']")
	WebElement IngenicoCreditcardMaestroCardHolderAuthorize;
	
	
	
	@FindBy(how=How.XPATH,using="//input[@id='submit3']")
	WebElement IngenicoCreditcardMaestroCardHolderSubmit;
	
	@FindBy(how=How.XPATH,using="//input[@id='ncol_cancel']")
	WebElement IngenicoCreditcardMaestroCardHolderCancel;
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='button_next']")
	WebElement SepaDirectDebitNextButton;
	
	@FindBy(how=How.XPATH,using=".//*[@id='agb']")
	WebElement SepaDirectDebitDeclartionCheckBox;
	
	
	
	
	/**
	 *  click on Wire card payment gate way SEPA Direct debit
	 */
	public void clickonSEPADirectDebitPayment()  {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(WirecardSepaDirectDebit, driver, 60);
		clickonSepapayment();
		log("Controll navigated to Credit card Maestro Secure Code details page");
		takeScreenShot();
	
	}
	/**
	 * To cancel the wirecard payment cancel button
	 */
	public void cllickCancelWireCardPayment() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(WirecardSepaDirectDebit, driver, 60);
		clickonSepapayment();
		log("Controll navigated to Credit card Maestro Secure Code details page");
		takeScreenShot();
	}
	
	/**
	 *  click on Wire card payment gate way SEPA Direct debit
	 */
	public void clickonSepapayment()  {
		WirecardSepaDirectDebit.click();
		log("Selected SEPA Direct debit card payment");
		takeScreenShot();
	
	}
	
	/**
	 * Enter all the Credetials related to SEPA direct debit.
	 */
	
	public void EnterSepaCredentialsAndPay(String _AccountHolder,String _IBAN, String _BIC ){
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(SepaDirectDebitAccountOwner, driver, 60);
		SepaDirectDebitAccountOwner.sendKeys(_AccountHolder);
		SepaDirectDebitIBAN.sendKeys(_IBAN);
		SepaDirectDebitBIC.sendKeys(_BIC);
		log("Entered SEPA Direct debit card payment credentials");
		takeScreenShot();
		SepaDirectDebitNextButton.click();
		SepaDirectDebitDeclartionCheckBox.click();
		SepaDirectDebitNextButton.click();
	}
	
	/**
	 *  click on Wire card payment gate way Credit card Maestro Secure Code
	 */
	public void clickonCreditcardMaestroSecureCodePayment()  {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(WirecardCreditcardMaestroSecureCode, driver, 60);
		clickonWirecardCreditcardMaestroSecureCodePaymentmethod();
		log("Controll navigated to Credit card Maestro Secure Code details page");
		takeScreenShot();
	
	}
	
	/**
	 *  click on Wire card payment gate way Credit card Maestro SecureCode
	 * 
	 */
	public void clickonWirecardCreditcardMaestroSecureCodePaymentmethod() {
		WirecardCreditcardMaestroSecureCode.click();
		log("clicked on Credit card Maestro Secure Code payment");
		takeScreenShot();	
	}
	
	
	public void clickonMasterpassPaymentmethod() {
		MasterpassCard.click();
		log("clicked on masterpass payment method");
		takeScreenShot();	
	}
	/**
     * Enter all below details in Credit card Maestro Secure Code
     * @param _cardHolder
     * @param _CarNumber
     * @param _ExpMonth
     * @param _ExpYear
     * @param _cvv
     * @throws InterruptedException 
     */
    
    public void EnterCreditcardMaestroSecureCodeUserDetails(String _cardHolder, String _CardNumber, String _ExpMonth,String _ExpYear,String _cvv) throws InterruptedException{
    	WaitHelper wh = new WaitHelper(driver, test);
        wh.waitForElementToBeClickable(CreditcardMaestroSecureCodeCardHolder, driver, 60);
        CreditcardMaestroSecureCodeCardHolder.sendKeys(_cardHolder);
        log("entered CardHolder name --> '"+_cardHolder+"'");
        
        CreditcardMaestroSecureCodeCardnumber.sendKeys(_CardNumber);
        log("entered CardHolder number --> '"+_CardNumber+"'");
        
        
        Select OselectExpMonth=new Select(CreditcardMaestroSecureCodeExpmonth);
        OselectExpMonth.selectByVisibleText(_ExpMonth);
        log("entered CardHolder ExpMonth --> '"+_ExpMonth+"'");
        
        Select OselectExpYear=new Select(CreditcardMaestroSecureCodeExpyear);
        OselectExpYear.selectByVisibleText(_ExpYear);
        log("entered CardHolder ExpYear --> '"+_ExpYear+"'");
        
        CreditcardMaestroSecureCodeCardSecuritycode.sendKeys(_cvv);
        log("entered CardHolder CVV --> '"+_cvv+"'");
        takeScreenShot();
        CreditcardMaestroSecureCodeNextButton.click();
        
        wh.waitForElementToBeClickable(CreditcardMaestroSecureCodeNextButton, driver, 60);
        Thread.sleep(5000);
        clickElementUsingJavaScript(CreditcardMaestroSecureCodeNextButton);

        takeScreenShot();
        
        driver.switchTo().frame(0);
        wh.waitForElementToBeClickable(CreditcardMaestroSecureCodeSuccessButton, driver, 60);
        CreditcardMaestroSecureCodeSuccessButton.click();
        log("clicked on Credit card Maestro Secure Code Success Button ");
        driver.switchTo().defaultContent();
        
    }
	
	/**
	 * Enter all below details in Credit card Maestro Secure Code via payment express
	 * @param _cardHolder
	 * @param _CarNumber
	 * @param _ExpMonth
	 * @param _ExpYear
	 * @param _cvv
	 * @throws InterruptedException 
	 */
	
	public void EnterCreditcardMaestroSecureCodeUserDetailsPaymentExpress(String _cardHolder, String _CardNumber, String _ExpMonth,String _ExpYear,
			String _cvv) throws InterruptedException{
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(PaymentExpressCreditcardMaestroCardHolderName, driver, 60);
		PaymentExpressCreditcardMaestroCardHolderName.sendKeys(_cardHolder);
		log("entered CardHolder name --> '"+_cardHolder+"'");
		
		PaymentExpressCreditcardMaestroCardHolderNumber.sendKeys(_CardNumber);
		log("entered CardHolder number --> '"+_CardNumber+"'");
		
		
		Select OselectExpMonth=new Select(PaymentExpressCreditcardMaestroCardHolderExpirationdate);
		OselectExpMonth.selectByVisibleText(_ExpMonth);
		log("entered CardHolder ExpMonth --> '"+_ExpMonth+"'");
		
//		Select OselectExpYear=new Select(PaymentExpressCreditcardMaestroCardHolderExpirationYear);
//		OselectExpYear.selectByVisibleText(_ExpYear);
//		log("entered CardHolder ExpYear --> '"+_ExpYear+"'");
//		
		PaymentExpressCreditcardMaestroCardHolderCVV.sendKeys(_cvv);
		log("entered CardHolder CVV --> '"+_cvv+"'");
		takeScreenShot();
	
		
		
		PaymentExpressCreditcardMaestroCardHolderSubmit.click();
		takeScreenShot();
		PaymentExpressCreditcardMaestroCardHolderPaymentNext.click();
		takeScreenShot();
		Thread.sleep(5000);
		log("clicked on Credit card Maestro Secure Code Success Button ");
		
	}
	
	/**
	 * Enter all below details in Credit card Maestro Secure Code via Ingenico payment method
	 * @param _cardHolder
	 * @param _CarNumber
	 * @param _ExpMonth
	 * @param _ExpYear
	 * @param _cvv
	 * @throws InterruptedException 
	 */
	
	public void EnterCreditcardMaestroSecureCodeUserDetailsIngenico(String _cardHolder, String _CardNumber, String _ExpMonth,String _ExpYear,
			String _cvv) throws InterruptedException{
		
		
		IngenicoCreditcardMaestroCardHolderNumber.sendKeys(_CardNumber);
		log("entered CardHolder number --> '"+_CardNumber+"'");
		
		
		Select OselectExpMonth=new Select(IngenicoCreditcardMaestroCardHolderExpirationdate);
		OselectExpMonth.selectByVisibleText(_ExpMonth);
		log("entered CardHolder ExpMonth --> '"+_ExpMonth+"'");
		
		Select OselectExpYear=new Select(IngenicoCreditcardMaestroCardHolderExpirationYear);
		OselectExpYear.selectByVisibleText(_ExpYear);
		log("entered CardHolder ExpYear --> '"+_ExpYear+"'");
//		
		IngenicoCreditcardMaestroCardHolderCVV.sendKeys(_cvv);
		log("entered CardHolder CVV --> '"+_cvv+"'");
		takeScreenShot();
		
IngenicoCreditcardMaestroCardHolderAuthorize.click();
		
		Thread.sleep(1000);
		IngenicoCreditcardMaestroCardHolderSubmit.click();
		takeScreenShot();
//		wh.waitForElementToBeClickable(PaymentExpressCreditcardMaestroCardHolderSubmit, driver, 60);
//		IngenicoCreditcardMaestroCardHolderPaymentNext.click();
		takeScreenShot();
		Thread.sleep(5000);
//		driver.switchTo().frame(0);
		//wh.waitForElementToBeClickable(CreditcardMaestroSecureCodeSuccessButton, driver, 60);
//		CreditcardMaestroSecureCodeSuccessButton.click();
		log("clicked on Credit card Maestro Secure Code Success Button ");
		
	}
	
	/**
	 * To cancel the ingenico payment 
	 */
	public void clickCancelIngenicoPayement() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(IngenicoCreditcardMaestroCardHolderCancel, driver, 60);
		IngenicoCreditcardMaestroCardHolderCancel.click();
		log("Clicked on cancel payment and page will redirect back to the failure page");
		takeScreenShot();
	}
	
	/*
	 * 
	 * 
	 */
	public void clickCancelPayementExpressPayment() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(PaymentExpressCreditcardMaestroCardHolderCancel, driver, 60);
		PaymentExpressCreditcardMaestroCardHolderCancel.click();
		log("Clicked on cancel payment and page will redirect back to the failure page");
		takeScreenShot();
	}
	
	/**
	 *  click onWire card payment gate way Ideal bank 
	 * 
	 */
	public void clickonWirecardIdealPayment()  {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(WirecardGateWayPage, driver, 60);
		WirecardIdealPayment.click();
		log("clicked on Ideal payment");
		takeScreenShot();
	
	}
	/**
	 *  select Chose your payment for ideal , So choosing ABN amro Bank
	 */
	
	public void clickonIdealBankABNAmroBank() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(WirecardABNamroBank, driver, 30);
		WirecardABNamroBank.click();
		log("clicked on Ideal Bank ABN Amro Bank");
		takeScreenShot();
	
	}
	/**
	 * select ABN amro Bank final successful button
	 */
	
	public void clickonIdealBankABNAmroBankSuccessbutton() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(WirecardABNamroBankSuccess, driver, 30);
		WirecardABNamroBankSuccess.click();
		log("clicked on Ideal Bank ABN Amro Bank success button");
		takeScreenShot();
	
	}

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
	public void EnterCreditcardMaestroSecureCodeUserDetails2(String _cardHolder, String _CardNumber, String _ExpMonth,String _ExpYear,
	String _cvv) throws InterruptedException {
	
		driver.findElement(By.xpath(".//*[@id='cardholder']")).sendKeys(_cardHolder);
		
		driver.findElement(By.xpath("//*[@id='pan']")).sendKeys(_CardNumber);
	
		driver.findElement(By.xpath("//*[@id='expMonth']")).sendKeys(_ExpMonth);
	
		driver.findElement(By.xpath(".//*[@id='expYear']")).sendKeys(_ExpYear);
	
		driver.findElement(By.xpath(".//*[@id='cvc']")).sendKeys(_cvv);
		
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@id='button_next']")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@id='button_next']")).click();
		Thread.sleep(8000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
		//Thread.sleep(10000);
	}
	


	public void EnterCreditcardMaestroSecureCodeUserDetailsRES(String _cardHolder, String _CardNumber, String _ExpMonth,String _ExpYear,
			String _cvv) throws InterruptedException {
			
				driver.findElement(By.xpath(".//*[@id='cardholder']")).sendKeys(_cardHolder);
				
				driver.findElement(By.xpath("//*[@id='pan']")).sendKeys(_CardNumber);
			
				driver.findElement(By.xpath("//*[@id='expMonth']")).sendKeys(_ExpMonth);
			
				driver.findElement(By.xpath(".//*[@id='expYear']")).sendKeys(_ExpYear);
			
				driver.findElement(By.xpath(".//*[@id='cvc']")).sendKeys(_cvv);
				
				driver.findElement(By.xpath("//*[@id='button_next']")).click();
				Thread.sleep(8000);
				driver.findElement(By.xpath("//*[@id='button_next']")).click();
				Thread.sleep(8000);
				driver.switchTo().frame(0);
				driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
				Thread.sleep(10000);
			}

	

	public void enterPaymentDetailsNewPage(String _PaymentType, String CardHolderName, String CardHolderNumber, String CardExpMonth, String CardExpYear, String CardCVV) throws InterruptedException {
		if(_PaymentType.equals("Wirecard Checkout Page - Selection of the means of payment - Wirecard CEE")) {
			clickonCreditcardMaestroSecureCodePayment();
			EnterCreditcardMaestroSecureCodeUserDetails(CardHolderName,CardHolderNumber,CardExpMonth,CardExpYear,CardCVV);
			AlertHelper ah = new AlertHelper(driver, test);
			boolean isPresent = ah.isAlertPresent();
			if(isPresent) {
				ah.acceptAlert();
			}
		}
	}
	
	@FindBy(how=How.XPATH,using ="//div[contains(text(),'Payment Methods')]")
	WebElement link_PaymentMethod;
	public void clickOnlink_paymentmethod() {
		link_PaymentMethod.click();
		log("clicked on payment method page link");
		takeScreenShot();
		
	}
	
	/*Verify header and label in payment method page*/
	
	@FindBy(how=How.XPATH,using ="//h2[@translate='_ProfilePaymentCards_']")
	WebElement PaymentMethodsHeader;
	
	@FindBy(how=How.XPATH,using ="//div[@translate='_DashboardAddPaymentMethod_']")
	WebElement AddMethodsHeader;
	
	@FindBy(how=How.XPATH,using ="//h2[@translate='_YouDoNotHaveAnyPaymentMethods_']")
	WebElement PaymentMethod_HeaderMessage;
	
	@FindBy(how=How.XPATH,using ="//p[@translate='_PleaseClickToAddPaymentMethods_']")
	WebElement PaymentMethod_SubHeaderMessage;
	
	@FindBy(how=How.XPATH,using ="//span[@translate='_DashboardAddPaymentMethod_']")
	WebElement AddPaymentMethod_Button;
	
	public String verifyPageHeaderAndLabel(String _PaymentMethodsHeader,String _AddMethodsHeader,String _PaymentMethod_HeaderMessage,String _PaymentMethod_SubHeaderMessage,String _AddPaymentMethod_Button) throws InterruptedException {
		status="FAIL";
		Thread.sleep(1000);
		if(PaymentMethodsHeader.getText().equals(_PaymentMethodsHeader)) {
			log(PaymentMethodsHeader.getText()+" is displayed");

			if(AddMethodsHeader.getText().equals(_AddMethodsHeader))
				log(AddMethodsHeader.getText()+ " --> Add Method link is displayed In The Payment Method Page");
			
//			 if(AddMethodsHeader.getAttribute("class").equals(_AddMethodsHeader))
//		          log(AddMethodsHeader.getAttribute("class")+"--> Add Method Button is displayed In The Payment Method Page");  	
			
			         if(PaymentMethod_HeaderMessage.getText().equals(_PaymentMethod_HeaderMessage)) {
				        log(PaymentMethod_HeaderMessage.getText()+" is displayed");
				            if(PaymentMethod_SubHeaderMessage.getText().equals(_PaymentMethod_SubHeaderMessage))
					           log(PaymentMethod_SubHeaderMessage.getText()+" is displayed");
				                    
				                 if(AddPaymentMethod_Button.getText().equals(_AddPaymentMethod_Button))
				                	 log(AddPaymentMethod_Button.getText()+ " Add payment Method Button is displayed In The Payment Method Page");
				            
//				                  if(AddPaymentMethod_Button.getAttribute("class").equals(_AddPaymentMethod_Button))
//						                log(AddPaymentMethod_Button.getAttribute("class")+"--> Add payment Method Button is displayed In The Payment Method Page"); 
				            
//				                    if(AddPaymentMethod_Button.getText().equals(_AddPaymentMethod_Button))
//					                  log(AddPaymentMethod_Button.getText()+" is displayed");
				
				takeScreenShot();
				status="PASS";
			}	
		}
		return status;
	}
	
	/*Verify payment method page image icon is displayed*/
	
	
	@FindBy(how=How.XPATH,using ="//div[@class='empty-message ng-scope']//img[@draggable='false']")
	WebElement PaymentMethodPage_Image;
	
	public String verifyImageDisplayed(String _PaymentMethodImage) {
		
		status="FAIL";
		if(PaymentMethodPage_Image.isDisplayed()) {
			log("payment method image icon is displayed in payment methods page");
			
				status ="PASS";
			}
			
		return status;
	}
	
	
	public void clickOnAddPaymentButtonLink() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(AddPaymentMethod_Button, driver, 20);
		AddPaymentMethod_Button.click();
		log(AddPaymentMethod_Button.getText()+" is clicked");
		takeScreenShot();

	}
	
	public void clickonMasterpassPayment()  {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(MasterpassCard, driver, 60);
		clickonMasterpassPaymentmethod();
		log("Controll navigated to Masterpass details page");
		takeScreenShot();
	
	}
	
	




}