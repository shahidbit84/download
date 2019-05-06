/**
 *
 */
package com.skidata.ssp.portal.checkoutpage.registered;

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
import com.skidata.uiPages.portal.SspShoppingCartPage;
import com.skidata.uiPages.portal.SspSignUpPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author naan
 * 
 * 
 */

public class TC_0034_CP_CheckOutPg_Verify_Res_ParkerSaved_in_IamNotTheParkerDetails_AfterSuccessBooking_SingleProd_Registered extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0034_CP_CheckOutPg_Verify_Res_ParkerSaved_in_IamNotTheParkerDetails_AfterSuccessBooking_SingleProd_Registered.class.getName());

	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0034_CP_CheckOutPg_Verify_Res_ParkerSaved_in_IamNotTheParkerDetails_AfterSuccessBooking_SingleProd_Registered";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=439,dataProvider = "getDataForTestCaseName", testName = "TC_0034_CP_CheckOutPg_Verify_Res_ParkerSaved_in_IamNotTheParkerDetails_AfterSuccessBooking_SingleProd_Registered", description ="TC_0034_CP_CheckOutPg_Verify_Res_ParkerSaved_in_IamNotTheParkerDetails_AfterSuccessBooking_SingleProd_Registered")
	public void ssp_TC_0034_CP_CheckOutPg_Verify_Res_ParkerSaved_in_IamNotTheParkerDetails_AfterSuccessBooking_SingleProd_Registered(Hashtable<String, String> data)throws Throwable {

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
			
			status=sspCheckoutPage.verifyIamNotTheParker_text(data.get("IamNotheParkerMessage"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"I am not the parker Text displayed successfully in checkout page");
			
			sspCheckoutPage.clickonIamNotTheParker();
			
			//status=sspCheckoutPage.verifySelectParker_text(data.get("SelectParkerText"));
			
			sspCheckoutPage.verifyAvailbleParkersFieldsIn_IamNotTheParkerDetailsForm(data.get("ParkerName_field"), data.get("ParkerEmail_field"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"), "Mismatch in the text fields for enter i am not the parker details");
			
			String ParkerUniqueEmailId=sspCheckoutPage.emailCreation();
			
			sspCheckoutPage.EnterIamNotTheParkerDetails(data.get("ParkerName"),ParkerUniqueEmailId);
			Assert.assertEquals(status,data.get("ExpectedValuePASS"), "I am not the parker details entered");
			
			sspCheckoutPage.addIdentificationDetails_AfterAdding_Parker(data.get("Identificationtype"), data.get("IdentificationValue"));
			
			//sspCheckoutPage.addIdentificationDetails_SingleProduct(data.get("Identification1"));
			
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

			
			SspBookingConfirmationPage sspBookingConfirmationPage = new SspBookingConfirmationPage(driver,test);
			status=sspBookingConfirmationPage.verifyPageTitle(data.get("PageTitle_BookingConfirmation"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Reservation Failed, User in CheckoutPage");
			
			sspBookingConfirmationPage.clickonContinueShoppingLink();
			
			status= sspProductsListPage.verifyProductListDisplayedForDefaultLocation_InListView();
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Products are not displayed in the List view");
			
			sspProductsListPage.addSingleProduct_IntoCart_Reservation_ListView();
			sspProductsListPage.clickOnShoppingCartIcon();
			sspShoppingCartPage.clickonCheckout();
			
			status=sspCheckoutPage.verifyPageTitle(data.get("PageTitle_Checkout"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of Checkout page");
			
			sspCheckoutPage.clickonIamNotTheParker();
			
			status=sspCheckoutPage.verify_SavedParkerDetails(data.get("SavedParkerName"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Saved Parker details in the dropdown");

			//End of Test Case 
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
