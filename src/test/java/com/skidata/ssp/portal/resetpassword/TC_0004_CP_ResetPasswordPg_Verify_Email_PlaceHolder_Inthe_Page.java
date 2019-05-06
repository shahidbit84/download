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

public class TC_0004_CP_ResetPasswordPg_Verify_Email_PlaceHolder_Inthe_Page extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0004_CP_ResetPasswordPg_Verify_Email_PlaceHolder_Inthe_Page.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0004_CP_ResetPasswordPg_Verify_Email_PlaceHolder_Inthe_Page";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=1301,dataProvider = "getDataForTestCaseName", testName = "TC_0004_CP_ResetPasswordPg_Verify_Email_PlaceHolder_Inthe_Page", description ="TC_0004_CP_ResetPasswordPg_Verify_Email_PlaceHolder_Inthe_Page")
	public void ssp_TC_0004_CP_ResetPasswordPg_Verify_Email_PlaceHolder_Inthe_Page(Hashtable<String, String> data)throws Throwable {

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
			
			status=sspResetPasswordPage.verifyEmailPlaceholder(data.get("EmailPlaceHolder"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Verified the Email Text filed Placeholder and it is as expected.");

			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}
}
