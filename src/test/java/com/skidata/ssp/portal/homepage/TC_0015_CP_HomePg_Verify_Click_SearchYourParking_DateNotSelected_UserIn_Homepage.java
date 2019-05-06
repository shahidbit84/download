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

public class TC_0015_CP_HomePg_Verify_Click_SearchYourParking_DateNotSelected_UserIn_Homepage extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0015_CP_HomePg_Verify_Click_SearchYourParking_DateNotSelected_UserIn_Homepage.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0015_CP_HomePg_Verify_Click_SearchYourParking_DateNotSelected_UserIn_Homepage";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=15,dataProvider = "getDataForTestCaseName", testName = "TC_0015_CP_HomePg_Verify_Click_SearchYourParking_DateNotSelected_UserIn_Homepage", description ="TC_0015_CP_HomePg_Verify_Click_SearchYourParking_DateNotSelected_UserIn_Homepage")
	public void ssp_TTC_0015_CP_HomePg_Verify_Click_SearchYourParking_DateNotSelected_UserIn_Homepage(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			//verifying that for the default date if user click on Search your parking he should be in the landing page itself
			sspHomePage.clickOnSubscription();
			sspHomePage.clickOnSearchYourParkingButton_Homepage();
			status=sspHomePage.verifySearchBookingButtonIsDisplayed(data.get("SearchYourParkingLabel"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"SEARCH YOUR PARKING button text mismatch");
			
			sspHomePage.clickOnReservation();
			sspHomePage.clickOnSearchYourParkingButton_Homepage();
			status=sspHomePage.verifySearchBookingButtonIsDisplayed(data.get("SearchYourParkingLabel"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"SEARCH YOUR PARKING button text mismatch");
	
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
