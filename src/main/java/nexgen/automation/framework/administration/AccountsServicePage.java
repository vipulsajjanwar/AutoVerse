package nexgen.automation.framework.administration;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class AccountsServicePage extends PageUtil {

	WebDriver driver;

	public AccountsServicePage(WebDriver driver) {
		this.driver = driver;
	}

	protected static final Logger log = Logger.getLogger(AccountsServicePage.class);
	static String dirPath=System.getProperty("user.dir");

	public final String accountsEXCELFILEPATH = System.getProperty("user.dir")+ Constant.NEXTGEN_ACCOUNT_TESTDATA_EXCEL_PATH;
	public static final String ACCOUNTPRIVILEGEFORBIDDENMESSAGE=prop.getProperty("workflow.toast.forbidden.Message");
	public final String accountName=BaseSuite.accountName;
	public final String workspaceNameToSearch=PageUtil.getWorkspaceName("", false);
	boolean isrelease5Flag=Boolean.parseBoolean(prop.getProperty("isrelease5orNot"));
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
	By accountSubModuleTab=getElementLocator(prop.getProperty("account.submodule.tab"));	
	By accountBreadcrumbHomeLink=getElementLocator(prop.getProperty("account.breadcrumb.home"));
	By accountBreadcrumbAdminLink=getElementLocator(prop.getProperty("account.breadcrumb.administration"));
	By accountBreadcrumbAccountsLabel=getElementLocator(prop.getProperty("account.breadcrumb.accounts"));
	By accountBreadcrumbAccountseLink=getElementLocator(prop.getProperty("account.breadcrumb.accountsLink"));

	By accountPageTitle=getElementLocator(prop.getProperty("account.page.title"));	
	By accountListingSearchField=getElementLocator(prop.getProperty("account.listing.search.field"));
	By accountListingSearchButton=getElementLocator(prop.getProperty("account.listing.search.button"));
	By accountListingSearchClear=getElementLocator(prop.getProperty("account.listing.search.clear"));	
	By accountListingNewAccountButton=getElementLocator(prop.getProperty("account.listing.newaccount.button"));
	By accountListingRefreshIcon=getElementLocator(prop.getProperty("account.listing.refresh.icon"));
	By accountListingColumnName=getElementLocator(prop.getProperty("account.listing.column.name"));
	By accountListingColumnDescription=getElementLocator(prop.getProperty("account.listing.column.description"));
	By accountListingColumnUpdatedBy=getElementLocator(prop.getProperty("account.listing.column.updatedby"));
	By accountListingPaginationBar=getElementLocator(prop.getProperty("account.listing.pagination.bar"));
	By accountListingPaginationMsg=getElementLocator(prop.getProperty("account.listing.pagination.info"));
	By accountListingNextPageArrow=getElementLocator(prop.getProperty("account.listing.nextpageArrow"));
	By accountListingNoRecordsToDisplay=getElementLocator(prop.getProperty("account.listing.norecordstodisplay"));
	By accountListingDescriptionList=getElementLocator(prop.getProperty("account.listing.descriptionList"));

	By accountDetailsDiscardHandle=getElementLocator(prop.getProperty("account.details.handle.discard"));
	By accountDetailsAccountId=getElementLocator(prop.getProperty("account.details.breadcrumb.accountid"));
	By accountDetailsBreadcrumbCreatenewaccount=getElementLocator(prop.getProperty("account.details.breadcrumb.createnewaccount"));
	By accountDetailsAccountNameLabel=getElementLocator(prop.getProperty("account.details.account.name.label"));
	By accountDetailsAccountNameField=getElementLocator(prop.getProperty("account.details.account.name.field"));
	By accountDetailsAccountNameValidation=getElementLocator(prop.getProperty("account.details.account.name.validation"));
	By accountDetailsDescNameLabel=getElementLocator(prop.getProperty("account.details.description.label"));
	By accountDetailsDescField=getElementLocator(prop.getProperty("account.details.description.field"));
	By accountDetailsDescValidation=getElementLocator(prop.getProperty("account.details.description.validation"));
	By accountDetailsSaveButton=getElementLocator(prop.getProperty("account.details.save.button"));
	By accountDetailsDiscardButton=getElementLocator(prop.getProperty("account.details.discard.button"));
	By accountDetailsUserGroupTab=getElementLocator(prop.getProperty("account.details.usersgroup.tab"));
	By accountDetailsWorkspacesTab=getElementLocator(prop.getProperty("account.details.workspaces.tab"));

	By accountDetailsUserGroupAssignButton=getElementLocator(prop.getProperty("account.details.button.assign.users"));
	By accountDetailsUserGroupRefreshButton=getElementLocator(prop.getProperty("account.details.button.users.refresh"));
	By accountDetailsUserGroupDeleteButton=getElementLocator(prop.getProperty("account.details.button.users.delete"));
	By accountDetailsUserGroupSearchField=getElementLocator(prop.getProperty("account.details.search.user.field"));
	By accountDetailsUserGroupSearchButton=getElementLocator(prop.getProperty("account.details.search.user.button"));
	By accountDetailsUserGroupSearchClear=getElementLocator(prop.getProperty("account.details.search.user.clear"));
	By accountDetailsUserGroupMastercheckbox=getElementLocator(prop.getProperty("account.details.users.mastercheckbox"));
	By accountDetailsUserGroupNameColumn=getElementLocator(prop.getProperty("account.details.users.column.name"));
	By accountDetailsUserGroupTypeColumn=getElementLocator(prop.getProperty("account.details.users.column.type"));
	By accountDetailsUserGroupRoleColumn=getElementLocator(prop.getProperty("account.details.users.column.role"));
	By accountDetailsUserGroupScopeColumn=getElementLocator(prop.getProperty("account.details.users.column.scope"));
	By accountDetailsUserGroupNoRecordsToDisplay=getElementLocator(prop.getProperty("account.details.users.NoRecordsToDisplay"));
	By accountDetailsUserGroupPaginationbar=getElementLocator(prop.getProperty("account.details.users.pagination.bar"));
	By accountDetailsUserGroupPaginationInfo=getElementLocator(prop.getProperty("account.details.users.pagination.info"));

	By accountDetailsWorkspacesAddButton=getElementLocator(prop.getProperty("account.details.button.add.workspace"));
	By accountDetailsWorkspacesRefreshButton=getElementLocator(prop.getProperty("account.details.button.addWorkspace.refresh"));
	By accountDetailsWorkspacesSearchField=getElementLocator(prop.getProperty("account.details.search.workspace.field"));
	By accountDetailsWorkspacesSearchButton=getElementLocator(prop.getProperty("account.details.search.workspace.button"));
	By accountDetailsWorkspacesSearchClear=getElementLocator(prop.getProperty("account.details.search.workspace.clear"));
	By accountDetailsWorkspacesNameColumn=getElementLocator(prop.getProperty("account.details.workspace.column.name"));
	By accountDetailsWorkspacesDescColumn=getElementLocator(prop.getProperty("account.details.workspace.column.desc"));
	By accountDetailsWorkspacesAccountColumn=getElementLocator(prop.getProperty("account.details.workspace.column.account"));
	By accountDetailsWorkspacesNoRecordsToDisplay=getElementLocator(prop.getProperty("account.details.workspace.NoRecordsToDisplay"));
	By accountDetailsWorkspacesPaginationBar=getElementLocator(prop.getProperty("account.details.workspace.pagination.bar"));
	By accountDetailsWorkspacesPaginationInfo=getElementLocator(prop.getProperty("account.details.workspace.pagination.info"));

	By accountDetailsPopupDiscardTitle=getElementLocator(prop.getProperty("account.details.popup.discard.title"));
	By accountDetailsPopupDiscardContent=getElementLocator(prop.getProperty("account.details.popup.discard.content"));
	By accountDetailsPopupDiscardButton=getElementLocator(prop.getProperty("account.details.popup.discard.discardbutton"));
	By accountDetailsPopupDiscardCancelButton=getElementLocator(prop.getProperty("account.details.popup.discard.cancelbutton"));

	By accountDetailsUserGroupPopupDeleteTitle=getElementLocator(prop.getProperty("account.details.popup.UserGroupDelete.title"));
	By accountDetailsUserGroupPopupDeleteContent=getElementLocator(prop.getProperty("account.details.popup.UserGroupDelete.content"));
	By accountDetailsUserGroupPopupDeleteButton=getElementLocator(prop.getProperty("account.details.popup.UserGroupDelete.deletebutton"));
	By accountDetailsUserGroupPopupDeleteCancelButton=getElementLocator(prop.getProperty("account.details.popup.UserGroupDelete.cancelbutton"));

	By workspaceDetailsSidebarRoleLabel=getElementLocator(prop.getProperty("account.details.sidebar.assign.users.role.label"));
	By workspaceDetailsSidebarRoleField=getElementLocator(prop.getProperty("account.details.sidebar.assign.users.role.field"));
	By workspaceDetailsSidebarRoleDropdown=getElementLocator(prop.getProperty("account.details.sidebar.assign.users.role.dropdown"));
	By workspaceDetailsSidebarRoleSelect=getElementLocator(prop.getProperty("account.details.sidebar.assign.users.role.select"));

	By workspaceDetailsSidebarAssignToLabel=getElementLocator(prop.getProperty("account.details.sidebar.assign.access.to.label"));
	By workspaceDetailsSidebarAssignToField=getElementLocator(prop.getProperty("account.details.sidebar.assign.access.to.field"));
	By workspaceDetailsSidebarAssignToDropdown=getElementLocator(prop.getProperty("account.details.sidebar.assign.access.to.dropdown"));
	By workspaceDetailsSidebarAssignToSelect=getElementLocator(prop.getProperty("account.details.sidebar.assign.users.role.select"));

	By workspaceDetailsSidebarAddUserTitle=getElementLocator(prop.getProperty("account.details.sidebar.assign.users.title"));
	By workspaceDetailsSidebarAddUserCross=getElementLocator(prop.getProperty("account.details.sidebar.assign.users.cross"));
	By workspaceDetailsSidebarAddUserLabel=getElementLocator(prop.getProperty("account.details.sidebar.assign.users.Userlabel"));
	By workspaceDetailsSidebarAddUserSearchField=getElementLocator(prop.getProperty("account.details.sidebar.assign.users.searchfield"));
	By workspaceDetailsSidebarAddUserLoadMore=getElementLocator(prop.getProperty("account.details.sidebar.assign.users.loadmore"));
	By workspaceDetailsSidebarAddUserCancelButton=getElementLocator(prop.getProperty("account.details.sidebar.assign.users.cancelButton"));
	By workspaceDetailsSidebarAddUserAssignButton=getElementLocator(prop.getProperty("account.details.sidebar.assign.users.addbutton"));
	By workspaceDetailsSidebarAddUserListCount=getElementLocator(prop.getProperty("account.details.sidebar.assign.users.listcount"));

	By workspaceDetailsSidebarSelectGroupLabel=getElementLocator(prop.getProperty("account.details.sidebar.assign.group.grouplabel"));
	By workspaceDetailsSidebarSelectGroupField=getElementLocator(prop.getProperty("account.details.sidebar.assign.group.searchfield"));

	By accountDetailsSidebarAddWorkspaceTitle=getElementLocator(prop.getProperty("account.details.sidebar.addworkspace.title"));
	By accountDetailsSidebarAddWorkspaceCrossIcon=getElementLocator(prop.getProperty("account.details.sidebar.addworkspace.crossicon"));
	By accountDetailsSidebarAddWorkspaceWorkspaceLabel=getElementLocator(prop.getProperty("account.details.sidebar.addworkspace.workspace.label"));
	By accountDetailsSidebarAddWorkspaceWorkspaceField=getElementLocator(prop.getProperty("account.details.sidebar.addworkspace.workspace.field"));
	By accountDetailsSidebarAddWorkspaceWorkspaceValidation=getElementLocator(prop.getProperty("account.details.sidebar.addworkspace.workspace.validation"));
	By accountDetailsSidebarAddWorkspaceDescLabel=getElementLocator(prop.getProperty("account.details.sidebar.addworkspace.Desc.label"));
	By accountDetailsSidebarAddWorkspaceDescField=getElementLocator(prop.getProperty("account.details.sidebar.addworkspace.Desc.field"));
	By accountDetailsSidebarAddWorkspaceDescValidation=getElementLocator(prop.getProperty("account.details.sidebar.addworkspace.Desc.validation"));
	By accountDetailsSidebarAddWorkspaceTypeLabel=getElementLocator(prop.getProperty("account.details.sidebar.addworkspace.type.label"));
	By accountDetailsSidebarAddWorkspaceTypeField=getElementLocator(prop.getProperty("account.details.sidebar.addworkspace.type.field"));
	By accountDetailsSidebarAddWorkspaceAddButton=getElementLocator(prop.getProperty("account.details.sidebar.addworkspace.add.button"));
	By accountDetailsSidebarAddWorkspaceCancelButton=getElementLocator(prop.getProperty("account.details.sidebar.addworkspace.cancel.button"));

	By accountListingButtonsCount=getElementLocator(prop.getProperty("button.count.listing.accounts"));
	By accountDetailsBeforeCreateButtonsCount=getElementLocator(prop.getProperty("button.count.details.accounts"));

	/** ----------------------  String variables ---------------------------------- **/
	String moduleTab=prop.getProperty("nextgen.hamberger.tab");
	String subModuleTab=prop.getProperty("nextgenmodule.submodule.tab");
	String subModuleHeadingName=prop.getProperty("nextgenmodule.submodule.headingDynamic");
	String dynamicName=prop.getProperty("DynName");
	String nextgenSubModuleDynamic=prop.getProperty("nextgenmodule.submodule.dynamic");

	String accountListingDynamicNameAvatar=prop.getProperty("account.listing.dynamic.name.avatar");
	String accountListingDynamicName=prop.getProperty("account.listing.dynamic.name");
	String accountListingDynamicDesc=prop.getProperty("account.listing.dynamic.description");
	String accountListingDynamicUpdatedBy=prop.getProperty("account.listing.dynamic.updatedby");
	String accountListingDynamicUpdatedDate=prop.getProperty("account.listing.dynamic.updateddate");

	String accountDetailsBreadcrumbDynamicName=prop.getProperty("account.details.breadcrumb.dynamic.accountName");
	String accountDetailsDynamicTitle=prop.getProperty("account.details.dynamic.page.title");
	String accountDetailsDynamicAvatar=prop.getProperty("account.details.dynamic.page.avatar");

	String accountDetailsUserGroupNameDynamic=prop.getProperty("account.details.users.namedynamic");
	String accountDetailsUserGroupStatusDynamic=prop.getProperty("account.details.users.statusdynamic");
	String accountDetailsUserGroupCheckboxDynamic=prop.getProperty("account.details.users.checkbox.namedynamic");
	String accountDetailsUserGroupAvatarDynamic=prop.getProperty("account.details.users.name.avatar");
	String accountDetailsUserGroupAdminIconDynamic=prop.getProperty("account.details.users.nameAdminIcondynamic");
	String accountDetailsUserGroupUserNameTypeDynamic=prop.getProperty("account.details.users.name.type");
	String accountDetailsUserGroupGroupNameTypeDynamic=prop.getProperty("account.details.groups.name.type");
	String accountDetailsUserGroupRoleDynamic=prop.getProperty("account.details.users.name.role.dynamic");
	String accountDetailsUserGroupScopeDynamic=prop.getProperty("account.details.users.name.scope.dynamic");

	String accountDetailsWorkspaceDynamicName=prop.getProperty("account.details.workspaces.namedynamic");
	String accountDetailsDataTestingWorkspaceDynamicAvatar=prop.getProperty("account.details.workspaces.avatardynamic");
	String accountDetailsDataMonitoringWorkspaceDynamicAvatar=prop.getProperty("account.details.DataMonitoringWorkspaces.avatardynamic");
	String accountDetailsWorkspaceDescription=prop.getProperty("account.details.workspaces.description");
	String accountDetailsWorkspaceAccount=prop.getProperty("account.details.workspaces.account");
	String accountDetailsWorkspaceUpdatedBy=prop.getProperty("account.details.workspaces.updatedby");
	String accountDetailsWorkspaceUpdatedDate=prop.getProperty("account.details.workspaces.updateddate");

	String workspaceDetailsSidebarRoleDynamic=prop.getProperty("account.details.sidebar.assign.users.role.dynamic");
	String workspaceDetailsSidebarAssignToDynamic=prop.getProperty("account.details.sidebar.assign.access.to.select.dynamic");
	String workspaceDetailsSidebarFullNameDynamic=prop.getProperty("account.details.sidebar.assign.users.fullnamedynamic");
	String workspaceDetailsSidebarFullNameCheckboxDynamic=prop.getProperty("account.details.sidebar.assign.users.fullnamecheckboxdynamic");
	String workspaceDetailsSidebarSelectGroup=prop.getProperty("account.details.sidebar.assign.group.select");

	String placeholderSearchAccount=prop.getProperty("account.placeholder.search.account");
	String placeholderSearchUserGroup=prop.getProperty("account.placeholder.searchusergroup");
	String placeholderSearchWorkspace=prop.getProperty("account.placeholder.searchworkspace");
	String placeholderEnterAccountName=prop.getProperty("account.placeholder.enteraccountName");
	String placeholderEnterDescription=prop.getProperty("account.placeholder.enterdescption");
	String placeholderSearchUser=prop.getProperty("placeholder.search.user");
	String placeholderSelectGroups=prop.getProperty("placehloder.select.groups");
	String placeholderEnterWorkspaceName=prop.getProperty("account.placehloder.enterWorkspaceName");

	String fieldEmptyAccountName=prop.getProperty("account.validation.empty.name");
	String fieldEmptyWorkspaceName=prop.getProperty("account.validation.empty.workspacename");

	String popupDiscardAccountTitle=prop.getProperty("account.title.single.discardworkspace");
	String popupDiscardAccountContent=prop.getProperty("account.content.single.discardworkspace");

	String popupDiscardUserGroupDeleteTitle=prop.getProperty("account.title.single.UserGroupDelete");
	String popupDiscardUserGroupDeleteContent=prop.getProperty("account.content.single.UserGroupDelete");
	String popupDiscardMultiUserGroupDeleteContent=prop.getProperty("account.content.multiple.UserGroupDelete");

	String toastMsgAccountCreated=prop.getProperty("account.toast.workspacecreated");
	String toastMsgWorkspaceCreated=prop.getProperty("account.toast.workspacecreated");

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
	String createNewAccountContent="Create New Account";
	String moduleContent=prop.getProperty("String.moduleContent");
	String subModuleContent=prop.getProperty("String.subModuleContent");
	String columnContent=prop.getProperty("String.columnContent");
	String tabContent=prop.getProperty("String.tabContent");
	String iconContent=prop.getProperty("String.iconContent");
	String newAccountContent="New Account";
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
	String nameContent="Name";
	String verifyButtonContent=" Verifying buttons on Accounts details page ";
	String verifyTabContent=" Verifying tabs on Accounts details page ";
	String accountListingPageContent="Accounts listing page";
	String addButtonContent="Add";
	String testingContent="Testing";
	String descContent=prop.getProperty("string.descriptionContent");
	static String workspaceNametitleContent="workspaceName";

	/** ----------------------  Generic methods ---------------------------------- **/

	public boolean validateElement(By locator, String label, String type) {
		return validateElement(driver, locator, label, type);

	}

	public void handleDiscardWindow(By locator, String button) {
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if (isDisplayed(driver, locator, 5)) {
				clickOnButton(driver, locator, button, true);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" handleDiscardWindow :: "+e.toString());

		}
	}

	public boolean searchFunctionalityMethod(boolean flag, By searchbar, By searchButton,String searchLabel, String placeholder, String searchValue ) {
		String methodName = "searchFunctionalityMethod";

		try {
			if(flag) {
				isDisplayedInLoop(driver, 3, searchbar);

				if(isDisplayed(driver, searchbar)) {

					flag=isClickable(driver, searchbar,searchBoxLabel, flag);

					if(flag) {

						flag=verifySearchField(driver, searchbar, searchLabel, placeholder);

						flag=enterValueToField(driver, flag, searchbar, searchButton, searchLabel, searchValue);

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

	public boolean searchNameOnEachPageAndClickOn(By locator,String label,By nextpageLocator, String name) {

		boolean flag=true;
		boolean nextpageFlag=true;
		int pn=0;

		try {

			do {

				BaseSuite.reportLog("searching "+label+" name : "+name+" on page number :"+(pn+1));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 3, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportLog(label+" name :  "+name+" found on page number :"+(pn+1));

					flag=clickOnButton(driver, locator, name, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					break;
				}
				if(isDisplayed(driver, nextpageLocator)) {

					String status = getAttribute(driver, nextpageLocator, attributeClass);

					if (!status.contains("disable")) {

						BaseSuite.reportLog("searched "+label+" name : "+name+" not found on page number :"+(pn+1));

						clickOnButton(driver, nextpageLocator, "next page", true);
						pn++;
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					} else {
						BaseSuite.reportLog("Page arrow :: next page is disabled");
						nextpageFlag=false;
					}

				}

			}while(nextpageFlag);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchNameOnEachPageAndClickOn :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public void getTableForTestScenario(List<String> list) {

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
			BaseSuite.reportLog(createHtmlTable1(table,"Test Scenarios"));

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
			isDisplayedInLoop(driver, 3, locator);

			javascript(driver, scrollToElementArg, locator);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, locator)) {			

				checkFieldEnabledOrNot(state, locator, label);

				checkExpectedValueWithActual(driver,flag, locator, label,expectedValue, true);

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

		if(!flag) { return flag;}

		isDisplayedInLoop(driver, 3, titleLocator);

		String removetitle = getText(driver, titleLocator);

		flag = stringContainsOutput(removetitle, title, true);

		if(!flag) { return flag;}

		String removecontents = getText(driver, contentLocator);

		flag = stringContainsOutput(removecontents, content, true);

		return flag;
	}

	public boolean selectcheckbox(By locator, String label) {
		boolean flag=true;
		isDisplayedInLoop(driver, 3, locator);

		if(isDisplayed(driver, locator)) {

			String acs=getAttribute(driver,locator, attributeClass);

			if(!acs.contains(checkContent) || acs.contains(uncheckContent)) {

				BaseSuite.reportLog(" Clicking on checkbox "+label);

				isDisplayedInLoop(driver, 3, locator);

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

	public void navigateToLink(By linkLocator,By validateLocator, String label) {

		try {

			if(!label.isEmpty()) {
				BaseSuite.reportLog("-------------- Navigating to link "+label+" ---------------");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				clickOnButton(driver, linkLocator, label, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				/**	handleDiscardWindow();**/

				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				waitForExecution(3000);

				validateIsDisplayedOrNot(driver, validateLocator, label, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" navigateToLink :: "+e.toString());
		}

	}

	/** ----------------------  Main methods ---------------------------------- **/

	public static DataTestingParameters setAccounteServiceParamUsingExcel(String filePath, String sheetName, int rowNumber) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();

		try {

			param.setTestScenarioName(xl.readUsingColName(filePath,sheetName, rowNumber, "testScenario"));
			param.setScenarioType(xl.readUsingColName(filePath,sheetName, rowNumber, "scenarioType"));
			/**param.setDescription(xl.readUsingColName(filePath,sheetName, rowNumber, "AccountDescription"));*/
			param.setDescription(PageUtil.getAccountDescription());
			param.setAddUser(xl.readUsingColName(filePath,sheetName, rowNumber, "addUser"));
			param.setRemoveUser(xl.readUsingColName(filePath,sheetName, rowNumber, "removeUser"));
			param.setAddGroup(xl.readUsingColName(filePath,sheetName, rowNumber, "addGroup"));
			param.setRemoveGroup(xl.readUsingColName(filePath,sheetName, rowNumber, "removeGroup"));
			param.setSearchAccountName(xl.readUsingColName(filePath,sheetName, rowNumber, "searchAccount"));
			param.setUpdateAccountName(xl.readUsingColName(filePath,sheetName, rowNumber, "updateAccountName"));
			param.setUpdateAccountDescription(xl.readUsingColName(filePath,sheetName, rowNumber, "updateAccountDescription"));
			/**param.setAccountName(xl.readUsingColName(filePath,sheetName, rowNumber, "accountName"));**/
			param.setAccountName(BaseSuite.accountName);
			param.setWorkspaceName(xl.readUsingColName(filePath,sheetName, rowNumber, workspaceNametitleContent));
			param.setWorkspaceType(xl.readUsingColName(filePath,sheetName, rowNumber, "WorkspaceType"));
			param.setFieldValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber, "fieldValidation"));
			param.setToastValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber, "toastValidation"));
			param.setAddWorkspace(xl.readUsingColName(filePath,sheetName, rowNumber, "addWorkspace"));
			param.setUpdateWorkspaceDescription(xl.readUsingColName(filePath,sheetName, rowNumber, "addWorkspaceDesc"));

		} catch (Exception e) {
			e.printStackTrace();
			BaseSuite.reportErrorLog("error occurs while setAccounteServiceParamUsingExcel "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setAccounteServiceParamUsingExcelInvalid(String filePath, String sheetName, int rowNumber) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();

		try {

			param.setTestScenarioName(xl.readUsingColName(filePath,sheetName, rowNumber, "testScenario"));
			param.setScenarioType(xl.readUsingColName(filePath,sheetName, rowNumber, "scenarioType"));
			param.setDescription(xl.readUsingColName(filePath,sheetName, rowNumber, "AccountDescription"));
			/** param.setDescription(PageUtil.getAccountDescription()); */
			param.setAddUser(xl.readUsingColName(filePath,sheetName, rowNumber, "addUser"));
			param.setRemoveUser(xl.readUsingColName(filePath,sheetName, rowNumber, "removeUser"));
			param.setAddGroup(xl.readUsingColName(filePath,sheetName, rowNumber, "addGroup"));
			param.setRemoveGroup(xl.readUsingColName(filePath,sheetName, rowNumber, "removeGroup"));
			/**param.setSearchAccountName(xl.readUsingColName(filePath,sheetName, rowNumber, "searchAccount"));*/
			param.setSearchAccountName(BaseSuite.accountName);
			param.setUpdateAccountName(xl.readUsingColName(filePath,sheetName, rowNumber, "updateAccountName"));
			param.setUpdateAccountDescription(xl.readUsingColName(filePath,sheetName, rowNumber, "updateAccountDescription"));
			param.setAccountName(xl.readUsingColName(filePath,sheetName, rowNumber, "accountName"));
			/** param.setAccountName(PageUtil.getAccountName()); */
			param.setWorkspaceName(xl.readUsingColName(filePath,sheetName, rowNumber, workspaceNametitleContent));
			param.setWorkspaceType(xl.readUsingColName(filePath,sheetName, rowNumber, "WorkspaceType"));
			param.setFieldValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber, "fieldValidation"));
			param.setToastValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber, "toastValidation"));
			param.setAddWorkspace(xl.readUsingColName(filePath,sheetName, rowNumber, "addWorkspace"));
			param.setUpdateWorkspaceDescription(xl.readUsingColName(filePath,sheetName, rowNumber, "addWorkspaceDesc"));

		} catch (Exception e) {
			e.printStackTrace();
			BaseSuite.reportErrorLog("error occurs while setAccounteServiceParamUsingExcel "+e.toString());
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
			param.setRole(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"UserRoleAccount"));
			param.setScope(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"UserScopeAccount"));
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
			param.setRole(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"GroupRoleAccount"));
			param.setScope(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"GroupScopeAccount"));
			param.setAdminFlag(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"AdminFlag"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setGroupsParamUsingExcel "+e.toString());
		}
		return param;

	}
	public static DataTestingParameters setWorkspacesParamUsingExcel(String filePath, String workspaceName) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String userNameColumn=workspaceNametitleContent;
		String usersheet="WorkspaceSheet";
		try {

			param.setWorkspaceName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, workspaceName,userNameColumn));
			param.setDescription(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, workspaceName,"workspaceDescription"));
			param.setWorkspaceType(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, workspaceName,"workspaceType"));
			/**param.setAccountName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, workspaceName,"accountName"));
			 */
			param.setAccountName(BaseSuite.accountName);
		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setWorkspacesParamUsingExcel "+e.toString());
		}
		return param;

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

	public boolean clickOnAccountsTab() {

		boolean flag = false;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 0, accountListingNewAccountButton);

			if(!isDisplayed(driver, accountListingNewAccountButton)) {

				isDisplayedInLoop(driver, 0, workspaceDetailsSidebarAddUserCancelButton);
				if(isDisplayed(driver, workspaceDetailsSidebarAddUserCancelButton)) {
					displayAndClick(driver, workspaceDetailsSidebarAddUserCancelButton);
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}

				isDisplayedInLoop(driver, 3, nextgenSubModuleAccounts);

				if(isDisplayed(driver, nextgenSubModuleAccounts)) {

					flag = isClickable(driver, nextgenSubModuleAccounts, accountsContent+" tab", true);

					if(flag) {

						BaseSuite.reportLog("Clicking on "+accountsContent+" tab");

						displayAndClick(driver, nextgenSubModuleAccounts);

						handleDiscardWindow(accountDetailsDiscardHandle, discardContent);

						BaseSuite.validationReportLog("Clicked on "+accountsContent+" tab");

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

						flag=validateElement(accountPageTitle, accountsContent, attributeTitle);

						clickOnButton(driver, accountListingRefreshIcon, refreshContent, true);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					}

				}else {
					BaseSuite.reportFailLog(accountsContent+" tab not visible", "clickOnAccountsTab");
				}
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnAccountsTab :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean clickOnAccountsTab(String expectedToastMessage) {

		boolean flag = false;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, accountListingNewAccountButton);

			if(elementNotVisible(driver, accountListingNewAccountButton)) {

				isDisplayedInLoop(driver, 3, nextgenSubModuleAccounts);

				if(isDisplayed(driver, nextgenSubModuleAccounts)) {

					flag = isClickable(driver, nextgenSubModuleAccounts, accountsContent+" tab", true);

					if(flag) {

						BaseSuite.reportLog("Clicking on "+accountsContent+" tab");

						displayAndClick(driver, nextgenSubModuleAccounts);

						/**handleDiscardWindow();**/
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.validationReportLog("Clicked on "+accountsContent+" tab");

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

						captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,
								"Workspaces tab authorization message");

						validateElement(accountPageTitle, accountsContent, attributeTitle);

						clickOnButton(driver, accountListingRefreshIcon, refreshContent, true);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						flag = captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,
								"Accounts tab authorization message");

					}

				}else {
					BaseSuite.reportFailLog(accountsContent+" tab not visible", "clickOnAccountsTab");
				}
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnAccountsTab :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public void navigateToAdministrationTabs(By linklocator, By validateLocator, String label, String type) {

		navigateToLink(linklocator, validateLocator, label+" "+type);

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		clickOnAccountsTab();

	}

	public boolean clickOnRefreshOnAccountsListingPage() {

		return clickOnButton(driver, accountListingRefreshIcon, refreshContent, true);
	}

	public boolean validateAccountsListingPage() {
		boolean flag=true;
		HomePage hp=new HomePage(driver);
		try {

			hp.validateNextgenIcedqModuleAndAdministrationSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Accounts listing page "+hyphenContent);

			validateElement(accountBreadcrumbHomeLink, homeContent, hyperlinkContent);

			validateElement(accountBreadcrumbAdminLink, administrationContent, hyperlinkContent);

			validateElement(accountBreadcrumbAccountsLabel, accountsContent, labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying Title and Search field Accounts listing page "+hyphenContent);

			verifyIndividualLabel(driver, accountPageTitle, accountsContent);

			verifySearchField(driver, accountListingSearchField, placeholderSearchAccount, placeholderSearchAccount);

			validateElement(accountListingSearchButton, placeholderSearchAccount, "button");

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Accounts listing page "+hyphenContent);

			validateButtons(driver, accountListingButtonsCount, 2);

			verifyVisibilityOfButtons(driver, accountListingNewAccountButton, newAccountContent, true);
			verifyVisibilityOfButtons(driver, accountListingRefreshIcon, refreshContent, true);

			BaseSuite.reportLog(hyphenContent+"  Verifying Columns on accounts listing page "+hyphenContent);

			validateElement(accountListingColumnName, "Name",columnContent);
			validateElement(accountListingColumnDescription, descriptionContent, columnContent);
			validateElement(accountListingColumnUpdatedBy, "Updated By", columnContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on Accounts listing page "+hyphenContent);

			getPaginationDetails(driver,accountListingPaginationMsg, accountListingPaginationBar,accountListingNoRecordsToDisplay, accountListingPageContent);

			BaseSuite.validationReportLog(hyphenContent+" Accounts listing page validated successfully "+hyphenContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateAccountsListingPage :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean clickOnNewAccountButton(String icedqUser) {

		boolean flag = true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 3, accountListingNewAccountButton);

			if(isDisplayed(driver, accountListingNewAccountButton)) {

				clickOnButton(driver, accountListingNewAccountButton, newAccountContent, flag);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

					String pgTitle=getAttribute(driver, returnElement(accountDetailsDynamicTitle, dynamicName, createNewAccountContent), attributeTextContent);

					flag = stringOutput(pgTitle.trim(), createNewAccountContent, true);

				}else{

					flag = captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
							"New Account authorization message");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnNewAccountButton :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateAccountDetailsWorkspaceTabBeforeCreating() {
		boolean flag = true;

		try {
			clickOnButton(driver, accountDetailsWorkspacesTab, workspacesContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog(hyphenContent+verifyTabContent+hyphenContent);

			validateElement(accountDetailsUserGroupTab, usersGroupsContent, tabContent);
			validateElement(accountDetailsWorkspacesTab, workspacesContent, tabContent);

			BaseSuite.reportLog(hyphenContent+" Verifying workspaces tab "+hyphenContent);

			verifySearchField(driver, accountDetailsWorkspacesSearchField, placeholderSearchWorkspace, placeholderSearchWorkspace);

			validateElement(accountDetailsWorkspacesSearchButton, placeholderSearchWorkspace, iconContent);



			verifyVisibilityOfButtons(driver, accountDetailsWorkspacesAddButton, addButtonContent, false);
			verifyVisibilityOfButtons(driver, accountDetailsWorkspacesRefreshButton, refreshContent+" "+workspacesContent, false);

			BaseSuite.reportLog(hyphenContent+" Verifying columns of workspaces tab "+hyphenContent);

			validateElement(accountDetailsWorkspacesNameColumn, nameContent, columnContent);
			validateElement(accountDetailsWorkspacesDescColumn, descriptionContent, columnContent);
			validateElement(accountDetailsWorkspacesAccountColumn, accountContent, columnContent);

			validateElement(accountDetailsWorkspacesNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on workspaces tab "+hyphenContent);

			getPaginationDetails(driver,accountDetailsWorkspacesPaginationInfo, accountDetailsWorkspacesPaginationBar,accountDetailsWorkspacesNoRecordsToDisplay, workspacesContent+" "+tabContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateAccountDetailsWorkspaceTabBeforeCreating :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean validateAccountsDetailPageBeforeCreating(boolean validatebutton) {
		boolean flag = true;
		HomePage hp=new HomePage(driver);
		try {
			hp.validateNextgenIcedqModuleAndAdministrationSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Accounts details page "+hyphenContent);

			validateElement(accountBreadcrumbHomeLink, homeContent, hyperlinkContent);

			validateElement(accountBreadcrumbAdminLink, administrationContent, hyperlinkContent);

			validateElement(accountBreadcrumbAccountseLink, accountsContent, hyperlinkContent);

			validateElement(accountDetailsBreadcrumbCreatenewaccount, createNewAccountContent, labelContent);

			validateElement(returnElement(accountDetailsDynamicTitle, dynamicName, createNewAccountContent), createNewAccountContent, attributeTitle);

			validateElement(returnTwoElements(accountDetailsDynamicAvatar, dynamicName, createNewAccountContent,dynamicType,accountContent), accountContent, iconContent);

			BaseSuite.reportLog(hyphenContent+verifyButtonContent+hyphenContent);

			if(validatebutton) {validateButtons(driver, accountDetailsBeforeCreateButtonsCount, 5);}

			verifyVisibilityOfButtons(driver, accountDetailsSaveButton, saveContent, false);
			verifyVisibilityOfButtons(driver, accountDetailsDiscardButton, discardContent, false);	

			validateElement(accountDetailsAccountNameLabel, accountContent+" "+nameContent, labelContent);
			validateElement(accountDetailsAccountNameField, accountContent+" "+nameContent, fieldContent);
			verifyPlaceHolderValue(driver, accountDetailsAccountNameField, accountContent+" "+nameContent, placeholderEnterAccountName);

			validateElement(accountDetailsDescNameLabel, descriptionContent, labelContent);
			validateElement(accountDetailsDescField, descriptionContent, fieldContent);
			verifyPlaceHolderValue(driver, accountDetailsDescField, descriptionContent, placeholderEnterDescription);

			BaseSuite.reportLog(hyphenContent+verifyTabContent+hyphenContent);

			validateElement(accountDetailsUserGroupTab, usersGroupsContent, tabContent);
			validateElement(accountDetailsWorkspacesTab, workspacesContent, tabContent);

			BaseSuite.reportLog(hyphenContent+" Verifying users/groups tab "+hyphenContent);

			verifySearchField(driver, accountDetailsUserGroupSearchField, placeholderSearchUserGroup, placeholderSearchUserGroup);

			validateElement(accountDetailsUserGroupSearchButton, placeholderSearchUserGroup, iconContent);

			verifyVisibilityOfButtons(driver, accountDetailsUserGroupAssignButton, assignContent, false);
			verifyVisibilityOfButtons(driver, accountDetailsUserGroupRefreshButton, refreshContent+" "+usersGroupsContent, false);
			verifyVisibilityOfButtons(driver, accountDetailsUserGroupDeleteButton, deleteContent+" "+usersGroupsContent, false);

			BaseSuite.reportLog(hyphenContent+" Verifying columns of users/groups tab "+hyphenContent);

			validateElement(accountDetailsUserGroupMastercheckbox, masterContent, checkboxContent);
			validateElement(accountDetailsUserGroupNameColumn, nameContent, columnContent);
			validateElement(accountDetailsUserGroupTypeColumn, typeContent, columnContent);
			validateElement(accountDetailsUserGroupRoleColumn, roleContent, columnContent);
			validateElement(accountDetailsUserGroupScopeColumn, scopeContent, columnContent);

			validateElement(accountDetailsUserGroupNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on users/groups tab "+hyphenContent);

			getPaginationDetails(driver,accountDetailsUserGroupPaginationInfo, accountDetailsUserGroupPaginationbar,accountDetailsUserGroupNoRecordsToDisplay, usersGroupsContent+" "+tabContent);

			validateAccountDetailsWorkspaceTabBeforeCreating();

			clickOnButton(driver, accountDetailsUserGroupTab, usersGroupsContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateAccountsDetailPageBeforeCreating :: "+e.toString());
			flag=false;
		}
		return flag;
	}


	public boolean searchAccountAndClickOnName(String accountName) {
		boolean flag =true;

		try {

			searchFunctionalityMethod(flag, accountListingSearchField, accountListingSearchButton, placeholderSearchAccount, placeholderSearchAccount, accountName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(elementNotVisible(driver, accountListingNoRecordsToDisplay)) {

				flag=searchNameOnEachPageAndClickOn(returnElement(accountListingDynamicName, dynamicName, accountName), accountName, accountListingNextPageArrow, accountName);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}else {
				BaseSuite.reportFailLog(noRecordsToDisplayContent+isVisibleContent,"searchAccountAndClickOnName");
				searchFunctionalityMethod(flag, accountListingSearchField, accountListingSearchButton, placeholderSearchAccount, placeholderSearchAccount, "");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchAccountAndClickOnName "+e.toString());
			flag=false;
		}

		return flag;
	}

	public String getAccountIdOnAccountDetailsPage() {
		String id =null;
		try {
			isDisplayedInLoop(driver, 3, accountDetailsAccountId);

			if(isDisplayed(driver, accountDetailsAccountId)) {

				id = getText(driver, accountDetailsAccountId);

				id = id.replaceAll(regexToRemoveBracess, "");

				BaseSuite.reportLog("Account id is :: "+id);
			}else {
				BaseSuite.reportFailLog("Account id is not visible ", "getAccountIdOnAccountDetailsPage");

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" getAccountIdOnAccountDetailsPage :: "+e.toString());

		}
		return id;
	}

	public String viewExistingAccountDetailPage(String accountName, String accountDescription) {
		HomePage hp=new HomePage(driver);
		String totalRecords="";
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			hp.validateNextgenIcedqModuleAndAdministrationSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Account details page "+hyphenContent);

			validateElement(accountBreadcrumbHomeLink, homeContent, hyperlinkContent);

			validateElement(accountBreadcrumbAdminLink, administrationContent, hyperlinkContent);

			validateElement(accountBreadcrumbAccountseLink, accountsContent, hyperlinkContent);

			validateElement(returnElement(accountDetailsBreadcrumbDynamicName, dynamicName, accountName), accountName, labelContent);

			getAccountIdOnAccountDetailsPage();

			validateElement(returnTwoElements(accountDetailsDynamicAvatar, dynamicName, accountName,dynamicType,accountContent), accountContent, iconContent);

			validateElement(returnElement(accountDetailsDynamicTitle, dynamicName, accountName),accountName, attributeTitle);

			BaseSuite.reportLog(hyphenContent+verifyButtonContent+hyphenContent);

			verifyVisibilityOfButtons(driver, accountDetailsSaveButton, saveContent, false);
			verifyVisibilityOfButtons(driver, accountDetailsDiscardButton, discardContent, false);	

			validateElement(accountDetailsAccountNameLabel, accountContent+" "+nameContent, labelContent);
			viewAndValidateField(accountDetailsAccountNameField, accountContent+" "+nameContent, accountName, true);

			validateElement(accountDetailsDescNameLabel, descriptionContent, labelContent);
			viewAndValidateField(accountDetailsDescField, workspaceNameContent, accountDescription, true);

			BaseSuite.reportLog(hyphenContent+verifyTabContent+hyphenContent);

			validateElement(accountDetailsUserGroupTab, usersGroupsContent, tabContent);
			validateElement(accountDetailsWorkspacesTab, workspacesContent, tabContent);

			BaseSuite.reportLog(hyphenContent+" Verifying users/groups tab "+hyphenContent);

			verifySearchField(driver, accountDetailsUserGroupSearchField, placeholderSearchUserGroup, placeholderSearchUserGroup);

			validateElement(accountDetailsUserGroupSearchButton, placeholderSearchUserGroup, iconContent);

			verifyVisibilityOfButtons(driver, accountDetailsUserGroupAssignButton, assignContent, true);
			verifyVisibilityOfButtons(driver, accountDetailsUserGroupRefreshButton, refreshContent+" "+usersGroupsContent, true);
			verifyVisibilityOfButtons(driver, accountDetailsUserGroupDeleteButton, deleteContent+" "+usersGroupsContent, false);

			BaseSuite.reportLog(hyphenContent+" Verifying columns of users/groups tab "+hyphenContent);

			validateElement(accountDetailsUserGroupMastercheckbox, masterContent, checkboxContent);
			validateElement(accountDetailsUserGroupNameColumn, nameContent, columnContent);
			validateElement(accountDetailsUserGroupTypeColumn, typeContent, columnContent);
			validateElement(accountDetailsUserGroupRoleColumn, roleContent, columnContent);
			validateElement(accountDetailsUserGroupScopeColumn, scopeContent, columnContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on users/groups tab "+hyphenContent);

			List<String> pageInfo=getPaginationDetails(driver,accountDetailsUserGroupPaginationInfo, accountDetailsUserGroupPaginationbar,accountDetailsUserGroupNoRecordsToDisplay, usersGroupsContent+" "+tabContent);

			totalRecords=pageInfo.get(1);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewExistingAccountDetailPage :: "+e.toString());

		}
		return totalRecords;
	}

	public boolean searchUserInAccountAndRefresh(boolean flag,String fullName) {

		try {
			BaseSuite.reportLog(hyphenContent+" Validate User details access in account :: "+fullName+" "+hyphenContent);

			flag=searchFunctionalityMethod(true, accountDetailsUserGroupSearchField, accountDetailsUserGroupSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, fullName);

			getPaginationDetails(driver, accountDetailsUserGroupPaginationInfo, accountDetailsUserGroupPaginationbar,accountDetailsUserGroupNoRecordsToDisplay, usersGroupsContent+" "+tabContent);

			clickOnButton(driver, accountDetailsUserGroupRefreshButton, refreshContent+" "+usersGroupsContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			getPaginationDetails(driver, accountDetailsUserGroupPaginationInfo, accountDetailsUserGroupPaginationbar,accountDetailsUserGroupNoRecordsToDisplay, usersGroupsContent+" "+tabContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchUserInAccountAndRefresh "+e.toString());
		}

		return flag;
	}

	public boolean searchAndViewAddedUserInAccount(boolean flag,String fullName,String role, String scope, boolean adminflag) {

		try {
			BaseSuite.reportLog(hyphenContent+" Validate User details access in account :: "+fullName+" "+hyphenContent);

			flag=searchFunctionalityMethod(true, accountDetailsUserGroupSearchField, accountDetailsUserGroupSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, fullName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {

				validateElement(returnElement(accountDetailsUserGroupCheckboxDynamic, dynamicName, fullName), fullName, checkboxContent);

				validateElement(returnTwoElements(accountDetailsUserGroupAvatarDynamic, dynamicName, fullName,dynamicType,"User"), fullName, avatarContent);

				validateElement(returnElement(accountDetailsUserGroupNameDynamic, dynamicName, fullName), fullName, hyperlinkContent);

				validateElementVisibility(returnElement(accountDetailsUserGroupAdminIconDynamic, dynamicName, fullName), adminContent, iconContent, adminflag);

				checkExpectedValueWithActual(driver,true,returnElement(accountDetailsUserGroupUserNameTypeDynamic, dynamicName, fullName), fullName+" "+typeContent, "User",true);

				checkExpectedValueWithActual(driver,true,returnElement(accountDetailsUserGroupRoleDynamic, dynamicName, fullName), fullName+" "+roleContent, role,true);

				checkExpectedValueWithActual(driver,true,returnElement(accountDetailsUserGroupScopeDynamic, dynamicName, fullName), fullName+" "+scopeContent, scope,true);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchAndViewAddedUserInAccount "+e.toString());
		}

		return flag;
	}

	public boolean viewAddedUserDetails(String userName) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if (!userName.isEmpty()) {

				if (userName.contains(",")) {

					iceuserName = userName.split(",");

					for (int i = 0; i < iceuserName.length; i++) {

						DataTestingParameters param = setUsersParamUsingExcel(accountsEXCELFILEPATH, iceuserName[i]);

						String fullName = param.getFirstName() + " " + param.getLastName();

						searchAndViewAddedUserInAccount(flag, fullName, param.getRole(), param.getScope(), Boolean.parseBoolean(param.getAdminFlag()));
					}

				} else {

					DataTestingParameters param = setUsersParamUsingExcel(accountsEXCELFILEPATH, userName);

					String fullName = param.getFirstName() + " " + param.getLastName();

					searchAndViewAddedUserInAccount(flag, fullName, param.getRole(), param.getScope(), Boolean.parseBoolean(param.getAdminFlag()));

				}
				displayAndClick(driver, accountDetailsUserGroupSearchField);
				displayAndClick(driver, accountDetailsUserGroupSearchClear);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewAddedUserDetails "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean searchAndViewAddedGroupInAccount(boolean flag,String groupName,String role, String scope, boolean adminflag) {

		try {
			BaseSuite.reportLog(hyphenContent+" Validate group added in account :: "+groupName+" "+hyphenContent);

			flag=searchFunctionalityMethod(true, accountDetailsUserGroupSearchField, accountDetailsUserGroupSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, groupName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {

				validateElement(returnElement(accountDetailsUserGroupCheckboxDynamic, dynamicName, groupName), groupName, checkboxContent);

				validateElement(returnTwoElements(accountDetailsUserGroupAvatarDynamic, dynamicName, groupName,dynamicType,"Group"), groupName, avatarContent);

				validateElement(returnElement(accountDetailsUserGroupNameDynamic, dynamicName, groupName), groupName, hyperlinkContent);

				validateElementVisibility(returnElement(accountDetailsUserGroupAdminIconDynamic, dynamicName, groupName), adminContent, iconContent, adminflag);

				checkExpectedValueWithActual(driver,true,returnElement(accountDetailsUserGroupGroupNameTypeDynamic, dynamicName, groupName), groupName+" Type", "Group",true);

				checkExpectedValueWithActual(driver,true,returnElement(accountDetailsUserGroupRoleDynamic, dynamicName, groupName), groupName+" Role", role,true);

				checkExpectedValueWithActual(driver,true,returnElement(accountDetailsUserGroupScopeDynamic, dynamicName, groupName), groupName+" Scope", scope,true);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchAndViewAddedGroupInAccount "+e.toString());
		}

		return flag;
	}

	public boolean viewAddedGroupDetails(String groupName) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if (!groupName.isEmpty()) {

				if (groupName.contains(",")) {

					iceuserName = groupName.split(",");

					for (int i = 0; i < iceuserName.length; i++) {

						DataTestingParameters param = setGroupsParamUsingExcel(accountsEXCELFILEPATH, iceuserName[i]);

						searchAndViewAddedGroupInAccount(flag, param.getGroupName(), param.getRole(),
								param.getScope(), Boolean.parseBoolean(param.getAdminFlag()));
					}

				} else {

					DataTestingParameters param = setGroupsParamUsingExcel(accountsEXCELFILEPATH, groupName);

					searchAndViewAddedGroupInAccount(flag, param.getGroupName(), param.getRole(), param.getScope(),
							Boolean.parseBoolean(param.getAdminFlag()));

				} 

				displayAndClick(driver, accountDetailsUserGroupSearchField);

				displayAndClick(driver, accountDetailsUserGroupSearchClear);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewAddedGroupDetails "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean viewAddedGroupDetailsNOUI(String groupName) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if (!groupName.isEmpty()) {

				if (groupName.contains(",")) {

					iceuserName = groupName.split(",");

					for (int i = 0; i < iceuserName.length; i++) {

						DataTestingParameters param = setGroupsParamUsingExcel(accountsEXCELFILEPATH, iceuserName[i]);

						flag=searchAndViewAddedGroupInAccountNOUI(flag, param.getGroupName());
					}

				} else {

					DataTestingParameters param = setGroupsParamUsingExcel(accountsEXCELFILEPATH, groupName);

					flag=searchAndViewAddedGroupInAccountNOUI(flag, param.getGroupName());

				} 

				waitForExecution(1000);

				displayAndClick(driver, accountDetailsUserGroupSearchField);

				displayAndClick(driver, accountDetailsUserGroupSearchClear);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewAddedGroupDetailsNOUI "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean searchAndViewAddedGroupInAccountNOUI(boolean flag,String groupName) {

		try {
			BaseSuite.reportLog(hyphenContent+" Validate user/group added in account :: "+groupName+" "+hyphenContent);

			flag=searchFunctionalityMethod(true, accountDetailsUserGroupSearchField, accountDetailsUserGroupSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, groupName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && elementNotVisible(driver, returnElement(accountDetailsUserGroupNameDynamic, dynamicName, groupName))) {

				flag=true;
			}else {
				flag=false;
				BaseSuite.reportLog(hyphenContent+" Already has access in account :: "+groupName+" "+hyphenContent);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchAndViewAddedGroupInAccountNOUI "+e.toString());
		}

		return flag;
	}

	public boolean searchAndViewAddedWorkspaceInAccount(boolean flag,String workspaceName,String description, String account, String workspaceType) {

		try {
			BaseSuite.reportLog(hyphenContent+" Validate workspace added in account :: "+workspaceName+" "+hyphenContent);

			flag=searchFunctionalityMethod(true, accountDetailsWorkspacesSearchField, accountDetailsWorkspacesSearchButton, placeholderSearchWorkspace, placeholderSearchWorkspace, workspaceName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {

				if(workspaceType.equalsIgnoreCase(dataTestingContent)) {

					validateElement(returnTwoElements(accountDetailsDataTestingWorkspaceDynamicAvatar, dynamicName, workspaceName,dynamicType,workspaceType), workspaceType, avatarContent);

				}else {
					validateElement(returnTwoElements(accountDetailsDataMonitoringWorkspaceDynamicAvatar, dynamicName, workspaceName,dynamicType,workspaceType), workspaceType, avatarContent);
				}
				validateElement(returnElement(accountDetailsWorkspaceDynamicName, dynamicName, workspaceName), workspaceName, hyperlinkContent);

				checkExpectedValueWithActual(driver,true,returnElement(accountDetailsWorkspaceDescription, dynamicName, workspaceName), workspaceContent+" "+descriptionContent, description,true);

				checkExpectedValueWithActual(driver,true,returnElement(accountDetailsWorkspaceAccount, dynamicName, workspaceName), accountContent+" "+nameContent, account,true);

				String updatedby=getAttribute(driver, returnElement(accountDetailsWorkspaceUpdatedBy, dynamicName, workspaceName), attributeTitle);

				BaseSuite.reportLog("Workspace updated by : "+updatedby);

				String updateddate=getAttribute(driver, returnElement(accountDetailsWorkspaceUpdatedDate, dynamicName, workspaceName), attributeTextContent);

				BaseSuite.reportLog("Workspace updated date : "+updateddate);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchAndViewAddedWorkspaceInAccount "+e.toString());
		}

		return flag;
	}

	public boolean viewAddedWorkspaceDetails(String workspaceName) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			clickOnButton(driver, accountDetailsWorkspacesTab, workspacesContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if (!workspaceName.isEmpty()) {

				if (workspaceName.contains(",")) {

					iceuserName = workspaceName.split(",");

					for (int i = 0; i < iceuserName.length; i++) {

						DataTestingParameters param = setWorkspacesParamUsingExcel(accountsEXCELFILEPATH, iceuserName[i]);

						searchAndViewAddedWorkspaceInAccount(flag, param.getWorkspaceName(), param.getDescription(),
								param.getAccountName(), param.getWorkspaceType());
					}

				} else {

					DataTestingParameters param = setWorkspacesParamUsingExcel(accountsEXCELFILEPATH, workspaceName);

					searchAndViewAddedWorkspaceInAccount(flag, param.getWorkspaceName(), param.getDescription(),
							param.getAccountName(), param.getWorkspaceType());

				} 

				displayAndClick(driver, accountDetailsWorkspacesSearchField);

				displayAndClick(driver, accountDetailsWorkspacesSearchClear);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, accountDetailsUserGroupTab, usersGroupsContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewAddedGroupDetails "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean clickOnDiscardAccountButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {

			clickOnButton(driver, accountDetailsDiscardButton, discardContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(500);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validatePopupWindowContent(flag, accountDetailsPopupDiscardTitle, accountDetailsPopupDiscardContent, popupDiscardAccountTitle, popupDiscardAccountContent);

			verifyVisibilityOfButtons(driver, accountDetailsPopupDiscardButton, discardContent, true);
			verifyVisibilityOfButtons(driver, accountDetailsPopupDiscardCancelButton, cancelButtonContent, true);

			clickOnButton(driver, accountDetailsPopupDiscardButton, discardContent, tag);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, accountContent+" "+discardContent);
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,accountContent+" "+discardContent);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnDiscardAccountButtonAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnSaveAccountButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {

			clickOnButton(driver, accountDetailsSaveButton, saveContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, accountContent+" "+saveContent);
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,accountContent+" "+saveContent);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnSaveAccountButtonAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public void validateAccountDetailsOnListingPage(String accountName, String description) {

		try {

			waitForExecution(1000);

			BaseSuite.reportLog(hyphenContent+" Verifying account details on account listing page "+hyphenContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateElementVisibility(returnTwoElements(accountListingDynamicNameAvatar, dynamicName, accountName,dynamicType,accountContent), accountContent, avatarContent, true);

			validateElementVisibility(returnElement(accountListingDynamicName, dynamicName, accountName), accountName, hyperlinkContent, true);

			validateValueWithActual(returnElement(accountListingDynamicDesc,  dynamicName, accountName), descriptionContent, description, attributeTextContent);

			String updatedby=getAttribute(driver, returnElement(accountListingDynamicUpdatedBy, dynamicName, accountName), attributeTitle);

			BaseSuite.reportLog("Account updated by : "+updatedby);

			String updateddate=getAttribute(driver, returnElement(accountListingDynamicUpdatedDate, dynamicName, accountName), attributeTextContent);

			BaseSuite.reportLog("Account updated date : "+updateddate);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateAccountDetailsOnListingPage :: "+e.toString());
		}

	}

	//Main

	public boolean viewAccountFunctionality(String accountName,String description, String workspaceName, String users, String groups) {

		boolean flag =true;
		String totalRecords="";	

		try {

			totalRecords=viewExistingAccountDetailPage(accountName,description);

			if(totalRecords.equalsIgnoreCase("0")) {

				validateElement(accountDetailsUserGroupNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);
			}else {

				viewAddedUserDetails(users);

				viewAddedGroupDetails(groups);

				viewAddedWorkspaceDetails(workspaceName);
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewAccountFunctionality :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean updateAccountFunctionality(DataTestingParameters param, String icedqUser) {
		boolean flag =true;

		try {
			viewAccountFunctionality(param.getAccountName(), param.getDescription(),param.getWorkspaceName(),param.getAddUser(), param.getAddGroup());

			validatAndeEnterValueToTextField(driver, accountDetailsAccountNameLabel, accountDetailsAccountNameField, accountDetailsAccountNameValidation, accountContent, placeholderEnterAccountName, param.getUpdateAccountName(), fieldEmptyAccountName);

			validatAndeEnterValueToTextField(driver, accountDetailsDescNameLabel, accountDetailsDescField, accountDetailsDescValidation, descriptionContent, placeholderEnterDescription, param.getUpdateAccountDescription(), "");

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

				flag=clickOnSaveAccountButtonAndValidateToast(false, "");

			}else {

				flag=clickOnSaveAccountButtonAndValidateToast(false, ACCOUNTPRIVILEGEFORBIDDENMESSAGE);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" updateAccountFunctionality :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean createAccountFunctionality(DataTestingParameters param, String icedqUser) {
		boolean flag =true;

		try {

			flag=clickOnNewAccountButton(icedqUser);

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

				validateAccountsDetailPageBeforeCreating(true);

				validatAndeEnterValueToTextField(driver, accountDetailsAccountNameLabel, accountDetailsAccountNameField, accountDetailsAccountNameValidation, accountContent, placeholderEnterAccountName, param.getAccountName(), fieldEmptyAccountName);

				validatAndeEnterValueToTextField(driver, accountDetailsDescNameLabel, accountDetailsDescField, accountDetailsDescValidation, descriptionContent, placeholderEnterDescription, param.getDescription(), "");

				flag=clickOnSaveAccountButtonAndValidateToast(false, toastMsgAccountCreated);

				viewAccountFunctionality(param.getAccountName(), param.getDescription(), param.getWorkspaceName(), "", "");

				clickOnAccountsTab();

				BaseSuite.reportLog(hyphenContent+" Verifying account details after created "+hyphenContent);

				flag=searchFunctionalityMethod(flag, accountListingSearchField, accountListingSearchButton, placeholderSearchAccount, placeholderSearchAccount, param.getAccountName());

				if(flag) {

					validateAccountDetailsOnListingPage(param.getAccountName(), param.getDescription());
				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" updateAccountFunctionality :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean discardAccountFunctionalityWhileCreating(DataTestingParameters param,String accountName, String icedqUser) {
		boolean flag =true;

		try {

			flag=clickOnNewAccountButton(icedqUser);

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

				validateAccountsDetailPageBeforeCreating(true);

				validatAndeEnterValueToTextField(driver, accountDetailsAccountNameLabel, accountDetailsAccountNameField, accountDetailsAccountNameValidation, accountContent, placeholderEnterAccountName, accountName, fieldEmptyAccountName);

				validatAndeEnterValueToTextField(driver, accountDetailsDescNameLabel, accountDetailsDescField, accountDetailsDescValidation, descriptionContent, placeholderEnterDescription, param.getDescription(), "");

				verifyVisibilityOfButtons(driver, accountDetailsSaveButton, saveContent, true);

				flag=clickOnDiscardAccountButtonAndValidateToast(flag, "");

				validateAccountsDetailPageBeforeCreating(false);

				clickOnAccountsTab();

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" discardAccountFunctionalityWhileCreating :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean discardAccountFunctionalityForExisting(DataTestingParameters param,String accountName, String icedqUser) {
		boolean flag =true;

		try {

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) ||  icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) 
					||  icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER) ||  icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_CONTRIBUTORUSER)
					||  icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_EXECUTORUSER) ||  icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_READERUSER)) {

				viewAccountFunctionality(param.getAccountName(), param.getDescription(), param.getWorkspaceName(), "", "");

				validatAndeEnterValueToTextField(driver, accountDetailsAccountNameLabel, accountDetailsAccountNameField, accountDetailsAccountNameValidation, accountContent, placeholderEnterAccountName, accountName, fieldEmptyAccountName);

				validatAndeEnterValueToTextField(driver, accountDetailsDescNameLabel, accountDetailsDescField, accountDetailsDescValidation, descriptionContent, placeholderEnterDescription, param.getUpdateAccountDescription(), "");

				verifyVisibilityOfButtons(driver, accountDetailsSaveButton, saveContent, true);

				flag=clickOnDiscardAccountButtonAndValidateToast(flag, "");

				viewAccountFunctionality(param.getAccountName(), param.getDescription(), param.getWorkspaceName(), "", "");

				clickOnAccountsTab();

				BaseSuite.reportLog(hyphenContent+" Verifying account details after discarded "+hyphenContent);

				flag=searchFunctionalityMethod(flag, accountListingSearchField, accountListingSearchButton, placeholderSearchAccount, placeholderSearchAccount, param.getAccountName());

				if(flag) {

					validateAccountDetailsOnListingPage(param.getAccountName(), param.getDescription());
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" discardAccountFunctionalityForExisting :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean refreshFunctionalityOnAccountDetailsPage(DataTestingParameters param, String searchUser) {

		boolean flag =true;
		try {

			viewAccountFunctionality(param.getAccountName(), param.getDescription(),
					param.getWorkspaceName(), "", "");

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			searchFunctionalityMethod(true, accountDetailsUserGroupSearchField, accountDetailsUserGroupSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, searchUser);

			getPaginationDetails(driver, accountDetailsUserGroupPaginationInfo, accountDetailsUserGroupPaginationbar,accountDetailsUserGroupNoRecordsToDisplay, usersGroupsContent+" "+tabContent);

			clickOnButton(driver, accountDetailsUserGroupRefreshButton, refreshContent+" "+usersGroupsContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			getPaginationDetails(driver, accountDetailsUserGroupPaginationInfo, accountDetailsUserGroupPaginationbar,accountDetailsUserGroupNoRecordsToDisplay, usersGroupsContent+" "+tabContent);

			clickOnButton(driver, accountDetailsWorkspacesTab, workspacesContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			searchFunctionalityMethod(true, accountDetailsWorkspacesSearchField, accountDetailsWorkspacesSearchButton, placeholderSearchWorkspace, placeholderSearchWorkspace, param.getWorkspaceName());

			clickOnButton(driver, accountDetailsWorkspacesRefreshButton, refreshContent+" "+workspacesContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			getPaginationDetails(driver,accountDetailsWorkspacesPaginationInfo, accountDetailsWorkspacesPaginationBar,accountDetailsWorkspacesNoRecordsToDisplay, workspacesContent+" "+tabContent);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" refreshFunctionalityOnAccountDetailsPage "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean refreshFunctionalityOnAccountListingPage(String accountName) {

		boolean flag =true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			searchFunctionalityMethod(flag, accountListingSearchField, accountListingSearchButton, placeholderSearchAccount, placeholderSearchAccount, accountName);

			getPaginationDetails(driver,accountListingPaginationMsg, accountListingPaginationBar,accountListingNoRecordsToDisplay, accountListingPageContent);

			clickOnRefreshOnAccountsListingPage();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			getPaginationDetails(driver,accountListingPaginationMsg, accountListingPaginationBar,accountListingNoRecordsToDisplay, accountListingPageContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" refreshFunctionalityOnAccountListingPage "+e.toString());
			flag=false;
		}

		return flag;
	}


	public boolean searchFunctionalityOfAccountListingPage(String scenarioType, String accountName,String accountDesc) {
		boolean flag =true;

		try {

			if (scenarioType.toLowerCase().contains("name")) {

				flag = searchFunctionalityMethod(flag, accountListingSearchField, accountListingSearchButton, placeholderSearchAccount, placeholderSearchAccount, accountName);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if (flag && elementNotVisible(driver, accountListingNoRecordsToDisplay)) {

					validateElementVisibility(
							returnTwoElements(accountListingDynamicNameAvatar, dynamicName, accountName, dynamicType,
									accountContent),
							accountName, avatarContent, true);

					validateElementVisibility(returnElement(accountListingDynamicName, dynamicName, accountName),
							accountName, hyperlinkContent, true);

				} else {
					BaseSuite.reportFailLog(noRecordsToDisplayContent+isVisibleContent, "searchFunctionalityOfAccountListingPage");

				} 
			}else if(scenarioType.toLowerCase().contains(descContent)) {

				flag = searchFunctionalityMethod(flag, accountListingSearchField, accountListingSearchButton, placeholderSearchAccount, placeholderSearchAccount, accountDesc);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if (flag && elementNotVisible(driver, accountListingNoRecordsToDisplay)) {

					List<WebElement> descs= getElements(driver, accountListingDescriptionList);

					BaseSuite.reportLog("No of records founds :: "+descs.size());

					for(int i=0; i<descs.size();i++) {

						BaseSuite.reportLog("Verifying account description : "+(i+1));

						String acdesc=descs.get(i).getAttribute(attributeTextContent);

						stringContainsOutput(acdesc, accountDesc, flag);
					}
				} else {
					BaseSuite.reportFailLog(noRecordsToDisplayContent+isVisibleContent, "searchFunctionalityOfAccountListingPage");

				} 
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchFunctionalityOfAccountListingPage "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean clickOnAssignButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {
			clickOnButton(driver, accountDetailsUserGroupAssignButton, assignContent, true);

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

	public boolean assignUserGroupAccessToAccount(String userName, String icedqUser) {
		String log1="  Assigning user/group access to account : ";
		String[] iceuserName=null;
		boolean flag=true;

		try {
			if (icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER)) {

				if(userName.contains(",")) {

					iceuserName= userName.split(","); 

					for(int i=0;i<iceuserName.length;i++) {

						BaseSuite.reportLog(hyphenContent+log1+ iceuserName[i]+hyphenContent );

						clickOnAssignButtonAndValidateToast(true, "");

						flag=assignAccountLevelAccessTo(iceuserName[i]);
					}

				}else {

					BaseSuite.reportLog(hyphenContent+log1+ userName+hyphenContent );

					clickOnAssignButtonAndValidateToast(true, "");

					flag=assignAccountLevelAccessTo(userName);
				}



			}else {

				clickOnAssignButtonAndValidateToast(true, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" assignUserGroupAccessToAccount "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean assignUserGroupAccessToAccountNoUI(String userName, String icedqUser) {

		String[] iceuserName=null;
		boolean flag=true;

		try {
			if (icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER)) {

				if(userName.contains(",")) {

					iceuserName= userName.split(","); 

					for(int i=0;i<iceuserName.length;i++) {

						BaseSuite.reportLog(hyphenContent+" Assigning user/group access to account : "+ iceuserName[i]+hyphenContent );

						/**	clickOnAssignButtonAndValidateToast(true, "");*/

						flag=validateAndAssignAccountLevelAccessToNOUI(iceuserName[i]);
					}

				}else {

					BaseSuite.reportLog(hyphenContent+" Assigning user/group access to account : "+ userName+hyphenContent );

					/**	clickOnAssignButtonAndValidateToast(true, "");*/

					flag=validateAndAssignAccountLevelAccessToNOUI(userName);
				}



			}else {

				clickOnAssignButtonAndValidateToast(true, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" assignUserGroupAccessToAccountNoUI "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean validateAddUserSidebarOnAccountDetailsPage() {
		boolean flag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateElement(workspaceDetailsSidebarAddUserTitle, "Role Assignment", attributeTitle);

			validateElement(workspaceDetailsSidebarAddUserCross, discardContent, iconContent);

			verifyVisibilityOfButtons(driver,workspaceDetailsSidebarAddUserAssignButton, assignContent, false);

			verifyVisibilityOfButtons(driver,workspaceDetailsSidebarAddUserCancelButton, cancelButtonContent,true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateAddUserSidebarOnAccountDetailsPage "+e.toString());
			flag=false;
		}
		return flag;
	}


	public void searchUser(String userName) {

		try {
			verifySearchField(driver, workspaceDetailsSidebarAddUserSearchField, placeholderSearchUser, placeholderSearchUser);

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

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 3, namelocator);

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

	public boolean addUsersToAccountFunctionality(String userName) {
		String[] iceuserName=null;
		boolean flag=true;
		try {

			if(userName.contains(",")) {

				iceuserName= userName.split(","); 

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setUsersParamUsingExcel(accountsEXCELFILEPATH, iceuserName[i]);

					BaseSuite.reportLog(hyphenContent+" Adding  "+(i+1)+" User to Workspace :: "+param.getFirstName()+" "+param.getLastName()+" "+hyphenContent);

					searchUser(param.getUserName());

					String fullName=param.getFirstName()+" "+param.getLastName();

					selectUserCheckbox(fullName);

				}

			}else {
				DataTestingParameters param = setUsersParamUsingExcel(accountsEXCELFILEPATH, userName);

				BaseSuite.reportLog(hyphenContent+" Adding  "+1+" User to Workspace :: "+param.getFirstName()+" "+param.getLastName()+" "+hyphenContent);

				searchUser(param.getUserName());

				String fullName=param.getFirstName()+" "+param.getLastName();

				selectUserCheckbox(fullName);

			}

			clickOnButton(driver, workspaceDetailsSidebarAddUserAssignButton, assignContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" addUsersToAccountFunctionality "+e.toString());
			flag=false;
		}
		return flag;
	}


	public boolean addGroupdToAccountFunctionality(String userName) {
		String[] iceuserName=null;
		boolean flag=true;
		try {

			if(userName.contains(",")) {

				iceuserName= userName.split(","); 

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setGroupsParamUsingExcel(accountsEXCELFILEPATH, iceuserName[i]);

					BaseSuite.reportLog(hyphenContent+" Adding "+(i+1)+" Group to Account :: "+param.getGroupName()+" "+hyphenContent);

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
				DataTestingParameters param = setGroupsParamUsingExcel(accountsEXCELFILEPATH, userName);

				BaseSuite.reportLog(hyphenContent+" Adding "+1+" Group to Account :: "+param.getFirstName()+" "+param.getLastName()+" "+hyphenContent);

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
			BaseSuite.reportErrorLog(errorLogTitle+" addGroupdToAccountFunctionality "+e.toString());
			flag=false;
		}
		return flag;
	}

	public void selectRoleOnAssignSideBar(String role) {

		try {

			validateElementVisibility(workspaceDetailsSidebarRoleLabel, roleContent, labelContent, true);

			displayAndClick(driver, workspaceDetailsSidebarRoleDropdown);

			waitForExecution(1000);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clear_Click_SendKeys(driver, 1,workspaceDetailsSidebarRoleSelect, role);

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

	public boolean validateLoadMore(String listCount) {
		boolean flag=true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			String b = listCount.split("of")[1].trim();

			validateElementVisibility(workspaceDetailsSidebarAddUserLoadMore, "Load more", hyperlinkContent, Integer.parseInt(b) > 20);

		}catch(Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" validateLoadMore "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean assignAccountLevelAccessTo(String userName) {

		boolean flag=true;
		try {

			DataTestingParameters aParam=setAssignToParamUsingExcel(accountsEXCELFILEPATH, userName);

			validateAddUserSidebarOnAccountDetailsPage();

			selectRoleOnAssignSideBar(aParam.getRole());

			selectAssignAccessToOnAssignSideBar(aParam.getAssignTo());

			if (aParam.getAssignTo().equalsIgnoreCase("user")) {

				BaseSuite.reportLog(hyphenContent+" Assigning access to user : "+aParam.getUserName()+hyphenContent);

				verifySearchField(driver, workspaceDetailsSidebarAddUserSearchField, placeholderSearchUser,
						placeholderSearchUser);

				/**		validateElement(workspaceDetailsSidebarAddUserLoadMore, "Load more", hyperlinkContent);**/

				javascript(driver, scrollToElementArg, workspaceDetailsSidebarAddUserListCount);

				String listcount = getAttribute(driver, workspaceDetailsSidebarAddUserListCount, attributeTextContent);

				BaseSuite.reportLog("User List count " + listcount);

				/**		validateLoadMore(listcount); requirement change**/

				addUsersToAccountFunctionality(aParam.getUserName());

				viewAddedUserDetails(aParam.getUserName());

			} else {

				BaseSuite.reportLog(hyphenContent+" Assigning access to group : "+aParam.getUserName()+hyphenContent);

				validateElementVisibility(workspaceDetailsSidebarSelectGroupLabel, "Select Group", labelContent, true);

				verifySearchField(driver, workspaceDetailsSidebarSelectGroupField, placeholderSelectGroups,
						placeholderSelectGroups);

				addGroupdToAccountFunctionality(aParam.getUserName());

				viewAddedGroupDetails(aParam.getUserName());

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" assignAccountLevelAccessTo "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateAndAssignAccountLevelAccessToNOUI(String userName) {

		boolean flag=true;
		try {

			DataTestingParameters aParam=setAssignToParamUsingExcel(accountsEXCELFILEPATH, userName);

			if (aParam.getAssignTo().equalsIgnoreCase("user")) {

				flag=searchAndViewAddedGroupInAccountNOUI(flag, aParam.getFirstName()+" "+aParam.getLastName());

				if(flag) {

					clickOnAssignButtonAndValidateToast(true, "");

					waitForExecution(2000);

					selectRoleOnAssignSideBar(aParam.getRole());

					selectAssignAccessToOnAssignSideBar(aParam.getAssignTo());


					BaseSuite.reportLog(hyphenContent+" Assigning access to user : "+aParam.getUserName()+hyphenContent);

					verifySearchField(driver, workspaceDetailsSidebarAddUserSearchField, placeholderSearchUser,
							placeholderSearchUser);

					/**		validateElement(workspaceDetailsSidebarAddUserLoadMore, "Load more", hyperlinkContent);**/

					javascript(driver, scrollToElementArg, workspaceDetailsSidebarAddUserListCount);

					String listcount = getAttribute(driver, workspaceDetailsSidebarAddUserListCount, attributeTextContent);

					BaseSuite.reportLog("User List count " + listcount);

					/**	validateLoadMore(listcount);*/

					addUsersToAccountFunctionality(aParam.getUserName());

					/**viewAddedUserDetails(aParam.getUserName());*/

				}else {

					searchFunctionalityMethod(true, accountDetailsUserGroupSearchField, accountDetailsUserGroupSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, "");

				}
			}else {

				flag=searchAndViewAddedGroupInAccountNOUI(flag, aParam.getUserName());

				if(flag) {

					clickOnAssignButtonAndValidateToast(true, "");

					waitForExecution(2000);

					selectRoleOnAssignSideBar(aParam.getRole());

					selectAssignAccessToOnAssignSideBar(aParam.getAssignTo());

					BaseSuite.reportLog(hyphenContent+" Assigning access to group : "+aParam.getUserName()+hyphenContent);

					validateElementVisibility(workspaceDetailsSidebarSelectGroupLabel, "Select Group", labelContent, true);

					verifySearchField(driver, workspaceDetailsSidebarSelectGroupField, placeholderSelectGroups,
							placeholderSelectGroups);

					addGroupdToAccountFunctionality(aParam.getUserName());

				}else {

					searchFunctionalityMethod(true, accountDetailsUserGroupSearchField, accountDetailsUserGroupSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, "");

				}
			}

			waitForExecution(1000);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateAndAssignAccountLevelAccessToNOUI "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean revokeUserGroupAccessToAccount(DataTestingParameters param, String removeUser, String removeGroup, String icedqUser) {

		boolean flag=true;

		try {

			/**	viewAccountFunctionality(param.getAccountName(), param.getDescription(),param.getWorkspaceName(), param.getAddUser(), param.getAddGroup());
			 */
			if(!removeUser.isEmpty()) {

				flag=deleteUsersFromAccountFunctionality(removeUser,icedqUser);

				validateDeletedUserInAccount(removeUser, icedqUser);

			}

			clickOnButton(driver, accountDetailsUserGroupRefreshButton, refreshContent+" "+usersGroupsContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(!removeGroup.isEmpty()) {

				flag=deleteGroupsFromAccountFunctionality(removeGroup,icedqUser);

				validateDeletedGroupInAccount(removeGroup,icedqUser);

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" revokeUserGroupAccessToAccount "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean deleteUsersFromAccountFunctionality(String userName, String icedqUser) {
		String[] iceuserName=null;
		boolean flag=true;
		int num=0;
		try {

			if(userName.contains(",")) {

				iceuserName= userName.split(","); 
				num=iceuserName.length;
				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setUsersParamUsingExcel(accountsEXCELFILEPATH, iceuserName[i]);

					BaseSuite.reportLog(hyphenContent+"  Deleting "+(i+1)+" User from workspace :: "+param.getFirstName()+" "+param.getLastName()+" "+hyphenContent);

					String fullName=param.getFirstName()+" "+param.getLastName();

					flag=searchFunctionalityMethod(true, accountDetailsUserGroupSearchField, accountDetailsUserGroupSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, fullName);

					selectUserCheckboxForAddedAccount(flag,fullName);

				}

			}else {
				num=1;
				DataTestingParameters param = setUsersParamUsingExcel(accountsEXCELFILEPATH, userName);

				BaseSuite.reportLog(hyphenContent+"  Deleting "+1+" User from workspace :: "+param.getFirstName()+" "+param.getLastName()+" "+hyphenContent);

				String fullName=param.getFirstName()+" "+param.getLastName();

				flag=searchFunctionalityMethod(true, accountDetailsUserGroupSearchField, accountDetailsUserGroupSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, fullName);

				selectUserCheckboxForAddedAccount(flag,fullName);

			}

			searchFunctionalityMethod(true, accountDetailsUserGroupSearchField, accountDetailsUserGroupSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, "");

			if (icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER)) {

				flag=clickOnButton(driver, accountDetailsUserGroupDeleteButton, deleteContent, true);

				flag=clickOnDeleteUserGroupButtonFromAccountAndValidateToast(flag, num, "");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}else {
				flag=clickOnButton(driver, accountDetailsUserGroupDeleteButton, deleteContent, true);
				flag=clickOnDeleteUserGroupButtonFromAccountAndValidateToast(flag, num, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
				clickOnButton(driver, accountDetailsUserGroupPopupDeleteCancelButton, cancelButtonContent, true);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" deleteUsersFromAccountFunctionality "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean selectUserCheckboxForAddedAccount(boolean flag, String fullName) {

		try {
			By namelocator = returnElement(accountDetailsUserGroupNameDynamic, dynamicName, fullName);
			By checkboxlocator = returnElement(accountDetailsUserGroupCheckboxDynamic, dynamicName, fullName);

			isDisplayedInLoop(driver, 3, namelocator);

			if(isDisplayed(driver, namelocator)) {

				BaseSuite.reportLog("User full name/Group name is visible as "+fullName);

				if(isDisplayed(driver, checkboxlocator)) {

					BaseSuite.reportLog("User full name/Group name checkbox is visible");

					flag=selectcheckbox(checkboxlocator, fullName);

				}else {
					BaseSuite.reportFailLog("User full name/Group name checkbox is not visible "+fullName, "selectUserCheckboxForAddedAccount");
				}
			}else {
				BaseSuite.reportFailLog("User full name/Group name is not visible", "selectUserCheckboxForAddedAccount");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" selectUserCheckboxForAddedAccount "+e.toString());
		}
		return flag;
	}

	public boolean clickOnDeleteUserGroupButtonFromAccountAndValidateToast(boolean flag,int num, String expectedToastMessage) {
		boolean tag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			waitForExecution(500);

			if(num==1) {
				validatePopupWindowContent(flag, accountDetailsUserGroupPopupDeleteTitle, accountDetailsUserGroupPopupDeleteContent, popupDiscardUserGroupDeleteTitle, popupDiscardUserGroupDeleteContent);
			}else if(num>1){
				validatePopupWindowContent(flag, accountDetailsUserGroupPopupDeleteTitle, accountDetailsUserGroupPopupDeleteContent, popupDiscardUserGroupDeleteTitle, popupDiscardMultiUserGroupDeleteContent);
			}
			verifyVisibilityOfButtons(driver, accountDetailsUserGroupPopupDeleteButton, deleteContent, true);
			verifyVisibilityOfButtons(driver, accountDetailsUserGroupPopupDeleteCancelButton, cancelButtonContent, true);

			clickOnButton(driver, accountDetailsUserGroupPopupDeleteButton, deleteContent, tag);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, assignContent+deleteContent);
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,assignContent+deleteContent);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnDeleteUserGroupButtonFromAccountAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateDeletedUserInAccount(String userName, String icedqUser) {

		String[] iceuserName=null;
		boolean flag=true;
		try {
			if (icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER)) {

				clickOnButton(driver, accountDetailsUserGroupRefreshButton, refreshContent+" "+usersGroupsContent, true);

				if(userName.contains(",")) {

					iceuserName= userName.split(","); 
					for(int i=0;i<iceuserName.length;i++) {

						DataTestingParameters param = setUsersParamUsingExcel(accountsEXCELFILEPATH, iceuserName[i]);

						String fullName=param.getFirstName()+" "+param.getLastName();

						searchUserForDeletedInAccount(flag, fullName,usersContent);

					}

				}else {
					DataTestingParameters param = setUsersParamUsingExcel(accountsEXCELFILEPATH, userName);

					String fullName=param.getFirstName()+" "+param.getLastName();

					searchUserForDeletedInAccount(flag, fullName,usersContent);

				}

				searchFunctionalityMethod(true, accountDetailsUserGroupSearchField, accountDetailsUserGroupSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, "");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateDeletedUserInAccount "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean searchUserForDeletedInAccount(boolean flag,String name,String label) {

		try {
			BaseSuite.reportLog(hyphenContent+" Validate "+label+" for deleted from workspace :: "+name+" "+hyphenContent);

			flag=searchFunctionalityMethod(true, accountDetailsUserGroupSearchField, accountDetailsUserGroupSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, name);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {
				By namelocator = returnElement(accountDetailsUserGroupNameDynamic, dynamicName, name);

				if(isDisplayed(driver, namelocator)) {
					flag=false;
					BaseSuite.reportFailLog("Removed user/group from account is visible, "+name,"searchUserForDeletedInAccount");
				}else {
					BaseSuite.validationReportLog(name+" is not visible ");
				}

				/**	flag=validateElement(accountDetailsUserGroupNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);*/

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchUserForDeletedInAccount "+e.toString());
		}

		return flag;
	}
	public boolean deleteGroupsFromAccountFunctionality(String groupName, String icedqUser) {
		String[] iceuserName=null;
		boolean flag=true;
		int num=0;
		try {

			if(groupName.contains(",")) {

				iceuserName= groupName.split(","); 
				num=iceuserName.length;
				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setGroupsParamUsingExcel(accountsEXCELFILEPATH, iceuserName[i]);

					BaseSuite.reportLog(hyphenContent+" Deleting "+(i+1)+" Group from workspace :: "+param.getGroupName()+" "+hyphenContent);

					flag=searchFunctionalityMethod(true, accountDetailsUserGroupSearchField, accountDetailsUserGroupSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, param.getGroupName());

					selectUserCheckboxForAddedAccount(flag,param.getGroupName());

				}

			}else {
				num=1;
				DataTestingParameters param = setGroupsParamUsingExcel(accountsEXCELFILEPATH, groupName);

				BaseSuite.reportLog(hyphenContent+" Deleting "+1+" Group from workspace :: "+param.getGroupName()+" "+hyphenContent);

				flag=searchFunctionalityMethod(true, accountDetailsUserGroupSearchField, accountDetailsUserGroupSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, param.getGroupName());

				selectUserCheckboxForAddedAccount(flag, param.getGroupName());

			}

			searchFunctionalityMethod(true, accountDetailsUserGroupSearchField, accountDetailsUserGroupSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, "");

			if (icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER)) {

				flag=clickOnButton(driver, accountDetailsUserGroupDeleteButton, deleteContent, true);

				flag=clickOnDeleteUserGroupButtonFromAccountAndValidateToast(flag, num, "");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}else {
				flag=clickOnButton(driver, accountDetailsUserGroupDeleteButton, deleteContent, true);
				flag=clickOnDeleteUserGroupButtonFromAccountAndValidateToast(flag, num, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
				clickOnButton(driver, accountDetailsUserGroupPopupDeleteCancelButton, cancelButtonContent, true);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" deleteGroupsFromAccountFunctionality "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateDeletedGroupInAccount(String userName, String icedqUser) {

		String[] iceuserName=null;
		boolean flag=true;
		try {
			if (icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER)) {

				clickOnButton(driver, accountDetailsUserGroupRefreshButton, refreshContent+" "+usersGroupsContent, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(userName.contains(",")) {

					iceuserName= userName.split(","); 

					for(int i=0;i<iceuserName.length;i++) {

						DataTestingParameters param = setGroupsParamUsingExcel(accountsEXCELFILEPATH, iceuserName[i]);

						searchUserForDeletedInAccount(flag, param.getGroupName(),groupContent);

					}

				}else {
					DataTestingParameters param = setGroupsParamUsingExcel(accountsEXCELFILEPATH, userName);

					searchUserForDeletedInAccount(flag, param.getGroupName(),groupContent);

				}

				searchFunctionalityMethod(true, accountDetailsUserGroupSearchField, accountDetailsUserGroupSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, "");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateDeletedGroupInAccount "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateNavigationFunctionalityForAccounts(String accountName, String fullName, String workspaceName, String icedqUser) {

		boolean flag =true;
		HomePage hp=new HomePage(driver);
		try {

			navigateToAdministrationTabs(nextgenSubModuleUsers,returnElement(subModuleHeadingName, dynamicName, usersContent), usersContent, subModuleContent);

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
			 **/
			clickOnNewAccountButton(icedqUser);

			navigateToLink(accountBreadcrumbAccountseLink, returnElement(subModuleHeadingName, dynamicName, accountsContent), accountsContent+" "+breadcrumbContent);

			clickOnNewAccountButton(icedqUser);

			navigateToLink(accountBreadcrumbAdminLink, returnElement(subModuleHeadingName, dynamicName, usersContent), administrationContent+" "+breadcrumbContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnAccountsTab();

			clickOnNewAccountButton(icedqUser);

			clickOnButton(driver, accountBreadcrumbHomeLink, homeContent+" "+breadcrumbContent, true);

			hp.clickOnAdministrationTab();

			clickOnAccountsTab();

			navigateToBreadcrumb(accountName);

			navigateToUserGroup(accountName, fullName, workspaceName);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateNavigationFunctionalityForAccounts :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public void navigateToBreadcrumb(String accountName) {

		HomePage hp=new HomePage(driver);

		try {

			searchAccountAndClickOnName(accountName);

			navigateToLink(accountBreadcrumbAccountseLink, returnElement(subModuleHeadingName, dynamicName, accountsContent), accountsContent+" "+breadcrumbContent);

			searchAccountAndClickOnName(accountName);

			navigateToLink(accountBreadcrumbAdminLink, returnElement(subModuleHeadingName, dynamicName, usersContent), administrationContent+" "+breadcrumbContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnAccountsTab();

			searchAccountAndClickOnName(accountName);

			clickOnButton(driver, accountBreadcrumbHomeLink, homeContent+" "+breadcrumbContent, true);

			hp.clickOnAdministrationTab();

			clickOnAccountsTab();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" navigateToBreadcrumb :: "+e.toString());

		}
	}

	public void navigateToUserGroup(String accountName,String fullName, String workspaceName) {


		try {

			searchAccountAndClickOnName(accountName);

			searchFunctionalityMethod(true, accountDetailsUserGroupSearchField, accountDetailsUserGroupSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, fullName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			navigateToLink(returnElement(accountDetailsUserGroupNameDynamic, dynamicName, fullName), returnElement(subModuleHeadingName, dynamicName, fullName), fullName+" "+attributeTitle);

			clickOnAccountsTab();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			searchAccountAndClickOnName(accountName);

			clickOnButton(driver, accountDetailsWorkspacesTab, workspacesContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			searchFunctionalityMethod(true, accountDetailsWorkspacesSearchField, accountDetailsWorkspacesSearchButton, placeholderSearchWorkspace, placeholderSearchWorkspace, workspaceName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			navigateToLink(returnElement(accountDetailsWorkspaceDynamicName, dynamicName, workspaceName), returnElement(subModuleHeadingName, dynamicName, workspaceName), workspaceName+" "+attributeTitle);

			clickOnAccountsTab();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" navigateToUserGroup :: "+e.toString());

		}
	}

	public void validateAddWorkspaceSidebarOnAccountDetails() {

		try {

			BaseSuite.reportLog(hyphenContent+" Validate add workspace sidebar "+hyphenContent);

			validateElementVisibility(accountDetailsSidebarAddWorkspaceTitle, "Add Workspace", attributeTitle, true);

			validateElementVisibility(accountDetailsSidebarAddWorkspaceCrossIcon, "Cross", iconContent, true);

			validateElement(accountDetailsSidebarAddWorkspaceWorkspaceLabel, workspaceContent, labelContent);
			validateElement(accountDetailsSidebarAddWorkspaceWorkspaceField, workspaceContent, fieldContent);
			verifyPlaceHolderValue(driver, accountDetailsSidebarAddWorkspaceWorkspaceField, workspaceContent, placeholderEnterWorkspaceName);

			validateElement(accountDetailsSidebarAddWorkspaceDescLabel, descriptionContent, labelContent);
			validateElement(accountDetailsSidebarAddWorkspaceDescField, descriptionContent, fieldContent);
			verifyPlaceHolderValue(driver, accountDetailsSidebarAddWorkspaceDescField, descriptionContent, placeholderEnterDescription);

			validateElement(accountDetailsSidebarAddWorkspaceTypeLabel, typeContent, labelContent);
			validateElement(accountDetailsSidebarAddWorkspaceTypeField, typeContent, fieldContent);

			viewAndValidateField(accountDetailsSidebarAddWorkspaceTypeField, typeContent, testingContent, isrelease5Flag);

			verifyVisibilityOfButtons(driver, accountDetailsSidebarAddWorkspaceAddButton, addButtonContent, false);
			verifyVisibilityOfButtons(driver, accountDetailsSidebarAddWorkspaceCancelButton, cancelButtonContent, true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" navigateToBreadcrumb :: "+e.toString());

		}
	}

	public boolean clickOnAddButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {
			clickOnButton(driver, accountDetailsSidebarAddWorkspaceAddButton, addButtonContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Workspace Created");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Workspace Created");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnAddButtonAndValidateToast :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean clickOnAddButtonAndValidateToastOnWorkspaceTab(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {
			clickOnButton(driver, accountDetailsWorkspacesAddButton, addButtonContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Workspace add");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Workspace add");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnAddButtonAndValidateToast :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean addWorkspaceToAccount(String workspaceName, String descr, String icedqUser) {
		boolean flag =true;

		try {

			clickOnButton(driver, accountDetailsWorkspacesTab, workspacesContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER)  || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_CONTRIBUTORUSER)) {

				flag=clickOnAddButtonAndValidateToastOnWorkspaceTab(flag, "");

				if(flag) {

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					validateAddWorkspaceSidebarOnAccountDetails();

					BaseSuite.reportLog(hyphenContent+" Entering workspace details to create new workspace "+hyphenContent);

					validatAndeEnterValueToTextField(driver, accountDetailsSidebarAddWorkspaceWorkspaceLabel, accountDetailsSidebarAddWorkspaceWorkspaceField, accountDetailsSidebarAddWorkspaceWorkspaceValidation, workspaceNameContent, placeholderEnterWorkspaceName, workspaceName, fieldEmptyWorkspaceName);

					validatAndeEnterValueToTextField(driver, accountDetailsSidebarAddWorkspaceDescLabel, accountDetailsSidebarAddWorkspaceDescField, accountDetailsSidebarAddWorkspaceDescValidation, descriptionContent, placeholderEnterDescription, descr, "");

					viewAndValidateField(accountDetailsSidebarAddWorkspaceTypeField, typeContent, testingContent, isrelease5Flag);

					verifyVisibilityOfButtons(driver,  accountDetailsSidebarAddWorkspaceCancelButton, cancelButtonContent, true);

					clickOnAddButtonAndValidateToast(flag, toastMsgWorkspaceCreated);
				}
			}else {

				flag=clickOnAddButtonAndValidateToastOnWorkspaceTab(flag, ACCOUNTPRIVILEGEFORBIDDENMESSAGE );
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" addWorkspaceToAccount :: "+e.toString());
			flag=false;
		}
		return flag;
	}


	public boolean viewAndAddWorkspaceInAccountDetails(DataTestingParameters param,String workspaceName,String workspaceType, String icedqUser) {
		boolean flag =true;

		try {

			String timeStamp =  new SimpleDateFormat(ConstantProperty.CONNECTIONNAME_TIMESTAMPFORMAT).format(new Date());

			String newworkspaceName = workspaceName+timeStamp;

			viewAccountFunctionality(param.getAccountName(), param.getDescription(),param.getWorkspaceName(),param.getAddUser(), param.getAddGroup());

			addWorkspaceToAccount(newworkspaceName, param.getUpdateWorkspaceDescription(), icedqUser);

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER)  || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_CONTRIBUTORUSER)) {

				BaseSuite.reportLog(hyphenContent+" Validate workspace added in account :: "+newworkspaceName+" "+hyphenContent);

				flag=searchFunctionalityMethod(true, accountDetailsWorkspacesSearchField, accountDetailsWorkspacesSearchButton, placeholderSearchWorkspace, placeholderSearchWorkspace, newworkspaceName);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(flag) {

					if(workspaceType.equalsIgnoreCase(dataTestingContent)) {

						validateElement(returnTwoElements(accountDetailsDataTestingWorkspaceDynamicAvatar, dynamicName, newworkspaceName,dynamicType,workspaceType), workspaceType, avatarContent);

					}else {
						validateElement(returnTwoElements(accountDetailsDataMonitoringWorkspaceDynamicAvatar, dynamicName, newworkspaceName,dynamicType,workspaceType), workspaceType, avatarContent);
					}

					validateElement(returnElement(accountDetailsWorkspaceDynamicName, dynamicName, newworkspaceName), newworkspaceName, hyperlinkContent);

					checkExpectedValueWithActual(driver,true,returnElement(accountDetailsWorkspaceDescription, dynamicName, newworkspaceName), workspaceContent+" "+descriptionContent, param.getUpdateWorkspaceDescription(),true);

					checkExpectedValueWithActual(driver,true,returnElement(accountDetailsWorkspaceAccount, dynamicName, newworkspaceName), accountContent+" "+nameContent, param.getAccountName(),true);

					String updatedby=getAttribute(driver, returnElement(accountDetailsWorkspaceUpdatedBy, dynamicName, newworkspaceName), attributeTitle);

					BaseSuite.reportLog("Workspace updated by : "+updatedby);

					String updateddate=getAttribute(driver, returnElement(accountDetailsWorkspaceUpdatedDate, dynamicName, newworkspaceName), attributeTextContent);

					BaseSuite.reportLog("Workspace updated date : "+updateddate);

				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewAndAddWorkspaceInAccountDetails :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	/**
	public boolean enterValueToFieldForInvalidDetails(By fieldLocator, By validationLocator,String fieldLabel, String inputValue, String fieldValidation) {
		boolean flag =true;

		try {
			if(!inputValue.isEmpty()) {
				enterValueToTextField(driver, fieldLocator, fieldLabel, inputValue);	
			}else {
				sendKeys(driver, fieldLocator, "emp");
				waitForExecution(500);
				click(driver, fieldLocator);
				clear(driver, fieldLocator);
			}

			String acmesg = validationMessageOfField(driver, validationLocator, fieldLabel, fieldValidation, true);

			if(!fieldValidation.equalsIgnoreCase(acmesg)) {
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" enterValueToFieldForInvalidDetails :: "+e.toString());
			flag=false;
		}
		return flag;
	}
	 **/

	//invalid method
	public boolean createAccountFunctionalityWithInvalidDetails(String scenarioType,String accountName, String description,String fieldValidation, String toastValidation, String icedqUser) {
		boolean flag =true;

		try {

			flag=clickOnNewAccountButton(icedqUser);

			if(flag && icedqUser.toLowerCase().contains(adminsContent)) {

				validateAccountDetailsWorkspaceTabBeforeCreating();

				switch(scenarioType.toLowerCase()) {

				case "name":

					enterValueToFieldForInvalidDetails(driver, accountDetailsAccountNameField, accountDetailsAccountNameValidation, accountContent, accountName, fieldValidation);

					verifyVisibilityOfButtons(driver, accountDetailsSaveButton, saveContent, false);

					break;

				case "description":

					enterValueToFieldForInvalidDetails(driver, accountDetailsDescField, accountDetailsDescValidation, descriptionContent, description, fieldValidation);

					verifyVisibilityOfButtons(driver, accountDetailsSaveButton, saveContent, false);

					break;

				case "existingacc":
					BaseSuite.reportLog(toastValidation);
					/**									
						validatAndeEnterValueToTextField(accountDetailsAccountNameLabel, accountDetailsAccountNameField, accountDetailsAccountNameValidation, accountContent, placeholderEnterWorkspaceName, accountName, fieldEmptyWorkspaceName);

						validatAndeEnterValueToTextField(accountDetailsDescNameLabel, accountDetailsDescField, accountDetailsDescValidation, descriptionContent, placeholderEnterDescription, description, fieldValidation);

				//		flag=clickOnSaveButtonAndValidateToast(flag, toastValidation);
					 **/
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

	public boolean updateAccountFunctionalityWithInvalidDetails(DataTestingParameters param,String scenarioType,String searchAccount, String icedqUser) {
		boolean flag =true;

		try {

			String saccountName=param.getAccountName();
			String description=param.getDescription();
			String fieldValidation=param.getFieldValidationMessage();
			String toastValidation=param.getToastValidationMessage();
			String userName=param.getAddUser();
			String workspaceName=param.getWorkspaceName();
			String addWorkspace=param.getAddWorkspace();
			String addWorkspaceDesc=param.getUpdateWorkspaceDescription();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(icedqUser.toLowerCase().contains(adminsContent)) {

				switch(scenarioType.toLowerCase()) {

				case "name":

					searchAccountAndClickOnName(searchAccount);

					enterValueToFieldForInvalidDetails(driver, accountDetailsAccountNameField, accountDetailsAccountNameValidation, accountContent, saccountName, fieldValidation);

					verifyVisibilityOfButtons(driver, accountDetailsSaveButton, saveContent, false);

					break;

				case "description":

					searchAccountAndClickOnName(searchAccount);

					enterValueToFieldForInvalidDetails(driver, accountDetailsDescField, accountDetailsDescValidation, descriptionContent, description, fieldValidation);

					verifyVisibilityOfButtons(driver, accountDetailsSaveButton, saveContent, false);

					break;

				case "existingacc":

					searchAccountAndClickOnName(searchAccount);
					/**				
						validatAndeEnterValueToTextField(accountDetailsAccountNameLabel, accountDetailsAccountNameField, accountDetailsAccountNameValidation, groupNameContent, placeholderEnterWorkspaceName, accountName, fieldEmptyWorkspaceName);

						validatAndeEnterValueToTextField(accountDetailsDescNameLabel, accountDetailsDescField, accountDetailsDescValidation, descriptionContent, placeholderEnterDescription, description, fieldValidation);

			//			flag=clickOnSaveButtonAndValidateToast(flag, toastValidation);
					 **/
					break;

				case "searchlist":

					searchFunctionalityMethod(flag, accountListingSearchField, accountListingSearchButton, placeholderSearchAccount, placeholderSearchAccount, saccountName);

					validateElementVisibility(accountListingNoRecordsToDisplay, noRecordsToDisplayContent, labelContent, true);

					break;

				case "searchuser":

					searchAccountAndClickOnName(searchAccount);

					flag=searchFunctionalityMethod(true, accountDetailsUserGroupSearchField, accountDetailsUserGroupSearchButton, placeholderSearchUserGroup, placeholderSearchUserGroup, userName);

					validateElementVisibility(accountDetailsUserGroupNoRecordsToDisplay, noRecordsToDisplayContent, labelContent, true);

					break;

				case "searchworkspace":

					searchAccountAndClickOnName(searchAccount);

					clickOnButton(driver, accountDetailsWorkspacesTab, workspacesContent, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					flag=searchFunctionalityMethod(true, accountDetailsWorkspacesSearchField, accountDetailsWorkspacesSearchButton, placeholderSearchWorkspace, placeholderSearchWorkspace, workspaceName);

					validateElementVisibility(accountDetailsWorkspacesNoRecordsToDisplay, noRecordsToDisplayContent, labelContent, true);

					break;

				case "addworkspace":

					searchAccountAndClickOnName(searchAccount);

					clickOnButton(driver, accountDetailsWorkspacesTab, workspacesContent, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					flag=clickOnAddButtonAndValidateToastOnWorkspaceTab(flag, "");

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					enterValueToFieldForInvalidDetails(driver, accountDetailsSidebarAddWorkspaceWorkspaceField, accountDetailsSidebarAddWorkspaceWorkspaceValidation, workspaceContent, addWorkspace, fieldValidation);

					verifyVisibilityOfButtons(driver, accountDetailsSidebarAddWorkspaceAddButton, addButtonContent, false);

					clickOnButton(driver, accountDetailsSidebarAddWorkspaceCancelButton, cancelButtonContent, true);

					break;

				case "adddesc":

					searchAccountAndClickOnName(searchAccount);

					clickOnButton(driver, accountDetailsWorkspacesTab, workspacesContent, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					flag=clickOnAddButtonAndValidateToastOnWorkspaceTab(flag, "");

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					enterValueToFieldForInvalidDetails(driver, accountDetailsSidebarAddWorkspaceDescField, accountDetailsSidebarAddWorkspaceDescValidation, descriptionContent, addWorkspaceDesc, fieldValidation);

					verifyVisibilityOfButtons(driver, accountDetailsSidebarAddWorkspaceAddButton, addButtonContent, false);

					clickOnButton(driver, accountDetailsSidebarAddWorkspaceCancelButton, cancelButtonContent, true);

					break;

				case "existingworkspace":

					searchAccountAndClickOnName(searchAccount);

					clickOnButton(driver, accountDetailsWorkspacesTab, workspacesContent, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					flag=clickOnAddButtonAndValidateToastOnWorkspaceTab(flag, "");

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					validatAndeEnterValueToTextField(driver, accountDetailsSidebarAddWorkspaceWorkspaceLabel, accountDetailsSidebarAddWorkspaceWorkspaceField, accountDetailsSidebarAddWorkspaceWorkspaceValidation, workspaceContent, placeholderEnterWorkspaceName, addWorkspace, fieldEmptyWorkspaceName);

					validatAndeEnterValueToTextField(driver, accountDetailsSidebarAddWorkspaceDescLabel, accountDetailsSidebarAddWorkspaceDescField, accountDetailsSidebarAddWorkspaceDescValidation, descriptionContent, placeholderEnterDescription, addWorkspaceDesc, fieldValidation);

					viewAndValidateField(accountDetailsSidebarAddWorkspaceTypeField, typeContent, testingContent, isrelease5Flag);

					verifyVisibilityOfButtons(driver,  accountDetailsSidebarAddWorkspaceCancelButton, cancelButtonContent, true);

					clickOnAddButtonAndValidateToast(flag, toastValidation);

					clickOnButton(driver, accountDetailsSidebarAddWorkspaceCancelButton, cancelButtonContent, true);

					break;

				default:

					break;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" updateAccountFunctionalityWithInvalidDetails :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean validateAccountsTabForWorkspaceLevelGrantUser(String icedqUser) {
		boolean flag =true;
		try {
			if(icedqUser.contains(ConstantProperty.ICEDQ_WORKSPACE_OWNERUSER) ||  icedqUser.contains(ConstantProperty.ICEDQ_WORKSPACE_CONTRIBUTORUSER) 
					||  icedqUser.contains(ConstantProperty.ICEDQ_WORKSPACE_EXECUTORUSER) ||  icedqUser.contains(ConstantProperty.ICEDQ_WORKSPACE_READERUSER)) {

				validateAccountsListingPage();

				validateElement(accountListingNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateAccountsTabForWorkspaceLevelGrantUser :: "+e.toString());
			flag=false;
		}
		return flag;
	}




	/**------------------------------ API Methods -----------------**/
	/**
	static ReadConfig readconfig = new ReadConfig();
	static String authorization=prop.getProperty("api.authorization");
	static String apibasic=prop.getProperty("api.apibasic");
	static String apicontentType=prop.getProperty("api.apicontentType");
	static String applicationJSonContentType=prop.getProperty("api.applicationJSonContentType");
	static String apiworkspaceId=prop.getProperty("api.apiworkspaceId");
	static String apiorgId=prop.getProperty("api.apiorgId");
	static String apiBearer=prop.getProperty("api.apiBearer");
	private static final Pattern pat = Pattern.compile(".*\"access_token\"\\s*:\\s*\"([^\"]+)\".*");
	private static final String CLIENTID = readconfig.clientID();
	private static final String CLIENTSECRET = readconfig.clientSecret();
	private static final String AUTH = CLIENTID + ":" + CLIENTSECRET;
	private static final String AUTHENTICATION = Base64.getEncoder().encodeToString(AUTH.getBytes());

	static String authetication = prop.getProperty("Authetication");
	static String basic = prop.getProperty("Basic");
	static String contentType = prop.getProperty("ContentType");


	public static String getOAuthBearerTokenBasedOnIcedqRole(String appURL,String orgid,String userName, String passWord) {

		String content = "grant_type=password&username=" + userName + "&password=" + passWord;

		BufferedReader reader = null;

		HttpURLConnection connection = null;

		String returnValue = "";

		try {

			if(appURL.contains("https")) {
				appURL=appURL.replace("https", "http");
			}
			if(orgid.contains("org-")) {
				orgid=orgid.replace("org-", "");
			}

			URL url = new URL(appURL+"auth/realms/"+orgid+"/protocol/openid-connect/token");

			connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("POST");

			connection.setDoOutput(true);

			connection.setRequestProperty(authorization, apibasic + AUTHENTICATION);

			connection.setRequestProperty(apicontentType, "application/x-www-form-urlencoded");

			connection.setRequestProperty("Accept", applicationJSonContentType);

			PrintStream os = new PrintStream(connection.getOutputStream());

			os.print(content);

			os.close();

			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String line = null;

			StringWriter out = new StringWriter(
					connection.getContentLength() > 0 ? connection.getContentLength() : 2048);

			while ((line = reader.readLine()) != null) {

				out.append(line);
			}
			String response = out.toString();

			Matcher matcher = pat.matcher(response);

			if (matcher.matches() && matcher.groupCount() > 0) {

				returnValue = matcher.group(1);
			}

		} catch (Exception e) {

			e.getMessage();

		} finally {

			if (reader != null) {

				try {

					reader.close();

					connection.disconnect();

				} catch (IOException e) {
					e.getMessage();
				}
			}


		}

		return returnValue;
	}


	// get workflow info from workflow id and workspace id
	public static String getEntityInfoUsingID(String workspaceid, String urlPath, String getid) {
		String jsonEntity = null;
		try {

			if(ConstantProperty.apiReadURL.contains("https")) {
				ConstantProperty.apiReadURL=ConstantProperty.apiReadURL.replace("https", "http");
			}

			String auto = getOAuthBearerTokenBasedOnIcedqRole(ConstantProperty.apiReadURL, ConstantProperty.apiReadOrgID, ConstantProperty.API_READ_USERNAME, ConstantProperty.API_READ_PASSWORD);

			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpGet getRequest = new HttpGet(BaseSuite.baseURL + urlPath+"/" + getid);

			getRequest.setHeader(apicontentType, applicationJSonContentType);

			getRequest.setHeader(apiworkspaceId, workspaceid);

			getRequest.setHeader(apiorgId, ConstantProperty.apiReadOrgID);

			getRequest.setHeader(authorization, apiBearer + auto);

			HttpResponse response;

			response = httpClient.execute(getRequest);

			log.info("response---------------- " + response);

			int statusCode = response.getStatusLine().getStatusCode();

			log.info("Status code for getting issues ----------- " + statusCode);

			HttpEntity entity1 = response.getEntity();

			jsonEntity = EntityUtils.toString(entity1);


		} catch (Exception e) {

			e.getMessage();
		}
		return jsonEntity;
	}


	public static  ArrayList<String> getJsonArrayValueUsingJsonPathExpreesion(String jsonEntity, String expression) {
		ArrayList<String> list = new ArrayList<>();

		try {

			BufferedReader buffer = new BufferedReader(new StringReader(jsonEntity));

			String line = null;

			StringBuilder buider = new StringBuilder();

			while ((line = buffer.readLine()) != null) {
				buider.append(line);

			}

			String jsonContent = buider.toString();

			Configuration conf = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
					.options(Option.ALWAYS_RETURN_LIST, Option.SUPPRESS_EXCEPTIONS).build();

			ArrayNode node = JsonPath.using(conf).parse(jsonContent).read(expression);

			for (Object o : node) {

				String value1 = o.toString().replace("\"", "");

				list.add(value1);

			}

		} catch (Exception e) {

			e.getMessage();
		}

		return list;

	}

	public static String getJsonValueUsingJsonPathExpreesion(String jsonEntity, String expression) {
		String value = null;

		try {

			BufferedReader buffer = new BufferedReader(new StringReader(jsonEntity));

			String line = null;

			StringBuilder buider = new StringBuilder();

			while ((line = buffer.readLine()) != null) {
				buider.append(line);

			}

			String jsonContent = buider.toString();

			log.info(jsonContent);

			Configuration conf = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
					.options(Option.ALWAYS_RETURN_LIST, Option.SUPPRESS_EXCEPTIONS).build();

			ArrayNode node = JsonPath.using(conf).parse(jsonContent).read(expression);

			for (Object o : node) {

				value = o.toString().replace("\"", "");
			}

		} catch (Exception e) {

			e.getMessage();
		}

		return value;

	}


	public String getJsonValueFromAPI(String workspaceid, String urlPath, String getid, String jsonPath) {

		String jsonValue="";

		if(getid!=null) {

			String jsonEntity = getEntityInfoUsingID(workspaceid, urlPath, getid);

			jsonValue= getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPath);
		}

		return jsonValue;
	}


	public String addKeyPairValueInJson(String jsonEntity, String objectName,int index, String newKey, String newValue) {

		if(!newKey.isEmpty()) {
			// Parse JSON string to JsonObject
			Gson gson = new Gson();
			JsonObject jsonObject = JsonParser.parseString(jsonEntity).getAsJsonObject();

			// Retrieve the "activities" array
			JsonObject firstActivity = jsonObject.getAsJsonArray(objectName).get(index).getAsJsonObject();

			// Add the new key-value pair to the first activity
			if(newKey.contains(",")) {
				String[] newKeys= newKey.split(",");
				String[] newValues= newValue.split(",");

				for (int j = 0; j < newKeys.length; j++) {
					firstActivity.addProperty(newKeys[j], newValues[j]);
				}
			}else {
				firstActivity.addProperty(newKey, newValue);
			}

			// Convert JsonObject back to JSON string
			jsonEntity = gson.toJson(jsonObject);
			log.info("addKeyPairValueInJson, Responce--- "+jsonEntity);
		}
		return jsonEntity;
	}

	public String addKeyPairValueInJson(String jsonEntity, String newKey, String newValue) {

		if(!newKey.isEmpty()) {
			// Parse the JSON response into a JSONObject
			JSONObject jsonObject = new JSONObject(jsonEntity);

			// Add a new key-value pair
			jsonObject.put(newKey, newValue);

			// Convert the JSONObject back to a JSON string
			String updatedJsonResponse = jsonObject.toString();

			jsonEntity = updatedJsonResponse;

			log.info("addKeyPairValueInJson, Responce--- "+jsonEntity);
		}
		return jsonEntity;
	}

	// get list of custom workflow id from workspace

	public static List<String> getListRestAssuredPostRequest(String token, String workspaceId,String requestURL, String requestJson, String jsonPath) {
		try {

			OkHttpClient client = new OkHttpClient().newBuilder().build();

			MediaType mediaType = MediaType.parse(contentType);

			RequestBody body = RequestBody.create(mediaType,requestJson);

			Request request = new Request.Builder()

					.url(requestURL).method("POST", body)

					.addHeader("content-type", contentType)

					.addHeader(apiworkspaceId, workspaceId)

					.addHeader(apiorgId, ConstantProperty.apiReadOrgID)

					.addHeader(authetication, apiBearer + token)

					.build();

			Response response = client.newCall(request).execute();

			String r = response.body().string();

			return getJsonArrayValueUsingJsonPathExpreesion(r, jsonPath);

		} catch (Exception e) {

			e.getMessage();
		}
		return Collections.emptyList();

	}

	public String getWorkflowInfo(String workspaceId, String workflowId) {

		String jsonPathName= "$.name";
		String jsonPathActivities="activities";
		String workflowJson=null;
		try {
			workflowJson= getEntityInfoUsingID(workspaceId, "api/v1/workflows", workflowId);

			String wkflfolderId = getJsonValueUsingJsonPathExpreesion(workflowJson, "$.folderId");

			String wkflfolderName = getJsonValueFromAPI(workspaceId, "api/v1/folders", wkflfolderId, jsonPathName);

			workflowJson=addKeyPairValueInJson(workflowJson,"folderName", wkflfolderName);

			ArrayList<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJson, "$.activities..objectId");

			for(int i=0;i<ruleList.size();i++) {

				String ruleJson = getEntityInfoUsingID(workspaceId, "api/v1/rules", ruleList.get(i));

				String rulefolderId = getJsonValueUsingJsonPathExpreesion(ruleJson, "$.folderId");

				String ruleParameterId = getJsonValueUsingJsonPathExpreesion(ruleJson, "$.properties.parameterId");

				String ruleSourceConnection = getJsonValueUsingJsonPathExpreesion(ruleJson, "$.objects[0].connectionId");

				String ruleTargetConnection = getJsonValueUsingJsonPathExpreesion(ruleJson, "$.objects[1].connectionId");

				String folderName = getJsonValueFromAPI(workspaceId, "api/v1/folders", rulefolderId, jsonPathName);

				String parameterName = getJsonValueFromAPI(workspaceId, "api/v1/parameters", ruleParameterId, jsonPathName);

				String soureConn = getJsonValueFromAPI(workspaceId, "api/v1/connections", ruleSourceConnection, jsonPathName);

				String targetConn = getJsonValueFromAPI(workspaceId, "api/v1/connections", ruleTargetConnection, jsonPathName);

				workflowJson=addKeyPairValueInJson(workflowJson,jsonPathActivities,i, "folderName", folderName);

				workflowJson=addKeyPairValueInJson(workflowJson,jsonPathActivities,i, "parameterName", parameterName);

				workflowJson=addKeyPairValueInJson(workflowJson,jsonPathActivities,i, "sourceConnection", soureConn);

				workflowJson=addKeyPairValueInJson(workflowJson,jsonPathActivities,i, "targetConnection", targetConn);

			}

		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return workflowJson;
	}

	 **/
}
