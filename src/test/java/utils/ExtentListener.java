package utils;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import base.BaseTest;

public class ExtentListener extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getMethodName(), "Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().log(Status.PASS, "✅ " + result.getMethod().getMethodName() + " Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTestManager.getTest().log(Status.FAIL, "❌ " + result.getThrowable());
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            String screenshot = ts.getScreenshotAs(OutputType.BASE64);
            ExtentTestManager.getTest().addScreenCaptureFromBase64String(screenshot, "Failure Screenshot");
        } catch (Exception e) {
            ExtentTestManager.getTest().log(Status.WARNING, "⚠️ Could not capture screenshot");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentTestManager.endTest();
    }
}
