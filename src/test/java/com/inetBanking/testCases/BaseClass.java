package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.Random;
import com.inetBanking.utilities.ReadConfig;


public class BaseClass 
{
	ReadConfig readConfig =  new ReadConfig();
	
	public String baseURL = readConfig.getAppURL();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
	public static Logger log;
	
	@Parameters("browser")
	@BeforeClass()
	public void setup(String br)
	{
		log = LogManager.getLogger(BaseClass.class.getName());
		
		if(br.equalsIgnoreCase("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		
		}
		else if(br.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			driver = new FirefoxDriver();	
		}
		else if(br.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			driver =new InternetExplorerDriver();	
		}
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();	
	
	}
	
 
	public void captureScreen(WebDriver driver,String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken !");
	
	}
	
	public String generateRandomString()
	{
		String generateString = RandomStringUtils.randomAlphabetic(8);
		return generateString;
		
	}
	
	public String generateRandomInteger()
	{
		String generateInt = RandomStringUtils.randomNumeric(4);
		return generateInt;
		
	}
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	

}
