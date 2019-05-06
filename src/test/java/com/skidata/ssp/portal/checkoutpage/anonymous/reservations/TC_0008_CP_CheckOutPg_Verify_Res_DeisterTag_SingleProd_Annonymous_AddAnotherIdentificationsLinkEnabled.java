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
import com.skidata.uiPages.portal.SspSignUpPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

/**
 * @author shmo
 * 
 * 
 */

public class TC_0008_CP_CheckOutPg_Verify_Res_DeisterTag_SingleProd_Annonymous_AddAnotherIdentificationsLinkEnabled extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0008_CP_CheckOutPg_Verify_Res_DeisterTag_SingleProd_Annonymous_AddAnotherIdentificationsLinkEnabled.class.getName());

	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0008_CP_CheckOutPg_Verify_Res_DeisterTag_SingleProd_Annonymous_AddAnotherIdentificationsLinkEnabled";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=409,dataProvider = "getDataForTestCaseName", testName = "TC_0008_CP_CheckOutPg_Verify_Res_DeisterTag_SingleProd_Annonymous_AddAnotherIdentificationsLinkEnabled", description ="TC_0008_CP_CheckOutPg_Verify_Res_DeisterTag_SingleProd_Annonymous_AddAnotherIdentificationsLinkEnabled")
	public void ssp_TC_0008_CP_CheckOutPg_Verify_Res_DeisterTag_SingleProd_Annonymous_AddAnotherIdentificationsLinkEnabled(Hashtable<String, String> data)throws Throwable {


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
			sspProductsListPage.clickOnShoppingCartIcon();

			SspShoppingCartPage sspShoppingCartPage = new SspShoppingCartPage(driver,test);
			sspShoppingCartPage.clickonCheckout();
			
			SspCheckoutPage sspCheckoutPage = new SspCheckoutPage(driver,test);
			
			status=sspCheckoutPage.verifyPageTitle(data.get("PageTitle_Checkout"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of Checkout page");
			SspSignUpPage sspSignUpPage = new SspSignUpPage(driver, test);
			String UniqueEmailId=sspSignUpPage.emailCreation();
			sspCheckoutPage.enterEmailId(UniqueEmailId);
			sspCheckoutPage.addIdentificationDetails_SingleProduct(data.get("Identification1"));


			
			status=sspCheckoutPage.verifyAddAnotherIdentificationLinkDisplayed(data.get("AddAnotherIdentificationLabel"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Add another identification is not displayed");
			
			
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
