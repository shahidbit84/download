package com.skidata.helperclasses;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.testBase.TestBase;


/**
 * @author shmo
 * Helper class to provide methods for waiting
 */
public class WaitHelper extends TestBase{
	
	
	public static final Logger log = Logger.getLogger(WaitHelper.class.getName());

	
	public WaitHelper(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		
	}
	
//	public void setImplicitWait(long timeOutInSeconds, TimeUnit unit) {
//		log(timeOutInSeconds+"");
//		driver.manage().timeouts().implicitlyWait(timeOutInSeconds, unit == 1 ? TimeUnit.SECONDS : unit);
//	}
//	
//	public void setPageLoadTimeout(long timeOutInSeconds, TimeUnit unit) {
//		log(timeOutInSeconds+"");
//		driver.manage().timeouts().pageLoadTimeout(timeOutInSeconds, unit == null ? TimeUnit.SECONDS : unit);
//	}
	/**
	 * 
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(pollingEveryInMiliSec, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
	/**
	 * Method to wait for Element to be visible polling web page
	 * @param locator
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 */
	public void waitForElementToBeVisible(WebElement locator, int timeOutInSeconds, int pollingEveryInMiliSec) {
      //  log("waiting for element to be visible using locator" + locator.toString() );
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(locator));
	}
	/**
	 * Method to wait for Element to be Visible
	 * @param element
	 * @param driver
	 * @param timeOutInSeconds
	 */
	public void waitForElementToBeVisible( WebElement element,WebDriver driver, long timeOutInSeconds) {
		//log("waiting for element to be visible using element" + element.toString() );
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	/**
	 * Method to wait for element to be clickable
	 * @param element
	 * @param driver
	 * @param timeOutInSeconds
	 * @return
	 */
	public WebElement waitForElementToBeClickable(WebElement element,WebDriver driver,long timeOutInSeconds){
		//log("waiting for element to be clickable " + element.toString() );
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * Method to wait for element to be invisible
	 * @param element
	 * @param driver
	 * @param timeOutInSeconds
	 */
	public void waitForElementToBeInvisible(WebElement element,WebDriver driver, int timeOutInSeconds) {
		//log("waiting for element to be Invisible " + element.toString() );
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.invisibilityOf(element));

	}
	
	/**
	 * Method to wait for the Alert to display
	 * @param driver
	 * @param timeout
	 */
	public void waitForAlertToBeVisible(WebDriver driver, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.alertIsPresent());
		log("Alert found...");
	} 
	
	/**
	 * Method to wait for page title to change , in this we will wait till the title of page provided has changed
	 * @param driver
	 * @param timeout
	 * @param _ExpectedPageTitleToChange
	 */
	public void waitUntilPageTitleChanges(WebDriver driver, long timeout,String _ExpectedPageTitleToChange) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.not(ExpectedConditions.titleIs(_ExpectedPageTitleToChange)));
		log("Page Title Changed");
		takeScreenShot();
	} 
	
}
