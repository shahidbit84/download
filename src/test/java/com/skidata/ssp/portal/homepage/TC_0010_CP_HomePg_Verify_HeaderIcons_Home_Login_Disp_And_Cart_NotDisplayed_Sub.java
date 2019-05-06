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


public class TC_0010_CP_HomePg_Verify_HeaderIcons_Home_Login_Disp_And_Cart_NotDisplayed_Sub extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0010_CP_HomePg_Verify_HeaderIcons_Home_Login_Disp_And_Cart_NotDisplayed_Sub.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0010_CP_HomePg_Verify_HeaderIcons_Home_Login_Disp_And_Cart_NotDisplayed_Sub";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=10,dataProvider = "getDataForTestCaseName", testName = "TC_0010_CP_HomePg_Verify_HeaderIcons_Home_Login_Disp_And_Cart_NotDisplayed_Sub", description ="TC_0010_CP_HomePg_Verify_HeaderIcons_Home_Login_Disp_And_Cart_NotDisplayed_Sub")
	public void ssp_TC_0010_CP_HomePg_Verify_HeaderIcons_Home_Login_Disp_And_Cart_NotDisplayed_Sub(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			//Verifying the Icon labels Home,Cart,Log in
			sspHomePage.clickOnSubscription();
			status=sspHomePage.verifyHeaderIconsLabelsInHomePageForSubscription(data.get("Home_Icon_Label"),data.get("Login_Icon_Label"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Label of the Header icons displayed.");
	
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
