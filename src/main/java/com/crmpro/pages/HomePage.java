package com.crmpro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmpro.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: rani k')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	// Inititalize the page objects
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	public ContactsPage clickOnContactLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	public void clickOnNewContactsLink() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}

}
















