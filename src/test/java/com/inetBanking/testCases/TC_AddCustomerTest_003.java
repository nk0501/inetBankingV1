package com.inetBanking.testCases;

import org.testng.annotations.Test;

import inetBanking.pageObjects.AddCustomerPage;
import inetBanking.pageObjects.LoginPage;
import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass 
{
	@Test
	public void addNewCustomer() throws InterruptedException, Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		
		log.info("Username is provided ! ");
		lp.setPassword(password);
		log.info("Password  is provided ! ");
		lp.setButton();
		
		Thread.sleep(3000);
		
		AddCustomerPage addCust = new AddCustomerPage(driver);
		
		addCust.clickAddNewCustomer();
		
		log.info("Providing the customer details to add new customer .");
		
		addCust.custName("naveen");
		addCust.custGender("male");
		addCust.custDOB("01", "03", "1992");
		addCust.custAddress("India");
		addCust.custCity("Kolkata");
		addCust.custState("West Bengal");
		addCust.custPin(123456);
		addCust.custPhone("7865059198");
		String emailid = generateRandomString()+"@gmail.com";
		addCust.custMail(emailid);
		addCust.custPassword("naveen1");
		addCust.submitButton();
		
		Thread.sleep(3000);
		
		log.info("Validation started ... ");
		
		boolean result=driver.getPageSource().contains("Customer Registered Successfully");
		if(result==true)
		{
			Assert.assertTrue(true);
			log.info("Test case is passed. ");
		}
		else 
		{
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			log.info("Test case failed.");
			
		}
		
	}
	


}
