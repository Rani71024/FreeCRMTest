package com.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crmpro.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	
//	@FindBy(xpath="//body/table/tbody/tr/td/table/tbody/tr/td/fieldset[@class='fieldset']/form[@id='contactForm']/table/tbody/tr/td/input[2]")
	WebElement saveBtn;
	
	//Initialize my page objects
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	public boolean verifyContactslabel() {
		return contactsLabel.isDisplayed();
	}
	public void selectContacts(String name) {
		driver.findElement(By.xpath("//tr[6]//td[1]//input[1]")).click();
	}
	public void createContact(String title, String ftName, String ltName, String comp) {
		
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
	}
}

















