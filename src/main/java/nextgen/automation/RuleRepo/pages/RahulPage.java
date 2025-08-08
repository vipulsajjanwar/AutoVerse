package nextgen.automation.RuleRepo.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.util.XLUtils;

public class RahulPage extends TestDataThroughApi {


	public RahulPage(WebDriver driver) {
		super(driver);	}
	
	By toastMsg = getElementLocator(prop.getProperty("Commontoastmsg"));
	By popUpClose = getElementLocator(prop.getProperty("PopUpClose"));
	public String errorMessage = prop.getProperty("dataT.RunErrorMsg");
	public String runErrorMsgtintative = prop.getProperty("dataT.RunErrorMsgtintative");

	

	By addNewFolder = getElementLocator(prop.getProperty("DataTesting.AddNewFolder"));
	By enterNewFolderName = getElementLocator(prop.getProperty("DataTesting.EnterNewFolderName"));
	By noteText = getElementLocator(prop.getProperty("DataTesting.NoteText"));
	By clearAll = getElementLocator(prop.getProperty("DataTesting.ClearAll"));
	By datasetSpinner = getElementLocator(prop.getProperty("DataTesting.DatasetSpinner"));
	By folderList = getElementLocator(prop.getProperty("RuleRepo.FolderList"));
	By addsubFolder = getElementLocator(prop.getProperty("DataTesting.AddsubFolder"));

    By addNewRuleText = getElementLocator(prop.getProperty("DataTesting.AddNewRuleText"));
    By workspacefolder = getElementLocator(prop.getProperty("DataTesting.Workspacefolder"));
    By ruleNameText = getElementLocator(prop.getProperty("DataTesting.RuleNameText"));
    By engineTypeText = getElementLocator(prop.getProperty("DataTesting.EngineTypeText"));
    By chooseTemplateText = getElementLocator(prop.getProperty("DataTesting.ChooseTemplateText"));
    By addnewruleCancelbtn = getElementLocator(prop.getProperty("DataTesting.AddnewruleCancelbtn"));
    
    
    
	By sourceColumnLabel = getElementLocator(prop.getProperty("DataTesting.sourceColumnLabel"));
	By sourcecolumnaddbtn =getElementLocator(prop.getProperty("dataTesting.sourcecolumnaddbtn"));
	By changeColumnbtn = getElementLocator(prop.getProperty("DataTesting.changeColumnbtn"));
	By pagenationFirst = getElementLocator(prop.getProperty("DataTesting.pagenationFirst"));
	By pagenationPrevious = getElementLocator(prop.getProperty("DataTesting.pagenationPrevious"));
	By pagenationNext = getElementLocator(prop.getProperty("DataTesting.pagenationNext"));
	By pagenationLast = getElementLocator(prop.getProperty("DataTesting.pagenationLast"));
	
	By calculatedcolumnsearchBar = getElementLocator(prop.getProperty("DataTesting.calculatedcolumnsearchBar"));
	By calculatedcolumnsearchbtn = getElementLocator(prop.getProperty("DataTesting.calculatedcolumnsearchbtn"));
	By calculatedChangecolumnbtn = getElementLocator(prop.getProperty("dataTesting.calculatedChangecolumnbtn"));
    By CloseIcon =getElementLocator(prop.getProperty("dataT.Sidebars.CloseIcon"));
    By calculatedcolumnsavebtn = getElementLocator(prop.getProperty("dataTesting.calculatedcolumnsavebtn"));
    By calculatedcolumnsaveandNextbtn = getElementLocator(prop.getProperty("dataTesting.calculatedcolumnsaveandNextbtn"));
    
    //nehapage locator
    By check_AddCol_sidebar_Searchbox = getElementLocator(prop.getProperty("dataT.check.AddCol.sidebar.Searchbox"));
    By check_AddCol_Sidebar_searchBtn = getElementLocator(prop.getProperty("dataT.check.AddCol.sidebar.SearchBtn"));
    By check_AddColumn_Sidebar_AddBtn = getElementLocator(prop.getProperty("dataT.check.AddCol.sidebar.AddBtn"));
	By check_AddColumn_Sidebar_CancelBtn = getElementLocator(prop.getProperty("dataT.check.AddCol.sidebar.CancelBtn"));
	By check_addCol_selectAllChk = getElementLocator(prop.getProperty("dataT.check.addcolumnPane.selectallChk"));
	String check_addCol_sidebar_columToChoose = prop.getProperty("dataT.check.AddCol.sidebar.column");
	By check_AddCol_Sidebar_srch_noRecord = getElementLocator(prop.getProperty("dataT.check.AddCol.sidebar.Search.NoRecord"));
	By label_totalNosPage=getElementLocator(prop.getProperty("dataT.choosecolumn.label.totalpageNo"));
	
	
	By pageArrows1=getElementLocator(prop.getProperty("dataTesting.pageArrows1"));
	By pageMsg1 =getElementLocator(prop.getProperty("dataTesting.pageMsg1"));
	By sourceColumnCheckbox =getElementLocator(prop.getProperty("dataTesting.sourceColumnCheckbox"));
	By calculatedcolumnCancelbtn = getElementLocator(prop.getProperty("dataTesting.calculatedcolumnCancelbtn"));
	By newRuleBtn = getElementLocator(prop.getProperty("DataTesting.NewRuleBtn"));
	By pathSelect = getElementLocator(prop.getProperty("DataTesting.PathSelect"));
	By pathTree = getElementLocator(prop.getProperty("DataTesting.PathTree"));
	By pathScroll = getElementLocator(prop.getProperty("DataTesting.PathScroll"));
	By addNewFolderPath = getElementLocator(prop.getProperty("DataTesting.AddNewFolderPath"));
	By selectBtn = getElementLocator(prop.getProperty("DataTesting.Selectbtn"));
	By nameRule = getElementLocator(prop.getProperty("DataTesting.RuleName"));
	By engineType = getElementLocator(prop.getProperty("DataTesting.EngineType"));
	By chooseTemplateChecksum = getElementLocator(prop.getProperty("DataTesting.ChooseTemplateChecksum"));
	By chooseTemplatehtValidation = getElementLocator(prop.getProperty("DataTesting.ChooseTemplatehtValidation"));
	By chooseTemplatehthtrecon = getElementLocator(prop.getProperty("DataTesting.ChooseTemplatehthtrecon"));
	By chooseTemplatescript = getElementLocator(prop.getProperty("DataTesting.ChooseTemplatescript"));
	By cancelButton = getElementLocator(prop.getProperty("DataTesting.CancelButton"));
	By nextButton = getElementLocator(prop.getProperty("DataTesting.NextButton"));
	By DatasetSpinner = getElementLocator(prop.getProperty("DataTesting.DatasetSpinner"));
	By propertiesCriticality = getElementLocator(prop.getProperty("DataTesting.PropertiesCriticality"));
	By sourceDatasetSpinner = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetSpinner"));
	By propertiesPane = getElementLocator(prop.getProperty("DataTesting.PropertiesPane"));
	By propertiesWksFolder = getElementLocator(prop.getProperty("DataTesting.PropertiesWksFolder"));
	By propertiesRuleType = getElementLocator(prop.getProperty("DataTesting.PropertiesRuleType"));
	By propertiesRuleName = getElementLocator(prop.getProperty("DataTesting.PropertiesRuleName"));
	By propertiesRuleCode = getElementLocator(prop.getProperty("DataTesting.PropertiesRuleCode"));
	By propertiesRuleDescription = getElementLocator(prop.getProperty("DataTesting.PropertiesRuleDescription"));
	By propertiesRulepurpose = getElementLocator(prop.getProperty("DataTesting.propertiesRulepurpose"));
	By propertiesActiveOption = getElementLocator(prop.getProperty("DataTesting.PropertiesActiveOption"));
	By propertiesAtRowClick = getElementLocator(prop.getProperty("DataTesting.PropertiesAtRowClick"));
	By propertiesAtErrorClick = getElementLocator(prop.getProperty("DataTesting.PropertiesAtErrorClick"));
	By propertiesAtTimeClick = getElementLocator(prop.getProperty("DataTesting.PropertiesAtTimeClick"));
	By propertiesSearchParameter = getElementLocator(prop.getProperty("DataTesting.propertiesSearchParameter"));
	By propertiesParameter = getElementLocator(prop.getProperty("DataTesting.PropertiesParameter"));
	By propertiesclosecursor = getElementLocator(prop.getProperty("DataTesting.Propertiesclosecursor"));
	By Propertiesdop = getElementLocator(prop.getProperty("DataTesting.Propertiesdop"));
	By selectcheck = getElementLocator(prop.getProperty("DataTesting.SelectCheck"));
	By searchChecks = getElementLocator(prop.getProperty("DataTesting.SearchChecks"));
	By searchChecksbutton = getElementLocator(prop.getProperty("DataTesting.SearchChecksButton"));
	By changeChecksStatus = getElementLocator(prop.getProperty("DataTesting.changeChecksStatus"));
	By checksdeletelogo = getElementLocator(prop.getProperty("DataTesting.checksdeletelogo"));
	By checksdeletebutton = getElementLocator(prop.getProperty("DataTesting.checksdeletebutton"));
	By deletecheckscontain = getElementLocator(prop.getProperty("DataTesting.deletecheckscontain"));
	By deletebuttononpopup = getElementLocator(prop.getProperty("DataTesting.deletebuttononpopup"));
	By clickonsummary = getElementLocator(prop.getProperty("DataTesting.clickonsummary"));
	By clicknewvariable = getElementLocator(prop.getProperty("DataTesting.clicknewvariable"));
	By addvariable = getElementLocator(prop.getProperty("DataTesting.addvariable"));
	By newvariablecancel = getElementLocator(prop.getProperty("DataTesting.newvariablecancel"));
	// By
	// selectformula=getElementLocator(prop.getProperty("DataTesting.selectformula"));
	By formulaoptions1 = getElementLocator(prop.getProperty("DataTesting.formulaoptions1"));
	By formulaoptions2 = getElementLocator(prop.getProperty("DataTesting.formulaoptions2"));
	By searchformulavalue = getElementLocator(prop.getProperty("DataTesting.searchformulavalue"));
	By formulaexpression = getElementLocator(prop.getProperty("DataTesting.formulaexpression"));
	By variablename = getElementLocator(prop.getProperty("DataTesting.variablename"));
	
//new UI changes(overview)
	By overviewlabel = getElementLocator(prop.getProperty("DataTesting.Overviewlabel"));
	By rulenameLabel = getElementLocator(prop.getProperty("DataTesting.RulenameLabel"));
	By rulecodeLabel = getElementLocator(prop.getProperty("DataTesting.RulecodeLabel"));
	By descriptionLabel = getElementLocator(prop.getProperty("DataTesting.DescriptionLabel"));
	By purposeLabel = getElementLocator(prop.getProperty("DataTesting.PurposeLabel"));
	By criticalityLabel = getElementLocator(prop.getProperty("DataTesting.CriticalityLabel"));
	By advanceSettingLabel = getElementLocator(prop.getProperty("DataTesting.AdvanceSettingLabel"));
	By dopLabel = getElementLocator(prop.getProperty("DataTesting.DopLabel"));
	By stopAtRowLabel = getElementLocator(prop.getProperty("DataTesting.StopAtRowLabel"));
	By stopAtErrorLabel = getElementLocator(prop.getProperty("DataTesting.StopAtErrorLabel"));
	By stopAtAfterTimeLabel = getElementLocator(prop.getProperty("DataTesting.StopAtAfterTimeLabel"));
	By parameterLabel = getElementLocator(prop.getProperty("DataTesting.ParameterLabel"));
	By switchbtnLabel = getElementLocator(prop.getProperty("DataTesting.SwitchbtnLabel"));
	By ruleNameField = getElementLocator(prop.getProperty("DataTesting.RuleNameField"));
	By rulecodeField = getElementLocator(prop.getProperty("DataTesting.RulecodeField"));
	By descriptionField = getElementLocator(prop.getProperty("DataTesting.DescriptionField"));
	By purposeField = getElementLocator(prop.getProperty("DataTesting.PurposeField"));
	By criticalityclick=getElementLocator(prop.getProperty("DataTesting.Criticalityclick"));
	String criticalityselect=prop.getProperty("DataTesting.Criticalityselect");
	By dopField =getElementLocator(prop.getProperty("DataTesting.DopField"));
	By stopAtRowField =getElementLocator(prop.getProperty("DataTesting.StopAtRowField"));
	By stopAtErrorField =getElementLocator(prop.getProperty("DataTesting.StopAtErrorField"));
	By stopAfterTimeField =getElementLocator(prop.getProperty("DataTesting.StopAfterTimeField"));
	By switchbtn =getElementLocator(prop.getProperty("DataTesting.Switchbtn"));
	By parameterclick = getElementLocator(prop.getProperty("DataTesting.Parameterclick"));
	String parameterSelect =(prop.getProperty("DataTesting.ParameterSelect"));
	By parameterSearch = getElementLocator(prop.getProperty("DataTesting.ParameterSearch"));
	By rulenameinnertext = getElementLocator(prop.getProperty("DataTesting.Rulenameinnertext"));
	By engineTypeinnerText = getElementLocator(prop.getProperty("DataTesting.EngineTypeinnerText"));
	By closeCursor = getElementLocator(prop.getProperty("DataTesting.closeCursor"));
	
	
	String rulelandingpage_Disable_buttons = prop.getProperty("RuleRepo.rulelandingpage_Disable_buttons");
	
	By wksfoldertext =getElementLocator( prop.getProperty("DataTesting.wksfoldertext"));

	By sourcedataset_buttons =getElementLocator(prop.getProperty("RuleRepo.sourcedataset_buttons"));
	
	By targetDataset_buttons =getElementLocator(prop.getProperty("RuleRepo.targetDataset_buttons"));
	
	By checks_buttons = getElementLocator(prop.getProperty("RuleRepo.checks_buttons"));
	
	By exceptionReport_buttons =getElementLocator(prop.getProperty("RuleRepo.exceptionReport_buttons"));
	
    By diffJoin_buttons =getElementLocator(prop.getProperty("RuleRepo.diffJoin_buttons"));
	
	By summary_buttons = getElementLocator(prop.getProperty("RuleRepo.summary_buttons"));
	
	By rulelandingpage_discard_button = getElementLocator(prop.getProperty("RuleRepo.rulelandingpage_discard_button"));

	By rulePublishButton = getElementLocator(prop.getProperty("dataT.Rule.PublishMenu"));
	By propertiesTab = getElementLocator(prop.getProperty("DataTesting.PropertiesTab"));
	String folderCreatedMessText = prop.getProperty("DataTesting.FolderCreatedMessText");
	By toastMsgClosedBtn = getElementLocator(prop.getProperty("ToastMsgClosedBtn"));

	
	By metatab = getElementLocator(prop.getProperty("DataTesting.Metatab"));
	By metatabClose = getElementLocator(prop.getProperty("DataTesting.MetatabClose"));
	By newCheckClose = getElementLocator(prop.getProperty("dataT.NewCheckClose"));
	// By selectRule =getElementLocator(prop.getProperty("DataTesting.SelectRule"));
	By sercheditem = getElementLocator(prop.getProperty("DataTesting.sercheditem"));

	String checkscheckboxselect = prop.getProperty("DataTesting.checkscheckboxselect");
	String selectExistingFolder = prop.getProperty("DataTesting.SelectExistingFolder");
	String validScrollFolder = prop.getProperty("DataTesting.ValidScrollFolder");
	String engineTypeSelectOption = prop.getProperty("DataTesting.EngineTypeSelectOption");
	String chooseTemplate = prop.getProperty("DataTesting.ChooseTemplate");
	String pathText = prop.getProperty("DataTesting.PathText");
	String propertiescriticalityOption = prop.getProperty("DataTesting.PropertiescriticalityOption");
	String propertiesselectParameter = prop.getProperty("DataTesting.propertiesselectParameter");
	String SelectRule = prop.getProperty("DataTesting.SelectRule");
	String selectchecksstatus = prop.getProperty("DataTesting.selectchecksstatus");
	String selectformula = prop.getProperty("DataTesting.selectformula");
	// String formulaoptions= prop.getProperty("DataTesting.formulaoptions");
	String selectoperator = prop.getProperty("DataTesting.selectoperator");
	String selectvalue = prop.getProperty("DataTesting.selectvalue");
	String formulavalueclick = prop.getProperty("DataTesting.formulavalueclick");
	
	By selectschemavalidation = getElementLocator(prop.getProperty("DataTesting.selectschemavalidation"));
	By selectTablevalidation = getElementLocator(prop.getProperty("DataTesting.selectTablevalidation"));
	By schemaTitleValidation = getElementLocator(prop.getProperty("DataTesting.schemaTitleValidation"));
	By tableviewTitleValidation = getElementLocator(prop.getProperty("DataTesting.tableviewTitleValidation"));
	By querytTextareavalidation = getElementLocator(prop.getProperty("DataTesting.querytTextareavalidation"));
	By sourceDatatabColumncount = getElementLocator(prop.getProperty("DataTesting.sourceDatatabColumncount"));
	By sourceDatatabDatatypecount = getElementLocator(prop.getProperty("DataTesting.sourceDatatabDatatypecount"));
	By connectiontypetitle = getElementLocator(prop.getProperty("DataTesting.connectiontypetitle"));
	By connectiontypefeild = getElementLocator(prop.getProperty("DataTesting.connectiontypefeild"));
	By connectionselectTitle = getElementLocator(prop.getProperty("DataTesting.connectionselectTitle"));
	By connectionselectfeild = getElementLocator(prop.getProperty("DataTesting.connectionselectfeild"));
	By radiobtndirect = getElementLocator(prop.getProperty("DataTesting.radiobtndirect"));
	By radiobtncustom = getElementLocator(prop.getProperty("DataTesting.radiobtncustom"));
	By sourcedatatabnorecords = getElementLocator(prop.getProperty("DataTesting.sourcedatatabnorecords"));
	By sourcedatasettextbox = getElementLocator(prop.getProperty("DataTesting.sourcedatasettextbox"));
	By sourcedatasettextboxediticon = getElementLocator(prop.getProperty("DataTesting.sourcedatasettextboxediticon"));
	By datatab = getElementLocator(prop.getProperty("DataTesting.datatab"));
	By sourcesettingblankpage = getElementLocator(prop.getProperty("DataTesting.sourcesettingblankpage"));
	By sourcesettingsourcetitle = getElementLocator(prop.getProperty("DataTesting.sourcesettingsourcetitle"));
	By sourcetablecolumn = getElementLocator(prop.getProperty("DataTesting.sourcetablecolumn"));
	By sourcetabletype = getElementLocator(prop.getProperty("DataTesting.sourcetabletype"));
	By sourceconncount = getElementLocator(prop.getProperty("DataTesting.sourceconncount"));
	By conntypedropdownvisibility = getElementLocator(prop.getProperty("DataTesting.conntypedropdownvisibility"));

	String conntypedropdownvisibletext = prop.getProperty("DataTesting.conntypedropdownvisibletext");
	By sourceSettingColumncount = getElementLocator(prop.getProperty("DataTesting.sourceSettingColumncount"));
	By sourceSettingTypecount = getElementLocator(prop.getProperty("DataTesting.sourceSettingTypecount"));
	By sourceSettingnorecords = getElementLocator(prop.getProperty("DataTesting.sourceSettingnorecords"));
			
			
	///////////////////////////////////
	By srcConnEditBt = getElementLocator(prop.getProperty("DataTesting.srcConnEditBt"));

	// This Method is use to click on the new folder and Existing folder
		// option=========For API
		

		public void clickOnAddNewFolderOrExistingOneAPI(DataTestingParameters param, String workspaceID,String jsonEntity,String icedqRole) throws InterruptedException{
			
			try {
				
					//need to update this method - refer method from datatesting page
				List<String> list = null; //TestDataThroughApi.getfolderNameUsingFolderList(workspaceID,icedqRole);

				int cout = list.size();

				if (cout != 0) {

					for (int i = 0; i < cout; i++) {

						String folder = list.get(i);

						String str = folder.replace("\\", " ");
						
						String str1=str.trim();
						
						//String str1=str.strip();
						
						int count = getcount(str1, ' ');

						
						
						String[] result = str1.split(" ");

						for (int colNum = 0; colNum <= count; colNum++) {
							
							String folderName = result[colNum];

							List<WebElement> ele = driver.findElements(folderList);

							boolean flag = false;

							for (WebElement e : ele) {

								String val = e.getText();

								if (val.equalsIgnoreCase(folderName)) {

									flag = true;

									displayAndClick(driver,
											returnElement(selectExistingFolder, "$name", folderName));

									inVisible(driver, datasetSpinner, Constant.ruleWait);

									BaseSuite.validationReportLog("Existing folder selected Successfully");

									break;

								}
	                              
							}

							if (flag == false) {

								displayAndClick(driver, addNewFolder);

								inVisible(driver, datasetSpinner, Constant.ruleWait);

								BaseSuite.validationReportLog("Clicked on Add New Folder ");

								sendKeys(driver, enterNewFolderName, folderName);
								
								Thread.sleep(1000);

								driver.findElement(enterNewFolderName).sendKeys(Keys.ENTER);

								captureToastMsg(driver, toastMsg, toastMsgClosedBtn, folderCreatedMessText, "Folder created Message.");
								
								inVisible(driver, datasetSpinner, Constant.ruleWait);

								BaseSuite.validationReportLog("Clicked on outside the Text Box");

								inVisible(driver, datasetSpinner, Constant.ruleWait);

								BaseSuite.validationReportLog("New Folder Created Successfully");
							
								if (count > 0) {
									
								
									displayAndClick(driver,returnElement(selectExistingFolder, "$name", folderName.trim()));
									
									displayAndClick(driver, addsubFolder);

									BaseSuite.validationReportLog("Clicked on Add New SubFolder ");

									inVisible(driver, datasetSpinner, Constant.ruleWait);

									sendKeys(driver, enterNewFolderName, folderName);

									driver.findElement(enterNewFolderName).sendKeys(Keys.ENTER);
									
									BaseSuite.validationReportLog("New Child Folder Created Successfully");
									
								}
								
							}
							break;
						}
	                       
					}
				}
			} catch (Exception e) {

				e.getMessage();

			}
		}


		// This method is use to click on New Rule Button
		
		public void clickOnNewRule() {

			try {
				if (isEnabled(driver, newRuleBtn)) {

					Actions actions = new Actions(driver);

					wait = waitMethod(driver);

					actions.moveToElement(driver.findElement(newRuleBtn)).perform();

					wait.until(ExpectedConditions.visibilityOfElementLocated(newRuleBtn));

					actions.click(driver.findElement(newRuleBtn)).build().perform();

					BaseSuite.reportLog("New Rule Button visible on Page");
					
					BaseSuite.reportLog("click on New Rule Button");
					
					BaseSuite.validationReportLog("New Rule Button Clicked");
				} else {
					BaseSuite.reportFailLog("New Rule Button is not visible", "newRuleBtn");
				}

			} catch (Exception e) {

				e.getMessage();
			}

		}
		// This Method is use to check New Rule pane functionality

			public void enterDetailsInAddNewPane(DataTestingParameters param)throws InterruptedException{
				try {
					clickOnNewRule();
					//validation checks for Add new Rule pane
					
					if(isDisplayed(driver, addNewRuleText)) {
						String val=getText(driver, addNewRuleText);
						BaseSuite.validationReportLog(val + " Text is displayed clearly ");
						}
						else
						{
							BaseSuite.reportFailLog("AddNewRuleText is fail to display", "addNewRuleText");
						}
				   String value=getAttribute(driver, wksfoldertext,"text");
					BaseSuite.validationReportLog(" Folder Label Text is displayed clearly ");

					if(isEnabled(driver, workspacefolder)) {
					String val4=getAttribute(driver, workspacefolder, "title");
					BaseSuite.validationReportLog(" Selected Folder displayed clearly ");
					}
					else
					{
						BaseSuite.reportFailLog("folder is fail to display", "workspacefolder");
					}
					if(isDisplayed(driver,ruleNameText )) {
						String val5=getText(driver,ruleNameText );
						BaseSuite.validationReportLog(val5 + " Text is displayed clearly ");
						}
						else
						{
							BaseSuite.reportFailLog("Rule Name text is fail to display", "ruleNameText");
						}
					
					if(isDisplayed(driver,rulenameinnertext)) {
						String val1=getAttribute(driver, rulenameinnertext, "value");
						BaseSuite.validationReportLog(val1 + " Text is displayed clearly ");
						}
						else
						{
							BaseSuite.reportFailLog("Rule Name inner text is fail to display", "rulenameinnertext");
						}
					if(isDisplayed(driver, engineTypeText)) {
						String val2=getText(driver, engineTypeText);
						BaseSuite.validationReportLog(val2 + " Text is displayed clearly ");
						}
						else
						{
							BaseSuite.reportFailLog("engineType Text is fail to display", "engineTypeText");
						}
					if(isDisplayed(driver, engineTypeinnerText)) {
						String val2=getAttribute(driver, engineTypeinnerText, "text");
						BaseSuite.validationReportLog("Internal Text is displayed clearly ");
						}
						else
						{
							BaseSuite.reportFailLog("engineType Text is fail to display", "engineTypeinnerText");
						}
					if(isDisplayed(driver, chooseTemplateText)) {
						String val3=getText(driver, chooseTemplateText);
						BaseSuite.validationReportLog(val3 + " Text is displayed clearly ");
		/**				List<WebElement> qwerty = driver.findElements(By.xpath("//ejs-sidebar[@id='default1']//input[@type='radio']//following::label"));
						for (int i = 0; i < qwerty.size(); i++) {

							String vals = qwerty.get(i).getText();

							qwerty.get(i);
							BaseSuite.validationReportLog(vals + " Template is clearly visible ");
						}**/
					}
						else
						{
							BaseSuite.reportFailLog("chooseTemplate Text is fail to display", "chooseTemplateText");
						}
					verifyVisibilityOfButtons(driver, cancelButton, "cancel button", true);

					//Fuctional validation check
				
					
					BaseSuite.reportLog("clicking on path");

					javascript(driver, "arguments[0].click();", pathSelect);

					BaseSuite.validationReportLog(" path clicked successfully ");

					if (isEnabled(driver, pathTree)) {
						Thread.sleep(2000);

						javascript(driver, "arguments[0].scrollIntoView(true);",
								returnElement(validScrollFolder, "$name", param.getFolderName()));
						
						clear_Click_SendKeys(driver, 10, addNewSearchBar, param.getFolderName());
						
						click(driver, addNewPanSearchBarButton);

						click(driver, returnElement(validScrollFolder, "$name", param.getFolderName()));

						inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

						String folder = getText(driver, returnElement(validScrollFolder, "$name", param.getFolderName()));

						Thread.sleep(2000);

						if (folder.trim().equalsIgnoreCase(param.getFolderName().trim())) {
							BaseSuite.validationReportLog(param.getFolderName() + " Folder is visble");

							BaseSuite.reportLog("clicking on select Button");

							click(driver, selectBtn);

							BaseSuite.validationReportLog(" Select Button clicked successfully ");
						} else {
							BaseSuite.reportFailLog(param.getFolderName() + "is fail to display", "selectpathRule");
						}

						if (!param.getRuleName().isEmpty()) {
							
							String rulenamecapture =getAttribute(driver, nameRule, "value");
							BaseSuite.validationReportLog(rulenamecapture + " Rule Name Text is displayed clearly ");
							inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

							
						}else
						{
							BaseSuite.reportLog("Click on Rule Name");

							clear_SendKeys(driver, nameRule, param.getRuleName());

							inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

							BaseSuite.validationReportLog("Rule Name field is visible and Editable");

						}
						BaseSuite.reportLog("Click on Engine Type option");

						inVisible(driver, datasetSpinner, Constant.ruleWait);

						displayAndClick(driver, engineType);

						javascript(driver, "arguments[0].click();", engineType);

						BaseSuite.validationReportLog("Engine Type option Clicked successfully");

						BaseSuite.reportLog("Engine Type option clicked");

						javascript(driver, "arguments[0].click();",
								returnElement(engineTypeSelectOption, "$name", param.getEngineTypeOption()));

						BaseSuite.validationReportLog(param.getEngineTypeOption()+ " Engine Type option clearly visible");

						inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

						BaseSuite.reportLog("Choosed Template");
						
						Thread.sleep(1000);

						displayAndClick(driver, returnElement(chooseTemplate, "$name", param.getRuleType().toLowerCase()));

						BaseSuite.validationReportLog(param.getRuleType() + " Template Selected successfully");

					} else {
						BaseSuite.reportFailLog(param.getFolderName() + "is fail to display", "selectpathRule");

					}
				} catch (Exception e) {
					e.getMessage();
				}
			}

		// This Method is use to check New Rule pane functionality===============through API

		public void enterDetailsInAddNewPaneAPI(DataTestingParameters param,String workspaceID,String icedqRole) 
		{
			try {
				List<String> list = null;//TestDataThroughApi.getfolderNameUsingFolderList(workspaceID,icedqRole); need to update this method

				clickOnNewRule();
				
				if (isDisplayed(driver,wksfoldertext)) {
					getAttribute(driver, wksfoldertext, "title");
					BaseSuite.validationReportLog(" Default Folder Name Visible ");
				}

				BaseSuite.reportLog("clicking on path");

				javascript(driver, "arguments[0].click();", pathSelect);

				BaseSuite.validationReportLog(" path clicked successfully ");
				
				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);


				if (isDisplayed(driver, pathTree)) {
					//Thread.sleep(2000);

					int cout = list.size();

					if (cout != 0) {

						for (int i = 0; i < cout; i++) {

							String folder = list.get(i);

							String str = folder.replace("\\", " ");

							String str1 = str.trim();

							// String str1=str.strip();
							
							

							int count = getcount(str1, ' ');

							String[] result = str1.split(" ");

							for (int colNum = 0; colNum <= count; colNum++) {

								String folderName = result[colNum];

								if (!folderName.isEmpty()) {
									List<WebElement> ele = driver.findElements(folderList);
									

									boolean flag = false;

									for (WebElement e : ele) {

										String val = e.getText();

										if (val.equalsIgnoreCase(folderName))
										{

											flag = true;
											
											inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
											
											waitForElement(driver,(returnElement( validScrollFolder,"$name", folderName)));

											javascript(driver, "arguments[0].scrollIntoView(true);",
													returnElement(validScrollFolder, "$name", folderName));
											
											clear_Click_SendKeys(driver, 10, addNewSearchBar, folderName);
											
											click(driver, addNewPanSearchBarButton);

											click(driver, returnElement(validScrollFolder, "$name", folderName));

											inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

										//	Thread.sleep(2000);
											
											BaseSuite.reportLog("clicking on select Button");

											click(driver, selectBtn);

											BaseSuite.validationReportLog(" Select Button clicked successfully ");
											
										break;
								}
									}
															}
								}
							}
						}
					} 
				else {
						BaseSuite.reportFailLog(param.getFolderName() + "is fail to display", "selectpathRule");
					}
			
					if (!param.getRuleName().isEmpty()) {
						BaseSuite.reportLog("Click on Rule Name");
						
						inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);


						clear_Click_SendKeys(driver, 10, nameRule, param.getRuleName());

						BaseSuite.validationReportLog("Rule Name field is visible and Editable");

					}
					BaseSuite.reportLog("Click on Engine Type option");

					inVisible(driver, datasetSpinner, Constant.ruleWait);

					displayAndClick(driver, engineType);

					javascript(driver, "arguments[0].click();", engineType);

					BaseSuite.validationReportLog("Engine Type option Clicked successfully");

					BaseSuite.reportLog("Engine Type option clicked");

					javascript(driver, "arguments[0].click();",returnElement(engineTypeSelectOption, "$name", param.getEngineTypeOption()));

					BaseSuite.validationReportLog("Engine Type option clearly visible");

					BaseSuite.reportLog("Choosed Template");

					javascript(driver, "arguments[0].scrollIntoView(({behavior:'smooth'}));", returnElement(chooseTemplate, "$name", param.getRuleType().toLowerCase()));
							
					displayAndClick(driver, returnElement(chooseTemplate, "$name", param.getRuleType().toLowerCase()));
					
					inVisible(driver, datasetSpinner, Constant.ruleWait);

					BaseSuite.validationReportLog(param.getRuleType() + " Template Selected successfully");
					
					validationcheckforvisibility(param,"input");
					
				}catch (Exception e) {
					
				}
			
		}
	   
			public void validationcheckforvisibility(DataTestingParameters param,String input)
			{
				try {
					// Buttons validation check 
					
					inVisible(driver, datasetSpinner, Constant.ruleWait);
					
					verifyVisibilityOfButtons(driver, propertiesPane, "Properties button", true);

					
					if(isEnabled(driver, returnElement(rulelandingpage_Disable_buttons, "$name", "Run"))) {
						  
						  BaseSuite.validationReportLog("Run Button is disable"); }
					else {
						  
						  BaseSuite.reportLog("Run Button is Enable");
						  
						  } 

					if(isEnabled(driver, returnElement(rulelandingpage_Disable_buttons, "$name", "Delete"))) {
						  
						  BaseSuite.validationReportLog("Delete Button is disable"); }
					else {
						  
						  BaseSuite.reportLog("Delete Button is Enable");
						  
						  } 

					if(isEnabled(driver, returnElement(rulelandingpage_Disable_buttons, "$name", "Subscription"))) {
						  
						  BaseSuite.validationReportLog("Subscription Button is disable"); }
					else {
						  
						  BaseSuite.reportLog("Subscription Button is Enable");
						  
						  } 
			
					 
					if (param.getRuleType().equalsIgnoreCase("Script"))
					 {
						verifyVisibilityOfButtons(driver, rulePublishButton, "Publish button", false);
						
						verifyVisibilityOfButtons(driver, rulelandingpage_discard_button, "Discard button", true);
					 }
						else {
							verifyVisibilityOfButtons(driver, rulePublishButton, "Publish button", true);
							
							verifyVisibilityOfButtons(driver, rulelandingpage_discard_button, "Discard button", true);

						}
				
					if (param.getRuleType().equalsIgnoreCase("Validation")
							|| param.getRuleType().equalsIgnoreCase("pushdown")) {

						inVisible(driver, datasetSpinner, Constant.ruleWait);
						
						verifyVisibilityOfButtons(driver, sourcedataset_buttons, "Source button",true);
						
						verifyVisibilityOfButtons(driver, checks_buttons, "checks button",false);
						
						verifyVisibilityOfButtons(driver,exceptionReport_buttons, "exceptionReport button", false);
						
						verifyVisibilityOfButtons(driver, summary_buttons, "summary button",false);
						

					}

					else if (param.getRuleType().equalsIgnoreCase("checksum")) {

						inVisible(driver, datasetSpinner, Constant.ruleWait);

						verifyVisibilityOfButtons(driver, sourcedataset_buttons, "Source button",true);
						
						verifyVisibilityOfButtons(driver, targetDataset_buttons, "Target button",true);
						
						verifyVisibilityOfButtons(driver, checks_buttons, "checks button",false);
						
						verifyVisibilityOfButtons(driver, summary_buttons, "summary button",false);
						

					} else if (param.getRuleType().equalsIgnoreCase("Recon")) {

						inVisible(driver, datasetSpinner, Constant.ruleWait);
						
	                    verifyVisibilityOfButtons(driver, sourcedataset_buttons, "Source button",true);
						
						verifyVisibilityOfButtons(driver, targetDataset_buttons, "Target button",true);
						
						verifyVisibilityOfButtons(driver,diffJoin_buttons, "diffJoin button", false);
						
						verifyVisibilityOfButtons(driver, checks_buttons, "checks button",false);
					
						verifyVisibilityOfButtons(driver,exceptionReport_buttons, "exceptionReport button", false);
						
						verifyVisibilityOfButtons(driver, summary_buttons, "summary button",false);

					}

					else {
						
						if (isEnabled(driver, returnElement(rulelandingpage_Disable_buttons, "$name", "Parse"))) {
							BaseSuite.validationReportLog("Parse button is Disable in the page");

						} else {
							BaseSuite.validationReportLog("Parse button is Enable in the page");
						}
						if (isEnabled(driver, returnElement(rulelandingpage_Disable_buttons, "$name", "Refresh"))) {
							BaseSuite.validationReportLog("Refresh button is Disable in the page");

						} else {
							BaseSuite.validationReportLog("Refresh button is Enable in the page");
						}

					}

				} catch (Exception e) {
				}

			}

		// This method is to click on Meta Tab
		public void clickOnMetaTab(DataTestingParameters param,SoftAssert soft) {

			try {
				BaseSuite.reportLog("Clicking on Metadata Tab ");

				//displayAndClick(driver, metatab);
				
				propertiespaneclick() ;

				BaseSuite.validationReportLog("Clicked on Metadata successfully");
				
				Thread.sleep(1000);

				propertieswksFolderSelect(param,soft);

				propertiesRuleType(param);

				PropertiesRuleName(param);

				RuleCodeProperties(param);

				descriptionPropertiedPane(param);

				propertiespanepurpose(param);

				criticalityoption(param);

				activeEnable(param);

				//propertiesMetaTabClose();
			} catch (Exception e) {

				e.getMessage();
			}

		}
		// This Method is to close the Properties Pane
		/*
		 * public void propertiesMetaTabClose() {
		 * 
		 * try { Thread.sleep(3000);
		 * 
		 * BaseSuite.validationReportLog("Clicking on Metadata Pane Close button");
		 * 
		 * displayAndClick(driver, metatabClose);
		 * 
		 * BaseSuite.
		 * validationReportLog("Metadata Pane Close button clicked Successfully"); }
		 * catch (InterruptedException e) {
		 * 
		 * e.getMessage(); }
		 * 
		 * }
		 */

		// This Method is use to click on properties Pane
		public void propertiespaneclick() {
			try {

				BaseSuite.reportLog("click on properties Pane");

				isDisplayedInLoop(driver, 3, propertiesPane);

				if (isEnabled(driver, propertiesPane)) {

					Thread.sleep(2000);

					javascript(driver, "arguments[0].click();", propertiesPane);

					BaseSuite.validationReportLog("properties Pane is visible on Page");

					BaseSuite.validationReportLog("properties Pane Clicked");

				} else {
					BaseSuite.reportFailLog("properties Pane is not visible", "propertiesPane");
				}

			} catch (Exception e) {

				e.getMessage();
			}
		}

		// This method is to use to enter the details in properties pane
		public void enterDetailsInPropertyPane(DataTestingParameters param)throws InterruptedException {
			try {
				displayAndClick(driver, propertiesTab);

				if (param.getEngineTypeOption().equalsIgnoreCase("High Throughput")
						|| param.getEngineTypeOption().equalsIgnoreCase("Cluster"))
				{
					
					propertiesDOPentry(param);

				}

				if (param.getRuleType().equalsIgnoreCase("Validation") || param.getRuleType().equalsIgnoreCase("Recon")) {

					propertiesStopAtRow(param);
					
					if (!param.getRuleType().equalsIgnoreCase("pushdown"))
					{
						propertiesStopAtError(param);
					}

						propertiesStopAtTime(param);

					}
				
				parameterSelect(param);

					propertiesPaneClose();


				}
		catch (Exception e) {

				e.getMessage();
			}
		}
		

		// This Method is use to enter details in Degree of parallelism(DOP)
		public void propertiesDOPentry(DataTestingParameters param) {
			try {
				int count1=1;
				if(Integer.parseInt(param.getDop())< count1) {
				if (!param.getDop().isEmpty()) {

					BaseSuite.validationReportLog("Entering Value in DOP");

					sendKeys(driver, Propertiesdop, param.getDop());

					BaseSuite.validationReportLog("Entered Value in DOP successfully");

				}
				}	} catch (Exception e) {
				e.getMessage();
			}

		}

		// This Method is to check the Workspace\Folder Visibility
		public boolean propertieswksFolderSelect(DataTestingParameters param, SoftAssert soft) {
			boolean flag = true;

			try {
				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
				if (isDisplayed(driver, propertiesWksFolder)) {
					String val1=getText(driver, propertiesWksFolder);
					BaseSuite.validationReportLog(val1 + " Text is displayed clearly ");

					if (val1.equalsIgnoreCase("\\"+param.getFolderName())) {
						BaseSuite.validationReportLog(val1 + "is visible");

					} else {
						soft.assertTrue(true, "a");
						BaseSuite.reportFailLog("properties wks folder failed to display", "propertiesWksFolder");

					}
				}

			} catch (Exception e) {

				e.getMessage();
			}
			return flag;
		}

		// This Method is to check the Rule Type Properties
		public boolean propertiesRuleType(DataTestingParameters param) {
			boolean flag = true;

			try {
				if (isEnabled(driver, propertiesRuleType)) {
					String ruletype = getText(driver, propertiesRuleType);

					if (ruletype.equalsIgnoreCase(param.getRuleType())) {
						BaseSuite.validationReportLog(ruletype + " Rule Type is visible");

					} else {
						BaseSuite.reportFailLog("properties Rule Type Field failed to display", "propertiesRuleType");

					}
				}

			} catch (Exception e) {

				e.getMessage();
			}
			return flag;
		}
	

		// This Method is to click on the Properties Rule Name
		public void PropertiesRuleName(DataTestingParameters param) {

			try {
				if (isDisplayed(driver, propertiesRuleName)) 
				{
						if (!param.getRuleName().isEmpty()) {

						String checkrule = getAttribute(driver, propertiesRuleName, "value");
					
						BaseSuite.validationReportLog(checkrule + " _Rule Name Text is displayed clearly ");
						}

					else {
						BaseSuite.reportLog("Click on Rule Name");

						clear_SendKeys(driver, propertiesRuleName, param.getRuleName());

						inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

						BaseSuite.validationReportLog("Rule Name field is visible and Editable");

						}
					
				}
			} catch (Exception e) {

				e.getMessage();
			}

		}

		// This Method is use to Enter the Rule Code in Properties Pane
		public void RuleCodeProperties(DataTestingParameters param) {

			try {
				if (param.getRuleCode() != null) {
					if (!param.getRuleCode().isEmpty()) {
						if (isDisplayed(driver, propertiesRuleCode))

							displayAndClick(driver, propertiesRuleCode);

						BaseSuite.reportLog("Entering code in Rule code field");

						sendKeys(driver, propertiesRuleCode, param.getRuleCode());

						BaseSuite.validationReportLog("Code Entered in Rule code field");

					}
				}

			} catch (Exception e) {

				e.getMessage();
			}
		}

		// This Method is use to Enter the Detailed Description in Rules Properties Pane
		public void descriptionPropertiedPane(DataTestingParameters param) {

			try {
				if (param.getDescription() != null) {

					if (!param.getDescription().isEmpty()) {
						if (isDisplayed(driver, propertiesRuleDescription)) {

							displayAndClick(driver, propertiesRuleDescription);

							BaseSuite.reportLog("Entering description in Description field");

							sendKeys(driver, propertiesRuleDescription, param.getDescription());

							BaseSuite.validationReportLog("Description Entered in description field");
						}
					}
				}
			} catch (Exception e) {

				e.getMessage();
			}
		}

		// This Method is to use to filled the purpose field for Properties Pane Rule
		public void propertiespanepurpose(DataTestingParameters param) {

			try {

				if (param.getPurpose() != null) {
					if (!param.getPurpose().isEmpty()) {
						if (isDisplayed(driver, propertiesRulepurpose)) {

							displayAndClick(driver, propertiesRulepurpose);

							BaseSuite.reportLog("Entering Data in Purpose field");

							sendKeys(driver, propertiesRulepurpose, param.getPurpose());

							BaseSuite.validationReportLog("Data Entered in Purpose field ");

						}

					}
				}

			} catch (Exception e) {

				e.getMessage();

			}

		}

		// This Method is to check the criticality of the rule
		public void criticalityoption(DataTestingParameters param) {
			try {
				BaseSuite.reportLog("Click on Criticality option");

				// Thread.sleep(30000);

				javascript(driver, "arguments[0].scrollIntoView(true);", propertiesCriticality);

				Actions actions = new Actions(driver);

				wait = waitMethod(driver);

				actions.moveToElement(driver.findElement(propertiesCriticality)).perform();

				wait.until(ExpectedConditions.visibilityOfElementLocated(propertiesCriticality));

				actions.click(driver.findElement(propertiesCriticality)).build().perform();

				// displayAndClick(driver, propertiesCriticality);

				// javascript(driver, "arguments[0].click();", propertiesCriticality);

				BaseSuite.validationReportLog("Criticality option Clicked successfully");

				displayAndClick(driver, returnElement(propertiescriticalityOption, "$option", param.getCriticality()));

				BaseSuite.validationReportLog("Ciriticality option Selected");
			} catch (Exception e) {

				e.getMessage();
			}
		}

		// This Method is to check the Checkbox is click or not
		public void activeEnable(DataTestingParameters param) {
		try {
				if (param.getEnableactiveOption().equalsIgnoreCase("True"))

				{

					BaseSuite.validationReportLog("Enable Active CheckBox is already checked");

				} else {

					displayAndClick(driver, propertiesActiveOption);

					BaseSuite.validationReportLog("Enable Active CheckBox is unchecked");
				}
			} catch (Exception e) {

				e.getMessage();
			}
		}

		// This Method is to use click on the Stop At Row option
		public void propertiesStopAtRow(DataTestingParameters param) {
			try {
				int count=1;
				if (Integer.parseInt(param.getStopAtRow())> count) {

					sendKeys(driver, propertiesAtRowClick, param.getStopAtRow());
					
					BaseSuite.validationReportLog("stoprowtext"+"row");
				}
				
			} catch (Exception e) {

				e.getMessage();
			}
		}

		// This Method is to use Click on Stop At Error option
		public void propertiesStopAtError(DataTestingParameters param) {
			try {
				int count=1;
				if (Integer.parseInt(param.getStopAtError())> count){
						BaseSuite.reportLog("Click on Stop At Error");
						
						clear_SendKeys(driver, propertiesAtErrorClick, param.getStopAtError());

						BaseSuite.validationReportLog("Stop At Error field is visible & ready to Update");
					}
				
			} catch (Exception e) {

				e.getMessage();
			}
		}
		
		//this Method is use to check UI-validation
		

		// This Method is to use click on Stop At Time option
		public void propertiesStopAtTime(DataTestingParameters param) throws InterruptedException {
			try {
				int count=5;
				if (Integer.parseInt(param.getStopAtTime())> count){
					 {
						BaseSuite.reportLog("Click on Stop At Time");

						clear_SendKeys(driver, propertiesAtTimeClick, param.getStopAtTime());

						BaseSuite.validationReportLog("Stop At Time field is visible & ready for Use");
						Thread.sleep(2000);

					}
				}
			} catch (Exception e) {

				e.getMessage();
			}
		}

		// This Method is use to Select the Parameter
		public void parameterSelect(DataTestingParameters param) {
			try {
				Thread.sleep(1000);

				if (param.getParameterFilename() != null) {

					if (!param.getParameterFilename().isEmpty())
					{
						
						BaseSuite.reportLog("Click on Select Parameter option");

						isDisplayedInLoop(driver, 10, propertiesParameter);

						Actions actions = new Actions(driver);

						wait = waitMethod(driver);

						actions.moveToElement(driver.findElement(propertiesParameter)).perform();

						wait.until(ExpectedConditions.visibilityOfElementLocated(propertiesParameter));

						//actions.click(driver.findElement(propertiesParameter)).build().perform();
						
						displayAndClick(driver, propertiesParameter);

						Thread.sleep(1000);
						
						BaseSuite.validationReportLog("Select Parameter option Clicked successfully");

						sendKeys(driver, propertiesSearchParameter, param.getParameterFilename());

						BaseSuite.validationReportLog("Select Parameter option is ready to search Parameter's");

						driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

						displayAndClick(driver,returnElement(propertiesselectParameter, "$name", param.getParameterFilename()));
						
						
						//javascript(driver, "arguments[0].scrollIntoView(true);",returnElement(propertiesselectParameter, "$name", param.getParameterFilename()));
						
						
						BaseSuite.validationReportLog("Parameter Selected successfully");
					}
				}

			} catch (Exception e) {
				e.getMessage();
			}
		}

		
		  // This Method is to close the Properties Pane 
		public void propertiesPaneClose() throws InterruptedException
		  { try {
		  displayAndClick(driver, propertiesclosecursor);
		  
		  BaseSuite.validationReportLog("Properties Pane Close Successfully");
		 
		  } catch (Exception e) { e.getMessage(); }
		  
		  }
		 
		
		// -------->This method use to click on summary option in test rules section
		public void clickonsummarry() {
			try {
				Thread.sleep(2000);

				inVisible(driver, datasetSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog(" Click on Summary ");

				
				/*
				 * Actions actions = new Actions(driver);
				 * 
				 * wait = waitMethod(driver);
				 * 
				 * actions.moveToElement(driver.findElement(clickonsummary)).perform();
				 * 
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(clickonsummary));
				 * 
				 * actions.click(driver.findElement(clickonsummary)).build().perform();
				 */
				
				displayAndClick(driver, clickonsummary);

				Actions actions = new Actions(driver);

				wait = waitMethod(driver);

				actions.moveToElement(driver.findElement(clickonsummary)).perform();

				wait.until(ExpectedConditions.visibilityOfElementLocated(clickonsummary));

				actions.click(driver.findElement(clickonsummary)).build().perform();

				BaseSuite.validationReportLog(" Summary Section clicked successfully ");

			} catch (Exception e) {

			}

		}

		// -------->This method use to click on New Variables option in test rules
		// section
		public void clickonnewvariabe() {
			try {

				Thread.sleep(3000);

				BaseSuite.validationReportLog(" Click on New Variable ");

				displayAndClick(driver, clicknewvariable);

				BaseSuite.validationReportLog("New Variable clicked successfully ");

			} catch (Exception e) {

			}

		}
		// click on variable Name to check functionality

		public void variabelName(String varName) {

			try {
				BaseSuite.validationReportLog("click on Variable Name ");
				
				if(isEnabled(driver, variablename))
				{
					BaseSuite.validationReportLog("Variable Name is clickable and Enable ");
				}
				else
				{
					BaseSuite.validationReportLog("Variable Name is Not clickable and disable ");

				}

				isDisplayed(driver, variablename);

				Thread.sleep(1000);

				click(driver, variablename);

				clear_SendKeys(driver, variablename, varName);

				BaseSuite.validationReportLog("clicked successfully on Variable Name ");
			} catch (InterruptedException e) {
				e.getMessage();
			}

		}

		public void validatingNameAndSearch(String searchValue) {
			try {

				// Use to check Search bar functionality
				int count = getcount(searchValue, ',');

				String[] result = searchValue.split(",");

				for (int colNum = 0; colNum <= count; colNum++) {

					String formulaSearch = result[colNum];
					
					if(isEnabled(driver, searchformulavalue))
					{
						BaseSuite.validationReportLog("Search field is clickable and Enable ");
					}
					else
					{
						BaseSuite.validationReportLog("Search field is Not clickable and disable ");

					}

					BaseSuite.validationReportLog("click on Search bar to search the formula value");

					displayAndClick(driver, searchformulavalue);

					BaseSuite.validationReportLog("Clicked successfully ");

					clear_SendKeys(driver, searchformulavalue, formulaSearch);

					driver.findElement(searchformulavalue).sendKeys(Keys.ENTER);

					Thread.sleep(2000);

					if (isDisplayed(driver, sercheditem)) {
						BaseSuite.validationReportLog(" Searched Result found successfully");

					} else {
						BaseSuite.validationReportLog("Searched Result didn't find ");
					}
					clear(driver, searchformulavalue);

					driver.findElement(searchformulavalue).sendKeys(Keys.ENTER);

					Thread.sleep(3000);
				}
			} catch (InterruptedException e) {

				e.getMessage();
			}
		}
		// This method use to check formulas functionality

		public void validatingformulas(String formulaValue) {
			try {
				int count = getcount(formulaValue, ',');

				String[] result = formulaValue.split(",");

				for (int colNum = 0; colNum <= count; colNum++) {

					String formulaSelection = result[colNum];

					BaseSuite.validationReportLog("Click on formula Name ");

					displayAndClick(driver, returnElement(selectformula, "$name", formulaSelection));

					BaseSuite.validationReportLog("formula Name clicked successfully ");
					/**
					WebElement element = driver.findElement(
							By.xpath("//ejs-sidebar[@id='accsidebar']//ejs-treeview[@id='template']//span//div[text()='"
									+ formulaSelection + "']"));

					Actions actions = new Actions(driver);

					wait = waitMethod(driver);

					wait.until(ExpectedConditions.visibilityOf(element));

					actions.moveToElement(element).perform();

					JavascriptExecutor js = (JavascriptExecutor) driver;

					actions.doubleClick(element).build().perform();

					Thread.sleep(2000);

					System.out.println(element);

					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

					List<WebElement> list = driver.findElements(By.xpath(
							"//span//div[text()='" + formulaSelection + "']//following::ul[@style='display: block;']//li"));

					for (int i = 0; i < list.size(); i++) {

						String val = list.get(i).getText();

						list.get(i).click();

						displayAndClick(driver, formulaexpression);

						String val1 = getAttribute(driver, formulaexpression, "value");

						clear(driver, formulaexpression);

						BaseSuite.validationReportLog("Retrived Message is :" + val);
						BaseSuite.validationReportLog("Expected Message is :" + val1.trim());

						if (val.contains(val1.trim())) {

							BaseSuite.validationReportLog("Message Successfully Matched");

						}

						else {
							BaseSuite.reportFailLog("Messages didn't match", "captureToastMsg");

						}
					}
**/
					displayAndClick(driver, returnElement(formulavalueclick, "$name", formulaSelection));

					click(driver, formulaexpression);

					Thread.sleep(3000);

				}
			} catch (InterruptedException e) {

				e.getMessage();
			}
		}
		// Use to check operator functionality

		public void validatingoperators() {

			try {
				clear(driver, formulaexpression);

				BaseSuite.validationReportLog(" Select operator ");
/**
				List<WebElement> operatorList = driver.findElements(By.xpath("//div[@class='operators-grp']//button"));

				for (int i = 0; i < operatorList.size(); i++) {

					String val = operatorList.get(i).getText();

					operatorList.get(i).click();

					displayAndClick(driver, formulaexpression);

					String valoperate = getAttribute(driver, formulaexpression, "value");

					clear(driver, formulaexpression);

					BaseSuite.validationReportLog("Retrived Message is :" + val);
					BaseSuite.validationReportLog("Expected Message is :" + valoperate.trim());

					BaseSuite.validationReportLog("operator clicked successfully ");

					if (val.contains(valoperate.trim())) {

						BaseSuite.validationReportLog("Message Successfully Matched");

					}

					else {
						BaseSuite.reportFailLog("Messages didn't match", "captureToastMsg");

					}
				}**/
			} catch (Exception e) {

				e.getMessage();
			}
		}

		// Enter value in Expression Area to Evaluate the expression-------For Excel
		public void validatingExpression(DataTestingParameters param) throws Exception {
			try {
				BaseSuite.validationReportLog("Enter Expression to evaluate for Execution ");

				displayAndClick(driver, formulaexpression);

				sendKeys(driver, formulaexpression, param.getFormulaoptionname());

				Thread.sleep(2000);

				BaseSuite.validationReportLog("Expression Enter and evaluated successfully");

				// Functionality use to check Add New Variable Button

				BaseSuite.validationReportLog("Click on Add New Variable Button to Save the Evaluation result");

				displayAndClick(driver, addvariable);

				Thread.sleep(2000);

				BaseSuite.validationReportLog(
						"successfully Saved the Evaluation result by clicking on Add New Variable Button");

			} catch (InterruptedException e) {

				e.getMessage();
			}
		}

		/*
		 * // Enter value in Expression Area to Evaluate the expression------For API
		 * public void validatingExpression(String expression) throws Exception{ try {
		 * BaseSuite.validationReportLog("Enter Expression to evaluate for Execution ");
		 * 
		 * displayAndClick(driver, formulaexpression);
		 * 
		 * sendKeys(driver, formulaexpression, expression);
		 * 
		 * Thread.sleep(2000);
		 * 
		 * BaseSuite.validationReportLog("Expression Enter and evaluated successfully");
		 * 
		 * // Functionality use to check Add New Variable Button
		 * 
		 * BaseSuite.
		 * validationReportLog("Click on Add New Variable Button to Save the Evaluation result"
		 * );
		 * 
		 * displayAndClick(driver, addvariable);
		 * 
		 * Thread.sleep(2000);
		 * 
		 * BaseSuite.validationReportLog(
		 * "successfully Saved the Evaluation result by clicking on Add New Variable Button"
		 * );
		 * 
		 * } catch (InterruptedException e) {
		 * 
		 * e.getMessage(); } }
		 */
		
		
		  public DataTestingParameters setRuleParameters() {
		  DataTestingParameters param = new DataTestingParameters(); try {
		
		  param.setRuleName(prop.getProperty("DataTesting.rulename"));
		  param.setRuleTemplateNames(prop.getProperty("DataTesting.ruleTemplateNames"));
		  param.setFolderName(prop.getProperty("DataTesting.folderName"));
		  param.setEngineTypeOption(prop.getProperty("DataTesting.EngineTypeOption"));
		  param.setRuleType(prop.getProperty("DataTesting.RuleType"));
		  param.setCalculatedNametext1(prop.getProperty("DataTesting.CalculatedNametext1"));
		  param.setCalculatedNametext2(prop.getProperty("DataTesting.CalculatedNametext2"));
		  param.setCalculatedNametext3(prop.getProperty("DataTesting.CalculatedNametext3"));
		  param.setColName1(prop.getProperty("DataTesting.colName1"));
		  param.setSourceQuery(prop.getProperty("DataTesting.SourceQuery"));
		  } catch (Exception e) {
		  
		  }
		return param; 
		}
		 
		


		// method to enter check name in name field
			public void enterCheckNametovalidatemsg(DataTestingParameters param) throws Exception {

				String cname = null;
				try {

					BaseSuite.reportLog("checking Name field is displayed or not");
					isDisplayedInLoop(driver, 10, checkNameLabel);
					javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", checkNameLabel);
					verifyIndividualLabel(driver, checkNameLabel, "Name");

					isDisplayedInLoop(driver, 10, checkNameField);

					if (isDisplayed(driver, checkNameField)) {
				
						cname = getAttribute(driver, checkNameField, "value");
						
						BaseSuite.validationReportLog(cname);
						 
						clear(driver, checkNameField);
											
						String cname2 = getText(driver, checksNameValidationError1);
						
						BaseSuite.validationReportLog("Name field is Empty so Error Msg mentioned ,"+ cname2 );

					}
					else 
					{
						BaseSuite.reportLog("unable to capture Message ,please check oince again");
						
					}
					if(isDisplayed(driver, checkNameField)) 
					{
					   Thread.sleep(1000);	
						
						driver.findElement(checkNameField).sendKeys(Keys.ENTER);
						
						sendKeys(driver, checkNameField, param.getCalculatedNametext1());
					
                        String cname3 = getText(driver, checksNameValidationError1);
                        
						BaseSuite.validationReportLog(cname3);
					}else 
					{
						BaseSuite.reportLog("unable to capture Message ,please check once again");
						
					}
					if(isDisplayed(driver, checkNameField)) 
					{
						Thread.sleep(1000);
						
						clear_Click_SendKeys(driver, 0, checkNameField, param.getCalculatedNametext2());
						
						String cname4 = getText(driver, checksNameValidationError1);
						
						BaseSuite.validationReportLog(cname4);
					}
					else 
					{
						BaseSuite.reportLog("unable to capture Message ,please check oince again");
						
					}
					if(isDisplayed(driver, checkNameField)) 
					{
						Thread.sleep(1000);
						
                        clear_Click_SendKeys(driver, 0, checkNameField, param.getCalculatedNametext3());
						
						String cname5 = getText(driver, checksNameValidationError3);
			
						Thread.sleep(1000);
					
						BaseSuite.validationReportLog(cname5);
						
						//String cname6 = getText(driver, checksNameValidationError3);
						
						//BaseSuite.validationReportLog(cname6);
					
					}
                      else {
						BaseSuite.reportFailLog("Check Name field not visible on current page", "enterCheckName");
					}
				} catch (Exception e) {
					e.getMessage();
					/*
					 * BaseSuite.reportFailLog("Name field not found kindly check",
					 * "enterCheckName"); clickOnCancelCheckButton();
					 */
					throw new Exception();
				}
			}


// Main method
public void getRuleInfoAndCreateRule20(String workspaceID, String ruleType, String ruleStateType, SoftAssert soft,String icedqRole)
		throws Throwable {
try {
	List<String> list = getRuleIdFromRuleList(workspaceID, ruleType, ruleStateType,icedqRole);

	int totalChkExpression = 0;
	ArrayList<String> expressionTypes = null;
	String connectionName = null;
	ArrayList<String> connList =null;
	DataTestingParameters xrparam = null;
	DataTestingParameters param =null;
	int cout = list.size();
	if (cout != 1) {

		for (int i = 0; i < 1; i++) {

			try {
				
				
				BaseSuite.reportLog("======================== Rule Number :" + i + " ====================");
				
				String ruleID = list.get(i).toString();
				
				BaseSuite.reportLog("==============   Creating Rule : " + (i + 1) + " reference Rule ID is : "
						+ ruleID + " ==========");
				
				System.out.println("==============   Creating Rule : " + (i + 1) + " reference Rule ID is : "
						+ ruleID + " ==========");

		
				String jsonEntity = getRuleJsonEntityUsingRuleID(workspaceID, ruleID,icedqRole);

				sourceAddColumn(jsonEntity);

				List<String> connectionList = createConnection(ruleType, jsonEntity, workspaceID, "$.objects..connectionId", soft,icedqRole);

				if(!ruleType.equalsIgnoreCase("Script")) {
					
					param = setRuleParametersForApi(workspaceID, jsonEntity,icedqRole);
				
				}else {
				
					param = setScriptRuleParametersForApi(jsonEntity,"1");
				}
			
			
		
				clickOnNextGenMenuTab("Data Testing");
				
				//addSubscription(auto, workspaceID);
		 
				verifyDataTestingLandingPage();

				//clickOnAddNewFolderOrExistingOneAPI(param,workspaceID,jsonEntity,icedqRole);

			  //  enterDetailsInAddNewPaneAPI(param,workspaceID,icedqRole);
			    
			    validationcheckforvisibility(param,"input");
				  
				clickOnMetaTab(param,soft);
				   
				enterDetailsInPropertyPane(param);
				
				if(!ruleType.equalsIgnoreCase("Script")) {

					//enterDetailsInSourceSetting(jsonEntity,param,soft);

				}

				xrparam = setExceptionReportParametersUsingApi(jsonEntity,param.getRuleType());


				switch (param.getRuleType().toLowerCase()) {

				case "checksum":

					
					//  enterDetailsInTargetDataset(jsonEntity,param,soft);
					  
					  //validateColumnNameNColumnDataType(param, jsonEntity, "target", soft);
					  
					  DataTestingParameters chkParam = setChecksParametersUsingApi(jsonEntity, param.getRuleType(), 0);
					  
					 // validateChecksumDefaultExpression(chkParam,soft);
					  
					break;
				

				case "recon":
				case "ht recon":


					//enterDetailsInTargetDataset(jsonEntity, param,  soft);

					validateColumnNameNColumnDataType(param, jsonEntity, "target", soft);

					ArrayList<String> sourceJoin = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,"$.objects[2].configuration.joins..sourceKey");

					ArrayList<String> targetJoin = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,"$.objects[2].configuration.joins..targetKey");

					for (int j = 0; j < sourceJoin.size(); j++) {


						//addJoins(sourceJoin.get(j), targetJoin.get(j));
					}

					clickOnCheckNode1();

					addChecksToRule(jsonEntity, param, soft);

					ArrayList<String> checksdetails = getCheckDetailsFromCheckSection();

					clickOnExceptionReportNode();

					//validateExceptionReportTab();

					selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

					//enableStoreFailureAndErrorsOnly(xrparam.getStoreFailureAndErrors(), soft);

					selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

					validateResultTypeOnExceptionReport(jsonEntity,"$.objects[3].configuration.checks[0].expression.values.*");

					//validateExpression(checksdetails, soft);


					break;

				case "validation":						
					
					clickOnCheckNode1();
					
					addChecksToRule(jsonEntity, param, soft);

					ArrayList<String> checksdetails1 = getCheckDetailsFromCheckSection();

					clickOnExceptionReportNode();

					//validateExceptionReportTab();

					selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

					//enableStoreFailureAndErrorsOnly(xrparam.getStoreFailureAndErrors(), soft);

					selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

					validateResultTypeOnExceptionReport(jsonEntity,"$.objects[1].configuration.checks[0].expression.values.*");

					//validateExpression(checksdetails1, soft);

					break;
					
				case "script":
					
					String scriptValue = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[?(@.id=='Script')].configuration.script");
					
					enterScriptOfScriptRule(scriptValue);
					
					ArrayList<String> connVarList = TestDataThroughApi
							.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
									"$.objects[?(@.id=='Variable')].configuration.variables..name");

					for (int a = 0; a < connVarList.size(); a++) {

						DataTestingParameters scparam = setScriptRuleParametersForApi(jsonEntity,
								Integer.toString(a));

						clickOnAddConnectionButtonInScriptObject();

//						enterConnectionVariableName(Integer.toString(a + 1),
//								scparam.getScriptConnVarName());

						selectConnectionInScriptObject(scparam.getScriptConnVarName(),
								connectionList.get(a));
						
				//		String msg = testButton(returnElement(connVarTestButton, connDynamicVar, scparam.getScriptConnVarName()));
						
						
					}
					
					break;
				
				case "pushdown":
					

					clickOnCheckNode1();
					
					uncheckDefaultResultTypeForRule(param.getRuleType());
					
					verifyAllAddedColumnNColexpName(param,jsonEntity);
					
					ArrayList<String> checksdetails2 = getCheckDetailsFromCheckSection();

					clickOnExceptionReportNode();

					//validateExceptionReportTab();

					selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

					//enableStoreFailureAndErrorsOnly(xrparam.getStoreFailureAndErrors(), soft);

					selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

					validateResultTypeOnExceptionReport(jsonEntity,"$.objects[1].configuration.checks[0].expression.values.*");

					//validateExpression(checksdetails2, soft);
					
					break;
					
				default:

					BaseSuite.reportFailLog("None of the Rule type,Kindly check", "createDBFileRules");

					break;
				}

				  // rahul's method 
					
					  int count = 0;
					  
					  if (param.getRuleType().equalsIgnoreCase("Recon") ||
					  param.getRuleType().equalsIgnoreCase("HT Recon")) { count = 4;
					  
					  ArrayList<String> summaryList =
					  getJsonArrayValueUsingJsonPathExpreesion(jsonEntity, "$.objects[" + count + "].configuration.checks..id");
					  
					  } else if (param.getRuleType().equalsIgnoreCase("Validation") ||
					  param.getRuleType().equalsIgnoreCase("HT Validation")) {
					  
					  count = 3; ArrayList<String> summaryList =
					  getJsonArrayValueUsingJsonPathExpreesion(jsonEntity, "$.objects[" + count +
					  "].configuration.checks..id"); } else { count = 2; ArrayList<String>
					  summaryList = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
					  "$.objects[" + count + "].configuration.checks..id"); } ArrayList<String>
					  summaryList = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
					  "$.objects[" + count + "].configuration.checks..id");
					  
					  int count1 = summaryList.size();
					  
					  for (int k = 0; k < count1; k++) {
					  
					  String summaryName = getJsonValueUsingJsonPathExpreesion(jsonEntity,
					  "$.objects[" + count + "].configuration.checks[" + k + "].name");
					  
					  String summaryValue = getJsonValueUsingJsonPathExpreesion(jsonEntity,
					  "$.objects[" + count + "].configuration.checks[" + k + "].expression.value");
					  
					  if (!summaryName.equalsIgnoreCase("exitcode")) {
					  
					  clickonsummarry();
					  
					  clickonnewvariabe();
					  
					  variabelName(summaryName);
					  
					  String search = prop.getProperty("DataTesting.Search");
					  
					  String formula = prop.getProperty("DataTesting.formula");
					  
					  validatingNameAndSearch(search);
					  
					  validatingformulas(formula);
					  
					  validatingoperators();
					  
					  validatingExpression(summaryValue);
					  
					  } }
					 
				 
					
				clickOnRulePublishMenuListIconBtn();
				clickOnPublishButton();
				if(ruleType.equalsIgnoreCase("Script")) {
					scriptParseButton();
				}
				//clickOnRunButton();
				//clickOnRecentRunTab_RefreshIcon();
			//	checkStatusOfRunningRule();
				clickOnExecutionLogButton();
				//printExecutionLogDetails();
				
				if (!param.getRuleType().toLowerCase().contains("checksum") || !ruleType.equalsIgnoreCase("script")) {
					
					//checkExceptionSummary("xlsx", BaseSuite.WorkspaceID, "Export All", "Download All", soft,icedqRole);
				}
			 
			}
				  
			catch (Exception e) {
				
				  System.out.println("Log " + list.get(i) + " *** \n" + e.getMessage());
				  BaseSuite.skipReportLog( "Rule :" + list.get(i) +
				  " not created successfully kindly check , " + e.getMessage());
				 
			
			} finally {
				clickOnDataTestingSubMobuleName("Rules");
				// clickOnNextGenMenuTab("Connection Repository");

			}
		}
	} else {
		BaseSuite.skipReportLog("No Rules Found inside workspace , ID : " + workspaceID);
	}
	
} catch (Exception e) {

	e.getMessage();
} finally {


}
}

//sTORY: DAT-504---> NRR-8655,NRR-8654,NRR-8643,NRR-8641 

public void publishbuttonvisibilitycheckForReaderAndExecutor(String ruleName,SoftAssert soft)
{
	try {
		
		clickOnNextGenMenuTab("Data Testing");
		
		//clickOnSearchedRuleNameOnDataTestingPage(ruleName,soft);
		
		isDisplayedInLoop(driver, 2, rulePublishButton);
		
		BaseSuite.validationReportLog("Publish button is displayed in NRR-8655 .");
		
		inVisible(driver, spinner, Constant.ruleWait);
	
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}

//sTORY: DAT-504---> NRR-8653,NRR-8652,NRR-8635,NRR-8638 
public void publishbuttonvisibilitycheckForOwnerAndContributor(DataTestingParameters param,String ruleName,SoftAssert soft)
{
	try {
		clickOnNextGenMenuTab("Data Testing");
		
		enterDetailsInAddNewPane(param);

		isDisplayedInLoop(driver, 2, rulePublishButton);

		BaseSuite.validationReportLog("Publish button is displayed.");

		inVisible(driver, spinner, Constant.ruleWait);
	} catch (Exception e) {

	}}



////story-DAT-776 ---> NRR-9083,NRR-9084,NRR-9087,NRR-9088
public void verifythatNamefieldiseditableornotForReaderAndExecutor(DataTestingParameters param,SoftAssert soft)
{
	try {
		clickOnNextGenMenuTab("Data Testing");

		verifyDataTestingLandingPage();
		
		clickOnNewRule();
		
		captureToastMsg(driver, toastMsg, ToastMsgClosedBtn, errorMessage, "No Grant to create any rule"); 

		inVisible(driver, spinner, Constant.ruleWait);
	} catch (Exception e) {

	}}

//story-DAT-776 ---> NRR-9081,NRR-9082,NRR-9085,NRR-9086,NRR-9077,NRR-9078.NRR-9066,NRR-9065
public void verifythatNamefieldiseditableornotForOwnerAndContributor(DataTestingParameters xparam,String workspaceID, String ruleName,
		String icedqRoleName, SoftAssert soft) throws Throwable {
	try {

		  DataTestingPage rule = new DataTestingPage(driver);
		  
		  TestDataThroughApi datathru = new TestDataThroughApi(driver);
		  
		  String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID,
		  icedqRoleName);
		  
		  String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,
		  icedqRoleName);
		  
		  String ruleType =
		  TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson,
		  "$.ruleType");
		  
		 // rule.clickOnNextGenMenuTab("Connections");
		  
		  // List<String> connectionList = datathru.createConnection(ruleType,ruleJson,workspaceID,"$.objects..connectionId", soft, icedqRoleName);
		  
		  DataTestingParameters param = setRuleParametersForApi(workspaceID, ruleJson,
		  icedqRoleName); rule.clickOnNextGenMenuTab("Data Testing");
		  
		  
		  rule.verifyDataTestingLandingPage();
		  
		//  rule.clickOnAddNewFolderOrExistingOneAPI(param, workspaceID, ruleJson,"",icedqRoleName);
		  
		  //rule.enterDetailsInAddNewPaneAPI(param, workspaceID,ruleName, icedqRoleName);
		  
		  enterDetailsInOverviewSection(param);
		  
		  enterDetailsInAdvancedSettingOfOverviewSection(param);
		  
		  //rule.enterDetailsInSourceSetting(ruleJson, param, soft);
		  
		  rule.clickOnCheckNode1();

		//  addChecksToRule(ruleJson, param, soft);
		 
		clickOnAddButton_checkTab();
		
		clickOnAddColumnMenuOption();

		clickOnCheckType("Calculated");
		
		enterCheckNametovalidatemsg(xparam);
		
		calculatedcancelbtn();


	} catch (Exception e) {

	}
}

//validate the overview section Title
public void overviewlabelvalidate() 
{
	try {
if(isDisplayed(driver, overviewlabel)) 
{
	String val=getText(driver, overviewlabel);
	BaseSuite.validationReportLog(val + " lablel is displayed clearly ");
	}
	else
	{
		BaseSuite.reportLog("Overview Label is fail to Displayef");
	}
	}catch(Exception e) {
		e.getMessage();
		}
}
//This Method is use to Enter the Rule Name in Overview
public void rulename(DataTestingParameters param)
{
try {
	if(isDisplayed(driver,rulenameLabel )) 
	{
		String val=getText(driver,rulenameLabel );
		BaseSuite.validationReportLog(val + " lablel is displayed clearly ");
		if (!param.getRuleName().isEmpty()) {

			String checkrule = getAttribute(driver, ruleNameField, "value");

			BaseSuite.validationReportLog(checkrule + " _Rule Name Text is displayed clearly ");
		}
		}
		else
		{
			
			BaseSuite.reportLog("Click on Rule Name");

			clear_SendKeys(driver, ruleNameField, param.getRuleName());

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			BaseSuite.validationReportLog("Rule Name field is visible and Editable");

		}
}catch (Exception e) {
	e.getMessage();
	}
} 
//This Method is use to Enter the Rule Code in Overview
	public void RuleCode(DataTestingParameters param) {

		try {
			if(isDisplayed(driver,rulecodeLabel ))
			{
				String val=getText(driver,rulecodeLabel );
				BaseSuite.validationReportLog(val + " lablel is displayed clearly ");
			
				if (!param.getRuleCode().isEmpty()) {
					if (isDisplayed(driver, rulecodeField))

						displayAndClick(driver, rulecodeField);
					

					BaseSuite.reportLog("Entering code in Rule code field");

					sendKeys(driver, rulecodeField, param.getRuleCode());
					
					String checkrulecode = getAttribute(driver, rulecodeField, "value");

					BaseSuite.validationReportLog(checkrulecode + " Code Entered in Rule code field");

				}
			}
		
		} catch (Exception e) {

			e.getMessage();
		}
	}
	// This Method is use to Enter the Detailed Description in overview
	public void description(DataTestingParameters param) {

		try {
			if(isDisplayed(driver,descriptionLabel ))
			{
				String val=getText(driver,descriptionLabel );
				BaseSuite.validationReportLog(val + " lablel is displayed clearly ");
				if (!param.getDescription().isEmpty()) {
					if (isDisplayed(driver, descriptionField)) {

						displayAndClick(driver, descriptionField);

						BaseSuite.reportLog("Entering description in Description field");

						sendKeys(driver, descriptionField, param.getDescription());
						
						String descriptiondata = getAttribute(driver, descriptionField, "value");


						BaseSuite.validationReportLog(descriptiondata + " Description Entered in description field");
					}
				}
			
			}
		} catch (Exception e) {

			e.getMessage();
		}
	}
	// This Method is to use to filled the purpose field for overview
		public void purpose(DataTestingParameters param) {

			try {
				if(isDisplayed(driver,purposeLabel ))
				{
					String val=getText(driver,purposeLabel );
					BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

				if (param.getPurpose() != null) {
					if (!param.getPurpose().isEmpty()) {
						if (isDisplayed(driver, purposeField)) {

							displayAndClick(driver, purposeField);

							BaseSuite.reportLog("Entering Data in Purpose field");

							sendKeys(driver, purposeField, param.getPurpose());
							
							String purposedata = getAttribute(driver, purposeField, "value");

							BaseSuite.validationReportLog(purposedata + " Data Entered in Purpose field ");

						}

					}
				}
				}

			} catch (Exception e) {

				e.getMessage();

			}

		}
		// This Method is to check the criticality of the rule
		public void criticality(DataTestingParameters param) {
			try {
				if(isDisplayed(driver,purposeLabel ))
				{
					String val=getText(driver,criticalityLabel );
					BaseSuite.validationReportLog(val + " lablel is displayed clearly ");
				}
				BaseSuite.reportLog("Click on Criticality option");

				javascript(driver, "arguments[0].scrollIntoView(true);", criticalityclick);

				Actions actions = new Actions(driver);

				wait = waitMethod(driver);

				actions.moveToElement(driver.findElement(criticalityclick)).perform();

				wait.until(ExpectedConditions.visibilityOfElementLocated(criticalityclick));
				
				Thread.sleep(1000);

				actions.click(driver.findElement(criticalityclick)).build().perform();

				//displayAndClick(driver, propertiesCriticality);

				//javascript(driver, "arguments[0].click();", propertiesCriticality);

				BaseSuite.validationReportLog("Criticality option Clicked successfully");

				javascript(driver, "arguments[0].scrollIntoView(({behavior:'smooth'})).click();",returnElement(criticalityselect, "$name", param.getCriticality()));
				
				String criticalitydata = getAttribute(driver,criticalityclick, "class");

				BaseSuite.validationReportLog(" Ciriticality option Selected " + criticalitydata);
				
			} catch (Exception e) {

				e.getMessage();
			}
		}
		
		

		// This Method is to use click on the Stop At Row option
		public void stopAtRow(DataTestingParameters param) {
			try {
				if(isDisplayed(driver,stopAtRowLabel ))
				{
					String val=getText(driver,stopAtRowLabel );
					BaseSuite.validationReportLog(val + " lablel is displayed clearly ");
				}
				int count = 1;
				if (Integer.parseInt(param.getStopAtRow()) > count) {
					
					javascript(driver, "arguments[0].scrollIntoView(true);",stopAtRowField);

					sendKeys(driver, stopAtRowField, param.getStopAtRow());
					
					String val = getText(driver, stopAtRowField);


					BaseSuite.validationReportLog(val + "Stop At Row field is visible & ready to Update");
				}

			} catch (Exception e) {

				e.getMessage();
			}
		}

		// This Method is to use Click on Stop At Error option
		public void stopAtError(DataTestingParameters param) {
			try {
				if(isDisplayed(driver,stopAtErrorLabel ))
				{
					String val=getText(driver,stopAtErrorLabel );
					BaseSuite.validationReportLog(val + " lablel is displayed clearly ");
				}
				int count = 1;
				if (Integer.parseInt(param.getStopAtError()) > count) {
					BaseSuite.reportLog("Click on Stop At Error");

					clear_SendKeys(driver, stopAtErrorField, param.getStopAtError());
					
					String val = getText(driver, stopAtErrorField);

					BaseSuite.validationReportLog(val + " Stop At Error field is visible & ready to Update");
				}

			} catch (Exception e) {

				e.getMessage();
			}
		}

		// this Method is use to check UI-validation

		// This Method is to use click on Stop At Time option
		public void stopAtTime(DataTestingParameters param) throws InterruptedException {
			try {
				if(isDisplayed(driver,stopAtAfterTimeLabel ))
				{
					String val=getText(driver,stopAtAfterTimeLabel );
					BaseSuite.validationReportLog(val + " lablel is displayed clearly ");
				}
				int count = 5;
				if (Integer.parseInt(param.getStopAtTime()) > count) {
					{
						BaseSuite.reportLog("Click on Stop At Time");
						
						javascript(driver, "arguments[0].scrollIntoView(true);",stopAfterTimeField);

						clear_SendKeys(driver, stopAfterTimeField, param.getStopAtTime());
						
						Thread.sleep(2000);
						
						String val = getText(driver, stopAfterTimeField);

						BaseSuite.validationReportLog(val + " Stop At Time field is visible & ready for Use");
						
					}
				}
			} catch (Exception e) {

				e.getMessage();
			}
		}

		// This Method is use to Select the Parameter
		public void parameterSection(DataTestingParameters param) {
			try {
				if(isDisplayed(driver,parameterLabel ))
				{
					String val=getText(driver,parameterLabel );
					BaseSuite.validationReportLog(val + " lablel is displayed clearly ");
				}

				if (param.getParameterFilename() != null) {

					if (!param.getParameterFilename().isEmpty()) {

						BaseSuite.reportLog("Click on Select Parameter option");

						isDisplayedInLoop(driver, 10, parameterclick);
					
						Actions actions = new Actions(driver);

						wait = waitMethod(driver);

						javascript(driver, "arguments[0].scrollIntoView(true);",parameterclick);
						
						actions.moveToElement(driver.findElement(parameterclick)).clickAndHold().perform();

						wait.until(ExpectedConditions.visibilityOfElementLocated(parameterclick));
					
						BaseSuite.validationReportLog("Parameter option Clicked successfully");

						clear_Click_SendKeys(driver, 0, parameterSearch, param.getParameterFilename());

						Thread.sleep(1000);

						BaseSuite.validationReportLog("Parameter option is ready to search Parameter's");

						driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

						displayAndClick(driver,returnElement(parameterSelect, "$name", param.getParameterFilename()));
						
						Thread.sleep(1000);

						//javascript(driver, "arguments[0].scrollIntoView(true);",returnElement(propertiesselectParameter,"$name", param.getParameterFilename()));

						BaseSuite.validationReportLog("Parameter Selected successfully");
					}
				}

			} catch (Exception e) {
				e.getMessage();
			}
		}
		// This Method is to check the Switch button Working
				public void switchbutton(DataTestingParameters param) {
					try {
						if(isDisplayed(driver,switchbtnLabel ))
						{
							String val=getText(driver,switchbtnLabel );
							
							BaseSuite.validationReportLog(val + " lablel is displayed clearly ");
							
							
						}
						if (param.getEnableactiveOption().equalsIgnoreCase("True"))

						{

							BaseSuite.validationReportLog("Activate is already checked");

						} else {

						displayAndClick(driver, switchbtn);

							BaseSuite.validationReportLog("Deactivate is checked");
						}
					} catch (Exception e) {

						e.getMessage();
					}
				}
		// This Method is use to enter details in Degree of parallelism(DOP)
		public void DegreeOfPeralleilsm(DataTestingParameters param) {
			try {
				if(isDisplayed(driver,dopLabel ))
				{
					String val=getText(driver,dopLabel );
					BaseSuite.validationReportLog(val + " lablel is displayed clearly ");
				}
				int count1 = 1;
				if (Integer.parseInt(param.getDop()) < count1) {
					if (!param.getDop().isEmpty()) {

						BaseSuite.validationReportLog("Entering Value in DOP");

						sendKeys(driver, dopField, param.getDop());

						BaseSuite.validationReportLog("Entered Value in DOP successfully");

					}
				}
			} catch (Exception e) {
				e.getMessage();
			}

		}
		public void enterDetailsInOverviewSection(DataTestingParameters xparam) 
		{
			try {
				//overviewlabelvalidate();
				  
				  rulename(xparam);
				  
				  RuleCode(xparam);
				  
				  description(xparam);
				  
				  purpose(xparam);
				 
				criticality(xparam);
				
			} catch (Exception e) {
				
			}
		}
		//Main method to check the Advanced setting working or not 
		public void enterDetailsInAdvancedSettingOfOverviewSection(DataTestingParameters param) throws InterruptedException {
			try {
				
				if(isDisplayed(driver,advanceSettingLabel ))
				{
					String val=getText(driver,advanceSettingLabel );
					
					BaseSuite.validationReportLog(val + " Title is displayed clearly ");
					
					javascript(driver, "arguments[0].scrollIntoView(true);",advanceSettingLabel);
				}
				

				if (param.getEngineTypeOption().equalsIgnoreCase("High Throughput")
						|| param.getEngineTypeOption().equalsIgnoreCase("Cluster")) {

					DegreeOfPeralleilsm(param);

				}

				if (param.getRuleType().equalsIgnoreCase("Validation") || param.getRuleType().equalsIgnoreCase("Recon")) {

					stopAtRow(param);

					if (!param.getRuleType().equalsIgnoreCase("pushdown")) {
						stopAtError(param);
					}

				stopAtTime(param);

				}

				parameterSection(param);
				
			//	switchbutton(param);

				

			} catch (Exception e) {

				e.getMessage();
			}
		}
		
		public void ExecutiorAndReaderGrantDontHavePrivilagesForRuleCreation()
	    {
	        try {
	           if(isDisplayed(driver, toastMsg))
	            {
	                captureToastMsg(driver, toastMsg, popUpClose, connectionTestMess, "Executior/Reader User");

	           }
	            else
	            {
	                BaseSuite.reportFailLog("Toast message not visible kindly check - issue id ",
	                        "clickOnNewRuleUserSpecific");
	                isDisplayedInLoop(driver, 2, newRuleCancelBtn);
	                displayAndClick(driver, newRuleCancelBtn);
	                throw new AssertionError("Test case failed!");
	            }
	            
	        } catch (Exception e) {
	            
	            e.getMessage();
	        
	        }
	        
	    }
		
		public void closeCursorFromAddColumn() 
		{
			try {
				if (isDisplayed(driver, closeCursor)) {
					isClickable(driver, closeCursor, "Add Column Close", true);
					displayAndClick(driver, closeCursor);
					BaseSuite.validationReportLog("Source column close Cursor is clicked successfully.");
				} else {
					BaseSuite.reportFailLog("Source column close Cursor is not visible neither clickable",
							"closeCursorFromAddColumn");
				}
			} catch (Exception e) {

				e.getMessage();
			}
			
		}
		public void calculatedcancelbtn()
		{
			try {
				BaseSuite.validationReportLog("Click on Cancel button Please");

				click(driver, calculatedcolumnCancelbtn);
				
				BaseSuite.validationReportLog("Cancel button clicked succcessfully");
			} catch (Exception e) {
				e.getMessage();
			}
		}
		
		public void calulatedColumnsearchtab(DataTestingParameters param)
		{
			try {

				if (isEnabled(driver, calculatedcolumnsearchBar)) {
					BaseSuite.validationReportLog("Search field is clickable and Enable ");
				} else {
					BaseSuite.validationReportLog("Search field is Not clickable and disable ");

				}

				BaseSuite.validationReportLog("click on Search bar to search the formula value");

				displayAndClick(driver, calculatedcolumnsearchBar);

				BaseSuite.validationReportLog("Clicked successfully ");

				clear_SendKeys(driver, calculatedcolumnsearchBar, param.getCalculatedNametext1());

				click(driver, calculatedcolumnsearchbtn);

				BaseSuite.validationReportLog("clicked on search Bar and clear the data ");

				clear(driver, calculatedcolumnsearchBar);
				
				click(driver, calculatedcolumnsearchbtn);

				BaseSuite.validationReportLog(" Data Clear from Search bar successfully ");

				verifyVisibilityOfButtons(driver, calculatedcolumnsavebtn, "calculated save button", false);
				verifyVisibilityOfButtons(driver, calculatedcolumnsaveandNextbtn,"calculated column save and Next button", false);
				verifyVisibilityOfButtons(driver, calculatedChangecolumnbtn, "change column button", true);
				verifyVisibilityOfButtons(driver, calculatedcolumnCancelbtn, "cancel button", true);
				verifyVisibilityOfButtons(driver, CloseIcon, "close cursor", true);
				// calculatedcancelbtn();

			} catch (Exception e) {
				e.getMessage();
			}

		}
		public void checkSourcetTemplateTochoosefieldsAreDisplayedasEnabledinAddColumn(String ColName1) {
			try {
				
			
				
				
				  if (isDisplayed(driver,srccolumnSearchbox)){
				  
				  isDisplayedInLoop(driver, 1, srccolumnSearchbox);
				  
				  sendKeys(driver, check_AddCol_Sidebar_searchBox, ColName1);
				  
				  BaseSuite.reportLog("Search box is displayed on side bar.");
				  
				  displayAndClick(driver, srccolumnSearchBtn);
				  
				  BaseSuite.validationReportLog("Search button clicked successfully.");
				  
				  Thread.sleep(1000);
				  
                   click(driver, sourcecolumnclearbtn);			  
				  }else { BaseSuite.
				  reportErrorLog("Unable to search as search box is disable, kindly check."); }
				 
				
				  
				 verifyVisibilityOfButtons(driver, sourcecolumnaddbtn, "Add Button", false);
				 getPaginationDetails(pageMsg1, pageArrows1);
               verifyVisibilityOfButtons(driver, changeColumnbtn, "change Column", true);
               verifyVisibilityOfButtons(driver, check_AddColumn_Sidebar_CancelBtn, "cancel button", true);
           
               closeCursorFromAddColumn();
               
			} catch (Exception e) {
				e.getMessage();
			}
		}
		public void checkSourceColumnPageAndValidateSame(String colName1) {
			try {
				
				verifyIndividualLabel(driver, changeColumnbtn, "sourceColumn");
				
				if (isDisplayed(driver,check_AddCol_Sidebar_searchBox)){
					
					isDisplayedInLoop(driver, 1, check_AddCol_Sidebar_searchBox);
					
					BaseSuite.reportLog("Search box is displayed on side bar.");
					
					displayAndClick(driver, check_AddCol_Sidebar_searchBtn);
					
					BaseSuite.validationReportLog("Search button clicked successfully.");
					
				 
				}else {
					BaseSuite.reportErrorLog("Unable to search as search box is disable, kindly check.");
				}
				
				  if (isDisplayed(driver,sourceColumnCheckbox))
				  { 
				  BaseSuite.reportLog("Column with name :- " + colName1 + " is displayed.");
				  
				  displayAndClick(driver,sourceColumnCheckbox);
				  
				  displayAndClick(driver,sourceColumnCheckbox);
				  
				  BaseSuite.validationReportLog("Column with name :- " + colName1 +
				  " is Selected."); 
				  }else 
				  {
				  
				  BaseSuite.reportErrorLog("Unable to find specific column, kindly check.");
				  
				  }
				 
				 getPaginationDetails(pageMsg1, pageArrows1);
               verifyVisibilityOfButtons(driver, changeColumnbtn, "change Column", true);
               verifyVisibilityOfButtons(driver, check_AddColumn_Sidebar_CancelBtn, "cancel button", true);
               verifyVisibilityOfButtons(driver, check_AddColumn_Sidebar_AddBtn, "Add Button", false);
       
               closeCursorFromAddColumn();
               
			} catch (Exception e) {
				e.getMessage();
			}
		}
		
		//Story-776 ticket.NRR-9250,NRR-9251,NRR-9246,NRR-9247,NRR-9079,NRR-9080,NRR-9076,NRR-9075,NRR-9027,NRR-9028,NRR-9023,NRR-9024,NRR-9014,NRR-9015,NRR-9018,NRR-9019
		public void crossIconButtonFuctionalityofColumnPane(DataTestingParameters param) throws InterruptedException
		{
			try {
			
				clickOnNextGenMenuTab("Data Testing");

				verifyDataTestingLandingPage();
				
				clickOnNewRule();
				
				inVisible(driver, spinner, Constant.ruleWait);
				
				captureToastMsg(driver, toastMsg, popUpClose, errorMessage, "Executior/Reader User Don't have access to create Rule"); 

				
		} catch (Exception e) {
			
			e.getMessage();
			
		}
			}
		
		//story-776 ticket.NRR-9248,NRR-9249,NRR-9244,NRR-9245
		public void crossIconButtonFuctionalityofColumnPaneForOwnerAndContributor(String workspaceID, String ruleName,
				String icedqRoleName, SoftAssert soft) throws Throwable
		{
			try {
				DataTestingPage rule = new DataTestingPage(driver);

				TestDataThroughApi datathru = new TestDataThroughApi(driver);

				String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID, icedqRoleName);

				String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID, icedqRoleName);

				String ruleType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson, "$.ruleType");

				//rule.clickOnNextGenMenuTab("Connections");

				//List<String> connectionList = datathru.createConnection(ruleType, ruleJson, workspaceID,"$.objects..connectionId", soft, icedqRoleName);

				DataTestingParameters param = datathru.setRuleParametersForApi(workspaceID, ruleJson, icedqRoleName);

				rule.clickOnNextGenMenuTab("Data Testing");

				// rule.verifyDataTestingLandingPage();

			//	rule.clickOnAddNewFolderOrExistingOneAPI(param, workspaceID, ruleName, ruleJson, icedqRoleName);

				//rule.enterDetailsInAddNewPaneAPI(param, workspaceID, ruleName, icedqRoleName);

				//rule.enterDetailsInOverviewSection(param);

				rule.enterDetailsInAdvancedSettingOfOverviewSection(param);

				//rule.enterDetailsInSourceSetting(ruleJson, param, soft);

				rule.clickOnCheckNode1();

				// addChecksToRule(ruleJson, param, soft);

				clickOnAddButton_checkTab();

				// clickOnAddButtonSideMenu();

				clickOnAddColumnMenuOption();

				closeCursorFromAddColumn();

			} catch (Exception e) {

				e.getMessage();
			}
		}
		
		//Story-776 ticket.NRR-9242,NRR-9243,NRR-9238,NRR-9239,
		public void crossIconButtonFuctionalityofAddColumn(DataTestingParameters param) throws InterruptedException
		{
			try {
			
				clickOnNextGenMenuTab("Data Testing");

				verifyDataTestingLandingPage();
				
				clickOnNewRule();
				
				inVisible(driver, spinner, Constant.ruleWait);
				
				captureToastMsg(driver, toastMsg, popUpClose, errorMessage, "Executior/Reader User Don't have access to create Rule"); 

				
		} catch (Exception e) {
			
			e.getMessage();
			
		}
			}
		
		//story-776 ticket.NRR-9236,NRR-9237,NRR-9240,NRR-9241,NRR-9012,NRR-9013,NRR-9016,NRR-9017
				public void crossIconButtonFuctionalityofAddColumnForOwnerAndContributor(String workspaceID, String ruleName,
						String icedqRoleName, SoftAssert soft) throws Throwable
				{
					try {
						
						
						  DataTestingPage rule = new DataTestingPage(driver);
						  
						  TestDataThroughApi datathru = new TestDataThroughApi(driver);
						  
						  String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID,
						  icedqRoleName);
						  
						  String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,
						  icedqRoleName);
						  
						  String ruleType =
						  TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson,
						  "$.ruleType");
						  
						  //rule.clickOnNextGenMenuTab("Connections");
						  
						  //List<String> connectionList = datathru.createConnection(ruleType, ruleJson, workspaceID,"$.objects..connectionId", soft, icedqRoleName);
						  
						  DataTestingParameters param = datathru.setRuleParametersForApi(workspaceID,
						  ruleJson, icedqRoleName);
						  
						  // rule.clickOnNextGenMenuTab("Data Testing");
						  
						  //rule.verifyDataTestingLandingPage();
						  
						//  rule.clickOnAddNewFolderOrExistingOneAPI(param, workspaceID,icedqRoleName);
						  
						 // rule.enterDetailsInAddNewPaneAPI(param, workspaceID, ruleName,
						 // icedqRoleName);
						  
						  //rule.enterDetailsInOverviewSection(param);
						  
						  rule.enterDetailsInAdvancedSettingOfOverviewSection(param);
						  
						 // rule.enterDetailsInSourceSetting(ruleJson, param, soft);
						  
						  rule.clickOnCheckNode1();
						  
						  clickOnAddButton_checkTab();
						  
						  clickOnAddColumnMenuOption();
						  
						  rule.clickOnColumnType("source");
						 
						 
						 
						checkSourcetTemplateTochoosefieldsAreDisplayedasEnabledinAddColumn("sex");


						
					} catch (Exception e) {

						e.getMessage();
					}
				}
				
				//story-DAT-776 --->NRR-9020,NRR-9021,NRR-9025,NRR-9026
				public void validatefromColumnpaneforcontributororOwnergrantusertochooseCalculatedtemplate(DataTestingParameters xparam,String workspaceID, String ruleName,
						String icedqRoleName, SoftAssert soft) throws Throwable {
					try {

						  DataTestingPage rule = new DataTestingPage(driver);
						  
						  TestDataThroughApi datathru = new TestDataThroughApi(driver);
						  
						  String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID,
						  icedqRoleName);
						  
						  String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,
						  icedqRoleName);
						  
						  String ruleType =TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson,"$.ruleType");
						  
						 // rule.clickOnNextGenMenuTab("Connections");
						  
						  // List<String> connectionList = datathru.createConnection(ruleType,ruleJson,workspaceID,"$.objects..connectionId", soft, icedqRoleName);
						  
						  DataTestingParameters param = setRuleParametersForApi(workspaceID, ruleJson,
						  icedqRoleName); rule.clickOnNextGenMenuTab("Data Testing");
						  
						  
						 rule.verifyDataTestingLandingPage();
						  
						  //rule.clickOnAddNewFolderOrExistingOneAPI(param, workspaceID,  icedqRoleName);
						  
						//  rule.enterDetailsInAddNewPaneAPI(param, workspaceID,ruleName, icedqRoleName);
						  
						  enterDetailsInOverviewSection(param);
						  
						  enterDetailsInAdvancedSettingOfOverviewSection(param);
						  
						 // rule.enterDetailsInSourceSetting(ruleJson, param, soft);
						  
						  rule.clickOnCheckNode1();

						clickOnAddButton_checkTab();
						
						clickOnAddColumnMenuOption();

						clickOnCheckType("Calculated");
						
						calulatedColumnsearchtab(xparam);
						
						


					} catch (Exception e) {

					}
				}
				//story-776 ticket.NRR-9012,NRR-9013,NRR-9016,NRR-9017
				public void chooseSourcetemplatefromColumnpanethenrequiredfieldsorbuttonsaredisplayedasEnabledordisabledinAddColumnpane(String workspaceID, String ruleName,
						String icedqRoleName, SoftAssert soft) throws Throwable
				{
					try {
						DataTestingPage rule = new DataTestingPage(driver);

						TestDataThroughApi datathru = new TestDataThroughApi(driver);

						String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID, icedqRoleName);

						String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID, icedqRoleName);

						String ruleType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson, "$.ruleType");

						rule.clickOnNextGenMenuTab("Connections");

						List<String> connectionList = datathru.createConnection(ruleType, ruleJson, workspaceID,
								"$.objects..connectionId", soft, icedqRoleName);

						DataTestingParameters param = datathru.setRuleParametersForApi(workspaceID, ruleJson, icedqRoleName);

						rule.clickOnNextGenMenuTab("Data Testing");

					    rule.verifyDataTestingLandingPage();

					//	rule.clickOnAddNewFolderOrExistingOneAPI(param, workspaceID, icedqRoleName);

						//rule.enterDetailsInAddNewPaneAPI(param, workspaceID, ruleName, icedqRoleName);

						//rule.enterDetailsInOverviewSection(param);

						rule.enterDetailsInAdvancedSettingOfOverviewSection(param);

						//rule.enterDetailsInSourceSetting(ruleJson, param, soft);

						rule.clickOnCheckNode1();

						clickOnAddButton_checkTab();

						clickOnAddColumnMenuOption();
						
						rule.clickOnColumnType("source");
						
						checkSourceColumnPageAndValidateSame("colName1");

						
					} catch (Exception e) {

						e.getMessage();
					}
				}
				/*
				//Rahul's New methods for story DAT-776
				public void ExecutiorAndReaderGrantDontHavePrivilagesForRuleCreation()
			    {
			        try {
			           if(isDisplayed(driver, toastMsg))
			            {
			                captureToastMsg(driver, toastMsg, popUpClose, connectionTestMess, "Executior/Reader User");

			           }
			            else
			            {
			                BaseSuite.reportFailLog("Toast message not visible kindly check - issue id ",
			                        "clickOnNewRuleUserSpecific");
			                isDisplayedInLoop(driver, 2, newRuleCancelBtn);
			                displayAndClick(driver, newRuleCancelBtn);
			                throw new AssertionError("Test case failed!");
			            }
			            
			        } catch (Exception e) {
			            
			            e.getMessage();
			        
			        }
			        
			    }
				
				public void closeCursorFromAddColumn() 
				{
					try {
						if (isDisplayed(driver, closeCursor)) {
							isClickable(driver, closeCursor, "Add Column Close", true);
							displayAndClick(driver, closeCursor);
							BaseSuite.validationReportLog("Source column close Cursor is clicked successfully.");
						} else {
							BaseSuite.reportFailLog("Source column close Cursor is not visible neither clickable",
									"closeCursorFromAddColumn");
						}
					} catch (Exception e) {

						e.getMessage();
					}
					
				}
				public void calculatedcancelbtn()
				{
					try {
						BaseSuite.validationReportLog("Click on Cancel button Please");

						click(driver, calculatedcolumnCancelbtn);
						
						BaseSuite.validationReportLog("Cancel button clicked succcessfully");
					} catch (Exception e) {
						e.getMessage();
					}
				}
				
				public void calulatedColumnsearchtab(DataTestingParameters param)
				{
					try {

						if (isEnabled(driver, calculatedcolumnsearchBar)) {
							BaseSuite.validationReportLog("Search field is clickable and Enable ");
						} else {
							BaseSuite.validationReportLog("Search field is Not clickable and disable ");

						}

						BaseSuite.validationReportLog("click on Search bar to search the formula value");

						displayAndClick(driver, calculatedcolumnsearchBar);

						BaseSuite.validationReportLog("Clicked successfully ");

						clear_SendKeys(driver, calculatedcolumnsearchBar, param.getCalculatedNametext1());

						click(driver, calculatedcolumnsearchbtn);

						BaseSuite.validationReportLog("clicked on search Bar and clear the data ");

						clear(driver, calculatedcolumnsearchBar);
						
						click(driver, calculatedcolumnsearchbtn);

						BaseSuite.validationReportLog(" Data Clear from Search bar successfully ");

						verifyVisibilityOfButtons(driver, calculatedcolumnsavebtn, "calculated save button", false);
						verifyVisibilityOfButtons(driver, calculatedcolumnsaveandNextbtn,"calculated column save and Next button", false);
						verifyVisibilityOfButtons(driver, calculatedChangecolumnbtn, "change column button", true);
						verifyVisibilityOfButtons(driver, calculatedcolumnCancelbtn, "cancel button", true);
						verifyVisibilityOfButtons(driver, CloseIcon, "close cursor", true);
						// calculatedcancelbtn();

					} catch (Exception e) {
						e.getMessage();
					}

				}
				public void checkSourcetTemplateTochoosefieldsAreDisplayedasEnabledinAddColumn(String ColName1) {
					try {
						
					
						
						
						  if (isDisplayed(driver,srccolumnSearchbox)){
						  
						  isDisplayedInLoop(driver, 1, srccolumnSearchbox);
						  
						  sendKeys(driver, check_AddCol_Sidebar_searchBox, ColName1);
						  
						  BaseSuite.reportLog("Search box is displayed on side bar.");
						  
						  displayAndClick(driver, srccolumnSearchBtn);
						  
						  BaseSuite.validationReportLog("Search button clicked successfully.");
						  
						  Thread.sleep(1000);
						  
		                   click(driver, sourcecolumnclearbtn);			  
						  }else { BaseSuite.
						  reportErrorLog("Unable to search as search box is disable, kindly check."); }
						 
						
						  
						 verifyVisibilityOfButtons(driver, sourcecolumnaddbtn, "Add Button", false);
						 getPaginationDetails(pageMsg1, pageArrows1);
		               verifyVisibilityOfButtons(driver, changeColumnbtn, "change Column", true);
		               verifyVisibilityOfButtons(driver, check_AddColumn_Sidebar_CancelBtn, "cancel button", true);
		           
		               closeCursorFromAddColumn();
		               
					} catch (Exception e) {
						e.getMessage();
					}
				}
				public void checkSourceColumnPageAndValidateSame(String colName1) {
					try {
						
						verifyIndividualLabel(driver, changeColumnbtn, "sourceColumn");
						
						if (isDisplayed(driver,check_AddCol_Sidebar_searchBox)){
							
							isDisplayedInLoop(driver, 1, check_AddCol_Sidebar_searchBox);
							
							BaseSuite.reportLog("Search box is displayed on side bar.");
							
							displayAndClick(driver, check_AddCol_Sidebar_searchBtn);
							
							BaseSuite.validationReportLog("Search button clicked successfully.");
							
						 
						}else {
							BaseSuite.reportErrorLog("Unable to search as search box is disable, kindly check.");
						}
						
						  if (isDisplayed(driver,sourceColumnCheckbox))
						  { 
						  BaseSuite.reportLog("Column with name :- " + colName1 + " is displayed.");
						  
						  displayAndClick(driver,sourceColumnCheckbox);
						  
						  displayAndClick(driver,sourceColumnCheckbox);
						  
						  BaseSuite.validationReportLog("Column with name :- " + colName1 +
						  " is Selected."); 
						  }else 
						  {
						  
						  BaseSuite.reportErrorLog("Unable to find specific column, kindly check.");
						  
						  }
						 
						 getPaginationDetails(pageMsg1, pageArrows1);
		               verifyVisibilityOfButtons(driver, changeColumnbtn, "change Column", true);
		               verifyVisibilityOfButtons(driver, check_AddColumn_Sidebar_CancelBtn, "cancel button", true);
		               verifyVisibilityOfButtons(driver, check_AddColumn_Sidebar_AddBtn, "Add Button", false);
		       
		               closeCursorFromAddColumn();
		               
					} catch (Exception e) {
						e.getMessage();
					}
				}
				
				//Story-776 ticket.NRR-9250,NRR-9251,NRR-9246,NRR-9247,NRR-9079,NRR-9080,NRR-9076,NRR-9075,NRR-9027,NRR-9028,NRR-9023,NRR-9024,NRR-9014,NRR-9015,NRR-9018,NRR-9019
				public void crossIconButtonFuctionalityofColumnPane(DataTestingParameters param) throws InterruptedException
				{
					try {
					
						clickOnNextGenMenuTab("Data Testing");

						verifyDataTestingLandingPage();
						
						enterDetailsInAddNewPane(param);
						
						//inVisible(driver, spinner, Constant.ruleWait);
						
						ExecutiorAndReaderGrantDontHavePrivilagesForRuleCreation(); 

						
				} catch (Exception e) {
					
					e.getMessage();
					
				}
					}
				
				//story-776 ticket.NRR-9248,NRR-9249,NRR-9244,NRR-9245
				public void crossIconButtonFuctionalityofColumnPaneForOwnerAndContributor(String workspaceID, String ruleName,
						String icedqRoleName, SoftAssert soft)
				{
					try {
						DataTestingPage rule = new DataTestingPage(driver);

						TestDataThroughApi datathru = new TestDataThroughApi(driver);

						String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID, icedqRoleName);

						String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID, icedqRoleName);

						String ruleType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson, "$.ruleType");

						rule.clickOnNextGenMenuTab("Connections");

						List<String> connectionList = datathru.createConnection(ruleType, ruleJson, workspaceID,
								"$.objects..connectionId", soft, icedqRoleName);

						DataTestingParameters param = datathru.setRuleParametersForApi(workspaceID, ruleJson, icedqRoleName);

						rule.clickOnNextGenMenuTab("Data Testing");

						// rule.verifyDataTestingLandingPage();

						rule.clickOnAddNewFolderOrExistingOneAPI(param, workspaceID, ruleName, ruleJson, icedqRoleName);

						rule.enterDetailsInAddNewPaneAPI(param, workspaceID, ruleName, icedqRoleName);

						rule.enterDetailsInOverviewSection(param);

						rule.enterDetailsInAdvancedSettingOfOverviewSection(param);

						rule.enterDetailsInSourceSetting(ruleJson, param, soft);

						rule.clickOnCheckNode1();

						// addChecksToRule(ruleJson, param, soft);

						clickOnAddButton_checkTab();

						// clickOnAddButtonSideMenu();

						clickOnAddColumnMenuOption();

						closeCursorFromAddColumn();

					} catch (Exception e) {

						e.getMessage();
					}
				}
				
				//Story-776 ticket.NRR-9242,NRR-9243,NRR-9238,NRR-9239,
				public void crossIconButtonFuctionalityofAddColumn(DataTestingParameters param) throws InterruptedException
				{
					try {
					
						clickOnNextGenMenuTab("Data Testing");

						verifyDataTestingLandingPage();
						
						enterDetailsInAddNewPane(param);
						
						//inVisible(driver, spinner, Constant.ruleWait);
						
						ExecutiorAndReaderGrantDontHavePrivilagesForRuleCreation(); 

						
				} catch (Exception e) {
					
					e.getMessage();
					
				}
					}
				
				//story-776 ticket.NRR-9236,NRR-9237,NRR-9240,NRR-9241,NRR-9012,NRR-9013,NRR-9016,NRR-9017
						public void crossIconButtonFuctionalityofAddColumnForOwnerAndContributor(String workspaceID, String ruleName,
								String icedqRoleName, SoftAssert soft)
						{
							try {
								
								
								  DataTestingPage rule = new DataTestingPage(driver);
								  
								  TestDataThroughApi datathru = new TestDataThroughApi(driver);
								  
								  String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID,
								  icedqRoleName);
								  
								  String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,
								  icedqRoleName);
								  
								  String ruleType =
								  TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson,
								  "$.ruleType");
								  
								  //rule.clickOnNextGenMenuTab("Connections");
								  
								  //List<String> connectionList = datathru.createConnection(ruleType, ruleJson, workspaceID,"$.objects..connectionId", soft, icedqRoleName);
								  
								  DataTestingParameters param = datathru.setRuleParametersForApi(workspaceID,
								  ruleJson, icedqRoleName);
								  
								  // rule.clickOnNextGenMenuTab("Data Testing");
								  
								  //rule.verifyDataTestingLandingPage();
								  
								  rule.clickOnAddNewFolderOrExistingOneAPI(param, workspaceID, ruleName,
								  ruleJson, icedqRoleName);
								  
								  rule.enterDetailsInAddNewPaneAPI(param, workspaceID, ruleName,
								  icedqRoleName);
								  
								  rule.enterDetailsInOverviewSection(param);
								  
								  rule.enterDetailsInAdvancedSettingOfOverviewSection(param);
								  
								  rule.enterDetailsInSourceSetting(ruleJson, param, soft);
								  
								  rule.clickOnCheckNode1();
								  
								  clickOnAddButton_checkTab();
								  
								  clickOnAddColumnMenuOption();
								  
								  rule.clickOnColumnType("source");
								 
								 
								 
								checkSourcetTemplateTochoosefieldsAreDisplayedasEnabledinAddColumn("sex");


								
							} catch (Exception e) {

								e.getMessage();
							}
						}
						
						//story-DAT-776 --->NRR-9020,NRR-9021,NRR-9025,NRR-9026
						public void validatefromColumnpaneforcontributororOwnergrantusertochooseCalculatedtemplate(DataTestingParameters xparam,String workspaceID, String ruleName,
								String icedqRoleName, SoftAssert soft) {
							try {

								  DataTestingPage rule = new DataTestingPage(driver);
								  
								  TestDataThroughApi datathru = new TestDataThroughApi(driver);
								  
								  String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID,
								  icedqRoleName);
								  
								  String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,
								  icedqRoleName);
								  
								  String ruleType =TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson,"$.ruleType");
								  
								 // rule.clickOnNextGenMenuTab("Connections");
								  
								  // List<String> connectionList = datathru.createConnection(ruleType,ruleJson,workspaceID,"$.objects..connectionId", soft, icedqRoleName);
								  
								  DataTestingParameters param = setRuleParametersForApi(workspaceID, ruleJson,
								  icedqRoleName); rule.clickOnNextGenMenuTab("Data Testing");
								  
								  
								 rule.verifyDataTestingLandingPage();
								  
								  rule.clickOnAddNewFolderOrExistingOneAPI(param, workspaceID, ruleJson,"",  icedqRoleName);
								  
								  rule.enterDetailsInAddNewPaneAPI(param, workspaceID,ruleName, icedqRoleName);
								  
								  enterDetailsInOverviewSection(param);
								  
								  enterDetailsInAdvancedSettingOfOverviewSection(param);
								  
								  rule.enterDetailsInSourceSetting(ruleJson, param, soft);
								  
								  rule.clickOnCheckNode1();

								clickOnAddButton_checkTab();
								
								clickOnAddColumnMenuOption();

								clickOnCheckType("Calculated");
								
								calulatedColumnsearchtab(xparam);
								
								


							} catch (Exception e) {

							}
						}
						//story-776 ticket.NRR-9012,NRR-9013,NRR-9016,NRR-9017
						public void chooseSourcetemplatefromColumnpanethenrequiredfieldsorbuttonsaredisplayedasEnabledordisabledinAddColumnpane(String workspaceID, String ruleName,
								String icedqRoleName, SoftAssert soft)
						{
							try {
								DataTestingPage rule = new DataTestingPage(driver);

								TestDataThroughApi datathru = new TestDataThroughApi(driver);

								String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID, icedqRoleName);

								String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID, icedqRoleName);

								String ruleType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson, "$.ruleType");

								rule.clickOnNextGenMenuTab("Connections");

								List<String> connectionList = datathru.createConnection(ruleType, ruleJson, workspaceID,
										"$.objects..connectionId", soft, icedqRoleName);

								DataTestingParameters param = datathru.setRuleParametersForApi(workspaceID, ruleJson, icedqRoleName);

								rule.clickOnNextGenMenuTab("Data Testing");

							    rule.verifyDataTestingLandingPage();

								rule.clickOnAddNewFolderOrExistingOneAPI(param, workspaceID, ruleName, ruleJson, icedqRoleName);

								rule.enterDetailsInAddNewPaneAPI(param, workspaceID, ruleName, icedqRoleName);

								rule.enterDetailsInOverviewSection(param);

								rule.enterDetailsInAdvancedSettingOfOverviewSection(param);

								rule.enterDetailsInSourceSetting(ruleJson, param, soft);

								rule.clickOnCheckNode1();

								clickOnAddButton_checkTab();

								clickOnAddColumnMenuOption();
								
								rule.clickOnColumnType("source");
								
								checkSourceColumnPageAndValidateSame("colName1");

								
							} catch (Exception e) {

								e.getMessage();
							}
						}
			// Rahul's story end 
				*/
				// Rahul's story common method's for DAT-775 starts
				public void SourceConnectionEditBtn() throws Exception 
				{
					
					BaseSuite.reportLog("Clicking on Edit button");
					
					isDisplayedInLoop(driver, 10, srcConnEditBt);
					
					displayAndClick(driver, srcConnEditBt);

					BaseSuite.validationReportLog("Edit button clicked successfully");
					
					
				}
				public void sourceconnTestBtn() 
				{
					try {
						BaseSuite.validationReportLog("Clicking on Test button");

						displayAndClick(driver, sourceDatasetTestButton);

						BaseSuite.validationReportLog("Test button clicked successfully");

						inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
						
						captureToastMsg(driver, toastMsg, popUpClose, errorMessage, "Test Button Selecting grant wise  ");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				
				
				public void enterqueryboxValidation() 
				{
					try {
						inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
						
						if (isDisplayed(driver, sourceDatasetDataQueryBox)) 
						{
							BaseSuite.validationReportLog("Enter Query TextBox field visible successfully");
						} else {
                            BaseSuite.reportLog("Enter Query TextBox field failed to display");
						}
						
					} catch (Exception e) {
						e.getMessage();
					}
				}
		
				public void selectSourceConnectionAndValidate(String sourceConnection) {
					try {
						BaseSuite.reportLog("Selecting " + sourceConnection + " connection");
						Thread.sleep(500);
						javascript(driver, "arguments[0].scrollIntoView(true);", sourceDatasetConnectionClick);

						//isDisplayedInLoop(driver, 10, sourceDatasetConnectionClick);

						// Thread.sleep(3000);
						/*
						 * Actions actions = new Actions(driver);
						 * 
						 * wait = waitMethod(driver);
						 * 
						 * actions.moveToElement(driver.findElement(sourceDatasetConnectionClick)).
						 * perform();
						 * 
						 * wait.until(ExpectedConditions.visibilityOfElementLocated(
						 * sourceDatasetConnectionClick));
						 * 
						 * actions.click(driver.findElement(sourceDatasetConnectionClick)).build().
						 * perform();
						 */
						isDisplayedInLoop(driver, 10, sourceDatasetConnectionClick);

						displayAndClick(driver, sourceDatasetConnectionClick);
						
						inVisible(driver, spinner, Constant.ruleWait);
						
						List<WebElement> colNames = getElements(driver, sourceconncount);
						
						int colNameCount = colNames.size();
												
						if ((colNameCount > 0) ) {
							BaseSuite.validationReportLog( colNameCount   +  "  database connections displayed in Connection dropdown field.");

						} else {
							BaseSuite.reportFailLog("No database connections to displayed in Connection dropdown field", "");
						}

						inVisible(driver, spinner, Constant.ruleWait);

						Actions actions = new Actions(driver);

						wait = waitMethod(driver);

						actions.moveToElement(driver.findElement(dropDownBox)).clickAndHold().build().perform();

						isDisplayedInLoop(driver, 10, sourceDatasetConnectionSearch);
						
						Thread.sleep(1000);

						sendKeys(driver, sourceDatasetConnectionSearch, sourceConnection);

						isDisplayedInLoop(driver, 10, returnElement(sourceDatasetConnectionSelect, "$name", sourceConnection));

						displayAndClick(driver, returnElement(sourceDatasetConnectionSelect, "$name", sourceConnection));

						inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

						BaseSuite.validationReportLog(sourceConnection + " connection selected successfully");

						// captureToastMsg(driver, toastMsg, popUpClose, connectionMess, "Connection");
					} catch (Exception e) {

						e.getMessage();
					}

				}
				//Method is to check Source setting page source column and type count and validation
				public void sourcesettingSourceColumnandTypecount(String ruletype, SoftAssert soft) throws Exception
				{
					try {
						String colName = null;
						String   colDataType = null;
                if(!isDisplayed(driver, sourceSettingnorecords)) {
                	
                	
						if ((ruletype.equalsIgnoreCase("validation"))) {

							List<WebElement> colNames = getElements(driver, sourceSettingColumncount);
							List<WebElement> coldatatypes = getElements(driver, sourceSettingTypecount);

							int colNameCount = colNames.size();
							int colDataTypeCount = coldatatypes.size();

							if ((colNameCount > 0) && (colDataTypeCount > 0)) {
								BaseSuite.validationReportLog("Successfully matched source column name & type column name for  "
										+ colNameCount + " AND " + colDataTypeCount);

							} else {
								BaseSuite.validationReportLog(
										"Source column name & type column name are not matched with Expected Condition "
												+ colName + "->" + colDataType);
							}

						} else {
							BaseSuite.reportErrorLog(
									"Source column & type column name not retrived from source , kindly check.");
						}
                             }
                        else
						{
                        	BaseSuite.validationReportLog("Source Table Displayed with NO records to Display");
						}
					} catch (Exception e) {
						e.getMessage();
					}
				}
             //Method is to check source setting Data Tab source column and type count and validation
				public void sourcecolumnandtypecount(String ruletype, SoftAssert soft) throws Exception
				{
					try {
						String colName = null;
						String   colDataType = null;
                if(isDisplayed(driver, sourcedatatabnorecords)) {
                	
                	
						if ((ruletype.equalsIgnoreCase("validation"))) {

							List<WebElement> colNames = getElements(driver, sourceDatatabColumncount);
							List<WebElement> coldatatypes = getElements(driver, sourceDatatabDatatypecount);

							int colNameCount = colNames.size();
							int colDataTypeCount = coldatatypes.size();

							if ((colNameCount > 0) && (colDataTypeCount > 0)) {
								BaseSuite.validationReportLog("Successfully matched source column name & datatype for  "
										+ colNameCount + " AND " + colDataTypeCount);

							} else {
								BaseSuite.validationReportLog(
										"Source column name & datatype are not matched with Expected Condition "
												+ colName + "->" + colDataType);
							}

						} else {
							BaseSuite.reportErrorLog(
									"Source column & datatype not retrived from source , kindly check.");
						}
                             }
                        else
						{
                        	BaseSuite.validationReportLog("Source Table Displayed with NO records to Display");
						}
					} catch (Exception e) {
						e.getMessage();
					}
				}
				//Method is to validate connection Name and Type with feild's and Title
				public void sourcesettingconnectionvalidation(boolean testButtonFalse,boolean editButtonFalse)
				{
					try {
						if ((isDisplayed(driver, connectiontypetitle))&&(isDisplayed(driver, connectiontypefeild))) 
						{
							BaseSuite.validationReportLog("Connection Type Title and Connection Type Dropdown Feild is Visible and Displayed clearly");
						} else {
							BaseSuite.validationReportLog("Connection Type Title and Connection Type Dropdown Feild is Not Visible Neither Displayed, Need to check");
						}
						if ((isDisplayed(driver, connectionselectTitle ))&&(isDisplayed(driver, connectionselectfeild ))) 
						{
							BaseSuite.validationReportLog("Connection Select Title and Connection Select Dropdown Feild is Visible and Displayed clearly");
						} else {
							BaseSuite.validationReportLog("Connection Select Title and Connection Select Dropdown Feild is Not Visible Neither Displayed Need to check");
						}
						verifyVisibilityOfButtons(driver, sourceDatasetTestButton, "TestButton", testButtonFalse);
						verifyVisibilityOfButtons(driver, sourceDatasetEditButton, "EditButton", editButtonFalse);
					} catch (Exception e) {
						e.getMessage();
					}
				}
				//method to validate schema,Table and Next btn
				public void sourcesettingschemaandtablevalidation() 
				{
					try {
						if ((isDisplayed(driver, radiobtndirect)) && (isDisplayed(driver, radiobtncustom))) {
							BaseSuite.validationReportLog(
									"Direct Radion Button and Custom SQL Radio Button are Visible and Displayed clearly");
						} else {
							BaseSuite.validationReportLog(
									"Direct Radion Button and Custom SQL Radio Button are Not Visible Neither Displayed Need to check");
						}
						if (isDisplayed(driver, schemaTitleValidation)
								&& (isDisplayed(driver, selectschemavalidation))) {
							BaseSuite.validationReportLog(
									"Schema Title and Select schema field is visible successfully");
						} else {
							BaseSuite.reportLog("Schema Title and Select schema field failed to display");
						}
						if (isDisplayed(driver, tableviewTitleValidation)
								&& (isDisplayed(driver, selectTablevalidation))) {
							BaseSuite.validationReportLog(
									"Table/View Title and Table/View field is visible successfully");
						} else {
							BaseSuite.reportLog("Table/View Title and Table/View field failed to display");
						}
						if(isEnabled(driver, sourceDatasetNextButton))
						{
							verifyVisibilityOfButtons(driver, sourceDatasetNextButton, "NextButton", true);
						} else {

							verifyVisibilityOfButtons(driver, sourceDatasetNextButton, "NextButton", false);
						}

					} catch (Exception e) {
						e.getMessage();
					}
				}
				//Method is to only validate the source page 
               public void sourceSettingValidation() 
               {
            	   try {
					
            		   sourcesettingconnectionvalidation(true,true);
						inVisible(driver, spinner, Constant.ruleWait);
            		   sourcesettingschemaandtablevalidation();

				} catch (Exception e) {
					e.getMessage();
				}
               }
               
               //method to click on DataTab
               public void clickOnDataTab()
               {
            	   try {
            		   if (isDisplayed(driver,datatab ))
						{
            			   displayAndClick(driver, datatab);
							BaseSuite.validationReportLog("datatab visible and Displayed Clearly");
						} else {
                           BaseSuite.reportLog("Datatab is Not visible Neither Displayed ");
						}
				} catch (Exception e) {
					e.getMessage();
				}
               }
               
               //method to validate sourcedataset text box and edit icon
               public void textboxAndEditIcon()
               {
            	   try {
            		   if (isDisplayed(driver, sourcedatasettextbox)&&(isDisplayed(driver, sourcedatasettextboxediticon))) 
						{
							BaseSuite.validationReportLog("TextBox and Edit Icon are visible and Displayed successfully");
						} else {
                           BaseSuite.reportLog("TextBox and Edit Icon are Not visible Neither Displayed ");
						}
				} catch (Exception e) {
					e.getMessage();
				}
               }
               //method to validate blank Page
               public void BlankPageValidation()
               {
            	   try {
            		   if (isDisplayed(driver, sourcesettingblankpage)) 
						{
							BaseSuite.validationReportLog("Blank Page visible and Displayed Clearly");
						} else {
                           BaseSuite.reportLog("Blank Page Not visible Neither Displayed ");
						}
				} catch (Exception e) {
					e.getMessage();
				}
               }
             //method to validate Source column and Type Validation
				public void sourceColumnAndTypeValidation() 
				{
					try {
						if ((isDisplayed(driver, sourcesettingsourcetitle ))) 
						{
							BaseSuite.validationReportLog("sourceDataset source title Visible and Displayed clearly");
						} else {
							BaseSuite.validationReportLog("sourceDataset source title Not Visible Neither Displayed Need to check");
						}
						if (isDisplayed(driver,sourcetablecolumn )&&(isDisplayed(driver, sourcetabletype))) 
						{
							BaseSuite.validationReportLog("source table column and source table type Heading visible successfully");
						} else {
                           BaseSuite.reportLog("source table column and source table type Heading failed to display");
						}
						if (isDisplayed(driver, sourcedatatabnorecords)) 
						{
							BaseSuite.validationReportLog("Message Shows : NO Records to Display");
						} else {
                           BaseSuite.reportLog("Source Table Displayed Nothing it's failed to display");
						}
					
					} catch (Exception e) {
						e.getMessage();
					}
				}
				
				public void verifyVisibilityOfElementFromDropdwnSourceConnectionType(String connType) {
					try {
						BaseSuite.reportLog("Selecting connection type");

						isDisplayedInLoop(driver, 10, sourceDatasetConnectionType);

						// Thread.sleep(3000);

						isDisplayedInLoop(driver, 10, sourceDatasetConnectionType);

						displayAndClick(driver, sourceDatasetConnectionType);
						                        
                        List<WebElement> ele = driver.findElements(conntypedropdownvisibility);

            			int count = ele.size();
            			
            			for(int i=0;i<ele.size();i++)
            			{
            			 try{
            			    String connectiontypeName = ele.get(i).getText();
            			    String value = getAttribute(driver, returnElement(conntypedropdownvisibletext, "$name", connectiontypeName), "class");
            			    if (value.contains("hide")) {
      						  
      						  BaseSuite.validationReportLog(" Disabled Connection Type is " + connectiontypeName );
      						  } else {
      						  
      						  BaseSuite.validationReportLog("Enable Connection Type is " + connectiontypeName);
      						  }
      						  }            			    
            			 catch(Exception ex)
            			   {
            			    //Write required code if not disabled
            			   } 
            			 }

						Actions actions = new Actions(driver);

						wait = waitMethod(driver);

						actions.moveToElement(driver.findElement(dropDownBox)).clickAndHold().build().perform();

						isDisplayedInLoop(driver, 10,
								returnElement(sourceDatasetConnectionTypeSelect, "$name", capitalize(connType)));

						displayAndClick(driver, returnElement(sourceDatasetConnectionTypeSelect, "$name", capitalize(connType)));

						inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

						BaseSuite.validationReportLog(connType + " Connection type selected successfully");

						// captureToastMsg(driver, toastMsg, popUpClose, connectionTypeMess, "Connection
						// Type");

					} catch (Exception e) {

						e.getMessage();
					}

				}
				
				//story-775 methods starts, NRR-9428,NRR-9424,
				
				public void toVerifyReaderUserisAbletoUpdateFieldValuesinDataTabofSourceDataset(DataTestingParameters param, String ruleName,SoftAssert soft) throws InterruptedException
				{
					try {
						DataTestingPage dtp = new DataTestingPage(driver);
						
						//clickOnSearchedRuleNameOnDataTestingPage(ruleName,soft);
						
						XLUtils xlReader = new XLUtils();
						
						String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

						String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, BaseSuite.SourceConnection);

						String connName = loginDetails[0];

						String schema = loginDetails[1];
					
						String table = loginDetails[2];
						
						
						  clickOnSourceDataset();
						  
						  nextButton(sourceDatasetNextButton);
						  
						//  enterDBQuery(sourceDatasetDataQueryBox, param.getSourceQuery(),schema,table);
						  
						  previewData(sourcegetData);
						  
						 
						 						
						  captureToastMsg(driver, toastMsg, toastMsgClosedBtn, errorMessage, "Get Data Message");
						
						
					} catch (Exception e) {
						e.getMessage();

					}
				}
				
			//story-775 methods starts, NRR-9427,NRR-9423
	
				public void toVerifyExecutorUserisAbletoUpdateFieldValuesinDataTabofSourceDataset(DataTestingParameters param, String ruleName,SoftAssert soft) throws InterruptedException
				{
					try {
						DataTestingPage dtp = new DataTestingPage(driver);
						
						//clickOnSearchedRuleNameOnDataTestingPage(ruleName,soft);
						
						XLUtils xlReader = new XLUtils();
						
						String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

						String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, BaseSuite.SourceConnection);

						String connName = loginDetails[0];

						String schema = loginDetails[1];
					
						String table = loginDetails[2];
						
						
						  clickOnSourceDataset();
						  
						  nextButton(sourceDatasetNextButton);
						  
						  //enterDBQuery(sourceDatasetDataQueryBox, param.getSourceQuery(),schema,table);
						  
						  previewData(sourcegetData);
						 						
						dtp.clickOnRulePublishMenuListIconBtn();
							
						dtp.clickOnDraftMenuOptionBtn(dtp.errorMessage);

						
						
					} catch (Exception e) {
						e.getMessage();

					}
				}
				//story-775 methods starts,NRR-9422,NRR-9421NRR-9426,NRR-9425,
				
				public void toVerifyUserisAbletoUpdateFieldValuesinDataTabofSourceDataset(DataTestingParameters param, String ruleName,SoftAssert soft) throws InterruptedException
				{
					try {
						DataTestingPage dtp = new DataTestingPage(driver);
						
						//clickOnSearchedRuleNameOnDataTestingPage(ruleName,soft);
						
						XLUtils xlReader = new XLUtils();
						
						String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

						String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, BaseSuite.SourceConnection);

						String connName = loginDetails[0];

						String schema = loginDetails[1];
					
						String table = loginDetails[2];
						
						
						  clickOnSourceDataset();
						  
						  nextButton(sourceDatasetNextButton);
						  
						  //enterDBQuery(sourceDatasetDataQueryBox, param.getSourceQuery(),schema,table);
						  

						 // getData(sourcegetData);

						  previewData(sourcegetData);

						 						
						dtp.clickOnRulePublishMenuListIconBtn();
							
						dtp.clickOnDraftMenuOptionBtn();

						
						
					} catch (Exception e) {
						e.getMessage();

					}
				}
				//story DAT-775 Nrr-9416 and NRR-9420 
				public void toverifythatReaderuserisabletoupdatefieldvaluesinSourceSettingtabofSourceDataset(DataTestingParameters param, String ruleName,SoftAssert soft) throws Throwable
				{
					try {
                     	DataTestingPage dtp = new DataTestingPage(driver);
						
						///clickOnSearchedRuleNameOnDataTestingPage(ruleName,soft);
						
                        XLUtils xlReader = new XLUtils();
						
						String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

						String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, BaseSuite.SourceConnection);

						String connName = loginDetails[0];

						String schema = loginDetails[1];
					
						String table = loginDetails[2];
				
						clickOnSourceDataset();
						 
						 selectSourceConnectionType(param.getSourceConnType());
						 
						 Thread.sleep(2000);
						 
						 selectSourceConnection(connName);
						 
						 sourceconnTestBtn() ;
				 
					} catch (Exception e) {
						e.getMessage();
					}
					
				}
	//story-775 --->NRR-9419,NRR-9415
				
				
				public void toverifythatExecutoruserisabletoupdatefieldvaluesinSourceSettingtabofSourceDataset(DataTestingParameters param, String ruleName,SoftAssert soft) throws Throwable
				{
					try {
                     	DataTestingPage dtp = new DataTestingPage(driver);
						
						//clickOnSearchedRuleNameOnDataTestingPage(ruleName,soft);
						
                        XLUtils xlReader = new XLUtils();
						
						String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

						String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, BaseSuite.SourceConnection);

						String connName = loginDetails[0];

						String schema = loginDetails[1];
					
						String table = loginDetails[2];
				
						clickOnSourceDataset();
						 
						 selectSourceConnectionType(param.getSourceConnType());
						 
						 Thread.sleep(2000);
						 
						 selectSourceConnection(connName);
						 					
						//selectInput(sourceDatasetInput, "Table");
						
						Thread.sleep(1000);
						
						sourceSettingValidation();
						
						selectSchema(sourceDatasetSchemaClick, schema);

						selectTable(sourceDatasetTableClick, table);
						 
						dtp.clickOnRulePublishMenuListIconBtn();
						
						dtp.clickOnDraftMenuOptionBtn(dtp.errorMessage);

						 
						 
					} catch (Exception e) {
						e.getMessage();
					}
					
				}
				
				//story-775 --->NRR-9418,NRR-9417,NRR-9414,NRR-9413
				
				
				public void toverifythatuserisabletoupdatefieldvaluesinSourceSettingtabofSourceDataset(DataTestingParameters param, String ruleName,SoftAssert soft) throws Throwable
				{
					try {
                     	DataTestingPage dtp = new DataTestingPage(driver);
						
						//clickOnSearchedRuleNameOnDataTestingPage(ruleName,soft);
						
                        XLUtils xlReader = new XLUtils();
						
						String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

						String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, BaseSuite.SourceConnection);

						String connName = loginDetails[0];

						String schema = loginDetails[1];
					
						String table = loginDetails[2];
				
						clickOnSourceDataset();
						 
						 selectSourceConnectionType(param.getSourceConnType());
						 
						 Thread.sleep(2000);
						 
						 selectSourceConnection(connName);
						 					
					//	selectInput(sourceDatasetInput, "Table");
						
						Thread.sleep(1000);
						
						sourceSettingValidation();
						
						selectSchema(sourceDatasetSchemaClick, schema);

						selectTable(sourceDatasetTableClick, table);
						 
						dtp.clickOnRulePublishMenuListIconBtn();
						
						dtp.clickOnDraftMenuOptionBtn();

						 
						 
					} catch (Exception e) {
						e.getMessage();
					}
					
				}
				
				//story-775 ticket.NRR-9394,NRR-9393,NRR-9389,NRR-9390
				public void verifyuserisabletoclickonDatatabofSourceDatasetwhenDirectoptionisselected(String workspaceID, String ruleName,
						String icedqRoleName,String settingType, SoftAssert soft)throws Throwable 
				{
					try {
						DataTestingPage rule = new DataTestingPage(driver);

						TestDataThroughApi datathru = new TestDataThroughApi(driver);

						String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID, icedqRoleName);

						String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID, icedqRoleName);

						String ruleType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson,
								"$.ruleType");

					//List<String> connectionList = datathru.createConnection(ruleType, ruleJson, workspaceID,"$.objects..connectionId", soft, icedqRoleName);

						DataTestingParameters param = datathru.setRuleParametersForApi(workspaceID, ruleJson,icedqRoleName);

						rule.verifyDataTestingLandingPage();

						//rule.enterDetailsInAddNewPaneAPI(param, workspaceID, ruleName, icedqRoleName);

						//rule.enterDetailsInOverviewSection(param);

						rule.enterDetailsInAdvancedSettingOfOverviewSection(param);

						//rule.enterDetailsInSourceSetting(ruleJson, param, soft);
						
						sourcecolumnandtypecount(param.getRuleType(),soft);

					} catch (Exception e) {
						e.getMessage();
					}
				}
				//story-775 ticket NRR-9396,NRR9395,NRR-9391,NRR-9392

				public void verifythaExecutorAndReaderuserisabletoclickonDatatabofSourceDatasetwhenDirectoptionisselected(DataTestingParameters param, String ruleName,SoftAssert soft) throws InterruptedException
				{
					try {
						DataTestingPage dtp = new DataTestingPage(driver);

						//clickOnSearchedRuleNameOnDataTestingPage(ruleName, soft);

						XLUtils xlReader = new XLUtils();

						String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

						String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet,
								BaseSuite.SourceConnection);

						String connName = loginDetails[0];

						String schema = loginDetails[1];

						String table = loginDetails[2];

						clickOnSourceDataset();

						sourceSettingValidation();

						nextButton(sourceDatasetNextButton);

						enterqueryboxValidation();

						verifyVisibilityOfButtons(driver, sourcegetData, "PreviewData", true);

						verifyVisibilityOfButtons(driver, sourceDataCancelBtn, "Cancel Button", true);

						sourcecolumnandtypecount(param.getRuleType(), soft);

					} catch (Exception e) {
						e.getMessage();

					}
				}
				//story-775 ticket NRR-9383,NRR9384,NRR-9387,NRR-9388

				public void verifyReaderAndExecutorUserIsAbleToClickOnDatatabOfSourceDatasetWhenCustomSQLoptionIsselected(DataTestingParameters param, String ruleName,SoftAssert soft) throws InterruptedException
				{
					try {
						DataTestingPage dtp = new DataTestingPage(driver);

						//clickOnSearchedRuleNameOnDataTestingPage(ruleName, soft);

						XLUtils xlReader = new XLUtils();

						String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

						String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet,
								BaseSuite.SourceConnection);

						String connName = loginDetails[0];

						String schema = loginDetails[1];

						String table = loginDetails[2];

						clickOnSourceDataset();

						sourceSettingValidation();

						nextButton(sourceDatasetNextButton);

						enterqueryboxValidation();

						verifyVisibilityOfButtons(driver, sourcegetData, "PreviewData", true);

						verifyVisibilityOfButtons(driver, sourceDataCancelBtn, "Cancel Button", true);

						sourcecolumnandtypecount(param.getRuleType(), soft);

					} catch (Exception e) {
						e.getMessage();

					}
				}

				//story-DAT-775 --->NRR-9385,NRR-9386,NRR-9381,NRR-9382
				public void verifyownerAndContributorUserIsAbleToClickOnDatatabOfSourceDatasetWhenCustomSQLoptionIsselected(String workspaceID, String ruleName,
						String icedqRoleName, SoftAssert soft) {
					try {

						  DataTestingPage rule = new DataTestingPage(driver);
						  
						  TestDataThroughApi datathru = new TestDataThroughApi(driver);
						  
						  String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID,icedqRoleName);
						  
						  String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,
						  icedqRoleName);
						  
						  String ruleType =TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson,"$.ruleType");
						  
						
						  DataTestingParameters param = setRuleParametersForApi(workspaceID, ruleJson,icedqRoleName); 
						  
					//	  rule.verifyDataTestingLandingPage();
						  						  
						 // rule.enterDetailsInAddNewPaneAPI(param, workspaceID,ruleName, icedqRoleName);
						  
						  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					
						  clickOnSourceDataset();
						  
						//  sourceSettingValidation();

						  selectSourceConnectionType(param.getSourceConnType());
						  
					//	  selectInput(sourceDatasetInput, "Table");
						  
						//  selectInput(sourceDatasetInput, "SQL");

						  textboxAndEditIcon();
						  
						  clickOnDataTab();
						  
						  BlankPageValidation();
						  
						  sourceColumnAndTypeValidation();
						  
					} catch (Exception e) {

					}
				}
				//story-775 ticket NRR-9364,NRR9363,NRR-9358,NRR-9359

				public void verifyThatSchemaAndTableDropdownFieldsAreDisplayedAfterSelectingDirectOptionForReaderAndExecutoruser(DataTestingParameters param, String ruleName,SoftAssert soft) throws InterruptedException
				{
					try {
						DataTestingPage dtp = new DataTestingPage(driver);

						//clickOnSearchedRuleNameOnDataTestingPage(ruleName, soft);

						XLUtils xlReader = new XLUtils();

						String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

						String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet,
								BaseSuite.SourceConnection);

						String connName = loginDetails[0];

						String schema = loginDetails[1];

						String table = loginDetails[2];

						clickOnSourceDataset();

						sourceSettingValidation();

					} catch (Exception e) {
						e.getMessage();

					}
				}
				//story-DAT-775 --->NRR-9361,NRR-9362,NRR-9356,NRR-9357
				public void verifyThatSchemaandTableDropdownFieldsAreDisplayedAfterSelectingDirectOptionForContributorAndOwneruser(String workspaceID, String ruleName,
						String icedqRoleName, SoftAssert soft) {
					try {

						  DataTestingPage rule = new DataTestingPage(driver);
						  
						  TestDataThroughApi datathru = new TestDataThroughApi(driver);
						  
						  String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID,icedqRoleName);
						  
						  String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,
						  icedqRoleName);
						  
						  String ruleType =TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson,"$.ruleType");
						  						
						  DataTestingParameters param = setRuleParametersForApi(workspaceID, ruleJson,icedqRoleName); 
						  
					//	  rule.verifyDataTestingLandingPage();
						  						  
						  //rule.enterDetailsInAddNewPaneAPI(param, workspaceID,ruleName, icedqRoleName);
						  
						  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					
						  clickOnSourceDataset();

						  selectSourceConnectionType(param.getSourceConnType());
			
						  textboxAndEditIcon();
			
						  ///(sourceDatasetInput, "Table");
						  sourcesettingschemaandtablevalidation();
						  
					} catch (Exception e) {

					}
				}
				//story-DAT-775 --->NRR-9072,NRR-9071,NRR-9068,NRR-9067
				public void verifyThatAfterSelectingConnectionTypeAndConnectionTestAndEditButtonsGetsEnableForOwnerAndContributorusers(String workspaceID, String ruleName,
						String icedqRoleName, SoftAssert soft) {
					try {
						String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;
						
						 XLUtils xlReader = new XLUtils();
							
							String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, BaseSuite.SourceConnection);

							String connName = loginDetails[0];


						  DataTestingPage rule = new DataTestingPage(driver);
						  
						  TestDataThroughApi datathru = new TestDataThroughApi(driver);
						  
						  String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID,icedqRoleName);
						  
						  String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,
						  icedqRoleName);
						  
						  String ruleType =TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson,"$.ruleType");
						  						
						  DataTestingParameters param = setRuleParametersForApi(workspaceID, ruleJson,icedqRoleName); 
						  
						 // rule.verifyDataTestingLandingPage();
						  						  
						  //rule.enterDetailsInAddNewPaneAPI(param, workspaceID,ruleName, icedqRoleName);
						  
						  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					
						  clickOnSourceDataset();
						  selectSourceConnectionType(param.getSourceConnType());
						  
						  if ((isDisplayed(driver, radiobtndirect)) && (isDisplayed(driver, radiobtncustom))) {
								BaseSuite.validationReportLog(
										"Direct Radion Button and Custom SQL Radio Button are Visible and Displayed clearly");
							} else {
								BaseSuite.validationReportLog(
										"Direct Radion Button and Custom SQL Radio Button are Not Visible Neither Displayed Need to check");
							}
			
						  
						  textboxAndEditIcon();
						  
						  //selectSourceConnection(connName);
						  
						  selectSourceConnectionAndValidate(connName) ;

						  verifyVisibilityOfButtons(driver, sourceDatasetTestButton, "TestButton", true);
							verifyVisibilityOfButtons(driver, sourceDatasetEditButton, "EditButton", true);
			
						  
						  
					} catch (Exception e) {

					}
				}
				//story-775 ticket NRR-9074,NRR-9073,NRR-9070,NRR-9069

				public void verifyThatForReaderAndExecutoruserTestAndEditButtonsAreDisplayedAsEnabledForExistingRuleIfConnectionTypeandConnectionIsSelected(DataTestingParameters param, String ruleName,SoftAssert soft) throws InterruptedException
				{
					try {
						DataTestingPage dtp = new DataTestingPage(driver);

						//clickOnSearchedRuleNameOnDataTestingPage(ruleName, soft);

						clickOnSourceDataset();

						sourceSettingValidation();
						
						verifyVisibilityOfButtons(driver, sourceDatasetTestButton, "TestButton", true);
						 
						verifyVisibilityOfButtons(driver, sourceDatasetEditButton, "EditButton", true);

					} catch (Exception e) {
						e.getMessage();

					}
				}
				
				//story-DAT-775 --->NRR-9061,NRR-9060,NRR-9056,NRR-9055
				public void verifyThatAllDatabaseConnectionsAreDisplayedInConnectionDropdownFieldForOwnerAndContributorUserAndIsAbleToSelectConnection(String workspaceID, String ruleName,
						String icedqRoleName, SoftAssert soft) {
					try {
						String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;
						
						 XLUtils xlReader = new XLUtils();
							
							String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, BaseSuite.SourceConnection);

							String connName = loginDetails[0];


						  DataTestingPage rule = new DataTestingPage(driver);
						  
						  TestDataThroughApi datathru = new TestDataThroughApi(driver);
						  
						  String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID,icedqRoleName);
						  
						  String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,
						  icedqRoleName);
						  
						  String ruleType =TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson,"$.ruleType");
						  						
						  DataTestingParameters param = setRuleParametersForApi(workspaceID, ruleJson,icedqRoleName); 
						  
						 // rule.verifyDataTestingLandingPage();
						  						  
						 // rule.enterDetailsInAddNewPaneAPI(param, workspaceID,ruleName, icedqRoleName);
						  
						  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					
						  clickOnSourceDataset();
						  selectSourceConnectionType(param.getSourceConnType());
						  
						  if ((isDisplayed(driver, radiobtndirect)) && (isDisplayed(driver, radiobtncustom))) {
								BaseSuite.validationReportLog(
										"Direct Radion Button and Custom SQL Radio Button are Visible and Displayed clearly");
							} else {
								BaseSuite.validationReportLog(
										"Direct Radion Button and Custom SQL Radio Button are Not Visible Neither Displayed Need to check");
							}
			
						  
						  textboxAndEditIcon();
						  
						  //selectSourceConnection(connName);
						  
						  selectSourceConnectionAndValidate(connName) ;
 
					} catch (Exception e) {

					}
				}
				
				//story-775 ticket NRR-9063,NRR9062,NRR-9058,NRR-9057

				public void verifyThatAllDatabaseConnectionsAreDisplayedInConnectionDropdownFieldForExecutorAndReaderUserAndIsAbleToSelectConnection(DataTestingParameters param, String ruleName,SoftAssert soft) throws InterruptedException
				{
					try {
						DataTestingPage dtp = new DataTestingPage(driver);

						//clickOnSearchedRuleNameOnDataTestingPage(ruleName, soft);

						XLUtils xlReader = new XLUtils();

						String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

						String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet,
								BaseSuite.SourceConnection);

						String connName = loginDetails[0];

						String schema = loginDetails[1];

						String table = loginDetails[2];

						clickOnSourceDataset();
						
						selectSourceConnectionType(param.getSourceConnType());

						sourceSettingValidation();
						
						selectSourceConnectionAndValidate(connName) ;


					} catch (Exception e) {
						e.getMessage();

					}
				}
				//story-775 ticket NRR-9050,NRR9049,NRR-9044,NRR-9043

				public void verifyThatReaderAndExecutorIsAbleToSelectDatabaseOptionFromConnectionTypeListForExistingRules(String workspaceID,String icedqRoleName,String ruleName,SoftAssert soft) throws InterruptedException
				{
					try {
						
						TestDataThroughApi datathru = new TestDataThroughApi(driver);

						String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID, icedqRoleName);

						String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID, icedqRoleName);

						String ruleType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson,"$.ruleType");
						
						DataTestingParameters param = setRuleParametersForApi(workspaceID, ruleJson, icedqRoleName);
					
						//clickOnSearchedRuleNameOnDataTestingPage(ruleName, soft);
						
						clickOnSourceDataset();

						selectSourceConnectionType(param.getSourceConnType());

						if ((isDisplayed(driver, radiobtndirect)) && (isDisplayed(driver, radiobtncustom))) {
							BaseSuite.validationReportLog(
									"Direct Radion Button and Default Selected Custom SQL Radio Button are Visible and Displayed clearly ");
						} else {
							BaseSuite.validationReportLog(
									"Direct Radion Button and Custom SQL Radio Button are Not Visible Neither Displayed Need to check");
						}

						textboxAndEditIcon();

					} catch (Exception e) {
						e.getMessage();

					}
				}
				//story-DAT-775 --->NRR-9048,NRR-9046,NRR-9039,NRR-9042
				public void verifyThatOwnerAndContributorIsAbleToSelectDatabaseOptionFromConnectionTypelist(String workspaceID, String ruleName,
						String icedqRoleName, SoftAssert soft) {
					try {
						String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;
						
						 XLUtils xlReader = new XLUtils();
							
							String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, BaseSuite.SourceConnection);

							String connName = loginDetails[0];


						  DataTestingPage rule = new DataTestingPage(driver);
						  
						  TestDataThroughApi datathru = new TestDataThroughApi(driver);
						  
						  String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID,icedqRoleName);
						  
						  String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,
						  icedqRoleName);
						  
						  String ruleType =TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson,"$.ruleType");
						  						
						  DataTestingParameters param = setRuleParametersForApi(workspaceID, ruleJson,icedqRoleName); 
						  
						  rule.verifyDataTestingLandingPage();
						  						  
						  //rule.enterDetailsInAddNewPaneAPI(param, workspaceID,ruleName, icedqRoleName);
						  
						  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					
						  clickOnSourceDataset();
						  
						  selectSourceConnectionType(param.getSourceConnType());

							if ((isDisplayed(driver, radiobtndirect)) && (isDisplayed(driver, radiobtncustom))) {
								BaseSuite.validationReportLog(
										"Direct Radion Button and Default Selected Custom SQL Radio Button are Visible and Displayed clearly ");
							} else {
								BaseSuite.validationReportLog(
										"Direct Radion Button and Custom SQL Radio Button are Not Visible Neither Displayed Need to check");
							}

							textboxAndEditIcon();

					} catch (Exception e) {

					}
				}
				//story-775 ticket NRR-9011,NRR9010,NRR-9007,NRR-9006
				
				public void userIsAbleToViewRequiredOptionsInConnectionTypeDropdownFieldForExistingRules(String workspaceID,String icedqRoleName,String ruleName,SoftAssert soft) throws InterruptedException
				{
					try {
						
						TestDataThroughApi datathru = new TestDataThroughApi(driver);

						String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID, icedqRoleName);

						String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID, icedqRoleName);

						String ruleType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson,"$.ruleType");
						
						DataTestingParameters param = setRuleParametersForApi(workspaceID, ruleJson, icedqRoleName);
					
						//clickOnSearchedRuleNameOnDataTestingPage(ruleName, soft);
						
						clickOnSourceDataset();

						verifyVisibilityOfElementFromDropdwnSourceConnectionType(param.getSourceConnType());

						
					} catch (Exception e) {
						e.getMessage();

					}
				}
				//story-DAT-775 --->NRR-8998,NRR-8997,NRR-8993,NRR-8994
				public void connectionTypeDropdownFieldIsDisplayedInSourceSettingPage(String workspaceID, String ruleName,
						String icedqRoleName, SoftAssert soft) {
					try {
						String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;
						
						 XLUtils xlReader = new XLUtils();
							
							String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, BaseSuite.SourceConnection);

							String connName = loginDetails[0];


						  DataTestingPage rule = new DataTestingPage(driver);
						  
						  TestDataThroughApi datathru = new TestDataThroughApi(driver);
						  
						  String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID,icedqRoleName);
						  
						  String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,
						  icedqRoleName);
						  
						  String ruleType =TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson,"$.ruleType");
						  						
						  DataTestingParameters param = setRuleParametersForApi(workspaceID, ruleJson,icedqRoleName); 
						  
					//	  rule.verifyDataTestingLandingPage();
						  						  
						  //rule.enterDetailsInAddNewPaneAPI(param, workspaceID,ruleName, icedqRoleName);
						  
						  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					
						  clickOnSourceDataset();
						  
						  if ((isDisplayed(driver, connectiontypetitle))&&(isDisplayed(driver, connectiontypefeild))) 
							{
								BaseSuite.validationReportLog("Connection Type Title and Connection Type DropDown Feild is Visible and Displayed clearly");
							} else {
								BaseSuite.validationReportLog("Connection Type Title and Connection Type DropDown Feild is Not Visible Neither Displayed Need to check");
							}

					} catch (Exception e) {

					}
				}
				//story-DAT-775 --->NRR-9009,NRR-9008,NRR-9005,NRR-9004
				public void requiredOptionsareDisplayedInConnectionTypeDropdownField(String workspaceID, String ruleName,
						String icedqRoleName, SoftAssert soft) {
					try {
						String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;
						
						 XLUtils xlReader = new XLUtils();
							
							String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, BaseSuite.SourceConnection);

							String connName = loginDetails[0];


						  DataTestingPage rule = new DataTestingPage(driver);
						  
						  TestDataThroughApi datathru = new TestDataThroughApi(driver);
						  
						  String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID,icedqRoleName);
						  
						  String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,
						  icedqRoleName);
						  
						  String ruleType =TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson,"$.ruleType");
						  						
						  DataTestingParameters param = setRuleParametersForApi(workspaceID, ruleJson,icedqRoleName); 
						  
						  rule.verifyDataTestingLandingPage();
						  						  
						 // rule.enterDetailsInAddNewPaneAPI(param, workspaceID,ruleName, icedqRoleName);
						  
						  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					
						  clickOnSourceDataset();
						  
						verifyVisibilityOfElementFromDropdwnSourceConnectionType(param.getSourceConnType());

					} catch (Exception e) {

					}
				}
				
	//story-775 ticket NRR-9000,NRR-8999,NRR-8996,NRR-8995
				
				public void  userAbleToViewConnectionTypeDropdownFieldInSourceSettingPage(String ruleName,SoftAssert soft) throws InterruptedException
				{
					try {
						
						//clickOnSearchedRuleNameOnDataTestingPage(ruleName, soft);
						
						clickOnSourceDataset();

						if ((isDisplayed(driver, connectiontypetitle))&&(isDisplayed(driver, connectiontypefeild))) 
						{
							BaseSuite.validationReportLog("Connection Title and Connection DropDown Feild is Visible and Displayed clearly");
						} else {
							BaseSuite.validationReportLog("Connection Title and Connection DropDown Feild is Not Visible Neither Displayed Need to check");
						}
						
					} catch (Exception e) {
						e.getMessage();

					}
				}
				
//story-775 ticket NRR-8992,NRR-899,NRR-8988,NRR-8987
				
				public void  userAbleToViewSourceSettingTabInFlowDiagramForExistingRules(DataTestingParameters param,String ruleName,SoftAssert soft) throws InterruptedException
				{
					try {
						
						//clickOnSearchedRuleNameOnDataTestingPage(ruleName, soft);
						
						clickOnSourceDataset();

						sourcesettingconnectionvalidation(true,true);
					
						sourcesettingSourceColumnandTypecount(param.getRuleType(),soft);
						
					} catch (Exception e) {
						e.getMessage();

					}
				}
				//story-DAT-775 --->NRR-8990,NRR-8989,NRR-8986,NRR-8985
				public void sourceSettingTabIsDisplayedInSourceDatasetPageForUser(String workspaceID, String ruleName,
						String icedqRoleName, SoftAssert soft) {
					try {
						String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;
						
						 XLUtils xlReader = new XLUtils();
							
							String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, BaseSuite.SourceConnection);

							String connName = loginDetails[0];


						  DataTestingPage rule = new DataTestingPage(driver);
						  
						  TestDataThroughApi datathru = new TestDataThroughApi(driver);
						  
						  String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID,icedqRoleName);
						  
						  String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,
						  icedqRoleName);
						  
						  String ruleType =TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson,"$.ruleType");
						  						
						  DataTestingParameters param = setRuleParametersForApi(workspaceID, ruleJson,icedqRoleName); 
						  
						  rule.verifyDataTestingLandingPage();
						  						  
						 // rule.enterDetailsInAddNewPaneAPI(param, workspaceID,ruleName, icedqRoleName);
						  
						  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					
						  clickOnSourceDataset();
						  
						  sourcesettingconnectionvalidation(false,false);
						  
						  sourcesettingSourceColumnandTypecount(param.getRuleType(),soft);


					} catch (Exception e) {

					}
				}
                //story-775 ticket NRR-8984,NRR-8983,NRR-8980,NRR-8979
				
				public void  userAbleToViewSourceDatasetBlockInFlowDiagramForExistingRules(String ruleName,SoftAssert soft) throws InterruptedException
				{
					try {
						
					//	clickOnSearchedRuleNameOnDataTestingPage(ruleName, soft);
						
						if ((isDisplayed(driver, sourceDatasetButton))) 
						{
							BaseSuite.validationReportLog("sourceDataset Block is Visible and Displayed clearly in Flow Daigram");
						} else {
							BaseSuite.validationReportLog("sourceDataset Block is Not Visible Neither Displayed in Flow Daigram, Need to check");
						}

						
						
					} catch (Exception e) {
						e.getMessage();

					}
				}
				//story-DAT-775 --->NRR-8982,NRR-8981,NRR-8978,NRR-8977
				public void SourceDatasetBlockIsDisplayedInFlowDiagram(String workspaceID, String ruleName,
						String icedqRoleName, SoftAssert soft) {
					try {
						String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;
						
						 XLUtils xlReader = new XLUtils();
							
							String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, BaseSuite.SourceConnection);

							String connName = loginDetails[0];


						  DataTestingPage rule = new DataTestingPage(driver);
						  
						  TestDataThroughApi datathru = new TestDataThroughApi(driver);
						  
						  String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID,icedqRoleName);
						  
						  String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,
						  icedqRoleName);
						  
						  String ruleType =TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson,"$.ruleType");
						  						
						  DataTestingParameters param = setRuleParametersForApi(workspaceID, ruleJson,icedqRoleName); 
						  
						  rule.verifyDataTestingLandingPage();
						  						  
						//  rule.enterDetailsInAddNewPaneAPI(param, workspaceID,ruleName, icedqRoleName);
						  
						  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					
						  if ((isDisplayed(driver, sourceDatasetButton))) 
							{
								BaseSuite.validationReportLog("sourceDataset Block is Visible and Displayed clearly in Flow Daigram");
							} else {
								BaseSuite.validationReportLog("sourceDataset Block is Not Visible Neither Displayed in Flow Daigram, Need to check");
							}
						 

					} catch (Exception e) {

					}
				}
                //story-775 ticket NRR-8984,NRR-8983,NRR-8980,NRR-8979
				
				public void  userIsAbleToconfigureSourceDatasetWithConnectionTypeAsDatabase(String workspaceID, String ruleName,
						String icedqRoleName, SoftAssert soft) throws InterruptedException
				{
					try {
						String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;
						
						 XLUtils xlReader = new XLUtils();
							
							String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, BaseSuite.SourceConnection);

							String connName = loginDetails[0];


						  DataTestingPage rule = new DataTestingPage(driver);
						  
						  TestDataThroughApi datathru = new TestDataThroughApi(driver);
						  
						  String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID,icedqRoleName);
						  
						  String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID,
						  icedqRoleName);
						  
						  String ruleType =TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson,"$.ruleType");
						  						
						  DataTestingParameters param = setRuleParametersForApi(workspaceID, ruleJson,icedqRoleName); 
						  
						  rule.verifyDataTestingLandingPage();
						  						  

					   	clickOnNewRule();
						
					   	captureToastMsg(driver, toastMsg, toastMsgClosedBtn, errorMessage, "New Rule");
						
						
					} catch (Exception e) {
						e.getMessage();

					}
				}
}


























