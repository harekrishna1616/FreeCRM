package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory - Object repository
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(linkText = "SignUp")
	WebElement signUpBtn;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	/*
	 * @FindBy() WebElement crmProLogo;
	 */
	
	//initialize page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
	String loginPageTitle=driver.getTitle();
	return loginPageTitle;
	}
	
	public HomePage login(String un, String pwd) {
	username.sendKeys(un);	
	password.sendKeys(pwd);
	loginBtn.click();
	
	return new HomePage();
		
	}
	
	
}
