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
import com.skidata.uiPages.portal.SspSignUpPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author shmo
 * 
 * 
 */

public class TC_0005_CP_LoginPg_Verify_Login_ClickOnProfile_AndCheckProfilePageDisplayed extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0005_CP_LoginPg_Verify_Login_ClickOnProfile_AndCheckProfilePageDisplayed.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0005_CP_LoginPg_Verify_Login_ClickOnProfile_AndCheckProfilePageDisplayed";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=1005,dataProvider = "getDataForTestCaseName", testName = "TC_0005_CP_LoginPg_Verify_Login_ClickOnProfile_AndCheckProfilePageDisplayed", description ="TC_0005_CP_LoginPg_Verify_Login_ClickOnProfile_AndCheckProfilePageDisplayed")
	public void ssp_TC_0005_CP_LoginPg_Verify_Login_ClickOnProfile_AndCheckProfilePageDisplayed(Hashtable<String, String> data)throws Throwable {

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
		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of Cart Page");
		    
            SspSignUpPage sspSignUpPage = new SspSignUpPage(driver, test);
			
        	sspSignUpPage.clickonSingUpInLogInPage();
            
           
        	String UniqueEmailId=sspSignUpPage.emailCreationNew();
			sspSignUpPage.EnterSignUpDetails(data.get("salutation"),data.get("Fname"),
					data.get("Lname"),UniqueEmailId+"@harakirimail.com",data.get("Password"),data.get("ConfirmPassword"));
			
			sspSignUpPage.clickOnSignUp();
		    sspLoginPage.Verifysignup(UniqueEmailId);
		    
            Thread.sleep(3000);
		    sspLoginPage.login(UniqueEmailId+"@harakirimail.com",data.get("Password"));  
			//sspLoginPage.clickonLogInButton();

		    //sspLoginPage.login(data.get("Email"),data.get("Password"));  
		    //sspHomePage.clickonProfileLink();
		   // sspHomePage.clickOnProfile();
		   
			
			//sspHomePage.clickOnProfileLink();
		    
//		    status=sspLoginPage.verifyPageTitle(data.get("PageTitle_ProfilePage"));
//		    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of Cart Page");
			
			     sspHomePage.clickOnProfileLink();
			    
			    status=sspLoginPage.verifyPageTitle(data.get("PageTitle_ProfilePage"));
			    Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of Cart Page");
			    

			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
