/**
 *
 */
package com.skidata.ssp.portal.reservationpage;

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
import com.skidata.uiPages.portal.SspReservations;
import com.skidata.uiPages.portal.SspSignUpPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author naan
 * 
 * 
 */

public class TC_0005_CP_ReservationPg_Verify_LabelsAndHeader_If_No_ActiveBookingsAvailable extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0005_CP_ReservationPg_Verify_LabelsAndHeader_If_No_ActiveBookingsAvailable.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0005_CP_ReservationPg_Verify_LabelsAndHeader_If_No_ActiveBookingsAvailable";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=603,dataProvider = "getDataForTestCaseName", testName = "TC_0005_CP_ReservationPg_Verify_LabelsAndHeader_If_No_ActiveBookingsAvailable", description ="TC_0005_CP_ReservationPg_Verify_LabelsAndHeader_If_No_ActiveBookingsAvailable")
	public void ssp_TC_0005_CP_ReservationPg_Verify_LabelsAndHeader_If_No_ActiveBookingsAvailable(Hashtable<String, String> data)throws Throwable {

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
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of DashboardPage");
		    
		    SspDashboardPage dashBoardPage = new SspDashboardPage(driver, test);
		    dashBoardPage.ClickOn_ProfileReservation();
		    
			SspReservations sspReservations = new SspReservations(driver, test);
			
			status=sspReservations.Verify_ReservationPg_HeaderAndLabels_If_No_Reservations(data.get("ReservationHeader"),data.get("PageHeader_Show"),data.get("PageHeader_AllReservation"),data.get("FindReservation"), data.get("SubHeaderText1"), data.get("SubHeaderText2"), data.get("AddButton"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the headers and labels in profile reservation page");
		    
		    
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
