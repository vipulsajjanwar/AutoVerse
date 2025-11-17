package com.framework.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.Status;
import com.framework.config.ReadConfig;
import com.framework.variables.ExecutionVariables;

import io.github.bonigarcia.wdm.WebDriverManager;

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

	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

	        log.info("Navigating to URL: " + baseURL);
	        driver.get(baseURL);

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
	
	private static WebDriver launchNormalChrome() {

	    WebDriverManager.chromedriver().setup();

	    ChromeOptions options = new ChromeOptions();
	    options.setAcceptInsecureCerts(true);

	    String downloadPath = BaseClass.DIR_PATH + "/files/download";
	    Map<String, Object> prefs = new HashMap<>();
	    prefs.put("download.default_directory", downloadPath);
	    prefs.put("profile.default_content_settings.popups", 0);

	    options.setExperimentalOption("prefs", prefs);
	    options.addExtensions(new File(BaseClass.DIR_PATH + "/files/extensions/disable_DownloadBar.crx"));

	    return new ChromeDriver(options);
	}

	private static WebDriver launchHeadlessChrome() {
	    WebDriverManager.chromedriver().setup();

	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--headless=new");
	    options.addArguments("--window-size=1366,786");
	    options.setAcceptInsecureCerts(true);

	    return new ChromeDriver(options);
	}
	
	private static WebDriver launchFirefox() {
	    WebDriverManager.firefoxdriver().setup();
	    return new FirefoxDriver();
	}
	
	private static WebDriver launchInternetExplorer() {
	    WebDriverManager.iedriver().setup();
	    return new InternetExplorerDriver();
	}

	private static WebDriver launchRemoteChrome() throws MalformedURLException {

	    WebDriverManager.chromedriver().setup();

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

		BaseClass.test = BaseClass.extent.createTest("verifyLoginToApplication_503");

	    ReadConfig config = new ReadConfig("");
	    BaseClass.test.log(Status.INFO, "NG21-503");

	    ExecutionVariables.issueKey = "NG21-503";
	}






}
