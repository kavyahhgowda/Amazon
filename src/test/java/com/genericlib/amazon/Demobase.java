package com.genericlib.amazon;

import org.testng.annotations.BeforeSuite;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class Demobase {

	public static WebDriver driver;

	@BeforeTest
	public void configBT() {

		driver = new ChromeDriver();
	}

	@AfterTest
	public void configAT() {

		driver.quit();

	}
}
/*
 * public static WebDriver driver; public GenericMethods gm = new
 * GenericMethods(); public String propPath = "Test Data\\testdata.properties";
 * 
 * // new WebDriverWait(driver, Duration.ofSeconds(10));
 * 
 * @BeforeSuite public void configBS() {
 * System.out.println("from before suite"); }
 * 
 * // @Parameters("browserName") // public void configBT(String bn ) //
 * if(bn.equals("chrome"))
 * 
 * @BeforeTest public void configBT() { System.out.println("from before test");
 * driver = new ChromeDriver(); driver.manage().window().maximize();
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); String url
 * = gm.getDataFromProperties(propPath, "URL"); driver.get(url); }
 * 
 * @BeforeClass public void configBC() {
 * System.out.println("from before Class"); }
 * 
 * @BeforeMethod public void configBM() { WebDriverWait wait = new
 * WebDriverWait(driver, Duration.ofSeconds(10));
 * System.out.println("from before method");
 * driver.findElement(By.id("login2")).click();
 * 
 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO: handle
 * exception e.printStackTrace(); }
 * wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(
 * "loginusername"))));
 * driver.findElement(By.id("loginusername")).sendKeys(gm.getDataFromProperties(
 * propPath, "username"));
 * driver.findElement(By.id("loginpassword")).sendKeys(gm.getDataFromProperties(
 * propPath, "password"));
 * driver.findElement(By.xpath("//button[text()='Log in']")).click(); try {
 * Thread.sleep(3000); } catch (InterruptedException e) { // TODO: handle
 * exception e.printStackTrace(); }
 * 
 * WebElement loggedinuser = driver.findElement(By.id("nameofuser")); //
 * wait.until(ExpectedConditions.textToBePresentInElement(loggedinuser,"Welcome
 * // QA Test")); String un = loggedinuser.getText(); System.out.println(un);
 * Assert.assertTrue(un.contains(gm.getDataFromProperties(propPath,
 * "username")));
 * 
 * try { Thread.sleep(2000);
 * 
 * } catch (InterruptedException e) { e.printStackTrace(); } }
 * 
 * @AfterMethod public void configAM() { System.out.println("from after mthod");
 * driver.findElement(By.id("logout2")).click(); }
 * 
 * @AfterClass public void configAC() { System.out.println("from after CLASS");
 * 
 * }
 * 
 * @AfterTest public void configAT() { System.out.println("from after test");
 * driver.quit(); }
 * 
 * @AfterSuite public void configAS() { System.out.println("from after suite");
 * } }
 */