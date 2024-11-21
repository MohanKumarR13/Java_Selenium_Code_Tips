package sorteddropdownlist;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortedDropDownList {
	public static void main(String[] args) {
		// Set the path for your WebDriver
		WebDriverManager.chromedriver().setup();
		// Initialize the Chrome driver
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		//WebElement dropDwn = driver.findElement(By.id("animals"));
		WebElement dropDwn = driver.findElement(By.id("colors"));

		Select select = new Select(dropDwn);

		ArrayList originalList = new ArrayList();
		ArrayList tempList = new ArrayList();

		List<WebElement> options = select.getOptions();

		for (WebElement option : options) {
			originalList.add(option.getText());
			tempList.add(option.getText());
		}

		System.out.println("Before Testing...");
		System.out.println("Original List" + originalList);
		System.out.println("Temp List" + tempList);
		if (originalList.equals(tempList)) {
			System.out.println("List Box Sorted");
		} else {
			System.out.println("List Box is not Sorted");
		}
		driver.quit();
	}

}
