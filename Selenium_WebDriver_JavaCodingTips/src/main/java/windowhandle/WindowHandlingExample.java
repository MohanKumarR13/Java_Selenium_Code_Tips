package windowhandle;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingExample {
	public static void main(String[] args) throws InterruptedException {
		// Set up the WebDriver (Chrome in this case)
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Open the main window and two additional windows
		driver.get("https://www.google.com");
		((JavascriptExecutor) driver).executeScript("window.open('https://www.bing.com');");
		((JavascriptExecutor) driver).executeScript("window.open('https://www.yahoo.com');");

		// Wait for windows to load
		Thread.sleep(2000);

		// Get window handles and convert to an array
		Set<String> windowHandles = driver.getWindowHandles();
		String[] windows = windowHandles.toArray(new String[0]);

		// Close the third window and switch back to the first window
		driver.switchTo().window(windows[2]).close(); // Close third window
		driver.switchTo().window(windows[0]); // Switch back to first window

		// Perform actions in window 1 (Google)
		System.out.println("Now in window 1: " + driver.getTitle());

		// Close the driver (all windows)
		driver.quit();
	}
}
