package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	public WebElement getQtyInput () {
		return this.driver.findElement(By.xpath("//*[@id=\"body\"]/section[1]/div/div/div[2]/div/div[3]/div[1]/ul/li[3]/input"));
	}
	
	public WebElement getAddToCartButton () {
		return this.driver.findElement(By.xpath("//*[@id=\"body\"]/section[1]/div/div/div[2]/div/div[3]/div[2]/a"));
	}
	
	public WebElement getAddToFavouritesButton () {
		return this.driver.findElement(By.xpath("//*[@id=\"item_119\"]"));
	}
	
	public void addToCart (String qty) {
		this.getAddToCartButton().sendKeys(qty);
	}
	
	public void addToFavourites () {
		this.getAddToFavouritesButton().click();
	}

}
