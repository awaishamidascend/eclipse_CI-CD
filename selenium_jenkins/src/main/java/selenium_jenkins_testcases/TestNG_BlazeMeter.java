package selenium_jenkins_testcases;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

public class TestNG_BlazeMeter {

  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private WebDriverWait wait;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    try {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      baseUrl = "https://www.blazedemo.com/";
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      wait = new WebDriverWait(driver, 30);
    } catch (Exception e) {
      System.err.println("Error setting up WebDriver: " + e.getMessage());
      throw e;
    }
  }

  @Test
  public void testBlazeMeter() throws Exception {
    try {
      driver.get("https://nhcc.ascend.com.sa/alltickets");
      // Wait for the page to load and ensure it contains the expected element
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
      // Add your assertions or further interactions here
      // Example:
      // WebElement element = driver.findElement(By.id("someElementId"));
      // assertTrue(element.isDisplayed(), "Element is not displayed");
    } catch (Exception e) {
      System.err.println("Error during test execution: " + e.getMessage());
      verificationErrors.append(e.toString());
      throw e;
    }
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    if (driver != null) {
      driver.quit();
    }
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  // Optional: Method to handle alerts if needed
  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
