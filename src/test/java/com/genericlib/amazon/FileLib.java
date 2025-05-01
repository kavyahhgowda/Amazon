package com.genericlib.amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileLib {

	public String getDataFromProperties(String path, String key) {
		FileInputStream ip = null;
		try {
			ip = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

	public String getDataFromExcel(String path, String sheet, int row, int cell) {
		FileInputStream ip = null;
		try {
			ip = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Workbook wb = null;

		try {
			wb = WorkbookFactory.create(ip);
		} catch (EncryptedDocumentException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		Sheet sh = wb.getSheet(sheet);
		return sh.getRow(row).getCell(cell).toString();
	}

	// public static void main(String[] args) throws IOException,
	// InterruptedException {
	// WebDriver driver = new ChromeDriver();
	// driver.manage().window().maximize();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	// FileInputStream ip = new FileInputStream("Test Data/testdata.properties");
	// Properties prop = new Properties();
	// prop.load(ip);
	// String un = prop.getProperty("username");
	// driver.get(prop.getProperty("URL"));
	// driver.findElement(By.id("login2")).click();
	// driver.findElement(By.id("loginusername")).sendKeys(prop.getProperty("username"));
	// driver.findElement(By.id("loginpassword")).sendKeys(prop.getProperty("password"));
	// driver.findElement(By.xpath("//button[text()='Log in']")).click();
	// try {
	// Thread.sleep(2000);

	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// TODO: handle exception
	// }
	// System.out.println("going to logout");
}