package com.skidata.util;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import com.skidata.excelReader.Xls_Reader;

public class DataUtil{
	static Xls_Reader xls =null;
	
	public Object[][] getDataForTestCaseName(String excelLocation, String testCaseName) throws FileNotFoundException {
		
		Object[][] data = null;
		Xls_Reader xls = new Xls_Reader(excelLocation);
    	
        String sheetName = ConstantValues.TESTDATA_SHEET;
      
        
        int testStartRowNum = 1;
        int rowcount = xls.getRowCount(sheetName);
        System.out.println(rowcount);
       
        while (!xls.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName)) {
            testStartRowNum++;
            if(testStartRowNum>rowcount) {
            	System.out.println(testCaseName+" TEST CASE NAME NOT FOUND IN THE DATA SOURCE");
            	break;
            }
        }
        System.out.println("Test starts from row - " + testStartRowNum);
        int colStartRowNum = testStartRowNum + 1;
        int dataStartRowNum = testStartRowNum + 2;

        // calculate rows of data
        int rows = 0;
        while (!xls.getCellData(sheetName, 0, dataStartRowNum + rows).equals("")) {
            rows++;
        }
        System.out.println("Total rows are  - " + rows);

        //calculate total cols
        int cols = 0;
        while (!xls.getCellData(sheetName, cols, colStartRowNum).equals("")) {
            cols++;
        }
        System.out.println("Total cols are  - " + cols);
        data = new Object[rows][1];
        //read the data
        int dataRow = 0;
        Hashtable<String, String> table = null;
        for (int rNum = dataStartRowNum; rNum < dataStartRowNum + rows; rNum++) {
            table = new Hashtable<String, String>();
            for (int cNum = 0; cNum < cols; cNum++) {
                String key = xls.getCellData(sheetName, cNum, colStartRowNum);
                String value = xls.getCellData(sheetName, cNum, rNum);
                table.put(key, value);
               
            }
            data[dataRow][0] = table;
            dataRow++;
        }
		
        
        return data;
    }

    public  boolean isTestExecutable(String excelLocation, String testCaseName) {
    	xls = new Xls_Reader(excelLocation);
        int rows = xls.getRowCount(ConstantValues.TESTCASES_SHEET);
        for (int rNum = 2; rNum <= rows; rNum++) {
            String tcid = xls.getCellData(ConstantValues.TESTCASES_SHEET, "TCID", rNum);
            if (tcid.equals(testCaseName)) {
                String Runmode = xls.getCellData(ConstantValues.TESTCASES_SHEET, "Runmode", rNum);
                if (Runmode.equals("Y"))
                    return true;
                else
                    return false;

            }
        }
        return false;
    }


    public String getUrl(String excelLocation, String testCaseName) {
    	xls = new Xls_Reader(excelLocation);
        int rows = xls.getRowCount(ConstantValues.TESTCASES_SHEET);
        for (int rNum = 2; rNum <= rows; rNum++) {
            String tcid = xls.getCellData(ConstantValues.TESTCASES_SHEET, "TCID", rNum);
            if (tcid.equals(testCaseName)) {
                String url = xls.getCellData(ConstantValues.TESTCASES_SHEET, "PortalURL", rNum);
                if (!url.equals(""))
                    return url;
                else
                  System.out.println("URL is missing for the " + testCaseName + " in the TestCases Sheet of Dataprovider");
                return null;

            }
        }
        return null;
    }
    
    public  String recordingOption(String excelLocation, String testCaseName) {
    	xls = new Xls_Reader(excelLocation);
        int rows = xls.getRowCount(ConstantValues.TESTCASES_SHEET);
        for (int rNum = 2; rNum <= rows; rNum++) {
            String tcid = xls.getCellData(ConstantValues.TESTCASES_SHEET, "TCID", rNum);
            if (tcid.equals(testCaseName)) {
                String screenRecording = xls.getCellData(ConstantValues.TESTCASES_SHEET, "ScreenRecording", rNum);
                if (!screenRecording.equals(""))
                    return screenRecording;
                else
                	System.out.println("Screen Recording is missing Y or N for the " + testCaseName + " in the TestCases Sheet of Dataprovider");
                return null;

            }
        }
        return null;
    }
    
    
    public  String chBackofficeURL(String excelLocation, String testCaseName) {
    xls = new Xls_Reader(excelLocation);
        int rows = xls.getRowCount(ConstantValues.TESTCASES_SHEET);
        for (int rNum = 2; rNum <= rows; rNum++) {
            String tcid = xls.getCellData(ConstantValues.TESTCASES_SHEET, "TCID", rNum);
            if (tcid.equals(testCaseName)) {
                String ChBackOfficeURL = xls.getCellData(ConstantValues.TESTCASES_SHEET, "ChBackOfficeURL", rNum);
                if (!ChBackOfficeURL.equals(""))
                    return ChBackOfficeURL;
                else
                return null;

            }
        }
        return null;
    }
    
    public  String chBackofficeAdminId(String excelLocation, String testCaseName) {
    	xls = new Xls_Reader(excelLocation);
        int rows = xls.getRowCount(ConstantValues.TESTCASES_SHEET);
        for (int rNum = 2; rNum <= rows; rNum++) {
            String tcid = xls.getCellData(ConstantValues.TESTCASES_SHEET, "TCID", rNum);
            if (tcid.equals(testCaseName)) {
                String ChBackofficeLoginID = xls.getCellData(ConstantValues.TESTCASES_SHEET, "AdminTenantId", rNum);
                if (!ChBackofficeLoginID.equals(""))
                    return ChBackofficeLoginID;
                else
                return null;

            }
        }
        return null;
    }
    
    
    public  String chBackofficeLoginID(String excelLocation, String testCaseName) {
    	xls = new Xls_Reader(excelLocation);
        int rows = xls.getRowCount(ConstantValues.TESTCASES_SHEET);
        for (int rNum = 2; rNum <= rows; rNum++) {
            String tcid = xls.getCellData(ConstantValues.TESTCASES_SHEET, "TCID", rNum);
            if (tcid.equals(testCaseName)) {
                String ChBackofficeLoginID = xls.getCellData(ConstantValues.TESTCASES_SHEET, "ChBackofficeLoginID", rNum);
                if (!ChBackofficeLoginID.equals(""))
                    return ChBackofficeLoginID;
                else
                return null;

            }
        }
        return null;
    }

	public  String chBackofficeLoginPassword(String excelLocation, String testCaseName) {
		xls = new Xls_Reader(excelLocation);
        int rows = xls.getRowCount(ConstantValues.TESTCASES_SHEET);
        for (int rNum = 2; rNum <= rows; rNum++) {
            String tcid = xls.getCellData(ConstantValues.TESTCASES_SHEET, "TCID", rNum);
            if (tcid.equals(testCaseName)) {
                String ChBackofficeLoginPassword = xls.getCellData(ConstantValues.TESTCASES_SHEET, "ChBackofficeLoginPassword", rNum);
                if (!ChBackofficeLoginPassword.equals(""))
                    return ChBackofficeLoginPassword;
                else
                return null;

            }
        }
        return null;
    }

	public  String tenantName(String excelLocation, String testCaseName) {
	xls = new Xls_Reader(excelLocation); 
        int rows = xls.getRowCount(ConstantValues.TESTCASES_SHEET);
        for (int rNum = 2; rNum <= rows; rNum++) {
            String tcid = xls.getCellData(ConstantValues.TESTCASES_SHEET, "TCID", rNum);
            if (tcid.equals(testCaseName)) {
                String TenantName = xls.getCellData(ConstantValues.TESTCASES_SHEET, "TenantName", rNum);
                if (!TenantName.equals(""))
                    return TenantName;
                else
                return null;

            }
        }
        return null;
    }

    

}