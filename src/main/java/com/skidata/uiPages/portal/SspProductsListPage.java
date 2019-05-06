/**
 *
 */
package com.skidata.uiPages.portal;

import java.text.ParseException;
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
import com.skidata.helperclasses.JavaScriptHelper;
import com.skidata.helperclasses.MouseKeyboardHelper;
import com.skidata.helperclasses.WaitHelper;
import com.skidata.testBase.TestBase;

/**
 * @author shmo
 * 
 */
public class SspProductsListPage extends TestBase {

	
	
	String status=null;


	public static final Logger log = Logger.getLogger(SspProductsListPage.class.getName());



	//Class constructor
	public SspProductsListPage(WebDriver driver,ExtentTest test) {
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

	@FindBy(how=How.XPATH,using =".//*[@id='goToCart1']/div[1]")
	WebElement label_CartIcon;

	@FindBy(how=How.XPATH,using ="//a[@id='goToLogin']/div")
	WebElement label_LoginIcon;

	@FindBy(how=How.ID,using ="locationSearch")
	WebElement field_SearchLocationBar;

	@FindBy(how=How.XPATH,using ="//input[@placeholder='Where do you want to park?']")
	WebElement inputText_SearchLocationBar;

	@FindBy(how=How.XPATH,using ="//input[@placeholder='Where do you want to park?']")
	WebElement placeholderText_SearchLocationBar;

	@FindBy(how=How.XPATH,using ="//span[@class='ssp-icon_pin_location']")
	WebElement imageMarkerMap_SearchLocationBar;

	@FindBy(how=How.ID,using ="faq")
	WebElement link_FAQ;

	@FindBy(how=How.ID,using ="termsOfUse")
	WebElement link_TermsOfUse;

	@FindBy(how=How.ID,using ="onlineParkingConditions")
	WebElement link_OnlineParkingTC;

	@FindBy(how=How.ID,using ="privacy")
	WebElement link_PrivacyPolicy;

	@FindBy(how=How.XPATH,using ="//div[@class='need-help']/div")
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

	@FindBy(how=How.XPATH,using ="//span[@class='ssp-icon_grid']")
	WebElement icon_GridView;

	@FindBy(how=How.XPATH,using ="//span[@class='ssp-icon_list onclick-color']")
	WebElement icon_ListView;

	@FindBy(how=How.XPATH,using ="//a[@class='map-view ng-scope' and @id='mapView']")
	WebElement icon_MapView;

	@FindBy(how=How.ID,using ="sort-by")
	WebElement dropDown_SortBy;

	@FindBy(how=How.XPATH,using ="//div[@class='sort-by']//button[@class='selected-item button-label dropdown-toggle']")
	WebElement dropDown_SortByDefaultValueDisplayed;

	@FindBy(how=How.XPATH,using ="//a[@id='goToCart1']//div[@data-ng-bind='cartTotalCount']")
	WebElement tooltip_CountOfItemsInCartIcon;

	//@FindBy(how=How.XPATH,using ="//button[@translate='_SeeCart_']")
	@FindBy(how=How.XPATH,using ="//span[contains(text(),'See Cart')]")
	WebElement button_SeeCart_InCartPopUp;

	@FindBy(how=How.XPATH,using ="//span[@translate='_Checkout_']")
	WebElement button_CHECKOUT_InCartPopUp;
	
	@FindBy(how=How.XPATH,using ="//h3[contains(text(),'A product with same time frame exists in your cart')]")
	WebElement Duplicate_Cart_Error_PopUp_Message;
	
	@FindBy(how=How.XPATH,using ="//div[@class='modal-footer']//button[@data-dismiss='modal']")
	WebElement Duplicate_Cart_Error_PopUp_Ok_Button;
	
	@FindBy(how=How.XPATH,using ="//button[@type='button']//i[@class='ssp-icon_close']")
	WebElement Duplicate_Cart_Error_PopUp_X_Button;
	
	



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

		Thread.sleep(5000);
		if(allElementsInList_LogoImage.size()==1) {
			log("Logo image is displayed in Product List page");
			WebElement logo = driver.findElement(By.id("logo"));
			highlightWebElement(driver, logo);
			takeScreenShot();
			status="PASS";
		}
		return status;


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
			log(label_HomeIcon.getText()+" is displayed in Products Page");
			highlightWebElement(driver, label_HomeIcon);
			if(label_CartIcon.getText().equals(_CartIconLabel)) {
				log(label_CartIcon.getText()+" is displayed in Products Page");
				highlightWebElement(driver, label_CartIcon);
				if(label_LoginIcon.getText().equals(_LoginIconLabel)) {
					log(label_LoginIcon.getText()+" is displayed in Products Page");
					highlightWebElement(driver, label_LoginIcon);
					status="PASS";
					takeScreenShot();
				}
			}
		}
		return status;
	}

	/**
	 *****************************************************************************************************************
	 * Method to verify the Header icons of the Main page for Subscription
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
			log(label_HomeIcon.getText()+" is displayed in Products page");
			highlightWebElement(driver, label_HomeIcon);
			if(label_LoginIcon.getText().equals(_LoginIconLabel)) {
				log(label_LoginIcon.getText()+" is displayed in Products page");
				highlightWebElement(driver, label_LoginIcon);
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
	 * Method to verify the Reservation and Subscription labels are displayed in UI
	 * @param _ReservationLabel
	 * @param _SubscriptionLabel
	 * @return
	 *****************************************************************************************************************
	 */
	public String verifyReservationSubscriptionIconsLabels(String _ReservationLabel,String _SubscriptionLabel) {
		status="FAIL";
		List<WebElement> reservation = driver.findElements(By.xpath("//a[text()='"+_ReservationLabel+"']"));
		List<WebElement> subscription = driver.findElements(By.xpath("//a[text()='"+_ReservationLabel+"']"));

		if(reservation.size()==1) {
			if(subscription.size()==1) {
				log(driver.findElement(By.xpath("//a[text()='"+_ReservationLabel+"']")).getText()+" is displayed in Products list page");
				log(driver.findElement(By.xpath("//a[text()='"+_SubscriptionLabel+"']")).getText()+" is displayed in Products list page");
				takeScreenShot();status="PASS";
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
 			inputText_SearchLocationBar.clear();

			if(placeholderText_SearchLocationBar.getAttribute("placeholder").equals(_PlaceholderText_SearchLocationBar)) {
				log(placeholderText_SearchLocationBar.getAttribute("placeholder")+" is displayed in Products page");
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
	 * Method to retrieve the From Date time in products list page 
	 * @return displayedFromDateTimeReservationProductsPage
	 *****************************************************************************************************************
	 */
	public String getSelected_Date_Month_Year_Time_FromCalendar_Reservation_InProductsPage() {

		WebElement fromDate = driver.findElement(By.xpath("//div[@id='dtFrom']//div[@class='date ng-binding']"));
		WebElement fromMonthYear = driver.findElement(By.xpath("//div[@id='dtFrom']//div[@class='month-year ng-binding ng-scope']"));
		WebElement fromTimeAMPM = driver.findElement(By.xpath("//div[@id='dtFrom']//div[@class='time ng-binding ng-scope']"));

		String displayedFromDateTimeReservationProductsPage = fromDate.getText()+fromMonthYear.getText()+fromTimeAMPM.getText();
		return displayedFromDateTimeReservationProductsPage;
	}


	/**
	 *****************************************************************************************************************
	 * Method to retrieve the From Date time in products list page 
	 * @return displayedFromDateTimeReservationProductsPage
	 *****************************************************************************************************************
	 */
	public String getSelected_FROM_DateTime_InProductsPage_ForCheckoutAndConfirmation() {

		WebElement fromDate = driver.findElement(By.xpath("//div[@id='dtFrom']//div[@class='date ng-binding']"));
		WebElement fromMonthYear = driver.findElement(By.xpath("//div[@id='dtFrom']//div[@class='month-year ng-binding ng-scope']"));
		WebElement fromTimeAMPM = driver.findElement(By.xpath("//div[@id='dtFrom']//div[@class='time ng-binding ng-scope']"));

		String displayedFromDateTimeReservationProductsPage = fromDate.getText()+" "+fromMonthYear.getText()+" "+"-"+" "+fromTimeAMPM.getText();
		return displayedFromDateTimeReservationProductsPage;
	}

	/**
	 *****************************************************************************************************************
	 * Method to retrieve the To Date time in products list page 
	 * @return
	 *****************************************************************************************************************
	 */
	public String getSelected_TO_DateTime_InProductsPage_ForCheckoutAndConfirmation() {

		WebElement toDate = driver.findElement(By.xpath("//div[@id='dtTo']//div[@class='date ng-binding']"));
		WebElement toMonthYear = driver.findElement(By.xpath("//div[@id='dtTo']//div[@class='month-year ng-binding']"));
		WebElement toTimeAMPM = driver.findElement(By.xpath("//div[@id='dtTo']//div[@class='time ng-binding']"));

		String displayedToDateTimeReservationProductsPage = toDate.getText()+" "+toMonthYear.getText()+" "+"-"+" "+toTimeAMPM.getText();
		return displayedToDateTimeReservationProductsPage;
	}



	public String getSelected_Date_Month_Year_Time_ToCalendar_Reservation_InProductsPage() {

		WebElement toDate = driver.findElement(By.xpath("//div[@id='dtTo']//div[@class='date ng-binding']"));
		WebElement toMonthYear = driver.findElement(By.xpath("//div[@id='dtTo']//div[@class='month-year ng-binding']"));
		WebElement toTimeAMPM = driver.findElement(By.xpath("//div[@id='dtTo']//div[@class='time ng-binding']"));

		String displayedToDateTimeReservationProductsPage = toDate.getText()+toMonthYear.getText()+toTimeAMPM.getText();
		return displayedToDateTimeReservationProductsPage;
	}



	/**
	 *****************************************************************************************************************
	 * Method to retrieve the From Date time in products list page 
	 * @return
	 *****************************************************************************************************************
	 */
	public String getSelected_Date_Month_Year_Time_ToCalendar_Subscription_InProductsPage() {

		WebElement fromDate = driver.findElement(By.xpath("//div[@id='dtFrom']//div[@class='date ng-binding']"));
		WebElement fromMonth = driver.findElement(By.xpath("//div[@id='dtFrom']//div[1][@class='month-year ng-binding ng-scope']"));
		WebElement fromYear = driver.findElement(By.xpath("//div[@id='dtFrom']//div[2][@class='month-year ng-binding ng-scope']"));

		String displayedFromDateTimeSubscriptionProductsPage = fromDate.getText()+fromMonth.getText()+fromYear.getText();
		return displayedFromDateTimeSubscriptionProductsPage;
	}

	/**
	 *****************************************************************************************************************
	 * Method will verify the Dates displayed are correct in the Product list page
	 * @param _FromDateTimeExpected
	 * @param _ToDateTimeExpected
	 *****************************************************************************************************************
	 */
	public String verifyDisplayedDateTime_FromAndTo_ForReservation_IsCorrect(String _FromDateTimeExpected,String _ToDateTimeExpected) {
		String fromDateTimeProductsListPage = getSelected_Date_Month_Year_Time_FromCalendar_Reservation_InProductsPage();
		String toDateTimeProductsListPage = getSelected_Date_Month_Year_Time_ToCalendar_Reservation_InProductsPage();

		status="FAIL";
		if(fromDateTimeProductsListPage.equals(_FromDateTimeExpected)) {
			if(toDateTimeProductsListPage.equals(_ToDateTimeExpected)) {
				status="PASS";
				takeScreenShot();
				log("Selected time in Home Page From calendar is "+fromDateTimeProductsListPage);
				log("Selected time in Home Page To calendar is "+toDateTimeProductsListPage);
				log("Displayed time in Products Page From calendar is "+_FromDateTimeExpected);
				log("Displayed time in Products Page To calendar is "+_ToDateTimeExpected);

			}
		}
		return status;


	}

	/**
	 *****************************************************************************************************************
	 * Method will verify the Dates displayed are correct in the Product list page for Subscription
	 * @param _FromDateTimeExpected
	 * @param _ToDateTimeExpected
	 *****************************************************************************************************************
	 */
	public String verifyDisplayedDateTime_FromAndTo_ForSubscription_IsCorrect(String _FromDateTimeExpected) {
		String fromDateTimeProductsListPage = getSelected_Date_Month_Year_Time_ToCalendar_Subscription_InProductsPage();


		status="FAIL";
		if(fromDateTimeProductsListPage.equals(_FromDateTimeExpected)) {

			status="PASS";
			takeScreenShot();
			log("Selected time in Home Page From calendar is "+fromDateTimeProductsListPage);
			log("Displayed time in Products Page From calendar is "+_FromDateTimeExpected);


		}
		return status;


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
//		if(image_SSLSecured.isDisplayed()) {
			if(image_MasterCard.isDisplayed()) {
				if(image_Visa.isDisplayed()) {
					if(image_Paypal.isDisplayed()) {
						if(image_WesternUnion.isDisplayed()) {
							if(image_Facebook.isDisplayed()) {
								if(image_Twitter.isDisplayed()) {
									if(image_Youtube.isDisplayed()) {
										log("Mastercard,Visa,Paypal,WesternUnion,Facebook,Twitter,Youtube images are displayed");
										status="PASS";
									}
								}
							}
						}
					}
				}
			}
	//	}

		return status;
	}

	/**
	 *****************************************************************************************************************
	 * Method to verify the products are displayed in the List view
	 * </br> it is assumed that the products are configured in CH back office and they are reflected in UI
	 * @return PASS or FAIL
	 * @throws InterruptedException 
	 *****************************************************************************************************************
	 */
	public String verifyProductListDisplayedForDefaultLocation_InListView() throws InterruptedException {
		status="FAIL";
		Thread.sleep(3000);
		List<WebElement> listOfProducts_ListView = driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-12 col-md-12 col-lg-12 px-0 ng-isolate-scope']"));

		if(listOfProducts_ListView.size()>=1) {
			log("No of Products displayed in List view are "+listOfProducts_ListView.size());
			status="PASS";
			//takeScreenShot();
		}
		return status;



	}



	/**
	 *****************************************************************************************************************
	 * Method to verify the products are displayed in the Grid View
	 * @return PASS or FAIL
	 *****************************************************************************************************************
	 */
	public String verifyProductListDisplayedForDefaultLocation_InGridView() {
		status ="FAIL";
		icon_GridView.click();
		log("Clicked on the Grid View Icon");
		List<WebElement> listOfProducts_GridView = driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-6 col-md-4 col-lg-4 pl-0 ng-isolate-scope']"));

		if(listOfProducts_GridView.size()>=1) {
			log("No of Products displayed in grid view are "+listOfProducts_GridView.size());
			status="PASS";
			takeScreenShot();
		}
		return status;

	}

	/**
	 * Method to verify the icon Map view list view grid view and sort by with default value
	 * @param _SortbyDefaultValue
	 */
	public String verifyMapView_ListView_GridView_SortByLabelDisplayed(String _SortbyDefaultValue) {
		status="FAIL";

		if(icon_MapView.isDisplayed()) {
			log("Map view icon is displayed in Product list page");
			if(icon_ListView.isDisplayed()) {
				log("List view icon is displayed in Product list page");
				if(icon_GridView.isDisplayed()) {
					log("Grid view icon is displayed in Product list page");
					log(dropDown_SortByDefaultValueDisplayed.getText());
					if(dropDown_SortByDefaultValueDisplayed.getText().equals(_SortbyDefaultValue)) {
						log("Default value option selected in Sort by: is "+dropDown_SortByDefaultValueDisplayed.getText());
						status="PASS";
						takeScreenShot();
					}
				}
			}
		}
		return status;



	}

	
	/**
	 * Method to verify the sortby list values
	 * @param _SortbyDefaultValue
	 */
	
	
	public String verify_Sortby_ListValues(String _SortbyListValues) {
		status="FAIL";

		String[] listValues = _SortbyListValues.split(",");
		
		dropDown_SortByDefaultValueDisplayed.click();
		log("Clicked on the Default Sortby value dropdown");
		
		List<WebElement> sortByList = driver.findElements(By.xpath("//ul[@id='dropDownListContent']//a"));
		
		
		
         for(int i=0;i<listValues.length;i++) {
        	 if(sortByList.get(i).getText().equals(listValues[i])) {
        		 status="PASS";
        		 log(sortByList.get(i).getText());
        	 }
        	 else {
        		  status="FAIL";
                  break;
        	 }
         }
		return status;


	}
	
	
	
	
	/**
	 * Click on the Cart icon in the Products page
	 * @throws InterruptedException 
	 */
	public void clickOnShoppingCartIcon() throws InterruptedException {
		Thread.sleep(2000);
	
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(label_CartIcon, driver, 15);
		clickElementUsingJavaScript(label_CartIcon);
		log("Clicked on the Cart icon");


	}


	/**
	 * Method to Add the products displayed for Reservation in the list view
	 * @return
	 * @throws InterruptedException 
	 */
	public int addProducts_IntoCart_Reservation_ListView() throws InterruptedException {
		WaitHelper wh = new WaitHelper(driver, test);
		List<WebElement> listOfProducts_ListView = driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-12 col-md-12 col-lg-12 px-0 ng-isolate-scope']//*[@id='btnAddToCart']"));

		log("No of products displayed are "+listOfProducts_ListView.size());

		if(listOfProducts_ListView.size()>0) {

			for(int i=0;i<2;i++) {
				WebElement addToCart = driver.findElement(By.xpath("//div[@id='product"+i+"' and @class='col-xs-12 col-sm-12 col-md-12 col-lg-12 px-0 ng-isolate-scope']//*[@id='btnAddToCart']//span"));
				wh.waitForElementToBeClickable(addToCart, driver, 30);
				clickElementUsingJavaScript(addToCart);
				Thread.sleep(3000);

			}
		}
		return listOfProducts_ListView.size();

	}

	/**
	 * Method to Add the products displayed for Reservation in the Grid view
	 * @return
	 * @throws InterruptedException 
	 */
	public int addProducts_IntoCart_Reservation_GridView() throws InterruptedException {
		WaitHelper wh = new WaitHelper(driver, test);
		List<WebElement> listOfProducts_GridView = driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-6 col-md-4 col-lg-4 pl-0 ng-isolate-scope']//*[@id='btnAddToCart']"));

		log("No of products displayed are "+listOfProducts_GridView.size());

		if(listOfProducts_GridView.size()>=1) {
			for(int i=0;i<listOfProducts_GridView.size();i++) {
				@SuppressWarnings("unused")
				int j =i+1;
				WebElement addToCart = driver.findElement(By.xpath("//div[@id='product"+i+"' and @class='col-xs-12 col-sm-6 col-md-4 col-lg-4 pl-0 ng-isolate-scope']//*[@id='btnAddToCart']//span"));
				wh.waitForElementToBeClickable(addToCart, driver, 30);
				clickElementUsingJavaScript(addToCart);
				
				Thread.sleep(3000);
				takeScreenShot();

			}
		}
		return listOfProducts_GridView.size();

	}


	/**
	 * Method to verify the no of item added shown as tool tip in the cart icon
	 * @param noOfProductsAddedIntoCart
	 */
	public String verify_CountOfItems_DisplayedInCartIcon_AsToolTip_AfterAddingProductToCart(int noOfProductsAddedIntoCart) {
		status="FAIL";

		if(tooltip_CountOfItemsInCartIcon.getText().equals(String.valueOf(noOfProductsAddedIntoCart))) {

			status="PASS";
			log("No of Products added are "+tooltip_CountOfItemsInCartIcon.getText()+" and shown as tooltip in Cart icon");
			takeScreenShot();

		}
		return status;

	}





	/**
	 * Method to add a single Product into Cart
	 * @return
	 * @throws InterruptedException
	 */
	public String addSingleProduct_IntoCart_Reservation_ListView() throws InterruptedException {
	   status="FAIL";
		Thread.sleep(3000);
		List<WebElement> listOfProducts_ListView = driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-12 col-md-12 col-lg-12 px-0 ng-isolate-scope']//*[@id='btnAddToCart']"));
		log("No of products displayed are "+listOfProducts_ListView.size());

		if(listOfProducts_ListView.size()>=1) {

			WebElement addToCart = driver.findElement(By.xpath("//div[@id='product"+0+"' and @class='col-xs-12 col-sm-12 col-md-12 col-lg-12 px-0 ng-isolate-scope']//*[@id='btnAddToCart']//span"));
			addToCart.click();
			log("Added the First Product displayed in List view");
			takeScreenShot();
			status="PASS";
		}
		return status;

	}


	/**
	 * Method to Hover mouse over the Cart pop up
	 * @throws InterruptedException
	 */
	public void hoverMouseOnCartPopUP() throws InterruptedException {
		WebElement cartpopup = driver.findElement(By.xpath("//div[@class='products-list hidden-xs ng-scope']"));
		//div[@class='cart-popup']//div[@class='products-list']
		MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver, test);
		mkh.mousehoverOnElement(cartpopup,driver);


	}



	@FindBy(how=How.XPATH,using ="//span[@translate='_YourCart_']")
	WebElement label_YourCart;

	@FindBy(how=How.XPATH,using ="//span[@class='ng-binding' and @data-ng-bind='cartTotalCount']")
	WebElement text_YourCartCountValue;

	/**
	 * Method will verify all the labels and the price time and total and buttons in the Cart pop up page for a single product
	 * @param _YourCartLabel
	 * @param _ExpectedFirstProductName
	 * @param _ExpectedFirstProductPrice
	 * @param _FromLabel
	 * @param _ToLabel
	 * @param _TotalLabel
	 * @param _LabelIncludesVat
	 * @param _SeeCartLabel
	 * @param _CheckoutLabel
	 * @throws ParseException
	 */
	public String verifyElementsAndProductDetailsInCartPopUp_ForSingleProduct(String _YourCartLabel,String _ExpectedFirstProductName,
			String _ExpectedFirstProductPrice,String _FromLabel,String _ToLabel,String _TotalLabel,String _LabelTaxIncl,
			String _SeeCartLabel,String _CheckoutLabel) throws ParseException {

		status="FAIL";

		String displayedYourCartMsgCount = 	label_YourCart.getText()+" "+"("+text_YourCartCountValue.getText()+")";

		//values of the cart pop up	
		String firstProductName_InCartPopUp = driver.findElement(By.xpath("//div[1][@class='product-details ng-scope' and @ng-repeat='item in cart.items']//h4")).getText();	
		String firstItemPrice_InCartPopUp = driver.findElement(By.xpath("//div[1][@class='product-details ng-scope' and @ng-repeat='item in cart.items']//span[@data-ng-bind='item.price']")).getText();

		String label_FROM_InCartPopUp = driver.findElement(By.xpath("//div[@class='from']//span[@translate='_From_']")).getText();
		String date_From_InCartPopUp = driver.findElement(By.xpath("//div[@class='from']//span[@data-ng-bind='item.from.format(dayFormat)']")).getText();
		String monthYear_From_InCartPopUp = driver.findElement(By.xpath("//div[@class='from']//span[@data-ng-bind='item.from | localizeDateFormat:datePickerLocale:monthYearFormat']")).getText();
		String timeAMPM_From_InCartPopUp = driver.findElement(By.xpath("//div[@class='from']//span[@data-ng-bind='item.from.format(timeFormat)']")).getText();

		String CartPopupFromDateTime = date_From_InCartPopUp+" "+monthYear_From_InCartPopUp+" - "+timeAMPM_From_InCartPopUp;

		String ProductPageSearchFieldfromDate = driver.findElement(By.xpath("//div[@id='dtFrom']//div[@class='date ng-binding']")).getText();
		String ProductPageSearchFieldfromMonthYear = driver.findElement(By.xpath("//div[@id='dtFrom']//div[@class='month-year ng-binding ng-scope']")).getText();
		String ProductPageSearchFieldfromTimeAMPM = driver.findElement(By.xpath("//div[@id='dtFrom']//div[@class='time ng-binding ng-scope']")).getText();

		String expectedFromDateTime = ProductPageSearchFieldfromDate+" "+ProductPageSearchFieldfromMonthYear+" - "+ProductPageSearchFieldfromTimeAMPM;

		String label_To_InCartPopUp = driver.findElement(By.xpath("//div[@class='to']//span[@translate='_To_']")).getText();

		String date_To_InCartPopUp = driver.findElement(By.xpath("//div[@class='to']//span[@data-ng-bind='item.to.format(dayFormat)']")).getText();
		String monthYear_To_InCartPopUp = driver.findElement(By.xpath("//div[@class='to']//span[@data-ng-bind='item.to | localizeDateFormat:datePickerLocale:monthYearFormat']")).getText();
		String timeAMPM_To_InCartPopUp = driver.findElement(By.xpath("//div[@class='to']//span[@data-ng-bind='item.to.format(timeFormat)']")).getText();

		String CartPopupToDateTime = date_To_InCartPopUp+" "+monthYear_To_InCartPopUp+" - "+timeAMPM_To_InCartPopUp;

		String ProductPageSearchFieldToDate = driver.findElement(By.xpath("//div[@id='dtTo']//div[@class='date ng-binding']")).getText();
		String ProductPageSearchFieldToMonthYear = driver.findElement(By.xpath("//div[@id='dtTo']//div[@class='month-year ng-binding']")).getText();
		String ProductPageSearchFieldToTimeAMPM = driver.findElement(By.xpath("//div[@id='dtTo']//div[@class='time ng-binding']")).getText();
		String expectedToDateTime = ProductPageSearchFieldToDate+" "+ProductPageSearchFieldToMonthYear+" - "+ProductPageSearchFieldToTimeAMPM;

		String label_Total = driver.findElement(By.xpath("//div[@class='total-price']//h4")).getText();
		String label_TaxIncluded = driver.findElement(By.xpath("//div[@class='total-price']//div[@class='vat ng-binding ng-scope']")).getText();
		String value_TotalAmountDisplayed = driver.findElement(By.xpath("//div[@class='total-price']//span[@data-ng-bind='cart.totalPrice']")).getText();

		log(value_TotalAmountDisplayed+"Total amount displayed is");

		if(displayedYourCartMsgCount.equals(_YourCartLabel)) {
			log(displayedYourCartMsgCount+ "is displayed");

			if(firstProductName_InCartPopUp.equals(_ExpectedFirstProductName)) {
				log(firstProductName_InCartPopUp+" is displayed in Cart popup");	

				if(firstItemPrice_InCartPopUp.equals(_ExpectedFirstProductPrice)) {
					log(firstItemPrice_InCartPopUp + "displayed as first product price in cart pop up");

					if(label_FROM_InCartPopUp.equals(_FromLabel)) {
						log(label_FROM_InCartPopUp+" is displayed in cart pop up");

						if(CartPopupFromDateTime.equals(expectedFromDateTime)) {
							log(CartPopupFromDateTime+" displayed as from time in cart pop up");

							if(label_To_InCartPopUp.equals(_ToLabel)) {
								log(label_To_InCartPopUp+" displayed in cart pop up");

								if(CartPopupToDateTime.equals(expectedToDateTime)) {
									log(CartPopupToDateTime+" displayed as To time in cart pop up");

									if(label_Total.equals(_TotalLabel)) {
										log(label_Total+" label is displayed in cart pop up");

										if(label_TaxIncluded.equals(_LabelTaxIncl)) {
											log(label_TaxIncluded+" label is displayed in cart pop up");

											if(value_TotalAmountDisplayed.equals(firstItemPrice_InCartPopUp)) {
												log("Total amount in cart is displayed as "+value_TotalAmountDisplayed);


												if(button_SeeCart_InCartPopUp.getText().equals(_SeeCartLabel)) {
													log(button_SeeCart_InCartPopUp.getText()+" is displayed in cart pop up");

													if(button_CHECKOUT_InCartPopUp.getText().equals(_CheckoutLabel)) {
														log(button_CHECKOUT_InCartPopUp.getText()+" is displayed in cart pop up");
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
		}
		return status;

	}




	/**
	 * Method to get the Product name by specifying the integer of the product displayed in view.
	 * @param i = position of the product start from 1
	 * @return product name
	 */
	public String getProductName(int i) {
		int j=i-1;
		String productName = driver.findElement(By.xpath("//div[@id='product"+j+"']//h2")).getText();
		return productName;
	}

	/**
	 * Method to get the Product name by specifying the integer of the product displayed in view.
	 * @param i =  position of the product start from 1
	 * @return product price
	 */
	public String getProductPrice(int i) {
		int j=i-1;
		String productPrice = driver.findElement(By.xpath("//div[@id='product"+j+"']//span[@data-ng-if='product.promotionalPrice']")).getText();
		return productPrice;
	}

	/**
	 * Method to click on See cart in cart pop up window
	 */
	public void clickOnSeeCart_InCartPopUpWindow() {
		clickElementUsingJavaScript(button_SeeCart_InCartPopUp);
		log("Clicked on See cart button in Cart pop up");
		takeScreenShot();

	}

	/**
	 * Method to click on checkout button in the cart pop up window.
	 */
	public void clickOnCheckout_InCartPopUpWindow() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(button_CHECKOUT_InCartPopUp, driver, 30);
		button_CHECKOUT_InCartPopUp.click();
		log("Clicked on Checkout button in Cart pop up");
		takeScreenShot();

	}


	@FindBy(how=How.XPATH,using ="//a[@id='goToProfile1']/div")
	WebElement link_Profile;
	public void clickOnProfileLink() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(link_Profile, driver, 20);
		link_Profile.click();
		log(link_Profile.getText()+" is clicked");
		takeScreenShot();

	}


//	public String addSubscription() {
//		status="FAIL";
//		List<WebElement> listOfProducts_ListView = driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-12 col-md-12 col-lg-12 px-0 ng-isolate-scope']//*[@id='btnAddToCart']"));
//		log("No of products displayed are "+listOfProducts_ListView.size());
//
//		if(listOfProducts_ListView.size()>=1) {
//
//		
//			String promotionalPrice = driver.findElement(By.xpath("//div[@id='product0'][@class='col-xs-12 col-sm-12 col-md-12 col-lg-12 px-0 ng-isolate-scope']//span[@data-ng-bind='product.promotionalPrice']")).getText();
//			
//			
//			
//			WebElement addFirstSubscription = driver.findElement(By.xpath("//div[@id='product"+0+"' and @class='col-xs-12 col-sm-12 col-md-12 col-lg-12 px-0 ng-isolate-scope']//*[@id='btnAddToCart']//span"));
//			addFirstSubscription.click();
//			log("Added the First Subscription displayed in List view");
//			takeScreenShot();
//			status="PASS";
//		}
//		return status;
//
//	}
	
	
	
	public String addFirstSubscriptionDisplayed() {
		status="FAIL";
		List<WebElement> listOfProducts_ListView = driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-12 col-md-12 col-lg-12 px-0 ng-isolate-scope']//*[@id='btnAddToCart']"));
		log("No of products displayed are "+listOfProducts_ListView.size());

		if(listOfProducts_ListView.size()>=1) {
			
			for(int i=0;i<listOfProducts_ListView.size();i++) {
				
				String promotionalPrice = driver.findElement(By.xpath("//div[@id='product"+i+"'][@class='col-xs-12 col-sm-12 col-md-12 col-lg-12 px-0 ng-isolate-scope']//span[@data-ng-bind='product.promotionalPrice']")).getText();
				
				if(!promotionalPrice.equalsIgnoreCase("PPU")) {
				WebElement addFirstSubscription = driver.findElement(By.xpath("//div[@id='product"+i+"' and @class='col-xs-12 col-sm-12 col-md-12 col-lg-12 px-0 ng-isolate-scope']//*[@id='btnAddToCart']//span"));
				addFirstSubscription.click();
					log("Added the Subscription displayed in List view");
					status="PASS";
					takeScreenShot();
					return status;
				}


			
		    }
		}
		
		takeScreenShot();
		return status;
		
	}
	
	
	
	
	
	
	
	
	public String subscribeSingleFlatFee(String _SubscriptionType) {
		status="FAIL";
		List<WebElement> listOfProducts_ListView = driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-12 col-md-12 col-lg-12 px-0 ng-isolate-scope']//*[@id='btnAddToCart']"));
		log("No of products displayed are "+listOfProducts_ListView.size());

		if(listOfProducts_ListView.size()>=1) {
			
			for(int i=0;i<listOfProducts_ListView.size();i++) {
				
				String promotionalPrice = driver.findElement(By.xpath("//div[@id='product"+i+"'][@class='col-xs-12 col-sm-12 col-md-12 col-lg-12 px-0 ng-isolate-scope']//span[@data-ng-bind='product.promotionalPrice']")).getText();
				
				if(promotionalPrice.equalsIgnoreCase(_SubscriptionType)) {
				WebElement addFirstSubscription = driver.findElement(By.xpath("//div[@id='product"+i+"' and @class='col-xs-12 col-sm-12 col-md-12 col-lg-12 px-0 ng-isolate-scope']//*[@id='btnAddToCart']//span"));
				addFirstSubscription.click();
					log("Added the Flat fee displayed in List view");
					status="PASS";
					takeScreenShot();
					return status;
				}


			
		    }
		}
		
		takeScreenShot();
		return status;
		
	}
	
	
	

	
	@FindBy(how=How.XPATH,using ="//span[@class='price ng-binding' and @data-ng-bind='cart.totalPrice']")
	WebElement cart_totalprice;
	
	public String getCartTotalPrice() throws InterruptedException {
		
		WebElement cartpopup = driver.findElement(By.xpath("//div[@class='products-list hidden-xs ng-scope']"));//div[@class='cart-popup']//div[@class='products-list']
		MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver, test);
		mkh.mousehoverOnElement(cartpopup,driver);
		
		
		log("Total in cart popup is "+cart_totalprice.getText());
		return cart_totalprice.getText();
	}


//	public String subscribePPU() {
//		status="FAIL";
//		List<WebElement> listOfProducts_ListView = driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-12 col-md-12 col-lg-12 px-0 ng-isolate-scope']//*[@id='btnAddToCart']"));
//		log("No of products displayed are "+listOfProducts_ListView.size());
//
//		if(listOfProducts_ListView.size()>=1) {
//			
//			for(int i=0;i<listOfProducts_ListView.size();i++) {
//				
//				String promotionalPrice = driver.findElement(By.xpath("//div[@id='product"+i+"'][@class='col-xs-12 col-sm-12 col-md-12 col-lg-12 px-0 ng-isolate-scope']//span[@data-ng-bind='product.promotionalPrice']")).getText();
//				
//				if(promotionalPrice.equalsIgnoreCase("PPU")) {
//				WebElement addFirstSubscription = driver.findElement(By.xpath("//div[@id='product"+i+"' and @class='col-xs-12 col-sm-12 col-md-12 col-lg-12 px-0 ng-isolate-scope']//*[@id='btnAddToCart']//span"));
//				addFirstSubscription.click();
//					log("Added the Flat fee displayed in List view");
//					status="PASS";
//					takeScreenShot();
//					return status;
//				}
//
//
//			
//		    }
//		}
//		
//		takeScreenShot();
//		return status;
//		
//	}

	@FindBy(how=How.XPATH,using ="//*[@id='cartErrorModal']/div/div/div[2]")
	WebElement popUp_DuplicateProductMessage;
	
	@FindBy(how=How.XPATH,using ="//*[@id='cartErrorModal']//h3")
	WebElement ErrorMessage;
	
	@FindBy(how=How.XPATH,using ="//*[@id='cartErrorModal']/div/div/div[3]/button")
	WebElement OK;
	
	
	public String verifyDuplicateProductMessageInCart(String _DuplicateItemInCartMsg) {
	status="FAIL";
	WaitHelper wh = new WaitHelper(driver, test);
	wh.waitForElementToBeVisible(popUp_DuplicateProductMessage, driver, 30);
		if(popUp_DuplicateProductMessage.isDisplayed()) {
			log("Error dialog is displayed ");
			takeScreenShot();
			log(ErrorMessage.getText());
			
			if(ErrorMessage.getText().equals(_DuplicateItemInCartMsg)) {
				log("Error message displayed as "+ErrorMessage.getText());
				OK.click();
				status="PASS";
				takeScreenShot();
				
			}
		}
		return status;
		
		
	}
	
	/*error message displayed for duplicate products in cart*/
	
	public String verifyDuplicateCart_Message_Displayed(String _Duplicate_Cart_Error_PopUp_Message) {
		
		status="FAIL";
		
		    WaitHelper wh = new WaitHelper (driver, test);
		    wh.waitForElementToBeClickable(Duplicate_Cart_Error_PopUp_Message, driver, 20);
		
			log("Error message displayed in PopUp for duplicate cart value is -->"+ Duplicate_Cart_Error_PopUp_Message.getText());
			
			if(Duplicate_Cart_Error_PopUp_Message.getText().equals(_Duplicate_Cart_Error_PopUp_Message)) {
				status ="PASS";
				log("Duplicate cart Message displayed correctly in the Popup");
			}
			
		
		
		return status;
	}
	
	/*Duplicate Cart PopUp X button*/

	public String DuplicateCart_PopUp_X_Button() {
		WaitHelper wh = new WaitHelper (driver,test);
		wh.waitForElementToBeClickable(Duplicate_Cart_Error_PopUp_X_Button, driver, 20);
		Duplicate_Cart_Error_PopUp_X_Button.click();
		log("clicked on X button in PopUp");
		return status;

	}
	
	/*Duplicate Cart PopUp OK Button*/
	
	public String DuplicateCart_PopUp_Ok_Button() {
		WaitHelper wh = new WaitHelper (driver,test);
		wh.waitForElementToBeClickable(Duplicate_Cart_Error_PopUp_Ok_Button, driver, 20);
		Duplicate_Cart_Error_PopUp_Ok_Button.click();
		log("clicked on Ok button in PopUp");
		return status;

	}

}