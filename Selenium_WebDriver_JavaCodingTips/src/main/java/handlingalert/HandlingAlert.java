package handlingalert;
//HandleIframes without using switchTo().alert();

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAlert {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		WebElement alertBtn = driver.findElement(By.id("alertBtn"));
		alertBtn.click();
		Thread.sleep(3000);

		// 1.Using Alert
		/*
		 * Alert alert = driver.switchTo().alert(); alert.accept(); // 2.Using
		 * WebDriverWait WebDriverWait driverWait = new WebDriverWait(driver,
		 * Duration.ofSeconds(10)); Alert alert2 =
		 * driverWait.until(ExpectedConditions.alertIsPresent()); alert2.accept();
		 */
		// Using JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("window.alert-function{};");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
