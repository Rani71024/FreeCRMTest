package com.crmpro.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crmpro.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		// code to read the properties
		
		try {
				prop = new Properties();
				FileInputStream fp = new FileInputStream("E:\\Java_Programs\\FreeCRMTest\\src\\main\\java\\com\\crmpro\\config\\config.properties");
				prop.load(fp);
		}
		  catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() throws Exception {
		
		String browserName = prop.getProperty("browser");
		
		//Check if parameter passed from TestNG is 'firefox'
        if(browserName.equalsIgnoreCase("firefox")){
        	//set path to geckodriver.exe
        	System.setProperty("webdriver.gecko.driver","D:\\Selenium\\lib\\geckodriver.exe");
        	//create firefox instance
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'Chrome'
        else if(browserName.equalsIgnoreCase("chrome")){
            //set path to chromedriver.exe
        	System.setProperty("webdriver.chrome.driver","D:\\Selenium\\lib\\chromedriver.exe");
        	//create chrome instance
            driver = new ChromeDriver();
        }
        
        e_driver = new EventFiringWebDriver(driver);
    	// Now create object of EventListerHandler to register it with EventFiringWebDriver
    	eventListener = new WebEventListener();
    	e_driver.register(eventListener);
    	driver = e_driver;
        
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(prop.getProperty("URL"));
        
	}
}

























