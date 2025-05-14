package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.Base;

public class LoginTest extends Base {
	
	@Test(priority = 1)
    public void loginpageValidCrendails() throws IOException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.getEmailField().sendKeys(FileUtils.readCommonData("email"));
        loginPage.getPasswordField().sendKeys(FileUtils.readCommonData("password"));
        loginPage.getLoginButton().click();
    }

    @Test(priority = 2)
    public void logiForgotPassword() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.getForgotPasswordLink().click();
        loginPage.getForgotEmailField().sendKeys(FileUtils.readCommonData("email"));
        loginPage.getResetPasswordButton().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popupMsg = wait.until(ExpectedConditions.visibilityOf(loginPage.getPopupMessage()));

        String actualMsg = popupMsg.getText();
        String expectedMsg = "We have sent the password reset link on your registered email id";

        if (actualMsg.contains(expectedMsg)) {
            System.out.println("✅ Message Verified: " + actualMsg);
        } else {
            System.out.println("❌ Message Mismatch: " + actualMsg);
        }

        loginPage.getOkButton().click();
        Thread.sleep(2000);
    }
    
    @Test(priority = 3)
    public void loginWithInvalidEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailField().sendKeys(JavaUtils.generateRandomEmail());
        loginPage.getPasswordField().sendKeys("Abhishek@1234");
        loginPage.getLoginButton().click();
    }
    
    
    @Test(priority = 4)
    public void loginWithInvalidPassword() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailField().sendKeys(FileUtils.readCommonData("email"));
        loginPage.getPasswordField().sendKeys("WrongPassword123");
        loginPage.getLoginButton().click();
    }
    
    @Test(priority = 5)
    public void loginWithEmptyFields() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getLoginButton().click();
    }
    
    @Test(priority = 6)
    public void forgotPasswordWithInvalidEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getForgotPasswordLink().click();
        loginPage.getForgotEmailField().sendKeys(JavaUtils.generateRandomEmail());
        loginPage.getResetPasswordButton().click();
    }
    
    @Test(priority = 7)
    public void forgotPasswordWithEmptyField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getForgotPasswordLink().click();
        loginPage.getResetPasswordButton().click();
    }
    
    @Test(priority = 8)
    public void loginWithSpecialCharEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailField().sendKeys("!@#$%^&*()");
        loginPage.getPasswordField().sendKeys("Abhishek@1234");
        loginPage.getLoginButton().click();
    }
    
    @Test(priority = 9)
    public void loginWithLongStringInputs() {
        LoginPage loginPage = new LoginPage(driver);
        String longEmail = JavaUtils.getRandomString() + "@test.com";
        String longPassword = JavaUtils.getRandomString();

        loginPage.getEmailField().sendKeys(longEmail);
        loginPage.getPasswordField().sendKeys(longPassword);
        loginPage.getLoginButton().click();
    }
    
    @Test(priority = 10)
    public void verifyForgotPasswordPopupUI() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getForgotPasswordLink().click();
        loginPage.getForgotEmailField().sendKeys(FileUtils.readCommonData("email"));
        loginPage.getResetPasswordButton().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement okBtn = wait.until(ExpectedConditions.elementToBeClickable(loginPage.getOkButton()));

        Assert.assertTrue(okBtn.isDisplayed(), "❌ OK button not visible");
        okBtn.click();
    }









}
