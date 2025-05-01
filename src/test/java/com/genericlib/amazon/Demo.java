package com.genericlib.amazon;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.listeners.amazon.EventList;
@Listeners(EventList.class)
public class Demo extends Base {
	@Test 
	public void demoTest() {
	 // test=extent.createTest("Demo");
		test.pass("Executed Demo");
		test.skip("skip");
		test.warning("warning");
		test.fail("fail");
		test.info("info");
	}
}