package com.framework.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;


import com.framework.report.WebEventListener;



public class Launcher {
	
	

	public static WebDriver launchBrowser(
	        WebDriver driver,
	        String br,
	        String baseURL,
	        String username,
	        String password,
	        Logger log,
	        boolean enableLogging,
	        boolean singleUserLogin,
	        String moduleName,
	        String workspaceName
	) throws MalformedURLException {

	    try {
	        log.info("Launching browser: " + br);

	        switch (br.toLowerCase().trim()) {

	            case "headlesschrome":
	                driver = launchHeadlessChrome();
	                break;

	            case "chrome":
	                driver = launchNormalChrome();
	                break;

	            case "firefox":
	                driver = launchFirefox();
	                break;

	            case "ie":
	                driver = launchInternetExplorer();
	                break;

	            case "remote":
	                driver = launchRemoteChrome();
	                break;

	            default:
	                throw new RuntimeException("Invalid browser name: " + br);
	        }
	        if (enableLogging) {
	        		        	
	        	driver = new EventFiringDecorator<WebDriver>(new WebEventListener()).decorate(driver);

	        }
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
	        
	     //   driver.get(baseURL);

	        // Single-user login
	        if (singleUserLogin) {
	            performAutoLogin(driver, moduleName, workspaceName);
	        }

	    } catch (Exception e) {
	        log.error("LaunchBrowser Error: ", e);
	        throw e;
	    }

	    return driver;
	}
	
	private static final boolean FULL_LOG = false;   // 🔷 Toggle here

	private static WebDriver launchNormalChrome() {

	    ChromeOptions options = new ChromeOptions();
	    options.setAcceptInsecureCerts(true);

	    // ----- MINIMAL LOG MODE -----
	    if (!FULL_LOG) {
	        System.setProperty("webdriver.chrome.silentOutput", "true");  // reduces console noise
	        System.setProperty("webdriver.chrome.verboseLogging", "false");
	        options.addArguments("--log-level=3");                // 0=ALL, 1=INFO, 2=WARNING, 3=ERROR only
	        options.addArguments("--silent");
	        options.addArguments("--disable-logging");
	        options.addArguments("--disable-dev-shm-usage");
	        options.addArguments("--output=/dev/null");
	    }

	    // ----- Download Preference -----
	    String downloadPath = BaseClass.DIR_PATH + "/files/download";
	    Map<String, Object> prefs = new HashMap<>();
	    prefs.put("download.default_directory", downloadPath);
	    prefs.put("profile.default_content_settings.popups", 0);

	    options.setExperimentalOption("prefs", prefs);

	    // ----- Extension -----
	    options.addExtensions(new File(BaseClass.DIR_PATH + "/files/extensions/disable_DownloadBar.crx"));

	    return new ChromeDriver(options);
	}

	private static WebDriver launchHeadlessChrome() {
	  //  WebDriverManager.chromedriver().setup();

	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--headless=new");
	    options.addArguments("--window-size=1366,786");
	    options.setAcceptInsecureCerts(true);

	    return new ChromeDriver(options);
	}
	
	private static WebDriver launchFirefox() {
	 //   WebDriverManager.firefoxdriver().setup();
	    return new FirefoxDriver();
	}
	
	private static WebDriver launchInternetExplorer() {
	//    WebDriverManager.iedriver().setup();
	    return new InternetExplorerDriver();
	}

	private static WebDriver launchRemoteChrome() throws MalformedURLException {

	 //   WebDriverManager.chromedriver().setup();

	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-gpu");
	    options.addArguments("--timezone=Asia/Kolkata");

	    Map<String, Object> prefs = new HashMap<>();
	    prefs.put("download.default_directory", "/home/seluser/");
	    prefs.put("download.prompt_for_download", false);

	    options.setExperimentalOption("prefs", prefs);
	    options.addExtensions(new File(BaseClass.DIR_PATH + "/src/Extensions/disable_DownloadBar.crx"));

	    return new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), options);
	}
		
	private static void performAutoLogin(WebDriver driver, String moduleName, String workspaceName) {


	}






}
