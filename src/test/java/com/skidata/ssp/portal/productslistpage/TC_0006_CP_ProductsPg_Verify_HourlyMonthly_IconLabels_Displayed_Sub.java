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

public class TC_0006_CP_ProductsPg_Verify_HourlyMonthly_IconLabels_Displayed_Sub extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0006_CP_ProductsPg_Verify_HourlyMonthly_IconLabels_Displayed_Sub.class.getName());

	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0006_CP_ProductsPg_Verify_HourlyMonthly_IconLabels_Displayed_Sub";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=206,dataProvider = "getDataForTestCaseName", testName = "TC_0006_CP_ProductsPg_Verify_HourlyMonthly_IconLabels_Displayed_Sub", description ="TC_0006_CP_ProductsPg_Verify_HourlyMonthly_IconLabels_Displayed_Sub")
	public void ssp_TC_0006_CP_ProductsPg_Verify_HourlyMonthly_IconLabels_Displayed_Sub(Hashtable<String, String> data)throws Throwable {

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
			sspHomePage.clickOnSearchYourParkingButton();

			SspProductsListPage sspProductsListPage = new SspProductsListPage(driver, test);

			 //Verifying the hourly and monthly labels are displayed
			status=sspProductsListPage.verifyReservationSubscriptionIconsLabels(data.get("ReservationLabel"),data.get("SubscriptionLabel"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Labels Hourly Monthly not displayed in Products Page");


			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
