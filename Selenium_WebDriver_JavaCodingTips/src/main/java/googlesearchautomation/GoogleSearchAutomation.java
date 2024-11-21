package googlesearchautomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class GoogleSearchAutomation {
	public static void main(String[] args) {
		// Set the path for your WebDriver
		WebDriverManager.chromedriver().setup();
		// Initialize the Chrome driver
		WebDriver driver = new ChromeDriver();
		try {
			// Open Google
			driver.get("https://www.google.com");

			// Find the search box and enter "ABC"
			WebElement searchBox = driver.findElement(By.name("q"));
			searchBox.sendKeys("ABC");
			searchBox.submit();

			// Wait for the auto-suggest dropdown to appear
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.erkvQe")));

			// Capture the suggestions
			List<WebElement> suggestions = driver.findElements(By.cssSelector("ul.erkvQe li"));

			// Get the size of the suggestions
			int suggestionCount = suggestions.size();
			System.out.println("Number of suggestions: " + suggestionCount);

			// Print the text of all suggestions
			for (WebElement suggestion : suggestions) {
				System.out.println(suggestion.getText());
			}

			// Click on the first suggestion
			if (suggestionCount > 0) {
				suggestions.get(0).click();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}
	}
}
