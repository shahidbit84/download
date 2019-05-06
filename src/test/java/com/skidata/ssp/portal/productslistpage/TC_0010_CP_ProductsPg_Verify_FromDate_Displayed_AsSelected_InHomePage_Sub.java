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

public class TC_0010_CP_ProductsPg_Verify_FromDate_Displayed_AsSelected_InHomePage_Sub extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0010_CP_ProductsPg_Verify_FromDate_Displayed_AsSelected_InHomePage_Sub.class.getName());

	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0010_CP_ProductsPg_Verify_FromDate_Displayed_AsSelected_InHomePage_Sub";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=210,dataProvider = "getDataForTestCaseName", testName = "TC_0010_CP_ProductsPg_Verify_FromDate_Displayed_AsSelected_InHomePage_Sub", description ="TC_0010_CP_ProductsPg_Verify_FromDate_Displayed_AsSelected_InHomePage_Sub")
	public void ssp_TC_0010_CP_ProductsPg_Verify_FromDate_Displayed_AsSelected_InHomePage_Sub(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			sspHomePage.clickOnSubscription();
			sspHomePage.searchParkingLocationsAndSelect(data.get("EnterLocationNameToSearch"),data.get("SelectLocationAddress"));
			sspHomePage.select_ProductSearchStartDate_InFromCalendar_Subscription();
			
			//Retrieve the selected date in Home page From calendar and store in a variable
			String selectedDateTimeFromCalendarSubscription = sspHomePage.getSelected_Date_Month_Year_Time_FromCalendar_Subscription_InHomePage();
			sspHomePage.clickOnSearchYourParkingButton();
			
			//Now Retrieve the From Time and To time in the Products page 
			SspProductsListPage sspProductsListPage = new SspProductsListPage(driver, test);
			status=sspProductsListPage.verifyDisplayedDateTime_FromAndTo_ForSubscription_IsCorrect(selectedDateTimeFromCalendarSubscription);
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the From Date Month Year Time AMPM in Product list page for the selected Date Month Year Time AMPM in Home Page");
		
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
