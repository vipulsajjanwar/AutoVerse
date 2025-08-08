package nexgen.automation.framework.connectionRepo;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import com.atlassian.jira.rest.client.api.RestClientException;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;
import nexgen.automation.pageclasses.otherpages.HomePage;
import nexgen.automation.pageclasses.otherpages.LoginPage;
import nextgen.automation.RuleRepo.pages.DataTestingParameters;
import nextgen.automation.RuleRepo.pages.TestDataThroughApi;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NewConnectionRepoPage extends PageUtil {
	WebDriver driver;

	public NewConnectionRepoPage(WebDriver driver) {
		this.driver = driver;
	}

	static ReadConfig readconfig = new ReadConfig();
	// *************************************** UI
	// Elements********************************************************************************
	By LoggedInMsg = getElementLocator(prop.getProperty("Login.LoggedInMsg"));
	By toastMsg = getElementLocator(prop.getProperty("Commontoastmsg"));
	By ToastMsgClosedBtn = getElementLocator(prop.getProperty("ToastMsgClosedBtn"));
	By pagelabel = getElementLocator(prop.getProperty("Connection.PageLabel"));
	By ClickonDataConnection = getElementLocator(prop.getProperty("Connection.connectionLabel"));
	By clickonNewConnection = getElementLocator(prop.getProperty("Connection.newConnection"));
	By connectionPageSpinner = getElementLocator(prop.getProperty("Connection.spinnershow"));
	By clickonRefresh = getElementLocator(prop.getProperty("Connection.refresh"));
	By brdCrumsHomeLink = getElementLocator(prop.getProperty("Connection.HomeLink1"));
	By brdCrumsConnRepo = getElementLocator(prop.getProperty("Connection.ConnRepoLink"));
	By brdCrumsConnections = getElementLocator(prop.getProperty("Connection.ConnectionBr"));
	By connectionLabels = getElementLocator(prop.getProperty("ConnectionsLabel"));
	By landingPageAllBtn = getElementLocator(prop.getProperty("landingPageAllBtn"));
	By clickonDisable = getElementLocator(prop.getProperty("Connection.disable"));
	By advancedSearchButton = getElementLocator(prop.getProperty("AdvancedSearchButton"));
	By connectionNameLabel = getElementLocator(prop.getProperty("connectionNameLabel"));
	By typeLabel = getElementLocator(prop.getProperty("typeLabel1"));
	By updatedByLabel = getElementLocator(prop.getProperty("UpdatedByLabel"));
	By connectionType = getElementLocator(prop.getProperty("ConnectionTypeLabel"));
	By lastModified = getElementLocator(prop.getProperty("landLastModified"));
	By searchBar = getElementLocator(prop.getProperty("Connection.SearchBox"));
	By searchBclick = getElementLocator(prop.getProperty("Connection.SearchButton"));
	By noRecondsFound = getElementLocator(prop.getProperty("noRecondsFound"));
	By disableWinTitle = getElementLocator(prop.getProperty("disableWinTitle"));
	By disablePopUpMsg = getElementLocator(prop.getProperty("disablePopUpMsg"));
	By disableNoOption = getElementLocator(prop.getProperty("Connection.disableNo1"));
	By disableYesOption = getElementLocator(prop.getProperty("Connection.disableYes1"));
	By connSingleCheck = getElementLocator(prop.getProperty("connSingleCheck"));
	By connectionCheckbox = getElementLocator(prop.getProperty("connectionCheckbox"));
	By popUpClose = getElementLocator(prop.getProperty("PopUpClose"));
	By connectionNameClick1 = getElementLocator(prop.getProperty("connectionNameClick1"));
	By connectionNameClick = getElementLocator(prop.getProperty("connectionNameClick"));
	By newConnectionNameSearch = getElementLocator(prop.getProperty("newConnectionNameSearch"));
	By connectionImg = getElementLocator(prop.getProperty("connectionImg"));
	By connPaginationIcon = getElementLocator(prop.getProperty("connPaginationIcon"));
	By listOfConnName = getElementLocator(prop.getProperty("listOfConnName"));
	By connectionRepoLeftPanel = getElementLocator(prop.getProperty("ConnectionRepoLeftPanel"));
	By connectionTab = getElementLocator(prop.getProperty("Connection.ConnectionTab"));
	By userconnectionTab = getElementLocator(prop.getProperty("Connection.UserConnectionTab"));
	By advanceSearchButton = getElementLocator(prop.getProperty("AdvancedSearchButton"));
	By connPaginationMsg = getElementLocator(prop.getProperty("Connection.PaginationMsg"));
	By connPaginationBar = getElementLocator(prop.getProperty("Connection.PaginationBar"));
	By pageArrows = getElementLocator(prop.getProperty("Connection.PageArrow"));
	By mainHeadingTitle = getElementLocator(prop.getProperty("Connection.MainHeadingTitle"));
	By leftArrow_connection = getElementLocator(prop.getProperty("Connection.LeftSideBarArrowClose"));
	By leftArrowOpen_connection = getElementLocator(prop.getProperty("Connection.LeftSiderBarArrowOpen"));
	By advanceSearchTitle = getElementLocator(prop.getProperty("Connection.AdvanceSearchTitle"));
	By selectConnType = getElementLocator(prop.getProperty("Connection.SelectConnType"));
	By selectConnType1 = getElementLocator(prop.getProperty("Connection.SelectConnType1"));
	By selectConnType2 = getElementLocator(prop.getProperty("Connection.SelectConnType2"));
	By connTypeTitle = getElementLocator(prop.getProperty("Connection.ConnectionTypeTitle"));
	By createdByTitle = getElementLocator(prop.getProperty("Connection.CreatedByTitle"));
	By updatedByTitle = getElementLocator(prop.getProperty("Connection.UpdatedByTitle"));
	By createdDateTitle = getElementLocator(prop.getProperty("Connection.CreatedDateTitle"));
	By updatedDateTitle = getElementLocator(prop.getProperty("Connection.UpdatedDateTitle"));
	By createdBydropdown = getElementLocator(prop.getProperty("Connection.CreatedByDropdown"));
	By createdBypopup = getElementLocator(prop.getProperty("Connection.CreatedByPopup"));
	By createdBySearch = getElementLocator(prop.getProperty("Connection.CreatedBySearch"));
	By createdBysearchBar = getElementLocator(prop.getProperty("Connection.CreatedBysearchBar"));
	By UpdatedBydropdown = getElementLocator(prop.getProperty("Connection.UpdatedByDropdown"));
	By UpdatedBypopup = getElementLocator(prop.getProperty("Connection.UpdatedByPopup"));
	By UpdatedBySearch = getElementLocator(prop.getProperty("Connection.UpdatedBySearch"));
	By UpdatedBysearchBar = getElementLocator(prop.getProperty("Connection.UpdatedBysearchBar"));
	By createDateSearch = getElementLocator(prop.getProperty("Connection.CreateDateSearch"));
	By updateDateSearch = getElementLocator(prop.getProperty("Connection.UpdateDateSearch"));
	By searchButton = getElementLocator(prop.getProperty("Connection.SearchButton"));
	By adSearchBtn = getElementLocator(prop.getProperty("Connection.advanceSearchBtn"));
	By selectWorkspaceClick = getElementLocator(prop.getProperty("Connection.SelectWorkspaceClick"));
	By selectWorkspaceSearch = getElementLocator(prop.getProperty("Connection.SelectWorkspaceSearch"));
	By connectionName = getElementLocator(prop.getProperty("ConnectionB.connectionName"));
	By selectDriver = getElementLocator(prop.getProperty("Connection.SelectDriver"));
	By selectAuthentication = getElementLocator(prop.getProperty("Connection.SelectAuthentication"));
	By customJdbcUrlToggleButton = getElementLocator(prop.getProperty("Connection.CustomJdbcUrlToggleButton"));
	By connectionFullUrl = getElementLocator(prop.getProperty("ConnectionB.EnterFullUrl"));
	By clickonConnectionHost = getElementLocator(prop.getProperty("ConnectionB.ClickonConnectionHost"));
	By clickonConnectionPort = getElementLocator(prop.getProperty("ConnectionB.ClickonConnectionPort"));
	By clickonDatabase = getElementLocator(prop.getProperty("ConnectionB.ClickonDatabase"));
	By enterUsername = getElementLocator(prop.getProperty("ConnectionB.EnterUsername"));
	By enterPassword = getElementLocator(prop.getProperty("ConnectionB.EnterPassword"));
	By connTestBtn = getElementLocator(prop.getProperty("connTestBtn"));
	By connSaveBtn = getElementLocator(prop.getProperty("connSaveBtn"));
	By discardButtonsDetails = getElementLocator(prop.getProperty("conn.DetailsDiscardButton"));
	By connCrawlIconBtn = getElementLocator(prop.getProperty("conn.CrawlIconBtn"));
	String connAllFieldValidation = prop.getProperty("conn.All.feild.validation");
	By addConnProperty = getElementLocator(prop.getProperty("Connection.AddConnProperty"));
	By connectionProperties = getElementLocator(prop.getProperty("ConnectionB.ConnectionProperties"));
	By addPropertyName = getElementLocator(prop.getProperty("Connection.AddPropertyName"));
	By addPropertyValue = getElementLocator(prop.getProperty("Connection.AddPropertyValue"));

	By addPropertyValueInput = getElementLocator(prop.getProperty("Connection.AddPropertyValue.Input"));

	By addpropertyValueInput = getElementLocator(prop.getProperty("Connection.AddPropertyValue.input"));

	By addPropertyTypeClick = getElementLocator(prop.getProperty("Connection.AddPropertyTypeClick"));
	By addPropertyDone = getElementLocator(prop.getProperty("Connection.AddPropertyDone"));
	By addPropertyCancel = getElementLocator(prop.getProperty("Connection.AddPropertyCancel"));
	By serverName = getElementLocator(prop.getProperty("Connection.ServerName"));
	By dsnName = getElementLocator(prop.getProperty("Connection.DSNName"));
	By saveConnection = getElementLocator(prop.getProperty("ConnectionB.SaveConnection"));
	By testconnectionToast = getElementLocator(prop.getProperty("ConnectionB.TestconnectionToast"));
	By spinner = getElementLocator(prop.getProperty("Conn.Spinner.AfterRefresh"));
	By connPrepertySearchBarButton = getElementLocator(prop.getProperty("Connection.ConnPrepertySearchBarButton"));
	By connPrepertySearchBar = getElementLocator(prop.getProperty("Connection.ConnPrepertySearchBar"));
	By acountIdentifier = getElementLocator(prop.getProperty("Connection.AcountIdentifier"));
	By region = getElementLocator(prop.getProperty("Connection.Region"));
	By cloudPlatform = getElementLocator(prop.getProperty("Connection.CloudPlatform"));
	By wareHouse = getElementLocator(prop.getProperty("Connection.WareHouse"));
	By keyFilePath = getElementLocator(prop.getProperty("Connection.KeyFilePath"));
	By KeyFileContent = getElementLocator(prop.getProperty("Connection.KeyFileContent"));
	By KeyFilePassword = getElementLocator(prop.getProperty("Connection.KeyFilePassword"));
	By connKeyfileContentPasswordfeild = getElementLocator(
			prop.getProperty("Connection.secretPassword.KeyfileContent.feild"));
	By connKeyfilePasswordfeild = getElementLocator(prop.getProperty("Connection.secret.keyfilePassword.feild"));
	By keyVaultName = getElementLocator(prop.getProperty("Connection.keyVaultName"));
	By clientId = getElementLocator(prop.getProperty("Connection.clientId"));
	By tenantId = getElementLocator(prop.getProperty("Connection.tenantId"));
	By clientSecret = getElementLocator(prop.getProperty("Connection.clientSecret"));
	By privateKeySecretName = getElementLocator(prop.getProperty("Connection.privateKeySecretName"));
	By privateKeyPasswordSecretName = getElementLocator(prop.getProperty("Connection.privateKeyPasswordSecretName"));
	By databaseName = getElementLocator(prop.getProperty("Connection.DatabaseName"));
	By discardBtnNewConn = getElementLocator(prop.getProperty("Connection.DiscardButtonOnNewConnectionPage"));
	By discardBtnPopup = getElementLocator(prop.getProperty("connDiscardYesBtn"));
	By instanceName = getElementLocator(prop.getProperty("ConnectionR.InstanceName"));
	By domainName = getElementLocator(prop.getProperty("ConnectionR.DomainName"));
	By chooseConnectionType_SearchTxt = getElementLocator(prop.getProperty("conn.chooseCtype.searchtxt"));
	By chooseConnectionType_SearchResultele = getElementLocator(
			prop.getProperty("conn.chooseCtype.afterSearchedCtype"));
	By chooseConnectionType_Spinner = getElementLocator(prop.getProperty("conn.spinner.afterCTypeClicked"));
	By connWorkspaceLabel = getElementLocator(prop.getProperty("Connection.Conn.Workspace.Label"));
	By connWorkspaceField = getElementLocator(prop.getProperty("Connection.Conn.Workspace.Field"));
	By connName = getElementLocator(prop.getProperty("ConnectionB.connectionName"));
	By connNameLabel = getElementLocator(prop.getProperty("Connection.Conn.Name.Label"));
	By connAuthTypeLabel = getElementLocator(prop.getProperty("Connection.Conn.Auth.Label"));
	By connAuthTypeField = getElementLocator(prop.getProperty("Connection.Conn.Auth.Field"));
	By connAuthTypeSearchIcon = getElementLocator(prop.getProperty("Connection.Conn.Auth.DDIcon"));
	By connAuthTypeList = getElementLocator(prop.getProperty("Connection.Conn.Auth.DD.List"));
	By connCustomJDBCCheckbox = getElementLocator(prop.getProperty("Connection.Conn.CustomJDBCURL.Checkbox"));
	By connCustomJDBCLabel = getElementLocator(prop.getProperty("Connection.Conn.CustomJDBCURL.Label"));
	By connCustomJDBCTextbox = getElementLocator(prop.getProperty("Connection.Conn.CustomJDBCURL.Textbox"));
	By connRepoBreadcrumbLink = getElementLocator(prop.getProperty("Connection.Conn.Repo.Breadcrem.Link"));
	By discardButtons = getElementLocator(prop.getProperty("dataT.discardButton"));
	By userName = getElementLocator(prop.getProperty("Login.UserName"));
	By connectionNameValidation = getElementLocator(prop.getProperty("Connection.Conn.Repo.Name.Validation"));
	By accountIdentifierInput = getElementLocator(prop.getProperty("conn.accountidentifier.input"));
	By accountIdentifierLabel = getElementLocator(prop.getProperty("conn.accountidentifier.Label"));
	By connWarehouseInput = getElementLocator(prop.getProperty("conn.warehouse.input"));
	By connWarehouseLabel = getElementLocator(prop.getProperty("conn.warehouse.Label"));
	By connDatabaseInput = getElementLocator(prop.getProperty("conn.database.input"));
	By connDatabaseLabel = getElementLocator(prop.getProperty("conn.database.Label"));
	By connDatabaseErrormsg = getElementLocator(prop.getProperty("conn.database.errorMsg"));
	By connWareHouseErrormsg = getElementLocator(prop.getProperty("conn.warehouse.errorMsg"));
	By connAccountIdentifierErrormsg = getElementLocator(prop.getProperty("conn.accountidentifier.errorMsg"));
	By connTypeSelectionDropdown = getElementLocator(prop.getProperty("conn.typeselection.dropdown"));
	By connTypeList = getElementLocator(prop.getProperty("conn.typeOfConn.dropdownlist"));
	By connTypeListpane = getElementLocator(prop.getProperty("conn.typeOfConn.dropdownlist.pane"));
	By connUsernameInput = getElementLocator(prop.getProperty("conn.Username.input"));
	By connsecretPasswordfeild = getElementLocator(prop.getProperty("Connection.secretPassword.feild"));
	By connUsernameLabel = getElementLocator(prop.getProperty("conn.Username.Label"));
	By connUsernameErrormsg = getElementLocator(prop.getProperty("conn.Username.errorMsg"));
	By connPasswordLabel = getElementLocator(prop.getProperty("conn.Password.Label"));
	By connPasswordInput = getElementLocator(prop.getProperty("conn.Password.input"));
	By connPropertiesTab = getElementLocator(prop.getProperty("conn.propetiesSection.tab"));
	By connOverviewTab = getElementLocator(prop.getProperty("conn.OverviewSection.tab"));
	By addpropertyNameInput = getElementLocator(prop.getProperty("Connection.AddPropertyName"));
	By addpropertyValueInput1 = getElementLocator(prop.getProperty("Connection.AddPropertyValue"));
	By addpropertyButton = getElementLocator(prop.getProperty("conn.property.addProperty.btn"));
	By removePropertyButton = getElementLocator(prop.getProperty("conn.property.removeProp.btn"));
	By clickOnPropertyTypeDropdown = getElementLocator(prop.getProperty("Connection.AddPropertyTypeClick"));
	By newPropertySaveButton = getElementLocator(prop.getProperty("conn.Add.newproperty.save.btn"));
	By newPropertyCancelButton = getElementLocator(prop.getProperty("conn.Cancel.newproperty.save.btn"));
	By createNewConnectionTitle = getElementLocator(prop.getProperty("Connection.Conn.CreateNewConnection.Title"));
	By propTypeListPane = getElementLocator(prop.getProperty("conn.ProPType.UiList"));
	By propListOptions = getElementLocator(prop.getProperty("conn.ProPType.listOfOption"));
	/** New Code For Flat file connector **/
	/** By locators **/
	By connFlatFileNativeLogo = getElementLocator(prop.getProperty("Connection.conn.flatfile.native.Logo"));
	By connFlatFileLocationLabel = getElementLocator(prop.getProperty("conn.flatfile.native.location.label"));
	By connFlatFileLocationField = getElementLocator(prop.getProperty("conn.flatfile.native.location.field"));
	By connFlatFileLocationDDBtn = getElementLocator(prop.getProperty("conn.flatfile.native.location.dropdownbtn"));
	By connFlatFileLocationDDList = getElementLocator(prop.getProperty("conn.flatfile.native.location.dropdownlist"));
	By connFlatFileFolderPathLabel = getElementLocator(prop.getProperty("conn.flatfile.native.FolderPath.label"));
	By connFlatFileFolderPathField = getElementLocator(prop.getProperty("conn.flatfile.native.FolderPath.field"));
	By connFlatFileFolderPathFieldValidation = getElementLocator(
			prop.getProperty("conn.flatfile.native.FolderPath.validation"));
	By connConnectionIdLabel = getElementLocator(prop.getProperty("conn.ConnectionID.Label"));
	By connConnectionIdField = getElementLocator(prop.getProperty("conn.ConnectionId.Field"));
	By connDeleteButton = getElementLocator(prop.getProperty("conn.DeleteButton"));
	By connUploadFilesButton = getElementLocator(prop.getProperty("conn.UploadFileButton"));
	By moreButton = getElementLocator(prop.getProperty("conn.MoreBtn"));
	By connDuplicateButton = getElementLocator(prop.getProperty("conn.DuplicateButton"));
	By connFlatFileTypeLabel = getElementLocator(prop.getProperty("conn.flatfile.native.FileType.label"));
	By connFlatFileTypeField = getElementLocator(prop.getProperty("conn.flatfile.native.FileType.field"));
	By connFlatFileTypeDDBtn = getElementLocator(prop.getProperty("conn.flatfile.native.FileType.dropdownbtn"));
	By connFlatFileContainerLabel = getElementLocator(prop.getProperty("conn.flatfile.native.Container.label"));
	By connFlatFileContainerField = getElementLocator(prop.getProperty("conn.flatfile.native.Container.field"));
	By connFlatFileContainerFieldValidation = getElementLocator(
			prop.getProperty("conn.flatfile.native.Container.validation"));
	By connFlatFileRegionLabel = getElementLocator(prop.getProperty("conn.flatfile.native.Region.label"));
	By connFlatFileRegionField = getElementLocator(prop.getProperty("conn.flatfile.native.Region.field"));
	By connFlatFileRegionFieldValidation = getElementLocator(
			prop.getProperty("conn.flatfile.native.Region.validation"));
	By connFlatFileAccesskeyLabel = getElementLocator(prop.getProperty("conn.flatfile.native.Accesskey.label"));
	By connFlatFileAccesskeyField = getElementLocator(prop.getProperty("conn.flatfile.native.Accesskey.field"));
	By connFlatFileAccesskeyFieldValidation = getElementLocator(
			prop.getProperty("conn.flatfile.native.Accesskey.validation"));
	By connFlatFileSecretkeyLabel = getElementLocator(prop.getProperty("conn.flatfile.native.Secretkey.label"));
	By connFlatFileSecretkeyField = getElementLocator(prop.getProperty("conn.flatfile.native.Secretkey.field"));
	By connFlatFileSecretkeyFieldValidation = getElementLocator(
			prop.getProperty("conn.flatfile.native.Secretkey.validation"));
	By connFlatFileAccountNameLabel = getElementLocator(prop.getProperty("conn.flatfile.native.AccountName.label"));
	By connFlatFileAccountNameField = getElementLocator(prop.getProperty("conn.flatfile.native.AccountName.field"));
	By connFlatFileAccountKeyLabel = getElementLocator(prop.getProperty("conn.flatfile.native.AccountKey.label"));
	By connFlatFileAccountKeyField = getElementLocator(prop.getProperty("conn.flatfile.native.AccountKey.field"));
	By connFlatFileDriverLabel = getElementLocator(prop.getProperty("conn.flatfile.native.Driver.label"));
	By connFlatFileDriverField = getElementLocator(prop.getProperty("conn.flatfile.native.Driver.field"));
	By connFlatFileDriverDDBtn = getElementLocator(prop.getProperty("conn.flatfile.native.Driver.dropdownbtn"));
	By connFlatFileDriverDDList = getElementLocator(prop.getProperty("conn.flatfile.native.Driver.dropdownlist"));
	By connSpinnerVisible = getElementLocator(prop.getProperty("conn.Spinner.visible"));
	By connectionDeletePopUpContent = getElementLocator(prop.getProperty("Connection.Conn.Delete.Popup.Content"));
	By connDeletePopupTitle = getElementLocator(prop.getProperty("Connection.Conn.Delete.Popup.Title"));
	By connHostInputField = getElementLocator(prop.getProperty("conn.host"));
	By connHostTitle = getElementLocator(prop.getProperty("Connection.conn.host.title"));
	By connPortInputField = getElementLocator(prop.getProperty("conn.port"));
	By connPortTitle = getElementLocator(prop.getProperty("Connection.conn.port.title"));
	By connDatabaseInputField = getElementLocator(prop.getProperty("conn.Database"));
	By connDatabaseTitle = getElementLocator(prop.getProperty("Connection.conn.database.title"));
	By updateName = getElementLocator(prop.getProperty("Connection.Conn.Property.Field.UpdateName"));
	By updateValue = getElementLocator(prop.getProperty("Connection.Conn.Property.Field.UpdateValue"));
	By saveButton = getElementLocator(prop.getProperty("Connection.Conn.Property.SaveButton"));
	By viewType = getElementLocator(prop.getProperty("Connection.Conn.Property.Field.viewType"));
	By chooseConnType = getElementLocator(prop.getProperty("conn.database.connectionTypeDD"));
	By domainname = getElementLocator(prop.getProperty("Connection.Conn.domainname.title"));
	By instancename = getElementLocator(prop.getProperty("Connection.Conn.instancename.title"));
	By conndomainnameInputField = getElementLocator(prop.getProperty("conn.domainname"));
	By conninstancenameInputField = getElementLocator(prop.getProperty("conn.instancename"));
	By connsecretQuickAddbtn = getElementLocator(prop.getProperty("Connection.secret.QuickAddbtn"));
	By connsecretName = getElementLocator(prop.getProperty("Connection.secretName"));
	By connsecretManagebtn = getElementLocator(prop.getProperty("Connection.secret.Managebtn"));
	By connsecretRefreshbtn = getElementLocator(prop.getProperty("Connection.secret.Refreshbtn"));
	By connvaultOnOffLabel = getElementLocator(prop.getProperty("Connection.vaultOnOffLabel"));
	By connvaultOnOff = getElementLocator(prop.getProperty("Connection.vaultOnOff"));
	By conndropdownResult = getElementLocator(prop.getProperty("conn.dd.result"));
	// **************************************String Variables
	// ************************************************************************************
	By connKeyfileContentdropdownbtn = getElementLocator(prop.getProperty("Connection.secretPassword.KeyfileContent.Passdropdownbtn.feild"));
	By connsecretNameSearchField = getElementLocator(prop.getProperty("Connection.secretNameSearch"));
	String viewName = prop.getProperty("connection.viewName");
	String viewValue = prop.getProperty("connection.viewValue");
	String commonLabel = prop.getProperty("connection.Common.Label");
	String connectionsNameTex = prop.getProperty("ConnectionsNameText");
	String newConnToastMsg = prop.getProperty("Connection.NewConnBtn.UserAuth.ErrMsg");
	String logeedInText = prop.getProperty("LogeedInText");
	String connFetchedMsg = prop.getProperty("Connection.ConnFetchMsg");
	String clickonSearchConnection = prop.getProperty("Connection.SearchConnection");
	String disableConnMsg = prop.getProperty("disableConnMsg");
	String desiredConnType = prop.getProperty("Connection.DesiredConnType");
	String updateDoneButtonConnProperty = prop.getProperty("Connection.UpdateDoneButtonConnProperty");
	String editConnProperty = prop.getProperty("Connection.EditConnProperty");
	String addPropertyType = prop.getProperty("Connection.AddPropertyType");
	String connectionTestMess = prop.getProperty("connectionTestMess");
	String connectionSaveMesssage = prop.getProperty("ConnectionSaveMesssage");
	String connectionUpdate = prop.getProperty("conn.PowerBIUpdateMess");
	String selectWorkspaceSearchClick = prop.getProperty("Connection.SelectWorkspaceSearchClick");
	String selectConnTypeSearch = prop.getProperty("Connection.SelectConnTypeSearch");
	String dynamicName = prop.getProperty("DynName");
	String valueAttribute = prop.getProperty("Attribute.value");
	String scrollToElementArg = prop.getProperty("ScrollToElementArgument");
	String booleanTrue = prop.getProperty("Boolean.True");

	String UsernameKeyPairPlaceholder = prop.getProperty("conn.Placeholder.UsernameKeyPair");
	String KeyFileContentKeyPairPlaceholder = prop.getProperty("conn.Placeholder.KeyFileContentKeyPair");
	String KeyFilePasswordKeyPairPlaceholder = prop.getProperty("conn.Placeholder.KeyFilePasswordKeyPair");
	String keyVaultNamePlaceholder = prop.getProperty("conn.Placeholder.KeyVaultNamePlaceholder");
	String clientIdPlaceholder = prop.getProperty("conn.Placeholder.ClientIdPlaceholder");
	String tenantIdPlaceholder = prop.getProperty("conn.Placeholder.TenantIdPlaceholder");
	String clientSecretPlaceholder = prop.getProperty("conn.Placeholder.ClientSecretPlaceholder");
	String privateKeySecretNamePlaceholder = prop.getProperty("conn.Placeholder.PrivateKeySecretNamePlaceholder");
	String privateKeyPasswordSecretNamePlaceholder = prop
			.getProperty("conn.Placeholder.PrivateKeyPasswordSecretNamePlaceholder");
	By connsecretUserPassword = getElementLocator(prop.getProperty("Connection.secretUserPassword.feild"));

	String create_actualValue = prop.getProperty("conn.status.create.actualValue");
	String update_actualValue = prop.getProperty("conn.status.update.actualValue");

	String placeHolderAttribute = prop.getProperty("Atribute.placeholder");
	String connectionNameSearchApi = prop.getProperty("ConnectionName.SearchAPI");
	String connectionNamePlaceHolder = prop.getProperty("Connection.Conn.Name.placeholder");
	String connAuthTypeSelect1 = prop.getProperty("Connection.Conn.Auth.TypeSelect");
	String connIcedqUserAuthorisationMsg = prop.getProperty("dataT.RunErrorMsg");
	String connAccountIdentifirePlaceHolder = prop.getProperty("Connection.Conn.AccountIdentifire.placeholder");
	String connWarehousePlaceHolder = prop.getProperty("Connection.Conn.Warehouse.placeholder");
	String connDatabasePlaceHolder = prop.getProperty("placeholder.database");
	String validationAccountIdentifierEmpty = prop.getProperty("Connection.accountIdentifier.empty");
	String validationwarehouseEmpty = prop.getProperty("Connection.warehouse.empty");
	String validationDatabaseEmpty = prop.getProperty("Connection.Database.empty");
	String connConnectionPropNames = prop.getProperty("Connection.ConnectionProperties.Names");
	String connConnectionPropValues = prop.getProperty("Connection.ConnectionProperties.Values");
	String connConnectionPropTypes = prop.getProperty("Connection.ConnectionProperties.Types");
	String connUsernamePlaceholder = prop.getProperty("Connection.Conn.Username.placeholer");
	String connPasswordPlaceholder = prop.getProperty("Connection.Conn.Password.placeholder");
	String connectionNameLinkWithContains = prop.getProperty("Connection.Conn.Name.ContainsLink");
	String connectionNameCheckboxListWithContains = prop.getProperty("Connection.Conn.Name.Checkbox.ContainsList");
	String connectionDeletePopupBtn = prop.getProperty("Connection.Conn.Delete.Popup.Button");
	String connFlatFileSelectLocation = prop.getProperty("conn.flatfile.native.location.selectLocation");
	String connselectDriver = prop.getProperty("conn.Driver.selectDriver");
	String folderPathPlaceHolder = prop.getProperty("Connection.Conn.FolderPath.placeholder");
	String folderPathEmptyValidationMsg = prop.getProperty("Connection.folderPath.empty");
	String containerEmptyValidationMsg = prop.getProperty("Connection.Container.empty");
	String containerPlaceHolder = prop.getProperty("Connection.Conn.Container.placeholder");
	String regionEmptyValidationMsg = prop.getProperty("Connection.Region.empty");
	String regionPlaceHolder = prop.getProperty("Connection.Conn.Region.placeholder");
	String accesskeyEmptyValidationMsg = prop.getProperty("Connection.Accesskey.empty");
	String accesskeyPlaceHolder = prop.getProperty("Connection.Conn.Accesskey.placeholder");
	String secretkeyEmptyValidationMsg = prop.getProperty("Connection.Secretkey.empty");
	String secretkeyPlaceHolder = prop.getProperty("Connection.Conn.Secretkey.placeholder");
	String connectionNameEmptyValidationMsg = prop.getProperty("Connection.name.empty");
	String connDupllicateToastMsg = prop.getProperty("Connection.Conn.Duplicate.ToastMsg");
	String connCommonFieldValidation = prop.getProperty("conn.field.validation");
	String accountIdentifierfeildvalidation = prop.getProperty("conn.AccountIdentifier.feild.validation");
	String accountNamePlaceHolder = prop.getProperty("Connection.Conn.AccountName.placeholder");
	String accountNameEmptyValidationMsg = prop.getProperty("Connection.AccountName.empty");
	String accountKeyPlaceHolder = prop.getProperty("Connection.Conn.AccountKey.placeholder");
	String accountKeyEmptyValidationMsg = prop.getProperty("Connection.AccountKey.empty");
	String connSingledeletePopupContentMsg = prop.getProperty("Connection.Conn.SingleDelete.Popup.Msg");
	String connSingledeletePopupTitle = prop.getProperty("Connection.Conn.SingleDelete.Popup.Title");
	String connMultideletePopupContentMsg = prop.getProperty("Connection.Conn.MultiDelete.Popup.Msg");
	String connMultideletePopupTitle = prop.getProperty("Connection.Conn.MultiDelete.Popup.Title");
	String connSingleDeleteToastMsg = prop.getProperty("Connection.Conn.SingleDelete.ToastMsg");
	public String connMultiDeleteToastMsg = prop.getProperty("Connection.Conn.MultiDelete.ToastMsg");
	String connHostPlaceholder = prop.getProperty("Connection.Conn.Host.placeholder");
	String connPortPlaceholder = prop.getProperty("Connection.Conn.Port.placeholder");
	String connDatabasePlaceholder = prop.getProperty("Connection.Conn.Database.placeholder");
	String connDomainnamePlaceholder = prop.getProperty("Connection.Conn.DomainName.placeholder");
	String connInstancenamePlaceholder = prop.getProperty("Connection.Conn.InstanceName.placeholder");
	By chooseConnectionTypeSpinner = getElementLocator(prop.getProperty("conn.spinner.afterCTypeClicked"));

	String validationHostEmpty = prop.getProperty("Connection.Host.empty");
	String validationPortEmpty = prop.getProperty("Connection.Port.empty");
	String validationPortInvalid = prop.getProperty("Connection.Port.invalid");
	String connConnectionPropCommonLocator = prop.getProperty("Connection.Conn.Property.fieldnew");
	String connPropertyEditButton = prop.getProperty("Connection.Conn.Property.EditButton");
	String connPropertyDeleteButton = prop.getProperty("Connection.Conn.Property.DeleteButton");
	String connPropertyCancelButton = prop.getProperty("Connection.Conn.Property.CancelButton");
	// #-------------------------Flatfile NativeElements by //
	// Rahul-----------------------------#
	By flatfileselect = getElementLocator(prop.getProperty("connection.flatfileselect"));
	By connectionwks = getElementLocator(prop.getProperty("connection.connectionwks"));
	By connectionname = getElementLocator(prop.getProperty("connection.connectionname"));
	By connectionlocation = getElementLocator(prop.getProperty("connection.connectionlocation"));
	By connectionfiletype = getElementLocator(prop.getProperty("connection.connectionfiletype"));
	By connectionauthentication = getElementLocator(prop.getProperty("connection.connectionauthentication"));
	By connectionfilepath = getElementLocator(prop.getProperty("connection.connectionfilepath"));
	By connectiontypeselect = getElementLocator(prop.getProperty("connection.connectiontypeselect"));
	By connectionaccountname = getElementLocator(prop.getProperty("connection.connectionaccountname"));
	By connectionaccountkey = getElementLocator(prop.getProperty("connection.connectionaccountkey"));
	By connectionsessiontoken = getElementLocator(prop.getProperty("connection.connectionsessiontoken"));
	By connectionregion = getElementLocator(prop.getProperty("connection.connectionregion"));
	By connectionaccesskey = getElementLocator(prop.getProperty("connection.connectionaccesskey"));
	By connectionsecretkey = getElementLocator(prop.getProperty("connection.connectionsecretkey"));
	By connectionchangebtn = getElementLocator(prop.getProperty("connection.connectionchangebtn"));
	By userconnectiontab1 = getElementLocator(prop.getProperty("connection.userconnectiontab1"));
	By usersearchconnection = getElementLocator(prop.getProperty("connection.usersearchconnection"));
	By usersearchconnectionbtn = getElementLocator(prop.getProperty("connection.usersearchconnectionbtn"));
	By userconnectionid = getElementLocator(prop.getProperty("connection.userconnectionid"));
	By userconnectionlocation = getElementLocator(prop.getProperty("connection.userconnectionlocation"));
	By userconnectionfiletype = getElementLocator(prop.getProperty("connection.userconnectionfiletype"));
	By userconnectionauthentication = getElementLocator(prop.getProperty("connection.userconnectionauthentication"));
	By userconnectiontype = getElementLocator(prop.getProperty("connection.userconnectiontype"));
	By existingPropName = getElementLocator(prop.getProperty("conn.existingProp.check.Name"));
	By existingPropValue = getElementLocator(prop.getProperty("conn.existingProp.check.value"));
	By existingPropType = getElementLocator(prop.getProperty("conn.existingProp.check.type"));
	By existingPropCheckbox = getElementLocator(prop.getProperty("conn.existingProp.check.checkBox"));

	String connectionCredentialsFile = prop.getProperty("ConnectionCredentialsFile");
	String connectionlocationoptions = prop.getProperty("connection.connectionlocationoptions");
	String connectionfileoptions = prop.getProperty("connection.connectionfileoptions");
	String connectionauthenticationoptions = prop.getProperty("connection.connectionauthenticationoptions");
	String connectiontypeselectoptions = prop.getProperty("connection.connectiontypeselectoptions");
	String userconnectionnameclick = prop.getProperty("connection.userconnectionnameclick");
	String connNameLink = prop.getProperty("connection.ConnectionNameLink");
	String newConn_ClickConnTile = prop.getProperty("conn.clickonConnTypeBtn");
	String editBtnwrtPropName = prop.getProperty("conn.property.usingname.Edit.btn");
	String connPropertyType = prop.getProperty("Connection.AddPropertyType");
	String existingPropertySaveButton = prop.getProperty("conn.existingProperty.save.btn");
	String existingPropertyCancelButton = prop.getProperty("conn.existingProperty.Cancel.btn");
	public String strDBConnectionType = prop.getProperty("conn.testdata.dbConnectorType");
	String attributeTextContent = prop.getProperty("Atribute.textContent");
	String readerGrantErrMessage = prop.getProperty("conn.ReaderErrorMessage");
	public String forbiddenToastMsg = prop.getProperty("Connection.NewConnBtn.UserAuth.ErrMsg");

	public String updateAndSaveClickErrorMessage = prop.getProperty("conn.updateAndSaveClickErrorMessage");
	By propertiesEditBtn = getElementLocator(prop.getProperty("Connection.propertiesEditBtn"));

	// *************************************** Comman methods for data testing
	// *******************************************************************

	// method to click on conn repo on homepage
	public void ConnectionRepo() {
		try {
			isDisplayedInLoop(driver, 10, pagelabel);
			if (isDisplayed(driver, pagelabel)) {
				displayAndClick(driver, ClickonDataConnection);
				getWindowHandler(driver);
				BaseSuite.reportLog("clicked on Data Connections tab");
				captureToastMsg(driver, LoggedInMsg, ToastMsgClosedBtn, logeedInText, "LoggedIn");
				captureToastMsg(driver, toastMsg, ToastMsgClosedBtn, connFetchedMsg, "Connection Fetched");
			} else {
				BaseSuite.reportLog("Not able to click on the Data Connections tab");
			}
		} catch (Exception e) {
			throw new AssertionError("User not able to navigate on Administration page", e);
		}
	}

	// method to click on refresh button on conn repo home page
	public void clickOnRefreshBtn() throws Exception {

		clickOnButton(driver, clickonRefresh, "Refresh", true);
		inVisible(driver, connectionPageSpinner, Constant.ruleWait);
	}

	// method to click on new conn button on conn repo home page
	public boolean clickOnNewConnectionBtn(String icedqUser) throws Exception {
		boolean s = true;
		try {
			clickOnButton(driver, clickonNewConnection, "New Connection", true);

			inVisible(driver, spinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 1, toastMsg);

			if (!icedqUser.toLowerCase().contains("owner")) {

				s = captureToastMsgWithContains(driver, toastMsg, ToastMsgClosedBtn,
						ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG, "New connection authorization message");
				if (!s) {
					BaseSuite.reportFailLog(
							"Expected Toast Message not found for user " + icedqUser
									+ "kindly check, https://icedqsoft.atlassian.net/browse/DAT-4755 ",
							"clickOnNewConnectionBtn ");
				}
			}
			isDisplayedInLoop(driver, 2, createNewConnectionTitle);
			if (isDisplayed(driver, createNewConnectionTitle)) {
				verifyIndividualLabel(driver, createNewConnectionTitle, "Create New Connection");

				BaseSuite.validationReportLog("New Connection button is clicked " + ConstantProperty.SUCCESSSTRING
						+ " and Create New Connection title is visible");
			} else if (icedqUser.toLowerCase().contains("owner")) {
				BaseSuite.reportFailLog(
						"New Connection button not clicked properly , create new connection page not visible",
						"clickOnNewConnectionBtn");
				s = false;

			} else {

			}
		} catch (Exception e) {

			throw new AssertionError("clickOnNewConnectionBtn");

		}
		return s;
	}

	// method to check button and lables on conn repo
	public void validateButtonsAndLables() {
		try {
			BaseSuite.reportLog("Verifying Connection Repository Breadcrums links on page");

			verifyVisibilityOfButtons(driver, brdCrumsHomeLink, "Home Link", true);
			verifyIndividualLabel(driver, brdCrumsConnRepo, "Connection");
			// verifyIndividualLabel(driver, brdCrumsConnections, "Connections ");

			BaseSuite.validationReportLog("Connection Repository Breadcrums links verified on page");

			verifyIndividualLabel(driver, connectionLabels, "Connections");

			BaseSuite.reportLog("Verifying the count of Button on connection page");

			validateButtons(driver, landingPageAllBtn, 3);
			verifyVisibilityOfButtons(driver, clickonNewConnection, "New Connection ", true);
			isClickable(driver, clickonNewConnection, "New Connection ", true);
			verifyVisibilityOfButtons(driver, clickonRefresh, "Refresh ", true);
			isClickable(driver, clickonRefresh, "Refresh Button", true);
			verifyVisibilityOfButtons(driver, clickonDisable, "Delete  ", false);
			isClickable(driver, clickonDisable, "Delete Button ", false);

			verifyIndividualLabel(driver, connectionNameLabel, "Name ");
			verifyIndividualLabel(driver, connectionType, "Connection Type");
			/**
			 * verifyIndividualLabel(driver, typeLabel, "Type");
			 * verifyIndividualLabel(driver, updatedByLabel, "Updated By");
			 * verifyIndividualLabel(driver, lastModified, "Last Updated");
			 **/
		}

		catch (Exception ex) {
			throw new AssertionError("All buttons are disabled", ex);
		}
	}

	// method to search connection name on conn repo home page
	public void searchConnectionFunctionality(String Connection_search) throws Exception {
		BaseSuite.reportLog("Searching for Connection:" + Connection_search);
		isDisplayedInLoop(driver, 20, searchBar);
		clear_Click_SendKeys(driver, 20, searchBar, Connection_search.trim());
		BaseSuite.validationReportLog("Connection name entered successfullly :" + Connection_search);
		BaseSuite.reportLog("Clicking on search icon");
		isDisplayedInLoop(driver, 3, searchBclick);
		displayAndClick(driver, searchBclick);
		inVisible(driver, connectionPageSpinner, Constant.ruleWait);

		try {
			isDisplayedInLoop(driver, 10, searchBclick);
			if (!isDisplayed(driver, noRecondsFound)) {
				String name = driver.findElement(returnElement(clickonSearchConnection, "$title", Connection_search))
						.getText();
				boolean flag = isDisplayed(driver, returnElement(clickonSearchConnection, "$title", Connection_search));
				if (flag) {
					BaseSuite.validationReportLog("Connection displayed in the list");

					if (name.equalsIgnoreCase(Connection_search)) {
						BaseSuite.validationReportLog("Searched connection found in the list :" + Connection_search);
						BaseSuite.validationReportLog("Search functionality working properly");
					} else {
						BaseSuite.reportFailLog("Searched connection not matched", "searchConnectionFunctionality");
					}
				} else {
					BaseSuite
							.validationReportLog("Searched connection not available in the list :" + Connection_search);
				}
			} else {
				BaseSuite.validationReportLog("No connection found for searched value ");
			}

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void verifyConnectionIsCreatedOrNot(String Connection_search) {
		try {
			BaseSuite.reportLog("Searching for Connection:" + Connection_search);
			isDisplayedInLoop(driver, 20, searchBar);
			clear_Click_SendKeys(driver, 20, searchBar, Connection_search.trim());
			BaseSuite.validationReportLog("Connection name entered successfullly :" + Connection_search);
			BaseSuite.reportLog("Clicking on search icon");
			isDisplayedInLoop(driver, 3, searchBclick);
			displayAndClick(driver, searchBclick);
			inVisible(driver, connectionPageSpinner, Constant.ruleWait);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	// method to validate disable functionality pop up window
	public void disableFunWithAlertPopUp(String mess, SoftAssert soft) {
		try {
			BaseSuite.reportLog("Verify disable alert pop up window alert messages and buttons");
			isDisplayedInLoop(driver, 20, clickonDisable);
			if (isEnabled(driver, clickonDisable)) {
				displayAndClick(driver, clickonDisable);
				BaseSuite.validationReportLog("Clicked on the Disable button");
				isDisplayedInLoop(driver, 20, disableWinTitle);
				if (isDisplayed(driver, disableWinTitle)) {
					isDisplayedInLoop(driver, 20, disableWinTitle);
					waitForElement(driver, disableWinTitle);
					String title = driver.findElement(disableWinTitle).getText();
					BaseSuite.validationReportLog(
							"After click on disable button alert pou up window opened successfully with title :"
									+ title);
					BaseSuite.reportLog("Verify the alert popup message on the window");
					waitForElement(driver, disablePopUpMsg);
					String validMess = getText(driver, disablePopUpMsg).trim();
					BaseSuite.validationReportLog("Retrived Message on popup window is :" + validMess);
					BaseSuite.validationReportLog("Expected Message on popup window is :" + mess.trim());

					if (!validMess.isEmpty() && validMess.equalsIgnoreCase(mess.trim())) {

						soft.assertEquals(validMess, mess.trim());

						BaseSuite.validationReportLog(
								"Popup window Message Successfully Matched and the message is :" + validMess);
					} else {
						BaseSuite.reportFailLog("Messages didn't match", "captureToastMsg");
					}
					BaseSuite.reportLog("Verify yes and no button is diplayed and enabled on the popup window");
					verifyVisibilityOfButtons(driver, disableYesOption, "Disable ", true);
					isClickable(driver, disableYesOption, "Disable ", true);
					verifyVisibilityOfButtons(driver, disableNoOption, "Cancel ", true);
					isClickable(driver, disableNoOption, "Disable ", true);
				} else {
					BaseSuite.reportFailLog("Popup window not opened or title message not getting displayed on window",
							"disableFunWithAlertPopUp");
				}
			}

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	// method to validate disable button should be disabled when non of connections
	// are selected
	public void disbleBtnShouldNotEnabledWithoutSelectionOfConnection() {
		try {

			BaseSuite.reportLog("Verify disable button enabled or disabled without the selection of connection");
			verifyVisibilityOfButtons(driver, clickonDisable, "Disable Button", false);
			isClickable(driver, clickonDisable, "Disable Button", false);
			BaseSuite.validationReportLog("Disable button is disabled without the selection of connection");

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	// method to validate disable button should be enabled when one of connection is
	// selected
	public void disbleBtnShouldBeEnabledWithSelectionOfConnection(String Connection_search) {
		try {
			searchConnectionFunctionality(Connection_search);
			isDisplayedInLoop(driver, 10, connSingleCheck);
			BaseSuite.reportLog("Clicking on connection's checkbox");
			displayAndClick(driver, connSingleCheck);
			BaseSuite.validationReportLog("Connection's checkbox is selected");

			BaseSuite.reportLog("Verify disable button enabled or disabled with the selection of connection");
			verifyVisibilityOfButtons(driver, clickonDisable, "Disable Button", true);
			isClickable(driver, clickonDisable, "Disable Button", true);
			BaseSuite.validationReportLog("Disable button is enabled with the selection of connection");

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	// method to check refresh button functionality on conn repo
	public void refreshBtnFunction() {
		try {
			BaseSuite.reportLog("Verifiying refresh button function");
			int count = driver.findElements(connectionCheckbox).size();
			List<WebElement> list = driver.findElements(connectionCheckbox);
			BaseSuite.reportLog("Before refresh button click select all the connections");
			String a = list.get(0).getAttribute("class");

			if (!a.contains("active")) {
				BaseSuite.validationReportLog(
						"Connection checkbox not selected and the size of all connection select checkbox on page is:"
								+ count);
				BaseSuite.reportLog("Now clicking on the checkbox to select the all the connections");
				list.get(0).click();
				String a1 = list.get(0).getAttribute("class");
				if (a1.contains("active")) {
					BaseSuite.validationReportLog("connnection selected successfully");
				} else {
					BaseSuite.reportFailLog("Connection not selected", "selectionOfCheckboxes");
				}
			} else {
				BaseSuite.validationReportLog("All connection checkboxes are selected");
			}
			BaseSuite.reportLog(
					"Clicking on the refresh button to check after click on refresh button all the connections should get unchecked or not ");
			clickOnRefreshBtn();
			inVisible(driver, connectionPageSpinner, Constant.ruleWait);
			List<WebElement> list1 = driver.findElements(connectionCheckbox);
			String a2 = list1.get(0).getAttribute("class");
			if (a2.contains("true")) {
				BaseSuite.reportFailLog("After click on refresh button connection page not getting refreshed",
						"selectionOfCheckboxes");

			} else {
				BaseSuite.validationReportLog(
						"All the selected connnections unchecked successfully hence refresh button function working successfylly");
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	// method to search and disable connection on connection repo home page
	public void disableConnWithYesOption(String mess, String Connection_search, SoftAssert soft) {
		try {
			searchConnectionFunctionality(Connection_search);
			isDisplayedInLoop(driver, 10, connSingleCheck);
			BaseSuite.reportLog("Clicking on connection's checkbox");
			displayAndClick(driver, connSingleCheck);
			BaseSuite.validationReportLog("Connection's checkbox is selected");
			disableFunWithAlertPopUp(mess, soft);
			BaseSuite.reportLog("Verify Yes button is diplayed and enabled on the popup window");
			verifyVisibilityOfButtons(driver, disableYesOption, "Disable", true);
			if (isEnabled(driver, disableYesOption)) {
				BaseSuite.reportLog("Clicking on the Yes button");
				displayAndClick(driver, disableYesOption);
				inVisible(driver, connectionPageSpinner, Constant.ruleWait);
				captureToastMsg(driver, toastMsg, popUpClose, disableConnMsg, "Msg retrived");
				BaseSuite.reportLog("Verifying disabled connection present in the list or not");
				searchConnectionFunctionality(Connection_search);
				BaseSuite
						.validationReportLog("Connection's disable Alert popup window Disable button working properly");
			} else {
				BaseSuite.reportFailLog("Yes button is not enabled on the pop up window", "disableConnWithYesOption");
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	// method to check cancel button functionality on disable pop-up window
	public void disableConnWithNoOption(String mess, String Connection_search, SoftAssert soft) {
		try {
			searchConnectionFunctionality(Connection_search);
			isDisplayedInLoop(driver, 10, connSingleCheck);
			BaseSuite.reportLog("Clicking on connection's checkbox");
			displayAndClick(driver, connSingleCheck);
			BaseSuite.validationReportLog("Connection's checkbox is selected");
			disableFunWithAlertPopUp(mess, soft);
			BaseSuite.reportLog("Verify No button is diplayed and enabled on the popup window");
			verifyVisibilityOfButtons(driver, disableNoOption, "Cancel", true);
			if (isEnabled(driver, disableNoOption)) {
				BaseSuite.reportLog("Clicking on the Cancel button");
				displayAndClick(driver, disableNoOption);
				BaseSuite.reportLog(
						"Verifying after choosing disable Cancel option connection present in the list or not");
				searchConnectionFunctionality(Connection_search);
				BaseSuite.validationReportLog("Connection's disable Alert popup window Cancel button working properly");
			} else {
				BaseSuite.reportFailLog("Cancel button is not enabled on the pop up window", "disableConnWithNoOption");
			}

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	// method to check connection tab clickable or not on new connection page
	public void connTabsButtonsClickableOrNotOnNewConnectionPage() {
		try {
			BaseSuite.reportLog("Verifying search text box is available and able to enter data or not");
			verifyIndividualLabel(driver, newConnectionNameSearch, "SearchBox");
			isClickable(driver, newConnectionNameSearch, "SearchBox", true);
			// verifyVisibilityOfButtons(driver, discardBtnNewConn, "Discard ", true);
			// BaseSuite.reportLog("Verify connections button are visible and enabled or not
			// on the new connection page.");
			isDisplayedInLoop(driver, 10, connectionNameClick);
			List<WebElement> connectionList = driver.findElements(connectionNameClick);
			List<String> connName = connectionList.stream().map(s -> s.getText()).collect(Collectors.toList());
			for (int i = 0; i < connName.size(); i++) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
						connectionList.get(i));
				boolean dis = connectionList.get(i).isDisplayed();
				String name = connName.get(i);
				BaseSuite.reportLog("verifying connection tab :" + name);
				if (dis) {
					BaseSuite.validationReportLog(name + " button is visible in the page");

				} else {
					BaseSuite.reportFailLog(name + " button is disabled and invisible in the page",
							"connectionTabsClickableOrNotOnNewConnectionPage");
				}
				isDisplayedInLoop(driver, 10, connectionNameClick1);
				List<WebElement> connectionList1 = driver.findElements(connectionNameClick1);
				String ena = connectionList1.get(i).getAttribute("class");
				if (ena.contains("disable")) {
					BaseSuite.validationReportLog(name + " connection tab is disabled and not clickable");
				} else {
					BaseSuite.validationReportLog(name + " connection tab is enabled and clickable");
				}

			}
			BaseSuite.validationReportLog("Connections button/ tab are verified on new connection page");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to check search functionality on new connection page
	public void searchConnectionNameOnNewConnectionPage(String searchNewconnectionName) {
		try {

			BaseSuite.reportLog("Searching for connection:" + searchNewconnectionName);

			BaseSuite.reportLog("Entering connection Name in search bar");

			clear_Click_SendKeys(driver, 10, newConnectionNameSearch, searchNewconnectionName.trim());

			BaseSuite.reportLog("Connection name entered successfuly");

			WebElement element = driver.findElement(newConnectionNameSearch);
			Thread.sleep(1000);
			element.sendKeys(Keys.ENTER);
			isDisplayedInLoop(driver, 30, connectionNameClick);
			BaseSuite.reportLog("Verifying entered rule searched or not");
			String name = driver.findElement(connectionNameClick).getText();
			if (name.equalsIgnoreCase(searchNewconnectionName)) {
				BaseSuite.validationReportLog("Connection searched successfully :" + name);
			} else {
				BaseSuite.reportFailLog("Connection not getting searched or wrong connection searched",
						"searchConnectionNameOnNewConnectionPage");
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	// method to check visiblity of labels and buttons and image on new connection
	// page
	public void labelsAndButtonsOnNewConnectionPage() {
		try {

			Thread.sleep(1000);
			BaseSuite.reportLog("Verifying search text box is available and able to enter data or not");
			verifyIndividualLabel(driver, newConnectionNameSearch, "SearchBox");
			isClickable(driver, newConnectionNameSearch, "SearchBox", true);
			BaseSuite.reportLog("Verify connections button are visible and enabled or not on the new connection page.");
			BaseSuite.reportLog(
					"Verify img of connections are available on the page according to the connection or not");
			List<WebElement> connImg = driver.findElements(connectionImg);
			List<WebElement> connectionList = driver.findElements(connectionNameClick);
			List<String> connName = connectionList.stream().map(s -> s.getText()).collect(Collectors.toList());
			List<String> imgName = connImg.stream().map(s -> s.getAttribute("src")).collect(Collectors.toList());
			// int j = 0;
			for (int i = 0; i < connName.size(); i++) {
				boolean dis = connectionList.get(i).isDisplayed();
				String name = connName.get(i);
				boolean imgDis = imgName.get(i).isEmpty();
				if (!imgDis) {
					BaseSuite.validationReportLog(name + " image is visible in the page");
				} else {
					BaseSuite.reportFailLog(name + "image is not visible in the page",
							"labelsAndButtonsOnNewConnectionPage");
				}

				if (dis) {
					BaseSuite.validationReportLog(name + " button is displaying in the page");
				} else {
					BaseSuite.reportFailLog(name + " button is not displaying in the page",
							"connectionTabsClickableOrNotOnNewConnectionPage");
				}
				boolean ena = connectionList.get(i).isEnabled();
				if (ena) {
					BaseSuite.validationReportLog(name + " button is enabled and clickable on the page");
				} else {
					BaseSuite.reportFailLog(name + " button is not enabled and not clickable on the page",
							"connectionTabsClickableOrNotOnNewConnectionPage");
				}

			}

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public String value(WebElement s) {
		String pricevalue = s.findElement(listOfConnName).getText();
		return pricevalue;
	}

	// method to validate connection repository landing page
	public boolean connectionRepositoryLandingPage() {
		String methodName = "connectionRepositoryLandingPage";
		HomePage home = new HomePage(driver);
		boolean flag = true;
		try {
			if (!isDisplayed(driver, userName)) {
				if (isDisplayed(driver, mainHeadingTitle)) {
					String str = getText(driver, mainHeadingTitle);
					if (!str.equalsIgnoreCase("Connections")) {
						clickOnConnectionsTab();
					}
				}

				isDisplayedInLoop(driver, 0, discardButtons);
				if (isDisplayed(driver, discardButtons)) {

					displayAndClick(driver, discardButtons);

				}

				BaseSuite.reportLog("Verifying Connection Repository landing page");

				home.validateNextGenTabs();

				isDisplayedInLoop(driver, 10, connectionTab);
				if (isDisplayed(driver, connectionTab) && isDisplayed(driver, userconnectionTab)) {
					BaseSuite.validationReportLog(
							"System connections and User connections tab visible on connection repository page");
				} else {
					BaseSuite.reportFailLog("System connection and User connections tab not visible",
							"connectionRepositoryLandingPage ");
				}

				validateButtonsAndLables();

				BaseSuite.reportLog("Verifying search bar and search click visibility ");
				isDisplayedInLoop(driver, 20, searchBar);
				if (isDisplayed(driver, searchBar) && isDisplayed(driver, searchBclick)) {

					BaseSuite.validationReportLog("Search bar and Search Click visible ");
					BaseSuite.reportLog("Verifying search bar and search click enable or not ");
					if (isEnabled(driver, searchBar)) {

						BaseSuite.validationReportLog("Search bar and Search click enabled ");
					} else {
						BaseSuite.reportFailLog("search bar and search click disabled", methodName);
					}

				} else {
					BaseSuite.reportFailLog("search bar and search click not visible", methodName);
				}

				BaseSuite.reportLog("Checking pagination on connection Repository");
				getPaginationDetails();

				BaseSuite.validationReportLog(
						"======   Connection Repository landing page verified successfully      ==========");
			} else {
				BaseSuite.reportFailLog("Connection Repository landing page is not visible kindly check", methodName);
				flag = false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Error occurs while connectionRepositoryLandingPage :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	// method to validate pagination arrows and return page and record details
	public List<String> getPaginationDetails() {

		String pageinfo, totalRecords, currentpage;
		int totalpage;

		isDisplayedInLoop(driver, 10, connPaginationMsg);

		pageinfo = getAttribute(driver, connPaginationMsg, "innerText");

		BaseSuite.validationReportLog("Page details displayed :: " + pageinfo);

		totalpage = Integer.parseInt(pageinfo.split(" ")[2]);

		BaseSuite.validationReportLog("Total page available are :: " + totalpage);

		totalRecords = pageinfo.split(" ")[4].replace("(", "");

		BaseSuite.validationReportLog("Total Records available are :: " + totalRecords);

		currentpage = pageinfo.split(" ")[0];

		BaseSuite.validationReportLog("Current page number is :: " + currentpage);

		List<WebElement> arrows = getElements(driver, pageArrows);

		for (int j = 0; j < arrows.size(); j++) {

			String arrow = arrows.get(j).getAttribute("innerText").replaceAll("Go to", "");

			BaseSuite.reportLog("Checking page arrow :: " + arrow);

			String status = arrows.get(j).getAttribute("class");

			if (status.contains("disable")) {
				BaseSuite.validationReportLog("Page arrow :: " + arrow + " is disabled");
			} else {
				BaseSuite.validationReportLog("Page arrow :: " + arrow + " is enabled");
			}
		}
		return Arrays.asList(pageinfo, totalRecords, currentpage);
	}

	// method to click on connection tab
	public void clickOnConnectionsTab() throws Exception {
		SoftAssert soft = new SoftAssert();
		isDisplayedInLoop(driver, 10, connectionTab);

		if (isDisplayed(driver, connectionTab)) {

			BaseSuite.reportLog("Clicking on  Connections tab ..");

			displayAndClick(driver, connectionTab);

			BaseSuite.validationReportLog("Clicked on  Connections tab successfully");
			isDisplayedInLoop(driver, 1, discardBtnPopup);
			if (isDisplayed(driver, discardBtnPopup)) {
				clickOnButton(driver, discardBtnPopup, "Discard", true);
			}
			inVisible(driver, connectionPageSpinner, Constant.ruleWait);
			if (isDisplayed(driver, ToastMsgClosedBtn)) {
				captureToastMsg(driver, toastMsg, ToastMsgClosedBtn, connFetchedMsg, "Connection Fetched");
			}
			isDisplayedInLoop(driver, 2, mainHeadingTitle);
			String str = getText(driver, mainHeadingTitle);

			soft.assertEquals(str, "Connections");
			if (str.equalsIgnoreCase(str)) {
				BaseSuite.validationReportLog("Expected Title : Connections and Actual Title : " + str + " matched  "
						+ ConstantProperty.SUCCESSSTRING + "");
			} else {
				BaseSuite.reportFailLog("Expected Title : Connections and Actual Title : " + str,
						"clickOnConnectionsTab");
			}
		} else {
			BaseSuite.reportFailLog(" Connections tab not visible", "clickOnConnectionsTab");
		}
	}

	// method to click on user connection tab
	public void clickOnUserConnectionTab() {
		SoftAssert soft = new SoftAssert();
		try {
			isDisplayedInLoop(driver, 10, userconnectionTab);

			if (isDisplayed(driver, userconnectionTab)) {

				BaseSuite.reportLog("Clicking on User Connection tab ..");

				displayAndClick(driver, userconnectionTab);

				BaseSuite.validationReportLog("Clicked on User Connection tab " + ConstantProperty.SUCCESSSTRING + "");
				inVisible(driver, connectionPageSpinner, Constant.ruleWait);
				isDisplayedInLoop(driver, 1, discardBtnPopup);
				if (isDisplayed(driver, discardBtnPopup)) {
					clickOnButton(driver, discardBtnPopup, "Discard", true);
				}
				inVisible(driver, connectionPageSpinner, Constant.ruleWait);
				String str = getText(driver, mainHeadingTitle);

				soft.assertEquals(str, "User Connections");

				BaseSuite.reportLog("Expected Title : User Connections and Actual Title : " + str + " matched "
						+ ConstantProperty.SUCCESSSTRING + "");
				if (str.equalsIgnoreCase("User Connections")) {
					BaseSuite.validationReportLog("Expected title matched");

				} else {
					BaseSuite.reportFailLog("Expected title not matched kindly check", "clickOnUserConnectionTab");
					/**
					 * throw new AssertionError("Unable to reach user connections tab");
					 */
				}

			} else {
				BaseSuite.reportFailLog("User Connection tab not visible", "clickOnUserConnectionTab");
			}
		} catch (Exception e) {
			// throw new AssertionError("Unable to reach user connections tab", e);
		}
	}

	// method to close connection repo left side bar window panel
	public void closeConnRepoLeftSideBarPanel() {

		isDisplayedInLoop(driver, 10, leftArrow_connection);
		BaseSuite.reportLog("verifying left side arrow to close sidebar panel is visible or not");
		if (isDisplayed(driver, leftArrow_connection)) {

			BaseSuite.validationReportLog("Sidebar close arrow is visible on connection repository home page");
			BaseSuite.reportLog("Clicking on sidebar arrow to close left sidebar window");
			displayAndClick(driver, leftArrow_connection);
			BaseSuite.validationReportLog("Clicked on sidebar arrow to close left sidebar window successfully");
		} else {
			BaseSuite.reportFailLog("sidebar arrow not visible on home page", "closeConnRepoLeftSideBarPanel");
		}
	}

	// method to close connection repo left side bar window panel
	public void openConnRepoLeftSideBarPanel() {

		isDisplayedInLoop(driver, 10, leftArrowOpen_connection);
		BaseSuite.reportLog("verifying left side arrow to open sidebar panel is visible or not");
		if (isDisplayed(driver, leftArrowOpen_connection)) {

			BaseSuite.validationReportLog("Sidebar arrow is visible on connection repository home page");
			BaseSuite.reportLog("Clicking on sidebar arrow to Open left sidebar window panel");
			displayAndClick(driver, leftArrowOpen_connection);
			BaseSuite.validationReportLog("Clicked on sidebar arrow to Open left sidebar window panel successfully");
		} else {
			BaseSuite.reportFailLog("sidebar arrow not visible on home page", "openConnRepoLeftSideBarPanel");
		}
	}

	// method to validate pagination on connection repository page
	public void paginationCheck() {

		BaseSuite.reportLog("verifying pagination on connection repository page ");

		isDisplayedInLoop(driver, 10, connPaginationMsg);

		if (isDisplayed(driver, connPaginationMsg) && isDisplayed(driver, connPaginationBar)) {

			BaseSuite.validationReportLog(
					"Pagination bar and pagination details are visible on connection repository page");

			List<String> a = getPaginationDetails();
			String pageinfo = a.get(0);
			String totalRecords = a.get(1);
			String currentpage = a.get(2);

			int totalpage = Integer.parseInt(pageinfo.split(" ")[2]);

			BaseSuite.reportLog("Checking page arrows on connection repository");

			if (totalpage > 1) {
				BaseSuite.reportLog("checking page number are clickable or not ");

				for (int i = 2; i <= totalpage; i++) {

					BaseSuite.reportLog("Checking page number :: " + i);

					isClickable(driver, returnElement(pageinfo, "$num", Integer.toString(i)), currentpage, true);

					displayAndClick(driver, returnElement(pageinfo, "$num", Integer.toString(i)));

					BaseSuite.validationReportLog("Clicked on page number :: " + i + " successfully");

					getPaginationDetails();

				}
			} else {
				BaseSuite.validationReportLog(
						"Only one page is available on connection repository page with total connection listed are :: "
								+ totalRecords);
			}
		} else {
			BaseSuite.reportFailLog("Pagination not visible on connection repository page ", "paginationCheck");
		}
	}

	// method to click on advance search button
	public void clickOnAdvanceSearchButton() throws Exception {

		isDisplayedInLoop(driver, 10, advanceSearchButton);

		clickOnButton(driver, advanceSearchButton, "Advance Search ", true);

		isDisplayedInLoop(driver, 10, advanceSearchTitle);

		// validateAdvancedSearchSideBar_ConnectionRepository();
	}

	// method to select connectionType on advance search
	public void selectConnectionType(String connectionType, SoftAssert soft) {

		try {
			isDisplayedInLoop(driver, 10, connTypeTitle);

			verifyIndividualLabel(driver, connTypeTitle, "Connection Type");

			BaseSuite.reportLog("Clicking on select Connection type dropdown ");

			displayAndClick(driver, selectConnType);

			BaseSuite.validationReportLog("Clicked on select connection type dropdown successfully");

			isDisplayedInLoop(driver, 10, selectConnType1);

			if (isDisplayed(driver, selectConnType1)) {

				BaseSuite.validationReportLog("Select connection type pop up window is visible");

				BaseSuite.reportLog("Clicking on connection type : " + connectionType);

				isDisplayedInLoop(driver, 10, returnElement(desiredConnType, "$name", connectionType.trim()));

				displayAndClick(driver, returnElement(desiredConnType, "$name", connectionType.trim()));

				BaseSuite.validationReportLog("Clicked on Connection type : " + connectionType + " successfully");

				isDisplayedInLoop(driver, 10, selectConnType2);

				String str = getAttribute(driver, selectConnType2, "aria-label");

				soft.assertEquals(str, connectionType.trim());

				BaseSuite.validationReportLog("Expected : " + connectionType + " and Actual : " + str + " matched ");

				BaseSuite.validationReportLog("Connection type is selected successfully");

			} else {
				BaseSuite.reportFailLog("Select Connection type pop up drowdown not visible", "selectConnectionType");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to select Created by on advance search
	public void selectCreatedBy(String createdBy, SoftAssert soft) {

		try {
			isDisplayedInLoop(driver, 10, createdByTitle);

			verifyIndividualLabel(driver, createdByTitle, "Created By");

			BaseSuite.reportLog("Clicking on select Created By dropdown ");

			displayAndClick(driver, createdBydropdown);

			BaseSuite.validationReportLog("Clicked on select Created By dropdown successfully");

			isDisplayedInLoop(driver, 10, createdBypopup);

			if (isDisplayed(driver, createdBypopup)) {

				BaseSuite.validationReportLog("Select Created By pop up window is visible");

				BaseSuite.reportLog("Clicking on Created By : " + createdBy);

				isDisplayedInLoop(driver, 10, returnElement(desiredConnType, "$name", createdBy.trim()));

				clear_Click_SendKeys(driver, 10, createdBySearch, createdBy.trim());

				displayAndClick(driver, returnElement(desiredConnType, "$name", createdBy.trim()));

				BaseSuite.validationReportLog("Clicked on Created By : " + createdBy + " successfully");

				isDisplayedInLoop(driver, 10, createdBysearchBar);

				String str = getAttribute(driver, createdBysearchBar, "aria-label");

				soft.assertEquals(str, createdBy.trim());

				BaseSuite.validationReportLog("Expected : " + createdBy + " and Actual : " + str + " matched ");

				BaseSuite.validationReportLog("Created By is selected successfully");

			} else {
				BaseSuite.reportFailLog("Select Created By pop up drowdown not visible", "selectCreatedBy");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to select Updated by on advance search
	public void selectUpdatedBy(String updateBy, SoftAssert soft) {

		try {
			isDisplayedInLoop(driver, 10, updatedByTitle);

			verifyIndividualLabel(driver, updatedByTitle, "Updated By");

			BaseSuite.reportLog("Clicking on select Updated by  dropdown ");

			displayAndClick(driver, UpdatedBydropdown);

			BaseSuite.validationReportLog("Clicked on select Updated By dropdown successfully");

			isDisplayedInLoop(driver, 10, UpdatedBypopup);

			if (isDisplayed(driver, UpdatedBypopup)) {

				BaseSuite.validationReportLog("Select Updated By pop up window is visible");

				BaseSuite.reportLog("Clicking on Created By : " + updateBy);

				isDisplayedInLoop(driver, 10, returnElement(desiredConnType, "$name", updateBy.trim()));

				clear_Click_SendKeys(driver, 10, UpdatedBySearch, updateBy.trim());

				displayAndClick(driver, returnElement(desiredConnType, "$name", updateBy.trim()));

				BaseSuite.validationReportLog("Clicked on Updated By : " + updateBy + " successfully");

				isDisplayedInLoop(driver, 10, UpdatedBysearchBar);

				String str = getAttribute(driver, UpdatedBysearchBar, "aria-label");

				soft.assertEquals(str, updateBy.trim());

				BaseSuite.validationReportLog("Expected : " + updateBy + " and Actual : " + str + " matched ");

				BaseSuite.validationReportLog("Connection Updated By is selected successfully");

			} else {
				BaseSuite.reportFailLog("Select Updated By pop up drowdown not visible", "selectCreatedBy");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to select create date on advance search
	public void selectCreateDate(String createDate, SoftAssert soft) {

		try {
			isDisplayedInLoop(driver, 10, createdDateTitle);

			verifyIndividualLabel(driver, createdDateTitle, "Create date");

			BaseSuite.reportLog("Clicking on select Create date search ");

			displayAndClick(driver, createDateSearch);

			BaseSuite.validationReportLog("Clicked on Created date search successfully");

			BaseSuite.reportLog("Entering on Create date : " + createDate);

			clear_Click_SendKeys(driver, 10, createDateSearch, createDate.trim());

			BaseSuite.validationReportLog("Entered Created date successfully");

			isDisplayedInLoop(driver, 10, createDateSearch);

			// String str =
			// driver.findElement(createDateSearch).getAttribute("textContent");

			// soft.assertEquals(str, createDate.trim());

			// BaseSuite.validationReportLog("Expected : "+createDate+" and Actual : "+str+"
			// matched ");

			BaseSuite.validationReportLog("Connection Created Date is selected successfully");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to select Update date on advance search
	public void selectUpdateDate(String updateDate, SoftAssert soft) {

		try {
			isDisplayedInLoop(driver, 10, updatedDateTitle);

			verifyIndividualLabel(driver, updatedDateTitle, "Create date");

			BaseSuite.reportLog("Clicking on select Update date search ");

			displayAndClick(driver, updateDateSearch);

			BaseSuite.validationReportLog("Clicked on Update date search successfully");

			BaseSuite.reportLog("Entering on Update date : " + updateDate);

			clear_Click_SendKeys(driver, 10, updateDateSearch, updateDate.trim());

			BaseSuite.validationReportLog("Entered Update date successfully");

			isDisplayedInLoop(driver, 10, updateDateSearch);

			// String str =
			// driver.findElement(updateDateSearch).getAttribute("textContent");

			// soft.assertEquals(str, createDate.trim());

			// BaseSuite.validationReportLog("Expected : "+createDate+" and Actual : "+str+"
			// matched ");

			BaseSuite.validationReportLog("Connection Updated Date is selected successfully");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to click on search button on advance search side bar
	public void clickOnSearchButton() throws Exception {

		isDisplayedInLoop(driver, 10, adSearchBtn);

		clickOnButton(driver, adSearchBtn, "Search", true);
	}

	public String verifyTextBox(WebDriver driver, By locator, String txtboxlabel, boolean expected) {

		String placeholder = null;

		isDisplayedInLoop(driver, 10, locator);

		if (isDisplayed(driver, locator)) {

			BaseSuite.reportLog(txtboxlabel + " textbox is visible ");

			isClickable(driver, locator, txtboxlabel, expected);

			placeholder = getAttribute(driver, locator, "aria-placeholder");

			BaseSuite.reportLog(txtboxlabel + " textbox visible placeholder value :: " + placeholder);

		} else {
			BaseSuite.reportFailLog(txtboxlabel + " is not visible", txtboxlabel);
		}
		return placeholder;
	}

	// method to validate advance search side bar of connection repository
	public void validateAdvancedSearchSideBar_ConnectionRepository() {

		BaseSuite.reportLog("======== Validating Advanced search side panel  ========");

		isDisplayedInLoop(driver, 10, advanceSearchTitle);

		verifyIndividualLabel(driver, advanceSearchTitle, "Advance Search Title");

		verifyIndividualLabel(driver, connTypeTitle, "Connection Type");

		verifyTextBox(driver, selectConnType2, "Connection Type", true);

		verifyIndividualLabel(driver, createdByTitle, "Created By ");

		verifyTextBox(driver, createdBysearchBar, "Created By ", true);

		verifyIndividualLabel(driver, updatedByTitle, "Updated By ");

		verifyTextBox(driver, UpdatedBysearchBar, "Updated By ", true);

		verifyIndividualLabel(driver, createdDateTitle, "Created Date ");

		verifyTextBox(driver, createDateSearch, "Created Date ", true);

		verifyIndividualLabel(driver, updatedDateTitle, "Updated Date ");

		verifyTextBox(driver, updateDateSearch, "Updated By ", true);

		verifyVisibilityOfButtons(driver, searchButton, "Search ", true);

		isClickable(driver, searchButton, "Search ", true);

		BaseSuite.reportLog("======== Advanced search side panel verified successfully  ========");
	}

	// method to use advanced search functionality on connection repository
	public void advanceSearch_ConnectionRepository(String connType, String createdBy, String updateBy,
			String createDate, String updateDate, SoftAssert s) {

		try {

			clickOnAdvanceSearchButton();

			validateAdvancedSearchSideBar_ConnectionRepository();

			selectConnectionType(connType, s);

			selectCreatedBy(createdBy, s);

			selectUpdatedBy(updateBy, s);

			selectCreateDate(createDate, s);

			selectUpdateDate(updateDate, s);

			clickOnSearchButton();

			inVisible(driver, connectionPageSpinner, Constant.ruleWait);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// ================================Dhawal's
	// code=================================================//

	public void selectWorkspace(String workspaceName) {
		BaseSuite.reportLog("Selecting Workspace");

		displayAndClick(driver, selectWorkspaceClick);

		clear_SendKeys(driver, selectWorkspaceSearch, workspaceName);

		displayAndClick(driver, returnElement(selectWorkspaceSearchClick, "$name", workspaceName));

		BaseSuite.reportLog("Workspace selected successfully");

	}

	public void selectDriver(String driverName) {
		BaseSuite.reportLog("Selecting Driver");

		displayAndClick(driver, selectDriver);

		displayAndClick(driver, returnElement(selectWorkspaceSearchClick, "$name", driverName));

		BaseSuite.reportLog("Driver selected successfully");
	}

	public void selectAuthentication(String authentication) {
		BaseSuite.reportLog("Selecting Authentication");

		displayAndClick(driver, selectAuthentication);

		displayAndClick(driver, returnElement(selectWorkspaceSearchClick, "$name", authentication));

		BaseSuite.reportLog("Authentication selected successfully");
	}

	public void customJdbcUrl() {

		try {
			BaseSuite.reportLog("Clicking on Custom JDBC URL");

			displayAndClick(driver, customJdbcUrlToggleButton);

			BaseSuite.reportLog("Custom JDBC URL clicked successfully");
		} catch (Exception e) {

			e.getMessage();
		}

	}

	/*
	 * This methode will create connection usinf excel for 1)Oracle 2)AS4OO 3)DB2
	 * 4)Greenplum 5)Postgres 5)ApacheDrill 6)Cassandra 7)JDBC-ODBC 8) Sql server
	 */
	public void createDBConnection(ConnectionPoJO connParam, SoftAssert soft) {
		try {

			// NehaConnectionPage conn = new NehaConnectionPage(driver);

			ConnectionHome home = new ConnectionHome(driver);

			home.clickConnnectionsTab();

			connectionRepositoryLandingPage();

			verifyConnectionIsCreatedOrNot(connParam.getConnName());

			if (isDisplayed(driver, noRecondsFound)) {

				home.clickOnNewConnectionBtn();

				connTabsButtonsClickableOrNotOnNewConnectionPage();

				chooseConnectionType(connParam.getConnectionType(), soft);

				BaseSuite.reportLog("Entering connection name in Name field : " + connParam.getConnName());

				clear_SendKeys(driver, connectionName, connParam.getConnName());

				BaseSuite.reportLog("Connection name entered successfully in Name field");

				selectDriver(connParam.getDriverName());

				selectAuthentication(connParam.getAuthentication());

				if (connParam.getCustomJdbcFullUrl().isEmpty()) {
					if (connParam.getConnectionType().equalsIgnoreCase("AS400")) {

						BaseSuite.reportLog("Entering Server Name in Server Name field : " + connParam.getServer());

						clear_SendKeys(driver, serverName, connParam.getServer());

						BaseSuite.reportLog("Server Name entered successfully in Server Name field");

					}

					else if (connParam.getConnectionType().equalsIgnoreCase("JDBC-ODBC")) {

						BaseSuite.reportLog("Entering DSN Name in DSN Name field : " + connParam.getDsn());

						clear_SendKeys(driver, dsnName, connParam.getDsn());

						BaseSuite.reportLog("DSN Name entered successfully in DSN Name field");

					} else {
						BaseSuite.reportLog("Entering Host in Host field : " + connParam.getHost());

						clear_SendKeys(driver, clickonConnectionHost, connParam.getHost());

						BaseSuite.reportLog("Host entered successfully in Host field");

						BaseSuite.reportLog("Entering Port in Port field : " + connParam.getPort());

						clear_SendKeys(driver, clickonConnectionPort, connParam.getPort());

						BaseSuite.reportLog("Port entered successfully in Port field");
					}

					if (!connParam.getConnectionType().equalsIgnoreCase("JDBC-ODBC")) {
						BaseSuite.reportLog(
								"Entering Database name in Database name field : " + connParam.getDatabase());

						clear_SendKeys(driver, clickonDatabase, connParam.getDatabase());

						BaseSuite.reportLog("Database name entered successfully in Database name field");
					}
				} else {
					customJdbcUrl();

					BaseSuite.reportLog(
							"Entering JDBC URL in Custome JDBC URL field : " + connParam.getCustomJdbcFullUrl());

					clear_Click_SendKeys(driver, 5, connectionFullUrl, connParam.getCustomJdbcFullUrl());

					BaseSuite.reportLog("JDBC URL entered successfully in Custome JDBC URL field");

				}
				if (connParam.getConnectionType().trim().equalsIgnoreCase("Sql Server")
						&& connParam.getAuthentication().trim().equalsIgnoreCase("Windows Authentication")) {

					if (!connParam.getInstaceName().isEmpty()) {
						BaseSuite.reportLog("Entering Instance name field : " + connParam.getInstaceName());

						clear_Click_SendKeys(driver, 5, instanceName, connParam.getInstaceName());

						BaseSuite.reportLog("Instance name entered successfully");
					}
					if (!connParam.getDomainName().isEmpty()) {
						BaseSuite.reportLog("Entering Domain name field : " + connParam.getDomainName());

						clear_Click_SendKeys(driver, 5, domainName, connParam.getDomainName());

						BaseSuite.reportLog("Domain name entered successfully");
					}
				}

				if (!connParam.getType().equalsIgnoreCase("System")) {
					displayAndClick(driver, selectConnType);

					displayAndClick(driver, returnElement(selectConnTypeSearch, "$name", connParam.getType()));

				}
				BaseSuite.reportLog("Entering UserName in UserName field : " + connParam.getUsername());

				clear_SendKeys(driver, enterUsername, connParam.getUsername());

				BaseSuite.reportLog("UserName entered successfully in UserName field");

				BaseSuite.reportLog("Entering Password in Password field : " + connParam.getPassword());

				clear_SendKeys(driver, enterPassword, connParam.getPassword());

				BaseSuite.reportLog("Password entered successfully in Password field");

				if (!connParam.getConnProperty().isEmpty()) {
					addConnectionProperties(connParam.getConnProperty());

				}

				// saveConnection(connectionSaveMesssage);

				testConnection(connectionTestMess);

			}

			else {

				BaseSuite.validationReportLog("Connection is already created with same name" + connParam.getConnName());
			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	/*
	 * This methode will create connection using Api for 1)Oracle 2)AS4OO 3)DB2
	 * 4)Greenplum 5)Postgres 5)ApacheDrill 6)Cassandra 7)JDBC-ODBC 8)Redshift
	 * 9)Teradata 10)My sql 11)Sql server 12) Snowflake
	 * 
	 */
	public void createDBConnectionFromApi(String jsonEntity, String connName, String connType, ConnectionPoJO connParam,
			SoftAssert soft) {
		try {

			// NehaConnectionPage conn = new NehaConnectionPage(driver);

			ConnectionHome home = new ConnectionHome(driver);

			home.clickConnnectionsTab();

			connectionRepositoryLandingPage();

			verifyConnectionIsCreatedOrNot(connName);

			String name1 = null;
			String userName = getConnectionDetailsUsingAuthType(connParam.getConnectorID(),
					connParam.getAuthentication(), 1);
			String password = getConnectionDetailsUsingAuthType(connParam.getConnectorID(),
					connParam.getAuthentication(), 2);
			if (isDisplayed(driver, returnElement(connectionsNameTex, "$name", connName))) {

				name1 = getText(driver, returnElement(connectionsNameTex, "$name", connName));
			}

			if (isDisplayed(driver, noRecondsFound) || !connName.equals(name1)) {

				home.clickOnNewConnectionBtn();

				connTabsButtonsClickableOrNotOnNewConnectionPage();

				chooseConnectionType(connType, soft);

				BaseSuite.reportLog("Entering connection name in Name field");

				clear_SendKeys(driver, connectionName, connName);

				BaseSuite.reportLog("Connection name entered successfully in Name field");

				if (!connType.equalsIgnoreCase("Snowflake")) {

					selectDriver(connParam.getDriverName());
				}

				selectAuthentication(connParam.getAuthentication());

				if (connParam.getCustomJdbcFullUrl().equalsIgnoreCase("False")) {
					if (connType.equalsIgnoreCase("AS400")) {

						BaseSuite.reportLog("Entering Server Name in Server Name field");

						clear_SendKeys(driver, serverName, connParam.getServer());

						BaseSuite.reportLog("Server Name entered successfully in Server Name field");

					}

					else if (connType.equalsIgnoreCase("JDBC-ODBC")) {

						BaseSuite.reportLog("Entering DSN Name in DSN Name field");

						clear_SendKeys(driver, dsnName, connParam.getDsn());

						BaseSuite.reportLog("DSN Name entered successfully in DSN Name field");

					} else if (connType.equalsIgnoreCase("Snowflake")) {

						BaseSuite.reportLog("Entering Account name in Account name field");

						clear_SendKeys(driver, acountIdentifier, connParam.getNameAccount());

						BaseSuite.validationReportLog("Account name entered successfully in Account name field");

						BaseSuite.reportLog("Entering wareHouse in wareHouse field");

						clear_SendKeys(driver, wareHouse, connParam.getWareHouseVal());

						BaseSuite.validationReportLog("wareHouse entered successfully in wareHouse field");

						if (connParam.getAuthentication().equalsIgnoreCase("key-pair")) {
							BaseSuite.reportLog("Entering keyFilePath in keyFilePath field");

							sendKeys(driver, keyFilePath, connParam.getFilePathKey());

							BaseSuite.validationReportLog("keyFilePath entered successfully in keyFilePath field");

						}

						else {
							BaseSuite.reportLog("Entering keyVaultName in keyVaultName field");

							clear_SendKeys(driver, keyVaultName, connParam.getKeyVaultName());

							BaseSuite.validationReportLog("keyVaultName entered successfully in keyVaultName field");

							BaseSuite.reportLog("Entering clientId in clientId field");

							clear_SendKeys(driver, clientId, connParam.getClientId());

							BaseSuite.validationReportLog("clientId entered successfully in clientId field");

							BaseSuite.reportLog("Entering tenantId in tenantId field");

							clear_SendKeys(driver, tenantId, connParam.getTenantId());

							BaseSuite.validationReportLog("tenantId entered successfully in tenantId field");

							BaseSuite.reportLog("Entering clientSecret in clientSecret field");

							clear_SendKeys(driver, clientSecret, connParam.getClientSecret());

							BaseSuite.validationReportLog("clientSecret entered successfully in clientSecret field");

							BaseSuite.reportLog("Entering privateKeySecretName in privateKeySecretName field");

							clear_SendKeys(driver, privateKeySecretName, connParam.getPrivateKeySecretName());

							BaseSuite.validationReportLog(
									"privateKeySecretName entered successfully in privateKeySecretName field");

							BaseSuite.reportLog("Entering privateKeyPasswordSecretName in privateKeySecretName field");

							clear_SendKeys(driver, privateKeyPasswordSecretName,
									connParam.getPrivateKeyPasswordSecretName());

							BaseSuite.validationReportLog(
									"privateKeyPasswordSecretName entered successfully in privateKeyPasswordSecretName field");

						}

					}

					else {
						BaseSuite.reportLog("Entering Host in Host field");

						clear_SendKeys(driver, clickonConnectionHost, connParam.getHost());

						BaseSuite.reportLog("Host entered successfully in Host field");

						BaseSuite.reportLog("Entering Port in Port field");

						clear_SendKeys(driver, clickonConnectionPort, connParam.getPort());

						BaseSuite.reportLog("Port entered successfully in Port field");
					}

					if (!connType.equalsIgnoreCase("JDBC-ODBC")) {

						BaseSuite.reportLog("Entering Database name in Database name field");

						clear_SendKeys(driver, clickonDatabase, connParam.getDatabase());

						BaseSuite.reportLog("Database name entered successfully in Database name field");
					}

					/*
					 * ==============Remove from UI and Backend============== if
					 * (connType.equalsIgnoreCase("Sql Server") &&
					 * connType.equalsIgnoreCase("Windows Authentication")) {
					 * 
					 * if (!connParam.getInstaceName().isEmpty()) {
					 * BaseSuite.reportLog("Entering Instance name field : " +
					 * connParam.getInstaceName());
					 * 
					 * clear_Click_SendKeys(driver, 5, instanceName, connParam.getInstaceName());
					 * 
					 * BaseSuite.reportLog("Instance name entered successfully"); } if
					 * (!connParam.getDomainName().isEmpty()) {
					 * BaseSuite.reportLog("Entering Domain name field : " +
					 * connParam.getDomainName());
					 * 
					 * clear_Click_SendKeys(driver, 5, domainName, connParam.getDomainName());
					 * 
					 * BaseSuite.reportLog("Domain name entered successfully"); } }
					 */

				} else {
					customJdbcUrl();

					BaseSuite.reportLog("Entering JDBC URL in Custome JDBC URL field");

					clear_Click_SendKeys(driver, 5, connectionFullUrl, connParam.getCustomJdbcFullUrl());

					BaseSuite.reportLog("JDBC URL entered successfully in Custome JDBC URL field");

				}

				if (!connParam.getType().equalsIgnoreCase("System")) {
					displayAndClick(driver, selectConnType);

					displayAndClick(driver, returnElement(selectConnTypeSearch, "$name", connParam.getType()));

				}
				if (connParam.getType().equalsIgnoreCase("System")) {
					BaseSuite.reportLog("Entering UserName in UserName field" + userName);

					clear_SendKeys(driver, enterUsername, userName);

					BaseSuite.reportLog("UserName entered successfully in UserName field");

					BaseSuite.reportLog("Entering Password in Password field " + password);

					clear_SendKeys(driver, enterPassword, password);

					BaseSuite.reportLog("Password entered successfully in Password field");
				}

				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity, "$.connectionProperties..name");

				int count = connPropertyList.size();

				if (count > 0) {

					ArrayList<String> name = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
							"$.connectionProperties..name");

					ArrayList<String> value = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
							"$.connectionProperties..value");

					ArrayList<String> type = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
							"$.connectionProperties..type");

					for (int j = 0; j < name.size(); j++) {

						addConnectionProperties(name.get(j), value.get(j), type.get(j));
					}

				}

				saveConnection(connectionSaveMesssage);

				if (connParam.getType().trim().equalsIgnoreCase("user")) {
					clickOnUserConnectionTab();
					searchAndClickOnConnectionName(connName);
					enterUserNameAndPassword(userName, password);
					saveConnection(connectionSaveMesssage);
				}

				testConnection(connectionTestMess);

			}

			else {

				BaseSuite.validationReportLog("Connection is already created with same name" + connParam.getConnName());
			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void createSnowflakeConnection(ConnectionPoJO connParam, SoftAssert soft) {

		try {
			NehaConnectionPage conn = new NehaConnectionPage(driver);

			ConnectionHome home = new ConnectionHome(driver);

			home.clickConnnectionsTab();

			connectionRepositoryLandingPage();

			verifyConnectionIsCreatedOrNot(connParam.getConnName());

			if (isDisplayed(driver, noRecondsFound)) {

				home.clickOnNewConnectionBtn();

				connTabsButtonsClickableOrNotOnNewConnectionPage();

				conn.chooseConnectionType(connParam.getConnectionType(), soft);

				BaseSuite.reportLog("Entering connection name in Name field");

				clear_SendKeys(driver, connectionName, connParam.getConnName());

				BaseSuite.reportLog("Connection name entered successfully in Name field");

				selectAuthentication(connParam.getAuthentication());

				if (connParam.getCustomJdbcFullUrl().isEmpty()) {

					BaseSuite.reportLog("Entering Account name in Account name field");

					clear_SendKeys(driver, acountIdentifier, connParam.getNameAccount());

					BaseSuite.validationReportLog("Account name entered successfully in Account name field");

					BaseSuite.reportLog("Entering Region in Region field");

					clear_SendKeys(driver, region, connParam.getRegionValue());

					BaseSuite.validationReportLog("Region entered successfully in Region field");

					BaseSuite.reportLog("Entering cloud Platform in cloud Platform field");

					clear_SendKeys(driver, cloudPlatform, connParam.getCloudPlatformVal());

					BaseSuite.validationReportLog("cloud Platform entered successfully in cloud Platform field");

					BaseSuite.reportLog("Entering wareHouse in wareHouse field");

					clear_SendKeys(driver, wareHouse, connParam.getWareHouseVal());

					BaseSuite.validationReportLog("wareHouse entered successfully in wareHouse field");

					BaseSuite.reportLog("Entering database name in database name field");

					clear_SendKeys(driver, databaseName, connParam.getDatabaseNameVal());

					BaseSuite.validationReportLog("database name entered successfully in database name field");

				} else {
					customJdbcUrl();

					BaseSuite.reportLog("Entering JDBC URL in Custome JDBC URL field");

					clear_Click_SendKeys(driver, 5, connectionFullUrl, connParam.getCustomJdbcFullUrl());

					BaseSuite.reportLog("JDBC URL entered successfully in Custome JDBC URL field");

				}

				if (!connParam.getType().equalsIgnoreCase("System")) {
					displayAndClick(driver, selectConnType);

					displayAndClick(driver, returnElement(selectConnTypeSearch, "$name", connParam.getType()));

				}
				BaseSuite.reportLog("Entering UserName in UserName field");

				clear_SendKeys(driver, enterUsername, connParam.getUsername());

				BaseSuite.reportLog("UserName entered successfully in UserName field");

				BaseSuite.reportLog("Entering Password in Password field");

				clear_SendKeys(driver, enterPassword, connParam.getPassword());

				BaseSuite.reportLog("Password entered successfully in Password field");

				if (!connParam.getConnProperty().isEmpty()) {
					addConnectionProperties(connParam.getConnProperty());

				}

				saveConnection(connectionSaveMesssage);

				testConnection(connectionTestMess);
			} else {

				BaseSuite.validationReportLog("Connection is already created with same name" + connParam.getConnName());

			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public ConnectionPoJO setConnectionParameters(String fileName, String sheetName, int rowNumber) throws Exception {
		ConnectionPoJO connParam = new ConnectionPoJO();
		XLUtils xl = new XLUtils();

		try {

			connParam.setConnectionType(xl.readUsingColName(fileName, sheetName, rowNumber, "connectionType"));
			connParam.setConnName(xl.readUsingColName(fileName, sheetName, rowNumber, "connName"));
			connParam.setDriverName(xl.readUsingColName(fileName, sheetName, rowNumber, "driverName"));
			connParam.setAuthentication(xl.readUsingColName(fileName, sheetName, rowNumber, "authentication"));
			connParam.setCustomJdbcFullUrl(xl.readUsingColName(fileName, sheetName, rowNumber, "customJdbcFullUrl"));
			connParam.setServer(xl.readUsingColName(fileName, sheetName, rowNumber, "server"));
			connParam.setDsn(xl.readUsingColName(fileName, sheetName, rowNumber, "dsn"));
			connParam.setHost(xl.readUsingColName(fileName, sheetName, rowNumber, "host"));
			connParam.setPort(xl.readUsingColName(fileName, sheetName, rowNumber, "port"));
			connParam.setDatabase(xl.readUsingColName(fileName, sheetName, rowNumber, "database"));
			connParam.setType(xl.readUsingColName(fileName, sheetName, rowNumber, "type"));
			connParam.setUsername(xl.readUsingColName(fileName, sheetName, rowNumber, "username"));
			connParam.setPassword(xl.readUsingColName(fileName, sheetName, rowNumber, "password"));
			connParam.setConnProperty(xl.readUsingColName(fileName, sheetName, rowNumber, "connProperty"));
			connParam.setNameAccount(xl.readUsingColName(fileName, sheetName, rowNumber, "nameAccount"));
			connParam.setRegionValue(xl.readUsingColName(fileName, sheetName, rowNumber, "regionValue"));
			connParam.setCloudPlatformVal(xl.readUsingColName(fileName, sheetName, rowNumber, "cloudPlatformVal"));
			connParam.setWareHouseVal(xl.readUsingColName(fileName, sheetName, rowNumber, "wareHouseVal"));
			connParam.setDatabaseNameVal(xl.readUsingColName(fileName, sheetName, rowNumber, "databaseNameVal"));
			connParam.setInstaceName(xl.readUsingColName(fileName, sheetName, rowNumber, "instanceName"));
			connParam.setDomainName(xl.readUsingColName(fileName, sheetName, rowNumber, "domainName"));
			connParam.setName(xl.readUsingColName(fileName, sheetName, rowNumber, "name"));
			connParam.setLocationname(xl.readUsingColName(fileName, sheetName, rowNumber, "locationname"));
			connParam.setFiletypename(xl.readUsingColName(fileName, sheetName, rowNumber, "filetypename"));
			connParam.setAuthenticationname(xl.readUsingColName(fileName, sheetName, rowNumber, "authenticationname"));
			connParam.setFilepath(xl.readUsingColName(fileName, sheetName, rowNumber, "filepath"));
			connParam.setTypeselect(xl.readUsingColName(fileName, sheetName, rowNumber, "typeselect"));
			connParam.setAccountname(xl.readUsingColName(fileName, sheetName, rowNumber, "accountname"));
			connParam.setAzureAccesskey(xl.readUsingColName(fileName, sheetName, rowNumber, "accountkey"));
			connParam.setSessiontoken(xl.readUsingColName(fileName, sheetName, rowNumber, "sessiontoken"));
			connParam.setRegion(xl.readUsingColName(fileName, sheetName, rowNumber, "region"));
			connParam.setAccess(xl.readUsingColName(fileName, sheetName, rowNumber, "access"));
			connParam.setSecret(xl.readUsingColName(fileName, sheetName, rowNumber, "secret"));
			connParam.setDropDownValue(xl.readUsingColName(fileName, sheetName, rowNumber, "dropDownValue"));
			// connParam.setConnectiontype(xl.readUsingColName(fileName,
			// sheetName,rowNumber, "connectiontype"));
			connParam.setConnectionsearch(xl.readUsingColName(fileName, sheetName, rowNumber, "connectionsearch"));
			connParam.setConnectionid(xl.readUsingColName(fileName, sheetName, rowNumber, "connectionid"));
			connParam.setPropertyName(xl.readUsingColName(fileName, sheetName, rowNumber, "propertyName"));

			return connParam;

		} catch (Exception e) {

			throw new Exception();
		}

	}

	public ConnectionPoJO setConnectionParametersForApi(String jsonEntity) throws Exception {
		ConnectionPoJO connParam = new ConnectionPoJO();
		XLUtils xl = new XLUtils();

		try {
			if (!jsonEntity.isEmpty()) {

				connParam.setDriverName(
						TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.driverId"));
				connParam.setAuthentication(
						TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.authTypeId"));
				connParam.setCustomJdbcFullUrl(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.serverConfig.useJDBCurl"));
				// connParam.setServer();
				// connParam.setDsn();
				connParam.setHost(
						TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.serverConfig.info.host"));
				connParam.setPort(
						TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.serverConfig.info.port"));
				connParam.setDatabase(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.serverConfig.info.database"));
				connParam.setType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.type"));
				connParam.setUsername(
						TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.authConfig.username"));
				connParam.setPassword(
						TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.authConfig.password"));
				connParam.setConnProperty(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.payload.connectionInfo.connectionProperties"));
				connParam.setSecretId(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.secretId"));
				/*
				 * connParam.setNameAccount(TestDataThroughApi.
				 * getJsonValueUsingJsonPathExpreesion(jsonEntity,
				 * "$.serverConfig.info.accountIdentifier"));
				 * connParam.setWareHouseVal(TestDataThroughApi.
				 * getJsonValueUsingJsonPathExpreesion(jsonEntity,
				 * "$.serverConfig.info.warehouse"));
				 * connParam.setFilePathKey(TestDataThroughApi.
				 * getJsonValueUsingJsonPathExpreesion(jsonEntity,
				 * "$.authConfig.privateKeyContentBase64Encoded"));
				 */
				connParam.setKeyFileContent(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.authConfig.privateKeyContentBase64Encoded"));

				connParam.setKeyFilePassword(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.authConfig.privateKeyPassphrase"));

				connParam.setKeyVaultName(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.authConfig.keyVaultName"));
				connParam.setTenantId(
						TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.authConfig.tenantId"));

				connParam.setConnectorID(
						TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.connectorId"));

				connParam.setCustomJDBCURLValue(
						TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.serverConfig.jdbcUrl"));
				connParam.setAccountIdentifire(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.serverConfig.info.accountIdentifier"));
				connParam.setWarehouse(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.serverConfig.info.warehouse"));
				connParam.setDatabaseName(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.serverConfig.info.database"));
				connParam.setConnName(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.name"));
				connParam.setServiceProviderName(
						TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.serviceProviderName"));
				connParam.setFileType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.serverConfig.info.fileType"));
				connParam.setFolderPath(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.serverConfig.info.folderPath"));
				connParam.setContainer(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.serverConfig.info.container"));
				connParam.setRegionValue(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.serverConfig.info.region"));
				connParam.setAccessKey(getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 3));
				connParam.setSecretKey(getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 4));
				// Rahul's parameter's for API

				connParam.setLocationname(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.serverConfig.info.location"));
				connParam.setFiletypename(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.serverConfig.info.fileType"));

				connParam.setAuthenticationname(setAuthenticationType(connParam.getAuthentication()));
				connParam.setFilepath(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.payload.connectionInfo.uri"));
				connParam.setTypeselect(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.status"));
				connParam.setAccountname(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.payload.connectionInfo.username"));
				connParam.setAzureAccesskey(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"payload.connectionInfo.password"));
				connParam.setSessiontoken(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.payload.connectionInfo.securityToken"));
				connParam.setRegion(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.payload.connectionInfo.region"));
				connParam.setAccess(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.payload.connectionInfo.username"));
				connParam.setSecret(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.payload.connectionInfo.password"));
				// connParam.setConnectiontype(xl.readUsingColName(fileName,
				// sheetName,rowNumber, "connectiontype"));
				connParam.setConnectionid(
						TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.payload.connId"));
				connParam.setPropertyName(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..name"));
				connParam.setInstaceName(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.serverConfig.info.instanceName"));
				connParam.setDomainName(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.serverConfig.info.domainName"));

			}
			return connParam;

		} catch (Exception e) {

			throw new Exception();
		}

	}

	public boolean saveConnection(String mess) throws Exception {
		boolean flag = true;
		try {

			BaseSuite.reportLog("Clicking on connection Save button");

			javascript(driver, "arguments[0].scrollIntoView(true);", connSaveBtn);

			flag = verifyVisibilityOfButtons(driver, connSaveBtn, "Save", flag);

			if (flag) {
				displayAndClick(driver, connSaveBtn);

				Thread.sleep(1000);

				inVisible(driver, spinner, Constant.ruleWait);

				BaseSuite.reportLog("connection Save button clicked successfully");

				flag = captureToastMsg(driver, toastMsg, popUpClose, mess, "Connection Save");
			}
		} catch (Exception ex) {
			throw new Exception();
		}
		return flag;
	}

	public boolean testConnection(String mess) throws Exception {
		boolean flag = true;
		try {
			flag = verifyVisibilityOfButtons(driver, connTestBtn, "Test", flag);

			if (flag) {
				BaseSuite.reportLog("Clicking on connection Test button");
				isDisplayedInLoop(driver, 4, connTestBtn);
				displayAndClick(driver, connTestBtn);

				inVisible(driver, spinner, Constant.ruleWait);

				BaseSuite.reportLog("connection Test button clicked successfully");

				flag = captureToastMsg(driver, toastMsg, popUpClose, mess, "Connection Test");
			}
		} catch (Exception ex) {
			throw new Exception(ex.toString());
		}
		return flag;
	}

	// For API use
	public void addConnectionProperties(String name, String value, String type) {

		try {

			BaseSuite.reportLog("Clicking on Add connection Properties button");

			displayAndClick(driver, connectionProperties);

			BaseSuite.validationReportLog("connection Properties button clicked successfully");

			BaseSuite.reportLog("Clicking on Add Property button");

			displayAndClick(driver, addConnProperty);

			BaseSuite.validationReportLog("Add Property button clicked successfully");

			BaseSuite.reportLog("Entering property Name");

			clear_SendKeys(driver, addPropertyName, name);

			BaseSuite.validationReportLog("Poperty Name entered successfully");

			BaseSuite.reportLog("Entering property Value");

			clear_SendKeys(driver, addPropertyValue, value);

			BaseSuite.validationReportLog("Poperty Value entered successfully");

			BaseSuite.reportLog("Selecting property Type");

			// displayAndClick(driver, addPropertyTypeClick);

			javascript(driver, "arguments[0].click();", addPropertyTypeClick);

			Thread.sleep(2000);

			displayAndClick(driver, returnElement(addPropertyType, "$name", type));

			BaseSuite.validationReportLog("Poperty Type selected successfully");

			BaseSuite.reportLog("Clicking on Done button");

			displayAndClick(driver, addPropertyDone);

			BaseSuite.validationReportLog("Done button clicked successfully");

		} catch (Exception e) {

			e.getMessage();
		}

	}

	// For Excel use
	public void addConnectionProperties(String colName) {

		try {

			javascript(driver, "arguments[0].scrollIntoView(true);", addConnProperty);

			int count = getcount(colName, ';');

			String[] result = colName.split(";");

			for (int colNum = 0; colNum <= count; colNum++) {

				String priviliges = result[colNum];

				String[] pri = priviliges.split(",");

				String name = pri[0];

				String value = pri[1];

				String type = pri[2];

				BaseSuite.reportLog("Clicking on Add Property button");

				displayAndClick(driver, addConnProperty);

				BaseSuite.validationReportLog("Add Property button clicked successfully");

				BaseSuite.reportLog("Entering property Name");

				clear_SendKeys(driver, addPropertyName, name);

				BaseSuite.validationReportLog("Poperty Name entered successfully");

				BaseSuite.reportLog("Entering property Value");

				clear_SendKeys(driver, addPropertyValue, value);

				BaseSuite.validationReportLog("Poperty Value entered successfully");

				BaseSuite.reportLog("Selecting property Type");

				displayAndClick(driver, addPropertyTypeClick);

				Thread.sleep(2000);

				displayAndClick(driver, returnElement(addPropertyType, "$name", type));

				BaseSuite.validationReportLog("Property Type selected successfully");

				BaseSuite.reportLog("Clicking on Done button");

				displayAndClick(driver, addPropertyDone);

				BaseSuite.validationReportLog("Done button clicked successfully");

			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void updateConnectionProperties(String colName) {

		try {

			javascript(driver, "arguments[0].scrollIntoView(true);", addConnProperty);

			int count = getcount(colName, ';');

			String[] result = colName.split(";");

			for (int colNum = 0; colNum <= count; colNum++) {

				String priviliges = result[colNum];

				String[] pri = priviliges.split(",");

				String name = pri[0];

				String value = pri[1];

				String type = pri[2];

				BaseSuite.reportLog("Clicking on Edit Property button");

				displayAndClick(driver, returnElement(editConnProperty, "$name", Integer.toString(colNum)));

				BaseSuite.validationReportLog("Edit Property button clicked successfully");

				BaseSuite.reportLog("Entering property Name");

				clear_SendKeys(driver, addPropertyName, name);

				BaseSuite.validationReportLog("Poperty Name entered successfully");

				BaseSuite.reportLog("Entering property Value");

				clear_SendKeys(driver, addPropertyValue, value);

				BaseSuite.validationReportLog("Poperty Value entered successfully");

				BaseSuite.reportLog("Selecting property Type");

				displayAndClick(driver, addPropertyTypeClick);

				Thread.sleep(2000);

				displayAndClick(driver, returnElement(addPropertyType, "$name", type));

				BaseSuite.validationReportLog("Poperty Type selected successfully");

				BaseSuite.reportLog("Clicking on Done button");

				displayAndClick(driver, returnElement(updateDoneButtonConnProperty, "$name", Integer.toString(colNum)));

				BaseSuite.validationReportLog("Done button clicked successfully");

			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void updateDBConnection(String connectionType, String scearchConnName, String connName, String driverName,
			String authentication, String customJdbcFullUrl, String server, String dsn, String host, String port,
			String database, String type, String username, String password, String connProperty, SoftAssert soft) {

		try {
			NehaConnectionPage conn = new NehaConnectionPage(driver);

			ConnectionHome home = new ConnectionHome(driver);

			home.clickConnnectionsTab();

			conn.connectionLandingpage_SearchConnection(scearchConnName, soft);

			BaseSuite.reportLog("Entering connection name in Name field");

			clear_SendKeys(driver, connectionName, connName);

			BaseSuite.reportLog("Connection name entered successfully in Name field");

			selectDriver(driverName);

			selectAuthentication(authentication);

			if (customJdbcFullUrl.isEmpty()) {

				if (connectionType.equalsIgnoreCase("AS400")) {

					BaseSuite.reportLog("Entering Server Name in Server Name field");

					clear_SendKeys(driver, serverName, server);

					BaseSuite.reportLog("Server Name entered successfully in Server Name field");

				}

				else if (connectionType.equalsIgnoreCase("JDBC-ODBC")) {

					BaseSuite.reportLog("Entering DSN Name in DSN Name field");

					clear_SendKeys(driver, dsnName, dsn);

					BaseSuite.reportLog("DSN Name entered successfully in DSN Name field");

				} else {

					BaseSuite.reportLog("Entering Host in Host field");

					clear_SendKeys(driver, clickonConnectionHost, host);

					BaseSuite.reportLog("Host entered successfully in Host field");

					BaseSuite.reportLog("Entering Port in Port field");

					clear_SendKeys(driver, clickonConnectionPort, port);

					BaseSuite.reportLog("Port entered successfully in Port field");
				}

				if (!connectionType.equalsIgnoreCase("JDBC-ODBC")) {

					BaseSuite.reportLog("Entering Database name in Database name field");

					clear_SendKeys(driver, clickonDatabase, database);

					BaseSuite.reportLog("Database name entered successfully in Database name field");
				}
			} else {

				BaseSuite.reportLog("Entering JDBC URL in Custome JDBC URL field");

				clear_Click_SendKeys(driver, 5, connectionFullUrl, customJdbcFullUrl);

				BaseSuite.reportLog("JDBC URL entered successfully in Custome JDBC URL field");

			}

			if (!type.equalsIgnoreCase("System")) {
				displayAndClick(driver, selectConnType);

				displayAndClick(driver, returnElement(selectConnTypeSearch, "$name", type));

			}
			BaseSuite.reportLog("Entering UserName in UserName field");

			clear_SendKeys(driver, enterUsername, username);

			BaseSuite.reportLog("UserName entered successfully in UserName field");

			BaseSuite.reportLog("Entering Password in Password field");

			clear_SendKeys(driver, enterPassword, password);

			BaseSuite.reportLog("Password entered successfully in Password field");

			if (!connProperty.isEmpty()) {

				updateConnectionProperties(connProperty);
			}

			saveConnection(connectionUpdate);

			testConnection(connectionTestMess);
		} catch (Exception e) {

			e.getMessage();
		}

	}

	///////////////////////////////////////////// Rahul's
	///////////////////////////////////////////// code/////////////////////////////////////////////////////
	// Method to click on FlatFile Native
	public void flatfilenative(ConnectionPoJO connParam, SoftAssert soft) {
		try {
			// choose connection type

			NehaConnectionPage conn = new NehaConnectionPage(driver);

			conn.chooseConnectionType(connParam.getConnectionType(), soft);

			// to check workspace
			BaseSuite.validationReportLog("Checking Workspace is visible or Not");

			if (isEnabled(driver, connectionwks)) {
				String wkscheck = getText(driver, connectionwks);

				if (wkscheck.equalsIgnoreCase(BaseSuite.WorkspaceName)) {
					BaseSuite.validationReportLog(wkscheck + " Workspace is visible");

				} else {
					BaseSuite.reportFailLog("Workspace visiblility Field failed to display", "connectionwks");

				}
			}

			connName(connParam.getName());

			dropdownselection(connectionlocation, connectionlocationoptions, connParam.getLocationname());
			dropdownselection(connectionfiletype, connectionfileoptions, connParam.getFiletypename());
			dropdownselection(connectionauthentication, connectionauthenticationoptions,
					connParam.getAuthenticationname());

			filepath(connParam.getFilepath());
			//
			if (connParam.getLocationname().equalsIgnoreCase("Azure Blob")
					&& (connParam.getAuthenticationname().equalsIgnoreCase("Access Key"))) {
				// Account Name
				accname(connParam.getAccountname());

				// Account Key
				acckey(connParam.getAzureAccesskey());

			} else if (connParam.getLocationname().equalsIgnoreCase("Azure Blob")
					&& (connParam.getAuthenticationname().equalsIgnoreCase("Shared Access Signature"))) {
				// to select session token
				sessionToken(connParam.getSessiontoken());
			} else if (connParam.getLocationname().equalsIgnoreCase("S3")) {
				// select region

				connectionRegion(connParam.getRegion());

				// Access Key

				accessKey(connParam.getAccess());

				// Secret Key

				secretKey(connParam.getSecret());
			} else if (connParam.getLocationname().equalsIgnoreCase("S3")
					&& (connParam.getAuthenticationname().equalsIgnoreCase("Custom Credential"))) {
				// to select session token
				sessionToken(connParam.getSessiontoken());

			}

			connectiontype(connParam.getTypeselect(), connParam.getAuthenticationname());
			// testConnection(connectionTestMess);
			saveConnection(connectionSaveMesssage);

			// change connection click
			changeconnection();

		} catch (Exception e) {

			e.getMessage();
		}

	}
	// to select connection type (SYSTEM)

	public void connectiontype(String typeselect, String authenticationname) {

		if ((!authenticationname.equalsIgnoreCase("No Authentication"))) {
			BaseSuite.validationReportLog("Clicking on connection type dropdown");
			isDisplayedInLoop(driver, 30, connectiontypeselect);
			javascript(driver, "arguments[0].scrollIntoView(true);", connectiontypeselect);
			displayAndClick(driver, connectiontypeselect);
			displayAndClick(driver, returnElement(connectiontypeselectoptions, "$name", typeselect));
			BaseSuite.validationReportLog("Selected connection type from dropdown successfully");
		}
	}

	// parameterize method for drop-down common method
	public void dropdownselection(By dropDownClick, String dropownList, String dropDownValue) {

		try {
			BaseSuite.validationReportLog("Clicking on the select dropdown");
			isDisplayedInLoop(driver, 30, dropDownClick);
			javascript(driver, "arguments[0].scrollIntoView(true);", dropDownClick);
			Actions actions = new Actions(driver);
			wait = waitMethod(driver);
			actions.moveToElement(driver.findElement(dropDownClick)).perform();
			actions.click(driver.findElement(dropDownClick)).build().perform();
			Thread.sleep(1000);
			displayAndClick(driver, returnElement(dropownList, "$name", dropDownValue));
			BaseSuite.validationReportLog("Selected value from dropdown successfully");
		} catch (InterruptedException e) {

			e.getMessage();
		}
	}

	// Account Name
	public void accname(String accountname) {
		try {
			BaseSuite.validationReportLog("Entering Account Name");
			clear_Click_SendKeys(driver, 3, connectionaccountname, accountname);
			BaseSuite.validationReportLog("Account Name entered successfully");
		} catch (Exception e) {
			e.getMessage();
		}

	}

	// Account Key
	public void acckey(String accountkey) {
		try {
			BaseSuite.validationReportLog("Entering Account Key");
			clear_Click_SendKeys(driver, 3, connectionaccountkey, accountkey);
			BaseSuite.validationReportLog("Account Key entered successfully");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// to add connection name
	public void connName(String name) {
		BaseSuite.reportLog("Clicking on connection name ");
		displayAndClick(driver, connectionname);
		sendKeys(driver, connectionname, name);
		BaseSuite.validationReportLog("Connection Name added successfully");
	}

	// to select File path
	public void filepath(String filepath) {
		BaseSuite.validationReportLog("Entering file path");
		clear_Click_SendKeys(driver, 3, connectionfilepath, filepath);
		BaseSuite.validationReportLog("File path entered successfully");
	}

	// to select session token
	public void sessionToken(String sessiontoken) {
		BaseSuite.validationReportLog("Entering Session Token");
		clear_Click_SendKeys(driver, 3, connectionsessiontoken, sessiontoken);
		BaseSuite.validationReportLog("Session Token entered successfully");
	}

	// change connection click
	public void changeconnection() {
		BaseSuite.validationReportLog("Click on change connection button");
		click(driver, connectionchangebtn);
		BaseSuite.validationReportLog("change connection button Clicked successfully");
	}

	// select region
	public void connectionRegion(String region) {
		BaseSuite.validationReportLog("Entering Region");
		clear_Click_SendKeys(driver, 3, connectionregion, region);
		BaseSuite.validationReportLog("Region entered successfully");
	}

	// Access Key
	public void accessKey(String access) {
		BaseSuite.validationReportLog("Entering access key");
		javascript(driver, "arguments[0].scrollIntoView(true);", connectionaccesskey);
		clear_Click_SendKeys(driver, 3, connectionaccesskey, access);
		BaseSuite.validationReportLog("access key entered successfully");
	}

	// Secret Key
	public void secretKey(String secret) {
		BaseSuite.validationReportLog("Entering secret key");
		javascript(driver, "arguments[0].scrollIntoView(true);", connectionsecretkey);
		clear_Click_SendKeys(driver, 3, connectionsecretkey, secret);
		BaseSuite.validationReportLog("secret key entered successfully");
	}

	///////////////////////////////////////////// Rahul's code through API for
	///////////////////////////////////////////// FlatFile
	///////////////////////////////////////////// Native/////////////////////////////////////////////////////
	// Method to click on FlatFile Native
	public void flatfilenativewithAPI(String jsonEntity, ConnectionPoJO connParam, String connName, SoftAssert soft,
			String connType, String typeselect) {
		try {

			NehaConnectionPage conn = new NehaConnectionPage(driver);

			ConnectionHome home = new ConnectionHome(driver);

			home.clickConnnectionsTab();

			connectionRepositoryLandingPage();

			verifyConnectionIsCreatedOrNot(connName);

			String name1 = null;

			if (isDisplayed(driver, returnElement(connectionsNameTex, "$name", connName))) {

				name1 = getText(driver, returnElement(connectionsNameTex, "$name", connName));
			}

			if (isDisplayed(driver, noRecondsFound) || !connName.equals(name1)) {

				home.clickOnNewConnectionBtn();

				connTabsButtonsClickableOrNotOnNewConnectionPage();

				conn.chooseConnectionType(connType, soft);

				BaseSuite.reportLog("Entering connection name in Name field");

				clear_SendKeys(driver, connectionName, connName);

				BaseSuite.reportLog("Connection name entered successfully in Name field");

				dropdownselection(connectionlocation, connectionlocationoptions, connParam.getLocationname());

				dropdownselection(connectionfiletype, connectionfileoptions, connParam.getFiletypename());

				dropdownselection(connectionauthentication, connectionauthenticationoptions,
						connParam.getAuthenticationname());

				filepath(connParam.getFilepath());

				if (connParam.getLocationname().equalsIgnoreCase("Azure Blob")
						&& (connParam.getAuthenticationname().equalsIgnoreCase("Access Key"))) {
					accname(connParam.getAccountname());

					acckey(connParam.getAzureAccesskey());

				} else if (connParam.getLocationname().equalsIgnoreCase("Azure Blob")
						&& (connParam.getAuthenticationname().equalsIgnoreCase("Shared Access Signature"))) {
					sessionToken(connParam.getSessiontoken());

				} else if (connParam.getLocationname().equalsIgnoreCase("S3")) {

					connectionRegion(connParam.getRegion());

					accessKey(connParam.getAccess());

					secretKey(connParam.getSecret());

				} else if (connParam.getLocationname().equalsIgnoreCase("S3")
						&& (connParam.getAuthenticationname().equalsIgnoreCase("Custom Credential"))) {
					sessionToken(connParam.getSessiontoken());

				}
				Thread.sleep(2000);

				connectiontype(connParam.getTypeselect(), connParam.getAuthenticationname());

				saveConnection(connectionSaveMesssage);

				Thread.sleep(3000);

				if (connParam.getTypeselect().equalsIgnoreCase("User")) {
					BaseSuite.reportLog("Connection type is USER hence Clicking on User Connection tab ..");

					Thread.sleep(3000);

					userConnectiontabclick();

					searchUserConnectionFunctionality(connName);

					validateuserconnectionproperties(jsonEntity, typeselect);
				}

				// changeconnection();
			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	// method to click on user connection tab
	public void userConnectiontabclick() {
		try {
			SoftAssert soft = new SoftAssert();
			isDisplayedInLoop(driver, 10, userconnectiontab1);

			if (isDisplayed(driver, userconnectiontab1)) {

				displayAndClick(driver, userconnectiontab1);

				BaseSuite.validationReportLog("Clicked on User Connection tab successfully");
				inVisible(driver, connectionPageSpinner, Constant.ruleWait);
				captureToastMsg(driver, toastMsg, ToastMsgClosedBtn, connFetchedMsg, "Connection Fetched");
			} else {
				BaseSuite.reportFailLog("User Connection tab not visible", "clickOnUserConnectionTab");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to search User connection name
	public void searchUserConnectionFunctionality(String connName) throws Exception {
		try {
			BaseSuite.reportLog("Searching for Connection:" + connName);
			isDisplayedInLoop(driver, 20, usersearchconnection);
			clear_Click_SendKeys(driver, 20, usersearchconnection, connName.trim());
			BaseSuite.validationReportLog("Connection name entered successfullly :" + connName);
			BaseSuite.reportLog("Clicking on search icon");
			isDisplayedInLoop(driver, 3, usersearchconnectionbtn);
			displayAndClick(driver, usersearchconnectionbtn);
			inVisible(driver, connectionPageSpinner, Constant.ruleWait);
			BaseSuite.validationReportLog("User Connection displayed in the list");
			String conname = driver.findElement(returnElement(userconnectionnameclick, "$name", connName)).getText();
			boolean flag = isDisplayed(driver, returnElement(userconnectionnameclick, "$name", connName));
			if (flag) {
				BaseSuite.validationReportLog("Connection displayed in the list");

				if (conname.equalsIgnoreCase(connName)) {
					BaseSuite.validationReportLog("Searched connection found in the list :" + connName);
					BaseSuite.validationReportLog("User Connection Search functionality working properly");
					displayAndClick(driver, returnElement(userconnectionnameclick, "$name", connName));
				} else {
					BaseSuite.reportFailLog("Searched connection not matched", "searchUserConnectionFunctionality");
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// to validate each field from user connection page
	public void validateuserconnectionproperties(String jsonentity, String typeselect) {
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(jsonentity);
			// validating workspace
			BaseSuite.validationReportLog("Checking Workspace is visible or Not");

			if (isDisplayed(driver, connectionwks)) {
				String wkscheck = getAttribute(driver, connectionwks, "value");

				if (wkscheck.equalsIgnoreCase(BaseSuite.WorkspaceName)) {
					BaseSuite.validationReportLog(wkscheck + " Workspace is visible");

				} else {
					BaseSuite.reportFailLog("Workspace visiblility Field failed to display", "connectionwks");

				}
			}
			// validating Connection Name
			BaseSuite.validationReportLog("Checking Connection Name is visible or Not");

			if (isDisplayed(driver, connectionname)) {
				String connName = getAttribute(driver, connectionname, "value").trim();

				if (connName.equalsIgnoreCase(connName)) {
					BaseSuite.validationReportLog(connectionname + " connection name is visible");

				} else {
					BaseSuite.reportFailLog("Connection Name Field failed to display", "connectionname");

				}
			}
			// validating Connection Id
			BaseSuite.validationReportLog("Checking Connection Id is visible or Not");

			boolean flag = isDisplayed(driver, userconnectionid);
			if (flag) {
				String connid = getAttribute(driver, userconnectionid, "value").trim();

				if (connid.equalsIgnoreCase(connParam.getConnectionid())) {
					BaseSuite.validationReportLog(userconnectionid + " connection Id is visible");

				} else {
					BaseSuite.reportFailLog("Connection Id failed to display", "userconnectionid");

				}
			}
			// validating Location
			BaseSuite.validationReportLog("Checking Location is visible or Not");

			if (isDisplayed(driver, userconnectionlocation)) {
				String userconnloction = getAttribute(driver, userconnectionlocation, "value").trim();

				if (userconnloction.equalsIgnoreCase(connParam.getLocationname())) {
					BaseSuite.validationReportLog(userconnectionlocation + " Location is visible");

				} else {
					BaseSuite.reportFailLog("Location failed to display", "userconnectionlocation");

				}
			}
			// validating File Type
			BaseSuite.validationReportLog("Checking File Type is visible or Not");

			if (isDisplayed(driver, userconnectionfiletype)) {
				String userconnfiletype = getAttribute(driver, userconnectionfiletype, "value").trim();

				if (userconnfiletype.equalsIgnoreCase(connParam.getFiletypename())) {
					BaseSuite.validationReportLog(userconnectionfiletype + " File Type is visible");

				} else {
					BaseSuite.reportFailLog("File Type failed to display", "userconnectionfiletype");

				}
			}
			// validating Authentication
			BaseSuite.validationReportLog("Checking Authentication is visible or Not");

			if (isDisplayed(driver, userconnectionauthentication)) {
				String userconnauthentication = getAttribute(driver, userconnectionauthentication, "value").trim();

				if (userconnauthentication.equalsIgnoreCase(connParam.getAuthenticationname())) {
					BaseSuite.validationReportLog(userconnectionauthentication + " Authentication is visible");

				} else {
					BaseSuite.reportFailLog("Authentication failed to display", "userconnectionauthentication");

				}
			}
			// validating File Path
			BaseSuite.validationReportLog("Checking File Path is visible or Not");

			if (isDisplayed(driver, connectionfilepath)) {
				String connfilepath = getAttribute(driver, connectionfilepath, "value").trim();

				if (connfilepath.equalsIgnoreCase(connParam.getFilepath())) {
					BaseSuite.validationReportLog(connectionfilepath + " File Path is visible");

				} else {
					BaseSuite.reportFailLog("File Path failed to display", "connectionfilepath");

				}
			}
			// validating Region
			BaseSuite.validationReportLog("Checking Region is visible or Not");

			if (isDisplayed(driver, connectionregion)) {
				String userconnregion = getAttribute(driver, connectionregion, "value").trim();

				if (userconnregion.equalsIgnoreCase(connParam.getRegion())) {
					BaseSuite.validationReportLog(connectionregion + " Region is visible");

				} else {
					BaseSuite.reportFailLog("Region failed to display", "connectionregion");

				}
			}
			// validating Type(SYSTEM/USER)
			BaseSuite.validationReportLog("Checking Type(SYSTEM/USER) is visible or Not");

			if (isDisplayed(driver, userconnectiontype)) {
				String usertype = getAttribute(driver, userconnectiontype, "value").trim();

				if (usertype.equalsIgnoreCase(connParam.getTypeselect())) {
					BaseSuite.validationReportLog(userconnectiontype + " Type(SYSTEM/USER) is visible");

				} else {
					BaseSuite.reportFailLog("Type(SYSTEM/USER) failed to display", "userconnectiontype");

				}
			}
			if (connParam.getLocationname().equalsIgnoreCase("Azure Blob")
					&& (connParam.getAuthenticationname().equalsIgnoreCase("Access Key"))) {

				XLUtils xlReader = new XLUtils();

				String accountname = xlReader.readUsingColName(
						System.getProperty("user.dir")
								+ "\\src\\main\\resources\\testdata\\ConnectionRepo\\Rahulconnection.xlsx",
						"sheet1", 0, "accountname");

				BaseSuite.reportLog("Entering Accountname in field");

				clear_SendKeys(driver, connectionaccountname, accountname);

				String accountkey = xlReader.readUsingColName(
						System.getProperty("user.dir")
								+ "\\src\\main\\resources\\testdata\\ConnectionRepo\\Rahulconnection.xlsx",
						"sheet1", 1, "accountkey");

				BaseSuite.reportLog("Entering AccountKey in field");

				clear_SendKeys(driver, connectionaccountkey, accountkey);

			} else if (connParam.getLocationname().equalsIgnoreCase("Azure Blob")
					&& (connParam.getAuthenticationname().equalsIgnoreCase("Shared Access Signature"))) {
				XLUtils xlReader = new XLUtils();

				String sessiontoken = xlReader.readUsingColName(
						System.getProperty("user.dir")
								+ "\\src\\main\\resources\\testdata\\ConnectionRepo\\Rahulconnection.xlsx",
						"sheet1", 4, "sessiontoken");

				BaseSuite.reportLog("Entering sessiontoken in field");

				clear_SendKeys(driver, connectionsessiontoken, sessiontoken);

			} else if (connParam.getLocationname().equalsIgnoreCase("S3")) {

				XLUtils xlReader = new XLUtils();

				String access = xlReader.readUsingColName(
						System.getProperty("user.dir")
								+ "\\src\\main\\resources\\testdata\\ConnectionRepo\\Rahulconnection.xlsx",
						"sheet1", 1, "access");

				BaseSuite.reportLog("Entering AccessKey in field");

				clear_SendKeys(driver, connectionaccesskey, access);

				String secret = xlReader.readUsingColName(
						System.getProperty("user.dir")
								+ "\\src\\main\\resources\\testdata\\ConnectionRepo\\Rahulconnection.xlsx",
						"sheet1", 3, "secret");

				BaseSuite.reportLog("Entering secretKey in field");

				clear_SendKeys(driver, connectionsecretkey, secret);

			} else if (connParam.getLocationname().equalsIgnoreCase("S3")
					&& (connParam.getAuthenticationname().equalsIgnoreCase("Custom Credential"))) {
				XLUtils xlReader = new XLUtils();

				String sessiontoken = xlReader.readUsingColName(
						System.getProperty("user.dir")
								+ "\\src\\main\\resources\\testdata\\ConnectionRepo\\Rahulconnection.xlsx",
						"sheet1", 4, "sessiontoken");

				BaseSuite.reportLog("Entering sessiontoken in field");

				clear_SendKeys(driver, connectionsessiontoken, sessiontoken);

			}
			saveConnection(connectionSaveMesssage);

		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void searchAndClickOnConnectionName(String connName) {

		try {

			BaseSuite.reportLog("Searching for Connection:" + connName);
			isDisplayedInLoop(driver, 20, usersearchconnection);
			clear_Click_SendKeys(driver, 20, usersearchconnection, connName.trim());
			BaseSuite.validationReportLog("Connection name entered successfullly :" + connName);
			BaseSuite.reportLog("Clicking on search icon");
			isDisplayedInLoop(driver, 5, usersearchconnectionbtn);
			displayAndClick(driver, usersearchconnectionbtn);
			inVisible(driver, connectionPageSpinner, Constant.ruleWait);
			BaseSuite.validationReportLog("Clicked on search icon successfully");

			if (!isDisplayed(driver, noRecondsFound)) {
				isDisplayedInLoop(driver, 3, returnElement(connNameLink, "$name", connName));
				if (isDisplayed(driver, returnElement(connNameLink, "$name", connName))) {

					BaseSuite.validationReportLog("Searched connection found in the list :" + connName);
					BaseSuite.reportLog("Clicking on connection name");
					displayAndClick(driver, returnElement(connNameLink, "$name", connName));
					BaseSuite.validationReportLog("Clicked on connection name successfully");
					inVisible(driver, connectionPageSpinner, Constant.ruleWait);
				} else {
					BaseSuite.reportFailLog("Searched connection not matched", "searchConnectionFunctionality");
				}
			} else {
				BaseSuite.validationReportLog("No connection found for searched value ");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void enterUserNameAndPassword(String userName, String password) {

		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", enterUsername);
			if (userName != null) {
				BaseSuite.reportLog("Entering username : " + userName);

				clear_Click_SendKeys(driver, 5, enterUsername, userName);

				BaseSuite.validationReportLog("Entered username successfully");
			} else {
				BaseSuite.reportFailLog("username value found as null", "enterUserNameAndPassword");
			}
			if (password != null) {
				BaseSuite.reportLog("Entering password : " + password);

				clear_Click_SendKeys(driver, 5, enterPassword, password);

				BaseSuite.validationReportLog("Entered password successfully");
			} else {
				BaseSuite.reportFailLog("password value found as null", "enterUserNameAndPassword");
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public String getConnectionDetailsUsingAuthType(String connector, String authType, int rowNumber) {

		XLUtils xl = new XLUtils();

		String value = null;

		try {

			String filePath = System.getProperty("user.dir") + connectionCredentialsFile;

			value = xl.readUsingColName(filePath, connector.trim(), rowNumber, authType.trim());

		} catch (Exception e) {
			e.getMessage();
		}

		return value;
	}

	// click on searched and choose connection type.

	public void chooseConnectionType(String connectionName, SoftAssert soft) {

		try {
			// Search desired connection type

			String connType = connectionName.trim().replace("-", " ");
			isDisplayedInLoop(driver, 2, chooseConnectionType_SearchTxt);
			BaseSuite.validationReportLog("Search textbox is displayed on choose connection type page.");
			clear_SendKeys(driver, chooseConnectionType_SearchTxt, connType);
			driver.findElement(chooseConnectionType_SearchTxt).sendKeys(Keys.ENTER);
			BaseSuite.reportLog("Enter button clicked successfully, verifying searched record.");
			BaseSuite.validationReportLog("Searched successfully " + connType + " connection type.");
			// Click on searched connection type
			isDisplayed(driver, returnElement(newConn_ClickConnTile, "$name", connType));
			displayAndClick(driver, returnElement(newConn_ClickConnTile, "$name", connType));
			BaseSuite.validationReportLog("Successfully clicked on connection " + connType + " button.");
			inVisible(driver, chooseConnectionType_Spinner, Constant.ruleWait);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	/** Vipul's Code start **/

	/**
	 * ---------------------------- Connection Repository New UI Code
	 * -------------------------------
	 **/

	/** Enter connection name method **/
	public void enterConnectionName(String connectionName) throws NoSuchElementException {

		try {
			isDisplayedInLoop(driver, 4, connName);

			javascript(driver, scrollToElementArg, connSaveBtn);

			verifyIndividualLabel(driver, connNameLabel, Constant.CONNECTIONNAME);

			if (isDisplayed(driver, connName)) {

				isClickable(driver, connName, Constant.CONNECTIONNAME + " field", true);

				if (isEditable(driver, connName, Constant.CONNECTIONNAME + " field")) {

					clear(driver, connName);

					String ph = getAttribute(driver, connName, placeHolderAttribute);

					if (!ph.isEmpty() && ph.equalsIgnoreCase(connectionNamePlaceHolder)) {

						BaseSuite.reportLog(Constant.CONNECTIONNAME + " field place holder : " + ph);

					} else {

						BaseSuite.reportFailLog(Constant.CONNECTIONNAME + " field place holder not found ",
								" enterConnectionName");

					}

					BaseSuite.reportLog("Entering value : " + connectionName);

					sendKeys(driver, connName, connectionName);

					String ac = getAttribute(driver, connName, valueAttribute);

					stringContainsOutput(ac, connectionName, true);

					validateConnectionNameField(true);

				} else {
					BaseSuite.reportFailLog(Constant.CONNECTIONNAME + " field not editable", "enterConnectionName");
				}
			} else {
				BaseSuite.reportFailLog(Constant.CONNECTIONNAME + " field not displayed", "enterConnectionName");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Exception found : " + e.getMessage());
			throw new NoSuchElementException();
		}
	}

	public String validateConnectionNameField(boolean state) {
		String valMsg = null;
		isDisplayedInLoop(driver, 2, connectionNameValidation);
		if (isDisplayed(driver, connectionNameValidation)) {
			if (state) {

				valMsg = getText(driver, connectionNameValidation);
				BaseSuite.reportFailLog("Proper connection name not entered : " + valMsg, "enterConnectionName1");
				throw new AssertionError();
			} else {
				valMsg = getText(driver, connectionNameValidation);
				BaseSuite.validationReportLog(
						"Proper Validation Message displayed for entered connection name , Message : " + valMsg);
			}
		}
		return valMsg;
	}

	/** Workspace method **/
	public void validateWorkspaceField(String workspaceName) {

		try {
			inVisible(driver, chooseConnectionType_Spinner, Constant.ruleWait);
			Thread.sleep(2000);
			isDisplayedInLoop(driver, 5, connWorkspaceLabel);

			javascript(driver, scrollToElementArg, connWorkspaceLabel);

			verifyIndividualLabel(driver, connWorkspaceLabel, "Workspace");

			if (isDisplayed(driver, connWorkspaceField)) {

				BaseSuite.validationReportLog("Workspace field is visible");

				BaseSuite.reportLog("checking workspace field disabled or not");

				if (!isEnabled(driver, connWorkspaceField)) {

					BaseSuite.validationReportLog("Workspace field is disabled");

					BaseSuite.reportLog("checking correct workspace name visible or not ");

					String wksc = getAttribute(driver, connWorkspaceField, valueAttribute);

					BaseSuite.reportLog("Retrived workspace name : " + wksc);

					BaseSuite.reportLog("Expected workspace name : " + workspaceName);

					if (wksc.equals(workspaceName)) {

						BaseSuite.validationReportLog("Expected workspace name is visible and matched "
								+ ConstantProperty.SUCCESSSTRING + " ");

					} else {
						BaseSuite.reportFailLog("Workspace name not matched with expected ", "validateWorkspaceField");
					}
				} else {
					BaseSuite.reportFailLog("Workspace field is enabled, expected should be disabled",
							"validateWorkspaceField");
				}

			} else {
				BaseSuite.reportFailLog("Workspace field not displayed, kindly check", "validateWorkspaceField ");
			}
		} catch (Exception e) {
			e.getMessage();
			Thread.currentThread().interrupt();
			throw new NoSuchElementException();
		}
	}

	/** Driver Type method **/

	public String setDriverType(String jsondriverType) {

		String driverName = null;

		if (!jsondriverType.isEmpty()) {
			switch (jsondriverType.toLowerCase()) {

			case "sqlserver-custom":
				driverName = "SQL Server Custom JDBC";
				break;
			case "sqlserver-native":
				driverName = "SQL Server Native JDBC";
				break;

			default:

			}
		}
		return driverName;
	}

	/** Authentication method **/

	public String setAuthenticationType(String jsonauthType) throws SQLException {
		String authName = null;

		if (!jsonauthType.isEmpty()) {

			switch (jsonauthType.toLowerCase()) {

			case "kerberos":
				authName = "Kerberos";
				break;
			case "azure-key-vault":
				authName = "Key Pair(Azure Key Vault)";
				break;
			case "key-pair":
				authName = "Key Pair";
				break;

			case "none":
				authName = "Local";
				break;
			case "aws-iam-flat-file":
				authName = "AWS IAM";
				break;
			case "azure-access-key":
				authName = "Azure Access Key";
				break;
			case "azure-access-key-flat-file":
				authName = "Azure Access Key";
				break;
			case "password":

				authName = "SQL Server Authentication";

				break;

			case "password-sqlserver":

				authName = "SQL Server Authentication";

				break;

			case "windows-ntlm":
				authName = "Windows Authentication";
				break;
			default:

			}
		}
		return authName;

	}

	/** Select Authentication method **/
	public void selectAuthenticationOfConnection(String authenticationType) {

		try {
			isDisplayedInLoop(driver, 2, connAuthTypeLabel);

			javascript(driver, scrollToElementArg, connAuthTypeLabel);

			verifyIndividualLabel(driver, connAuthTypeLabel, "Authentication");

			if (isDisplayed(driver, connAuthTypeField)) {

				BaseSuite.validationReportLog("Authentication field is visible ");

				String authValue = getAttribute(driver, connAuthTypeField, valueAttribute);

				BaseSuite.reportLog("Default authentication type selected as : " + authValue);

				BaseSuite.validationReportLog("Authentication field drop down arrow is visible");

				displayAndClick(driver, connAuthTypeSearchIcon);

				BaseSuite.validationReportLog(
						"Clicked on authentication drop down " + ConstantProperty.SUCCESSSTRING + "");

				BaseSuite.reportLog("Checking list of authentication type visible");
				Thread.sleep(2000);
				List<WebElement> authList = getElements(driver, connAuthTypeList);

				for (int i = 0; i < authList.size(); i++) {

					String authName = authList.get(i).getAttribute("textContent");

					BaseSuite.reportLog((i + 1) + ". " + authName + " is visible");

				}

				// authenticationType = setAuthenticationType(authenticationType);

				BaseSuite.reportLog("Selecting expected authentication type : " + authenticationType);

				if (isDisplayed(driver, returnElement(connAuthTypeSelect1, dynamicName, authenticationType))) {

					BaseSuite.reportLog(authenticationType + " is visible");

					BaseSuite.reportLog("Clicking on auth type ...");

					displayAndClick(driver, returnElement(connAuthTypeSelect1, dynamicName, authenticationType));

					String acauth = getAttribute(driver, connAuthTypeField, valueAttribute);

					if (!acauth.isEmpty() && acauth.equalsIgnoreCase(authenticationType)) {

						BaseSuite.validationReportLog(
								"Expected authentication type is selected " + ConstantProperty.SUCCESSSTRING + "");

					} else {
						BaseSuite.reportFailLog("Expected authentication type is not selected, kindly check ",
								"selectAuthenticationOfConnection");
					}

				} else {
					BaseSuite.reportFailLog("Authentication type not visible " + authenticationType,
							"selectAuthenticationOfConnection");
				}

			} else {
				BaseSuite.reportFailLog("Authentication field not visible ", " selectAuthenticationOfConnection");
			}
		} catch (Exception e) {
			e.getMessage();
			throw new NoSuchElementException();
		}
	}

	/** Enable custom JDBC URL check box method **/

	public boolean selectCustomJDBCURLOfConnection(String state) {
		String str = "check";
		boolean flag = false;
		try {
			isDisplayedInLoop(driver, 5, connCustomJDBCLabel);

			javascript(driver, scrollToElementArg, connCustomJDBCLabel);

			if (isDisplayed(driver, connCustomJDBCLabel)) {

				BaseSuite.reportLog("verifying custom JDBC URL checkbox");

				if (isDisplayed(driver, connCustomJDBCCheckbox)) {

					BaseSuite.validationReportLog("Custom JDBC URL checkbox is visible");

					String actualState = getAttribute(driver, connCustomJDBCCheckbox, "class");

					if (actualState.contains(str)) {

						BaseSuite.reportLog("Default condition of Custom JDBC URL checkbox is checked");
					} else {
						BaseSuite.reportLog("Default condition of Custom JDBC URL checkbox is unchecked");
					}

					if (Boolean.parseBoolean(state) && !actualState.contains(str)) {

						BaseSuite.reportLog("Clicking on custom JDBC URL checkbox");

						displayAndClick(driver, connCustomJDBCCheckbox);

						actualState = getAttribute(driver, connCustomJDBCCheckbox, "class");

						stringContainsOutput(actualState, str, true);
						flag = true;
					} else if (state.equalsIgnoreCase("false") && actualState.contains(str)) {

						BaseSuite.reportLog("Clicking on custom JDBC URL checkbox");

						displayAndClick(driver, connCustomJDBCCheckbox);

						actualState = getAttribute(driver, connCustomJDBCCheckbox, "class");

						// stringContainsOutput(actualState, str, true);
						flag = true;
					}

				} else {
					BaseSuite.reportFailLog("Custom JDBC URL checkbox not visible ", "selectCustomJDBCURLOfConnection");
				}
			} else {
				BaseSuite.reportFailLog("Custom JDBC URL field not visible ", "selectCustomJDBCURLOfConnection");
			}
		} catch (Exception e) {
			e.getMessage();
			throw new NoSuchElementException();
		}
		return flag;
	}

	/** JDBC URL field box method **/

	public void enterCustomJDBCURL(String customJDBCURLCheckboxStatus, String customJDBCURL) {

		try {
			if (customJDBCURLCheckboxStatus.equalsIgnoreCase(booleanTrue)) {
				isDisplayedInLoop(driver, 4, connCustomJDBCTextbox);

				javascript(driver, scrollToElementArg, connCustomJDBCTextbox);

				if (isDisplayed(driver, connCustomJDBCTextbox)) {

					BaseSuite.validationReportLog("Custom JDBC URL field textbox is visible");

					if (isEditable(driver, connCustomJDBCTextbox, "Custom JDBC URL textbox")) {

						BaseSuite.reportLog("Entering custom JDBC URL : " + customJDBCURL);

						clear_Click_SendKeys(driver, 0, connCustomJDBCTextbox, customJDBCURL);

						String acstr = getAttribute(driver, connCustomJDBCTextbox, valueAttribute);

						BaseSuite.reportLog("Expected custom JDBC URL : " + customJDBCURL);

						if (acstr.equals(customJDBCURL)) {

							BaseSuite.validationReportLog(
									"Custom JDBC URL entered " + ConstantProperty.SUCCESSSTRING + "");
						} else {
							BaseSuite.reportFailLog("Custom JDBC URL entered not matched with expected",
									"enterCustomJDBCURL");
						}

					} else {
						BaseSuite.reportFailLog("Custom JDBC URL textbox not editable", "enterCustomJDBCURL ");
					}

				} else {
					BaseSuite.reportFailLog("Custom JDBC URL textbox not visible", "enterCustomJDBCURL ");
				}
			}
		} catch (Exception e) {
			e.getMessage();
			throw new NoSuchElementException();
		}

	}

	/** Connection repository breadcrumbs link **/

	public void clickOnConnectionRepoBreadcrumbLink() {
		SoftAssert soft = new SoftAssert();
		boolean flag = false;
		LoginPage lp = new LoginPage(driver);
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {
			cp.clickOnConnectionsTab();
			isDisplayedInLoop(driver, 0, discardButtons);
			if (isDisplayed(driver, discardButtons)) {
				clickOnButton(driver, discardButtons, "Discard popup", true);
			}

			isDisplayedInLoop(driver, 4, mainHeadingTitle);
			String str = getText(driver, mainHeadingTitle);

			soft.assertEquals(str, "Connections");
			BaseSuite.reportLog("Expected Title : Connections");
			BaseSuite.reportLog("Actual Title : " + str);
			Thread.sleep(1000);
			if (str.equalsIgnoreCase("Connections")) {
				BaseSuite.validationReportLog(
						"Expected Title and Actual Title matched  " + ConstantProperty.SUCCESSSTRING + "");
			} else {
				BaseSuite.reportFailLog("Expected Title and Actual Title not matched ", "clickOnConnectionsTab");
				isDisplayedInLoop(driver, 0, discardButtons);
				if (isDisplayed(driver, discardButtons)) {
					clickOnButton(driver, discardButtons, " Discard ", true);
				}
				flag = true;
				throw new AssertionError();
			}

		} catch (Exception e) {
			e.getMessage();
			flag = true;
			throw new AssertionError();
		} finally {

			isDisplayedInLoop(driver, 0, discardButtons);
			if (isDisplayed(driver, discardButtons)) {

				displayAndClick(driver, discardButtons);

			}

			if (flag && BaseSuite.RunFailedTestCases) {

				if (isDisplayed(driver, connectionPageSpinner)) {
					driver.navigate().refresh();
					cp.clickOnConnectionsTab();
				}

				lp.logOut();

			}
		}
	}

	/** Get connection id from connection name using API method **/

	public String getConnectionIDFromConnectionName(String connectionName, String workspaceId, String userRole)
			throws RestClientException, NullPointerException {

		String connID = null;

		try {
			String auto = TestDataThroughApi.getOAuthBearerTokenBasedOnIcedqRole(userRole);

			RequestBody body;

			OkHttpClient client = new OkHttpClient().newBuilder().build();

			MediaType mediaType = MediaType.parse("application/json");

			body = RequestBody.create(mediaType,
					"{\r\n" + "    \"search\": [\r\n" + "        {\r\n" + "            \"attribute\": \"name\",\r\n"
							+ "            \"operator\": \"StartsWith\",\r\n" + "            \"value\": \""
							+ connectionName + "\"\r\n" + "        }\r\n" + "    ]\r\n" + "}");

			Request request = new Request.Builder()

					.url(readconfig.connectionListApiUrl()).method("POST", body)

					.addHeader("content-type", "application/json")

					.addHeader("workspace-id", workspaceId)

					.addHeader("org-id", "org-iam.icedq")

					.addHeader("Authorization", "Bearer " + auto)

					.build();

			Response response = client.newCall(request).execute();

			String jsonBody = response.body().string();

			connID = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonBody,
					ConstantProperty.CONNECTIONID_JSONPATH);

			if (connID.isEmpty()) {
				BaseSuite.reportFailLog(
						"Search Connection API not returning rule id kindly check :: Responce :: " + jsonBody,
						"_getConnectionIDFromConnectionName");
			}
		} catch (IOException e) {
			e.getMessage();
			BaseSuite.reportFailLog("Search Connection API not returning rule id kindly check exception",
					"getConnectionIDFromConnectionName");
		} catch (NullPointerException e) {
			e.getMessage();
			BaseSuite.reportFailLog("Search Connection API not returning rule id kindly check exception" + e.toString(),
					"getConnectionIDFromConnectionName");
		}

		return connID;

	}

	/**
	 * Create snowflake connection method
	 * 
	 * @throws Exception
	 **/

	public boolean createSnowflakeConnectionMethod(String connJsonEntity, SoftAssert soft, String icedqUser)
			throws InterruptedException {
		boolean flag = true;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		// VipulConnectionRepo cv = new VipulConnectionRepo(driver);

		String newconnectionName = null;
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			// String timestamp = new
			// SimpleDateFormat(ConstantProperty.CONNECTIONNAME_TIMESTAMPFORMAT).format(new
			// Date());

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME;

			String connusername = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

			String connpassword = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 2);

			String usernamekeypair = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 9);

			String keyFileContentdata = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 10);

			String keyFilePassworddata = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 11);

			String keyVaultNamedata = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 12);

			String clientIddata = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 13);

			String tenantIddata = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 14);

			String clientSecretdata = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 15);

			String privateKeySecretNamedata = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 16);

			String privateKeyPasswordSecretNamedata = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 17);

			// cp.connectionRepositoryLandingPage();

			flag = clickOnNewConnectionBtn(icedqUser);

			if (flag) {

				chooseConnectorType(connParam.getConnectorID());
				
				inVisible(driver, spinner, Constant.ruleWait);
				
				String wizardStatus = cp.validateNewConnPageButtonsFields(connParam.getConnectorID());
				
				if (wizardStatus.contains("Wizard supported connector")) {
					
					verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", false);
				}
				
				verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

				verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);

				verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

				verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", false);

				verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", false);

				// validateWorkspaceField(BaseSuite.WorkspaceName);

				enterConnectionName(newconnectionName);
				
				selectDriverOfFlatFileNativeConnection(connParam.getDriverName());
				
				//selectAuthenticationOfConnection(connParam.getAuthentication());
				
				String authName = cp.setAuthenticationType(connParam.getAuthentication());

				selectAuthenticationOfConnection(authName);

				boolean cs = selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

				enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());
				if (cs) {

					cp.validateInputFieldVisibility(accountIdentifierInput, "Account Identifire",
							connAccountIdentifirePlaceHolder, false);
					cp.validateInputFieldVisibility(connWarehouseInput, "Warehouse", connWarehousePlaceHolder, false);
					cp.validateInputFieldVisibility(connDatabaseInput, "Database", connDatabasePlaceHolder, false);

				} else {

					enterAccountIdentifier(connParam.getAccountIdentifire());

					enterWarehouse(connParam.getWarehouse());

					enterDatabase(connParam.getDatabaseName());

				}
				selectConnectionType(connParam.getType());

				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					if (connParam.getAuthentication().equalsIgnoreCase("password")) {

						enterUsername(connusername);

						cp.entersecretPassword(connJsonEntity, connParam.getAuthentication(),
								connParam.getConnectorID(), icedqUser);
					} else if (connParam.getAuthentication().equalsIgnoreCase("key-pair")) {

						enterUsername(usernamekeypair);

						cp.entersecretPassword(connJsonEntity, connParam.getAuthentication(),
								connParam.getConnectorID(), icedqUser);
					} else if (connParam.getAuthentication().equalsIgnoreCase("azure-key-vault")) {

						enterUsername(usernamekeypair);

						enterkeyVaultName(keyVaultNamedata);

						enterClientId(clientIddata);

						enterTenantId(tenantIddata);

						cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
								connParam.getConnectorID(), icedqUser);
					}
				}
			} else {
				validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", false);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				waitForExecution(1000);

				verifyVisibilityOfButtons(driver, connsecretManagebtn, "Manage Button", false);

				verifyVisibilityOfButtons(driver, connsecretQuickAddbtn, "Quick Add Button", false);

				verifyVisibilityOfButtons(driver, connsecretRefreshbtn, "Refresh Button", false);

				validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "", false);

				if (connParam.getAuthentication().equalsIgnoreCase("password")) {

					validateInputFieldVisibility(connsecretPasswordfeild, ConstantProperty.CONN_FIELD_PASSWORD, "",
							false);
				}
				if (connParam.getAuthentication().equalsIgnoreCase("key-pair")) {

					validateInputFieldVisibility(connKeyfileContentPasswordfeild, "Key File Content",
							KeyFileContentKeyPairPlaceholder, true);

					validateInputFieldVisibility(connKeyfilePasswordfeild, "Key File Password",
							KeyFilePasswordKeyPairPlaceholder, true);
				} else {
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					validateInputFieldVisibility(keyVaultName, "key Vault Name", keyVaultNamePlaceholder, false);

					validateInputFieldVisibility(clientId, "client Id", clientIdPlaceholder, false);

					validateInputFieldVisibility(tenantId, "tenant Id", tenantIdPlaceholder, false);

					validateInputFieldVisibility(clientSecret, "client Secret", clientSecretPlaceholder, false);

					validateInputFieldVisibility(privateKeySecretName, "private Key Secret Name",
							privateKeySecretNamePlaceholder, false);

					validateInputFieldVisibility(privateKeyPasswordSecretName, "private Key Password Secret Name",
							privateKeyPasswordSecretNamePlaceholder, false);
				}
			}

			ArrayList<String> connPropertyList = TestDataThroughApi
					.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, "$.connectionProperties..name");

			int count = connPropertyList.size();

			cp.addConnectionPropertiesToConnection(connJsonEntity, count);

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			flag = cp.saveConnection(connectionSaveMesssage);

			clickOnConnectionsTab();

			cp.searchConnection(newconnectionName);

			cp.getConnection(newconnectionName, update_actualValue);

			cp.searchAndClickOnConnectionNameInConnRepo(newconnectionName);

			if (flag || (isEnabled(driver, connDuplicateButton)&& isEnabled(driver, connDeleteButton))) {
				if (connParam.getType().trim().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

					clickOnUserConnectionTab();

					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}

					searchAndClickOnConnectionNameInConnRepo(newconnectionName);

					Thread.sleep(5000);

					if (connParam.getAuthentication().contains("password")) {

						enterUsername(connusername);

						cp.entersecretPassword(connJsonEntity, connParam.getAuthentication(),
								connParam.getConnectorID(), icedqUser);

					} else if (connParam.getAuthentication().contains("key-pair")) {

						enterUsername(usernamekeypair);

						cp.entersecretPassword(connJsonEntity, connParam.getAuthentication(),
								connParam.getConnectorID(), icedqUser);
					} else {
						enterUsername(usernamekeypair);

						enterkeyVaultName(keyVaultNamedata);

						enterClientId(clientIddata);

						enterTenantId(tenantIddata);

						enterClientSecret(clientSecretdata);

						enterPrivateKeySecretName(privateKeySecretNamedata);

						enterPrivateKeyPasswordSecretName(privateKeyPasswordSecretNamedata);

					}

					cp.saveConnection();

					clickOnUserConnectionTab();

					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}

					cp.searchConnection(newconnectionName);

					cp.getConnection(newconnectionName, update_actualValue);

					cp.searchAndClickOnConnectionNameInConnRepo(newconnectionName);

					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					testConnection(connectionTestMess);

					cp.clickOnUserConnectionTab();

					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}

					cp.searchConnection(newconnectionName);

					cp.getConnection(newconnectionName, create_actualValue);

					cp.searchAndClickOnConnectionNameInConnRepo(newconnectionName);

				} else {
					testConnection(connectionTestMess);

					cp.clickOnConnectionsTab();

					cp.searchConnection(newconnectionName);

					cp.getConnection(newconnectionName, create_actualValue);

					cp.searchAndClickOnConnectionNameInConnRepo(newconnectionName);
				}

			} else {
				BaseSuite.reportFailLog("Connection not created properly kindly check ",
						"createSnowflakeConnectionMethod");
			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog("Connection not created properly due to exception kindly check " + e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;

	}

	public boolean viewSnowflakeConnectionMethod(String connJsonEntity, String icedqUser) throws InterruptedException {

		boolean flag = false;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		// String newconnectionName = null;
		try {

			inVisible(driver, spinner, Constant.ruleWait);

			Thread.sleep(1000);

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {
				viewAndValidateConnectionField(connName, "Connection Name", connParam.getConnName(), true);
				
				String authName = cp.setAuthenticationType(connParam.getAuthentication());

				viewAndValidateConnectionField(connAuthTypeField, "Connection Authentication",
						authName, true);

				verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

				if (connParam.getCustomJdbcFullUrl().equalsIgnoreCase("true")) {

					viewAndValidateConnectionField(connCustomJDBCTextbox, "Connection JDBC URL",
							connParam.getCustomJDBCURLValue(), true);

					validateInputFieldVisibility(accountIdentifierInput, "Account Identifire",
							connAccountIdentifirePlaceHolder, false);

					validateInputFieldVisibility(connWarehouseInput, "Warehouse", connWarehousePlaceHolder, false);

					validateInputFieldVisibility(connDatabaseInput, "Database", connDatabasePlaceHolder, false);

				} else {

					viewAndValidateConnectionField(connCustomJDBCTextbox, "Connection JDBC URL",
							connParam.getCustomJDBCURLValue(), false);

					validateInputFieldVisibility(accountIdentifierInput, "Account Identifire",
							connAccountIdentifirePlaceHolder, true);

					validateInputFieldVisibility(connWarehouseInput, "Warehouse", connWarehousePlaceHolder, true);

					validateInputFieldVisibility(connDatabaseInput, "Database", connDatabasePlaceHolder, true);
				}

				validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", true);

				javascript(driver, scrollToElementArg, connUsernameInput);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				waitForExecution(1000);

				verifyVisibilityOfButtons(driver, connsecretManagebtn, "Manage Button", true);

				verifyVisibilityOfButtons(driver, connsecretQuickAddbtn, "Quick Add Button", true);

				verifyVisibilityOfButtons(driver, connsecretRefreshbtn, "Refresh Button", true);

				validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "", true);

				if (connParam.getAuthentication().equalsIgnoreCase("password")) {

					validateInputFieldVisibility(connsecretPasswordfeild, "Password", connPasswordPlaceholder, true);
				} else if (connParam.getAuthentication().equalsIgnoreCase("key-pair")) {

					validateInputFieldVisibility(connKeyfileContentPasswordfeild, "Key File Content",
							KeyFileContentKeyPairPlaceholder, true);

					validateInputFieldVisibility(connKeyfilePasswordfeild, "Key File Password",
							KeyFilePasswordKeyPairPlaceholder, true);
				} else if (connParam.getAuthentication().equalsIgnoreCase("azure-key-vault")) {

					validateInputFieldVisibility(keyVaultName, "key Vault Name", keyVaultNamePlaceholder, true);

					validateInputFieldVisibility(clientId, "client Id", clientIdPlaceholder, true);

					validateInputFieldVisibility(tenantId, "tenant Id", tenantIdPlaceholder, true);

					validateInputFieldVisibility(clientSecret, "client Secret", clientSecretPlaceholder, true);

					validateInputFieldVisibility(privateKeySecretName, "private Key Secret Name",
							privateKeySecretNamePlaceholder, true);

					validateInputFieldVisibility(privateKeyPasswordSecretName, "private Key Password Secret Name",
							privateKeyPasswordSecretNamePlaceholder, true);
				}
				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, "$.connectionProperties..name");

				int count = connPropertyList.size();

				flag = viewAndValidateConnectionPropertiesToConnection(connJsonEntity, count);

			} else {

				inVisible(driver, spinner, Constant.ruleWait);

				viewAndValidateConnectionField(connName, "Connection Name", connParam.getConnName(), false);
				
				String authName = cp.setAuthenticationType(connParam.getAuthentication());
				
				viewAndValidateConnectionField(connAuthTypeField, "Connection Authentication",
						authName, false);

				verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

				viewAndValidateConnectionField(connCustomJDBCTextbox, "Connection JDBC URL",
						connParam.getCustomJDBCURLValue(), false);

				validateInputFieldVisibility(accountIdentifierInput, "Account Identifire",
						connAccountIdentifirePlaceHolder, false);

				validateInputFieldVisibility(connWarehouseInput, "Warehouse", connWarehousePlaceHolder, false);

				validateInputFieldVisibility(connDatabaseInput, "Database", connDatabasePlaceHolder, false);

				validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", true);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				waitForExecution(1000);

				// verifyVisibilityOfButtons(driver, connsecretManagebtn, "Manage Button",
				// true);

				verifyVisibilityOfButtons(driver, connsecretQuickAddbtn, "Quick Add Button", true);

				verifyVisibilityOfButtons(driver, connsecretRefreshbtn, "Refresh Button", true);

				validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "", true);

				if (connParam.getAuthentication().equalsIgnoreCase("password")) {

					validateInputFieldVisibility(connsecretPasswordfeild, "Password", connPasswordPlaceholder, true);
				} else if (connParam.getAuthentication().equalsIgnoreCase("key-pair")) {

					validateInputFieldVisibility(connKeyfileContentPasswordfeild, "Key File Content",
							KeyFileContentKeyPairPlaceholder, true);

					validateInputFieldVisibility(connKeyfilePasswordfeild, "Key File Password",
							KeyFilePasswordKeyPairPlaceholder, true);
				} else if (connParam.getAuthentication().equalsIgnoreCase("azure-key-vault")) {
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					validateInputFieldVisibility(keyVaultName, "key Vault Name", keyVaultNamePlaceholder, true);

					validateInputFieldVisibility(clientId, "client Id", clientIdPlaceholder, true);

					validateInputFieldVisibility(tenantId, "tenant Id", tenantIdPlaceholder, true);

					validateInputFieldVisibility(clientSecret, "client Secret", clientSecretPlaceholder, true);

					validateInputFieldVisibility(privateKeySecretName, "private Key Secret Name",
							privateKeySecretNamePlaceholder, true);

					validateInputFieldVisibility(privateKeyPasswordSecretName, "private Key Password Secret Name",
							privateKeyPasswordSecretNamePlaceholder, true);
				}

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, "$.connectionProperties..name");

				int count = connPropertyList.size();

				flag = viewAndValidateConnectionPropertiesToConnection(connJsonEntity, count);
			}

		} catch (Exception e) {

			BaseSuite.reportErrorLog("Connection not created properly due to exception kindly check " + e.toString());
			Thread.currentThread().interrupt();
		}

		return flag;
	}

	@SuppressWarnings("static-access")
	public boolean newUpdatedSnowflakeConnectionMethod(String connJsonEntity, SoftAssert soft, String icedqUser)
			throws InterruptedException {
		boolean flag = true;

		ConnectionRepoCommonPage cc = new ConnectionRepoCommonPage(driver);

		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			String connusername = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

			String usernamekeypair = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 9);

			String keyVaultNamedata = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 12);

			String clientIddata = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 13);

			String tenantIddata = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 14);

			String clientSecretdata = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 15);

			String privateKeySecretNamedata = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 16);

			String updatedConnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

			} else {

				Thread.sleep(1000);
				String connName;
				waitForExecution(3000);
				clickOnConnectionsTab();
				isDisplayedInLoop(driver, 0, discardButtons);
				if (isDisplayed(driver, discardButtons)) {
					displayAndClick(driver, discardButtons);
				}
				if ((!icedqUser.contains("owner"))) {
					connName = updatedConnectionName;
				} else {
					connName = connParam.getConnName() + "_" + BaseSuite.WorkspaceName;
				}
				searchAndClickOnConnectionNameInConnRepo(connName);

			}

			updateConnectionName(updatedConnectionName);

			Thread.sleep(1000);

			String authName = cc.setAuthenticationType(connParam.getAuthentication());

			selectAuthenticationOfConnection(authName);

			verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

			selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

			enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());

			if (connParam.getCustomJdbcFullUrl().equalsIgnoreCase(booleanTrue)) {

				cc.validateInputFieldVisibility(accountIdentifierInput, "Account Identifire",
						connAccountIdentifirePlaceHolder, false);
				cc.validateInputFieldVisibility(connWarehouseInput, "Warehouse", connWarehousePlaceHolder, false);
				cc.validateInputFieldVisibility(connDatabaseInput, "Database", connDatabasePlaceHolder, false);

			} else {

				enterAccountIdentifier(connParam.getAccountIdentifire());

				enterWarehouse(connParam.getWarehouse());

				enterDatabase(connParam.getDatabaseName());

			}
			selectConnectionType(connParam.getType());

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				if (connParam.getAuthentication().equalsIgnoreCase("password")) {

					enterUsername(connusername);

					cc.entersecretPassword(connJsonEntity, connParam.getAuthentication(),
							connParam.getConnectorID(), icedqUser);
				} else if (connParam.getAuthentication().equalsIgnoreCase("key-pair")) {

					enterUsername(usernamekeypair);

					cc.entersecretPassword(connJsonEntity, connParam.getAuthentication(),
							connParam.getConnectorID(), icedqUser);
				} else if (connParam.getAuthentication().equalsIgnoreCase("azure-key-vault")) {

					enterUsername(usernamekeypair);

					enterkeyVaultName(keyVaultNamedata);

					enterClientId(clientIddata);

					enterTenantId(tenantIddata);

					cc.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
							connParam.getConnectorID(), icedqUser);
				}
			}

			else {
				validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", false);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				waitForExecution(1000);

				verifyVisibilityOfButtons(driver, connsecretManagebtn, "Manage Button", false);

				verifyVisibilityOfButtons(driver, connsecretQuickAddbtn, "Quick Add Button", false);

				verifyVisibilityOfButtons(driver, connsecretRefreshbtn, "Refresh Button", false);

				validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "", false);

				if (connParam.getAuthentication().equalsIgnoreCase("password")) {

					validateInputFieldVisibility(connPasswordInput, "Password", connPasswordPlaceholder, false);
				} else if (connParam.getAuthentication().equalsIgnoreCase("key-pair")) {

					validateInputFieldVisibility(connKeyfileContentPasswordfeild, "Key File Content",
							KeyFileContentKeyPairPlaceholder, false);

					validateInputFieldVisibility(connKeyfilePasswordfeild, "Key File Password",
							KeyFilePasswordKeyPairPlaceholder, false);
				} else {
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					validateInputFieldVisibility(keyVaultName, "key Vault Name", keyVaultNamePlaceholder, false);

					validateInputFieldVisibility(clientId, "client Id", clientIdPlaceholder, false);

					validateInputFieldVisibility(tenantId, "tenant Id", tenantIdPlaceholder, false);

					validateInputFieldVisibility(clientSecret, "client Secret", clientSecretPlaceholder, false);

					validateInputFieldVisibility(privateKeySecretName, "private Key Secret Name",
							privateKeySecretNamePlaceholder, false);

					validateInputFieldVisibility(privateKeyPasswordSecretName, "private Key Password Secret Name",
							privateKeyPasswordSecretNamePlaceholder, false);
				}
			}

			ArrayList<String> connPropertyList = TestDataThroughApi
					.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

			int count = connPropertyList.size();

			if ((connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE))) {

				cc.updateConnectionPropertiesToConnection(connJsonEntity, count);

			} else {

				saveConnection();

				cc.updateUserConnectionPropertiesToConnection(connJsonEntity, count,
						ConstantProperty.ICEDQ_WORKSPACE_OWNERUSER);

				if (connParam.getAuthentication().contains("password")) {

					enterUsername(connusername);

					cc.entersecretPassword(connJsonEntity, connParam.getAuthentication(),
							connParam.getConnectorID(), icedqUser);

				} else if (connParam.getAuthentication().contains("key-pair")) {

					enterUsername(usernamekeypair);

					cc.entersecretPassword(connJsonEntity, connParam.getAuthentication(),
							connParam.getConnectorID(), icedqUser);

					// enterKeyFilePassword(keyFilePassworddata);
				} else if (connParam.getAuthentication().contains("azure-key-vault")) {
					enterUsername(usernamekeypair);

					enterkeyVaultName(keyVaultNamedata);

					enterClientId(clientIddata);

					enterTenantId(tenantIddata);

					enterClientSecret(clientSecretdata);

					enterPrivateKeySecretName(privateKeySecretNamedata);

					cc.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
							connParam.getConnectorID(), icedqUser);

				}
			}

			if (icedqUser.contains("owner")) {

				cc.saveConnection();

				inVisible(driver, spinner, Constant.ruleWait);

				cc.waitForExecution(2000);

				cc.testConnection(connectionTestMess);

			} else {
				
				if (!icedqUser.contains("reader")) {

					cc.saveConnection();

					inVisible(driver, spinner, Constant.ruleWait);

					cc.waitForExecution(2000);

					cc.testConnection(connectionTestMess);

				} else {
					
					flag = cc.saveConnection(updateAndSaveClickErrorMessage);
				}
				
			}
		} catch (Exception e) {
			flag = false;
			BaseSuite.reportFailLog("Connection not created properly due to exception kindly check ",
					"newUpdatedSnowflakeConnectionMethod");
			Thread.currentThread().interrupt();
		}
		return flag;

	}

	/** Test Snowflake connection common method **/

	public boolean testSnowflakeConnection(String connJsonEntity, String driverName, String icedqUser) {
		boolean flag = false;
		NewConnectionRepoPage np = new NewConnectionRepoPage(driver);
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		RahulConnectionPage rp = new RahulConnectionPage(driver);
		try {
			ConnectionPoJO connParam = np.setConnectionParametersForApi(connJsonEntity);

			String connusername = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

			// String connpassword =
			// getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 2);

			String usernamekeypair = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 9);

			// String keyFileContentdata =
			// getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 10);

			// String keyFilePassworddata =
			// getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 11);

			String keyVaultNamedata = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 12);

			String clientIddata = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 13);

			String tenantIddata = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 14);

			String clientSecretdata = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 15);

			String privateKeySecretNamedata = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 16);

			String privateKeyPasswordSecretNamedata = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 17);

			inVisible(driver, spinner, Constant.ruleWait);

			Thread.sleep(1000);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				// viewSnowflakeConnectionMethod(connJsonEntity, driverName);

				if (!icedqUser.contains("reader")) {

					flag = cp.testConnection(connectionTestMess);

				} else {
					flag = cp.testConnection(forbiddenToastMsg);
				}
			} else {
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE))
					if (icedqUser.contains("contributor") || (icedqUser.contains("executor"))) {

						if (connParam.getAuthentication().equalsIgnoreCase("password")) {

							enterUsername(connusername);

							cp.entersecretPassword(connJsonEntity, connParam.getAuthentication(),
									connParam.getConnectorID(), icedqUser);
						} else if (connParam.getAuthentication().equalsIgnoreCase("key-pair")) {

							enterUsername(usernamekeypair);

							cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);
						} else if (connParam.getAuthentication().equalsIgnoreCase("azure-key-vault")) {

							enterUsername(usernamekeypair);

							enterkeyVaultName(keyVaultNamedata);

							enterClientId(clientIddata);

							enterTenantId(tenantIddata);

							enterClientSecret(clientSecretdata);

							enterPrivateKeySecretName(privateKeySecretNamedata);

							enterPrivateKeyPasswordSecretName(privateKeyPasswordSecretNamedata);
						}
						cp.saveConnection();
						waitForExecution(2000);
						inVisible(driver, spinner, Constant.ruleWait);
						flag = cp.testConnection(connectionTestMess);
					} else if (icedqUser.contains("owner")) {
						flag = cp.testConnection(connectionTestMess);

					} else {
						flag = rp.clickQuickAddbtn(forbiddenToastMsg);
					}
			}

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not tested properly kindly check :" + e.toString());

		}

		return flag;
	}

	/** Duplicate Snowflake connection using API **/
	public boolean duplicateSnowflakeConnectionMethod(String connJsonEntity, String icedqUser) {
		boolean flag = false;
		String name = null;
		String newconnectionName = null;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {

			// viewSnowflakeConnectionMethod(connJsonEntity,icedqUser);

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

			inVisible(driver, spinner, Constant.ruleWait);

			Thread.sleep(3000);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				clickOnConnectionsTab();

				isDisplayedInLoop(driver, 0, discardButtons);
				if (isDisplayed(driver, discardButtons)) {
					displayAndClick(driver, discardButtons);
				}

				String connName;

				waitForExecution(3000);

				if ((!icedqUser.contains("owner"))) {

					connName = newconnectionName;
				} else {
					connName = newconnectionName;
				}
				searchAndClickOnConnectionNameInConnRepo(connName);

				inVisible(driver, spinner, Constant.ruleWait);

				waitForExecution(2000);
			}
			if (icedqUser.contains("owner")) {

				flag = cp.clickOnDuplicateConnection(connDupllicateToastMsg);

				inVisible(driver, spinner, Constant.ruleWait);

				if (flag) {
					name = getAttribute(driver, connName, valueAttribute);

					cp.clickOnConnectionsTab();

					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}

					flag = cp.searchConnection(name);
				}
			} else {
				flag = cp.clickOnDuplicateConnection(readerGrantErrMessage);
			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog("due to exception kindly check " + e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;
	}

	/** Delete snowflake connection using API test data **/
	public boolean deleteSnowflakeConnectionMethod(String connJsonEntity, String icedqUser) {
		boolean flag = true;
		String newconnectionName = null;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

			inVisible(driver, spinner, Constant.ruleWait);

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			// viewSnowflakeConnectionMethod(connJsonEntity,icedqUser);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				String connName;
				waitForExecution(3000);
				clickOnConnectionsTab();
				if ((!icedqUser.contains("owner"))) {
					connName = newconnectionName;
				} else {
					connName = connParam.getConnName() + "_" + BaseSuite.WorkspaceName
							+ ConstantProperty.SIGN_UNDERSCORE + "vault";
				}
				cp.searchAndClickOnConnectionNameInConnRepo(connName);

				inVisible(driver, spinner, Constant.ruleWait);

			}

			if (icedqUser.contains("owner")) {

				flag = cp.clickOnDeleteButton(connSingleDeleteToastMsg, 1);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			} else {

				flag = clickOnButton(driver, clickonDisable, "Connection Delete", flag);

				flag = captureToastMsg(driver, toastMsg, popUpClose, forbiddenToastMsg, "Connection Delete");

			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(" due to exception kindly check " + e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;
	}

	public void updateConnectionName(String updatedconnName) throws NoSuchElementException {

		try {
			isDisplayedInLoop(driver, 4, connName);

			javascript(driver, scrollToElementArg, connNameLabel);

			verifyIndividualLabel(driver, connNameLabel, Constant.CONNECTIONNAME);

			if (isDisplayed(driver, connName)) {

				isClickable(driver, connName, Constant.CONNECTIONNAME + " field", true);

				if (isEditable(driver, connName, Constant.CONNECTIONNAME + " field")) {

					clear(driver, connName);

					validateConnectionNameField(false);

					BaseSuite.validationReportLog("Entering Name : " + updatedconnName);

					sendKeys(driver, connName, updatedconnName);

				} else {
					BaseSuite.reportFailLog(Constant.CONNECTIONNAME + " field not editable", "enterConnectionName");
				}
			} else {
				BaseSuite.reportFailLog(Constant.CONNECTIONNAME + " field not displayed", "enterConnectionName");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Exception found : " + e.getMessage());
			throw new NoSuchElementException();
		}
	}

	public String getConnectionDetailsUsingAuthType(String connectorName, int rowNumber) {

		XLUtils xl = new XLUtils();

		String value = null;

		try {

			String filePath = System.getProperty("user.dir") + Constant.NEXTGENCONNECTIONDETAILS;

			value = xl.readUsingColName(filePath, "ConnectionCrendential", rowNumber,
					connectorName.trim().toLowerCase());

		} catch (Exception e) {
			e.getMessage();
		}

		return value;
	}

	/** New connection method for contributor/excutor/reader grant users **/

	public boolean clickOnNewConnectionButton() {
		boolean flag = true;
		try {

			clickOnButton(driver, clickonNewConnection, "New Connection", true);

			inVisible(driver, connectionPageSpinner, Constant.ruleWait);

			if (isDisplayed(driver, toastMsg)) {

				flag = captureToastMsg(driver, toastMsg, ToastMsgClosedBtn, connIcedqUserAuthorisationMsg,
						"Role authentication");

			} else {
				BaseSuite.reportFailLog("Expected Toast message not found kindly check", "clickOnNewConnectionButton");

				throw new AssertionError("clickOnNewConnectionButton");
			}

		} catch (Exception e) {
			e.getMessage();
			flag = false;
		}
		return flag;
	}

	/** Validate input field state method **/
	public boolean validateInputFieldVisibility(By locator, String label, String placeholder, boolean expected) {

		boolean flag = true;

		try {
			verifyVisibilityOfButtons(driver, locator, label, expected);

			flag = isEditable(driver, locator, label);

			if (flag && expected) {
				BaseSuite.validationReportLog(label + " is editable as expected");
			} else if (!flag && !expected) {
				BaseSuite.validationReportLog(label + " is not editable as expected");
			} else {
				BaseSuite.reportFailLog(
						"Expected condition not found : Expected :" + expected + " and Actual : " + flag,
						"validateInputFieldVisibility");
			}

			String ph = getAttribute(driver, locator, placeHolderAttribute);

			if (ph.isEmpty()) {

				if (ph.equalsIgnoreCase(placeholder)) {

					BaseSuite.validationReportLog("Expected place holder value matched");
				} else {
					BaseSuite.reportFailLog("Expected place holder value not matched", "validateInputFieldVisibility");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e.toString());
			flag = false;
		}

		return flag;
	}

	/** Search Connection method **/
	public boolean searchConnection(String name) {
		boolean flag = true;

		try {
			isDisplayedInLoop(driver, 5, usersearchconnection);

			if (isDisplayed(driver, usersearchconnection)) {

				if (isEnabled(driver, usersearchconnection)) {

					if (isEditable(driver, usersearchconnection, "Search box")) {

						BaseSuite.reportLog("Entering connection name : " + name);

						clear_Click_SendKeys(driver, 5, usersearchconnection, name);

						// String ac = getAttribute(driver, usersearchconnection, valueAttribute);

						// flag = stringContainsOutput(ac, name, true);
						isDisplayedInLoop(driver, 5, usersearchconnectionbtn);
						if (isDisplayed(driver, usersearchconnectionbtn)) {

							BaseSuite.reportLog("Clicking on search button");

							displayAndClick(driver, usersearchconnectionbtn);

							BaseSuite.validationReportLog("Clicked on search button successfully");

							inVisible(driver, connectionPageSpinner, Constant.ruleWait);
						} else {
							BaseSuite.reportFailLog("Search button not visible", "_searchConnection");
							flag = false;
						}
					} else {
						BaseSuite.reportFailLog("Search box not editable", "_searchConnection");
						flag = false;
					}
				} else {
					BaseSuite.reportFailLog("Search box not enabled", "searchConnection");
					flag = false;
				}

			} else {
				BaseSuite.reportFailLog("Search box not displayed", "searchConnection");
				flag = false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e.toString());
			flag = false;
		}

		return flag;
	}

	/** Click on Connection with contains method **/
	public boolean clickOnConnectionName(String name) {

		boolean flag = true;

		try {
			waitForExecution(500);

			isDisplayedInLoop(driver, 10, returnElement(connectionNameLinkWithContains, dynamicName, name));

			if (isDisplayed(driver, returnElement(connectionNameLinkWithContains, dynamicName, name))) {

				clickOnButton(driver, returnElement(connectionNameLinkWithContains, dynamicName, name), name, true);

				waitForExecution(1000);

				inVisible(driver, chooseConnectionTypeSpinner, Constant.ruleWait);

			} else {

				BaseSuite.reportFailLog("Connection name not visible ", "clickOnConnectionName");

				flag = false;
			}

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e.toString());

			flag = false;

			Thread.currentThread().interrupt();
		}
		return flag;
	}

	/** Search and click on Connection method **/
	public boolean searchAndClickOnConnectionNameInConnRepo(String name) {
		boolean flag = true;

		try {
			flag = searchConnection(name);
			Thread.sleep(1000);
			if (!isDisplayed(driver, noRecondsFound)) {

				if (flag) {
					waitForExecution(2000);
					flag = clickOnConnectionName(name);

					inVisible(driver, spinner, Constant.ruleWait);
					waitForExecution(1000);

				} else {
					BaseSuite.reportFailLog("Searched connection name not found",
							"searchAndClickOnConnectionNameInConnRepo");

				}
			} else {
				BaseSuite.skipReportLog("No connection found for searched value : " + name);
				flag = false;
				clickOnUserConnectionTab();
				clickOnConnectionsTab();
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e.toString());
			flag = false;
		}

		return flag;
	}

	/** Save connection method in case of update **/
	public boolean saveConnection() throws Exception {
		boolean flag = true;
		try {

			javascript(driver, "arguments[0].scrollIntoView(true);", connSaveBtn);

			flag = clickOnButton(driver, connSaveBtn, "Save", true);

			inVisible(driver, spinner, Constant.ruleWait);

		} catch (Exception ex) {
			throw new NoSuchElementException();
		}
		return flag;
	}

	/** Test Connection method **/
	public boolean testConnectionInConnRepo(String connName, String connectionType, String connectorType,
			String icedqUser) {
		boolean flag = true;
		ConnectionPageNeha cp = new ConnectionPageNeha(driver);

		try {
			String connusername = getConnectionDetailsUsingAuthType(connectorType, 1);

			String connpassword = getConnectionDetailsUsingAuthType(connectorType, 2);

			if (connectionType.equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				// clickOnConnectionsTab();

				// connectionRepositoryLandingPage();

				// flag = searchAndClickOnConnectionNameInConnRepo(connName);
				if (flag) {

					if (icedqUser.toLowerCase().contains("reader")) {
						Thread.sleep(3000);
						flag = testConnection(readerGrantErrMessage);

					} else {

						flag = testConnection(connectionTestMess);
					}
				}
			} else if (connectionType.equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				clickOnUserConnectionTab();

				flag = searchAndClickOnConnectionNameInConnRepo(connName);
				if (flag) {
					Thread.sleep(3000);
					cp.enterUsername(connusername);

					cp.enterPassword(connpassword);

					if (icedqUser.toLowerCase().contains("reader")) {

						flag = saveConnection(newConnToastMsg);

						flag = verifyVisibilityOfButtons(driver, connTestBtn, "Test", false);
					} else {
						saveConnection();

						flag = testConnection(connectionTestMess);
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e.toString());
			Thread.currentThread().interrupt();
		}

		return flag;
	}

	/** View Connection Details Method **/

	public boolean viewConnectionDetailsMethod(String connJsonEntity, String icedqUser) {

		boolean flag = true;
		try {

			// ConnectionPageNeha nk= new ConnectionPageNeha(driver);

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			// connectionRepositoryLandingPage();

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				// validateWorkspaceField(BaseSuite.WorkspaceName);

				flag = viewAndValidateConnectionField(connName, "Connection Name", connParam.getConnName(), true);

				Thread.sleep(1000);

				String authType = setAuthenticationType(connParam.getAuthentication());

				flag = viewAndValidateConnectionField(connAuthTypeField, "Connection Authentication", authType, true);

				flag = viewCustomJDBCURLCheckbox(connParam.getCustomJdbcFullUrl());

				if (connParam.getCustomJdbcFullUrl().equalsIgnoreCase("true")) {
					flag = viewAndValidateConnectionField(connCustomJDBCTextbox, "Connection JDBC URL",
							connParam.getCustomJDBCURLValue(), true);
				} else {
					flag = viewAndValidateConnectionField(connCustomJDBCTextbox, "Connection JDBC URL",
							connParam.getCustomJDBCURLValue(), false);
				}

				verifyConnElementNItsVisibility(accountIdentifierInput, "Identifier", connParam.getAccountIdentifire(),
						connParam.getCustomJdbcFullUrl(), ConstantProperty.CONN_SYSTETYPE);

				verifyConnElementNItsVisibility(connWarehouseInput, "Warehouse", connParam.getWarehouse(),
						connParam.getCustomJdbcFullUrl(), ConstantProperty.CONN_SYSTETYPE);

				verifyConnElementNItsVisibility(connDatabaseInput, "Database", connParam.getDatabaseName(),
						connParam.getCustomJdbcFullUrl(), ConstantProperty.CONN_SYSTETYPE);

				viewConnectionTypeForSystemConn();

				viewUsernameFieldWithSystemConnection(connParam.getUsername().trim());

				viewPasswordFieldWithSystemConnection();

			} else if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				clickOnUserConnectionTab();

				flag = searchAndClickOnConnectionNameInConnRepo(connParam.getConnName());

				if (flag) {
					// validateWorkspaceField(BaseSuite.WorkspaceName);

					inVisible(driver, spinner, Constant.ruleWait);

					Thread.sleep(1000);

					flag = viewAndValidateConnectionField(connName, "Connection Name", connParam.getConnName(), false);

					String authName = setAuthenticationType(connParam.getAuthentication());

					flag = viewAndValidateConnectionField(connAuthTypeField, "Connection Authentication", authName,
							false);

					flag = viewCustomJDBCURLCheckbox(connParam.getCustomJdbcFullUrl());

					flag = viewAndValidateConnectionField(connCustomJDBCTextbox, "Connection JDBC URL",
							connParam.getCustomJDBCURLValue(), false);

					verifyConnElementNItsVisibility(accountIdentifierInput, "access modifier",
							connParam.getNameAccount(), connParam.getCustomJdbcFullUrl(),
							ConstantProperty.CONN_USERTYPE);

					verifyConnElementNItsVisibility(connWarehouseInput, "warehouser", connParam.getWareHouseVal(),
							connParam.getCustomJdbcFullUrl(), ConstantProperty.CONN_USERTYPE);

					verifyConnElementNItsVisibility(connDatabaseInput, "database", connParam.getDatabase(),
							connParam.getCustomJdbcFullUrl(), ConstantProperty.CONN_USERTYPE);

					viewConnectionTypeForUserConn();

					viewUsernameFieldWithUserConnection();

					viewPasswordFieldWithUserConnection();

				}
			}

			ArrayList<String> connPropertyList = TestDataThroughApi
					.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, "$.connectionProperties..name");

			int count = connPropertyList.size();

			if (count > 0) {
				verifyPropertyPane(connJsonEntity);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e.toString());
		}
		return flag;

	}

	/** View Connection Field Data method **/

	public boolean viewAndValidateConnectionField(By locator, String label, String expectedValue, boolean state) {

		boolean flag = true;
		String methodName = "viewAndValidateConnectionField";
		try {
			isDisplayedInLoop(driver, 5, locator);
			javascript(driver, scrollToElementArg, locator);
			if (isDisplayed(driver, locator)) {

				if (state) {
					if (isEnabled(driver, locator)) {

						BaseSuite.validationReportLog(label + " is enabled as expected");
					} else {
						BaseSuite.reportFailLog(label + " is disabled and expected is enabled", methodName);

					}
				} else {
					if (!isEnabled(driver, locator)) {
						BaseSuite.validationReportLog(label + " is disabled as expected");
					} else {
						BaseSuite.reportFailLog(label + " is enabled and expected is disabled", methodName);

					}
				}
				if (!expectedValue.isEmpty()) {
					String ac = getAttribute(driver, locator, valueAttribute);

					flag = stringContainsOutput(ac, expectedValue, true);
				}

			} else {
				BaseSuite.reportFailLog(label + " is not visible ", methodName);
				flag = false;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e.toString());
			flag = false;
		}
		if (!flag) {
			throw new AssertionError(methodName);
		}
		return flag;
	}

	public boolean viewCustomJDBCURLCheckbox(String state) {
		String str = "check";
		boolean flag = true;
		String mN = "viewCustomJDBCURLCheckbox";
		try {
			isDisplayedInLoop(driver, 5, connCustomJDBCLabel);

			javascript(driver, scrollToElementArg, connCustomJDBCLabel);

			if (isDisplayed(driver, connCustomJDBCLabel)) {

				BaseSuite.reportLog("verifying custom JDBC URL checkbox");

				if (isDisplayed(driver, connCustomJDBCCheckbox)) {

					BaseSuite.validationReportLog("Custom JDBC URL checkbox is visible");

					String actualState = getAttribute(driver, connCustomJDBCCheckbox, "class");

					if (Boolean.parseBoolean(state)) {
						if (actualState.contains(str)) {

							BaseSuite.validationReportLog(
									"Default condition of Custom JDBC URL checkbox is is expected as checked");
						} else {
							BaseSuite.reportFailLog(
									"Default condition of Custom JDBC URL checkbox is is expected as unchecked", mN);
							flag = false;
						}
					} else {
						if (!actualState.contains(str)) {

							BaseSuite.validationReportLog(
									"Default condition of Custom JDBC URL checkbox is expected as unchecked");
						} else {
							BaseSuite.reportFailLog(
									"Default condition of Custom JDBC URL checkbox is expected as checked", mN);
							flag = false;
						}
					}

				} else {
					BaseSuite.reportFailLog("Custom JDBC URL checkbox not visible ", mN);
					flag = false;
				}
			} else {
				BaseSuite.reportFailLog("Custom JDBC URL field not visible ", mN);
				flag = false;
			}
		} catch (Exception e) {
			e.getMessage();

			throw new NoSuchElementException();
		}

		return flag;
	}

	/** ========= Flat File Native Code Start here ======== **/

	/** Validate and select location type of flat file connection **/

	public void selectLocationOfFlatFileNativeConnection(String locationType) {

		try {
			String authValue = null;
			isDisplayedInLoop(driver, 2, connFlatFileLocationLabel);

			javascript(driver, scrollToElementArg, connFlatFileLocationLabel);

			verifyIndividualLabel(driver, connFlatFileLocationLabel, ConstantProperty.CONN_FIELD_LOCATION);

			if (isDisplayed(driver, connFlatFileLocationField)) {

				BaseSuite.validationReportLog("Location field is visible ");

				authValue = getAttribute(driver, connFlatFileLocationField, valueAttribute);

				BaseSuite.reportLog("Default Location type selected as : " + authValue);

				isDisplayedInLoop(driver, 2, connFlatFileLocationDDBtn);

				if (isDisplayed(driver, connFlatFileLocationDDBtn)) {

					displayAndClick(driver, connFlatFileLocationDDBtn);

					BaseSuite.validationReportLog(
							"Clicked on Location drop down  " + ConstantProperty.SUCCESSSTRING + "");

					BaseSuite.reportLog("Checking list of location type visible");
					Thread.sleep(2000);
					List<WebElement> authList = getElements(driver, connFlatFileLocationDDList);

					for (int i = 0; i < authList.size(); i++) {

						String authName = authList.get(i).getAttribute("textContent");

						BaseSuite.reportLog((i + 1) + ". " + authName + " is visible");

					}
				}

				isDisplayedInLoop(driver, 4, returnElement(connFlatFileSelectLocation, dynamicName, locationType));

				if (isDisplayed(driver, returnElement(connFlatFileSelectLocation, dynamicName, locationType))) {

					displayAndClick(driver, returnElement(connFlatFileSelectLocation, dynamicName, locationType));

					authValue = getAttribute(driver, connFlatFileLocationField, valueAttribute);

					if (!authValue.isEmpty()) {
						BaseSuite.validationReportLog("Location type selected as : " + authValue);
					}

				} else {
					BaseSuite.reportFailLog("Expected location type not found kindly check",
							"selectAuthenticationOfConnection");
				}

			} else {
				BaseSuite.reportFailLog("Location field not visible ", " selectAuthenticationOfConnection");
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			e.getMessage();
			throw new NoSuchElementException();
		}
	}

	/** Enter Folder path for file connection **/

	public void enterFolderPathForFileConnection(String folderPath) throws NoSuchElementException {

		try {
			isDisplayedInLoop(driver, 4, connFlatFileFolderPathLabel);

			javascript(driver, scrollToElementArg, connFlatFileFolderPathLabel);

			verifyIndividualLabel(driver, connFlatFileFolderPathLabel, Constant.CONNECTIONNAME);

			if (isDisplayed(driver, connFlatFileFolderPathField)) {

				isClickable(driver, connFlatFileFolderPathField, " Folder path ", true);

				if (isEditable(driver, connFlatFileFolderPathField, " Folder Path ")) {

					clear(driver, connFlatFileFolderPathField);

					validationMessageOfField(connFlatFileFolderPathFieldValidation, " Folder path",
							folderPathEmptyValidationMsg, true);

					String ph = getAttribute(driver, connFlatFileFolderPathField, placeHolderAttribute);

					if (!ph.isEmpty() && ph.equalsIgnoreCase(folderPathPlaceHolder)) {

						BaseSuite.reportLog("Folder path field place holder : " + ph);

					} else {

						BaseSuite.reportFailLog("folder path field place holder not found : Actual :" + ph
								+ "  and Expected : " + folderPathPlaceHolder, " enterFolderPathForFileConnection");
					}

					BaseSuite.reportLog("Entering value : " + folderPath);

					sendKeys(driver, connFlatFileFolderPathField, folderPath);

					String ac = getAttribute(driver, connFlatFileFolderPathField, valueAttribute);

					stringContainsOutput(ac, folderPath, true);

					validationMessageOfField(connFlatFileFolderPathFieldValidation, "Folder  path",
							folderPathEmptyValidationMsg, false);

				} else {
					BaseSuite.reportFailLog("Folder path field not editable", "enterFolderPathForFileConnection");
				}
			} else {
				BaseSuite.reportFailLog("Folder path field not displayed", "enterFolderPathForFileConnection");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Exception found : " + e.getMessage());
			throw new NoSuchElementException();
		}
	}

	/**
	 * validate validation message for field and whether is expected or not - true
	 * if message is expected and false if message not expected
	 **/
	public String validationMessageOfField(By locator, String label, String expected, boolean state) {

		String valMsg = null;
		isDisplayedInLoop(driver, 0, locator);

		if (isDisplayed(driver, locator)) {

			valMsg = getText(driver, locator);

			if (!valMsg.isEmpty()) {

				if (state) {

					if (valMsg.trim().contains(expected)) {

						BaseSuite.validationReportLog("Proper Validation message applied on " + label
								+ " field, Expected :- " + expected + " , Actual :- " + valMsg);
					} else {
						BaseSuite.reportFailLog("Validation message not matched for " + label + " field, i.e. actual : "
								+ valMsg + ", Expected : " + expected, "validationMessageOfField");
					}

				} else {
					if (valMsg.trim().contains(expected)) {

						BaseSuite.validationReportLog("Proper Validation message applied on " + label
								+ " field, Expected :- " + expected + " , Actual :- " + valMsg);

					} else {
						BaseSuite.reportFailLog("Validation message not matched for " + label + " field, i.e. actual : "
								+ valMsg + ", Expected : " + expected, "validationMessageOfField");
					}
				}
			}
		}
		return valMsg;
	}

	/** Choose connector type for api **/

	public String setConnectorIdToConnectorName(String connectorId) {
		String connectorName = null;

		switch (connectorId.toLowerCase()) {

		case "flat-file":
			connectorName = "Flat File (Native)";
			break;

		case "snowflake":
			connectorName = "Snowflake";
			break;

		case "redshift":
			connectorName = "Redshift";
			break;
		case "postgresql":
			connectorName = "PostgreSQL";
		case "oracle":
			connectorName = "Oracle";
			break;
		case "sybase":
			connectorName = "Sybase";
			break;
		case "teradata":
			connectorName = "Teradata";
			break;
		case "sql-server":
			connectorName = "SQL Server";
			break;
		case "salesforce":
			connectorName = "Salesforce";
			break;
		default:

		}

		return connectorName;

	}

	/** choose connector type using api data **/
	public void chooseConnectorType(String connectorId) {

		String connectorName = setConnectorIdToConnectorName(connectorId);

		isDisplayedInLoop(driver, 2, chooseConnectionType_SearchTxt);
		inVisible(driver, chooseConnectionType_Spinner, Constant.ruleWait);
		if (isDisplayed(driver, chooseConnectionType_SearchTxt)) {

			BaseSuite.validationReportLog("Search textbox is displayed on choose connection type page.");

			clear_SendKeys(driver, chooseConnectionType_SearchTxt, connectorName);

			driver.findElement(chooseConnectionType_SearchTxt).sendKeys(Keys.ENTER);

			BaseSuite.reportLog("Enter button clicked successfully, verifying searched record.");

			BaseSuite.validationReportLog("Searched successfully " + connectorName + " connection type.");

			isDisplayedInLoop(driver, 0, returnElement(newConn_ClickConnTile, "$name", connectorName));

			if (isDisplayed(driver, returnElement(newConn_ClickConnTile, "$name", connectorName))) {

				displayAndClick(driver, returnElement(newConn_ClickConnTile, "$name", connectorName));

				BaseSuite.validationReportLog("Successfully clicked on connection " + connectorName + " button.");

				inVisible(driver, chooseConnectionType_Spinner, Constant.ruleWait);
			}
		} else {
			//
		}
	}

	/**
	 * Create Flat file native connection using API test data
	 * 
	 * @throws Exception
	 **/
	public boolean createFlatFileNativeConnectionMethod(String sourceConnectionName, String sourceWorkspaceId,
			String icedqUser) throws Exception {
		boolean flag = true;

		String newconnectionName = null;

		try {
			String connectionID = getConnectionIDFromConnectionName(sourceConnectionName, sourceWorkspaceId, icedqUser);

			String connJsonEntity = TestDataThroughApi.getConnectionJsonEntity(sourceWorkspaceId, connectionID,
					icedqUser);

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			String timestamp = new SimpleDateFormat(ConstantProperty.CONNECTIONNAME_TIMESTAMPFORMAT).format(new Date());

			newconnectionName = connParam.getConnName() + "_" + BaseSuite.WorkspaceName + "_" + timestamp;

			connectionRepositoryLandingPage();

			flag = clickOnNewConnectionBtn(icedqUser);

			if (flag) {

				chooseConnectorType(connParam.getConnectorID());

				inVisible(driver, spinner, Constant.ruleWait);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				enterConnectionName(newconnectionName);

				// selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

				selectLocationOfFlatFileNativeConnection(connParam.getServiceProviderName());

				switch (connParam.getServiceProviderName().trim().toLowerCase()) {

				case "local":

					enterFolderPathForFileConnection(connParam.getFolderPath());

					break;

				case "s3":

					selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());

					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					validatAndeEnterValueToTextField(connFlatFileContainerLabel, connFlatFileContainerField,
							ConstantProperty.CONN_FIELD_CONTAINER, containerPlaceHolder, connParam.getContainer(),
							containerEmptyValidationMsg);

					validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,
							ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder, connParam.getFolderPath(),
							folderPathEmptyValidationMsg);

					validatAndeEnterValueToTextField(connFlatFileRegionLabel, connFlatFileRegionField,
							ConstantProperty.CONN_FIELD_REGION, regionPlaceHolder, connParam.getRegionValue(),
							regionEmptyValidationMsg);

					selectConnectionType(connParam.getType());

					break;

				case "azure blob":

					selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());

					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					validatAndeEnterValueToTextField(connFlatFileContainerLabel, connFlatFileContainerField,
							ConstantProperty.CONN_FIELD_CONTAINER, containerPlaceHolder, connParam.getContainer(),
							containerEmptyValidationMsg);

					validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,
							ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder, connParam.getFolderPath(),
							folderPathEmptyValidationMsg);

					selectConnectionType(connParam.getType());

					break;

				default:

					BaseSuite.reportLog("Location not found  :: " + connParam.getServiceProviderName());
					break;

				}

				updateSystemAndUserConnectionCredentials(connParam, newconnectionName, icedqUser);

				viewCreatedOrUpdatedConnectionForFlatFile(connParam, newconnectionName);

			}
		} catch (RuntimeException e) {
			flag = false;
			BaseSuite.reportErrorLog("Connection not created properly due to exception kindly check " + e.toString());

		}
		return flag;

	}

	public boolean updateSystemAndUserConnectionCredentials(ConnectionPoJO connParam, String newConnectionName,
			String icedqUser) {
		boolean flag = false;

		String accessKey = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 3);

		String secretKey = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 4);

		String accountName = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 5);

		String accountKey = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 6);

		try {
			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				if (connParam.getServiceProviderName().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)) {

					validatAndeEnterValueToTextField(connFlatFileAccesskeyLabel, connFlatFileAccesskeyField,
							ConstantProperty.CONN_FIELD_ACCESSKEY, accesskeyPlaceHolder, accessKey,
							accesskeyEmptyValidationMsg);

					validatAndeEnterValueToTextField(connFlatFileSecretkeyLabel, connFlatFileSecretkeyField,
							ConstantProperty.CONN_FIELD_SECRETKEY, secretkeyPlaceHolder, secretKey,
							secretkeyEmptyValidationMsg);

				} else if (connParam.getServiceProviderName().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {

					validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
							ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, accountName,
							accountNameEmptyValidationMsg);

					validatAndeEnterValueToTextField(connFlatFileAccountKeyLabel, connFlatFileAccountKeyField,
							ConstantProperty.CONN_FIELD_ACCOUNTKEY, accountKeyPlaceHolder, accountKey,
							accountKeyEmptyValidationMsg);

				}

				flag = saveConnection(connectionSaveMesssage);

			} else {
				if (connParam.getServiceProviderName().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)) {

					validateFieldOfConnection(connFlatFileAccesskeyLabel, connFlatFileAccesskeyField,
							ConstantProperty.CONN_FIELD_ACCESSKEY, accesskeyPlaceHolder, false);

					validateFieldOfConnection(connFlatFileSecretkeyLabel, connFlatFileSecretkeyField,
							ConstantProperty.CONN_FIELD_SECRETKEY, secretkeyPlaceHolder, false);

				} else if (connParam.getServiceProviderName().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {

					validateFieldOfConnection(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
							ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, false);

					validateFieldOfConnection(connFlatFileAccountKeyLabel, connFlatFileAccountKeyField,
							ConstantProperty.CONN_FIELD_ACCOUNTKEY, accountKeyPlaceHolder, false);

				}

				flag = saveConnection(connectionSaveMesssage);
				if (flag) {
					clickOnUserConnectionTab();

					searchAndClickOnConnectionName(newConnectionName);

					Thread.sleep(3000);

					if (connParam.getServiceProviderName().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)) {

						validatAndeEnterValueToTextField(connFlatFileAccesskeyLabel, connFlatFileAccesskeyField,
								ConstantProperty.CONN_FIELD_ACCESSKEY, accesskeyPlaceHolder, accessKey,
								accesskeyEmptyValidationMsg);

						validatAndeEnterValueToTextField(connFlatFileSecretkeyLabel, connFlatFileSecretkeyField,
								ConstantProperty.CONN_FIELD_SECRETKEY, secretkeyPlaceHolder, secretKey,
								secretkeyEmptyValidationMsg);

					} else if (connParam.getServiceProviderName()
							.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {

						validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
								ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, accountName,
								accountNameEmptyValidationMsg);

						validatAndeEnterValueToTextField(connFlatFileAccountKeyLabel, connFlatFileAccountKeyField,
								ConstantProperty.CONN_FIELD_ACCOUNTKEY, accountKeyPlaceHolder, accountKey,
								accountKeyEmptyValidationMsg);

					}
				}
				flag = saveConnection();

			}
			if (flag) {
				flag = testFlatFileNativeConnectionUsingIcedqUser(connParam, icedqUser);
			}
		} catch (NoSuchElementException e) {
			flag = false;
			BaseSuite.reportErrorLog("NoSuchElementException " + e.toString());

		} catch (InterruptedException e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("InterruptedException kindly check " + e.toString());

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog("Exception kindly check  :" + e.toString());

		}

		return flag;
	}

	public boolean testFlatFileNativeConnectionUsingIcedqUser(ConnectionPoJO connParam, String icedqUser) {
		boolean flag = false;

		try {

			switch (connParam.getType().toLowerCase().trim()) {

			case "system":

				if (!icedqUser.contains("reader")) {

					if (!connParam.getServiceProviderName().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_LOCAL)) {

						flag = testConnection(connectionTestMess);

					} else if (connParam.getServiceProviderName()
							.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_LOCAL)) {

						flag = verifyVisibilityOfButtons(driver, connTestBtn, ConstantProperty.COMMON_BUTTON_TEST,
								false);

					}

				} else {
					if (!connParam.getServiceProviderName().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_LOCAL)) {

						flag = testConnection(forbiddenToastMsg);

					} else if (connParam.getServiceProviderName()
							.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_LOCAL)) {

						flag = verifyVisibilityOfButtons(driver, connTestBtn, ConstantProperty.COMMON_BUTTON_TEST,
								false);

					}
				}
				break;

			case "user":

				if (!icedqUser.contains("reader")) {

					flag = testConnection(connectionTestMess);

				} else {

					flag = testConnection(forbiddenToastMsg);
				}

				break;

			default:
				break;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e.toString());
		}
		return flag;

	}

	/** validate connection id field of connection **/
	public String validateConnectionIdField() {

		String connectionID = null;
		String methodName = "validateConnectionIdField";

		isDisplayedInLoop(driver, 3, connConnectionIdLabel);

		if (isDisplayed(driver, connConnectionIdLabel)) {

			BaseSuite.validationReportLog("Connection Id field label is visible");

			isDisplayedInLoop(driver, 3, connConnectionIdField);

			if (isDisplayed(driver, connConnectionIdField)) {

				if (!isEnabled(driver, connConnectionIdField)) {

					BaseSuite.validationReportLog("Connection Id field is disabled");

					connectionID = getAttribute(driver, connConnectionIdField, valueAttribute);

					BaseSuite.validationReportLog("Connection Id is : " + connectionID);
				} else {
					BaseSuite.reportFailLog("Connection Id field is enabled", methodName);
				}
			} else {
				BaseSuite.reportFailLog("Connection Id field not visible", methodName);
			}
		} else {
			BaseSuite.reportFailLog("Connection Id label not visible", methodName);
		}

		return connectionID;
	}

	/** View Flat file native connection using API test data **/
	public boolean viewFlatFileNativeConnectionMethod(String connJsonEntity, String icedqUser) {
		boolean flag = true;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);
			
			String wizardStatus = cp.validateExistingConnPageButtonsFields(connJsonEntity);
			
			if (wizardStatus.contains("Wizard supported connector")) {
				
				verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", false);
			}
			
			verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

			verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", true);

			verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

			verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", true);

			verifyVisibilityOfButtons(driver, connUploadFilesButton, "Upload Files Button", false);
			
			verifyVisibilityOfButtons(driver, moreButton, "More Button", true);

			inVisible(driver, spinner, Constant.ruleWait);

			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			Thread.sleep(2000);
			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {
				inVisible(driver, spinner, Constant.ruleWait);

				viewAndValidateConnectionField(connName, "Connection Name", connParam.getConnName(), true);

				// viewAndValidateConnectionField(connFlatFileDriverField,"driver", "Flat File
				// (Native)", true);

				viewAndValidateConnectionField(connFlatFileLocationField, ConstantProperty.CONN_FIELD_LOCATION,
						connParam.getServiceProviderName(), true);

				if (connParam.getServiceProviderName().trim().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_LOCAL)) {

					viewAndValidateConnectionField(connFlatFileFolderPathField, "Folder Path ",
							connParam.getFolderPath(), true);

					verifyVisibilityOfButtons(driver, connSaveBtn, ConstantProperty.COMMON_BUTTON_SAVE, false);
					verifyVisibilityOfButtons(driver, connTestBtn, ConstantProperty.COMMON_BUTTON_TEST, false);
					verifyVisibilityOfButtons(driver, connDuplicateButton, ConstantProperty.COMMON_BUTTON_DUPLICATE,
							true);
					verifyVisibilityOfButtons(driver, connDeleteButton, ConstantProperty.COMMON_BUTTON_DELETE, true);
				} else if (connParam.getServiceProviderName().trim()
						.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)) {

					viewAndValidateConnectionField(connFlatFileTypeField, ConstantProperty.CONN_FIELD_FILETYPE,
							connParam.getFileType(), true);

					viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
							connParam.getAuthenticationname(), true);

					viewAndValidateConnectionField(connFlatFileContainerField, ConstantProperty.CONN_FIELD_CONTAINER,
							connParam.getContainer(), true);

					viewAndValidateConnectionField(connFlatFileFolderPathField, ConstantProperty.CONN_FIELD_FOLDERPATH,
							connParam.getFolderPath(), true);

					viewAndValidateConnectionField(connFlatFileRegionField, ConstantProperty.CONN_FIELD_REGION,
							connParam.getRegionValue(), true);

					validatAndeEnterValueToTextField(connFlatFileAccesskeyLabel, connFlatFileAccesskeyField,
							ConstantProperty.CONN_FIELD_ACCESSKEY, accesskeyPlaceHolder, "",
							accesskeyEmptyValidationMsg);

					validatAndeEnterValueToTextField(connFlatFileSecretkeyLabel, connFlatFileSecretkeyField,
							ConstantProperty.CONN_FIELD_SECRETKEY, secretkeyPlaceHolder, "",
							secretkeyEmptyValidationMsg);

				} else if (connParam.getServiceProviderName().trim()
						.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {

					viewAndValidateConnectionField(connFlatFileTypeField, ConstantProperty.CONN_FIELD_FILETYPE,
							connParam.getFileType(), true);

					viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
							connParam.getAuthenticationname(), true);

					viewAndValidateConnectionField(connFlatFileContainerField, ConstantProperty.CONN_FIELD_CONTAINER,
							connParam.getContainer(), true);

					viewAndValidateConnectionField(connFlatFileFolderPathField, ConstantProperty.CONN_FIELD_FOLDERPATH,
							connParam.getFolderPath(), true);

					validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
							ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, "",
							accountNameEmptyValidationMsg);

					validatAndeEnterValueToTextField(connFlatFileAccountKeyLabel, connFlatFileAccountKeyField,
							ConstantProperty.CONN_FIELD_ACCOUNTKEY, accountKeyPlaceHolder, "",
							accountKeyEmptyValidationMsg);

				}
			} else {
				inVisible(driver, spinner, Constant.ruleWait);

				viewAndValidateConnectionField(connName, "Connection Name", connParam.getConnName(), false);

				viewAndValidateConnectionField(connFlatFileLocationField, ConstantProperty.CONN_FIELD_LOCATION,
						connParam.getServiceProviderName(), false);

				viewAndValidateConnectionField(connFlatFileTypeField, ConstantProperty.CONN_FIELD_FILETYPE,
						connParam.getFileType(), false);

				viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
						connParam.getAuthenticationname(), false);

				viewAndValidateConnectionField(connFlatFileContainerField, ConstantProperty.CONN_FIELD_CONTAINER,
						connParam.getContainer(), false);

				viewAndValidateConnectionField(connFlatFileFolderPathField, ConstantProperty.CONN_FIELD_FOLDERPATH,
						connParam.getFolderPath(), false);

				if (connParam.getServiceProviderName().trim().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)) {

					viewAndValidateConnectionField(connFlatFileRegionField, ConstantProperty.CONN_FIELD_REGION,
							connParam.getRegionValue(), false);

					viewAndValidateConnectionField(connFlatFileAccesskeyField, ConstantProperty.CONN_FIELD_ACCESSKEY,
							"", true);

					viewAndValidateConnectionField(connFlatFileSecretkeyLabel, ConstantProperty.CONN_FIELD_ACCESSKEY,
							"", true);

				} else {
					viewAndValidateConnectionField(connFlatFileAccountNameField,
							ConstantProperty.CONN_FIELD_ACCOUNTNAME, "", true);

					viewAndValidateConnectionField(connFlatFileAccountKeyLabel, ConstantProperty.CONN_FIELD_ACCOUNTKEY,
							"", true);

				}
			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog("Connection not visible properly due to exception kindly check " + e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;
	}

	/** Update Flat file native connection using API test data **/
	public boolean updateFlatFileNativeConnectionMethod(String connJsonEntity, String icedqUser) {
		boolean flag = true;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);

			Thread.sleep(4000);

			String timestamp = new SimpleDateFormat(ConstantProperty.CONNECTIONNAME_TIMESTAMPFORMAT).format(new Date());

			String updateConnectionName = connParam.getConnName() + "_" + BaseSuite.WorkspaceName + "_" + timestamp;

			String accessKey = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 3);

			String secretKey = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 4);

			String accountName = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 5);

			String accountKey = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 6);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				flag = updateFlatFileSystemConnection(connParam, updateConnectionName, accessKey, secretKey,
						accountName, accountKey, icedqUser);

			} else if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				flag = updateFlatFileUserConnection(connParam, accessKey, secretKey, accountName, accountKey,
						icedqUser);
			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog("Connection not updated properly due to exception kindly check " + e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;
	}

	public boolean updateFlatFileUserConnection(ConnectionPoJO connParam, String accessKey, String secretKey,
			String accountName, String accountKey, String icedqUser) {
		boolean flag = true;
		try {
			viewAndValidateConnectionField(connFlatFileTypeField, ConstantProperty.CONN_FIELD_FILETYPE,
					connParam.getFileType(), false);

			viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
					connParam.getAuthenticationname(), false);

			viewAndValidateConnectionField(connFlatFileContainerField, ConstantProperty.CONN_FIELD_CONTAINER,
					connParam.getContainer(), false);

			viewAndValidateConnectionField(connFlatFileFolderPathField, ConstantProperty.CONN_FIELD_FOLDERPATH,
					connParam.getFolderPath(), false);

			if (connParam.getServiceProviderName().trim().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)) {

				viewAndValidateConnectionField(connFlatFileRegionField, ConstantProperty.CONN_FIELD_REGION,
						connParam.getRegionValue(), false);

				validatAndeEnterValueToTextField(connFlatFileAccesskeyLabel, connFlatFileAccesskeyField,
						ConstantProperty.CONN_FIELD_ACCESSKEY, accesskeyPlaceHolder, accessKey,
						accesskeyEmptyValidationMsg);

				validatAndeEnterValueToTextField(connFlatFileSecretkeyLabel, connFlatFileSecretkeyField,
						ConstantProperty.CONN_FIELD_SECRETKEY, secretkeyPlaceHolder, secretKey,
						secretkeyEmptyValidationMsg);

			} else if (connParam.getServiceProviderName().trim()
					.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {

				validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
						ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, accountName,
						accountNameEmptyValidationMsg);

				validatAndeEnterValueToTextField(connFlatFileAccountKeyLabel, connFlatFileAccountKeyField,
						ConstantProperty.CONN_FIELD_ACCOUNTKEY, accountKeyPlaceHolder, accountKey,
						accountKeyEmptyValidationMsg);

			}
			if (!icedqUser.contains("reader")) {
				flag = saveConnection();
			} else {
				flag = saveConnection(forbiddenToastMsg);
			}
		} catch (NoSuchElementException e) {
			flag = false;
			BaseSuite.reportErrorLog("NoSuchElementException  kindly check " + e.toString());
		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(" Exception kindly check " + e.toString());
		}
		return flag;
	}

	public boolean updateFlatFileSystemConnection(ConnectionPoJO connParam, String updateConnectionName,
			String accessKey, String secretKey, String accountName, String accountKey, String icedqUser) {
		boolean flag = false;

		try {
			viewAndValidateConnectionField(connName, "Connection Name",
					connParam.getConnName() + "_" + BaseSuite.WorkspaceName, true);

			enterConnectionName(updateConnectionName);

			viewAndValidateConnectionField(connFlatFileLocationField, ConstantProperty.CONN_FIELD_LOCATION,
					connParam.getServiceProviderName(), true);

			if (connParam.getServiceProviderName().trim().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_LOCAL)) {

				viewAndValidateConnectionField(connFlatFileFolderPathField, ConstantProperty.CONN_FIELD_FOLDERPATH,
						connParam.getFolderPath(), true);

				enterFolderPathForFileConnection(connParam.getFolderPath());

				verifyVisibilityOfButtons(driver, connSaveBtn, ConstantProperty.COMMON_BUTTON_SAVE, true);
				verifyVisibilityOfButtons(driver, connTestBtn, ConstantProperty.COMMON_BUTTON_TEST, false);
				verifyVisibilityOfButtons(driver, connDuplicateButton, ConstantProperty.COMMON_BUTTON_DUPLICATE, true);
				verifyVisibilityOfButtons(driver, connDeleteButton, ConstantProperty.COMMON_BUTTON_DELETE, true);

				if (icedqUser.contains("owner")) {
					flag = saveConnection();
				} else {
					flag = saveConnection(forbiddenToastMsg);
				}

			} else if (connParam.getServiceProviderName().trim().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)) {

				viewAndValidateConnectionField(connFlatFileTypeField, ConstantProperty.CONN_FIELD_FILETYPE,
						connParam.getFileType(), true);

				selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());

				viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
						connParam.getAuthenticationname(), true);

				selectAuthenticationOfConnection(connParam.getAuthenticationname());

				viewAndValidateConnectionField(connFlatFileContainerField, ConstantProperty.CONN_FIELD_CONTAINER,
						connParam.getContainer(), true);

				validatAndeEnterValueToTextField(connFlatFileContainerLabel, connFlatFileContainerField,
						ConstantProperty.CONN_FIELD_CONTAINER, containerPlaceHolder, connParam.getContainer(),
						containerEmptyValidationMsg);

				viewAndValidateConnectionField(connFlatFileFolderPathField, ConstantProperty.CONN_FIELD_FOLDERPATH,
						connParam.getFolderPath(), true);

				validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,
						ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder, connParam.getFolderPath(),
						folderPathEmptyValidationMsg);

				viewAndValidateConnectionField(connFlatFileRegionField, ConstantProperty.CONN_FIELD_REGION,
						connParam.getRegionValue(), true);

				validatAndeEnterValueToTextField(connFlatFileRegionLabel, connFlatFileRegionField,
						ConstantProperty.CONN_FIELD_REGION, regionPlaceHolder, connParam.getRegionValue(),
						regionEmptyValidationMsg);

				selectConnectionType(connParam.getType());

				validatAndeEnterValueToTextField(connFlatFileAccesskeyLabel, connFlatFileAccesskeyField,
						ConstantProperty.CONN_FIELD_ACCESSKEY, accesskeyPlaceHolder, accessKey,
						accesskeyEmptyValidationMsg);

				validatAndeEnterValueToTextField(connFlatFileSecretkeyLabel, connFlatFileSecretkeyField,
						ConstantProperty.CONN_FIELD_SECRETKEY, secretkeyPlaceHolder, secretKey,
						secretkeyEmptyValidationMsg);

				if (icedqUser.contains("owner")) {
					flag = saveConnection();
				} else {
					flag = saveConnection(forbiddenToastMsg);
				}

			} else if (connParam.getServiceProviderName().trim()
					.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {

				viewAndValidateConnectionField(connFlatFileTypeField, ConstantProperty.CONN_FIELD_FILETYPE,
						connParam.getFileType(), true);

				selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());

				viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
						connParam.getAuthenticationname(), true);

				selectAuthenticationOfConnection(connParam.getAuthenticationname());

				viewAndValidateConnectionField(connFlatFileContainerField, ConstantProperty.CONN_FIELD_CONTAINER,
						connParam.getContainer(), true);

				validatAndeEnterValueToTextField(connFlatFileContainerLabel, connFlatFileContainerField,
						ConstantProperty.CONN_FIELD_CONTAINER, containerPlaceHolder, connParam.getContainer(),
						containerEmptyValidationMsg);

				viewAndValidateConnectionField(connFlatFileFolderPathField, ConstantProperty.CONN_FIELD_FOLDERPATH,
						connParam.getFolderPath(), true);

				validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,
						ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder, connParam.getFolderPath(),
						folderPathEmptyValidationMsg);

				selectConnectionType(connParam.getType());

				validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
						ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, accountName,
						accountNameEmptyValidationMsg);

				validatAndeEnterValueToTextField(connFlatFileAccountKeyLabel, connFlatFileAccountKeyField,
						ConstantProperty.CONN_FIELD_ACCOUNTKEY, accountKeyPlaceHolder, accountKey,
						accountKeyEmptyValidationMsg);

				if (icedqUser.contains("owner")) {
					flag = saveConnection();
				} else {
					flag = saveConnection(forbiddenToastMsg);
				}
			}
		} catch (NoSuchElementException e) {
			flag = false;
			BaseSuite.reportErrorLog("NoSuchElementException kindly check " + e.toString());
		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog("Exception kindly check " + e.toString());
		}

		return flag;

	}

	public boolean viewCreatedOrUpdatedConnectionForFlatFile(ConnectionPoJO connParam, String updateConnectionName)
			throws Exception {
		boolean flag = false;
		try {
			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				clickOnConnectionsTab();

				flag = searchAndClickOnConnectionNameInConnRepo(updateConnectionName);

				if (flag) {

					inVisible(driver, spinner, Constant.ruleWait);
					Thread.sleep(3000);
					driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

					viewAndValidateConnectionField(connName, "Connection Name", updateConnectionName, true);

					viewAndValidateConnectionField(connFlatFileLocationField, " Location ",
							connParam.getServiceProviderName(), true);

					if (connParam.getServiceProviderName().trim()
							.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_LOCAL)) {

						inVisible(driver, spinner, Constant.ruleWait);

						viewAndValidateConnectionField(connFlatFileFolderPathField,
								ConstantProperty.CONN_FIELD_FOLDERPATH, connParam.getFolderPath(), true);

					} else {

						viewAndValidateConnectionField(connFlatFileTypeField, ConstantProperty.CONN_FIELD_FILETYPE,
								connParam.getFileType(), true);

						viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
								connParam.getAuthenticationname(), true);

						viewAndValidateConnectionField(connFlatFileContainerField,
								ConstantProperty.CONN_FIELD_CONTAINER, connParam.getContainer(), true);

						viewAndValidateConnectionField(connFlatFileFolderPathField,
								ConstantProperty.CONN_FIELD_FOLDERPATH, connParam.getFolderPath(), true);

						if (connParam.getServiceProviderName().trim()
								.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)) {

							viewAndValidateConnectionField(connFlatFileRegionField, ConstantProperty.CONN_FIELD_REGION,
									connParam.getRegionValue(), true);

							validatAndeEnterValueToTextField(connFlatFileAccesskeyLabel, connFlatFileAccesskeyField,
									ConstantProperty.CONN_FIELD_ACCESSKEY, accesskeyPlaceHolder, "",
									accesskeyEmptyValidationMsg);

							validatAndeEnterValueToTextField(connFlatFileSecretkeyLabel, connFlatFileSecretkeyField,
									ConstantProperty.CONN_FIELD_SECRETKEY, secretkeyPlaceHolder, "",
									secretkeyEmptyValidationMsg);

						} else {

							validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
									ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, "",
									accountNameEmptyValidationMsg);

							validatAndeEnterValueToTextField(connFlatFileAccountKeyLabel, connFlatFileAccountKeyField,
									ConstantProperty.CONN_FIELD_ACCOUNTKEY, accountKeyPlaceHolder, "",
									accountKeyEmptyValidationMsg);

						}

					}
				}
			}
		} catch (NoSuchElementException e) {
			flag = false;
			BaseSuite.reportErrorLog("NoSuchElementException kindly check " + e.toString());
		} catch (InterruptedException e) {
			flag = false;
			BaseSuite.reportErrorLog("InterruptedException kindly check " + e.toString());
			Thread.currentThread().interrupt();
		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog("Exception kindly check " + e.toString());
		}
		return flag;
	}

	/** Test Flat file native connection using API test data **/
	public boolean testFlatFileNativeConnectionMethod(String connJsonEntity, String icedqUser) {
		boolean flag = true;

		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);

			Thread.sleep(3000);
			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				String accessKey = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 3);

				String secretKey = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 4);

				String accountName = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 5);

				String accountKey = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 6);

				if (connParam.getServiceProviderName().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)) {

					validatAndeEnterValueToTextField(connFlatFileAccesskeyLabel, connFlatFileAccesskeyField,
							ConstantProperty.CONN_FIELD_ACCESSKEY, accesskeyPlaceHolder, accessKey,
							accesskeyEmptyValidationMsg);

					validatAndeEnterValueToTextField(connFlatFileSecretkeyLabel, connFlatFileSecretkeyField,
							ConstantProperty.CONN_FIELD_SECRETKEY, secretkeyPlaceHolder, secretKey,
							secretkeyEmptyValidationMsg);

				} else if (connParam.getServiceProviderName().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {

					validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
							ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, accountName,
							accountNameEmptyValidationMsg);

					validatAndeEnterValueToTextField(connFlatFileAccountKeyLabel, connFlatFileAccountKeyField,
							ConstantProperty.CONN_FIELD_ACCOUNTKEY, accountKeyPlaceHolder, accountKey,
							accountKeyEmptyValidationMsg);

				}
				saveConnection();
			}
			if (!icedqUser.contains("reader")
					&& !connParam.getServiceProviderName().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_LOCAL)) {

				flag = testConnection(connectionTestMess);

			} else if (icedqUser.contains("reader")
					&& !connParam.getServiceProviderName().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_LOCAL)) {

				flag = testConnection(forbiddenToastMsg);

			} else if (connParam.getServiceProviderName().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_LOCAL)) {
				flag = verifyVisibilityOfButtons(driver, connTestBtn, ConstantProperty.COMMON_BUTTON_TEST, false);
			}
		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(" due to exception kindly check  " + e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;
	}

	/** Delete Flat file native connection using API test data **/
	public boolean deleteFlatFileNativeConnectionMethod(String connJsonEntity, String icedqUser) {
		boolean flag = true;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);
			Thread.sleep(3000);
			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				viewFlatFileNativeConnectionMethod(connJsonEntity, icedqUser);
			}
			if (icedqUser.contains("owner")) {

				flag = clickOnDeleteButton(connSingleDeleteToastMsg, 1);

			} else {
				flag = clickOnDeleteButton(forbiddenToastMsg, 1);
			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(" due to exception kindly check " + e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;
	}

	/** Click on delete button of connection and validate delete popup **/
	public boolean clickOnDeleteButton(String toastMessage, int count) {
		boolean flag = true;
		try {
			clickOnButton(driver, clickonDisable, ConstantProperty.CONNECTION_DELETE_BTN_TEXT, true);

			isDisplayedInLoop(driver, 3,
					returnElement(connectionDeletePopupBtn, dynamicName, ConstantProperty.CONNECTION_DELETE_BTN_TEXT));

			if (isDisplayed(driver, returnElement(connectionDeletePopupBtn, dynamicName,
					ConstantProperty.CONNECTION_DELETE_BTN_TEXT))) {

				if (count != 1) {
					flag = verifyIndividualLabel(driver, connDeletePopupTitle, connMultideletePopupTitle);

					flag = verifyIndividualLabel(driver, connectionDeletePopUpContent, connMultideletePopupContentMsg);

					flag = verifyVisibilityOfButtons(driver,
							returnElement(connectionDeletePopupBtn, dynamicName,
									ConstantProperty.CONNECTION_DELETE_BTN_TEXT),
							ConstantProperty.CONNECTION_DELETE_BTN_TEXT, true);

					flag = verifyVisibilityOfButtons(driver,
							returnElement(connectionDeletePopupBtn, dynamicName,
									ConstantProperty.CONNECTION_CANCEL_BTN_TEXT),
							ConstantProperty.CONNECTION_CANCEL_BTN_TEXT, true);

				} else {
					flag = verifyIndividualLabel(driver, connDeletePopupTitle, connSingledeletePopupTitle);

					flag = verifyIndividualLabel(driver, connectionDeletePopUpContent, connSingledeletePopupContentMsg);

					flag = verifyVisibilityOfButtons(driver,
							returnElement(connectionDeletePopupBtn, dynamicName,
									ConstantProperty.CONNECTION_DELETE_BTN_TEXT),
							ConstantProperty.CONNECTION_DELETE_BTN_TEXT, true);

					flag = verifyVisibilityOfButtons(driver,
							returnElement(connectionDeletePopupBtn, dynamicName,
									ConstantProperty.CONNECTION_CANCEL_BTN_TEXT),
							ConstantProperty.CONNECTION_CANCEL_BTN_TEXT, true);
				}

				flag = clickOnButton(driver,
						returnElement(connectionDeletePopupBtn, dynamicName,
								ConstantProperty.CONNECTION_DELETE_BTN_TEXT),
						ConstantProperty.CONNECTION_DELETE_BTN_TEXT, true);

				inVisible(driver, spinner, Constant.ruleWait);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				flag = captureToastMsg(driver, toastMsg, popUpClose, toastMessage, "Connection Delete");

			} else {
				flag = false;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;
	}

	/** Duplicate connection method **/

	public boolean clickOnDuplicateConnection(String extoastMsg) {

		boolean flag = false;

		try {
			flag = clickOnButton(driver, connDuplicateButton, "Duplicate", true);
			inVisible(driver, spinner, Constant.ruleWait);
			if (isDisplayed(driver, toastMsg) && flag) {
				flag = captureToastMsg(driver, toastMsg, popUpClose, extoastMsg, "Connection Duplicate");
			} else {
				//
			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog("due to exception kindly check " + e.toString());
		}

		return flag;
	}

	/** Duplicate Flat file native connection using API test data **/
	public boolean duplicateFlatFileNativeConnectionMethod(String connJsonEntity, String icedqUser) {
		boolean flag = false;
		String name = null;
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);
			Thread.sleep(3000);
			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				viewFlatFileNativeConnectionMethod(connJsonEntity, icedqUser);
			}
			if (icedqUser.contains("owner")) {

				flag = clickOnDuplicateConnection(connDupllicateToastMsg);

				inVisible(driver, spinner, Constant.ruleWait);

				if (flag) {
					name = getAttribute(driver, connName, valueAttribute);

					clickOnConnectionsTab();

					flag = searchConnection(name);
				}
			} else {
				flag = clickOnDuplicateConnection(forbiddenToastMsg);
			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog("due to exception kindly check " + e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;
	}

	/** Flat file Native S3 Location Common methods **/

	/** Select file type method **/
	public void selectFileTypeOfFlatFileNativeConnection(String fileType) {

		try {
			String authValue = null;
			isDisplayedInLoop(driver, 2, connFlatFileTypeLabel);

			javascript(driver, scrollToElementArg, connFlatFileTypeLabel);

			verifyIndividualLabel(driver, connFlatFileTypeLabel, "File Type ");

			if (isDisplayed(driver, connFlatFileTypeField)) {

				BaseSuite.validationReportLog("File Type field is visible ");

				authValue = getAttribute(driver, connFlatFileTypeField, valueAttribute);

				BaseSuite.reportLog("Default File type selected as : " + authValue);

				isDisplayedInLoop(driver, 2, connFlatFileTypeDDBtn);

				if (isDisplayed(driver, connFlatFileTypeDDBtn)) {

					displayAndClick(driver, connFlatFileTypeDDBtn);

					BaseSuite.validationReportLog(
							"Clicked on Location drop down " + ConstantProperty.SUCCESSSTRING + "");

					BaseSuite.reportLog("Checking list of File type visible");
					Thread.sleep(2000);
					List<WebElement> authList = getElements(driver, connFlatFileLocationDDList);

					for (int i = 0; i < authList.size(); i++) {

						String authName = authList.get(i).getAttribute("data-value");

						BaseSuite.reportLog((i + 1) + ". " + authName + " is visible");

					}
				}

				isDisplayedInLoop(driver, 4, returnElement(connFlatFileSelectLocation, dynamicName, fileType));

				if (isDisplayed(driver, returnElement(connFlatFileSelectLocation, dynamicName, fileType))) {

					displayAndClick(driver, returnElement(connFlatFileSelectLocation, dynamicName, fileType));

					authValue = getAttribute(driver, connFlatFileLocationField, valueAttribute);

					if (!authValue.isEmpty()) {
						BaseSuite.validationReportLog("File type selected as : " + authValue);
					}

				} else {
					BaseSuite.reportFailLog("Expected File type not found kindly check",
							"selectFileTypeOfFlatFileNativeConnection");
				}

			} else {
				BaseSuite.reportFailLog("File type field not visible ", " selectFileTypeOfFlatFileNativeConnection");
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			e.getMessage();
			throw new NoSuchElementException();
		}
	}

	/** enter container method **/
	public void enterContainerForFileConnection(String container) throws NoSuchElementException {

		try {
			isDisplayedInLoop(driver, 4, connFlatFileContainerLabel);

			javascript(driver, scrollToElementArg, connFlatFileContainerLabel);

			verifyIndividualLabel(driver, connFlatFileContainerLabel, "Container ");

			if (isDisplayed(driver, connFlatFileContainerField)) {

				isClickable(driver, connFlatFileContainerField, " Container", true);

				if (isEditable(driver, connFlatFileContainerField, " Container ")) {

					clear(driver, connFlatFileContainerField);

					validationMessageOfField(connFlatFileContainerFieldValidation, "Folder path",
							containerEmptyValidationMsg, true);

					String ph = getAttribute(driver, connFlatFileContainerField, placeHolderAttribute);

					if (!ph.isEmpty() && ph.equalsIgnoreCase(containerPlaceHolder)) {

						BaseSuite.reportLog("Folder path field place holder : " + ph);

					} else {

						BaseSuite.reportFailLog("Container field place holder not found : Actual :" + ph
								+ "  and Expected : " + containerPlaceHolder, " enterContainerForFileConnection");
					}

					BaseSuite.reportLog("Entering value : " + container);

					sendKeys(driver, connFlatFileContainerField, container);

					String ac = getAttribute(driver, connFlatFileContainerField, valueAttribute);

					stringContainsOutput(ac, container, true);

					validationMessageOfField(connFlatFileContainerFieldValidation, "Container",
							containerEmptyValidationMsg, false);

				} else {
					BaseSuite.reportFailLog("Container field not editable", "enterContainerForFileConnection");
				}
			} else {
				BaseSuite.reportFailLog("Container field not displayed", "enterContainerForFileConnection");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Exception found : " + e.getMessage());
			throw new NoSuchElementException();
		}
	}

	/** enter region method **/
	public void enterRegionForFileConnection(String region) throws NoSuchElementException {

		try {
			isDisplayedInLoop(driver, 4, connFlatFileRegionLabel);

			javascript(driver, scrollToElementArg, connFlatFileRegionLabel);

			verifyIndividualLabel(driver, connFlatFileRegionLabel, " Region");

			if (isDisplayed(driver, connFlatFileRegionField)) {

				isClickable(driver, connFlatFileRegionField, " Region", true);

				if (isEditable(driver, connFlatFileRegionField, " Region ")) {

					clear(driver, connFlatFileRegionField);

					validationMessageOfField(connFlatFileRegionFieldValidation, "Region", regionEmptyValidationMsg,
							true);

					String ph = getAttribute(driver, connFlatFileRegionField, placeHolderAttribute);

					if (!ph.isEmpty() && ph.equalsIgnoreCase(regionPlaceHolder)) {

						BaseSuite.reportLog("Region field place holder : " + ph);

					} else {

						BaseSuite.reportFailLog("Region field place holder not found : Actual :" + ph
								+ " and  Expected : " + regionPlaceHolder, " enterFolderPathForFileConnection");
					}

					BaseSuite.reportLog("Entering value : " + region);

					sendKeys(driver, connFlatFileRegionField, region);

					String ac = getAttribute(driver, connFlatFileRegionField, valueAttribute);

					stringContainsOutput(ac, region, true);

					validationMessageOfField(connFlatFileRegionFieldValidation, "Region", regionEmptyValidationMsg,
							false);

				} else {
					BaseSuite.reportFailLog("Region field not editable", "enterRegionForFileConnection");
				}
			} else {
				BaseSuite.reportFailLog("Region field not displayed", "enterRegionForFileConnection");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Exception found : " + e.getMessage());
			throw new NoSuchElementException();
		}
	}

	/** enter access key method **/
	public void enterAccessKeyForFileConnection(String accessKey) throws NoSuchElementException {

		try {
			isDisplayedInLoop(driver, 4, connFlatFileAccesskeyLabel);

			javascript(driver, scrollToElementArg, connFlatFileAccesskeyLabel);

			verifyIndividualLabel(driver, connFlatFileAccesskeyLabel, " Access Key");

			if (isDisplayed(driver, connFlatFileAccesskeyField)) {

				isClickable(driver, connFlatFileAccesskeyField, " Access Key", true);

				if (isEditable(driver, connFlatFileAccesskeyField, " Access Key ")) {

					clear(driver, connFlatFileAccesskeyField);

					validationMessageOfField(connFlatFileAccesskeyFieldValidation, "Access key",
							accesskeyEmptyValidationMsg, true);

					String ph = getAttribute(driver, connFlatFileAccesskeyField, placeHolderAttribute);

					if (!ph.isEmpty() && ph.equalsIgnoreCase(accesskeyPlaceHolder)) {

						BaseSuite.reportLog("Access Key field place holder : " + ph);

					} else {

						BaseSuite.reportFailLog("Access Key field place holder not found : Actual :" + ph
								+ " and Expected :  " + accesskeyPlaceHolder, " enterAccessKeyForFileConnection");
					}

					BaseSuite.reportLog("Entering value : " + accessKey);

					sendKeys(driver, connFlatFileAccesskeyField, accessKey);

					String ac = getAttribute(driver, connFlatFileAccesskeyField, valueAttribute);

					stringContainsOutput(ac, accessKey, true);

					validationMessageOfField(connFlatFileAccesskeyFieldValidation, "Access Key",
							accesskeyEmptyValidationMsg, false);

				} else {
					BaseSuite.reportFailLog("Access Key field not editable", "enterAccessKeyForFileConnection");
				}
			} else {
				BaseSuite.reportFailLog("Access Key field not displayed", "enterAccessKeyForFileConnection");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Exception found : " + e.getMessage());
			throw new NoSuchElementException();
		}
	}

	/** enter secret key method **/
	public void enterSecretKeyForFileConnection(String secretKey) throws NoSuchElementException {

		try {
			isDisplayedInLoop(driver, 4, connFlatFileSecretkeyLabel);

			javascript(driver, scrollToElementArg, connFlatFileSecretkeyLabel);

			verifyIndividualLabel(driver, connFlatFileSecretkeyLabel, " Secret Key");

			if (isDisplayed(driver, connFlatFileSecretkeyField)) {

				isClickable(driver, connFlatFileSecretkeyField, " Secret Key", true);

				if (isEditable(driver, connFlatFileSecretkeyField, " Secret Key ")) {

					clear(driver, connFlatFileSecretkeyField);

					validationMessageOfField(connFlatFileSecretkeyFieldValidation, "Secret key",
							secretkeyEmptyValidationMsg, true);

					String ph = getAttribute(driver, connFlatFileSecretkeyField, placeHolderAttribute);

					if (!ph.isEmpty() && ph.equalsIgnoreCase(secretkeyPlaceHolder)) {

						BaseSuite.reportLog("Secret Key field place holder : " + ph);

					} else {

						BaseSuite.reportFailLog("Secret Key field place holder not found : Actual : " + ph
								+ " and Expected  : " + secretkeyPlaceHolder, " enterSecretKeyForFileConnection");
					}

					BaseSuite.reportLog("Entering value : " + secretKey);

					sendKeys(driver, connFlatFileSecretkeyField, secretKey);

					String ac = getAttribute(driver, connFlatFileSecretkeyField, valueAttribute);

					stringContainsOutput(ac, secretKey, true);

					validationMessageOfField(connFlatFileSecretkeyFieldValidation, "Secret Key",
							secretkeyEmptyValidationMsg, false);

				} else {
					BaseSuite.reportFailLog("Secret Key field not editable", "enterSecretKeyForFileConnection");
				}
			} else {
				BaseSuite.reportFailLog("Secret Key field not displayed", "enterSecretKeyForFileConnection");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Exception found : " + e.getMessage());
			throw new NoSuchElementException();
		}
	}

	public boolean validatAndeEnterValueToTextField(By labelLocator, By fieldLocator, String label, String placeHolder,
			String input, String fieldValidation) throws NoSuchElementException {
		boolean flag = true;
		try {
			isDisplayedInLoop(driver, 4, labelLocator);

			javascript(driver, scrollToElementArg, labelLocator);

			verifyIndividualLabel(driver, labelLocator, label);

			if (isDisplayed(driver, fieldLocator)) {

				isClickable(driver, fieldLocator, label, true);

				if (!placeHolder.isEmpty()) {
					String ph = getAttribute(driver, fieldLocator, placeHolderAttribute);

					if (!ph.isEmpty() && ph.equalsIgnoreCase(placeHolder)) {

						BaseSuite.reportLog(label + " field place holder : " + ph);

					} else {

						BaseSuite.reportFailLog("Secret Key field place holder not found : Actual :" + ph
								+ " and Expected : " + placeHolder, " validatAndeEnterValueToTextField");
					}
				}
				if (!input.isEmpty()) {
					click(driver, fieldLocator);

					clear(driver, fieldLocator);

					validationMessageOfField(returnElement(connCommonFieldValidation, dynamicName, label.toLowerCase()),
							label, fieldValidation, true);

					BaseSuite.reportLog("Entering value : " + input);

					sendKeys(driver, fieldLocator, input);

					String ac = getAttribute(driver, fieldLocator, valueAttribute);

					flag = stringContainsOutput(ac, input, true);

					validationMessageOfField(returnElement(connCommonFieldValidation, dynamicName, label.toLowerCase()),
							label, fieldValidation, false);
				}
			} else {
				flag = false;
				BaseSuite.reportFailLog(label + " field not displayed", "validatAndeEnterValueToTextField");
			}
		} catch (Exception e) {

			BaseSuite.reportErrorLog("Exception found : " + e.getMessage());
			throw new NoSuchElementException();
		}
		return flag;
	}

	public static String sybaseValueChanger(int i, String type) throws Exception {
		String temp;

		try {

			String[] specificvalue = ConstantProperty.SYBASEASE.split(",");

			if (i == 0) {
				temp = specificvalue[i];

			} else if (i == 1) {
				temp = specificvalue[i];

			} else {
				temp = specificvalue[i];

			}

		} catch (Exception e) {

			throw new NoSuchElementException();
		}
		return temp;

	}

	public boolean validateFieldOfConnection(By labelLocator, By fieldLocator, String label, String placeHolder,
			boolean state) {

		boolean flag = true;

		try {
			isDisplayedInLoop(driver, 4, labelLocator);

			javascript(driver, scrollToElementArg, labelLocator);

			verifyIndividualLabel(driver, labelLocator, label);

			if (isDisplayed(driver, fieldLocator)) {

				isClickable(driver, fieldLocator, label, state);

				if (!placeHolder.isEmpty()) {

					String ph = getAttribute(driver, fieldLocator, placeHolderAttribute);

					if (!ph.isEmpty() && ph.equalsIgnoreCase(placeHolder)) {

						BaseSuite.reportLog(label + " field place holder : " + ph);

					} else {

						BaseSuite.reportFailLog("Secret Key field place holder not found : Actual :" + ph
								+ " and Expected : " + placeHolder, " validatAndeEnterValueToTextField");
					}
				}
			} else {
				flag = false;
				BaseSuite.reportFailLog(label + " field not displayed", "validatAndeEnterValueToTextField");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Exception found : " + e.getMessage());
			throw new NoSuchElementException();
		}

		return flag;

	}

	/** Validate and select driver type of flat file connection **/

	public void selectDriverOfFlatFileNativeConnection(String driverName) {

		try {
			String authValue = null;

			isDisplayedInLoop(driver, 2, connFlatFileDriverLabel);

			// driverName = setConnectorIdToConnectorName(driverName);

			javascript(driver, scrollToElementArg, connFlatFileDriverLabel);

			verifyIndividualLabel(driver, connFlatFileDriverLabel, ConstantProperty.CONN_FIELD_LOCATION);

			if (isDisplayed(driver, connFlatFileDriverField)) {

				BaseSuite.validationReportLog("Driver field is visible ");

				authValue = getAttribute(driver, connFlatFileDriverField, valueAttribute);

				if (!authValue.isEmpty()) {

					BaseSuite.reportLog("Default Driver type selected as : " + authValue);
				} else {
					BaseSuite.reportFailLog(
							"Default Driver Name is empty :: https://icedqsoft.atlassian.net/browse/DAT-5789",
							"selectDriverOfFlatFileNativeConnection");
				}
				isDisplayedInLoop(driver, 2, connFlatFileDriverDDBtn);

				if (isDisplayed(driver, connFlatFileDriverDDBtn)) {

					displayAndClick(driver, connFlatFileDriverDDBtn);

					BaseSuite.validationReportLog(
							"Clicked on Location drop down " + ConstantProperty.SUCCESSSTRING + "");

					BaseSuite.reportLog("Checking list of location type visible");
					Thread.sleep(1000);
					List<WebElement> authList = getElements(driver, connFlatFileDriverDDList);

					for (int i = 0; i < authList.size(); i++) {

						String authName = authList.get(i).getAttribute("data-value");

						BaseSuite.reportLog((i + 1) + ". " + authName + " is visible");

					}
				}

				isDisplayedInLoop(driver, 4, returnElement(connselectDriver, dynamicName, driverName));

				if (isDisplayed(driver, returnElement(connselectDriver, dynamicName, driverName))) {

					displayAndClick(driver, returnElement(connselectDriver, dynamicName, driverName));

					authValue = getAttribute(driver, connFlatFileDriverField, valueAttribute);

					if (!authValue.isEmpty()) {
						BaseSuite.validationReportLog("Driver type selected as : " + authValue);
					}

				} else {
					BaseSuite.reportFailLog("Expected Driver type not found kindly check",
							"selectDriverOfFlatFileNativeConnection");
				}

			} else {
				BaseSuite.reportFailLog("Driver field not visible ", "selectDriverOfFlatFileNativeConnection1");
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			e.getMessage();
			throw new NoSuchElementException();
		}
	}

	/** create flat file native connection with invalid data **/
	public boolean createFlatFileNativeConnectionMethodForInvalidData(String connJsonEntity, String scenario,
			String onSaveMessage, String onfieldMessage, String icedqUser) throws Exception {

		boolean flag = true;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			String accessKey = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 3);

			String secretKey = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 4);

			String accountName = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 5);

			String accountKey = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 6);

			connectionRepositoryLandingPage();

			flag = clickOnNewConnectionBtn(icedqUser);

			if (flag) {

				chooseConnectorType(connParam.getConnectorID());

				inVisible(driver, spinner, Constant.ruleWait);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				boolean status = enterConnectionNameWithValidation(connParam.getConnName(), scenario, onfieldMessage);

				if (status) {

					selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

					selectLocationOfFlatFileNativeConnection(connParam.getServiceProviderName());

					switch (connParam.getServiceProviderName().trim().toLowerCase()) {

					case "local":

						enterFolderPathForFileConnection(connParam.getFolderPath());

						break;

					case "s3":

						selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());

						selectAuthenticationOfConnection(connParam.getAuthenticationname());

						validatAndeEnterValueToTextField(connFlatFileContainerLabel, connFlatFileContainerField,
								ConstantProperty.CONN_FIELD_CONTAINER, containerPlaceHolder, connParam.getContainer(),
								containerEmptyValidationMsg);

						validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,
								ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder,
								connParam.getFolderPath(), folderPathEmptyValidationMsg);

						validatAndeEnterValueToTextField(connFlatFileRegionLabel, connFlatFileRegionField,
								ConstantProperty.CONN_FIELD_REGION, regionPlaceHolder, connParam.getRegionValue(),
								regionEmptyValidationMsg);

						selectConnectionType(connParam.getType());

						if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

							validatAndeEnterValueToTextField(connFlatFileAccesskeyLabel, connFlatFileAccesskeyField,
									ConstantProperty.CONN_FIELD_ACCESSKEY, accesskeyPlaceHolder, accessKey,
									accesskeyEmptyValidationMsg);

							validatAndeEnterValueToTextField(connFlatFileSecretkeyLabel, connFlatFileSecretkeyField,
									ConstantProperty.CONN_FIELD_SECRETKEY, secretkeyPlaceHolder, secretKey,
									secretkeyEmptyValidationMsg);

						}
						break;

					case "azure blob":

						selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());

						selectAuthenticationOfConnection(connParam.getAuthenticationname());

						validatAndeEnterValueToTextField(connFlatFileContainerLabel, connFlatFileContainerField,
								ConstantProperty.CONN_FIELD_CONTAINER, containerPlaceHolder, connParam.getContainer(),
								containerEmptyValidationMsg);

						validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,
								ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder,
								connParam.getFolderPath(), folderPathEmptyValidationMsg);

						selectConnectionType(connParam.getType());

						if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

							validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
									ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, accountName,
									accountNameEmptyValidationMsg);

							validatAndeEnterValueToTextField(connFlatFileAccountKeyLabel, connFlatFileAccountKeyField,
									ConstantProperty.CONN_FIELD_ACCOUNTKEY, accountKeyPlaceHolder, accountKey,
									accountKeyEmptyValidationMsg);

						}
						break;

					default:

						BaseSuite.reportLog("Location not found :: " + connParam.getServiceProviderName());
						break;

					}
					flag = saveConnection(onSaveMessage);
				}
			}
		} catch (RuntimeException e) {
			flag = false;
			BaseSuite.reportErrorLog("Connection not created properly due to exception kindly check " + e.toString());

		}
		return flag;

	}

	/**
	 * Enter connection name method - state is for valid / invalid connection name
	 * field if state = true then valid data else invalid data
	 **/
	public boolean enterConnectionNameWithValidation(String connectionName, String state, String validationMessage)
			throws NoSuchElementException {

		String methodName = "enterConnectionName";
		boolean flag = false;
		try {
			isDisplayedInLoop(driver, 4, connName);

			javascript(driver, scrollToElementArg, connNameLabel);

			verifyIndividualLabel(driver, connNameLabel, Constant.CONNECTIONNAME);

			isClickable(driver, connName, Constant.CONNECTIONNAME + " field", true);

			if (isEditable(driver, connName, Constant.CONNECTIONNAME + " field")) {

				click(driver, connName);

				clear(driver, connName);

				BaseSuite.reportLog("Entering value : " + connectionName);
				if (!connectionName.isEmpty()) {
					sendKeys(driver, connName, connectionName);
				} else {
					sendKeys(driver, connName, "emptyvalue");
					clear(driver, connName);
				}
				String ac = getAttribute(driver, connName, valueAttribute);
				stringContainsOutput(ac, connectionName, true);

				if (validationMessage.isEmpty()) {
					validationMessageOfField(connectionNameValidation, "Connection name", "", false);

				} else {
					String acmesg = validationMessageOfField(connectionNameValidation, "Connection name",
							validationMessage, true);
					if (validationMessage.equalsIgnoreCase(acmesg)) {
						flag = true;
					} else {
						flag = false;
					}
				}

			} else {
				BaseSuite.reportFailLog(Constant.CONNECTIONNAME + " field not editable", methodName);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog("Exception found : " + e.getMessage());
			throw new NoSuchElementException();
		}
		return flag;
	}

	public ConnectionPoJO setConnParametersForInvalid(String fileName, String sheetName, int rowNumber) {
		ConnectionPoJO connectionparam = new ConnectionPoJO();
		XLUtils xl = new XLUtils();

		try {

			connectionparam.setTestScenario(xl.readUsingColName(fileName, sheetName, rowNumber, "TestScenario"));
			connectionparam.setFieldName(xl.readUsingColName(fileName, sheetName, rowNumber, "FieldName"));
			connectionparam.setConnectionJsonValue(
					xl.readUsingColName(fileName, sheetName, rowNumber, "ConnectionJsonForLocal"));
			connectionparam
					.setValidationMessage(xl.readUsingColName(fileName, sheetName, rowNumber, "ValidationMessage"));
			connectionparam
					.setOnSaveValidation(xl.readUsingColName(fileName, sheetName, rowNumber, "OnSaveValidation"));
			connectionparam
					.setOnTestValidation(xl.readUsingColName(fileName, sheetName, rowNumber, "OnTestValidation"));
			connectionparam.setConnectionJsonValueS3(
					xl.readUsingColName(fileName, sheetName, rowNumber, "ConnectionJsonForS3"));
			connectionparam.setConnectionJsonValueAzure(
					xl.readUsingColName(fileName, sheetName, rowNumber, "ConnectionJsonForAzure"));

			// *Rahul's param**//

			connectionparam.setScenario(xl.readUsingColName(fileName, sheetName, rowNumber, "scenario"));
			connectionparam
					.setGenericFieldName(xl.readUsingColName(fileName, sheetName, rowNumber, "GenericFieldName"));
			connectionparam.setConnectionJson(xl.readUsingColName(fileName, sheetName, rowNumber, "ConnectionJson"));
			connectionparam.setValidationMesg(xl.readUsingColName(fileName, sheetName, rowNumber, "ValidationMesg"));
			connectionparam.setOnSaveValidate(xl.readUsingColName(fileName, sheetName, rowNumber, "OnSaveValidate"));
			connectionparam.setOnTestValidate(xl.readUsingColName(fileName, sheetName, rowNumber, "OnTestValidate"));

			return connectionparam;
		} catch (Exception e) {
			throw new NullPointerException(e.toString());
		}
	}

	/** create flat file native connection with invalid data **/
	public boolean updateFlatFileNativeConnectionMethodForInvalidData(String connJsonEntity, String scenario,
			String onSaveMessage, String onfieldMessage, String icedqUser) throws Exception {

		boolean flag = true;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			String accessKey = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 3);

			String secretKey = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 4);

			String accountName = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 5);

			String accountKey = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 6);

			boolean status = enterConnectionNameWithValidation(connParam.getConnName(), scenario, onfieldMessage);

			if (status) {

				selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

				selectLocationOfFlatFileNativeConnection(connParam.getServiceProviderName());

				switch (connParam.getServiceProviderName().trim().toLowerCase()) {

				case "local":

					enterFolderPathForFileConnection(connParam.getFolderPath());

					break;

				case "s3":

					selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());

					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					validatAndeEnterValueToTextField(connFlatFileContainerLabel, connFlatFileContainerField,
							ConstantProperty.CONN_FIELD_CONTAINER, containerPlaceHolder, connParam.getContainer(),
							containerEmptyValidationMsg);

					validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,
							ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder, connParam.getFolderPath(),
							folderPathEmptyValidationMsg);

					validatAndeEnterValueToTextField(connFlatFileRegionLabel, connFlatFileRegionField,
							ConstantProperty.CONN_FIELD_REGION, regionPlaceHolder, connParam.getRegionValue(),
							regionEmptyValidationMsg);

					selectConnectionType(connParam.getType());

					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						validatAndeEnterValueToTextField(connFlatFileAccesskeyLabel, connFlatFileAccesskeyField,
								ConstantProperty.CONN_FIELD_ACCESSKEY, accesskeyPlaceHolder, accessKey,
								accesskeyEmptyValidationMsg);

						validatAndeEnterValueToTextField(connFlatFileSecretkeyLabel, connFlatFileSecretkeyField,
								ConstantProperty.CONN_FIELD_SECRETKEY, secretkeyPlaceHolder, secretKey,
								secretkeyEmptyValidationMsg);

					}
					break;

				case "azure blob":

					selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());

					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					validatAndeEnterValueToTextField(connFlatFileContainerLabel, connFlatFileContainerField,
							ConstantProperty.CONN_FIELD_CONTAINER, containerPlaceHolder, connParam.getContainer(),
							containerEmptyValidationMsg);

					validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,
							ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder, connParam.getFolderPath(),
							folderPathEmptyValidationMsg);

					selectConnectionType(connParam.getType());

					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
								ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, accountName,
								accountNameEmptyValidationMsg);

						validatAndeEnterValueToTextField(connFlatFileAccountKeyLabel, connFlatFileAccountKeyField,
								ConstantProperty.CONN_FIELD_ACCOUNTKEY, accountKeyPlaceHolder, accountKey,
								accountKeyEmptyValidationMsg);

					}
					break;

				default:

					BaseSuite.reportLog("Location not found :: " + connParam.getServiceProviderName());
					break;

				}
				if (icedqUser.toLowerCase().contains("owner")) {
					flag = saveConnection(onSaveMessage);
				}
			}

		} catch (RuntimeException e) {
			flag = false;
			BaseSuite.reportErrorLog("Connection not created properly due to exception kindly check " + e.toString());

		}
		return flag;

	}

	/** Test Flat file native connection using API Invalid test data **/
	public boolean testFlatFileNativeConnectionMethodForInvalidData(ConnectionPoJO connParam, String authtype,
			String icedqUser) {
		boolean flag = true;

		try {

			inVisible(driver, spinner, Constant.ruleWait);

			Thread.sleep(3000);
			String s = connParam.getConnectionJsonValueS3();
			String[] a = s.split(";");

			String x = connParam.getConnectionJsonValueAzure();
			String[] b = x.split(";");

			String accessKey = a[0];

			String secretKey = a[1];

			String accountName = b[0];

			String accountKey = b[1];

			if (authtype.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)) {

				validatAndeEnterValueToTextField(connFlatFileAccesskeyLabel, connFlatFileAccesskeyField,
						ConstantProperty.CONN_FIELD_ACCESSKEY, accesskeyPlaceHolder, accessKey,
						accesskeyEmptyValidationMsg);

				validatAndeEnterValueToTextField(connFlatFileSecretkeyLabel, connFlatFileSecretkeyField,
						ConstantProperty.CONN_FIELD_SECRETKEY, secretkeyPlaceHolder, secretKey,
						secretkeyEmptyValidationMsg);

			} else if (authtype.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {

				validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
						ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, accountName,
						accountNameEmptyValidationMsg);

				validatAndeEnterValueToTextField(connFlatFileAccountKeyLabel, connFlatFileAccountKeyField,
						ConstantProperty.CONN_FIELD_ACCOUNTKEY, accountKeyPlaceHolder, accountKey,
						accountKeyEmptyValidationMsg);

			}
			saveConnection();

			if (!icedqUser.contains("reader") && !authtype.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_LOCAL)) {

				clickOnButton(driver, connTestBtn, "Test", true);

				inVisible(driver, spinner, 10);

				flag = captureToastMsgForConnection(driver, toastMsg, popUpClose, connectionTestMess, "Connection Test",
						false);
			} else {

				flag = false;

			}

		} catch (Exception e) {
			flag = false;

			BaseSuite.reportFailLog("Application spinner taking more time to invisible than stardard time",
					"testFlatFileNativeConnectionMethodForInvalidData");

			driver.navigate().refresh();

			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

			BaseSuite.reportErrorLog(" due to exception kindly check " + e.toString());

			Thread.currentThread().interrupt();
		} finally {
			clickOnConnectionRepoBreadcrumbLink();
		}
		return flag;
	}

	public boolean captureToastMsgForConnection(WebDriver driver, By locator1, By locator2, String mess, String label,
			boolean status) {
		String validMess;
		String methodName = "captureToastMsgForConnection";
		boolean flag = true;
		try {

			BaseSuite.reportLog("Verifying " + label + " Message");

			Actions actions = new Actions(driver);

			wait = waitMethod(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(locator1));

			actions.moveToElement(driver.findElement(locator1)).perform();

			validMess = getText(driver, locator1).trim();

			if (validMess.isEmpty()) {
				validMess = getAttribute(driver, locator1, "textContent");
			}

			actions.click(driver.findElement(locator2)).build().perform();

			SoftAssert s = new SoftAssert();

			s.assertEquals(validMess.trim(), mess.trim());

			BaseSuite.validationReportLog("Retrived Message for " + label + " is :" + validMess);

			BaseSuite.validationReportLog("Expected Message for " + label + " is :" + mess.trim());

			if (!validMess.isEmpty()) {
				if (status) {
					if (validMess.trim().equalsIgnoreCase(mess.trim())) {

						BaseSuite.validationReportLog("Expected condition Successfully Matched");
					} else {
						BaseSuite.reportFailLog("Expected condition didn't match", methodName);
						flag = false;
					}
				} else {

					if (!validMess.trim().equalsIgnoreCase(mess.trim())) {

						BaseSuite.validationReportLog("Expected condition Successfully Matched");
					} else {
						BaseSuite.reportFailLog("Expected condition Messages didn't match", methodName);
						flag = false;
					}
				}
			} else {
				BaseSuite.reportFailLog(label + " Messages didn't match", methodName);
				flag = false;
			}
		} catch (Exception e) {
			e.getMessage();
			BaseSuite.reportFailLog(label + " Messages didn't found kindly check, captureToastMsg", methodName);
			flag = false;
		}
		return flag;
	}

	/** ====== Flat File Native Code Ends here ====== **/

	/** create database connection method **/
	/** testScenario = "Valid/Invalid" , ValidationMessage blank for valid name **/
	public boolean createDatabaseConnection(String connJsonEntity, String testScenario, String validationMessage,
			String icedqUser) {
		boolean flag = true;
		String newconnectionName = null;
		NewConnectionRepoPage np = new NewConnectionRepoPage(driver);
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			String timestamp = new SimpleDateFormat(ConstantProperty.CONNECTIONNAME_TIMESTAMPFORMAT).format(new Date());

			newconnectionName = connParam.getConnName() + "_" + BaseSuite.WorkspaceName + "_" + timestamp;

			String connusername = np.getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

			String connpassword = np.getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 2);

			// np.connectionRepositoryLandingPage();

			flag = np.clickOnNewConnectionBtn(icedqUser);

			if (flag) {

				np.chooseConnectorType(connParam.getConnectorID());

				inVisible(driver, spinner, Constant.ruleWait);
				
				String wizardStatus = cp.validateNewConnPageButtonsFields(connParam.getConnectorID());
				
				if (wizardStatus.contains("Wizard supported connector")) {
					
					verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", false);
				}
				
				verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

				verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);

				verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

				verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", false);

				verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", false);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				np.enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

				np.selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

				np.selectAuthenticationOfConnection(connParam.getAuthenticationname());

				boolean cs = np.selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

				enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());

				if (cs) {

					np.validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
							connHostPlaceholder, false);
					np.validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
							connPortPlaceholder, false);
					np.validateInputFieldVisibility(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
							connDatabasePlaceHolder, false);

				} else {

					np.validatAndeEnterValueToTextField(connHostTitle, connHostInputField,
							ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder, connParam.getHost(),
							validationHostEmpty);

					np.validatAndeEnterValueToTextField(connPortTitle, connPortInputField,
							ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder, connParam.getPort(),
							validationPortEmpty);

					np.validatAndeEnterValueToTextField(connDatabaseTitle, connDatabaseInputField,
							ConstantProperty.CONN_FIELD_DATABASE, connDatabasePlaceholder, connParam.getDatabaseName(),
							validationDatabaseEmpty);
				}

				np.selectConnectionType(connParam.getType());

				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					np.enterUsername(connusername);

					np.enterPassword(connpassword);

				} else {

					np.validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME,
							connUsernamePlaceholder, false);
					np.validateInputFieldVisibility(connPasswordInput, ConstantProperty.CONN_FIELD_PASSWORD,
							connPasswordPlaceholder, false);

				}

				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

				int count = connPropertyList.size();

				np.addConnectionPropertiesToConnection(connJsonEntity, count);

				if (icedqUser.toLowerCase().contains("owner")) {

					flag = np.saveConnection(connectionSaveMesssage);

					if (flag) {

						updateUsernameAndPasswordForUserConnection("create", connParam.getType(), newconnectionName,
								connusername, connpassword, icedqUser);
					}
				} else {

					flag = np.saveConnection(forbiddenToastMsg);
				}
			}
		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not created properly kindly check :" + e.toString());
		}
		return flag;
	}

	public boolean updateUsernameAndPasswordForUserConnection(String scenario, String connectionType,
			String connectionName, String username, String password, String icedqUser) {
		boolean flag = true;
		NewConnectionRepoPage np = new NewConnectionRepoPage(driver);

		try {
			if (!icedqUser.toLowerCase().contains("reader")) {

				if (connectionType.trim().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

					Thread.sleep(1000);

					if (scenario.equalsIgnoreCase("create")) {

						np.clickOnUserConnectionTab();

						np.searchAndClickOnConnectionNameInConnRepo(connectionName);

						inVisible(driver, spinner, Constant.ruleWait);
						Thread.sleep(2000);
					}

					np.enterUsername(username);

					np.enterPassword(password);

					Thread.sleep(1000);

					np.saveConnection();

					flag = np.testConnection(connectionTestMess);

				} else {

					flag = np.testConnection(connectionTestMess);
				}
			} else {
				Thread.sleep(3000);

				np.enterUsername(username);

				np.enterPassword(password);

				flag = np.saveConnection(forbiddenToastMsg);
			}
		} catch (Exception e) {

			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("user connection not updated properly kindly check :" + e.toString());
		}

		return flag;
	}

	/** View DataBase connection details method **/

	public boolean viewDatabaseConnection(String connJsonEntity, String driverName) {
		boolean flag = true;
		NewConnectionRepoPage np = new NewConnectionRepoPage(driver);
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);

		try {
			ConnectionPoJO connParam = np.setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);
			
			String wizardStatus = cp.validateExistingConnPageButtonsFields(connJsonEntity);
			
			if (wizardStatus.contains("Wizard supported connector")) {
				
				verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", false);
			}
			
			verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

			verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", true);

			verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

			verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", true);

			verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", true);

			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				inVisible(driver, spinner, Constant.ruleWait);

				np.viewAndValidateConnectionField(connName, "Connection Name", connParam.getConnName(), true);

				np.viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, true);

				np.viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
						connParam.getAuthenticationname(), true);

				verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

				if (connParam.getCustomJdbcFullUrl().equalsIgnoreCase(booleanTrue)) {

					np.viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
							connParam.getCustomJDBCURLValue(), true);

					np.viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST, "", false);

					np.viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT, "", false);

					np.viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE, "",
							false);

				} else {

					np.viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
							connParam.getCustomJDBCURLValue(), false);

					np.viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
							connParam.getHost(), true);

					np.viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
							connParam.getPort(), true);

					np.viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
							connParam.getDatabaseName(), true);
				}

				np.validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "", true);

				np.validateInputFieldVisibility(connPasswordInput, ConstantProperty.CONN_FIELD_PASSWORD, "", true);

				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

				int count = connPropertyList.size();

				flag = viewAndValidateConnectionPropertiesToConnection(connJsonEntity, count);

			} else {

				inVisible(driver, spinner, Constant.ruleWait);

				np.viewAndValidateConnectionField(connName, "Connection Name", connParam.getConnName(), false);

				np.viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, false);

				np.viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
						connParam.getAuthenticationname(), false);

				verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

				np.viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
						connParam.getCustomJDBCURLValue(), false);

				np.viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
						connParam.getHost(), false);

				np.viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
						connParam.getPort(), false);

				np.viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
						connParam.getDatabaseName(), false);

				np.validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "", true);

				np.validateInputFieldVisibility(connPasswordInput, ConstantProperty.CONN_FIELD_PASSWORD, "", true);

				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

				int count = connPropertyList.size();

				flag = viewAndValidateConnectionPropertiesToConnection(connJsonEntity, count);

			}

		} catch (Exception e) {

			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("connection not visible properly kindly check :" + e.toString());
		}
		return flag;
	}

	/** Enable custom JDBC URL check box method **/

	public boolean verifyCustomJDBCURLCheckboxOfConnection(String state) {
		String str = "check";
		boolean flag = false;
		String methodName = "verifyCustomJDBCURLCheckboxOfConnection";
		try {
			isDisplayedInLoop(driver, 5, connCustomJDBCLabel);

			javascript(driver, scrollToElementArg, connCustomJDBCLabel);

			if (isDisplayed(driver, connCustomJDBCLabel)) {

				BaseSuite.reportLog("verifying custom JDBC URL checkbox");

				if (isDisplayed(driver, connCustomJDBCCheckbox)) {

					BaseSuite.validationReportLog("Custom JDBC URL checkbox is visible");

					String actualState = getAttribute(driver, connCustomJDBCCheckbox, "class");

					if (state.equalsIgnoreCase(booleanTrue)) {
						if (actualState.contains(str)) {
							flag = true;
							BaseSuite.validationReportLog("Custom JDBC URL checkbox is checked");
						} else {
							BaseSuite.reportFailLog("Custom JDBC URL checkbox is unchecked", methodName);
						}
					} else {
						if (actualState.contains(str)) {
							BaseSuite.reportFailLog("Custom JDBC URL checkbox is checked", methodName);
						} else {
							flag = true;
							BaseSuite.validationReportLog("Custom JDBC URL checkbox is unchecked");
						}
					}

				} else {
					BaseSuite.reportFailLog("Custom JDBC URL checkbox not visible ", methodName);
				}
			} else {
				BaseSuite.reportFailLog("Custom JDBC URL field not visible ", methodName);
			}
		} catch (Exception e) {
			e.getMessage();
			throw new NoSuchElementException();
		}
		return flag;
	}

	/** Update Database connection common method **/

	/** testScenario = "Valid/Invalid" , ValidationMessage blank for valid name **/
	public boolean updateDatabaseConnection(String connJsonEntity, String driverName, String testScenario,
			String validationMessage, String icedqUser) {
		boolean flag = true;
		String newconnectionName = null;
		NewConnectionRepoPage np = new NewConnectionRepoPage(driver);
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			String timestamp = new SimpleDateFormat(ConstantProperty.CONNECTIONNAME_TIMESTAMPFORMAT).format(new Date());

			newconnectionName = connParam.getConnName() + "_" + BaseSuite.WorkspaceName + "_" + timestamp;

			String connusername = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

			String connpassword = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 2);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				inVisible(driver, spinner, Constant.ruleWait);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				np.enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

				np.viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, true);

				np.selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

				np.viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
						connParam.getAuthenticationname(), true);

				np.selectAuthenticationOfConnection(connParam.getAuthenticationname());

				verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

				selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

				enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());

				if (connParam.getCustomJdbcFullUrl().equalsIgnoreCase(booleanTrue)) {

					np.validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
							connHostPlaceholder, false);
					np.validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
							connPortPlaceholder, false);
					np.validateInputFieldVisibility(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
							connDatabasePlaceHolder, false);

				} else {
					np.viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
							connParam.getHost(), true);
					np.validatAndeEnterValueToTextField(connHostTitle, connHostInputField,
							ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder, connParam.getHost(),
							validationHostEmpty);

					np.viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
							connParam.getPort(), true);
					np.validatAndeEnterValueToTextField(connPortTitle, connPortInputField,
							ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder, connParam.getPort(),
							validationPortEmpty);

					np.viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
							connParam.getDatabaseName(), true);
					np.validatAndeEnterValueToTextField(connDatabaseTitle, connDatabaseInputField,
							ConstantProperty.CONN_FIELD_DATABASE, connDatabasePlaceholder, connParam.getDatabaseName(),
							validationDatabaseEmpty);
				}

				np.selectConnectionType(connParam.getType());

				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					np.enterUsername(connusername);

					np.enterPassword(connpassword);

				} else {

					np.validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME,
							connUsernamePlaceholder, false);
					np.validateInputFieldVisibility(connPasswordInput, ConstantProperty.CONN_FIELD_PASSWORD,
							connPasswordPlaceholder, false);

				}

				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, "$.connectionProperties..name");

				int count = connPropertyList.size();

				flag = updateConnectionPropertiesToConnection(connJsonEntity, count);

				if (icedqUser.contains("owner")) {
					np.saveConnection();
				} else {
					flag = np.saveConnection(forbiddenToastMsg);
				}
			} else {
				if (flag) {

					flag = updateUsernameAndPasswordForUserConnection("update", connParam.getType(), newconnectionName,
							connusername, connpassword, icedqUser);
				}
			}

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not created properly kindly check :" + e.toString());
		}
		return flag;
	}

	/** Test Database connection common method **/

	public boolean testDatabaseConnection(String connJsonEntity, String driverName, String icedqUser) {
		boolean flag = false;
		NewConnectionRepoPage np = new NewConnectionRepoPage(driver);

		try {
			ConnectionPoJO connParam = np.setConnectionParametersForApi(connJsonEntity);

			String connusername = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

			String connpassword = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 2);

			inVisible(driver, spinner, Constant.ruleWait);
			Thread.sleep(3000);
			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				viewDatabaseConnection(connJsonEntity, driverName);

				if (!icedqUser.contains("reader")) {

					flag = testConnection(connectionTestMess);

				} else {
					flag = testConnection(forbiddenToastMsg);
				}
			} else {

				// viewDatabaseConnection(connJsonEntity, driverName);

				np.enterUsername(connusername);

				np.enterPassword(connpassword);

				if (!icedqUser.contains("reader")) {

					np.saveConnection();

					flag = testConnection(connectionTestMess);

				} else {

					flag = saveConnection(forbiddenToastMsg);
				}
			}

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not deleted properly kindly check :" + e.toString());

		}

		return flag;
	}

	/** Delete Database connection common method **/

	/*
	 * public boolean deleteDatabaseConnection(String connJsonEntity, String
	 * driverName, String icedqUser) { boolean flag = true; NewConnectionRepoPage np
	 * = new NewConnectionRepoPage(driver);
	 * 
	 * try {
	 * 
	 * //viewDatabaseConnection(connJsonEntity, driverName);
	 * 
	 * ConnectionPoJO connParam = np.setConnectionParametersForApi(connJsonEntity);
	 * 
	 * inVisible(driver, spinner, Constant.ruleWait);
	 * 
	 * Thread.sleep(3000);
	 * 
	 * if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {
	 * clickOnConnectionsTab();
	 * 
	 * searchAndClickOnConnectionNameInConnRepo(connParam.getConnName() + "_" +
	 * BaseSuite.WorkspaceName);
	 * 
	 * } if (icedqUser.contains("owner")) {
	 * 
	 * flag = clickOnDeleteButton(connSingleDeleteToastMsg, 1);
	 * 
	 * } else { flag = clickOnDeleteButton(forbiddenToastMsg, 1); } } catch
	 * (Exception e) { flag = false; Thread.currentThread().interrupt(); BaseSuite.
	 * reportErrorLog("Database connection not deleted properly kindly check :" +
	 * e.toString());
	 * 
	 * }
	 * 
	 * return flag; }
	 */
	
	/** Delete Database connection common method **/

	public boolean deleteDatabaseConnection(String connJsonEntity, String driverName, String icedqUser) {
		boolean flag = true;
		String newconnectionName = null;
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";
			inVisible(driver, spinner, Constant.ruleWait);

			waitForExecution(3000);

			// viewDatabaseConnection(connJsonEntity, driverName);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {
				String connName;

				clickOnConnectionsTab();

				if ((icedqUser.contains("owner"))) {

					connName = newconnectionName;

				} else {
					connName = newconnectionName;

					if (connName.contains("Databricks") || connName.contains("Impala") || connName.contains("Hive")) {

						connName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
								+ ConstantProperty.TARGET_WORKSPACE_NAME;
					} else {

						connName = newconnectionName;
					}
				}
				searchAndClickOnConnectionNameInConnRepo(connName);

				inVisible(driver, spinner, Constant.ruleWait);

			}
			if (icedqUser.contains("owner")) {

				flag = clickOnDeleteButton(connSingleDeleteToastMsg, 1);

			} else {
				flag = clickOnButton(driver, clickonDisable, "Connection Delete", flag);

				flag = captureToastMsg(driver, toastMsg, popUpClose, forbiddenToastMsg, "Connection Delete");
			}
		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not deleted properly kindly check :" + e.toString());

		}

		return flag;
	}
	
	/** view connection property common method **/

	public boolean viewAndValidateConnectionPropertiesToConnection(String jsonEntity, int count) throws Exception {
		boolean flag = true;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {
			if (count > 0) {
				clickOnPropertiesTab();
				inVisible(driver, spinner, Constant.ruleWait);

				ArrayList<String> name = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						connConnectionPropNames);

				ArrayList<String> value = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						connConnectionPropValues);

				ArrayList<String> type = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						connConnectionPropTypes);
				int a = 1;
				for (int j = 0; j < name.size(); j++) {
					a = a + j;
					String connTypename = type.get(j);
					if (!connTypename.equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						if (name.get(j).contains("loginTimeout")) {

							cp.validateDefaultConnectionProperty(name.get(j), value.get(j), type.get(j));

						} else {
							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, "$num",
									Integer.toString(a), dynamicName, name.get(j)), name.get(j));

							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, "$num",
									Integer.toString(a), dynamicName, value.get(j)), value.get(j));

							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, "$num",
									Integer.toString(a), dynamicName, type.get(j)), type.get(j));
						}
					} else {

						if (name.get(j).contains("loginTimeout")) {

							cp.validateDefaultConnectionProperty(name.get(j), value.get(j), type.get(j));

						} else {
							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, "$num",
									Integer.toString(a), dynamicName, name.get(j)), name.get(j));

							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, "$num",
									Integer.toString(a), dynamicName, value.get(j)), value.get(j));

							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, "$num",
									Integer.toString(a), dynamicName, type.get(j)), type.get(j));
						}

					}
				}
				clickOnOverviewTab();
			}

		} catch (Exception e) {
			flag = false;
			e.getMessage();
			throw new NoSuchElementException(e.getMessage());

		}
		return flag;
	}

	/** update connection property common method **/
	public boolean updateConnectionPropertiesToConnection(String jsonEntity, int count) throws Exception {
		boolean flag = true;
		String dynamicVar1 = "$name";
		String dynamicVar = "$num";
		String namefield = "Name";
		String valueField = "Value";
		String typeField = "Type";
		try {
			if (count > 0) {

				clickOnPropertiesTab();
				// updateConnectionDefaultPropHandler(jsonEntity);

				inVisible(driver, spinner, Constant.ruleWait);

				Thread.sleep(1000);

				ArrayList<String> name = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						connConnectionPropNames);

				ArrayList<String> value = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						connConnectionPropValues);

				ArrayList<String> type = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						connConnectionPropTypes);
				int a = 1;
				for (int j = 0; j < name.size(); j++) {

					a = a + j;

					// javascript(driver, scrollToElementArg,returnElement(connPropertyEditButton,
					// dynamicVar1,name.get(j)));

					validateConnectionPropertyField(returnElement(viewName, "$name", name.get(j)), name.get(j));

					validateConnectionPropertyField(returnElement(viewValue, "$name", value.get(j)), value.get(j));

					validateConnectionPropertyField(viewType, type.get(j));

					if (!name.get(j).equals("loginTimeout")) {

						clickOnButton(driver, returnElement(connPropertyEditButton, dynamicVar1, name.get(j)), "Edit",
								true);

						updateConnectionPropertyField(updateName, name.get(j));

						updateConnectionPropertyField(updateValue, value.get(j));

						selectPropertyType(type.get(j));

						clickOnButton(driver, saveButton, "Save", true);

					}

				}

			}

		} catch (Exception e) {
			flag = false;
			e.getMessage();
			throw new NoSuchElementException(e.getMessage());

		}
		return flag;
	}

	public boolean validateConnectionPropertyField(By locator, String expectedValue) {

		boolean flag = true;

		isDisplayedInLoop(driver, 4, locator);

		// javascript(driver, scrollToElementArg, locator);

		if (isDisplayed(driver, locator)) {

			String actualValue = getAttribute(driver, locator, "textContent");

			BaseSuite.reportLog("Retrieved : " + actualValue);
			BaseSuite.reportLog("Expected : " + expectedValue);

			if (actualValue.equalsIgnoreCase(expectedValue)) {

				BaseSuite.validationReportLog("Expected value matched successfully");
			} else {
				BaseSuite.reportFailLog("Expected value not matched", actualValue);
			}

		} else {
			BaseSuite.reportFailLog("Element not visible kindly check", "validateConnectionPropertyField");

		}

		return flag;
	}

	public boolean updateConnectionPropertyField(By locator, String expectedValue) {

		boolean flag = true;

		isDisplayedInLoop(driver, 4, locator);

		// javascript(driver, scrollToElementArg, locator);

		if (isDisplayed(driver, locator)) {

			clear_Click_SendKeys(driver, 0, locator, expectedValue);

			String actualValue = getAttribute(driver, locator, valueAttribute);

			BaseSuite.reportLog("Retrieved : " + actualValue);
			BaseSuite.reportLog("Expected : " + expectedValue);

			if (actualValue.equalsIgnoreCase(expectedValue)) {

				BaseSuite.validationReportLog("Expected value entered successfully");
			} else {
				BaseSuite.reportFailLog("Expected value not entered", actualValue);
			}

		} else {
			BaseSuite.reportFailLog("Element not visible kindly check", "validateConnectionPropertuField");
		}

		return flag;
	}

	public void updatePropertyType(By locator, String expectedValue) {

		try {
			isDisplayedInLoop(driver, 2, locator);

			if (isDisplayed(driver, locator)) {
				if (isClickable(driver, locator, "property type", true)) {

					click(driver, addPropertyTypeClick);

					BaseSuite.reportLog("Clicked on property type dropdown");

					Thread.sleep(2000);

					if (isDisplayed(driver, propTypeListPane)) {
						BaseSuite.reportLog("System & User options are displayed.");

						List<WebElement> typeList = getElements(driver, propListOptions);

						for (int i = 0; i < typeList.size(); i++) {
							String label = typeList.get(i).getAttribute("data-value");

							if (label.equalsIgnoreCase(expectedValue)) {
								typeList.get(i).click();

								BaseSuite.reportLog(expectedValue + " is selected from type list.");
								break;
							}
						}

						String propType = getAttribute(driver, addPropertyTypeClick, attributeTextContent);

						stringContainsOutput(propType.trim(), expectedValue, true);

					}

				}
			} else {
				BaseSuite.reportErrorLog("Unable to locate property type, kindly check.");
			}

		} catch (Exception e) {
			Thread.currentThread().interrupt();
			e.getMessage();

		}

	}

	/** Duplicate database connection using API test data **/
	public boolean duplicateDatabaseConnectionMethod(String connJsonEntity, String driverName, String icedqUser) {
		boolean flag = false;
		String name = null;
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);

			viewDatabaseConnection(connJsonEntity, driverName);

			Thread.sleep(3000);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				clickOnConnectionsTab();

				searchAndClickOnConnectionNameInConnRepo(connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
						+ ConstantProperty.TARGET_WORKSPACE_NAME);

				inVisible(driver, spinner, Constant.ruleWait);

				Thread.sleep(2000);
			}
			if (icedqUser.contains("owner")) {

				flag = clickOnDuplicateConnection(connDupllicateToastMsg);

				inVisible(driver, spinner, Constant.ruleWait);

				if (flag) {
					name = getAttribute(driver, connName, valueAttribute);
					Thread.sleep(3000);

					clickOnConnectionsTab();
					Thread.sleep(2000);
					flag = searchConnection(name);
				}
			} else {
				flag = clickOnDuplicateConnection(forbiddenToastMsg);
			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(
					"due to exception while duplicate Database Connection kindly check " + e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;
	}

	/** testScenario = "Valid/Invalid" , ValidationMessage blank for valid name **/
	public boolean createDatabaseConnectionForInvalid(String connJsonEntity, String testScenario,
			String onvalidationMessage, String onSaveValidation, String icedqUser) {
		boolean flag = true;
		boolean status = false;
		String newconnectionName = null;
		NewConnectionRepoPage np = new NewConnectionRepoPage(driver);
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName();

			String connusername = np.getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

			String connpassword = np.getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 2);

			np.connectionRepositoryLandingPage();

			flag = np.clickOnNewConnectionBtn(icedqUser);

			if (flag) {

				np.chooseConnectorType(connParam.getConnectorID());

				inVisible(driver, spinner, Constant.ruleWait);
				
				String wizardStatus = cp.validateNewConnPageButtonsFields(connParam.getConnectorID());
				
				if (wizardStatus.contains("Wizard supported connector")) {
					
					verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", false);
				}
				
				verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

				verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);

				verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

				verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", false);

				verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", false);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				status = np.enterConnectionNameWithValidation(newconnectionName, testScenario, onvalidationMessage);

				if (onvalidationMessage.isEmpty()) {

					np.selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

					np.selectAuthenticationOfConnection(connParam.getAuthenticationname());

					boolean cs = np.selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

					enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());

					if (cs) {

						np.validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
								connHostPlaceholder, false);
						np.validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
								connPortPlaceholder, false);
						np.validateInputFieldVisibility(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
								connDatabasePlaceHolder, false);

					} else {

						np.validatAndeEnterValueToTextField(connHostTitle, connHostInputField,
								ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder, connParam.getHost(),
								validationHostEmpty);

						np.validatAndeEnterValueToTextField(connPortTitle, connPortInputField,
								ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder, connParam.getPort(),
								validationPortEmpty);

						np.validatAndeEnterValueToTextField(connDatabaseTitle, connDatabaseInputField,
								ConstantProperty.CONN_FIELD_DATABASE, connDatabasePlaceholder,
								connParam.getDatabaseName(), validationDatabaseEmpty);
					}

					np.selectConnectionType(connParam.getType());

					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						np.enterUsername(connusername);

						np.enterPassword(connpassword);

					} else {

						np.validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME,
								connUsernamePlaceholder, false);
						np.validateInputFieldVisibility(connPasswordInput, ConstantProperty.CONN_FIELD_PASSWORD,
								connPasswordPlaceholder, false);

					}

					ArrayList<String> connPropertyList = TestDataThroughApi
							.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

					int count = connPropertyList.size();

					np.addConnectionPropertiesToConnection(connJsonEntity, count);

					if (icedqUser.toLowerCase().contains("owner")) {

						flag = np.saveConnection(onSaveValidation);

					} else {

						flag = np.saveConnection(forbiddenToastMsg);
					}
				} else {
					if (status) {
						flag = true;
					} else {
						flag = false;
					}
				}
			}
		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not created properly kindly check :" + e.toString());
		}
		return flag;
	}

	/** testScenario = "Valid/Invalid" , ValidationMessage blank for valid name **/
	public boolean updateDatabaseConnectionForInvalid(String connJsonEntity, String testScenario,
			String validationMessage, String onSaveValidation, String icedqUser) {
		boolean flag = true;
		boolean status = false;
		String newconnectionName = null;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName();

			String connusername = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

			String connpassword = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 2);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				inVisible(driver, spinner, Constant.ruleWait);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				status = enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

				if (validationMessage.isEmpty()) {

					// np.viewAndValidateConnectionField(connFlatFileDriverField,"Driver",
					// driverName, true);

					selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

					viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
							connParam.getAuthenticationname(), true);

					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

					selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

					enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());

					if (connParam.getCustomJdbcFullUrl().equalsIgnoreCase(booleanTrue)) {

						validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
								connHostPlaceholder, false);
						validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
								connPortPlaceholder, false);
						validateInputFieldVisibility(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
								connDatabasePlaceHolder, false);

					} else {
						viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
								connParam.getHost(), true);
						validatAndeEnterValueToTextField(connHostTitle, connHostInputField,
								ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder, connParam.getHost(),
								validationHostEmpty);

						viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
								connParam.getPort(), true);
						validatAndeEnterValueToTextField(connPortTitle, connPortInputField,
								ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder, connParam.getPort(),
								validationPortEmpty);

						viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
								connParam.getDatabaseName(), true);
						validatAndeEnterValueToTextField(connDatabaseTitle, connDatabaseInputField,
								ConstantProperty.CONN_FIELD_DATABASE, connDatabasePlaceholder,
								connParam.getDatabaseName(), validationDatabaseEmpty);
					}

					selectConnectionType(connParam.getType());

					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						enterUsername(connusername);

						enterPassword(connpassword);

					} else {

						validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME,
								connUsernamePlaceholder, false);
						validateInputFieldVisibility(connPasswordInput, ConstantProperty.CONN_FIELD_PASSWORD,
								connPasswordPlaceholder, false);

					}

					ArrayList<String> connPropertyList = TestDataThroughApi
							.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, "$.connectionProperties..name");

					int count = connPropertyList.size();

					flag = updateConnectionPropertiesToConnection(connJsonEntity, count);

					if (icedqUser.contains("owner")) {
						saveConnection(onSaveValidation);
					} else {
						flag = saveConnection(forbiddenToastMsg);
					}
				}
			}

			if (status) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not created properly kindly check :" + e.toString());
		}
		return flag;
	}

	/** Test Flat file native connection using API Invalid test data **/
	public boolean testDatabaseConnectionMethodForInvalidData(ConnectionPoJO connParam, String authtype,
			String icedqUser) {
		boolean flag = true;

		try {

			inVisible(driver, spinner, Constant.ruleWait);

			Thread.sleep(3000);
			String s = connParam.getConnectionJsonValue();
			String[] a = s.split(";");

			String accessKey = a[0];

			String secretKey = a[1];

			validatAndeEnterValueToTextField(connUsernameLabel, connUsernameInput, "Username", connUsernamePlaceholder,
					accessKey, "Username is required.");

			validatAndeEnterValueToTextField(connPasswordLabel, connPasswordInput, "Username", connPasswordPlaceholder,
					secretKey, "Password is required.");

			saveConnection();

			clickOnButton(driver, connTestBtn, "Test", true);

			inVisible(driver, spinner, 10);

			flag = captureToastMsgForConnection(driver, toastMsg, popUpClose, connectionTestMess, "Connection Test",
					false);

		} catch (Exception e) {
			flag = false;

			BaseSuite.reportFailLog("Application spinner taking more time to invisible than stardard time",
					"testFlatFileNativeConnectionMethodForInvalidData");

			driver.navigate().refresh();

			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

			BaseSuite.reportErrorLog(" due to exception kindly check " + e.toString());

			Thread.currentThread().interrupt();
		} finally {
			clickOnConnectionRepoBreadcrumbLink();
		}
		return flag;
	}

	/***************** Neha's code *******************/
	// verify placeholder in input box

	public boolean verifyplaceholder(By locator, String expected) {
		boolean status = false;
		if (isDisplayed(driver, locator)) {
			String holder = getAttribute(driver, locator, "placeholder");

			if (holder.equalsIgnoreCase(expected)) {
				status = true;
			} else {
				status = false;
			}
		} else {
			BaseSuite.reportErrorLog("Unable to locate locator :: " + locator);
		}

		return status;

	}

	// method to validate & enter VALID data in accesIdentifier

	public void enterAccountIdentifier(String value) throws Exception {
		try {

			boolean flag = false;

			// javascript(driver, "arguments[0].scrollIntoView(true);",
			// accountIdentifierInput);

			if (isDisplayed(driver, accountIdentifierInput)) {
				BaseSuite.reportLog("Account identifier field is displayed.");

				if (isEnabled(driver, accountIdentifierInput)) {
					if (isEditable(driver, accountIdentifierInput, "access identifier")) {
						clear(driver, accountIdentifierInput);

						BaseSuite.reportLog("Verify placeholder is present in input box.");

						flag = verifyplaceholder(accountIdentifierInput, "Enter account identifier");

						if (flag) {
							BaseSuite.validationReportLog(
									"correct placeholder is displayed in account identifier input box.");
						} else {
							BaseSuite.reportFailLog(
									"Expected placeholder didnt matched with actual placeholder, kindly check.",
									"enterAccountIdentifier");
						}

						BaseSuite.reportLog("Entering account identifier value  :: " + value.trim());

						sendKeys(driver, accountIdentifierInput, value.trim());

						isDisplayedInLoop(driver, 1, accountIdentifierInput);

						String accountidentifier = getAttribute(driver, accountIdentifierInput, "value").trim();

						compareActualNExpectedValue(accountidentifier.trim(), value.trim());
					}
				} else {
					BaseSuite.reportFailLog("Account identifier input is disabled, kindly check.",
							"enterAccountIdentifier");
				}
			} else {
				BaseSuite.reportFailLog("Unable to locate account identifier field on current page, kindly check.",
						"enterAccessIdentifier");
			}

			BaseSuite.reportLog("Verifing account identifier field title/label is displayed or not.");

			verifyIndividualLabel(driver, accountIdentifierLabel, "Account Identifier");

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}

	}

	// Method to validate Warehouse field & enter VALID data in it.
	public void enterWarehouse(String value) throws Exception {
		boolean flag = false;
		try {
			// javascript(driver, "arguments[0].scrollIntoView(true);", connWarehouseInput);

			if (isDisplayed(driver, connWarehouseInput)) {
				BaseSuite.reportLog("Warehouse field is displayed.");

				if (isEnabled(driver, connWarehouseInput)) {
					if (isEditable(driver, connWarehouseInput, "warehouse")) {
						clear(driver, connWarehouseInput);

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag = verifyplaceholder(connWarehouseInput, "Enter warehouse (optional)");

						if (flag) {
							BaseSuite.validationReportLog("correct placeholder is displayed in warehouse input box.");
						} else {
							BaseSuite.reportFailLog(
									"Expected placeholder didnt matched with actual placeholder, kindly check.",
									"enterWarehouse");
						}

						BaseSuite.reportLog("Entering warehouse value  :: " + value.trim());

						sendKeys(driver, connWarehouseInput, value.trim());

						isDisplayedInLoop(driver, 1, connWarehouseInput);

						String warehouse = getAttribute(driver, connWarehouseInput, "value").trim();

						compareActualNExpectedValue(warehouse.trim(), value.trim());
					}
				} else {
					BaseSuite.reportFailLog("Warehouse input is disabled, kindly check.", "enterWarehouse");
				}
			} else {
				BaseSuite.reportFailLog("Unable to locate warehouse field on current page, kindly check.",
						"enterWarehouse");
			}

			BaseSuite.reportLog("Verifing warehouse field title/label is displayed or not.");

			verifyIndividualLabel(driver, connWarehouseLabel, "Warehouse");

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// Method to validate Warehouse field & enter VALID data in it.
	public void enterDatabase(String value) throws Exception {
		boolean flag = false;
		try {
			// javascript(driver, "arguments[0].scrollIntoView(true);", connDatabaseInput);

			if (isDisplayed(driver, connDatabaseInput)) {
				BaseSuite.reportLog("Database field is displayed.");

				if (isEnabled(driver, connDatabaseInput)) {
					if (isEditable(driver, connDatabaseInput, "database")) {
						clear(driver, connDatabaseInput);

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag = verifyplaceholder(connDatabaseInput, "Enter database (optional)");

						if (flag) {
							BaseSuite.validationReportLog("correct placeholder is displayed in database input box.");
						} else {
							BaseSuite.reportFailLog(
									"Expected placeholder didnt matched with actual placeholder, kindly check.",
									"enterDatabase");
						}

						BaseSuite.reportLog("Entering database value  :: " + value.trim());

						sendKeys(driver, connDatabaseInput, value.trim());

						isDisplayedInLoop(driver, 1, connDatabaseInput);

						String database = getAttribute(driver, connDatabaseInput, "value").trim();

						compareActualNExpectedValue(database.trim(), value.trim());
					}
				} else {
					BaseSuite.reportFailLog("Database input is disabled, kindly check.", "enterDatabase");
				}
			} else {
				BaseSuite.reportFailLog("Unable to locate database field on current page, kindly check.",
						"enterDatabase");
			}

			BaseSuite.reportLog("Verifing database field title/label is displayed or not.");

			verifyIndividualLabel(driver, connDatabaseLabel, "Database");

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// method to validate connection type dropdown & select one value
	public void selectConnectionType(String value) throws Exception {
		try {
			isDisplayedInLoop(driver, 5, connTypeSelectionDropdown);
			javascript(driver, "arguments[0].scrollIntoView(true);", connTypeSelectionDropdown);

			if (isDisplayed(driver, connTypeSelectionDropdown)) {
				BaseSuite.reportLog("Connection type dropdown is displayed.");

				if (isClickable(driver, connTypeSelectionDropdown, "type dropdown", true)) {
					click(driver, connTypeSelectionDropdown);

					if (isDisplayed(driver, connTypeListpane)) {
						BaseSuite.reportLog("Type list options are displayed");

						List<WebElement> typeList = getElements(driver, connTypeList);

						BaseSuite.reportLog("List has " + typeList.size() + "options as:");

						selectConnectionTypeForConn(typeList, value);
					}
				} else {
					BaseSuite.reportFailLog("Connection type dropdown is not clickable,kindly check.",
							"selectConnectionType");
				}

			} else {
				BaseSuite.reportFailLog("Unable to located type dropdown, kindly check.", "selectConnectionType");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// method
	public void selectConnectionTypeForConn(List<WebElement> typeList, String value) throws Exception {
		try {

			int a = 1;
			for (int i = 0; i < typeList.size(); i++) {
				String label = typeList.get(i).getAttribute("data-value");

				if ((label.equalsIgnoreCase("System")) || (label.equalsIgnoreCase("User"))) {
					BaseSuite.validationReportLog(a + "- " + label);
					a++;
				}

			}
			Thread.sleep(1000);
			for (int i = 0; i < typeList.size(); i++) {
				String label = typeList.get(i).getAttribute("data-value");
				if (label.equalsIgnoreCase(value)) {
					typeList.get(i).click();
					BaseSuite.validationReportLog("Connection type : " + value + " selected successfully.");
					break;
				}
			}

			if (typeList.size() > 2) {
				BaseSuite.reportFailLog(
						"Type dropdown must contains 2 values only, it has " + typeList.size() + ", kindly check.",
						value);
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}

	}

	// Method to validate & enter Username
	public void enterUsername(String value) throws Exception {
		boolean flag = false;
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", connUsernameInput);

			if (isDisplayed(driver, connUsernameInput)) {
				BaseSuite.reportLog("Username field is displayed.");

				if (isEnabled(driver, connUsernameInput)) {
					if (isEditable(driver, connUsernameInput, "username")) {
						clear(driver, connUsernameInput);

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag = verifyplaceholder(connUsernameInput, "Enter username");

						if (flag) {
							BaseSuite.validationReportLog("correct placeholder is displayed in database input box.");
						} else {
							BaseSuite.reportFailLog(
									"Expected placeholder didnt matched with actual placeholder, kindly check.",
									"enterUsername");
						}

						sendKeys(driver, connUsernameInput, value.trim());

						isDisplayedInLoop(driver, 1, connUsernameInput);

						String username = getAttribute(driver, connUsernameInput, "value").trim();

						compareActualNExpectedValue(username.trim(), value.trim());

					}

				} else {
					BaseSuite.reportFailLog("Username input is disabled, kindly check.", "enterUsername");
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate username field on current page, kindly check.",
						"enterUsername");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// Method to validate & enter Username
	public void enterPassword(String value) throws Exception {
		boolean flag = false;
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", connPasswordInput);

			if (isDisplayed(driver, connPasswordInput)) {
				BaseSuite.reportLog("Password field is displayed.");

				if (isEnabled(driver, connPasswordInput)) {
					if (isEditable(driver, connPasswordInput, "password")) {
						clear(driver, connPasswordInput);

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag = verifyplaceholder(connPasswordInput, "Enter password");

						if (flag) {
							BaseSuite.validationReportLog("correct placeholder is displayed in database input box.");
						} else {
							BaseSuite.reportFailLog(
									"Expected placeholder didnt matched with actual placeholder, kindly check.",
									"enterPassword");
						}

						sendKeys(driver, connPasswordInput, value.trim());

						BaseSuite.validationReportLog("Entered password in password field.");
					}

				} else {
					BaseSuite.reportFailLog("Password input is disabled, kindly check.", "enterPassword");
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate password field on current page, kindly check.",
						"enterPassword");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// Method to validate & enter Key File Content
	public void enterKeyFileContentEncoded(String value) throws Exception {
		boolean flag = false;
		try {
			// javascript(driver, "arguments[0].scrollIntoView(true);", KeyFileContent);

			if (isDisplayed(driver, KeyFileContent)) {
				BaseSuite.reportLog("Key File Content field is displayed.");

				if (isEnabled(driver, KeyFileContent)) {
					if (isEditable(driver, KeyFileContent, "Key File Content")) {
						clear(driver, KeyFileContent);

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag = verifyplaceholder(KeyFileContent, "Enter key file content");

						if (flag) {
							BaseSuite.validationReportLog("correct placeholder is displayed in database input box.");
						} else {
							BaseSuite.reportFailLog(
									"Expected placeholder didnt matched with actual placeholder, kindly check.",
									"enterKeyFileContentEncoded");
						}

						sendKeys(driver, KeyFileContent, value.trim());

						isDisplayedInLoop(driver, 1, KeyFileContent);

						String KeyFileContentData = getAttribute(driver, KeyFileContent, "value").trim();

						compareActualNExpectedValue(KeyFileContentData.trim(), value.trim());

					}

				} else {
					BaseSuite.reportFailLog("key File Content input is disabled, kindly check.",
							"enterKeyFileContentEncoded");
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate key File Content field on current page, kindly check.",
						"enterKeyFileContentEncoded");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// Method to validate & enter Key File Content
	public void enterKeyFilePassword(String value) throws Exception {
		boolean flag = false;
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", KeyFilePassword);

			if (isDisplayed(driver, KeyFilePassword)) {
				BaseSuite.reportLog("Key File Content field is displayed.");

				if (isEnabled(driver, KeyFilePassword)) {
					if (isEditable(driver, KeyFilePassword, "Key File Password")) {
						clear(driver, KeyFilePassword);

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag = verifyplaceholder(KeyFilePassword, "Enter Key File Password");

						if (flag) {
							BaseSuite.validationReportLog("correct placeholder is displayed in database input box.");
						} else {
							BaseSuite.reportFailLog(
									"Expected placeholder didnt matched with actual placeholder, kindly check.",
									"enterKeyFilePassword");
						}

						sendKeys(driver, KeyFilePassword, value.trim());

						isDisplayedInLoop(driver, 1, KeyFilePassword);

						String KeyFilePasswordData = getAttribute(driver, KeyFilePassword, "value").trim();

						compareActualNExpectedValue(KeyFilePasswordData.trim(), value.trim());

					}

				} else {
					BaseSuite.reportFailLog("key File Content input is disabled, kindly check.",
							"enterKeyFileContentEncoded");
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate key File Content field on current page, kindly check.",
						"enterKeyFilePassword");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// Method to validate & enter key Vaul tName
	public void enterkeyVaultName(String value) throws Exception {
		boolean flag = false;
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", keyVaultName);

			if (isDisplayed(driver, keyVaultName)) {
				BaseSuite.reportLog("key Vault Name field is displayed.");

				if (isEnabled(driver, keyVaultName)) {
					if (isEditable(driver, keyVaultName, "key Vault Name")) {
						clear(driver, keyVaultName);

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag = verifyplaceholder(keyVaultName, "Enter key vault name");

						if (flag) {
							BaseSuite.validationReportLog("correct placeholder is displayed in database input box.");
						} else {
							BaseSuite.reportFailLog(
									"Expected placeholder didnt matched with actual placeholder, kindly check.",
									"enterkeyVaultName");
						}

						sendKeys(driver, keyVaultName, value.trim());

						isDisplayedInLoop(driver, 1, keyVaultName);

						String keyVault = getAttribute(driver, keyVaultName, "value").trim();

						compareActualNExpectedValue(keyVault.trim(), value.trim());

					}

				} else {
					BaseSuite.reportFailLog("key Vault Name input is disabled, kindly check.", "enterkeyVaultName");
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate key Vault Name field on current page, kindly check.",
						"enterkeyVaultName");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// Method to validate & enter Client Id
	public void enterClientId(String value) throws Exception {
		boolean flag = false;
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", clientId);

			if (isDisplayed(driver, clientId)) {
				BaseSuite.reportLog("Client Id field is displayed.");

				if (isEnabled(driver, clientId)) {
					if (isEditable(driver, clientId, "Client ID")) {
						clear(driver, clientId);

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag = verifyplaceholder(clientId, "Enter client ID");

						if (flag) {
							BaseSuite.validationReportLog("correct placeholder is displayed in database input box.");
						} else {
							BaseSuite.reportFailLog(
									"Expected placeholder didnt matched with actual placeholder, kindly check.",
									"enterClientId");
						}

						sendKeys(driver, clientId, value.trim());

						isDisplayedInLoop(driver, 1, clientId);

						String client = getAttribute(driver, clientId, "value").trim();

						compareActualNExpectedValue(client.trim(), value.trim());

					}

				} else {
					BaseSuite.reportFailLog("Client Id input is disabled, kindly check.", "enterClientId");
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate Client Id field on current page, kindly check.",
						"enterClientId");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// Method to validate & enter Tenant Id
	public void enterTenantId(String value) throws Exception {
		boolean flag = false;
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", tenantId);

			if (isDisplayed(driver, tenantId)) {
				BaseSuite.reportLog("tenant Id field is displayed.");

				if (isEnabled(driver, tenantId)) {
					if (isEditable(driver, tenantId, "Tenant Id")) {
						clear(driver, tenantId);

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag = verifyplaceholder(tenantId, "Enter tenant Id");

						if (flag) {
							BaseSuite.validationReportLog("correct placeholder is displayed in database input box.");
						} else {
							BaseSuite.reportFailLog(
									"Expected placeholder didnt matched with actual placeholder, kindly check.",
									"enterTenantId");
						}

						sendKeys(driver, tenantId, value.trim());

						isDisplayedInLoop(driver, 1, tenantId);

						String client = getAttribute(driver, tenantId, "value").trim();

						compareActualNExpectedValue(client.trim(), value.trim());

					}

				} else {
					BaseSuite.reportFailLog("Tenant Id input is disabled, kindly check.", "enterTenantId");
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate Tenant Id field on current page, kindly check.",
						"enterTenantId");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// Method to validate & enter client Secret
	public void enterClientSecret(String value) throws Exception {
		boolean flag = false;
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", clientSecret);

			if (isDisplayed(driver, clientSecret)) {
				BaseSuite.reportLog("client Secret field is displayed.");

				if (isEnabled(driver, tenantId)) {
					if (isEditable(driver, clientSecret, "client Secret")) {
						clear(driver, clientSecret);

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag = verifyplaceholder(clientSecret, "Enter client secret");

						if (flag) {
							BaseSuite.validationReportLog("correct placeholder is displayed in database input box.");
						} else {
							BaseSuite.reportFailLog(
									"Expected placeholder didnt matched with actual placeholder, kindly check.",
									"enterClientSecret");
						}

						sendKeys(driver, clientSecret, value.trim());

						isDisplayedInLoop(driver, 1, clientSecret);

						String clientSec = getAttribute(driver, clientSecret, "value").trim();

						compareActualNExpectedValue(clientSec.trim(), value.trim());

					}

				} else {
					BaseSuite.reportFailLog("client Secret input is disabled, kindly check.", "enterClientSecret");
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate client Secret field on current page, kindly check.",
						"enterClientSecret");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// Method to validate & enter Private Key Secret Name
	public void enterPrivateKeySecretName(String value) throws Exception {
		boolean flag = false;
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", privateKeySecretName);

			if (isDisplayed(driver, privateKeySecretName)) {
				BaseSuite.reportLog("Private Key Secret Name field is displayed.");

				if (isEnabled(driver, privateKeySecretName)) {
					if (isEditable(driver, privateKeySecretName, "Private Key Secret Name")) {
						clear(driver, privateKeySecretName);

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag = verifyplaceholder(privateKeySecretName, "Enter private key secret name");

						if (flag) {
							BaseSuite.validationReportLog("correct placeholder is displayed in database input box.");
						} else {
							BaseSuite.reportFailLog(
									"Expected placeholder didnt matched with actual placeholder, kindly check.",
									"enterPrivateKeySecretName");
						}

						sendKeys(driver, privateKeySecretName, value.trim());

						isDisplayedInLoop(driver, 1, privateKeySecretName);

						String secretname = getAttribute(driver, privateKeySecretName, "value").trim();

						compareActualNExpectedValue(secretname.trim(), value.trim());

					}

				} else {
					BaseSuite.reportFailLog("Private Key Secret Name input is disabled, kindly check.",
							"enterPrivateKeySecretName");
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate Private Key Secret Name field on current page, kindly check.",
						"enterPrivateKeySecretName");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// Method to validate & enter Private Key Password Secret Name
	public void enterPrivateKeyPasswordSecretName(String value) throws Exception {
		boolean flag = false;
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", privateKeyPasswordSecretName);

			if (isDisplayed(driver, privateKeyPasswordSecretName)) {
				BaseSuite.reportLog("Private Key Password Secret Name field is displayed.");

				if (isEnabled(driver, privateKeyPasswordSecretName)) {
					if (isEditable(driver, privateKeyPasswordSecretName, "private Key Password Secret Name")) {
						clear(driver, privateKeyPasswordSecretName);

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag = verifyplaceholder(privateKeyPasswordSecretName,
								"Enter private key password secret name");

						if (flag) {
							BaseSuite.validationReportLog("correct placeholder is displayed in database input box.");
						} else {
							BaseSuite.reportFailLog(
									"Expected placeholder didnt matched with actual placeholder, kindly check.",
									"enterPrivateKeyPasswordSecretName");
						}

						sendKeys(driver, privateKeyPasswordSecretName, value.trim());

						isDisplayedInLoop(driver, 1, privateKeyPasswordSecretName);

						String secretname = getAttribute(driver, privateKeyPasswordSecretName, "value").trim();

						compareActualNExpectedValue(secretname.trim(), value.trim());

					}

				} else {
					BaseSuite.reportFailLog("Private Key Password Secret Name input is disabled, kindly check.",
							"enterPrivateKeyPasswordSecretName");
				}

			} else {
				BaseSuite.reportFailLog(
						"Unable to locate Private Key Password Secret Name field on current page, kindly check.",
						"enterPrivateKeyPasswordSecretName");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// Comman method to verify String value expected & actual
	public boolean compareActualNExpectedValue(String actualString, String expectedString) {

		boolean flag = false;

		try {
			if ((!actualString.isEmpty()) & (!expectedString.isEmpty())) {

				if (actualString.trim().toLowerCase().equalsIgnoreCase(expectedString.trim().toLowerCase())) {

					BaseSuite.validationReportLog("Expected value : " + expectedString.trim()
							+ " matched successfully with actual value : " + actualString.trim());
					flag = true;

				} else {
					BaseSuite.reportFailLog("Expected value : " + expectedString.trim()
							+ " didn't matched with actual value : " + actualString.trim(),
							"compareActualNExpectedValue");

				}
			} else {

				BaseSuite.reportErrorLog("Unable to match values as either of them is empty : Expected value="
						+ actualString + " & Actual value=" + actualString);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e.toString());
		}
		return flag;
	}

	// click on properties tab
	public void clickOnPropertiesTab() throws Exception {
		try {
			if (isDisplayed(driver, connPropertiesTab)) {
				if (isClickable(driver, connPropertiesTab, "properties", true)) {

					javascript(driver, scrollToElementArg, connPropertiesTab);

					BaseSuite.reportLog("Clicking on properties tab on connection page.");

					Thread.sleep(1000);

					click(driver, connPropertiesTab);

					BaseSuite.validationReportLog("Clicked successfully on properties tab");

				} else {
					BaseSuite.reportFailLog("Properties tab is not clickable, kindly check..", "clickOnPropertiesTab");
				}
			} else {
				BaseSuite.reportErrorLog("Unable to locate properties tab on connection page, kindly check.");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// click on overview tab
	public void clickOnOverviewTab() throws Exception {
		try {
			if (isDisplayed(driver, connOverviewTab)) {
				if (isClickable(driver, connOverviewTab, "properties", true)) {

					BaseSuite.reportLog("Clicking on overview tab on connection page.");

					click(driver, connOverviewTab);

					BaseSuite.validationReportLog("Clicked successfully on overview tab");

				} else {
					BaseSuite.reportFailLog("Overview tab is not clickable, kindly check..", "clickOnPropertiesTab");
				}
			} else {
				BaseSuite.reportErrorLog("Unable to locate overview tab on connection page, kindly check.");
			}
		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	public void clickOnEditButtonfromConnProperty(String propertyName) throws Exception

	{
		try {

			if (isDisplayed(driver, returnElement(editBtnwrtPropName, "$propName", propertyName.trim()))) {
				BaseSuite.reportLog("Edit button for property :: " + propertyName + " is displayed.");

				if (isClickable(driver, returnElement(editBtnwrtPropName, "$propName", propertyName.trim()),
						"property edit", true)) {
					displayAndClick(driver, returnElement(editBtnwrtPropName, "$propName", propertyName.trim()));

					BaseSuite.validationReportLog("Successfully clicked on edit button.");
				} else {
					BaseSuite.reportFailLog("Unable to click on property edit button :: " + propertyName,
							"clickOnEditButtonfromConnProperty");

				}

			} else {
				BaseSuite.reportFailLog("Unable to find the property name :: " + propertyName,
						"clickOnEditButtonfromConnProperty");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// method will enter property name
	public void addConnectionPropertyName(String name) throws Exception {
		try {
			if (isDisplayed(driver, addpropertyNameInput)) {
				BaseSuite.reportLog("Property name input box is displayed.");

				if (!name.isEmpty()) {

					clear_Click_SendKeys(driver, 1, addpropertyNameInput, name);

					BaseSuite.reportLog(name + " is entered in to property name");
				} else {
					BaseSuite.reportErrorLog("Property value parameter is empty, kindly check.");
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate property name input field , kindly check.",
						"addConnectionPropertyName");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// method will enter value
	public void addConnectionPropertyValue(String value) throws Exception {
		try {
			if (isDisplayed(driver, addpropertyValueInput)) {
				BaseSuite.reportLog("Property value input box is displayed.");

				if (!value.isEmpty()) {
					clear_Click_SendKeys(driver, 1, addpropertyValueInput, value.trim());

					BaseSuite.reportLog(value + " is entered in to property value");
				} else {
					BaseSuite.reportErrorLog("Property value parameter is empty, kindly check.");
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate property name input field , kindly check.",
						"addConnectionPropertyName");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// method will select property type from dropdown
	public void selectConnectionPropertyType(String type) throws Exception {
		try {

			if (isDisplayed(driver, clickOnPropertyTypeDropdown)) {
				BaseSuite.reportLog("Property type dropdown is displayed.");

				if (isClickable(driver, clickOnPropertyTypeDropdown, "property type", true)) {
					click(driver, clickOnPropertyTypeDropdown);

					BaseSuite.validationReportLog("Clicked on property type dropdown.");

					isDisplayedInLoop(driver, 3, returnElement(connPropertyType, "$name", type.trim()));

					displayAndClick(driver, returnElement(connPropertyType, "$name", type.trim()));

					BaseSuite.validationReportLog("Property Type selected successfully");
				} else {
					BaseSuite.reportFailLog("Property type dropdown is not clickable, kindly check.",
							"selectConnectionPropertyType");
				}

			} else {

			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// method will click on remove property button
	// method will click on remove
	public void clickOnRemovePropertybutton() throws Exception {
		try {

			if (isDisplayed(driver, removePropertyButton)) {
				BaseSuite.reportLog("Remove property button is displayed.");
				if (isEnabled(driver, removePropertyButton)) {
					BaseSuite.validationReportLog("Remove button is enabled on page.");

					if (isClickable(driver, removePropertyButton, "remove property", true)) {
						click(driver, removePropertyButton);

						BaseSuite.validationReportLog("successfully clicked on remove property button.");
					}
				} else {
					BaseSuite.reportFailLog("Remove property button is disabled, kindly check.",
							"clickOnRemovePropertybutton");
				}
			} else {
				BaseSuite.reportFailLog("Unable to locate remove property button, kindly check.",
						"clickOnRemovePropertybutton");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new AssertionError();
		}
	}

	// method will click on Add property button
	// method will click on add property button
	public void clickOnAddPropertybutton() throws Exception {
		try {

			if (isDisplayed(driver, addpropertyButton)) {
				BaseSuite.reportLog("Add property button is displayed.");
				if (isEnabled(driver, addpropertyButton)) {
					BaseSuite.validationReportLog("Add button is enabled on page.");

					if (isClickable(driver, addpropertyButton, "remove property", true)) {
						click(driver, addpropertyButton);

						BaseSuite.validationReportLog("successfully clicked on add property button.");
					}
				} else {
					BaseSuite.reportFailLog("Add property button is disabled, kindly check.",
							"clickOnRemovePropertybutton");
				}
			} else {
				BaseSuite.reportFailLog("Unable to locate add property button, kindly check.",
						"clickOnRemovePropertybutton");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// method will return timestamp
	public String returnCurrentTimestap() throws Exception {
		try {

			String timeS = null;

			final SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			timeS = temp.format(timestamp);

			return timeS;

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}

	}

	public void addTimeStampToConnectionName(String connectionName) throws Throwable {
		String connectionNameTime;
		try {

			isDisplayedInLoop(driver, 2, connName);

			String getTextC = getAttribute(driver, connName, valueAttribute);

			String upend = returnCurrentTimestap();

			if (connectionName.equalsIgnoreCase(getTextC)) {
				connectionNameTime = getTextC + "_" + upend;

				clear_Click_SendKeys(driver, 1, connName, connectionNameTime);
			} else {
				BaseSuite.reportFailLog(
						"Unable to match connection name entered with expected hence skipped adding timestamp to connection name.",
						upend);
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// method to add connection properties to connection
	public boolean addConnectionPropertiesToConnection(String jsonEntity, int count) throws Exception {
		boolean flag = true;
		try {
			if (count > 0) {
				clickOnPropertiesTab();

				Thread.sleep(1000);

				/// boolean create= CreateConnectionDefaultPropHandler(jsonEntity);

				ArrayList<String> name = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..name");

				ArrayList<String> value = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..value");

				ArrayList<String> type = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..type");

				for (int j = 0; j < name.size(); j++) {

				
					addConnectionProperty(jsonEntity,j, name.get(j), value.get(j), type.get(j));


				}
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();

		}
		return flag;
	}

	public void enterConnPropertyName(String name) {
		try {

			
			isDisplayedInLoop(driver, 2, addPropertyName);


			//javascript(driver, "arguments[0].scrollIntoView(true);", addPropertyName);


			if (!name.isEmpty()) {
				if (isEnabled(driver, addPropertyName)) {
					if (isClickable(driver, addPropertyName, "property name", true)) {
						BaseSuite.reportLog("Entering property Name as " + name);

						clear_SendKeys(driver, addPropertyName, name);

						BaseSuite.validationReportLog("Poperty Name entered successfully");

						String connPropName = getAttribute(driver, addPropertyName, valueAttribute);

						stringContainsOutput(connPropName.trim(), name.trim(), true);

						click(driver, addPropertyValue);

					}
				} else {
					BaseSuite.reportErrorLog("Property name field is disabled, kindly check.");
				}
			} else {
				BaseSuite.reportErrorLog("Unable to proceed as property name is empty , kindly check.");
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void enterConnPropertyValue(String value) {
		try {

			isDisplayedInLoop(driver, 2, addPropertyValue);

			if (!value.isEmpty()) {
				if (isEnabled(driver, addPropertyValue)) {
					if (isClickable(driver, addPropertyValue, "property value", true)) {
						BaseSuite.reportLog("Entering property value as " + value);


						clear_SendKeys(driver, addPropertyValueInput, value);

						BaseSuite.validationReportLog("Property value entered successfully");

						String connPropValue = getAttribute(driver, addPropertyValueInput, valueAttribute);
						
						stringContainsOutput(connPropValue.trim(), value.trim(), true);
					}
				} else {
					BaseSuite.reportErrorLog("Property value field is disabled, kindly check.");
				}
			} else {
				BaseSuite.reportErrorLog("Unable to proceed as property value is empty , kindly check.");
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void selectPropertyType(String type) {

		try {
			isDisplayedInLoop(driver, 2, addPropertyTypeClick);

			if (!type.isEmpty()) {
				if (isDisplayed(driver, addPropertyTypeClick)) {
					if (isClickable(driver, addPropertyTypeClick, "property type", true)) {
						// javascript(driver, "arguments[0].click();", addPropertyTypeClick);

						click(driver, addPropertyTypeClick);

						BaseSuite.reportLog("Clicked on property type dropdown");

						Thread.sleep(2000);

						if (isDisplayed(driver, propTypeListPane)) {
							BaseSuite.reportLog("System & User options are displayed.");

							List<WebElement> typeList = getElements(driver, propListOptions);

							for (int i = 0; i < typeList.size(); i++) {
								String label = typeList.get(i).getAttribute("data-value");

								if (label.equalsIgnoreCase(type.trim())) {
									typeList.get(i).click();

									BaseSuite.reportLog(type + " is selected from type list.");
									break;
								}
							}

							String propType = getAttribute(driver, addPropertyTypeClick, attributeTextContent);

							stringContainsOutput(propType.trim(), type.trim(), true);

						}

					}
				} else {
					BaseSuite.reportErrorLog("Unable to locate property type, kindly check.");
				}

			} else {
				BaseSuite.reportErrorLog("Unable to proceed as property type is empty , kindly check.");
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void clickonAddPropertyIconButton() {
		try {
			if (isDisplayed(driver, addPropertyDone)) {
				if (isEnabled(driver, addPropertyDone)) {
					if (isClickable(driver, addPropertyDone, "add property icon", true)) {
						BaseSuite.reportLog("Clicking on add property icon  button");

						displayAndClick(driver, addPropertyDone);

						BaseSuite.validationReportLog("add property icon button clicked successfully.");
					} else {
						BaseSuite.reportFailLog("Add property icon button is not clickable, kindly check.",
								"clickonAddPropertyIconButton");
					}
				} else {
					BaseSuite.reportErrorLog("Add property icon button is disabled in UI , kindly check.");
				}

			} else {
				BaseSuite.reportErrorLog("Add property icon button is not displayed in UI , kindly check.");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void addConnectionProperty(String connJsonEntity, int i, String name, String value, String type) {

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			String connectorName = setConnectorIdToConnectorName(connParam.getConnectorID());

			boolean flag = false;

			if ((connectorName.contains("Oracle")) || (connectorName.contains("Snowflake"))) {

				List<WebElement> propNameList = getElements(driver, existingPropName);

				String pName = propNameList.get(i).getText();

				if (!pName.equalsIgnoreCase(name)) {

					flag = true;
				}

			}

			else {

				flag = true;

			}

			if (flag) {
				Thread.sleep(1000);

				clickOnAddPropertybutton();

				enterConnPropertyName(name.trim());

				enterConnPropertyValue(value.trim());

				selectPropertyType(type.trim());

				clickonAddPropertyIconButton();

			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	// Method to view and check details of property pane.
	public void verifyPropertyPane(String jsonEntity) {
		try {
			clickOnPropertiesTab();

			BaseSuite.reportLog("Verifying how many properties available in this connection.");

			ArrayList<String> pname = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
					"$.connectionProperties..name");

			ArrayList<String> pvalue = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
					"$.connectionProperties..value");

			ArrayList<String> ptype = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
					"$.connectionProperties..type");

			List<WebElement> name = getElements(driver, existingPropName);

			int pCount = name.size();
			int count = pname.size();

			if (count == pCount) {
				BaseSuite.validationReportLog(
						"This connection has connection properties i.e " + count + " are added and viewed.");
			} else {
				BaseSuite.reportFailLog(
						"This connection has connection properties , but its count didnt matched. expected::" + count
								+ " & actual ::" + pCount + ".Kindly check.",
						"verifyPropertyPane");
			}

			if (isDisplayed(driver, existingPropCheckbox)) {
				BaseSuite.reportLog("Property check boxes are displayed.");

				if (!isClickable(driver, existingPropCheckbox, "property checkbox", true)) {
					BaseSuite.reportFailLog("Checkboxes are not clickable, kindly check.", "verifyPropertyPane");
				}
			}

			for (int i = 0; i < count; i++) {
				boolean status = verifyConnectionPropertyFields(pname.get(i), pvalue.get(i), ptype.get(i));

				if (status) {
					BaseSuite.validationReportLog("Successfully Match Connection Property Details");

				} else {
					BaseSuite.reportFailLog("Unable to match connection property details, kindly check.",
							"verifyPropertyPane");

				}
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public boolean verifyConnectionPropertyFields(String name, String value, String type) {
		boolean flag = false;
		try {
			String pName, pValue, pType;
			// verify property name

			List<WebElement> elementN = getElements(driver, existingPropName);

			// verify property value
			List<WebElement> elementV = getElements(driver, existingPropValue);
			// verify property type

			List<WebElement> elementT = getElements(driver, existingPropType);

			for (int j = 0; j < elementN.size(); j++) {

				pName = elementN.get(j).getText();

				pValue = elementV.get(j).getText();

				pType = elementT.get(j).getText();

				if (name.trim().equalsIgnoreCase(pName)) {
					BaseSuite.validationReportLog("Property name: " + name + " matched with expected.");

					flag = true;

					if (value.trim().equalsIgnoreCase(pValue)) {
						BaseSuite.validationReportLog("Property value: " + value + " matched with expected.");
						flag = true;
					}

					if (type.trim().equalsIgnoreCase(pType)) {
						BaseSuite.validationReportLog("Property type: " + type + " matched with expected.");
						flag = true;
					} else {
						BaseSuite.reportFailLog("Element not visible kindly check", "verifyConnectionPropertyFields");
					}
					break;
				}

			}

			/*
			 * else { flag=false; } if(value.trim().equalsIgnoreCase(pValue)) {
			 * BaseSuite.validationReportLog("Property value: "
			 * +value+" matched with expected."); flag=true; } else { flag=false; } else {
			 * flag=false; }
			 */

		} catch (Exception e) {
			e.getMessage();
		}
		return flag;
	}

	// Method to view Username for system Connection.
	public void viewUsernameFieldWithSystemConnection(String value) {
		String methodName = "viewUsernameFieldWithSystemConnection";
		try {

			javascript(driver, "arguments[0].scrollIntoView(true);", connUsernameInput);

			if (isDisplayed(driver, connUsernameInput)) {
				BaseSuite.reportLog("Username field is displayed.");

				if (isEnabled(driver, connUsernameInput)) {
					BaseSuite.reportLog("Username field is enabled.");

					if (!(isEditable(driver, connUsernameInput, "username"))) {
						BaseSuite.reportFailLog("Username field is not editable.Kindly check.", methodName);
					}
					BaseSuite.reportLog("Verifying username field value:");

					String actualValue = getAttribute(driver, connUsernameInput, "value");

					compareActualNExpectedValue(actualValue, value);

				} else {
					BaseSuite.reportFailLog("Username field is disabled in case of system connection., kindly check.",
							methodName);
				}
			} else {
				BaseSuite.reportFailLog("Unable to locate username field as it not displayed, kindly check.",
						methodName);
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	// Method to view Username for User Connection.
	public void viewUsernameFieldWithUserConnection() {

		String methodName = "viewUsernameFieldWithSystemConnection";
		try {

			javascript(driver, "arguments[0].scrollIntoView(true);", connUsernameInput);

			if (isDisplayed(driver, connUsernameInput)) {
				BaseSuite.reportLog("Username field is displayed.");

				if (isEnabledAsPerClassName(connUsernameInput)) {
					BaseSuite.reportLog("Username field is disabled.");

					if (!(isEditable(driver, connUsernameInput, "username"))) {
						BaseSuite.reportFailLog("Username field is not editable.Kindly check.", methodName);
					}
					boolean flag = verifyplaceholder(connUsernameInput, "Enter username");

					if (flag) {
						BaseSuite.validationReportLog("correct placeholder is displayed in username input box.");
					} else {
						BaseSuite.reportFailLog(
								"Expected placeholder didnt matched with actual placeholder, kindly check.",
								methodName);
					}

				} else {
					BaseSuite.reportFailLog("Username field is disabled in case of user connection, kindly check.",
							methodName);
				}
			} else {
				BaseSuite.reportFailLog("Unable to locate username field as it not displayed, kindly check.",
						methodName);
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// Method to view Connection Type for system connection
	public void viewConnectionTypeForSystemConn() {
		String methodName = "viewConnectionTypeWithoutJDBCURL";

		try {
			BaseSuite.reportLog("Verifying connection type field.");

			javascript(driver, "arguments[0].scrollIntoView(true);", connTypeSelectionDropdown);

			if (isDisplayed(driver, connTypeSelectionDropdown)) {
				BaseSuite.reportLog("Connection type field is displayed.");

				if (isEnabledAsPerClassName(connTypeSelectionDropdown)) {
					BaseSuite.validationReportLog("Connection type is enabled.");

					if (!isClickable(driver, connTypeSelectionDropdown, "connection type", true)) {
						BaseSuite.reportFailLog("Connection type field is not clickable.Kindly check.", methodName);
					}

					BaseSuite.reportLog("Verifying connection type field selected value:");

					String actualValue = getAttribute(driver, connTypeSelectionDropdown, "textContent");

					compareActualNExpectedValue(actualValue, "system");
				} else {
					BaseSuite.reportFailLog(
							"Connection type is disabled even when JDBC url is not selected, kindly check.",
							methodName);
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate connection type field as its not displayed, kindly check.",
						methodName);
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	// Method to view Connection Type for User connection
	public void viewConnectionTypeForUserConn() {
		String methodName = "viewConnectionTypeWithoutJDBCURL";

		try {
			BaseSuite.reportLog("Verifying connection type field.");

			javascript(driver, "arguments[0].scrollIntoView(true);", connTypeSelectionDropdown);

			if (isDisplayed(driver, connTypeSelectionDropdown)) {
				BaseSuite.reportLog("Connection type field is displayed.");

				if (!(isEnabledAsPerClassName(connTypeSelectionDropdown))) {
					BaseSuite.validationReportLog("Connection type in user connections is disabled.");

					BaseSuite.reportLog("Verifying connection type field displayed value:");

					String actualValue = getAttribute(driver, connTypeSelectionDropdown, "textContent");

					compareActualNExpectedValue(actualValue, "user");
				} else {
					BaseSuite.reportFailLog("Connection type is enabled in user connection, kindly check.", methodName);
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate connection type field as its not displayed, kindly check.",
						methodName);
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	// Method to view Password field for System connection
	public void viewPasswordFieldWithSystemConnection() {
		String methodName = "viewUsernameFieldWithSystemConnection";
		try {

			javascript(driver, "arguments[0].scrollIntoView(true);", connPasswordInput);

			if (isDisplayed(driver, connPasswordInput)) {
				BaseSuite.reportLog("Password field is displayed.");

				if (isEnabled(driver, connPasswordInput)) {
					BaseSuite.reportLog("Password field is enabled.");

					if (!(isEditable(driver, connPasswordInput, "Password"))) {
						BaseSuite.reportFailLog("Password field is not editable.Kindly check.", methodName);
					}
					BaseSuite.reportLog("Verifying password field value:");

					String actualValue = getAttribute(driver, connPasswordInput, "value");

					if (actualValue.isEmpty()) {
						BaseSuite.reportErrorLog("Password field on system connection page is empty,kindly check.");
					}

				} else {
					BaseSuite.reportFailLog("Password field is disabled in case of system connection., kindly check.",
							methodName);
				}
			} else {
				BaseSuite.reportFailLog("Unable to locate password field as it not displayed, kindly check.",
						methodName);
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	// Method to view Password field for User connection
	public void viewPasswordFieldWithUserConnection() {

		String methodName = "viewUsernameFieldWithSystemConnection";
		try {

			javascript(driver, "arguments[0].scrollIntoView(true);", connPasswordInput);

			if (isDisplayed(driver, connPasswordInput)) {
				BaseSuite.reportLog("Password field is displayed.");

				if (isEnabled(driver, connPasswordInput))//
				{
					BaseSuite.reportLog("Password field is enabled.");

					if (!(isEditable(driver, connPasswordInput, "Password"))) {
						BaseSuite.reportFailLog("Password field is not editable.Kindly check.", methodName);
					}

				} else {
					BaseSuite.reportFailLog("Password field is disabled in case of user connection, kindly check.",
							methodName);
				}
			} else {
				BaseSuite.reportFailLog("Unable to locate password field as it not displayed, kindly check.",
						methodName);
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// comman method to check visibility of input boxes based on JDBC url condition
	// as well

	public void verifyConnElementNItsVisibility(By locator, String locatorname, String valueToVerify, String jdbcFlag,
			String connectionType) throws Exception {
		String methodName = "verifyConnElementNItsVisibility";

		try {

			boolean actual = false;
			String strVisiblityA = null, strVisiblityE = null;

			javascript(driver, "arguments[0].scrollIntoView(true);", locator);

			if (connectionType.equalsIgnoreCase("system")) {
				if (isDisplayed(driver, locator)) {
					BaseSuite.reportLog(locatorname + " field is displayed.");

					verifyElementVisibilityAsPerJDBCFlag(jdbcFlag, locator, locatorname, connectionType);
					// verifying data

					if (!jdbcFlag.isEmpty()) {
						if (jdbcFlag.trim().toLowerCase().equalsIgnoreCase("true")) {
							verifyWhenJDBCUrlIsTrue(locator, locatorname, valueToVerify, methodName);

						} else if (jdbcFlag.trim().toLowerCase().equalsIgnoreCase("false")) {
							verifyWhenJDBCUrlIsFalse(locator, locatorname, valueToVerify, methodName, connectionType);

						} else {
							BaseSuite.reportErrorLog("Unable to process given value: " + jdbcFlag + ",kindly check.");
						}
					} else {
						BaseSuite.reportErrorLog("JDBC flag is empty kindly check.");
					}
				} else {
					BaseSuite.reportFailLog("Unable to locate " + locatorname
							+ " field as it not displayed for connection type:: " + connectionType + ", kindly check.",
							methodName);
				}
			} else if (connectionType.equalsIgnoreCase("user")) {
				if (isDisplayed(driver, locator)) {
					BaseSuite.reportLog(locatorname + " field is displayed.");

					verifyElementVisibilityAsPerJDBCFlag(jdbcFlag, locator, locatorname, connectionType);
					// verifying content of element

					if (!jdbcFlag.isEmpty()) {
						if (jdbcFlag.trim().toLowerCase().equalsIgnoreCase("true")) {
							verifyWhenJDBCUrlIsTrue(locator, locatorname, valueToVerify, methodName);

						} else if (jdbcFlag.trim().toLowerCase().equalsIgnoreCase("false")) {
							verifyWhenJDBCUrlIsFalse(locator, locatorname, valueToVerify.trim(), methodName,
									connectionType);

						} else {
							BaseSuite.reportErrorLog("Unable to process given value: " + jdbcFlag + ",kindly check.");
						}
					} else {
						BaseSuite.reportErrorLog("JDBC flag is empty kindly check.");
					}

				} else {
					BaseSuite.reportFailLog("Unable to locate " + locatorname
							+ " field as it not displayed for connection type:: " + connectionType + ", kindly check.",
							methodName);
				}

			} else {
				BaseSuite.reportErrorLog(
						"Unable to match value of connection type as its different from system or user. Actual received:: "
								+ connectionType);
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}

	}

	public void verifyWhenJDBCUrlIsTrue(By locator, String locatorname, String placeholder, String methodName) {
		boolean status = false;
		String placeholderValue = null;
		try {

			if (placeholder == null) {

				BaseSuite.reportLog("Verifying placeholder is present in input box.");

				if (locator.equals(accountIdentifierInput)) {
					placeholderValue = ConstantProperty.placeholderAccountIdentifier;

				} else if (locator.equals(connWarehouseInput)) {
					placeholderValue = ConstantProperty.placeholderWarehouse;
				} else if (locator.equals(connDatabaseInput)) {
					placeholderValue = ConstantProperty.placeholderDatabase;
				} else {
					System.out.println("Unable to process locator value in Method :: verifyWhenJDBCUrlIsTrue");
				}

				status = verifyplaceholder(locator, placeholderValue); // "Enter "+locatorname

				if (status) {
					BaseSuite.validationReportLog("correct placeholder is displayed in " + locatorname + " input box.");
				} else {
					BaseSuite.reportFailLog("Expected placeholder didnt matched with actual placeholder, kindly check.",
							methodName);
				}
			}

		} catch (NullPointerException e) {
			BaseSuite.reportErrorLog("Value parameter is null, kindly check details :: " + e.toString());

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void verifyWhenJDBCUrlIsFalse(By locator, String locatorname, String data, String methodName,
			String connectionType) {

		try {
			if ((!isEditable(driver, locator, locatorname)) & (connectionType.trim().equalsIgnoreCase("system"))) {
				BaseSuite.reportFailLog(locatorname + " field is not editable.Kindly check.", methodName);
			}

			BaseSuite.reportLog("Verifying " + locatorname + " field value:");

			String actualValue = getAttribute(driver, locator, "value");

			compareActualNExpectedValue(actualValue, data);

		} catch (Exception e) {
			e.getMessage();
			throw new AssertionError();
		}
	}

	// verify visibility of element based on jdbc flag
	public void verifyElementVisibilityAsPerJDBCFlag(String jdbcFlag, By locator, String locatorName,
			String connectionType) {
		String strVisiblityA, strVisiblityE;
		boolean actual, expected = false;

		try {
			if (!jdbcFlag.isEmpty()) {
				actual = isEnabledAsPerClassName(locator);

				if (jdbcFlag.trim().toLowerCase().equalsIgnoreCase("true")) {
					strVisiblityE = returnStringAsPerBooleanValue(expected);
					strVisiblityA = returnStringAsPerBooleanValue(actual);

					if (actual == expected) {
						BaseSuite.validationReportLog(
								"Visibility of " + locatorName + " field is matched, as its " + strVisiblityA + ".");
					} else {
						BaseSuite.reportFailLog("Visibility of " + locatorName + " field doesnt matched with actual",
								"verifyElementVisibilityAsPerJDBCFlag");
					}

				} else if (jdbcFlag.trim().toLowerCase().equalsIgnoreCase("false")) {
					strVisiblityA = returnStringAsPerBooleanValue(actual);

					if (connectionType.equalsIgnoreCase("system")) {
						expected = true;
					} else {
						expected = false;
					}
					strVisiblityE = returnStringAsPerBooleanValue(expected);

					if (actual == expected) {
						BaseSuite.validationReportLog(
								"Visibility of " + locatorName + " field is matched, as its " + strVisiblityA + ".");
					} else {
						BaseSuite.reportFailLog("Visibility of " + locatorName + " field doesnt matched with actual",
								"verifyElementVisibilityAsPerJDBCFlag");
					}
				}

			} else {
				BaseSuite.reportErrorLog("JDBC flag is empty kindly check.");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// return class flag
	public String returnStringAsPerBooleanValue(boolean state) {
		String tempVar = null;
		try {

			if (state) {
				tempVar = "enabled";
			} else {
				tempVar = "disabled";
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return tempVar;
	}

	// method will check enabled or not with respect to class value
	public boolean isEnabledAsPerClassName(By locator) {
		boolean flag = false;
		String strState = "disabled";
		try {
			String classValue = getAttribute(driver, locator, "class");

			if (classValue.trim().contains(strState)) {
				flag = false;
			} else {
				flag = true;
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return flag;
	}

	/**
	 * Enter connection name method - state is for valid / invalid connection name
	 * field if state = true then valid data else invalid data
	 **/
	public boolean entervalueInTextFieldWithValidation(By locator, String label, String inputvalue, String scenario,
			String validationMessage, boolean state) throws NoSuchElementException {

		String methodName = "enterConnectionName";
		boolean flag = false;
		try {
			isDisplayedInLoop(driver, 4, locator);

			javascript(driver, scrollToElementArg, locator);

			isClickable(driver, locator, label + " field", state);

			if (isEditable(driver, locator, label + " field") && state) {

				click(driver, locator);

				clear(driver, locator);

				BaseSuite.reportLog("Entering value : " + inputvalue);
				if (!inputvalue.isEmpty()) {
					sendKeys(driver, locator, inputvalue);
				} else if (scenario.equalsIgnoreCase("invalid")) {
					sendKeys(driver, locator, "emptyvalue");
					clear(driver, locator);
				}
				String ac = getAttribute(driver, locator, valueAttribute);

				stringContainsOutput(ac, inputvalue, true);

				if (validationMessage.isEmpty()) {
					validationMessageOfField(returnElement(connAllFieldValidation, dynamicName, label.toLowerCase()),
							label, "", false);

				} else {
					String acmesg = validationMessageOfField(
							returnElement(connAllFieldValidation, dynamicName, label.toLowerCase()), label,
							validationMessage, true);
					if (validationMessage.equalsIgnoreCase(acmesg)) {
						flag = true;
					} else {
						flag = false;
					}
				}

			} else {
				BaseSuite.reportFailLog(label + " field not editable", methodName);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog("Exception found : " + e.getMessage());
			throw new NoSuchElementException();
		}
		return flag;
	}

	public boolean updateConnectionDefaultPropHandler(String jsonEntity) {
		boolean flag = false;
		try {

			if (isDisplayed(driver, existingPropName)) {

				BaseSuite.validationReportLog("existing Property Name field is visible ");

				BaseSuite.validationReportLog("Property Name is visible");

				ArrayList<String> name = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..name");
				if (name.size() > 0) {

					List<WebElement> propNameList = getElements(driver, existingPropName);

					for (int i = 0; i < name.size(); i++) {

						String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								"$.connectionProperties[" + i + "].name");

						String pName = propNameList.get(i).getText();

						if (val.equalsIgnoreCase(pName)) {
							BaseSuite.validationReportLog("Property name: " + pName + " matched with expected.");

							flag = true;

						} else {
							BaseSuite.reportFailLog("Property Name not visible ", "connectionDefaultPropHandler");
							flag = false;
							// Enter Add Code
						}
						break;
					}
				}

			}
		} catch (Exception e) {
			e.getMessage();
			throw new NoSuchElementException();
		}
		return flag;
	}

	public boolean CreateConnectionDefaultPropHandler(String jsonEntity) {
		boolean flag = false;
		try {

			if (isDisplayed(driver, existingPropName)) {

				BaseSuite.validationReportLog("existing Property Name field is visible ");

				BaseSuite.validationReportLog("Property Name is visible");

				ArrayList<String> name = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..name");// 1,2
				if (name.size() > 0) {

					List<WebElement> propNameList = getElements(driver, existingPropName);
					// 0,1

					for (int i = 0; i < name.size(); i++) {

						String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								"$.connectionProperties[" + i + "].name");

						// List<WebElement> propNameList = getElements(driver, existingPropName);
						String pName = propNameList.get(i).getText();

						if (val.equalsIgnoreCase(pName)) {
							BaseSuite.validationReportLog("Property name: " + pName + " matched with expected.");

							flag = true;

						} else {
							BaseSuite.reportFailLog("Property Name not visible ", "connectionDefaultPropHandler");
							flag = false;
							// Enter Add Code
						}
						break;
					}
				}

			}
		} catch (Exception e) {
			e.getMessage();
			throw new NoSuchElementException();
		}
		return flag;
	}

	public boolean enterUsernamePasswordToSqlServerConnection(String connJsonEntity, String sqlusername,
			String winusername, String newconnectionName, String icedqUser) {
		boolean flag = true;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);

		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);
			if (!icedqUser.toLowerCase().contains("reader")) {

				if (connParam.getType().trim().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

					Thread.sleep(1000);

					cp.clickOnUserConnectionTab();

					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}

					cp.searchAndClickOnConnectionNameInConnRepo(newconnectionName);

					inVisible(driver, spinner, Constant.ruleWait);
					Thread.sleep(2000);

					if ((connParam.getAuthenticationname()).equalsIgnoreCase("SQL Server Authentication")) {

						if (isDisplayed(driver, connsecretName)) {

							cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);

							cp.enterUsername(sqlusername);

						}

					} else if ((connParam.getAuthenticationname()).equalsIgnoreCase("Windows Authentication")) {

						if (isDisplayed(driver, connsecretName)) {

							cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);

							cp.enterUsername(winusername);

						}

					}
					Thread.sleep(1000);

					cp.saveConnection();

					cp.clickOnUserConnectionTab();

					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}

					cp.searchConnection(newconnectionName);

					cp.getConnection(newconnectionName, update_actualValue);

					cp.clickOnUserConnectionTab();

					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}

					cp.searchAndClickOnConnectionNameInConnRepo(newconnectionName);

					flag = cp.testConnection(connectionTestMess);

					cp.clickOnUserConnectionTab();

					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}

					cp.searchConnection(newconnectionName);

					cp.getConnection(newconnectionName, create_actualValue);

				} else {

					flag = cp.testConnection(connectionTestMess);

					cp.clickOnConnectionsTab();

					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}

					cp.searchConnection(newconnectionName);

					cp.getConnection(newconnectionName, create_actualValue);
				}
			} else {
				Thread.sleep(3000);

				if ((connParam.getAuthenticationname()).equalsIgnoreCase("SQL Server Authentication")) {

					enterUsername(sqlusername);

					cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
							connParam.getConnectorID(), icedqUser);

				} else if ((connParam.getAuthenticationname()).equalsIgnoreCase("Windows Authentication")) {

					enterUsername(winusername);

					cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
							connParam.getConnectorID(), icedqUser);

				}
				flag = cp.saveConnection(forbiddenToastMsg);

			}
		} catch (Exception e) {

			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("user connection not updated properly kindly check :" + e.toString());
		}

		return flag;
	}

	/******* SQL Server Native Method Creation start *********/
	public boolean createSQLserverConnection(String connJsonEntity, String testScenario, String validationMessage,
			String icedqUser) {
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		NewConnectionRepoPage np = new NewConnectionRepoPage(driver);
		boolean flag = true;
		String newconnectionName = null;
		String sqlusername = null;
		String sqlpassword = null;
		String winusername = null;
		String winpassword = null;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			String drivertype = setDriverType(connParam.getDriverName());

			// String timestamp = new
			// SimpleDateFormat(ConstantProperty.CONNECTIONNAME_TIMESTAMPFORMAT).format(new
			// Date());

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME;

			String authName = setAuthenticationType(connParam.getAuthentication());

			if ((authName).equalsIgnoreCase("SQL Server Authentication")) {

				sqlusername = getConnectionDetailsUsingAuthType("sqlserver", 1);

				// sqlpassword = getConnectionDetailsUsingAuthType("sqlserver", 2);
			} else if ((connParam.getAuthenticationname()).equalsIgnoreCase("Windows Authentication")) {
				winusername = getConnectionDetailsUsingAuthType("windows", 1);

				// winpassword = getConnectionDetailsUsingAuthType("windows", 2);

			}

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			flag = clickOnNewConnectionBtn(icedqUser);

			if (flag) {

				cp.chooseConnectorType(connParam.getConnectorID());

				inVisible(driver, spinner, Constant.ruleWait);

				String wizardStatus = cp.validateNewConnPageButtonsFields(connParam.getConnectorID());

				if (wizardStatus.contains("Wizard supported connector")) {

					verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", false);
				}

				verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

				verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);

				verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

				verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", false);

				verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", false);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				flag = cp.enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

				selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

				selectAuthenticationOfConnection(authName);

				if (drivertype.equalsIgnoreCase("SQL Server Native JDBC")
						&& connParam.getAuthenticationname().equalsIgnoreCase("Windows Authentication")) {
					np.validatAndeEnterValueToTextField(domainname, conndomainnameInputField,
							ConstantProperty.CONN_FIELD_DOMAINNAME, connDomainnamePlaceholder,
							connParam.getDomainName(), "");

					np.validatAndeEnterValueToTextField(instancename, conninstancenameInputField,
							ConstantProperty.CONN_FIELD_INSTANCENAME, connInstancenamePlaceholder,
							connParam.getInstaceName(), "");
				}

				boolean cs = np.selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

				enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());

				if (cs) {

					np.validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
							connHostPlaceholder, false);
					np.validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
							connPortPlaceholder, false);
					np.validateInputFieldVisibility(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
							connDatabasePlaceHolder, false);

				} else {

					np.validatAndeEnterValueToTextField(connHostTitle, connHostInputField,
							ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder, connParam.getHost(),
							validationHostEmpty);

					np.validatAndeEnterValueToTextField(connPortTitle, connPortInputField,
							ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder, connParam.getPort(),
							validationPortEmpty);

					np.validatAndeEnterValueToTextField(connDatabaseTitle, connDatabaseInputField,
							ConstantProperty.CONN_FIELD_DATABASE, connDatabasePlaceholder, connParam.getDatabaseName(),
							validationDatabaseEmpty);
				}
				np.selectConnectionType(connParam.getType());

				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)
						&& (connParam.getAuthenticationname()).equalsIgnoreCase("SQL Server Authentication")) {

					enterUsername(sqlusername);

					cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
							connParam.getConnectorID(), icedqUser);

				} else if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)
						&& (connParam.getAuthenticationname()).equalsIgnoreCase("Windows Authentication")) {

					enterUsername(winusername);

					cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
							connParam.getConnectorID(), icedqUser);

				}

				else {

					validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME,
							connUsernamePlaceholder, false);
					validateInputFieldVisibility(connsecretUserPassword, ConstantProperty.CONN_FIELD_PASSWORD, "",
							false);

				}

				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

				int count = connPropertyList.size();

				addConnectionPropertiesToConnection(connJsonEntity, count);

				if (icedqUser.toLowerCase().contains("owner")) {

					flag = cp.saveConnection(connectionSaveMesssage);

					cp.clickOnConnectionsTab();

					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}

					cp.searchConnection(newconnectionName);

					cp.getConnection(newconnectionName, update_actualValue);

					cp.searchAndClickOnConnectionNameInConnRepo(newconnectionName);

					if (flag || (isEnabled(driver, connDuplicateButton) && isEnabled(driver, connDeleteButton))) {

						flag = enterUsernamePasswordToSqlServerConnection(connJsonEntity, sqlusername, winusername,
								newconnectionName, icedqUser);
					}
				} else {

					flag = cp.saveConnection(forbiddenToastMsg);
				}

			}
		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog("Connection not created properly due to exception kindly check " + e.toString());
		}

		return flag;

	}

	public boolean updateUsernamePasswordToSqlServerConnection(String connJsonEntity, String sqlusername,
			String winusername, String icedqUser) {
		boolean flag = true;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);

		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			if (connParam.getType().trim().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {
				if (icedqUser.contains("contributor") || (icedqUser.contains("executor"))) {
					if ((connParam.getAuthenticationname()).equalsIgnoreCase("SQL Server Authentication")) {

						if (isDisplayed(driver, connsecretName)) {

							cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);

							cp.enterUsername(sqlusername);
						}
					} else if ((connParam.getAuthenticationname()).equalsIgnoreCase("Windows Authentication")) {

						if (isDisplayed(driver, connsecretName)) {

							cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);

							cp.enterUsername(winusername);
						}
					}
					saveConnection();
					waitForExecution(1000);
					inVisible(driver, spinner, Constant.ruleWait);
					flag = testConnection(connectionTestMess);

				}

				else if (icedqUser.contains("owner")) {
					flag = testConnection(connectionTestMess);

				} else {
					if (icedqUser.contains("reader")) {
						waitForExecution(1000);
						flag = cp.clickQuickAddbtn(forbiddenToastMsg);
					}
				}
			} else {
				if (icedqUser.contains("contributor") || (icedqUser.contains("executor"))) {
					saveConnection(updateAndSaveClickErrorMessage);
				}
				waitForExecution(1000);

				if (icedqUser.contains("owner")) {
					saveConnection();

					flag = testConnection(connectionTestMess);
				} else if (icedqUser.contains("reader")) {

					waitForExecution(1000);

					saveConnection(updateAndSaveClickErrorMessage);
				}
			}
		} catch (Exception e) {

			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("user connection not updated properly kindly check :" + e.toString());
		}

		return flag;
	}

	/** View SQL server details method **/

	public boolean viewSQLServerMethod(String connJsonEntity, String driverName) {
		boolean flag = true;
		NewConnectionRepoPage np = new NewConnectionRepoPage(driver);
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {
			ConnectionPoJO connParam = np.setConnectionParametersForApi(connJsonEntity);

			String drivertype = setDriverType(connParam.getDriverName());

			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				inVisible(driver, spinner, Constant.ruleWait);

				np.viewAndValidateConnectionField(connName, "Connection Name", connParam.getConnName(), true);

				np.viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, true);

				np.viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
						connParam.getAuthenticationname(), true);

				if (drivertype.equalsIgnoreCase("SQL Server Native JDBC")
						&& connParam.getAuthenticationname().equalsIgnoreCase("Windows Authentication")) {
					np.viewAndValidateConnectionField(conndomainnameInputField, ConstantProperty.CONN_FIELD_DOMAINNAME,
							connParam.getDomainName(), true);

					np.viewAndValidateConnectionField(conninstancenameInputField,
							ConstantProperty.CONN_FIELD_INSTANCENAME, connParam.getInstaceName(), true);
				}

				verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

				if (connParam.getCustomJdbcFullUrl().equalsIgnoreCase(booleanTrue)) {

					np.viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
							connParam.getCustomJDBCURLValue(), true);

					np.viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST, "", false);

					np.viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT, "", false);

					np.viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE, "",
							false);

				} else {

					np.viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
							connParam.getCustomJDBCURLValue(), false);

					np.viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
							connParam.getHost(), true);

					np.viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
							connParam.getPort(), true);

					np.viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
							connParam.getDatabaseName(), true);
				}
				if (isDisplayed(driver, connsecretName)) {

					validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", true);

					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					waitForExecution(1000);

					verifyVisibilityOfButtons(driver, connsecretManagebtn, "Manage Button", true);

					verifyVisibilityOfButtons(driver, connsecretQuickAddbtn, "Quick Add Button", true);

					validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "", true);

					validateInputFieldVisibility(connsecretPasswordfeild, ConstantProperty.CONN_FIELD_PASSWORD, "",
							true);
				} else {

					isDisplayedInLoop(driver, 5, connvaultOnOffLabel);

					BaseSuite.validationReportLog("Enable Vault Label shows Clearly");

					isDisplayed(driver, connvaultOnOff);

					BaseSuite.validationReportLog("Enable Vault Checkbox shows Clearly");

					validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "", true);

					validateInputFieldVisibility(connPasswordInput, ConstantProperty.CONN_FIELD_PASSWORD, "", true);

				}

				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

				int count = connPropertyList.size();

				flag = cp.viewAndValidateConnectionPropertiesToConnection(connJsonEntity, count);

			} else {

				inVisible(driver, spinner, Constant.ruleWait);

				np.viewAndValidateConnectionField(connName, "Connection Name", connParam.getConnName(), false);

				np.viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, false);

				np.viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
						connParam.getAuthenticationname(), false);

				if (drivertype.equalsIgnoreCase("SQL Server Native JDBC")
						&& connParam.getAuthenticationname().equalsIgnoreCase("Windows Authentication")) {
					np.viewAndValidateConnectionField(conndomainnameInputField, ConstantProperty.CONN_FIELD_DOMAINNAME,
							connParam.getDomainName(), false);

					np.viewAndValidateConnectionField(conninstancenameInputField,
							ConstantProperty.CONN_FIELD_INSTANCENAME, connParam.getInstaceName(), false);
				}

				verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

				np.viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
						connParam.getCustomJDBCURLValue(), false);

				np.viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
						connParam.getHost(), false);

				np.viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
						connParam.getPort(), false);

				np.viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
						connParam.getDatabaseName(), false);

				if (isDisplayed(driver, connsecretName)) {

					validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", true);

					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					waitForExecution(1000);

					validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "", true);

					validateInputFieldVisibility(connsecretPasswordfeild, ConstantProperty.CONN_FIELD_PASSWORD, "",
							true);

				} else {

					validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "", true);

					validateInputFieldVisibility(connPasswordInput, ConstantProperty.CONN_FIELD_PASSWORD, "", true);
				}

				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

				int count = connPropertyList.size();

				flag = cp.viewAndValidateConnectionPropertiesToConnection(connJsonEntity, count);

			}

		} catch (Exception e) {

			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("connection not visible properly kindly check :" + e.toString());
		}
		return flag;
	}

	/** Test Sql server connection method **/

	public boolean testSqlServerConnection(String connJsonEntity, String driverName, String icedqUser) {
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		boolean flag = false;
		String sqlusername = null;
		String winusername = null;
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			if ((connParam.getAuthenticationname()).equalsIgnoreCase("SQL Server Authentication")) {

				sqlusername = getConnectionDetailsUsingAuthType("sqlserver", 1);

				// sqlpassword = getConnectionDetailsUsingAuthType("sqlserver", 2);
			} else if ((connParam.getAuthenticationname()).equalsIgnoreCase("Windows Authentication")) {
				winusername = getConnectionDetailsUsingAuthType("windows", 1);

				// winpassword = getConnectionDetailsUsingAuthType("windows", 2);

			}

			inVisible(driver, spinner, Constant.ruleWait);
			Thread.sleep(3000);
			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				// viewSQLServerMethod(connJsonEntity, driverName);

				if (!icedqUser.contains("reader")) {

					flag = testConnection(connectionTestMess);

				} else {
					flag = testConnection(forbiddenToastMsg);
				}
			} else {

				// viewSQLServerMethod(connJsonEntity, driverName);

				if ((connParam.getAuthenticationname()).equalsIgnoreCase("SQL Server Authentication"))
					if (icedqUser.contains("contributor") || (icedqUser.contains("executor"))) {

						enterUsername(sqlusername);

						cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
								connParam.getConnectorID(), icedqUser);
						saveConnection();
						waitForExecution(1000);
						inVisible(driver, spinner, Constant.ruleWait);
						flag = testConnection(connectionTestMess);

					}
				if ((connParam.getAuthenticationname()).equalsIgnoreCase("Windows Authentication"))
					if (icedqUser.contains("contributor") || (icedqUser.contains("executor"))) {

						enterUsername(winusername);

						cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
								connParam.getConnectorID(), icedqUser);
						saveConnection();
						waitForExecution(1000);
						inVisible(driver, spinner, Constant.ruleWait);
						flag = testConnection(connectionTestMess);

					}
			}
			if (icedqUser.contains("owner")) {
				flag = testConnection(connectionTestMess);

			} else {
				flag = cp.clickQuickAddbtn(forbiddenToastMsg);
			}

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not tested properly kindly check :" + e.toString());

		}

		return flag;
	}

	/** Update Database connection common method **/

	public boolean updateSqlServerConnection(String connJsonEntity, String driverName, String testScenario,
			String validationMessage, String icedqUser) {
		boolean flag = true;
		String newconnectionName = null;
		String sqlusername = null;
		String winusername = null;
		NewConnectionRepoPage np = new NewConnectionRepoPage(driver);
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			String drivertype = setDriverType(connParam.getDriverName());

			// String timestamp = new
			// SimpleDateFormat(ConstantProperty.CONNECTIONNAME_TIMESTAMPFORMAT).format(new
			// Date());

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

			if ((connParam.getAuthenticationname()).equalsIgnoreCase("SQL Server Authentication")) {

				sqlusername = getConnectionDetailsUsingAuthType("sqlserver", 1);

				// sqlpassword = getConnectionDetailsUsingAuthType("sqlserver", 2);
			} else if ((connParam.getAuthenticationname()).equalsIgnoreCase("Windows Authentication")) {
				winusername = getConnectionDetailsUsingAuthType("windows", 1);

				// winpassword = getConnectionDetailsUsingAuthType("windows", 2);
			}
			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

			} else {

				String connName;
				waitForExecution(3000);
				clickOnConnectionsTab();

				isDisplayedInLoop(driver, 0, discardButtons);
				if (isDisplayed(driver, discardButtons)) {
					displayAndClick(driver, discardButtons);
				}
				if ((!icedqUser.contains("owner"))) {
					connName = newconnectionName;
				} else {
					connName = connParam.getConnName() + "_" + BaseSuite.WorkspaceName;
				}

				cp.searchAndClickOnConnectionNameInConnRepo(connName);

			}
			inVisible(driver, spinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 20, connName);

			Thread.sleep(1000);

			cp.enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

			viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, true);

			selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

			viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
					connParam.getAuthenticationname(), true);

			selectAuthenticationOfConnection(connParam.getAuthenticationname());

			if (drivertype.equalsIgnoreCase("SQL Server Native JDBC")
					&& connParam.getAuthenticationname().equalsIgnoreCase("Windows Authentication")) {
				np.validatAndeEnterValueToTextField(domainname, conndomainnameInputField,
						ConstantProperty.CONN_FIELD_DOMAINNAME, connDomainnamePlaceholder, connParam.getDomainName(),
						"");

				np.validatAndeEnterValueToTextField(instancename, conninstancenameInputField,
						ConstantProperty.CONN_FIELD_INSTANCENAME, connInstancenamePlaceholder,
						connParam.getInstaceName(), "");
			}

			verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

			selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

			enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());

			if (connParam.getCustomJdbcFullUrl().equalsIgnoreCase(booleanTrue)) {

				validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder,
						false);
				validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder,
						false);
				validateInputFieldVisibility(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
						connDatabasePlaceHolder, false);

			} else {
				viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
						connParam.getHost(), true);
				validatAndeEnterValueToTextField(connHostTitle, connHostInputField, ConstantProperty.CONN_FIELD_HOST,
						connHostPlaceholder, connParam.getHost(), validationHostEmpty);

				viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
						connParam.getPort(), true);
				validatAndeEnterValueToTextField(connPortTitle, connPortInputField, ConstantProperty.CONN_FIELD_PORT,
						connPortPlaceholder, connParam.getPort(), validationPortEmpty);

				viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
						connParam.getDatabaseName(), true);
				validatAndeEnterValueToTextField(connDatabaseTitle, connDatabaseInputField,
						ConstantProperty.CONN_FIELD_DATABASE, connDatabasePlaceHolder, connParam.getDatabaseName(),
						validationDatabaseEmpty);
			}

			selectConnectionType(connParam.getType());

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)
					&& (connParam.getAuthenticationname()).equalsIgnoreCase("SQL Server Authentication")) {

				cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(), connParam.getConnectorID(),
						icedqUser);

				enterUsername(sqlusername);

			} else if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)
					&& (connParam.getAuthenticationname()).equalsIgnoreCase("Windows Authentication")) {

				cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(), connParam.getConnectorID(),
						icedqUser);

				enterUsername(winusername);

			} else {

				validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", false);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				waitForExecution(1000);

				validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "", false);

				validateInputFieldVisibility(connsecretPasswordfeild, ConstantProperty.CONN_FIELD_PASSWORD, "", false);
			}

			ArrayList<String> connPropertyList = TestDataThroughApi
					.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

			int count = connPropertyList.size();

			if ((connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE))) {

				updateConnectionPropertiesToConnection(connJsonEntity, count);
			} else {

				saveConnection();
				cp.updateUserConnectionPropertiesToConnection(connJsonEntity, count,
						ConstantProperty.ICEDQ_WORKSPACE_OWNERUSER);
			}

			updateUsernamePasswordToSqlServerConnection(connJsonEntity, sqlusername, winusername, icedqUser);

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not updated properly kindly check :" + e.toString());
		}
		return flag;
	}

	/** Duplicate Sql Server Connection **/
	public boolean duplicateSqlServerConnectionMethod(String connJsonEntity, String driverName, String icedqUser) {
		boolean flag = false;
		String name = null;
		String newconnectionName = null;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);
			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";
			inVisible(driver, spinner, Constant.ruleWait);
			Thread.sleep(3000);

			viewSQLServerMethod(connJsonEntity, driverName);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {
				String connName;
				cp.clickOnConnectionsTab();

				isDisplayedInLoop(driver, 0, discardButtons);
				if (isDisplayed(driver, discardButtons)) {
					displayAndClick(driver, discardButtons);
				}

				if ((!icedqUser.contains("owner"))) {

					connName = newconnectionName;
				} else {
					connName = newconnectionName;
				}
				searchAndClickOnConnectionNameInConnRepo(connName);

				inVisible(driver, spinner, Constant.ruleWait);
				Thread.sleep(2000);
			}
			if (icedqUser.contains("owner")) {

				flag = clickOnDuplicateConnection(connDupllicateToastMsg);

				inVisible(driver, spinner, Constant.ruleWait);

				Thread.sleep(1000);

				if (flag) {
					if (isDisplayed(driver, connName)) {
						name = getAttribute(driver, connName, valueAttribute);
					} else {
						clickOnOverviewTab();
						name = getAttribute(driver, connName, valueAttribute);
					}
					cp.clickOnConnectionsTab();
					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}
					Thread.sleep(2000);
					flag = cp.searchAndClickOnConnectionNameInConnRepo(name);
				}
			} else {
				flag = clickOnDuplicateConnection(forbiddenToastMsg);
			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(
					"due to exception while duplicate Database Connection kindly check " + e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;
	}

	/** Delete Sql Server Connection **/

	public boolean deleteSqlServerConnection(String connJsonEntity, String driverName, String icedqUser) {
		boolean flag = true;
		String newconnectionName = null;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);
			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";
			inVisible(driver, spinner, Constant.ruleWait);

			// viewSQLServerMethod(connJsonEntity, driverName);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				String connName;
				waitForExecution(3000);
				clickOnConnectionsTab();
				if ((!icedqUser.contains("owner"))) {
					connName = newconnectionName;
				} else {
					connName = connParam.getConnName() + "_" + BaseSuite.WorkspaceName
							+ ConstantProperty.SIGN_UNDERSCORE + "vault";
				}
				searchAndClickOnConnectionNameInConnRepo(connName);

				inVisible(driver, spinner, Constant.ruleWait);

			}
			if (icedqUser.contains("owner")) {

				flag = cp.clickOnDeleteButton(connSingleDeleteToastMsg, 1);

			} else {
				flag = clickOnButton(driver, clickonDisable, "Connection Delete", flag);

				flag = captureToastMsg(driver, toastMsg, popUpClose, forbiddenToastMsg, "Connection Delete");
			}
		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not deleted properly kindly check :" + e.toString());

		}

		return flag;
	}

	public boolean saveAndTestWithMsgConnectionForInvalidScenario(String connectionType, String icedqUser,
			String newConnectionName, ConnectionPoJO connParam, ConnectionPoJO connParamFromExcel,
			String testScenario) {
		boolean flag = false;
		boolean status = false;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {
			if (!connectionType.equalsIgnoreCase("user")) {

				flag = cp.entervalueInTextFieldWithValidation(connParam, connUsernameInput,
						ConstantProperty.CONN_FIELD_USERNAME, connParam.getUsername(), testScenario,
						connParamFromExcel.getValidationMessage(), true);

				if (flag) {
					flag = cp.entervalueInTextFieldWithValidation(connParam, connPasswordInput,
							ConstantProperty.CONN_FIELD_PASSWORD, connParam.getPassword(), testScenario,
							connParamFromExcel.getValidationMessage(), true);
				}
			} else {

				cp.viewAndValidateConnectionField(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "", false);

				cp.viewAndValidateConnectionField(connPasswordInput, ConstantProperty.CONN_FIELD_PASSWORD, "", false);

			}

			if (connectionType.equalsIgnoreCase("user") && icedqUser.contains("contributor")
					|| icedqUser.contains("executor")) {

				saveConnection();

				if (isDisplayed(driver, toastMsg)) {

					BaseSuite.reportLog("Toast message visible on save button");

					status = captureToastMsgForConnection(driver, toastMsg, popUpClose, connectionSaveMesssage,
							"Connection Save", true);
				}
			}

		} catch (Exception e) {

			flag = false;

			BaseSuite.reportErrorLog(
					"Error occured while save And Test Connection For Invalid Scenario kindly check :" + e.toString());
		}
		return flag;
	}

	/*************** Invalid Scenarios Method creation ********************/

	/** testScenario = "Valid/Invalid" , ValidationMessage blank for valid name **/

	public boolean createSqlServerInvalidScenarioMethod(String connParamFromExcel, ConnectionPoJO invalidDataFetch,
			String testScenario, String icedqUser, String tctype, String connectionType) {
		boolean flag = true;
		boolean status1 = false;
		boolean status = false;
		String newconnectionName = null;
		String sqlusername = null;
		String winusername = null;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connParamFromExcel);

			String drivertype = setDriverType(connParam.getDriverName());

			newconnectionName = connParam.getConnName();

			inVisible(driver, spinner, Constant.ruleWait);

			if ((connParam.getAuthenticationname()).equalsIgnoreCase("SQL Server Authentication")) {

				sqlusername = getConnectionDetailsUsingAuthType("sqlserver", 1);

			} else if ((connParam.getAuthenticationname()).equalsIgnoreCase("Windows Authentication")) {
				winusername = getConnectionDetailsUsingAuthType("windows", 1);

			}
			status1 = cp.entervalueInTextFieldWithValidation(connParam, connName, "Connection Name", newconnectionName,
					testScenario, invalidDataFetch.getValidationMessage(), true);

			if (!tctype.isEmpty()) {

				selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

				String authName = setAuthenticationType(connParam.getAuthentication());

				selectAuthenticationOfConnection(authName);

				if (drivertype.equalsIgnoreCase("SQL Server Native JDBC")
						&& connParam.getAuthenticationname().equalsIgnoreCase("Windows Authentication")) {
					validatAndeEnterValueToTextField(domainname, conndomainnameInputField,
							ConstantProperty.CONN_FIELD_DOMAINNAME, connDomainnamePlaceholder,
							connParam.getDomainName(), "");

					validatAndeEnterValueToTextField(instancename, conninstancenameInputField,
							ConstantProperty.CONN_FIELD_INSTANCENAME, connInstancenamePlaceholder,
							connParam.getInstaceName(), "");
				}

				boolean cs = cp.selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

				inVisible(driver, spinner, Constant.ruleWait);

				selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

				switch (invalidDataFetch.getFieldName().toLowerCase().trim()) {

				case "connectionname":

					if (Boolean.parseBoolean(connParam.getCustomJdbcFullUrl())) {

						cp.entervalueInTextFieldWithValidation(connParam, connCustomJDBCTextbox, "",
								connParam.getCustomJDBCURLValue(), testScenario,
								invalidDataFetch.getValidationMessage(), true);
					} else {

						cp.entervalueInTextFieldWithValidation(connParam, connHostInputField,
								ConstantProperty.CONN_FIELD_HOST, connParam.getHost(), testScenario,
								invalidDataFetch.getValidationMessage(), true);
						cp.entervalueInTextFieldWithValidation(connParam, connPortInputField,
								ConstantProperty.CONN_FIELD_PORT, connParam.getPort(), testScenario,
								invalidDataFetch.getValidationMessage(), true);
						cp.entervalueInTextFieldWithValidation(connParam, connDatabaseInputField,
								ConstantProperty.CONN_FIELD_DATABASE, connParam.getDatabaseName(), testScenario,
								invalidDataFetch.getValidationMessage(), true);
					}
					selectConnectionType(connectionType);

					if (!connectionType.equalsIgnoreCase("user")) {

						cp.entervalueInTextFieldWithValidation(connParam, connUsernameInput,
								ConstantProperty.CONN_FIELD_USERNAME, connParam.getUsername(), testScenario,
								invalidDataFetch.getValidationMessage(), true);
						cp.entersecretPassword(connParamFromExcel, authName, connParam.getConnectorID(), icedqUser);
						Thread.sleep(1000);
					} else {

						viewAndValidateConnectionField(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "",
								false);
						viewAndValidateConnectionField(connPasswordInput, ConstantProperty.CONN_FIELD_PASSWORD, "",
								false);
					}

					inVisible(driver, spinner, Constant.ruleWait);

					if (icedqUser.toLowerCase().contains("owner")) {
						String saveErrorMsg = "Connection name \'" + newconnectionName + "\' already exists.";
						Thread.sleep(1000);
						status = saveConnection(saveErrorMsg);

					} else {

						status = saveConnection(forbiddenToastMsg);
					}
					break;

				case "jdbcurl":
					if (Boolean.parseBoolean(connParam.getCustomJdbcFullUrl())) {
						// cp.selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());
						// status =
						// cp.entervalueInTextFieldWithValidation(connParam,connCustomJDBCTextbox, "",
						// connParam.getCustomJDBCURLValue(), testScenario,
						// connParamFromExcel.getValidationMessage(), true);
						status = cp.entervalueJdbcWithValidation(connParam, connCustomJDBCTextbox,
								connParam.getCustomJDBCURLValue(), "", testScenario,
								invalidDataFetch.getValidationMessage(), true);

					}
					break;

				case "host":
					cp.selectCustomJDBCURLOfConnection("false");
					status = cp.entervalueInTextFieldWithValidation(connParam, connHostInputField,
							ConstantProperty.CONN_FIELD_HOST, connParam.getHost(), testScenario,
							invalidDataFetch.getValidationMessage(), true);

					break;

				case "port":
					cp.selectCustomJDBCURLOfConnection("false");
					status = cp.entervalueInTextFieldWithValidation(connParam, connPortInputField,
							ConstantProperty.CONN_FIELD_PORT, connParam.getPort(), testScenario,
							invalidDataFetch.getValidationMessage(), true);

					break;
				case "database":
					cp.selectCustomJDBCURLOfConnection("false");
					status = cp.entervalueInTextFieldWithValidation(connParam, connDatabaseInputField,
							ConstantProperty.CONN_FIELD_DATABASE, connParam.getDatabaseName(), testScenario,
							invalidDataFetch.getValidationMessage(), true);

					break;
				case "username":

					selectConnectionType(connectionType);

					if (!connectionType.equalsIgnoreCase("user")) {

						status = cp.entervalueInTextFieldWithValidation(connParam, connUsernameInput,
								ConstantProperty.CONN_FIELD_USERNAME, connParam.getUsername(), testScenario,
								invalidDataFetch.getValidationMessage(), true);
					} else {

						status = viewAndValidateConnectionField(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME,
								"", false);
					}
					break;

				case "propertyname":
				case "propertyvalue":
					ArrayList<String> connPropertyList = TestDataThroughApi
							.getJsonArrayValueUsingJsonPathExpreesion(connParamFromExcel, connConnectionPropNames);

					int count = connPropertyList.size();

					status = cp.addConnectionPropertiesToConnection1(connParamFromExcel, count, testScenario,
							invalidDataFetch.getFieldName());

					clickOnOverviewTab();

					break;

				default:
					BaseSuite.reportErrorLog(
							"Field name is not found kindly check :: " + invalidDataFetch.getFieldName());
					break;

				}

			} else if (status1) {
				status = true;

			}

			if (status || status1) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(
					"Database connection not created properly enterDatabaseConnectionDetailsForInvalidScenario kindly check :"
							+ e.toString());
		}
		return flag;
	}

	public boolean sqlServerInvalidScenarioToTestConnection(ConnectionPoJO connParamFromExcel, String connectionName,
			String connJsonEntity, String testScenario, String icedqUser, String connectionType) {
		boolean flag = false;
		boolean status = true;
		String newConnectionName = null;
		String sqlusername = null;
		String sqlpassword = null;
		String winusername = null;
		String winpassword = null;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			String drivertype = setDriverType(connParam.getDriverName());

			//String timestamp = new SimpleDateFormat(ConstantProperty.CONNECTIONNAME_TIMESTAMPFORMAT).format(new Date());

			newConnectionName = connectionName ;

			if ((connParam.getAuthenticationname()).equalsIgnoreCase("SQL Server Authentication")) {

				sqlusername = getConnectionDetailsUsingAuthType("sqlserver", 1);

				sqlpassword = getConnectionDetailsUsingAuthType("sqlserver", 2);
			} else if ((connParam.getAuthenticationname()).equalsIgnoreCase("Windows Authentication")) {
				winusername = getConnectionDetailsUsingAuthType("windows", 1);

				winpassword = getConnectionDetailsUsingAuthType("windows", 2);

			}

			if (icedqUser.contains("owner") || icedqUser.contains("contributor") || icedqUser.contains("executor")) {

				status = cp.entervalueInTextFieldWithValidation(connParam, connName, "Connection Name",
						newConnectionName, testScenario, connParamFromExcel.getValidationMessage(), true);

				if (status) {

					cp.selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

					cp.selectAuthenticationOfConnection(connParam.getAuthenticationname());

					if (drivertype.equalsIgnoreCase("SQL Server Native JDBC")&& connParam.getAuthenticationname().equalsIgnoreCase("Windows Authentication")) {
						
						validatAndeEnterValueToTextField(domainname, conndomainnameInputField,ConstantProperty.CONN_FIELD_DOMAINNAME, connDomainnamePlaceholder,
								connParam.getDomainName(), "");

						validatAndeEnterValueToTextField(instancename, conninstancenameInputField,ConstantProperty.CONN_FIELD_INSTANCENAME, connInstancenamePlaceholder,
								connParam.getInstaceName(), "");
					}

					cp.selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

					if (Boolean.parseBoolean(connParam.getCustomJdbcFullUrl())) {

						cp.entervalueInTextFieldWithValidation(connParam, connCustomJDBCTextbox, "",connParam.getCustomJDBCURLValue(), testScenario,
								connParamFromExcel.getValidationMessage(), true);

					} else {

						cp.entervalueInTextFieldWithValidation(connParam, connHostInputField,
								ConstantProperty.CONN_FIELD_HOST, connParam.getHost(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
						cp.entervalueInTextFieldWithValidation(connParam, connPortInputField,
								ConstantProperty.CONN_FIELD_PORT, connParam.getPort(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
						cp.entervalueInTextFieldWithValidation(connParam, connDatabaseInputField,
								ConstantProperty.CONN_FIELD_DATABASE, connParam.getDatabaseName(), testScenario,
								connParamFromExcel.getValidationMessage(), true);

					}

					selectConnectionType(connectionType);

					status = cp.enterUsernamePassword(connJsonEntity,connectionType , newConnectionName, connParam,
							connParamFromExcel, testScenario, icedqUser);

					status = cp.saveAndTestConnectionForInvalidScenario(icedqUser, status, connectionType);

					if (connectionType.equalsIgnoreCase("user")) {
						clickOnConnectionRepoBreadcrumbLink();
						searchAndClickOnConnectionNameInConnRepo(connectionName);
					}
				}
			} else {

				clickOnUserConnectionTab();

				flag = cp.searchAndClickOnConnectionNameInConnRepo(connectionName);

				if (flag) {

					flag = cp.entervalueInTextFieldWithValidation(connParam, connUsernameInput,
							ConstantProperty.CONN_FIELD_USERNAME, connParam.getUsername(), testScenario,
							connParamFromExcel.getValidationMessage(), true);

					if (flag) {
						flag = cp.entervalueInTextFieldWithValidation(connParam, connPasswordInput,
								ConstantProperty.CONN_FIELD_PASSWORD, connParam.getPassword(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
					}
				}

				status = saveConnection();

				if (status) {

					clickOnButton(driver, connTestBtn, "Test", true);

					inVisible(driver, spinner, 30);

					flag = captureToastMsgForConnection(driver, toastMsg, popUpClose, connectionTestMess,
							"Connection Test", true);
				}

			}
			if (status) {
				flag = true;
			}

		} catch (Exception e) {

			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not created properly kindly check :" + e.toString());
		}
		return flag;
	}

	public boolean sqlServerInvalid(String connJsonEntity, ConnectionPoJO connParamFromExcel, String connectionName,
			String testScenario, String icedqUser, String tctype, String connectionType) {
		boolean flag = false;
		boolean status = false;
		String newConnectionName = null;
		String sqlusername = null;
		String sqlpassword = null;
		String winusername = null;
		String winpassword = null;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(
					connParamFromExcel.getConnectionJsonForSQLServeNativeSQLServerAuth());

			String timestamp = new SimpleDateFormat(ConstantProperty.CONNECTIONNAME_TIMESTAMPFORMAT).format(new Date());

			newConnectionName = connectionName + ConstantProperty.SIGN_UNDERSCORE + timestamp;

			if (icedqUser.contains("owner") || icedqUser.contains("contributor") || icedqUser.contains("executor")) {

				status = cp.entervalueInTextFieldWithValidation(connParam, connName, "Connection Name",
						newConnectionName, testScenario, connParamFromExcel.getValidationMessage(), true);

				if (status) {

					cp.selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

					cp.selectAuthenticationOfConnection(connParam.getAuthenticationname());

					if ((connParam.getAuthenticationname()).equalsIgnoreCase("SQL Server Authentication")) {

						sqlusername = getConnectionDetailsUsingAuthType("sqlserver", 1);

						sqlpassword = getConnectionDetailsUsingAuthType("sqlserver", 2);
					} else if ((connParam.getAuthenticationname()).equalsIgnoreCase("Windows Authentication")) {
						winusername = getConnectionDetailsUsingAuthType("windows", 1);

						winpassword = getConnectionDetailsUsingAuthType("windows", 2);

					}

					cp.selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

					if (Boolean.parseBoolean(connParam.getCustomJdbcFullUrl())) {

						cp.entervalueInTextFieldWithValidation(connParam, connCustomJDBCTextbox, "",
								connParam.getCustomJDBCURLValue(), testScenario,
								connParamFromExcel.getValidationMessage(), true);

					} else {

						cp.entervalueInTextFieldWithValidation(connParam, connHostInputField,
								ConstantProperty.CONN_FIELD_HOST, connParam.getHost(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
						cp.entervalueInTextFieldWithValidation(connParam, connPortInputField,
								ConstantProperty.CONN_FIELD_PORT, connParam.getPort(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
						cp.entervalueInTextFieldWithValidation(connParam, connDatabaseInputField,
								ConstantProperty.CONN_FIELD_DATABASE, connParam.getDatabaseName(), testScenario,
								connParamFromExcel.getValidationMessage(), true);

					}

					selectConnectionType(connectionType);

					status = cp.enterUsernamePassword(connJsonEntity, connectionType, newConnectionName, connParam,
							connParamFromExcel, testScenario, icedqUser);

					status = cp.saveAndTestConnectionForInvalidScenario(icedqUser, status, connectionType);

					if (connectionType.equalsIgnoreCase("user")) {
						clickOnConnectionRepoBreadcrumbLink();
						cp.searchAndClickOnConnectionNameInConnRepo(connectionName);
					}
				}
			} else {

				clickOnUserConnectionTab();

				flag = cp.searchAndClickOnConnectionNameInConnRepo(connectionName);

				if (flag) {

					flag = cp.entervalueInTextFieldWithValidation(connParam, connUsernameInput,
							ConstantProperty.CONN_FIELD_USERNAME, connParam.getUsername(), testScenario,
							connParamFromExcel.getValidationMessage(), true);

					if (flag) {
						flag = cp.entervalueInTextFieldWithValidation(connParam, connPasswordInput,
								ConstantProperty.CONN_FIELD_PASSWORD, connParam.getPassword(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
					}
				}

				status = saveConnection();

				if (status) {

					clickOnButton(driver, connTestBtn, "Test", true);

					inVisible(driver, spinner, 30);

					flag = captureToastMsgForConnection(driver, toastMsg, popUpClose, connectionTestMess,
							"Connection Test", false);
				}

			}
			if (status) {
				flag = true;
			}

		} catch (Exception e) {

			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" Database connection not tested properly kindly check :" + e.toString());
		}
		return flag;
	}

	/*************** Invalid Scenario's for Snowflake Connection Starts ****/

	public boolean createSnowflakeConnectionMethodWithInvalidData(String connParamFromExcel,
			ConnectionPoJO invalidDataFetch, String testScenario, String icedqUser, String tctype,
			String connectionType) {
		boolean flag = true;
		boolean status1 = false;
		boolean status = true;
		String newconnectionName = null;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connParamFromExcel);

			newconnectionName = connParam.getConnName();

			String exxistname = "Connection name '" + newconnectionName + "' already exists.";

			inVisible(driver, spinner, Constant.ruleWait);

			status1 = cp.entervalueInTextFieldWithValidation(connParam, connName, "Connection Name", newconnectionName,
					testScenario, invalidDataFetch.getValidationMessage(), true);

			if (!tctype.isEmpty()) {

				selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

				String authName = cp.setAuthenticationType(connParam.getAuthentication());

				selectAuthenticationOfConnection(authName);

				boolean cs = selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

				switch (invalidDataFetch.getFieldName().trim()) {

				case "connectionname":

					if (cs) {
						entervalueInTextFieldWithValidation(connCustomJDBCTextbox, "",
								connParam.getCustomJDBCURLValue(), testScenario,
								invalidDataFetch.getValidationMessage(), true);
					}

					entervalueInTextFieldWithValidation(accountIdentifierInput,
							ConstantProperty.CONN_FEILD_ACCOUNTIDENTIFIER, connParam.getAccountIdentifire(),
							testScenario, invalidDataFetch.getValidationMessage(), true);
					entervalueInTextFieldWithValidation(connWarehouseInput, ConstantProperty.CONN_FEILD_WAREHOUSE,
							connParam.getWarehouse(), testScenario, invalidDataFetch.getValidationMessage(), true);
					entervalueInTextFieldWithValidation(connDatabaseInput, ConstantProperty.CONN_FIELD_DATABASE,
							connParam.getDatabaseName(), testScenario, invalidDataFetch.getValidationMessage(), true);

					selectConnectionType(connectionType);

					if (connParam.getAuthentication().equalsIgnoreCase("password")) {

						if (!connectionType.equalsIgnoreCase("user")) {

							cp.entervalueInTextFieldWithValidation(connParam, connUsernameInput,
									ConstantProperty.CONN_FIELD_USERNAME, connParam.getUsername(), testScenario,
									invalidDataFetch.getValidationMessage(), true);
							cp.entersecretPassword(connParamFromExcel, authName, connParam.getConnectorID(), icedqUser);
							Thread.sleep(1000);

						} else {

							viewAndValidateConnectionField(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME,"", false);
							
							viewAndValidateConnectionField(connPasswordInput, ConstantProperty.CONN_FIELD_PASSWORD,"", false);
						}
					}
					if (connParam.getAuthentication().equalsIgnoreCase("key-pair")) {

						if (!connectionType.equalsIgnoreCase("user")) {
							cp.entervalueInTextFieldWithValidation(connParam, connUsernameInput,
									ConstantProperty.CONN_FIELD_USERNAME, connParam.getUsername(), testScenario,
									invalidDataFetch.getValidationMessage(), true);
							cp.entersecretPassword(connParamFromExcel, authName, connParam.getConnectorID(), icedqUser);
						} else {

							validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME,"", false);
							
							validateInputFieldVisibility(KeyFileContent,ConstantProperty.CONN_FEILD_KEYFILECONTENT,"",false);
							
							validateInputFieldVisibility(KeyFilePassword,ConstantProperty.CONN_FEILD_KEYFILEPASSWORD, "", false);

						}

					}

					if (icedqUser.toLowerCase().contains("owner")) {

						status = saveConnection(exxistname);

					} else {

						status = saveConnection(forbiddenToastMsg);
					}
					break;

				case "jdbcurl":
					if (cs) {
						// status = entervalueInTextFieldWithValidation(connCustomJDBCTextbox,
						// "",connParam.getCustomJDBCURLValue(),
						// testScenario,invalidDataFetch.getValidationMessage(), true);
						status = cp.entervalueJdbcWithValidation(connParam, connCustomJDBCTextbox,
								connParam.getCustomJDBCURLValue(), "", testScenario,
								invalidDataFetch.getValidationMessage(), true);
					}
					break;

				case "accountidentifier":
					selectCustomJDBCURLOfConnection("false");
					status = cp.entervalueAccIdentifierWithValidation(connParam, accountIdentifierInput,
							ConstantProperty.CONN_FEILD_ACCOUNTIDENTIFIER, connParam.getAccountIdentifire(),
							testScenario, invalidDataFetch.getValidationMessage(), true);

					break;

				case "username":

					selectConnectionType(connectionType);

					if (!connectionType.equalsIgnoreCase("user")) {

						status = cp.entervalueInTextFieldWithValidation(connParam, connUsernameInput,
								ConstantProperty.CONN_FIELD_USERNAME, connParam.getUsername(), testScenario,
								invalidDataFetch.getValidationMessage(), true);

					} else {

						status = viewAndValidateConnectionField(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME,
								"", false);
					}
					break;
				case "password":

					selectConnectionType(connectionType);

					if (!connectionType.equalsIgnoreCase("user")) {

						cp.entersecretPassword(connParamFromExcel, authName, connParam.getConnectorID(), icedqUser);

					} else {

						status = viewAndValidateConnectionField(connPasswordInput, ConstantProperty.CONN_FIELD_PASSWORD,
								"", false);
					}

					break;
					
				case "Secret Name":

					//selectConnectionType(connectionType);

					if (!connectionType.equalsIgnoreCase("user")) {

						checkRecordFoundOrNot(ConstantProperty.CONN_FIELD_SECRETNAME,connsecretName,connsecretNameSearchField,"Icedq");
					} else {

						status = viewAndValidateConnectionField(connsecretName,ConstantProperty.CONN_FIELD_SECRETNAME, "",
								false);
					}

				case "keyfilecontent":

					//selectConnectionType(connectionType);

					if (!connectionType.equalsIgnoreCase("user")) {

						checkRecordFoundOrNot(ConstantProperty.CONN_FEILD_KEYFILECONTENT,connKeyfileContentdropdownbtn,connsecretNameSearchField,"Icedq");
					} else {

						status = viewAndValidateConnectionField(KeyFileContent,
								ConstantProperty.CONN_FEILD_KEYFILECONTENT,"",
								false);
					}
					break;
				case "keyfilepassword":

					//selectConnectionType(connectionType);

					if (!connectionType.equalsIgnoreCase("user")) {
						
						checkRecordFoundOrNot(ConstantProperty.CONN_FEILD_KEYFILEPASSWORD,connsecretPasswordfeild,connsecretNameSearchField,"Icedq");

					//	cp.entersecretPassword(connParamFromExcel, authName, connParam.getConnectorID(), icedqUser);

					} else {

						status = viewAndValidateConnectionField(KeyFilePassword,ConstantProperty.CONN_FEILD_KEYFILEPASSWORD, "", false);
					}
					break;

				case "propertyname":
				case "propertyvalue":
					ArrayList<String> connPropertyList = TestDataThroughApi
							.getJsonArrayValueUsingJsonPathExpreesion(connParamFromExcel, connConnectionPropNames);

					int count = connPropertyList.size();

					status = cp.addConnectionPropertiesToConnection1(connParamFromExcel, count, testScenario,
							invalidDataFetch.getFieldName());

					clickOnOverviewTab();

					break;

				default:
					BaseSuite.reportErrorLog(
							"Field name is not found kindly check :: " + invalidDataFetch.getFieldName());
					break;

				}

			} else if (status1) {
				status = true;

			}

			if (status || status1) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not created properly kindly check :" + e.toString());
		}
		return flag;
	}

	public boolean enterDataInTextFieldAndValidate(By locator, String label, String inputvalue, String scenario,
			String validationMessage, boolean state) throws NoSuchElementException {

		String methodName = "enterConnectionName";
		boolean flag = false;
		try {
			isDisplayedInLoop(driver, 4, locator);

			javascript(driver, scrollToElementArg, locator);

			if (isClickable(driver, locator, label + " field", state)) {
				click(driver, locator);

				clear(driver, locator);

				BaseSuite.reportLog("Entering value : " + inputvalue);
				if (!inputvalue.isEmpty()) {
					sendKeys(driver, locator, inputvalue);
				} else if (scenario.toLowerCase().equalsIgnoreCase("invalid") && inputvalue.isEmpty()) {

					sendKeys(driver, locator, "emptyvalue");

					displayAndClearInputField(driver, 1, locator);

					Thread.sleep(500);
				}
				String ac = getAttribute(driver, locator, valueAttribute);

				stringContainsOutput(ac, inputvalue, true);

				if (validationMessage.isEmpty()) {
					validationMessageOfField(returnElement(connCommonFieldValidation, dynamicName, label.toLowerCase()),
							label, "", false);

				} else {
					String acmesg = validationMessageOfField(
							returnElement(connCommonFieldValidation, dynamicName, label.toLowerCase()), label,
							validationMessage, true);
					inVisible(driver, spinner, Constant.ruleWait);
					if (validationMessage.equalsIgnoreCase(acmesg)) {
						flag = true;
					} else {
						flag = false;
					}
				}
			} else {
				BaseSuite.validationReportLog("feild is not clickable");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog("Exception found : " + e.getMessage());
			throw new NoSuchElementException();
		}
		return flag;
	}

	/** validate Record Found Or Not method for invalid scenario **/
	public Boolean checkRecordFoundOrNot(String labelName,By inputFeild,By clickSearch,String input)throws NoSuchElementException {
		boolean flag = false;
		try {
			isDisplayedInLoop(driver, 2, returnElement(commonLabel, dynamicName, labelName));

			javascript(driver, scrollToElementArg, returnElement(commonLabel, dynamicName, labelName));

			verifyIndividualLabel(driver, returnElement(commonLabel, dynamicName, labelName), "");

			if (isDisplayed(driver, inputFeild)) {

				BaseSuite.validationReportLog("Input Field is visible ");

				String authValue = getAttribute(driver, inputFeild, valueAttribute);

				BaseSuite.reportLog("Default Input type selected as : " + authValue);

				BaseSuite.validationReportLog("Input field drop down arrow is visible");

				displayAndClick(driver, inputFeild);

				BaseSuite.validationReportLog(
						"Clicked on Input Feild drop down " + ConstantProperty.SUCCESSSTRING + "");

				BaseSuite.reportLog("Checking list of Input Feild type");
				
				Thread.sleep(2000);

				if (isDisplayed(driver,clickSearch)) {
					
					sendKeys(driver, clickSearch, input);

					BaseSuite.reportLog("No Record Found is visible");

					String acauth = getText(driver, conndropdownResult);
					
					Thread.sleep(2000);

					if (acauth.equalsIgnoreCase(ConstantProperty.CONN_NO_RECORD_FOUND)) {
						
						BaseSuite.validationReportLog(
								"Expected Input Feild is Visible " + ConstantProperty.SUCCESSSTRING + "");
						flag = true;
					} else {
						flag = false;
						BaseSuite.reportFailLog("Expected authentication type is not selected, kindly check ",
								"checkRecordFoundOrNot");
					}

				} else {
					BaseSuite.reportFailLog("Input Feild not visible " ,"");
				}

			} else {
				BaseSuite.reportFailLog("Input Feild not visible ", "");
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" Exception found : " + e.getMessage());
			throw new NoSuchElementException();
		}
		return flag;
	}

															 

}
