package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

public class TestListener implements ITestListener {
    private WebDriver driver;

    @Override
    public void onTestFailure(ITestResult result) {
        // Get driver instance from the test class
        Object testClass = result.getInstance();
        driver = ((BaseTest) testClass).getDriver();

        // Capture screenshot on failure
        ScreenshotUtility.captureScreenshot(driver, result.getName());
    }
}
