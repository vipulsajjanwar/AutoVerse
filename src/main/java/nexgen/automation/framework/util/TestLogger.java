package nexgen.automation.framework.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import nexgen.automation.framework.baseclass.BaseSuite;

public class TestLogger extends PageUtil{
	
	
    private TestLogger() {
        throw new UnsupportedOperationException("Utility class - instantiation not allowed");
    }
	
	static final Logger log = Logger.getLogger(TestLogger.class);

	private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private static String timestamp() {
		return "[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern(TIME_FORMAT)) + "]";
	}

	private static void log(String level, String message) {
		log.info(timestamp() + " " + level + ": " + message);
	}

	private static void logError(String level, String message) {
		log.error(timestamp() + " " + level + ": " + message);
	}

	// General
	public static void  info(String message)       { log("INFO", message); }
	public static void debug(String message)      { log("DEBUG", message); }
	public static void warn(String message)       { log("WARNING", message); }
	public static void pass(String message)       { log("PASS", message); }
	public static void fail(String message)       { logError("FAIL", message); }

	// UI Interactions
	public static void clickOn(String element)    {  BaseSuite.reportLog("Clicking on: " + element); }
	public static void clicked(String element)    {  BaseSuite.validationReportLog("Clicked on: " + element); }

	public static void input(String field, String value) {
		BaseSuite.reportLog("Entering text into '" + field + "': " + value);
	}
	public static void selected(String option, String dropdown) {
		BaseSuite.reportLog("Selected '" + option + "' from '" + dropdown + "'");
	}
	public static void hovered(String element)    {  BaseSuite.reportLog("Hovered over: " + element); }
	public static void scrolledTo(String element) {  BaseSuite.reportLog("Scrolled to element: " + element); }

	// Assertions & Validations
	public static void expected(String expectation) {
		BaseSuite.reportLog("Expected: " + expectation);
	}
	public static void actual(String actual) {
		BaseSuite.reportLog("Actual: " + actual);
	}
	public static void retrieved(String name, String value) {
		BaseSuite.reportLog("Retrieved '" + name + "': " + value);
	}
	public static void verify(String condition) {
		BaseSuite.reportLog("Verifying: " + condition);
	}
	public static void validate(String check) {
		BaseSuite.reportLog("Validating: " + check);
	}
	public static void assertEquals(String expected, String actual) {
		BaseSuite.reportLog("Asserting equality -> Expected: '" + expected + "' | Actual: '" + actual + "'");
	}
	public static void assertTrue(String conditionDesc) {
		BaseSuite.reportLog("Asserting condition is TRUE: " + conditionDesc);
	}

	// Navigation
	public static void navigateTo(String url) {
		BaseSuite.reportLog("Navigating to: " + url);
	}
	public static void redirectedTo(String page) {
		BaseSuite.reportLog("Redirected to: " + page);
	}

	// Waiting / Timing
	public static void waitFor(String condition) {
		BaseSuite.reportLog("Waiting for: " + condition);
	}
	public static void waitCompleted(String condition) {
		BaseSuite.reportLog("Condition met: " + condition);
	}

	// Element States
	public static void elementVisible(String element) {
		BaseSuite.reportLog("Element is visible: " + element);
	}
	public static void elementNotVisible(String element) {
		BaseSuite.reportLog("Element is NOT visible: " + element);
	}
	public static void elementEnabled(String element) {
		BaseSuite.reportLog("Element is enabled: " + element);
	}
	public static void elementDisabled(String element) {
		BaseSuite.reportLog("Element is disabled: " + element);
	}

	// Checkboxes & Radio buttons
	public static void checked(String element) {
		BaseSuite.reportLog("Checked: " + element);
	}
	public static void unchecked(String element) {
		BaseSuite.reportLog("Unchecked: " + element);
	}

	// File Uploads/Downloads
	public static void fileUploaded(String filePath) {
		BaseSuite.reportLog("File uploaded: " + filePath);
	}
	public static void fileDownloaded(String filePath) {
		BaseSuite.reportLog("File downloaded: " + filePath);
	}

	// API / Data Logs (if applicable)
	public static void apiRequest(String endpoint) {
		BaseSuite.reportLog("API Request sent to: " + endpoint);
	}
	public static void apiResponse(String responseCode, String body) {
		BaseSuite.reportLog("API Response -> Code: " + responseCode + ", Body: " + body);
	}
	
	public String createHtmlTable(String [][] datatable, String tableTitle) {


		String trClose="</tr>";
		StringBuilder htmlbuilder = new StringBuilder();

		try {
			if(datatable!=null) {

				htmlbuilder.append(prop.getProperty("workflow.recentRuns.Details.Table.cssStyle"));

				htmlbuilder.append("<table class =\"rule1\">");

				htmlbuilder.append("<caption>"+tableTitle+" table"+"</caption>");

				htmlbuilder.append("<thead>");

				htmlbuilder.append("<tr class=\"e-row\">");

				for(String header : datatable[0]) {

					htmlbuilder.append("<th class=\"e-headercell\" style=\"text-align: center;\">").append(header).append("</th>");

				}
				htmlbuilder.append(trClose);

				htmlbuilder.append("</thead>");

				htmlbuilder.append("<tbody>");

				for(int i=1;i<datatable.length;i++) {

					htmlbuilder.append("<tr class=\"e-row\">");

					for(String cell :datatable[i]) {

						htmlbuilder=setHtmlColorCode(cell, htmlbuilder);
					}

					htmlbuilder.append(trClose);
				}

				htmlbuilder.append("</tbody>");

				htmlbuilder.append("</table>");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Error occurs while createHtmlTable1 kindly check , "+e.toString());
		}
		return htmlbuilder.toString();
	}
	
	public void getTableForTestScenarios(WebDriver driver,List<String> list) {

		try {

			log.info(driver);
			if(!list.isEmpty()) {

				String [][] table = new String[list.size()+1][4];

				String[] header = { "No.", "Test Scenario name", "Execution Status" };

				table[0] = header;

				for (int i = 0; i < list.size(); i++) {

					String num = Integer.toString(i + 1);

					String tscenario = list.get(i).split(",")[0];

					String tstatus = list.get(i).split(",")[1];

					String[] data = { num, tscenario, tstatus };

					table[i + 1] = data;

				}

				BaseSuite.reportLog(createHtmlTable(table,"Test Scenarios"));

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"error observed while getTableForTestScenario :: " + e.toString());
		}
	}
}
