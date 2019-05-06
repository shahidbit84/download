/**
 *
 */
package com.skidata.uiPages.portal;

import java.util.List;

import org.apache.log4j.Logger;
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
public class SspDashboardPage extends TestBase {

	
	
	String status=null;


	public static final Logger log = Logger.getLogger(SspDashboardPage.class.getName());



	//Class constructor
	public SspDashboardPage(WebDriver driver,ExtentTest test) {
		this.test=test;
		this.driver = driver;
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
			log("Title of the  page is "+driver.getTitle());
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

	@FindBy(how=How.XPATH,using ="//h1[@translate='_ProfileDashboard_']")
	WebElement header_Dashboard;
	
	@FindBy(how=How.XPATH,using ="//div[@translate='_UpcomingBookings_']")
	WebElement label_Upcoming_bookings;
	
	@FindBy(how=How.XPATH,using ="//div[@translate='_UpcomingSubscriptions_']")
	WebElement label_Your_Subscriptions;
	
	@FindBy(how=How.XPATH,using ="//div[@translate='_ProfilePaymentCards_']")
	WebElement label_PaymentMethod;
	
	@FindBy(how=How.XPATH,using ="//div[@translate='_Identifications_']")
	WebElement label_Identifications;
	
	public String verifyLabelsInDashboard(String _Header,String _Upcomingbookings,String _YourSubscriptions,String _MyParkers,String _Identifications) {
		status="FAIL";
	
		if(header_Dashboard.getText().equals(_Header)) {	
			 log(header_Dashboard.getText()+" is displayed");
		if(label_Upcoming_bookings.getText().equals(_Upcomingbookings)) {
		   log(label_Upcoming_bookings.getText()+" is displayed");
			if(label_Your_Subscriptions.getText().equals(_YourSubscriptions)) {
				log(label_Your_Subscriptions.getText()+" is displayed");
				if(label_PaymentMethod.getText().equals(_MyParkers)) {
					log(label_PaymentMethod.getText()+" is displayed");
					if(label_Identifications.getText().equals(_Identifications)) {
						log(label_Identifications.getText()+" is displayed");
						status="PASS";
						takeScreenShot();
						
					}
				}
			}
		}
		}
		return status;
		
		
	}





	
	
	@FindBy(how=How.XPATH,using ="//a[@translate='_SeeAll_' and @data-ng-click='getUrl(linkObjects[0])']")
	WebElement link_Seeall_UpcomingBookings;
	public void clickOnSeeall_UpcomingBookings() {
		
		link_Seeall_UpcomingBookings.click();
		log("Clicked on See all link in the Upcoming bookings section");
		takeScreenShot();
		
	}

	@FindBy(how=How.XPATH,using ="//span[contains(text(),'Reservations')]")
	WebElement Profile_Reservation_Link;
	
	public void ClickOn_ProfileReservation(){
		 
		WaitHelper wh = new WaitHelper(driver,test);
		wh.waitForElementToBeClickable(Profile_Reservation_Link, driver, 10);
		
		Profile_Reservation_Link.click();
		log("Profile reservation clicked");
	}

	
	@FindBy(how=How.XPATH,using ="//span[contains(text(),'Subscription')]")
	WebElement Profile_Subscription_Link;
	
	public void ClickOn_ProfileSubscription(){
		 
		WaitHelper wh = new WaitHelper(driver,test);
		wh.waitForElementToBeClickable(Profile_Subscription_Link, driver, 10);
		
		Profile_Subscription_Link.click();
		log("Profile subscription clicked");
	}

	

	@FindBy(how=How.XPATH,using ="//a[@translate='_SeeAll_' and @data-ng-click='getUrl(linkObjects[1])']")
	WebElement link_Seeall_YourSubscriptions;
	public void clickOnSeeall_YourSubscriptions() {
		
		link_Seeall_YourSubscriptions.click();
		log("Clicked on See all link in the Your Subscriptions section");
		takeScreenShot();
		
	}

	@FindBy(how=How.XPATH,using ="//a[@translate='_SeeAll_' and @data-ng-click='getUrl(linkObjects[2])']")
	WebElement link_Seeall_Payment_Method;
	public void clickOnSeeall_PaymentMethod() {
		link_Seeall_Payment_Method.click();
		log("Clicked on See all link in the Payment Method section");
		takeScreenShot();
		
	}


	@FindBy(how=How.XPATH,using ="//a[@ui-sref='profile.parkers']")
	WebElement link_Seeall_MyParkers;
	public void clickOnSeeall_Myparkers() {
		link_Seeall_MyParkers.click();
		log("Clicked on See all link in the My parkers section");
		takeScreenShot();
		
	}

	
	@FindBy(how=How.XPATH,using ="//a[@translate='_SeeAll_' and @data-ng-click='getUrl(linkObjects[3])']")
	WebElement link_Seeall_Identifications;
	public void clickOnSeeall_Identifications() {
		link_Seeall_Identifications.click();
		log("Clicked on See all link in the My Identifications section");
		takeScreenShot();
		
	}




	@FindBy(how=How.XPATH,using ="//a[@ui-sref='.parkers']//div")
	WebElement link_MyParkers;
	public void clickOnMyParkers() {
		link_MyParkers.click();
		log("Clicked on My Parkers link");
		takeScreenShot();
		
	}




	//@FindBy(how=How.XPATH,using ="//div[@class='hidden-sm ng-binding ng-scope'][contains(text(),'Login & Security')]")
	@FindBy(how=How.XPATH,using ="//span[contains(text(),'Login & Security')]")
	
	WebElement link_LoginAndSecurity;
	
	public void clickOnLoginAndSecurity() {
		
		link_LoginAndSecurity.click();
		log("clicked on Login&Security");
		takeScreenShot();
	}




	//@FindBy(how=How.XPATH,using ="//div[@class='hidden-sm ng-binding ng-scope'][contains(text(),'Addresses')]")
	@FindBy(how=How.XPATH,using ="//span[contains(text(),'Addresses')]")
	WebElement link_Addresses;
	public void clickOnAddresses(){
		link_Addresses.click();
		log("clicked on Addresses");
		takeScreenShot();
		
	}




	@FindBy(how=How.XPATH,using ="//div[@class='hidden-sm ng-binding ng-scope'][contains(text(),'Identifications')]")
	WebElement link_Identifications;
	public void clickOnIdentifications() {
		link_Identifications.click();
		log("clicked on Identifications");
		takeScreenShot();
		
	}
	

	//indBy(how=How.XPATH,using ="//div[contains(text(),'IDs & Parkers')]")
	@FindBy(how=How.XPATH,using ="//span[contains(text(),'IDs & Parkers')]")
	WebElement link_Ids_parkers;
	public void clickOnlink_Ids_parkers() {
		link_Ids_parkers.click();
		log("clicked on Ids & parkers link");
		takeScreenShot();
		
	}





	@FindBy(how=How.XPATH,using ="//a[@class='logout']//div")
	WebElement link_LOGOUT;
	public void clickOnLOGOUT() throws InterruptedException {
	
		link_LOGOUT.click();
		log("clicked on the LOGOUT link");
		takeScreenShot();
		Thread.sleep(6000);
		
	}




	@FindBy(how=How.XPATH,using ="//div//div[@class='row mx-0']//div[@class='row mx-0']//div[1]//div[1]//div[3]//img[1]")
	WebElement img_UpcomingReservation;
	
	@FindBy(how=How.XPATH,using ="//img[@class='subscriptions-img']")
	WebElement img_UpcomingSubscription;
	
	@FindBy(how=How.XPATH,using ="//div[@class='thumbnail-payment-block']//img[@draggable='false']")
	WebElement img_paymentCards;
	
	@FindBy(how=How.XPATH,using ="//img[@class='identifications-img']")
	WebElement img_identificationList;
	
	@FindBy(how=How.XPATH,using ="//h4[@translate='_YouDoNotHaveAnyReservations_']")
	WebElement h4_UpcomingReservation;
	
	@FindBy(how=How.XPATH,using ="//h4[@translate='_YouDoNotHaveAnySubscriptions_']")
	WebElement h4_UpcomingSubscription;
	
	@FindBy(how=How.XPATH,using ="//h4[@translate='_YouDoNotHaveAnyPaymentMethods_']")
	WebElement h4_paymentCards;
	
	@FindBy(how=How.XPATH,using ="//h4[@translate='_YouDoNotHaveAnyIdentifications_']")
	WebElement h4_identificationList;
	
	@FindBy(how=How.XPATH,using ="//span[@translate='_DashboardAddReservation_']")
	WebElement btn_AddReservation;
	
	@FindBy(how=How.XPATH,using ="//span[@translate='_DashboardAddSubscription_']")
	WebElement btn_AddSubscription;
	
	@FindBy(how=How.XPATH,using ="//span[@translate='_DashboardAddPaymentMethod_']")
	WebElement btn_AddpaymentCards;
	
	@FindBy(how=How.XPATH,using ="//span[@translate='_DashboardAddIdentification_']")
	WebElement btn_AddidentificationList;
	
	public String verifyImagesAndMessagesDisplayed(String _UpcomingReservationMsg,String _UpcomingSubscriptionMsg,String _NoPaymentMsg,String _NoIdentificationMsg) {
	
		status="FAIL";
		if(img_UpcomingReservation.isDisplayed() && img_UpcomingSubscription.isDisplayed() && img_paymentCards.isDisplayed() && img_identificationList.isDisplayed()) {
			log("All image icons are displayed for Upcoming reservation, subscriptions, payments and identifications");
			log(h4_UpcomingReservation.getText());
			log(h4_UpcomingSubscription.getText());
			log(h4_paymentCards.getText());
			log(h4_identificationList.getText());
			if(h4_UpcomingReservation.getText().equals(_UpcomingReservationMsg) && 
			   h4_UpcomingSubscription.getText().equals(_UpcomingSubscriptionMsg) &&
			   h4_paymentCards.getText().equals(_NoPaymentMsg) &&
			   h4_identificationList.getText().equals(_NoIdentificationMsg)) {
				status ="PASS";
				log("Messages and Images are displayed correctly in the Dashboard page");
			}
			
		}
		
		return status;
	}

	public String verifyIButtonsDisplayed(String _AddReservationButton, String _AddSubscriptionMButton, String _AddPaymentbutton, String _AddIdentificationButton) {
	
		log(btn_AddReservation.getText());
		log(btn_AddSubscription.getText());
		log(btn_AddpaymentCards.getText());
		log(btn_AddidentificationList.getText());
		status="FAIL";
		if(btn_AddReservation.getText().equals(_AddReservationButton) &&
		   btn_AddSubscription.getText().equals(_AddSubscriptionMButton) &&
		   btn_AddpaymentCards.getText().equals(_AddPaymentbutton) &&
		   btn_AddidentificationList.getText().equals(_AddIdentificationButton)) {
			
		   log(" All buttons are displayed in Dashboard page correctly");
			status="PASS";
			takeScreenShot();
		}
		
		
		return status;
	}





	
	

}