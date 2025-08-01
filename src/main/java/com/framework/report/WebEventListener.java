package com.framework.report;

import org.openqa.selenium.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

public class WebEventListener implements WebDriverListener {

    private static final Logger log = LoggerFactory.getLogger(WebEventListener.class);

    private String describeElement(WebElement element) {
        try {
            return element != null ? element.toString() : "null";
        } catch (StaleElementReferenceException e) {
            return "stale element";
        }
    }

    // Navigation
    @Override
    public void beforeGet(WebDriver driver, String url) {
        log.info("Navigating to URL: {}", url);
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
        log.info("Navigated to URL: {}", url);
    }

    public void beforeNavigateBack(WebDriver.Navigation navigation) {
        log.info("Navigating back");
    }


    public void afterNavigateBack(WebDriver.Navigation navigation) {
        log.info("Navigated back");
    }

  
    public void beforeNavigateForward(WebDriver.Navigation navigation) {
        log.info("Navigating forward");
    }

 
    public void afterNavigateForward(WebDriver.Navigation navigation) {
        log.info("Navigated forward");
    }

    @Override
    public void beforeRefresh(WebDriver.Navigation navigation) {
        log.info("Refreshing the page");
    }

    @Override
    public void afterRefresh(WebDriver.Navigation navigation) {
        log.info("Page refreshed");
    }

    // Click / Input / Interaction
    @Override
    public void beforeClick(WebElement element) {
        log.info("Clicking on element: {}", describeElement(element));
    }

    @Override
    public void afterClick(WebElement element) {
        log.info("Clicked on element: {}", describeElement(element));
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        log.info("Typing '{}' into element: {}", String.valueOf(keysToSend), describeElement(element));
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        log.info("Typed '{}' into element: {}", String.valueOf(keysToSend), describeElement(element));
    }

    @Override
    public void beforeClear(WebElement element) {
        log.info("Clearing element: {}", describeElement(element));
    }

    @Override
    public void afterClear(WebElement element) {
        log.info("Cleared element: {}", describeElement(element));
    }

    @Override
    public void beforeSubmit(WebElement element) {
        log.info("Submitting form using element: {}", describeElement(element));
    }

    @Override
    public void afterSubmit(WebElement element) {
        log.info("Form submitted using element: {}", describeElement(element));
    }

    // Finding elements
    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        log.info("Finding element by: {}", locator);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        log.info("Found element by: {}", locator);
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        log.info("Finding elements by: {}", locator);
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        log.info("Found {} elements by: {}", result.size(), locator);
    }

    @Override
    public void beforeFindElement(WebElement element, By locator) {
        log.info("Finding child element by: {} from {}", locator, describeElement(element));
    }

    @Override
    public void afterFindElement(WebElement element, By locator, WebElement result) {
        log.info("Found child element by: {} from {}", locator, describeElement(element));
    }

    @Override
    public void beforeFindElements(WebElement element, By locator) {
        log.info("Finding child elements by: {} from {}", locator, describeElement(element));
    }

    @Override
    public void afterFindElements(WebElement element, By locator, List<WebElement> result) {
        log.info("Found {} child elements by: {} from {}", result.size(), locator, describeElement(element));
    }

    // Alerts
    @Override
    public void beforeAccept(Alert alert) {
        log.info("Accepting alert");
    }

    @Override
    public void afterAccept(Alert alert) {
        log.info("Alert accepted");
    }

    @Override
    public void beforeDismiss(Alert alert) {
        log.info("Dismissing alert");
    }

    @Override
    public void afterDismiss(Alert alert) {
        log.info("Alert dismissed");
    }

    @Override
    public void beforeSendKeys(Alert alert, String keysToSend) {
        log.info("Sending keys '{}' to alert", keysToSend);
    }

    @Override
    public void afterSendKeys(Alert alert, String keysToSend) {
        log.info("Sent keys '{}' to alert", keysToSend);
    }

    // Screenshot
  
    public <T> void beforeGetScreenshotAs(OutputType<T> outputType) {
        log.info("Taking screenshot: {}", outputType.toString());
    }


    public <T> void afterGetScreenshotAs(OutputType<T> outputType, T screenshot) {
        log.info("Screenshot taken: {}", outputType.toString());
    }

    // Script execution
 
    public void beforeExecuteScript(JavascriptExecutor js, String script, Object[] args) {
        log.info("Executing script: {}", script);
    }


    public void afterExecuteScript(JavascriptExecutor js, String script, Object[] args, Object result) {
        log.info("Script executed: {}", script);
    }

    // Switching
 
    public void beforeSwitchToWindow(WebDriver driver, String nameOrHandle) {
        log.info("Switching to window: {}", nameOrHandle);
    }


    public void afterSwitchToWindow(WebDriver driver, String nameOrHandle) {
        log.info("Switched to window: {}", nameOrHandle);
    }


    public void beforeSwitchToFrame(WebDriver driver, int index) {
        log.info("Switching to frame by index: {}", index);
    }

  
    public void afterSwitchToFrame(WebDriver driver, int index) {
        log.info("Switched to frame by index: {}", index);
    }


    public void beforeSwitchToFrame(WebDriver driver, String nameOrId) {
        log.info("Switching to frame by name/id: {}", nameOrId);
    }

    
    public void afterSwitchToFrame(WebDriver driver, String nameOrId) {
        log.info("Switched to frame by name/id: {}", nameOrId);
    }


    public void beforeSwitchToFrame(WebDriver driver, WebElement frameElement) {
        log.info("Switching to frame element: {}", describeElement(frameElement));
    }


    public void afterSwitchToFrame(WebDriver driver, WebElement frameElement) {
        log.info("Switched to frame element: {}", describeElement(frameElement));
    }

 
    public void beforeSwitchToDefaultContent(WebDriver driver) {
        log.info("Switching to default content");
    }

 
    public void afterSwitchToDefaultContent(WebDriver driver) {
        log.info("Switched to default content");
    }

    // Cookies
    @Override
    public void beforeAddCookie(WebDriver.Options options, Cookie cookie) {
        log.info("Adding cookie: {}", cookie);
    }

    @Override
    public void afterAddCookie(WebDriver.Options options, Cookie cookie) {
        log.info("Added cookie: {}", cookie);
    }

    @Override
    public void beforeDeleteCookieNamed(WebDriver.Options options, String name) {
        log.info("Deleting cookie by name: {}", name);
    }

    @Override
    public void afterDeleteCookieNamed(WebDriver.Options options, String name) {
        log.info("Deleted cookie by name: {}", name);
    }

    @Override
    public void beforeDeleteCookie(WebDriver.Options options, Cookie cookie) {
        log.info("Deleting cookie: {}", cookie);
    }

    @Override
    public void afterDeleteCookie(WebDriver.Options options, Cookie cookie) {
        log.info("Deleted cookie: {}", cookie);
    }

    @Override
    public void beforeDeleteAllCookies(WebDriver.Options options) {
        log.info("Deleting all cookies");
    }

    @Override
    public void afterDeleteAllCookies(WebDriver.Options options) {
        log.info("Deleted all cookies");
    }

    @Override
    public void beforeGetCookies(WebDriver.Options options) {
        log.info("Getting all cookies");
    }

    @Override
    public void afterGetCookies(WebDriver.Options options, Set<Cookie> cookies) {
        log.info("Retrieved {} cookies", cookies.size());
    }

    @Override
    public void beforeGetCookieNamed(WebDriver.Options options, String name) {
        log.info("Getting cookie by name: {}", name);
    }

    @Override
    public void afterGetCookieNamed(WebDriver.Options options, String name, Cookie cookie) {
        log.info("Retrieved cookie: {}", cookie);
    }

    // Title, URL, Window Handle
    @Override
    public void beforeGetTitle(WebDriver driver) {
        log.info("Getting page title");
    }

    @Override
    public void afterGetTitle(WebDriver driver, String result) {
        log.info("Page title is: {}", result);
    }

    @Override
    public void beforeGetCurrentUrl(WebDriver driver) {
        log.info("Getting current URL");
    }

    @Override
    public void afterGetCurrentUrl(WebDriver driver, String result) {
        log.info("Current URL is: {}", result);
    }

    @Override
    public void beforeGetWindowHandle(WebDriver driver) {
        log.info("Getting current window handle");
    }

    @Override
    public void afterGetWindowHandle(WebDriver driver, String result) {
        log.info("Current window handle is: {}", result);
    }

    // Error Handling
    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        log.error("Exception in method '{}': {}", method.getName(), e.getTargetException().getMessage(), e);
    }
}
