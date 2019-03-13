package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class ContactsPageTest extends TestBase{
	
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage= homePage.clickOnContactsLink();
	}
	
	
	@Test(priority=1)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactsPage.verifyContactslabel(), "Contact label is missing on the page");
	}
	
	
	@Test(priority=2)
	public void selectSingleContactTest()
	{
		contactsPage.selectContactsByName("Test 2 Test 2");
	}
	
	@Test(priority=3)
	public void selectMultipleContactTest()
	{
		contactsPage.selectContactsByName("Test 1 Test 1");
		contactsPage.selectContactsByName("Test 2 Test 2");
		contactsPage.selectContactsByName("Test 3 Test 3");

	}
	
		
	
	@Test(priority=4)
	public void validateCreateNewContact()
	{
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact("Mr.", "Nitu", "Ramteke", "Facebook");
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
