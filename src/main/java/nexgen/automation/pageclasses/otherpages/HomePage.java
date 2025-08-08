package nexgen.automation.pageclasses.otherpages;



import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.util.PageUtil;

public class HomePage extends PageUtil {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;

	}

	public By AdministrationLabel = getElementLocator(prop.getProperty("LandingPage.AdministrationLabel"));
	By DataConnectionsLabel = getElementLocator(prop.getProperty("LandingPage.DataConnectionsLabel"));
	By WelcomeHeader = getElementLocator(prop.getProperty("Landingpage.WelcomeHeader"));
	By WelcomeUser = getElementLocator(prop.getProperty("Landingpage.WelcomeUser"));
	By UserName = getElementLocator(prop.getProperty("Landingpage.UserName"));
	public  By homePageWellcomeMsg = getElementLocator(prop.getProperty("Home.HomePageWellcomeMsg"));
	
	
	By UserOption = getElementLocator(prop.getProperty("LandingPage.UserOptions"));
	By Profile = getElementLocator(prop.getProperty("LandingPage.Profile"));
	By Logout = getElementLocator(prop.getProperty("LandingPage.Logout"));
	

	By RuleConfigurationLabel = getElementLocator(prop.getProperty("LandingPage.RuleConfigurationLabel"));
	By dataPrepLabel = getElementLocator(prop.getProperty("LandingPage.DataPrepLabel"));
	By TestLabLabel = getElementLocator(prop.getProperty("LandingPage.TestLabLabel"));
	By ObservabilityLabel = getElementLocator(prop.getProperty("LandingPage.ObservabilityLabel"));
	By OrchestrationLabel = getElementLocator(prop.getProperty("LandingPage.OrchestrationLabel"));
	By CodeRepositoryLabel = getElementLocator(prop.getProperty("LandingPage.CodeRepositoryLabel"));
	By DataCatalogLabel = getElementLocator(prop.getProperty("LandingPage.DataCatalogLabel"));
	By ListIcon = getElementLocator(prop.getProperty("LandingPage.ListIcon"));
	By ListIconAdministration = getElementLocator(prop.getProperty("LandingPage.ListIcon.Administration"));
	By ListIconDataConnection = getElementLocator(prop.getProperty("LandingPage.ListIcon.DataConnection"));
	By ListIconRuleConfiguration = getElementLocator(prop.getProperty("LandingPage.ListIcon.RuleConfiguration"));
	
	By AdministrationHomePageLabel = getElementLocator(prop.getProperty("LandingPage.AdministrationHomePageLabel"));
	By ToastMsgClosedBtn = getElementLocator(prop.getProperty("ToastMsgClosedBtn"));
	By icedq_logo = getElementLocator(prop.getProperty("Home.icedq_Logo"));
	By nextGenTabs = getElementLocator(prop.getProperty("Home.NextGenTabs"));
	By userProfile = getElementLocator(prop.getProperty("Home.userProfile"));
	By nextGentTabState=getElementLocator(prop.getProperty("Home.NextGenTabsstatus"));
	//Side nmenus
	By UserMenu = getElementLocator(prop.getProperty("Admin.UserMenu"));
	By GroupsMenu = getElementLocator(prop.getProperty("Admin.GroupsMenu"));
	By RolesMenu = getElementLocator(prop.getProperty("Admin.RolesMenu"));
	By AccountsMenu = getElementLocator(prop.getProperty("Admin.AccountsMenu"));
	By WorkspaceMenu = getElementLocator(prop.getProperty("Admin.WorkspaceMenu"));
	By dataprepLandPageTab = getElementLocator(prop.getProperty("LandingPage.DataPrepLabel"));
	By workspaceList =getElementLocator(prop.getProperty("DataTesting.WorkspaceWindow"));
	By workspaceSearch=getElementLocator(prop.getProperty("DataTesting.WorkspaceSearch"));
	By workspaceSearchTxt=getElementLocator(prop.getProperty("Data.WorkspaceSearchTxt"));
	By spinner = getElementLocator(prop.getProperty("Spinner"));
	By okButton = getElementLocator(prop.getProperty("WorkspaceOkButton"));
	By toastMsg=getElementLocator(prop.getProperty("Commontoastmsg"));
	By workspacePopUpWindow=getElementLocator(prop.getProperty("WorkspacePopUpWindow"));
	By selectWorkspace=getElementLocator(prop.getProperty("Home.selectWOrkspace"));
	
	String createElement = prop.getProperty("Data.desiredConn");
	String connFetchedMsg=prop.getProperty("Connection.ConnFetchMsg");
	String newConnToastMsg = prop.getProperty("Connection.NewConnBtn.UserAuth.ErrMsg");
	public void verifyLandingPage_Services() {
		
		String msg = "Admin/RuleConfiguration/TestLab/Scheduler/Orchestration/CodeRepository/DataCatalog";
		
		try {
			if ((isEnabled(driver, AdministrationLabel)) && (isEnabled(driver, RuleConfigurationLabel)) && (isEnabled(driver, TestLabLabel))
					&& (isEnabled(driver, ObservabilityLabel)) && (isEnabled(driver, OrchestrationLabel))
					&& (isEnabled(driver, CodeRepositoryLabel)) && (isEnabled(driver, DataCatalogLabel))) {
			
				BaseSuite.reportLog(msg+ " options are displaying in the page");
				BaseSuite.validationReportLog("Serives are displaying on the Landing Page!!");

			} else {
				BaseSuite.reportFailLog(msg+ " is not displaying in the page", "verifyLandingPage_Services");
			}
		} catch (Exception e) {
			e.getMessage();
		}

	
	}

	public void administration() throws Exception {

		
		
		verifyLandingPage_Services(); // landing page verification
		BaseSuite.reportLog("Checking for the Administration service");
		isDisplayedInLoop(driver, 30, AdministrationLabel);

		click(driver, AdministrationLabel);
		BaseSuite.validationReportLog("Clicked on the Administration service!!");
		getWindowHandler(driver);
		
		Thread.sleep(3000);
		isDisplayed(driver, AdministrationHomePageLabel);
		BaseSuite.reportLog("Landed on Administration service page!");
		BaseSuite.validationReportLog("Welcome to Administration Section, With Aministration Section, you can manage users, accounts and workspaces!!");
		verifySideMenus();
	}

	
	public void verifySideMenus()
	{
		String msg = "Users/Groups/Roles/Accounts/Workspace";
		try {
			BaseSuite.reportLog("Checking the side bar options in the Administration Section!!");

			if ((isEnabled(driver, UserMenu)) && (isEnabled(driver, GroupsMenu)) && (isEnabled(driver, RolesMenu))
					&& (isEnabled(driver, AccountsMenu)) && (isEnabled(driver, WorkspaceMenu))) {
			
				BaseSuite.reportLog(msg+ " options are displaying in the administration page");
				BaseSuite.validationReportLog("Sidebar menus are displaying in the Administration Home page!!");

			} else {
				BaseSuite.reportFailLog(msg+ " is not displaying in the page", "verifySideMenus");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void dataConnections() {

		isDisplayedInLoop(driver, 20, DataConnectionsLabel);

		click(driver, DataConnectionsLabel);
		BaseSuite.reportLog("Landed on Data Connection service page!");
	}

	public void ruleConfiguration() {

		isDisplayedInLoop(driver, 20, RuleConfigurationLabel);

		click(driver, RuleConfigurationLabel);
		BaseSuite.reportLog("Landed on Rule Configuration service page!");
	}

	public void testLab() {

		isDisplayedInLoop(driver, 20, TestLabLabel);

		click(driver, TestLabLabel);
		BaseSuite.reportLog("Landed on Test Lab service page!");
	}

	public void scheduler() {

		isDisplayedInLoop(driver, 20, ObservabilityLabel);

		click(driver, ObservabilityLabel);
		BaseSuite.reportLog("Landed on Observability service page!");
	}

	public void orchestration() {

		isDisplayedInLoop(driver, 20, OrchestrationLabel);

		click(driver, OrchestrationLabel);
		BaseSuite.reportLog("Landed on Orchestration service page!");
	}

	public void codeRepository() {

		isDisplayedInLoop(driver, 20, CodeRepositoryLabel);

		click(driver, CodeRepositoryLabel);
		BaseSuite.reportLog("Landed on Code Repository service page!");
	}

	public void dataCatalog() {

		isDisplayedInLoop(driver, 20, DataCatalogLabel);

		click(driver, DataCatalogLabel);
		BaseSuite.reportLog("Landed on Data Catalog service page!");
	}
	
	public void dataPrep() throws Exception
	{
		isDisplayedInLoop(driver,20,dataPrepLabel);
		click(driver,dataPrepLabel);
		BaseSuite.validationReportLog("Clicked on the Data prep service!!");
		getWindowHandler(driver);	
	}


//	public void ruleMonitor() {
//		isDisplayedInLoop(driver, 20, RuleMonitor );
//	    click(driver,RuleMonitor);
//	  //  RuleMonitorPage rm =new RuleMonitorPage(driver);
//	  //  rm.verifyRuleMonitorLandingPage();
//	    
//	    BaseSuite.reportLog("Landed on Rule Monitor page");
//	}

	
	
	public void verifyLoginUser(String username)
	{
		isDisplayedInLoop(driver, 10, WelcomeUser);
		if(isEnabled(driver, WelcomeUser))
		{
			isDisplayed(driver, UserName);
			BaseSuite.reportLog(username+ " is displaying in the page");
			BaseSuite.validationReportLog(username + " this user is displaying on the page the Landing Page!!");
			
		}
		else
		{
			BaseSuite.reportLog(username+ " is not displaying in the page");
		}
		
	}
	
	public boolean verifyUserOption()
	{
		String options = "Profile/Logout";
		
		boolean flag = false;
		if(isEnabled(driver, WelcomeUser))
		{
		click(driver, UserOption);
		isDisplayedInLoop(driver, 20, Profile);
		isDisplayedInLoop(driver, 20, Logout);
		click(driver, UserOption);
		BaseSuite.reportLog(options + " Options are displaying in the User Dropdown");
		
		flag = true;
		}
		else
		{
			BaseSuite.reportLog(options + " Options are not displaying in the User Dropdown");
		}
		
		return flag;
	}
	
	//Added comments
	//method to choose workspace on nextgen ui
	public void chooseWorkspace(String workspaceName) {

		
		SoftAssert soft = new SoftAssert();
		Actions action = new Actions(driver);
		try {
			isDisplayedInLoop(driver,10,workspacePopUpWindow);
			if(isDisplayed(driver, workspacePopUpWindow)) {
				BaseSuite.reportLog("Selecting Workspace...");
				WebElement s1 = driver.findElement(workspaceList);
				isDisplayedInLoop(driver,20,workspaceList);

				BaseSuite.reportLog("Search text box is displayed, to search workspace :: "+workspaceName);
				action.click(s1).build().perform();
				BaseSuite.validationReportLog("Clicked on workspace search successfully");
				isDisplayedInLoop(driver, 10, workspaceSearch);	

				WebElement s2 = driver.findElement(workspaceSearch);

				action.click(s2).build().perform();
				BaseSuite.reportLog("Entering workspace name :: "+workspaceName);
				sendKeys(driver, workspaceSearch, workspaceName);
				BaseSuite.reportLog("Entered workspace name :: "+workspaceName);

				isDisplayedInLoop(driver, 5, returnElement(createElement, "$name", workspaceName));
				if(isDisplayed(driver, returnElement(createElement, "$name", workspaceName))) {
					displayAndClick(driver, returnElement(createElement, "$name", workspaceName));

					BaseSuite.validationReportLog("Successfully searched & clicked on workspace :: "+workspaceName);
					//check weather correct connection is selected.
					
					waitForElement(driver, workspaceList);
					String con=getAttribute(driver, workspaceList,"value");
					soft.assertEquals(con, workspaceName,"Expected workspace didnt matched with selected workspace.");
					if(con.equalsIgnoreCase(workspaceName))
					{
						
						BaseSuite.validationReportLog("Correct workspace :: "+con+" is selected.");
					}
					displayAndClick(driver, okButton);
					inVisible(driver, spinner, Constant.ruleWait);
					if(isDisplayed(driver, toastMsg)) {
					captureToastMsg(driver, toastMsg, ToastMsgClosedBtn, newConnToastMsg, "Connection Fetched");
					}
				}else {
					BaseSuite.reportFailLog("Workspace name not found :: "+workspaceName, "chooseWorkspace");
					throw new AssertionError("Unable to select workspace to the application!");
				}
			}else {
				BaseSuite.reportLog("Workspace pop up window not visible  ");
			//	selectWorkspace(workspaceName);
			//	throw new AssertionError("Unable to select workspace to the application!");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	By chooseWorkspaceDropdownButton=getElementLocator(prop.getProperty("datatesting.Workspace.Dropdown.Button"));
	public void validateNextGenTabs() {
		
		verifyIndividualLabel(driver, icedq_logo, "iceDQ logo");
		isClickable(driver, icedq_logo, "iceDQ logo", true);

		verifyVisibilityOfButtons(driver, userProfile, "User Profile", true);
		isClickable(driver, userProfile, "User Profile", true);
		
		validateIsDisplayedOrNot(driver, chooseWorkspaceDropdownButton, "Select workspace", true);

		BaseSuite.reportLog("Checking visibility of Next gen menu tabs ");

		List<WebElement> check = getElements(driver, nextGenTabs);
		List<WebElement> checkstate = getElements(driver, nextGentTabState);
		for(int i=0 ; i<check.size();i++) {

			String title = check.get(i).getAttribute("aria-label");

			String status = checkstate.get(i).getAttribute("aria-label");

			BaseSuite.reportLog("checking "+title+" menu tab visibility ");

			if(!status.contains("disable")) {
				BaseSuite.validationReportLog(title+ " menu tab enabled ");

			}else {
				BaseSuite.validationReportLog(title+ " menu tab disabled ");
			}
		}
	}
	
	public void selectWorkspace(String workspaceName){
		
		try {
			clickOnButton(driver, userProfile, "User profile", true);
			
			isDisplayedInLoop(driver, 10, selectWorkspace);
			if(isDisplayed(driver, selectWorkspace)) {
				displayAndClick(driver, selectWorkspace);
				
				chooseWorkspace(workspaceName);
			}else {
				BaseSuite.reportFailLog("Select workspace button not visible", "selectWorkspace");
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	//===================================== Common Code ======================================================
	By dashboardtab=getElementLocator(prop.getProperty("module.tab.dashboard"));
	public By datatestingtab=getElementLocator(prop.getProperty("module.tab.datatesting"));
	By schedulertab=getElementLocator(prop.getProperty("module.tab.scheduler"));
	By connectionstab=getElementLocator(prop.getProperty("module.tab.connections"));
	By administrationtab=getElementLocator(prop.getProperty("module.tab.administration"));
	By dmoTab=getElementLocator(prop.getProperty("module.tab.dmo"));
	By knowledgeGraphTab=getElementLocator(prop.getProperty("module.tab.knowledgegraph"));
	By incidentManagementTab=getElementLocator(prop.getProperty("module.tab.incidentManagement"));
	By dataObservabilityTab=getElementLocator(prop.getProperty("module.tab.dataObservability"));
	
	By connectionsSubmoduleTab=getElementLocator(prop.getProperty("connections.submodule.connections"));
	By userConnectionsTab=getElementLocator(prop.getProperty("connections.submodule.userconnections"));
	By secretsTab=getElementLocator(prop.getProperty("connections.submodule.secrets"));
	
	By dashboardIcon=getElementLocator(prop.getProperty("module.icon.dashboard"));
	By datatestingIcon=getElementLocator(prop.getProperty("module.icon.datatesting"));
	By schedulerIcon=getElementLocator(prop.getProperty("module.icon.scheduler"));
	By connectionsIcon=getElementLocator(prop.getProperty("module.icon.connections"));
	By administrationIcon=getElementLocator(prop.getProperty("module.icon.administration"));
	By dmoIcon=getElementLocator(prop.getProperty("module.icon.dmo"));
	By knowledgeGraphIcon=getElementLocator(prop.getProperty("module.icon.knowledgegraph"));
	By incidentManagementIcon=getElementLocator(prop.getProperty("module.icon.incidentManagement"));
	By dataObservabilityIcon=getElementLocator(prop.getProperty("module.icon.dataObservability"));
	
	By helpdeskButton=getElementLocator(prop.getProperty("homepage.button.helpdesk"));
	By aboutButton=getElementLocator(prop.getProperty("homepage.button.about"));
	By documentationButton=getElementLocator(prop.getProperty("homepage.button.documentation"));

	By dataTSpinner=getElementLocator(prop.getProperty("dataT.spinner"));
	By icedqLogo = getElementLocator(prop.getProperty("Home.icedq_Logo"));
	By userProfile1 = getElementLocator(prop.getProperty("Home.userProfile"));
	By toastMsg1=getElementLocator(prop.getProperty("Workflow.Toast.Message"));
	By toastMsgCloseBtn=getElementLocator(prop.getProperty("Workflow.Toast.Close"));
	
	By workspaceFieldDropdown=getElementLocator(prop.getProperty("Workspace.field.on.screen"));
	By usersListingNoRecordsToDisplay=getElementLocator(prop.getProperty("users.details.users.NoRecordsToDisplay"));
	
	By nextgenSubModuleUsers=getElementLocator(prop.getProperty("nextgenmodule.submodule.users"));
	By nextgenSubModuleGroups=getElementLocator(prop.getProperty("nextgenmodule.submodule.groups"));
	By nextgenSubModuleRoles=getElementLocator(prop.getProperty("nextgenmodule.submodule.roles"));
	By nextgenSubModuleAccounts=getElementLocator(prop.getProperty("nextgenmodule.submodule.accounts"));
	By nextgenSubModuleWorkspaces=getElementLocator(prop.getProperty("nextgenmodule.submodule.workspaces"));
	By nextgenSubModuleFederations=getElementLocator(prop.getProperty("nextgenmodule.submodule.federations"));
	By nextgenSubModuleIdentityProviders=getElementLocator(prop.getProperty("nextgenmodule.submodule.identityproviders"));
	By nextgenSubModuleVault=getElementLocator(prop.getProperty("nextgenmodule.submodule.vault"));
	By nextgenSubModuleFields=getElementLocator(prop.getProperty("nextgenmodule.submodule.fields"));
	By nextgenSubModuleCalenders=getElementLocator(prop.getProperty("nextgenmodule.submodule.calenders"));
	By nextgenSubModuleSettings=getElementLocator(prop.getProperty("nextgenmodule.submodule.settings"));
	By nextgenSubModuleIntegrations=getElementLocator(prop.getProperty("nextgenmodule.submodule.integrations"));
	By nextgenSubModuleLibraries=getElementLocator(prop.getProperty("nextgenmodule.submodule.libraries"));
	By nextgenSubModuleConfigurations=getElementLocator(prop.getProperty("nextgenmodule.submodule.configurations"));
	By nextgenSubModuleSecurity=getElementLocator(prop.getProperty("nextgenmodule.submodule.security"));
	
	String hyphenContent=prop.getProperty("String.hyphenContent");
	String moduleContent=prop.getProperty("String.moduleContent");
	String subModuleContent=prop.getProperty("String.subModuleContent");
	String tabContent=prop.getProperty("String.tabContent");
	String iconContent=prop.getProperty("String.iconContent");
	String administrationContent=prop.getProperty("String.administrationContent");
	String dataTestingContent=prop.getProperty("String.dataTestingContent");
	String schedulerContent=prop.getProperty("String.schedulerContent");
	String connectionsContent=prop.getProperty("String.connectionsContent");
	String connectorsContent=prop.getProperty("String.connectorsContent");
	String workspacesContent=prop.getProperty("String.workspacesContent");
	String errorLogTitle=prop.getProperty("string.Error.Log.Title");
	String moduleTab=prop.getProperty("nextgen.hamberger.tab1");
	String subModuleTab=prop.getProperty("nextgenmodule.submodule.tab");
	String subModuleHeadingName=prop.getProperty("nextgenmodule.submodule.headingDynamic");
	String dynamicName=prop.getProperty("DynName");
	String nextgenSubModuleDynamic=prop.getProperty("nextgenmodule.submodule.dynamic");
	String groupsContent=prop.getProperty("String.groupsContent");
	String usersContent=prop.getProperty("String.usersContent");
	String accountsContent=prop.getProperty("String.accountsContent");
	String rolesContent=prop.getProperty("String.rolesContent");
	String fedetationsContent=prop.getProperty("String.fedetationsContent");
	String identityProvidersContent=prop.getProperty("String.identityProvidersContent");
	
	String dashboardandReportingContent="Dashboard";
	String verifyingContent=" Verifying ";
	String userProfileContent="User Profile";
	String icedqLogoContent="iceDQ logo";
	String secretsContent="Secrets";
	String rulesContent="Rules";
	
	String schedulesSubModules = prop.getProperty("schedules.submodule.tab");
	
	public void validateHomePageAndModules() {
        try {
        	 BaseSuite.reportLog(hyphenContent + " Verifying Nextgen module tab on Home page " + hyphenContent);

            if (!isDisplayed(driver, datatestingtab) && !isDisplayed(driver, workspacePopUpWindow)) {
                click(driver, icedqLogo);
                isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
            }

            if (!isDisplayed(driver, workspacePopUpWindow)) {
                validateTabAndIcon(datatestingtab, datatestingIcon, dataTestingContent);
                validateTabAndIcon(schedulertab, schedulerIcon, schedulerContent);
                validateTabAndIcon(connectionstab, connectionsIcon, connectorsContent);
                validateTabAndIcon(administrationtab, administrationIcon, administrationContent);

                verifyVisibilityOfButtons(driver, helpdeskButton, "Helpdesk", true);
                verifyVisibilityOfButtons(driver, aboutButton, "About", true);
                verifyVisibilityOfButtons(driver, documentationButton, "Documentation", true);
            }

        } catch (Exception e) {
        	 BaseSuite.reportErrorLog(e, errorLogTitle + " validateNextgenHomePage :: " + e);
        }
    }

    private void validateTabAndIcon(By tab, By icon, String label) {
        validateElement(driver, tab, label, tabContent);
        validateElement(driver, icon, label, iconContent);
    }

    public void clickTabAndValidateSubModule(By tabLocator, String label, By subModuleLocator, String subModuleName) {
        try {
            validateHomePageAndModules();

            clickOnButton(driver, tabLocator, label, true);

            if (isDisplayed(driver, toastMsg)) {
                captureToastMsgWithContains(driver, toastMsg, toastMsgCloseBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG, label + " tab authorization message");
            }

            waitUntilDisplayed(subModuleLocator, subModuleName);

        } catch (Exception e) {
        	 BaseSuite.reportErrorLog(e, errorLogTitle + " clickTabAndValidateSubModule [" + label + "] :: " + e);
        }
    }

    private void waitUntilDisplayed(By locator, String label) {
        for (int i = 0; i < 120; i++) {
            if (isDisplayed(driver, locator)) {
                return;
            }
            waitForExecution(1000);
        }
        BaseSuite.reportErrorLog("Timeout waiting for submodule: " + label);
    }

    public void clickOnDataTestingTab() {
        clickTabAndValidateSubModule(datatestingtab, dataTestingContent,
                returnElement(nextgenSubModuleDynamic, dynamicName, rulesContent), rulesContent);
    }

    public void clickOnConnectorsTab() {
        clickTabAndValidateSubModule(connectionstab, connectorsContent,
        		connectionsSubmoduleTab, connectorsContent);
    }

    public void clickOnAdministrationTab() {
        clickTabAndValidateSubModule(administrationtab, administrationContent,
                nextgenSubModuleUsers, "Users");
    }

    public void clickOnSchedulerTab() {
        try {
            validateHomePageAndModules();

            clickOnButton(driver, schedulertab, schedulerContent, true);

            if (isDisplayed(driver, toastMsg)) {
                captureToastMsgWithContains(driver, toastMsg, toastMsgCloseBtn,
                        ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
                        schedulerContent + " tab authorization message");
            }
            // Scheduler submodules wait (optional based on your use case)

        } catch (Exception e) {
        	 BaseSuite.reportErrorLog(e, errorLogTitle + " clickOnSchedulerTab :: " + e);
        }
    }
	
	public void checkCSSColorOfElement(By locator,String label, String attribute, String expectedColor) {
		
		getCSSColorOfElement(driver, locator,label, attribute, expectedColor);

	}
	
	public void performCommonNextgenSetup(String context) {
        try {
            isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
            verifyIndividualLabel(driver, icedqLogo, icedqLogoContent);
            isClickable(driver, icedqLogo, icedqLogoContent, true);
            verifyVisibilityOfButtons(driver, userProfile, userProfileContent, true);
            isClickable(driver, userProfile, userProfileContent, true);
            BaseSuite.reportLog(hyphenContent + " Verifying Nextgen icedq module tab on " + context + " listing page " + hyphenContent);
        } catch (Exception e) {
            BaseSuite.reportErrorLog(e, errorLogTitle + " performCommonNextgenSetup (" + context + ") :: " + e.toString());
        }
    }

    public void validateSubModules(String locatorTemplate, List<String> subModules, String contextLabel) {
        for (String subModule : subModules) {
            By locator = returnElement(locatorTemplate, dynamicName, subModule);
            validateElement(driver, locator, subModule, contextLabel);
        }
    }

    public void verifyHighlightedModule(String moduleName) {
        By locator = returnElement(moduleTab, dynamicName, moduleName);
        checkCSSColorOfElement(locator, moduleName, "background-color", "Blue");
    }

    public void logModuleValidation(String moduleName) {
        BaseSuite.reportLog(hyphenContent + " Verifying Nextgen icedq module tab on " + moduleName + " listing page " + hyphenContent);
    }

    public void validateNextgenModuleAndDataTestingSubModules() {
        try {
            performCommonNextgenSetup("DataTesting");
            logModuleValidation(dataTestingContent);

            validateSubModules(moduleTab, Arrays.asList(dataTestingContent, schedulerContent, connectorsContent, administrationContent), moduleContent);
            verifyHighlightedModule(dataTestingContent);

            validateSubModules(nextgenSubModuleDynamic, Arrays.asList(rulesContent, "Parameters", "Functions", "Workflows", "Instances"), subModuleContent);

        } catch (Exception e) {
            BaseSuite.reportErrorLog(e, errorLogTitle + " validateNextgenModuleAndDataTestingSubModules :: " + e.toString());
        }
    }

    public void validateNextgenIcedqModuleAndAdministrationSubModules() {
        try {
            performCommonNextgenSetup("Administration");
            logModuleValidation(administrationContent);

            validateSubModules(moduleTab, Arrays.asList(dataTestingContent, schedulerContent, connectorsContent, administrationContent), moduleContent);
            verifyHighlightedModule(administrationContent);

            validateSubModules(nextgenSubModuleDynamic, Arrays.asList("Users", "Groups", "Roles", "Accounts", "Workspaces", "Configurations"), subModuleContent);

        } catch (Exception e) {
            BaseSuite.reportErrorLog(e, errorLogTitle + " validateNextgenIcedqModuleAndAdministrationSubModules :: " + e.toString());
        }
    }

    public void validateNextgenIcedqModuleAndSecretsSubModules() {
        try {
            performCommonNextgenSetup(secretsContent);
            logModuleValidation(connectorsContent);

            validateSubModules(moduleTab, Arrays.asList(dataTestingContent, schedulerContent, connectorsContent, administrationContent), moduleContent);
            verifyHighlightedModule(connectorsContent);

            validateSubModules(nextgenSubModuleDynamic, Arrays.asList("Connections", "User Profiles", secretsContent), subModuleContent);

        } catch (Exception e) {
            BaseSuite.reportErrorLog(e, errorLogTitle + " validateNextgenIcedqModuleAndSecretsSubModules :: " + e.toString());
        }
    }

    public void validateNextgenIcedqModuleAndSchedulerSubModules() {
        try {
            performCommonNextgenSetup("Schedulers");
            logModuleValidation(schedulerContent);

            validateSubModules(moduleTab, Arrays.asList(dataTestingContent, schedulerContent, connectorsContent, administrationContent), moduleContent);
            verifyHighlightedModule(schedulerContent);

            validateSubModules(nextgenSubModuleDynamic, Arrays.asList("Schedules", "Schedule Monitor"), subModuleContent);

        } catch (Exception e) {
            BaseSuite.reportErrorLog(e, errorLogTitle + " validateNextgenIcedqModuleAndSchedulerSubModules :: " + e.toString());
        }
    }
	
}