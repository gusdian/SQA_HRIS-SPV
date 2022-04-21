package com.juaracoding.HRIS_SPV.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.HRIS_SPV.drivers.DriverSingleton;

public class SetTargetPage {
	
private WebDriver driver;
	
	public SetTargetPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[11]/a")
	WebElement menuPA;
	
	@FindBy(xpath = "//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[11]/ul/li[1]/a")
	WebElement menuSetTarget;
	
	@FindBy(xpath = "//*[@id=\"table_filter\"]/label/input")
	WebElement inputTarget; //SQA
	
	@FindBy(id="btnSearch")
	WebElement btnSearch;
	
	@FindBy(xpath = "//*[@id=\"table\"]/tbody/tr/td[3]/a")
	WebElement btnEdit;
	
	@FindBy(xpath = "//*[@id=\"content\"]/h1/a[1]")
	WebElement btnPrev;
	
	@FindBy(xpath = "//*[@id=\"content\"]/h1/a")
	WebElement btnPrev2;
	
	@FindBy(xpath = "//*[@id=\"table\"]/tbody/tr[1]/td[3]/a")
	WebElement btnEdit2;
	
	@FindBy(xpath = "//*[@id=\"content\"]/h1/a[2]")
	WebElement btnAddTarget;
	
	@FindBy(name="Temp_Name")
	WebElement tempName;
	
	@FindBy(id = "Period_Start_Date")
	WebElement startDate;
	
	@FindBy(id = "Period_End_Date")
	WebElement endDate;
	
	@FindBy(id = "Review_Count")
	WebElement reviewCount;
	
	@FindBy(xpath = "//*[@id='Review_Count']/option")
	List<WebElement>listReviewCount;
	
	@FindBy(id = "btnSubmit")
	WebElement btnSubmit1;
	
	@FindBy(id = "Weight")
	List<WebElement> weight;
	
	@FindBy(xpath = "//*[@id=\"tab-category\"]/div/div/div/form/div[2]/div/button")
	WebElement btnSubmit2;
	
	@FindBy(id = "Objective_Name")
	WebElement formParameter;
	
	@FindBy(id = "Objective_Description")
	WebElement formTarget;
	
	@FindBy(xpath = "//*[@class='btn btn-primary']")
	WebElement btnSubmit3;
	
	@FindBy(css = "#table > tbody > tr > td:nth-child(4) > a")
	WebElement delete;
	
	@FindBy(css = "#content > div:nth-child(8) > div > ul > li:nth-child(2) > a")
	WebElement people;
	
	@FindBy(css = "#content > div:nth-child(8) > div > ul > li:nth-child(3) > a")
	WebElement sigap;
	
	@FindBy(css = "#content > div:nth-child(8) > div > ul > li:nth-child(4) > a")
	WebElement tggjwb;
	
	@FindBy(css = "#content > div:nth-child(8) > div > ul > li:nth-child(5) > a")
	WebElement aspir;
	
	@FindBy(css = "#tab-category > div > div:nth-child(5) > div > a")
	WebElement nextForm;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/select")
	WebElement pilihAssign;
	
	@FindBy(xpath = "//*[@id=\"table1_filter\"]/label/input")
	WebElement inputParam;
	
	@FindBy(id="btnRefresh")
	WebElement btnRefresh;
	
	@FindBy(xpath = "//*[@id=\"assign\"]/span/span[1]/span/ul/li/input")
	WebElement inputNama;
	
	@FindBy(xpath = "//*[@id=\"tab-category1\"]/div/div/div/form/input[5]")
	WebElement btnSubmit4;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div/select")
	WebElement pilihAssign2;
	
//	@FindBy(xpath = "//*[@id=\"table1_filter\"]/label/input")
//	WebElement inputParam;
//	
	@FindBy(css = "#content > div.alert.alert-warning.alert-dismissable")
	WebElement txtTarget;
	
	//set tgl manual di framework properties
	
	public void menuPA() {
		tunggu();
		menuPA.click();
		menuSetTarget.click();
	}
	
	public void setTarget(String src, String target, String start, String end, String persen, String persen2) {
		tunggu();
		inputTarget.sendKeys(src);
		tunggu();
		btnSearch.click();
		tunggu();
		btnEdit.click();
		tunggu();
		btnPrev.click();
		tunggu();
		btnEdit2.click();
		tunggu();
		btnAddTarget.click();
		tunggu();
		tempName.sendKeys(target);
		tunggu();
		startDate.sendKeys(Keys.chord(Keys.CONTROL+"a", start));
		startDate.sendKeys(start);
		startDate.sendKeys(Keys.ENTER);
		tunggu();
		endDate.sendKeys(Keys.chord(Keys.CONTROL+"a", end));
		endDate.sendKeys(end);
		endDate.sendKeys(Keys.ENTER);
		tunggu();
		reviewCount.click();
		tunggu();
		listReviewCount.get(4).click();
		btnSubmit1.click();
		tunggu();
		weight.get(0).sendKeys(persen);
		weight.get(1).sendKeys(persen);
		btnSubmit2.click();
		tunggu();
		btnPrev2.click();
		tunggu();
		weight.get(0).sendKeys(Keys.DELETE);
		weight.get(0).sendKeys(Keys.DELETE);
		weight.get(0).sendKeys(Keys.DELETE);
		weight.get(0).sendKeys(persen2);
		weight.get(1).sendKeys(Keys.DELETE);
		weight.get(1).sendKeys(Keys.DELETE);
		weight.get(1).sendKeys(Keys.DELETE);
		weight.get(1).sendKeys(persen2);
		btnSubmit2.click();
		tunggu();
	}
	
	public void setObj(String target, String persen, String persen2, String diri, String team, String s, String name) {
		formParameter.sendKeys(target);
		formTarget.sendKeys(persen);
		btnSubmit3.click();
		tunggu();
		delete.click();
		tunggu();
		formParameter.sendKeys(target);
		formTarget.sendKeys(persen2);
		btnSubmit3.click();
		tunggu();
		people.click();
		tunggu();
		formParameter.sendKeys(target);
		formTarget.sendKeys(persen2);
		btnSubmit3.click();
		tunggu();
		sigap.click();
		tunggu();
		formParameter.sendKeys(target);
		formTarget.sendKeys(persen2);
		btnSubmit3.click();
		tunggu();
		tggjwb.click();
		tunggu();
		formParameter.sendKeys(target);
		formTarget.sendKeys(persen2);
		btnSubmit3.click();
		tunggu();
		aspir.click();
		tunggu();
		formParameter.sendKeys(target);
		formTarget.sendKeys(persen2);
		btnSubmit3.click();
		tunggu();
		nextForm.click();
		pilihAssign.sendKeys(Keys.chord(Keys.CONTROL+"d", diri));
		pilihAssign.sendKeys(diri);
		pilihAssign.sendKeys(Keys.ENTER);
		tunggu();
		inputParam.sendKeys(s);
		btnSearch.click();
		tunggu();
		btnRefresh.click();
		tunggu();
		pilihAssign.sendKeys(Keys.chord(Keys.CONTROL+"t", team));
		pilihAssign.sendKeys(team);
		pilihAssign.sendKeys(Keys.ENTER);
		tunggu();
		scroll();
		inputNama.sendKeys(name);
		inputNama.sendKeys(Keys.ENTER);
		btnSubmit4.click();
		tunggu();
		pilihAssign2.sendKeys(Keys.chord(Keys.CONTROL+"d", diri));
		pilihAssign2.sendKeys(diri);
		pilihAssign2.sendKeys(Keys.ENTER);
		tunggu();
		btnSubmit4.click();
	}
	
	public String getTxtTarget() {
		return txtTarget.getText();
	}
	
	public void tunggu() {
		try {
			Thread.sleep(1000);
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
