package selenium_jenkins_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG {

    WebDriver driver = null;

    @BeforeTest
    public void setUpTest() {
        // Set up WebDriverManager
        WebDriverManager.chromedriver().setup();
        
        // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-web-security");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
        // Initialize ChromeDriver
        driver = new ChromeDriver(options);
    }

    @Test
    public void googleSearch() {
        // Go to google.com
        driver.get("https://google.com");
        // Enter text in search textbox
        driver.findElement(By.name("q")).sendKeys("Ascend Solutions");
        // Press Enter key
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
    }

    @AfterTest
    public void tearDownTest() {
        if (driver != null) {
            // Close browser
            driver.quit();
            System.out.println("Test Completed Successfully");
        }
    }
}
