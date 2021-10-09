package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.crm.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	//comments
	public TestBase() {
	prop=new Properties();
	try {
		FileInputStream ip=new FileInputStream("D:/My Projects - Eclipse/RadheKrishnaFramework01Oct2021/src/main/java/com/qa/crm/config/config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public static void initialization() {
       String browserName=prop.getProperty("browser");
       
       if(browserName.equalsIgnoreCase("chrome")) {
    	   System.setProperty("webdriver.chrome.driver", "D:/My Projects - Eclipse/Drivers/chromedriver_win32/chromedriver.exe");
    	   driver=new ChromeDriver();
       }
       else if(browserName.equalsIgnoreCase("firefox")) {
    	   System.setProperty("webdriver.firefox.driver", "D:/My Projects - Eclipse/Drivers/geckodriver-v0.30.0-win64/geckodriver.exe");
    	   driver=new FirefoxDriver();
       }
       
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
       
       driver.get(prop.getProperty("url"));
	}

}
