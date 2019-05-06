/**
 *
 */
package com.skidata.uiPages.portal;


import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.helperclasses.DateAndUniqueNoGenerateHelper;
import com.skidata.helperclasses.JavaScriptHelper;
import com.skidata.helperclasses.WaitHelper;
import com.skidata.testBase.TestBase;

/**
 * @author shmo
 * 
 */
public class SspHomePage extends TestBase {


	
	
	String status=null;


	public static final Logger log = Logger.getLogger(SspHomePage.class.getName());



	//Class constructor
	public SspHomePage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
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

	@FindBy(how=How.XPATH,using ="//div[@translate='_Home_']")
	WebElement label_HomeIcon;

	@FindBy(how=How.XPATH,using ="//div[@translate='_Cart_']")
	WebElement label_CartIcon;

	@FindBy(how=How.XPATH,using ="//div[@translate='_Login_']")
	WebElement link_Login;

	@FindBy(how=How.XPATH,using ="//div[@class='pre-booking text-center']/h1")
	WebElement header_PreBookYourParking;

	@FindBy(how=How.XPATH,using ="//div[@class='pre-booking text-center']/p")
	WebElement subheaderText_PreBookYourParking;

	@FindBy(how=How.ID,using ="banner")
	WebElement image_Banner;

	@FindBy(how=How.XPATH,using ="//a[@translate='_Reservation_']")
	WebElement label_Reservation;

	@FindBy(how=How.XPATH,using ="//a[@translate='_Subscription_']")
	WebElement label_Subscription;

	@FindBy(how=How.XPATH,using ="//div[@id='searchLocations']/div[@class='col-xs-12 col-sm-12 col-md-12 col-lg-12 ssp-auto-search px-0']")
	WebElement field_SearchLocationBar;


	@FindBy(how=How.XPATH,using ="//input[@ng-required='searchRequired']") //input[@id='searchLocationText']
	WebElement inputText_SearchLocationBar;

	@FindBy(how=How.XPATH,using ="//input[@ng-required='searchRequired']")
	WebElement placeholderText_SearchLocationBar;

	@FindBy(how=How.XPATH,using ="//span[@class='ssp-icon_pin_location']")
	WebElement imageMarkerMap_SearchLocationBar;


	@FindBy(how=How.XPATH,using ="//div[@id='searchLocations']//div[@class='noResults ng-scope']//span")
	WebElement label_SearchLocationBarErrorMessage_InvalidLocation;

	@FindBy(how=How.XPATH,using ="//div[@class='from ng-binding']")
	WebElement label_From;

	@FindBy(how=How.XPATH,using ="//div[@class='to ng-binding']")
	WebElement label_To;

	@FindBy(how=How.XPATH,using ="//*[@id='dtFromDesk']//thead/tr[1]//th[@class='picker-switch C']")
	WebElement datePicker_From_MonthNameAndYear_Reservation;

	@FindBy(how=How.XPATH,using ="//*[@id='dtToDesk']//thead/tr[1]//th[@class='picker-switch C']")
	WebElement datePicker_To_MonthNameAndYear_Reservation;


	@FindBy(how=How.XPATH,using ="//*[@id='dtFromDesk']//thead/tr[1]//th[@class='picker-switch C']")
	WebElement datePicker_From_MonthNameAndYearForSubscription;

	@FindBy(how=How.XPATH,using ="//div[@id='dtFromDesk']//th[@class='picker-switch N']")
	WebElement datePicker_To_MonthNameAndYearForSubscription;


	@FindBy(how=How.ID,using ="searchProducts")
	WebElement button_SearchYourParking;

	@FindBy(how=How.XPATH,using ="//button[text()='GOT IT!']")
	WebElement button_GotIt;


	@FindBy(how=How.XPATH,using ="//div[@id='dtFromDesk']//span[@class='ssp-icon_arrow_left']")
	WebElement chevronPrevious_FromMonthCalendar_Reservation;

	@FindBy(how=How.XPATH,using ="//div[@id='dtFromDesk']//span[@class='ssp-icon_arrow_right']")
	WebElement chevronNext_FromMonthCalendar_Reservation;

	@FindBy(how=How.XPATH,using ="//div[@id='dtToDesk']//span[@class='ssp-icon_arrow_left']")
	WebElement chevronPrevious_ToMonthCalendar_Reservation;

	@FindBy(how=How.XPATH,using ="//div[@id='dtToDesk']//span[@class='ssp-icon_arrow_right']")
	WebElement chevronNext_ToMonthCalendar_Reservation;

	@FindBy(how=How.XPATH,using ="//a[@translate='_Faq_']")
	WebElement link_FAQ;

	@FindBy(how=How.XPATH,using ="//a[@translate='_TermsOfUse_']")
	WebElement link_TermsOfUse;

	@FindBy(how=How.XPATH,using ="//a[@translate='_OnlineParkingTC_']")
	WebElement link_OnlineParkingTC;

	@FindBy(how=How.XPATH,using ="//a[@translate='_PrivacyPolicy_']")
	WebElement link_PrivacyPolicy;

	@FindBy(how=How.XPATH,using ="//div[@class='text ng-binding']")
	WebElement label_NeedHelp;

	@FindBy(how=How.XPATH,using ="//div[@class='phone-number']")
	WebElement label_PhoneNumber;

	@FindBy(how=How.CLASS_NAME,using ="ssl-secured")
	WebElement image_SSLSecured;

	@FindBy(how=How.CLASS_NAME,using ="master-card")
	WebElement image_MasterCard;

	@FindBy(how=How.CLASS_NAME,using ="visa")
	WebElement image_Visa;

	@FindBy(how=How.CLASS_NAME,using ="paypal")
	WebElement image_Paypal;

	@FindBy(how=How.CLASS_NAME,using ="western-union")
	WebElement image_WesternUnion;

	@FindBy(how=How.XPATH,using ="//a[@id='facebook']/span")
	WebElement image_Facebook;

	@FindBy(how=How.XPATH,using ="//a[@id='twitter']/span")
	WebElement image_Twitter;

	@FindBy(how=How.XPATH,using ="//a[@id='youtube']/span")
	WebElement image_Youtube;

	@FindBy(how=How.XPATH,using ="//div[@id='dtFromDesk']//div[contains(@class,'today')]")
	WebElement datePicker_CurrentDateInFromCalendar;
	

	@FindBy(how=How.XPATH,using ="//div[@class='to-block']//div[@class='date-time']//div[@class='date ng-binding']")/*This is the Element with date selected in the From Calendar example FROM : 06*/
	WebElement dateValue_InToCalendarFieldAfterSelection;

	@FindBy(how=How.XPATH,using ="//div[@class='to-block']//div[@class='month-year ng-binding ng-scope']")/*This is the Element with date selected in the From Calendar example FROM : March 2018*/
	WebElement monthYearValue_InToCalendarFieldAfterSelection;

	@FindBy(how=How.XPATH,using ="//div[@class='to-block']//div[@class='time ng-binding']")/*This is the Element with date selected in the From Calendar example FROM : March 2018*/
	WebElement timeAndPeriod_InToCalendarFieldAfterSelection;/*12:00 PM*/

	

	@FindBy(how=How.XPATH,using ="//div[@id='dtFromDesk' and @aria-invalid='true']")
	WebElement FromcalendarWarningIndication;

	@FindBy(how=How.XPATH,using ="//div[@id='dtToDesk' and @aria-invalid='true']")
	WebElement TocalendarWarningIndication;
	
	@FindBy(how=How.XPATH,using ="//a[@id='goToProfile1']")
	WebElement ProfileLink;
	
	@FindBy (how=How.XPATH,using="//div[@class='loader']")
	WebElement loader;
	
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
			log("Logo image is displayed in Home page");
			WebElement logo = driver.findElement(By.id("logo"));
			highlightWebElement(driver, logo);
			takeScreenShot();
			status="PASS";
		}
		return status;


	}

	/**
	 * Method to Click on the RESERVATION label
	 */
	
	
	public void clickOnReservation() {
		//clickOnCookiesGotItbutton();
		label_Reservation.click();
		log("clicked on the RESERVATION label");

	}



	/**
	 *****************************************************************************************************************
	 * Method to verify the Header icons of the Main page
	 * @param _HomeIconLabel
	 * @param _CartIconLabel
	 * @param _LoginIconLabel
	 * @return PASS or FAIL
	 * @throws InterruptedException 
	 *****************************************************************************************************************
	 */
	public String verifyHeaderIconsLabelsInHomePageForReservation(String _HomeIconLabel,String _CartIconLabel,String _LoginIconLabel) throws InterruptedException {
		status="FAIL";

		if(label_HomeIcon.getText().equals(_HomeIconLabel)) {
			log(label_HomeIcon.getText()+" is displayed in Home page");
			highlightWebElement(driver, label_HomeIcon);
			if(label_CartIcon.getText().equals(_CartIconLabel)) {
				log(label_CartIcon.getText()+" is displayed in Home page");
				highlightWebElement(driver, label_CartIcon);
				if(link_Login.getText().equals(_LoginIconLabel)) {
					log(link_Login.getText()+" is displayed in Home page");
					highlightWebElement(driver, link_Login);
					status="PASS";
					takeScreenShot();
				}
			}
		}
		return status;
	}


	/**
	 *****************************************************************************************************************
	 * Method to Click on the Subscription label
	 *****************************************************************************************************************
	 */
	public void clickOnSubscription() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(label_Subscription, driver, 30);
		//clickOnCookiesGotItbutton();
		label_Subscription.click();
		log("clicked on the SUBSCRIPTION label");

	}

	/**
	 *****************************************************************************************************************
	 * Method to verify the Header icons of the Main page for SUBSCRIPTION
	 * @param _HomeIconLabel
	 * @param _CartIconLabel
	 * @param _LoginIconLabel
	 * @return PASS or FAIL
	 * @throws InterruptedException 
	 *****************************************************************************************************************
	 */
	public String verifyHeaderIconsLabelsInHomePageForSubscription(String _HomeIconLabel,String _LoginIconLabel) throws InterruptedException {
		status="FAIL";

		if(label_HomeIcon.getText().equals(_HomeIconLabel)) {
			log(label_HomeIcon.getText()+" is displayed in Home page");
			highlightWebElement(driver, label_HomeIcon);
			if(link_Login.getText().equals(_LoginIconLabel)) {
				log(link_Login.getText()+" is displayed in Home page");
				highlightWebElement(driver, link_Login);
				List<WebElement> iconlist = driver.findElements(By.xpath("//a[@id='goToCart1']/div"));
				if(iconlist.size()==0) {
					status="PASS";
					takeScreenShot();
				}
			}
		}
		return status;
	}

	/**
	 *****************************************************************************************************************
	 * Method to verify the Header H1 of the Home page
	 * @param _HomePageHeader
	 * @return PASS or FAIL
	 * @throws InterruptedException 
	 *****************************************************************************************************************
	 */
	public String verifyHeader_PreBookYourParking(String _HomePageHeader) throws InterruptedException {
		status="FAIL";

		WaitHelper wh = new WaitHelper(driver , test);
		wh.waitForElementToBeClickable(header_PreBookYourParking, driver, 20);
		
		if(header_PreBookYourParking.getText().equals(_HomePageHeader)) {
			log(header_PreBookYourParking.getText()+" is displayed in Home page as Header ");
			highlightWebElement(driver, header_PreBookYourParking);
			takeScreenShot();
			status="PASS";
		}
		return status;
	}

	/**
	 *****************************************************************************************************************
	 * Method to Verify the Sub header content of the Home page
	 * @param string
	 * @return PASS or FAIL
	 * @throws InterruptedException 
	 *****************************************************************************************************************
	 */
	public String verifySubHeader_PreBookYourParking(String _HomePageSubHeaderContent) throws InterruptedException {
		status="FAIL";
		
		WaitHelper wh = new WaitHelper (driver, test);
		wh.waitForElementToBeClickable(subheaderText_PreBookYourParking, driver, 20);

		if(subheaderText_PreBookYourParking.getText().equals(_HomePageSubHeaderContent)) {
			log(subheaderText_PreBookYourParking.getText()+" is displayed in Home page as Header ");
			highlightWebElement(driver, subheaderText_PreBookYourParking);
			takeScreenShot();
			status="PASS";
		}
		return status;
	}

	/**
	 *****************************************************************************************************************
	 * Method to verify if the Banner is displayed in the UI
	 * @return PASS or FAIL
	 * @throws InterruptedException 
	 *****************************************************************************************************************
	 */
	public String verifyBannerIsDisplayed() throws InterruptedException {
		status="FAIL";
		if(image_Banner.isDisplayed()) {
			highlightWebElement(driver, image_Banner);
			status="PASS";
		}
		return status;
	}

	/**
	 *****************************************************************************************************************
	 * Method to verify the RESERVATION and Subscription labels are displayed in UI
	 * @param _ReservationLabel
	 * @param _SubscriptionLabel
	 * @return
	 *****************************************************************************************************************
	 */
	public String verifyReservationSubscriptionIconsLabels(String _ReservationLabel,String _SubscriptionLabel) {
		status="FAIL";
		List<WebElement> reservation = driver.findElements(By.xpath("//a[text()='"+_ReservationLabel+"']"));
		List<WebElement> subscription = driver.findElements(By.xpath("//a[text()='"+_SubscriptionLabel+"']"));

		if(reservation.size()==1) {
			if(subscription.size()==1) {
				log(driver.findElement(By.xpath("//a[text()='"+_ReservationLabel+"']")).getText()+" is displayed in HomePage");
				log(driver.findElement(By.xpath("//a[text()='"+_SubscriptionLabel+"']")).getText()+" is displayed in HomePage");
				takeScreenShot();
				status="PASS";
			}
		}

		return status;
	}

	/**
	 *****************************************************************************************************************
	 * Method to verify if the Search location Bar is displayed and the Placeholder Value inside it and the icon
	 * @param string
	 * @param string2
	 * @return PASS or FAIL
	 * @throws InterruptedException 
	 *****************************************************************************************************************
	 */
	public String verifySeachLocationBar_PlaceholderText_Icon(String _PlaceholderText_SearchLocationBar) throws InterruptedException {
		status="FAIL";
		
		WaitHelper wh = new WaitHelper(driver,test);
		wh.waitForElementToBeClickable(field_SearchLocationBar, driver, 10);
		
		if(field_SearchLocationBar.isDisplayed()) {
			highlightWebElement(driver, field_SearchLocationBar);
			if(placeholderText_SearchLocationBar.getAttribute("placeholder").equals(_PlaceholderText_SearchLocationBar)) {
				log(placeholderText_SearchLocationBar.getAttribute("placeholder")+" is displayed in Home page");
				highlightWebElement(driver, placeholderText_SearchLocationBar);
				if(imageMarkerMap_SearchLocationBar.isDisplayed()) {
					highlightWebElement(driver, imageMarkerMap_SearchLocationBar);
					log("Map Marker is displayed in the Search Bar");
					status="PASS";
					takeScreenShot();
				}
			}
		}
		return status;
	}


	/**
	 *****************************************************************************************************************
	 * Method to verify Error message when Invalid Address is entered
	 * @param string
	 * @param string2
	 * @return PASS or FAIL
	 * @throws InterruptedException 
	 *****************************************************************************************************************
	 */
	public String verifyErrorMessage_ForInvalidAddressEntered_InSearchLocationBar(String _Location,String _ErrorMessage_For_InvalidAddress) throws InterruptedException {
		status="FAIL";
		WaitHelper wh = new WaitHelper(driver, test);
		if(field_SearchLocationBar.isDisplayed()) {


			inputText_SearchLocationBar.sendKeys(_Location);
			log("Entered the text in the search as "+_Location);

			wh.waitForElementToBeVisible(label_SearchLocationBarErrorMessage_InvalidLocation, driver, 10);
			if(label_SearchLocationBarErrorMessage_InvalidLocation.getText().equals(_ErrorMessage_For_InvalidAddress)) {
				status="PASS";
				log(label_SearchLocationBarErrorMessage_InvalidLocation.getText()+" is displayed in Home page");
				takeScreenShot();
			}
		}

		return status;
	}




	public String searchParkingLocationsAndSelect(String _EnterLocationNameToSearch,String _SelectLocationAddress) throws InterruptedException {
		status="FAIL";
		WaitHelper wh = new WaitHelper(driver, test);
		if(field_SearchLocationBar.isDisplayed()) {
			inputText_SearchLocationBar.sendKeys(_EnterLocationNameToSearch.substring(0, 10));
			
			WebElement dropDownMenu_listOfAddress = driver.findElement(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']//a"));

			wh.waitForElementToBeVisible(dropDownMenu_listOfAddress, driver, 20);

			List<WebElement> searchResults = driver.findElements(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']//a"));//ul[contains(@id,'typeahead')]//li//div[@class='ng-binding']

			for(int i=0;i<searchResults.size();i++) {
				int j=i+1;

				WebElement addressToSelect = driver.findElement(By.xpath("//ul[contains(@id,'typeahead')]//li["+j+"]//div[@class='ng-binding']"));
				if(addressToSelect.getText().equals(_SelectLocationAddress)) {
					addressToSelect.click();takeScreenShot();
					log("Address is selected from Search Result");break;

				}

			}

		}
		return status;
	}
	
	public void searchParkingLocationsAndSelect2(String _EnterLocationNameToSearch,String _SelectLocationAddress) throws InterruptedException {
		status="FAIL";
		WaitHelper wh = new WaitHelper(driver, test);
		Thread.sleep(5000);
		JavaScriptHelper js = new JavaScriptHelper(driver, test);
		js.waitForJStoLoad();
		
		if(field_SearchLocationBar.isDisplayed()) {
			inputText_SearchLocationBar.sendKeys(_EnterLocationNameToSearch.substring(0, 10));
			
				WebElement addressToSelect = driver.findElement(By.xpath("//ul[contains(@id,'typeahead')]//li[1]//div[@class='ng-binding']"));
				WebDriverWait wait = new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[contains(@id,'typeahead')]//li[1]//div[@class='ng-binding']")));
				
				
				clickElementUsingJavaScript(addressToSelect);
				
					log("Address is selected from Search Result");

				

			
	}
	}

	/**
	 ***************************************************************************************************************** 
	 * Method to verify the Labels FROM: and TO: are displayed in UI
	 * @param _FromLabel
	 * @param _ToLabel
	 * @return PASS or FAIL
	 * @throws InterruptedException
	 *****************************************************************************************************************
	 */
	public String verifyFromToLabelsAreDisplayed(String _FromLabel, String _ToLabel) throws InterruptedException {
		status="FAIL";
		if(label_From.getText().equals(_FromLabel)) {
			log(label_From.getText()+" is displayed in Home page");
			highlightWebElement(driver, label_From);
			if(label_To.getText().equals(_ToLabel)) {
				log(label_To.getText()+" is displayed in Home page");
				highlightWebElement(driver, label_To);
				takeScreenShot();
				status="PASS";
			}
		}	
		return status;
	}

	/**
	 ***************************************************************************************************************** 
	 * Method to verify the To month and Year is displayed and the Days of week as SU,MO,TU,WE,TH,FR,SA
	 * @param _days
	 * @return PASS or FAIL
	 ***************************************************************************************************************** 
	 */
	public String verifyCalendar_From_Month_NameOfDaysInWeek(String _days) {
		status="FAIL";
		if(datePicker_From_MonthNameAndYear_Reservation.getText().length()>1) {
			log("From month is displayed as "+ datePicker_From_MonthNameAndYear_Reservation.getText());
			if(datePicker_To_MonthNameAndYear_Reservation.getText().length()>1) {
				log("To month is displayed as "+ datePicker_To_MonthNameAndYear_Reservation.getText());
				status="PASS";

				List<WebElement> daysName = driver.findElements(By.xpath("//div[@id='dtFromDesk']//table/thead/tr[2]/th"));
				String[] daysToCheck = _days.split(",");
				for(int i=0;i<daysName.size();i++) {

					if(daysName.get(i).getText().equals(daysToCheck[i])){
						log("The day displayed in FROM: calendar is "+daysName.get(i).getText());
						status="PASS";
						takeScreenShot();

					}
				}
			}

		}

		return status;
	}

	/**
	 ***************************************************************************************************************** 
	 * Method to verify To month and Year is displayed and the Days of week as SU,MO,TU,WE,TH,FR,SA
	 * @param _days
	 * @return PASS or FAIL
	 ***************************************************************************************************************** 
	 */
	public String verifyCalendar_To_Month_NameOfDaysInWeek(String _days) {
		status="FAIL";
		if(datePicker_From_MonthNameAndYear_Reservation.getText().length()>1) {
			log("From month is displayed as "+ datePicker_From_MonthNameAndYear_Reservation.getText());
			if(datePicker_To_MonthNameAndYear_Reservation.getText().length()>1) {
				log("To month is displayed as "+ datePicker_To_MonthNameAndYear_Reservation.getText());
				status="PASS";

				List<WebElement> daysName = driver.findElements(By.xpath("//div[@id='dtToDesk']//table/thead/tr[2]/th"));
				String[] daysToCheck = _days.split(",");
				for(int i=0;i<daysName.size();i++) {

					if(daysName.get(i).getText().equals(daysToCheck[i])){
						log("The day displayed in FROM: calendar is "+daysName.get(i).getText());
						status="PASS";
						takeScreenShot();

						
						
					}
				}
			}

		}

		return status;
	}

	/**
	 ***************************************************************************************************************** 
	 * Method to verify the FromTo month and Year is displayed and the Days of week as SU,MO,TU,WE,TH,FR,SA for SUBSCRIPTION
	 * @param _days
	 * @return PASS or FAIL
	 ***************************************************************************************************************** 
	 */
	public String verifyCalendar_FromAndTo_Month_NameOfDaysInWeek_Subscription(String _days) {
		status="FAIL";
		if(datePicker_From_MonthNameAndYear_Reservation.getText().length()>1) {
			log("From month is displayed as "+ datePicker_From_MonthNameAndYear_Reservation.getText());
			if(datePicker_To_MonthNameAndYearForSubscription.getText().length()>1) {
				log("To month is displayed as "+ datePicker_To_MonthNameAndYearForSubscription.getText());
				status="PASS";

				List<WebElement> daysName = driver.findElements(By.xpath("//div[@id='dtFromDesk']//table/thead/tr[2]/th"));
				String[] daysToCheck = _days.split(",");
				for(int i=0;i<daysName.size();i++) {

					if(daysName.get(i).getText().equals(daysToCheck[i])){
						log("The day displayed in FROM and To: calendar is "+daysName.get(i).getText());
						status="PASS";
						takeScreenShot();

					}
				}
			}

		}

		return status;
	}


	/**
	 ***************************************************************************************************************** 
	 * Method to verify that the default date From and To is blank when user opens the portal for Reservation
	 * @return PASS or FAIL
	 ***************************************************************************************************************** 
	 */
	public String verifyDefaultDateisBlankForReservation() {
		status="FAIL";
		String fromDate = driver.findElement(By.xpath("//div[@class='from-block']//div[@class='date-time']//div[@data-ng-bind='dtFrom.format(dayFormat)']")).getText();
		String toDate = driver.findElement(By.xpath("//div[@class='to-block']//div[@class='date-time']//div[@data-ng-bind='dtTo.format(dayFormat)']")).getText();
		if(fromDate.equals("")) {	
			if(toDate.equals("")) {
				log("The default From Date for Reservation is :"+fromDate);
				log("The default To Date for Reservation is :"+toDate);
				status="PASS";
				takeScreenShot();
			}
		}
		return status;
	}

	/**
	 ***************************************************************************************************************** 
	 * Method to verify that the default date From and To is blank when user opens the portal for SUBSCRIPTION
	 * @return PASS or FAIL
	 ***************************************************************************************************************** 
	 */
	public String verifyDefaultDateisBlankForSubscription() {
		status="FAIL";
		String fromDate = driver.findElement(By.xpath("//div[@class='from-block']//div[@class='date-time']//div[@data-ng-bind='dtFrom.format(dayFormat)']")).getText();
		if(fromDate.equals("")) {		
			log("The default From Date for SUBSCRIPTION is :"+fromDate);
			status="PASS";
			takeScreenShot();
		}
		return status;
	}

	/**
	 *****************************************************************************************************************
	 * @param _SearchYourParkingLabel
	 * @return PASS or FAIL
	 *****************************************************************************************************************
	 */
	public String verifySearchBookingButtonIsDisplayed(String _SearchYourParkingLabel) {
		status="FAIL";
		if(button_SearchYourParking.getText().equals(_SearchYourParkingLabel)) {
			status="PASS";
			log("Button text is displayed as "+button_SearchYourParking.getText());
			takeScreenShot();
			status="PASS";

		}

		return status;
	}

	/**
	 *****************************************************************************************************************
	 * Method to click on Search your parking.
	 *****************************************************************************************************************
	 */
	public void clickOnSearchYourParkingButton() {
		//clickOnCookiesGotItbutton();
		clickElementUsingJavaScript(button_SearchYourParking);
		log("clicked on the SEARCH YOUR PARKING button");
      	
		WebElement loader = driver.findElement(By.xpath("//div[@class='loader']"));
		
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeInvisible(loader, driver, 30);
		
		
		takeScreenShot();

	}
	
	public void clickOnSearchYourParkingButton_Homepage() {
		//clickOnCookiesGotItbutton();
		clickElementUsingJavaScript(button_SearchYourParking);
		log("clicked on the SEARCH YOUR PARKING button");
		
		takeScreenShot();

	}

	/**
	 *****************************************************************************************************************
	 * Method to click on the Got It button of Cookies pop-up
	 ******************************************************************************************************************
	 */
	public void clickOnCookiesGotItbutton(){
		if(button_GotIt.isDisplayed()){
			button_GotIt.click();
			log("clicked on the Cookies GotIt button");
		}
	}



	/**
	 *****************************************************************************************************************
	 * Method to verify the Month and year displayed in the FROM: calendar
	 * @param _CurrentMonthYear
	 * @return PASS or FAIL
	 *****************************************************************************************************************
	 */
	public String verify_MonthYear_ValueDisplayedIn_FromCalendar(String _CurrentMonthYear) {
		status="FAIL";
		if(datePicker_From_MonthNameAndYear_Reservation.getText().equals(_CurrentMonthYear)) {
			status="PASS";
			log("The month and year displayed in the FROM: calendar is -> "+datePicker_From_MonthNameAndYear_Reservation.getText());
			takeScreenShot();
		}


		return status;
	}

	/**
	 *****************************************************************************************************************
	 * Method to verify the Month and year displayed in the TO: calendar
	 * @param _CurrentMonthYear
	 * @return PASS or FAIL
	 *****************************************************************************************************************
	 */
	public String verify_MonthYear_ValueDisplayedIn_ToCalendar(String _CurrentMonthYear) {
		status="FAIL";
		if(datePicker_To_MonthNameAndYear_Reservation.getText().equals(_CurrentMonthYear)) {
			status="PASS";
			log("The month and year displayed in the To: calendar is -> "+datePicker_To_MonthNameAndYear_Reservation.getText());
			takeScreenShot();
		}


		return status;
	}

	/**
	 *****************************************************************************************************************
	 * Method to verify the Month and year displayed in the TO: calendar
	 * @param _CurrentMonthYear
	 * @return PASS or FAIL
	 *****************************************************************************************************************
	 */
	public String verify_MonthYear_ValueDisplayedIn_ToCalendar_Subscription(String _NextMonthYear) {
		status="FAIL";
		if(datePicker_To_MonthNameAndYearForSubscription.getText().equals(_NextMonthYear)) {
			status="PASS";
			log("The month and year displayed in the To: calendar is -> "+datePicker_To_MonthNameAndYearForSubscription.getText());
			takeScreenShot();
		}


		return status;
	}

	/**
	 *****************************************************************************************************************
	 * Method to click on < in the FROM: calendar for Reservation
	 *****************************************************************************************************************
	 */
	public void clickOnPreviousArrow_FromMonthCalendarForReservation() {
		chevronPrevious_FromMonthCalendar_Reservation.click();
		log("clicked on the Previous chevron < in the FROM: Calendar");
		takeScreenShot();

	}

	/**
	 *****************************************************************************************************************
	 * Method to click on < in the FROM: calendar for Reservation
	 *****************************************************************************************************************
	 */
	public void clickOnPreviousArrow_ToMonthCalendarForForReservation() {
		chevronPrevious_ToMonthCalendar_Reservation.click();
		log("clicked on the Previous chevron < in the To: Calendar");
		takeScreenShot();

	}

	/**
	 *****************************************************************************************************************
	 * Method to verify the links and the text of links in the Home page footer
	 * @param _FAQlabel
	 * @param _TermsOfUseLabel
	 * @param _OnlineParkingTClabel
	 * @param _PrivacyPolicy
	 * @param _NeedHelpLabel
	 * @param _PhoneNumberText
	 * @return PASS or FAIL
	 *****************************************************************************************************************
	 */
	public String verifyHomePageFooterUrls_AreDisplayed(String _FAQlabel, String _TermsOfUseLabel,String _OnlineParkingTClabel,String _PrivacyPolicy,
			String _NeedHelpLabel,String _PhoneNumberText) {

		JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver, test);
		status="FAIL";
		if(link_FAQ.getText().equals(_FAQlabel)) {
			log(link_FAQ.getText()+" is displayed in Footer");

			if(link_TermsOfUse.getText().equals(_TermsOfUseLabel+"")) {
				log(link_TermsOfUse.getText()+" is displayed in Footer");

				if(link_OnlineParkingTC.getText().equals(_OnlineParkingTClabel)) {
					log(link_OnlineParkingTC.getText()+" is displayed in Footer");

					if(link_PrivacyPolicy.getText().equals(_PrivacyPolicy)) {
						log(link_PrivacyPolicy.getText()+" is displayed in Footer");

						if(label_NeedHelp.getText().equals(_NeedHelpLabel)) {
							log(label_NeedHelp.getText()+" is displayed in Footer");

							if(label_PhoneNumber.getText().trim().equals(_PhoneNumberText.trim())) {
								log(label_PhoneNumber.getText()+" is displayed in Footer");

								status="PASS";
								javaScriptHelper.scrollDownVertically();
								takeScreenShot();
							}
						}
					}
				}

			}
		}

		return status;
	}
	/**
	 *****************************************************************************************************************
	 * Method to Check the Footer images like ssl,paypal,visa,etc
	 * @return PASS or FAIL
	 *****************************************************************************************************************
	 */
	public String verifyHomePageFooterImages_AreDisplayed() {

		status="FAIL";
	//	if(image_SSLSecured.isDisplayed()) {
			if(image_MasterCard.isDisplayed()) {
				if(image_Visa.isDisplayed()) {
					if(image_Paypal.isDisplayed()) {
						if(image_WesternUnion.isDisplayed()) {
							if(image_Facebook.isDisplayed()) {
								if(image_Twitter.isDisplayed()) {
									if(image_Youtube.isDisplayed()) {
										log("SSL,Mastercard,Visa,Paypal,WesternUnion,Facebook,Twitter,Youtube images are displayed");
										status="PASS";
									}
								}
							}
						}
					}
				}
			}
//		}

		return status;
	}

	/**
	 *****************************************************************************************************************
	 * Method to Select the Current date in the From Calendar for Reservation
	 *****************************************************************************************************************
	 */
	public void select_ProductSearchStartDate_InFromCalendar_Reservation() {
		log("Select the current date as Start Date in From Calendar");
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(datePicker_CurrentDateInFromCalendar, driver, 10);
		
	
	     clickElementUsingJavaScript(datePicker_CurrentDateInFromCalendar);
		
		takeScreenShot();

	}

	/**
	 *****************************************************************************************************************
	 * Method to Select the Disabled date in the From Calendar for Reservation
	 *****************************************************************************************************************
	 */
	public void select_ProductSearch_DisabledStartDate_InFromCalendar_Reservation() {
		log("Select the disabled date as Start Date in From Calender");
		List<WebElement> disabledDates = driver.findElements(By.xpath("//div[@id='dtFromDesk']//div[contains(@class,'disabled')]"));
		if(disabledDates.size()>1) {
			WebElement disabledDate = driver.findElement(By.xpath("//div[@id='dtFromDesk']//div[contains(@class,'disabled')]"));
			disabledDate.click();
			log("Clicked on Disabled Date in From Calendar"+ disabledDate.getText());
			takeScreenShot();
		}
		else {
			log("There are no Disabled Dates Displayed in From Calendar");
			takeScreenShot();

		}

	}


	/**
	 *****************************************************************************************************************
	 * Method to Select the Disabled date in the From Calendar for Reservation
	 *****************************************************************************************************************
	 */
	public void select_ProductSearch_DisabledEndDate_InToCalendar_Reservation() {
		log("Select the disabled date as Start Date in From Calendar");
		List<WebElement> disabledDates = driver.findElements(By.xpath("//div[@id='dtToDesk']//div[contains(@class,'disabled')]"));
		if(disabledDates.size()>1) {
			WebElement disabledDate = driver.findElement(By.xpath("//div[@id='dtToDesk']//div[contains(@class,'disabled')]"));
			disabledDate.click();
			log("Clicked on Disabled Date in To Calendar"+ disabledDate.getText());
			takeScreenShot();
		}
		else {
			log("There are no Disabled Dates Displayed in To Calendar");
			takeScreenShot();

		}

	}

	/**
	 *****************************************************************************************************************
	 * Method to Select the Current date in the From Calendar for SUBSCRIPTION
	 *****************************************************************************************************************
	 */
	public void select_ProductSearchStartDate_InFromCalendar_Subscription() {
		DateAndUniqueNoGenerateHelper dateAndUniqueNoGenHelper = new DateAndUniqueNoGenerateHelper();
		log("Select the current date as Start Date in From Calendar");
		@SuppressWarnings("unused")
		String currentHour = dateAndUniqueNoGenHelper.get_CurrentSystem_Day_Month_Year_Time_Minute_MilliSecond_AMPM("hour");
		@SuppressWarnings("unused")
		String currentAMPM = dateAndUniqueNoGenHelper.get_CurrentSystem_Day_Month_Year_Time_Minute_MilliSecond_AMPM("AMPM");
		@SuppressWarnings("unused")
		String currentMin = dateAndUniqueNoGenHelper.get_CurrentSystem_Day_Month_Year_Time_Minute_MilliSecond_AMPM("minute");
//		if(Integer.parseInt(currentHour)==11 && currentAMPM.equals("PM") && Integer.parseInt(currentMin)>0 && Integer.parseInt(currentMin)<59)
//		{
//			driver.findElement(By.xpath("//div[@id='dtFromDesk']//div[@data-day='"+_EndDate+"']")).click();
//		}
		datePicker_CurrentDateInFromCalendar.click();
		//takeScreenShot();

	}


	/**
	 *****************************************************************************************************************
	 * Method to Select the date in the To Calendar for Reservation
	 * @throws InterruptedException 
	 *****************************************************************************************************************
	 */
	public void select_ProductSearchEndDate_InToCalendar_Reservation(String _EndDate) throws InterruptedException {
		
		DateAndUniqueNoGenerateHelper dateAndUniqueNoGenHelper = new DateAndUniqueNoGenerateHelper();
		String currentHour = dateAndUniqueNoGenHelper.get_CurrentSystem_Day_Month_Year_Time_Minute_MilliSecond_AMPM("hour");
		String currentAMPM = dateAndUniqueNoGenHelper.get_CurrentSystem_Day_Month_Year_Time_Minute_MilliSecond_AMPM("AMPM");
		
		DateAndUniqueNoGenerateHelper dateAndUniqueNoGenerateHelper = new DateAndUniqueNoGenerateHelper();
		String endDate=dateAndUniqueNoGenerateHelper.get_PreviousDate_OrFutureDate("MM/dd/yyyy","1");

		Thread.sleep(3000);
		
		if(currentHour.equals("11")&&currentAMPM.equals("PM")) {
			//chevronNext_ToMonthCalendar_Reservation.click();
			driver.findElement(By.xpath("//div[@id='dtToDesk']//div[@data-day='"+endDate+"']")).click();
			System.out.println("stale check1");
		}
		else {
//			Dimension n = new Dimension(360,592);  
//			 driver.manage().window().setSize(n);
//			 driver.manage().window().maximize();
			WebElement toDate = driver.findElement(By.xpath("//div[@id='dtToDesk']//div[@data-day='"+_EndDate+"']"));
			WaitHelper wh = new WaitHelper(driver, test);
			wh.waitForElementToBeClickable(toDate, driver, 20);
			System.out.println("stale check2");
			clickElementUsingJavaScript(toDate);
		}
		takeScreenShot();

	}



	@FindBy(how=How.XPATH,using ="//div[@class='from-block']//div[@class='date-time']//div[@class='date ng-binding']")/*This is the Element with date selected in the From Calendar example FROM : 06*/
	WebElement dateValue_InFromCalendarFieldAfterSelection_Reservation;

	@FindBy(how=How.XPATH,using ="//div[@class='from-block']//div[@class='month-year ng-binding ng-scope']")/*This is the Element with date selected in the From Calendar example FROM : March 2018*/
	WebElement monthYearValue_InFromCalendarFieldAfterSelection_Reservation;

	@FindBy(how=How.XPATH,using ="//div[@class='from-block']//div[@class='time ng-binding ng-scope']")/*This is the Element with date selected in the From Calendar example FROM : March 2018*/
	WebElement timeAndPeriod_InFromCalendarFieldAfterSelection_Reservation;/*12:00 PM*/

	@FindBy(how=How.XPATH,using ="//div[@id='dtFromDesk']//select[@id='hours']//option[@selected]")
	WebElement datePicker_SelectedTime_Hour_FromCalendar_Reservation;

	@FindBy(how=How.XPATH,using ="//div[@id='dtFromDesk']//select[@id='minutes']//option[@selected]")
	WebElement datePicker_SelectedTime_Minutes_FromCalendar_Reservation;

	@FindBy(how=How.XPATH,using ="//div[@id='dtFromDesk']//select[@id='period']//option[@selected]")
	WebElement datePicker_SelectedTime_AMPM_FromCalendar_Reservation;
	/**
	 *****************************************************************************************************************
	 * Method will check the date Month Year Time AM PM is displayed in FROM : after user has selected the Date and time in From Calendar for Reservation
	 * @return PASS or FAIL
	 *****************************************************************************************************************
	 */
	public String verify_Selected_From_DateMonthYearWithTimePeriod_IsDisplayed_ForReservation() {
		status="FAIL";
		DateAndUniqueNoGenerateHelper dateAndUniqueNoGenHelper = new DateAndUniqueNoGenerateHelper();
		String currentDate = dateAndUniqueNoGenHelper.get_CurrentSystem_Day_Month_Year_Time_Minute_MilliSecond_AMPM("day", "dd/MMMMMMMMMMM/yy/HH/mm/ss/a");

		String selectedTime = datePicker_SelectedTime_Hour_FromCalendar_Reservation.getText()+":"+datePicker_SelectedTime_Minutes_FromCalendar_Reservation.getText()+" "+datePicker_SelectedTime_AMPM_FromCalendar_Reservation.getText();

		if(dateValue_InFromCalendarFieldAfterSelection_Reservation.getText().equals(currentDate)) {
			if(monthYearValue_InFromCalendarFieldAfterSelection_Reservation.getText().equals(datePicker_From_MonthNameAndYear_Reservation.getText())) {
				if(timeAndPeriod_InFromCalendarFieldAfterSelection_Reservation.getText().equals(selectedTime)) {
					log("FROM: " +dateValue_InFromCalendarFieldAfterSelection_Reservation.getText()
					+" "+monthYearValue_InFromCalendarFieldAfterSelection_Reservation.getText()+" "+timeAndPeriod_InFromCalendarFieldAfterSelection_Reservation.getText()+" is displayed ");
					takeScreenShot();
					status="PASS";
				}	
			}

		}
		return status;

	}





	@FindBy(how=How.XPATH,using ="//div[@class='to-block']//div[@class='date-time']//div[@class='date ng-binding']")/*This is the Element with date selected in the From Calendar example FROM : 06*/
	WebElement dateValue_InToCalendarFieldAfterSelection_Reservation;

	@FindBy(how=How.XPATH,using ="//div[@class='to-block']//div[@class='month-year ng-binding']")/*This is the Element with date selected in the From Calendar example FROM : March 2018*/
	WebElement monthYearValue_InToCalendarFieldAfterSelection_Reservation;

	@FindBy(how=How.XPATH,using ="//div[@class='to-block']//div[@class='time ng-binding']")/*This is the Element with date selected in the From Calendar example FROM : March 2018*/
	WebElement timeAndPeriod_InToCalendarFieldAfterSelection_Reservation;/*12:00 PM*/

	@FindBy(how=How.XPATH,using ="//div[@id='dtToDesk']//select[@id='hours']//option[@selected]")
	WebElement datePicker_SelectedTime_Hour_ToCalendar_Reservation;

	@FindBy(how=How.XPATH,using ="//div[@id='dtToDesk']//select[@id='minutes']//option[@selected]")
	WebElement datePicker_SelectedTime_Minutes_ToCalendar_Reservation;

	@FindBy(how=How.XPATH,using ="//div[@id='dtToDesk']//select[@id='period']//option[@selected]")
	WebElement datePicker_SelectedTime_AMPM_ToCalendar_Reservation;
	/**
	 *****************************************************************************************************************
	 * Method will check the date Month Year Time AM PM is displayed in TO : after user has selected the Date and time in From Calendar for Reservation
	 * @return PASS or FAIL
	 *****************************************************************************************************************
	 */
	public String verify_Selected_To_DateMonthYearWithTimePeriod_IsDisplayed_ForReservation(String _endDate) {
		status="FAIL";
		String selectedTime = datePicker_SelectedTime_Hour_ToCalendar_Reservation.getText()+":"+datePicker_SelectedTime_Minutes_ToCalendar_Reservation.getText()+" "+datePicker_SelectedTime_AMPM_ToCalendar_Reservation.getText();

		if(dateValue_InToCalendarFieldAfterSelection_Reservation.getText().equals(_endDate)) {
			if(monthYearValue_InToCalendarFieldAfterSelection_Reservation.getText().equals(datePicker_To_MonthNameAndYear_Reservation.getText())) {
				if(timeAndPeriod_InToCalendarFieldAfterSelection.getText().equals(selectedTime)) {
					log("TO: " +dateValue_InToCalendarFieldAfterSelection_Reservation.getText()
					+" "+monthYearValue_InToCalendarFieldAfterSelection_Reservation.getText()+" "+timeAndPeriod_InToCalendarFieldAfterSelection.getText()+" is displayed ");
					takeScreenShot();
					status="PASS";
				}	
			}

		}
		return status;

	}




	@FindBy(how=How.XPATH,using ="//div[@class='from-block']//div[@class='date-time']//div[@class='date ng-binding']")/*This is the Element with date selected in the From Calendar example FROM : 06*/
	WebElement dateValue_InFromCalendarFieldAfterSelection_Subscription;

	@FindBy(how=How.XPATH,using ="//div[@class='from-block']//div[@class='month-year ng-binding ng-scope'][1]")/*This is the Element with date selected in the From Calendar example FROM : March 2018*/
	WebElement monthValue_InFromCalendarFieldAfterSelection_Subscription;

	@FindBy(how=How.XPATH,using ="//div[@class='from-block']//div[@class='month-year ng-binding ng-scope'][2]")/*This is the Element with date selected in the From Calendar example FROM : March 2018*/
	WebElement year_InFromCalendarFieldAfterSelection_Subscription;/*12:00 PM*/
	/**
	 *****************************************************************************************************************
	 * Method will check the date Month Year Time AM PM is displayed in FROM : after user has selected the Date and time in From Calendar for SUBSCRIPTION
	 * @return PASS or FAIL
	 *****************************************************************************************************************
	 */
	public String verify_Selected_From_DateMonthYearWithTimePeriod_IsDisplayed_ForSubscription() {
		status="FAIL";
		DateAndUniqueNoGenerateHelper dateAndUniqueNoGenHelper = new DateAndUniqueNoGenerateHelper();
		String currentDate = dateAndUniqueNoGenHelper.get_CurrentSystem_Day_Month_Year_Time_Minute_MilliSecond_AMPM("day", "dd/MMMMMMMMMMM/yy/HH/mm/ss/a");

		String monthYear = monthValue_InFromCalendarFieldAfterSelection_Subscription.getText()+" "+year_InFromCalendarFieldAfterSelection_Subscription.getText();

		if(dateValue_InFromCalendarFieldAfterSelection_Subscription.getText().equals(currentDate)) {
			if(monthYear.equals(datePicker_From_MonthNameAndYearForSubscription.getText())) {

				log("FROM: " +dateValue_InFromCalendarFieldAfterSelection_Subscription.getText()+" "+monthValue_InFromCalendarFieldAfterSelection_Subscription.getText()+" "
						+year_InFromCalendarFieldAfterSelection_Subscription.getText()+"is displayed in UI");
				takeScreenShot();
				status="PASS";	
			}

		}
		return status;

	}


	/**
	 *****************************************************************************************************************
	 * Method Will Fetch the Date,Month,year,TimeAMPM from the Home page for the Value FROM: for Reservation
	 * @return selectedDateTimeFromCalendarReservation
	 *****************************************************************************************************************
	 */
	public String getSelected_Date_Month_Year_Time_FromCalendar_Reservation_InHomePage() {

		String selectedDateTimeFromCalendarReservation= dateValue_InFromCalendarFieldAfterSelection_Reservation.getText()+
				monthYearValue_InFromCalendarFieldAfterSelection_Reservation.getText()+timeAndPeriod_InFromCalendarFieldAfterSelection_Reservation.getText();
		return selectedDateTimeFromCalendarReservation;

	}


	/**
	 *****************************************************************************************************************
	 * Method Will Fetch the Date,Month,year,TimeAMPM from the Home page for the Value TO: for Reservation
	 * @return selectedDateTimeFromCalendarReservation
	 *****************************************************************************************************************
	 */
	public String getSelected_Date_Month_Year_Time_ToCalendar_Reservation_InHomePage() {

		String selectedDateTimeFromCalendarReservation= dateValue_InToCalendarFieldAfterSelection_Reservation.getText()+
				monthYearValue_InToCalendarFieldAfterSelection_Reservation.getText()+timeAndPeriod_InToCalendarFieldAfterSelection_Reservation.getText();
		return selectedDateTimeFromCalendarReservation;

	}

	/**
	 *****************************************************************************************************************
	 * Method Will Fetch the Date,Month,year,TimeAMPM from the Home page for the Value FROM :for Subscription 
	 * @return selectedDateTimeFromCalendarSubscription
	 *****************************************************************************************************************
	 */
	public String getSelected_Date_Month_Year_Time_FromCalendar_Subscription_InHomePage() {

		String selectedDateTimeFromCalendarSubscription= dateValue_InFromCalendarFieldAfterSelection_Subscription.getText()+
				monthValue_InFromCalendarFieldAfterSelection_Subscription.getText()+year_InFromCalendarFieldAfterSelection_Subscription.getText();
		return selectedDateTimeFromCalendarSubscription;

	}

	/**
	 * Method to click on Log in 
	 * @throws InterruptedException 
	 */
	public void clickonLogin() throws InterruptedException {
	
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(link_Login, driver, 10);
		
		clickElementUsingJavaScript(link_Login);

		log("Clicked on the Login");
		takeScreenShot();

	}


	@FindBy(how=How.XPATH,using ="//a[@id='goToProfile1']/div")
	WebElement link_Profile;
	public String verifyProfileLinkDisplayed(String _Profile) {
		status="FAIL";
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(link_Profile, driver, 20);
		if(link_Profile.getText().equals(_Profile)) {
			log(link_Profile.getText()+" is displayed");
			status="PASS";
			takeScreenShot();
		}
		return status;

	}

	public void clickOnProfileLink() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(link_Profile, driver, 20);
		link_Profile.click();
		log(link_Profile.getText()+" is clicked");
		takeScreenShot();

	}

	/**
	 *****************************************************************************************************************
	 * Method to verify the Warning message appears for FROM and TO date if user selects SEARCH YOUR PARKING button without selecting FROM and TO dates
	 * @param _CurrentMonthYear
	 * @return PASS or FAIL
	 * @throws InterruptedException 
	 *****************************************************************************************************************
	 */
	public String VerifyWarningMessageToSelectFromAndTodatesOrLocation(String _WarningMessageLableForFromandTodate) throws InterruptedException {
		status="FAIL";
		Thread.sleep(4000);
		String s1;
		String s3="";
		 String s2="";
		List<WebElement> erroMessageContent = driver.findElements(By.xpath("//div[@class='unselected-datetimepicker-error-msg']//div"
				+ ""));
		
		for(int i=0;i<erroMessageContent.size();i++) {
			 s1= erroMessageContent.get(i).getText();
			 s2 = s2.concat(s1+" ");
			 s3 = s2.trim();
			 s3=s3.replace(" ,", ",");
		}
		
		log(s3);
		log(_WarningMessageLableForFromandTodate);
		if(s3.equals(_WarningMessageLableForFromandTodate)) {
			status="PASS";
			log("Warning message displyed if user clicks SEARCH YOUR PARKING without selecting FROM and TO dates-> "+s2.trim());
			takeScreenShot();
		}
		return status;
	}

//	/**
//	 *****************************************************************************************************************
//	 * Method to verify the Warning boarder appears on  FROM and TO date if user selects SEARCH YOUR PARKING button without selecting FROM and TO dates
//	 * @param _CurrentMonthYear
//	 * @return PASS or FAIL
//	 *****************************************************************************************************************
//	 */
//	public String VerifyWarningBorderOnFromAndTodates(String _Fromdate,String _Todates) {
//		status="FAIL";
//		
//		if(FromcalendarWarningIndication.getAttribute("aria-invalid").equals(_Fromdate)) {
//			log("Warning label displyed on From Calendar boarder if user selects Search button without selecting FROM -> "+FromcalendarWarningIndication.getAttribute("aria-invalid"));
//			if(TocalendarWarningIndication.getAttribute("aria-invalid").equals(_Todates)){
//				log("Warning label displyed on To Calendar boarder if user selects Search button without selecting To -> "+TocalendarWarningIndication.getAttribute("aria-invalid"));	
//				status="PASS";
//				takeScreenShot();
//			}
//		}
//		return status;
//	}
//
//	/**
//	 *****************************************************************************************************************
//	 * Method to verify the Warning boarder appears on  FROM calendar if user selects SEARCH YOUR PARKING button without selecting FROM  dates
//	 * @param _CurrentMonthYear
//	 * @return PASS or FAIL
//	 *****************************************************************************************************************
//	 */
//	public String VerifyWarningBorderOnFromCalendar(String _Fromdate) {
//		status="FAIL";
//		System.out.println(FromcalendarWarningIndication.getAttribute("aria-invalid"));
//		if(FromcalendarWarningIndication.getAttribute("aria-invalid").equals(_Fromdate)) {
//			log("Warning label displyed on From Calendar boarder if user selects Search button without selecting FROM -> "+FromcalendarWarningIndication.getAttribute("aria-invalid"));
//			status="PASS";
//			takeScreenShot();
//		}
//		return status;
//	}

	/* Clicked on Profile Link */
	
	public void clickOnProfile() {
		ProfileLink.click();
		log("clicked on Profile");

	}
	
	
	/*select locale*/
	
	public void SelectLocale() throws InterruptedException {
		
		WaitHelper wh = new WaitHelper (driver , test);
		wh.waitForElementToBeClickable(Locale_Dropdown, driver, 20);		
		
		Locale_Dropdown.click();
		log("clicked on locale drop down");
		wh.waitForElementToBeClickable(Deutsch_Value, driver, 20);
		Deutsch_Value.click();
		log("Deutsch Selected From The Locale Dropdown");

	}
	
	
	@FindBy(how=How.XPATH,using ="//div[@class='btn-group ng-scope']")
	WebElement Locale_Dropdown;
	
	@FindBy(how=How.XPATH,using ="//a[contains(text(),'Deutsch (Österreich)')]")
	WebElement Deutsch_Value;
	
	@FindBy(how=How.XPATH,using ="//a[contains(text(),'English (United States)')]")
	WebElement English_Value;
	
	
	public void addLocale(String _Locale) throws InterruptedException{
		status="FAIL";
		Thread.sleep(2000);
		
		Locale_Dropdown.click();
		
		Thread.sleep(2000);
        List<WebElement> Locale = driver.findElements(By.xpath("//a[@class='ng-binding' and contains(text(),'')]"));
		
		for(int i =0;i<Locale.size();i++) {
			if((Locale.get(i).getText()).equals(_Locale)){
				clickElementUsingJavaScript(Locale.get(i));
				Thread.sleep(5000);
				break;
	    }
	  }
		status="PASS";
	}
		
	
	public void clickOnGotIt() throws InterruptedException {
		
		
		List<WebElement> gotIt = driver.findElements(By.xpath("//button[@ng-click='onCookieGotIt()']"));
		
		if(gotIt.size()>0) {
			WebElement gotItbutton = driver.findElement(By.xpath("//button[@ng-click='onCookieGotIt()']"));
			clickElementUsingJavaScript(gotItbutton);
			log("clicked on Got it button");
			
		}
	}

}











