/**
 *
 */
package com.skidata.ssp.portal.addresspage;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspAddressesPage;
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

public class TC_0002_CP_AddressPage_Verify_LabelAndHeader extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0002_CP_AddressPage_Verify_LabelAndHeader.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0002_CP_AddressPage_Verify_LabelAndHeader";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=702,dataProvider = "getDataForTestCaseName", testName = "TC_0002_CP_AddressPage_Verify_LabelAndHeader", description ="TC_0002_CP_AddressPage_Verify_LabelAndHeader")
	public void ssp_TC_0002_CP_AddressPage_Verify_LabelAndHeader(Hashtable<String, String> data)throws Throwable {

//		log("Test case/s link of included test cases: "
//		+ " <br /><a href='https://testlink.skidata.net/qa/linkto.php?tprojectPrefix=SSP&item=testcase&id=SSP-33'> SSP-33:TC_01 Verify Mandatorily available functionalities in the main list page.</a>");


		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);
			
			SspHomePage sspHomePage = new SspHomePage(driver,test);
			sspHomePage.clickOnGotIt();
			sspHomePage.clickonLogin();
	     
			SspLoginPage sspLoginPage = new SspLoginPage(driver,test);
			sspLoginPage.clickOnSignUp();
			
			SspSignUpPage sspSignUpPage = new SspSignUpPage(driver,test);
			
			
		/*	String UniqueEmailId=sspSignUpPage.emailCreation();
			sspSignUpPage.EnterSignUpDetails(data.get("salutation"),data.get("Fname"),
					data.get("Lname"),UniqueEmailId,data.get("Password"),data.get("ConfirmPassword"));
			
			status=sspSignUpPage.VerifySignUpSuccessfulMessage(data.get("SignUpSuccessfullMessage"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"SignUp not Success");

		    sspLoginPage.login(UniqueEmailId,data.get("Password"));  
		 */
		    
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
		    
		    SspDashboardPage dashBoardPage = new SspDashboardPage(driver,test);
		    dashBoardPage.clickOnAddresses();
		    
		    
		    SspAddressesPage addressesPage = new SspAddressesPage(driver,test);
		    status=addressesPage.verifyPageTitle(data.get("PageTitle_AddressesPage"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of Addresses page");
		    
		    status=addressesPage.verifyPageHeaderAndLabel(data.get("AddressPageHeader"),data.get("AddressPageHeader2"),data.get("AddBillingAddressLabel"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the header and label in profile address page");
		    
		   
		    
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
