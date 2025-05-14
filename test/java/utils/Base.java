package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.LoginPage;

public class Base {
	public static WebDriver driver;
	public FileUtility FileUtils = new FileUtility();
	public webDriverUtility WebUtils = new webDriverUtility();
	public JavaUtility JavaUtils = new JavaUtility();
	
	@BeforeMethod
	public void configBeforeMethod() throws IOException
	{
		String browsername = FileUtils.readCommonData("browsername");
		if(browsername.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browsername.equals("edge"))
		{
			driver = new EdgeDriver();
			
		}
		driver.get(FileUtils.readCommonData("url"));
		driver.manage().window().maximize();
		
	}
	
	
	public void loginpageValidCrendails() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.getEmailField().sendKeys(FileUtils.readCommonData("email"));
        loginPage.getPasswordField().sendKeys(FileUtils.readCommonData("password"));
        loginPage.getLoginButton().click();
    }
	
	@AfterMethod 
	public void configAfterMethod() throws InterruptedException
	{
		driver.manage().window().minimize();
		Thread.sleep(6000);
		driver.quit();
	}

	public static WebDriver getDriver() {
		return null;
	}

}
