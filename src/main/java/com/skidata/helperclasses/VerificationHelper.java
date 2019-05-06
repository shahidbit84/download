package com.skidata.helperclasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.testBase.TestBase;


/**
 * @author shmo
 * 
 */
public class VerificationHelper extends TestBase{

	public static final Logger log = Logger.getLogger(JavaScriptHelper.class.getName());
	
	public VerificationHelper(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		
	}

	public boolean verifyElementPresent(WebElement element) {
		boolean isDispalyed = false;
		try {
			 isDispalyed= element.isDisplayed();
			 log(element.getText()+" is dispalyed");
		}
		catch(Exception ex) {
			log("Element not found " + ex);
		}
		
		return isDispalyed;
	}
	
	public static synchronized boolean verifyElementNotPresent(WebElement element) {
		boolean isDispalyed = false;
		try {
			 element.isDisplayed();
			 log.info(element.getText()+" is dispalyed");
		}
		catch(Exception ex) {
			log.error("Element not found " + ex);
			isDispalyed = true;
		}
		
		return isDispalyed;
	}
	
	public static synchronized boolean verifyTextEquals(WebElement element,String expectedText) {
		boolean flag = false;
		try {
			String actualText=element.getText();
			if(actualText.equals(expectedText)) {
				log.info("actualText is :"+actualText+" expected text is: "+expectedText);
				return flag=true;
			}
			else {
				log.error("actualText is :"+actualText+" expected text is: "+expectedText);
				return flag;
			}
		}
		catch(Exception ex) {
			log.error("actualText is :"+element.getText()+" expected text is: "+expectedText);
			log.info("text not matching" + ex);
			return flag;
		}
	}
}