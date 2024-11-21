package countelementscrollingpageinfinitely;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindNumberOfBooks {

	public static void main(String[] args) throws Exception {
		// Set the path for your WebDriver
		WebDriverManager.chromedriver().setup();
		// Initialize the Chrome driver
		WebDriver driver = new ChromeDriver();
		// Open Google
		driver.get("https://www.booksbykilo.in/new-books");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// List<WebElement> books =
		// driver.findElements(By.xpath("//*[@id='productsDiv']//h3"));
		// System.out.println("No Of Books " + books.size());

		// js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		// System.out.println("No Of Books " + books.size());

		// Logic
		int previousCount = 0;
		int currentCount = 0;
		Actions actions = new Actions(driver);
		while (true) {
			List<WebElement> book = driver.findElements(By.xpath("//*[@id='productsDiv']//h3"));
			currentCount = book.size();

			if (currentCount == previousCount) {
				break;
			}
			previousCount = currentCount;
			actions.sendKeys(Keys.END).perform();
			Thread.sleep(5000);
		}

		System.out.println("Total Number Of Books" + currentCount);
		driver.quit();
	}

}
