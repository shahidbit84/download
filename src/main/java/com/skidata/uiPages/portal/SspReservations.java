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
public class SspReservations extends TestBase {

	
	
	String status=null;


	public static final Logger log = Logger.getLogger(SspReservations.class.getName());



	//Class constructor
	public SspReservations(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
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

	@FindBy(how=How.XPATH,using ="//div[@id='mydiv']//div[@class='loader']")
	WebElement loader;	
	
	@FindBy(how=How.XPATH,using ="//a[@id='goToProducts']/div")
	WebElement link_ContinueShopping;
	
	@FindBy(how=How.XPATH,using ="//div[@translate='_BackToBookings_']")
	WebElement link_BackToReservation;

	@FindBy(how=How.XPATH,using ="//h1[@class='ng-scope' and @translate='_Bookings_']")
	WebElement pageHeader_Reservation;
	
	@FindBy(how=How.XPATH,using ="//a[@class='ng-binding ng-scope']")
	WebElement pageHeader_FindReservation;
	
	@FindBy(how=How.XPATH,using ="//span[contains(text(),'Show:')]")
	WebElement pageHeader_Show;
	
	@FindBy(how=How.XPATH,using ="//button[contains(text(),'All Reservations')]")
	WebElement AllReservationsDropDownLink;
	
	@FindBy(how=How.XPATH,using ="//h2[@class='ng-scope' and @translate='_UpcomingBookings_']")
	WebElement UpcomingReservationText;
	
	@FindBy(how=How.XPATH,using ="//span[@translate='_CancelSelectedReservation_']")
	WebElement CancelSelectedReservation_Link;
	
	@FindBy(how=How.XPATH,using ="//div[@translate='_ViewBooking_']")
	WebElement ViewButton_Link;
	
	@FindBy(how=How.XPATH,using ="//strong[@class='ng-binding'][contains(text(),'From:')]")
	WebElement FromText;
	
	@FindBy(how=How.XPATH,using ="//strong[@class='ng-binding'][contains(text(),'To:')]")
	WebElement ToText;
	
	@FindBy(how=How.XPATH,using ="//strong[@translate='_Extras_']")
	WebElement ExtraText;
	
	@FindBy(how=How.XPATH,using ="//strong[@class='ng-binding'][contains(text(),'Reservation Code:')]")
	WebElement ReservationCode_Text;
	
	@FindBy(how=How.XPATH,using ="//strong[@class='ng-binding'][contains(text(),'Total Price:')]")
	WebElement TotalPrice_Text;
	
	@FindBy(how=How.XPATH,using ="//a[@class='cancellation ng-binding']")
	WebElement CancelationAndContractLink;
	
	@FindBy(how=How.XPATH,using ="//div[@translate='_Details_']")
	WebElement Details_Link;
	
	@FindBy(how=How.XPATH,using ="//h2[@translate='_Parker_']")
	WebElement ParkerHeaderText;
	
	@FindBy(how=How.XPATH,using ="//strong[@translate='_Parker_']")
	WebElement ParkerSubHeader;
	
	@FindBy(how=How.XPATH,using ="//span[@data-ng-bind='currentOrderLine.parkerName']")
	WebElement ParkerName;
	
	@FindBy(how=How.XPATH,using ="//span[@data-ng-bind='currentOrderLine.parkerEmail']")
	WebElement ParkerEmail;
	
	@FindBy(how=How.XPATH,using ="//h2[@translate='_Identification_']")
	WebElement Identification_Header;
	
	@FindBy(how=How.XPATH,using ="//strong[@class='ng-binding' and @data-ng-bind='item.identificationType.name']")
	WebElement Identification_CardName;
	
	@FindBy(how=How.XPATH,using ="//span[@class='ng-binding' and @data-ng-bind='item.value']")
	WebElement Identification_ID_valueText;
	
	@FindBy(how=How.XPATH,using ="//span[@data-ng-bind='item.value']")
	WebElement Identification_CardNumber;
	
	@FindBy(how=How.XPATH,using ="//div[@class='link ng-scope' and @translate='_ResendConfirmationEmail_']")
	WebElement Resend_ConfirmationMail_Link;
	
	@FindBy(how=How.XPATH,using ="//span[@data-ng-bind='cancelRBtnText']")
	WebElement CancelReservation_Link;
	
	@FindBy(how=How.XPATH,using ="//div[@translate='_BackToSubscriptions_']")
	WebElement BackToSubscription_Link;
	
	
	

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
	
	public void clickonBackToReservationLink() {
		
		link_BackToReservation.click();
		log("clicked on < Back To Reservation link");
		takeScreenShot();
	
	}
	
	public void clickonBackToSubscriptionLink() throws InterruptedException {
		
		Thread.sleep(2000);
		BackToSubscription_Link.click();
		log("clicked on < Back To Subscriptions link");
		takeScreenShot();
	
	}
	
	public void clickonViewLink() {
		
		ViewButton_Link.click();
		log("clicked on < View Reservation link");
		takeScreenShot();
	
	}
	
	
	/*Verify Reservation Page Label And Header After Reservation Booking Pass*/
	
	public String verifyPageHeaderAndLabel_AfterBookingPass(String _PageHeader_Reservation,String _PageHeader_Show,String _PageHeader_AllReservation) throws InterruptedException {
		status="FAIL";
		Thread.sleep(1000);
		if(pageHeader_Reservation.getText().equals(_PageHeader_Reservation)) {
			log(pageHeader_Reservation.getText()+" is displayed");
			     if(pageHeader_Show.getText().equals(_PageHeader_Show)) {
				     log(pageHeader_Show.getText()+" is displayed");
				 if(AllReservationsDropDownLink.getText().equals(_PageHeader_AllReservation))
		    log(AllReservationsDropDownLink.getText()+" is displayed");
				
				takeScreenShot();
				status="PASS";
			}	
		}
		return status;
	}
	
	
	/*In Reservation Page Verify Added Reservation Product Label And Header After Reservation Booking Pass*/
	
	public String verifySingleProduct_HeaderAndLabel_AfterBookingPass(String _PageHeader_UpcomingReservation,String _PageHeader_CancelSelectedReservation,String _From,String _To,String _ReservationCode,String _TotalPrice,String _View) throws InterruptedException {
		status="FAIL";
		Thread.sleep(1000);
		if(UpcomingReservationText.getText().equals(_PageHeader_UpcomingReservation)) {
			log(UpcomingReservationText.getText()+" is displayed");
		        if(CancelSelectedReservation_Link.getText().equals(_PageHeader_CancelSelectedReservation)) 
				    log(CancelSelectedReservation_Link.getText()+" is displayed");
			            if(FromText.getText().equals(_From)) {
				             log(FromText.getText()+" is displayed In The Added Product");
				                 if(ToText.getText().equals(_To))
					                  log(ToText.getText()+" is displayed In The Added Product");
//				                           if(ExtraText.getText().equals(_Extra))
//				                               log(ExtraText.getText()+" is displayed In The Added Product");
		                                   if(ReservationCode_Text.getText().equals(_ReservationCode))
		                              log(ReservationCode_Text.getText()+" is displayed In The Added Product");
                                 if(TotalPrice_Text.getText().equals(_TotalPrice))
                            log(TotalPrice_Text.getText()+" is displayed In The Added Product");   
                         if(ViewButton_Link.getText().equals(_View))
                      log(ViewButton_Link.getText()+" is displayed In The Added Product");
                                 
                           
                takeScreenShot();
				status="PASS";
			}	
		}
		return status;
	}
	
	/*Verify single product header and label after click on View reservation*/
	
	public String verifySingleProduct_HeaderAndLabel_AfterClickOnViewReservation(String _From,String _To,String _ReservationCode,String CancelationAndContract_Link,String DetailsLink,String Parker_HeaderText,String _ParkerSubHeader,String _ParkerName,String _ParkerEmail,String _IdentificationHeader,String _IdentificationCardName,String _IdentificationID_valueText,String _Identification_CardNumber,String _Resend_ConfirmationMailLink,String _CancelReservationLink) throws InterruptedException {
		status="FAIL";
		Thread.sleep(1000);
		if(FromText.getText().equals(_From)) {
			log(FromText.getText()+" is displayed");
		        if(ToText.getText().equals(_To)) 
				    log(ToText.getText()+" is displayed");
			            if(ReservationCode_Text.getText().equals(_ReservationCode)) {
				             log(ReservationCode_Text.getText()+" is displayed In The Added Product");
				                  if(CancelationAndContractLink.getAttribute("class").equals(CancelationAndContract_Link))
				        			log(CancelationAndContractLink.getAttribute("class")+"--> CancelationAndContract Link is displayed in the added product");
//				                       if(CancelationAndContractLink.getText().equals(CancelationAndContract_Link))
//					                      log(CancelationAndContractLink.getText()+" is displayed In The Added Product");
				                             if(Details_Link.getText().equals(DetailsLink))
				                                 log(Details_Link.getText()+" is displayed In The Added Product");
		                                            if(ParkerHeaderText.getText().equals(Parker_HeaderText))
		                                               log(ParkerHeaderText.getText()+" is displayed In The Added Product");
                                                          if(ParkerSubHeader.getText().equals(_ParkerSubHeader))
                                                             log(ParkerSubHeader.getText()+" is displayed In The Added Product");   
                                                                if(ParkerName.getText().equals(_ParkerName))
                                                                  log(ParkerName.getText()+" is displayed In The Added Product");
                                                                
                                                                  if(ParkerEmail.getAttribute("class").equals(_ParkerEmail))
                                       				              log(ParkerEmail.getAttribute("class")+"--> parker Email is displayed In The Added Product");  	 
                                                                
//                                                          if(ParkerEmail.getText().equals(_ParkerEmail))
//                                                      log(ParkerEmail.getText()+" is displayed In The Added Product");
                                                    if(Identification_Header.getText().equals(_IdentificationHeader))
                                                       log(Identification_Header.getText()+" is displayed In The Added Product");                     
                                             
                                                    if(Identification_CardName.getAttribute("class").equals(_IdentificationCardName))
                             				           log(Identification_CardName.getAttribute("class")+"--> Identification Card Name is displayed In The Added Product");  	
                                                    
 //                                              if(Identification_CardName.getText().equals(_IdentificationCardName))
//                                            log(Identification_CardName.getText()+" is displayed In The Added Product"); 
                                         if(Identification_ID_valueText.getText().equals(_IdentificationID_valueText))
                                       log(Identification_ID_valueText.getText()+" is displayed In The Added Product"); 
//                                     if(Identification_CardNumber.getAttribute("class").equals(_Identification_CardNumber))
//     				              log(Identification_CardNumber.getAttribute("class")+"--> parker name field is displayed for parker Details form");  	 
//                              if(Identification_CardNumber.getText().equals(_Identification_CardNumber))
//                            log(Identification_CardNumber.getText()+" is displayed In The Added Product"); 
                            if(Resend_ConfirmationMail_Link.getText().equals(_Resend_ConfirmationMailLink))
                         log(Resend_ConfirmationMail_Link.getText()+" is displayed In The Added Product"); 
                      if(CancelReservation_Link.getText().equals(_CancelReservationLink))
                   log(CancelReservation_Link.getText()+" is displayed In The Added Product"); 
              
             
                takeScreenShot();
				status="PASS";
			}	
		}
		return status;
	}
	
	
	/*QR CODE DISPLAYED IN RESERVATION PAGE AFTER BOOKING PASS*/

	public String verifyQRCodeGenerated() {
		status="FAIL";
		int images = driver.findElements(By.xpath("//div[contains(@class,'qr-code')]//img[contains(@class,'img-responsive')]")).size();
		if(images==1) {
			log("QR code image is displayed");
			status="PASS";
			takeScreenShot();
		}
		return status;
	}
	
	/*Verify Resend Email Confirmation Message*/
	
	
	@FindBy(how=How.XPATH,using ="//div[@class='col-md-12 col-sm-12 col-xs-12']//span[@class='ssp-icon_arrow_right']")
	WebElement ResendEmailConfirmation_Link;
	
	
      public void ClickOn_ResendConfirmationMailLink() throws InterruptedException {
		
    	  WaitHelper wh = new WaitHelper(driver, test);
  		  wh.waitForElementToBeVisible(ResendEmailConfirmation_Link, driver, 20);
  		  ResendEmailConfirmation_Link.click();
		  log("Clicked On Resend Confirmation Mail Link");
		  takeScreenShot();
	
	}
	
	@FindBy(how=How.XPATH,using ="//span[@class='resend-confirm-msg ng-binding']")
	WebElement EmailConfirmation_Message;
	
	public String verifyEmail_ConfirmationMessage(String _EmailConfirmation_Message) throws InterruptedException {
		status="FAIL";
//		Thread.sleep(5000);
//		Resend_ConfirmationMail_Link.click();
//		log("clicked on resend confirmation mail link");
		Thread.sleep(1000);
		if(EmailConfirmation_Message.getText().equals(_EmailConfirmation_Message)) {
			log(EmailConfirmation_Message.getText()+" is displayed");
		       
                takeScreenShot();
				status="PASS";
			}	
		
		return status;
	}
	
	/*Click on cancel reservation*/
	
         public void ClickOn_CancelReservation() throws InterruptedException {
		
    	  WaitHelper wh = new WaitHelper(driver, test);
  		  wh.waitForElementToBeVisible(CancelReservation_Link, driver, 20);
  		  CancelReservation_Link.click();
		  log("Clicked On Cancel Reservation Link");
		  takeScreenShot();
	
	}
         
         
         /*Click on cancel subscription in profile subscription page*/
         
         
         public void ClickOn_CancelSubscription() throws InterruptedException {
     		
       	  WaitHelper wh = new WaitHelper(driver, test);
     		  wh.waitForElementToBeVisible(CancelSubscription_Link, driver, 20);
     		 CancelSubscription_Link.click();
   		  log("Clicked On Cancel Subscription Link");
   		  takeScreenShot();
   	
   	}
         
         /*Verify Cancel Reservation Message*/
         
         @FindBy(how=How.XPATH,using ="//h1[@class='text-center ng-binding']")
     	 WebElement CancelReservation_Message;
         
         public String verifyCancelReservationMessage(String _CancelReservationMessage) throws InterruptedException {

     		status="FAIL";
     		Thread.sleep(2000);
     		
     		log(CancelReservation_Message.getText());
     		
     		if(CancelReservation_Message.getText().equals(_CancelReservationMessage)) {
     			log(CancelReservation_Message.getText()+" is displayed");
     			takeScreenShot();
     			status="PASS";
     		}
     		return status;
     		
     		
     	}
         
         /*Verify cancel subscription message*/
         
         @FindBy(how=How.XPATH,using ="//h1[@class='text-center ng-binding']")
     	 WebElement CancelSubscription_Message;
         
         public String verifyCancelSubscriptionMessage(String _CancelSubscriptionMessage) throws InterruptedException {

     		status="FAIL";
     		Thread.sleep(2000);
     		
     		log(CancelSubscription_Message.getText());
     		
     		if(CancelSubscription_Message.getText().equals(_CancelSubscriptionMessage)) {
     			log(CancelSubscription_Message.getText()+" is displayed");
     			takeScreenShot();
     			status="PASS";
     		}
     		return status;
     		
     		
     	}
         
         
         
         /*
          * Method to verify header and labels in profile reservation page if user don't have any active bookings
          * */
         
         
         @FindBy(how=How.XPATH,using="//h2[@class='ng-scope' and @translate='_YouDoNotHaveAnyReservations_']")
         WebElement ReservationPageHeaderText_If_No_ActiveBookings;
         
         @FindBy(how=How.XPATH,using="//p[@class='ng-scope' and @translate='_PleaseClickToAddReservations_']")
         WebElement ReservationPageSubHeader_If_No_ActiveBookings;
         
         @FindBy(how=How.XPATH,using="//span[@translate='_DashboardAddReservation_']")
         WebElement ReservationPage_AddButton_Link;
         
         @FindBy(how=How.XPATH,using="//h1[@class='ng-scope' and @translate='_Bookings_']")
         WebElement ReservationPage_Header;
         
         @FindBy(how=How.XPATH,using="//span[@class='link ng-scope' and @translate='_FindABooking_']")
         WebElement ReservationPage_FindReserbation_Link;
         
         public String Verify_ReservationPg_HeaderAndLabels_If_No_Reservations(String Header,String _PageHeader_Show, String _PageHeader_AllReservation,String _FindReservation,String _SubHeaderText1, String _SubHeaderText2,String _AddButton) {
			 
        	 status="FAIL";
        	 
        	 if(ReservationPage_Header.getText().equals(Header)) {
        		 log(ReservationPage_Header.getText());
        	 
        		 if(pageHeader_Show.getText().equals(_PageHeader_Show)) {
				     log(pageHeader_Show.getText()+" is displayed");
				       if(AllReservationsDropDownLink.getText().equals(_PageHeader_AllReservation))
		                  log(AllReservationsDropDownLink.getText()+" is displayed");
        	                 if(ReservationPageHeaderText_If_No_ActiveBookings.getText().equals(_SubHeaderText1)) {
				                log(ReservationPageHeaderText_If_No_ActiveBookings.getText());
				             if(ReservationPageSubHeader_If_No_ActiveBookings.getText().equals(_SubHeaderText2)) {
					      log(ReservationPageSubHeader_If_No_ActiveBookings.getText());
					    if(ReservationPage_AddButton_Link.getText().equals(_AddButton)) {
					log(ReservationPage_AddButton_Link.getText());
						
					    takeScreenShot();
						status="PASS";
					  }
				     }
				   }
				 }
			  }
			
        	 return status;	 
        	 
         }
         
         
         
         /*
          * Method to verify header and labels in profile subscription page if user don't have any active bookings
          * */
         
         
         @FindBy(how=How.XPATH,using="//h2[@class='ng-scope' and @translate='_YouDoNotHaveAnySubscriptions_']")
         WebElement SubscriptionPageHeaderText_If_No_ActiveBookings;
         
         @FindBy(how=How.XPATH,using="//p[@class='ng-scope' and @translate='_PleaseClickToAddSubscriptions_']")
         WebElement SubscriptionPageSubHeader_If_No_ActiveBookings;

         @FindBy(how=How.XPATH,using="//button[contains(text(),'(0)')]")
         WebElement All_Subscription_DropDown_Link;
         
         @FindBy(how=How.XPATH,using="//span[@translate='_DashboardAddSubscription_']")
         WebElement SubscriptionPage_AddButton_Link;
         
         @FindBy(how=How.XPATH,using="//h1[@class='ng-scope' and @translate='_Subscriptions_']")
         WebElement SubscriptionPage_Header;
         
         @FindBy(how=How.XPATH,using="//span[@class='link ng-scope' and @translate='_FindASubscription_']")
         WebElement SubscriptionPage_FindSubscription_Link;
         
         public String Verify_SubscriptionPg_HeaderAndLabels_If_No_Subscriptions(String Header,String _PageHeader_Show, String _PageHeader_AllSubscription,String _FindSubscription,String _SubHeaderText1, String _SubHeaderText2,String _AddButton) {
			 
        	 status="FAIL";
        	 
        	 if(SubscriptionPage_Header.getText().equals(Header)) {
        		 log(SubscriptionPage_Header.getText());
        	 
        		 if(pageHeader_Show.getText().equals(_PageHeader_Show)) {
				     log(pageHeader_Show.getText()+" is displayed");
				       if(All_Subscription_DropDown_Link.getText().equals(_PageHeader_AllSubscription))
		                  log(All_Subscription_DropDown_Link.getText()+" is displayed");
				       
				           if(SubscriptionPage_FindSubscription_Link.getText().equals(_FindSubscription))
			                  log(SubscriptionPage_FindSubscription_Link.getText()+" is displayed");
        	                 if(SubscriptionPageHeaderText_If_No_ActiveBookings.getText().equals(_SubHeaderText1)) {
				                log(SubscriptionPageHeaderText_If_No_ActiveBookings.getText());
				             if(SubscriptionPageSubHeader_If_No_ActiveBookings.getText().equals(_SubHeaderText2)) {
					      log(SubscriptionPageSubHeader_If_No_ActiveBookings.getText());
					    if(SubscriptionPage_AddButton_Link.getText().equals(_AddButton)) {
					log(SubscriptionPage_AddButton_Link.getText());
						
					    takeScreenShot();
						status="PASS";
					  }
				     }
				   }
				 }
			  }
			
        	 return status;	 
        	 
         }
         
         
         /*Verify single product header and label after click on View Subscription*/
         
         @FindBy(how=How.XPATH,using="//div[@translate='_Transactions_']")
         WebElement Transaction_Label;
         
         @FindBy(how=How.XPATH,using="//div[@class='invoices-div ng-scope' and @translate='_Invoices_']")
         WebElement Invoice_Label;
         
         @FindBy(how=How.XPATH,using="//h2[@translate='_BillingAddress_']")
         WebElement BillingAddress_Label;
         
         @FindBy(how=How.XPATH,using="//span[@data-ng-bind='cancelSBtnText']")
         WebElement CancelSubscription_Link;
         
         @FindBy(how=How.XPATH,using="//div[@translate='_ZoomQrCode_']")
         WebElement ZoomEticket_Link;
         
         @FindBy(how=How.XPATH,using="//div[@translate='_AddAnotherIdentification_']")
         WebElement AddAnotherIdentification_Link;
         
         public String verifySingleProduct_HeaderAndLabel_AfterClickOnViewSubscription(String _BackToSubscription,String _From,String _ZoomEticket,String _Duration,String _SubscriptionCode,
        		 String _IdentificationLabel,String AddAnotherIdentification_Label,String _TransactionsLabel,String _InvoiceLabel,
        		 String _Details,String _BillingAddress,String _ResendMailLink,String _CancelSubscriptionLink) {
			
        	 status="PASS";
             if(BackToSubscription_Link.getText().equals(_BackToSubscription)){
            	 log(BackToSubscription_Link.getText()+" is displayed");
            	 if(FromText.getText().equals(_From))
            		 log(FromText.getText()+" is displayed");
            	    if(ZoomEticket_Link.getText().equals(_ZoomEticket))
            	    	log(ZoomEticket_Link.getText()+" is displayed");
            	         if(Duration_Label.getText().equals(_Duration))
            	        	 log(Duration_Label.getText()+" is displayed");
            	              if(SubscriptionCode_Label.getText().equals(_SubscriptionCode))
            	            	  log(SubscriptionCode_Label.getText()+" is displayed");
            	                    if(Identification_Header.getText().equals(_IdentificationLabel))
            	                    	log(Identification_Header.getText()+" is displayed");
            	                           if(AddAnotherIdentification_Link.getText().equals(AddAnotherIdentification_Label))
            	                        	  log(AddAnotherIdentification_Link.getText()+" is displayed");
            	                                 if(Transaction_Label.getText().equals(_TransactionsLabel))
            	                                log(Transaction_Label.getText()+" is displayed");
            	                               if(Invoice_Label.getText().equals(_InvoiceLabel))
            	                             log(Invoice_Label.getText()+" is displayed");
            	                           if(Details_Link.getText().equals(_Details))
            	                         log(Details_Link.getText()+" is displayed");
            	                       if(BillingAddress_Label.getText().equals(_BillingAddress))
            	                     log(BillingAddress_Label.getText()+" is displayed");
            		               if(Resend_ConfirmationMail_Link.getText().equals(_ResendMailLink)) 
            		             log(Resend_ConfirmationMail_Link.getText()+" is displayed");
            		           if(CancelSubscription_Link.getText().equals(_CancelSubscriptionLink))
            		         log(CancelSubscription_Link.getText()+" is displayed");
                              takeScreenShot();
            		          status="PASS";
             }
        	  
        	 return status;
        	 
         }
         
         
         /*Verify Subscription Page Label And Header After Subscription Booking Pass*/
         
         
         @FindBy(how=How.XPATH,using ="//h1[@class='ng-scope' and @translate='_Subscriptions_']")
     	 WebElement pageHeader_Subscription;
         
         @FindBy(how=How.XPATH,using ="//span[contains(text(),'Show:')]")
     	 WebElement Subscription_pageHeader_Show;
         
         @FindBy(how=How.XPATH,using ="//button[contains(text(),'All Subscriptions')]")
     	 WebElement AllSubscriptionsDropDownLink;
         
         @FindBy(how=How.XPATH,using="//h2[@class='ng-scope' and @translate='_UpcomingSubscriptions_']")
         WebElement UpcomingSubscription;
         
         @FindBy(how=How.XPATH,using="//span[@class='link ng-scope' and @translate='_FindASubscription_']")
         WebElement FindSubscription;
         
         @FindBy(how=How.XPATH,using="//strong[contains(text(),'Duration:')]")
         WebElement Duration_Label;
         
         @FindBy(how=How.XPATH,using="//strong[contains(text(),'Subscription Code:')]")
         WebElement SubscriptionCode_Label;
         
      
     	
     	public String verify_Subscriptions_PageHeaderAndLabel_AfterBookingPass(String _PageHeader_Subscription,String _PageHeader_Show,String _PageHeader_AllSubscriptions,String _FindSubscription,String _UpcomingSubscription,String _From,String _Duration,String _SubscritionCode,String _TotalPrice, String _View) throws InterruptedException {
     		status="FAIL";
     		Thread.sleep(1000);
     		if(pageHeader_Subscription.getText().equals(_PageHeader_Subscription)) {
     			log(pageHeader_Subscription.getText()+" is displayed");
     			     if(Subscription_pageHeader_Show.getText().equals(_PageHeader_Show)) {
     				     log(Subscription_pageHeader_Show.getText()+" is displayed");
     				         if(AllSubscriptionsDropDownLink.getText().equals(_PageHeader_AllSubscriptions))
     		                    log(AllSubscriptionsDropDownLink.getText()+" is displayed");
     				               if(FindSubscription.getText().equals(_FindSubscription))
     					              log(FindSubscription.getText()+" is displayed");    				 
     				                      if(UpcomingSubscription.getText().equals(_UpcomingSubscription)) {
     			                              log(UpcomingSubscription.getText()+" is displayed");
     				                             if(FromText.getText().equals(_From))
     					                         log(FromText.getText()+" is displayed");
     				                           if(Duration_Label.getText().equals(_Duration))
     				    	                log(Duration_Label.getText()+" is displayed");
     				                    if(SubscriptionCode_Label.getText().equals(_SubscritionCode))
     				    	        log(SubscriptionCode_Label.getText()+" is displayed");
     				            if(TotalPrice_Text.getText().equals(_TotalPrice))
                             log(TotalPrice_Text.getText()+" is displayed In The Added Product");   
                          if(ViewButton_Link.getText().equals(_View))
                       log(ViewButton_Link.getText()+" is displayed In The Added Product");
     				 
     				takeScreenShot();
     				status="PASS";
     				}
     	        }
     		}
     		return status;
     	} 
     	
     	

}