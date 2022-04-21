package com.juaracoding.HRIS_SPV.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.HRIS_SPV.drivers.DriverSingleton;

public class CekPenilaianPage {
	private WebDriver driver;

	public CekPenilaianPage() {
		this.driver=DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='sidebar']/div/div[1]/ul[2]/li[11]/a/span")
	WebElement ListMenu;
	
	@FindBy(xpath = "//*[@id='sidebar']/div/div[1]/ul[2]/li[11]/ul/li[4]/a")
	WebElement ListSubMenu;
	
	@FindBy(xpath = "//*[@id='table']/tbody/tr/td/a")
	List<WebElement>EditData;
	
	@FindBy(id = "btneditnumber")
	WebElement EditPenilaianQuantity;
	
	@FindBy(id = "Actual_Result_Number")
	List <WebElement> InputActualNumber;
	
	@FindBy(id = "Score1")
	List<WebElement> Score1;
	
	@FindBy(id = "Score2")
	List<WebElement> Score2;
	
	@FindBy(css = "#btnUpdateNumber > button.btn.btn-primary")
	WebElement Update1;
	
	@FindBy(id = "btneditrating")
	WebElement EditRating;
	
	@FindBy(id = "Actual_Result_Rating")
	List<WebElement> InputActualRating;
	
	@FindBy(xpath = "//span[@id='f_star_1_324']")
	WebElement Star1;
	
	@FindBy(xpath = "//span[@id='f_star_2_325']")
	WebElement Star2;
	
	@FindBy(css = "#btnUpdateRating > button.btn.btn-primary")
	WebElement Update2;
	
	@FindBy(css = "#btnEditText > button")
	WebElement EditAspiration;
	
	@FindBy(id = "Actual_Result_Text_1")
	WebElement InputActualText;
	
	@FindBy(css = "#btnUpdateText > button.btn.btn-danger")
	WebElement CancelUpdate;
	
	@FindBy(css = "#content > div.row > div:nth-child(2) > div.col-lg-12 > form > button")
	WebElement SimpanData;
	
	@FindBy(xpath = "//*[@id='content']/div[1]")
	WebElement txtBerhasilCekPenilaian;
	
	public void MenuPA() {
		ListMenu.click();
		ListSubMenu.click();
	}
	
	public void EditPenilaian(String actualNum1, String actualNum2, String score1, String score2, String rating1, String rating2, String text) {
		tunggu();
		EditData.get(1).click();
		scroll(3);
		EditPenilaianQuantity.click();
		InputActualNumber.get(0).sendKeys(actualNum1);
		tunggu();
		Score1.get(0).sendKeys(score1);
		tunggu();
		InputActualNumber.get(1).sendKeys(actualNum2);
		tunggu();
		Score2.get(0).sendKeys(score2);
		tunggu();
		Update1.click();
		tunggu();
		scroll(5);
		tunggu();
		EditRating.click();
		InputActualRating.get(0).sendKeys(rating1);
		tunggu();
		Star1.click();
		tunggu();
		InputActualRating.get(1).sendKeys(rating2);
		tunggu();
		Update2.click();
		tunggu();
		scroll(7);
		tunggu();
		EditAspiration.click();
		tunggu();
		InputActualText.sendKeys(text);
		tunggu();
		CancelUpdate.click();
		SimpanData.click();
	}
	
	public String getTxtBerhasilCekPenilaiant() {
	return txtBerhasilCekPenilaian.getText();	
	}
	
	public void tunggu() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void scroll(int kali) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)");
	}
}
