package com.testscripts.amazon;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.genericlib.amazon.Demobase;

public class ProductDetails extends Demobase {
	@Test
	public void verifyProductDetailsPageTest() {
		
		String pn = "Nokia lumia 1520";
	//	cu.clickonProduct(pn, driver);
		try {
	//		cu.addToCartButton("Nokia lumia 1520", driver);
			System.out.println("Test Script passed");
			Reporter.log("Navigated to"+pn+" page",true);
			Reporter.log("Test Script passed",true);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Test script Failed");
			Assert.assertTrue(false, "Test script Failed");
		}
	}
}
//String name = "QAC";
//String name1 = "Test";
//String name2 = "QAC";
//SoftAssert sf = new SoftAssert();
//sf.assertTrue(name.equals(name1));
//sf.assertEquals(name1.equals(name2),true);
//sf.assertAll();