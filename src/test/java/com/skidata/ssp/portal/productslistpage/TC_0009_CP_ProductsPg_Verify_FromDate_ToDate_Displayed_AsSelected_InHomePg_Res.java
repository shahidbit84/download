/**
 *
 */
package com.skidata.ssp.portal.productslistpage;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skidata.helperclasses.DateAndUniqueNoGenerateHelper;
import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.uiPages.portal.SspProductsListPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author shmo
 * 
 * 
 */

public class TC_0009_CP_ProductsPg_Verify_FromDate_ToDate_Displayed_AsSelected_InHomePg_Res extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0009_CP_ProductsPg_Verify_FromDate_ToDate_Displayed_AsSelected_InHomePg_Res.class.getName());

	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0009_CP_ProductsPg_Verify_FromDate_ToDate_Displayed_AsSelected_InHomePg_Res";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=209,dataProvider = "getDataForTestCaseName", testName = "TC_0009_CP_ProductsPg_Verify_FromDate_ToDate_Displayed_AsSelected_InHomePg_Res", description ="TC_0009_CP_ProductsPg_Verify_FromDate_ToDate_Displayed_AsSelected_InHomePg_Res")
	public void ssp_TC_0009_CP_ProductsPg_Verify_FromDate_ToDate_Displayed_AsSelected_InHomePg_Res(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			DateAndUniqueNoGenerateHelper dateAndUniqueNoGenerateHelper = new DateAndUniqueNoGenerateHelper();
			String endDate=dateAndUniqueNoGenerateHelper.get_PreviousDate_OrFutureDate("MM/dd/yyyy",data.get("AddOrMinusDate"));
		
			sspHomePage.searchParkingLocationsAndSelect(data.get("EnterLocationNameToSearch"),data.get("SelectLocationAddress"));
			sspHomePage.select_ProductSearchStartDate_InFromCalendar_Reservation();
			sspHomePage.select_ProductSearchEndDate_InToCalendar_Reservation(endDate);
			
			//Retrieve the selected date in Home page From calendar and store in a variable
			
			String selectedDateTimeFromCalendarHourly = sspHomePage.getSelected_Date_Month_Year_Time_FromCalendar_Reservation_InHomePage();
			
			//Retrieve the selected date in Home page From calendar and store in a variable
			
			String selectedDateTimeToCalendarHourly=sspHomePage.getSelected_Date_Month_Year_Time_ToCalendar_Reservation_InHomePage();
			

			sspHomePage.clickOnSearchYourParkingButton();
			
			//Now Retrieve the From Time and To time in the Products page 

			SspProductsListPage sspProductsListPage = new SspProductsListPage(driver, test);
			status=sspProductsListPage.verifyDisplayedDateTime_FromAndTo_ForReservation_IsCorrect(selectedDateTimeFromCalendarHourly, selectedDateTimeToCalendarHourly);
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the From and To Date Month Year Time AMPM in Product list page for the selected Date Month Year Time AMPM in Home Page");
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
