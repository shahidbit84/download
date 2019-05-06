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

import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspDashboardPage;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.uiPages.portal.SspLoginPage;
import com.skidata.uiPages.portal.SspSignUpPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author naan
 * 
 * 
 */

public class TC_0014_CP_ResetPasswordPg_Verify_Available_FieldAndLinks extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0014_CP_ResetPasswordPg_Verify_Available_FieldAndLinks.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0014_CP_ResetPasswordPg_Verify_Available_FieldAndLinks";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=1100,dataProvider = "getDataForTestCaseName", testName = "TC_0014_CP_ResetPasswordPg_Verify_Available_FieldAndLinks", description ="TC_0014_CP_ResetPasswordPg_Verify_Available_FieldAndLinks")
	public void ssp_TC_0014_CP_ResetPasswordPg_Verify_Available_FieldAndLinks(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);
			
			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			sspHomePage.clickonLogin();
	     
			SspLoginPage sspLoginPage = new SspLoginPage(driver, test);
			
			sspLoginPage.clickonForgotPassword();
			
			status=sspLoginPage.verifyPageTitle_ResetPasswordPage(data.get("PageTitle_Resetpassword"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in Page Title");
			
			status=sspLoginPage.verify_ResetPasswordPage_HeaderAndLabel(data.get("PageHeader"), data.get("SubHeader"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page header and labels in reset password page");
			
			sspLoginPage.verifyAvailbleTextFieldInResetParkerPage(data.get("ResetEmail_field"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"), "Mismatch in the text field for reset password");
			
			
			log(data.get("ResendButton"));
			log(data.get("BackToLogInButton"));
						
			status=sspLoginPage.verify_AvailableLinks_ResetPassword(data.get("ResendButton"),data.get("BackToLogInButton"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"), "Mismatch in reset password page available links");
			
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

	public static void main(String[] args) {
		
	}

}
