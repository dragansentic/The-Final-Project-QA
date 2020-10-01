package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AuthPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.NotificationSistemPage;
import pages.ProfilePage;

public class ProfileTest extends BasicTest {

	@Test(priority = 0)
	public void EditProfile() throws InterruptedException {
		this.driver.navigate().to(baseURL + "/guest-user/login-form");
		this.driver.manage().window().maximize();

		LocationPopupPage lpp = new LocationPopupPage(driver, wait);
		lpp.closePopupSelectLocation();

		LoginPage lp = new LoginPage(driver, wait);
		lp.login(email, password);

		NotificationSistemPage nsp = new NotificationSistemPage(driver, wait);
		assertEquals("Login Successfull", nsp.getMessageText());

		this.driver.navigate().to(baseURL + "/member/profile");
		ProfilePage pp = new ProfilePage(driver, wait);
		String firstName = "Vladimir";
		String lastName = "Minic";
		String address = "Krusevacka";
		String phoneNo = "+381 69 123457";
		String zipCode = "37000";

		pp.changeAllBasicInformations(firstName, lastName, address, phoneNo, zipCode);

		assertEquals(nsp.getMessageText(), "Setup Successful");

		AuthPage ap = new AuthPage(driver, wait);
		ap.logout();

		assertEquals(nsp.getMessageText(), "Logout Successfull!");
	}

	@Test(priority = 10)
	public void ChangeProfileImage() throws InterruptedException, IOException {
		this.driver.navigate().to(baseURL + "/guest-user/login-form");
		this.driver.manage().window().maximize();

//		LocationPopupPage lpp = new LocationPopupPage(driver, wait);
//		lpp.closePopupSelectLocation();

		LoginPage lp = new LoginPage(driver, wait);
		lp.login(email, password);

		NotificationSistemPage nsp = new NotificationSistemPage(driver, wait);
		assertEquals(nsp.getMessageText(), "Login Successfull");
		
		this.driver.navigate().to(baseURL + "/member/profile");
		ProfilePage pp = new ProfilePage(driver, wait);
		
		pp.uploadAProfilePicture();
		assertEquals(nsp.getMessageText(), "Profile Image Uploaded Successfully");
		
		pp.deleteAProfilePicture();
		assertEquals(nsp.getMessageText(), "Profile Image Deleted Successfully");
		
		AuthPage ap = new AuthPage(driver, wait);
		ap.logout();

		assertEquals(nsp.getMessageText(), "Logout Successfull!");
	}

}
