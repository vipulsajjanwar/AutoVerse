package nexgen.automation.framework.administration;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;
import nexgen.automation.pageclasses.otherpages.HomePage;
import nextgen.automation.workflow.service.pages.DataTestingParameters;

public class FederationsServicePage  extends PageUtil {

	WebDriver driver;

	public FederationsServicePage(WebDriver driver) {
		this.driver = driver;
	}

	protected static final Logger log = Logger.getLogger(FederationsServicePage.class);

	public static final String FEDERATIONSPRIVILEGEFORBIDDENMESSAGE=prop.getProperty("workflow.toast.forbidden.Message");
	public static final String FEDERATIONEXCELPATH = BaseSuite.dirPath+ Constant.NEXTGEN_FEDERATION_TESTDATA_EXCEL_PATH;

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

	By securityTabTitle = getElementLocator(prop.getProperty("security.tab.title"));
	By securityTabFederationsLabel = getElementLocator(prop.getProperty("security.tab.federations.label"));
	By securityTabFederationsAvatar = getElementLocator(prop.getProperty("security.tab.federations.avatar"));
	By securityTabFederationsDescription = getElementLocator(prop.getProperty("security.tab.federations.description"));
	By securityTabSingleSignOnLabel = getElementLocator(prop.getProperty("security.tab.singlesignon.label"));
	By securityTabSingleSignOnAvatar = getElementLocator(prop.getProperty("security.tab.singlesignon.avatar"));
	By securityTabSingleSignOnDescription = getElementLocator(prop.getProperty("security.tab.singlesignon.description"));
	By securityTabEmbeddedVaultLabel = getElementLocator(prop.getProperty("security.tab.emabeddedvault.label"));
	By securityTabEmbeddedVaultAvatar = getElementLocator(prop.getProperty("security.tab.emabeddedvault.avatar"));
	By securityTabEmbeddedVaultDescription = getElementLocator(prop.getProperty("security.tab.emabeddedvault.description"));
	By securityTabCustomCodeLabel = getElementLocator(prop.getProperty("security.tab.customcode.label"));
	By securityTabCustomCodeAvatar = getElementLocator(prop.getProperty("security.tab.customcode.avatar"));
	By securityTabCustomCodeDescription = getElementLocator(prop.getProperty("security.tab.customcode.description"));
	By securityTabPoliciesLabel = getElementLocator(prop.getProperty("security.tab.policies.label"));
	By securityTabPoliciesAvatar = getElementLocator(prop.getProperty("security.tab.policies.avatar"));
	By securityTabPoliciesDescription = getElementLocator(prop.getProperty("security.tab.policies.description"));

	By breadcrumbHome = getElementLocator(prop.getProperty("security.federations.listing.breadcrumb.home")); // breadcrumbHome
	By breadcrumbAdministration = getElementLocator(prop.getProperty("security.federations.listing.breadcrumb.administration"));
	By breadcrumbSecurity = getElementLocator(prop.getProperty("security.federations.listing.breadcrumb.security"));
	By breadcrumbFederations = getElementLocator(prop.getProperty("security.federations.listing.breadcrumb.federations"));
	By breadcrumbFederationsLink = getElementLocator(prop.getProperty("security.federations.listing.breadcrumb.federations.link"));
	By breadcrumbDefaultName = getElementLocator(prop.getProperty("security.federations.listing.breadcrumb.defaultname"));
	By listingTitle = getElementLocator(prop.getProperty("security.federations.listing.title"));
	By listingbuttonCount = getElementLocator(prop.getProperty("security.federations.listing.button.count"));
	By listingbuttonNewFederation = getElementLocator(prop.getProperty("security.federations.listing.button.newfederation"));
	By listingbuttonRefresh = getElementLocator(prop.getProperty("security.federations.listing.button.refresh"));
	By listingbuttonDelete = getElementLocator(prop.getProperty("security.federations.listing.button.delete"));
	By listingsearchBar = getElementLocator(prop.getProperty("security.federations.listing.search.bar"));
	By listingsearchIcon = getElementLocator(prop.getProperty("security.federations.listing.search.icon"));
	By listingsearchClear = getElementLocator(prop.getProperty("security.federations.listing.search.clear"));
	By listingmasterCheckbox = getElementLocator(prop.getProperty("security.federations.listing.master.checkbox"));
	By listingcolumnName = getElementLocator(prop.getProperty("security.federations.listing.column.name"));
	By listingcolumnEnabled = getElementLocator(prop.getProperty("security.federations.listing.column.enabled"));
	By listingcolumnProvider = getElementLocator(prop.getProperty("security.federations.listing.column.provider"));
	By listingnoRecordsToDisplay = getElementLocator(prop.getProperty("security.federations.listing.norecordstodisplay"));
	By listingstaticCheckbox = getElementLocator(prop.getProperty("security.federations.listing.static.checkbox"));
	By listingstaticAvatar = getElementLocator(prop.getProperty("security.federations.listing.static.avatar"));
	By listingstaticName = getElementLocator(prop.getProperty("security.federations.listing.static.name"));
	By listingstaticEnabled = getElementLocator(prop.getProperty("security.federations.listing.static.enabled"));
	By listingstaticProvider = getElementLocator(prop.getProperty("security.federations.listing.static.provider"));
	By listingcountName = getElementLocator(prop.getProperty("security.federations.listing.count.name"));
	By listingcountEnabled = getElementLocator(prop.getProperty("security.federations.listing.count.enabled"));
	By listingcountProvider = getElementLocator(prop.getProperty("security.federations.listing.count.provider"));
	By listingnextPageArrow = getElementLocator(prop.getProperty("security.federations.listing.nextpagearrow"));
	By listingpaginationBar = getElementLocator(prop.getProperty("security.federations.listing.pagination.bar"));
	By listingpaginationInfo = getElementLocator(prop.getProperty("security.federations.listing.pagination.info"));
	By detailsTitle = getElementLocator(prop.getProperty("security.federations.details.title"));
	By detailsAvatar = getElementLocator(prop.getProperty("security.federations.details.avatar"));
	By detailsButtonCount = getElementLocator(prop.getProperty("security.federations.details.button.count"));
	By detailsButtonSave = getElementLocator(prop.getProperty("security.federations.details.button.save"));
	By detailsButtonTest = getElementLocator(prop.getProperty("security.federations.details.button.test"));
	By detailsButtonDiscard = getElementLocator(prop.getProperty("security.federations.details.button.discard"));
	By detailsButtonMoreOptions = getElementLocator(prop.getProperty("security.federations.details.button.moreoptions"));
	By detailsButtonDelete = getElementLocator(prop.getProperty("security.federations.details.button.delete"));
	By detailsTabSettings = getElementLocator(prop.getProperty("security.federations.details.tab.settings"));

	By configFieldsDetailsDiscardPoupupTitle=getElementLocator(prop.getProperty("configurations.fields.details.popup.discard.title"));
	By configFieldsDetailsDiscardPoupupContent=getElementLocator(prop.getProperty("configurations.fields.details.popup.discard.content"));
	By configFieldsDetailsDiscardPoupupDiscardButton=getElementLocator(prop.getProperty("configurations.fields.details.popup.discard.discardbutton"));
	By configFieldsDetailsDiscardPoupupCancelButton=getElementLocator(prop.getProperty("configurations.fields.details.popup.discard.cancelbutton"));

	By federationDetailsDeletePoupupTitle=getElementLocator(prop.getProperty("security.federations.details.popup.delete.title"));
	By federationDetailsDeletePoupupContent=getElementLocator(prop.getProperty("security.federations.details.popup.delete.content"));
	By federationDetailsDeletePoupupDeleteButton=getElementLocator(prop.getProperty("security.federations.details.popup.delete.deletebutton"));
	By federationDetailsDeletePoupupCancelButton=getElementLocator(prop.getProperty("security.federations.details.popup.delete.cancelbutton"));

	By mappersTab=getElementLocator(prop.getProperty("security.federations.details.mappers.tab"));
	By mapperssearchBar = getElementLocator(prop.getProperty("security.federations.details.mappers.search.bar"));
	By mapperssearchIcon = getElementLocator(prop.getProperty("security.federations.details.mappers.search.icon"));
	By mapperssearchClear = getElementLocator(prop.getProperty("security.federations.details.mappers.search.clear"));
	By mappersmasterCheckbox = getElementLocator(prop.getProperty("security.federations.details.mappers.mastercheckbox"));
	By mapperscolumnName = getElementLocator(prop.getProperty("security.federations.details.mappers.column.name"));
	By mapperscolumnType = getElementLocator(prop.getProperty("security.federations.details.mappers.column.type"));

	By mappersListingButtonCount=getElementLocator(prop.getProperty("security.federations.details.mappers.button.count"));
	By mappersListingButtonNewMapper=getElementLocator(prop.getProperty("security.federations.details.mappers.button.newmapper"));
	By mappersListingButtonRefresh=getElementLocator(prop.getProperty("security.federations.details.mappers.button.refresh"));
	By mappersListingButtonDelete=getElementLocator(prop.getProperty("security.federations.details.mappers.button.delete"));

	By mappersListingStaticCheckbox=getElementLocator(prop.getProperty("security.federations.details.mappers.checkbox"));
	By mappersListingStaticAvatar=getElementLocator(prop.getProperty("security.federations.details.mappers.avatar"));
	By mappersListingStaticName=getElementLocator(prop.getProperty("security.federations.details.mappers.name"));
	By mappersListingStatictype=getElementLocator(prop.getProperty("security.federations.details.mappers.type"));

	By mappersListingCountCheckbox=getElementLocator(prop.getProperty("security.federations.details.mappers.count.checkbox"));
	By mappersListingCountName=getElementLocator(prop.getProperty("security.federations.details.mappers.count.name"));
	By mappersListingCounttype=getElementLocator(prop.getProperty("security.federations.details.mappers.count.type"));

	By mapperslistingnextPageArrow = getElementLocator(prop.getProperty("security.federations.mappers.nextpagearrow"));
	By mapperslistingpaginationBar = getElementLocator(prop.getProperty("security.federations.mappers.pagination.bar"));
	By mapperslistingpaginationInfo = getElementLocator(prop.getProperty("security.federations.mappers.pagination.info"));


	By mappersBreadcrumbLink=getElementLocator(prop.getProperty("security.federations.mappers.details.breadcrumb.mapper"));

	By mappersDetailsButtonCount=getElementLocator(prop.getProperty("security.federations.mappers.details.button.count"));
	By mappersDetailsButtonSave=getElementLocator(prop.getProperty("security.federations.mappers.details.button.save"));
	By mappersDetailsButtonDiscard=getElementLocator(prop.getProperty("security.federations.mappers.details.button.discard"));
	By mappersDetailsButtonDelete=getElementLocator(prop.getProperty("security.federations.mappers.details.button.delete"));

	String mapperLabelName=prop.getProperty("security.federations.details.mapper.label.name");
	String mapperLabelType=prop.getProperty("security.federations.details.mapper.label.mappertype");
	String mapperLabelUserModel=prop.getProperty("security.federations.details.mapper.label.usermodel");
	String mapperLabelLdapAttribute=prop.getProperty("security.federations.details.mapper.label.ldapatribute");

	String mapperTooltipName=prop.getProperty("security.federations.details.mapper.tooltip.name");
	String mapperTooltipType=prop.getProperty("security.federations.details.mapper.tooltip.mappertype");
	String mapperTooltipUserModel=prop.getProperty("security.federations.details.mapper.tooltip.usermodel");
	String mapperTooltipLdapAttribute=prop.getProperty("security.federations.details.mapper.tooltip.ldapatribute");

	String mapperPlaceholderName=prop.getProperty("federation.mapper.placeholder.name");
	String mapperPlaceholderType=prop.getProperty("federation.mapper.placeholder.type");
	String mapperPlaceholderUserModel=prop.getProperty("federation.mapper.placeholder.usermodel");
	String mapperPlaceholderLdapAttribute=prop.getProperty("federation.mapper.placeholder.ldapatribute");

	String mapperDynamicLabel = prop.getProperty("security.federations.details.mappers.dynamic.label");
	String mapperDynamicTooltip = prop.getProperty("security.federations.details.mappers.dynamic.tooltip");
	String mapperDynamicInputField = prop.getProperty("security.federations.details.mappers.dynamic.inputfield");
	String mapperDynamicValidation = prop.getProperty("security.federations.details.mappers.dynamic.validation");

	String mapperDynamicInputFieldDropDown=prop.getProperty("security.federations.details.mappers.dynamicfield.dropdown");
	String mapperDynamicInputFieldDropDownSelect=prop.getProperty("security.federations.details.mappers.dynamicfield.select");

	String mapperDynamicInputFieldDisabled = prop.getProperty("security.federations.details.mappers.dynamic.input.disabled");
	String mapperDynamicInputFieldEnabled = prop.getProperty("security.federations.details.mappers.dynamic.input.enabled");



	String mappersDetailsBreadcrumbLabel=prop.getProperty("security.federations.mappers.details.breadcrumb.label");

	String mappersDynamicCheckbox = prop.getProperty("security.federations.mappers.dynamic.checkbox");
	String mappersDynamicName = prop.getProperty("security.federations.mappers.dynamic.name");
	String mappersDynamicType = prop.getProperty("security.federations.mappers.dynamic.type");
	String mappersDynamicAvatar = prop.getProperty("security.federations.mappers.dynamic.avatar");

	String ldapDynamicTab=prop.getProperty("security.federations.details.dynamic.tab");

	String dynamicBreadcrumbName=prop.getProperty("security.federations.listing.dynamicname.label");
	String dynamicBreadcrumbID=prop.getProperty("security.federations.listing.dynamicnameid.label");
	String detailsDynamicTitle=prop.getProperty("security.federations.details.dynamictitle");
	String detailsDynamicAvatar=prop.getProperty("security.federations.details.dynamicavatar");
	String listingDynamicCheckbox = prop.getProperty("security.federations.listing.dynamic.checkbox");
	String listingDynamicAvatar = prop.getProperty("security.federations.listing.dynamic.avatar");
	String listingDynamicName = prop.getProperty("security.federations.listing.dynamic.name");
	String listingDynamicEnabled = prop.getProperty("security.federations.listing.dynamic.enabled");
	String listingDynamicProvider = prop.getProperty("security.federations.listing.dynamic.provider");
	String detailsDynamicLabel = prop.getProperty("security.federations.details.settings.dynamic.label");
	String detailsDynamicTooltip = prop.getProperty("security.federations.details.settings.dynamic.tooltip");
	String detailsDynamicInputField = prop.getProperty("security.federations.details.settings.dynamic.inputfield");
	String detailsDynamicValidation = prop.getProperty("security.federations.details.settings.dynamic.validation");
	String labelConsoleDisplayName = prop.getProperty("security.federations.details.settings.label.consoledisplayname");
	String labelPriority = prop.getProperty("security.federations.details.settings.label.priority");
	String labelEditMode = prop.getProperty("security.federations.details.settings.label.editmode");
	String labelVendor = prop.getProperty("security.federations.details.settings.label.vendor");
	String labelUsernameLdapAttribute = prop.getProperty("security.federations.details.settings.label.usernameldapattribute");
	String labelRdnLdapAttribute = prop.getProperty("security.federations.details.settings.label.rdnldapattribute");
	String labelUuidLdapAttribute = prop.getProperty("security.federations.details.settings.label.UUIDldapattribute");
	String labelUserObjectClasses = prop.getProperty("security.federations.details.settings.label.userobjectclasses");
	String labelConnectionUrl = prop.getProperty("security.federations.details.settings.label.connectionurl");
	String labelUsersDn = prop.getProperty("security.federations.details.settings.label.usersdn");
	String labelCustomUserLdapFilter = prop.getProperty("security.federations.details.settings.label.customuserldapfilter");
	String labelSearchScope = prop.getProperty("security.federations.details.settings.label.searchscope");
	String labelBindType = prop.getProperty("security.federations.details.settings.label.bindtype");
	String labelBindDn = prop.getProperty("security.federations.details.settings.label.binddn");
	String labelBindCredential = prop.getProperty("security.federations.details.settings.label.bindcredential");
	String labelPagination = prop.getProperty("security.federations.details.settings.label.pagination");
	String labelEnabled=prop.getProperty("security.federations.details.settings.label.enabled");
	String labelImportUsers=prop.getProperty("security.federations.details.settings.label.importusers");
	String labelSyncRegistration=prop.getProperty("security.federations.details.settings.label.syncRegistration");

	String detailsDynamicFieldCheckbox=prop.getProperty("security.federations.details.settings.dynamicfield.checkbox");
	String detailsDynamicFieldTooltip=prop.getProperty("security.federations.details.settings.dynamicfield.tooltip");
	String detailsDynamicInputFieldDisabled = prop.getProperty("security.federations.details.settings.dynamic.input.disabled");
	String detailsDynamicInputFieldEnabled = prop.getProperty("security.federations.details.settings.dynamic.input.enabled");
	String detailsDynamicInputCheckboxDisabled = prop.getProperty("security.federations.details.settings.dynamicfield.checkbox.disabled");
	String detailsDynamicInputCheckboxEnabled = prop.getProperty("security.federations.details.settings.dynamicfield.checkbox.enabled");

	String detailsDynamicInputFieldDropDown=prop.getProperty("security.federations.details.settings.dynamicfield.dropdown");
	String detailsDynamicInputFieldDropDownSelect=prop.getProperty("security.federations.details.settings.dynamicfield.select");


	String placeholderConsoleDisplayName = prop.getProperty("security.federations.details.settings.placeholder.consoledisplayname");
	String placeholderPriority = prop.getProperty("security.federations.details.settings.placeholder.priority");
	String defaultValuePriority = prop.getProperty("security.federations.details.settings.defaultvalue.priority");
	String defaultValueEditMode = prop.getProperty("security.federations.details.settings.defaultvalue.editmode");
	String defaultValueVendor = prop.getProperty("security.federations.details.settings.defaultvalue.vendor");
	String placeholderUsernameLdapAttribute = prop.getProperty("security.federations.details.settings.placeholder.usernameldapattribute");
	String placeholderRdnLdapAttribute = prop.getProperty("security.federations.details.settings.placeholder.rdnldapattribute");
	String placeholderUuidLdapAttribute = prop.getProperty("security.federations.details.settings.placeholder.UUIDldapattribute");
	String placeholderUserObjectClasses = prop.getProperty("security.federations.details.settings.placeholder.userobjectclasses");
	String placeholderConnectionUrl = prop.getProperty("security.federations.details.settings.placeholder.connectionurl");
	String placeholderUsersDn = prop.getProperty("security.federations.details.settings.placeholder.usersdn");
	String placeholderCustomUserLdapFilter = prop.getProperty("security.federations.details.settings.placeholder.customuserldapfilter");
	String defaultValueSearchScope = prop.getProperty("security.federations.details.settings.defaultvalue.searchscope");
	String defaultValueBindType = prop.getProperty("security.federations.details.settings.defaultvalue.bindtype");
	String placeholderBindDn = prop.getProperty("security.federations.details.settings.placeholder.binddn");
	String placeholderBindCredential = prop.getProperty("security.federations.details.settings.placeholder.bindcredential");
	String defaultValuePagination = prop.getProperty("security.federations.details.settings.defaultvalue.pagination");

	String fieldEmptyConsoleDisplayName=prop.getProperty("fieldEmpty.consoledisplayname");
	String fieldEmptyPriority=prop.getProperty("fieldEmpty.priority");
	String fieldEmptyUsernameLdap=prop.getProperty("fieldEmpty.usernameldap");
	String fieldEmptyRdnldap=prop.getProperty("fieldEmpty.rdnldap");
	String fieldEmptyUuidLdap=prop.getProperty("fieldEmpty.uuidldap");
	String fieldEmptyUserObjectClass=prop.getProperty("fieldEmpty.userobjectclass");
	String fieldEmptyConnectionURL=prop.getProperty("fieldEmpty.connectionurl");
	String fieldEmptyUsersDn=prop.getProperty("fieldEmpty.usersdn");
	String fieldEmptyBindDn=prop.getProperty("fieldEmpty.binddn");
	String fieldEmptyBindCred=prop.getProperty("fieldEmpty.bindcred");

	String moduleTab=prop.getProperty("nextgen.hamberger.tab");
	String subModuleTab=prop.getProperty("nextgenmodule.submodule.tab");
	String subModuleHeadingName=prop.getProperty("nextgenmodule.submodule.headingDynamic");
	String dynamicName=prop.getProperty("DynName");
	String nextgenSubModuleDynamic=prop.getProperty("nextgenmodule.submodule.dynamic");
	String refreshContent=prop.getProperty("string.refreshContent");
	String attributeClass=prop.getProperty("string.attributeClass");
	String attrcheck=prop.getProperty("string.attrcheck");
	String attrUncheck=prop.getProperty("string.attrUncheck");
	String attributeValue=prop.getProperty("string.attributeValue");
	String attributeTextContent=prop.getProperty("string.attributeTextContent");
	String attributeContent="content";
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
	String federationsContent=prop.getProperty("String.fedetationsContent");
	String identityProvidersContent=prop.getProperty("String.identityProvidersContent");
	String vaultContent=prop.getProperty("String.vaultContent");
	String fieldContent=prop.getProperty("String.fieldContent");
	String calendarsContent=prop.getProperty("String.calendarsContent");
	String settingsContent=prop.getProperty("String.settingsContent");
	String integrationsContent=prop.getProperty("String.integrationsContent");
	String librariesContent=prop.getProperty("String.librariesContent");
	String configurationsContent="Configurations";
	String securityContent="Security";
	String moduleContent=prop.getProperty("String.moduleContent");
	String subModuleContent=prop.getProperty("String.subModuleContent");
	String columnContent=prop.getProperty("String.columnContent");
	String tabContent=prop.getProperty("String.tabContent");
	String iconContent=prop.getProperty("String.iconContent");
	String newFederationContent="New Federation";
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

	String userFederationContent="User Federation";
	String singleSignOnContent="Single Sign-On";
	String embeddedVaultContent="Embedded Vault";
	String customCodeContent="Custom Code";
	String policiesContent="Policies";

	String defaultConsoleDisplayName = "ldap";
	String defaultNameForMapper="Create New Mapper";
	String mappersContent="Mappers";
	String clickingOnContent="Clicking on ";
	String clickedOnContent="Clicked on ";
	String verifyingContent="Verifying ";

	String isVisibleContent=" is visible";

	String descuserFederationContent="Connect your existing company directory (e.g., Active Directory) for easy login and user management.";
	String descsingleSignOnContent="Integrate with identity providers like Entra, Okta, or Ping for seamless login using your existing credentials.";
	String descembeddedVaultContent="Enable the built-in vault to securely store sensitive information used throughout the application.";
	String desccustomCodeContent="Upload third-party or custom code for advanced users to extend functionalities through functions or scripts.";
	String descpoliciesContent="Set up rules that define how user accounts and data are protected within the application.";

	String tooltipConsoleDisplayName = prop.getProperty("security.federations.details.settings.tooltip.consoledisplayname");
	String tooltipPriority = prop.getProperty("security.federations.details.settings.tooltip.priority");
	String tooltipEditMode = prop.getProperty("security.federations.details.settings.tooltip.editmode");
	String tooltipVendor = prop.getProperty("security.federations.details.settings.tooltip.vendor");
	String tooltipUsernameLdapAttribute = prop.getProperty("security.federations.details.settings.tooltip.usernameLdapAttribute");
	String tooltipRdnLdapAttribute = prop.getProperty("security.federations.details.settings.tooltip.rdnLdapAttribute");
	String tooltipUUIDldapattribute = prop.getProperty("security.federations.details.settings.tooltip.UUIDldapattribute");
	String tooltipUserObjectClasses = prop.getProperty("security.federations.details.settings.tooltip.userobjectclasses");
	String tooltipConnectionUrl = prop.getProperty("security.federations.details.settings.tooltip.connectionurl");
	String tooltipUsersDn = prop.getProperty("security.federations.details.settings.tooltip.usersdn");
	String tooltipCustomUserLdapFilter = prop.getProperty("security.federations.details.settings.tooltip.customuserldapfilter");
	String tooltipSearchScope = prop.getProperty("security.federations.details.settings.tooltip.searchscope");
	String tooltipBindType = prop.getProperty("security.federations.details.settings.tooltip.bindtype");
	String tooltipBindDn = prop.getProperty("security.federations.details.settings.tooltip.binddn");
	String tooltipBindCredential = prop.getProperty("security.federations.details.settings.tooltip.bindcredential");
	String tooltipPagination = prop.getProperty("security.federations.details.settings.tooltip.pagination");

	String tooltipEnabled=prop.getProperty("security.federations.details.settings.tooltip.enabled");
	String tooltipImportUsers=prop.getProperty("security.federations.details.settings.tooltip.importusers");
	String tooltipSyncRegistration=prop.getProperty("security.federations.details.settings.tooltip.syncRegistration");

	String toastLdapCreated=prop.getProperty("toast.create.ldap");
	String toastLdapTested=prop.getProperty("toast.test.ldap");
	String toastLdapDeleted=prop.getProperty("toast.delete.ldap");

	String toastMapperCreated=prop.getProperty("toast.create.mapper");
	String toastMapperDeleted=prop.getProperty("toast.delete.mapper");

	String placeholderSearchFederation=prop.getProperty("federation.listing.placeholder.search");
	String placeholderSearchMappers=prop.getProperty("federation.mapper.placeholder.search");

	String bindCredentialHiddenValue="**********";

	String popuupDeleteFedTitle=prop.getProperty("popup.delete.federation.title");
	String popuupDeleteFedContent=prop.getProperty("popup.delete.federation.content");
	String popuupDeleteMapperTitle=prop.getProperty("popup.delete.Mapper.title");
	String popuupDeleteMapperContent=prop.getProperty("popup.delete.Mapper.content");




	public static final String ENABLED = "enabled";
	public static final String DISABLED = "disabled";
	public static final String FALSE = "false";
	public static final String TRUE = "true";
	
	public static final String GROUPLDAPMAPPER="group-ldap-mapper";
	public static final String USERLDAPMAPPER="user-attribute-ldap-mapper";

	/** ---------------------- Methods  ---------------------------------- **/

	public static DataTestingParameters setFederationServiceParamUsingExcel(String filePath, String sheetName, int rowNumber, boolean useSuffix) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String ln="";
		String uln="";
		try {
			if(useSuffix) {
				ln=System.getProperty("ldapsuffix");
				uln=System.getProperty("Updateldapsuffix");
			}

			param.setTestScenarioName(xl.readUsingColName(filePath,sheetName, rowNumber, "testScenario"));
			param.setScenarioType(xl.readUsingColName(filePath,sheetName, rowNumber, "scenarioType"));
			param.setExecutionstate(xl.readUsingColName(filePath,sheetName, rowNumber, "execute"));
			// Setting values using setter methods
			param.setLdapEnabledFlag(xl.readUsingColName(filePath,sheetName, rowNumber, "EnabledFlag"));
			param.setConsoleDisplayName(xl.readUsingColName(filePath,sheetName, rowNumber, "ConsoleDisplayName")+ln);
			param.setPriority(xl.readUsingColName(filePath,sheetName, rowNumber, "Priority"));
			param.setImportUsersFlag(xl.readUsingColName(filePath,sheetName, rowNumber, "ImportUsersFlag"));
			param.setEditMode(xl.readUsingColName(filePath,sheetName, rowNumber, "EditMode"));
			param.setSyncRegistrations(xl.readUsingColName(filePath,sheetName, rowNumber, "SyncRegiFlag"));
			param.setVendor(xl.readUsingColName(filePath,sheetName, rowNumber, "Vendor"));
			param.setUsernameLdapAttribute(xl.readUsingColName(filePath,sheetName, rowNumber, "UsernameLDAP"));
			param.setRdnLdapAttribute(xl.readUsingColName(filePath,sheetName, rowNumber, "RDNLDAP"));
			param.setUuidLdapAttribute(xl.readUsingColName(filePath,sheetName, rowNumber, "UUIDLDAP"));
			param.setUserObjectClasses(xl.readUsingColName(filePath,sheetName, rowNumber, "UserObjectClasses"));
			param.setConnectionURL(xl.readUsingColName(filePath,sheetName, rowNumber, "ConnectionURL"));
			param.setUsersDN(xl.readUsingColName(filePath,sheetName, rowNumber, "UsersDN"));
			param.setCustomUserLdapFilter(xl.readUsingColName(filePath,sheetName, rowNumber, "CustomUserLdapFilter"));
			param.setSearchScope(xl.readUsingColName(filePath,sheetName, rowNumber, "SearchScope"));
			param.setBindType(xl.readUsingColName(filePath,sheetName, rowNumber, "BindType"));
			param.setBindDN(xl.readUsingColName(filePath,sheetName, rowNumber, "BindDN"));
			param.setBindCredential(xl.readUsingColName(filePath,sheetName, rowNumber, "BindCred"));
			param.setPagination(xl.readUsingColName(filePath,sheetName, rowNumber, "Pagination").toLowerCase());
			param.setUpdateConsoleDisplayName(xl.readUsingColName(filePath,sheetName, rowNumber, "UpdateConsoleDisplayName")+uln);
			param.setMappers(xl.readUsingColName(filePath,sheetName, rowNumber, "defaultMappers"));
			param.setCustomMappers(xl.readUsingColName(filePath,sheetName, rowNumber, "customMappers"));
			param.setUpdateMappers(xl.readUsingColName(filePath,sheetName, rowNumber, "updateMappers"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setFederationServiceParamUsingExcel "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setMappersParamUsingExcel(String filePath, String user, boolean useSuffix) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String refColumn="key";
		String sheetName="mappers";
		String mn="";
		try {

			if(useSuffix) {
				mn=System.getProperty("mappersuffix");
				
			}
			param.setMapperName(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"mapperName")+mn);
			param.setMapperType(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"mapperType"));
			param.setUserModel(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"userModel"));
			param.setLdapAttribute(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"ldapAttribute"));
			param.setLdapGroupsDn(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"ldapGroupsDn"));
			param.setGroupNameLdap(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"groupNameLdap"));
			param.setGroupObjectClasses(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"groupObjectClasses"));
			param.setMembershipLdapAttribute(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"membershipLdapattribute"));
			param.setMembershipType(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"membershipType"));
			param.setMembershipUserLdap(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"membershipUserLdap"));
			param.setLdapFilter(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"ldapFilter"));
			param.setMode(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"mode"));
			param.setUserGroupsRetrieveStategy(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"userGroupsRetrieveStategy"));
			param.setMemberOFLdap(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"memberOFLdap"));
			param.setMappedGroup(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"mappedGroup"));


		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setUsersParamUsingExcel "+e.toString());
		}
		return param;

	}
	
	public static DataTestingParameters setUpdateMappersParamUsingExcel(String filePath, String user, boolean useSuffix) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String refColumn="key";
		String sheetName="umapper";
		String mn="";
		try {

			if(useSuffix) {
				mn=System.getProperty("mappersuffix");
				
			}
			param.setMapperName(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"mapperName")+mn);
			param.setMapperType(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"mapperType"));
			param.setUserModel(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"userModel"));
			param.setLdapAttribute(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"ldapAttribute"));
			param.setLdapGroupsDn(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"ldapGroupsDn"));
			param.setGroupNameLdap(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"groupNameLdap"));
			param.setGroupObjectClasses(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"groupObjectClasses"));
			param.setMembershipLdapAttribute(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"membershipLdapattribute"));
			param.setMembershipType(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"membershipType"));
			param.setMembershipUserLdap(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"membershipUserLdap"));
			param.setLdapFilter(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"ldapFilter"));
			param.setMode(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"mode"));
			param.setUserGroupsRetrieveStategy(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"userGroupsRetrieveStategy"));
			param.setMemberOFLdap(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"memberOFLdap"));
			param.setMappedGroup(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"mappedGroup"));


		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setUpdateMappersParamUsingExcel "+e.toString());
		}
		return param;

	}


	public boolean clickOnRefreshOnFederationsListingPage() {

		return clickOnButton(driver, listingbuttonRefresh, refreshContent, true);
	}

	public boolean clickOnRefreshOnFederationsListingPageWithValidation() {
		boolean flag=true;

		try {
			clickOnButton(driver, listingbuttonRefresh, refreshContent, true);

			waitForExecution(100);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, toastMsg)) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
						"Federations tab refresh authorization message");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnRefreshOnFederationsListingPageWithValidation :: "+e.toString());
		}

		return flag;
	}

	public boolean clickOnSecurityTab() {

		boolean flag = false;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, securityTabTitle);

			if(elementNotVisible(driver, securityTabTitle)) {

				isDisplayedInLoop(driver, 3, nextgenSubModuleSecurity);

				if(isDisplayed(driver, nextgenSubModuleSecurity)) {

					flag = isClickable(driver, nextgenSubModuleSecurity, securityContent+" tab", true);

					if(flag) {

						BaseSuite.reportLog(clickingOnContent+securityContent+" tab");

						displayAndClick(driver, nextgenSubModuleSecurity);

						handleDiscardWindow(driver, configFieldsDetailsDiscardPoupupDiscardButton, discardContent);

						BaseSuite.validationReportLog(clickedOnContent+securityContent+" tab");

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

						flag=validateElement(driver, securityTabTitle, securityContent, attributeTitle);
					}

				}else {
					BaseSuite.reportFailLog(securityContent+" tab not visible", "clickOnSecurityTab");
				}
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnSecurityTab :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean clickOnSecurityTab(String expectedToastMessage) {

		boolean flag = false;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, listingTitle);

			if(elementNotVisible(driver, listingTitle)) {

				isDisplayedInLoop(driver, 3, nextgenSubModuleSecurity);

				if(isDisplayed(driver, nextgenSubModuleSecurity)) {

					flag = isClickable(driver, nextgenSubModuleSecurity, securityContent+" tab", true);

					if(flag) {

						BaseSuite.reportLog(clickingOnContent+securityContent+" tab");

						displayAndClick(driver, nextgenSubModuleSecurity);

						/**handleDiscardWindow();**/
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.validationReportLog(clickedOnContent+securityContent+" tab");

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

						captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,
								securityContent+" tab authorization message");

						flag=validateElement(driver, listingTitle, securityContent, attributeTitle);

					}

				}else {
					BaseSuite.reportFailLog(securityContent+" tab not visible", "clickOnSecurityTab");
				}
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnSecurityTab :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateSecurityTab() {

		boolean flag = false;

		try {

			BaseSuite.reportLog(hyphenContent+" validating security tab fields "+hyphenContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateElement(driver, securityTabTitle, securityContent, labelContent);

			validateElement(driver, securityTabFederationsAvatar, userFederationContent, iconContent);

			validateElement(driver, securityTabFederationsLabel, userFederationContent, attributeTitle);

			checkExpectedValueWithActual(driver, flag, securityTabFederationsDescription, userFederationContent, descuserFederationContent, true, attributeTextContent);

			validateElement(driver, securityTabSingleSignOnAvatar, singleSignOnContent, iconContent);

			validateElement(driver, securityTabSingleSignOnLabel, singleSignOnContent, attributeTitle);

			checkExpectedValueWithActual(driver, flag, securityTabSingleSignOnDescription, singleSignOnContent, descsingleSignOnContent, true, attributeTextContent);

			validateElement(driver, securityTabEmbeddedVaultAvatar, embeddedVaultContent, iconContent);

			validateElement(driver, securityTabEmbeddedVaultLabel,  embeddedVaultContent, attributeTitle);

			checkExpectedValueWithActual(driver, flag, securityTabEmbeddedVaultDescription,  embeddedVaultContent, descembeddedVaultContent, true, attributeTextContent);

			validateElement(driver, securityTabCustomCodeAvatar, customCodeContent, labelContent);

			validateElement(driver, securityTabCustomCodeLabel, customCodeContent, iconContent);

			checkExpectedValueWithActual(driver, flag, securityTabCustomCodeDescription, customCodeContent, desccustomCodeContent, true, attributeTextContent);

			validateElement(driver, securityTabPoliciesAvatar, policiesContent, labelContent);

			validateElement(driver, securityTabPoliciesLabel, policiesContent, iconContent);

			checkExpectedValueWithActual(driver, flag, securityTabPoliciesDescription, policiesContent, descpoliciesContent, true, attributeTextContent);

			BaseSuite.reportLog(hyphenContent+" validated security tab fields successfully "+hyphenContent);

		}catch(Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" validateSecurityTab :: "+e.toString());
			flag=false;

		}

		return flag;

	}

	public boolean clickOnUserFederationsTab() {

		boolean flag = false;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isDisplayedInLoop(driver, 0, listingTitle);

			if (!isDisplayed(driver, listingTitle)) {
				flag = handleFederationsTabNavigation();
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " clickOnUserFederationsTab :: " + e.toString());
			flag = false;
		}

		return flag;

	}

	private boolean handleFederationsTabNavigation() {
		boolean flag = false;

		if (isDisplayed(driver, securityTabFederationsLabel)) {
			flag = clickOnButton(driver, securityTabFederationsLabel, userFederationContent, true);
		} else if (isDisplayed(driver, breadcrumbFederationsLink)) {
			flag = clickOnButton(driver, breadcrumbFederationsLink, federationsContent, true);
		}

		if (flag) {
			handleDiscardWindow(driver, configFieldsDetailsDiscardPoupupDiscardButton, discardContent);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isDisplayedInLoop(driver, 0, listingbuttonNewFederation);

			if (isDisplayed(driver, listingbuttonNewFederation)) {
				flag = validateElement(driver, listingTitle, federationsContent, attributeTitle);
			}
		}

		return flag;
	}


	public boolean validateFederationsListingPage() {

		boolean flag = true;
		HomePage hp=new HomePage(driver);

		try {

			BaseSuite.reportLog(hyphenContent+" validating Federation listing page fields "+hyphenContent);

			hp.validateNextgenIcedqModuleAndAdministrationSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Federations listing page "+hyphenContent);

			validateElement(driver,breadcrumbHome, homeContent, hyperlinkContent);

			validateElement(driver,breadcrumbAdministration, administrationContent, hyperlinkContent);

			validateElement(driver,breadcrumbSecurity, securityContent, hyperlinkContent);
			
			validateElement(driver,breadcrumbFederations, federationsContent, labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying Title and Search field Federations listing page "+hyphenContent);

			verifyIndividualLabel(driver, listingTitle, federationsContent);

			verifySearchField(driver, listingsearchBar, placeholderSearchFederation, placeholderSearchFederation);

			validateElement(driver,listingsearchIcon, placeholderSearchFederation, iconContent);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Federations listing page "+hyphenContent);

			validateButtons(driver, listingbuttonCount, 3);

			verifyVisibilityOfButtons(driver, listingbuttonNewFederation, newFederationContent, true);
			verifyVisibilityOfButtons(driver, listingbuttonRefresh, refreshContent, true);
			verifyVisibilityOfButtons(driver, listingbuttonDelete, deleteContent, false);

			BaseSuite.reportLog(hyphenContent+"  Verifying Columns on Federations listing page "+hyphenContent);

			validateElement(driver, listingmasterCheckbox, "Master", checkboxContent);
			validateElement(driver,listingcountName, "Name",columnContent);
			validateElement(driver,listingcolumnEnabled, "Enabled", columnContent);
			validateElement(driver,listingcolumnProvider, "Provider", columnContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on Federations listing page "+hyphenContent);

			getPaginationDetails(driver,listingpaginationInfo, listingpaginationBar,listingnoRecordsToDisplay, "Federations listing page");

			BaseSuite.validationReportLog(hyphenContent+" Federations listing page validated successfully "+hyphenContent);

		}catch(Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" validateFederationsListingPage :: "+e.toString());
			flag=false;

		}

		return flag;

	}


	public boolean clickOnNewFederationButton(String icedqUser) {

		boolean flag = true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 3, listingbuttonNewFederation);

			if(isDisplayed(driver, listingbuttonNewFederation)) {

				clickOnButton(driver, listingbuttonNewFederation, newFederationContent, flag);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

					String pgTitle=getAttribute(driver, detailsTitle, attributeTextContent);

					flag = stringOutput(pgTitle.trim(), "ldap", true);

				}else{

					flag = captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
							"New Federation authorization message");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnNewFederationButton :: "+e.toString());
			flag=false;
		}

		return flag;
	}


	public boolean validateFederationDetailPageBeforeCreating() {
		boolean flag = true;
		HomePage hp=new HomePage(driver);

		try {

			BaseSuite.reportLog(hyphenContent+" validating federation details page before creating "+hyphenContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			hp.validateNextgenIcedqModuleAndAdministrationSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Federation details page "+hyphenContent);

			validateElement(driver,breadcrumbHome, homeContent, hyperlinkContent);

			validateElement(driver,breadcrumbAdministration, administrationContent, hyperlinkContent);

			validateElement(driver,breadcrumbSecurity, securityContent, hyperlinkContent);

			validateElement(driver,breadcrumbFederationsLink, federationsContent, hyperlinkContent);

			validateElement(driver,breadcrumbDefaultName, "ldap", labelContent);

			validateElement(driver,returnElement(detailsDynamicTitle, dynamicName, defaultConsoleDisplayName), defaultConsoleDisplayName, attributeTitle);

			validateElement(driver,returnElement(detailsDynamicAvatar, dynamicName, defaultConsoleDisplayName), defaultConsoleDisplayName, iconContent);


			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Federation details page "+hyphenContent);

			validateButtons(driver, detailsButtonCount, 5);

			verifyVisibilityOfButtons(driver, detailsButtonSave, saveContent, false);
			verifyVisibilityOfButtons(driver, detailsButtonTest, "Test", false);	
			verifyVisibilityOfButtons(driver, detailsButtonDiscard, discardContent, false);	
			verifyVisibilityOfButtons(driver, detailsButtonMoreOptions, "More Options", false);	
			verifyVisibilityOfButtons(driver, detailsButtonDelete, deleteContent, false);

			validateDefaultFieldsOfFederations();

			BaseSuite.reportLog(hyphenContent+" validated federation details page "+hyphenContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateFederationDetailPageBeforeCreating :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateDefaultFieldsOfFederations() {
		boolean flag = true;
		try {
			// Define an array of field details (including default values)
			String[][] fieldDetails = {
					{labelConsoleDisplayName, tooltipConsoleDisplayName, placeholderConsoleDisplayName, defaultConsoleDisplayName, TRUE},
					{labelPriority, tooltipPriority, placeholderPriority, defaultValuePriority, TRUE},
					{labelEditMode, tooltipEditMode, "", defaultValueEditMode, FALSE},
					{labelVendor, tooltipVendor, "", defaultValueVendor, FALSE},
					{labelUsernameLdapAttribute, tooltipUsernameLdapAttribute, placeholderUsernameLdapAttribute, "", TRUE},
					{labelRdnLdapAttribute, tooltipRdnLdapAttribute, placeholderRdnLdapAttribute, "", TRUE},
					{labelUuidLdapAttribute, tooltipUUIDldapattribute, placeholderUuidLdapAttribute, "", TRUE},
					{labelUserObjectClasses, tooltipUserObjectClasses, placeholderUserObjectClasses, "", TRUE},
					{labelConnectionUrl, tooltipConnectionUrl, placeholderConnectionUrl, "", TRUE},
					{labelUsersDn, tooltipUsersDn, placeholderUsersDn, "", TRUE},
					{labelCustomUserLdapFilter, tooltipCustomUserLdapFilter, placeholderCustomUserLdapFilter, "", TRUE},
					{labelSearchScope, tooltipSearchScope, "", defaultValueSearchScope, TRUE},
					{labelBindType, tooltipBindType, "", defaultValueBindType, FALSE},
					{labelBindDn, tooltipBindDn, placeholderBindDn, "", TRUE},
					{labelBindCredential, tooltipBindCredential, placeholderBindCredential, "", TRUE},
					{labelPagination, tooltipPagination, "", defaultValuePagination, TRUE}
			};

			// Loop through each field and validate
			for (String[] field : fieldDetails) {
				String label = field[0];
				String tooltip = field[1];
				String placeholder = field[2];
				String defaultValue = field[3];
				String enabled = field[4];

				flag=validateField(driver, label, tooltip, placeholder, defaultValue, Boolean.parseBoolean(enabled));
			}

			validateCheckboxOfFederation(false, false, true, false);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " validateDefaultFieldsOfFederations :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	private boolean validateField(WebDriver driver, String label, String tooltip, String placeholder, String defaultValue, boolean enabled) {
		boolean flag = true;
		try {
			validateElement(driver, returnElement(detailsDynamicLabel, dynamicName, label), label, labelContent);
			validateElement(driver, returnElement(detailsDynamicInputField, dynamicName, label), label, fieldContent);

			checkFieldIsEnabledOrNot(label, enabled);

			BaseSuite.reportLog("Veifying "+label+" tooltip content");

			checkExpectedValueWithActual(driver, flag, returnElement(detailsDynamicTooltip, dynamicName, label), label, tooltip, true, attributeContent);

			verifyPlaceHolderValue(driver, returnElement(detailsDynamicInputField, dynamicName, label), label, placeholder);
			verifyDefaultValue(returnElement(detailsDynamicInputField, dynamicName, label), label, defaultValue);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " validateField :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	private boolean verifyDefaultValue(By element, String label, String defaultValue) {
		boolean flag = true;
		try {
			if(!defaultValue.isEmpty()) {
				String actualValue =getAttribute(driver, element, attributeValue);
				BaseSuite.reportLog("Expected Default value : "+defaultValue);
				BaseSuite.reportLog("Retrieved Default value : "+actualValue);

				if (!actualValue.trim().equalsIgnoreCase(defaultValue)) {
					BaseSuite.reportFailLog(label + " Default value mismatch. Expected: " + defaultValue + ", Found: " + actualValue, "verifyDefaultValue");
				}else {
					BaseSuite.validationReportLog("Default value matched successfully.");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " verifyDefaultValue :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	public boolean searchLdapNameOnEachPageAndClickOn(By locator,String name, boolean clickOn) {

		boolean flag=false;
		boolean nextpageFlag=true;
		int pn=0;

		try {

			do {

				BaseSuite.reportLog("searching ldap name : "+name+" on page number :"+(pn+1));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 3, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportLog("ldap name : "+name+" found on page number :"+(pn+1));

					if(clickOn) {
						clickOnButton(driver, locator, name, true);
					}
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					flag=true;
					break;
				}
				if(isDisplayed(driver, listingnextPageArrow)) {

					String status = getAttribute(driver, listingnextPageArrow, attributeClass);

					if (!status.contains("disable")) {

						clickOnButton(driver, listingnextPageArrow, "next page", true);
						pn++;
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					} else {
						BaseSuite.reportLog("Page arrow :: next page is disabled");
						nextpageFlag=false;

					}

				}

			}while(nextpageFlag);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchLdapNameOnEachPageAndClickOn :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean searchLdapNameAndClickOnLdapName(String ldapName) {
		boolean flag =true;

		try {

			flag=searchFunctionalityMethod(driver, flag, listingsearchBar, listingsearchIcon, placeholderSearchFederation, placeholderSearchFederation,  ldapName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && elementNotVisible(driver, listingnoRecordsToDisplay)) {

				flag=searchLdapNameOnEachPageAndClickOn(returnElement(listingDynamicName, dynamicName, ldapName), ldapName, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}else {
				flag=false;
				BaseSuite.reportFailLog(noRecordsToDisplayContent+isVisibleContent,"searchDisplayNameAndClickOnFieldName");
				searchFunctionalityMethod(driver, flag, listingsearchBar, listingsearchIcon, placeholderSearchFederation, placeholderSearchFederation,  "");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchLdapNameAndClickOnLdapName "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean searchLdapNameOnListingPage(String ldapName) {
		boolean flag =true;

		try {

			flag=searchFunctionalityMethod(driver, flag, listingsearchBar, listingsearchIcon, placeholderSearchFederation, placeholderSearchFederation,  ldapName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && isDisplayed(driver, returnElement(listingDynamicName, dynamicName, ldapName))) {

				flag=false;
				BaseSuite.reportLog(ldapName+" user federation is already exist");

			}else {
				flag=true;
				BaseSuite.reportLog(ldapName+" user federation is not exist");
				searchFunctionalityMethod(driver, flag, listingsearchBar, listingsearchIcon, placeholderSearchFederation, placeholderSearchFederation,  "");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchLdapNameOnListingPage "+e.toString());
			flag=false;
		}

		return flag;
	}


	public boolean validateFederationDetailPageForExisting(DataTestingParameters param, boolean useSuffix) {
		boolean flag = true;
		HomePage hp=new HomePage(driver);
		try {

			BaseSuite.reportLog(hyphenContent+" validating federation details page for existing federation "+hyphenContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			hp.validateNextgenIcedqModuleAndAdministrationSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Federation details page "+hyphenContent);

			validateElement(driver,breadcrumbHome, homeContent, hyperlinkContent);

			validateElement(driver,breadcrumbAdministration, administrationContent, hyperlinkContent);

			validateElement(driver,breadcrumbSecurity, securityContent, labelContent);

			validateElement(driver,breadcrumbFederationsLink, federationsContent, hyperlinkContent);

			validateElement(driver,returnElement(dynamicBreadcrumbName, dynamicName, param.getConsoleDisplayName()), param.getConsoleDisplayName(), labelContent);

			validateElement(driver,returnElement(dynamicBreadcrumbID, dynamicName, param.getConsoleDisplayName()), param.getConsoleDisplayName(), labelContent);

			validateElement(driver,returnElement(detailsDynamicTitle, dynamicName, param.getConsoleDisplayName()), param.getConsoleDisplayName(), attributeTitle);

			validateElement(driver,returnElement(detailsDynamicAvatar, dynamicName, param.getConsoleDisplayName()), param.getConsoleDisplayName(), iconContent);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Federation details page "+hyphenContent);

			validateButtons(driver, detailsButtonCount, 5);

			verifyVisibilityOfButtons(driver, detailsButtonSave, saveContent, false);
			verifyVisibilityOfButtons(driver, detailsButtonTest, "Test", true);	
			verifyVisibilityOfButtons(driver, detailsButtonDiscard, discardContent, false);	
			verifyVisibilityOfButtons(driver, detailsButtonMoreOptions, "More Options", true);	
			verifyVisibilityOfButtons(driver, detailsButtonDelete, deleteContent, true);

			flag=validateFederationFieldsForExisting(param);

			clickOnMappersTab();

			validateMappersListingPage();

			viewMapperDetails(param.getMappers(), true,useSuffix);

			clickOnSettingsTab();

			BaseSuite.reportLog(hyphenContent+" validated federation details page for existing "+hyphenContent);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateFederationDetailPageForExisting :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateFederationFieldsForExisting(DataTestingParameters param) {
		boolean flag = true;
		try {

			String[][] fieldDetails = {
					{labelConsoleDisplayName, tooltipConsoleDisplayName, placeholderConsoleDisplayName, param.getConsoleDisplayName(), TRUE},
					{labelPriority, tooltipPriority, placeholderPriority, param.getPriority(), TRUE},
					{labelEditMode, tooltipEditMode, "", param.getEditMode(), FALSE},
					{labelVendor, tooltipVendor, "", param.getVendor(), FALSE},
					{labelUsernameLdapAttribute, tooltipUsernameLdapAttribute, placeholderUsernameLdapAttribute, param.getUsernameLdapAttribute(), TRUE},
					{labelRdnLdapAttribute, tooltipRdnLdapAttribute, placeholderRdnLdapAttribute, param.getRdnLdapAttribute(), TRUE},
					{labelUuidLdapAttribute, tooltipUUIDldapattribute, placeholderUuidLdapAttribute, param.getUuidLdapAttribute(), TRUE},
					{labelUserObjectClasses, tooltipUserObjectClasses, placeholderUserObjectClasses, param.getUserObjectClasses(), TRUE},
					{labelConnectionUrl, tooltipConnectionUrl, placeholderConnectionUrl, param.getConnectionURL(), TRUE},
					{labelUsersDn, tooltipUsersDn, placeholderUsersDn, param.getUsersDN(), TRUE},
					{labelCustomUserLdapFilter, tooltipCustomUserLdapFilter, placeholderCustomUserLdapFilter, param.getCustomUserLdapFilter(), TRUE},
					{labelSearchScope, tooltipSearchScope, "", param.getSearchScope(), TRUE},
					{labelBindType, tooltipBindType, "", param.getBindType(), FALSE, TRUE},
					{labelBindDn, tooltipBindDn, placeholderBindDn, param.getBindDN(), TRUE},
					{labelBindCredential, tooltipBindCredential, placeholderBindCredential, bindCredentialHiddenValue, TRUE},
					{labelPagination, tooltipPagination, "", param.getPagination(), TRUE}
			};

			// Loop through each field and validate
			for (String[] field : fieldDetails) {
				String label = field[0];
				String tooltip = field[1];
				String placeholder = field[2];
				String defaultValue = field[3];
				String enabled = field[4];

				flag=validateField(driver, label, tooltip, placeholder, defaultValue, Boolean.parseBoolean(enabled));
			}

			validateCheckboxOfFederation(true, Boolean.parseBoolean(param.getLdapEnabledFlag()), Boolean.parseBoolean(param.getImportUsersFlag()), Boolean.parseBoolean(param.getSyncRegistrations()));

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " validateFederationFieldsForExisting :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	public boolean enterValuesToFederationFields(DataTestingParameters param, boolean enable) {
		boolean flag = true;
		try {

			String[][] fieldDetails = {
					{labelConsoleDisplayName, tooltipConsoleDisplayName, placeholderConsoleDisplayName, param.getConsoleDisplayName(), TRUE,fieldEmptyConsoleDisplayName},
					{labelPriority, tooltipPriority, placeholderPriority, param.getPriority(), TRUE,fieldEmptyPriority},
					{labelEditMode, tooltipEditMode, "", param.getEditMode(), FALSE,""},
					{labelVendor, tooltipVendor, "", param.getVendor(), FALSE,""},
					{labelUsernameLdapAttribute, tooltipUsernameLdapAttribute, placeholderUsernameLdapAttribute, param.getUsernameLdapAttribute(), TRUE,fieldEmptyUsernameLdap},
					{labelRdnLdapAttribute, tooltipRdnLdapAttribute, placeholderRdnLdapAttribute, param.getRdnLdapAttribute(), TRUE,fieldEmptyRdnldap},
					{labelUuidLdapAttribute, tooltipUUIDldapattribute, placeholderUuidLdapAttribute, param.getUuidLdapAttribute(), TRUE,fieldEmptyUuidLdap},
					{labelUserObjectClasses, tooltipUserObjectClasses, placeholderUserObjectClasses, param.getUserObjectClasses(), TRUE,fieldEmptyUserObjectClass},
					{labelConnectionUrl, tooltipConnectionUrl, placeholderConnectionUrl, param.getConnectionURL(), TRUE,fieldEmptyConnectionURL},
					{labelUsersDn, tooltipUsersDn, placeholderUsersDn, param.getUsersDN(), TRUE,fieldEmptyUsersDn},
					{labelCustomUserLdapFilter, tooltipCustomUserLdapFilter, placeholderCustomUserLdapFilter, param.getCustomUserLdapFilter(), TRUE, ""},
					{labelSearchScope, tooltipSearchScope, "", param.getSearchScope(), TRUE,""},
					{labelBindType, tooltipBindType, "", param.getBindType(), FALSE, TRUE,""},
					{labelBindDn, tooltipBindDn, placeholderBindDn, param.getBindDN(), TRUE,fieldEmptyBindDn},
					{labelBindCredential, tooltipBindCredential, placeholderBindCredential, param.getBindCredential(), TRUE,fieldEmptyBindCred},
					{labelPagination, tooltipPagination, "", param.getPagination(), TRUE,""}
			};

			// Loop through each field and validate
			for (String[] field : fieldDetails) {
				String label = field[0];
				String tooltip = field[1];
				String placeholder = field[2];
				String defaultValue = field[3];
				String enabled = field[4];
				String validation = field[5];

				if( Boolean.parseBoolean(enabled)) {
					flag=enterValues(driver, label, placeholder, defaultValue, validation);
				}else {
					flag=validateField(driver, label, tooltip, placeholder, defaultValue, Boolean.parseBoolean(enabled));
				}

			}

			validateCheckboxOfFederation(enable, Boolean.parseBoolean(param.getLdapEnabledFlag()), Boolean.parseBoolean(param.getImportUsersFlag()), Boolean.parseBoolean(param.getSyncRegistrations()));

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " enterValuesToFederationFields :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	public boolean enterValuesToFederationFieldsToUpdate(DataTestingParameters param, boolean enable) {
		boolean flag = true;
		try {

			String[][] fieldDetails = {
					{labelConsoleDisplayName, tooltipConsoleDisplayName, placeholderConsoleDisplayName, param.getUpdateConsoleDisplayName(), TRUE,fieldEmptyConsoleDisplayName},
					{labelPriority, tooltipPriority, placeholderPriority, param.getPriority(), TRUE,fieldEmptyPriority},
					{labelEditMode, tooltipEditMode, "", param.getEditMode(), FALSE,""},
					{labelVendor, tooltipVendor, "", param.getVendor(), FALSE,""},
					{labelUsernameLdapAttribute, tooltipUsernameLdapAttribute, placeholderUsernameLdapAttribute, param.getUsernameLdapAttribute(), TRUE,fieldEmptyUsernameLdap},
					{labelRdnLdapAttribute, tooltipRdnLdapAttribute, placeholderRdnLdapAttribute, param.getRdnLdapAttribute(), TRUE,fieldEmptyRdnldap},
					{labelUuidLdapAttribute, tooltipUUIDldapattribute, placeholderUuidLdapAttribute, param.getUuidLdapAttribute(), TRUE,fieldEmptyUuidLdap},
					{labelUserObjectClasses, tooltipUserObjectClasses, placeholderUserObjectClasses, param.getUserObjectClasses(), TRUE,fieldEmptyUserObjectClass},
					{labelConnectionUrl, tooltipConnectionUrl, placeholderConnectionUrl, param.getConnectionURL(), TRUE,fieldEmptyConnectionURL},
					{labelUsersDn, tooltipUsersDn, placeholderUsersDn, param.getUsersDN(), TRUE,fieldEmptyUsersDn},
					{labelCustomUserLdapFilter, tooltipCustomUserLdapFilter, placeholderCustomUserLdapFilter, param.getCustomUserLdapFilter(), TRUE, ""},
					{labelSearchScope, tooltipSearchScope, "", param.getSearchScope(), TRUE,""},
					{labelBindType, tooltipBindType, "", param.getBindType(), FALSE, TRUE,""},
					{labelBindDn, tooltipBindDn, placeholderBindDn, param.getBindDN(), TRUE,fieldEmptyBindDn},
					{labelBindCredential, tooltipBindCredential, placeholderBindCredential, param.getBindCredential(), TRUE,fieldEmptyBindCred},
					{labelPagination, tooltipPagination, "", param.getPagination(), TRUE,""}
			};

			// Loop through each field and validate
			for (String[] field : fieldDetails) {
				String label = field[0];
				String tooltip = field[1];
				String placeholder = field[2];
				String defaultValue = field[3];
				String enabled = field[4];
				String validation = field[5];

				if( Boolean.parseBoolean(enabled)) {
					flag=enterValues(driver, label, placeholder, defaultValue, validation);
				}else {
					flag=validateField(driver, label, tooltip, placeholder, defaultValue, Boolean.parseBoolean(enabled));
				}

			}

			validateCheckboxOfFederation(enable, Boolean.parseBoolean(param.getLdapEnabledFlag()), Boolean.parseBoolean(param.getImportUsersFlag()), Boolean.parseBoolean(param.getSyncRegistrations()));

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " enterValuesToFederationFields :: " + e.toString());
			flag = false;
		}
		return flag;
	}


	public boolean validateCheckboxOfFederation(boolean scenario, boolean enabled, boolean importUsers, boolean syncRegi) {
		CustomFieldsServicePage cp = new CustomFieldsServicePage(driver);
		boolean flag = true;
		try {
			if(scenario) {
				validateElement(driver, returnElement(detailsDynamicLabel, dynamicName, labelEnabled), labelEnabled, labelContent);
				checkExpectedValueWithActual(driver, flag, returnElement(detailsDynamicFieldTooltip, dynamicName, labelEnabled), labelEnabled, tooltipEnabled, true, attributeContent);
				cp.checkboxStatus(returnElement(detailsDynamicFieldCheckbox, dynamicName, labelEnabled), labelEnabled, enabled);
				checkCheckboxIsEnabledOrNot(labelEnabled, true);
			}
			validateElement(driver, returnElement(detailsDynamicLabel, dynamicName, labelImportUsers), labelImportUsers, labelContent);
			checkExpectedValueWithActual(driver, flag, returnElement(detailsDynamicFieldTooltip, dynamicName, labelImportUsers), labelImportUsers, tooltipImportUsers, true, attributeContent);
			cp.checkboxStatus(returnElement(detailsDynamicFieldCheckbox, dynamicName, labelImportUsers), labelImportUsers, importUsers);
			checkCheckboxIsEnabledOrNot(labelImportUsers, false);
			validateElement(driver, returnElement(detailsDynamicLabel, dynamicName, labelSyncRegistration), labelSyncRegistration, labelContent);
			checkExpectedValueWithActual(driver, flag, returnElement(detailsDynamicFieldTooltip, dynamicName, labelSyncRegistration), labelSyncRegistration, tooltipSyncRegistration, true, attributeContent);
			cp.checkboxStatus(returnElement(detailsDynamicFieldCheckbox, dynamicName, labelSyncRegistration), labelSyncRegistration, syncRegi);
			checkCheckboxIsEnabledOrNot(labelSyncRegistration, false);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " validateCheckboxOfFederation :: " + e.toString());
			flag = false;
		}
		return flag;

	}


	public boolean checkFieldIsEnabledOrNot(String label, boolean expected) {
		boolean flag = true;
		try {

			BaseSuite.reportLog("Verifying state of input is enabled or not  for field : "+label);

			String elementToCheck = expected ? detailsDynamicInputFieldEnabled : detailsDynamicInputFieldDisabled;

			if (isDisplayed(driver, returnElement(elementToCheck, dynamicName, label))) {

				BaseSuite.validationReportLog(label + " field is " + (expected ? ENABLED : DISABLED));

			} else {
				BaseSuite.reportFailLog(label + " field is " + (expected ? DISABLED : ENABLED) + " not matched with expected condition ", "checkFieldIsEnabledOrNot");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " checkFieldIsEnabledOrNot :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	public boolean checkCheckboxIsEnabledOrNot(String label, boolean expected) {
		boolean flag = true;
		try {

			BaseSuite.reportLog("Verifying state of checkbox is enabled or not  for field : "+label);

			String elementToCheck = expected ? detailsDynamicInputCheckboxEnabled : detailsDynamicInputCheckboxDisabled;

			if (isDisplayed(driver, returnElement(elementToCheck, dynamicName, label))) {

				BaseSuite.validationReportLog(label + " checkbox is " + (expected ? ENABLED : DISABLED));

			} else {
				BaseSuite.reportFailLog(label + " checkbox is " + (expected ? DISABLED : ENABLED) + " not matched with expected condition", "checkCheckboxIsEnabledOrNot");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " checkCheckboxIsEnabledOrNot :: " + e.toString());
			flag = false;
		}
		return flag;
	}


	public boolean selectDynamicFieldValuesOfFederation(String label, String inputSelect) {

		boolean flag = true;
		try {

			BaseSuite.reportLog(verifyingContent+label+" field dropdown is visible or not");

			isDisplayedInLoop(driver, 0, returnElement(detailsDynamicInputFieldDropDown, dynamicName, label));

			if(isDisplayed(driver, returnElement(detailsDynamicInputFieldDropDown, dynamicName, label))) {

				BaseSuite.validationReportLog(label+" field dropdown is visible");

				BaseSuite.reportLog(clickingOnContent+label+"  field dropdown");

				displayAndClick(driver, returnElement(detailsDynamicInputFieldDropDown, dynamicName, label));

				BaseSuite.validationReportLog(clickedOnContent+label+"  field dropdown");

				BaseSuite.reportLog(verifyingContent+inputSelect+" value in dropdown is visible or not");

				isDisplayedInLoop(driver, 0, returnElement(detailsDynamicInputFieldDropDownSelect, dynamicName, inputSelect));

				if(isDisplayed(driver, returnElement(detailsDynamicInputFieldDropDownSelect, dynamicName, inputSelect))) {

					BaseSuite.validationReportLog(inputSelect+" value is visible in  dropdown list");

					BaseSuite.reportLog("Selecting "+inputSelect+" value from dropdown");

					displayAndClick(driver, returnElement(detailsDynamicInputFieldDropDownSelect, dynamicName, inputSelect));

					BaseSuite.validationReportLog("Selected "+inputSelect+" value from dropdown");
				}else {

					BaseSuite.reportFailLog(inputSelect + " value is not visible", "selectDynamicFieldValuesOfFederation");
					flag=false;
				}
			}else {
				BaseSuite.reportFailLog(label + " field is not visible", "selectDynamicFieldValuesOfFederation");		
				flag=false;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " selectDynamicFieldValuesOfFederation :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	private boolean enterValues(WebDriver driver, String label,String placeholder, String inputValue,String fieldValid) {
		boolean flag = true;
		try {

			log.info(fieldValid);

			switch(label.toLowerCase().trim()) {

			case "edit mode":
			case "vendor":
			case "bind type":	
				break;
			case "search scope":					
			case "pagination":

				flag=selectDynamicFieldValuesOfFederation(label, inputValue);

				break;
			default:

				flag=validatAndeEnterValueToTextField(driver, returnElement(detailsDynamicLabel, dynamicName, label), 
						returnElement(detailsDynamicInputField, dynamicName, label), 
						returnElement(detailsDynamicValidation, dynamicName, label), 
						label, placeholder, inputValue, "");

				break;
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " enterValues :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	public boolean clickOnSaveButtonAndValidateToast(String expectedToastMessage) {
		boolean tag =true;
		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, detailsButtonSave, saveContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Federation Created");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Federation Created");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnSaveButtonAndValidateToast :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean clickOnDeleteFederationButtonAndValidateToast(String expectedToastMessage, String icedqUser) {
		boolean tag =true;
		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, detailsButtonDelete, deleteContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

				validatePopupWindowContent(driver, flag, federationDetailsDeletePoupupTitle, federationDetailsDeletePoupupContent, popuupDeleteFedTitle, popuupDeleteFedContent);

				verifyVisibilityOfButtons(driver, federationDetailsDeletePoupupDeleteButton, deleteContent, true);
				verifyVisibilityOfButtons(driver, federationDetailsDeletePoupupCancelButton, cancelButtonContent, true);

				flag=clickOnButton(driver, federationDetailsDeletePoupupDeleteButton, deleteContent, tag);

			}

			if(isDisplayed(driver, toastMsg) && flag) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Federation deleted");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Federation deleted");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnDeleteFederationButtonAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnTestFederationButtonAndValidateToast(String expectedToastMessage, String icedqUser) {
		boolean tag =true;
		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

				flag=clickOnButton(driver, detailsButtonTest, "Test", true);

				if(isDisplayed(driver, toastMsg) && flag) {

					flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Federation tested");
					tag=false;
				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(tag && !expectedToastMessage.isEmpty()) {
					flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Federation tested");
				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnTestFederationButtonAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}


	public boolean validateFederationOnListingPage(DataTestingParameters param, boolean updated) {

		boolean flag=true;
		String ldapName="";
		String enabled="";
		try {

			ldapName = updated ? param.getUpdateConsoleDisplayName() : param.getConsoleDisplayName();
			enabled = Boolean.parseBoolean(param.getLdapEnabledFlag()) ? "ACTIVE" : "INACTIVE";

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=searchFunctionalityMethod(driver, flag,listingsearchBar, listingsearchIcon, placeholderSearchFederation, placeholderSearchFederation,  ldapName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {

				validateElement(driver,returnElement(listingDynamicCheckbox, dynamicName, ldapName), ldapName, checkboxContent);

				validateElement(driver, returnElement(listingDynamicAvatar, dynamicName, ldapName), ldapName, iconContent);

				validateValueWithActual(driver, returnElement(listingDynamicName, dynamicName, ldapName), "Name", ldapName, attributeTextContent);

				validateValueWithActual(driver, returnElement(listingDynamicEnabled, dynamicName, ldapName), "Enabled", enabled, attributeTextContent);

				validateValueWithActual(driver, returnElement(listingDynamicProvider, dynamicName, ldapName), "Provider", "ldap", attributeTextContent);

			}

		}catch (Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" validateFederationOnListingPage :: "+e.toString());
			flag=false;
		}

		return flag;
	}


	public boolean validateDeletedFederationOnListingPage(String ldapName) {

		boolean flag=true;

		try {

			flag=searchFunctionalityMethod(driver, flag,listingsearchBar, listingsearchIcon, placeholderSearchFederation, placeholderSearchFederation,  ldapName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && !isDisplayed(driver, returnElement(listingDynamicName, dynamicName, ldapName))) {

				BaseSuite.validationReportLog("Deleted federation not visible on listing page : "+ldapName);

			}else if(isDisplayed(driver, returnElement(listingDynamicName, dynamicName, ldapName))){

				BaseSuite.reportFailLog("Deleted federation is visible on listing page : "+ldapName, "validateDeletedFederationOnListingPage");

			}

		}catch (Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" validateDeletedFederationOnListingPage :: "+e.toString());
			flag=false;
		}

		return flag;
	}
	public boolean createFederationForValid(DataTestingParameters param, String icedqUser) {

		boolean flag=true;
		try {

			flag=clickOnNewFederationButton(icedqUser);

			if(flag) {

				enterValuesToFederationFields(param, false);

				flag=clickOnSaveButtonAndValidateToast(toastLdapCreated);

				if(flag && Boolean.parseBoolean(param.getLdapEnabledFlag())) {
					selectcheckbox(driver,returnElement(detailsDynamicFieldCheckbox, dynamicName, labelEnabled), labelEnabled);
					flag=clickOnSaveButtonAndValidateToast("");

				}
				if(flag) {

					testFederationForValid(icedqUser);
				}

				clickOnUserFederationsTab();

				flag=validateFederationOnListingPage(param, false);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" createFederationForValid :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean updateFederationForValid(DataTestingParameters param, String icedqUser) {

		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

				if(Boolean.parseBoolean(param.getLdapEnabledFlag())) {

					selectcheckbox(driver,returnElement(detailsDynamicFieldCheckbox, dynamicName, labelEnabled), labelEnabled);

				}else {
					unselectcheckbox(driver,returnElement(detailsDynamicFieldCheckbox, dynamicName, labelEnabled), labelEnabled);
				}

				enterValuesToFederationFieldsToUpdate(param, Boolean.parseBoolean(param.getLdapEnabledFlag()));

				flag=clickOnSaveButtonAndValidateToast("");

				if(flag) {

					testFederationForValid(icedqUser);
				}

				clickOnUserFederationsTab();

				flag=validateFederationOnListingPage(param, true);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" updateFederationForValid :: "+e.toString());
			flag=false;
		}
		return flag;

	}


	public boolean deleteFederationForValid(String ldapName, String icedqUser) {

		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

				clickOnDeleteFederationButtonAndValidateToast(toastLdapDeleted, icedqUser);

				clickOnUserFederationsTab();

				flag=validateDeletedFederationOnListingPage(ldapName);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" deleteFederationForValid :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean testFederationForValid(String icedqUser) {

		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

				flag=clickOnTestFederationButtonAndValidateToast(toastLdapTested, icedqUser);	
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" deleteFederationForValid :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean clickOnMappersTab() {

		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 0, mappersTab);

			if(isDisplayed(driver, mappersTab)) {

				javascript(driver, scrollToElementArg, mappersTab);

				BaseSuite.reportLog("Mappers tab is visible");

				String state = getAttribute(driver, returnElement(ldapDynamicTab, dynamicName, mappersContent), "aria-selected");

				if(state.equalsIgnoreCase(FALSE)) {

					BaseSuite.reportLog("Clicking on mappers tab");

					displayAndClick(driver, mappersTab);

					BaseSuite.validationReportLog("Clicked on mappers tab");

				}else if(state.equalsIgnoreCase(TRUE)){

					BaseSuite.reportLog("Mappers tab already active");
				}

			}else {

				BaseSuite.reportFailLog("Mappers tab not visible on page", "clickOnMappersTab"); 
				flag=false;
			}
			
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnMappersTab :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean clickOnSettingsTab() {
		String settingsCont="Settings";
		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 0, returnElement(ldapDynamicTab, dynamicName, settingsCont));

			if(isDisplayed(driver, returnElement(ldapDynamicTab, dynamicName, settingsCont))) {

				javascript(driver, scrollToElementArg, returnElement(ldapDynamicTab, dynamicName, settingsCont));

				BaseSuite.reportLog("Settings tab is visible");

				String state = getAttribute(driver, returnElement(ldapDynamicTab, dynamicName, settingsCont), "aria-selected");

				if(state.equalsIgnoreCase(FALSE)) {

					BaseSuite.reportLog("Clicking on Settings tab");

					displayAndClick(driver, returnElement(ldapDynamicTab, dynamicName, settingsCont));

					BaseSuite.validationReportLog("Clicked on Settings tab");

				}else if(state.equalsIgnoreCase(TRUE)){

					BaseSuite.reportLog("Settings tab already active");
				}

			}else {

				BaseSuite.reportFailLog("Settings tab not visible on page", "clickOnSettingsTab"); 
				flag=false;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnSettingsTab :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateMappersListingPage() {

		boolean flag=true;
		try {

			BaseSuite.reportLog(hyphenContent+" validating mappers tab "+hyphenContent);

			verifySearchField(driver, mapperssearchBar, placeholderSearchMappers, placeholderSearchMappers);

			validateElement(driver,mapperssearchIcon, placeholderSearchMappers, iconContent);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on mappers tab "+hyphenContent);

			validateButtons(driver, mappersListingButtonCount, 3);

			verifyVisibilityOfButtons(driver, mappersListingButtonNewMapper, "New Mapper", true);
			verifyVisibilityOfButtons(driver, mappersListingButtonRefresh, refreshContent, true);
			verifyVisibilityOfButtons(driver, mappersListingButtonDelete, deleteContent, false);

			BaseSuite.reportLog(hyphenContent+"  Verifying Columns on mappers tab "+hyphenContent);

			validateElement(driver, mappersmasterCheckbox, "Master", checkboxContent);
			validateElement(driver,mapperscolumnName, "Name",columnContent);
			validateElement(driver,mapperscolumnType, "Type", columnContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on mappers tab "+hyphenContent);

			getPaginationDetails(driver,mapperslistingpaginationInfo, mapperslistingpaginationBar,listingnoRecordsToDisplay, "Mappers listing page");

			BaseSuite.validationReportLog(hyphenContent+" mappers tab page validated successfully "+hyphenContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateMappersListingPage :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean searchMappersNameAndValidateOnMappersTab(String mapperName, String type) {
		boolean flag =true;

		try {

			flag=searchFunctionalityMethod(driver, flag, mapperssearchBar, mapperssearchIcon, placeholderSearchMappers, placeholderSearchMappers,  mapperName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && isDisplayed(driver, returnElement(mappersDynamicName, dynamicName, mapperName))) {

				validateElement(driver,returnElement(mappersDynamicCheckbox, dynamicName, mapperName), mapperName, checkboxContent);

				validateElement(driver, returnElement(mappersDynamicAvatar, dynamicName, mapperName), mappersContent, iconContent);

				validateValueWithActual(driver, returnElement(mappersDynamicName, dynamicName, mapperName), "Name", mapperName, attributeTextContent);

				validateValueWithActual(driver, returnElement(mappersDynamicType, dynamicName, mapperName), "Type", type, attributeTextContent);

			}else {
				flag=false;
				BaseSuite.reportFailLog(mapperName+" mapper is not exist","searchMappersNameOnMappersTab");
				searchFunctionalityMethod(driver, flag, mapperssearchBar, mapperssearchBar, placeholderSearchMappers, placeholderSearchMappers,  "");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchMappersNameOnMappersTab "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean searchMappersNameAndClickOnName(String mapperName) {
		boolean flag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=searchFunctionalityMethod(driver, flag, mapperssearchBar, mapperssearchIcon, placeholderSearchMappers, placeholderSearchMappers,  mapperName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && isDisplayed(driver, returnElement(mappersDynamicName, dynamicName, mapperName))) {

				flag=clickOnButton(driver, returnElement(mappersDynamicName, dynamicName, mapperName), mapperName, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}else {

				BaseSuite.reportFailLog(mapperName+" mapper is not visible","searchMappersNameAndClickOnName");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchMappersNameAndClickOnName "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean searchMappersNameAndValidateDeletedOrNot(String mapperName) {
		boolean flag =true;

		try {

			flag=searchFunctionalityMethod(driver, flag, mapperssearchBar, mapperssearchIcon, placeholderSearchMappers, placeholderSearchMappers,  mapperName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && !isDisplayed(driver, returnElement(mappersDynamicName, dynamicName, mapperName))) {

				BaseSuite.validationReportLog(mapperName+" mapper is not exist");
				
			}else {
				flag=false;
				BaseSuite.reportFailLog(mapperName+" mapper is exist","searchMappersNameAndValidateDeletedOrNot");
				
				searchFunctionalityMethod(driver, flag, mapperssearchBar, mapperssearchBar, placeholderSearchMappers, placeholderSearchMappers,  "");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchMappersNameAndValidateDeletedOrNot "+e.toString());
			flag=false;
		}

		return flag;
	}


	public boolean viewMapperDetails(String mappers, boolean check, boolean useSuffix) {
		String[] mapper=null;
		boolean flag =true;

		try {

			if (!mappers.isEmpty() && check) {

				if (mappers.contains(",")) {

					mapper = mappers.split(",");

					for (int i = 0; i < mapper.length; i++) {

						DataTestingParameters mparam = setMappersParamUsingExcel(FEDERATIONEXCELPATH, mapper[i], useSuffix);

						flag=searchMappersNameAndValidateOnMappersTab(mparam.getMapperName(), mparam.getMapperType());

					}

				} else {

					DataTestingParameters mparam = setMappersParamUsingExcel(FEDERATIONEXCELPATH, mappers,useSuffix);

					flag=searchMappersNameAndValidateOnMappersTab(mparam.getMapperName(), mparam.getMapperType());

				}
				displayAndClick(driver, mapperssearchBar);
				displayAndClick(driver, mapperssearchClear);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewMapperDetails "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean clickOnNewMapperButton(String icedqUser) {

		boolean flag = true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 3, mappersListingButtonNewMapper);

			if(isDisplayed(driver, mappersListingButtonNewMapper)) {

				clickOnButton(driver, mappersListingButtonNewMapper, "New Mapper", flag);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

					flag=validateElement(driver, returnElement(mappersDetailsBreadcrumbLabel, dynamicName, defaultNameForMapper), defaultNameForMapper, labelContent);

				}else{

					flag = captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
							"New Mapper authorization message");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnNewMapperButton :: "+e.toString());
			flag=false;
		}

		return flag;
	}


	public boolean validateMapperDetailPageBeforeCreating() {
		boolean flag = true;

		try {

			BaseSuite.reportLog(hyphenContent+" validating mapper details page before creating "+hyphenContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on mapper details page "+hyphenContent);

			validateElement(driver,mappersBreadcrumbLink, mappersContent, hyperlinkContent);

			validateElement(driver, returnElement(mappersDetailsBreadcrumbLabel, dynamicName, defaultNameForMapper), defaultNameForMapper, labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on mappers details page "+hyphenContent);

			validateButtons(driver, mappersDetailsButtonCount, 3);

			verifyVisibilityOfButtons(driver, mappersDetailsButtonSave, saveContent, false);
			verifyVisibilityOfButtons(driver, mappersDetailsButtonDiscard, discardContent, false);	
			verifyVisibilityOfButtons(driver, mappersDetailsButtonDelete, deleteContent, false);	

			validateFieldForMapper(driver, mapperLabelName, mapperTooltipName, mapperPlaceholderName, "", true);
			validateFieldForMapper(driver, mapperLabelType, mapperTooltipType, mapperPlaceholderType, "", true);

			BaseSuite.reportLog(hyphenContent+" validated mapper details page "+hyphenContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateMapperDetailPageBeforeCreating :: "+e.toString());
			flag=false;
		}
		return flag;
	}


	public boolean enterValuesToMapperFields(DataTestingParameters param) {
		boolean flag = true;
		String[][] fieldDetails=new String[0][];
		try {

			if(param.getMapperType().equalsIgnoreCase(GROUPLDAPMAPPER)) {

				fieldDetails = new String[][]{
					{mapperLabelName, mapperTooltipName, mapperPlaceholderName, param.getMapperName(), TRUE,""},
					{mapperLabelType, mapperTooltipType, mapperPlaceholderType, param.getMapperType(), TRUE,""}


				};
			}else if(param.getMapperType().equalsIgnoreCase(USERLDAPMAPPER)){

				fieldDetails = new String[][]{
					{mapperLabelName, mapperTooltipName, mapperPlaceholderName, param.getMapperName(), TRUE,""},
					{mapperLabelType, mapperTooltipType, mapperPlaceholderType, param.getMapperType(), TRUE,""},
					{mapperLabelUserModel,mapperTooltipUserModel,mapperPlaceholderUserModel, param.getUserModel(), TRUE,""},
					{mapperLabelLdapAttribute, mapperTooltipLdapAttribute, mapperPlaceholderLdapAttribute, param.getLdapAttribute(), TRUE,""}
				};
			}


			// Loop through each field and validate
			for (String[] field : fieldDetails) {
				String label = field[0];
				/**	String tooltip = field[1];**/
				String placeholder = field[2];
				String defaultValue = field[3];

				flag=enterMapperValues(driver, label, placeholder, defaultValue, "");

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " enterValuesToMapperFields :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	private boolean enterMapperValues(WebDriver driver, String label,String placeholder, String inputValue,String fieldValid) {
		boolean flag = true;
		try {

			log.info(fieldValid);

			switch(label.toLowerCase().trim()) {

			case "edit mode":
			case "vendor":
			case "mapper type":	
				flag=selectDynamicFieldValuesOfMapper(label, inputValue);
				break;
			case "search scope":					
			case "pagination":

				

				break;
			default:

				flag=validatAndeEnterValueToTextField(driver, returnElement(mapperDynamicLabel, dynamicName, label), 
						returnElement(mapperDynamicInputField, dynamicName, label), 
						returnElement(mapperDynamicValidation, dynamicName, label), 
						label, placeholder, inputValue, "");

				break;
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " enterMapperValues :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	public boolean viewValuesToMapperFields(DataTestingParameters param) {
		boolean flag = true;
		String[][] fieldDetails=new String[0][];
		try {

			if(param.getMapperType().equalsIgnoreCase(GROUPLDAPMAPPER)) {

				fieldDetails = new String[][]{
					{mapperLabelName, mapperTooltipName, mapperPlaceholderName, param.getMapperName(), TRUE,""},
					{mapperLabelType, mapperTooltipType, mapperPlaceholderType, param.getMapperType(), TRUE,""}


				};
			}else if(param.getMapperType().equalsIgnoreCase(USERLDAPMAPPER)){

				fieldDetails = new String[][]{
					{mapperLabelName, mapperTooltipName, mapperPlaceholderName, param.getMapperName(), FALSE,""},
					{mapperLabelType, mapperTooltipType, mapperPlaceholderType, param.getMapperType(), FALSE,""},
					{mapperLabelUserModel,mapperTooltipUserModel,mapperPlaceholderUserModel, param.getUserModel(), TRUE,""},
					{mapperLabelLdapAttribute, mapperTooltipLdapAttribute, mapperPlaceholderLdapAttribute, param.getLdapAttribute(), TRUE,""}
				};
			}


			// Loop through each field and validate
			for (String[] field : fieldDetails) {
				String label = field[0];
				String tooltip = field[1];
				String placeholder = field[2];
				String defaultValue = field[3];
				String enabled=field[4];

				flag=validateFieldForMapper(driver, label, tooltip, placeholder, defaultValue, Boolean.parseBoolean(enabled));

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " viewValuesToMapperFields :: " + e.toString());
			flag = false;
		}
		return flag;
	}


	private boolean validateFieldForMapper(WebDriver driver, String label, String tooltip, String placeholder, String defaultValue, boolean enabled) {
		boolean flag = true;
		try {
			validateElement(driver, returnElement(mapperDynamicLabel, dynamicName, label), label, labelContent);
			validateElement(driver, returnElement(mapperDynamicInputField, dynamicName, label), label, fieldContent);

			checkFieldIsEnabledOrNotForMapper(label, enabled);

			BaseSuite.reportLog("Veifying "+label+" tooltip content");

			checkExpectedValueWithActual(driver, flag, returnElement(mapperDynamicTooltip, dynamicName, label), label, tooltip, true, attributeContent);

			verifyPlaceHolderValue(driver, returnElement(mapperDynamicInputField, dynamicName, label), label, placeholder);
			verifyDefaultValue(returnElement(mapperDynamicInputField, dynamicName, label), label, defaultValue);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " validateFieldForMapper :: " + e.toString());
			flag = false;
		}
		return flag;
	}


	public boolean checkFieldIsEnabledOrNotForMapper(String label, boolean expected) {
		boolean flag = true;
		try {

			BaseSuite.reportLog("Verifying state of input is enabled or not  for field : "+label);

			String elementToCheck = expected ? mapperDynamicInputFieldEnabled : mapperDynamicInputFieldDisabled;

			if (isDisplayed(driver, returnElement(elementToCheck, dynamicName, label))) {

				BaseSuite.validationReportLog(label + " field is  " + (expected ? ENABLED : DISABLED));

			} else {
				BaseSuite.reportFailLog(label + " field is  " + (expected ? DISABLED : ENABLED) + " not matched with expected condition", "checkFieldIsEnabledOrNotForMapper");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " checkFieldIsEnabledOrNotForMapper :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	public boolean selectDynamicFieldValuesOfMapper(String label, String inputSelect) {

		boolean flag = true;
		try {

			BaseSuite.reportLog(verifyingContent+label+" field dropdown is visible or not");

			isDisplayedInLoop(driver, 0, returnElement(mapperDynamicInputFieldDropDown, dynamicName, label));

			if(isDisplayed(driver, returnElement(mapperDynamicInputFieldDropDown, dynamicName, label))) {

				BaseSuite.validationReportLog(label+" field dropdown is visible");

				BaseSuite.reportLog(clickingOnContent+label+" field dropdown");

				displayAndClick(driver, returnElement(mapperDynamicInputFieldDropDown, dynamicName, label));

				BaseSuite.validationReportLog(clickedOnContent+label+" field dropdown");

				BaseSuite.reportLog(verifyingContent+inputSelect+" value in dropdown is visible or not");

				isDisplayedInLoop(driver, 0, returnElement(mapperDynamicInputFieldDropDownSelect, dynamicName, inputSelect));

				if(isDisplayed(driver, returnElement(mapperDynamicInputFieldDropDownSelect, dynamicName, inputSelect))) {

					BaseSuite.validationReportLog(inputSelect+" value is visible in  dropdown list");

					BaseSuite.reportLog("Selecting "+inputSelect+" value from  dropdown");

					displayAndClick(driver, returnElement(mapperDynamicInputFieldDropDownSelect, dynamicName, inputSelect));

					BaseSuite.validationReportLog("Selected "+inputSelect+" value from  dropdown");
				}else {

					BaseSuite.reportFailLog(inputSelect + " value is not visible", "selectDynamicFieldValuesOfMapper");
					flag=false;
				}
			}else {
				BaseSuite.reportFailLog(label + " field is not visible", "selectDynamicFieldValuesOfMapper");		
				flag=false;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " selectDynamicFieldValuesOfMapper :: " + e.toString());
			flag = false;
		}
		return flag;
	}


	public boolean clickOnSaveButtonOfMapperAndValidateToast(String expectedToastMessage) {
		boolean tag =true;
		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, mappersDetailsButtonSave, saveContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Mapper Created");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Mapper Created");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnSaveButtonOfMapperAndValidateToast :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean clickOnDeleteMapperButtonAndValidateToast(String expectedToastMessage, String icedqUser) {
		boolean tag =true;
		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, mappersDetailsButtonDelete, deleteContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

				validatePopupWindowContent(driver, flag, federationDetailsDeletePoupupTitle, federationDetailsDeletePoupupContent, popuupDeleteMapperTitle, popuupDeleteMapperContent);

				verifyVisibilityOfButtons(driver, federationDetailsDeletePoupupDeleteButton, deleteContent, true);
				verifyVisibilityOfButtons(driver, federationDetailsDeletePoupupCancelButton, cancelButtonContent, true);

				flag=clickOnButton(driver, federationDetailsDeletePoupupDeleteButton, deleteContent, tag);

			}

			if(isDisplayed(driver, toastMsg) && flag) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Mapper deleted");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Mapper deleted");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnDeleteMapperButtonAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean createMapperInExistingFederation(DataTestingParameters param, String icedqUser, boolean useSuffix) {
		boolean flag = true;
		try {
			clickOnMappersTab();
			validateMappersListingPage();

			String[] customMappers = param.getCustomMappers().split(",");

			for (String mapper : customMappers) {
				flag = processMapperCreation(mapper, icedqUser,useSuffix);
				
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " createMapperInExistingFederation :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	private boolean processMapperCreation(String mapper, String icedqUser, boolean useSuffix) {
		boolean flag;
		try {
			flag = clickOnNewMapperButton(icedqUser);
			if (!flag) return false;

			validateMapperDetailPageBeforeCreating();

			DataTestingParameters mparam = setMappersParamUsingExcel(FEDERATIONEXCELPATH, mapper,useSuffix);
			enterValuesToMapperFields(mparam);

			flag = clickOnSaveButtonOfMapperAndValidateToast(toastMapperCreated);
			if (!flag) return false;

			clickOnButton(driver, mappersBreadcrumbLink, mappersContent, true);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag = searchMappersNameAndValidateOnMappersTab(mparam.getMapperName(), mparam.getMapperType());
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " processMapperCreation :: " + e.toString());
			flag = false;
		}
		return flag;
	}


	public boolean viewMapperInExistingFederation(DataTestingParameters param, boolean useSuffix) {
		boolean flag = true;
		try {
			clickOnMappersTab();
			validateMappersListingPage();

			String[] customMappers = param.getCustomMappers().split(",");

			for (String mapper : customMappers) {
				
				DataTestingParameters mparam = setMappersParamUsingExcel(FEDERATIONEXCELPATH, mapper,useSuffix);
				flag = searchMappersNameAndClickOnName(mparam.getMapperName());
				
				if(flag) {
				flag = viewValuesToMapperFields(mparam);
				}
				
				if (!navigateToMapperListPage()) {
					flag = false;
					break;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " viewMapperInExistingFederation :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	private boolean navigateToMapperListPage() {
		try {
			clickOnButton(driver, mappersBreadcrumbLink, mappersContent, true);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			return true;
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " navigateToMapperListPage :: " + e.toString());
			return false;
		}
	}
	
	/**   **/
	
	
	public boolean updateMapperInExistingFederation(DataTestingParameters param, boolean useSuffix) {
		boolean flag = true;
		try {
			clickOnMappersTab();
			validateMappersListingPage();

			String[] customMappers = param.getUpdateMappers().split(",");
			
			for (String mapper : customMappers) {
				flag = processMapperUpdation(mapper,useSuffix);
				
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " updateMapperInExistingFederation :: " + e.toString());
			flag = false;
		}
		return flag;
	}
	
	private boolean processMapperUpdation(String mapper, boolean useSuffix) {
		boolean flag;
		try {


			DataTestingParameters mparam = setMappersParamUsingExcel(FEDERATIONEXCELPATH, mapper, useSuffix);
			DataTestingParameters umparam = setUpdateMappersParamUsingExcel(FEDERATIONEXCELPATH, mapper,useSuffix);

			flag = searchMappersNameAndClickOnName(mparam.getMapperName());
			if(flag) {

				updateValuesToMapperFields(umparam); 

				flag = clickOnSaveButtonOfMapperAndValidateToast("");

				if (!flag) return false;

				clickOnButton(driver, mappersBreadcrumbLink, mappersContent, true);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " processMapperUpdation :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	private boolean updateMapperValues(WebDriver driver, String label,String placeholder, String inputValue,boolean enabled,String fieldValid) {
		boolean flag = true;
		try {

			log.info(fieldValid+enabled);

			switch(label.toLowerCase().trim()) {

			case "mapper type":	
			case "name":
				
				break;
		
			default:

				flag=validatAndeEnterValueToTextField(driver, returnElement(mapperDynamicLabel, dynamicName, label), 
						returnElement(mapperDynamicInputField, dynamicName, label), 
						returnElement(mapperDynamicValidation, dynamicName, label), 
						label, placeholder, inputValue, "");

				break;
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " updateMapperValues :: " + e.toString());
			flag = false;
		}
		return flag;
	}
	
	public boolean updateValuesToMapperFields(DataTestingParameters param) {
		boolean flag = true;
		String[][] fieldDetails=new String[0][];
		try {

			if(param.getMapperType().equalsIgnoreCase(GROUPLDAPMAPPER)) {

				fieldDetails = new String[][]{
					{mapperLabelName, mapperTooltipName, mapperPlaceholderName, param.getMapperName(), TRUE,""},
					{mapperLabelType, mapperTooltipType, mapperPlaceholderType, param.getMapperType(), TRUE,""}


				};
			}else if(param.getMapperType().equalsIgnoreCase(USERLDAPMAPPER)){

				fieldDetails = new String[][]{
					{mapperLabelName, mapperTooltipName, mapperPlaceholderName, param.getMapperName(), FALSE,""},
					{mapperLabelType, mapperTooltipType, mapperPlaceholderType, param.getMapperType(), FALSE,""},
					{mapperLabelUserModel,mapperTooltipUserModel,mapperPlaceholderUserModel, param.getUserModel(), TRUE,""},
					{mapperLabelLdapAttribute, mapperTooltipLdapAttribute, mapperPlaceholderLdapAttribute, param.getLdapAttribute(), TRUE,""}
				};
			}


			// Loop through each field and validate
			for (String[] field : fieldDetails) {
				String label = field[0];
			/**	String tooltip = field[1];**/
				String placeholder = field[2];
				String defaultValue = field[3];
				String enabled=field[4];
				String fieldValid=field[5];
				
				flag=updateMapperValues(driver, label, placeholder, defaultValue, Boolean.parseBoolean(enabled), fieldValid);

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " updateValuesToMapperFields :: " + e.toString());
			flag = false;
		}
		return flag;
	}
	
	public boolean deleteMapperInExistingFederation(DataTestingParameters param,String icedqUser, boolean useSuffix) {
		boolean flag = true;
		try {
			clickOnMappersTab();
			validateMappersListingPage();

			String[] customMappers = param.getUpdateMappers().split(",");
			
			for (String mapper : customMappers) {
				flag = processMapperDeletion(mapper,icedqUser,useSuffix);
			
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " deleteMapperInExistingFederation :: " + e.toString());
			flag = false;
		}
		return flag;
	}
	
	private boolean processMapperDeletion(String mapper,String icedqUser, boolean useSuffix) {
		boolean flag;
		try {


			DataTestingParameters mparam = setMappersParamUsingExcel(FEDERATIONEXCELPATH, mapper, useSuffix);
		
			flag = searchMappersNameAndClickOnName(mparam.getMapperName());
			if(flag) {

				flag = clickOnDeleteMapperButtonAndValidateToast(toastMapperDeleted,icedqUser);

				if (!flag) return false;

				clickOnMappersTab();
				
				flag=searchMappersNameAndValidateDeletedOrNot(mparam.getMapperName());

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " processMapperDeletion :: " + e.toString());
			flag = false;
		}
		return flag;
	}

}
