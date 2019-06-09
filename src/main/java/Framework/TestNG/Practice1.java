package Framework.TestNG;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Practice1 {

//goto to app>> shopping card and verify if "Continue" button is displayed
	// I want to login to the app in 4 different test cases,
	// 1 with correct user and pass
	// 2 with incorrect user and correct pass
	// 3 with correct user and incorrect pass
	// 4 with incorrect user and pass

	static WebDriver driver;

	public static void testLogIn(String username, String password) {
		driver.get("https://www.tekschoolofamerica.com/test-environment/");
		driver.findElement(By.xpath("//span[text() ='My Account']")).click();
		driver.findElement(By.xpath("//a[text() ='Login']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();

	}

	@BeforeMethod
	public void setEnviroment() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void shoppingCartTest() {
		driver.get("https://www.tekschoolofamerica.com/test-environment/");
		driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();
		boolean continueExist = driver.findElement(By.xpath("//a[text()='Continue']")).isDisplayed();
		Assert.assertEquals(continueExist, true);
	}

	@Test(priority = 2)
	public void loginScenario1() {
		testLogIn("test001@test.com", "test001");
		String loginPage = driver.getTitle();
		Assert.assertEquals(loginPage, "My Account");
	}

	@Test(priority = 3)
	public void loginScenario2() {
		testLogIn("asdf", "test001");
		boolean errormessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.isDisplayed();
		Assert.assertTrue(errormessage);
	}

	@Test(priority = 4)
	public void loginScenario3() {
		testLogIn("test001@test.com", "tasdfsaf");
		boolean errormessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.isDisplayed();
		Assert.assertTrue(errormessage);
	}

	@Test(priority = 5)
	public void loginScenario4() {
		testLogIn("asdfdsaf", "asdfdf");
		boolean errormessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.isDisplayed();
		Assert.assertTrue(errormessage);
	}

	@AfterMethod
	public void closeTheEnviroment() {
		driver.close();
		driver.quit();
	}

}