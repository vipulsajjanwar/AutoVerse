package com.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.framework.base.BaseClass;


public class PageUtil {

	protected static final Properties prop = new Properties();

	static final Logger log = Logger.getLogger(PageUtil.class);

	public static final String DIR_PATH=System.getProperty("user.dir");

	protected WebDriver driver;
	protected WebDriverWait wait;

	String locatorSeperator = "~~";

	private Actions actions;
	private JavascriptExecutor js;

	public PageUtil(WebDriver driver, long timeoutSec) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
		this.actions = new Actions(driver);
		this.js = (JavascriptExecutor) driver;
	}

	public WebDriverWait waitMethod() {
		return wait;
	}

	public static void beforesuite(String locatorsFolderPath) {


		File folder = new File(BaseClass.DIR_PATH+locatorsFolderPath);

		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				log.info("File " + listOfFiles[i].getName());

				Properties prop2 = new Properties();

				File src = new File(locatorsFolderPath + listOfFiles[i].getName());

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

	// ---------------------- Wait Helpers ----------------------

	public WebElement waitForVisibility(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public boolean waitForInvisibility(By locator) {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public WebElement waitForVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Common fallback wait (extra wait during latency)
	private WebElement fallbackWait(By locator, int seconds) {
		try {
			WebDriverWait fallbackWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			return fallbackWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			log.error("Fallback wait failed: " + locator + " | " + e.getMessage());
			return null;
		}
	}

	// ------------------------- isDisplayed() -------------------------
	public boolean isDisplayed(By locator) {
		try {
			WebElement element = waitForVisibility(locator);
			return element.isDisplayed();
		} catch (TimeoutException e) {
			log.warn("Primary wait timeout for: " + locator + " | Trying fallback...");

			WebElement fallback = fallbackWait(locator, 5);
			if (fallback != null) {
				try { return fallback.isDisplayed(); } 
				catch (Exception ex) {
					log.error("Fallback check failed for isDisplayed(): " + locator);
				}
			}
			return false;
		} catch (Exception e) {
			log.error("Unexpected error in isDisplayed(): " + e.getMessage());
			return false;
		}
	}

	// ------------------------- isEnabled() -------------------------
	public boolean isEnabled(By locator) {
		try {
			return waitForVisibility(locator).isEnabled();
		} catch (Exception e) {
			log.warn("isEnabled() failed for: " + locator + " | Trying fallback...");
			WebElement fallback = fallbackWait(locator, 5);

			if (fallback != null) {
				return fallback.isEnabled();
			}

			throw new NoSuchElementException("Failed in isEnabled() for locator: " + locator);
		}
	}

	// ------------------------- isSelected() -------------------------
	public boolean isSelected(By locator) {
		try {
			return waitForClickable(locator).isSelected();
		} catch (Exception e) {
			log.warn("isSelected() failed for: " + locator + " | Trying fallback...");
			WebElement fallback = fallbackWait(locator, 5);

			if (fallback != null) {
				return fallback.isSelected();
			}

			throw new NoSuchElementException("Failed in isSelected() for locator: " + locator);
		}
	}

	// ------------------------- click() -------------------------
	public void click(By locator) {
		try {
			waitForClickable(locator).click();
		} catch (Exception e) {
			log.warn("Click failed for: " + locator + " | Trying fallback...");

			WebElement fallback = fallbackWait(locator, 5);
			if (fallback != null) {
				try {
					fallback.click();
					return;
				} catch (Exception ignored) {}
			}

			throw new NoSuchElementException("Failed in click() for locator: " + locator);
		}
	}

	// ------------------------- getText() -------------------------
	public String getText(By locator) {
		try {
			return waitMethod().until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
		} catch (Exception e) {
			log.warn("getText() failed for: " + locator + " | Trying fallback...");

			WebElement fallback = fallbackWait(locator, 5);
			if (fallback != null) {
				return fallback.getText();
			}

			throw new NoSuchElementException("Failed in getText() for locator: " + locator);
		}
	}

	// ------------------------- clear() -------------------------
	public void clear(By locator) {
		try {
			waitForClickable(locator).clear();
		} catch (Exception e) {
			log.warn("clear() failed for: " + locator + " | Trying fallback...");

			WebElement fallback = fallbackWait(locator, 5);
			if (fallback != null) {
				fallback.clear();
				return;
			}

			throw new NoSuchElementException("Failed in clear() for locator: " + locator);
		}
	}

	// ------------------------- visible() -------------------------
	public void visible(By locator) {
		try {
			waitForVisibility(locator);
		} catch (Exception e) {
			log.warn("visible() failed for: " + locator + " | Trying fallback...");
			fallbackWait(locator, 5);  // no return required
		}
	}

	// ------------------------------
	// CLICK with fallback mechanism
	// ------------------------------
	public void clickWithFallback(By locator) {
		try {
			WebElement ele = waitForClickable(locator);
			ele.click(); // PRIMARY CLICK
		} catch (Exception e1) {
			try {
				// FALLBACK 1: Actions Click
				WebElement ele = waitForVisible(locator);
				actions.moveToElement(ele).click().perform();
			} catch (Exception e2) {
				// FALLBACK 2: JavaScript Click
				WebElement ele = driver.findElement(locator);
				js.executeScript("arguments[0].click();", ele);
			}
		}
	}

	// ------------------------------
	// SENDKEYS with fallback
	// ------------------------------
	public void sendKeys(By locator, String value) {
		try {
			WebElement ele = waitForVisible(locator);
			ele.clear();
			ele.sendKeys(value);   // PRIMARY SENDKEYS
		} catch (Exception e1) {
			try {
				// FALLBACK 1: Actions → sendKeys
				WebElement ele = waitForVisible(locator);
				actions.moveToElement(ele).click().sendKeys(value).perform();
			} catch (Exception e2) {
				// FALLBACK 2: JS set value
				WebElement ele = driver.findElement(locator);
				js.executeScript("arguments[0].value='" + value + "';", ele);
			}
		}
	}

	// ------------------------------
	// GET TEXT with fallback
	// ------------------------------
	public String getTextWithFallback(By locator) {
		try {
			return waitForVisible(locator).getText();   // PRIMARY TEXT
		} catch (Exception e1) {
			try {
				WebElement ele = driver.findElement(locator);
				return ele.getDomAttribute("innettext");   // FALLBACK 1
			} catch (Exception e2) {
				return js.executeScript("return arguments[0].textContent;",
						driver.findElement(locator)).toString();  // FALLBACK 2
			}
		}
	}

	// ------------------------------
	// SCROLL methods
	// ------------------------------
	public void scrollTo(By locator) {
		WebElement ele = driver.findElement(locator);
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	public void scrollToBottom() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	// ------------------------------
	// SELECT DROPDOWN by visible text with fallback
	// ------------------------------
	public void selectFromDropdown(By locator, String optionText) {
		try {
			WebElement ele = driver.findElement(locator);
			ele.click();
			WebElement option = driver.findElement(By.xpath("//li[normalize-space()='" + optionText + "']"));
			option.click(); // PRIMARY
		} catch (Exception e) {
			// FALLBACK → JS
			js.executeScript(
					"arguments[0].querySelector(\"option[value='" + optionText + "']\").selected=true;",
					driver.findElement(locator));
		}
	}

	// ------------------------------
	// SAFE CLEAR method
	// ------------------------------
	public void clearWithFallback(By locator) {
		try {
			driver.findElement(locator).clear(); // primary
		} catch (Exception e) {
			js.executeScript("arguments[0].value='';", driver.findElement(locator)); // fallback
		}
	}

	// ------------------------------
	// RETRY CLICK
	// ------------------------------
	public void retryClick(By locator, int attempts) {
		int count = 0;
		while (count < attempts) {
			try {
				click(locator);
				return;
			} catch (Exception e) {
				count++;
			}
		}
	}


}
