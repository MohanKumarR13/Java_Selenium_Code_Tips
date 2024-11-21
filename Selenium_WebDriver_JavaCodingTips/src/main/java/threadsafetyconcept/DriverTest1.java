package threadsafetyconcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverTest1 {
	private static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();
	WebDriver driver;

	public void setDriver(WebDriver driver) {
		tDriver.set(driver);
	}

	public WebDriver getDriver() {
		return tDriver.get();
	}

	@Test
	void myTest1() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		setDriver(driver);
		getDriver().get("https://www.google.com");
		System.out.println(getDriver().getTitle());
		getDriver();
		driver.quit();
	}

	@Test
	void myTest2() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		setDriver(driver);
		getDriver().get("https://www.bing.com");
		System.out.println(getDriver().getTitle());
		getDriver();
		driver.quit();
	}
}
