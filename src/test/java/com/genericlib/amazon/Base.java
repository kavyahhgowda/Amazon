package com.genericlib.amazon;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base {

	public static WebDriver driver;
	public FileLib f1 = new FileLib();
	public CommonUtils cu = new CommonUtils();
	public String propPath = "Test Data\\testdata.properties";
    public static ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark=new ExtentSparkReporter("test-output/Extent.html");
    public static ExtentTest test;

	// @Parameters("browserName") // public void configBT(String bn ) //
	// if(bn.equals("chrome"))

	@BeforeTest
	public void configBT() {
		extent.attachReporter(spark);
		System.out.println("from before test");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String url = f1.getDataFromProperties(propPath, "URL");
		driver.get(url);
	}

	@BeforeMethod
	public void configBM() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		System.out.println("from before method");
		driver.findElement(By.id("login2")).click();

		try{
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			// TODO: handle exception

			e2.printStackTrace();
		}

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("loginusername"))));
		driver.findElement(By.id("loginusername")).sendKeys(f1.getDataFromProperties(propPath, "username"));
		driver.findElement(By.id("loginpassword")).sendKeys(f1.getDataFromProperties(propPath, "password"));
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
System.out.println("hi we are adding");
		try {
			Thread.sleep(3000);
		} catch (Exception e1) {
			// TODO: handle exception

			e1.printStackTrace();
		}

		WebElement loggedinuser = driver.findElement(By.id("nameofuser"));
		//
		// wait.until(ExpectedConditions.textToBePresentInElement(loggedinuser,"Welcom
		// QA Test"));
		String un = loggedinuser.getText();
		System.out.println(un);
		Assert.assertTrue(un.contains(f1.getDataFromProperties(propPath, "username")));

		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void configAM() {
		System.out.println("from after mthod");
		driver.findElement(By.id("logout2")).click();
		try {
			driver.findElement(By.id("login2"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("not logged out");
			// TODO: handle exception
		}
		// TODO: handle exception
	}

	@AfterTest
	public void configAT() {
		System.out.println("from after test");
		driver.quit();
		
	}
}