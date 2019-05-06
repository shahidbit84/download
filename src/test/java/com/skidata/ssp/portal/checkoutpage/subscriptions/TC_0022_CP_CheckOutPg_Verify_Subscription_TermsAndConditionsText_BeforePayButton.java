/**
 *
 */
package com.skidata.ssp.portal.checkoutpage.subscriptions;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspCheckoutPage;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.uiPages.portal.SspLoginPage;
import com.skidata.uiPages.portal.SspProductsListPage;
import com.skidata.uiPages.portal.SspSignUpPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author shmo
 * 
 * 
 */

public class TC_0022_CP_CheckOutPg_Verify_Subscription_TermsAndConditionsText_BeforePayButton extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0022_CP_CheckOutPg_Verify_Subscription_TermsAndConditionsText_BeforePayButton.class.getName());

	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0022_CP_CheckOutPg_Verify_Subscription_TermsAndConditionsText_BeforePayButton";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=426,dataProvider = "getDataForTestCaseName", testName = "TC_0022_CP_CheckOutPg_Verify_Subscription_TermsAndConditionsText_BeforePayButton", description ="TC_0022_CP_CheckOutPg_Verify_Subscription_TermsAndConditionsText_BeforePayButton")
	public void ssp_TC_0022_CP_CheckOutPg_Verify_Subscription_TermsAndConditionsText_BeforePayButton(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver,test);
			sspHomePage.clickOnGotIt();
			sspHomePage.clickOnSubscription();
			sspHomePage.searchParkingLocationsAndSelect(data.get("EnterLocationNameToSearch"),data.get("SelectLocationAddress"));
			sspHomePage.select_ProductSearchStartDate_InFromCalendar_Subscription();
			sspHomePage.clickOnSearchYourParkingButton();

			SspProductsListPage sspProductsListPage = new SspProductsListPage(driver,test);
	        status=sspProductsListPage.verifyPageTitle(data.get("PageTitle_SSPProducts"));
	        Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of SSP Products page");
			
	        
	        
	        status= sspProductsListPage.verifyProductListDisplayedForDefaultLocation_InListView();
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Products are not displayed in the List view");
	  
			sspProductsListPage.addFirstSubscriptionDisplayed();
	        
			SspLoginPage sspLoginPage = new SspLoginPage(driver,test);

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
		   
//			status=sspCheckoutPage.verifyTermsAndConditionsBeforePay(data.get("TermsAndConditions"));
//			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Terms And Conditions above pay button");
			
			status=sspCheckoutPage.verifyTermsAndConditions_And_PrivacyPolicy(data.get("IagreeTermsAndCondition"), data.get("TermsAndConditions"), data.get("IagreePrivacypolicy"),data.get("PrivacyPolicy"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Terms And Conditions above pay button");

			
			//End of Test Case 
			log("====Ended " + testName + " Testcase====");
		}
		
		
		
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
