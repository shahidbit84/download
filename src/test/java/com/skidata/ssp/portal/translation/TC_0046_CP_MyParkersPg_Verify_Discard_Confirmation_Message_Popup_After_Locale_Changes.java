/**
 *
 */
package com.skidata.ssp.portal.translation;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspDashboardPage;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.uiPages.portal.SspLoginPage;
import com.skidata.uiPages.portal.SspMyParkersPage;
import com.skidata.uiPages.portal.SspSignUpPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author naan
 * 
 * 
 */

public class TC_0046_CP_MyParkersPg_Verify_Discard_Confirmation_Message_Popup_After_Locale_Changes extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0046_CP_MyParkersPg_Verify_Discard_Confirmation_Message_Popup_After_Locale_Changes.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0046_CP_MyParkersPg_Verify_Discard_Confirmation_Message_Popup_After_Locale_Changes";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=1212,dataProvider = "getDataForTestCaseName", testName = "TC_0046_CP_MyParkersPg_Verify_Discard_Confirmation_Message_Popup_After_Locale_Changes", description ="TC_0046_CP_MyParkersPg_Verify_Discard_Confirmation_Message_Popup_After_Locale_Changes")
	public void ssp_TC_0046_CP_MyParkersPg_Verify_Discard_Confirmation_Message_Popup_After_Locale_Changes(Hashtable<String, String> data)throws Throwable {

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
		    
		    status=sspLoginPage.verifyPageTitle(data.get("PageTitle_DashboardPage"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of DashboardPage");
		    
		    SspDashboardPage dashBoardPage = new SspDashboardPage(driver, test);
		    dashBoardPage.clickOnlink_Ids_parkers();
		    
		    sspHomePage.SelectLocale();
		 	Thread.sleep(5000);
		    
		    SspMyParkersPage myParkersPage = new SspMyParkersPage(driver, test);
		    
		    status=myParkersPage.verifyPageTitle(data.get("PageTitle_MyParkersPage"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of My parkers");
		    
		    myParkersPage.clickOnAddPerson();
		    
		    myParkersPage.EnterParkerDetails(data.get("ParkerName"), data.get("ParkerEmail"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Parker Name and Email Entered");
		    
		    sspHomePage.clickOnProfileLink();
		    
		    status=myParkersPage.verify_Discard_ConfirmationMessage(data.get("DiscardConfirmation"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Discard Confirmation");
		    
		    myParkersPage.clickOn_X_DeleteConfirmationPopUp();
		    
		    Thread.sleep(1000);
		    sspHomePage.clickOnProfileLink();
		    
		    status=myParkersPage.verify_Discard_ConfirmationMessage(data.get("DiscardConfirmation"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Discard Confirmation");
		    
		    myParkersPage.clickOnNoDiscardConfirmationPopUp_();
		    
		    Thread.sleep(1000);
		    sspHomePage.clickOnProfileLink();
		    
		    status=myParkersPage.verify_Discard_ConfirmationMessage(data.get("DiscardConfirmation"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Discard Confirmation");
		    
		    myParkersPage.clickOnYesDiscardConfirmationPopUp_();
		    
		    status=sspLoginPage.verifyPageTitle(data.get("PageTitle_DashboardPage"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of DashboardPage");
		    
		    
		    
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
