package nexgen.automation.framework.administration;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;
import nexgen.automation.pageclasses.otherpages.HomePage;
import nexgen.automation.pageclasses.otherpages.LoginPage;

public class Users extends PageUtil {
	WebDriver driver;

	public Users(WebDriver driver) {

		this.driver = driver;

	}

	static final Logger log = Logger.getLogger(Users.class);

	By AdministrationLabel = getElementLocator(prop.getProperty("LandingPage.AdministrationLabel"));
	By HomeLink = getElementLocator(prop.getProperty("Users.HomeLink"));
	By UsersLink = getElementLocator(prop.getProperty("Users.UserLink"));
	By AccountName = getElementLocator(prop.getProperty("Users.AccountName"));
	By Sidebar = getElementLocator(prop.getProperty("Users.Sidebar"));

	By usersMenu = getElementLocator(prop.getProperty("Users.UserMenu"));
	By vaultTab = getElementLocator(prop.getProperty("Admin.VaultTab"));
	By fieldsTab = getElementLocator(prop.getProperty("Admin.FieldsTab"));
	By groupsTab = getElementLocator(prop.getProperty("Admin.GroupsTab"));
	By rolesTab = getElementLocator(prop.getProperty("Admin.RolesTab"));
	By accountsTab = getElementLocator(prop.getProperty("Admin.AccountsTab"));
	By workspacesTab = getElementLocator(prop.getProperty("Admin.WorkspacesTab"));
	By federationsTab = getElementLocator(prop.getProperty("Admin.FederationsTab"));
	By emailTab = getElementLocator(prop.getProperty("Admin.EmailTab"));
	By userPopUp = getElementLocator(prop.getProperty("Admin.UserPopUp"));

	By dataTestingHamburger = getElementLocator(prop.getProperty("Admin.DataTestingHamburger"));
	By connectionHamburger = getElementLocator(prop.getProperty("Admin.ConnectionHamburger"));
	By adminHamburger = getElementLocator(prop.getProperty("Admin.AdminHamburger"));
	By dMOHamburger = getElementLocator(prop.getProperty("Admin.DMOHamburger"));
	By assetHamburger = getElementLocator(prop.getProperty("Admin.AssetHamburger"));
	By dashboardHamburger = getElementLocator(prop.getProperty("Admin.DashboardHamburger"));
	By ruleMonitoringHamburger = getElementLocator(prop.getProperty("Admin.RuleMonitoringHamburger"));
	By toolTip = getElementLocator(prop.getProperty("User.ToolTip"));
	By userHeader = getElementLocator(prop.getProperty("User.UserHeader"));

	By newUsersButton = getElementLocator(prop.getProperty("Users.NewUsersButton"));
	By RefreshHeader = getElementLocator(prop.getProperty("Users.RefreshHeader"));
	By BlockUserHeader = getElementLocator(prop.getProperty("Users.BlockUserHeader"));
	By DeleteUserHeader = getElementLocator(prop.getProperty("Users.DeleteUserHeader"));
	By DeleteUserHeaderYes = getElementLocator(prop.getProperty("Users.DeleteUserHeaderYes"));
	By SearchUser = getElementLocator(prop.getProperty("Users.SearchUsers"));
	By createNewUserTitle = getElementLocator(prop.getProperty("Admin.CreateNewUserTitle"));
	By fullNameHeader = getElementLocator(prop.getProperty("Users.FullNameHeader"));
	By userNameHeader = getElementLocator(prop.getProperty("Users.UserNameHeader"));
	By statusHeader = getElementLocator(prop.getProperty("Users.StatusHeader"));
	By emailHeader = getElementLocator(prop.getProperty("Users.EmailHeader"));
	By identityHeader = getElementLocator(prop.getProperty("Users.IdentityHeader"));

	By blockUserButton = getElementLocator(prop.getProperty("Admin.Users.BlockUserButton"));

	By GridDetailsFullName = getElementLocator(prop.getProperty("Users.GridDetails.FullName"));
	By GridDetailsUserName = getElementLocator(prop.getProperty("Users.GridDetails.UserName"));
	By GridDetailsStatus = getElementLocator(prop.getProperty("Users.GridDetails.Status"));
	By GridDetailsEmail = getElementLocator(prop.getProperty("Users.GridDetails.Email"));
	By GridDetailsSynced = getElementLocator(prop.getProperty("Users.GridDetails.Synced"));
	By GridDetailsIdentity = getElementLocator(prop.getProperty("Users.GridDetails.Identity"));
	By GridDetailsLastModified = getElementLocator(prop.getProperty("Users.GridDetails.LastModified"));

	By SidebarUsers = getElementLocator(prop.getProperty("Users.SideBar.User"));
	By SidebarGroups = getElementLocator(prop.getProperty("Users.SideBar.Groups"));
	By SidebarRoles = getElementLocator(prop.getProperty("Users.SideBar.Roles"));
	By SidebarAccounts = getElementLocator(prop.getProperty("Users.SideBar.Accounts"));
	By SidebarWorkspace = getElementLocator(prop.getProperty("Users.SideBar.Workspace"));
	By tempPassWord = getElementLocator(prop.getProperty("User.TempPassWord"));
	By statusToggle = getElementLocator(prop.getProperty("User.Status"));
	By toolbarAccounts = getElementLocator(prop.getProperty("Users.Toolbar.Accounts"));
	By toolbarGroups = getElementLocator(prop.getProperty("Users.Toolbar.Groups"));
	By toolbarWorkspace = getElementLocator(prop.getProperty("Users.Toolbar.Workspace"));
	By toolbarText = getElementLocator(prop.getProperty("Users.Toolbar.text"));
	By searchBarClear = getElementLocator(prop.getProperty("Users.SearchBarClear"));
	By groupSearchBarClear = getElementLocator(prop.getProperty("Users.GroupSearchBarClear"));
	By workspaceSearchBarClear = getElementLocator(prop.getProperty("Users.WorkspaceSearchBarClear"));
	By accountSearchBarClear = getElementLocator(prop.getProperty("Users.AccountSearchBarClear"));
	By groupSearchList = getElementLocator(prop.getProperty("Users.GroupSearchList"));
	By workspaceSearchList = getElementLocator(prop.getProperty("Users.WorkspaceSearchList"));
	By accountSearchList = getElementLocator(prop.getProperty("User.AccountNameList"));
	// User's Creation

	By pagelabel = getElementLocator(prop.getProperty("Admin.PageLabel"));
	By ClickonAdmin = getElementLocator(prop.getProperty("Admin.Administration"));
	By ClickonCreateuser = getElementLocator(prop.getProperty("Admin.CreateUserButton"));
	By ClickonDiscard = getElementLocator(prop.getProperty("Admin.Discard"));
	public By username = getElementLocator(prop.getProperty("Admin.Username"));
	public By email = getElementLocator(prop.getProperty("Admin.Email"));
	public By firstname = getElementLocator(prop.getProperty("Admin.FirstName"));
	public By lastname = getElementLocator(prop.getProperty("Admin.Lastname"));
	public By password = getElementLocator(prop.getProperty("Admin.Password"));
	public By confirmpassword = getElementLocator(prop.getProperty("Admin.ConfirmPassword"));
	By clickonsave = getElementLocator(prop.getProperty("Admin.SaveUser"));
	By DiscardUser = getElementLocator(prop.getProperty("Admin.DiscardUser"));

	By toggle1 = getElementLocator(prop.getProperty("Admin.ActiveTogglekey"));
	// By userCreatedMsg = getElementLocator(prop.getProperty("UserCreatedMsg"));
	// String userCreateText = prop.getProperty("UserCreateText");
	String userBlockText = prop.getProperty("UserBlockText");
	String toastRetriveMsg = prop.getProperty("ToastRetriveMsg");
	String toastUpdateMsg = prop.getProperty("UserUpdatedText");
	public String toastDeleteAzureADMsg = prop.getProperty("DeleteAzureAdUser");
	public String toastDeleteLocaluser = prop.getProperty("DeleteLocaluser");
	String searchBarPlaceHolder = prop.getProperty("User.SearchBarPlaceHolder");
	String accountSearchBarPlaceHolder = prop.getProperty("User.AccountSearchBarPlaceHolder");
	String groupSearchBarPlaceHolder = prop.getProperty("User.GroupSearchBarPlaceHolder");
	String workspaceSearchBarPlaceHolder = prop.getProperty("User.WorkspaceSearchBarPlaceHolder");
	By commonToastMsg = getElementLocator(prop.getProperty("ToastMsgGet"));
	By toastMsgClosedBtn1 = getElementLocator(prop.getProperty("ToastMsgClosedBtn1"));

	String actualTitle;
	String expectedTitle;

	// Search
	By SearchBar = getElementLocator(prop.getProperty("Admin.searchBar"));
	By SearchClick = getElementLocator(prop.getProperty("Admin.searchBarClick"));
	String searchList1 = prop.getProperty("Admin.searchData");
	String searchList = prop.getProperty("Admin.searchData");

	By searchListed = getElementLocator(prop.getProperty("Admin.searchData"));

	// Pagination search
	By PaginationNext = getElementLocator(prop.getProperty("Users.pagination"));
	By PaginationPre = getElementLocator(prop.getProperty("Users.Paginationpre"));
	By PaginationNumNext = getElementLocator(prop.getProperty("Users.PagninationnumNext"));
	By PaginationNumPre = getElementLocator(prop.getProperty("Users.PaginationnumPre"));
	By PaginationPageNext = getElementLocator(prop.getProperty("Users.PaginationpageNext"));
	By PaginationPageLast = getElementLocator(prop.getProperty("Users.PaginationpageLast"));

	By NumberOfUsers = getElementLocator(prop.getProperty("Users.NumberOfUsers"));
	By Pagination = getElementLocator(prop.getProperty("Users.pagination"));

	// Assigning Group

	By userGroupTab = getElementLocator(prop.getProperty("Users.GroupTab"));
	By userWrokspaceButton = getElementLocator(prop.getProperty("Users.UserWrokspaceButton"));
	By userAccountButton = getElementLocator(prop.getProperty("Users.UserAccountButton"));

	By userRefereshButtonInsideAssignPage = getElementLocator(
			prop.getProperty("Users.UserRefereshButtonInsideAssignPage"));
	By userAssignBtn = getElementLocator(prop.getProperty("Users.AssignBtn"));
	By UserAssignGroupsLabel = getElementLocator(prop.getProperty("Users.AssignGroupsLabel"));
	By addGroupTextBox = getElementLocator(prop.getProperty("Users.AddGroupTextbox"));
	By addGroupTexSendKey = getElementLocator(prop.getProperty("Users.AddGroupTexSendKey"));
	By refreshButtom = getElementLocator(prop.getProperty("User.RefreshButtom"));
	By groupRefreshButton = getElementLocator(prop.getProperty("User.GroupRefreshButton"));
	By accountRefreshButton = getElementLocator(prop.getProperty("User.AccountRefreshButton"));
	By workspaceRefreshButton = getElementLocator(prop.getProperty("User.WorkspaceRefreshButton"));
	By UsersAssignGroupBtn = getElementLocator(prop.getProperty("Users.AssignGroupBtn"));
	By UsersDiscardGroupBtn = getElementLocator(prop.getProperty("Users.DiscardGroupBtn"));
	By groupSearchNoRecord = getElementLocator(prop.getProperty("User.GroupSearchNoRecord"));

	By groupPaginationList = getElementLocator(prop.getProperty("User.GroupPaginationList"));
	By workspacePaginationList = getElementLocator(prop.getProperty("User.WorkspacePaginationList"));
	By AddedGroupDetails = getElementLocator(prop.getProperty("Users.AddedGroupDetails"));

	// Group Search for User

	By GrpSearchTextboxForUser = getElementLocator(prop.getProperty("Users.GrpSearchTextboxForUser"));
	By GrpSearchTextboxClickForUser = getElementLocator(prop.getProperty("Users.GrpSearchTextboxButtonForUser"));

	String GroupSearchData = prop.getProperty("User.GroupSearchData");
	public String SrUser = prop.getProperty("Group.GroupUser");
	public String SrUserGrp = prop.getProperty("Group.SearchGroup");

	By GroupSearchData1 = getElementLocator(prop.getProperty("Users.AddedGroupDetails"));

	// Delete user

	By GrpCheckbox = getElementLocator(prop.getProperty("User.GrpCheckbox"));
	By GrpRemoveBtnClick = getElementLocator(prop.getProperty("User.GrpRemoveBtnClick"));
	By GrpRemoveBtnClickYes = getElementLocator(prop.getProperty("User.GrpRemoveBtnClickYes"));
	By GrpRemoveBtnClickNo = getElementLocator(prop.getProperty("User.GrpRemoveBtnClickNo"));
	By GroupRemoveText = getElementLocator(prop.getProperty("GroupRemoveText"));
	String GroupRemovePopUp = prop.getProperty("SearchUserDetails");

	// Admin User page object

	By secureAdvanceButton = getElementLocator(prop.getProperty("secure.AdvanceButton"));
	By secureProceedtounsafe = getElementLocator(prop.getProperty("secure.Proceedtounsafe"));

	By DiscardAlert = getElementLocator(prop.getProperty("Admin.alertwindow"));
	By Toggle = getElementLocator(prop.getProperty("Admin.togglebutton"));
	By Toggle1 = getElementLocator(prop.getProperty("Admin.togglebutton1"));
	By Loadingtoast = getElementLocator(prop.getProperty("login.LoadingIcon"));
	By Usersclick = getElementLocator(prop.getProperty("Admin.UsersTab"));

	By namelable = getElementLocator(prop.getProperty("Admin.NameLable"));
	By deletebutton = getElementLocator(prop.getProperty("Admin.DeleteTab"));
	By searchbar = getElementLocator(prop.getProperty("Admin.searchBar"));
	By searchclick = getElementLocator(prop.getProperty("Admin.searchBarClick"));
	By deleteT = getElementLocator(prop.getProperty("Admin.DeleteTab"));
	By clickonpopup = getElementLocator(prop.getProperty("Admin.DeletePopup"));
	By Welcometitle = getElementLocator(prop.getProperty("Landingpage.Welcome"));
	By numberOfCount = getElementLocator(prop.getProperty("User.NumberOfCount"));

	By Blocklabel = getElementLocator(prop.getProperty("Users.BlockLabel"));
	By SelectCheckboxes = getElementLocator(prop.getProperty("Users.Checkboxes"));
	By BlockYes = getElementLocator(prop.getProperty("Users.Blockyes"));
	By SelectAllCheckboxes = getElementLocator(prop.getProperty("Users.CheckAllUser"));
	By DeleteAzureADButton = getElementLocator(prop.getProperty("Users.DeleteAzureADButton"));
	By ClickTempPass = getElementLocator(prop.getProperty("User.TempPassWord_No"));
	By SaveUserButton = getElementLocator(prop.getProperty("User.SaveuserButton"));
	By UpdateToastMess = getElementLocator(prop.getProperty("User.UpdateToastMess"));
	By DeleteUserToastMess = getElementLocator(prop.getProperty("User.DeleteUserToastMess"));
	By StatusToggleButton = getElementLocator(prop.getProperty("User.StatusActiveButton"));
	By StatusBlockTogButton = getElementLocator(prop.getProperty("User.StatusBlockedButton"));
	By StatusBlockedBtn = getElementLocator(prop.getProperty("User.StatusBlockedBtnBlock"));
	String searchdataclick = prop.getProperty("Admin.searchdata");
	By TempPassWord_No = getElementLocator(prop.getProperty("User.TempPassWord_No"));
	By TempPassWord_Yes = getElementLocator(prop.getProperty("User.TempPassWord_Yes"));
	By DiscardButton = getElementLocator(prop.getProperty("User.DiscardButton"));
	By discardAlertYes = getElementLocator(prop.getProperty("User.DiscardYesAlert"));
	By discardAlertNo = getElementLocator(prop.getProperty("User.DiscardNoAlert"));
	By discardMsg = getElementLocator(prop.getProperty("User.DiscardMsg"));
	By RetriverMsg = getElementLocator(prop.getProperty("User.UserDetailsRetriveMsg"));
	By WorkspaceLabel = getElementLocator(prop.getProperty("User.WorkspaceLabel"));
	By WorkspaceNameLabel = getElementLocator(prop.getProperty("User.WorkspaceNameLabel"));
	By WorkspaceRoleLabel = getElementLocator(prop.getProperty("User.WorkspaceRoleLabel"));
	By WorkspaceTypeLabel = getElementLocator(prop.getProperty("User.WorkspaceTypeLabel"));
	By WorkspaceAccountLabel = getElementLocator(prop.getProperty("User.WorkspaceAccountLabel"));
	By WorkspaceScopeLabel = getElementLocator(prop.getProperty("User.WorkspaceScopeLabel"));
	By WorkspaceNameList = getElementLocator(prop.getProperty("User.AssignedWorkspacesList"));
	By W_SearchBar = getElementLocator(prop.getProperty("W_SearchBar"));
	By W_SearchClick = getElementLocator(prop.getProperty("W_SearchiconButton"));

	By AccountLabel = getElementLocator(prop.getProperty("User.AccountLabel"));
	By AccountNameLabel = getElementLocator(prop.getProperty("User.AccountNameLabel"));
	By AccountRoleLabel = getElementLocator(prop.getProperty("User.AccountRoleLabel"));
	By AccountScopeLabel = getElementLocator(prop.getProperty("User.AccountScopeLabel"));
	By AccountNameList = getElementLocator(prop.getProperty("User.AssignedAccountList"));

	By GroupLabel = getElementLocator(prop.getProperty("User.GroupLabel"));
	By GroupNameLabel = getElementLocator(prop.getProperty("User.GroupNameLabel"));
	By GroupPathLabel = getElementLocator(prop.getProperty("User.GroupPathLabel"));
	By GroupNameList = getElementLocator(prop.getProperty("User.AssignedGroupList"));
	By G_SearchBar = getElementLocator(prop.getProperty("G_SearchBar"));
	By G_SearchClick = getElementLocator(prop.getProperty("G_SearchiconButton"));

	// Nehas locator

	By userSearchNameClicked = getElementLocator(prop.getProperty("User.UserSearchNameClicked"));
	By groupNameList = getElementLocator(prop.getProperty("User.GroupNameList"));
	By accountNameList = getElementLocator(prop.getProperty("User.AccountNameList"));
	By workspaceNameList = getElementLocator(prop.getProperty("User.WorkspaceNameList"));
	By userNameSearchClicked = getElementLocator(prop.getProperty("User.UserNameSearchClicked"));
	By emailSearchClicked = getElementLocator(prop.getProperty("User.EmailSearchClicked"));
	By userCheckboxAttribute = getElementLocator(prop.getProperty("User.UserCheckboxAttribute"));
	By goToLastPage = getElementLocator(prop.getProperty("User.GoToLastPage"));
	By goToFirstPage = getElementLocator(prop.getProperty("User.GoToFirstPage"));
	By workspaceGoToLastPagee = getElementLocator(prop.getProperty("User.WorkspaceGoToLastPagee"));
	By workspaceGoToFirstPagee = getElementLocator(prop.getProperty("User.WorkspaceGoToFirstPagee"));
	By pageNumber = getElementLocator(prop.getProperty("User.PageNumber"));
	By accountPageCount = getElementLocator(prop.getProperty("User.AccountPageCount"));
	By accountItemCount = getElementLocator(prop.getProperty("User.AccountItemCount"));
	By workspaceItemCount = getElementLocator(prop.getProperty("User.WorkspaceItemCount"));

	By itemCount = getElementLocator(prop.getProperty("User.ItemCount"));
	By previousPageArrow = getElementLocator(prop.getProperty("User.PreviousPageArrow"));
	By firstPageArrow = getElementLocator(prop.getProperty("User.FirstPageArrow"));
	By nextPageArrow = getElementLocator(prop.getProperty("User.NextPageArrow"));
	By lastPageArrow = getElementLocator(prop.getProperty("User.LastPageArrow"));
	By accountPreviousButton = getElementLocator(prop.getProperty("User.AccountPreviousButton"));
	By accountFirstPageButton = getElementLocator(prop.getProperty("User.AccountFirstPageButton"));
	By accountNextPageButton = getElementLocator(prop.getProperty("User.AccountNextPageButton"));
	By accountLastPageButton = getElementLocator(prop.getProperty("User.AccountLastPageButton"));
	By workspacePageCount = getElementLocator(prop.getProperty("User.WorkspacePageCount"));
	By workspacePreviousButton = getElementLocator(prop.getProperty("User.WorkspacePreviousButton"));
	By workspaceFirstButton = getElementLocator(prop.getProperty("User.WorkspaceFirstButton"));
	By workspaceNextButton = getElementLocator(prop.getProperty("User.WorkspaceNextButton"));
	By workspaceLastButton = getElementLocator(prop.getProperty("User.WorkspaceLastButton"));

	By userSaveButton = getElementLocator(prop.getProperty("User.Savebtn"));
	By userUsername = getElementLocator(prop.getProperty("User.Username"));
	By userEmail = getElementLocator(prop.getProperty("User.Email"));
	By userFirstname = getElementLocator(prop.getProperty("User.Firstname"));
	By userLastname = getElementLocator(prop.getProperty("User.LastName"));
	By userNameBreadCrumb = getElementLocator(prop.getProperty("Users.UserNameBreadCrumb"));
	By userGroupName = getElementLocator(prop.getProperty("Users.UserGroupName"));
	By userAccountName = getElementLocator(prop.getProperty("Users.UserAccountName"));
	By userWorkspaceName = getElementLocator(prop.getProperty("Users.UserWorkspaceName"));

	By userPassword = getElementLocator(prop.getProperty("User.Password"));
	By userCPassword = getElementLocator(prop.getProperty("User.CPassword"));
	public By discardButton = getElementLocator(prop.getProperty("User.DiscardBtn"));
	By assignAdminAccessButtonForSuperUser = getElementLocator(
			prop.getProperty("User.AssignAdminAccessButtonForSuperUser"));
	By userNameLogin = getElementLocator(prop.getProperty("Login.UserName"));
	By passWord = getElementLocator(prop.getProperty("Login.Password"));
	By signin = getElementLocator(prop.getProperty("Login.SubmitButton"));
	By UDiscardYesOpt = getElementLocator(prop.getProperty("User.DiscardYesOpt"));
	By UBlockBtn = getElementLocator(prop.getProperty("User.BlockBtn"));
	By USelectChk = getElementLocator(prop.getProperty("User.SelectionChk"));
	By UCountOfPages = getElementLocator(prop.getProperty("User.CountOfPages"));
	By deleteButton = getElementLocator(prop.getProperty("User.DeleteBtn"));
	By breadCrumb = getElementLocator(prop.getProperty("User.BreadCrumb"));
	By newPssword = getElementLocator(prop.getProperty("Login.NewPssword"));
	By confirmPssword = getElementLocator(prop.getProperty("Login.ConfirmPssword"));
	By sumitButton = getElementLocator(prop.getProperty("Login.SumitButton"));

	By adminBreadCrumb = getElementLocator(prop.getProperty("User.AdminBreadCrumb"));
	By usersBreadCrumb = getElementLocator(prop.getProperty("User.UsersBreadCrumb"));
	By createNewUserBreadCrum = getElementLocator(prop.getProperty("User.CreateNewUserBreadCrum"));
	By createNewUserHeadline = getElementLocator(prop.getProperty("User.CreateNewUserHeadline"));
	By createNewUserLeftArrow = getElementLocator(prop.getProperty("User.CreateNewUserLeftArrow"));
	By userIcon = getElementLocator(prop.getProperty("User.UserIcon"));
	By userNameHeading = getElementLocator(prop.getProperty("User.UserNameHeading"));

	By assignGroupPaneCancleButton = getElementLocator(prop.getProperty("Users.AssignGroupPaneCancleButton"));
	By assignGroupPaneAssignButton = getElementLocator(prop.getProperty("Users.AssignGroupPaneAssignButton"));
	By groupSearchBox = getElementLocator(prop.getProperty("User.GropSearchBox"));
	By groupSearchBar = getElementLocator(prop.getProperty("User.GropSearchBar"));
	By workspaceSearchBox = getElementLocator(prop.getProperty("User.WorkspaceSearchBox"));
	By workspaceSearchBar = getElementLocator(prop.getProperty("User.WorkspaceSearchBar"));
	By accountSearchBox = getElementLocator(prop.getProperty("User.AccountSearchBox"));
	By accountSearchBar = getElementLocator(prop.getProperty("User.AccountSearchBar"));
	By userSearchOnLisitingPage = getElementLocator(prop.getProperty("User.UserSearchOnLisitingPage"));
	By userSearchIconOnLisitingPage = getElementLocator(prop.getProperty("User.UserSearchIconOnLisitingPage"));
	By blockUserButtonOnListing = getElementLocator(prop.getProperty("Users.BlockUserButtonOnListing"));
	By unblockUserButtonOnListing = getElementLocator(prop.getProperty("Users.UnBlockUserButtonOnListing"));

	By deleteUserButtonOnListing = getElementLocator(prop.getProperty("Users.DeleteUserButtonOnListing"));
	By userListStatusCol = getElementLocator(prop.getProperty("User.UserListStatusCol"));
	By blockedUserLoginMess = getElementLocator(prop.getProperty("User.BlockedUserLoginMess"));

	By UpaginationLastBtn = getElementLocator(prop.getProperty("User.PagLastBtn"));
	By UpaginationNextBtn = getElementLocator(prop.getProperty("User.PagNextLbtn"));
	By UpaginationPreBtn = getElementLocator(prop.getProperty("User.PagPreBtn"));
	By UpaginationFirstBtn = getElementLocator(prop.getProperty("User.PagFirstbtn"));
	By UselectAllChk = getElementLocator(prop.getProperty("User.SelectAll"));
	By UCheckBoxToSelect = getElementLocator(prop.getProperty("User.CheckboxGrid"));
	By UselectAllChkF = getElementLocator(prop.getProperty("User.SelectAllFocus"));
	By UlabelPages = getElementLocator(prop.getProperty("User.LabelNoPages"));
	By UlabelTUser = getElementLocator(prop.getProperty("User.LabelTotalUser"));
	By selectAllCheckbox = getElementLocator(prop.getProperty("Roles.SelectAllCheckbox"));
	By singleCheckbox = getElementLocator(prop.getProperty("User.SingleCheckbox"));
	By assignAdminAccess = getElementLocator(prop.getProperty("User.AssignAdminAccess"));
	By groupCheckBoxClick = getElementLocator(prop.getProperty("User.GroupCheckBoxClick"));
	By visibilityOfCheckbox = getElementLocator(prop.getProperty("User.VisibilityOfCheckbox"));

	By userCheckBoxClick = getElementLocator(prop.getProperty("User.UserCheckBoxClick"));
	By gridGroupName = getElementLocator(prop.getProperty("User.GridGroupName"));
	By gridGroupPath = getElementLocator(prop.getProperty("User.GridGroupPath"));
	By groupRemoveButton = getElementLocator(prop.getProperty("User.GroupRemoveButton"));
	By groupRemovePopupBoxText = getElementLocator(prop.getProperty("User.GroupRemovePopupBoxText"));
	By userDiscardBox = getElementLocator(prop.getProperty("User.UserDiscardBox"));
	By gridAccountName = getElementLocator(prop.getProperty("User.GridAccountName"));
	By gridAccountRole = getElementLocator(prop.getProperty("User.GridAccountRole"));
	By gridAccountScope = getElementLocator(prop.getProperty("User.GridAccountScope"));
	By gridWorkspaceName = getElementLocator(prop.getProperty("User.GridWorkspaceName"));
	By gridWorkspaceRole = getElementLocator(prop.getProperty("User.GridWorkspaceRole"));
	By gridWorkspaceType = getElementLocator(prop.getProperty("User.GridWorkspaceType"));
	By gridWorkspaceScope = getElementLocator(prop.getProperty("User.GridWorkspaceScope"));

	By userListingPopupBox = getElementLocator(prop.getProperty("User.UserListingPopupBox"));
	By userListingPopupBoxTitleText = getElementLocator(prop.getProperty("User.UserListingPopupBoxTitleText"));
	By userListingPopupBoxContentTitleText = getElementLocator(
			prop.getProperty("User.UserListingPopupBoxContentTitleText"));
	By userDiscardHeaderText = getElementLocator(prop.getProperty("User.UserDiscardHeaderText"));
	By userDiscardContentText = getElementLocator(prop.getProperty("User.UserDiscardContentText"));
	public By userDiscardBtnClickYes = getElementLocator(prop.getProperty("User.UserDiscardBtnClickYes"));
	By userDiscardBtnClickCancel = getElementLocator(prop.getProperty("User.UserDiscardBtnClickCancel"));
	By userSearchBarClear = getElementLocator(prop.getProperty("User.UserSearchBarClear"));

	By deleteButtonListingPage = getElementLocator(prop.getProperty("User.DeleteButton"));
	By groupRemovePopupBoxTitle = getElementLocator(prop.getProperty("User.GroupRemovePopupBoxTitle"));
	By groupRemovePopupBoxCancelButton = getElementLocator(prop.getProperty("User.GroupRemovePopupBoxCancelButton"));
	By userBlockPopupBoxCancelButton = getElementLocator(prop.getProperty("User.UserBlockPopupBoxCancelButton"));
	By userBlockPopupBoxBlockButton = getElementLocator(prop.getProperty("User.UserBlockPopupBoxBlockButton"));

	By groupRemovePopupBoxDeleteButton = getElementLocator(prop.getProperty("User.GroupRemovePopupBoxDeleteButton"));
	By userRemovePopupBoxCancelButton = getElementLocator(prop.getProperty("User.UserRemovePopupBoxCancelButton"));
	By userDeletePopupBoxCancelButton = getElementLocator(prop.getProperty("User.UserDeletePopupBoxCancelButton"));

	By userRemovePopupBoxDeleteButton = getElementLocator(prop.getProperty("User.UserRemovePopupBoxDeleteButton"));
	By userDeletePopupBoxDeleteButton = getElementLocator(prop.getProperty("User.UserDeletePopupBoxDeleteButton"));
	By iCEDQLogo = getElementLocator(prop.getProperty("User.ICEDQLogo"));
	By administrationBreadCrumb = getElementLocator(prop.getProperty("User.AdministrationBreadCrumb"));

	By userDeletePopupBoxText = getElementLocator(prop.getProperty("User.UserDeletePopupBoxText"));
	By userDeletePopupBoxTitle = getElementLocator(prop.getProperty("User.UserDeletePopupBoxTitle"));
	By userBreadCrumb = getElementLocator(prop.getProperty("User.UserBreadCrumb"));
	public By homeBreadCrumb = getElementLocator(prop.getProperty("User.HomeBreadCrumb"));
	By userLabelOnLandingPage = getElementLocator(prop.getProperty("User.UserLabelOnLandingPage"));
	By passwordEyeIcon = getElementLocator(prop.getProperty("User.PasswordEyeIcon"));
	By confirmPasswordEyeIcon = getElementLocator(prop.getProperty("User.ConfirmPasswordEyeIcon"));
	// Discard User details
	public String Username = prop.getProperty("User.D_Username");
	public String Email11 = prop.getProperty("User.D_Email");
	public String FirstName = prop.getProperty("User.D_Firstname");
	public String LastName = prop.getProperty("User.D_Lastname");
	public String Password11 = prop.getProperty("User.D_Password");
	public String ConfirmPassword11 = prop.getProperty("User.D_ConfirmPass");
	public String TemporaryPass = prop.getProperty("User.D_TempPass");
	public String DiscaralertYes = prop.getProperty("User.D_DiscardAlert");
	public String User_search = prop.getProperty("User.D_SearchExistingUser");
	public String Workspace_search = prop.getProperty("W_SearchWorkspace");
	public String Account_search = prop.getProperty("A_SearchAccount");
	public String Group_search = prop.getProperty("G_SearchGroup");
	public String RetriveDetailsMsg = prop.getProperty("RetriveUserDetails");
	String groupDeletePopupHeader = prop.getProperty("User.GroupDeletePopupHeader");
	String groupDeletePopupTitle = prop.getProperty("User.GroupDeletePopupTitle");
	String userDeletePopupHeader = prop.getProperty("User.UserDeletePopupHeader");
	String userDeletePopupTitle = prop.getProperty("User.UserDeletePopupTitle");
	String userDeleteMessage = prop.getProperty("User.UserDeleteMessage");
	String blockUserPopupTitle = prop.getProperty("User.BlockUserPopupTitle");
	String discardChangesMessage = prop.getProperty("User.DiscardChangesMessage");
	String breadCrumbText = prop.getProperty("User.BreadCrumbText");
	String scrollToElementArg = prop.getProperty("ScrollToElementArgument");
	String blockUserPopupHeader = prop.getProperty("User.BlockUserPopupHeader");
	String blockUserMessage = prop.getProperty("User.BlockUserMessage");
	String unblockUserMessage = prop.getProperty("User.UnblockUserMessage");
	String userBlockedMessage = prop.getProperty("UserBlockedMessage");
	String discardPopupHeader = prop.getProperty("User.DiscardPopupHeader");
	String discardPopupTitle = prop.getProperty("User.DiscardPopupTitle");
	String genericInputBox = prop.getProperty("User.GenericInputBox");
	String dataTestingHamburgerText = prop.getProperty("Admin.DataTestingHamburgerText");
	String connectionsHamburgerText = prop.getProperty("Admin.ConnectionsHamburgerText");
	String administrationHamburgerText = prop.getProperty("Admin.AdministrationHamburgerText");
	String userTitle = prop.getProperty("User.UserTitle");
	String leftArrowToolTip = prop.getProperty("User.LeftArrowToolTip");
	String userIconTitle = prop.getProperty("User.UserIconTitle");
	String usernamePlaceHolder = prop.getProperty("User.UsernamePlaceHolder");
	String emailPlaceHolder = prop.getProperty("User.EmailPlaceHolder");
	String firstNamePlaceHolder = prop.getProperty("User.FirstNamePlaceHolder");
	String lastNamePlaceHolder = prop.getProperty("User.LastNamePlaceHolder");
	String passwordPlaceHolder = prop.getProperty("User.PasswordPlaceHolder");
	String confirmPasswordPlaceHolder = prop.getProperty("User.ConfirmPasswordPlaceHolder");
	String passwordIconTitle = prop.getProperty("User.PasswordIconTitle");
	String createNewUserToolTip = prop.getProperty("User.CreateNewUserToolTip");
	String userIconToolTip = prop.getProperty("User.UserIconToolTip");
	String passwordToolTip = prop.getProperty("User.PasswordToolTip");
	String userNameWithID = prop.getProperty("User.UserNameWithID");
	String searchUserName = prop.getProperty("User.SearchUserName");
	String loginPasswordLabel = prop.getProperty("User.LoginPasswordLabel");

	String userNameLable = prop.getProperty("User.UserNameLable");
	String emailLable = prop.getProperty("User.EmailLable");
	String firstNameLable = prop.getProperty("User.FirstNameLable");
	String lastNameLable = prop.getProperty("User.LastNameLable");
	String passwordLabel = prop.getProperty("User.PasswordLabel");
	String confirmPasswordLabel = prop.getProperty("User.ConfirmPasswordLabel");
	String label = prop.getProperty("User.Label");
	String userNameRequiredMess = prop.getProperty("UserNameRequiredMess");
	String userNameSpecailCharMess = prop.getProperty("UserNameSpecailCharMess");
	String emailNameRequiredMess = prop.getProperty("EmailNameRequiredMess");
	String emailInvalidSyntexMess = prop.getProperty("EmailInvalidSyntexMess");
	String lastNameRequired = prop.getProperty("LastNameRequired");
	String passwordRequired = prop.getProperty("PasswordRequired");
	String minimumEigthCharacter = prop.getProperty("MinimumEigthCharacter");
	String minimumEigthCharacterConfirmPassword = prop.getProperty("MinimumEigthCharacterConfirmPassword");
	String maxCharacterExceededLimit = prop.getProperty("MaxCharacterExceededLimit");
	String maximumCharacterLimitConfirmPassword = prop.getProperty("MaximumCharacterLimitConfirmPassword");
	public String userCreatedWithUserName = prop.getProperty("UserCreatedWithUserName");
	public String userCreatedWithEmailId = prop.getProperty("UserCreatedWithEmailId");
	String invalidGroupMess = prop.getProperty("InvalidGroupMess");

	String firstNameRequired = prop.getProperty("FirstNameRequired");
	String firstNameMaximumTwoCharMess = prop.getProperty("FirstNameMaximumTwoCharMess");
	String firstNameMaximumTwoCharMess1 = prop.getProperty("FirstNameMaximumTwoCharMess1");
	String firstNameMaximumTwoCharMess2 = prop.getProperty("FirstNameMaximumTwoCharMess2");

	// Blocked user as status Blocked without temp pass
	public String SearchBlockedUserTemp = prop.getProperty("BlockedUser");
	public String Username1 = prop.getProperty("User.B_Username");
	public String BlockEmail = prop.getProperty("User.B_Email");
	public String BlockFirstName = prop.getProperty("User.B_Firstname");
	public String BlockLastName = prop.getProperty("User.B_Lastname");
	public String BlockPassword = prop.getProperty("User.B_Password");
	public String BlockConfirmPassword = prop.getProperty("User.B_ConfirmPass");
	public String TemporaryPass1 = prop.getProperty("User.B_TempPass");
	public String BlockedStatus = prop.getProperty("User.B_StatusBlocked");
	public String Search_user1 = prop.getProperty("User.B_SearchNewUser");

	// Blocked user as status Blocked with temp pass
	public String SearchBlockedUserTemp2 = prop.getProperty("BlockedUser");
	public String Username2 = prop.getProperty("User.BWTP_Username");
	public String Email2 = prop.getProperty("User.BWTP_Email");
	public String FirstName2 = prop.getProperty("User.BWTP_Firstname");
	public String LastName2 = prop.getProperty("User.BWTP_Lastname");
	public String Password2 = prop.getProperty("User.BWTP_Password");
	public String ConfirmPassword2 = prop.getProperty("User.BWTP_ConfirmPass");
	public String TemporaryPass2 = prop.getProperty("User.BWTP_TempPass");
	public String BlockedStatus2 = prop.getProperty("User.BWTP_StatusBlocked");
	public String Search_user2 = prop.getProperty("User.BWTP_SearchNewUser");

	// Search Created User
	public String User_search1 = prop.getProperty("User.BWTP_SearchNewUser");

	// AzureAD User
	public String AzureADUser = prop.getProperty("User.D_SearchExistingAzureADUser");
	public String DeleteAzureADUser = prop.getProperty("User.deleteAzureADUser");
	String updateAzureADMsg = prop.getProperty("UpdateAzureADMsg");

	// Local User
	public String DeleteLocalUser = prop.getProperty("LocalUser");

	// Block Multiple User
	public String Block_users = prop.getProperty("User.Blockusers");

	// String searchdataclick = prop.getProperty("Admin.searchdata");
	String SearchUserDetails = prop.getProperty("SearchUserDetails");

	String SelectGroupsToAssignText = prop.getProperty("SelectGroupsToAssignText");
	By SelectGroupsToAssignMsg = getElementLocator(prop.getProperty("SelectGroupsToAssignMsg"));

	String UserDetailsRetrivedText = prop.getProperty("UserDetailsRetrivedText");
	By UserRetrivedMsg = getElementLocator(prop.getProperty("UserRetrivedMsg"));
	By mandatoryMess = getElementLocator(prop.getProperty("User.MandatoryMess"));

	String UserDeletedFromGroupText = prop.getProperty("UserDeletedFromGroupText");
	By UserDeletedFromGroupMsg = getElementLocator(prop.getProperty("UserDeletedFromGroupMsg"));
	By noRecordFound = getElementLocator(prop.getProperty("User.NoRecordFound"));
	By adminAccessButton = getElementLocator(prop.getProperty("User.AdminAccessButton"));
	By revokeAdminAccessButton = getElementLocator(prop.getProperty("User.RevokeAdminAccessButton"));
	By accountNoRecordItem = getElementLocator(prop.getProperty("User.AccountNoRecordItem"));
	By workspaceNoRecordItem = getElementLocator(prop.getProperty("User.WorkspaceNoRecordItem"));
	By adminBadgeOnListingPage = getElementLocator(prop.getProperty("User.AdminBadgeOnListingPage"));

	By adminBadge = getElementLocator(prop.getProperty("User.AdminBadge"));
	By groupTab = getElementLocator(prop.getProperty("User.GroupTab"));
	By accountTab = getElementLocator(prop.getProperty("User.AccountTab"));
	By workspaceTab = getElementLocator(prop.getProperty("User.WorkspaceTab"));

	public By UserNameSpecialCharVal = getElementLocator(prop.getProperty("User.UserNameSpecialCharVal"));
	public By UserNameMandatoryVal = getElementLocator(prop.getProperty("User.UserNameMandatoryVal"));
	public By ExceedCharValMsg = getElementLocator(prop.getProperty("User.ExceedCharValMsg"));
	public By EmailSpecialCharVal = getElementLocator(prop.getProperty("User.EmailSpecialCharVal"));
	public By EmailMandatoryVal = getElementLocator(prop.getProperty("User.EmailMandatoryVal"));
	public By FirstNameMandatoryVal = getElementLocator(prop.getProperty("User.FirstNameMandatoryVal"));
	public By LastNameMandatoryVal = getElementLocator(prop.getProperty("User.LastNameMandatoryVal"));
	public By PasswordNameMandatoryVal = getElementLocator(prop.getProperty("User.PasswordNameMandatoryVal"));
	public By ConfPasswordNameMandatoryVal = getElementLocator(prop.getProperty("User.ConfPasswordNameMandatoryVal"));
	public By UserNameLabel = getElementLocator(prop.getProperty("User.UserUserNameLabel"));
	public By EmailLabel = getElementLocator(prop.getProperty("User.UserEmailLabel"));
	public By FirstNameLabel = getElementLocator(prop.getProperty("User.UserFirstNameLabel"));
	public By LastNameLabel = getElementLocator(prop.getProperty("User.UserLastNameLabel"));
	public By userPasswordLabel = getElementLocator(prop.getProperty("User.UserPasswordLabel"));
	public By userConfirmPasswordLabel = getElementLocator(prop.getProperty("User.UserConfirmPasswordLabel"));

	public String UsernameSpecialCharError = prop.getProperty("UsernameSpecialCharError");
	public String EmailSpecialCharError = prop.getProperty("EmailSpecialCharError");
	public String UserNameMandatoryText = prop.getProperty("UserNameMandatoryText");
	public String EmailMandatoryText = prop.getProperty("EmailMandatoryText");
	public String FirstnameMandatoryText = prop.getProperty("FirstnameMandatoryText");
	public String LastnameMandatoryText = prop.getProperty("LastnameMandatoryText");
	public String PasswordMandatoryText = prop.getProperty("PasswordMandatoryText");
	public String ConfirmPasswordeMandatoryText = prop.getProperty("ConfirmPasswordeMandatoryText");

	public String NameExceedCharErrorMsgText = prop.getProperty("NameExceedCharErrorMsgText");
	public String ExceedCharactersTextDetails = prop.getProperty("ExceedCharactersTextDetails");

	public String EmailDetails = prop.getProperty("Email");
	public String FirstNameSpecialChar = prop.getProperty("FirstNameSpecialChar");
	public String LastNameSpecialChar = prop.getProperty("LastNameSpecialChar");

	public String userCreateText = prop.getProperty("UserCreateText");
	String userWhoDontHavePrivilegesMessage = prop.getProperty("UserWhoDontHavePrivilegesMessage");
	String selectGroup = prop.getProperty("Users.SelectGroup");
	String groupName = prop.getProperty("User.GroupName");

	String groupPath = prop.getProperty("User.GroupPath");
	String workspaceType = prop.getProperty("User.WorkspaceType");
	String workspaceScope = prop.getProperty("User.WorkspaceScope");
	String workspaceRole = prop.getProperty("User.WorkspaceRole");
	String accountRole = prop.getProperty("User.AccountRole");

	By userCreatedMsg = getElementLocator(prop.getProperty("UserCreatedMsg"));
	By toastMsgClosedBtn = getElementLocator(prop.getProperty("ToastMsgClosedBtn"));
	By assignedGroupListName = getElementLocator(prop.getProperty("User.AssignedGroupListName"));
	String UserAddedToGroupText = prop.getProperty("UserAddedToGroupText");
	By UserAddedToGroupMsg = getElementLocator(prop.getProperty("UserAddedToGroupMsg"));

	// UserCreation Details from config file

	public String usernameDetails = prop.getProperty("Users.userNameDetails");
	public String Email = prop.getProperty("User.email");
	public String UserFirstName = prop.getProperty("Users.firstName");
	public String UserLastName = prop.getProperty("Users.lastName");
	public String Password = prop.getProperty("Users.password");
	public String ConfirmPassword = prop.getProperty("Users.confirmPassword");

	public String UsernameDetails1 = prop.getProperty("Users.userNameDetails1");
	public String Email1 = prop.getProperty("User.email1");
	public String FirstName1 = prop.getProperty("Users.firstName1");
	public String LastName1 = prop.getProperty("Users.lastName1");
	public String Password1 = prop.getProperty("Users.password1");
	public String ConfirmPassword1 = prop.getProperty("Users.confirmPassword1");

	public String userName = prop.getProperty("userName");
	public String assignGroupName = prop.getProperty("assignGroupName");

	public String userSearch = prop.getProperty("userSearch");
	public String groupSearch = prop.getProperty("groupSearch");

	public String updatedemail = prop.getProperty("Updatedemail");
	public String updatedfirstname = prop.getProperty("Updatedfirstname");
	public String updatedlastname = prop.getProperty("Updatedlastname");
	public String updatedpassword = prop.getProperty("Updatedpassword");
	public String updatedconfirmpassword = prop.getProperty("Updatedconfirmpassword");
	public String tempPass = prop.getProperty("tempPass");
	public String status = prop.getProperty("status");
	public String LocalUser_search = prop.getProperty("LocalUser_search");

	By NewUserInput = getElementLocator(prop.getProperty("NewUserInput"));
	By NewUserButtons = getElementLocator(prop.getProperty("NewUserButtons"));
	By administrationButton = getElementLocator(prop.getProperty("User.AdministrationButton"));

	String duplicateUserValidationText = prop.getProperty("duplicateUserValidationText");
	By duplicateUserValidationMsg = getElementLocator(prop.getProperty("duplicateUserValidationMsg"));

	By deleteUserBtn = getElementLocator(prop.getProperty("deleteUserBtn"));
	By deleteUserYes = getElementLocator(prop.getProperty("deleteUserYes"));

	// Group Menu click
	By GroupsMenu = getElementLocator(prop.getProperty("Groups.GroupsSideBar"));

	By spinner = getElementLocator(prop.getProperty("Spinner"));

	public String searchUser = prop.getProperty("SearchUser");

	String nonAdminValidationText = prop.getProperty("nonAdminValidationText");
	By toastMsg = getElementLocator(prop.getProperty("Commontoastmsg"));
	By popUpClose = getElementLocator(prop.getProperty("PopUpClose"));
	By usersDetailsAdminAccessButton=getElementLocator(prop.getProperty("users.details.button.adminaccess"));
	String assignAdminAccessContent=prop.getProperty("String.assignAdminAccessContent");
//**************** Methods *************
	/*
	 * public void clickOnGroupsMenu() { isDisplayedInLoop(driver, 60, GroupsMenu);
	 * click(driver, GroupsMenu);
	 * 
	 * BaseSuite.reportLog(" Clicked on the Group menu!"); }
	 * 
	 * public void userPageUIDetails() throws InterruptedException {
	 * 
	 * BaseSuite.reportLog("Checking the User Page UI details.....");
	 * 
	 * String userPageDetails =
	 * "Home Link/User Link/Users Menu/New User Option/Refresh Button/Block User/Delete Button/Search User"
	 * ;
	 * 
	 * if ((isDisplayed(driver, usersMenu)) && (isDisplayed(driver, newUsersHeader))
	 * && (isDisplayed(driver, RefreshHeader)) && (isDisplayed(driver,
	 * BlockUserHeader)) && (isDisplayed(driver, DeleteUserHeader)) &&
	 * (isDisplayed(driver, SearchUser))) { BaseSuite.reportLog(userPageDetails +
	 * " details of Users page are displayed!");
	 * BaseSuite.validationReportLog("Links, Menus and Buttons are dispayed!");
	 * 
	 * } else { BaseSuite.reportFailLog(userPageDetails +
	 * " are not displaying in the page", "userPageUIDetails"); }
	 * 
	 * }
	 * 
	 * public void homeLinkClickFromUserPage() throws InterruptedException {
	 * clickOnUsersMenu();
	 * 
	 * if (isDisplayed(driver, AdministrationLabel)) { isDisplayedInLoop(driver, 10,
	 * AdministrationLabel); click(driver, AdministrationLabel); BaseSuite.
	 * reportLog("Home Link is displayed and clickable--Navigation to Home link from user is working"
	 * ); } else {
	 * BaseSuite.reportFailLog("Home Link is not displayed and clickable",
	 * "homeLinkClickFromUserPage"); } }
	 * 
	 * public void userPageGridDetailsInfo() throws InterruptedException {
	 * 
	 * String gridDetails =
	 * "FullName/Username/Status/Email/Synced/Identity/LastModified grid details";
	 * 
	 * BaseSuite.reportLog("Checking grid columns in the User Page!");
	 * 
	 * if ((isDisplayed(driver, GridDetailsFullName)) && (isDisplayed(driver,
	 * GridDetailsUserName)) && (isDisplayed(driver, GridDetailsStatus)) &&
	 * (isDisplayed(driver, GridDetailsEmail)) && (isDisplayed(driver,
	 * GridDetailsSynced)) && (isDisplayed(driver, GridDetailsIdentity)) &&
	 * (isDisplayed(driver, GridDetailsLastModified))) {
	 * 
	 * BaseSuite.validationReportLog(gridDetails +
	 * " columns are displayed properly in the User Page!");
	 * 
	 * } else { BaseSuite.reportFailLog(gridDetails +
	 * " some columns are missing from the Users Page", "userPageGridDetailsInfo");
	 * }
	 * 
	 * }
	 * 
	 * public void checkSideBarMenus() { isDisplayed(driver, Sidebar); click(driver,
	 * Sidebar); BaseSuite.reportLog("Click on the side bar!"); if
	 * ((isDisplayed(driver, SidebarUsers)) && (isDisplayed(driver, SidebarGroups))
	 * && (isDisplayed(driver, SidebarRoles)) && (isDisplayed(driver,
	 * SidebarAccounts)) && (isDisplayed(driver, SidebarWorkspace))) {
	 * 
	 * BaseSuite.
	 * reportLog("Side bar details are displayed properly in the User Page!");
	 * click(driver, Sidebar);
	 * BaseSuite.reportLog("Click on the side bar to open the side bar!");
	 * 
	 * if ((isDisplayed(driver, SidebarUsers)) && (isDisplayed(driver,
	 * SidebarGroups)) && (isDisplayed(driver, SidebarRoles)) &&
	 * (isDisplayed(driver, SidebarAccounts)) && (isDisplayed(driver,
	 * SidebarWorkspace))) { BaseSuite.reportLog(
	 * "Opening and closing of side bar is working and displaying the Users/Groups/Roles/Accounts/Workspace Menus!"
	 * ); }
	 * 
	 * } else { BaseSuite.
	 * reportFailLog("Side bar details are not displayed properly in the User Page!"
	 * , "checkSideBarMenus"); } }
	 * 
	 * public boolean checkBlockUserDisabled() { boolean flag = false;
	 * 
	 * if (isDisplayed(driver, blockUserDisabled)) {
	 * BaseSuite.reportLog("Blaock user button is disabled"); flag = true; } else {
	 * BaseSuite.reportLog("Block user button is enabled"); } return flag; }
	 * 
	 * public boolean Createuser1(SoftAssert softAssert, String Username, String
	 * Email, String FirstName, String LastName, String Password, String
	 * ConfirmPassword, String InvalidDetails, String ValidDetails) { boolean flag =
	 * false; // boolean AzureLabel = isDisplayed(driver, username); //
	 * softAssert.assertTrue(AzureLabel); try {
	 * 
	 * String browserInfo = BaseSuite.browserName.toLowerCase();
	 * 
	 * if ((browserInfo != null) && (!browserInfo.contains("head"))) {
	 * navigatetoAppPage(); }
	 * 
	 * isDisplayedInLoop(driver, 5, pagelabel); if (isDisplayed(driver,
	 * ClickonAdmin)) { flag = true; click(driver, ClickonAdmin);
	 * BaseSuite.reportLog("User able to click on Administration tab");
	 * 
	 * isDisplayedInLoop(driver, 5, ClickonCreateuser); click(driver,
	 * ClickonCreateuser);
	 * BaseSuite.reportLog("User clicked on the create new user tab"); }
	 * 
	 * if (actualTitle == expectedTitle) { flag = true; actualTitle =
	 * driver.getTitle(); expectedTitle = "Nextgenicedq";
	 * assertEquals(expectedTitle, actualTitle);
	 * 
	 * isDisplayedInLoop(driver, 2, username); clear_Click_SendKeys(driver, 2,
	 * username, Username); clear_Click_SendKeys(driver, 2, email, Email);
	 * clear_Click_SendKeys(driver, 2, firstname, FirstName);
	 * clear_Click_SendKeys(driver, 2, lastname, LastName);
	 * clear_Click_SendKeys(driver, 2, password, Password);
	 * clear_Click_SendKeys(driver, 2, confirmpassword, ConfirmPassword);
	 * 
	 * if (InvalidDetails.equalsIgnoreCase("Invalid")) { flag = true; click(driver,
	 * ClickonDiscard); isDisplayedInLoop(driver, 2, ClickonCreateuser);
	 * click(driver, ClickonCreateuser);
	 * BaseSuite.reportLog("User clicked on the create new user tab");
	 * 
	 * if (ValidDetails.equalsIgnoreCase("Valid")) { flag = true; List<WebElement>
	 * togg = driver.findElements(toggle1); for (WebElement tag : togg) { if
	 * (tag.isEnabled()) { tag.click(); } else if (!tag.isEnabled()) { tag.click();
	 * } }
	 * 
	 * click(driver, clickonsave);
	 * 
	 * } else { BaseSuite.reportLog("User not able to create a new user"); } }
	 * 
	 * } } catch (Exception ex) { throw new
	 * AssertionError("User not able to navigate on the create new user page", ex);
	 * } return flag; }
	 * 
	 * public void holdsAfterLogin() throws InterruptedException {
	 * Thread.sleep(5000); }
	 * 
	 * public void searchUser(String User_search) throws Exception {
	 * 
	 * BaseSuite.reportLog("Searching for User: " + User_search);
	 * isDisplayedInLoop(driver, 30, SearchBar); javascript(driver,
	 * "arguments[0].click();", SearchBar); clear(driver, SearchBar);
	 * 
	 * isDisplayedInLoop(driver, 30, SearchBar);
	 * BaseSuite.reportLog("Entering the user details...."); sendKeys(driver,
	 * SearchBar, User_search); BaseSuite.reportLog("Click On searched");
	 * 
	 * isDisplayedInLoop(driver, 30, SearchClick); javascript(driver,
	 * "arguments[0].click();", SearchClick);
	 * 
	 * Thread.sleep(3000); try {
	 * 
	 * isDisplayedInLoop(driver, 30, SearchClick);
	 * 
	 * BaseSuite.reportLog("Click on Searched User"); click(driver,
	 * returnElement(searchList, "$User", User_search));
	 * BaseSuite.validationReportLog("Clicked on User: " + User_search);
	 * BaseSuite.reportLog("User Details retrieved successfully for user " +
	 * User_search); waitForElement(driver, toastMsgClosedBtn);
	 * captureToastMsg(driver, UserRetrivedMsg, toastMsgClosedBtn,
	 * UserDetailsRetrivedText, "User detail retrieved");
	 * 
	 * } catch (Exception e) { throw new Exception("User_search " + SearchClick +
	 * " not found"); } }
	 * 
	 * public void numberOfUsersAndPagination() throws InterruptedException {
	 * 
	 * clickOnUsersMenu();
	 * 
	 * BaseSuite.reportLog("Checking number of available users ");
	 * isDisplayedInLoop(driver, 10, NumberOfUsers); Thread.sleep(3000); String
	 * numbers = getText(driver, NumberOfUsers);
	 * 
	 * System.out.println("Number of users in the list are " + numbers);
	 * BaseSuite.reportLog("Available Users " + numbers);
	 * 
	 * paginationInsearchfield(driver, Pagination);
	 * 
	 * }
	 * 
	 * public void defaultUserPageVerification() {
	 * 
	 * BaseSuite.reportLog("Verifying New Button in the User page");
	 * 
	 * boolean newUserButton = isEnabled(driver, NewUsersHeader);
	 * 
	 * if (newUserButton) {
	 * BaseSuite.validationReportLog("New User creation button is enabled"); } else
	 * { BaseSuite.reportFailLog("New User creation button is disabled",
	 * "defaultUserPageVerification"); }
	 * 
	 * BaseSuite.reportLog("Verifying Refresh Button in the User page");
	 * 
	 * boolean refreshButton = isEnabled(driver, RefreshHeader);
	 * 
	 * if (refreshButton) {
	 * BaseSuite.validationReportLog("Refresh button is enabled");
	 * 
	 * } else {
	 * 
	 * BaseSuite.reportFailLog("Refresh button is disabled",
	 * "defaultUserPageVerification"); }
	 * 
	 * BaseSuite.reportLog("Verifying Block user Button in the User page");
	 * 
	 * boolean yes = isDisplayed(driver, BlockUserHeader);
	 * 
	 * if (yes) { BaseSuite.validationReportLog("Block user button is disabled"); }
	 * else {
	 * 
	 * BaseSuite.reportFailLog("Block user button is enabled",
	 * "defaultUserPageVerification"); }
	 * 
	 * BaseSuite.reportLog("Verifying Delete button in the User Page");
	 * 
	 * boolean deleteUser = isDisplayed(driver, DeleteUserHeader);
	 * 
	 * if (deleteUser) {
	 * 
	 * BaseSuite.validationReportLog("Delete user button is disabled ");
	 * 
	 * } else {
	 * 
	 * BaseSuite.reportFailLog("Delete user button is enabled",
	 * "defaultUserPageVerification"); }
	 * 
	 * }
	 * 
	 * public void displayAndClick(By locator) {
	 * 
	 * try {
	 * 
	 * isDisplayedInLoop(driver, 20, locator);
	 * 
	 * click(driver, locator);
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.getMessage(); } }
	 * 
	 * public void searchAssignGroup(String assignGroupName) {
	 * 
	 * clear(driver, AddGroupTextBox);
	 * 
	 * isDisplayedInLoop(driver, 14, AddGroupTextBox);
	 * 
	 * clear_Click_SendKeys(driver, 2, AddGroupTextBox, assignGroupName);
	 * 
	 * displayAndClick(AddGroupTextBox);
	 * 
	 * }
	 * 
	 * public void validateDuplicateUserCreation() throws Exception { createUser();
	 * captureToastMsg(driver, duplicateUserValidationMsg, toastMsgClosedBtn,
	 * duplicateUserValidationText, "Username already exist");
	 * driver.navigate().refresh(); clickOnUsersMenu();
	 * searchUserAndClick("DuplicateUserTest");
	 * 
	 * isDisplayedInLoop(driver, 30, deleteUserBtn); click(driver, deleteUserBtn);
	 * Thread.sleep(2000); isDisplayedInLoop(driver, 30, deleteUserYes);
	 * click(driver, deleteUserYes); Thread.sleep(5000);
	 * 
	 * }
	 * 
	 * public void userAssignToGroup(String userName, String assignGrpName,
	 * SoftAssert soft) throws Exception {
	 * 
	 * searchUser(userName);
	 * 
	 * Thread.sleep(3000);
	 * 
	 * BaseSuite.reportLog("Checking the Group tab"); isDisplayedInLoop(driver, 30,
	 * UserGroupTab); click(driver, UserGroupTab);
	 * BaseSuite.validationReportLog("Clicked on the Group tab");
	 * 
	 * BaseSuite.reportLog("Checking the Assign button"); isDisplayedInLoop(driver,
	 * 30, UserAssignBtn); click(driver, UserAssignBtn);
	 * BaseSuite.validationReportLog("Clicked on the Assign button");
	 * 
	 * BaseSuite.reportLog("Checking the Assign Grooup pane");
	 * isDisplayedInLoop(driver, 30, UserAssignGroupsLabel);
	 * 
	 * BaseSuite.reportLog("Checking the Add Group TextBox");
	 * isDisplayedInLoop(driver, 30, AddGroupTextBox);
	 * displayAndClick(AddGroupTextBox);
	 * BaseSuite.validationReportLog("Clicked on the Add Group Textbox");
	 * 
	 * Thread.sleep(2000);
	 * 
	 * BaseSuite.reportLog("Entering the group name details.."); sendKeys(driver,
	 * AddGroupTextBox, assignGrpName); Thread.sleep(2000);
	 * driver.findElement(By.xpath("//input[@class='e-dropdownbase']")).sendKeys(
	 * Keys.ENTER);
	 * 
	 * BaseSuite.reportLog("Entered group is:::" + assignGrpName);
	 * BaseSuite.validationReportLog("Group name details are entered");
	 * 
	 * isDisplayedInLoop(driver, 30, UsersAssignGroupBtn); click(driver,
	 * UsersAssignGroupBtn); BaseSuite.reportLog("Clicked on the Assign button");
	 * Thread.sleep(2000);
	 * 
	 * captureToastMsg(driver, UserAddedToGroupMsg, toastMsgClosedBtn,
	 * UserAddedToGroupText, "User added to group"); }
	 * 
	 * public void discardAddingOfGroupForUser(String assignGrpName) throws
	 * Exception { searchUser("Vivek Ramteke"); isDisplayedInLoop(driver, 30,
	 * UserGroupTab); click(driver, UserGroupTab);
	 * 
	 * isDisplayedInLoop(driver, 30, UserAssignBtn); click(driver, UserAssignBtn);
	 * 
	 * isDisplayedInLoop(driver, 30, UserAssignGroupsLabel);
	 * 
	 * isDisplayedInLoop(driver, 30, AddGroupTextBox);
	 * displayAndClick(AddGroupTextBox);
	 * 
	 * Thread.sleep(2000);
	 * 
	 * BaseSuite.reportLog("Clicked on the group search bar");
	 * 
	 * driver.findElement(By.xpath("//input[@class='e-dropdownbase']")).sendKeys(
	 * assignGrpName); Thread.sleep(2000);
	 * driver.findElement(By.xpath("//input[@class='e-dropdownbase']")).sendKeys(
	 * Keys.ENTER);
	 * 
	 * BaseSuite.reportLog("Added group is " + assignGrpName);
	 * 
	 * click(driver, UsersDiscardGroupBtn);
	 * 
	 * BaseSuite.reportLog("Group adding for user has been discarded");
	 * 
	 * }
	 * 
	 * public void searchAssignGroupForUserAndClick(String Grp_search) throws
	 * Exception {
	 * 
	 * searchUser("Vivek Ramteke");
	 * 
	 * isDisplayedInLoop(driver, 14, UserGroupTab); click(driver, UserGroupTab);
	 * 
	 * BaseSuite.reportLog("Searching for Group: " + Grp_search);
	 * isDisplayedInLoop(driver, 30, GrpSearchTextboxForUser); click(driver,
	 * GrpSearchTextboxForUser); clear(driver, GrpSearchTextboxForUser);
	 * 
	 * isDisplayedInLoop(driver, 30, GrpSearchTextboxForUser);
	 * BaseSuite.reportLog("Search Group Name"); sendKeys(driver,
	 * GrpSearchTextboxForUser, Grp_search);
	 * 
	 * BaseSuite.reportLog("Searched Group is " + Grp_search);
	 * 
	 * isDisplayedInLoop(driver, 30, GrpSearchTextboxClickForUser); click(driver,
	 * GrpSearchTextboxClickForUser);
	 * BaseSuite.reportLog("Clicking on Searched Group which assigned to User");
	 * 
	 * try {
	 * 
	 * click(driver, returnElement(GroupSearchData, "$Group", Grp_search));
	 * 
	 * Thread.sleep(3000); BaseSuite.reportLog("Clicked on Group: " + Grp_search);
	 * BaseSuite.reportLog("Group Details retrieved successfully for user " +
	 * Grp_search);
	 * 
	 * } catch (Exception e) { throw new Exception("Group_search " +
	 * GrpSearchTextboxClickForUser + " not found"); } }
	 * 
	 * public void removeGroupFromExistingUser(String searchUserDetails, String
	 * GroupDetails, SoftAssert soft) throws Exception {
	 * 
	 * searchUser(searchUserDetails);
	 * 
	 * BaseSuite.reportLog("Checking the Group tab"); isDisplayedInLoop(driver, 30,
	 * UserGroupTab); click(driver, UserGroupTab);
	 * BaseSuite.validationReportLog("Clicked on the Group tab");
	 * 
	 * BaseSuite.reportLog("Searching for Assigned Group: " + GroupDetails);
	 * isDisplayedInLoop(driver, 30, GrpSearchTextboxForUser); click(driver,
	 * GrpSearchTextboxForUser);
	 * BaseSuite.reportLog("Checked on serach user text box"); clear(driver,
	 * GrpSearchTextboxForUser);
	 * 
	 * isDisplayedInLoop(driver, 30, GrpSearchTextboxForUser);
	 * BaseSuite.reportLog("Searching Group Name"); sendKeys(driver,
	 * GrpSearchTextboxForUser, GroupDetails);
	 * BaseSuite.reportLog("Entering the group details in the search field..");
	 * 
	 * isDisplayedInLoop(driver, 30, GrpSearchTextboxClickForUser); click(driver,
	 * GrpSearchTextboxClickForUser);
	 * BaseSuite.validationReportLog("Click on searched group");
	 * 
	 * BaseSuite.reportLog("Searched group is " + GroupDetails);
	 * 
	 * Thread.sleep(3000); BaseSuite.reportLog("Selecting the Group checkbox");
	 * click(driver, GrpCheckbox);
	 * BaseSuite.validationReportLog("Group is selected");
	 * 
	 * BaseSuite.reportLog("Clicking on the Remove Button"); click(driver,
	 * GrpRemoveBtnClick); Thread.sleep(3000);
	 * BaseSuite.validationReportLog("Clicked on the Remove Button");
	 * 
	 * BaseSuite.reportLog("Clicking on the Remove Button---Yes"); click(driver,
	 * GrpRemoveBtnClickYes);
	 * BaseSuite.validationReportLog("Clicked on the Remove Button---Yes");
	 * 
	 * captureToastMsg(driver, UserDeletedFromGroupMsg, toastMsgClosedBtn,
	 * UserDeletedFromGroupText, "User Deleted From Group");
	 * 
	 * }
	 * 
	 * public void Admin() { try { isDisplayedInLoop(driver, 5, pagelabel); if
	 * (isDisplayed(driver, pagelabel)) { click(driver, ClickonAdmin);
	 * BaseSuite.reportLog("User able to click on Administration tab"); }
	 * 
	 * else { BaseSuite.reportLog("Not able to click on the Administration tab"); }
	 * } catch (Exception e) { throw new
	 * AssertionError("User not able to navigate on Administration page", e); } }
	 * 
	 * public boolean CreateValidInvalidUser(SoftAssert softAssert, String Username,
	 * String Email, String FirstName, String LastName, String Password, String
	 * ConfirmPassword, String Scenario, String TemporaryPass, String Status) {
	 * 
	 * boolean flag = false;
	 * 
	 * try {
	 * 
	 * clickOnUsersMenu(); isDisplayedInLoop(driver, 30, NewUsersHeader);
	 * 
	 * if (!Scenario.isEmpty()) { isDisplayedInLoop(driver, 30, NewUsersHeader);
	 * click(driver, NewUsersHeader); Thread.sleep(3000);
	 * BaseSuite.reportLog("User clicked on the create new user tab");
	 * 
	 * actualTitle = driver.getTitle(); expectedTitle = "Nextgenicedq";
	 * assertEquals(expectedTitle, actualTitle);
	 * 
	 * isDisplayedInLoop(driver, 20, username); clear_Click_SendKeys(driver, 20,
	 * username, Username); clear_Click_SendKeys(driver, 20, email, Email);
	 * clear_Click_SendKeys(driver, 20, firstname, FirstName); //
	 * clear_Click_SendKeys(driver, 20, lastname, LastName);
	 * 
	 * javascript(driver, "arguments[0].click();", lastname); sendKeys(driver,
	 * lastname, LastName);
	 * 
	 * javascript(driver, "arguments[0].click();", password); sendKeys(driver,
	 * password, Password);
	 * 
	 * // clear_Click_SendKeys(driver, 20, password, Password); //
	 * clear_Click_SendKeys(driver, 20, confirmpassword, ConfirmPassword);
	 * 
	 * javascript(driver, "arguments[0].click();", confirmpassword);
	 * sendKeys(driver, confirmpassword, ConfirmPassword);
	 * 
	 * if (Scenario.equalsIgnoreCase("Valid")) {
	 * 
	 * if (!TemporaryPass.isEmpty()) { String gettext = getText(driver, Toggle);
	 * gettext = gettext.trim();
	 * 
	 * if (!TemporaryPass.equalsIgnoreCase(gettext)) {
	 * 
	 * javascript(driver, "arguments[0].click();", Toggle);
	 * 
	 * BaseSuite.reportLog("Temporary password is selected"); } }
	 * 
	 * isDisplayedInLoop(driver, 30, clickonsave); if (isDisplayed(driver,
	 * clickonsave)) { Thread.sleep(3000); javascript(driver,
	 * "arguments[0].click();", clickonsave);
	 * BaseSuite.reportLog("Clicked on Save button");
	 * 
	 * } }
	 * 
	 * else {
	 * 
	 * click(driver, ClickonDiscard);
	 * 
	 * String subwindow = driver.getWindowHandle();
	 * driver.switchTo().window(subwindow); javascript(driver,
	 * "arguments[0].click();", DiscardAlert);
	 * 
	 * BaseSuite.reportLog("Clicked on the discard button"); } } else {
	 * BaseSuite.reportLog("Not able to click on the the button for empty row"); }
	 * 
	 * }
	 * 
	 * catch (Exception ex) { throw new
	 * AssertionError("User not able to navigate on the create new user page", ex);
	 * 
	 * } return flag; }
	 * 
	 * public boolean createUserWithValid_InvalidData(SoftAssert softAssert, String
	 * Username, String Email, String FirstName, String LastName, String Password,
	 * String ConfirmPassword, String Scenario, String TemporaryPass, String Status)
	 * {
	 * 
	 * boolean flag = false;
	 * 
	 * try { clickOnUsersMenu(); isDisplayedInLoop(driver, 25, NewUsersHeader);
	 * 
	 * if (!Scenario.isEmpty()) { javascript(driver, "arguments[0].click();",
	 * NewUsersHeader);
	 * BaseSuite.reportLog("User clicked on the create new user tab");
	 * 
	 * actualTitle = driver.getTitle(); expectedTitle = "Nextgenicedq";
	 * assertEquals(expectedTitle, actualTitle); Thread.sleep(5000);
	 * isDisplayedInLoop(driver, 3, username); clear_Click_SendKeys(driver, 3,
	 * username, Username); clear_Click_SendKeys(driver, 3, email, Email); //
	 * clear_Click_SendKeys(driver, 3, firstname, FirstName); click(driver,
	 * lastname); sendKeys(driver, lastname, LastName); clear_Click_SendKeys(driver,
	 * 3, lastname, LastName); clear_Click_SendKeys(driver, 3, password, Password);
	 * clear_Click_SendKeys(driver, 3, confirmpassword, ConfirmPassword);
	 * 
	 * if (Scenario.equalsIgnoreCase("Valid")) {
	 * 
	 * if (!TemporaryPass.isEmpty()) { String gettext = getText(driver, Toggle);
	 * gettext = gettext.trim();
	 * 
	 * if (!TemporaryPass.equalsIgnoreCase(gettext)) { click(driver, Toggle);
	 * 
	 * BaseSuite.reportLog("Temporary password is selected"); } }
	 * 
	 * if (!Status.isEmpty()) {
	 * 
	 * String gettext = getText(driver, Toggle1); gettext = gettext.trim();
	 * 
	 * if (!Status.equalsIgnoreCase(gettext)) { click(driver, Toggle1);
	 * 
	 * BaseSuite.reportLog("Status is selected"); } }
	 * 
	 * isDisplayedInLoop(driver, 3, clickonsave); if (isDisplayed(driver,
	 * clickonsave)) { Thread.sleep(3000); javascript(driver,
	 * "arguments[0].click();", clickonsave);
	 * 
	 * BaseSuite.reportLog("Clicked on Save button"); isDisplayedInLoop(driver, 3,
	 * Welcometitle); isDisplayed(driver, Welcometitle);
	 * BaseSuite.validationReportLog("New user created successfully");
	 * Thread.sleep(3000); clickOnUsersMenu();
	 * 
	 * }
	 * 
	 * }
	 * 
	 * else {
	 * 
	 * isDisplayedInLoop(driver, 5, ClickonDiscard); Thread.sleep(3000);
	 * 
	 * click(driver, ClickonDiscard);
	 * 
	 * Thread.sleep(3000); javascript(driver, "arguments[0].click();",
	 * DiscardAlert);
	 * 
	 * BaseSuite.
	 * validationReportLog("User clicked on the discard button successfully"); } }
	 * else {
	 * BaseSuite.reportLog("Not able to click on the the button for empty row"); }
	 * 
	 * }
	 * 
	 * catch (Exception ex) { throw new
	 * AssertionError("User not able to navigate on the create new user page", ex);
	 * 
	 * } return flag; }
	 * 
	 * public void deleteuser(String User_search) throws Exception {
	 * 
	 * clickOnUsersMenu(); Thread.sleep(3000);
	 * BaseSuite.reportLog("Searching for User:" + User_search);
	 * isDisplayedInLoop(driver, 30, searchbar); click(driver, searchbar);
	 * clear(driver, searchbar);
	 * 
	 * isDisplayedInLoop(driver, 30, searchbar); BaseSuite.reportLog("Search Name");
	 * sendKeys(driver, searchbar, User_search);
	 * BaseSuite.reportLog("Click On searched"); if (!User_search.isEmpty()) {
	 * isDisplayedInLoop(driver, 30, searchclick); click(driver, searchclick); }
	 * else { BaseSuite.reportLog("Created user not available in the list"); }
	 * 
	 * try {
	 * 
	 * isDisplayedInLoop(driver, 30, searchclick);
	 * 
	 * BaseSuite.reportLog("Click on Searched User");
	 * 
	 * click(driver, returnElement(searchdataclick, "$User", User_search));
	 * BaseSuite.reportLog("Clicked on User: " + User_search);
	 * BaseSuite.reportLog("User Details retrieved successfully for user " +
	 * User_search);
	 * 
	 * isDisplayedInLoop(driver, 30, deleteT); if (isDisplayed(driver, deleteT)) {
	 * click(driver, deleteT); isDisplayedInLoop(driver, 30, clickonpopup);
	 * Thread.sleep(3000); click(driver, clickonpopup); Thread.sleep(5000);
	 * BaseSuite.validationReportLog("Created user deleted successfully"); } else {
	 * BaseSuite.reportLog("Created user not able to delete"); } } catch (Exception
	 * e) { throw new Exception("deleteuser " + searchdataclick + " not found"); } }
	 * 
	 * isDisplayedInLoop(driver, 2, pagelabel); if(isDisplayed(driver,
	 * ClickonAdmin)) {
	 * 
	 * click(driver, ClickonAdmin);
	 * BaseSuite.reportLog("User able to click on Administration tab");
	 * 
	 * BaseSuite.reportLog("User able to click on Administration tab");
	 * 
	 * Thread.sleep(5000); isDisplayedInLoop(driver,2, namelable);
	 * 
	 * List<WebElement> checkbox =
	 * driver.findElements(By.xpath("//input[@type='checkbox']")); int size =
	 * checkbox.size();
	 * 
	 * System.out.println("Quantity of checkboxes are:"+ size); for(WebElement ele :
	 * checkbox) { if(ele.isSelected()) { ele.click(); } }
	 * 
	 * for(int i=0; i<size; i++) { String val=
	 * checkbox.get(i).getAttribute("Icedq Test");
	 * if(val.equalsIgnoreCase("e-frame e-icons e-uncheck")) {
	 * checkbox.get(i).click(); } } } }
	 * 
	 * catch(
	 * 
	 * Exception ex) {
	 * BaseSuite.reportLog("User not able to delete the selected user"); }
	 * 
	 * public void continueNext(String FileName, String SheetName, String
	 * userNameCol, ExtentTest test, int userNumber, String errorMsg,
	 * org.apache.log4j.Logger log, String columnName, String methodName) throws
	 * IOException, EncryptedDocumentException, InvalidFormatException,
	 * org.apache.poi.openxml4j.exceptions.InvalidFormatException {
	 * 
	 * BaseClassUtil util = new BaseClassUtil();
	 * 
	 * XLUtils xl = new XLUtils();
	 * 
	 * String ruleName = xl.readUsingColName(FileName, SheetName, userNumber,
	 * userNameCol);// get the rule name from // excel // sheet
	 * 
	 * try {
	 * 
	 * xl.writeToExcel("Fail", FileName, SheetName, userNumber, columnName);// write
	 * the excel as fail into the // status // column
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.getStackTrace();
	 * 
	 * }
	 * 
	 * test.error("User Name " + userNameCol + " with User number " + userNumber +
	 * " failed");// log the error in // extent // report test.error(errorMsg);//
	 * Log the exception in extent report
	 * 
	 * String screenshotPath = util.takeScreenshotAtEndOfTest(methodName, driver);//
	 * pass the class name as screen shot // name
	 * 
	 * test.addScreenCaptureFromBase64String(screenshotPath);// log the screen shot
	 * in extent report
	 * 
	 * log.debug(errorMsg);// also log this error into application log
	 * 
	 * }
	 * 
	 * // Test code from Vivek_Page
	 * 
	 * 
	 * public void clickOnUserMenuForNonAdminUser() throws Exception { try {
	 * Thread.sleep(1000); displayAndClick(toastMsgClosedBtn); Workspaces wrk = new
	 * Workspaces(driver); displayAndClick(wrk.WorkspaceMenu);
	 * BaseSuite.reportLog("Clicking on User menu"); displayAndClick(UsersMenu);
	 * BaseSuite.validationReportLog("Clicked on the User Menu!!"); BaseSuite.
	 * reportLog("Verifying validation message for the non admin user on User Menu"
	 * ); inVisible(driver, spinner, Constant.ruleWait); isDisplayedInLoop(driver,
	 * 10, toastMsgClosedBtn); captureToastMsg(driver, commonToastMsg,
	 * toastMsgClosedBtn, nonAdminValidationText, "Insufficient privileges"); }
	 * catch (Exception e) { log.error(e.getMessage()); throw new Exception(); } }
	 * 
	 * public void clickOnSaveUserBtn() throws Exception {
	 * 
	 * BaseSuite.reportLog("Clicking on the Save button..");
	 * isDisplayedInLoop(driver, 40, clickonsave); click(driver, clickonsave);
	 * BaseSuite.validationReportLog("Save button clicked successfully..");
	 * inVisible(driver, spinner, Constant.ruleWait); waitForElement(driver,
	 * toastMsgClosedBtn); captureToastMsg(driver, userCreatedMsg,
	 * toastMsgClosedBtn, userCreateText, "User Created");
	 * validateInputFields(driver, NewUserInput, 8); validateButtons(driver,
	 * NewUserButtons, 3);
	 * 
	 * }
	 * 
	 * public void createUser_TempPassword(String Username, String Email, String
	 * FirstName, String LastName, String Password, String ConfirmPassword, String
	 * TemporaryPass) throws InterruptedException { clickOnUsersMenu();
	 * Thread.sleep(2000); BaseSuite.reportLog("Checking the New user button ");
	 * clickOnNewButton(); BaseSuite.validationReportLog("New user page is opened");
	 * 
	 * BaseSuite.reportLog(":::Entering the details of the User:::");
	 * 
	 * clear_Click_SendKeys(driver, 30, username, Username);
	 * BaseSuite.reportLog("Entered Users name: " + Username);
	 * 
	 * clear_Click_SendKeys(driver, 30, email, Email);
	 * BaseSuite.reportLog("Entered Users Email: " + Email);
	 * 
	 * clear_Click_SendKeys(driver, 30, firstname, FirstName);
	 * BaseSuite.reportLog("Entered Users FirstName: " + FirstName);
	 * 
	 * clear_Click_SendKeys(driver, 30, lastname, LastName);
	 * BaseSuite.reportLog("Entered Users LastName: " + LastName);
	 * 
	 * clear_Click_SendKeys(driver, 30, password, Password);
	 * BaseSuite.reportLog("Entered Users Password: " + Password);
	 * 
	 * clear_Click_SendKeys(driver, 30, confirmpassword, ConfirmPassword);
	 * BaseSuite.reportLog("Entered Users ConfirmPassword: " + ConfirmPassword);
	 * 
	 * if (TemporaryPass.equals("Yes")) {
	 * BaseSuite.reportLog("Temporary password is selected..."); BaseSuite.
	 * validationReportLog("Creating user with the Temporary password :::::::::::");
	 * 
	 * } else if (TemporaryPass.equals("No")) { click(driver, TempPassWord_No);
	 * BaseSuite.reportLog("Clicked on Temporary password--No");
	 * BaseSuite.reportLog("Temporary password is not selected..."); BaseSuite.
	 * validationReportLog("Creating user without the Temporary password:::::::::::"
	 * ); } else {
	 * BaseSuite.reportLog("Unable to click on the Temporary password toggle button"
	 * ); }
	 * 
	 * isDisplayedInLoop(driver, 30, clickonsave);
	 * BaseSuite.reportLog("Clicking on the user save button"); click(driver,
	 * clickonsave); try { waitForElement(driver, toastMsgClosedBtn);
	 * captureToastMsg(driver, userCreatedMsg, toastMsgClosedBtn, userCreateText,
	 * "User Created"); } catch (Exception e) { e.printStackTrace(); throw new
	 * AssertionError("Error occured in this method", e); } Thread.sleep(3000); }
	 * 
	 * public void refreshUserListing() throws InterruptedException {
	 * clickOnUsersMenu(); Thread.sleep(3000);
	 * 
	 * BaseSuite.reportLog("Checking the Refresh button"); isDisplayedInLoop(driver,
	 * 30, RefreshHeader);
	 * 
	 * if (isEnabled(driver, RefreshHeader)) {
	 * BaseSuite.reportLog("Refresh button is enabled");
	 * BaseSuite.reportLog("Checking number of available users ");
	 * 
	 * String numbers = getText(driver, NumberOfUsers);
	 * System.out.println("Number of users in the list are " + numbers);
	 * BaseSuite.reportLog("Available Users " + numbers);
	 * 
	 * BaseSuite.reportLog("Click on the Refresh button"); click(driver,
	 * RefreshHeader);
	 * BaseSuite.validationReportLog("Clicked on the Refresh button");
	 * 
	 * String updatednumbers = getText(driver, NumberOfUsers);
	 * System.out.println("Number of users in the list are " + updatednumbers);
	 * BaseSuite.reportLog("Available Users " + updatednumbers);
	 * 
	 * BaseSuite.validationReportLog("User listing refreshed"); } else {
	 * BaseSuite.reportLog("Unable to click refresh button");
	 * BaseSuite.reportErrorLog("Unable to refresh the user listing"); }
	 * 
	 * }
	 * 
	 * public void mandatoryFieldValidation(String specialCharacter, String
	 * specialCharacterKey, By locator1, By locator2, String backSpaceKey, String
	 * lable, String specialCharErrorMsg, String backSpaceErrorMsg, By locator3) {
	 * 
	 * SoftAssert soft = new SoftAssert();
	 * 
	 * if (specialCharacter.equalsIgnoreCase("Yes") &&
	 * !specialCharacterKey.isEmpty()) {
	 * 
	 * specialCharaMandatoryField(driver, locator1, locator3, specialCharacterKey,
	 * soft, lable, specialCharErrorMsg); } else {
	 * 
	 * if (!(backSpaceKey.equalsIgnoreCase("Yes"))) { otherMandatoryField(driver,
	 * locator1, locator2, backSpaceKey, soft, lable, backSpaceErrorMsg);
	 * 
	 * }
	 * 
	 * } }
	 * 
	 * public void userNameValidate(String specialCharacter, String
	 * specialCharacterKey, By locator1, By locator2, String backSpaceKey, String
	 * lable, String specialCharErrorMsg, String backSpaceErrorMsg, By locator3)
	 * throws InterruptedException {
	 * 
	 * mandatoryFieldValidation(specialCharacter, specialCharacterKey, locator1,
	 * locator2, backSpaceKey, lable, specialCharErrorMsg, backSpaceErrorMsg,
	 * locator3);
	 * 
	 * driver.navigate().refresh(); Thread.sleep(3000); visible(driver, username,
	 * Constant.ruleWait); }
	 * 
	 * public void emailTextBoxWithInvalidDetails(String specialCharacter, String
	 * specialCharacterKey, By locator1, By locator2, String backSpaceKey, String
	 * lable, String specialCharErrorMsg, String backSpaceErrorMsg, By locator3)
	 * throws InterruptedException {
	 * 
	 * mandatoryFieldValidation(specialCharacter, specialCharacterKey, locator1,
	 * locator2, backSpaceKey, lable, specialCharErrorMsg, backSpaceErrorMsg,
	 * locator3);
	 * 
	 * driver.navigate().refresh(); Thread.sleep(3000); visible(driver, username,
	 * Constant.ruleWait); }
	 * 
	 * public void exceedNameValidate(String specialCharacter, String
	 * specialCharacterKey, By locator1, By locator2, String backSpaceKey, String
	 * lable, String specialCharErrorMsg, String backSpaceErrorMsg, By locator3)
	 * throws InterruptedException {
	 * 
	 * mandatoryFieldValidation(specialCharacter, specialCharacterKey, locator1,
	 * locator2, backSpaceKey, lable, specialCharErrorMsg, backSpaceErrorMsg,
	 * locator3);
	 * 
	 * driver.navigate().refresh(); Thread.sleep(3000); visible(driver, username,
	 * Constant.ruleWait); }
	 * 
	 * public boolean userNameWithMoreThan50Char(String exceedUserName, By locator2,
	 * String lable, String errorMess, SoftAssert soft) throws InterruptedException
	 * {
	 * 
	 * BaseSuite.
	 * reportLog("Entering the details of the UserName with more than 50 characters:::"
	 * );
	 * 
	 * clear_Click_SendKeys(driver, 30, username, exceedUserName);
	 * BaseSuite.reportLog("Entered Users name: " + exceedUserName);
	 * 
	 * String userNameErrmsg = getText(driver, locator2).trim();
	 * BaseSuite.validationReportLog("Retrived Message for " + lable + " field is :"
	 * + userNameErrmsg); BaseSuite.validationReportLog("Expected Message for " +
	 * lable + " field is :" + errorMess);
	 * 
	 * boolean status = false; if (!userNameErrmsg.isEmpty()) {
	 * soft.assertEquals(userNameErrmsg.trim(), errorMess.trim()); status = true;
	 * BaseSuite.validationReportLog(lable +
	 * "Field Error Message Successfully Matched"); } else {
	 * BaseSuite.reportFailLog(lable + "Field Error Message not Matched",
	 * "userNameWithMoreThan50Char"); } return status;
	 * 
	 * }
	 * 
	 * public boolean firstNameWithMoreThan50Char(String exceedFirstName, By
	 * locator2, String lable, String errorMess, SoftAssert soft) throws
	 * InterruptedException {
	 * 
	 * BaseSuite.
	 * reportLog("Entering the details of the First Name with more than 50 characters:::"
	 * );
	 * 
	 * clear_Click_SendKeys(driver, 30, firstname, exceedFirstName);
	 * BaseSuite.reportLog("Entered First name: " + exceedFirstName);
	 * 
	 * String firstNameErrmsg = getText(driver, locator2).trim();
	 * 
	 * BaseSuite.validationReportLog("Retrived Message for " + lable + " field is :"
	 * + firstNameErrmsg); BaseSuite.validationReportLog("Expected Message for " +
	 * lable + " field is :" + errorMess);
	 * 
	 * boolean status = false; if (!firstNameErrmsg.isEmpty()) {
	 * soft.assertEquals(firstNameErrmsg.trim(), errorMess.trim()); status = true;
	 * BaseSuite.validationReportLog(lable +
	 * "Field Error Message Successfully Matched"); } else {
	 * BaseSuite.reportFailLog(lable + "Field Error Message not Matched",
	 * "mandatoryField"); } return status;
	 * 
	 * }
	 * 
	 * public boolean lastNameWithMoreThan50Char(String exceedLastName, By locator2,
	 * String lable, String errorMess, SoftAssert soft) throws InterruptedException
	 * {
	 * 
	 * BaseSuite.
	 * reportLog("Entering the details of the First Name with more than 50 characters:::"
	 * );
	 * 
	 * clear_Click_SendKeys(driver, 30, lastname, exceedLastName);
	 * BaseSuite.reportLog("Entered Last name: " + exceedLastName);
	 * 
	 * String lastNameErrmsg = getText(driver, locator2).trim();
	 * 
	 * BaseSuite.validationReportLog("Retrived Message for " + lable + " field is :"
	 * + lastNameErrmsg); BaseSuite.validationReportLog("Expected Message for " +
	 * lable + " field is :" + errorMess);
	 * 
	 * boolean status = false; if (!lastNameErrmsg.isEmpty()) {
	 * soft.assertEquals(lastNameErrmsg.trim(), errorMess.trim()); status = true;
	 * BaseSuite.validationReportLog(lable +
	 * "Field Error Message Successfully Matched"); } else {
	 * BaseSuite.reportFailLog(lable + "Field Error Message not Matched",
	 * "mandatoryField"); } return status;
	 * 
	 * }
	 * 
	 * public void emailTextBoxWithValidDetails(String emailDetails) {
	 * BaseSuite.reportLog("Entering the details of the Email");
	 * 
	 * clear_Click_SendKeys(driver, 30, email, emailDetails);
	 * BaseSuite.reportLog("Entered Email : " + emailDetails);
	 * 
	 * if (isDisplayed(driver, EmailSpecialCharVal)) {
	 * BaseSuite.reportFailLog("Fetching invalid details", emailDetails); } else {
	 * BaseSuite.
	 * validationReportLog("Email text box field is accepting valid details");
	 * 
	 * } }
	 * 
	 * public void firstNameWithSpecialChar(String firstNameDetails) { BaseSuite.
	 * reportLog("Entering the details in the First name with different special characters"
	 * );
	 * 
	 * clear_Click_SendKeys(driver, 30, firstname, firstNameDetails);
	 * BaseSuite.reportLog("Entered special characters ::::   " + firstNameDetails);
	 * 
	 * if (isDisplayed(driver, ExceedCharValMsg)) { BaseSuite.
	 * reportFailLog("Unable to entered the special characters or First Name textbox limit exceed"
	 * , firstNameDetails); } else { BaseSuite.
	 * validationReportLog("First name text box field is accepting special characters"
	 * );
	 * 
	 * } }
	 * 
	 * public void lastNameWithSpecialChar(String lastNameDetails) { BaseSuite.
	 * reportLog("Entering the details in the Last name with different special characters"
	 * );
	 * 
	 * clear_Click_SendKeys(driver, 30, lastname, lastNameDetails);
	 * BaseSuite.reportLog("Entered special characters ::::   " + lastNameDetails);
	 * 
	 * if (isDisplayed(driver, ExceedCharValMsg)) { BaseSuite.
	 * reportFailLog("Unable to entered the special characters or Last Name textbox limit exceed"
	 * , lastNameDetails); } else { BaseSuite.
	 * validationReportLog("Last name text box field is accepting special characters"
	 * );
	 * 
	 * } }
	 * 
	 * public void firstNameWithBlankData(By locator1, By locator2, String
	 * keysToSend, SoftAssert soft, String lable, String errorMess) { BaseSuite.
	 * reportLog("Checking validation message for Firstname textbox with blank data"
	 * ); otherMandatoryField(driver, locator1, locator2, keysToSend, soft, lable,
	 * errorMess); BaseSuite.
	 * validationReportLog("First Name textbox is showing proper validation message "
	 * ); }
	 * 
	 * public void lastNameWithBlankData(By locator1, By locator2, String
	 * keysToSend, SoftAssert soft, String lable, String errorMess) { BaseSuite.
	 * reportLog("Checking validation message for LastName textbox with blank data"
	 * ); otherMandatoryField(driver, locator1, locator2, keysToSend, soft, lable,
	 * errorMess); BaseSuite.
	 * validationReportLog("Last Name textbox is showing proper validation message "
	 * ); }
	 * 
	 * public void userNameWithLowerCase(String userName, SoftAssert soft) throws
	 * Exception { searchUser(userName);
	 * 
	 * BaseSuite.reportLog("Checking the user name from the non-editable text field"
	 * ); String value =
	 * driver.findElement(By.xpath("//input[@aria-disabled=\"true\"]")).getAttribute
	 * ("value");
	 * 
	 * if (value.equals(userName.toLowerCase())) { soft.assertTrue(true);
	 * BaseSuite.reportLog("User name is showing in the lower case::::" + value);
	 * BaseSuite.
	 * validationReportLog("Username is showing in the lower case after revisiting the user"
	 * );
	 * 
	 * } else { BaseSuite.reportLog("User name is not showing in the proper format"
	 * + value); BaseSuite.reportFailLog("Username is not showing as expected",
	 * "userNameWithLowerCase"); }
	 * 
	 * }
	 * 
	 * public void userAssignWithoutGroupDetails(String userName, String
	 * assignGrpName, SoftAssert soft) throws Exception {
	 * 
	 * searchUser(userName);
	 * 
	 * BaseSuite.reportLog("Checking the Group tab"); isDisplayedInLoop(driver, 30,
	 * UserGroupTab); click(driver, UserGroupTab);
	 * BaseSuite.validationReportLog("Clicked on the Group tab");
	 * 
	 * BaseSuite.reportLog("Checking the Assign button"); isDisplayedInLoop(driver,
	 * 30, UserAssignBtn); click(driver, UserAssignBtn);
	 * BaseSuite.validationReportLog("Clicked on the Assign button");
	 * 
	 * BaseSuite.reportLog("Checking the Assign Grooup pane");
	 * isDisplayedInLoop(driver, 30, UserAssignGroupsLabel);
	 * 
	 * BaseSuite.reportLog("Checking the Add Group TextBox");
	 * isDisplayedInLoop(driver, 30, AddGroupTextBox);
	 * 
	 * BaseSuite.
	 * reportLog("Clicking assign group button without adding the group details");
	 * try { click(driver, UsersAssignGroupBtn);
	 * BaseSuite.validationReportLog("Clicked on the Assign Group button");
	 * Thread.sleep(2000);
	 * 
	 * captureToastMsg(driver, SelectGroupsToAssignMsg, toastMsgClosedBtn,
	 * SelectGroupsToAssignText, "Select groups to assign."); } catch (Exception e)
	 * { throw new
	 * Exception("Unable to get validation message while assigning group without group details"
	 * ); } }
	 * 
	 * // 2nd Code
	 * 
	 * 
	 * public void searchUser1(String User_search) throws Exception {
	 * 
	 * Thread.sleep(2000); BaseSuite.reportLog("Searching for User: " +
	 * User_search); isDisplayedInLoop(driver, 30, SearchBar); javascript(driver,
	 * "arguments[0].click();", SearchBar); clear(driver, SearchBar);
	 * 
	 * isDisplayedInLoop(driver, 30, SearchBar); BaseSuite.reportLog("Search Name");
	 * sendKeys(driver, SearchBar, User_search);
	 * BaseSuite.reportLog("Click On searched");
	 * 
	 * isDisplayedInLoop(driver, 30, SearchClick); javascript(driver,
	 * "arguments[0].click();", SearchClick);
	 * 
	 * }
	 * 
	 * public void searchUserAndClick(String User_search) throws Exception {
	 * 
	 * Thread.sleep(2000); BaseSuite.reportLog("Searching for User: " +
	 * User_search); isDisplayedInLoop(driver, 30, SearchBar); javascript(driver,
	 * "arguments[0].click();", SearchBar); clear(driver, SearchBar);
	 * 
	 * isDisplayedInLoop(driver, 30, SearchBar); BaseSuite.reportLog("Search Name");
	 * sendKeys(driver, SearchBar, User_search);
	 * BaseSuite.reportLog("Click On searched");
	 * 
	 * isDisplayedInLoop(driver, 30, SearchClick); javascript(driver,
	 * "arguments[0].click();", SearchClick);
	 * 
	 * try {
	 * 
	 * isDisplayedInLoop(driver, 30, SearchClick);
	 * 
	 * BaseSuite.reportLog("Click on Searched User"); click(driver,
	 * returnElement(searchList1, "$User", User_search)); Thread.sleep(2000);
	 * BaseSuite.reportLog("Clicked on User: " + User_search);
	 * BaseSuite.reportLog("User Details retrieved successfully for user " +
	 * User_search);
	 * 
	 * } catch (Exception e) { throw new Exception("User_search " + SearchClick +
	 * " not found"); } }
	 * 
	 * public void searchWorspaceAssignInUser(String User_search) throws Exception {
	 * 
	 * Thread.sleep(2000);
	 * BaseSuite.reportLog("Searching for workspace/account/group: " + User_search);
	 * isDisplayedInLoop(driver, 30, W_SearchBar); javascript(driver,
	 * "arguments[0].click();", W_SearchBar); clear(driver, W_SearchBar);
	 * 
	 * isDisplayedInLoop(driver, 30, W_SearchBar);
	 * BaseSuite.reportLog("Search Name"); sendKeys(driver, W_SearchBar,
	 * User_search); BaseSuite.reportLog("Click on searched");
	 * 
	 * isDisplayedInLoop(driver, 30, W_SearchClick); javascript(driver,
	 * "arguments[0].click();", W_SearchClick); }
	 * 
	 * public void createBlockedUserWithoutTempPass(String Username1, String
	 * BlockEmail, String BlockFirstName, String BlockLastName, String
	 * BlockPassword, String BlockConfirmPassword, String TemporaryPass1, String
	 * BlockedStatus, String Search_user1) throws Exception
	 * 
	 * { clickOnUsersMenu(); try {
	 * 
	 * BaseSuite.reportLog("Checking the New user button ");
	 * isDisplayedInLoop(driver, 30, NewUsersHeader);
	 * BaseSuite.reportLog("Click New user button "); clickOnNewButton(); //
	 * javascript(driver, "arguments[0].click();", NewUsersHeader); // click(driver,
	 * NewUsersHeader); BaseSuite.validationReportLog("New user page is opened");
	 * 
	 * BaseSuite.reportLog(":::Entering the details of the User:::");
	 * 
	 * clear_Click_SendKeys(driver, 30, username, Username1);
	 * BaseSuite.reportLog("Entered Users name: " + Username1);
	 * 
	 * clear_Click_SendKeys(driver, 30, email, BlockEmail);
	 * BaseSuite.reportLog("Entered Users Email: " + BlockEmail);
	 * 
	 * clear_Click_SendKeys(driver, 30, firstname, BlockFirstName);
	 * BaseSuite.reportLog("Entered Users FirstName: " + BlockFirstName);
	 * 
	 * clear_Click_SendKeys(driver, 30, lastname, BlockLastName);
	 * BaseSuite.reportLog("Entered Users LastName: " + BlockLastName);
	 * 
	 * clear_Click_SendKeys(driver, 30, password, BlockPassword);
	 * BaseSuite.reportLog("Entered Users Password: " + BlockPassword);
	 * 
	 * clear_Click_SendKeys(driver, 30, confirmpassword, BlockConfirmPassword);
	 * BaseSuite.reportLog("Entered Users ConfirmPassword: " +
	 * BlockConfirmPassword);
	 * 
	 * if (TemporaryPass1.equals("Yes")) {
	 * BaseSuite.reportLog("Temporary password is selected");
	 * BaseSuite.validationReportLog("Creating user with the Temporary password");
	 * 
	 * } else if (TemporaryPass1.equals("No")) { click(driver, TempPassWord_Yes);
	 * BaseSuite.reportLog("Clicked on Temporary password--No");
	 * BaseSuite.reportLog("Temporary password is not selected");
	 * BaseSuite.validationReportLog("Creating user without the Temporary password"
	 * ); } else {
	 * BaseSuite.reportLog("Unable to click on the Temporary password toggle button"
	 * ); } if (BlockedStatus.equals("No")) {
	 * BaseSuite.reportLog("Status as active is selected");
	 * BaseSuite.validationReportLog("Creating user with status as active");
	 * 
	 * } else if (BlockedStatus.equals("Yes")) { click(driver,
	 * StatusBlockTogButton); BaseSuite.reportLog("Clicked on status as Blocked");
	 * BaseSuite.reportLog("Status as blocked has been selected");
	 * BaseSuite.validationReportLog("Creating user with status as Blocked"); } else
	 * { BaseSuite.reportLog("Unable to click on the Status toggle button"); }
	 * 
	 * isDisplayedInLoop(driver, 30, clickonsave);
	 * BaseSuite.reportLog("Clicking on the user save button");
	 * clickOnSaveUserBtn(); // click(driver, clickonsave); //
	 * waitForElement(driver,userCreatedMsg);
	 * 
	 * // captureToastMsg(driver, CommonToastMsg, toastMsgClosedBtn1,
	 * userCreateText, // "User Created"); BaseSuite.
	 * validationReportLog("New user created with status as Blocked and without temporary password."
	 * ); clickOnUsersMenu(); BaseSuite.reportLog("Searching for created user");
	 * searchUser1(Search_user1); isDisplayedInLoop(driver, 20, Blocklabel); String
	 * Status = getText(driver, Blocklabel); if (Status.contains("Blocked")) {
	 * BaseSuite.
	 * validationReportLog("New user created with status as Blocked and without temporary password:"
	 * + Search_user1 + Status); } else { BaseSuite.validationReportLog(
	 * "New user not created with status as Blocked and without temporary password."
	 * ); } } catch (Exception e) { throw new
	 * AssertionError("Error occured in this method", e); } }
	 * 
	 * public void createBlockedUserWithTempPass(String Username2, String Email2,
	 * String FirstName2, String LastName2, String Password2, String
	 * ConfirmPassword2, String TemporaryPass2, String BlockedStatus2, String
	 * Search_user2) throws Exception
	 * 
	 * { clickOnUsersMenu(); try {
	 * 
	 * BaseSuite.reportLog("Checking the New user button ");
	 * isDisplayedInLoop(driver, 30, NewUsersHeader);
	 * BaseSuite.reportLog("Click New user button "); clickOnNewButton();
	 * 
	 * BaseSuite.validationReportLog("New user page is opened");
	 * 
	 * BaseSuite.reportLog(":::Entering the details of the User:::");
	 * 
	 * clear_Click_SendKeys(driver, 30, username, Username2);
	 * BaseSuite.reportLog("Entered Users name: " + Username2);
	 * 
	 * clear_Click_SendKeys(driver, 30, email, Email2);
	 * BaseSuite.reportLog("Entered Users Email: " + Email2);
	 * 
	 * clear_Click_SendKeys(driver, 30, firstname, FirstName2);
	 * BaseSuite.reportLog("Entered Users FirstName: " + FirstName2);
	 * 
	 * clear_Click_SendKeys(driver, 30, lastname, LastName2);
	 * BaseSuite.reportLog("Entered Users LastName: " + LastName2);
	 * 
	 * clear_Click_SendKeys(driver, 30, password, Password2);
	 * BaseSuite.reportLog("Entered Users Password: " + Password2);
	 * 
	 * clear_Click_SendKeys(driver, 30, confirmpassword, ConfirmPassword2);
	 * BaseSuite.reportLog("Entered Users ConfirmPassword: " + ConfirmPassword2);
	 * 
	 * if (TemporaryPass2.equals("Yes")) {
	 * 
	 * BaseSuite.reportLog("Temporary password is already selected");
	 * BaseSuite.validationReportLog("Creating user with the Temporary password");
	 * 
	 * } else if (TemporaryPass2.equals("No")) { click(driver, TempPassWord_Yes);
	 * BaseSuite.reportLog("Clicked on Temporary password--No");
	 * BaseSuite.reportLog("Temporary password is not selected");
	 * BaseSuite.validationReportLog("Creating user without the Temporary password"
	 * ); } else {
	 * BaseSuite.reportLog("Unable to click on the Temporary password toggle button"
	 * ); } if (BlockedStatus2.equals("No")) {
	 * BaseSuite.reportLog("Status as active is selected");
	 * BaseSuite.validationReportLog("Creating user with status as active");
	 * 
	 * } else if (BlockedStatus2.equals("Yes")) { click(driver,
	 * StatusBlockTogButton); BaseSuite.reportLog("Clicked on status as Blocked");
	 * BaseSuite.reportLog("Status as blocked has been selected");
	 * BaseSuite.validationReportLog("Creating user with status as Blocked"); } else
	 * { BaseSuite.reportLog("Unable to click on the Status toggle button"); }
	 * 
	 * isDisplayedInLoop(driver, 30, clickonsave);
	 * BaseSuite.reportLog("Clicking on the Save button..");
	 * isDisplayedInLoop(driver, 40, clickonsave); click(driver, clickonsave);
	 * BaseSuite.validationReportLog("Save button clicked successfully..");
	 * inVisible(driver, spinner, Constant.ruleWait); waitForElement(driver,
	 * userCreatedMsg); captureToastMsg(driver, userCreatedMsg, toastMsgClosedBtn1,
	 * userCreateText, "User Created"); driver.navigate().refresh();
	 * Thread.sleep(2000); BaseSuite.
	 * validationReportLog("New user created with status as Blocked and without temporary password."
	 * ); clickOnUsersMenu();
	 * 
	 * BaseSuite.reportLog("Searching for created user"); searchUser1(Search_user2);
	 * waitForElement(driver, Blocklabel); isDisplayedInLoop(driver, 30,
	 * Blocklabel); String Status = getText(driver, Blocklabel); if
	 * (Status.contains("Blocked")) { BaseSuite.
	 * validationReportLog("New user created with status as Blocked and without temporary password:"
	 * + Search_user2 + Status); } else { BaseSuite.validationReportLog(
	 * "New user not created with status as Blocked and without temporary password."
	 * ); }
	 * 
	 * } catch (Exception e) { throw new
	 * AssertionError("Error occured in this method", e); } }
	 * 
	 * public void searchCreatedUser(String User_search1) throws Exception {
	 * 
	 * clickOnUsersMenu();
	 * 
	 * BaseSuite.reportLog("Searching for User: " + User_search1);
	 * 
	 * isDisplayedInLoop(driver, 30, SearchBar);
	 * 
	 * javascript(driver, "arguments[0].click();", SearchBar);
	 * 
	 * clear(driver, SearchBar);
	 * 
	 * isDisplayedInLoop(driver, 30, SearchBar);
	 * 
	 * BaseSuite.reportLog("Search Name");
	 * 
	 * sendKeys(driver, SearchBar, User_search1);
	 * 
	 * BaseSuite.reportLog("Click On searched");
	 * 
	 * isDisplayedInLoop(driver, 30, SearchClick);
	 * 
	 * javascript(driver, "arguments[0].click();", SearchClick);
	 * 
	 * BaseSuite.validationReportLog("Found newly created user in the list");
	 * 
	 * isDisplayedInLoop(driver, 60, SearchClick);
	 * 
	 * String name = getText(driver, searchListed);
	 * 
	 * BaseSuite.reportLog("Try to print the name of newly created user"); //
	 * List<WebElement> Users = driver.findElements(searchList);
	 * 
	 * // for (int i = 0; i < Users.size(); i++) {
	 * 
	 * // get(i).getText();
	 * 
	 * if (User_search1.equalsIgnoreCase(name)) {
	 * BaseSuite.validationReportLog("Created user searched successfully:" + name);
	 * } else
	 * 
	 * {
	 * 
	 * BaseSuite.reportFailLog("Created user not getting displayed in the list",
	 * "searchCreatedUser"); }
	 * 
	 * isDisplayedInLoop(driver, 30, SearchBar); clear(driver, SearchBar);
	 * isDisplayedInLoop(driver, 30, SearchClick); javascript(driver,
	 * "arguments[0].click();", SearchClick); Thread.sleep(2000);
	 * clickOnUsersMenu();
	 * 
	 * }
	 * 
	 * public void userSearchWithPagination(String PaginationPoint) throws Exception
	 * {
	 * 
	 * try { Thread.sleep(1000); boolean flag = isDisplayed(driver, PaginationNext);
	 * if (flag) { BaseSuite.reportLog("Test"); if
	 * (PaginationPoint.equalsIgnoreCase(">")) { isDisplayedInLoop(driver, 30,
	 * PaginationNext); paginationAllSymbol(driver, PaginationNext, PaginationPre);
	 * BaseSuite.validationReportLog("Clicked on the Angular '< >' pagination icons"
	 * ); BaseSuite.
	 * validationReportLog("Angular Symbol Pagination working successfully"); } else
	 * if (PaginationPoint.equalsIgnoreCase("1")) { isDisplayedInLoop(driver, 20,
	 * PaginationNumNext); paginationAllSymbol(driver, PaginationNumNext,
	 * PaginationNumPre);
	 * BaseSuite.validationReportLog("Clicked on the Number '1 2' pagination icons"
	 * );
	 * BaseSuite.validationReportLog("Number Symbol Pagination working successfully"
	 * ); }
	 * 
	 * else if (PaginationPoint.equalsIgnoreCase(">|")) { isDisplayedInLoop(driver,
	 * 20, PaginationNumNext); paginationAllSymbol(driver, PaginationPageNext,
	 * PaginationPageLast); BaseSuite.
	 * validationReportLog("Clicked on the last and first page r '|< >|' pagination icons"
	 * ); BaseSuite.
	 * validationReportLog("Last and first page Symbol Pagination working successfully"
	 * ); }
	 * 
	 * else { BaseSuite.reportErrorLog("Pagination not working"); } } else {
	 * BaseSuite.validationReportLog("Pagination page is not available"); } } catch
	 * (Exception e) { throw new NoSuchElementException("Failed in pagination"); }
	 * 
	 * }
	 * 
	 * public void continueNext(String users, String sheetName, String string,
	 * ExtentTest test, int rowNumber, String e1, Logger log, String columnName,
	 * String string2) {
	 * 
	 * }
	 * 
	 * public void multipleUserBlock(String Block_users) throws Exception {
	 * clickOnUsersMenu(); try { isDisplayedInLoop(driver, 30, SelectCheckboxes);
	 * List<WebElement> UserList = driver.findElements(SelectCheckboxes); for (int i
	 * = 1; i < UserList.size() - 13; i++) { UserList.get(i).click(); }
	 * 
	 * if (!isSelected(driver, SelectCheckboxes)) {
	 * BaseSuite.validationReportLog("Multiple users selected successfully"); } else
	 * { BaseSuite.validationReportLog("Multiple users not selected"); }
	 * 
	 * if (isEnabled(driver, BlockUserHeader)) { javascript(driver,
	 * "arguments[0].click();", BlockUserHeader); BaseSuite.
	 * validationReportLog("Block user button is enabled and user able to click");
	 * javascript(driver, "arguments[0].click();", BlockYes); Thread.sleep(2000);
	 * captureToastMsg(driver, CommonToastMsg, toastMsgClosedBtn1, userBlockText,
	 * "Block users");
	 * BaseSuite.validationReportLog("Selected users has been blocked successfully"
	 * ); } else { BaseSuite.
	 * reportErrorLog("Block user button is disabled even after selection of users"
	 * ); } BaseSuite.
	 * reportLog("To check the status of block user serching for the current user."
	 * );
	 * 
	 * searchUser1(Block_users);
	 * 
	 * isDisplayedInLoop(driver, 40, searchListed);
	 * 
	 * // String username = getText(driver,searchList);
	 * 
	 * String blocklabel = getText(driver, Blocklabel);
	 * 
	 * BaseSuite.reportLog("Try to print the status of newly blocked user");
	 * 
	 * if (blocklabel.contains("Blocked")) { BaseSuite.validationReportLog(
	 * "User blocked successfully and status updated successfully as :" +
	 * blocklabel); } else
	 * 
	 * { BaseSuite.
	 * reportFailLog("Created user not getting blocked and status in not updated in the list"
	 * , "searchCreatedUser"); }
	 * 
	 * } catch (Exception e) { throw new
	 * AssertionError("Error occured in this method", e); }
	 * 
	 * }
	 * 
	 * public void allUserSelect() throws Exception { clickOnUsersMenu(); try {
	 * isDisplayedInLoop(driver, 30, SelectCheckboxes); List<WebElement> UserList =
	 * driver.findElements(SelectCheckboxes); int i = 0; UserList.get(i).click();
	 * BaseSuite.validationReportLog("Clicked on the select all user checkbox");
	 * 
	 * isDisplayedInLoop(driver, 30, SelectAllCheckboxes); if
	 * (!UserList.get(i).isSelected()) { isDisplayedInLoop(driver, 30,
	 * SelectAllCheckboxes); List<WebElement> UserList1 =
	 * driver.findElements(SelectAllCheckboxes); int a = UserList1.size() - 1;
	 * BaseSuite.validationReportLog(
	 * "All the checkboxes has been selected successfully and total number of selected users on 1st page are:"
	 * + a);
	 * 
	 * } else { BaseSuite.
	 * reportErrorLog("User not able to select all the users using all user checkbox"
	 * ); }
	 * 
	 * }
	 * 
	 * catch (Exception e) {
	 * BaseSuite.reportErrorLog("Multiple user selection function not working"); }
	 * clickOnGroupsMenu(); }
	 * 
	 * public void updateAzureADuser(String AzureADUser, String TemporaryPass2,
	 * String BlockedStatus2) throws Exception { clickOnUsersMenu(); try {
	 * isDisplayedInLoop(driver, 20, DeleteAzureADButton);
	 * searchUserAndClick(AzureADUser); inVisible(driver, spinner,
	 * Constant.ruleWait); waitForElement(driver, CommonToastMsg);
	 * captureToastMsg(driver, CommonToastMsg, toastMsgClosedBtn1,
	 * RetriveDetailsMsg, "Save User"); String fieldNames =
	 * "username/email/firstname/lastname/password/confirmpassword";
	 * Thread.sleep(2000); if ((!isEditable(driver, username, "Username")) &&
	 * (!isEditable(driver, email, "Email")) && (!isEditable(driver, firstname,
	 * "FirstName")) && (!isEditable(driver, lastname, "LastName")) &&
	 * (!isEditable(driver, password, "Password")) && (!isEditable(driver,
	 * confirmpassword, "ConfirmPassword"))) { BaseSuite.validationReportLog(
	 * "All fields are disabled and Admin user not able to enter any details in the fields:"
	 * + fieldNames); } else { BaseSuite.
	 * reportFailLog("Fields are enabled and admin user can able to update details",
	 * "updateAzureADuser"); } if (TemporaryPass2.equals("Yes")) {
	 * 
	 * BaseSuite.reportLog("Temporary password is already selected");
	 * BaseSuite.validationReportLog("User with the Temporary password");
	 * 
	 * } else if (TemporaryPass2.equals("No")) { click(driver, TempPassWord_Yes);
	 * BaseSuite.reportLog("Clicked on Temporary password--No");
	 * BaseSuite.reportLog("Temporary password is not selected");
	 * BaseSuite.validationReportLog("Updating user without the Temporary password"
	 * ); } else {
	 * BaseSuite.reportLog("Unable to click on the Temporary password toggle button"
	 * ); } if (BlockedStatus2.equals("No")) {
	 * BaseSuite.reportLog("Status as active is selected");
	 * BaseSuite.validationReportLog("Updating user with status as active");
	 * 
	 * } else if (BlockedStatus2.equals("Yes")) { isDisplayedInLoop(driver, 20,
	 * StatusBlockTogButton); click(driver, StatusBlockTogButton);
	 * BaseSuite.reportLog("Clicked on status as Blocked");
	 * BaseSuite.reportLog("Status as blocked has been selected");
	 * BaseSuite.validationReportLog("Updating user with status as Blocked"); } else
	 * { BaseSuite.reportLog("Unable to click on the Status toggle button"); }
	 * isDisplayedInLoop(driver, 40, clickonsave);
	 * BaseSuite.reportLog("Clicking on the user save button"); //
	 * clickOnSaveUserBtn(); click(driver, clickonsave); inVisible(driver, spinner,
	 * Constant.ruleWait); waitForElement(driver, CommonToastMsg);
	 * captureToastMsg(driver, CommonToastMsg, toastMsgClosedBtn1, updateAzureADMsg,
	 * "Save User"); BaseSuite.
	 * validationReportLog("User updated with status as Blocked and without temporary password."
	 * ); clickOnUsersMenu(); BaseSuite.reportLog("Searching for created user");
	 * searchUser1(AzureADUser); isDisplayedInLoop(driver, 20, Blocklabel); String
	 * Status = getText(driver, Blocklabel); if (Status.contains("Blocked")) {
	 * BaseSuite.validationReportLog(
	 * "AzureAD user only updated with status and temporary password: " +
	 * AzureADUser + Status); } else { BaseSuite.validationReportLog(
	 * "AzureAD user updated with status as Blocked and without temporary password."
	 * ); } isDisplayedInLoop(driver, 40, SearchBar); clear(driver, SearchBar);
	 * searchUserAndClick(AzureADUser); inVisible(driver, spinner,
	 * Constant.ruleWait); isDisplayedInLoop(driver, 30, StatusBlockedBtn);
	 * click(driver, StatusBlockedBtn); isDisplayedInLoop(driver, 30, clickonsave);
	 * click(driver, clickonsave); driver.navigate().refresh(); Thread.sleep(2000);
	 * 
	 * } catch (Exception e) { throw new
	 * AssertionError("Error occured in this method", e); } }
	 * 
	 * public void updateUser(String updatedemail, String updatedfirstname, String
	 * updatedlastname, String updatedpassword,
	 * 
	 * String updatedconfirmpassword, String tempPass, String status, String
	 * LocalUser_search) throws Exception { clickOnUsersMenu(); try {
	 * isDisplayedInLoop(driver, 20, SearchBar);
	 * searchUserAndClick(LocalUser_search); inVisible(driver, spinner,
	 * Constant.ruleWait); captureToastMsg(driver, CommonToastMsg,
	 * toastMsgClosedBtn1, RetriveDetailsMsg, "Retrive details");
	 * 
	 * isDisplayedInLoop(driver, 20, username);
	 * 
	 * if (!isEditable(driver, username, "Username")) { BaseSuite.
	 * validationReportLog("Username field is disabled user not able to update username field."
	 * ); } else {
	 * BaseSuite.reportFailLog("Username field is enabled so bug occured",
	 * "updateUser"); } if (isEditable(driver, email, "Email")) {
	 * clear_Click_SendKeys(driver, 3, email, updatedemail);
	 * BaseSuite.validationReportLog("Updated email is: " + updatedemail);
	 * 
	 * if (isEditable(driver, firstname, "FirstName")) {
	 * clear_Click_SendKeys(driver, 3, firstname, updatedfirstname);
	 * BaseSuite.validationReportLog("Updated firstname is: " + updatedfirstname);
	 * 
	 * if (isEditable(driver, lastname, "LastName")) { clear_Click_SendKeys(driver,
	 * 3, lastname, updatedlastname);
	 * BaseSuite.validationReportLog("Updated lastname is: " + updatedlastname);
	 * 
	 * if (isEditable(driver, password, "Password")) { clear_Click_SendKeys(driver,
	 * 3, password, updatedpassword);
	 * 
	 * if (isEditable(driver, confirmpassword, "Confirm Password")) {
	 * clear_Click_SendKeys(driver, 3, confirmpassword, updatedconfirmpassword);
	 * 
	 * BaseSuite.validationReportLog("All the user details has been updated ");
	 * 
	 * if (tempPass.equalsIgnoreCase("No")) { click(driver, ClickTempPass);
	 * BaseSuite.validationReportLog("User created with temporary password");
	 * 
	 * } else {
	 * BaseSuite.validationReportLog("User created without temporary password"); }
	 * if (status.equalsIgnoreCase("Active")) { BaseSuite.reportLog(
	 * "User clicked on the toggle button to make the status as blocked");
	 * isDisplayedInLoop(driver, 20, StatusToggleButton); click(driver,
	 * StatusToggleButton);
	 * BaseSuite.validationReportLog("User status updated as 'Blocked'"); } else {
	 * BaseSuite.validationReportLog("User status already is in 'Blocked' status");
	 * } } } } } }
	 * 
	 * else { BaseSuite.reportFailLog("Admin not able to update the user details",
	 * "updateUser"); } if (isEnabled(driver, SaveUserButton)) {
	 * isDisplayedInLoop(driver, 40, SaveUserButton); // clickOnSaveUserBtn();
	 * Thread.sleep(2000); click(driver, SaveUserButton); inVisible(driver, spinner,
	 * Constant.ruleWait); waitForElement(driver, toastMsgClosedBtn1);
	 * captureToastMsg(driver, CommonToastMsg, toastMsgClosedBtn1, toastUpdateMsg,
	 * "update user"); BaseSuite.validationReportLog("User updated successfully");
	 * driver.navigate().refresh(); Thread.sleep(2000);
	 * 
	 * } else {
	 * BaseSuite.reportFailLog("Save button in not enabled hence user not updated",
	 * "updateUser"); }
	 * 
	 * } catch (Exception e) { throw new
	 * AssertionError("Error occured in this method", e); } }
	 * 
	 * public void deleteAzureAdUser(String DeleteAzureADUser) throws Exception {
	 * clickOnUsersMenu(); try { inVisible(driver, spinner, Constant.ruleWait);
	 * searchUser1(DeleteAzureADUser); isDisplayedInLoop(driver, 40,
	 * SelectCheckboxes); List<WebElement> UserList =
	 * driver.findElements(SelectCheckboxes);
	 * 
	 * int i = 1;
	 * 
	 * if (i <= 1) { isDisplayedInLoop(driver, 40, SearchBar);
	 * UserList.get(i).click(); String Name = UserList.get(i).getText();
	 * BaseSuite.validationReportLog("AzureAd user selected successfully: " + Name);
	 * if (isEnabled(driver, DeleteUserHeader)) { isDisplayedInLoop(driver, 20,
	 * DeleteUserHeader); javascript(driver, "arguments[0].click();",
	 * DeleteUserHeader); javascript(driver, "arguments[0].click();",
	 * DeleteUserHeaderYes); inVisible(driver, spinner, Constant.ruleWait);
	 * Thread.sleep(2000); captureToastMsg(driver, CommonToastMsg,
	 * toastMsgClosedBtn1, toastDeleteAzureADMsg, "Delete AzureAD User");
	 * 
	 * BaseSuite.validationReportLog("AzureADUser deleted successfully."); } } else
	 * { BaseSuite.reportFailLog("AzureAD user not deleted", "deleteAzureAdUser"); }
	 * driver.navigate().refresh(); Thread.sleep(2000); } catch (Exception e) {
	 * throw new AssertionError("Error occured in this method", e); } } // need to
	 * 
	 * add specific user to delete in admin module-24/jan/22
	 * 
	 * public void deleteLocalUser(String DeleteLocalUser) throws Exception {
	 * clickOnUsersMenu(); try { searchUser1(DeleteLocalUser); Thread.sleep(2000);
	 * List<WebElement> UserList = driver.findElements(SelectCheckboxes); for(int
	 * i=1; i<=2; i++) //if (i <= 2) { isDisplayedInLoop(driver, 40,
	 * SelectCheckboxes); UserList.get(i).click(); String LocalUserName =
	 * UserList.get(i).getText();
	 * BaseSuite.validationReportLog("Local user selected successfully:" +
	 * LocalUserName);
	 * 
	 * }
	 * 
	 * if (isEnabled(driver, DeleteUserHeader)) { isDisplayedInLoop(driver, 20,
	 * DeleteUserHeader); javascript(driver, "arguments[0].click();",
	 * DeleteUserHeader); javascript(driver, "arguments[0].click();",
	 * DeleteUserHeaderYes); inVisible(driver, spinner, Constant.ruleWait);
	 * waitForElement(driver, toastMsgClosedBtn1); captureToastMsg(driver,
	 * CommonToastMsg, toastMsgClosedBtn1, toastDeleteLocaluser,
	 * "Delete Local User");
	 * 
	 * BaseSuite.validationReportLog("LocalUser deleted successfully."); } else {
	 * BaseSuite.reportFailLog("Local user not deleted", "deleteLocalUser"); }
	 * Thread.sleep(2000); }catch(
	 * 
	 * Exception e) { throw new AssertionError("Error occured in this method", e); }
	 * }
	 * 
	 * public void discardNewUser(String Username, String Email11, String FirstName,
	 * String LastName, String Password11, String ConfirmPassword11, String
	 * TemporaryPass, String DiscardalertYes) throws Exception { clickOnUsersMenu();
	 * try { inVisible(driver, spinner, Constant.ruleWait);
	 * BaseSuite.reportLog("Checking the New user button ");
	 * isDisplayedInLoop(driver, 30, NewUsersHeader);
	 * BaseSuite.reportLog("Click New user button "); // click(driver,
	 * NewUsersHeader); clickOnNewButton(); // javascript(driver,
	 * "arguments[0].click();", NewUsersHeader);
	 * BaseSuite.validationReportLog("New user page is opened");
	 * 
	 * BaseSuite.reportLog(":::Entering the details of the User:::");
	 * 
	 * clear_Click_SendKeys(driver, 30, username, Username);
	 * BaseSuite.reportLog("Entered Users name: " + Username);
	 * 
	 * clear_Click_SendKeys(driver, 30, email, Email11);
	 * BaseSuite.reportLog("Entered Users Email: " + Email11);
	 * 
	 * clear_Click_SendKeys(driver, 30, firstname, FirstName);
	 * BaseSuite.reportLog("Entered Users FirstName: " + FirstName);
	 * 
	 * clear_Click_SendKeys(driver, 30, lastname, LastName);
	 * BaseSuite.reportLog("Entered Users LastName: " + LastName);
	 * 
	 * clear_Click_SendKeys(driver, 30, password, Password11);
	 * BaseSuite.reportLog("Entered Users Password: " + Password11);
	 * 
	 * clear_Click_SendKeys(driver, 30, confirmpassword, ConfirmPassword11);
	 * BaseSuite.reportLog("Entered Users ConfirmPassword: " + ConfirmPassword11);
	 * 
	 * if (TemporaryPass.equals("Yes")) {
	 * BaseSuite.reportLog("Temporary password is selected");
	 * BaseSuite.validationReportLog("Creating user with the Temporary password");
	 * 
	 * } else if (TemporaryPass.equals("No")) { click(driver, TempPassWord_No);
	 * BaseSuite.reportLog("Clicked on Temporary password--No");
	 * BaseSuite.reportLog("Temporary password is not selected");
	 * BaseSuite.validationReportLog("Creating user without the Temporary password"
	 * ); } else {
	 * BaseSuite.reportLog("Unable to click on the Temporary password toggle button"
	 * ); } if (isEnabled(driver, DiscardButton)) { isDisplayedInLoop(driver, 30,
	 * DiscardButton); BaseSuite.reportLog("Clicking on the discard button");
	 * click(driver, DiscardButton);
	 * BaseSuite.validationReportLog("Discard alert message getting displayed");
	 * String discardmsg = getText(driver, DiscardMsg); if
	 * (DiscardalertYes.contains("Yes")) {
	 * BaseSuite.reportLog("Discarding user details with option 'Yes' ");
	 * click(driver, DiscardAlertYes);
	 * BaseSuite.validationReportLog("Alert message displaying successfully:" +
	 * discardmsg); } else {
	 * BaseSuite.reportLog("User not discarding new user details with option 'No");
	 * javascript(driver, "arguments[0].click();", DiscardAlertNo); }
	 * 
	 * BaseSuite.validationReportLog("New user details discarded successfully"); }
	 * else { BaseSuite.reportFailLog("Discard button not enabled",
	 * "discardNewUser"); } } catch (Exception e) { throw new
	 * AssertionError("Error occured in this method", e); } }
	 * 
	 * public void discardExistingUser(String Username, String Email, String
	 * FirstName, String LastName, String Password, String ConfirmPassword, String
	 * TemporaryPass, String DiscardalertYes, String User_search) throws Exception {
	 * clickOnUsersMenu(); try {
	 * BaseSuite.reportLog("Searching the existing user using search bar");
	 * searchUserAndClick(User_search); inVisible(driver, spinner,
	 * Constant.ruleWait); isDisplayedInLoop(driver, 20, lastname);
	 * captureToastMsg(driver, RetriverMsg, lastname, RetriveDetailsMsg,
	 * "Details retrive msg");
	 * BaseSuite.validationReportLog("existing user page is opened");
	 * 
	 * BaseSuite.reportLog(":::Entering the details of the User:::"); if
	 * (!isEditable(driver, username, "Username")) { BaseSuite.
	 * reportLog("Username field is disabled and user not enter any details in the field."
	 * ); } else { clear_Click_SendKeys(driver, 30, username, Username);
	 * BaseSuite.reportLog("Entered Users Username: " + Username); BaseSuite.
	 * reportFailLog("User able to enter the username details so test case should be failed"
	 * , "discardExistingUser"); } clear_Click_SendKeys(driver, 30, email, Email);
	 * BaseSuite.reportLog("Entered Users Email: " + Email);
	 * 
	 * clear_Click_SendKeys(driver, 30, firstname, FirstName);
	 * BaseSuite.reportLog("Entered Users FirstName: " + FirstName);
	 * 
	 * clear_Click_SendKeys(driver, 30, lastname, LastName);
	 * BaseSuite.reportLog("Entered Users LastName: " + LastName);
	 * 
	 * clear_Click_SendKeys(driver, 30, password, Password);
	 * BaseSuite.reportLog("Entered Users Password: " + Password);
	 * 
	 * clear_Click_SendKeys(driver, 30, confirmpassword, ConfirmPassword);
	 * BaseSuite.reportLog("Entered Users ConfirmPassword: " + ConfirmPassword);
	 * 
	 * if (TemporaryPass.equals("Yes")) {
	 * BaseSuite.reportLog("Temporary password is selected");
	 * BaseSuite.validationReportLog("Creating user with the Temporary password");
	 * 
	 * } else if (TemporaryPass.equals("No")) { click(driver, TempPassWord_No);
	 * BaseSuite.reportLog("Clicked on Temporary password--No");
	 * BaseSuite.reportLog("Temporary password is not selected");
	 * BaseSuite.validationReportLog("Creating user without the Temporary password"
	 * ); } else {
	 * BaseSuite.reportLog("Unable to click on the Temporary password toggle button"
	 * ); } if (isEnabled(driver, DiscardButton)) { isDisplayedInLoop(driver, 30,
	 * DiscardButton); BaseSuite.reportLog("Clicking on the discard button");
	 * click(driver, DiscardButton); // BaseSuite.validationReportLog("Discard alert
	 * message 'Are you sure, you want // to discard the changes?' message getting
	 * displayed"); String discardmsg = getText(driver, DiscardMsg);
	 * BaseSuite.validationReportLog("Alert message displaying successfully:" +
	 * discardmsg); if (DiscardalertYes.contains("Yes")) {
	 * BaseSuite.reportLog("Discarding user details with option 'Yes' ");
	 * click(driver, DiscardAlertYes);
	 * 
	 * } else { BaseSuite.
	 * reportLog("User not discarding existing user details with option 'No");
	 * javascript(driver, "arguments[0].click();", DiscardAlertNo); }
	 * 
	 * // captureToastMsg(driver, userCreatedMsg, toastMsgClosedBtn, userCreateText,
	 * // "User Discared details");
	 * BaseSuite.validationReportLog("Existing user details discarded successfully"
	 * ); } else { BaseSuite.reportFailLog("Discard button not enabled",
	 * "discardNewUser"); } } catch (Exception e) { throw new
	 * AssertionError("Error occured in this method", e); } }
	 * 
	 * public void workspaceAssignDetails(String Workspace_search, String
	 * User_search) throws Exception { clickOnUsersMenu(); try {
	 * searchUserAndClick(User_search); inVisible(driver, spinner,
	 * Constant.ruleWait); captureToastMsg(driver, CommonToastMsg,
	 * toastMsgClosedBtn1, toastRetriveMsg, "Existing user details");
	 * isDisplayedInLoop(driver, 20, WorkspaceLabel);
	 * BaseSuite.reportLog("Clicking on workspace label"); click(driver,
	 * WorkspaceLabel); inVisible(driver, spinner, Constant.ruleWait); BaseSuite.
	 * validationReportLog("User able to see the list of assigned wokspaces");
	 * String WorkspaceLabelsColumns = "Name /Role /Type /Account /Scope"; if
	 * ((isDisplayed(driver, WorkspaceNameLabel)) && (isDisplayed(driver,
	 * WorkspaceRoleLabel)) && (isDisplayed(driver, WorkspaceTypeLabel)) &&
	 * (isDisplayed(driver, WorkspaceAccountLabel)) && (isDisplayed(driver,
	 * WorkspaceScopeLabel))) { BaseSuite.validationReportLog(
	 * "In workspace section all the workspace labels name displaying successfully:"
	 * + WorkspaceLabelsColumns); } else {
	 * BaseSuite.reportFailLog("Workspace labels are not available",
	 * "workspaceAssignDetails"); } isDisplayedInLoop(driver, 40, W_SearchBar);
	 * BaseSuite.reportLog("Searching for assigned workspace");
	 * searchWorspaceAssignInUser(Workspace_search); Thread.sleep(2000); if
	 * (isAvailableInPage(driver, Workspace_search)) { isDisplayedInLoop(driver, 20,
	 * WorkspaceNameList); String Name = getText(driver, WorkspaceNameList); if
	 * (Name.equalsIgnoreCase(Workspace_search)) {
	 * 
	 * BaseSuite.validationReportLog(
	 * "In workspace section assigned workspace displaying successfully:" + Name); }
	 * else { BaseSuite.
	 * reportFailLog("Assigned workspace is not displaying in the under the workspace section"
	 * , "workspaceAssignDetails"); } } else { BaseSuite.reportFailLog(
	 * "Assigned workspace is not available in the list or page is not loading the workspace list"
	 * , "workspaceAssignDetails"); } } catch (Exception e) { throw new
	 * AssertionError("Error occured in this method", e); } }
	 * 
	 * public void accountAssignDetails(String Account_search, String User_search)
	 * throws Exception { clickOnUsersMenu(); try { searchUserAndClick(User_search);
	 * inVisible(driver, spinner, Constant.ruleWait); captureToastMsg(driver,
	 * CommonToastMsg, toastMsgClosedBtn1, toastRetriveMsg,
	 * "Existing user details"); isDisplayedInLoop(driver, 20, AccountLabel);
	 * BaseSuite.reportLog("Clicking on account label"); click(driver,
	 * AccountLabel); inVisible(driver, spinner, Constant.ruleWait); BaseSuite.
	 * validationReportLog("User able to see the list of assigned accounts"); String
	 * AccountLabelsColumns = "Name /Role /Scope"; if ((isDisplayed(driver,
	 * AccountNameLabel)) && (isDisplayed(driver, AccountRoleLabel)) &&
	 * (isDisplayed(driver, AccountScopeLabel))) { BaseSuite.
	 * validationReportLog("In account section all the account labels name displaying successfully:"
	 * + AccountLabelsColumns); } else {
	 * BaseSuite.reportFailLog("Account labels are not available",
	 * "accountAssignDetails"); } isDisplayedInLoop(driver, 40, W_SearchBar);
	 * BaseSuite.reportLog("Searching for assigned accounts");
	 * searchWorspaceAssignInUser(Account_search); Thread.sleep(2000); if
	 * (isAvailableInPage(driver, Account_search)) { isDisplayedInLoop(driver, 20,
	 * AccountNameList); String Name = getText(driver, AccountNameList); if
	 * (Name.equalsIgnoreCase(Account_search)) {
	 * 
	 * List<WebElement> WorkspaceListName = driver.findElements(WorkspaceNameList);
	 * 
	 * int i = 0; String Name = WorkspaceListName.get(i).getText();
	 * 
	 * BaseSuite.validationReportLog(
	 * "In account section assigned workspace displaying successfully:" + Name); } }
	 * else { BaseSuite.reportFailLog(
	 * "Assigned account is not available in the list under the account section or page is not loading the account list"
	 * , "accountAssignDetails"); } Thread.sleep(3000); } catch (Exception e) {
	 * throw new AssertionError("Error occured in this method", e); } }
	 * 
	 * public void groupAssignDetails(String Group_search, String User_search)
	 * throws Exception { clickOnUsersMenu(); try { searchUserAndClick(User_search);
	 * inVisible(driver, spinner, Constant.ruleWait); captureToastMsg(driver,
	 * CommonToastMsg, toastMsgClosedBtn1, toastRetriveMsg,
	 * "Existing user details"); isDisplayedInLoop(driver, 30, GroupLabel);
	 * BaseSuite.reportLog("Clicking on Group label"); click(driver, GroupLabel);
	 * inVisible(driver, spinner, Constant.ruleWait);
	 * BaseSuite.validationReportLog("User able to see the list of assigned groups"
	 * ); String GroupLabelsColumns = "Name /Path"; if ((isDisplayed(driver,
	 * GroupNameLabel)) && (isDisplayed(driver, GroupPathLabel))) {
	 * BaseSuite.validationReportLog(
	 * "In group section all the group labels name displaying successfully:" +
	 * GroupLabelsColumns); } else {
	 * BaseSuite.reportFailLog("Group labels are not available",
	 * "groupAssignDetails"); } isDisplayedInLoop(driver, 40, G_SearchBar);
	 * BaseSuite.reportLog("Searching for assigned group");
	 * searchGroupAssignInUser(Group_search); if (isAvailableInPage(driver,
	 * Group_search)) { waitForElement(driver, GroupNameList);
	 * isDisplayedInLoop(driver, 20, GroupNameList); String Name = getText(driver,
	 * GroupNameList); if (Name.equalsIgnoreCase(Group_search)) {
	 * 
	 * List<WebElement> WorkspaceListName = driver.findElements(WorkspaceNameList);
	 * 
	 * int i = 0; String Name = WorkspaceListName.get(i).getText();
	 * 
	 * BaseSuite.validationReportLog(
	 * "In group section assigned groups displaying successfully and assigned group is :"
	 * + Name); } } else { BaseSuite.reportFailLog(
	 * "Assigned group is not available in the list under the user/group section or page is not loading the group/user list"
	 * , "groupAssignDetails"); } } catch (Exception e) { throw new
	 * AssertionError("Error occured in this method", e); } }
	 * 
	 * // Neha's code // Method for save button should be enabled when user enter
	 * all details.
	 * 
	 * public void test(SoftAssert soft) {
	 * driver.findElement(BtnSave_newUser).isEnabled(); }
	 * 
	 * public void SaveButtonShouldBeEnabled(SoftAssert soft) {
	 * 
	 * // Click on user menu option log.info(
	 * "***********************************Method: SaveButtonShouldBeEnabled execution started***********************************"
	 * );
	 * 
	 * isDisplayedInLoop(driver, 30, UsersMenu);
	 * BaseSuite.reportLog("User menu is displayed"); javascript(driver,
	 * "arguments[0].click();", UsersMenu);
	 * BaseSuite.validationReportLog("Clicked on User menu."); // Check if new user
	 * button is displayed or not driver.manage().timeouts().implicitlyWait(30,
	 * TimeUnit.SECONDS); isDisplayedInLoop(driver, 20, NewUsersHeader);
	 * BaseSuite.reportLog("New User button is displayed."); javascript(driver,
	 * "arguments[0].click();", NewUsersHeader);
	 * BaseSuite.validationReportLog("New User button is clicked."); // wait for
	 * element to be displayed - username
	 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 * isDisplayedInLoop(driver, 30, UserUsername);
	 * BaseSuite.validationReportLog("New user details UI is displayed");
	 * log.info("--------------Username textbox is displayed---------------");
	 * soft.assertFalse(isEnabled(driver, BtnSave_newUser)); // To confirm that save
	 * button is disabled by // default if (!(isEnabled(driver, BtnSave_newUser))) {
	 * 
	 * log.info("--------------Inside if condition---------------"); BaseSuite.
	 * validationReportLog("Save button is disabled, entering the new user details"
	 * ); sendKeys(driver, UserUsername, "TestUsername");
	 * BaseSuite.reportLog("Username is entered"); sendKeys(driver, UserEmail,
	 * "Test@Email.com"); BaseSuite.reportLog("Email id is entered");
	 * sendKeys(driver, UFirstname, "Testfirstname");
	 * BaseSuite.reportLog("Firstname is entered"); sendKeys(driver, ULastname,
	 * "Testlastname"); BaseSuite.reportLog("Lastname is entered"); sendKeys(driver,
	 * UPassword, "12345"); BaseSuite.reportLog("Password is entered");
	 * sendKeys(driver, UCPassword, "12345");
	 * BaseSuite.reportLog("Confirm password is entered");
	 * 
	 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 * BaseSuite.reportLog("Verifying save button after entering all data.");
	 * 
	 * if (isEnabled(driver, BtnSave_newUser)) {
	 * log.info("--------------SaveButtonIsenabled---------------");
	 * soft.assertTrue(driver.findElement(BtnSave_newUser).isEnabled()); //
	 * validating save button is enabled. BaseSuite.
	 * validationReportLog("Save button is enabled after entring data in all text boxes"
	 * ); } else {
	 * log.info("--------------SaveButtonIsStillDisabled---------------");
	 * soft.assertTrue(driver.findElement(BtnSave_newUser).isEnabled());// failing
	 * the case if save button is // still disabled. BaseSuite.reportFailLog(
	 * "Save button is still disabled even after entering data in all textboxes hence testcase is failed "
	 * , "SaveButtonShouldBeEnabled"); }
	 * 
	 * }else
	 * 
	 * { BaseSuite.
	 * reportFailLog("Save button is by default enabled hence this case failed ",
	 * "SaveButtonShouldBeEnabled"); } // To discard new user page & go to user
	 * landing
	 * page.BaseSuite.reportLog("Discarding the changes made on user details page");
	 * if(isEnabled(driver, UDiscardBtn)) { isDisplayedInLoop(driver, 30,
	 * UDiscardBtn); javascript(driver, "arguments[0].click();", UDiscardBtn); //
	 * need to handle another pop-up options BaseSuite.
	 * reportLog("Discard activity successfull,navigating back to user page");
	 * isDisplayedInLoop(driver, 30, UDiscardYesOpt); javascript(driver,
	 * "arguments[0].click();", UDiscardYesOpt);
	 * 
	 * isDisplayed(driver, UsersMenu); // BaseSuite.reportLog("On User page");
	 * 
	 * } else { BaseSuite.
	 * reportFailLog("Another issue observed Discard button is not enabled",
	 * "SaveButtonShouldBeEnabled"); }
	 * 
	 * log.info(
	 * "***********************************Method: SaveButtonShouldBeEnabled execution Ended***********************************"
	 * ); }
	 * 
	 * // Testcase:- Verify 'blocked' & 'Delete' buttons are enabled if user is //
	 * selected.
	 * 
	 * public void BlockDeleteButtonEnabledifUserSelected(SoftAssert soft) throws
	 * InterruptedException
	 * 
	 * { log.info(
	 * "***********************************Method: BlockDeleteButtonVisibilityAsPerUserSelection execution started***********************************"
	 * ); isDisplayedInLoop(driver, 30, UsersMenu);
	 * BaseSuite.reportLog("User menu is displayed."); javascript(driver,
	 * "arguments[0].click();", UsersMenu);
	 * BaseSuite.validationReportLog("Clicked on User menu option.");
	 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 * 
	 * BaseSuite.reportLog("Verifying Block button is disabled or not.");
	 * //WebElement UBlock = driver.findElement(UBlockBtn);
	 * isDisplayedInLoop(driver, 20, UBlockBtn);
	 * System.out.println("Block button is displayed.");
	 * 
	 * //WebElement UDelete = driver.findElement(UDeleteBtn);
	 * isDisplayedInLoop(driver, 20, UDeleteBtn);
	 * System.out.println("Delete button is displayed.");
	 * 
	 * isDisplayedInLoop(driver, 30, UselectAllChk);
	 * 
	 * // declaring variable required for loop int count = 0, countOfCheck = 0,
	 * selectchk = 0;
	 * 
	 * Thread.sleep(3000);
	 * 
	 * WebElement selectAllUser = driver.findElement(UselectAllChk); WebElement
	 * label = driver.findElement(UlabelTUser); WebElement pageNo =
	 * driver.findElement(UlabelPages);
	 * 
	 * System.out.println("------" + pageNo.getText());
	 * 
	 * String totalNoUser = label.getText(); String[] userAvailable =
	 * totalNoUser.substring(1).split(" "); // total user available in nextgen app
	 * System.out.println("************* total user available = " +
	 * userAvailable[0]); int totalUser = Integer.parseInt(userAvailable[0]);
	 * 
	 * // Check block & delete button visibility by default
	 * 
	 * if (selectAllUser.isEnabled()) {
	 * log.info("---------------check select all checkbox -----------------"); //
	 * click(driver, UselectAllChk); javascript(driver, "arguments[0].click()",
	 * UselectAllChk);
	 * 
	 * if (selectAllUser.isSelected()) { log.
	 * info("---------------Verify select all check box is selected-----------------"
	 * ); // Verify block & delete button should be enabled if ((isEnabled(driver,
	 * UBlockBtn))&&(isEnabled(driver, UDeleteBtn))) {
	 * 
	 * soft.assertTrue(isEnabled(driver, UBlockBtn)&&isEnabled(driver, UDeleteBtn));
	 * BaseSuite.validationReportLog(
	 * "Block and delete both buttons are enabled when select all checkbox is checked for all users."
	 * ); log.info(
	 * "Block and delete both buttons are enabled when select all checkbox is checked for all users."
	 * ); javascript(driver, "arguments[0].click()", UselectAllChkF);
	 * log.info("-------Unchecked select all checkbox--------"); } } else { // Raise
	 * issue unable to check check box //
	 * soft.assertFalse(selectAllUser.isEnabled()); log.
	 * info("---------------Unable to check select all check box its issue-----------------"
	 * ); BaseSuite.reportFailLog("Unable to check checkbox",
	 * "verufyBlockDeleteButtonEnabledifUserSelected"); } }
	 * 
	 * // Verifying for any user selected from user listing
	 * 
	 * if ((!isEnabled(driver, UBlockBtn)) && (!isEnabled(driver, UDeleteBtn))) {
	 * BaseSuite.reportLog("Block & delete button is disabled.");
	 * BaseSuite.reportLog("Selecting user check box from list."); List<WebElement>
	 * chkValues = getElements(driver, USelectChk); count = chkValues.size();
	 * driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); // boolean
	 * checked = false; // Loop to check any user's check box is checked or not. for
	 * (int i = 0; i < count; i++)
	 * 
	 * { chkValues.get(i).click();
	 * BaseSuite.reportLog(" user check box is checked from list."); // Selected
	 * first checkbox & now verifying buttons if (isEnabled(driver, UBlockBtn) &&
	 * isEnabled(driver, UDeleteBtn)) { soft.assertTrue(isEnabled(driver, UBlockBtn)
	 * && isEnabled(driver, UDeleteBtn)); BaseSuite.validationReportLog(
	 * "Block & delete buttons are enabled after selecting single user from user listing."
	 * ); log.
	 * info("Block & delete button is enabled after selecting single user from user listing."
	 * ); chkValues.get(i).click(); break; }
	 * 
	 * }
	 * 
	 * } else { soft.assertFalse(isEnabled(driver, UBlockBtn) && isEnabled(driver,
	 * UDeleteBtn)); BaseSuite.
	 * reportFailLog("Block & delete buttons are enabled by default, need verification"
	 * , "verifyBlockNDeleteButtonsAreEnabledWhenUserIsSelected"); }
	 * 
	 * log.info("Redirecting to user page"); isDisplayedInLoop(driver, 30,
	 * UsersMenu); // javascript(driver, "arguments[0].click();", UsersMenu);
	 * click(driver, UsersMenu); // BaseSuite.reportLog("User menu is displayed.");
	 * log.
	 * info("********************************************************Method-BlockDeleteButtonVisibilityAsPerUserSelection excution Ended********************************************************"
	 * ); }
	 * 
	 * // Testcase:- Verify 'blocked' & 'Delete' buttons are disabled if none of the
	 * // user is selected.
	 * 
	 * public void BlockDeleteButtonDisableifNoUserSelected(SoftAssert soft) throws
	 * InterruptedException
	 * 
	 * {
	 * 
	 * log.info(
	 * "********************************************************Method-VerifyDelete&BlockBtnIsDisabled excution Started********************************************************"
	 * ); isDisplayedInLoop(driver, 30, UsersMenu);
	 * BaseSuite.reportLog("User menu is displayed."); javascript(driver,
	 * "arguments[0].click();", UsersMenu);
	 * BaseSuite.validationReportLog("Clicked on User menu.");
	 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 * 
	 * WebElement UBlock = driver.findElement(UBlockBtn); isDisplayedInLoop(driver,
	 * 20, UBlockBtn); System.out.println("Block button is displayed.");
	 * 
	 * WebElement UDelete = driver.findElement(UDeleteBtn);
	 * isDisplayedInLoop(driver, 20, UDeleteBtn);
	 * System.out.println("Delete button is displayed.");
	 * 
	 * isDisplayedInLoop(driver, 30, UselectAllChk);
	 * log.info("'Select all' user check box is diaplayed.");
	 * 
	 * Thread.sleep(3000); // driver.manage().timeouts().implicitlyWait(5,
	 * TimeUnit.MINUTES);
	 * 
	 * int count = 0; int countOfCheck = 0, selectchk = 0;
	 * 
	 * // WebElement label=
	 * driver.findElement(By.cssSelector("span.e-pagecountmsg")); WebElement
	 * selectAllUser = driver.findElement(UselectAllChk); // WebElement userCheckBox
	 * =driver.findElement() WebElement label = driver.findElement(UlabelTUser);
	 * WebElement pageNo = driver.findElement(UlabelPages); String[] pages =
	 * pageNo.getText().split(" "); System.out.println(
	 * "My total pages in pagination of user listing are " + pages[2] +
	 * "this is my first page" + pages[0]);
	 * 
	 * int startingpageNo = 0, endpageNo = 0;
	 * 
	 * endpageNo = Integer.parseInt(pages[2]); startingpageNo =
	 * Integer.parseInt(pages[0]);
	 * 
	 * System.out.println("------" + pageNo.getText());
	 * 
	 * String totalNoUser = label.getText(); String[] userAvailable =
	 * totalNoUser.substring(1).split(" "); // total user available in nextgen app
	 * System.out.println("************* total user available in application are " +
	 * userAvailable[0]);
	 * 
	 * // coverting string in to integer
	 * 
	 * int totalUser = Integer.parseInt(userAvailable[0]); //
	 * System.out.println("************* total user available = "+userA);
	 * BaseSuite.reportLog(
	 * "Verifying if 'select all' checkbox is checked, if yes then block & delete button should be enabled."
	 * ); BaseSuite.
	 * reportLog("Verifying if 'select all' user checkbox is enabled to select.");
	 * if (selectAllUser.isEnabled()) { BaseSuite.
	 * reportLog("Checkbox is enabled & clicking 'select all' user checkbox"); log.
	 * info("---------------Verify select all check box is selected-----------------"
	 * ); if (selectAllUser.isSelected()) {
	 * BaseSuite.reportLog("'Select all' user check box is checked."); // Verify
	 * block & delete button should be enabled if (UBlock.isEnabled() &&
	 * UDelete.isEnabled()) { soft.assertTrue(UBlock.isEnabled() &&
	 * UDelete.isEnabled()); BaseSuite.validationReportLog(
	 * "Block and delete both buttons are enabled as, 'select all' checkbox is checked for all users."
	 * ); log.info(
	 * "Block and delete both buttons are enabled as select all checkbox is checked for all users."
	 * ); } } else { // Verify it should be disabled if ((!UBlock.isEnabled()) &&
	 * (!UDelete.isEnabled())) {
	 * BaseSuite.validationReportLog("Select all check box is unchecked.");
	 * soft.assertFalse(UBlock.isEnabled() || UDelete.isEnabled());
	 * BaseSuite.validationReportLog("Block & Delete both buttons are disabled.");
	 * log.
	 * info("---------------Block & delete both button are disabled-----------------"
	 * ); } } }
	 * 
	 * BaseSuite.
	 * reportLog("Verifying no user is selected from total available user in available user listing."
	 * );
	 * 
	 * if (totalUser < 16)
	 * 
	 * { // Single cycle
	 * 
	 * if ((!UBlock.isEnabled()) && (!UDelete.isEnabled())) {
	 * soft.assertFalse(UBlock.isEnabled() || UDelete.isEnabled()); log.
	 * info("---------------Block & delete both button are disabled-----------------"
	 * ); BaseSuite.
	 * validationReportLog("Block & Delete both buttons are disabled by default.");
	 * BaseSuite.
	 * validationReportLog("Verifying is there is any user is selected from list or Not."
	 * );
	 * log.info("---------------waiting for page label to appear----------------");
	 * isDisplayedInLoop(driver, 30, UCountOfPages);
	 * log.info("--------------- page label to appear displayed ----------------");
	 * List<WebElement> chkValues = getElements(driver, USelectChk); // getting
	 * checkbox webelement for all // users boolean checked = false; count =
	 * chkValues.size(); driver.manage().timeouts().implicitlyWait(50,
	 * TimeUnit.SECONDS);
	 * 
	 * // Loop to check any user's check box is checked or not. for (int i = 0; i <
	 * count; i++)
	 * 
	 * { checked = chkValues.get(i).isSelected(); log.info("Checkbox at" + i +
	 * "th row is selected =" + checked); log.info("size of array=" + count);
	 * 
	 * if (checked == false) // Incremented if any user is not selected. {
	 * countOfCheck = countOfCheck + 1;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * log.info("None of the user is selected as count of User checkbox unchecked ="
	 * + countOfCheck + " & web element array count =" + count); BaseSuite.
	 * validationReportLog("None of the user is selected as count of User checkboxs unchecked are"
	 * + countOfCheck + " & Total User checkboxes available are" + count);
	 * 
	 * if (count == countOfCheck) { soft.assertEquals(count, countOfCheck);
	 * BaseSuite.
	 * validationReportLog("Block & Delete button is disabled as no user is selected. "
	 * ); } } else { if (UBlock.isEnabled()) { soft.assertFalse(UBlock.isEnabled());
	 * BaseSuite.reportFailLog(
	 * "Test case failed as block button is enabled even when user is not selected",
	 * "Verify block & delete button gets disable when no user selected"); } if
	 * (UDelete.isEnabled()) { soft.assertFalse(UDelete.isEnabled());
	 * BaseSuite.reportFailLog(
	 * "Test case failed as delete button is enabled even when user is not selected"
	 * , "Verify block & delete button gets disable when no user selected"); }
	 * 
	 * } }if(totalUser>15)
	 * 
	 * { // as more than one page data is available we need to check every page
	 * user's // check box
	 * 
	 * WebElement pageNextBtn = driver.findElement(UpaginationNextBtn); WebElement
	 * pageLastBtn = driver.findElement(UpaginationLastBtn); int totalUserCheckboxs
	 * = 0, totalcount = 0, j = 0, k = 0;
	 * 
	 * while (startingpageNo <= endpageNo) { if ((!UBlock.isEnabled()) &&
	 * (!UDelete.isEnabled())) { soft.assertFalse(UBlock.isEnabled() ||
	 * UDelete.isEnabled()); j++; log.
	 * info("---------------Block & delete both button are disabled for page of " +
	 * j + "-----------------");
	 * 
	 * BaseSuite.
	 * validationReportLog("Block & delete both buttons are disabled by default.");
	 * BaseSuite.
	 * validationReportLog("Verifying in any user is selected from list or Not.");
	 * log.info("---------------waiting for page label to appear----------------");
	 * isDisplayedInLoop(driver, 30, UCountOfPages);
	 * log.info("--------------- page label to appear displayed ----------------");
	 * 
	 * List<WebElement> chkValues = getElements(driver, USelectChk); count =
	 * chkValues.size(); boolean checked = false;
	 * driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); for (int i =
	 * 0; i < count; i++)
	 * 
	 * { checked = chkValues.get(i).isSelected(); k++; log.info("Checkbox at" + i +
	 * "th row is selected =" + checked); log.info("size of array=" + count);
	 * 
	 * if (checked == false) // Incremented if any user is not selected. {
	 * countOfCheck = countOfCheck + 1;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * log.info("count of User checkbox unchecked =" + countOfCheck +
	 * " & web element array count =" + count + "for first page of pagination=" +
	 * j); totalUserCheckboxs = countOfCheck; log.info("total user count =" + k); //
	 * log.info("Checking if last button is enabled ="+isEnabled(driver, //
	 * UpaginationLastBtn)); pages = pageNo.getText().split(" "); endpageNo =
	 * Integer.parseInt(pages[2]); startingpageNo = Integer.parseInt(pages[0]);
	 * 
	 * log.info("Checking if last button is enabled =" + pageNextBtn.isEnabled());
	 * if (startingpageNo != endpageNo) { click(driver, UpaginationNextBtn);
	 * 
	 * } if (startingpageNo == endpageNo) { log.
	 * info("None of the user is selected as count of user checkboxes unchecked are "
	 * + totalUserCheckboxs + " Total User checkboxes available are " + totalUser);
	 * BaseSuite.validationReportLog(
	 * "None of the user is selected as count of user checkboxs unchecked are " +
	 * totalUserCheckboxs + " Total User checkboxes available are " + totalUser); //
	 * soft.assertEquals(totalUser, totalUserCheckboxs); //
	 * BaseSuite.validationReportLog("Block & delete buttons are disabled, when none
	 * // of user is selected"); break; }
	 * 
	 * System.out.println("***inside ***My total pages in pagination are " +
	 * pages[2] + "this is my first page" + pages[0]); } else { if
	 * (UBlock.isEnabled()) { soft.assertFalse(UBlock.isEnabled());
	 * BaseSuite.reportFailLog(
	 * "Test case failed as block button is enabled even when user is not selected",
	 * "Verify block & delete button gets disable when no user selected"); log.
	 * info("Test case failed as block button is enabled even when user is not selected"
	 * ); } if (UDelete.isEnabled()) { soft.assertFalse(UDelete.isEnabled());
	 * BaseSuite.reportFailLog(
	 * "Test case failed as delete button is enabled even when user is not selected"
	 * , "Verify block & delete button gets disable when no user selected"); log.
	 * info("Test case failed as Delete button is enabled even when user is not selected"
	 * ); } } }
	 * 
	 * if (totalUserCheckboxs == k) { soft.assertTrue((!UBlock.isEnabled()) &&
	 * (!UDelete.isEnabled())); BaseSuite.
	 * validationReportLog("Block & delete buttons are disabled, when none of user is selected"
	 * );
	 * log.info("As none of the user is selected block & delete button is disabled"
	 * ); } log.
	 * info("*******************redirecting to user page*************************");
	 * isDisplayedInLoop(driver, 10, UsersMenu); click(driver, UsersMenu); log.info(
	 * "********************************************************Method-VerifyDelete&BlockBtnIsDisabled excution ended********************************************************"
	 * ); }
	 * 
	 * else { // Else condition if user count is failing for above two conditions
	 * log.
	 * info("*******************some issue observed kindly debug*************************"
	 * ); } }
	 * 
	 * public boolean verifyVisibilityOfTemporaryPasswordToggleButtons(WebDriver
	 * driver, By locator, String buttonName, boolean expected) { SoftAssert soft =
	 * new SoftAssert(); boolean status = false;
	 * BaseSuite.reportLog("Checking for button " + buttonName);
	 * waitForElement(driver, locator); String toggle = getText(driver, locator);
	 * 
	 * if (toggle.equalsIgnoreCase("Yes")) { status = true;
	 * 
	 * BaseSuite.validationReportLog(buttonName +
	 * " Toggle button is On in the page"); } else {
	 * 
	 * BaseSuite.validationReportLog(buttonName +
	 * " Toggle button is OFF in the page"); }
	 * 
	 * soft.assertEquals(status, expected);
	 * 
	 * return status; }
	 * 
	 * public boolean verifyVisibilityOfStatusToggleButtons(WebDriver driver, By
	 * locator, String buttonName, boolean expected) { SoftAssert soft = new
	 * SoftAssert(); boolean status = false;
	 * BaseSuite.reportLog("Checking for button " + buttonName);
	 * waitForElement(driver, locator); String toggle = getText(driver, locator);
	 * 
	 * if (toggle.equalsIgnoreCase("Active")) { status = true;
	 * 
	 * BaseSuite.validationReportLog(buttonName +
	 * " Toggle button is Active in the page"); } else {
	 * 
	 * BaseSuite.validationReportLog(buttonName +
	 * " Toggle button is Blocked in the page"); }
	 * 
	 * soft.assertEquals(status, expected);
	 * 
	 * return status; }
	 * 
	 * public void allUiElementsInNewUserPageFromAdminModule() { try {
	 * clickOnUsersMenu();
	 * 
	 * clickOnNewButton();
	 * 
	 * verifyVisibilityOfTemporaryPasswordToggleButtons(driver, tempPassWord,
	 * "Temporary Password", true);
	 * 
	 * verifyVisibilityOfStatusToggleButtons(driver, statusToggle, "Status", true);
	 * 
	 * isClickable(driver, tempPassWord, "Temporary Password", true);
	 * 
	 * isClickable(driver, statusToggle, "Status", true);
	 * 
	 * BaseSuite.reportLog("Click on Account from new User page");
	 * 
	 * displayAndClick(driver, toolbarAccounts);
	 * 
	 * BaseSuite.
	 * validationReportLog("Account clicked successfully from new User page");
	 * 
	 * BaseSuite.reportLog("Click on Workspace from new User page");
	 * 
	 * displayAndClick(driver, toolbarWorkspace);
	 * 
	 * BaseSuite.
	 * validationReportLog("Workspace clicked successfully from new User page");
	 * 
	 * BaseSuite.reportLog("Click on Groups from new User page");
	 * 
	 * displayAndClick(driver, toolbarGroups);
	 * 
	 * BaseSuite.
	 * validationReportLog("Groups clicked successfully from new User page");
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.getMessage(); }
	 * 
	 * }
	 * 
	 * public void allUiElementsWhenUserDetailsAreGettingUpdated(String user) { try
	 * {
	 * 
	 * clickOnUsersMenu();
	 * 
	 * searchUser(user);
	 * 
	 * isEditable(driver, username, "Username");
	 * 
	 * isEditable(driver, email, "Email");
	 * 
	 * isEditable(driver, firstname, "First Name");
	 * 
	 * isEditable(driver, lastname, "Last Name");
	 * 
	 * isEditable(driver, password, "Password");
	 * 
	 * isEditable(driver, confirmpassword, "Confirm Password");
	 * 
	 * isDisplayed(driver, TempPassWord_No);
	 * 
	 * BaseSuite.
	 * validationReportLog("Temporary Password toggle button is displayed in the page"
	 * );
	 * 
	 * isDisplayed(driver, statusToggle);
	 * 
	 * BaseSuite.validationReportLog("Status toggle button is displayed in the page"
	 * );
	 * 
	 * BaseSuite.reportLog("Click on Account from new User page");
	 * 
	 * displayAndClick(driver, toolbarAccounts);
	 * 
	 * BaseSuite.
	 * validationReportLog("Account clicked successfully from new User page");
	 * 
	 * BaseSuite.reportLog("Click on Workspace from new User page");
	 * 
	 * displayAndClick(driver, toolbarWorkspace);
	 * 
	 * BaseSuite.
	 * validationReportLog("Workspace clicked successfully from new User page");
	 * 
	 * BaseSuite.reportLog("Click on Groups from new User page");
	 * 
	 * displayAndClick(driver, toolbarGroups);
	 * 
	 * BaseSuite.
	 * validationReportLog("Groups clicked successfully from new User page");
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.getMessage(); }
	 * 
	 * }
	 * 
	 * public void allUiElementsOnUserListingPage() {
	 * 
	 * try { clickOnUsersMenu();
	 * 
	 * isClickable(driver, selectAllCheckbox, "SelectAll Check Box", true);
	 * 
	 * isClickable(driver, singleCheckbox, "Single Select Check Box", true);
	 * 
	 * } catch (InterruptedException e) {
	 * 
	 * e.getMessage(); } }
	 * 
	 * public void usersRefreshFunctionality() { try { clickOnUsersMenu();
	 * 
	 * displayAndClick(RefreshHeader);
	 * 
	 * boolean flag = isDisplayed(driver, spinner);
	 * 
	 * if (flag) { BaseSuite.
	 * validationReportLog("Referesh spinner is visible after clicking on Referesh button"
	 * ); } else { BaseSuite.
	 * reportFailLog("Referesh spinner is not visible after clicking on Referesh button"
	 * , "rolesRefereshFunctionality");
	 * 
	 * }
	 * 
	 * displayAndClick(selectAllCheckbox);
	 * 
	 * displayAndClick(RefreshHeader);
	 * 
	 * inVisible(driver, spinner, Constant.ruleWait);
	 * 
	 * boolean selectAllFlag = isSelected(driver, selectAllCheckbox);
	 * 
	 * if (selectAllFlag) { BaseSuite.reportFailLog(
	 * "Select all functionality is not getting unselect after clicking on Referesh button"
	 * , "rolesRefereshFunctionality");
	 * 
	 * } else { BaseSuite.validationReportLog(
	 * "Select all functionality is getting unselect after clicking on Referesh button"
	 * ); }
	 * 
	 * displayAndClick(singleCheckbox);
	 * 
	 * displayAndClick(RefreshHeader);
	 * 
	 * inVisible(driver, spinner, Constant.ruleWait);
	 * 
	 * boolean singleSelectFlag = isSelected(driver, selectAllCheckbox);
	 * 
	 * if (singleSelectFlag) { BaseSuite.reportFailLog(
	 * "Single Select functionality is not getting unselect after clicking on Referesh button"
	 * , "rolesRefereshFunctionality");
	 * 
	 * } else { BaseSuite.validationReportLog(
	 * "Single Select functionality is getting unselect after clicking on Referesh button"
	 * ); }
	 * 
	 * } catch (Exception e) { e.getMessage(); }
	 * 
	 * }
	 */

	/// User New Code/////

	public void clickOnUsersMenu() {

		try {

			clickOnButton(driver, usersMenu, "User Tab", true);

			inVisible(driver, spinner, Constant.ruleWait);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void clickOnAdministrationTab() {
		try {
			if (isDisplayed(driver, administrationButton)) {

				BaseSuite.reportLog("Clicking on  administration tab ..");

				displayAndClick(driver, administrationButton);

				BaseSuite.validationReportLog("Clicked on  administration tab successfully");

			} else {

				BaseSuite.reportFailLog("Administration tab not visible", "clickOnUserTab");

				throw new AssertionError();
			}
		} catch (Exception e) {

			e.getMessage();

			throw new AssertionError("Administration tab not visible");
		}

	}

	/** This method is use to click on new useser button **/
	public void clickOnNewButton() {

		try {
			clickOnButton(driver, newUsersButton, "New User", true);

			inVisible(driver, spinner, Constant.ruleWait);

			validateInputFields(driver, NewUserInput, 6);

			validateButtons(driver, NewUserButtons, 3);

			verifyIndividualLabel(driver, UserNameLabel, Constant.USERNAMELABLE);

			verifyIndividualLabel(driver, EmailLabel, Constant.EMAILLABLE);

			verifyIndividualLabel(driver, FirstNameLabel, Constant.FIRSTNAMELABLE);

			verifyIndividualLabel(driver, LastNameLabel, Constant.LASTNAMELABLE);

			verifyIndividualLabel(driver, userPasswordLabel, Constant.PASSWORDLABLE);

			verifyIndividualLabel(driver, userConfirmPasswordLabel, Constant.CONFIRMPASSWORDLABLE);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void searchUserOnLisitingPage(String userName) throws Exception {
		try {
			BaseSuite.reportLog("Entering User name on search box");

			click(driver, userSearchOnLisitingPage);

			clear(driver, userSearchOnLisitingPage);

			Thread.sleep(2000);

			sendKeys(driver, userSearchOnLisitingPage, userName);

			displayAndClick(driver, userSearchIconOnLisitingPage);

			inVisible(driver, spinner, Constant.ruleWait);

			BaseSuite.validationReportLog("User name entered successfully on search box");
		} catch (Exception e) {

			throw new Exception();
		}

	}

	public void clickOnSearchedUserName() throws Exception {
		try {

			BaseSuite.reportLog("Clicking on searched user name");

			displayAndClick(driver, userSearchNameClicked);

			inVisible(driver, spinner, Constant.ruleWait);

			BaseSuite.validationReportLog("Searched user name clicked successfully");

		} catch (Exception e) {

			throw new Exception();
		}

	}

	public void enterUserName(String value) {
		try {

			if (!value.isEmpty()) {

				BaseSuite.reportLog("Entering value on Usernme Field");

				clear_SendKeys(driver, userUsername, value);

				BaseSuite.validationReportLog("value entered successfully on Usernme Field");

				Thread.sleep(2000);

				String val = getText(driver, userNameBreadCrumb);

				if (val.equals(value)) {

					BaseSuite.validationReportLog("Entered User name value is visible on the breadcrumb");

				} else {

					BaseSuite.reportFailLog("Entered User name value not visible on the breadcrumb", "enterUserName");

				}
			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void enterInvalidUserName(String inputValue, SoftAssert soft) {

		String errorMess;
		try {

			int count = getcount(inputValue, '-');

			String[] result = inputValue.split("-");

			for (int colNum = 0; colNum <= count; colNum++) {

				String val = result[colNum];

				if (colNum == 1) {

					otherMandatoryField(driver, userUsername, mandatoryMess, val, soft, userNameLable,
							userNameRequiredMess);

				}

				else {

					clear(driver, userUsername);

					if (colNum == 0) {

						errorMess = maxCharacterExceededLimit;

					} else {

						errorMess = userNameSpecailCharMess;
					}

					specialCharaMandatoryField(driver, userUsername, mandatoryMess, val, soft, userNameLable,
							errorMess);

				}
			}

			displayAndClick(driver, discardButton);

			clickOnButton(driver, userDiscardBtnClickYes, "Discard Button", true);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void enterEmail(String value) {
		try {

			if (!value.isEmpty()) {
				BaseSuite.reportLog("Entering value on Email Field");

				clear_SendKeys(driver, userEmail, value);

				BaseSuite.validationReportLog("value entered successfully on Email Field");
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void enterInvalidEmail(String inputValue, String errorMess, SoftAssert soft) {
		try {

			int count = getcount(inputValue, '-');

			String[] result = inputValue.split("-");

			for (int colNum = 0; colNum <= count; colNum++) {

				String val = result[colNum];

				if (colNum == 0) {

					otherMandatoryField(driver, userEmail, mandatoryMess, val, soft, emailLable, emailNameRequiredMess);
				} else {

					clear(driver, userEmail);

					specialCharaMandatoryField(driver, userEmail, mandatoryMess, val, soft, emailLable,
							emailInvalidSyntexMess);
				}

			}

			displayAndClick(driver, discardButton);

			clickOnButton(driver, userDiscardBtnClickYes, "Discard Button", true);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void enterFirstName(String value) {
		try {
			if (!value.isEmpty()) {
				BaseSuite.reportLog("Entering value on First Name Field");

				clear_SendKeys(driver, userFirstname, value);

				BaseSuite.validationReportLog("value entered successfully on First Name Field");
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void enterInvalidFirstName(String inputValue, SoftAssert soft) {

		String errorMess;
		try {
			int count = getcount(inputValue, '-');

			String[] result = inputValue.split("-");

			for (int colNum = 0; colNum <= count; colNum++) {

				String val = result[colNum];
				{

					if (colNum == 1) {

						otherMandatoryField(driver, userFirstname, mandatoryMess, val, soft, firstNameLable,
								firstNameRequired);
					}

					else {

						clear(driver, userFirstname);

						if (colNum == 0) {

							errorMess = maxCharacterExceededLimit;

						} else if (colNum == 2) {

							errorMess = firstNameMaximumTwoCharMess;

						} else if (colNum == 3) {

							errorMess = firstNameMaximumTwoCharMess1;
						}

						else {

							errorMess = firstNameMaximumTwoCharMess2;
						}

						specialCharaMandatoryField(driver, userFirstname, mandatoryMess, val, soft, firstNameLable,
								errorMess);

					}
				}
			}

			displayAndClick(driver, discardButton);

			clickOnButton(driver, userDiscardBtnClickYes, "Discard Button", true);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void enterLastName(String value) {
		try {
			if (!value.isEmpty()) {
				BaseSuite.reportLog("Entering value on Last Name Field");

				clear_SendKeys(driver, userLastname, value);

				BaseSuite.validationReportLog("value entered successfully on Last Name Field");
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void enterInvalidLastName(String inputValue, SoftAssert soft) {

		String errorMess;

		try {
			int count = getcount(inputValue, '-');

			String[] result = inputValue.split("-");

			for (int colNum = 0; colNum <= count; colNum++) {

				String val = result[colNum];
				{

					if (colNum == 1) {

						otherMandatoryField(driver, userLastname, mandatoryMess, val, soft, lastNameLable,
								lastNameRequired);
					}

					else {

						clear(driver, userLastname);

						if (colNum == 0) {

							errorMess = maxCharacterExceededLimit;

						} else if (colNum == 2) {

							errorMess = firstNameMaximumTwoCharMess;

						} else if (colNum == 3) {

							errorMess = firstNameMaximumTwoCharMess1;
						}

						else {

							errorMess = firstNameMaximumTwoCharMess2;
						}

						specialCharaMandatoryField(driver, userLastname, mandatoryMess, val, soft, lastNameLable,
								errorMess);

					}
				}
			}

			displayAndClick(driver, discardButton);

			clickOnButton(driver, userDiscardBtnClickYes, "Discard Button", true);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void enterPassword(String value) {
		try {
			if (!value.isEmpty()) {
				BaseSuite.reportLog("Entering value on Password Field");

				clear_SendKeys(driver, userPassword, value);

				BaseSuite.validationReportLog("value entered successfully on Password Field");
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void enterInvalidPassword(String inputValue, SoftAssert soft) {
		String errorMess;
		try {
			int count = getcount(inputValue, '-');

			String[] result = inputValue.split("-");

			for (int colNum = 0; colNum <= count; colNum++) {

				String val = result[colNum];

				if (colNum == 1) {
					otherMandatoryField(driver, userPassword, mandatoryMess, val, soft, passwordLabel,
							passwordRequired);

				} else {
					clear(driver, userPassword);

					if (colNum == 0) {
						errorMess = maxCharacterExceededLimit;
					} else {

						errorMess = minimumEigthCharacter;
					}

					specialCharaMandatoryField(driver, userPassword, mandatoryMess, val, soft, passwordLabel,
							errorMess);
				}

			}

			displayAndClick(driver, discardButton);

			clickOnButton(driver, userDiscardBtnClickYes, "Discard Button", true);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void enterConfirmPassword(String value) {
		try {
			if (!value.isEmpty()) {
				BaseSuite.reportLog("Entering value on Confirm Password Field");

				clear_SendKeys(driver, userCPassword, value);

				BaseSuite.validationReportLog("value entered successfully on Confirm Password Field");
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void enterInvalidConfirmPassword(String inputValue, SoftAssert soft) {

		String errorMess;

		String saveMess = null;

		try {
			int count = getcount(inputValue, '-');

			String[] result = inputValue.split("-");

			for (int colNum = 0; colNum <= count; colNum++) {

				String val = result[colNum];

				if (colNum == 1) {

					otherMandatoryField(driver, userCPassword, mandatoryMess, val, soft, confirmPasswordLabel,
							passwordRequired);
				} else {

					clear(driver, userCPassword);

					if (colNum == 0) {

						errorMess = maxCharacterExceededLimit;

					} else {

						errorMess = minimumEigthCharacterConfirmPassword;
					}

					specialCharaMandatoryField(driver, userCPassword, mandatoryMess, val, soft, confirmPasswordLabel,
							errorMess);
				}

			}

			displayAndClick(driver, discardButton);

			clickOnButton(driver, userDiscardBtnClickYes, "Discard Button", true);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void assignButton() {
		try {

			javascript(driver, scrollToElementArg, userAssignBtn);

			clickOnButton(driver, userAssignBtn, "Assign button", true);

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void selectGroup(String val) {
		try {
			BaseSuite.reportLog("Selecting group");

			assignButton();

			int count = getcount(val, ',');

			String[] result = val.split(",");

			for (int colNum = 0; colNum <= count; colNum++) {

				String grp = result[colNum];

				if (colNum == 0) {

					verifyVisibilityOfButtons(driver, assignGroupPaneCancleButton, grp, true);

					verifyVisibilityOfButtons(driver, assignGroupPaneAssignButton, grp, false);

				}

				Thread.sleep(3000);
				
				displayAndClick(driver, addGroupTextBox);

				sendKeys(driver, addGroupTextBox, grp);

				Thread.sleep(3000);

				displayAndClick(driver, returnElement(selectGroup, "$name", grp));

				verifyVisibilityOfButtons(driver, assignGroupPaneCancleButton, grp, true);

				verifyVisibilityOfButtons(driver, assignGroupPaneAssignButton, grp, true);

				BaseSuite.validationReportLog(grp + " Group selected successfully");

			}

			displayAndClick(driver, assignGroupPaneAssignButton);

		} catch (Exception e) {

			throw new AssertionError("Not able to select the group,Kindly check!");
		}
	}

	public void clickOnSave(String mess) {
		try {
			clickOnButton(driver, userSaveButton, "Save Button", true);

			inVisible(driver, spinner, Constant.ruleWait);

			if (isDisplayed(driver, commonToastMsg)) {
				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, mess, "User save message");
			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void verifyFieldIsBlank(By locator, String label) {
		try {
			String val = getAttribute(driver, locator, "value");

			if (val.isEmpty()) {
				BaseSuite.validationReportLog(label + " field is balnk after click on save button");
			} else {
				BaseSuite.reportFailLog(label + " field is not balnk after click on save button,Kindly check !",
						"verifyFieldIsBlank");
			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void createUser(AdministrationParameters param, String icedqUser, String mess) throws InterruptedException {

		try {

			if (icedqUser.contains("account") || icedqUser.contains("workspace")) {

				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, userWhoDontHavePrivilegesMessage,
						"User who don't have privileges message");
			} else {
				clickOnUsersMenu();

				clickOnNewButton();

			//	verifyBreadCrumbs("Home", "Administration", "Users");

			//	verifyVisibilityOfButtons(driver, userSaveButton, "Save Button", false);

			//	verifyVisibilityOfButtons(driver, discardButton, "Discard button", false);

			//	verifyVisibilityOfButtons(driver, deleteButton, "Delete button", false);

				enterUserName(param.getUserNameVal());

				enterEmail(param.getEmailVal());

				enterFirstName(param.getFirstNameVal());

				enterLastName(param.getLastNameVal());

				enterPassword(param.getPasswordVal());

				enterConfirmPassword(param.getConfirmPasswordVal());

				verifyVisibilityOfButtons(driver, userSaveButton, "Save Button", true);

				verifyVisibilityOfButtons(driver, discardButton, "Discard button", true);

				clickOnSave(mess);

				verifyFieldIsBlank(userPassword, "Password");

				verifyFieldIsBlank(userCPassword, "ConfirmPassword");

				verifyVisibilityOfButtons(driver, userSaveButton, "Save Button", false);

				verifyVisibilityOfButtons(driver, discardButton, "Discard button", false);

				verifyVisibilityOfButtons(driver, assignAdminAccess, "Assign Admin Access", true);

				verifyVisibilityOfButtons(driver, deleteButton, "Delete button", true);

				verifyVisibilityOfButtons(driver, userAssignBtn, "Assign button", true);

				verifyVisibilityOfButtons(driver, userRefereshButtonInsideAssignPage, "Refresh button", true);
				
				if(Boolean.parseBoolean(param.getAdminFlag())) {
					
					clickOnButton(driver, usersDetailsAdminAccessButton, assignAdminAccessContent, true);
				}
			}

		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void createInvalidUser(AdministrationParameters param, String mess) throws InterruptedException {

		try {
			clickOnUsersMenu();

			clickOnNewButton();

			verifyBreadCrumbs("Home", "Administration", "Users");

			verifyVisibilityOfButtons(driver, userSaveButton, "Save Button", false);

			verifyVisibilityOfButtons(driver, discardButton, "Discard button", false);

			verifyVisibilityOfButtons(driver, deleteButton, "Delete button", false);

			enterUserName(param.getUserNameVal());

			enterEmail(param.getEmailVal());

			enterFirstName(param.getFirstNameVal());

			enterLastName(param.getLastNameVal());

			enterPassword(param.getPasswordVal());

			enterConfirmPassword(param.getConfirmPasswordVal());

			verifyVisibilityOfButtons(driver, userSaveButton, "Save Button", true);

			verifyVisibilityOfButtons(driver, discardButton, "Discard button", true);

			clickOnSave(mess);

			// verifyFieldIsBlank(userPassword, "Password");

			// verifyFieldIsBlank(userCPassword, "ConfirmPassword");

			displayAndClick(driver, discardButton);

			clickOnButton(driver, userDiscardBtnClickYes, "Discard Button", true);

		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void createInvalidUserWithSpeacilCharacter(AdministrationParameters param, SoftAssert soft)
			throws Exception {

		try {
			clickOnUsersMenu();

			clickOnNewButton();

			verifyBreadCrumbs("Home", "Administration", "Users");

			verifyVisibilityOfButtons(driver, userSaveButton, "Save Button", false);

			verifyVisibilityOfButtons(driver, discardButton, "Discard button", false);

			verifyVisibilityOfButtons(driver, deleteButton, "Delete button", false);

			enterInvalidUserName(param.getUserNameVal(), soft);

			enterInvalidEmail(param.getEmailVal(), param.getErrorMess(), soft);

			enterInvalidFirstName(param.getFirstNameVal(), soft);

			enterInvalidLastName(param.getLastNameVal(), soft);

			enterInvalidPassword(param.getPasswordVal(), soft);

			enterInvalidConfirmPassword(param.getConfirmPasswordVal(), soft);

			verifyVisibilityOfButtons(driver, userSaveButton, "Save Button", false);

			verifyVisibilityOfButtons(driver, discardButton, "Discard button", false);

			verifyVisibilityOfButtons(driver, deleteButton, "Delete button", false);

		} catch (Exception e) {

			throw new Exception();
		}
	}

	public boolean updateUser(AdministrationParameters param) throws Exception {
		boolean status = false;

		try {
			if (isDisplayed(driver, commonToastMsg)) {

				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, userWhoDontHavePrivilegesMessage,
						"User who don't have privileges message");
			} else {
				clickOnUsersMenu();

				searchUserOnLisitingPage(param.getUserNameVal());

				clickOnSearchedUserName();

				verifyVisibilityOfButtons(driver, userSaveButton, "Save Button", false);

				verifyVisibilityOfButtons(driver, discardButton, "Discard button", false);

				verifyVisibilityOfButtons(driver, assignAdminAccess, "Assign Admin Access", true);

				verifyVisibilityOfButtons(driver, deleteButton, "Delete button", true);

				verifyVisibilityOfButtons(driver, userAssignBtn, "Assign button", true);

				verifyVisibilityOfButtons(driver, userRefereshButtonInsideAssignPage, "Refresh button", true);

				verifyFieldIsBlank(userPassword, "Password");

				verifyFieldIsBlank(userCPassword, "ConfirmPassword");

				isEditable(driver, userUsername, "UserName");

				verifyRetrivedValues(driver, userUsername, "User Name", "value", param.getUserNameVal().toLowerCase());

				enterEmail(param.getEmailVal());

				enterFirstName(param.getFirstNameVal());

				enterLastName(param.getLastNameVal());

				enterPassword(param.getPasswordVal());

				enterConfirmPassword(param.getConfirmPasswordVal());

				verifyVisibilityOfButtons(driver, userSaveButton, "Save Button", true);

				verifyVisibilityOfButtons(driver, discardButton, "Discard button", true);

				clickOnSave(userCreateText);

				verifyFieldIsBlank(userPassword, "Password");

				verifyFieldIsBlank(userCPassword, "ConfirmPassword");

				verifyVisibilityOfButtons(driver, userSaveButton, "Save Button", false);

				verifyVisibilityOfButtons(driver, discardButton, "Discard button", false);

				verifyVisibilityOfButtons(driver, assignAdminAccess, "Assign Admin Access", true);

				verifyVisibilityOfButtons(driver, deleteButton, "Delete button", true);

				verifyVisibilityOfButtons(driver, userAssignBtn, "Assign button", true);

				verifyVisibilityOfButtons(driver, userRefereshButtonInsideAssignPage, "Refresh button", true);
			}

			status = true;

		} catch (Exception e) {

			status = false;

			throw new Exception();

		}
		return status;
	}

	public void veiwUserDetail(AdministrationParameters param) throws Exception {

		try {

			if (isDisplayed(driver, commonToastMsg)) {

				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, userWhoDontHavePrivilegesMessage,
						"User who don't have privileges message");
			} else {
				clickOnUsersMenu();

				searchUserOnLisitingPage(param.getUserNameVal());

				clickOnSearchedUserName();

				verifyUserDetailPage(param);

				verifyAddedGroupFromUserTab(param.getGropDetail());
				inVisible(driver, spinner, Constant.ruleWait);

				verifyAddedAccountFromUserTab(param.getAccountDetail());
				inVisible(driver, spinner, Constant.ruleWait);

				verifyAddedWorkspaceFromUserTab(param.getWorkspaceDetail());
				inVisible(driver, spinner, Constant.ruleWait);

			}

		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void assignGroupFunctionalityToUser(AdministrationParameters param) {
		try {
			if (isDisplayed(driver, commonToastMsg)) {

				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, userWhoDontHavePrivilegesMessage,
						"User who don't have privileges message");
			} else {
				clickOnUsersMenu();

				searchUserOnLisitingPage(param.getUserNameVal());

				clickOnSearchedUserName();

				verifyUserDetailPage(param);

				selectGroup(param.getAssignGroup());

				verifyAddedGroupFromUserTab(param.getGropDetail());
				inVisible(driver, spinner, Constant.ruleWait);
				
				verifyAddedAccountFromUserTab(param.getAccountDetail());
				inVisible(driver, spinner, Constant.ruleWait);

				verifyAddedWorkspaceFromUserTab(param.getWorkspaceDetail());
				inVisible(driver, spinner, Constant.ruleWait);
			}

		} catch (Exception e) {

			throw new AssertionError();
		}
	}

	public void invalidAssignGroupFunctionalityToUser(AdministrationParameters param) {
		try {
			clickOnUsersMenu();

			searchUserOnLisitingPage(param.getUserNameVal());

			clickOnSearchedUserName();

			// verifyUserDetailPage(param);

			int count = getcount(param.getAssignGroup(), ',');

			String[] result = param.getAssignGroup().split(",");

			for (int colNum = 0; colNum <= count; colNum++) {

				String group = result[colNum];

				if (colNum == 0) {

					selectGroup(group);

					searchGroup(group);

					List<WebElement> ele = getElements(driver, assignedGroupListName);

					int count1 = ele.size();

					if (count1 == 1) {
						BaseSuite.validationReportLog(
								"Group assigned only one time if we added same group name repeatedly");

					} else {
						BaseSuite.reportFailLog("Group assigned multiple times if we added same group name repeatedly",
								"invalidAssignGroupFunctionalityToUser");
					}

					displayAndClick(driver, groupRefreshButton);

				} else if (colNum == 1) {

					assignButton();

					displayAndClick(driver, addGroupTextBox);

					sendKeys(driver, addGroupTextBox, group);

					// Thread.sleep(3000);

					verifyVisibilityOfButtons(driver, assignGroupPaneCancleButton, "Cancel Button", true);

					verifyVisibilityOfButtons(driver, assignGroupPaneAssignButton, "Assign Button", false);

					String val = getText(driver, groupSearchNoRecord);

					if (val.equalsIgnoreCase(invalidGroupMess)) {
						BaseSuite.validationReportLog(
								"When entered invalid group/non exsisting group no record found text is displayed");
					} else {
						BaseSuite.reportFailLog(
								"When entered invalid group/non exsisting group no record found text is not displayed",
								"invalidAssignGroupFunctionalityToUser");

					}

					displayAndClick(driver, assignGroupPaneCancleButton);

				}

			}

		} catch (Exception e) {

			throw new AssertionError();
		}
	}

	public void removeGroupFunctionalityToUser(AdministrationParameters param) {
		try {
			if (isDisplayed(driver, commonToastMsg)) {

				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, userWhoDontHavePrivilegesMessage,
						"User who don't have privileges message");
			} else {
				searchUserOnLisitingPage(param.getUserNameVal());

				clickOnSearchedUserName();

				verifyUserDetailPage(param);

				removeGroupFromUserTab(param.getAssignGroup());
				
				inVisible(driver, spinner, Constant.ruleWait);
				
				clickOnButton(driver, userBreadCrumb, "Users Breadcrumb", true);
				inVisible(driver, spinner, Constant.ruleWait);
			}

		} catch (Exception e) {

			throw new AssertionError();
		}
	}

	public void verifyUserDetailPage(AdministrationParameters param) {

		try {
			verifyVisibilityOfButtons(driver, userSaveButton, "Save Button", false);

			verifyVisibilityOfButtons(driver, discardButton, "Discard button", false);

			verifyVisibilityOfButtons(driver, assignAdminAccess, "Assign Admin Access", true);

			verifyVisibilityOfButtons(driver, deleteButton, "Delete button", true);

			verifyVisibilityOfButtons(driver, userAssignBtn, "Assign button", true);

			verifyVisibilityOfButtons(driver, userRefereshButtonInsideAssignPage, "Refresh button", true);

			verifyRetrivedValues(driver, userUsername, "User Name", "value", param.getUserNameVal().toLowerCase());

			verifyRetrivedValues(driver, userEmail, "Email", "value", param.getEmailVal().toLowerCase());

			verifyRetrivedValues(driver, userFirstname, "First Name", "value", param.getFirstNameVal());

			verifyRetrivedValues(driver, userLastname, "Last Name", "value", param.getLastNameVal());

			verifyFieldIsBlank(userPassword, "Password");

			verifyFieldIsBlank(userCPassword, "ConfirmPassword");

		} catch (Exception e) {

			throw new AssertionError("Not able to validate user detail page");
		}

	}

	public void verifyAssignAdminAccess(AdministrationParameters param, int col) {
		try {
			if (isDisplayed(driver, commonToastMsg)) {

				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, userWhoDontHavePrivilegesMessage,
						"User who don't have privileges message");
			} else {

				if (col == 0) {

					clickOnUsersMenu();

					searchUserOnLisitingPage(param.getUserNameVal());

					clickOnSearchedUserName();

					BaseSuite.reportLog(
							"Verifying visibility of Assign Admin Access button and Delete button for Super Admi User "
									+ param.getUserNameVal());

					verifyVisibilityOfButtons(driver, assignAdminAccessButtonForSuperUser, "Assign Admin Access",
							false);

					verifyVisibilityOfButtons(driver, deleteButton, "Delete button", false);

					BaseSuite.validationReportLog(
							"Visibility of Assign Admin Access button and Delete button for Super Admin User is verified "
									+ param.getUserNameVal());

				}

				else if (col == 1) {

					BaseSuite.reportLog("Verifying assign admin access using application admin user");

					int count = getcount(param.getUserNameVal(), ',');

					String[] result = param.getUserNameVal().split(",");

					for (int colNum = 0; colNum <= count; colNum++) {

						String userName = result[colNum];

						clickOnUsersMenu();

						searchUserOnLisitingPage(userName);

						clickOnSearchedUserName();

						if (isDisplayed(driver, adminBadge)) {

							click(driver, revokeAdminAccessButton);
							
							
							
							
							throw new AssertionError(
									param.getUserNameVal() + " User name already assigned admin access,Kindly check!");

						}

						else {

							assignAdminAccess(userName);

							boolean flag = isDisplayed(driver, revokeAdminAccessButton);

							if (flag) {
								BaseSuite.validationReportLog(
										"Assign admin access button change to Revoke access button after clicked on it");
							} else {
								BaseSuite.reportFailLog(
										"Not able to change the Assign admin access button to Revoke admin access button after clicked on it",
										"verifyAssignAdminAccess");

							}

						}
					}

				} else {
					LoginPage lp = new LoginPage(driver);

					lp.logOut();

					boolean loginflag = lp.loginWithIcedqUserAndSelectWorkspace(ConstantProperty.ICEDQ_SUPERADMINUSER,
							"", ConstantProperty.MODULENAME_ADMINISTRATION, "");

					if (loginflag) {
						BaseSuite.reportLog("Verifying assign admin access using super admin user");

						clickOnUsersMenu();

						searchUserOnLisitingPage(param.getUserNameVal());

						clickOnSearchedUserName();

						if (isDisplayed(driver, adminBadge)) {

							throw new AssertionError(
									param.getUserNameVal() + " User name already assigned admin access,Kindly check!");

						}

						else {

							assignAdminAccess(param.getUserNameVal());

							boolean flag = isDisplayed(driver, revokeAdminAccessButton);

							if (flag) {
								BaseSuite.validationReportLog(
										"Assign admin access button change to Revoke access button after clicked on it");
							} else {
								BaseSuite.reportFailLog(
										"Not able to change the Assign admin access button to Revoke admin access button after clicked on it",
										"verifyAssignAdminAccess");

							}

						}

					} else {
						throw new AssertionError("Not able to login using super admi credentials,Kindly check!");
					}
				}
			}
		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void invalidAssignAdminAccess(AdministrationParameters param) throws Exception {
		try {
			createUser(param, ConstantProperty.ICEDQ_ADMINUSER, userCreateText);

			assignAdminAccess(param.getUserNameVal());

			LoginPage lp = new LoginPage(driver);

			lp.logOut();

			enterValueToTextField(driver, userNameLogin, "Username", param.getUserNameVal());

			Thread.sleep(2000);

			enterValueToTextField(driver, passWord, "Password", param.getPasswordVal());

			clickOnButton(driver, signin, "Sign In", true);

			sendKeys(driver, newPssword, param.getPasswordVal());

			sendKeys(driver, confirmPssword, param.getConfirmPasswordVal());

			clickOnButton(driver, sumitButton, "Submit", true);

			BaseSuite.reportLog("Checking for the Administration service");

			displayAndClick(driver, AdministrationLabel);

			BaseSuite.validationReportLog("Clicked on the Administration service!!");

			searchUserOnLisitingPage(param.getUserNameVal());

			clickOnSearchedUserName();

			verifyUserDetailPage(param);

			deleteUserFromDetailPage();

			if (isDisplayed(driver, toolbarText)) {
				BaseSuite.validationReportLog(
						"No records is visible on user page after assigning the admin access to the user and deleteed it by itself");
			} else {
				BaseSuite.reportFailLog(
						"Records is visible on user page after assigning the admin access to the user and deleteed it by itself",
						"invalidAssignAdminAccess");
			}

			displayAndClick(driver, groupTab);

			inVisible(driver, spinner, Constant.ruleWait);

			if (isDisplayed(driver, toolbarText)) {
				BaseSuite.validationReportLog(
						"No records is visible on group page after assigning the admin access to the user and deleteed it by itself");
			} else {
				BaseSuite.reportFailLog(
						"Records is visible on group page after assigning the admin access to the user and deleteed it by itself",
						"invalidAssignAdminAccess");
			}

			displayAndClick(driver, rolesTab);

			inVisible(driver, spinner, Constant.ruleWait);

			if (isDisplayed(driver, toolbarText)) {
				BaseSuite.validationReportLog(
						"No records is visible on roles page after assigning the admin access to the user and deleteed it by itself");
			} else {
				BaseSuite.reportFailLog(
						"Records is visible on roles page after assigning the admin access to the user and deleteed it by itself",
						"invalidAssignAdminAccess");
			}

			displayAndClick(driver, accountTab);

			inVisible(driver, spinner, Constant.ruleWait);

			if (isDisplayed(driver, toolbarText)) {
				BaseSuite.validationReportLog(
						"No records is visible on accounts page after assigning the admin access to the user and deleteed it by itself");
			} else {
				BaseSuite.reportFailLog(
						"Records is visible on accounts page after assigning the admin access to the user and deleteed it by itself",
						"invalidAssignAdminAccess");
			}

			displayAndClick(driver, workspaceTab);

			inVisible(driver, spinner, Constant.ruleWait);

			if (isDisplayed(driver, toolbarText)) {
				BaseSuite.validationReportLog(
						"No records is visible on workspaces page after assigning the admin access to the user and deleteed it by itself");
			} else {
				BaseSuite.reportFailLog(
						"Records is visible on workspaces page after assigning the admin access to the user and deleteed it by itself",
						"invalidAssignAdminAccess");
			}

		} catch (InterruptedException e) {

			throw new AssertionError();
		}

	}

	public void verifyRevokeAdminAccess(AdministrationParameters param, int col) {
		try {
			if (isDisplayed(driver, commonToastMsg)) {

				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, userWhoDontHavePrivilegesMessage,
						"User who don't have privileges message");
			} else {

				if (col == 0) {

					BaseSuite.reportLog("Verifying revoke assigned admin sccess using application admin user");

					clickOnUsersMenu();

					searchUserOnLisitingPage(param.getUserNameVal());

					clickOnSearchedUserName();

					BaseSuite.reportLog(
							"Verifying visibility of Assign Admin Access button and Delete button for Super Admi User "
									+ param.getUserNameVal());

					verifyVisibilityOfButtons(driver, assignAdminAccessButtonForSuperUser, "Assign Admin Access",
							false);

					verifyVisibilityOfButtons(driver, deleteButton, "Delete button", false);

					BaseSuite.validationReportLog(
							"Visibility of Assign Admin Access button and Delete button for Super Admin User is verified "
									+ param.getUserNameVal());

				} else if (col == 1) {

					BaseSuite.reportLog("Verifying revoke assigned admin sccess using application admin user");

					int count = getcount(param.getUserNameVal(), ',');

					String[] result = param.getUserNameVal().split(",");

					for (int colNum = 0; colNum <= count; colNum++) {

						String userName = result[colNum];

						clickOnUsersMenu();

						searchUserOnLisitingPage(userName);

						clickOnSearchedUserName();

						String val = getText(driver, adminBadge);

						if (val.equals("Admin")) {

							revokeAdminAccess(userName, colNum);

							if (colNum == 0) {

								boolean flag = isDisplayed(driver, adminAccessButton);

								if (flag) {
									BaseSuite.validationReportLog(
											"Revoke admin access button change to Assign access button after clicked on it");
								} else {
									BaseSuite.reportFailLog(
											"Not able to change the Revoke admin access button to Assign admin access button after clicked on it",

											"verifyRevokeAdminAccess");

								}
							} else {
								boolean flag = isDisplayed(driver, revokeAdminAccessButton);

								if (flag) {
									BaseSuite.validationReportLog(
											"Not able to revoke admin access because user inherit admin access from admin group");
								} else {
									BaseSuite.reportFailLog(
											"Admin access revoked from user which inherit admin access from admin group,Kindly check!",
											"verifyRevokeAdminAccess");

								}
							}
						} else {

							BaseSuite.reportFailLog(
									param.getUserNameVal() + " is not an admin user,Kindly check the user detail!",
									"verifyRevokeAdminAccess");
						}
					}

				} else {

					LoginPage lp = new LoginPage(driver);

					lp.logOut();

					int countForSuperAdmin = 0;

					boolean loginflag = lp.loginWithIcedqUserAndSelectWorkspace(ConstantProperty.ICEDQ_SUPERADMINUSER,
							"", ConstantProperty.MODULENAME_ADMINISTRATION, "");

					if (loginflag) {
						BaseSuite.reportLog("Verifying revoke assigned admin sccess using super admin user");

						clickOnUsersMenu();

						searchUserOnLisitingPage(param.getUserNameVal());

						clickOnSearchedUserName();

						String val = getText(driver, adminBadge);

						if (val.equals("Admin")) {

							revokeAdminAccess(param.getUserNameVal(), countForSuperAdmin);

							boolean flag = isDisplayed(driver, adminAccessButton);

							if (flag) {
								BaseSuite.validationReportLog(
										"Revoke admin access button change to Assign access button after clicked on it");
							} else {
								BaseSuite.reportFailLog(
										"Not able to change the Revoke admin access button to Assign admin access button after clicked on it",
										"verifyRevokeAdminAccess");

							}
						} else {

							BaseSuite.reportFailLog(
									param.getUserNameVal() + " is not an admin user,Kindly check the user detail!",
									"verifyRevokeAdminAccess");
						}

					} else {
						throw new AssertionError("Not able to login using super admi credentials,Kindly check!");
					}

				}

			}
		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public AdministrationParameters setUserParameters(String filePath, String sheetName, int rowNumber)
			throws Exception {
		try {
			AdministrationParameters param = new AdministrationParameters();

			XLUtils xl = new XLUtils();

			param.setUserNameVal(xl.readUsingColName(filePath, sheetName, rowNumber, "UserName"));

			param.setEmailVal(xl.readUsingColName(filePath, sheetName, rowNumber, "Email"));

			param.setFirstNameVal(xl.readUsingColName(filePath, sheetName, rowNumber, "FirstName"));

			param.setLastNameVal(xl.readUsingColName(filePath, sheetName, rowNumber, "LastName"));

			param.setPasswordVal(xl.readUsingColName(filePath, sheetName, rowNumber, "Password"));

			param.setConfirmPasswordVal(xl.readUsingColName(filePath, sheetName, rowNumber, "ConfirmPassword"));

			param.setAssignGroup(xl.readUsingColName(filePath, sheetName, rowNumber, "AssignGroup"));

			param.setGropDetail(xl.readUsingColName(filePath, sheetName, rowNumber, "GropDetail"));

			param.setAccountDetail(xl.readUsingColName(filePath, sheetName, rowNumber, "AccountDetail"));

			param.setWorkspaceDetail(xl.readUsingColName(filePath, sheetName, rowNumber, "WorkspaceDetail"));

			param.setDetailPageUserName(xl.readUsingColName(filePath, sheetName, rowNumber, "DetailPageUserName"));

			param.setListPageUserName(xl.readUsingColName(filePath, sheetName, rowNumber, "ListPageUserName"));

			param.setFullName(xl.readUsingColName(filePath, sheetName, rowNumber, "FullName"));

			param.setErrorMess(xl.readUsingColName(filePath, sheetName, rowNumber, "ErrorMess"));

			param.setInvalidInputValue(xl.readUsingColName(filePath, sheetName, rowNumber, "InvalidInputValue"));
			
			param.setAdminFlag(xl.readUsingColName(filePath, sheetName, rowNumber, "AdminFlag"));

			return param;

		} catch (Exception e) {

			e.getMessage();

			throw new Exception();
		}

	}

	public void addGroupToUser(String assignGrpName) {

		try {
			BaseSuite.reportLog("Clicking on group tab");

			displayAndClick(driver, userGroupTab);

			BaseSuite.validationReportLog("Group tab clicked successfully");

			assignButton();

			selectGroup(assignGrpName);

			BaseSuite.reportLog("Clicking on Assign button");

			displayAndClick(driver, assignGroupPaneAssignButton);

			BaseSuite.validationReportLog("Assign button clicked successfully");

			inVisible(driver, spinner, Constant.ruleWait);

		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void searchGroup(String groupName) {
		try {

			BaseSuite.reportLog("Entering Group name on search box");

			javascript(driver, scrollToElementArg, groupSearchBox);

			click(driver, groupSearchBox);

			clear_SendKeys(driver, groupSearchBox, groupName);

			displayAndClick(driver, groupSearchBar);

			BaseSuite.validationReportLog("Group name entered successfully on search box");

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void searchWorkspace(String workspaceName) {
		try {

			BaseSuite.reportLog("Entering workspace name on search box");

			click(driver, workspaceSearchBox);

			clear_SendKeys(driver, workspaceSearchBox, workspaceName);

			displayAndClick(driver, workspaceSearchBar);

			BaseSuite.validationReportLog("workspace name entered successfully on search box");

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void searchAccount(String accountName) {
		try {

			BaseSuite.reportLog("Entering Account name on search box");

			javascript(driver, scrollToElementArg, accountSearchBox);

			click(driver, accountSearchBox);

			clear_SendKeys(driver, accountSearchBox, accountName);

			displayAndClick(driver, accountSearchBar);

			BaseSuite.validationReportLog("Account name entered successfully on search box");

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void verifyAddedGroupFromUserTab(String val) {
		try {

			if ((!val.isEmpty()) && (!isDisplayed(driver, noRecordFound))) {
				int count = getcount(val, ';');

				String[] result = val.split(";");

				for (int colNum = 0; colNum <= count; colNum++) {

					String addGroup = result[colNum];

					String[] add = addGroup.split(",");

					String name = add[0];

					String path = add[1];

					String pathVal = "//" + path;

					javascript(driver, scrollToElementArg, userGroupTab);

					displayAndClick(driver, userGroupTab);

					inVisible(driver, spinner, Constant.ruleWait);

					searchGroup(name);

					javascript(driver, scrollToElementArg, returnElement(groupName, "$name", name));

					String grpName = getText(driver, returnElement(groupName, "$name", name)).trim();

					String grpPath = getText(driver, returnElement(groupPath, "$name", name)).trim();

					if (grpName.equalsIgnoreCase(name.trim())) {

						BaseSuite.validationReportLog(
								"Group Name in User detailed page matched successfully : " + grpName);

					} else {

						BaseSuite.reportFailLog("Group Name in User detailed page not matched",
								"verifyAddedGroupFromUserTab");

					}

					if (grpPath.equalsIgnoreCase(path.trim())) {

						BaseSuite.validationReportLog(
								"Group path in User detailed page matched successfully : " + grpName);

					} else {

						BaseSuite.reportFailLog("Group path in User detailed page not matched",
								"verifyAddedGroupFromUserTab");

					}

				}
			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void verifyAddedWorkspaceFromUserTab(String val) {
		try {
			if ((!val.isEmpty()) && (!isDisplayed(driver, noRecordFound))) {
				int count = getcount(val, ';');

				String[] result = val.split(";");

				for (int colNum = 0; colNum <= count; colNum++) {

					String addGroup = result[colNum];

					String[] add = addGroup.split(",");

					String name = add[0];

					String role = add[1];

					String type = add[2];

					String scope = add[3];

					javascript(driver, scrollToElementArg, userWrokspaceButton);

					displayAndClick(driver, userWrokspaceButton);

					inVisible(driver, spinner, Constant.ruleWait);

					searchWorkspace(name);

					javascript(driver, scrollToElementArg, returnElement(groupName, "$name", name));

					String grpName = getText(driver, returnElement(groupName, "$name", name)).trim();

					if (grpName.equalsIgnoreCase(name.trim())) {

						BaseSuite.validationReportLog(
								"Workspace Name in User detailed page matched successfully : " + grpName);

					} else {

						BaseSuite.reportFailLog("Workspace Name in User detailed page not matched",
								"verifyAddedGroupFromUserTab");

					}

					String typeValue = getText(driver, returnElement(workspaceType, "$name", type)).trim();

					if (typeValue.equalsIgnoreCase(type.trim())) {
						BaseSuite.validationReportLog(
								"Workspace type in User detailed page matched successfully : " + type);
					} else {

						BaseSuite.reportFailLog("Workspace type in User detailed page not matched",
								"verifyAddedGroupFromUserTab");

					}

					String roleValue = getText(driver, returnElement(workspaceRole, "$name", grpName)).trim();

					if (roleValue.equalsIgnoreCase(role.trim())) {
						BaseSuite.validationReportLog(
								"Workspace role in User detailed page matched successfully : " + roleValue);
					} else {
						BaseSuite.reportFailLog("Workspace role in User detailed page not matched",
								"verifyAddedGroupFromUserTab");

					}

					String scopeValue = getText(driver, returnElement(workspaceScope, "$name", scope)).trim();

					if (scopeValue.equalsIgnoreCase(scope.trim())) {
						BaseSuite.validationReportLog(
								"Workspace scope in User detailed page matched successfully : " + scopeValue);
					} else {
						BaseSuite.reportFailLog("Workspace scope in User detailed page not matched",
								"verifyAddedGroupFromUserTab");

					}

				}
			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void verifyAddedAccountFromUserTab(String val) {
		try {
			if ((!val.isEmpty()) && (!isDisplayed(driver, noRecordFound))) {

				int count = getcount(val, ';');

				String[] result = val.split(";");

				for (int colNum = 0; colNum <= count; colNum++) {

					String addGroup = result[colNum];

					String[] add = addGroup.split(",");

					String name = add[0];

					String role = add[1];

					String scope = add[2];

					javascript(driver, scrollToElementArg, userWrokspaceButton);

					displayAndClick(driver, userAccountButton);

					inVisible(driver, spinner, Constant.ruleWait);

					searchAccount(name);

					javascript(driver, scrollToElementArg, returnElement(groupName, "$name", name));

					String grpName = getText(driver, returnElement(groupName, "$name", name)).trim();

					if (grpName.equalsIgnoreCase(name.trim())) {

						BaseSuite.validationReportLog(
								"Account Name in User detailed page matched successfully : " + grpName);

					} else {

						BaseSuite.reportFailLog("Account Name in User detailed page not matched",
								"verifyAddedGroupFromUserTab");

					}

					String roleValue = getText(driver, returnElement(accountRole, "$name", role)).trim();

					if (roleValue.equalsIgnoreCase(role.trim())) {
						BaseSuite.validationReportLog(
								"Account role in User detailed page matched successfully : " + roleValue);
					} else {
						BaseSuite.reportFailLog("Account role in User detailed page not matched",
								"verifyAddedGroupFromUserTab");

					}

					String scopeValue = getText(driver, returnElement(workspaceScope, "$name", scope)).trim();

					if (scopeValue.equalsIgnoreCase(scopeValue.trim())) {
						BaseSuite.validationReportLog(
								"Account scope in User detailed page matched successfully : " + scopeValue);
					} else {
						BaseSuite.reportFailLog("Account scope in User detailed page not matched",
								"verifyAddedGroupFromUserTab");

					}

				}
			}
		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void assignAdminAccess(String userName) {
		try {
			boolean flag = clickOnButton(driver, adminAccessButton, "Access Admin Button", true);

			inVisible(driver, spinner, Constant.ruleWait);

			if (flag) {
				String val = getText(driver, adminBadge);

				if (val.equals("Admin")) {

					BaseSuite.validationReportLog(
							"Assigned admin access successfully to the user and Admin badge add after the username on detail page"
									+ userName);

					clickOnButton(driver, userBreadCrumb, "Users Breadcrumb", true);

					inVisible(driver, spinner, Constant.ruleWait);

					searchUserOnLisitingPage(userName);

					String val1 = getText(driver, adminBadgeOnListingPage);

					if (val1.equals("Admin")) {
						BaseSuite.validationReportLog(
								"Assigned admin access successfully to the user and Admin badge add after the username on listing page"
										+ userName);

					} else {
						BaseSuite.reportFailLog(
								"Not able to assigned admin assign to the user/Admin badge not added after the username on listing page"
										+ userName,
								"assignAdminAccess");
					}

					clickOnSearchedUserName();

				} else {
					BaseSuite.reportFailLog(
							"Not able to assigned admin assign to the user/Admin badge not added after the username "
									+ userName,
							"assignAdminAccess");
				}
			}

		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void revokeAdminAccess(String userName, int count) {
		try {
			boolean flag = clickOnButton(driver, revokeAdminAccessButton, "Revoke Admin Button", true);

			inVisible(driver, spinner, Constant.ruleWait);

			Thread.sleep(2000);

			if (flag) {

				if (isDisplayed(driver, adminBadge)) {

					BaseSuite.reportFailLog(
							"Not able to revoke admin access to the user and admin badge remove from user on detail page"
									+ userName,
							"revokeAdminAccess");
				} else {
					BaseSuite.validationReportLog(
							"Admin access revoked successfully to the user and admin badge remove from user on detail page"
									+ userName);

				}

				clickOnButton(driver, userBreadCrumb, "Users Breadcrumb", true);

				inVisible(driver, spinner, Constant.ruleWait);

				searchUserOnLisitingPage(userName);

				if (count == 0) {

					if (isDisplayed(driver, adminBadgeOnListingPage)) {

						BaseSuite.reportFailLog(
								"Not able to revoke admin access to the user and admin badge remove from user on listing page"
										+ userName,
								"revokeAdminAccess");

					} else {
						BaseSuite.validationReportLog(
								"Admin access revoked successfully to the user and admin badge remove from user on listing page"
										+ userName);
					}
				} else {

					if (isDisplayed(driver, adminBadgeOnListingPage)) {

						BaseSuite.validationReportLog(
								"Not able to revoke admin access because user inherit admin access from admin group");

					} else {

						BaseSuite.reportFailLog(
								"Admin access revoked from user which inherit admin access from admin group,Kindly check!",
								"verifyRevokeAdminAccess");

					}

				}

				clickOnSearchedUserName();

			}

			else {

				throw new AssertionError("Not able to revoke admin access");
			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void clickOnGroupDeleteButton() {
		try {
			BaseSuite.reportLog("Click on delete button to remove the group");

			displayAndClick(driver, groupRemoveButton);

			BaseSuite.validationReportLog("Delete button clciked successfully");

			Thread.sleep(2000);

			if (isDisplayed(driver, groupRemovePopupBoxText)) {
				String val = getText(driver, groupRemovePopupBoxText);

				if (val.trim().equals(groupDeletePopupHeader)) {
					BaseSuite.validationReportLog("Delete pop up header matched successfully");
				} else {
					BaseSuite.reportFailLog("Delete pop up header not matched,Kindly check",
							"clickOnGroupDeleteButton");
				}

				String val1 = getText(driver, groupRemovePopupBoxTitle);

				if (val1.equals(groupDeletePopupTitle)) {
					BaseSuite.validationReportLog("Delete pop up title matched successfully");
				} else {
					BaseSuite.reportFailLog("Delete pop up title not matched,Kindly check", "clickOnGroupDeleteButton");
				}

				verifyVisibilityOfButtons(driver, groupRemovePopupBoxCancelButton, "Cancel Button", true);

				clickOnButton(driver, groupRemovePopupBoxDeleteButton, "Delete Button", true);

				inVisible(driver, spinner, Constant.ruleWait);

				if (isDisplayed(driver, noRecordFound)) {
					BaseSuite.validationReportLog("Group deleted successfully");
				} else {
					BaseSuite.reportFailLog("Group not deleted,Kindly check", "clickOnGroupDeleteButton");
				}
			} else {
				BaseSuite.reportFailLog("Delete pop up is not showing after clicking on delete button",
						"clickOnGroupDeleteButton");

			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void removeGroupFromUserTab(String groupName) {
		try {
			int count = getcount(groupName, ',');

			String[] result = groupName.split(",");

			for (int colNum = 0; colNum <= count; colNum++) {

				String addGroup = result[colNum];

				searchGroup(addGroup);

				if (!isDisplayed(driver, noRecordFound)) {

					BaseSuite.reportLog("Click on checkbox to remove the group");

					verifyVisibilityOfButtons(driver, groupRemovePopupBoxDeleteButton, "Delete Button", false);

					displayAndClick(driver, groupCheckBoxClick);

					BaseSuite.validationReportLog("Checkbox clciked successfully");

					verifyVisibilityOfButtons(driver, groupRemovePopupBoxDeleteButton, "Delete Button", true);

					clickOnGroupDeleteButton();

				}

				else {

					throw new AssertionError(addGroup + " Searched Group is not added.Kindly check!");

				}

			}
		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void verifyUserBlockFunctionality(AdministrationParameters param, int col) throws Exception {

		try {
			if (isDisplayed(driver, commonToastMsg)) {

				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, userWhoDontHavePrivilegesMessage,
						"User who don't have privileges message");
			} else {

				LoginPage page = new LoginPage(driver);

				int count = getcount(param.getUserNameVal(), ',');

				String[] result = param.getUserNameVal().split(",");

				for (int colNum = 0; colNum <= count; colNum++) {

					String users = result[colNum];

					searchUserOnLisitingPage(users);

					if (!isDisplayed(driver, noRecordFound)) {

						String statusVal = getText(driver, userListStatusCol);

						if (statusVal.equals("ACTIVE")) {

							
						BaseSuite.reportLog("Click on checkbox to block the user");

							verifyVisibilityOfButtons(driver, blockUserButtonOnListing, "User Block Button", false);

							verifyVisibilityOfButtons(driver, deleteUserButtonOnListing, "Delete Button", false);

							//displayAndClick(driver, groupCheckBoxClick);

							BaseSuite.validationReportLog("Checkbox clicked successfully");

							if (col == 0) {
								BaseSuite.reportLog(
										"Verifying visibility of Block user button and Delete button for Super Admi User "
												+ users);

								verifyVisibilityOfButtons(driver, blockUserButtonOnListing, "User Block Button", false);

								verifyVisibilityOfButtons(driver, deleteUserButtonOnListing, "Delete Button", false);

								BaseSuite.validationReportLog(
										"Visibility of Block user button and Delete button for Super Admin User is verified "
												+ users);

								String val = getAttribute(driver, visibilityOfCheckbox, "class");

								if (val.contains("disable")) {

									BaseSuite.validationReportLog(
											"Master check box for Super Admin User is disabled " + users);

								} else {

									BaseSuite.reportFailLog("Master check box for Super Admin User is enable " + users,
											"verifyUserBlockFunctionality");
								}

							} else {

								displayAndClick(driver, groupCheckBoxClick);

								verifyVisibilityOfButtons(driver, blockUserButtonOnListing, "User Block Button", true);

								verifyVisibilityOfButtons(driver, deleteUserButtonOnListing, "Delete Button", true);

								blockUser();

								page.logOut();

								Thread.sleep(2000);

								enterValueToTextField(driver, userNameLogin, "Username", users);

								Thread.sleep(2000);

								enterValueToTextField(driver, passWord, "Password", param.getPasswordVal());

								clickOnButton(driver, signin, "Sign In", true);

								String val = getText(driver, blockedUserLoginMess);

								if (val.equalsIgnoreCase(userBlockedMessage)) {

									BaseSuite.validationReportLog(
											users + " User not able to loggedin the app after it's blocked");
								} else {

									BaseSuite.reportFailLog(
											users + " User able to loggedin the app after it's blocked,Kindly check",
											"verifyUserBlockFunctionality");
								}

							}

						} else {
							throw new AssertionError(users + " User is already blocked.Kindly check!");

						}
					} else {

						throw new AssertionError(users + " Searched User is not added.Kindly check!");

					}

				}

			}
		} catch (AssertionError e) {

			throw new AssertionError();
		}
	}

	public void verifyDeleteUserFunctionality(AdministrationParameters param) {

		try {

			if (isDisplayed(driver, commonToastMsg)) {

				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, userWhoDontHavePrivilegesMessage,
						"User who don't have privileges message");
			} else {
				clickOnUsersMenu();

				int count = getcount(param.getDetailPageUserName(), ',');

				String[] result = param.getDetailPageUserName().split(",");

				for (int colNum = 0; colNum <= count; colNum++) {

					String detailPageUserName = result[colNum];

					searchUserOnLisitingPage(detailPageUserName);

					if (!isDisplayed(driver, noRecordFound)) {

						clickOnSearchedUserName();

						// verifyUserDetailPage(param);

						deleteUserFromDetailPage();

					} else {

						throw new AssertionError(param.getUserNameVal() + " Searched User is not added.Kindly check!");
					}

				}

				int count1 = getcount(param.getListPageUserName(), ',');

				String[] result1 = param.getListPageUserName().split(",");

				for (int colNum = 0; colNum <= count1; colNum++) {

					String listingPageUserName = result1[colNum];

					if (colNum > 0) {

						click(driver, userSearchOnLisitingPage);

						displayAndClick(driver, userSearchBarClear);

						inVisible(driver, spinner, Constant.ruleWait);

					}

					searchUserOnLisitingPage(listingPageUserName);

					Thread.sleep(2000);

					if (!isDisplayed(driver, noRecordFound)) {

						BaseSuite.reportLog("Click on checkbox to delete the user");

						verifyVisibilityOfButtons(driver, deleteButtonListingPage, "Delete Button", false);

						displayAndClick(driver, groupCheckBoxClick);

						BaseSuite.validationReportLog("Checkbox clciked successfully");

						verifyVisibilityOfButtons(driver, deleteButtonListingPage, "Delete Button", true);

						deleteUserFromListingPage();

					} else {

						throw new AssertionError(param.getUserNameVal() + " Searched User is not added.Kindly check!");
					}

				}
			}

		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void verifySearchedResult(By locator, String label, String expectedSearchResult) {
		BaseSuite.reportLog("Verifying search result for " + label);

		List<WebElement> ele = getElements(driver, locator);

		for (int i = 0; i < ele.size(); i++) {

			String val = ele.get(i).getText();

			if (val.toLowerCase().contains(expectedSearchResult.toLowerCase())) {

				BaseSuite.validationReportLog(label + " Actual search result " + expectedSearchResult
						+ " matched with expected search result " + val);

			} else {

				BaseSuite.reportFailLog(label + " Actual search result " + expectedSearchResult
						+ " not matched with expected search result " + val, "verifySearchedResult");

			}

		}

	}

	public void searchUsingFullName(AdministrationParameters param) {
		try {
			clickOnUsersMenu();

			int count = getcount(param.getFullName(), ',');

			String[] result = param.getFullName().split(",");

			for (int colNum = 0; colNum <= count; colNum++) {

				if (colNum > 0) {

					click(driver, userSearchOnLisitingPage);

					displayAndClick(driver, searchBarClear);
					
					inVisible(driver, spinner, Constant.ruleWait);
				}

				String fullName = result[colNum];

				searchUserOnLisitingPage(fullName);

				if (!isDisplayed(driver, noRecordFound)) {

					verifySearchedResult(userSearchNameClicked, "Full Name", fullName);

				} else {
					throw new AssertionError(fullName + " Searched User is not found.Kindly check!");
				}

			}
		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void searchUsingUserName(AdministrationParameters param) {
		try {
			clickOnUsersMenu();

			int count = getcount(param.getUserNameVal(), ',');

			String[] result = param.getUserNameVal().split(",");

			for (int colNum = 0; colNum <= count; colNum++) {

				if (colNum > 0) {
					click(driver, userSearchOnLisitingPage);

					displayAndClick(driver, searchBarClear);
					
					inVisible(driver, spinner, Constant.ruleWait);
				}

				String userName = result[colNum];

				searchUserOnLisitingPage(userName);

				if (!isDisplayed(driver, noRecordFound)) {

					verifySearchedResult(userNameSearchClicked, "User Name", userName);

				} else {
					throw new AssertionError(userName + " Searched User is not found.Kindly check!");
				}

			}
		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void searchUsingEmail(AdministrationParameters param) {
		try {
			clickOnUsersMenu();

			int count = getcount(param.getEmailVal(), ',');

			String[] result = param.getEmailVal().split(",");

			for (int colNum = 0; colNum <= count; colNum++) {

				if (colNum > 0) {
					click(driver, userSearchOnLisitingPage);

					displayAndClick(driver, searchBarClear);
					
					inVisible(driver, spinner, Constant.ruleWait);
				}

				String email = result[colNum];

				searchUserOnLisitingPage(email);

				if (!isDisplayed(driver, noRecordFound)) {
					verifySearchedResult(emailSearchClicked, "Email", email);
				}

				else {
					throw new AssertionError(email + " Searched email is not found.Kindly check!");
				}

			}
		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void verifyGroupSearchResult(AdministrationParameters param) {
		try {

			int count = getcount(param.getGropDetail(), ',');

			String[] result = param.getGropDetail().split(",");

			for (int colNum = 0; colNum <= count; colNum++) {

				if (colNum > 0) {
					click(driver, groupSearchBox);

					displayAndClick(driver, groupSearchBarClear);
					
				}

				String groupName = result[colNum];

				searchGroup(groupName);

				if (!isDisplayed(driver, noRecordFound)) {
					verifySearchedResult(groupSearchList, "Group", groupName);
				}

				else {
					throw new AssertionError(groupName + " Searched group is not found.Kindly check!");
				}

			}
		} catch (Exception e) {

			throw new AssertionError();
		}

	}
	
	
	public void verifyAccountSearchResult(AdministrationParameters param) {
		try {

			javascript(driver, scrollToElementArg, userAccountButton);

			displayAndClick(driver, userAccountButton);

			int count = getcount(param.getAccountDetail(), ',');

			String[] result = param.getAccountDetail().split(",");

			for (int colNum = 0; colNum <= count; colNum++) {

				if (colNum > 0) {
					click(driver, accountSearchBox);

					displayAndClick(driver, accountSearchBarClear);
		}

				String accountName = result[colNum];

				searchAccount(accountName);

				if (!isDisplayed(driver, noRecordFound)) {
					verifySearchedResult(accountSearchList, "Account", accountName);
				}

				else {
					throw new AssertionError(accountName + " Searched account is not found.Kindly check!");
				}

			}
		} catch (Exception e) {

			throw new AssertionError();
		}
	}
		
	public void verifyWorkspaceSearchResult(AdministrationParameters param) {
		try {

			javascript(driver, scrollToElementArg, userWrokspaceButton);

			displayAndClick(driver, userWrokspaceButton);

			int count = getcount(param.getWorkspaceDetail(), ',');

			String[] result = param.getWorkspaceDetail().split(",");

			for (int colNum = 0; colNum <= count; colNum++) {

				if (colNum > 0) {
					click(driver, workspaceSearchBox);

					displayAndClick(driver, workspaceSearchBarClear);
				}

				String workspaceName = result[colNum];

				searchWorkspace(workspaceName);

				if (!isDisplayed(driver, noRecordFound)) {
					verifySearchedResult(workspaceSearchList, "Workspace", workspaceName);
				}

				else {
					throw new AssertionError(workspaceName + " Searched workspace is not found.Kindly check!");
				}

			}
		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void verifySearchFunctionalityOnUserListingPage(AdministrationParameters param) throws Exception {
		try {
			if (isDisplayed(driver, commonToastMsg)) {

				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, userWhoDontHavePrivilegesMessage,
						"User who don't have privileges message");
			} else {
				clickOnUsersMenu();

				searchUsingFullName(param);
				
				searchUsingUserName(param);
			
				searchUsingEmail(param);
			
			}

		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void verifySearchFunctionalityOnUserDetailsPage(AdministrationParameters param) throws Exception {
		try {
			if (isDisplayed(driver, commonToastMsg)) {

				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, userWhoDontHavePrivilegesMessage,
						"User who don't have privileges message");
			} else {
				clickOnUsersMenu();

				searchUserOnLisitingPage(param.getUserNameVal());

				clickOnSearchedUserName();

				verifyGroupSearchResult(param);
				
				verifyAccountSearchResult(param);
				
				verifyWorkspaceSearchResult(param);

			}

		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void clickOnRefreshButton() {
		try {
			clickOnButton(driver, refreshButtom, "Refresh Button", true);

			inVisible(driver, spinner, Constant.ruleWait);

		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void refreshGroup(AdministrationParameters param) {
		try {
			BaseSuite.reportLog("Verifying refresh functionality on search of group name");

			searchGroup(param.getGropDetail());

			clickOnButton(driver, groupRefreshButton, "Group Refresh Button", true);

			inVisible(driver, spinner, Constant.ruleWait);

			List<WebElement> ele = getElements(driver, groupNameList);

			if (ele.size() > 1) {

				BaseSuite.validationReportLog("Group list gets refreshed after clicked on refresh button");

			} else { 

				BaseSuite.reportFailLog("Group list not get refreshed after clicked on refresh button", "refreshGroup");
			}

			BaseSuite.reportLog("Verifying refresh functionality on clicking of group name check box");

			displayAndClick(driver, groupCheckBoxClick);

			clickOnButton(driver, groupRefreshButton, "Group Refresh Button", true);

			inVisible(driver, spinner, Constant.ruleWait);

			String val = getAttribute(driver, userCheckboxAttribute, "class");

			if (val.contains("uncheck")) {

				BaseSuite.validationReportLog("Group list gets unchecked after clicked on refresh button");

			} else {

				BaseSuite.reportFailLog("Group list not get unchecked after clicked on refresh button", "refreshGroup");

			}

			BaseSuite.reportLog("Verifying refresh functionality on search bar");

			clear_SendKeys(driver, groupSearchBox, param.getGropDetail());

			clickOnButton(driver, groupRefreshButton, "Group Refresh Button", true);

			inVisible(driver, spinner, Constant.ruleWait);

			String text = getAttribute(driver, groupSearchBox, "value");

			if (text.isEmpty()) {

				BaseSuite.reportFailLog("Seacrh bar gets cleared after clicked on refresh button", "refreshGroup");

			} else {
				BaseSuite.validationReportLog("Seacrh bar not get cleared after clicked on refresh button");

			}

			javascript(driver, scrollToElementArg, goToLastPage);

			String pageAtt = getAttribute(driver, goToLastPage, "class");

			if (!pageAtt.contains("disable")) {
				displayAndClick(driver, goToLastPage);

				clickOnButton(driver, groupRefreshButton, "Group Refresh Button", true);

				inVisible(driver, spinner, Constant.ruleWait);

				String val1 = getAttribute(driver, goToFirstPage, "aria-selected");

				if (val1.contains("true")) {

					BaseSuite.validationReportLog(
							"Pagination came on first page from last page after clicked on refresh button");

				} else {

					BaseSuite.reportFailLog(
							"Pagination not came on first page from last page after clicked on refresh button",
							"refreshGroup");

				}
			}

		} catch (Exception e) {

			throw new AssertionError();
		}
	}

	public void refreshWorkspace(AdministrationParameters param) {
		try {
			BaseSuite.reportLog("Verifying refresh functionality on search of workspace name");

			javascript(driver, scrollToElementArg, userWrokspaceButton);

			displayAndClick(driver, userWrokspaceButton);

			inVisible(driver, spinner, Constant.ruleWait);

			searchWorkspace(param.getWorkspaceDetail());

			clickOnButton(driver, workspaceRefreshButton, "Workspace Refresh Button", true);

			inVisible(driver, spinner, Constant.ruleWait);

			List<WebElement> ele = getElements(driver, workspaceNameList);

			if (ele.size() > 1) {

				BaseSuite.validationReportLog("Workspace list gets refreshed after clicked on refresh button");

			} else {

				BaseSuite.reportFailLog("Workspace list not get refreshed after clicked on refresh button",
						"refreshWorkspace");
			}

			BaseSuite.reportLog("Verifying refresh functionality on search bar");

			clear_SendKeys(driver, workspaceSearchBox, param.getWorkspaceDetail());

			clickOnButton(driver, workspaceRefreshButton, "Workspace Refresh Button", true);

			inVisible(driver, spinner, Constant.ruleWait);

			String text = getAttribute(driver, workspaceSearchBox, "value");

			if (text.isEmpty()) {

				BaseSuite.reportFailLog("Seacrh bar gets cleared after clicked on refresh button", "refreshWorkspace");

			} else {
				BaseSuite.validationReportLog("Seacrh bar not get cleared after clicked on refresh button");

			}

			javascript(driver, scrollToElementArg, workspaceGoToLastPagee);

			String pageAtt = getAttribute(driver, workspaceGoToLastPagee, "class");

			if (!pageAtt.contains("disable")) {
				displayAndClick(driver, workspaceGoToLastPagee);

				clickOnButton(driver, workspaceRefreshButton, "Workspace Refresh Button", true);

				inVisible(driver, spinner, Constant.ruleWait);

				String val1 = getAttribute(driver, workspaceGoToFirstPagee, "class");

				if (val1.contains("firstpagedisabled")) {

					BaseSuite.validationReportLog(
							"Pagination came on first page from last page after clicked on refresh button");

				} else {

					BaseSuite.reportFailLog(
							"Pagination not came on first page from last page after clicked on refresh button",
							"refreshWorkspace");

				}
			}

		} catch (Exception e) {

			throw new AssertionError();
		}
	}

	public void refreshAccount(AdministrationParameters param) {
		try {
			BaseSuite.reportLog("Verifying refresh functionality on search of account name");

			javascript(driver, scrollToElementArg, userAccountButton);

			displayAndClick(driver, userAccountButton);

			inVisible(driver, spinner, Constant.ruleWait);

			searchAccount(param.getGropDetail());

			clickOnButton(driver, accountRefreshButton, "Account Refresh Button", true);

			inVisible(driver, spinner, Constant.ruleWait);

			List<WebElement> ele = getElements(driver, accountNameList);

			if (ele.size() > 0) {

				BaseSuite.validationReportLog("Account list gets refreshed after clicked on refresh button");

			} else {

				BaseSuite.reportFailLog("Account list not get refreshed after clicked on refresh button",
						"refreshAccount");
			}

			clear_SendKeys(driver, accountSearchBox, param.getGropDetail());

			clickOnButton(driver, accountRefreshButton, "Account Refresh Button", true);

			inVisible(driver, spinner, Constant.ruleWait);

			String text = getAttribute(driver, accountSearchBox, "value");

			if (text.isEmpty()) {

				BaseSuite.reportFailLog("Seacrh bar gets cleared after clicked on refresh button", "refreshAccount");

			} else {
				BaseSuite.validationReportLog("Seacrh bar not get cleared after clicked on refresh button");

			}

		} catch (Exception e) {

			throw new AssertionError();
		}
	}

	public void refreshFunctionalityOnUserDetailPage(AdministrationParameters param) {
		try {
			if (isDisplayed(driver, commonToastMsg)) {

				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, userWhoDontHavePrivilegesMessage,
						"User who don't have privileges message");
			} else {
				searchUserOnLisitingPage(param.getUserNameVal());

				clickOnSearchedUserName();

				refreshGroup(param);

				refreshAccount(param);

				refreshWorkspace(param);
			}

		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void refreshFunctionalityOnLisitngPage(AdministrationParameters param) {
		try {
			if (isDisplayed(driver, commonToastMsg)) {

				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, userWhoDontHavePrivilegesMessage,
						"User who don't have privileges message");
			} else {

				BaseSuite.reportLog("Verifying refresh functionality on search of user name");

				searchUserOnLisitingPage(param.getUserNameVal());

				clickOnRefreshButton();

				List<WebElement> ele = getElements(driver, userSearchNameClicked);

				if (ele.size() > 1) {
					BaseSuite.validationReportLog("Users list gets refreshed after clicked on refresh button");
				} else {
					BaseSuite.reportFailLog("Users list not get refreshed after clicked on refresh button",
							"refreshFunctionalityOnLisitngPage");
				}

				BaseSuite.reportLog("Verifying refresh functionality on clicking of user name check box");

				displayAndClick(driver, groupCheckBoxClick);

				clickOnRefreshButton();
				
				String val = getAttribute(driver, userCheckboxAttribute, "class");

				if (val.contains("uncheck")) {
					BaseSuite.validationReportLog("Users list gets unchecked after clicked on refresh button");
				} else {
					BaseSuite.reportFailLog("Users list not get unchecked after clicked on refresh button",
							"refreshFunctionalityOnLisitngPage");

				}

				BaseSuite.reportLog("Verifying refresh functionality on pagination");

				javascript(driver, scrollToElementArg, goToLastPage);

				displayAndClick(driver, goToLastPage);

				clickOnRefreshButton();

				String val1 = getAttribute(driver, goToFirstPage, "class");

				if (val1.contains("firstpagedisabled")) {
					BaseSuite.validationReportLog(
							"Pagination came on first page from last page after clicked on refresh button");
				} else {
					BaseSuite.reportFailLog(
							"Pagination not came on first page from last page after clicked on refresh button",
							"refreshFunctionalityOnLisitngPage");

				}

				BaseSuite.reportLog("Verifying refresh functionality on search bar");

				clear_SendKeys(driver, userSearchOnLisitingPage, param.getUserNameVal());

				clickOnRefreshButton();

				String text = getAttribute(driver, userSearchOnLisitingPage, "value");

				if (text.isEmpty()) {

					BaseSuite.reportFailLog("Seacrh bar gets cleared after clicked on refresh button",
							"refreshFunctionalityOnLisitngPage");

				} else {
					BaseSuite.validationReportLog("Seacrh bar not get cleared after clicked on refresh button");

				}

			}

		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public boolean verifyUnblockUserFunctionality(AdministrationParameters param, String loginUser) throws Exception {
		boolean flag = true;
		try {

			String users = null;

			if (isDisplayed(driver, commonToastMsg)) {

				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, userWhoDontHavePrivilegesMessage,
						"User who don't have privileges message");
			} else {

				LoginPage page = new LoginPage(driver);

				int count = getcount(param.getUserNameVal(), ',');

				String[] result = param.getUserNameVal().split(",");

				for (int colNum = 0; colNum <= count; colNum++) {

					users = result[colNum];

					clickOnUsersMenu();

					searchUserOnLisitingPage(users);

					if (!isDisplayed(driver, noRecordFound)) {

						String statusVal = getText(driver, userListStatusCol);

						if (statusVal.equals(status)) {

							BaseSuite.reportLog("Click on checkbox to block the user");

							verifyVisibilityOfButtons(driver, blockUserButtonOnListing, "User Block Button", false);

							verifyVisibilityOfButtons(driver, deleteUserButtonOnListing, "Delete Button", false);

							displayAndClick(driver, groupCheckBoxClick);

							BaseSuite.validationReportLog("Checkbox clicked successfully");

							verifyVisibilityOfButtons(driver, blockUserButtonOnListing, "User Block Button", false);

							verifyVisibilityOfButtons(driver, unblockUserButtonOnListing, "Unblock Button", true);

							verifyVisibilityOfButtons(driver, deleteUserButtonOnListing, "Delete Button", true);

							unBlockUser();

							page.logOut();

							Thread.sleep(2000);

							page.loginWithIcedqUserAndSelectWorkspace(loginUser, "",
									ConstantProperty.MODULENAME_ADMINISTRATION, "");
						}

						else {
							flag = false;
							throw new AssertionError(users + " User is already unblock.Kindly check!");

						}

					}

					else {
						flag = false;
						throw new AssertionError(users + " Searched User is not added.Kindly check!");

					}
				}

			}
		} catch (InterruptedException e) {
			flag = false;
			throw new AssertionError();
		}
		return flag;

	}

	public void blockUser() {

		try {
			BaseSuite.reportLog("Clicking on Block user button");

			displayAndClick(driver, blockUserButtonOnListing);

			BaseSuite.validationReportLog("Block user button clciked successfully");

			Thread.sleep(2000);

			if (isDisplayed(driver, userListingPopupBox)) {

				String val = getText(driver, userListingPopupBoxTitleText);

				if (val.equals(blockUserPopupHeader)) {

					BaseSuite.validationReportLog("Block user pop up header matched successfully");

				} else {

					BaseSuite.reportFailLog("Block user pop up header not matched,Kindly check", "blockUser");
				}

				String val1 = getText(driver, userListingPopupBoxContentTitleText);

				if (val1.equals(blockUserPopupTitle)) {

					BaseSuite.validationReportLog("Block user pop up title matched successfully");

				} else {

					BaseSuite.reportFailLog("Block user pop up title not matched,Kindly check", "blockUser");
				}

				verifyVisibilityOfButtons(driver, userBlockPopupBoxCancelButton, "Cancel Button", true);

				clickOnButton(driver, userBlockPopupBoxBlockButton, "Block Button", true);

				inVisible(driver, spinner, Constant.ruleWait);

				if (isDisplayed(driver, toastMsg)) {
					captureToastMsg(driver, toastMsg, popUpClose, blockUserMessage, "User Block Message");

				}

				if (isDisplayed(driver, userListStatusCol)) {

					String statusVal = getText(driver, userListStatusCol);

					if (statusVal.equals(status)) {

						BaseSuite.validationReportLog(
								"Blocked label added on Status column after user blocked successfully");

					} else {

						BaseSuite.reportFailLog(
								"Blocked label not added on Status column after user blocked successfully",
								"blockUser");
					}

				}

			} else {

				BaseSuite.reportFailLog("Block user pop up is not showing after clicking on block button", "blockUser");

			}

		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void verifyDiscardFunctionalityForUser(AdministrationParameters param, int rowNum, String fileName,
			int colName, String sheetName) throws Exception {
		try {
			if (isDisplayed(driver, commonToastMsg)) {

				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, userWhoDontHavePrivilegesMessage,
						"User who don't have privileges message");
			} else {
				if (rowNum == 1) {
					clickOnUsersMenu();

					searchUserOnLisitingPage(param.getUserNameVal());

					clickOnSearchedUserName();
				}

				if (!isDisplayed(driver, noRecordFound)) {

					discardUser(rowNum, fileName, colName, sheetName);

				} else {

					throw new AssertionError(param.getUserNameVal() + " Searched User is not added.Kindly check!");

				}
			}

		} catch (AssertionError e) {

			throw new AssertionError();
		}

	}

	public void discardUser(int rowNum, String fileName, int colNum, String sheetName) {
		String label = null;

		try {
			verifyVisibilityOfButtons(driver, userSaveButton, "Save Button", false);

			verifyVisibilityOfButtons(driver, discardButton, "Discard button", false);

			if (rowNum == 1) {
				label = "Email";
			} else if (rowNum == 2) {
				label = "First Name";
			} else if (rowNum == 3) {
				label = "Last Name";
			} else if (rowNum == 4) {
				label = "Password";
			} else if (rowNum == 5) {
				label = "Confirm Password";
			}

			sendKeys(driver, returnElement(genericInputBox, "$name", Integer.toString(rowNum + 1)), label, "A");

			if (isDisplayed(driver, discardButton)) {
				if (label.contains("Password")) {
					verifyVisibilityOfButtons(driver, userSaveButton, "Save Button", false);

				}

				else {
					verifyVisibilityOfButtons(driver, userSaveButton, "Save Button", true);

				}

				verifyVisibilityOfButtons(driver, discardButton, "Discard button", true);

				BaseSuite.reportLog("Clicking on discard button");

				displayAndClick(driver, discardButton);

				BaseSuite.validationReportLog("Discard button clicked successfully");

				Thread.sleep(2000);

				if (isDisplayed(driver, userDiscardBox)) {

					String val = getText(driver, userDiscardHeaderText);

					if (val.equals(discardPopupHeader)) {

						BaseSuite.validationReportLog("Discard pop up header matched successfully");

					} else {

						BaseSuite.reportFailLog("Discard pop up header not matched,Kindly check", "discardUser");
					}

					String val1 = getText(driver, userDiscardContentText);

					if (val1.equals(discardPopupTitle)) {

					}
					BaseSuite.validationReportLog("Discard pop up title matched successfully");

				} else {

					BaseSuite.reportFailLog("Discard pop up title not matched,Kindly check", "discardUser");
				}

				verifyVisibilityOfButtons(driver, userDiscardBtnClickCancel, "Cancel Button", true);

				clickOnButton(driver, userDiscardBtnClickYes, "Discard Button", true);

				inVisible(driver, spinner, Constant.ruleWait);

				verifyVisibilityOfButtons(driver, userSaveButton, "Save Button", false);

				verifyVisibilityOfButtons(driver, discardButton, "Discard button", false);

				String val = getAttribute(driver, returnElement(genericInputBox, "$name", Integer.toString(rowNum + 1)),
						"value");

				XLUtils xl = new XLUtils();

				String name = xl.getCellData(fileName, sheetName, rowNum, colNum);

				if (val.equals(name.trim())) {
					BaseSuite.validationReportLog(
							label + " before and after changes matched successfully after click on discard button");
				} else {
					BaseSuite.reportFailLog(
							label + " before and after changes not matched successfully after click on discard button",
							"discardUser");

				}
			} else {
				throw new AssertionError("Discard button is not enable after entering value");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void unBlockUser() {
		try {
			BaseSuite.reportLog("Clicking on Unblock user button");

			displayAndClick(driver, unblockUserButtonOnListing);

			BaseSuite.validationReportLog("Unblock user button clciked successfully");

			captureToastMsg(driver, toastMsg, popUpClose, unblockUserMessage, "User Unblock");

			String statusVal = getText(driver, userListStatusCol);

			if (statusVal.equals("Active")) {

				BaseSuite.validationReportLog("Active label added on Status column after user unblocked successfully");

			} else {

				BaseSuite.reportFailLog("Active label not added on Status column after user unblocked successfully",
						"blockUser");
			}

		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void deleteUserFromDetailPage() {
		try {

			clickOnButton(driver, deleteButton, "Delete Button", true);

			Thread.sleep(2000);

			if (isDisplayed(driver, userDeletePopupBoxText)) {
				String val = getText(driver, userDeletePopupBoxText);

				if (val.trim().equals(userDeletePopupHeader)) {
					BaseSuite.validationReportLog("Delete pop up header matched successfully");
				} else {
					BaseSuite.reportFailLog("Delete pop up header not matched,Kindly check",
							"deleteUserFromDetailPage");
				}

				String val1 = getText(driver, userDeletePopupBoxTitle);

				if (val1.equals(userDeletePopupTitle)) {
					BaseSuite.validationReportLog("Delete pop up title matched successfully");
				} else {
					BaseSuite.reportFailLog("Delete pop up title not matched,Kindly check", "deleteUserFromDetailPage");
				}

				verifyVisibilityOfButtons(driver, userRemovePopupBoxCancelButton, "Cancel Button", true);

				clickOnButton(driver, userRemovePopupBoxDeleteButton, "Delete Button", true);

				inVisible(driver, spinner, Constant.ruleWait);

				captureToastMsg(driver, toastMsg, popUpClose, userDeleteMessage, "User Delete Message");

				if (isDisplayed(driver, userLabelOnLandingPage)) {
					BaseSuite.validationReportLog("User landing page isdisplayed after user deleted from detail page");
				} else {
					BaseSuite.reportFailLog("User landing page not displayed after user deleted from detail page",
							"deleteUserFromDetailPage");

				}

			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void deleteUserFromListingPage() {
		try {

			clickOnButton(driver, deleteButtonListingPage, "Delete Button", true);

			Thread.sleep(2000);

			if (isDisplayed(driver, userDeletePopupBoxText)) {

				String val = getText(driver, userDeletePopupBoxText);

				if (val.trim().equals(userDeletePopupHeader)) {

					BaseSuite.validationReportLog("Delete pop up header matched successfully");

				} else {

					BaseSuite.reportFailLog("Delete pop up header not matched,Kindly check",
							"deleteUserFromDetailPage");
				}

				String val1 = getText(driver, userDeletePopupBoxTitle);

				if (val1.equals(userDeletePopupTitle)) {

					BaseSuite.validationReportLog("Delete pop up title matched successfully");

				} else {

					BaseSuite.reportFailLog("Delete pop up title not matched,Kindly check", "deleteUserFromDetailPage");
				}

				verifyVisibilityOfButtons(driver, userDeletePopupBoxCancelButton, "Cancel Button", true);

				clickOnButton(driver, userDeletePopupBoxDeleteButton, "Delete Button", true);

				inVisible(driver, spinner, Constant.ruleWait);

				captureToastMsg(driver, toastMsg, popUpClose, userDeleteMessage, "User Delete Message");

			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void revisiteCreatedUserDetail(String usernameInputToCompare, String emailInputToCompare,
			String firstNameInputToCompare, String lastNameInputToCompare, String passwprdInputToCompare,
			String confirmInputToCompare) {
		try {

			searchUserOnLisitingPage(userName);

			clickOnSearchedUserName();

			verifyRetrivedValues(driver, userUsername, Constant.USERNAMELABLE, Constant.AttributeValue,
					usernameInputToCompare);

			verifyRetrivedValues(driver, userUsername, Constant.EMAILLABLE, Constant.AttributeValue,
					emailInputToCompare);

			verifyRetrivedValues(driver, userUsername, Constant.FIRSTNAMELABLE, Constant.AttributeValue,
					firstNameInputToCompare);

			verifyRetrivedValues(driver, userUsername, Constant.LASTNAMELABLE, Constant.AttributeValue,
					lastNameInputToCompare);

			verifyRetrivedValues(driver, userUsername, Constant.PASSWORDLABLE, Constant.AttributeValue,
					passwprdInputToCompare);

			verifyRetrivedValues(driver, userUsername, Constant.CONFIRMPASSWORDLABLE, Constant.AttributeValue,
					confirmInputToCompare);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void clickOnUserBreadcrumbLink(String icedqUser) {

		try {
			isDisplayedInLoop(driver, 5, userBreadCrumb);

			if (icedqUser.toLowerCase().contains("admin")) {

				clickOnButton(driver, userBreadCrumb, "Users Breadcrumb", true);

				if (isDisplayed(driver, discardAlertYes)) {

					isDisplayedInLoop(driver, 4, discardMsg);

					String str = getText(driver, discardMsg);

					BaseSuite.reportLog("Expected Title : " + discardChangesMessage);

					BaseSuite.reportLog("Actual Title : " + str);

					if (str.equalsIgnoreCase(discardChangesMessage)) {

						BaseSuite.validationReportLog("Expected Title and Actual Title matched successfully");

					} else {

						BaseSuite.reportFailLog("Expected Title and Actual Title not matched ",
								"clickOnUserBreadcrumbLink");

					}

					verifyVisibilityOfButtons(driver, discardAlertNo, "Cancel", true);

					clickOnButton(driver, discardAlertYes, "Discard", true);
				}

			} else {

				if (icedqUser.contains("account") || icedqUser.contains("workspace")) {

					clickOnButton(driver, homeBreadCrumb, "Home Breadcrumb", true);

				} else {
					BaseSuite.reportFailLog("Users breadcrumb link not visible",
							"clickOnConnectionRepoBreadcrumbLink1");

					driver.navigate().refresh();

					clickOnAdministrationTab();

					throw new AssertionError();

				}

			}
		} catch (Exception e) {

			e.getMessage();

			throw new AssertionError("Users breadcrumb link not clickable nor visible");
		}
	}

	public void verifyBreadCrumbs(String bredCrumb1, String bredCrumb2, String bredCrumb3) {
		try {
			List<String> expected = Arrays.asList(bredCrumb1, bredCrumb2, bredCrumb3);

			List<WebElement> breadcrumbs = getElements(driver, breadCrumb);

			for (int i = 0; i < expected.size(); i++) {

				String breadcrumb = breadcrumbs.get(i).getText();

				if (breadcrumb.equals(expected.get(i))) {

					isClickable(driver, returnElement(breadCrumbText, "$name", breadcrumb), breadcrumb, true);

				} else {

					BaseSuite.reportFailLog(breadcrumb + "breadcrumb is not present on the page,Kindly check!",
							"verifyBreadCrumbs");
				}
			}
		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void textHighlightedOrNot(By locator) {
		String color = getElement(driver, locator).getCssValue("color");

		String backcolor = getElement(driver, locator).getCssValue("background-color");

		System.out.println(color);

		System.out.println(backcolor);

		if (!color.equals(backcolor)) {

			System.out.println("Text is highlighted!");

		}

		else {

			System.out.println("Text is not highlighted!");
		}

	}

	public void toolTipVerify(String expectedVal, String label, By moveLocator, By toolTip)
			throws InterruptedException {

		try {
			moveToElement(driver, moveLocator);

			if (isDisplayed(driver, toolTip)) {
				String val = getText(driver, toolTip);

				if (val.equals(expectedVal)) {

					BaseSuite.validationReportLog(label + " Tooltip is enable on mouse hover");

				} else {

					BaseSuite
							.validationReportLog(label + " Tooltip is not enable on mouse hover for disabel Hamburger");

				}
			} else {
				BaseSuite.validationReportLog(label + " Tooltip is disable on mouse hover");

			}
		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void verifyUserListingPage() {
		try {
			boolean flag = isDisplayed(driver, iCEDQLogo);

			if (flag) {
				BaseSuite.validationReportLog("iCEDQ logo is visible ont the page");
			} else {
				BaseSuite.reportFailLog("iCEDQ logo is not visible ont the page", "verifyUserListingPage");
			}

			String breadCrumbHome = getAttribute(driver, homeBreadCrumb, "class");

			if (breadCrumbHome.contains("link")) {
				BaseSuite.validationReportLog("Home bread crumb is a Hyperlink");
			} else {
				BaseSuite.reportFailLog("Home bread crumb is not a Hyperlink", "verifyUserListingPage");
			}

			String breadCrumbAdmin = getAttribute(driver, adminBreadCrumb, "class");

			if (breadCrumbAdmin.contains("link")) {

				BaseSuite.reportFailLog("Administration bread crumb is a Hyperlink", "verifyUserListingPage");
			} else {
				BaseSuite.validationReportLog("Administration bread crumb is not a Hyperlink");
			}

			String breadCrumbUsers = getAttribute(driver, userBreadCrumb, "class");

			if (breadCrumbUsers.contains("link")) {

				BaseSuite.reportFailLog("Users bread crumb is a Hyperlink", "verifyUserListingPage");
			} else {
				BaseSuite.validationReportLog("Users bread crumb is not a Hyperlink");
			}

			verifyVisibilityOfButtons(driver, usersMenu, "Users Tab", true);

			verifyVisibilityOfButtons(driver, groupsTab, "Group Tab", true);

			verifyVisibilityOfButtons(driver, rolesTab, "Roles Tab", true);

			verifyVisibilityOfButtons(driver, accountsTab, "Accounts Tab", true);

			verifyVisibilityOfButtons(driver, workspacesTab, "Workspace Tab", true);

			verifyVisibilityOfButtons(driver, federationsTab, "Federation Tab", true);

			//verifyVisibilityOfButtons(driver, emailTab, "Email Tab", true);

			verifyVisibilityOfButtons(driver, vaultTab, "Vault Tab", true);

			verifyVisibilityOfButtons(driver, userPopUp, "User logo Tab", true);

			verifyVisibilityOfButtons(driver, dataTestingHamburger, "DataTesting Hamburger", true);

			toolTipVerify(dataTestingHamburgerText, "DataTesting Hamburger", dataTestingHamburger, toolTip);

			verifyVisibilityOfButtons(driver, connectionHamburger, "Connection Hamburger", true);

			toolTipVerify(connectionsHamburgerText, "Connection Hamburger", connectionHamburger, toolTip);

			verifyVisibilityOfButtons(driver, adminHamburger, "Admin Hamburger", true);

			toolTipVerify(administrationHamburgerText, "Admin Hamburger", adminHamburger, toolTip);

			verifyVisibilityOfHamburger(driver, dMOHamburger, "Data Monitoring and Observability Hamburger", false);

			// toolTipVerify("", "Data Monitoring and Observability Hamburger",
			// dMOHamburger, toolTip);

			verifyVisibilityOfHamburger(driver, dashboardHamburger, "Dashboard and Reporting Hamburger", true);

			// toolTipVerify("", "Dashboard and Reporting Hamburger", dashboardHamburger,
			// toolTip);

			verifyVisibilityOfHamburger(driver, ruleMonitoringHamburger, "Task and Issue Tracking Hamburger", false);

			// toolTipVerify("", "Task and Issue Tracking Hamburger",
			// ruleMonitoringHamburger, toolTip);

			verifyIndividualLabel(driver, userHeader, "User title");

			boolean searchFlag = isDisplayed(driver, userSearchOnLisitingPage);

			if (searchFlag) {
				BaseSuite.validationReportLog("Search bar displayed on the pge");

				String placeVal = getAttribute(driver, userSearchOnLisitingPage, "placeholder");

				if (placeVal.trim().equalsIgnoreCase(searchBarPlaceHolder)) {
					BaseSuite.validationReportLog("Placeholder displayed on the search bar");
				} else {
					BaseSuite.reportFailLog("Placeholder not displayed on the search bar", "verifyUserListingPage");
				}
			} else {
				BaseSuite.reportFailLog("Search bar not displayed on the pge", "verifyUserListingPage");
			}

			verifyVisibilityOfButtons(driver, newUsersButton, "New User", true);

			verifyVisibilityOfButtons(driver, refreshButtom, "Refresh User", true);

			verifyVisibilityOfButtons(driver, blockUserButtonOnListing, "Block User", false);

			verifyVisibilityOfButtons(driver, deleteUserButtonOnListing, "Delete User", false);

			verifyIndividualLabel(driver, fullNameHeader, "Full Name Header");

			verifyIndividualLabel(driver, userNameHeader, "User Name Header");

			verifyIndividualLabel(driver, statusHeader, "Status Header");

			verifyIndividualLabel(driver, emailHeader, "Email Header");

			verifyIndividualLabel(driver, identityHeader, "Identity Header");

			if (isDisplayed(driver, pageNumber)) {
				String pageNum = getText(driver, pageNumber);

				BaseSuite.validationReportLog(pageNum + " page number displayed on the page");

			}

			if (isDisplayed(driver, itemCount)) {
				String pageCount = getText(driver, itemCount);

				BaseSuite.validationReportLog(pageCount + " Item count displayed on the page");

			}

			String previousPage = getAttribute(driver, previousPageArrow, "class");

			if (previousPage.contains("disable")) {
				BaseSuite.validationReportLog("When user on the 1st page go to previous page button is disable");
			} else {
				BaseSuite.reportFailLog("When user on the 1st page go to previous page button is enable",
						"verifyUserListingPage");
			}

			String firstPage = getAttribute(driver, firstPageArrow, "class");

			if (firstPage.contains("disable")) {
				BaseSuite.validationReportLog("When user on the 1st page go to first page button is disable");
			} else {
				BaseSuite.reportFailLog("When user on the 1st page go to first page button is enable",
						"verifyUserListingPage");
			}

			displayAndClick(driver, lastPageArrow);

			inVisible(driver, spinner, Constant.ruleWait);

			String nextPage = getAttribute(driver, nextPageArrow, "class");

			if (nextPage.contains("disable")) {
				BaseSuite.validationReportLog("When user on the last page go to next page button is disable");
			} else {
				BaseSuite.reportFailLog("When user on the last page go to next page button is enable",
						"verifyUserListingPage");
			}

			String lastPage = getAttribute(driver, lastPageArrow, "class");

			if (lastPage.contains("disable")) {
				BaseSuite.validationReportLog("When user on the last page go to last page button is disable");
			} else {
				BaseSuite.reportFailLog("When user on the last page go to last page button is enable",
						"verifyUserListingPage");
			}

		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void verifyUserDetailPage() {
		try {
			clickOnUsersMenu();

			clickOnNewButton();

			verifyBreadCrumbs("Home", "Administration", "Users");

			String breadCrumbCreateNewUser = getAttribute(driver, createNewUserBreadCrum, "class");

			if (breadCrumbCreateNewUser.contains("link")) {

				BaseSuite.reportFailLog("Create new user bread crumb is a Hyperlink", "verifyUserDetailPage");
			} else {
				BaseSuite.validationReportLog("Create new user bread crumb is not a Hyperlink");
			}

			if (isDisplayed(driver, createNewUserHeadline)) {
				BaseSuite.validationReportLog("Create new user title is displayed on the page");
			} else {
				BaseSuite.reportFailLog("Create new user title is not display on the page", "verifyUserDetailPage");
			}

			/*
			 * if (isDisplayed(driver, createNewUserLeftArrow)) { BaseSuite.
			 * validationReportLog("Arrow is displayed on the left side of create new user title"
			 * ); } else { BaseSuite.
			 * reportFailLog("Arrow is not displayed on the left side of create new user title"
			 * , "verifyUserDetailPage"); }
			 */
			
			if (isDisplayed(driver, userIcon)) {
				BaseSuite.validationReportLog("User icon is displayed on the left side of create new user title");
			} else {
				BaseSuite.reportFailLog("User icon is not displayed on the left side of create new user title",
						"verifyUserDetailPage");
			}

			verifyVisibilityOfButtons(driver, userSaveButton, "Save Button", false);

			verifyVisibilityOfButtons(driver, discardButton, "Discard button", false);

			verifyVisibilityOfButtons(driver, deleteButton, "Delete button", false);

			verifyIndividualLabel(driver, returnElement(label, "$name", userNameLable), userNameLable);

			verifyPlaceHolder(userUsername, usernamePlaceHolder, "User Name");

			verifyIndividualLabel(driver, returnElement(label, "$name", emailLable), emailLable);

			verifyPlaceHolder(userEmail, emailPlaceHolder, "Email");

			verifyIndividualLabel(driver, returnElement(label, "$name", firstNameLable), firstNameLable);

			verifyPlaceHolder(userFirstname, firstNamePlaceHolder, "First Name");

			verifyIndividualLabel(driver, returnElement(label, "$name", lastNameLable), lastNameLable);

			verifyPlaceHolder(userLastname, lastNamePlaceHolder, "Last Name");

			verifyIndividualLabel(driver, returnElement(label, "$name", passwordLabel), passwordLabel);

			verifyPlaceHolder(userPassword, passwordPlaceHolder, "Password");

			verifyIndividualLabel(driver, returnElement(label, "$name", confirmPasswordLabel), confirmPasswordLabel);

			verifyPlaceHolder(userCPassword, confirmPasswordPlaceHolder, "Confirm Password");

			verifyVisibilityOfButtons(driver, passwordEyeIcon, "Show password button on password field", true);

			verifyVisibilityOfButtons(driver, confirmPasswordEyeIcon, "Show password button on confirm password field",
					true);

			enterUserName(usernameDetails);

			verifyVisibilityOfButtons(driver, discardButton, "Discard button", true);

			groupGUIOnUserDetailPage();

			accountGUIOnUserDetailPage();

			workspaceGUIOnUserDetailPage();

		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void verifyNavigationFunctionality(AdministrationParameters param) {
		String breadCrumbCreateNewUser;

		boolean flag;

		try {
			HomePage home = new HomePage(driver);

			clickOnUsersMenu();

			clickOnNewButton();

			verifyBreadCrumbs("Home", "Administration", "Users");

			breadCrumbCreateNewUser = getAttribute(driver, createNewUserBreadCrum, "class");

			if (breadCrumbCreateNewUser.equals("link")) {

				BaseSuite.reportFailLog("Create new user bread crumb is a Hyperlink", "verifyUserDetailPage");
			} else {
				BaseSuite.validationReportLog("Create new user bread crumb is not a Hyperlink");
			}

			clickOnButton(driver, userBreadCrumb, "Users Breadcrumb", true);

			inVisible(driver, spinner, Constant.ruleWait);

			flag = verifyIndividualLabel(driver, userHeader, "User title");

			if (flag) {
				BaseSuite.validationReportLog("Landed to user listing page after click on User Hyperlink");
			} else {
				BaseSuite.reportFailLog("Not able to Land on user listing page after click on User Hyperlink",
						"verifyNavigationFunctionality");

			}

			clickOnNewButton();

			verifyBreadCrumbs("Home", "Administration", "Users");

			breadCrumbCreateNewUser = getAttribute(driver, createNewUserBreadCrum, "href");

			if (breadCrumbCreateNewUser != null && breadCrumbCreateNewUser.contains("https")) {

				BaseSuite.reportFailLog("Create new user bread crumb is a Hyperlink", "verifyUserDetailPage");
			} else {
				BaseSuite.validationReportLog("Create new user bread crumb is not a Hyperlink");
			}

			clickOnButton(driver, administrationBreadCrumb, "Administration Breadcrumb", true);

			inVisible(driver, spinner, Constant.ruleWait);

			flag = verifyIndividualLabel(driver, userHeader, "User title");

			if (flag) {
				BaseSuite.validationReportLog("Landed to user listing page after click on Administration Hyperlink");
			} else {
				BaseSuite.reportFailLog("Not able to Land on user listing page after click on Administration Hyperlink",
						"verifyNavigationFunctionality");

			}

			clickOnNewButton();

			verifyBreadCrumbs("Home", "Administration", "Users");

			breadCrumbCreateNewUser = getAttribute(driver, createNewUserBreadCrum, "href");

			if (breadCrumbCreateNewUser != null && breadCrumbCreateNewUser.contains("https")) {

				BaseSuite.reportFailLog("Create new user bread crumb is a Hyperlink", "verifyUserDetailPage");
			} else {
				BaseSuite.validationReportLog("Create new user bread crumb is not a Hyperlink");
			}

			clickOnButton(driver, homeBreadCrumb, "Home Breadcrumb", true);

			inVisible(driver, spinner, Constant.ruleWait);

			flag = verifyIndividualLabel(driver, home.homePageWellcomeMsg, "User title");

			if (flag) {
				BaseSuite.validationReportLog("Landed to home page after click on Home Hyperlink");
			} else {
				BaseSuite.reportFailLog("Not able to Land on home page after click on Home Hyperlink",
						"verifyNavigationFunctionality");

			}

			clickOnButton(driver, AdministrationLabel, "Admin module", true);

			flag = verifyIndividualLabel(driver, userHeader, "User title");

			if (flag) {
				BaseSuite.validationReportLog("Landed to user listing page after click on Administration Module");
			} else {
				BaseSuite.reportFailLog("Not able to Land on user listing page after click on Administration Module",
						"verifyNavigationFunctionality");

			}
			Thread.sleep(5000);
			searchUserOnLisitingPage(param.getUserNameVal());

			clickOnSearchedUserName();

			searchGroup(param.getGropDetail());

			displayAndClick(driver, returnElement(groupName, "$name", param.getGropDetail()));

			inVisible(driver, spinner, Constant.ruleWait);

			Thread.sleep(2000);

			verifyBreadCrumbs("Home", "Administration", "Groups");

			String val = getAttribute(driver, groupTab, "class");

			if (val.equals("link")) {
				BaseSuite.validationReportLog("Successfully redirected to Group Tab");

				boolean flagLabel = verifyIndividualLabel(driver, userGroupName, "Group Name");

				String groupName = getText(driver, userNameBreadCrumb);

				if (groupName.equals(param.getGropDetail()) && flagLabel) {
					BaseSuite.validationReportLog(
							"Landed to the group page after click on group name from user detail page");

				} else {
					BaseSuite.reportFailLog(
							"Not landed to the group page after click on group name from user detail page",
							"verifyNavigationFunctionality");
				}

				driver.navigate().back();

				inVisible(driver, spinner, Constant.ruleWait);

				Thread.sleep(2000);

				String userName = getAttribute(driver, userUsername, "value");

				boolean flagUsernameLabel = verifyIndividualLabel(driver, returnElement(label, "$name", userNameLable),
						userNameLable);

				if (userName.equals(param.getUserNameVal()) && flagUsernameLabel) {
					BaseSuite.validationReportLog(
							"Landed to the user page after click on left arrow from group detail page");

				} else {
					BaseSuite.reportFailLog(
							"Not Landed to the user page after click on left arrow from group detail page",
							"verifyNavigationFunctionality");
				}

			} else {
				BaseSuite.reportFailLog("Not able to redirect to Group tab", "verifyNavigationFunctionality");

			}

			javascript(driver, scrollToElementArg, userAccountButton);

			displayAndClick(driver, userAccountButton);

			inVisible(driver, spinner, Constant.ruleWait);

			searchAccount(param.getAccountDetail());

			displayAndClick(driver, returnElement(groupName, "$name", param.getAccountDetail()));

			inVisible(driver, spinner, Constant.ruleWait);

			Thread.sleep(2000);

			verifyBreadCrumbs("Home", "Administration", "Accounts");

			String valAccount = getAttribute(driver, accountTab, "class");

			if (valAccount.equals("link")) {
				BaseSuite.validationReportLog("Successfully redirected to Account Tab");

				boolean flagLabel = verifyIndividualLabel(driver, userAccountName, "Account Name");

				String accountName = getText(driver, userNameBreadCrumb);

				if (accountName.equals(param.getAccountDetail()) && flagLabel) {
					BaseSuite.validationReportLog(
							"Landed to the account page after click on accounts name from user detail page");

				} else {
					BaseSuite.reportFailLog(
							"Not landed to the account page after click on account name from user detail page",
							"verifyNavigationFunctionality");
				}

				driver.navigate().back();

				inVisible(driver, spinner, Constant.ruleWait);

				Thread.sleep(2000);

				String userName = getAttribute(driver, userUsername, "value");

				boolean flagUsernameLabel = verifyIndividualLabel(driver, returnElement(label, "$name", userNameLable),
						userNameLable);

				if (userName.equals(param.getUserNameVal()) && flagUsernameLabel) {
					BaseSuite.validationReportLog(
							"Landed to the user page after click on left arrow from account detail page");

				} else {
					BaseSuite.reportFailLog(
							"Not Landed to the user page after click on left arrow from account detail page",
							"verifyNavigationFunctionality");
				}

			} else {
				BaseSuite.reportFailLog("Not able to redirect to Account tab", "verifyNavigationFunctionality");

			}

			javascript(driver, scrollToElementArg, userWrokspaceButton);

			displayAndClick(driver, userWrokspaceButton);

			inVisible(driver, spinner, Constant.ruleWait);

			searchWorkspace(param.getWorkspaceDetail());

			displayAndClick(driver, returnElement(groupName, "$name", param.getWorkspaceDetail()));

			inVisible(driver, spinner, Constant.ruleWait);

			Thread.sleep(2000);

			verifyBreadCrumbs("Home", "Administration", "Workspaces");

			String valWorkspace = getAttribute(driver, workspaceTab, "class");

			if (valWorkspace.equals("link")) {
				BaseSuite.validationReportLog("Successfully redirected to Workspace Tab");

				boolean flagLabel = verifyIndividualLabel(driver, userWorkspaceName, "Workspace Name");

				String workspaceName = getText(driver, userNameBreadCrumb);

				if (workspaceName.trim().equals(param.getWorkspaceDetail()) && flagLabel) {
					BaseSuite.validationReportLog(
							"Landed to the workspace page after click on workspace name from user detail page");

				} else {
					BaseSuite.reportFailLog(
							"Not landed to the workspace page after click on workspace name from user detail page",
							"verifyNavigationFunctionality");
				}

				driver.navigate().back();

				inVisible(driver, spinner, Constant.ruleWait);

				Thread.sleep(2000);

				String userName = getAttribute(driver, userUsername, "value");

				boolean flagUsernameLabel = verifyIndividualLabel(driver, returnElement(label, "$name", userNameLable),
						userNameLable);

				if (userName.equals(param.getUserNameVal()) && flagUsernameLabel) {
					BaseSuite.validationReportLog(
							"Landed to the user page after click on left arrow from workspace detail page");

				} else {
					BaseSuite.reportFailLog(
							"Not Landed to the user page after click on left arrow from workspace detail page",
							"verifyNavigationFunctionality");
				}

			} else {
				BaseSuite.reportFailLog("Not able to redirect to workspace tab", "verifyNavigationFunctionality");

			}

		} catch (Exception e) {

			throw new AssertionError();
		}
	}

	public void groupGUIOnUserDetailPage() {
		try {
			javascript(driver, scrollToElementArg, groupSearchBox);

			boolean searchFlag = isDisplayed(driver, groupSearchBox);

			boolean searchBarFlag = isDisplayed(driver, groupSearchBar);

			if (searchFlag && searchBarFlag) {
				BaseSuite.validationReportLog("Search box and Search bar displayed on the pge");

				String placeVal = getAttribute(driver, groupSearchBox, "placeholder");

				if (placeVal.trim().equalsIgnoreCase(groupSearchBarPlaceHolder)) {
					BaseSuite.validationReportLog("Placeholder displayed on the search box");
				} else {
					BaseSuite.reportFailLog("Placeholder not displayed on the search box", "verifyUserDetailPage");
				}
			} else {
				BaseSuite.reportFailLog("Search box/Search bar not displayed on the pge", "verifyUserDetailPage");
			}

			verifyVisibilityOfButtons(driver, userAssignBtn, "Assign button", false);

			verifyVisibilityOfButtons(driver, userRefereshButtonInsideAssignPage, "Refresh button", false);

			verifyVisibilityOfButtons(driver, groupRemoveButton, "Delete button", false);

			verifyIndividualLabel(driver, gridGroupName, "Name column");

			verifyIndividualLabel(driver, gridGroupPath, "Path column");

			verifyVisibilityOfButtons(driver, groupCheckBoxClick, "Master check Box", true);

			if (isDisplayed(driver, noRecordFound)) {
				BaseSuite.validationReportLog("No records to display text is visible on group section");
			} else {
				BaseSuite.reportFailLog("No records to display text is not visible on group section",
						"verifyUserDetailPage");

			}

			if (isDisplayed(driver, pageNumber)) {
				String pageNum = getText(driver, pageNumber);

				BaseSuite.validationReportLog(pageNum + " page number displayed on the page");

			}

			if (isDisplayed(driver, itemCount)) {
				String pageCount = getText(driver, itemCount);

				BaseSuite.validationReportLog(pageCount + " Item count displayed on the page");

			}

			String previousPage = getAttribute(driver, previousPageArrow, "class");

			if (previousPage.contains("disable")) {
				BaseSuite.validationReportLog("Go to previous page button is disable on the page");
			} else {
				BaseSuite.reportFailLog("Go to previous page button is enable", "verifyUserDetailPage");
			}

			String firstPage = getAttribute(driver, firstPageArrow, "class");

			if (firstPage.contains("disable")) {
				BaseSuite.validationReportLog("Go to first page button is disable on the page");
			} else {
				BaseSuite.reportFailLog("Go to first page button is enable", "verifyUserDetailPage");
			}

			String nextPage = getAttribute(driver, nextPageArrow, "class");

			if (nextPage.contains("disable")) {
				BaseSuite.validationReportLog("Go to next page button is disable on the page");
			} else {
				BaseSuite.reportFailLog("Go to next page button is enable", "verifyUserDetailPage");
			}

			String lastPage = getAttribute(driver, lastPageArrow, "class");

			if (lastPage.contains("disable")) {
				BaseSuite.validationReportLog("Go to last page button is disable on the page");
			} else {
				BaseSuite.reportFailLog("Go to last page button is enable", "verifyUserDetailPage");
			}
		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void accountGUIOnUserDetailPage() {
		try {
			javascript(driver, scrollToElementArg, userAccountButton);

			displayAndClick(driver, userAccountButton);

			inVisible(driver, spinner, Constant.ruleWait);

			boolean searchFlag = isDisplayed(driver, accountSearchBox);

			boolean searchBarFlag = isDisplayed(driver, accountSearchBar);

			if (searchFlag && searchBarFlag) {
				BaseSuite.validationReportLog("Search box and Search bar displayed on the pge");

				String placeVal = getAttribute(driver, accountSearchBox, "placeholder");

				if (placeVal.trim().equalsIgnoreCase(accountSearchBarPlaceHolder)) {
					BaseSuite.validationReportLog("Placeholder displayed on the search box");
				} else {
					BaseSuite.reportFailLog("Placeholder not displayed on the search box", "verifyUserDetailPage");
				}
			} else {
				BaseSuite.reportFailLog("Search box/Search bar not displayed on the pge", "verifyUserDetailPage");
			}

			verifyVisibilityOfButtons(driver, accountRefreshButton, "Refresh button", false);

			verifyIndividualLabel(driver, gridAccountName, "Name column");

			verifyIndividualLabel(driver, gridAccountRole, "Role column");

			verifyIndividualLabel(driver, gridAccountScope, "Scope column");

			if (isDisplayed(driver, accountNoRecordItem)) {
				BaseSuite.validationReportLog("No records to display text is visible on account section");
			} else {
				BaseSuite.reportFailLog("No records to display text is not visible on account section",
						"accountGUIOnUserDetailPage");

			}

			if (isDisplayed(driver, accountPageCount)) {
				String pageNum = getText(driver, accountPageCount);

				BaseSuite.validationReportLog(pageNum + " page number displayed on the page");

			}

			if (isDisplayed(driver, accountItemCount)) {
				String pageCount = getText(driver, accountItemCount);

				BaseSuite.validationReportLog(pageCount + " Item count displayed on the page");

			}

			String previousPage = getAttribute(driver, accountPreviousButton, "class");

			if (previousPage.contains("disable")) {
				BaseSuite.validationReportLog("Go to previous page button is disable on the page");
			} else {
				BaseSuite.reportFailLog("Go to previous page button is enable", "verifyUserDetailPage");
			}

			String firstPage = getAttribute(driver, accountFirstPageButton, "class");

			if (firstPage.contains("disable")) {
				BaseSuite.validationReportLog("Go to first page button is disable on the page");
			} else {
				BaseSuite.reportFailLog("Go to first page button is enable", "verifyUserDetailPage");
			}

			String nextPage = getAttribute(driver, accountNextPageButton, "class");

			if (nextPage.contains("disable")) {
				BaseSuite.validationReportLog("Go to next page button is disable on the page");
			} else {
				BaseSuite.reportFailLog("Go to next page button is enable", "verifyUserDetailPage");
			}

			String lastPage = getAttribute(driver, accountLastPageButton, "class");

			if (lastPage.contains("disable")) {
				BaseSuite.validationReportLog("Go to last page button is disable on the page");
			} else {
				BaseSuite.reportFailLog("Go to last page button is enable", "verifyUserDetailPage");
			}
		} catch (Exception e) {
			throw new AssertionError();
		}

	}

	public void workspaceGUIOnUserDetailPage() {
		try {
			javascript(driver, scrollToElementArg, userWrokspaceButton);

			displayAndClick(driver, userWrokspaceButton);

			inVisible(driver, spinner, Constant.ruleWait);

			boolean searchFlag = isDisplayed(driver, workspaceSearchBox);

			boolean searchBarFlag = isDisplayed(driver, workspaceSearchBar);

			if (searchFlag && searchBarFlag) {
				BaseSuite.validationReportLog("Search box and Search bar displayed on the pge");

				String placeVal = getAttribute(driver, workspaceSearchBox, "placeholder");

				if (placeVal.trim().equalsIgnoreCase(workspaceSearchBarPlaceHolder)) {
					BaseSuite.validationReportLog("Placeholder displayed on the search box");
				} else {
					BaseSuite.reportFailLog("Placeholder not displayed on the search box",
							"workspaceGUIOnUserDetailPage");
				}
			} else {
				BaseSuite.reportFailLog("Search box/Search bar not displayed on the pge",
						"workspaceGUIOnUserDetailPage");
			}

			verifyVisibilityOfButtons(driver, workspaceRefreshButton, "Refresh button", false);

			verifyIndividualLabel(driver, gridWorkspaceName, "Name column");

			verifyIndividualLabel(driver, gridWorkspaceRole, "Role column");

			verifyIndividualLabel(driver, gridWorkspaceType, "Type column");

			verifyIndividualLabel(driver, gridWorkspaceScope, "Scope column");

			if (isDisplayed(driver, workspaceNoRecordItem)) {
				BaseSuite.validationReportLog("No records to display text is visible on workspace section");
			} else {
				BaseSuite.reportFailLog("No records to display text is not visible on workspace section",
						"workspaceGUIOnUserDetailPage");

			}

			if (isDisplayed(driver, workspacePageCount)) {
				String pageNum = getText(driver, workspacePageCount);

				BaseSuite.validationReportLog(pageNum + " page number displayed on the page");

			}

			if (isDisplayed(driver, workspaceItemCount)) {
				String pageCount = getText(driver, workspaceItemCount);

				BaseSuite.validationReportLog(pageCount + " Item count displayed on the page");

			}

			String previousPage = getAttribute(driver, workspacePreviousButton, "class");

			if (previousPage.contains("disable")) {
				BaseSuite.validationReportLog("Go to previous page button is disable on the page");
			} else {
				BaseSuite.reportFailLog("Go to previous page button is enable", "verifyUserDetailPage");
			}

			String firstPage = getAttribute(driver, workspaceFirstButton, "class");

			if (firstPage.contains("disable")) {
				BaseSuite.validationReportLog("Go to first page button is disable on the page");
			} else {
				BaseSuite.reportFailLog("Go to first page button is enable", "verifyUserDetailPage");
			}

			String nextPage = getAttribute(driver, workspaceNextButton, "class");

			if (nextPage.contains("disable")) {
				BaseSuite.validationReportLog("Go to next page button is disable on the page");
			} else {
				BaseSuite.reportFailLog("Go to next page button is enable", "verifyUserDetailPage");
			}

			String lastPage = getAttribute(driver, workspaceLastButton, "class");

			if (lastPage.contains("disable")) {
				BaseSuite.validationReportLog("Go to last page button is disable on the page");
			} else {
				BaseSuite.reportFailLog("Go to last page button is enable", "verifyUserDetailPage");
			}

		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void verifyPlaceHolder(By locator, String expectedVal, String placeHolderName) {
		try {
			String placeVal = getAttribute(driver, locator, "placeholder");

			if (placeVal.trim().equalsIgnoreCase(expectedVal)) {
				BaseSuite.validationReportLog(placeHolderName + " Placeholder displayed on the page");
			} else {
				BaseSuite.reportFailLog(placeHolderName + " Placeholder not displayed on the page",
						"verifyPlaceHolder");
			}
		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public boolean verifyVisibilityOfHamburger(WebDriver driver, By locator, String buttonName, boolean expected) {
		SoftAssert soft = new SoftAssert();
		boolean status = true;
		try {
			BaseSuite.reportLog("Verifying for button " + buttonName);

			waitForElement(driver, locator);

			String val = getAttribute(driver, locator, "class");

			if (val.contains("disable")) {
				status = false;

				BaseSuite.validationReportLog(buttonName + " button is disabled in the page");
			} else {

				BaseSuite.validationReportLog(buttonName + " button is enable in the page");
			}

			soft.assertEquals(status, expected, buttonName + " button is expected to be " + expected
					+ " & actual status of button as " + status + " :: ");
			boolean isEqual = (status == expected);
			if (isEqual) {
				status = true;
				BaseSuite.validationReportLog(buttonName + " button visibility is matched with expected condition");
			} else {
				BaseSuite.reportFailLog(buttonName + " button is expected to be " + expected
						+ " & actual status of button as " + status, "verifyVisibilityOfButtons");
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return status;
	}

	public void searchResultWithInvalidData(AdministrationParameters param) {
		try {

			searchUserOnLisitingPage(param.getUserNameVal());

			if (isDisplayed(driver, noRecordFound)) {

				BaseSuite.validationReportLog(
						"No records to display for invalid searched result: " + param.getUserNameVal());

				displayAndClick(driver, userSearchOnLisitingPage);

				displayAndClick(driver, userSearchBarClear);

			} else {

				BaseSuite.reportFailLog("Records is display for invalid searched result: " + param.getUserNameVal(),
						"searchResultWithInvalidData");
			}

		} catch (Exception e) {

			throw new AssertionError();
		}

	}

	public void invalidBlockUser(AdministrationParameters param) {
		try {
			HomePage home = new HomePage(driver);

			searchUserOnLisitingPage(param.getUserNameVal());

			displayAndClick(driver, groupCheckBoxClick);

			verifyVisibilityOfButtons(driver, blockUserButtonOnListing, "User Block Button", true);

			verifyVisibilityOfButtons(driver, deleteUserButtonOnListing, "Delete Button", true);

			blockUser();

			driver.manage().timeouts().pageLoadTimeout(Constant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

			if (isDisplayed(driver, userNameLogin) && isDisplayed(driver, passWord) && isDisplayed(driver, signin)) {

				BaseSuite.validationReportLog(param.getUserNameVal() + " User loggedout successfully after blocked it");

				Thread.sleep(2000);

				enterValueToTextField(driver, userNameLogin, "Username", param.getUserNameVal());

				Thread.sleep(2000);

				enterValueToTextField(driver, passWord, "Password", param.getPasswordVal());

				clickOnButton(driver, signin, "Sign In", true);

				String val = getText(driver, blockedUserLoginMess);

				if (val.equalsIgnoreCase(userBlockedMessage)) {

					BaseSuite.validationReportLog(
							param.getUserNameVal() + " User not able to loggedin the app after it's blocked");
				} else {

					BaseSuite.reportFailLog(
							param.getUserNameVal() + " User able to loggedin the app after it's blocked,Kindly check",
							"invalidBlockUser");
				}

				enterValueToTextField(driver, userNameLogin, "Username", searchUserName);

				Thread.sleep(2000);

				enterValueToTextField(driver, passWord, "Password", loginPasswordLabel);

				clickOnButton(driver, signin, "Sign In", true);

				home.administration();

				searchUserOnLisitingPage(param.getUserNameVal());

				displayAndClick(driver, groupCheckBoxClick);

				BaseSuite.validationReportLog("Checkbox clicked successfully");

				verifyVisibilityOfButtons(driver, blockUserButtonOnListing, "User Block Button", false);

				verifyVisibilityOfButtons(driver, unblockUserButtonOnListing, "Unblock Button", true);

				verifyVisibilityOfButtons(driver, deleteUserButtonOnListing, "Delete Button", true);

				unBlockUser();

			} else {

				BaseSuite.reportFailLog(
						param.getUserNameVal()
								+ " User still loggedin on the application after blocked it,Kindly check!",
						"invalidBlockUser");
			}

		} catch (Exception e) {

			throw new AssertionError();
		}

	}

}
