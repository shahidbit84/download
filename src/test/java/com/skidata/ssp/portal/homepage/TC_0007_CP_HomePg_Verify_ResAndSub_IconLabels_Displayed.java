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

public class TC_0007_CP_HomePg_Verify_ResAndSub_IconLabels_Displayed extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0007_CP_HomePg_Verify_ResAndSub_IconLabels_Displayed.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0007_CP_HomePg_Verify_ResAndSub_IconLabels_Displayed";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=7,dataProvider = "getDataForTestCaseName", testName = "TC_0007_CP_HomePg_Verify_ResAndSub_IconLabels_Displayed", description ="TC_0007_CP_HomePg_Verify_ResAndSub_IconLabels_Displayed")
	public void ssp_TC_0007_CP_HomePg_Verify_ResAndSub_IconLabels_Displayed(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			//Verifying the hourly and monthly labels are displayed
			status=sspHomePage.verifyReservationSubscriptionIconsLabels(data.get("ReservationLabel"),data.get("SubscriptionLabel"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the content of Sub Header");
	
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
