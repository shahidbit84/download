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

public class BookingOverViewPage extends TestBase {
	WaitHelper wh = new WaitHelper(driver,test);
	MouseKeyboardHelper mkh = new MouseKeyboardHelper(driver,test);
    


	public static final Logger log = Logger.getLogger(CarParkListPage.class.getName());
	String status;


	public BookingOverViewPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);

	}

	//**************************************************************************************************

	@FindBy(xpath = "//span[@class='v-label' and translate='VSMCommon.ProgressLoading']")
	public WebElement loadingprogress;

	@FindBy(xpath = "//span[@class='v-label' and text()='SAVING...']")
	public WebElement savingprogress;

	@FindBy(xpath = "//div[contains(@v-label,'CH.SelectTenant')]/div/div//span/span[@class='k-dropdown-wrap k-state-default']")
	public WebElement TenantDropDown;
	
	@FindBy(xpath = "//*[@id='ssp_booking_details']")
	public WebElement BookingsOverViewPage_BookingDetailsLabel;
	
	
	@FindBy(xpath = "//*[@id='ssp_booking_cancel']")
	public WebElement BookingaOverViewPage_CancelBookings;
	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPBooking.searchByHeader']")
	public WebElement SearchBylabel;
	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPBooking.GridColumnBookingNumber']")
	public WebElement NameColumHeaderlabel;
	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPBooking.GridColumnProductName']")
	public WebElement ProductsNameColumHeaderlabel;
	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPBooking.GridColumnPurchaseDate']")
	public WebElement PurchaseDateColumHeaderlabel;
	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPBooking.GridColumnStartDate']")
	public WebElement StartDateColumHeaderlabel;
	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPBooking.GridColumnEndDate']")
	public WebElement EndDateColumHeaderlabel;
	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPBooking.GridColumnType']")
	public WebElement TypeColumHeaderlabel;
	
	@FindBy(xpath = "//span[@class='v-label ng-scope' and @translate='SSPBooking.GridColumnBookingStatus']")
	public WebElement BookingStatusColumHeaderlabel;
	
	
	
	public void waitforInvisibilityOfLoading() {
		waitForElementInVisiblity(driver, 10, loadingprogress);
		log("loading progress completed");
	}

	
/**
 * To verify the labels in the overview page
 * @param _BookingDetailsButton
 * @param _BookingCancelButton
 * @param _SearchBypage
 * @return
 * @throws InterruptedException
 */
		public String verifyIconLabelsinBookingOverViewPage(String _BookingDetailsButton,String _BookingCancelButton,String _SearchBypage) throws InterruptedException {
			status="FAIL";
			
			if(BookingsOverViewPage_BookingDetailsLabel.getText().equals(_BookingDetailsButton)){
				log(BookingsOverViewPage_BookingDetailsLabel.getText()+" label is displayed in the bookings overview page");
				if(BookingaOverViewPage_CancelBookings.getText().equals(_BookingCancelButton)) {
					log(BookingaOverViewPage_CancelBookings.getText()+" label is displayed in the bookings overview page");
							if(SearchBylabel.getText().equals(_SearchBypage)) {
								log(SearchBylabel.getText()+" label is displayed in the overview page");
										Thread.sleep(3000);
										takeScreenShot();
										status="PASS";	
					}
				}
			}
			return status;
		
		}
		
		public String verifyApplicationHeaderAndTableLabels(String _NameColHeader,String _ProductNameColHeader,String _PurchaseDateColHeader,
				String _StartDateColHeader,String _EndDateColHeader,String _TypeColHeader,String _BookingStatus) {
		
			status="FAIL";
				if(NameColumHeaderlabel.getText().equals(_NameColHeader)) {
					log("NameColumHeaderlabel is displayed as " +NameColumHeaderlabel.getText());
					if(ProductsNameColumHeaderlabel.getText().equals(_ProductNameColHeader)) {
						log("ProductsNameColumHeaderlabel is displayed as " +ProductsNameColumHeaderlabel.getText());
						if(PurchaseDateColumHeaderlabel.getText().equals(_PurchaseDateColHeader)) {
							log("PurchaseDateColumHeaderlabel is displayed as " +PurchaseDateColumHeaderlabel.getText());
							if(StartDateColumHeaderlabel.getText().equals(_StartDateColHeader)) {
								log("StartDateColumHeaderlabel is displayed as " +StartDateColumHeaderlabel.getText());
								if(EndDateColumHeaderlabel.getText().equals(_EndDateColHeader)) {	
									log("EndDateColumHeaderlabel is displayed as " +EndDateColumHeaderlabel.getText());
									if(TypeColumHeaderlabel.getText().equals(_TypeColHeader)) {	
										log("TypeColumHeaderlabel is displayed as " +TypeColumHeaderlabel.getText());
										if(BookingStatusColumHeaderlabel.getText().equals(_BookingStatus)) {	
											log("BookingStatusColumHeaderlabel is displayed as " +BookingStatusColumHeaderlabel.getText());
												status="PASS";
												takeScreenShot();
										}
									}
								}
							}
						}
					}
				}
			return status;
			
		}
	
		/**
		 * To select the tenant
		 * @param _TenantName
		 * @throws InterruptedException
		 */
		
		@FindBy(xpath = "//span[@class='v-tree-combo-box-expand ng-scope']")
		public WebElement AddTenant_Plus_Button;
		
		public void selectTenant(String _TenantName) throws InterruptedException {
			
			clickElementUsingJavaScript(TenantDropDown);
			Thread.sleep(6000);
			
			try {
				driver.findElement(By.xpath("//span[@class='v-tree-combo-box-expand ng-scope']")).click();
			} catch (Exception e) {
				
				clickElementUsingJavaScript(TenantDropDown);
				Thread.sleep(6000);
				driver.findElement(By.xpath("//span[@class='v-tree-combo-box-expand ng-scope']")).click();
			}
	//		clickElementUsingJavaScript(AddTenant_Plus_Button);
			
			WebElement selectTenant = driver.findElement(By.xpath("//span[@class='ng-binding ng-scope'][contains(text(),'"+_TenantName+"')]"));
			Thread.sleep(3000);
			clickElementUsingJavaScript(selectTenant);
		}
	
	
	public String searchAndSelectSearchedBookings(String _BookingNumber, String _CreatedCarParkBays,String _CreatedCarParkLatitude,String _CreatedCarParkLongitude) throws InterruptedException {
		status = "FAIL";
		Thread.sleep(8000);

		List<WebElement> carParkRows = driver.findElements(By.xpath("//table[@class='k-selectable']/tbody/tr"));
		log("No of rows found for car park list is "+carParkRows.size());
		for(int i=0;i<carParkRows.size();i++) {
			int j=i+1;
			WebElement NameColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[1]"));
			WebElement BaysColumnValue = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[2]"));
			WebElement latitude = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[3]"));
			WebElement longitude = driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]/td[4]"));

			if(NameColumnValue.getText().equals(_BookingNumber)) {		
				if(BaysColumnValue.getText().equals(_CreatedCarParkBays)) {
					log(NameColumnValue.getText()+" "+BaysColumnValue.getText()+" "+latitude.getText()+" "+longitude.getText()+" -> is displayed in the Table");
					
						driver.findElement(By.xpath("//table[@class='k-selectable']/tbody/tr["+j+"]")).click();
						log("car park is -> "+_BookingNumber+" is Searched and Selected ");
						status ="PASS";
						return status;
				
				}
			}

		}
		
		return status;

	}

	@FindBy(xpath = "//input[@ng-model='model.searchCriteria.reservationId']")
	public WebElement inputSearch_BookingNumber;
	
	@FindBy(xpath = "//button[@translate='SSPBooking.BookingForm-Search']")
	public WebElement search_Button;
	
	
	public void searchBooking_byNumber(String _BookingNumber) throws InterruptedException {

		inputSearch_BookingNumber.clear();
		sendKeys(inputSearch_BookingNumber, _BookingNumber);	
		
		Thread.sleep(20000);
		
		clickElementUsingJavaScript(search_Button);
		Thread.sleep(5000);
		log("Entered and searched for the Booking - "+_BookingNumber);
		takeScreenShot();
		
	}


	public String verifyBookingStatusSingleProd(String _BookingNumber,String _ProductName,String _Startdate,String _EndDate,String _type, String _BookingStatus) {
		status="FAIL";
		List<WebElement> rows = driver.findElements(By.xpath("//div[@kendo-grid='model.bookingsGrid']//tbody//tr"));
		
		wh.waitForElementToBeVisible(rows.get(0), driver, 30);
		
		for(int i=0;i<rows.size();i++) {
			int j=i+1;
			WebElement bookingNumberCol = driver.findElement(By.xpath("//div[@kendo-grid='model.bookingsGrid']//tbody//tr["+j+"]//td[1]"));
			WebElement productName = driver.findElement(By.xpath("//div[@kendo-grid='model.bookingsGrid']//tbody//tr["+j+"]//td[2]"));
			WebElement startDate = driver.findElement(By.xpath("//div[@kendo-grid='model.bookingsGrid']//tbody//tr["+j+"]//td[4]"));
			WebElement endDate = driver.findElement(By.xpath("//div[@kendo-grid='model.bookingsGrid']//tbody//tr["+j+"]//td[5]"));
			WebElement type = driver.findElement(By.xpath("//div[@kendo-grid='model.bookingsGrid']//tbody//tr["+j+"]//td[6]"));
			WebElement systemError = driver.findElement(By.xpath("//div[@kendo-grid='model.bookingsGrid']//tbody//tr["+j+"]//td[7]"));
			WebElement bookingStatusCol = driver.findElement(By.xpath("//div[@kendo-grid='model.bookingsGrid']//tbody//tr["+j+"]//td[8]"));
			
			
//			log(bookingNumberCol.getText());
//			log(productName.getText());
//			log(startDate.getText());
//			log(endDate.getText());
//			log(type.getText());
//			log(systemError.getText());
//			log(bookingStatusCol.getText());
			
	
			if(bookingNumberCol.getText().equals(_BookingNumber)) {
				if(productName.getText().equals(_ProductName)) {
					if(startDate.getText().equals(_Startdate)) {
						if(type.getText().equals(_type)) {
							if(endDate.getText().equals(_EndDate)) {
								if(systemError.getText().isEmpty()) {
									if(bookingStatusCol.getText().equals(_BookingStatus)) {
										status="PASS";
									log(bookingNumberCol.getText()+" "+productName.getText()+" "+bookingStatusCol.getText());
									}
								}
							}
						}
					}
				}
					
				else {
					status="FAIL";
					log("Booking status is "+bookingStatusCol.getText());
					return status;
				}
				
			}else {
				status="FAIL";
				log("Booking id Not found");
				takeScreenShot();
				return status;
				
			}
			takeScreenShot();
		}
		return status;
		
	}
	
	
	public String verifyBookingStatusSingleProdSub(String _BookingNumber,String _ProductName,String _Startdate,String _type, String _BookingStatus) {
		status="FAIL";
		List<WebElement> rows = driver.findElements(By.xpath("//div[@kendo-grid='model.bookingsGrid']//tbody//tr"));
		
		wh.waitForElementToBeVisible(rows.get(0), driver, 10);
		
		for(int i=0;i<rows.size();i++) {
			int j=i+1;
			WebElement bookingNumberCol = driver.findElement(By.xpath("//div[@kendo-grid='model.bookingsGrid']//tbody//tr["+j+"]//td[1]"));
			WebElement productName = driver.findElement(By.xpath("//div[@kendo-grid='model.bookingsGrid']//tbody//tr["+j+"]//td[2]"));
			WebElement purchasedate = driver.findElement(By.xpath("//div[@kendo-grid='model.bookingsGrid']//tbody//tr["+j+"]//td[3]"));
			WebElement startDate = driver.findElement(By.xpath("//div[@kendo-grid='model.bookingsGrid']//tbody//tr["+j+"]//td[4]"));
			WebElement endDate = driver.findElement(By.xpath("//div[@kendo-grid='model.bookingsGrid']//tbody//tr["+j+"]//td[5]"));
			WebElement type = driver.findElement(By.xpath("//div[@kendo-grid='model.bookingsGrid']//tbody//tr["+j+"]//td[6]"));
			WebElement systemError = driver.findElement(By.xpath("//div[@kendo-grid='model.bookingsGrid']//tbody//tr["+j+"]//td[7]"));
			WebElement bookingStatusCol = driver.findElement(By.xpath("//div[@kendo-grid='model.bookingsGrid']//tbody//tr["+j+"]//td[8]"));
			
			
			log(bookingNumberCol.getText());
			log(productName.getText());
			log(purchasedate.getText());
			log(startDate.getText());
			log(endDate.getText());
			log(type.getText());
			log(systemError.getText());
			log(_ProductName);
	
			if(bookingNumberCol.getText().equals(_BookingNumber)) {
				if(productName.getText().equals(_ProductName)) {
					if(startDate.getText().equals(_Startdate)) {
						if(type.getText().equals(_type)) {
								if(systemError.getText().isEmpty()) {
									if(bookingStatusCol.getText().equals(_BookingStatus)) {
										status="PASS";
									log(bookingNumberCol.getText()+" "+productName.getText()+" "+bookingStatusCol.getText());
									}
								}
							}
						}
					}
				
					
				else {
					status="FAIL";
					log("Booking status is "+bookingStatusCol.getText());
					return status;
				}
				
			}else {
				status="FAIL";
				log("Booking id Not found");
				takeScreenShot();
				return status;
				
			}
			takeScreenShot();
		}
		return status;
		
	}
	
	
	
	
	
	
	

//public void clickonDelete() {
//	wh.waitForElementToBeClickable(carparkListPage_Deleteiconlabel, driver, 10);
//	clickElementUsingJavaScript(carparkListPage_Deleteiconlabel);
//	log("Clicked on the Delete icon ");
//	takeScreenShot();
//	
//}
//
//public String verifyConfirmDeletePopUpLabelsAndClickX(String _DeleteCarParkConfirmMsg,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
//	status="FAIL";
//	log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
//	if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
//		log("Message is displayed -> "+deleteconfirmationMessage.getText());
//		if(deleteconfirmationMessage.getText().equals(_DeleteCarParkConfirmMsg)) {
//			log("Button Label is displayed -> "+YesButtoninDeleteConfirmation.getText());
//			if(YesButtoninDeleteConfirmation.getText().equals(_yesbuttonText)) {
//				log("Button Label is displayed -> "+NoButtoninDeleteConfirmation.getText());
//				if(NoButtoninDeleteConfirmation.getText().equals(_NobuttonText)) {
//					takeScreenShot();
//					wh.waitForElementToBeClickable(closeXiconinDeleteConfirmationPopup, driver, 10);
//					closeXiconinDeleteConfirmationPopup.click();
//					log("clicked on X icon");
//					status="PASS";
//					
//				}
//			}
//		}
//	}
//	return status;
//
//}
//
//public String verifyConfirmDeletePopUpLabelsAndClickNo(String _UnitName,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
//	status="FAIL";
//	log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
//	if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
//		log("Message is displayed -> "+deleteconfirmationMessage.getText());
//		if(deleteconfirmationMessage.getText().equals("Do you want to delete unit '"+_UnitName+"'?")) {
//			log("Button Label is displayed -> "+YesButtoninDeleteConfirmation.getText());
//			if(YesButtoninDeleteConfirmation.getText().equals(_yesbuttonText)) {
//				log("Button Label is displayed -> "+NoButtoninDeleteConfirmation.getText());
//				if(NoButtoninDeleteConfirmation.getText().equals(_NobuttonText)) {
//					takeScreenShot();
//					wh.waitForElementToBeClickable(NoButtoninDeleteConfirmation, driver, 10);
//					NoButtoninDeleteConfirmation.click();
//					log("clicked on X icon");
//					status="PASS";
//					
//				}
//			}
//		}
//	}
//	return status;
//
//}
//
//public String verifyConfirmDeletePopUpLabelsAndClickYes(String _UnitName,String _ConfirmdeleteLabel,String _yesbuttonText,String _NobuttonText) throws InterruptedException {
//	status="FAIL";
//	log(" Header Label is displayed -> "+ConfirmDeleteDialoglabel.getText());
//	if(ConfirmDeleteDialoglabel.getText().equals(_ConfirmdeleteLabel)){
//		log("Message is displayed -> "+deleteconfirmationMessage.getText());
//		if(deleteconfirmationMessage.getText().equals("Do you want to delete unit '"+_UnitName+"'?")) {
//			log("Button Label is displayed -> "+YesButtoninDeleteConfirmation.getText());
//			if(YesButtoninDeleteConfirmation.getText().equals(_yesbuttonText)) {
//				log("Button Label is displayed -> "+NoButtoninDeleteConfirmation.getText());
//				if(NoButtoninDeleteConfirmation.getText().equals(_NobuttonText)) {
//					takeScreenShot();
//					wh.waitForElementToBeClickable(YesButtoninDeleteConfirmation, driver, 10);
//					YesButtoninDeleteConfirmation.click();
//					log("clicked on yes icon");
//					status="PASS";
//					
//				}
//			}
//		}
//	}
//	return status;
//
//}
//
//
//public String clickYesDeleteConfirmation(String _UnitName) throws InterruptedException {
//	status="FAIL";
//					takeScreenShot();
//					if(deleteconfirmationMessage.getText().equals("Do you want to delete unit '"+_UnitName+"'?")) {
//					wh.waitForElementToBeClickable(YesButtoninDeleteConfirmation, driver, 10);
//					YesButtoninDeleteConfirmation.click();
//					log("clicked on yes icon");
//					status="PASS";
//					}
//					return status;
//
//
//}
	
	

}
