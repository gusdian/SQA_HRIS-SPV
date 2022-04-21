package com.juaracoding.HRIS_SPV.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.HRIS_SPV.drivers.DriverSingleton;

public class PA360Page {
	private WebDriver driver;
	
	public PA360Page() {
		this.driver=DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='sidebar']/div/div[1]/ul[2]/li[11]/a/span")
	WebElement ListMenu;
	
	@FindBy(xpath = "//*[@id='sidebar']/div/div[1]/ul[2]/li[11]/ul/li[5]/a")
	WebElement ListSubMenu;
	
	@FindBy(css = "#table_length > label > select")
	WebElement Entries1;
	
	@FindBy(xpath = "//*[@id='table_length']/label/select/option")
	List<WebElement> ListEntries1;
	
	@FindBy(css = "#table_filter > label > input")
	WebElement Filter1;
	
	@FindBy(xpath = "//*[@id=\"content\"]/h1")
	WebElement txtPA360Page;
	
	public void MenuPA() {
		ListMenu.click();
		ListSubMenu.click();
	}
	
	public void indexPA360(String filter4) {
		tunggu();
		Entries1.click();
		ListEntries1.get(1).click();
		Filter1.sendKeys(Keys.chord(Keys.CONTROL+"a"));
		Filter1.sendKeys(filter4);
		Filter1.sendKeys(Keys.ENTER);
		tunggu();
		ListMenu.click();
		ListSubMenu.click();
	}
	
	public String getTxtPA360Page() {
		return txtPA360Page.getText();	
		}
		
		public void tunggu() {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}