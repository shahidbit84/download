package com.skidata.util;

//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html


import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            Date d = new Date();
            String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".html";
            String reportPath = ConstantValues.EXTENTREPORT_FOLDER_PATH + fileName;
            
            //is actually creating the extent report instance using this instance we can do some actions like publish loadconfig
            extent = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);
            extent.loadConfig(new File(ConstantValues.EXTENT_REPORT_CONFIG_FILE));
            
            // optional
            //extent.addSystemInfo("Selenium Version", "2.53.0").addSystemInfo(
            //"Environment", "QA");
        }
        return extent;
    }
}
