package inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.NAME, using ="uid")
	//@CacheLookup  - For cache 
	WebElement txtUsername ;
	
	@FindBy(how=How.NAME,using = "password")                       // 3 Objects are created
	WebElement txtPassword;
	
	@FindBy(how=How.NAME,using = "btnLogin")
	WebElement txtButton;
	
	@FindBy(how=How.XPATH,using = "/html/body/div[3]/div/ul/li[15]/a")
	WebElement lnklogout;
	
	public void setUserName(String uname)
	{
		txtUsername.sendKeys(uname);
	}
	
	public void setPassword(String upass)
	{
		txtPassword.sendKeys(upass);
	}
	
	public void setButton()
	{
		txtButton.click();
	}
	
	public void linkLogout()
	{
		lnklogout.click();
	}
	

}
