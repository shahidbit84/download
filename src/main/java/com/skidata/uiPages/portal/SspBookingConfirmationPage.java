/**
 *
 */
package com.skidata.uiPages.portal;

import java.io.File;
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
import com.skidata.helperclasses.DateAndUniqueNoGenerateHelper;
import com.skidata.helperclasses.WaitHelper;
import com.skidata.testBase.TestBase;

/**
 * @author shmo
 * 
 */
public class SspBookingConfirmationPage extends TestBase {

	
	
	String status=null;


	public static final Logger log = Logger.getLogger(SspBookingConfirmationPage.class.getName());



	//Class constructor
	public SspBookingConfirmationPage(WebDriver driver,ExtentTest test) {
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

	@FindBy(how=How.XPATH,using ="//h1[@class='ng-binding']")
	WebElement label_ThankyouMessage;
	

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
		

		Thread.sleep(8000);
		
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


	public void clickonContinueShoppingLink() {
		
		link_ContinueShopping.click();
		log("clicked on < Continue shopping link");
		takeScreenShot();
	
	}


	public String verifyContinueShoppingLink(String _ContinueShoppingLink) {
		status="FAIL";
		if(link_ContinueShopping.getText().equals(_ContinueShoppingLink)) {
			status="PASS";
			takeScreenShot();
			log(link_ContinueShopping.getText()+" is displayed in UI");
		}
		return status;
	}

	public String verifyThankyouMessage(String _ThankyouMessage) {
		status="FAIL";
		
		if(label_ThankyouMessage.getText().equals(_ThankyouMessage)) {
			log(label_ThankyouMessage.getText()+" is displayed");
			takeScreenShot();
			status="PASS";
		}
		return status;
	}

	public String verifyQRCodeGenerated() {
		status="FAIL";
		int images = driver.findElements(By.xpath("//div[@class='qr-code']")).size();
		if(images==1) {
			log("QR code image is generated and displayed");
			status="PASS";
			takeScreenShot();
		}
		return status;
	}
	
	
	
	
	@FindBy(how=How.XPATH,using ="//div[@class='left-block']//p[@translate='_PleaseUseThisIdForAnyCommunication_']")
	WebElement label_PleaseUseThisIdForAnyCommunication;
	
	@FindBy(how=How.XPATH,using ="//strong[@translate='_ReservationCode_']")
	WebElement label_ReservationCode;
	
	@FindBy(how=How.XPATH,using ="//strong[@translate='_SubscriptionCode_']")
	WebElement label_SubscriptionCode;
		
	@FindBy(how=How.XPATH,using ="//span[@class='ordNum ng-binding ng-scope']")
	WebElement ID_Bookingreference;
	
	@FindBy(how=How.XPATH,using ="//span[@translate='_ZoomQrCode_']")
	WebElement label_ZoomQRCode;
	
	@FindBy(how=How.XPATH,using ="//div[@class='reference-number clr ng-binding ng-scope']")
	WebElement ID_Bookingreference_Annonymous;
	
	public String verifyBookingMessageContent_BookingID_ZoomQRCode(String _PleaseUseThisIdForAnyCommunication,
			String _ReservationCodeLabel,String _ZoomQRLabel) {	
		
		status="FAIL";
		
			if(label_PleaseUseThisIdForAnyCommunication.getText().equals(_PleaseUseThisIdForAnyCommunication)) {
				log(label_PleaseUseThisIdForAnyCommunication.getText()+" is displayed in UI");
				if(label_ReservationCode.getText().equals(_ReservationCodeLabel)) {
					log(label_ReservationCode.getText()+" is displayed in ui");
					if(ID_Bookingreference.getText().matches("^[a-zA-Z0-9]*$")) {
						log(ID_Bookingreference.getText()+" is displayed as reference id");
						if(label_ZoomQRCode.getText().equals(_ZoomQRLabel)) {
							log(label_ZoomQRCode.getText()+" label is displayed");
						takeScreenShot();
						status="PASS";
						}
					}
				}
			}
		
		return status;
	}
	
	public String verifyBookingMessageContent_BookingID_ZoomQRCode_Subscription(String _PleaseUseThisIdForAnyCommunication,
			String _SubscriptionCodeLabel,String _ZoomQRLabel) {	
		
		status="FAIL";
		
			if(label_PleaseUseThisIdForAnyCommunication.getText().equals(_PleaseUseThisIdForAnyCommunication)) {
				log(label_PleaseUseThisIdForAnyCommunication.getText()+" is displayed in UI");
				if(label_SubscriptionCode.getText().equals(_SubscriptionCodeLabel)) {
					log(label_SubscriptionCode.getText()+" is displayed in ui");
					if(ID_Bookingreference.getText().matches("^[a-zA-Z0-9]*$")) {
						log(ID_Bookingreference.getText()+" is displayed as reference id");
						if(label_ZoomQRCode.getText().equals(_ZoomQRLabel)) {
							log(label_ZoomQRCode.getText()+" label is displayed");
						takeScreenShot();
						status="PASS";
						}
					}
				}
			}
		
		return status;
	}
	
	
	public String verifyBookingMessageContent_BookingID_ZoomQRCode_Annonymous(String _PleaseUseThisIdForAnyCommunication,
			String _Bookingreferencelabel,String _ZoomQRLabel) {	
		
		status="FAIL";
		
			if(label_PleaseUseThisIdForAnyCommunication.getText().equals(_PleaseUseThisIdForAnyCommunication)) {
				log(label_PleaseUseThisIdForAnyCommunication.getText()+" is displayed in UI");
				log(label_ReservationCode.getText()+" is displayed in UI");
				if(label_ReservationCode.getText().equals(_Bookingreferencelabel)) {
					log(label_ReservationCode.getText()+" is displayed in ui");
					if(ID_Bookingreference_Annonymous.getText().matches("^[a-zA-Z0-9]*$")) {
						log(ID_Bookingreference_Annonymous.getText()+" is displayed as reference id");
						if(label_ZoomQRCode.getText().equals(_ZoomQRLabel)) {
							log(label_ZoomQRCode.getText()+" label is displayed");
						takeScreenShot();
						status="PASS";
						}
					}
				}
			}
		
		return status;
	}


	
	@FindBy(how=How.XPATH,using ="//p[@translate='_BookingOrderUnderProcess_']")
	WebElement label_BookingConfirmationEmailMessagetext;
	public String verifyBookingConfirmationEmailMsg_WalletImage(String _BookingConfirmationEmailMessagetext) {
		status="FAIL";
		
		int appleWallet=driver.findElements(By.xpath("//div[@class='fb-twitter']//div[1]//a[1]//img[1]")).size();
		int googleWallet=driver.findElements(By.xpath("//div[@class='fb-twitter']//div[2]//a[1]//img[1]")).size();
		
		log(label_BookingConfirmationEmailMessagetext.getText());
		
		if(label_BookingConfirmationEmailMessagetext.getText().equals(_BookingConfirmationEmailMessagetext)) {
			log(label_BookingConfirmationEmailMessagetext.getText()+" is displayed");
			if(appleWallet==1) {
				if(googleWallet==1) {
					log("FB/Twitter button  are displayed");
					takeScreenShot();
					status="PASS";
				}
			}
		}
		
		return status;
	}

	
	@FindBy(how=How.XPATH,using ="//div[@translate='_DownloadBookingConfirmation_']")
	WebElement link_DownloadBookingConfirmation;
	public String verifyDownloadBookingConfirmationLink(String _DownloadBookingConfirmation) {
		status="FAIL";
	
		if(link_DownloadBookingConfirmation.getText().equals(_DownloadBookingConfirmation)) {
			log(link_DownloadBookingConfirmation.getText());
			takeScreenShot();
			status="PASS";
		}
		return status;
	}

	public void clickonDownloadBookingConfirmation() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(link_DownloadBookingConfirmation, driver, 20);
		link_DownloadBookingConfirmation.click();
		log("Clicked on the Download booking confirmation link to download the pdf");
		
	}
	
	
	public String isFileDownloaded_Ext(String dirPath, String ext){
		status="FAIL";
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();

	    
	    if (files == null || files.length == 0) {
	    	status = "FAIL";
	    }
	    
	    for (int i = 0; i < files.length; i++) {
	    	if(files[i].getName().contains(ext)) {
	    		log(files[i].getName() +" is downloaded in the folder");
	    		status="PASS";
	    	}
	    }
	    return status;
	}

	
	@FindBy(how=How.XPATH,using ="//h2[@translate='_ParkerVehicle_']")
	WebElement label_ParkerAndVehicle;
	
	@FindBy(how=How.XPATH,using ="//div[@class='parker-details']//*[@translate='_Parker_']")
	WebElement label_Parker;
	
	@FindBy(how=How.XPATH,using ="//strong[@translate='_Vehicle_']")
	WebElement label_Vehicle;
	
	@FindBy(how=How.XPATH,using ="//span[@data-ng-bind='item.parkerName']")
	WebElement ParkerName;
	
	@FindBy(how=How.XPATH,using ="//span[@data-ng-bind='item.parkerEmail']")
	WebElement ParkerEmail;
	
	@FindBy(how=How.XPATH,using ="//div[@class='vehicle-details ng-scope']//span[@class='ng-binding']")
	WebElement ParkerVehicleId;
	
	
	
	public String verifyParkerAndVehicleLabelSection(String _IdType,String _ParkerVehicleHeader,String _ParkerLabel,String _VehicleLabel,String _ParkerName,String _ParkerEmail,String _ID) throws InterruptedException {
		status="FAIL";
		WaitHelper wh = new WaitHelper(driver, test);
		Thread.sleep(3000);
		wh.waitForElementToBeVisible(label_ParkerAndVehicle, driver, 10);
		wh.waitForElementToBeVisible(label_Parker, driver, 10);
		
		if(_IdType.contains("License plate")) {
			if(label_ParkerAndVehicle.getText().equals(_ParkerVehicleHeader)) {
				if(label_Parker.getText().equals(_ParkerLabel)) {
					if(ParkerName.getText().equals(_ParkerName)) {
						if(ParkerEmail.getText().equals(_ParkerEmail)) {
			                  if(ParkerVehicleId.getText().equals(_ID)) {
			                	  log(label_ParkerAndVehicle.getText() +"-----" +label_Parker.getText()+"----"+ParkerName.getText()+"---"+ParkerEmail.getText()+"---"+ParkerVehicleId.getText());
			                	  status="PASS";
			                	  takeScreenShot();
			                  
			                  }
			                
						}
					}
				}
			}
		}
		else {
			if(label_ParkerAndVehicle.getText().equals(_ParkerVehicleHeader)) {
				if(label_Parker.getText().equals(_ParkerLabel)) {
					if(ParkerName.getText().equals(_ParkerName)) {
						if(ParkerEmail.getText().equals(_ParkerEmail)) {
							if(ParkerEmail.getText().equals(_ParkerEmail)) 
			                	  log(label_ParkerAndVehicle.getText() +"-----" +label_Parker.getText()+"----"+ParkerName.getText()+"---"+ParkerEmail.getText());
			                	  status="PASS";
			                	  takeScreenShot();
			                  
			                  }
			                }
						}
					}
				}
		return status;
	
	}

	
	
	
	@FindBy(how=How.XPATH,using ="//h2[@translate='_Identification_']")
	WebElement IdentificationLabel;
	
	@FindBy(how=How.XPATH,using ="//strong[@translate='_AccessMediaType_']")
	WebElement AccessMediaTypeLabel;
	
	@FindBy(how=How.XPATH,using ="//strong[@translate='_IDNumber_']")
	WebElement IDNumberLabel;
	
	@FindBy(how=How.XPATH,using ="//span[@data-ng-bind='prop.identificationType.name']")
	WebElement AccessMediaTypeValue;
	
	@FindBy(how=How.XPATH,using ="//div[@class='id-details']//div//span[@data-ng-bind='prop.value']")
	WebElement IdNumberValue;
	
	public String verifyIdentificationLabelSection(String _Id,String _IdentificationLabel, String _AccessMediaTypeLabel, String _IDNumberLabel, String _AccessMediaTypeValue) throws InterruptedException {
	
		status="FAIL";
		
		
		
		if(IdentificationLabel.getText().equals(_IdentificationLabel)) {
			if(AccessMediaTypeLabel.getText().equals(_AccessMediaTypeLabel)) {
				if(IDNumberLabel.getText().equals(_IDNumberLabel)) {
					if(AccessMediaTypeValue.getText().equals(_AccessMediaTypeValue)) {	
						if(IdNumberValue.getText().equals(_Id)) {
							

							log(IdentificationLabel.getText()+" label is displayed in the confirmation page");
							log(AccessMediaTypeLabel.getText()+" label is displayed in the Parker details");
							log(IDNumberLabel.getText()+" label is displayed in the Parker details");
							
							log(AccessMediaTypeValue.getText()+" value is displayed in the Access Media Type");
							log(IdNumberValue.getText()+" value is displayed in the ID number");
							
							
							status="PASS";
							takeScreenShot();
						}

					}

				}
				
			}
			
		}
		return status;
		
		
	}

	public void clickOnBookingId() {
		log("Click on the "+ID_Bookingreference.getText());
		ID_Bookingreference.click();
		takeScreenShot();
		

	}

	public String getBookingID() {

       return ID_Bookingreference.getText();
		
	}
	
	public String getBookingIDAnonymous() {

	       return ID_Bookingreference_Annonymous.getText();
			
		}

	
	
	
	public String getFirstProductNameFromConfirmationPage() {
		
		String firstPurchasedProductName = driver.findElement(By.xpath("//div[@class='product-name ng-binding']")).getText();
		
		return firstPurchasedProductName;

	}

	public String getFirstProductStartDateAndTime() {
		String finalDate=null;
		String date = null;
		String month = null;
		String year = null;
		String ampm = null;
		
		
		String startdate = driver.findElement(By.xpath("//div[@class='col-xs-9 col-sm-9 col-md-9 col-lg-9 pl-0']//div[1]//div[1]")).getText();
		ampm = driver.findElement(By.xpath("//div[@class='col-xs-9 col-sm-9 col-md-9 col-lg-9 pl-0']//div[1]//div[2]")).getText();
		String[] startdatesplit = startdate.split(" ");
		
		
			date=startdatesplit[0];
			month=startdatesplit[1];
			year=startdatesplit[2];
		
			DateAndUniqueNoGenerateHelper dh = new DateAndUniqueNoGenerateHelper();
			month = dh.convertMonthInTextToNumber(month);
			
		
			
			if(ampm.substring(0,1).equals("0")){
				finalDate = month+"/"+date+"/"+year+" "+ampm.substring(1, ampm.length());
			}
			else {
				finalDate = month+"/"+date+"/"+year+" "+ampm;
			}
			
			

		return finalDate;
	}
	
	
	
	public String getFirstProductStartDateAndTimeSubscription() {
		String finalDate=null;
		String date = null;
		String month = null;
		String year = null;
		//String ampm = null;
		
		
		String startdate = driver.findElement(By.xpath("//div[@class='date ng-binding']")).getText();
	//	ampm = driver.findElement(By.xpath("//strong[@translate='_From_']//ancestor::div[1]/div[2]")).getText();
		String[] startdatesplit = startdate.split(" ");
		
		
			date=startdatesplit[0];
			month=startdatesplit[1];
			year=startdatesplit[2];
		
			DateAndUniqueNoGenerateHelper dh = new DateAndUniqueNoGenerateHelper();
			month = dh.convertMonthInTextToNumber(month);

				finalDate = month+"/"+date+"/"+year;

		return finalDate;
	}
	
	
	
	
	public String getFirstProductEndDateAndTime() {
		String finalDate=null;
		String date = null;
		String month = null;
		String year = null;
		String ampm = null;
		
		
		String startdate = driver.findElement(By.xpath("//div[@class='col-xs-9 col-sm-9 col-md-9 col-lg-9 pl-0']//div[2]//div[1]")).getText();
		ampm = driver.findElement(By.xpath("//div[@class='col-xs-9 col-sm-9 col-md-9 col-lg-9 pl-0']//div[2]//div[2]")).getText();
		String[] startdatesplit = startdate.split(" ");
		
		
			date=startdatesplit[0];
			month=startdatesplit[1];
			year=startdatesplit[2];
		
			DateAndUniqueNoGenerateHelper dh = new DateAndUniqueNoGenerateHelper();
			month = dh.convertMonthInTextToNumber(month);
			

			if(ampm.substring(0,1).equals("0")){
				finalDate = month+"/"+date+"/"+year+" "+ampm.substring(1, ampm.length());
			}
			else {
				finalDate = month+"/"+date+"/"+year+" "+ampm;
			}
			

		return finalDate;
	}
	
	
	
	

}