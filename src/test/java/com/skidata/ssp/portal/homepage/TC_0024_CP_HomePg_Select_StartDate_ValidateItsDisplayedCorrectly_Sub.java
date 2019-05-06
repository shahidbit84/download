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

public class TC_0024_CP_HomePg_Select_StartDate_ValidateItsDisplayedCorrectly_Sub extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0024_CP_HomePg_Select_StartDate_ValidateItsDisplayedCorrectly_Sub.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0024_CP_HomePg_Select_StartDate_ValidateItsDisplayedCorrectly_Sub";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=24,dataProvider = "getDataForTestCaseName", testName = "TC_0024_CP_HomePg_Select_StartDate_ValidateItsDisplayedCorrectly_Sub", description ="TC_0024_CP_HomePg_Select_StartDate_ValidateItsDisplayedCorrectly_Sub")
	public void ssp_TC_0024_CP_HomePg_Select_StartDate_ValidateItsDisplayedCorrectly_Sub(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			sspHomePage.clickOnSubscription();
			sspHomePage.select_ProductSearchStartDate_InFromCalendar_Subscription();

			//Verifying the value date month year time period is displayed correctly after user selects in FROM for Hourly
			status=sspHomePage.verify_Selected_From_DateMonthYearWithTimePeriod_IsDisplayed_ForSubscription();
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Date month Year displayed for FROM: in Monthly");
			
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
