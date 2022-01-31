
package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.utilities.XLUtils;

import inetBanking.pageObjects.LoginPage;


public class TC_LoginTest_002 extends BaseClass
{
	@Test(dataProvider ="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		log.info("Username is provided");
		lp.setPassword(pwd);
		log.info("password is provided");
		lp.setButton();
		Thread.sleep(3000);
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();// close alert .
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			log.warn("Login Failed");
		}
		else
		{
			Assert.assertTrue(true);
			log.info("Login passed");
			lp.linkLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); // close logout alert.
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent()
	{
		try 
		{
			driver.switchTo().alert();
			return true;
		}
		catch (NoAlertPresentException e)
		{
			return false;
			
		}
		
		
		

	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path =  System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		int rowcount = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path,"Sheet1",1);
		
		String loginData[][] = new String[rowcount][colcount]; //Creating 2D array.
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				loginData[i-1][j] = XLUtils.getCellData(path,"Sheet1",i,j);
			}
		}
		return loginData;
		
	}
	

}
