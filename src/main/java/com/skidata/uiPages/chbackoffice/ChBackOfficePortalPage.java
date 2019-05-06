/**
 *
 */
package com.skidata.uiPages.chbackoffice;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.helperclasses.MouseKeyboardHelper;
import com.skidata.helperclasses.WaitHelper;
import com.skidata.testBase.TestBase;

/**
 * @author shmo
 */
public class ChBackOfficePortalPage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;
	//Constructor of the class
	public ChBackOfficePortalPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

	}
	

	public static final Logger log = Logger.getLogger(ChBackOfficePortalPage.class.getName());
	public boolean isTrue = true;


	@FindBy(xpath = "//div[@class='task-close ng-scope']")
	public WebElement taskcloseicon;
	
	/**
	 * Method to click on X task header Control icon
	 */
	public void clickonXtaskHeaderControlicon() {
		taskcloseicon.click();
		log("clicked on the X icon in the Task Header label");
		takeScreenShot();
	}


	/**
	 ******************************************************************************************************
	 * Web Elements of the page
	 ******************************************************************************************************
	 */
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='CHPortal.AppLauncherLabel']")
	public WebElement appLauncherIcon;

	@FindBy(xpath = "//input[@ng-model='portalAppLauncher.searchValue' and @placeholder='Search']")
	public WebElement searchAppInputField;

	@FindBy(xpath = "//button[@class='ng-scope' and @translate='Regional headoffices']")
	public WebElement RegionalheadquartersIcon;

	@FindBy(xpath = "//button[@class='ng-scope' and @translate='Generic organization units']")
	public WebElement UnitsIcon;

	@FindBy(xpath = "//button[@class='ng-scope' and @translate='Sales channel']")
	public WebElement SalesChannelIcon;

	@FindBy(xpath = "//button[@class='ng-scope' and @translate='Facilities']")
	public WebElement SalesFacilitiesIcon;

	@FindBy(xpath = "//button[@class='ng-scope' and @translate='Car park']")
	public WebElement CarparkIcon;

	@FindBy(xpath = "//button[@class='ng-scope' and @translate='Portfolios']")
	public WebElement PortfoliosIcon;

	@FindBy(xpath = "//button[@class='ng-scope' and @translate='Products']")
	public WebElement ProductsIcon;

	@FindBy(xpath = "//button[@class='ng-scope' and @translate='Articles']")
	public WebElement ArticlesIcon;

	@FindBy(xpath = "//button[@class='ng-scope' and @translate='Tenant']")
	public WebElement TenantIcon;
	
	@FindBy(xpath = "//button[@class='ng-scope' and @translate='Catalogs']")
	public WebElement CatalogsIcon;
	

	@FindBy(xpath = "//button[@class='ng-scope' and @translate='Notification configuration']")
	public WebElement NotificationConfigurationIcon;

	@FindBy(xpath = "//button[@class='ng-scope' and @translate='Notification type mapping']")
	public WebElement NotificationTypeMappingIcon;

	@FindBy(xpath = "//button[@class='ng-scope' and @translate='Customers']")
	public WebElement CustomersIcon;
	
	@FindBy(xpath = "//button[@class='ng-scope' and @translate='Employees']")
	public WebElement EmployeesIcon;
	
	@FindBy(xpath = "//button[@class='ng-scope' and @translate='Parkers']")
	public WebElement ParkersIcon;
	
	@FindBy(xpath = "//button[@class='ng-scope' and @translate='Pricing Procedures']")
	public WebElement PricingProcedureIcon;
	
	@FindBy(xpath = "//div[@class='user-logout']")
	public WebElement LogoutButton;
	
	@FindBy(xpath = "//*[@onclick='login()']")
	public WebElement LoginSSPButton;

	
	/**
	 * Method to click on App Launcher icon after Login successful
	 * @throws InterruptedException
	 */
	public void clickOnAppLauncher() throws InterruptedException {
	
		wh.waitForElementToBeClickable(appLauncherIcon, driver, 20);
		log("Click on App Launcher link");
		clickElementUsingJavaScript(appLauncherIcon);
		takeScreenShot();
		Thread.sleep(2000);
		log("Clicked on App Launcher link" + appLauncherIcon.toString());

	}
	
	/**
	 * Login button
	 */
	public void clickOnLogin() {
		clickElementUsingJavaScript(LoginSSPButton);
		log("clicked on the login to SSP button");
	}



	/**
	 * Method to Search and Select the App 
	 * @param _AppName
	 * @throws InterruptedException
	 */
	public void searchAppNameAndClick(String _AppName) throws InterruptedException {
		searchAppInputField.sendKeys(_AppName);
		log("Entered the text in search field as "+_AppName);
		Thread.sleep(3000);
		selectApptoOpen(_AppName);
	}



	/**
	 * This method is used to Select the desired app from the app launcher window.
	 */
	public void selectApptoOpen(String _AppName) throws InterruptedException {

		WebElement appToOpen = driver.findElement(By.xpath("//span[@translate='"+_AppName+"'][1]"));
		wh.waitForElementToBeClickable(appToOpen, driver, 10);
		log("Click on App -> " + _AppName);
		appToOpen.click();
		takeScreenShot();
		log("The App -> " + _AppName + " is selected");
	}




	/**Common method to switch to the desired frame
	 * this method will be usually called when the app is selected and the Frame switch is to be done.
	 *
	 */
	public void switchToiframe(int frameno) {

		List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
		log("No of total frames is " +iframe.size());
		log("switching to the iFrame window frame no -> "+ frameno);
		driver.switchTo().frame(frameno);
		log("Switched to the iFrame window success");


	}


	/**
	 * Common method to switch to the default content
	 */
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
		log("Switched to default content ");

	}


	public void selectRegionalHeadquartersIcon() {
		wh.waitForElementToBeClickable(RegionalheadquartersIcon, driver, 10);
		clickElementUsingJavaScript(RegionalheadquartersIcon);
		log("clicked on the Regional headquarters Icon");
		takeScreenShot();
	}

	public void selectUnitsIcon() {
		wh.waitForElementToBeClickable(UnitsIcon, driver, 10);
		clickElementUsingJavaScript(UnitsIcon);
		log("clicked on the Units Icon");
		takeScreenShot();
	}



	public void selectSalesChannel() {
		wh.waitForElementToBeClickable(SalesChannelIcon, driver, 10);
		clickElementUsingJavaScript(SalesChannelIcon);
		log("clicked on the Sales Channel Icon");
		takeScreenShot();


	}



	public void selectFacilities() {
		wh.waitForElementToBeClickable(SalesFacilitiesIcon, driver, 10);
		clickElementUsingJavaScript(SalesFacilitiesIcon);
		clickElementUsingJavaScript(SalesFacilitiesIcon);
		log("clicked on the Facilities Icon");
		takeScreenShot();

	}



	public void selectCarPark() {
		wh.waitForElementToBeClickable(CarparkIcon, driver, 10);
		clickElementUsingJavaScript(CarparkIcon);
		log("clicked on the Car park Icon");
		takeScreenShot();

	}



	public void selectPortfolios() {
		wh.waitForElementToBeClickable(PortfoliosIcon, driver, 10);
		clickElementUsingJavaScript(PortfoliosIcon);
		log("clicked on the Port folios Icon");
		takeScreenShot();

	}



	public void selectProducts() {
		wh.waitForElementToBeClickable(ProductsIcon, driver, 10);
		clickElementUsingJavaScript(ProductsIcon);
		log("clicked on the Products Icon");
		takeScreenShot();

	}



	public void selectArticles() {
		wh.waitForElementToBeClickable(ArticlesIcon, driver, 10);
		clickElementUsingJavaScript(ArticlesIcon);
		log("clicked on the Articles Icon");
		takeScreenShot();

	}



	public void selectTenantIcon() {
		wh.waitForElementToBeClickable(TenantIcon, driver, 10);
		clickElementUsingJavaScript(TenantIcon);
		log("clicked on the Tenant Icon");
		takeScreenShot();

	}



	public void selectCatalogs() {
		wh.waitForElementToBeClickable(CatalogsIcon, driver, 10);
		clickElementUsingJavaScript(CatalogsIcon);
		log("clicked on the Catalogs Icon");
		takeScreenShot();
		
	}
	

	public void selectCustomer() {
		wh.waitForElementToBeClickable(CustomersIcon, driver, 10);
		clickElementUsingJavaScript(CustomersIcon);
		log("clicked on the customer Icon");
		takeScreenShot();
		
	}
	

	public void selectEmployees() {
		wh.waitForElementToBeClickable(EmployeesIcon, driver, 10);
		clickElementUsingJavaScript(EmployeesIcon);
		log("clicked on the employee Icon");
		takeScreenShot();
		
	}

	public void selectParkers() {
		wh.waitForElementToBeClickable(ParkersIcon, driver, 10);
		clickElementUsingJavaScript(ParkersIcon);
		log("clicked on the Prkers Icon");
		takeScreenShot();
		
	}
	
	public void selectNotificationTypeMapping() {
		wh.waitForElementToBeClickable(NotificationTypeMappingIcon, driver, 10);
		clickElementUsingJavaScript(NotificationTypeMappingIcon);
		log("clicked on the Notification type mapping  Icon");
		takeScreenShot();
		
	}


	public void selectNotificationConfiguration() {
		wh.waitForElementToBeClickable(NotificationConfigurationIcon, driver, 10);
		clickElementUsingJavaScript(NotificationConfigurationIcon);
		log("clicked on the Notification configuration Icon");
		takeScreenShot();
		
	}
	
	public void selectPricingProcedure() {
		wh.waitForElementToBeClickable(PricingProcedureIcon, driver, 10);
		clickElementUsingJavaScript(PricingProcedureIcon);
		log("clicked on the Pricing procedure Icon");
		takeScreenShot();
		
	}
	
	/**
	 * method for logout
	 */
	public void logoutButton() {
		
		clickElementUsingJavaScript(LogoutButton);
		log("Logout is successfull");
		takeScreenShot();
	}




}
