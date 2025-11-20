package com.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;


import com.framework.base.BaseClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageUtil {

	protected static final Properties prop = new Properties();

	public static final Logger log = LogManager.getLogger(PageUtil.class);

	public static final String DIR_PATH=System.getProperty("user.dir");
	protected WebDriverWait wait;

	String locatorSeperator = "~~";

	private Actions actions;
	private JavascriptExecutor js;

	public WebDriverWait waitMethod(WebDriver driver, int seconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(ElementClickInterceptedException.class);
		// Wait for the page to load completely
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));
		
		return wait;
	}

	public static void beforesuite(String locatorsFolderPath) {

		
		File folder = new File(locatorsFolderPath);

		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			
			if (listOfFiles[i].isFile()) {
				log.info("File " + listOfFiles[i].getName());

				Properties prop2 = new Properties();
				
				locatorsFolderPath=locatorsFolderPath.endsWith("/") ? locatorsFolderPath: locatorsFolderPath+"/" ;

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
	        BaseClass.reportLog("Checking invisibility for locator: " + locator);

	        endTime = System.currentTimeMillis() + (waitTime * 1000);

	        while (System.currentTimeMillis() < endTime) {
	        	 try {
	                 WebElement ele = driver.findElement(locator);

	                 if (!ele.isDisplayed()) {
	                     BaseClass.reportLog("Element is NOT displayed: " + locator);
	                     return true;
	                 }

	             } catch (NoSuchElementException | StaleElementReferenceException e) {
	                 // If element is NOT in DOM → it is NOT visible → return TRUE
	                 BaseClass.reportLog("Element NOT found in DOM → treated as NOT displayed: " + locator);
	                 return true;
	             }
	        }

	        if (System.currentTimeMillis() > endTime && driver.findElement(locator).isDisplayed()) {
	            String msg = "Unexpected: Element still visible after wait: " + locator;
	            log.error(msg);
	            BaseClass.reportFailLog(msg, "isNotDisplayed");
	        }

	    } catch (Exception e) {
	        log.error(e.getMessage());
	        BaseClass.reportErrorLog("Exception in isNotDisplayed(): " + e.getMessage());
	    }

	    return flag;
	}


	// ---------------------- Wait Helpers ----------------------

	public WebElement waitForVisibility(WebDriver driver, By locator) {
	    try {
	        BaseClass.reportLog("Waiting for visibility: " + locator);
	        return waitMethod(driver, 3).until(ExpectedConditions.presenceOfElementLocated(locator));
	    } catch (Exception e) {
	        BaseClass.reportErrorLog("waitForVisibility failed: " + locator + " | " + e.getMessage());
	        throw e;
	    }
	}


	public WebElement waitForClickable(WebDriver driver, By locator) {
	    try {
	        BaseClass.reportLog("Waiting for clickable: " + locator);
	        return waitMethod(driver, 3).until(ExpectedConditions.elementToBeClickable(locator));
	    } catch (Exception e) {
	        BaseClass.reportErrorLog("waitForClickable failed: " + locator + " | " + e.getMessage());
	        throw e;
	    }
	}


	public boolean waitForInvisibility(WebDriver driver, By locator) {
		return waitMethod(driver, 3).until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	private WebElement fallbackWait(WebDriver driver, By locator, int seconds) {
	    try {
	        BaseClass.reportLog("Trying fallback wait for locator: " + locator);
	        WebDriverWait fallbackWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	        return fallbackWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	    } catch (Exception e) {
	        String msg = "Fallback wait failed for: " + locator + " | " + e.getMessage();
	        log.error(msg);
	        BaseClass.reportErrorLog(msg);
	        return null;
	    }
	}


	// ------------------------- isDisplayed() -------------------------
	public boolean isDisplayed(WebDriver driver, By locator, String label) {
	    try {
	        BaseClass.reportLog("Checking display status: " + locator);
	        WebElement element = waitForVisibility(driver, locator);
	        return element.isDisplayed();
	    } catch (TimeoutException e) {
	        BaseClass.reportFailLog("Timeout in isDisplayed() for: " + locator, "isDisplayed");
	        WebElement fallback = fallbackWait(driver, locator, 5);

	        if (fallback != null) {
	            return fallback.isDisplayed();
	        }
	        return false;
	    } catch (Exception e) {
	        BaseClass.reportErrorLog("Unexpected error in isDisplayed(): " + e.getMessage());
	        return false;
	    }
	}


	// ------------------------- isEnabled() -------------------------
	public boolean isEnabled(WebDriver driver, By locator, String label) {
	    try {
	        BaseClass.reportLog("Checking enabled state: " + locator);
	        return waitForVisibility(driver, locator).isEnabled();
	    } catch (Exception e) {
	        BaseClass.reportFailLog("isEnabled() failed for: " + locator, "isEnabled");
	        WebElement fallback = fallbackWait(driver, locator, 5);

	        if (fallback != null) {
	            return fallback.isEnabled();
	        }

	        BaseClass.reportErrorLog("isEnabled -> NoSuchElement: " + locator);
	        throw new NoSuchElementException("Failed in isEnabled() for locator: " + locator);
	    }
	}



	// ------------------------- isSelected() -------------------------
	public boolean isSelected(WebDriver driver, By locator, String label) {
	    try {
	        BaseClass.reportLog("Checking selected state: " + locator);
	        return waitForClickable(driver, locator).isSelected();
	    } catch (Exception e) {
	        BaseClass.reportFailLog("isSelected() failed for: " + locator, "isSelected");
	        WebElement fallback = fallbackWait(driver, locator, 5);

	        if (fallback != null) {
	            return fallback.isSelected();
	        }

	        BaseClass.reportErrorLog("isSelected() -> NoSuchElement: " + locator);
	        throw new NoSuchElementException("Failed in isSelected() for locator: " + locator);
	    }
	}


	// ------------------------- click() -------------------------
	public void click(WebDriver driver, By locator, String label) {
	    try {
	        BaseClass.reportLog("Clicking on: " + label);
	        waitForClickable(driver, locator).click();
	    } catch (Exception e) {
	        BaseClass.reportFailLog("Click failed for: " + label, "click");

	        WebElement fallback = fallbackWait(driver, locator, 5);
	        if (fallback != null) {
	            try {
	                fallback.click();
	                return;
	            } catch (Exception ignored) {}
	        }

	        BaseClass.reportErrorLog("Click() final failure for: " + locator);
	        throw new NoSuchElementException("Failed in click() for locator: " + locator);
	    }finally {
	    	
	    	 isNotDisplayed(driver, getElementLocator(prop.getProperty("icedq.spinner")), 30);
	    }
	}


	// ------------------------- getText() -------------------------
	public String getText(WebDriver driver, By locator, String label) {
	    try {
	        BaseClass.reportLog("Getting text for: " + label);
	        return waitMethod(driver, 3).until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
	    } catch (Exception e) {
	        BaseClass.reportFailLog("getText() failed for: " + locator, "getText");
	        WebElement fallback = fallbackWait(driver, locator, 5);

	        if (fallback != null) {
	            return fallback.getText();
	        }

	        BaseClass.reportErrorLog("getText() -> Unable to retrieve text: " + locator);
	        throw new NoSuchElementException("Failed in getText() for locator: " + locator);
	    }
	}


	// ------------------------- clear() -------------------------
	public void clear(WebDriver driver, By locator, String label) {
	    try {
	        BaseClass.reportLog("Clearing field: " + label);
	        waitForClickable(driver, locator).clear();
	    } catch (Exception e) {
	        BaseClass.reportFailLog("clear() failed for: " + locator, "clear");
	        WebElement fallback = fallbackWait(driver, locator, 5);

	        if (fallback != null) {
	            fallback.clear();
	            return;
	        }

	        BaseClass.reportErrorLog("clear() -> Unable to clear: " + locator);
	        throw new NoSuchElementException("Failed in clear() for locator: " + locator);
	    }
	}


	// ------------------------- visible() -------------------------
	public void visible(WebDriver driver, By locator) {
	    try {
	        BaseClass.reportLog("Validating visibility: " + locator);
	        waitForVisibility(driver, locator);
	    } catch (Exception e) {
	        BaseClass.reportFailLog("visible() failed for: " + locator, "visible");
	        fallbackWait(driver, locator, 5);
	    }
	}


	// ------------------------------
	// CLICK with fallback mechanism
	// ------------------------------
	public void clickWithFallback(WebDriver driver, By locator) {
	    try {
	        BaseClass.reportLog("Primary click attempt: " + locator);
	        WebElement ele = waitForClickable(driver, locator);
	        ele.click();
	    } catch (Exception e1) {
	        BaseClass.reportFailLog("Primary click failed for: " + locator, "clickWithFallback");

	        try {
	            BaseClass.reportLog("Fallback ACTIONS click: " + locator);
	            WebElement ele = waitForVisibility(driver, locator);
	            actions.moveToElement(ele).click().perform();
	        } catch (Exception e2) {
	            BaseClass.reportLog("Fallback JS click: " + locator);
	            WebElement ele = driver.findElement(locator);
	            js.executeScript("arguments[0].click();", ele);
	        }
	    }
	}


	// ------------------------------
	// SENDKEYS with fallback
	// ------------------------------
	public void sendKeys(WebDriver driver, By locator, String value, String label) {
	    try {
	        BaseClass.reportLog("Typing into: " + label + " | Value: " + value);
	        WebElement ele = waitForVisibility(driver, locator);
	        ele.clear();
	        ele.sendKeys(value);
	    } catch (Exception e1) {
	        BaseClass.reportFailLog("Primary sendKeys failed for: " + label, "sendKeys");

	        try {
	            BaseClass.reportLog("Fallback ACTIONS sendKeys: " + locator);
	            WebElement ele = waitForVisibility(driver, locator);
	            actions.moveToElement(ele).click().sendKeys(value).perform();
	        } catch (Exception e2) {
	            BaseClass.reportLog("Fallback JS sendKeys: " + locator);
	            WebElement ele = driver.findElement(locator);
	            js.executeScript("arguments[0].value='" + value + "';", ele);
	        }
	    }
	}


	// ------------------------------
	// GET TEXT with fallback
	// ------------------------------
	public String getTextWithFallback(WebDriver driver, By locator) {
	    try {
	        BaseClass.reportLog("Getting text (primary): " + locator);
	        return waitForVisibility(driver, locator).getText();
	    } catch (Exception e1) {
	        BaseClass.reportFailLog("Primary getText failed: " + locator, "getTextWithFallback");

	        try {
	            BaseClass.reportLog("Fallback DOM attribute text: " + locator);
	            WebElement ele = driver.findElement(locator);
	            return ele.getDomAttribute("innertext");
	        } catch (Exception e2) {
	            BaseClass.reportLog("Fallback JS textContent: " + locator);
	            return js.executeScript("return arguments[0].textContent;",
	                    driver.findElement(locator)).toString();
	        }
	    }
	}

	// ------------------------------
	// SCROLL methods
	// ------------------------------
	public void scrollTo(WebDriver driver, By locator) {
		WebElement ele = driver.findElement(locator);
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	public void scrollToBottom() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	// ------------------------------
	// SELECT DROPDOWN by visible text with fallback
	// ------------------------------
	public void selectFromDropdown(WebDriver driver, By locator, String optionText) {
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
	public void clearWithFallback(WebDriver driver, By locator) {
		try {
			driver.findElement(locator).clear(); // primary
		} catch (Exception e) {
			js.executeScript("arguments[0].value='';", driver.findElement(locator)); // fallback
		}
	}

	// ------------------------------
	// RETRY CLICK
	// ------------------------------
	public void retryClick(WebDriver driver, By locator, int attempts, String label) {
		int count = 0;
		while (count < attempts) {
			try {
				click(driver, locator, label);
				return;
			} catch (Exception e) {
				count++;
			}
		}
	}


}
