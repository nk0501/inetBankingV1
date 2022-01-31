package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

// ReadConfig.java class will read the data from config.properties, then  BaseClass will read the data from here .
// Bascially this class is a mediater . 

public class ReadConfig 
{
	Properties prop ;
	
	public ReadConfig()              // Constructor
	{
		File src = new File("./Configuration\\config.properties");
		try 
		{
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is"+e.getMessage());
		}
	}
	
// To read values from config.properties, we will create methods . 
	
	public String getAppURL()
	{
		return prop.getProperty("baseURL");
	}

    public String getUsername()
	{
		return prop.getProperty("username");
	}
    
    public String getPassword()
	{
		return prop.getProperty("password");
	}
    
    public String getChromePath()
	{
		return prop.getProperty("chromepath");
	}
    
    public String getIEPath()
	{
		return prop.getProperty("iepath");
	}
    
    public String getFirefoxPath()
	{
		return prop.getProperty("firefoxpath");
	}
    
}
