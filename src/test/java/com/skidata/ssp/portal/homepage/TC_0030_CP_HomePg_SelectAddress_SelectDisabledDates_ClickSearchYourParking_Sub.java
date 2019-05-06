/**
 *
 */
package com.skidata.ssp.portal.homepage;

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

public class TC_0030_CP_HomePg_SelectAddress_SelectDisabledDates_ClickSearchYourParking_Sub extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0030_CP_HomePg_SelectAddress_SelectDisabledDates_ClickSearchYourParking_Sub.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0030_CP_HomePg_SelectAddress_SelectDisabledDates_ClickSearchYourParking_Sub";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=30,dataProvider = "getDataForTestCaseName", testName = "TC_0030_CP_HomePg_SelectAddress_SelectDisabledDates_ClickSearchYourParking_Sub", description ="TC_0030_CP_HomePg_SelectAddress_SelectDisabledDates_ClickSearchYourParking_Sub")
	public void ssp_TC_0030_CP_HomePg_SelectAddress_SelectDisabledDates_ClickSearchYourParking_Sub(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			sspHomePage.clickOnSubscription();
			
			//Verifying the SearchLocation Bar is displayed and the placeholder value
			sspHomePage.searchParkingLocationsAndSelect(data.get("EnterLocationNameToSearch"),data.get("SelectLocationAddress"));
			
			

			sspHomePage.select_ProductSearch_DisabledStartDate_InFromCalendar_Reservation();	
			sspHomePage.clickOnSearchYourParkingButton_Homepage();
			
	        SspProductsListPage sspProductsListPage = new SspProductsListPage(driver, test);
	        status=sspProductsListPage.verifyPageTitle(data.get("PageTitle_SSPProducts"));
	        Assert.assertEquals(status,data.get("ExpectedValueFAIL"),"user Navigated to Product list page");
	        
	        log("User remains in the Home page if selected disabled date and clicked on Search Your Parking");
		
	        //End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
