package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory or OR
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@id=\"navbar-collapse\"]/ul/li[2]/a/font")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[@alt='free crm logo']")
	WebElement crmLogo;
	
	//Initialization of Page Objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	//Actions i.e. features available on login page
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(1000);
		loginBtn.click();
		Thread.sleep(2000);

		
		return new HomePage();
	}
	
	
	
}
