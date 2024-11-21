package handlingiframe;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

//HandleIframes without using switchTo().frame();
public class HandleIframes {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://ui.vision/demo/webtest/frames/");
	driver.manage().window().maximize();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("disable-infobars");
	//1. Using swichTo
	//WebElement frameElement=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
	//driver.switchTo().frame(frameElement);
	//driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("testing");
	//Using WebDriverWait
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(500));
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("//frame[@src='frame_1.html']"));
	driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("testing");
	driver.quit();
}
}
