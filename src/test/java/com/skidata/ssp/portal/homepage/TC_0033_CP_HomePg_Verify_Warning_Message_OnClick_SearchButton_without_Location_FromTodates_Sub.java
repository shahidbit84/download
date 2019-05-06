package com.skidata.ssp.portal.homepage;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

public class TC_0033_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_Location_FromTodates_Sub extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0033_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_Location_FromTodates_Sub.class.getName());


	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0033_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_Location_FromTodates_Sub";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=32,dataProvider = "getDataForTestCaseName", testName = "TC_0033_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_Location_FromTodates_Sub", description ="TC_0033_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_Location_FromTodates_Sub")
	public void ssp_TC_0033_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_Location_FromTodates_Sub(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			//Verifying Warning message appears after selecting SEARCH YOUR PARKING button without entering FROM date for Subscription.
			sspHomePage.clickOnSubscription();
			sspHomePage.clickOnSearchYourParkingButton_Homepage();
			status=sspHomePage.VerifyWarningMessageToSelectFromAndTodatesOrLocation(data.get("WarningMessageLabel"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Warning messages is not matching");
			
			
	
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch (NullPointerException e) {
			String exceptionMessage=ExceptionUtils.getStackTrace(e);
			log(exceptionMessage);
			test.log(LogStatus.FAIL, "Null pointer exception occured");
			Assert.fail(e.getMessage());

		}		
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
