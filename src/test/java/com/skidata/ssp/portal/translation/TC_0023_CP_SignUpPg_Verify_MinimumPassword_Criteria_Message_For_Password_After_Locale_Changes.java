package com.skidata.ssp.portal.translation;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.uiPages.portal.SspSignUpPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;


/**
 * @author naan
 * 
 * 
 */


public class TC_0023_CP_SignUpPg_Verify_MinimumPassword_Criteria_Message_For_Password_After_Locale_Changes extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0023_CP_SignUpPg_Verify_MinimumPassword_Criteria_Message_For_Password_After_Locale_Changes.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0023_CP_SignUpPg_Verify_MinimumPassword_Criteria_Message_For_Password_After_Locale_Changes";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=1604,dataProvider = "getDataForTestCaseName", testName = "TC_0023_CP_SignUpPg_Verify_MinimumPassword_Criteria_Message_For_Password_After_Locale_Changes", description ="TC_0023_CP_SignUpPg_Verify_MinimumPassword_Criteria_Message_For_Password_After_Locale_Changes")
	public void ssp_TC_0023_CP_SignUpPg_Verify_MinimumPassword_Criteria_Message_For_Password_After_Locale_Changes(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);
			
			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			
			sspHomePage.SelectLocale();
			Thread.sleep(5000);
			
			SspSignUpPage SspSignUpPage=new SspSignUpPage(driver, test);
			
			sspHomePage.clickonLogin();
			//SspSignUpPage.clickonSingUpLink();
			SspSignUpPage.clickonSingUpInLogInPage();
			
			
			status=SspSignUpPage.verifyPasswordMinimumCriteria_Message(data.get("salutation"),data.get("Fname"),data.get("Lname"),data.get("Email"),data.get("InvalidPassword"),data.get("ConfirmPassword"),data.get("PasswordMinCriteria"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Password Minimum criteria statement is appering as expected in Sign Up page.");

			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}		
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}


}

