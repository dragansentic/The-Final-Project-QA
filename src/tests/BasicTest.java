package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public abstract class BasicTest {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected String baseURL = "http://demo.yo-meals.com/";
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");

		this.driver = new ChromeDriver();
		this.wait = new WebDriverWait(driver, 10);
		this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void afterTest(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("SUCCESS");}
//		} else {
//			System.err.println("ERROR");
//			TakesScreenshot scrShot = ((TakesScreenshot) driver);
//			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//			File DestFile = new File("screenshots/screenshot.png");
//			FileUtils.copyFile(SrcFile, DestFile);
//		}
	}

	@AfterClass
	public void afterClass() {
			this.driver.quit();
	}
}
