package com.skidata.helperclasses;

import java.util.LinkedList;
import java.util.Set;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.testBase.TestBase;



/**
 *************************************************************************************************************
 * @Project SSP - CHBACKOFFICE AND PORTAL
 * @Description
 * BrowserHelper class contains methods which will be used to handle Browser Actions
 * @author shmo
 * @version 1.0
 *************************************************************************************************************
 */
public class BrowserHelper extends TestBase{


	public static final Logger log = Logger.getLogger(BrowserHelper.class.getName());

	public BrowserHelper(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		
	}

	/**
	 *************************************************************************************************************
	 * Method to Navigate to the previous page
	 *************************************************************************************************************
	 */
	public void goBack() {
		driver.navigate().back();
		log("Navigated Back");
	}

	/**
	 *************************************************************************************************************
	 * Method to Navigate to the next page
	 *************************************************************************************************************
	 */
	public void goForward() {
		driver.navigate().forward();
		log("Navigated Forward");
	}

	/**
	 *************************************************************************************************************
	 * Method to refresh the page
	 *************************************************************************************************************
	 */
	public void refresh() {
		driver.navigate().refresh();
		log("Page is refreshed");
	}

	/**
	 *************************************************************************************************************
	 * Method to retrieve the window handles
	 *************************************************************************************************************
	 */
	public Set<String> getWindowHandles() {
		log("No of window handles is " +driver.getWindowHandle());
		return driver.getWindowHandles();
	}

	/**
	 *************************************************************************************************************
	 * Method to switch to a specific window
	 *************************************************************************************************************
	 */
	public void SwitchToWindow(int index) {

		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandles());

		if (index < 0 || index > windowsId.size()){
			throw new IllegalArgumentException("Invalid Index : " + index);
		}
		driver.switchTo().window(windowsId.get(index));
		log(index+"");
	}

	/**
	 *************************************************************************************************************
	 * Method to Switch to the parent window 
	 *************************************************************************************************************
	 */
	public void switchToParentWindow() {
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandles());
		driver.switchTo().window(windowsId.get(0));
		log("Switched to the Parent window");
	}

	/**
	 *************************************************************************************************************
	 * Method to Switch to the Parent and child and close child and parent
	 *************************************************************************************************************
	 */
	public void switchToParentWithChildClosed() {
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandles());

		for (int i = 1; i < windowsId.size(); i++) {
			log(windowsId.get(i));
			driver.switchTo().window(windowsId.get(i));
			driver.close();
		}

		switchToParentWindow();
	}
	

	/**
	 *************************************************************************************************************
	 * Method to switch to a specific frame
	 *************************************************************************************************************
	 */
	public void switchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
		log("Switched to the Frame id or Name "+nameOrId);
	}
	
	public void waitForPageLoadToComplete() {

		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            System.out.println("Current Window State       : "
	                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
	            return String
	                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
	                .equals("complete");
	        }
	    });
	}
	
	
	

}