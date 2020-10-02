package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	
	public WebElement getAddressInput () {
		return this.driver.findElement(By.xpath("//*[@id=\"profileInfoFrm\"]/div[2]/div[2]/fieldset/input"));
	}
	
	public WebElement getPhoneNoInput () {
		return this.driver.findElement(By.xpath("//*[@id=\"profileInfoFrm\"]/div[3]/div[1]/fieldset/input"));
	}
	
	public WebElement getZipCodeInput () {
		return this.driver.findElement(By.xpath("//*[@id=\"profileInfoFrm\"]/div[3]/div[2]/fieldset/input"));
	}
	
	public WebElement getCountryInput () {
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
	
	public WebElement getProfileImg () {
		return this.driver.findElement(By.xpath("//*[@id=\"profileInfo\"]/div/div[1]/img"));
	}
	
	public WebElement getUploadImgButton () {
		return this.driver.findElement(By.className("upload"));
	}
	
	public WebElement getRemoveImgButton () {
		return this.driver.findElement(By.className("remove"));
	}
	
	public void uploadAProfilePicture() throws IOException {
        ((JavascriptExecutor) this.driver).executeScript("arguments[0].click();", this.getUploadImgButton());
        String imgPath = new File("images/brofist.jpg").getCanonicalPath();
        this.driver.findElement(By.xpath("//input[@type='file']")).sendKeys(imgPath);
    }
	
	public void deleteAProfilePicture () {
        ((JavascriptExecutor) this.driver).executeScript("arguments[0].click();", this.getRemoveImgButton());
	}
	
	public WebElement getSavePersonalInformationButton () {
		return this.driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[2]/div/div/div[4]/form/div[5]/div/fieldset/input"));
	}
	
	public void changeAllBasicInformations (String firstName, String lastName, String address, String phoneNo, String zipCode) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		this.getFirstNameInput().sendKeys(Keys.chord(Keys.CONTROL, "a"), firstName);
		this.getLastNameInput().sendKeys(Keys.chord(Keys.CONTROL, "a"), lastName);
		this.getAddressInput().sendKeys(Keys.chord(Keys.CONTROL, "a"), address);
		this.getPhoneNoInput().sendKeys(Keys.chord(Keys.CONTROL, "a"), phoneNo);
		this.getZipCodeInput().sendKeys(Keys.chord(Keys.CONTROL, "a"), zipCode);
		js.executeScript("arguments[0].click();", this.getPersonalInformationSaveButton());
	}
	
}
