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

public class TC_0018_CP_HomePg_Verify_DaysOfWeek_MonthYearDisplayed_InCalendars_Sub extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0018_CP_HomePg_Verify_DaysOfWeek_MonthYearDisplayed_InCalendars_Sub.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0018_CP_HomePg_Verify_DaysOfWeek_MonthYearDisplayed_InCalendars_Sub";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=18,dataProvider = "getDataForTestCaseName", testName = "TC_0018_CP_HomePg_Verify_DaysOfWeek_MonthYearDisplayed_InCalendars_Sub", description ="TC_0018_CP_HomePg_Verify_DaysOfWeek_MonthYearDisplayed_InCalendars_Sub")
	public void ssp_TC_0018_CP_HomePg_Verify_DaysOfWeek_MonthYearDisplayed_InCalendars_Sub(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			sspHomePage.clickOnSubscription();
			
			//Verifying the days Name in calendar FROM:
			status=sspHomePage.verifyCalendar_FromAndTo_Month_NameOfDaysInWeek_Subscription(data.get("Days_Of_Week_Names"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the calendar Month or Calendar days name");
		
	
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
