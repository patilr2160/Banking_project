package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.UtilityClass;

public class FundPage extends UtilityClass {
	
WebDriver driver;
	
	@FindBy(xpath="//div[text()='Balance available']")
	private WebElement fundAvailableText;
		
	@FindBy(xpath="//input[@id='wrs445Amount']")
	private WebElement enterAmmount;
	
	public FundPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public boolean verifyFundPageLoaded()
	{
		WebElement element = explicitWait(driver, fundAvailableText);
		String text = element.getTagName().trim();
		String dataFromExcel = "Balance available";
		
		if(text.equals(dataFromExcel))
		{
			return true;
		}
		
		return false;
	}
	


}
