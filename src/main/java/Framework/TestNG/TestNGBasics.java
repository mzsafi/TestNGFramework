package Framework.TestNG;

import org.testng.annotations.*;

public class TestNGBasics {

	@BeforeSuite
	public void testsuite() {
		System.out.println("1 . BeforeSuite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("2 . BeforeTest");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("3 . BeforeClass");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("4 . BeforeMethod");
	}

	//**************************************************
	
	@Test
	public void testCase() {
		System.out.println("# . Test 1");
	}
	
	@Test
	public void testCase2() {
		System.out.println("# . Test 2");
	}
	
	//**************************************************
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("4 . AfterMethod");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("3 . AfterClass");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("2 . AfterTest");
	}
	@AfterSuite
	public void aftersuite() {
		System.out.println("1 . AfterSuite");
	}
}
