package com.skidata.helperclasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.testBase.TestBase;



/**
 *************************************************************************************************************
 * @Project SSP - CHBACKOFFICE AND PORTAL
 * @Description
 * AlertHelper class contains methods which will be used to handle Alert pop up.
 * @author shmo
 * @version 1.0
 *************************************************************************************************************
 */
public class AlertHelper extends TestBase{

	
	
	public static final Logger log = Logger.getLogger(AlertHelper.class.getName());

	public AlertHelper(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		
	}

	public Alert getAlert(){
		log.info("alert test: "+driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}
	
	public void acceptAlert(){
		getAlert().accept();
		log.info("accept Alert is done...");
	}
	
	public void dismissAlert(){
		getAlert().dismiss();
		log.info("dismiss Alert is done...");
	}
	
	public String getAlertText(){
		String text = getAlert().getText();
		log.info("alert text: "+text);
		return text;
	}
	
	public boolean isAlertPresent(){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.alertIsPresent());
					driver.switchTo().alert();
			log.info("alert is present");
			return true;
		}
		catch(Exception e){
			log.info(e.getCause());
			return false;
		}
	}
	
	public void acceptAlertIfPresent(){
		if(isAlertPresent()){
			acceptAlert();
		}
		else{
			log.info("Alert is not present..");
		}
	}
	
	public void dismissAlertIfPresent(){
		if(isAlertPresent()){
			dismissAlert();
		}
		else{
			log.info("Alert is not present..");
		}
	}
	
	public void acceptPrompt(String text){
		if(isAlertPresent()){
			Alert alert = getAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("alert text: "+text);
		}
	}
}
