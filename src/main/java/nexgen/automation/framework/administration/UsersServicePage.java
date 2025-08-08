package nexgen.automation.framework.administration;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;
import nexgen.automation.pageclasses.otherpages.HomePage;
import nextgen.automation.workflow.service.pages.DataTestingParameters;

public class UsersServicePage extends PageUtil {

	WebDriver driver;

	public UsersServicePage(WebDriver driver) {
		this.driver = driver;
	}

	protected static final Logger log = Logger.getLogger(UsersServicePage.class);
	static String dirPath=System.getProperty("user.dir");

	public final String uSEREXCELFILEPATH = System.getProperty("user.dir")+ Constant.NEXTGEN_USERS_TESTDATA_EXCEL_PATH;
	public static final String PARAMETERPRIVILEGEFORBIDDENMESSAGE=prop.getProperty("workflow.toast.forbidden.Message");

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
	By nextgenSubModuleConfigurations=getElementLocator(prop.getProperty("nextgenmodule.submodule.configurations"));
	By nextgenSubModuleSecurity=getElementLocator(prop.getProperty("nextgenmodule.submodule.security"));

	By groupDetailsHandleDiscardPopup=getElementLocator(prop.getProperty("groups.details.handle.discard"));

	By usersPageTitle=getElementLocator(prop.getProperty("users.page.title"));

	By breadcrumbHomeLink=getElementLocator(prop.getProperty("users.breadcrumb.homelink"));
	By breadcrumbAdministrationLink=getElementLocator(prop.getProperty("users.breadcrumb.administrationlink"));
	By breadcrumbUsersLink=getElementLocator(prop.getProperty("users.breadcrumb.userslinks"));
	By breadcrumbAdministration=getElementLocator(prop.getProperty("users.breadcrumb.administration"));
	By breadcrumbUsers=getElementLocator(prop.getProperty("users.breadcrumb.users"));
	By breadcrumbCreateNewUser=getElementLocator(prop.getProperty("users.breadcrumb.createNewUser"));

	By usersListingNewUserButton=getElementLocator(prop.getProperty("users.listing.button.newUser"));
	By usersListingRefreshIcon=getElementLocator(prop.getProperty("users.listing.button.refresh"));
	By usersListingDeleteIcon=getElementLocator(prop.getProperty("users.listing.button.delete"));
	By usersListingBlockIcon=getElementLocator(prop.getProperty("users.listing.button.block"));
	By usersListingUnBlockIcon=getElementLocator(prop.getProperty("users.listing.button.unblock"));
	By usersListingSearchField=getElementLocator(prop.getProperty("users.listing.search.field"));
	By usersListingSearchButton=getElementLocator(prop.getProperty("users.listing.search.button"));
	By usersListingSearchClearIcon=getElementLocator(prop.getProperty("users.listing.search.clear"));
	By usersListingMasterCheckbox=getElementLocator(prop.getProperty("users.listing.mastercheckbox"));
	By usersListingColumnFullName=getElementLocator(prop.getProperty("users.listing.column.fullName"));
	By usersListingColumnUserName=getElementLocator(prop.getProperty("users.listing.column.userName"));
	By usersListingColumnStatus=getElementLocator(prop.getProperty("users.listing.column.status"));
	By usersListingColumnEmail=getElementLocator(prop.getProperty("users.listing.column.email"));
	By usersListingColumnIdentity=getElementLocator(prop.getProperty("users.listing.column.identity"));
	By usersListingNoRecordsToDisplay=getElementLocator(prop.getProperty("users.listing.NoRecordsToDisplay"));
	By usersListingUserName=getElementLocator(prop.getProperty("users.listing.fullNamestatic"));
	By usersListingDescription=getElementLocator(prop.getProperty("users.listing.description"));
	By usersListingIdentity=getElementLocator(prop.getProperty("users.listing.identity"));

	By usersListingPaginationBar=getElementLocator(prop.getProperty("users.listing.users.paginationbar"));
	By usersListingPaginationMsg=getElementLocator(prop.getProperty("users.listing.users.paginationMsg"));
	By usersListingNextPageArrow=getElementLocator(prop.getProperty("users.listing.nextpagearrow"));

	By usersDetailsSaveButton=getElementLocator(prop.getProperty("users.details.button.save"));
	By usersDetailsDiscardButton=getElementLocator(prop.getProperty("users.details.button.discard"));
	By usersDetailsDeleteButton=getElementLocator(prop.getProperty("users.details.button.delete"));
	By usersDetailsAdminAccessButton=getElementLocator(prop.getProperty("users.details.button.adminaccess"));
	By usersDetailsRevokeAdminAccessButton=getElementLocator(prop.getProperty("users.details.button.revokeAdminAccess"));
	By usersDetailsTitleStatic=getElementLocator(prop.getProperty("users.details.titleStatic"));
	By usersDetailsAdminAccessIcon=getElementLocator(prop.getProperty("users.details.adminAccess.Icon"));

	By userDetailsGroupsTab=getElementLocator(prop.getProperty("users.details.groups.tab"));
	By userDetailsAccountsTab=getElementLocator(prop.getProperty("users.details.accounts.tab"));
	By userDetailsWorkspacesTab=getElementLocator(prop.getProperty("users.details.workspaces.tab"));
	By userDetailsAssignGroupButton=getElementLocator(prop.getProperty("users.details.button.assign.group"));
	By userDetailsRefreshGroups=getElementLocator(prop.getProperty("users.details.button.group.refresh"));
	By userDetailsDeleteGroup=getElementLocator(prop.getProperty("users.details.button.group.delete"));
	By userDetailsSearchGroupField=getElementLocator(prop.getProperty("users.details.search.group.field"));
	By userDetailsSearchGroupButton=getElementLocator(prop.getProperty("users.details.search.group.button"));
	By userDetailsSearchGroupClear=getElementLocator(prop.getProperty("users.details.search.group.clear"));
	By userDetailsGroupMasterCheckbox=getElementLocator(prop.getProperty("users.details.group.mastercheckbox"));
	By userDetailsGroupNameColumn=getElementLocator(prop.getProperty("users.details.group.column.name"));
	By userDetailsGroupPathColumn=getElementLocator(prop.getProperty("users.details.group.column.path"));
	By userDetailsGroupNoRecordsToDisplay=getElementLocator(prop.getProperty("users.details.group.NoRecordsToDisplay"));
	By userDetailsGroupAvatarIcon=getElementLocator(prop.getProperty("users.details.groupAvatar"));

	By userDetailsGroupsPaginationBar=getElementLocator(prop.getProperty("users.details.groups.paginationbar"));
	By userDetailsGroupsPaginationMsg=getElementLocator(prop.getProperty("users.details.groups.paginationMsg"));

	By groupDetailsRefreshAccounts=getElementLocator(prop.getProperty("groups.details.button.accounts.refresh"));
	By groupDetailsSearchAccountField=getElementLocator(prop.getProperty("groups.details.search.accounts.field"));
	By groupDetailsSearchAccountButton=getElementLocator(prop.getProperty("groups.details.search.accounts.button"));
	By groupDetailsSearchAccountClear=getElementLocator(prop.getProperty("groups.details.search.accounts.clear"));
	By groupDetailsAccountNameColumn=getElementLocator(prop.getProperty("groups.details.accounts.column.name"));
	By groupDetailsAccountRoleColumn=getElementLocator(prop.getProperty("groups.details.accounts.column.role"));
	By groupDetailsAccountScopeColumn=getElementLocator(prop.getProperty("groups.details.accounts.column.scope"));
	By groupDetailsAccountNoRecordsToDisplay=getElementLocator(prop.getProperty("groups.details.accounts.NoRecordsToDisplay"));

	By groupDetailsAccountsPaginationBar=getElementLocator(prop.getProperty("groupd.details.accounts.paginationbar"));
	By groupDetailsWorkspacesPaginationBar=getElementLocator(prop.getProperty("groupd.details.workspaces.paginationbar"));

	By groupDetailsAccountsPaginationMsg=getElementLocator(prop.getProperty("groupd.details.accounts.paginationMsg"));
	By groupDetailsWorkspacesPaginationMsg=getElementLocator(prop.getProperty("groupd.details.workspaces.paginationMsg"));

	By groupDetailsRefreshWorkspaces=getElementLocator(prop.getProperty("groups.details.button.workspaces.refresh"));
	By groupDetailsSearchWorkspaceField=getElementLocator(prop.getProperty("groups.details.search.workspaces.field"));
	By groupDetailsSearchWorkspaceButton=getElementLocator(prop.getProperty("groups.details.search.workspaces.button"));
	By groupDetailsSearchWorkspaceClear=getElementLocator(prop.getProperty("groups.details.search.workspaces.clear"));
	By groupDetailsWorkspaceNameColumn=getElementLocator(prop.getProperty("groups.details.workspaces.column.name"));
	By groupDetailsWorkspaceRoleColumn=getElementLocator(prop.getProperty("groups.details.workspaces.column.role"));
	By groupDetailsWorkspaceTypeColumn=getElementLocator(prop.getProperty("groups.details.workspaces.column.type"));
	By groupDetailsWorkspaceScopeColumn=getElementLocator(prop.getProperty("groups.details.workspaces.column.scope"));
	By groupDetailsWorkspaceNoRecordsToDisplay=getElementLocator(prop.getProperty("groups.details.workspaces.NoRecordsToDisplay"));

	By userDetailsUserNameTitle=getElementLocator(prop.getProperty("users.details.username.title"));
	By userDetailsUserNameField=getElementLocator(prop.getProperty("users.details.username.field"));
	By userDetailsUserNameValidation=getElementLocator(prop.getProperty("users.details.username.validation"));

	By userDetailsEmailTitle=getElementLocator(prop.getProperty("users.details.email.title"));
	By userDetailsEmailField=getElementLocator(prop.getProperty("users.details.email.field"));
	By userDetailsEmailValidation=getElementLocator(prop.getProperty("users.details.email.validation"));

	By userDetailsFirstNameTitle=getElementLocator(prop.getProperty("users.details.firstname.title"));
	By userDetailsFirstNameField=getElementLocator(prop.getProperty("users.details.firstname.field"));
	By userDetailsFirstNameValidation=getElementLocator(prop.getProperty("users.details.firstname.validation"));

	By userDetailsLastNameTitle=getElementLocator(prop.getProperty("users.details.lastname.title"));
	By userDetailsLastNameField=getElementLocator(prop.getProperty("users.details.lastname.field"));
	By userDetailsLastNameValidation=getElementLocator(prop.getProperty("users.details.lastname.validation"));

	By userDetailsPasswordTitle=getElementLocator(prop.getProperty("users.details.password.title"));
	By userDetailsPasswordField=getElementLocator(prop.getProperty("users.details.password.field"));
	By userDetailsPasswordValidation=getElementLocator(prop.getProperty("users.details.password.validation"));

	By userDetailsConfirmPasswordTitle=getElementLocator(prop.getProperty("users.details.confirmpassword.title"));
	By userDetailsConfirmPasswordField=getElementLocator(prop.getProperty("users.details.confirmpassword.field"));
	By userDetailsConfirmPasswordValidation=getElementLocator(prop.getProperty("users.details.confirmpassword.validation"));

	By usersPopupBlockUserTitle=getElementLocator(prop.getProperty("users.details.popup.block.title"));
	By usersPopupBlockUserContent=getElementLocator(prop.getProperty("users.details.popup.block.content"));
	By usersPopupBlockUserButton=getElementLocator(prop.getProperty("users.details.popup.block.blockbutton"));
	By usersPopupBlockUserCancelButton=getElementLocator(prop.getProperty("users.details.popup.block.cancelbutton"));
	By usersPopupDeleteUserButton=getElementLocator(prop.getProperty("users.details.popup.block.Deletebutton"));
	By usersPopupDiscardUserButton=getElementLocator(prop.getProperty("users.details.popup.block.Discardbutton"));

	By accountDetailsPopupDiscardTitle=getElementLocator(prop.getProperty("account.details.popup.discard.title"));
	By accountDetailsPopupDiscardContent=getElementLocator(prop.getProperty("account.details.popup.discard.content"));
	By accountDetailsPopupDiscardButton=getElementLocator(prop.getProperty("account.details.popup.discard.discardbutton"));
	By accountDetailsPopupDiscardCancelButton=getElementLocator(prop.getProperty("account.details.popup.discard.cancelbutton"));

	By usersPopupDeleteGroupTitle=getElementLocator(prop.getProperty("users.details.popup.deletegroup.title"));
	By usersPopupDeleteGroupContent=getElementLocator(prop.getProperty("users.details.popup.deletegroup.content"));
	By usersPopupDeleteGroupDeleteButton=getElementLocator(prop.getProperty("users.details.popup.deletegroup.deletebutton"));
	By usersPopupDeleteGroupCancelButton=getElementLocator(prop.getProperty("users.details.popup.deletegroup.cancelbutton"));

	By userDetailsGroupAssignSidebarTitle=getElementLocator(prop.getProperty("users.details.sidebar.assigngroup.title"));
	By userDetailsGroupAssignSidebarCross=getElementLocator(prop.getProperty("users.details.sidebar.assigngroup.cross"));
	By userDetailsGroupAssignSidebarLabel=getElementLocator(prop.getProperty("users.details.sidebar.assigngroup.label"));
	By userDetailsGroupAssignSidebarField=getElementLocator(prop.getProperty("users.details.sidebar.assigngroup.field"));
	By userDetailsGroupAssignSidebarAssignButton=getElementLocator(prop.getProperty("users.details.sidebar.assigngroup.assignbutton"));
	By userDetailsGroupAssignSidebarCancelButton=getElementLocator(prop.getProperty("users.details.sidebar.assigngroup.cancelbutton"));

	By usersListingButtonsCount=getElementLocator(prop.getProperty("button.count.listing.users"));
	By usersDetailsBeforeCreateButtonsCount=getElementLocator(prop.getProperty("button.count.details.users"));
	/** ----------------------  String variables ---------------------------------- **/

	String subModuleHeadingName=prop.getProperty("nextgenmodule.submodule.headingDynamic");

	String usersListingUserNameCheckbox=prop.getProperty("users.listing.checkbox.userNamedynamic");
	String usersListingUserNameAvatar=prop.getProperty("users.listing.avatar.usernamedynamic");
	String usersListingUserNameAdminIcon=prop.getProperty("users.listing.adminIcon.userNamedynamic");
	String usersListingIdentityByName=prop.getProperty("users.listing.identity.usernamedynamic");
	String usersListingStatusByName=prop.getProperty("users.listing.status.usernamedynamic");
	String usersListingEmailByName=prop.getProperty("users.listing.email.usernamedynamic");
	String usersListingFullNameByName=prop.getProperty("users.listing.fullName.usernamedynamic");
	String usersListingUserNameDynamic=prop.getProperty("users.listing.username.userNamedynamic");

	String breadcrumbUserName=prop.getProperty("users.details.breadcrumb.usernamedynamic");
	String breadcrumbUserid=prop.getProperty("users.details.breadcrumb.useriddynamic");

	String usersDetailsFullNameHeadingDynamic=prop.getProperty("users.details.heading.fullname.dynamic");
	String userDetailsAvatarByFullnameDynamic=prop.getProperty("users.details.avatar.fullname.dynamic");

	String placeholderSearchUser = prop.getProperty("users.placeholder.searchuser");
	String placeholderSearchGroup=prop.getProperty("groups.placeholder.searchgroup");
	String placeholderSearchAccount=prop.getProperty("groups.placeholder.searchaccount");
	String placeholderSearchWorkspace=prop.getProperty("groups.placeholder.searchworkspace");

	String placeholderEnterUserName=prop.getProperty("String.placeholderEnterUserName");
	String placeholderEnterEmail=prop.getProperty("String.placeholderEnterEmail");
	String placeholderEnterFirstName=prop.getProperty("String.placeholderEnterFirstName");
	String placeholderEnterLastName=prop.getProperty("String.placeholderEnterLastName");
	String placeholderEnterPassword=prop.getProperty("String.placeholderEnterPassword");
	String placeholderConfirmPassword=prop.getProperty("String.placeholderConfirmPassword");
	String placeholderSelectGroups=prop.getProperty("placehloder.select.groups");

	String toastMsgUserCreated=prop.getProperty("users.toast.created");
	String toastMsgUserDeleted=prop.getProperty("users.toast.deleted");
	String toastMsgUsersDeleted=prop.getProperty("users.toast.delete.multiple");
	String toastMsgUserBlocked=prop.getProperty("users.toast.blocked");
	String toastMsgUsersBlocked=prop.getProperty("users.toast.blocked.multiple");
	String toastMsgUserUnBlocked=prop.getProperty("users.toast.unblocked");
	String toastMsgUsersUnBlocked=prop.getProperty("users.toast.unblocked.multiple");


	String userDetailsGroupCheckboxDynamic=prop.getProperty("users.details.group.checkbox.dynamic");
	String userDetailsGroupAvatarDynamic=prop.getProperty("users.details.group.avatar.dynamic");
	String userDetailsGroupNameDynamic=prop.getProperty("users.details.group.hyperlink.dynamic");
	String userDetailsGroupAdminFlagDynamic=prop.getProperty("users.details.group.admingflag.dynamic");
	String userDetailsGroupPathDynamic=prop.getProperty("users.details.group.path.dynamic");


	String userDetailsAccountName=prop.getProperty("users.details.accounts.namedynamic");
	String userDetailsAccountAvatar=prop.getProperty("users.details.accounts.avatardynamic");
	String userDetailsAccountRole=prop.getProperty("users.details.accounts.roledynamic");
	String userDetailsAccountScope=prop.getProperty("users.details.accounts.scopedynamic");

	String groupDetailsWorkspaceName=prop.getProperty("groups.details.workspaces.namedynamic");
	String groupDetailsWorkspaceAvatar=prop.getProperty("groups.details.workspaces.avatardynamic");
	String groupDetailsDataMonitoringWorkspaceAvatar=prop.getProperty("groups.details.DataMonitoringWorkspaces.avatardynamic");
	String groupDetailsWorkspaceRole=prop.getProperty("groups.details.workspaces.roledynamic");
	String groupDetailsWorkspaceType=prop.getProperty("groups.details.workspaces.typedynamic");
	String groupDetailsWorkspaceScope=prop.getProperty("groups.details.workspaces.scopedynamic");

	String popupSingleBlockUserTitle=prop.getProperty("users.details.popup.single.block.title");
	String popupSingleBlockUserContent=prop.getProperty("users.details.popup.single.block.content");
	String popupMultipleBlockUserTitle=prop.getProperty("users.details.popup.multiple.block.title");
	String popupMultipleBlockUserContent=prop.getProperty("users.details.popup.multiple.block.content");
	String popupSingleDeleteUserTitle=prop.getProperty("users.details.popup.single.delete.user.title");
	String popupSingleDeleteUserContent=prop.getProperty("users.details.popup.single.delete.user.content");
	String popupMultipleDeleteUserTitle=prop.getProperty("users.details.popup.multiple.delete.user.title");
	String popupMultipleDeleteUserContent=prop.getProperty("users.details.popup.multiple.delete.user.content");
	String popupDiscardAccountTitle=prop.getProperty("account.title.single.discardworkspace");
	String popupDiscardAccountContent=prop.getProperty("account.content.single.discardworkspace");

	String popupSingleDeleteGroupTitle=prop.getProperty("users.details.popup.single.delete.group.title");
	String popupSingleDeleteGroupContent=prop.getProperty("users.details.popup.single.delete.group.content");
	String popupMultipleDeleteGroupTitle=prop.getProperty("users.details.popup.multiple.delete.group.title");
	String popupMultipleDeleteGroupContent=prop.getProperty("users.details.popup.multiple.delete.group.content");

	String usersDetailsSidebarSelectGroup=prop.getProperty("users.details.sidebar.assign.group.select");


	/** ----------------------  String values ---------------------------------- **/

	String dynamicName=prop.getProperty("DynName");
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
	String createNewUserContent="Create New User";
	String moduleContent=prop.getProperty("String.moduleContent");
	String subModuleContent=prop.getProperty("String.subModuleContent");
	String columnContent=prop.getProperty("String.columnContent");
	String tabContent=prop.getProperty("String.tabContent");
	String iconContent=prop.getProperty("String.iconContent");
	String newUserContent="New User";
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

	String labelUserName=prop.getProperty("String.labelUserName");
	String labelFirstName=prop.getProperty("String.labelFirstName");
	String labelLastName=prop.getProperty("String.labelLastName");
	String labelEmail=prop.getProperty("String.labelEmail");
	String labelPassword=prop.getProperty("String.labelPassword");
	String labelConfirmPassword=prop.getProperty("String.labelConfirmPassword");

	String assignContent=prop.getProperty("String.assignContent");
	String blockContent=prop.getProperty("String.blockContent");
	String activeContent=prop.getProperty("String.activeContent");

	static String referenceColumn="key";
	static String userRefSheet="UserSheet";
	static String upadateUserRefSheet="UpdateUserSheet";
	static String groupRefSheet="GroupSheet";
	static String accountRefSheet="AccountSheet";
	static String workspaceRefSheet="WorkspaceSheet";

	String sanity = "sanity";
	

	/** ----------------------  Generic methods ---------------------------------- **/

	public static DataTestingParameters setUsersServiceParamUsingExcel(String filePath, String sheetName, int rowNumber) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();

		try {

			param.setTestScenarioName(xl.readUsingColName(filePath,sheetName, rowNumber, "testScenario"));
			param.setScenarioType(xl.readUsingColName(filePath,sheetName, rowNumber, "scenarioType"));
			param.setUserName(xl.readUsingColName(filePath,sheetName, rowNumber, "username"));
			/**param.setAccountName(xl.readUsingColName(filePath,sheetName, rowNumber, "accountName"));*/
			param.setAccountName(BaseSuite.accountName);
			param.setWorkspaceName(xl.readUsingColName(filePath,sheetName, rowNumber, "workspaceName"));
			param.setFieldValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber, "fieldValidation"));
			param.setToastValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber, "toastValidation"));
			param.setAdminFlag(xl.readUsingColName(filePath,sheetName, rowNumber, "adminflag"));
			param.setUserIdentify(xl.readUsingColName(filePath,sheetName, rowNumber, "Identify"));
			param.setGroupName(xl.readUsingColName(filePath,sheetName, rowNumber, "groupname"));
			param.setSearchName(xl.readUsingColName(filePath,sheetName, rowNumber, "searchusername"));
		} catch (Exception e) {

			BaseSuite.reportErrorLog(e, "error occurs while setUsersServiceParamUsingExcel "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setUsersParamUsingExcel(String filePath, String user) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String userNameColumn=referenceColumn;
		String usersheet=userRefSheet;
		try {

			param.setUserName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"UserName"));
			param.setFirstName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"FirstName"));
			param.setLastName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"LastName"));
			param.setEmail(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"Email"));
			param.setPassword(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"Password"));
			param.setConfirmPassword(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"ConfirmPassword"));
			param.setFullName(param.getFirstName()+" "+param.getLastName());

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e, "error occurs while setUsersParamUsingExcel "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setUpdateUsersParamUsingExcel(String filePath, String user) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String userNameColumn=referenceColumn;
		String usersheet=upadateUserRefSheet;
		try {

			param.setUserName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"UserName"));
			param.setFirstName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"FirstName"));
			param.setLastName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"LastName"));
			param.setEmail(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"Email"));
			param.setPassword(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"Password"));
			param.setConfirmPassword(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"ConfirmPassword"));
			param.setFullName(param.getFirstName()+" "+param.getLastName());

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e, "error occurs while setUpdateUsersParamUsingExcel "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setGroupParamUsingExcel(String filePath, String user) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String userNameColumn=referenceColumn;
		String usersheet=groupRefSheet;
		try {


			param.setGroupName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, user,"Groupname"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e, "error occurs while setUsersParamUsingExcel "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setAccountsParamUsingExcel(String filePath, String accountName) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		/**		String userNameColumn=referenceColumn;*/
		String usersheet=accountRefSheet;
		log.info(accountName);
		try {

			/**param.setAccountName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, accountName,"Name"));

			param.setRole(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, accountName,"Role"));
			param.setScope(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, accountName,"Scope"));*/
			param.setAccountName(BaseSuite.accountName);
			param.setRole(xl.readUsingColName(filePath,usersheet, 1,"Role"));
			param.setScope(xl.readUsingColName(filePath,usersheet, 1,"Scope"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e, "error occurs while setAccountsParamUsingExcel "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setWorkspacesParamUsingExcel(String filePath, String workspaceName) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String userNameColumn=referenceColumn;
		String usersheet=workspaceRefSheet;
		try {

			param.setWorkspaceName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, workspaceName,"Name"));
			param.setRole(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, workspaceName,"Role"));
			param.setType(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, workspaceName,"Type"));
			param.setScope(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, workspaceName,"Scope"));
			param.setWorkspaceType(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, workspaceName,"WorkspaceType"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e, "error occurs while setWorkspacesParamUsingExcel "+e.toString());
		}
		return param;

	}

	public void handleDiscardWindow() {
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isDisplayed(driver, groupDetailsHandleDiscardPopup, 10);
			if (isDisplayed(driver, groupDetailsHandleDiscardPopup, 10)) {
				clickOnButton(driver, groupDetailsHandleDiscardPopup, discardContent, true);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" handleDiscardWindow :: "+e.toString());

		}
	}

	public boolean validateUsersListingPage() {
		boolean flag=true;

		HomePage hp=new HomePage(driver);
		try {
			hp.validateNextgenIcedqModuleAndAdministrationSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Users listing page "+hyphenContent);

			validateElement(driver,breadcrumbHomeLink, homeContent, hyperlinkContent);

			validateElement(driver,breadcrumbAdministration, administrationContent, labelContent);

			validateElement(driver,breadcrumbUsers, usersContent, labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying Title and Search field Users listing page "+hyphenContent);

			verifyIndividualLabel(driver, usersPageTitle, usersContent);

			verifySearchField(driver, usersListingSearchField, placeholderSearchUser, placeholderSearchUser);

			validateElement(driver, usersListingSearchButton, placeholderSearchUser, "button");

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Users listing page "+hyphenContent);

			validateButtons(driver, usersListingButtonsCount, 4);

			verifyVisibilityOfButtons(driver, usersListingNewUserButton, newUserContent, true);
			verifyVisibilityOfButtons(driver, usersListingRefreshIcon, refreshContent, true);
			verifyVisibilityOfButtons(driver, usersListingBlockIcon, blockContent, false);
			verifyVisibilityOfButtons(driver, usersListingDeleteIcon, deleteContent, false);

			BaseSuite.reportLog(hyphenContent+"  Verifying Columns on Users listing page "+hyphenContent);

			validateElement(driver,usersListingMasterCheckbox, masterContent, "Checkbox");
			validateElement(driver,usersListingColumnFullName, "Full Name",columnContent);
			validateElement(driver,usersListingColumnUserName, "User Name", columnContent);
			validateElement(driver,usersListingColumnStatus, "Status", columnContent);
			validateElement(driver,usersListingColumnEmail, labelEmail, columnContent);
			validateElement(driver,usersListingColumnIdentity, "Identity", columnContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on Users listing page "+hyphenContent);

			getPaginationDetails(driver,usersListingPaginationMsg, usersListingPaginationBar,usersListingNoRecordsToDisplay, "User listing page");

			BaseSuite.validationReportLog(hyphenContent+" Users listing page validated successfully "+hyphenContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateUsersListingPage :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean clickOnUsersTab() {

		boolean flag = false;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, usersListingNewUserButton);

			BaseSuite.reportLog(" Clicking on "+usersContent+" "+tabContent);

			if(!isDisplayed(driver, usersListingNewUserButton)) {

				isDisplayedInLoop(driver, 2, nextgenSubModuleUsers);

				if(isDisplayed(driver, nextgenSubModuleUsers, 20)) {

					flag = isClickable(driver, nextgenSubModuleGroups, usersContent+" "+tabContent, true);

					if(flag) {

						BaseSuite.reportLog("Clicking on "+usersContent+" "+tabContent);

						displayAndClick(driver, nextgenSubModuleUsers);

						handleDiscardWindow();

						BaseSuite.validationReportLog("Clicked on "+usersContent+" "+tabContent);

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

						flag=validateElement(driver,usersPageTitle, usersContent, attributeTitle);

						clickOnButton(driver, usersListingRefreshIcon, refreshContent, true);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					}

				}else {
					BaseSuite.reportFailLog(usersContent+" tab not visible", "clickOnGroupsTab");
				}
			}else {
				BaseSuite.validationReportLog("Already on "+usersContent+" "+tabContent);
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnUsersTab :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean clickOnUsersTab(String expectedToastMessage) {

		boolean flag = false;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, usersListingNewUserButton);

			if(elementNotVisible(driver, usersListingNewUserButton)) {

				isDisplayedInLoop(driver, 2, nextgenSubModuleUsers);

				if(isDisplayed(driver, nextgenSubModuleUsers, 20)) {

					flag = isClickable(driver, nextgenSubModuleUsers, usersContent+" "+tabContent, true);

					if(flag) {

						BaseSuite.reportLog("Clicking on "+usersContent+" "+tabContent);

						displayAndClick(driver, nextgenSubModuleUsers);

						/**handleDiscardWindow();**/
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.validationReportLog("Clicked on "+usersContent+" "+tabContent);

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

						captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,
								"Groups tab authorization message");

						validateElement(driver,usersPageTitle, usersContent, attributeTitle);

						clickOnButton(driver, usersListingRefreshIcon, refreshContent, true);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						flag = captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,
								"Groups tab authorization message");

					}

				}else {
					BaseSuite.reportFailLog(usersContent+" tab not visible", "clickOnGroupsTab");
				}
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnUsersTab :: "+e.toString());
			flag=false;
		}

		return flag;

	}


	public boolean clickOnNewUserButton(String icedqUser) {

		boolean flag = true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, usersListingNewUserButton);

			if(isDisplayed(driver, usersListingNewUserButton)) {

				clickOnButton(driver, usersListingNewUserButton, newUserContent, flag);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(icedqUser.contains(adminsContent)) {

					String pgTitle=getAttribute(driver, usersPageTitle, attributeTextContent);

					flag = stringOutput(pgTitle.trim(), createNewUserContent, true);

				}else{

					flag = captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
							"New User authorization message");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnNewUserButton :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnAccountsTabUserDetails() {
		boolean flag =true;

		try {
			isDisplayedInLoop(driver, 2, userDetailsAccountsTab);

			if(isDisplayed(driver, userDetailsAccountsTab)) {

				BaseSuite.reportLog("Clicking on Accounts Tab");

				displayAndClick(driver, userDetailsAccountsTab);

				BaseSuite.validationReportLog("Clicked on Accounts Tab");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnAccountsTabUserDetails "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean clickOnWorkspacesTabUserDetails() {
		boolean flag =true;

		try {
			isDisplayedInLoop(driver, 2, userDetailsWorkspacesTab);

			if(isDisplayed(driver, userDetailsWorkspacesTab)) {

				BaseSuite.reportLog("Clicking on Workspaces Tab");

				displayAndClick(driver, userDetailsWorkspacesTab);

				BaseSuite.validationReportLog("Clicked on Workspaces Tab");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnWorkspacesTabUserDetails "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean clickOnGroupsTabUserDetails() {
		boolean flag =true;

		try {
			isDisplayedInLoop(driver, 2, userDetailsGroupsTab);

			if(isDisplayed(driver, userDetailsGroupsTab)) {

				BaseSuite.reportLog("Clicking on Groups Tab");

				displayAndClick(driver, userDetailsGroupsTab);

				BaseSuite.validationReportLog("Clicked on Groups Tab");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnGroupsTabUserDetails "+e.toString());
			flag =false;
		}

		return flag;
	}

	public String getUserIdOnUserDetailsPage(String fullName) {
		String id =null;
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			
			if(fullName.length()>100) { return "";}
			
			By locator = returnElement(breadcrumbUserid, dynamicName, fullName);
			
			isDisplayedInLoop(driver, 3, locator);

			if(isDisplayed(driver, locator)) {

				id = getText(driver, locator);

				id = id.replaceAll(regexToRemoveBracess, "");

				BaseSuite.reportLog("User id is :: "+id);
			}else {
				BaseSuite.reportFailLog("User id is not visible for "+locator, "getUserIdOnUserDetailsPage");

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" getUserIdOnUserDetailsPage :: "+e.toString());

		}
		return id;
	}


	public boolean validateUserDetailPageBeforeCreating(boolean validatebutton) {
		boolean flag = true;
		HomePage hp=new HomePage(driver);
		try {
			hp.validateNextgenIcedqModuleAndAdministrationSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Users details page "+hyphenContent);

			validateElement(driver,breadcrumbHomeLink, homeContent, hyperlinkContent);

			validateElement(driver,breadcrumbAdministrationLink, administrationContent, hyperlinkContent);

			validateElement(driver,breadcrumbUsersLink, usersContent, hyperlinkContent);

			validateElement(driver,breadcrumbCreateNewUser, createNewUserContent, labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Users details page "+hyphenContent);

			if(validatebutton) {validateButtons(driver, usersDetailsBeforeCreateButtonsCount, 6);}

			verifyVisibilityOfButtons(driver, usersDetailsSaveButton, saveContent, false);
			verifyVisibilityOfButtons(driver, usersDetailsDiscardButton, discardContent, false);
			verifyVisibilityOfButtons(driver, usersDetailsDeleteButton, deleteContent, false);

			validateElement(driver,userDetailsUserNameTitle, labelUserName, attributeTitle);
			validateField(driver, userDetailsUserNameField, labelUserName, placeholderEnterUserName, fieldContent, "", attributeTextContent,true);

			validateElement(driver,userDetailsEmailTitle, labelEmail, attributeTitle);
			validateField(driver, userDetailsEmailField, labelEmail, placeholderEnterEmail, fieldContent, "", attributeTextContent,true);

			validateElement(driver,userDetailsFirstNameTitle, labelFirstName, attributeTitle);
			validateField(driver, userDetailsFirstNameField, labelFirstName, placeholderEnterFirstName, fieldContent, "", attributeTextContent,true);

			validateElement(driver,userDetailsLastNameTitle, labelLastName, attributeTitle);
			validateField(driver, userDetailsLastNameField, labelLastName, placeholderEnterLastName, fieldContent, "", attributeTextContent,true);

			validateElement(driver,userDetailsPasswordTitle, labelPassword, attributeTitle);
			validateField(driver, userDetailsPasswordField, labelPassword, placeholderEnterPassword, fieldContent, "", attributeTextContent,true);

			validateElement(driver,userDetailsConfirmPasswordTitle, placeholderConfirmPassword, attributeTitle);
			validateField(driver, userDetailsConfirmPasswordField, placeholderConfirmPassword, placeholderConfirmPassword, fieldContent, "", attributeTextContent,true);

			verifyVisibilityOfButtons(driver, userDetailsAssignGroupButton, assignContent, false);
			verifyVisibilityOfButtons(driver, userDetailsRefreshGroups, refreshContent+" "+groupsContent, false);
			verifyVisibilityOfButtons(driver, userDetailsDeleteGroup, deleteContent+" "+groupsContent, false);

			BaseSuite.reportLog(hyphenContent+" Verifying tabs on Users details page "+hyphenContent);

			validateElement(driver,userDetailsGroupsTab, groupsContent, tabContent);
			validateElement(driver,userDetailsAccountsTab, accountsContent, tabContent);
			validateElement(driver,userDetailsWorkspacesTab, accountsContent, tabContent);

			verifySearchField(driver,userDetailsSearchGroupField, placeholderSearchGroup, placeholderSearchGroup);

			validateElement(driver,userDetailsSearchGroupButton, placeholderSearchGroup, iconContent);

			BaseSuite.reportLog(hyphenContent+" Verifying columns of groups tab "+hyphenContent);

			validateElement(driver,userDetailsGroupMasterCheckbox, masterContent, checkboxContent);
			validateElement(driver,userDetailsGroupNameColumn, "Name", columnContent);
			validateElement(driver,userDetailsGroupPathColumn, "Path", columnContent);

			validateElement(driver,userDetailsGroupNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on groups tab "+hyphenContent);

			getPaginationDetails(driver,userDetailsGroupsPaginationMsg, userDetailsGroupsPaginationBar,userDetailsGroupNoRecordsToDisplay, groupsContent+" "+tabContent);

			clickOnAccountsTabUserDetails();

			verifySearchField(driver, groupDetailsSearchAccountField, placeholderSearchAccount, placeholderSearchAccount);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Accounts "+tabContent+" "+hyphenContent);

			verifyVisibilityOfButtons(driver, groupDetailsRefreshAccounts, refreshContent, false);

			BaseSuite.reportLog(hyphenContent+" Verifying columns of Accounts "+tabContent+" "+hyphenContent);

			validateElementVisibility(driver, groupDetailsAccountNameColumn, "Name", columnContent, true);

			validateElementVisibility(driver, groupDetailsAccountRoleColumn, roleContent, columnContent, true);

			validateElementVisibility(driver, groupDetailsAccountScopeColumn, scopeContent, columnContent, true);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on Accounts "+tabContent+" "+hyphenContent);

			getPaginationDetails(driver, groupDetailsAccountsPaginationMsg, groupDetailsAccountsPaginationBar, groupDetailsAccountNoRecordsToDisplay, accountsContent+" "+tabContent);

			clickOnWorkspacesTabUserDetails();

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

			clickOnGroupsTabUserDetails();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateUserDetailPageBeforeCreating :: "+e.toString());
			flag=false;
		}
		return flag;
	}


	public String validateUserDetailPageAfterNewCreated(DataTestingParameters param, boolean validatebutton) {
		HomePage hp=new HomePage(driver);
		String totalRecords="";
		try {
			hp.validateNextgenIcedqModuleAndAdministrationSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Users details page "+hyphenContent);

			validateElement(driver,breadcrumbHomeLink, homeContent, hyperlinkContent);

			validateElement(driver,breadcrumbAdministrationLink, administrationContent, hyperlinkContent);

			validateElement(driver,breadcrumbUsersLink, usersContent, hyperlinkContent);

			String fullName = param.getFirstName()+" "+param.getLastName();

			validateElement(driver,returnElement(breadcrumbUserName, dynamicName, fullName), fullName, labelContent);

			getUserIdOnUserDetailsPage(fullName);

			validateElementVisibility(driver,returnElement(usersDetailsFullNameHeadingDynamic, dynamicName, fullName), fullName, attributeTitle, true);

			validateElementVisibility(driver,returnElement(userDetailsAvatarByFullnameDynamic, dynamicName, fullName),fullName, avatarContent, true);

			validateElement(driver,userDetailsUserNameTitle, labelUserName, attributeTitle);
			validateField(driver, userDetailsUserNameField, labelUserName, placeholderEnterUserName, fieldContent, param.getUserName(), attributeValue,false);

			validateElement(driver,userDetailsEmailTitle, labelEmail, attributeTitle);
			validateField(driver, userDetailsEmailField, labelEmail, placeholderEnterEmail, fieldContent, param.getEmail(), attributeValue,true);

			validateElement(driver,userDetailsFirstNameTitle, labelFirstName, attributeTitle);
			validateField(driver, userDetailsFirstNameField, labelFirstName, placeholderEnterFirstName, fieldContent, param.getFirstName(), attributeValue,true);

			validateElement(driver,userDetailsLastNameTitle, labelLastName, attributeTitle);
			validateField(driver, userDetailsLastNameField, labelLastName, placeholderEnterLastName, fieldContent,  param.getLastName(), attributeValue,true);

			validateElement(driver,userDetailsPasswordTitle, labelPassword, attributeTitle);
			validateField(driver, userDetailsPasswordField, labelPassword, placeholderEnterPassword, fieldContent,  "", attributeValue,true);

			validateElement(driver,userDetailsConfirmPasswordTitle, placeholderConfirmPassword, attributeTitle);
			validateField(driver, userDetailsConfirmPasswordField, placeholderConfirmPassword, placeholderConfirmPassword, fieldContent, "", attributeValue,true);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on User details page "+hyphenContent);

			if(validatebutton) {validateButtons(driver, usersDetailsBeforeCreateButtonsCount, 8);}

			verifyVisibilityOfButtons(driver, usersDetailsSaveButton, saveContent, false);
			verifyVisibilityOfButtons(driver, usersDetailsDiscardButton, discardContent, false);

			if(elementNotVisible(driver, usersDetailsAdminAccessIcon)) {

				verifyVisibilityOfButtons(driver, usersDetailsAdminAccessButton, assignAdminAccessContent, true);
			}else {
				verifyVisibilityOfButtons(driver, usersDetailsRevokeAdminAccessButton, revokeAdminAccessContent, true);
			}

			verifyVisibilityOfButtons(driver, usersDetailsDeleteButton, deleteContent, true);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Groups tab "+hyphenContent);

			verifyVisibilityOfButtons(driver, userDetailsAssignGroupButton, assignContent, true);
			verifyVisibilityOfButtons(driver, userDetailsRefreshGroups, refreshContent+" "+groupsContent, true);
			verifyVisibilityOfButtons(driver, userDetailsDeleteGroup, deleteContent+" "+groupsContent, false);

			BaseSuite.reportLog(hyphenContent+" Verifying tabs on Users details page "+hyphenContent);

			validateElement(driver,userDetailsGroupsTab, groupsContent, tabContent);
			validateElement(driver,userDetailsAccountsTab, accountsContent, tabContent);
			validateElement(driver,userDetailsWorkspacesTab, accountsContent, tabContent);

			verifySearchField(driver,userDetailsSearchGroupField, placeholderSearchGroup, placeholderSearchGroup);

			validateElement(driver,userDetailsSearchGroupButton, placeholderSearchGroup, iconContent);

			BaseSuite.reportLog(hyphenContent+" Verifying columns of groups tab "+hyphenContent);

			validateElement(driver,userDetailsGroupMasterCheckbox, masterContent, checkboxContent);
			validateElement(driver,userDetailsGroupNameColumn, "Name", columnContent);
			validateElement(driver,userDetailsGroupPathColumn, "Path", columnContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on Groups tab "+hyphenContent);

			List<String> pageInfo=getPaginationDetails(driver,userDetailsGroupsPaginationMsg, userDetailsGroupsPaginationBar,userDetailsGroupNoRecordsToDisplay, groupsContent+" "+tabContent);

			totalRecords=pageInfo.get(1);

			clickOnAccountsTabUserDetails();

			verifySearchField(driver,groupDetailsSearchAccountField, placeholderSearchAccount, placeholderSearchAccount);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Accounts tab "+hyphenContent);

			verifyVisibilityOfButtons(driver, groupDetailsRefreshAccounts, refreshContent, true);

			BaseSuite.reportLog(hyphenContent+" Verifying columns of Accounts tab "+hyphenContent);

			validateElementVisibility(driver,groupDetailsAccountNameColumn, "Name", columnContent, true);

			validateElementVisibility(driver,groupDetailsAccountRoleColumn, roleContent, columnContent, true);

			validateElementVisibility(driver,groupDetailsAccountScopeColumn, scopeContent, columnContent, true);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on Accounts tab "+hyphenContent);

			getPaginationDetails(driver, groupDetailsAccountsPaginationMsg, groupDetailsAccountsPaginationBar, groupDetailsAccountNoRecordsToDisplay, accountsContent+" "+tabContent);

			clickOnWorkspacesTabUserDetails();

			verifySearchField(driver,groupDetailsSearchWorkspaceField, placeholderSearchWorkspace, placeholderSearchWorkspace);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Workspaces tab "+hyphenContent);

			verifyVisibilityOfButtons(driver, groupDetailsRefreshWorkspaces, refreshContent, true);

			BaseSuite.reportLog(hyphenContent+" Verifying columns of Workspaces tab "+hyphenContent);

			validateElementVisibility(driver,groupDetailsWorkspaceNameColumn, "Name", columnContent, true);

			validateElementVisibility(driver,groupDetailsWorkspaceRoleColumn, roleContent, columnContent, true);

			validateElementVisibility(driver,groupDetailsWorkspaceTypeColumn, typeContent, columnContent, true);

			validateElementVisibility(driver,groupDetailsWorkspaceScopeColumn, scopeContent, columnContent, true);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on Workspaces tab "+hyphenContent);

			getPaginationDetails(driver, groupDetailsWorkspacesPaginationMsg, groupDetailsWorkspacesPaginationBar, groupDetailsWorkspaceNoRecordsToDisplay, workspacesContent+" "+tabContent);

			clickOnGroupsTabUserDetails();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateUserDetailPageAfterNewCreated :: "+e.toString());

		}
		return totalRecords;
	}

	public boolean clickOnSaveButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {
			clickOnButton(driver, usersDetailsSaveButton, saveContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "User Created");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"User Created");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnSaveButtonAndValidateToast :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean clickOnDeleteButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {
			clickOnButton(driver, usersDetailsDeleteButton, deleteContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "User Delete");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"User Delete");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnDeleteButtonAndValidateToast :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean clickOnBlockUsersAndValidateToast(boolean flag, int numberOfUsers) {
		String toastMsgContent="";
		try {

			if(numberOfUsers==1) {
				validatePopupWindowContent(driver, flag, usersPopupBlockUserTitle, usersPopupBlockUserContent, popupSingleBlockUserTitle, popupSingleBlockUserContent);
				toastMsgContent=toastMsgUserBlocked;
			}else {
				validatePopupWindowContent(driver,flag, usersPopupBlockUserTitle, usersPopupBlockUserContent, popupMultipleBlockUserTitle, popupMultipleBlockUserContent);
				toastMsgContent=toastMsgUsersBlocked;
			}

			verifyVisibilityOfButtons(driver, usersPopupBlockUserButton, blockContent, true);
			verifyVisibilityOfButtons(driver, usersPopupBlockUserCancelButton, cancelButtonContent, true);

			clickOnButton(driver, usersPopupBlockUserButton, blockContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, toastMsgContent, "User block");

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnBlockUsersAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnUnBlockUsersAndValidateToast(boolean flag, int numberOfUsers) {
		String toastMsgContent="";
		try {

			if(numberOfUsers==1) {
				/**	validatePopupWindowContent(driver, flag, usersPopupBlockUserTitle, usersPopupBlockUserContent, popupSingleBlockUserTitle, popupSingleBlockUserContent);**/
				toastMsgContent=toastMsgUserUnBlocked;
			}else {
				/**	validatePopupWindowContent(driver,flag, usersPopupBlockUserTitle, usersPopupBlockUserContent, popupMultipleBlockUserTitle, popupMultipleBlockUserContent);**/
				toastMsgContent=toastMsgUsersUnBlocked;
			}
			/**
			verifyVisibilityOfButtons(driver, usersPopupUnBlockUserButton, blockContent, true);
			verifyVisibilityOfButtons(driver, usersPopupBlockUserCancelButton, cancelButtonContent, true);
			 **/
			clickOnButton(driver, usersListingUnBlockIcon, "Unblock", true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, toastMsgContent, "User block");

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnUnBlockUsersAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnDeleteUsersAndValidateToast(boolean flag, int numberOfUsers) {
		String toastMsgContent="";
		try {

			if(numberOfUsers==1) {
				validatePopupWindowContent(driver, flag, usersPopupBlockUserTitle, usersPopupBlockUserContent, popupSingleDeleteUserTitle, popupSingleDeleteUserContent);
				toastMsgContent=toastMsgUserDeleted;
			}else {
				validatePopupWindowContent(driver,flag, usersPopupBlockUserTitle, usersPopupBlockUserContent, popupMultipleDeleteUserTitle, popupMultipleDeleteUserContent);
				toastMsgContent=toastMsgUsersDeleted;
			}

			verifyVisibilityOfButtons(driver, usersPopupDeleteUserButton, deleteContent, true);
			verifyVisibilityOfButtons(driver, usersPopupBlockUserCancelButton, cancelButtonContent, true);

			clickOnButton(driver, usersPopupDeleteUserButton, deleteContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, toastMsgContent, "User "+deleteContent);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnDeleteUsersAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnDeleteUsersFromGroupAndValidateToast(boolean flag, int numberOfUsers) {

		try {

			if(numberOfUsers==1) {
				validatePopupWindowContent(driver, flag, usersPopupDeleteGroupTitle, usersPopupDeleteGroupContent, popupSingleDeleteGroupTitle, popupSingleDeleteGroupContent);

			}else {
				validatePopupWindowContent(driver,flag, usersPopupDeleteGroupTitle, usersPopupDeleteGroupContent, popupMultipleDeleteGroupTitle, popupMultipleDeleteGroupContent);

			}

			verifyVisibilityOfButtons(driver, usersPopupDeleteGroupDeleteButton, deleteContent, true);
			verifyVisibilityOfButtons(driver, usersPopupDeleteGroupCancelButton, cancelButtonContent, true);

			clickOnButton(driver, usersPopupDeleteGroupDeleteButton, deleteContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			/**
			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, toastMsgContent, "User "+deleteContent);

			}
			 **/
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnDeleteUsersFromGroupAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnDiscardUsersAndValidateToast(boolean flag, String expectedtoastMsg) {

		boolean tag =true;
		try {

			validatePopupWindowContent(driver, flag, accountDetailsPopupDiscardTitle, accountDetailsPopupDiscardContent, popupDiscardAccountTitle, popupDiscardAccountContent);

			verifyVisibilityOfButtons(driver, accountDetailsPopupDiscardButton, discardContent, true);
			verifyVisibilityOfButtons(driver, accountDetailsPopupDiscardCancelButton, cancelButtonContent, true);

			clickOnButton(driver, accountDetailsPopupDiscardButton, discardContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedtoastMsg, usersContent+" "+discardContent);
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedtoastMsg.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedtoastMsg,usersContent+" "+discardContent);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnDiscardUsersAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public void validateUserDetailsOnListingPage(DataTestingParameters param,String status, boolean adminFlag) {

		try {
			BaseSuite.reportLog(hyphenContent+" Verifying user details on user listing page "+hyphenContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateElementVisibility(driver,returnElement(usersListingUserNameCheckbox, dynamicName, param.getUserName()), "Username", checkboxContent, true);

			validateElementVisibility(driver,returnElement(usersListingUserNameAvatar, dynamicName, param.getUserName()), "User", avatarContent, true);

			validateValueWithActual(driver,returnElement(usersListingFullNameByName, dynamicName, param.getUserName()), "Full Name", param.getFullName(),attributeTextContent);

			validateElementVisibility(driver,returnElement(usersListingUserNameAdminIcon, dynamicName, param.getUserName()), "Admin Access", iconContent,adminFlag);

			validateValueWithActual(driver,returnElement(usersListingStatusByName, dynamicName, param.getUserName()), "Status", status,attributeTextContent);

			validateValueWithActual(driver,returnElement(usersListingEmailByName, dynamicName, param.getUserName()), labelEmail, param.getEmail(),attributeTextContent);

			validateValueWithActual(driver,returnElement(usersListingIdentityByName,  dynamicName, param.getUserName()), "Identity", "Local", attributeTextContent);

			clickOnRefreshOnUsersListingPage("");

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateUserDetailsOnListingPage :: "+e.toString());
		}

	}

	public boolean clickOnRefreshOnUsersListingPage(String toastMsgValidation) {

		boolean flag=true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, usersListingRefreshIcon, refreshContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(!toastMsgValidation.isEmpty()) {
				flag = captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, toastMsgValidation,
						"authorization message");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnRefreshOnUsersListingPage :: "+e.toString());
		}
		return flag;
	}

	public boolean searchGroupNameOnEachPageAndClickOn(By locator,String name) {

		boolean flag=true;
		boolean nextpageFlag=true;
		int pn=0;

		try {

			do {

				BaseSuite.reportLog("searching user name : "+name+" on page number :"+(pn+1));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 2, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportLog("user name : "+name+" found on page number :"+(pn+1));

					flag=clickOnButton(driver, locator, name, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					break;
				}
				if(isDisplayed(driver, usersListingNextPageArrow)) {

					String status = getAttribute(driver, usersListingNextPageArrow, attributeClass);

					if (!status.contains("disable")) {

						clickOnButton(driver, usersListingNextPageArrow, "next page", true);
						pn++;
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					} else {
						BaseSuite.reportLog("Page arrow :: next page is disabled");
						nextpageFlag=false;
					}

				}

			}while(nextpageFlag);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" searchGroupNameOnEachPageAndClickOn :: "+e.toString());
			flag=false;
		}
		return flag;
	}


	public boolean searchUserAndClickOnUserName(String username) {
		boolean flag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=searchFunctionalityMethod(driver, flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, username);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && elementNotVisible(driver, usersListingNoRecordsToDisplay)) {

				flag=searchGroupNameOnEachPageAndClickOn(returnElement(usersListingFullNameByName, dynamicName, username), username);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}else {
				BaseSuite.reportFailLog("No records to display is visible","searchUserAndClickOnUserName");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" searchUserAndClickOnUserName "+e.toString());
			flag=false;
		}
		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		return flag;
	}

	public boolean clickOnAccountsTabGroupDetails() {
		boolean flag =true;

		try {
			isDisplayedInLoop(driver, 2, userDetailsAccountsTab);

			if(isDisplayed(driver, userDetailsAccountsTab)) {

				BaseSuite.reportLog("Clicking on Accounts Tab");

				displayAndClick(driver, userDetailsAccountsTab);

				BaseSuite.validationReportLog("Clicked on Accounts Tab");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnAccountsTabGroupDetails "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean clickOnWorkspacesTabGroupDetails() {
		boolean flag =true;

		try {
			isDisplayedInLoop(driver, 2, userDetailsWorkspacesTab);

			if(isDisplayed(driver, userDetailsWorkspacesTab)) {

				BaseSuite.reportLog("Clicking on Workspaces Tab");

				displayAndClick(driver, userDetailsWorkspacesTab);

				BaseSuite.validationReportLog("Clicked on Workspaces Tab");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnWorkspacesTabGroupDetails "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean searchAndViewAccountInGroup(boolean flag,String accountName, String role, String scope) {

		try {
			BaseSuite.reportLog(hyphenContent+" Validate Account in  group :: "+accountName+" "+hyphenContent);

			flag=searchFunctionalityMethod(driver, true, groupDetailsSearchAccountField, groupDetailsSearchAccountButton, placeholderSearchAccount, placeholderSearchAccount, accountName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {

				validateElement(driver, returnElement(userDetailsAccountAvatar, dynamicName, accountName), accountName, avatarContent);

				validateElement(driver, returnElement(userDetailsAccountName, dynamicName, accountName), accountName, hyperlinkContent);

				validateElementVisibility(driver, returnElement(userDetailsAccountRole, dynamicName, accountName), roleContent, labelContent, true);

				String acrole=getAttribute(driver, returnElement(userDetailsAccountRole, dynamicName, accountName), attributeTextContent);

				stringContainsOutput(acrole, role, true);

				validateElement(driver, returnElement(userDetailsAccountScope, dynamicName, accountName), scopeContent, labelContent);

				String acscope=getAttribute(driver, returnElement(userDetailsAccountScope, dynamicName, accountName), attributeTextContent);

				stringContainsOutput(acscope, scope, true);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" searchAndViewAccountInGroup "+e.toString());
		}

		return flag;
	}

	public boolean searchAndViewWorkspaceInGroup(boolean flag,String workspaceName, String role, String type, String scope, String workspaceType) {

		try {
			BaseSuite.reportLog(hyphenContent+" Validate Workspace in  group :: "+workspaceName+" "+hyphenContent);

			flag=searchFunctionalityMethod(driver, true, groupDetailsSearchWorkspaceField, groupDetailsSearchWorkspaceButton, placeholderSearchWorkspace, placeholderSearchWorkspace, workspaceName);

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
			BaseSuite.reportErrorLog(e, errorLogTitle+" searchAndViewAccountInGroup "+e.toString());
		}

		return flag;
	}

	public boolean searchAndViewAssignGroupToUser(boolean flag,String groupName,boolean adminflag) {

		try {
			BaseSuite.reportLog(hyphenContent+" Validate Group assign to user  :: "+groupName+" "+hyphenContent);

			flag=searchFunctionalityMethod(driver, true, userDetailsSearchGroupField, userDetailsSearchGroupButton, placeholderSearchGroup, placeholderSearchGroup, groupName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {

				validateElement(driver,returnElement(userDetailsGroupCheckboxDynamic, dynamicName, groupName), groupName, checkboxContent);

				validateElement(driver,returnElement(userDetailsGroupAvatarDynamic, dynamicName, groupName), groupName, avatarContent);

				validateElement(driver,returnElement(userDetailsGroupNameDynamic, dynamicName, groupName), groupName, hyperlinkContent);

				validateElementVisibility(driver,returnElement(userDetailsGroupAdminFlagDynamic, dynamicName, groupName), adminContent, iconContent, adminflag);

				validateElement(driver,returnElement(userDetailsGroupPathDynamic, dynamicName, groupName), groupName+" Path", labelContent);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" searchAndViewAssignGroupToUser "+e.toString());
		}

		return flag;
	}

	public boolean viewAddedAccountDetails(String accountName) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if(!accountName.isEmpty()) {

				if(accountName.contains(",")) {

					iceuserName= accountName.split(","); 

					for(int i=0;i<iceuserName.length;i++) {

						DataTestingParameters param = setAccountsParamUsingExcel(uSEREXCELFILEPATH, iceuserName[i]);

						searchAndViewAccountInGroup(flag, param.getAccountName(),param.getRole(),param.getScope());
					}

				}else {

					DataTestingParameters param = setAccountsParamUsingExcel(uSEREXCELFILEPATH, accountName);

					searchAndViewAccountInGroup(flag, param.getAccountName(),param.getRole(),param.getScope());

				}

				displayAndClick(driver, groupDetailsSearchAccountField);

				displayAndClick(driver, groupDetailsSearchAccountClear);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" viewAddedAccountDetails "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean viewAddedWorkspaceDetails(String workspaceName) {
		String[] iceuserName=null;
		boolean flag =true;

		try {
			if(!workspaceName.isEmpty()) {

				if(workspaceName.contains(",")) {

					iceuserName= workspaceName.split(","); 

					for(int i=0;i<iceuserName.length;i++) {

						DataTestingParameters param = setWorkspacesParamUsingExcel(uSEREXCELFILEPATH, iceuserName[i]);

						searchAndViewWorkspaceInGroup(flag, param.getWorkspaceName(),param.getRole(),param.getType(),param.getScope(), param.getWorkspaceType());
					}

				}else {

					DataTestingParameters param = setWorkspacesParamUsingExcel(uSEREXCELFILEPATH, workspaceName);

					searchAndViewWorkspaceInGroup(flag, param.getWorkspaceName(),param.getRole(),param.getType(),param.getScope(), param.getWorkspaceType());

				}

				displayAndClick(driver, groupDetailsSearchWorkspaceField);

				displayAndClick(driver, groupDetailsSearchWorkspaceClear);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" viewAddedWorkspaceDetails "+e.toString());
			flag =false;
		}

		return flag;

	}



	public boolean viewAssignGroupDetails(String userName, boolean adminFlag) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if(userName.contains(",")) {

				iceuserName= userName.split(","); 

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setGroupParamUsingExcel(uSEREXCELFILEPATH, iceuserName[i]);


					searchAndViewAssignGroupToUser(flag, param.getGroupName(),adminFlag);
				}

			}else {

				DataTestingParameters param = setGroupParamUsingExcel(uSEREXCELFILEPATH, userName);

				searchAndViewAssignGroupToUser(flag, param.getGroupName(),adminFlag);

			}

			displayAndClick(driver, userDetailsSearchGroupField);

			displayAndClick(driver, userDetailsSearchGroupClear);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" viewAssignGroupDetails "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean clickOnAccountsTabInUserDetailsAndValidate(String accountName) {
		boolean flag =true;

		try {
			isDisplayedInLoop(driver, 2, userDetailsAccountsTab);

			if(isDisplayed(driver, userDetailsAccountsTab)) {

				clickOnAccountsTabUserDetails();

				verifySearchField(driver, groupDetailsSearchAccountField, placeholderSearchAccount, placeholderSearchAccount);

				BaseSuite.reportLog(hyphenContent+" Verifying buttons on Accounts tab "+hyphenContent);

				verifyVisibilityOfButtons(driver, groupDetailsRefreshAccounts, refreshContent, true);

				BaseSuite.reportLog(hyphenContent+" Verifying columns of Accounts tab "+hyphenContent);

				validateElementVisibility(driver, groupDetailsAccountNameColumn, "Name", columnContent, true);

				validateElementVisibility(driver, groupDetailsAccountRoleColumn, roleContent, columnContent, true);

				validateElementVisibility(driver, groupDetailsAccountScopeColumn, scopeContent, columnContent, true);

				BaseSuite.reportLog(hyphenContent+" Verifying pagination on Accounts tab "+hyphenContent);

				List<String> pageInfo=getPaginationDetails(driver, groupDetailsAccountsPaginationMsg, groupDetailsAccountsPaginationBar, groupDetailsAccountNoRecordsToDisplay, accountsContent+" "+tabContent);

				String totalRecords=pageInfo.get(1);

				boolean shouldDisplay = totalRecords.equalsIgnoreCase("0");
				validateElementVisibility(driver, groupDetailsAccountNoRecordsToDisplay, noRecordsToDisplayContent, labelContent, shouldDisplay);

				if(!accountName.isEmpty() && !totalRecords.equalsIgnoreCase("0")) {

					viewAddedAccountDetails(accountName);
				}

			}else {
				BaseSuite.reportFailLog("Accounts Tab not visible", "clickOnAccountsTabInUserDetailsAndValidate");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnAccountsTabInUserDetailsAndValidate "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean clickOnWorkspacesTabInUserDetailsAndValidate(String workspaceName) {
		boolean flag =true;

		try {
			isDisplayedInLoop(driver, 2, userDetailsWorkspacesTab);

			if(isDisplayed(driver, userDetailsWorkspacesTab)) {

				clickOnWorkspacesTabUserDetails();

				verifySearchField(driver, groupDetailsSearchWorkspaceField, placeholderSearchWorkspace, placeholderSearchWorkspace);

				BaseSuite.reportLog(hyphenContent+" Verifying buttons on Workspaces tab "+hyphenContent);

				verifyVisibilityOfButtons(driver, groupDetailsRefreshWorkspaces, refreshContent, true);

				BaseSuite.reportLog(hyphenContent+" Verifying columns of Workspaces tab "+hyphenContent);

				validateElementVisibility(driver, groupDetailsWorkspaceNameColumn, "Name", columnContent, true);

				validateElementVisibility(driver, groupDetailsWorkspaceRoleColumn, roleContent, columnContent, true);

				validateElementVisibility(driver, groupDetailsWorkspaceTypeColumn, typeContent, columnContent, true);

				validateElementVisibility(driver, groupDetailsWorkspaceScopeColumn, scopeContent, columnContent, true);

				BaseSuite.reportLog(hyphenContent+" Verifying pagination on Workspaces tab "+hyphenContent);

				List<String> pageInfo=getPaginationDetails(driver, groupDetailsWorkspacesPaginationMsg, groupDetailsWorkspacesPaginationBar, groupDetailsWorkspaceNoRecordsToDisplay, workspacesContent+" "+tabContent);

				String totalRecords=pageInfo.get(1);

				boolean shouldDisplay = totalRecords.equalsIgnoreCase("0");

				validateElementVisibility(driver, groupDetailsWorkspaceNoRecordsToDisplay, noRecordsToDisplayContent, labelContent, shouldDisplay);


				if(!workspaceName.isEmpty() && !totalRecords.equalsIgnoreCase("0")) {

					viewAddedWorkspaceDetails(workspaceName);
				}


			}else {
				BaseSuite.reportFailLog("Workspaces Tab not visible", "clickOnWorkspacesTabInUserDetailsAndValidate");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnWorkspacesTabInUserDetailsAndValidate "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean selectUserCheckbox(boolean flag, String userName) {

		try {
			By namelocator = returnElement(usersListingUserNameDynamic, dynamicName, userName);
			By checkboxlocator = returnElement(usersListingUserNameCheckbox, dynamicName, userName);

			isDisplayedInLoop(driver, 2, namelocator);

			if(isDisplayed(driver, namelocator)) {

				BaseSuite.reportLog("User full name is visible as "+userName);

				if(isDisplayed(driver, checkboxlocator)) {

					BaseSuite.reportLog("User full name checkbox is visible");

					flag=selectcheckbox(driver, checkboxlocator, userName);

				}else {
					BaseSuite.reportFailLog("User full name checkbox is not visible "+userName, "selectUserCheckbox");
				}
			}else {
				BaseSuite.reportFailLog("User full name is not visible", "selectUserCheckbox");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" selectUserCheckbox "+e.toString());
		}
		return flag;
	}

	public boolean selectGroupCheckbox(boolean flag, String groupName) {

		try {
			By namelocator = returnElement(userDetailsGroupNameDynamic, dynamicName, groupName);
			By checkboxlocator = returnElement(userDetailsGroupCheckboxDynamic, dynamicName, groupName);

			isDisplayedInLoop(driver, 2, namelocator);

			if(isDisplayed(driver, namelocator)) {

				BaseSuite.reportLog("Group is visible as "+groupName);

				if(isDisplayed(driver, checkboxlocator)) {

					BaseSuite.reportLog("Group checkbox is visible");

					flag=selectcheckbox(driver, checkboxlocator, groupName);

				}else {
					BaseSuite.reportFailLog("Group checkbox is not visible "+groupName, "selectGroupCheckbox");
				}
			}else {
				BaseSuite.reportFailLog("Group is not visible", "selectGroupCheckbox");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" selectGroupCheckbox "+e.toString());
		}
		return flag;
	}

	//main method
	public boolean createUserFunctionality(DataTestingParameters param, String icedqUser) {
		boolean flag =true;
		String totalRecords="";
		boolean uicheck=!BaseSuite.suiteType.equalsIgnoreCase(sanity);
		try {

			flag=clickOnNewUserButton(icedqUser);

			if(flag && icedqUser.toLowerCase().contains(adminsContent)) {
				if(uicheck) {
					validateUserDetailPageBeforeCreating(true);
				}else {
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}
				validatAndeEnterValueToTextField(driver, userDetailsUserNameTitle, userDetailsUserNameField, userDetailsUserNameValidation, labelUserName, placeholderEnterUserName, param.getUserName(), "");
				validatAndeEnterValueToTextField(driver, userDetailsEmailTitle, userDetailsEmailField, userDetailsEmailValidation, labelEmail, placeholderEnterEmail, param.getEmail(), "");
				validatAndeEnterValueToTextField(driver, userDetailsFirstNameTitle, userDetailsFirstNameField, userDetailsFirstNameValidation, labelFirstName, placeholderEnterFirstName, param.getFirstName(), "");
				validatAndeEnterValueToTextField(driver, userDetailsLastNameTitle, userDetailsLastNameField, userDetailsLastNameValidation, labelLastName, placeholderEnterLastName, param.getLastName(), "");
				validatAndeEnterValueToTextField(driver, userDetailsPasswordTitle, userDetailsPasswordField, userDetailsPasswordValidation, labelPassword, placeholderEnterPassword, param.getPassword(), "");
				validatAndeEnterValueToTextField(driver, userDetailsConfirmPasswordTitle, userDetailsConfirmPasswordField, userDetailsConfirmPasswordValidation, placeholderConfirmPassword, placeholderConfirmPassword, param.getConfirmPassword(), "");

				verifyVisibilityOfButtons(driver, usersDetailsSaveButton, saveContent, true);
				verifyVisibilityOfButtons(driver, usersDetailsDiscardButton, discardContent, true);

				flag=clickOnSaveButtonAndValidateToast(flag, toastMsgUserCreated);

				if(uicheck) {

					totalRecords=validateUserDetailPageAfterNewCreated(param, false);

					if(totalRecords.equalsIgnoreCase("0")) {

						validateElement(driver, userDetailsGroupNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);
					}else {
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					}

					clickOnUsersTab();

					flag=searchFunctionalityMethod(driver,flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, param.getFullName());

					validateUserDetailsOnListingPage(param,activeContent,Boolean.parseBoolean(param.getAdminFlag()));		

				}else {

					clickOnUsersTab();

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" createUserFunctionality :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean createUserForPre(DataTestingParameters param, String icedqUser) {
		boolean flag =true;
		boolean uicheck=!BaseSuite.suiteType.equalsIgnoreCase(sanity) ;
		try {
			flag=clickOnNewUserButton(icedqUser);

			if(flag && icedqUser.toLowerCase().contains(adminsContent)) {
				if(uicheck) {
					validateUserDetailPageBeforeCreating(true);
				}else {
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}
				validatAndeEnterValueToTextField(driver, userDetailsUserNameTitle, userDetailsUserNameField, userDetailsUserNameValidation, labelUserName, placeholderEnterUserName, param.getUserName(), "");
				validatAndeEnterValueToTextField(driver, userDetailsEmailTitle, userDetailsEmailField, userDetailsEmailValidation, labelEmail, placeholderEnterEmail, param.getEmail(), "");
				validatAndeEnterValueToTextField(driver, userDetailsFirstNameTitle, userDetailsFirstNameField, userDetailsFirstNameValidation, labelFirstName, placeholderEnterFirstName, param.getFirstName(), "");
				validatAndeEnterValueToTextField(driver, userDetailsLastNameTitle, userDetailsLastNameField, userDetailsLastNameValidation, labelLastName, placeholderEnterLastName, param.getLastName(), "");
				validatAndeEnterValueToTextField(driver, userDetailsPasswordTitle, userDetailsPasswordField, userDetailsPasswordValidation, labelPassword, placeholderEnterPassword, param.getPassword(), "");
				validatAndeEnterValueToTextField(driver, userDetailsConfirmPasswordTitle, userDetailsConfirmPasswordField, userDetailsConfirmPasswordValidation, placeholderConfirmPassword, placeholderConfirmPassword, param.getConfirmPassword(), "");

				flag=clickOnSaveButtonAndValidateToast(flag, toastMsgUserCreated);

			}
		} catch (NoSuchElementException e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" createUserFunctionality :: "+e.toString());
			flag=false;
		}
		return flag;
	}


	public boolean viewUserFunctionality(DataTestingParameters param,String groupName, String accountName, String workspaceName,  String icedqUser, boolean ui) {

		boolean flag =true;
		String totalRecords="";	
		boolean adminFlag =true;
		log.info(icedqUser);
		try {
			if(ui) {
				totalRecords=validateUserDetailPageAfterNewCreated(param,true);
			}
			if(elementNotVisible(driver, usersDetailsAdminAccessIcon)) {

				adminFlag =false;
			}

			if(totalRecords.equalsIgnoreCase("0")) {

				validateElement(driver,userDetailsGroupNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);
			}else {

				viewAssignGroupDetails(groupName, adminFlag);
			}

			clickOnAccountsTabInUserDetailsAndValidate(accountName);

			clickOnWorkspacesTabInUserDetailsAndValidate(workspaceName);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" viewUserFunctionality :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean updateUserFunctionality(DataTestingParameters param, String icedqUser) {
		boolean flag =true;
		String totalRecords="";
		boolean uicheck=!BaseSuite.suiteType.equalsIgnoreCase(sanity) ;
		try {

			if(icedqUser.toLowerCase().contains(adminsContent)) {

				validatAndeEnterValueToTextField(driver, userDetailsEmailTitle, userDetailsEmailField, userDetailsEmailValidation, labelEmail, placeholderEnterEmail, param.getEmail(), "");
				validatAndeEnterValueToTextField(driver, userDetailsFirstNameTitle, userDetailsFirstNameField, userDetailsFirstNameValidation, labelFirstName, placeholderEnterFirstName, param.getFirstName(), "");
				validatAndeEnterValueToTextField(driver, userDetailsLastNameTitle, userDetailsLastNameField, userDetailsLastNameValidation, labelLastName, placeholderEnterLastName, param.getLastName(), "");
				validatAndeEnterValueToTextField(driver, userDetailsPasswordTitle, userDetailsPasswordField, userDetailsPasswordValidation, labelPassword, placeholderEnterPassword, param.getPassword(), "");
				validatAndeEnterValueToTextField(driver, userDetailsConfirmPasswordTitle, userDetailsConfirmPasswordField, userDetailsConfirmPasswordValidation, placeholderConfirmPassword, placeholderConfirmPassword, param.getConfirmPassword(), "");

				verifyVisibilityOfButtons(driver, usersDetailsSaveButton, saveContent, true);
				verifyVisibilityOfButtons(driver, usersDetailsDiscardButton, discardContent, true);

				flag=clickOnSaveButtonAndValidateToast(flag, "");
				if(uicheck) {
					totalRecords=validateUserDetailPageAfterNewCreated(param, false);

					if(totalRecords.equalsIgnoreCase("0")) {

						validateElement(driver, userDetailsGroupNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);
					}
				}else {
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}
				clickOnUsersTab();

				flag=searchFunctionalityMethod(driver,flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, param.getUserName());

				if(flag) {

					validateUserDetailsOnListingPage(param,activeContent,Boolean.parseBoolean(param.getAdminFlag()));		
				}

				clickOnRefreshOnUsersListingPage("");

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" updateUserFunctionality :: "+e.toString());
			flag=false;
		}
		return flag;

	}



	public boolean createUserValid(DataTestingParameters xparam, String icedqUser) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if(xparam.getUserName().contains(",")) {

				iceuserName= xparam.getUserName().split(","); 

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, iceuserName[i]);

					createUserFunctionality(param, icedqUser);

				}

			}else {

				DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, xparam.getUserName());

				createUserFunctionality(param, icedqUser);

			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" createUserValid "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean readUserValid(DataTestingParameters xparam, String icedqUser, boolean ui) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if(xparam.getUserName().contains(",")) {

				iceuserName= xparam.getUserName().split(","); 

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, iceuserName[i]);

					viewUserFunctionality(param,xparam.getGroupName(),xparam.getAccountName(), xparam.getWorkspaceName(), icedqUser, ui);

				}

			}else {

				DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, xparam.getUserName());

				viewUserFunctionality(param,xparam.getGroupName(), xparam.getAccountName(), xparam.getWorkspaceName(), icedqUser, ui);

			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" readUserValid "+e.toString());
			flag =false;
		}

		return flag;

	}


	public boolean updateUserValid(DataTestingParameters xparam, String icedqUser) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if(xparam.getUserName().contains(",")) {

				iceuserName= xparam.getUserName().split(","); 

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, iceuserName[i]);
					DataTestingParameters upparam = setUpdateUsersParamUsingExcel(uSEREXCELFILEPATH, iceuserName[i]);

					if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateUserDetailPageAfterNewCreated(param, false);}

					updateUserFunctionality(upparam, icedqUser);
				}

			}else {

				DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, xparam.getUserName());
				DataTestingParameters upparam = setUpdateUsersParamUsingExcel(uSEREXCELFILEPATH, xparam.getUserName());

				if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateUserDetailPageAfterNewCreated(param, false);}

				updateUserFunctionality(upparam, icedqUser);
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" updateUserValid "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean blockUserValid(DataTestingParameters xparam, String icedqUser) {
		String[] iceuserName=null;
		boolean flag =true;
		int numberOfUsers=1;
		log.info(icedqUser);
		try {

			if(xparam.getUserName().contains(",")) {

				iceuserName= xparam.getUserName().split(","); 

				numberOfUsers = iceuserName.length;

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, iceuserName[i]);

					flag=searchFunctionalityMethod(driver, flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, param.getUserName());

					selectUserCheckbox(flag, param.getUserName());

					searchFunctionalityMethod(driver, flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, "");

				}

			}else {

				numberOfUsers = 1;

				DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, xparam.getUserName());

				flag=searchFunctionalityMethod(driver, flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, param.getUserName());

				selectUserCheckbox(flag, param.getUserName());


			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			searchFunctionalityMethod(driver,true, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, "");

			flag=clickOnButton(driver, usersListingBlockIcon, "block user", true);

			flag=clickOnBlockUsersAndValidateToast(flag, numberOfUsers);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" blockUserValid "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean validateBlockUserValid(DataTestingParameters xparam, String userStatus) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if(xparam.getUserName().contains(",")) {

				iceuserName= xparam.getUserName().split(","); 

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, iceuserName[i]);

					flag=searchFunctionalityMethod(driver,flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, param.getUserName());

					if(flag) {

						validateUserDetailsOnListingPage(param,userStatus,Boolean.parseBoolean(param.getAdminFlag()));		
					}
				}

			}else {

				DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, xparam.getUserName());

				flag=searchFunctionalityMethod(driver,flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, param.getUserName());

				if(flag) {

					validateUserDetailsOnListingPage(param,userStatus,Boolean.parseBoolean(param.getAdminFlag()));		
				}
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateBlockUserValid "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean blockUserCheckForValidScenario(DataTestingParameters xparam, String userStatus, String icedqUser) {
		boolean flag =true;

		try {

			blockUserValid(xparam, icedqUser);

			validateBlockUserValid(xparam, userStatus);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" blockUserCheckForValidScenario "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean unblockUserValid(DataTestingParameters xparam, String icedqUser) {
		String[] iceuserName=null;
		boolean flag =true;
		int numberOfUsers=1;
		log.info(icedqUser);
		try {

			if(xparam.getUserName().contains(",")) {

				iceuserName= xparam.getUserName().split(","); 

				numberOfUsers = iceuserName.length;

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, iceuserName[i]);

					flag=searchFunctionalityMethod(driver, flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, param.getUserName());

					selectUserCheckbox(flag, param.getUserName());

					searchFunctionalityMethod(driver, flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, "");

				}

			}else {

				numberOfUsers = 1;

				DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, xparam.getUserName());

				flag=searchFunctionalityMethod(driver, flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, param.getUserName());

				selectUserCheckbox(flag, param.getUserName());


			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			searchFunctionalityMethod(driver,true, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, "");

			flag=clickOnUnBlockUsersAndValidateToast(flag, numberOfUsers);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" unblockUserValid "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean unblockUserCheckForValidScenario(DataTestingParameters xparam, String userStatus, String icedqUser) {
		boolean flag =true;

		try {

			unblockUserValid(xparam, icedqUser);

			validateBlockUserValid(xparam, userStatus);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" unblockUserCheckForValidScenario "+e.toString());
			flag =false;
		}

		return flag;
	}


	public boolean deleteUserValid(DataTestingParameters xparam, String icedqUser) {
		String[] iceuserName=null;
		boolean flag =true;
		int numberOfUsers=1;
		log.info(icedqUser);
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			if(xparam.getUserName().contains(",")) {

				iceuserName= xparam.getUserName().split(","); 

				numberOfUsers = iceuserName.length;

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, iceuserName[i]);

					flag=searchFunctionalityMethod(driver, flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, param.getUserName());

					selectUserCheckbox(flag, param.getUserName());

					searchFunctionalityMethod(driver, flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, "");

				}

			}else {

				numberOfUsers = 1;

				DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, xparam.getUserName());

				flag=searchFunctionalityMethod(driver, flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, param.getUserName());

				selectUserCheckbox(flag, param.getUserName());


			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			searchFunctionalityMethod(driver,true, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, "");

			flag=clickOnButton(driver, usersListingDeleteIcon, deleteContent, true);

			flag=clickOnDeleteUsersAndValidateToast(flag, numberOfUsers);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" deleteUserValid "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean validateDeletedUserValid(DataTestingParameters xparam) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(xparam.getUserName().contains(",")) {

				iceuserName= xparam.getUserName().split(","); 

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, iceuserName[i]);

					flag=searchFunctionalityMethod(driver,flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, param.getUserName());

					if(flag && elementNotVisible(driver, returnElement(usersListingFullNameByName, dynamicName, param.getUserName()))) {

						BaseSuite.validationReportLog(param.getUserName()+" User Not visible on listing.");
					}else {
						BaseSuite.reportFailLog(param.getUserName()+" User is visible on listing.", "validateDeletedUserValid");
					}

					clickOnRefreshOnUsersListingPage("");
				}

			}else {

				DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, xparam.getUserName());

				flag=searchFunctionalityMethod(driver,flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, param.getUserName());

				if(flag && elementNotVisible(driver, returnElement(usersListingFullNameByName, dynamicName, param.getUserName()))) {

					BaseSuite.validationReportLog(param.getUserName()+" User Not visible on listing.");
				}else {
					BaseSuite.reportFailLog(param.getUserName()+" User is visible on listing.", "validateDeletedUserValid");
				}

				clickOnRefreshOnUsersListingPage("");
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateDeletedUserValid "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean deleteUserCheckForValidScenario(DataTestingParameters xparam, String icedqUser) {
		boolean flag =true;

		try {

			deleteUserValid(xparam, icedqUser);

			flag=validateDeletedUserValid(xparam);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" deleteUserCheckForValidScenario "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean deleteUserFromDetailsPageForValidScenario(DataTestingParameters xparam, String icedqUser) {
		boolean flag =true;
		log.info(icedqUser);
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=clickOnButton(driver, usersDetailsDeleteButton, deleteContent, true);

			clickOnDeleteUsersAndValidateToast(flag, 1);

			flag=validateDeletedUserValid(xparam);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" deleteUserFromDetailsPageForValidScenario "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean validateRefreshFunctionality(String userName) {
		boolean flag =true;

		try {

			searchFunctionalityMethod(driver,flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser,userName);

			validateUsersListingPage();

			clickOnRefreshOnUsersListingPage("");

			validateUsersListingPage();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateRefreshFunctionality "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean assignAdminAccessToUserFunctionality(DataTestingParameters xparam, String icedqUser) {

		boolean flag=true;
		log.info(icedqUser);
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=clickOnButton(driver, usersDetailsAdminAccessButton, assignAdminAccessContent, true);

			if (flag) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				validateElement(driver,usersDetailsAdminAccessIcon, adminContent, iconContent);

				verifyVisibilityOfButtons(driver, usersDetailsRevokeAdminAccessButton, revokeAdminAccessContent, true);

				DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, xparam.getUserName());

				if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateUserDetailPageAfterNewCreated(param, false);}

				clickOnUsersTab();

				flag=searchFunctionalityMethod(driver,flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, param.getUserName());

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(flag) {

					validateUserDetailsOnListingPage(param, activeContent, true);		
				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" assignAdminAccessToUserFunctionality :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean revokeAdminAccessToUserFunctionality(DataTestingParameters xparam, String icedqUser) {

		boolean flag=true;
		log.info(icedqUser);
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=clickOnButton(driver, usersDetailsRevokeAdminAccessButton, revokeAdminAccessContent, true);

			if (flag) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				validateElementVisibility(driver,usersDetailsAdminAccessIcon, adminContent, iconContent, false);

				verifyVisibilityOfButtons(driver, usersDetailsAdminAccessButton, adminContent, true);

				DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, xparam.getUserName());

				if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateUserDetailPageAfterNewCreated(param, false);}

				clickOnUsersTab();

				flag=searchFunctionalityMethod(driver,flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, param.getUserName());

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(flag) {

					validateUserDetailsOnListingPage(param, activeContent, false);		
				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" revokeAdminAccessToUserFunctionality :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean discardUserFunctionalityWhileCreating(DataTestingParameters xparam, String icedqUser) {
		boolean flag =true;
		boolean uicheck=!BaseSuite.suiteType.equalsIgnoreCase(sanity) ;
		try {

			flag=clickOnNewUserButton(icedqUser);

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

				DataTestingParameters param = setUpdateUsersParamUsingExcel(uSEREXCELFILEPATH, xparam.getUserName());
				if(uicheck) {
					validateUserDetailPageBeforeCreating(true);
				}
				validatAndeEnterValueToTextField(driver, userDetailsUserNameTitle, userDetailsUserNameField, userDetailsUserNameValidation, labelUserName, placeholderEnterUserName, param.getUserName(), "");
				validatAndeEnterValueToTextField(driver, userDetailsEmailTitle, userDetailsEmailField, userDetailsEmailValidation, labelEmail, placeholderEnterEmail, param.getEmail(), "");
				validatAndeEnterValueToTextField(driver, userDetailsFirstNameTitle, userDetailsFirstNameField, userDetailsFirstNameValidation, labelFirstName, placeholderEnterFirstName, param.getFirstName(), "");
				validatAndeEnterValueToTextField(driver, userDetailsLastNameTitle, userDetailsLastNameField, userDetailsLastNameValidation, labelLastName, placeholderEnterLastName, param.getLastName(), "");
				validatAndeEnterValueToTextField(driver, userDetailsPasswordTitle, userDetailsPasswordField, userDetailsPasswordValidation, labelPassword, placeholderEnterPassword, param.getPassword(), "");
				validatAndeEnterValueToTextField(driver, userDetailsConfirmPasswordTitle, userDetailsConfirmPasswordField, userDetailsConfirmPasswordValidation, placeholderConfirmPassword, placeholderConfirmPassword, param.getConfirmPassword(), "");

				verifyVisibilityOfButtons(driver, usersDetailsSaveButton, saveContent, true);

				clickOnButton(driver, usersDetailsDiscardButton, discardContent, true);

				flag=clickOnDiscardUsersAndValidateToast(flag, "");

				validateUserDetailPageBeforeCreating(false);

				clickOnUsersTab();

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" discardUserFunctionalityWhileCreating :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean discardUserFunctionalityWhileUpdating(DataTestingParameters xparam, String icedqUser) {
		boolean flag =true;
		boolean uicheck=!BaseSuite.suiteType.equalsIgnoreCase(sanity) ;
		try {

		/**	flag=clickOnNewUserButton(icedqUser);*/

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

				DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, xparam.getUserName());
				DataTestingParameters upparam = setUpdateUsersParamUsingExcel(uSEREXCELFILEPATH, xparam.getUserName());
				if(uicheck) {
					validateUserDetailPageAfterNewCreated(param, false);
				}
				validatAndeEnterValueToTextField(driver, userDetailsEmailTitle, userDetailsEmailField, userDetailsEmailValidation, labelEmail, placeholderEnterEmail, upparam.getEmail(), "");
				validatAndeEnterValueToTextField(driver, userDetailsFirstNameTitle, userDetailsFirstNameField, userDetailsFirstNameValidation, labelFirstName, placeholderEnterFirstName, upparam.getFirstName(), "");
				validatAndeEnterValueToTextField(driver, userDetailsLastNameTitle, userDetailsLastNameField, userDetailsLastNameValidation, labelLastName, placeholderEnterLastName, upparam.getLastName(), "");
				validatAndeEnterValueToTextField(driver, userDetailsPasswordTitle, userDetailsPasswordField, userDetailsPasswordValidation, labelPassword, placeholderEnterPassword, upparam.getPassword(), "");
				validatAndeEnterValueToTextField(driver, userDetailsConfirmPasswordTitle, userDetailsConfirmPasswordField, userDetailsConfirmPasswordValidation, placeholderConfirmPassword, placeholderConfirmPassword, upparam.getConfirmPassword(), "");

				verifyVisibilityOfButtons(driver, usersDetailsSaveButton, saveContent, true);

				clickOnButton(driver, usersDetailsDiscardButton, discardContent, true);

				flag=clickOnDiscardUsersAndValidateToast(flag, "");

				validateUserDetailPageAfterNewCreated(param, false);

				clickOnUsersTab();

				flag=searchFunctionalityMethod(driver,flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, param.getUserName());

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(flag) {

					validateUserDetailsOnListingPage(param, activeContent, false);		
				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" discardUserFunctionalityWhileUpdating :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean validateAssignGroupsSidebarOnUserDetailsPage() {
		boolean flag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateElement(driver, userDetailsGroupAssignSidebarTitle, "Assign Groups", attributeTitle);

			validateElement(driver, userDetailsGroupAssignSidebarCross, discardContent, iconContent);

			validateElementVisibility(driver,userDetailsGroupAssignSidebarLabel, "Groups", labelContent, true);

			verifySearchField(driver,userDetailsGroupAssignSidebarField, placeholderSelectGroups,
					placeholderSelectGroups);

			verifyVisibilityOfButtons(driver,userDetailsGroupAssignSidebarAssignButton, assignContent, false);

			verifyVisibilityOfButtons(driver,userDetailsGroupAssignSidebarCancelButton, cancelButtonContent,true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateAssignGroupsSidebarOnUserDetailsPage "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean assignGroupToUser(String groupName) {

		boolean flag=true;
		try {

			BaseSuite.reportLog("Clicking on select group field");

			displayAndClick(driver, userDetailsGroupAssignSidebarField);

			waitForExecution(1000);

			BaseSuite.reportLog("Clicked on select group field");

			BaseSuite.reportLog("Entering group name "+groupName);

			sendKeys(driver, userDetailsGroupAssignSidebarField, groupName);

			BaseSuite.reportLog("Entered group name "+groupName);

			BaseSuite.reportLog("Clicking on searched group "+groupName+" from drop down");

			isDisplayedInLoop(driver, 2, returnElement(usersDetailsSidebarSelectGroup, dynamicName, groupName));

			if(isDisplayed(driver, returnElement(usersDetailsSidebarSelectGroup, dynamicName, groupName))) {

				displayAndClick(driver, returnElement(usersDetailsSidebarSelectGroup, dynamicName, groupName));

				waitForExecution(1000);

				BaseSuite.reportLog("Clicked on searched group "+groupName+" from drop down");

			}else {

				BaseSuite.reportFailLog("searched group not visible kindly check "+groupName, "assignGroupToUser");

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" assignGroupToUser "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean assignGroupAccessToUser(String groupName, String icedqUser) {

		String[] iceuserName=null;
		boolean flag=true;

		try {

			if (icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

				clickOnButton(driver, userDetailsAssignGroupButton, assignContent, true);

				validateAssignGroupsSidebarOnUserDetailsPage();

				if(groupName.contains(",")) {

					iceuserName= groupName.split(","); 

					for(int i=0;i<iceuserName.length;i++) {

						BaseSuite.reportLog(hyphenContent+" Assigning "+(i+1)+" group access to user : "+ iceuserName[i]+hyphenContent );

						DataTestingParameters param=setGroupParamUsingExcel(uSEREXCELFILEPATH, iceuserName[i]);

						flag=assignGroupToUser(param.getGroupName());
					}

				}else {

					BaseSuite.reportLog(hyphenContent+" Assigning 1 group access to user : "+ groupName+hyphenContent );

					DataTestingParameters param=setGroupParamUsingExcel(uSEREXCELFILEPATH, groupName);

					flag=assignGroupToUser(param.getGroupName());
				}

				clickOnButton(driver, userDetailsGroupAssignSidebarAssignButton, assignContent, true);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" assignGroupAccessToUser "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean assignGroupToUserAndValidate(DataTestingParameters xparam, String icedqUser) {
		boolean flag=true;

		try {
			assignGroupAccessToUser(xparam.getGroupName(), icedqUser);

			readUserValid(xparam, icedqUser, !BaseSuite.suiteType.equalsIgnoreCase(sanity));

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" assignGroupToUserAndValidate "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean deleteUserFromGroups(String groupName) {
		String[] iceuserName=null;
		boolean flag=true;
		int numberOfUsers=1;
		try {

			if(groupName.contains(",")) {

				iceuserName= groupName.split(","); 

				numberOfUsers = iceuserName.length;

				for(int i=0;i<iceuserName.length;i++) {

					BaseSuite.reportLog(hyphenContent+" Selecting "+(i+1)+" group : "+ iceuserName[i]+hyphenContent );

					DataTestingParameters param=setGroupParamUsingExcel(uSEREXCELFILEPATH, iceuserName[i]);

					searchFunctionalityMethod(driver, true, userDetailsSearchGroupField, userDetailsSearchGroupButton, placeholderSearchGroup, placeholderSearchGroup, param.getGroupName());

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					selectGroupCheckbox(flag, param.getGroupName());

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					searchFunctionalityMethod(driver, flag, userDetailsSearchGroupField, userDetailsSearchGroupButton, placeholderSearchGroup, placeholderSearchGroup, "");

				}

			}else {

				numberOfUsers = 1;

				BaseSuite.reportLog(hyphenContent+" Selecting 1 group : "+ groupName+hyphenContent );

				DataTestingParameters param=setGroupParamUsingExcel(uSEREXCELFILEPATH, groupName);

				searchFunctionalityMethod(driver, true, userDetailsSearchGroupField, userDetailsSearchGroupButton, placeholderSearchGroup, placeholderSearchGroup,  param.getGroupName());

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				selectGroupCheckbox(flag, param.getGroupName());

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				searchFunctionalityMethod(driver, flag, userDetailsSearchGroupField, userDetailsSearchGroupButton, placeholderSearchGroup, placeholderSearchGroup, "");

			}

			clickOnButton(driver, userDetailsDeleteGroup, groupContent+" "+deleteContent, true);

			clickOnDeleteUsersFromGroupAndValidateToast(flag, numberOfUsers);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" deleteUserFromGroups "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateDeletedUserFromGroups(String groupName) {
		String[] iceuserName=null;
		boolean flag=true;
		try {

			if(groupName.contains(",")) {

				iceuserName= groupName.split(","); 

				for(int i=0;i<iceuserName.length;i++) {

					BaseSuite.reportLog(hyphenContent+" Selecting "+(i+1)+" group : "+ iceuserName[i]+hyphenContent );

					DataTestingParameters param=setGroupParamUsingExcel(uSEREXCELFILEPATH, iceuserName[i]);

					searchFunctionalityMethod(driver, true, userDetailsSearchGroupField, userDetailsSearchGroupButton, placeholderSearchGroup, placeholderSearchGroup, param.getGroupName());

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					if(elementNotVisible(driver, returnElement(userDetailsGroupNameDynamic, dynamicName, param.getGroupName()))) {
						BaseSuite.validationReportLog("Successfully deleted user from group: "+param.getGroupName());
					}else {
						BaseSuite.reportFailLog("deleted user from group: "+param.getGroupName()+" is visible","validateDeletedUserFromGroups");
					}

				}

			}else {

				BaseSuite.reportLog(hyphenContent+" Selecting 1 group : "+ groupName+hyphenContent );

				DataTestingParameters param=setGroupParamUsingExcel(uSEREXCELFILEPATH, groupName);

				searchFunctionalityMethod(driver, true, userDetailsSearchGroupField, userDetailsSearchGroupButton, placeholderSearchGroup, placeholderSearchGroup,  param.getGroupName());

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(elementNotVisible(driver, returnElement(userDetailsGroupNameDynamic, dynamicName, param.getGroupName()))) {

					BaseSuite.validationReportLog("Successfully deleted user from group: "+param.getGroupName());

				}else {

					BaseSuite.reportFailLog("deleted user from group: "+param.getGroupName()+" is visible","validateDeletedUserFromGroups");
				}

			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateDeletedUserFromGroups "+e.toString());
			flag=false;
		}

		return flag;
	}


	public boolean deleteUserFromGroupsAndValidate(DataTestingParameters xparam) {
		boolean flag=true;

		try {
			deleteUserFromGroups(xparam.getGroupName());

			validateDeletedUserFromGroups(xparam.getGroupName());

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" assignGroupToUserAndValidate "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateRefreshFunctionalityOnUserDetailsPage() {

		boolean flag=true;
		String searchValue="abc";
		try {

			searchFunctionalityMethod(driver, true, userDetailsSearchGroupField, userDetailsSearchGroupButton, placeholderSearchGroup, placeholderSearchGroup,  searchValue);

			getPaginationDetails(driver,userDetailsGroupsPaginationMsg, userDetailsGroupsPaginationBar,userDetailsGroupNoRecordsToDisplay, groupsContent+" "+tabContent);

			clickOnButton(driver, userDetailsRefreshGroups, groupContent+" "+refreshContent, true);

			getPaginationDetails(driver,userDetailsGroupsPaginationMsg, userDetailsGroupsPaginationBar,userDetailsGroupNoRecordsToDisplay, groupsContent+" "+tabContent);

			clickOnAccountsTabUserDetails();

			searchFunctionalityMethod(driver, true, groupDetailsSearchAccountField, groupDetailsSearchAccountButton, placeholderSearchAccount, placeholderSearchAccount, searchValue);

			getPaginationDetails(driver, groupDetailsAccountsPaginationMsg, groupDetailsAccountsPaginationBar, groupDetailsAccountNoRecordsToDisplay, accountsContent+" "+tabContent);

			clickOnButton(driver, groupDetailsRefreshAccounts, accountsContent+" "+refreshContent, true);

			getPaginationDetails(driver, groupDetailsAccountsPaginationMsg, groupDetailsAccountsPaginationBar, groupDetailsAccountNoRecordsToDisplay, accountsContent+" "+tabContent);

			clickOnWorkspacesTabUserDetails();

			searchFunctionalityMethod(driver, true, groupDetailsSearchWorkspaceField, groupDetailsSearchWorkspaceButton, placeholderSearchWorkspace, placeholderSearchWorkspace, searchValue);

			getPaginationDetails(driver, groupDetailsWorkspacesPaginationMsg, groupDetailsWorkspacesPaginationBar, groupDetailsWorkspaceNoRecordsToDisplay, workspacesContent+" "+tabContent);

			clickOnButton(driver, groupDetailsRefreshWorkspaces, workspacesContent+" "+refreshContent, true);

			getPaginationDetails(driver, groupDetailsWorkspacesPaginationMsg, groupDetailsWorkspacesPaginationBar, groupDetailsWorkspaceNoRecordsToDisplay, workspacesContent+" "+tabContent);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateRefreshFunctionalityOnUserDetailsPage "+e.toString());
			flag=false;
		}

		return flag;
	}

	public void navigateToAdministrationTabs(By linklocator, By validateLocator, String label, String type) {

		navigateToLink(driver,linklocator, validateLocator, label+" "+type);

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		clickOnUsersTab();

	}

	public boolean validateNavigationFunctionalityForUsers(String groupName, String icedqUser) {

		boolean flag =true;
		HomePage hp=new HomePage(driver);
		try {

			navigateToAdministrationTabs(nextgenSubModuleGroups,returnElement(subModuleHeadingName, dynamicName, groupsContent), groupsContent, subModuleContent);

			navigateToAdministrationTabs(nextgenSubModuleRoles,returnElement(subModuleHeadingName, dynamicName, rolesContent), rolesContent, subModuleContent);

			navigateToAdministrationTabs(nextgenSubModuleAccounts,returnElement(subModuleHeadingName, dynamicName, accountsContent), accountsContent, subModuleContent);

			navigateToAdministrationTabs(nextgenSubModuleWorkspaces,returnElement(subModuleHeadingName, dynamicName, workspacesContent), workspacesContent, subModuleContent);
		
			clickOnNewUserButton(icedqUser);

			navigateToLink(driver, breadcrumbUsersLink, returnElement(subModuleHeadingName, dynamicName,usersContent), usersContent+" "+breadcrumbContent);

			clickOnNewUserButton(icedqUser);

			navigateToLink(driver, breadcrumbAdministrationLink, returnElement(subModuleHeadingName, dynamicName, usersContent), administrationContent+" "+breadcrumbContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnUsersTab();

			clickOnNewUserButton(icedqUser);

			clickOnButton(driver, breadcrumbHomeLink, homeContent+" "+breadcrumbContent, true);

			hp.clickOnAdministrationTab();

			clickOnUsersTab();

			navigateToBreadcrumb(groupName);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateNavigationFunctionalityForUsers :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public void navigateToBreadcrumb(String userName) {

		HomePage hp=new HomePage(driver);

		try {

			BaseSuite.reportLog("-------------- Navigate functionality check on Users details page ---------------");

			searchUserAndClickOnUserName(userName);

			navigateToLink(driver,breadcrumbUsers, returnElement(subModuleHeadingName, dynamicName, usersContent), usersContent+" "+breadcrumbContent);

			searchUserAndClickOnUserName(userName);

			navigateToLink(driver,breadcrumbAdministrationLink, returnElement(subModuleHeadingName, dynamicName, usersContent), administrationContent+" "+breadcrumbContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnUsersTab();

			searchUserAndClickOnUserName(userName);

			clickOnButton(driver, breadcrumbHomeLink, homeContent+" "+breadcrumbContent, true);

			hp.clickOnAdministrationTab();

			clickOnUsersTab();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" navigateToBreadcrumb :: "+e.toString());

		}
	}

	public boolean validateUserFieldsForInvalidData(DataTestingParameters param, String scenarioType,DataTestingParameters xparam, boolean isCreate) {
		boolean flag=true;
		boolean saveflag=true;
		try {
			switch(scenarioType.toLowerCase()) {

			case "username":
				flag=enterValueToFieldForInvalidDetails(driver, userDetailsUserNameField, userDetailsUserNameValidation, labelUserName, param.getUserName(), xparam.getFieldValidationMessage());
				saveflag=false;
				break;

			case "email":
				flag=enterValueToFieldForInvalidDetails(driver, userDetailsEmailField, userDetailsEmailValidation, labelEmail, param.getEmail(), xparam.getFieldValidationMessage());
				saveflag=false;
				break;

			case "firstname":
				flag=enterValueToFieldForInvalidDetails(driver, userDetailsFirstNameField, userDetailsFirstNameValidation, labelFirstName, param.getFirstName(), xparam.getFieldValidationMessage());
				saveflag=false;
				break;

			case "lastname":
				flag=enterValueToFieldForInvalidDetails(driver, userDetailsLastNameField, userDetailsLastNameValidation, labelLastName, param.getLastName(), xparam.getFieldValidationMessage());
				saveflag=false;
				break;

			case "password":
				flag=enterValueToFieldForInvalidDetails(driver, userDetailsPasswordField, userDetailsPasswordValidation, labelPassword, param.getPassword(), xparam.getFieldValidationMessage());
				saveflag=false;
				break;

			case "confirmpassword":
				flag=enterValueToFieldForInvalidDetails(driver, userDetailsConfirmPasswordField, userDetailsConfirmPasswordValidation, labelConfirmPassword, param.getConfirmPassword(), xparam.getFieldValidationMessage());
				saveflag=false;
				break;

			case "existingusername":
				if(isCreate) {
					validatAndeEnterValueToTextField(driver, userDetailsUserNameTitle, userDetailsUserNameField, userDetailsUserNameValidation, labelUserName, placeholderEnterUserName, param.getUserName(), "");
				}
				validatAndeEnterValueToTextField(driver, userDetailsEmailTitle, userDetailsEmailField, userDetailsEmailValidation, labelEmail, placeholderEnterEmail, param.getEmail(), "");
				validatAndeEnterValueToTextField(driver, userDetailsFirstNameTitle, userDetailsFirstNameField, userDetailsFirstNameValidation, labelFirstName, placeholderEnterFirstName, param.getFirstName(), "");
				validatAndeEnterValueToTextField(driver, userDetailsLastNameTitle, userDetailsLastNameField, userDetailsLastNameValidation, labelLastName, placeholderEnterLastName, param.getLastName(), "");
				if(isCreate) {
					validatAndeEnterValueToTextField(driver, userDetailsPasswordTitle, userDetailsPasswordField, userDetailsPasswordValidation, labelPassword, placeholderEnterPassword, param.getPassword(), "");
					validatAndeEnterValueToTextField(driver, userDetailsConfirmPasswordTitle, userDetailsConfirmPasswordField, userDetailsConfirmPasswordValidation, placeholderConfirmPassword, placeholderConfirmPassword, param.getConfirmPassword(), "");
				}
				verifyVisibilityOfButtons(driver, usersDetailsSaveButton, saveContent, true);
				verifyVisibilityOfButtons(driver, usersDetailsDiscardButton, discardContent, true);

				flag=clickOnSaveButtonAndValidateToast(flag, "Username '"+param.getUserName()+"' already exists.");


				break;

			case "existingemail":
				if(isCreate) {
					validatAndeEnterValueToTextField(driver, userDetailsUserNameTitle, userDetailsUserNameField, userDetailsUserNameValidation, labelUserName, placeholderEnterUserName, param.getUserName(), "");
				}
				validatAndeEnterValueToTextField(driver, userDetailsEmailTitle, userDetailsEmailField, userDetailsEmailValidation, labelEmail, placeholderEnterEmail, param.getEmail(), "");
				validatAndeEnterValueToTextField(driver, userDetailsFirstNameTitle, userDetailsFirstNameField, userDetailsFirstNameValidation, labelFirstName, placeholderEnterFirstName, param.getFirstName(), "");
				validatAndeEnterValueToTextField(driver, userDetailsLastNameTitle, userDetailsLastNameField, userDetailsLastNameValidation, labelLastName, placeholderEnterLastName, param.getLastName(), "");
				if(isCreate) {
					validatAndeEnterValueToTextField(driver, userDetailsPasswordTitle, userDetailsPasswordField, userDetailsPasswordValidation, labelPassword, placeholderEnterPassword, param.getPassword(), "");
					validatAndeEnterValueToTextField(driver, userDetailsConfirmPasswordTitle, userDetailsConfirmPasswordField, userDetailsConfirmPasswordValidation, placeholderConfirmPassword, placeholderConfirmPassword, param.getConfirmPassword(), "");
				}
				verifyVisibilityOfButtons(driver, usersDetailsSaveButton, saveContent, true);
				verifyVisibilityOfButtons(driver, usersDetailsDiscardButton, discardContent, true);

				flag=clickOnSaveButtonAndValidateToast(flag, "User email id '"+param.getEmail()+"' already exists.");

				break;

			default: 

				break;

			}

			verifyVisibilityOfButtons(driver, usersDetailsSaveButton, saveContent, saveflag);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateUserFieldsForInvalidData :: "+e.toString());
			flag=false;
		}

		return flag;
	}




	public boolean createUserUsingInvalidData(DataTestingParameters xparam,String scenarioType, String icedqUser) {
		boolean flag=true;
		String[] iceuserName=null;


		try {

			flag=clickOnNewUserButton(icedqUser);

			if (flag && !xparam.getUserName().isEmpty()) {

				if (xparam.getUserName().contains(",")) {

					iceuserName = xparam.getUserName().split(",");

					for (int i = 0; i < iceuserName.length; i++) {

						DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, iceuserName[i]);

						flag = validateUserFieldsForInvalidData(param, scenarioType, xparam,true);

					}

				} else {

					DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, xparam.getUserName());

					flag = validateUserFieldsForInvalidData(param, scenarioType, xparam,true);

				} 
			}

			clickOnUsersTab();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" createUserUsingInvalidData :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean updateUserUsingInvalidData(DataTestingParameters xparam,String scenarioType, String icedqUser) {
		boolean flag=true;
		String[] iceuserName=null;

		log.info(icedqUser);
		try {

			if (!xparam.getUserName().isEmpty()) {

				if (xparam.getUserName().contains(",")) {

					iceuserName = xparam.getUserName().split(",");

					for (int i = 0; i < iceuserName.length; i++) {

						DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, iceuserName[i]);

						flag = validateUserFieldsForInvalidData(param, scenarioType, xparam,false);

					}

				} else {

					DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, xparam.getUserName());

					flag = validateUserFieldsForInvalidData(param, scenarioType, xparam,false);

				} 
			}

			clickOnUsersTab();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" createUserUsingInvalidData :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean deleteUserValidForCleanup(DataTestingParameters xparam, String icedqUser) {
		String[] iceuserName=null;
		boolean flag =true;
		int numberOfUsers=1;
		log.info(icedqUser);
		try {

			if(xparam.getUserName().contains(",")) {

				iceuserName= xparam.getUserName().split(","); 

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, iceuserName[i]);

					flag=searchFunctionalityMethod(driver, flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, param.getUserName());

					isDisplayedInLoop(driver, 4, returnElement(usersListingUserNameDynamic, dynamicName, param.getUserName()));
					if(isDisplayed(driver, returnElement(usersListingUserNameDynamic, dynamicName, param.getUserName()))) {

						selectUserCheckbox(flag, param.getUserName());
					}

					if(isEnabled(driver, usersListingDeleteIcon)) {

						flag=clickOnButton(driver, usersListingDeleteIcon, deleteContent, true);

						flag=clickOnDeleteUsersAndValidateToast(flag, 1);
					}
					searchFunctionalityMethod(driver,true, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, "");
				}

			}else {

				numberOfUsers = 1;

				DataTestingParameters param = setUsersParamUsingExcel(uSEREXCELFILEPATH, xparam.getUserName());

				flag=searchFunctionalityMethod(driver, flag, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, param.getUserName());

				isDisplayedInLoop(driver, 4, returnElement(usersListingUserNameDynamic, dynamicName, param.getUserName()));
				if(isDisplayed(driver, returnElement(usersListingUserNameDynamic, dynamicName, param.getUserName()))) {

					selectUserCheckbox(flag, param.getUserName());
				}

				if(isEnabled(driver, usersListingDeleteIcon)) {

					flag=clickOnButton(driver, usersListingDeleteIcon, deleteContent, true);

					flag=clickOnDeleteUsersAndValidateToast(flag, numberOfUsers);
				}
				searchFunctionalityMethod(driver,true, usersListingSearchField, usersListingSearchButton, placeholderSearchUser, placeholderSearchUser, "");

			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" deleteUserValidForCleanup "+e.toString());
			flag =false;
		}

		return flag;

	}

}
