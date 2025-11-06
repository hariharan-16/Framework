package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.ExtentReporter;
import utilities.Utilities;

public class MyListener implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	String testName;
	
	@Override
	public void onStart(ITestContext context){
		try {
			report = ExtentReporter.extentReporter();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result){
		testName = result.getName();
		test = report.createTest(testName);
		test.info("Execution started.");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(testName+" execution passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			WebDriver driver = null;
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			String location = Utilities.getScreenshot(driver, testName);
			test.addScreenCaptureFromPath(location);
			test.info(result.getThrowable());
			test.fail(testName+" execution failed");
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.info(result.getThrowable());
		test.skip("Execution skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		test.info("Execution finished");
		report.flush();
	}
	
	
	
}
