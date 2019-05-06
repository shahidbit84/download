package com.skidata.customListener;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.skidata.testBase.TestBase;

/**
 * @author shmo
 */
public class Listener extends TestBase implements ITestListener {
	
	

    public void onFinish(ITestContext arg0) {
    
        Reporter.log("Test is finished:" + arg0.getName());

    }

    public void onStart(ITestContext arg0) {

    	
   
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        

    }

    public void onTestFailure(ITestResult arg0) {
    	 Object currentClass = arg0.getInstance();
    	    @SuppressWarnings("unused")
			WebDriver driver = ((TestBase) currentClass).getDriver();
    	    
        if (!arg0.isSuccess()) {
//        	Date d = new Date();
//    		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
//    		String filePath = (System.getProperty("user.dir")) + "/src/main/java/com/skidata/screenshot/" + screenshotFile;
//    		// store screenshot in that file
//    		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//    		try {
//    			FileUtils.copyFile(scrFile, new File(filePath));
//    			Reporter.log("<a href='" + filePath + "'> <img src='" + filePath + "' height='100' width='100'/> </a>");
//    			
//    		} catch (IOException e) {
//
//    			e.printStackTrace();
//    		}
    		//test.log(LogStatus.INFO, test.addScreenCapture(filePath));
    		test.log(LogStatus.FAIL, "FAIL");
        }

    }


    public void onTestSkipped(ITestResult arg0) {
    	
        Reporter.log("Test is skipped:" + arg0.getMethod().getMethodName());
        

    }

    public void onTestStart(ITestResult arg0) {

    }

    public void onTestSuccess(ITestResult arg0) {
    	 Object currentClass = arg0.getInstance();
 	    @SuppressWarnings("unused")
		WebDriver driver = ((TestBase) currentClass).getDriver();

        if (arg0.isSuccess()) {
//        	Date d = new Date();
//    		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
//    		String filePath = (System.getProperty("user.dir")) + "/src/main/java/com/skidata/screenshot/" + screenshotFile;
//    		// store screenshot in that file
//    		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//    		try {
//    			FileUtils.copyFile(scrFile, new File(filePath));
//    			Reporter.log("<a href='" + filePath + "'> <img src='" + filePath + "' height='100' width='100'/> </a>");
//    		} catch (IOException e) {
//
//    			e.printStackTrace();
//    		}
//    		//test.log(LogStatus.INFO, test.addScreenCapture(filePath));
    		test.log(LogStatus.PASS, "PASS");
        }

    }
}