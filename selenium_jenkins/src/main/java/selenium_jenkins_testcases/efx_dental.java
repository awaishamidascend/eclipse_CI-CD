package selenium_jenkins_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class efx_dental {
    
    public static void main(String[] args) {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();   
        driver.get("https://efficax-dental.ascend.com.sa/");
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Wait until the email input field is visible
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email']")));
        
        // Fill in the email and password fields
        emailInput.sendKeys("rida.khan@ascend.com.sa");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("eod777");
        
        // Click on the login button
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        
        // Wait until the "Dental Supplies" link is clickable
        WebElement dentalSuppliesLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Dental Supplies']")));
        
        // Click on the "Dental Supplies" link
        dentalSuppliesLink.click();
        
        // Close the browser
        driver.quit();
    }
}
