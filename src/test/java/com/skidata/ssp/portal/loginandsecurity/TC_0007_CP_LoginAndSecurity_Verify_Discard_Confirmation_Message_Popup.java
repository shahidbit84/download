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

public class TC_0007_CP_LoginAndSecurity_Verify_Discard_Confirmation_Message_Popup extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0007_CP_LoginAndSecurity_Verify_Discard_Confirmation_Message_Popup.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0007_CP_LoginAndSecurity_Verify_Discard_Confirmation_Message_Popup";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=907,dataProvider = "getDataForTestCaseName", testName = "TC_0007_CP_LoginAndSecurity_Verify_Discard_Confirmation_Message_Popup", description ="TC_0007_CP_LoginAndSecurity_Verify_Discard_Confirmation_Message_Popup")
	public void ssp_TC_0007_CP_LoginAndSecurity_Verify_Discard_Confirmation_Message_Popup(Hashtable<String, String> data)throws Throwable {

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
	
		    
		    loginAndSecurityPage.updateUserPhone(data.get("UpdatePhone"));
		    
		    Thread.sleep(1000);
		    sspHomePage.clickOnProfileLink();
		    
		    status=loginAndSecurityPage.verify_Discard_ConfirmationMessage(data.get("DiscardConfirmation"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Discard Confirmation");
		    
		    loginAndSecurityPage.clickOn_X_DiscardConfirmationPopUp();
		    
		    Thread.sleep(1000);
		    sspHomePage.clickOnProfileLink();
		    
		    status=loginAndSecurityPage.verify_Discard_ConfirmationMessage(data.get("DiscardConfirmation"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Discard Confirmation");
		    
		    loginAndSecurityPage.clickOnNoDiscardConfirmationPopUp();
		    
		    Thread.sleep(1000);
		    sspHomePage.clickOnProfileLink();
		    
		    status=loginAndSecurityPage.verify_Discard_ConfirmationMessage(data.get("DiscardConfirmation"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Discard Confirmation");
		    
		    loginAndSecurityPage.clickOnYesDiscardConfirmationPopUp_();
		    
		    status=sspLoginPage.verifyPageTitle(data.get("PageTitle_DashboardPage"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of DashboardPage");
		    
		    
		    
		    
		    //loginAndSecurityPage.clickOnUpdate();
		    
//		    status = loginAndSecurityPage.verifyUpdationSuccessMsg(data.get("UserUpdationSuccessMessage"));
//		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the User Updatio message");
		    
		    
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
