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

import com.skidata.helperclasses.DateAndUniqueNoGenerateHelper;
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

public class TC_0013_CP_ProductsPg_Verify_ProdsDisp_DefaultListView_SpecificLocation_Res extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0013_CP_ProductsPg_Verify_ProdsDisp_DefaultListView_SpecificLocation_Res.class.getName());

	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0013_CP_ProductsPg_Verify_ProdsDisp_DefaultListView_SpecificLocation_Res";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=213,dataProvider = "getDataForTestCaseName", testName = "TC_0013_CP_ProductsPg_Verify_ProdsDisp_DefaultListView_SpecificLocation_Res", description ="TC_0013_CP_ProductsPg_Verify_ProdsDisp_DefaultListView_SpecificLocation_Res")
	public void ssp_TC_0013_CP_ProductsPg_Verify_ProdsDisp_DefaultListView_SpecificLocation_Res(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			DateAndUniqueNoGenerateHelper dateAndUniqueNoGenerateHelper = new DateAndUniqueNoGenerateHelper();
			String endDate=dateAndUniqueNoGenerateHelper.get_PreviousDate_OrFutureDate("MM/dd/yyyy",data.get("AddOrMinusDate"));

			sspHomePage.searchParkingLocationsAndSelect(data.get("EnterLocationNameToSearch"),data.get("SelectLocationAddress"));
			sspHomePage.select_ProductSearchStartDate_InFromCalendar_Reservation();
			sspHomePage.select_ProductSearchEndDate_InToCalendar_Reservation(endDate);
				
			sspHomePage.clickOnSearchYourParkingButton();
			
	        SspProductsListPage sspProductsListPage = new SspProductsListPage(driver, test);
	      
	        
	       status= sspProductsListPage.verifyProductListDisplayedForDefaultLocation_InListView();
	       Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Products are not displayed in the List view");
	        
	        
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
