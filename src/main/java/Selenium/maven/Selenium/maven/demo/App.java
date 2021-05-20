package Selenium.maven.Selenium.maven.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Events;


public class App 
{
	static WebDriver driver;
	
    public static void main( String[] args ) throws Throwable
    {	
    	
    	//intialize the chrome driver and tell where the .exe is. In this example its at the root of the project then the driver folder
    	System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    	//set your driver equal to the chrome driver
    	driver = new ChromeDriver();
    	
    	//initialize your events object utilizing the driver
		Events event = new Events(driver);
		
		//call each event and start your test
		event.navigateToURL("http://google.com", 1000);
		
		//php travels is a test automation site
		event.navigateToURL("http://automationpractice.com/index.php", 1000);
		
		event.checkElement("AutoPracticeSignInButton", 30, 500, 1000);
		event.clickButton("AutoPracticeSignInButton",30,1000,500);
		

    }
}
