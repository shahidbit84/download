package com.skidata.ssp.portal.signuppage;

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

public class TC_0001_CP_SignUpPg_Verify_ControlNavigatesToSignUpPageFromLoginPage extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0001_CP_SignUpPg_Verify_ControlNavigatesToSignUpPageFromLoginPage.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0001_CP_SignUpPg_Verify_ControlNavigatesToSignUpPageFromLoginPage";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=1601,dataProvider = "getDataForTestCaseName", testName = "TC_0001_CP_SignUpPg_Verify_ControlNavigatesToSignUpPageFromLoginPage", description ="TC_0001_CP_SignUpPg_Verify_ControlNavigatesToSignUpPageFromLoginPage")
	public void ssp_TC_0001_CP_SignUpPg_Verify_ControlNavigatesToSignUpPageFromLoginPage(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);
			
			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			SspSignUpPage SspSignUpPage=new SspSignUpPage(driver, test);
			
			sspHomePage.clickonLogin();
			SspSignUpPage.clickonSingUpLink();
			
			status=SspSignUpPage.verifyPageTitle(data.get("PageTitle"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Controll is navigated from Login page to Sign Up page.");

			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}