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
import com.skidata.uiPages.portal.SspLoginAndSecurityPage;
import com.skidata.uiPages.portal.SspLoginPage;
import com.skidata.uiPages.portal.SspSignUpPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author naan
 * 
 * 
 */

public class TC_0029_CP_LoginAndSecurity_Pg_Verify_NameUpdate_ProfileUpdateSuccessMsg_After_Locale_Changes extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0029_CP_LoginAndSecurity_Pg_Verify_NameUpdate_ProfileUpdateSuccessMsg_After_Locale_Changes.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0029_CP_LoginAndSecurity_Pg_Verify_NameUpdate_ProfileUpdateSuccessMsg_After_Locale_Changes";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=903,dataProvider = "getDataForTestCaseName", testName = "TC_0029_CP_LoginAndSecurity_Pg_Verify_NameUpdate_ProfileUpdateSuccessMsg_After_Locale_Changes", description ="TC_0029_CP_LoginAndSecurity_Pg_Verify_NameUpdate_ProfileUpdateSuccessMsg_After_Locale_Changes")
	public void ssp_TC_0029_CP_LoginAndSecurity_Pg_Verify_NameUpdate_ProfileUpdateSuccessMsg_After_Locale_Changes(Hashtable<String, String> data)throws Throwable {

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
		    dashBoardPage.clickOnLoginAndSecurity();
		    
		    sspHomePage.SelectLocale();
			Thread.sleep(5000);
		    
		    SspLoginAndSecurityPage loginAndSecurityPage = new SspLoginAndSecurityPage(driver, test);
	
		    
		    loginAndSecurityPage.updateUserFirstName(data.get("UpdateFirstName"));
		    loginAndSecurityPage.updateUserLastName(data.get("UpdateLastName"));
		    loginAndSecurityPage.clickOnUpdate();
		    
		    status = loginAndSecurityPage.verifyUpdationSuccessMsg(data.get("UserUpdationSuccessMessage"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the User Updatio message");
		    
		    
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
