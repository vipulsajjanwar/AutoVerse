package com.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class PageUtil {

	protected static final Properties prop = new Properties();

	static final Logger log = Logger.getLogger(PageUtil.class);

	public static final String DIR_PATH=System.getProperty("user.dir");

	protected WebDriver driver;
	protected WebDriverWait wait;

	String locatorSeperator = "~~";

	private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

	public PageUtil(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
		this.wait.ignoring(NoSuchElementException.class)
		.ignoring(StaleElementReferenceException.class)
		.ignoring(ElementClickInterceptedException.class);
	}

	public WebDriverWait waitMethod() {
		return wait;
	}

	public static void beforesuite() {

		File folder = new File(DIR_PATH + "/src/main/resources/locators/");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				log.info("File " + listOfFiles[i].getName());

				Properties prop2 = new Properties();

				File src = new File(DIR_PATH + "/src/main/resources/locators/" + listOfFiles[i].getName());

				try (FileInputStream fis = new FileInputStream(src);){

					prop2.load(fis);

					prop.putAll(prop2);
				} catch (Exception e) {
					log.info("Exception is " + e.getMessage());

				}

			} else if (listOfFiles[i].isDirectory()) {
				log.info("Directory " + listOfFiles[i].getName());
			}
		}

	}

	public String readConfig(String key) {
		return prop.getProperty(key);
	}

	public By getElementLocator(String locator) {

		try {
			
			if (locator == null || !locator.contains(locatorSeperator)) {
				log.error("Invalid locator format: " + locator);
				return null;
			}

			String[] parts = locator.split(locatorSeperator, 2);

			String type = parts[0].trim().toLowerCase();
			String value = parts[1].trim();

			switch (type) {
			case "xpath":           return By.xpath(value);
			case "id":              return By.id(value);
			case "css":             return By.cssSelector(value);
			case "name":            return By.name(value);
			case "classname":       return By.className(value);
			case "linktext":        return By.linkText(value);
			case "partiallinktext": return By.partialLinkText(value);
			case "tagname":         return By.tagName(value);
			default:
				log.warn("Unknown locator type '" + type + "'. Defaulting to XPath.");
				return By.xpath(value);
			}

		} catch (Exception e) {
			log.error("Error while parsing locator: " + locator + " - " + e.getMessage(), e);
			return null;
		}
	}

	public boolean isNotDisplayed(WebDriver driver, By locator, int waitTime) {
		boolean flag = false;
		long endTime = 0;
		try {
			endTime = System.currentTimeMillis() + (waitTime * 1000);

			while (System.currentTimeMillis() < endTime) {

				if (!driver.findElement(locator).isDisplayed()) {
					flag = true;
					break;
				}
			}

			if(System.currentTimeMillis() > endTime && driver.findElement(locator).isDisplayed()) {
				log.error("Unexpected webelement still visible on page kindly check"+locator);
			}

		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return flag;
	}

	public boolean isDisplayed(By locator) {
		try {

			WebElement element = waitMethod().until(ExpectedConditions.visibilityOfElementLocated(locator));
			return element.isDisplayed(); 
		} catch (TimeoutException e) {

			log.error("Element not visible within timeout: " + locator);

			try {

				isNotDisplayed(driver, getElementLocator(prop.getProperty("")), 60);

				return driver.findElement(locator).isDisplayed(); // Fallback
			} catch (Exception ex) {
				log.error("Element not found during fallback check: " + locator);
				return false;
			}
		} catch (Exception e) {
			log.error("Unexpected error: " + e.getMessage());
			return false;
		}
	}

	public boolean isEnabled(By locator) {

		try {

			return  waitMethod().until(ExpectedConditions.visibilityOfElementLocated(locator)).isEnabled();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in isEnabled() for locator" + locator);
		}
	}

	public boolean isSelected(By locator) {

		try {

			return  waitMethod().until(ExpectedConditions.elementToBeClickable(locator)).isSelected();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in isSelected() for locator" + locator);
		}
	}

	public void click(By locator) {

		try {

			waitMethod().until(ExpectedConditions.elementToBeClickable(locator)).click();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in click() for locator " + locator);
		}
	}

	public String getText(By locator) {

		try {
			String resulttring = null;

			resulttring =  waitMethod().until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
			return resulttring;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in getText() for locator " + locator);
		}

	}

	public void clear(By locator) {

		try {

			waitMethod().until(ExpectedConditions.elementToBeClickable(locator)).clear();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in clear() for locator " + locator);
		}
	}

	public void visible(By locator) {

		try {

			waitMethod().until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

}
