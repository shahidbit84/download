/**
 *
 */
package com.skidata.ssp.portal.myparkers;

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

public class TC_0010_CP_MyParkersPg_Verify_Error_Message_For_Invalid_Email extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0010_CP_MyParkersPg_Verify_Error_Message_For_Invalid_Email.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0010_CP_MyParkersPg_Verify_Error_Message_For_Invalid_Email";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=1210,dataProvider = "getDataForTestCaseName", testName = "TC_0010_CP_MyParkersPg_Verify_Error_Message_For_Invalid_Email", description ="TC_0010_CP_MyParkersPg_Verify_Error_Message_For_Invalid_Email")
	public void ssp_TC_0010_CP_MyParkersPg_Verify_Error_Message_For_Invalid_Email(Hashtable<String, String> data)throws Throwable {

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
		    
		    SspMyParkersPage myParkersPage = new SspMyParkersPage(driver, test);
		    
		    status=myParkersPage.verifyPageTitle(data.get("PageTitle_MyParkersPage"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of My parkers");
		    
		    myParkersPage.clickOnAddPerson();
		    
		    myParkersPage.EnterParkerDetails(data.get("ParkerName"), data.get("ParkerEmail"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Parker Name and Email Entered");
		    
		    status=myParkersPage.Verify_Parker_Email_Error_Message(data.get("ParkerEmailErrorMassage"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Email Error Message Displayed Successfully");
		    
		    
		    
			
			
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
