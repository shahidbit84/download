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
 * @author shmo
 * 
 * 
 */

public class TC_0021_CP_ProductsPg_Verify_AddSingleProduct_ListView_Verify_Elements_InCartPopUp extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0021_CP_ProductsPg_Verify_AddSingleProduct_ListView_Verify_Elements_InCartPopUp.class.getName());

	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0021_CP_ProductsPg_Verify_AddSingleProduct_ListView_Verify_Elements_InCartPopUp";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=221,dataProvider = "getDataForTestCaseName", testName = "TC_0021_CP_ProductsPg_Verify_AddSingleProduct_ListView_Verify_Elements_InCartPopUp", description ="TC_0021_CP_ProductsPg_Verify_AddSingleProduct_ListView_Verify_Elements_InCartPopUp")
	public void ssp_TC_0021_CP_ProductsPg_Verify_AddSingleProduct_ListView_Verify_Elements_InCartPopUp(Hashtable<String, String> data)throws Throwable {

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
			
			String firstproductExpectedName = sspProductsListPage.getProductName(1);
			String firstproductExpectedPrice = sspProductsListPage.getProductPrice(1);

			status= sspProductsListPage.addSingleProduct_IntoCart_Reservation_ListView();
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Product not added into cart");
			
			
			sspProductsListPage.hoverMouseOnCartPopUP();
			
			
			status=sspProductsListPage.verifyElementsAndProductDetailsInCartPopUp_ForSingleProduct(data.get("YourCartLabel"),firstproductExpectedName,firstproductExpectedPrice,
					data.get("FromLabelInCartPopUp"),data.get("ToLabelInCartPopUp"),data.get("TotalLabel"),data.get("LabelIncludesVat"),
					data.get("SeeCartLabelInCartPopUp"),data.get("CheckoutLabelInCartPopUp"));

			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the cart pop up");

			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
