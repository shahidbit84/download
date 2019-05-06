package com.skidata.helperclasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.testBase.TestBase;


/**
 *************************************************************************************************************
 * @Project SSP - CHBACKOFFICE AND PORTAL
 * @Description
 * JavaScriptHelper class will have method which will help to upload files
 * @author shmo
 * @version 1.0
 *************************************************************************************************************
 */
public class JavaScriptHelper extends TestBase {

	
	public static final Logger log = Logger.getLogger(JavaScriptHelper.class.getName());

	public JavaScriptHelper(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		
	}

	private Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		log(script);
		return exe.executeScript(script);
	}

	private Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		log(script);
		return exe.executeScript(script, args);
	}

	/**
	 * Scroll to the Element on Web page
	 * @param element
	 */
	public void scrollToElement(WebElement element) {
		executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
		log("Scrolled to the Element on the web page"+ element.toString());
	}

	/**
	 * Scroll to element and click
	 * @param element
	 */
	public void scrollToElementAndClick(WebElement element) {
		scrollToElement(element);
		element.click();
		log("Scrolled to the web element on the web page and clicked on it"+ element.toString());
	}

	/**
	 * Scroll into view of the web element
	 * @param element
	 */
	public void scrollIntoView(WebElement element) {
		executeScript("arguments[0].scrollIntoView()", element);
		log("Scrolled into view for the web element"+ element.toString());
	}

	/**
	 * Scroll into view and click
	 * @param element
	 */
	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		log("Scrolled into view for the web element and clicked on it"+ element.toString());
	}

	/**
	 * Scroll down vertically
	 */
	public void scrollDownVertically() {
		executeScript("window.scrollTo(0, document.body.scrollHeight)");
		log("Scrolled down vertically");
	}

	/**
	 * Scroll up vertically
	 */
	public void scrollUpVertically() {
		executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		log("Scrolled up vertically");
	}

	/**
	 * Scrolling down vertically provide the x and y coordinate sample 0 ,200
	 * @param xCoordinate
	 * @param yCoordinate
	 */
	public void scrollDownByPixel(int xCoordinate , int yCoordinate) {
		executeScript("window.scrollBy(xCoordinate,yCoordinate)");
		log("Scrolled down by pixels");
	}
	
	/**
	 * Scroll down by pixel fixed in code 0 and 1500 x and y coordinate
	 */
	public void scrollDownByPixel() {
		executeScript("window.scrollBy(0,1500)");
		log("Scrolled down by pixels");
	}

	/**
	 * Scroll up by pixel sample input should be 0,-1000
	 * @param xCoordinate
	 * @param minusyCoordinate
	 */
	public void scrollUpByPixel(int xCoordinate , int minusyCoordinate) {
		executeScript("window.scrollBy(xCoordinate,minusyCoordinate)");
	}
	
	/**
	 * Scroll up by pixel 0,-1500
	 */
	public void scrollUpByPixel() {
		executeScript("window.scrollBy(0,-1500)");
	}

	/**
	 * Zoom in by 50 percent
	 */
	public void ZoomInBy50percentage() {
		executeScript("document.body.style.zoom='50%'");
	}
	
	/**
	 * Zoom in by 60 percent
	 */
	public void ZoomInBy60percentage() {
		executeScript("document.body.style.zoom='60%'");
	}
	
	/**
	 * Zoom in by 70 percent
	 */
	public void ZoomInBy70percentage() {
		executeScript("document.body.style.zoom='70%'");
	}
	
	/**
	 * Zoom in by 80 percent
	 */
	public void ZoomInBy80percentage() {
		executeScript("document.body.style.zoom='80%'");
	}
	
	/**
	 * Zoom in by 90 percent
	 */
	public void ZoomInBy90percentage() {
		executeScript("document.body.style.zoom='90%'");
	}

	/**
	 * Zoom in by 100 percent
	 */
	public void ZoomInBy100percentage() {
		executeScript("document.body.style.zoom='100%'");
	}
	
	public void ZoomInBy40percentage() {
		executeScript("document.body.style.zoom='40%'");
	}
	
	
	/**
	 * Zoom in by 150 percent
	 */
	public void ZoomInBy150percentage() {
		executeScript("document.body.style.zoom='150%'");
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @exception jgjhgjh
	 */
	public void ZoomInBy200percentage(String username, int password) {
		executeScript("document.body.style.zoom='200%'");
	}
	
	public boolean waitForJStoLoad() {

	    WebDriverWait wait = new WebDriverWait(driver, 60);

	    // wait for jQuery to load
	    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        try {
	          return ((Long)executeScript("return jQuery.active") == 0);
	        }
	        catch (Exception e) {
	          return true;
	        }
	      }
	    };

	    // wait for Javascript to load
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        return executeScript("return document.readyState")
	            .toString().equals("complete");
	      }
	    };

	  return wait.until(jQueryLoad) && wait.until(jsLoad);
	}
	
	
	
	
	
	
	
}