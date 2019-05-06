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

public class TC_0016_CP_ShoppingCartPg_Verify_InEmptyCart_Labels_And_Header_After_Locale_Changes extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0016_CP_ShoppingCartPg_Verify_InEmptyCart_Labels_And_Header_After_Locale_Changes.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0016_CP_ShoppingCartPg_Verify_InEmptyCart_Labels_And_Header_After_Locale_Changes";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=1002,dataProvider = "getDataForTestCaseName", testName = "TC_0016_CP_ShoppingCartPg_Verify_InEmptyCart_Labels_And_Header_After_Locale_Changes", description ="TC_0016_CP_ShoppingCartPg_Verify_InEmptyCart_Labels_And_Header_After_Locale_Changes")
	public void ssp_TC_0016_CP_ShoppingCartPg_Verify_InEmptyCart_Labels_And_Header_After_Locale_Changes(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
		
			sspHomePage.SelectLocale();
			Thread.sleep(5000);

			SspProductsListPage sspProductsListPage = new SspProductsListPage(driver, test);

			sspProductsListPage.clickOnShoppingCartIcon();

			SspShoppingCartPage sspShoppingCartPage = new SspShoppingCartPage(driver, test);
//			status=sspShoppingCartPage.verifyDefaultEmptyCart_Message(data.get("EmptyCartMsg1"), data.get("EmptyCartMsg2ForUser"));
//			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Empty cart message");
			
			status=sspShoppingCartPage.verifyPage_EmptyCart_HeaderAndLabel(data.get("EmptyCartMessage1"), data.get("EmptyCartMessage2"), data.get("ContinueButton"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Empty cart message");
			
//			sspShoppingCartPage.clickOnLoginLinkInMessage();
			

			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
			
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
