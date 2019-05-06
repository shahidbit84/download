/**
 *
 */
package com.skidata.ssp.portal.identifications;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspDashboardPage;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.uiPages.portal.SspIdentificationsPage;
import com.skidata.uiPages.portal.SspLoginPage;
import com.skidata.uiPages.portal.SspSignUpPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author shmo
 * 
 * 
 */

public class TC_0011_CP_identifications_Verify_EditIdentification_Success_SkidataKeycard extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0011_CP_identifications_Verify_EditIdentification_Success_SkidataKeycard.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0011_CP_identifications_Verify_EditIdentification_Success_SkidataKeycard";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=812,dataProvider = "getDataForTestCaseName", testName = "TC_0011_CP_identifications_Verify_EditIdentification_Success_SkidataKeycard", description ="TC_0011_CP_identifications_Verify_EditIdentification_Success_SkidataKeycard")
	public void ssp_TC_0011_CP_identifications_Verify_EditIdentification_Success_SkidataKeycard(Hashtable<String, String> data)throws Throwable {

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
		    dashBoardPage.clickOnlink_Ids_parkers();
		    
		    SspIdentificationsPage identificationsPage = new SspIdentificationsPage(driver, test);

//		    status=identificationsPage.verifyPageHeaderAndLabel(data.get("PageTitle_IdentificationsPage"),data.get("AddIdentificationsLabel"));
//		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of Identifications page");
		    
		    status=identificationsPage.verifyPage_HeaderAndLabel(data.get("PageHeader"),data.get("PageHeader2"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page header and lebels of Addresses page");
		    
		    identificationsPage.clickOnAddIdentification();
		    identificationsPage.addIdentificationDetails(data.get("Identificationtype"),data.get("IdentificationValue"));
		    identificationsPage.clickOnAdd();
		    
//		    status=identificationsPage.verifyAddedVerificationDetails(data.get("Identificationtype"),data.get("IdentificationValue"));
//		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Id details displayed after adding");
		    
		    status=identificationsPage._verifyAddedVerificationDetails(data.get("Identificationtype4"),data.get("IdentificationValue4"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Id details displayed after adding");
		    
		    identificationsPage.clickOnEditIdentifications();
		    
		    identificationsPage.editIdentificationDetails(data.get("EditIdentificationValue"));
		    
		    identificationsPage.clickOnUpdatebutton();
		    
		    status=identificationsPage._verifyAddedVerificationDetails(data.get("Identificationtype4"),data.get("_EditIdentificationValue"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Id details displayed after adding");
			
		    //End of Test Case
		    
		    
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
