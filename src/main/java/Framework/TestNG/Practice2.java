package Framework.TestNG;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Practice2 {

	// go to laptop page, add 3 items to the card and verify that they are added to
	// the cart
	// make sure you use 3 methods for this,
	// find a way so that aftermethod does not close after each
	WebDriver driver;

	@BeforeClass
	public void setEnviroment() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void hpLaptop() {
		boolean item = itemCheck(driver, "HP LP3065");

		Assert.assertTrue(item);
	}

	// remove the cart
	@Test(priority = 2)
	public void macBook() {
		boolean item = itemCheck(driver, "MacBook");

		Assert.assertTrue(item);
	}

	@AfterClass
	public void closeTheEnviroment() {
		driver.close();
		driver.quit();
	}

	// the static method
	public static boolean itemCheck(WebDriver d, String itemName) {
		d.get("https://www.tekschoolofamerica.com/test-environment/");
		d.findElement(By.xpath("//a[text() = 'Laptops & Notebooks']")).click();
		d.findElement(By.xpath("//a[text() = 'Show All Laptops & Notebooks']")).click();
		d.findElement(By.xpath("//a[text() = '" + itemName + "']")).click();
		d.findElement(By.xpath("//button[@id = 'button-cart']")).click();
		// item added to the cart

		d.findElement(By.xpath("//span[text() = 'Shopping Cart']")).click();
		boolean result = d.findElement(By.xpath("//a[text() = '" + itemName + "']")).isDisplayed();

		return result;
	}

	}

//This is the code that Hasib did and it's the same as above code.
/*	String item1 = "HP LP3065";
	String item2 = "MacBook";
	String item3 = "Sony VAIO";

	static WebDriver driver;

	@BeforeClass
	public void setEnviroment() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	public static void goToLaptopsAndDesks() {
		driver.get("https://www.tekschoolofamerica.com/test-environment/");
		driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']")).click();
		driver.findElement(By.xpath("//a[text()='Show All Laptops & Notebooks']")).click();
		// button[descendant::span[text()='Add to Cart']]
	}

	public static void addItemtoCart(String itemName) {
		String xpath = "//a[text()='" + itemName + "']";
		driver.findElement(By.xpath(xpath)).click();
		driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
		boolean messageAppear = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"))
				.isDisplayed();
		Assert.assertTrue(messageAppear);
	}

	public static void verifyItemAdded(String itemName) {
		driver.findElement(By.xpath("//a[@title='Shopping Cart']")).sendKeys(Keys.ENTER);
		String xpath = "//a[text()='" + itemName + "']";
		boolean itemExist = driver.findElement(By.xpath(xpath)).isDisplayed();
		Assert.assertTrue(itemExist);
	}

	@Test
	public void addFirstItem() {
		goToLaptopsAndDesks();
		addItemtoCart(item1);
		verifyItemAdded(item1);
	}

	@Test
	public void addSecondItem() {
		goToLaptopsAndDesks();
		addItemtoCart(item2);
		verifyItemAdded(item2);
	}

	@Test
	public void addThirdItem() {
		goToLaptopsAndDesks();
		addItemtoCart(item3);
		verifyItemAdded(item3);
	}

@AfterClass
public void closeTheEnviroment() {
	driver.close();
	driver.quit();
}
}*/