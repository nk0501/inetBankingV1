package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws Exception
	{
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		log.info("Enter the username");
		
		
		
		lp.setPassword(password);
		log.info("Enter the password");
		
		
		lp.setButton();
		String title = driver.getTitle();  
		if(title.equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			log.info("Test successful");
			
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertFalse(false);
			log.info("test failed");
			
		}
	}

}
