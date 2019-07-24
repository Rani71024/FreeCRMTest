package com.crmpro.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crmpro.base.TestBase;
import com.crmpro.pages.ContactsPage;
import com.crmpro.pages.HomePage;
import com.crmpro.pages.LoginPage;
import com.crmpro.util.TestUtil;

import junit.framework.Assert;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetname = "Contacts";
	
	public ContactsPageTest() {
		super();	
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactLink();
	}
	
	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactslabel());
	}
	
	@Test(priority = 2)
	public void selectContactsTest() {
		contactsPage.selectContacts("Rani");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetname);
		return data;
		
	}
	@Test(priority = 3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String Title, String FirstName, String LastName, String Company) {
		homePage.clickOnNewContactsLink();
								//mr. , sowmya, k, Google
		contactsPage.createContact(Title, FirstName, LastName, Company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
