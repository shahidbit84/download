/**
 *
 */
package com.skidata.ssp.portal.productslistpage;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.uiPages.portal.SspProductsListPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author shmo
 * 
 * 
 */

public class TC_0012_CP_ProductsPg_Verify_Links_Images_Displayed_In_Footer_Sub extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0012_CP_ProductsPg_Verify_Links_Images_Displayed_In_Footer_Sub.class.getName());

	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0012_CP_ProductsPg_Verify_Links_Images_Displayed_In_Footer_Sub";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=212,dataProvider = "getDataForTestCaseName", testName = "TC_0012_CP_ProductsPg_Verify_Links_Images_Displayed_In_Footer_Sub", description ="TC_0012_CP_ProductsPg_Verify_Links_Images_Displayed_In_Footer_Sub")
	public void ssp_TC_0012_CP_ProductsPg_Verify_Links_Images_Displayed_In_Footer_Sub(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			sspHomePage.clickOnSubscription();
			sspHomePage.searchParkingLocationsAndSelect(data.get("EnterLocationNameToSearch"),data.get("SelectLocationAddress"));
			sspHomePage.select_ProductSearchStartDate_InFromCalendar_Subscription();
			sspHomePage.clickOnSearchYourParkingButton();

			SspProductsListPage sspProductsListPage = new SspProductsListPage(driver, test);
			
			
			//Verifying the links in Footer and the text
			status=sspProductsListPage.verifyHomePageFooterUrls_AreDisplayed(data.get("FAQlabel"),data.get("TermsOfUseLabel"),data.get("OnlineParkingTClabel"),data.get("PrivacyPolicy"),data.get("NeedHelpLabel"),
					data.get("PhoneNumberText"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in footer labels");
			
			//Verifying the links in Footer and the text
			status=sspProductsListPage.verifyHomePageFooterImages_AreDisplayed();
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in footer images");
	
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}
	}

}
