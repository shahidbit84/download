package com.skidata.ssp.portal.resetpassword;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.uiPages.portal.SspResetPasswordPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

public class TC_0006_CP_ResetPasswordPg_Verify_Controll_Navigates_To_Login_Pg_after_seelcting_Send_Reset_Link_If_ValidEmail_Is_Given extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0006_CP_ResetPasswordPg_Verify_Controll_Navigates_To_Login_Pg_after_seelcting_Send_Reset_Link_If_ValidEmail_Is_Given.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0006_CP_ResetPasswordPg_Verify_Controll_Navigates_To_Login_Pg_after_seelcting_Send_Reset_Link_If_ValidEmail_Is_Given";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=1406,dataProvider = "getDataForTestCaseName", testName = "TC_0006_CP_ResetPasswordPg_Verify_Controll_Navigates_To_Login_Pg_after_seelcting_Send_Reset_Link_If_ValidEmail_Is_Given", description ="TC_0006_CP_ResetPasswordPg_Verify_Controll_Navigates_To_Login_Pg_after_seelcting_Send_Reset_Link_If_ValidEmail_Is_Given")
	public void ssp_TC_0006_CP_ResetPasswordPg_Verify_Controll_Navigates_To_Login_Pg_after_seelcting_Send_Reset_Link_If_ValidEmail_Is_Given(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);
			
			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			SspResetPasswordPage sspResetPasswordPage=new SspResetPasswordPage(driver, test);

			sspHomePage.clickonLogin();


			sspResetPasswordPage.SelectForgotPasswordInLoginPage();
			sspResetPasswordPage.enterValidEmailInEmailtextfield(data.get("ValidEmailId"));
			sspResetPasswordPage.ClickOnBackToLoginLink();
			status=sspResetPasswordPage.verifyPageTitle(data.get("LoginPageTitle"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Controll navigated to Login page after seelcting Back to Login link in the Reset Password Page.");

			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}


}
