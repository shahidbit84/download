package com.skidata.customListener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.skidata.testBase.TestBase;

/**
 * @author shmo
 */
public class Retry extends TestBase implements IRetryAnalyzer {
    public static final Logger log = Logger.getLogger(Retry.class.getName());
    private int retryCount = 0;
    private int maxRetryCount = 5;

    public boolean retry(ITestResult result) {
    	
    	if(result.getStatus()==2) {
        if (retryCount < maxRetryCount) {
        	
            test.log(LogStatus.WARNING,"Retrying test " + result.getName() + " with status " + getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " time(s).");
            Reporter.log("Retrying test " + result.getName() + " with status " + getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " time(s).");
            retryCount++;
            return true;
         }
    	}
		return false;
    	
    }

    public String getResultStatusName(int status) {
    	
        String resultName = null;
        if (status == 1)
            resultName = "SUCCESS";
        if (status == 2)
            resultName = "FAILURE";
        if (status == 3)
            resultName = "SKIP";
        return resultName;
    }

   

}
