package tests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import junit.framework.TestResult;

public abstract class BasicTest {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected String baseURL = "http://demo.yo-meals.com/";
	protected String email = "customer@dummyid.com";
	protected String password = "12345678a";
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");

		this.driver = new ChromeDriver();
		this.wait = new WebDriverWait(driver, 10);
		this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void afterTest(TestResult result) throws Exception {
//		if (((ITestResult) result).getStatus() == ITestResult.FAILURE) {
//			File ss = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
//			String fileName = new SimpleDateFormat("yyyyMMddHHmm'.png'").format(new Date());
//			File save = new File("/.screenshots/" + fileName);
//			FileHandler.copy(ss, save);
//		}
		this.driver.manage().deleteAllCookies();
	}

	@AfterClass
	public void afterClass() {
		this.driver.quit();
	}
}
