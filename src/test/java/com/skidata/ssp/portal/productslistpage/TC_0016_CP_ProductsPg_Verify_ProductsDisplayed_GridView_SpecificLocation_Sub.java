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

public class TC_0016_CP_ProductsPg_Verify_ProductsDisplayed_GridView_SpecificLocation_Sub extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0016_CP_ProductsPg_Verify_ProductsDisplayed_GridView_SpecificLocation_Sub.class.getName());

	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0016_CP_ProductsPg_Verify_ProductsDisplayed_GridView_SpecificLocation_Sub";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=216,dataProvider = "getDataForTestCaseName", testName = "TC_0016_CP_ProductsPg_Verify_ProductsDisplayed_GridView_SpecificLocation_Sub", description ="TC_0016_CP_ProductsPg_Verify_ProductsDisplayed_GridView_SpecificLocation_Sub")
	public void ssp_TC_0016_CP_ProductsPg_Verify_ProductsDisplayed_GridView_SpecificLocation_Sub(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			sspHomePage.searchParkingLocationsAndSelect(data.get("EnterLocationNameToSearch"),data.get("SelectLocationAddress"));
			sspHomePage.clickOnSubscription();
			sspHomePage.select_ProductSearchStartDate_InFromCalendar_Subscription();
			sspHomePage.clickOnSearchYourParkingButton();

			SspProductsListPage sspProductsListPage = new SspProductsListPage(driver, test);

			status= sspProductsListPage.verifyProductListDisplayedForDefaultLocation_InListView();
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Products are not displayed in the List view");

			status= sspProductsListPage.verifyProductListDisplayedForDefaultLocation_InGridView();
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Products are not displayed in the Grid view");

			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
