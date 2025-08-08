package nexgen.automation.framework.connectionRepo;


import java.awt.Button;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.CodePageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import org.openqa.selenium.remote.server.handler.GetTitle;

import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import com.atlassian.util.concurrent.TimedOutException;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;
import nexgen.automation.pageclasses.otherpages.HomePage;
import nexgen.automation.pageclasses.otherpages.LoginPage;
import nextgen.automation.RuleRepo.pages.TestDataThroughApi;

public class ConnectionRepoCommonPage extends PageUtil {
	WebDriver driver;

	public ConnectionRepoCommonPage(WebDriver driver) {
		this.driver = driver;
	}

	static ReadConfig readconfig = new ReadConfig();
	By userName = getElementLocator(prop.getProperty("Login.UserName"));
	By passWord = getElementLocator(prop.getProperty("Login.Password"));
	By loggedInMsg = getElementLocator(prop.getProperty("Login.LoggedInMsg"));
	By toastMsg = getElementLocator(prop.getProperty("Commontoastmsg"));
	By toastMsgClosedBtn = getElementLocator(prop.getProperty("ToastMsgClosedBtn"));
	By pagelabel = getElementLocator(prop.getProperty("Connection.PageLabel"));
	By clickonDataConnection = getElementLocator(prop.getProperty("Connection.connectionLabel"));
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
	By connectionMasterCheckbox = getElementLocator(prop.getProperty("Connection.masterCheckbox"));
	By popUpClose = getElementLocator(prop.getProperty("PopUpClose"));
	By connectionNameClick1 = getElementLocator(prop.getProperty("connectionNameClick1"));
	By connectionNameClick = getElementLocator(prop.getProperty("connectionNameClick"));
	By newConnectionNameSearch = getElementLocator(prop.getProperty("newConnectionNameSearch"));
	By connectionImg = getElementLocator(prop.getProperty("connectionImg"));
	By connPaginationIcon = getElementLocator(prop.getProperty("connPaginationIcon"));
	By listOfConnName = getElementLocator(prop.getProperty("listOfConnName"));
	By connectionRepoLeftPanel = getElementLocator(prop.getProperty("ConnectionRepoLeftPanel"));
	By connectionTab = getElementLocator(prop.getProperty("Connection.ConnectionTab"));
	By connectionTitle = getElementLocator(prop.getProperty("Connection.ConnTitle"));
	By userconnectionTitle = getElementLocator(prop.getProperty("ConnectionUser.ConnTitle"));
	By userconnectionTab = getElementLocator(prop.getProperty("Connection.UserConnectionTab"));
	By advanceSearchButton = getElementLocator(prop.getProperty("AdvancedSearchButton"));
	By connPaginationMsg1 = getElementLocator(prop.getProperty("Connection.PaginationMsg"));
	By connPaginationCount = getElementLocator(prop.getProperty("Connection.Pagination"));
	By connPaginationBar1 = getElementLocator(prop.getProperty("Connection.PaginationBar"));
	By pageArrows1 = getElementLocator(prop.getProperty("Connection.PageArrow"));
	By mainHeadingTitle = getElementLocator(prop.getProperty("Connection.MainHeadingTitle"));
	By leftArrowConnection = getElementLocator(prop.getProperty("Connection.LeftSideBarArrowClose"));
	By leftArrowOpenConnection = getElementLocator(prop.getProperty("Connection.LeftSiderBarArrowOpen"));
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
	By updatedBydropdown = getElementLocator(prop.getProperty("Connection.UpdatedByDropdown"));
	By updatedBypopup = getElementLocator(prop.getProperty("Connection.UpdatedByPopup"));
	By updatedBySearch = getElementLocator(prop.getProperty("Connection.UpdatedBySearch"));
	By updatedBysearchBar = getElementLocator(prop.getProperty("Connection.UpdatedBysearchBar"));
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
	By addConnProperty = getElementLocator(prop.getProperty("Connection.AddConnProperty"));
	By connectionProperties = getElementLocator(prop.getProperty("ConnectionB.ConnectionProperties"));
	By addPropertyNewName = getElementLocator(prop.getProperty("Connection.AddProperty.New.Name"));

	By addPropertyNameForColor = getElementLocator(prop.getProperty("Connection.AddPropertyNameForColor"));

	By addPropertyNameForDB = getElementLocator(prop.getProperty("Connection.AddPropertyNameForDB"));
	By addPropertyValue = getElementLocator(prop.getProperty("Connection.AddPropertyValue"));
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
	By chooseConnectionTypeSearchTxt = getElementLocator(prop.getProperty("conn.chooseCtype.searchtxt"));
	By chooseConnectionTypeSearchResultele = getElementLocator(prop.getProperty("conn.chooseCtype.afterSearchedCtype"));
	By chooseConnectionTypeSpinner = getElementLocator(prop.getProperty("conn.spinner.afterCTypeClicked"));
	By connWorkspaceLabel = getElementLocator(prop.getProperty("Connection.Conn.Workspace.Label"));
	By connWorkspaceField = getElementLocator(prop.getProperty("Connection.Conn.Workspace.Field"));
	By connName = getElementLocator(prop.getProperty("ConnectionB.connectionName"));
	By connNameLabel = getElementLocator(prop.getProperty("Connection.Conn.Name.Label"));
	By connAuthTypeLabel = getElementLocator(prop.getProperty("Connection.Conn.Auth.Label"));
	By connAuthTypeField = getElementLocator(prop.getProperty("Connection.Conn.Auth.Field"));
	By connAuthTypeSearchIcon = getElementLocator(prop.getProperty("Connection.Conn.Auth.DDIcon"));
	By connAuthTypeList = getElementLocator(prop.getProperty("Connection.Conn.Auth.DD.List"));
	By connTypeField = getElementLocator(prop.getProperty("conn.TypeField"));

	By connsecretNameSearchField = getElementLocator(prop.getProperty("Connection.secretNameSearch"));

	By connDetailsPageTabs = getElementLocator(prop.getProperty("conn.DetailsPageTabs"));

	By breadCrumb = getElementLocator(prop.getProperty("Connection.BreadCrumb"));
	By connDatabricksLogo = getElementLocator(prop.getProperty("Databricks.LogoDetailPage"));
	By connCloudProviderTypeLabel = getElementLocator(prop.getProperty("Connection.Conn.CloudProvider.Label"));
	By connCloudProviderField = getElementLocator(prop.getProperty("Connection.Conn.CloudProvider.Field"));
	By connCloudProviderSearchIcon = getElementLocator(prop.getProperty("Connection.Conn.CloudProvider.DDIcon"));
	By connCloudProviderList = getElementLocator(prop.getProperty("Connection.Conn.CloudProvider.DD.List"));
	String connCloudProviderSelect1 = prop.getProperty("Connection.Conn.CloudProviderSelect");

	String ConnectionlistingCheckbox = prop.getProperty("Connection.listingCheckbox");

	By connDEnvironmentLabel = getElementLocator(prop.getProperty("Connection.Conn.DEnvironment.Label"));
	By connDEnvironmentField = getElementLocator(prop.getProperty("Connection.Conn.DEnvironment.Field"));
	By connDEnvironmentSearchIcon = getElementLocator(prop.getProperty("Connection.Conn.DEnvironment.DDIcon"));
	By connDEnvironmentList = getElementLocator(prop.getProperty("Connection.Conn.DEnvironmentr.DD.List"));
	String connDEnvironmentSelect1 = prop.getProperty("Connection.Conn.DEnvironmentSelect");
	String connJdbcFieldValidation = prop.getProperty("conn.Jdbc.Field.Validation");
	By connHttpPathInputField = getElementLocator(prop.getProperty("conn.HttpPath"));
	By connHttpPathTitle = getElementLocator(prop.getProperty("Connection.conn.HttpPath.title"));
	By connCatalogInputField = getElementLocator(prop.getProperty("conn.Catalog"));

	By DatabricksInputFields = getElementLocator(prop.getProperty("Databricks.InputFields"));
	By connDatabricksBtn = getElementLocator(prop.getProperty("Databricks.Btns"));

	String connDatabricksDefaultJDBCURL = prop.getProperty("databricks.DefaultJDBCURL");

	// -------------------------------- DH ---------------------------//
	// String connConnectionPropCommonLocatorDatabricks =
	// prop.getProperty("Connection.Conn.Property.field_Databricks");

	By connExcelTestFileLabel = getElementLocator(prop.getProperty("conn.Excel.TestFile.label"));
	By connExcelTestFileField = getElementLocator(prop.getProperty("conn.Excel.TestFile.field"));
	By connExcelTestFileFieldValidation = getElementLocator(prop.getProperty("conn.ExcelTestFile.validation"));
	By connExcelInputFields = getElementLocator(prop.getProperty("connExcel.InputFields"));
	By connExcelBtn = getElementLocator(prop.getProperty("connExcel.Btns"));
	By connRDBMSBtn = getElementLocator(prop.getProperty("connRDBMS.Btns"));
	By connExcelinfoIcon = getElementLocator(prop.getProperty("conn.ExcelInfoIcon"));

	String connExcelLogo = prop.getProperty("connExcel.LogoDetailPage");
	String testFilePlaceHolder = prop.getProperty("Connection.Conn.TestFile.placeholder");
	String testFileEmptyValidationMsg = prop.getProperty("Connection.Excel.TestFile.empty");

	By connAtScaleCustomJDBCCheckbox = getElementLocator(prop.getProperty("conn.AtScale.EnableCustomJDBCURL"));
	By connCustomJDBCCheckbox = getElementLocator(prop.getProperty("Connection.Conn.CustomJDBCURL.Checkbox"));
	By connCustomJDBCLabel = getElementLocator(prop.getProperty("Connection.Conn.CustomJDBCURL.Label"));
	By connCustomJDBCTextbox = getElementLocator(prop.getProperty("Connection.Conn.CustomJDBCURL.Textbox"));
	By connRepoBreadcrumbLink = getElementLocator(prop.getProperty("Connection.Conn.Repo.Breadcrem.Link"));
	By discardButtonsDetails = getElementLocator(prop.getProperty("conn.DetailsDiscardButton"));
	By discardButtons = getElementLocator(prop.getProperty("conn.discardButton"));
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
	By connTypeFeildverify = getElementLocator(prop.getProperty("conn.connType.feild.verify"));
	By connTypedropdownOpener = getElementLocator(prop.getProperty("conn.connType.dropdown.opener"));
	By connTypeSelectionDropdown = getElementLocator(prop.getProperty("conn.typeselection.dropdown"));
	By connTypeList = getElementLocator(prop.getProperty("conn.typeOfConn.dropdownlist"));
	By connTypeListpane = getElementLocator(prop.getProperty("conn.typeOfConn.dropdownlist.pane"));
	By warningPopupTitleMsg = getElementLocator(prop.getProperty("Conn.warningPopupTitleMsg"));
	By warningPopupTitle = getElementLocator(prop.getProperty("Conn.warningPopupTitle"));
	By connPopupCancelBtn = getElementLocator(prop.getProperty("Conn.connPopupCancelBtn"));
	By connPopupYesBtn = getElementLocator(prop.getProperty("Conn.connPopupYesBtn"));
	By connUsernameInput = getElementLocator(prop.getProperty("conn.Username.input"));
	By connUsernameLabel = getElementLocator(prop.getProperty("conn.Username.Label"));
	By connUsernameErrormsg = getElementLocator(prop.getProperty("conn.Username.errorMsg"));
	By connPrincipalInput = getElementLocator(prop.getProperty("conn.principal.input"));
	By connUserPrincipal = getElementLocator(prop.getProperty("Conn.hive.userPrincipal.Feild"));
	By connUserPrincipalLabel = getElementLocator(prop.getProperty("Conn.hive.userPrincipal.label"));
	By connKrbButton = getElementLocator(prop.getProperty("conn.krb.button"));
	By connsecretQuickAddbtn = getElementLocator(prop.getProperty("Connection.secret.QuickAddbtn"));
	By connsecretRefreshbtn = getElementLocator(prop.getProperty("Connection.secret.Refreshbtn"));
	By connsecretName = getElementLocator(prop.getProperty("Connection.secretName"));
	By connsecretNameLabel = getElementLocator(prop.getProperty("Connection.secretNameLabel"));
	By connsecretManagebtn = getElementLocator(prop.getProperty("Connection.secret.Managebtn"));
	By connvaultOnOff = getElementLocator(prop.getProperty("Connection.vaultOnOff"));
	By connvaultOnOffLabel = getElementLocator(prop.getProperty("Connection.vaultOnOffLabel"));
	By connsecretPasswordfeild = getElementLocator(prop.getProperty("Connection.secretPassword.feild"));
	By connKeyfileContentPasswordfeild = getElementLocator(
			prop.getProperty("Connection.secretPassword.KeyfileContent.feild"));
	By connKeyfilePasswordfeild = getElementLocator(prop.getProperty("Connection.secret.keyfilePassword.feild"));
	By connsecretPassworddropdownbtn = getElementLocator(prop.getProperty("Connection.secretpassword.Passdropdownbtn"));
	By connsecretPassdropdownlist = getElementLocator(prop.getProperty("Connection.secretpassword.Passdropdownlist"));
	String connsecretselectPassword = prop.getProperty("Connection.secretpassword.selectPassword");
	String connselectsecretName = prop.getProperty("Connection.secretName.selectsecretName");
	By connsecretNamedropdownbtn = getElementLocator(prop.getProperty("Connection.secretName.dropdownbtn"));
	By connsecretNamedropdownlist = getElementLocator(prop.getProperty("Connection.secretName.dropdownList"));
	By connsecretNameNoRecord = getElementLocator(prop.getProperty("Connection.NoRecordSecretName"));
	String connsecretPasswordlabel = prop.getProperty("Connection.secretPassword.label");
	By connsecretUserPassword = getElementLocator(prop.getProperty("Connection.secretUserPassword.feild"));
	By connsecretPATLabel = getElementLocator(prop.getProperty("Connection.secretPersonalAccessToken.label"));
	By connsecretUserPAT = getElementLocator(prop.getProperty("Connection.secretUserPersonalAccessToken.feild"));
	By connKeyfileContentPasswordLabel = getElementLocator(
			prop.getProperty("Connection.secretPassword.KeyfileContent.Label"));
	By connKeyfileContentdropdownbtn = getElementLocator(
			prop.getProperty("Connection.secretPassword.KeyfileContent.Passdropdownbtn.feild"));
	String connselectPassword = prop.getProperty("Connection.secretPassword.selectPassword.feild");

	By connsecretiddropdownbtn = getElementLocator(prop.getProperty("Connection.salesforce.secretid.ddb"));
	By connsecretidfield = getElementLocator(prop.getProperty("Connection.salesforce.secretid.field"));
	By connsecretidlabel = getElementLocator(prop.getProperty("Connection.salesforce.secretid.label"));
	By flatfilesecretddb = getElementLocator(prop.getProperty("Connection.flatfile.secretkeyddb"));
	By flatfileaccessddb = getElementLocator(prop.getProperty("Connection.flatfile.accesskeyddb"));
	By flatfileSecurityTokenddb = getElementLocator(prop.getProperty("Connection.flatfile.securityTokenddb"));
	By athenasecretddb = getElementLocator(prop.getProperty("Connection.Athena.secretkeyddb"));

	By connKrbFeild = getElementLocator(prop.getProperty("conn.krb5.feild"));
	By connKrbChoosefile = getElementLocator(prop.getProperty("conn.krb5.choosefile"));
	By connKeytabFeild = getElementLocator(prop.getProperty("conn.keytab.feild"));
	By connKeytabChoosefile = getElementLocator(prop.getProperty("conn.keytab.choosefile"));
	By connKeyTabButton = getElementLocator(prop.getProperty("conn.keytab.button"));
	By connHiveUserPrincipal = getElementLocator(prop.getProperty("Connection.hive.userPrincipal.feild"));
	By connPrincipalLabel = getElementLocator(prop.getProperty("conn.principal.Label"));
	By connPrincipalErrormsg = getElementLocator(prop.getProperty("conn.principal.errorMsg"));
	By connPasswordLabel = getElementLocator(prop.getProperty("conn.Password.Label"));
	By connPasswordInput = getElementLocator(prop.getProperty("conn.Password.input"));
	By connPropertiesTab = getElementLocator(prop.getProperty("conn.propetiesSection.tab"));
	By connOverviewTab = getElementLocator(prop.getProperty("conn.OverviewSection.tab"));
	By addpropertyNameInput = getElementLocator(prop.getProperty("Connection.AddPropertyName"));
	By addedpropertyNameInputText = getElementLocator(prop.getProperty("Connection.AddedPropertyNameText"));

	By addpropertyValueInput = getElementLocator(prop.getProperty("Connection.AddPropertyValue.Input"));

	By addpropertyButton = getElementLocator(prop.getProperty("conn.property.addProperty.btn"));
	By removePropertyButton = getElementLocator(prop.getProperty("conn.property.removeProp.btn"));
	By clickOnPropertyTypeDropdown = getElementLocator(prop.getProperty("Connection.AddPropertyTypeClick"));
	By newPropertySaveButton = getElementLocator(prop.getProperty("conn.Add.newproperty.save.btn"));
	By newPropertyCancelButton = getElementLocator(prop.getProperty("conn.Cancel.newproperty.save.btn"));
	By createNewConnectionTitle = getElementLocator(prop.getProperty("Connection.Conn.CreateNewConnection.Title"));
	By propTypeListPane = getElementLocator(prop.getProperty("conn.ProPType.UiList"));
	By propListOptions = getElementLocator(prop.getProperty("conn.ProPType.listOfOption"));
	By connFlatFileNativeLogo = getElementLocator(prop.getProperty("Connection.conn.flatfile.native.Logo"));
	By connFlatFileLocationLabel = getElementLocator(prop.getProperty("conn.flatfile.native.location.label"));
	By connFlatFileLocationField = getElementLocator(prop.getProperty("conn.flatfile.native.location.field"));
	By connFlatFileLocationDDBtn = getElementLocator(prop.getProperty("conn.flatfile.native.location.dropdownbtn"));
	// By connFlatFileLocationDDBtnAmazon =
	// getElementLocator(prop.getProperty("conn.Excel.AmazonLocation"));
	By connFlatFileLocationDDList = getElementLocator(prop.getProperty("conn.flatfile.native.location.dropdownlist"));
	By connFlatFileFolderPathLabel = getElementLocator(prop.getProperty("conn.flatfile.native.FolderPath.label"));
	By connFlatFileFolderPathField = getElementLocator(prop.getProperty("conn.flatfile.native.FolderPath.field"));
	By connFlatFileFolderPathFieldValidation = getElementLocator(
			prop.getProperty("conn.flatfile.native.FolderPath.validation"));
	By connConnectionIdLabel = getElementLocator(prop.getProperty("conn.ConnectionID.Label"));
	By connConnectionIdField = getElementLocator(prop.getProperty("conn.ConnectionId.Field"));
	By connDeleteButton = getElementLocator(prop.getProperty("conn.DeleteButton"));
	By connDeleteButtonListing = getElementLocator(prop.getProperty("con.DeleteBtnListing"));
	By connDeletepopCancelBtn = getElementLocator(prop.getProperty("Connection.cancelDeleteConnBtn"));
	By connDeletepopDeleteBtn = getElementLocator(prop.getProperty("Connection.deleteConnBtn"));
	By connUploadFilesButton = getElementLocator(prop.getProperty("conn.UploadFileButton"));
	By connDuplicateButton = getElementLocator(prop.getProperty("conn.DuplicateButton"));
	By connCrawlIconBtn = getElementLocator(prop.getProperty("conn.CrawlIconBtn"));
	By connFileDuplicateButton = getElementLocator(prop.getProperty("conn.FileDuplicateButton"));
	By enableUploadButton = getElementLocator(prop.getProperty("conn.EnableUploadBtn"));
	By moreButton = getElementLocator(prop.getProperty("conn.MoreBtn"));
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
	By secondvalueselect = getElementLocator(prop.getProperty("conn.secondvalueselect.discard"));
	By connTypeSelect = getElementLocator(prop.getProperty("conn.connTypeSelect.discard"));
	By connTypeSelectSys = getElementLocator(prop.getProperty("conn.connTypeSelectSys.discard"));
	By connSelectSecretOpt = getElementLocator(prop.getProperty("conn.SelectSecretOpt"));
	By connSelectSecretPassOpt = getElementLocator(prop.getProperty("conn.SelectSecretPassOpt"));
	By connfilevalueselect = getElementLocator(prop.getProperty("conn.filevalueselect.discard"));

	By jaasPropertiesTextarea = getElementLocator(prop.getProperty("Conn.hive.jaasProperties.textarea"));
	By jaasPropertiesTitle = getElementLocator(prop.getProperty("Conn.hive.jaasProperties.title"));
	By projectidFeild = getElementLocator(prop.getProperty("Conn.GBQ.ProjectId.feild"));
	By projectidLabel = getElementLocator(prop.getProperty("Conn.GBQ.ProjectId.Label"));

	By chooseFileBtn = getElementLocator(prop.getProperty("Conn.hive.userKeytab.chosefile"));
	By connUserKeytab = getElementLocator(prop.getProperty("Conn.hive.userKeytab.feild"));
	By krb5 = getElementLocator(prop.getProperty("kerberosKrb5"));
	By connSpinnerVisible = getElementLocator(prop.getProperty("conn.Spinner.visible"));
	By connectionDeletePopUpContent = getElementLocator(prop.getProperty("Connection.Conn.Delete.Popup.Content"));
	By connDeletePopupTitle = getElementLocator(prop.getProperty("Connection.Conn.Delete.Popup.Title"));
	By connListingDeletePopup = getElementLocator(prop.getProperty("Connection.Conn.ListingDelete.Popup"));
	By connectionsDeletePopUpContent = getElementLocator(
			prop.getProperty("Connection.MultipleConn.Delete.Popup.Content"));
	By connectionsDeletePopupTitle = getElementLocator(prop.getProperty("Connection.MultipleConn.Delete.Popup.Title"));
	By connHostInputField = getElementLocator(prop.getProperty("conn.host"));
	By connHostTitle = getElementLocator(prop.getProperty("Connection.conn.host.title"));
	By connPortInputField = getElementLocator(prop.getProperty("conn.port"));
	By connPortTitle = getElementLocator(prop.getProperty("Connection.conn.port.title"));
	By connDatabaseInputField = getElementLocator(prop.getProperty("conn.Database"));
	By connDatabaseTitle = getElementLocator(prop.getProperty("Connection.conn.database.title"));
	By connCatalogTitle = getElementLocator(prop.getProperty("Connection.conn.catalog.title"));
	By usersearchconnection = getElementLocator(prop.getProperty("connection.usersearchconnection"));
	By usersearchconnectionbtn = getElementLocator(prop.getProperty("connection.usersearchconnectionbtn"));
	By propertiesEditBtn = getElementLocator(prop.getProperty("Connection.propertiesEditBtn"));
	By popUpOpenInput = getElementLocator(prop.getProperty("conn.popup.input"));
	By connSecurityTokenLabel = getElementLocator(prop.getProperty("conn.flatfile.native.SecurityToken.label"));
	By connSecurityTokenField = getElementLocator(prop.getProperty("conn.flatfile.native.SecurityToken.field"));
	By connSessionTokenLabel = getElementLocator(prop.getProperty("conn.flatfile.native.SessionToken.label"));
	By connSessionTokenField = getElementLocator(prop.getProperty("conn.flatfile.native.SessionToken.field"));
	By propConnType = getElementLocator(prop.getProperty("conn.prop.connectionTypeDD"));
	By chooseConnType = getElementLocator(prop.getProperty("conn.database.connectionTypeDD"));
	By systemConnType = getElementLocator(prop.getProperty("conn.database.systemConnectionType"));
	By userConnType = getElementLocator(prop.getProperty("conn.database.userConnectionType"));
	String accountIdentifierfeildvalidation = prop.getProperty("conn.AccountIdentifier.feild.validation");
	String statusType = prop.getProperty("conn.landingPage.statusType");

	By discardchanges = getElementLocator(prop.getProperty("conn.Discardchanges.popup.content"));

	By discardButton = getElementLocator(prop.getProperty("conn.DiscardButton"));
	By discardpopupcancelbtn = getElementLocator(prop.getProperty("conn.Discardpopup.cancel"));
	By discardpopupdiscardbtn = getElementLocator(prop.getProperty("conn.Discardpopup.discard"));
	By principalFeild = getElementLocator(prop.getProperty("conn.Principal.feild"));

	By warningPopupWindowTitle = getElementLocator(prop.getProperty("conn.warning.popup.title"));
	By warningPopupWindowContent = getElementLocator(prop.getProperty("conn.warning.popup.content"));
	By warningPopupWindowCancelButton = getElementLocator(prop.getProperty("conn.warning.popup.cancel"));
	By warningPopupWindowYesButton = getElementLocator(prop.getProperty("conn.warning.popup.yes"));

	By salesforcePopupWindowTitle = getElementLocator(prop.getProperty("Connection.salesforceLoginPage.popup"));
	By salesforcePopupWindowContent = getElementLocator(prop.getProperty("Connection.salesforceLoginPage.content"));
	By salesforcePopupWindowCancelButton = getElementLocator(
			prop.getProperty("Connection.salesforceLoginPage.cancelbtn"));
	By salesforcePopupWindowYesButton = getElementLocator(prop.getProperty("Connection.salesforceLoginPage.yesbtn"));
	By salesforcelogo = getElementLocator(prop.getProperty("Conn.salesforceLogo"));
	By sandboxUsername = getElementLocator(prop.getProperty("conn.sandboxUsername.input"));
	By sandboxPassword = getElementLocator(prop.getProperty("conn.sandboxPassword.input"));
	By sandboxloginbtn = getElementLocator(prop.getProperty("conn.sandbox.loginbtn"));
	By salesforceloginbtn = getElementLocator(prop.getProperty("conn.salesforce.loginbtn"));
	By callbackurl = getElementLocator(prop.getProperty("Connection.salesforce.callback.field"));
	By sandboxcheckbox = getElementLocator(prop.getProperty("Conn.salesforce.sandbox.checkbox"));
	By sandboxlabel = getElementLocator(prop.getProperty("Conn.salesforce.sandbox.label"));
	By authorizebtn = getElementLocator(prop.getProperty("conn.salesforce.Authorizebtn"));

	By useSSLLabel = getElementLocator(prop.getProperty("Connection.hive.useSSLLabel"));
	By useSSLCheckbox = getElementLocator(prop.getProperty("Connection.hive.useSSL.Checkbox"));
	By javaTruststoreRadioLabel = getElementLocator(
			prop.getProperty("Connection.hive.javaTruststore.radiobuttonlabel"));
	By javaTruststorePaawordLabel = getElementLocator(prop.getProperty("Connection.hive.javaTruststore.Passwordlabel"));
	By javaTruststorePaawordfeild = getElementLocator(prop.getProperty("Connection.hive.javaTruststore.Passwordfeild"));
	By servicePrincipallabel = getElementLocator(prop.getProperty("Connection.hive.servicePrincipal.label"));
	By servicePrincipalfeild = getElementLocator(prop.getProperty("Connection.hive.servicePrincipal.feild"));
	By ticketCacheLabel = getElementLocator(prop.getProperty("Conn.hive.ticketcachename.label"));
	By ticketCachefeild = getElementLocator(prop.getProperty("Conn.hive.ticketcachename.feild"));
	By javaTrustChoosefile = getElementLocator(prop.getProperty("Conn.hive.javaTruststore.choosefile"));
	By javaTrustStoreFeild = getElementLocator(prop.getProperty("Conn.hive.javaTruststore.feild"));
	By rowDisabled = getElementLocator(prop.getProperty("Connection.fileconn.row.disabled"));
	By javaTruStstoreChoosefile = getElementLocator(prop.getProperty("Conn.hive.javatruststore.choosefile.label"));

	By connAthenaS3LocationField = getElementLocator(prop.getProperty("Conn.AthenaIAMS3Location.Field"));
	By connAthenaS3LocationTitle = getElementLocator(prop.getProperty("Conn.AthenaIAMS3Location.Label"));
	By connAthenaRegionField = getElementLocator(prop.getProperty("conn.flatfile.native.Region.field"));
	By connAthenaRegionLabel = getElementLocator(prop.getProperty("conn.flatfile.native.Region.label"));

	// **************************************String Variables
	// ************************************************************************************
	String ConnectionPageTitle = prop.getProperty("ConnectionPage.Title");
	String UserConnectionPageTitle = prop.getProperty("UserConnectionPage.Title");
	String connAthenaS3LocationPlaceholder = prop.getProperty("Connection.Athena.S3Location.placeholder");
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
	String connTestAuthorizeMess = prop.getProperty("connTestAuthorizeMess");
	String connectionSaveMesssage = prop.getProperty("ConnectionSaveMesssage");
	String ConnectionTestMsgInvalidFolderPath = prop.getProperty("ConnectionTestMsgInvalidFolderPath");
	String connSaveMsgFileUpload = prop.getProperty("ConnectionSaveMsgFileUpload");
	String connsaveMsgconntypeChange = prop.getProperty("saveMsgconntypeChange");
	String labelConnType = prop.getProperty("Connection.LabelConnType");
	String connectionUpdate = prop.getProperty("conn.PowerBIUpdateMess");
	String selectWorkspaceSearchClick = prop.getProperty("Connection.SelectWorkspaceSearchClick");
	String selectConnTypeSearch = prop.getProperty("Connection.SelectConnTypeSearch");
	String dynamicName = prop.getProperty("DynName");
	String valueAttribute = prop.getProperty("Attribute.value");
	String krb5value = prop.getProperty("Attribute.krb5value");
	String scrollToElementArg = prop.getProperty("ScrollToElementArgument");
	String booleanTrue = prop.getProperty("Boolean.True");
	String placeHolderAttribute = prop.getProperty("Atribute.placeholder");
	String connectionNameSearchApi = prop.getProperty("ConnectionName.SearchAPI");
	String connectionNamePlaceHolder = prop.getProperty("Connection.Conn.Name.placeholder");
	String connAuthTypeSelect1 = prop.getProperty("Connection.Conn.Auth.TypeSelect");
	String connIcedqUserAuthorisationMsg = prop.getProperty("dataT.RunErrorMsg");
	String connAccountIdentifirePlaceHolder = prop.getProperty("Connection.Conn.AccountIdentifire.placeholder");
	String connWarehousePlaceHolder = prop.getProperty("Connection.Conn.Warehouse.placeholder");
	String connDatabasePlaceHolder = prop.getProperty("Connection.Conn.Database.placeholder");
	String connservicePrinciplePlaceHolder = prop.getProperty("Connection.hive.servicePrinciple.placeholder");
	String connectionNameLinkWithContains = prop.getProperty("Connection.Conn.Name.ContainsLink");
	String connectionNameCheckboxListWithContains = prop.getProperty("Connection.Conn.Name.Checkbox.ContainsList");
	String connectionDeletePopupBtn = prop.getProperty("Connection.Conn.Delete.Popup.Button");
	String connFlatFileSelectLocation = prop.getProperty("conn.flatfile.native.location.selectLocation");
	String connselectLocation = prop.getProperty("conn.location.selectLocation");
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
	String connAllFieldValidation = prop.getProperty("conn.All.feild.validation");
	String connJDBCFieldValidation = prop.getProperty("conn.JDBC.feild.validation");
	String accountNamePlaceHolder = prop.getProperty("Connection.Conn.AccountName.placeholder");
	String accountNameEmptyValidationMsg = prop.getProperty("Connection.AccountName.empty");
	String accountKeyPlaceHolder = prop.getProperty("Connection.Conn.AccountKey.placeholder");
	String accountKeyEmptyValidationMsg = prop.getProperty("Connection.AccountKey.empty");
	String connSingledeletePopupContentMsg = prop.getProperty("Connection.Conn.SingleDelete.Popup.Msg");
	String connSingledeletePopupTitle = prop.getProperty("Connection.Conn.SingleDelete.Popup.Title");
	String conntypechangePopupTitle = prop.getProperty("Connection.typechange.Warning.Popup.Title");
	String conntypechangePopupTitleMsg = prop.getProperty("Connection.typechange.Warning.Popup.Msg");
	String connMultideletePopupContentMsg = prop.getProperty("Connection.Conn.MultiDelete.Popup.Msg");
	String connMultideletePopupTitle = prop.getProperty("Connection.Conn.MultiDelete.Popup.Title");
	String connSingleDeleteToastMsg = prop.getProperty("Connection.Conn.SingleDelete.ToastMsg");
	String connHostPlaceholder = prop.getProperty("Connection.Conn.Host.placeholder");
	String connPortPlaceholder = prop.getProperty("Connection.Conn.Port.placeholder");
	String connUsernamePlaceholder = prop.getProperty("Connection.Conn.Username.placeholer");
	String connPrincipalPlaceholder = prop.getProperty("Connection.Conn.Principal.placeholer");
	String connPasswordPlaceholder = prop.getProperty("Connection.Conn.Password.placeholder");
	String validationHostEmpty = prop.getProperty("Connection.Host.empty");
	String validationPortEmpty = prop.getProperty("Connection.Port.empty");
	String validationDatabaseEmpty = prop.getProperty("Connection.Database.empty");
	String validationUserprincipal = prop.getProperty("Connection.hive.userprincipal.validation");
	String validationServicePrincipalEmpty = prop.getProperty("Connection.hive.serviceprincipal.empty");
	String validationPortInvalid = prop.getProperty("Connection.Port.invalid");
	String connConnectionPropNames = prop.getProperty("Connection.ConnectionProperties.Names");
	String connConnectionPropValues = prop.getProperty("Connection.ConnectionProperties.Values");
	String connConnectionPropTypes = prop.getProperty("Connection.ConnectionProperties.Types");
	String connConnectionTypes = prop.getProperty("Connection.Connection.Types");
	String connSecretNamePlaceholder = prop.getProperty("Connection.Conn.SecretName.placeholder");
	String validationS3OutputLocationEmpty = prop.getProperty("Connection.S3.OutputLocation.empty");

	String connPropCommonLocator1 = prop.getProperty("Connection.Conn.Property1.field");
	String connPropCommonLocator2 = prop.getProperty("Connection.Conn.Property2.field");
	String connPropCommonLocator3 = prop.getProperty("Connection.Conn.Property3.field");
	// String connConnectionPropCommonLocator
	// =prop.getProperty("Connection.Conn.Property.fieldnew");
	// DH
	// String connConnectionPropCommonLocatorDatabricks =
	// prop.getProperty("Connection.Conn.Property.field_Databricks");
	String connPropCommonNameUpdate = prop.getProperty("Connection.Conn.Property.name.Update");

	String connPropCommonValueUpdate = prop.getProperty("Connection.Conn.Property.value.Update");

	// String connConnectionPropCommonLocator =
	// prop.getProperty("Connection.Conn.Property.field");

	String connConnectionPropCommonLocator = prop.getProperty("Connection.Conn.Property.field");

	String connPropCommonFieldUpdate = prop.getProperty("Connection.Conn.Property.Field.Update");
	String connPropertyEditButton = prop.getProperty("Connection.Conn.Property.EditButton");
	String connPropertyDeleteButton = prop.getProperty("Connection.Conn.Property.DeleteButton");
	String connPropertySaveButton = prop.getProperty("Connection.Conn.Property.SaveButton");
	String connPropertyCancelButton = prop.getProperty("Connection.Conn.Property.CancelButton");
	String connectionCredentialsFile = prop.getProperty("ConnectionCredentialsFile");
	String connectionlocationoptions = prop.getProperty("connection.connectionlocationoptions");
	String connectionfileoptions = prop.getProperty("connection.connectionfileoptions");
	String connectionauthenticationoptions = prop.getProperty("connection.connectionauthenticationoptions");
	String connectiontypeselectoptions = prop.getProperty("connection.connectiontypeselectoptions");
	String userconnectionnameclick = prop.getProperty("connection.userconnectionnameclick");
	String connNameLink = prop.getProperty("connection.ConnectionNameLink");
	String newConnClickConnTile = prop.getProperty("conn.clickonConnTypeBtn");
	String editBtnwrtPropName = prop.getProperty("conn.property.usingname.Edit.btn");
	String connPropertyType = prop.getProperty("Connection.AddPropertyType");
	String existingPropertySaveButton = prop.getProperty("conn.existingProperty.save.btn");
	String existingPropertyCancelButton = prop.getProperty("conn.existingProperty.Cancel.btn");
	String attributeTextContent = prop.getProperty("Atribute.textContent");
	String readerGrantErrMessage = prop.getProperty("conn.ReaderErrorMessage");
	String attributeClassName = prop.getProperty("Attribute.Class");
	String attributeBorder = prop.getProperty("Attribute.borderToColor");
	String connSecurityTokenPlaceholder = prop.getProperty("Conn.Placeholder.SecurityToken");
	String connSessionTokenPlaceholder = prop.getProperty("Conn.Placeholder.SessionToken");
	String connSecurityTokenEmpty = prop.getProperty("Conn.Empty.SecurityToken");
	String connSessionTokenEmpty = prop.getProperty("Conn.Empty.SessionToken");
	String connDefaultPropertyField = prop.getProperty("Connection.Conn.Property.default");
	String connPropertyTypeFieldDD = prop.getProperty("conn.property.Type.DD");
	String connTcktCacheValidation = prop.getProperty("Connection.hive.tcktcache.empty");
	String connTicketCachePlaceHolder = prop.getProperty("Connection.hive.tcktcache.placeholder");
	String warningPopupContent = prop.getProperty("Connection.Conn.Warning.Content");
	String salesforcePopupContent = prop.getProperty("Connection.salesforce.Content");
	String ProjectiDPlaceholder = prop.getProperty("Connection.ProjectiD.placeholder");
	String validationProjectIDEmpty = prop.getProperty("Connection.gbq.ProjectID.empty");

	String connPropNameDynamic=prop.getProperty("conn.connPropertyName");
	


	// ###
	String connCatalogPlaceHolder = prop.getProperty("Connection.Conn.Catalog.placeholder");
	String connHttpPathPlaceHolder = prop.getProperty("Connection.Conn.HttpPath.placeholder");
	// ###

	String chooseFilebtn = prop.getProperty("Connection.hive.keytab.ChooseFile");

	public final String forbiddenToastMsg = prop.getProperty("Connection.NewConnBtn.UserAuth.ErrMsg");
	public final String strDBConnectionType = prop.getProperty("conn.testdata.dbConnectorType");
	public final String updateAndSaveClickErrorMessage = prop.getProperty("conn.updateAndSaveClickErrorMessage");
	public final String connMultiDeleteToastMsg = prop.getProperty("Connection.Conn.MultiDelete.ToastMsg");

	String create_actualValue = prop.getProperty("conn.status.create.actualValue");
	String update_actualValue = prop.getProperty("conn.status.update.actualValue");

	static public String duplicateConnName = null;

	/**
	 * -------------------------------DataBase Connection common method for valid
	 * scenarios started from here --------------------------------------
	 **/

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

	public String setAuthenticationType(String jsonauthType) {

		String authName = null;

		if (!jsonauthType.isEmpty()) {
			switch (jsonauthType.toLowerCase()) {

			case "password":
				authName = ConstantProperty.AUTH_USERNAMEPASSWORD;
				break;

			case "kerberos":
				authName = ConstantProperty.AUTH_KERBEROS;
				break;

			case "azure-key-vault":
				authName = ConstantProperty.AUTH_KEYPAIRAZUREKEYVAULT;
				break;

			case "key-pair":
				authName = ConstantProperty.AUTH_KEYPAIR;
				break;

			case "none":
			
				authName = ConstantProperty.AUTH_LOCAL;
				break;

			case "aws-iam-flat-file":
			case "flat-file-sql":
			case "aws-iam":
				authName = ConstantProperty.AUTH_AWS_IAM;
				break;

			case "azure-access-key":
			case "azure-access-key-flat-file":
				authName = ConstantProperty.AUTH_AZURE_ACCESSKEY;
				break;

			case "azure-shared-signature":
			case "azure-shared-signature-flat-file":
				authName = ConstantProperty.AUTH_AZURE_SHAREDSIGNATURE;
				break;

			case "aws-custom-credentials":
			case "aws-custom-credentials-flat-file":
				authName = ConstantProperty.AUTH_AWS_CUSTOMCREDENTIAL;
				break;
			
			case "password-sqlserver":
				authName = "SQL Server Authentication";
				break;
			case "windows-ntlm-sqlserver-custom":
			case "windows-ntlm":
				authName = "Windows Authentication";
				break;
			case "oauth":
				authName = ConstantProperty.AUTH_SALESFORCE;
				break;
			case "kerberos-keytab":
				authName = ConstantProperty.AUTH_KERBEROS_KEYTAB;
				break;
			case "kerberos-ticket-cache":
				authName = ConstantProperty.AUTH_KERBEROS_TICKET_CACHE;
				break;
			case "gcp-service-account-custom":
				authName = ConstantProperty.AUTH_GOOGLE_BIG_QUERY;
				break;

			default:

			}
		}
		return authName;
	}

	
	/** Location method **/

	public String setLocationType(String locationType) {

		String locationName = null;

		if (!locationType.isEmpty()) {
			switch (locationType.toLowerCase()) {

			case "aws-s3":
				locationName = "Amazon S3";
				break;
		
			case "azure-blob":
				locationName = "Azure Blob Storage";
				break;
			case "local":
				locationName = ConstantProperty.AUTH_LOCAL;
				break;
		
			case "s3":
				locationName = "Amazon S3";
				break;
		
			case "azure blob":
				locationName = "Azure Blob Storage";
				break;

			default:

			}
		}
		return locationName;
	}
	
	public ConnectionPoJO setConnectionParametersForApi(String jsonEntity) throws NullPointerException {
		ConnectionPoJO connParam = new ConnectionPoJO();
		//XLUtils xl = new XLUtils();
		try {

			connParam.setDriverName(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.driverId"));
			connParam.setAuthentication(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.authTypeId"));
			connParam.setCustomJdbcFullUrl(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.serverConfig.useJDBCurl"));
			connParam.setHost(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.serverConfig.info.host"));
			connParam.setPort(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.serverConfig.info.port"));
			connParam.setDatabase(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.serverConfig.info.database"));
			connParam.setType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.type"));
			connParam.setUsername(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.authConfig.username"));
			connParam.setClientId(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.authConfig.oauthClientId"));
			connParam.setPassword(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.authConfig.password"));
			connParam.setConnProperty(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.payload.connectionInfo.connectionProperties"));
			connParam.setNameAccount(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.serverConfig.info.accountIdentifier"));
			connParam.setWareHouseVal(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.serverConfig.info.warehouse"));
			connParam.setFilePathKey(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.serverConfig.info.kpFileName"));
			connParam.setKeyVaultName(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.authConfig.keyVaultName"));
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
			connParam.setDatabaseName(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.serverConfig.info.database"));
			connParam.setConnName(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.name"));
			connParam.setServiceProviderName(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.serviceProviderName"));
			connParam.setFileType(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.serverConfig.info.fileType"));
			connParam.setFolderPath(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.serverConfig.info.folderPath"));
			connParam.setContainer(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.serverConfig.info.container"));
			connParam.setRegionValue(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.serverConfig.info.region"));
			connParam.setAccessKey(getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 3));
			connParam.setSecretKey(getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 4));
			connParam.setLocationname(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.serverConfig.info.location"));
			connParam.setFiletypename(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.serverConfig.info.fileType"));
			connParam.setAuthenticationname(setAuthenticationType(connParam.getAuthentication()));
			connParam.setFilepath(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.payload.connectionInfo.uri"));
			connParam.setTypeselect(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.status"));
			connParam.setAccountname(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.authConfig.azureAccount"));
			connParam.setAzureAccesskey(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.authConfig.azureAccessKey"));
			connParam.setSessiontoken(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.authConfig.awsSessionToken"));
			connParam.setRegion(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.payload.connectionInfo.region"));
			connParam.setAccess(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.authConfig.awsAccessKey"));
			connParam.setSecret(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.authConfig.awsSecretKey"));
			connParam.setConnectionid(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.payload.connId"));
			connParam.setSecurityToken(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.authConfig.securityToken"));
			connParam.setSecretName(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.secretId"));
			connParam.setVaultstatus(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.useVault"));
			connParam.setSecretPassword(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.authConfig.password"));
			connParam.setSandboxcheckbox(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.serverConfig.info.useSandbox"));
			connParam.setUseSSLCheckbox(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.serverConfig.info.useSsl"));
			// connParam.setJavatruststorePass(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
			// "$.serverConfig.info.useSsl"));
			connParam.setServicePrincipal(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.serverConfig.info.servicePrincipal"));

			connParam.setUserPrincipal(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.authConfig.krbPrincipal"));

			connParam.setTicketCacheFileName(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.authConfig..ticketCacheFileName"));
			connParam.setJaasProperties(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.serverConfig.info.jaasProperties"));

			connParam.setProjectid(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.serverConfig.info.projectId"));
			connParam.setcloudProvidername(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.serverConfig.info.cloudProvider"));

			connParam.setDatabricksEnvironmentname(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.serverConfig.info.databricksEnvironment"));
			connParam.setDatabricksPassword(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.authConfig.password"));
			connParam.setHttpPath(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.serverConfig.info.httpPath"));
			connParam.setSecretId(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.secretId"));
			connParam.setTestFile(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.serverConfig.info.sampleFile"));

		} catch (Exception e) {

			throw new NullPointerException();
		}
		return connParam;
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
				waitForExecution(2000);
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

	// method to check button and lables on conn repo - tested
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

	// method to click on connection tab
	public void clickOnConnectionsTab() {

		SoftAssert soft = new SoftAssert();
		isDisplayedInLoop(driver, 10, connectionTab);

		try {
			if (isDisplayed(driver, connectionTab)) {

				BaseSuite.reportLog("Clicking on  Connections tab ..");
				waitForExecution(2000);
				displayAndClick(driver, connectionTab);

				BaseSuite.validationReportLog("Clicked on  Connections tab successfully");
				isDisplayedInLoop(driver, 1, discardBtnPopup);
				if (isDisplayed(driver, discardButtons)) {
					clickOnButton(driver, discardButtons, "Discard", true);
				}
				inVisible(driver, connectionPageSpinner, Constant.ruleWait);
				if (isDisplayed(driver, toastMsgClosedBtn)) {
					captureToastMsg(driver, toastMsg, toastMsgClosedBtn, connFetchedMsg, "Connection Fetched");
				}
				isDisplayedInLoop(driver, 2, mainHeadingTitle);
				String str = getText(driver, mainHeadingTitle);

				soft.assertEquals(str, "Connections");
				if (str.equalsIgnoreCase("Connections")) {
					BaseSuite.validationReportLog("Expected Title : Connections and Actual Title : " + str
							+ " matched  " + ConstantProperty.SUCCESSSTRING + "");
				} else {
					BaseSuite.reportFailLog("Expected Title : Connections and Actual Title : " + str,
							"clickOnConnectionsTab1");
				}
			} else {
				BaseSuite.reportFailLog(" Connections tab not visible", "clickOnConnectionsTab");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(" Connections tab not clickable" + e.toString());
		}
	}

	// method to validate pagination arrows and return page and record details
	public List<String> getPaginationDetails() {

		String pageinfo;
		String totalRecords;
		String currentpage;
		int totalpage;

		isDisplayedInLoop(driver, 10, connPaginationMsg1);

		pageinfo = getAttribute(driver, connPaginationMsg1, "innerText");

		BaseSuite.reportLog("Page details displayed :: " + pageinfo);

		totalpage = Integer.parseInt(pageinfo.split(" ")[2]);

		BaseSuite.reportLog("Total page available are :: " + totalpage);

		totalRecords = pageinfo.split(" ")[4].replace("(", "");

		BaseSuite.reportLog("Total Records available are :: " + totalRecords);

		currentpage = pageinfo.split(" ")[0];

		BaseSuite.reportLog("Current page number is :: " + currentpage);

		List<WebElement> arrows = getElements(driver, pageArrows1);

		for (int j = 0; j < arrows.size(); j++) {

			String arrow = arrows.get(j).getAttribute("innerText").replaceAll("Go to", "");

			BaseSuite.reportLog("Checking page arrow :: " + arrow);

			String status = arrows.get(j).getAttribute(attributeClassName);

			if (status.contains("disable")) {
				BaseSuite.validationReportLog("Page arrow :: " + arrow + " is disabled");
			} else {
				BaseSuite.validationReportLog("Page arrow :: " + arrow + " is enabled");
			}
		}
		return Arrays.asList(pageinfo, totalRecords, currentpage);
	}

	// method to click on new conn button on conn repo home page
	public boolean clickOnNewConnectionBtn(String icedqUser) throws Exception {
		boolean s = true;
		LoginPage lp = new LoginPage(driver);
		try {
			if (isDisplayed(driver, userName) && isDisplayed(driver, passWord)) {

				lp.loginWithIcedqUserAndSelectWorkspace(icedqUser, ConstantProperty.TARGET_WORKSPACE_NAME,
						ConstantProperty.CONNECTIONREPOMODULENAME, "");

			}

			clickOnButton(driver, clickonNewConnection, "New Connection", true);

			inVisible(driver, spinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 1, toastMsg);

			if (!icedqUser.toLowerCase().contains("owner")) {

				s = captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn,
						ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG, "New connection authorization message");
				if (!s) {
					BaseSuite.reportFailLog("Expected Toast Message not found for user " + icedqUser + "kindly check, ",
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

	/** Choose connector type for api **/

	public String setConnectorIdToConnectorName(String connectorId) {
		String connectorName = null;

		switch (connectorId.toLowerCase()) {

		case "flat-file":
			connectorName = "Flat File";
			break;
		case "hive":
			connectorName = "Hive";
			break;

		case "snowflake":
			connectorName = "Snowflake";
			break;

		case "redshift":
			connectorName = "Redshift";
			break;
		case "postgresql":
			connectorName = "PostgreSQL";
			break;
		case "xml":
			connectorName = "XML";
			break;

		case "oracle":
			connectorName = "Oracle";
			break;

		case "mysql":
			connectorName = "MySQL";
			break;

		case "db2":
			connectorName = "DB2";
			break;

		case "sybase":
			connectorName = "Sybase";
			break;

		case "teradata":
			connectorName = "Teradata";
			break;
		case "greenplum":
			connectorName = "Greenplum";
			break;
		case "sql-server":
			connectorName = "SQL Server";
			break;

		case "flat-file-sql":
			connectorName = "Flat File (SQL)";
			break;

		case "mariadb":
			connectorName = "MariaDB";
			break;
		case "denodo":
			connectorName = "Denodo";
			break;
		case "salesforce":
			connectorName = "Salesforce";
			break;
		case "json":
			connectorName = "JSON";
			break;
		case "google-bigquery":
			connectorName = "Google BigQuery";
			break;

		case "databricks":
			connectorName = "Databricks";
			break;

		case "excel":
			connectorName = "Excel";
			break;

		case "impala":
			connectorName = "Impala";
			break;

		case "parquet":
			connectorName = "Parquet";
			break;

		case "atscale":
			connectorName = "AtScale: Microsoft SSAS";
			break;

		case "amazon-aurora-mysql":
			connectorName = "Amazon Aurora MySQL";
			break;

		case "amazon-aurora-postgresql":
			connectorName = "Amazon Aurora PostgreSQL";
			break;

		case "netezza":
			connectorName = "IBM Netezza";
			break;

		case "sap-hana":
			connectorName = "SAP HANA";
			break;

		case "vertica":
			connectorName = "Vertica";
			break;

		case "athena":
			connectorName = "Athena";
			break;

		default:

		}

		return connectorName;

	}

	public String setServiceProvidertoLocation(String Location) {
		String locationName = null;

		switch (Location.toLowerCase()) {

		case "local":
			locationName = "Local";
			break;

		case "aws-s3":
			locationName = "Amazon S3";
			break;

		case "s3":
			locationName = "Amazon S3";
			break;

		case "azure-blob":
			locationName = "Azure Blob Storage";
			break;

		case "azure blob":
			locationName = "Azure Blob Storage";
			break;

		default:

		}

		return locationName;

	}

	/**
	 * choose connector type using api data
	 * 
	 * @throws Exception
	 **/
	public void chooseConnectorType(String connectorId) throws Exception {

		String connectorName = setConnectorIdToConnectorName(connectorId);

		isDisplayedInLoop(driver, 2, chooseConnectionTypeSearchTxt);
		inVisible(driver, chooseConnectionTypeSpinner, Constant.ruleWait);
		if (isDisplayed(driver, chooseConnectionTypeSearchTxt)) {

			BaseSuite.validationReportLog("Search textbox is displayed on choose connection type page.");

			clear_SendKeys(driver, chooseConnectionTypeSearchTxt, connectorName);

			driver.findElement(chooseConnectionTypeSearchTxt).sendKeys(Keys.ENTER);

			BaseSuite.reportLog("Enter button clicked successfully, verifying searched record.");

			BaseSuite.validationReportLog("Searched successfully " + connectorName + " connection type.");

			isDisplayedInLoop(driver, 0, returnElement(newConnClickConnTile, dynamicName, connectorName));

			if (isDisplayed(driver, returnElement(newConnClickConnTile, dynamicName, connectorName))) {

				displayAndClick(driver, returnElement(newConnClickConnTile, dynamicName, connectorName));

				BaseSuite.validationReportLog("Successfully clicked on connection " + connectorName + " button.");

				inVisible(driver, chooseConnectionTypeSpinner, Constant.ruleWait);
			}
		} else {
			//
		}
	}

	/**
	 * validate validation message for field and whether is expected or not - true
	 * if message is expected and false if message not expected
	 **/
	public String validationMessageOfField(By locator, String label, String expected, boolean state) {

		String valMsg = null;
		if (!expected.isEmpty()) {
			isDisplayedInLoop(driver, 0, locator);
			if (isDisplayed(driver, locator)) {
				valMsg = getText(driver, locator);

				if (!valMsg.isEmpty()) {

					if (state) {

						BaseSuite.reportLog("Expected :- " + expected);

						BaseSuite.reportLog("Actual :- " + valMsg);

						if (valMsg.trim().contains(expected)) {

							BaseSuite.validationReportLog("Proper Validation message applied on " + label + "  field");
						} else {
							BaseSuite.reportFailLog("Validation message not matched for " + label + "  field",
									"validationMessageOfField");
						}

					} else {
						if (valMsg.trim().contains(expected)) {

							BaseSuite.validationReportLog("Proper Validation message applied on " + label + " field ");

						} else {
							BaseSuite.reportFailLog("Validation message not matched for " + label + " field  ",
									"validationMessageOfField");
						}
					}
				}
			} 
		}
		return valMsg;
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

			isClickable(driver, connName, Constant.CONNECTIONNAME + "   field", true);

			if (isEditable(driver, connName, Constant.CONNECTIONNAME + " field   ")) {

				click(driver, connName);

				clear(driver, connName);

				if (!connectionName.isEmpty()) {
					BaseSuite.reportLog("Entering value  : " + connectionName);
					clear(driver, connName);
					sendKeys(driver, connName, connectionName);
					BaseSuite.reportLog("Entered value  : " + connectionName);
				} else {
					BaseSuite.reportLog("Entering value  : " + connectionName);
					sendKeys(driver, connName, "emptyvalue");
					clear(driver, connName);
					
				}
				isDisplayedInLoop(driver, 4, connName);

				click(driver, connName);
				waitForExecution(1000);

				String ac = getAttribute(driver, connName, valueAttribute);

				stringContainsOutput(ac, connectionName, true);

				if (validationMessage.isEmpty()) {
					validationMessageOfField(connectionNameValidation, "Connection name", "", false);
					flag = true;
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
			BaseSuite.reportErrorLog("Exception found :  " + e.getMessage());
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
					waitForExecution(1000);
					List<WebElement> authList = getElements(driver, connFlatFileDriverDDList);
 
					for (int i = 0; i < authList.size(); i++) {
 
						String authName = authList.get(i).getAttribute("data-value");
 
						BaseSuite.reportLog((i + 1) + ". " + authName + "  is visible");
 
					}
				}
				waitForExecution(1000);
				isDisplayedInLoop(driver, 4, returnElement(connselectDriver, dynamicName, driverName));
 
				waitForExecution(2000);
 
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

	/** Select Authentication method **/
	public void selectAuthenticationOfConnection(String authenticationType) {
		String methodName = "selectAuthenticationOfConnection";
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
 
				BaseSuite.validationReportLog("Clicked on auth type drop down " + ConstantProperty.SUCCESSSTRING + "");
 
				BaseSuite.reportLog("Checking list of auth type visible");
				waitForExecution(2000);
				List<WebElement> authList = getElements(driver, connAuthTypeList);
 
				for (int i = 0; i < authList.size(); i++) {
 
					String authName = authList.get(i).getAttribute(attributeTextContent);
 
					BaseSuite.reportLog((i + 1) + ". " + authName + " is visible");
 
				}
 
				/** authenticationType = setAuthenticationType(authenticationType); **/
 
				BaseSuite.reportLog("Selecting expected authentication type : " + authenticationType);
				
				isDisplayedInLoop(driver, 0, returnElement(connAuthTypeSelect1, dynamicName, authenticationType));

				waitForExecution(2000);

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
								methodName);
					}
 
				} else {
					BaseSuite.reportFailLog("Authentication type not visible " + authenticationType, methodName);
				}
 
			} else {
				BaseSuite.reportFailLog("Authentication field not visible ", methodName);
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
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

					String actualState = getAttribute(driver, connCustomJDBCCheckbox, attributeClassName);

					if (actualState.contains(str)) {

						BaseSuite.reportLog("Default condition of Custom JDBC URL checkbox is checked");
					} else {
						BaseSuite.reportLog("Default condition of Custom JDBC URL checkbox is unchecked");
					}

					if (Boolean.parseBoolean(state) && !actualState.contains(str)) {

						BaseSuite.reportLog("Clicking on custom JDBC URL checkbox");

						inVisible(driver, spinner, Constant.ruleWait);

						displayAndClick(driver, connCustomJDBCCheckbox);

						inVisible(driver, spinner, Constant.ruleWait);

						actualState = getAttribute(driver, connCustomJDBCCheckbox, attributeClassName);

						stringContainsOutput(actualState, str, true);
						flag = true;
					} else if (state.equalsIgnoreCase("false") && actualState.contains(str)) {

						BaseSuite.reportLog("Clicking on custom JDBC URL checkbox");

						displayAndClick(driver, connCustomJDBCCheckbox);

						/**
						 * actualState = getAttribute(driver, connCustomJDBCCheckbox, "class");
						 * 
						 * stringContainsOutput(actualState, str, true);
						 **/
						flag = true;

					} else if (state.equalsIgnoreCase("true") && actualState.contains(str)) {

						BaseSuite.reportLog("Checkbox is checked.");

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

			// BaseSuite.validationReportLog("Expected value matched is " + ph);

			if (ph.isEmpty()) {

				if (ph.equalsIgnoreCase(placeholder)) {

					BaseSuite.validationReportLog("Expected place holder value matched");
				} else {
					BaseSuite.reportFailLog("Expected place holder value not matched", "validateInputFieldVisibility");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e.toString());
		}

		return flag;
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

						BaseSuite.reportLog(label + " field placeholder : " + ph);

					} else {

						BaseSuite.reportFailLog(label + " field place holder not found : Actual :" + ph
								+ " and Expected : " + placeHolder, " validatAndeEnterValueToTextField");
					}
				}
				if (!input.isEmpty()) {

					inVisible(driver, spinner, Constant.ruleWait);

					// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					// fieldLocator);

					click(driver, fieldLocator);

				    clear(driver, fieldLocator);

					// validationMessageOfField(returnElement(connCommonFieldValidation,
					// dynamicName, label.toLowerCase()), label, fieldValidation, true);

					BaseSuite.reportLog(" Entering value : " + input);

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

			BaseSuite.reportErrorLog(" Exception found : " + e.getMessage());
			throw new NoSuchElementException();
		}
		return flag;
	}

	public void selectConnectionTypeForConn(List<WebElement> typeList, String value) throws NullPointerException {
		try {

			int a = 1;
			for (int i = 0; i < typeList.size(); i++) {
				String label = typeList.get(i).getAttribute("data-value");

				if ((label.equalsIgnoreCase("System")) || (label.equalsIgnoreCase("User"))) {
					BaseSuite.validationReportLog(a + "- " + label);
					a++;
				}

			}
			waitForExecution(1000);
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
			Thread.currentThread().interrupt();
			e.getMessage();

		}

	}

	// method to validate connection type dropdown & select one value
	public void selectConnectionType(String value) throws NoSuchElementException {
		try {
			isDisplayedInLoop(driver, 5, connTypeSelectionDropdown);
			javascript(driver, scrollToElementArg, connTypeSelectionDropdown);

			if (isDisplayed(driver, connTypeSelectionDropdown)) {
				BaseSuite.reportLog("Connection type dropdown is displayed.");

				if (isClickable(driver, connTypeSelectionDropdown, "type dropdown", true)) {
					click(driver, connTypeSelectionDropdown);

					if (isDisplayed(driver, connTypeListpane)) {
						BaseSuite.reportLog("Type list options are displayed");

						List<WebElement> typeList = getElements(driver, connTypeList);

						BaseSuite.reportLog("List has " + typeList.size() + "options as:");

						selectConnectionTypeForConn(typeList, value);

						waitForExecution(1000);
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

		}
	}

	// Comman method to verify String value expected & actual
	public boolean compareActualNExpectedValue(String actualString, String expectedString) {

		boolean flag = false;

		try {
			if ((!actualString.isEmpty()) && (!expectedString.isEmpty())) {

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

	// Method to validate & enter Username
	public void enterUsername(String value) throws NullPointerException {
		boolean flag = false;
		String methodName = "enterUsername";
		try {
			javascript(driver, scrollToElementArg, connUsernameInput);

			if (isDisplayed(driver, connUsernameInput)) {
				BaseSuite.reportLog("Username field is displayed.");

				if (isEnabled(driver, connUsernameInput)) {
					if (isEditable(driver, connUsernameInput, " username")) {

						clear(driver, connUsernameInput);

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag = verifyplaceholder(connUsernameInput, "Enter username");

						if (flag) {
							BaseSuite.validationReportLog("correct placeholder is displayed in username input box.");
						} else {
							BaseSuite.reportFailLog(
									"Expected placeholder didnt matched with actual placeholder, kindly check.",
									methodName);
						}

						sendKeys(driver, connUsernameInput, value.trim());

						isDisplayedInLoop(driver, 1, connUsernameInput);

						String username = getAttribute(driver, connUsernameInput, valueAttribute).trim();

						compareActualNExpectedValue(username.trim(), value.trim());

					}

				} else {
					BaseSuite.reportFailLog("Username input is disabled, kindly check.", methodName);
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate username field on current page, kindly check.", methodName);
			}

		} catch (Exception e) {
			e.getMessage();

		}
	}

	// verify placeholder in input box

	public boolean verifyplaceholder(By locator, String expected) {
		boolean status = false;
		if (isDisplayed(driver, locator)) {
			String holder = getAttribute(driver, locator, placeHolderAttribute);

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

	// Method to validate & enter Username
	public void enterPassword(String value) throws NullPointerException {
		boolean flag = false;
		String methodName = "enterPassword";
		try {
			javascript(driver, scrollToElementArg, connPasswordInput);

			if (isDisplayed(driver, connPasswordInput)) {
				BaseSuite.reportLog("Password field is displayed.");

				if (isEnabled(driver, connPasswordInput)) {
					if (isEditable(driver, connPasswordInput, " password")) {
						clear(driver, connPasswordInput);

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag = verifyplaceholder(connPasswordInput, "Enter password");

						if (flag) {
							BaseSuite.validationReportLog("correct placeholder is displayed in database input box.");
						} else {
							BaseSuite.reportFailLog(
									"Expected placeholder didnt matched with actual placeholder, kindly check.",
									methodName);
						}

						sendKeys(driver, connPasswordInput, value.trim());

						BaseSuite.validationReportLog("Entered password in password field.");
					}

				} else {
					BaseSuite.reportFailLog("Password input is disabled, kindly check.", methodName);
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate password field on current page, kindly check.", methodName);
			}

		} catch (Exception e) {
			e.getMessage();

		}
	}

	// Method to validate & enter Principal
	public void enterPrincipal(String value) throws NullPointerException {
		boolean flag = false;
		String methodName = "enterPrincipal";
		try {
			javascript(driver, scrollToElementArg, connPrincipalInput);

			if (isDisplayed(driver, connPrincipalInput)) {
				BaseSuite.reportLog("Principal field is displayed.");

				if (isEnabled(driver, connPrincipalInput)) {
					if (isEditable(driver, connPrincipalInput, " Principal")) {

						clear(driver, connPrincipalInput);

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag = verifyplaceholder(connPrincipalInput, "Enter Principal");

						if (flag) {
							BaseSuite.validationReportLog("correct placeholder is displayed in Principal input box.");
						} else {
							BaseSuite.reportFailLog(
									"Expected placeholder didnt matched with actual placeholder, kindly check.",
									methodName);
						}

						sendKeys(driver, connPrincipalInput, value.trim());

						isDisplayedInLoop(driver, 1, connPrincipalInput);

						String principalname = getAttribute(driver, connPrincipalInput, valueAttribute).trim();

						compareActualNExpectedValue(principalname.trim(), value.trim());

					}

				} else {
					BaseSuite.reportFailLog("Principal input is disabled, kindly check.", methodName);
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate Principal field on current page, kindly check.", methodName);
			}

		} catch (Exception e) {
			e.getMessage();

		}
	}

	// click on properties tab
	public void clickOnPropertiesTab() throws NoSuchElementException {
		try {

			isDisplayedInLoop(driver, 4, connPropertiesTab);

			javascript(driver, scrollToElementArg, connPropertiesTab);

			if (isDisplayed(driver, connPropertiesTab)) {

				if (isClickable(driver, connPropertiesTab, "properties", true)) {

					BaseSuite.reportLog("Clicking on properties tab on connection page.");

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
			throw new NoSuchElementException();
		}
	}

	// click on overview tab
	public void clickOnOverviewTab() throws NoSuchElementException {
		try {
			javascript(driver, scrollToElementArg, connOverviewTab);
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
			throw new NoSuchElementException();
		}
	}

	// click on jaas properties tab
	public void clickOnJaasPropertiesTab() throws NoSuchElementException {
		try {

			isDisplayedInLoop(driver, 4, jaasPropertiesTitle);

			javascript(driver, scrollToElementArg, jaasPropertiesTitle);

			if (isDisplayed(driver, jaasPropertiesTitle)) {

				if (isClickable(driver, jaasPropertiesTitle, "jaas properties", true)) {

					BaseSuite.reportLog("Clicking on jaas properties tab on connection page.");

					click(driver, jaasPropertiesTitle);

					BaseSuite.validationReportLog("Clicked successfully on jaas properties tab");

				} else {

					BaseSuite.reportFailLog("JAAS Properties tab is not clickable, kindly check..",
							"jaasPropertiesTitle");

				}
			} else {

				BaseSuite.reportErrorLog("Unable to locate jaas properties tab on connection page, kindly check.");

			}

		} catch (Exception e) {
			e.getMessage();
			throw new NoSuchElementException();
		}
	}

	// method will enter property name
	public void addConnectionPropertyName(String name) throws NoSuchElementException {
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
			throw new NoSuchElementException();
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
				BaseSuite.reportFailLog("Unable to locate property value input field , kindly check.",
						"addConnectionPropertyValue");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new NoSuchElementException();
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
	public void clickOnRemovePropertybutton() throws NoSuchElementException {
		String methodName = "clickOnRemovePropertybutton";
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
					BaseSuite.reportFailLog("Remove property button is disabled, kindly check.", methodName);
				}
			} else {
				BaseSuite.reportFailLog("Unable to locate remove property button, kindly check.", methodName);
			}

		} catch (Exception e) {
			e.getMessage();
			throw new AssertionError();
		}
	}

	// method will click on add property button
	public void clickOnAddPropertybutton() throws NoSuchElementException {
		String methodName = "clickOnAddPropertybutton";
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
					BaseSuite.reportFailLog("Add property button is disabled, kindly check.", methodName);
				}
			} else {
				BaseSuite.reportFailLog("Unable to locate add property button, kindly check.", methodName);
			}

		} catch (Exception e) {
			e.getMessage();
			throw new NoSuchElementException();
		}
	}

	public void enterConnPropertyName(String name) {
		try {

			javascript(driver, scrollToElementArg, addPropertyNameForDB);

			if (!name.isEmpty()) {
				if (isEnabled(driver, addPropertyNameForDB)) {
					if (isClickable(driver, addPropertyNameForDB, " property name", true)) {
						BaseSuite.reportLog("Entering property Name as " + name);

						clear_SendKeys(driver, addPropertyNameForDB, name);

						BaseSuite.validationReportLog("Poperty Name entered successfully");

						String connPropName = getAttribute(driver, addPropertyNameForDB, valueAttribute);

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

	public void enterCustomConnPropertyName(String name) {
		try {

			javascript(driver, scrollToElementArg, addPropertyNameForDB);

			if (!name.isEmpty()) {
				if (isEnabled(driver, addPropertyNameForDB)) {
					if (isClickable(driver, addPropertyNameForDB, " property name", true)) {
						BaseSuite.reportLog("Entering property Name as " + name);

						clear_SendKeys(driver, addPropertyNameForDB, name);

						driver.findElement(addPropertyNameForDB).sendKeys(Keys.ENTER);

						BaseSuite.validationReportLog("Poperty Name entered successfully");

						String connPropName = getAttribute(driver, addPropertyNameForDB, valueAttribute);

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

						clear_SendKeys(driver, addpropertyValueInput, value);

						BaseSuite.validationReportLog("Property value entered successfully");

						String connPropValue = getAttribute(driver, addpropertyValueInput, valueAttribute);

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
		Actions actions = new Actions(driver);
		try {
			isDisplayedInLoop(driver, 2, addPropertyTypeClick);

			if (!type.isEmpty()) {

				if (isDisplayed(driver, addPropertyTypeClick)) {

					if (isClickable(driver, addPropertyTypeClick, "property type", true)) {

						// click(driver, addPropertyTypeClick);
						actions.click(driver.findElement(addPropertyTypeClick)).build().perform();
						BaseSuite.reportLog("Clicked on property type dropdown");

						waitForExecution(2000);

						if (isDisplayed(driver, propTypeListPane)) {

							BaseSuite.reportLog("System & User options are displayed.");

							if (!isDisplayed(driver, propListOptions)) {
								click(driver, addPropertyTypeClick);
							}
						}

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
				} else {
					BaseSuite.reportErrorLog("Unable to locate property type, kindly check.");
				}

			} else {
				BaseSuite.reportErrorLog("Unable to proceed as property type is empty , kindly check.");
			}

		} catch (Exception e) {
			e.getMessage();
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Unabled to select connection property type kindly check :: " + e.toString());
		}

	}

	public void clickonAddPropertyIconButton() {
		try {
			if (isDisplayed(driver, addPropertyDone)) {
				if (isEnabled(driver, addPropertyDone)) {
					if (isClickable(driver, addPropertyDone, "add property icon", true)) {
						BaseSuite.reportLog("Clicking on add property icon  button");

						displayAndClick(driver, addPropertyDone);

						waitForExecution(1000);

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

	public void addConnectionProperty(String name, String value, String type) {

		try {

			clickOnAddPropertybutton();

			waitForExecution(1000);

			enterConnPropertyName(name.trim());

			enterConnPropertyValue(value.trim());

			// selectPropertyType(type.trim());

			selectConnectionType(propConnType, type.trim());

			clickonAddPropertyIconButton();

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void addCustomConnectionPropertyFile(String name, String value, String type) {

		try {

			clickOnAddPropertybutton();

			waitForExecution(1000);

			enterCustomConnPropertyName(name.trim());

			enterConnPropertyValue(value.trim());

			// selectPropertyType(type.trim());

			selectConnectionType(propConnType, type.trim());

			clickonAddPropertyIconButton();

		} catch (Exception e) {

			e.getMessage();
		}

	}

	// method to add connection properties to connection
	public void addConnectionPropertiesToConnection(String jsonEntity, int count) throws Exception {
		try {
			if (count > 0) {

				clickOnPropertiesTab();

				ArrayList<String> name = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						connConnectionPropNames);

				ArrayList<String> value = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						connConnectionPropValues);

				ArrayList<String> type = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						connConnectionPropTypes);

				for (int j = 0; j < name.size(); j++) {

					if (name.get(j).contains("loginTimeout")) {

						validateDefaultConnectionProperty(name.get(j), value.get(j), type.get(j));

					} else {

						addConnectionProperty(name.get(j), value.get(j), type.get(j));
					}
				}

			}
			clickOnOverviewTab();

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();

		}
	}

	public boolean saveConnection(String mess) throws Exception {
		boolean flag = true;
		try {

			BaseSuite.reportLog("Clicking on connection Save button");

			javascript(driver, scrollToElementArg, connSaveBtn);

			flag = verifyVisibilityOfButtons(driver, connSaveBtn, "Save", flag);

			if (flag) {

				displayAndClick(driver, connSaveBtn);

				inVisible(driver, spinner, Constant.ruleWait);

				BaseSuite.reportLog("connection Save button clicked successfully");

				flag = captureToastMsg(driver, toastMsg, popUpClose, mess, "Connection Save");

				inVisible(driver, spinner, Constant.ruleWait);
			}
		} catch (Exception ex) {
			Thread.currentThread().interrupt();
			// throw new Exception(ex.toString());
		} finally {
			isDisplayedInLoop(driver, 0, discardButtons);
			if (isDisplayed(driver, discardButtons)) {
				clickOnButton(driver, discardButtons, "Discard popup", true);
			}
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

				inVisible(driver, spinner, Constant.ruleWait);

				inVisible(driver, spinner, Constant.ruleWait);

				displayAndClick(driver, connTestBtn);

				inVisible(driver, spinner, Constant.ruleWait);

				inVisible(driver, spinner, Constant.ruleWait);

				BaseSuite.reportLog("connection Test button clicked successfully");

				flag = captureToastMsg(driver, toastMsg, popUpClose, mess, " Connection Test");

				waitForExecution(1000);

				inVisible(driver, spinner, Constant.ruleWait);

			}
		} catch (Exception ex) {
			Thread.currentThread().interrupt();
			throw new Exception(ex.toString());
		} finally {
			isDisplayedInLoop(driver, 0, discardButtons);
			if (isDisplayed(driver, discardButtons)) {
				clickOnButton(driver, discardButtons, " Discards ", true);
			}
		}
		return flag;
	}

	// Status identification Method

	public boolean getConnection(String newconnectionName, String expectedValue) throws Exception {
		boolean flag = true;
		try {
			if (isDisplayed(driver, returnElement(statusType, "$name", newconnectionName))) {

				String actualValue = getText(driver, returnElement(statusType, "$name", newconnectionName));

				BaseSuite.reportLog("Retrieved Connection Status : " + actualValue);
				BaseSuite.reportLog("Expected Connection Status : " + expectedValue);

				if (actualValue.equalsIgnoreCase(expectedValue)) {

					BaseSuite.validationReportLog("Expected Connection Status matched successfully");
				} else {
					BaseSuite.reportFailLog("Expected value not matched", actualValue);
				}

			} else {
				BaseSuite.reportFailLog("Element not visible kindly check", "getConnection");

			}

		} catch (Exception ex) {
			throw new NoSuchElementException();
		}
		return flag;
	}

	public boolean updateUsernameAndPasswordForUserConnection(String connJsonEntity, ConnectionPoJO connParam,
			String connectionType, String connusername, String icedqUser) {
		boolean flag = true;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		String UserKeytabLocation = System.getProperty("user.dir") + Constant.USER_KEYTAB_LOCATION;

		try {
			if (connectionType.trim().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {
				if (icedqUser.contains("contributor") || (icedqUser.contains("executor"))) {
					if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS))

					{

						WebElement m = driver.findElement(By.xpath("//input[@id='keytab']"));

						m.sendKeys(UserKeytabLocation);

						BaseSuite.validationReportLog("User key tab File Choosed successfully");

						validatAndeEnterValueToTextField(connUserPrincipalLabel, connHiveUserPrincipal,
								ConstantProperty.CONN_FIELD_USERPRINCIPAL, connPrincipalPlaceholder,
								connParam.getUserPrincipal(), validationUserprincipal);

					} else {

						cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
								connParam.getConnectorID(), icedqUser);

						cp.enterUsername(connusername);

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
						flag = clickQuickAddbtn(forbiddenToastMsg);
					}
				}

			} else {

				if (icedqUser.contains("contributor") || (icedqUser.contains("executor"))) {
					saveConnection(updateAndSaveClickErrorMessage);
				}
				waitForExecution(1000);

				if (icedqUser.contains("owner")) {
					// saveConnection();

					flag = testConnection(connectionTestMess);
				} else if (icedqUser.contains("reader")) {

					waitForExecution(1000);

					saveConnection(updateAndSaveClickErrorMessage);
				}

				// changeConnType(connectionType,connJsonEntity,icedqUser,connectionName);

			}

		} catch (Exception e) {

			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("user connection not updated properly kindly check :" + e.toString());
		}

		return flag;
	}

	public boolean changeConnType(String connectionType, String connJsonEntity, String icedqUser, String connectionName)
			throws Exception {
		boolean flag = true;
		try {
			// NewConnectionRepoPage np = new NewConnectionRepoPage(driver);

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			String connusername = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

			if (isClickable(driver, connTypeSelectionDropdown, "type dropdown", true)) {

				click(driver, connTypeSelectionDropdown);

				if (isDisplayed(driver, connTypeListpane)) {

					BaseSuite.reportLog("Type list options are displayed");

					List<WebElement> typeList = getElements(driver, connTypeList);

					BaseSuite.reportLog("List has " + typeList.size() + "options as:");

					if (connectionType.equalsIgnoreCase("user")) {

						selectConnectionTypeForConn(typeList, "system");

						waitForExecution(1000);

						verifyIndividualLabel(driver, warningPopupTitle, conntypechangePopupTitle);

						verifyIndividualLabel(driver, warningPopupTitleMsg, conntypechangePopupTitleMsg);

						verifyVisibilityOfButtons(driver, connPopupCancelBtn, "Cancel", true);

						verifyVisibilityOfButtons(driver, connPopupYesBtn, "Yes", true);

						click(driver, connPopupYesBtn);

						if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS))

						{

							entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);

							WebElement m = driver.findElement(By.xpath("//input[@id='keytab']"));

							m.sendKeys(
									"D:\\Nexg-ICEDQ-Automation\\ng-icedq-automation\\kerberos files\\testuser.keytab");

							BaseSuite.validationReportLog("User Keytab File Choosed successfully");

						} else {
							if (isDisplayed(driver, connsecretName)) {

								entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
										connParam.getConnectorID(), icedqUser);

								enterUsername(connusername);

							}

							saveConnection(connsaveMsgconntypeChange);

						}
					} else {

						selectConnectionTypeForConn(typeList, "user");

						saveConnection(connsaveMsgconntypeChange);

						clickOnUserConnectionTab();

						searchAndClickOnConnectionNameInConnRepo(connectionName);

						if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS))

						{

							entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);

							WebElement m = driver.findElement(By.xpath("//input[@id='keytab']"));

							m.sendKeys(
									"D:\\Nexg-ICEDQ-Automation\\ng-icedq-automation\\kerberos files\\testuser.keytab");

							BaseSuite.validationReportLog("User Keytab File Choosed successfully");

						} else {
							if (isDisplayed(driver, connsecretName)) {

								entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
										connParam.getConnectorID(), icedqUser);

								enterUsername(connusername);

							}

						}
						saveConnection();
					}

					// testConnection(connectionTestMess);

				}

			}

		}

		catch (Exception ex) {
			Thread.currentThread().interrupt();
			// throw new Exception(ex.toString());
		}
		return flag;

	}

	/**
	 * Connection repository breadcrumbs link
	 * 
	 * @throws Exception
	 **/

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
			waitForExecution(2000);
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

	public boolean clickQuickAddbtn(String mess) throws Exception {
		boolean flag = true;
		try {

			BaseSuite.reportLog("Clicking on Quick Add Button");

			javascript(driver, scrollToElementArg, connsecretQuickAddbtn);

			flag = verifyVisibilityOfButtons(driver, connsecretQuickAddbtn, "Quick Add Button", flag);

			if (flag) {

				Thread.sleep(1000);

				displayAndClick(driver, connsecretQuickAddbtn);

				inVisible(driver, spinner, Constant.ruleWait);

				BaseSuite.reportLog("Quick Add Button clicked successfully");

				flag = captureToastMsg(driver, toastMsg, popUpClose, mess, "Quick Add Button");

				waitForExecution(1000);

				inVisible(driver, spinner, Constant.ruleWait);
			}
		} catch (Exception ex) {
			Thread.currentThread().interrupt();
			// throw new Exception(ex.toString());
		} finally {
			isDisplayedInLoop(driver, 0, discardButtons);
			if (isDisplayed(driver, discardButtons)) {
				clickOnButton(driver, discardButtons, "Discard popup", true);
			}
		}
		return flag;
	}

	public boolean searchConnection(String name) {
		boolean flag = true;
		Actions actions = new Actions(driver);
		try {
			inVisible(driver, connectionPageSpinner, Constant.ruleWait);
			isDisplayedInLoop(driver, 5, usersearchconnection);

			if (isDisplayed(driver, usersearchconnection)) {

				if (isEnabled(driver, usersearchconnection)) {

					if (isEditable(driver, usersearchconnection, "Search box")) {

						isClickable(driver, usersearchconnection, "Search box", flag);

						BaseSuite.reportLog("Entering connection name : " + name);

						waitForExecution(2000);

						clear_Click_SendKeys(driver, 4, usersearchconnection, name);

						isDisplayedInLoop(driver, 2, usersearchconnectionbtn);

						if (isDisplayed(driver, usersearchconnectionbtn)) {

							BaseSuite.reportLog("Clicking on search button");
							
							waitForExecution(2000);
							
							actions.click(driver.findElement(usersearchconnectionbtn)).build().perform();

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
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(e.toString());
			flag = false;
		}

		return flag;
	}

	public boolean clickOnConnectionName(String name) {

		boolean flag = true;

		try {
			waitForExecution(500);

			isDisplayedInLoop(driver, 10, returnElement(connectionNameLinkWithContains, dynamicName, name));

			if (isDisplayed(driver, returnElement(connectionNameLinkWithContains, dynamicName, name))) {

				Thread.sleep(3000);

				clickOnButton(driver, returnElement(connectionNameLinkWithContains, dynamicName, name), name, true);

				waitForExecution(3000);

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

	public boolean searchAndClickOnConnectionNameInConnRepo(String name) {
		boolean flag = true;

		try {
			flag = searchConnection(name);
			// Thread.sleep(1000);
			if (!isDisplayed(driver, noRecondsFound)) {

				if (flag) {
					waitForExecution(1000);
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

	public String validateNewConnPageButtonsFields(String connectorId) throws NoSuchElementException {

		String wizardmsg = null;

		try {

			switch (connectorId.toLowerCase()) {

			case "flat-file":
			case "flat-file-sql":
			case "json":
			case "xml":
			case "excel":
			case "parquet":

				validateInputFields(driver, DatabricksInputFields, 4);

				validateButtons(driver, connExcelBtn, 6);

				wizardmsg = "Wizard not supported connector";

				break;
			// Wizard supported connectors
			case "db2":
			case "mysql":
			case "postgresql":
			case "greenplum":
			case "teradata":
			case "sql-server":
			case "redshift":
			case "oracle":
			case "amazon-aurora-mysql":
			case "amazon-aurora-postgresql":

				validateButtons(driver, connDatabricksBtn, 6);

				validateInputFields(driver, DatabricksInputFields, 5);

				validateTextFields(driver, connCustomJDBCTextbox, 1);

				wizardmsg = "Wizard supported connector";

				break;
			// Wizard not supported connectors
			case "databricks":
			case "denodo":
			case "mariadb":
			case "snowflake":
			case "sybase":
			case "netezza":
			case "vertica":
			case "sap-hana":

				validateButtons(driver, connDatabricksBtn, 5);

				validateInputFields(driver, DatabricksInputFields, 5);

				validateTextFields(driver, connCustomJDBCTextbox, 1);

				wizardmsg = "Wizard not supported connector";

				break;

			case "athena":

				validateButtons(driver, connDatabricksBtn, 5);

				validateInputFields(driver, DatabricksInputFields, 3);

				validateTextFields(driver, connCustomJDBCTextbox, 1);

				wizardmsg = "Wizard not supported connector";

				break;

			case "salesforce":

				validateButtons(driver, connDatabricksBtn, 5);

				validateInputFields(driver, DatabricksInputFields, 3);

				wizardmsg = "Wizard not supported connector";

				break;

			case "google-bigquery":

				validateButtons(driver, connDatabricksBtn, 5);

				validateInputFields(driver, DatabricksInputFields, 2);

				wizardmsg = "Wizard not supported connector";

				break;

			case "atscale":

				validateButtons(driver, connDatabricksBtn, 5);

				validateInputFields(driver, DatabricksInputFields, 2);

				validateTextFields(driver, connCustomJDBCTextbox, 1);

				wizardmsg = "Wizard not supported connector";

				break;

			case "hive":
			case "impala":

				validateButtons(driver, connDatabricksBtn, 5);

				validateInputFields(driver, DatabricksInputFields, 6);

				validateTextFields(driver, connCustomJDBCTextbox, 1);

				wizardmsg = "Wizard not supported connector";

			default:
			}

			return wizardmsg;

		} catch (Exception e) {
			BaseSuite.reportErrorLog("Exception found :  " + e.getMessage());
			throw new NoSuchElementException();
		}
	}

	public String validateExistingConnPageButtonsFields(String connJsonEntity) throws NoSuchElementException {

		String wizardmsg = null;

		ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

		try {

			switch (connParam.connectorID.toLowerCase()) {

			case "flat-file":
			case "flat-file-sql":
			case "json":
			case "xml":
			case "excel":
			case "parquet":

				if (connParam.getServiceProviderName().equalsIgnoreCase("Local")) {

					validateInputFields(driver, DatabricksInputFields, 2);

					validateButtons(driver, connExcelBtn, 6);

					wizardmsg = "Wizard not supported connector";

					break;
				} else if (connParam.getServiceProviderName().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)
						&& (connParam.getServiceProviderName().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)))) {

					validateInputFields(driver, DatabricksInputFields, 4);

					validateButtons(driver, connExcelBtn, 6);

					wizardmsg = "Wizard not supported connector";

					break;

				} else {

					validateInputFields(driver, DatabricksInputFields, 3);

					validateButtons(driver, connExcelBtn, 6);

					wizardmsg = "Wizard not supported connector";

					break;
				}

				// Wizard supported connectors
			case "db2":
			case "mysql":
			case "postgresql":
			case "greenplum":
			case "teradata":
			case "sql-server":
			case "redshift":
			case "amazon-aurora-mysql":
			case "amazon-aurora-postgresql":
			case "oracle":

				// *** IN PROGRESS if
				// (connParam.getCustomJdbcFullUrl().equalsIgnoreCase(booleanTrue)) {

				if ((connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE))) {

					validateButtons(driver, connDatabricksBtn, 6);

					validateInputFields(driver, DatabricksInputFields, 5);

					validateTextFields(driver, connCustomJDBCTextbox, 1);

					wizardmsg = "Wizard supported connector";

					break;
				} else {

					validateButtons(driver, connDatabricksBtn, 6);

					validateInputFields(driver, DatabricksInputFields, 4);

					validateTextFields(driver, connCustomJDBCTextbox, 1);

					wizardmsg = "Wizard supported connector";
					break;

				}

				// Wizard not supported connectors
			case "databricks":
			case "denodo":
			case "mariadb":
			case "snowflake":
			case "sybase":
			case "netezza":
			case "vertica":
			case "sap-hana":

				if ((connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE))) {

					validateButtons(driver, connDatabricksBtn, 5);

					validateInputFields(driver, DatabricksInputFields, 5);

					validateTextFields(driver, connCustomJDBCTextbox, 1);

					wizardmsg = "Wizard not supported connector";

					break;

				} else {

					validateButtons(driver, connDatabricksBtn, 5);

					validateInputFields(driver, DatabricksInputFields, 4);

					validateTextFields(driver, connCustomJDBCTextbox, 1);

					wizardmsg = "Wizard supported connector";

					break;
				}

			case "atscale":

				if ((connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE))) {

					validateButtons(driver, connDatabricksBtn, 5);

					validateInputFields(driver, DatabricksInputFields, 2);

					validateTextFields(driver, connCustomJDBCTextbox, 1);

					wizardmsg = "Wizard not supported connector";

					break;

				} else {

					validateButtons(driver, connDatabricksBtn, 5);

					validateInputFields(driver, DatabricksInputFields, 1);

					validateTextFields(driver, connCustomJDBCTextbox, 1);

					wizardmsg = "Wizard not supported connector";

					break;
				}

			case "hive":
			case "impala":

				if (connParam.getAuthentication().equalsIgnoreCase("password")) {
					if ((connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE))) {

						validateButtons(driver, connDatabricksBtn, 5);

						validateInputFields(driver, DatabricksInputFields, 5);

						validateTextFields(driver, connCustomJDBCTextbox, 1);

						wizardmsg = "Wizard not supported connector";

						break;

					} else {

						validateButtons(driver, connDatabricksBtn, 5);

						validateInputFields(driver, DatabricksInputFields, 4);

						validateTextFields(driver, connCustomJDBCTextbox, 1);

						wizardmsg = "Wizard not supported connector";

						break;

					}

				} else {

					if ((connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE))) {

						// for both Kerberos and Kerberos Ticket Cache auth.

						validateButtons(driver, connDatabricksBtn, 5);

						validateInputFields(driver, DatabricksInputFields, 7);

						validateTextFields(driver, connCustomJDBCTextbox, 1);

						wizardmsg = "Wizard not supported connector";

						break;

					} else {

						if (connParam.getAuthentication().equalsIgnoreCase("kerberos")) {

							validateButtons(driver, connDatabricksBtn, 5);

							validateInputFields(driver, DatabricksInputFields, 6);

							validateTextFields(driver, connCustomJDBCTextbox, 1);

							wizardmsg = "Wizard not supported connector";

							break;

						} else {

							validateButtons(driver, connDatabricksBtn, 5);

							validateInputFields(driver, DatabricksInputFields, 5);

							validateTextFields(driver, connCustomJDBCTextbox, 1);

							wizardmsg = "Wizard not supported connector";

							break;

						}
					}

				}

			case "athena":

				validateButtons(driver, connDatabricksBtn, 5);

				validateInputFields(driver, DatabricksInputFields, 3);

				validateTextFields(driver, connCustomJDBCTextbox, 1);

				wizardmsg = "Wizard not supported connector";

				break;

			case "salesforce":

				validateButtons(driver, connDatabricksBtn, 5);

				validateInputFields(driver, DatabricksInputFields, 3);

				wizardmsg = "Wizard not supported connector";

				break;

			case "google-bigquery":

				validateButtons(driver, connDatabricksBtn, 5);

				validateInputFields(driver, DatabricksInputFields, 2);

				wizardmsg = "Wizard not supported connector";

				break;

			default:
			}

			return wizardmsg;

		} catch (Exception e) {
			BaseSuite.reportErrorLog("Exception found :  " + e.getMessage());
			throw new NoSuchElementException();
		}
	}

	/** create database connection method **/
	/** testScenario = "Valid/Invalid" , ValidationMessage blank for valid name **/
	public boolean createDatabaseConnection(String connJsonEntity, String testScenario, String validationMessage,
			String icedqUser) {
		boolean flag = true;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		String newconnectionName = null;
		LoginPage lp = new LoginPage(driver);
		String KerberosConfigLocation = System.getProperty("user.dir") + Constant.KERBEROS_CONFIG_LOCATION;
		String UserKeytabLocation = System.getProperty("user.dir") + Constant.USER_KEYTAB_LOCATION;
		try {
			if (isDisplayed(driver, userName) && isDisplayed(driver, passWord)) {

				flag = lp.loginWithIcedqUserAndSelectWorkspace(icedqUser, ConstantProperty.TARGET_WORKSPACE_NAME,
						ConstantProperty.CONNECTIONREPOMODULENAME, "");

			}
			if (flag) {

				ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

				newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
						+ ConstantProperty.TARGET_WORKSPACE_NAME;

				String authName = setAuthenticationType(connParam.getAuthentication());

				String connusername = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				flag = clickOnNewConnectionBtn(icedqUser);

				if (flag) {

					chooseConnectorType(connParam.getConnectorID());

					inVisible(driver, spinner, Constant.ruleWait);

					String wizardStatus = validateNewConnPageButtonsFields(connParam.getConnectorID());

					if (wizardStatus.contains("Wizard supported connector")) {

						verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", false);
					}

					verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

					verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);

					verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

					verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", false);

					verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", false);

					enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

					selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

					selectAuthenticationOfConnection(authName);

					boolean cs = selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

					enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());

					if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS))

					{
						WebElement m = driver.findElement(By.xpath("//input[@id='krbFile']"));

						m.sendKeys(KerberosConfigLocation);

						BaseSuite.validationReportLog("Krb5 File Choosed successfully");

						driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
					}

					if (cs) {

						driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

						validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
								connHostPlaceholder, false);
						validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
								connPortPlaceholder, false);
						validateInputFieldVisibility(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
								connDatabasePlaceHolder, false);

					} else {
						validatAndeEnterValueToTextField(connHostTitle, connHostInputField,
								ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder, connParam.getHost(),
								validationHostEmpty);

						validatAndeEnterValueToTextField(connPortTitle, connPortInputField,
								ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder, connParam.getPort(),
								validationPortEmpty);

						validatAndeEnterValueToTextField(connDatabaseTitle, connDatabaseInputField,
								ConstantProperty.CONN_FIELD_DATABASE, connDatabasePlaceHolder,
								connParam.getDatabaseName(), validationDatabaseEmpty);
					}

					// driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					selectConnectionType(chooseConnType, connParam.getType());

					// selectConnectionType(connParam.getType());

					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

							WebElement m = driver.findElement(By.xpath("//input[@id='keytab']"));

							m.sendKeys(UserKeytabLocation);

							BaseSuite.validationReportLog("User key tab File Choosed successfully");

							validatAndeEnterValueToTextField(connUserPrincipalLabel, connHiveUserPrincipal,
									ConstantProperty.CONN_FIELD_USERPRINCIPAL, connPrincipalPlaceholder,
									connParam.getUserPrincipal(), validationUserprincipal);

						} else {

							entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);

							enterUsername(connusername);

						}

					} else {

						if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

							validateInputFieldVisibility(connHiveUserPrincipal, ConstantProperty.CONN_USERPRINCIPAL, "",
									false);

							isEnabled(driver, connUserKeytab);

							BaseSuite.validationReportLog("User key tab Field is Disabled");

							isEnabled(driver, chooseFileBtn);

							BaseSuite.validationReportLog("Choose File button is Disabled");

						} else {

							validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "",
									false);

							validateInputFieldVisibility(connsecretUserPassword, ConstantProperty.CONN_FIELD_PASSWORD,
									"", false);
						}
					}

					ArrayList<String> connPropertyList = TestDataThroughApi
							.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

					int count = connPropertyList.size();

					addConnectionPropertiesToConnection(connJsonEntity, count);

					// clickOnOverviewTab();

					if (icedqUser.toLowerCase().contains("owner")) {

						flag = saveConnection(connectionSaveMesssage);

						clickOnConnectionsTab();

						cp.searchConnection(newconnectionName);

						getConnection(newconnectionName, update_actualValue);

						searchAndClickOnConnectionNameInConnRepo(newconnectionName);

						if (flag || (isEnabled(driver, connDeleteButton) && isEnabled(driver, connDuplicateButton))) {

							flag = enterUsernameAndPasswordForUserConnection(connJsonEntity, connParam,
									connParam.getType(), newconnectionName, connusername, icedqUser);
						}
					} else {

						flag = saveConnection(forbiddenToastMsg);
					}
				}
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" Database connection not created properly kindly check :" + e.toString());
		}
		return flag;
	}

	public boolean enterUsernameAndPasswordForUserConnection(String connJsonEntity, ConnectionPoJO connParam,
			String connectionType, String connectionName, String connusername, String icedqUser) {
		boolean flag = true;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		String UserKeytabLocation = System.getProperty("user.dir") + Constant.USER_KEYTAB_LOCATION;
		try {
			if (!icedqUser.toLowerCase().contains("reader")) {

				if (connectionType.trim().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

					waitForExecution(1000);

					cp.clickOnUserConnectionTab();

					waitForExecution(2000);

					cp.searchAndClickOnConnectionNameInConnRepo(connectionName);

					inVisible(driver, spinner, Constant.ruleWait);

					if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS))

					{

						WebElement m = driver.findElement(By.xpath("//input[@id='keytab']"));

						m.sendKeys(UserKeytabLocation);

						BaseSuite.validationReportLog("User key tab File Choosed successfully");

						validatAndeEnterValueToTextField(connUserPrincipalLabel, connHiveUserPrincipal,
								ConstantProperty.CONN_FIELD_USERPRINCIPAL, connPrincipalPlaceholder,
								connParam.getUserPrincipal(), validationUserprincipal);

					} else {

						cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
								connParam.getConnectorID(), icedqUser);

						cp.enterUsername(connusername);

					}

					flag = saveConnection();

					cp.clickOnUserConnectionTab();

					waitForExecution(2000);

					cp.searchConnection(connectionName);

					cp.getConnection(connectionName, update_actualValue);

					cp.searchAndClickOnConnectionNameInConnRepo(connectionName);

					inVisible(driver, spinner, Constant.ruleWait);

					flag = testConnection(connectionTestMess);

					clickOnUserConnectionTab();

					waitForExecution(1000);

					cp.searchConnection(connectionName);

					cp.getConnection(connectionName, create_actualValue);

					cp.searchAndClickOnConnectionNameInConnRepo(connectionName);

				} else {
					waitForExecution(1000);

					flag = testConnection(connectionTestMess);

					clickOnConnectionsTab();

					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}

					cp.searchConnection(connectionName);

					getConnection(connectionName, create_actualValue);

					searchAndClickOnConnectionNameInConnRepo(connectionName);

					// changeConnType(connectionType,connJsonEntity,icedqUser,connectionName);

				}
			} else {
				waitForExecution(1000);

				cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(), connParam.getConnectorID(),
						icedqUser);

				cp.enterUsername(connusername);
				inVisible(driver, spinner, Constant.ruleWait);
				flag = cp.saveConnection(forbiddenToastMsg);
				inVisible(driver, spinner, Constant.ruleWait);
			}
		} catch (Exception e) {

			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("user connection not updated properly kindly check :" + e.toString());
		}

		return flag;
	}

	public boolean createDatabaseConnectionForVault(String connJsonEntity, String testScenario,
			String validationMessage, String icedqUser) {
		boolean flag = true;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		String newconnectionName = null;
		LoginPage lp = new LoginPage(driver);
		try {
			if (isDisplayed(driver, userName) && isDisplayed(driver, passWord)) {

				flag = lp.loginWithIcedqUserAndSelectWorkspace(icedqUser, ConstantProperty.TARGET_WORKSPACE_NAME,
						ConstantProperty.CONNECTIONREPOMODULENAME, "");

			}
			if (flag) {

				ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

				// String timestamp = new
				// SimpleDateFormat(ConstantProperty.CONNECTIONNAME_TIMESTAMPFORMAT).format(new
				// Date());

				newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
						+ ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER + ConstantProperty.SIGN_UNDERSCORE + "vault";

				String connusername = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

				String connpassword = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 2);

				String connprincipal = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 21);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				flag = clickOnNewConnectionBtn(icedqUser);

				if (flag) {

					chooseConnectorType(connParam.getConnectorID());

					inVisible(driver, spinner, Constant.ruleWait);

					// driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

					selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					boolean cs = selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

					enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());

					if (cs) {

						validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
								connHostPlaceholder, false);
						validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
								connPortPlaceholder, false);
						validateInputFieldVisibility(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
								connDatabasePlaceHolder, false);

					} else {
						validatAndeEnterValueToTextField(connHostTitle, connHostInputField,
								ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder, connParam.getHost(),
								validationHostEmpty);

						validatAndeEnterValueToTextField(connPortTitle, connPortInputField,
								ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder, connParam.getPort(),
								validationPortEmpty);

						validatAndeEnterValueToTextField(connDatabaseTitle, connDatabaseInputField,
								ConstantProperty.CONN_FIELD_DATABASE, connDatabasePlaceHolder,
								connParam.getDatabaseName(), validationDatabaseEmpty);
					}
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					selectConnectionType(chooseConnType, connParam.getType());

					// selectConnectionType(connParam.getType());

					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

							enterPrincipal(connprincipal);

						} else {
							// boolean ev = selectEnableVaultOfConnection(connParam.getVaultstatus());

							entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);

							// enterSecretName(connParam.getSecretName());

							enterUsername(connusername);

							// enterSecretPassword(connParam.getSecretPassword());

							// enterPassword(connpassword);

						}

					} else {
						if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

							validateInputFieldVisibility(connPrincipalInput, ConstantProperty.CONN_FIELD_PRINCIPAL,
									connPrincipalPlaceholder, false);

						} else {

							validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "",
									false);

							validateInputFieldVisibility(connsecretUserPassword, ConstantProperty.CONN_FIELD_PASSWORD,
									"", false);
						}
					}

					ArrayList<String> connPropertyList = TestDataThroughApi
							.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

					int count = connPropertyList.size();

					addConnectionPropertiesToConnection(connJsonEntity, count);

					clickOnOverviewTab();

					if (icedqUser.toLowerCase().contains("owner")) {

						flag = saveConnection(connectionSaveMesssage);

						if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)
								&& connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE))

						{
							WebElement m = driver.findElement(By.xpath("//input[@id='krbFile']"));

							m.sendKeys("D:\\Nexg-ICEDQ-Automation\\ng-icedq-automation\\kerberos files\\krb5.conf");

							BaseSuite.validationReportLog("Krb5 File Choosed successfully");

							saveConnection(connSaveMsgFileUpload);
						}

						clickOnConnectionsTab();

						isDisplayedInLoop(driver, 0, discardButtons);
						if (isDisplayed(driver, discardButtons)) {
							displayAndClick(driver, discardButtons);
						}

						cp.searchConnection(newconnectionName);

						getConnection(newconnectionName, update_actualValue);

						searchAndClickOnConnectionNameInConnRepo(newconnectionName);

						if (flag) {

							flag = updateUsernameAndPasswordForUserConnection(connJsonEntity, connParam,
									connParam.getType(), connusername, icedqUser);
						}
					} else {

						flag = saveConnection(forbiddenToastMsg);
					}
				}
			}
		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" Database connection not created properly kindly check :" + e.toString());
		}
		return flag;
	}

	public void entersecretPassword(String connJsonEntity, String authentication, String connectorId, String icedqUser)
			throws NoSuchElementException {

		String connectorName = null;
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			String locationName =setLocationType(connParam.getServiceProviderName());

			switch (connectorId.toLowerCase()) {
			
			case "flat-file":
				connectorName = "Flat File";
				
				
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {
					
					if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3) && connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

						enterSecretName("passForAllDatabaseConn");

						selectAccessKey("FlatFile-AccessKey");
						selectSecretKey("FlatFile-SecretKey");
					} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
						if (connParam.getAuthentication().toLowerCase().contains("azure-access-key")) {
							
							enterSecretName("passForAllDatabaseConn");
							selectAccessKey("FlatFile-Azure-AccessKey");
						} else {
							enterSecretName("passForAllDatabaseConn");
							selectSecuritytoken("FlatFile-Securitytoken");

						}
					}
				} else {
					switch (icedqUser) {

					case "account_owner":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("PassForAllDatabaseUserConn");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
							
						} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							if (connParam.getAuthenticationname().toLowerCase().contains("azure-access-key") 
								||connParam.getAuthenticationname().toLowerCase().contains("azure access key")) {
								
								enterSecretName("PassForAllDatabaseUserConn");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("PassForAllDatabaseUserConn");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;

					case "account_contributor":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("UserSecretsOfAllConnectors");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
							
						} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {
								
								enterSecretName("UserSecretsOfAllConnectors");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("UserSecretsOfAllConnectors");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;

					case "account_executor":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("UserSecretNameForAllConnectors");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
						} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {
								
								enterSecretName("UserSecretNameForAllConnectors");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("UserSecretNameForAllConnectors");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;

					case "workspace_owner":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("WorkspaceOwnerUserSecret");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
							
						} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {
								
								enterSecretName("WorkspaceOwnerUserSecret");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("WorkspaceOwnerUserSecret");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;

					case "workspace_contributor":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("WorkspaceContributorUserSecretPassword");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
						} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {
								
								enterSecretName("WorkspaceContributorUserSecretPassword");
								selectAccessKey("FlatFile-Azure-AccessKey");
								
							} else {
								enterSecretName("WorkspaceContributorUserSecretPassword");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;

					case "workspace_executor":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("WorkspaceExecutorUserSecretPassword");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
						} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {
								
								enterSecretName("WorkspaceExecutorUserSecretPassword");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("WorkspaceExecutorUserSecretPassword");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;
					default:
						break;
					}

				}
				break;

			case "snowflake":
				connectorName = "Snowflake";

				if (setAuthenticationType(authentication).equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {
					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						enterSecretName("passForAllDatabaseConn");

						selectVaultPassword("Snowflake-Auth-userPas", ConstantProperty.CONN_FIELD_PASSWORD);
					} else {

						switch (icedqUser) {

						case "account_owner":
							enterSecretName("PassForAllDatabaseUserConn");

							selectVaultPassword("Snowflake-user_pass", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "account_contributor":
							enterSecretName("UserSecretsOfAllConnectors");

							selectVaultPassword("Snowflake-user_pass", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "account_executor":
							enterSecretName("UserSecretNameForAllConnectors");

							selectVaultPassword("Snowflake-user_pass", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "workspace_owner":
							enterSecretName("WorkspaceOwnerUserSecret");

							selectVaultPassword("Snowflake-user_pass", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "workspace_contributor":
							enterSecretName("WorkspaceContributorUserSecretPassword");

							selectVaultPassword("Snowflake-user_pass", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "workspace_executor":
							enterSecretName("WorkspaceExecutorUserSecretPassword");

							selectVaultPassword("Snowflake-user_pass", ConstantProperty.CONN_FIELD_PASSWORD);
							break;
						default:
							break;
						}
					}

				} else if (setAuthenticationType(authentication).equalsIgnoreCase(ConstantProperty.AUTH_KEYPAIR)) {
					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						enterSecretName("passForAllDatabaseConn");

						selectVaultKeyFileContent("Snowflake-Auth-KeyPair-KeyFileContent");
						selectVaultPassword("Snowflake-Auth-KeyPair-KeyFilePassword",
								ConstantProperty.CONN_FEILD_KEYFILEPASSWORD);
					} else {

						switch (icedqUser) {

						case "account_owner":
							enterSecretName("PassForAllDatabaseUserConn");

							selectVaultKeyFileContent("snowflake-KeyPair-FileContent");
							selectVaultPassword("snowflake-KeyPair-FilePassword",
									ConstantProperty.CONN_FEILD_KEYFILEPASSWORD);
							break;

						case "account_contributor":
							enterSecretName("UserSecretsOfAllConnectors");

							selectVaultKeyFileContent("snowflake-KeyPair-FileContent");
							selectVaultPassword("snowflake-KeyPair-FilePassword",
									ConstantProperty.CONN_FEILD_KEYFILEPASSWORD);
							break;

						case "account_executor":
							enterSecretName("UserSecretNameForAllConnectors");

							selectVaultKeyFileContent("snowflake-KeyPair-FileContent");
							selectVaultPassword("snowflake-KeyPair-FilePassword",
									ConstantProperty.CONN_FEILD_KEYFILEPASSWORD);
							break;

						case "workspace_owner":
							enterSecretName("WorkspaceOwnerUserSecret");

							selectVaultKeyFileContent("snowflake-KeyPair-FileContent");
							selectVaultPassword("snowflake-KeyPair-FilePassword",
									ConstantProperty.CONN_FEILD_KEYFILEPASSWORD);
							break;

						case "workspace_contributor":
							enterSecretName("WorkspaceContributorUserSecretPassword");

							selectVaultKeyFileContent("snowflake-KeyPair-FileContent");
							selectVaultPassword("snowflake-KeyPair-FilePassword",
									ConstantProperty.CONN_FEILD_KEYFILEPASSWORD);
							break;

						case "workspace_executor":
							enterSecretName("WorkspaceExecutorUserSecretPassword");

							selectVaultKeyFileContent("snowflake-KeyPair-FileContent");
							selectVaultPassword("snowflake-KeyPair-FilePassword",
									ConstantProperty.CONN_FEILD_KEYFILEPASSWORD);
							break;
						default:
							break;
						}
					}
				}

				break;

			case "redshift":
				connectorName = "Redshift";

				if (authentication.equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {
					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						enterSecretName("passForAllDatabaseConn");

						selectVaultPassword("Redshift", ConstantProperty.CONN_FIELD_PASSWORD);
					} else {
						switch (icedqUser) {

						case "account_owner":
							enterSecretName("PassForAllDatabaseUserConn");

							selectVaultPassword("Redshift", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "account_contributor":
							enterSecretName("UserSecretsOfAllConnectors");

							selectVaultPassword("Redshift", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "account_executor":
							enterSecretName("UserSecretNameForAllConnectors");

							selectVaultPassword("Redshift", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "workspace_owner":
							enterSecretName("WorkspaceOwnerUserSecret");

							selectVaultPassword("Redshift", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "workspace_contributor":
							enterSecretName("WorkspaceContributorUserSecretPassword");

							selectVaultPassword("Redshift", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "workspace_executor":
							enterSecretName("WorkspaceExecutorUserSecretPassword");

							selectVaultPassword("Redshift", ConstantProperty.CONN_FIELD_PASSWORD);
							break;
						default:
							break;
						}
					}
				}
				break;
			case "google-bigquery":
				connectorName = "Google BigQuery";
				enterSecretName("GoogleBigQuery");

				break;

			case "hive":
				connectorName = "Hive";
				if (authentication.equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {
					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						enterSecretName("passForAllDatabaseConn");

						selectVaultPassword("HivePasssword", ConstantProperty.CONN_FIELD_PASSWORD);
					} else {

						switch (icedqUser) {

						case "account_owner":
							enterSecretName("PassForAllDatabaseUserConn");

							selectVaultPassword("HivePasssword", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "account_contributor":
							enterSecretName("UserSecretsOfAllConnectors");

							selectVaultPassword("HivePasssword", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "account_executor":
							enterSecretName("UserSecretNameForAllConnectors");

							selectVaultPassword("HivePasssword", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "workspace_owner":
							enterSecretName("WorkspaceOwnerUserSecret");

							selectVaultPassword("HivePasssword", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "workspace_contributor":
							enterSecretName("WorkspaceContributorUserSecretPassword");

							selectVaultPassword("HivePasssword", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "workspace_executor":
							enterSecretName("WorkspaceExecutorUserSecretPassword");

							selectVaultPassword("HivePasssword", ConstantProperty.CONN_FIELD_PASSWORD);
							break;
						default:
							break;
						}
					}

				}
				break;

			case "denodo":
				connectorName = "Denodo";
				if (authentication.equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {
					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						enterSecretName("passForAllDatabaseConn");

						selectVaultPassword("Denodo", ConstantProperty.CONN_FIELD_PASSWORD);
					} else {
						switch (icedqUser) {

						case "account_owner":
							enterSecretName("PassForAllDatabaseUserConn");

							selectVaultPassword("Denodo", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "account_contributor":
							enterSecretName("UserSecretsOfAllConnectors");

							selectVaultPassword("Denodo", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "account_executor":
							enterSecretName("UserSecretNameForAllConnectors");

							selectVaultPassword("Denodo", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "workspace_owner":
							enterSecretName("WorkspaceOwnerUserSecret");

							selectVaultPassword("Denodo", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "workspace_contributor":
							enterSecretName("WorkspaceContributorUserSecretPassword");

							selectVaultPassword("Denodo", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "workspace_executor":
							enterSecretName("WorkspaceExecutorUserSecretPassword");

							selectVaultPassword("Denodo", ConstantProperty.CONN_FIELD_PASSWORD);
							break;
						default:
							break;
						}
					}
				}
				break;

			case "postgresql":
				connectorName = "PostgreSQL";

				if (authentication.equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {

					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						enterSecretName("passForAllDatabaseConn");

						selectVaultPassword("PostgreSQL", ConstantProperty.CONN_FIELD_PASSWORD);
					} else {
						switch (icedqUser) {

						case "account_owner":
							enterSecretName("PassForAllDatabaseUserConn");

							selectVaultPassword("PostgreSQL", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "account_contributor":
							enterSecretName("UserSecretsOfAllConnectors");

							selectVaultPassword("PostgreSQL", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "account_executor":
							enterSecretName("UserSecretNameForAllConnectors");

							selectVaultPassword("PostgreSQL", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "workspace_owner":
							enterSecretName("WorkspaceOwnerUserSecret");

							selectVaultPassword("PostgreSQL", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "workspace_contributor":
							enterSecretName("WorkspaceContributorUserSecretPassword");

							selectVaultPassword("PostgreSQL", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "workspace_executor":
							enterSecretName("WorkspaceExecutorUserSecretPassword");

							selectVaultPassword("PostgreSQL", ConstantProperty.CONN_FIELD_PASSWORD);
							break;
						default:
							break;
						}
					}
				}
				break;

			case "xml":
				connectorName = "XML";
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {
					if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
							&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

						
						enterSecretName("passForAllDatabaseConn");

						selectAccessKey("FlatFile-AccessKey");
						selectSecretKey("FlatFile-SecretKey");
						
					} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
						if (connParam.getAuthentication().toLowerCase().contains("azure-access-key")) {
							
							enterSecretName("passForAllDatabaseConn");
							selectAccessKey("FlatFile-Azure-AccessKey");
						} else {
							enterSecretName("passForAllDatabaseConn");
							selectSecuritytoken("FlatFile-Securitytoken");

						}
					}
				} else {
					switch (icedqUser) {

					case "account_owner":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("PassForAllDatabaseUserConn");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
							
						} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							
							if (connParam.getAuthentication().toLowerCase().contains("azure-access-key")) {
								
								enterSecretName("PassForAllDatabaseUserConn");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("PassForAllDatabaseUserConn");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;

					case "account_contributor":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("UserSecretsOfAllConnectors");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
						} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							
							if (connParam.getAuthentication().toLowerCase().contains("azure-access-key")) {
								
								enterSecretName("UserSecretsOfAllConnectors");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("UserSecretsOfAllConnectors");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;

					case "account_executor":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("UserSecretNameForAllConnectors");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
						} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							
							
							if (connParam.getAuthentication().toLowerCase().contains("azure-access-key")) {
								
								enterSecretName("UserSecretNameForAllConnectors");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("UserSecretNameForAllConnectors");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;

					case "workspace_owner":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("WorkspaceOwnerUserSecret");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
						} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							
							if (connParam.getAuthentication().toLowerCase().contains("azure-access-key")) {
								
								enterSecretName("WorkspaceOwnerUserSecret");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("WorkspaceOwnerUserSecret");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;

					case "workspace_contributor":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("WorkspaceContributorUserSecretPassword");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
						} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							
							if (connParam.getAuthentication().toLowerCase().contains("azure-access-key")) {
								
								enterSecretName("WorkspaceContributorUserSecretPassword");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("WorkspaceContributorUserSecretPassword");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;

					case "workspace_executor":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthentication().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("WorkspaceExecutorUserSecretPassword");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
						} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							
							if (connParam.getAuthentication().toLowerCase().contains("azure-access-key")) {
								
								enterSecretName("WorkspaceExecutorUserSecretPassword");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("WorkspaceExecutorUserSecretPassword");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;
					default:
						break;
					}

				}
				break;

			case "oracle":
				connectorName = "Oracle";
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {
					if (authentication.equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {

						enterSecretName("passForAllDatabaseConn");

						selectVaultPassword("Oracle-UserPas", ConstantProperty.CONN_FIELD_PASSWORD);
					} else if (authentication.equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

						enterSecretName("passForAllDatabaseConn");
						selectUserPrincipal("Oracle-kerberos-principal", ConstantProperty.CONN_FIELD_USERPRINCIPAL);
					}
				} else {
					switch (icedqUser) {

					case "account_owner":
						if (authentication.equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {

							enterSecretName("PassForAllDatabaseUserConn");

							selectVaultPassword("Oracle-user-pass", ConstantProperty.CONN_FIELD_PASSWORD);
						} else if (authentication.equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

							enterSecretName("passForAllDatabaseConn");
							selectUserPrincipal("Oracle-kerberos-principal", ConstantProperty.CONN_FIELD_USERPRINCIPAL);
						}

						break;

					case "account_contributor":
						if (authentication.equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {
							enterSecretName("UserSecretsOfAllConnectors");

							selectVaultPassword("Oracle-user-pass", ConstantProperty.CONN_FIELD_PASSWORD);
						} else if (authentication.equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

							enterSecretName("passForAllDatabaseConn");
							selectUserPrincipal("Oracle-kerberos-principal", ConstantProperty.CONN_FIELD_USERPRINCIPAL);
						}
						break;

					case "account_executor":
						if (authentication.equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {
							enterSecretName("UserSecretNameForAllConnectors");

							selectVaultPassword("Oracle-user-pass", ConstantProperty.CONN_FIELD_PASSWORD);
						} else if (authentication.equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

							enterSecretName("passForAllDatabaseConn");
							selectUserPrincipal("Oracle-kerberos-principal", ConstantProperty.CONN_FIELD_USERPRINCIPAL);
						}
						break;

					case "workspace_owner":
						if (authentication.equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {
							enterSecretName("WorkspaceOwnerUserSecret");

							selectVaultPassword("Oracle-UserPas", ConstantProperty.CONN_FIELD_PASSWORD);
						} else if (authentication.equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

							enterSecretName("passForAllDatabaseConn");
							selectUserPrincipal("Oracle-kerberos-principal", ConstantProperty.CONN_FIELD_USERPRINCIPAL);
						}
						break;

					case "workspace_contributor":
						if (authentication.equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {
							enterSecretName("WorkspaceContributorUserSecretPassword");

							selectVaultPassword("Oracle-UserPas", ConstantProperty.CONN_FIELD_PASSWORD);
						} else if (authentication.equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

							enterSecretName("passForAllDatabaseConn");
							selectUserPrincipal("Oracle-kerberos-principal", ConstantProperty.CONN_FIELD_USERPRINCIPAL);
						}
						break;

					case "workspace_executor":
						if (authentication.equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {
							enterSecretName("WorkspaceExecutorUserSecretPassword");

							selectVaultPassword("Oracle-UserPas", ConstantProperty.CONN_FIELD_PASSWORD);
						} else if (authentication.equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

							enterSecretName("passForAllDatabaseConn");
							selectUserPrincipal("Oracle-kerberos-principal", ConstantProperty.CONN_FIELD_USERPRINCIPAL);
						}
						break;
					default:
						break;
					}
				}

				break;

			case "mysql":
				connectorName = "MySQL"; {
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					enterSecretName("passForAllDatabaseConn");

					selectVaultPassword("MySQL", ConstantProperty.CONN_FIELD_PASSWORD);
				} else {
					switch (icedqUser) {

					case "account_owner":
						enterSecretName("PassForAllDatabaseUserConn");

						selectVaultPassword("MySQL", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "account_contributor":
						enterSecretName("UserSecretsOfAllConnectors");

						selectVaultPassword("MySQL", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "account_executor":
						enterSecretName("UserSecretNameForAllConnectors");

						selectVaultPassword("MySQL", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "workspace_owner":
						enterSecretName("WorkspaceOwnerUserSecret");

						selectVaultPassword("MySQL", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "workspace_contributor":
						enterSecretName("WorkspaceContributorUserSecretPassword");

						selectVaultPassword("MySQL", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "workspace_executor":
						enterSecretName("WorkspaceExecutorUserSecretPassword");

						selectVaultPassword("MySQL", ConstantProperty.CONN_FIELD_PASSWORD);
						break;
					default:
						break;
					}
				}
			}
				break;

			case "db2":
				connectorName = "DB2"; {
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					enterSecretName("passForAllDatabaseConn");

					selectVaultPassword("DB2", ConstantProperty.CONN_FIELD_PASSWORD);
				} else {

					switch (icedqUser) {

					case "account_owner":
						enterSecretName("PassForAllDatabaseUserConn");

						selectVaultPassword("DB2", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "account_contributor":
						enterSecretName("UserSecretsOfAllConnectors");

						selectVaultPassword("DB2", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "account_executor":
						enterSecretName("UserSecretNameForAllConnectors");

						selectVaultPassword("DB2", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "workspace_owner":
						enterSecretName("WorkspaceOwnerUserSecret");

						selectVaultPassword("DB2", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "workspace_contributor":
						enterSecretName("WorkspaceContributorUserSecretPassword");

						selectVaultPassword("DB2", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "workspace_executor":
						enterSecretName("WorkspaceExecutorUserSecretPassword");

						selectVaultPassword("DB2", ConstantProperty.CONN_FIELD_PASSWORD);
						break;
					default:
						break;
					}

				}
			}
				break;

			case "sybase":
				connectorName = "Sybase"; {
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					enterSecretName("passForAllDatabaseConn");

					selectVaultPassword("SybaseBoth-ASE-IQ", ConstantProperty.CONN_FIELD_PASSWORD);
				} else {
					switch (icedqUser) {

					case "account_owner":
						enterSecretName("PassForAllDatabaseUserConn");

						selectVaultPassword("SybaseBoth-ASE-IQ", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "account_contributor":
						enterSecretName("UserSecretsOfAllConnectors");

						selectVaultPassword("SybaseBoth-ASE-IQ", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "account_executor":
						enterSecretName("UserSecretNameForAllConnectors");

						selectVaultPassword("SybaseBoth-ASE-IQ", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "workspace_owner":
						enterSecretName("WorkspaceOwnerUserSecret");

						selectVaultPassword("SybaseBoth-ASE-IQ", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "workspace_contributor":
						enterSecretName("WorkspaceContributorUserSecretPassword");

						selectVaultPassword("SybaseBoth-ASE-IQ", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "workspace_executor":
						enterSecretName("WorkspaceExecutorUserSecretPassword");

						selectVaultPassword("SybaseBoth-ASE-IQ", ConstantProperty.CONN_FIELD_PASSWORD);
						break;
					default:
						break;
					}
				}
			}
				break;

			case "teradata":
				connectorName = "Teradata";

			{
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					enterSecretName("passForAllDatabaseConn");

					selectVaultPassword("Teradata", ConstantProperty.CONN_FIELD_PASSWORD);
				} else {
					switch (icedqUser) {

					case "account_owner":
						enterSecretName("PassForAllDatabaseUserConn");

						selectVaultPassword("Teradata", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "account_contributor":
						enterSecretName("UserSecretsOfAllConnectors");

						selectVaultPassword("Teradata", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "account_executor":
						enterSecretName("UserSecretNameForAllConnectors");

						selectVaultPassword("Teradata", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "workspace_owner":
						enterSecretName("WorkspaceOwnerUserSecret");

						selectVaultPassword("Teradata", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "workspace_contributor":
						enterSecretName("WorkspaceContributorUserSecretPassword");

						selectVaultPassword("Teradata", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "workspace_executor":
						enterSecretName("WorkspaceExecutorUserSecretPassword");

						selectVaultPassword("Teradata", ConstantProperty.CONN_FIELD_PASSWORD);
						break;
					default:
						break;
					}
				}
			}
				break;
			case "greenplum":
				connectorName = "Greenplum"; {
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {
					waitForExecution(1000);
					enterSecretName("passForAllDatabaseConn");

					selectVaultPassword("Greenplum", ConstantProperty.CONN_FIELD_PASSWORD);
				} else {
					switch (icedqUser) {

					case "account_owner":
						enterSecretName("PassForAllDatabaseUserConn");

						selectVaultPassword("Greenplum", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "account_contributor":
						enterSecretName("UserSecretsOfAllConnectors");

						selectVaultPassword("Greenplum", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "account_executor":
						enterSecretName("UserSecretNameForAllConnectors");

						selectVaultPassword("Greenplum", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "workspace_owner":
						enterSecretName("WorkspaceOwnerUserSecret");

						selectVaultPassword("Greenplum", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "workspace_contributor":
						enterSecretName("WorkspaceContributorUserSecretPassword");

						selectVaultPassword("Greenplum", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "workspace_executor":
						enterSecretName("WorkspaceExecutorUserSecretPassword");

						selectVaultPassword("Greenplum", ConstantProperty.CONN_FIELD_PASSWORD);
						break;
					default:
						break;
					}
				}
			}
				break;

			case "sql-server":

				connectorName = "sql-server"; {
				if ((authentication.equalsIgnoreCase("Windows Authentication")
						&& (connParam.getDriverName().equalsIgnoreCase("sqlserver-native")))
						|| (authentication.equalsIgnoreCase("Windows Authentication")
								&& (connParam.getDriverName().equalsIgnoreCase("sqlserver-custom")))) {
					Thread.sleep(1000);
					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						enterSecretName("passForAllDatabaseConn");

						selectVaultPassword("SQL-native-windows", ConstantProperty.CONN_FIELD_PASSWORD);
					} else {

						switch (icedqUser) {

						case "account_owner":
							Thread.sleep(1000);
							enterSecretName("PassForAllDatabaseUserConn");

							selectVaultPassword("SQL-Native-Windows", ConstantProperty.CONN_FIELD_PASSWORD);

							break;
						case "account_contributor":
							enterSecretName("UserSecretsOfAllConnectors");

							selectVaultPassword("SQL-Native-Windows", ConstantProperty.CONN_FIELD_PASSWORD);
							break;
						case "account_executor":
							enterSecretName("UserSecretsOfAllConnectors");

							selectVaultPassword("SQL-Native-Windows", ConstantProperty.CONN_FIELD_PASSWORD);
							break;
						case "workspace_owner":
							enterSecretName("WorkspaceOwnerUserSecret");

							selectVaultPassword("SQL-native-windows", ConstantProperty.CONN_FIELD_PASSWORD);

							break;
						case "workspace_contributor":
							enterSecretName("WorkspaceContributorUserSecretPassword");

							selectVaultPassword("SQL-native-windows", ConstantProperty.CONN_FIELD_PASSWORD);
							break;
						case "workspace_executor":
							enterSecretName("WorkspaceExecutorUserSecretPassword");

							selectVaultPassword("SQL-native-windows", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						}
					}
				} else if ((authentication.equalsIgnoreCase("SQL Server Authentication")
						&& (connParam.getDriverName().equalsIgnoreCase("sqlserver-native")))
						|| (authentication.equalsIgnoreCase("SQL Server Authentication")
								&& (connParam.getDriverName().equalsIgnoreCase("sqlserver-custom")))) {

					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {
						Thread.sleep(1000);
						enterSecretName("passForAllDatabaseConn");

						selectVaultPassword("SQL-native-sqlServer", ConstantProperty.CONN_FIELD_PASSWORD);
					} else {

						switch (icedqUser) {

						case "account_owner":
							Thread.sleep(1000);
							enterSecretName("PassForAllDatabaseUserConn");

							selectVaultPassword("SQL-Native-SQLServer", ConstantProperty.CONN_FIELD_PASSWORD);
							break;
						case "account_contributor":
							enterSecretName("UserSecretsOfAllConnectors");

							selectVaultPassword("SQL-Native-SQLServer", ConstantProperty.CONN_FIELD_PASSWORD);
							break;
						case "account_executor":
							enterSecretName("UserSecretNameForAllConnectors");

							selectVaultPassword("SQL-Native-SQLServer", ConstantProperty.CONN_FIELD_PASSWORD);
							break;
						case "workspace_owner":
							enterSecretName("WorkspaceOwnerUserSecret");

							selectVaultPassword("SQL-native-sqlServer", ConstantProperty.CONN_FIELD_PASSWORD);
							break;
						case "workspace_contributor":
							enterSecretName("WorkspaceContributorUserSecretPassword");

							selectVaultPassword("SQL-native-sqlServer", ConstantProperty.CONN_FIELD_PASSWORD);
							break;
						case "workspace_executor":
							enterSecretName("WorkspaceExecutorUserSecretPassword");

							selectVaultPassword("SQL-native-sqlServer", ConstantProperty.CONN_FIELD_PASSWORD);
							break;
						default:
							break;
						}
					}

				}
			}
				break;

			case "salesforce":
				connectorName = "Salesforce"; {
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)
						|| connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

					enterSecretName("passForAllDatabaseConn");

					selectSecretId("salesforce");
				} else {
					switch (icedqUser) {

					case "account_owner":
						enterSecretName("PassForAllDatabaseUserConn");

						selectSecretId("salesforce");
						break;

					case "account_contributor":
						enterSecretName("UserSecretsOfAllConnectors");

						selectSecretId("salesforce");
						break;

					case "account_executor":
						enterSecretName("UserSecretNameForAllConnectors");

						selectSecretId("salesforce");
						break;

					case "workspace_owner":
						enterSecretName("WorkspaceOwnerUserSecret");

						selectSecretId("salesforce");
						break;

					case "workspace_contributor":
						enterSecretName("WorkspaceContributorUserSecretPassword");

						selectSecretId("salesforce");
						break;

					case "workspace_executor":
						enterSecretName("WorkspaceExecutorUserSecretPassword");

						selectSecretId("salesforce");
						break;
					default:
						break;
					}
				}
			}
				break;

			case "flat-file-sql":
				connectorName = "Flat File (SQL)";

				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {
					if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
							&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

						enterSecretName("passForAllDatabaseConn");

						selectAccessKey("FlatFile-AccessKey");
						selectSecretKey("FlatFile-SecretKey");
					} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
						if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {
							enterSecretName("passForAllDatabaseConn");
							selectAccessKey("FlatFile-Azure-AccessKey");
						} else {
							enterSecretName("passForAllDatabaseConn");
							selectSecuritytoken("FlatFile-Securitytoken");

						}
					}
				} else {
					switch (icedqUser) {

					case "account_owner":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("PassForAllDatabaseUserConn");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
						} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {
								enterSecretName("PassForAllDatabaseUserConn");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("PassForAllDatabaseUserConn");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;

					case "account_contributor":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("UserSecretsOfAllConnectors");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
						} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {
								enterSecretName("UserSecretsOfAllConnectors");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("UserSecretsOfAllConnectors");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;

					case "account_executor":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("UserSecretNameForAllConnectors");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
						} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {
								enterSecretName("UserSecretNameForAllConnectors");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("UserSecretNameForAllConnectors");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;

					case "workspace_owner":
						if (connParam.getServiceProviderName().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("WorkspaceOwnerUserSecret");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
						} else if (connParam.getServiceProviderName()
								.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {
								enterSecretName("WorkspaceOwnerUserSecret");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("WorkspaceOwnerUserSecret");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;

					case "workspace_contributor":
						if (connParam.getServiceProviderName().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("WorkspaceContributorUserSecretPassword");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
						} else if (connParam.getServiceProviderName()
								.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {
								enterSecretName("WorkspaceContributorUserSecretPassword");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("WorkspaceContributorUserSecretPassword");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;

					case "workspace_executor":
						if (connParam.getServiceProviderName().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("WorkspaceExecutorUserSecretPassword");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
						} else if (connParam.getServiceProviderName()
								.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {
								enterSecretName("WorkspaceExecutorUserSecretPassword");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("WorkspaceExecutorUserSecretPassword");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;
					default:
						break;
					}

				}
				break;

			case "json":
				connectorName = "JSON";

				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {
					if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
							&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

						enterSecretName("passForAllDatabaseConn");

						selectAccessKey("FlatFile-AccessKey");
						selectSecretKey("FlatFile-SecretKey");
					} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
						if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {
							enterSecretName("passForAllDatabaseConn");
							selectAccessKey("FlatFile-Azure-AccessKey");
						} else {
							enterSecretName("passForAllDatabaseConn");
							selectSecuritytoken("FlatFile-Securitytoken");

						}
					}
				} else {
					switch (icedqUser) {

					case "account_owner":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("PassForAllDatabaseUserConn");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
						} else if (locationName
								.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {
								enterSecretName("PassForAllDatabaseUserConn");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("PassForAllDatabaseUserConn");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;

					case "account_contributor":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("UserSecretsOfAllConnectors");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
						} else if (locationName
								.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {
								enterSecretName("UserSecretsOfAllConnectors");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("UserSecretsOfAllConnectors");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;

					case "account_executor":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("UserSecretNameForAllConnectors");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
						} else if (locationName
								.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {
								enterSecretName("UserSecretNameForAllConnectors");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("UserSecretNameForAllConnectors");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;

					case "workspace_owner":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("WorkspaceOwnerUserSecret");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
						} else if (locationName
								.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {
								enterSecretName("WorkspaceOwnerUserSecret");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("WorkspaceOwnerUserSecret");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;

					case "workspace_contributor":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("WorkspaceContributorUserSecretPassword");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
						} else if (locationName
								.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {
								enterSecretName("WorkspaceContributorUserSecretPassword");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("WorkspaceContributorUserSecretPassword");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;

					case "workspace_executor":
						if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("WorkspaceExecutorUserSecretPassword");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");
						} else if (locationName
								.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
							if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {
								enterSecretName("WorkspaceExecutorUserSecretPassword");
								selectAccessKey("FlatFile-Azure-AccessKey");
							} else {
								enterSecretName("WorkspaceExecutorUserSecretPassword");
								selectSecuritytoken("FlatFile-Securitytoken");

							}
						}
						break;
					default:
						break;
					}

				}
				break;

			case "mariadb":
				connectorName = "MariaDB"; {
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					enterSecretName("passForAllDatabaseConn");

					selectVaultPassword("MariaDB", ConstantProperty.CONN_FIELD_PASSWORD);
				} else {
					switch (icedqUser) {

					case "account_owner":
						enterSecretName("PassForAllDatabaseUserConn");

						selectVaultPassword("MariaDB", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "account_contributor":
						enterSecretName("UserSecretsOfAllConnectors");

						selectVaultPassword("MariaDB", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "account_executor":
						enterSecretName("UserSecretNameForAllConnectors");

						selectVaultPassword("MariaDB", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "workspace_owner":
						enterSecretName("WorkspaceOwnerUserSecret");

						selectVaultPassword("MariaDB", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "workspace_contributor":
						enterSecretName("WorkspaceContributorUserSecretPassword");

						selectVaultPassword("MariaDB", ConstantProperty.CONN_FIELD_PASSWORD);
						break;

					case "workspace_executor":
						enterSecretName("WorkspaceExecutorUserSecretPassword");

						selectVaultPassword("MariaDB", ConstantProperty.CONN_FIELD_PASSWORD);
						break;
					default:
						break;
					}
					;
				}
			}
				break;

			default:
				break;
			case "databricks":
				connectorName = "Databricks"; {
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					enterSecretName("passForAllDatabaseConn");

					String CP = connParam.getcloudProvidername();

					if (CP.equalsIgnoreCase("Microsoft Azure")) {

						selectVaultPersonalAccessToken("Personal_Access_Token_Azure",
								ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN);

					} else {

						selectVaultPersonalAccessToken("Personal_Access_Token_AWS",
								ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN);
					}
				} else {
					switch (icedqUser) {

					case "account_owner":
						enterSecretName("PassForAllDatabaseUserConn");

						String CP = connParam.getcloudProvidername();

						if (CP.equalsIgnoreCase("Microsoft Azure")) {

							selectVaultPersonalAccessToken("Personal_Access_Token_Azure",
									ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN);

						} else {

							selectVaultPersonalAccessToken("Personal_Access_Token_AWS",
									ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN);
						}
						break;

					case "account_contributor":
						enterSecretName("UserSecretsOfAllConnectors");

						String CP1 = connParam.getcloudProvidername();

						if (CP1.equalsIgnoreCase("Microsoft Azure")) {

							selectVaultPersonalAccessToken("Personal_Access_Token_Azure",
									ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN);

						} else {

							selectVaultPersonalAccessToken("Personal_Access_Token_AWS",
									ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN);
						}
						break;

					case "account_executor":
						enterSecretName("UserSecretNameForAllConnectors");

						String CP2 = connParam.getcloudProvidername();

						if (CP2.equalsIgnoreCase("Microsoft Azure")) {

							selectVaultPersonalAccessToken("Personal_Access_Token_Azure",
									ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN);

						} else {

							selectVaultPersonalAccessToken("Personal_Access_Token_AWS",
									ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN);
						}

						break;

					case "workspace_owner":
						enterSecretName("WorkspaceOwnerUserSecret");

						String CP3 = connParam.getcloudProvidername();

						if (CP3.equalsIgnoreCase("Microsoft Azure")) {

							selectVaultPersonalAccessToken("Personal_Access_Token_Azure",
									ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN);

						} else {

							selectVaultPersonalAccessToken("Personal_Access_Token_AWS",
									ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN);
						}
						break;

					case "workspace_contributor":
						enterSecretName("WorkspaceContributorUserSecretPassword");

						String CP4 = connParam.getcloudProvidername();

						if (CP4.equalsIgnoreCase("Microsoft Azure")) {

							selectVaultPersonalAccessToken("Personal_Access_Token_Azure",
									ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN);

						} else {

							selectVaultPersonalAccessToken("Personal_Access_Token_AWS",
									ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN);
						}
						break;

					case "workspace_executor":
						enterSecretName("WorkspaceExecutorUserSecretPassword");

						String CP5 = connParam.getcloudProvidername();

						if (CP5.equalsIgnoreCase("Microsoft Azure")) {

							selectVaultPersonalAccessToken("Personal_Access_Token_Azure",
									ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN);

						} else {

							selectVaultPersonalAccessToken("Personal_Access_Token_AWS",
									ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN);
						}
						break;
					default:
						break;
					}
				}
			}

				break;

			case "impala":
				connectorName = "Impala";
				if (authentication.equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {
					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						enterSecretName("passForAllDatabaseConn");

						selectVaultPassword("Impala_userNamepass", ConstantProperty.CONN_FIELD_PASSWORD);
					} else {

						switch (icedqUser) {

						case "account_owner":
							enterSecretName("PassForAllDatabaseUserConn");

							selectVaultPassword("Impala_userNamepass", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "account_contributor":
							enterSecretName("UserSecretsOfAllConnectors");

							selectVaultPassword("Impala_userNamepass", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "account_executor":
							enterSecretName("UserSecretNameForAllConnectors");

							selectVaultPassword("Impala_userNamepass", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "workspace_owner":
							enterSecretName("WorkspaceOwnerUserSecret");

							selectVaultPassword("Impala_userNamepass", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "workspace_contributor":
							enterSecretName("WorkspaceContributorUserSecretPassword");

							selectVaultPassword("Impala_userNamepass", ConstantProperty.CONN_FIELD_PASSWORD);
							break;

						case "workspace_executor":
							enterSecretName("WorkspaceExecutorUserSecretPassword");

							selectVaultPassword("Impala_userNamepass", ConstantProperty.CONN_FIELD_PASSWORD);
							break;
						default:
							break;
						}

					}

				}
				break;

			case "parquet":
				connectorName = "Parquet"; {
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {
					if (connParam.getServiceProviderName().equalsIgnoreCase("aws-s3")
							&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

						enterSecretName("passForAllDatabaseConn");

						selectAccessKey("Parquet-AccessKey");
						selectSecretKey("Parquet-SecretKey");
					}

				} else {
					switch (icedqUser) {

					case "account_owner":
						if (connParam.getServiceProviderName().equalsIgnoreCase("aws-s3")
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							enterSecretName("PassForAllDatabaseUserConn");

							selectAccessKey("FlatFile-AccessKey");
							selectSecretKey("FlatFile-SecretKey");

						}

						break;
					default:
						break;
					}
				}
			}
				break;

			case "atscale":
				connectorName = "AtScale"; {
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					enterSecretName("passForAllDatabaseConn");

					selectVaultPassword("AtScale", ConstantProperty.CONN_FIELD_PASSWORD);
				} else {
					switch (icedqUser) {

					case "account_owner":

						enterSecretName("PassForAllDatabaseUserConn");

						selectVaultPassword("AtScale", ConstantProperty.CONN_FIELD_PASSWORD);

						break;
					default:
						break;
					}

				}
			}

				break;

			case "amazon-aurora-mysql":
				connectorName = "Amazon Aurora MySQL"; {
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					enterSecretName("passForAllDatabaseConn");

					selectVaultPassword("AAMySQL", ConstantProperty.CONN_FIELD_PASSWORD);
				} else {
					switch (icedqUser) {

					case "account_owner":

						enterSecretName("PassForAllDatabaseUserConn");

						selectVaultPassword("AAMySQL", ConstantProperty.CONN_FIELD_PASSWORD);

						break;
					default:
						break;
					}

				}
			}

				break;

			case "amazon-aurora-postgresql":
				connectorName = "Amazon Aurora PostgreSQL"; {
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					enterSecretName("passForAllDatabaseConn");

					selectVaultPassword("AmazonAuroraPostgreSQL", ConstantProperty.CONN_FIELD_PASSWORD);
				} else {
					switch (icedqUser) {

					case "account_owner":

						enterSecretName("PassForAllDatabaseUserConn");

						selectVaultPassword("AmazonAuroraPostgreSQL", ConstantProperty.CONN_FIELD_PASSWORD);

						break;
					default:
						break;
					}
				}
			}
				break;

			case "netezza":
				connectorName = "IBM Netezza"; {
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					enterSecretName("passForAllDatabaseConn");

					selectVaultPassword("IBM_Netezza", ConstantProperty.CONN_FIELD_PASSWORD);
				} else {
					switch (icedqUser) {

					case "account_owner":

						enterSecretName("PassForAllDatabaseUserConn");

						selectVaultPassword("IBM_Netezza", ConstantProperty.CONN_FIELD_PASSWORD);

						break;
					default:
						break;
					}
				}
			}
				break;

			case "sap-hana":
				connectorName = "SAP HANA"; {
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					enterSecretName("passForAllDatabaseConn");

					selectVaultPassword("SAP_HANA", ConstantProperty.CONN_FIELD_PASSWORD);
				} else {
					switch (icedqUser) {

					case "account_owner":

						enterSecretName("PassForAllDatabaseUserConn");

						selectVaultPassword("SAP_HANA", ConstantProperty.CONN_FIELD_PASSWORD);

						break;
					default:
						break;
					}
				}
			}
				break;

			case "vertica":
				connectorName = "Vertica"; {
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					enterSecretName("passForAllDatabaseConn");

					selectVaultPassword("Vertica", ConstantProperty.CONN_FIELD_PASSWORD);
				} else {
					switch (icedqUser) {

					case "account_owner":

						enterSecretName("PassForAllDatabaseUserConn");

						selectVaultPassword("Vertica", ConstantProperty.CONN_FIELD_PASSWORD);

						break;
					default:
						break;
					}
				}
			}
				break;

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Exception found :  " + e.getMessage());
			throw new NoSuchElementException();
		}
	}

	public boolean enterSecretNameAndPass(String icedqUser, String connName, String secretName) throws Exception {
		boolean flag = true;
		try {
			switch (icedqUser) {

			case "account_owner":

				secretName = "PassForAllDatabaseUserConn";
				break;

			case "account_contributor":
				secretName = "UserSecretsOfAllConnectors";

				break;

			case "account_executor":
				secretName = "UserSecretNameForAllConnectors";

				break;

			case "workspace_owner":
				secretName = "WorkspaceOwnerUserSecret";

				break;

			case "workspace_contributor":
				secretName = "WorkspaceContributorUserSecretPassword";

				break;

			case "workspace_executor":
				secretName = "WorkspaceExecutorUserSecretPassword";

				break;
			default:
				break;
			}

			enterSecretName(secretName);

			selectVaultPassword(connName, ConstantProperty.CONN_FIELD_PASSWORD);

		} catch (Exception e) {
			flag = false;
			e.getMessage();
			throw new NoSuchElementException(e.getMessage());

		}
		return flag;
	}

	public void secretUsesrSandox(String connJsonEntity, String connectorId, String icedqUser) {
		String connectorName = null;

		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);
			switch (connectorId.toLowerCase()) {

			case "salesforce":
				connectorName = "Salesforce"; {
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					enterSecretName("passForAllDatabaseConn");

					selectSecretId("salesforceNew");
				} else {
					switch (icedqUser) {

					case "account_owner":
						enterSecretName("PassForAllDatabaseUserConn");

						selectSecretId("salesforceSandbox");
						break;

					case "account_contributor":
						enterSecretName("UserSecretsOfAllConnectors");

						selectSecretId("salesforceNew");
						break;

					case "account_executor":
						enterSecretName("UserSecretNameForAllConnectors");

						selectSecretId("salesforceNew");
						break;

					case "workspace_owner":
						enterSecretName("WorkspaceOwnerUserSecret");

						selectSecretId("salesforceNew");
						break;

					case "workspace_contributor":
						enterSecretName("WorkspaceContributorUserSecretPassword");

						selectSecretId("salesforceNew");
						break;

					case "workspace_executor":
						enterSecretName("WorkspaceExecutorUserSecretPassword");

						selectSecretId("salesforceNew");
						break;
					default:
						break;
					}
				}
			}
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
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

	public boolean validateConnectionPropertyField(By locator, String expectedValue) {

		boolean flag = true;

		isDisplayedInLoop(driver, 4, locator);

		javascript(driver, scrollToElementArg, locator);

		if (isDisplayed(driver, locator)) {

			String actualValue = getAttribute(driver, locator, "innerHTML");

			BaseSuite.reportLog("Retrieved : " + actualValue);
			BaseSuite.reportLog("Expected : " + expectedValue);

			if (actualValue.equalsIgnoreCase(expectedValue)) {

				BaseSuite.validationReportLog("Expected value matched successfully");
			} else {
				BaseSuite.reportFailLog("Expected value not matched", actualValue);
			}

		} else {
			BaseSuite.reportFailLog("Element not visible kindly check", "validateConnectionPropertuField");

		}

		return flag;
	}

	/** view connection property common method **/
	public boolean viewAndValidateConnectionPropertiesToConnection(String jsonEntity, int count) throws Exception {
		boolean flag = true;
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

							validateDefaultConnectionProperty(name.get(j), value.get(j), type.get(j));

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

							validateDefaultConnectionProperty(name.get(j), value.get(j), type.get(j));

						} else {

							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, "$num",
									Integer.toString(a), dynamicName, name.get(j)), name.get(j));

							// validateConnectionPropertyField(returnElement(connConnectionPropCommonLocator,
							// dynamicName, name.get(j)), name.get(j));

							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, "$num",
									Integer.toString(a), dynamicName, value.get(j)), value.get(j));

							// validateConnectionPropertyField(returnElement(connConnectionPropCommonLocator,
							// dynamicName, value.get(j)), value.get(j));

							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, "$num",
									Integer.toString(a), dynamicName, type.get(j)), type.get(j));

							// validateConnectionPropertyField(returnElement(connConnectionPropCommonLocator,
							// dynamicName, type.get(j)), type.get(j));
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

	/** view connection property common method **/
	public boolean viewAndValidateConnectionPropertiesToConnectionForDatabricks(String jsonEntity, int count)
			throws Exception {
		boolean flag = true;
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

							validateDefaultConnectionProperty(name.get(j), value.get(j), type.get(j));

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

							validateDefaultConnectionProperty(name.get(j), value.get(j), type.get(j));

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

	/** View DataBase connection details method **/

	public boolean viewDatabaseConnection(String connJsonEntity, String driverName) {
		boolean flag = true;

		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				String wizardStatus = validateExistingConnPageButtonsFields(connJsonEntity);

				if (wizardStatus.contains("Wizard supported connector")) { // DAT-11547

					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", true);

					} else {

						verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", false);
					}
				}

				verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

				verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", true);

				verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

				verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", true);

				verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", true);

				driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

				inVisible(driver, spinner, Constant.ruleWait);

				viewAndValidateConnectionField(connName, "Connection Name ", connParam.getConnName(), true);

				viewAndValidateConnectionField(connFlatFileDriverField, "Driver ", driverName, true);

				viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
						connParam.getAuthenticationname(), true);

				verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

				if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS))

				{

					String krb5 = getAttribute(driver, connKrbFeild, valueAttribute).trim();

					BaseSuite.validationReportLog(krb5 + " File visible");

					isEnabled(driver, connKrbChoosefile);

					BaseSuite.validationReportLog("Choose File Button Enable on page.");

				}

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				if (connParam.getCustomJdbcFullUrl().equalsIgnoreCase(booleanTrue)) {

					viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
							connParam.getCustomJDBCURLValue(), true);

					viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST, "", false);

					viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT, "", false);

					viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE, "",
							false);

				} else {

					viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
							connParam.getCustomJDBCURLValue(), false);

					viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
							connParam.getHost(), true);

					viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
							connParam.getPort(), true);

					viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
							connParam.getDatabaseName(), true);
				}

				if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS))

				{

					viewAndValidateConnectionField(principalFeild, ConstantProperty.CONN_FIELD_PRINCIPAL,
							connParam.getUserPrincipal(), true);

					String keytab = getAttribute(driver, connKeytabFeild, valueAttribute).trim();

					BaseSuite.validationReportLog(keytab + " File visible");

					isEnabled(driver, connKeytabChoosefile);

					BaseSuite.validationReportLog("Choose File Button Enable on page.");

				}

				else {
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

				}

				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

				int count = connPropertyList.size();

				flag = viewAndValidateConnectionPropertiesToConnection(connJsonEntity, count);

			} else {

				inVisible(driver, spinner, Constant.ruleWait);

				validateButtons(driver, connDatabricksBtn, 3);

				verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

				String selectedSecret = getAttribute(driver, connsecretName, "value");

				if (selectedSecret.isEmpty()) {

					verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);

				} else {

					verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", true);

				}

				verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

				viewAndValidateConnectionField(connName, "Connection Name", connParam.getConnName(), false);

				viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, false);

				viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
						connParam.getAuthenticationname(), false);

				verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

				viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
						connParam.getCustomJDBCURLValue(), false);

				if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS))

				{

					String krb5 = getAttribute(driver, connKrbFeild, krb5value).trim();

					if (krb5.contains("true")) {
						BaseSuite.validationReportLog("Choose Krb5 File Feild is Disable");
					} else {
						BaseSuite.validationReportLog("Choose Krb5 File Feild is Enable");
					}

					// viewAndValidateConnectionField(connKrbFeild, "Krb", krb5, false);

					// String choose = getAttribute(driver,connKrbChoosefile,
					// attributeClassName).trim();

					String krb5chooseFile = getAttribute(driver, connKrbChoosefile, attributeClassName).trim();

					if (krb5chooseFile.contains("disabled")) {
						BaseSuite.validationReportLog("Krb5 Choose file Button is Disable");
					} else {
						BaseSuite.validationReportLog("Krb5 Choose file Button is Enable");
					}
				}

				validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST, connParam.getHost(),
						false);

				validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT, connParam.getPort(),
						false);

				validateInputFieldVisibility(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
						connParam.getDatabaseName(), false);

				if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS))

				{

					validateInputFieldVisibility(principalFeild, ConstantProperty.CONN_FIELD_PRINCIPAL, "", true);

					validateInputFieldVisibility(connKeytabFeild, "User Keytab Field", " ", true);

				} else {

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

				}
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

	public boolean updateConnectionPropertyField(By locator, String expectedValue) {

		boolean flag = true;

		isDisplayedInLoop(driver, 4, locator);

		javascript(driver, scrollToElementArg, locator);

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

	/** update connection property common method **/
	public boolean updateConnectionPropertiesToConnection(String jsonEntity, int count) throws Exception {
		boolean flag = true;
		String dynamicVar = "$num";
		String namefield = "Name";
		String valueField = "Value";
		String typeField = "Type";
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
					if (name.get(j).equalsIgnoreCase("loginTimeout")) {

						validateDefaultConnectionProperty(name.get(j), value.get(j), type.get(j));

					} else if (type.get(j).toLowerCase().contains("system")
							|| type.get(j).toLowerCase().contains("user")) {

						javascript(driver, scrollToElementArg,
								returnElement(connPropertyEditButton, "$name", name.get(j)));

						validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, dynamicVar,
								Integer.toString(a), dynamicName, name.get(j)), name.get(j));

						validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, dynamicVar,
								Integer.toString(a), dynamicName, value.get(j)), value.get(j));

						validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, dynamicVar,
								Integer.toString(a), dynamicName, type.get(j)), type.get(j));

						clickOnButton(driver, returnElement(connPropertyEditButton, "$name", name.get(j)), "Edit",
								true);

						updateConnectionPropertyField(returnElement(connPropCommonNameUpdate, dynamicName, name.get(j)),
								name.get(j));

						updateConnectionPropertyField(
								returnElement(connPropCommonValueUpdate, dynamicName, name.get(j)), value.get(j));

						selectConnectionType(propConnType, type.get(j).trim());

						clickOnButton(driver, returnElement(connPropertySaveButton, dynamicVar, Integer.toString(a)),
								"Save", true);

						// saveConnection();
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
	public boolean updateUserConnectionPropertiesToConnection(String jsonEntity, int count, String icedqUser)
			throws Exception {
		boolean flag = true;
		String dynamicVar = "$num";
		String newconnectionName = null;
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(jsonEntity);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

			String connName;

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				clickOnUserConnectionTab();

				if ((!icedqUser.contains("owner"))) {

					connName = newconnectionName;

				} else {

					connName = newconnectionName;
				}
				searchAndClickOnConnectionNameInConnRepo(connName);
			}
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

					if (type.get(j).toLowerCase().contains("system")) {

						validateDefaultConnectionProperty(name.get(j), value.get(j), type.get(j));

						boolean flag1 = isDisplayed(driver,
								returnElement(connPropertyEditButton, "$name", name.get(j)));

						boolean flag2 = isEnabled(driver, returnElement(connPropertyEditButton, "$name", name.get(j)));

						System.out.println(flag1);

						System.out.println(flag2);
					} else {
						javascript(driver, scrollToElementArg,
								returnElement(connPropertyEditButton, "$name", name.get(j)));

						validateConnectionPropertyField(returnElement(connPropCommonLocator1, dynamicName, name.get(j)),
								name.get(j));

						validateConnectionPropertyField(returnElement(connPropCommonLocator2, dynamicName, name.get(j)),
								value.get(j));

						validateConnectionPropertyField(returnElement(connPropCommonLocator3, dynamicName, name.get(j)),
								type.get(j));

						clickOnButton(driver, returnElement(connPropertyEditButton, "$name", name.get(j)), "Edit",
								true);

						// updateConnectionPropertyField(returnTwoElements(connPropCommonFieldUpdate,
						// dynamicVar,Integer.toString(a), dynamicName, "name"), name.get(j));

						updateConnectionPropertyField(
								returnElement(connPropCommonValueUpdate, dynamicName, name.get(j)), value.get(j));

						// selectConnectionType(propConnType, type.get(j).trim());

						clickOnButton(driver, returnElement(connPropertySaveButton, dynamicVar, Integer.toString(a)),
								"Save", true);
						saveConnection();
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

	/** Update Database connection common method **/

	/** testScenario = "Valid/Invalid" , ValidationMessage blank for valid name **/
	public boolean updateDatabaseConnection(String connJsonEntity, String driverName, String testScenario,
			String validationMessage, String icedqUser) {
		boolean flag = true;
		boolean stop = true;
		String newconnectionName = null;

		String KerberosConfigLocation = System.getProperty("user.dir") + Constant.KERBEROS_CONFIG_LOCATION;
		String UserKeytabLocation = System.getProperty("user.dir") + Constant.USER_KEYTAB_LOCATION;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

			String connusername = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

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
					connName = connParam.getConnName() + "_" + ConstantProperty.TARGET_WORKSPACE_NAME;
				}
				searchAndClickOnConnectionNameInConnRepo(connName);

			}

			String wizardStatus = validateExistingConnPageButtonsFields(connJsonEntity);

			if (wizardStatus.contains("Wizard supported connector")) { // DAT-11547

				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", true);

				} else {

					verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", false);
				}
			}

			verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", true);

			} else {

				verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);
			}

			verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

			verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", true);

			verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", true);

			inVisible(driver, spinner, Constant.ruleWait);

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

			viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, true);

			selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

			viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
					connParam.getAuthenticationname(), true);

			selectAuthenticationOfConnection(connParam.getAuthenticationname());

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

			selectConnectionType(chooseConnType, connParam.getType());

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

					WebElement m = driver.findElement(By.xpath("//input[@id='keytab']"));

					m.sendKeys(UserKeytabLocation);

					BaseSuite.validationReportLog("User key tab File Choosed successfully");

					validatAndeEnterValueToTextField(connUserPrincipalLabel, connHiveUserPrincipal,
							ConstantProperty.CONN_FIELD_USERPRINCIPAL, connPrincipalPlaceholder,
							connParam.getUserPrincipal(), validationUserprincipal);

				} else {
					entersecretPassword(connJsonEntity, connParam.getAuthenticationname(), connParam.getConnectorID(),
							icedqUser);

					enterUsername(connusername);

				}
			} else {
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

					if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

						validateInputFieldVisibility(connHiveUserPrincipal, ConstantProperty.CONN_USERPRINCIPAL, "",
								false);

						isEnabled(driver, connUserKeytab);

						BaseSuite.validationReportLog("User key tab Field is Disabled");

						isEnabled(driver, chooseFileBtn);

						BaseSuite.validationReportLog("Choose File button is Disabled");

					} else {

						validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", false);

						driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

						waitForExecution(1000);

						validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "",
								false);

						validateInputFieldVisibility(connsecretPasswordfeild, ConstantProperty.CONN_FIELD_PASSWORD, "",
								false);
					}
				}
			}

			ArrayList<String> connPropertyList = TestDataThroughApi
					.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

			int count = connPropertyList.size();

			if ((connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE))) {

				updateConnectionPropertiesToConnection(connJsonEntity, count);

				saveConnection();

			} else {

				saveConnection();

				updateUserConnectionPropertiesToConnection(connJsonEntity, count,
						ConstantProperty.ICEDQ_WORKSPACE_OWNERUSER);
			}

			updateUsernameAndPasswordForUserConnection(connJsonEntity, connParam, connParam.getType(), connusername,
					icedqUser);

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not updated properly kindly check :" + e.toString());
		}
		return flag;
	}

	/** testScenario = "Valid/Invalid" , ValidationMessage blank for valid name **/
	public boolean updateDatabaseConnectionForvault(String connJsonEntity, String driverName, String testScenario,
			String validationMessage, String icedqUser, String newconnectionName) {
		boolean flag = true;
		boolean stop = true;
		String updatednewconnectionName = null;
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			// String timestamp = new
			// SimpleDateFormat(ConstantProperty.CONNECTIONNAME_TIMESTAMPFORMAT).format(new
			// Date());

			updatednewconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE + icedqUser
					+ ConstantProperty.SIGN_UNDERSCORE + "vault" + ConstantProperty.SIGN_UNDERSCORE + "existing";

			String connusername = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

			String connpassword = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 2);

			String connprincipal = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 21);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

			} else {

				waitForExecution(3000);
				clickOnConnectionsTab();

				searchAndClickOnConnectionNameInConnRepo(newconnectionName);

			}
			inVisible(driver, spinner, Constant.ruleWait);

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			enterConnectionNameWithValidation(updatednewconnectionName, testScenario, validationMessage);

			viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, true);

			// selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

			viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
					connParam.getAuthenticationname(), true);

			selectAuthenticationOfConnection(connParam.getAuthenticationname());

			verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

			selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

			enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());

			if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS))

			{
				WebElement m = driver.findElement(By.xpath("//input[@id='krbFile']"));

				m.sendKeys("D:\\Nexg-ICEDQ-Automation\\ng-icedq-automation\\kerberos files\\krb5.conf");

				BaseSuite.validationReportLog("Krb5 File Choosed successfully");

			}

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

			selectConnectionType(chooseConnType, connParam.getType());

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS))

				{
					WebElement m = driver.findElement(By.xpath("//input[@id='keytab']"));

					m.sendKeys("D:\\Nexg-ICEDQ-Automation\\ng-icedq-automation\\kerberos files\\testuser.keytab");

					BaseSuite.validationReportLog("Keytab File Choosed successfully");

					enterPrincipal(connprincipal);
				} else if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					if (isDisplayed(driver, connvaultOnOffLabel)) {

						BaseSuite.validationReportLog("Enable Vault Label shows Clearly");

						click(driver, connvaultOnOff);

						BaseSuite.validationReportLog("Enable Vault Checkbox Clicked Successfully");

						entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
								connParam.getConnectorID(), icedqUser);

					} else {
						entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
								connParam.getConnectorID(), icedqUser);

						enterUsername(connusername);

					}
				}
			} else {

				if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

					viewAndValidateConnectionField(connKeytabFeild, "", "keytab", false);

					isEnabled(driver, connKeytabFeild);

					isClickable(driver, connKeytabFeild, "key tab", false);

					verifyVisibilityOfButtons(driver, connKeytabChoosefile, "Choose file", false);

					isEnabled(driver, connKeytabChoosefile);

					isClickable(driver, connKeytabChoosefile, "Choose file", false);

					validateInputFieldVisibility(connPrincipalInput, ConstantProperty.CONN_FIELD_PRINCIPAL,
							connPrincipalPlaceholder, false);

				} else if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

					if (isDisplayed(driver, connvaultOnOffLabel)) {
						BaseSuite.validationReportLog("Enable Vault Label shows Clearly");

						isDisplayed(driver, connvaultOnOff);

						BaseSuite.validationReportLog("Enable Vault Checkbox shows unchecked");

						click(driver, connvaultOnOff);

						BaseSuite.validationReportLog("Enable Vault Checkbox checked to update Connection");

						validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", false);

						driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

						waitForExecution(1000);

						validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "",
								false);

						validateInputFieldVisibility(connsecretPasswordfeild, ConstantProperty.CONN_FIELD_PASSWORD, "",
								false);

					} else {

						validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", false);

						driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

						waitForExecution(1000);

						validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "",
								false);

						validateInputFieldVisibility(connsecretPasswordfeild, ConstantProperty.CONN_FIELD_PASSWORD, "",
								false);
					}
				}
			}
			ArrayList<String> connPropertyList = TestDataThroughApi
					.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

			int count = connPropertyList.size();

			updateConnectionPropertiesToConnection(connJsonEntity, count);

			if ((icedqUser.contains("owner"))) {

				saveConnection();

				clickOnButton(driver, connRepoBreadcrumbLink, "Connection Repository Breadcrumb", true);

				isDisplayedInLoop(driver, 0, discardButtons);
				if (isDisplayed(driver, discardButtons)) {
					displayAndClick(driver, discardButtons);
				}

				getConnection(updatednewconnectionName, update_actualValue);

				searchAndClickOnConnectionNameInConnRepo(updatednewconnectionName);
			} else {
				flag = saveConnection(forbiddenToastMsg);
				stop = false;
			}
			if (stop) {
				flag = updateUsernameAndPasswordForUserConnection(connJsonEntity, connParam, connParam.getType(),
						connusername, icedqUser);
			}

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not updated properly kindly check :" + e.toString());
		}
		return flag;
	}

	/** Test Database connection common method **/

	public boolean testDatabaseConnection(String connJsonEntity, String driverName, String icedqUser) {
		boolean flag = false;
		String KerberosConfigLocation = System.getProperty("user.dir") + Constant.KERBEROS_CONFIG_LOCATION;
		String UserKeytabLocation = System.getProperty("user.dir") + Constant.USER_KEYTAB_LOCATION;
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			String connusername = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

			inVisible(driver, spinner, Constant.ruleWait);
			waitForExecution(1000);
			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				// viewDatabaseConnection(connJsonEntity, driverName);

				if (!icedqUser.contains("reader")) {

					waitForExecution(2000);

					flag = testConnection(connectionTestMess);

				} else {
					flag = testConnection(forbiddenToastMsg);
				}
			} else {

				// viewDatabaseConnection(connJsonEntity, driverName);

				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE))
					if (icedqUser.contains("contributor") || (icedqUser.contains("executor"))) {

						if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS))

						{

							WebElement m = driver.findElement(By.xpath("//input[@id='keytab']"));

							m.sendKeys(UserKeytabLocation);

							BaseSuite.validationReportLog("User key tab File Choosed successfully");

							validatAndeEnterValueToTextField(connUserPrincipalLabel, connHiveUserPrincipal,
									ConstantProperty.CONN_FIELD_USERPRINCIPAL, connPrincipalPlaceholder,
									connParam.getUserPrincipal(), validationUserprincipal);

						} else {

							entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);

							enterUsername(connusername);

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
							flag = clickQuickAddbtn(forbiddenToastMsg);
						}
					}
			}
		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not tested properly kindly check :" + e.toString());

		}

		return flag;
	}

	public boolean clickOnSecretPassReader(String Secret, String username, String password) {

		boolean flag = false;

		try {

			isDisplayed(driver, connUsernameInput);

			click(driver, connsecretPasswordfeild);

			sendKeys(driver, connsecretPasswordfeild, password.trim());

			BaseSuite.reportLog("Entered Secret Password");

			isDisplayed(driver, connUsernameInput);

			click(driver, connUsernameInput);

			sendKeys(driver, connUsernameInput, username.trim());

			BaseSuite.reportLog("Entered User Name");

			isDisplayed(driver, connsecretName);

			click(driver, connsecretName);

			sendKeys(driver, connsecretName, Secret.trim());

			BaseSuite.reportLog("Entered Secret Name");

		} catch (Exception e) {

			BaseSuite.reportErrorLog("due to exception kindly check " + e.toString());
		} finally {
			isDisplayedInLoop(driver, 0, discardButtons);
			if (isDisplayed(driver, discardButtons)) {
				displayAndClick(driver, discardButtons);
			}
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
			inVisible(driver, spinner, Constant.ruleWait);
		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog("due to exception kindly check " + e.toString());
		} finally {
			isDisplayedInLoop(driver, 0, discardButtons);
			if (isDisplayed(driver, discardButtons)) {
				displayAndClick(driver, discardButtons);
			}
		}
		return flag;
	}

	public boolean clickOnDuplicateConnectionForFile(String extoastMsg) {

		boolean flag = false;

		try {

			isDisplayed(driver, moreButton);
			click(driver, moreButton);
			flag = clickOnButton(driver, connFileDuplicateButton, "Duplicate", true);
			inVisible(driver, spinner, Constant.ruleWait);
			if (isDisplayed(driver, toastMsg) && flag) {
				// waitForExecution(1000);
				flag = captureToastMsg(driver, toastMsg, popUpClose, extoastMsg, "Connection Duplicate");
			} else {
				//
			}
			inVisible(driver, spinner, Constant.ruleWait);
		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog("due to exception kindly check " + e.toString());
		} finally {
			isDisplayedInLoop(driver, 0, discardButtons);
			if (isDisplayed(driver, discardButtons)) {
				displayAndClick(driver, discardButtons);
			}
		}
		return flag;
	}

	/** Duplicate database connection using API test data **/
	public boolean duplicateDatabaseConnectionMethod(String connJsonEntity, String driverName, String icedqUser) {
		boolean flag = false;
		String name = null;
		String newconnectionName = null;
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);
			waitForExecution(3000);
			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";
			// viewDatabaseConnection(connJsonEntity, driverName);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				clickOnConnectionsTab();
				isDisplayedInLoop(driver, 0, discardButtons);
				if (isDisplayed(driver, discardButtons)) {
					displayAndClick(driver, discardButtons);
				}
				String connName;

				waitForExecution(1000);

				if ((icedqUser.contains("owner"))) {

					connName = newconnectionName;
				} else {

					connName = newconnectionName;

					if (connName.contains("Databricks") || connName.contains("Hive")) {

						connName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
								+ ConstantProperty.TARGET_WORKSPACE_NAME;
					} else {

						connName = newconnectionName;
					}

				}
				searchAndClickOnConnectionNameInConnRepo(connName);

				inVisible(driver, spinner, Constant.ruleWait);

				waitForExecution(1000);
			}
			if (icedqUser.contains("owner")) {

				flag = clickOnDuplicateConnection(connDupllicateToastMsg);

				inVisible(driver, spinner, Constant.ruleWait);

				waitForExecution(1000);

				javascript(driver, scrollToElementArg, connName);

				if (flag) {
					if (isDisplayed(driver, connName)) {
						name = getAttribute(driver, connName, valueAttribute);
					} else {
						clickOnOverviewTab();
						name = getAttribute(driver, connName, valueAttribute);
					}
					clickOnConnectionsTab();
					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}

					waitForExecution(2000);
					flag = searchAndClickOnConnectionNameInConnRepo(name);
				}
			} else {
				flag = clickOnDuplicateConnection(forbiddenToastMsg);
			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(
					"Due to exception while duplicate Database Connection kindly check " + e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;
	}

	/** Duplicate database connection using API test data **/
	public boolean duplicateDatabaseConnectionMethodNew(String connJsonEntity, String driverName, String icedqUser) {
		boolean flag = false;
		String name = null;
		String newconnectionName = null;
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);
			waitForExecution(3000);
			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME;
			// viewDatabaseConnection(connJsonEntity, driverName);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				clickOnConnectionsTab();

				searchAndClickOnConnectionNameInConnRepo(newconnectionName);

				inVisible(driver, spinner, Constant.ruleWait);

				waitForExecution(1000);
			} else {

			}

			if (icedqUser.contains("owner")) {

				flag = clickOnDuplicateConnection(connDupllicateToastMsg);

				inVisible(driver, spinner, Constant.ruleWait);

				waitForExecution(1000);

				javascript(driver, scrollToElementArg, connName);

				if (flag) {
					if (isDisplayed(driver, connName)) {
						duplicateConnName = getAttribute(driver, connName, valueAttribute);
					} else {
						clickOnOverviewTab();
						duplicateConnName = getAttribute(driver, connName, valueAttribute);
					}
					clickOnConnectionsTab();

					waitForExecution(2000);

					searchConnection(duplicateConnName);

					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						getConnection(duplicateConnName, create_actualValue);

					} else {
						getConnection(duplicateConnName, update_actualValue);
					}

					flag = searchAndClickOnConnectionNameInConnRepo(duplicateConnName);
				}
			} else {
				flag = clickOnDuplicateConnection(forbiddenToastMsg);
			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(
					"Due to exception while duplicate Database Connection kindly check " + e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;
	}

	/** Duplicate database connection using API test data **/
	public String duplicateConnectionForExistingOne(String connJsonEntity, String driverName, String icedqUser) {
		boolean flag = false;
		String name = null;
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);
			waitForExecution(3000);

			// viewDatabaseConnection(connJsonEntity, driverName);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				clickOnConnectionsTab();

				searchAndClickOnConnectionNameInConnRepo(connParam.getConnName());

				inVisible(driver, spinner, Constant.ruleWait);
				waitForExecution(2000);
			}
			if (icedqUser.contains("owner")) {

				flag = clickOnDuplicateConnection(connDupllicateToastMsg);

				inVisible(driver, spinner, Constant.ruleWait);

				waitForExecution(1000);

				javascript(driver, scrollToElementArg, connName);

				if (flag) {
					if (isDisplayed(driver, connName)) {
						name = getAttribute(driver, connName, valueAttribute);
					} else {
						clickOnOverviewTab();
						name = getAttribute(driver, connName, valueAttribute);
					}
					clickOnConnectionsTab();

					waitForExecution(2000);
					flag = searchAndClickOnConnectionNameInConnRepo(name);
				}
			} else {
				flag = clickOnDuplicateConnection(forbiddenToastMsg);
			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(
					"Due to exception while duplicate Database Connection kindly check " + e.toString());
			Thread.currentThread().interrupt();
		}
		return name;
	}

	/** Click on delete button of connection and validate delete popup **/
	public boolean clickOnDeleteButton(String toastMessage, int count) {
		boolean flag = true;
		try {
			clickOnButton(driver, clickonDisable, ConstantProperty.CONNECTION_DELETE_BTN_TEXT, true);

			isDisplayedInLoop(driver, 10,
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

				inVisible(driver, spinner, Constant.ruleWait);

				flag = clickOnButton(driver,
						returnElement(connectionDeletePopupBtn, dynamicName,
								ConstantProperty.CONNECTION_DELETE_BTN_TEXT),
						ConstantProperty.CONNECTION_DELETE_BTN_TEXT, true);

				waitForExecution(2000);

				if (isDisplayed(driver, popUpClose)) {

					flag = captureToastMsg(driver, toastMsg, popUpClose, toastMessage, "Connection Delete");
				} else {

					inVisible(driver, spinner, Constant.ruleWait);
					flag = captureToastMsg(driver, toastMsg, popUpClose, toastMessage, "Connection Delete");

				}
				inVisible(driver, spinner, Constant.ruleWait);
			} else {
				flag = false;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;
	}

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

	public boolean validateListingDeleteBtn() {
		boolean flag = false;
		try {

			if (isDisplayed(driver, connDeleteButtonListing)) {

				BaseSuite.reportLog("Delete Button is visible");

				Thread.sleep(2000);

				displayAndClick(driver, connDeleteButtonListing);

				BaseSuite.reportLog("Clicked successfully on Delete Button");

				if (isDisplayed(driver, connListingDeletePopup)) {

					String popupTitle = getText(driver, connDeletePopupTitle);

					if (popupTitle.equalsIgnoreCase(connSingledeletePopupTitle)) {

						verifyIndividualLabel(driver, connectionDeletePopUpContent, connSingledeletePopupContentMsg);

					} else {

						verifyIndividualLabel(driver, connectionsDeletePopUpContent, connMultideletePopupContentMsg);

					}

					verifyVisibilityOfButtons(driver, connDeletepopCancelBtn, "Cancel", true);
					verifyVisibilityOfButtons(driver, connDeletepopDeleteBtn, "Delete", true);

					flag = true;
				} else {

					BaseSuite.reportFailLog("Delete Connection popup window not visible ", "validateListingDeleteBtn");
				}

			} else {
				BaseSuite.reportFailLog("Delete Button not visible ", "validateListingDeleteBtn");
			}

		} catch (Exception e) {

			e.getMessage();
		}
		return flag;
	}

	public boolean deleteConnectionFromListingPage(String connJsonEntity, String driverName, String icedqUser) {
		boolean flag = true;
		String newconnectionName = null;
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";
			inVisible(driver, spinner, Constant.ruleWait);

			waitForExecution(3000);

			if (icedqUser.contains("owner")) {

				clickOnConnectionsTab();

				searchConnection(newconnectionName);

				inVisible(driver, spinner, Constant.ruleWait);

				click(driver, returnElement(ConnectionlistingCheckbox, dynamicName, newconnectionName));

				waitForExecution(2000);

				flag = validateListingDeleteBtn();

				inVisible(driver, spinner, Constant.ruleWait);

				if (flag) {

					displayAndClick(driver, connDeletepopDeleteBtn);

					String toastConndelete = getAttribute(driver, toastMsg, "textContent");

					if (toastConndelete.equalsIgnoreCase(connSingleDeleteToastMsg)) {

						BaseSuite.reportLog(
								"Connection deleted successfully !!! and Proper message is displayed on single connection delete.");

						displayAndClick(driver, clickonRefresh);

					} else {

						BaseSuite.reportFailLog("Please check single connection delete message is not correct!",
								"getAttribute");
					}
				} else {

					BaseSuite.reportFailLog(ConstantProperty.COMMON_BUTTON_DELETE + "button is disabled",
							"clickOnButton");

				}

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

	/** Delete Database connection For vault method **/

	public boolean deleteDatabaseConnectionForvault(String connJsonEntity, String driverName, String icedqUser) {
		boolean flag = true;

		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);

			waitForExecution(3000);

			// viewDatabaseConnection(connJsonEntity, driverName);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				clickOnConnectionsTab();

				searchAndClickOnConnectionNameInConnRepo(connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
						+ icedqUser + ConstantProperty.SIGN_UNDERSCORE + "vault" + ConstantProperty.SIGN_UNDERSCORE
						+ "existing");

				inVisible(driver, spinner, Constant.ruleWait);

			}
			if (icedqUser.contains("owner")) {

				flag = clickOnDeleteButton(connSingleDeleteToastMsg, 1);

			} else {
				flag = clickOnDeleteButton(forbiddenToastMsg, 1);
			}
		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not deleted properly kindly check :" + e.toString());

		}

		return flag;
	}

	/**
	 * -------------------------------DataBase Connection common method for valid
	 * scenarios ended here --------------------------------------
	 **/

	/**
	 * -------------------------------DataBase Connection common method for invalid
	 * scenarios started from here ------------------------------
	 **/

	/**
	 * Enter connection name method - state is for valid / invalid connection name
	 * field if state = true then valid data else invalid data
	 **/

	public boolean createSnowflakeConnectionMethod(String connJsonEntity, SoftAssert soft, String icedqUser)
			throws InterruptedException, InterruptedException {
		boolean flag = true;
		ConnectionPageNeha cp = new ConnectionPageNeha(driver);
		NewConnectionRepoPage np = new NewConnectionRepoPage(driver);
		String newconnectionName = null;
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			String timestamp = new SimpleDateFormat("_yyyy-MM-dd-HH-mm-ss").format(new Date());

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + timestamp;

			String connusername = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

			String connpassword = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 2);

			flag = clickOnNewConnectionBtn(icedqUser);

			if (flag) {

				chooseConnectorType(connParam.getConnectorID());

				// validateWorkspaceField(ConstantProperty.TARGET_WORKSPACE_NAME);

				enterConnectionNameWithValidation(newconnectionName, "", "");

				selectAuthenticationOfConnection(connParam.getAuthentication());

				selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

				enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());

				cp.enterAccountIdentifier(connParam.getAccountIdentifire());

				cp.enterWarehouse(connParam.getWarehouse());

				cp.enterDatabase(connParam.getDatabaseName());

				cp.selectConnectionType(connParam.getType());

				if (connParam.getType().equalsIgnoreCase("system")) {

					cp.enterUsername(connusername);

					cp.enterPassword(connpassword);
				}

				flag = saveConnection(connectionSaveMesssage);

				if (flag) {

					if (connParam.getType().trim().equalsIgnoreCase("user")) {

						np.clickOnUserConnectionTab();

						np.searchAndClickOnConnectionName(newconnectionName);

						Thread.sleep(3000);
						cp.enterUsername(connusername);

						cp.enterPassword(connpassword);

						saveConnection(connectionSaveMesssage);

						testConnection(connectionTestMess);

					} else {

						testConnection(connectionTestMess);
					}

				} else {
					BaseSuite.reportFailLog("Connection not created properly kindly check ",
							"createSnowflakeConnectionMethod");
				}

			}

		} catch (Exception e) {

			BaseSuite.reportErrorLog("Connection not created properly due to exception kindly check " + e.toString());
			Thread.currentThread().interrupt();

		}
		return flag;

	}


	public boolean entervalueInTextFieldWithValidation(ConnectionPoJO connParamFromExcel, By locator, String label,
			String inputvalue, String scenario, String validationMessage, boolean state) throws NoSuchElementException {
 
		String methodName = "entervalueInTextFieldWithValidation";
		boolean flag = false;
		try {
			// ConnectionPoJO connParam =
			// setConnectionParametersForApi(connParamFromExcel.getFieldName());
 
			isDisplayedInLoop(driver, 4, locator);
 
			javascript(driver, scrollToElementArg, locator);
 
			isClickable(driver, locator, label + " field", state);
 
			if (isEditable(driver, locator, label + " field") && state) {
 
				BaseSuite.reportLog("Entering value : " + inputvalue);
				if (!inputvalue.isEmpty()) {
					click(driver, locator);
 
					clear(driver, locator);
 
					clear_Click_SendKeys(driver, 10, locator, inputvalue);
 
				} else if (scenario.toLowerCase().equalsIgnoreCase("invalid") && inputvalue.isEmpty()) {
 
					click(driver, locator);
 
					sendKeys(driver, locator, "emptyvaluecheck");
 
					displayAndClearInputField(driver, 1, locator);
 
					waitForExecution(500);
				}
				String ac = getAttribute(driver, locator, valueAttribute);
 
				stringContainsOutput(ac, inputvalue, true);
 
				if (validationMessage.isEmpty()) {
					String acmesg = validationMessageOfField(returnElement(connAllFieldValidation, dynamicName, label),
							label, "", false);
					if (acmesg == null) {
						flag = true;
					}
				} else {
					String acmesg = validationMessageOfField(returnElement(connAllFieldValidation, dynamicName, label),
							label, "", true);
 
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
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" Exception found : " + e.getMessage());
			throw new NoSuchElementException();
		}
		return flag;
	}

	
	
			public boolean entervalueJdbcWithValidation(ConnectionPoJO connParamFromExcel, By locator, String label,
					String inputvalue, String scenario, String validationMessage, boolean state) throws NoSuchElementException {
		 
				String methodName = "entervalueInTextFieldWithValidation";
				boolean flag = false;
				try {
					// ConnectionPoJO connParam =
					// setConnectionParametersForApi(connParamFromExcel.getFieldName());
		 
					isDisplayedInLoop(driver, 4, locator);
		 
					javascript(driver, scrollToElementArg, locator);
		 
					isClickable(driver, locator, label + " field", state);
		 
					if (isEditable(driver, locator, label + " field") && state) {
		 
						BaseSuite.reportLog("Entering value : " + inputvalue);
						if (!inputvalue.isEmpty()) {
							click(driver, locator);
		 
							clear(driver, locator);
		 
							clear_Click_SendKeys(driver, 10, locator, inputvalue);
		 
						} else if (scenario.toLowerCase().equalsIgnoreCase("invalid") && inputvalue.isEmpty()) {
		 
							click(driver, locator);
		 
							sendKeys(driver, locator, "emptyvaluecheck");
		 
							displayAndClearInputField(driver, 1, locator);
		 
							waitForExecution(500);
						}
						String ac = getAttribute(driver, locator, valueAttribute);
		 
						stringContainsOutput(ac, inputvalue, true);
		 
						if (validationMessage.isEmpty()) {
							String acmesg = validationMessageOfField(returnElement(connJdbcFieldValidation, dynamicName, label),
									label, "", false);
							if (acmesg == null) {
								flag = true;
							}
						} else {
							String acmesg = validationMessageOfField(returnElement(connJdbcFieldValidation, dynamicName, label),
									label, "", true);
		 
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
					Thread.currentThread().interrupt();
					BaseSuite.reportErrorLog(" Exception found : " + e.getMessage());
					throw new NoSuchElementException();
				}
				return flag;
			}

	

	public boolean entervalueAccIdentifierWithValidation(ConnectionPoJO connParamFromExcel, By locator, String label,
			String inputvalue, String scenario, String validationMessage, boolean state) throws NoSuchElementException {

		String methodName = "entervalueAccIdentifierWithValidation";
		boolean flag = false;
		try {
			// ConnectionPoJO connParam =
			// setConnectionParametersForApi(connParamFromExcel.getFieldName());

			isDisplayedInLoop(driver, 4, locator);

			javascript(driver, scrollToElementArg, locator);

			isClickable(driver, locator, label + " field", state);

			if (isEditable(driver, locator, label + " field") && state) {

				BaseSuite.reportLog("Entering value : " + inputvalue);
				if (!inputvalue.isEmpty()) {
					click(driver, locator);

					clear(driver, locator);

					clear_Click_SendKeys(driver, 10, locator, inputvalue);

				} else if (scenario.toLowerCase().equalsIgnoreCase("invalid") && inputvalue.isEmpty()) {

					click(driver, locator);

					sendKeys(driver, locator, "emptyvaluecheck");

					displayAndClearInputField(driver, 1, locator);

					waitForExecution(500);
				}
				String ac = getAttribute(driver, locator, valueAttribute);

				stringContainsOutput(ac, inputvalue, true);

				if (validationMessage.isEmpty()) {
					String acmesg = validationMessageOfField(
							returnElement(accountIdentifierfeildvalidation, dynamicName, label), label, "", false);
					if (acmesg == null) {
						flag = true;
					}
				} else {
					String acmesg = validationMessageOfField(
							returnElement(accountIdentifierfeildvalidation, dynamicName, label), label, "", true);

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
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" Exception found : " + e.getMessage());
			throw new NoSuchElementException();
		}
		return flag;
	}

	public ConnectionPoJO setConnParametersForInvalid(String fileName, String sheetName, int rowNumber) {
		ConnectionPoJO connectionparam = new ConnectionPoJO();
		XLUtils xl = new XLUtils();

		try {

			connectionparam.setTestScenario(xl.readUsingColName(fileName, sheetName, rowNumber, "TestScenario"));
			connectionparam.setKerberosCreate(xl.readUsingColName(fileName, sheetName, rowNumber, "ConnectionJsonForKerberos"));
			connectionparam.setFieldName(xl.readUsingColName(fileName, sheetName, rowNumber, "FieldName"));
			connectionparam.setConnectionJsonValueLocal(xl.readUsingColName(fileName, sheetName, rowNumber, "ConnectionJsonForLocal"));
			connectionparam.setConnectionJsonValue(xl.readUsingColName(fileName, sheetName, rowNumber, "ConnectionJsonForDatabricks"));
			connectionparam.setValidationMessage(xl.readUsingColName(fileName, sheetName, rowNumber, "ValidationMessage"));
			connectionparam.setOnSaveValidation(xl.readUsingColName(fileName, sheetName, rowNumber, "OnSaveValidation"));
			connectionparam.setOnTestValidation(xl.readUsingColName(fileName, sheetName, rowNumber, "OnTestValidation"));
			connectionparam.setConnectionJsonValueS3(xl.readUsingColName(fileName, sheetName, rowNumber, "ConnectionJsonForS3"));
			connectionparam.setConnectionJsonValueAzure(xl.readUsingColName(fileName, sheetName, rowNumber, "ConnectionJsonForAzure"));
			connectionparam.setHiveUsernamePassword(xl.readUsingColName(fileName, sheetName, rowNumber, "json_username&password"));
			
			
			connectionparam.setConnectionJsonValue(
					xl.readUsingColName(fileName, sheetName, rowNumber, "ConnectionJsonForLocal"));

			connectionparam.setConnectionJSONForExcelLocal(
					xl.readUsingColName(fileName, sheetName, rowNumber, "ConnectionJsonForExcelLocal"));
			connectionparam.setConnectionJsonValue(
					xl.readUsingColName(fileName, sheetName, rowNumber, "ConnectionJsonForDatabricks"));
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

			connectionparam.setType(xl.readUsingColName(fileName, sheetName, rowNumber, "testcasetype"));
			connectionparam
					.setAccountIdentifire(xl.readUsingColName(fileName, sheetName, rowNumber, "AccountIdentifier"));
			connectionparam.setAuthenticationSnowflake(
					xl.readUsingColName(fileName, sheetName, rowNumber, "AuthenticationSnowflake"));
			connectionparam.setConnectionJsonForUsername(
					xl.readUsingColName(fileName, sheetName, rowNumber, "ConnectionJsonForUsername"));
			connectionparam.setConnectionJsonForKeyPair(
					xl.readUsingColName(fileName, sheetName, rowNumber, "ConnectionJsonForKeyPair"));
			connectionparam.setConnectionJsonForAzureKeyVault(
					xl.readUsingColName(fileName, sheetName, rowNumber, "ConnectionJsonForAzureKeyVault"));
			connectionparam
					.setSybaseCredentials(xl.readUsingColName(fileName, sheetName, rowNumber, "sybaseCredentials"));
			connectionparam.setConnectionJsonForSQLServeNativeSQLServerAuth(xl.readUsingColName(fileName, sheetName,
					rowNumber, "ConnectionJsonForSQLServeNativeSQLServerAuth"));
			connectionparam.setConnectionJsonForSQLServerNativeWindowsAuth(
					xl.readUsingColName(fileName, sheetName, rowNumber, "ConnectionJsonForSQLServerNativeWindowsAuth"));
			connectionparam.setConnectionJsonForSQLServerCustomSQLServerAuth(xl.readUsingColName(fileName, sheetName,
					rowNumber, "ConnectionJsonForSQLServerCustomSQLServerAuth"));
			connectionparam.setConnectionJsonForSQLServerCustomWindowsAuth(
					xl.readUsingColName(fileName, sheetName, rowNumber, "ConnectionJsonForSQLServerCustomWindowsAuth"));

			return connectionparam;
		} catch (Exception e) {
			throw new NullPointerException(e.toString());
		}
	}

	/** testScenario = "Valid/Invalid" , ValidationMessage blank for valid name **/

	public boolean createDatabaseConnectionForInvalid(String connJsonEntity, String testScenario, String fieldName,
			String onvalidationMessage, String onSaveValidation, String icedqUser, String tctype) {
		boolean flag = true;
		boolean status1 = false;
		boolean status = false;
		String newconnectionName = null;
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName();

			inVisible(driver, spinner, Constant.ruleWait);

			String wizardStatus = validateNewConnPageButtonsFields(connParam.getConnectorID());

			if (wizardStatus.contains("Wizard supported connector")) {

				verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", false);
			}

			verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

			verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);

			verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

			verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", false);

			verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", false);

			status1 = entervalueInTextFieldWithValidation(connParam, connName, "Connection Name", newconnectionName,
					testScenario, onvalidationMessage, true);

			if (!tctype.isEmpty()) {

				selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

				selectAuthenticationOfConnection(connParam.getAuthenticationname());

				boolean cs = selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

				switch (fieldName.toLowerCase().trim()) {

				case "connectionname":

					if (cs) {
						entervalueInTextFieldWithValidation(connParam, connCustomJDBCTextbox, "",
								connParam.getCustomJDBCURLValue(), testScenario, onvalidationMessage, true);
					}

					entervalueInTextFieldWithValidation(connParam, connHostInputField, ConstantProperty.CONN_FIELD_HOST,
							connParam.getHost(), testScenario, onvalidationMessage, true);
					entervalueInTextFieldWithValidation(connParam, connPortInputField, ConstantProperty.CONN_FIELD_PORT,
							connParam.getPort(), testScenario, onvalidationMessage, true);
					entervalueInTextFieldWithValidation(connParam, connDatabaseInputField,
							ConstantProperty.CONN_FIELD_DATABASE, connParam.getDatabaseName(), testScenario,
							onvalidationMessage, true);

					entervalueInTextFieldWithValidation(connParam, connUsernameInput,
							ConstantProperty.CONN_FIELD_USERNAME, connParam.getUsername(), testScenario,
							onvalidationMessage, true);
					entervalueInTextFieldWithValidation(connParam, connPasswordInput,
							ConstantProperty.CONN_FIELD_PASSWORD, connParam.getPassword(), testScenario,
							onvalidationMessage, true);

					if (icedqUser.toLowerCase().contains("owner")) {

						status = saveConnection(onSaveValidation);

					} else {

						status = saveConnection(forbiddenToastMsg);
					}
					break;

				case "jdbcurl":
					if (cs) {
						status = entervalueInTextFieldWithValidation(connParam, connCustomJDBCTextbox, "",
								connParam.getCustomJDBCURLValue(), testScenario, onvalidationMessage, true);

					}
					break;

				case "host":
					selectCustomJDBCURLOfConnection("false");
					status = entervalueInTextFieldWithValidation(connParam, connHostInputField,
							ConstantProperty.CONN_FIELD_HOST, connParam.getHost(), testScenario, onvalidationMessage,
							true);

					break;

				case "port":
					selectCustomJDBCURLOfConnection("false");
					status = entervalueInTextFieldWithValidation(connParam, connPortInputField,
							ConstantProperty.CONN_FIELD_PORT, connParam.getPort(), testScenario, onvalidationMessage,
							true);

					break;
				case "database":
					selectCustomJDBCURLOfConnection("false");
					status = entervalueInTextFieldWithValidation(connParam, connDatabaseInputField,
							ConstantProperty.CONN_FIELD_DATABASE, connParam.getDatabaseName(), testScenario,
							onvalidationMessage, true);

					break;
				case "username":
					if (!connParam.getType().equalsIgnoreCase("user")) {
						status = entervalueInTextFieldWithValidation(connParam, connUsernameInput,
								ConstantProperty.CONN_FIELD_USERNAME, connParam.getUsername(), testScenario,
								onvalidationMessage, true);
					}
					break;
				case "password":

					if (!connParam.getType().equalsIgnoreCase("user")) {
						status = entervalueInTextFieldWithValidation(connParam, connPasswordInput,
								ConstantProperty.CONN_FIELD_PASSWORD, connParam.getPassword(), testScenario,
								onvalidationMessage, true);
					}
					break;

				case "propertyname":
				case "propertyvalue":
					ArrayList<String> connPropertyList = TestDataThroughApi
							.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

					int count = connPropertyList.size();

					status = addConnectionPropertiesToConnection1(connJsonEntity, count, testScenario, fieldName);

					clickOnOverviewTab();

					break;

				default:
					BaseSuite.reportErrorLog("Field name is not found kindly check :: " + fieldName);
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
			BaseSuite.reportErrorLog("Database connection not created properly kindly check   :" + e.toString());
		}
		return flag;
	}

	// method to add connection properties to connection
	public boolean addConnectionPropertiesToConnection1(String jsonEntity, int count, String scenario, String fieldname)
			throws Exception {
		boolean flag = false;
		try {
			if (count > 0) {

				clickOnPropertiesTab();

				ArrayList<String> name = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						connConnectionPropNames);

				ArrayList<String> value = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						connConnectionPropValues);

				ArrayList<String> type = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						connConnectionPropTypes);

				for (int j = 0; j < name.size(); j++) {

					flag = addConnectionProperty1(name.get(j), value.get(j), type.get(j), scenario, fieldname);

				}

			}

		} catch (Exception e) {
			e.getMessage();

		}
		return flag;
	}

	public boolean addConnectionProperty1(String name, String value, String type, String scenario, String fieldname) {
		boolean flag = false;

		try {
			waitForExecution(2000);

			clickOnAddPropertybutton();

			switch (fieldname.toLowerCase().trim()) {

			case "propertyname":
				flag = enterConnPropertyName(name.trim(), scenario);
				break;

			case "propertyvalue":
				flag = enterConnPropertyValue(value.trim(), scenario);
				break;
			default:
				break;
			}

			/** selectPropertyType(type.trim()); **/

			/** clickonAddPropertyIconButton(); **/

		} catch (Exception e) {

			e.getMessage();
		}
		return flag;
	}

	public boolean enterConnPropertyName(String name, String scenario) {
		boolean flag = false;
		try {

			javascript(driver, scrollToElementArg, addPropertyNewName);

			if (!name.isEmpty()) {
				if (isEnabled(driver, addPropertyNewName)) {
					if (isClickable(driver, addPropertyNewName, "property name", true)) {
						BaseSuite.reportLog("Entering property Name as " + name);

						clear_SendKeys(driver, addPropertyNameForDB, name);

						driver.findElement(addPropertyNameForDB).sendKeys(Keys.ENTER);

						BaseSuite.validationReportLog("Poperty Name entered successfully");

						String connPropName = getAttribute(driver, addpropertyNameInput, valueAttribute);

						stringContainsOutput(connPropName.trim(), name.trim(), true);

						click(driver, addPropertyValue);

						flag = checkCssOfTextField(addPropertyNameForColor, "property name", scenario, attributeBorder);

					}
				} else {
					BaseSuite.reportErrorLog("Property name field is disabled, kindly check.");
				}
			} else {
				click(driver, addPropertyValue);

				flag = checkCssOfTextField(addPropertyNameForColor, "property name", scenario, attributeBorder);

			}

		} catch (Exception e) {
			e.getMessage();
		}
		return flag;
	}

	public boolean enterConnPropertyValue(String value, String scenario) {
		boolean flag = false;
		try {

			isDisplayedInLoop(driver, 2, addPropertyValue);

			if (!value.isEmpty()) {
				if (isEnabled(driver, addPropertyValue)) {
					if (isClickable(driver, addPropertyValue, "property value", true)) {
						BaseSuite.reportLog("Entering property value as " + value);

						clear_SendKeys(driver, addPropertyValue, value);

						BaseSuite.validationReportLog("Property value entered successfully");

						String connPropValue = getAttribute(driver, addpropertyValueInput, valueAttribute);

						stringContainsOutput(connPropValue.trim(), value.trim(), true);

						click(driver, addpropertyNameInput);

						flag = checkCssOfTextField(addPropertyValue, "property value", scenario, attributeBorder);
					}
				} else {
					BaseSuite.reportErrorLog("Property value field is disabled, kindly check.");
				}
			} else {

				click(driver, addpropertyNameInput);

				flag = checkCssOfTextField(addPropertyValue, "property value", scenario, attributeBorder);

			}

		} catch (Exception e) {
			e.getMessage();
		}
		return flag;
	}

	public boolean checkCssOfTextField(By locator, String label, String scenario, String cssAtrr)
			throws InterruptedException {
		boolean flag = true;
		isDisplayedInLoop(driver, 0, locator);

		if (isDisplayed(driver, locator)) {
			BaseSuite.reportLog("checking state of " + label);
			Thread.sleep(1000);
			String color = driver.findElement(locator).getCssValue(cssAtrr);
			String hex = Color.fromString(color).asHex();

			switch (scenario.toLowerCase().trim()) {

			case "valid":

				if (hex.matches("#ff0000")) {

					BaseSuite.reportFailLog(
							label + " is highlighted in RED color for entered invalid value :: actual " + hex,
							"checkCssOfTextField");
					flag = false;
				} else {
					BaseSuite.validationReportLog(label + " is not highlighted in RED color for entered invalid value");

				}

				break;
			case "invalid":
				Thread.sleep(1000);
				if (hex.matches("#ff0000")) {

					BaseSuite.validationReportLog(label + " is highlighted in RED color for entered invalid value");

				} else {
					BaseSuite.reportFailLog(
							label + " is not highlighted in RED color for entered invalid value:: actual " + hex,
							"checkCssOfTextField");
					flag = false;
				}

				break;
			default:
				break;
			}
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

			actions.moveToElement(driver.findElement(locator1)).perform();
			
			inVisible(driver, spinner, 30);

			validMess = getText(driver, locator1).trim();

			if (validMess.isEmpty()) {
				validMess = getAttribute(driver, locator1, "textContent");
			}

			actions.click(driver.findElement(locator2)).build().perform();
			
			inVisible(driver, spinner, 30);

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

						BaseSuite.validationReportLog("Expected condition Successfully Matched ");
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

	/** Save connection method in case of update **/
	public boolean saveConnection() throws Exception {
		boolean flag = true;
		try {

			javascript(driver, scrollToElementArg, connSaveBtn);

			flag = clickOnButton(driver, connSaveBtn, "Save", true);

			inVisible(driver, spinner, Constant.ruleWait);

		} catch (Exception ex) {
			throw new NoSuchElementException();
		}
		return flag;
	}

	/** Test Flat file native connection using API Invalid test data **/
	public boolean testDatabaseConnectionMethodForInvalidData(String connectorType, String fileName, String sheetName,
			int rowNumber) throws NullPointerException {
		boolean flag = true;
		String credential = null;
		String accessKey = null;
		String secretKey = null;
		XLUtils xl = new XLUtils();

		try {

			switch (connectorType.toLowerCase().trim()) {

			case "postgresql":
				credential = xl.readUsingColName(fileName, sheetName, rowNumber, "postgresql");

				break;

			case "redshift":
				credential = xl.readUsingColName(fileName, sheetName, rowNumber, "redshift");

			case "oracle":
				credential = xl.readUsingColName(fileName, sheetName, rowNumber, "oracle");

				break;
			default:

				break;
			}

			inVisible(driver, spinner, Constant.ruleWait);

			waitForExecution(3000);

			if (credential != null) {

				String[] a = credential.split(";");

				accessKey = a[0];

				secretKey = a[1];
			}

			validatAndeEnterValueToTextField(connUsernameLabel, connUsernameInput, "Username", connUsernamePlaceholder,
					accessKey, "Username is required.");

			validatAndeEnterValueToTextField(connPasswordLabel, connPasswordInput, "Password", connPasswordPlaceholder,
					secretKey, "Password is required.");

			flag = saveConnection();

			if (flag) {

				clickOnButton(driver, connTestBtn, "Test", true);

				inVisible(driver, spinner, 30);

				flag = captureToastMsgForConnection(driver, toastMsg, popUpClose, connectionTestMess, "Connection Test",
						false);
			}

		} catch (TimedOutException e) {
			flag = false;

			BaseSuite.reportFailLog("Application spinner taking more time to invisible than stardard time",
					"testFlatFileNativeConnectionMethodForInvalidData");

			driver.navigate().refresh();

			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

			BaseSuite.reportErrorLog(" due to exception kindly check " + e.toString());

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();

			BaseSuite.reportLog("Error occurs while test database connection :: " + e.toString());

		}
		return flag;
	}

	/** xml file connector code **/

	/** Validate and select location type of flat file connection **/

	public void selectLocationOfFlatFileNativeConnection(String locationType, ConnectionPoJO connParam) {

		// String locationName =setServiceProvidertoLocation(locationType) ;
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
					waitForExecution(2000);
					List<WebElement> authList = getElements(driver, connFlatFileLocationDDList);

					for (int i = 0; i < authList.size(); i++) {

						String authName = authList.get(i).getAttribute("textContent");

						BaseSuite.reportLog((i + 1) + ". " + authName + " is visible");

					}
				}
				String locationName =setLocationType(connParam.getServiceProviderName());
				String locator;
				if ((connParam.getServiceProviderName().equalsIgnoreCase(locationName))) {

					locator = connselectLocation;
				} else {
					locator = connselectLocation;

				}
				isDisplayedInLoop(driver, 4, returnElement(locator, dynamicName, locationName));

				if (isDisplayed(driver, returnElement(locator, dynamicName, locationName))) {

					displayAndClick(driver, returnElement(locator, dynamicName, locationName));

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

	public void selectLocationOfParquetConnection(String locationType, ConnectionPoJO connParam) {

		String locationName = setServiceProvidertoLocation(locationType);
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
					waitForExecution(2000);
					List<WebElement> authList = getElements(driver, connFlatFileLocationDDList);

					for (int i = 0; i < authList.size(); i++) {

						String authName = authList.get(i).getAttribute("textContent");

						BaseSuite.reportLog((i + 1) + ". " + authName + " is visible");

					}
				}
				String locator;
				if ((connParam.getServiceProviderName().equalsIgnoreCase("aws-s3"))) {

					locator = connselectLocation;
				} else {
					locator = connselectLocation;

				}
				isDisplayedInLoop(driver, 4, returnElement(locator, dynamicName, locationName));

				if (isDisplayed(driver, returnElement(locator, dynamicName, locationName))) {

					displayAndClick(driver, returnElement(locator, dynamicName, locationName));

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

					validationMessageOfField(connFlatFileFolderPathFieldValidation, "Folder path",
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

	/** Enter Test file method for Excel file connection **/

	public void enterTestFileForExcelConnection(String testFile) throws NoSuchElementException {

		try {
			isDisplayedInLoop(driver, 4, connExcelTestFileLabel);

			javascript(driver, scrollToElementArg, connExcelTestFileLabel);

			verifyIndividualLabel(driver, connExcelTestFileLabel, Constant.CONNECTIONNAME);

			if (isDisplayed(driver, connExcelTestFileField)) {

				isClickable(driver, connExcelTestFileField, "Test File", true);

				if (isEditable(driver, connExcelTestFileField, "Test File")) {

					clear(driver, connExcelTestFileField);

					validationMessageOfField(connExcelTestFileFieldValidation, "Test File", testFileEmptyValidationMsg,
							true);

					String ph = getAttribute(driver, connExcelTestFileField, placeHolderAttribute);

					if (!ph.isEmpty() && ph.equalsIgnoreCase(testFilePlaceHolder)) {

						BaseSuite.reportLog("Test File field place holder : " + ph);

					} else {

						BaseSuite.reportFailLog("test file field place holder not found : Actual :" + ph
								+ "  and Expected : " + testFilePlaceHolder, " enterTestFileForExcelConnection");
					}

					BaseSuite.reportLog("Entering value : " + testFile);

					sendKeys(driver, connExcelTestFileField, testFile);

					String ac = getAttribute(driver, connExcelTestFileField, valueAttribute);

					stringContainsOutput(ac, testFile, true);

					validationMessageOfField(connExcelTestFileFieldValidation, "Test File", testFileEmptyValidationMsg,
							false);

				} else {
					BaseSuite.reportFailLog("Test File field not editable", "enterTestFileForExcelConnection");
				}
			} else {
				BaseSuite.reportFailLog("Test File field not displayed", "enterTestFileForExcelConnection");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Exception found : " + e.getMessage());
			throw new NoSuchElementException();
		}
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

	public boolean updateSystemAndUserConnectionCredentials(String connJsonEntity, ConnectionPoJO connParam,
			String newConnectionName, String icedqUser) {
		boolean flag = false;

		connParam = setConnectionParametersForApi(connJsonEntity);
		
		String locationName =setLocationType(connParam.getServiceProviderName());

		String accountName = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 5);

		try {
			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
						|| connParam.getServiceProviderName().equalsIgnoreCase("aws-s3")
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

					entersecretPassword(connJsonEntity, connParam.getAuthenticationname(), connParam.getConnectorID(),
							icedqUser);

					if (locationName.toLowerCase().contains("custom credential")) {

						validatAndeEnterValueToTextField(connSessionTokenLabel, connSessionTokenField,
								ConstantProperty.CONN_FIELD_SESSIONTOKEN, connSessionTokenPlaceholder, "",
								connSessionTokenPlaceholder);

					}
				} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {

					validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
							ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, accountName,
							accountNameEmptyValidationMsg);

					if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {

						entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
								connParam.getConnectorID(), icedqUser);

					} else {
						entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
								connParam.getConnectorID(), icedqUser);
					}
				}
				Thread.sleep(1000);
				if (icedqUser.contains("owner")) {
					flag = saveConnection(connectionSaveMesssage);
				} else {

					flag = saveConnection(forbiddenToastMsg);
				}

			} else {
				if (connParam.getServiceProviderName().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
						|| connParam.getServiceProviderName().equalsIgnoreCase("aws-s3")
						|| connParam.getServiceProviderName().equalsIgnoreCase("s3")
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

					validateFieldOfConnection(connFlatFileAccesskeyLabel, connFlatFileAccesskeyField,
							ConstantProperty.CONN_FIELD_ACCESSKEY, accesskeyPlaceHolder, false);

					validateFieldOfConnection(connFlatFileSecretkeyLabel, connFlatFileSecretkeyField,
							ConstantProperty.CONN_FIELD_SECRETKEY, secretkeyPlaceHolder, false);

					if (connParam.getAuthenticationname().toLowerCase().contains("custom credential")) {

						validateFieldOfConnection(connSessionTokenLabel, connSessionTokenField,
								ConstantProperty.CONN_FIELD_SESSIONTOKEN, "", false);

					}
				} else if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {
					
					validateFieldOfConnection(connsecretNameLabel, connsecretName,
							ConstantProperty.CONN_FIELD_SECRETNAME, connSecretNamePlaceholder, false);

					validateFieldOfConnection(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
							ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, false);

					if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {

						validateFieldOfConnection(connFlatFileAccountKeyLabel, connFlatFileAccountKeyField,
								ConstantProperty.CONN_FIELD_ACCOUNTKEY, accountKeyPlaceHolder, false);

					} else {
						validateFieldOfConnection(connSecurityTokenLabel, connSecurityTokenField,
								ConstantProperty.CONN_FIELD_SECURITYTOKEN, connSecurityTokenPlaceholder, false);

					}
				}
				if (icedqUser.contains("owner")) {

					flag = saveConnection(connectionSaveMesssage);
				} else {

					flag = saveConnection(forbiddenToastMsg);

				}
				if (flag || (isEnabled(driver, moreButton) && isEnabled(driver, connDeleteButton))) {

					clickOnUserConnectionTab();

					searchAndClickOnConnectionNameInConnRepo(newConnectionName);

					waitForExecution(3000);

					if (locationName.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)
							&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

						entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
								connParam.getConnectorID(), icedqUser);

						if (connParam.getAuthenticationname().toLowerCase().contains("custom credential")) {

							validatAndeEnterValueToTextField(connSessionTokenLabel, connSessionTokenField,
									ConstantProperty.CONN_FIELD_SESSIONTOKEN, connSessionTokenPlaceholder, "",
									connSessionTokenPlaceholder);

						}

					} else if (locationName
							.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {

						validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
								ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, accountName,
								accountNameEmptyValidationMsg);

						if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {

							entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);

						} else {

							entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);

						}
					}
				}
				if (icedqUser.contains("owner")) {

					flag = saveConnection();
				} else {

					flag = saveConnection(forbiddenToastMsg);
				}

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

	public void selectAccessKey(String locationType) {

		try {
			String authValue = null;
			isDisplayedInLoop(driver, 2, connFlatFileAccesskeyLabel);

			javascript(driver, scrollToElementArg, connFlatFileAccesskeyLabel);

			verifyIndividualLabel(driver, connFlatFileAccesskeyLabel, ConstantProperty.CONN_FIELD_ACCESSKEY);

			if (isEditable(driver, connFlatFileAccesskeyField, "Select access key")) {

				BaseSuite.validationReportLog("Access key field is visible ");

				authValue = getAttribute(driver, connFlatFileAccesskeyField, valueAttribute);

				BaseSuite.reportLog("Default access key value selected as : " + authValue);

				isDisplayedInLoop(driver, 2, flatfileaccessddb);

				if (isDisplayed(driver, flatfileaccessddb)) {

					displayAndClick(driver, flatfileaccessddb);

					BaseSuite.validationReportLog(
							"Clicked on Access key drop down  " + ConstantProperty.SUCCESSSTRING + "");

					BaseSuite.reportLog("Checking list of Access key Value visible");
					waitForExecution(2000);
					/*
					 * List<WebElement> authList = getElements(driver, connsecretPassdropdownlist);
					 * 
					 * for (int i = 0; i < authList.size(); i++) {
					 * 
					 * String authName = authList.get(i).getAttribute("textContent");
					 * 
					 * BaseSuite.reportLog((i + 1) + ". " + authName + " is visible");
					 * 
					 * }
					 */
				}
				javascript(driver, scrollToElementArg, returnElement(connselectPassword, dynamicName, locationType));

				isDisplayedInLoop(driver, 4, returnElement(connselectPassword, dynamicName, locationType));

				if (isDisplayed(driver, returnElement(connselectPassword, dynamicName, locationType))) {

					displayAndClick(driver, returnElement(connselectPassword, dynamicName, locationType));

					authValue = getAttribute(driver, connFlatFileAccesskeyField, valueAttribute);

					if (!authValue.isEmpty()) {
						BaseSuite.validationReportLog("Access key selected as : " + authValue);

					}

				} else {
					BaseSuite.reportFailLog("Expected Access key not found kindly check", "selectAccessKey");
				}

			} else {
				BaseSuite.reportFailLog("Select access key field not visible ", "selectAccessKey");
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			e.getMessage();
			throw new NoSuchElementException();
		}
	}

	public void selectSecretKey(String locationType) {

		try {
			String authValue = null;
			isDisplayedInLoop(driver, 2, connFlatFileSecretkeyLabel);

			javascript(driver, scrollToElementArg, connFlatFileSecretkeyLabel);

			verifyIndividualLabel(driver, connFlatFileSecretkeyLabel, ConstantProperty.CONN_FIELD_SECRETKEY);

			if (isEditable(driver, connFlatFileSecretkeyField, "Select secret key")) {

				BaseSuite.validationReportLog("Secret key field is visible ");

				authValue = getAttribute(driver, connFlatFileSecretkeyField, valueAttribute);

				BaseSuite.reportLog("Default Secret key value selected as : " + authValue);

				isDisplayedInLoop(driver, 2, flatfilesecretddb);

				if (isDisplayed(driver, flatfilesecretddb)) {

					displayAndClick(driver, flatfilesecretddb);

					BaseSuite.validationReportLog(
							"Clicked on Secret key drop down  " + ConstantProperty.SUCCESSSTRING + "");

					BaseSuite.reportLog("Checking list of Secret key Value visible");
					waitForExecution(2000);

				}
				javascript(driver, scrollToElementArg, returnElement(connselectPassword, dynamicName, locationType));

				isDisplayedInLoop(driver, 4, returnElement(connselectPassword, dynamicName, locationType));

				if (isDisplayed(driver, returnElement(connselectPassword, dynamicName, locationType))) {

					waitForExecution(3000);

					displayAndClick(driver, returnElement(connselectPassword, dynamicName, locationType));

					authValue = getAttribute(driver, connFlatFileSecretkeyField, valueAttribute);

					if (!authValue.isEmpty()) {
						BaseSuite.validationReportLog("Secret key selected as : " + authValue);

					}

				} else {
					BaseSuite.reportFailLog("Expected Secret key not found kindly check", "selectSecretKey");
				}

			} else {
				BaseSuite.reportFailLog("Select Secret key field not visible ", "selectSecretKey");
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			e.getMessage();
			throw new NoSuchElementException();
		}
	}

	public void selectAthenaSecretKey(String locationType) {

		try {
			String authValue = null;
			isDisplayedInLoop(driver, 2, connFlatFileSecretkeyLabel);

			javascript(driver, scrollToElementArg, connFlatFileSecretkeyLabel);

			verifyIndividualLabel(driver, connFlatFileSecretkeyLabel, ConstantProperty.CONN_FIELD_SECRETKEY);

			if (isEditable(driver, connFlatFileSecretkeyField, "Select secret key")) {

				BaseSuite.validationReportLog("Secret key field is visible ");

				authValue = getAttribute(driver, connFlatFileSecretkeyField, valueAttribute);

				BaseSuite.reportLog("Default Secret key value selected as : " + authValue);

				isDisplayedInLoop(driver, 2, athenasecretddb);

				if (isDisplayed(driver, athenasecretddb)) {

					displayAndClick(driver, athenasecretddb);

					BaseSuite.validationReportLog(
							"Clicked on Secret key drop down  " + ConstantProperty.SUCCESSSTRING + "");

					BaseSuite.reportLog("Checking list of Secret key Value visible");
					waitForExecution(2000);

				}
				javascript(driver, scrollToElementArg, returnElement(connselectPassword, dynamicName, locationType));

				isDisplayedInLoop(driver, 4, returnElement(connselectPassword, dynamicName, locationType));

				if (isDisplayed(driver, returnElement(connselectPassword, dynamicName, locationType))) {

					waitForExecution(3000);

					displayAndClick(driver, returnElement(connselectPassword, dynamicName, locationType));

					authValue = getAttribute(driver, connFlatFileSecretkeyField, valueAttribute);

					if (!authValue.isEmpty()) {
						BaseSuite.validationReportLog("Secret key selected as : " + authValue);

					}

				} else {
					BaseSuite.reportFailLog("Expected Secret key not found kindly check", "selectSecretKey");
				}

			} else {
				BaseSuite.reportFailLog("Select Secret key field not visible ", "selectSecretKey");
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			e.getMessage();
			throw new NoSuchElementException();
		}
	}

	public void selectSecuritytoken(String locationType) {

		try {
			String authValue = null;
			isDisplayedInLoop(driver, 2, connSecurityTokenLabel);

			javascript(driver, scrollToElementArg, connSecurityTokenLabel);

			verifyIndividualLabel(driver, connSecurityTokenLabel, ConstantProperty.CONN_FIELD_SECURITYTOKEN);

			if (isEditable(driver, connSecurityTokenField, "Select security token")) {

				BaseSuite.validationReportLog("Security token field is visible ");

				authValue = getAttribute(driver, connSecurityTokenField, valueAttribute);

				BaseSuite.reportLog("Default Security token value selected as : " + authValue);

				isDisplayedInLoop(driver, 2, flatfileSecurityTokenddb);

				if (isDisplayed(driver, flatfileSecurityTokenddb)) {

					displayAndClick(driver, flatfileSecurityTokenddb);

					BaseSuite.validationReportLog(
							"Clicked on Access key drop down  " + ConstantProperty.SUCCESSSTRING + "");

					BaseSuite.reportLog("Checking list of Security token Value visible");
					waitForExecution(2000);
					/*
					 * List<WebElement> authList = getElements(driver, connsecretPassdropdownlist);
					 * 
					 * for (int i = 0; i < authList.size(); i++) {
					 * 
					 * String authName = authList.get(i).getAttribute("textContent");
					 * 
					 * BaseSuite.reportLog((i + 1) + ". " + authName + " is visible");
					 * 
					 * }
					 */
				}
				javascript(driver, scrollToElementArg, returnElement(connselectPassword, dynamicName, locationType));

				isDisplayedInLoop(driver, 4, returnElement(connselectPassword, dynamicName, locationType));

				if (isDisplayed(driver, returnElement(connselectPassword, dynamicName, locationType))) {

					displayAndClick(driver, returnElement(connselectPassword, dynamicName, locationType));

					authValue = getAttribute(driver, connSecurityTokenField, valueAttribute);

					if (!authValue.isEmpty()) {
						BaseSuite.validationReportLog("Security token selected as : " + authValue);

					}

				} else {
					BaseSuite.reportFailLog("Expected Security token not found kindly check", "selectSecuritytoken");
				}

			} else {
				BaseSuite.reportFailLog("Select Security token field not visible ", "selectSecuritytoken");
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			e.getMessage();
			throw new NoSuchElementException();
		}
	}

	public boolean testFlatFileNativeConnectionUsingIcedqUser(ConnectionPoJO connParam, String icedqUser) {
		boolean flag = false;

		try {

			switch (connParam.getType().toLowerCase().trim()) {

			case "system":

				if (!icedqUser.contains("reader")) {

					flag = testConnection(connectionTestMess);

				} else {

					flag = testConnection(forbiddenToastMsg);

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

	/** create xml file connector **/

	public boolean createXmlFileConnection(String connJsonEntity, String testScenario, String validationMessage,
			String icedqUser) {

		boolean flag = true;
		String newconnectionName = null;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME;

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			flag = clickOnNewConnectionBtn(icedqUser);

			if (flag) {

				chooseConnectorType(connParam.getConnectorID());

				inVisible(driver, spinner, Constant.ruleWait);

				String wizardStatus = validateNewConnPageButtonsFields(connParam.getConnectorID());

				if (wizardStatus.contains("Wizard supported connector")) {

					verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", false);
				}

				verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

				verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);

				verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

				verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", false);

				verifyVisibilityOfButtons(driver, connUploadFilesButton, "Upload Files Button", false);

				verifyVisibilityOfButtons(driver, moreButton, "More Button", false);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				flag = enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

				if (flag) {

					if ((connParam.getConnectorID().toLowerCase().equalsIgnoreCase("flat-file-sql"))
							|| (connParam.getConnectorID().toLowerCase().equalsIgnoreCase("xml"))
							|| (connParam.getConnectorID().toLowerCase().equalsIgnoreCase("json"))) {

						selectDriverOfFlatFileNativeConnection(connParam.getDriverName());
					}

					selectLocationOfFlatFileNativeConnection(connParam.getServiceProviderName(), connParam);

					switch (connParam.getServiceProviderName().trim().toLowerCase()) {

					case "local":

						enterFolderPathForFileConnection(connParam.getFolderPath());

						break;

					case "s3":

						if ((connParam.getConnectorID().toLowerCase().equalsIgnoreCase("flat-file"))) {

							selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());
						}

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

						selectConnectionType(chooseConnType, connParam.getType());

						break;

					case "azure blob":

						if ((connParam.getConnectorID().toLowerCase().equalsIgnoreCase("flat-file"))) {

							selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());
						}

						selectAuthenticationOfConnection(connParam.getAuthenticationname());

						validatAndeEnterValueToTextField(connFlatFileContainerLabel, connFlatFileContainerField,
								ConstantProperty.CONN_FIELD_CONTAINER, containerPlaceHolder, connParam.getContainer(),
								containerEmptyValidationMsg);

						validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,
								ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder,
								connParam.getFolderPath(), folderPathEmptyValidationMsg);

						selectConnectionType(chooseConnType, connParam.getType());

						break;

					default:

						break;

					}
					if ((!connParam.getConnectorID().toLowerCase().equalsIgnoreCase("flat-file"))) {
						ArrayList<String> connPropertyList = TestDataThroughApi
								.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

						int count = connPropertyList.size();

						addConnectionPropertiesToXMLConnection(connJsonEntity, count);
					}
					flag = updateSystemAndUserConnectionCredentials(connJsonEntity, connParam, newconnectionName,
							icedqUser);

				}

			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog("Connection not created properly due to exception kindly check " + e.toString());
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
				if (!expectedValue.isBlank()) {
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

		return flag;
	}

	/** View Flat file native connection using API test data **/

	public boolean viewFlatFileNativeConnectionMethod(String connJsonEntity, String driverName) {
		boolean flag = true;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);

			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			waitForExecution(2000);

			verifyVisibilityOfButtons(driver, connSaveBtn, ConstantProperty.COMMON_BUTTON_SAVE, false);

			verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				inVisible(driver, spinner, Constant.ruleWait);

				verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", true);

				verifyVisibilityOfButtons(driver, connTestBtn, ConstantProperty.COMMON_BUTTON_TEST, true);

				verifyVisibilityOfButtons(driver, connUploadFilesButton, "Upload Files Button", false);

				isDisplayed(driver, moreButton);

				verifyVisibilityOfButtons(driver, moreButton, "More Button", true);

				click(driver, moreButton);

				verifyVisibilityOfButtons(driver, connFileDuplicateButton, ConstantProperty.COMMON_BUTTON_DUPLICATE,
						true);

				verifyVisibilityOfButtons(driver, enableUploadButton, ConstantProperty.COMMON_BUTTON_ENABLEUPLOAD,
						true);

				viewAndValidateConnectionField(connName, "Connection Name",
						connParam.getConnName() + "_" + ConstantProperty.TARGET_WORKSPACE_NAME, true);

				if (!driverName.isEmpty()) {

					viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, true);
				}
				viewAndValidateConnectionField(connFlatFileLocationField, ConstantProperty.CONN_FIELD_LOCATION,
						connParam.getServiceProviderName(), true);

				switch (connParam.getServiceProviderName().trim().toLowerCase()) {

				case "local":

					if (connParam.getConnectorID().toLowerCase().equalsIgnoreCase("excel")) {

						viewAndValidateConnectionField(connFlatFileFolderPathField, "Folder Path ",
								connParam.getFolderPath(), true);

						viewAndValidateConnectionField(connExcelTestFileField, "Test File", connParam.getTestFile(),
								true);

					} else {

						viewAndValidateConnectionField(connFlatFileFolderPathField, "Folder Path ",
								connParam.getFolderPath(), true);
					}

					break;

				case "s3":

					if ((connParam.getConnectorID().toLowerCase().equalsIgnoreCase("flat-file"))) {

						viewAndValidateConnectionField(connFlatFileTypeField, ConstantProperty.CONN_FIELD_FILETYPE,
								connParam.getFileType(), true);
					}
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

					if (connParam.getAuthenticationname().toLowerCase().contains("custom credential")) {

						validatAndeEnterValueToTextField(connSessionTokenLabel, connSessionTokenField,
								ConstantProperty.CONN_FIELD_SESSIONTOKEN, connSessionTokenPlaceholder, "",
								connSessionTokenPlaceholder);

					}

					break;

				case "azure blob":

					if ((connParam.getConnectorID().toLowerCase().equalsIgnoreCase("flat-file"))) {

						viewAndValidateConnectionField(connFlatFileTypeField, ConstantProperty.CONN_FIELD_FILETYPE,
								connParam.getFileType(), true);
					}
					viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
							connParam.getAuthenticationname(), true);

					viewAndValidateConnectionField(connFlatFileContainerField, ConstantProperty.CONN_FIELD_CONTAINER,
							connParam.getContainer(), true);

					viewAndValidateConnectionField(connFlatFileFolderPathField, ConstantProperty.CONN_FIELD_FOLDERPATH,
							connParam.getFolderPath(), true);

					validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
							ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, "",
							accountNameEmptyValidationMsg);

					if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {

						validatAndeEnterValueToTextField(connFlatFileAccountKeyLabel, connFlatFileAccountKeyField,
								ConstantProperty.CONN_FIELD_ACCOUNTKEY, accountKeyPlaceHolder, "",
								accountKeyEmptyValidationMsg);

					} else {

						validatAndeEnterValueToTextField(connSecurityTokenLabel, connSecurityTokenField,
								ConstantProperty.CONN_FIELD_SECURITYTOKEN, connSecurityTokenPlaceholder, "",
								connSecurityTokenPlaceholder);

					}
					break;

				default:

					break;
				}

			} else {

				inVisible(driver, spinner, Constant.ruleWait);

				String selectedSecret = getAttribute(driver, connsecretName, "value");

				if (selectedSecret.isEmpty()) {

					verifyVisibilityOfButtons(driver, connTestBtn, ConstantProperty.COMMON_BUTTON_TEST, false);

				} else {

					verifyVisibilityOfButtons(driver, connTestBtn, ConstantProperty.COMMON_BUTTON_TEST, true);

				}

				viewAndValidateConnectionField(connName, "Connection Name",
						connParam.getConnName() + "_" + ConstantProperty.TARGET_WORKSPACE_NAME, false);

				if (!driverName.isEmpty()) {

					viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, false);
				}

				viewAndValidateConnectionField(connFlatFileLocationField, ConstantProperty.CONN_FIELD_LOCATION,
						connParam.getServiceProviderName(), false);

				if (connParam.getConnectorID().toLowerCase().equals("flat-file")) {

					viewAndValidateConnectionField(connFlatFileTypeField, ConstantProperty.CONN_FIELD_FILETYPE,
							connParam.getFileType(), false);
				}

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

					if (connParam.getAuthenticationname().toLowerCase().contains("custom credential")) {

						viewAndValidateConnectionField(connSessionTokenLabel, ConstantProperty.CONN_FIELD_SESSIONTOKEN,
								"", true);
					}

				} else {
					viewAndValidateConnectionField(connFlatFileAccountNameField,
							ConstantProperty.CONN_FIELD_ACCOUNTNAME, "", true);

					if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {

						viewAndValidateConnectionField(connFlatFileAccountKeyLabel,
								ConstantProperty.CONN_FIELD_ACCOUNTKEY, "", true);

					} else {
						viewAndValidateConnectionField(connSecurityTokenField,
								ConstantProperty.CONN_FIELD_SECURITYTOKEN, "", true);

					}
				}
			}

			if ((!connParam.getConnectorID().toLowerCase().equalsIgnoreCase("flat-file"))) {

				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

				int count = connPropertyList.size();

				flag = viewAndValidateConnectionPropertiesToConnection(connJsonEntity, count);
			}
		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog("Connection not visible properly due to exception kindly check " + e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;
	}

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
					waitForExecution(2000);
					List<WebElement> authList = getElements(driver, connFlatFileLocationDDList);

					for (int i = 0; i < authList.size(); i++) {

						String authName = authList.get(i).getAttribute("data-value");

						BaseSuite.reportLog((i + 1) + ". " + authName + " is visible");

					}
				}

				isDisplayedInLoop(driver, 4, returnElement(connselectLocation, dynamicName, fileType));

				if (isDisplayed(driver, returnElement(connselectLocation, dynamicName, fileType))) {

					displayAndClick(driver, returnElement(connselectLocation, dynamicName, fileType));

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

	public boolean updateFlatFileSystemConnection(ConnectionPoJO connParam, String updateConnectionName,
			String accessKey, String secretKey, String accountName, String accountKey, String securityToken,
			String icedqUser) {
		boolean flag = false;

		try {
			viewAndValidateConnectionField(connName, "Connection Name",
					connParam.getConnName() + "_" + ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER, true);

			/** enterConnectionName(updateConnectionName); **/

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

				selectConnectionType(chooseConnType, connParam.getType());

				validatAndeEnterValueToTextField(connFlatFileAccesskeyLabel, connFlatFileAccesskeyField,
						ConstantProperty.CONN_FIELD_ACCESSKEY, accesskeyPlaceHolder, accessKey,
						accesskeyEmptyValidationMsg);

				validatAndeEnterValueToTextField(connFlatFileSecretkeyLabel, connFlatFileSecretkeyField,
						ConstantProperty.CONN_FIELD_SECRETKEY, secretkeyPlaceHolder, secretKey,
						secretkeyEmptyValidationMsg);

				if (connParam.getAuthenticationname().toLowerCase().contains("custom credential")) {

					validatAndeEnterValueToTextField(connSessionTokenLabel, connSessionTokenField,
							ConstantProperty.CONN_FIELD_SECRETKEY, connSessionTokenPlaceholder, secretKey,
							connSessionTokenEmpty);

				}
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

				selectConnectionType(chooseConnType, connParam.getType());

				validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
						ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, accountName,
						accountNameEmptyValidationMsg);

				if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {

					validatAndeEnterValueToTextField(connFlatFileAccountKeyLabel, connFlatFileAccountKeyField,
							ConstantProperty.CONN_FIELD_ACCOUNTKEY, accountKeyPlaceHolder, accountKey,
							accountKeyEmptyValidationMsg);

				} else {

					validatAndeEnterValueToTextField(connSecurityTokenLabel, connSecurityTokenField,
							ConstantProperty.CONN_FIELD_ACCOUNTKEY, connSecurityTokenPlaceholder, securityToken,
							connSecurityTokenEmpty);

				}
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

	public boolean updateFlatFileUserConnection(String connJsonEntity, String accountName, String icedqUser,
			String testScenario, String validationMessage) {
		boolean flag = true;
		String newconnectionName = null;
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

			clickOnConnectionsTab();

			if (icedqUser.contains("owner")) {
				searchAndClickOnConnectionNameInConnRepo(connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
						+ ConstantProperty.TARGET_WORKSPACE_NAME);
			} else {
				searchAndClickOnConnectionNameInConnRepo(connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
						+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault");

			}

			enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

			selectLocationOfFlatFileNativeConnection(connParam.getServiceProviderName(), connParam);

			if ((connParam.getConnectorID().toLowerCase().equalsIgnoreCase("flat-file"))) {

				selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());
			}

			viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
					connParam.getAuthenticationname(), true);

			selectAuthenticationOfConnection(connParam.getAuthenticationname());

			validatAndeEnterValueToTextField(connFlatFileContainerLabel, connFlatFileContainerField,
					ConstantProperty.CONN_FIELD_CONTAINER, containerPlaceHolder, connParam.getContainer(),
					containerEmptyValidationMsg);

			validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,
					ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder, connParam.getFolderPath(),
					folderPathEmptyValidationMsg);
			if (connParam.getServiceProviderName().trim().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)) {

				validatAndeEnterValueToTextField(connFlatFileRegionLabel, connFlatFileRegionField,
						ConstantProperty.CONN_FIELD_REGION, regionPlaceHolder, connParam.getRegionValue(),
						regionEmptyValidationMsg);
			}
			selectConnectionType(chooseConnType, connParam.getType());
			if (icedqUser.contains("owner")) {
				saveConnection();

			} else {
				saveConnection(forbiddenToastMsg);
			}

			clickOnUserConnectionTab();

			searchAndClickOnConnectionNameInConnRepo(newconnectionName);

			if (connParam.getServiceProviderName().trim().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)) {

				if (connParam.getAuthenticationname().toLowerCase().contains("custom credential")) {

					// validatAndeEnterValueToTextField(connSessionTokenLabel,
					// connSessionTokenField,ConstantProperty.CONN_FIELD_SECRETKEY,
					// connSessionTokenPlaceholder, secretKey,connSessionTokenEmpty);

				}
			} else if (connParam.getServiceProviderName().trim()
					.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {

				validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
						ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, accountName,
						accountNameEmptyValidationMsg);

				if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {

					entersecretPassword(connJsonEntity, connParam.getAuthenticationname(), connParam.getConnectorID(),
							icedqUser);
				} else {

					entersecretPassword(connJsonEntity, connParam.getAuthenticationname(), connParam.getConnectorID(),
							icedqUser);

				}
				if (icedqUser.contains("owner")) {
					flag = saveConnection();
				} else {
					flag = saveConnection(forbiddenToastMsg);
				}
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

	/** Update Flat file native connection using API test data **/
	public boolean updateFlatFileNativeConnectionMethod(String connJsonEntity, String icedqUser) {
		boolean flag = true;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);

			waitForExecution(4000);

			// String timestamp = new
			// SimpleDateFormat(ConstantProperty.CONNECTIONNAME_TIMESTAMPFORMAT).format(new
			// Date());

			String updateConnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME;

			String accessKey = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 3);

			String secretKey = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 4);

			String accountName = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 5);

			String accountKey = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 6);

			String securityToken = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 8);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				flag = updateFlatFileSystemConnection(connParam, updateConnectionName, accessKey, secretKey,
						accountName, accountKey, securityToken, icedqUser);

			} else if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				flag = updateFlatFileUserConnection(connJsonEntity, accountName, icedqUser,
						ConstantProperty.TEST_SCENARIO_VALID, "");
			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog("Connection not updated properly due to exception kindly check " + e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;
	}

	public boolean updateXmlFileConnection(String connJsonEntity, String driverName, String testScenario,
			String validationMessage, String icedqUser) {

		boolean flag = true;
		String newconnectionName = null;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				String wizardStatus = validateExistingConnPageButtonsFields(connJsonEntity);

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

				viewAndValidateConnectionField(connName, "Connection Name",
						connParam.getConnName() + "_" + ConstantProperty.TARGET_WORKSPACE_NAME, true);

				flag = enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

				if (flag) {

					if (!driverName.isEmpty()) {

						viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, true);

						selectDriverOfFlatFileNativeConnection(connParam.getDriverName());
					}

					String locationName = setServiceProvidertoLocation(connParam.getServiceProviderName());

					viewAndValidateConnectionField(connFlatFileLocationField, ConstantProperty.CONN_FIELD_LOCATION,
							locationName, true);

					selectLocationOfFlatFileNativeConnection(locationName, connParam);

					switch (connParam.getServiceProviderName().trim().toLowerCase()) {

					case "local":

						if (connParam.getConnectorID().toLowerCase().equalsIgnoreCase("excel")) {

							viewAndValidateConnectionField(connFlatFileFolderPathField, "Folder Path ",
									connParam.getFolderPath(), true);

							enterFolderPathForFileConnection(connParam.getFolderPath());

							viewAndValidateConnectionField(connExcelTestFileField, "Test File", connParam.getTestFile(),
									true);

							enterTestFileForExcelConnection(connParam.getTestFile());

						} else {

							viewAndValidateConnectionField(connFlatFileFolderPathField, "Folder Path ",
									connParam.getFolderPath(), true);

							enterFolderPathForFileConnection(connParam.getFolderPath());
						}

						break;

					case "s3":

						String secretKey = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 4);

						if ((connParam.getConnectorID().toLowerCase().equalsIgnoreCase("flat-file"))) {

							selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());
						}

						viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
								connParam.getAuthenticationname(), true);

						selectAuthenticationOfConnection(connParam.getAuthenticationname());

						viewAndValidateConnectionField(connFlatFileContainerField,
								ConstantProperty.CONN_FIELD_CONTAINER, connParam.getContainer(), true);

						validatAndeEnterValueToTextField(connFlatFileContainerLabel, connFlatFileContainerField,
								ConstantProperty.CONN_FIELD_CONTAINER, containerPlaceHolder, connParam.getContainer(),
								containerEmptyValidationMsg);

						viewAndValidateConnectionField(connFlatFileFolderPathField,
								ConstantProperty.CONN_FIELD_FOLDERPATH, connParam.getFolderPath(), true);

						validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,
								ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder,
								connParam.getFolderPath(), folderPathEmptyValidationMsg);

						viewAndValidateConnectionField(connFlatFileRegionField, ConstantProperty.CONN_FIELD_REGION,
								connParam.getRegionValue(), true);

						validatAndeEnterValueToTextField(connFlatFileRegionLabel, connFlatFileRegionField,
								ConstantProperty.CONN_FIELD_REGION, regionPlaceHolder, connParam.getRegionValue(),
								regionEmptyValidationMsg);

						selectConnectionType(chooseConnType, connParam.getType());

						entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
								connParam.getConnectorID(), icedqUser);

						if (connParam.getAuthenticationname().toLowerCase().contains("custom credential")) {
							validatAndeEnterValueToTextField(connSessionTokenLabel, connSessionTokenField,
									ConstantProperty.CONN_FIELD_SESSIONTOKEN, connSessionTokenPlaceholder, secretKey,
									connSecurityTokenEmpty);
						}
						break;

					case "azure blob":

						String accountName = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 5);

						if ((connParam.getConnectorID().toLowerCase().equalsIgnoreCase("flat-file"))) {

							selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());
						}

						viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
								connParam.getAuthenticationname(), true);

						selectAuthenticationOfConnection(connParam.getAuthenticationname());

						viewAndValidateConnectionField(connFlatFileContainerField,
								ConstantProperty.CONN_FIELD_CONTAINER, connParam.getContainer(), true);

						validatAndeEnterValueToTextField(connFlatFileContainerLabel, connFlatFileContainerField,
								ConstantProperty.CONN_FIELD_CONTAINER, containerPlaceHolder, connParam.getContainer(),
								containerEmptyValidationMsg);

						viewAndValidateConnectionField(connFlatFileFolderPathField,
								ConstantProperty.CONN_FIELD_FOLDERPATH, connParam.getFolderPath(), true);

						validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,
								ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder,
								connParam.getFolderPath(), folderPathEmptyValidationMsg);

						selectConnectionType(chooseConnType, connParam.getType());

						validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
								ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, accountName,
								accountNameEmptyValidationMsg);

						if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {

							entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);

						} else {

							entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);

						}

						break;

					default:

						break;

					}
					ArrayList<String> connPropertyList = TestDataThroughApi
							.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

					int count = connPropertyList.size();

					updateConnectionPropertiesToXMLConnection(connJsonEntity, count);

					if (icedqUser.contains("owner")) {

						flag = saveConnection();
						waitForExecution(1000);
						flag = testConnection(connectionTestMess);

						clickOnConnectionsTab();

						if (connParam.getConnectorID().toLowerCase().equalsIgnoreCase("excel")) {

							searchAndClickOnConnectionNameInConnRepo(newconnectionName);

							BaseSuite.reportLog(
									"---Update Location scenario start - Only check all fields are displayed or not because Amazon S3 is not able to test on OnPrem---");

							viewAndValidateConnectionField(connName, "Connection Name",
									connParam.getConnName() + "_" + ConstantProperty.TARGET_WORKSPACE_NAME + "_vault",
									true);

							flag = enterConnectionNameWithValidation(newconnectionName, testScenario,
									validationMessage);

							if (flag) {

								if (!driverName.isEmpty()) {

									viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, true);

									selectDriverOfFlatFileNativeConnection(connParam.getDriverName());
								} else {

									flag = saveConnection();
									waitForExecution(1000);
									flag = testConnection(connectionTestMess);

									clickOnConnectionsTab();
								}

								viewAndValidateConnectionField(connFlatFileLocationField,
										ConstantProperty.CONN_FIELD_LOCATION, connParam.getServiceProviderName(), true);

								selectLocationOfFlatFileNativeConnection("Amazon S3", connParam);

								viewAndValidateConnectionField(connAuthTypeField, "Authentication", "AWS EC2 Role",
										true);

								viewAndValidateConnectionField(connFlatFileContainerField, "Container", "", true);

								viewAndValidateConnectionField(connFlatFileFolderPathField, "Folder Path ",
										connParam.getFolderPath(), true);

								viewAndValidateConnectionField(connFlatFileRegionField, "Region", "", true);

								viewAndValidateConnectionField(connExcelTestFileField, "Test File",
										connParam.getTestFile(), true);

								viewAndValidateConnectionField(connTypeField, "Type", "", false);

								validatediscardBtn();

								clickOnButton(driver, discardpopupdiscardbtn, "Discard", true);

								viewFlatFileNativeConnectionMethod(connJsonEntity, driverName);

							}

						} else {
						}

					} else {

						flag = saveConnection(forbiddenToastMsg);
					}
				}

			} else {

				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

				int count = connPropertyList.size();

				updateConnectionPropertiesToXMLConnection(connJsonEntity, count);

				updateFlatFileNativeConnectionMethod(connJsonEntity, icedqUser);
			}
		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog("Connection not created properly due to exception kindly check " + e.toString());
		}

		return flag;

	}

	/** Test Flat file native connection using API test data **/
	public boolean testFlatFileNativeConnectionMethod(String connJsonEntity, String icedqUser) {
		boolean flag = false;
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);

			waitForExecution(3000);
			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				// viewDatabaseConnection(connJsonEntity, driverName);

				if (!icedqUser.contains("reader")) {

					waitForExecution(2000);

					flag = testConnection(connectionTestMess);

				} else {
					flag = testConnection(forbiddenToastMsg);
				}
			} else {

				// viewDatabaseConnection(connJsonEntity, driverName);

				// if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE))
				if ((icedqUser.contains("contributor")) || (icedqUser.contains("executor"))) {

					String accountName = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 5);

					if (connParam.getServiceProviderName().equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_S3)) {

						entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
								connParam.getConnectorID(), icedqUser);

					} else if (connParam.getServiceProviderName()
							.equalsIgnoreCase(ConstantProperty.CONN_FLATFILE_AZURE)) {

						validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
								ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, accountName,
								accountNameEmptyValidationMsg);

						if (connParam.getAuthenticationname().toLowerCase().contains("access key")) {

							entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);

						} else {

							entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);
						}
					}
					saveConnection();

					waitForExecution(1000);

					inVisible(driver, spinner, Constant.ruleWait);

					flag = testConnection(connectionTestMess);

				} else if (icedqUser.contains("owner")) {
					flag = testConnection(connectionTestMess);

				}
				if (icedqUser.contains("owner")) {

					flag = testConnection(connectionTestMess);

				} else {

					if (icedqUser.contains("reader")) {
						waitForExecution(1000);
						flag = clickQuickAddbtn(forbiddenToastMsg);
					}
				}
			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(" due to exception kindly check  " + e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;
	}

	/** Delete Flat file native connection using API test data **/
	public boolean deleteFlatFileNativeConnectionMethod(String connJsonEntity, String driverName, String icedqUser) {
		boolean flag = true;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);

			waitForExecution(3000);

			// viewFlatFileNativeConnectionMethod(connJsonEntity, driverName);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				clickOnConnectionsTab();

				searchAndClickOnConnectionNameInConnRepo(connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
						+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault");

				inVisible(driver, spinner, Constant.ruleWait);
				waitForExecution(2000);

			}

			if (icedqUser.contains("owner")) {

				flag = clickOnDeleteButton(connSingleDeleteToastMsg, 1);

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

	/** Duplicate Flat file native connection using API test data **/
	public boolean duplicateFlatFileNativeConnectionMethod(String connJsonEntity, String driverName, String icedqUser) {
		boolean flag = false;
		String name = null;
		try {

			// viewFlatFileNativeConnectionMethod(connJsonEntity, driverName);

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);
			waitForExecution(3000);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				clickOnConnectionsTab();

				searchAndClickOnConnectionNameInConnRepo(connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
						+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault");

				inVisible(driver, spinner, Constant.ruleWait);
				waitForExecution(2000);
			}
			if (icedqUser.contains("owner")) {

				flag = clickOnDuplicateConnectionForFile(connDupllicateToastMsg);
				inVisible(driver, spinner, Constant.ruleWait);

				inVisible(driver, spinner, Constant.ruleWait);
				waitForExecution(2000);

				if (flag) {
					name = getAttribute(driver, connName, valueAttribute);

					clickOnConnectionsTab();

					flag = searchConnection(name);
				}
			} else {
				flag = clickOnDuplicateConnectionForFile(forbiddenToastMsg);
			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog("due to exception kindly check " + e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;
	}

	/** Duplicate File connection method To use Duplicated connection in Update **/
	public boolean duplicateFileConnectionMethodNew(String connJsonEntity, String driverName, String icedqUser) {
		boolean flag = false;
		String name = null;
		String newconnectionName = null;
		try {

			// viewFlatFileNativeConnectionMethod(connJsonEntity, driverName);

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);
			waitForExecution(3000);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME;

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				clickOnConnectionsTab();

				searchAndClickOnConnectionNameInConnRepo(connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
						+ ConstantProperty.TARGET_WORKSPACE_NAME);

				inVisible(driver, spinner, Constant.ruleWait);

				String connName1;

				waitForExecution(2000);

				if ((!icedqUser.contains("owner"))) {

					connName1 = newconnectionName;
				} else {
					connName1 = newconnectionName;
				}
				searchAndClickOnConnectionNameInConnRepo(connName1);

				inVisible(driver, spinner, Constant.ruleWait);

				waitForExecution(1000);

				flag = clickOnDuplicateConnectionForFile(connDupllicateToastMsg);

				if (flag) {
					if (isDisplayed(driver, connName)) {
						duplicateConnName = getAttribute(driver, connName, valueAttribute);
					} else {
						clickOnOverviewTab();
						duplicateConnName = getAttribute(driver, connName, valueAttribute);
					}
				}

			}

			if (icedqUser.contains("owner")) {

				flag = clickOnDuplicateConnectionForFile(connDupllicateToastMsg);

				inVisible(driver, spinner, Constant.ruleWait);

				waitForExecution(1000);

				javascript(driver, scrollToElementArg, connName);

				if (flag) {
					if (isDisplayed(driver, connName)) {
						duplicateConnName = getAttribute(driver, connName, valueAttribute);
					} else {
						clickOnOverviewTab();
						duplicateConnName = getAttribute(driver, connName, valueAttribute);
					}
					clickOnConnectionsTab();
//				isDisplayedInLoop(driver, 0, discardButtons);
//				if (isDisplayed(driver, discardButtons)) {
//					displayAndClick(driver, discardButtons);
//				}

					waitForExecution(2000);

					searchConnection(duplicateConnName);

					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						getConnection(duplicateConnName, create_actualValue);

					} else {
						getConnection(duplicateConnName, update_actualValue);
					}

					flag = searchAndClickOnConnectionNameInConnRepo(duplicateConnName);
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

	/** Connection property for xml connection **/

	public void selectConnectionPropertyName(String connPropName) {
		Actions action = new Actions(driver);
		try {
			if (isDisplayed(driver, addpropertyNameInput)) {

				BaseSuite.reportLog("Property name input box is displayed.");

				if (!connPropName.isEmpty()) {

					// WebElement s1 = driver.findElement(addpropertyNameInput);

					// action.click(s1).build().perform();

					displayAndClick(driver, addpropertyNameInput);

					// WebElement s2 = driver.findElement(popUpOpenInput);

					// action.click(s2).build().perform();
					// WebElement s1 = driver.findElement(addpropertyNameInput);

					// action.click(s1).build().perform();

					displayAndClick(driver, addpropertyNameInput);

					// WebElement s2 = driver.findElement(popUpOpenInput);

					// action.click(s2).build().perform();


					isDisplayedInLoop(driver, 5, returnElement(connPropNameDynamic, dynamicName, connPropName));

					if (isDisplayed(driver, returnElement(connPropNameDynamic, dynamicName, connPropName))) {

						displayAndClick(driver, returnElement(connPropNameDynamic, dynamicName, connPropName));

						isDisplayedInLoop(driver, 5, addpropertyNameInput);

						String acrg = getAttribute(driver, addedpropertyNameInputText, valueAttribute);

						if (acrg.equalsIgnoreCase(connPropName)) {

							BaseSuite.reportLog(connPropName + " is selected in to property name");

						} else {
							BaseSuite.reportFailLog("Connection property not selected kindly check",
									"selectConnectionPropertyKey");
						}
					}

				} else {
					BaseSuite.reportErrorLog("Property name parameter is empty, kindly check.");
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate property name input field , kindly check.",
						"addConnectionPropertyName");
			}

		} catch (Exception e) {

			BaseSuite.reportErrorLog("Error while selecting connection property kindly check :: " + e.toString());

		}
	}

	// method to add connection properties to connection
	public void addConnectionPropertiesToXMLConnection(String jsonEntity, int count) throws NullPointerException {
		try {
			if (count > 0) {
				clickOnPropertiesTab();
				inVisible(driver, spinner, 30);
				ArrayList<String> name = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..name");

				ArrayList<String> value = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..value");

				ArrayList<String> type = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..type");

				for (int j = 0; j < name.size(); j++) {
					if (name.get(j).contains("timeout")) {

						validateDefaultConnectionProperty(name.get(j), value.get(j), type.get(j));

					} else {

						addConnectionPropertyToXml(name.get(j), value.get(j), type.get(j));
					}
				}

				clickOnOverviewTab();

			}

		} catch (Exception e) {
			e.getMessage();
			throw new NullPointerException();

		}
	}

	// method to add connection properties to connection
	public void addConnectionPropertiesToExcelConnection(String jsonEntity, int count) throws NullPointerException {

		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(jsonEntity);

			String serviceProvider = connParam.getServiceProviderName();

			if (count > 0) {
				clickOnPropertiesTab();
				inVisible(driver, spinner, 30);
				ArrayList<String> name = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..name");

				ArrayList<String> value = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..value");

				ArrayList<String> type = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..type");

				for (int j = 0; j < name.size(); j++) {

					if (name.get(j).contains("timeout")) {

						validateDefaultConnectionProperty(name.get(j), value.get(j), type.get(j));

					} else {
						if (serviceProvider.equalsIgnoreCase("local")) {

							addCustomConnectionPropertyFile(name.get(j), value.get(j), type.get(j));

						} else {

							addConnectionPropertyToXml(name.get(j), value.get(j), type.get(j));

						}

					}
				}

				clickOnOverviewTab();

			}

		} catch (Exception e) {
			e.getMessage();
			throw new NullPointerException();

		}
	}

	// method to add connection properties to connection in invalid scenario
	public void addConnectionPropertiesToExcelConnectionInvalid(String jsonEntity, int count, String scenario,
			String fieldname) throws NullPointerException {

		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(jsonEntity);

			String serviceProvider = connParam.getServiceProviderName();

			if (count > 0) {
				clickOnPropertiesTab();
				inVisible(driver, spinner, 30);
				ArrayList<String> name = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..name");

				ArrayList<String> value = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..value");

				ArrayList<String> type = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..type");

				for (int j = 0; j < name.size(); j++) {

					if (name.get(j).contains("timeout")) {

						validateDefaultConnectionProperty(name.get(j), value.get(j), type.get(j));

					} else {
						if (serviceProvider.equalsIgnoreCase("local")) {

							addConnectionProperty1(name.get(j), value.get(j), type.get(j), scenario, fieldname);

						} else {

							addConnectionPropertyToXml(name.get(j), value.get(j), type.get(j));

						}

					}
				}

				clickOnOverviewTab();

			}

		} catch (Exception e) {
			e.getMessage();
			throw new NullPointerException();

		}
	}

	public void addConnectionPropertyToXml(String name, String value, String type) {

		try {

			clickOnAddPropertybutton();

			enterCustomConnPropertyName(name.trim());

			// selectConnectionPropertyName(name.trim());

			enterConnPropertyValue(value.trim());

			selectConnectionType(propConnType, type.trim());

			clickonAddPropertyIconButton();

		} catch (Exception e) {

			e.getMessage();
		}

	}

	/** update connection property common method **/
	public boolean updateConnectionPropertiesToXMLConnection(String jsonEntity, int count) throws Exception {
		boolean flag = true;
		String dynamicVar = "$num";
		String namefield = "Name";
		String valueField = "Value";
		String typeField = "Type";
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

				String connectionType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, connConnectionTypes);


				if (connectionType.equalsIgnoreCase("User")) {


					driver.findElements(rowDisabled);

					BaseSuite.reportLog("Property name ,value and Type are dis-abled.");


				} else {

					int b = 1;

					int a = 1;
					for (int j = 0; j < name.size(); j++) {
						a = a + j;
						if (connectionType.toLowerCase().contains("system")) {

							javascript(driver, scrollToElementArg,
									returnElement(connPropertyEditButton, "$name", name.get(j)));

							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, dynamicVar,
									Integer.toString(a), dynamicName, name.get(j)), name.get(j));
							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, dynamicVar,
									Integer.toString(a), dynamicName, value.get(j)), value.get(j));
							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, dynamicVar,
									Integer.toString(a), dynamicName, type.get(j)), type.get(j));

							flag = clickOnButton(driver, returnElement(connPropertyEditButton, "$name", name.get(j)),
									"Edit", true);

							if (flag) {
								if (!type.get(j).trim().equalsIgnoreCase("user")) {
									// selectConnectionPropertyName(name.get(j));
								}

								enterCustomConnPropertyName(name.get(j));

								updateConnectionPropertyField(returnTwoElements(connPropCommonFieldUpdate, dynamicVar,
										Integer.toString(b), dynamicName, "value"), value.get(j));

								if (!type.get(j).trim().equalsIgnoreCase("user")) {

									selectConnectionType(propConnType, type.get(j).trim());
								}
								flag = clickOnButton(driver,

										returnElement(connPropertySaveButton, dynamicVar, Integer.toString(a)), "Save", true);
							}

						}else
						{
							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, dynamicVar,
									Integer.toString(a), dynamicName, namefield), name.get(j));
							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, dynamicVar,
									Integer.toString(a), dynamicName, valueField), value.get(j));
							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, dynamicVar,
									Integer.toString(a), dynamicName, typeField), type.get(j));

						}
					}

				}
				clickOnOverviewTab();
			}

		} catch (Exception e) {
			flag = false;
			e.getMessage();

		}
		return flag;
	}

	public ConnectionPoJO setConnectionParametersForInvalidScenario(String fileName, String sheetName, int rowNumber,
			String connectorType) {
		ConnectionPoJO connectionparam = new ConnectionPoJO();
		XLUtils xl = new XLUtils();

		try {

			connectionparam.setTestScenario(xl.readUsingColName(fileName, sheetName, rowNumber, "TestScenario"));
			connectionparam.setFieldName(xl.readUsingColName(fileName, sheetName, rowNumber, "FieldName"));
			connectionparam.setConnectionJsonValue(
					xl.readUsingColName(fileName, sheetName, rowNumber, "ConnectionJsonForLocal"));
			connectionparam
					.setValidationMessage(xl.readUsingColName(fileName, sheetName, rowNumber, "OnFieldValidation"));
			connectionparam
					.setOnSaveValidation(xl.readUsingColName(fileName, sheetName, rowNumber, "OnSaveValidation"));
			connectionparam
					.setOnTestValidation(xl.readUsingColName(fileName, sheetName, rowNumber, "OnTestValidation"));
			connectionparam.setConnectionJsonValueS3(
					xl.readUsingColName(fileName, sheetName, rowNumber, "ConnectionJsonForS3"));
			connectionparam.setConnectionJsonValueAzure(
					xl.readUsingColName(fileName, sheetName, rowNumber, "ConnectionJsonForAzure"));
			connectionparam.setType(xl.readUsingColName(fileName, sheetName, rowNumber, "testcasetype"));
			connectionparam.setAuthentication(xl.readUsingColName(fileName, sheetName, rowNumber, "authType"));

			switch (connectorType.toLowerCase()) {

			
			case "mariadb":
				connectionparam
						.setConnectionJsonValueLocal(xl.readUsingColName(fileName, sheetName, rowNumber, "json_MariaDB"));
				break;
			
			case "mysql":
				connectionparam
						.setConnectionJsonValueLocal(xl.readUsingColName(fileName, sheetName, rowNumber, "Json_Mysql"));
				break;

			case "postgresql":
				connectionparam
						.setConnectionJsonValueLocal(xl.readUsingColName(fileName, sheetName, rowNumber, "Json_Postgresql"));
				break;

			case "redshift":
				connectionparam
						.setConnectionJsonValueLocal(xl.readUsingColName(fileName, sheetName, rowNumber, "Json_Redshift"));
				break;

			case "db2":
				connectionparam.setConnectionJsonValueLocal(xl.readUsingColName(fileName, sheetName, rowNumber, "Json_Db2"));
				break;

			case "denodo":
				connectionparam
						.setConnectionJsonValueLocal(xl.readUsingColName(fileName, sheetName, rowNumber, "Json_Denodo"));
				break;

			case "flat-file":

				connectionparam.setConnectionJsonValue(
						xl.readUsingColName(fileName, sheetName, rowNumber, "Json_flatfileNative"));
				connectionparam.setConnectionJsonValueLocal(
						xl.readUsingColName(fileName, sheetName, rowNumber, "Json_FlatFileNative_Local"));
				connectionparam.setConnectionJsonValueS3(
						xl.readUsingColName(fileName, sheetName, rowNumber, "Json_FlatFileNative_S3"));
				connectionparam.setConnectionJsonValueAzure(
						xl.readUsingColName(fileName, sheetName, rowNumber, "Json_FlatFileNative_Azure"));
				connectionparam.setConnectionJsonValueS3User(
						xl.readUsingColName(fileName, sheetName, rowNumber, "Json_FlatFileNative_S3_User"));
				connectionparam.setConnectionJsonValueAzureUser(
						xl.readUsingColName(fileName, sheetName, rowNumber, "Json_FlatFileNative_Azure_User"));
				connectionparam.setConnectionJsonValueAzureSharedUser(
						xl.readUsingColName(fileName, sheetName, rowNumber, "Json_FlatFileNative_AzureShared_User"));
				connectionparam.setConnectionJsonValueAzureShared(
						xl.readUsingColName(fileName, sheetName, rowNumber, "Json_FlatFileNative_AzureShared"));
				
				

				break;
				
			case "flat-file-sql":

				connectionparam.setConnectionJsonValue(xl.readUsingColName(fileName, sheetName, rowNumber, "Json_flatfileSQL_Local"));
				
				connectionparam.setConnectionJsonValueS3(xl.readUsingColName(fileName, sheetName, rowNumber, "Json_flatfileSQLS3"));
				
				connectionparam.setConnectionJsonValueAzure(xl.readUsingColName(fileName, sheetName, rowNumber, "Json_flatfileSQL_Azure"));
				
				connectionparam.setConnectionJsonValueS3User(xl.readUsingColName(fileName, sheetName, rowNumber, "Json_FlatFileSQL_S3_User"));
				
				connectionparam.setConnectionJsonValueAzureUser(xl.readUsingColName(fileName, sheetName, rowNumber, "Json_FlatFileSQL_Azure_User"));
				
				connectionparam.setConnectionJsonValueAzureShared(xl.readUsingColName(fileName, sheetName, rowNumber, "Json_FlatFileSQL_AzureShared"));
				
				connectionparam.setConnectionJsonValueAzureSharedUser(xl.readUsingColName(fileName, sheetName, rowNumber,"Json_FlatFileSQL_AzureShared_User" ));
				
				
				
				

				break;

			case "xml":

				connectionparam.setConnectionJsonValue(xl.readUsingColName(fileName, sheetName, rowNumber, "Json_Xml_Local"));
				
				connectionparam.setConnectionJsonValueLocal(xl.readUsingColName(fileName, sheetName, rowNumber, "Json_Xml_Local"));
				
				connectionparam.setConnectionJsonValueS3(xl.readUsingColName(fileName, sheetName, rowNumber, "Json_Xml_S3"));
				
				connectionparam.setConnectionJsonValueS3User(xl.readUsingColName(fileName, sheetName, rowNumber, "Json_Xml_S3_User"));
				
				connectionparam.setConnectionJsonValueAzure(xl.readUsingColName(fileName, sheetName, rowNumber, "Json_Xml_Azure"));
				
				connectionparam.setConnectionJsonValueAzureUser(xl.readUsingColName(fileName, sheetName, rowNumber, "Json_Xml_Azure_User"));

				break;

			default:

				break;
			}

			return connectionparam;
		} catch (Exception e) {
			throw new NullPointerException(e.toString());
		}
	}

	/** testScenario = "Valid/Invalid" , ValidationMessage blank for valid name **/

	public boolean enterDatabaseConnectionDetailsForInvalidScenario(ConnectionPoJO connParamFromExcel,
			String testScenario, String icedqUser, String tctype, String connectionType) {
		boolean flag = true;
		boolean status1 = false;
		boolean status = false;
		String newconnectionName = null;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connParamFromExcel.getConnectionJsonValueLocal());

			newconnectionName = connParam.getConnName();

			inVisible(driver, spinner, Constant.ruleWait);

			status1 = entervalueInTextFieldWithValidation(connParam, connName, "Connection Name", newconnectionName,
					testScenario, connParamFromExcel.getValidationMessage(), true);

			if (!tctype.isEmpty()) {

				selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

				String authName = setAuthenticationType(connParam.getAuthentication());

				selectAuthenticationOfConnection(authName);

				boolean cs = selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

				inVisible(driver, spinner, Constant.ruleWait);

				selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

				switch (connParamFromExcel.getFieldName().toLowerCase().trim()) {

				case "connectionname":

					if (Boolean.parseBoolean(connParam.getCustomJdbcFullUrl())) {

						entervalueInTextFieldWithValidation(connParam, connCustomJDBCTextbox, "",
								connParam.getCustomJDBCURLValue(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
					} else {

						entervalueInTextFieldWithValidation(connParam, connHostInputField,
								ConstantProperty.CONN_FIELD_HOST, connParam.getHost(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
						entervalueInTextFieldWithValidation(connParam, connPortInputField,
								ConstantProperty.CONN_FIELD_PORT, connParam.getPort(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
						entervalueInTextFieldWithValidation(connParam, connDatabaseInputField,
								ConstantProperty.CONN_FIELD_DATABASE, connParam.getDatabaseName(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
					}
					selectConnectionType(connectionType);

					if (!connectionType.equalsIgnoreCase("user")) {

						entervalueInTextFieldWithValidation(connParam, connUsernameInput,
								ConstantProperty.CONN_FIELD_USERNAME, connParam.getUsername(), testScenario,
								connParamFromExcel.getValidationMessage(), true);

						entersecretPassword(connParamFromExcel.getConnectionJsonValue(),
								connParam.getAuthenticationname(), connParam.getConnectorID(), icedqUser);

					} else {

						viewAndValidateConnectionField(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "",
								false);
						viewAndValidateConnectionField(connPasswordInput, ConstantProperty.CONN_FIELD_PASSWORD, "",
								false);
					}

					inVisible(driver, spinner, Constant.ruleWait);

					if (icedqUser.toLowerCase().contains("owner")) {
						String saveErrorMsg = "Connection name \'" + newconnectionName + "\' already exists.";
						status = saveConnection(saveErrorMsg);

					} else {

						status = saveConnection(forbiddenToastMsg);
					}
					break;

				case "jdbcurl":
					if ((Boolean.parseBoolean(connParam.getCustomJdbcFullUrl()))) {
						selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());
						// entervalueInTextFieldWithValidation(connParam,connCustomJDBCTextbox,
						// "",connParam.getCustomJDBCURLValue(),
						// testScenario,connParamFromExcel.getValidationMessage(), true);
						status = entervalueJdbcWithValidation(connParam, connCustomJDBCTextbox,
								connParam.getCustomJDBCURLValue(), "", testScenario,
								connParamFromExcel.getValidationMessage(), true);
					}
					break;

				case "host":
					selectCustomJDBCURLOfConnection("false");
					status = entervalueInTextFieldWithValidation(connParam, connHostInputField,
							ConstantProperty.CONN_FIELD_HOST, connParam.getHost(), testScenario,
							connParamFromExcel.getValidationMessage(), true);

					break;

				case "port":
					selectCustomJDBCURLOfConnection("false");
					status = entervalueInTextFieldWithValidation(connParam, connPortInputField,
							ConstantProperty.CONN_FIELD_PORT, connParam.getPort(), testScenario,
							connParamFromExcel.getValidationMessage(), true);

					break;
				case "database":
					selectCustomJDBCURLOfConnection("false");
					status = entervalueInTextFieldWithValidation(connParam, connDatabaseInputField,
							ConstantProperty.CONN_FIELD_DATABASE, connParam.getDatabaseName(), testScenario,
							connParamFromExcel.getValidationMessage(), true);

					break;
				case "username":

					selectConnectionType(connectionType);

					if (!connectionType.equalsIgnoreCase("user")) {

						status = entervalueInTextFieldWithValidation(connParam, connUsernameInput,
								ConstantProperty.CONN_FIELD_USERNAME, connParam.getUsername(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
					} else {

						status = viewAndValidateConnectionField(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME,
								"", false);
					}
					break;

				case "propertyname":
				case "propertyvalue":
					ArrayList<String> connPropertyList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(
							connParamFromExcel.getConnectionJsonValueLocal(), connConnectionPropNames);

					int count = connPropertyList.size();

					status = addConnectionPropertiesToConnection1(connParamFromExcel.getConnectionJsonValueLocal(), count,testScenario, connParamFromExcel.getFieldName());

                    clickOnOverviewTab();

					break;

				default:
					BaseSuite.reportErrorLog(
							"Field name is not found kindly check :: " + connParamFromExcel.getFieldName());
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


	public boolean validateAndEnterUsernameAndPasswordForGrant(String connJsonEntity,boolean flag, String userName, String icedqUser,
			String validationMsg, String testScenario) {
		String UserKeytabLocation =System.getProperty("user.dir")+ Constant.USER_KEYTAB_LOCATION;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			if (connParam.getConnectorID().contains("kerberos")) {

				WebElement n = driver.findElement(By.xpath("//input[@id='keytab']"));

				n.sendKeys(UserKeytabLocation);

				BaseSuite.validationReportLog("User key tab File Choosed successfully");

				validatAndeEnterValueToTextField(connUserPrincipalLabel, connHiveUserPrincipal,ConstantProperty.CONN_FIELD_USERPRINCIPAL, connPrincipalPlaceholder,
						connParam.getUserPrincipal(), validationUserprincipal);
				
			}
			else if (flag) {
				
				flag = entervalueInTextFieldWithValidation(connParam,connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME,
						userName, testScenario, validationMsg, true);


				if (flag) {
					String a1 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity, "$.secretId");

					enterSecretName(a1);

					String a2 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity,
							"$.authConfig.password");

					selectVaultPassword(a2, ConstantProperty.CONN_FIELD_PASSWORD);
				
			     }
			}
			if (flag) {
				flag = saveConnection(forbiddenToastMsg);
			}

		} catch (Exception e) {
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" test Database connection not tested properly kindly check :" + e.toString());
		}
		return flag;
	}

	/** testScenario = "Valid/Invalid" , ValidationMessage blank for valid name **/

	public boolean enterDatabaseConnectionDetailsForInvalidScenarioToTestConnection(String connJsonEntity,
			ConnectionPoJO connParamFromExcel, String connectionName, String testScenario, String icedqUser,
			String connectionType) {
		boolean flag = true;
		boolean status = false;
		String newConnectionName = null;
		try {
 
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);
 
			// String timestamp = new
			// SimpleDateFormat(ConstantProperty.CONNECTIONNAME_TIMESTAMPFORMAT).format(new
			// Date());
 
			newConnectionName = connParam.getConnName();
 
			if (icedqUser.contains("owner")) {
 
				status = entervalueInTextFieldWithValidation(connParam, connName, "Connection Name", newConnectionName,
						testScenario, connParamFromExcel.getValidationMessage(), true);
 
				if (status) {
 
					selectDriverOfFlatFileNativeConnection(connParam.getDriverName());
 
					selectAuthenticationOfConnection(connParam.getAuthenticationname());
 
					selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());
 
					if (Boolean.parseBoolean(connParam.getCustomJdbcFullUrl())) {
 
						entervalueInTextFieldWithValidation(connParam, connCustomJDBCTextbox, "",
								connParam.getCustomJDBCURLValue(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
 
					} else {
 
						entervalueInTextFieldWithValidation(connParam, connHostInputField,
								ConstantProperty.CONN_FIELD_HOST, connParam.getHost(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
						entervalueInTextFieldWithValidation(connParam, connPortInputField,
								ConstantProperty.CONN_FIELD_PORT, connParam.getPort(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
						entervalueInTextFieldWithValidation(connParam, connDatabaseInputField,
								ConstantProperty.CONN_FIELD_DATABASE, connParam.getDatabaseName(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
 
					}
 
					selectConnectionType(connectionType);
 
					status = enterUsernamePassword(connJsonEntity, connectionType, newConnectionName, connParam,
							connParamFromExcel, testScenario, icedqUser);
 
					status = saveAndTestConnectionForInvalidScenario(icedqUser, status, connectionType);
 
					if (connectionType.equalsIgnoreCase("user")) {
						clickOnConnectionRepoBreadcrumbLink();
						searchAndClickOnConnectionNameInConnRepo(connectionName);
					}
				}
			} else if (icedqUser.contains("contributor") || icedqUser.contains("executor")) {
 
				if (!connectionType.equalsIgnoreCase("user")) {
					status = entervalueInTextFieldWithValidation(connParam, connName, "Connection Name",
							newConnectionName, testScenario, connParamFromExcel.getValidationMessage(), true);
 
					if (status) {
 
						selectDriverOfFlatFileNativeConnection(connParam.getDriverName());
 
						selectAuthenticationOfConnection(connParam.getAuthenticationname());
 
						selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());
 
						if (Boolean.parseBoolean(connParam.getCustomJdbcFullUrl())) {
 
							entervalueInTextFieldWithValidation(connParam, connCustomJDBCTextbox, "",
									connParam.getCustomJDBCURLValue(), testScenario,
									connParamFromExcel.getValidationMessage(), true);
 
						} else {
 
							entervalueInTextFieldWithValidation(connParam, connHostInputField,
									ConstantProperty.CONN_FIELD_HOST, connParam.getHost(), testScenario,
									connParamFromExcel.getValidationMessage(), true);
							entervalueInTextFieldWithValidation(connParam, connPortInputField,
									ConstantProperty.CONN_FIELD_PORT, connParam.getPort(), testScenario,
									connParamFromExcel.getValidationMessage(), true);
							entervalueInTextFieldWithValidation(connParam, connDatabaseInputField,
									ConstantProperty.CONN_FIELD_DATABASE, connParam.getDatabaseName(), testScenario,
									connParamFromExcel.getValidationMessage(), true);
 
						}
 
						selectConnectionType(connectionType);
 
						entervalueInTextFieldWithValidation(connParam, connUsernameInput,
								ConstantProperty.CONN_FIELD_USERNAME, connParam.getUsername(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
 
						entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
								connParam.getConnectorID(), icedqUser);
 
						saveConnection();
 
						captureToastMsgForConnection(driver, toastMsg, popUpClose, connectionTestMess,
								"Connection Test", false);
					}
 
				} else {
 
					clickOnUserConnectionTab();
 
					flag = searchAndClickOnConnectionNameInConnRepo(connectionName);
 
					if (flag) {
 
						flag = entervalueInTextFieldWithValidation(connParam, connUsernameInput,
								ConstantProperty.CONN_FIELD_USERNAME, connParam.getUsername(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
 
						if (flag) {
							String a1 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity,
									"$.secretId");
 
							enterSecretName(a1);
 
							String a2 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity,
									"$.authConfig.password");
 
							selectVaultPassword(a2, ConstantProperty.CONN_FIELD_PASSWORD);
 
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
			} else {
				validateAndEnterUsernameAndPasswordForGrant(connJsonEntity,flag, connParam.getUsername(),
						icedqUser, connParamFromExcel.getValidationMessage(), testScenario);
			}
 
		} catch (Exception e) {
 
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" Database connection not tested properly kindly check :" + e.toString());
		}
		return flag;
	}

	public boolean saveAndTestConnectionForInvalidScenario(String icedqUser, boolean status, String type)
			throws InterruptedException {
		boolean flag = false;
 
		try {
			if (icedqUser.toLowerCase().contains("owner")
					|| (icedqUser.toLowerCase().contains("contributor") && type.toLowerCase().contains("user"))
					|| (icedqUser.toLowerCase().contains("executor") && type.toLowerCase().contains("user"))) {
 
				if (status) {
 
					status = saveConnection();
 
					if (isDisplayed(driver, toastMsg)) {
 
						BaseSuite.reportLog("Toast message visible on save button");
 
						status = captureToastMsgForConnection(driver, toastMsg, popUpClose, connectionSaveMesssage,
								"Connection Save", true);
					}
 
					if (status) {
 
						clickOnButton(driver, connTestBtn, "Test", true);
 
						Thread.sleep(2000);
 
						inVisible(driver, spinner, Constant.ruleWait);
 
						flag = captureToastMsgForConnection(driver, toastMsg, popUpClose, connectionTestMess,
								"Connection Test", false);
					}
				}
			} else {
 
				flag = saveConnection(readerGrantErrMessage);
 
				if (flag) {
 
					clickOnButton(driver, discardButtonsDetails, "Discard", true);
 
					waitForExecution(2000);
 
					clickOnButton(driver, connTestBtn, "Test Button", true);
 
					String acMess = getText(driver, toastMsg);
 
					BaseSuite.reportLog("Toast message visible on Test button");
 
					clickOnButton(driver, connTestBtn, "Test Button", true);
 
					/*
					 * status = captureToastMsgForConnection(driver, toastMsg, popUpClose,
					 * ConnectionTestMsgInvalidFolderPath, "Connection Test", true);
					 */
 
					flag = false;
 
					if (acMess.contains(ConnectionTestMsgInvalidFolderPath)) {
 
						flag = true;
					} else {
 
						testConnection(readerGrantErrMessage);
						flag = true;
					}
 
				}
			}
		} catch (Exception e) {
 
			flag = false;
 
			BaseSuite.reportErrorLog(
					"Error occured while save And Test Connection For Invalid Scenario kindly check :" + e.toString());
		}
		return flag;
	}
	public boolean enterUsernamePassword(String connJsonEntity, String connectionType, String newConnectionName,
			ConnectionPoJO connParam, ConnectionPoJO connParamFromExcel, String testScenario, String icedqUser) {

		boolean flag = false;

		try {

			if (!connectionType.equalsIgnoreCase("user")) {

				flag = entervalueInTextFieldWithValidation(connParam, connUsernameInput,
						ConstantProperty.CONN_FIELD_USERNAME, connParam.getUsername(), testScenario,
						connParamFromExcel.getValidationMessage(), true);

				if (flag) {
					// entersecretPassword(connJsonEntity,connParam.getAuthenticationname(),
					// connParam.getConnectorID(),icedqUser);

					String a1 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity, "$.secretId");

					enterSecretName(a1);

				    String a2=  TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity, "$.authConfig.password");
					
					selectVaultPassword(a2, ConstantProperty.CONN_FIELD_PASSWORD);

					// flag = entervalueInTextFieldWithValidation(connParam,connPasswordInput,
					// ConstantProperty.CONN_FIELD_PASSWORD,connParam.getPassword(), testScenario,
					// connParamFromExcel.getValidationMessage(), true);
				}
			} else {

				viewAndValidateConnectionField(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "", false);

				viewAndValidateConnectionField(connsecretPasswordfeild, ConstantProperty.CONN_FIELD_PASSWORD, "",
						false);

			}

			if (connectionType.equalsIgnoreCase("user")) {

				if (isEnabled(driver, connSaveBtn) && (icedqUser.toLowerCase().contains("owner"))) {
					saveConnection();
				} else {

					saveConnection(forbiddenToastMsg);
					click(driver, discardButtonsDetails);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}

				}   
				 clickOnUserConnectionTab();
				 waitForExecution(2000);
				flag = searchAndClickOnConnectionNameInConnRepo(newConnectionName);
				waitForExecution(2000);
				if (flag) {
					inVisible(driver, spinner, Constant.ruleWait);
					flag = entervalueInTextFieldWithValidation(connParam, connUsernameInput,
							ConstantProperty.CONN_FIELD_USERNAME, connParam.getUsername(), testScenario,
							connParamFromExcel.getValidationMessage(), true);
					inVisible(driver, spinner, Constant.ruleWait);
					if (flag) {
						String a1 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity,
								"$.secretId");

						enterSecretName(a1);

						String a2 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity,
								"$.authConfig.password");

						selectVaultPassword(a2, ConstantProperty.CONN_FIELD_PASSWORD);
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Error Observed kindly check :: " + e.toString());
			Thread.currentThread().interrupt();
		}

		return flag;
	}

	// validate default connection property

	public void validateDefaultConnectionProperty(String name, String value, String type) {

		try {
			BaseSuite.reportLog("Verifying default property of connection...");

			validateConnectionPropertyField(
					returnTwoElements(connDefaultPropertyField, "$num", Integer.toString(3), dynamicName, name), name);

			validateConnectionPropertyField(
					returnTwoElements(connDefaultPropertyField, "$num", Integer.toString(4), dynamicName, name), value);

			validateConnectionPropertyField(
					returnTwoElements(connDefaultPropertyField, "$num", Integer.toString(5), dynamicName, name), type);
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Error Observed kindly check :: " + e.toString());
		}

	}

	/** testScenario = "Valid/Invalid" , ValidationMessage blank for valid name **/

	public boolean enterFileConnectionDetailsForInvalidScenario(ConnectionPoJO connParamFromExcel,String testScenario,
			String icedqUser, String tctype, String connectionType) {
		boolean flag = true;
		boolean status1 = false;
		boolean status = false;
		String newconnectionName = null;
		ConnectionPoJO connParam = null;
		NewConnectionRepoPage np = new NewConnectionRepoPage(driver);
		try {

			connParam = setConnectionParametersForApi(connParamFromExcel.getConnectionJsonValue());

			newconnectionName = connParam.getConnName();

			inVisible(driver, spinner, Constant.ruleWait);

			status1 = entervalueInTextFieldWithValidation(connParam, connName, "Connection Name", newconnectionName,
					testScenario, connParamFromExcel.getValidationMessage(), true);

			if (!tctype.isEmpty()) {

				if (!connParam.getConnectorID().toLowerCase().contains("flat-file")) {

					selectDriverOfFlatFileNativeConnection(connParam.getDriverName());
				}

				switch (connParamFromExcel.getFieldName().toLowerCase().trim()) {

				case "connectionname":

					switch (connParam.getServiceProviderName().trim().toLowerCase()) {

					case "local":

						selectLocationOfFlatFileNativeConnection("Local", connParam);

						entervalueInTextFieldWithValidation(connParam, connFlatFileFolderPathField,
								ConstantProperty.CONN_FIELD_FOLDERPATH, connParam.getFolderPath(), testScenario,
								connParamFromExcel.getValidationMessage(), true);

						break;

					case "aws-s3":
						selectLocationOfFlatFileNativeConnection(connParam.getServiceProviderName(), connParam);

						if (connParam.getConnectorID().toLowerCase().contains("file")) {

							selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());
						}

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

						selectConnectionType(chooseConnType, connParam.getType());
						
						entersecretPassword(connParamFromExcel.getConnectionJsonValue(), connParam.getAuthenticationname(),connParam.getConnectorID(), icedqUser);

					//	validatAndeEnterValueToTextField(connFlatFileAccesskeyLabel, connFlatFileAccesskeyField,ConstantProperty.CONN_FIELD_ACCESSKEY, accesskeyPlaceHolder, accessKey,accesskeyEmptyValidationMsg);

					//	validatAndeEnterValueToTextField(connFlatFileSecretkeyLabel, connFlatFileSecretkeyField,ConstantProperty.CONN_FIELD_SECRETKEY, secretkeyPlaceHolder, secretKey,secretkeyEmptyValidationMsg);

						break;

					case "azure-blob":

						selectLocationOfFlatFileNativeConnection(connParam.getServiceProviderName(), connParam);

						if (connParam.getConnectorID().toLowerCase().contains("file")) {

							selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());
						}

						selectAuthenticationOfConnection(connParam.getAuthenticationname());

						validatAndeEnterValueToTextField(connFlatFileContainerLabel, connFlatFileContainerField,
								ConstantProperty.CONN_FIELD_CONTAINER, containerPlaceHolder, connParam.getContainer(),
								connParamFromExcel.getValidationMessage());

						validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,
								ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder,
								connParam.getFolderPath(), connParamFromExcel.getValidationMessage());

						selectConnectionType(chooseConnType, connParam.getType());

						validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
								ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, connParam.getAccountname(),
								connParamFromExcel.getValidationMessage());

						if (connParam.getAuthentication().toLowerCase().contains("azure-access-key")) {

							entersecretPassword(connParamFromExcel.getConnectionJsonValue(), connParam.getAuthenticationname(),connParam.getConnectorID(), icedqUser);

						} else {

							entersecretPassword(connParamFromExcel.getConnectionJsonValue(), connParam.getAuthenticationname(),connParam.getConnectorID(), icedqUser);

						}
						break;

					default:

						break;

					}

					if (icedqUser.toLowerCase().contains("owner")) {

						String saveErrorMsg = "Connection name \'" + newconnectionName + "\' already exists.";
						status = saveConnection(saveErrorMsg);

					} else {

						status = saveConnection(forbiddenToastMsg);
					}
					break;
					
				
				case "folderpath":

					status = entervalueInTextFieldWithValidation(connParam, connFlatFileFolderPathField,
							ConstantProperty.CONN_FIELD_FOLDERPATH, connParam.getFolderPath(), testScenario,
							connParamFromExcel.getValidationMessage(), true);

					break;

				case "container":

					status = entervalueInTextFieldWithValidation(connParam, connFlatFileContainerField,
							ConstantProperty.CONN_FIELD_CONTAINER, connParam.getContainer(), testScenario,
							connParamFromExcel.getValidationMessage(), true);

					break;

				case "region":
					status = entervalueInTextFieldWithValidation(connParam, connFlatFileRegionField,
							ConstantProperty.CONN_FIELD_REGION, connParam.getRegionValue(), testScenario,
							connParamFromExcel.getValidationMessage(), true);

					break;
					
				case "secretid":

					selectConnectionType(connectionType);

					if (!connectionType.equalsIgnoreCase("user")) {

						status = np.checkRecordFoundOrNot(ConstantProperty.CONN_FIELD_SECRETNAME,connsecretName,connsecretNameSearchField,"Icedq");
					} else {

						status = viewAndValidateConnectionField(connsecretName,ConstantProperty.CONN_FIELD_SECRETNAME, connParamFromExcel.getValidationMessage(),
								false);
					}
					
					
					break;
					
				case "awsaccesskey":
					if (!connectionType.equalsIgnoreCase("user")) {

						status =np.checkRecordFoundOrNot(ConstantProperty.CONN_FIELD_ACCESSKEY,flatfileaccessddb,connsecretNameSearchField,"Icedq");
					} else {

						status = viewAndValidateConnectionField(connFlatFileAccesskeyField,ConstantProperty.CONN_FIELD_ACCESSKEY, connParamFromExcel.getValidationMessage(),
								true);
					}
					
			status = entervalueInTextFieldWithValidation(connParam, connFlatFileAccesskeyField,
							ConstantProperty.CONN_FIELD_ACCESSKEY, connParam.getAccess(), testScenario,
							connParamFromExcel.getValidationMessage(), true);


					break;

				case "azureaccesskey":
					
					if (!connectionType.equalsIgnoreCase("user")) {

						status =np.checkRecordFoundOrNot(ConstantProperty.CONN_FIELD_ACCESSKEY,connFlatFileAccesskeyField,connsecretNameSearchField,"Icedq");
					} else {

						status = viewAndValidateConnectionField(connFlatFileAccesskeyField,ConstantProperty.CONN_FIELD_ACCESSKEY, connParamFromExcel.getValidationMessage(),
								true);
					}

					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					selectConnectionType(connectionType);

					status = entervalueInTextFieldWithValidation(connParam, connFlatFileAccesskeyField,
							ConstantProperty.CONN_FIELD_ACCESSKEY, connParam.getAccess(), testScenario,
							connParamFromExcel.getValidationMessage(), true);

					break;

				case "awssecretkey":
					
					if (!connectionType.equalsIgnoreCase("user")) {

						status = np.checkRecordFoundOrNot(ConstantProperty.CONN_FIELD_SECRETKEY,flatfilesecretddb,connsecretNameSearchField,"Icedq");
					} else {

						status = viewAndValidateConnectionField(connFlatFileSecretkeyField,ConstantProperty.CONN_FIELD_SECRETKEY, connParamFromExcel.getValidationMessage(),
								true);
					}

					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					selectConnectionType(connectionType);

					status = entervalueInTextFieldWithValidation(connParam, connFlatFileSecretkeyField,
							ConstantProperty.CONN_FIELD_SECRETKEY, connParam.getSecret(), testScenario,
							connParamFromExcel.getValidationMessage(), true);

					break;

				case "azureaccount":

					String locationName =setLocationType(connParam.getServiceProviderName());
					
					selectLocationOfFlatFileNativeConnection(locationName, connParam);
					
					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					selectConnectionType(connectionType);

					status = entervalueInTextFieldWithValidation(connParam, connFlatFileAccountNameField,
							ConstantProperty.CONN_FIELD_ACCOUNTNAME, connParam.getAccountname(), testScenario,
							connParamFromExcel.getValidationMessage(), true);

					break;

				case "sessiontoken":

					selectLocationOfFlatFileNativeConnection(connParam.getServiceProviderName(), connParam);

					if (connParam.getConnectorID().toLowerCase().contains("file")) {

						selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());
					}

					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					selectConnectionType(connectionType);

					status = entervalueInTextFieldWithValidation(connParam, connSessionTokenField,
							ConstantProperty.CONN_FIELD_SESSIONTOKEN, connParam.getSessiontoken(), testScenario,
							connParamFromExcel.getValidationMessage(), true);

					break;

				case "securitytoken":

					selectLocationOfFlatFileNativeConnection(connParam.getServiceProviderName(), connParam);

					if (connParam.getConnectorID().toLowerCase().contains("file")) {

						selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());
					}

					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					selectConnectionType(connectionType);

					status = entervalueInTextFieldWithValidation(connParam, connSecurityTokenField,
							ConstantProperty.CONN_FIELD_SECURITYTOKEN, connParam.getSecurityToken(), testScenario,connParamFromExcel.getValidationMessage(), true);

					break;

				default:
					BaseSuite.reportErrorLog(
							"Field name is not found kindly check :: " + connParamFromExcel.getFieldName());
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

	/** testScenario = "Valid/Invalid" , ValidationMessage blank for valid name **/

	public boolean enterFileConnectionDetailsForInvalidScenarioToTestConnection(ConnectionPoJO connParamFromExcel,
			String connectionJsonEntity, String connectionName, String testScenario, String icedqUser, String tctype,
			String connectionType) {
		boolean flag = false;
		boolean status = false;
		String newConnectionName = null;
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connectionJsonEntity);

			ArrayList<String> cred = new ArrayList<>();
			cred.add(connParam.getAccess());
			cred.add(connParam.getSecret());
			cred.add(connParam.getSessiontoken());
			cred.add(connParam.getAccountname());
			cred.add(connParam.getAzureAccesskey());
			cred.add(connParam.getSecurityToken());

			newConnectionName = connectionName ;

			status = entervalueInTextFieldWithValidation(connParam, connName, "Connection Name", newConnectionName,
					testScenario, connParamFromExcel.getValidationMessage(), true);

			if (status) {

				if (!connParam.getConnectorID().toLowerCase().contains("flat-file")) {

					selectDriverOfFlatFileNativeConnection(connParam.getDriverName());
				}

				selectLocationOfFlatFileNativeConnection(connParam.getServiceProviderName(), connParam);

				switch (connParam.getServiceProviderName().toLowerCase()) {

				case "local":

					if (connParam.getConnectorID().toLowerCase().contains("excel")) {

						switch (connParam.getFieldName().toLowerCase()) {

						case "folderpath":

							validatAndeEnterValueToTextField(connFlatFileFolderPathField, connFlatFileFolderPathLabel,
									ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder,
									connParam.getFolderPath(), folderPathEmptyValidationMsg);

						case "testfile":

							validatAndeEnterValueToTextField(connExcelTestFileLabel, connExcelTestFileField,
									"Test File", testFilePlaceHolder, connParam.getTestFile(),
									testFileEmptyValidationMsg);

						}
					} else {

						validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,
								ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder,
								connParam.getFolderPath(), folderPathEmptyValidationMsg);
					}

					break;

				case "azure-blob":

					
					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					validatAndeEnterValueToTextField(connFlatFileContainerLabel, connFlatFileContainerField,
							ConstantProperty.CONN_FIELD_CONTAINER, containerPlaceHolder, connParam.getContainer(),
							containerEmptyValidationMsg);

					validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,
							ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder, connParam.getFolderPath(),
							folderPathEmptyValidationMsg);

					selectConnectionType(connectionType);

					enterCredentialForUserConnection(connectionName, connectionType, connParam.getServiceProviderName(),
							connParam.getAuthenticationname(), cred,connectionJsonEntity);

					break;

				case "aws-s3":

					
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

					selectConnectionType(connectionType);
					
					enterCredentialForUserConnection(connectionName, connectionType, connParam.getServiceProviderName(),
							connParam.getAuthenticationname(), cred,connectionJsonEntity);

					break;

				default:

					break;

				}

				status = saveAndTestConnectionForInvalidScenario(icedqUser, status, connectionType);
				
				clickOnConnectionsTab();

				if (connectionType.equalsIgnoreCase("User") && icedqUser.contains("owner")) {

					clickOnConnectionsTab();

					//searchAndClickOnConnectionNameInConnRepo(connectionName);

				}
			}
			if (status) {
				flag = true;
			}

		} catch (Exception e) {

			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("File connection not created properly kindly check :" + e.toString());
		}
		return flag;
	}

	public boolean enterCredentialForUserConnection(String connectionName, String connectionType, String location,
			String authtype, ArrayList<String> credentials,String connectionJsonEntity) {

		boolean flag = false;

		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connectionJsonEntity);

			
			ArrayList<String> cred = new ArrayList<>();
			cred.add(connParam.getAccess());
			cred.add(connParam.getSecret());
			cred.add(connParam.getSessiontoken());
			cred.add(connParam.getAccountname());
			cred.add(connParam.getAzureAccesskey());
			cred.add(connParam.getSecurityToken());

			if (connectionType.toLowerCase().contains(ConstantProperty.CONN_SYSTETYPE)) {

				flag = true;

			} else {

				waitForExecution(1000);

				saveConnection();

				clickOnUserConnectionTab();

				flag = searchAndClickOnConnectionNameInConnRepo(connectionName);

			}
			if (flag) {

				switch (location.toLowerCase()) {

				case "aws-s3":

					String a2 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connectionJsonEntity, "$.secretId");
					
					enterSecretName(a2);
					
					selectAccessKey(connParam.getAccess());
					
					selectSecretKey(connParam.getSecret());
					
					break;
				case "azure-blob":

					String a1 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connectionJsonEntity, "$.secretId");
					
					enterSecretName(a1);
					
					validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
							ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, connParam.getAccountname(),
							accountNameEmptyValidationMsg);

					if (connParam.getAuthentication().toLowerCase().contains("azure-shared-signature")) {

					
						selectSecuritytoken(connParam.getSecurityToken());
					} else {

						selectAccessKey(connParam.getAzureAccesskey());

					}

					break;

				default:

					break;

				}

			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("File connection not tested properly kindly check :" + e.toString());

		}
		return flag;
	}

	public boolean enterXMLFileConnectionDetailsForInvalidScenario(ConnectionPoJO connParamFromExcel,
			String connJsonEntity, String testScenario, String icedqUser, String tctype, String connectionType) {
		boolean flag = true;
		boolean status1 = false;
		boolean status = false;
		String newconnectionName = null;
		ConnectionPoJO connParam = null;
		NewConnectionRepoPage np = new NewConnectionRepoPage(driver);
		try {

			connParam = setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName();

			inVisible(driver, spinner, Constant.ruleWait);

			status1 = entervalueInTextFieldWithValidation(connParam, connName, "Connection Name", newconnectionName,
					testScenario, connParamFromExcel.getValidationMessage(), true);

			if (!tctype.isEmpty()) {


				if (!connParam.getConnectorID().toLowerCase().contains("flat-file")) {

					selectDriverOfFlatFileNativeConnection(connParam.getDriverName());
				}

				switch (connParamFromExcel.getFieldName().toLowerCase().trim()) {

				case "connectionname":

					switch (connParam.getServiceProviderName().trim().toLowerCase()) {

					case "local":

						selectLocationOfFlatFileNativeConnection(connParam.getServiceProviderName(), connParam);

						entervalueInTextFieldWithValidation(connParam, connFlatFileFolderPathField,
								ConstantProperty.CONN_FIELD_FOLDERPATH, connParam.getFolderPath(), testScenario,
								connParamFromExcel.getValidationMessage(), true);

						break;

					case "aws-s3":

						selectLocationOfFlatFileNativeConnection(connParam.getServiceProviderName(), connParam);

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

						selectConnectionType(chooseConnType, connParam.getType());

						entersecretPassword(connParamFromExcel.getConnectionJsonValueS3(), connParam.getAuthentication(),connParam.getConnectorID(), icedqUser);
						
						break;

					case "azure-blob":

						selectLocationOfFlatFileNativeConnection(connParam.getServiceProviderName(), connParam);

						selectAuthenticationOfConnection(connParam.getAuthenticationname());

						validatAndeEnterValueToTextField(connFlatFileContainerLabel, connFlatFileContainerField,
								ConstantProperty.CONN_FIELD_CONTAINER, containerPlaceHolder, connParam.getContainer(),
								containerEmptyValidationMsg);

						validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,
								ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder,
								connParam.getFolderPath(), folderPathEmptyValidationMsg);

						selectConnectionType(chooseConnType, connParam.getType());

						validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
								ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, connParam.getAccountname(),
								connParamFromExcel.getValidationMessage());

						if (connParam.getAuthentication().toLowerCase().contains("azure-access-key")) {

							entersecretPassword(connParamFromExcel.getConnectionJsonValueAzure(), connParam.getAuthentication(),connParam.getConnectorID(), icedqUser);

						} else {

							entersecretPassword(connParamFromExcel.getConnectionJsonValueAzure(), connParam.getAuthentication(),connParam.getConnectorID(), icedqUser);

						}
						break;

					default:

						break;

					}

					if (icedqUser.toLowerCase().contains("owner")) {

						String saveErrorMsg = "Connection name \'" + newconnectionName + "\' already exists.";
						status = saveConnection(saveErrorMsg);

					} else {

						status = saveConnection(forbiddenToastMsg);
					}
					break;

				case "folderpath":

					status = entervalueInTextFieldWithValidation(connParam, connFlatFileFolderPathField,
							ConstantProperty.CONN_FIELD_FOLDERPATH, connParam.getFolderPath(), testScenario,
							connParamFromExcel.getValidationMessage(), true);

					break;

				case "container":

					status = entervalueInTextFieldWithValidation(connParam, connFlatFileContainerField,
							ConstantProperty.CONN_FIELD_CONTAINER, connParam.getContainer(), testScenario,
							connParamFromExcel.getValidationMessage(), true);

					break;

				case "region":
					status = entervalueInTextFieldWithValidation(connParam, connFlatFileRegionField,
							ConstantProperty.CONN_FIELD_REGION, connParam.getRegionValue(), testScenario,
							connParamFromExcel.getValidationMessage(), true);

					break;
					
				case "secretid":

					selectConnectionType(connectionType);

					if (!connectionType.equalsIgnoreCase("user")) {

						status = np.checkRecordFoundOrNot(ConstantProperty.CONN_FIELD_SECRETNAME,connsecretName,connsecretNameSearchField,"Icedq");
					} else {

						status = viewAndValidateConnectionField(connsecretName,ConstantProperty.CONN_FIELD_SECRETNAME, connParamFromExcel.getValidationMessage(),
								false);
					}
					
					
					break;
					
				case "awsaccesskey":
					if (!connectionType.equalsIgnoreCase("user")) {

						status =np.checkRecordFoundOrNot(ConstantProperty.CONN_FIELD_ACCESSKEY,flatfileaccessddb,connsecretNameSearchField,"Icedq");
					} else {


						status = viewAndValidateConnectionField(connFlatFileAccesskeyField,ConstantProperty.CONN_FIELD_ACCESSKEY, connParamFromExcel.getValidationMessage(),
								true);
					}
					

					// selectConnectionType(connectionType);
					selectConnectionType(chooseConnType, connectionType);

					status = entervalueInTextFieldWithValidation(connParam, connFlatFileAccesskeyField,
							ConstantProperty.CONN_FIELD_ACCESSKEY, connParam.getAccess(), testScenario,
							connParamFromExcel.getValidationMessage(), true);


					break;

				case "azureaccesskey":
					
					if (!connectionType.equalsIgnoreCase("user")) {

						status =np.checkRecordFoundOrNot(ConstantProperty.CONN_FIELD_ACCESSKEY,connFlatFileAccesskeyField,connsecretNameSearchField,"Icedq");
					} else {

						status = viewAndValidateConnectionField(connFlatFileAccesskeyField,ConstantProperty.CONN_FIELD_ACCESSKEY, connParamFromExcel.getValidationMessage(),
								true);
					}

					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					selectConnectionType(chooseConnType, connectionType);

					status = entervalueInTextFieldWithValidation(connParam, connFlatFileAccesskeyField,
							ConstantProperty.CONN_FIELD_ACCESSKEY, connParam.getAccess(), testScenario,
							connParamFromExcel.getValidationMessage(), true);


					break;

				case "awssecretkey":
					
					if (!connectionType.equalsIgnoreCase("user")) {

						status = np.checkRecordFoundOrNot(ConstantProperty.CONN_FIELD_SECRETKEY,flatfilesecretddb,connsecretNameSearchField,"Icedq");
					} else {

						status = viewAndValidateConnectionField(connFlatFileSecretkeyField,ConstantProperty.CONN_FIELD_SECRETKEY, connParamFromExcel.getValidationMessage(),
								true);
					}

					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					selectConnectionType(chooseConnType, connectionType);

					status = entervalueInTextFieldWithValidation(connParam, connFlatFileSecretkeyField,
							ConstantProperty.CONN_FIELD_SECRETKEY, connParam.getSecret(), testScenario,
							connParamFromExcel.getValidationMessage(), true);

					break;

				case "azureaccount":

					String locationName =setLocationType(connParam.getServiceProviderName());
					
					selectLocationOfFlatFileNativeConnection(locationName, connParam);
					
					selectAuthenticationOfConnection(connParam.getAuthenticationname());
	
					selectConnectionType(chooseConnType, connectionType);

					status = entervalueInTextFieldWithValidation(connParam, connFlatFileAccountNameField,
							ConstantProperty.CONN_FIELD_ACCOUNTNAME, connParam.getAccountname(), testScenario,
							connParamFromExcel.getValidationMessage(), true);

					break;

				case "sessiontoken":

					selectLocationOfFlatFileNativeConnection(connParam.getServiceProviderName(), connParam);

					if (connParam.getConnectorID().toLowerCase().contains("file")) {

						selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());
					}

					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					selectConnectionType(chooseConnType, connectionType);

					status = entervalueInTextFieldWithValidation(connParam, connSessionTokenField,
							ConstantProperty.CONN_FIELD_SESSIONTOKEN, connParam.getSessiontoken(), testScenario,
							connParamFromExcel.getValidationMessage(), true);

					break;

				case "securitytoken":

					selectLocationOfFlatFileNativeConnection(connParam.getServiceProviderName(), connParam);

					if (connParam.getConnectorID().toLowerCase().contains("file")) {

						selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());
					}

					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					selectConnectionType(chooseConnType, connectionType);

					status = entervalueInTextFieldWithValidation(connParam, connSecurityTokenField,
							ConstantProperty.CONN_FIELD_SECURITYTOKEN, connParam.getSecurityToken(), testScenario,connParamFromExcel.getValidationMessage(), true);

					break;

				default:
					BaseSuite.reportErrorLog(
							"Field name is not found kindly check :: " + connParamFromExcel.getFieldName());
					break;

				}
			}
			 else if (status1) {
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

	public void handleWarningPopupWindow() {

		try {
			isDisplayedInLoop(driver, 0, warningPopupWindowTitle);

			if (isDisplayed(driver, warningPopupWindowTitle)) {

				verifyIndividualLabel(driver, warningPopupWindowTitle, "Warning");

				String ac = getAttribute(driver, warningPopupWindowContent, attributeTextContent);

				stringContainsOutput(ac, warningPopupContent, true);

				verifyVisibilityOfButtons(driver, warningPopupWindowCancelButton, "Cancel", true);

				verifyVisibilityOfButtons(driver, warningPopupWindowYesButton, "Yes", true);

				clickOnButton(driver, warningPopupWindowCancelButton, "Cancel", true);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Error while handleWarningPopupWindow kindly check :" + e.toString());
		}

	}

	public void handleWarningPopupWindow(By locator, String label) {

		try {
			isDisplayedInLoop(driver, 0, warningPopupWindowTitle);

			if (isDisplayed(driver, warningPopupWindowTitle)) {

				verifyIndividualLabel(driver, warningPopupWindowTitle, "Warning");

				String ac = getAttribute(driver, warningPopupWindowContent, attributeTextContent);

				stringContainsOutput(ac, warningPopupContent, true);

				verifyVisibilityOfButtons(driver, warningPopupWindowCancelButton, "Cancel", true);

				verifyVisibilityOfButtons(driver, warningPopupWindowYesButton, "Yes", true);

				clickOnButton(driver, locator, label, true);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Error while handleWarningPopupWindow kindly check :" + e.toString());
		}

	}

	// select connection type new common method

	public void selectConnectionType(By locator, String expected) {

		Actions action = new Actions(driver);

		try {
			isDisplayedInLoop(driver, 5, locator);

			javascript(driver, scrollToElementArg, locator);

			if (isDisplayed(driver, locator)) {

				displayAndClick(driver, locator);

				waitForExecution(1000);

				if (expected.trim().equalsIgnoreCase("System")) {
				//	waitForExecution(1000);
					isDisplayedInLoop(driver, 5, systemConnType);
					BaseSuite.validationReportLog("system Conn Type visible");
					if (isDisplayed(driver, systemConnType)) {
						WebElement systemele = driver.findElement(systemConnType);
						action.moveToElement(systemele).click().perform();
						BaseSuite.validationReportLog("Connection Type System Selected ");
					} else {
						BaseSuite.reportFailLog("System connection type not visible", "");
					}
					handleWarningPopupWindow(warningPopupWindowYesButton, "Yes");

				} else {
				//	waitForExecution(1000);
					isDisplayedInLoop(driver, 5, userConnType);

					if (isDisplayed(driver, userConnType)) {

						WebElement userele = driver.findElement(userConnType);

						action.moveToElement(userele).click().perform();

					} else {
						BaseSuite.reportFailLog("User connection type not visible", "");
					}
				}

			}

			handleWarningPopupWindow();

		} catch (Exception e) {

			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Error occurs while selectConnectionType :" + e.toString());
		}

	}

	/** Enable custom JDBC URL check box method **/

	public boolean selectCustomJDBCURLOfConnection(String state, String expected) {
		String str = "check";
		boolean flag = false;
		try {
			isDisplayedInLoop(driver, 5, connCustomJDBCLabel);

			javascript(driver, scrollToElementArg, connCustomJDBCLabel);

			if (isDisplayed(driver, connCustomJDBCLabel)) {

				BaseSuite.reportLog("verifying custom JDBC URL checkbox");

				if (isDisplayed(driver, connCustomJDBCCheckbox)) {

					BaseSuite.validationReportLog("Custom JDBC URL checkbox is visible");

					String actualState = getAttribute(driver, connCustomJDBCCheckbox, attributeClassName);

					if (actualState.contains(str)) {

						BaseSuite.reportLog("Default condition of Custom JDBC URL checkbox is checked");
					} else {
						BaseSuite.reportLog("Default condition of Custom JDBC URL checkbox is unchecked");
					}

					if (Boolean.parseBoolean(state) && !actualState.contains(str)) {

						BaseSuite.reportLog("Clicking on custom JDBC URL checkbox");

						displayAndClick(driver, connCustomJDBCCheckbox);

						actualState = getAttribute(driver, connCustomJDBCCheckbox, attributeClassName);

						stringContainsOutput(actualState, str, true);
						flag = true;
					} else if (state.equalsIgnoreCase("false") && actualState.contains(str)) {

						BaseSuite.reportLog("Clicking on custom JDBC URL checkbox");

						displayAndClick(driver, connCustomJDBCCheckbox);

						/**
						 * actualState = getAttribute(driver, connCustomJDBCCheckbox, "class");
						 * 
						 * stringContainsOutput(actualState, str, true);
						 **/
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

	public static void waitForExecution(int waitTime) {
		long endTime = System.currentTimeMillis() + (waitTime);
		while (System.currentTimeMillis() < endTime) {
			//
		}
	}

	// Method to validate & Secret Name
	public void enterSecretName(String value) throws NullPointerException {
		boolean flag = false;
		String methodName = "enterSecretName";
		try {
			javascript(driver, scrollToElementArg, connsecretName);

			if (isDisplayed(driver, connsecretName)) {
				BaseSuite.reportLog("Secret Name field is displayed.");

				if (isEnabled(driver, connsecretName)) {
					if (isEditable(driver, connsecretName, " Secret Name")) {

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag = verifyplaceholder(connsecretName, "Select secret name");

						if (flag) {
							BaseSuite.validationReportLog("correct placeholder is displayed in Secret Name input box.");
						} else {
							BaseSuite.reportFailLog(
									"Expected placeholder didnt matched with actual placeholder, kindly check.",
									methodName);
						}
						displayAndClick(driver, connsecretName);

						sendKeys(driver, connsecretNameSearchField, value.trim());

						Thread.sleep(2000);

						driver.findElement(connsecretNameSearchField).sendKeys(Keys.ENTER);

						isDisplayedInLoop(driver, 1, connsecretName);

						String secretname = getAttribute(driver, connsecretName, valueAttribute).trim();

						compareActualNExpectedValue(secretname.trim(), value.trim());

						/*
						 * sendKeys(driver, connsecretName, value.trim());
						 * 
						 * driver.findElement(connsecretName).sendKeys(Keys.ENTER);
						 * 
						 * isDisplayedInLoop(driver, 1, connsecretName);
						 * 
						 * String secretname = getAttribute(driver, connsecretName,
						 * valueAttribute).trim();
						 * 
						 * compareActualNExpectedValue(secretname.trim(), value.trim());
						 * 
						 */

						/*
						 * isDisplayedInLoop(driver, 2, connsecretNamedropdownbtn);
						 * 
						 * if (isDisplayed(driver, connsecretNamedropdownbtn)) {
						 * 
						 * displayAndClick(driver, connsecretNamedropdownbtn);
						 * 
						 * BaseSuite.validationReportLog( "Clicked on Secret Name drop down  " +
						 * ConstantProperty.SUCCESSSTRING + "");
						 * 
						 * BaseSuite.reportLog("Checking list of Secret Name Values visible");
						 * waitForExecution(2000);
						 * 
						 * 
						 * /* List<WebElement> authList = getElements(driver,
						 * connsecretPassdropdownlist);
						 * 
						 * for (int i = 0; i < authList.size(); i++) {
						 * 
						 * String authName = authList.get(i).getAttribute("textContent");
						 * 
						 * BaseSuite.reportLog((i + 1) + ". " + authName + " is visible");
						 * 
						 * }
						 */
						/*
						 * } javascript(driver, scrollToElementArg, returnElement(connselectsecretName,
						 * dynamicName, value));
						 * 
						 * isDisplayedInLoop(driver, 4, returnElement(connselectsecretName, dynamicName,
						 * value));
						 * 
						 * if (isDisplayed(driver, returnElement(connselectsecretName, dynamicName,
						 * value))) {
						 * 
						 * displayAndClick(driver, returnElement(connselectsecretName, dynamicName,
						 * value));
						 * 
						 * } else {
						 * BaseSuite.reportFailLog("Expected Secret Name type not found kindly check",
						 * methodName); }
						 */
					}

				} else {
					BaseSuite.reportFailLog("Secret Name input is disabled, kindly check.", methodName);
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate Secret Name field on current page, kindly check.",
						methodName);
			}

		} catch (Exception e) {
			e.getMessage();

		}
	}

	/*
	 * // Method to validate & enter Secret Password public void
	 * enterVaultPassword(String value) throws NullPointerException { boolean flag =
	 * false; String methodName = "enterSecretPassword"; try { javascript(driver,
	 * scrollToElementArg, connsecretPasswordfeild);
	 * 
	 * if (isDisplayed(driver, connsecretPasswordfeild)) {
	 * BaseSuite.reportLog("Password field is displayed.");
	 * 
	 * if (isEnabled(driver, connsecretPasswordfeild)) { if (isEditable(driver,
	 * connsecretPasswordfeild, " password")) { clear(driver,
	 * connsecretPasswordfeild);
	 * 
	 * BaseSuite.reportLog("Verify placeholder is present in the input box.");
	 * 
	 * flag = verifyplaceholder(connsecretPasswordfeild, "Enter password");
	 * 
	 * if (flag) { BaseSuite.
	 * validationReportLog("correct placeholder is displayed in database input box."
	 * ); } else { BaseSuite.reportFailLog(
	 * "Expected placeholder didnt matched with actual placeholder, kindly check.",
	 * methodName); }
	 * 
	 * sendKeys(driver, connsecretPasswordfeild, value.trim());
	 * 
	 * driver.findElement(connsecretPasswordfeild).sendKeys(Keys.ENTER);
	 * 
	 * BaseSuite.validationReportLog("Entered password in password field."); }
	 * 
	 * } else { BaseSuite.reportFailLog("Password input is disabled, kindly check.",
	 * methodName); }
	 * 
	 * } else { BaseSuite.
	 * reportFailLog("Unable to locate password field on current page, kindly check."
	 * , methodName); }
	 * 
	 * } catch (Exception e) { e.getMessage();
	 * 
	 * } }
	 */
	/** Method to validate & enter Secret Password **/

	public void selectVaultPersonalAccessToken(String locationType, String locationType1) {
		boolean flag = false;
		String methodName = "selectVaultPersonalAccessToken";
		try {
			String authValue = null;

			if (isDisplayed(driver, connsecretPATLabel)) {
				String Personal_Access_Token_Label = getText(driver, connsecretPATLabel);

				BaseSuite.reportLog(Personal_Access_Token_Label + "field is displayed.");

			} else {

				BaseSuite.reportLog("Personal Access Token field is not displayed.");

			}

			if (isEditable(driver, connsecretPasswordfeild, "Personal Access Token")) {

				// BaseSuite.validationReportLog("Password field is visible ");

				BaseSuite.reportLog("Verify placeholder is present in password input box.");

				click(driver, connsecretPasswordfeild);

				waitForExecution(2000);

				sendKeys(driver, connsecretPasswordfeild, locationType.trim());

				isDisplayedInLoop(driver, 1, connsecretPasswordfeild);

				authValue = getAttribute(driver, connsecretPasswordfeild, valueAttribute);

				compareActualNExpectedValue(authValue.trim(), locationType.trim());

				BaseSuite.reportLog("Password value selected as : " + authValue);

			}
			/*
			 * javascript(driver, scrollToElementArg,
			 * returnElement(connsecretselectPassword, dynamicName, locationType));
			 * 
			 * isDisplayedInLoop(driver, 4, returnElement(connsecretselectPassword,
			 * dynamicName, locationType));
			 * 
			 * if (isDisplayed(driver, returnElement(connsecretselectPassword, dynamicName,
			 * locationType))) {
			 * 
			 * displayAndClick(driver, returnElement(connsecretselectPassword, dynamicName,
			 * locationType));
			 * 
			 * authValue = getAttribute(driver, connsecretPasswordfeild, valueAttribute);
			 * 
			 * if (!authValue.isEmpty()) {
			 * BaseSuite.validationReportLog("Password selected as : " + authValue);
			 * 
			 * }
			 * 
			 * } else {
			 * BaseSuite.reportFailLog("Expected Password type not found kindly check",
			 * "selectVaultPassword"); }
			 */
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			e.getMessage();
			throw new NoSuchElementException();
		}
	}

	public void selectVaultPassword(String locationType, String locationType1) {

		try {
			String authValue = null;
			isDisplayedInLoop(driver, 2, returnElement(connsecretPasswordlabel, dynamicName, locationType1));

			javascript(driver, scrollToElementArg, returnElement(connsecretPasswordlabel, dynamicName, locationType1));

			verifyIndividualLabel(driver, returnElement(connsecretPasswordlabel, dynamicName, locationType1),
					ConstantProperty.CONN_FIELD_PASSWORD);

			if (isEditable(driver, connsecretPasswordfeild, "Password")) {

				BaseSuite.reportLog("Verify placeholder is present in password input box.");

				click(driver, connsecretPasswordfeild);

				sendKeys(driver, connsecretNameSearchField, locationType.trim());

				inVisible(driver, spinner, Constant.ruleWait);

				driver.findElement(connsecretNameSearchField).sendKeys(Keys.ENTER);

				isDisplayedInLoop(driver, 1, connsecretPasswordfeild);

				authValue = getAttribute(driver, connsecretPasswordfeild, valueAttribute);

				compareActualNExpectedValue(authValue.trim(), locationType.trim());

				BaseSuite.reportLog("Password value selected as : " + authValue);

			}

		} catch (Exception e) {
			Thread.currentThread().interrupt();
			e.getMessage();
			throw new NoSuchElementException();
		}
	}

	public void selectUserPrincipal(String locationType, String locationType1) {

		try {
			String authValue = null;
			isDisplayedInLoop(driver, 2, returnElement(connsecretPasswordlabel, dynamicName, locationType1));

			javascript(driver, scrollToElementArg, returnElement(connsecretPasswordlabel, dynamicName, locationType1));

			verifyIndividualLabel(driver, returnElement(connsecretPasswordlabel, dynamicName, locationType1),
					ConstantProperty.CONN_USERPRINCIPAL);

			if (isEditable(driver, connHiveUserPrincipal, "Select principal")) {

				// BaseSuite.validationReportLog("Password field is visible ");

				BaseSuite.reportLog("Verify placeholder is present in User Principal input box.");

				click(driver, connHiveUserPrincipal);

				waitForExecution(2000);
				sendKeys(driver, connHiveUserPrincipal, locationType.trim());

				isDisplayedInLoop(driver, 1, connHiveUserPrincipal);

				authValue = getAttribute(driver, connHiveUserPrincipal, valueAttribute);

				compareActualNExpectedValue(authValue.trim(), locationType.trim());

				BaseSuite.reportLog("User Principal value selected as : " + authValue);

			}

		} catch (Exception e) {
			Thread.currentThread().interrupt();
			e.getMessage();
			throw new NoSuchElementException();
		}
	}

	/** Method to validate & enter Secret Password **/

	public void selectSecretId(String locationType) {
		try {

			String authValue = null;
			isDisplayedInLoop(driver, 2, connsecretidlabel);

			javascript(driver, scrollToElementArg, connsecretidlabel);

			verifyIndividualLabel(driver, connsecretidlabel, ConstantProperty.CONN_FIELD_SECRETID);

			if (isEditable(driver, connsecretidfield, "Select secret ID")) {

				BaseSuite.validationReportLog("Secret ID field is visible ");

				authValue = getAttribute(driver, connsecretidfield, valueAttribute);

				BaseSuite.reportLog("Default Secret ID value selected as : " + authValue);

				isDisplayedInLoop(driver, 2, connsecretiddropdownbtn);

				if (isDisplayed(driver, connsecretiddropdownbtn)) {

					inVisible(driver, spinner, Constant.ruleWait);

					displayAndClick(driver, connsecretiddropdownbtn);

					BaseSuite.validationReportLog(
							"Clicked on Secret ID drop down  " + ConstantProperty.SUCCESSSTRING + "");

					BaseSuite.reportLog("Checking list of Secret ID Value visible");
					waitForExecution(2000);

				}
				javascript(driver, scrollToElementArg, returnElement(connselectPassword, dynamicName, locationType));

				isDisplayedInLoop(driver, 4, returnElement(connselectPassword, dynamicName, locationType));

				if (isDisplayed(driver, returnElement(connselectPassword, dynamicName, locationType))) {

					displayAndClick(driver, returnElement(connselectPassword, dynamicName, locationType));

					authValue = getAttribute(driver, connsecretidfield, valueAttribute);

					if (!authValue.isEmpty()) {
						BaseSuite.validationReportLog("Secret ID selected as : " + authValue);

					}

				} else {
					BaseSuite.reportFailLog("Expected Secret ID not found kindly check", "selectVaultKeyFileContent");
				}

			} else {
				BaseSuite.reportFailLog("Secret ID field not visible ", " selectVaultKeyFileContent");
			}
		}

		catch (Exception e) {
			Thread.currentThread().interrupt();
			e.getMessage();
			throw new NoSuchElementException();
		}
	}

	/**
	 * Method to validate & enter Key File Content via secret Name for vault use
	 **/

	public void selectVaultKeyFileContent(String locationType) {
		 
		try {
			String authValue = null;
			isDisplayedInLoop(driver, 2, connKeyfileContentPasswordLabel);
 
			javascript(driver, scrollToElementArg, connKeyfileContentPasswordLabel);
 
			verifyIndividualLabel(driver, connKeyfileContentPasswordLabel, ConstantProperty.CONN_FEILD_KEYFILECONTENT);
 
			if (isEditable(driver, connKeyfileContentPasswordfeild, "Key File Content")) {
 
				BaseSuite.validationReportLog("Key file Content field is visible clearly");
 
				click(driver, connKeyfileContentPasswordfeild);
 
				waitForExecution(2000);
 
				sendKeys(driver, connsecretNameSearchField, locationType.trim());
 
				inVisible(driver, spinner, Constant.ruleWait);
 
				driver.findElement(connsecretNameSearchField).sendKeys(Keys.ENTER);
 
				isDisplayedInLoop(driver, 1, returnElement(connselectPassword, dynamicName, locationType));
 
				authValue = getAttribute(driver, connKeyfileContentPasswordfeild, valueAttribute);
 
				compareActualNExpectedValue(authValue.trim(), locationType.trim());
 
				BaseSuite.reportLog("Key Pair Content value selected as : " + authValue);
 
				if (!authValue.isEmpty()) {
					BaseSuite.validationReportLog("Key file Content selected as : " + authValue);
 
				} else {
					BaseSuite.reportFailLog("Expected Key file Content not found kindly check",
							"selectVaultKeyFileContent");
				}
 
			} else {
				BaseSuite.reportFailLog("Key file Content field not visible ", " selectVaultKeyFileContent");
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			e.getMessage();
			throw new NoSuchElementException();
		}
	}

	/** Enable Vault check box method **/

	public boolean selectEnableVaultOfConnection(String state) {
		boolean flag = false;
		try {
			isDisplayedInLoop(driver, 5, connvaultOnOffLabel);

			javascript(driver, scrollToElementArg, connvaultOnOffLabel);

			if (isDisplayed(driver, connvaultOnOffLabel)) {

				BaseSuite.reportLog("verifying Enable Vault checkbox");

				isSelected(driver, connvaultOnOff);

				displayAndClick(driver, connvaultOnOff);

				BaseSuite.validationReportLog("Vault selected as True");

			} else {
				BaseSuite.reportFailLog("Enable Vault field not visible ", "selectEnableVaultOfConnection");
			}
		} catch (Exception e) {
			e.getMessage();
			throw new NoSuchElementException();
		}
		return flag;
	}

	/** testScenario = "Valid/Invalid" , ValidationMessage blank for valid name **/
	public boolean updateKerberosConnection(String scenario, String connJsonEntity, String driverName,
			String testScenario, String validationMessage, String icedqUser) {
		boolean flag = true;
		boolean stop = true;
		String newconnectionName = null;

		String KerberosConfigLocation = System.getProperty("user.dir") + Constant.KERBEROS_CONFIG_LOCATION;
		String UserKeytabLocation = System.getProperty("user.dir") + Constant.USER_KEYTAB_LOCATION;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

			String connusername = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

			String connpassword = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 2);

			String connprincipal = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 21);

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

					connName = connParam.getConnName() + "_" + ConstantProperty.TARGET_WORKSPACE_NAME;
				}

				searchAndClickOnConnectionNameInConnRepo(connName);

			}
			inVisible(driver, spinner, Constant.ruleWait);

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

			viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, true);

			selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

			viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
					connParam.getAuthenticationname(), true);

			selectAuthenticationOfConnection(connParam.getAuthenticationname());

			verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

			selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

			enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());

			if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS))

			{
				WebElement m = driver.findElement(By.xpath("//input[@id='krbFile']"));

				m.sendKeys(KerberosConfigLocation);

				BaseSuite.validationReportLog("Krb5 File Choosed successfully");

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			}

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

			selectConnectionType(chooseConnType, connParam.getType());

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

					WebElement m = driver.findElement(By.xpath("//input[@id='keytab']"));

					m.sendKeys(UserKeytabLocation);

					BaseSuite.validationReportLog("User key tab File Choosed successfully");

					validatAndeEnterValueToTextField(connUserPrincipalLabel, connHiveUserPrincipal,
							ConstantProperty.CONN_FIELD_USERPRINCIPAL, connPrincipalPlaceholder,
							connParam.getUserPrincipal(), validationUserprincipal);

				} else {

					entersecretPassword(connJsonEntity, connParam.getAuthenticationname(), connParam.getConnectorID(),
							icedqUser);

					enterUsername(connusername);

				}

			} else {
				if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

					validateInputFieldVisibility(connHiveUserPrincipal, ConstantProperty.CONN_USERPRINCIPAL, "", false);

					isEnabled(driver, connUserKeytab);

					BaseSuite.validationReportLog("User key tab Field is Disabled");

					isEnabled(driver, chooseFileBtn);

					BaseSuite.validationReportLog("Choose File button is Disabled");

				} else {

					validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "", false);

					validateInputFieldVisibility(connsecretUserPassword, ConstantProperty.CONN_FIELD_PASSWORD, "",
							false);
				}
			}
			ArrayList<String> connPropertyList = TestDataThroughApi
					.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

			int count = connPropertyList.size();

			updateConnectionPropertiesToConnection(connJsonEntity, count);

			if ((icedqUser.contains("owner"))) {

				saveConnection();

				clickOnConnectionsTab();

				getConnection(newconnectionName, update_actualValue);

				searchAndClickOnConnectionNameInConnRepo(newconnectionName);
			} else {
				flag = saveConnection(forbiddenToastMsg);
				stop = false;
			}
			if (stop) {
				flag = updateUsernameAndPasswordForHiveAndImpalaConnection(connJsonEntity, connParam,
						connParam.getType(), newconnectionName, icedqUser);
			}

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not updated properly kindly check :" + e.toString());
		}
		return flag;
	}

	/******* Common method to check discard functionality for Fields *******/
	public void verifyFeildData(By locator, String value) {

		try {

			String actValue = getAttribute(driver, locator, valueAttribute).trim();

			BaseSuite.validationReportLog("Enter value to check Discarded fuctionality");

			Thread.sleep(2000);

			sendKeys(driver, locator, value.trim());

			BaseSuite.validationReportLog("Entered value is " + value);

			BaseSuite.validationReportLog("value Entered Successfully");

			isDisplayedInLoop(driver, 1, locator);

			String enteredvalue = getAttribute(driver, locator, valueAttribute).trim();

			BaseSuite.validationReportLog("Value entered successfully and current value in field =" + enteredvalue);

			validatediscardBtn();

			clickOnButton(driver, discardpopupdiscardbtn, "Discard", true);

			BaseSuite.validationReportLog("Entered value Discarded Successfully");

			String afterDiscardvalue = getAttribute(driver, locator, valueAttribute).trim();

			if (actValue.equals(afterDiscardvalue)) {

				BaseSuite.validationReportLog("Discard fuctionality Work Properly");

			} else {

				BaseSuite.validationReportLog("Discard fuctionality Not Working");
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	/********
	 * Common method to check discard functionality for Drop Downs
	 ************/

	public void dropDownDiscard(By locator, By locator2, By locator3, By locator4) {
		String afterDiscardvalue = null;
		try {

			if (isDisplayed(driver, locator)) {

				BaseSuite.validationReportLog("Drop down field is visible ");

				String actValue = getAttribute(driver, locator, valueAttribute);

				BaseSuite.reportLog("Default drop down value type selected as : " + actValue);

				BaseSuite.validationReportLog("Field drop down arrow is visible");

				waitForExecution(2000);

				displayAndClick(driver, locator2);

				BaseSuite.validationReportLog("Field drop down arrow clicked successfully");

				List<WebElement> authList = getElements(driver, locator3);

				int count = authList.size();

				BaseSuite.validationReportLog("Took the list of value successfully");

				if (count > 1) {

					waitForExecution(1000);

					click(driver, locator4);

					BaseSuite.validationReportLog("drop down value selected successfully");

					String selectedValue = getAttribute(driver, locator, valueAttribute).trim();

					if (selectedValue.equalsIgnoreCase("System")) {

						waitForExecution(1000);

						verifyIndividualLabel(driver, warningPopupTitle, conntypechangePopupTitle);

						verifyIndividualLabel(driver, warningPopupTitleMsg, conntypechangePopupTitleMsg);

						verifyVisibilityOfButtons(driver, connPopupCancelBtn, "Cancel", true);

						verifyVisibilityOfButtons(driver, connPopupYesBtn, "Yes", true);

						click(driver, connPopupYesBtn);

						BaseSuite.validationReportLog(
								"Value selected successfully and current value in field =" + selectedValue);

					} else {

						BaseSuite.validationReportLog(
								"Value selected successfully and current value in field =" + selectedValue);
					}

					validatediscardBtn();

					clickOnButton(driver, discardpopupdiscardbtn, "Discard", true);

					afterDiscardvalue = getAttribute(driver, locator, valueAttribute).trim();

				} else {

					waitForExecution(1000);

					click(driver, locator3);

					BaseSuite.validationReportLog("Only 1 value in drop down so no need to select");
				}
				if (actValue.equals(afterDiscardvalue)) {

					BaseSuite.validationReportLog("Discarded fuctionality Work Properly");

				} else {

					BaseSuite.validationReportLog("Discarded fuctionality Not Working");
				}

			} else {
				BaseSuite.reportLog("DropDown Feild is not Visible");

			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**** Validation for Discard Button ****/

	public void validatediscardBtn() {

		try {

			if (isDisplayed(driver, discardButtonsDetails)) {

				BaseSuite.reportLog("Discard Button is visible");

				Thread.sleep(2000);

				displayAndClick(driver, discardButtonsDetails);

				BaseSuite.reportLog("Clicked successfully on Discard Button");

				if (isDisplayed(driver, discardchanges)) {

					verifyIndividualLabel(driver, discardchanges, "Discard Connection");
					verifyVisibilityOfButtons(driver, discardpopupcancelbtn, "Cancel", true);
					verifyVisibilityOfButtons(driver, discardpopupdiscardbtn, "Discard", true);

				} else {

					BaseSuite.reportFailLog("Discard Changes popup window not visible ", "discardBtnMethod");
				}

			} else {
				BaseSuite.reportFailLog("Discard Button not visible ", "discardBtnMethod");
			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void newConnnectionDiscardFuctionality(String connectorName) {

		try {

			verifyVisibilityOfButtons(driver, connSaveBtn, "Save", false);

			verifyVisibilityOfButtons(driver, connTestBtn, "Test", false);

			boolean discard = isDisplayed(driver, discardButtonsDetails);

			// boolean discard = isDisplayed(driver, discardButton);

			BaseSuite.validationReportLog(" discard" + " button is disabled in the page.");

			BaseSuite.validationReportLog(" Discard button visibility is matched with expected condition.");

			verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard", false);

			verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate", false);

			verifyVisibilityOfButtons(driver, clickonDisable, "Delete", false);

			verifyFeildData(connName, "ConnectorName");

			dropDownDiscard(connFlatFileDriverField, connFlatFileDriverDDBtn, connFlatFileDriverDDList,
					secondvalueselect);

			waitForExecution(1000);

			dropDownDiscard(connAuthTypeField, connAuthTypeSearchIcon, connAuthTypeList, secondvalueselect);

			waitForExecution(1000);

			click(driver, connCustomJDBCCheckbox);

			BaseSuite.validationReportLog("Checkbox Selected successfully");

			validatediscardBtn();

			clickOnButton(driver, discardpopupdiscardbtn, "Discard", true);

			if (connectorName.contains(ConstantProperty.CONN_SNOWFLAKE)) {
				verifyFeildData(accountIdentifierInput, "I am Account Identifier");
				verifyFeildData(connWarehouseInput, "I am Warehouse");
				verifyFeildData(connDatabaseInput, "I am Database");
				verifyFeildData(connUsernameInput, "I am Username");
				verifyFeildData(keyVaultName, "I am key Vault Name");
				verifyFeildData(clientId, "I am client Id");
				verifyFeildData(tenantId, "I am tenant Id");
				verifyFeildData(clientSecret, "I am client Secret");
				verifyFeildData(privateKeySecretName, "I am private Key Secret Name");
				verifyFeildData(privateKeyPasswordSecretName, "I am private Key Password Secret Name");
			}

			else {

				verifyFeildData(connHostInputField, "HostName");

				verifyFeildData(connPortInputField, "PortName");

				verifyFeildData(connDatabaseInputField, "DatabaseName");

			}

			dropDownDiscard(connTypeFeildverify, connTypedropdownOpener, connTypeList, connTypeSelect);

			if (connectorName.contains(ConstantProperty.CONN_ORACLE)) {
				verifyFeildData(principalFeild, "I am principal");
			} else {
				if (!connectorName.contains(ConstantProperty.CONN_SNOWFLAKE)) {

					dropDownDiscard(connsecretName, connsecretNamedropdownbtn, connsecretPassdropdownlist,
							connTypeSelect);

					verifyFeildData(connUsernameInput, "UserName Entered");

					dropDownDiscard(connsecretPasswordfeild, connsecretPassworddropdownbtn, connsecretPassdropdownlist,
							connTypeSelect);
				}
			}
			waitForExecution(1000);
		} catch (Exception e) {

			e.getMessage();
		}

	}

	@SuppressWarnings("unused")
	public void existingConnnectionDiscardFuctionality(String name, String connectorName) {

		try {

			waitForExecution(1000);

			clickOnButton(driver, connectionTab, "ConnectionTab", true);

			searchAndClickOnConnectionNameInConnRepo(name);

			verifyVisibilityOfButtons(driver, connSaveBtn, "Save", false);

			verifyVisibilityOfButtons(driver, connTestBtn, "Test", true);

			boolean discard = isDisplayed(driver, discardButton);

			BaseSuite.validationReportLog(" discard" + " button is disabled in the page.");

			BaseSuite.validationReportLog(" Discard button visibility is matched with expected condition.");

			// verifyVisibilityOfButtons(driver, clickonRefresh, "Refresh", true);

			verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate", true);

			verifyVisibilityOfButtons(driver, clickonDisable, "Delete", true);

			verifyFeildData(connName, "ConnectorName");

			dropDownDiscard(connFlatFileDriverField, connFlatFileDriverDDBtn, connFlatFileDriverDDList,
					secondvalueselect);

			dropDownDiscard(connAuthTypeField, connAuthTypeSearchIcon, connAuthTypeList, secondvalueselect);

			waitForExecution(3000);

			click(driver, connCustomJDBCCheckbox);

			waitForExecution(2000);

			BaseSuite.validationReportLog("Checkbox Selected successfully");

			// verifyVisibilityOfButtons(driver, connSaveBtn, "Save", true);

			// verifyVisibilityOfButtons(driver, connTestBtn, "Test", false);

			// verifyVisibilityOfButtons(driver, discardButton, "Discard", true);

			// verifyVisibilityOfButtons(driver, clickonRefresh, "Refresh", true);

			// verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate", true);

			// verifyVisibilityOfButtons(driver, clickonDisable, "Delete", true);

			validatediscardBtn();

			clickOnButton(driver, discardpopupdiscardbtn, "Discard", true);

			if (connectorName.contains(ConstantProperty.CONN_SNOWFLAKE)) {
				verifyFeildData(accountIdentifierInput, "I am Account Identifier");
				verifyFeildData(connWarehouseInput, "I am Warehouse");
				verifyFeildData(connDatabaseInput, "I am Database");
				verifyFeildData(connUsernameInput, "I am Username");
				verifyFeildData(keyVaultName, "I am key Vault Name");
				verifyFeildData(clientId, "I am client Id");
				verifyFeildData(tenantId, "I am tenant Id");
				verifyFeildData(clientSecret, "I am client Secret");
				verifyFeildData(privateKeySecretName, "I am private Key Secret Name");
				verifyFeildData(privateKeyPasswordSecretName, "I am private Key Password Secret Name");
			}

			else {

				verifyFeildData(connHostInputField, "HostName");

				verifyFeildData(connPortInputField, "PortName");

				verifyFeildData(connDatabaseInputField, "DatabaseName");

			}

			dropDownDiscard(connTypeFeildverify, connTypedropdownOpener, connTypeList, connTypeSelect);

			if (!connectorName.contains(ConstantProperty.CONN_SNOWFLAKE)) {

				dropDownDiscard(connsecretName, connsecretNamedropdownbtn, connsecretPassdropdownlist, connTypeSelect);

				verifyFeildData(connUsernameInput, "UserName Entered");

				dropDownDiscard(connsecretPasswordfeild, connsecretPassworddropdownbtn, connsecretPassdropdownlist,
						connTypeSelect);
			}

			waitForExecution(1000);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void existingUserConnnectionDiscardFuctionality(String name, String connectorName) {

		try {

			searchAndClickOnConnectionNameInConnRepo(name);

			if (connectorName.contains(ConstantProperty.CONN_SNOWFLAKE)) {

				verifyFeildData(connUsernameInput, "I am Username");
				verifyFeildData(keyVaultName, "I am key Vault Name");
				verifyFeildData(clientId, "I am client Id");
				verifyFeildData(tenantId, "I am tenant Id");
				verifyFeildData(clientSecret, "I am client Secret");
				verifyFeildData(privateKeySecretName, "I am private Key Secret Name");
				verifyFeildData(privateKeyPasswordSecretName, "I am private Key Password Secret Name");
			} else {

				dropDownDiscard(connsecretName, connsecretNamedropdownbtn, connsecretPassdropdownlist, connTypeSelect);

				verifyFeildData(connUsernameInput, "UserName Entered");

				dropDownDiscard(connsecretPasswordfeild, connsecretPassworddropdownbtn, connsecretPassdropdownlist,
						connTypeSelect);
			}
			waitForExecution(1000);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void newFileConnnectionDiscardFuctionality(String connectorName) {

		try {

			verifyVisibilityOfButtons(driver, connSaveBtn, "Save", false);

			verifyVisibilityOfButtons(driver, connTestBtn, "Test", false);

			boolean discard = isDisplayed(driver, discardButton);

			BaseSuite.validationReportLog(" discard" + " button is disabled in the page.");

			BaseSuite.validationReportLog(" Discard button visibility is matched with expected condition.");

			verifyVisibilityOfButtons(driver, clickonRefresh, "Refresh", false);

			verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate", false);

			verifyVisibilityOfButtons(driver, clickonDisable, "Delete", false);

			verifyFeildData(connName, "ConnectorName");

			if ((connectorName.toLowerCase().equalsIgnoreCase("Flat File (SQL)"))
					|| (connectorName.toLowerCase().equalsIgnoreCase("XML"))
					|| (connectorName.toLowerCase().equalsIgnoreCase("JSON"))) {

				dropDownDiscard(connFlatFileDriverField, connFlatFileDriverDDBtn, connFlatFileDriverDDList,
						secondvalueselect);
			}

			dropDownDiscard(connFlatFileLocationField, connFlatFileLocationDDBtn, connFlatFileLocationDDList,
					secondvalueselect);

			dropDownDiscard(connAuthTypeField, connAuthTypeSearchIcon, connAuthTypeList, secondvalueselect);

			verifyFeildData(connFlatFileContainerField, "ContainerValue");

			verifyFeildData(connFlatFileFolderPathField, "Folder Path");

			verifyFeildData(connFlatFileRegionField, "Region value");

			dropDownDiscard(connTypeFeildverify, connTypedropdownOpener, connTypeList, connTypeSelect);

			verifyFeildData(connFlatFileAccesskeyField, "Access key Data");

			verifyFeildData(connFlatFileSecretkeyField, "Secret key Data");

			verifyFeildData(connSessionTokenField, "Session Token");

			waitForExecution(1000);
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void discardFuctionality(String connectionType, String icedqUser, String connectorName, String name) {
		try {

			if (connectionType.toLowerCase().contains(ConstantProperty.CONN_SYSTETYPE)) {

				clickOnNewConnectionBtn(icedqUser);

				chooseConnectorType(connectorName);

				if (icedqUser.contains("owner")) {

					newConnnectionDiscardFuctionality(connectorName);

				} else {
					saveConnection(forbiddenToastMsg);

				}

				existingConnnectionDiscardFuctionality(name, connectorName);
			} else {
				existingUserConnnectionDiscardFuctionality(name, connectorName);

			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void newDiscardFuctionality(String connectionType, String icedqUser, String connectorName, String name) {
		try {

			if (connectionType.toLowerCase().contains(ConstantProperty.CONN_SYSTETYPE)) {

				clickOnNewConnectionBtn(icedqUser);

				chooseConnectorType(connectorName);

				if (icedqUser.contains("owner")) {

					switch (connectorName.trim()) {

					case "Flat File (SQL)":
					case "XML":
					case "JSON":
					case "Flat File":

						newFileConnnectionDiscardFuctionality(connectorName);

						break;

					default:
						newConnnectionDiscardFuctionality(connectorName);
						break;
					}

				} else {
					saveConnection(forbiddenToastMsg);

				}

				existingConnnectionDiscardFuctionality(name, connectorName);
			} else {
				existingUserConnnectionDiscardFuctionality(name, connectorName);

			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	/* Salesforce common methods starts */

	public boolean createSalesforceConnection(String connJsonEntity, String testScenario, String validationMessage,
			String icedqUser) {
		boolean flag = true;
		String newconnectionName = null;
		LoginPage lp = new LoginPage(driver);
		NewConnectionRepoPage rp = new NewConnectionRepoPage(driver);
		try {

			if (isDisplayed(driver, userName) && isDisplayed(driver, passWord)) {

				flag = lp.loginWithIcedqUserAndSelectWorkspace(icedqUser, ConstantProperty.TARGET_WORKSPACE_NAME,
						ConstantProperty.CONNECTIONREPOMODULENAME, "");

			}
			if (flag) {

				ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

				newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
						+ ConstantProperty.TARGET_WORKSPACE_NAME;

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				flag = clickOnNewConnectionBtn(icedqUser);

				if (flag) {

					chooseConnectorType(connParam.getConnectorID());

					inVisible(driver, spinner, Constant.ruleWait);

					String wizardStatus = validateNewConnPageButtonsFields(connParam.getConnectorID());

					if (wizardStatus.contains("Wizard supported connector")) {

						verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", false);
					}

					verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

					verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);

					verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

					verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", false);

					verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", false);

					enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

					selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

					String authNew = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity,
							"$.authTypeId");

					if (authNew.contains("oauth")) {

						authNew = "OAuth Connected App";

					}
					selectAuthenticationOfConnection(authNew);

					validateInputFieldVisibility(callbackurl, ConstantProperty.CONN_CALLBACK_LABEL, "", true);

					boolean sb = enableCheckboxOfSandbox(connParam.getSandboxcheckbox());

					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					selectConnectionType(chooseConnType, connParam.getType());

					rp.enterClientId(connParam.getClientId());

					if (sb) {

						secretUsesrSandox(connJsonEntity, connParam.getConnectorID(), icedqUser);
					} else {
						entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
								connParam.getConnectorID(), icedqUser);

					}

					ArrayList<String> connPropertyList = TestDataThroughApi
							.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

					int count = connPropertyList.size();

					addConnectionPropertiesToConnection(connJsonEntity, count);

					clickOnOverviewTab();

					if (icedqUser.toLowerCase().contains("owner")) {

						flag = saveConnection(connectionSaveMesssage);

						if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

							inVisible(driver, spinner, Constant.ruleWait);

							waitForExecution(2000);

							salesforcePopupWindow();

							waitForExecution(3000);

							String title = driver.getTitle();

							if (title.equalsIgnoreCase("Login | Salesforce")) {
								salesforceSandboxPage();
							}

							clickOnConnectionsTab();

							searchConnection(newconnectionName);

							getConnection(newconnectionName, update_actualValue);

							searchAndClickOnConnectionNameInConnRepo(newconnectionName);

							flag = testConnection(connectionTestMess);

							clickOnConnectionsTab();

							waitForExecution(2000);

							searchConnection(newconnectionName);

							getConnection(newconnectionName, create_actualValue);

							searchAndClickOnConnectionNameInConnRepo(newconnectionName);
						} else {

							flag = updateSalesforceConnForUserConnection(connJsonEntity, connParam, connParam.getType(),
									newconnectionName, icedqUser);
						}
					} else {

						flag = saveConnection(forbiddenToastMsg);
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

	/**** Validation for salesforce Popup ****/

	public void salesforcePopupWindow() {

		try {
			isDisplayedInLoop(driver, 2, salesforcePopupWindowTitle);

			if (isDisplayed(driver, salesforcePopupWindowTitle)) {

				verifyIndividualLabel(driver, salesforcePopupWindowTitle, "Salesforce Popup");

				String ac = getAttribute(driver, salesforcePopupWindowContent, attributeTextContent);

				stringContainsOutput(ac, salesforcePopupContent, true);

				verifyVisibilityOfButtons(driver, salesforcePopupWindowCancelButton, "Cancel", true);

				verifyVisibilityOfButtons(driver, salesforcePopupWindowYesButton, "Yes", true);

				clickOnButton(driver, salesforcePopupWindowYesButton, "Yes", true);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Error while handleSalesforcePopupWindow kindly check :" + e.toString());
		}

	}

	public void salesforceSandboxPage() {

		try {
			String login = getAttribute(driver, salesforceloginbtn, "value");

			if (login.contains("Sandbox")) {
				BaseSuite.reportLog("salesforcelogo displayed clearly.");
				salesforceSandboxUsername("shrikant.p-amzf@force.com.nextgensx");
				salesforceSandboxPassword("$alesForcePr0dConn1");
				verifyVisibilityOfButtons(driver, sandboxloginbtn, "login button", true);

				clickOnButton(driver, sandboxloginbtn, "login button", true);
			} else {
				BaseSuite.reportLog("salesforcelogo displayed clearly.");
				salesforceSandboxUsername("chetanb@torana.sandbox");
				salesforceSandboxPassword("Admin@2024");
				verifyVisibilityOfButtons(driver, salesforceloginbtn, "login button", true);

				clickOnButton(driver, salesforceloginbtn, "login button", true);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Error while handleSalesforcePopupWindow kindly check :" + e.toString());
		}

	}

	// Method to validate & enter Username
	public void salesforceSandboxUsername(String value) throws NullPointerException {

		String methodName = "salesforceSandboxUsername";
		try {
			javascript(driver, scrollToElementArg, sandboxUsername);

			if (isDisplayed(driver, sandboxUsername)) {
				BaseSuite.reportLog("Username field is displayed.");

				if (isEnabled(driver, sandboxUsername)) {
					if (isEditable(driver, sandboxUsername, " username")) {

						clear(driver, sandboxUsername);

						sendKeys(driver, sandboxUsername, value.trim());

						isDisplayedInLoop(driver, 1, sandboxUsername);

						String username = getAttribute(driver, sandboxUsername, valueAttribute).trim();

						compareActualNExpectedValue(username.trim(), value.trim());

					}

				} else {
					BaseSuite.reportFailLog("Username input is disabled, kindly check.", methodName);
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate username field on current page, kindly check.", methodName);
			}

		} catch (Exception e) {
			e.getMessage();

		}
	}

	// Method to validate & enter Password
	public void salesforceSandboxPassword(String value) throws NullPointerException {

		String methodName = "salesforceSandboxPassword";
		try {
			javascript(driver, scrollToElementArg, sandboxPassword);

			if (isDisplayed(driver, sandboxPassword)) {
				BaseSuite.reportLog("Password field is displayed.");

				if (isEnabled(driver, sandboxPassword)) {
					if (isEditable(driver, sandboxPassword, " password")) {

						clear(driver, sandboxPassword);

						sendKeys(driver, sandboxPassword, value.trim());

						BaseSuite.validationReportLog("Entered password in password field.");
					}

				} else {
					BaseSuite.reportFailLog("Password input is disabled, kindly check.", methodName);
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate password field on current page, kindly check.", methodName);
			}

		} catch (Exception e) {
			e.getMessage();

		}
	}

	public boolean updateSalesforceConnForUserConnection(String connJsonEntity, ConnectionPoJO connParam,
			String connectionType, String connectionName, String icedqUser) {
		boolean flag = true;
		NewConnectionRepoPage rp = new NewConnectionRepoPage(driver);
		try {
			if (!icedqUser.toLowerCase().contains("reader")) {

				if (connectionType.trim().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

					waitForExecution(1000);

					clickOnUserConnectionTab();

					waitForExecution(2000);

					searchAndClickOnConnectionNameInConnRepo(connectionName);

					inVisible(driver, spinner, Constant.ruleWait);

					waitForExecution(1000);

					flag = isEnabled(driver, authorizebtn);

					if (flag) {

						displayAndClick(driver, authorizebtn);

						waitForExecution(2000);

						salesforcePopupWindow();

						waitForExecution(4000);

						String title = driver.getTitle();

						if (title.equalsIgnoreCase("Login | Salesforce")) {
							salesforceSandboxPage();
						}
					}
					inVisible(driver, spinner, Constant.ruleWait);

					flag = isEnabled(driver, connTestBtn);

					if (flag) {

						clickOnUserConnectionTab();

						waitForExecution(2000);

						searchConnection(connectionName);

						getConnection(connectionName, update_actualValue);

						searchAndClickOnConnectionNameInConnRepo(connectionName);

						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

					} else {
						BaseSuite.reportErrorLog(
								"After Authorize Test button is not enabled. Please check!!!" + "isEnable");
					}

					if (flag) {

						waitForExecution(2000);

						inVisible(driver, spinner, Constant.ruleWait);

						flag = testConnection(connectionTestMess);

						clickOnUserConnectionTab();

						waitForExecution(2000);

						searchConnection(connectionName);

						getConnection(connectionName, create_actualValue);

						searchAndClickOnConnectionNameInConnRepo(connectionName);
					}
				}
			}
		} catch (Exception e) {

			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("user connection not updated properly kindly check :" + e.toString());
		}

		return flag;
	}

	public void addConnectionPropertiesToHiveConnection(String jsonEntity, int count) throws Exception {
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(jsonEntity);
			if (count > 0) {
				clickOnPropertiesTab();

				ArrayList<String> name = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						connConnectionPropNames);

				ArrayList<String> value = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						connConnectionPropValues);

				ArrayList<String> type = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						connConnectionPropTypes);

				for (int j = 0; j < name.size(); j++) {

					if (name.get(j).contains("loginTimeout")) {

						validateDefaultConnectionProperty(name.get(j), value.get(j), type.get(j));

					} else {

						addConnectionProperty(name.get(j), value.get(j), type.get(j));

						if ((connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS_KEYTAB))
								|| (connParam.getAuthenticationname()
										.equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS_TICKET_CACHE))) {

							addJaasPropertiesToConnection(connParam.getJaasProperties());
						}

					}
				}

			}
			clickOnOverviewTab();

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();

		}
	}

	public boolean updateUsernameAndPasswordForHiveAndImpalaConnection(String connJsonEntity, ConnectionPoJO connParam,
			String connectionType, String connectionName, String icedqUser) {
		boolean flag = true;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);

		String UserKeytabLocation = System.getProperty("user.dir") + Constant.USER_KEYTAB_LOCATION;

		String connusername = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);
		
		if (connusername.isEmpty()) {
			
			connusername = connParam.getUsername();
		}

		try {

			if (connectionType.trim().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				waitForExecution(1000);

				cp.clickOnUserConnectionTab();

				isDisplayedInLoop(driver, 0, discardButtons);
				if (isDisplayed(driver, discardButtons)) {
					displayAndClick(driver, discardButtons);
				}

				cp.searchAndClickOnConnectionNameInConnRepo(connectionName);

				if (connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {

					entersecretPassword(connJsonEntity, connParam.getAuthenticationname(), connParam.getConnectorID(),
							icedqUser);

					enterUsername(connusername);

				} else if (connParam.getAuthenticationname()
						.equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS_TICKET_CACHE)) {

					validatAndeEnterValueToTextField(connUserPrincipalLabel, connHiveUserPrincipal,
							ConstantProperty.CONN_FIELD_USERPRINCIPAL, connPrincipalPlaceholder,
							connParam.getUserPrincipal(), validationUserprincipal);

					validatAndeEnterValueToTextField(ticketCacheLabel, ticketCachefeild,
							ConstantProperty.CONN_FIELD_TICKETCACHEFEILD, connTicketCachePlaceHolder,
							connParam.getTicketCacheFileName(), connTcktCacheValidation);

				} else {
					WebElement m = driver.findElement(By.xpath("//input[@id='keytab']"));

					m.sendKeys(UserKeytabLocation);

					BaseSuite.validationReportLog("User key tab File Choosed successfully");

					validatAndeEnterValueToTextField(connUserPrincipalLabel, connHiveUserPrincipal,
							ConstantProperty.CONN_FIELD_USERPRINCIPAL, connPrincipalPlaceholder,
							connParam.getUserPrincipal(), validationUserprincipal);

				}

				flag = saveConnection();

				inVisible(driver, spinner, Constant.ruleWait);

				flag = testConnection(connectionTestMess);

				clickOnUserConnectionTab();

				waitForExecution(1000);

				cp.searchConnection(connectionName);

				cp.getConnection(connectionName, create_actualValue);

				// cp.searchAndClickOnConnectionNameInConnRepo(connectionName);

			} else {
				waitForExecution(1000);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				inVisible(driver, spinner, Constant.ruleWait);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				flag = testConnection(connectionTestMess);

				waitForExecution(2000);

				clickOnConnectionsTab();

				isDisplayedInLoop(driver, 0, discardButtons);
				if (isDisplayed(driver, discardButtons)) {
					displayAndClick(driver, discardButtons);
				}

				waitForExecution(1000);

				searchConnection(connectionName);

				getConnection(connectionName, create_actualValue);

			}
		} catch (Exception e) {

			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("user connection not updated properly kindly check :" + e.toString());
		}

		return flag;
	}

	/** View Salesforce connection details method **/

	public boolean viewSalesforceConnection(String connJsonEntity, String driverName) {
		boolean flag = true;

		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);

			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

			waitForExecution(2000);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				inVisible(driver, spinner, Constant.ruleWait);

				viewAndValidateConnectionField(connName, "Connection Name ", connParam.getConnName(), true);

				viewAndValidateConnectionField(connFlatFileDriverField, "Driver ", driverName, true);

				String authNew = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity, "$.authTypeId");

				if (authNew.contains("oauth")) {

					authNew = "OAuth Connected App";

				}

				viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION, authNew,
						true);

				if (isDisplayed(driver, connsecretName)) {

					validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", true);

					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					waitForExecution(1000);

					verifyVisibilityOfButtons(driver, connsecretManagebtn, "Manage Button", true);

					verifyVisibilityOfButtons(driver, connsecretQuickAddbtn, "Quick Add Button", true);

					validateInputFieldVisibility(clientId, ConstantProperty.CONN_FEILD_CLIENTID, "", true);

					validateInputFieldVisibility(connsecretidfield, ConstantProperty.CONN_FIELD_SECRETID, "", true);
				}

				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

				int count = connPropertyList.size();

				flag = viewAndValidateConnectionPropertiesToConnection(connJsonEntity, count);

			} else {

				inVisible(driver, spinner, Constant.ruleWait);

				viewAndValidateConnectionField(connName, "Connection Name", connParam.getConnName(), false);

				viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, false);

				viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
						connParam.getAuthenticationname(), false);

				if (isDisplayed(driver, connsecretName)) {

					validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", true);

					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					verifyVisibilityOfButtons(driver, connsecretManagebtn, "Manage Button", true);

					verifyVisibilityOfButtons(driver, connsecretQuickAddbtn, "Quick Add Button", true);

					waitForExecution(1000);

					validateInputFieldVisibility(clientId, ConstantProperty.CONN_FEILD_CLIENTID, "", true);

					validateInputFieldVisibility(connsecretidfield, ConstantProperty.CONN_FIELD_SECRETID, "", true);

				}

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

	/** Test Salesforce connection common method **/

	public boolean testSalesforceConnection(String connJsonEntity, String icedqUser) {
		boolean flag = false;
		RahulConnectionPage rp = new RahulConnectionPage(driver);
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);

			waitForExecution(1000);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				if (!icedqUser.contains("reader")) {

					waitForExecution(2000);

					flag = testConnection(connectionTestMess);

				} else {
					flag = testConnection(forbiddenToastMsg);
				}
			} else {

				if (!icedqUser.contains("reader")) {

					if (isEnabled(driver, connTestBtn) && isEnabled(driver, authorizebtn)) {

						displayAndClick(driver, authorizebtn);

						waitForExecution(4000);

						String title = driver.getTitle();

						if (title.equalsIgnoreCase("Login | Salesforce")) {
							salesforceSandboxPage();
						}

						waitForExecution(1000);
						inVisible(driver, spinner, Constant.ruleWait);
						flag = testConnection(connectionTestMess);

					}
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

	/** Update Salesforce connection common method **/

	/** Salesforce **/
	public boolean updateSalesforceConnection(String connJsonEntity, String testScenario, String validationMessage,
			String icedqUser) {
		boolean flag = true;
		String newconnectionName = null;
		NewConnectionRepoPage cp = new NewConnectionRepoPage(driver);
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

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
					connName = connParam.getConnName() + "_" + ConstantProperty.TARGET_WORKSPACE_NAME;
				}
				searchAndClickOnConnectionNameInConnRepo(connName);

			}
			inVisible(driver, spinner, Constant.ruleWait);

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

			selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

			String authNew = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity, "$.authTypeId");

			if (authNew.contains("oauth")) {

				authNew = "OAuth Connected App";

			}
			selectAuthenticationOfConnection(authNew);

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			Thread.sleep(1000);

			selectConnectionType(chooseConnType, connParam.getType());

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)
					|| connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				entersecretPassword(connJsonEntity, connParam.getAuthenticationname(), connParam.getConnectorID(),
						icedqUser);
				cp.enterClientId(connParam.getClientId());
			}

			/*
			 * else {
			 * 
			 * validateInputFieldVisibility(connsecretName,
			 * ConstantProperty.CONN_FIELD_SECRETNAME, "", false);
			 * 
			 * validateInputFieldVisibility(clientId, ConstantProperty.CONN_FEILD_CLIENTID,
			 * "", false);
			 * 
			 * validateInputFieldVisibility(connsecretidfield,
			 * ConstantProperty.CONN_FIELD_SECRETID, "", false);
			 * 
			 * }
			 */

			ArrayList<String> connPropertyList = TestDataThroughApi
					.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

			int count = connPropertyList.size();

			if (count > 0) {

				if ((connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE))) {

					updateConnectionPropertiesToConnection(connJsonEntity, count);

				} else {

					saveConnection();

					updateUserConnectionPropertiesToConnection(connJsonEntity, count,
							ConstantProperty.ICEDQ_WORKSPACE_OWNERUSER);

					/*
					 * Thread.sleep(1000);
					 * 
					 * entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
					 * connParam.getConnectorID(), icedqUser);
					 * 
					 * cp.enterClientId(connParam.getClientId());
					 */
				}
			}

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				saveConnection();

				clickOnUserConnectionTab();

				searchAndClickOnConnectionNameInConnRepo(newconnectionName);

				if (!icedqUser.contains("reader")) {

					if (isEnabled(driver, connTestBtn) && isEnabled(driver, authorizebtn)) {

						displayAndClick(driver, authorizebtn);

						waitForExecution(4000);

						String title = driver.getTitle();

						if (title.equalsIgnoreCase("Login | Salesforce")) {
							salesforceSandboxPage();
						}

						waitForExecution(10000);
						inVisible(driver, spinner, Constant.ruleWait);
						flag = testConnection(connectionTestMess);

					}
				} else {
					flag = clickQuickAddbtn(forbiddenToastMsg);
				}
			} else {
				if (icedqUser.toLowerCase().contains("reader")) {

					saveConnection(updateAndSaveClickErrorMessage);

				} else {
					saveConnection();
					inVisible(driver, spinner, Constant.ruleWait);
					salesforcePopupWindow();
					waitForExecution(2000);
					testConnection(connectionTestMess);
				}
			}
		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not updated properly kindly check :" + e.toString());
		}
		return flag;
	}

	/** Enable Use Sandbox check box method **/

	public boolean enableCheckboxOfSandbox(String state) {
		String str = "check";
		boolean flag = false;
		try {
			isDisplayedInLoop(driver, 5, sandboxlabel);

			javascript(driver, scrollToElementArg, sandboxlabel);

			if (isDisplayed(driver, sandboxlabel)) {

				BaseSuite.reportLog("verifying Use Sandbox checkbox");

				if (isDisplayed(driver, sandboxcheckbox)) {

					BaseSuite.validationReportLog("Use Sandbox checkbox is visible");

					String actualState = getAttribute(driver, sandboxcheckbox, attributeClassName);

					if (actualState.contains(str)) {

						BaseSuite.reportLog("Default condition of Use Sandbox checkbox is checked");
					} else {
						BaseSuite.reportLog("Default condition of Use Sandbox checkbox is unchecked");
					}

					if (Boolean.parseBoolean(state) && !actualState.contains(str)) {

						BaseSuite.reportLog("Clicking on Use Sandbox checkbox");

						displayAndClick(driver, sandboxcheckbox);

						actualState = getAttribute(driver, sandboxcheckbox, attributeClassName);

						stringContainsOutput(actualState, str, true);
						flag = true;
					} else if (state.equalsIgnoreCase("false") && actualState.contains(str)) {

						BaseSuite.reportLog("Clicking on custom JDBC URL checkbox");

						displayAndClick(driver, sandboxcheckbox);

						flag = true;
					}

				} else {
					BaseSuite.reportFailLog("Use Sandbox checkbox not visible ", "enableCheckboxOfSandbox");
				}
			} else {
				BaseSuite.reportFailLog("Use Sandbox field not visible ", "enableCheckboxOfSandbox");
			}
		} catch (Exception e) {
			e.getMessage();
			throw new NoSuchElementException();
		}
		return flag;
	}

	public boolean authorizeSalesforceConnection(String connJsonEntity, String icedqUser) {
		boolean flag = true;
		RahulConnectionPage rp = new RahulConnectionPage(driver);
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);

			waitForExecution(1000);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				if (icedqUser.contains("owner")) {

					waitForExecution(2000);

					if (isDisplayed(driver, authorizebtn)) {

						click(driver, authorizebtn);
						String title = driver.getTitle();
						if (title.equalsIgnoreCase("Login | Salesforce")) {
							salesforceSandboxPage();
						}
					}
				} else {
					if (isEnabled(driver, authorizebtn)) {
						BaseSuite.reportFailLog("Button is Enabled , Hence condition is failed",
								"authorizeSalesforceConnection");
					} else {
						BaseSuite.reportLog("Button is disabled , Hence condition is Passed");
					}
				}
			} else {

				if (icedqUser.contains("reader")) {
					if (isEnabled(driver, authorizebtn)) {
						BaseSuite.reportFailLog("Button is Enabled , Hence condition is failed",
								"authorizeSalesforceConnection");
					} else {
						BaseSuite.reportLog("Button is disabled , Hence condition is Passed");
					}

				} else {

					entersecretPassword(connJsonEntity, connParam.getAuthenticationname(), connParam.getConnectorID(),
							icedqUser);

					rp.enterClientId(connParam.getClientId());

					flag = saveConnection();

					salesforcePopupWindow();

					waitForExecution(3000);

					String title = driver.getTitle();

					if (title.equalsIgnoreCase("Login | Salesforce")) {
						salesforceSandboxPage();
					}

				}
			}

		} catch (Exception e) {
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not tested properly kindly check :" + e.toString());

		}

		return flag;
	}

	public void salesforceDiscardFuctionality(String connectionType, String icedqUser, String connectorName,
			String name) {
		try {

			if (connectionType.toLowerCase().contains(ConstantProperty.CONN_SYSTETYPE)) {

				clickOnNewConnectionBtn(icedqUser);

				chooseConnectorType(connectorName);

				if (icedqUser.contains("owner")) {

					newSalesforceConnnectionDiscardFuctionality(connectorName);

				} else {
					saveConnection(forbiddenToastMsg);

				}

				existingSalesforceConnnectionDiscardFuctionality(name, connectorName);
			} else {
				existingSalesforceUserConnnectionDiscardFuctionality(name, connectorName);

			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void newSalesforceConnnectionDiscardFuctionality(String connectorName) {

		try {

			verifyVisibilityOfButtons(driver, connSaveBtn, "Save", false);

			verifyVisibilityOfButtons(driver, connTestBtn, "Test", false);

			boolean discard = isDisplayed(driver, discardButton);

			BaseSuite.validationReportLog(" discard" + " button is disabled in the page.");

			BaseSuite.validationReportLog(" Discard button visibility is matched with expected condition.");

			verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate", false);

			verifyVisibilityOfButtons(driver, clickonDisable, "Delete", false);

			verifyFeildData(connName, "ConnectorName");

			dropDownDiscard(connFlatFileDriverField, connFlatFileDriverDDBtn, connFlatFileDriverDDList,
					secondvalueselect);

			waitForExecution(1000);

			dropDownDiscard(connAuthTypeField, connAuthTypeSearchIcon, connAuthTypeList, secondvalueselect);

			waitForExecution(1000);

			click(driver, sandboxcheckbox);

			BaseSuite.validationReportLog("Checkbox Selected successfully");

			validatediscardBtn();

			clickOnButton(driver, discardpopupdiscardbtn, "Discard", true);

			dropDownDiscard(connTypeFeildverify, connTypedropdownOpener, connTypeList, connTypeSelect);

			dropDownDiscard(connsecretName, connsecretNamedropdownbtn, connsecretPassdropdownlist, connTypeSelect);

			verifyFeildData(clientId, "client id Entered");

			dropDownDiscard(connsecretidfield, connsecretiddropdownbtn, connsecretPassdropdownlist, connTypeSelect);

			waitForExecution(1000);
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void existingSalesforceConnnectionDiscardFuctionality(String name, String connectorName) {

		try {

			waitForExecution(1000);

			clickOnButton(driver, connectionTab, "ConnectionTab", true);

			searchAndClickOnConnectionNameInConnRepo(name);

			verifyVisibilityOfButtons(driver, connSaveBtn, "Save", false);

			verifyVisibilityOfButtons(driver, connTestBtn, "Test", true);

			boolean discard = isDisplayed(driver, discardButton);

			BaseSuite.validationReportLog(" discard" + " button is disabled in the page.");

			BaseSuite.validationReportLog(" Discard button visibility is matched with expected condition.");

			verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate", true);

			verifyVisibilityOfButtons(driver, clickonDisable, "Delete", true);

			verifyFeildData(connName, "ConnectorName");

			dropDownDiscard(connFlatFileDriverField, connFlatFileDriverDDBtn, connFlatFileDriverDDList,
					secondvalueselect);

			dropDownDiscard(connAuthTypeField, connAuthTypeSearchIcon, connAuthTypeList, secondvalueselect);

			waitForExecution(3000);

			click(driver, sandboxcheckbox);

			waitForExecution(2000);

			BaseSuite.validationReportLog("Checkbox Selected successfully");

			validatediscardBtn();

			clickOnButton(driver, discardpopupdiscardbtn, "Discard", true);

			dropDownDiscard(connTypeFeildverify, connTypedropdownOpener, connTypeList, connTypeSelect);

			dropDownDiscard(connsecretName, connsecretNamedropdownbtn, connsecretPassdropdownlist, connTypeSelect);

			verifyFeildData(clientId, "client id Entered");

			dropDownDiscard(connsecretidfield, connsecretiddropdownbtn, connsecretPassdropdownlist, connTypeSelect);

			waitForExecution(1000);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void existingSalesforceUserConnnectionDiscardFuctionality(String name, String connectorName) {

		try {

			searchAndClickOnConnectionNameInConnRepo(name);

			waitForExecution(1000);

			dropDownDiscard(connsecretName, connsecretNamedropdownbtn, connsecretPassdropdownlist, connTypeSelect);

			verifyFeildData(clientId, "client id Entered");

			dropDownDiscard(connsecretidfield, connsecretiddropdownbtn, connsecretPassdropdownlist, connTypeSelect);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void enterjavaTruststorePaaword(String value) throws NullPointerException {
		boolean flag = false;
		String methodName = "enterjavaTruststorePaaword";
		try {
			javascript(driver, scrollToElementArg, javaTruststorePaawordfeild);

			if (isDisplayed(driver, javaTruststorePaawordfeild)) {
				BaseSuite.reportLog("java Truststore Paaword field is displayed.");

				if (isEnabled(driver, javaTruststorePaawordfeild)) {
					if (isEditable(driver, javaTruststorePaawordfeild, " Java Truststore Password")) {

						clear(driver, javaTruststorePaawordfeild);

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag = verifyplaceholder(javaTruststorePaawordfeild, "Enter truststore password (optional)");

						if (flag) {
							BaseSuite.validationReportLog(
									"correct placeholder is displayed in java Truststore Paaword input box.");
						} else {
							BaseSuite.reportFailLog(
									"Expected placeholder didnt matched with actual placeholder, kindly check.",
									methodName);
						}

						sendKeys(driver, javaTruststorePaawordfeild, value.trim());

						isDisplayedInLoop(driver, 1, javaTruststorePaawordfeild);

						String username = getAttribute(driver, javaTruststorePaawordfeild, valueAttribute).trim();

						compareActualNExpectedValue(username.trim(), value.trim());

					}

				} else {
					BaseSuite.reportFailLog("java Truststore Paaword is disabled, kindly check.", methodName);
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate java Truststore Paaword field on current page, kindly check.",
						methodName);
			}

		} catch (Exception e) {
			e.getMessage();

		}
	}

	public boolean selectUseSSLOfConnection(String state) {
		String str = "check";
		boolean flag = false;
		try {
			isDisplayedInLoop(driver, 5, useSSLLabel);

			javascript(driver, scrollToElementArg, useSSLLabel);

			if (isDisplayed(driver, useSSLLabel)) {

				BaseSuite.reportLog("verifying Use SSL checkbox");

				if (isDisplayed(driver, useSSLCheckbox)) {

					BaseSuite.validationReportLog("Use SSL checkbox is visible");

					String actualState = getAttribute(driver, useSSLCheckbox, attributeClassName);

					if (actualState.contains(str)) {

						BaseSuite.reportLog("Default condition of Use SSL checkbox is checked");
					} else {
						BaseSuite.reportLog("Default condition of Use SSL checkbox is unchecked");
					}

					if (Boolean.parseBoolean(state) && !actualState.contains(str)) {

						BaseSuite.reportLog("Clicking on Use SSL checkbox");

						displayAndClick(driver, useSSLCheckbox);

						actualState = getAttribute(driver, useSSLCheckbox, attributeClassName);

						stringContainsOutput(actualState, str, true);
						flag = true;
					} else if (state.equalsIgnoreCase("false") && actualState.contains(str)) {

						BaseSuite.reportLog("Clicking on Use SSL checkbox");

						displayAndClick(driver, useSSLCheckbox);

						/**
						 * actualState = getAttribute(driver, connCustomJDBCCheckbox, "class");
						 * 
						 * stringContainsOutput(actualState, str, true);
						 **/
						flag = true;
					}

				} else {
					BaseSuite.reportFailLog("Use SSL checkbox not visible ", "selectUseSSLOfConnection");
				}
			} else {
				BaseSuite.reportFailLog("Use SSL field not visible ", "selectUseSSLOfConnection");
			}
		} catch (Exception e) {
			e.getMessage();
			throw new NoSuchElementException();
		}
		return flag;
	}

	public boolean createHiveConnection(String connJsonEntity, String testScenario, String validationMessage,
			String icedqUser) {
		boolean flag = true;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		String newconnectionName = null;
		LoginPage lp = new LoginPage(driver);
		String JavaTruststoreLocation = System.getProperty("user.dir") + Constant.JAVATRUST_STORE_LOCATION;
		String KerberosConfigLocation = System.getProperty("user.dir") + Constant.KERBEROS_CONFIG_LOCATION;
		String UserKeytabLocation = System.getProperty("user.dir") + Constant.USER_KEYTAB_LOCATION;
		try {
			if (isDisplayed(driver, userName) && isDisplayed(driver, passWord)) {

				flag = lp.loginWithIcedqUserAndSelectWorkspace(icedqUser, ConstantProperty.TARGET_WORKSPACE_NAME,
						ConstantProperty.CONNECTIONREPOMODULENAME, "");

			}
			if (flag) {

				ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

				if (icedqUser.contains(ConstantProperty.ICEDQ_WORKSPACE_OWNERUSER)) {

					newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
							+ ConstantProperty.TARGET_WORKSPACE_NAME + "_WO";
				} else {

					newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
							+ ConstantProperty.TARGET_WORKSPACE_NAME;
				}
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				String javaTrustStore = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 23);

				flag = clickOnNewConnectionBtn(icedqUser);

				if (flag) {

					chooseConnectorType(connParam.getConnectorID());

					inVisible(driver, spinner, Constant.ruleWait);

					String wizardStatus = validateNewConnPageButtonsFields(connParam.getConnectorID());

					if (wizardStatus.contains("Wizard supported connector")) {

						verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", false);
					}

					verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

					verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);

					verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

					verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", false);

					verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", false);

					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

					selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					boolean cs = selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

					enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());

					if (!connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD))

					{
						WebElement m = driver.findElement(By.xpath("//input[@id='krbFile']"));

						m.sendKeys(KerberosConfigLocation);

						BaseSuite.validationReportLog("Krb5 File Choosed successfully");

					}

					boolean ss = selectUseSSLOfConnection(connParam.getUseSSLCheckbox());

					if (ss) {

						verifyIndividualLabel(driver, javaTruststoreRadioLabel, "Java Truststore");

						// boolean radioBTNCheck = isSelected(driver, connFlatFileLocationDDBtn);

						BaseSuite.validationReportLog("Java Truststore Radio button Label visible");

						WebElement m = driver.findElement(By.xpath("//input[@id='jksFile']"));

						m.sendKeys(JavaTruststoreLocation);

						BaseSuite.validationReportLog("Java Truststore File Choosed successfully");

						enterjavaTruststorePaaword(javaTrustStore);

					}

					if (connParam.getAuthentication().equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

						validatAndeEnterValueToTextField(servicePrincipallabel, servicePrincipalfeild,
								ConstantProperty.CONN_SERVICECPRINCIPAL, connservicePrinciplePlaceHolder,
								connParam.getServicePrincipal(), validationServicePrincipalEmpty);
					}

					if (cs) {

						validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
								connHostPlaceholder, false);
						validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
								connPortPlaceholder, false);
						validateInputFieldVisibility(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
								connDatabasePlaceHolder, false);

					} else {
						validatAndeEnterValueToTextField(connHostTitle, connHostInputField,
								ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder, connParam.getHost(),
								validationHostEmpty);

						validatAndeEnterValueToTextField(connPortTitle, connPortInputField,
								ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder, connParam.getPort(),
								validationPortEmpty);

						validatAndeEnterValueToTextField(connDatabaseTitle, connDatabaseInputField,
								ConstantProperty.CONN_FIELD_DATABASE, connDatabasePlaceHolder,
								connParam.getDatabaseName(), validationDatabaseEmpty);
					}
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					selectConnectionType(chooseConnType, connParam.getType());

					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						if (connParam.getAuthenticationname()
								.equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {

							entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);

							enterUsername(connParam.getUsername());

						} else if (connParam.getAuthenticationname()
								.equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS_TICKET_CACHE)) {

							validatAndeEnterValueToTextField(connUserPrincipalLabel, connHiveUserPrincipal,
									ConstantProperty.CONN_FIELD_USERPRINCIPAL, connPrincipalPlaceholder,
									connParam.getUserPrincipal(), validationUserprincipal);

							validatAndeEnterValueToTextField(ticketCacheLabel, ticketCachefeild,
									ConstantProperty.CONN_FIELD_TICKETCACHEFEILD, connTicketCachePlaceHolder,
									connParam.getTicketCacheFileName(), connTcktCacheValidation);

						} else {
							WebElement m = driver.findElement(By.xpath("//input[@id='keytab']"));

							m.sendKeys(UserKeytabLocation);

							BaseSuite.validationReportLog("User key tab File Choosed successfully");

							validatAndeEnterValueToTextField(connUserPrincipalLabel, connHiveUserPrincipal,
									ConstantProperty.CONN_FIELD_USERPRINCIPAL, connPrincipalPlaceholder,
									connParam.getUserPrincipal(), validationUserprincipal);

						}

					} else {

						if (connParam.getAuthenticationname()
								.equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {

							validateInputFieldVisibility(connsecretUserPassword, ConstantProperty.CONN_FIELD_PASSWORD,
									"", false);

							validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "",
									false);

						} else if (connParam.getAuthenticationname()
								.equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS_TICKET_CACHE)) {

							validateInputFieldVisibility(connHiveUserPrincipal, ConstantProperty.CONN_USERPRINCIPAL, "",
									false);

							validateInputFieldVisibility(ticketCachefeild, ConstantProperty.CONN_FIELD_TICKETCACHEFEILD,
									"", false);

						} else {

							validateInputFieldVisibility(connHiveUserPrincipal, ConstantProperty.CONN_USERPRINCIPAL, "",
									false);

							isEnabled(driver, connUserKeytab);

							BaseSuite.validationReportLog("User key tab Field is Disabled");

							isEnabled(driver, chooseFileBtn);

							BaseSuite.validationReportLog("Choose File button is Disabled");
						}

					}
				}

				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

				int count = connPropertyList.size();

				addConnectionPropertiesToHiveConnection(connJsonEntity, count);

				if (icedqUser.toLowerCase().contains("owner")) {

					waitForExecution(1000);

					flag = saveConnection(connectionSaveMesssage);

					/*
					 * captureToastMsgForConnection(driver, toastMsg, popUpClose,
					 * connectionSaveMesssage, "Connection Save", true);
					 */

					clickOnConnectionsTab();

					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}

					cp.searchConnection(newconnectionName);

					getConnection(newconnectionName, update_actualValue);

					flag = searchAndClickOnConnectionNameInConnRepo(newconnectionName);

					if (flag) {

						flag = updateUsernameAndPasswordForHiveAndImpalaConnection(connJsonEntity, connParam,
								connParam.getType(), newconnectionName, icedqUser);
					}
				} else {

					flag = saveConnection(forbiddenToastMsg);
				}
			}

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" Database connection not created properly kindly check :" + e.toString());
		}
		return flag;
	}

	public void addJaasPropertiesToConnection(String value) throws Exception {
		boolean flag = false;
		String methodName = "addJaasPropertiesToConnection";
		try {

			verifyIndividualLabel(driver, jaasPropertiesTitle, "JAAS Properties");

			if (isDisplayed(driver, jaasPropertiesTextarea)) {
				BaseSuite.reportLog("JAAS Properties Textarea is displayed.");

				if (isEnabled(driver, jaasPropertiesTextarea)) {
					if (isEditable(driver, jaasPropertiesTextarea, "JAAS Properties")) {

						clear(driver, jaasPropertiesTextarea);

						BaseSuite.reportLog("Verify placeholder is present in Textarea.");

						flag = verifyplaceholder(jaasPropertiesTextarea, "Enter JAAS properties");

						if (flag) {
							BaseSuite.validationReportLog(
									"correct placeholder is displayed in JAAS Properties Textarea.");
						} else {
							BaseSuite.reportFailLog(
									"Expected placeholder didnt matched with actual placeholder, kindly check.",
									methodName);
						}

						sendKeys(driver, jaasPropertiesTextarea, value.trim());

						isDisplayedInLoop(driver, 1, jaasPropertiesTextarea);

						String jaas = getAttribute(driver, jaasPropertiesTextarea, valueAttribute).trim();

						compareActualNExpectedValue(jaas.trim(), value.trim());

					}

				} else {
					BaseSuite.reportFailLog("JAAS Properties Textarea is disabled, kindly check.", methodName);
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate JAAS Properties Textarea on current page, kindly check.",
						methodName);
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();

		}
	}

	public boolean viewHiveConnection(String connJsonEntity, String driverName) {
		boolean flag = true;

		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);

			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

			waitForExecution(2000);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				inVisible(driver, spinner, Constant.ruleWait);

				viewAndValidateConnectionField(connName, "Connection Name ", connParam.getConnName(), true);

				viewAndValidateConnectionField(connFlatFileDriverField, "Driver ", driverName, true);

				viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
						connParam.getAuthenticationname(), true);

				verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

				if (!(connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD))

				{

					String krb5 = getAttribute(driver, connKrbFeild, valueAttribute).trim();

					BaseSuite.validationReportLog(krb5 + " File visible");

					isEnabled(driver, connKrbChoosefile);

					BaseSuite.validationReportLog("Choose File Button Enable on page.");

				}
				if (connParam.getUseSSLCheckbox().equalsIgnoreCase(booleanTrue))

				{
					verifyIndividualLabel(driver, javaTruststoreRadioLabel, "Java Truststore");

					BaseSuite.validationReportLog("Java Truststore Radio button Label visible");

					String javastr = getAttribute(driver, javaTrustStoreFeild, valueAttribute).trim();

					BaseSuite.validationReportLog(javastr + " File visible");

					isEnabled(driver, javaTruStstoreChoosefile);

					BaseSuite.validationReportLog("java Trust store File Button Enable on page.");

					viewAndValidateConnectionField(javaTruststorePaawordfeild,
							ConstantProperty.CONN_FIELD_TRUSTSTOREPASS, "", true);

				}
				if (connParam.getAuthentication().equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

					viewAndValidateConnectionField(servicePrincipalfeild, ConstantProperty.CONN_SERVICECPRINCIPAL, "",
							true);
				}
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				if (connParam.getCustomJdbcFullUrl().equalsIgnoreCase(booleanTrue)) {

					viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
							connParam.getCustomJDBCURLValue(), true);

					viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST, "", false);

					viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT, "", false);

					viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE, "",
							false);

				} else {

					viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
							connParam.getCustomJDBCURLValue(), false);

					viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
							connParam.getHost(), true);

					viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
							connParam.getPort(), true);

					viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
							connParam.getDatabaseName(), true);
				}

				if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS))

				{

					String keytab = getAttribute(driver, connKeytabFeild, valueAttribute).trim();

					BaseSuite.validationReportLog(keytab + " File visible");

					isEnabled(driver, connKeytabChoosefile);

					BaseSuite.validationReportLog("Choose File Button Enable on page.");

					validateInputFieldVisibility(connPrincipalInput, ConstantProperty.CONN_FIELD_PRINCIPAL, "", true);

				}

				else {
					if (isDisplayed(driver, connsecretName)) {

						if (connParam.getAuthenticationname()
								.equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {

							validateInputFieldVisibility(connsecretUserPassword, ConstantProperty.CONN_FIELD_PASSWORD,
									"", true);

							validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "",
									true);
						} else if (connParam.getAuthenticationname()
								.equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS_TICKET_CACHE)) {
							validateInputFieldVisibility(connHiveUserPrincipal, ConstantProperty.CONN_USERPRINCIPAL, "",
									true);

							validateInputFieldVisibility(ticketCachefeild, ConstantProperty.CONN_FIELD_TICKETCACHEFEILD,
									"", true);

						} else {

							validateInputFieldVisibility(connHiveUserPrincipal, ConstantProperty.CONN_USERPRINCIPAL, "",
									true);

							isEnabled(driver, connUserKeytab);

							BaseSuite.validationReportLog("User key tab Field is Enabled");

							isEnabled(driver, chooseFileBtn);

							BaseSuite.validationReportLog("Choose File button is Enabled");
						}
					}
				}

				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

				int count = connPropertyList.size();

				flag = viewAndValidateHiveConnectionProperties(connJsonEntity, count);

			} else {

				inVisible(driver, spinner, Constant.ruleWait);

				validateButtons(driver, connDatabricksBtn, 3);

				verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);
				
				/*
				 * String selectedSecret = getAttribute(driver, connsecretName, "value");
				 * 
				 * if (selectedSecret.isEmpty()) {
				 * 
				 * verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);
				 * 
				 * } else {
				 * 
				 * verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", true);
				 * 
				 * }
				 */
				verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", true);

				verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

				viewAndValidateConnectionField(connName, "Connection Name", connParam.getConnName(), false);

				viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, false);

				viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
						connParam.getAuthenticationname(), false);

				verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

				viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
						connParam.getCustomJDBCURLValue(), false);

				if (!(connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD))

				{
					String krb5 = getAttribute(driver, connKrbFeild, valueAttribute).trim();

					BaseSuite.validationReportLog(krb5 + " File Dis-abled");

					isEnabled(driver, connKrbChoosefile);

					BaseSuite.validationReportLog("Choose File Button Dis-abled on page.");

				}

				if (connParam.getUseSSLCheckbox().equalsIgnoreCase(booleanTrue))

				{
					verifyIndividualLabel(driver, javaTruststoreRadioLabel, "Java Truststore");

					BaseSuite.validationReportLog("Java Truststore Radio button Label Dis-abled");

					String javastr = getAttribute(driver, javaTrustStoreFeild, valueAttribute).trim();

					BaseSuite.validationReportLog(javastr + " File visible");

					isEnabled(driver, javaTruStstoreChoosefile);

					BaseSuite.validationReportLog("java Trust store File Button Dis-abled on page.");

					viewAndValidateConnectionField(javaTruststorePaawordfeild,
							ConstantProperty.CONN_FIELD_TRUSTSTOREPASS, "", false);

				}
				if (connParam.getAuthentication().equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

					viewAndValidateConnectionField(servicePrincipalfeild, ConstantProperty.CONN_SERVICECPRINCIPAL, "",
							false);
				}
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				if (connParam.getCustomJdbcFullUrl().equalsIgnoreCase(booleanTrue)) {

					viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
							connParam.getCustomJDBCURLValue(), false);

					viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST, "", false);

					viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT, "", false);

					viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE, "",
							false);

				} else {

					viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
							connParam.getCustomJDBCURLValue(), false);

					viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
							connParam.getHost(), false);

					viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
							connParam.getPort(), false);

					viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
							connParam.getDatabaseName(), false);
				}

				viewAndValidateConnectionField(connTypeField, "Connection Type Field", connParam.getType(), false);

				if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS))

				{

					String keytab = getAttribute(driver, connKeytabFeild, valueAttribute).trim();

					BaseSuite.validationReportLog(keytab + " File button is Enabled");

					isEnabled(driver, connKeytabChoosefile);

					BaseSuite.validationReportLog("Choose File Button Enabled on page.");

					viewAndValidateConnectionField(connUserPrincipal, ConstantProperty.CONN_FIELD_PRINCIPAL, "", true);

				} else {
					if (isDisplayed(driver, connsecretName)) {

						if (connParam.getAuthenticationname()
								.equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {

							validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "",
									true);

							validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "",
									true);

							validateInputFieldVisibility(connsecretUserPassword, ConstantProperty.CONN_FIELD_PASSWORD,
									"", true);
						} else if (connParam.getAuthenticationname()
								.equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS_TICKET_CACHE)) {

							validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "",
									true);

							validateInputFieldVisibility(connHiveUserPrincipal, ConstantProperty.CONN_USERPRINCIPAL, "",
									true);

							validateInputFieldVisibility(ticketCachefeild, ConstantProperty.CONN_FIELD_TICKETCACHEFEILD,
									"", true);

						} else {
							validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "",
									true);

							validateInputFieldVisibility(connHiveUserPrincipal, ConstantProperty.CONN_USERPRINCIPAL, "",
									true);

							isEnabled(driver, connUserKeytab);

							BaseSuite.validationReportLog("User key tab Field is Enabled");

							isEnabled(driver, chooseFileBtn);

							BaseSuite.validationReportLog("Choose File button is Enabled");
						}
					}
				}
				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

				int count = connPropertyList.size();

				flag = viewAndValidateHiveConnectionProperties(connJsonEntity, count);

			}

		} catch (Exception e) {

			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("connection not visible properly kindly check :" + e.toString());
		}
		return flag;
	}

	public boolean viewAndValidateHiveConnectionProperties(String jsonEntity, int count) throws Exception {
		boolean flag = true;
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(jsonEntity);
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

							validateDefaultConnectionProperty(name.get(j), value.get(j), type.get(j));

						} else {
							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, "$num",
									Integer.toString(a), dynamicName, name.get(j)), name.get(j));

							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, "$num",
									Integer.toString(a), dynamicName, value.get(j)), value.get(j));

							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, "$num",
									Integer.toString(a), dynamicName, type.get(j)), type.get(j));
						}

						/*
						 * if ((connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.
						 * AUTH_KERBEROS_KEYTAB)) || (connParam.getAuthenticationname()
						 * .equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS_TICKET_CACHE))) {
						 * 
						 * clickOnJaasPropertiesTab();
						 * 
						 * validateConnectionPropertyField(jaasPropertiesTextarea, ""); }
						 */
					} else {

						if (name.get(j).contains("loginTimeout")) {

							validateDefaultConnectionProperty(name.get(j), value.get(j), type.get(j));

						} else {
							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, "$num",
									Integer.toString(a), dynamicName, name.get(j)), name.get(j));

							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, "$num",
									Integer.toString(a), dynamicName, value.get(j)), value.get(j));

							validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, "$num",
									Integer.toString(a), dynamicName, type.get(j)), type.get(j));
						}

						/*
						 * if ((connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.
						 * AUTH_KERBEROS_KEYTAB)) || (connParam.getAuthenticationname()
						 * .equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS_TICKET_CACHE))) {
						 * 
						 * clickOnJaasPropertiesTab();
						 * 
						 * validateConnectionPropertyField(jaasPropertiesTextarea,
						 * connParam.getJaasProperties()); }
						 */

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

	public boolean testHiveConnection(String connJsonEntity, String icedqUser) {
		boolean flag = false;
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			String connusername = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

			String UserKeytabLocation = System.getProperty("user.dir") + Constant.USER_KEYTAB_LOCATION;

			inVisible(driver, spinner, Constant.ruleWait);

			waitForExecution(1000);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				// viewDatabaseConnection(connJsonEntity, driverName);

				if (!icedqUser.contains("reader")) {

					waitForExecution(2000);

					flag = testConnection(connectionTestMess);

				} else {
					flag = testConnection(forbiddenToastMsg);
				}
			} else {

				// viewDatabaseConnection(connJsonEntity, driverName);

				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE))
					if (icedqUser.contains("contributor") || (icedqUser.contains("executor"))) {
						if (connParam.getAuthenticationname()
								.equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {

							entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);

							enterUsername(connusername);

						} else if (connParam.getAuthenticationname()
								.equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS_TICKET_CACHE)) {
							entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);

							validatAndeEnterValueToTextField(ticketCacheLabel, ticketCachefeild,
									ConstantProperty.CONN_FIELD_TICKETCACHEFEILD, connTicketCachePlaceHolder,
									connParam.getTicketCacheFileName(), connTcktCacheValidation);

						} else {
							WebElement m = driver.findElement(By.xpath("//input[@id='keytab']"));

							m.sendKeys(UserKeytabLocation);

							BaseSuite.validationReportLog("User key tab File Choosed successfully");

							validatAndeEnterValueToTextField(connUserPrincipalLabel, connHiveUserPrincipal,
									ConstantProperty.CONN_FIELD_USERPRINCIPAL, connPrincipalPlaceholder,
									connParam.getUserPrincipal(), validationUserprincipal);

						}
						saveConnection();
						waitForExecution(1000);
						inVisible(driver, spinner, Constant.ruleWait);
						flag = testConnection(connectionTestMess);

					} else if (icedqUser.contains("owner")) {
						flag = testConnection(connectionTestMess);

					} else {
						flag = clickQuickAddbtn(forbiddenToastMsg);
					}

			}
		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not tested properly kindly check :" + e.toString());

		}

		return flag;
	}

	public boolean updateHiveConnection(String connJsonEntity, String driverName, String testScenario,
			String validationMessage, String icedqUser) {
		boolean flag = true;
		boolean stop = true;
		String newconnectionName = null;
		String KerberosConfigLocation = System.getProperty("user.dir") + Constant.KERBEROS_CONFIG_LOCATION;
		String JavaTruststoreLocation = System.getProperty("user.dir") + Constant.JAVATRUST_STORE_LOCATION;
		String UserKeytabLocation = System.getProperty("user.dir") + Constant.USER_KEYTAB_LOCATION;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

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
					connName = connParam.getConnName() + "_" + ConstantProperty.TARGET_WORKSPACE_NAME;
				}
				searchAndClickOnConnectionNameInConnRepo(connName);

			}
			String javaTrustStore = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 23);

			String wizardStatus = validateExistingConnPageButtonsFields(connJsonEntity);

			if (wizardStatus.contains("Wizard supported connector")) { // DAT-11547

				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", true);

				} else {

					verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", false);
				}
			}

			verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

			verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", true);

			verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

			verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", true);

			verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", true);

			inVisible(driver, spinner, Constant.ruleWait);

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

			viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, true);

			selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

			viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
					connParam.getAuthenticationname(), true);

			selectAuthenticationOfConnection(connParam.getAuthenticationname());

			boolean cs = selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

			enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());

			if (!connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD))

			{
				WebElement m = driver.findElement(By.xpath("//input[@id='krbFile']"));

				m.sendKeys(KerberosConfigLocation);

				BaseSuite.validationReportLog("Krb5 File Choosed successfully");

			}

			boolean ss = selectUseSSLOfConnection(connParam.getUseSSLCheckbox());

			if (ss) {

				verifyIndividualLabel(driver, javaTruststoreRadioLabel, "Java Truststore");

				BaseSuite.validationReportLog("Java Truststore Radio button Label visible");

				WebElement m = driver.findElement(By.xpath("//input[@id='jksFile']"));

				m.sendKeys(JavaTruststoreLocation);

				BaseSuite.validationReportLog("Java Truststore File Choosed successfully");

				enterjavaTruststorePaaword(javaTrustStore);

			}

			if (connParam.getAuthentication().equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

				validatAndeEnterValueToTextField(servicePrincipallabel, servicePrincipalfeild,
						ConstantProperty.CONN_SERVICECPRINCIPAL, connservicePrinciplePlaceHolder,
						connParam.getServicePrincipal(), validationServicePrincipalEmpty);
			}

			if (cs) {

				validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder,
						false);
				validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder,
						false);
				validateInputFieldVisibility(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
						connDatabasePlaceHolder, false);

			} else {
				validatAndeEnterValueToTextField(connHostTitle, connHostInputField, ConstantProperty.CONN_FIELD_HOST,
						connHostPlaceholder, connParam.getHost(), validationHostEmpty);

				validatAndeEnterValueToTextField(connPortTitle, connPortInputField, ConstantProperty.CONN_FIELD_PORT,
						connPortPlaceholder, connParam.getPort(), validationPortEmpty);

				validatAndeEnterValueToTextField(connDatabaseTitle, connDatabaseInputField,
						ConstantProperty.CONN_FIELD_DATABASE, connDatabasePlaceHolder, connParam.getDatabaseName(),
						validationDatabaseEmpty);
			}
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			selectConnectionType(chooseConnType, connParam.getType());

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {
				if (connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {

					entersecretPassword(connJsonEntity, connParam.getAuthenticationname(), connParam.getConnectorID(),
							icedqUser);

					enterUsername(connParam.getUsername());
				} else if (connParam.getAuthenticationname()
						.equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS_TICKET_CACHE)) {
					entersecretPassword(connJsonEntity, connParam.getAuthenticationname(), connParam.getConnectorID(),
							icedqUser);

					validatAndeEnterValueToTextField(ticketCacheLabel, ticketCachefeild,
							ConstantProperty.CONN_FIELD_TICKETCACHEFEILD, connTicketCachePlaceHolder,
							connParam.getTicketCacheFileName(), connTcktCacheValidation);

				} else {
					WebElement m = driver.findElement(By.xpath("//input[@id='keytab']"));

					m.sendKeys(UserKeytabLocation);

					BaseSuite.validationReportLog("User key tab File Choosed successfully");

					entersecretPassword(connJsonEntity, connParam.getAuthenticationname(), connParam.getConnectorID(),
							icedqUser);

				}

			} else {

				if (connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {

					validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", false);

					validateInputFieldVisibility(connsecretUserPassword, ConstantProperty.CONN_FIELD_PASSWORD, "",
							false);

					validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "", false);

				} else if (connParam.getAuthenticationname()
						.equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS_TICKET_CACHE)) {

					validateInputFieldVisibility(connHiveUserPrincipal, ConstantProperty.CONN_USERPRINCIPAL, "", false);

					validateInputFieldVisibility(ticketCachefeild, ConstantProperty.CONN_FIELD_TICKETCACHEFEILD, "",
							false);

				} else {

					validateInputFieldVisibility(connHiveUserPrincipal, ConstantProperty.CONN_USERPRINCIPAL, "", false);

					isEnabled(driver, connUserKeytab);

					BaseSuite.validationReportLog("User key tab Field is Disabled");

					isEnabled(driver, chooseFileBtn);

					BaseSuite.validationReportLog("Choose File button is Disabled");
				}

			}

			ArrayList<String> connPropertyList = TestDataThroughApi
					.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

			int count = connPropertyList.size();

			updateConnectionPropertiesOfHive(connJsonEntity, count);

			if ((icedqUser.contains("owner"))) {

				saveConnection();

				clickOnConnectionsTab();

				isDisplayedInLoop(driver, 0, discardButtons);
				if (isDisplayed(driver, discardButtons)) {
					displayAndClick(driver, discardButtons);
				}

				getConnection(newconnectionName, update_actualValue);

				searchAndClickOnConnectionNameInConnRepo(newconnectionName);
			} else {
				flag = saveConnection(forbiddenToastMsg);

				stop = false;
			}
			if (stop) {
				flag = updateUsernameAndPasswordForHiveAndImpalaConnection(connJsonEntity, connParam,
						connParam.getType(), newconnectionName, icedqUser);
			}

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Connection not updated properly kindly check :" + e.toString());
		}
		return flag;
	}

	public boolean updateImpalaConnectionusingDuplicateConn(String connJsonEntity, String driverName,
			String testScenario, String validationMessage, String icedqUser) {
		boolean flag = true;
		boolean stop = true;
		String newconnectionName = null;

		String KerberosConfigLocation = System.getProperty("user.dir") + Constant.KERBEROS_CONFIG_LOCATION;
		String UserKeytabLocation = System.getProperty("user.dir") + Constant.USER_KEYTAB_LOCATION;
		String JavaTruststoreLocation = System.getProperty("user.dir") + Constant.JAVATRUST_STORE_LOCATION;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			if (icedqUser.contains(ConstantProperty.ICEDQ_WORKSPACE_OWNERUSER)) {

				newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
						+ ConstantProperty.TARGET_WORKSPACE_NAME + "_WO" + ConstantProperty.SIGN_UNDERSCORE + "vault";
			} else {

				newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
						+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";
			}

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			String javaTrustStore = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 23);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

			} else {

				String connName = ConnectionRepoCommonPage.duplicateConnName;

				if (icedqUser.contains("owner")) {

					connName = ConnectionRepoCommonPage.duplicateConnName;

				} else {

					connName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
							+ ConstantProperty.TARGET_WORKSPACE_NAME;
				}

				waitForExecution(3000);
				clickOnConnectionsTab();
				isDisplayedInLoop(driver, 0, discardButtons);
				if (isDisplayed(driver, discardButtons)) {
					displayAndClick(driver, discardButtons);
				}

				searchAndClickOnConnectionNameInConnRepo(connName);

			}
			inVisible(driver, spinner, Constant.ruleWait);

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

			viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, true);

			selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

			viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
					connParam.getAuthenticationname(), true);

			selectAuthenticationOfConnection(connParam.getAuthenticationname());

			boolean cs = selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

			enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());

			if (!connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD))

			{
				WebElement m = driver.findElement(By.xpath("//input[@id='krbFile']"));

				m.sendKeys(KerberosConfigLocation);

				BaseSuite.validationReportLog("Krb5 File Choosed successfully");

			}

			boolean ss = selectUseSSLOfConnection(connParam.getUseSSLCheckbox());

			if (ss) {

				verifyIndividualLabel(driver, javaTruststoreRadioLabel, "Java Truststore");

				BaseSuite.validationReportLog("Java Truststore Radio button Label visible");

				WebElement m = driver.findElement(By.xpath("//input[@id='jksFile']"));

				m.sendKeys(JavaTruststoreLocation);

				BaseSuite.validationReportLog("Java Truststore File Choosed successfully");

				enterjavaTruststorePaaword(javaTrustStore);

			}

			if (connParam.getAuthentication().equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

				validatAndeEnterValueToTextField(servicePrincipallabel, servicePrincipalfeild,
						ConstantProperty.CONN_SERVICECPRINCIPAL, connservicePrinciplePlaceHolder,
						connParam.getServicePrincipal(), validationServicePrincipalEmpty);
			}

			if (cs) {

				validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder,
						false);
				validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder,
						false);
				validateInputFieldVisibility(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
						connDatabasePlaceHolder, false);

			} else {
				validatAndeEnterValueToTextField(connHostTitle, connHostInputField, ConstantProperty.CONN_FIELD_HOST,
						connHostPlaceholder, connParam.getHost(), validationHostEmpty);

				validatAndeEnterValueToTextField(connPortTitle, connPortInputField, ConstantProperty.CONN_FIELD_PORT,
						connPortPlaceholder, connParam.getPort(), validationPortEmpty);

				validatAndeEnterValueToTextField(connDatabaseTitle, connDatabaseInputField,
						ConstantProperty.CONN_FIELD_DATABASE, connDatabasePlaceHolder, connParam.getDatabaseName(),
						validationDatabaseEmpty);
			}
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			selectConnectionType(chooseConnType, connParam.getType());

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {
				if (connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {

					entersecretPassword(connJsonEntity, connParam.getAuthenticationname(), connParam.getConnectorID(),
							icedqUser);

					enterUsername(connParam.getUsername());
				} else if (connParam.getAuthenticationname()
						.equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS_TICKET_CACHE)) {
					entersecretPassword(connJsonEntity, connParam.getAuthenticationname(), connParam.getConnectorID(),
							icedqUser);

					validatAndeEnterValueToTextField(ticketCacheLabel, ticketCachefeild,
							ConstantProperty.CONN_FIELD_TICKETCACHEFEILD, connTicketCachePlaceHolder,
							connParam.getTicketCacheFileName(), connTcktCacheValidation);

				} else {
					WebElement m = driver.findElement(By.xpath("//input[@id='keytab']"));

					m.sendKeys(UserKeytabLocation);

					BaseSuite.validationReportLog("User key tab File Choosed successfully");

					entersecretPassword(connJsonEntity, connParam.getAuthenticationname(), connParam.getConnectorID(),
							icedqUser);

				}

			} else {

				if (connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {

					validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", false);

					validateInputFieldVisibility(connsecretUserPassword, ConstantProperty.CONN_FIELD_PASSWORD, "",
							false);

					validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "", false);

				} else if (connParam.getAuthenticationname()
						.equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS_TICKET_CACHE)) {

					validateInputFieldVisibility(connHiveUserPrincipal, ConstantProperty.CONN_USERPRINCIPAL, "", false);

					validateInputFieldVisibility(ticketCachefeild, ConstantProperty.CONN_FIELD_TICKETCACHEFEILD, "",
							false);

				} else {

					validateInputFieldVisibility(connHiveUserPrincipal, ConstantProperty.CONN_USERPRINCIPAL, "", false);

					isEnabled(driver, connUserKeytab);

					BaseSuite.validationReportLog("User key tab Field is Disabled");

					isEnabled(driver, chooseFileBtn);

					BaseSuite.validationReportLog("Choose File button is Disabled");
				}

			}

			ArrayList<String> connPropertyList = TestDataThroughApi
					.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

			int count = connPropertyList.size();

			updateConnectionPropertiesOfHive(connJsonEntity, count);

			if ((icedqUser.contains("owner"))) {

				saveConnection();

				clickOnConnectionsTab();

				isDisplayedInLoop(driver, 0, discardButtons);
				if (isDisplayed(driver, discardButtons)) {
					displayAndClick(driver, discardButtons);
				}

				getConnection(newconnectionName, update_actualValue);

				searchAndClickOnConnectionNameInConnRepo(newconnectionName);
			} else {
				flag = saveConnection(forbiddenToastMsg);

				stop = false;
			}
			if (stop) {
				flag = updateUsernameAndPasswordForHiveAndImpalaConnection(connJsonEntity, connParam,
						connParam.getType(), newconnectionName, icedqUser);
			}

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Connection not updated properly kindly check :" + e.toString());
		}
		return flag;
	}

	public boolean updateConnectionPropertiesOfHive(String jsonEntity, int count) throws Exception {
		boolean flag = true;
		String dynamicVar = "$num";

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(jsonEntity);
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
					if (name.get(j).contains("loginTimeout")) {

						validateDefaultConnectionProperty(name.get(j), value.get(j), type.get(j));

					} else if (type.get(j).toLowerCase().contains("system")) {

						javascript(driver, scrollToElementArg,
								returnElement(connPropertyEditButton, "$name", name.get(j)));

						validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, dynamicVar,
								Integer.toString(a), dynamicName, name.get(j)), name.get(j));
						validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, dynamicVar,
								Integer.toString(a), dynamicName, value.get(j)), value.get(j));
						validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, dynamicVar,
								Integer.toString(a), dynamicName, type.get(j)), type.get(j));

						flag = clickOnButton(driver, returnElement(connPropertyEditButton, "$name", name.get(j)),
								"Edit", true);

						if (flag) {
							if (!type.get(j).trim().equalsIgnoreCase("user")) {

								updateConnectionPropertyField(returnTwoElements(connPropCommonFieldUpdate, dynamicVar,
										Integer.toString(a), dynamicName, "name"), name.get(j));
							}

							updateConnectionPropertyField(returnTwoElements(connPropCommonFieldUpdate, dynamicVar,
									Integer.toString(a), dynamicName, "value"), value.get(j));

							if (!type.get(j).trim().equalsIgnoreCase("user")) {
								selectConnectionType(propConnType, type.get(j).trim());
							}
							/*
							 * if ((connParam.getAuthenticationname()
							 * .equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS_KEYTAB)) ||
							 * (connParam.getAuthenticationname()
							 * .equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS_TICKET_CACHE))) {
							 * 
							 * addJaasPropertiesToConnection(connParam.getJaasProperties()); }
							 */

							flag = clickOnButton(driver,
									returnElement(connPropertySaveButton, dynamicVar, Integer.toString(a)), "Save",
									true);
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

	public boolean duplicateHiveConnection(String connJsonEntity, String driverName, String icedqUser) {
		boolean flag = false;
		String name = null;
		String newconnectionName = null;
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);
			waitForExecution(3000);
			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				clickOnConnectionsTab();
				isDisplayedInLoop(driver, 0, discardButtons);
				if (isDisplayed(driver, discardButtons)) {
					displayAndClick(driver, discardButtons);
				}
				String connName;

				waitForExecution(1000);

				if ((!icedqUser.contains("owner"))) {

					connName = newconnectionName;
				} else {
					connName = newconnectionName;
				}
				searchAndClickOnConnectionNameInConnRepo(connName);

				inVisible(driver, spinner, Constant.ruleWait);

				waitForExecution(1000);
			}
			if (icedqUser.contains("owner")) {

				flag = clickOnDuplicateConnection(connDupllicateToastMsg);

				inVisible(driver, spinner, Constant.ruleWait);

				waitForExecution(1000);

				javascript(driver, scrollToElementArg, connName);

				if (flag) {
					if (isDisplayed(driver, connName)) {
						name = getAttribute(driver, connName, valueAttribute);
					} else {
						clickOnOverviewTab();
						name = getAttribute(driver, connName, valueAttribute);
					}
					clickOnConnectionsTab();
					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}

					waitForExecution(2000);
					flag = searchAndClickOnConnectionNameInConnRepo(name);
				}
			} else {
				flag = clickOnDuplicateConnection(forbiddenToastMsg);
			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(
					"Due to exception while duplicate Database Connection kindly check " + e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;
	}

	public boolean deleteHiveConnection(String connJsonEntity, String driverName, String icedqUser) {
		boolean flag = true;
		String newconnectionName = null;
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			if (icedqUser.contains("workspace")) {

				newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
						+ ConstantProperty.TARGET_WORKSPACE_NAME + "_WO" + ConstantProperty.SIGN_UNDERSCORE + "vault";
			} else {

				newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
						+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";
			}

			inVisible(driver, spinner, Constant.ruleWait);

			waitForExecution(3000);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {
				String connName;

				clickOnConnectionsTab();

				if ((!icedqUser.contains("owner"))) {

					if (icedqUser.contains("workspace")) {

						connName = newconnectionName;

					} else {

						connName = newconnectionName;
					}

					connName = newconnectionName;
				} else {
					if (icedqUser.contains("workspace")) {

						connName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
								+ ConstantProperty.TARGET_WORKSPACE_NAME + "_WO" + ConstantProperty.SIGN_UNDERSCORE
								+ "vault";
					} else {

						connName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
								+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";
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

	/****************************
	 * GoogleBigQuery Connection Implementation Starts
	 *************************/

	public boolean createGoogleBigQueryConnection(String connJsonEntity, String testScenario, String validationMessage,
			String icedqUser) {
		boolean flag = true;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		String newconnectionName = null;
		LoginPage lp = new LoginPage(driver);
		try {
			if (isDisplayed(driver, userName) && isDisplayed(driver, passWord)) {

				flag = lp.loginWithIcedqUserAndSelectWorkspace(icedqUser, ConstantProperty.TARGET_WORKSPACE_NAME,
						ConstantProperty.CONNECTIONREPOMODULENAME, "");

			}
			if (flag) {

				ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

				newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
						+ ConstantProperty.TARGET_WORKSPACE_NAME;

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				flag = clickOnNewConnectionBtn(icedqUser);

				if (flag) {

					chooseConnectorType(connParam.getConnectorID());

					inVisible(driver, spinner, Constant.ruleWait);

					String wizardStatus = validateNewConnPageButtonsFields(connParam.getConnectorID());

					if (wizardStatus.contains("Wizard supported connector")) {

						verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", false);
					}

					verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

					verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);

					verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

					verifyVisibilityOfButtons(driver, connDeleteButton, "Dalete Button", false);

					verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", false);

					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

					selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					// isEnabled(driver, selectConnType);

					isDisplayed(driver, selectConnType);

					BaseSuite.validationReportLog("System connection type is Disabled");

					validatAndeEnterValueToTextField(projectidLabel, projectidFeild,
							ConstantProperty.CONN_FIELD_PROJECTID, ProjectiDPlaceholder, connParam.getProjectid(),
							validationProjectIDEmpty);

					entersecretPassword(connJsonEntity, connParam.getAuthenticationname(), connParam.getConnectorID(),
							icedqUser);

				}
				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

				int count = connPropertyList.size();

				addConnectionPropertiesToGoogleBigQuery(connJsonEntity, count);

				if (icedqUser.toLowerCase().contains("owner")) {

					waitForExecution(1000);

					flag = saveConnection(connectionSaveMesssage);

					clickOnConnectionsTab();

					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}

					cp.searchConnection(newconnectionName);

					getConnection(newconnectionName, update_actualValue);

					flag = searchAndClickOnConnectionNameInConnRepo(newconnectionName);

					testConnection(connectionTestMess);

					clickOnConnectionsTab();

					waitForExecution(2000);

					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}

					waitForExecution(1000);

					searchConnection(newconnectionName);

					getConnection(newconnectionName, create_actualValue);

					searchAndClickOnConnectionNameInConnRepo(newconnectionName);

				} else {

					flag = saveConnection(forbiddenToastMsg);
				}
			}
		} catch (Exception e) {

			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" Google Big Query connection not created properly kindly check :" + e.toString());
		}
		return flag;
	}

	public void addConnectionPropertiesToGoogleBigQuery(String jsonEntity, int count) throws Exception {
		try {
			if (count > 0) {
				clickOnPropertiesTab();

				ArrayList<String> name = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						connConnectionPropNames);

				ArrayList<String> value = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						connConnectionPropValues);

				ArrayList<String> type = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						connConnectionPropTypes);

				for (int j = 0; j < name.size(); j++) {

					if (name.get(j).contains("ConnectionLifeTime")) {

						validateDefaultConnectionProperty(name.get(j), value.get(j), type.get(j));

					} else {

						addConnectionProperty(name.get(j), value.get(j), type.get(j));
					}
				}

			}
			clickOnOverviewTab();

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();

		}
	}

	/** View DataBase connection details method **/

	public boolean viewGoogleBigQueryConnection(String connJsonEntity, String driverName) {
		boolean flag = true;

		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);

			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

			String wizardStatus = validateExistingConnPageButtonsFields(connJsonEntity);

			if (wizardStatus.contains("Wizard supported connector")) { // DAT-11547

				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", true);

				} else {

					verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", false);
				}
			}

			verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

			verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", true);

			verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

			verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", true);

			verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", true);

			inVisible(driver, spinner, Constant.ruleWait);

			viewAndValidateConnectionField(connName, "Connection Name ", connParam.getConnName(), true);

			viewAndValidateConnectionField(connFlatFileDriverField, "Driver ", driverName, true);

			viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
					connParam.getAuthenticationname(), true);

			isDisplayed(driver, selectConnType);

			BaseSuite.validationReportLog("System connection type is Disabled");

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			if (isDisplayed(driver, connsecretName)) {

				validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", true);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				waitForExecution(1000);

				verifyVisibilityOfButtons(driver, connsecretManagebtn, "Manage Button", true);

				verifyVisibilityOfButtons(driver, connsecretQuickAddbtn, "Quick Add Button", true);

			}

			ArrayList<String> connPropertyList = TestDataThroughApi
					.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

			int count = connPropertyList.size();

			flag = viewAndValidateGoogleBigQueryConnectionProperties(connJsonEntity, count);

		} catch (Exception e) {

			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("connection not visible properly kindly check :" + e.toString());
		}
		return flag;
	}

	public boolean viewAndValidateGoogleBigQueryConnectionProperties(String jsonEntity, int count) throws Exception {
		boolean flag = true;
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

					if (name.get(j).contains("ConnectionLifeTime")) {

						validateDefaultConnectionProperty(name.get(j), value.get(j), type.get(j));

					} else {
						validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, "$num",
								Integer.toString(a), dynamicName, name.get(j)), name.get(j));

						validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, "$num",
								Integer.toString(a), dynamicName, value.get(j)), value.get(j));

						validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, "$num",
								Integer.toString(a), dynamicName, type.get(j)), type.get(j));
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

	public boolean testGoogleBigQueryConnection(String connJsonEntity, String icedqUser) {
		boolean flag = false;
		try {

			inVisible(driver, spinner, Constant.ruleWait);

			waitForExecution(1000);

			if (!icedqUser.contains("reader")) {

				waitForExecution(2000);

				flag = testConnection(connectionTestMess);

			} else {
				flag = testConnection(forbiddenToastMsg);
			}

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not tested properly kindly check :" + e.toString());

		}

		return flag;
	}

	public boolean updateGoogleBigQueryConnection(String connJsonEntity, String driverName, String testScenario,
			String validationMessage, String icedqUser) {
		boolean flag = true;
		String newconnectionName = null;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			String wizardStatus = validateExistingConnPageButtonsFields(connJsonEntity);

			if (wizardStatus.contains("Wizard supported connector")) { // DAT-11547

				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", true);

				} else {

					verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", false);
				}
			}

			verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

			verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", true);

			verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

			verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", true);

			verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", true);

			enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

			viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, true);

			selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

			viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
					connParam.getAuthenticationname(), true);

			selectAuthenticationOfConnection(connParam.getAuthenticationname());

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			isDisplayed(driver, selectConnType);

			BaseSuite.validationReportLog("System connection type is Disabled");

			validatAndeEnterValueToTextField(projectidLabel, projectidFeild, ConstantProperty.CONN_FIELD_PROJECTID,
					ProjectiDPlaceholder, connParam.getProjectid(), validationProjectIDEmpty);

			entersecretPassword(connJsonEntity, connParam.getAuthenticationname(), connParam.getConnectorID(),
					icedqUser);

			ArrayList<String> connPropertyList = TestDataThroughApi
					.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

			int count = connPropertyList.size();

			updateConnectionPropertiesOfGoogleBigQueryHive(connJsonEntity, count);

			if (icedqUser.toLowerCase().contains("owner")) {

				saveConnection();

				clickOnConnectionsTab();

				getConnection(newconnectionName, update_actualValue);

				searchAndClickOnConnectionNameInConnRepo(newconnectionName);

				testConnection(connectionTestMess);

				clickOnConnectionsTab();

				waitForExecution(2000);

				searchConnection(newconnectionName);

				getConnection(newconnectionName, create_actualValue);

				searchAndClickOnConnectionNameInConnRepo(newconnectionName);
			} else {
				flag = saveConnection(forbiddenToastMsg);

			}
		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Connection not updated properly kindly check :" + e.toString());
		}
		return flag;
	}

	public boolean updateConnectionPropertiesOfGoogleBigQueryHive(String jsonEntity, int count) throws Exception {
		boolean flag = true;
		String dynamicVar = "$num";

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
					if (name.get(j).contains("ConnectionLifeTime")) {

						validateDefaultConnectionProperty(name.get(j), value.get(j), type.get(j));

					} else if (type.get(j).toLowerCase().contains("system")) {
						javascript(driver, scrollToElementArg,
								returnElement(connPropertyEditButton, dynamicVar, Integer.toString(a)));

						validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, dynamicVar,
								Integer.toString(a), dynamicName, name.get(j)), name.get(j));
						validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, dynamicVar,
								Integer.toString(a), dynamicName, value.get(j)), value.get(j));
						validateConnectionPropertyField(returnTwoElements(connConnectionPropCommonLocator, dynamicVar,
								Integer.toString(a), dynamicName, type.get(j)), type.get(j));

						flag = clickOnButton(driver,
								returnElement(connPropertyEditButton, dynamicVar, Integer.toString(j + 1)), "Edit",
								true);

						if (flag) {
							if (!type.get(j).trim().equalsIgnoreCase("user")) {

								updateConnectionPropertyField(returnTwoElements(connPropCommonFieldUpdate, dynamicVar,
										Integer.toString(a), dynamicName, "name"), name.get(j));
							}

							updateConnectionPropertyField(returnTwoElements(connPropCommonFieldUpdate, dynamicVar,
									Integer.toString(a), dynamicName, "value"), value.get(j));

							if (!type.get(j).trim().equalsIgnoreCase("user")) {
								selectConnectionType(propConnType, type.get(j).trim());
							}

							flag = clickOnButton(driver,
									returnElement(connPropertySaveButton, dynamicVar, Integer.toString(a)), "Save",
									true);
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

	/** Duplicate Google Big Query connection using API test data **/
	public boolean duplicateGBQConnectionMethod(String connJsonEntity, String icedqUser) {
		boolean flag = false;
		String name = null;
		String newconnectionName = null;
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);

			waitForExecution(3000);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

			if (icedqUser.contains("owner")) {

				flag = clickOnDuplicateConnection(connDupllicateToastMsg);

				inVisible(driver, spinner, Constant.ruleWait);

				waitForExecution(1000);

				javascript(driver, scrollToElementArg, connName);

				if (flag) {
					if (isDisplayed(driver, connName)) {
						name = getAttribute(driver, connName, valueAttribute);
					} else {
						clickOnOverviewTab();
						name = getAttribute(driver, connName, valueAttribute);
					}
					clickOnConnectionsTab();
					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}

					waitForExecution(2000);
					flag = searchAndClickOnConnectionNameInConnRepo(name);
				}
			} else {
				flag = clickOnDuplicateConnection(forbiddenToastMsg);
			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(
					"Due to exception while duplicate Google Big Query Connection kindly check " + e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;
	}

	/** Delete Google Big Query connection method **/

	public boolean deleteGBQConnection(String connJsonEntity, String icedqUser) {
		boolean flag = true;
		String newconnectionName = null;
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

			inVisible(driver, spinner, Constant.ruleWait);

			waitForExecution(3000);

			if (icedqUser.contains("owner")) {

				flag = clickOnDeleteButton(connSingleDeleteToastMsg, 1);

			} else {
				flag = clickOnButton(driver, clickonDisable, "Connection Delete", flag);

				flag = captureToastMsg(driver, toastMsg, popUpClose, forbiddenToastMsg, "Connection Delete");
			}
		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Google Big Query connection not deleted properly kindly check :" + e.toString());

		}

		return flag;
	}

	/** Select Cloud Provider method **/
	public void selectCloudProviderOfConnection(String CloudProviderType) {
		String methodName = "selectCloudProviderofConnection";
		try {
			isDisplayedInLoop(driver, 2, connCloudProviderTypeLabel);

			javascript(driver, scrollToElementArg, connCloudProviderTypeLabel);

			verifyIndividualLabel(driver, connCloudProviderTypeLabel, "cloudProvider");

			if (isDisplayed(driver, connCloudProviderField)) {

				BaseSuite.validationReportLog("Cloud Provider field is visible ");

				String CloudProviderValue = getAttribute(driver, connCloudProviderField, valueAttribute);

				BaseSuite.reportLog("Default cloud provider selected as : " + CloudProviderValue);

				BaseSuite.validationReportLog("Cloud Provider field drop down arrow is visible");

				displayAndClick(driver, connCloudProviderSearchIcon);

				BaseSuite.validationReportLog(
						"Clicked on Cloud Provider drop down " + ConstantProperty.SUCCESSSTRING + "");

				BaseSuite.reportLog("Checking list of cloud provider visible");
				waitForExecution(2000);
				List<WebElement> cloudProviderList = getElements(driver, connCloudProviderList);

				for (int i = 0; i < cloudProviderList.size(); i++) {

					String cloudProviderName = cloudProviderList.get(i).getAttribute(attributeTextContent);

					BaseSuite.reportLog((i + 1) + ". " + cloudProviderName + " is visible");

				}

				/** CloudProviderType = setCloudProviderType(CloudProviderType); **/

				BaseSuite.reportLog("Selecting expected Cloud Provider type : " + CloudProviderType);

				if (isDisplayed(driver, returnElement(connCloudProviderSelect1, dynamicName, CloudProviderType))) {

					BaseSuite.reportLog(CloudProviderType + " is visible");

					BaseSuite.reportLog("Clicking on Cloud Provider ...");

					displayAndClick(driver, returnElement(connCloudProviderSelect1, dynamicName, CloudProviderType));

					String accloudProvider = getAttribute(driver, connCloudProviderField, valueAttribute);

					if (!accloudProvider.isEmpty() && accloudProvider.equalsIgnoreCase(CloudProviderType)) {

						BaseSuite.validationReportLog(
								"Expected Cloud Provider is selected " + ConstantProperty.SUCCESSSTRING + "");

					} else {
						BaseSuite.reportFailLog("Expected Cloud Provider is not selected, kindly check ", methodName);
					}

				} else {
					BaseSuite.reportFailLog("Cloud Provider is not visible " + CloudProviderType, methodName);
				}

			} else {
				BaseSuite.reportFailLog("Cloud Provider field not visible ", methodName);
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			e.getMessage();
			throw new NoSuchElementException();
		}
	}

	/** Select Databricks Environment method **/
	public void selectDatabricksEnvironmentOfConnection(String DatabricksEnvironment) {
		String methodName = "selectDatabricksEnvironmentofConnection";
		try {
			isDisplayedInLoop(driver, 2, connDEnvironmentLabel);

			javascript(driver, scrollToElementArg, connDEnvironmentLabel);

			verifyIndividualLabel(driver, connDEnvironmentLabel, "DatabricksEnvironment");

			if (isDisplayed(driver, connDEnvironmentField)) {

				BaseSuite.validationReportLog("Databricks Environment field is visible ");

				String DatabricksEnvironmentValue = getAttribute(driver, connDEnvironmentField, valueAttribute);

				BaseSuite.reportLog("Default Databricks Environment selected as : " + DatabricksEnvironmentValue);

				BaseSuite.validationReportLog("Databricks Environment field drop down arrow is visible");

				displayAndClick(driver, connDEnvironmentSearchIcon);

				BaseSuite.validationReportLog(
						"Clicked on Databricks Environment drop down " + ConstantProperty.SUCCESSSTRING + "");

				BaseSuite.reportLog("Checking list of Databricks Environment visible");
				waitForExecution(2000);
				List<WebElement> databricksEnvironmentList = getElements(driver, connDEnvironmentList);

				for (int i = 0; i < databricksEnvironmentList.size(); i++) {

					String DatabricksEnvironmentName = databricksEnvironmentList.get(i)
							.getAttribute(attributeTextContent);

					BaseSuite.reportLog((i + 1) + ". " + DatabricksEnvironmentName + " is visible");

				}

				/** DatabricksEnvironment = setDatabricksEnvironment(DatabricksEnvironment); **/

				BaseSuite.reportLog("Selecting expected Databricks Environment : " + DatabricksEnvironment);

				if (isDisplayed(driver, returnElement(connDEnvironmentSelect1, dynamicName, DatabricksEnvironment))) {

					BaseSuite.reportLog(DatabricksEnvironment + " is visible");

					BaseSuite.reportLog("Clicking on Databricks Environment...");

					displayAndClick(driver, returnElement(connDEnvironmentSelect1, dynamicName, DatabricksEnvironment));

					String accDatabricksEnvironment = getAttribute(driver, connDEnvironmentField, valueAttribute);

					if (!accDatabricksEnvironment.isEmpty()
							&& accDatabricksEnvironment.equalsIgnoreCase(DatabricksEnvironment)) {

						BaseSuite.validationReportLog(
								"Expected Databricks Environment is selected " + ConstantProperty.SUCCESSSTRING + "");

					} else {
						BaseSuite.reportFailLog("Expected Databricks Environment is not selected, kindly check ",
								methodName);
					}

				} else {
					BaseSuite.reportFailLog("Databricks Environment is not visible " + DatabricksEnvironment,
							methodName);
				}

			} else {
				BaseSuite.reportFailLog("Databricks Environment field not visible ", methodName);
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			e.getMessage();
			throw new NoSuchElementException();
		}
	}

//	public void verifyBreadCrumbs(String bredCrumb1, String bredCrumb2, String bredCrumb3) {
//		try {
//			List<String> expected = Arrays.asList(bredCrumb1, bredCrumb2, bredCrumb3);
//
//			List<WebElement> breadcrumbs = getElements(driver, breadCrumb);
//
//			for (int i = 0; i < expected.size(); i++) {
//
//				String breadcrumb = breadcrumbs.get(i).getText();
//
//				if (breadcrumb.equals(expected.get(i))) {
//
//					isClickable(driver, returnElement(breadCrumbText, "$name", breadcrumb), breadcrumb, true);
//
//				} else {
//
//					BaseSuite.reportFailLog(breadcrumb + "breadcrumb is not present on the page,Kindly check!",
//							"verifyBreadCrumbs");
//				}
//			}
//		} catch (Exception e) {
//
//			throw new AssertionError();
//		}
//
//	}

	public boolean createDatabricksConnection(String connJsonEntity, String testScenario, String validationMessage,
			String icedqUser) {
		boolean flag = true;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		String newconnectionName = null;
		LoginPage lp = new LoginPage(driver);
		try {
			if (isDisplayed(driver, userName) && isDisplayed(driver, passWord)) {

				flag = lp.loginWithIcedqUserAndSelectWorkspace(icedqUser, ConstantProperty.TARGET_WORKSPACE_NAME,
						ConstantProperty.CONNECTIONREPOMODULENAME, "");

			}
			if (flag) {

				ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

				newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
						+ ConstantProperty.TARGET_WORKSPACE_NAME;

				flag = clickOnNewConnectionBtn(icedqUser);

				if (flag) {

					chooseConnectorType(connParam.getConnectorID());

					inVisible(driver, spinner, Constant.ruleWait);

					waitForExecution(10);

//					verifyBreadCrumbs("Home", "Administration", "Users");

					flag = validateFieldsButtons();

					if (flag) {

						boolean a = isDisplayed(driver, connDatabricksLogo);

						if (a) {
							BaseSuite.validationReportLog("Databricks Connector logo is displayed.");

						} else {
							BaseSuite.reportFailLog("Databricks connector logo is not displayed. Kindly Check!!!",
									"Logo isDisplayed");
						}

						verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

						verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);

						verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

						verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", false);

						verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", false);

					}

					enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

					selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

					selectCloudProviderOfConnection(connParam.getcloudProvidername());

					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					selectDatabricksEnvironmentOfConnection(connParam.getDatabricksEnvironmentname());

					boolean cs = selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

					enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());

					if (cs) {

						validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
								connHostPlaceholder, false);
						validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
								connPortPlaceholder, false);
						validateInputFieldVisibility(connHttpPathInputField, ConstantProperty.CONN_FIELD_HTTPPATH,
								connHttpPathPlaceHolder, false);

					} else {
						validatAndeEnterValueToTextField(connHostTitle, connHostInputField,
								ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder, connParam.getHost(),
								validationHostEmpty);

						validatAndeEnterValueToTextField(connPortTitle, connPortInputField,
								ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder, connParam.getPort(),
								validationPortEmpty);

						validatAndeEnterValueToTextField(connHttpPathTitle, connHttpPathInputField,
								ConstantProperty.CONN_FIELD_HTTPPATH, connHttpPathPlaceHolder, connParam.getHttpPath(),
								validationPortEmpty);

					}

					validatAndeEnterValueToTextField(connCatalogTitle, connCatalogInputField,
							ConstantProperty.CONN_FIELD_CATALOG, connCatalogPlaceHolder, connParam.getDatabaseName(),
							validationDatabaseEmpty);
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					selectConnectionType(chooseConnType, connParam.getType());

					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
								connParam.getConnectorID(), icedqUser);

					} else {

						validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", false);

						validateInputFieldVisibility(connsecretUserPAT, ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN,
								"", false);
					}

					ArrayList<String> connPropertyList = TestDataThroughApi
							.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

					int count = connPropertyList.size();

					addConnectionPropertiesToConnection(connJsonEntity, count);

					// clickOnOverviewTab();

					if (icedqUser.toLowerCase().contains("owner")) {

						flag = saveConnection(connectionSaveMesssage);

						clickOnConnectionsTab();

						isDisplayedInLoop(driver, 0, discardButtons);
						if (isDisplayed(driver, discardButtons)) {
							displayAndClick(driver, discardButtons);
						}

						cp.searchConnection(newconnectionName);

						getConnection(newconnectionName, update_actualValue);

						searchAndClickOnConnectionNameInConnRepo(newconnectionName);

						if (flag || (isEnabled(driver, connDuplicateButton) && isEnabled(driver, connDeleteButton))) {

							flag = updateUsernameAndPasswordForDatabricksUserConnection(connJsonEntity, "create",
									connParam.getType(), newconnectionName, icedqUser);
						}

					} else {

						flag = saveConnection(forbiddenToastMsg);
					}
				}
			}

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" Database connection not created properly kindly check :" + e.toString());
		}
		return flag;
	}

	public boolean validateFieldsButtons() {
		boolean flag = true;
		try {

			validateInputFields(driver, DatabricksInputFields, 5);

			validateTextFields(driver, connCustomJDBCTextbox, 1);

			validateButtons(driver, connDatabricksBtn, 5);

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" Fields and Buttons are not as excepted.kindly check :" + e.toString());
		}
		return flag;
	}

	public boolean validateExcelConnFieldsButtons() {
		boolean flag = true;
		try {

			validateInputFields(driver, connExcelInputFields, 6);

			validateButtons(driver, connExcelBtn, 6);

			validateButtons(driver, connDetailsPageTabs, 2);

			BaseSuite.reportLog("Checking For Info Icon present on the page.");

			validateButtons(driver, connExcelinfoIcon, 1);

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" Fields and Buttons are not as excepted.kindly check :" + e.toString());
		}
		return flag;
	}

	public boolean validateParquetConnFieldsButtons() {
		boolean flag = true;
		try {

			validateInputFields(driver, connExcelInputFields, 4);

			validateButtons(driver, connExcelBtn, 6);

			validateButtons(driver, connDetailsPageTabs, 2);

			BaseSuite.reportLog("Proper Input fields, buttons and tabs are displayed.");

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" Fields and Buttons are not as excepted.kindly check :" + e.toString());
		}
		return flag;
	}

	public boolean validateFieldsButtonsUserConn() {
		boolean flag = true;
		try {

			validateInputFields(driver, DatabricksInputFields, 5);

			validateTextFields(driver, connCustomJDBCTextbox, 1);

			validateButtons(driver, connDatabricksBtn, 3);

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" Fields and Buttons are not as excepted.kindly check :" + e.toString());
		}
		return flag;
	}

	public boolean validateDatabaseConnFieldsButtons() {
		boolean flag = true;
		try {

			validateInputFields(driver, DatabricksInputFields, 5);

			validateTextFields(driver, connCustomJDBCTextbox, 1);

			validateButtons(driver, connDatabricksBtn, 5);

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" Fields and Buttons are not as excepted.kindly check :" + e.toString());
		}
		return flag;
	}

	/** View Databricks connection details method **/

	public boolean viewDatabricksConnection(String connJsonEntity, String driverName) {
		boolean flag = true;

		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);

			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

			waitForExecution(2000);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				flag = validateFieldsButtons();

				if (flag) {

					verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

					verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", true);

					verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

					verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", true);

					verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", true);

				}

				inVisible(driver, spinner, Constant.ruleWait);

				viewAndValidateConnectionField(connName, "Connection Name ", connParam.getConnName(), true);

				viewAndValidateConnectionField(connFlatFileDriverField, "Driver ", driverName, true);

				viewAndValidateConnectionField(connCloudProviderField, "Cloud Provider",
						connParam.getcloudProvidername(), true);

				viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
						connParam.getAuthenticationname(), true);

				viewAndValidateConnectionField(connDEnvironmentField, "Databricks Environment",
						connParam.getDatabricksEnvironmentname(), true);

				verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				if (connParam.getCustomJdbcFullUrl().equalsIgnoreCase(booleanTrue)) {

					viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
							connParam.getCustomJDBCURLValue(), true);

					viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST, "", false);

					viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT, "", false);

					viewAndValidateConnectionField(connHttpPathInputField, ConstantProperty.CONN_FIELD_HTTPPATH, "",
							false);

				} else {

					viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
							connParam.getCustomJDBCURLValue(), false);

					viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
							connParam.getHost(), true);

					viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
							connParam.getPort(), true);

					viewAndValidateConnectionField(connHttpPathInputField, ConstantProperty.CONN_FIELD_HTTPPATH,
							connParam.getHttpPath(), true);
				}

//				validateInputFieldVisibility(connCatalogInputField, ConstantProperty.CONN_FIELD_CATALOG, connParam.getDatabase(),
//						true);

				viewAndValidateConnectionField(connCatalogInputField, ConstantProperty.CONN_FIELD_CATALOG,
						connParam.getDatabase(), true);

				if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {
					if (isDisplayed(driver, connsecretName)) {

						validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", true);

						driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

						waitForExecution(1000);

						verifyVisibilityOfButtons(driver, connsecretManagebtn, "Manage Button", true);

						verifyVisibilityOfButtons(driver, connsecretQuickAddbtn, "Quick Add Button", true);

						verifyVisibilityOfButtons(driver, connsecretRefreshbtn, "Refresh Button", true);

						validateInputFieldVisibility(connsecretPasswordfeild,
								ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN, "", true);
					} else {
						BaseSuite.reportErrorLog(
								"Secret Name field is not displayed on Connection details page. Kindly Check!!!");
					}

				}

				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

				int count = connPropertyList.size();

				flag = viewAndValidateConnectionPropertiesToConnection(connJsonEntity, count);

			} else {

				validateButtons(driver, connDatabricksBtn, 3);

				verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

				String selectedSecret = getAttribute(driver, connsecretName, "value");

				if (selectedSecret.isEmpty()) {

					verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);

				} else {

					verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", true);

				}

				verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

				// verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button",
				// true);

				// verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", true);

				inVisible(driver, spinner, Constant.ruleWait);

				viewAndValidateConnectionField(connName, "Connection Name", connParam.getConnName(), false);

				viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, false);

				viewAndValidateConnectionField(connCloudProviderField, "Cloud Provider",
						connParam.getcloudProvidername(), false);

				viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
						connParam.getAuthenticationname(), false);

				viewAndValidateConnectionField(connDEnvironmentField, "Databricks Environment",
						connParam.getDatabricksEnvironmentname(), false);

				verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

				viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
						connParam.getCustomJDBCURLValue(), false);

				validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST, connParam.getHost(),
						false);

				validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT, connParam.getPort(),
						false);

				validateInputFieldVisibility(connHttpPathInputField, ConstantProperty.CONN_FIELD_HTTPPATH,
						connParam.getHttpPath(), false);

				validateInputFieldVisibility(connCatalogInputField, ConstantProperty.CONN_FIELD_CATALOG,
						connParam.getDatabase(), false);

				if ((connParam.getAuthenticationname()).equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {

					if (isDisplayed(driver, connsecretName)) {

						validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", true);
						driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

						waitForExecution(1000);

						selectedSecret = getAttribute(driver, connsecretName, "value");

						if (selectedSecret.isEmpty()) {

							verifyVisibilityOfButtons(driver, connsecretManagebtn, "Manage Button", false);

						} else {

							verifyVisibilityOfButtons(driver, connsecretManagebtn, "Manage Button", true);

						}

						verifyVisibilityOfButtons(driver, connsecretQuickAddbtn, "Quick Add Button", true);

						verifyVisibilityOfButtons(driver, connsecretRefreshbtn, "Refresh Button", true);

						validateInputFieldVisibility(connsecretPasswordfeild,
								ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN, "", true);

					} else {

						BaseSuite.reportErrorLog(
								"Secret Name field is not displayed on Connection details page. Kindly Check!!!");
					}

				}
				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

				int count = connPropertyList.size();

				flag = viewAndValidateConnectionPropertiesToConnectionForDatabricks(connJsonEntity, count);

			}

		} catch (Exception e) {

			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("connection not visible properly kindly check :" + e.toString());
		}
		return flag;
	}

	// ******************************************
	public boolean changeConnTypeForDatabricks(String connJsonEntity, String icedqUser) throws Exception {
		BaseSuite.reportLog(
				"================================================ Change Connection Type System/User Scenario start =======================================");
		boolean flag = true;
		String newconnectionName = null;
		try {
			NewConnectionRepoPage np = new NewConnectionRepoPage(driver);

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			String selectedConnectionType = connParam.getType();

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

			String connusername = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

			if (isClickable(driver, connTypeSelectionDropdown, "type dropdown", true)) {

				click(driver, connTypeSelectionDropdown);

				if (isDisplayed(driver, connTypeListpane)) {

					BaseSuite.reportLog("Type list options are displayed");

					List<WebElement> typeList = getElements(driver, connTypeList);

//							np.enterClientId(connParam.getClientId());
//							
//							saveConnection(connsaveMsgconntypeChange);

					BaseSuite.reportLog("List has " + typeList.size() + "options as:");

					if (selectedConnectionType.equalsIgnoreCase("user")) {

						selectConnectionTypeForConn(typeList, "system");

						waitForExecution(2000);

						verifyIndividualLabel(driver, warningPopupTitle, conntypechangePopupTitle);

						verifyIndividualLabel(driver, warningPopupTitleMsg, conntypechangePopupTitleMsg);

						verifyVisibilityOfButtons(driver, connPopupCancelBtn, "Cancel", true);

						verifyVisibilityOfButtons(driver, connPopupYesBtn, "Yes", true);

						click(driver, connPopupYesBtn);

						String ActTypeselected = getAttribute(driver, connTypeField, "value");

						if (ActTypeselected.equalsIgnoreCase("System")) {

							enterSecretName("passForAllDatabaseConn");

							String CP = connParam.getcloudProvidername();

							if (CP.equalsIgnoreCase("Microsoft Azure")) {

								selectVaultPersonalAccessToken("Personal_Access_Token_Azure",
										ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN);

							} else {

								selectVaultPersonalAccessToken("Personal_Access_Token_AWS",
										ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN);
							}

							saveConnection();
						}
						// saveConnection("");

					} else {

						selectConnectionTypeForConn(typeList, "user");

						String ActType = getAttribute(driver, connTypeField, "value");

						saveConnection();

						waitForExecution(2000);

						clickOnUserConnectionTab();

						searchAndClickOnConnectionNameInConnRepo(newconnectionName);

						if (ActType.equalsIgnoreCase("user")) {

							if (icedqUser.equalsIgnoreCase("account_owner")) {

								enterSecretName("PassForAllDatabaseUserConn");

								String CP = connParam.getcloudProvidername();

								if (CP.equalsIgnoreCase("Microsoft Azure")) {

									selectVaultPersonalAccessToken("Personal_Access_Token_Azure",
											ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN);

								} else {

									// enterSecretName("WorkspaceOwnerUserSecret");

									selectVaultPersonalAccessToken("Personal_Access_Token_AWS",
											ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN);
								}
								saveConnection();

							} else {

								enterSecretName("WorkspaceOwnerUserSecret");

								String CP = connParam.getcloudProvidername();

								if (CP.equalsIgnoreCase("Microsoft Azure")) {

									selectVaultPersonalAccessToken("Personal_Access_Token_Azure",
											ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN);

								} else {

									selectVaultPersonalAccessToken("Personal_Access_Token_AWS",
											ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN);
								}
								saveConnection();
							}

						} else {

							if (connParam.connectorID.equalsIgnoreCase("databricks")) {

								entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
										connParam.getConnectorID(), icedqUser);
							} else {

								entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
										connParam.getConnectorID(), icedqUser);

								enterUsername(connusername);
							}

							saveConnection();
							// saveConnection("");

						}
					}
				}

				testConnection(connectionTestMess);

			}
		}

		catch (Exception ex) {
			Thread.currentThread().interrupt();
			// throw new Exception(ex.toString());
		}
		return flag;

	}

	// ******************************************

	public boolean updateDatabricksConnection(String connJsonEntity, String driverName, String testScenario,
			String validationMessage, String icedqUser) {
		boolean flag = true;
		boolean stop = true;
		String newconnectionName = null;
		BaseSuite.reportLog(
				"================================= Update Databricks Connection All fields Scenario start ================================");

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

			} else {
				String connName;
				waitForExecution(3000);
				clickOnConnectionsTab();
				isDisplayedInLoop(driver, 0, discardButtons);
				if (isDisplayed(driver, discardButtons)) {
					displayAndClick(driver, discardButtons);
				}
				if ((icedqUser.contains("owner"))) {
					connName = newconnectionName;
				} else {
					connName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
							+ ConstantProperty.TARGET_WORKSPACE_NAME;
				}
				searchAndClickOnConnectionNameInConnRepo(connName);

			}
			inVisible(driver, spinner, Constant.ruleWait);
			
			String wizardStatus = validateExistingConnPageButtonsFields(connJsonEntity);

			if (wizardStatus.contains("Wizard supported connector")) { // DAT-11547

				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", true);

				} else {

					verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", false);
				}
			}

			verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", true);

			} else {

				verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);
			}

			verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

			verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", true);

			verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", true);

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

			viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, true);

			selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

			String DatabricksCloud_ProviderValue = getAttribute(driver, connCloudProviderField, valueAttribute);

			BaseSuite.validationReportLog("Actual Cloud Provider After Change Cloud Provider Scenario"
					+ DatabricksCloud_ProviderValue + ", Now chnaging to " + connParam.getcloudProvidername());

			selectCloudProviderOfConnection(connParam.getcloudProvidername());

			viewAndValidateConnectionField(connCloudProviderField, "Cloud Provider", connParam.getcloudProvidername(),
					true);

			viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
					connParam.getAuthenticationname(), true);

			selectAuthenticationOfConnection(connParam.getAuthenticationname());

			viewAndValidateConnectionField(connDEnvironmentField, "Databricks Environment",
					connParam.getDatabricksEnvironmentname(), true);

			selectDatabricksEnvironmentOfConnection(connParam.getDatabricksEnvironmentname());

			verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

			selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

			enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());

			if (connParam.getCustomJdbcFullUrl().equalsIgnoreCase(booleanTrue)) {

				validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder,
						false);
				validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder,
						false);
				validateInputFieldVisibility(connHttpPathInputField, ConstantProperty.CONN_FIELD_HTTPPATH,
						connHttpPathPlaceHolder, false);

			} else {

				String actHost = getAttribute(driver, connHostInputField, valueAttribute);

				BaseSuite.validationReportLog(actHost + "Host Value is as per previous cloud Provider");

				validatAndeEnterValueToTextField(connHostTitle, connHostInputField, ConstantProperty.CONN_FIELD_HOST,
						connHostPlaceholder, connParam.getHost(), validationHostEmpty);

				viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
						connParam.getHost(), true);

				String actPort = getAttribute(driver, connPortInputField, valueAttribute);

				BaseSuite.validationReportLog(actPort + "Port Value is as per previous cloud Provider");

				validatAndeEnterValueToTextField(connPortTitle, connPortInputField, ConstantProperty.CONN_FIELD_PORT,
						connPortPlaceholder, connParam.getPort(), validationPortEmpty);

				viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
						connParam.getPort(), true);

				String actHttpPath = getAttribute(driver, connHttpPathInputField, valueAttribute);

				BaseSuite.validationReportLog(actHttpPath + "HttpPath Value is as per previous cloud Provider");

				validatAndeEnterValueToTextField(connHttpPathTitle, connHttpPathInputField,
						ConstantProperty.CONN_FIELD_HTTPPATH, connHttpPathPlaceHolder, connParam.getHttpPath(),
						validationDatabaseEmpty);

				viewAndValidateConnectionField(connHttpPathInputField, ConstantProperty.CONN_FIELD_HTTPPATH,
						connParam.getHttpPath(), true);
			}

			String DatabricksCatalogAsCloud_ProviderValue = getAttribute(driver, connCatalogInputField, valueAttribute);

			BaseSuite.validationReportLog("Entering Catalog as per Cloud Provider" + DatabricksCloud_ProviderValue
					+ ", Now chnaging to " + connParam.getcloudProvidername() + "and same changing catalog value from"
					+ DatabricksCatalogAsCloud_ProviderValue + "to" + connParam.getDatabase());

			validatAndeEnterValueToTextField(connCatalogTitle, connCatalogInputField,
					ConstantProperty.CONN_FIELD_CATALOG, connCatalogPlaceHolder, connParam.getDatabase(),
					validationDatabaseEmpty);

			viewAndValidateConnectionField(connCatalogInputField, ConstantProperty.CONN_FIELD_CATALOG,
					connParam.getDatabase(), true);

			selectConnectionType(chooseConnType, connParam.getType());

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				entersecretPassword(connJsonEntity, connParam.getAuthenticationname(), connParam.getConnectorID(),
						icedqUser);

			} else {

				validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", false);

				validateInputFieldVisibility(connsecretUserPAT, ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN, "",
						false);
			}

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

			} else {
			}
			ArrayList<String> connPropertyList = TestDataThroughApi
					.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

			int count = connPropertyList.size();

			updateConnectionPropertiesToConnection(connJsonEntity, count);

			if ((icedqUser.contains("owner"))) {

				saveConnection();

				clickOnConnectionsTab();

				/*
				 * isDisplayedInLoop(driver, 0, discardButtons); if (isDisplayed(driver,
				 * discardButtons)) { displayAndClick(driver, discardButtons); }
				 */

				getConnection(newconnectionName, update_actualValue);

				searchAndClickOnConnectionNameInConnRepo(newconnectionName);

			} else {
				flag = saveConnection(forbiddenToastMsg);

				stop = false;
			}
			if (stop) {
				flag = updateUsernameAndPasswordForDatabricksUserConnection(connJsonEntity, "create",
						connParam.getType(), newconnectionName, icedqUser);
			}

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Databricks connection not updated properly kindly check :" + e.toString());
		}
		return flag;
	}

	public boolean updateConnectionScenario(String connJsonEntity, String connJsonEntity3, String icedqUser) {

		BaseSuite.reportLog(
				"================================================ Change Connection JDBC URL To Full Info or Vice-Versa Scenario is start=======================================");
		boolean flag = true;
		String newconnectionName = null;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);
			ConnectionPoJO connParam3 = setConnectionParametersForApi(connJsonEntity3);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

			verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

			if (connParam.getCustomJdbcFullUrl().equalsIgnoreCase(booleanTrue)) {

				displayAndClick(driver, connCustomJDBCCheckbox);

				viewAndValidateConnectionField(connCustomJDBCTextbox, "JDBC URL Textbox", connParam.customJDBCURLValue,
						false);

//				viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
//						connParam3.getHost(), true);
				validatAndeEnterValueToTextField(connHostTitle, connHostInputField, ConstantProperty.CONN_FIELD_HOST,
						connHostPlaceholder, connParam3.getHost(), validationHostEmpty);

//				viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
//						connParam3.getPort(), true);
				validatAndeEnterValueToTextField(connPortTitle, connPortInputField, ConstantProperty.CONN_FIELD_PORT,
						connPortPlaceholder, connParam3.getPort(), validationPortEmpty);

//				viewAndValidateConnectionField(connHttpPathInputField, ConstantProperty.CONN_FIELD_HTTPPATH,
//						connParam.getHttpPath(), true);
				validatAndeEnterValueToTextField(connHttpPathTitle, connHttpPathInputField,
						ConstantProperty.CONN_FIELD_HTTPPATH, connHttpPathPlaceHolder, connParam3.getHttpPath(),
						validationDatabaseEmpty);

			} else {
				displayAndClick(driver, connCustomJDBCCheckbox);

				viewAndValidateConnectionField(connCustomJDBCTextbox, "JDBC URL Textbox", connDatabricksDefaultJDBCURL,
						true);

				validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder,
						false);
				validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder,
						false);
				validateInputFieldVisibility(connHttpPathInputField, ConstantProperty.CONN_FIELD_HTTPPATH,
						connHttpPathPlaceHolder, false);

				boolean actualStatus = isEnabled(driver, connCustomJDBCTextbox);
				if (actualStatus == true) {

					enterCustomJDBCURL("true", connParam3.getCustomJDBCURLValue());
				}

				viewAndValidateConnectionField(connCustomJDBCTextbox, "JDBC URL Textbox", connParam3.customJDBCURLValue,
						true);

			}

			flag = saveConnection();

			if (flag) {

				clickOnConnectionsTab();

				getConnection(newconnectionName, update_actualValue);

				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					searchAndClickOnConnectionNameInConnRepo(newconnectionName);

					testConnection(connectionTestMess);

					clickOnConnectionsTab();

					getConnection(newconnectionName, create_actualValue);

				} else {

					clickOnUserConnectionTab();

					searchAndClickOnConnectionNameInConnRepo(newconnectionName);

					testConnection(connectionTestMess);

					clickOnUserConnectionTab();

					getConnection(newconnectionName, create_actualValue);

				}

			}

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(
					"Connection is not Updated properly JDBC URL To Full Info or Vice-Versa :" + e.toString());
		}

		return flag;

	}

	public boolean updateDatabricksConnectionEnvironment(String connJsonEntity, String connJsonEntity2,
			String driverName, String testScenario, String validationMessage, String icedqUser) {

		BaseSuite.reportLog(
				"================================================ Update Databricks Connection Environment Scenario start =======================================");
		boolean flag = true;
		boolean stop = true;
		String newconnectionName = null;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);
			ConnectionPoJO connParam2 = setConnectionParametersForApi(connJsonEntity2);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

			// searchAndClickOnConnectionNameInConnRepo(newconnectionName);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

			} else {
				String connName;
				waitForExecution(3000);
				clickOnConnectionsTab();

				if ((!icedqUser.contains("owner"))) {
					connName = newconnectionName;
				} else {
					// connName = connParam.getConnName() + "_" +
					// ConstantProperty.TARGET_WORKSPACE_NAME;
				}
				searchAndClickOnConnectionNameInConnRepo(newconnectionName);

			}
			inVisible(driver, spinner, Constant.ruleWait);

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			// enterConnectionNameWithValidation(newconnectionName, testScenario,
			// validationMessage);

			viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, true);

			selectDriverOfFlatFileNativeConnection(connParam2.getDriverName());

			viewAndValidateConnectionField(connCloudProviderField, "Cloud Provider", connParam.getcloudProvidername(),
					true);

			selectCloudProviderOfConnection(connParam2.getcloudProvidername());

			viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
					connParam.getAuthenticationname(), true);

			selectAuthenticationOfConnection(connParam2.getAuthenticationname());

			String DatabricksEnvironmentValue = getAttribute(driver, connDEnvironmentField, valueAttribute);

			BaseSuite.validationReportLog("Updating Databricks Environment from" + DatabricksEnvironmentValue + " to "
					+ connParam2.getDatabricksEnvironmentname());

			selectDatabricksEnvironmentOfConnection(connParam2.getDatabricksEnvironmentname());

			viewAndValidateConnectionField(connDEnvironmentField, "Databricks Environment",
					connParam2.getDatabricksEnvironmentname(), true);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				if (isDisplayed(driver, connsecretName)) {

					validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", true);
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					waitForExecution(1000);

					String selectedSecret = getAttribute(driver, connsecretName, "value");

					if (selectedSecret.isEmpty()) {

						BaseSuite.validationReportLog("Secret Name field is reset");

						verifyVisibilityOfButtons(driver, connsecretManagebtn, "Manage Button", false);

					} else {
						BaseSuite.reportErrorLog("Secret Name field is not reset. Kindly Check!!!");

						verifyVisibilityOfButtons(driver, connsecretManagebtn, "Manage Button", true);

					}

					verifyVisibilityOfButtons(driver, connsecretQuickAddbtn, "Quick Add Button", true);

					verifyVisibilityOfButtons(driver, connsecretRefreshbtn, "Refresh Button", true);

					validateInputFieldVisibility(connsecretPasswordfeild,
							ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN, "", true);

					String selectedPAT = getAttribute(driver, connsecretPasswordfeild, "value");

					if (selectedPAT.isEmpty()) {
						BaseSuite.validationReportLog("Personal Access Token field is reset");

					} else {
						BaseSuite.reportErrorLog("Personal Access Token field is not reset. Kindly Check!!!");
					}

				} else {

					BaseSuite.reportErrorLog(
							"Secret Name field is not displayed on Connection details page. Kindly Check!!!");
				}
			} else {
				validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", false);

				validateInputFieldVisibility(connsecretPasswordfeild, ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN,
						"", false);
			}

			// flag = isDisplayed(driver, customJdbcUrlToggleButton);
			String state = connParam2.getCustomJdbcFullUrl();

			if (state.contains("true")) {

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				displayAndClick(driver, connCustomJDBCCheckbox);

			} else {

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				displayAndClick(driver, connCustomJDBCCheckbox);
			}

			// selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

			enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam2.getCustomJDBCURLValue());

			if (connParam.getCustomJdbcFullUrl().equalsIgnoreCase(booleanTrue)) {

				validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder,
						false);
				validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder,
						false);
				validateInputFieldVisibility(connHttpPathInputField, ConstantProperty.CONN_FIELD_HTTPPATH,
						connHttpPathPlaceHolder, false);

			} else {
				viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
						connParam.getHost(), true);
				validatAndeEnterValueToTextField(connHostTitle, connHostInputField, ConstantProperty.CONN_FIELD_HOST,
						connHostPlaceholder, connParam2.getHost(), validationHostEmpty);

				viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
						connParam.getPort(), true);
				validatAndeEnterValueToTextField(connPortTitle, connPortInputField, ConstantProperty.CONN_FIELD_PORT,
						connPortPlaceholder, connParam2.getPort(), validationPortEmpty);

				viewAndValidateConnectionField(connHttpPathInputField, ConstantProperty.CONN_FIELD_HTTPPATH,
						connParam.getHttpPath(), true);
				validatAndeEnterValueToTextField(connHttpPathTitle, connHttpPathInputField,
						ConstantProperty.CONN_FIELD_HTTPPATH, connHttpPathPlaceHolder, connParam2.getHttpPath(),
						validationDatabaseEmpty);

			}

			viewAndValidateConnectionField(connCatalogInputField, ConstantProperty.CONN_FIELD_CATALOG,
					connParam.getDatabase(), true);

			validatAndeEnterValueToTextField(connCatalogTitle, connCatalogInputField,
					ConstantProperty.CONN_FIELD_CATALOG, connCatalogPlaceHolder, connParam2.getDatabase(),
					validationDatabaseEmpty);

			selectConnectionType(chooseConnType, connParam.getType());

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				entersecretPassword(connJsonEntity2, connParam.getAuthenticationname(), connParam.getConnectorID(),
						icedqUser);

			} else {

				validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", false);

				validateInputFieldVisibility(connsecretUserPAT, ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN, "",
						false);
			}
			ArrayList<String> connPropertyList = TestDataThroughApi
					.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity2, connConnectionPropNames);

			int count = connPropertyList.size();

			updateConnectionPropertiesToConnection(connJsonEntity2, count);

			if ((icedqUser.contains("owner"))) {

				saveConnection();

				// testConnection(connectionTestMess);

				clickOnConnectionsTab();

//				isDisplayedInLoop(driver, 0, discardButtons);
//				if (isDisplayed(driver, discardButtons)) {
//					displayAndClick(driver, discardButtons);
//				}

				getConnection(newconnectionName, update_actualValue);

				searchAndClickOnConnectionNameInConnRepo(newconnectionName);

			} else {
				flag = saveConnection(forbiddenToastMsg);

				stop = false;
			}
			if (stop) {
				// if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE))
				// {
				flag = updateUsernameAndPasswordForDatabricksUserConnection(connJsonEntity2, "create",
						connParam.getType(), newconnectionName, icedqUser);
				// }
			}

			/*
			 * searchAndClickOnConnectionNameInConnRepo(newconnectionName);
			 * changeConnTypeForDatabricks(newconnectionName, connJsonEntity, icedqUser);
			 */

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Databricks connection not updated properly kindly check :" + e.toString());
		}
		return flag;
	}

	public boolean updateDatabricksConnectionCloudProvider(String connJsonEntity, String connJsonEntity4,
			String driverName, String testScenario, String validationMessage, String icedqUser) {

		BaseSuite.reportLog(
				"=================== Update Databricks Connection Cloud Provider Scenario start ==================");
		boolean flag = true;
		boolean stop = true;
		String newconnectionName = null;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);
			ConnectionPoJO connParam4 = setConnectionParametersForApi(connJsonEntity4);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

			} else {
				String connName;
				waitForExecution(3000);
				// clickOnConnectionsTab();

				if ((!icedqUser.contains("owner"))) {
					connName = newconnectionName;
				} else {
					// connName = connParam.getConnName() + "_" +
					// ConstantProperty.TARGET_WORKSPACE_NAME;
				}
				// searchAndClickOnConnectionNameInConnRepo(newconnectionName);

			}
			inVisible(driver, spinner, Constant.ruleWait);

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

			viewAndValidateConnectionField(connFlatFileDriverField, "Driver", driverName, true);

			selectDriverOfFlatFileNativeConnection(connParam4.getDriverName());

			viewAndValidateConnectionField(connCloudProviderField, "Cloud Provider", connParam.getcloudProvidername(),
					true);
			String DatabricksCloud_ProviderValue = getAttribute(driver, connCloudProviderField, valueAttribute);

			BaseSuite.validationReportLog("Updating Databricks Cloud Provider from" + DatabricksCloud_ProviderValue
					+ " to " + connParam4.getcloudProvidername());

			selectCloudProviderOfConnection(connParam4.getcloudProvidername());

			viewAndValidateConnectionField(connCloudProviderField, "Cloud Provider", connParam4.getcloudProvidername(),
					true);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				if (isDisplayed(driver, connsecretName)) {

					validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", true);
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					waitForExecution(1000);

					String selectedSecret = getAttribute(driver, connsecretName, "value");

					if (selectedSecret.isEmpty()) {

						BaseSuite.validationReportLog("Secret Name field is reset");

						verifyVisibilityOfButtons(driver, connsecretManagebtn, "Manage Button", false);

					} else {
						BaseSuite.reportErrorLog("Secret Name field is not reset. Kindly Check!!!");

						verifyVisibilityOfButtons(driver, connsecretManagebtn, "Manage Button", true);

					}

					verifyVisibilityOfButtons(driver, connsecretQuickAddbtn, "Quick Add Button", true);

					verifyVisibilityOfButtons(driver, connsecretRefreshbtn, "Refresh Button", true);

					validateInputFieldVisibility(connsecretPasswordfeild,
							ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN, "", true);

					String selectedPAT = getAttribute(driver, connsecretPasswordfeild, "value");

					if (selectedPAT.isEmpty()) {
						BaseSuite.validationReportLog("Personal Access Token field is reset");

					} else {
						BaseSuite.reportErrorLog("Personal Access Token field is not reset. Kindly Check!!!");
					}

				} else {

					BaseSuite.reportErrorLog(
							"Secret Name field is not displayed on Connection details page. Kindly Check!!!");
				}
			} else {
				validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", false);

				validateInputFieldVisibility(connsecretPasswordfeild, ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN,
						"", false);
			}

			viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
					connParam.getAuthenticationname(), true);

			selectAuthenticationOfConnection(connParam4.getAuthenticationname());

			selectDatabricksEnvironmentOfConnection(connParam4.getDatabricksEnvironmentname());

			viewAndValidateConnectionField(connDEnvironmentField, "Databricks Environment",
					connParam4.getDatabricksEnvironmentname(), true);

			// flag = isSelected(driver, customJdbcUrlToggleButton);
			flag = verifyCustomJDBCURLCheckboxOfConnection(connParam4.getCustomJdbcFullUrl());

			if (flag) {

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				// selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

				enterCustomJDBCURL(connParam4.getCustomJdbcFullUrl(), connParam4.getCustomJDBCURLValue());

			}

			if (connParam4.getCustomJdbcFullUrl().equalsIgnoreCase(booleanTrue)) {

				validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder,
						false);
				validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder,
						false);
				validateInputFieldVisibility(connHttpPathInputField, ConstantProperty.CONN_FIELD_HTTPPATH,
						connHttpPathPlaceHolder, false);

			} else {
				viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
						connParam.getHost(), true);
				validatAndeEnterValueToTextField(connHostTitle, connHostInputField, ConstantProperty.CONN_FIELD_HOST,
						connHostPlaceholder, connParam4.getHost(), validationHostEmpty);

				viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
						connParam.getPort(), true);
				validatAndeEnterValueToTextField(connPortTitle, connPortInputField, ConstantProperty.CONN_FIELD_PORT,
						connPortPlaceholder, connParam4.getPort(), validationPortEmpty);

				viewAndValidateConnectionField(connHttpPathInputField, ConstantProperty.CONN_FIELD_HTTPPATH,
						connParam.getHttpPath(), true);
				validatAndeEnterValueToTextField(connHttpPathTitle, connHttpPathInputField,
						ConstantProperty.CONN_FIELD_HTTPPATH, connHttpPathPlaceHolder, connParam4.getHttpPath(),
						validationDatabaseEmpty);

			}

			viewAndValidateConnectionField(connCatalogInputField, ConstantProperty.CONN_FIELD_CATALOG,
					connParam.getDatabase(), true);

			validatAndeEnterValueToTextField(connCatalogTitle, connCatalogInputField,
					ConstantProperty.CONN_FIELD_CATALOG, connCatalogPlaceHolder, connParam4.getDatabase(),
					validationDatabaseEmpty);

			selectConnectionType(chooseConnType, connParam.getType());

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				entersecretPassword(connJsonEntity4, connParam.getAuthenticationname(), connParam.getConnectorID(),
						icedqUser);

			} else {

				validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME,
						"Select secret name", false);

				validateInputFieldVisibility(connsecretUserPAT, ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN,
						"Select personal access token", false);
			}
			ArrayList<String> connPropertyList = TestDataThroughApi
					.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity4, connConnectionPropNames);

			int count = connPropertyList.size();

			updateConnectionPropertiesToConnection(connJsonEntity4, count);

			if ((icedqUser.contains("owner"))) {

				saveConnection();

				// testConnection(connectionTestMess);

				clickOnConnectionsTab();

				getConnection(newconnectionName, update_actualValue);

				searchAndClickOnConnectionNameInConnRepo(newconnectionName);

			} else {
				flag = saveConnection(forbiddenToastMsg);

				stop = false;
			}
			if (stop) {
				// if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE))
				// {
				flag = updateUsernameAndPasswordForDatabricksUserConnection(connJsonEntity4, "create",
						connParam.getType(), newconnectionName, icedqUser);
				// }
			}

			/*
			 * searchAndClickOnConnectionNameInConnRepo(newconnectionName);
			 * changeConnTypeForDatabricks(newconnectionName, connJsonEntity, icedqUser);
			 */

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Databricks connection not updated properly kindly check :" + e.toString());
		}
		return flag;
	}

	public boolean updateUsernameAndPasswordForDatabricksUserConnection(String connJsonEntity, String scenario,
			String connectionType, String connectionName, String icedqUser) {
		boolean flag = true;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);

		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);
			if (!icedqUser.toLowerCase().contains("reader")) {

				if (connectionType.trim().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

					waitForExecution(1000);

					cp.clickOnUserConnectionTab();

					waitForExecution(2000);

					cp.searchAndClickOnConnectionNameInConnRepo(connectionName);

					inVisible(driver, spinner, Constant.ruleWait);

					waitForExecution(1000);

					if (isDisplayed(driver, connsecretName)) {

						cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
								connParam.getConnectorID(), icedqUser);

					}

					flag = saveConnection();

					cp.clickOnUserConnectionTab();

					waitForExecution(2000);

					cp.searchConnection(connectionName);

					cp.getConnection(connectionName, update_actualValue);

					cp.searchAndClickOnConnectionNameInConnRepo(connectionName);

					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

					inVisible(driver, spinner, Constant.ruleWait);

					flag = testConnection(connectionTestMess);

					clickOnUserConnectionTab();

					waitForExecution(1000);

					cp.searchConnection(connectionName);

					cp.getConnection(connectionName, create_actualValue);

					cp.searchAndClickOnConnectionNameInConnRepo(connectionName);

				} else {

					inVisible(driver, spinner, Constant.ruleWait);

					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					flag = testConnection(connectionTestMess);

					clickOnConnectionsTab();

					waitForExecution(2000);

					inVisible(driver, spinner, Constant.ruleWait);

					cp.searchConnection(connectionName);

					cp.getConnection(connectionName, create_actualValue);

					searchAndClickOnConnectionNameInConnRepo(connectionName);
				}
			} else {
				waitForExecution(1000);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				inVisible(driver, spinner, Constant.ruleWait);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				flag = testConnection(connectionTestMess);

				clickOnConnectionsTab();

				waitForExecution(2000);

//					isDisplayedInLoop(driver, 0, discardButtons);
//					if (isDisplayed(driver, discardButtons)) {
//						displayAndClick(driver, discardButtons);
//					}

				waitForExecution(1000);

				cp.searchConnection(connectionName);

				getConnection(connectionName, create_actualValue);

				searchAndClickOnConnectionNameInConnRepo(connectionName);
			}

		} catch (Exception e) {

			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("user connection not updated properly kindly check :" + e.toString());
		}

		return flag;
	}

	public void existingDatabricksUserConnnectionDiscardFuctionality(String name, String connectorName) {

		try {
			clickOnButton(driver, connectionTab, "ConnectionTab", true);

			searchAndClickOnConnectionNameInConnRepo(name);

			verifyVisibilityOfButtons(driver, connSaveBtn, "Save", false);

			verifyVisibilityOfButtons(driver, connTestBtn, "Test", true);

			boolean discard = isDisplayed(driver, discardButtonsDetails);

			if (discard) {

				BaseSuite.validationReportLog(" discard" + " button is disabled in the page.");

				BaseSuite.validationReportLog(" Discard button visibility is matched with expected condition.");

				verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard", false);

			} else {

				BaseSuite.reportFailLog("Discard button is not displayed.", "verifyVisibilityOfButtons");

			}

			// verifyVisibilityOfButtons(driver, clickonRefresh, "Refresh", true);

			verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate", true);

			verifyVisibilityOfButtons(driver, connDeleteButton, "Delete", true);

			verifyFeildData(connName, "ConnectorName");

			dropDownDiscard(connDEnvironmentField, connDEnvironmentSearchIcon, connDEnvironmentList, secondvalueselect);

			waitForExecution(3000);

			click(driver, connCustomJDBCCheckbox);

			waitForExecution(2000);

			BaseSuite.validationReportLog("Checkbox Selected successfully");

			verifyVisibilityOfButtons(driver, connSaveBtn, "Save", true);

			verifyVisibilityOfButtons(driver, connTestBtn, "Test", false);

			verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard", true);

			// verifyVisibilityOfButtons(driver, clickonRefresh, "Refresh", true);

			verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate", true);

			verifyVisibilityOfButtons(driver, clickonDisable, "Delete", true);

			validatediscardBtn();

			clickOnButton(driver, discardpopupdiscardbtn, "Discard", true);

			verifyFeildData(connHostInputField, "HostName");

			verifyFeildData(connPortInputField, "PortName");

			verifyFeildData(connHttpPathInputField, "HttpPathValue");

			verifyFeildData(connCatalogInputField, "CatalogeName");

			dropDownDiscard(connTypeFeildverify, connTypedropdownOpener, connTypeList, connTypeSelectSys);

			viewAndValidateConnectionField(connsecretName, "Secret Name", "Field should be disabled.", false);

			viewAndValidateConnectionField(connsecretPasswordfeild, "Personal Access Token",
					"Field should be disabled.", false);

			waitForExecution(1000);

			clickOnButton(driver, userconnectionTab, "User ConnectionTab", true);

			searchAndClickOnConnectionNameInConnRepo(name);

			dropDownDiscard(connsecretName, connsecretNamedropdownbtn, connsecretNamedropdownlist, connSelectSecretOpt);

			dropDownDiscard(connsecretPasswordfeild, connsecretPassworddropdownbtn, connsecretPassdropdownlist,
					connSelectSecretPassOpt);

			waitForExecution(1000);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void discardDatabricksFuctionality(String connectionType, String icedqUser, String connectorName,
			String name) {
		try {

			if (connectionType.toLowerCase().contains(ConstantProperty.CONN_SYSTETYPE)) {

				clickOnNewConnectionBtn(icedqUser);

				chooseConnectorType(connectorName);

				if (icedqUser.contains("owner")) {

					newDatabricksConnnectionDiscardFuctionality(connectorName);

				} else {
					saveConnection(forbiddenToastMsg);

				}

				existingDatabricksConnnectionDiscardFuctionality(name, connectorName);

			} else {

				existingDatabricksUserConnnectionDiscardFuctionality(name, connectorName);

			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void newDatabricksConnnectionDiscardFuctionality(String connectorName) {

		try {

			verifyVisibilityOfButtons(driver, connSaveBtn, "Save", false);

			verifyVisibilityOfButtons(driver, connTestBtn, "Test", false);

			boolean discard = isDisplayed(driver, discardButtonsDetails);

			// boolean discard = isDisplayed(driver, discardButton);

			if (discard) {

				BaseSuite.validationReportLog(" discard" + " button is disabled in the page.");

				BaseSuite.validationReportLog(" Discard button visibility is matched with expected condition.");

				verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard", false);

			} else {

				BaseSuite.reportFailLog("Discard button is not displayed.", "verifyVisibilityOfButtons");

			}

			verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate", false);

			verifyVisibilityOfButtons(driver, clickonDisable, "Delete", false);

			verifyFeildData(connName, "ConnectorName");

			dropDownDiscard(connCloudProviderField, connCloudProviderSearchIcon, connCloudProviderList,
					secondvalueselect);

			dropDownDiscard(connDEnvironmentField, connDEnvironmentSearchIcon, connDEnvironmentList, secondvalueselect);

			waitForExecution(1000);

			click(driver, connCustomJDBCCheckbox);

			BaseSuite.validationReportLog("Checkbox Selected successfully");

			validatediscardBtn();

			clickOnButton(driver, discardpopupdiscardbtn, "Discard", true);

			verifyFeildData(connHostInputField, "HostName");

			verifyFeildData(connPortInputField, "PortName");

			verifyFeildData(connHttpPathInputField, "HttpPathValue");

			verifyFeildData(connCatalogInputField, "CatalogeName");

			dropDownDiscard(connTypeFeildverify, connTypedropdownOpener, connTypeList, connTypeSelect);

			dropDownDiscard(connsecretName, connsecretNamedropdownbtn, connsecretNamedropdownlist, connSelectSecretOpt);

			enterSecretName("passForAllDatabaseConn");

			dropDownDiscard(connsecretPasswordfeild, connsecretPassworddropdownbtn, connsecretPassdropdownlist,
					connSelectSecretPassOpt);

			waitForExecution(1000);
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void existingDatabricksConnnectionDiscardFuctionality(String name, String connectorName) {

		try {

			waitForExecution(1000);

			clickOnButton(driver, connectionTab, "ConnectionTab", true);

			searchAndClickOnConnectionNameInConnRepo(name);

			verifyVisibilityOfButtons(driver, connSaveBtn, "Save", false);

			verifyVisibilityOfButtons(driver, connTestBtn, "Test", true);

			boolean discard = isDisplayed(driver, discardButtonsDetails);

			if (discard) {

				BaseSuite.validationReportLog(" discard" + " button is disabled in the page.");

				BaseSuite.validationReportLog(" Discard button visibility is matched with expected condition.");

				verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard", false);

			} else {

				BaseSuite.reportFailLog("Discard button is not displayed.", "verifyVisibilityOfButtons");

			}

			// verifyVisibilityOfButtons(driver, clickonRefresh, "Refresh", true);

			verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate", true);

			verifyVisibilityOfButtons(driver, clickonDisable, "Delete", true);

			verifyFeildData(connName, "ConnectorName");

			dropDownDiscard(connCloudProviderField, connCloudProviderSearchIcon, connCloudProviderList,
					secondvalueselect);

			dropDownDiscard(connDEnvironmentField, connDEnvironmentSearchIcon, connDEnvironmentList, secondvalueselect);

			waitForExecution(2000);

			click(driver, connCustomJDBCCheckbox);

			waitForExecution(2000);

			BaseSuite.validationReportLog("Checkbox Selected successfully");

			verifyVisibilityOfButtons(driver, connSaveBtn, "Save", true);

			verifyVisibilityOfButtons(driver, connTestBtn, "Test", false);

			verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard", true);

			// verifyVisibilityOfButtons(driver, clickonRefresh, "Refresh", true);

			verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate", true);

			verifyVisibilityOfButtons(driver, clickonDisable, "Delete", true);

			validatediscardBtn();

			clickOnButton(driver, discardpopupdiscardbtn, "Discard", true);

			verifyFeildData(connHostInputField, "HostName");

			verifyFeildData(connPortInputField, "PortName");

			verifyFeildData(connHttpPathInputField, "HttpPathValue");

			verifyFeildData(connCatalogInputField, "CatalogeName");

			dropDownDiscard(connTypeFeildverify, connTypedropdownOpener, connTypeList, connTypeSelect);

			dropDownDiscard(connsecretName, connsecretNamedropdownbtn, connsecretNamedropdownlist, connSelectSecretOpt);

			dropDownDiscard(connsecretPasswordfeild, connsecretPassworddropdownbtn, connsecretPassdropdownlist,
					connSelectSecretPassOpt);

			waitForExecution(1000);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public boolean createExcelFileConnection(String connJsonEntity, String testScenario, String validationMessage,
			String icedqUser) {

		boolean flag = true;
		String newconnectionName = null;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME;

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			flag = clickOnNewConnectionBtn(icedqUser);

			if (flag) {

				chooseConnectorType(connParam.getConnectorID());

				inVisible(driver, spinner, Constant.ruleWait);

				if (connParam.getConnectorID().equalsIgnoreCase("excel")) {

					flag = validateExcelConnFieldsButtons();

				} else {

					flag = validateParquetConnFieldsButtons();
				}

				if (flag) {
					String connectorName = setConnectorIdToConnectorName(connParam.getConnectorID());

					boolean a = isDisplayed(driver, returnElement(connExcelLogo, dynamicName, connectorName));

					if (a) {
						BaseSuite.validationReportLog(connectorName + "Connector logo is displayed.");

					} else {
						BaseSuite.reportFailLog(connectorName + "connector logo is not displayed. Kindly Check!!!",
								"Logo isDisplayed");
					}

					verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

					verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);

					verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

					verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", false);

					verifyVisibilityOfButtons(driver, connUploadFilesButton, "Upload Files Button", false);

					verifyVisibilityOfButtons(driver, moreButton, "More Dropdown Button", false);

				}

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				flag = enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

				if (flag) {

					selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

					selectLocationOfParquetConnection(connParam.getServiceProviderName(), connParam);

					switch (connParam.getServiceProviderName().trim().toLowerCase()) {

					case "local":
						if (connParam.getConnectorID().equalsIgnoreCase("excel")) {

							enterFolderPathForFileConnection(connParam.getFolderPath());

							enterTestFileForExcelConnection(connParam.getTestFile());
						} else {

							enterFolderPathForFileConnection(connParam.getFolderPath());
						}

						break;

					case "aws-s3":

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

						selectConnectionType(chooseConnType, connParam.getType());

						break;

					default:

						break;

					}
					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						if (!connParam.getServiceProviderName().equalsIgnoreCase("local")) {

							entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);
						}

						if ((!connParam.getConnectorID().toLowerCase().equalsIgnoreCase("flat-file"))) {
							ArrayList<String> connPropertyList = TestDataThroughApi
									.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

							int count = connPropertyList.size();

							addConnectionPropertiesToExcelConnection(connJsonEntity, count);

							if (icedqUser.toLowerCase().contains("owner")) {

								flag = saveConnection(connectionSaveMesssage);

								clickOnConnectionsTab();

								searchConnection(newconnectionName);

								getConnection(newconnectionName, update_actualValue);

								searchAndClickOnConnectionNameInConnRepo(newconnectionName);

								if (flag || (isEnabled(driver, connDeleteButton) && (isEnabled(driver, moreButton)))) {

									testConnection(connectionTestMess);

									clickOnConnectionsTab();

									searchConnection(newconnectionName);

									getConnection(newconnectionName, create_actualValue);

									searchAndClickOnConnectionNameInConnRepo(newconnectionName);

								}

							} else {

								flag = saveConnection(forbiddenToastMsg);

							}

						}

					} else {

						if (connParam.getServiceProviderName().equalsIgnoreCase("aws-s3")
								&& connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

							validateFieldOfConnection(connsecretNameLabel, connsecretName,
									ConstantProperty.CONN_FIELD_SECRETNAME, connSecretNamePlaceholder, false);

							validateFieldOfConnection(connFlatFileAccesskeyLabel, connFlatFileAccesskeyField,
									ConstantProperty.CONN_FIELD_ACCESSKEY, accesskeyPlaceHolder, false);

							validateFieldOfConnection(connFlatFileSecretkeyLabel, connFlatFileSecretkeyField,
									ConstantProperty.CONN_FIELD_SECRETKEY, secretkeyPlaceHolder, false);

							if ((!connParam.getConnectorID().toLowerCase().equalsIgnoreCase("flat-file"))) {
								ArrayList<String> connPropertyList = TestDataThroughApi
										.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity,
												connConnectionPropNames);

								int count = connPropertyList.size();

								addConnectionPropertiesToExcelConnection(connJsonEntity, count);

								if (icedqUser.toLowerCase().contains("owner")) {

									flag = saveConnection(connectionSaveMesssage);

									clickOnUserConnectionTab();

									waitForExecution(3000);

									searchConnection(newconnectionName);

									getConnection(newconnectionName, update_actualValue);

									flag = searchAndClickOnConnectionNameInConnRepo(newconnectionName);

									inVisible(driver, spinner, Constant.ruleWait);

									if (flag) {

										entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
												connParam.getConnectorID(), icedqUser);

										saveConnection();

										testConnection(connectionTestMess);

										clickOnConnectionsTab();

										searchConnection(newconnectionName);

										getConnection(newconnectionName, create_actualValue);

										searchAndClickOnConnectionNameInConnRepo(newconnectionName);
									}

								} else {

									flag = saveConnection(forbiddenToastMsg);

								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog("Connection not created properly due to exception kindly check " + e.toString());
		}

		return flag;

	}

	public boolean createExcelFileConnectionInvalid(ConnectionPoJO connParamFromExcel, String testScenario,
			String icedqUser, String tctype, String connectionType) throws IOException {

		boolean flag = true;
		boolean status1 = false;
		boolean status = false;
		String newconnectionName = null;

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connParamFromExcel.getConnectionJsonValue());

			newconnectionName = connParam.getConnName();

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			status1 = entervalueInTextFieldWithValidation(connParam, connName, "Connection Name", newconnectionName,
					testScenario, connParamFromExcel.getValidationMessage(), true);

			selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

			selectLocationOfFlatFileNativeConnection(connParam.getServiceProviderName(), connParam);

			if (!tctype.isEmpty()) {

				switch (connParamFromExcel.getFieldName().toLowerCase().trim()) {

				case "connectionname":

					switch (connParam.getServiceProviderName().trim().toLowerCase())

					{
					case "local":

						entervalueInTextFieldWithValidation(connParam, connFlatFileFolderPathField,
								ConstantProperty.CONN_FIELD_FOLDERPATH, connParam.getFolderPath(), testScenario,
								connParamFromExcel.getValidationMessage(), true);

						entervalueInTextFieldWithValidation(connParam, connExcelTestFileField, "Test File",
								connParam.getTestFile(), testScenario, connParamFromExcel.getValidationMessage(), true);

						break;

					default:

						break;

					}

					inVisible(driver, spinner, Constant.ruleWait);

					status = isEnabled(driver, connSaveBtn);

					if (status) {

						if (icedqUser.toLowerCase().contains("owner")) {

							String saveErrorMsg = "Connection name \'" + newconnectionName + "\' already exists.";
							status = saveConnection(saveErrorMsg);

						} else {

							status = saveConnection(forbiddenToastMsg);
						}

					}

					break;

				case "folderpath":

					entervalueInTextFieldWithValidation(connParam, connFlatFileFolderPathField,
							ConstantProperty.CONN_FIELD_FOLDERPATH, connParam.getFolderPath(), testScenario,
							connParamFromExcel.getValidationMessage(), true);

					break;

				case "testfile":

					enterValueToTextField(driver, connFlatFileFolderPathField, ConstantProperty.CONN_FIELD_FOLDERPATH,
							connParam.getFolderPath());

					entervalueInTextFieldWithValidation(connParam, connExcelTestFileField, "Test File",
							connParam.getTestFile(), testScenario, connParamFromExcel.getValidationMessage(), true);

					break;

				case "propertyname":
				case "propertyvalue":

					enterValueToTextField(driver, connFlatFileFolderPathField, ConstantProperty.CONN_FIELD_FOLDERPATH,
							connParam.getFolderPath());

					enterValueToTextField(driver, connExcelTestFileField, "Test File", connParam.getTestFile());

					ArrayList<String> connPropertyList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(
							connParamFromExcel.getConnectionJsonValue(), connConnectionPropNames);

					int count = connPropertyList.size();

					addConnectionPropertiesToExcelConnectionInvalid(connParamFromExcel.getConnectionJsonValue(), count,
							testScenario, connParamFromExcel.getFieldName());

					break;

				default:

					BaseSuite.reportErrorLog(
							"Field name is not found kindly check :: " + connParamFromExcel.getFieldName());
					break;

				}

			} else if (status1) {
				status = true;

				boolean discardbutton = isEnabled(driver, discardButtonsDetails);

				if (discardbutton) {

					clickOnButton(driver, discardButtonsDetails, "Discard", true);

					waitForExecution(2000);

					clickOnButton(driver, discardpopupdiscardbtn, "Pop-up Discard", true);

					waitForExecution(2000);

				} else {

					BaseSuite.reportErrorLog("Discard button is not enabled after making changes. Kindly check!!!");
				}

			}

			if (status || status1) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (

		Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(
					"File connection not created properly enterFileConnectionDetailsForInvalidScenario kindly check :"
							+ e.toString());
		}
		return flag;
	}

	/** testScenario = "Invalid" Excel **/

	public boolean enterExcelFileConnectionDetailsForInvalidScenarioToTestConnection(ConnectionPoJO connParamFromExcel,
			String testScenario, String icedqUser, String tctype, String connectionType) {
		boolean flag = false;
		boolean status = false;
		String newConnectionName = null;
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(
					connParamFromExcel.getConnectionJSONForExcelLocal());

			newConnectionName = connParam.getConnName();

			status = entervalueInTextFieldWithValidation(connParam, connName, "Connection Name", newConnectionName,
					testScenario, connParamFromExcel.getValidationMessage(), true);

			if (status) {

				selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

				selectLocationOfFlatFileNativeConnection(connParam.getServiceProviderName(), connParam);

				switch (connParam.getServiceProviderName().toLowerCase()) {

				case "local":

					switch (connParamFromExcel.getFieldName().trim().toLowerCase()) {

					case "folderpath":

						entervalueInTextFieldWithValidation(connParam, connFlatFileFolderPathField,
								ConstantProperty.CONN_FIELD_FOLDERPATH, connParam.getFolderPath(), testScenario,
								connParamFromExcel.getValidationMessage(), true);

					case "testfile":

						entervalueInTextFieldWithValidation(connParam, connExcelTestFileField, "Test File",
								connParam.getTestFile(), testScenario, connParamFromExcel.getValidationMessage(), true);

					}

				}

				status = saveAndTestConnectionForInvalidScenario(icedqUser, status, connectionType);

				if (connectionType.equalsIgnoreCase("User") && icedqUser.contains("owner")) {

					clickOnConnectionsTab();

					searchAndClickOnConnectionNameInConnRepo(newConnectionName);

				}
			}
			if (status) {
				flag = true;
			}

		} catch (Exception e) {

			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("File connection not created properly kindly check :" + e.toString());
		}
		return flag;
	}

	/** Databricks Invalid **/

	public boolean enterDatabricksConnectionDetailsForInvalidScenario(ConnectionPoJO connParamFromExcel,
			String testScenario, String icedqUser, String tctype, String connectionType) {
		boolean flag = true;
		boolean status1 = false;
		boolean status = false;
		String newconnectionName = null;

		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connParamFromExcel.getConnectionJsonValue());

			newconnectionName = connParam.getConnName();

			inVisible(driver, spinner, Constant.ruleWait);

			status1 = entervalueInTextFieldWithValidation(connParam, connName, "Connection Name", newconnectionName,
					testScenario, connParamFromExcel.getValidationMessage(), true);

			if (!tctype.isEmpty()) {

				selectDriverOfFlatFileNativeConnection(connParam.getDriverName());
				selectCloudProviderOfConnection(connParam.getcloudProvidername());
				selectAuthenticationOfConnection(connParam.getAuthenticationname());
				selectDatabricksEnvironmentOfConnection(connParam.getDatabricksEnvironmentname());

				boolean cs = selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

				inVisible(driver, spinner, Constant.ruleWait);

				if (cs) {
					selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());
				}

				switch (connParamFromExcel.getFieldName().toLowerCase().trim()) {

				case "connectionname":
					if (Boolean.parseBoolean(connParam.getCustomJdbcFullUrl())) {
						status = entervalueInTextFieldWithValidation(connParam, connCustomJDBCTextbox, "",
								connParam.getCustomJDBCURLValue(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
					} else {
						entervalueInTextFieldWithValidation(connParam, connHostInputField,
								ConstantProperty.CONN_FIELD_HOST, connParam.getHost(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
						entervalueInTextFieldWithValidation(connParam, connPortInputField,
								ConstantProperty.CONN_FIELD_PORT, connParam.getPort(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
						entervalueInTextFieldWithValidation(connParam, connHttpPathInputField,
								ConstantProperty.CONN_FIELD_HTTPPATH, connParam.getHttpPath(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
					}

					validatAndeEnterValueToTextField(connCatalogTitle, connCatalogInputField,
							ConstantProperty.CONN_FIELD_CATALOG, connCatalogPlaceHolder, connParam.getDatabaseName(),
							validationDatabaseEmpty);

					selectConnectionType(connectionType);

					if (!connectionType.equalsIgnoreCase("user")) {
						entersecretPassword(connParamFromExcel.getConnectionJsonValue(),
								connParam.getAuthenticationname(), connParam.getConnectorID(), icedqUser);
					} else {
						validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", false);
						validateInputFieldVisibility(connsecretUserPAT, ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN,
								"", false);
					}

					inVisible(driver, spinner, Constant.ruleWait);
					if (!newconnectionName.isEmpty()) {
						if (icedqUser.toLowerCase().contains("owner")) {
							String saveErrorMsg = "Connection name \'" + newconnectionName + "\' already exists.";
							status = saveConnection(saveErrorMsg);
						} else {
							status = saveConnection(forbiddenToastMsg);
						}
					}
					break;

				case "jdbcurl":
					if (Boolean.parseBoolean(connParam.getCustomJdbcFullUrl())) {
						status = entervalueJdbcWithValidation(connParam, connCustomJDBCTextbox,
								connParam.getCustomJDBCURLValue(), "", testScenario,
								connParamFromExcel.getValidationMessage(), true);
					}
					break;

				case "host":
					selectCustomJDBCURLOfConnection("false");
					status = entervalueInTextFieldWithValidation(connParam, connHostInputField,
							ConstantProperty.CONN_FIELD_HOST, connParam.getHost(), testScenario,
							connParamFromExcel.getValidationMessage(), true);
					break;

				case "port":
					selectCustomJDBCURLOfConnection("false");
					status = entervalueInTextFieldWithValidation(connParam, connPortInputField,
							ConstantProperty.CONN_FIELD_PORT, connParam.getPort(), testScenario,
							connParamFromExcel.getValidationMessage(), true);
					break;

				case "httppath":
					selectCustomJDBCURLOfConnection("false");
					status = entervalueInTextFieldWithValidation(connParam, connHttpPathInputField,
							ConstantProperty.CONN_FIELD_HTTPPATH, connParam.getHttpPath(), testScenario,
							connParamFromExcel.getValidationMessage(), true);
					break;

				case "propertyname":
				case "propertyvalue":
					ArrayList<String> connPropertyList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(
							connParamFromExcel.getConnectionJsonValue(), connConnectionPropNames);

					int count = connPropertyList.size();
					if (count > 0) {
						status = addConnectionPropertiesToConnection1(connParamFromExcel.getConnectionJsonValue(),
								count, testScenario, connParamFromExcel.getFieldName());

						displayAndClick(driver, newPropertyCancelButton);

						clickOnOverviewTab();
					} else {
						BaseSuite.reportErrorLog(
								"No connection properties found for " + connParamFromExcel.getFieldName());
						status = false;
					}
					break;

				default:
					BaseSuite.reportErrorLog(
							"Field name is not found kindly check :: " + connParamFromExcel.getFieldName());
					status = false;
					break;
				}

			} else if (status1) {
				status = true;
			}

			flag = status || status1;

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(
					"Database connection not created properly enterDatabaseConnectionDetailsForInvalidScenario kindly check :"
							+ e.toString());
		}
		return flag;
	}

	public boolean enterDatabricksConnectionDetailsForInvalidScenarioToTestConnection(String connJsonEntity,
			ConnectionPoJO connParamFromExcel, String connectionName, String testScenario, String icedqUser,
			String connectionType) {
		boolean flag = true;
		boolean status = false;
		String newConnectionName = null;
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			// String timestamp = new
			// SimpleDateFormat(ConstantProperty.CONNECTIONNAME_TIMESTAMPFORMAT).format(new
			// Date());

			newConnectionName = connParam.getConnName();

			if (icedqUser.contains("owner")) {

				status = entervalueInTextFieldWithValidation(connParam, connName, "Connection Name", newConnectionName,
						testScenario, connParamFromExcel.getValidationMessage(), true);

				if (status) {

					selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

					selectCloudProviderOfConnection(connParam.getcloudProvidername());

					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					selectDatabricksEnvironmentOfConnection(connParam.getDatabricksEnvironmentname());

					if (Boolean.parseBoolean(connParam.getCustomJdbcFullUrl())) {

						entervalueInTextFieldWithValidation(connParam, connCustomJDBCTextbox, "",
								connParam.getCustomJDBCURLValue(), testScenario,
								connParamFromExcel.getValidationMessage(), true);

					} else {

						entervalueInTextFieldWithValidation(connParam, connHostInputField,
								ConstantProperty.CONN_FIELD_HOST, connParam.getHost(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
						entervalueInTextFieldWithValidation(connParam, connPortInputField,
								ConstantProperty.CONN_FIELD_PORT, connParam.getPort(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
						entervalueInTextFieldWithValidation(connParam, connHttpPathInputField,
								ConstantProperty.CONN_FIELD_HTTPPATH, connParam.getHttpPath(), testScenario,
								connParamFromExcel.getValidationMessage(), true);

					}

					validatAndeEnterValueToTextField(connCatalogTitle, connCatalogInputField,
							ConstantProperty.CONN_FIELD_CATALOG, connCatalogPlaceHolder, connParam.getDatabaseName(),
							validationDatabaseEmpty);

					selectConnectionType(connectionType);

					if (!connectionType.equalsIgnoreCase("user")) {

						entersecretPassword(connParamFromExcel.getConnectionJsonValue(),
								connParam.getAuthenticationname(), connParam.getConnectorID(), icedqUser);
					} else {

						validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", false);
						validateInputFieldVisibility(connsecretUserPAT, ConstantProperty.CONN_FIELD_PERSONALACCESSTOKEN,
								"", false);
					}

					status = saveAndTestConnectionForInvalidScenario(icedqUser, status, connectionType);

					if (connectionType.equalsIgnoreCase("user")) {
						clickOnConnectionRepoBreadcrumbLink();
						searchAndClickOnConnectionNameInConnRepo(connectionName);
					}
				}
			} else if (icedqUser.contains("contributor") || icedqUser.contains("executor")) {

				if (connectionType.equalsIgnoreCase("user")) {

					clickOnUserConnectionTab();

					flag = searchAndClickOnConnectionNameInConnRepo(connectionName);

					if (flag) {

						String a1 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity,
								"$.secretId");

						enterSecretName(a1);

						String a2 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity,
								"$.authConfig.password");

						selectVaultPassword(a2, ConstantProperty.CONN_FIELD_PASSWORD);

					}

					status = saveConnection();

					if (status) {

						clickOnButton(driver, connTestBtn, "Test", true);

						inVisible(driver, spinner, 30);

						flag = captureToastMsgForConnection(driver, toastMsg, popUpClose, connectionTestMess,
								"Connection Test", false);
					}
				}
			} else {
				validateAndEnterUsernameAndPasswordForGrant(connJsonEntity,flag, connParam.getUsername(),
						icedqUser, connParamFromExcel.getValidationMessage(), testScenario);
			}
	} catch (Exception e) {

			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" Database connection not tested properly kindly check :" + e.toString());
		}
		return flag;
	}

	
	/** create kerberos invalid scenario method **/

	public boolean enterKerberosAuthConnectionDetailsForInvalidScenario(ConnectionPoJO connParamFromExcel,
			String testScenario, String icedqUser, String tctype, String connectionType) {
		boolean flag = true;
		boolean status1 = false;
		boolean status = false;
		String newconnectionName = null;
		String UserKeytabLocation =System.getProperty("user.dir")+ Constant.USER_KEYTAB_LOCATION;
		String KerberosConfigLocation =System.getProperty("user.dir")+ Constant.KERBEROS_CONFIG_LOCATION;
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connParamFromExcel.getKerberosCreate());

			newconnectionName = connParam.getConnName();

			inVisible(driver, spinner, Constant.ruleWait);

			status1 = entervalueInTextFieldWithValidation(connParam,connName, "Connection Name", newconnectionName, testScenario,connParamFromExcel.getValidationMessage(), true);

			if (!tctype.isEmpty()) {

				selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

				String authName = setAuthenticationType(connParam.getAuthentication());

				selectAuthenticationOfConnection(authName);

				boolean cs = selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

				inVisible(driver, spinner, Constant.ruleWait);

				selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

				switch (connParamFromExcel.getFieldName().toLowerCase().trim()) {

				case "connectionname":

					if (Boolean.parseBoolean(connParam.getCustomJdbcFullUrl())) {

						entervalueInTextFieldWithValidation(connParam,connCustomJDBCTextbox, "",connParam.getCustomJDBCURLValue(), testScenario,connParamFromExcel.getValidationMessage(), true);
						
					} else {

						entervalueInTextFieldWithValidation(connParam,connHostInputField, ConstantProperty.CONN_FIELD_HOST,
								connParam.getHost(), testScenario, connParamFromExcel.getValidationMessage(), true);
						
						entervalueInTextFieldWithValidation(connParam,connPortInputField, ConstantProperty.CONN_FIELD_PORT,
								connParam.getPort(), testScenario, connParamFromExcel.getValidationMessage(), true);
						
						entervalueInTextFieldWithValidation(connParam,connDatabaseInputField,ConstantProperty.CONN_FIELD_DATABASE, connParam.getDatabaseName(), testScenario,
								connParamFromExcel.getValidationMessage(), true);
					}
					
					
					WebElement m = driver.findElement(By.xpath("//input[@id='krbFile']"));

					m.sendKeys(KerberosConfigLocation);

					BaseSuite.validationReportLog("Krb5 File Choosed successfully");

					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
					
					selectConnectionType(connectionType);
					

					if (!connectionType.equalsIgnoreCase("user"))
					{

						WebElement n = driver.findElement(By.xpath("//input[@id='keytab']"));

						n.sendKeys(UserKeytabLocation);

						BaseSuite.validationReportLog("User key tab File Choosed successfully");

						validatAndeEnterValueToTextField(connUserPrincipalLabel, connHiveUserPrincipal,ConstantProperty.CONN_FIELD_USERPRINCIPAL, connPrincipalPlaceholder,
								connParam.getUserPrincipal(), validationUserprincipal);
						
					} else
					{

						validateInputFieldVisibility(connHiveUserPrincipal, ConstantProperty.CONN_USERPRINCIPAL, "",false);

						isEnabled(driver, connUserKeytab);

						BaseSuite.validationReportLog("User key tab Field is Disabled");

						isEnabled(driver, chooseFileBtn);

						BaseSuite.validationReportLog("Choose File button is Disabled");
					}

					inVisible(driver, spinner, Constant.ruleWait);

					if (icedqUser.toLowerCase().contains("owner"))
					{
						String saveErrorMsg = "Connection name \'" + newconnectionName + "\' already exists.";
						status = saveConnection(saveErrorMsg);

					} else {

						status = saveConnection(forbiddenToastMsg);
					}
					break;

				case "jdbcurl":
					if ((Boolean.parseBoolean(connParam.getCustomJdbcFullUrl()))) {
						selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());
						        //entervalueInTextFieldWithValidation(connParam,connCustomJDBCTextbox, "",connParam.getCustomJDBCURLValue(), testScenario,connParamFromExcel.getValidationMessage(), true);
						 status = entervalueJdbcWithValidation(connParam,connCustomJDBCTextbox,connParam.getCustomJDBCURLValue(), "",testScenario,connParamFromExcel.getValidationMessage(), true);
					}
					break;

				case "host":
					selectCustomJDBCURLOfConnection("false");
					status = entervalueInTextFieldWithValidation(connParam,connHostInputField, ConstantProperty.CONN_FIELD_HOST,
							connParam.getHost(), testScenario, connParamFromExcel.getValidationMessage(), true);

					break;

				case "port":
					selectCustomJDBCURLOfConnection("false");
					status = entervalueInTextFieldWithValidation(connParam,connPortInputField, ConstantProperty.CONN_FIELD_PORT,
							connParam.getPort(), testScenario, connParamFromExcel.getValidationMessage(), true);

					break;
				case "database":
					selectCustomJDBCURLOfConnection("false");
					status = entervalueInTextFieldWithValidation(connParam,connDatabaseInputField,
							ConstantProperty.CONN_FIELD_DATABASE, connParam.getDatabaseName(), testScenario,
							connParamFromExcel.getValidationMessage(), true);

					break;
				
				
				case "propertyname":
				case "propertyvalue":
					ArrayList<String> connPropertyList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(connParamFromExcel.getKerberosCreate(), connConnectionPropNames);

					int count = connPropertyList.size();

					status = addConnectionPropertiesToConnection1(connParamFromExcel.getKerberosCreate(), count,testScenario, connParamFromExcel.getFieldName());

					clickOnOverviewTab();

					break;

				default:
					BaseSuite.reportErrorLog(
							"Field name is not found kindly check :: " + connParamFromExcel.getFieldName());
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
	
	
		
	public void entersecretPasswordAthena(String connJsonEntity, String authentication, String connectorId,
			String icedqUser) throws NoSuchElementException {
 
		String connectorName = null;
		try {
 
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);
 
			switch (connectorId.toLowerCase()) {
 
			case "athena":
				connectorName = "Athena";
				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {
 
					enterSecretName("passForAllDatabaseConn");
 
					selectAccessKey("Athena_AccessKey");
					selectAthenaSecretKey("Athena_SecretKey");
 
				} else {
					switch (icedqUser) {
 
					case "account_owner":
 
						enterSecretName("PassForAllDatabaseUserConn");
 
						selectAccessKey("Athena_AccessKey");
						selectAthenaSecretKey("Athena_SecretKey");
 
					}
				}
				break;
			}
 
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Exception found :  " + e.getMessage());
			throw new NoSuchElementException();
		}
	}


	public boolean createAtScaleConnection(String connJsonEntity, String testScenario, String validationMessage,
			String icedqUser) {
		boolean flag = true;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		String newconnectionName = null;
		LoginPage lp = new LoginPage(driver);

		try {
			if (isDisplayed(driver, userName) && isDisplayed(driver, passWord)) {

				flag = lp.loginWithIcedqUserAndSelectWorkspace(icedqUser, ConstantProperty.TARGET_WORKSPACE_NAME,
						ConstantProperty.CONNECTIONREPOMODULENAME, "");

			}
			if (flag) {

				ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

				if (icedqUser.contains("account")) {

					newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
							+ ConstantProperty.TARGET_WORKSPACE_NAME + "AO";
				} else {

					newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
							+ ConstantProperty.TARGET_WORKSPACE_NAME + "WO";
				}

				String authName = setAuthenticationType(connParam.getAuthentication());

				String connusername = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				flag = clickOnNewConnectionBtn(icedqUser);

				if (flag) {

					chooseConnectorType(connParam.getConnectorID());

					inVisible(driver, spinner, Constant.ruleWait);

					if (flag) {

						String connectorName = setConnectorIdToConnectorName(connParam.getConnectorID());

						boolean a = isDisplayed(driver, returnElement(connExcelLogo, dynamicName, connectorName));

						if (a) {

							BaseSuite.validationReportLog(connectorName + "Connector logo is displayed.");

						} else {
							BaseSuite.reportFailLog(connectorName + "connector logo is not displayed. Kindly Check!!!",
									"Logo isDisplayed");
						}

						validateInputFields(driver, connExcelInputFields, 2);

						validateButtons(driver, connDetailsPageTabs, 2);

						validateButtons(driver, connRDBMSBtn, 5);

						verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

						verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);

						verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

						verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", false);

						verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", false);

					}

					enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

					selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

					selectAuthenticationOfConnection(authName);

					boolean cs = isDisplayed(driver, connAtScaleCustomJDBCCheckbox);

					boolean JDBCTextbox = isEnabled(driver, connCustomJDBCTextbox);

					if (cs && JDBCTextbox) {

						enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());
					}

					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					selectConnectionType(chooseConnType, connParam.getType());

					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
								connParam.getConnectorID(), icedqUser);

						enterUsername(connusername);

					} else {

						validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "",
								false);

						validateInputFieldVisibility(connsecretUserPassword, ConstantProperty.CONN_FIELD_PASSWORD, "",
								false);

					}

					ArrayList<String> connPropertyList = TestDataThroughApi
							.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

					int count = connPropertyList.size();

					addConnectionPropertiesToConnection(connJsonEntity, count);

					if (icedqUser.toLowerCase().contains("owner")) {

						flag = saveConnection(connectionSaveMesssage);

						clickOnConnectionsTab();

						cp.searchConnection(newconnectionName);

						getConnection(newconnectionName, update_actualValue);

						searchAndClickOnConnectionNameInConnRepo(newconnectionName);

						if (flag || (isEnabled(driver, connDeleteButton) && isEnabled(driver, connDuplicateButton))) {

							flag = enterUsernameAndPasswordForUserConnection(connJsonEntity, connParam,
									connParam.getType(), newconnectionName, connusername, icedqUser);
						}
					} else {

						flag = saveConnection(forbiddenToastMsg);
					}
				}
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" Database connection not created properly kindly check :" + e.toString());
		}
		return flag;
	}
	
	
	/*************Test invalid Scenario of kerberos Connection******************/
	
	
	public boolean kerberosAuthToTestInvalidScenario(String connJsonEntity, ConnectionPoJO connParamFromExcel,
			String connectionName, String testScenario, String icedqUser, String connectionType) {
		boolean flag = true;
		boolean status = false;
		String newConnectionName = null;
		String UserKeytabLocation = System.getProperty("user.dir") + Constant.USER_KEYTAB_LOCATION;
		String KerberosConfigLocation = System.getProperty("user.dir") + Constant.KERBEROS_CONFIG_LOCATION;
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			newConnectionName = connParam.getConnName();

			if (icedqUser.contains("owner")) {

				status = entervalueInTextFieldWithValidation(connParam,connName, "Connection Name", newConnectionName,
						testScenario, connParamFromExcel.getValidationMessage(), true);

				if (status) {

					selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

					if (Boolean.parseBoolean(connParam.getCustomJdbcFullUrl())) {

						entervalueInTextFieldWithValidation(connParam,connCustomJDBCTextbox, "",
								connParam.getCustomJDBCURLValue(), testScenario,
								connParamFromExcel.getValidationMessage(), true);

					} else {

						entervalueInTextFieldWithValidation(connParam,connHostInputField, ConstantProperty.CONN_FIELD_HOST,
								connParam.getHost(), testScenario, connParamFromExcel.getValidationMessage(), true);
						entervalueInTextFieldWithValidation(connParam,connPortInputField, ConstantProperty.CONN_FIELD_PORT,
								connParam.getPort(), testScenario, connParamFromExcel.getValidationMessage(), true);
						entervalueInTextFieldWithValidation(connParam,connDatabaseInputField,
								ConstantProperty.CONN_FIELD_DATABASE, connParam.getDatabaseName(), testScenario,
								connParamFromExcel.getValidationMessage(), true);

					}
					WebElement m = driver.findElement(By.xpath("//input[@id='krbFile']"));

					m.sendKeys(KerberosConfigLocation);

					BaseSuite.validationReportLog("Krb5 File Choosed successfully");

					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
					

					selectConnectionType(connectionType);

					status = enterUserPrincipalAndKeytabForKerberosInvalid(connJsonEntity,connectionType, newConnectionName, connParam, connParamFromExcel,testScenario, icedqUser);

					status = saveAndTestConnectionForInvalidScenario(icedqUser, status, connectionType);

					if (connectionType.equalsIgnoreCase("user")) {
						clickOnConnectionsTab();
						searchAndClickOnConnectionNameInConnRepo(connectionName);
					}
				}
			} else if (icedqUser.contains("contributor") || icedqUser.contains("executor")) {
				
				if (!connectionType.equalsIgnoreCase("user"))
				{
				status = entervalueInTextFieldWithValidation(connParam,connName, "Connection Name", newConnectionName,
						testScenario, connParamFromExcel.getValidationMessage(), true);

				if (status) {

					selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

					selectAuthenticationOfConnection(connParam.getAuthenticationname());

					selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

					if (Boolean.parseBoolean(connParam.getCustomJdbcFullUrl())) {

						entervalueInTextFieldWithValidation(connParam,connCustomJDBCTextbox, "",connParam.getCustomJDBCURLValue(), testScenario,
								connParamFromExcel.getValidationMessage(), true);

					} else {

						entervalueInTextFieldWithValidation(connParam,connHostInputField, ConstantProperty.CONN_FIELD_HOST,
								connParam.getHost(), testScenario, connParamFromExcel.getValidationMessage(), true);
						entervalueInTextFieldWithValidation(connParam,connPortInputField, ConstantProperty.CONN_FIELD_PORT,
								connParam.getPort(), testScenario, connParamFromExcel.getValidationMessage(), true);
						entervalueInTextFieldWithValidation(connParam,connDatabaseInputField,
								ConstantProperty.CONN_FIELD_DATABASE, connParam.getDatabaseName(), testScenario,
								connParamFromExcel.getValidationMessage(), true);

					}
					
					selectConnectionType(connectionType);
					
					WebElement n = driver.findElement(By.xpath("//input[@id='keytab']"));

					n.sendKeys(UserKeytabLocation);

					BaseSuite.validationReportLog("User key tab File Choosed successfully");

					validatAndeEnterValueToTextField(connUserPrincipalLabel, connHiveUserPrincipal,ConstantProperty.CONN_FIELD_USERPRINCIPAL, connPrincipalPlaceholder,
							connParam.getUserPrincipal(), validationUserprincipal);
						
						saveConnection();
					
						captureToastMsgForConnection(driver, toastMsg, popUpClose, connectionTestMess,
								"Connection Test", false);
				}
			
				}else
				{

					clickOnUserConnectionTab();

					flag = searchAndClickOnConnectionNameInConnRepo(connectionName);

					if (flag) {
						
						WebElement n = driver.findElement(By.xpath("//input[@id='keytab']"));

						n.sendKeys(UserKeytabLocation);

						BaseSuite.validationReportLog("User key tab File Choosed successfully");

						validatAndeEnterValueToTextField(connUserPrincipalLabel, connHiveUserPrincipal,ConstantProperty.CONN_FIELD_USERPRINCIPAL, connPrincipalPlaceholder,
								connParam.getUserPrincipal(), validationUserprincipal);

					}

					status = saveConnection();

					if (status) {
						
						inVisible(driver, spinner,50);

						clickOnButton(driver, connTestBtn, "Test", true);

						inVisible(driver, spinner, 30);

						flag = captureToastMsgForConnection(driver, toastMsg, popUpClose, connectionTestMess,
								"Connection Test", true);
					}
				}
			}
			 else {
					validateAndEnterUsernameAndPasswordForGrant(connJsonEntity,flag, connParam.getUsername(),icedqUser,
							connParamFromExcel.getValidationMessage(), testScenario);
				}

		} catch (Exception e) {

			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" Database connection not tested properly kindly check :" + e.toString());
		}
		return flag;
	}
	
	
	
	public boolean enterUserPrincipalAndKeytabForKerberosInvalid(String connJsonEntity,String connectionType, String newConnectionName, ConnectionPoJO connParam,
			ConnectionPoJO connParamFromExcel, String testScenario, String icedqUser) {
		String UserKeytabLocation =System.getProperty("user.dir")+ Constant.USER_KEYTAB_LOCATION;
		boolean flag = false;
		try {
			
			if (!connectionType.equalsIgnoreCase("user")) {

				WebElement n = driver.findElement(By.xpath("//input[@id='keytab']"));

				n.sendKeys(UserKeytabLocation);

				BaseSuite.validationReportLog("User key tab File Choosed successfully");

				validatAndeEnterValueToTextField(connUserPrincipalLabel, connHiveUserPrincipal,ConstantProperty.CONN_FIELD_USERPRINCIPAL, connPrincipalPlaceholder,
						connParam.getUserPrincipal(), validationUserprincipal);
			} else {

				validateInputFieldVisibility(connHiveUserPrincipal, ConstantProperty.CONN_USERPRINCIPAL, "",false);

				isEnabled(driver, connUserKeytab);

				BaseSuite.validationReportLog("User key tab Field is Disabled");

				isEnabled(driver, chooseFileBtn);

				BaseSuite.validationReportLog("Choose File button is Disabled");

			}

			if (connectionType.equalsIgnoreCase("user")) {
				
				 if (isEnabled(driver, connSaveBtn)&& (icedqUser.toLowerCase().contains("owner"))) {
					 saveConnection();
				} else {
					waitForExecution(2000);
					saveConnection(forbiddenToastMsg);
					click(driver, discardButtonsDetails);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver,discardButtons);
					}
				}   
				 clickOnUserConnectionTab();
				 waitForExecution(2000);
				flag = searchAndClickOnConnectionNameInConnRepo(newConnectionName);
				waitForExecution(2000);
				if (flag) {
					WebElement n = driver.findElement(By.xpath("//input[@id='keytab']"));

					n.sendKeys(UserKeytabLocation);

					BaseSuite.validationReportLog("User key tab File Choosed successfully");

					validatAndeEnterValueToTextField(connUserPrincipalLabel, connHiveUserPrincipal,ConstantProperty.CONN_FIELD_USERPRINCIPAL, connPrincipalPlaceholder,
							connParam.getUserPrincipal(), validationUserprincipal);
					}
				}
			
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Error Observed kindly check :: " + e.toString());
			Thread.currentThread().interrupt();
		}

		return flag;
	}

	

	/** create Athena connection method **/

	public boolean createAthenaConnection(String connJsonEntity, String testScenario, String validationMessage,
			String icedqUser) {
		boolean flag = true;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		String newconnectionName = null;
		LoginPage lp = new LoginPage(driver);
 
		try {
			if (isDisplayed(driver, userName) && isDisplayed(driver, passWord)) {
 
				flag = lp.loginWithIcedqUserAndSelectWorkspace(icedqUser, ConstantProperty.TARGET_WORKSPACE_NAME,
						ConstantProperty.CONNECTIONREPOMODULENAME, "");
 
			}
			if (flag) {
 
				ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);
 
				newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
						+ ConstantProperty.TARGET_WORKSPACE_NAME;
 
				String authName = setAuthenticationType(connParam.getAuthentication());
 
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
 
				flag = clickOnNewConnectionBtn(icedqUser);
 
				if (flag) {
 
					chooseConnectorType(connParam.getConnectorID());
 
					inVisible(driver, spinner, Constant.ruleWait);

					String wizardStatus = validateNewConnPageButtonsFields(connParam.getConnectorID());

					if (wizardStatus.contains("Wizard supported connector")) {

						verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", false);
					}

					verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);
 
					verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);
 
					verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);
 
					verifyVisibilityOfButtons(driver, connDeleteButton, "Delete Button", false);
 
					verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", false);
 
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
 
					enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);
 
					selectDriverOfFlatFileNativeConnection(connParam.getDriverName());
 
					selectAuthenticationOfConnection(authName);
 
					boolean cs = selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());
 
					enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());
 
					if (cs) {
 
						driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
 
						validateInputFieldVisibility(connAthenaS3LocationField,
								ConstantProperty.CONN_FIELD_S3OUTPUTLOCATION, connAthenaS3LocationPlaceholder, false);
 
						validateInputFieldVisibility(connAthenaRegionField, ConstantProperty.CONN_FIELD_REGION,
								regionPlaceHolder, false);
 
					} else {
						validatAndeEnterValueToTextField(connAthenaS3LocationTitle, connAthenaS3LocationField,
								ConstantProperty.CONN_FIELD_S3OUTPUTLOCATION, connAthenaS3LocationPlaceholder,
								connParam.getLocationname(), validationS3OutputLocationEmpty);
 
						validatAndeEnterValueToTextField(connAthenaRegionLabel, connAthenaRegionField,
								ConstantProperty.CONN_FIELD_REGION, regionPlaceHolder, connParam.getRegionValue(),
								regionEmptyValidationMsg);
 
					}
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
 
					selectConnectionType(chooseConnType, connParam.getType());
 
					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {
 
						entersecretPasswordAthena(connJsonEntity, connParam.getAuthenticationname(),
								connParam.getConnectorID(), icedqUser);
 
					} else {
 
						validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", false);
 
						validateInputFieldVisibility(connFlatFileAccesskeyField, ConstantProperty.CONN_FIELD_ACCESSKEY,
								"", false);
 
						validateInputFieldVisibility(connFlatFileSecretkeyField, ConstantProperty.CONN_FIELD_SECRETKEY,
								"", false);
					}
				}
 
				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);
 
				int count = connPropertyList.size();
 
				addConnectionPropertiesToConnection(connJsonEntity, count);
 
				if (icedqUser.toLowerCase().contains("owner")) {
 
					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {
 
						flag = saveConnection(connectionSaveMesssage);
 
						clickOnConnectionsTab();
 
						cp.searchConnection(newconnectionName);
 
						getConnection(newconnectionName, update_actualValue);
 
						searchAndClickOnConnectionNameInConnRepo(newconnectionName);
 
						waitForExecution(1000);
 
						flag = testConnection(connectionTestMess);
 
						clickOnConnectionsTab();
 
						cp.searchConnection(newconnectionName);
 
						getConnection(newconnectionName, create_actualValue);
 
						searchAndClickOnConnectionNameInConnRepo(newconnectionName);
					} else {
 
						flag = saveConnection(connectionSaveMesssage);
 
						clickOnUserConnectionTab();
 
						cp.searchConnection(newconnectionName);
 
						getConnection(newconnectionName, update_actualValue);
 
						searchAndClickOnConnectionNameInConnRepo(newconnectionName);
 
						waitForExecution(1000);
 
						if (!icedqUser.toLowerCase().contains("reader")) {
 
							entersecretPasswordAthena(connJsonEntity, connParam.getAuthenticationname(),
									connParam.getConnectorID(), icedqUser);
 
							saveConnection();
 
							flag = testConnection(connectionTestMess);
 
						}
 
						clickOnConnectionsTab();
 
						cp.searchConnection(newconnectionName);
 
						getConnection(newconnectionName, create_actualValue);
 
					}
 
				} else {
 
					flag = saveConnection(forbiddenToastMsg);
				}
 
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" Database connection not created properly kindly check :" + e.toString());
		}
		return flag;
	}

	public boolean deleteConnectionBeforeSanity() {
		boolean flag = false;
		try {
			verifyText(driver, connectionTitle, ConnectionPageTitle);

			String pageCount = getText(driver, connPaginationCount);

			String[] numbers = pageCount.replaceAll("[^0-9]", " ").trim().split("\\s+");

			int page = Integer.parseInt(numbers[0]);

			int totalPages = Integer.parseInt(numbers[1]);

			if (!isDisplayed(driver, noRecondsFound)) {

				for (page = 1; page <= totalPages; page++) {

					displayAndClick(driver, connectionMasterCheckbox);

					waitForExecution(2000);

					flag = validateListingDeleteBtn();

					if (flag) {

						displayAndClick(driver, connDeletepopDeleteBtn);

						String toastConndelete = getAttribute(driver, toastMsg, "textContent");

						if (toastConndelete.equalsIgnoreCase(connSingleDeleteToastMsg)
								|| toastConndelete.equalsIgnoreCase(connMultiDeleteToastMsg)) {

							BaseSuite.reportLog(
									"Connection or connections deleted successfully !!! and Proper message is displayed on single connection delete.");

							displayAndClick(driver, clickonRefresh);

						} else {

							BaseSuite.reportFailLog("Please check connection delete message is not correct!",
									"getAttribute");
						}
					} else {

						BaseSuite.reportFailLog(ConstantProperty.COMMON_BUTTON_DELETE + "button is disabled",
								"clickOnButton");

					}

				}

			} else {

				flag = true;
				BaseSuite.reportLog("No connections present in workspace. Go ahead!!");

			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Issue occure while deleting connections.  :" + e.toString());
		}
		return flag;
	}
	
	
	public boolean createHiveConnectionInvalidScenario(ConnectionPoJO connParamFromExcel, String testScenario,String icedqUser, String tctype, String connectionType) {
		boolean flag = true;
		String newconnectionName = null;
		boolean status = false;
		boolean status1 = false;
		String JavaTruststoreLocation = System.getProperty("user.dir") + Constant.JAVATRUST_STORE_LOCATION;
		String KerberosConfigLocation = System.getProperty("user.dir") + Constant.KERBEROS_CONFIG_LOCATION;
		String UserKeytabLocation = System.getProperty("user.dir") + Constant.USER_KEYTAB_LOCATION;
		try {
			
				ConnectionPoJO connParam = setConnectionParametersForApi(connParamFromExcel.getHiveUsernamePassword());

				newconnectionName = connParam.getConnName() ;
				
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				
				status1 = entervalueInTextFieldWithValidation(connParam,connName, "Connection Name", newconnectionName, testScenario,connParamFromExcel.getValidationMessage(), true);

				String javaTrustStore = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 23);

				flag = clickOnNewConnectionBtn(icedqUser);

				if (!tctype.isEmpty()) {

					selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

					String authName = setAuthenticationType(connParam.getAuthentication());

					selectAuthenticationOfConnection(authName);

					boolean cs = selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

					inVisible(driver, spinner, Constant.ruleWait);

					selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());
					
					switch (connParamFromExcel.getFieldName().toLowerCase().trim()) {

					case "connectionname":
						
						if (cs) {

							validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
									connHostPlaceholder, false);
							validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
									connPortPlaceholder, false);
							validateInputFieldVisibility(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
									connDatabasePlaceHolder, false);

						} else {
							validatAndeEnterValueToTextField(connHostTitle, connHostInputField,
									ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder, connParam.getHost(),
									validationHostEmpty);

							validatAndeEnterValueToTextField(connPortTitle, connPortInputField,
									ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder, connParam.getPort(),
									validationPortEmpty);

							validatAndeEnterValueToTextField(connDatabaseTitle, connDatabaseInputField,
									ConstantProperty.CONN_FIELD_DATABASE, connDatabasePlaceHolder,
									connParam.getDatabaseName(), validationDatabaseEmpty);
						}

					if (!connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD))

					{
						WebElement m = driver.findElement(By.xpath("//input[@id='krbFile']"));

						m.sendKeys(KerberosConfigLocation);

						BaseSuite.validationReportLog("Krb5 File Choosed successfully");

					}

					boolean ss = selectUseSSLOfConnection(connParam.getUseSSLCheckbox());

					if (ss) {

						verifyIndividualLabel(driver, javaTruststoreRadioLabel, "Java Truststore");

						// boolean radioBTNCheck = isSelected(driver, connFlatFileLocationDDBtn);

						BaseSuite.validationReportLog("Java Truststore Radio button Label visible");

						WebElement m = driver.findElement(By.xpath("//input[@id='jksFile']"));

						m.sendKeys(JavaTruststoreLocation);

						BaseSuite.validationReportLog("Java Truststore File Choosed successfully");

						enterjavaTruststorePaaword(javaTrustStore);

					}

					if (connParam.getAuthentication().equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS)) {

						validatAndeEnterValueToTextField(servicePrincipallabel, servicePrincipalfeild,ConstantProperty.CONN_SERVICECPRINCIPAL, connservicePrinciplePlaceHolder,
								connParam.getServicePrincipal(), validationServicePrincipalEmpty);
					}

				
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					selectConnectionType(chooseConnType, connParam.getType());

					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						if (connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) {

							entersecretPassword(connParamFromExcel.getHiveUsernamePassword(), connParam.getAuthenticationname(),connParam.getConnectorID(), icedqUser);

							enterUsername(connParam.getUsername());

						} else if (connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS_TICKET_CACHE)) {

							validatAndeEnterValueToTextField(connUserPrincipalLabel, connHiveUserPrincipal,ConstantProperty.CONN_FIELD_USERPRINCIPAL, connPrincipalPlaceholder,
									connParam.getUserPrincipal(), validationUserprincipal);

							validatAndeEnterValueToTextField(ticketCacheLabel, ticketCachefeild,ConstantProperty.CONN_FIELD_TICKETCACHEFEILD, connTicketCachePlaceHolder,
									connParam.getTicketCacheFileName(), connTcktCacheValidation);

						} else {
							WebElement m = driver.findElement(By.xpath("//input[@id='keytab']"));

							m.sendKeys(UserKeytabLocation);

							BaseSuite.validationReportLog("User key tab File Choosed successfully");

							validatAndeEnterValueToTextField(connUserPrincipalLabel, connHiveUserPrincipal,ConstantProperty.CONN_FIELD_USERPRINCIPAL, connPrincipalPlaceholder,
									connParam.getUserPrincipal(), validationUserprincipal);

						}

					} else {

						if (connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_USERNAMEPASSWORD)) 
						{

							validateInputFieldVisibility(connsecretUserPassword, ConstantProperty.CONN_FIELD_PASSWORD,
									"", false);

							validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "",
									false);

						} else if (connParam.getAuthenticationname().equalsIgnoreCase(ConstantProperty.AUTH_KERBEROS_TICKET_CACHE))
						{

							validateInputFieldVisibility(connHiveUserPrincipal, ConstantProperty.CONN_USERPRINCIPAL, "",
									false);

							validateInputFieldVisibility(ticketCachefeild, ConstantProperty.CONN_FIELD_TICKETCACHEFEILD,
									"", false);

						} else {

							validateInputFieldVisibility(connHiveUserPrincipal, ConstantProperty.CONN_USERPRINCIPAL, "",false);

							isEnabled(driver, connUserKeytab);

							BaseSuite.validationReportLog("User key tab Field is Disabled");

							isEnabled(driver, chooseFileBtn);

							BaseSuite.validationReportLog("Choose File button is Disabled");
						}

					}
				
					inVisible(driver, spinner, Constant.ruleWait);

					if (icedqUser.toLowerCase().contains("owner"))
					{
						String saveErrorMsg = "Connection name \'" + newconnectionName + "\' already exists.";
						status = saveConnection(saveErrorMsg);

					} else {

						status = saveConnection(forbiddenToastMsg);
					}
					
					break;
					
					case "jdbcurl":
						if ((Boolean.parseBoolean(connParam.getCustomJdbcFullUrl()))) {
							selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());
							        //entervalueInTextFieldWithValidation(connParam,connCustomJDBCTextbox, "",connParam.getCustomJDBCURLValue(), testScenario,connParamFromExcel.getValidationMessage(), true);
							 status = entervalueJdbcWithValidation(connParam,connCustomJDBCTextbox,connParam.getCustomJDBCURLValue(), "",testScenario,connParamFromExcel.getValidationMessage(), true);
						}
						break;

					case "host":
						selectCustomJDBCURLOfConnection("false");
						status = entervalueInTextFieldWithValidation(connParam,connHostInputField, ConstantProperty.CONN_FIELD_HOST,
								connParam.getHost(), testScenario, connParamFromExcel.getValidationMessage(), true);

						break;

					case "port":
						selectCustomJDBCURLOfConnection("false");
						status = entervalueInTextFieldWithValidation(connParam,connPortInputField, ConstantProperty.CONN_FIELD_PORT,
								connParam.getPort(), testScenario, connParamFromExcel.getValidationMessage(), true);

						break;
					case "database":
						selectCustomJDBCURLOfConnection("false");
						status = entervalueInTextFieldWithValidation(connParam,connDatabaseInputField,
								ConstantProperty.CONN_FIELD_DATABASE, connParam.getDatabaseName(), testScenario,
								connParamFromExcel.getValidationMessage(), true);

						break;
						
					case "javaTrustStore":
						
						verifyIndividualLabel(driver, javaTruststoreRadioLabel, "Java Truststore");

						BaseSuite.validationReportLog("Java Truststore Radio button Label visible");

						WebElement m = driver.findElement(By.xpath("//input[@id='jksFile']"));

						m.sendKeys(JavaTruststoreLocation);

						BaseSuite.validationReportLog("Java Truststore File Choosed successfully");
						
						break;
						
					case "userPrincipal":
						
						validatAndeEnterValueToTextField(connUserPrincipalLabel, connHiveUserPrincipal,ConstantProperty.CONN_FIELD_USERPRINCIPAL, connPrincipalPlaceholder,
								connParam.getUserPrincipal(), validationUserprincipal);

						break;
						
					case "userKeytab":
						WebElement n = driver.findElement(By.xpath("//input[@id='keytab']"));

						n.sendKeys(UserKeytabLocation);

						BaseSuite.validationReportLog("User key tab File Choosed successfully");

						break;
						
						
					case "ticketCacheFileName":

						validatAndeEnterValueToTextField(ticketCacheLabel, ticketCachefeild,ConstantProperty.CONN_FIELD_TICKETCACHEFEILD, connTicketCachePlaceHolder,
								connParam.getTicketCacheFileName(), connTcktCacheValidation);
						break;
					
					case "propertyname":
					case "propertyvalue":
						ArrayList<String> connPropertyList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(connParamFromExcel.getKerberosCreate(), connConnectionPropNames);

						int count = connPropertyList.size();

						status = addConnectionPropertiesToConnection1(connParamFromExcel.getKerberosCreate(), count,testScenario, connParamFromExcel.getFieldName());

						clickOnOverviewTab();

						break;

					default:
						BaseSuite.reportErrorLog(
								"Field name is not found kindly check :: " + connParamFromExcel.getFieldName());
						break;
					}
							}
				else if (status1) {
					status = true;

				}

				if (status || status1) {
					flag = true;
				} else {
					flag = false;
				}

			}
			catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog(" Hive connection not created properly kindly check :" + e.toString());
		}
		return flag;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
