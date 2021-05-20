package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class AbstractPage {
	
	protected WebDriver driver;
	
	public AbstractPage (WebDriver driver){
		
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
