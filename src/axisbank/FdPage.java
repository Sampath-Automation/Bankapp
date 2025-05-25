package axisbank;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FdPage extends Wrapper_Class {

	WebDriver driver;
	
	By seniorCitizen = By.xpath("//*[@id=\"RadioButton\"]/label[2]");
 
	By loanAmount = By.xpath("//*[@id=\"loan_amount\"]");
	
	By aggregateInterest = By.xpath("//*[@id=\"ctl00_Body_C022_Col00\"]/div/div[3]/div[2]/div[1]/div/article[2]/div/div[2]");
	
	public FdPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
		
	public void selectTypeOfFixedDeposit() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"RadioButton\"]/label[2]")).click();
		
		WebElement sc = driver.findElement(By.xpath("//*[@id=\"FdepType\"]")); //select the web element
		
		Select d1 = new Select(sc);

		d1.selectByIndex(2);
		
		Thread.sleep(2000);		
	    				
	}
	
	public void amountOfDeposit()
	{
		driver.findElement(By.xpath("//*[@id=\"loan_amount\"]")).clear();
		
		int amount=readExcel("C:\\Users\\candy\\seleniumws\\Axis_Bank_SBA\\excelaxis.xlsx","Sheet1",1,1);
		
		
		sendTextToElement(driver,loanAmount,amount);
	}
	
	public void clickAnywhere() throws AWTException
	{
		 Actions actions = new Actions(driver);

		  Robot robot = new Robot();

		  robot.mouseMove(50,50);

		  actions.click().build().perform();
	}
	
	public String getAggregateInterest()
	{
		String interest=getTextFromElement(driver,aggregateInterest);
		
		return interest;
	}
	

}
