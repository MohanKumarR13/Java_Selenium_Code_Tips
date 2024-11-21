package findwebelementscrollingpageinfinitely;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindABookInaScrollingPage {

	public static void main(String[] args) throws Exception {
		// Set the path for your WebDriver
		WebDriverManager.chromedriver().setup();
		// Initialize the Chrome driver
		WebDriver driver = new ChromeDriver();
		// Open Google
		driver.get("https://www.booksbykilo.in/new-books");
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// WebElement books = driver.findElement(By.xpath("//*[normalize-space()=\"The
		// Vile Victorians\"]"));

		// js.executeScript("arguments[0].scrollIntoView();", books);

		// Logic
		boolean found = false;
		Actions actions = new Actions(driver);
		while (!found) {
			List<WebElement> bookWebElements = driver.findElements(By.xpath("//*[@id='productsDiv']//h3"));
			for (WebElement bookWebElement : bookWebElements) {
				if (bookWebElement.getText().equals("The Vile Victorians")) {
					System.out.println("Book Found");
					found = true;
					break;
				}
			}
			actions.sendKeys(Keys.END).perform();
		}

		driver.quit();
	}

}
