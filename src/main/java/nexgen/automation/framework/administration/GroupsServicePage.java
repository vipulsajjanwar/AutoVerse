package nexgen.automation.framework.administration;

import java.util.List;
import java.util.NoSuchElementException;
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
import nextgen.automation.workflow.service.pages.WorkflowPage;

public class GroupsServicePage extends PageUtil {

	WebDriver driver;

	public GroupsServicePage(WebDriver driver) {
		this.driver = driver;
	}

	protected static final Logger log = Logger.getLogger(GroupsServicePage.class);
	static String dirPath=System.getProperty("user.dir");

	public final String groupEXCELFILEPATH = System.getProperty("user.dir")+ Constant.NEXTGEN_GROUPS_TESTDATA_EXCEL_PATH;
	public static final String PARAMETERPRIVILEGEFORBIDDENMESSAGE=prop.getProperty("workflow.toast.forbidden.Message");


	/** ----------------------  By locators ---------------------------------- **/

	By dashboardtab=getElementLocator(prop.getProperty("module.tab.dashboard"));
	By datatestingtab=getElementLocator(prop.getProperty("module.tab.datatesting"));
	By schedulertab=getElementLocator(prop.getProperty("module.tab.scheduler"));
	By connectionstab=getElementLocator(prop.getProperty("module.tab.connections"));
	By administrationtab=getElementLocator(prop.getProperty("module.tab.administration"));
	By dmoTab=getElementLocator(prop.getProperty("module.tab.dmo"));
	By knowledgeGraphTab=getElementLocator(prop.getProperty("module.tab.knowledgegraph"));
	By incidentManagementTab=getElementLocator(prop.getProperty("module.tab.incidentManagement"));
	By dataObservabilityTab=getElementLocator(prop.getProperty("module.tab.dataObservability"));

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
	By userProfile = getElementLocator(prop.getProperty("Home.userProfile"));
	By toastMsg=getElementLocator(prop.getProperty("Workflow.Toast.Message"));
	By toastMsgClosedBtn=getElementLocator(prop.getProperty("Workflow.Toast.Close"));

	By groupsPageTitle=getElementLocator(prop.getProperty("groups.page.title"));

	By breadcrumbHomeLink=getElementLocator(prop.getProperty("groups.breadcrumb.homelink"));
	By breadcrumbAdministrationLink=getElementLocator(prop.getProperty("groups.breadcrumb.administrationlink"));
	By breadcrumbGroupsLink=getElementLocator(prop.getProperty("groups.breadcrumb.grouplink"));
	By breadcrumbGroups=getElementLocator(prop.getProperty("groups.breadcrumb.group"));
	By breadcrumbCreateNewGroup=getElementLocator(prop.getProperty("groups.breadcrumb.createNewGroup"));

	By groupListingNewGroupButton=getElementLocator(prop.getProperty("groups.listing.button.newGroup"));
	By groupListingRefreshIcon=getElementLocator(prop.getProperty("groups.listing.button.refresh"));
	By groupListingDeleteIcon=getElementLocator(prop.getProperty("groups.listing.button.delete"));
	By groupListingSearchField=getElementLocator(prop.getProperty("groups.listing.search.field"));
	By groupListingSearchButton=getElementLocator(prop.getProperty("groups.listing.search.button"));
	By groupListingSearchClearIcon=getElementLocator(prop.getProperty("groups.listing.search.clear"));
	By groupListingMasterCheckbox=getElementLocator(prop.getProperty("groups.listing.mastercheckbox"));
	By groupListingColumnName=getElementLocator(prop.getProperty("groups.listing.column.groupName"));
	By groupListingColumnDescription=getElementLocator(prop.getProperty("groups.listing.column.description"));
	By groupListingColumnIdentity=getElementLocator(prop.getProperty("groups.listing.column.identity"));
	By groupListingNoRecordsToDisplay=getElementLocator(prop.getProperty("groups.listing.NoRecordsToDisplay"));
	By groupListingGroupName=getElementLocator(prop.getProperty("groups.listing.groupNamestatic"));
	By groupListingDescription=getElementLocator(prop.getProperty("groups.listing.description"));
	By groupListingIdentity=getElementLocator(prop.getProperty("groups.listing.identity"));
	By groupListingPaginationBar=getElementLocator(prop.getProperty("groupd.listing.users.paginationbar"));
	By groupListingPaginationMsg=getElementLocator(prop.getProperty("groupd.listing.users.paginationMsg"));

	By groupDetailsSaveButton=getElementLocator(prop.getProperty("groups.details.button.save"));
	By groupDetailsDiscardButton=getElementLocator(prop.getProperty("groups.details.button.discard"));
	By groupDetailsDeleteButton=getElementLocator(prop.getProperty("groups.details.button.delete"));
	By groupDetailsAdminAccessButton=getElementLocator(prop.getProperty("groups.details.button.adminaccess"));
	By groupDetailsRevokeAdminAccessButton=getElementLocator(prop.getProperty("groups.details.button.revokeAdminAccess"));
	By groupDetailsTitleStatic=getElementLocator(prop.getProperty("groups.details.titleStatic"));
	By groupDetailsAdminAccessIcon=getElementLocator(prop.getProperty("groups.details.adminAccess.Icon"));
	By groupDetailsNameTitle=getElementLocator(prop.getProperty("groups.details.groupname.title"));
	By groupDetailsNameField=getElementLocator(prop.getProperty("groups.details.groupname.field"));
	By groupDetailsNameValidation=getElementLocator(prop.getProperty("groups.details.groupname.validation"));
	By groupDetailsDescriptionTitle=getElementLocator(prop.getProperty("groups.details.description.title"));
	By groupDetailsDescriptionField=getElementLocator(prop.getProperty("groups.details.description.field"));
	By groupDetailsDescriptionValidation=getElementLocator(prop.getProperty("groups.details.description.validation"));
	By groupDetailsUsersTab=getElementLocator(prop.getProperty("groups.details.users.tab"));
	By groupDetailsAccountsTab=getElementLocator(prop.getProperty("groups.details.accounts.tab"));
	By groupDetailsWorkspacesTab=getElementLocator(prop.getProperty("groups.details.workspaces.tab"));
	By groupDetailsAddUsersButton=getElementLocator(prop.getProperty("groups.details.button.add.users"));
	By groupDetailsRefreshUsers=getElementLocator(prop.getProperty("groups.details.button.users.refresh"));
	By groupDetailsDeleteUsers=getElementLocator(prop.getProperty("groups.details.button.users.delete"));
	By groupDetailsSearchUserField=getElementLocator(prop.getProperty("groups.details.search.user.field"));
	By groupDetailsSearchUserButton=getElementLocator(prop.getProperty("groups.details.search.user.button"));
	By groupDetailsSearchUserClear=getElementLocator(prop.getProperty("groups.details.search.user.clear"));
	By groupDetailsUsersMasterCheckbox=getElementLocator(prop.getProperty("groups.details.users.mastercheckbox"));
	By groupDetailsUserNameColumn=getElementLocator(prop.getProperty("groups.details.users.column.name"));
	By groupDetailsUsersStatusColumn=getElementLocator(prop.getProperty("groups.details.users.column.status"));
	By groupDetailsUserNoRecordsToDisplay=getElementLocator(prop.getProperty("groups.details.users.NoRecordsToDisplay"));
	By groupDetailsGroupAvatarIcon=getElementLocator(prop.getProperty("groups.details.groupAvatar"));

	By groupDetailsRefreshAccounts=getElementLocator(prop.getProperty("groups.details.button.accounts.refresh"));
	By groupDetailsSearchAccountField=getElementLocator(prop.getProperty("groups.details.search.accounts.field"));
	By groupDetailsSearchAccountButton=getElementLocator(prop.getProperty("groups.details.search.accounts.button"));
	By groupDetailsSearchAccountClear=getElementLocator(prop.getProperty("groups.details.search.accounts.clear"));
	By groupDetailsAccountNameColumn=getElementLocator(prop.getProperty("groups.details.accounts.column.name"));
	By groupDetailsAccountRoleColumn=getElementLocator(prop.getProperty("groups.details.accounts.column.role"));
	By groupDetailsAccountScopeColumn=getElementLocator(prop.getProperty("groups.details.accounts.column.scope"));
	By groupDetailsAccountNoRecordsToDisplay=getElementLocator(prop.getProperty("groups.details.accounts.NoRecordsToDisplay"));

	By groupDetailsRefreshWorkspaces=getElementLocator(prop.getProperty("groups.details.button.workspaces.refresh"));
	By groupDetailsSearchWorkspaceField=getElementLocator(prop.getProperty("groups.details.search.workspaces.field"));
	By groupDetailsSearchWorkspaceButton=getElementLocator(prop.getProperty("groups.details.search.workspaces.button"));
	By groupDetailsSearchWorkspaceClear=getElementLocator(prop.getProperty("groups.details.search.workspaces.clear"));
	By groupDetailsWorkspaceNameColumn=getElementLocator(prop.getProperty("groups.details.workspaces.column.name"));
	By groupDetailsWorkspaceRoleColumn=getElementLocator(prop.getProperty("groups.details.workspaces.column.role"));
	By groupDetailsWorkspaceTypeColumn=getElementLocator(prop.getProperty("groups.details.workspaces.column.type"));
	By groupDetailsWorkspaceScopeColumn=getElementLocator(prop.getProperty("groups.details.workspaces.column.scope"));
	By groupDetailsWorkspaceNoRecordsToDisplay=getElementLocator(prop.getProperty("groups.details.workspaces.NoRecordsToDisplay"));

	By groupDetailsUsersPaginationBar=getElementLocator(prop.getProperty("groupd.details.users.paginationbar"));
	By groupDetailsAccountsPaginationBar=getElementLocator(prop.getProperty("groupd.details.accounts.paginationbar"));
	By groupDetailsWorkspacesPaginationBar=getElementLocator(prop.getProperty("groupd.details.workspaces.paginationbar"));

	By groupDetailsUsersPaginationMsg=getElementLocator(prop.getProperty("groupd.details.users.paginationMsg"));
	By groupDetailsAccountsPaginationMsg=getElementLocator(prop.getProperty("groupd.details.accounts.paginationMsg"));
	By groupDetailsWorkspacesPaginationMsg=getElementLocator(prop.getProperty("groupd.details.workspaces.paginationMsg"));

	By groupDetailsSidebarAddUserTitle=getElementLocator(prop.getProperty("groups.details.sidebar.add.users.title"));
	By groupDetailsSidebarAddUserCross=getElementLocator(prop.getProperty("groups.details.sidebar.add.users.cross"));
	By groupDetailsSidebarAddUserLabel=getElementLocator(prop.getProperty("groups.details.sidebar.add.users.Userlabel"));
	By groupDetailsSidebarAddUserSearchField=getElementLocator(prop.getProperty("groups.details.sidebar.add.users.searchfield"));
	By groupDetailsSidebarAddUserLoadMore=getElementLocator(prop.getProperty("groups.details.sidebar.add.users.loadmore"));
	By groupDetailsSidebarAddUserDiscardButton=getElementLocator(prop.getProperty("groups.details.sidebar.add.users.discardbutton"));
	By groupDetailsSidebarAddUserAddButton=getElementLocator(prop.getProperty("groups.details.sidebar.add.users.addbutton"));
	By groupDetailsSidebarAddUserListCount=getElementLocator(prop.getProperty("groups.details.sidebar.add.users.listcount"));

	By groupDetailsPopupDeleteTitle=getElementLocator(prop.getProperty("groups.details.popup.delete.title"));
	By groupDetailsPopupDeleteContent=getElementLocator(prop.getProperty("groups.details.popup.delete.content"));
	By groupDetailsPopupDeleteButton=getElementLocator(prop.getProperty("groups.details.popup.delete.deletebutton"));
	By groupDetailsPopupDeleteCancelButton=getElementLocator(prop.getProperty("groups.details.popup.delete.cancelbutton"));

	By groupDetailsPopupDiscardTitle=getElementLocator(prop.getProperty("groups.details.popup.discard.title"));
	By groupDetailsPopupDiscardContent=getElementLocator(prop.getProperty("groups.details.popup.discard.content"));
	By groupDetailsPopupDiscardButton=getElementLocator(prop.getProperty("groups.details.popup.discard.discardbutton"));
	By groupDetailsPopupDiscardCancelButton=getElementLocator(prop.getProperty("groups.details.popup.discard.cancelbutton"));

	By groupDetailsPopupDeleteUserTitle=getElementLocator(prop.getProperty("groups.details.popup.delete.user.title"));
	By groupDetailsPopupDeleteUserContent=getElementLocator(prop.getProperty("groups.details.popup.delete.user.content"));
	By groupDetailsPopupDeleteUserButton=getElementLocator(prop.getProperty("groups.details.popup.delete.user.deletebutton"));
	By groupDetailsPopupDeleteUserCancelButton=getElementLocator(prop.getProperty("groups.details.popup.delete.user.cancelbutton"));

	By groupDetailsHandleDiscardPopup=getElementLocator(prop.getProperty("groups.details.handle.discard"));

	By ldapGroupsCheckbox=getElementLocator(prop.getProperty("groups.listing.LDAP.group.checkboxs"));
	By ldapGroupsNames=getElementLocator(prop.getProperty("groups.listing.LDAP.group.names"));
	By groupsListingNextPageArrow=getElementLocator(prop.getProperty("groups.listing.nextpageArrow"));

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

	By usersListingSearchField=getElementLocator(prop.getProperty("users.listing.search.field"));
	By usersListingSearchButton=getElementLocator(prop.getProperty("users.listing.search.button"));
	By usersListingSearchClearIcon=getElementLocator(prop.getProperty("users.listing.search.clear"));

	By workspaceFieldDropdown=getElementLocator(prop.getProperty("workspace.dropdown.field"));
	By usersListingNoRecordsToDisplay=getElementLocator(prop.getProperty("users.details.users.NoRecordsToDisplay"));

	By groupsListingButtonsCount=getElementLocator(prop.getProperty("button.count.listing.groups"));
	By groupsDetailsBeforeCreateButtonsCount=getElementLocator(prop.getProperty("button.count.details.groups"));
	/** ----------------------  String variables ---------------------------------- **/

	String moduleTab=prop.getProperty("nextgen.hamberger.tab");
	String subModuleTab=prop.getProperty("nextgenmodule.submodule.tab");
	String subModuleHeadingName=prop.getProperty("nextgenmodule.submodule.headingDynamic");
	String dynamicName=prop.getProperty("DynName");
	String nextgenSubModuleDynamic=prop.getProperty("nextgenmodule.submodule.dynamic");

	String groupListingGroupNameCheckbox=prop.getProperty("groups.listing.checkbox.groupNamedynamic");
	String groupListingGroupAvatar=prop.getProperty("groups.listing.avatar.groupNamedynamic");
	String groupListingGroupNameHyperlink=prop.getProperty("groups.listing.groupNamedynamic");
	String groupListingGroupNameAdminIcon=prop.getProperty("groups.listing.adminIcon.groupNamedynamic");
	String groupListingGroupLogo=prop.getProperty("groups.listing.logo.groupNamedynamic");
	String groupListingDescriptionByName=prop.getProperty("groups.listing.descriptiondynamic");
	String groupListingIdentityByName=prop.getProperty("groups.listing.identitydynamic");

	String placeholderSearchGroup=prop.getProperty("groups.placeholder.searchgroup");
	String placeholderGroupName=prop.getProperty("groups.placeholder.groupname");
	String placeholderGroupDescription=prop.getProperty("groups.placeholder.description");
	String placeholderSearchUser=prop.getProperty("groups.placeholder.searchuser");
	String placeholderSearchAccount=prop.getProperty("groups.placeholder.searchaccount");
	String placeholderSearchWorkspace=prop.getProperty("groups.placeholder.searchworkspace");

	String fieldNameEmpty=prop.getProperty("groups.field.name.empty");
	String fieldNameInvalid=prop.getProperty("groups.field.name.invalid");
	String fieldNameMaxChar=prop.getProperty("groups.field.name.maxcharacter");
	String fieldDescMaxChar=prop.getProperty("groups.field.description.maxcharacter");

	String toastGroupCreated=prop.getProperty("groups.toast.created");
	String toastGroupDeleted=prop.getProperty("groups.toast.deleted");
	String toastGroupMultipleDelete=prop.getProperty("groups.toast.delete.multiple");

	String groupDetailsTitle=prop.getProperty("groups.details.titleDynamic");

	String groupDetailsUserFullName=prop.getProperty("groups.details.users.namedynamic");
	String groupDetailsUserStatus=prop.getProperty("groups.details.users.statusdynamic");
	String groupDetailsUserCheckbox=prop.getProperty("groups.details.users.checkbox.namedynamic");
	String groupDetailsUserAvatar=prop.getProperty("groups.details.users.name.avatar");
	String groupDetailsUserAdminIcon=prop.getProperty("groups.details.users.nameAdminIcondynamic");

	String groupDetailsAccountName=prop.getProperty("groups.details.accounts.namedynamic");
	String groupDetailsAccountAvatar=prop.getProperty("groups.details.accounts.avatardynamic");
	String groupDetailsAccountRole=prop.getProperty("groups.details.accounts.roledynamic");
	String groupDetailsAccountScope=prop.getProperty("groups.details.accounts.scopedynamic");

	String groupDetailsWorkspaceName=prop.getProperty("groups.details.workspaces.namedynamic");
	String groupDetailsWorkspaceAvatar=prop.getProperty("groups.details.workspaces.avatardynamic");
	String groupDetailsDataMonitoringWorkspaceAvatar=prop.getProperty("groups.details.DataMonitoringWorkspaces.avatardynamic");
	String groupDetailsWorkspaceRole=prop.getProperty("groups.details.workspaces.roledynamic");
	String groupDetailsWorkspaceType=prop.getProperty("groups.details.workspaces.typedynamic");
	String groupDetailsWorkspaceScope=prop.getProperty("groups.details.workspaces.scopedynamic");

	String groupDetailsSidebarAddUserFullName=prop.getProperty("groups.details.sidebar.add.users.fullnamedynamic");
	String groupDetailsSidebarAddUserFullNameCheckbox=prop.getProperty("groups.details.sidebar.add.users.fullnamecheckboxdynamic");

	String breadcrumbGroupName=prop.getProperty("groups.details.breadcrumb.groupnamedynamic");
	String breadcrumbGroupid=prop.getProperty("groups.details.breadcrumb.groupiddynamic");

	String popupDeleteGroupTitle=prop.getProperty("groups.title.single.deletegroup");
	String popupDeleteGroupContent=prop.getProperty("groups.content.single.deletegroup");
	String popupDeleteMultipleGroupTitle=prop.getProperty("groups.title.multiple.deletegroup");
	String popupDeleteMultipleGroupContent=prop.getProperty("groups.content.multiple.deletegroup");
	String popupDiscardGroupTitle=prop.getProperty("groups.title.single.discardgroup");
	String popupDiscardGroupContent=prop.getProperty("groups.content.single.discardgroup");	
	String popupDeleteSingleUserTitle=prop.getProperty("groups.title.single.deleteuser");
	String popupDeleteSingleUserContent=prop.getProperty("groups.content.single.deleteuser");	
	String popupDeleteMultipleUserTitle=prop.getProperty("groups.title.multiple.deleteuser");
	String popupDeleteMultipleUserContent=prop.getProperty("groups.content.multiple.deleteuser");

	String usersListingFullNameDynamic=prop.getProperty("users.details.users.namedynamic");
	String usersDetailsUserStatus=prop.getProperty("users.details.users.statusdynamic");
	String usersDetailsUserCheckbox=prop.getProperty("users.details.users.checkbox.namedynamic");
	String usersDetailsUserAvatar=prop.getProperty("users.details.users.name.avatar");
	String usersDetailsUserAdminIcon=prop.getProperty("users.details.users.nameAdminIcondynamic");

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
	String createNewGroupContent=prop.getProperty("String.createNewGroupContent");
	String moduleContent=prop.getProperty("String.moduleContent");
	String subModuleContent=prop.getProperty("String.subModuleContent");
	String columnContent=prop.getProperty("String.columnContent");
	String tabContent=prop.getProperty("String.tabContent");
	String iconContent=prop.getProperty("String.iconContent");
	String newGroupContent=prop.getProperty("String.newGroupContent");
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
	String sanityContent ="sanity";
	/** ----------------------  Generic methods ---------------------------------- **/

	//validate field 
	public boolean viewAndValidateField(By locator, String label, String expectedValue, boolean state) {

		boolean flag = true;
		String methodName="viewAndValidateField";
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 3, locator);

			javascript(driver, scrollToElementArg, locator);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, locator)) {			

				checkFieldEnabledOrNot(driver, locator, label, state);

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


	public boolean validatAndeEnterValueToTextField(By labelLocator, By fieldLocator,By fieldValidLocator, String label, String placeHolder, String input, String fieldValidation) throws NoSuchElementException {
		boolean flag =true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 4, labelLocator);

			javascript(driver, scrollToElementArg, labelLocator);

			verifyIndividualLabel(driver, labelLocator, label);

			if (isDisplayed(driver, fieldLocator)) {

				isClickable(driver, fieldLocator,label, true);

				verifyPlaceHolderValue(driver, fieldLocator, label, placeHolder);

				if(input==null) {
					input="";
				}
				if(!input.isEmpty()) {	

					click(driver, fieldLocator);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					sendKeys(driver, fieldLocator, "a");

					clear(driver, fieldLocator);

					validationMessageOfField(driver,fieldValidLocator, label, fieldValidation, true);

					BaseSuite.reportLog("Entering value : " + input);

					sendKeys(driver, fieldLocator, input);

					String ac = getAttribute(driver, fieldLocator, attributeValue);

					flag = stringContainsOutput(ac, input, true);

					validationMessageOfField(driver,fieldValidLocator, label, fieldValidation, false);
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

	//common search method
	public boolean searchFunctionalityMethod(boolean flag, By searchbar, By searchButton,String searchLabel, String placeholder, String searchValue ) {
		String methodName = "searchFunctionalityMethod";

		try {
			if(flag) {
				isDisplayedInLoop(driver, 2, searchbar);

				if(isDisplayed(driver, searchbar)) {

					flag=isClickable(driver, searchbar,searchBoxLabel, flag);

					if(flag) {

						flag=verifySearchField(driver, searchbar, searchLabel, placeholder);

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

	//groupMethods

	public boolean clickOnRefreshOnGroupsListingPage() {

		return clickOnButton(driver, groupListingRefreshIcon, refreshContent, true);
	}

	public boolean clickOnRefreshOnGroupsListingPageWithValidation() {
		boolean flag=true;

		clickOnButton(driver, groupListingRefreshIcon, refreshContent, true);

		waitForExecution(100);

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		if(isDisplayed(driver, toastMsg)) {
			flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
					"Groups tab refresh authorization message");
		}

		return flag;
	}

	public String getGroupIdOnGroupDetailsPage(String groupName) {
		String id =null;
		try {
			isDisplayedInLoop(driver, 3, returnElement(breadcrumbGroupid, dynamicName, groupName));

			if(groupName.length()<100) {

				if(isDisplayed(driver, returnElement(breadcrumbGroupid, dynamicName, groupName))) {

					id = getText(driver, returnElement(breadcrumbGroupid, dynamicName, groupName));

					id = id.replaceAll(regexToRemoveBracess, "");

					BaseSuite.reportLog("Group id is :: "+id);
				}else {
					BaseSuite.reportFailLog("Group id is not visible ", "getGroupIdOnGroupDetailsPage");

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" getGroupIdOnGroupDetailsPage :: "+e.toString());

		}
		return id;
	}

	public boolean validateGroupListingPage() {
		boolean flag=true;
		HomePage hp=new HomePage(driver);

		try {
			hp.validateNextgenIcedqModuleAndAdministrationSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Groups listing page "+hyphenContent);

			validateElement(driver, breadcrumbHomeLink, homeContent, hyperlinkContent);

			validateElement(driver, breadcrumbAdministrationLink, administrationContent, labelContent);

			validateElement(driver, breadcrumbGroups, groupsContent, labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying Title and Search field Groups listing page "+hyphenContent);

			verifyIndividualLabel(driver, groupsPageTitle, groupsContent);

			verifySearchField(driver, groupListingSearchField, placeholderSearchGroup, placeholderSearchGroup);

			validateElement(driver, groupListingSearchButton, placeholderSearchGroup, "button");

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Groups listing page "+hyphenContent);

			validateButtons(driver, groupsListingButtonsCount, 3);

			verifyVisibilityOfButtons(driver, groupListingNewGroupButton, newGroupContent, true);
			verifyVisibilityOfButtons(driver, groupListingRefreshIcon, refreshContent, true);
			verifyVisibilityOfButtons(driver, groupListingDeleteIcon, deleteContent, false);

			BaseSuite.reportLog(hyphenContent+"  Verifying Columns on Groups listing page "+hyphenContent);

			validateElement(driver, groupListingMasterCheckbox, masterContent, "Checkbox");
			validateElement(driver, groupListingColumnName, "Name",columnContent);
			validateElement(driver, groupListingColumnDescription, descriptionContent, columnContent);
			validateElement(driver, groupListingColumnIdentity, "Identity", columnContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on Groups listing page "+hyphenContent);

			getPaginationDetails(driver,groupListingPaginationMsg, groupListingPaginationBar,groupListingNoRecordsToDisplay, "Group listing page");

			BaseSuite.validationReportLog(hyphenContent+" Groups listing page validated successfully "+hyphenContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateGroupListingPage :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean validateGroupDetailPageBeforeCreating() {
		boolean flag = true;
		HomePage hp=new HomePage(driver);
		try {
			hp.validateNextgenIcedqModuleAndAdministrationSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Groups details page "+hyphenContent);

			validateElement(driver, breadcrumbHomeLink, homeContent, hyperlinkContent);

			validateElement(driver, breadcrumbAdministrationLink, administrationContent, hyperlinkContent);

			validateElement(driver, breadcrumbGroupsLink, groupsContent, hyperlinkContent);

			validateElement(driver, breadcrumbCreateNewGroup, createNewGroupContent, labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Groups details page "+hyphenContent);

			validateButtons(driver, groupsDetailsBeforeCreateButtonsCount, 6);

			verifyVisibilityOfButtons(driver, groupDetailsSaveButton, saveContent, false);
			verifyVisibilityOfButtons(driver, groupDetailsDiscardButton, discardContent, false);
			verifyVisibilityOfButtons(driver, groupDetailsDeleteButton, deleteContent, false);

			verifyVisibilityOfButtons(driver, groupDetailsAddUsersButton, "Add", false);
			verifyVisibilityOfButtons(driver, groupDetailsRefreshUsers, refreshContent+" "+usersContent, false);
			verifyVisibilityOfButtons(driver, groupDetailsDeleteUsers, deleteContent+" "+usersContent, false);

			BaseSuite.reportLog(hyphenContent+" Verifying tabs on Groups details page "+hyphenContent);

			validateElement(driver, groupDetailsUsersTab, usersContent, tabContent);
			validateElement(driver, groupDetailsAccountsTab, accountsContent, tabContent);
			validateElement(driver, groupDetailsWorkspacesTab, accountsContent, tabContent);

			verifySearchField(driver, groupDetailsSearchUserField, placeholderSearchUser, placeholderSearchUser);

			validateElement(driver, groupDetailsSearchUserButton, placeholderSearchUser, iconContent);

			BaseSuite.reportLog(hyphenContent+" Verifying columns of users tab "+hyphenContent);

			validateElement(driver, groupDetailsUsersMasterCheckbox, masterContent, checkboxContent);
			validateElement(driver, groupDetailsUserNameColumn, "Name", columnContent);
			validateElement(driver, groupDetailsUsersStatusColumn, "Status", columnContent);

			validateElement(driver, groupDetailsUserNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on users tab "+hyphenContent);

			getPaginationDetails(driver,groupDetailsUsersPaginationMsg, groupDetailsUsersPaginationBar,groupDetailsUserNoRecordsToDisplay, usersContent+" "+tabContent);

			clickOnAccountsTabGroupDetails();

			verifySearchField(driver, groupDetailsSearchAccountField, placeholderSearchAccount, placeholderSearchAccount);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Accounts "+tabContent+" "+hyphenContent);

			verifyVisibilityOfButtons(driver, groupDetailsRefreshAccounts, refreshContent, false);

			BaseSuite.reportLog(hyphenContent+" Verifying columns of Accounts "+tabContent+" "+hyphenContent);

			validateElementVisibility(driver, groupDetailsAccountNameColumn, "Name", columnContent, true);

			validateElementVisibility(driver, groupDetailsAccountRoleColumn, roleContent, columnContent, true);

			validateElementVisibility(driver, groupDetailsAccountScopeColumn, scopeContent, columnContent, true);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on Accounts "+tabContent+" "+hyphenContent);

			getPaginationDetails(driver, groupDetailsAccountsPaginationMsg, groupDetailsAccountsPaginationBar, groupDetailsAccountNoRecordsToDisplay, accountsContent+" "+tabContent);

			clickOnWorkspacesTabGroupDetails();

			verifySearchField(driver, groupDetailsSearchWorkspaceField, placeholderSearchWorkspace, placeholderSearchWorkspace);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Workspaces "+tabContent+" "+hyphenContent);

			verifyVisibilityOfButtons(driver, groupDetailsRefreshWorkspaces, refreshContent, false);

			BaseSuite.reportLog(hyphenContent+" Verifying columns of Workspaces "+tabContent+" "+hyphenContent);

			validateElementVisibility(driver, groupDetailsWorkspaceNameColumn, "Name", columnContent, true);

			validateElementVisibility(driver, groupDetailsWorkspaceRoleColumn, roleContent, columnContent, true);

			validateElementVisibility(driver, groupDetailsWorkspaceTypeColumn, typeContent, columnContent, true);

			validateElementVisibility(driver, groupDetailsWorkspaceScopeColumn, scopeContent, columnContent, true);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on Workspaces "+tabContent+" "+hyphenContent);

			getPaginationDetails(driver, groupDetailsWorkspacesPaginationMsg, groupDetailsWorkspacesPaginationBar, groupDetailsWorkspaceNoRecordsToDisplay, workspacesContent+" "+tabContent);

			clickOnUsersTabGroupDetails();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateGroupDetailPageBeforeCreating :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public String validateGroupDetailPageAfterNewCreated(String groupName, String groupDescription, boolean validatebutton) {
		HomePage hp=new HomePage(driver);
		String totalRecords="";
		try {
			hp.validateNextgenIcedqModuleAndAdministrationSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Groups details page "+hyphenContent);

			validateElement(driver, breadcrumbHomeLink, homeContent, hyperlinkContent);

			validateElement(driver, breadcrumbAdministrationLink, administrationContent, hyperlinkContent);

			validateElement(driver, breadcrumbGroupsLink, groupsContent, hyperlinkContent);

			validateElement(driver, returnElement(breadcrumbGroupName, dynamicName, groupName), groupName, labelContent);

			getGroupIdOnGroupDetailsPage(groupName);

			validateElementVisibility(driver, groupDetailsGroupAvatarIcon, groupContent, iconContent, true);

			validateElement(driver, returnElement(groupDetailsTitle, dynamicName, groupName), groupName, attributeTitle);

			viewAndValidateField(groupDetailsNameField, groupNameContent, groupName, true);

			viewAndValidateField(groupDetailsDescriptionField, "Description", groupDescription, true);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Groups details page "+hyphenContent);

			if(validatebutton) {validateButtons(driver, groupsDetailsBeforeCreateButtonsCount, 7);}

			verifyVisibilityOfButtons(driver, groupDetailsSaveButton, saveContent, false);
			verifyVisibilityOfButtons(driver, groupDetailsDiscardButton, discardContent, false);

			if(elementNotVisible(driver, groupDetailsAdminAccessIcon)) {

				verifyVisibilityOfButtons(driver, groupDetailsAdminAccessButton, assignAdminAccessContent, true);
			}else {
				verifyVisibilityOfButtons(driver, groupDetailsRevokeAdminAccessButton, revokeAdminAccessContent, true);
			}

			verifyVisibilityOfButtons(driver, groupDetailsDeleteButton, deleteContent, true);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Users tab "+hyphenContent);

			verifyVisibilityOfButtons(driver, groupDetailsAddUsersButton, "Add", true);
			verifyVisibilityOfButtons(driver, groupDetailsRefreshUsers, refreshContent+" "+usersContent, true);
			verifyVisibilityOfButtons(driver, groupDetailsDeleteUsers, deleteContent+" "+usersContent, false);

			BaseSuite.reportLog(hyphenContent+" Verifying tabs on Groups details page "+hyphenContent);

			validateElement(driver, groupDetailsUsersTab, usersContent, tabContent);
			validateElement(driver, groupDetailsAccountsTab, accountsContent, tabContent);
			validateElement(driver, groupDetailsWorkspacesTab, accountsContent, tabContent);

			verifySearchField(driver, groupDetailsSearchUserField, placeholderSearchUser, placeholderSearchUser);

			validateElement(driver, groupDetailsSearchUserButton, placeholderSearchUser, iconContent);

			BaseSuite.reportLog(hyphenContent+" Verifying columns of users tab "+hyphenContent);

			validateElement(driver, groupDetailsUsersMasterCheckbox, masterContent, checkboxContent);
			validateElement(driver, groupDetailsUserNameColumn, "Name", columnContent);
			validateElement(driver, groupDetailsUsersStatusColumn, "Status", columnContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on users tab "+hyphenContent);

			List<String> pageInfo=getPaginationDetails(driver, groupDetailsUsersPaginationMsg, groupDetailsUsersPaginationBar, groupDetailsUserNoRecordsToDisplay,  usersContent+" "+tabContent);

			totalRecords=pageInfo.get(1);

			clickOnAccountsTabGroupDetails();

			verifySearchField(driver, groupDetailsSearchAccountField, placeholderSearchAccount, placeholderSearchAccount);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Accounts tab "+hyphenContent);

			verifyVisibilityOfButtons(driver, groupDetailsRefreshAccounts, refreshContent, true);

			BaseSuite.reportLog(hyphenContent+" Verifying columns of Accounts tab "+hyphenContent);

			validateElementVisibility(driver, groupDetailsAccountNameColumn, "Name", columnContent, true);

			validateElementVisibility(driver, groupDetailsAccountRoleColumn, roleContent, columnContent, true);

			validateElementVisibility(driver, groupDetailsAccountScopeColumn, scopeContent, columnContent, true);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on Accounts tab "+hyphenContent);

			getPaginationDetails(driver, groupDetailsAccountsPaginationMsg, groupDetailsAccountsPaginationBar, groupDetailsAccountNoRecordsToDisplay, accountsContent+" "+tabContent);

			clickOnWorkspacesTabGroupDetails();

			verifySearchField(driver, groupDetailsSearchWorkspaceField, placeholderSearchWorkspace, placeholderSearchWorkspace);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Workspaces tab "+hyphenContent);

			verifyVisibilityOfButtons(driver, groupDetailsRefreshWorkspaces, refreshContent, true);

			BaseSuite.reportLog(hyphenContent+" Verifying columns of Workspaces tab "+hyphenContent);

			validateElementVisibility(driver, groupDetailsWorkspaceNameColumn, "Name", columnContent, true);

			validateElementVisibility(driver, groupDetailsWorkspaceRoleColumn, roleContent, columnContent, true);

			validateElementVisibility(driver, groupDetailsWorkspaceTypeColumn, typeContent, columnContent, true);

			validateElementVisibility(driver, groupDetailsWorkspaceScopeColumn, scopeContent, columnContent, true);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on Workspaces tab "+hyphenContent);

			getPaginationDetails(driver, groupDetailsWorkspacesPaginationMsg, groupDetailsWorkspacesPaginationBar, groupDetailsWorkspaceNoRecordsToDisplay, workspacesContent+" "+tabContent);

			clickOnUsersTabGroupDetails();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateGroupDetailPageAfterNewCreated :: "+e.toString());

		}
		return totalRecords;
	}

	public void handleDiscardWindow() {
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if (isDisplayed(driver, groupDetailsHandleDiscardPopup, 3)) {
				clickOnButton(driver, groupDetailsHandleDiscardPopup, discardContent, true);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" handleDiscardWindow :: "+e.toString());

		}
	}

	public boolean clickOnGroupsTab() {

		boolean flag = false;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, groupListingNewGroupButton);

			if(elementNotVisible(driver, groupListingNewGroupButton)) {

				isDisplayedInLoop(driver, 2, nextgenSubModuleGroups);

				if(isDisplayed(driver, nextgenSubModuleGroups, 3)) {

					flag = isClickable(driver, nextgenSubModuleGroups, groupsContent+" "+tabContent, true);

					if(flag) {

						BaseSuite.reportLog("Clicking on "+groupsContent+" "+tabContent);

						displayAndClick(driver, nextgenSubModuleGroups);

						handleDiscardWindow();

						BaseSuite.validationReportLog("Clicked on "+groupsContent+" "+tabContent);

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

						flag=validateElement(driver, groupsPageTitle, groupsContent, attributeTitle);

						clickOnButton(driver, groupListingRefreshIcon, refreshContent, true);

					}

				}else {
					BaseSuite.reportFailLog(groupsContent+" tab not visible", "clickOnGroupsTab");
				}
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnGroupsTab :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean clickOnGroupsTab(String expectedToastMessage) {

		boolean flag = false;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, groupListingNewGroupButton);

			if(elementNotVisible(driver, groupListingNewGroupButton)) {

				isDisplayedInLoop(driver, 2, nextgenSubModuleGroups);

				if(isDisplayed(driver, nextgenSubModuleGroups, 3)) {

					flag = isClickable(driver, nextgenSubModuleGroups, groupsContent+" "+tabContent, true);

					if(flag) {

						BaseSuite.reportLog("Clicking on "+groupsContent+" "+tabContent);

						displayAndClick(driver, nextgenSubModuleGroups);

						/**handleDiscardWindow();**/
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.validationReportLog("Clicked on "+groupsContent+" "+tabContent);

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

						captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,
								"Groups tab authorization message");

						validateElement(driver, groupsPageTitle, groupsContent, attributeTitle);

						clickOnButton(driver, groupListingRefreshIcon, refreshContent, true);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						flag = captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,
								"Groups tab authorization message");

					}

				}else {
					BaseSuite.reportFailLog(groupsContent+" tab not visible", "clickOnGroupsTab");
				}
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnGroupsTab :: "+e.toString());
			flag=false;
		}

		return flag;

	}


	public boolean clickOnNewGroupButton(String icedqUser) {

		boolean flag = true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, groupListingNewGroupButton);

			if(isDisplayed(driver, groupListingNewGroupButton)) {

				clickOnButton(driver, groupListingNewGroupButton, newGroupContent, flag);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(icedqUser.contains(adminsContent)) {

					String pgTitle=getAttribute(driver, groupsPageTitle, attributeTextContent);

					stringOutput(pgTitle.trim(), createNewGroupContent, true);

				}else{

					flag = captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
							"New Group authorization message");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnNewGroupButton :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnSaveButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {
			clickOnButton(driver, groupDetailsSaveButton, saveContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Group Created");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Group Created");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnSaveButtonAndValidateToast :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean clickOnDeleteButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {
			clickOnButton(driver, groupDetailsDeleteButton, deleteContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Group Delete");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Group Delete");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnDeleteButtonAndValidateToast :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean clickOnDeleteGroupButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {
			validatePopupWindowContent(flag, groupDetailsPopupDeleteTitle, groupDetailsPopupDeleteContent, popupDeleteGroupTitle, popupDeleteGroupContent);

			verifyVisibilityOfButtons(driver, groupDetailsPopupDeleteButton, deleteContent, true);
			verifyVisibilityOfButtons(driver, groupDetailsPopupDeleteCancelButton, cancelButtonContent, true);

			clickOnButton(driver, groupDetailsPopupDeleteButton, deleteContent, tag);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, groupContent+deleteContent);
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,groupContent+deleteContent);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnDeleteGroupButtonAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnDeleteMultipleGroupsButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {
			validatePopupWindowContent(flag, groupDetailsPopupDeleteTitle, groupDetailsPopupDeleteContent, popupDeleteMultipleGroupTitle, popupDeleteMultipleGroupContent);

			verifyVisibilityOfButtons(driver, groupDetailsPopupDeleteButton, deleteContent, true);
			verifyVisibilityOfButtons(driver, groupDetailsPopupDeleteCancelButton, cancelButtonContent, true);

			clickOnButton(driver, groupDetailsPopupDeleteButton, deleteContent, tag);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, groupContent+deleteContent);
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,groupContent+deleteContent);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnDeleteMultipleGroupsButtonAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnDiscardGroupButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {

			clickOnButton(driver, groupDetailsDiscardButton, discardContent, true);

			validatePopupWindowContent(flag, groupDetailsPopupDiscardTitle, groupDetailsPopupDiscardContent, popupDiscardGroupTitle, popupDiscardGroupContent);

			verifyVisibilityOfButtons(driver, groupDetailsPopupDiscardButton, discardContent, true);
			verifyVisibilityOfButtons(driver, groupDetailsPopupDiscardCancelButton, cancelButtonContent, true);

			clickOnButton(driver, groupDetailsPopupDiscardButton, discardContent, tag);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, groupContent+deleteContent);
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,groupContent+deleteContent);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnDiscardGroupButtonAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnDeleteUsersFromGroupButtonAndValidateToast(boolean flag, int numberOfUsers) {

		try {

			if(numberOfUsers==1) {
				validatePopupWindowContent(flag, groupDetailsPopupDeleteUserTitle, groupDetailsPopupDeleteUserContent, popupDeleteSingleUserTitle, popupDeleteSingleUserContent);
			}else {
				validatePopupWindowContent(flag, groupDetailsPopupDeleteUserTitle, groupDetailsPopupDeleteUserContent, popupDeleteMultipleUserTitle, popupDeleteMultipleUserContent);
			}

			verifyVisibilityOfButtons(driver, groupDetailsPopupDeleteUserButton, deleteContent, true);
			verifyVisibilityOfButtons(driver, groupDetailsPopupDeleteUserCancelButton, cancelButtonContent, true);

			clickOnButton(driver, groupDetailsPopupDeleteUserButton, deleteContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, "", "User "+deleteContent);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnDeleteUsersFromGroupButtonAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public void validateGroupDetailsOnListingPage(String groupName, String description, String identity, boolean adminFlag) {

		try {
			BaseSuite.reportLog(hyphenContent+" Verifying group details on group listing page "+hyphenContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateElementVisibility(driver, returnElement(groupListingGroupAvatar, dynamicName, groupName), groupContent, avatarContent, true);

			validateElementVisibility(driver, returnElement(groupListingGroupNameHyperlink, dynamicName, groupName), groupName, hyperlinkContent, true);

			validateElementVisibility(driver, returnElement(groupListingGroupNameAdminIcon, dynamicName, groupName), "Admin Access", iconContent,adminFlag);

			validateValueWithActual(returnElement(groupListingDescriptionByName,  dynamicName, groupName), descriptionContent, description, attributeTextContent);

			validateValueWithActual(returnElement(groupListingIdentityByName,  dynamicName, groupName), "Identity", identity, attributeTextContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateGroupDetailsOnListingPage :: "+e.toString());
		}

	}


	public static DataTestingParameters setGroupsServiceParamUsingExcel(String filePath, String sheetName, int rowNumber) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();

		try {

			param.setTestScenarioName(xl.readUsingColName(filePath,sheetName, rowNumber, "testScenario"));
			param.setScenarioType(xl.readUsingColName(filePath,sheetName, rowNumber, "scenarioType"));
			param.setGroupName(xl.readUsingColName(filePath,sheetName, rowNumber, "groupName"));
			param.setGroupDescription(xl.readUsingColName(filePath,sheetName, rowNumber, "groupDescription"));
			param.setGroupIdentity(xl.readUsingColName(filePath,sheetName, rowNumber, "groupIdentity"));
			param.setAddUser(xl.readUsingColName(filePath,sheetName, rowNumber, "addUser"));
			param.setRemoveUser(xl.readUsingColName(filePath,sheetName, rowNumber, "removeUser"));
			param.setSearchGroupName(xl.readUsingColName(filePath,sheetName, rowNumber, "searchGroup"));
			param.setUpdateGroupName(xl.readUsingColName(filePath,sheetName, rowNumber, "updateGroupName"));
			param.setUpdateGroupDescription(xl.readUsingColName(filePath,sheetName, rowNumber, "updateGroupDescription"));
			/**param.setAccountName(xl.readUsingColName(filePath,sheetName, rowNumber, "accountName"));*/

			param.setAccountName(BaseSuite.accountName);
			param.setWorkspaceName(xl.readUsingColName(filePath,sheetName, rowNumber, "workspaceName"));
			param.setFieldValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber, "fieldValidation"));
			param.setToastValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber, "toastValidation"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setGroupsServiceParamUsingExcel "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setGroupsServiceParamUsingExcelInvalid(String filePath, String sheetName, int rowNumber) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();

		try {

			param.setTestScenarioName(xl.readUsingColName(filePath,sheetName, rowNumber, "testScenario"));
			param.setScenarioType(xl.readUsingColName(filePath,sheetName, rowNumber, "scenarioType"));
			param.setGroupName(xl.readUsingColName(filePath,sheetName, rowNumber, "groupName"));
			param.setGroupDescription(xl.readUsingColName(filePath,sheetName, rowNumber, "groupDescription"));
			param.setGroupIdentity(xl.readUsingColName(filePath,sheetName, rowNumber, "groupIdentity"));
			param.setAddUser(xl.readUsingColName(filePath,sheetName, rowNumber, "addUser"));
			param.setRemoveUser(xl.readUsingColName(filePath,sheetName, rowNumber, "removeUser"));
			param.setSearchGroupName(xl.readUsingColName(filePath,sheetName, rowNumber, "searchGroup"));
			param.setUpdateGroupName(xl.readUsingColName(filePath,sheetName, rowNumber, "updateGroupName"));
			param.setUpdateGroupDescription(xl.readUsingColName(filePath,sheetName, rowNumber, "updateGroupDescription"));
			param.setAccountName(xl.readUsingColName(filePath,sheetName, rowNumber, "accountName"));

			/**param.setAccountName(PageUtil.getAccountName());*/
			param.setWorkspaceName(xl.readUsingColName(filePath,sheetName, rowNumber, "workspaceName"));
			param.setFieldValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber, "fieldValidation"));
			param.setToastValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber, "toastValidation"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setGroupsServiceParamUsingExcelInvalid "+e.toString());
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


		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setUsersParamUsingExcel "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setAccountsParamUsingExcel(String filePath, String accountName) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		/**		String userNameColumn="Name";*/
		String usersheet="AccountSheet";
		log.info(accountName);
		try {

			/**param.setAccountName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, accountName,"Name"));

			param.setRole(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, accountName,"Role"));
			param.setScope(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, accountName,"Scope"));*/

			param.setAccountName(BaseSuite.accountName);
			param.setRole(xl.readUsingColName(filePath,usersheet, 1,"Role"));
			param.setScope(xl.readUsingColName(filePath,usersheet, 1,"Scope"));


		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setAccountsParamUsingExcel "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setWorkspacesParamUsingExcel(String filePath, String workspaceName) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String userNameColumn="Name";
		String usersheet="WorkspaceSheet";
		try {

			param.setWorkspaceName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, workspaceName,"Name"));
			param.setRole(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, workspaceName,"Role"));
			param.setType(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, workspaceName,"Type"));
			param.setScope(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, workspaceName,"Scope"));
			param.setWorkspaceType(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, workspaceName,"WorkspaceType"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setWorkspacesParamUsingExcel "+e.toString());
		}
		return param;

	}


	public boolean searchGroupAndClickOnGroupName(String groupName) {
		boolean flag =true;

		try {

			flag=searchFunctionalityMethod(flag, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, groupName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && elementNotVisible(driver, groupListingNoRecordsToDisplay)) {

				flag=searchGroupNameOnEachPageAndClickOn(returnElement(groupListingGroupNameHyperlink, dynamicName, groupName), groupName);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}else {
				BaseSuite.reportFailLog("No records to display is visible","searchGroupAndClickOnGroupName");
				searchFunctionalityMethod(flag, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, "");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchGroupAndClickOnGroupName "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean searchGroupName(String groupName) {
		boolean flag =true;

		try {

			flag=searchFunctionalityMethod(flag, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, groupName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && isDisplayed(driver, returnElement(groupListingGroupNameHyperlink, dynamicName, groupName))) {

				/**		flag=searchGroupNameOnEachPageAndClickOn(returnElement(groupListingGroupNameHyperlink, dynamicName, groupName), groupName);**/

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				flag=false;
			}else {
				BaseSuite.reportLog("No records to display is visible");
				flag=true;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchGroupName "+e.toString());
			flag=false;
		}
		searchFunctionalityMethod(flag, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, "");

		return flag;
	}

	public boolean clickOnAddUsersButton(boolean flag) {

		return clickOnButton(driver, groupDetailsAddUsersButton, "Add", flag);

	}
	public boolean validateLoadMore(String listCount) {
		boolean flag=true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			String b = listCount.split("of")[1].trim();

			validateElementVisibility(driver, groupDetailsSidebarAddUserLoadMore, "Load more", hyperlinkContent, Integer.parseInt(b)>20);

		}catch(Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" validateLoadMore "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean validateAddUserSidebarOnGroupDetailsPage() {
		boolean flag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateElement(driver, groupDetailsSidebarAddUserTitle, "Add Users", attributeTitle);

			validateElement(driver, groupDetailsSidebarAddUserCross, discardContent, iconContent);

			verifySearchField(driver, groupDetailsSidebarAddUserSearchField, placeholderSearchUser, placeholderSearchUser);

			/**		validateElement(driver, groupDetailsSidebarAddUserLoadMore, "Load more", hyperlinkContent);**/

			verifyVisibilityOfButtons(driver,groupDetailsSidebarAddUserAddButton, "Add", false);

			verifyVisibilityOfButtons(driver,groupDetailsSidebarAddUserDiscardButton, cancelButtonContent,true);

			javascript(driver, scrollToElementArg, groupDetailsSidebarAddUserListCount);

			String listcount=getAttribute(driver, groupDetailsSidebarAddUserListCount, attributeTextContent);

			BaseSuite.reportLog("User List count "+listcount);

			/**		validateLoadMore(listcount); requirement change**/

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchGroupAndClickOnGroupName "+e.toString());
			flag=false;
		}
		return flag;
	}

	public void searchUser(String userName) {

		try {
			verifySearchField(driver, groupDetailsSidebarAddUserSearchField, placeholderSearchUser, placeholderSearchUser);

			BaseSuite.reportLog(" Entering value : "+userName);

			displayAndClick(driver, groupDetailsSidebarAddUserSearchField);

			clear_Click_SendKeys(driver, 4, groupDetailsSidebarAddUserSearchField, userName);

			BaseSuite.reportLog(" Entered value : "+userName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(1000);

			String listcount=getAttribute(driver, groupDetailsSidebarAddUserListCount, attributeTextContent);

			BaseSuite.reportLog("User List count "+listcount);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchUser "+e.toString());

		}		
	}

	public void selectUserCheckbox(String fullName) {

		try {
			By namelocator = returnElement(groupDetailsSidebarAddUserFullName, dynamicName, fullName);
			By checkboxlocator = returnElement(groupDetailsSidebarAddUserFullNameCheckbox, dynamicName, fullName);

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

	public boolean selectUserCheckboxForAddedUsers(boolean flag, String fullName) {

		try {
			By namelocator = returnElement(groupDetailsUserFullName, dynamicName, fullName);
			By checkboxlocator = returnElement(groupDetailsUserCheckbox, dynamicName, fullName);

			isDisplayedInLoop(driver, 2, namelocator);

			if(isDisplayed(driver, namelocator)) {

				BaseSuite.reportLog("User full name is visible as "+fullName);

				if(isDisplayed(driver, checkboxlocator)) {

					BaseSuite.reportLog("User full name checkbox is visible");

					flag=selectcheckbox(checkboxlocator, fullName);

				}else {
					BaseSuite.reportFailLog("User full name checkbox is not visible "+fullName, "selectUserCheckboxForAddedUsers");
				}
			}else {
				BaseSuite.reportFailLog("User full name is not visible", "selectUserCheckboxForAddedUsers");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" selectUserCheckboxForAddedUsers "+e.toString());
		}
		return flag;
	}


	public boolean addUsersToGroupFunctionality(String userName) {
		String[] iceuserName=null;
		boolean flag=true;
		try {

			if (!userName.isEmpty()) {
				clickOnAddUsersButton(true);
				validateAddUserSidebarOnGroupDetailsPage();
				if (isDisplayed(driver, groupDetailsSidebarAddUserTitle)) {

					if (userName.contains(",")) {

						iceuserName = userName.split(",");

						for (int i = 0; i < iceuserName.length; i++) {

							DataTestingParameters param = GroupsServicePage.setUsersParamUsingExcel(groupEXCELFILEPATH,
									iceuserName[i]);

							BaseSuite.reportLog(hyphenContent + "  Adding " + (i + 1) + "  User to group :: "
									+ param.getFirstName() + " " + param.getLastName() + " " + hyphenContent);

							searchUser(param.getUserName());

							String fullName = param.getFirstName() + " " + param.getLastName();

							selectUserCheckbox(fullName);

						}

					} else {
						DataTestingParameters param = GroupsServicePage.setUsersParamUsingExcel(groupEXCELFILEPATH,
								userName);

						BaseSuite.reportLog(hyphenContent + " Adding  " + 1 + " User to group ::  " + param.getFirstName()
						+ " " + param.getLastName() + " " + hyphenContent);

						searchUser(param.getUserName());

						String fullName = param.getFirstName() + " " + param.getLastName();

						selectUserCheckbox(fullName);

					}

					clickOnButton(driver, groupDetailsSidebarAddUserAddButton, "Add", true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				} 
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" addUsersToGroupFunctionality "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean addUsersToGroup(String userName) {
		boolean flag=true;
		String[] iceuserName=null;
		try {

			iceuserName = userName.split(",");

			for (int i = 0; i < iceuserName.length; i++) {

				DataTestingParameters param = GroupsServicePage.setUsersParamUsingExcel(groupEXCELFILEPATH,
						iceuserName[i]);

				String fullName = param.getFirstName() + " " + param.getLastName();

				flag= searchAndViewAddedUserInGroup(flag, fullName);

				if(flag) {

					BaseSuite.reportLog(hyphenContent + " Adding " + (i + 1) + " User to group :: "
							+ param.getFirstName() + " " + param.getLastName() + " " + hyphenContent);

					clickOnAddUsersButton(true);

					waitForExecution(1000);

					searchUser(param.getUserName());

					selectUserCheckbox(fullName);

					clickOnButton(driver, groupDetailsSidebarAddUserAddButton, "Add", true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				}else {
					searchFunctionalityMethod(true, groupDetailsSearchUserField, groupDetailsSearchUserButton, placeholderSearchUser, placeholderSearchUser, "");

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" addUsersToGroup "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateAndAddUsersToGroupFunctionalityNOUI(String userName) {

		boolean flag=true;
		try {

			if (!userName.isEmpty()) {

				if (userName.contains(",")) {

					flag= addUsersToGroup(userName);

				} else {
					DataTestingParameters param = GroupsServicePage.setUsersParamUsingExcel(groupEXCELFILEPATH,
							userName);

					String fullName = param.getFirstName() + " " + param.getLastName();

					flag= searchAndViewAddedUserInGroup(flag, fullName);

					if(flag) {

						BaseSuite.reportLog(hyphenContent + " Adding " + 1 + " User to group :: " + param.getFirstName()
						+ " " + param.getLastName() + " " + hyphenContent);

						clickOnAddUsersButton(true);

						waitForExecution(1000);

						searchUser(param.getUserName());

						selectUserCheckbox(fullName);

						clickOnButton(driver, groupDetailsSidebarAddUserAddButton, "Add", true);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					}else {

						searchFunctionalityMethod(true, groupDetailsSearchUserField, groupDetailsSearchUserButton, placeholderSearchUser, placeholderSearchUser, "");

					}
				}
			} 
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateAndAddUsersToGroupFunctionalityNOUI "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean deleteUsersToGroupFunctionality(String userName) {
		String[] iceuserName=null;
		boolean flag=true;
		int numberOfUsers=1;
		try {

			if (!userName.isEmpty()) {
				if (userName.contains(",")) {

					iceuserName = userName.split(",");

					numberOfUsers = iceuserName.length;

					for (int i = 0; i < iceuserName.length; i++) {

						DataTestingParameters param = GroupsServicePage.setUsersParamUsingExcel(groupEXCELFILEPATH,
								iceuserName[i]);

						BaseSuite.reportLog(hyphenContent + " Deleting " + (i + 1) + " User from group :: "
								+ param.getFirstName() + " " + param.getLastName() + " " + hyphenContent);

						String fullName = param.getFirstName() + " " + param.getLastName();

						flag = searchFunctionalityMethod(true, groupDetailsSearchUserField,
								groupDetailsSearchUserButton, placeholderSearchUser, placeholderSearchUser, fullName);

						selectUserCheckboxForAddedUsers(flag, fullName);

					}

				} else {

					numberOfUsers = 1;

					DataTestingParameters param = GroupsServicePage.setUsersParamUsingExcel(groupEXCELFILEPATH,
							userName);

					BaseSuite.reportLog(hyphenContent + " Deleting " + 1 + " User from group :: " + param.getFirstName()
					+ " " + param.getLastName() + " " + hyphenContent);

					String fullName = param.getFirstName() + " " + param.getLastName();

					flag = searchFunctionalityMethod(true, groupDetailsSearchUserField, groupDetailsSearchUserButton,
							placeholderSearchUser, placeholderSearchUser, fullName);

					selectUserCheckboxForAddedUsers(flag, fullName);

				} 

				searchFunctionalityMethod(true, groupDetailsSearchUserField, groupDetailsSearchUserButton, placeholderSearchUser, placeholderSearchUser, "");

				flag=clickOnButton(driver, groupDetailsDeleteUsers, deleteContent+" user", true);

				flag=clickOnDeleteUsersFromGroupButtonAndValidateToast(flag, numberOfUsers);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" addUsersToGroupFunctionality "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean searchAndViewAddedUserInGroup(boolean flag,String fullName,boolean adminflag) {

		try {
			BaseSuite.reportLog(hyphenContent+"  Validate User added in  group :: "+fullName+" "+hyphenContent);

			flag=searchFunctionalityMethod(true, groupDetailsSearchUserField, groupDetailsSearchUserButton, placeholderSearchUser, placeholderSearchUser, fullName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {

				validateElement(driver, returnElement(groupDetailsUserCheckbox, dynamicName, fullName), fullName, checkboxContent);

				validateElement(driver, returnElement(groupDetailsUserAvatar, dynamicName, fullName), fullName, avatarContent);

				validateElement(driver, returnElement(groupDetailsUserFullName, dynamicName, fullName), fullName, hyperlinkContent);

				validateElementVisibility(driver, returnElement(groupDetailsUserAdminIcon, dynamicName, fullName), adminContent, iconContent, adminflag);

				validateElement(driver, returnElement(groupDetailsUserStatus, dynamicName, fullName), fullName+" Status", labelContent);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchAndViewAddedUserInGroup "+e.toString());
		}

		return flag;
	}

	public boolean searchAndViewAddedUserInGroup(boolean flag,String fullName) {

		try {
			BaseSuite.reportLog(hyphenContent+" Validate User added in  group :: "+fullName+" "+hyphenContent);

			flag=searchFunctionalityMethod(true, groupDetailsSearchUserField, groupDetailsSearchUserButton, placeholderSearchUser, placeholderSearchUser, fullName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && elementNotVisible(driver, returnElement(groupDetailsUserFullName, dynamicName, fullName))) {

				flag=true;
			}else {
				flag=false;
				BaseSuite.reportLog(hyphenContent+" Already has added in group :: "+fullName+" "+hyphenContent);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchAndViewAddedUserInGroup "+e.toString());
		}

		return flag;
	}
	public boolean searchAndViewAccountInGroup(boolean flag,String accountName, String role, String scope) {

		try {
			BaseSuite.reportLog(hyphenContent+" Validate Account in  group :: "+accountName+" "+hyphenContent);

			flag=searchFunctionalityMethod(true, groupDetailsSearchAccountField, groupDetailsSearchAccountButton, placeholderSearchAccount, placeholderSearchAccount, accountName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {

				validateElement(driver, returnElement(groupDetailsAccountAvatar, dynamicName, accountName), accountName, avatarContent);

				validateElement(driver, returnElement(groupDetailsAccountName, dynamicName, accountName), accountName, hyperlinkContent);

				validateElementVisibility(driver, returnElement(groupDetailsAccountRole, dynamicName, accountName), roleContent, labelContent, true);

				String acrole=getAttribute(driver, returnElement(groupDetailsAccountRole, dynamicName, accountName), attributeTextContent);

				stringContainsOutput(acrole, role, true);

				validateElement(driver, returnElement(groupDetailsAccountScope, dynamicName, accountName), scopeContent, labelContent);

				String acscope=getAttribute(driver, returnElement(groupDetailsAccountScope, dynamicName, accountName), attributeTextContent);

				stringContainsOutput(acscope, scope, true);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchAndViewAccountInGroup "+e.toString());
		}

		return flag;
	}

	public boolean searchAndViewWorkspaceInGroup(boolean flag,String workspaceName, String role, String type, String scope, String workspaceType) {

		try {
			BaseSuite.reportLog(hyphenContent+" Validate Workspace in  group :: "+workspaceName+" "+hyphenContent);

			flag=searchFunctionalityMethod(true, groupDetailsSearchWorkspaceField, groupDetailsSearchWorkspaceButton, placeholderSearchWorkspace, placeholderSearchWorkspace, workspaceName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {

				if(workspaceType.trim().equalsIgnoreCase("dmo")) {

					validateElement(driver, returnElement(groupDetailsDataMonitoringWorkspaceAvatar, dynamicName, workspaceName), workspaceName, avatarContent);

				}else if(workspaceType.trim().equalsIgnoreCase("Workspace")){

					validateElement(driver, returnElement(groupDetailsWorkspaceAvatar, dynamicName, workspaceName), workspaceName, avatarContent);
				}

				validateElement(driver, returnElement(groupDetailsWorkspaceName, dynamicName, workspaceName), workspaceName, hyperlinkContent);

				validateElementVisibility(driver, returnElement(groupDetailsWorkspaceRole, dynamicName, workspaceName), roleContent, labelContent, true);

				String acrole=getAttribute(driver, returnElement(groupDetailsWorkspaceRole, dynamicName, workspaceName), attributeTextContent);

				stringContainsOutput(acrole, role, true);

				validateElementVisibility(driver, returnElement(groupDetailsWorkspaceType, dynamicName, workspaceName), typeContent, labelContent, true);

				String actype=getAttribute(driver, returnElement(groupDetailsWorkspaceType, dynamicName, workspaceName), attributeTextContent);

				stringContainsOutput(actype, type, true);

				validateElement(driver, returnElement(groupDetailsWorkspaceScope, dynamicName, workspaceName), scopeContent, labelContent);

				String acscope=getAttribute(driver, returnElement(groupDetailsWorkspaceScope, dynamicName, workspaceName), attributeTextContent);

				stringContainsOutput(acscope, scope, true);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchAndViewAccountInGroup "+e.toString());
		}

		return flag;
	}

	public boolean searchAndViewDeleteUserInGroup(boolean flag,String fullName) {

		try {
			BaseSuite.reportLog(hyphenContent+" Validate User added in  group :: "+fullName+" "+hyphenContent);

			flag=searchFunctionalityMethod(true, groupDetailsSearchUserField, groupDetailsSearchUserButton, placeholderSearchUser, placeholderSearchUser, fullName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && isDisplayed(driver, groupDetailsUserNoRecordsToDisplay)) {

				BaseSuite.validationReportLog(noRecordsToDisplayContent +" is visible");

			}else if(isDisplayed(driver, returnElement(groupDetailsUserFullName, dynamicName, fullName))){
				BaseSuite.reportFailLog("Deleted user from group is visible", "searchAndViewDeleteUserInGroup");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchAndViewDeleteUserInGroup "+e.toString());
		}

		return flag;
	}

	public boolean viewAddedUserDetails(String userName, boolean adminFlag) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if(userName.contains(",")) {

				iceuserName= userName.split(","); 

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = GroupsServicePage.setUsersParamUsingExcel(groupEXCELFILEPATH, iceuserName[i]);

					String fullName=param.getFirstName()+" "+param.getLastName();

					searchAndViewAddedUserInGroup(flag, fullName,adminFlag);
				}

			}else {

				DataTestingParameters param = GroupsServicePage.setUsersParamUsingExcel(groupEXCELFILEPATH, userName);

				String fullName=param.getFirstName()+" "+param.getLastName();

				searchAndViewAddedUserInGroup(flag, fullName,adminFlag);

			}

			displayAndClick(driver, groupDetailsSearchUserField);

			displayAndClick(driver, groupDetailsSearchUserClear);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewAddedUserDetails "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean viewAddedAccountDetails(String accountName) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if(accountName.contains(",")) {

				iceuserName= accountName.split(","); 

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = GroupsServicePage.setAccountsParamUsingExcel(groupEXCELFILEPATH, iceuserName[i]);

					searchAndViewAccountInGroup(flag, param.getAccountName(),param.getRole(),param.getScope());
				}

			}else {

				DataTestingParameters param = GroupsServicePage.setAccountsParamUsingExcel(groupEXCELFILEPATH, accountName);

				searchAndViewAccountInGroup(flag, param.getAccountName(),param.getRole(),param.getScope());

			}

			displayAndClick(driver, groupDetailsSearchAccountField);

			displayAndClick(driver, groupDetailsSearchAccountClear);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewAddedAccountDetails "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean viewAddedWorkspaceDetails(String workspaceName) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if(workspaceName.contains(",")) {

				iceuserName= workspaceName.split(","); 

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = GroupsServicePage.setWorkspacesParamUsingExcel(groupEXCELFILEPATH, iceuserName[i]);

					searchAndViewWorkspaceInGroup(flag, param.getWorkspaceName(),param.getRole(),param.getType(),param.getScope(), param.getWorkspaceType());
				}

			}else {

				DataTestingParameters param = GroupsServicePage.setWorkspacesParamUsingExcel(groupEXCELFILEPATH, workspaceName);

				searchAndViewWorkspaceInGroup(flag, param.getWorkspaceName(),param.getRole(),param.getType(),param.getScope(), param.getWorkspaceType());

			}

			displayAndClick(driver, groupDetailsSearchWorkspaceField);

			displayAndClick(driver, groupDetailsSearchWorkspaceClear);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewAddedWorkspaceDetails "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean viewDeleteUserDetails(String userName) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if(userName.contains(",")) {

				iceuserName= userName.split(","); 

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = GroupsServicePage.setUsersParamUsingExcel(groupEXCELFILEPATH, iceuserName[i]);

					String fullName=param.getFirstName()+" "+param.getLastName();

					searchAndViewDeleteUserInGroup(flag, fullName);
				}

			}else {

				DataTestingParameters param = GroupsServicePage.setUsersParamUsingExcel(groupEXCELFILEPATH, userName);

				String fullName=param.getFirstName()+" "+param.getLastName();

				searchAndViewDeleteUserInGroup(flag, fullName);

			}

			displayAndClick(driver, groupDetailsSearchUserField);

			displayAndClick(driver, groupDetailsSearchUserClear);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewDeleteUserDetails "+e.toString());
			flag =false;
		}

		return flag;

	}




	public boolean clickOnAccountsTabInGroupDetailsAndValidate(String accountName) {
		boolean flag =true;

		try {
			isDisplayedInLoop(driver, 2, groupDetailsAccountsTab);

			if(isDisplayed(driver, groupDetailsAccountsTab)) {

				clickOnAccountsTabGroupDetails();

				verifySearchField(driver, groupDetailsSearchAccountField, placeholderSearchAccount, placeholderSearchAccount);

				BaseSuite.reportLog(hyphenContent+" Verifying buttons on Accounts tab "+hyphenContent);

				verifyVisibilityOfButtons(driver, groupDetailsRefreshAccounts, refreshContent, true);

				BaseSuite.reportLog(hyphenContent+" Verifying columns of Accounts tab "+hyphenContent);

				validateElementVisibility(driver, groupDetailsAccountNameColumn, "Name", columnContent, true);

				validateElementVisibility(driver, groupDetailsAccountRoleColumn, roleContent, columnContent, true);

				validateElementVisibility(driver, groupDetailsAccountScopeColumn, scopeContent, columnContent, true);

				if(accountName.isEmpty()) {

					validateElementVisibility(driver, groupDetailsAccountNoRecordsToDisplay, noRecordsToDisplayContent, labelContent, true);
				}else {
					validateElementVisibility(driver, groupDetailsAccountNoRecordsToDisplay, noRecordsToDisplayContent, labelContent, false);

					viewAddedAccountDetails(accountName);
				}

				BaseSuite.reportLog(hyphenContent+" Verifying pagination on Accounts tab "+hyphenContent);

				getPaginationDetails(driver, groupDetailsAccountsPaginationMsg, groupDetailsAccountsPaginationBar, groupDetailsAccountNoRecordsToDisplay, accountsContent+" "+tabContent);

			}else {
				BaseSuite.reportFailLog("Accounts Tab not visible", "clickOnAccountsTabInGroupDetailsAndValidate");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnAccountsTabInGroupDetailsAndValidate "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean clickOnWorkspacesTabInGroupDetailsAndValidate(String workspaceName) {
		boolean flag =true;

		try {
			isDisplayedInLoop(driver, 2, groupDetailsWorkspacesTab);

			if(isDisplayed(driver, groupDetailsWorkspacesTab)) {

				clickOnWorkspacesTabGroupDetails();

				verifySearchField(driver, groupDetailsSearchWorkspaceField, placeholderSearchWorkspace, placeholderSearchWorkspace);

				BaseSuite.reportLog(hyphenContent+" Verifying buttons on Workspaces tab "+hyphenContent);

				verifyVisibilityOfButtons(driver, groupDetailsRefreshWorkspaces, refreshContent, true);

				BaseSuite.reportLog(hyphenContent+" Verifying columns of Workspaces tab "+hyphenContent);

				validateElementVisibility(driver, groupDetailsWorkspaceNameColumn, "Name", columnContent, true);

				validateElementVisibility(driver, groupDetailsWorkspaceRoleColumn, roleContent, columnContent, true);

				validateElementVisibility(driver, groupDetailsWorkspaceTypeColumn, typeContent, columnContent, true);

				validateElementVisibility(driver, groupDetailsWorkspaceScopeColumn, scopeContent, columnContent, true);

				if(workspaceName.isEmpty()) {

					validateElementVisibility(driver, groupDetailsWorkspaceNoRecordsToDisplay, noRecordsToDisplayContent, labelContent, true);
				}else {
					validateElementVisibility(driver, groupDetailsWorkspaceNoRecordsToDisplay, noRecordsToDisplayContent, labelContent, false);

					viewAddedWorkspaceDetails(workspaceName);
				}

				BaseSuite.reportLog(hyphenContent+" Verifying pagination on Workspaces tab "+hyphenContent);

				getPaginationDetails(driver, groupDetailsWorkspacesPaginationMsg, groupDetailsWorkspacesPaginationBar, groupDetailsWorkspaceNoRecordsToDisplay, workspacesContent+" "+tabContent);

			}else {
				BaseSuite.reportFailLog("Workspaces Tab not visible", "clickOnWorkspacesTabInGroupDetailsAndValidate");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnWorkspacesTabInGroupDetailsAndValidate "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean clickOnUsersTabRefreshButton() {
		boolean flag =true;

		flag =clickOnButton(driver, groupDetailsRefreshUsers, refreshContent, true);

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		return flag;
	}

	public boolean clickOnAccountsTabRefreshButton() {
		boolean flag =true;

		flag =clickOnButton(driver, groupDetailsRefreshAccounts, refreshContent, true);

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		return flag;
	}

	public boolean clickOnWorkspacesTabRefreshButton() {
		boolean flag =true;

		flag =clickOnButton(driver, groupDetailsRefreshWorkspaces, refreshContent, true);

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		return flag;
	}

	public boolean clickOnUsersTabGroupDetails() {
		boolean flag =true;

		try {
			isDisplayedInLoop(driver, 2, groupDetailsUsersTab);

			if(isDisplayed(driver, groupDetailsUsersTab)) {

				BaseSuite.reportLog("Clicking on Users Tab");

				displayAndClick(driver, groupDetailsUsersTab);

				BaseSuite.validationReportLog("Clicked on Users Tab");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnUsersTabGroupDetails "+e.toString());
			flag =false;
		}
		return flag;
	}

	public boolean clickOnAccountsTabGroupDetails() {
		boolean flag =true;

		try {
			isDisplayedInLoop(driver, 2, groupDetailsAccountsTab);

			if(isDisplayed(driver, groupDetailsAccountsTab)) {

				BaseSuite.reportLog("Clicking on Accounts Tab");

				displayAndClick(driver, groupDetailsAccountsTab);

				BaseSuite.validationReportLog("Clicked on Accounts Tab");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnAccountsTabGroupDetails "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean clickOnWorkspacesTabGroupDetails() {
		boolean flag =true;

		try {
			isDisplayedInLoop(driver, 2, groupDetailsWorkspacesTab);

			if(isDisplayed(driver, groupDetailsWorkspacesTab)) {

				BaseSuite.reportLog("Clicking on Workspaces Tab");

				displayAndClick(driver, groupDetailsWorkspacesTab);

				BaseSuite.validationReportLog("Clicked on Workspaces Tab");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnWorkspacesTabGroupDetails "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean clickOnUserSubModule() {

		boolean flag =true;

		try {
			isDisplayedInLoop(driver, 2, nextgenSubModuleUsers);

			if(isDisplayed(driver, nextgenSubModuleUsers)) {

				BaseSuite.reportLog("Clicking on Users Tab");

				displayAndClick(driver, nextgenSubModuleUsers);

				BaseSuite.validationReportLog("Clicked on Users Tab");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				validateElementVisibility(driver, returnElement(subModuleHeadingName, dynamicName, usersContent), usersContent, "page title", true);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnUserSubModule "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean searchAndViewUserInUsersTab(boolean flag,String username,String fullName, boolean adminflag) {

		try {
			BaseSuite.reportLog(hyphenContent+" Validate User :: "+username+" "+hyphenContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);waitForExecution(1000);

			flag=searchFunctionalityMethod(true, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, username);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {

				validateElement(driver, returnElement(usersDetailsUserCheckbox, dynamicName, fullName), fullName, checkboxContent);

				validateElement(driver, returnElement(usersDetailsUserAvatar, dynamicName, fullName), fullName, avatarContent);

				validateElement(driver, returnElement(usersListingFullNameDynamic, dynamicName, fullName), fullName, hyperlinkContent);

				validateElementVisibility(driver, returnElement(usersDetailsUserAdminIcon, dynamicName, fullName), adminContent, iconContent, adminflag);

				validateElement(driver, returnElement(usersDetailsUserStatus, dynamicName, fullName), fullName+" Status", labelContent);

			}
			searchFunctionalityMethod(true, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, "");

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchAndViewUserInUsersTab "+e.toString());
		}

		return flag;
	}

	public boolean searchAndViewUserInUsersTab(boolean flag,String username,String firstName,String lastName) {

		try {
			BaseSuite.reportLog(hyphenContent+" Validate User :: "+username+" "+hyphenContent);

			flag=searchFunctionalityMethod(true, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, username);

			String fullName=firstName+" "+lastName;

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && isDisplayed(driver, returnElement(usersListingFullNameDynamic, dynamicName, fullName))) {

				BaseSuite.reportLog("user already created");
				flag=false;
			}else {
				BaseSuite.reportLog("user not created");
				flag=true;
			}
			searchFunctionalityMethod(true, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, "");

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchAndViewUserInUsersTab "+e.toString());
		}

		return flag;
	}

	public boolean viewUserDetailsOnUsersTab(String userName, boolean adminFlag) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if (!userName.isEmpty()) {
				if (userName.contains(",")) {

					iceuserName = userName.split(",");

					for (int i = 0; i < iceuserName.length; i++) {

						DataTestingParameters param = GroupsServicePage.setUsersParamUsingExcel(groupEXCELFILEPATH,
								iceuserName[i]);

						String fullName = param.getFirstName() + " " + param.getLastName();

						searchAndViewUserInUsersTab(flag, iceuserName[i], fullName, adminFlag);
					}

				} else {

					DataTestingParameters param = GroupsServicePage.setUsersParamUsingExcel(groupEXCELFILEPATH,
							userName);

					String fullName = param.getFirstName() + " " + param.getLastName();

					searchAndViewUserInUsersTab(flag, userName, fullName, adminFlag);

				} 
			}
			displayAndClick(driver, usersListingSearchField);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			displayAndClick(driver, usersListingSearchClearIcon);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewUserDetailsOnUsersTab "+e.toString());
			flag =false;
		}

		return flag;

	}



	//main method
	public boolean createGroupFunctionality(String groupName, String description,String identity, String icedqUser) {
		boolean flag =true;
		String totalRecords="";
		boolean ui = !BaseSuite.suiteType.equalsIgnoreCase(sanityContent) ;
		try {

			flag=clickOnNewGroupButton(icedqUser);

			if(flag && icedqUser.toLowerCase().contains(adminsContent)) {

				validateGroupDetailPageBeforeCreating();

				validatAndeEnterValueToTextField(groupDetailsNameTitle, groupDetailsNameField, groupDetailsNameValidation, groupNameContent, placeholderGroupName, groupName, fieldNameEmpty);

				verifyVisibilityOfButtons(driver, groupDetailsSaveButton, saveContent, true);
				verifyVisibilityOfButtons(driver, groupDetailsDiscardButton, discardContent, true);

				validatAndeEnterValueToTextField(groupDetailsDescriptionTitle, groupDetailsDescriptionField, groupDetailsDescriptionValidation, descriptionContent, placeholderGroupDescription, description, "");

				flag=clickOnSaveButtonAndValidateToast(flag, toastGroupCreated);

				if(ui) {
					totalRecords=validateGroupDetailPageAfterNewCreated(groupName,description,false);

					if(totalRecords.equalsIgnoreCase("0")) {

						validateElement(driver, groupDetailsUserNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);
					}
				}
				clickOnGroupsTab();

				flag=searchFunctionalityMethod(flag, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, groupName);

				if(flag) {

					validateGroupDetailsOnListingPage(groupName, description, identity,false);		
				}

				clickOnRefreshOnGroupsListingPage();
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" createGroupFunctionality :: "+e.toString());
			flag=false;
		}
		return flag;

	}


	public boolean viewGroupFunctionality(String groupName, String description, String userName) {

		boolean flag =true;
		String totalRecords="";	
		boolean adminFlag =true;

		try {
			totalRecords=validateGroupDetailPageAfterNewCreated(groupName,description,true);

			if(elementNotVisible(driver, groupDetailsAdminAccessIcon)) {

				adminFlag =false;
			}

			if(totalRecords.equalsIgnoreCase("0")) {

				validateElement(driver, groupDetailsUserNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);
			}else {

				viewAddedUserDetails(userName,adminFlag);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewGroupFunctionality :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean viewGroupAndRefreshAllTabsFunctionality(String groupName, String description, String userName,String accountName, String workspaceName) {

		boolean flag =true;
		String totalRecords="";	
		boolean adminFlag =true;

		try {
			totalRecords=validateGroupDetailPageAfterNewCreated(groupName,description,true);

			if(elementNotVisible(driver, groupDetailsAdminAccessIcon)) {

				adminFlag =false;
			}

			if(totalRecords.equalsIgnoreCase("0")) {

				validateElement(driver, groupDetailsUserNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);
			}else {

				viewAddedUserDetails(userName,adminFlag);
			}

			clickOnUsersTabRefreshButton();

			clickOnAccountsTabInGroupDetailsAndValidate(accountName);

			clickOnAccountsTabRefreshButton();

			clickOnWorkspacesTabInGroupDetailsAndValidate(workspaceName);

			clickOnWorkspacesTabRefreshButton();



		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewGroupAndRefreshAllTabsFunctionality :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean searchFunctionalityInGroupDetailsPage(String groupName, String description, String userName, String accountName, String workspaceName) {

		boolean flag =true;
		String totalRecords="";	
		boolean adminFlag =true;

		try {
			totalRecords=validateGroupDetailPageAfterNewCreated(groupName,description,true);

			if(elementNotVisible(driver, groupDetailsAdminAccessIcon)) {

				adminFlag =false;
			}

			if(totalRecords.equalsIgnoreCase("0")) {

				validateElement(driver, groupDetailsUserNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);
			}else {

				viewAddedUserDetails(userName,adminFlag);
			}

			clickOnUsersTabRefreshButton();

			clickOnAccountsTabInGroupDetailsAndValidate(accountName);

			clickOnAccountsTabRefreshButton();

			clickOnWorkspacesTabInGroupDetailsAndValidate(workspaceName);

			clickOnWorkspacesTabRefreshButton();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchFunctionalityInGroupDetailsPage :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean viewGroupDetailsForRemoveUsersFunctionality(String groupName, String description, String userName) {

		boolean flag =true;
		String totalRecords="";	

		try {
			totalRecords=validateGroupDetailPageAfterNewCreated(groupName,description,true);

			if(totalRecords.equalsIgnoreCase("0")) {

				validateElement(driver, groupDetailsUserNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);
			}else {

				viewDeleteUserDetails(userName);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewGroupDetailsForRemoveUsersFunctionality :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean deleteGroupFunctionalityFromDetailsPage(String groupName) {

		boolean flag =true;

		try {
			flag=clickOnDeleteButtonAndValidateToast(flag, "");

			if(flag) {

				flag=clickOnDeleteGroupButtonAndValidateToast(flag, toastGroupDeleted);

				clickOnGroupsTab();

				clickOnRefreshOnGroupsListingPage();

				BaseSuite.reportLog("Verifying deleted group on groups listing page");

				flag=searchFunctionalityMethod(flag, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, groupName);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(flag && elementNotVisible(driver, returnElement(groupListingGroupNameHyperlink, dynamicName, groupName))) {

					BaseSuite.validationReportLog(groupName+"Group not visible on listing page, group successfully deleted");

				}else {

					BaseSuite.reportFailLog("Group is visible on listing page", "deleteGroupFunctionalityFromDetailsPage");
					flag=false;
				}
			}else {

				BaseSuite.reportFailLog("Delete button not working properly ", "deleteGroupFunctionalityFromDetailsPage");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" deleteGroupFunctionalityFromDetailsPage :: "+e.toString());
			flag=false;
		}finally {

			searchFunctionalityMethod(flag, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, groupName);
		}

		return flag;
	}

	public boolean assignAdminAccessToGroupFunctionality(String groupName, String description,String identity, String userName) {

		boolean flag=true;
		UsersServicePage us = new UsersServicePage(driver);
		try {

			flag=clickOnButton(driver, groupDetailsAdminAccessButton, assignAdminAccessContent, true);

			if (flag) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				validateElement(driver, groupDetailsAdminAccessIcon, adminContent, iconContent);

				verifyVisibilityOfButtons(driver, groupDetailsRevokeAdminAccessButton, revokeAdminAccessContent, true);

				if(!BaseSuite.suiteType.equalsIgnoreCase(sanityContent)) {viewGroupFunctionality(groupName, description, userName);}

				clickOnGroupsTab();

				clickOnRefreshOnGroupsListingPage();

				flag=searchFunctionalityMethod(flag, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, groupName);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(flag) {

					validateGroupDetailsOnListingPage(groupName, description, identity,true);		
				}

				clickOnRefreshOnGroupsListingPage();

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				us.clickOnUsersTab();

				viewUserDetailsOnUsersTab(userName, true);

				clickOnGroupsTab();

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" assignAdminAccessToGroupFunctionality :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean revokeAdminAccessToGroupFunctionality(String groupName, String description,String identity, String userName) {

		boolean flag=true;
		UsersServicePage us = new UsersServicePage(driver);
		try {

			flag=clickOnButton(driver, groupDetailsRevokeAdminAccessButton, revokeAdminAccessContent, true);

			if (flag) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				validateElementVisibility(driver, groupDetailsAdminAccessIcon, adminContent, iconContent, false);

				verifyVisibilityOfButtons(driver, groupDetailsAdminAccessButton, assignAdminAccessContent, flag);

				if(!BaseSuite.suiteType.equalsIgnoreCase(sanityContent)) {viewGroupFunctionality(groupName, description, userName);}

				clickOnGroupsTab();

				clickOnRefreshOnGroupsListingPage();

				flag=searchFunctionalityMethod(flag, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, groupName);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(flag) {

					validateGroupDetailsOnListingPage(groupName, description, identity,false);		
				}

				clickOnRefreshOnGroupsListingPage();

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				us.clickOnUsersTab();

				viewUserDetailsOnUsersTab(userName, false);

				clickOnGroupsTab();

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" revokeAdminAccessToGroupFunctionality :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean updateGroupFunctionality(String groupName, String description,String updateGroupName, String updateDesc, String identity, String icedqUser) {
		boolean flag =true;
		String totalRecords="";
		boolean uicheck=!BaseSuite.suiteType.equalsIgnoreCase(sanityContent) ;
		try {

			if(icedqUser.toLowerCase().contains(adminsContent)) {

				if(!BaseSuite.suiteType.equalsIgnoreCase(sanityContent)) {validateGroupDetailPageAfterNewCreated(groupName,description,true);}

				validatAndeEnterValueToTextField(groupDetailsNameTitle, groupDetailsNameField, groupDetailsNameValidation, groupNameContent, placeholderGroupName, updateGroupName, fieldNameEmpty);

				verifyVisibilityOfButtons(driver, groupDetailsSaveButton, saveContent, true);
				verifyVisibilityOfButtons(driver, groupDetailsDiscardButton, discardContent, true);

				validatAndeEnterValueToTextField(groupDetailsDescriptionTitle, groupDetailsDescriptionField, groupDetailsDescriptionValidation, descriptionContent, placeholderGroupDescription, updateDesc, "");

				flag=clickOnSaveButtonAndValidateToast(flag, "");
				if(uicheck) {
					totalRecords=validateGroupDetailPageAfterNewCreated(updateGroupName,updateDesc,false);

					if(totalRecords.equalsIgnoreCase("0")) {

						validateElement(driver, groupDetailsUserNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);
					}
				}
				clickOnGroupsTab();

				flag=searchFunctionalityMethod(flag, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, updateGroupName);

				if(flag) {

					validateGroupDetailsOnListingPage(updateGroupName, updateDesc, identity,false);		
				}

				clickOnRefreshOnGroupsListingPage();
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" updateGroupFunctionality :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean discardGroupFunctionality(String groupName, String description,String updateGroupName, String updateDesc, String identity, String icedqUser) {
		boolean flag =true;
		String totalRecords="";
		boolean uicheck=!BaseSuite.suiteType.equalsIgnoreCase(sanityContent) ;
		try {

			if(icedqUser.toLowerCase().contains(adminsContent)) {

				if(!BaseSuite.suiteType.equalsIgnoreCase(sanityContent)) {validateGroupDetailPageAfterNewCreated(groupName,description,true);}

				validatAndeEnterValueToTextField(groupDetailsNameTitle, groupDetailsNameField, groupDetailsNameValidation, groupNameContent, placeholderGroupName, updateGroupName, fieldNameEmpty);

				verifyVisibilityOfButtons(driver, groupDetailsSaveButton, saveContent, true);
				verifyVisibilityOfButtons(driver, groupDetailsDiscardButton, discardContent, true);

				validatAndeEnterValueToTextField(groupDetailsDescriptionTitle, groupDetailsDescriptionField, groupDetailsDescriptionValidation, descriptionContent, placeholderGroupDescription, updateDesc, "");

				flag=clickOnDiscardGroupButtonAndValidateToast(flag, "");
				if(uicheck) {
					totalRecords=validateGroupDetailPageAfterNewCreated(groupName,description,false);

					if(totalRecords.equalsIgnoreCase("0")) {

						validateElement(driver, groupDetailsUserNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);
					}
				}
				clickOnGroupsTab();

				flag=searchFunctionalityMethod(flag, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, groupName);

				if(flag) {

					validateGroupDetailsOnListingPage(groupName, description, identity,false);		
				}

				clickOnRefreshOnGroupsListingPage();
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" discardGroupFunctionality :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public void navigateToAdministrationTabs(By linklocator, By validateLocator, String label, String type) {

		navigateToLink(driver, linklocator, validateLocator, label+" "+type);

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		clickOnGroupsTab();

	}

	public void navigateToBreadcrumb(String groupName) {
		HomePage hp=new HomePage(driver);
		try {
			BaseSuite.reportLog("-------------- Navigate functionality check on groups listing page ---------------");

			navigateToLink(driver, breadcrumbAdministrationLink, returnElement(subModuleHeadingName, dynamicName, usersContent), administrationContent+" "+breadcrumbContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnGroupsTab();

			clickOnButton(driver, breadcrumbHomeLink, homeContent+" "+breadcrumbContent, true);

			hp.clickOnAdministrationTab();

			clickOnGroupsTab();

			BaseSuite.reportLog("-------------- Navigate functionality check on groups details page ---------------");

			searchGroupAndClickOnGroupName(groupName);

			clickOnGroupsTab();

			searchGroupAndClickOnGroupName(groupName);

			/**	clickOnGroupsTab();*/

			navigateToLink(driver, breadcrumbGroupsLink, returnElement(subModuleHeadingName, dynamicName, groupsContent), groupsContent+" "+breadcrumbContent);

			searchGroupAndClickOnGroupName(groupName);

			/**	clickOnGroupsTab();*/

			navigateToLink(driver, breadcrumbAdministrationLink, returnElement(subModuleHeadingName, dynamicName, usersContent), administrationContent+" "+breadcrumbContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnGroupsTab();

			searchGroupAndClickOnGroupName(groupName);

			clickOnGroupsTab();

			clickOnButton(driver, breadcrumbHomeLink, homeContent+" "+breadcrumbContent, true);

			hp.clickOnAdministrationTab();

			clickOnGroupsTab();
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" navigateToBreadcrumb :: "+e.toString());

		}

	}


	public boolean validateNavigationFunctionalityForGroups(String groupName, String icedqUser) {
		HomePage hp=new HomePage(driver);
		boolean flag =true;

		try {

			navigateToAdministrationTabs(nextgenSubModuleUsers,returnElement(subModuleHeadingName, dynamicName, usersContent), usersContent, subModuleContent);

			navigateToAdministrationTabs(nextgenSubModuleRoles,returnElement(subModuleHeadingName, dynamicName, rolesContent), rolesContent, subModuleContent);

			navigateToAdministrationTabs(nextgenSubModuleAccounts,returnElement(subModuleHeadingName, dynamicName, accountsContent), accountsContent, subModuleContent);

			navigateToAdministrationTabs(nextgenSubModuleWorkspaces,returnElement(subModuleHeadingName, dynamicName, workspacesContent), workspacesContent, subModuleContent);
			/**
	//		navigateToAdministrationTabs(nextgenSubModuleFederations,returnElement(subModuleHeadingName, dynamicName, fedetationsContent), fedetationsContent, subModuleContent);

	//		navigateToAdministrationTabs(nextgenSubModuleIdentityProviders,returnElement(subModuleHeadingName, dynamicName, identityProvidersContent), identityProvidersContent, subModuleContent);

	//		navigateToAdministrationTabs(nextgenSubModuleVault,returnElement(subModuleHeadingName, dynamicName,  vaultContent), vaultContent, subModuleContent);

	//		navigateToAdministrationTabs(nextgenSubModuleFields,returnElement(subModuleHeadingName, dynamicName,  fieldContent), fieldContent, subModuleContent);

	//		navigateToAdministrationTabs(nextgenSubModuleCalenders,returnElement(subModuleHeadingName, dynamicName, calendarsContent), calendarsContent, subModuleContent);

	//		navigateToAdministrationTabs(nextgenSubModuleSettings,returnElement(subModuleHeadingName, dynamicName, settingsContent), settingsContent, subModuleContent);

	//		navigateToAdministrationTabs(nextgenSubModuleIntegrations,returnElement(subModuleHeadingName, dynamicName, integrationsContent), integrationsContent, subModuleContent);

	//		navigateToAdministrationTabs(nextgenSubModuleLibraries,returnElement(subModuleHeadingName, dynamicName, librariesContent), librariesContent, subModuleContent);
			 **/
			clickOnNewGroupButton(icedqUser);

			navigateToLink(driver, breadcrumbGroupsLink, returnElement(subModuleHeadingName, dynamicName, groupsContent), groupsContent+" "+breadcrumbContent);

			clickOnNewGroupButton(icedqUser);

			navigateToLink(driver, breadcrumbAdministrationLink, returnElement(subModuleHeadingName, dynamicName, usersContent), administrationContent+" "+breadcrumbContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnGroupsTab();

			clickOnNewGroupButton(icedqUser);

			clickOnButton(driver, breadcrumbHomeLink, homeContent+" "+breadcrumbContent, true);

			hp.clickOnAdministrationTab();

			clickOnGroupsTab();

			navigateToBreadcrumb(groupName);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateNavigationFunctionalityForGroups :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	//invalid method
	public boolean createGroupFunctionalityWithInvalidDetails(String scenarioType, String groupName, String description,String fieldValidation, String toastValidation, String icedqUser) {
		boolean flag =true;

		try {

			flag=clickOnNewGroupButton(icedqUser);

			if(flag && icedqUser.toLowerCase().contains(adminsContent)) {

				/**			validateGroupDetailPageBeforeCreating();**/

				switch(scenarioType.toLowerCase()) {

				case"groupname":

					if(!groupName.isEmpty()) {
						enterValueToTextField(driver, groupDetailsNameField, groupNameContent, groupName);	
					}else {
						sendKeys(driver, groupDetailsNameField, "emp");
						waitForExecution(500);
						click(driver, groupDetailsNameField);
						clear(driver, groupDetailsNameField);
					}

					String acmesg = validationMessageOfField(driver,groupDetailsNameValidation, groupNameContent, fieldValidation, true);

					if(!fieldValidation.equalsIgnoreCase(acmesg)) {
						flag=false;
					}

					verifyVisibilityOfButtons(driver, groupDetailsSaveButton, saveContent, false);

					break;

				case"groupdescription":

					/**	flag=validatAndeEnterValueToTextField(groupDetailsDescriptionTitle, groupDetailsDescriptionField, groupDetailsDescriptionValidation, descriptionContent,
					placeholderGroupDescription, description, fieldValidation);*/

					enterValueToTextField(driver, groupDetailsDescriptionField, descriptionContent, description);	

					String acdesc = validationMessageOfField(driver,groupDetailsDescriptionValidation, descriptionContent, fieldValidation, true);

					if(!fieldValidation.equalsIgnoreCase(acdesc)) {
						flag=false;
					}

					verifyVisibilityOfButtons(driver, groupDetailsSaveButton, saveContent, false);

					break;

				case"existinggroup":

					validatAndeEnterValueToTextField(groupDetailsNameTitle, groupDetailsNameField, groupDetailsNameValidation, groupNameContent, placeholderGroupName, groupName, fieldNameEmpty);

					validatAndeEnterValueToTextField(groupDetailsDescriptionTitle, groupDetailsDescriptionField, groupDetailsDescriptionValidation, descriptionContent, placeholderGroupDescription, description, fieldValidation);

					flag=clickOnSaveButtonAndValidateToast(flag, toastValidation);

					break;

				default:

					break;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" createGroupFunctionalityWithInvalidDetails :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean updateGroupFunctionalityWithInvalidDetails(DataTestingParameters param,String scenarioType,String searchGroup, String icedqUser) {
		boolean flag =true;
		boolean state =true;
		try {

			String groupName=param.getGroupName();
			String description=param.getGroupDescription();
			String fieldValidation=param.getFieldValidationMessage();
			/**		String toastValidation=param.getToastValidationMessage();**/
			String userName=param.getAddUser();
			String accountName=param.getAccountName();
			String workspaceName=param.getWorkspaceName();

			state=searchGroupAndClickOnGroupName(searchGroup);

			if(state && icedqUser.toLowerCase().contains(adminsContent)) {

				switch(scenarioType.toLowerCase()) {

				case"groupname":

					enterValueToTextField(driver, groupDetailsNameField, groupNameContent, groupName);	

					String acmesg = validationMessageOfField(driver,groupDetailsNameValidation, groupNameContent, fieldValidation, true);

					if(!fieldValidation.equalsIgnoreCase(acmesg)) {
						flag=false;
					}

					verifyVisibilityOfButtons(driver, groupDetailsSaveButton, saveContent, false);

					break;

				case"groupdescription":

					/**	flag=validatAndeEnterValueToTextField(groupDetailsDescriptionTitle, groupDetailsDescriptionField, groupDetailsDescriptionValidation, descriptionContent, placeholderGroupDescription, description, fieldValidation);
					 **/
					enterValueToTextField(driver, groupDetailsDescriptionField, descriptionContent, description);	

					String acdesc = validationMessageOfField(driver,groupDetailsDescriptionValidation, descriptionContent, fieldValidation, true);

					if(!fieldValidation.equalsIgnoreCase(acdesc)) {
						flag=false;
					}

					verifyVisibilityOfButtons(driver, groupDetailsSaveButton, saveContent, false);

					break;

				case"existinggroup":

					validatAndeEnterValueToTextField(groupDetailsNameTitle, groupDetailsNameField, groupDetailsNameValidation, groupNameContent, placeholderGroupName, groupName, fieldNameEmpty);

					validatAndeEnterValueToTextField(groupDetailsDescriptionTitle, groupDetailsDescriptionField, groupDetailsDescriptionValidation, descriptionContent, placeholderGroupDescription, description, fieldValidation);

					flag=clickOnSaveButtonAndValidateToast(flag, "Group name '"+groupName+"' already exists.");

					break;

				case"searchuser":

					flag=searchFunctionalityMethod(true, groupDetailsSearchUserField, groupDetailsSearchUserButton, placeholderSearchUser, placeholderSearchUser, userName);

					validateElementVisibility(driver, groupDetailsUserNoRecordsToDisplay, noRecordsToDisplayContent, labelContent, true);

					break;
				case"searchaccount":

					clickOnAccountsTabGroupDetails();

					flag=searchFunctionalityMethod(true, groupDetailsSearchAccountField, groupDetailsSearchAccountButton, placeholderSearchAccount, placeholderSearchAccount, accountName);

					validateElementVisibility(driver, groupDetailsAccountNoRecordsToDisplay, noRecordsToDisplayContent, labelContent, true);

					break;
				case"searchworkspace":

					clickOnWorkspacesTabGroupDetails();

					flag=searchFunctionalityMethod(true, groupDetailsSearchWorkspaceField, groupDetailsSearchWorkspaceButton, placeholderSearchWorkspace, placeholderSearchWorkspace, workspaceName);

					validateElementVisibility(driver, groupDetailsWorkspaceNoRecordsToDisplay, noRecordsToDisplayContent, labelContent, true);

					break;
				default:

					break;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" updateGroupFunctionalityWithInvalidDetails :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean deleteLDAPGroupsFromListingPage() {
		boolean flag =true;
		boolean nextpageFlag =true;

		try {
			do {

				List<WebElement> ldapGrp=getElements(driver, ldapGroupsCheckbox);

				if(!ldapGrp.isEmpty()) {

					List<WebElement> ldapGrpName=getElements(driver, ldapGroupsNames);

					for(int i=0;i<ldapGrp.size();i++) {

						BaseSuite.reportLog("Clicking on checkbox of LDAP Group :: "+ldapGrpName.get(i).getText());

						ldapGrp.get(i).click();

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					}
				}	
				if(isDisplayed(driver, groupsListingNextPageArrow)) {

					String status = getAttribute(driver, groupsListingNextPageArrow, attributeClass);

					if (!status.contains("disable")) {
						clickOnButton(driver, groupsListingNextPageArrow, "next page", true);
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					} else {
						BaseSuite.validationReportLog("Page arrow :: next page is disabled");
						nextpageFlag=false;
					}

				}

			}while(nextpageFlag);

			clickOnButton(driver, groupListingDeleteIcon, deleteContent, true);

			clickOnDeleteMultipleGroupsButtonAndValidateToast(flag, toastGroupMultipleDelete);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" deleteLDAPGroupsFromListingPage :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean searchGroupNameOnEachPageAndClickOn(By locator,String name) {

		boolean flag=true;
		boolean nextpageFlag=true;
		int pn=0;

		try {

			do {

				BaseSuite.reportLog("searching group name : "+name+" on page number :"+(pn+1));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 2, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportLog("group name : "+name+" found on page number :"+(pn+1));

					flag=clickOnButton(driver, locator, name, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					break;
				}
				if(isDisplayed(driver, groupsListingNextPageArrow)) {

					String status = getAttribute(driver, groupsListingNextPageArrow, attributeClass);

					if (!status.contains("disable")) {

						clickOnButton(driver, groupsListingNextPageArrow, "next page", true);
						pn++;
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					} else {
						BaseSuite.reportLog("Page arrow :: next page is disabled");
						nextpageFlag=false;
					}

				}

			}while(nextpageFlag);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchGroupNameOnEachPageAndClickOn :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean selectGroupCheckbox(boolean flag, String userName) {

		try {
			By namelocator = returnElement(groupListingGroupNameHyperlink, dynamicName, userName);
			By checkboxlocator = returnElement(groupListingGroupNameCheckbox, dynamicName, userName);

			isDisplayedInLoop(driver, 2, namelocator);

			if(isDisplayed(driver, namelocator)) {

				BaseSuite.reportLog("Group name is visible as "+userName);

				if(isDisplayed(driver, checkboxlocator)) {

					BaseSuite.reportLog("Group name checkbox is visible");

					flag=selectcheckbox(driver, checkboxlocator, userName);

				}else {
					BaseSuite.reportFailLog("Group name checkbox is not visible "+userName, "selectGroupCheckbox");
				}
			}else {
				BaseSuite.reportFailLog("Group name is not visible", "selectGroupCheckbox");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" selectGroupCheckbox "+e.toString());
		}
		return flag;
	}


	public boolean clickOnDeleteGroupsAndValidateToast(boolean flag, int numberOfUsers) {
		String toastMsgContent="";
		try {

			if(numberOfUsers==1) {
				validatePopupWindowContent(driver, flag, groupDetailsPopupDeleteTitle, groupDetailsPopupDeleteContent, popupDeleteGroupTitle, popupDeleteGroupContent);
				toastMsgContent=toastGroupDeleted;
			}else {
				validatePopupWindowContent(driver,flag, groupDetailsPopupDeleteTitle, groupDetailsPopupDeleteContent, popupDeleteMultipleGroupTitle, popupDeleteMultipleGroupContent);
				toastMsgContent=toastGroupMultipleDelete;
			}

			verifyVisibilityOfButtons(driver, groupDetailsPopupDeleteButton, deleteContent, true);
			verifyVisibilityOfButtons(driver, groupDetailsPopupDeleteCancelButton, cancelButtonContent, true);

			clickOnButton(driver, groupDetailsPopupDeleteButton, deleteContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, toastMsgContent, "User "+deleteContent);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnDeleteGroupsAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean deleteGroupValid(String groupName, String icedqUser) {
		String[] iceuserName=null;
		boolean flag =true;
		int numberOfUsers=1;
		log.info(icedqUser);
		try {

			if(groupName.contains(",")) {

				iceuserName= groupName.split(","); 

				numberOfUsers = iceuserName.length;

				for(int i=0;i<iceuserName.length;i++) {

					BaseSuite.reportLog(hyphenContent+"  selecting "+(i+1)+"  group :: "+iceuserName[i]+" "+hyphenContent);

					flag=searchFunctionalityMethod(driver, flag, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, iceuserName[i]);

					selectGroupCheckbox(flag, iceuserName[i]);

					searchFunctionalityMethod(driver, flag, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, "");

				}

			}else {

				numberOfUsers = 1;

				BaseSuite.reportLog(hyphenContent+"  selecting 1 group :: "+groupName+" "+hyphenContent);

				flag=searchFunctionalityMethod(driver, flag, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, groupName);

				selectGroupCheckbox(flag, groupName);


			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			searchFunctionalityMethod(driver,true, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, "");

			flag=clickOnButton(driver, groupListingDeleteIcon, deleteContent, true);

			flag=clickOnDeleteGroupsAndValidateToast(flag, numberOfUsers);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" deleteGroupValid "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean validateDeletedGroupValid(String groupName) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if(groupName.contains(",")) {

				iceuserName= groupName.split(","); 

				for(int i=0;i<iceuserName.length;i++) {

					BaseSuite.reportLog(hyphenContent+"  validating deleted "+(i+1)+"  group :: "+iceuserName[i]+" "+hyphenContent);

					flag=searchFunctionalityMethod(driver, flag, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, iceuserName[i]);

					if(flag && elementNotVisible(driver, returnElement(groupListingGroupNameHyperlink, dynamicName, iceuserName[i]))) {

						BaseSuite.validationReportLog(iceuserName[i]+" group Not visible on listing.");
					}else {
						BaseSuite.reportFailLog(iceuserName[i]+" group is visible on listing.", "validateDeletedGroupValid");
					}

					clickOnRefreshOnGroupsListingPage();
				}

			}else {

				BaseSuite.reportLog(hyphenContent+"  validating deleted "+(1)+" group :: "+groupName+" "+hyphenContent);

				flag=searchFunctionalityMethod(driver, flag, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, groupName);

				if(flag && elementNotVisible(driver, returnElement(groupListingGroupNameHyperlink, dynamicName, groupName))) {

					BaseSuite.validationReportLog(groupName+" group Not visible on listing.");
				}else {
					BaseSuite.reportFailLog(groupName+" group is visible on listing.", "validateDeletedGroupValid");
				}

				clickOnRefreshOnGroupsListingPage();
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateDeletedGroupValid "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean deleteGroupCheckForValidScenario(String groupname, String icedqUser) {
		boolean flag =true;

		try {

			deleteGroupValid(groupname, icedqUser);

			flag=validateDeletedGroupValid(groupname);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" deleteGroupCheckForValidScenario "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean deleteGroupValidForCleanUp(String groupName, String icedqUser) {
		String[] iceuserName=null;
		boolean flag =true;
		int numberOfUsers=1;
		log.info(icedqUser);
		try {

			if(groupName.contains(",")) {

				iceuserName= groupName.split(","); 

				for(int i=0;i<iceuserName.length;i++) {

					BaseSuite.reportLog(hyphenContent+"  selecting "+(i+1)+" group :: "+iceuserName[i]+" "+hyphenContent);

					flag=searchFunctionalityMethod(driver, flag, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, iceuserName[i]);

					if(isDisplayed(driver, returnElement(groupListingGroupNameHyperlink, dynamicName, iceuserName[i]))) {

						selectGroupCheckbox(flag, iceuserName[i]);
					}
					if(isEnabled(driver, groupListingDeleteIcon)) {

						flag=clickOnButton(driver, groupListingDeleteIcon, deleteContent, true);

						flag=clickOnDeleteGroupsAndValidateToast(flag, 1);
					}

					searchFunctionalityMethod(driver,true, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, "");
				}

			}else {

				numberOfUsers = 1;

				BaseSuite.reportLog(hyphenContent+"  selecting 1 group :: "+groupName+" "+hyphenContent);

				flag=searchFunctionalityMethod(driver, flag, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, groupName);

				if(isDisplayed(driver, returnElement(groupListingGroupNameHyperlink, dynamicName, groupName))) {
					selectGroupCheckbox(flag, groupName);
				}

				if(isEnabled(driver, groupListingDeleteIcon)) {

					flag=clickOnButton(driver, groupListingDeleteIcon, deleteContent, true);

					flag=clickOnDeleteGroupsAndValidateToast(flag, numberOfUsers);
				}

				searchFunctionalityMethod(driver,true, groupListingSearchField, groupListingSearchButton, placeholderSearchGroup, placeholderSearchGroup, "");


			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);




		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" deleteGroupValid "+e.toString());
			flag =false;
		}

		return flag;

	}


	//main method
	public boolean createGroupFunctionalityNOUI(String groupName, String description,String identity, String icedqUser) {
		boolean flag =true;
		
		log.info(identity);
		try {

			flag=clickOnNewGroupButton(icedqUser);

			if(flag && icedqUser.toLowerCase().contains(adminsContent)) {

				validatAndeEnterValueToTextField(groupDetailsNameTitle, groupDetailsNameField, groupDetailsNameValidation, groupNameContent, placeholderGroupName, groupName, fieldNameEmpty);

				validatAndeEnterValueToTextField(groupDetailsDescriptionTitle, groupDetailsDescriptionField, groupDetailsDescriptionValidation, descriptionContent, placeholderGroupDescription, description, "");

				flag=clickOnSaveButtonAndValidateToast(flag, toastGroupCreated);
				

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" createGroupFunctionalityNOUI :: "+e.toString());
			flag=false;
		}
		return flag;

	}
}
