package com.juaracoding.HRIS_SPV.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.HRIS_SPV.drivers.DriverSingleton;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	WebElement inputEmail;
	
	@FindBy(name = "password")
	WebElement inputPassword;	
	
	@FindBy(css = "#page-container > div > div.login-content > form > div.login-buttons")
	WebElement btnLogin;
	
	@FindBy(xpath = "//*[@id='content']/h1")
	WebElement txtWelcome;

	@FindBy(css = "#page-container > div > div.login-header > div.brand > small")
	WebElement txtInvalidLogin;
	
	public void submitInvalidLogin(String userNamee, String passwordd) {
		inputEmail.sendKeys(userNamee);
		inputPassword.sendKeys(passwordd);
		btnLogin.click();
	}
	
	public void submitLogin(String userName, String password) {
		inputEmail.sendKeys(userName);
		inputPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public String getTxtWelcome() {
		return txtWelcome.getText();
	}
	
	public String getTxtInvalidLogin() {
		return txtInvalidLogin.getText();
	}
	
	public void tunggu() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		
	
}
