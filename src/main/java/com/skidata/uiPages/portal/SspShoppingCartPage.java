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
import com.skidata.helperclasses.JavaScriptHelper;
import com.skidata.helperclasses.WaitHelper;
import com.skidata.testBase.TestBase;

/**
 * @author shmo
 * 
 */
public class SspShoppingCartPage extends TestBase {

	
	
	String status=null;


	public static final Logger log = Logger.getLogger(SspShoppingCartPage.class.getName());



	//Class constructor
	public SspShoppingCartPage(WebDriver driver,ExtentTest test) {
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

	@FindBy(how=How.XPATH,using ="//h2[@translate='_YourShoppingCartEmpty_']")
	WebElement label_EmptyCartMsg;


	@FindBy(how=How.XPATH,using ="//a[@id='goToCart1']/div[2]")
	WebElement label_NoOfProducts_Number_InCartIcon;


	@FindBy(how=How.XPATH,using ="//button[@id='btnOk']")
	WebElement button_YES_deleteProductConfirmationDialog;
	
	
	@FindBy(how=How.XPATH,using ="//button[@id='btnCancel']")
	WebElement button_NO_deleteProductConfirmationDialog;
	
	@FindBy(how=How.XPATH,using ="//h1[@class='ng-binding' and @data-ng-bind='$ctrl.modalObj.modalTitle']")
	WebElement msg_DeleteProductConfirmation;
	
	
	@FindBy(how=How.XPATH,using ="//div[@translate='_ContinueShopping_']")
	WebElement link_ContinueShopping;
	
	
	@FindBy(how=How.XPATH,using ="//button[@id='btnGoToCheckOut']")
	WebElement button_CHECKOUT;
	
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
	
	@FindBy(how=How.XPATH,using ="//a[@translate='_Login_']")
	WebElement link_Login_emptyCartMessage;
	

	@FindBy(how=How.XPATH,using ="//button[@id='btnOk']")
	WebElement DeleteProduct_Yes_Button_From_Cart;
	
	
	
	
	
	/**
	 * Method to verify the Empty cart message displayed for the User
	 * @param _EmptyCartMsg
	 * @param _EmptyCartMsgForUser
	 * @return PASS or FAIL
	 * @throws InterruptedException 
	 */
	public String verifyDefaultEmptyCart_Message(String _EmptyCartMsg,String _EmptyCartMsgForUser) throws InterruptedException {
		status="FAIL";
		
		Thread.sleep(5000);
		
		if(label_EmptyCartMsg.getText().equals(_EmptyCartMsg)) {

			String msgForUser = driver.findElement(By.xpath("//span[@translate='_IfYouAlreadyHaveAnAccount_']")).getText()+" "+
					driver.findElement(By.xpath("//a[@translate='_Login_']")).getText()+" "+
					driver.findElement(By.xpath("//span[@translate='_ToSeeYourCart_']")).getText()+ " "+
					driver.findElement(By.xpath("//span[@translate='_ClickHere_']")).getText()+" "+
					driver.findElement(By.xpath("//span[@translate='_ToContinueShopping_']")).getText();
			
			if(msgForUser.equals(_EmptyCartMsgForUser)) {
				status="PASS";
				takeScreenShot();
				log(label_EmptyCartMsg.getText());
				log(msgForUser);
				log("Messages are displayed in the Cart page if the cart is empty");
			}

		}
		return status;


	}
	
	
	@FindBy(how=How.XPATH,using ="//h2[@translate='_YourShoppingCartEmpty_']")
	WebElement Header_Text_From_EmptyCart;
	
	@FindBy(how=How.XPATH,using ="//h5[@translate='_PleaseClickOnTheButtonBelowToContinueShopping_']")
	WebElement SubHeader_Text_From_EmptyCart;
	
	@FindBy(how=How.XPATH,using ="//span[@translate='_ContinueShopping_']")
	WebElement ContinueButton_From_EmptyCart;
	

	
	
	public String verifyPage_EmptyCart_HeaderAndLabel(String _PageHeader,String _PageSubHeader,String _ContinueButton) throws InterruptedException {
		status="FAIL";
		Thread.sleep(1000);
		if(Header_Text_From_EmptyCart.getText().equals(_PageHeader)) {
			log(Header_Text_From_EmptyCart.getText()+" is displayed");
			if(SubHeader_Text_From_EmptyCart.getText().equals(_PageSubHeader)) 
				log(SubHeader_Text_From_EmptyCart.getText()+" is displayed");
			    if(ContinueButton_From_EmptyCart.getText().equals(_ContinueButton)) 
				   log(ContinueButton_From_EmptyCart.getText()+" is displayed");
			
				takeScreenShot();
				status="PASS";
			}	
		
		return status;
	}
	

	
	
	public void clickonContinueShooping() throws InterruptedException {
		
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(ContinueButton_From_EmptyCart, driver, 10);
		
		clickElementUsingJavaScript(ContinueButton_From_EmptyCart);

		log("Clicked on the Continue Shooping Button");
		takeScreenShot();

	}
	
	
	/**
	 * Method to verify the Empty cart message displayed for the User
	 * @param _EmptyCartMsg
	 * @param _EmptyCartMsgForUser
	 * @return PASS or FAIL
	 */
	public String verifyDefaultEmptyCart_MsgLoggedInUser(String _EmptyCartMsg,String _EmptyCartMsgForUser) {
		status="FAIL";
		
		if(label_EmptyCartMsg.getText().equals(_EmptyCartMsg)) {

			String msgForUser = driver.findElement(By.xpath("//span[@translate='_ClickHere_']")).getText()+" "+
					driver.findElement(By.xpath("//span[@translate='_ToContinueShopping_']")).getText();
			
			if(msgForUser.equals(_EmptyCartMsgForUser)) {
				status="PASS";
				takeScreenShot();
				log(label_EmptyCartMsg.getText());
				log(msgForUser);
				log("Messages are displayed in the Cart page if the cart is empty");
			}

		}
		return status;


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
		driver.getTitle();
		log(_PageTitle);
		
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

	/**
	 *****************************************************************************************************************
	 * Method to verify the Header icons of the Main page for Monthly
	 * @param _HomeIconLabel
	 * @param _CartIconLabel
	 * @param _LoginIconLabel
	 * @return PASS or FAIL
	 * @throws InterruptedException 
	 *****************************************************************************************************************
	 */
	public String verifyHeaderIconsLabelsInHomePageForMonthly(String _HomeIconLabel,String _LoginIconLabel) throws InterruptedException {
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
	 * Method to verify the Header icons of the Main page
	 * @param _HomeIconLabel
	 * @param _CartIconLabel
	 * @param _LoginIconLabel
	 * @return PASS or FAIL
	 * @throws InterruptedException 
	 *****************************************************************************************************************
	 */
	public String verifyHeaderIconsLabelsInHomePageForHourly(String _HomeIconLabel,String _CartIconLabel,String _LoginIconLabel) throws InterruptedException {
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



	public String verifyNoOfProductsDisplayedIsCorrect() {
		status="FAIL";
		String noOfAddedProducts = label_NoOfProducts_Number_InCartIcon.getText();
		int noOfAddProdInCart = Integer.parseInt(noOfAddedProducts);
		int noOfProductsListed = driver.findElements(By.xpath("//div[contains(@id,'cartDetails')]")).size();

		if(noOfAddProdInCart==noOfProductsListed) {
			status="PASS";
			takeScreenShot();
			log("Total no of Products in the Cart page is "+noOfProductsListed);
			status="PASS";
		}
		return status;
	}

	/**
	 * Method to check the From and To labels are displayed for all the products added in cart page
	 * @return
	 * @throws InterruptedException 
	 */
	public String verifyFromToLabelForAllProductsInCartPage(String _FromLabel,String _ToLabel) throws InterruptedException {
		status="FAIL";
		Thread.sleep(3000);
		List<WebElement> totalProductsAdded = driver.findElements(By.xpath("//div[contains(@id,'cartDetails')]"));
		for(int i=0;i<totalProductsAdded.size();i++) {
			status="FAIL";
			WebElement fromLabel = driver.findElement(By.xpath("//div[contains(@id,'cartDetails"+i+"')]//div[@class='from']//strong"));
			WebElement toLabel = driver.findElement(By.xpath("//div[contains(@id,'cartDetails"+i+"')]//div[@class='to']//strong"));

			if(fromLabel.getText().equals(_FromLabel)) {
				if(toLabel.getText().equals(_ToLabel)) {
					highlightWebElement(driver, fromLabel);
					highlightWebElement(driver, toLabel);
					log("From and To label is displayed for product"+(i+1));
					status="PASS";
					takeScreenShot();
				}
			}
		}

		return status;



	}

	
	/**
	 * Method to verify the From date time and To date time for the first product.
	 * @return
	 * @throws InterruptedException 
	 */
	public String verifyFromToTimeForFirstProductInCartPage(String _ExpectedFromDateTime,String _ExpectedToDateTime) throws InterruptedException {
		status="FAIL";
	
			status="FAIL";
			String fromDate = driver.findElement(By.xpath("//div[@class='from']//div[@class='date-time']//div[@data-ng-bind='item.from.format(dayFormat)']")).getText();
			String fromMonthYear = driver.findElement(By.xpath("//div[@class='from']//div[@data-ng-bind='item.from | localizeDateFormat:datePickerLocale:monthYearFormat']")).getText();
			String fromTimeAMPM = driver.findElement(By.xpath("//div[@class='from']//div[@data-ng-bind='item.from.format(timeFormat)']")).getText();
			
			String toDate = driver.findElement(By.xpath("//div[@class='to']//div[@class='date-time']//div[@data-ng-bind='item.to.format(dayFormat)']")).getText();
			String toMonthYear = driver.findElement(By.xpath("//div[@class='to']//div[@data-ng-bind='item.to | localizeDateFormat:datePickerLocale:monthYearFormat']")).getText();
			String toTimeAMPM = driver.findElement(By.xpath("//div[@class='to']//div[@data-ng-bind='item.to.format(timeFormat)']")).getText();
			
			String firstProductFromDateTime = fromDate+fromMonthYear+fromTimeAMPM;
			String firstProductToDateTime = toDate+toMonthYear+toTimeAMPM;
			
			if(firstProductFromDateTime.equals(_ExpectedFromDateTime)) {
				if(firstProductToDateTime.equals(_ExpectedToDateTime)) {
					
					log("From Date time and To Date time for first product is displayed correctly");
					log("Expected from time is "+_ExpectedFromDateTime);
					log("Expected to time is "+_ExpectedToDateTime);
					log("Actual from time is "+firstProductFromDateTime);
					log("Actual to time is "+firstProductToDateTime);
					
					takeScreenShot();
					status="PASS";
					
				}
			}
			return status;
			

	}
	
	
	
	

	public void deleteAllProductsFromCart() throws InterruptedException {

		int totalProductsAdded = driver.findElements(By.xpath("//div[contains(@id,'cartDetails')]")).size();

		for(int i = 0;i<totalProductsAdded;i++) {

			WebElement trashIcon = driver.findElement(By.xpath("//span[@id='removeProduct0']/a/span"));
			Thread.sleep(3000);
			clickElementUsingJavaScript(trashIcon);
			Thread.sleep(3000);
			log("Clicked on delete icon");
			clickElementUsingJavaScript(button_YES_deleteProductConfirmationDialog);
			Thread.sleep(3000);
			log("clicked on DELETE button");
			takeScreenShot();

		}



	}

	/**
	 * Method to count the delete product icons in cart page
	 * @return
	 * @throws InterruptedException 
	 */
	public String verifyDeleteIconForAllProductsInCartPage() throws InterruptedException {
		status="FAIL";
		Thread.sleep(3000);
		List<WebElement> totalProductsAdded = driver.findElements(By.xpath("//div[contains(@id,'cartDetails')]"));

		List<WebElement> trashIcon = driver.findElements(By.xpath("//span[contains(@id,'removeProduct')]/a/span"));

		if(totalProductsAdded.size()==trashIcon.size()) {
			log("Total products are "+totalProductsAdded.size());
			log("Total delete icons are "+trashIcon.size());
			status="PASS";
		}

		return status;

	}


	public String verifyDeleteConfirmationMessage_Cancel_AndDeleteProduct(String _Part1,String _Part2) throws InterruptedException {

		status="FAIL";
		int totalProductsAdded = driver.findElements(By.xpath("//div[contains(@id,'cartDetails')]")).size();
		
		
		for(int i = 0;i<totalProductsAdded;i++) {
            status="FAIL";
            
            Thread.sleep(5000);
			String productName = driver.findElement(By.xpath("//div[@id='cartDetails0']//h2")).getText(); //extracting the first product name
			log(productName+" is to be deleted");
			
			WebElement trashIcon = driver.findElement(By.xpath("//span[@id='removeProduct0']/a/span"));
			clickElementUsingJavaScript(trashIcon); //clicking on Delete icon
			log("Clicked on the delete icon");
			Thread.sleep(3000);
			takeScreenShot();
			clickElementUsingJavaScript(button_NO_deleteProductConfirmationDialog); //clicking on cancel button
			Thread.sleep(3000);
			log("Clicked on the No button");
			Thread.sleep(3000);
			trashIcon = driver.findElement(By.xpath("//span[@id='removeProduct0']/a/span"));
			clickElementUsingJavaScript(trashIcon);//clicking on Delete icon
			log("Clicked on the delete icon");
			Thread.sleep(3000);
			String confirmationMessage = msg_DeleteProductConfirmation.getText();//extracting the delete confirmation message
			
			log("Actual Message is : " +confirmationMessage);
			log(_Part1+" '"+productName+"' "+_Part2);
	        
	    	Thread.sleep(3000);
	        if(confirmationMessage.equals(_Part1+" '"+productName+"' "+_Part2)) { /* verifying that the message is correct*/
			clickElementUsingJavaScript(button_YES_deleteProductConfirmationDialog);
			
			log("Clicked on the Yes button");
			status="PASS";
			takeScreenShot();
			}else {
				log("Product Not deleted and Delete Confirmation message mismatch");
				status="FAIL";
				return status;
			}
			

		}
		return status;



	}

	public void clickonContinueShoppingLink() throws InterruptedException {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeClickable(link_ContinueShopping, driver, 20);
		clickElementUsingJavaScript(link_ContinueShopping);
		log("clicked on < Continue shopping link");
		takeScreenShot();
		Thread.sleep(5000);
	
	}

	public void clickonCheckout() throws InterruptedException {
		Thread.sleep(8000);
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(button_CHECKOUT, driver, 10);
		clickElementUsingJavaScript(button_CHECKOUT);
		log("Clicked on the CHECKOUT button in cart page");
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

		JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver,test);
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
		if(image_SSLSecured.isDisplayed()) {
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
		}

		return status;
	}

	/**
	 * Method to click on Log in 
	 */
	public void clickonLogin() {
		label_LoginIcon.click();
		log("Clicked on the Login");
		takeScreenShot();
		
	}

	public void clickOnLoginLinkInMessage() {
		link_Login_emptyCartMessage.click();
		log("Clicked on the Login in Empty cart message");
		takeScreenShot();
	}
	
	public void clickOnContinueShoppingButton() {
		ContinueButton_From_EmptyCart.click();
		log("Clicked on the Continue Shopping Button in Empty cart page");
		takeScreenShot();
	}

	public String getValueAddedTaxesAmount() {
	
		String[] vatValue = driver.findElement(By.xpath("//div[@class='vat ng-binding']")).getText().split(" ");
		log("Displayed Vat in Cart page is "+vatValue[2]+" "+vatValue[3]);
		String vat = vatValue[2]+" "+vatValue[3];
		return vat;
		
		
	}

	public String getTotalAmountFromCartPage() throws InterruptedException {
		Thread.sleep(4000);
		String totalAmount = driver.findElement(By.xpath("//div[@data-ng-bind='cart.totalPrice']")).getText();
		log(totalAmount + "is the displayed Total amount in cart page ");
		return totalAmount;
		
	}


	public String verifyTotalbetweenCartPopUpAndCartPage(String _CartPopUpTotalPrice,String _TotalPriceFromCartPage) throws InterruptedException {
		status ="FAIL";
		Thread.sleep(3000);
		if(_CartPopUpTotalPrice.equals(_TotalPriceFromCartPage)) {
			log("Total Price displayed in Cart pop up in product list page is "+_CartPopUpTotalPrice);
			log("Total Price displayed in Cart page is "+_TotalPriceFromCartPage);
			status="PASS";
		}
		else {
			log("Mismatch in the total price of cart page and total price of cartPopup");
		}
		return status;
	}

	



}