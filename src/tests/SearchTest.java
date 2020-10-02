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

import pages.LocationPopupPage;
import pages.SearchResultPage;

public class SearchTest extends BasicTest {

	@Test(priority = 0)
	public void search_results_test() throws InterruptedException, IOException {

		this.driver.navigate().to(baseURL + "meals");
		this.driver.manage().window().maximize();

		LocationPopupPage lpp = new LocationPopupPage(driver, wait);
		lpp.setLocation("City Center - Albany");

		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meal Search Results");

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = sheet.getRow(i);

			this.driver.get("" + row.getCell(1).getStringCellValue() + "");
			lpp.openPopupSelectLocation();
			lpp.setLocation("" + row.getCell(0).getStringCellValue() + "");
			Thread.sleep(6666);

			SearchResultPage srp = new SearchResultPage(driver, wait);
			assertEquals(srp.numberOfSearchResults(), row.getCell(2).getNumericCellValue());
			
			for (int j = 3; j < 3 + row.getCell(2).getNumericCellValue(); j++) {
				assertTrue(srp.listOfMealNames().get(j - 3).contains(row.getCell(j).getStringCellValue()));
			}
		}
	}
}
