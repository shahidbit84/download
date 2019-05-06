/**
 *
 */
package com.skidata.ssp.portal.loginpage;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skidata.helperclasses.DateAndUniqueNoGenerateHelper;
import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.uiPages.portal.SspLoginPage;
import com.skidata.uiPages.portal.SspProductsListPage;
import com.skidata.uiPages.portal.SspShoppingCartPage;
import com.skidata.uiPages.portal.SspSignUpPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author shmo
 * 
 * 
 */

public class TC_0006_CP_LoginPg_Verify_InEmptyShoppingCart_Login_AndVerifyProfilePage extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0006_CP_LoginPg_Verify_InEmptyShoppingCart_Login_AndVerifyProfilePage.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0006_CP_LoginPg_Verify_InEmptyShoppingCart_Login_AndVerifyProfilePage";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=1006,dataProvider = "getDataForTestCaseName", testName = "TC_0006_CP_LoginPg_Verify_InEmptyShoppingCart_Login_AndVerifyProfilePage", description ="TC_0006_CP_LoginPg_Verify_InEmptyShoppingCart_Login_AndVerifyProfilePage")
	public void ssp_TC_0006_CP_LoginPg_Verify_InEmptyShoppingCart_Login_AndVerifyProfilePage(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			DateAndUniqueNoGenerateHelper dateAndUniqueNoGenerateHelper = new DateAndUniqueNoGenerateHelper();
			String endDate=dateAndUniqueNoGenerateHelper.get_PreviousDate_OrFutureDate("MM/dd/yyyy",data.get("AddOrMinusDate"));

			sspHomePage.select_ProductSearchStartDate_InFromCalendar_Reservation();
			sspHomePage.select_ProductSearchEndDate_InToCalendar_Reservation(endDate);
			sspHomePage.clickOnSearchYourParkingButton_Homepage();

			SspProductsListPage sspProductsListPage = new SspProductsListPage(driver, test);

			sspProductsListPage.clickOnShoppingCartIcon();

			SspShoppingCartPage sspShoppingCartPage = new SspShoppingCartPage(driver, test);
//			status=sspShoppingCartPage.verifyDefaultEmptyCart_Message(data.get("EmptyCartMsg1"), data.get("EmptyCartMsg2ForUser"));
//			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Empty cart message");

			status=sspShoppingCartPage.verifyPage_EmptyCart_HeaderAndLabel(data.get("PageHeader"),data.get("PageSubHeader"),data.get("ContinueButton"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Empty cart message");
			
//			sspShoppingCartPage.clickOnLoginLinkInMessage();

			sspShoppingCartPage.clickonContinueShooping();
		       
			status=sspProductsListPage.verifyPageTitle(data.get("PageTitle_SSPProducts"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of SSP Products page");
		    
		    sspHomePage.clickonLogin();
			
		    SspLoginPage sspLoginPage = new SspLoginPage(driver, test);
		    
		   // sspLoginPage.login(data.get("Email"),data.get("Password"));  
		    
            SspSignUpPage sspSignUpPage = new SspSignUpPage(driver, test);
			
        	sspSignUpPage.clickonSingUpInLogInPage();
            
        	String UniqueEmailId=sspSignUpPage.emailCreationNew();
			sspSignUpPage.EnterSignUpDetails(data.get("salutation"),data.get("Fname"),
					data.get("Lname"),UniqueEmailId+"@harakirimail.com",data.get("Password"),data.get("ConfirmPassword"));
			
			sspSignUpPage.clickOnSignUp();
		    sspLoginPage.Verifysignup(UniqueEmailId);
		    
            Thread.sleep(3000);
		    sspLoginPage.login(UniqueEmailId+"@harakirimail.com",data.get("Password"));  
			//sspLoginPage.clickonLogInButton();
		    
		    sspHomePage.clickOnProfileLink();
		    
		    status=sspLoginPage.verifyPageTitle(data.get("PageTitle_ProfilePage"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of Cart Page");
		    
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
