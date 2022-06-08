package PomClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.UtilityClass;

public class LoginPage extends UtilityClass {
	
	WebDriver driver;
	
    @FindBy(xpath="//input[@id='login_email1']")
	private WebElement email;
	
	@FindBy(xpath="//span[@class='absolute-center']")
	private WebElement continue1;
	
	@FindBy(xpath="//input[@id='login_password1']")
	private WebElement password;
	
	@FindBy(xpath="//span[@class='absolute-center']")
	private WebElement submit;
	
	@FindBy(xpath="//div[@class='otpinput88item']")
	private WebElement pinField;
	
	public LoginPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void enterEmail() throws IOException
	{
		email.sendKeys(getDataFromPropertyFile("email"));
	}
	
	public void clickOnContinue()
	{
		continue1.click();
	}
	
	public void enterPassword() throws IOException
	{
		explicitWait(driver,password);
		password.sendKeys(getDataFromPropertyFile("password"));
	}
	
	public void clickOnSubmitButton()
	{
		submit.click();
	}
	
	public void enterPin() throws IOException
	{
		String pin= getDataFromPropertyFile("pin");
		char [] digit = pin.toCharArray();
		
		explicitWait(driver,pinField);
		
		 List <WebElement> elements = driver.findElements(By.xpath("//input[@type='number']"));
		
		for(int i=0; i<digit.length; i++)
		{
		   
			elements.get(i).sendKeys(String.valueOf(digit[i]));
		    
		}
	}
	
	
		

}
