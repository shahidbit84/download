/**
 *
 */
package com.skidata.uiPages.chbackoffice;

import java.io.IOException;

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
 * 
 */
public class ConfigureThemePage extends TestBase {

	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
	String status=null;


	public static final Logger log = Logger.getLogger(ConfigureThemePage.class.getName());



	//Class constructor
	public ConfigureThemePage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

	}

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
	@FindBy(xpath = "//div[@class='v-progress-window ng-scope k-window-content k-content']//span[@translate='VSMCommon.ProgressLoading']")
	public WebElement loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;

	@FindBy(xpath = "//li[@id='ssp_saleschannel_theme_cancel']")
	public WebElement Cancellabel;

	@FindBy(xpath = "//li[@id='ssp_saleschannel_theme_logo']")
	public WebElement UploadLogolabel;

	@FindBy(xpath = "//li[@id='ssp_saleschannel_theme_banner']")
	public WebElement UploadBannerlabel;

	@FindBy(xpath = "//li[@id='ssp_saleschannel_theme_preview']")
	public WebElement Previewlabel;

	@FindBy(xpath = "//li[@id='ssp_saleschannel_theme_publish']")
	public WebElement Publishlabel;

	@FindBy(xpath = "//*[@id='app']/div[1]/div[2]/p")
	public WebElement ConfigureThemePageHeader;

	@FindBy(xpath = "//div[contains(@v-label,'SSPSalesChannel.ChooseTheme-LabelName')]//span[@class='k-input ng-scope']")
	public WebElement ThemesDropDown;

	@FindBy(xpath = "//*[@id='ssp_saleschannel_theme_favicon']")
	public WebElement Faviconlabel;
	

	@FindBy(xpath = "//span[@id='{{windowId}}_wnd_title']")
	public WebElement ConfirmWindowPopUpTitle;


	@FindBy(xpath = "//p[@translate='SSPSalesChannel.SalesChannelForm-ConfirmPublish']")
	public WebElement ConfirmPublishMsg;


	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonYes']")
	public WebElement ConfirmPublishYesButton;


	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonNo']")
	public WebElement ConfirmPublishNoButton;


	@FindBy(xpath = "//div[13]/div[1]/div/a/span")
	public WebElement XiconPopUp;



	@FindBy(xpath = "//p[@translate='SSPSalesChannel.SalesChannelForm-themePublishSuccess']")
	public WebElement InformationDialogMsg;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonOk']")
	public WebElement OKButtonlabel;


	@FindBy(xpath = "//*[@id='logoUpload']")
	public WebElement UploadLogoBrowseButton;

	@FindBy(xpath = "//*[@id='bannerUpload']")
	public WebElement UploadBannerBrowseButton;


	@FindBy(xpath = "//button[@translate='CH.ButtonSave']")
	public WebElement SaveButton;


	@FindBy(xpath = "//div[@v-on-click='confirmUpload(1)']//button")
	public WebElement SaveButtonUploadBanner;

	@FindBy(xpath = "//button[@translate='CH.ButtonCancel']")
	public WebElement CancelButton;

	@FindBy(xpath = "//div[@v-on-click='cancelUpload(1)']//button")
	public WebElement CancelButtonUploadBanner;

	@FindBy(xpath = "//p[@translate='SSPSalesChannel.SalesChannelForm-saveLogo']")
	public WebElement SaveLogoMessage;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonYes']")
	public WebElement YesButtonSaveLogo;

	@FindBy(xpath = "//button[@translate='VSMCommon.ButtonNo']")
	public WebElement NoButtonSaveLogo;


	@FindBy(xpath = "//p[@translate='SSPSalesChannel.SalesChannelForm-saveBanner']")
	public WebElement SaveBannerMessage;




	//****************************************************************************************************************


	public String verifyPageHeaderConfigureThemePage(String _ConfigureThemePageHeader) {
		status="FAIL";

		wh.waitForElementToBeVisible(ConfigureThemePageHeader, driver, 10);
		if(ConfigureThemePageHeader.getText().equals(_ConfigureThemePageHeader)) {
			status="PASS";
			log("Page header is displayed as ->"+ConfigureThemePageHeader.getText());
			takeScreenShot();
		}
		return status;


	}

	public String verifyConfigureThemePageIcons(String _Cancel,String _Uplaodlogo,String _Uploadbanner,String _Preview,String _Publish) {
		status="FAIL";
		if(Cancellabel.getText().equals(_Cancel)) {
			log(Cancellabel.getText()+" is displayed in UI");
			if(UploadLogolabel.getText().equals(_Uplaodlogo)) {
				log(UploadLogolabel.getText()+" is displayed in UI");
				if(UploadBannerlabel.getText().equals(_Uploadbanner)) {
					log(UploadBannerlabel.getText()+" is displayed in UI");
					if(Previewlabel.getText().equals(_Preview)) {
						log(Previewlabel.getText()+" is displayed in UI");
						if(Publishlabel.getText().equals(_Publish)) {
							log(Publishlabel.getText()+" is displayed in UI");
							status="PASS";
							takeScreenShot();
						}
					}
				}
			}
		}
		return status;
	}

	public void clickonCancel() {
		Cancellabel.click();
		log("Clicked on the Cancel icon");
		takeScreenShot();

	}

	public void selectThemes(String _ThemetoSelect) {
		wh.waitForElementToBeClickable(ThemesDropDown, driver, 10);
		ThemesDropDown.click();
		log("clicked on the Themes drop down");

		takeScreenShot();
		driver.findElement(By.xpath("//li[text()='"+_ThemetoSelect+"']")).click();
		log("Theme is selected as "+_ThemetoSelect);
		takeScreenShot();

	}

	public void clickonPublish() {
		Publishlabel.click();
		log("Clicked on the Publish icon");
		takeScreenShot();

	}
	
	
	public void clickFavIcon() {
		wh.waitForElementToBeClickable(Faviconlabel, driver, 10);
		Faviconlabel.click();
		log("Favicon button is clicked");
	}

	public String verifyPublishConfirmDialogMessageAndButtons(String _ConfirmWindowPopUpTitle,String _ConfirmPublishMsg,String _ConfirmPublishYesButton,String _ConfirmPublishNoButton) {
		status="FAIL";
		if(ConfirmWindowPopUpTitle.getText().equals(_ConfirmWindowPopUpTitle)) {
			log(ConfirmWindowPopUpTitle.getText()+" is displayed in UI");
			if(ConfirmPublishMsg.getText().equals(_ConfirmPublishMsg)) {
				log(ConfirmPublishMsg.getText()+" is displayed in UI");
				if(ConfirmPublishYesButton.getText().equals(_ConfirmPublishYesButton)) {
					log(ConfirmPublishYesButton.getText()+" is displayed in UI");
					if(ConfirmPublishNoButton.getText().equals(_ConfirmPublishNoButton)) {
						log(ConfirmPublishNoButton.getText()+" is displayed in UI");
						status="PASS";
						takeScreenShot();
					}
				}
			}
		}
		return status;

	}

	public void clickonXConfirmPublishpopUp() {
		XiconPopUp.click();
		log("Clicked on the X to Close");
		takeScreenShot();

	}

	public void clickonNoButtonConfirmDialog() {
		ConfirmPublishNoButton.click();
		log("clicked on No");
		takeScreenShot();

	}

	public void clickonYesButtonConfirmDialog() {
		ConfirmPublishYesButton.click();
		log("clicked on Yes");
		takeScreenShot();

	}

	public String verifyPublishInformation(String _InformationHeader,String _InformationDialogMsg,String _OKbuttonLabel) {
		status="FAIL";
		int window = driver.findElements(By.xpath("//span[@class='k-window-title' and text()='"+_InformationHeader+"']")).size();

		if(window==1) {
			log(InformationDialogMsg.getText());
			if(InformationDialogMsg.getText().equals(_InformationDialogMsg)){
				if(OKButtonlabel.getText().equals(_OKbuttonLabel)) {
					status="PASS";
					takeScreenShot();
					OKButtonlabel.click();
				}
			}
		}
		return status;

	}

	public void clickonUploadlogo() {
		wh.waitForElementToBeClickable(UploadLogolabel, driver, 10);
		clickElementUsingJavaScript(UploadLogolabel);
		log("Upload logo icon label clicked");
		takeScreenShot();

	}



	public String verifyUploadlogoPopUpLabels(String _Browser,String _Filepath,String _Save,String _Cancel) throws IOException {
		status="FAIL";
		int window = driver.findElements(By.xpath("//span[@class='k-window-title' and text()='Upload Logo']")).size();			
		if(window==1) {
			UploadLogoBrowseButton.click();
			log("clicked on the Browse");

			uploadFile(_Browser, _Filepath);

			int cropPreview = driver.findElements(By.xpath("//*[@id='lCrop']")).size();
			if(cropPreview==1) {
				log("Crop Preview Image is displayed");

				if(SaveButton.getText().equals(_Save)) {
					log(SaveButton.getText()+" is displayed");
					if(CancelButton.getText().equals(_Cancel)) {
						log(CancelButton.getText()+" is displayed");
						takeScreenShot();
						status="PASS";
					}
				}
			}
		}
		return status;
	}

	public void clickonSaveUploadLogo() {
		wh.waitForElementToBeClickable(SaveButton, driver, 10);
		SaveButton.click();
		log("Clicked on the Save button in Upload logo pop up dialog");
		takeScreenShot();

	}

	public void clickonCancelUploadLogo() {
		wh.waitForElementToBeClickable(CancelButton, driver, 10);
		CancelButton.click();
		log("Clicked on the Cancel button in Upload logo pop up dialog");
		takeScreenShot();

	}

	public String verifyUploadlogoConfirmationDialog(String _SaveLogoMessage,String _YesButtonSaveLogo,String _NoButtonSaveLogo) {

		status="FAIL";
		log(SaveLogoMessage.getText()+" is displayed in UI");
		if(SaveLogoMessage.getText().equals(_SaveLogoMessage)) {
			log(SaveLogoMessage.getText()+" is displayed in UI");
			if(YesButtonSaveLogo.getText().equals(_YesButtonSaveLogo)) {
				log(YesButtonSaveLogo.getText()+ " is displayed in UI");
				if(NoButtonSaveLogo.getText().equals(_NoButtonSaveLogo)) {
					log(NoButtonSaveLogo.getText()+" is displayed in UI");
					takeScreenShot();
					status="PASS";
				}
			}

		}
		return status;


	}

	public void clickonUploadbanner() {
		wh.waitForElementToBeClickable(UploadBannerlabel, driver, 10);
		clickElementUsingJavaScript(UploadBannerlabel);
		log("Upload banner icon label clicked");
		takeScreenShot();

	}

	public String verifyUploadbannerPopUpLabels(String _Browser, String _Filepath, String _Save,
			String _Cancel) throws IOException {
		status="FAIL";
		int window = driver.findElements(By.xpath("//span[@class='k-window-title' and text()='Upload Banner']")).size();			
		if(window==1) {
			UploadBannerBrowseButton.click();
			log("clicked on the Browse");

			uploadFile(_Browser, _Filepath);

			int cropPreview = driver.findElements(By.xpath("//*[@id='bCrop']")).size();
			if(cropPreview==1) {
				log("Crop Preview Image is displayed");
				log(SaveButtonUploadBanner.getText());
				if(SaveButtonUploadBanner.getText().equals(_Save)) {
					log(SaveButtonUploadBanner.getText()+" is displayed");
					if(CancelButtonUploadBanner.getText().equals(_Cancel)) {
						log(CancelButtonUploadBanner.getText()+" is displayed");
						takeScreenShot();
						status="PASS";
					}
				}
			}
		}
		return status;
	}

	public void clickonCancelUploadBanner() {
		wh.waitForElementToBeClickable(CancelButtonUploadBanner, driver, 10);
		CancelButtonUploadBanner.click();
		log("Clicked on the Cancel button in Upload banner pop up dialog");
		takeScreenShot();

	}

	public void clickonSaveUploadBanner() {
		wh.waitForElementToBeClickable(SaveButtonUploadBanner, driver, 10);
		SaveButtonUploadBanner.click();
		log("Clicked on the Save button in Upload banner pop up dialog");
		takeScreenShot();

	}

	public String verifyUploadbannerConfirmationDialog(String _SaveBannerMessage, String _YesButtonBaneruploadConfirmation, String _NoButtonBaneruploadConfirmation) {
		status="FAIL";

		if(SaveBannerMessage.getText().equals(_SaveBannerMessage)) {
			log(SaveBannerMessage.getText()+" is displayed in UI");
			if(YesButtonSaveLogo.getText().equals(_YesButtonBaneruploadConfirmation)) {
				log(YesButtonSaveLogo.getText()+ " is displayed in UI");
				if(NoButtonSaveLogo.getText().equals(_NoButtonBaneruploadConfirmation)) {
					log(NoButtonSaveLogo.getText()+" is displayed in UI");
					takeScreenShot();
					status="PASS";
				}
			}

		}
		return status;


	}

	public void clickonNoButtonConfirmUploadBannerDialog() {
		ConfirmPublishNoButton.click();
		log("clicked on No");
		takeScreenShot();

	}

	public void clickonYesButtonConfirmUploadBannerDialog() {
		ConfirmPublishYesButton.click();
		log("clicked on Yes");
		takeScreenShot();

	}

}

