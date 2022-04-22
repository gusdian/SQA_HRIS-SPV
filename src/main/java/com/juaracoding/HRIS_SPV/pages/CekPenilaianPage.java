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
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(11)")
	WebElement menuPA;
	
	@FindBy(xpath = "//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[11]/ul/li")
	List<WebElement> submenuCekPenilaian;
	
	@FindBy(css = "#content > h1:nth-child(3)")
	WebElement txtCekPenilaian;
	
	@FindBy(xpath = "//*[@id=\"table\"]/tbody/tr[1]/td[3]/a")
	WebElement btnAction;
	
	//-----Quantity Aspect-----
	
	@FindBy(css = "#heading1")
	WebElement collapseQuantity;
	
	@FindBy(css = "#btneditnumber")
	WebElement btnEditQuantity;
	
	@FindBy(id = "Actual_Result_Number")
	WebElement inputActual1;
	
	@FindBy(id = "Score1")
	WebElement inputScore1;
	
	@FindBy(xpath = "//*[@value]")
	List<WebElement> listScore1;
	
	@FindBy(id = "Actual_Result_Number")
	WebElement inputActual2;
	
	@FindBy(id = "Score2")
	WebElement inputScore2;
	
	@FindBy(xpath = "//*[@value]")
	List<WebElement> listScore2;
	
	@FindBy(css = "#btnUpdateNumber > button.btn.btn-primary")
	WebElement btnUpdateQuantity;
	
	@FindBy(css = "#btnUpdateNumber > button.btn.btn-danger")
	WebElement btnCancelQuantity;
	
	//-----Quality Aspect-----
	
	@FindBy(css = "#heading2")
	WebElement collapseQuality;
	
	@FindBy(css = "#btneditrating")
	WebElement btnEditQuality;
	
	@FindBy(id = "Actual_Result_Rating")
	WebElement inputActRat1;
	
	@FindBy(id = "f_star_3_391")
	WebElement inputRat1;
	
	@FindBy(id = "Actual_Result_Rating")
	WebElement inputActRat2;
	
	@FindBy(id = "f_star_2_351")
	WebElement inputRat2;
	
	@FindBy(css = "#btnUpdateRating > button.btn.btn-primary")
	WebElement btnUpdateQuality;
	
	@FindBy(css = "#btnUpdateRating > button.btn.btn-danger")
	WebElement btnCancelQuality;
	
	//-----Aspiration-----
	
	@FindBy(css = "#heading3")
	WebElement collapseAspiration;
	
	@FindBy(css = "#btnEditText > button")
	WebElement btnEditAspiration;
	
	@FindBy(id = "Actual_Result_Text_1")
	WebElement inputAspiration;
	
	@FindBy(css = "#btnUpdateText > button.btn.btn-primary")
	WebElement btnUpdateAspiration;
	
	@FindBy(css = "#btnUpdateText > button.btn.btn-danger")
	WebElement btnCancelAspiration;
	
	//-----Final Rating-----
	
	@FindBy(css = "#heading5")
	WebElement collapseFinal;
	
	@FindBy(css = "#content > div.row > div:nth-child(2) > div.col-lg-12 > form > button")
	WebElement btnSimpanDataPenilaian;
	
	@FindBy(xpath = "//div[contains(concat(' ',normalize-space(@class),' '),'')]")
	WebElement txtBerhasil;
	
	//-----Show Search Page Sort-----
	
	@FindBy(css = "#table_length > label > select")
	WebElement btnRange;
	
	@FindBy(xpath = "//*[@value]")
	List<WebElement> showRange;
	
	@FindBy(css = "#table > thead > tr > th:nth-child(2)")
	WebElement sortAscending;
	
	@FindBy(css = "#table_next > a")
	WebElement pageNext;
	
	@FindBy(css = "#table_previous > a")
	WebElement pagePrevious;
	
	@FindBy(css = "#table_filter > label > input")
	WebElement inputSearch;
	
	@FindBy(css = "#btnSearch")
	WebElement btnSearch;
	
	
	
	//------------Process--------
	public void goToMenuCekPenilaian() {
		menuPA.click();
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView();",submenuCekPenilaian.get(1));
		submenuCekPenilaian.get(3).click();
	}
	
	public String getTxtCekPenilaian() {
		return txtCekPenilaian.getText();
	}
	
	public void goToBtnAction() {
		btnAction.click();
	}
	
	//Quantity Aspect
	public void collapseQuantityAspect() {
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,400)");
		collapseQuantity.click();
		tunggu(2);
		collapseQuantity.click();
	}
	
	public void editQuantityAspect(String actual1) {
		btnEditQuantity.click();
		inputActual1.clear();
		inputActual1.sendKeys(actual1);
		inputScore1.click();
		listScore1.get(4).click();
		btnUpdateQuantity.click();
	}
	
	public void cancelQuantityAspect() {
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,400)");
		btnEditQuantity.click();
		btnCancelQuantity.click();
	}
	
	//Quality Aspect
	public void collapseQualityAspect() {
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,300)");
		collapseQuality.click();
		tunggu(2);
		collapseQuality.click();
	}
	
	public void editQualityAspect(String actualRat1) {
		btnEditQuality.click();
		inputActRat1.clear();
		inputActRat1.sendKeys(actualRat1);
		inputRat1.click();
		btnUpdateQuality.click();
	}
	
	public void cancelQualityAspect() {
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,900)");
		btnEditQuality.click();
		btnCancelQuality.click();
	}
	
	//Aspiration
	public void collapseAspiration() {
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,300)");
		collapseAspiration.click();
		tunggu(2);
		collapseAspiration.click();
	}
	
	public void editAspiration(String aspiration) {
		btnEditAspiration.click();
		inputAspiration.clear();
		inputAspiration.sendKeys(aspiration);
		btnUpdateAspiration.click();
	}
	
	public void cancelAspiration() {
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,1538)");
		btnEditAspiration.click();
		btnCancelAspiration.click();
	}
	
	//FinalRating
	public void collapseFinalRating() {
		collapseFinal.click();
		tunggu(1);
	}
	
	public void simpanDataPenilaian() {
		btnSimpanDataPenilaian.click();
	}
	
	public String getTxtBerhasil() {
		return txtBerhasil.getText();
	}
	
	//Page Show Sort Search
	
	public void PagingCekPenilaian() {
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,1759)");
		pageNext.click();
		tunggu(2);
		pagePrevious.click();
	}
	
	public void ShowPageCekPenilaian() {
		btnRange.click();
		showRange.get(2).click();
	}
	
	public void SortCekPenilaian() {
		sortAscending.click();
	}
	
	public void SearchCekPenilaian(String search) {
		inputSearch.sendKeys(search);
		btnSearch.click();
	}
	
	public void tunggu(int detik) {
		try {
			Thread.sleep(detik*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
