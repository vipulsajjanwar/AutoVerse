package nexgen.automation.framework.administration;

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

public class CustomFieldsServicePage extends PageUtil {

	WebDriver driver;

	public CustomFieldsServicePage(WebDriver driver) {
		this.driver = driver;
	}

	protected static final Logger log = Logger.getLogger(CustomFieldsServicePage.class);
	static String dirPath=System.getProperty("user.dir");

	public final String customFieldEXCELFILEPATH = BaseSuite.dirPath+ Constant.NEXTGEN_CUSTOMFIELD_TESTDATA_EXCEL_PATH;
	public static final String CUSTOMFIELDPRIVILEGEFORBIDDENMESSAGE=prop.getProperty("workflow.toast.forbidden.Message");

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
	By accountSubModuleTab=getElementLocator(prop.getProperty("account.submodule.tab"));
	By nextgenSubModuleLibraries=getElementLocator(prop.getProperty("nextgenmodule.submodule.libraries"));
	By nextgenSubModuleConfigurations=getElementLocator(prop.getProperty("nextgenmodule.submodule.configurations"));
	By nextgenSubModuleSecurity=getElementLocator(prop.getProperty("nextgenmodule.submodule.security"));

	By configBreadcrumbHomeLink=getElementLocator(prop.getProperty("configurations.breadcrumb.home"));
	By configBreadcrumbAdminLink=getElementLocator(prop.getProperty("configurations.breadcrumb.Admin"));
	By configBreadcrumbConfigLabel=getElementLocator(prop.getProperty("configurations.breadcrumb.config.label"));
	By configBreadcrumbConfigLink=getElementLocator(prop.getProperty("configurations.breadcrumb.config.link"));
	By configBreadcrumbFieldsLabel=getElementLocator(prop.getProperty("configurations.breadcrumb.fields.label"));
	By configBreadcrumbFieldsLink=getElementLocator(prop.getProperty("configurations.breadcrumb.fields.link"));
	By configBreadcrumbCreateNewFieldLabel=getElementLocator(prop.getProperty("configurations.breadcrumb.createnewfield.label"));

	By configPageTitle=getElementLocator(prop.getProperty("configurations.title"));

	By configAccountsTitle=getElementLocator(prop.getProperty("configurations.accounts.title"));
	By configAccountsCustomFieldIcon=getElementLocator(prop.getProperty("configurations.accounts.customfields.icon"));
	By configAccountsCustomFieldTitle=getElementLocator(prop.getProperty("configurations.accounts.customfields.title"));
	By configAccountsCustomFieldDesc=getElementLocator(prop.getProperty("configurations.accounts.customfields.desc"));
	By configAccountsCustomFormsIcon=getElementLocator(prop.getProperty("configurations.accounts.customforms.icon"));
	By configAccountsCustomFormsTitle=getElementLocator(prop.getProperty("configurations.accounts.customforms.title"));
	By configAccountsCustomFormsDesc=getElementLocator(prop.getProperty("configurations.accounts.customforms.desc"));
	By configAccountsCalendersIcon=getElementLocator(prop.getProperty("configurations.accounts.excludecalenders.icon"));
	By configAccountsCalendersTitle=getElementLocator(prop.getProperty("configurations.accounts.excludecalenders.title"));
	By configAccountsCalendersDesc=getElementLocator(prop.getProperty("configurations.accounts.excludecalenders.desc"));

	By configWorkspacesTitle=getElementLocator(prop.getProperty("configurations.workspaces.title"));
	By configWorkspacePreferencesTitle=getElementLocator(prop.getProperty("configurations.workspaces.preferences.title"));
	By configWorkspacePreferencesDesc=getElementLocator(prop.getProperty("configurations.workspaces.preferences.desc"));
	By configWorkspacePreferencesIcon=getElementLocator(prop.getProperty("configurations.workspaces.preferences.icon"));

	By configFieldsListingTitle=getElementLocator(prop.getProperty("configurations.fields.listing.title"));
	By configFieldsListingSearchBar=getElementLocator(prop.getProperty("configurations.fields.listing.search.bar"));
	By configFieldsListingSearchIcon=getElementLocator(prop.getProperty("configurations.fields.listing.search.icon"));
	By configFieldsListingSearchClear=getElementLocator(prop.getProperty("configurations.fields.listing.search.clear"));

	By configFieldsListingButtonNewField=getElementLocator(prop.getProperty("configurations.fields.listing.button.newfield"));
	By configFieldsListingButtonRefresh=getElementLocator(prop.getProperty("configurations.fields.listing.button.refresh"));
	By configFieldsListingButtonDelete=getElementLocator(prop.getProperty("configurations.fields.listing.button.delete"));
	By configFieldsListingButtonCount=getElementLocator(prop.getProperty("configurations.fields.listing.button.count"));

	By configFieldsListingMasterCheckbox=getElementLocator(prop.getProperty("configurations.fields.listing.master.checkbox"));
	By configFieldsListingColumnName=getElementLocator(prop.getProperty("configurations.fields.listing.column.name"));
	By configFieldsListingColumnDescription=getElementLocator(prop.getProperty("configurations.fields.listing.column.description"));
	By configFieldsListingColumnAccount=getElementLocator(prop.getProperty("configurations.fields.listing.column.account"));
	By configFieldsListingColumnType=getElementLocator(prop.getProperty("configurations.fields.listing.column.type"));
	By configFieldsListingColumnLastUpdated=getElementLocator(prop.getProperty("configurations.fields.listing.column.lastupdated"));

	By configFieldsListingNoRecordsToDisplay=getElementLocator(prop.getProperty("configurations.fields.listing.norecordstodisplay"));
	By configFieldsListingStaticCheckbox=getElementLocator(prop.getProperty("configurations.fields.listing.static.checkbox"));
	By configFieldsListingStaticAvatar=getElementLocator(prop.getProperty("configurations.fields.listing.static.avatar"));
	By configFieldsListingStaticAllName=getElementLocator(prop.getProperty("configurations.fields.listing.static.allname"));
	By configFieldsListingStaticName=getElementLocator(prop.getProperty("configurations.fields.listing.static.name"));
	By configFieldsListingStaticDescription=getElementLocator(prop.getProperty("configurations.fields.listing.static.description"));
	By configFieldsListingStaticAllDescription=getElementLocator(prop.getProperty("configurations.fields.listing.static.alldescription"));
	By configFieldsListingStaticAccount=getElementLocator(prop.getProperty("configurations.fields.listing.static.account"));
	By configFieldsListingStaticType=getElementLocator(prop.getProperty("configurations.fields.listing.static.type"));
	By configFieldsListingStaticLastUpdatedBy=getElementLocator(prop.getProperty("configurations.fields.listing.static.lastupdatedby"));
	By configFieldsListingStaticLastUpdatedDate=getElementLocator(prop.getProperty("configurations.fields.listing.static.lastupdateddate"));

	By configFieldsListingPaginationBar=getElementLocator(prop.getProperty("configurations.fields.listing.pagination.bar"));
	By configFieldsListingPaginationInfo=getElementLocator(prop.getProperty("configurations.fields.listing.pagination.info"));
	By configFieldsListingNextPageArrow=getElementLocator(prop.getProperty("configurations.fields.listing.pagination.nextarrow"));

	By configFieldsDetailsAccountTitle=getElementLocator(prop.getProperty("configurations.fields.details.accounts.title"));
	By configFieldsDetailsAccountField=getElementLocator(prop.getProperty("configurations.fields.details.accounts.field"));
	By configFieldsDetailsAccountDD=getElementLocator(prop.getProperty("configurations.fields.details.accounts.fielddd"));
	By configFieldsDetailsFieldNameTitle=getElementLocator(prop.getProperty("configurations.fields.details.fieldname.title"));
	By configFieldsDetailsFieldNameField=getElementLocator(prop.getProperty("configurations.fields.details.fieldname.field"));
	By configFieldsDetailsFieldNameValidation=getElementLocator(prop.getProperty("configurations.fields.details.fieldname.validation"));
	By configFieldsDetailsDisplayNameTitle=getElementLocator(prop.getProperty("configurations.fields.details.displayname.title"));
	By configFieldsDetailsDisplayNameField=getElementLocator(prop.getProperty("configurations.fields.details.displayname.field"));
	By configFieldsDetailsDisplayNameValidation=getElementLocator(prop.getProperty("configurations.fields.details.displayname.validation"));
	By configFieldsDetailsFieldTypeTitle=getElementLocator(prop.getProperty("configurations.fields.details.fieldtype.title"));
	By configFieldsDetailsFieldTypeField=getElementLocator(prop.getProperty("configurations.fields.details.fieldtype.field"));
	By configFieldsDetailsFieldTypeFieldDD=getElementLocator(prop.getProperty("configurations.fields.details.fieldtype.fieldDropdown"));

	By configFieldsDetailsDescriptionTitle=getElementLocator(prop.getProperty("configurations.fields.details.description.title"));
	By configFieldsDetailsDescriptionField=getElementLocator(prop.getProperty("configurations.fields.details.description.field"));
	By configFieldsDetailsDescriptionValidation=getElementLocator(prop.getProperty("configurations.fields.details.description.validation"));

	By configFieldsDetailsButtonSave=getElementLocator(prop.getProperty("configurations.fields.details.button.save"));
	By configFieldsDetailsButtonDiscard=getElementLocator(prop.getProperty("configurations.fields.details.button.discard"));
	By configFieldsDetailsButtonDelete=getElementLocator(prop.getProperty("configurations.fields.details.button.delete"));
	By configFieldsDetailsButtonCount=getElementLocator(prop.getProperty("configurations.fields.details.button.count"));

	By configFieldsDetailsDiscardPoupupTitle=getElementLocator(prop.getProperty("configurations.fields.details.popup.discard.title"));
	By configFieldsDetailsDiscardPoupupContent=getElementLocator(prop.getProperty("configurations.fields.details.popup.discard.content"));
	By configFieldsDetailsDiscardPoupupDiscardButton=getElementLocator(prop.getProperty("configurations.fields.details.popup.discard.discardbutton"));
	By configFieldsDetailsDiscardPoupupCancelButton=getElementLocator(prop.getProperty("configurations.fields.details.popup.discard.cancelbutton"));

	By configFieldsDetailsDeletePoupupTitle=getElementLocator(prop.getProperty("configurations.fields.details.popup.delete.title"));
	By configFieldsDetailsDeletePoupupContent=getElementLocator(prop.getProperty("configurations.fields.details.popup.delete.content"));
	By configFieldsDetailsDeletePoupupDeleteButton=getElementLocator(prop.getProperty("configurations.fields.details.popup.delete.deletebutton"));
	By configFieldsDetailsDeletePoupupCancelButton=getElementLocator(prop.getProperty("configurations.fields.details.popup.delete.cancelbutton"));

	By configFieldDetailsValuesTab=getElementLocator(prop.getProperty("configurations.fields.details.values.tab"));
	By configFieldDetailsValuesTabButtonAdd=getElementLocator(prop.getProperty("configurations.fields.details.values.tab.button.add"));
	By configFieldDetailsValuesTabButtonRefresh=getElementLocator(prop.getProperty("configurations.fields.details.values.tab.button.refresh"));
	By configFieldDetailsValuesTabButtonDelete=getElementLocator(prop.getProperty("configurations.fields.details.values.tab.button.delete"));

	By configFieldDetailsValuesSearchbar=getElementLocator(prop.getProperty("configurations.fields.details.values.tab.search.bar"));
	By configFieldDetailsValuesSearchIcon=getElementLocator(prop.getProperty("configurations.fields.details.values.tab.search.icon"));
	By configFieldDetailsValuesSearchClear=getElementLocator(prop.getProperty("configurations.fields.details.values.tab.search.clear"));

	By configFieldDetailsValuesTabMasterCheckbox=getElementLocator(prop.getProperty("configurations.fields.details.values.tab.master.checkbox"));
	By configFieldDetailsValuesTabColumnValue=getElementLocator(prop.getProperty("configurations.fields.details.values.tab.column.value"));
	By configFieldDetailsValuesTabColumnDefault=getElementLocator(prop.getProperty("configurations.fields.details.values.tab.column.default"));
	By configFieldDetailsValuesTabColumnDescription=getElementLocator(prop.getProperty("configurations.fields.details.values.tab.column.description"));
	By configFieldDetailsValuesTabColumnAction=getElementLocator(prop.getProperty("configurations.fields.details.values.tab.column.action"));
	By configFieldDetailsValuesTabColumnHiddenValue=getElementLocator(prop.getProperty("configurations.fields.details.values.tab.column.hiddenvalue"));

	By configFieldDetailsValuesTabFieldInputValue=getElementLocator(prop.getProperty("configurations.fields.details.values.tab.field.value"));
	By configFieldDetailsValuesTabFieldInputHiddenvalue=getElementLocator(prop.getProperty("configurations.fields.details.values.tab.field.hiddenvalue"));
	By configFieldDetailsValuesTabFieldInputdefaultCheckbox=getElementLocator(prop.getProperty("configurations.fields.details.values.tab.field.checkbox.default"));
	By configFieldDetailsValuesTabFieldInputDescription=getElementLocator(prop.getProperty("configurations.fields.details.values.tab.field.description"));

	By configFieldDetailsValuesTabValueSaveButton=getElementLocator(prop.getProperty("configurations.fields.details.values.tab.button.save"));
	By configFieldDetailsValuesTabValueCancelButton=getElementLocator(prop.getProperty("configurations.fields.details.values.tab.button.cancel"));
	By configFieldDetailsValuesTabValueEditButton=getElementLocator(prop.getProperty("configurations.fields.details.values.tab.button.edit"));
	By configFieldDetailsValuesTabValueDeleteButton=getElementLocator(prop.getProperty("configurations.fields.details.values.tab.button.vdelete"));


	/** ----------------------  String variables ---------------------------------- **/

	String moduleTab=prop.getProperty("nextgen.hamberger.tab");
	String subModuleTab=prop.getProperty("nextgenmodule.submodule.tab");
	String subModuleHeadingName=prop.getProperty("nextgenmodule.submodule.headingDynamic");
	String dynamicName=prop.getProperty("DynName");
	String nextgenSubModuleDynamic=prop.getProperty("nextgenmodule.submodule.dynamic");


	String configBreadcrumbDynamicFieldNameLabel=prop.getProperty("configurations.breadcrumb.dynamicname.label");
	String configBreadcrumbDynamicFieldIdLabel=prop.getProperty("configurations.breadcrumb.dynamicnameid.label");
	String configFieldsListingDynamicCheckbox=prop.getProperty("configurations.fields.listing.dynamic.checkbox");
	String configFieldsListingDynamicAvatar=prop.getProperty("configurations.fields.listing.dynamic.avatar");
	String configFieldsListingDynamicName=prop.getProperty("configurations.fields.listing.dynamic.name");
	String configFieldsListingDynamicDescription=prop.getProperty("configurations.fields.listing.dynamic.description");
	String configFieldsListingDynamicAccount=prop.getProperty("configurations.fields.listing.dynamic.account");
	String configFieldsListingDynamicType=prop.getProperty("configurations.fields.listing.dynamic.type");
	String configFieldsListingDynamicLastUpdatedBy=prop.getProperty("configurations.fields.listing.dynamic.lastupdatedby");
	String configFieldsListingDynamicLastUpdatedDate=prop.getProperty("configurations.fields.listing.dynamic.lastupdateddate");
	String configFieldsDetailsDynamicTitle=prop.getProperty("configurations.fields.details.dynamic.title");
	String configFieldsDetailsDynamicAvatar=prop.getProperty("configurations.fields.details.dynamic.avatar");
	String configFieldsDetailsFieldTypeSelect=prop.getProperty("configurations.fields.details.fieldtype.select");

	String configFieldsDetailsValueTabDynamicValue=prop.getProperty("configurations.fields.details.values.tab.dynamic.value");
	String configFieldsDetailsValueTabDynamicHiddenValue=prop.getProperty("configurations.fields.details.values.tab.dynamic.hiddenvalue");
	String configFieldsDetailsValueTabDynamicDescription=prop.getProperty("configurations.fields.details.values.tab.dynamic.description");
	String configFieldsDetailsValueTabDynamicDefaultCheckbox=prop.getProperty("configurations.fields.details.values.tab.dynamic.default");

	String configFieldsDetailsValueTabviewValue=prop.getProperty("configurations.fields.details.values.tab.view.value");
	String configFieldsDetailsValueTabviewHiddenValue=prop.getProperty("configurations.fields.details.values.tab.view.hiddenvalue");
	String configFieldsDetailsValueTabviewDescription=prop.getProperty("configurations.fields.details.values.tab.view.description");
	String configFieldsDetailsValueTabviewDefaultCheckbox=prop.getProperty("configurations.fields.details.values.tab.view.default");

	String configFieldsDetailsValueTabviewCheckbox=prop.getProperty("configurations.fields.details.values.tab.view.checkbox");

	String configFieldsDetailsValueTabviewEditButton=prop.getProperty("configurations.fields.details.values.tab.view.edit");

	String configFieldsDetailsValueTabDynamicEditButton=prop.getProperty("configurations.fields.details.values.tab.dynamic.edit");
	String configFieldsDetailsValueTabDynamicSaveButton=prop.getProperty("configurations.fields.details.values.tab.dynamic.save");
	String configFieldsDetailsValueTabDynamicCancelButton=prop.getProperty("configurations.fields.details.values.tab.dynamic.cancel");
	
	String configFieldsDetailsAccountSelect=prop.getProperty("configurations.fields.details.accounts.select");
	
	String configFieldsAdvanceSearchAccountSelectDynamic=prop.getProperty("configurations.fields.listing.advancesearch.accountselect");

	String placeholderSearchField=prop.getProperty("placeholderSearchField");
	String placeholderAccountField=prop.getProperty("placeholderAccountField");
	String placeholderFieldName=prop.getProperty("placeholderFieldName");
	String placeholderDisplayName=prop.getProperty("placeholderDisplayName");
	String placeholderFieldType=prop.getProperty("placeholderFieldType");
	String placeholderDescription=prop.getProperty("placeholderDescription");
	String placeholderSearchValue=prop.getProperty("placeholderSearchValue");

	String popupDiscardFieldTitle=prop.getProperty("popupDiscardFieldTitle");
	String popupDiscardFieldContext=prop.getProperty("popupDiscardFieldContext");
	String popupDeleteFieldTitle=prop.getProperty("popupDeleteFieldTitle");
	String popupDeleteFieldContext=prop.getProperty("popupDeleteFieldContext");
	String popupDeleteMultipleFieldsTitle=prop.getProperty("popupDeleteMultipleFieldsTitle");
	String popupDeleteMultipleFieldsContext=prop.getProperty("popupDeleteMultipleFieldsContext");
	String popupDeleteSingleFieldTitle=prop.getProperty("popupDeleteSingleFieldTitle");
	String popupDeleteSingleFieldContext=prop.getProperty("popupDeleteSingleFieldContext");
	String popupDeleteMultipleFieldTitle=prop.getProperty("popupDeleteMultipleFieldTitle");
	String popupDeleteMultipleFieldContext=prop.getProperty("popupDeleteMultipleFieldContext");

	String toastMessageSaveField=prop.getProperty("toastMessageSaveField");
	String toastMessageDeleteField=prop.getProperty("toastMessageDeleteField");
	String toastMessageDeleteCustomField=prop.getProperty("toastMessageDeleteCustomField");
	String toastMessageDeleteCustomFields=prop.getProperty("toastMessageDeleteCustomFields");

	String fieldValidationFieldNameEmpty=prop.getProperty("fieldValidationFieldNameEmpty");
	String fieldValidationdDisplayNameEmpty=prop.getProperty("fieldValidationdDisplayNameEmpty");

	String customFieldDescText=prop.getProperty("customfields.desc");
	String customFormsDescText=prop.getProperty("customforms.desc");
	String excludeCalendarsDescText=prop.getProperty("excludecalendars.desc");
	String preferencesDescText=prop.getProperty("preferences.desc");

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
	String configurationsContent="Configurations";
	String createNewFieldContent="Create New Field";
	String moduleContent=prop.getProperty("String.moduleContent");
	String subModuleContent=prop.getProperty("String.subModuleContent");
	String columnContent=prop.getProperty("String.columnContent");
	String tabContent=prop.getProperty("String.tabContent");
	String iconContent=prop.getProperty("String.iconContent");
	String newFieldContent="New Field";
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
	String customFieldsContent="Custom Fields";
	String customFormsContent="Custom Forms";
	String excludeCalendersContent="Exclude Calendars";
	String preferencesContent="Preferences";
	String accountContent="Account";
	String fieldNameContent="Field Name";
	String displayNameContent="Display Name";
	String fieldtypeContent="Field type";
	String fieldsContent="Fields";
	String valueContent="value ";
	String singleSelectMapContent="SingleSelectMap";
	String isVisibleContent=" is visible";

	/** ---------------------- Methods  ---------------------------------- **/



	public static DataTestingParameters setCustomFieldServiceParamUsingExcel(String filePath, String sheetName, int rowNumber, boolean useSuffix) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String fn="";
		String dn="";
		String udn="";
		try {
			if(useSuffix) {

				fn=System.getProperty("fieldNameSuffix");
				dn=System.getProperty("displayNameSuffix");
				udn=System.getProperty("updateDisplayNameSuffix");
			}

			param.setTestScenarioName(xl.readUsingColName(filePath,sheetName, rowNumber, "testScenario"));
			param.setScenarioType(xl.readUsingColName(filePath,sheetName, rowNumber, "scenarioType"));
			param.setExecutionstate(xl.readUsingColName(filePath,sheetName, rowNumber, "execute"));
			param.setFieldName(xl.readUsingColName(filePath,sheetName, rowNumber, "fieldName")+fn);
			param.setFieldDescription(xl.readUsingColName(filePath,sheetName, rowNumber, "description"));
			param.setFieldType(xl.readUsingColName(filePath,sheetName, rowNumber, "type"));
			param.setFieldDisplayName(xl.readUsingColName(filePath,sheetName, rowNumber, "displayName")+dn);
			param.setFieldAccountName(xl.readUsingColName(filePath,sheetName, rowNumber, "accountName"));
			param.setFieldValue(xl.readUsingColName(filePath,sheetName, rowNumber, "fieldValue"));
			param.setFieldValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber, "fieldMessage"));
			param.setToastValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber, "toastMessage"));
			param.setUpdateFieldDisplayName(xl.readUsingColName(filePath,sheetName, rowNumber, "updatedisplayName")+udn);
			param.setUpdateFieldDescription(xl.readUsingColName(filePath,sheetName, rowNumber, "updatedescription"));
			param.setType(xl.readUsingColName(filePath,sheetName, rowNumber, "ftype"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setCustomFieldServiceParamUsingExcel "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setCustomFieldValuesParamUsingExcel(String filePath, String fieldValue, boolean suffix) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String sheetName="values";
		String refcolumn="key";
		String vn="";
		String uvn="";
		try {

			if(suffix) {
				vn=System.getProperty("valueNameSuffix");
				uvn=System.getProperty("updatevalueNameSuffix");
			}

			param.setFieldValue(xl.readUsingColNameAndCellContains(filePath, sheetName, refcolumn, fieldValue,"InputValue")+vn);
			param.setFieldValueDescription(xl.readUsingColNameAndCellContains(filePath, sheetName, refcolumn, fieldValue,"InputValueDescription"));
			param.setFieldValueDefaultFlag(xl.readUsingColNameAndCellContains(filePath, sheetName, refcolumn, fieldValue,"InputValueDefault"));
			param.setFieldHiddenValue(xl.readUsingColNameAndCellContains(filePath, sheetName, refcolumn, fieldValue,"InputHiddenValue"));

			param.setUpdateFieldValue(xl.readUsingColNameAndCellContains(filePath, sheetName, refcolumn, fieldValue,"UpdateValue")+uvn);
			param.setUpdateFieldValueDescription(xl.readUsingColNameAndCellContains(filePath, sheetName, refcolumn, fieldValue,"UpdateValueDescription"));
			param.setUpdateFieldValueDefaultFlag(xl.readUsingColNameAndCellContains(filePath, sheetName, refcolumn, fieldValue,"UpdateValueDefault"));
			param.setUpdateFieldHiddenValue(xl.readUsingColNameAndCellContains(filePath, sheetName, refcolumn, fieldValue,"UpdateHiddenValue"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setCustomFieldValuesParamUsingExcel "+e.toString());
		}
		return param;

	}


	public boolean clickOnRefreshOnCustomFieldsListingPage() {

		return clickOnButton(driver, configFieldsListingButtonRefresh, refreshContent, true);
	}

	public boolean clickOnRefreshOnCustomFieldsListingPageWithValidation() {
		boolean flag=true;

		try {
			clickOnButton(driver, configFieldsListingButtonRefresh, refreshContent, true);

			waitForExecution(100);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, toastMsg)) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
						"Custom fields tab refresh authorization message");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnRefreshOnCustomFieldsListingPageWithValidation :: "+e.toString());
		}

		return flag;
	}


	public boolean clickOnConfigurationTab() {

		boolean flag = false;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, configPageTitle);

			if(elementNotVisible(driver, configPageTitle)) {

				isDisplayedInLoop(driver, 2, nextgenSubModuleConfigurations);

				if(isDisplayed(driver, nextgenSubModuleConfigurations)) {

					flag = isClickable(driver, nextgenSubModuleConfigurations, configurationsContent+" tab", true);

					if(flag) {

						BaseSuite.reportLog("Clicking on "+configurationsContent+" tab");

						displayAndClick(driver, nextgenSubModuleConfigurations);

						handleDiscardWindow(driver, configFieldsDetailsDiscardPoupupDiscardButton, discardContent);

						BaseSuite.validationReportLog("Clicked on "+configurationsContent+" tab");

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

						flag=validateElement(driver, configPageTitle, configurationsContent, attributeTitle);
					}

				}else {
					BaseSuite.reportFailLog(configurationsContent+" tab not visible", "clickOnConfigurationTab");
				}
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnConfigurationTab :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean clickOnConfigurationTab(String expectedToastMessage) {

		boolean flag = false;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, configPageTitle);

			if(elementNotVisible(driver, configPageTitle)) {

				isDisplayedInLoop(driver, 2, nextgenSubModuleConfigurations);

				if(isDisplayed(driver, nextgenSubModuleConfigurations)) {

					flag = isClickable(driver, nextgenSubModuleConfigurations, configurationsContent+" tab", true);

					if(flag) {

						BaseSuite.reportLog("Clicking on "+configurationsContent+" tab");

						displayAndClick(driver, nextgenSubModuleConfigurations);

						/**handleDiscardWindow();**/
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.validationReportLog("Clicked on "+nextgenSubModuleConfigurations+" tab");

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

						captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,
								configurationsContent+" tab authorization message");

						validateElement(driver, configPageTitle, configurationsContent, attributeTitle);

					}

				}else {
					BaseSuite.reportFailLog(configurationsContent+" tab not visible", "clickOnConfigurationTab");
				}
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnConfigurationTab :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean validateConfigurationTab() {

		boolean flag = false;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateElement(driver, configAccountsTitle, accountsContent, labelContent);

			validateElement(driver, configAccountsCustomFieldIcon, customFieldsContent, iconContent);

			validateElement(driver, configAccountsCustomFieldTitle, customFieldsContent, attributeTitle);

			checkExpectedValueWithActual(driver, flag, configAccountsCustomFieldDesc, customFieldsContent, customFieldDescText, true, attributeTextContent);

			validateElement(driver, configAccountsCustomFormsIcon, customFormsContent, iconContent);

			validateElement(driver, configAccountsCustomFormsTitle, customFieldsContent, attributeTitle);

			checkExpectedValueWithActual(driver, flag, configAccountsCustomFormsDesc, customFieldsContent, customFormsDescText, true, attributeTextContent);

			validateElement(driver, configAccountsCalendersIcon, excludeCalendersContent, iconContent);

			validateElement(driver, configAccountsCalendersTitle, excludeCalendersContent, attributeTitle);

			checkExpectedValueWithActual(driver, flag, configAccountsCalendersDesc, excludeCalendersContent, excludeCalendarsDescText, true, attributeTextContent);

			validateElement(driver, configWorkspacesTitle, workspacesContent, labelContent);

			validateElement(driver, configWorkspacePreferencesIcon, preferencesContent, iconContent);

			validateElement(driver, configWorkspacePreferencesTitle, preferencesContent, attributeTitle);

			checkExpectedValueWithActual(driver, flag, configWorkspacePreferencesDesc, preferencesContent, preferencesDescText, true, attributeTextContent);

		}catch(Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" validateConfigurationTab :: "+e.toString());
			flag=false;

		}

		return flag;

	}

	public boolean clickOnCustomFieldsTab() {

		boolean flag = false;

	    try {
	        isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
	        isDisplayedInLoop(driver, 0, configFieldsListingTitle);

	        if (!isDisplayed(driver, configFieldsListingTitle)) {
	            flag = handleCustomFieldsTabNavigation();
	        }
	        
	        selectAccountFromAdvanceSearchFilter(getAccountName(""));
	        
	    } catch (Exception e) {
	        BaseSuite.reportErrorLog(errorLogTitle + " clickOnCustomFieldsTab :: " + e.toString());
	        flag = false;
	    }

	    return flag;

	}

	private boolean handleCustomFieldsTabNavigation() {
	    boolean flag = false;

	    if (isDisplayed(driver, configAccountsCustomFieldTitle)) {
	        flag = clickOnButton(driver, configAccountsCustomFieldTitle, customFieldsContent, true);
	    } else if (isDisplayed(driver, configBreadcrumbFieldsLink)) {
	        flag = clickOnButton(driver, configBreadcrumbFieldsLink, customFieldsContent, true);
	    }

	    if (flag) {
	        handleDiscardWindow(driver, configFieldsDetailsDiscardPoupupDiscardButton, discardContent);
	        isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
	        isDisplayedInLoop(driver, 0, configFieldsListingButtonNewField);

	        if (isDisplayed(driver, configFieldsListingButtonNewField)) {
	            flag = validateElement(driver, configFieldsListingTitle, fieldsContent, attributeTitle);
	            
	            selectAccountFromAdvanceSearchFilter(getAccountName(""));
	        }
	    }

	    return flag;
	}
	
	public boolean selectAccountFromAdvanceSearchFilter(String accountName) {
		
		boolean flag = true;
		
		try {
			By locator = returnElement(configFieldsAdvanceSearchAccountSelectDynamic, dynamicName, accountName);
			
			if(isDisplayed(driver, locator)) {
				
				clickOnButton(driver, locator, accountName, true);
				
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		} catch (Exception e) {
			  BaseSuite.reportErrorLog(errorLogTitle + " selectAccountFromAdvanceSearchFilter :: " + e.toString());
		        flag = false;
		}
		
		return flag;
	}

	public boolean validateCustomFieldsListingPage() {

		boolean flag = true;
		HomePage hp=new HomePage(driver);

		try {

			hp.validateNextgenIcedqModuleAndAdministrationSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Custom Fields listing page "+hyphenContent);

			validateElement(driver,configBreadcrumbHomeLink, homeContent, hyperlinkContent);

			validateElement(driver,configBreadcrumbAdminLink, administrationContent, hyperlinkContent);

			validateElement(driver,configBreadcrumbConfigLink, configurationsContent, labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying Title and Search field Custom Fields listing page "+hyphenContent);

			verifyIndividualLabel(driver, configFieldsListingTitle, workspacesContent);

			verifySearchField(driver, configFieldsListingSearchBar, placeholderSearchField, placeholderSearchField);

			validateElement(driver,configFieldsListingSearchIcon, placeholderSearchField, iconContent);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Custom Fields listing page "+hyphenContent);

			validateButtons(driver, configFieldsListingButtonCount, 3);

			verifyVisibilityOfButtons(driver, configFieldsListingButtonNewField, "New Field", true);
			verifyVisibilityOfButtons(driver, configFieldsListingButtonRefresh, refreshContent, true);
			verifyVisibilityOfButtons(driver, configFieldsListingButtonDelete, deleteContent, false);

			BaseSuite.reportLog(hyphenContent+"  Verifying Columns on Custom Fields listing page "+hyphenContent);

			validateElement(driver, configFieldsListingMasterCheckbox, "Master", checkboxContent);
			validateElement(driver,configFieldsListingColumnName, "Name",columnContent);
			validateElement(driver,configFieldsListingColumnDescription, descriptionContent, columnContent);
			validateElement(driver,configFieldsListingColumnAccount, accountsContent, columnContent);
			validateElement(driver,configFieldsListingColumnType, typeContent, columnContent);
			validateElement(driver,configFieldsListingColumnLastUpdated, "Last Updated", columnContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on Custom Fields listing page "+hyphenContent);

			getPaginationDetails(driver,configFieldsListingPaginationInfo, configFieldsListingPaginationBar,configFieldsListingNoRecordsToDisplay, "Custom Fields listing page");

			BaseSuite.validationReportLog(hyphenContent+" Custom Fields listing page validated successfully "+hyphenContent);

		}catch(Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" validateCustomFieldsListingPage :: "+e.toString());
			flag=false;

		}

		return flag;

	}

	public boolean clickOnNewFieldButton(String icedqUser) {

		boolean flag = true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 3, configFieldsListingButtonNewField);

			if(isDisplayed(driver, configFieldsListingButtonNewField)) {

				clickOnButton(driver, configFieldsListingButtonNewField, newFieldContent, flag);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

					String pgTitle=getAttribute(driver, returnElement(configFieldsDetailsDynamicTitle, dynamicName, createNewFieldContent), attributeTextContent);

					flag = stringOutput(pgTitle.trim(), createNewFieldContent, true);

				}else{

					flag = captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
							"New Field authorization message");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnNewFieldButton :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateCustomFieldsDetailPageBeforeCreating(String accountName) {
		boolean flag = true;
		HomePage hp=new HomePage(driver);
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			hp.validateNextgenIcedqModuleAndAdministrationSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Custom Field details page "+hyphenContent);

			validateElement(driver,configBreadcrumbHomeLink, homeContent, hyperlinkContent);

			validateElement(driver,configBreadcrumbAdminLink, administrationContent, hyperlinkContent);

			validateElement(driver,configBreadcrumbConfigLink, configurationsContent, hyperlinkContent);

			validateElement(driver,configBreadcrumbFieldsLink, fieldsContent, hyperlinkContent);

			validateElement(driver,configBreadcrumbCreateNewFieldLabel, createNewFieldContent, labelContent);

			validateElement(driver,returnElement(configFieldsDetailsDynamicTitle, dynamicName, createNewFieldContent), createNewFieldContent, attributeTitle);

			validateElement(driver,returnElement(configFieldsDetailsDynamicAvatar, dynamicName, createNewFieldContent), "Field", iconContent);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Custom Field details page "+hyphenContent);

			validateButtons(driver, configFieldsDetailsButtonCount, 3);

			verifyVisibilityOfButtons(driver, configFieldsDetailsButtonSave, saveContent, false);
			verifyVisibilityOfButtons(driver, configFieldsDetailsButtonDiscard, discardContent, false);	
			verifyVisibilityOfButtons(driver, configFieldsDetailsButtonDelete, deleteContent, false);

			validateElement(driver, configFieldsDetailsAccountTitle, accountContent, labelContent);
			validateElement(driver, configFieldsDetailsAccountField, accountContent, fieldContent);
			verifyPlaceHolderValue(driver, configFieldsDetailsAccountField, accountContent, placeholderAccountField);

			viewAndValidateField(driver, configFieldsDetailsAccountField, accountContent, IS_MULTI_TENENT_ACCOUNT ? "" : accountName, IS_MULTI_TENENT_ACCOUNT);

			validateElement(driver, configFieldsDetailsFieldNameTitle, fieldNameContent, labelContent);
			validateElement(driver, configFieldsDetailsFieldNameField, fieldNameContent, fieldContent);
			verifyPlaceHolderValue(driver, configFieldsDetailsFieldNameField, fieldNameContent, placeholderFieldName);

			validateElement(driver, configFieldsDetailsDisplayNameTitle, displayNameContent, labelContent);
			validateElement(driver, configFieldsDetailsDisplayNameField, displayNameContent, fieldContent);
			verifyPlaceHolderValue(driver, configFieldsDetailsDisplayNameField, displayNameContent, placeholderDisplayName);

			validateElement(driver, configFieldsDetailsFieldTypeTitle, fieldtypeContent, labelContent);
			validateElement(driver, configFieldsDetailsFieldTypeField, fieldtypeContent, fieldContent);
			verifyPlaceHolderValue(driver, configFieldsDetailsFieldTypeField, fieldtypeContent, placeholderFieldType);

			validateElement(driver, configFieldsDetailsDescriptionTitle, descriptionContent, labelContent);
			validateElement(driver, configFieldsDetailsDescriptionField, descriptionContent, fieldContent);
			verifyPlaceHolderValue(driver, configFieldsDetailsDescriptionField, descriptionContent, placeholderDescription);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateCustomFieldsDetailPageBeforeCreating :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateCustomFieldsDetailPageExistingField(String accountName, String fieldName, String displayName, String fieldType, String description) {
		boolean flag = true;
		HomePage hp=new HomePage(driver);
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			hp.validateNextgenIcedqModuleAndAdministrationSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Custom Field details page "+hyphenContent);

			validateElement(driver,configBreadcrumbHomeLink, homeContent, hyperlinkContent);

			validateElement(driver,configBreadcrumbAdminLink, administrationContent, hyperlinkContent);

			validateElement(driver,configBreadcrumbConfigLink, configurationsContent, hyperlinkContent);

			validateElement(driver,configBreadcrumbFieldsLink, fieldsContent, hyperlinkContent);

			validateElement(driver,returnElement(configBreadcrumbDynamicFieldNameLabel, dynamicName, displayName), displayName, labelContent);

			//validateElement(driver,returnElement(configBreadcrumbDynamicFieldIdLabel, dynamicName, displayName), displayName, labelContent);

			validateElement(driver,returnElement(configFieldsDetailsDynamicTitle, dynamicName, displayName), displayName, attributeTitle);

			validateElement(driver,returnElement(configFieldsDetailsDynamicAvatar, dynamicName, displayName), "Field", iconContent);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Custom Field details page "+hyphenContent);

			validateButtons(driver, configFieldsDetailsButtonCount, 3);

			verifyVisibilityOfButtons(driver, configFieldsDetailsButtonSave, saveContent, false);
			verifyVisibilityOfButtons(driver, configFieldsDetailsButtonDiscard, discardContent, false);	
			verifyVisibilityOfButtons(driver, configFieldsDetailsButtonDelete, deleteContent, true);

			validateElement(driver, configFieldsDetailsAccountTitle, accountContent, labelContent);
			validateElement(driver, configFieldsDetailsAccountField, accountContent, fieldContent);
			verifyPlaceHolderValue(driver, configFieldsDetailsAccountField, accountContent, placeholderAccountField);

			viewAndValidateField(driver, configFieldsDetailsAccountField, accountContent, accountName, false);

			validateElement(driver, configFieldsDetailsFieldNameTitle, fieldNameContent, labelContent);
			validateElement(driver, configFieldsDetailsFieldNameField, fieldNameContent, fieldContent);
			verifyPlaceHolderValue(driver, configFieldsDetailsFieldNameField, fieldNameContent, placeholderFieldName);
			viewAndValidateField(driver, configFieldsDetailsFieldNameField, fieldNameContent, fieldName, false);

			validateElement(driver, configFieldsDetailsDisplayNameTitle, displayNameContent, labelContent);
			validateElement(driver, configFieldsDetailsDisplayNameField, displayNameContent, fieldContent);
			verifyPlaceHolderValue(driver, configFieldsDetailsDisplayNameField, displayNameContent, placeholderDisplayName);
			viewAndValidateField(driver, configFieldsDetailsDisplayNameField, displayNameContent, displayName, true);

			validateElement(driver, configFieldsDetailsFieldTypeTitle, fieldtypeContent, labelContent);
			validateElement(driver, configFieldsDetailsFieldTypeField, fieldtypeContent, fieldContent);
			verifyPlaceHolderValue(driver, configFieldsDetailsFieldTypeField, fieldtypeContent, placeholderFieldType);
			viewAndValidateField(driver, configFieldsDetailsFieldTypeField, fieldtypeContent, fieldType, false);

			validateElement(driver, configFieldsDetailsDescriptionTitle, descriptionContent, labelContent);
			validateElement(driver, configFieldsDetailsDescriptionField, descriptionContent, fieldContent);
			verifyPlaceHolderValue(driver, configFieldsDetailsDescriptionField, descriptionContent, placeholderDescription);
			viewAndValidateField(driver, configFieldsDetailsDescriptionField, descriptionContent, description, true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateCustomFieldsDetailPageExistingField :: "+e.toString());
			flag=false;
		}
		return flag;
	}
	
	public boolean clickOnSaveButtonAndValidateToast(String expectedToastMessage) {
		boolean tag =true;
		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, configFieldsDetailsButtonSave, saveContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Field Created");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Field Created");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnSaveButtonAndValidateToast :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean clickOnDeleteValuesFromFields(boolean flag, int num, String expectedToastMessage) {
		boolean tag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(1000);
			
			String title = (num == 1) ? popupDeleteSingleFieldTitle : popupDeleteMultipleFieldTitle;
		    String context = (num == 1) ? popupDeleteSingleFieldContext : popupDeleteMultipleFieldContext;

		    validatePopupWindowContent(driver, flag, configFieldsDetailsDeletePoupupTitle, configFieldsDetailsDeletePoupupContent, title, context);
		    
			verifyVisibilityOfButtons(driver, configFieldsDetailsDeletePoupupDeleteButton, deleteContent, true);
			verifyVisibilityOfButtons(driver, configFieldsDetailsDeletePoupupCancelButton, cancelButtonContent, true);

			clickOnButton(driver, configFieldsDetailsDeletePoupupDeleteButton, deleteContent, tag);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, deleteContent);
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty() || isDisplayed(driver, toastMsg)) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,deleteContent);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnDeleteValuesFromFields :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnDeleteFieldsFromListingPage(boolean flag, int num, String expectedToastMessage) {
		boolean tag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(1000);

		    String title = (num == 1) ? popupDeleteFieldTitle : popupDeleteMultipleFieldsTitle;
		    String context = (num == 1) ? popupDeleteFieldContext : popupDeleteMultipleFieldsContext;
		   
		    validatePopupWindowContent(driver, flag, configFieldsDetailsDeletePoupupTitle, configFieldsDetailsDeletePoupupContent, title, context);
		    
			verifyVisibilityOfButtons(driver, configFieldsDetailsDeletePoupupDeleteButton, deleteContent, true);
			verifyVisibilityOfButtons(driver, configFieldsDetailsDeletePoupupCancelButton, cancelButtonContent, true);

			clickOnButton(driver, configFieldsDetailsDeletePoupupDeleteButton, deleteContent, tag);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, deleteContent);
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,deleteContent);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnDeleteFieldsFromListingPage :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnDiscardFieldButtonAndValidateToast(String expectedToastMessage) {
		boolean tag =true;
		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, configFieldsDetailsButtonDiscard, discardContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validatePopupWindowContent(driver, flag, configFieldsDetailsDiscardPoupupTitle, configFieldsDetailsDiscardPoupupContent, popupDiscardFieldTitle, popupDiscardFieldContext);

			verifyVisibilityOfButtons(driver, configFieldsDetailsDiscardPoupupDiscardButton, discardContent, true);
			verifyVisibilityOfButtons(driver, configFieldsDetailsDiscardPoupupCancelButton, cancelButtonContent, true);

			clickOnButton(driver, configFieldsDetailsDiscardPoupupDiscardButton, discardContent, tag);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, fieldContent+" "+discardContent);
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,fieldContent+" "+discardContent);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnDiscardFieldButtonAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnDeleteFieldButtonAndValidateToast(String expectedToastMessage, String icedqUser) {
		boolean tag =true;
		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, configFieldsDetailsButtonDelete, deleteContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

				validatePopupWindowContent(driver, flag, configFieldsDetailsDeletePoupupTitle, configFieldsDetailsDeletePoupupContent, popupDeleteFieldTitle, popupDeleteFieldContext);

				verifyVisibilityOfButtons(driver, configFieldsDetailsDeletePoupupDeleteButton, deleteContent, true);
				verifyVisibilityOfButtons(driver, configFieldsDetailsDeletePoupupCancelButton, cancelButtonContent, true);

				clickOnButton(driver, configFieldsDetailsDeletePoupupDeleteButton, deleteContent, tag);

			}

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, fieldContent+" "+deleteContent);
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,fieldContent+" "+deleteContent);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnDeleteFieldButtonAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}
	
	
	public boolean selectCustomFieldType(String fieldType) {
	    
		boolean flag = true;

	    try {
	        isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

	        if (elementNotVisible(driver, configFieldsDetailsFieldTypeTitle)) {
	            BaseSuite.reportFailLog("Field type title not visible", ":selectCustomFieldType");
	            return false;
	        }

	        BaseSuite.reportLog("Checking for Field type label visibility");
	        BaseSuite.validationReportLog("Field type label is visible");
	        javascript(driver, scrollToElementArg, configFieldsDetailsFieldTypeTitle);

	        if (elementNotVisible(driver, configFieldsDetailsFieldTypeField)) {
	            BaseSuite.reportFailLog("Field type field not visible", ":selectCustomFieldType");
	            return false;
	        }

	        BaseSuite.reportLog("Field type dropdown is visible. Clicking on it.");
	        BaseSuite.validationReportLog("Field type dropdown field is visible");
	        displayAndClick(driver, configFieldsDetailsFieldTypeFieldDD);

	        isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

	        if (!isFieldTypeVisible(fieldType)) {
	            BaseSuite.reportFailLog(fieldtypeContent+" " + fieldType + " not visible in dropdown list", "selectCustomFieldType");
	            return false;
	        }

	        clickOnFieldType(fieldType);

	    } catch (Exception e) {
	        BaseSuite.reportErrorLog(errorLogTitle + " selectCustomFieldType :: " + e.toString());
	        flag = false;
	    }

	    return flag;
	}
	

	private boolean isFieldTypeVisible(String fieldType) {
	    BaseSuite.reportLog("Checking for Field type " + fieldType + " visibility");

	    return isDisplayed(driver, returnElement(configFieldsDetailsFieldTypeSelect, dynamicName, fieldType));
	}

	private void clickOnFieldType(String fieldType) {
	    BaseSuite.reportLog("Clicking on Field type " + fieldType);
	    BaseSuite.validationReportLog(fieldtypeContent+" " + fieldType + isVisibleContent);
	    javascript(driver, scrollToElementArg, returnElement(configFieldsDetailsFieldTypeSelect, dynamicName, fieldType));
	    displayAndClick(driver, returnElement(configFieldsDetailsFieldTypeSelect, dynamicName, fieldType));
	    BaseSuite.validationReportLog("Clicked on Field type " + fieldType);
	}
	
	public boolean seleteCustomFieldType(String fieldType) {

		boolean flag=true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog("Checking for Field type label is visible or not");

			isDisplayedInLoop(driver, 0, configFieldsDetailsFieldTypeTitle);

			if(isDisplayed(driver, configFieldsDetailsFieldTypeTitle)) {

				BaseSuite.validationReportLog("Field type label is visible ");

				javascript(driver, scrollToElementArg, configFieldsDetailsFieldTypeTitle);

				BaseSuite.reportLog("Checking for Field type dropdown field is visible or not");

				if(isDisplayed(driver, configFieldsDetailsFieldTypeField)) {

					BaseSuite.validationReportLog("Field type drowdown field is visible ");

					BaseSuite.reportLog("Clicking on Field type drowdown field ");

					displayAndClick(driver, configFieldsDetailsFieldTypeFieldDD);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					BaseSuite.validationReportLog("Clicked on Field type drowdown field ");

					BaseSuite.reportLog("Checking for Field type "+fieldType+" is visible or not");

					if(isDisplayed(driver,  returnElement(configFieldsDetailsFieldTypeSelect, dynamicName, fieldType))) {

						BaseSuite.validationReportLog("Field type "+fieldType+isVisibleContent);

						javascript(driver, scrollToElementArg, returnElement(configFieldsDetailsFieldTypeSelect, dynamicName, fieldType));

						BaseSuite.reportLog("Clicking on Field type "+fieldType);

						displayAndClick(driver, returnElement(configFieldsDetailsFieldTypeSelect, dynamicName, fieldType));

						BaseSuite.validationReportLog("Clicked on Field type "+fieldType);

					}else {
						BaseSuite.reportFailLog("Field type not visible in dropdown list", "seleteCustomFieldType");
						flag=false;					
					}

				}else {
					BaseSuite.reportFailLog("Field type field not visible", ":seleteCustomFieldType");
					flag=false;	
				}
			}else {
				BaseSuite.reportFailLog("Field type title not visible", ":seleteCustomFieldType");
				flag=false;	
			}


		}catch(Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" seleteCustomFieldType :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public void selectAccountOnWorkspaceDetailsPage(String accountName, boolean ismultipleAccount) {

		try {

			if(ismultipleAccount) {
				isDisplayedInLoop(driver, 2, configFieldsDetailsAccountDD);
				
				displayAndClick(driver, configFieldsDetailsAccountDD);

				waitForExecution(1000);

				/**sendKeys(driver, workspaceDetailsAccountSelectSearch, accountName);*/

				BaseSuite.reportLog("Searching for account name : "+accountName);

				isDisplayedInLoop(driver, 2, returnElement(configFieldsDetailsAccountSelect, dynamicName, accountName));

				if(isDisplayed(driver, returnElement(configFieldsDetailsAccountSelect, dynamicName, accountName))) {

					BaseSuite.reportLog("Selecting account name : "+accountName);

					displayAndClick(driver, returnElement(configFieldsDetailsAccountSelect, dynamicName, accountName));

					BaseSuite.validationReportLog("Account is selected");

					String getAcc=getAttribute(driver, configFieldsDetailsAccountField, attributeValue);

					stringOutput(getAcc.trim(), accountName, true);

				}else {
					BaseSuite.reportFailLog("Account is not visible", "selectAccountOnWorkspaceDetailsPage");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" selectAccountOnWorkspaceDetailsPage :: "+e.toString());
		}
	}

	public boolean createCustomFieldForValidConditions(DataTestingParameters param, String icedqUser, boolean suffix) {

		boolean flag=true;
		final boolean uiTag=false;
		try {

			flag= clickOnNewFieldButton(icedqUser);

			if(flag && (icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER))) {

				if(uiTag) {validateCustomFieldsDetailPageBeforeCreating(param.getFieldAccountName());}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				
				selectAccountOnWorkspaceDetailsPage(param.getFieldAccountName(), IS_MULTI_TENENT_ACCOUNT);

				validatAndeEnterValueToTextField(driver, configFieldsDetailsFieldNameTitle, configFieldsDetailsFieldNameField, configFieldsDetailsFieldNameValidation, 
						fieldNameContent, placeholderFieldName, param.getFieldName(), fieldValidationFieldNameEmpty);

				validatAndeEnterValueToTextField(driver, configFieldsDetailsDisplayNameTitle, configFieldsDetailsDisplayNameField, configFieldsDetailsDisplayNameValidation, 
						displayNameContent, placeholderDisplayName, param.getFieldDisplayName(), fieldValidationdDisplayNameEmpty);

				seleteCustomFieldType(param.getFieldType());

				validatAndeEnterValueToTextField(driver, configFieldsDetailsDescriptionTitle, configFieldsDetailsDescriptionField, configFieldsDetailsDescriptionValidation, 
						descriptionContent, placeholderDescription, param.getFieldDescription(), "");


				validateAndAddValuesToFields(param, true, suffix);

				flag=clickOnSaveButtonAndValidateToast(toastMessageSaveField);

				clickOnCustomFieldsTab();

				if(flag) {

					flag=validateFieldOnListingPage(param, false);
				}

			}

		}catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" createCustomFieldForValidConditions :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateFieldOnListingPage(DataTestingParameters param, boolean updated) {

		boolean flag=true;
		String displayName="";
		String description="";
		try {

			displayName = updated ? param.getUpdateFieldDisplayName() : param.getFieldDisplayName();
			description = updated ? param.getUpdateFieldDescription() : param.getFieldDescription();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=searchFunctionalityMethod(driver, flag, configFieldsListingSearchBar, configFieldsListingSearchIcon, placeholderSearchField, placeholderSearchField,  displayName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {

				validateElement(driver, returnElement(configFieldsListingDynamicCheckbox, dynamicName, displayName), displayNameContent, checkboxContent);

				validateElement(driver, returnElement(configFieldsListingDynamicAvatar, dynamicName, displayName), displayNameContent, iconContent);

				validateValueWithActual(driver, returnElement(configFieldsListingDynamicName, dynamicName, displayName), displayNameContent, displayName, attributeTextContent);

				validateValueWithActual(driver, returnElement(configFieldsListingDynamicDescription, dynamicName, displayName), descriptionContent, description, attributeTextContent);

				validateValueWithActual(driver, returnElement(configFieldsListingDynamicAccount, dynamicName, displayName), accountContent, param.getFieldAccountName(), attributeTextContent);

				validateValueWithActual(driver, returnElement(configFieldsListingDynamicType, dynamicName, displayName), fieldtypeContent, param.getType(), attributeTextContent);

				String lastUpdated=getAttribute(driver,  returnElement(configFieldsListingDynamicLastUpdatedDate, dynamicName, displayName), attributeTextContent);

				if(!lastUpdated.isEmpty()) {
					BaseSuite.reportLog("Custom field last updated on :: "+lastUpdated);
				}else {
					BaseSuite.reportFailLog("Custom field last updated time not visible", "validateFieldOnListingPage");
				}

				String updatedBy=getAttribute(driver, returnElement(configFieldsListingDynamicLastUpdatedBy, dynamicName, displayName), attributeTitle);

				if(!updatedBy.isEmpty()) {
					BaseSuite.reportLog("Custom field last updated by :: "+updatedBy);
				}else {
					BaseSuite.reportFailLog("Custom field last updated by not visible", "validateFieldOnListingPage");
				}			
			}

		}catch (Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" validateFieldOnListingPage :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateFieldValuesTab(String fieldType, boolean refresh) {

		boolean flag=true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 0, configFieldDetailsValuesTab);

			validateElement(driver, configFieldDetailsValuesTab, "Values", tabContent);

			verifySearchField(driver, configFieldDetailsValuesSearchbar, placeholderSearchValue, placeholderSearchValue);

			verifyVisibilityOfButtons(driver, configFieldDetailsValuesTabButtonAdd, "Add", !fieldType.trim().equalsIgnoreCase("toggle"));

			verifyVisibilityOfButtons(driver, configFieldDetailsValuesTabButtonRefresh, refreshContent, refresh);
			verifyVisibilityOfButtons(driver, configFieldDetailsValuesTabButtonDelete, deleteContent, false);

			validateElement(driver, configFieldDetailsValuesTabMasterCheckbox, "Master", checkboxContent);
			validateElement(driver,configFieldDetailsValuesTabColumnValue, "Value",columnContent);
			validateElement(driver,configFieldDetailsValuesTabColumnDefault, "Default", columnContent);
			validateElement(driver,configFieldDetailsValuesTabColumnDescription, descriptionContent, columnContent);
			validateElement(driver,configFieldDetailsValuesTabColumnAction, "Action", columnContent);

			if(fieldType.trim().equalsIgnoreCase(singleSelectMapContent)) {
				validateElement(driver,configFieldDetailsValuesTabColumnHiddenValue, "Hidden Value",columnContent);
			}

		}catch (Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" validateFieldValuesTab :: "+e.toString());
			flag=false;
		}

		return flag;
	}


	public boolean clickOnAddValueButton() {
	    try {
	        isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
	        isDisplayedInLoop(driver, 0, configFieldDetailsValuesTab);

	        if (elementNotVisible(driver, configFieldDetailsValuesTabButtonAdd)) {
	            BaseSuite.reportFailLog("Add Value button not visible", "clickOnAddValueButton");
	            return false;
	        }

	        return clickOnButton(driver, configFieldDetailsValuesTabButtonAdd, "Add", true);

	    } catch (Exception e) {
	        BaseSuite.reportErrorLog(errorLogTitle + " clickOnAddValueButton :: " + e.toString());
	        return false;
	    }
	}


	public boolean addValuesToField(DataTestingParameters param, String fieldType) {
	    try {
	        // Click on Add Value Button and return early if it fails
	        if (!clickOnAddValueButton()) {
	            return false;
	        }

	        // Enter the main field value
	        enterValueToTextField(driver, configFieldDetailsValuesTabFieldInputValue, valueContent + fieldContent, param.getFieldValue());

	        // If the field type is SingleSelectMapContent and hidden value is provided, enter it
	        if (!param.getFieldHiddenValue().isEmpty() && fieldType.trim().equalsIgnoreCase(singleSelectMapContent)) {
	            enterValueToTextField(driver, configFieldDetailsValuesTabFieldInputHiddenvalue,
	                    "Hidden value " + fieldContent, param.getFieldHiddenValue());
	        }

	        // Enter the field description
	        enterValueToTextField(driver, configFieldDetailsValuesTabFieldInputDescription,
	                descriptionContent + " " + fieldContent, param.getFieldValueDescription());

	        // Set the default flag if required
	        if (Boolean.parseBoolean(param.getFieldValueDefaultFlag())) {
	            selectcheckbox(driver, configFieldDetailsValuesTabFieldInputdefaultCheckbox, "Default");
	        }

	        // Verify visibility of cancel button and click save button
	        verifyVisibilityOfButtons(driver, configFieldDetailsValuesTabValueCancelButton, cancelButtonContent, true);
	        return clickOnButton(driver, configFieldDetailsValuesTabValueSaveButton, "Right arrow", true);

	    } catch (Exception e) {
	        BaseSuite.reportErrorLog(errorLogTitle + " addValuesToField :: " + e.toString());
	        return false;
	    }
	}

	public boolean addValuesToField(String fieldValues, String fieldType, boolean suffix) {
		String[] fieldValue=null;
		boolean flag=true;
		try {

			if (!fieldValues.isEmpty()) {
				flag= clickOnAddValueButton();

				if (fieldValues.contains(",")) {

					fieldValue = fieldValues.split(",");

					for (int i = 0; i < fieldValue.length; i++) {

						DataTestingParameters vparam = setCustomFieldValuesParamUsingExcel(customFieldEXCELFILEPATH, fieldValue[i],suffix);

						BaseSuite.reportLog(hyphenContent + "  Adding " + (i + 1) + "   value :: "+ vparam.getFieldValue()+ " " + hyphenContent);

						flag=addValuesToField(vparam, fieldType);

					}

				} else {

					DataTestingParameters vparam = setCustomFieldValuesParamUsingExcel(customFieldEXCELFILEPATH, fieldValues,suffix);

					BaseSuite.reportLog(hyphenContent + "  Adding " + (1) + "  value  :: "+ vparam.getFieldValue()+ " " + hyphenContent);

					flag=addValuesToField(vparam, fieldType);
				}	
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" addValuesToField "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean deleteValuesToField(DataTestingParameters param) {


		boolean flag=true;

		try {

			flag= searchFunctionalityMethod(driver, flag, configFieldDetailsValuesSearchbar, configFieldDetailsValuesSearchIcon, placeholderSearchValue, placeholderSearchValue,  param.getFieldValue());

			if (flag) {

				viewAndValidateField(driver, returnElement(configFieldsDetailsValueTabviewValue, dynamicName, param.getFieldValue()), valueContent + fieldContent, param.getFieldValue(), true);

				if(isDisplayed(driver, returnElement(configFieldsDetailsValueTabviewCheckbox, dynamicName, param.getFieldValue()))) {

					selectcheckbox(driver, returnElement(configFieldsDetailsValueTabviewCheckbox, dynamicName, param.getFieldValue()), param.getFieldValue()+" "+checkboxContent);
				}

			}

		}catch (Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" deleteValuesToField :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validatedeletedValuesToField(String fieldValueName, boolean scenario) {


		boolean flag=true;

		try {
			if(scenario) {
				
				flag= searchFunctionalityMethod(driver, flag, configFieldDetailsValuesSearchbar, configFieldDetailsValuesSearchIcon, placeholderSearchValue, placeholderSearchValue,  fieldValueName);

				if (flag && elementNotVisible(driver, returnElement(configFieldsDetailsValueTabviewValue, dynamicName, fieldValueName))) {

					BaseSuite.validationReportLog(fieldValueName+" : Field Values not visible on values tab.");

				}else if(isDisplayed(driver, returnElement(configFieldsDetailsValueTabviewValue, dynamicName, fieldValueName))) {

					BaseSuite.reportFailLog(fieldValueName+" : Field value is visible on values tab", "validatedeletedValuesToField");
				}
			}
		}catch (Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" validatedeletedValuesToField :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean deleteValuesFromFieldForMultiple(boolean flag, boolean scenario) {

		if(scenario) {

			flag=clickOnButton(driver, configFieldDetailsValuesTabButtonDelete, deleteContent+" "+valueContent, true);

			flag=clickOnDeleteValuesFromFields(flag, 1, "");

		}
		return flag;
	}


	public boolean deleteValuesToField(String fieldValues, String scenario, boolean suffix) {
		String[] fieldValue=null;
		boolean flag=true;
		String stype="multiple";
		int x =0;
		try {

			if (!fieldValues.isEmpty()) {

				if (fieldValues.contains(",")) {

					fieldValue = fieldValues.split(",");

					for (int i = 0; i < fieldValue.length; i++) {

						DataTestingParameters vparam = setCustomFieldValuesParamUsingExcel(customFieldEXCELFILEPATH, fieldValue[i],suffix);

						BaseSuite.reportLog(hyphenContent + "  deleting  " + (i + 1) + "  value :: "+ vparam.getFieldValue()+ " " + hyphenContent);

						flag=deleteValuesToField(vparam);
						x++;

						flag=deleteValuesFromFieldForMultiple(flag, scenario.equalsIgnoreCase(stype));
						
						validatedeletedValuesToField(vparam.getFieldValue(), scenario.equalsIgnoreCase(stype));

					}

				} else {

					DataTestingParameters vparam = setCustomFieldValuesParamUsingExcel(customFieldEXCELFILEPATH, fieldValues,suffix);

					BaseSuite.reportLog(hyphenContent + "  deleting  " + (1) + " value  :: "+ vparam.getFieldValue()+ " " + hyphenContent);

					flag=deleteValuesToField(vparam);
					x++;
				}

				if(x>0 && !scenario.equalsIgnoreCase(stype)) {

					flag=clickOnButton(driver, configFieldDetailsValuesTabButtonDelete, deleteContent+" "+valueContent, true);

					flag=clickOnDeleteValuesFromFields(flag, x, "");
				}else {
					BaseSuite.reportLog("No values found to delete from fields");
				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" deleteValuesToField "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validatedeleteValuesToField(String fieldValues, boolean suffix) {
		String[] fieldValue=null;
		boolean flag=true;

		try {

			if (!fieldValues.isEmpty()) {

				if (fieldValues.contains(",")) {

					fieldValue = fieldValues.split(",");

					for (int i = 0; i < fieldValue.length; i++) {

						DataTestingParameters vparam = setCustomFieldValuesParamUsingExcel(customFieldEXCELFILEPATH, fieldValue[i],suffix);

						BaseSuite.reportLog(hyphenContent + " validate deleted " + (i + 1) + "  value :: "+ vparam.getFieldValue()+ " " + hyphenContent);

						flag=validatedeletedValuesToField(vparam.getFieldValue(), true);

					}

				} else {

					DataTestingParameters vparam = setCustomFieldValuesParamUsingExcel(customFieldEXCELFILEPATH, fieldValues,suffix);

					BaseSuite.reportLog(hyphenContent + " validate deleted " + (1) + " value  :: "+ vparam.getFieldValue()+ " " + hyphenContent);

					flag=validatedeletedValuesToField(vparam.getFieldValue(), true);

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validatedeleteValuesToField "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean checkboxStatus(By locator, String label, boolean expectedState) {
		boolean flag=true;

		try {

			isDisplayedInLoop(driver, 0, locator);

			if(isDisplayed(driver, locator)) {

				BaseSuite.reportLog("validating "+label+" checkbox status");

				String actual = getAttribute(driver, locator, attributeClass);

				if(expectedState) {

					BaseSuite.reportLog("Expected checkbox status is checked");

					if(actual.contains(attrcheck)) {

						BaseSuite.validationReportLog(label+" checkbox is checked as expected");

					}else {

						BaseSuite.reportFailLog(label+" checkbox is unchecked kindly check", "checkboxStatus");
						flag=false;
					}
				}else {

					BaseSuite.reportLog("Expected checkbox status is unchecked");

					if(!actual.contains(attrcheck)) {

						BaseSuite.validationReportLog(label+" checkbox is unchecked as expected");

					}else {

						BaseSuite.reportFailLog(label+" checkbox is checked kindly check", "checkboxStatus");
						flag=false;
					}
				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" checkboxStatus "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean viewValuesToField(DataTestingParameters param, String fieldType) {


		boolean flag=true;

		try {

			flag= searchFunctionalityMethod(driver, flag, configFieldDetailsValuesSearchbar, configFieldDetailsValuesSearchIcon, placeholderSearchValue, placeholderSearchValue,  param.getFieldValue());

			if (flag) {

				viewAndValidateField(driver, returnElement(configFieldsDetailsValueTabviewValue, dynamicName, param.getFieldValue()), valueContent + fieldContent, param.getFieldValue(), true);

				if (!param.getFieldHiddenValue().isEmpty() && (fieldType.trim().equalsIgnoreCase(singleSelectMapContent))) {

					viewAndValidateField(driver, returnElement(configFieldsDetailsValueTabviewHiddenValue, dynamicName, param.getFieldValue()), "Hidden value " + fieldContent, param.getFieldHiddenValue(), true);

				}

				checkboxStatus(returnElement(configFieldsDetailsValueTabviewDefaultCheckbox, dynamicName, param.getFieldValue()), "Default flag", Boolean.parseBoolean(param.getFieldValueDefaultFlag()));

				viewAndValidateField(driver, returnElement(configFieldsDetailsValueTabviewDescription, dynamicName, param.getFieldValue()), descriptionContent+" " + fieldContent, param.getFieldValueDescription(), true);

				verifyVisibilityOfButtons(driver, returnElement(configFieldsDetailsValueTabviewEditButton, dynamicName, param.getFieldValue()), "Edit", true);

			}

			displayAndClick(driver, configFieldDetailsValuesSearchbar);
			waitForExecution(500);
			displayAndClick(driver, configFieldDetailsValuesSearchClear);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		}catch (Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" viewValuesToField :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean viewValuesToField(String fieldValues, String fieldType, boolean suffix) {
		String[] fieldValue=null;
		boolean flag=true;
		try {

			if (!fieldValues.isEmpty()) {

				if (fieldValues.contains(",")) {

					fieldValue = fieldValues.split(",");

					for (int i = 0; i < fieldValue.length; i++) {

						DataTestingParameters vparam = setCustomFieldValuesParamUsingExcel(customFieldEXCELFILEPATH, fieldValue[i],suffix);

						BaseSuite.reportLog(hyphenContent + "  viewing " + (i + 1) + " value :: "+ vparam.getFieldValue()+ " " + hyphenContent);

						flag=viewValuesToField(vparam, fieldType);

					}

				} else {

					DataTestingParameters vparam = setCustomFieldValuesParamUsingExcel(customFieldEXCELFILEPATH, fieldValues,suffix);

					BaseSuite.reportLog(hyphenContent + "  viewing " + (1) + " value :: "+ vparam.getFieldValue()+ " " + hyphenContent);

					flag=viewValuesToField(vparam, fieldType);
				}	
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewValuesToField "+e.toString());
			flag=false;
		}
		return flag;
	}


	public boolean validateAndAddValuesToFields(DataTestingParameters param, boolean validateUi, boolean suffix) {

		boolean flag=true;

		try {

			switch(param.getFieldType().toLowerCase().trim()+1) {

			case "label1":
			case "multiselectdropdown1":
			case "singleselectdropdown1":
			case "singleselectmap1":

				if(validateUi) {validateFieldValuesTab(param.getFieldType(),false);}

				flag=addValuesToField(param.getFieldValue(), param.getFieldType(), suffix);

				break;

			default:

				break;
			}

		}catch (Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" validateAndAddValuesToFields :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean viewAndValidateAddValuesToFields(DataTestingParameters param, boolean validateUi, boolean suffix) {

		boolean flag=true;

		try {

			switch(param.getFieldType().toLowerCase().trim()) {

			case "label":
			case "multiselectdropdown":
			case "singleselectdropdown":
			case "singleselectmap":

				if(validateUi) {validateFieldValuesTab(param.getFieldType(),true);}

				viewValuesToField(param.getFieldValue(), param.getFieldType(), suffix);

				break;

			case "toggle":

				validateFieldValuesTab(param.getFieldType(),false);

				flag=viewValuesToField(param.getFieldValue(), param.getFieldType(), false);

				break;

			default:

				break;
			}

		}catch (Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" viewAndValidateAddValuesToFields :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean validateAndDeleteValuesFromFields(DataTestingParameters param, boolean validateUi, boolean suffix) {

		boolean flag=true;

		try {

			switch(param.getFieldType().toLowerCase().trim()) {

			case "label":
			case "multiselectdropdown":
			case "singleselectdropdown":
			case "singleselectmap":

				if(validateUi) {validateFieldValuesTab(param.getFieldType(),false);}

				deleteValuesToField(param.getFieldValue(), param.getScenarioType(),suffix);

				flag=validatedeleteValuesToField(param.getFieldValue(), suffix);

				break;

			default:

				break;
			}

		}catch (Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" validateAndDeleteValuesFromFields :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean searchFieldNameOnEachPageAndClickOn(By locator,String name) {

		boolean flag=false;
		boolean nextpageFlag=true;
		int pn=0;

		try {

			do {

				BaseSuite.reportLog("searching Field name : "+name+" on page number :"+(pn+1));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 0, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportLog("Field name : "+name+" found on page number :"+(pn+1));

					flag=clickOnButton(driver, locator, name, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					break;
				}
				if(isDisplayed(driver, configFieldsListingNextPageArrow)) {

					String status = getAttribute(driver, configFieldsListingNextPageArrow, attributeClass);

					if (!status.contains("disable")) {

						clickOnButton(driver, configFieldsListingNextPageArrow, "next page", true);
						pn++;
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					} else {
						BaseSuite.reportLog("Page arrow :: next page is disabled");
						nextpageFlag=false;

					}

				}

			}while(nextpageFlag);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchFieldNameOnEachPageAndClickOn :: "+e.toString());
			flag=false;
		}
		return flag;
	}
	
	public boolean searchDisplayNameOnEachPageAndClickOn(By locator,String name, boolean clickOn) {

		boolean flag=false;
		boolean nextpageFlag=true;
		int pn=0;

		try {

			do {

				BaseSuite.reportLog("searching Display name : "+name+" on page number :"+(pn+1));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 3, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportLog("Display name : "+name+" found on page number :"+(pn+1));

					if(clickOn) {
						clickOnButton(driver, locator, name, true);
					}
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					flag=true;
					break;
				}
				if(isDisplayed(driver, configFieldsListingNextPageArrow)) {

					String status = getAttribute(driver, configFieldsListingNextPageArrow, attributeClass);

					if (!status.contains("disable")) {

						clickOnButton(driver, configFieldsListingNextPageArrow, "next page", true);
						pn++;
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					} else {
						BaseSuite.reportLog("Page arrow :: next page is disabled");
						nextpageFlag=false;

					}

				}

			}while(nextpageFlag);
			
			if(!flag) {
				BaseSuite.reportLog("Searched name not visible on page : "+name);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchFieldNameOnEachPageAndClickOn :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean searchDisplayNameAndClickOnFieldName(String displayName) {
		boolean flag =true;

		try {

			searchFunctionalityMethod(driver, flag, configFieldsListingSearchBar, configFieldsListingSearchIcon, placeholderSearchField, placeholderSearchField,  displayName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(elementNotVisible(driver, configFieldsListingNoRecordsToDisplay)) {

				flag=searchFieldNameOnEachPageAndClickOn(returnElement(configFieldsListingDynamicName, dynamicName, displayName), displayName);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}else {
				flag=false;
				BaseSuite.reportFailLog(noRecordsToDisplayContent+isVisibleContent,"searchDisplayNameAndClickOnFieldName");
				searchFunctionalityMethod(driver, flag, configFieldsListingSearchBar, configFieldsListingSearchIcon, placeholderSearchField, placeholderSearchField,  "");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchDisplayNameAndClickOnFieldName "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean searchDisplayNameAndClickOnCheckbox(String displayName) {
		boolean flag =true;

		try {

			flag=searchFunctionalityMethod(driver, flag, configFieldsListingSearchBar, configFieldsListingSearchIcon, placeholderSearchField, placeholderSearchField,  displayName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && elementNotVisible(driver, configFieldsListingNoRecordsToDisplay)) {

				flag=searchFieldNameOnEachPageAndClickOn(returnElement(configFieldsListingDynamicCheckbox, dynamicName, displayName), displayName);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}else {
				flag=false;
				BaseSuite.reportFailLog(noRecordsToDisplayContent+isVisibleContent,"searchDisplayNameAndClickOnCheckbox");
				searchFunctionalityMethod(driver, flag, configFieldsListingSearchBar, configFieldsListingSearchIcon, placeholderSearchField, placeholderSearchField,  "");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchDisplayNameAndClickOnCheckbox "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean searchDisplayNameIsExistOrNot(String displayName) {
		boolean flag =true;

		try {

			flag=searchFunctionalityMethod(driver, flag, configFieldsListingSearchBar, configFieldsListingSearchIcon, placeholderSearchField, placeholderSearchField,  displayName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && elementNotVisible(driver, configFieldsListingNoRecordsToDisplay)) {

				flag=searchDisplayNameOnEachPageAndClickOn(returnElement(configFieldsListingDynamicName, dynamicName, displayName), displayName, false);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}else {
				
				BaseSuite.reportLog(noRecordsToDisplayContent+isVisibleContent);
				flag=false;
			}
			
			
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchDisplayNameIsExistOrNot "+e.toString());
			flag=false;
		}

		return flag;
	}
	

	public boolean viewAndValidateCustomFieldDetailsPage(DataTestingParameters param, boolean suffix) {
		boolean flag =true;

		try {

			flag=validateCustomFieldsDetailPageExistingField(param.getFieldAccountName(), param.getFieldName(), param.getFieldDisplayName(),
					param.getFieldType(), param.getFieldDescription());

			viewAndValidateAddValuesToFields(param, true, suffix);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewAndValidateCustomFieldDetailsPage "+e.toString());
			flag=false;
		}

		return flag;
	}



	public boolean updateCustomFieldDetailsForValidConditions(DataTestingParameters param, String icedqUser, boolean suffix) {
		boolean flag =true;
		final boolean uiTag=false;
		try {

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

				if(uiTag) {

					validateCustomFieldsDetailPageExistingField(param.getFieldAccountName(), param.getFieldName(), param.getFieldDisplayName(),
							param.getFieldType(), param.getFieldDescription());

					viewAndValidateAddValuesToFields(param, true,suffix);

				}
				validatAndeEnterValueToTextField(driver, configFieldsDetailsDisplayNameTitle, configFieldsDetailsDisplayNameField, configFieldsDetailsDisplayNameValidation, 
						displayNameContent, placeholderDisplayName, param.getUpdateFieldDisplayName(), fieldValidationdDisplayNameEmpty);

				validatAndeEnterValueToTextField(driver, configFieldsDetailsDescriptionTitle, configFieldsDetailsDescriptionField, configFieldsDetailsDescriptionValidation,
						descriptionContent, placeholderDescription, param.getUpdateFieldDescription(), "");

				verifyVisibilityOfButtons(driver, configFieldsDetailsButtonDiscard, discardContent, true);	

				flag=clickOnSaveButtonAndValidateToast("");

				clickOnCustomFieldsTab();

				if(flag) {

					flag=validateFieldOnListingPage(param, true);
				}
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" updateCustomFieldDetails "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean addValuesToExistingField(DataTestingParameters param, String icedqUser, boolean suffix) {

		boolean flag =true;

		try {

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || 
					icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_CONTRIBUTORUSER)) {


				flag= validateAndAddValuesToFields(param, false, suffix);

				verifyVisibilityOfButtons(driver, configFieldsDetailsButtonDiscard, discardContent, false);	

				verifyVisibilityOfButtons(driver, configFieldsDetailsButtonSave, saveContent, false);

			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" addValuesToExistingField "+e.toString());
			flag=false;
		}

		return flag;

	}


	public boolean deleteValuesToExistingField(DataTestingParameters param, String icedqUser, boolean suffix) {

		boolean flag =true;

		try {

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER) || 
					icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ACCOUNT_CONTRIBUTORUSER)) {

				flag= validateAndDeleteValuesFromFields(param, false, suffix);

				verifyVisibilityOfButtons(driver, configFieldsDetailsButtonDiscard, discardContent, false);	

				verifyVisibilityOfButtons(driver, configFieldsDetailsButtonSave, saveContent, false);

			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" deleteValuesToExistingField "+e.toString());
			flag=false;
		}

		return flag;

	}
	
	public boolean searchFunctionalityOnListingPage(String scenario, String displayName, String description) {
		boolean flag = true;

		try {
			if(scenario.isEmpty()) {
				
				String searchText = scenario.equalsIgnoreCase("name") ? displayName : description;
				
				By fieldToCheck = scenario.equalsIgnoreCase("name") ? configFieldsListingStaticAllName : configFieldsListingStaticAllDescription;

				flag = searchFunctionalityMethod(driver, flag, configFieldsListingSearchBar, configFieldsListingSearchIcon, placeholderSearchField, placeholderSearchField, searchText);
				
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if (flag && elementNotVisible(driver, configFieldsListingNoRecordsToDisplay)) {
					
					List<WebElement> elements = getElements(driver, fieldToCheck);
					
					BaseSuite.reportLog("No of records found :: " + elements.size());

					for (int i = 0; i < elements.size(); i++) {
						BaseSuite.reportLog("Verifying field " + (i + 1));
						
						String acdesc = elements.get(i).getAttribute(attributeTextContent);
						
						flag = stringContainsOutput(acdesc, searchText, flag);
					}
				} else {
					BaseSuite.reportFailLog(noRecordsToDisplayContent+" visible on screen", "searchFunctionalityOnListingPage");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " searchFunctionalityOnListingPage " + e.toString());
			flag = false;
		}

		return flag;
	}
	
	private boolean isValidUser(String icedqUser) {
	    return icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER);
	}
	
	private String[] prepareFieldNames(String fieldValues, boolean suffix) {
	    
		String[] fieldNames = fieldValues.contains(",") ? fieldValues.split(",") : new String[]{fieldValues};

	    if (suffix) {
	        String suffixText = System.getProperty("updateDisplayNameSuffix");
	        for (int i = 0; i < fieldNames.length; i++) {
	            fieldNames[i] = fieldNames[i] + suffixText;
	        }
	    }

	    return fieldNames;
	}
	
	private int deleteFields(String[] fieldNames) {
	    int deletedFieldsCount = 0;
	    for (String fieldName : fieldNames) {
	        BaseSuite.reportLog(hyphenContent + " deleting field :: " + fieldName + " " + hyphenContent);
	        if (searchDisplayNameAndClickOnCheckbox(fieldName)) {
	            deletedFieldsCount++;
	        }
	    }
	    return deletedFieldsCount;
	}
	
	private boolean deleteFieldsFromListingPage(int deletedFieldsCount) {
	    boolean flag = clickOnButton(driver, configFieldsListingButtonDelete, deleteContent + " " + valueContent, true);
	    return clickOnDeleteFieldsFromListingPage(flag, deletedFieldsCount, 
	        deletedFieldsCount == 1 ? toastMessageDeleteCustomField : toastMessageDeleteCustomFields);
	}

	public boolean deleteFieldFromListingPage(String fieldValues, String icedqUser, boolean suffix) {
		boolean flag = true;
		
	    try {
	    	
	        if (!isValidUser(icedqUser) || fieldValues.isEmpty()) {
	            BaseSuite.reportLog("Invalid user or empty field values.");
	            return false;
	        }

	        String[] fieldNames = prepareFieldNames(fieldValues, suffix);
	        
	        int deletedFieldsCount = deleteFields(fieldNames);

	        if (deletedFieldsCount > 0) {
	         
	        	flag = deleteFieldsFromListingPage(deletedFieldsCount);
	        } else {
	           
	        	BaseSuite.reportLog("No fields were deleted.");
	        }

	        return flag;

	    } catch (Exception e) {
	        BaseSuite.reportErrorLog(errorLogTitle + " deleteFieldFromListingPage " + e.toString());
	        flag = false;
	    }

	    return flag;
	}

	
	public boolean discardCustomFieldFunctionalityWhileCreating(DataTestingParameters param, String icedqUser, boolean suffix) {

		boolean flag=true;
		final boolean uiTag=false;
		try {

			flag= clickOnNewFieldButton(icedqUser);

			if(flag && (icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER))) {

				if(uiTag) {validateCustomFieldsDetailPageBeforeCreating(param.getFieldAccountName());}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				validatAndeEnterValueToTextField(driver, configFieldsDetailsFieldNameTitle, configFieldsDetailsFieldNameField, configFieldsDetailsFieldNameValidation, 
						fieldNameContent, placeholderFieldName, param.getFieldName(), fieldValidationFieldNameEmpty);

				validatAndeEnterValueToTextField(driver, configFieldsDetailsDisplayNameTitle, configFieldsDetailsDisplayNameField, configFieldsDetailsDisplayNameValidation, 
						displayNameContent, placeholderDisplayName, param.getFieldDisplayName(), fieldValidationdDisplayNameEmpty);

				seleteCustomFieldType(param.getFieldType());

				validatAndeEnterValueToTextField(driver, configFieldsDetailsDescriptionTitle, configFieldsDetailsDescriptionField, configFieldsDetailsDescriptionValidation, 
						descriptionContent, placeholderDescription, param.getFieldDescription(), "");

				validateAndAddValuesToFields(param, true, suffix);

				flag=clickOnDiscardFieldButtonAndValidateToast("");

				if(flag) {
					
					flag=validateCustomFieldsDetailPageBeforeCreating(param.getFieldAccountName());
				}

			}

		}catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" discardCustomFieldFunctionalityWhileCreating :: "+e.toString());
			flag=false;
		}

		return flag;
	}
	
	public boolean discardCustomFieldFunctionalityWhileUpdating(DataTestingParameters param, String icedqUser, boolean suffix) {
		boolean flag =true;
		final boolean uiTag=false;
		try {

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

				if(uiTag) {

					validateCustomFieldsDetailPageExistingField(param.getFieldAccountName(), param.getFieldName(), param.getFieldDisplayName(),
							param.getFieldType(), param.getFieldDescription());

					viewAndValidateAddValuesToFields(param, true,suffix);

				}
				validatAndeEnterValueToTextField(driver, configFieldsDetailsDisplayNameTitle, configFieldsDetailsDisplayNameField, configFieldsDetailsDisplayNameValidation, 
						displayNameContent, placeholderDisplayName, param.getUpdateFieldDisplayName(), fieldValidationdDisplayNameEmpty);

				validatAndeEnterValueToTextField(driver, configFieldsDetailsDescriptionTitle, configFieldsDetailsDescriptionField, configFieldsDetailsDescriptionValidation,
						descriptionContent, placeholderDescription, param.getUpdateFieldDescription(), "");

				flag=clickOnDiscardFieldButtonAndValidateToast("");

				if(flag) {
					
					flag=validateCustomFieldsDetailPageExistingField(param.getFieldAccountName(), param.getFieldName(), param.getFieldDisplayName(),
							param.getFieldType(), param.getFieldDescription());

					viewAndValidateAddValuesToFields(param, true,suffix);
				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" discardCustomFieldFunctionalityWhileUpdating "+e.toString());
			flag=false;
		}

		return flag;

	}

}
