
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

public class TC_0011_CP_LoginPg_Verify_ControllNavigates_To_Google_Login_Page_From_Login_Page extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0011_CP_LoginPg_Verify_ControllNavigates_To_Google_Login_Page_From_Login_Page.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0011_CP_LoginPg_Verify_ControllNavigates_To_Google_Login_Page_From_Login_Page";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=1011,dataProvider = "getDataForTestCaseName", testName = "TC_0011_CP_LoginPg_Verify_ControllNavigates_To_Google_Login_Page_From_Login_Page", description ="TC_0011_CP_LoginPg_Verify_ControllNavigates_To_Google_Login_Page_From_Login_Page")
	public void ssp_TC_0011_CP_LoginPg_Verify_ControllNavigates_To_Google_Login_Page_From_Login_Page(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);
			
			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			SspLoginPage sspLoginPage=new SspLoginPage(driver, test);
			
			sspHomePage.clickonLogin();
			sspLoginPage.clickonGoogleLinkButton();
			
			status=sspLoginPage.verifyPageTitle(data.get("PageTitle"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Controll is navigated from Login page to  Google Login page.");

			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}
}

