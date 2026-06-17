package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.AllureUtil;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println(
                "STARTED : "
                + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println(
                "PASSED : "
                + result.getName());
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        AllureUtil.attachScreenshot(
                ScreenshotUtil.captureForAllure());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println(
                "SKIPPED : "
                + result.getName());
    }
}