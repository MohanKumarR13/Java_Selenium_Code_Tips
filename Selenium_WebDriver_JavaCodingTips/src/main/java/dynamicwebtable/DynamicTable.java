package dynamicwebtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DynamicTable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		
		driver.get("https://practice.expandtesting.com/dynamic-table");
		driver.manage().window().maximize();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		System.out.println("Number Of Rows :" + rows.size());
		for (int r = 1; r <= rows.size(); r++) {
			WebElement name = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + r + "]//td[1]"));
			if (name.getText().equals("Chrome")) {
				String cpuLoad = driver
						.findElement(By
								.xpath("//td[normalize-space()='Chrome']//following-sibling::*[contains(text(),'%')]"))
						.getText();
				String value = driver.findElement(By.xpath("//*[@id='chrome-cpu']")).getText();

				if (cpuLoad.contains(value)) {
					System.out.println("CPU Load Of Chrome is Equal");
				} else {
					System.out.println("CPU Load Of Chrome is Not Equal");

				}
				break;
			}
		}
	}
}
