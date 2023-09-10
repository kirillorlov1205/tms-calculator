package support;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println(String.format("===========Start test: '%s'", iTestResult.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println(String.format("===========Test passed: '%s'", iTestResult.getMethod().getMethodName()));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println(String.format("---------Test failed: '%s'", iTestResult.getMethod().getMethodName()));
    }
}
