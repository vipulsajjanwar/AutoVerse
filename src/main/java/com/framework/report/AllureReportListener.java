package com.framework.report;

import java.nio.charset.StandardCharsets;

import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class AllureReportListener implements ITestListener {

    @Attachment(value = "Log", type = "text/plain")
    public byte[] saveTextLog(String message) {
        return message.getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] attachScreenshot(byte[] screenshotBytes) {
        return screenshotBytes;
    }

    @Override
    public void onTestStart(ITestResult result) {
        Allure.step("Starting test: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        saveTextLog("Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveTextLog("Test Failed: " + result.getThrowable().getMessage());

        // attachScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        saveTextLog("Test Skipped");
    }

}
