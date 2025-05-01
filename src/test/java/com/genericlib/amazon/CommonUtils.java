package com.genericlib.amazon;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonUtils 
{

	public void clickonProduct(String productName, WebDriver driver)
	{
		for (int i = 0; i < 5; i++) 
		{

			try
			{
				driver.findElement(By.xpath("//a[text()='" + productName + "']")).click();
				break;
			} 
			catch (StaleElementReferenceException e)
			{
				e.printStackTrace();
			}
		}
	}	
	
	public WebElement addToCartButton(String productName, WebDriver driver) {
		return driver.findElement(By.xpath("//h2[text()='" + productName + "']/following-sibling::div/descendant::a"));

	}

	public void captureScreenshot(WebDriver driver) {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		long currentTime = System.currentTimeMillis();
		File dest = new File("Screenshots/"+currentTime+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		
		}
		}
}