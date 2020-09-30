package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSistemPage;

public class MealItemTest extends BasicTest {
	
	@Test(priority = 0)
	public void add_meal_to_cart() throws InterruptedException {
		this.driver.navigate().to(baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo");
		this.driver.manage().window().maximize();
		
		LocationPopupPage lpp = new LocationPopupPage(driver, wait);
		lpp.closePopupSelectLocation();
		
		MealPage mp = new MealPage(driver, wait);
		mp.addToCart("2");
		
		NotificationSistemPage nsp = new NotificationSistemPage(driver, wait);

		assertTrue(nsp.getMessageText().contains("The Following Errors Occurred:"));
		assertTrue(nsp.getMessageText().contains("Please Select Location"));
		
		Thread.sleep(5000);
		
		lpp.openPopupSelectLocation();
		lpp.setLocation("Burlington - Vermont");
		mp.addToCart("3");
		assertEquals(nsp.getMessageText(), "Meal Added To Cart");
		
	}
	
	
	
	@Test(priority = 10)
	public void add_meal_to_favorite() throws InterruptedException {
		this.driver.navigate().to(baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo");
		this.driver.manage().window().maximize();

		LocationPopupPage lpp = new LocationPopupPage(driver, wait);
		lpp.closePopupSelectLocation();
		
		MealPage mp = new MealPage(driver, wait);
		mp.addToFavourites();

		NotificationSistemPage nsp = new NotificationSistemPage(driver, wait);

		assertEquals(nsp.getMessageText(), "Please login first!");
		

		this.driver.navigate().to(baseURL + "guest-user/login-form");
		
		LoginPage lp = new LoginPage(driver, wait);
		lp.login(email, password);
		
		this.driver.navigate().to(baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo");

		mp.addToFavourites();

		assertEquals(nsp.getMessageText(), "Product has been added to your favorites.");
		
	
	}

	
	
	@Test(priority = 20)
	public void clear_cart() throws InterruptedException, IOException {
		this.driver.navigate().to(baseURL + "meals");
		this.driver.manage().window().maximize();

		LocationPopupPage lpp = new LocationPopupPage(driver, wait);

		lpp.setLocation("City Center - Albany");
		
		
		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meals");
		
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			
			XSSFRow row = sheet.getRow(i);
			
			String mealUrl = row.getCell(0).getStringCellValue();
			this.driver.get(mealUrl);
			
			MealPage mp = new MealPage(driver, wait);
			mp.addToCart(Integer.toString(i));
			
			NotificationSistemPage nsp = new NotificationSistemPage(driver, wait);
			SoftAssert softAssertion = new SoftAssert();
			softAssertion.assertEquals(nsp.getMessageText(), "Meal Added To Cart");
		}
		
		CartSummaryPage csp = new CartSummaryPage(driver, wait);
		csp.clearAll();
		
		NotificationSistemPage nsp = new NotificationSistemPage(driver, wait);
		assertEquals(nsp.getMessageText(), "All meals removed from Cart successfully");
		
		
	}

}
