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

public class TC_0002_CP_DashboardPg_Verify_Labels_InDashboardPage extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0002_CP_DashboardPg_Verify_Labels_InDashboardPage.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0002_CP_DashboardPg_Verify_Labels_InDashboardPage";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=602,dataProvider = "getDataForTestCaseName", testName = "TC_0002_CP_DashboardPg_Verify_Labels_InDashboardPage", description ="TC_0002_CP_DashboardPg_Verify_Labels_InDashboardPage")
	public void ssp_TC_0002_CP_DashboardPg_Verify_Labels_InDashboardPage(Hashtable<String, String> data)throws Throwable {

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
		    
		    status=sspLoginPage.verifyPageTitle(data.get("PageTitle_ProfilePage"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of Profile Page");
		    
		   SspDashboardPage sspDashboardPage = new SspDashboardPage(driver, test);
		   status = sspDashboardPage.verifyLabelsInDashboard(data.get("DashBoardHeader"),data.get("UpcomingReservations"),data.get("UpcomingSubscriptions"),data.get("PaymentMethod"),data.get("Identifications"));
		   Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Labels of Dashboard page");

		   status = sspDashboardPage.verifyImagesAndMessagesDisplayed(data.get("UpcomingReservationMsg"),data.get("UpcomingSubscriptionMsg"),
				   data.get("NoPaymentMsg"),data.get("NoIdentificationMsg"));
		   Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Images and Messages in Dashboard page");
		   
		   status = sspDashboardPage.verifyIButtonsDisplayed(data.get("AddReservationButton"),data.get("AddSubscriptionMButton"),
				   data.get("AddPaymentbutton"),data.get("AddIdentificationButton"));
		   Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Buttons Available in Dashboard page");
		   
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
