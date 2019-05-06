/**
 *
 */
package com.skidata.uiPages.portal;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.helperclasses.WaitHelper;
import com.skidata.testBase.TestBase;

/**
 * @author shmo
 * 
 */
public class SspUserProfilePage extends TestBase {

	
	
	String status=null;


	public static final Logger log = Logger.getLogger(SspUserProfilePage.class.getName());



	//Class constructor
	public SspUserProfilePage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

	}


	/**
	 ******************************************************************************************************
	 * Web Elements of PortalMainPage
	 ******************************************************************************************************
	 */

	@FindBy(xpath = "//span[@class='v-label' and text()='LOADING...']")
	public WebElement loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;

	@FindBys({	
		@FindBy(how=How.ID, using="logo"),
	})	public List<WebElement> allElementsInList_LogoImage;

	@FindBy(how=How.XPATH,using ="//a[@id='goToHome1']/div")
	WebElement label_HomeIcon;

	@FindBy(how=How.XPATH,using ="//a[@id='goToCart1']/div")
	WebElement label_CartIcon;

	


	/**
	 *****************************************************************************************************************
	 * Method to verify the Page Title
	 * @param _PageTitle
	 * @return
	 *****************************************************************************************************************
	 */
	public String verifyPageTitle(String _PageTitle) {
		status="FAIL";
		if(driver.getTitle().equals(_PageTitle)) {
			log("Title of the page is "+driver.getTitle());
			status="PASS";
			takeScreenShot();
		}
		return status;
	}


	/**
	 *****************************************************************************************************************
	 * Method to verify if logo is displayed in UI
	 * @return PASS or FAIL
	 * @throws InterruptedException 
	 *****************************************************************************************************************
	 */
	public String verifyLogoDisplayed() throws InterruptedException {
		status="FAIL";

		if(allElementsInList_LogoImage.size()==1) {
			log("Logo image is displayed in Product List page");
			WebElement logo = driver.findElement(By.id("logo"));
			highlightWebElement(driver, logo);
			takeScreenShot();
			status="PASS";
		}
		return status;


	}


	public void clickonHomeIcon() {
		WaitHelper wh = new WaitHelper(driver, test);
		wh.waitForElementToBeVisible(label_HomeIcon, driver, 20);
		label_HomeIcon.click();
		log("Clicked on the Home Icon");
	}


	
	

}