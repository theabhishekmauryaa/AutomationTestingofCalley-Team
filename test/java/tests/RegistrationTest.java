package tests;

import java.io.IOException;
import org.testng.annotations.Test;

import pages.RegisterPage;
import utils.Base;

public class RegistrationTest extends Base{
	
	@Test(priority = 1)
	public void RegisterByProvidingValidCredentials() throws IOException, InterruptedException {
		WebUtils.implicitWait(driver);
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.getSignupLink().click();
		registerpage.getNameInput().sendKeys(FileUtils.readCommonData("fullname"));
		registerpage.getEmailInput().sendKeys(FileUtils.readCommonData("email"));
		registerpage.getPasswordInput().sendKeys(FileUtils.readCommonData("password"));
		registerpage.getMobileInput().sendKeys(FileUtils.readCommonData("mobileNo"));
//		registerpage.getTermsCheckbox().click();
		registerpage.getSignUpButton().click();
		Thread.sleep(2000);
	}
	

    @Test(priority = 2)
    public void RegisterWithValidRandomData() throws IOException, InterruptedException {
        WebUtils.implicitWait(driver);
        RegisterPage registerpage = new RegisterPage(driver);
        registerpage.getSignupLink().click();
        registerpage.getNameInput().sendKeys(JavaUtils.getRandomString());
        registerpage.getEmailInput().sendKeys(JavaUtils.generateRandomEmail());
        registerpage.getPasswordInput().sendKeys("Test@1234");
        registerpage.getMobileInput().sendKeys(JavaUtils.generateRandomMobileNumber());
        registerpage.getSignUpButton().click();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void RegisterWithoutName() throws InterruptedException {
        WebUtils.implicitWait(driver);
        RegisterPage registerpage = new RegisterPage(driver);
        registerpage.getSignupLink().click();
        registerpage.getEmailInput().sendKeys(JavaUtils.generateRandomEmail());
        registerpage.getPasswordInput().sendKeys("Test@1234");
        registerpage.getMobileInput().sendKeys(JavaUtils.generateRandomMobileNumber());
        registerpage.getSignUpButton().click();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void RegisterWithoutEmail() throws InterruptedException {
        WebUtils.implicitWait(driver);
        RegisterPage registerpage = new RegisterPage(driver);
        registerpage.getSignupLink().click();
        registerpage.getNameInput().sendKeys(JavaUtils.getRandomString());
        registerpage.getPasswordInput().sendKeys("Test@1234");
        registerpage.getMobileInput().sendKeys(JavaUtils.generateRandomMobileNumber());
        registerpage.getSignUpButton().click();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void RegisterWithoutPassword() throws InterruptedException {
        WebUtils.implicitWait(driver);
        RegisterPage registerpage = new RegisterPage(driver);
        registerpage.getSignupLink().click();
        registerpage.getNameInput().sendKeys(JavaUtils.getRandomString());
        registerpage.getEmailInput().sendKeys(JavaUtils.generateRandomEmail());
        registerpage.getMobileInput().sendKeys(JavaUtils.generateRandomMobileNumber());
        registerpage.getSignUpButton().click();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void RegisterWithoutMobileNumber() throws InterruptedException {
        WebUtils.implicitWait(driver);
        RegisterPage registerpage = new RegisterPage(driver);
        registerpage.getSignupLink().click();
        registerpage.getNameInput().sendKeys(JavaUtils.getRandomString());
        registerpage.getEmailInput().sendKeys(JavaUtils.generateRandomEmail());
        registerpage.getPasswordInput().sendKeys("Test@1234");
        registerpage.getSignUpButton().click();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void RegisterWithInvalidEmailFormat() throws InterruptedException {
        WebUtils.implicitWait(driver);
        RegisterPage registerpage = new RegisterPage(driver);
        registerpage.getSignupLink().click();
        registerpage.getNameInput().sendKeys(JavaUtils.getRandomString());
        registerpage.getEmailInput().sendKeys("invalidemail.com");
        registerpage.getPasswordInput().sendKeys("Test@1234");
        registerpage.getMobileInput().sendKeys(JavaUtils.generateRandomMobileNumber());
        registerpage.getSignUpButton().click();
        Thread.sleep(2000);
    }

    @Test(priority = 8)
    public void RegisterWithWeakPassword() throws InterruptedException {
        WebUtils.implicitWait(driver);
        RegisterPage registerpage = new RegisterPage(driver);
        registerpage.getSignupLink().click();
        registerpage.getNameInput().sendKeys(JavaUtils.getRandomString());
        registerpage.getEmailInput().sendKeys(JavaUtils.generateRandomEmail());
        registerpage.getPasswordInput().sendKeys("123");
        registerpage.getMobileInput().sendKeys(JavaUtils.generateRandomMobileNumber());
        registerpage.getSignUpButton().click();
        Thread.sleep(2000);
    }

    @Test(priority = 9)
    public void RegisterWithShortMobileNumber() throws InterruptedException {
        WebUtils.implicitWait(driver);
        RegisterPage registerpage = new RegisterPage(driver);
        registerpage.getSignupLink().click();
        registerpage.getNameInput().sendKeys(JavaUtils.getRandomString());
        registerpage.getEmailInput().sendKeys(JavaUtils.generateRandomEmail());
        registerpage.getPasswordInput().sendKeys("Test@1234");
        registerpage.getMobileInput().sendKeys("12345");
        registerpage.getSignUpButton().click();
        Thread.sleep(2000);
    }

    @Test(priority = 10)
    public void RegisterWithDuplicateEmail() throws InterruptedException {
        WebUtils.implicitWait(driver);
        String email = JavaUtils.generateRandomEmail();

        RegisterPage registerpage = new RegisterPage(driver);
        registerpage.getSignupLink().click();
        registerpage.getNameInput().sendKeys(JavaUtils.getRandomString());
        registerpage.getEmailInput().sendKeys(email);
        registerpage.getPasswordInput().sendKeys("Test@1234");
        registerpage.getMobileInput().sendKeys(JavaUtils.generateRandomMobileNumber());
        registerpage.getSignUpButton().click();
        Thread.sleep(3000);

        driver.navigate().refresh();
        WebUtils.implicitWait(driver);

        registerpage.getSignupLink().click();
        registerpage.getNameInput().sendKeys(JavaUtils.getRandomString());
        registerpage.getEmailInput().sendKeys(email); // same email again
        registerpage.getPasswordInput().sendKeys("Test@1234");
        registerpage.getMobileInput().sendKeys(JavaUtils.generateRandomMobileNumber());
        registerpage.getSignUpButton().click();
        Thread.sleep(2000);
    }
	
	
	
	
	

}
