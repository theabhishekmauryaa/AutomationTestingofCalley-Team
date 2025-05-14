package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Login elements x-path using
    @FindBy(xpath = "//input[@placeholder='Your Email Address']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Your Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Log in']")
    private WebElement loginButton;

    // Forgot password flow
    @FindBy(xpath = "//a[normalize-space()='Forgot Password?']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//input[@placeholder='Enter Email Id']")
    private WebElement forgotEmailField;

    @FindBy(xpath = "//input[@value='Reset Password']")
    private WebElement resetPasswordButton;

    @FindBy(xpath = "//h2[contains(text(),'We have sent the password reset link on your registered email id')]")
    private WebElement popupMessage;

    @FindBy(xpath = "//button[normalize-space()='OK']")
    private WebElement okButton;

    // ======= Return Methods =======

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    public WebElement getForgotEmailField() {
        return forgotEmailField;
    }

    public WebElement getResetPasswordButton() {
        return resetPasswordButton;
    }

    public WebElement getPopupMessage() {
        return popupMessage;
    }

    public WebElement getOkButton() {
        return okButton;
    }
}
