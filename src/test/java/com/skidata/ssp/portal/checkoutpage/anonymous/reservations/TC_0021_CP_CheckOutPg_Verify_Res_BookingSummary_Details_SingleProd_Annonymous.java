/**
 *
 */
package com.skidata.ssp.portal.checkoutpage.anonymous.reservations;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skidata.helperclasses.DateAndUniqueNoGenerateHelper;
import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspCheckoutPage;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.uiPages.portal.SspProductsListPage;
import com.skidata.uiPages.portal.SspShoppingCartPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author shmo
 * 
 * 
 */

public class TC_0021_CP_CheckOutPg_Verify_Res_BookingSummary_Details_SingleProd_Annonymous extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0021_CP_CheckOutPg_Verify_Res_BookingSummary_Details_SingleProd_Annonymous.class.getName());

	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0021_CP_CheckOutPg_Verify_Res_BookingSummary_Details_SingleProd_Annonymous";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=420,dataProvider = "getDataForTestCaseName", testName = "TC_0021_CP_CheckOutPg_Verify_Res_BookingSummary_Details_SingleProd_Annonymous", description ="TC_0021_CP_CheckOutPg_Verify_Res_BookingSummary_Details_SingleProd_Annonymous")
	public void ssp_TC_0021_CP_CheckOutPg_Verify_Res_BookingSummary_Details_SingleProd_Annonymous(Hashtable<String, String> data)throws Throwable {


		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver,test);
			sspHomePage.clickOnGotIt();
			DateAndUniqueNoGenerateHelper dateAndUniqueNoGenerateHelper = new DateAndUniqueNoGenerateHelper();
			String endDate=dateAndUniqueNoGenerateHelper.get_PreviousDate_OrFutureDate("MM/dd/yyyy",data.get("AddOrMinusDate"));

			sspHomePage.searchParkingLocationsAndSelect(data.get("EnterLocationNameToSearch"),data.get("SelectLocationAddress"));
			sspHomePage.select_ProductSearchStartDate_InFromCalendar_Reservation();
			sspHomePage.select_ProductSearchEndDate_InToCalendar_Reservation(endDate);
			sspHomePage.clickOnSearchYourParkingButton();

			SspProductsListPage sspProductsListPage = new SspProductsListPage(driver,test);
			status= sspProductsListPage.verifyProductListDisplayedForDefaultLocation_InListView();
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Products are not displayed in the List view");
		
			
			sspProductsListPage.addSingleProduct_IntoCart_Reservation_ListView();
			String firstProductName = sspProductsListPage.getProductName(1);
			String firstProductPrice=sspProductsListPage.getProductPrice(1);
			
			String fromTimeExpected = sspProductsListPage.getSelected_FROM_DateTime_InProductsPage_ForCheckoutAndConfirmation();
			log(fromTimeExpected);
			String toTimeExpected = sspProductsListPage.getSelected_TO_DateTime_InProductsPage_ForCheckoutAndConfirmation();
			log(toTimeExpected);
			
			
			
			sspProductsListPage.clickOnShoppingCartIcon();

			SspShoppingCartPage sspShoppingCartPage = new SspShoppingCartPage(driver,test);
			
			
			//String expectedVatValue = sspShoppingCartPage.getValueAddedTaxesAmount();
			@SuppressWarnings("unused")
			String expectedTotalValue = sspShoppingCartPage.getTotalAmountFromCartPage();
			
			sspShoppingCartPage.clickonCheckout();
			
			SspCheckoutPage sspCheckoutPage = new SspCheckoutPage(driver,test);
			
			status=sspCheckoutPage.verifyPageTitle(data.get("PageTitle_Checkout"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of Checkout page");

			status=sspCheckoutPage.verifyBookingSummary_ProductName_ProductPrice(firstProductName,firstProductPrice);
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Product name or price in booking summary Checkout page");
			
			status=sspCheckoutPage.verifyFromToValuesInBookingSummary(fromTimeExpected,toTimeExpected);
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the FROM and TO values for product booking summary");
		
			
//			status=sspCheckoutPage.verifyValueAddedTaxes_AndTotalAmountInBookingSummary(expectedTotalValue);
//			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the FROM and TO values for product booking summary");
			
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
