package duplicateoptionsinlistbox;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateOptionsinListBox {
	public static void main(String[] args) {
		// Set the path for your WebDriver
		WebDriverManager.chromedriver().setup();
		// Initialize the Chrome driver
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement listBox = driver.findElement(By.id("animals"));
		// WebElement listBox = driver.findElement(By.id("colors"));

		Select select = new Select(listBox);

		Set<String> uniqueOptions = new HashSet<String>();

		boolean flag = false;
		for (WebElement option : select.getAllSelectedOptions()) {
			String optionText = option.getText();
			if (!uniqueOptions.add(optionText)) {
				System.out.println("Duplicate Option Found" + optionText);
				flag = true;
			}
		}
		if (!flag) {
			System.out.println("No Duplicates Found in the list in box...");
		}
		driver.quit();
	}

}
