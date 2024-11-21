package fileupload;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {
	public static void main(String[] args) throws Exception {
		// Set the path for your WebDriver
		WebDriverManager.chromedriver().setup();
		// Initialize the Chrome driver
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.foundit.in/fileupload");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn__text']")).click();
		Thread.sleep(5000);
		// 1. Using sendKeys
		// driver.findElement(By.id("file-upload"))
		// .sendKeys("C:\\Users\\91995\\Downloads\\RESIDEO\\MohanKumar Ramasamy.pdf");
		// 2. Using Robot Class
		WebElement uploadBtn = driver.findElement(By.id("file-upload"));
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click()", uploadBtn);
		// Copy the file path into click board (CTRL+C)
		StringSelection filePathSelection = new StringSelection(
				"C:\\Users\\91995\\Downloads\\RESIDEO\\MohanKumar Ramasamy.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);
		// CTRL+V
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		// Click On Return/Enter Key
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		driver.quit();

	}
}
