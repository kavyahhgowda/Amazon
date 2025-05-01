package com.testscripts.amazon;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlib.amazon.Base;
import com.genericlib.amazon.Demobase;
import com.listeners.amazon.EventList;
import com.objectrepository.amazon.Homepage;

@Listeners(EventList.class)
public class AddToCart extends Base {

	@Test
	public void addToCartTest() {

	//	test = extent.createTest("Add product to the cart");
		Homepage hp = PageFactory.initElements(driver, Homepage.class);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		cu.clickonProduct("Nokia lumia 1520", driver);
		test.pass("Clicked on the product");
		try {
			cu.addToCartButton("Nokia lumia 1520", driver);
			System.out.println("Test Script passed");
		} 
		catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Test script Failed");
			test.fail("Test script Failed");
		}
		cu.addToCartButton("Nokia lumia 1520", driver).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alt = driver.switchTo().alert();
		alt.accept();
		test.pass("Handled Alert");
		test.pass("Added to cart");
		Assert.fail();
//		cu.captureScreenshot(driver);
		hp.getCartLinKtext().click();

		try {
			Thread.sleep(3000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}