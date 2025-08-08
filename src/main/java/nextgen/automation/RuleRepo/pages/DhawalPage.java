package nextgen.automation.RuleRepo.pages;

import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;

public class DhawalPage extends PageUtil{
	
	WebDriver driver;
	
	public DhawalPage(WebDriver driver) {

		this.driver = driver;

	}
	
	By popUpClose=getElementLocator( prop.getProperty("PopUpClose"));
	By toastMsg=getElementLocator(prop.getProperty("Commontoastmsg"));
	By sourceDatasetClick = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetClick"));
	By sourceDatasetClick1 = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetClick1"));
	By sourceDatasetSourceName = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetSourceName"));
	By sourceDatasetConnectionType = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetConnectionType"));
	By sourceDatasetConnectionClick = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetConnectionClick"));
	By sourceDatasetConnectionSearch = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetConnectionSearch"));
	By SourceDatasetSchemaSearch = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetSchemaSearch"));
	By sourceDatasetSchemaClick = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetSchemaClick"));
	By sourceDatasetTableClick = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetTableClick"));
	By sourceDatasetTableSearch = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetTableSearch"));
	By sourceDatasetTestButton = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetTestButton"));
	By sourceDatasetEditButton = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetEditButton"));
	By sourceDatasetSetSQLButton = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetSetSQLButton"));
	By sourceDatasetSetFileButton = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetSetFileButton"));
	By sourceDatasetSetFileType = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetSetFileType"));
	By sourceDatasetSpinner = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetSpinner"));
	By sourceDatasetDataQueryBox = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetDataQueryBox"));
	By targetDatasetDataQueryBox = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetDataQueryBox"));
	By newRuleCancelBtn = getElementLocator(prop.getProperty("dataT.NewRuleSideBar.CancelButton"));
	By calculatedTab = getElementLocator(prop.getProperty("dataT.AddCol.CalculatedTab"));
	By expressionBox = getElementLocator(prop.getProperty("dataT.ExpressionBox"));
	By expressionBoxClear = getElementLocator(prop.getProperty("dataT.ExpressionBoxClear"));
	By vaalidationCancleButton = getElementLocator(prop.getProperty("DataTesting.CancleButton"));
	By connectionTypeLabel = getElementLocator(prop.getProperty("DataTestting.ConnectionTypeLabel"));
	By connectionLabel = getElementLocator(prop.getProperty("DataTestting.ConnectionLabel"));
	
	By getData = getElementLocator(prop.getProperty("RuleRepo.GetData"));
	By cancleButton = getElementLocator(prop.getProperty("RuleRepo.CancleButton"));
	By sourceData = getElementLocator(prop.getProperty("RuleRepo.Data"));
	By getFile = getElementLocator(prop.getProperty("RuleRepo.GetFile")); 
	By selectBottom = getElementLocator(prop.getProperty("RuleRepo.SelectBottom")); 
	By propertiesBtn = getElementLocator(prop.getProperty("propertiesBtn")); 
	By appendOrderBy = getElementLocator(prop.getProperty("RuleRepo.AppendOrderBy")); 
	By tableList = getElementLocator(prop.getProperty("RuleRepo.TableList")); 
	By preview = getElementLocator(prop.getProperty("RuleRepo.Preview")); 
	By targetDatasetConnectionType = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetConnectionType")); 
	By targetDatasetConnectionClick = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetConnectionClick")); 
	By targetData = getElementLocator(prop.getProperty("RuleRepo.TargetData")); 
	By targetDatasetTestButton = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetTestButton")); 
	By diffJoinButton = getElementLocator(prop.getProperty("RuleRepo.DiffJoinButton")); 
	
	By diffJoinConnectAll = getElementLocator(prop.getProperty("RuleRepo.DiffJoinConnectAll")); 
	By diffJoinDisConnectAll = getElementLocator(prop.getProperty("RuleRepo.DiffJoinDisConnectAll")); 
	By diffJoinAddAllAsExpression = getElementLocator(prop.getProperty("RuleRepo.DiffJoinAddAllAsExpression")); 
	By ruleTab = getElementLocator(prop.getProperty("DataT.RuleTab")); 
	
	
	By targetDatasetTargetName = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetTargetName")); 
	
	By source = getElementLocator(prop.getProperty("RuleRepo.Source")); 
	By target = getElementLocator(prop.getProperty("RuleRepo.Target")); 
	By targetDatasetButton = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetButton")); 
	By cancelBtn = getElementLocator(prop.getProperty("dataT.calculated.CancelBtn")); 
	
	String sourceDatasetConnectionTypeSelect = prop.getProperty("RuleRepo.SourceDatasetConnectionTypeSelect");
	String sourceDatasetInput = prop.getProperty("RuleRepo.SourceDatasetInput");
	String sourceDatasetConnectionSelect = prop.getProperty("RuleRepo.SourceDatasetConnectionSelect");
	String sourceDatasetSchemaSelect = prop.getProperty("RuleRepo.SourceDatasetSchemaSelect");
	String sourceDatasetTableSelect = prop.getProperty("RuleRepo.SourceDatasetTableSelect");
	String sourceDatasetSetFileTypeSelect = prop.getProperty("RuleRepo.SourceDatasetSetFileTypeSelect");
	String connectionTypeMess = prop.getProperty("RuleRepo.ConnectionTypeMess");
	String connectionMess = prop.getProperty("RuleRepo.ConnectionMess");
	String schemaMess = prop.getProperty("RuleRepo.SchemaMess");
	String selectFileFolder = prop.getProperty("RuleRepo.SelectFileFolder");
	String selectFile = prop.getProperty("RuleRepo.SelectFile");
	String connectionTestMess = prop.getProperty("connectionTestMess");
	String joinSourceColName = prop.getProperty("RuleRepo.JoinSourceColName");
	String joinTargetColName = prop.getProperty("RuleRepo.JoinTargetColName");
	String chooseAttribute = prop.getProperty("dataT.Checks.ChooseAttribute");
	String columnNameClick = prop.getProperty("dataT.ColumnNameClick");
	String readerMessage = prop.getProperty("DataTesting.ReaderMessage");
	
	
	
	//=========================Connection Repo============================================//
	
	
	
	
	public void clickOnSourceDataset() throws FindFailed
	{
		WebElement ele = driver.findElement(sourceDatasetClick);
		//WebElement ele1 = driver.findElement(sourceDatasetClick1);
		wait = new WebDriverWait(driver, Constant.ruleWait);
		//ele.click();
		Actions builder = new Actions(driver);
		//dragAndDrop(driver, sourceDatasetClick.toString(), propertiesBtn.toString()); 
		builder.dragAndDropBy(ele, 300, 300).build().perform();
		builder.moveToElement(ele).clickAndHold(ele).dragAndDropBy(ele, 1000, 1000).build().perform();;
		//imageClick();
		 //ele.sendKeys(Keys.ENTER);
		javascript(driver, "arguments[0].click();", sourceDatasetClick);
		builder.click(ele).build().perform();
		builder.doubleClick(ele).perform();
		
       // wait.until(ExpectedConditions.elementToBeClickable(sourceDatasetClick1)).click();;
       // JavascriptExecutor js = (JavascriptExecutor)driver;
        //js.executeScript("document.getElementById('parent').click();");
		//javascript(driver, "arguments[0].click();", sourceDatasetClick1);
		
	}
	
	public void clickOnTargetDataset()
	{
		
		try {
			
			WebElement ele = driver.findElement(targetDatasetButton);
			
			BaseSuite.reportLog("Clicking on Target dataset button");
			
			javascript(driver, "arguments[0].scrollIntoView(true);", targetDatasetButton);
			
			Thread.sleep(2000);
			
			Actions builder = new Actions(driver);
		
			builder.click(ele).build().perform();

			BaseSuite.reportLog("Target dataset button clicked successfully");
		} catch (Exception e) {
			
			e.getMessage();
		}
	
		
		
	}
	
	public void clickOnDiffJoin()
	{
		
		try {
			
			WebElement ele = driver.findElement(diffJoinButton);
			
			BaseSuite.reportLog("Clicking on Target dataset button");
			
			javascript(driver, "arguments[0].scrollIntoView(true);", diffJoinButton);
			
			Thread.sleep(2000);
			
			Actions builder = new Actions(driver);
		
			builder.click(ele).build().perform();

			BaseSuite.reportLog("Target dataset button clicked successfully");
		} catch (Exception e) {
			
			e.getMessage();
		}
	
		
		
	}
	
	public void enterDetailsInSourceSetting(DataTestingParameters param) throws Exception{

		try {
			if (!param.getSourceName().isEmpty()) {
				
				BaseSuite.reportLog("Entering Source Dataset Source name");

				clear_Click_SendKeys(driver, 5, sourceDatasetSourceName, param.getSourceName());

				BaseSuite.validationReportLog("Source Dataset Source name entered successfully");
			}

			selectSourceConnectionType(param.getSourceConnType());

			selectInput(param.getSourceInput());

			selectSourceConnection(param.getSourceConnection());

			String connTestMess = testButton(sourceDatasetTestButton);
			
			if(connTestMess.equalsIgnoreCase(connectionTestMess))
			{

				if (param.getSourceConnType().equalsIgnoreCase("Database")) {

					if (param.getSourceInput().equalsIgnoreCase("Table")) {

						selectSchema(param.getSourceSchema());

						selectTable(param.getSourceTable());

						dataButton(sourceData);

					} else {

						setSqlButton();
					}
					
					if(param.getRuleType().equalsIgnoreCase("Recon"))
					{
						appendOrderBy(param.getSourceAppendOrder());

					}
					
					connectionSchemaTablePath(source, param.getSourecPath());

					enterDBQuery(sourceDatasetDataQueryBox,param.getSourceQuery());

					getData();

				} else {

					selectFileType(param.getSourceFileType());

					setFileButton();

				}

			}
			
			else
			{
				BaseSuite.reportFailLog("Not able to create a rule because connection details is invalid, kindly check the connection details", "enterDetailsInSourceSetting");
				
			}
		} catch (Exception e) {
			
			throw new Exception();
		}

	}
	
	
	
	public void enterDetailsInTargetDataset(DataTestingParameters param) throws Exception{

		try {
			
			clickOnTargetDataset();
			
			if (!param.getTargetName().isEmpty()) {
				
				BaseSuite.reportLog("Entering Target Dataset Source name");

				clear_Click_SendKeys(driver, 5, targetDatasetTargetName, param.getTargetName());

				BaseSuite.reportLog("Target Dataset Source name entered successfully");
			}

			selectTargetConnectionType(param.getTargetConnType());

			selectInput(param.getTargetInput());

			selectTargetConnection(param.getTargetConnection());

			String connTestMess = testButton(targetDatasetTestButton);
			
			if(connTestMess.equalsIgnoreCase(connectionTestMess))
			{

				if (param.getTargetConnType().equalsIgnoreCase("Database")) {

					if (param.getTargetInput().equalsIgnoreCase("Table Input")) {

						selectSchema(param.getTargetSchema());

						selectTable(param.getTargetTable());

						dataButton(targetData);

					} else {

						setSqlButton();
					}
					
					if(param.getRuleType().equalsIgnoreCase("Recon"))
					{
						appendOrderBy(param.getTargetAppendOrder());

					}
					
					connectionSchemaTablePath(target, param.getTargetPath());

					enterDBQuery(targetDatasetDataQueryBox,param.getTargetQuery());

					getData();

				} else {

					selectFileType(param.getTargetFileType());

					setFileButton();

				}

			}
			
			else
			{
				BaseSuite.reportFailLog("Not able to create a rule because connection details is invalid, kindly check the connection details", "enterDetailsInTargetDataset");
				
			}
		} catch (Exception e) {
			
			throw new Exception();
		}

	}
	
	
	
	public void createDBFileRules(DataTestingParameters param) throws Exception
	{

		try {
			enterDetailsInSourceSetting(param);

			switch (param.getRuleType()) {

			case "Checksum":
			case "Recon":

				enterDetailsInTargetDataset(param);

				break;

			default:

				BaseSuite.reportFailLog("None of the Rule type,Kindly check", "createDBFileRules");
				
				break;
			}
		} catch (Exception e) {

			throw new Exception();
		}

	}
	
	
	public DataTestingParameters setRuleParameters(String fileName, String sheetName, int rowNumber) throws Exception
	{
		DataTestingParameters param  = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		
		try {
			
			param.setSourceName(xl.readUsingColName(fileName, sheetName, rowNumber, "SourceName"));
			param.setSourceConnType(xl.readUsingColName(fileName, sheetName, rowNumber, "SourceConnType"));
			param.setSourceInput(xl.readUsingColName(fileName, sheetName, rowNumber, "SourceInput"));
			param.setSourceConnection(xl.readUsingColName(fileName, sheetName, rowNumber, "SourceConnection"));
			param.setSourceSchema(xl.readUsingColName(fileName, sheetName, rowNumber, "SourceSchema"));
			param.setSourceTable(xl.readUsingColName(fileName, sheetName, rowNumber, "SourceTable"));
			param.setSourceAppendOrder(xl.readUsingColName(fileName, sheetName, rowNumber, "SourceAppendOrder"));
			param.setSourecPath(xl.readUsingColName(fileName, sheetName, rowNumber, "SourecPath"));
			param.setSourceQuery(xl.readUsingColName(fileName, sheetName, rowNumber, "SourceQuery"));
			param.setRuleType(xl.readUsingColName(fileName, sheetName, rowNumber, "ruleType"));
			param.setTargetName(xl.readUsingColName(fileName, sheetName, rowNumber, "TargetName"));
			param.setTargetConnType(xl.readUsingColName(fileName, sheetName, rowNumber, "TargetConnType"));
			param.setTargetInput(xl.readUsingColName(fileName, sheetName, rowNumber, "TargetInput"));
			param.setTargetConnection(xl.readUsingColName(fileName, sheetName, rowNumber, "TargetConnection"));
			param.setTargetSchema(xl.readUsingColName(fileName, sheetName, rowNumber, "TargetSchema"));
			param.setTargetTable(xl.readUsingColName(fileName, sheetName, rowNumber, "TargetTable"));
			param.setTargetAppendOrder(xl.readUsingColName(fileName, sheetName, rowNumber, "TargetAppendOrder"));
			param.setTargetPath(xl.readUsingColName(fileName, sheetName, rowNumber, "TargetPath"));
			param.setTargetQuery(xl.readUsingColName(fileName, sheetName, rowNumber, "TargetQuery"));
			
			return param;	
			
		} catch (Exception e) {

					
	
			throw new Exception();
		}
		
	
		
	}

	public static void imageClick()
	{
	    try {
			
			Pattern DesktpIcon = new Pattern("C:\\Users\\DhawalThakre\\Desktop\\sourceDataset.png");
			Screen s= new Screen();
			s.click(DesktpIcon);
			System.out.println("Desktop is Clicked.");
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectSourceConnectionType(String connType)
	{
		try {
			BaseSuite.reportLog("Selecting connection type");
			
			Thread.sleep(1000);
			
			displayAndClick(driver, sourceDatasetConnectionType);
			
			//javascript(driver, "arguments[0].click();", sourceDatasetConnectionType);
			
			displayAndClick(driver, returnElement(sourceDatasetConnectionTypeSelect, "$name", connType));
			
			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
			
			BaseSuite.validationReportLog("Connection type selected successfully");
			
			captureToastMsg(driver, toastMsg, popUpClose, connectionTypeMess, "Connection Type");
			
		} catch (Exception e) {
			
			e.getMessage();
		}
		
		
	}
	
	
	public void selectTargetConnectionType(String connType)
	{
		try {
			BaseSuite.reportLog("Selecting connection type");
			
			Thread.sleep(1000);
			
			displayAndClick(driver, targetDatasetConnectionType);
			
			displayAndClick(driver, returnElement(sourceDatasetConnectionTypeSelect, "$name", connType));
			
			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
			
			BaseSuite.validationReportLog("Connection type selected successfully");
			
			captureToastMsg(driver, toastMsg, popUpClose, connectionTypeMess, "Connection Type");
			
		} catch (Exception e) {
			
			e.getMessage();
		}
		
		
	}
	
	public void selectInput(String input)
	{
		try {
			BaseSuite.reportLog("Clicking on " +input+ " Input radio button");
			
			displayAndClick(driver, returnElement(sourceDatasetInput, "$input", input));
			
			BaseSuite.validationReportLog(input+ " Input radio button clicked successfully");
		} catch (Exception e) {
			
			e.getMessage();
		}
		
	}
	
	
	public void appendOrderBy(String appendOrder)
	{
		try {

			if (!appendOrder.equalsIgnoreCase("Yes")) {
				
				BaseSuite.reportLog("Clicking on Append OrderBy checkbox");

				displayAndClick(driver, appendOrderBy);

				BaseSuite.validationReportLog("Append OrderBy checkbox clicked successfully");

			}
		} catch (Exception e) {

			e.getMessage();
		}

	}
		
	
	
	
	public void selectSourceConnection(String sourceConnection)
	{
		try {
			BaseSuite.reportLog("Selecting " +sourceConnection+ " connection");
			
			javascript(driver, "arguments[0].scrollIntoView(true);", sourceDatasetConnectionClick);
			
			displayAndClick(driver, sourceDatasetConnectionClick);
			
			sendKeys(driver, sourceDatasetConnectionSearch, sourceConnection);
			
			displayAndClick(driver, returnElement(sourceDatasetConnectionSelect, "$name", sourceConnection));
			
			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
			
			BaseSuite.validationReportLog(sourceConnection+ " connection selected successfully");
			
			captureToastMsg(driver, toastMsg, popUpClose, connectionMess, "Connection");
		} catch (Exception e) {
		
			e.getMessage();
		}
		
		
	}
	
	
	
	public void selectTargetConnection(String targetConnection)
	{
		try {
			BaseSuite.reportLog("Selecting " +targetConnection+ " connection");
			
			javascript(driver, "arguments[0].scrollIntoView(true);", targetDatasetConnectionClick);
			
			displayAndClick(driver, targetDatasetConnectionClick);
			
			sendKeys(driver, sourceDatasetConnectionSearch, targetConnection);
			
			displayAndClick(driver, returnElement(sourceDatasetConnectionSelect, "$name", targetConnection));
			
			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
			
			BaseSuite.validationReportLog(targetConnection+ " connection selected successfully");
			
			captureToastMsg(driver, toastMsg, popUpClose, connectionMess, "Connection");
		} catch (Exception e) {
		
			e.getMessage();
		}
		
		
	}
	
	public void selectSchema(String schema)
	{
		try {
			BaseSuite.reportLog("Selecting " +schema+ " schema");
			
			javascript(driver, "arguments[0].scrollIntoView(true);", sourceDatasetSchemaClick);
			
			displayAndClick(driver, sourceDatasetSchemaClick);
			
			sendKeys(driver, SourceDatasetSchemaSearch, schema);
			
			displayAndClick(driver, returnElement(sourceDatasetSchemaSelect, "$name", schema));
			
			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
			
			BaseSuite.validationReportLog(schema+ " schema selected successfully");
			
			captureToastMsg(driver, toastMsg, popUpClose, schemaMess, "Schema");
			
		} catch (Exception e) {
			
			e.getMessage();
		}
		
		
	}
	
	public void selectTable(String table)
	{
		try {
			BaseSuite.reportLog("Selecting " +table+ " Table");
			
			javascript(driver, "arguments[0].scrollIntoView(true);", sourceDatasetTableClick);
			
			displayAndClick(driver, sourceDatasetTableClick);
			
			sendKeys(driver, sourceDatasetTableSearch, table);
			
			displayAndClick(driver, returnElement(sourceDatasetTableSelect, "$name", table));
			
			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
			
			BaseSuite.validationReportLog(table+ " Table selected successfully");
		} catch (Exception e) {
			e.getMessage();
		}
		
		
	}
	
	public void setSqlButton()
	{
		try {
			BaseSuite.reportLog("Clicking on Set SQL button");
			
			displayAndClick(driver, sourceDatasetSetSQLButton);
			
			BaseSuite.validationReportLog("Set SQL button clicked successfully");
		} catch (Exception e) {
			
			e.getMessage();
		}
		
		
	}
	
	public void verifyTableList() throws Exception
	{
		try {
			
			javascript(driver, "arguments[0].scrollIntoView(true);", preview);
			
			List<WebElement> ele = driver.findElements(tableList);
			
			int count = ele.size();
			
			if(count>0)
			{
				
				BaseSuite.validationReportLog("Table list retrive successfully after click on getdata button");
			}
			else
			{
				
				BaseSuite.reportFailLog("Table list not retrive successfully after click on getdata button, kindly check the query", "verifyTableList");
				
			}
		} catch (Exception e) {
			
			throw new Exception();
		}
		
		
	}
	
	public void selectFileType(String fileType) throws Exception
	{
		BaseSuite.reportLog("Selecting " +fileType+ " File Type");
		
		displayAndClick(driver, sourceDatasetSetFileType);
		
		displayAndClick(driver, returnElement(sourceDatasetSetFileTypeSelect, "$name", fileType));
		
		BaseSuite.validationReportLog(fileType+ " File Type selected successfully");
		
		
	}
	
	public void setFileButton()
	{
		try {
			BaseSuite.reportLog("Clicking on Set File button");
			
			displayAndClick(driver, sourceDatasetSetFileButton);
			
			BaseSuite.validationReportLog("Set File button clicked successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void enterDBQuery(By locator,String query)
	{
		BaseSuite.reportLog("Entering Query in query box");
		
		clear_Click_SendKeys(driver, 0, locator, query);
		
		BaseSuite.validationReportLog("Query Entered successfully in query box");
		
		
	}
	
	
	public void connectionSchemaTablePath(By locator,String path)
	{
		try {
			String mess = getAttribute(driver, locator, "value");
			
			
			BaseSuite.validationReportLog("Retrived Message for is :" + mess);
			
			BaseSuite.validationReportLog("Expected Message for is :" + path.trim());
			
			if (!mess.isEmpty()) {
				
				if(mess.trim().equalsIgnoreCase(path.trim())) {
					
					BaseSuite.validationReportLog(" Message Successfully Matched");
				}
				else
				{
					BaseSuite.reportFailLog(" Messages didn't match", "captureLoginMsg");
					
				}
							
			}
			else {
				BaseSuite.reportFailLog(" Messages didn't match", "captureLoginMsg");

			}
		} catch (Exception e) {
		
			e.getMessage();
		}
		
		
	}
	
	public void getData() throws Exception
	{
		try {
			BaseSuite.reportLog("Clicking on Get data button");
			
			javascript(driver, "arguments[0].scrollIntoView(true);", getData);
			
			displayAndClick(driver, getData);
			
			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
			
			BaseSuite.validationReportLog("Get data button clicked successfully");
			
		//	verifyTableList();
		} catch (Exception e) {
		
			throw new Exception();
		}
	}
	
	public void cancleButton()
	{
		try {
			BaseSuite.reportLog("Clicking on Cancle button");
			
			displayAndClick(driver, cancleButton);
			
			BaseSuite.validationReportLog("Cancle button clicked successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dataButton(By locator)
	{
		try {
			BaseSuite.reportLog("Clicking on Source Dataset Data button");
			
			displayAndClick(driver, locator);
			
			BaseSuite.validationReportLog("Source Dataset Data button clicked successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String testButton(By locator)
	{String mess = null;
		try {
			
			
			BaseSuite.reportLog("Clicking on Test button");
			
			displayAndClick(driver, locator);
			
			BaseSuite.reportLog("Test button clicked successfully");
			
			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
			
			mess = getText(driver, toastMsg);
			
			captureToastMsg(driver, toastMsg, popUpClose, connectionTestMess, "Connection Test");
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mess;
	}
	
	public void getFiles(String fileFolderName,String fileName)
	{
		try {
			BaseSuite.reportLog("Clicking on Get Files button");
			
			displayAndClick(driver, getFile);
			
			BaseSuite.reportLog("Get Files button clicked successfully");
			
			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
			
			javascript(driver, "arguments[0].scrollIntoView(true);", returnElement(selectFileFolder, "$name", fileFolderName));
			
			BaseSuite.reportLog("Clicking on "+fileFolderName+" Folder to select file");
			
			displayAndClick(driver, returnElement(selectFileFolder, "$name", fileFolderName));
			
			BaseSuite.reportLog(fileFolderName+" Folder clicked successfully to select file");
			
			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
			
			javascript(driver, "arguments[0].scrollIntoView(true);", returnElement(selectFile, "$name", fileName));
			
			BaseSuite.reportLog("Clicking on "+fileName+" File from " +fileFolderName+ " Folder");
			
			displayAndClick(driver, returnElement(selectFile, "$name", fileName));
			
			BaseSuite.reportLog(fileName+" File from " +fileFolderName+ " Folder selected successfully");
			
			javascript(driver, "arguments[0].scrollIntoView(true);", selectBottom);
			
			BaseSuite.reportLog("Clicking on Select button");
			
			displayAndClick(driver, selectBottom);
			
			BaseSuite.reportLog("Select button clicked successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void addJoins(String joinColName) throws Exception {

		//isDisplayedInLoop(driver, 10, SourceConnSelectValue);
		
		clickOnDiffJoin();
		
		Thread.sleep(2000);

		if (!joinColName.isEmpty()) {

			int count = getcount(joinColName, ',');

			String[] result = joinColName.split(",");

			for (int colNum = 0; colNum <= count; colNum++) {

				String joinCol1 = result[colNum];

				String[] joins = joinCol1.split("=");

				String sourceJoin = joins[0];

				String targetJoin = joins[1];

				if (!sourceJoin.isEmpty() || !targetJoin.isEmpty()) {
					
					javascript(driver, "arguments[0].scrollIntoView(true);", returnElement(joinSourceColName, "$name", sourceJoin));
					
					BaseSuite.reportLog("Applying join on source and target side");
					
					dragAndDrop(driver, returnElement(joinSourceColName, "$name", sourceJoin), 
							returnElement(joinTargetColName, "$name", targetJoin));
					
					BaseSuite.validationReportLog("Join successfully applied on source "+sourceJoin+ " column and " +targetJoin+ " target column"); 

				}
			}
		}
	}
	
	
	public void joinAll()
	{
		try {
			BaseSuite.reportLog("Clicking on ConnectAll button");
			
			displayAndClick(driver, diffJoinConnectAll);
			
			BaseSuite.validationReportLog("ConnectAll button clicked successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void disconnectAll()
	{
		try {
			BaseSuite.reportLog("Clicking on DisconnectAll button");
			
			displayAndClick(driver, diffJoinDisConnectAll);
			
			BaseSuite.validationReportLog("DisconnectAll button clicked successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void addAllAsExpression()
	{
		try {
			BaseSuite.reportLog("Clicking on Add All As Expression button");
			
			displayAndClick(driver, diffJoinDisConnectAll);
			
			BaseSuite.validationReportLog("Add All As Expression button clicked successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	


//====================================Connection Repo Code================================================//
	
	
	
	public void verifyUserAbleToChangeTheRuleStateFromValidatePublishedToDraft(String ruleName,SoftAssert soft) throws Throwable
	{
		try {
			DataTestingPage dt = new DataTestingPage(driver);
			
			if (!ruleName.isEmpty()) {
				int count = getcount(ruleName, ',');

				String[] result = ruleName.split(",");

				for (int colNum = 0; colNum <= count; colNum++) {

					String name = result[colNum];

					dt.clickOnSearchedRuleNameOnDataTestingPage("",name, soft);
					
					dt.clickOnRulePublishMenuListIconBtn();
					
					dt.clickOnDraftMenuOptionBtn();
					if(colNum == 0)
					{
						dt.clickOnPublishButton();
					}
					else
					{
						dt.clickOnRulePublishMenuListIconBtn();
						
						dt.clickOnValidateMenuOptionBtn();
						
					}
					
					dt.clickOnNextGenMenuTab("Data Testing");

				}
				
			}
			
		} catch (Exception e) {
			
			throw new AssertionError("Test case failed due to isssue/Bug,Kindly check report");
		}
		
		
		
	}
	
	public void verifyUserAbleToChangeTheRuleStateFromDraftPublishedToValidate(String ruleName,SoftAssert soft) throws Throwable
	{
		try {
			DataTestingPage dt = new DataTestingPage(driver);
			
			if (!ruleName.isEmpty()) {
				int count = getcount(ruleName, ',');

				String[] result = ruleName.split(",");

				for (int colNum = 0; colNum <= count; colNum++) {

					String name = result[colNum];

					dt.clickOnSearchedRuleNameOnDataTestingPage("",name, soft);
					
					dt.clickOnRulePublishMenuListIconBtn();
					
					if(colNum == 0)
					{
						dt.clickOnValidateMenuOptionBtn();
						
						dt.clickOnRulePublishMenuListIconBtn();
						
						dt.clickOnDraftMenuOptionBtn();
					}
					else
					{
						dt.clickOnValidateMenuOptionBtn();
						
						dt.clickOnPublishButton();
						
					}
					
					dt.clickOnNextGenMenuTab("Data Testing");

				}
				
			}
			
		} catch (Exception e) {
			
			throw new AssertionError("Test case failed due to isssue/Bug,Kindly check report");
		}
		
		
		
	}
	
	
	public void verifyUserAbleToChangeTheRuleStateFromDraftValidateToPublished(String ruleName,SoftAssert soft) throws Throwable
	{
		try {
			DataTestingPage dt = new DataTestingPage(driver);
			
			if (!ruleName.isEmpty()) {
				int count = getcount(ruleName, ',');

				String[] result = ruleName.split(",");

				for (int colNum = 0; colNum <= count; colNum++) {

					String name = result[colNum];

					dt.clickOnSearchedRuleNameOnDataTestingPage("",name, soft);
					
					dt.clickOnPublishButton();
					
					if(colNum == 0)
					{
						dt.clickOnRulePublishMenuListIconBtn();
						
						dt.clickOnDraftMenuOptionBtn();
					}
					else
					{
						dt.clickOnRulePublishMenuListIconBtn();
						
						dt.clickOnValidateMenuOptionBtn();
					}
					
					dt.clickOnNextGenMenuTab("Data Testing");

				}
				
			}
			
		} catch (Exception e) {
			
			throw new AssertionError("Test case failed due to isssue/Bug,Kindly check report");
		}
	
	}
	
	
	public void createVlidationRuleUsingDirectOptionForExecutiorReaderGrant()
	{
		try {
			DataTestingPage dt = new DataTestingPage(driver);
			
			dt.clickOnNewRule();
			
			if(isDisplayed(driver, toastMsg))
			{
				captureToastMsg(driver, toastMsg, popUpClose, connectionTestMess, "Executior/Reader User");

			}
			else
			{
				BaseSuite.reportFailLog("Toast message not visible kindly check - issue id - DAT-2732",
						"clickOnNewRuleUserSpecific");
				isDisplayedInLoop(driver, 2, newRuleCancelBtn);
				displayAndClick(driver, newRuleCancelBtn);
				throw new AssertionError("Test case failed!");
			}
			
		} catch (Exception e) {
			
			e.getMessage();
		
		}
		
	}
	
	public void createVlidationRuleForAdminGrant()
	{
		try {
			if(isDisplayed(driver, toastMsg))
			{
				captureToastMsg(driver, toastMsg, popUpClose, connectionTestMess, "Executior/Reader User");

			}
			else
			{
				BaseSuite.reportFailLog("Toast message not visible kindly check - issue id - DAT-2732",
						"clickOnNewRuleUserSpecific");
				isDisplayedInLoop(driver, 2, newRuleCancelBtn);
				displayAndClick(driver, newRuleCancelBtn);
				throw new AssertionError("Test case failed!");
			}
			
		} catch (Exception e) {
			
			e.getMessage();
		}
		
	}
	
	
	public void createValidationRuleForDataBaseConnectionUsingDirectOption(String icedqRoleName,String ruleName,String workspaceID,SoftAssert soft) throws Throwable
	{
		try {
			DataTestingPage rule = new DataTestingPage(driver);
			
			TestDataThroughApi data = new TestDataThroughApi(driver);

			String ruleID = data.getRuleIDFromRuleName(ruleName, workspaceID,icedqRoleName);

			String ruleJson = data.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,icedqRoleName);

			data.sourceAddColumn(ruleJson);

			String ruleType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson, "$.ruleType");
			
			rule.clickOnNextGenMenuTab("Connections");

			List<String> connectionList = data.createConnection(ruleType, ruleJson, workspaceID,
					"$.objects..connectionId", soft,icedqRoleName);

			DataTestingParameters param = data.setRuleParametersForApi(workspaceID, ruleJson,icedqRoleName);
			
			rule.clickOnNextGenMenuTab("Data Testing");
			
			rule.verifyDataTestingLandingPage();

			//rule.clickOnAddNewFolderOrExistingOneAPI(param,workspaceID,ruleJson,icedqRoleName);

			//rule. enterDetailsInAddNewPaneAPI(param,workspaceID,ruleName,icedqRoleName);
			  
			//rule.enterDetailsInOverviewSection(param);
			
			rule.enterDetailsInAdvancedSettingOfOverviewSection(param);

			
			//rule.enterDetailsInSourceSetting(ruleJson,param,soft);

			//rule.validateColumnNameNColumnDataType(param, ruleJson, "source", soft);
			
			DataTestingParameters xrparam = rule.setExceptionReportParametersUsingApi(ruleJson,ruleType);

			rule.clickOnCheckNode1();
			
			data.addChecksToRule(ruleJson, param, soft);

			ArrayList<String> checksdetails1 = data.getCheckDetailsFromCheckSection();

			rule.clickOnExceptionReportNode();

			//rule.validateExceptionReportTab();

			rule.selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

			//rule.enableStoreFailureAndErrorsOnly(xrparam.getStoreFailureAndErrors(), soft);

			rule.selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

			rule.validateResultTypeOnExceptionReport(ruleJson,"$.objects[1].configuration.checks[0].expression.values.*");

			//rule.validateExpression(checksdetails1, soft);
			
			rule.clickOnPublishButton();
			
			rule.clickOnNextGenMenuTab("Data Testing");

		} catch (Exception e) {

			throw new AssertionError("Test case failed due to isssue/Bug,Kindly check report");
		}

	}
	
	
	
	public void createAndRunValidationRuleForDataBaseConnection(String icedqRoleName, String ruleName,
			String workspaceID,SoftAssert soft) throws Throwable	{
		try {
			DataTestingPage rule = new DataTestingPage(driver);
			
			TestDataThroughApi data = new TestDataThroughApi(driver);

			String ruleID = data.getRuleIDFromRuleName(ruleName, workspaceID,icedqRoleName);

			String ruleJson = data.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,icedqRoleName);

			data.sourceAddColumn(ruleJson);

			String ruleType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson, "$.ruleType");
			
			rule.clickOnNextGenMenuTab("Connections");

			List<String> connectionList = data.createConnection(ruleType, ruleJson, workspaceID,
					"$.objects..connectionId", soft,icedqRoleName);

			DataTestingParameters param = data.setRuleParametersForApi(workspaceID, ruleJson,icedqRoleName);
			
			rule.clickOnNextGenMenuTab("Data Testing");
			
			rule.verifyDataTestingLandingPage();

			//rule.clickOnAddNewFolderOrExistingOneAPI(param,workspaceID,ruleJson,icedqRoleName);

			//rule. enterDetailsInAddNewPaneAPI(param,workspaceID,ruleName,icedqRoleName);
			  
			//rule.enterDetailsInOverviewSection(param);
			
			rule.enterDetailsInAdvancedSettingOfOverviewSection(param);
			
			//rule.enterDetailsInSourceSetting(ruleJson,param,soft);

			rule.validateColumnNameNColumnDataType(param, ruleJson, "source", soft);
			
			DataTestingParameters xrparam = rule.setExceptionReportParametersUsingApi(ruleJson,ruleType);

			rule.clickOnCheckNode1();
			
			data.addChecksToRule(ruleJson, param, soft);

			ArrayList<String> checksdetails1 = data.getCheckDetailsFromCheckSection();

			rule.clickOnExceptionReportNode();
			

			//rule.validateExceptionReportTab();

			rule.selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

			//rule.enableStoreFailureAndErrorsOnly(xrparam.getStoreFailureAndErrors(), soft);

			rule.selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

			rule.validateResultTypeOnExceptionReport(ruleJson,"$.objects[1].configuration.checks[0].expression.values.*");

			//rule.validateExpression(checksdetails1, soft);
			
			rule.clickOnRulePublishMenuListIconBtn();
			
			rule.clickOnPublishButton();
			
			//rule.clickOnRunButton();
			
			//rule.clickOnRecentRunTab_RefreshIcon();
			
			//rule.checkStatusOfRunningRule();
			
			rule.clickOnExecutionLogButton();
			
			//rule.printExecutionLogDetails();
			
			if (!param.getRuleType().toLowerCase().contains("checksum") || !ruleType.equalsIgnoreCase("script")) {
				
				//rule.checkExceptionSummary("xlsx", BaseSuite.WorkspaceID, "Export All", "Download All", soft,icedqRoleName);
			}
			
			rule.clickOnNextGenMenuTab("Data Testing");

		} catch (Exception e) {

			throw new AssertionError("Test case failed due to isssue/Bug,Kindly check report");
		}

	}
	
	
	public void searchAndRunValidationRuleForDataBaseConnection(String icedqRoleName, String ruleName,SoftAssert soft) throws Throwable	{
		try {
			DataTestingPage rule = new DataTestingPage(driver);
			
			TestDataThroughApi data = new TestDataThroughApi(driver);
			
			boolean flag = rule.clickOnSearchedRuleNameOnDataTestingPage("",ruleName, soft);
			
			if(flag) {
				
				Thread.sleep(2000);
				
				//rule.clickOnRunButton();
				
				//rule.clickOnRecentRunTab_RefreshIcon();
				
				//rule.checkStatusOfRunningRule();
				
				rule.clickOnExecutionLogButton();
				
				//rule.printExecutionLogDetails();
				
				//rule.checkExceptionSummary("xlsx", BaseSuite.WorkspaceID, "Export All", "Download All", soft,icedqRoleName);
				
			}else {
				
				throw new AssertionError("Searched rule not found hence these test is failed, kindly check");
			}
			
			
			
		} catch (Exception e) {

			throw new AssertionError("Test case failed due to isssue/Bug,Kindly check report");
		}

	}
	
	
	public void clearButonFunctionalityOnCalculatedColumnPane(String icedqRoleName, String ruleName,
			String workspaceID,SoftAssert soft) throws Throwable
	{
		try {
			DataTestingPage rule = new DataTestingPage(driver);
			
			TestDataThroughApi data = new TestDataThroughApi(driver);

			String ruleID = data.getRuleIDFromRuleName(ruleName, workspaceID,icedqRoleName);

			String ruleJson = data.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,icedqRoleName);

			data.sourceAddColumn(ruleJson);

			String ruleType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson, "$.ruleType");
			
			DataTestingParameters param = data.setRuleParametersForApi(workspaceID,ruleJson,icedqRoleName);
			
			rule.verifyDataTestingLandingPage();

			//rule.clickOnAddNewFolderOrExistingOneAPI(param,workspaceID,ruleJson,icedqRoleName);

			//rule. enterDetailsInAddNewPaneAPI(param,workspaceID,ruleName,icedqRoleName);
			  
			//rule.enterDetailsInOverviewSection(param);
			
			rule.enterDetailsInAdvancedSettingOfOverviewSection(param);
			
			//rule.enterDetailsInSourceSetting(ruleJson,param,soft);

			rule.validateColumnNameNColumnDataType(param, ruleJson, "source", soft);
	
			rule.clickOnCheckNode1();
			
			rule.clickOnAddButtonSideMenu();
			
			rule.clickOnAddColumnMenuOption();
			
			BaseSuite.reportLog("Clicking on Calculated Tab");
			
			displayAndClick(driver, calculatedTab);
			
			BaseSuite.validationReportLog("Calculated Tab clicked successfully");
			
			BaseSuite.reportLog("Clicking on Source dropdown");
			
			displayAndClick(driver, returnElement(chooseAttribute, "$name", "Source"));
			
			displayAndClick(driver, returnElement(chooseAttribute, "$name", "Source"));
			
			BaseSuite.validationReportLog("Source dropdown clicked successfully");

			Thread.sleep(2000);
			
			BaseSuite.reportLog("Clicking on Source column name");
			
			displayAndClick(driver, returnElement(columnNameClick, "$name", "Source"));
			
			BaseSuite.validationReportLog("Source column name clicked successfully");
			
			BaseSuite.reportLog("Entering value in expression box");
			
			sendKeys(driver, expressionBox, "null");
			
			BaseSuite.validationReportLog("Value entered successfully in expression box");
			
			BaseSuite.reportLog("Clicking on Clear button");
			
			displayAndClick(driver, expressionBoxClear);
			
			BaseSuite.validationReportLog("Clear button clicked successfully");
			
			String val1 = getAttribute(driver, expressionBox, "value");
			
			if(val1.isEmpty())
			{
				BaseSuite.validationReportLog("Clear button functionality is working properly after clicked on clear button");
			}
			else
			{
				BaseSuite.reportFailLog("Clear button functionality is not working properly after clicked on clear button", "");
			}
			BaseSuite.reportLog("Clicking on Cancle button");
		
			displayAndClick(driver, cancelBtn);
			
			BaseSuite.validationReportLog("Cancle button clicked successfully");
		
			
		} catch (Exception e) {
			
			e.getMessage();
		}

		
	}
	
	public void createNewAndExsisitngRuleUsingReaderGrant(String ruleName,SoftAssert soft)
	{
		try {
			DataTestingPage rule = new DataTestingPage(driver);
			
			//createVlidationRuleUsingDirectOptionForExecutiorReaderGrant();
			
			boolean flag = rule.clickOnSearchedRuleNameOnDataTestingPage("",ruleName, soft);
			
			if(flag) {
				
				Thread.sleep(2000);
				
				//rule.clickOnRunButton();
				
				captureToastMsg(driver, toastMsg, popUpClose, readerMessage, "Executior/Reader User");
			}else {
				
				throw new AssertionError("Searched rule not found hence these test is failed, kindly check");
			}
		} catch (Exception e) {
			
			e.getMessage();
		}
	}
	
	public void createValidationRuleForDataBaseConnectionWithoutExp(String icedqRoleName, String ruleName,
			String workspaceID,SoftAssert soft) throws Throwable	{
		try {
			DataTestingPage rule = new DataTestingPage(driver);
			
			TestDataThroughApi data = new TestDataThroughApi(driver);

			String ruleID = data.getRuleIDFromRuleName(ruleName, workspaceID,icedqRoleName);

			String ruleJson = data.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,icedqRoleName);

			data.sourceAddColumn(ruleJson);

			String ruleType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson, "$.ruleType");
			
			DataTestingParameters param = data.setRuleParametersForApi(workspaceID, ruleJson,icedqRoleName);
			
			rule.verifyDataTestingLandingPage();

			//rule.clickOnAddNewFolderOrExistingOneAPI(param,workspaceID,ruleJson,icedqRoleName);

		//	rule. enterDetailsInAddNewPaneAPI(param,workspaceID,ruleName,icedqRoleName);
			  
			//rule.enterDetailsInOverviewSection(param);
			
			rule.enterDetailsInAdvancedSettingOfOverviewSection(param);
			
			//rule.enterDetailsInSourceSetting(ruleJson,param,soft);

			rule.validateColumnNameNColumnDataType(param, ruleJson, "source", soft);
			
			DataTestingParameters xrparam = rule.setExceptionReportParametersUsingApi(ruleJson,ruleType);

			rule.clickOnCheckNode1();
			
			data.addChecksToRule(ruleJson, param, soft);

			ArrayList<String> checksdetails1 = data.getCheckDetailsFromCheckSection();

			rule.clickOnExceptionReportNode();

			//rule.validateExceptionReportTab();

			rule.selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

			//rule.enableStoreFailureAndErrorsOnly(xrparam.getStoreFailureAndErrors(), soft);

			rule.selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

			rule.validateResultTypeOnExceptionReport(ruleJson,"$.objects[1].configuration.checks[0].expression.values.*");

			//rule.validateExpression(checksdetails1, soft);
			
			rule.clickOnRulePublishMenuListIconBtn();
			
			rule.clickOnDraftMenuOptionBtn();
			
			rule.clickOnRulePublishMenuListIconBtn();
			
			rule.clickOnValidateMenuOptionBtn(rule.expNtAddedMsg);
			
			rule.clickOnPublishButton(rule.expNtAddedMsg);
			
		} catch (Exception e) {

			throw new AssertionError("Test case failed due to isssue/Bug,Kindly check report");
		}

	}
	
	
	public void userDirectedToSourceSettingTabAfterClickingOnCancelButtonFromDataTab(String ruleName,SoftAssert soft)
	{
		try {
			DataTestingPage rule = new DataTestingPage(driver);
			
			//createVlidationRuleUsingDirectOptionForExecutiorReaderGrant();
			
			boolean flag = rule.clickOnSearchedRuleNameOnDataTestingPage("",ruleName, soft);
			
			if(flag) {
				
				rule.clickOnSourceDataset();
				
				displayAndClick(driver, rule.sourceFileDataButton);
				
				displayAndClick(driver, vaalidationCancleButton);
				
				isDisplayedInLoop(driver, 10, vaalidationCancleButton);
				
				javascript(driver, "arguments[0].click();", vaalidationCancleButton);
				
				if(isDisplayed(driver, connectionTypeLabel) && isDisplayed(driver, connectionLabel))
				{
					BaseSuite.validationReportLog("User directed to 'SourceSetting' tab after clicking on 'Cancel' button from 'Data' tab.");
				}
				else
				{
					BaseSuite.reportFailLog("User not directed to 'SourceSetting' tab after clicking on 'Cancel' button from 'Data' tab.", "");

				}
				
			}else {
				
				throw new AssertionError("Searched rule not found hence these test is failed, kindly check");
			}
		} catch (Exception e) {
			
			e.getMessage();
		}
		
		
	}
	
	
	public void getDataFunctionality(String ruleName,String roleName,SoftAssert soft)
	{
		try {
			DataTestingPage rule = new DataTestingPage(driver);
			
			//createVlidationRuleUsingDirectOptionForExecutiorReaderGrant();
			
			boolean flag = rule.clickOnSearchedRuleNameOnDataTestingPage("",ruleName, soft);
			
			if(flag) {
				
				rule.clickOnSourceDataset();
				
				displayAndClick(driver, rule.sourceFileDataButton);
				
				isDisplayedInLoop(driver, 10, vaalidationCancleButton);
				
				BaseSuite.reportLog("Entering Query in query box");

				javascript(driver, "arguments[0].scrollIntoView(true);", rule.sourceDatasetButton);

				Thread.sleep(2000);

				verifyVisibilityOfButtons(driver, rule.sourcegetData, "Preveiw Button", true);
				
				
				
				if(roleName.equalsIgnoreCase("workspace_reader") || roleName.equalsIgnoreCase("account_reader"))
				{
					//rule.getData(rule.sourcegetData);
					
					captureToastMsg(driver, toastMsg, popUpClose, rule.errorMessage, "Preview Data");
				
				}
				
				else
				{
					//rule.getData(rule.sourcegetData);
					
				}
				
			}else {
				
				throw new AssertionError("Searched rule not found hence these test is failed, kindly check");
			}
		} catch (Exception e) {
			
			e.getMessage();
		}
		
		
	}
	
	
	public void getDataFunctionalityForContributorOwner(String icedqRoleName, String ruleName,
			String workspaceID,SoftAssert soft) throws Throwable
	{
		try {
			
			TestDataThroughApi data = new TestDataThroughApi(driver);
			
			DataTestingPage rule = new DataTestingPage(driver);

			String ruleID = data.getRuleIDFromRuleName(ruleName, workspaceID,icedqRoleName);

			String ruleJson = data.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,icedqRoleName);

			data.sourceAddColumn(ruleJson);

			DataTestingParameters param = data.setRuleParametersForApi(workspaceID, ruleJson,icedqRoleName);
			
			rule.verifyDataTestingLandingPage();

			//rule.clickOnAddNewFolderOrExistingOneAPI(param,workspaceID,ruleJson,icedqRoleName);

			//rule. enterDetailsInAddNewPaneAPI(param,workspaceID,ruleName,icedqRoleName);
			  
			//rule.enterDetailsInOverviewSection(param);
			
			rule.enterDetailsInAdvancedSettingOfOverviewSection(param);
			
			//rule.enterDetailsInSourceSetting(ruleJson,param,soft);
			
			
			
		} catch (Exception e) {
			
			e.getMessage();
		}
		
		
	}
	
	
	public void tableViewDropDownFunctionality(String ruleName,String roleName,SoftAssert soft)
	{
		try {
			DataTestingPage rule = new DataTestingPage(driver);
			
			//createVlidationRuleUsingDirectOptionForExecutiorReaderGrant();
			
			boolean flag = rule.clickOnSearchedRuleNameOnDataTestingPage("",ruleName, soft);
			
			XLUtils xlReader = new XLUtils();
			
			String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

			String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, BaseSuite.SourceConnection);
			
			String table = loginDetails[2];
			
			if(flag) {
				
				rule.clickOnSourceDataset();
				
				
				BaseSuite.reportLog("Selecting " + table + " Table");

				javascript(driver, "arguments[0].scrollIntoView(true);", rule.sourceDatasetTableClick);

				isDisplayedInLoop(driver, 10, rule.sourceDatasetTableClick);

				isDisplayedInLoop(driver, 10, rule.sourceDatasetTableClick);

				displayAndClick(driver, rule.sourceDatasetTableClick);
				
				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
				
				if(roleName.equalsIgnoreCase("workspace_reader") || roleName.equalsIgnoreCase("account_reader"))
				{
					captureToastMsg(driver, toastMsg, popUpClose, rule.errorMessage, "Table/View");
				
				}
				
				else
				{
					

					Actions actions = new Actions(driver);

					wait = waitMethod(driver);

					actions.moveToElement(driver.findElement(rule.dropDownBox1)).clickAndHold().build().perform();

					isDisplayedInLoop(driver, 10, sourceDatasetTableSearch);

					sendKeys(driver, sourceDatasetTableSearch, table);

					isDisplayedInLoop(driver, 10, returnElement(sourceDatasetTableSelect, "$name", table));

					displayAndClick(driver, returnElement(sourceDatasetTableSelect, "$name", table));

					inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

					BaseSuite.validationReportLog(table + " Table selected successfully");;
					
				}
				
			}else {
				
				throw new AssertionError("Searched rule not found hence these test is failed, kindly check");
			}
		} catch (Exception e) {
			
			e.getMessage();
		}
		
		
	}
	
	
	public void tableViewDropDownFunctionalityContributorOwner(String icedqRoleName, String ruleName,
			String workspaceID,SoftAssert soft) throws Throwable
	{
		try {
			
			XLUtils xlReader = new XLUtils();
			
			TestDataThroughApi data = new TestDataThroughApi(driver);
			
			DataTestingPage rule = new DataTestingPage(driver);

			String ruleID = data.getRuleIDFromRuleName(ruleName, workspaceID,icedqRoleName);

			String ruleJson = data.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,icedqRoleName);

			data.sourceAddColumn(ruleJson);

			DataTestingParameters param = data.setRuleParametersForApi(workspaceID, ruleJson,icedqRoleName);
			
			rule.verifyDataTestingLandingPage();

			//rule.clickOnAddNewFolderOrExistingOneAPI(param,workspaceID,ruleJson,icedqRoleName);

			//rule. enterDetailsInAddNewPaneAPI(param,workspaceID,ruleName,icedqRoleName);
			  
			//rule.enterDetailsInOverviewSection(param);
			
			rule.enterDetailsInAdvancedSettingOfOverviewSection(param);
			
			String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

			String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, BaseSuite.SourceConnection);

			String connName = loginDetails[0];

			String schema = loginDetails[1];
		
			String table = loginDetails[2];
			
			rule.clickOnSourceDataset();
			
			rule.selectSourceConnectionType(param.getSourceConnType());

			rule.selectSourceConnection(connName);

			//rule.selectInput(sourceDatasetInput, param.getSourceInput());

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
			
			String connTestMess = testButton(sourceDatasetTestButton);

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
			
			if (connTestMess.trim().equalsIgnoreCase(connectionTestMess.trim())) {
				
				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				if (param.getSourceConnType().equalsIgnoreCase("Database")) {

					if (param.getSourceInput().equalsIgnoreCase("Table")) {

						rule.selectSchema(sourceDatasetSchemaClick, schema);

						rule.selectTable(sourceDatasetTableClick, table);
					
					} else {

						rule.setCustomSqlButton(sourceDatasetSetSQLButton);
					}
				}
			}
			else {
				BaseSuite.reportFailLog(
						"Not able to create a rule because connection details is invalid, kindly check the connection details",
						"enterDetailsInSourceSetting");
				throw new AssertionError("Not able to create a rule because connection details is invalid , kindly check");
			}
			
		} catch (Exception e) {
			
			e.getMessage();
		}
		
		
	}
	
	

	public void schemaFieldDropDownFunctionality(String ruleName,String roleName,SoftAssert soft) throws Throwable
	{
		try {
			DataTestingPage rule = new DataTestingPage(driver);
			
			boolean flag = rule.clickOnSearchedRuleNameOnDataTestingPage("",ruleName, soft);
			
			XLUtils xlReader = new XLUtils();
			
			String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

			String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, BaseSuite.SourceConnection);

			String connName = loginDetails[0];
			
			String schema = loginDetails[1];
			
			if(flag) {
				
				rule.clickOnSourceDataset();
				
				if(!(roleName.equalsIgnoreCase("workspace_reader") || roleName.equalsIgnoreCase("account_reader")))
				{
					rule.selectSourceConnection(connName);
				}
				
				BaseSuite.reportLog("Selecting " + schema + " schema");

				javascript(driver, "arguments[0].scrollIntoView(true);", rule.sourceDatasetSchemaClick);

				isDisplayedInLoop(driver, 10, rule.sourceDatasetSchemaClick);

				isDisplayedInLoop(driver, 10, rule.sourceDatasetSchemaClick);

				displayAndClick(driver, rule.sourceDatasetSchemaClick);
				
				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
				
				if(roleName.equalsIgnoreCase("workspace_reader") || roleName.equalsIgnoreCase("account_reader"))
				{
					captureToastMsg(driver, toastMsg, popUpClose, rule.errorMessage, "Table/View");
				
				}
				
				else
				{
					

					Actions actions = new Actions(driver);

					wait = waitMethod(driver);

					actions.moveToElement(driver.findElement(rule.dropDownBox1)).clickAndHold().build().perform();

					isDisplayedInLoop(driver, 10, SourceDatasetSchemaSearch);

					sendKeys(driver, SourceDatasetSchemaSearch, schema);

					isDisplayedInLoop(driver, 10, returnElement(sourceDatasetSchemaSelect, "$name", schema));

					displayAndClick(driver, returnElement(sourceDatasetSchemaSelect, "$name", schema));

					inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

					BaseSuite.validationReportLog(schema + " schema selected successfully");
					
				}
				
			}else {
				
				throw new AssertionError("Searched rule not found hence these test is failed, kindly check");
			}
		} catch (Exception e) {
			
			e.getMessage();
		}
		
		
	}
	
	
	public void schemaDropDownFunctionalityContributorOwner(String icedqRoleName, String ruleName,
			String workspaceID,SoftAssert soft) throws Throwable
	{
		try {
			
			XLUtils xlReader = new XLUtils();
			
			TestDataThroughApi data = new TestDataThroughApi(driver);
			
			DataTestingPage rule = new DataTestingPage(driver);

			String ruleID = data.getRuleIDFromRuleName(ruleName, workspaceID,icedqRoleName);

			String ruleJson = data.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,icedqRoleName);

			data.sourceAddColumn(ruleJson);

			DataTestingParameters param = data.setRuleParametersForApi(workspaceID, ruleJson,icedqRoleName);
			
			rule.verifyDataTestingLandingPage();

			//rule.clickOnAddNewFolderOrExistingOneAPI(param,workspaceID,ruleJson,icedqRoleName);

			//rule. enterDetailsInAddNewPaneAPI(param,workspaceID,ruleName,icedqRoleName);
			  
			//rule.enterDetailsInOverviewSection(param);
			
			rule.enterDetailsInAdvancedSettingOfOverviewSection(param);
			
			String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

			String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, BaseSuite.SourceConnection);

			String connName = loginDetails[0];

			String schema = loginDetails[1];
		
			String table = loginDetails[2];
			
			rule.clickOnSourceDataset();
			
			rule.selectSourceConnectionType(param.getSourceConnType());

			rule.selectSourceConnection(connName);

			//rule.selectInput(sourceDatasetInput, param.getSourceInput());

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
			
			String connTestMess = testButton(sourceDatasetTestButton);

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
			
			if (connTestMess.trim().equalsIgnoreCase(connectionTestMess.trim())) {
				
				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				if (param.getSourceConnType().equalsIgnoreCase("Database")) {

					if (param.getSourceInput().equalsIgnoreCase("Table")) {

						rule.selectSchema(sourceDatasetSchemaClick, schema);
					
					} else {

						rule.setCustomSqlButton(sourceDatasetSetSQLButton);
					}
				}
			}
			else {
				BaseSuite.reportFailLog(
						"Not able to create a rule because connection details is invalid, kindly check the connection details",
						"enterDetailsInSourceSetting");
				throw new AssertionError("Not able to create a rule because connection details is invalid , kindly check");
			}
			
		} catch (Exception e) {
			
			e.getMessage();
		}
		
		
	}
	
	
	public void testFunctionality(String ruleName,String roleName,SoftAssert soft)
	{
		try {
			DataTestingPage rule = new DataTestingPage(driver);
			
			//createVlidationRuleUsingDirectOptionForExecutiorReaderGrant();
			
			boolean flag = rule.clickOnSearchedRuleNameOnDataTestingPage("",ruleName, soft);
		
			
			if(flag) {
				
				rule.clickOnSourceDataset();
				
				rule.testButton(sourceDatasetTestButton);

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
				
				
				if(roleName.equalsIgnoreCase("workspace_reader") || roleName.equalsIgnoreCase("account_reader"))
				{
					captureToastMsg(driver, toastMsg, popUpClose, rule.errorMessage, "Table/View");
				
				}
				
				else
				{
					
					captureToastMsg(driver, toastMsg, popUpClose, rule.connectionTestMess, "Connection Test Message");
					
				}
				
			}else {
				
				throw new AssertionError("Searched rule not found hence these test is failed, kindly check");
			}
		} catch (Exception e) {
			
			e.getMessage();
		}
		
		
	}
	
	
	public void testButtonFunctionalityContributorOwner(String icedqRoleName, String ruleName,
			String workspaceID,SoftAssert soft) throws Throwable
	{
		try {
			
			XLUtils xlReader = new XLUtils();
			
			TestDataThroughApi data = new TestDataThroughApi(driver);
			
			DataTestingPage rule = new DataTestingPage(driver);

			String ruleID = data.getRuleIDFromRuleName(ruleName, workspaceID,icedqRoleName);

			String ruleJson = data.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,icedqRoleName);

			data.sourceAddColumn(ruleJson);

			DataTestingParameters param = data.setRuleParametersForApi(workspaceID, ruleJson,icedqRoleName);
			
			rule.verifyDataTestingLandingPage();

			//rule.clickOnAddNewFolderOrExistingOneAPI(param,workspaceID,ruleJson,icedqRoleName);

			//rule. enterDetailsInAddNewPaneAPI(param,workspaceID,ruleName,icedqRoleName);
			  
			//rule.enterDetailsInOverviewSection(param);
			
			rule.enterDetailsInAdvancedSettingOfOverviewSection(param);
			
			String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

			String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, BaseSuite.SourceConnection);

			String connName = loginDetails[0];

			rule.clickOnSourceDataset();
			
			rule.selectSourceConnectionType(param.getSourceConnType());

			rule.selectSourceConnection(connName);

			rule.testButton(sourceDatasetTestButton);

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
			
		} catch (Exception e) {
			
			e.getMessage();
		}
		
		
	}
	
	
	public void editFunctionality(String ruleName,String roleName,SoftAssert soft)
	{
		try {
			DataTestingPage rule = new DataTestingPage(driver);

			// createVlidationRuleUsingDirectOptionForExecutiorReaderGrant();

			boolean flag = rule.clickOnSearchedRuleNameOnDataTestingPage("",ruleName, soft);

			if (flag) {

				rule.clickOnSourceDataset();
				
				String val = getAttribute(driver, rule.connection, "aria-label");

				rule.editButton(rule.sourceDatasetEditButton);

				String parentWindow = driver.getWindowHandle();

				Set<String> allWindowHandles = driver.getWindowHandles();

				Iterator<String> iterator = allWindowHandles.iterator();

				while (iterator.hasNext()) {

					String childWindow = iterator.next();

					if (!parentWindow.equalsIgnoreCase(childWindow)) {

						driver.switchTo().window(childWindow);

						Thread.sleep(5000);

						if (isDisplayed(driver, rule.connections)
								&& isDisplayed(driver, returnElement(rule.connectionsName, "$name", val))) {
							BaseSuite.validationReportLog(
									"After click on Edit button user redirect to Connection/UserConnection module");

						}

						else {

							BaseSuite.reportFailLog(
									"After click on Edit button user not able to redirect on Connection/UserConnection module",
									"");

						}

						driver.close();
					}

				}

				driver.switchTo().window(parentWindow);

			} else {

				throw new AssertionError("Searched rule not found hence these test is failed, kindly check");
			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	
	
	
	
}
