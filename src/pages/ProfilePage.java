package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	public WebElement getFirstNameInput () {
		return this.driver.findElement(By.xpath("//*[@id=\"profileInfoFrm\"]/div[1]/div[1]/fieldset/input"));
	}
	
	public WebElement getLastNameInput () {
		return this.driver.findElement(By.xpath("//*[@id=\"profileInfoFrm\"]/div[1]/div[2]/fieldset/input"));
	}
	
	public WebElement getAdrressInput () {
		return this.driver.findElement(By.xpath("//*[@id=\"profileInfoFrm\"]/div[2]/div[2]/fieldset/input"));
	}
	
	public WebElement getPhoneNoInput () {
		return this.driver.findElement(By.xpath("//*[@id=\"profileInfoFrm\"]/div[3]/div[1]/fieldset/input"));
	}
	
	public WebElement getZipCodeInput () {
		return this.driver.findElement(By.xpath("//*[@id=\"profileInfoFrm\"]/div[3]/div[2]/fieldset/input"));
	}
	
	public WebElement getCountryInput () {
//		WebElement s = driver.findElement(By.xpath("//*[@id=\"cars\"]"));
//		Select select = new Select(e);
//		select.selectByValue("saab");
		return this.driver.findElement(By.xpath("//*[@id=\"user_country_id\"]"));
	}
	
	public WebElement getStateInput () {
		return this.driver.findElement(By.xpath("//*[@id=\"user_state_id\"]"));
	}
	
	public WebElement getPersonalInformationSaveButton () {
		return this.driver.findElement(By.xpath("//*[@id=\"profileInfoFrm\"]/div[5]/div/fieldset/input"));
	}
	
	public WebElement getCurrentPasswordInput () {
		return this.driver.findElement(By.xpath("//*[@id=\"frm_fat_id_changePwdFrm\"]/div/div[1]/fieldset/input"));
	}
	
	public WebElement getNewPasswordInput () {
		return this.driver.findElement(By.xpath("//*[@id=\"frm_fat_id_changePwdFrm\"]/div/div[2]/fieldset/input"));
	}
	
	public WebElement getConfirmPasswordInput () {
		return this.driver.findElement(By.xpath("//*[@id=\"frm_fat_id_changePwdFrm\"]/div/div[3]/fieldset/input"));
	}
	
	public WebElement getCityInput () {
		return this.driver.findElement(By.xpath("//*[@id=\"frm_fat_id_changePwdFrm\"]/div/div[4]/fieldset/input"));
	}
	
	public WebElement getChangePasswordButton () {
		return this.driver.findElement(By.xpath("//*[@id=\"frm_fat_id_changePwdFrm\"]/div/div[4]/fieldset/input"));
	}
	
	public WebElement getImgInput () {
		return this.driver.findElement(By.xpath("//*[@id=\"profileInfo\"]/div/div[1]/img"));
	}
	
	public WebElement getUploadImgButton () {
		return this.driver.findElement(By.xpath("//*[@id=\"profileInfo\"]/div/div[1]/div/a[1]/i"));
	}
	
	public WebElement getRemoveImgButton () {
		return this.driver.findElement(By.xpath("//*[@id=\"profileInfo\"]/div/div[1]/div/a[2]/i"));
	}
	
	public void uploadsAProfilePicture(String pathToFile) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", this.getImgInput());
		this.getUploadImgButton().sendKeys(pathToFile);
	}
	
	public void deleteAProfilePicture () {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", this.getImgInput());
		this.getRemoveImgButton().click();
	}
	
}
