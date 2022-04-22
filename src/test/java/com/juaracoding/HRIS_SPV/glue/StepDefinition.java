package com.juaracoding.HRIS_SPV.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.HRIS_SPV.config.AutomationFrameworkConfig;
import com.juaracoding.HRIS_SPV.drivers.DriverSingleton;
import com.juaracoding.HRIS_SPV.pages.ApprovalPage;
import com.juaracoding.HRIS_SPV.pages.CekPenilaianPage;
import com.juaracoding.HRIS_SPV.pages.IsiPenilaianPage;
import com.juaracoding.HRIS_SPV.pages.LoginPage;
import com.juaracoding.HRIS_SPV.pages.SetTargetPage;
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
	private SetTargetPage targetPage;
	private ApprovalPage approvalPage;
	private IsiPenilaianPage isiPenilaianPage;
	private PA360Page pa360Page;
	private CekPenilaianPage cekPenilaianPage;
	
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReport.html");
	
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		targetPage = new SetTargetPage();
		approvalPage = new ApprovalPage();
		isiPenilaianPage = new IsiPenilaianPage();
		pa360Page = new PA360Page();
		cekPenilaianPage = new CekPenilaianPage();
		
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
	
	//----------------------( Set Target Page )----------------------//
	
		@When("SPV mengakses halaman set target")
	    public void spv_mengakses_halaman_set_target() {
	    	tunggu(1);
	    	targetPage.menuPA();
	    	extentTest.log(LogStatus.PASS, "SPV mengakses halaman set target");
	    }
		
		@Then("SPV set target")
		public void spv_set_target() {
			tunggu(1);
			targetPage.setTarget(configurationProperties.getSrc(), configurationProperties.getTarget(), configurationProperties.getStart(), configurationProperties.getEnd(), configurationProperties.getPersen(), configurationProperties.getPersen2());
			extentTest.log(LogStatus.PASS, "SPV melakukan set target");
		}
		
		@Then("SPV set objective")
		public void spv_set_objective() {
			tunggu(1);
			targetPage.setObj(configurationProperties.getTarget(), configurationProperties.getPersen(), configurationProperties.getPersen2(), configurationProperties.getDiri(), configurationProperties.getTeam(), configurationProperties.getS(), configurationProperties.getNama());
			extentTest.log(LogStatus.PASS, "SPV melakukan set objective");
		}
		
		@Then("SPV berhasil set target")
	    public void spv_berhasil_set_target() {
	    	tunggu(1);
	    	assertEquals(configurationProperties.getTxtTarget(), targetPage.getTxtTarget());
	    	extentTest.log(LogStatus.PASS, "Staff Berhasil Mengisi Target");
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
		approvalPage.EditDataApproval(configurationProperties.getNamee(), configurationProperties.getStartDate(), configurationProperties.getEndDate(), configurationProperties.getWeight1(), configurationProperties.getWeight2(), configurationProperties.getParam1(), configurationProperties.getTar1(), configurationProperties.getFilter2());
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
	
	//----------------------( Cek Penilaian Page )----------------------//
	
	@When("SPV klik menu Cek Penilaian")
	public void klik_cek_penilaian() {
		tunggu(2);
		cekPenilaianPage.goToMenuCekPenilaian();
		extentTest.log(LogStatus.PASS, "SPV klik menu Cek Penilaian");
	}
	
    @Then("Menampilkan Data Cek Penilaian")
	public void tampil_cek_penilaian() {
    	tunggu(2);
    	assertEquals(configurationProperties.getTxtCekPenilaian(), cekPenilaianPage.getTxtCekPenilaian());
    	extentTest.log(LogStatus.PASS, "Menampilkan Data Cek Penilaian");
    }
    
    @When("SPV klik button Action")
    public void klik_action() {
    	cekPenilaianPage.goToBtnAction();
    	extentTest.log(LogStatus.PASS, "SPV klik button Action");
    }
    
    @And("SPV klik Quantity Aspect")
    public void klik_quantity_aspect() {
    	tunggu(2);
    	cekPenilaianPage.collapseQuantityAspect();
    	extentTest.log(LogStatus.PASS, "SPV klik Quantity Aspect");
    }
    
    @Then("SPV Update Penilaian Quantity Aspect")
	public void update_penilaian_quantity() {
    	tunggu(2);
    	cekPenilaianPage.editQuantityAspect(configurationProperties.getTxtActual1());
    	extentTest.log(LogStatus.PASS, "SPV Update Penilaian Quantity Aspect");
    }
    
    @And("SPV Cancel Penilaian Quantity Aspect")
    public void cancel_penilaian_quantity() {
    	tunggu(2);
    	cekPenilaianPage.cancelQuantityAspect();
    	extentTest.log(LogStatus.PASS, "SPV Cancel Penilaian Quantity Aspect");
    }
    
    @When("SPV klik Quality Aspect")
    public void klik_quality_aspect() {
    	tunggu(2);
    	cekPenilaianPage.collapseQualityAspect();
    	extentTest.log(LogStatus.PASS, "SPV klik Quality Aspect");
    }
    
    @Then("SPV Update Penilaian Quality Aspect")
    public void update_penilaian_quality() {
    	tunggu(2);
    	cekPenilaianPage.editQualityAspect(configurationProperties.getTxtActualRat1());
    	extentTest.log(LogStatus.PASS, "SPV Update Penilaian Quality Aspect");
    }
    
    @And("SPV Cancel Penilaian Quality Aspect")
    public void cancel_penilaian_quality() {
    	tunggu(2);
    	cekPenilaianPage.cancelQualityAspect();
    	extentTest.log(LogStatus.PASS, "SPV Cancel Penilaian Quality Aspect");
    }
    
    @When("SPV klik Aspiration")
    public void klik_aspiration() {
    	tunggu(2);
    	cekPenilaianPage.collapseAspiration();
    	extentTest.log(LogStatus.PASS, "SPV klik Aspiration");
    }
    
    @Then("SPV Update Penilaian Aspiration")
    public void update_penilaian_aspiration() {
    	tunggu(2);
    	cekPenilaianPage.editAspiration(configurationProperties.getTxtAspiration());
    	extentTest.log(LogStatus.PASS, "SPV Update Penilaian Aspiration");
    }
    
    @And("SPV Cancel Penilaian Aspiration")
    public void cancel_penilaian_aspiration() {
    	tunggu(2);
    	cekPenilaianPage.cancelAspiration();
    	extentTest.log(LogStatus.PASS, "SPV Cancel Penilaian Aspiration");
    }

    @When("SPV klik Final Rating")
    public void klik_final_rating() {
    	tunggu(2);
    	cekPenilaianPage.collapseFinalRating();
    	extentTest.log(LogStatus.FAIL, "SPV klik Final Rating");
    }
    
    @Then("SPV Simpan Data Penilaian")
    public void klik_simpan_data_penilaian() {
    	tunggu(2);
    	cekPenilaianPage.simpanDataPenilaian();
    	extentTest.log(LogStatus.PASS, "SPV Simpan Data Penilaian");
    }
    
    @And("Menampilkan notifikasi Berhasil! dan Data tersimpan")
    public void tampil_data_cek_penilaian() {
    	tunggu(3);
    	assertEquals(configurationProperties.getTxtCekPenilaianBerhasil(), cekPenilaianPage.getTxtBerhasil());
    	extentTest.log(LogStatus.FAIL, "Menampilkan notifikasi Berhasil! dan Data tersimpan");
    }
    
    @When("SPV klik Next Page and Previous Page")
    public void klik_next_page_cek_penilaian() {
    	cekPenilaianPage.PagingCekPenilaian();
    	extentTest.log(LogStatus.PASS, "SPV klik Next Page and Previous Page");
    }
    
    @And("SPV klik Show Entries")
    public void klik_show_cek_penilaian() {
    	driver.navigate().refresh();
    	tunggu(2);
    	cekPenilaianPage.ShowPageCekPenilaian();
    	extentTest.log(LogStatus.PASS, "SPV klik Show Entries");
    }
    
	@Then("Menampilkan data Cek Penilaian sesuai banyaknya data yang dipilih")
	public void tampil_show_entries_cek_penilaian() {
		extentTest.log(LogStatus.PASS, "Menampilkan data Cek Penilaian sesuai banyaknya data yang dipilih");
	}
	
	@When("SPV klik sorting pada Tabel Detail")
	public void klik_sorting_cek_penilaian() {
		cekPenilaianPage.SortCekPenilaian();
		extentTest.log(LogStatus.PASS, "SPV klik sorting pada Tabel Detail");
	}
	
	@Then("Menampilkan data Cek Penilaian secara ascending")
	public void tampil_sorting_cek_penilaian() {
		tunggu(2);
		extentTest.log(LogStatus.PASS, "Menampilkan data Cek Penilaian secara ascending");
	}
	
	@When("SPV search data")
	public void search_cek_penilaian() {
		tunggu(2);
		cekPenilaianPage.SearchCekPenilaian(configurationProperties.getSearchCekPenilaian());
		extentTest.log(LogStatus.PASS, "SPV search data");
	}
	
	@Then("Menampilkan data yang dicari")
	public void tampil_search_cek_penilaian() {
		tunggu(2);
		extentTest.log(LogStatus.FAIL, "Menampilkan data yang dicari");
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
