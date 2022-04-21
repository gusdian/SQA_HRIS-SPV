package com.juaracoding.HRIS_SPV.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.HRIS_SPV.drivers.DriverSingleton;

public class ApprovalPage {
	private WebDriver driver;
	
	public ApprovalPage() {
		this.driver=DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='sidebar']/div/div[1]/ul[2]/li[11]/a/span")
	WebElement ListMenu;
	
	@FindBy(xpath = "//*[@id='sidebar']/div/div[1]/ul[2]/li[11]/ul/li[2]/a")
	WebElement ListSubMenu;
	
	@FindBy(css = "#table_length > label > select")
	WebElement Entries1;
	
	@FindBy(xpath = "//*[@id='table_length']/label/select/option")
	List<WebElement> ListEntries1;
	
	@FindBy(css = "#table_filter > label > input")
	WebElement Filter1;
	
//	@FindBy(css = "#table > tbody > tr:nth-child(1) > td:nth-child(1)")
//	WebElement ViewEdit;
	
	@FindBy(xpath = "//*[@title=\"Detail\"]")
	List<WebElement> EditData;
	
	@FindBy(id = "Temp_Name")
	WebElement Name;
	
	@FindBy(id = "Period_Start_Date")
	WebElement StartDate;
	
	@FindBy(id = "Period_End_Date")
	WebElement EndDate;
	
	@FindBy(id = "Review_Count")
	WebElement ReviewCount;
	
	@FindBy(xpath = "//*[@id='Review_Count']/option")
	List<WebElement>ListReviewCount;
	
	@FindBy(css = "#btnSubmit")
	WebElement Submit1;
	
	@FindBy(css = "#content > h1 > a")
	WebElement Next1;
	
	@FindBy(css = "#content > h1 > a.btn.btn-danger")
	WebElement Mundur1;
	
	@FindBy(css = "#content > h1 > a")
	WebElement Next2;
	
	@FindBy(id = "Weight")
	List<WebElement> Weight1;
	
	@FindBy(id = "Weight")
	List<WebElement> Weight2;
	
	@FindBy(css = "#tab-category > div > div > div > form > div.row > div > button")
	WebElement Submit2;
	
	@FindBy(css = "#content > h1 > a.btn.btn-success")
	WebElement Next3;
	
	@FindBy(css = "#content > h1 > a")
	WebElement Mundur2;
	
	@FindBy(css = "#content > h1 > a.btn.btn-success")
	WebElement Next4;
	
	@FindBy(id = "Objective_Name")
	WebElement Parameter1;
	
	@FindBy(id = "Objective_Description")
	WebElement Target1;
	
	@FindBy(css = "#tab-category > div > div:nth-child(1) > div > form > button")
	WebElement Submit3;
	
	@FindBy(css = "#table_length > label > select")
	WebElement Entries2;
	
	@FindBy(xpath = "//*[@id='table_length']/label/select/option")
	List<WebElement> ListEntries2;
	
	@FindBy(css = "#table_filter > label > input")
	WebElement Filter2;
	
	@FindBy(css = "#table > tbody > tr > td:nth-child(4) > a")
	WebElement deleteData;	
	
//	@FindBy(css = "#content > div:nth-child(8) > div > ul > li:nth-child(2) > a > span.d-sm-block.d-none > i")
//	WebElement NextTarget;
	
	@FindBy(id = "Objective_Name")
	WebElement Parameter2;
	
	@FindBy(id = "Objective_Description")
	WebElement Target2;
	
	@FindBy(css = "#tab-category > div > div:nth-child(1) > div > form > button")
	WebElement Submit4;
	
	@FindBy(css = "#tab-category > div > div > div > a")
	WebElement ApproveTarget;
	
	@FindBy(css = "#content > div.alert.alert-warning.alert-dismissable")
	WebElement TxtSuccessApprove;
	
	public void MenuPA() {
		ListMenu.click();
		ListSubMenu.click();
	}
	
	public void indexApproval(String filter1) {
		tunggu();
		Entries1.click();
		ListEntries1.get(1).click();
		Filter1.sendKeys(Keys.chord(Keys.CONTROL+"a"));
		Filter1.sendKeys(filter1);
		Filter1.sendKeys(Keys.ENTER);
		ListMenu.click();
		ListSubMenu.click();
		tunggu();
		EditData.get(0).click();
	}
	
	public void EditDataApproval(String name, String startDate, String endDate, String weight1, String weight2, String param1, String tar1, String filter2, String param2, String tar2 ) {
		tunggu();
		Name.sendKeys(Keys.chord(Keys.CONTROL+"a"));
		Name.sendKeys(name);
		StartDate.sendKeys(Keys.chord(Keys.CONTROL+"a"));
		StartDate.sendKeys(startDate);
		StartDate.sendKeys(Keys.ENTER);
		EndDate.sendKeys(Keys.chord(Keys.CONTROL+"a"));
		EndDate.sendKeys(endDate);
		EndDate.sendKeys(Keys.ENTER);
		ReviewCount.click();
		ListReviewCount.get(2).click();
		scroll();
		Submit1.click();
		Next1.click();
		tunggu();
		Mundur1.click();
		tunggu();
		Next2.click();
		Weight1.get(0).sendKeys(weight1);
		tunggu();
		Weight2.get(1).sendKeys(weight2);
		Submit2.click();
		Next3.click();
		tunggu();
		Mundur2.click();
		Next4.click();
		tunggu();
		Parameter1.sendKeys(param1);
		tunggu();
		Target1.sendKeys(tar1);
		tunggu();
		Submit3.click();
		tunggu();
		scroll();
		deleteData.click();
		tunggu();
		Alert alert_box = driver.switchTo().alert();
		alert_box.accept(); 
		Parameter2.sendKeys(param2);
		tunggu();
		Target2.sendKeys(tar2);
		tunggu();
		Submit4.click();
		scroll();
		ApproveTarget.click();
	}
	
	public String getTxtApprovalTarget() {
	return TxtSuccessApprove.getText();	
	}
	
	public void tunggu() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void scroll() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)");
	}
}
