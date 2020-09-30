package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	public WebElement getLoginButton () {
		return this.driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[2]/div[2]/ul/li[2]/a"));
	}
	
	public WebElement getEmailAddressInput () {
		return this.driver.findElement(By.xpath("//*[@id=\"frm_fat_id_frmLogin\"]/fieldset[1]/input"));
	}
	
	public WebElement getPasswordInput () {
		return this.driver.findElement(By.xpath("//*[@id=\"frm_fat_id_frmLogin\"]/fieldset[2]/input"));
	}
	
	public WebElement getSubmitLoginButton () {
		return this.driver.findElement(By.xpath("//*[@id=\"frm_fat_id_frmLogin\"]/fieldset[4]/input"));
	}
	
	public void login (String email, String password) {
		this.getEmailAddressInput().sendKeys(Keys.chord(Keys.CONTROL, "a"), email);
		this.getPasswordInput().sendKeys(Keys.chord(Keys.CONTROL, "a"), password);
		this.getSubmitLoginButton().click();
	}

}
