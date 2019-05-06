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

public class TC_0022_CP_HomePg_Verify_Links_Images_Displayed_In_Footer extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0022_CP_HomePg_Verify_Links_Images_Displayed_In_Footer.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0022_CP_HomePg_Verify_Links_Images_Displayed_In_Footer";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=22,dataProvider = "getDataForTestCaseName", testName = "TC_0022_CP_HomePg_Verify_Links_Images_Displayed_In_Footer", description ="TC_0022_CP_HomePg_Verify_Links_Images_Displayed_In_Footer")
	public void ssp_TC_0022_CP_HomePg_Verify_Links_Images_Displayed_In_Footer(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			//Verifying the links in Footer and the text
			status=sspHomePage.verifyHomePageFooterUrls_AreDisplayed(data.get("FAQlabel"),data.get("TermsOfUseLabel"),data.get("OnlineParkingTClabel"),data.get("PrivacyPolicy"),data.get("NeedHelpLabel"),
					data.get("PhoneNumberText"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in footer labels");
			
			//Verifying the links in Footer and the text
			status=sspHomePage.verifyHomePageFooterImages_AreDisplayed();
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Footer image may not displayed in UI");
	
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
