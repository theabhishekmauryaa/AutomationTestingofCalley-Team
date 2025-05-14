package pages;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class AddListPage {
    WebDriver driver;
    WebDriverWait wait;

    public AddListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Modals and Popups
    @FindBy(xpath = "//span[@aria-hidden='true']")
    private List<WebElement> closeModalButtons;

    @FindBy(xpath = "//button[normalize-space()='Later']")
    private List<WebElement> laterButtons;

    // Add New List
    @FindBy(xpath = "//a[normalize-space()='Add New List']//i[@class='fa fa-plus-square']")
    private WebElement addNewListButton;

    @FindBy(id = "ContentPlaceHolder1_txtlistname")
    private WebElement listNameInput;

    @FindBy(id = "ContentPlaceHolder1_fileUpload")
    private WebElement fileUploadInput;

    @FindBy(xpath = "//a[@id='btnUp' and @class='btn btn-new2']")
    private WebElement uploadBtn;

    @FindBy(xpath = "//button[contains(@class, 'confirm') and text()='Ok']")
    private WebElement okButton;

    @FindBy(id = "ddlbelongto_1")
    private WebElement dropdown1;

    @FindBy(id = "ddlbelongto_2")
    private WebElement dropdown2;

    @FindBy(id = "ddlbelongto_3")
    private WebElement dropdown3;

    @FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnUpload' and @type='submit']")
    private WebElement submitButton;
    
    @FindBy(xpath = "//button[contains(@class, 'confirm') and text()='OK']")
    private WebElement  finalOkButtom;

    // Methods

    public void closeCalleyModalIfPresent() {
        if (!closeModalButtons.isEmpty()) {
            closeModalButtons.get(0).click();
        }
    }

    public void dismissSubscribePopupIfPresent() {
        if (!laterButtons.isEmpty()) {
            laterButtons.get(0).click();
        }
    }

    public void clickAddNewList() {
        addNewListButton.click();
    }

    public void enterListName(String name) {
        listNameInput.sendKeys(name);
    }

    public void uploadCSV(String filePath) throws InterruptedException {
        fileUploadInput.sendKeys(new File(filePath).getAbsolutePath());
        Thread.sleep(5000); 
    }

    public void clickUploadButtonAndAcceptConfirmation() throws InterruptedException {
        uploadBtn.click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
        Thread.sleep(5000);
    }

    public void selectDropdownValues() {
        new Select(dropdown1).selectByVisibleText("FirstName");
        new Select(dropdown2).selectByVisibleText("Phone");
        new Select(dropdown3).selectByVisibleText("Notes");
    }

    public void clickFinalSubmitAndAcceptConfirmation() throws InterruptedException {
        submitButton.click();
        WebElement finalOk = wait.until(ExpectedConditions.elementToBeClickable(okButton));
        Thread.sleep(4000);
        finalOk.click();
        Thread.sleep(5000);
    }
    public void finalOkbuttomclick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(finalOkButtom));
        finalOkButtom.click();
    }
}
