package com.juaracoding.HRIS_SPV.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.HRIS_SPV.config.AutomationFrameworkConfig;
import com.juaracoding.HRIS_SPV.drivers.DriverSingleton;
import com.juaracoding.HRIS_SPV.pages.ApprovalPage;
import com.juaracoding.HRIS_SPV.pages.IsiPenilaianPage;
import com.juaracoding.HRIS_SPV.pages.LoginPage;
import com.juaracoding.HRIS_SPV.pages.PA360Page;
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
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class StepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	private ApprovalPage approvalPage;
	private IsiPenilaianPage isiPenilaianPage;
	private PA360Page pa360Page;
	
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReport.html");
	
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		approvalPage = new ApprovalPage();
		isiPenilaianPage = new IsiPenilaianPage();
		pa360Page = new PA360Page();
		
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
		//driver.quit();
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
	
	//----------------------( Approval Target Page )----------------------//
	@When("Spv Klik Menu Approval Target")
		public void spv_klik_menu_approval_target() {
		approvalPage.MenuPA();
		tunggu(2);
		approvalPage.indexApproval(configurationProperties.getFilter1());
		extentTest.log(LogStatus.PASS, "Spv Klik Menu Approval Target");
	}
	
	@Then("Spv Melihat Dan Mengubah Data Jika Diperlukan")
	public void spv_melihat_dan_mengubah_data_jika_diperlukan() {
		approvalPage.EditDataApproval(configurationProperties.getName(), configurationProperties.getStartDate(), configurationProperties.getEndDate(), configurationProperties.getWeight1(), configurationProperties.getWeight2(), configurationProperties.getParam1(), configurationProperties.getTar1(), configurationProperties.getFilter2(), configurationProperties.getParam2(), configurationProperties.getTar2());
		extentTest.log(LogStatus.PASS, "Spv Melihat Dan Mengubah Data Jika Diperlukan");
	}
	
	@Then("Spv Berhasil Approval Target")
	public void spv_berhasil_approval_target() {
		assertEquals(configurationProperties.getTxtInvalidLogin(), approvalPage.getTxtApprovalTarget());
		extentTest.log(LogStatus.PASS, "Spv Berhasil Approval Target");
	}
	
	//----------------------( Isi Penilaian Page )----------------------//
	
	@When("SPV Klik Menu Isi Penilaian")
	public void spv_klik_menu_isi_penilaian() {
		isiPenilaianPage.MenuPA();
		tunggu(2);
		extentTest.log(LogStatus.PASS, "SPV Klik Menu Isi Penilaian");
	}
	
	@Then("SPV Melihat Data")
	public void spv_melihat_data() {
		isiPenilaianPage.indexIsiPenilaian(configurationProperties.getFilter3());
		assertEquals(configurationProperties.getTxtPenilaianPage(), isiPenilaianPage.getTxtPenilaianPage());
		extentTest.log(LogStatus.PASS, "SPV Melihat Data");
	}
	
	//----------------------( PA360 Page )----------------------//
	@When("SPV Klik Menu PA 360")
	public void spv_klik_menu_PA_360() {
		pa360Page.MenuPA();
		tunggu(2);
		extentTest.log(LogStatus.PASS, "SPV Klik Menu PA 360");
	}
	
	@Then("SPV Melihat Data Dan Sesuai")
	public void spv_melihat_data_dan_sesuai() {
		pa360Page.indexPA360(configurationProperties.getFilter3());
		assertEquals(configurationProperties.getTxtPA360Page(), pa360Page.getTxtPA360Page());
		extentTest.log(LogStatus.PASS, "SPV Melihat Data Dan Sesuai");
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
