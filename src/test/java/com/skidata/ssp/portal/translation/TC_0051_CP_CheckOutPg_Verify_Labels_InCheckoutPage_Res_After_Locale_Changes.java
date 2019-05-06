/**
 *
 */
package com.skidata.ssp.portal.translation;

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
 * @author naan
 * 
 * 
 */

public class TC_0051_CP_CheckOutPg_Verify_Labels_InCheckoutPage_Res_After_Locale_Changes extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0051_CP_CheckOutPg_Verify_Labels_InCheckoutPage_Res_After_Locale_Changes.class.getName());

	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0051_CP_CheckOutPg_Verify_Labels_InCheckoutPage_Res_After_Locale_Changes";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=403,dataProvider = "getDataForTestCaseName", testName = "TC_0051_CP_CheckOutPg_Verify_Labels_InCheckoutPage_Res_After_Locale_Changes", description ="TC_0051_CP_CheckOutPg_Verify_Labels_InCheckoutPage_Res_After_Locale_Changes")
	public void ssp_TC_0051_CP_CheckOutPg_Verify_Labels_InCheckoutPage_Res_After_Locale_Changes(Hashtable<String, String> data)throws Throwable {


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
			sspProductsListPage.addProducts_IntoCart_Reservation_ListView();
			sspProductsListPage.clickOnShoppingCartIcon();

			SspShoppingCartPage sspShoppingCartPage = new SspShoppingCartPage(driver,test);
			sspShoppingCartPage.clickonCheckout();
			
            Thread.sleep(5000);
			
			sspHomePage.SelectLocale();
			Thread.sleep(5000);
			
			SspCheckoutPage sspCheckoutPage = new SspCheckoutPage(driver,test);
			
			status=sspCheckoutPage.verifyPageTitle(data.get("PageTitle_Checkout"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of Checkout page");

			status=sspCheckoutPage.verifyLabelsInCheckoutPageForReservation(data.get("CheckoutHeader"),data.get("LabelYourDetails"),
					data.get("LabelAreyouregistered"),data.get("LoginLinkText"),
					data.get("AddAddressLabel"),data.get("IdentificationLabel"),data.get("TermsAndCondition"),data.get("PrivacyPolicy"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Labels in the CheckoutPage");
			
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}