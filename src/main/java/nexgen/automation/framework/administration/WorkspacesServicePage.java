package nexgen.automation.framework.administration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;
import nexgen.automation.pageclasses.otherpages.HomePage;
import nextgen.automation.workflow.service.pages.DataTestingParameters;
import nextgen.automation.workflow.service.pages.WorkflowPage;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WorkspacesServicePage extends PageUtil {

	WebDriver driver;

	public WorkspacesServicePage(WebDriver driver) {
		this.driver = driver;
	}

	protected static final Logger log = Logger.getLogger(WorkspacesServicePage.class);
	static String dirPath=System.getProperty("user.dir");

	public final String wORKSPACEEXCELFILEPATH = System.getProperty("user.dir")+ Constant.NEXTGEN_WORKSPACE_TESTDATA_EXCEL_PATH;
	public static final String PARAMETERPRIVILEGEFORBIDDENMESSAGE=prop.getProperty("workflow.toast.forbidden.Message");
	boolean isrelease5Flag=Boolean.parseBoolean(prop.getProperty("isrelease5orNot"));
	public static final boolean IS_MULTI_TENENT_ACCOUNT=Constant.MULTI_TENENT_ACCOUNT;
	/** ----------------------  By locators ---------------------------------- **/

	By dataTSpinner=getElementLocator(prop.getProperty("dataT.spinner"));
	By icedqLogo = getElementLocator(prop.getProperty("Home.icedq_Logo"));
	By userProfile = getElementLocator(prop.getProperty("Home.userProfile"));
	By toastMsg=getElementLocator(prop.getProperty("Workflow.Toast.Message"));
	By toastMsgClosedBtn=getElementLocator(prop.getProperty("Workflow.Toast.Close"));	
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
	By workspaceSubModuleTab=getElementLocator(prop.getProperty("workspace.submodule.tab"));	
	By workspaceDiscardHandle=getElementLocator(prop.getProperty("workspace.details.handle.discard"));
	By workspaceBreadcrumbHomeLink=getElementLocator(prop.getProperty("workspace.breadcrumb.home"));
	By workspaceBreadcrumbAdminLink=getElementLocator(prop.getProperty("workspace.breadcrumb.administration"));
	By workspaceBreadcrumbWorkspacesLabel=getElementLocator(prop.getProperty("workspace.breadcrumb.workspaces"));
	By workspaceBreadcrumbWorkspaceLink=getElementLocator(prop.getProperty("workspace.breadcrumb.workspacesLink"));
	By workspaceBreadcrumbCreateNewWorkspaceLabel=getElementLocator(prop.getProperty("workspace.details.breadcrumb.createnewworkspace"));	
	By workspacePageTitle=getElementLocator(prop.getProperty("workspace.page.title"));	
	By workspaceListingSearchField=getElementLocator(prop.getProperty("workspace.listing.search.field"));
	By workspaceListingSearchButton=getElementLocator(prop.getProperty("workspace.listing.search.button"));
	By workspaceListingSearchClear=getElementLocator(prop.getProperty("workspace.listing.search.clear"));	
	By workspaceListingNewWorkspaceButton=getElementLocator(prop.getProperty("workspace.listing.newworkflow.button"));
	By workspaceListingRefreshIcon=getElementLocator(prop.getProperty("workspace.listing.refresh.icon"));
	By workspaceListingColumnName=getElementLocator(prop.getProperty("workspace.listing.column.name"));
	By workspaceListingColumnDescription=getElementLocator(prop.getProperty("workspace.listing.column.description"));
	By workspaceListingColumnAccount=getElementLocator(prop.getProperty("workspace.listing.column.account"));
	By workspaceListingColumnUpdatedBy=getElementLocator(prop.getProperty("workspace.listing.column.name"));
	By workspaceListingPaginationBar=getElementLocator(prop.getProperty("workspace.listing.pagination.bar"));
	By workspaceListingPaginationMsg=getElementLocator(prop.getProperty("workspace.listing.pagination.info"));
	By workspaceListingNextPageArrow=getElementLocator(prop.getProperty("workspace.listing.nextpageArrow"));
	By workspaceListingNoRecordsToDisplay=getElementLocator(prop.getProperty("workspace.listing.norecordstodisplay"));
	By workspaceListingDescList=getElementLocator(prop.getProperty("workspace.listing.dynamic.descriptionList"));

	By workspaceDetailsBreadcrumbCreateNewWorkspace=getElementLocator(prop.getProperty("workspace.details.breadcrumb.createnewworkspace"));
	By workspaceDetailsBreadcrumbWorkspaceId=getElementLocator(prop.getProperty("workspace.details.breadcrumb.dynamic.workspaceid"));

	By workspaceDetailsAccountLabel=getElementLocator(prop.getProperty("workspace.details.account.label"));
	By workspaceDetailsAccountField=getElementLocator(prop.getProperty("workspace.details.account.field"));
	By workspaceDetailsAccountDropdown=getElementLocator(prop.getProperty("workspace.details.account.dropdown"));
	By workspaceDetailsAccountSelectSearch=getElementLocator(prop.getProperty("workspace.details.account.select.search"));	
	By workspaceDetailsAccountSelectNoRecordsFound=getElementLocator(prop.getProperty("workspace.details.account.select.norecordsfound"));
	By workspaceDetailsNameLabel=getElementLocator(prop.getProperty("workspace.details.workspace.name.label"));
	By workspaceDetailsNameField=getElementLocator(prop.getProperty("workspace.details.workspace.name.field"));
	By workspaceDetailsNameValidation=getElementLocator(prop.getProperty("workspace.details.workspace.name.validation"));
	By workspaceDetailsDescLabel=getElementLocator(prop.getProperty("workspace.details.description.label"));
	By workspaceDetailsDescField=getElementLocator(prop.getProperty("workspace.details.description.field"));
	By workspaceDetailsDescValidation=getElementLocator(prop.getProperty("workspace.details.description.validation"));	
	By workspaceDetailsTypeLabel=getElementLocator(prop.getProperty("workspace.details.type.label"));
	By workspaceDetailsTypeField=getElementLocator(prop.getProperty("workspace.details.type.field"));	
	By workspaceDetailsSaveButton=getElementLocator(prop.getProperty("workspace.details.save.button"));
	By workspaceDetailsDiscardButton=getElementLocator(prop.getProperty("workspace.details.discard.button"));
	By workspaceDetailsUserGroupTab=getElementLocator(prop.getProperty("workspace.details.usersgroup.tab"));
	By workspaceDetailsPreferencesTab=getElementLocator(prop.getProperty("workspace.details.preferences.tab"));

	By workspaceDetailsUserGroupTabAssignButton=getElementLocator(prop.getProperty("workspace.details.button.assign.users"));
	By workspaceDetailsUserGroupTabRefreshButton=getElementLocator(prop.getProperty("workspace.details.button.users.refresh"));
	By workspaceDetailsUserGroupTabDeleteButton=getElementLocator(prop.getProperty("workspace.details.button.users.delete"));

	By workspaceDetailsUserGroupTabSearchField=getElementLocator(prop.getProperty("workspace.details.search.user.field"));
	By workspaceDetailsUserGroupTabSearchButton=getElementLocator(prop.getProperty("workspace.details.search.user.button"));
	By workspaceDetailsUserGroupTabSearchClear=getElementLocator(prop.getProperty("workspace.details.search.user.clear"));

	By workspaceDetailsUserGroupTabMasterCheckbox=getElementLocator(prop.getProperty("workspace.details.users.mastercheckbox"));
	By workspaceDetailsUserGroupTabColumnName=getElementLocator(prop.getProperty("workspace.details.users.column.name"));
	By workspaceDetailsUserGroupTabColumnType=getElementLocator(prop.getProperty("workspace.details.users.column.type"));
	By workspaceDetailsUserGroupTabColumnRole=getElementLocator(prop.getProperty("workspace.details.users.column.role"));
	By workspaceDetailsUserGroupTabColumnScope=getElementLocator(prop.getProperty("workspace.details.users.column.scope"));
	By workspaceDetailsUserGroupTabNoRecordsToDisplay=getElementLocator(prop.getProperty("workspace.details.users.NoRecordsToDisplay"));
	By workspaceDetailsUserGroupTabPaginationBar=getElementLocator(prop.getProperty("workspace.details.users.pagination.bar"));
	By workspaceDetailsUserGroupTabPaginationMsg=getElementLocator(prop.getProperty("workspace.details.users.pagination.info"));

	By workspaceDetailsPopupDiscardTitle=getElementLocator(prop.getProperty("workspace.details.popup.discard.title"));
	By workspaceDetailsPopupDiscardContent=getElementLocator(prop.getProperty("workspace.details.popup.discard.content"));
	By workspaceDetailsPopupDiscardButton=getElementLocator(prop.getProperty("workspace.details.popup.discard.discardbutton"));
	By workspaceDetailsPopupDiscardCancelButton=getElementLocator(prop.getProperty("workspace.details.popup.discard.cancelbutton"));

	By workspaceDetailsUserGroupPopupDeleteTitle=getElementLocator(prop.getProperty("workspace.details.popup.UserGroupDelete.title"));
	By workspaceDetailsUserGroupPopupDeleteContent=getElementLocator(prop.getProperty("workspace.details.popup.UserGroupDelete.content"));
	By workspaceDetailsUserGroupPopupDeleteButton=getElementLocator(prop.getProperty("workspace.details.popup.UserGroupDelete.deletebutton"));
	By workspaceDetailsUserGroupPopupDeleteCancelButton=getElementLocator(prop.getProperty("workspace.details.popup.UserGroupDelete.cancelbutton"));

	By workspaceDetailsSidebarRoleLabel=getElementLocator(prop.getProperty("workspace.details.sidebar.assign.users.role.label"));
	By workspaceDetailsSidebarRoleField=getElementLocator(prop.getProperty("workspace.details.sidebar.assign.users.role.field"));
	By workspaceDetailsSidebarRoleDropdown=getElementLocator(prop.getProperty("workspace.details.sidebar.assign.users.role.dropdown"));
	By workspaceDetailsSidebarRoleSelect=getElementLocator(prop.getProperty("workspace.details.sidebar.assign.users.role.select"));

	By workspaceDetailsSidebarAssignToLabel=getElementLocator(prop.getProperty("workspace.details.sidebar.assign.access.to.label"));
	By workspaceDetailsSidebarAssignToField=getElementLocator(prop.getProperty("workspace.details.sidebar.assign.access.to.field"));
	By workspaceDetailsSidebarAssignToDropdown=getElementLocator(prop.getProperty("workspace.details.sidebar.assign.access.to.dropdown"));
	By workspaceDetailsSidebarAssignToSelect=getElementLocator(prop.getProperty("workspace.details.sidebar.assign.users.role.select"));

	By workspaceDetailsSidebarAddUserTitle=getElementLocator(prop.getProperty("workspace.details.sidebar.assign.users.title"));
	By workspaceDetailsSidebarAddUserCross=getElementLocator(prop.getProperty("workspace.details.sidebar.assign.users.cross"));
	By workspaceDetailsSidebarAddUserLabel=getElementLocator(prop.getProperty("workspace.details.sidebar.assign.users.Userlabel"));
	By workspaceDetailsSidebarAddUserSearchField=getElementLocator(prop.getProperty("workspace.details.sidebar.assign.users.searchfield"));
	By workspaceDetailsSidebarAddUserLoadMore=getElementLocator(prop.getProperty("workspace.details.sidebar.assign.users.loadmore"));
	By workspaceDetailsSidebarAddUserCancelButton=getElementLocator(prop.getProperty("workspace.details.sidebar.assign.users.cancelButton"));
	By workspaceDetailsSidebarAddUserAssignButton=getElementLocator(prop.getProperty("workspace.details.sidebar.assign.users.addbutton"));
	By workspaceDetailsSidebarAddUserListCount=getElementLocator(prop.getProperty("workspace.details.sidebar.assign.users.listcount"));

	By workspaceDetailsSidebarSelectGroupLabel=getElementLocator(prop.getProperty("workspace.details.sidebar.assign.group.grouplabel"));
	By workspaceDetailsSidebarSelectGroupField=getElementLocator(prop.getProperty("workspace.details.sidebar.assign.group.searchfield"));

	By workspacesListingButtonsCount=getElementLocator(prop.getProperty("button.count.listing.workspaces"));
	By workspacesDetailsBeforeCreateButtonsCount=getElementLocator(prop.getProperty("button.count.details.workspaces"));
	/** ----------------------  String variables ---------------------------------- **/

	String moduleTab=prop.getProperty("nextgen.hamberger.tab");
	String subModuleTab=prop.getProperty("nextgenmodule.submodule.tab");
	String subModuleHeadingName=prop.getProperty("nextgenmodule.submodule.headingDynamic");
	String dynamicName=prop.getProperty("DynName");
	String dynamicAccountName="$account";
	String nextgenSubModuleDynamic=prop.getProperty("nextgenmodule.submodule.dynamic");
	String workspaceListingWorkspaceAvatar=prop.getProperty("workspace.listing.dynamic.name.avatar");
	String workspaceListingWorkspaceName=prop.getProperty("workspace.listing.dynamic.name");
	String workspaceListingWorkspaceNameWithAccount=prop.getProperty("workspace.listing.dynamic.name.withaccount");
	String workspaceListingWorkspaceDesc=prop.getProperty("workspace.listing.dynamic.description");
	String workspaceListingWorkspaceAccount=prop.getProperty("workspace.listing.dynamic.account");
	String workspaceListingWorkspaceUpdatedBy=prop.getProperty("workspace.listing.dynamic.updatedby");
	String workspaceListingWorkspaceUpdateddate=prop.getProperty("workspace.listing.dynamic.updateddate");

	String workspaceDetailsBreadcrumbName=prop.getProperty("workspace.details.breadcrumb.dynamic.workspaceName");
	String workspaceDetailsPageTitle=prop.getProperty("workspace.details.dynamic.page.title");
	String workspaceDetailsPageAvatar=prop.getProperty("workspace.details.dynamic.page.avatar");

	String workspaceDetailsAccountselectDynamic=prop.getProperty("workspace.details.account.select.dynamic");

	String workspaceDetailsUserNameDynamic=prop.getProperty("workspace.details.users.namedynamic");
	String workspaceDetailsUserNameCheckbox=prop.getProperty("workspace.details.users.checkbox.namedynamic");
	String workspaceDetailsUserNameAvatar=prop.getProperty("workspace.details.users.name.avatar");
	String workspaceDetailsUserNameAdminIcon=prop.getProperty("workspace.details.users.nameAdminIcondynamic");
	String workspaceDetailsUserNameType=prop.getProperty("workspace.details.users.name.type");
	String workspaceDetailsGroupNameType=prop.getProperty("workspace.details.groups.name.type");
	String workspaceDetailsUserNameRole=prop.getProperty("workspace.details.users.name.role.dynamic");
	String workspaceDetailsUserNameScope=prop.getProperty("workspace.details.users.name.scope.dynamic");

	String placeholderSearchAccount=prop.getProperty("placeholder.search.account");
	String placeholderSearchWorkspace=prop.getProperty("placeholder.search.workspace");
	String placeholderSearchUserGroup=prop.getProperty("placeholder.search.usergroup");
	String placeholderEnterWorkspaceName=prop.getProperty("placeholder.enterworkspacename");
	String placeholderEnterDescription=prop.getProperty("placeholder.enterdescription");
	String placeholderSearchUser=prop.getProperty("placeholder.search.user");
	String placeholderSelectGroups=prop.getProperty("placehloder.select.groups");

	String fieldEmptyWorkspaceName=prop.getProperty("field.empty.workspace.name");

	String toastMessageWorkspaceCreated=prop.getProperty("toast.message.workspace.created");

	String popupDiscardWorkspaceTitle=prop.getProperty("workspace.title.single.discardworkspace");
	String popupDiscardWorkspaceContent=prop.getProperty("workspace.content.single.discardworkspace");	

	String popupDiscardUserGroupDeleteTitle=prop.getProperty("workspace.title.single.UserGroupDelete");
	String popupDiscardUserGroupDeleteContent=prop.getProperty("workspace.content.single.UserGroupDelete");
	String popupDiscardMultiUserGroupDeleteContent=prop.getProperty("workspace.content.multiple.UserGroupDelete");

	String workspaceDetailsSidebarRoleDynamic=prop.getProperty("workspace.details.sidebar.assign.users.role.dynamic");
	String workspaceDetailsSidebarAssignToDynamic=prop.getProperty("workspace.details.sidebar.assign.access.to.select.dynamic");

	String workspaceDetailsSidebarFullNameDynamic=prop.getProperty("workspace.details.sidebar.assign.users.fullnamedynamic");
	String workspaceDetailsSidebarFullNameCheckboxDynamic=prop.getProperty("workspace.details.sidebar.assign.users.fullnamecheckboxdynamic");

	String workspaceDetailsSidebarSelectGroup=prop.getProperty("workspace.details.sidebar.assign.group.select");
	/** ----------------------  String values ---------------------------------- **/

	String refreshContent=prop.getProperty("string.refreshContent");
	String attributeClass=prop.getProperty("string.attributeClass");
	String attrcheck=prop.getProperty("string.attrcheck");
	String attrUncheck=prop.getProperty("string.attrUncheck");
	String attributeValue=prop.getProperty("string.attributeValue");
	String attributeTextContent=prop.getProperty("string.attributeTextContent");
	String attributeTitle=prop.getProperty("string.attributeTitle");
	String attributePlaceholder=prop.getProperty("string.attributePlaceholder");
	String attributeAriaLabel=prop.getProperty("string.attributeAriaLabel");
	String disableContent=prop.getProperty("string.disableContent");
	String descriptionContent=prop.getProperty("string.descriptionContent");
	String copyContent=prop.getProperty("string.copyContent");
	String moveContent=prop.getProperty("string.moveContent");
	String deleteContent=prop.getProperty("string.deleteContent");
	String advanceSearchContent=prop.getProperty("string.AdvanceSearchContent");
	String executorContent=prop.getProperty("string.executorContent");
	String readerContent=prop.getProperty("string.readerContent");
	String ownerContent=prop.getProperty("string.ownerContent");
	String contributorContent=prop.getProperty("string.contributorContent");
	String saveContent=prop.getProperty("string.saveContent");
	String duplicateContent=prop.getProperty("string.duplicate");
	String checkContent=prop.getProperty("string.attrcheck");
	String uncheckContent=prop.getProperty("string.attrUncheck");
	String errorLogTitle=prop.getProperty("string.Error.Log.Title");
	String regexToRemoveBracess=prop.getProperty("regex.bracess");
	String scrollToElementArg=prop.getProperty("ScrollToElementArgument");
	String searchBoxLabel=prop.getProperty("string.searchBox");
	String discardContent=prop.getProperty("string.discardContent");
	String cancelButtonContent=prop.getProperty("string.cancelButtonContent");
	String administrationContent=prop.getProperty("String.administrationContent");
	String dataTestingContent=prop.getProperty("String.dataTestingContent");
	String schedulerContent=prop.getProperty("String.schedulerContent");
	String connectionsContent=prop.getProperty("String.connectionsContent");
	String connectorsContent=prop.getProperty("String.connectorsContent");
	String groupsContent=prop.getProperty("String.groupsContent");
	String usersContent=prop.getProperty("String.usersContent");
	String accountsContent=prop.getProperty("String.accountsContent");
	String workspacesContent=prop.getProperty("String.workspacesContent");
	String rolesContent=prop.getProperty("String.rolesContent");
	String fedetationsContent=prop.getProperty("String.fedetationsContent");
	String identityProvidersContent=prop.getProperty("String.identityProvidersContent");
	String vaultContent=prop.getProperty("String.vaultContent");
	String fieldContent=prop.getProperty("String.fieldContent");
	String calendarsContent=prop.getProperty("String.calendarsContent");
	String settingsContent=prop.getProperty("String.settingsContent");
	String integrationsContent=prop.getProperty("String.integrationsContent");
	String librariesContent=prop.getProperty("String.librariesContent");
	String createNewWorkspaceContent="Create New Workspace";
	String moduleContent=prop.getProperty("String.moduleContent");
	String subModuleContent=prop.getProperty("String.subModuleContent");
	String columnContent=prop.getProperty("String.columnContent");
	String tabContent=prop.getProperty("String.tabContent");
	String iconContent=prop.getProperty("String.iconContent");
	String newWorkspaceContent="New Workspace";
	String hyperlinkContent=prop.getProperty("String.hyperlinkContent");
	String labelContent=prop.getProperty("String.labelContent");
	String masterContent=prop.getProperty("String.masterContent");
	String checkboxContent=prop.getProperty("String.checkboxContent");
	String adminContent=prop.getProperty("String.adminContent");
	String noRecordsToDisplayContent=prop.getProperty("String.noRecordsToDisplayContent");
	String assignAdminAccessContent=prop.getProperty("String.assignAdminAccessContent");
	String revokeAdminAccessContent=prop.getProperty("String.revokeAdminAccessContent");
	String groupNameContent=prop.getProperty("String.groupNameContent");
	String groupContent=prop.getProperty("String.groupContent");
	String scopeContent=prop.getProperty("string.scopeContent");
	String roleContent=prop.getProperty("String.roleContent");
	String typeContent=prop.getProperty("String.typeContent");
	String avatarContent=prop.getProperty("String.avatarContent");
	String adminsContent=prop.getProperty("String.adminsContent");
	String hyphenContent=prop.getProperty("String.hyphenContent");
	String breadcrumbContent=prop.getProperty("String.breadcrumbContent");
	String homeContent=prop.getProperty("String.homeContent");

	String dashboardandReportingContent="Dashboard";
	String verifyingContent=" Verifying ";
	String userProfileContent="User Profile";
	String icedqLogoContent="iceDQ logo";
	String accountContent="Account";
	String workspaceNameContent="Workspace Name";
	String dynamicType="$type";
	String usersGroupsContent="users/groups";
	String dataContent="Data ";
	String workspaceContent=" Workspace";
	String isVisibleContent=" is visible ";
	String assignContent="Assign";
	String selectGroupContent="Select Group";
	public static final String WORKSPACENAMETOSEARCH="Automation_Testing_DND";/**PageUtil.getWorkspaceName("");*/
	/** ----------------------  Generic methods ---------------------------------- **/

	public boolean validateElement(By locator, String label, String type) {
		return validateElement(driver, locator, label, type);

	}

	public boolean verifySearchField(By locator, String label, String placeHolder) {
		boolean flag =true;
		try {
			BaseSuite.reportLog(hyphenContent+" Verifying  "+label+" "+hyphenContent);

			isDisplayedInLoop(driver, 2, locator);
			if(isDisplayed(driver, locator)) {

				BaseSuite.validationReportLog(label+isVisibleContent);

				isClickable(driver, locator, label, true);

				String acph = getAttribute(driver, locator, attributePlaceholder);

				BaseSuite.reportLog(verifyingContent+label+" placeholder");

				flag=stringContainsOutput(acph, placeHolder, true);

			}else {
				BaseSuite.reportFailLog(label+" field not visible ", "verifySearchField");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" verifySearchField :: "+e.toString());
		}
		return flag;
	}

	public void handleDiscardWindow() {
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if (isDisplayed(driver, workspaceDiscardHandle, 2)) {
				clickOnButton(driver, workspaceDiscardHandle, discardContent, true);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" handleDiscardWindow :: "+e.toString());

		}
	}

	public void verifyPlaceHolderValue(By fieldLocator ,String label, String placeHolder) {

		if(!placeHolder.isEmpty()) {

			String ph = getAttribute(driver, fieldLocator, attributePlaceholder);

			if (!ph.isEmpty() && ph.equalsIgnoreCase(placeHolder)) {

				BaseSuite.reportLog(label+" field place holder : " + ph);

			} else {

				BaseSuite.reportFailLog(label+" field place holder not found : Actual :"+ph+" and Expected : "+placeHolder,
						" verifyPlaceHolderValue");
			}
		}
	}

	public boolean searchFunctionalityMethod(boolean flag, By searchbar, By searchButton,String searchLabel, String placeholder, String searchValue ) {
		String methodName = "searchFunctionalityMethod";

		try {
			if(flag) {
				isDisplayedInLoop(driver, 2, searchbar);

				if(isDisplayed(driver, searchbar)) {

					flag=isClickable(driver, searchbar,searchBoxLabel, flag);

					if(flag) {

						flag=verifySearchField(searchbar, searchLabel, placeholder);

						flag=enterValueToField(driver,flag, searchbar, searchButton, searchLabel, searchValue);

					}else {
						BaseSuite.reportFailLog(searchLabel+" field not clickable ", methodName);
						flag=false;
					}
				}else {
					BaseSuite.reportFailLog(searchLabel+" box not displayed ", methodName);
					flag=false;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+methodName+" :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean searchWorkspaceNameOnEachPageAndClickOn(By locator,String name) {

		boolean flag=true;
		boolean nextpageFlag=true;
		int pn=0;

		try {

			do {

				BaseSuite.reportLog("searching workspace name : "+name+" on page number :"+(pn+1));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 2, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportLog("workspace name : "+name+" found on page number :"+(pn+1));

					flag=clickOnButton(driver, locator, name, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					break;
				}
				if(isDisplayed(driver, workspaceListingNextPageArrow)) {

					String status = getAttribute(driver, workspaceListingNextPageArrow, attributeClass);

					if (!status.contains("disable")) {

						BaseSuite.reportLog("searched workspace name : "+name+" not found on page number :"+(pn+1));

						clickOnButton(driver, workspaceListingNextPageArrow, "next page", true);
						pn++;
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					} else {
						BaseSuite.reportLog("Page arrow :: next page is disabled");
						nextpageFlag=false;
						flag=false;
					}

				}

			}while(nextpageFlag);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchWorkspaceNameOnEachPageAndClickOn :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public void getTableForTestScenario(List<String> list) {
		WorkflowPage wp = new WorkflowPage(driver);
		try {

			String [][] table = new String[list.size()+1][4];

			String [] header = {"No.","Test Scenario name", "Execution Status"};

			table[0] = header;

			for(int i =0;i<list.size();i++) {

				String num=Integer.toString(i+1);

				String tscenario = list.get(i).split(",")[0];

				String tstatus = list.get(i).split(",")[1];

				String [] data = {num, tscenario,tstatus};

				table[i+1] = data;

			}
			BaseSuite.reportLog(wp.createHtmlTable1(table,"Test Scenarios"));

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" getTableForTestScenario :: "+e.toString());
		}
	}

	public boolean checkFieldEnabledOrNot(boolean state, By locator, String label) {

		if(state) {
			if(isEnabled(driver, locator) ) {

				BaseSuite.validationReportLog(label+" is enabled as expected");
			}else {
				BaseSuite.reportFailLog(label+" is disabled and expected is enabled", "checkFieldEnabledOrNot");

			}
		}else {
			if(!isEnabled(driver, locator) ) {
				BaseSuite.validationReportLog(label+" is disabled as expected");
			}else {
				BaseSuite.reportFailLog(label+" is enabled and expected is disabled", "checkFieldEnabledOrNot");

			}
		}
		return state;
	}

	public boolean viewAndValidateField(By locator, String label, String expectedValue, boolean state) {

		boolean flag = true;
		String methodName="viewAndValidateField";
		try {
			isDisplayedInLoop(driver, 10, locator);

			javascript(driver, scrollToElementArg, locator);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, locator)) {			

				checkFieldEnabledOrNot(state, locator, label);

				checkExpectedValueWithActual(driver,flag, locator, label,expectedValue,true);

			}else {
				BaseSuite.reportFailLog(label+" not visible  ", methodName);
				flag=false;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateElementVisibility(By locator, String label, String type, boolean state) {

		return validateElementVisibility(driver, locator, label, type, state);

	}

	public String validationMessageOfField(By locator,String label, String expected, boolean state) {

		String valMsg = null;
		isDisplayedInLoop(driver, 1, locator);

		try {
			if(!expected.isEmpty()) {
				javascript(driver, scrollToElementArg, locator);

				valMsg = getText(driver, locator);

				if(!valMsg.isEmpty()) {

					if(state) {

						BaseSuite.reportLog("Expected Value:- "+expected);

						BaseSuite.reportLog("Actual Value:- "+valMsg);

						validateMessage(valMsg, expected, label);

					} else {

						validateMessage(valMsg, expected, label);
					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return valMsg;
	}

	public boolean validatAndeEnterValueToTextField(By labelLocator, By fieldLocator,By fieldValidLocator, String label, String placeHolder, String input, String fieldValidation) throws NoSuchElementException {
		boolean flag =true;
		try {
			isDisplayedInLoop(driver, 4, labelLocator);

			javascript(driver, scrollToElementArg, labelLocator);

			verifyIndividualLabel(driver, labelLocator, label);

			if (isDisplayed(driver, fieldLocator)) {

				isClickable(driver, fieldLocator,label, true);

				verifyPlaceHolderValue(fieldLocator, label, placeHolder);

				if(input==null) {
					input="";
				}
				if(!input.isEmpty()) {	
					waitForExecution(500);
					click(driver, fieldLocator);

					clear(driver, fieldLocator);

					validationMessageOfField(fieldValidLocator, label, fieldValidation, true);

					BaseSuite.reportLog("Entering value : " + input);

					sendKeys(driver, fieldLocator, input);

					String ac = getAttribute(driver, fieldLocator, attributeValue);

					flag = stringContainsOutput(ac, input, true);

					validationMessageOfField(fieldValidLocator, label, fieldValidation, false);
				}
			} else {
				flag=false;
				BaseSuite.reportFailLog(label+" field not displayed", "validatAndeEnterValueToTextField");
			}
		} catch (Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" validatAndeEnterValueToTextField : " + e.getMessage());
			flag=false;
		}

		return flag;
	}

	public boolean validateValueWithActual(By locator,String label,  String expected, String attribute) {

		boolean flag=true;

		try {
			if(!expected.isEmpty()) {
				BaseSuite.reportLog("verifying "+label+" with expected value");	
				if(isDisplayed(driver, locator)) {

					String actualValue=getAttribute(driver, locator, attribute);

					flag=stringOutput(actualValue, expected, flag);
				}else {
					BaseSuite.reportFailLog(label+" is not visible", "validateValueWithActual");

				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateValueWithActual :: "+e.toString());
			flag=false;
		}


		return flag;
	}

	public boolean validatePopupWindowContent(boolean flag, By titleLocator, By contentLocator, String title, String content) {

		if(flag) {
			String removetitle = getText(driver, titleLocator);

			flag = stringContainsOutput(removetitle, title, true);

			if(flag) {

				String removecontents = getText(driver, contentLocator);

				flag = stringContainsOutput(removecontents, content, true);

			}
		}
		return flag;
	}

	public boolean selectcheckbox(By locator, String label) {
		boolean flag=true;
		isDisplayedInLoop(driver, 10, locator);

		if(isDisplayed(driver, locator)) {

			String acs=getAttribute(driver,locator, attributeClass);

			if(!acs.contains(checkContent) || acs.contains(uncheckContent)) {

				BaseSuite.reportLog(" Clicking on checkbox "+label);

				isDisplayedInLoop(driver, 10, locator);

				displayAndClick(driver, locator);

				BaseSuite.validationReportLog(label+" checkbox is selected");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}else {
				BaseSuite.reportLog(label+" type is checkbox already selected");
				flag=false;
			}
		}else {
			BaseSuite.reportFailLog("Checkbox not visible for "+label, "selectcheckbox");
			flag=false;
		}
		return flag;
	}

	/** ----------------------  Main methods ---------------------------------- **/

	public void navigateToAdministrationTabs(By linklocator, By validateLocator, String label, String type) {

		navigateToLink(driver,linklocator, validateLocator, label+" "+type);

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		clickOnWorkspacesTab();

	}

	public static DataTestingParameters setAssignToParamUsingExcel(String filePath, String user) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String userNameColumn="selectname";
		String usersheet="AssignAccessTo";
		try {

			param.setUserName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"selectname"));
			param.setFirstName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"FirstName"));
			param.setLastName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"LastName"));
			param.setRole(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"role"));
			param.setScope(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"scope"));
			param.setAssignTo(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"assignTo"));


		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setUsersParamUsingExcel "+e.toString());
		}
		return param;

	}


	public static DataTestingParameters setUsersParamUsingExcel(String filePath, String user) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String userNameColumn="UserName";
		String usersheet="UserSheet";
		try {

			param.setUserName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"UserName"));
			param.setFirstName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"FirstName"));
			param.setLastName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"LastName"));
			param.setRole(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"UserRole"));
			param.setScope(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"UserScope"));
			param.setAdminFlag(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"AdminFlag"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setUsersParamUsingExcel "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setGroupsParamUsingExcel(String filePath, String user) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String userNameColumn="GroupName";
		String usersheet="GroupsSheet";
		try {

			param.setGroupName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"GroupName"));
			param.setRole(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"GroupRole"));
			param.setScope(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"GroupScope"));
			param.setAdminFlag(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"AdminFlag"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setGroupsParamUsingExcel "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setWorkspaceServiceParamUsingExcel(String filePath, String sheetName, int rowNumber) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();

		try {

			param.setTestScenarioName(xl.readUsingColName(filePath,sheetName, rowNumber, "testScenario"));
			param.setScenarioType(xl.readUsingColName(filePath,sheetName, rowNumber, "scenarioType"));
			param.setDescription(xl.readUsingColName(filePath,sheetName, rowNumber, "workspaceDescription"));
			param.setAddUser(xl.readUsingColName(filePath,sheetName, rowNumber, "addUser"));
			param.setRemoveUser(xl.readUsingColName(filePath,sheetName, rowNumber, "removeUser"));
			param.setAddGroup(xl.readUsingColName(filePath,sheetName, rowNumber, "addGroup"));
			param.setRemoveGroup(xl.readUsingColName(filePath,sheetName, rowNumber, "removeGroup"));
			param.setSearchWorkspaceName(xl.readUsingColName(filePath,sheetName, rowNumber, "searchWorkspace"));
			param.setUpdateWorkspaceName(xl.readUsingColName(filePath,sheetName, rowNumber, "updateWorkspaceName"));
			param.setUpdateWorkspaceDescription(xl.readUsingColName(filePath,sheetName, rowNumber, "updateWorkspaceDescription"));
			/**	param.setAccountName(xl.readUsingColName(filePath,sheetName, rowNumber, "accountName"));*/
			param.setAccountName(BaseSuite.accountName);
			param.setWorkspaceName(xl.readUsingColName(filePath,sheetName, rowNumber, "workspaceName"));
			param.setWorkspaceType(xl.readUsingColName(filePath,sheetName, rowNumber, "WorkspaceType"));
			param.setFieldValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber, "fieldValidation"));
			param.setToastValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber, "toastValidation"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setGroupsServiceParamUsingExcel "+e.toString());
		}
		return param;

	}

	public boolean clickOnRefreshOnWorkspacesListingPage() {

		return clickOnButton(driver, workspaceListingRefreshIcon, refreshContent, true);
	}

	public boolean clickOnRefreshOnWorkspacesListingPageWithValidation() {
		boolean flag=true;

		clickOnButton(driver, workspaceListingRefreshIcon, refreshContent, true);

		waitForExecution(100);

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		if(isDisplayed(driver, toastMsg)) {
			flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
					"Workspaces tab refresh authorization message");
		}

		return flag;
	}

	public String getWorkspaceIdOnWorkspaceDetailsPage() {
		String id =null;
		try {
			isDisplayedInLoop(driver, 3, workspaceDetailsBreadcrumbWorkspaceId);

			if(isDisplayed(driver, workspaceDetailsBreadcrumbWorkspaceId)) {

				id = getText(driver, workspaceDetailsBreadcrumbWorkspaceId);

				id = id.replaceAll(regexToRemoveBracess, "");

				BaseSuite.reportLog("Workspace id is :: "+id);
			}else {
				BaseSuite.reportFailLog("Workspace id is not visible ", "getWorkspaceIdOnWorkspaceDetailsPage");

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" getWorkspaceIdOnWorkspaceDetailsPage :: "+e.toString());

		}
		return id;
	}

	public boolean validateWorkspacesListingPage() {
		boolean flag=true;
		HomePage hp=new HomePage(driver);

		try {
			hp.validateNextgenIcedqModuleAndAdministrationSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Workspaces listing page "+hyphenContent);

			validateElement(workspaceBreadcrumbHomeLink, homeContent, hyperlinkContent);

			validateElement(workspaceBreadcrumbAdminLink, administrationContent, hyperlinkContent);

			validateElement(workspaceBreadcrumbWorkspacesLabel, workspacesContent, labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying Title and Search field workspaces listing page "+hyphenContent);

			verifyIndividualLabel(driver, workspacePageTitle, workspacesContent);

			verifySearchField(workspaceListingSearchField, placeholderSearchWorkspace, placeholderSearchWorkspace);

			validateElement(workspaceListingSearchButton, placeholderSearchWorkspace, "button");

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Workspaces listing page "+hyphenContent);

			validateButtons(driver, workspacesListingButtonsCount, 2);

			verifyVisibilityOfButtons(driver, workspaceListingNewWorkspaceButton, newWorkspaceContent, true);
			verifyVisibilityOfButtons(driver, workspaceListingRefreshIcon, refreshContent, true);

			BaseSuite.reportLog(hyphenContent+"  Verifying Columns on Workspaces listing page "+hyphenContent);

			validateElement(workspaceListingColumnName, "Name",columnContent);
			validateElement(workspaceListingColumnDescription, descriptionContent, columnContent);
			validateElement(workspaceListingColumnAccount, accountContent, columnContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on Workspaces listing page "+hyphenContent);

			getPaginationDetails(driver,workspaceListingPaginationMsg, workspaceListingPaginationBar,workspaceListingNoRecordsToDisplay, "Workspaces listing page");

			BaseSuite.validationReportLog(hyphenContent+" Workspaces listing page validated successfully "+hyphenContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateWorkspacesListingPage :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean clickOnWorkspacesTab() {

		boolean flag = false;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, workspaceListingNewWorkspaceButton);

			if(isDisplayed(driver, workspaceDetailsSidebarAddUserCancelButton)) { clickOnButton(driver, workspaceDetailsSidebarAddUserCancelButton, cancelButtonContent, true);}

			if(!isDisplayed(driver, workspaceListingNewWorkspaceButton)) {

				isDisplayedInLoop(driver, 2, nextgenSubModuleWorkspaces);

				if(isDisplayed(driver, nextgenSubModuleWorkspaces)) {

					flag = isClickable(driver, nextgenSubModuleWorkspaces, workspacesContent+" tab", true);

					if(flag) {

						BaseSuite.reportLog("Clicking on "+workspacesContent+" tab");

						displayAndClick(driver, nextgenSubModuleWorkspaces);

						handleDiscardWindow();

						BaseSuite.validationReportLog("Clicked on "+workspacesContent+" tab");

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

						flag=validateElement(workspacePageTitle, workspacesContent, attributeTitle);

						clickOnButton(driver, workspaceListingRefreshIcon, refreshContent, true);

					}

				}else {
					BaseSuite.reportFailLog(workspacesContent+" tab not visible", "clickOnWorkspacesTab");
				}
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnWorkspacesTab :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean clickOnWorkspacesTab(String expectedToastMessage) {

		boolean flag = false;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, workspaceListingNewWorkspaceButton);

			if(elementNotVisible(driver, workspaceListingNewWorkspaceButton)) {

				isDisplayedInLoop(driver, 2, nextgenSubModuleWorkspaces);

				if(isDisplayed(driver, nextgenSubModuleWorkspaces)) {

					flag = isClickable(driver, nextgenSubModuleWorkspaces, workspacesContent+" tab", true);

					if(flag) {

						BaseSuite.reportLog("Clicking on "+workspacesContent+" tab");

						displayAndClick(driver, nextgenSubModuleWorkspaces);

						/**handleDiscardWindow();**/
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.validationReportLog("Clicked on "+workspacesContent+" tab");

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

						captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,
								"Workspaces tab authorization message");

						validateElement(workspacePageTitle, workspacesContent, attributeTitle);

						clickOnButton(driver, workspaceListingRefreshIcon, refreshContent, true);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						flag = captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,
								"Workspaces tab authorization message");

					}

				}else {
					BaseSuite.reportFailLog(workspacesContent+" tab not visible", "clickOnWorkspacesTab");
				}
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnWorkspacesTab :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean clickOnNewWorkspaceButton(String icedqUser) {

		boolean flag = true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, workspaceListingNewWorkspaceButton);

			if(isDisplayed(driver, workspaceListingNewWorkspaceButton)) {

				clickOnButton(driver, workspaceListingNewWorkspaceButton, newWorkspaceContent, flag);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER)  || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_CONTRIBUTORUSER)) {

					String pgTitle=getAttribute(driver, returnElement(workspaceDetailsPageTitle, dynamicName, createNewWorkspaceContent), attributeTextContent);

					flag = stringOutput(pgTitle.trim(), createNewWorkspaceContent, true);

				}else{

					flag = captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
							"New Workspace authorization message");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnNewWorkspaceButton :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnSaveButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {
			clickOnButton(driver, workspaceDetailsSaveButton, saveContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Workspace Created");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Workspace Created");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnSaveButtonAndValidateToast :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean clickOnDiscardWorkspaceButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {

			clickOnButton(driver, workspaceDetailsDiscardButton, discardContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validatePopupWindowContent(flag, workspaceDetailsPopupDiscardTitle, workspaceDetailsPopupDiscardContent, popupDiscardWorkspaceTitle, popupDiscardWorkspaceContent);

			verifyVisibilityOfButtons(driver, workspaceDetailsPopupDiscardButton, discardContent, true);
			verifyVisibilityOfButtons(driver, workspaceDetailsPopupDiscardCancelButton, cancelButtonContent, true);

			clickOnButton(driver, workspaceDetailsPopupDiscardButton, discardContent, tag);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, workspaceContent+" "+discardContent);
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,workspaceContent+" "+discardContent);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnDiscardWorkspaceButtonAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnAssignButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {
			clickOnButton(driver, workspaceDetailsUserGroupTabAssignButton, assignContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Assign access");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Assign access");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnAssignButtonAndValidateToast :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean clickOnDeleteUserGroupButtonFromWorkspaceAndValidateToast(boolean flag,int num, String expectedToastMessage) {
		boolean tag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(1000);

			if(num==1) {
				validatePopupWindowContent(flag, workspaceDetailsUserGroupPopupDeleteTitle, workspaceDetailsUserGroupPopupDeleteContent, popupDiscardUserGroupDeleteTitle, popupDiscardUserGroupDeleteContent);
			}else if(num>1){
				validatePopupWindowContent(flag, workspaceDetailsUserGroupPopupDeleteTitle, workspaceDetailsUserGroupPopupDeleteContent, popupDiscardUserGroupDeleteTitle, popupDiscardMultiUserGroupDeleteContent);
			}
			verifyVisibilityOfButtons(driver, workspaceDetailsUserGroupPopupDeleteButton, deleteContent, true);
			verifyVisibilityOfButtons(driver, workspaceDetailsUserGroupPopupDeleteCancelButton, cancelButtonContent, true);

			clickOnButton(driver, workspaceDetailsUserGroupPopupDeleteButton, deleteContent, tag);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, assignContent+deleteContent);
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,assignContent+deleteContent);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnDeleteUserGroupButtonFromWorkspaceAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateWorkspacesDetailPageBeforeCreating() {
		boolean flag = true;
		HomePage hp=new HomePage(driver);
		try {
			hp.validateNextgenIcedqModuleAndAdministrationSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Workspaces details page "+hyphenContent);

			validateElement(workspaceBreadcrumbHomeLink, homeContent, hyperlinkContent);

			validateElement(workspaceBreadcrumbAdminLink, administrationContent, hyperlinkContent);

			validateElement(workspaceBreadcrumbWorkspaceLink, workspacesContent, hyperlinkContent);

			validateElement(workspaceDetailsBreadcrumbCreateNewWorkspace, createNewWorkspaceContent, labelContent);

			validateElement(returnElement(workspaceDetailsPageTitle, dynamicName, createNewWorkspaceContent), createNewWorkspaceContent, attributeTitle);

			validateElement(returnTwoElements(workspaceDetailsPageAvatar, dynamicName, createNewWorkspaceContent,dynamicType,dataTestingContent), dataTestingContent, iconContent);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Workspaces details page "+hyphenContent);

			validateButtons(driver, workspacesDetailsBeforeCreateButtonsCount, 5);

			verifyVisibilityOfButtons(driver, workspaceDetailsSaveButton, saveContent, false);
			verifyVisibilityOfButtons(driver, workspaceDetailsDiscardButton, discardContent, false);	
			verifyVisibilityOfButtons(driver, workspaceDetailsUserGroupTabAssignButton, assignContent, false);
			verifyVisibilityOfButtons(driver, workspaceDetailsUserGroupTabRefreshButton, refreshContent+" "+usersGroupsContent, false);
			verifyVisibilityOfButtons(driver, workspaceDetailsUserGroupTabDeleteButton, deleteContent+" "+usersGroupsContent, false);

			validateElement(workspaceDetailsAccountLabel, accountContent, labelContent);
			validateElement(workspaceDetailsAccountField, accountContent, fieldContent);
			verifyPlaceHolderValue(workspaceDetailsAccountField, accountContent, placeholderSearchAccount);

			validateElement(workspaceDetailsNameLabel, workspaceNameContent, labelContent);
			validateElement(workspaceDetailsNameField, workspaceNameContent, fieldContent);
			verifyPlaceHolderValue(workspaceDetailsNameField, workspaceNameContent, placeholderEnterWorkspaceName);

			validateElement(workspaceDetailsDescLabel, descriptionContent, labelContent);
			validateElement(workspaceDetailsDescField, descriptionContent, fieldContent);
			verifyPlaceHolderValue(workspaceDetailsDescField, descriptionContent, placeholderEnterDescription);

			validateElement(workspaceDetailsTypeLabel, typeContent, labelContent);
			validateElement(workspaceDetailsTypeField, typeContent, fieldContent);
			viewAndValidateField(workspaceDetailsTypeField, typeContent, "Testing", isrelease5Flag);

			BaseSuite.reportLog(hyphenContent+" Verifying tabs on Workspaces details page "+hyphenContent);

			validateElement(workspaceDetailsUserGroupTab, usersGroupsContent, tabContent);
			/**	validateElement(workspaceDetailsPreferencesTab, "Preferences", tabContent);*/

			verifySearchField(workspaceDetailsUserGroupTabSearchField, placeholderSearchUserGroup, placeholderSearchUserGroup);

			validateElement(workspaceDetailsUserGroupTabSearchButton, placeholderSearchUserGroup, iconContent);

			BaseSuite.reportLog(hyphenContent+" Verifying columns of users/groups tab "+hyphenContent);

			validateElement(workspaceDetailsUserGroupTabMasterCheckbox, masterContent, checkboxContent);
			validateElement(workspaceDetailsUserGroupTabColumnName, "Name", columnContent);
			validateElement(workspaceDetailsUserGroupTabColumnType, "Type", columnContent);
			validateElement(workspaceDetailsUserGroupTabColumnRole, "Role", columnContent);
			validateElement(workspaceDetailsUserGroupTabColumnScope, "Scope", columnContent);

			validateElement(workspaceDetailsUserGroupTabNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on users/groups tab "+hyphenContent);

			getPaginationDetails(driver,workspaceDetailsUserGroupTabPaginationMsg, workspaceDetailsUserGroupTabPaginationBar,workspaceDetailsUserGroupTabNoRecordsToDisplay, "Users/Groups tab");

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateWorkspacesDetailPageBeforeCreating :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean searchWorkspace(String workspaceName) {
		boolean flag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=searchFunctionalityMethod(flag, workspaceListingSearchField, workspaceListingSearchButton, placeholderSearchWorkspace, placeholderSearchWorkspace, workspaceName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && isDisplayed(driver, workspaceListingNoRecordsToDisplay)) {

				flag=false;

			}else {
				flag=true;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchWorkspace "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickonWorkspace(String workspaceName) {
		boolean flag =true;

		try {

			/**flag=searchWorkspaceNameOnEachPageAndClickOn(returnElement(workspaceListingWorkspaceName, dynamicName, workspaceName), workspaceName);*/
			flag=	searchWorkspaceNameOnEachPageAndClickOn(returnTwoElements(workspaceListingWorkspaceNameWithAccount, dynamicAccountName, BaseSuite.accountName, dynamicName, workspaceName), workspaceName);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickonWorkspace "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean updateWorkspaceName(String updatedWorkspaceName) {
		boolean flag =true;

		try {

			String timeStamp =  new SimpleDateFormat(ConstantProperty.CONNECTIONNAME_TIMESTAMPFORMAT).format(new Date());

			String newworkspaceName = updatedWorkspaceName+timeStamp;

			validatAndeEnterValueToTextField(workspaceDetailsNameLabel, workspaceDetailsNameField, workspaceDetailsNameValidation, workspaceNameContent, placeholderEnterWorkspaceName, newworkspaceName, fieldEmptyWorkspaceName);

			flag=clickOnSaveButtonAndValidateToast(true, "");

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickonWorkspace "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean searchWorkspaceAndClickOnName(String workspaceName) {
		boolean flag =true;

		try {

			flag=searchFunctionalityMethod(flag, workspaceListingSearchField, workspaceListingSearchButton, placeholderSearchWorkspace, placeholderSearchWorkspace, workspaceName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && elementNotVisible(driver, workspaceListingNoRecordsToDisplay)) {

				/**flag=searchWorkspaceNameOnEachPageAndClickOn(returnElement(workspaceListingWorkspaceName, dynamicName, workspaceName), workspaceName);*/
				flag=	searchWorkspaceNameOnEachPageAndClickOn(returnTwoElements(workspaceListingWorkspaceNameWithAccount, dynamicAccountName, BaseSuite.accountName, dynamicName, workspaceName), workspaceName);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}else {
				BaseSuite.reportFailLog(noRecordsToDisplayContent+isVisibleContent,"searchWorkspaceAndClickOnName");
				searchFunctionalityMethod(flag, workspaceListingSearchField, workspaceListingSearchButton, placeholderSearchWorkspace, placeholderSearchWorkspace, "");
				return false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchWorkspaceAndClickOnName "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean searchWorkspaceName(String workspaceName) {
		boolean flag =true;

		try {

			flag=searchFunctionalityMethod(flag, workspaceListingSearchField, workspaceListingSearchButton, placeholderSearchWorkspace, placeholderSearchWorkspace, workspaceName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && isDisplayed(driver, returnElement(workspaceListingWorkspaceName, dynamicName, workspaceName))) {

				/**		flag=searchWorkspaceNameOnEachPageAndClickOn(returnElement(workspaceListingWorkspaceName, dynamicName, workspaceName), workspaceName);**/
				BaseSuite.reportLog(workspaceName+" Workspace exist");
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				flag=false;
			}else {
				BaseSuite.reportLog(noRecordsToDisplayContent+isVisibleContent);
				flag=true;
			}
			searchFunctionalityMethod(true, workspaceListingSearchField, workspaceListingSearchButton, placeholderSearchWorkspace, placeholderSearchWorkspace, "");

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchWorkspaceName "+e.toString());
			flag=false;
		}

		return flag;
	}

	public String viewExistingWorkspacesDetailPage(String accountName, String workspaceName, String description, String workspaceType) {

		String totalRecords="";
		HomePage hp=new HomePage(driver);
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			hp.validateNextgenIcedqModuleAndAdministrationSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Workspaces details page "+hyphenContent);

			validateElement(workspaceBreadcrumbHomeLink, homeContent, hyperlinkContent);

			validateElement(workspaceBreadcrumbAdminLink, administrationContent, hyperlinkContent);

			validateElement(workspaceBreadcrumbWorkspaceLink, workspacesContent, hyperlinkContent);

			validateElement(returnElement(workspaceDetailsBreadcrumbName, dynamicName, workspaceName), workspaceName, labelContent);

			getWorkspaceIdOnWorkspaceDetailsPage();

			validateElement(returnTwoElements(workspaceDetailsPageAvatar, dynamicName, workspaceName,dynamicType,dataContent+workspaceType), dataContent+workspaceType, iconContent);

			validateElement(returnElement(workspaceDetailsPageTitle, dynamicName, workspaceName),workspaceName, attributeTitle);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Workspaces details page "+hyphenContent);

			validateButtons(driver, workspacesDetailsBeforeCreateButtonsCount, 5);

			verifyVisibilityOfButtons(driver, workspaceDetailsSaveButton, saveContent, false);
			verifyVisibilityOfButtons(driver, workspaceDetailsDiscardButton, discardContent, false);	
			verifyVisibilityOfButtons(driver, workspaceDetailsUserGroupTabAssignButton, assignContent, true);
			verifyVisibilityOfButtons(driver, workspaceDetailsUserGroupTabRefreshButton, refreshContent+" "+usersGroupsContent, true);
			verifyVisibilityOfButtons(driver, workspaceDetailsUserGroupTabDeleteButton, deleteContent+" "+usersGroupsContent, false);

			validateElement(workspaceDetailsAccountLabel, accountContent, labelContent);
			viewAndValidateField(workspaceDetailsAccountField, accountContent, accountName, false);

			validateElement(workspaceDetailsNameLabel, workspaceNameContent, labelContent);
			viewAndValidateField(workspaceDetailsNameField, workspaceNameContent, workspaceName, true);

			validateElement(workspaceDetailsDescLabel, descriptionContent, labelContent);
			viewAndValidateField(workspaceDetailsDescField, descriptionContent, description, true);

			validateElement(workspaceDetailsTypeLabel, typeContent, labelContent);
			viewAndValidateField(workspaceDetailsTypeField, typeContent, workspaceType, false);

			BaseSuite.reportLog(hyphenContent+" Verifying tabs on Workspaces details page "+hyphenContent);

			validateElement(workspaceDetailsUserGroupTab, usersGroupsContent, tabContent);
			/**		validateElement(workspaceDetailsPreferencesTab, "Preferences", tabContent);*/

			verifySearchField(workspaceDetailsUserGroupTabSearchField, placeholderSearchUserGroup, placeholderSearchUserGroup);

			validateElement(workspaceDetailsUserGroupTabSearchButton, placeholderSearchUserGroup, iconContent);

			BaseSuite.reportLog(hyphenContent+" Verifying columns of users/groups tab "+hyphenContent);

			validateElement(workspaceDetailsUserGroupTabMasterCheckbox, masterContent, checkboxContent);
			validateElement(workspaceDetailsUserGroupTabColumnName, "Name", columnContent);
			validateElement(workspaceDetailsUserGroupTabColumnType, "Type", columnContent);
			validateElement(workspaceDetailsUserGroupTabColumnRole, "Role", columnContent);
			validateElement(workspaceDetailsUserGroupTabColumnScope, "Scope", columnContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on users/groups tab "+hyphenContent);

			List<String> pageInfo=getPaginationDetails(driver,workspaceDetailsUserGroupTabPaginationMsg, workspaceDetailsUserGroupTabPaginationBar,workspaceDetailsUserGroupTabNoRecordsToDisplay, "Users/Groups tab");

			totalRecords=pageInfo.get(1);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewExistingWorkspacesDetailPage :: "+e.toString());

		}
		return totalRecords;
	}

	public boolean searchAndViewAddedUserInWorkspace(boolean flag,String fullName,String role, String scope, boolean adminflag) {

		try {
			BaseSuite.reportLog(hyphenContent+" Validate User details access in workspace :: "+fullName+" "+hyphenContent);

			flag=searchFunctionalityMethod(true, workspaceDetailsUserGroupTabSearchField, workspaceDetailsUserGroupTabSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, fullName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {

				validateElement(returnElement(workspaceDetailsUserNameCheckbox, dynamicName, fullName), fullName, checkboxContent);

				validateElement(returnTwoElements(workspaceDetailsUserNameAvatar, dynamicName, fullName,dynamicType,"User"), fullName, avatarContent);

				validateElement(returnElement(workspaceDetailsUserNameDynamic, dynamicName, fullName), fullName, hyperlinkContent);

				validateElementVisibility(returnElement(workspaceDetailsUserNameAdminIcon, dynamicName, fullName), adminContent, iconContent, adminflag);

				checkExpectedValueWithActual(driver,true,returnElement(workspaceDetailsUserNameType, dynamicName, fullName), fullName+" Type", "User",true);

				checkExpectedValueWithActual(driver,true,returnElement(workspaceDetailsUserNameRole, dynamicName, fullName), fullName+" Role", role,true);

				checkExpectedValueWithActual(driver,true,returnElement(workspaceDetailsUserNameScope, dynamicName, fullName), fullName+" Scope", scope,true);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchAndViewAddedUserInWorkspace "+e.toString());
		}

		return flag;
	}

	public boolean searchAndViewAddedUserInWorkspaceNOUI(boolean flag,String fullName) {

		try {
			BaseSuite.reportLog(hyphenContent+" Validate User details access in workspace :: "+fullName+" "+hyphenContent);

			flag=searchFunctionalityMethod(true, workspaceDetailsUserGroupTabSearchField, workspaceDetailsUserGroupTabSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, fullName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(1000);

			if(flag && elementNotVisible(driver, returnElement(workspaceDetailsUserNameDynamic, dynamicName, fullName))) {

				flag=true;

			}else {
				flag=false;
				BaseSuite.reportLog(hyphenContent+" Already has access in workspace :: "+fullName+" "+hyphenContent);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchAndViewAddedUserInWorkspaceNOUI "+e.toString());
		}

		return flag;
	}

	public boolean viewAddedUserDetails(String userName, boolean adminFlag) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if (!userName.isEmpty()) {

				if (userName.contains(",")) {

					iceuserName = userName.split(",");

					for (int i = 0; i < iceuserName.length; i++) {

						DataTestingParameters param = setUsersParamUsingExcel(wORKSPACEEXCELFILEPATH, iceuserName[i]);

						String fullName = param.getFirstName() + " " + param.getLastName();

						searchAndViewAddedUserInWorkspace(flag, fullName, param.getRole(), param.getScope(), adminFlag);
					}

				} else {

					DataTestingParameters param = setUsersParamUsingExcel(wORKSPACEEXCELFILEPATH, userName);

					String fullName = param.getFirstName() + " " + param.getLastName();

					searchAndViewAddedUserInWorkspace(flag, fullName, param.getRole(), param.getScope(), adminFlag);

				}
				displayAndClick(driver, workspaceDetailsUserGroupTabSearchField);
				displayAndClick(driver, workspaceDetailsUserGroupTabSearchClear);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewAddedUserDetails "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean searchUserForDeletedInWorkspace(boolean flag,String name,String label) {

		try {
			BaseSuite.reportLog(hyphenContent+" Validate "+label+" for deleted from workspace :: "+name+" "+hyphenContent);

			flag=searchFunctionalityMethod(true, workspaceDetailsUserGroupTabSearchField, workspaceDetailsUserGroupTabSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, name);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {

				/**	flag=validateElement(workspaceDetailsUserGroupTabNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);*/

				if(isDisplayed(driver, returnElement(workspaceDetailsUserNameDynamic, dynamicName, name))) {
					flag=false;
					BaseSuite.reportFailLog("Removed user/group from workspace is visible, "+name,"searchUserForDeletedInWorkspace");
				}else {
					BaseSuite.validationReportLog("Removed user/group from workspace is not visible, "+name);
				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchUserForDeletedInWorkspace "+e.toString());
		}

		return flag;
	}

	public boolean searchAndViewAddedGroupInWorkspace(boolean flag,String groupName,String role, String scope, boolean adminflag) {

		try {
			BaseSuite.reportLog(hyphenContent+" Validate group added in workspace :: "+groupName+" "+hyphenContent);

			flag=searchFunctionalityMethod(true, workspaceDetailsUserGroupTabSearchField, workspaceDetailsUserGroupTabSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, groupName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {

				validateElement(returnElement(workspaceDetailsUserNameCheckbox, dynamicName, groupName), groupName, checkboxContent);

				validateElement(returnTwoElements(workspaceDetailsUserNameAvatar, dynamicName, groupName,dynamicType,"Group"), groupName, avatarContent);

				validateElement(returnElement(workspaceDetailsUserNameDynamic, dynamicName, groupName), groupName, hyperlinkContent);

				validateElementVisibility(returnElement(workspaceDetailsUserNameAdminIcon, dynamicName, groupName), adminContent, iconContent, adminflag);

				checkExpectedValueWithActual(driver,true,returnElement(workspaceDetailsGroupNameType, dynamicName, groupName), groupName+" Type", "Group",true);

				checkExpectedValueWithActual(driver,true,returnElement(workspaceDetailsUserNameRole, dynamicName, groupName), groupName+" Role", role,true);

				checkExpectedValueWithActual(driver,true,returnElement(workspaceDetailsUserNameScope, dynamicName, groupName), groupName+" Scope", scope,true);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchAndViewAddedGroupInWorkspace "+e.toString());
		}

		return flag;
	}

	public boolean viewAddedGroupDetails(String groupName, boolean adminFlag) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if (!groupName.isEmpty()) {

				if (groupName.contains(",")) {

					iceuserName = groupName.split(",");

					for (int i = 0; i < iceuserName.length; i++) {

						DataTestingParameters param = setGroupsParamUsingExcel(wORKSPACEEXCELFILEPATH, iceuserName[i]);

						searchAndViewAddedGroupInWorkspace(flag, param.getGroupName(), param.getRole(),
								param.getScope(), adminFlag);
					}

				} else {

					DataTestingParameters param = setGroupsParamUsingExcel(wORKSPACEEXCELFILEPATH, groupName);

					searchAndViewAddedGroupInWorkspace(flag, param.getGroupName(), param.getRole(), param.getScope(),
							adminFlag);

				} 

				displayAndClick(driver, workspaceDetailsUserGroupTabSearchField);

				displayAndClick(driver, workspaceDetailsUserGroupTabSearchClear);
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewAddedGroupDetails "+e.toString());
			flag =false;
		}

		return flag;

	}

	public void validateWorkspaceDetailsOnListingPage(String workspaceName, String description, String accountName, String workspaceType) {

		try {

			waitForExecution(1000);

			BaseSuite.reportLog(hyphenContent+" Verifying workspace details on workspace listing page "+hyphenContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateElementVisibility(returnTwoElements(workspaceListingWorkspaceAvatar, dynamicName, workspaceName,dynamicType,dataContent+workspaceType), dataContent+workspaceType, avatarContent, true);

			validateElementVisibility(returnElement(workspaceListingWorkspaceName, dynamicName, workspaceName), workspaceName, hyperlinkContent, true);

			validateValueWithActual(returnElement(workspaceListingWorkspaceDesc,  dynamicName, workspaceName), descriptionContent, description, attributeTextContent);

			validateValueWithActual(returnElement(workspaceListingWorkspaceAccount,  dynamicName, workspaceName), accountContent, accountName, attributeTextContent);

			String updatedby=getAttribute(driver, returnElement(workspaceListingWorkspaceUpdatedBy, dynamicName, workspaceName), attributeTitle);

			BaseSuite.reportLog("Workspace updated by : "+updatedby);

			String updateddate=getAttribute(driver, returnElement(workspaceListingWorkspaceUpdateddate, dynamicName, workspaceName), attributeTextContent);

			BaseSuite.reportLog("Workspace updated date : "+updateddate);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateWorkspaceDetailsOnListingPage :: "+e.toString());
		}

	}

	public boolean viewWorkspaceFunctionality(String accountName, String workspaceName, String description, String workspaceType, String users, String groups) {

		boolean flag =true;
		String totalRecords="";	
		boolean adminFlag =false;

		try {

			totalRecords=viewExistingWorkspacesDetailPage(accountName,workspaceName,description,workspaceType);

			if(totalRecords.equalsIgnoreCase("0")) {

				validateElement(workspaceDetailsUserGroupTabNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);
			}else {

				viewAddedUserDetails(users,adminFlag);

				clickOnButton(driver, workspaceDetailsUserGroupTabRefreshButton, refreshContent+" "+usersGroupsContent, true);

				viewAddedGroupDetails(groups, adminFlag);
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewWorkspaceFunctionality :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public void selectAccountOnWorkspaceDetailsPage(String accountName) {

		try {


			displayAndClick(driver, workspaceDetailsAccountDropdown);

			waitForExecution(1000);

			sendKeys(driver, workspaceDetailsAccountSelectSearch, accountName);

			BaseSuite.reportLog("Searching for account name : "+accountName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver,1, returnElement(workspaceDetailsAccountselectDynamic, dynamicName, accountName));

			if(isDisplayed(driver, returnElement(workspaceDetailsAccountselectDynamic, dynamicName, accountName))) {

				BaseSuite.reportLog("Selecting account name : "+accountName);

				displayAndClick(driver, returnElement(workspaceDetailsAccountselectDynamic, dynamicName, accountName));

				BaseSuite.validationReportLog("Account is selected");

				String getAcc=getAttribute(driver, workspaceDetailsAccountField, attributeValue);

				stringOutput(getAcc.trim(), accountName, true);

			}else {
				BaseSuite.reportFailLog("Account is not visible", "selectAccountOnWorkspaceDetailsPage");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" selectAccountOnWorkspaceDetailsPage :: "+e.toString());
		}
	}



	public boolean createWorkspaceFunctionality(DataTestingParameters param,String workspaceName, String icedqUser) {
		boolean flag =true;

		try {

			flag=clickOnNewWorkspaceButton(icedqUser);

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER)  || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_CONTRIBUTORUSER)) {

				validateWorkspacesDetailPageBeforeCreating();

				selectAccountOnWorkspaceDetailsPage(param.getAccountName());

				validatAndeEnterValueToTextField(workspaceDetailsNameLabel, workspaceDetailsNameField, workspaceDetailsNameValidation, workspaceNameContent, placeholderEnterWorkspaceName, workspaceName, fieldEmptyWorkspaceName);

				validatAndeEnterValueToTextField(workspaceDetailsDescLabel, workspaceDetailsDescField, workspaceDetailsDescValidation, descriptionContent, placeholderEnterDescription, param.getDescription(), "");

				verifyVisibilityOfButtons(driver, workspaceDetailsDiscardButton, discardContent, true);

				flag=clickOnSaveButtonAndValidateToast(true, toastMessageWorkspaceCreated);

				verifyVisibilityOfButtons(driver, workspaceDetailsDiscardButton, discardContent, false);

				clickOnWorkspacesTab();

				BaseSuite.reportLog(hyphenContent+" Verifying workspace details after created "+hyphenContent);

				flag=searchFunctionalityMethod(flag, workspaceListingSearchField, workspaceListingSearchButton, placeholderSearchWorkspace, placeholderSearchWorkspace, workspaceName);

				if (flag) {

					validateWorkspaceDetailsOnListingPage(workspaceName, param.getDescription(),
							param.getAccountName(), param.getWorkspaceType());
					/**	
					flag=searchWorkspaceNameOnEachPageAndClickOn(returnElement(workspaceListingWorkspaceName, dynamicName, param.getWorkspaceName()), param.getWorkspaceName());

					viewWorkspaceFunctionality(param.getAccountName(), param.getWorkspaceName(), param.getDescription(),
							param.getWorkspaceType(), "", "");

					 **/			
				}

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" createWorkspaceFunctionality :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean updateWorkspaceFunctionality(DataTestingParameters param,String workspaceName,String updatedWorkspaceName, String icedqUser) {
		boolean flag =true;

		try {

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER)  || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_CONTRIBUTORUSER)) {

				if(!BaseSuite.suiteType.equalsIgnoreCase("sanity")) {viewWorkspaceFunctionality(param.getAccountName(), workspaceName, param.getDescription(),
						param.getWorkspaceType(), "", "");}

				validatAndeEnterValueToTextField(workspaceDetailsNameLabel, workspaceDetailsNameField, workspaceDetailsNameValidation, workspaceNameContent, placeholderEnterWorkspaceName, updatedWorkspaceName, fieldEmptyWorkspaceName);

				validatAndeEnterValueToTextField(workspaceDetailsDescLabel, workspaceDetailsDescField, workspaceDetailsDescValidation, descriptionContent, placeholderEnterDescription, param.getUpdateWorkspaceDescription(), "");

				verifyVisibilityOfButtons(driver, workspaceDetailsDiscardButton, discardContent, true);

				flag=clickOnSaveButtonAndValidateToast(true, "");

				viewWorkspaceFunctionality(param.getAccountName(), updatedWorkspaceName, param.getUpdateWorkspaceDescription(),
						param.getWorkspaceType(), "", "");

				clickOnWorkspacesTab();

				BaseSuite.reportLog(hyphenContent+" Verifying workspace details after updated "+hyphenContent);

				flag=searchFunctionalityMethod(flag, workspaceListingSearchField, workspaceListingSearchButton, placeholderSearchWorkspace, placeholderSearchWorkspace, updatedWorkspaceName);

				if (flag) {

					validateWorkspaceDetailsOnListingPage(updatedWorkspaceName, param.getUpdateWorkspaceDescription(),
							param.getAccountName(), param.getWorkspaceType());
					/**	
					flag=searchWorkspaceNameOnEachPageAndClickOn(returnElement(workspaceListingWorkspaceName, dynamicName, param.getWorkspaceName()), param.getWorkspaceName());

					viewWorkspaceFunctionality(param.getAccountName(), param.getWorkspaceName(), param.getDescription(),
							param.getWorkspaceType(), "", "");

					 **/			
				}
			}else {
				validatAndeEnterValueToTextField(workspaceDetailsNameLabel, workspaceDetailsNameField, workspaceDetailsNameValidation, workspaceNameContent, placeholderEnterWorkspaceName, updatedWorkspaceName, fieldEmptyWorkspaceName);

				validatAndeEnterValueToTextField(workspaceDetailsDescLabel, workspaceDetailsDescField, workspaceDetailsDescValidation, descriptionContent, placeholderEnterDescription, param.getUpdateWorkspaceDescription(), "");

				flag=clickOnSaveButtonAndValidateToast(true, PARAMETERPRIVILEGEFORBIDDENMESSAGE);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" updateWorkspaceFunctionality :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean discardWorkspaceFunctionality(DataTestingParameters param,String workspaceName, String icedqUser) {
		boolean flag =true;

		try {

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) ||  icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER)  || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_CONTRIBUTORUSER)) {

				if(!BaseSuite.suiteType.equalsIgnoreCase("sanity")) {viewWorkspaceFunctionality(param.getAccountName(), workspaceName, param.getDescription(),
						param.getWorkspaceType(), "", "");}

				validatAndeEnterValueToTextField(workspaceDetailsNameLabel, workspaceDetailsNameField, workspaceDetailsNameValidation, workspaceNameContent, placeholderEnterWorkspaceName, param.getUpdateWorkspaceName(), fieldEmptyWorkspaceName);

				validatAndeEnterValueToTextField(workspaceDetailsDescLabel, workspaceDetailsDescField, workspaceDetailsDescValidation, descriptionContent, placeholderEnterDescription, param.getUpdateWorkspaceDescription(), "");

				verifyVisibilityOfButtons(driver, workspaceDetailsSaveButton, saveContent, true);

				flag=clickOnDiscardWorkspaceButtonAndValidateToast(flag, "");

				viewWorkspaceFunctionality(param.getAccountName(), workspaceName, param.getDescription(),
						param.getWorkspaceType(), "", "");

				clickOnWorkspacesTab();

				BaseSuite.reportLog(hyphenContent+" Verifying workspace details after discarded "+hyphenContent);

				flag=searchFunctionalityMethod(flag, workspaceListingSearchField, workspaceListingSearchButton, placeholderSearchWorkspace, placeholderSearchWorkspace, workspaceName);

				if (flag) {

					validateWorkspaceDetailsOnListingPage(workspaceName, param.getDescription(),
							param.getAccountName(), param.getWorkspaceType());
					/**	
					flag=searchWorkspaceNameOnEachPageAndClickOn(returnElement(workspaceListingWorkspaceName, dynamicName, param.getWorkspaceName()), param.getWorkspaceName());

					viewWorkspaceFunctionality(param.getAccountName(), param.getWorkspaceName(), param.getDescription(),
							param.getWorkspaceType(), "", "");

					 **/			
				}
			}else {

				validatAndeEnterValueToTextField(workspaceDetailsNameLabel, workspaceDetailsNameField, workspaceDetailsNameValidation, workspaceNameContent, placeholderEnterWorkspaceName, param.getUpdateWorkspaceName(), fieldEmptyWorkspaceName);

				validatAndeEnterValueToTextField(workspaceDetailsDescLabel, workspaceDetailsDescField, workspaceDetailsDescValidation, descriptionContent, placeholderEnterDescription, param.getUpdateWorkspaceDescription(), "");

				flag=clickOnDiscardWorkspaceButtonAndValidateToast(flag, "");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" discardWorkspaceFunctionality :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean discardWorkspaceFunctionalityWhileCreating(DataTestingParameters param,String workspaceName, String icedqUser) {
		boolean flag =true;

		try {

			flag=clickOnNewWorkspaceButton(icedqUser);

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER)  || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_CONTRIBUTORUSER)) {

				validateWorkspacesDetailPageBeforeCreating();

				selectAccountOnWorkspaceDetailsPage(param.getAccountName());

				validatAndeEnterValueToTextField(workspaceDetailsNameLabel, workspaceDetailsNameField, workspaceDetailsNameValidation, workspaceNameContent, placeholderEnterWorkspaceName, workspaceName, fieldEmptyWorkspaceName);

				validatAndeEnterValueToTextField(workspaceDetailsDescLabel, workspaceDetailsDescField, workspaceDetailsDescValidation, descriptionContent, placeholderEnterDescription, param.getDescription(), "");

				verifyVisibilityOfButtons(driver, workspaceDetailsSaveButton, saveContent, true);

				flag=clickOnDiscardWorkspaceButtonAndValidateToast(flag, "");

				validateWorkspacesDetailPageBeforeCreating();

				clickOnWorkspacesTab();

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" discardWorkspaceFunctionalityWhileCreating :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean searchFunctionalityOfWorkspaceListingPage(String scenarioType, String workspaceName,String workspaceDescription, String workspaceType) {
		boolean flag =true;

		try {

			clickOnRefreshOnWorkspacesListingPage();

			if (scenarioType.contains("workspaceName")) {

				flag = searchFunctionalityMethod(flag, workspaceListingSearchField, workspaceListingSearchButton,
						placeholderSearchWorkspace, placeholderSearchWorkspace, workspaceName);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if (flag && elementNotVisible(driver, workspaceListingNoRecordsToDisplay)) {

					validateElementVisibility(returnTwoElements(workspaceListingWorkspaceAvatar, dynamicName, workspaceName,dynamicType,dataContent+workspaceType),dataContent+workspaceType,avatarContent,true);

					validateElementVisibility(returnElement(workspaceListingWorkspaceName, dynamicName, workspaceName),
							workspaceName, hyperlinkContent, true);

				} else {
					BaseSuite.reportFailLog(noRecordsToDisplayContent+isVisibleContent, "searchFunctionalityOfWorkspaceListingPage");

				} 
			}else if(scenarioType.contains("description")) {

				flag = searchFunctionalityMethod(flag, workspaceListingSearchField, workspaceListingSearchButton,
						placeholderSearchWorkspace, placeholderSearchWorkspace, workspaceDescription);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if (flag && elementNotVisible(driver, workspaceListingNoRecordsToDisplay)) {

					List<WebElement> descs= getElements(driver, workspaceListingDescList);

					BaseSuite.reportLog("No of records founds :: "+descs.size());

					for(int i=0; i<descs.size();i++) {

						BaseSuite.reportLog("Verifying workspace description : "+(i+1));

						String acdesc=descs.get(i).getAttribute(attributeTextContent);

						stringContainsOutput(acdesc, workspaceDescription, flag);
					}
				} else {
					BaseSuite.reportFailLog(noRecordsToDisplayContent+isVisibleContent, "searchFunctionalityOfWorkspaceListingPage");

				} 
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchFunctionalityOfWorkspaceListingPage "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean refreshFunctionalityOnWorkspaceListingPage(String workspaceName) {

		boolean flag =true;
		try {

			searchFunctionalityMethod(true, workspaceListingSearchField, workspaceListingSearchButton,
					placeholderSearchWorkspace, placeholderSearchWorkspace, workspaceName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			getPaginationDetails(driver,workspaceListingPaginationMsg, workspaceListingPaginationBar,workspaceListingNoRecordsToDisplay, "Workspaces page");

			clickOnRefreshOnWorkspacesListingPage();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			getPaginationDetails(driver,workspaceListingPaginationMsg, workspaceListingPaginationBar,workspaceListingNoRecordsToDisplay, "Workspaces page");

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" refreshFunctionalityOnWorkspaceListingPage "+e.toString());
			flag=false;
		}

		return flag;
	}


	public boolean refreshFunctionalityOnWorkspaceDetailsPage(DataTestingParameters param, String searchUser) {

		boolean flag =true;
		try {

			if(!BaseSuite.suiteType.equalsIgnoreCase("sanity")) {viewWorkspaceFunctionality(param.getAccountName(), param.getWorkspaceName(), param.getDescription(),
					param.getWorkspaceType(), "", "");}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			searchFunctionalityMethod(true, workspaceDetailsUserGroupTabSearchField, workspaceDetailsUserGroupTabSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, searchUser);

			getPaginationDetails(driver,workspaceDetailsUserGroupTabPaginationMsg, workspaceDetailsUserGroupTabPaginationBar,workspaceDetailsUserGroupTabNoRecordsToDisplay, "Users tab");

			clickOnButton(driver, workspaceDetailsUserGroupTabRefreshButton, refreshContent+" "+usersGroupsContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			getPaginationDetails(driver,workspaceDetailsUserGroupTabPaginationMsg, workspaceDetailsUserGroupTabPaginationBar,workspaceDetailsUserGroupTabNoRecordsToDisplay, "Users tab");

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" refreshFunctionalityOnWorkspaceDetailsPage "+e.toString());
			flag=false;
		}

		return flag;
	}

	public void selectRoleOnAssignSideBar(String role) {

		try {

			validateElementVisibility(workspaceDetailsSidebarRoleLabel, roleContent, labelContent, true);

			displayAndClick(driver, workspaceDetailsSidebarRoleDropdown);

			waitForExecution(1000);

			sendKeys(driver, workspaceDetailsSidebarRoleSelect, role);

			BaseSuite.reportLog("Searching for role : "+role);

			isDisplayedInLoop(driver,2, returnElement(workspaceDetailsSidebarRoleDynamic, dynamicName, role));

			if(isDisplayed(driver, returnElement(workspaceDetailsSidebarRoleDynamic, dynamicName, role))) {

				BaseSuite.reportLog("Selecting for role : "+role);

				displayAndClick(driver, returnElement(workspaceDetailsSidebarRoleDynamic, dynamicName, role));

				BaseSuite.validationReportLog(role+" Role is selected");

				String getrole=getAttribute(driver, workspaceDetailsSidebarRoleField, attributeValue);

				stringOutput(getrole.trim(), role, true);

			}else {
				BaseSuite.reportFailLog("role is not visible", "selectRoleOnAssignSideBar");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" selectRoleOnAssignSideBar :: "+e.toString());
		}
	}

	public void selectAssignAccessToOnAssignSideBar(String assignTo) {

		try {

			validateElementVisibility(workspaceDetailsSidebarAssignToLabel, "Assign access to", labelContent, true);

			displayAndClick(driver, workspaceDetailsSidebarAssignToDropdown);

			waitForExecution(1000);

			isDisplayedInLoop(driver,2, returnElement(workspaceDetailsSidebarAssignToDynamic, dynamicName, assignTo));

			if(isDisplayed(driver, returnElement(workspaceDetailsSidebarAssignToDynamic, dynamicName, assignTo))) {

				BaseSuite.reportLog("Selecting for Assign access to : "+assignTo);

				displayAndClick(driver, returnElement(workspaceDetailsSidebarAssignToDynamic, dynamicName, assignTo));

				BaseSuite.validationReportLog(assignTo+" Assign access to is selected");

				String getrole=getAttribute(driver, workspaceDetailsSidebarAssignToField, attributeValue);

				stringOutput(getrole.trim(), assignTo, true);

			}else {
				BaseSuite.reportFailLog("Assign access to is not visible", "selectAssignAccessToOnAssignSideBar");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" selectAssignAccessToOnAssignSideBar :: "+e.toString());
		}
	}

	public boolean validateAddUserSidebarOnWorkspaceDetailsPage() {
		boolean flag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateElement(workspaceDetailsSidebarAddUserTitle, "Role Assignment", attributeTitle);

			validateElement(workspaceDetailsSidebarAddUserCross, discardContent, iconContent);

			verifyVisibilityOfButtons(driver,workspaceDetailsSidebarAddUserAssignButton, assignContent, false);

			verifyVisibilityOfButtons(driver,workspaceDetailsSidebarAddUserCancelButton, cancelButtonContent,true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateAddUserSidebarOnWorkspaceDetailsPage "+e.toString());
			flag=false;
		}
		return flag;
	}


	public void searchUser(String userName) {

		try {
			verifySearchField(workspaceDetailsSidebarAddUserSearchField, placeholderSearchUser, placeholderSearchUser);

			BaseSuite.reportLog(" Entering value : "+userName);

			displayAndClick(driver, workspaceDetailsSidebarAddUserSearchField);

			clear_Click_SendKeys(driver, 4, workspaceDetailsSidebarAddUserSearchField, userName);

			BaseSuite.reportLog(" Entered value : "+userName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(2000);

			String listcount=getAttribute(driver, workspaceDetailsSidebarAddUserListCount, attributeTextContent);

			BaseSuite.reportLog("User List count : "+listcount);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchUser "+e.toString());

		}		
	}

	public void selectUserCheckbox(String fullName) {

		try {
			By namelocator = returnElement(workspaceDetailsSidebarFullNameDynamic, dynamicName, fullName);
			By checkboxlocator = returnElement(workspaceDetailsSidebarFullNameCheckboxDynamic, dynamicName, fullName);

			isDisplayedInLoop(driver, 2, namelocator);

			if(isDisplayed(driver, namelocator)) {

				BaseSuite.reportLog("User full name is visible as "+fullName);

				if(isDisplayed(driver, checkboxlocator)) {

					BaseSuite.reportLog("User full name checkbox is visible");

					selectcheckbox(checkboxlocator, fullName);

				}else {
					BaseSuite.reportFailLog("User full name checkbox is not visible "+fullName, "selectUserCheckbox");
				}
			}else {
				BaseSuite.reportFailLog("User full name is not visible", "selectUserCheckbox");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" selectUserCheckbox "+e.toString());
		}

	}

	public boolean addUsersToWorkspaceFunctionality(String userName) {
		String[] iceuserName=null;
		boolean flag=true;
		try {

			if(userName.contains(",")) {

				iceuserName= userName.split(","); 

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setUsersParamUsingExcel(wORKSPACEEXCELFILEPATH, iceuserName[i]);

					BaseSuite.reportLog(hyphenContent+" Adding  "+(i+1)+" User to Workspace :: "+param.getFirstName()+" "+param.getLastName()+" "+hyphenContent);

					searchUser(param.getUserName());

					String fullName=param.getFirstName()+" "+param.getLastName();

					selectUserCheckbox(fullName);

				}

			}else {
				DataTestingParameters param = setUsersParamUsingExcel(wORKSPACEEXCELFILEPATH, userName);

				BaseSuite.reportLog(hyphenContent+" Adding  "+1+" User to Workspace :: "+param.getFirstName()+" "+param.getLastName()+" "+hyphenContent);

				searchUser(param.getUserName());

				String fullName=param.getFirstName()+" "+param.getLastName();

				selectUserCheckbox(fullName);

			}

			clickOnButton(driver, workspaceDetailsSidebarAddUserAssignButton, assignContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" addUsersToWorkspaceFunctionality "+e.toString());
			flag=false;
		}
		return flag;
	}


	public boolean addGroupdToWorkspaceFunctionality(String userName) {
		String[] iceuserName=null;
		boolean flag=true;
		try {

			if(userName.contains(",")) {

				iceuserName= userName.split(","); 

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setGroupsParamUsingExcel(wORKSPACEEXCELFILEPATH, iceuserName[i]);

					BaseSuite.reportLog(hyphenContent+" Adding "+(i+1)+" Group to Workspace :: "+param.getGroupName()+" "+hyphenContent);

					displayAndClick(driver, workspaceDetailsSidebarSelectGroupField);

					waitForExecution(1000);

					sendKeys(driver, dataTSpinner, param.getGroupName());

					isDisplayedInLoop(driver, 2, returnElement(workspaceDetailsSidebarSelectGroup, dynamicName, param.getGroupName()));

					if(isDisplayed(driver, returnElement(workspaceDetailsSidebarSelectGroup, dynamicName, param.getGroupName()))) {

						displayAndClick(driver, returnElement(workspaceDetailsSidebarSelectGroup, dynamicName, param.getGroupName()));

						waitForExecution(1000);

					}

				}

			}else {
				DataTestingParameters param = setGroupsParamUsingExcel(wORKSPACEEXCELFILEPATH, userName);

				BaseSuite.reportLog(hyphenContent+" Adding "+1+" Group to Workspace :: "+param.getFirstName()+" "+param.getLastName()+" "+hyphenContent);

				displayAndClick(driver, workspaceDetailsSidebarSelectGroupField);

				waitForExecution(1000);

				sendKeys(driver, workspaceDetailsSidebarSelectGroupField, param.getGroupName());

				isDisplayedInLoop(driver, 2, returnElement(workspaceDetailsSidebarSelectGroup, dynamicName, param.getGroupName()));

				if(isDisplayed(driver, returnElement(workspaceDetailsSidebarSelectGroup, dynamicName, param.getGroupName()))) {

					displayAndClick(driver, returnElement(workspaceDetailsSidebarSelectGroup, dynamicName, param.getGroupName()));

					waitForExecution(1000);

				}

			}

			clickOnButton(driver, workspaceDetailsSidebarAddUserAssignButton, assignContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" addUsersToWorkspaceFunctionality "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateLoadMore(String listCount) {
		boolean flag=true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			String b = listCount.split("of")[1].trim();

			validateElementVisibility(workspaceDetailsSidebarAddUserLoadMore, "Load more", hyperlinkContent, Integer.parseInt(b)>20);

		}catch(Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" validateLoadMore "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean assignWorkspaceLevelAccessTo(String userName) {

		boolean flag=true;
		try {

			DataTestingParameters aParam=setAssignToParamUsingExcel(wORKSPACEEXCELFILEPATH, userName);

			validateAddUserSidebarOnWorkspaceDetailsPage();

			selectRoleOnAssignSideBar(aParam.getRole());

			selectAssignAccessToOnAssignSideBar(aParam.getAssignTo());

			if (aParam.getAssignTo().equalsIgnoreCase("user")) {

				BaseSuite.reportLog(hyphenContent+"  Assigning access to user : "+aParam.getUserName()+hyphenContent);

				verifySearchField(workspaceDetailsSidebarAddUserSearchField, placeholderSearchUser,
						placeholderSearchUser);

				/**		validateElement(workspaceDetailsSidebarAddUserLoadMore, "Load more", hyperlinkContent);**/

				javascript(driver, scrollToElementArg, workspaceDetailsSidebarAddUserListCount);

				String listcount = getAttribute(driver, workspaceDetailsSidebarAddUserListCount, attributeTextContent);

				BaseSuite.reportLog("User List count :" + listcount);

				/**		validateLoadMore(listcount); requirement change**/

				addUsersToWorkspaceFunctionality(aParam.getUserName());

				viewAddedUserDetails(aParam.getUserName(),false);

			} else {

				BaseSuite.reportLog(hyphenContent+"  Assigning access to group : "+aParam.getUserName()+hyphenContent);

				validateElementVisibility(workspaceDetailsSidebarSelectGroupLabel, selectGroupContent, labelContent, true);

				verifySearchField(workspaceDetailsSidebarSelectGroupField, placeholderSelectGroups,
						placeholderSelectGroups);

				addGroupdToWorkspaceFunctionality(aParam.getUserName());

				viewAddedGroupDetails(aParam.getUserName(), false);

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" assignWorkspaceLevelAccessTo "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean assignWorkspaceLevelAccessToNoUI(String userName) {

		boolean flag=true;
		try {

			DataTestingParameters aParam=setAssignToParamUsingExcel(wORKSPACEEXCELFILEPATH, userName);

			validateAddUserSidebarOnWorkspaceDetailsPage();

			selectRoleOnAssignSideBar(aParam.getRole());

			selectAssignAccessToOnAssignSideBar(aParam.getAssignTo());

			if (aParam.getAssignTo().equalsIgnoreCase("user")) {

				BaseSuite.reportLog(hyphenContent+" Assigning access to user : "+aParam.getUserName()+hyphenContent);

				verifySearchField(workspaceDetailsSidebarAddUserSearchField, placeholderSearchUser,
						placeholderSearchUser);

				/**		validateElement(workspaceDetailsSidebarAddUserLoadMore, "Load more", hyperlinkContent);**/

				javascript(driver, scrollToElementArg, workspaceDetailsSidebarAddUserListCount);

				String listcount = getAttribute(driver, workspaceDetailsSidebarAddUserListCount, attributeTextContent);

				BaseSuite.reportLog("User List count " + listcount);

				/**	validateLoadMore(listcount);*/

				addUsersToWorkspaceFunctionality(aParam.getUserName());

				/**	viewAddedUserDetails(aParam.getUserName(),false);*/

			} else {

				BaseSuite.reportLog(hyphenContent+" Assigning access to group : "+aParam.getUserName()+hyphenContent);

				validateElementVisibility(workspaceDetailsSidebarSelectGroupLabel, selectGroupContent, labelContent, true);

				verifySearchField(workspaceDetailsSidebarSelectGroupField, placeholderSelectGroups,
						placeholderSelectGroups);

				addGroupdToWorkspaceFunctionality(aParam.getUserName());

				/**	viewAddedUserDetails(aParam.getUserName(),false);*/

			}
			waitForExecution(1000);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" assignWorkspaceLevelAccessToNoUI "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateAndAssignWorkspaceLevelAccessToNoUI(String userName) {

		boolean flag=true;
		try {

			DataTestingParameters aParam=setAssignToParamUsingExcel(wORKSPACEEXCELFILEPATH, userName);

			if (aParam.getAssignTo().equalsIgnoreCase("user")) {

				flag=searchAndViewAddedUserInWorkspaceNOUI(flag, aParam.getFirstName()+ " "+ aParam.getLastName());

				if(flag) {

					clickOnAssignButtonAndValidateToast(true, "");

					waitForExecution(2000);

					selectRoleOnAssignSideBar(aParam.getRole());

					selectAssignAccessToOnAssignSideBar(aParam.getAssignTo());

					BaseSuite.reportLog(hyphenContent+" Assigning access to user : "+aParam.getUserName()+hyphenContent);

					verifySearchField(workspaceDetailsSidebarAddUserSearchField, placeholderSearchUser,
							placeholderSearchUser);

					javascript(driver, scrollToElementArg, workspaceDetailsSidebarAddUserListCount);

					String listcount = getAttribute(driver, workspaceDetailsSidebarAddUserListCount, attributeTextContent);

					BaseSuite.reportLog("User List count " + listcount);

					addUsersToWorkspaceFunctionality(aParam.getUserName());

				}

			} else {

				flag=searchAndViewAddedUserInWorkspaceNOUI(flag, aParam.getUserName());

				if(flag) {

					clickOnAssignButtonAndValidateToast(true, "");

					waitForExecution(2000);

					selectRoleOnAssignSideBar(aParam.getRole());

					selectAssignAccessToOnAssignSideBar(aParam.getAssignTo());

					BaseSuite.reportLog(hyphenContent+" Assigning access to group : "+aParam.getUserName()+hyphenContent);

					validateElementVisibility(workspaceDetailsSidebarSelectGroupLabel, selectGroupContent, labelContent, true);

					verifySearchField(workspaceDetailsSidebarSelectGroupField, placeholderSelectGroups,
							placeholderSelectGroups);

					addGroupdToWorkspaceFunctionality(aParam.getUserName());
				}
			}

			waitForExecution(1000);

			searchFunctionalityMethod(true, workspaceDetailsUserGroupTabSearchField, workspaceDetailsUserGroupTabSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, "");

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateAndAssignWorkspaceLevelAccessToNoUI "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean assignUserGroupAccessToWorkspace(String userName, String icedqUser) {

		String[] iceuserName=null;
		boolean flag=true;

		try {
			if (icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER) || icedqUser.contains(ConstantProperty.ICEDQ_WORKSPACE_OWNERUSER)) {

				if (!userName.isEmpty()) {

					if (userName.contains(",")) {

						iceuserName = userName.split(",");

						for (int i = 0; i < iceuserName.length; i++) {

							BaseSuite.reportLog(hyphenContent + " Assigning user/group access to workspace  : "
									+ iceuserName[i] + hyphenContent);

							clickOnAssignButtonAndValidateToast(true, "");

							flag = assignWorkspaceLevelAccessTo(iceuserName[i]);
						}

					} else {

						BaseSuite.reportLog(hyphenContent + " Assigning user/group access to workspace  : " + userName
								+ hyphenContent);

						clickOnAssignButtonAndValidateToast(true, "");

						flag = assignWorkspaceLevelAccessTo(userName);
					} 
				}



			}else {

				clickOnAssignButtonAndValidateToast(true, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" assignUserGroupAccessToWorkspace "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean assignUserGroupAccessToWorkspaceNoUI(String userName, String icedqUser) {

		String[] iceuserName=null;
		boolean flag=true;

		try {
			if (icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER) || icedqUser.contains(ConstantProperty.ICEDQ_WORKSPACE_OWNERUSER)) {

				if (!userName.isEmpty()) {

					if (userName.contains(",")) {

						iceuserName = userName.split(",");

						for (int i = 0; i < iceuserName.length; i++) {

							BaseSuite.reportLog(hyphenContent + " Assigning user/group access to workspace : "
									+ iceuserName[i] + hyphenContent);

							/**		clickOnAssignButtonAndValidateToast(true, "");*/

							flag = validateAndAssignWorkspaceLevelAccessToNoUI(iceuserName[i]);
						}

					} else {

						BaseSuite.reportLog(hyphenContent + " Assigning user/group access to workspace : " + userName
								+ hyphenContent);

						/**	clickOnAssignButtonAndValidateToast(true, "");*/

						flag = validateAndAssignWorkspaceLevelAccessToNoUI(userName);
					} 
				}

			}else {

				clickOnAssignButtonAndValidateToast(true, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" assignUserGroupAccessToWorkspaceNoUI "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean selectUserCheckboxForAddedWorkspace(boolean flag, String fullName) {

		try {
			By namelocator = returnElement(workspaceDetailsUserNameDynamic, dynamicName, fullName);
			By checkboxlocator = returnElement(workspaceDetailsUserNameCheckbox, dynamicName, fullName);

			isDisplayedInLoop(driver, 2, namelocator);

			if(isDisplayed(driver, namelocator)) {

				BaseSuite.reportLog("User full name is visible as "+fullName);

				if(isDisplayed(driver, checkboxlocator)) {

					BaseSuite.reportLog("User full name checkbox is visible");

					flag=selectcheckbox(checkboxlocator, fullName);

				}else {
					BaseSuite.reportFailLog("User full name checkbox is not visible "+fullName, "selectUserCheckboxForAddedWorkspace");
				}
			}else {
				BaseSuite.reportFailLog("User full name is not visible", "selectUserCheckboxForAddedWorkspace");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" selectUserCheckboxForAddedWorkspace "+e.toString());
		}
		return flag;
	}

	public boolean deleteUsersFromWorkspaceFunctionality(String userName, String icedqUser) {
		String[] iceuserName=null;
		boolean flag=true;
		int num=0;
		try {

			if(userName.contains(",")) {

				iceuserName= userName.split(","); 
				num=iceuserName.length;
				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setUsersParamUsingExcel(wORKSPACEEXCELFILEPATH, iceuserName[i]);

					BaseSuite.reportLog(hyphenContent+"  Deleting "+(i+1)+" User from workspace :: "+param.getFirstName()+" "+param.getLastName()+" "+hyphenContent);

					String fullName=param.getFirstName()+" "+param.getLastName();

					flag=searchFunctionalityMethod(true, workspaceDetailsUserGroupTabSearchField, workspaceDetailsUserGroupTabSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, fullName);

					selectUserCheckboxForAddedWorkspace(flag,fullName);

				}

			}else {
				num=1;
				DataTestingParameters param = setUsersParamUsingExcel(wORKSPACEEXCELFILEPATH, userName);

				BaseSuite.reportLog(hyphenContent+"  Deleting "+1+" User from workspace :: "+param.getFirstName()+" "+param.getLastName()+" "+hyphenContent);

				String fullName=param.getFirstName()+" "+param.getLastName();

				flag=searchFunctionalityMethod(true, workspaceDetailsUserGroupTabSearchField, workspaceDetailsUserGroupTabSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, fullName);

				selectUserCheckboxForAddedWorkspace(flag,fullName);

			}

			searchFunctionalityMethod(true, workspaceDetailsUserGroupTabSearchField, workspaceDetailsUserGroupTabSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, "");

			if (icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER) || icedqUser.contains(ConstantProperty.ICEDQ_WORKSPACE_OWNERUSER)) {

				flag=clickOnButton(driver, workspaceDetailsUserGroupTabDeleteButton, deleteContent, true);

				flag=clickOnDeleteUserGroupButtonFromWorkspaceAndValidateToast(flag, num, "");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}else {
				flag=clickOnButton(driver, workspaceDetailsUserGroupTabDeleteButton, deleteContent, true);
				flag=clickOnDeleteUserGroupButtonFromWorkspaceAndValidateToast(flag, num, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
				clickOnButton(driver, workspaceDetailsUserGroupPopupDeleteCancelButton, cancelButtonContent, true);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" deleteUsersFromWorkspaceFunctionality "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateDeletedUserInWorkspace(String userName, String icedqUser) {

		String[] iceuserName=null;
		boolean flag=true;
		try {
			if (icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER) || icedqUser.contains(ConstantProperty.ICEDQ_WORKSPACE_OWNERUSER)) {

				if(userName.contains(",")) {

					iceuserName= userName.split(","); 
					for(int i=0;i<iceuserName.length;i++) {

						DataTestingParameters param = setUsersParamUsingExcel(wORKSPACEEXCELFILEPATH, iceuserName[i]);

						String fullName=param.getFirstName()+" "+param.getLastName();

						searchUserForDeletedInWorkspace(flag, fullName,usersContent);

					}

				}else {
					DataTestingParameters param = setUsersParamUsingExcel(wORKSPACEEXCELFILEPATH, userName);

					String fullName=param.getFirstName()+" "+param.getLastName();

					searchUserForDeletedInWorkspace(flag, fullName,usersContent);

				}

				clickOnButton(driver, workspaceDetailsUserGroupTabRefreshButton, refreshContent+" "+usersGroupsContent, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateDeletedUserGroupInWorkspace "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateDeletedGroupInWorkspace(String userName, String icedqUser) {

		String[] iceuserName=null;
		boolean flag=true;
		try {
			if (icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER) || icedqUser.contains(ConstantProperty.ICEDQ_WORKSPACE_OWNERUSER)) {

				if(userName.contains(",")) {

					iceuserName= userName.split(","); 

					for(int i=0;i<iceuserName.length;i++) {

						DataTestingParameters param = setGroupsParamUsingExcel(wORKSPACEEXCELFILEPATH, iceuserName[i]);

						searchUserForDeletedInWorkspace(flag, param.getGroupName(),groupContent);

					}

				}else {
					DataTestingParameters param = setGroupsParamUsingExcel(wORKSPACEEXCELFILEPATH, userName);

					searchUserForDeletedInWorkspace(flag, param.getGroupName(),groupContent);

				}

				clickOnButton(driver, workspaceDetailsUserGroupTabRefreshButton, refreshContent+" "+usersGroupsContent, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateDeletedGroupInWorkspace "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean deleteGroupsFromWorkspaceFunctionality(String groupName, String icedqUser) {
		String[] iceuserName=null;
		boolean flag=true;
		int num=0;
		try {

			if(groupName.contains(",")) {

				iceuserName= groupName.split(","); 
				num=iceuserName.length;
				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setGroupsParamUsingExcel(wORKSPACEEXCELFILEPATH, iceuserName[i]);

					BaseSuite.reportLog(hyphenContent+" Deleting "+(i+1)+" Group from workspace :: "+param.getGroupName()+" "+hyphenContent);

					flag=searchFunctionalityMethod(true, workspaceDetailsUserGroupTabSearchField, workspaceDetailsUserGroupTabSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, param.getGroupName());

					selectUserCheckboxForAddedWorkspace(flag,param.getGroupName());

				}

			}else {
				num=1;
				DataTestingParameters param = setGroupsParamUsingExcel(wORKSPACEEXCELFILEPATH, groupName);

				BaseSuite.reportLog(hyphenContent+" Deleting "+1+" Group from workspace :: "+param.getGroupName()+" "+hyphenContent);

				flag=searchFunctionalityMethod(true, workspaceDetailsUserGroupTabSearchField, workspaceDetailsUserGroupTabSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, param.getGroupName());

				selectUserCheckboxForAddedWorkspace(flag,param.getGroupName());

			}

			searchFunctionalityMethod(true, workspaceDetailsUserGroupTabSearchField, workspaceDetailsUserGroupTabSearchButton, placeholderSearchUser, placeholderSearchUser, "");

			if (icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER) || icedqUser.contains(ConstantProperty.ICEDQ_WORKSPACE_OWNERUSER)) {

				flag=clickOnButton(driver, workspaceDetailsUserGroupTabDeleteButton, deleteContent, true);

				flag=clickOnDeleteUserGroupButtonFromWorkspaceAndValidateToast(flag, num, "");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}else {
				flag=clickOnButton(driver, workspaceDetailsUserGroupTabDeleteButton, deleteContent, true);
				flag=clickOnDeleteUserGroupButtonFromWorkspaceAndValidateToast(flag, num, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
				clickOnButton(driver, workspaceDetailsUserGroupPopupDeleteCancelButton, cancelButtonContent, true);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" deleteUsersFromWorkspaceFunctionality "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean revokeUserGroupAccessToWorkspace(DataTestingParameters param,String workspaceName, String removeUser, String removeGroup, String icedqUser) {

		boolean flag=true;

		try {

			/**		viewWorkspaceFunctionality(param.getAccountName(), workspaceName, param.getDescription(),param.getWorkspaceType(), param.getAddUser(), param.getAddGroup());
			 */
			if(!removeUser.isEmpty()) {

				flag=deleteUsersFromWorkspaceFunctionality(removeUser,icedqUser);

				validateDeletedUserInWorkspace(removeUser, icedqUser);

			}

			clickOnButton(driver, workspaceDetailsUserGroupTabRefreshButton, refreshContent+" "+usersGroupsContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(!removeGroup.isEmpty()) {

				flag=deleteGroupsFromWorkspaceFunctionality(removeGroup,icedqUser);

				validateDeletedGroupInWorkspace(removeGroup,icedqUser);

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" revokeUserGroupAccessToWorkspace "+e.toString());
			flag=false;
		}
		return flag;

	}


	public boolean searchAndCreateAndAssignWorkspaceAccess(DataTestingParameters param,String workspaceName, String icedqUser) {
		boolean flag=true;

		try {

			searchFunctionalityMethod(true, workspaceListingSearchField, workspaceListingSearchButton,
					placeholderSearchWorkspace, placeholderSearchWorkspace, workspaceName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(elementNotVisible(driver, workspaceListingNoRecordsToDisplay)) {

				/**flag=searchWorkspaceNameOnEachPageAndClickOn(returnElement(workspaceListingWorkspaceName, dynamicName, workspaceName), workspaceName);*/
				flag=	searchWorkspaceNameOnEachPageAndClickOn(returnTwoElements(workspaceListingWorkspaceNameWithAccount, dynamicAccountName, BaseSuite.accountName, dynamicName, workspaceName), workspaceName);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}else {

				flag= createWorkspaceFunctionality(param,workspaceName, icedqUser);

				searchWorkspaceAndClickOnName(workspaceName);
			}

			if(flag) {

				flag=assignUserGroupAccessToWorkspace(param.getAddUser(), icedqUser);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchAndCreateAndAssignWorkspaceAccess "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateAccountFieldInWorkspace(String accountName) {
		boolean flag =true;

		try {

			isDisplayedInLoop(driver, 3, workspaceDetailsAccountDropdown);

			displayAndClick(driver, workspaceDetailsAccountDropdown);

			waitForExecution(1000);

			sendKeys(driver, workspaceDetailsAccountSelectSearch, accountName);

			BaseSuite.reportLog("Searching for account name : "+accountName);

			if(elementNotVisible(driver, workspaceDetailsAccountSelectNoRecordsFound)) {

				flag=false;
			}else {

				BaseSuite.reportLog("No records found is visible");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateAccountFieldInWorkspace "+e.toString());
			flag=false;
		}
		return flag;
	}

	//invalid method
	public boolean createWorkspaceFunctionalityWithInvalidDetails(String scenarioType,String accountName, String workspaceName, String description,String fieldValidation, String toastValidation, String icedqUser) {
		boolean flag =true;

		try {

			flag=clickOnNewWorkspaceButton(icedqUser);

			if(flag && icedqUser.toLowerCase().contains(adminsContent)) {

				validateWorkspacesDetailPageBeforeCreating();

				switch(scenarioType.toLowerCase()) {

				case"accountname":

					flag=validateAccountFieldInWorkspace(accountName);

					break;

				case"workspacenamevalue":

					if(!workspaceName.isEmpty()) {
						enterValueToTextField(driver, workspaceDetailsNameField, workspaceContent, workspaceName);	
					}else {
						sendKeys(driver, workspaceDetailsNameField, "emp");
						waitForExecution(500);
						click(driver, workspaceDetailsNameField);
						clear(driver, workspaceDetailsNameField);
					}

					String acmesg = validationMessageOfField(workspaceDetailsNameValidation, workspaceContent, fieldValidation, true);

					if(!fieldValidation.equalsIgnoreCase(acmesg)) {
						flag=false;
					}

					verifyVisibilityOfButtons(driver, workspaceDetailsSaveButton, saveContent, false);

					break;

				case"workspacedesc":

					enterValueToTextField(driver, workspaceDetailsDescField, descriptionContent, description);	

					String acdesc = validationMessageOfField(workspaceDetailsDescValidation, descriptionContent, fieldValidation, true);

					if(!fieldValidation.equalsIgnoreCase(acdesc)) {
						flag=false;
					}

					verifyVisibilityOfButtons(driver, workspaceDetailsSaveButton, saveContent, false);

					break;

				case"existingworkspace":

					selectAccountOnWorkspaceDetailsPage(accountName);

					validatAndeEnterValueToTextField(workspaceDetailsNameLabel, workspaceDetailsNameField, workspaceDetailsNameValidation, groupNameContent, placeholderEnterWorkspaceName, workspaceName, fieldEmptyWorkspaceName);

					validatAndeEnterValueToTextField(workspaceDetailsDescLabel, workspaceDetailsDescField, workspaceDetailsDescValidation, descriptionContent, placeholderEnterDescription, description, fieldValidation);

					flag=clickOnSaveButtonAndValidateToast(flag, toastValidation);

					break;

				default:

					break;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" createWorkspaceFunctionalityWithInvalidDetails :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean updateWorkspaceFunctionalityWithInvalidDetails(DataTestingParameters param,String scenarioType,String searchWorkspace, String icedqUser) {
		boolean flag =true;
		boolean state =true;
		try {

			String workspaceName=param.getWorkspaceName();
			String description=param.getDescription();
			String fieldValidation=param.getFieldValidationMessage();
			String toastValidation=param.getToastValidationMessage();
			String userName=param.getAddUser();

			state=searchWorkspaceAndClickOnName(searchWorkspace);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(state && icedqUser.toLowerCase().contains(adminsContent)) {

				switch(scenarioType.toLowerCase()) {

				case"workspacenamevalue":

					if(!workspaceName.isEmpty()) {
						enterValueToTextField(driver, workspaceDetailsNameField, workspaceContent, workspaceName);	
					}else {
						sendKeys(driver, workspaceDetailsNameField, "emp");
						waitForExecution(500);
						click(driver, workspaceDetailsNameField);
						clear(driver, workspaceDetailsNameField);
					}

					String acmesg = validationMessageOfField(workspaceDetailsNameValidation, workspaceContent, fieldValidation, true);

					if(!fieldValidation.equalsIgnoreCase(acmesg)) {
						flag=false;
					}

					verifyVisibilityOfButtons(driver, workspaceDetailsSaveButton, saveContent, false);

					break;

				case"workspacedesc":

					enterValueToTextField(driver, workspaceDetailsDescField, descriptionContent, description);	

					String acdesc = validationMessageOfField(workspaceDetailsDescValidation, descriptionContent, fieldValidation, true);

					if(!fieldValidation.equalsIgnoreCase(acdesc)) {
						flag=false;
					}

					verifyVisibilityOfButtons(driver, workspaceDetailsSaveButton, saveContent, false);

					break;

				case"existingworkspace":

					validatAndeEnterValueToTextField(workspaceDetailsNameLabel, workspaceDetailsNameField, workspaceDetailsNameValidation, workspaceContent, placeholderEnterWorkspaceName, workspaceName, fieldEmptyWorkspaceName);

					validatAndeEnterValueToTextField(workspaceDetailsDescLabel, workspaceDetailsDescField, workspaceDetailsDescValidation, descriptionContent, placeholderEnterDescription, description, fieldValidation);

					flag=clickOnSaveButtonAndValidateToast(flag, toastValidation);

					break;

				case"searchusergroup":

					flag=searchFunctionalityMethod(true, workspaceDetailsUserGroupTabSearchField, workspaceDetailsUserGroupTabSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, userName);

					validateElementVisibility(workspaceDetailsUserGroupTabNoRecordsToDisplay, noRecordsToDisplayContent, labelContent, true);

					break;

				default:

					break;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" updateWorkspaceFunctionalityWithInvalidDetails :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public void navigateToBreadcrumb(String groupName) {

		HomePage hp=new HomePage(driver);

		try {

			searchWorkspaceAndClickOnName(groupName);

			navigateToLink(driver, workspaceBreadcrumbWorkspaceLink, returnElement(subModuleHeadingName, dynamicName, workspacesContent), workspacesContent+" "+breadcrumbContent);

			searchWorkspaceAndClickOnName(groupName);

			navigateToLink(driver, workspaceBreadcrumbAdminLink, returnElement(subModuleHeadingName, dynamicName, usersContent), administrationContent+" "+breadcrumbContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnWorkspacesTab();

			searchWorkspaceAndClickOnName(groupName);

			clickOnButton(driver, workspaceBreadcrumbHomeLink, homeContent+" "+breadcrumbContent, true);

			hp.clickOnAdministrationTab();

			clickOnWorkspacesTab();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" navigateToBreadcrumb :: "+e.toString());

		}

	}

	public boolean validateNavigationFunctionalityForWorkspaces(String workspaceName, String icedqUser) {

		boolean flag =true;
		HomePage hp=new HomePage(driver);
		try {

			navigateToAdministrationTabs(nextgenSubModuleUsers,returnElement(subModuleHeadingName, dynamicName, usersContent), usersContent, subModuleContent);

			navigateToAdministrationTabs(nextgenSubModuleGroups,returnElement(subModuleHeadingName, dynamicName, groupsContent), groupsContent, subModuleContent);

			navigateToAdministrationTabs(nextgenSubModuleRoles,returnElement(subModuleHeadingName, dynamicName, rolesContent), rolesContent, subModuleContent);

			navigateToAdministrationTabs(nextgenSubModuleAccounts,returnElement(subModuleHeadingName, dynamicName, accountsContent), accountsContent, subModuleContent);

			navigateToAdministrationTabs(nextgenSubModuleWorkspaces,returnElement(subModuleHeadingName, dynamicName, workspacesContent), workspacesContent, subModuleContent);
			/**
		//	navigateToAdministrationTabs(nextgenSubModuleFederations,returnElement(subModuleHeadingName, dynamicName, fedetationsContent), fedetationsContent, subModuleContent);

		//	navigateToAdministrationTabs(nextgenSubModuleIdentityProviders,returnElement(subModuleHeadingName, dynamicName, identityProvidersContent), identityProvidersContent, subModuleContent);

		//	navigateToAdministrationTabs(nextgenSubModuleVault,returnElement(subModuleHeadingName, dynamicName,  vaultContent), vaultContent, subModuleContent);

		//	navigateToAdministrationTabs(nextgenSubModuleFields,returnElement(subModuleHeadingName, dynamicName,  fieldContent), fieldContent, subModuleContent);

		//	navigateToAdministrationTabs(nextgenSubModuleCalenders,returnElement(subModuleHeadingName, dynamicName, calendarsContent), calendarsContent, subModuleContent);

		//	navigateToAdministrationTabs(nextgenSubModuleSettings,returnElement(subModuleHeadingName, dynamicName, settingsContent), settingsContent, subModuleContent);

		//	navigateToAdministrationTabs(nextgenSubModuleIntegrations,returnElement(subModuleHeadingName, dynamicName, integrationsContent), integrationsContent, subModuleContent);

		//	navigateToAdministrationTabs(nextgenSubModuleLibraries,returnElement(subModuleHeadingName, dynamicName, librariesContent), librariesContent, subModuleContent);
			 */
			clickOnNewWorkspaceButton(icedqUser);

			navigateToLink(driver, workspaceBreadcrumbWorkspaceLink, returnElement(subModuleHeadingName, dynamicName, workspacesContent), workspacesContent+" "+breadcrumbContent);

			clickOnNewWorkspaceButton(icedqUser);

			navigateToLink(driver, workspaceBreadcrumbAdminLink, returnElement(subModuleHeadingName, dynamicName, usersContent), administrationContent+" "+breadcrumbContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnWorkspacesTab();

			clickOnNewWorkspaceButton(icedqUser);

			clickOnButton(driver, workspaceBreadcrumbHomeLink, homeContent+" "+breadcrumbContent, true);

			hp.clickOnAdministrationTab();

			clickOnWorkspacesTab();

			navigateToBreadcrumb(workspaceName);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateNavigationFunctionalityForWorkspaces :: "+e.toString());
			flag=false;
		}

		return flag;
	}


	//Workspace Delete API-----------------------------------

	static String contentType = prop.getProperty("ContentType");
	static String apiorgId=prop.getProperty("api.apiorgId");
	static String apiBearer=prop.getProperty("api.apiBearer");
	static String authorization=prop.getProperty("api.authorization");

	public String searchForWorkspaceUsingWorkspaceName(String workspaceName, String icedqUser, String accountID) {
		String jsonEntity = null;
		String orgid;
		try {

			orgid=getOrgId("");

			String auto = WorkflowPage.getOAuthBearerTokenBasedOnIcedqRole(icedqUser);

			OkHttpClient client = new OkHttpClient().newBuilder().build();

			MediaType mediaType = MediaType.parse(contentType);

			RequestBody body = RequestBody.create(mediaType,
					"{\r\n"
							+ "    \"search\": [\r\n"
							+ "        {\r\n"
							+ "            \"attribute\": \"name\",\r\n"
							+ "            \"operator\": \"equals\",\r\n"
							+ "            \"value\": \""+workspaceName+"\"\r\n"
							+ "        }\r\n"
							+ "    ]\r\n"
							+ "}");

			Request request = new Request.Builder()

					.url(BaseSuite.baseURL+"api/v1/workspaces/search").method("POST", body)

					.addHeader("content-type", contentType)

					.addHeader("Account-Id", accountID)

					.addHeader(apiorgId, orgid)

					.addHeader(authorization, "Bearer " + auto)

					.build();

			Response response = client.newCall(request).execute();

			BaseSuite.reportLog("Searching for workspace name by api request and workspace name : "+workspaceName);

			String r = response.body().string();

			int statusCode = response.code();

			BaseSuite.reportLog("Responce code is : "+ statusCode);
			BaseSuite.reportLog("Responce body is : "+ r);

			if(statusCode==200) {

				jsonEntity = WorkflowPage.getJsonValueUsingJsonPathExpreesion(r, "$.items[0].id");

				if(jsonEntity.contains("wksc")) {

					BaseSuite.validationReportLog("Workspace name found and workspace id : "+jsonEntity);

				}else {
					BaseSuite.reportLog("Workspace name not found and responce is : "+r);
				}
			}else {
				BaseSuite.reportLog("Workspace name not found ");

			}

		} catch (Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" searchForWorkspaceUsingWorkspaceName "+e.toString());
		}
		return jsonEntity;
	}

	// get workflow info from workflow id and workspace id
	public int deleteWorkspaceUsingWorkspaceId(String workspaceId, String icedqUser, String accountID) {
		int statusCode=0;
		String orgid;
		try {
			orgid=getOrgId("");

			String auto = WorkflowPage.getOAuthBearerTokenBasedOnIcedqRole(icedqUser);

			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpDelete delRequest = new HttpDelete(BaseSuite.baseURL+ "api/v1/workspaces/" + workspaceId);

			delRequest.setHeader("content-type", contentType);

			delRequest.setHeader("Account-Id", accountID);

			delRequest.setHeader(apiorgId, orgid);

			delRequest.setHeader(authorization, "Bearer "+auto);

			HttpResponse response;

			BaseSuite.reportLog("Deleting workspace by api request using workspace id : "+workspaceId);

			response = httpClient.execute(delRequest);

			log.info("response---------------- " + response);

			statusCode = response.getStatusLine().getStatusCode();

			log.info("Status code for getting issues ----------- " + statusCode);

			HttpEntity entity1 = response.getEntity();

			String jsonEntity = EntityUtils.toString(entity1);

			BaseSuite.reportLog("Responce code is : "+ statusCode);
			BaseSuite.reportLog("Responce body is : "+ jsonEntity);

			if(statusCode==202) {

				BaseSuite.validationReportLog("Workspace deletion request is accepted");

			}else if(statusCode==404) {

				BaseSuite.reportLog("Workspace Id not found");

			}
		} catch (Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" deleteWorkspaceUsingWorkspaceId "+e.toString());

		}
		return statusCode;
	}



	public boolean deleteWorkspaceUsingAPI(String workspaceName, String icedqUser, String accountID) {

		boolean flag=true;
		int statusCode=0;

		try {

			if (!BaseSuite.baseURL.contains("52.20.42.154:32222")) {

				String workspaceId = searchForWorkspaceUsingWorkspaceName(workspaceName, icedqUser, accountID);
				if (workspaceId != null) {

					statusCode = deleteWorkspaceUsingWorkspaceId(workspaceId, icedqUser, accountID);

					if (statusCode != 202) {
						flag = false;
					}

				} 
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" deleteWorkspaceUsingAPI "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean createWorkspaceFunctionalityNOUI(DataTestingParameters param,String workspaceName, String icedqUser) {
		boolean flag =true;

		try {

			flag=clickOnNewWorkspaceButton(icedqUser);

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER)  || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_CONTRIBUTORUSER)) {

				/**	validateWorkspacesDetailPageBeforeCreating();
				 */
				selectAccountOnWorkspaceDetailsPage(param.getAccountName());

				validatAndeEnterValueToTextField(workspaceDetailsNameLabel, workspaceDetailsNameField, workspaceDetailsNameValidation, workspaceNameContent, placeholderEnterWorkspaceName, workspaceName, fieldEmptyWorkspaceName);

				validatAndeEnterValueToTextField(workspaceDetailsDescLabel, workspaceDetailsDescField, workspaceDetailsDescValidation, descriptionContent, placeholderEnterDescription, param.getDescription(), "");
				/**
				verifyVisibilityOfButtons(driver, workspaceDetailsDiscardButton, discardContent, true);
				 */
				flag=clickOnSaveButtonAndValidateToast(true, toastMessageWorkspaceCreated);
				/**
				verifyVisibilityOfButtons(driver, workspaceDetailsDiscardButton, discardContent, false);
				 */
				clickOnWorkspacesTab();

				BaseSuite.reportLog(hyphenContent+" Verifying workspace details after created "+hyphenContent);
				/***
				flag=searchFunctionalityMethod(flag, workspaceListingSearchField, workspaceListingSearchButton, placeholderSearchWorkspace, placeholderSearchWorkspace, workspaceName);

				if (flag) {

					validateWorkspaceDetailsOnListingPage(workspaceName, param.getDescription(),
							param.getAccountName(), param.getWorkspaceType());

					flag=searchWorkspaceNameOnEachPageAndClickOn(returnElement(workspaceListingWorkspaceName, dynamicName, param.getWorkspaceName()), param.getWorkspaceName());

					viewWorkspaceFunctionality(param.getAccountName(), param.getWorkspaceName(), param.getDescription(),
							param.getWorkspaceType(), "", "");


				}
				 */
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" createWorkspaceFunctionalityNOUI :: "+e.toString());
			flag=false;
		}
		return flag;
	}

}
