package parallelexcecutionwithdataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	@Test(dataProvider = "readData")
	public static void launchTest(String email, String pwd) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Log in']")).click();
		Thread.sleep(5000); 
		boolean loginStatus;
		try {
			loginStatus = driver.findElement(By.xpath("//*[text()='Log out']")).isDisplayed();
			Assert.assertTrue(loginStatus);

		} catch (Exception e) {
			loginStatus = false;
			Assert.assertTrue(loginStatus);
		} finally {
			driver.quit();
		}

	}

	@DataProvider(parallel = true, indices = { 0, 1 })
	public static Object[][] readData() {
		String[][] data = { { "laura.taylor1234@example.com", "test123" }, { "john.deol1234@example.com", "test123" } };
		return data;

	}
}
