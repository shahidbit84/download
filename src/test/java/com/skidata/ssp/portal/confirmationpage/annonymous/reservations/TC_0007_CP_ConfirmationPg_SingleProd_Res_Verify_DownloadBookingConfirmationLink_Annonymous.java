/**
 *
 */
package com.skidata.ssp.portal.confirmationpage.annonymous.reservations;

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

public class TC_0007_CP_ConfirmationPg_SingleProd_Res_Verify_DownloadBookingConfirmationLink_Annonymous extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0007_CP_ConfirmationPg_SingleProd_Res_Verify_DownloadBookingConfirmationLink_Annonymous.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0007_CP_ConfirmationPg_SingleProd_Res_Verify_DownloadBookingConfirmationLink_Annonymous";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=607,dataProvider = "getDataForTestCaseName", testName = "TC_0007_CP_ConfirmationPg_SingleProd_Res_Verify_DownloadBookingConfirmationLink_Annonymous", description ="TC_0007_CP_ConfirmationPg_SingleProd_Res_Verify_DownloadBookingConfirmationLink_Annonymous")
	public void ssp_TC_0007_CP_ConfirmationPg_SingleProd_Res_Verify_DownloadBookingConfirmationLink_Annonymous(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);

			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			DateAndUniqueNoGenerateHelper dateAndUniqueNoGenerateHelper = new DateAndUniqueNoGenerateHelper();
			String endDate=dateAndUniqueNoGenerateHelper.get_PreviousDate_OrFutureDate("MM/dd/yyyy",data.get("AddOrMinusDate"));

//			sspHomePage.clickonLogin();
//			SspLoginPage sspLoginPage = new SspLoginPage(driver, test);
//
//		    SspSignUpPage sspSignUpPage = new SspSignUpPage(driver, test);
//		    sspLoginPage.clickOnSignUp();
//		    
//		    String UniqueEmailId=sspSignUpPage.emailCreation();
//		    sspSignUpPage.EnterSignUpDetails(data.get("salutation"),data.get("Fname"),
//					data.get("Lname"),UniqueEmailId,data.get("Password"),data.get("ConfirmPassword"));
//			
//			status=sspSignUpPage.VerifySignUpSuccessfulMessage(data.get("SignUpSuccessfullMessage"));
//		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"SignUp not Success");
//		    
//		    sspLoginPage.login(UniqueEmailId,data.get("Password"));  
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
			
			SspSignUpPage sspSignUpPage = new SspSignUpPage(driver, test);
			String UniqueEmailId=sspSignUpPage.emailCreation();
			sspCheckoutPage.enterEmailId(UniqueEmailId);
			
			sspCheckoutPage.clickonAddAddress_Optionally();
			sspCheckoutPage.enterPrivatePersonDetails(data.get("PrivatePerson_Name"),data.get("PrivatePerson_Country"),data.get("PrivatePerson_Address"),data.get("PrivatePerson_Phone"));
			
			sspCheckoutPage.addIdentificationDetails_SingleProduct(data.get("Identification1"));

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

			status=sspBookingConfirmationPage.verifyBookingConfirmationEmailMsg_WalletImage(data.get("BookingConfirmationEmailMessagetext"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in email booking confirmation message or wallet images not displayed");
			
			status=sspBookingConfirmationPage.verifyDownloadBookingConfirmationLink(data.get("DownloadBookingConfirmation"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Download booking confirmation link text mismatch");
			
			//End of Test Case
			log("====Ended " + testName + " Testcase====");


		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
