/**
 *
 */
package com.skidata.ssp.portal.loginandsecurity;

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

public class TC_0008_CP_LoginAndSecurity_Verify_Unregistered extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0008_CP_LoginAndSecurity_Verify_Unregistered.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0008_CP_LoginAndSecurity_Verify_Unregistered";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=902,dataProvider = "getDataForTestCaseName", testName = "TC_0008_CP_LoginAndSecurity_Verify_Unregistered", description ="TC_0008_CP_LoginAndSecurity_Verify_Unregistered")
	public void ssp_TC_0008_CP_LoginAndSecurity_Verify_Unregistered(Hashtable<String, String> data)throws Throwable {

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
		    
		    SspLoginAndSecurityPage loginAndSecurityPage = new SspLoginAndSecurityPage(driver, test);
		    
		    status=loginAndSecurityPage.verifyPageTitle(data.get("PageTitle_LoginAndSecurityPage"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of Login and security");
		    
		    status=loginAndSecurityPage.Unregisteredlink_LoginAndSecurityPg(data.get("Unregistered_Link"));
		    Assert.assertEquals(status, data.get("ExpectedValuePASS"),"Mismatch in unregistered link in login & security page");
		    
		    
		    status=loginAndSecurityPage.unregistered_Popup(data.get("UnregisteredPopup"));
		    Assert.assertEquals(status, data.get("ExpectedValuePASS"), "Mismatch in the unregistered popup message");
		    		    
		    loginAndSecurityPage.ClickOnAll_Buttons_On_Unregistered_Popup();
		    
		    status=sspHomePage.verifyPageTitle(data.get("PageTitle_PortalHomePage"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in Page Title");
		    
		 
		    
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
