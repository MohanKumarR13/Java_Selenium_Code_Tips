package windowhandle;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window_Handling {

	public static void main(String[] args) {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/alert.xhtml");
		String oldWindow = driver.getWindowHandle();
		WebElement browser = driver.findElement(By.id("menuform:j_idt38"));
		browser.click();
		WebElement window = driver.findElement(By.id("menuform:m_window"));
		window.click();

		Set<String> handles = driver.getWindowHandles();
		for (String newWindows : handles) {
			driver.switchTo().window(newWindows);
		}
		 WebElement newTab = driver.findElement(By.name("j_idt88:new"));
		newTab.click();
		driver.switchTo().window(oldWindow);

		WebElement openMultiple = driver.findElement(By.name("j_idt88:j_idt91"));
		openMultiple.click();
		driver.getWindowHandles().size();
		int numberOfWindows = driver.getWindowHandles().size();
		System.out.println("No Of Windows Opened :" + numberOfWindows);

		WebElement dontClose = driver.findElement(By.name("j_idt88:j_idt91"));
		dontClose.click();

		Set<String> newWindowHandles = driver.getWindowHandles();
		for (String allWindows : newWindowHandles) {
			if (!allWindows.equals(oldWindow)) {
				driver.switchTo().window(allWindows);
				driver.close();
			}
		}
		driver.quit();

	}

}
