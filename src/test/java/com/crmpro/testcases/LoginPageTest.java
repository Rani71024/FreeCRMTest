package com.crmpro.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmpro.base.TestBase;
import com.crmpro.pages.HomePage;
import com.crmpro.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		
		String actualTitle = loginPage.validatePageTitle();
		System.out.println(actualTitle);
		String expectedTitle = "CRMPRO  - CRM software for customer relationship management, sales, and support.";
		
		if(actualTitle.equalsIgnoreCase(expectedTitle)){
			System.out.println("Title test is passed");
		}
		else 
			System.out.println("Title test is failed");
	}
	@Test(priority=2)
	public void crmLogoTest() {
		boolean flag = loginPage.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
