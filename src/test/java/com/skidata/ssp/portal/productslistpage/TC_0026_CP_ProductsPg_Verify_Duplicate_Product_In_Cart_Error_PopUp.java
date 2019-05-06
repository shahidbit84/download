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

/**nmn
 * @author naan
 * 
 * 
 */

public class TC_0026_CP_ProductsPg_Verify_Duplicate_Product_In_Cart_Error_PopUp extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0026_CP_ProductsPg_Verify_Duplicate_Product_In_Cart_Error_PopUp.class.getName());

	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0026_CP_ProductsPg_Verify_Duplicate_Product_In_Cart_Error_PopUp";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=226,dataProvider = "getDataForTestCaseName", testName = "TC_0026_CP_ProductsPg_Verify_Duplicate_Product_In_Cart_Error_PopUp", description ="TC_0026_CP_ProductsPg_Verify_Duplicate_Product_In_Cart_Error_PopUp")
	public void ssp_TC_0026_CP_ProductsPg_Verify_Duplicate_Product_In_Cart_Error_PopUp(Hashtable<String, String> data)throws Throwable {

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

		

			status= sspProductsListPage.addSingleProduct_IntoCart_Reservation_ListView();
			
			status= sspProductsListPage.addSingleProduct_IntoCart_Reservation_ListView();
			
			
			
			
			status=sspProductsListPage.verifyDuplicateCart_Message_Displayed(data.get("popup_text_message"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Pop Up test message displayed correctly");
			
			status= sspProductsListPage.DuplicateCart_PopUp_Ok_Button();
			
			status= sspProductsListPage.addSingleProduct_IntoCart_Reservation_ListView();
			
			status= sspProductsListPage.DuplicateCart_PopUp_X_Button();
			
		

			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
