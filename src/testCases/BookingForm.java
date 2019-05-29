package testCases;


import java.io.FileInputStream;
import java.io.IOException;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;
import xlsReader.XlsReader;

@SuppressWarnings("deprecation")
public class BookingForm {
	
	static WebDriver driver; 
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, IOException {
//---- Add Properties file -----	
		Properties prop = new Properties();
		 FileInputStream input = new FileInputStream("D:\\Mayuresh\\Mayuresh Data\\Workspace\\MyFleetManDemo\\src\\Repository\\ObjectRepository.properties");
	        prop.load(input); 
//---- Select Browser ----
	    System.out.println(prop.getProperty("browser"));
		String browserName = prop.getProperty("browser");
	
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Mayuresh\\Desktop\\MyFleetman\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "D:\\Mayuresh\\Mayuresh Data\\Selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		else {
		System.out.println("Browser not Found");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//---- Add Username & Password from properties File ----	
		driver.findElement(By.xpath("//*[@id='myLogin_UserName']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//*[@id='myLogin_Password']")).sendKeys(prop.getProperty("password"));
	Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='myLogin_LoginButton']")).click();
		Thread.sleep(2000); 
		String PageTitle = driver.getTitle();
		System.out.println("Page Title is : " + PageTitle);	
		
//---- Add Excel File Data ----
		XlsReader reader = new XlsReader ("D:\\Mayuresh\\Desktop\\MyFleetman\\MyFleetMan.xlsx");
		int rowCount = reader.getRowCount("Booking");
	
	for(int rowNo=2; rowNo<=rowCount; rowNo++){
		
//---- Click on Add New Bookings ----
	Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("/html/body/form/div[3]/div[1]/a[2]/i"));
	Thread.sleep(2000);
		element.click();
	Thread.sleep(1500);
		Actions Action = new Actions(driver);
		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"ctl00_rptMenu_ctl06_masters\"]"));
		Action.moveToElement(element1).click().build().perform();
	Thread.sleep(1500);
		Actions Action1 = new Actions(driver);
		WebElement element2 = driver.findElement(By.xpath("//*[@id=\"ctl00_rptMenu_ctl06_rptSubMenu_ctl01_HyperLink1\"]"));
		Action1.moveToElement(element2).click().build().perform();
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnNew")).click();
		
//---- Parameterization	----
		System.out.println("***Inputs*****");
//---- Sheet = Booking ----	
		String PrefixCompany = reader.getCellData("Booking", "PrefixCompany", rowNo);
		System.out.println(PrefixCompany);
		
		String CompanyName = reader.getCellData("Booking", "CompanyName", rowNo);
		System.out.println(CompanyName);
				
		String ServingCity = reader.getCellData("Booking", "ServingCity", rowNo);
		System.out.println(ServingCity);
		
		String BookingMode = reader.getCellData("Booking", "BookingMode", rowNo);
		System.out.println(BookingMode);
		
		String FromYear = reader.getCellData("Booking", "FromYear", rowNo);
		System.out.println(FromYear);
		
		String FromMonth = reader.getCellData("Booking", "FromMonth", rowNo);
		System.out.println(FromMonth);
		
		String FromDay = reader.getCellData("Booking", "FromDay", rowNo);
		System.out.println(FromDay);
				
		String NoofGuests = reader.getCellData("Booking", "NoofGuests", rowNo);
		System.out.println(NoofGuests);
		
		String GuestName = reader.getCellData("Booking", "GuestName", rowNo);
		System.out.println(GuestName);
		
		String MobileNo  = reader.getCellData("Booking", "MobileNo ", rowNo);
		System.out.println(MobileNo );
		
		String EmailId = reader.getCellData("Booking", "EmailId", rowNo);
		System.out.println(EmailId);
		
		String Time = reader.getCellData("Booking", "Time", rowNo);
		System.out.println(Time);
		
		String PickupAddress = reader.getCellData("Booking", "PickupAddress", rowNo);
		System.out.println(PickupAddress);
		
		String PickupLocation = reader.getCellData("Booking", "PickupLocation", rowNo);
		System.out.println(PickupLocation);
		
		String PickupLocation1 = reader.getCellData("Booking", "PickupLocation1", rowNo);
		System.out.println(PickupLocation1);
		
		String PickupLocation2 = reader.getCellData("Booking", "PickupLocation2", rowNo);
		System.out.println(PickupLocation2);
		
		String DropAddress = reader.getCellData("Booking", "DropAddress", rowNo);
		System.out.println(DropAddress);
		
		String DropLocation = reader.getCellData("Booking", "DropLocation", rowNo);
		System.out.println(DropLocation);
		
		String DropLocation1 = reader.getCellData("Booking", "DropLocation1", rowNo);
		System.out.println(DropLocation1);
		
		String DropLocation2 = reader.getCellData("Booking", "DropLocation2", rowNo);
		System.out.println(DropLocation2);

		String VIP = reader.getCellData("Booking", "VIP", rowNo);
		System.out.println(VIP);
		
		String Lady = reader.getCellData("Booking", "Lady", rowNo);
		System.out.println(Lady);
		
		String BookingGivenBy = reader.getCellData("Booking", "BookingGivenBy", rowNo);
		System.out.println(BookingGivenBy);
		
		String BookingByContactNo = reader.getCellData("Booking", "BookingByContactNo", rowNo);
		System.out.println(BookingByContactNo);
		
		String BookingByEmailId = reader.getCellData("Booking", "BookingByEmailId", rowNo);
		System.out.println(BookingByEmailId);
		
		String CompanyRefNo = reader.getCellData("Booking", "CompanyRefNo", rowNo);
		System.out.println(CompanyRefNo);
		
		String PaymentType = reader.getCellData("Booking", "PaymentType", rowNo);
		System.out.println(PaymentType);
		
		String Security = reader.getCellData("Booking", "Security", rowNo);
		System.out.println(Security);
		
		String VehicleType = reader.getCellData("Booking", "VehicleType", rowNo);
		System.out.println(VehicleType);
		
		String Carrier = reader.getCellData("Booking", "Carrier", rowNo);
		System.out.println(Carrier);
		
		String PackageFor = reader.getCellData("Booking", "PackageFor", rowNo);
		System.out.println(PackageFor);
		
		String PackageName = reader.getCellData("Booking", "PackageName", rowNo);
		System.out.println(PackageName);
		
		String TotalVehicles = reader.getCellData("Booking", "TotalVehicles", rowNo);
		System.out.println(TotalVehicles);
		
		String AdvanceAmt = reader.getCellData("Booking", "AdvanceAmt", rowNo);
		System.out.println(AdvanceAmt);
		
		String PaymentMode = reader.getCellData("Booking", "PaymentMode", rowNo);
		System.out.println(PaymentMode);
		
		String Remark = reader.getCellData("Booking", "Remark", rowNo);
		System.out.println(Remark);
		
//---- Sheet = Allocation ----	
		String SelfOrVendor = reader.getCellData("Allocation", "SelfOrVendor", rowNo);
		System.out.println(SelfOrVendor);
				
		String SearchVehicle = reader.getCellData("Allocation", "SearchVehicle", rowNo);
		System.out.println(SearchVehicle);
		
		String SearchVendorVehicle = reader.getCellData("Allocation", "SearchVendorVehicle", rowNo);
		System.out.println(SearchVendorVehicle);
		
		String Parking = reader.getCellData("Allocation", "Parking", rowNo);
		System.out.println(Parking);
		
		String AllocationType = reader.getCellData("Allocation", "AllocationType", rowNo);
		System.out.println(AllocationType);
		
		String DrierName = reader.getCellData("Allocation", "DrierName", rowNo);
		System.out.println(DrierName);

		System.out.println("****Output****");
		
//------ insert Data to Booking Form -----
//----- Select on click Textbox -----	
		driver.findElement(By.id("txtCompanyName")).clear();
		driver.findElement(By.id("txtCompanyName")).click();
		driver.findElement(By.id("txtCompanyName")).sendKeys(PrefixCompany);

		driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
		List<WebElement> list = driver.findElements(By.className("ui-menu-item"));
		
		for (WebElement listview : list) {
			if(listview.getText().equalsIgnoreCase(CompanyName)) {
			 Actions actions = new Actions(driver);
			    actions.moveToElement(listview);
			    Thread.sleep(1000);
			    listview.click();   
				}			
			}
		
		if(driver.getPageSource().contains(CompanyName)){
			System.out.println("company name is : " + CompanyName);
			} else{
				System.out.println("Enter Company name");
				}

		Select s2 = new Select(driver.findElement(By.id("ddlCity")));
		s2.selectByVisibleText(ServingCity);
		System.out.println("Serving City is : " + ServingCity);
		
		Select s3 = new Select(driver.findElement(By.id("ddlBookingMode")));
		s3.selectByVisibleText(BookingMode);
		System.out.println("Booking Mode is : " + BookingMode);

//---- Select Calendar Date - DD-MM-YYYY ----	
	Thread.sleep(1000);
		driver.findElement(By.id("txtFromDate")).click();
			try{			
//---- Select Year ----
	Thread.sleep(1000);
		Select s4 = new Select(driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-year")));
		s4.selectByVisibleText(FromYear);
//---- Select Month ----
		Select s5 = new Select(driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-month")));
		s5.selectByVisibleText(FromMonth);
//---- Select Day ----	
	Thread.sleep(1000);
		List <WebElement> Days = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a"));
		for(WebElement d:Days){
			d.getText();
			if(d.getText().equals(FromDay)){
				d.click();
					}
				}
			} catch (Exception e){
				System.out.println("From Date : " + FromDay + "/" + FromMonth + "/" + FromYear );
				}
			
//---- Select Dropdown ----	
	Thread.sleep(1000);				
		Select s6 = new Select(driver.findElement(By.id("ddlGuestsNo")));
		s6.selectByVisibleText(NoofGuests);
		System.out.println("No. of Guests : " + NoofGuests);
		
		driver.findElement(By.xpath("//*[@id='txtCustomerName_1']")).clear();
		driver.findElement(By.xpath("//*[@id='txtCustomerName_1']")).sendKeys(GuestName);
		System.out.println("Guest Name is : " + GuestName);
		
		driver.findElement(By.xpath("//*[@id='txtMobileNo_1']")).clear();
		driver.findElement(By.xpath("//*[@id='txtMobileNo_1']")).sendKeys(MobileNo);
		System.out.println("Mobile No. is : " + MobileNo);
		
		driver.findElement(By.xpath("//*[@id='txtEmailId_1']")).clear();
		driver.findElement(By.xpath("//*[@id='txtEmailId_1']")).sendKeys(EmailId);
		System.out.println("Email Id : " + EmailId);
		
		driver.findElement(By.id("txtReportingTime_1")).clear();
		driver.findElement(By.id("txtReportingTime_1")).sendKeys(Time);
		System.out.println("Time is : " + Time );
		
	Thread.sleep(1000);
		Select PA = new Select (driver.findElement(By.xpath("//*[@id='ddlPickupPlace_1']")));
		PA.selectByVisibleText(PickupAddress);
		System.out.println("Pickup Address is : " + PickupAddress);
		
		if(PickupAddress.equals("Hotel") || PickupAddress.equalsIgnoreCase("Airport")){
		
		driver.findElement(By.id("PickupField1_1")).clear();
		driver.findElement(By.id("PickupField1_1")).sendKeys(PickupLocation1);
		System.out.println("Pickup Location is : " + PickupLocation1);
		
		
		driver.findElement(By.id("PickupField2_1")).clear();
		driver.findElement(By.id("PickupField2_1")).sendKeys(PickupLocation2);
		System.out.println("Pickup Location is : " + PickupLocation2);
		} else{
			driver.findElement(By.xpath("//*[@id='txtpickuplacefrom_1']")).clear();
			driver.findElement(By.xpath("//*[@id='txtpickuplacefrom_1']")).sendKeys(PickupLocation);
			System.out.println("Pickup Location is : " + PickupLocation);
		}
	Thread.sleep(1000);
		Select DA = new Select (driver.findElement(By.id("ddlDropPlace_1")));
		DA.selectByVisibleText(DropAddress);
		System.out.println("Drop Address is : " + DropAddress);
		
		if(DropAddress.equalsIgnoreCase("Airport")|| DropAddress.equalsIgnoreCase("Hotel") ){
		
		driver.findElement(By.id("DropField1_1")).clear();
		driver.findElement(By.id("DropField1_1")).sendKeys(DropLocation1);
		System.out.println("Drop Location is : " + DropLocation1);
		
		driver.findElement(By.id("DropField2_1")).clear();
		driver.findElement(By.id("DropField2_1")).sendKeys(DropLocation2);
		System.out.println("Drop Location is : " + DropLocation2);
		}else{
			driver.findElement(By.xpath("//*[@id='txtpickuplaceto_1']")).clear();
			driver.findElement(By.xpath("//*[@id='txtpickuplaceto_1']")).sendKeys(DropLocation);
			System.out.println("Drop Location is : " + DropLocation);
		}
		
//---- Click on Check box ----
	Thread.sleep(1000);
		if(VIP.equalsIgnoreCase("Yes") && Lady.equalsIgnoreCase("No")) {
				WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"chkVIP_1\"]"));
				checkbox1.click();
			}else if(Lady.equalsIgnoreCase("Yes") && VIP.equalsIgnoreCase("No") ) {
				WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"chkLady_1\"]"));
			checkbox2.click();
			}
			else if(VIP.equalsIgnoreCase("Yes") && Lady.equalsIgnoreCase("Yes"))
			{
				WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"chkVIP_1\"]"));
				checkbox1.click();
				WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"chkLady_1\"]"));
				checkbox2.click();
			}
	
	Thread.sleep(2000);
		driver.findElement(By.id("txtBookingGivenBy")).clear();
		driver.findElement(By.id("txtBookingGivenBy")).sendKeys(BookingGivenBy);
		System.out.println("Booking Given By : " + BookingGivenBy);
		
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtBookingContactNo']")).clear();
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtBookingContactNo']")).sendKeys(BookingByContactNo);
		System.out.println("Booking By Contact No. : " + BookingByContactNo);
		
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtBoookerEmailId']")).clear();
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtBoookerEmailId']")).sendKeys(BookingByEmailId);
		System.out.println("Booking By Email Id : " + BookingByEmailId);
		
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtCmpReference']")).clear();
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtCmpReference']")).sendKeys(CompanyRefNo);
		System.out.println("Company Ref. No. : " + CompanyRefNo);
				
//----- Click on RadioButtons : Cash, BTC ----
//----- Value assign to :- Cash = rdoCash ; BTC = rdoBTC
		List<WebElement> radio = driver.findElements(By.xpath("//input[@name = 'ctl00$ContentPlaceHolder1$Direct' and @type = 'radio']"));
			for(int i=0;i<radio.size();i++){
				WebElement local_radio = radio.get(i);
				String value = local_radio.getAttribute("value");	
			if(value.equals(PaymentType)){
					local_radio.click();
				}
			}
			System.out.println("Payment type : " + PaymentType);
			
	Thread.sleep(1000);
			if(Security.equals("Yes")) {
				WebElement Security_box = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_chkIsSecurityNeed']"));
				Security_box.getAttribute("value3");
				Security_box.click();
				System.out.println("Security : " + Security);
				}			
			
	Thread.sleep(1000);
		Select VT = new Select (driver.findElement(By.id("ddlVehicalType")));
		VT.selectByVisibleText(VehicleType);
		System.out.println("Vehicle Type : " + VehicleType);
		
	Thread.sleep(1000);
		if(Carrier.equals("Yes")) {
			WebElement Carrierbox = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_chkIsCarrier']"));
			Carrierbox.getAttribute("value2");
			Carrierbox.click();
			System.out.println("Carrier : " + Carrier);
			}
		
	Thread.sleep(1000);
		Select PF = new Select (driver.findElement(By.id("ddlPackageFor")));
		PF.selectByVisibleText(PackageFor);
		System.out.println("Package For : " + PackageFor);
		
	Thread.sleep(1000);
		Select PN = new Select (driver.findElement(By.id("ddlPackageName")));
		PN.selectByVisibleText(PackageName);
		System.out.println("Package Name : " + PackageName);
		
	Thread.sleep(1000);
		driver.findElement(By.id("txtVehicleCount")).clear();
		driver.findElement(By.id("txtVehicleCount")).sendKeys(TotalVehicles);
		System.out.println("Total No. of Vehicles : " + TotalVehicles);
				
		/*driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtAdvanceAmount']")).clear();
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtAdvanceAmount']")).sendKeys(AdvanceAmt);
		System.out.println("Advance Amt. : " + AdvanceAmt);
		
	Thread.sleep(1000);
		Select PM = new Select (driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ddlPaymentType']")));
		PM.selectByVisibleText(PaymentMode);
		System.out.println("Payment Mode is : " + PaymentMode);*/
		
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtDestination']")).clear();
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtDestination']")).sendKeys(Remark);
		System.out.println("Advance Amt. : " + Remark);
		
		
		driver.findElement(By.id("btnSaveAllocaion")).click();

//----- Get Title of the Page -----
	Thread.sleep(10000);
		String actual_msg = driver.switchTo().alert().getText();
		System.out.println("Alert message is : " + actual_msg );
		driver.switchTo().alert().accept();
		String expected_msg = "Booking saved successfully."; 
		Assert.assertEquals(expected_msg, actual_msg);
	  
//----- Switch to Old Window ------
	Thread.sleep(3000);
		 String Booking = driver.getWindowHandle();
		 driver.switchTo().window(Booking);
		 String PageTitle2 = driver.getTitle();
		 System.out.println("Page title is : " + PageTitle2);

	
//-----Insert Data to Allocation Form --------
//---- Select Radio Button : Self, Vendor ------
	Thread.sleep(4000);
		List<WebElement> radio3 = driver.findElements(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_rdBookingType']/tbody/tr/td/input"));
			for(int i=0;i<radio3.size();i++){
				WebElement local_radio3 = radio3.get(i);
				String value = local_radio3.getAttribute("value");
				if(value.equals(SelfOrVendor)){
					local_radio3.click();
				}
			}
		System.out.println("Type is : " + SelfOrVendor);
		
		if (SelfOrVendor.equalsIgnoreCase("Self")){
				driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVehicleNumberSearch']")).clear();
				driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVehicleNumberSearch']")).sendKeys(SearchVehicle);
				driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVehicleNumberSearch']")).sendKeys(Keys.TAB);
				System.out.println("Vehicle number is : " + SearchVehicle);	
	
	Thread.sleep(5000);
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtDriverNameSaswad")).clear();
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtDriverNameSaswad")).sendKeys(DrierName);
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtDriverNameSaswad")).sendKeys(Keys.TAB);
			System.out.println("Driver name is : " + DrierName);
		
	Thread.sleep(4000);
			Select Park = new Select (driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_ddlParkingName']")));
			Park.selectByVisibleText(Parking);
			System.out.println("Package For : " + Parking);
	
	Thread.sleep(2000);
			Select AT = new Select (driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_ddlAllocationType']")));
				AT.selectByVisibleText(AllocationType);
				System.out.println("Allocation Type : " + AllocationType);
			}
		
		else if(SelfOrVendor.equalsIgnoreCase("Vendor")){
			
	Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVehicleNumberSearch']")).clear();
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVehicleNumberSearch']")).sendKeys(SearchVendorVehicle);
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVehicleNumberSearch']")).sendKeys(Keys.TAB);
			System.out.println("Vehicle number is : " + SearchVendorVehicle);
			
	Thread.sleep(3000);
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtDriverNameSaswad")).clear();
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtDriverNameSaswad")).sendKeys(DrierName);
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtDriverNameSaswad")).sendKeys(Keys.TAB);
			System.out.println("Driver name is : " + DrierName);

	Thread.sleep(2000);
			Select AT = new Select (driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_ddlAllocationType']")));
				AT.selectByVisibleText(AllocationType);
				System.out.println("Allocation Type : " + AllocationType);	
			}
//----- Final Click on SAVE Allocation ------		
	Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_btnSave']")).click();

//----- Switch to dashboard -----
	Thread.sleep(25000);
		String Allocation = driver.getWindowHandle();
		driver.switchTo().window(Allocation);
		String PageTitle3 = driver.getTitle();
		System.out.println("Page title is : " + PageTitle3);
	Thread.sleep(5000);	
	}
	}
					
}