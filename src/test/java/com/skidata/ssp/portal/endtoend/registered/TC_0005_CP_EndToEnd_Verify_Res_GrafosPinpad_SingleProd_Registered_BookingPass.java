/**
 *
 */
package com.skidata.ssp.portal.endtoend.registered;

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
import com.skidata.uiPages.chbackoffice.BookingOverViewPage;
import com.skidata.uiPages.chbackoffice.ChBackOfficePortalPage;
import com.skidata.uiPages.chbackoffice.LoginPageChbackOfficePage;
import com.skidata.uiPages.portal.SspBookingConfirmationPage;
import com.skidata.uiPages.portal.SspCheckoutPage;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.uiPages.portal.SspLoginPage;
import com.skidata.uiPages.portal.SspProductsListPage;
import com.skidata.uiPages.portal.SspPspPage;
import com.skidata.uiPages.portal.SspShoppingCartPage;
import com.skidata.uiPages.portal.SspSignUpPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author naan
 * 
 * 
 */

public class TC_0005_CP_EndToEnd_Verify_Res_GrafosPinpad_SingleProd_Registered_BookingPass extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0005_CP_EndToEnd_Verify_Res_GrafosPinpad_SingleProd_Registered_BookingPass.class.getName());

	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0005_CP_EndToEnd_Verify_Res_GrafosPinpad_SingleProd_Registered_BookingPass";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=408,dataProvider = "getDataForTestCaseName", testName = "TC_0005_CP_EndToEnd_Verify_Res_GrafosPinpad_SingleProd_Registered_BookingPass", description ="TC_0005_CP_EndToEnd_Verify_Res_GrafosPinpad_SingleProd_Registered_BookingPass")
	public void ssp_TC_0005_CP_EndToEnd_Verify_Res_GrafosPinpad_SingleProd_Registered_BookingPass(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);

			SspHomePage sspHomePage = new SspHomePage(driver,test);
			sspHomePage.clickOnGotIt();
			
			sspHomePage.clickonLogin();
		     
			SspLoginPage sspLoginPage = new SspLoginPage(driver, test);
			sspLoginPage.clickOnSignUp();
			
			SspSignUpPage sspSignUpPage = new SspSignUpPage(driver, test);
			
			
			String UniqueEmailId=sspSignUpPage.emailCreationNew();
			sspSignUpPage.EnterSignUpDetails(data.get("salutation"),data.get("Fname"),
					data.get("Lname"),UniqueEmailId+"@harakirimail.com",data.get("Password"),data.get("ConfirmPassword"));
			
			sspSignUpPage.clickOnSignUp();
		    sspLoginPage.Verifysignup(UniqueEmailId);
		    
            Thread.sleep(3000);
		    sspLoginPage.login(UniqueEmailId+"@harakirimail.com",data.get("Password"));
			
			DateAndUniqueNoGenerateHelper dateAndUniqueNoGenerateHelper = new DateAndUniqueNoGenerateHelper();
			String endDate=dateAndUniqueNoGenerateHelper.get_PreviousDate_OrFutureDate("MM/dd/yyyy",data.get("AddOrMinusDate"));

			sspHomePage.searchParkingLocationsAndSelect(data.get("EnterLocationNameToSearch"),data.get("SelectLocationAddress"));
			sspHomePage.select_ProductSearchStartDate_InFromCalendar_Reservation();
			sspHomePage.select_ProductSearchEndDate_InToCalendar_Reservation(endDate);
			sspHomePage.clickOnSearchYourParkingButton();
			
			
			SspProductsListPage sspProductsListPage = new SspProductsListPage(driver,test);
			status= sspProductsListPage.verifyProductListDisplayedForDefaultLocation_InListView();
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Products are not displayed in the List view");
			sspProductsListPage.addSingleProduct_IntoCart_Reservation_ListView();
			sspProductsListPage.clickOnShoppingCartIcon();

			SspShoppingCartPage sspShoppingCartPage = new SspShoppingCartPage(driver,test);
			sspShoppingCartPage.clickonCheckout();
			
			SspCheckoutPage sspCheckoutPage = new SspCheckoutPage(driver,test);
			
			status=sspCheckoutPage.verifyPageTitle(data.get("PageTitle_Checkout"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of Checkout page");
//			SspSignUpPage sspSignUpPage = new SspSignUpPage(driver, test);
//			String UniqueEmailId=sspSignUpPage.emailCreation();
//			sspCheckoutPage.enterEmailId(UniqueEmailId);
			sspCheckoutPage.addIdentificationDetails_SingleProduct(data.get("Identification1"));

			sspCheckoutPage.clickon_TermsAndCondition_And_PrivacyPolicy_Checkbox();
			sspCheckoutPage.clickOnPay();
			
			SspPspPage SspPspPages=new SspPspPage(driver, test);
			Thread.sleep(15000);
			
			log(driver.getTitle());
			
			
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

				
				SspPspPages.enterPaymentDetailsNewPage(paymentPageType,data.get("CardHolderName"),data.get("CardHolderNumber"),data.get("CardExpMonth"),data.get("CardExpYear"),data.get("CardCVV"));

			}

		
			SspBookingConfirmationPage sspBookingConfirmationPage = new SspBookingConfirmationPage(driver,test);
			
			status=sspBookingConfirmationPage.verifyPageTitle(data.get("PageTitle_BookingConfirmation"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Reservation Failed, User in CheckoutPage");
			
            Thread.sleep(5000);
			
			String firstProdPurchasedName = sspBookingConfirmationPage.getFirstProductNameFromConfirmationPage();
			String firstProdPurchasedstartDate = sspBookingConfirmationPage.getFirstProductStartDateAndTime();
			String firstProdPurchasedendDate = sspBookingConfirmationPage.getFirstProductEndDateAndTime();
			
			
			
			String  bookingID = sspBookingConfirmationPage.getBookingID();
			log("Booking ID is - "+ bookingID);
			
			//Launch Ch backoffice to verify the booking is success
			driver.navigate().to(chBackofficeURL);
			
			Thread.sleep(5000);
			
			
//			LoginPageChbackOfficePage loginPageChBackOffice = new LoginPageChbackOfficePage(driver,test);
//			loginPageChBackOffice.loginToApplication(chBackofficeLoginID, chBackofficeLoginPassword);
			LoginPageChbackOfficePage loginPageChBackOffice = new LoginPageChbackOfficePage(driver,test);
			loginPageChBackOffice.loginToApplication(adminTenant,chBackofficeLoginID, chBackofficeLoginPassword);
			
			ChBackOfficePortalPage portalpage = new ChBackOfficePortalPage(driver,test);
			portalpage.clickOnAppLauncher();
			log("App Launcher is clicked");
			
			//Open the bookings app
			portalpage.searchAppNameAndClick(data.get("BookingsApp"));
			//portalpage.switchToiframe(0);
			
			BookingOverViewPage bookingOverViewPage = new BookingOverViewPage(driver,test);
			bookingOverViewPage.selectTenant(tenantName);
			
			//Verify if the booking is successful or Confirmed
			bookingOverViewPage.searchBooking_byNumber(bookingID);
			
			
			status=bookingOverViewPage.verifyBookingStatusSingleProd(bookingID, firstProdPurchasedName, firstProdPurchasedstartDate, firstProdPurchasedendDate,data.get("TypeOfBooking"), data.get("ExpectedBookingStatus"));
	
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Booking status in chbackoffice");


			
			//End of Test Case 
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
