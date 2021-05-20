package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Events extends AbstractPage 
{
	public Events(WebDriver driver) throws Throwable {
		super(driver);
	}
	
	public void getProperty() throws Throwable
	{
		File src=new File("/objectRepository.properties");
		 
		// Create  FileInputStream object
		FileInputStream fis=new FileInputStream(src);
		 
		// Create Properties class object to read properties file
		Properties pro=new Properties();
		 
		// Load file so we can use into our script
		pro.load(fis);
	
	}
	//load object repository
	Properties prop = Data.getProperties("objectlocations");
	public void checkElement(String object,int loop, int wait, int hardWait) throws Throwable
	{
		boolean displayed = false;
		boolean enabled = false;
		
		try 
		{
			for(int i=0; i<loop; i++)
			{
			driver.findElement(By.xpath(prop.getProperty(object))).isDisplayed();
			driver.findElement(By.xpath(prop.getProperty(object))).isEnabled();
			
			if ((displayed = true) && (enabled = true))
			{
				System.out.println("Step Passed: Check Element Existence (" + object + ")");
				break;
			}
			else if((displayed = false) || (enabled = false))
			{
				Thread.sleep(wait);
			}
			
			}
		}
		catch (Exception e)
		{
			
		}
		Thread.sleep(hardWait);
	}
	public void clickButton(String object,int loop, int wait, int hardWait) throws Throwable
	{
		boolean displayed = false;
		boolean enabled = false;
		
		try 
		{
			for(int i=0; i<loop; i++)
			{
			driver.findElement(By.xpath(prop.getProperty(object))).isDisplayed();
			driver.findElement(By.xpath(prop.getProperty(object))).isEnabled();
			
			if ((displayed = true) && (enabled = true))
			{
				driver.findElement(By.xpath(prop.getProperty(object))).click();
				System.out.println("Step Passed: Click Button (" + object + ")");
				break;
			}
			else if((displayed = false) || (enabled = false))
			{
				Thread.sleep(wait);
			}
			
			}
		}
		catch (Exception e)
		{
			
		}
		Thread.sleep(hardWait);
	}
	public String getCurrentDate(String format, int hardWait) throws Throwable
	{
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		System.out.println("Step Passed: Get Current Date (" + dateFormat.format(date) + ")");
		String currentDate = dateFormat.format(date);
		Thread.sleep(hardWait);
		return currentDate;
		
	}
	public void enterDataTextbox(String object, String data, int wait) throws Throwable
	{
		driver.findElement(By.xpath(prop.getProperty(object))).sendKeys(data);
		Thread.sleep(wait);
		System.out.println("Step Passed: Enter Data into Textbox (" + object + ")(Value: " + data +")");
		
	}
	public void getText(String object,int wait) throws Throwable
	{
		driver.findElement(By.xpath(prop.getProperty(object))).getText();
		Thread.sleep(wait);
	}
	public void navigateBack()
	{
		driver.navigate().back();
	}
	public void refreshPage()
	{
		driver.navigate().refresh();
		System.out.println("Step Passed: Navigate Back");
	}
	public void navigateToURL(String URL, int wait) throws Throwable
	{
		driver.get(URL);
		Thread.sleep(wait);
	}
	public void getTitle(int wait)
	{
		driver.getTitle();
	}
	public void clearTextbox(String object, int wait)
	{
		driver.findElement(By.xpath(object)).clear(); 
	}
}
