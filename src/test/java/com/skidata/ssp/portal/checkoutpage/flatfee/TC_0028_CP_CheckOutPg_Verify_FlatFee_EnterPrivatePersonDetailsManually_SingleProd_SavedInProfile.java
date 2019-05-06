/**
 *
 */
package com.skidata.ssp.portal.checkoutpage.flatfee;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skidata.helperclasses.WaitHelper;
import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspAddressesPage;
import com.skidata.uiPages.portal.SspBookingConfirmationPage;
import com.skidata.uiPages.portal.SspCheckoutPage;
import com.skidata.uiPages.portal.SspDashboardPage;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.uiPages.portal.SspLoginPage;
import com.skidata.uiPages.portal.SspProductsListPage;
import com.skidata.uiPages.portal.SspPspPage;
import com.skidata.uiPages.portal.SspSignUpPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author shmo
 * 
 * 
 */

public class TC_0028_CP_CheckOutPg_Verify_FlatFee_EnterPrivatePersonDetailsManually_SingleProd_SavedInProfile extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0028_CP_CheckOutPg_Verify_FlatFee_EnterPrivatePersonDetailsManually_SingleProd_SavedInProfile.class.getName());

	public String status=null;
	DataUtil dataUtil = new DataUtil();
	WaitHelper wh;

	String testName = "TC_0028_CP_CheckOutPg_Verify_FlatFee_EnterPrivatePersonDetailsManually_SingleProd_SavedInProfile";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=435,dataProvider = "getDataForTestCaseName", testName = "TC_0028_CP_CheckOutPg_Verify_FlatFee_EnterPrivatePersonDetailsManually_SingleProd_SavedInProfile", description ="TC_0028_CP_CheckOutPg_Verify_FlatFee_EnterPrivatePersonDetailsManually_SingleProd_SavedInProfile")
	public void ssp_TC_0028_CP_CheckOutPg_Verify_FlatFee_EnterPrivatePersonDetailsManually_SingleProd_SavedInProfile(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			sspHomePage.searchParkingLocationsAndSelect(data.get("EnterLocationNameToSearch"),data.get("SelectLocationAddress"));
			sspHomePage.clickOnSubscription();
			sspHomePage.select_ProductSearchStartDate_InFromCalendar_Subscription();
			sspHomePage.clickOnSearchYourParkingButton();

			SspProductsListPage sspProductsListPage = new SspProductsListPage(driver, test);
			status=sspProductsListPage.verifyPageTitle(data.get("PageTitle_SSPProducts"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of SSP Products page");



			status= sspProductsListPage.verifyProductListDisplayedForDefaultLocation_InListView();
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Products are not displayed in the List view");

			sspProductsListPage.subscribeSingleFlatFee(data.get("FlatFeeType"));

			SspLoginPage sspLoginPage = new SspLoginPage(driver, test);

			status=sspLoginPage.verifyPageTitle(data.get("PageTitle_LoginPage"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title Login page");

			SspSignUpPage sspSignUpPage = new SspSignUpPage(driver,test);
			sspLoginPage.clickOnSignUp();

			String UniqueEmailId=sspSignUpPage.emailCreationNew();
			sspSignUpPage.EnterSignUpDetails(data.get("salutation"),data.get("Fname"),
					data.get("Lname"),UniqueEmailId+"@harakirimail.com",data.get("Password"),data.get("ConfirmPassword"));
			
			sspSignUpPage.clickOnSignUp();
		    sspLoginPage.Verifysignup(UniqueEmailId);
		    
            Thread.sleep(3000);
		    sspLoginPage.login(UniqueEmailId+"@harakirimail.com",data.get("Password"));


			SspCheckoutPage sspCheckoutPage = new SspCheckoutPage(driver,test);

			status=sspCheckoutPage.verifyPageTitle(data.get("PageTitle_Checkout"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of Checkout page");
			sspCheckoutPage.clickonAddAddress_Optionally();
			sspCheckoutPage.enterPrivatePersonAddressComplete(data.get("PrivatePerson_Name"),data.get("PrivatePerson_Country"),data.get("PrivatePerson_Address"),data.get("PrivatePerson_Phone"),
					data.get("PrivatePerson_AddLine1"),data.get("PrivatePerson_AddLine2"),
					data.get("PrivatePerson_Town"),data.get("PrivatePerson_State"),data.get("PrivatePerson_PostCode"));
			sspCheckoutPage.clickonAddToMyAddress();
			
			sspCheckoutPage.addIdentificationDetails_SingleProduct(data.get("Identification1"));
			
			sspCheckoutPage.clickon_TermsAndCondition_And_PrivacyPolicy_Checkbox();

			sspCheckoutPage.clickOnPay();
			
			sspCheckoutPage.clickOnPay_InPopUpConfirmation();

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
			sspProductsListPage.clickOnProfileLink();
			
			SspDashboardPage dashBoardPage = new SspDashboardPage(driver, test);
		    dashBoardPage.clickOnAddresses();
		    
		    SspAddressesPage sspAddressPage = new SspAddressesPage(driver, test);
		    sspAddressPage.verifySavedBillingAddresses_PrivatePerson(data.get("PrivatePerson_Name"), data.get("PrivatePerson_Phone"), data.get("PrivatePerson_AddLine1"), data.get("PrivatePerson_AddLine2"), data.get("PrivatePerson_Town"), data.get("PrivatePerson_State"),data.get("PrivatePerson_PostCode"), data.get("PrivatePerson_Country"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Address not added/Saved correctly to user profile from the checkout page");


			//End of Test Case 
			log("====Ended " + testName + " Testcase====");



		}	
		catch(Throwable e) {
			HandlingErrorOrException(e);
		}
	}

}
