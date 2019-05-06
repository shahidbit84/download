package com.skidata.ssp.portal.translation;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;


/**
 * @author naan
 * 
 * 
 */


public class TC_0013_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_Location_FromTodates_Res_After_Locale_Changes extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0013_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_Location_FromTodates_Res_After_Locale_Changes.class.getName());

	
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0013_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_Location_FromTodates_Res_After_Locale_Changes";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=31,dataProvider = "getDataForTestCaseName", testName = "TC_0013_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_Location_FromTodates_Res_After_Locale_Changes", description ="TC_0013_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_Location_FromTodates_Res_After_Locale_Changes")
	public void ssp_TC_0013_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_Location_FromTodates_Res_After_Locale_Changes(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			
			sspHomePage.SelectLocale();
			Thread.sleep(5000);
			
			//Verifying Warning message appears after selecting SEARCH YOUR PARKING button without entering FROM and TO dates.
			sspHomePage.clickOnSearchYourParkingButton_Homepage();
			
			status=sspHomePage.VerifyWarningMessageToSelectFromAndTodatesOrLocation(data.get("WarningMessageLabel"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Warning messages is not matching");
			
			
	
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
