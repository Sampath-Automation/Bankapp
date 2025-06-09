package axisbank;

import org.testng.annotations.Test;

import axisbank.FdPage;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class FdTestCase extends Wrapper_Class {
	public WebDriver driver;
	
	FdPage fd ;
	
 
	@Parameters("browser")
	@BeforeClass
  
  public WebDriver driver;
  public void launchBrowser(String browser) throws InterruptedException {
	  
	  driver= launchBrowser(browser,"https://www.axisbank.com/retail/calculators/fd-calculator");
  }
  
  
  
  @Test
  public void testCase() throws AWTException, InterruptedException 
  {
	  fd = new  FdPage(driver);
	  
	  fd.selectTypeOfFixedDeposit();
	  //scrollDown();
	  
	  fd.amountOfDeposit();
	  
	  fd.clickAnywhere();
	  	  
	  String interest=fd.getAggregateInterest();
	  System.out.println(interest);
	  	  
      fd.clickAnywhere();
	  			  	   
	  takeScreenShot();	  
	  
  }
  
  
  @AfterClass
  public void closeBrowser() {
        //close current browser
        driver.close();
  }



}
