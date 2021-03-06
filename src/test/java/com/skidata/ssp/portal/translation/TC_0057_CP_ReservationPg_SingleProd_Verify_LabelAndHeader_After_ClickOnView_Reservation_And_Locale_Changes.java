/**
 *
 */
package com.skidata.ssp.portal.translation;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skidata.helperclasses.DateAndUniqueNoGenerateHelper;
import com.skidata.helperclasses.WaitHelper;
import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspBookingConfirmationPage;
import com.skidata.uiPages.portal.SspCheckoutPage;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.uiPages.portal.SspLoginPage;
import com.skidata.uiPages.portal.SspProductsListPage;
import com.skidata.uiPages.portal.SspPspPage;
import com.skidata.uiPages.portal.SspReservations;
import com.skidata.uiPages.portal.SspShoppingCartPage;
import com.skidata.uiPages.portal.SspSignUpPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author naan
 * 
 * 
 */

public class TC_0057_CP_ReservationPg_SingleProd_Verify_LabelAndHeader_After_ClickOnView_Reservation_And_Locale_Changes extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0057_CP_ReservationPg_SingleProd_Verify_LabelAndHeader_After_ClickOnView_Reservation_And_Locale_Changes.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0057_CP_ReservationPg_SingleProd_Verify_LabelAndHeader_After_ClickOnView_Reservation_And_Locale_Changes";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=512,dataProvider = "getDataForTestCaseName", testName = "TC_0057_CP_ReservationPg_SingleProd_Verify_LabelAndHeader_After_ClickOnView_Reservation_And_Locale_Changes", description ="TC_0057_CP_ReservationPg_SingleProd_Verify_LabelAndHeader_After_ClickOnView_Reservation_And_Locale_Changes")
	public void ssp_TC_0057_CP_ReservationPg_SingleProd_Verify_LabelAndHeader_After_ClickOnView_Reservation_And_Locale_Changes(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);
			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			DateAndUniqueNoGenerateHelper dateAndUniqueNoGenerateHelper = new DateAndUniqueNoGenerateHelper();
			String endDate=dateAndUniqueNoGenerateHelper.get_PreviousDate_OrFutureDate("MM/dd/yyyy",data.get("AddOrMinusDate"));

			sspHomePage.clickonLogin();
			SspLoginPage sspLoginPage = new SspLoginPage(driver, test);

		    SspSignUpPage sspSignUpPage = new SspSignUpPage(driver, test);
		    sspLoginPage.clickOnSignUp();
		    
		    String UniqueEmailId=sspSignUpPage.emailCreationNew();
			sspSignUpPage.EnterSignUpDetails(data.get("salutation"),data.get("Fname"),
					data.get("Lname"),UniqueEmailId+"@harakirimail.com",data.get("Password"),data.get("ConfirmPassword"));
			
			sspSignUpPage.clickOnSignUp();
		    sspLoginPage.Verifysignup(UniqueEmailId);
		    
            Thread.sleep(3000);
		    sspLoginPage.login(UniqueEmailId+"@harakirimail.com",data.get("Password"));  
		    
			sspHomePage.searchParkingLocationsAndSelect(data.get("EnterLocationNameToSearch"),data.get("SelectLocationAddress"));
			sspHomePage.select_ProductSearchStartDate_InFromCalendar_Reservation();
			sspHomePage.select_ProductSearchEndDate_InToCalendar_Reservation(endDate);
			sspHomePage.clickOnSearchYourParkingButton();
			
			SspProductsListPage sspProductsListPage = new SspProductsListPage(driver, test);
			status= sspProductsListPage.verifyProductListDisplayedForDefaultLocation_InListView();
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Products are not displayed in the List view");
//			sspProductsListPage.addProducts_IntoCart_Reservation_ListView();
			sspProductsListPage.addSingleProduct_IntoCart_Reservation_ListView();
			sspProductsListPage.clickOnShoppingCartIcon();

			SspShoppingCartPage sspShoppingCartPage = new SspShoppingCartPage(driver, test);
			sspShoppingCartPage.clickonCheckout();
			
			SspCheckoutPage sspCheckoutPage = new SspCheckoutPage(driver, test);
			status=sspCheckoutPage.verifyPageTitle(data.get("PageTitle_Checkout"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of Checkout page");
			
			sspCheckoutPage.clickonAddAddress_Optionally();
			sspCheckoutPage.enterPrivatePersonDetails(data.get("PrivatePerson_Name"),data.get("PrivatePerson_Country"),data.get("PrivatePerson_Address"),data.get("PrivatePerson_Phone"));
			
			sspCheckoutPage.addIdentificationDetails_SingleProduct(data.get("Identification1"));
			
//			status=sspCheckoutPage.verifyIamNotTheParker_text(data.get("IamNotheParkerMessage"));
//			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"I am not the parker Text displayed successfully in checkout page");
			
            sspCheckoutPage.clickonIamNotTheParker();
			
			 String UniqueEmailIdParker=sspSignUpPage.emailCreation();
//        	
            sspCheckoutPage.EnterIamNotTheParkerDetails(data.get("ParkerName"),UniqueEmailIdParker );
			Assert.assertEquals(status,data.get("ExpectedValuePASS"), "I am not the parker details entered");
			
//			sspCheckoutPage.addIdentificationDetails_AfterAdding_Parker(data.get("IdentificationCardName"), data.get("Identification_CardNumber"));
			
            
			sspCheckoutPage.clickon_TermsAndCondition_And_PrivacyPolicy_Checkbox();

			sspCheckoutPage.clickOnPay();
	
			
			SspPspPage SspPspPages=new SspPspPage(driver, test);
			
			
			log(driver.getTitle());
			
			WaitHelper whHelper = new WaitHelper(driver, test);
			whHelper.waitUntilPageTitleChanges(driver, 20, "Checkout");
			
			if(driver.getTitle().equals("Checkout")) {
				
				WaitHelper wh = new WaitHelper(driver, test);
				
						    driver.switchTo().frame(0);
							
							WebElement creditCard = driver.findElement(By.xpath("//*[@id='CCARD']/img"));
							wh.waitForElementToBeVisible(creditCard, driver, 10);
							
							creditCard.click();
							SspPspPages.EnterCreditcardMaestroSecureCodeUserDetails2(data.get("CardHolderName"),data.get("CardHolderNumber"),data.get("CardExpMonth"),data.get("CardExpYear"),data.get("CardCVV"));

				
			}else {
				
				
				WaitHelper wh = new WaitHelper(driver, test);
				wh.waitUntilPageTitleChanges(driver,20, data.get("PageTitle_Checkout"));
		
				String paymentPageType = driver.getTitle();
				log(paymentPageType);

//				if(paymentPageType.toLowerCase().contains(data.get("PaymentTypeWireCard"))) {
//					SspPspPages.clickonCreditcardMaestroSecureCodePayment();
//					SspPspPages.EnterCreditcardMaestroSecureCodeUserDetails(data.get("CardHolderName"),data.get("CardHolderNumber"),data.get("CardExpMonth"),data.get("CardExpYear"),data.get("CardCVV"));
//				}
				
				SspPspPages.enterPaymentDetailsNewPage(paymentPageType,data.get("CardHolderName"),data.get("CardHolderNumber"),data.get("CardExpMonth"),data.get("CardExpYear"),data.get("CardCVV"));
				
			}
 
			
			SspBookingConfirmationPage sspBookingConfirmationPage = new SspBookingConfirmationPage(driver, test);
			status=sspBookingConfirmationPage.verifyPageTitle(data.get("PageTitle_BookingConfirmation"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Reservation Failed, User in CheckoutPage");
			log(driver.getTitle());
			
			sspBookingConfirmationPage.clickOnBookingId();
			
			SspReservations sspReservations = new SspReservations(driver, test);
			log(driver.getTitle());
			
			sspReservations.verifyPageTitle(data.get("PageTitle_Reservations"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"User not navigated to Reservations page");
			
			sspReservations.clickonBackToReservationLink();
			
			log(driver.getTitle());
			sspReservations.verifyPageTitle(data.get("PageTitle_Reservations_Page"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"User not navigated to Reservations page");
			
			sspReservations.clickonViewLink();
			
			Thread.sleep(5000);
			sspHomePage.SelectLocale();
	        Thread.sleep(5000);
			
			log(driver.getTitle());
			sspReservations.verifyPageTitle(data.get("PageTitle_Reservations_Page"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"User not navigated to Reservations page");
			
			status=sspReservations.verifySingleProduct_HeaderAndLabel_AfterClickOnViewReservation(data.get("From"),data.get("To"),data.get("ReservationCode"),data.get("CancelationAndContract_Link"),data.get("Details_Link"),data.get("ParkerHeaderText"),data.get("ParkerSubHeader"),data.get("AddedParkerName"),data.get("AddedParkerEmail"),data.get("IdentificationHeader"),data.get("AddedIdentificationCardName"),data.get("IdentificationID_valueText"),data.get("Identification_CardNumber"),data.get("Resend_ConfirmationMailLink"),data.get("CancelReservationLink"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in Reservation Page Label And Header After Click On View Reservation");
			
			status=sspReservations.verifyQRCodeGenerated();
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"QR code is not displayed");
			
			//End of Test Case
			log("====Ended " + testName + " Testcase====");


		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
