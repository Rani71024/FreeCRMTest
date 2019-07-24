package com.crmpro.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmpro.base.TestBase;
import com.crmpro.pages.ContactsPage;
import com.crmpro.pages.HomePage;
import com.crmpro.pages.LoginPage;
import com.crmpro.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();	
		contactsPage = new ContactsPage();
	
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));					
	}
	
	@Test
	public void verifyHomePageTitle() {
		
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "HomePage title not matched");
	}
	@Test
	public void verifyUserNameTest() {
		
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	@Test
	public void verifyContactsLink() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}






















