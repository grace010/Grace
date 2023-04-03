package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_Wait_1 {
	WebDriver driver;
	String ProjectPath = System.getProperty("user.dir");
	WebDriverWait explicitWait;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", ProjectPath +"\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		explicitWait= new WebDriverWait(driver, 10);
	}
	
	@Test
	public void wait_1_visibility() {
		driver.get("https://www.facebook.com/");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@gmail.com");
	
	}
	
	@Test
	public void wait_1_invisibility() {
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@gmail.com");
	
	}
	
	@AfterClass
	public void afterClass() {
		 driver.quit();
	}

}
