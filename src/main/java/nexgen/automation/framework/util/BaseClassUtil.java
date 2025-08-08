package nexgen.automation.framework.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.constant.ExecutionResult;
import nexgen.automation.framework.reports.WebEventListener;
import nexgen.automation.pageclasses.otherpages.LoginPage;


public class BaseClassUtil   {
	

	String key = "https://icedqngvm1.eastus.cloudapp.azure.com:8443/auth/realms/iam.icedq/protocol/openid-connect/auth?client_id=icedq.admin-ui&redirect_uri=http%3A%2F%2Ficedqngvm1.eastus.cloudapp.azure.com%3A4201%2F%23%2F&state=2dfe4aec-aa86-4394-96bb-cebb34aee7f1&response_mode=fragment&response_type=code&scope=openid&nonce=c4667708-e899-4687-a86a-3edddff6bb8a";//https://icedqngvm1.eastus.cloudapp.azure.com:8443/auth/realms/iam.icedq/protocol/openid-connect/auth?client_id=icedq.admin-ui&redirect_uri=http%3A%2F%2Ficedqngvm1.eastus.cloudapp.azure.com%3A4200%2F&state=36f36a05-728d-4464-9807-2c13726c345d&response_mode=fragment&response_type=code&scope=openid&nonce=1751d908-e11d-4731-b00d-4645f701b52c
	String dirPath=System.getProperty("user.dir");
	SoftAssert soft = new SoftAssert();

	/**
	 * getuserName
	 *
	 */
	public String getuserName() {

		return System.getProperty("user.name");

	}

	public String getFileOperator() {
		String fileOperator = null;
		switch (System.getProperty("os.name")) {
		case "Linux":
			fileOperator = "/";
			break;
		case "Windows":
			fileOperator = "\\";
			break;
		default:
			break;
		}
		return fileOperator;

	}

	/**
	 * getOSName
	 *
	 */

	public String getOSName() {

		return System.getProperty("os.name");
		      

	}

	/**
	 * takeScreenshotAtEndOfTest
	 * 
	 * @param MethodName
	 * @throws IOException
	 */

	public String takeScreenshotAtEndOfTest(String methodName, WebDriver driver) throws IOException {
		String timeStampformail = new SimpleDateFormat("HH.mm.ss-MM-dd-yyyy").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		String dest = ts.getScreenshotAs(OutputType.BASE64);
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(Paths.get("").toAbsolutePath().toString() + "/reports/"+BaseSuite.buildId+"/Screenshots/" + methodName + "/"+ methodName + timeStampformail + ".png");
		FileUtils.copyFile(source, target);
		return dest;

	}

	/**
	 * takeScreenshot
	 * 
	 * @param MethodName
	 * @throws IOException
	 */

	public String takeScreenshot(String methodName, WebDriver driver) throws IOException {
		String timeStampformail = new SimpleDateFormat("HH.mm.ss-MM-dd-yyyy").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		File target = new File(Paths.get("").toAbsolutePath().toString() + "/reports/"+BaseSuite.buildId+"/Screenshots/" + methodName + "/"+ methodName + timeStampformail + ".png");
		FileUtils.copyFile(source, target);
		FileUtils.forceDelete(source);
		return target.toString();

	}

	/**
	 * 
	 * gethost Get the host name on which the test is running
	 * 
	 */

	public String gethost() {
		String hostname = "Unknown";
		try {
			InetAddress addr;
			addr = InetAddress.getLocalHost();
			hostname = addr.getHostName();
		} catch (UnknownHostException ex) {
			soft.fail("Hostname can not be resolved");
		}
		return hostname;
	}

	/**
	 * getcount
	 * 
	 * get count of the splitters
	 * 
	 * @param string
	 * @param type
	 * 
	 */
	public int getcount(String string, char type) {
		int commas = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == type)
				commas++;
		}
		return commas;

	}

	public String writeXmlDocumentToXmlFile(String xmlDocument)
			throws TransformerException, SAXException, IOException, ParserConfigurationException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
		dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(new File(xmlDocument));

		TransformerFactory tf = TransformerFactory.newInstance();
		tf.setFeature(XMLConstants.DEFAULT_NS_PREFIX, true);

		Transformer transformer= tf.newTransformer();

		
		StringWriter writer = new StringWriter();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

		// transform document to string
		transformer.transform(new DOMSource(document), new StreamResult(writer));

		return writer.getBuffer().toString();
		

	}

	@SuppressWarnings("deprecation")
	public WebDriver launchBrowser(WebDriver driver, String br, String baseURL, String username, String password,
			Logger log, boolean logging, EventFiringWebDriver edriver, WebEventListener eventListener, boolean singleUserLogin,String moduleName, String workspaceName)
			throws MalformedURLException {

		try {
			switch (br.toLowerCase().trim()) {

			case "headlesschrome":
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-extensions");
				options.addArguments("headless");
				options.addArguments("window-size=1366x786");
				options.addArguments("--no-sandbox");
				options.setAcceptInsecureCerts(true);
				driver = new ChromeDriver(options);
				break;

			case "chrome":
				
				WebDriverManager.chromedriver().setup();
				ChromeOptions optionsHL = new ChromeOptions();
				
				String downloadFilepath = dirPath+"\\src\\Downloads";
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory", downloadFilepath);
				optionsHL.setExperimentalOption("prefs", chromePrefs);
				optionsHL.addExtensions(new File(dirPath+"\\src\\Extensions\\disable_DownloadBar.crx"));
			/**	optionsHL.addArguments("--incognito");*/
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				cap.setCapability(ChromeOptions.CAPABILITY, optionsHL);
				
				driver = new ChromeDriver(cap);
				
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;

			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			
			case "remote":
				
				WebDriverManager.chromedriver().setup();
				ChromeOptions optionsHL1 = new ChromeOptions();
				
			/**	String downloadFilepath1 = dirPath+"\\src\\Downloads";*/
				HashMap<String, Object> chromePrefs1 = new HashMap<String, Object>();
				chromePrefs1.put("profile.default_content_settings.popups", 0);
				chromePrefs1.put("download.prompt_for_download", false);
				chromePrefs1.put("download.default_directory", "/home/seluser/Downloads");
				optionsHL1.addArguments("--disable-gpu");
				optionsHL1.addArguments("--timezone=Asia/Kolkata");
				optionsHL1.setExperimentalOption("prefs", chromePrefs1);
				optionsHL1.addExtensions(new File(dirPath+"/src/Extensions/disable_DownloadBar.crx"));
				optionsHL1.setCapability("platformName", "Linux");
				DesiredCapabilities cap1 = DesiredCapabilities.chrome();
				cap1.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				cap1.setCapability(ChromeOptions.CAPABILITY, optionsHL1);

				driver = new RemoteWebDriver(new URL(Constant.REMOTE_HUB_URL), cap1);
			
				break;
			default:
				log.info("Browser not defined.");
				break;
			}
			if (logging) {
				edriver = new EventFiringWebDriver(driver);
				eventListener = new WebEventListener();
				edriver.register(eventListener);
				driver = edriver;
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(baseURL);
					
			driver.manage().timeouts().pageLoadTimeout(Constant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			
			
			//LoginPage login = new LoginPage(driver);
			
			if(singleUserLogin)
			{
				
				BaseSuite.test = BaseSuite.extent.createTest("verifyLoginToApplication_503");
				ReadConfig mailconfig = new ReadConfig();

				BaseSuite.test.log(Status.INFO, "X-ray Test Case URL");
				BaseSuite.test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-503");
				ExecutionResult.issueKey = "NG21-503";
				new LoginPage(driver).loginWithIcedqUserAndSelectWorkspace("",ConstantProperty.TARGET_WORKSPACE_NAME, BaseSuite.ModuleName,"");
			}
		} catch (Exception e) {
			log.error("Error occurs while launching browser :: "+e.toString());
			
		}
		
		return driver;

	}

	
	public void createReport(ReadConfig readconfig, BaseClassUtil util) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String reportname = ExecutionResult.suitename + "-Suite-" + timeStamp + ".html";
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				dirPath + "/reports/" + ExecutionResult.suitename + "-reports" + "/" + reportname);
		htmlReporter.config().setDocumentTitle(readconfig.subject());
		htmlReporter.config().setReportName(ExecutionResult.suitename);
		htmlReporter.config().setTheme(Theme.DARK);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", util.gethost());
		extent.setSystemInfo("OS", util.getOSName());
		extent.setSystemInfo("PC User", util.getuserName());

	}
	
	// Method to generate a random string
    public static String generateRandomLowercaseString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
        	 int index = RANDOM.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
    
 // Method to generate a random string
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
        	 int index = RANDOM.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
       
    private static final String[] AI_NAMES = {
            "NeuralMind", "DeepVision", "CognitiveCore", "QuantumAI", "SentientLogic",
            "AetherNet", "NeuroLink", "Singularity", "AlphaBrain", "DeepSynapse",
            "CyberMind", "GigaNeuron", "Intellecta", "SynthoMind", "MetaCog",
            "DeepThink", "HyperNeural", "Neuronexus", "CogniBot", "NeuraFlow",
            "AI_Nexus", "SmartAI", "AutoCog", "NeuroSynth", "QuantumBot",
            "ThinkNet", "AI_Fusion", "DeepSense", "CyberIntellect", "GeniusAI",
            "SingularCore", "HyperIntellect", "NeuraX", "AI_Sentinel", "CerebraNet",
            "MindMeld", "VisionAI", "DeepMorph", "EvoMind", "HyperCog",
            "NeuralSpark", "AI_Visionary", "CortexNet", "QuantumThink", "LogicMind",
            "DeepGen", "AI_Evolve", "AutoNeural", "NexusBot", "AI_Prime",
            "BrainwaveAI", "DeepNet", "AI_Nova", "NeuraGen", "NeuroSphere",
            "HyperMind", "CyberThink", "AI_Cognition", "MetaMind", "DeepBot",
            "AI_Insight", "NeuralFocus", "Deep_Intelligence", "CognitiveAI", "AI_Link",
            "HyperNeuro", "NeuraCloud", "AI_Precision", "IntellectX", "SmartNeuron",
            "DeepNeuron", "AI_Zenith", "CyberCore", "QuantumNeuro", "AI_Echo",
            "Deep Fusion", "NeuroHive", "AI_Mindstorm", "MetaNeural", "ThinkBot",
            "NeuralCircuit", "CogniVerse", "IntelliAI", "AutoMind", "DeepEcho",
            "SentientAI", "NeuroMorph", "HyperCortex", "DeepStream", "NeuroThink",
            "AI_Pulse", "GeniusNeural", "CognitiveLink", "DeepNeuronX", "AI_Reflex",
            "QuantumCortex", "CognitiveBot", "AutoCortex", "CyberNeural", "AI_Core"
        };
    private static final Random RANDOM = new Random();
    public static String getRandomSuffix() {
        
        return AI_NAMES[RANDOM.nextInt(AI_NAMES.length)];
    }
    
    public static void setSystemPropertiesForExecution() {
    	
    	System.setProperty("fieldNameSuffix", "_"+generateRandomLowercaseString(5));
		System.setProperty("displayNameSuffix", "_"+getRandomSuffix()+"_"+generateRandomString(3));
		System.setProperty("updateDisplayNameSuffix", "_"+getRandomSuffix()+"_"+generateRandomString(3));
		System.setProperty("valueNameSuffix", "_"+getRandomSuffix()+"_"+generateRandomString(3));
		System.setProperty("updatevalueNameSuffix", "_"+getRandomSuffix()+"_"+generateRandomString(3));
		System.setProperty("ldapsuffix","_"+getRandomSuffix()+"_"+generateRandomString(3));
		System.setProperty("Updateldapsuffix","_"+getRandomSuffix()+"_"+generateRandomString(3));
		System.setProperty("mappersuffix","_"+generateRandomString(3));
		System.setProperty("idpaliassuffix","_"+getRandomSuffix()+"_"+generateRandomString(3));
		System.setProperty("idpupdatealiassuffix","_"+getRandomSuffix()+"_"+generateRandomString(3));
		System.setProperty("schedulesuffix", "_"+getRandomSuffix()+"_"+generateRandomString(3));
		System.setProperty("updateschedulesuffix", "_"+getRandomSuffix()+"_"+generateRandomString(3));
		System.setProperty("foldersuffix", "_"+generateRandomString(5));
		System.setProperty("updatefoldersuffix", "_"+generateRandomString(5));
    }
	
    private static final Map<Class<? extends Exception>, String> exceptionMessages = createExceptionMessages();

    private static Map<Class<? extends Exception>, String> createExceptionMessages() {
        Map<Class<? extends Exception>, String> map = new HashMap<>();

        // Selenium-specific exceptions
        map.put(StaleElementReferenceException.class, "The web element is no longer attached to the DOM. It may have been refreshed or removed.");
        map.put(NoSuchElementException.class, "Element not found. Verify the locator or ensure the element is visible.");
        map.put(TimeoutException.class, "The operation timed out. Consider increasing wait time or refining the wait condition.");
        map.put(ElementNotInteractableException.class, "Element is present but not interactable. It may be hidden, disabled, or overlapped.");
        map.put(ElementClickInterceptedException.class, "Click was intercepted. Another element (e.g., popup or overlay) may be blocking the target.");
        map.put(WebDriverException.class, "WebDriver encountered an error. Check browser session, compatibility, or driver path.");
        map.put(JavascriptException.class, "A JavaScript error occurred during script execution. Review console for JS errors.");
        map.put(InvalidSelectorException.class, "Invalid selector used. Check for typos or incorrect XPath/CSS syntax.");
        map.put(SessionNotCreatedException.class, "Failed to create a browser session. This may be due to mismatched driver/browser versions.");
        map.put(NoSuchWindowException.class, "Attempted to switch to a non-existent window. Ensure the window handle is valid.");
        map.put(NoSuchFrameException.class, "Frame not found. Check if the frame index or name is correct.");
        map.put(MoveTargetOutOfBoundsException.class, "Element is outside of the viewport. Scroll into view or adjust your interaction.");

        // General Java exceptions
        map.put(NullPointerException.class, "Null reference encountered. Make sure the object is initialized before use.");
        map.put(IllegalArgumentException.class, "Invalid argument passed to a method. Check parameter values.");
        map.put(IllegalStateException.class, "Method was invoked at an illegal or inappropriate time. Check object state.");
        map.put(IOException.class, "An I/O error occurred. Check file paths, permissions, or network resources.");
        map.put(FileNotFoundException.class, "File not found. Verify the file path and that the file exists.");
        map.put(ArithmeticException.class, "Illegal arithmetic operation (e.g., division by zero). Check your calculations.");
        map.put(ArrayIndexOutOfBoundsException.class, "Array index is out of range. Check array size and accessed index.");
        map.put(ClassCastException.class, "Invalid type casting. Ensure correct object type before casting.");
        map.put(NumberFormatException.class, "Invalid number format. Ensure the string can be parsed as a number.");

        return map;
    }

    public static String getExceptionCause(Exception e) {
        for (Map.Entry<Class<? extends Exception>, String> entry : exceptionMessages.entrySet()) {
            if (entry.getKey().isInstance(e)) {
                return entry.getValue();
            }
        }
        return "Unknown error occurred. Check the stack trace for more details.";
    }

}
