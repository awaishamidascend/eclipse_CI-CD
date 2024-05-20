package test.automate;

import java.time.Duration;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class apm_login {

	public static void main(String[] args) throws InterruptedException {
		
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://apm.ascend.com.sa/");
		
        driver.findElement(By.cssSelector("input[placeholder='Email / Phone number']")).sendKeys("awais.hamid@ascend.com.sa");
		
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("Ascend@745382");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//span[@class='menu-item menu-title text-capitalize'][normalize-space()='All'])[1]")).click();
		
		Thread.sleep(5000);

		driver.findElement(By.cssSelector("#Export")).click();
		
		driver.findElement(By.className("spinner-border text-white")).click();


		
	}

}
