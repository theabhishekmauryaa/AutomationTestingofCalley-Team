package utils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class demo extends Base{
	@Test
	public static void setup() {
		try {
			driver.findElement(By.xpath("//a[@id='cmdsinup']")).click();
			driver.findElement(By.xpath("//input[@id='txtName']")).sendKeys("Abhishek Maurya");
			driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("Abhishekkumarverma0811@gmail.com");
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Abhi@12345");
			driver.findElement(By.xpath("//input[@id='txt_mobile']")).sendKeys("7371815289");
			Thread.sleep(5000);

//	        // Accept Terms & Conditions
	        WebElement termsCheckbox = driver.findElement(By.xpath("(//input[@id='checkbox-signup'])[1]"));
	        if (!termsCheckbox.isSelected()) {
	            termsCheckbox.click();
	        }
	        Thread.sleep(5000);
	        driver.findElement(By.id("btnSignUp")).click();
	        Thread.sleep(4000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void loginpages() {
		//Enter email id
		driver.findElement(By.xpath("//input[@placeholder='Your Email Address']")).sendKeys("abhishekkumarverma0811@gmail.com");
		//Enter password
		driver.findElement(By.xpath("//input[@placeholder='Your Password']")).sendKeys("Abhishek@1234");
		//Enter login buttom click
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	
	}
	
	@Test
	public void logiForgotPassword() throws InterruptedException {
	    // Click the "Forgot Password?" link
	    driver.findElement(By.xpath("//a[normalize-space()='Forgot Password?']")).click();

	    // Enter email id
	    driver.findElement(By.xpath("//input[@placeholder='Enter Email Id']")).sendKeys("abhishekkumarverma0811@gmail.com");

	    // Click "Reset Password"
	    driver.findElement(By.xpath("//input[@value='Reset Password']")).click();

	    // Wait for the popup to appear
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement popupMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//h2[contains(text(),'We have sent the password reset link on your registered email id')]")
	    ));

	    // Validate the popup message
	    String actualMsg = popupMessage.getText();
	    String expectedMsg = "We have sent the password reset link on your registered email id";

	    if (actualMsg.contains(expectedMsg)) {
	        System.out.println("✅ Message Verified: " + actualMsg);
	    } else {
	        System.out.println("❌ Message Mismatch: " + actualMsg);
	    }

	    // Click OK button
	    WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//button[normalize-space()='OK']")
	    ));
	    okButton.click();

	    // Optional: wait after popup is closed
	    Thread.sleep(2000);
	}
	
	@Test
	public void AddNewLisst() throws IOException, InterruptedException {
		loginpageValidCrendails();
		driver.findElement(By.xpath("//span[@aria-hidden='true']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Add New List')]")).click();
		driver.findElement(By.xpath("(//input[@id='ContentPlaceHolder1_txtlistname'])[1]")).sendKeys("filetosend");
		// file upload
		driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_fileUpload']")).sendKeys("D:\\masai\\Evaluate-Prograne\\Project\\CalleyAutomation\\src\\test\\resources\\Sample File(in).csv");		
	}

	@Test
	public void AddNewList() throws IOException, InterruptedException {
	    loginpageValidCrendails();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // === Step 1: Close "Calley Won’t Call" modal if present ===
	    try {
	        WebElement closeModalBtn = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//span[@aria-hidden='true']")));
	        js.executeScript("arguments[0].click();", closeModalBtn);
	        System.out.println("✅ Modal closed.");
	    } catch (Exception e) {
	        System.out.println("ℹ️ Modal already closed or not found.");
	    }

	    // === Step 2: Handle "Subscribe" notification popup (Click Later if appears) ===
	    try {
	        WebElement laterBtn = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//button[normalize-space()='Later']")));
	        laterBtn.click();
	        System.out.println("✅ Clicked 'Later' on notification popup.");
	    } catch (Exception e) {
	        System.out.println("ℹ️ No subscription popup found.");
	    }

	    // === Step 3: Click on "Add New List" ===
	    WebElement addNewListBtn = driver.findElement(By.xpath("//a[normalize-space()='Add New List']//i[@class='fa fa-plus-square']"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addNewListBtn);
	    wait.until(ExpectedConditions.elementToBeClickable(addNewListBtn)).click();


	    // === Step 4: Enter List Name ===
	    WebElement listNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.id("ContentPlaceHolder1_txtlistname")));
	    listNameInput.sendKeys("filetosend");
	    System.out.println("✅ Entered list name");

	    // === Step 5: Upload CSV File ===
	    WebElement fileUploadInput = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.id("ContentPlaceHolder1_fileUpload")));
	    fileUploadInput.sendKeys("D:\\masai\\Evaluate-Prograne\\Project\\CalleyAutomation\\src\\test\\resources\\Sample File(in).csv");
	    System.out.println("✅ File uploaded");

	    // === Step 6: Optional - Click Submit/Save button if required ===
	    // WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("submitBtn")));
	    // submitBtn.click();
	}
	
	@Test
	public void AddNewLissst() throws IOException, InterruptedException {
	    loginpageValidCrendails();

	    // Step 1: Close "Calley Won’t Call" modal if present
	    if (driver.findElements(By.xpath("//span[@aria-hidden='true']")).size() > 0) {
	        WebElement closeModal = driver.findElement(By.xpath("//span[@aria-hidden='true']"));
	        closeModal.click();
	        System.out.println("✅ Closed 'Calley Won’t Call' modal.");
	    }

	    // Step 2: Handle "Subscribe" popup (Click 'Later' if present)
	    if (driver.findElements(By.xpath("//button[normalize-space()='Later']")).size() > 0) {
	        WebElement laterBtn = driver.findElement(By.xpath("//button[normalize-space()='Later']"));
	        laterBtn.click();
	        System.out.println("✅ Clicked 'Later' on notification popup.");
	    }

	    // Step 3: Click on "Add New List"
	    WebElement addNewListBtn = driver.findElement(By.xpath("//a[normalize-space()='Add New List']//i[@class='fa fa-plus-square']"));
	    addNewListBtn.click();
	    System.out.println("✅ Clicked on 'Add New List'.");

	    // Step 4: Enter List Name
	    WebElement listNameInput = driver.findElement(By.id("ContentPlaceHolder1_txtlistname"));
	    listNameInput.sendKeys("filetosend");
	    System.out.println("✅ Entered list name.");

	    // Step 5: Upload CSV file
	    WebElement fileUploadInput = driver.findElement(By.id("ContentPlaceHolder1_fileUpload"));
	    fileUploadInput.sendKeys("D:\\masai\\Evaluate-Prograne\\Project\\CalleyAutomation\\src\\test\\resources\\demo.csv");
	    Thread.sleep(5000);
	    System.out.println("✅ File uploaded.");
	    
	    Thread.sleep(5000);
	    
        driver.findElement(By.xpath("//a[@id=\"btnUp\" and @class=\"btn btn-new2\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

     // Wait until the OK button is visible and clickable
     WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(
         By.xpath("//button[contains(@class, 'confirm') and text()='Ok']"))
     );

     // Click the OK button
     Thread.sleep(4000);
     okButton.click();
     Thread.sleep(5000);

     System.out.println("√ Clicked the OK button successfully");
     WebElement dropdown = driver.findElement(By.id("ddlbelongto_1"));

  // Create Select object
  Select select = new Select(dropdown);

  // Select by visible text
  select.selectByVisibleText("FirstName");

WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='ddlbelongto_2']"));
// Create Select object
Select select1 = new Select(dropdown1);

// Select by visible text
select1.selectByVisibleText("Phone");

WebElement dropdown2 = driver.findElement(By.xpath("//select[@id='ddlbelongto_3']"));
Select select2 = new Select(dropdown2);

//Select by visible text
select2.selectByVisibleText("Notes");


Thread.sleep(4000);
driver.findElement(By.xpath("//input[@id=\"ContentPlaceHolder1_btnUpload\" and @type=\"submit\"]")).click();
Thread.sleep(4000);

WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(4));

// Wait until the OK button is visible and clickable
WebElement okButton1 = wait1.until(ExpectedConditions.elementToBeClickable(
    By.xpath("//button[contains(@class, 'confirm') and text()='Ok']"))
);

// Click the OK button
Thread.sleep(4000);
okButton1.click();
Thread.sleep(5000);
     

	    
	}


}
