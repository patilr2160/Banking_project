package TestClasses;

import org.testng.annotations.Test;

import BaseClasses.BaseClass;
import PomClasses.FundPage;
import PomClasses.HomePage;
import PomClasses.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class VerifyUserCanAddFundToAccount {
	
	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	FundPage fp;
  
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String k) 
  {
	  driver = BaseClass.getBrowser(k);
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  lp = new LoginPage (driver);
	  hp = new HomePage (driver);
	  fp = new FundPage (driver);
	  
  }
   
  @Test
  public void f() throws IOException 
  {
	  lp.enterEmail();
	  lp.clickOnContinue();
	  lp.enterPassword();
	  lp.clickOnSubmitButton();
	  lp.enterPin();
	  
	  hp.clickOnProfileIcon();
	  hp.verifyUser();
	  hp.clickOnFundButton();
	  
	  fp.verifyFundPageLoaded();
	 
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

  @AfterClass
  public void afterClass() {
  }

  

}
