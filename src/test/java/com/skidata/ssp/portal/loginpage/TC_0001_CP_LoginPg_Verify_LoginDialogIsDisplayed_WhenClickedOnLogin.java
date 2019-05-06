/**
 *
 */
package com.skidata.ssp.portal.loginpage;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.uiPages.portal.SspLoginPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author shmo
 * 
 * 
 */

public class TC_0001_CP_LoginPg_Verify_LoginDialogIsDisplayed_WhenClickedOnLogin extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0001_CP_LoginPg_Verify_LoginDialogIsDisplayed_WhenClickedOnLogin.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0001_CP_LoginPg_Verify_LoginDialogIsDisplayed_WhenClickedOnLogin";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=1001,dataProvider = "getDataForTestCaseName", testName = "TC_0001_CP_LoginPg_Verify_LoginDialogIsDisplayed_WhenClickedOnLogin", description ="TC_0001_CP_LoginPg_Verify_LoginDialogIsDisplayed_WhenClickedOnLogin")
	public void ssp_TC_0001_CP_LoginPg_Verify_LoginDialogIsDisplayed_WhenClickedOnLogin(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);
			
			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			sspHomePage.clickonLogin();
	     
			SspLoginPage sspLoginPage = new SspLoginPage(driver, test);
			
			
			status=sspLoginPage.verifyPageTitle(data.get("PageTitle"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of login Page");



			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
