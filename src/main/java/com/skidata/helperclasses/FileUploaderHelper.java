package com.skidata.helperclasses;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.testBase.TestBase;


/**
 *************************************************************************************************************
 * @Project SSP - CHBACKOFFICE AND PORTAL
 * @Description
 * FileUploaderHelper class will have method which will help to upload files
 * @author shmo
 * @version 1.0
 *************************************************************************************************************
 */
public class FileUploaderHelper extends TestBase{
	
	
	public static final Logger log = Logger.getLogger(FileUploaderHelper.class.getName());

	

	public FileUploaderHelper(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		
	}
	
	/**
	 * This is the method that we need to call when uploading a file in the
	 * application. the user will need to provide the browser name and the path
	 * of the file to upload.
	 * @param browser
	 * @param filePathToUpload
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	public void fileUploader(String browser, String filePathToUpload) throws IOException {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				Process process = new ProcessBuilder(System.getProperty("user.dir") + "\\filesToUpload\\upload.exe", filePathToUpload, "Open").start();
              
			} else if (browser.equalsIgnoreCase("firefox")) {
				Process process = new ProcessBuilder(
						System.getProperty("user.dir") + "\\filesToUpload\\uploadFirefox.exe", filePathToUpload, "Open").start();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail("Unable to upload");
		}

	}

}
