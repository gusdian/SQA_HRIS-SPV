package com.juaracoding.HRIS_SPV.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.HRIS_SPV.config.AutomationFrameworkConfig;
import com.juaracoding.HRIS_SPV.drivers.DriverSingleton;
import com.juaracoding.HRIS_SPV.pages.LoginPage;
import com.juaracoding.HRIS_SPV.utils.ConfigurationProperties;
import com.juaracoding.HRIS_SPV.utils.Constants;
import com.juaracoding.HRIS_SPV.utils.TestCases;
import com.juaracoding.HRIS_SPV.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class StepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;

	
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReport.html");
	
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		
		TestCases[] tests = TestCases.values();
		extentTest = reports.startTest(tests[Utils.testCount].getTestName());
		Utils.testCount++;
		
	}
	
	@After
	public void closeObject() {
		reports.endTest(extentTest);
		reports.flush();
	}
	
	@AfterAll
	public static void closeBrowser() {
		driver.quit();
	}
	
	//----------------------( Login Page )----------------------//
	@Given("SPV mengakses url")
	public void spv_akses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to "+Constants.URL);
	}
	
	@When("SPV invalid login")
	public void spv_invalid_login() {
		loginPage.submitInvalidLogin(configurationProperties.getEmailku(), configurationProperties.getPasswordd());
		extentTest.log(LogStatus.PASS, "SPV invalid login");
	}
	
	@Then("SPV gagal login")
	public void spv_gagal_login() {
		assertEquals(configurationProperties.getTxtInvalidLogin(), loginPage.getTxtInvalidLogin());
		extentTest.log(LogStatus.PASS, "SPV gagal login");
	}
	
	@When("SPV valid login")
	public void spv_valid_login() {
		loginPage.submitLogin(configurationProperties.getEmail(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "SPV valid login");
	}
	
	@Then("SPV berhasil login")
	public void spv_berhasil_login() {
		assertEquals(configurationProperties.getTxtWelcome(), loginPage.getTxtWelcome());
		extentTest.log(LogStatus.PASS, "SPV berhasil login");
	}    
	
    public void tunggu(int detik) {
		try {
			Thread.sleep(detik*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
