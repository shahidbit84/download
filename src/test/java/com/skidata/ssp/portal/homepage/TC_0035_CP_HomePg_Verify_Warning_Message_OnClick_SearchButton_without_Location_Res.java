package com.skidata.ssp.portal.homepage;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skidata.helperclasses.DateAndUniqueNoGenerateHelper;
import com.skidata.testBase.TestBase;
import com.skidata.uiPages.portal.SspHomePage;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;

public class TC_0035_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_Location_Res extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0035_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_Location_Res.class.getName());

	
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0035_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_Location_Res";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=35,dataProvider = "getDataForTestCaseName", testName = "TC_0035_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_Location_Res", description ="TC_0035_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_Location_Res")
	public void ssp_TC_0035_CP_HomePg_Verify_Warning_Message_OnClick_SearchButton_without_Location_Res(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);
			DateAndUniqueNoGenerateHelper dateAndUniqueNoGenerateHelper = new DateAndUniqueNoGenerateHelper();
			String endDate=dateAndUniqueNoGenerateHelper.get_PreviousDate_OrFutureDate("MM/dd/yyyy",data.get("AddOrMinusDate"));

			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			
			//Verifying Warning message appears after selecting SEARCH YOUR PARKING button with entering FROM and TO dates.
			sspHomePage.select_ProductSearchStartDate_InFromCalendar_Reservation();
			
			sspHomePage.select_ProductSearchEndDate_InToCalendar_Reservation(endDate);
			sspHomePage.clickOnSearchYourParkingButton_Homepage();
			
			status=sspHomePage.VerifyWarningMessageToSelectFromAndTodatesOrLocation(data.get("WarningMessageLabel"));
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Warning messages is not matching");
			
			
	
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
