package com.skidata.helperclasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.testBase.TestBase;


/**
 * @author shmo
 * Helper class to provide methods for waiting
 */
public class MouseKeyboardHelper extends TestBase{
	Robot rb;
	
	
	public static final Logger log = Logger.getLogger(MouseKeyboardHelper.class.getName());

	
	public MouseKeyboardHelper(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		
	}
	
	public void pressEscapeKeyAndRelease() throws AWTException {
		rb = new Robot();
		rb.keyPress(KeyEvent.VK_ESCAPE);
		rb.keyRelease(KeyEvent.VK_ESCAPE);
  }
	
	public void pressDownArrowKeyAndRelease() throws AWTException {
		rb = new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
  }
	
	public void pressEnterKeyAndRelease() throws AWTException {
		rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
  }
	
	public void pressTabKeyAndRelease() throws AWTException {
		rb = new Robot();
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
  }
	
	public void mousehoverOnElement(WebElement element,WebDriver driver) {
		Actions action = new Actions(driver); 
        action.moveToElement(element).build().perform();
        
 
	}
	
}
