package selenium_jenkins_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amanexport {
	public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://efficax-obligation.ascend.com.sa/login?isQA=true");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("system@ascend.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("eod777");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);
        String otp = "786786";
        // Find the OTP input field
        //WebElement otpInput = driver.findElement(By.xpath("//input[@aria-label='Please enter OTP character 1']"));
        // Loop through each digit of the OTP and enter it into the input field
        for (int i = 0; i < otp.length(); i++) {
            char digit = otp.charAt(i);
            String digitAsString = Character.toString(digit);
            // Construct XPath for locating each box of the OTP input field
            String xpath = "//input[@aria-label='Please enter OTP character " + (i + 1) + "']";
            WebElement otpBox = driver.findElement(By.xpath(xpath));
            otpBox.sendKeys(digitAsString);
        }
        //OTP Login Button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.print("OTP logged in successfully");
        Thread.sleep(50000);
        System.out.print("Wait statement executed successfully");

        
       // driver.findElement(By.xpath("//span[contains(@class,'menu-item text-truncate')][normalize-space()='Users']")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/img[1]")).click();
       // Thread.sleep(50000);
       // driver.findElement(By.xpath("//span[contains(@class,'menu-item text-truncate')][normalize-space()='Regions']")).click();
        //driver.findElement(By.xpath("//div[@id='export']//div//img")).click();
        //Thread.sleep(50000);
        //driver.findElement(By.xpath("//span[@class='menu-item text-truncate'][normalize-space()='Sites']")).click();
        //driver.findElement(By.xpath("//div[@id='export']//div//img")).click();
        //Thread.sleep(50000);
       
        

        
      
//Awais
    }}
