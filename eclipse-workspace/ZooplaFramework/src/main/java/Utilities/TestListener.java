package Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

public class TestListener extends TestBase implements ITestListener {

	public synchronized void onStart(ITestContext context) {
		System.out.println("Test Suite started!");
	}

	public synchronized void onFinish(ITestContext context) {
		System.out.println(("Test Suite is ending!"));
		reports.flush();
	}

	public synchronized void onTestStart(ITestResult result) {
		logger = reports.startTest(result.getMethod().getMethodName());
		System.out.println("onTestStart called");
		System.out.println(result.getMethod().getMethodName() + " started");
		logger.log(LogStatus.INFO, result.getMethod().getMethodName() + "started");
		System.out.println("Logger initialized");
	}

	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess called");
		logger.log(LogStatus.PASS, result.getMethod().getMethodName() + " Passes");

		try {
			logger.log(LogStatus.PASS, result.getMethod().getMethodName() + logger.addScreenCapture(takeScreenshot()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Add screenshots
		reports.endTest(logger);
	}

	public synchronized void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure called");
		logger.log(LogStatus.FAIL, result.getMethod().getMethodName() + " Failed");
		// Add screenshots
		try {
			logger.log(LogStatus.FAIL, result.getMethod().getMethodName() + logger.addScreenCapture(takeScreenshot()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		reports.endTest(logger);
	}

	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped called");
		reports.endTest(logger);
	}
}