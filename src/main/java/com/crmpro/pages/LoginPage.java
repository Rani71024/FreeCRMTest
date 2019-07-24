package com.crmpro.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmpro.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory/ Object Repositories
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@src='https://classic.crmpro.com/img/logo.png']")
	WebElement crmLogo;
	
	//Initialize the elements using Page Factory class
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(loginBtn).click().build().perform();
		
		
	//	loginBtn.click();
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click()", loginBtn);
		
		return new HomePage();
	}
}



























