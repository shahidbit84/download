package com.skidata.testBase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.skidata.customListener.WebEventListener;
import com.skidata.helperclasses.DateAndUniqueNoGenerateHelper;
import com.skidata.helperclasses.JavaScriptHelper;
import com.skidata.util.ConstantValues;
import com.skidata.util.DataUtil;
import com.skidata.util.ExtentManager;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

/**
 *************************************************************************************************************
 * @Project SSP - CHBACKOFFICE AND PORTAL
 * @Description
 * TestBase is the base class of the framework, which will be extended to all other classes.</Br>
 * Common methods are kept in this class which provides re-usability to other classes.
 * @author shmo
 * @version 1.0
 *************************************************************************************************************
 */
public class TestBase {
	
	

	
	
	
	//public ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	public static ExtentReports extent=null;
	public  ExtentTest test=null;
	//public static Xls_Reader xls_chbackoffice = new Xls_Reader(ConstantValues.DATA_XLS_PATH_CHBACKOFFICE);
	//public   Xls_Reader xls_portal = new Xls_Reader(ConstantValues.DATA_XLS_PATH_PORTAL);
	public WebDriver driver=null;
	//RemoteWebDriver driverRemote=null;
	public WebEventListener eventListener=null;
	public Properties OR = new Properties();
	public ITestResult result=null;
	public ATUTestRecorder recorder=null; 
	public String testvideoName=null;
	// Excel_Reader excel;
	// public EventFiringWebDriver driver;
	
	public String portalURL = null;
	public String chBackofficeURL= null;
	public String chBackofficeLoginID= null;
	public String chBackofficeLoginPassword = null;
	public String tenantName= null;
	public String screenRecording= null;
	public String adminTenant=null;
	
	public DataUtil dataUtil = new DataUtil();
	

	//In order to have a single instance of the extent manager this is declared inside the static method.
	static {
		extent = ExtentManager.getInstance(); /* Object of the Extent Report */
	}

	/**
	 * Method to read the TestCases Sheet and all the columns in that and have values retrieved 
	 * @param xls
	 * @param testName
	 */
	public void readTestCaseSheetColumns(String excelLocation,String testName) {
		DataUtil dataUtil = new DataUtil();
	
	portalURL = dataUtil.getUrl(excelLocation, testName);//getting the URL from the sheet TestCases
	screenRecording = dataUtil.recordingOption(excelLocation, testName);
	chBackofficeURL = dataUtil.chBackofficeURL(excelLocation, testName);
	 adminTenant = dataUtil.chBackofficeLoginID(excelLocation, testName);
	chBackofficeLoginID = dataUtil.chBackofficeLoginID(excelLocation, testName);
	chBackofficeLoginPassword = dataUtil.chBackofficeLoginPassword(excelLocation, testName);
	tenantName = dataUtil.tenantName(excelLocation, testName);
	
	}
	
	
	
	public void runCheck(Hashtable<String, String> data,String testName) {
		log("====" + testName + " ====");
		assignCategory_Author(data.get("Test Type"),data.get("Module Name"),data.get("Author"),data.get("Browser"));

		//To check if the Test case needs to be Skipped based on the Run mode provided from the Excel Sheet.
		if (!dataUtil.isTestExecutable(ConstantValues.DATA_XLS_PATH_PORTAL, testName) || data.get(ConstantValues.RUNMODE_COL).equals("N")) {
			test.log(LogStatus.SKIP, "Skipping the test as Runmode is N");
			log("Skipping the test as Runmode is N");
			throw new SkipException("Skipping the test as Runmode is N");

		}else {
			
			log("Test case data <br /> "+data);
		}
	}
	

	/**
	 *************************************************************************************************************
	 * Method which initializes the driver and creates the browser instance and navigates to specific URL.
	 * @param browser
	 * @param url
	 * @throws Exception 
	 *************************************************************************************************************
	 */
	public void init(String browser, String url,String testCase,String startRecording) throws Exception {
		loadData();
		 String hubIp = OR.getProperty("HubIp");
	        String hubPort = OR.getProperty("HubPort");
	        String remoteUrl = "http://" + hubIp + ":" + hubPort + "/wd/hub";
	        
		startScreenRecord(testCase, startRecording);
		if(OR.getProperty("GRIDEXECUTION").equalsIgnoreCase("YES")) {
			launchapp(browser,remoteUrl);
			getUrl(url);
		}else {
			selectBrowser(browser);
			getUrl(url);
		}
		
		
	}

	/**
	 *************************************************************************************************************
	 * Method to Launch the specific browser
	 * @param browser
	 *************************************************************************************************************
	 */
	public void selectBrowser(String browser) {

		// System.out.println(System.getProperty("os.name"));
		if (System.getProperty("os.name").contains("Window")) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.out.println(System.getProperty("user.dir"));
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				ChromeOptions o = new ChromeOptions();
				o.addArguments("disable-extensions");
				o.addArguments("test-type");
				o.addArguments("start-maximized");
				o.addArguments("--js-flags=--expose-gc");
				o.addArguments("--enable-precise-memory-info");
				o.addArguments("--disable-popup-blocking");
				o.addArguments("--disable-default-apps");
				o.addArguments("test-type=browser");
				o.addArguments("disable-infobars");
				o.setAcceptInsecureCerts(true);
				o.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
				o.addArguments("start-maximized");

				Map<String, Object> chromePreferences = new Hashtable<String, Object>();
				/* Below two chrome preference settings will disable popup dialog when download file.*/
				chromePreferences.put("profile.default_content_settings.popups", 0);
				chromePreferences.put("download.prompt_for_download", "false");
				
				/* Set file save to directory. */
				chromePreferences.put("download.default_directory", ConstantValues.DOWNLOAD_PDF_ETICKET_FOLDER);

				
				o.setExperimentalOption("prefs", chromePreferences);

				//DesiredCapabilities cap = DesiredCapabilities.chrome();
				o.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				o.setCapability(ChromeOptions.CAPABILITY, o);

				driver = new ChromeDriver(o);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().deleteAllCookies();
				// driver = new EventFiringWebDriver(dr);
				// eventListener = new WebEventListener();
				// driver.register(eventListener);
			} else if (browser.equalsIgnoreCase("firefox")) {
				
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("marionette", "true");
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().deleteAllCookies();
//				
//				
	//			FirefoxProfile profile = new FirefoxProfile();
//				DesiredCapabilities dc=DesiredCapabilities.firefox();
//				dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//				profile.setAssumeUntrustedCertificateIssuer(true);
//				profile.setAcceptUntrustedCertificates(true);
//				profile.setAssumeUntrustedCertificateIssuer(true);
//				profile.setPreference("browser.download.folderList", 2);
//				profile.setPreference("browser.helperApps.alwaysAsk.force", false);
//				profile.setPreference("browser.download.manager.showWhenStarting",false); profile.setPreference("browser.download.dir", "C:\\Downloads"); profile.setPreference("browser.download.downloadDir","C:\\Downloads"); profile.setPreference("browser.download.defaultFolder","C:\\Downloads"); profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/anytext ,text/plain,text/html,application/plain" );
//				dc = DesiredCapabilities.firefox();
//				dc.setCapability(FirefoxDriver.PROFILE, profile);
//				driver =  new FirefoxDriver();
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				
				
				
				
				
				
				
				
				// driver = new EventFiringWebDriver(dr);
				//eventListener = new WebEventListener();
				// driver.register(eventListener);
				// setDriver(driver);
			} else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.edge.driver",System.getProperty("user.dir") + "/drivers/MicrosoftWebDriver.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
				capabilities.setCapability("requireWindowFocus", true);
				
				driver = new EdgeDriver();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				// driver = new EventFiringWebDriver(dr);
				//eventListener = new WebEventListener();
				// driver.register(eventListener);
				// setDriver(driver);
			}
			else if (browser.equalsIgnoreCase("headless")) {
				  File file = new File("D:\\Projects\\SSP_Release_UIPortal\\drivers\\phantomjs.exe");				
//		          System.setProperty("phantomjs.binary.path", file.getAbsolutePath());		
	
		          DesiredCapabilities desiredCapabilities = DesiredCapabilities.phantomjs();
		  		desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.setProperty("phantomjs.binary.path", file.getAbsolutePath()));
		  		desiredCapabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
		  		desiredCapabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
		  		desiredCapabilities.setCapability(CapabilityType.ENABLE_PROFILING_CAPABILITY, true);
		  		desiredCapabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);

		  		desiredCapabilities.setJavascriptEnabled(true);

		  		ArrayList<String> cliArgs = new ArrayList<String>();
		  		cliArgs.add("--web-security=true");
		  		cliArgs.add("--ignore-ssl-errors=true");
		  		desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgs);

		  	   driver = new PhantomJSDriver(desiredCapabilities);
		          
		          
		          
		          
		          
		          
		          
		          
		          
		          
		          
		          
		          
		          
			
			}

		} else if (System.getProperty("os.name").contains("Mac")) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driversmac/chromedriver");
				driver = new ChromeDriver();
				// driver = new EventFiringWebDriver(dr);
				// eventListener = new WebEventListener();
				// driver.register(eventListener);
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.firefox.marionette",
						System.getProperty("user.dir") + "/drivers/geckodriver");
				driver = new FirefoxDriver();
				driver.get("http://google.com");
				// driver = new EventFiringWebDriver(dr);
				//eventListener = new WebEventListener();
				// driver.register(eventListener);
				// setDriver(driver);
			}
			else if (browser.equalsIgnoreCase("safari")) {
				
				driver = new SafariDriver();
			
		    }
		}
	}

	
	
	
	
	
	
	
	/**
	 **************************************************************************************************************
	 * Below is the Grid configuration which has to be used for grid execution.
	 * @param browser
	 * @throws IOException
	 * @throws InterruptedException
	 **************************************************************************************************************
	 */
	public void launchapp(String browser,String remoteUrl) throws IOException, InterruptedException {

		if (System.getProperty("os.name").contains("Mac")) {
			if (browser.equalsIgnoreCase("chrome")) {
			
				System.out.println(" Executing on CHROME");
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				String Node = remoteUrl;
			    driver = new RemoteWebDriver(new URL(Node), cap);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
			} else if (browser.equalsIgnoreCase("firefox")) {

				System.out.println(" Executing on FireFox");
				String Node = remoteUrl;
				DesiredCapabilities cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				this.driver = new RemoteWebDriver(new URL(Node), cap);

			} else if (browser.equalsIgnoreCase("ie")) {
				System.out.println(" Executing on IE");
				DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
				cap.setBrowserName("ie");
				String Node = remoteUrl;
				driver = new RemoteWebDriver(new URL(Node), cap);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
			} else {
				throw new IllegalArgumentException("The Browser Type is Undefined");
			}
		}
		if (System.getProperty("os.name").contains("Window")) {
			if (browser.equalsIgnoreCase("chrome")) {

				System.out.println(" Executing on CHROME");
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
                cap.setPlatform(Platform.WINDOWS);
				String Node = remoteUrl;
				driver = new RemoteWebDriver(new URL(Node), cap);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				
			} else if (browser.equalsIgnoreCase("firefox")) {

				System.out.println(" Executing on FireFox");
				String Node = remoteUrl;
				DesiredCapabilities cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				driver = new RemoteWebDriver(new URL(Node), cap);

				
			} else if (browser.equalsIgnoreCase("ie")) {
				System.out.println(" Executing on IE");
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setBrowserName("ie");
				String Node = remoteUrl;
				driver = new RemoteWebDriver(new URL(Node), cap);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			} else {
				throw new IllegalArgumentException("The Browser Type is Undefined");
			}
		}
	}
	

	
	
	
	/**
	 *************************************************************************************************************
	 * Method to open the URL in the browser
	 * @param url
	 * @throws InterruptedException
	 ************************************************************************************************************* 
	 */
	public void getUrl(String url) throws InterruptedException {
		
		driver.manage().window().maximize();
		
		driver.get(url);
		
		log.info("navigate to :-" + url);
	}

	/**
	 **************************************************************************************************************
	 * Configuration of the Log4j 
	 **************************************************************************************************************
	 */
	@BeforeMethod
	public void configureLog4j() {
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}
	
	

	/**
	 **************************************************************************************************************
	 * Method to return the driver instance created in the TestBase
	 * @return driver
	 **************************************************************************************************************
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 **************************************************************************************************************
	 * Setting the Event firing web driver currently we are not using this to a
	 * great extent as we have log4j
	 **************************************************************************************************************
	 */
	public void setDriver(EventFiringWebDriver driver) {
		this.driver = driver;
	}

	/**
	 **************************************************************************************************************
	 * Loading the property file Name config.properties
	 * @throws IOException
	 *************************************************************************************************************
	 */
	public void loadData() throws IOException {
		File file = new File(System.getProperty("user.dir") + "/src/main/java/com/skidata/config/config.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);
	}

	/**
	 **************************************************************************************************************
	 * This method will highlight the WebElement in the web page.
	 * @param driver
	 * @param element
	 * @throws InterruptedException
	 * @author shmo
	 **************************************************************************************************************
	 */
	public static void highlightWebElement(WebDriver driver, WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='4px solid yellow'", element);
		Thread.sleep(500);
		js.executeScript("arguments[0].style.border=''", element);
	}

	/**
	 **************************************************************************************************************
	 * Method to wait for the Text to appear or to be present in Element
	 * @param newDriver
	 * @param textToAppear
	 * @param element
	 **************************************************************************************************************
	 */
	public static void waitForTextToAppear(WebDriver newDriver, String textToAppear, WebElement element) {
		WebDriverWait wait = new WebDriverWait(newDriver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(element, textToAppear));
	}

	/**
	 **************************************************************************************************************
	 * Method to wait for the Element Visibility on the web page
	 * @param driver
	 * @param timeOutInSeconds
	 * @param element
	 * @return
	 **************************************************************************************************************
	 */
	public WebElement waitForElementVisiblity(WebDriver driver, int timeOutInSeconds, WebElement element) {
		log("waiting for Element Visibility");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	/**
	 **************************************************************************************************************
	 * Method to wait for the Element Invisibility
	 * @param driver
	 * @param timeOutInSeconds
	 * @param element
	 **************************************************************************************************************
	 */
	public void waitForElementInVisiblity(WebDriver driver, int timeOutInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.invisibilityOf(element));

	}

	/**
	 **************************************************************************************************************
	 * Method to wait for the Element to be Click able
	 * @param driver
	 * @param timeOutInSeconds
	 * @param element
	 * @return web element
	 **************************************************************************************************************
	 */
	public WebElement waitForElementToBeClickable(WebDriver driver, int timeOutInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}
	
	
	/**
	 **************************************************************************************************************
	 * Method to Take a Screenshot of the Web page 
	 * @throws ATUTestRecorderException 
	 **************************************************************************************************************
	 */
	public void startScreenRecord(String testCase,String startRecording) throws ATUTestRecorderException {
		if(startRecording.equalsIgnoreCase("Y")) {
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_");
		testvideoName = testCase+"_"+screenshotFile;
		
		
		 File file = new File(ConstantValues.SCRIPTVIDEOS_FOLDER_ABSOLUTEPATH);
		 if (!file.exists()) {
			file.mkdirs();
		 }
		
		  
		
		recorder = new ATUTestRecorder(System.getProperty("user.dir")+"/extentreports/ScriptVideos/",testvideoName,false); 
		recorder.start(); 
		log("Screen Recording Started");
		test.log(LogStatus.INFO, "<a href='"+ConstantValues.SCRIPTVIDEOS_FOLDER_RELATIVEPATH+testvideoName+".mov"+"'"
				+ "<span class='label info'>Download Video</a>");

		}
	
	}
	
	
	

	/**
	 **************************************************************************************************************
	 * Method to Take a Screenshot of the Web page 
	 **************************************************************************************************************
	 */
	public void takeScreenShot() {
		try {
		//Date d = new Date();
			
		DateAndUniqueNoGenerateHelper dh = new DateAndUniqueNoGenerateHelper();
		String screenshotFile = dh.generateUniqueNo() + ".png";
		String filePath = (System.getProperty("user.dir")) + "/extentreports/screenshots/" + screenshotFile;
		// store screenshot in that file
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(filePath));

			Reporter.log("<a href='" + filePath + "'> <img src='" + filePath + "' height='100' width='100'/> </a>");
		} catch (IOException e) {

			e.printStackTrace();
		}
		test.log(LogStatus.INFO, test.addScreenCapture(ConstantValues.SCREENSHOT_FOLDER_RELATIVEPATH+screenshotFile));
	}catch(Throwable e) {
		log("Screen not captured");
	}
	}

	/**
	 **************************************************************************************************************
	 * Take a Screenshot of the whole screen from top to bottom
	 * @throws IOException
	 **************************************************************************************************************
	 */
	public void takeScreenShotFullScreen() throws IOException {
//		Date d = new Date();
//		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_")+".png";
		DateAndUniqueNoGenerateHelper dh = new DateAndUniqueNoGenerateHelper();
		String screenshotFile = dh.generateUniqueNo() + ".png";
		
		String filePath = ConstantValues.SCREENSHOT_FOLDER_ABSOLUTEPATH + screenshotFile;
		// store screenshot in that file

		File outputfile = new File(filePath);
		JavaScriptHelper js= new JavaScriptHelper(driver, test);
		js.ZoomInBy70percentage();
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		js.scrollUpVertically();
		js.ZoomInBy100percentage();
		try {
			ImageIO.write(screenshot.getImage(), "png", outputfile);
			Reporter.log("<a href='" + filePath + "'> <img src='" + filePath + "' height='100' width='100'/> </a>");
		} catch (IOException e) {

			e.printStackTrace();
		}
		test.log(LogStatus.INFO, test.addScreenCapture(ConstantValues.SCREENSHOT_FOLDER_RELATIVEPATH+screenshotFile));
	}

	/**
	 **************************************************************************************************************
	 * Take screenshot of the Exact Web element which is to be interacted
	 * @param element
	 * @throws IOException
	 **************************************************************************************************************
	 */
	public void takeScreenShotOfWebElement(WebElement element) throws IOException {
		
		
		DateAndUniqueNoGenerateHelper dh = new DateAndUniqueNoGenerateHelper();
		String screenshotFile = dh.generateUniqueNo() + ".png";
		String filePath = ConstantValues.SCREENSHOT_FOLDER_ABSOLUTEPATH + screenshotFile;
		// store screenshot in that file

		File outputfile = new File(filePath);

		JavaScriptHelper js= new JavaScriptHelper(driver, test);
		js.waitForElementVisiblity(driver, 10, element);
		js.scrollToElement(element);

		Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, element) ;

		try {
			ImageIO.write(screenshot.getImage(), "PNG", outputfile);
			Reporter.log("<a href='" + filePath + "'> <img src='" + filePath + "' height='100' width='100'/> </a>");
		} catch (IOException e) {

			e.printStackTrace();
		}
		test.log(LogStatus.INFO, test.addScreenCapture(ConstantValues.SCREENSHOT_FOLDER_RELATIVEPATH+screenshotFile));
	}

	/**
	 **************************************************************************************************************
	 * Method which will return (iterator)the no of window handle available.
	 * @return windowHandles
	 **************************************************************************************************************
	 */
	public Iterator<String> getAllWindows() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> windowHandle = windows.iterator();
		return windowHandle;
	}

	/**
	 **************************************************************************************************************
	 * overloaded method getScreenShot here it automatically takes the screenshot based on the execution of the test case result either its pass
	 * or fail it will take a screenshot at the end.
	 **************************************************************************************************************
	 */
	public void getScreenShot(WebDriver driver, ITestResult result, String folderName) {
		DateAndUniqueNoGenerateHelper dh = new DateAndUniqueNoGenerateHelper();
		String screenshotFile = dh.generateUniqueNo() + ".png";
		String filePath = ConstantValues.SCREENSHOT_FOLDER_ABSOLUTEPATH + screenshotFile;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(filePath));

			Reporter.log("<a href='" + filePath + "'> <img src='" + filePath + "' height='100' width='100'/> </a>");
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 **************************************************************************************************************
	 * Takes Screen shot on Success
	 * @param driver
	 * @param result
	 **************************************************************************************************************
	 */
	public void getScreenShotOnSucess(WebDriver driver, ITestResult result) {
		DateAndUniqueNoGenerateHelper dh = new DateAndUniqueNoGenerateHelper();
		String screenshotFile = dh.generateUniqueNo() + ".png";
		String filePath = ConstantValues.SCREENSHOT_FOLDER_ABSOLUTEPATH + screenshotFile;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(filePath));

			Reporter.log("<a href='" + filePath + "'> <img src='" + filePath + "' height='100' width='100'/> </a>");
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 *************************************************************************************************************
	 * This method will capture the screen which is called by get result method and returns the path of the file
	 *************************************************************************************************************
	 */
	public String captureScreen() {
		DateAndUniqueNoGenerateHelper dh = new DateAndUniqueNoGenerateHelper();
		String screenshotFile = dh.generateUniqueNo() + ".png";
		String filePath = ConstantValues.SCREENSHOT_FOLDER_ABSOLUTEPATH + screenshotFile;
		// store screenshot in that file
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destFile = ConstantValues.SCREENSHOT_FOLDER_RELATIVEPATH+screenshotFile; // Providing the Relative Path
		try {
			FileUtils.copyFile(scrFile, new File(filePath));

			Reporter.log("<a href='" + filePath + "'> <img src='" + filePath + "' height='100' width='100'/> </a>");
		} catch (IOException e) {

			e.printStackTrace();
		}
		return destFile.toString();
	}

	/**
	 *************************************************************************************************************
	 * A common method defined in the Test base which will log the messages in
	 * console and extent reports. this can be used in any class to log
	 *************************************************************************************************************
	 */
	public void log(String data) {
		
		
		log.info(data);
		
		test.log(LogStatus.INFO,"<pre>"+data+"</pre>");
		Reporter.log(data);

	}

	/**
	 **************************************************************************************************************
	 * Logging Exception
	 * @param e
	 **************************************************************************************************************
	 */
	public void logexception(Exception e) {
		log.info(e);
		test.log(LogStatus.INFO, e);
		Reporter.log(e + "");

	}

	/**
	 **************************************************************************************************************
	 *Logging Assertion Error
	 * @param e
	 **************************************************************************************************************
	 */
	public void logAssertionError(AssertionError e) {
		log.info(e);
		test.log(LogStatus.INFO, e);
		Reporter.log(e + "");

	}

	/**
	 **************************************************************************************************************
	 * This method will fetch the Test result after the execution of the Test
	 * case done. it will see if it was passed or skipped or failed or started.
	 **************************************************************************************************************
	 */
	public void getresult(ITestResult result) {
		String screen = captureScreen();
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP,result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.ERROR, result.getName() + " test is failed" + result.getThrowable());
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started");
	
		}

	}

	/**
	 *************************************************************************************************************
	 * This method was written to wait for the page to be loaded so all elements
	 * are displayed.
	 *************************************************************************************************************
	 */
	public void waitForPageToLoad() throws InterruptedException {
		// wait(1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String state = (String) js.executeScript("return document.readyState");

		while (!state.equals("complete")) {
			// wait(2);
			state = (String) js.executeScript("return document.readyState");
		}
	}

	

	/**
	 *************************************************************************************************************
	 * This annotation will be used to execute the beforeMethod before every
	 * test method or case. It will log the test status as started
	 *************************************************************************************************************
	 */
	@BeforeMethod()
	public void beforeMethod(Method method) {
		test = extent.startTest(method.getName());
		test.log(LogStatus.INFO,"<pre>Test case method <br />" + method.getName() + "<br />Test Started Success </pre>");
	
		
	}
	
//	@BeforeMethod()
//	public void onTestStart(ITestResult result) {
//			log("<pre>Description of test case is <br /> "+result.getMethod().getDescription()+"</pre>");
//	}
	
	

	/**
	 **************************************************************************************************************
	 * If a user want to do a tab action in the script this method can be used
	 * and also modified if he want to press enter after the tab or not.
	 **************************************************************************************************************
	 */
	public void pressTab() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 **************************************************************************************************************
	 * If for some reason the element is not click able then we can interact with
	 * it using the java script The below method will be used to click on the
	 * element which will find the location of element and click on it
	 **************************************************************************************************************
	 */
	public void clickUsingJavaScriptonLocation(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"document.elementFromPoint(" + element.getLocation().x + "," + element.getLocation().y + ").click();");
	}

	/**
	 **************************************************************************************************************
	 * If for some reason the element is not click able then we can interact with
	 * it using the java script The below method will be used to click on the
	 * element
	 **************************************************************************************************************
	 */
	public void clickElementUsingJavaScript(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	/**
	 **************************************************************************************************************
	 * Method to Scroll to any Web element using java-script
	 * @param element
	 **************************************************************************************************************
	 */
	public void scrollToElementUsingJavaScript(WebElement element) {
		int y = element.getLocation().y;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0," + (y - 200) + ")");
	}

	/**
	 **************************************************************************************************************
	 * Scroll to element using the x-path of the element
	 * @param xpathofElement
	 **************************************************************************************************************
	 */
	public void scrollToElementUsingXpath(String xpathofElement) {
		int y = driver.findElement(By.xpath(xpathofElement)).getLocation().y;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0," + (y - 200) + ")");
	}

	/**
	 **************************************************************************************************************
	 * Method using fluent wait to wait for element 
	 * @param driver
	 * @param inputElement
	 **************************************************************************************************************
	 */
//	public void usingFluentWait(WebDriver driver, final WebElement inputElement) {
//		// Create object of FluentWait class and pass webdriver as input
//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//		// It should poll webelement after every single second
//		wait.pollingEvery(5, TimeUnit.SECONDS);
//		// Max time for wait- If conditions are not met within this time frame
//		// then it will fail the script
//		wait.withTimeout(80, TimeUnit.SECONDS);
//		wait.ignoring(NoSuchElementException.class);
//		// we are creating Function here which accept webdriver and output as
//		// WebElement-
//		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
//			// apply method- which accept webdriver as input
//			public WebElement apply(WebDriver arg0) {
//				// find the element
//				// System.out.println(locator+ " dddddddddddd");
//				// WebElement ele = arg0.findElement(locator);
//				WebElement ele = inputElement;
//
//				if (ele.isDisplayed() || ele.isEnabled()) {
//					System.out.println("element is to be clicked >>> ");
//					return ele;
//				}
//
//				// If condition is not true then it will return null and it will
//				// keep checking until condition is not true
//				else {
//					System.out.println("Element displayed >>> " + ele.isDisplayed());
//					return null;
//				}
//			}
//		});
//
//		// If element is found then it will display the status
//		System.out.println("Final visible status is >>>>> " + element.isDisplayed());
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		// clickUsingJavaScriptonLocation(element);
//		clickElementUsingJavaScript(element);
//		element.click();
//		System.out.println(element + "is clicked successfully");
//	}

	/**
	 **************************************************************************************************************
	 * Method to use fluent wait and accepts the locator
	 * @param driver
	 * @param locator
	 **************************************************************************************************************
	 */
//	public void usingFluentWaitwithLocator(WebDriver driver, final By locator) {
//		// Create object of FluentWait class and pass webdriver as input
//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//		// It should poll webelement after every single second
//		wait.pollingEvery(1, TimeUnit.SECONDS);
//		// Max time for wait- If conditions are not met within this time frame
//		// then it will fail the script
//		wait.withTimeout(80, TimeUnit.SECONDS);
//		wait.ignoring(NoSuchElementException.class);
//		// we are creating Function here which accept webdriver and output as
//		// WebElement-
//		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
//			// apply method- which accept webdriver as input
//			public WebElement apply(WebDriver arg0) {
//				// find the element
//				WebElement ele = arg0.findElement(locator);
//				// WebElement ele = inputElement;
//
//				if (ele.isDisplayed() || ele.isEnabled()) {
//					System.out.println("element is to be clicked >>> ");
//					return ele;
//				}
//				// If condition is not true then it will return null and it will
//				// keep checking until condition is not true
//				else {
//					System.out.println("Element displayed >>> " + ele.isDisplayed());
//					return null;
//				}
//			}
//		});
//
//		// If element is found then it will display the status
//		System.out.println("Final visible status is >>>>> " + element.isDisplayed());
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		// clickUsingJavaScriptonLocation(element);
//		clickElementUsingJavaScript(element);
//		// element.click();
//		System.out.println(element + "is clicked successfully");
//	}

	/**
	 **************************************************************************************************************
	 * This is the method that we need to call when uploading a file in the
	 * application. the user will need to provide the browser name and the path
	 * of the file to upload.
	 * @param browser
	 * @param filePathToUpload
	 * @throws IOException
	 **************************************************************************************************************
	 */
	@SuppressWarnings("unused")
	public void uploadFile(String browser, String filePathToUpload) throws IOException {
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
	



	/**
	 **************************************************************************************************************
	 * Method to separate and display test cases as per categories and display author name in extent reports
	 * @param _TestType
	 * @param _ModuleName
	 * @param _Author
	 * @param _Browser
	 **************************************************************************************************************
	 */
	public void assignCategory_Author(String _TestType,String _ModuleName,String _Author,String _Browser){

		String[] testTypegroups = _TestType.split(",");
		for(int i=0;i<testTypegroups.length;i++){
			if(!testTypegroups[i].equals("")||!testTypegroups[i].equals(" "))
				test.assignCategory(testTypegroups[i]) ;
		}


		String[] moduleNamegroups = _ModuleName.split(",");
		for(int i=0;i<moduleNamegroups.length;i++){
			if(!moduleNamegroups[i].equals("")||!moduleNamegroups[i].equals(" "))
				test.assignCategory(moduleNamegroups[i]) ;
		}

		String[] authorgroups = _Author.split(",");
		for(int i=0;i<authorgroups.length;i++){
			if(!authorgroups[i].equals("")||!authorgroups[i].equals(" "))
				test.assignAuthor(authorgroups[i]) ;
		}

		if(!_Browser.equals("")||!_Author.equals(" ")){
			test.assignAuthor(_Browser);
		}

	}
	
	/**
	 *************************************************************************************************************
	 * In this Annotation we will check for the result of the Test case. and we
	 * are trying to flush the extent report and close the browser at all times
	 * after execution.
	 *************************************************************************************************************
	 */
	@AfterMethod()
	public void afterMethod(ITestResult result) {
		try {
			getresult(result);
			if (extent != null) {
				extent.endTest(test);
				extent.flush();
			}
			if (driver != null) {
				quitDriver();/* Quit the driver after Test case completed*/
			}
		} catch (Exception e) {
			if (extent != null) {
				extent.endTest(test);
				extent.flush();
			}
			if (driver != null) {
				quitDriver();/* Quit the driver after Test case completed*/
			}
			
		}finally {
			System.gc();
		}
	}
	
	/**
	 **************************************************************************************************************
	 * It is necessary to make sure we have all the browser closed So to double
	 * check This is added that after all test methods in a class are executed
	 * quit all the browser instance.
	 * @throws ATUTestRecorderException 
	 **************************************************************************************************************
	 */
	
	@AfterClass(alwaysRun = true)
	public void endTest() throws ATUTestRecorderException {
		closeBrowser();
		stopRecorder();
	}

	/**
	 **************************************************************************************************************
	 * This method is called to quit the driver instance.
	 **************************************************************************************************************
	 */
	
	
	
	public void closeBrowser() {
		try{if (extent != null) {
			extent.endTest(test);
			extent.flush();
		}
		if (driver != null) {
			quitDriver();
		}}
	
		finally {
			System.gc();
		}
	}

	/**
	 ************************************************************************************************************** 
	 * Method to stop Recorder
	 * @throws ATUTestRecorderException
	 **************************************************************************************************************
	 */
	 public void stopRecorder() throws ATUTestRecorderException {
	try {
		 if(recorder!=null) {
			 recorder.stop();	 
		 }}
	catch(Exception e) {
		log("Recording Driver not closed");
	}
	}

	/**
	 * 
	 * Quit Browser 
	 */
	 public void quitDriver() {
	 driver.quit();
		
	 }
	 
	 
	 public void waitForPageLoadToComplete() {

			WebDriverWait wait = new WebDriverWait(driver, 60);
		    wait.until(new Function<WebDriver, Boolean>() {
		        public Boolean apply(WebDriver driver) {
		           log("Current Window State       : "
		                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
		            return String
		                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
		                .equals("complete");
		        }
		    });
		}
	 
	 protected void sendKeys(final WebElement element, final String keys) {
		    for (int i = 0; i < keys.length(); i++){
		        element.sendKeys(Character.toString(keys.charAt(i)));
		        
		    }
		    log("Entered the text as "+ keys);
		}
	
	 
	 
	public void HandlingErrorOrException(Throwable e) {
		
		if(e instanceof NullPointerException) {
			String exceptionMessage=ExceptionUtils.getStackTrace(e);
			log(exceptionMessage);
			test.log(LogStatus.FAIL, "Null pointer exception occured");
			Assert.fail(e.getMessage());

		}		
		if(e instanceof IllegalStateException){
			String exceptionMessage=ExceptionUtils.getStackTrace(e);
			log(exceptionMessage);
			test.log(LogStatus.ERROR, "Illegal State Exception occured");
			Assert.fail(e.getMessage());

		}
		if (e instanceof SessionNotCreatedException ) {
			String exceptionMessage=ExceptionUtils.getStackTrace(e);
			log(exceptionMessage);
			test.log(LogStatus.ERROR, "Session Not created Exception occured");
			Assert.fail(e.getMessage());

		} 
		if (e instanceof WebDriverException ) {
			String exceptionMessage=ExceptionUtils.getStackTrace(e);
			log(exceptionMessage);
			test.log(LogStatus.ERROR, "WebDriver Exception occured");
			Assert.fail(e.getMessage());

		} 		
		
		if (e instanceof AssertionError) {
			String exceptionMessage=ExceptionUtils.getStackTrace(e);
			log(exceptionMessage);
			test.log(LogStatus.FAIL, "Assertion Error");
			Assert.fail(e.getMessage());
		}
		
		if (e instanceof Error) {
			String exceptionMessage=ExceptionUtils.getStackTrace(e);
			log(exceptionMessage);
			test.log(LogStatus.FAIL, "Error");
			Assert.fail(e.getMessage());
		}
		
		if (e instanceof Exception ) {
			takeScreenShot();
			String exceptionMessage=ExceptionUtils.getStackTrace(e);
			log(exceptionMessage);
			test.log(LogStatus.FAIL, "Exception occured while processing");
			Assert.fail(e.getMessage());
		}
		
	}
	 
	
	/**
	 * This is kind of deprecated method in this framework it wont be used much
	 * as we are using other method to read excel
	 */
	//    public String[][] getData(String excelName, String sheetName) {
	//        String path = System.getProperty("user.dir") + "/src/main/java/com/skidata/data/" + excelName;
	//        excel = new Excel_Reader(path);
	//        String[][] data = excel.getDataFromSheet(sheetName, excelName);
	//        return data;
	// }


	

	/**
	 * Method to get the screenshot
	 */
	//	public void getScreenShot(String name) {
	//
	//		Calendar calendar = Calendar.getInstance();
	//		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	//
	//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	//
	//		try {
	//			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
	//					+ "/src/main/java/com/skidata/screenshot/";
	//			File destFile = new File(
	//					(String) reportDirectory + name + "_" + formater.format(calendar.getTime()) + ".png");
	//			FileUtils.copyFile(scrFile, destFile);
	//			// This will help us to link the screen shot in testNG report
	//			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
	//					+ "' height='100' width='100'/> </a>");
	//			test.log(LogStatus.INFO, test.addScreenCapture(destFile.toString()));
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
	//
	//	}

}
