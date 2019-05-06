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

public class TC_0009_CP_AddressPage_Add_Company_Full_address extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0009_CP_AddressPage_Add_Company_Full_address.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0009_CP_AddressPage_Add_Company_Full_address";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=709,dataProvider = "getDataForTestCaseName", testName = "TC_0009_CP_AddressPage_Add_Company_Full_address", description ="TC_0009_CP_AddressPage_Add_Company_Full_address")
	public void ssp_TC_0009_CP_AddressPage_Add_Company_Full_address(Hashtable<String, String> data)throws Throwable {


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
		    Thread.sleep(500);
		    SspAddressesPage addressesPage = new SspAddressesPage(driver,test);
		    status=addressesPage.verifyPageTitle(data.get("PageTitle_AddressesPage"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of Addresses page");
		    addressesPage.clickOnAddbillingAddresses();
		    Thread.sleep(500);
		    addressesPage.clickOnCompanygAddresses();
		    
		   
		    addressesPage.addCompanyfullAddress(data.get("CompanyName"),data.get("CompanyOtherInformation"),data.get("CompanyVat"),data.get("CompanyCountry"),data.get("CompanyFullAddress1"),data.get("CompanyFullAddress2"),data.get("CompanyTownOrCity")
		    		,data.get("CompanyStateOrProvince"),data.get("Postcode"),data.get("CompanyPhone"));
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Company full Address form  fields");
		    
		    status=addressesPage.VerifyAddressAddSuccessfulMessage(data.get("AddSuccessfulMsg"));
     	    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Address Successfully Added");
		   
		    
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
