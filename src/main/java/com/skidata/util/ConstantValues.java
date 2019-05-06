package com.skidata.util;

import java.util.Hashtable;

public class ConstantValues {
    public static final boolean GRID_RUN = false;

    //paths
    public static final String CHROME_DRIVER_EXE = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
    public static final String FIREFOX_DRIVER_EXE=System.getProperty("user.dir")+"\\src\\main\\resources\\geckodriver.exe";
    // public static final String FIREFOX_DRIVER_EXE = "D:\\skidata\\workspace\\Facebook_WithPageFactory\\src\\main\\resources\\geckodriver.exe";
    // URLs-uat
    public static final String UAT_HOMEPAGE_URL = "http://uat.facebook.com";
    public static final String UAT_USERNAME = "uat_rejishtest13@gmail.com";
    public static final String UAT_PASSWORD = "uat_testing@123";
    // URLs-prod
    public static final String PROD_HOMEPAGE_URL = "http://facebook.com";
    public static final String PROD_USERNAME = "rejishtest13@gmail.com";
    public static final String PROD_PASSWORD = "testing@12";
    
    
    
    


    //images and Files of SwebWallet
    public static final String BACKGROUND_IMG = System.getProperty("user.dir") +"\\filesToUpload\\Hintergrund-ticket.png";
    public static final String PREVIEW_IMG_SWEBWALLET = System.getProperty("user.dir") +"\\filesToUpload\\swebWallet\\preview.png";
    public static final String LEFTLOGO_IMG = System.getProperty("user.dir") + "\\filesToUpload\\ssp\\Logo-left.png";
    public static final String SWEBHTMLFRONT = System.getProperty("user.dir")+"\\filesToUpload\\SwebhtmlFront.html";
    public static final String SWEBHTMLBACK = System.getProperty("user.dir")+"\\filesToUpload\\SwebhtmlBack.html";
    public static final String SWEBHTMLPLACEHOLDERSFRONT = System.getProperty("user.dir")+"\\filesToUpload\\SwebPlaceholdershtmlFront.html";
    public static final String SWEBHTMLPLACEHOLDERSBACK = System.getProperty("user.dir")+"\\filesToUpload\\SwebPlaceholdershtmlBack.html";
    public static final String LOGO = System.getProperty("user.dir")+"\\filesToUpload\\Logo.png";
    public static final String LOGO99x99 = System.getProperty("user.dir")+"\\filesToUpload\\Logo99x99.png";
    public static final String LOGO159x159 = System.getProperty("user.dir")+"\\filesToUpload\\Logo159x159.png";
    public static final String LOGO336x336 = System.getProperty("user.dir")+"\\filesToUpload\\Logo336x336.png";
    public static final String HTMLBACKMSWALLET = System.getProperty("user.dir")+"\\filesToUpload\\mswallet\\htmlback.xml";
    public static final String PBBACKGROUNDIMG =System.getProperty("user.dir")+"\\filesToUpload\\Passbook\\background.png";
    public static final String PBICONIMG = System.getProperty("user.dir")+"\\filesToUpload\\Passbook\\icon.png";
    public static final String SWEB = System.getProperty("user.dir")+"\\filesToUpload\\sweb.png";
    public static final String AENA = System.getProperty("user.dir")+"\\filesToUpload\\aena.png";
    public static final String SDLOGO = System.getProperty("user.dir")+"\\filesToUpload\\sd-logo.png";
    public static final String PDFHTMLFRONT = System.getProperty("user.dir")+"\\filesToUpload\\PdfhtmlFront.html";
    public static final String PDFHTMLPLACEHOLDERSFRONT = System.getProperty("user.dir")+"\\filesToUpload\\PdfPlaceholdershtmlFront.html";
    public static final String PHANI ="sdkjfsjkdfhjksfh";

  
    public static final String ENV = "PROD"; //PROD, UAT,SAT


    //paths
    public static final String REPORTS_PATH = "D:\\reports\\";
    public static final String DATA_XLS_PATH = System.getProperty("user.dir") + "/src/main/java/com/skidata/data/TestDataSwebWallet.xlsx";
    public static final String DATA_XLS_PATH_BILLINGPROCESS = System.getProperty("user.dir") + "/src/main/java/com/skidata/data/TestDataBillingProcess.xlsx";
    public static final String DATA_XLS_PATH_BEICONFIGURATION = System.getProperty("user.dir") + "/src/main/java/com/skidata/data/TestDataBeiConfiguration.xlsx";
    public static final String DATA_XLS_PATH_SWEBWALLETTENANTS= System.getProperty("user.dir") + "/src/main/java/com/skidata/data/TestDataSwebwalletTenant.xlsx";
    public static final String DATA_XLS_PATH_CHBACKOFFICE = System.getProperty("user.dir") + "/src/main/java/com/skidata/data/TestDataChbackoffice.xlsx";
    public static final String DATA_XLS_PATH_PORTAL = System.getProperty("user.dir") + "/src/main/java/com/skidata/data/TestDataPortal.xlsx";
    public static final String TESTDATA_SHEET = "TestData";
    public static final String RUNMODE_COL = "Runmode";
    public static final String TESTCASES_SHEET = "TestCases";
    public static final String INVOICESKIDATAZIP = System.getProperty("user.dir") + "\\filesToUpload\\billingprocess\\invoice_skidata.zip";
    public static final String PRINTATHOMETEMPLATEZIP = System.getProperty("user.dir") + "\\filesToUpload\\billingprocess\\barcode.zip";
	public static final String SCREENSHOT_FOLDER_RELATIVEPATH = "screenshots/";
	public static final String SCRIPTVIDEOS_FOLDER_RELATIVEPATH = "ScriptVideos/";
	public static final String SCREENSHOT_FOLDER_ABSOLUTEPATH = System.getProperty("user.dir") + "/extentreports/screenshots/";
	public static final String SCRIPTVIDEOS_FOLDER_ABSOLUTEPATH = System.getProperty("user.dir") + "/extentreports/scriptvideos/";
	public static final String EXTENTREPORT_FOLDER_PATH = System.getProperty("user.dir") + "/extentreports/";
	public static final String EXTENT_REPORT_CONFIG_FILE = System.getProperty("user.dir") + "//extentReportConfigFile.xml";
	public static final String SALESCHANNELLOGO = System.getProperty("user.dir")+"\\filesToUpload\\ssp_saleschannel\\Logo-left.png";
	public static final String DOWNLOAD_PDF_ETICKET_FOLDER = System.getProperty("user.dir")+"\\downloadedfiles";

	

	
    public static Hashtable<String, String> table;

	

    public static Hashtable<String, String> getEnvDetails() {
        if (table == null) {
            table = new Hashtable<String, String>();
            if (ENV.equals("PROD")) {
                table.put("url", PROD_HOMEPAGE_URL);
                table.put("username", PROD_USERNAME);
                table.put("password", PROD_PASSWORD);
            } else if (ENV.equals("UAT")) {
                table.put("url", UAT_HOMEPAGE_URL);
                table.put("username", UAT_USERNAME);
                table.put("password", UAT_PASSWORD);
            }

        }
        return table;

    }


}
