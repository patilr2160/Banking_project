package PomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.UtilityClass;

public class HomePage extends UtilityClass{
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='valign-wrapper']/div")
	private WebElement profileIcon;
	
	@FindBy(xpath="//p[text()='patilr2160@gmail.com']")
	private WebElement profileEmail;
	
	@FindBy(xpath="//div[@class='valign-wrapper balance-wrap']")
	private WebElement fundButton;
	
	
	

	public HomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickOnProfileIcon()
	{
		explicitWait(driver, profileIcon);
		profileIcon.click();
	}
	
	public boolean verifyUser() throws IOException
	{
		WebElement element = explicitWait(driver, profileEmail);
		String emailFromUI = element.getText().trim();
		String emailFromConfigFile = getDataFromPropertyFile("email");
		
		if(emailFromUI.equals(emailFromConfigFile))
		{
			return true;
		}
		
		return false;
	}
	
	public void clickOnFundButton()
	{
		fundButton.click();
	}

}
