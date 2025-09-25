package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    public static ExtentTest getTest() {
        return testThread.get();
    }

    public static void startTest(String testName, String description) {
        ExtentTest test = extent.createTest(testName, description);
        testThread.set(test);
    }

    public static void endTest() {
        extent.flush();
    }
}
