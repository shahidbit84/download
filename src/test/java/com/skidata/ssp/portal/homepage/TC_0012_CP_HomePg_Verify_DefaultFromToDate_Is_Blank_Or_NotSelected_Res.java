/**
 *
 */
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

/**
 * @author shmo
 * 
 * 
 */

public class TC_0012_CP_HomePg_Verify_DefaultFromToDate_Is_Blank_Or_NotSelected_Res extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0012_CP_HomePg_Verify_DefaultFromToDate_Is_Blank_Or_NotSelected_Res.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0012_CP_HomePg_Verify_DefaultFromToDate_Is_Blank_Or_NotSelected_Res";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=12,dataProvider = "getDataForTestCaseName", testName = "TC_0012_CP_HomePg_Verify_DefaultFromToDate_Is_Blank_Or_NotSelected_Res", description ="TC_0012_CP_HomePg_Verify_DefaultFromToDate_Is_Blank_Or_NotSelected_Res")
	public void ssp_TC_0012_CP_HomePg_Verify_DefaultFromToDate_Is_Blank_Or_NotSelected_Res(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			//Verifying the Default date for From when Hourly is selected is blank
			status=sspHomePage.verifyDefaultDateisBlankForReservation();
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Default date is selected for Hourly From and To Date and displayed in UI");
			
	
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
