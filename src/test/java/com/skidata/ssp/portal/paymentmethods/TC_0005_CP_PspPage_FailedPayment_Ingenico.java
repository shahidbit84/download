package com.skidata.ssp.portal.paymentmethods;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skidata.helperclasses.DateAndUniqueNoGenerateHelper;
import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspBookingConfirmationPage;
import com.skidata.uiPages.portal.SspCheckoutPage;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.uiPages.portal.SspProductsListPage;
import com.skidata.uiPages.portal.SspPspPage;
import com.skidata.uiPages.portal.SspShoppingCartPage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

public class TC_0005_CP_PspPage_FailedPayment_Ingenico extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0005_CP_PspPage_FailedPayment_Ingenico.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0005_CP_PspPage_FailedPayment_Ingenico";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=1305,dataProvider = "getDataForTestCaseName", testName = "TC_0005_CP_PspPage_FailedPayment_Ingenico", description ="TC_0005_CP_PspPage_FailedPayment_Ingenico")
	public void ssp_TC_0005_CP_PspPage_FailedPayment_Ingenico(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);
		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			DateAndUniqueNoGenerateHelper dateAndUniqueNoGenerateHelper = new DateAndUniqueNoGenerateHelper();
			String endDate=dateAndUniqueNoGenerateHelper.get_PreviousDate_OrFutureDate("MM/dd/yyyy",data.get("AddOrMinusDate"));

			sspHomePage.select_ProductSearchStartDate_InFromCalendar_Reservation();
			sspHomePage.select_ProductSearchEndDate_InToCalendar_Reservation(endDate);
			sspHomePage.clickOnSearchYourParkingButton();

			SspProductsListPage sspProductsListPage = new SspProductsListPage(driver, test);
			status= sspProductsListPage.verifyProductListDisplayedForDefaultLocation_InListView();
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Products are not displayed in the List view");
			sspProductsListPage.addProducts_IntoCart_Reservation_ListView();
			sspProductsListPage.clickOnShoppingCartIcon();

			SspShoppingCartPage sspShoppingCartPage = new SspShoppingCartPage(driver, test);
			sspShoppingCartPage.clickonCheckout();
			
			SspCheckoutPage sspCheckoutPage = new SspCheckoutPage(driver, test);
			
			status=sspCheckoutPage.verifyPageTitle(data.get("PageTitle_Checkout"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Page title of Checkout page");

		
			sspCheckoutPage.enterEmailId(data.get("EmailId"));
			sspCheckoutPage.addIdentificationDetails(data.get("Identification1"));
			
			sspCheckoutPage.clickon_TermsAndCondition_And_PrivacyPolicy_Checkbox();
			sspCheckoutPage.clickOnPay();
			SspPspPage SspPspPages=new SspPspPage(driver, test);
			
			//to cancel the payment via ingenico
			SspPspPages.clickCancelIngenicoPayement();
			
			
			SspBookingConfirmationPage sspBookingConfirmationPage = new SspBookingConfirmationPage(driver, test);
			Thread.sleep(35000);
			status=sspBookingConfirmationPage.verifyPageTitle(data.get("PageTitle_Failed"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Reservation Failed, User in CheckoutPage");
			
			log(driver.getTitle());
			
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}