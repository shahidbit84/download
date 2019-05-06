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


/**
 * @author naan
 * 
 * 
 */


public class TC_0013_CP_Verify_All_Available_SignUp_Fields_In_SignUp_Details_Form extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0013_CP_Verify_All_Available_SignUp_Fields_In_SignUp_Details_Form.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0013_CP_Verify_All_Available_SignUp_Fields_In_SignUp_Details_Form";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=1613,dataProvider = "getDataForTestCaseName", testName = "TC_0013_CP_Verify_All_Available_SignUp_Fields_In_SignUp_Details_Form", description ="TC_0013_CP_Verify_All_Available_SignUp_Fields_In_SignUp_Details_Form")
	public void ssp_TC_0013_CP_Verify_All_Available_SignUp_Fields_In_SignUp_Details_Form(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);
			
			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			SspSignUpPage sspSignUpPage=new SspSignUpPage(driver, test);
			
			sspHomePage.clickonLogin();
			//sspSignUpPage.clickonSingUpLink();
			sspSignUpPage.clickonSingUpInLogInPage();
			
			
			status=sspSignUpPage.verifyAvailbleSignUpFieldsInSignUpDetailsForm(data.get("Salutation"),data.get("Fname"),data.get("Lname"),data.get("Email") ,data.get("Password"),data.get("ConfirmPassword"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"All SignUp Detail Fields Displayed Successfully");


			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}



}
