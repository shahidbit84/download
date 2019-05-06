package com.skidata.helperclasses;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.testBase.TestBase;

/**
 *************************************************************************************************************
 * @Project SSP - CHBACKOFFICE AND PORTAL
 * @Description
 * DropDownHelper class will be used to handle the drop down in the UI  
 * @author shmo
 * @version 1.0
 *************************************************************************************************************
 */
public class DropDownHelper extends TestBase{
	
	public static final Logger log = Logger.getLogger(DropDownHelper.class.getName());

	public DropDownHelper(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		
	}
	
	/**
	 *************************************************************************************************************
	 * Method to Select by Visible Value 
	 * @param element
	 * @param visibleValue
	 *************************************************************************************************************
	 */
	public void SelectUsingVisibleValue(WebElement element,String visibleValue) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleValue);
		log("Locator : " + element + " Value : " + visibleValue);
	}

	
	/**
	 *************************************************************************************************************
	 * Method to return the Selected value of Drop down
	 * @param element
	 * @return valueSelected in dropDown
	 *************************************************************************************************************
	 */
	public String getSelectedValue(WebElement element) {
		String value = new Select(element).getFirstSelectedOption().getText();
		log("WebELement : " + element + " Value : "+ value);
		return value;
	}
	
	/**
	 *************************************************************************************************************
	 * Select value using the index
	 * @param element
	 * @param index
	 *************************************************************************************************************
	 */
	public void SelectUsingIndex(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
		log("Locator : " + element + " Value : " + index);
	}
	
	/**
	 *************************************************************************************************************
	 * Selecting the value by the visible text in the drop down
	 * @param element
	 * @param text
	 *************************************************************************************************************
	 */
	public void SelectUsingVisibleText(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		log("Locator : " + element + " Value : " + text);
	}
	
	/**
	 **************************************************************************************************************
	 * Returning all the drop down values that are part of the list
	 * @param locator
	 * @return Values in the List
	 **************************************************************************************************************
	 */
	public List<String> getAllDropDownValues(WebElement locator) {
		Select select = new Select(locator);
		List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();
		
		for (WebElement element : elementList) {
			log(element.getText());
			valueList.add(element.getText());
		}
		return valueList;
	}
}   