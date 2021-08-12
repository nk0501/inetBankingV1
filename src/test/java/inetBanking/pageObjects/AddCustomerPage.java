package inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage
{
	WebDriver driver; // create WebDriver variable .
	
	public AddCustomerPage(WebDriver driver)    // create constructor 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);  // Initializaion 		
	}
	
	@FindBy(how = How.XPATH,using = "/html/body/div[3]/div/ul/li[2]/a")
	WebElement NewCustomer;
	
	@FindBy(how = How.NAME,using = "name")
	WebElement txtName ;
	
	@FindBy(how = How.NAME,using = "rad1")
	WebElement txtGender;
	
	@FindBy(how = How.ID,using = "dob")
	WebElement txtdob ;
	
	@FindBy(how = How.NAME,using = "addr")
	WebElement txtAddress;
	
	@FindBy(how = How.NAME,using = "city")
	WebElement txtCity;
	
	@FindBy(how = How.NAME,using = "state")
	WebElement txtState;
	
	@FindBy(how = How.NAME,using = "pinno")
	WebElement txtPin; //telephoneno
	
	@FindBy(how = How.NAME,using = "telephoneno")
	WebElement txtPhone; 
	
	@FindBy(how = How.NAME,using = "emailid")
	WebElement txtmail; 
	
	@FindBy(how = How.NAME,using = "password")
	WebElement txtpassword;
	
	@FindBy(how = How.NAME,using = "sub")
	WebElement btnSubmit; 
	
	@FindBy(how = How.NAME,using = "res")
	WebElement btnReset; 
	
	// Methods
	
	public void clickAddNewCustomer()
	{
		NewCustomer.click();
	}
	
	public void custName(String cname)
	{
		txtName.sendKeys(cname);
	}
	
	public void custGender(String cGender)
	{
		txtGender.click();
	}
	
	public void custDOB(String mm,String dd,String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void custAddress(String cadd)
	{
		txtAddress.sendKeys(cadd);
		
	}
	
	public void custCity(String ccity)
	{
		txtCity.sendKeys(ccity);
	}
	
	public void custState(String cstate)
	{
		txtState.sendKeys(cstate);
	}
	
	
	public void custPin(int cpin)
	{
		txtPin.sendKeys(String.valueOf(cpin));
	}
	
	public void custPhone(String cphone) 
	{
		txtPhone.sendKeys(cphone);
	}
	
	public void custMail(String cmail)
	{
		txtmail.sendKeys(cmail);
	}
	
	public void custPassword(String cpass)
	{
		txtpassword.sendKeys(cpass);
		
	}
	
	public void submitButton()
	{
		btnSubmit.click();
	}
	
	public void resetButton()
	{
		btnReset.click();
	}
	
	
	
	
	

}
