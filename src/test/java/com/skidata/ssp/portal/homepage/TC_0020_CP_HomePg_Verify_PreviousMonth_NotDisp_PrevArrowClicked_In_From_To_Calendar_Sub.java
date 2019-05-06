/**
 *
 */
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

/**
 * @author shmo
 * 
 * 
 */

public class TC_0020_CP_HomePg_Verify_PreviousMonth_NotDisp_PrevArrowClicked_In_From_To_Calendar_Sub extends TestBase {

	public static final Logger log = Logger.getLogger(TC_0020_CP_HomePg_Verify_PreviousMonth_NotDisp_PrevArrowClicked_In_From_To_Calendar_Sub.class.getName());
	public String status=null;
	DataUtil dataUtil = new DataUtil();

	String testName = "TC_0020_CP_HomePg_Verify_PreviousMonth_NotDisp_PrevArrowClicked_In_From_To_Calendar_Sub";

	@DataProvider
	public Object[][] getDataForTestCaseName() throws FileNotFoundException {
		return dataUtil.getDataForTestCaseName(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
	}

	@Test(groups = {"smoke,regression"},timeOut=800000,priority=20,dataProvider = "getDataForTestCaseName", testName = "TC_0020_CP_HomePg_Verify_PreviousMonth_NotDisp_PrevArrowClicked_In_From_To_Calendar_Sub", description ="TC_0020_CP_HomePg_Verify_PreviousMonth_NotDisp_PrevArrowClicked_In_From_To_Calendar_Sub")
	public void ssp_TC_0020_CP_HomePg_Verify_PreviousMonth_NotDisp_PrevArrowClicked_In_From_To_Calendar_Sub(Hashtable<String, String> data)throws Throwable {

		runCheck(data,testName);

		//Start of the execution of test case 
		try {
			
			readTestCaseSheetColumns(ConstantValues.DATA_XLS_PATH_PORTAL, testName);
			init(data.get("Browser"), portalURL,testName,screenRecording);


			SspHomePage sspHomePage = new SspHomePage(driver, test);
			sspHomePage.clickOnGotIt();
			sspHomePage.clickOnSubscription();
			sspHomePage.clickOnPreviousArrow_FromMonthCalendarForReservation();
			
			DateAndUniqueNoGenerateHelper dateAndUniqueNoGenerateHelper = new DateAndUniqueNoGenerateHelper();
			String currentMonth = dateAndUniqueNoGenerateHelper.get_CurrentSystem_Day_Month_Year_Time_Minute_MilliSecond_AMPM("month","dd/MMMMMMMMMMM/yy/HH/mm/ss/a");
			String currentYear = dateAndUniqueNoGenerateHelper.get_CurrentSystem_Day_Month_Year_Time_Minute_MilliSecond_AMPM("year","dd/MM/yyyy/HH/mm/ss/a");
			
			log("The current Month and year expected in portal is ->"+ currentMonth+" "+currentYear);
			
			String currentMonthYear = currentMonth+" "+currentYear;
					
			status=sspHomePage.verify_MonthYear_ValueDisplayedIn_FromCalendar(currentMonthYear);
			Assert.assertEquals(status,data.get("ExpectedValuePASS"),"Mismatch in the Month Year displayed in From Calendar");
			
			
		
	
			//End of Test Case
			log("====Ended " + testName + " Testcase====");

		}	
		catch(Throwable e) {
			  HandlingErrorOrException(e);
		}

	}

}
