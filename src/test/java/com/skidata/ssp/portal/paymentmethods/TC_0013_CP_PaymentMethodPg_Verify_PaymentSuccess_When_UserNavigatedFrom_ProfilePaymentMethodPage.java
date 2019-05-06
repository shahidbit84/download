/**
 *
 */
package com.skidata.ssp.portal.paymentmethods;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspBookingConfirmationPage;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.uiPages.portal.SspLoginPage;
import com.skidata.uiPages.portal.SspPspPage;
import com.skidata.uiPages.portal.SspSignUpPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author naan
 * 
 * 
 */

public class TC_0013_CP_PaymentMethodPg_Verify_PaymentSuccess_When_UserNavigatedFrom_ProfilePaymentMethodPage extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0013_CP_PaymentMethodPg_Verify_PaymentSuccess_When_UserNavigatedFrom_ProfilePaymentMethodPage.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0013_CP_PaymentMethodPg_Verify_PaymentSuccess_When_UserNavigatedFrom_ProfilePaymentMethodPage";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=1313,dataProvider = "getDataForTestCaseName", testName = "TC_0013_CP_PaymentMethodPg_Verify_PaymentSuccess_When_UserNavigatedFrom_ProfilePaymentMethodPage", description ="TC_0013_CP_PaymentMethodPg_Verify_PaymentSuccess_When_UserNavigatedFrom_ProfilePaymentMethodPage")
	public void ssp_TC_0013_CP_PaymentMethodPg_Verify_PaymentSuccess_When_UserNavigatedFrom_ProfilePaymentMethodPage(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);
			
			SspHomePage sspHomePage = new SspHomePage(driver, test);
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
		    sspHomePage.clickOnProfileLink();
		    
		    driver.getTitle();
		    
		    status=sspLoginPage.verifyPageTitle(data.get("PageTitle_ProfilePage"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of profile Page");
		    
			SspPspPage SspPspPages=new SspPspPage(driver, test);
			SspPspPages.clickOnlink_paymentmethod();
			
			status=SspPspPages.verifyPageTitle(data.get("PageTitle_Paymentmethod"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of payment method Page");
			
			status=SspPspPages.verifyPageHeaderAndLabel(data.get("PaymentMethodsHeader"),data.get("AddMethodsHeader"),data.get("PaymentMethod_HeaderMessage"),data.get("PaymentMethod_SubHeaderMessage"),data.get("AddPaymentMethod_Button"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page header and label in payment method Page");
		    
			status=SspPspPages.verifyImageDisplayed(data.get("PaymentMethodImage"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the image in payment method Page");
			
			SspPspPages.clickOnAddPaymentButtonLink();
			
			status=SspPspPages.verifyPageTitle(data.get("PageTitle_PaymentPage"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of payment method Page");
			
			SspPspPages.clickonCreditcardMaestroSecureCodePayment();
			SspPspPages.EnterCreditcardMaestroSecureCodeUserDetails(data.get("CardHolderName"),data.get("CardHolderNumber")
					,data.get("CardExpMonth"),data.get("CardExpYear"),data.get("CardCVV"));

			SspBookingConfirmationPage sspBookingConfirmationPage = new SspBookingConfirmationPage(driver, test);
			Thread.sleep(35000);
			status=sspBookingConfirmationPage.verifyPageTitle(data.get("PageTitle_BookingConfirmation"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Reservation Failed, User in CheckoutPage");
			
			log(driver.getTitle());

			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
