/**
 *
 */
package com.skidata.ssp.portal.dashboard;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspDashboardPage;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.uiPages.portal.SspLoginPage;
import com.skidata.uiPages.portal.SspSignUpPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author shmo
 * 
 * 
 */

public class TC_0006_CP_DashboardPg_Verify_Click_Seeall_Identifications_NavigateIdentificationsPage extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0006_CP_DashboardPg_Verify_Click_Seeall_Identifications_NavigateIdentificationsPage.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0006_CP_DashboardPg_Verify_Click_Seeall_Identifications_NavigateIdentificationsPage";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=606,dataProvider = "getDataForTestCaseName", testName = "TC_0006_CP_DashboardPg_Verify_Click_Seeall_Identifications_NavigateIdentificationsPage", description ="TC_0006_CP_DashboardPg_Verify_Click_Seeall_Identifications_NavigateIdentificationsPage")
	public void ssp_TC_0006_CP_DashboardPg_Verify_Click_Seeall_Identifications_NavigateIdentificationsPage(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);
			
			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			sspHomePage.clickonLogin();
	     
			SspLoginPage sspLoginPage = new SspLoginPage(driver, test);
			sspLoginPage.clickOnSignUp();
			
			SspSignUpPage sspSignUpPage = new SspSignUpPage(driver, test);
			
			
			String UniqueEmailId=sspSignUpPage.emailCreationNew();
			sspSignUpPage.EnterSignUpDetails(data.get("salutation"),data.get("Fname"),
					data.get("Lname"),UniqueEmailId+"@harakirimail.com",data.get("Password"),data.get("ConfirmPassword"));
			
			sspSignUpPage.clickOnSignUp();
		    sspLoginPage.Verifysignup(UniqueEmailId);
		    
            Thread.sleep(3000);
		    sspLoginPage.login(UniqueEmailId+"@harakirimail.com",data.get("Password"));  
		    sspHomePage.clickOnProfileLink();
		    
		    status=sspLoginPage.verifyPageTitle(data.get("PageTitle_DashboardPage"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in"
		    		+ " the Page title of DashboardPage");
		    
		    SspDashboardPage dashBoardPage = new SspDashboardPage(driver, test);
		    dashBoardPage.clickOnSeeall_Identifications();
		    
		    status=dashBoardPage.verifyPageTitle(data.get("PageTitle_IdentificationsPage"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of My parkers");
		    
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
