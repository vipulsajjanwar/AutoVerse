package com.framework.report;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ChainTestListener implements ITestListener {

    private final List<ITestListener> listeners = new ArrayList<>();

    public ChainTestListener() {
        listeners.add(new ExtentReportListener());
        listeners.add(new AllureReportListener());
    }

    @Override
    public void onStart(ITestContext context) {
        listeners.forEach(l -> l.onStart(context));
    }

    @Override
    public void onFinish(ITestContext context) {
        listeners.forEach(l -> l.onFinish(context));
    }

    @Override
    public void onTestStart(ITestResult result) {
        listeners.forEach(l -> l.onTestStart(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        listeners.forEach(l -> l.onTestSuccess(result));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        listeners.forEach(l -> l.onTestFailure(result));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        listeners.forEach(l -> l.onTestSkipped(result));
    }

}
