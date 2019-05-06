package com.skidata.ssp.portal.homepage;

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

public class TC_0034_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_FromTodates_Sub extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0034_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_FromTodates_Sub.class.getName());

	
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0034_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_FromTodates_Sub";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=34,dataProvider = "getDataForTestCaseName", testName = "TC_0034_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_FromTodates_Sub", description ="TC_0034_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_FromTodates_Sub")
	public void ssp_TC_0034_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_FromTodates_Sub(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			sspHomePage.clickOnSubscription();
			sspHomePage.searchParkingLocationsAndSelect(data.get("EnterLocationNameToSearch"),data.get("SelectLocationAddress"));
			//Verifying Warning message appears after selecting SEARCH YOUR PARKING button with entering FROM and TO dates.
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
