package practice1;

import org.testng.*;

public class CustomListener implements ITestListener {

    public CustomListener() {
        super();
    }

    public void onTestStart(ITestResult iTestResult) {
        System.out.println("CustomListener.onTestStart");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("CustomListener.onTestSuccess");
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("CustomListener.onTestFailure");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("CustomListener.onTestSkipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("CustomListener.onTestFailedButWithinSuccessPercentage");
    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("CustomListener.onStart");
    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("CustomListener.onFinish");
    }
}
