package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	 WebDriver driver;

	    // Constructor
	    public RegisterPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    // Locators (XPath-based)

	    @FindBy(xpath = "//a[@id='cmdsinup']")
	    private WebElement signupLink;

	    @FindBy(xpath = "//input[@id='txtName']")
	    private WebElement nameInput;

	    @FindBy(xpath = "//input[@id='txtEmail']")
	    private WebElement emailInput;

	    @FindBy(xpath = "//input[@id='txtPassword']")
	    private WebElement passwordInput;

	    @FindBy(xpath = "//input[@id='txt_mobile']")
	    private WebElement mobileInput;

	    @FindBy(xpath = "//input[@id='checkbox-signup']")
	    private WebElement termsCheckbox;

	    @FindBy(id = "btnSignUp")
	    private WebElement signUpButton;

	    // Getter methods

	    public WebElement getSignupLink() {
	        return signupLink;
	    }

	    public WebElement getNameInput() {
	        return nameInput;
	    }

	    public WebElement getEmailInput() {
	        return emailInput;
	    }

	    public WebElement getPasswordInput() {
	        return passwordInput;
	    }

	    public WebElement getMobileInput() {
	        return mobileInput;
	    }

	    public WebElement getTermsCheckbox() {
	        return termsCheckbox;
	    }

	    public WebElement getSignUpButton() {
	        return signUpButton;
	    }
}
