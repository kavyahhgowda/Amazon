package com.listeners.amazon;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.genericlib.amazon.Base;
import com.genericlib.amazon.Demobase;

public class EventList implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {

		TakesScreenshot ss = (TakesScreenshot) Base.driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		long time = System.currentTimeMillis();
		File dest = new File("Screenshots/" + time + ".png");
		
		String path=dest.getAbsolutePath();
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Base.test.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
	}
	
	public void onTestStart(ITestResult result) {
		Base.test = Base.extent.createTest(result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		Base.test.pass("Test passes");
	}

	
	public void onTestSkipped(ITestResult result) {
		Base.test.fail("skipped");

	}


	public void onStart(ITestContext context) {

	}

	
	public void onFinish(ITestContext context) {
		Base.extent.flush();
	}
}