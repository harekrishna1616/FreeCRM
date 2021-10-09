package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.qa.crm.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	public LoginPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
	}
	
	@Test
	public void validateLoginPageTitleTest() {
		String loginPageTitle=loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
}
