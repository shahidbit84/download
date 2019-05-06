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

import com.skidata.helperclasses.DateAndUniqueNoGenerateHelper;
import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author shmo
 * 
 * 
 */

public class TC_0023_CP_HomePg_Select_StartEndDate_ValidateItsDisplayedCorrectly_Res extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0023_CP_HomePg_Select_StartEndDate_ValidateItsDisplayedCorrectly_Res.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0023_CP_HomePg_Select_StartEndDate_ValidateItsDisplayedCorrectly_Res";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=23,dataProvider = "getDataForTestCaseName", testName = "TC_0023_CP_HomePg_Select_StartEndDate_ValidateItsDisplayedCorrectly_Res", description ="TC_0023_CP_HomePg_Select_StartEndDate_ValidateItsDisplayedCorrectly_Res")
	public void ssp_TC_0023_CP_HomePg_Select_StartEndDate_ValidateItsDisplayedCorrectly_Res(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);

			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			DateAndUniqueNoGenerateHelper dateAndUniqueNoGenerateHelper = new DateAndUniqueNoGenerateHelper();
			String endDate=dateAndUniqueNoGenerateHelper.get_PreviousDate_OrFutureDate("MM/dd/yyyy",data.get("AddOrMinusDate"));
		
			//Spliting and sending only the day value like 06 for example
			String[] dateToSend = endDate.split("/");

			sspHomePage.select_ProductSearchStartDate_InFromCalendar_Reservation();
			sspHomePage.select_ProductSearchEndDate_InToCalendar_Reservation(endDate);
			
			//Verifying the value date month year time period is displayed correctly after user selects in FROM for Hourly
			status=sspHomePage.verify_Selected_From_DateMonthYearWithTimePeriod_IsDisplayed_ForReservation();
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Date month Year Time and Period displayed for FROM: in Hourly");
			
			//Verifying the value date month year time period is displayed correctly after user selects in TO for Hourly
			status=sspHomePage.verify_Selected_To_DateMonthYearWithTimePeriod_IsDisplayed_ForReservation(dateToSend[1]);
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Date month Year Time and Period displayed for TO: in Hourly");
			
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
