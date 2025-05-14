package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class webDriverUtility {
public WebDriver driver;
	
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
