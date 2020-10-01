package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasicPage {

	public SearchResultPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	public List <WebElement> getListOfSearchResults () {
		return this.driver.findElements(By.xpath("//*[@class='product-name']/a"));
	}

	public ArrayList<String> listOfMealNames () {
		ArrayList<String> listOfMealNames = new ArrayList<String>();
		for (int i = 0; i < this.getListOfSearchResults().size(); i++) {
			listOfMealNames.add(this.getListOfSearchResults().get(i).getText());
		}
		return listOfMealNames;
	}
	
	public int numberOfSearchResults() {
		return this.getListOfSearchResults().size();
	}
 	
}
