package com.skidata.ssp.portal.signuppage;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skidata.testBase.TestBase;
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


public class TC_0014_CP_Verify_CheckYourMail_Popup_After_Successfully_SignUp extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0014_CP_Verify_CheckYourMail_Popup_After_Successfully_SignUp.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0014_CP_Verify_CheckYourMail_Popup_After_Successfully_SignUp";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=1601,dataProvider = "getDataForTestCaseName", testName = "TC_0014_CP_Verify_CheckYourMail_Popup_After_Successfully_SignUp", description ="TC_0014_CP_Verify_CheckYourMail_Popup_After_Successfully_SignUp")
	public void ssp_TC_0014_CP_Verify_CheckYourMail_Popup_After_Successfully_SignUp(Hashtable<String, String> data)throws Throwable {

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
			
			status=sspSignUpPage.VerifySignUpSuccessfulMessage(data.get("SignUpSuccessfullMessage"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in Signup successfully message");
			
            status=sspSignUpPage.Verify_CheckYourMail_Popup_After_SignUpSuccessfully(data.get("HeaderOne"), data.get("HeaderTwo"));
            Assert.assertEquals(status, data.get("ExpectedValuePASS"), "Mismatch in check your mail popup after successfully signup");
            
            status=sspLoginPage.verifyPageTitle(data.get("PageTitle_LogInPage"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of login Page");
		
		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}