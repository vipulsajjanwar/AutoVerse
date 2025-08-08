package nextgen.automation.RuleRepo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.asserts.SoftAssert;


import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.pageclasses.otherpages.HomePage;
import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;

public class RuleRepoHomePage extends PageUtil {

	WebDriver driver;
	
	public RuleRepoHomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By rulesTab = getElementLocator(prop.getProperty("rulesTab"));
	By ruleTabSpinner = getElementLocator(prop.getProperty("ruleTabSpinner"));
	By popUpClose=getElementLocator( prop.getProperty("PopUpClose"));
	By toastMsg=getElementLocator(prop.getProperty("Commontoastmsg"));
	By sourceDefinationTab=getElementLocator(prop.getProperty("sourceDefinationTab"));
	By parameterTab=getElementLocator(prop.getProperty("parameterTab"));
	By ruleRepoClick = getElementLocator(prop.getProperty("LandingPage.RuleConfigurationLabel"));
	By userDefinedFunTab=getElementLocator(prop.getProperty("userDefinedFunTab"));
	By personalRuleSpaceTab=getElementLocator(prop.getProperty("personalRuleSpaceTab"));
	By ruleMonitorTab=getElementLocator(prop.getProperty("ruleMonitorTab"));
	By exportTab=getElementLocator(prop.getProperty("exportTab"));
	By importTab=getElementLocator(prop.getProperty("importTab"));
	By welcomeTxt1=getElementLocator(prop.getProperty("Rule.WelcomeText1"));
	By welcomeTxt2=getElementLocator(prop.getProperty("Rule.WelcomeText2"));
	By RuleRepoImg=getElementLocator(prop.getProperty("RuleRepoImg"));
	By RuleRepoUserWelcomeMess=getElementLocator(prop.getProperty("RuleRepoUserWelcomeMess"));
	By RuleUserProfileImg=getElementLocator(prop.getProperty("RuleUserProfileImg"));
	By expandIcon=getElementLocator(prop.getProperty("expandIcon"));
	By ruleImg = getElementLocator(prop.getProperty("ruleImg"));
	By sourceDefImg=getElementLocator(prop.getProperty("sourceDefImg"));
	By parameterImg=getElementLocator(prop.getProperty("parameterImg"));
	By userDefinedFunImg=getElementLocator(prop.getProperty("userDefinedFunImg"));
	By ruleSpaceImg=getElementLocator(prop.getProperty("ruleSpaceImg"));
	By ruleMonitorImg=getElementLocator(prop.getProperty("ruleMonitorImg"));
	By exportImg=getElementLocator(prop.getProperty("exportImg"));
	By importImg=getElementLocator(prop.getProperty("importImg"));
	By rulerepoimgButton=getElementLocator(prop.getProperty("rulerepoimgButton"));
	By dataTesting = getElementLocator(prop.getProperty("DataTestingTab"));
	By workspaceList =getElementLocator(prop.getProperty("DataTesting.WorkspaceWindow"));
	By workspaceSearch=getElementLocator(prop.getProperty("DataTesting.WorkspaceSearch"));
	
	String RuleWelcomeMess1 = prop.getProperty("RuleWelcomeMess1");
	String RuleWelcomeMess2 = prop.getProperty("RuleWelcomeMess2");
	String ruleLandingPageMsg = prop.getProperty("ruleLandingPageMsg");
	String parameterLandingPageMsg = prop.getProperty("parameterLandingPageMsg");
	
	public void verifyHomeLandingPage() throws Exception
	{
		SoftAssert soft = new SoftAssert();
		
		BaseSuite.reportLog("Verifying Landing Page");
			
		visible(driver, welcomeTxt1, Constant.ruleWait);
		
		String validMess1 = getText(driver, welcomeTxt1).trim();
		String validMess2 = getText(driver, welcomeTxt2).trim();
		
		BaseSuite.validationReportLog("Retrived Message is :" + validMess1);
		BaseSuite.validationReportLog("Expected Message is :" + RuleWelcomeMess1.trim());
		
		BaseSuite.validationReportLog("Retrived Message is :" + validMess2);
		BaseSuite.validationReportLog("Expected Message is :" + RuleWelcomeMess2.trim());
		
		if (!(validMess1.isEmpty() && validMess2.isEmpty())) {

			soft.assertEquals(validMess1, RuleWelcomeMess1.trim());
			soft.assertEquals(validMess2, RuleWelcomeMess2.trim());

			BaseSuite.validationReportLog("Welcome Message Successfully Matched");
		}
		else {
			BaseSuite.reportFailLog("Welcome Messages didn't match", "captureLoginMsg");
		}
		verifyIndividualLabel(driver, RuleRepoImg, "Rule Repository Logo");
		verifyIndividualLabel(driver, RuleUserProfileImg, "User Logo");
		verifyIndividualLabel(driver, RuleRepoUserWelcomeMess, "User Welcome Message");
		Thread.sleep(1000);
		/*
		 * verifyIndividualLabel(driver, ruleImg, "Rule Tab Img");
		 * verifyIndividualLabel(driver, sourceDefImg, "Source Defination Tab Img");
		 * verifyIndividualLabel(driver, parameterImg, "Parameter Tab Img");
		 * verifyIndividualLabel(driver, userDefinedFunImg,
		 * "User Defined Function Tab Img"); verifyIndividualLabel(driver, ruleSpaceImg,
		 * "Personal Rule Space Tab Img"); verifyIndividualLabel(driver, ruleMonitorImg,
		 * "Rule Monitor Tab Img"); verifyIndividualLabel(driver, exportImg,
		 * "Export Tab Img"); verifyIndividualLabel(driver, importImg,
		 * "Import Tab Img");
		 */	
		BaseSuite.reportLog("Verifying the count of Button on rule repo home page");
		
		validateButtons(driver, rulerepoimgButton, 8);
		
		verifyVisibilityOfButtons(driver, ruleImg, "Rule Tab", true);
		
		isClickable(driver, ruleImg, "Rule Tab",true);
		
		verifyVisibilityOfButtons(driver, sourceDefImg, "Source Defination", true);
		
		isClickable(driver, sourceDefImg, "Source Defination", false);
		
		verifyVisibilityOfButtons(driver, parameterImg, "Parameter", true);
		
		isClickable(driver, parameterImg, "Parameter", true);
		
		verifyVisibilityOfButtons(driver, userDefinedFunImg, "User Defined Function", true);
		
		isClickable(driver, userDefinedFunImg, "User Defined Function", false);
		
		verifyVisibilityOfButtons(driver, ruleSpaceImg, "Personal Rule Space", true);
		
		isClickable(driver, ruleSpaceImg, "Personal Rule Space", false);
		
		verifyVisibilityOfButtons(driver, ruleMonitorImg, "Rule Monitor", true);
		
		isClickable(driver, ruleMonitorImg, "Rule Monitor", false);
		
		verifyVisibilityOfButtons(driver, exportImg, "Export", true);
		
		isClickable(driver, exportImg, "Export", false);
		
		verifyVisibilityOfButtons(driver, importImg, "Import", true);
		
		isClickable(driver, importImg, "Import", false);
		Thread.sleep(1000);
		if(isDisplayed(driver,expandIcon) && isClickable(driver,expandIcon,"Expand Icon",true))
		{	
			displayAndClick(driver,expandIcon);
		verifyIndividualLabel(driver, rulesTab, "Rule Tab");
		verifyIndividualLabel(driver, sourceDefinationTab, "Source Defination Tab");
		verifyIndividualLabel(driver, parameterTab, "Parameter Tab");	
		verifyIndividualLabel(driver, userDefinedFunTab, "User Defined Function Tab");	
		verifyIndividualLabel(driver, personalRuleSpaceTab, "Personal Rule Space Tab");	
		verifyIndividualLabel(driver, ruleMonitorTab, "Rule Monitor Tab");	
		verifyIndividualLabel(driver, exportTab, "Export Tab");	
		verifyIndividualLabel(driver, importTab, "Import Tab");		
		}
		else
		{
			BaseSuite.reportFailLog("Expand icon is not displayed or not clickable", "verifyHomePage");
		}	

	}
	
	public void ruleRepository() throws Exception
	{
		isDisplayedInLoop(driver,20,ruleRepoClick);
		click(driver,ruleRepoClick);
		BaseSuite.validationReportLog("Clicked on the Rule repository service!!");
		getWindowHandler(driver);		
		//verifyHomeLandingPage();
	}

	
	public void clickRulesTab(SoftAssert soft) throws Exception {
		try
		{
		BaseSuite.reportLog("Clicking on Rules Tab");
		Thread.sleep(1000);
		 if(isDisplayed(driver,ruleImg))
	        {
	            displayAndClick(driver,ruleImg);
	        }
	        else {
		//displayAndClick(driver,expandIcon);		
		 
		 isDisplayedInLoop(driver,20,rulesTab);
		 
		displayAndClick(driver, rulesTab);
	        }
		inVisible(driver, ruleTabSpinner, Constant.ruleWait);	
		
		waitForElement(driver,popUpClose); captureToastMsg(driver, toastMsg,
		popUpClose, ruleLandingPageMsg, "Rule details");		 
		
		BaseSuite.validationReportLog("Rule Tab clicked successfully");		
			        
		}
		catch(Exception e)
		{
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void sourceDefinationTab(SoftAssert soft) throws Exception {
		
		try {
						
			BaseSuite .reportLog("Clicking on Source Defination Tab");
			
			 waitForElement(driver, sourceDefinationTab);

			click(driver, sourceDefinationTab);
			
			inVisible(driver, ruleTabSpinner, Constant.ruleWait);
			waitForElement(driver,popUpClose);
			
			captureToastMsg(driver, toastMsg, popUpClose, ruleLandingPageMsg, "Rule details");
						
			BaseSuite.validationReportLog("Source Defination Tab clicked successfully");
		} 
			catch(Exception e)
			{
				throw new AssertionError("Error occured in this method", e);
			}
		
	}

	public void parameterTab(SoftAssert soft) {
       try
        {
        BaseSuite .reportLog("Clicking on Parameter Tab");
        //Thread.sleep(1000);
        if(isDisplayed(driver,parameterImg))
        {
            displayAndClick(driver,parameterImg);
        }
        else {
        	
        	waitForElement(driver, parameterTab);       
         click(driver, parameterTab);
        }
       
        inVisible(driver, ruleTabSpinner, Constant.ruleWait);       
       
        captureToastMsg1(driver, toastMsg, popUpClose, parameterLandingPageMsg, "Rule details");
       
        BaseSuite.validationReportLog("Parameter Tab clicked successfully");       
        }
        catch(Exception e)
        {
            throw new AssertionError("Error occured in this method", e);
        }
    }


	
	public void userDefinedTab(SoftAssert soft) {
		
		try {
		BaseSuite .reportLog("Clicking on user defined function Tab");
		
		 waitForElement(driver, userDefinedFunTab);
		
		click(driver, userDefinedFunTab);
		
		inVisible(driver, ruleTabSpinner, Constant.ruleWait);
		
		waitForElement(driver,popUpClose);
		
		captureToastMsg(driver, toastMsg, popUpClose, parameterLandingPageMsg, "Rule details");
		
		BaseSuite.validationReportLog("user defined function Tab clicked successfully");
				
		
		}
		catch(Exception e)
		{
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
public void personalRuleSpaceTab(SoftAssert soft) {
		
		try {
		BaseSuite .reportLog("Clicking on personal rule space Tab");
		
		 waitForElement(driver, personalRuleSpaceTab);
		
		click(driver, personalRuleSpaceTab);
		
		inVisible(driver, ruleTabSpinner, Constant.ruleWait);
		
		waitForElement(driver,popUpClose);
		
		captureToastMsg(driver, toastMsg, popUpClose, parameterLandingPageMsg, "Rule details");
		
		BaseSuite.validationReportLog("Personal rule space Tab clicked successfully");
				
		
		}
		catch(Exception e)
		{
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
public void ruleMonitorTab(SoftAssert soft) {
	
	try {
	BaseSuite .reportLog("Clicking on rule monitor Tab");
	
	 waitForElement(driver, ruleMonitorTab);
	
	click(driver, ruleMonitorTab);
	
	inVisible(driver, ruleTabSpinner, Constant.ruleWait);
	
	waitForElement(driver,popUpClose);
	
	captureToastMsg(driver, toastMsg, popUpClose, parameterLandingPageMsg, "Rule details");
	
	BaseSuite.validationReportLog("Rule monitor tab clicked successfully");
			
	
	}
	catch(Exception e)
	{
		throw new AssertionError("Error occured in this method", e);
	}
}

public void exportTab(SoftAssert soft) {
	
	try {
	BaseSuite .reportLog("Clicking on export Tab");
	
	 waitForElement(driver, exportTab);
	
	click(driver, exportTab);
	
	inVisible(driver, ruleTabSpinner, Constant.ruleWait);
	
	waitForElement(driver,popUpClose);
	
	captureToastMsg(driver, toastMsg, popUpClose, parameterLandingPageMsg, "Rule details");
	
	BaseSuite.validationReportLog("Export tab clicked successfully");
		
	}
	catch(Exception e)
	{
		throw new AssertionError("Error occured in this method", e);
	}
}

public void importTab(SoftAssert soft) {
	
	try {
	BaseSuite .reportLog("Clicking on import Tab");
	
	 waitForElement(driver, importTab);
	
	click(driver, importTab);
	
	inVisible(driver, ruleTabSpinner, Constant.ruleWait);
	
	waitForElement(driver,popUpClose);
	
	captureToastMsg(driver, toastMsg, popUpClose, parameterLandingPageMsg, "Rule details");
	
	BaseSuite.validationReportLog("Import tab clicked successfully");
		
	}
	catch(Exception e)
	{
		throw new AssertionError("Error occured in this method", e);
	}
}

public void dataTesting() throws Exception
{
	
	isDisplayedInLoop(driver,2,dataTesting);
	if(isDisplayed(driver, dataTesting)) {
	displayAndClick(driver,dataTesting);
	BaseSuite.validationReportLog("Clicked on the Data Testing service!!");}
	//getWindowHandler(driver);	
	
	
	//verifyHomeLandingPage();
}


}

