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

public class IdentityProvidersServicePage extends PageUtil {

	WebDriver driver;

	public IdentityProvidersServicePage(WebDriver driver) {
		this.driver = driver;
	}

	protected static final Logger log = Logger.getLogger(IdentityProvidersServicePage.class);

	public static final String IDPPRIVILEGEFORBIDDENMESSAGE=prop.getProperty("workflow.toast.forbidden.Message");

	public final String iDENTITYPROVIDERTESTDATASHEET = BaseSuite.dirPath+ Constant.NEXTGEN_IDENTITYPROVIDER_TESTDATA_EXCEL_PATH;

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

	By breadcrumbHome = getElementLocator(prop.getProperty("security.idp.listing.breadcrumb.home")); // breadcrumbHome
	By breadcrumbAdministration = getElementLocator(prop.getProperty("security.idp.listing.breadcrumb.administration"));
	By breadcrumbSecurity = getElementLocator(prop.getProperty("security.idp.listing.breadcrumb.security"));
	By breadcrumbidp = getElementLocator(prop.getProperty("security.idp.listing.breadcrumb.idp"));
	By breadcrumbidpLink = getElementLocator(prop.getProperty("security.idp.listing.breadcrumb.idp.link"));
	By breadcrumbDefaultName = getElementLocator(prop.getProperty("security.idp.listing.breadcrumb.defaultname"));
	By listingTitle = getElementLocator(prop.getProperty("security.idp.listing.title"));
	By listingbuttonCount = getElementLocator(prop.getProperty("security.idp.listing.button.count"));
	By listingbuttonNewIDP = getElementLocator(prop.getProperty("security.idp.listing.button.newidp"));
	By listingbuttonRefresh = getElementLocator(prop.getProperty("security.idp.listing.button.refresh"));
	By listingbuttonDelete = getElementLocator(prop.getProperty("security.idp.listing.button.delete"));
	By listingsearchBar = getElementLocator(prop.getProperty("security.idp.listing.search.bar"));
	By listingsearchIcon = getElementLocator(prop.getProperty("security.idp.listing.search.icon"));
	By listingsearchClear = getElementLocator(prop.getProperty("security.idp.listing.search.clear"));
	By listingmasterCheckbox = getElementLocator(prop.getProperty("security.idp.listing.master.checkbox"));
	By listingcolumnName = getElementLocator(prop.getProperty("security.idp.listing.column.name"));
	By listingcolumnEnabled = getElementLocator(prop.getProperty("security.idp.listing.column.enabled"));
	By listingcolumnProvider = getElementLocator(prop.getProperty("security.idp.listing.column.provider"));
	By listingnoRecordsToDisplay = getElementLocator(prop.getProperty("security.idp.listing.norecordstodisplay"));
	By listingstaticCheckbox = getElementLocator(prop.getProperty("security.idp.listing.static.checkbox"));
	By listingstaticAvatar = getElementLocator(prop.getProperty("security.idp.listing.static.avatar"));
	By listingstaticName = getElementLocator(prop.getProperty("security.idp.listing.static.name"));
	By listingstaticEnabled = getElementLocator(prop.getProperty("security.idp.listing.static.enabled"));
	By listingstaticProvider = getElementLocator(prop.getProperty("security.idp.listing.static.provider"));
	By listingcountName = getElementLocator(prop.getProperty("security.idp.listing.count.name"));
	By listingcountEnabled = getElementLocator(prop.getProperty("security.idp.listing.count.enabled"));
	By listingcountProvider = getElementLocator(prop.getProperty("security.idp.listing.count.provider"));
	By listingnextPageArrow = getElementLocator(prop.getProperty("security.idp.listing.nextpagearrow"));
	By listingpaginationBar = getElementLocator(prop.getProperty("security.idp.listing.pagination.bar"));
	By listingpaginationInfo = getElementLocator(prop.getProperty("security.idp.listing.pagination.info"));

	By configFieldsDetailsDiscardPoupupTitle=getElementLocator(prop.getProperty("configurations.fields.details.popup.discard.title"));
	By configFieldsDetailsDiscardPoupupContent=getElementLocator(prop.getProperty("configurations.fields.details.popup.discard.content"));
	By configFieldsDetailsDiscardPoupupDiscardButton=getElementLocator(prop.getProperty("configurations.fields.details.popup.discard.discardbutton"));
	By configFieldsDetailsDiscardPoupupCancelButton=getElementLocator(prop.getProperty("configurations.fields.details.popup.discard.cancelbutton"));

	By detailsTitle = getElementLocator(prop.getProperty("security.idp.details.title"));
	By detailsAvatar = getElementLocator(prop.getProperty("security.idp.details.avatar"));
	By detailsButtonCount = getElementLocator(prop.getProperty("security.idp.details.button.count"));
	By detailsButtonSave = getElementLocator(prop.getProperty("security.idp.details.button.save"));
	By detailsButtonTest = getElementLocator(prop.getProperty("security.idp.details.button.test"));
	By detailsButtonDiscard = getElementLocator(prop.getProperty("security.idp.details.button.discard"));
	By detailsButtonMoreOptions = getElementLocator(prop.getProperty("security.idp.details.button.moreoptions"));
	By detailsButtonDelete = getElementLocator(prop.getProperty("security.idp.details.button.delete"));
	By detailsTabSettings = getElementLocator(prop.getProperty("security.idp.details.tab.settings"));

	By detailsShowMetadataIcon = getElementLocator(prop.getProperty("security.idp.details.settings.showmetadata"));
	By detailsHideMetadataIcon = getElementLocator(prop.getProperty("security.idp.details.settings.hidemetadata"));

	By idpDetailsDeletePoupupTitle=getElementLocator(prop.getProperty("security.idp.details.popup.delete.title"));
	By idpDetailsDeletePoupupContent=getElementLocator(prop.getProperty("security.idp.details.popup.delete.content"));
	By idpDetailsDeletePoupupDeleteButton=getElementLocator(prop.getProperty("security.idp.details.popup.delete.deletebutton"));
	By idpDetailsDeletePoupupCancelButton=getElementLocator(prop.getProperty("security.idp.details.popup.delete.cancelbutton"));


	By mappersTab=getElementLocator(prop.getProperty("security.idp.details.mappers.tab"));
	By mapperssearchBar = getElementLocator(prop.getProperty("security.idp.details.mappers.search.bar"));
	By mapperssearchIcon = getElementLocator(prop.getProperty("security.idp.details.mappers.search.icon"));
	By mapperssearchClear = getElementLocator(prop.getProperty("security.idp.details.mappers.search.clear"));
	By mappersmasterCheckbox = getElementLocator(prop.getProperty("security.idp.details.mappers.mastercheckbox"));
	By mapperscolumnName = getElementLocator(prop.getProperty("security.idp.details.mappers.column.name"));
	By mapperscolumnType = getElementLocator(prop.getProperty("security.idp.details.mappers.column.type"));

	By mappersListingButtonCount=getElementLocator(prop.getProperty("security.idp.details.mappers.button.count"));
	By mappersListingButtonNewMapper=getElementLocator(prop.getProperty("security.idp.details.mappers.button.newmapper"));
	By mappersListingButtonRefresh=getElementLocator(prop.getProperty("security.idp.details.mappers.button.refresh"));
	By mappersListingButtonDelete=getElementLocator(prop.getProperty("security.idp.details.mappers.button.delete"));

	By mappersListingStaticCheckbox=getElementLocator(prop.getProperty("security.idp.details.mappers.checkbox"));
	By mappersListingStaticAvatar=getElementLocator(prop.getProperty("security.idp.details.mappers.avatar"));
	By mappersListingStaticName=getElementLocator(prop.getProperty("security.idp.details.mappers.name"));
	By mappersListingStatictype=getElementLocator(prop.getProperty("security.idp.details.mappers.type"));

	By mappersListingCountCheckbox=getElementLocator(prop.getProperty("security.idp.details.mappers.count.checkbox"));
	By mappersListingCountName=getElementLocator(prop.getProperty("security.idp.details.mappers.count.name"));
	By mappersListingCounttype=getElementLocator(prop.getProperty("security.idp.details.mappers.count.type"));

	By mapperslistingnextPageArrow = getElementLocator(prop.getProperty("security.idp.mappers.nextpagearrow"));
	By mapperslistingpaginationBar = getElementLocator(prop.getProperty("security.idp.mappers.pagination.bar"));
	By mapperslistingpaginationInfo = getElementLocator(prop.getProperty("security.idp.mappers.pagination.info"));


	By mappersBreadcrumbLink=getElementLocator(prop.getProperty("security.idp.mappers.details.breadcrumb.mapper"));

	By mappersDetailsButtonCount=getElementLocator(prop.getProperty("security.idp.mappers.details.button.count"));
	By mappersDetailsButtonSave=getElementLocator(prop.getProperty("security.idp.mappers.details.button.save"));
	By mappersDetailsButtonDiscard=getElementLocator(prop.getProperty("security.idp.mappers.details.button.discard"));
	By mappersDetailsButtonDelete=getElementLocator(prop.getProperty("security.idp.mappers.details.button.delete"));

	By mappernoRecordsToDisplay = getElementLocator(prop.getProperty("security.idp.mapper.norecordstodisplay"));

	String mapperDynamicLabel = prop.getProperty("security.idp.details.mappers.dynamic.label");
	String mapperDynamicTooltip = prop.getProperty("security.idp.details.mappers.dynamic.tooltip");
	String mapperDynamicInputField = prop.getProperty("security.idp.details.mappers.dynamic.inputfield");
	String mapperDynamicValidation = prop.getProperty("security.idp.details.mappers.dynamic.validation");

	String mapperDynamicLabel1 = prop.getProperty("security.idp.details.mappers.dynamic.label1");
	String mapperDynamicTooltip1 = prop.getProperty("security.idp.details.mappers.dynamic.tooltip1");
	String mapperDynamicInputField1 = prop.getProperty("security.idp.details.mappers.dynamic.inputfield1");
	String mapperDynamicValidation1 = prop.getProperty("security.idp.details.mappers.dynamic.validation1");

	String mapperDynamicInputFieldDisabled1 = prop.getProperty("security.idp.details.mappers.dynamic.input.disabled1");
	String mapperDynamicInputFieldEnabled1 = prop.getProperty("security.idp.details.mappers.dynamic.input.enabled1");

	String mapperDynamicInputFieldDropDown=prop.getProperty("security.idp.details.mappers.dynamicfield.dropdown");
	String mapperDynamicInputFieldDropDownSelect=prop.getProperty("security.idp.details.mappers.dynamicfield.select");

	String mapperDynamicInputFieldDisabled = prop.getProperty("security.idp.details.mappers.dynamic.input.disabled");
	String mapperDynamicInputFieldEnabled = prop.getProperty("security.idp.details.mappers.dynamic.input.enabled");

	String mappersDetailsBreadcrumbLabel=prop.getProperty("security.idp.mappers.details.breadcrumb.label");

	String mappersDynamicCheckbox = prop.getProperty("security.idp.mappers.dynamic.checkbox");
	String mappersDynamicName = prop.getProperty("security.idp.mappers.dynamic.name");
	String mappersDynamicType = prop.getProperty("security.idp.mappers.dynamic.type");
	String mappersDynamicAvatar = prop.getProperty("security.idp.mappers.dynamic.avatar");

	String mapperLabelName=prop.getProperty("security.idp.details.mapper.label.name");
	String mapperLabelType=prop.getProperty("security.idp.details.mapper.label.mappertype");
	String mapperLabelClaim=prop.getProperty("security.idp.details.mapper.label.claim");
	String mapperLabelUserAttributeName=prop.getProperty("security.idp.details.mapper.label.userattributename");

	String mapperTooltipName=prop.getProperty("security.idp.details.mapper.tooltip.name");
	String mapperTooltipType=prop.getProperty("security.idp.details.mapper.tooltip.mappertype");
	String mapperTooltipClaim=prop.getProperty("security.idp.details.mapper.tooltip.claim");
	String mapperTooltipUserAttributeName=prop.getProperty("security.idp.details.mapper.tooltip.userattributename");

	String mapperPlaceholderName=prop.getProperty("idp.mapper.placeholder.name");
	String mapperPlaceholderType=prop.getProperty("idp.mapper.placeholder.type");
	String mapperPlaceholderClaim=prop.getProperty("idp.mapper.placeholder.claim");
	String mapperPlaceholderUserAttributeName=prop.getProperty("idp.mapper.placeholder.userattributename");

	String idpDynamicTab=prop.getProperty("security.idp.details.dynamic.tab");
	String placeholderSearchMappers=prop.getProperty("federation.mapper.placeholder.search");

	String toastMapperCreated=prop.getProperty("toast.create.mapper.idp");
	String toastMapperDeleted=prop.getProperty("toast.delete.mapper.idp");

	String popuupDeleteMapperTitle = prop.getProperty("popup.delete.idp.mapper.title");
	String popuupDeleteMapperContent = prop.getProperty("popup.delete.idp.mapper.content");

	String defaultMapperType=prop.getProperty("default.value.mapper.type");

	/** ----------------------  String locators ---------------------------------- **/

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
	String newIDPContent="New Identity Provider";
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

	String defaultAliasName = "oidc";
	String defaultNameForMapper="Create New Mapper";
	String mappersContent="Mappers";
	String clickingOnContent="Clicking on ";
	String clickedOnContent="Clicked on ";
	String verifyingContent="Verifying ";
	String isVisibleContent=" is visible";

	String userFederationContent="User Federation";
	String singleSignOnContent="Single Sign-On";
	String embeddedVaultContent="Embedded Vault";
	String customCodeContent="Custom Code";
	String policiesContent="Policies";

	String descuserFederationContent="Connect your existing company directory (e.g., Active Directory) for easy login and user management.";
	String descsingleSignOnContent="Integrate with identity providers like Entra, Okta, or Ping for seamless login using your existing credentials.";
	String descembeddedVaultContent="Enable the built-in vault to securely store sensitive information used throughout the application.";
	String desccustomCodeContent="Upload third-party or custom code for advanced users to extend functionalities through functions or scripts.";
	String descpoliciesContent="Set up rules that define how user accounts and data are protected within the application.";

	public static final String ENABLED = "enabled";
	public static final String DISABLED = "disabled";
	public static final String FALSE = "false";
	public static final String TRUE = "true";


	String dynamicBreadcrumbName=prop.getProperty("security.idp.listing.dynamicname.label");
	String dynamicBreadcrumbID=prop.getProperty("security.idp.listing.dynamicnameid.label");
	String detailsDynamicTitle=prop.getProperty("security.idp.details.dynamictitle");
	String detailsDynamicAvatar=prop.getProperty("security.idp.details.dynamicavatar");
	String listingDynamicCheckbox = prop.getProperty("security.idp.listing.dynamic.checkbox");
	String listingDynamicAvatar = prop.getProperty("security.idp.listing.dynamic.avatar");
	String listingDynamicName = prop.getProperty("security.idp.listing.dynamic.name");
	String listingDynamicEnabled = prop.getProperty("security.idp.listing.dynamic.enabled");
	String listingDynamicProvider = prop.getProperty("security.idp.listing.dynamic.provider");

	String detailsDynamicLabel = prop.getProperty("security.idp.details.settings.dynamic.label");
	String detailsDynamicTooltip = prop.getProperty("security.idp.details.settings.dynamic.tooltip");
	String detailsDynamicInputField = prop.getProperty("security.idp.details.settings.dynamic.inputfield");
	String detailsDynamicValidation = prop.getProperty("security.idp.details.settings.dynamic.validation");

	String detailsDynamicFieldCheckbox=prop.getProperty("security.idp.details.settings.dynamicfield.checkbox");
	String detailsDynamicFieldTooltip=prop.getProperty("security.idp.details.settings.dynamicfield.tooltip");
	String detailsDynamicInputFieldDisabled = prop.getProperty("security.idp.details.settings.dynamic.input.disabled");
	String detailsDynamicInputFieldEnabled = prop.getProperty("security.idp.details.settings.dynamic.input.enabled");
	String detailsDynamicInputCheckboxDisabled = prop.getProperty("security.idp.details.settings.dynamicfield.checkbox.disabled");
	String detailsDynamicInputCheckboxEnabled = prop.getProperty("security.idp.details.settings.dynamicfield.checkbox.enabled");

	String detailsDynamicInputFieldDropDown=prop.getProperty("security.idp.details.settings.dynamicfield.dropdown");
	String detailsDynamicInputFieldDropDownSelect=prop.getProperty("security.idp.details.settings.dynamicfield.select");

	String labelEnabled=prop.getProperty("security.federations.details.settings.label.enabled");
	String labelRedirectUrl = prop.getProperty("security.idp.details.settings.label.redirecturl");
	String labelAlias = prop.getProperty("security.idp.details.settings.label.alias");
	String labelDisplayName = prop.getProperty("security.idp.details.settings.label.displayname");
	String labelDisplayOrder = prop.getProperty("security.idp.details.settings.label.displayorder");
	String labelUseDiscoveryEndpoint = prop.getProperty("security.idp.details.settings.label.usediscoveryendpoint");
	String labelDiscoveryEndpoint = prop.getProperty("security.idp.details.settings.label.discoveryendpoint");
	String labelClientAuthentication = prop.getProperty("security.idp.details.settings.label.clientauthentication");
	String labelClientId = prop.getProperty("security.idp.details.settings.label.cliendid");
	String labelClientSecret = prop.getProperty("security.idp.details.settings.label.clientsecret");
	String labelScopes = prop.getProperty("security.idp.details.settings.label.scopes");

	String labelAuthorizationURL = prop.getProperty("security.idp.details.settings.label.authorizationurl");
	String labelTokenURL = prop.getProperty("security.idp.details.settings.label.tokenurl");
	String labelLogoutURL = prop.getProperty("security.idp.details.settings.label.logouturl");
	String labelUserInfoURL = prop.getProperty("security.idp.details.settings.label.userinfourl");
	String labelIssuer = prop.getProperty("security.idp.details.settings.label.issuer");
	String labelValidateSign = prop.getProperty("security.idp.details.settings.label.validateSign");
	String labelUsePKCE = prop.getProperty("security.idp.details.settings.label.usepkce");


	String placeholderRedirectUrl = prop.getProperty("security.idp.details.settings.placeholder.redirecturl");
	String placeholderAlias = prop.getProperty("security.idp.details.settings.placeholder.alias");
	String placeholderDisplayName = prop.getProperty("security.idp.details.settings.placeholder.displayname");
	String placeholderDisplayOrder = prop.getProperty("security.idp.details.settings.placeholder.displayorder");
	String placeholderDiscoveryEndpoint = prop.getProperty("security.idp.details.settings.placeholder.discoveryendpoint");
	String placeholderClientAuthentication = prop.getProperty("security.idp.details.settings.placeholder.clientauthentication");
	String placeholderClientId = prop.getProperty("security.idp.details.settings.placeholder.cliendid");
	String placeholderClientSecret = prop.getProperty("security.idp.details.settings.placeholder.clientsecret");
	String placeholderScopes = prop.getProperty("security.idp.details.settings.placeholder.scopes");

	String placeholderAuthorizationURL = prop.getProperty("security.idp.details.settings.placeholder.authorizationurl");
	String placeholderTokenURL = prop.getProperty("security.idp.details.settings.placeholder.tokenurl");
	String placeholderLogoutURL = prop.getProperty("security.idp.details.settings.placeholder.logouturl");
	String placeholderUserInfoURL = prop.getProperty("security.idp.details.settings.placeholder.userinfourl");
	String placeholderIssuer = prop.getProperty("security.idp.details.settings.placeholder.issuer");

	String tooltipEnabled = prop.getProperty("security.idp.details.settings.tooltip.enabled");
	String tooltipRedirectUrl = prop.getProperty("security.idp.details.settings.tooltip.redirecturl");
	String tooltipAlias = prop.getProperty("security.idp.details.settings.tooltip.alias");
	String tooltipDisplayName = prop.getProperty("security.idp.details.settings.tooltip.displayname");
	String tooltipDisplayOrder = prop.getProperty("security.idp.details.settings.tooltip.displayorder");
	String tooltipUseDiscoveryEndpoint = prop.getProperty("security.idp.details.settings.tooltip.usediscoveryendpoint");
	String tooltipDiscoveryEndpoint = prop.getProperty("security.idp.details.settings.tooltip.discoveryendpoint");
	String tooltipClientAuthentication = prop.getProperty("security.idp.details.settings.tooltip.clientauthentication");
	String tooltipClientId = prop.getProperty("security.idp.details.settings.tooltip.cliendid");
	String tooltipClientSecret = prop.getProperty("security.idp.details.settings.tooltip.clientsecret");
	String tooltipScopes = prop.getProperty("security.idp.details.settings.tooltip.scopes");

	String tooltipAuthorizationURL = prop.getProperty("security.idp.details.settings.tooltip.authorizationurl");
	String tooltipTokenURL = prop.getProperty("security.idp.details.settings.tooltip.tokenurl");
	String tooltipLogoutURL = prop.getProperty("security.idp.details.settings.tooltip.logouturl");
	String tooltipUserInfoURL = prop.getProperty("security.idp.details.settings.tooltip.userinfourl");
	String tooltipIssuer = prop.getProperty("security.idp.details.settings.tooltip.issuer");

	String tooltipValidateSign = prop.getProperty("security.idp.details.settings.tooltip.validateSign");
	String tooltipUsePKCE = prop.getProperty("security.idp.details.settings.tooltip.usepkce");

	String placeholderSearchIDP=prop.getProperty("idp.listing.placeholder.search");

	String toastIDPCreated=prop.getProperty("toast.idp.created");
	String toastIDPDeleted=prop.getProperty("toast.idp.deleted");

	String popuupDeleteIdpTitle=prop.getProperty("popup.delete.idp.title");
	String popuupDeleteIdpContent=prop.getProperty("popup.delete.idp.content");


	/** ---------------------- Methods  ---------------------------------- **/

	public static DataTestingParameters setIdentityServiceParamUsingExcel(String filePath, String sheetName, int rowNumber, boolean useSuffix) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String ian="";
		String uin="";
		try {
			if(useSuffix) {
				ian=System.getProperty("idpaliassuffix");
				uin=System.getProperty("idpupdatealiassuffix");
			}

			param.setTestScenarioName(xl.readUsingColName(filePath,sheetName, rowNumber, "testScenario"));
			param.setScenarioType(xl.readUsingColName(filePath,sheetName, rowNumber, "scenarioType"));
			param.setExecutionstate(xl.readUsingColName(filePath,sheetName, rowNumber, "execute"));
			// Setting values using setter methods
			param.setIdpEnabled(xl.readUsingColName(filePath,sheetName, rowNumber, "EnabledFlag"));
			param.setIdpRedirectURI(xl.readUsingColName(filePath,sheetName, rowNumber, "RedirectURI"));
			param.setIdpAlias(xl.readUsingColName(filePath,sheetName, rowNumber, "Alias")+ian);
			param.setIdpDisplayName(xl.readUsingColName(filePath,sheetName, rowNumber, "DisplayName")+ian);
			param.setIdpDisplayOrder(xl.readUsingColName(filePath,sheetName, rowNumber, "DisplayOrder"));
			param.setIdpUseDiscoveryEndpoint(xl.readUsingColName(filePath,sheetName, rowNumber, "UseDiscoveryEndpoint"));
			param.setIdpDiscoveryEndpoint(xl.readUsingColName(filePath,sheetName, rowNumber, "DiscoveryEndpoint"));
			param.setIdpClientAuthentication(xl.readUsingColName(filePath,sheetName, rowNumber, "ClientAuthentication"));
			param.setIdpClientID(xl.readUsingColName(filePath,sheetName, rowNumber, "ClientID"));
			param.setIdpClientSecret(xl.readUsingColName(filePath,sheetName, rowNumber, "ClientSecret"));
			param.setIdpScopes(xl.readUsingColName(filePath,sheetName, rowNumber, "Scopes"));

			param.setIdpAuthorizationURL(xl.readUsingColName(filePath,sheetName, rowNumber, "AuthorizationURL"));
			param.setIdpTokenURL(xl.readUsingColName(filePath,sheetName, rowNumber, "TokenURL"));
			param.setIdpLogoutURL(xl.readUsingColName(filePath,sheetName, rowNumber, "LogoutURL"));
			param.setIdpUserInfoURL(xl.readUsingColName(filePath,sheetName, rowNumber, "UserInfoURL"));
			param.setIdpIssuer(xl.readUsingColName(filePath,sheetName, rowNumber, "Issuer"));
			param.setIdpValidateSignatures(xl.readUsingColName(filePath,sheetName, rowNumber, "ValidateSignatures"));
			param.setIdpUsePKCE(xl.readUsingColName(filePath,sheetName, rowNumber, "UsePKCE"));
			param.setIdpUpdateDisplayName(xl.readUsingColName(filePath,sheetName, rowNumber, "DisplayName")+uin);

			param.setCustomMappers(xl.readUsingColName(filePath,sheetName, rowNumber, "customMappers"));
			param.setUpdateMappers(xl.readUsingColName(filePath,sheetName, rowNumber, "updateMappers"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setIdentityServiceParamUsingExcel "+e.toString());
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
			param.setClaim(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"claim"));
			param.setUserAttributeName(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"userattributename"));



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
			param.setClaim(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"claim"));
			param.setUserAttributeName(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, user,"userattributename"));



		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setUsersParamUsingExcel "+e.toString());
		}
		return param;

	}


	public boolean clickOnRefreshOnIDPsListingPage() {

		return clickOnButton(driver, listingbuttonRefresh, refreshContent, true);
	}


	public boolean clickOnRefreshOnIDPsListingPageWithValidation() {
		boolean flag=true;

		try {
			clickOnButton(driver, listingbuttonRefresh, refreshContent, true);

			waitForExecution(100);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, toastMsg)) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
						"Identity Providers tab refresh authorization message");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnRefreshOnIDPsListingPageWithValidation :: "+e.toString());
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

	public boolean clickOnIdentityProvidersTab() {

		boolean flag = false;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isDisplayedInLoop(driver, 0, listingTitle);

			if (!isDisplayed(driver, listingTitle)) {
				flag = handleIdentityProvidersTabNavigation();
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " clickOnIdentityProvidersTab :: " + e.toString());
			flag = false;
		}

		return flag;

	}

	private boolean handleIdentityProvidersTabNavigation() {
		boolean flag = false;

		if (isDisplayed(driver, securityTabFederationsLabel)) {
			flag = clickOnButton(driver, securityTabSingleSignOnLabel, singleSignOnContent, true);
		} else if (isDisplayed(driver, breadcrumbidpLink)) {
			flag = clickOnButton(driver, breadcrumbidpLink, identityProvidersContent, true);
		}

		if (flag) {
			handleDiscardWindow(driver, configFieldsDetailsDiscardPoupupDiscardButton, discardContent);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isDisplayedInLoop(driver, 0, listingbuttonNewIDP);

			if (isDisplayed(driver, listingbuttonNewIDP)) {
				flag = validateElement(driver, listingTitle, identityProvidersContent, attributeTitle);
			}
		}

		return flag;
	}


	public boolean validateIdentityProvidersListingPage() {

		boolean flag = true;
		HomePage hp=new HomePage(driver);

		try {

			BaseSuite.reportLog(hyphenContent+" validating Identity Providers listing page fields "+hyphenContent);

			hp.validateNextgenIcedqModuleAndAdministrationSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Identity Providers listing page "+hyphenContent);

			validateElement(driver,breadcrumbHome, homeContent, hyperlinkContent);

			validateElement(driver,breadcrumbAdministration, administrationContent, hyperlinkContent);

			validateElement(driver,breadcrumbSecurity, securityContent, hyperlinkContent);

			validateElement(driver,breadcrumbidp, identityProvidersContent, labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying Title and Search field Identity Providers listing page "+hyphenContent);

			verifyIndividualLabel(driver, listingTitle, identityProvidersContent);

			verifySearchField(driver, listingsearchBar, placeholderSearchIDP, placeholderSearchIDP);

			validateElement(driver,listingsearchIcon, placeholderSearchIDP, iconContent);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Identity Providers listing page "+hyphenContent);

			validateButtons(driver, listingbuttonCount, 3);

			verifyVisibilityOfButtons(driver, listingbuttonNewIDP, newIDPContent, true);
			verifyVisibilityOfButtons(driver, listingbuttonRefresh, refreshContent, true);
			verifyVisibilityOfButtons(driver, listingbuttonDelete, deleteContent, false);

			BaseSuite.reportLog(hyphenContent+"  Verifying Columns on Identity Providers listing page "+hyphenContent);

			validateElement(driver, listingmasterCheckbox, "Master", checkboxContent);
			validateElement(driver,listingcolumnName, "Name",columnContent);
			validateElement(driver,listingcolumnEnabled, "Enabled", columnContent);
			validateElement(driver,listingcolumnProvider, "Provider", columnContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on Identity Providers listing page "+hyphenContent);

			getPaginationDetails(driver,listingpaginationInfo, listingpaginationBar,listingnoRecordsToDisplay, "Identity Providers listing page");

			BaseSuite.validationReportLog(hyphenContent+" Identity Providers listing page validated successfully "+hyphenContent);

		}catch(Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" validateIdentityProvidersListingPage :: "+e.toString());
			flag=false;

		}

		return flag;

	}

	public boolean clickOnNewIDPButton(String icedqUser) {

		boolean flag = true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 3, listingbuttonNewIDP);

			if(isDisplayed(driver, listingbuttonNewIDP)) {

				clickOnButton(driver, listingbuttonNewIDP, newIDPContent, flag);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

					String pgTitle=getAttribute(driver, detailsTitle, attributeTextContent);

					flag = stringOutput(pgTitle.trim(), defaultAliasName, true);

				}else{

					flag = captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
							"New Identity Provider authorization message");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnNewIDPButton :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateIDPDetailPageBeforeCreating() {
		boolean flag = true;
		HomePage hp=new HomePage(driver);

		try {

			BaseSuite.reportLog(hyphenContent+" validating Identity Provider details page before creating "+hyphenContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			hp.validateNextgenIcedqModuleAndAdministrationSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Identity Provider details page "+hyphenContent);

			validateElement(driver,breadcrumbHome, homeContent, hyperlinkContent);

			validateElement(driver,breadcrumbAdministration, administrationContent, hyperlinkContent);

			validateElement(driver,breadcrumbSecurity, securityContent, hyperlinkContent);

			validateElement(driver,breadcrumbidpLink, identityProvidersContent, hyperlinkContent);

			validateElement(driver,breadcrumbDefaultName, defaultAliasName, labelContent);

			validateElement(driver,returnElement(detailsDynamicTitle, dynamicName, defaultAliasName), defaultAliasName, attributeTitle);

			validateElement(driver,returnElement(detailsDynamicAvatar, dynamicName, defaultAliasName), defaultAliasName, iconContent);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Identity Provider details page "+hyphenContent);

			validateButtons(driver, detailsButtonCount, 3);

			verifyVisibilityOfButtons(driver, detailsButtonSave, saveContent, false);
			verifyVisibilityOfButtons(driver, detailsButtonDiscard, discardContent, false);	
			verifyVisibilityOfButtons(driver, detailsButtonDelete, deleteContent, false);

			validateDefaultFieldsOfIDP(defaultAliasName);

			BaseSuite.reportLog(hyphenContent+" validated Identity Provider details page "+hyphenContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateIDPDetailPageBeforeCreating :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public String getRedirectURLEndpoint(String idpName) {

		return "/broker/"+idpName+"/endpoint";
	}

	public boolean validateDefaultFieldsOfIDP(String idpName) {
		boolean flag = true;
		CustomFieldsServicePage cp = new CustomFieldsServicePage(driver);
		try {
			// Define an array of field details (including default values)
			String[][] fieldDetails = {
					{labelRedirectUrl, tooltipRedirectUrl, placeholderRedirectUrl, getTokenPathForIDP(BaseSuite.baseURL)+getRedirectURLEndpoint(idpName), FALSE},
					{labelAlias, tooltipAlias, placeholderAlias, defaultAliasName, TRUE},
					{labelDisplayName, tooltipDisplayName, placeholderDisplayName, "", TRUE},
					{labelDisplayOrder, tooltipDisplayOrder, placeholderDisplayOrder, "", TRUE},
					{labelDiscoveryEndpoint, tooltipDiscoveryEndpoint, placeholderDiscoveryEndpoint, "", TRUE},
					{labelClientId, tooltipClientId, placeholderClientId, "", TRUE},
					{labelClientSecret, tooltipClientSecret, placeholderClientSecret, "", TRUE},
					{labelScopes, tooltipScopes, placeholderScopes, "profile email", FALSE},

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


			validateElement(driver, returnElement(detailsDynamicLabel, dynamicName, labelUseDiscoveryEndpoint), labelUseDiscoveryEndpoint, labelContent);
			checkExpectedValueWithActual(driver, flag, returnElement(detailsDynamicFieldTooltip, dynamicName, labelUseDiscoveryEndpoint), labelUseDiscoveryEndpoint, tooltipUseDiscoveryEndpoint, true, attributeContent);
			cp.checkboxStatus(returnElement(detailsDynamicFieldCheckbox, dynamicName, labelUseDiscoveryEndpoint), labelUseDiscoveryEndpoint, true);
			checkCheckboxIsEnabledOrNot(labelUseDiscoveryEndpoint, true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " validateDefaultFieldsOfIDP :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	private boolean selectCheckboxOfIDP(By locator, String label, String input) {

		boolean flag = true;

		if(Boolean.parseBoolean(input)) {

			flag=selectcheckbox(driver,locator, label);

		}else {
			flag= unselectcheckbox(driver,locator, label);
		}

		return flag;
	}


	private boolean validateField(WebDriver driver, String label, String tooltip, String placeholder, String defaultValue, boolean enabled) {
		boolean flag = true;
		try {
			validateElement(driver, returnElement(detailsDynamicLabel, dynamicName, label), label, labelContent);
			validateElement(driver, returnElement(detailsDynamicInputField, dynamicName, label), label, fieldContent);

			checkFieldIsEnabledOrNot(label, enabled);

			BaseSuite.reportLog("Veifying  "+label+" tooltip content ");

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

	public boolean checkFieldIsEnabledOrNot(String label, boolean expected) {
		boolean flag = true;
		try {

			BaseSuite.reportLog("Verifying state of input is enabled or not  for field  : "+label);

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
				BaseSuite.reportFailLog(label + " checkbox is " + (expected ? DISABLED : ENABLED) + " not matched with expected condition ", "checkCheckboxIsEnabledOrNot");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " checkCheckboxIsEnabledOrNot :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	public boolean searchIDPNameOnEachPageAndClickOn(By locator,String name, boolean clickOn) {

		boolean flag=false;
		boolean nextpageFlag=true;
		int pn=0;

		try {

			do {

				BaseSuite.reportLog("searching IDP name : "+name+" on page number :"+(pn+1));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 3, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportLog("IDP name : "+name+" found on page number :"+(pn+1));

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
			BaseSuite.reportErrorLog(errorLogTitle+" searchIDPNameOnEachPageAndClickOn :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean searchIDPNameAndClickOnIDPName(String ldapName) {
		boolean flag =true;

		try {

			flag=searchFunctionalityMethod(driver, flag, listingsearchBar, listingsearchIcon, placeholderSearchIDP, placeholderSearchIDP,  ldapName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && elementNotVisible(driver, listingnoRecordsToDisplay)) {

				flag=searchIDPNameOnEachPageAndClickOn(returnElement(listingDynamicName, dynamicName, ldapName), ldapName, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}else {
				flag=false;
				BaseSuite.reportFailLog(noRecordsToDisplayContent+isVisibleContent,"searchIDPNameAndClickOnIDPName");
				searchFunctionalityMethod(driver, flag, listingsearchBar, listingsearchIcon, placeholderSearchIDP, placeholderSearchIDP,  "");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchIDPNameAndClickOnIDPName "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean searchIDPNameOnListingPage(String ldapName) {
		boolean flag =true;

		try {

			flag=searchFunctionalityMethod(driver, flag, listingsearchBar, listingsearchIcon, placeholderSearchIDP, placeholderSearchIDP,  ldapName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && isDisplayed(driver, returnElement(listingDynamicName, dynamicName, ldapName))) {

				flag=false;
				BaseSuite.reportLog(ldapName+" user IDP is already exist");

			}else {
				flag=true;
				BaseSuite.reportLog(ldapName+" user IDP is not exist");
				searchFunctionalityMethod(driver, flag, listingsearchBar, listingsearchIcon, placeholderSearchIDP, placeholderSearchIDP,  "");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchIDPNameOnListingPage "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean selectDynamicFieldValuesOfIDP(String label, String inputSelect) {

		boolean flag = true;
		try {

			BaseSuite.reportLog(verifyingContent+label+" field dropdown is visible or not");

			javascript(driver, scrollToElementArg, returnElement(detailsDynamicInputFieldDropDown, dynamicName, label));

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

					BaseSuite.reportFailLog(inputSelect + " value is not visible", "selectDynamicFieldValuesOfIDP");
					flag=false;
				}
			}else {
				BaseSuite.reportFailLog(label + " field is not visible", "selectDynamicFieldValuesOfIDP");		
				flag=false;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " selectDynamicFieldValuesOfIDP :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	private boolean enterValues(WebDriver driver, String label,String placeholder, String inputValue,String fieldValid, String enabled) {
		boolean flag = true;
		try {

			log.info(fieldValid);

			switch(label.toLowerCase().trim()) {

			case "use discovery endpoint":	

				if(Boolean.parseBoolean(inputValue)) {
					flag=selectcheckbox(driver,returnElement(detailsDynamicFieldCheckbox, dynamicName, label), label);

					clickOnButton(driver, detailsShowMetadataIcon, "Show metadata", true);

				}else {
					flag=unselectcheckbox(driver,returnElement(detailsDynamicFieldCheckbox, dynamicName, label), label);

				}

				break;					
			case "client authentication":

				flag=selectDynamicFieldValuesOfIDP(label, inputValue);

				break;


			case "authorization url":

				displayAndClick(driver, returnElement(detailsDynamicLabel, dynamicName, label));

				waitForExecution(2000);

				flag=validateField(driver, label, "", placeholder, inputValue, Boolean.parseBoolean(enabled));

				break;
			case "token url":
			case "logout url":
			case "user info url":
			case "issuer":
			case "scopes":

				flag=validateField(driver, label, "", placeholder, inputValue, Boolean.parseBoolean(enabled));

				break;
			case "redirect uri":

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

	public boolean enterValuesToFieldsOfIDP(DataTestingParameters param) {
		boolean flag = true;

		try {
			// Define an array of field details (including default values)

			String urlfields= Boolean.parseBoolean(param.getIdpUseDiscoveryEndpoint()) ? FALSE : TRUE;

			String[][] fieldDetails = {
					{labelRedirectUrl, tooltipRedirectUrl, placeholderRedirectUrl, getTokenPathForIDP(BaseSuite.baseURL)+getRedirectURLEndpoint(param.getIdpAlias()), FALSE, ""},
					{labelAlias, tooltipAlias, placeholderAlias, param.getIdpAlias(), TRUE, ""},
					{labelDisplayName, tooltipDisplayName, placeholderDisplayName, param.getIdpDisplayName(), TRUE, ""},
					{labelDisplayOrder, tooltipDisplayOrder, placeholderDisplayOrder, param.getIdpDisplayOrder(), TRUE, ""},
					{labelUseDiscoveryEndpoint, tooltipUseDiscoveryEndpoint, param.getIdpUseDiscoveryEndpoint(), TRUE, TRUE, ""},
					{labelDiscoveryEndpoint, tooltipDiscoveryEndpoint, placeholderDiscoveryEndpoint, param.getIdpDiscoveryEndpoint(), TRUE, ""},
					{labelAuthorizationURL, tooltipAuthorizationURL, placeholderAuthorizationURL, param.getIdpAuthorizationURL(), urlfields, ""},
					{labelTokenURL, tooltipTokenURL, placeholderTokenURL, param.getIdpTokenURL(), urlfields, ""},
					{labelLogoutURL, tooltipLogoutURL, placeholderLogoutURL, param.getIdpLogoutURL(), urlfields, ""},
					{labelUserInfoURL, tooltipUserInfoURL, placeholderUserInfoURL, param.getIdpUserInfoURL(), urlfields, ""},
					{labelIssuer, tooltipIssuer, placeholderIssuer, param.getIdpIssuer(), urlfields, ""},
					{labelClientAuthentication, tooltipClientAuthentication, placeholderClientAuthentication, param.getIdpClientAuthentication(), TRUE, ""},
					{labelClientId, tooltipClientId, placeholderClientId, param.getIdpClientID(), TRUE, ""},
					{labelClientSecret, tooltipClientSecret, placeholderClientSecret, param.getIdpClientSecret(), TRUE, ""},
					{labelScopes, tooltipScopes, placeholderScopes, param.getIdpScopes(), FALSE, ""},

			};

			// Loop through each field and validate
			for (String[] field : fieldDetails) {
				String label = field[0];
				String placeholder = field[2];
				String defaultValue = field[3];
				String enabled = field[4];
				String validation = field[5];

				flag=enterValues(driver, label, placeholder, defaultValue, validation, enabled);
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " enterValuesToFieldsOfIDP :: " + e.toString());
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

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "IDP Created");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"IDP Created");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnSaveButtonAndValidateToast :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean clickOnDeleteIDPButtonAndValidateToast(String expectedToastMessage, String icedqUser) {
		boolean tag =true;
		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, detailsButtonDelete, deleteContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

				validatePopupWindowContent(driver, flag, idpDetailsDeletePoupupTitle, idpDetailsDeletePoupupContent, popuupDeleteIdpTitle, popuupDeleteIdpContent);

				verifyVisibilityOfButtons(driver, idpDetailsDeletePoupupDeleteButton, deleteContent, true);
				verifyVisibilityOfButtons(driver, idpDetailsDeletePoupupCancelButton, cancelButtonContent, true);

				flag=clickOnButton(driver, idpDetailsDeletePoupupDeleteButton, deleteContent, tag);

			}

			if(isDisplayed(driver, toastMsg) && flag) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "IDP deleted");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "IDP deleted");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnDeleteIDPButtonAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean createIDPForValid(DataTestingParameters param, String icedqUser) {

		boolean flag=true;
		try {

			flag=clickOnNewIDPButton(icedqUser);

			if(flag) {

				enterValuesToFieldsOfIDP(param);

				flag=clickOnSaveButtonAndValidateToast(toastIDPCreated);

				if(flag && Boolean.parseBoolean(param.getLdapEnabledFlag())) {
					selectcheckbox(driver,returnElement(detailsDynamicFieldCheckbox, dynamicName, labelEnabled), labelEnabled);
					flag=clickOnSaveButtonAndValidateToast("");

				}

				clickOnIdentityProvidersTab();

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" createIDPForValid :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean viewValuesToFieldsOfIDP(DataTestingParameters param) {
		boolean flag = true;

		try {
			// Define an array of field details (including default values)


			String[][] fieldDetails = {
					{labelRedirectUrl, tooltipRedirectUrl, placeholderRedirectUrl, getTokenPathForIDP(BaseSuite.baseURL)+getRedirectURLEndpoint(param.getIdpAlias()), FALSE, ""},
					{labelAlias, tooltipAlias, placeholderAlias, param.getIdpAlias(), FALSE, ""},
					{labelDisplayName, tooltipDisplayName, placeholderDisplayName, param.getIdpDisplayName(), TRUE, ""},
					{labelDisplayOrder, tooltipDisplayOrder, placeholderDisplayOrder, param.getIdpDisplayOrder(), TRUE, ""},
					{labelAuthorizationURL, tooltipAuthorizationURL, placeholderAuthorizationURL, param.getIdpAuthorizationURL(), TRUE, ""},
					{labelTokenURL, tooltipTokenURL, placeholderTokenURL, param.getIdpTokenURL(), TRUE, ""},
					{labelLogoutURL, tooltipLogoutURL, placeholderLogoutURL, param.getIdpLogoutURL(), TRUE, ""},
					{labelUserInfoURL, tooltipUserInfoURL, placeholderUserInfoURL, param.getIdpUserInfoURL(), TRUE, ""},
					{labelIssuer, tooltipIssuer, placeholderIssuer, param.getIdpIssuer(), TRUE, ""},
					{labelClientAuthentication, tooltipClientAuthentication, placeholderClientAuthentication, param.getIdpClientAuthentication(), TRUE, ""},
					{labelClientId, tooltipClientId, placeholderClientId, param.getIdpClientID(), TRUE, ""},
					{labelClientSecret, tooltipClientSecret, placeholderClientSecret, "**********", TRUE, ""},
					{labelScopes, tooltipScopes, placeholderScopes, "openid profile email", FALSE, ""},

			};

			// Loop through each field and validate
			for (String[] field : fieldDetails) {
				String label = field[0];
				String placeholder = field[2];
				String defaultValue = field[3];
				String enabled = field[4];
				String validation = field[5];

				flag=viewValues(driver, label, placeholder, defaultValue, validation, enabled);
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " viewValuesToFieldsOfIDP :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	private boolean viewValues(WebDriver driver, String label,String placeholder, String inputValue,String fieldValid, String enabled) {
		boolean flag = true;
		try {

			log.info(fieldValid);

			switch(label.toLowerCase().trim()+1) {

			case "client authentication1":
				flag=selectDynamicFieldValuesOfIDP(label, inputValue);
				break;

			case "enabled1":
			case "validate signatures1":
			case "use pkce1":


				flag=checkCheckboxIsEnabledOrNot(label, Boolean.parseBoolean(inputValue));
				break;

			default:

				flag=validateField(driver, label, "", placeholder, inputValue, Boolean.parseBoolean(enabled));

				break;
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " viewValues :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	public boolean updateValuesToFieldsOfIDP(DataTestingParameters param) {
		boolean flag = true;

		try {
			// Define an array of field details (including default values)


			String[][] fieldDetails = {
					{labelEnabled, tooltipEnabled, "", param.getIdpEnabled(), TRUE, ""},
					{labelRedirectUrl, tooltipRedirectUrl, placeholderRedirectUrl, getTokenPathForIDP(BaseSuite.baseURL)+getRedirectURLEndpoint(param.getIdpAlias()), FALSE, ""},
					{labelAlias, tooltipAlias, placeholderAlias, param.getIdpAlias(), FALSE, ""},
					{labelDisplayName, tooltipDisplayName, placeholderDisplayName, param.getIdpUpdateDisplayName(), TRUE, ""},
					{labelDisplayOrder, tooltipDisplayOrder, placeholderDisplayOrder, param.getIdpDisplayOrder(), TRUE, ""},
					{labelAuthorizationURL, tooltipAuthorizationURL, placeholderAuthorizationURL, param.getIdpAuthorizationURL(), TRUE, ""},
					{labelTokenURL, tooltipTokenURL, placeholderTokenURL, param.getIdpTokenURL(), TRUE, ""},
					{labelLogoutURL, tooltipLogoutURL, placeholderLogoutURL, param.getIdpLogoutURL(), TRUE, ""},
					{labelUserInfoURL, tooltipUserInfoURL, placeholderUserInfoURL, param.getIdpUserInfoURL(), TRUE, ""},
					{labelIssuer, tooltipIssuer, placeholderIssuer, param.getIdpIssuer(), TRUE, ""},
					{labelClientAuthentication, tooltipClientAuthentication, placeholderClientAuthentication, param.getIdpClientAuthentication(), TRUE, ""},
					{labelClientId, tooltipClientId, placeholderClientId, param.getIdpClientID(), TRUE, ""},
					{labelClientSecret, tooltipClientSecret, placeholderClientSecret, param.getIdpClientSecret(), TRUE, ""},
					{labelScopes, tooltipScopes, placeholderScopes, "openid "+param.getIdpScopes(), FALSE, ""},

			};

			// Loop through each field and validate
			for (String[] field : fieldDetails) {
				String label = field[0];
				String placeholder = field[2];
				String defaultValue = field[3];
				String enabled = field[4];
				String validation = field[5];

				flag=updateValues(label, placeholder, defaultValue, validation, enabled);
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " updateValuesToFieldsOfIDP :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	public boolean viewIDPForValid(DataTestingParameters param, String icedqUser) {

		boolean flag=true;
		try {
			log.info(icedqUser);

			flag=viewValuesToFieldsOfIDP(param);



		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewIDPForValid :: "+e.toString());
			flag=false;
		}
		return flag;


	}

	private boolean updateValues(String label,String placeholder, String inputValue,String fieldValid, String enabled) {
		boolean flag = true;
		try {

			log.info(fieldValid);

			switch(label.toLowerCase().trim()+1) {

			case "redirect uri1":
			case "alias1":
			case "scopes1":
				flag=validateField(driver, label, "", placeholder, inputValue, Boolean.parseBoolean(enabled));
				break;

			case "client authentication1":
				flag=selectDynamicFieldValuesOfIDP(label, inputValue);
				break;

			case "enabled1":
			case "validate signatures1":
			case "use pkce1":

				/**	checkCheckboxIsEnabledOrNot(label, Boolean.parseBoolean(inputValue));
				 */
				flag= selectCheckboxOfIDP(returnElement(detailsDynamicFieldCheckbox, dynamicName, label), label, inputValue);
				break;

			default:

				flag=validatAndeEnterValueToTextField(driver, returnElement(detailsDynamicLabel, dynamicName, label), 
						returnElement(detailsDynamicInputField, dynamicName, label), 
						returnElement(detailsDynamicValidation, dynamicName, label), 
						label, placeholder, inputValue, "");

				break;
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " updateValues :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	public boolean updateIDPForValid(DataTestingParameters param, String icedqUser) {

		boolean flag=true;
		try {
			log.info(icedqUser);

			flag= updateValuesToFieldsOfIDP(param);

			flag= flag && clickOnSaveButtonAndValidateToast("");

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" updateIDPForValid :: "+e.toString());
			flag=false;
		}
		return flag;


	}

	public boolean validateDeletedIdpOnListingPage(String idpName) {

		boolean flag=true;

		try {

			flag=searchFunctionalityMethod(driver, flag,listingsearchBar, listingsearchIcon, placeholderSearchIDP, placeholderSearchIDP,  idpName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && !isDisplayed(driver, returnElement(listingDynamicName, dynamicName, idpName))) {

				BaseSuite.validationReportLog("Deleted identity provider not visible on listing page : "+idpName);

			}else if(isDisplayed(driver, returnElement(listingDynamicName, dynamicName, idpName))){

				BaseSuite.reportFailLog("Deleted identity provider is visible on listing page : "+idpName, "validateDeletedIdpOnListingPage");

			}

		}catch (Exception e) {

			BaseSuite.reportErrorLog(errorLogTitle+" validateDeletedIdpOnListingPage :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean deleteIDPForValidFromDetailsPage(DataTestingParameters param, String icedqUser) {

		boolean flag=true;
		try {



			flag= clickOnDeleteIDPButtonAndValidateToast(toastIDPDeleted, icedqUser);

			clickOnIdentityProvidersTab();

			flag = flag && validateDeletedIdpOnListingPage(param.getIdpAlias());

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" deleteIDPForValidFromDetailsPage :: "+e.toString());
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

				String state = getAttribute(driver, returnElement(idpDynamicTab, dynamicName, mappersContent), "aria-selected");

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

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnMappersTab :: "+e.toString());
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

			getPaginationDetails(driver,mapperslistingpaginationInfo, mapperslistingpaginationBar,mappernoRecordsToDisplay, "Mappers listing page");

			BaseSuite.validationReportLog(hyphenContent+" mappers tab page validated successfully "+hyphenContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateMappersListingPage :: "+e.toString());
			flag=false;
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
			/**	
			//As per new improvement this code is invalid - DAT-12544

			//validateFieldForMapperForDropDown(driver, mapperLabelType, mapperTooltipType, mapperPlaceholderType, "", true);


			//	validateFieldForMapper(driver, mapperLabelType, mapperTooltipType, mapperPlaceholderType, defaultMapperType, false);
			//
			//validateFieldForMapper(driver, mapperLabelClaim, mapperTooltipClaim, mapperPlaceholderClaim, "", true);
			//validateFieldForMapper(driver, mapperLabelUserAttributeName, mapperTooltipUserAttributeName, mapperPlaceholderUserAttributeName, "", true);
			 */
			BaseSuite.reportLog(hyphenContent+" validated mapper details page "+hyphenContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateMapperDetailPageBeforeCreating :: "+e.toString());
			flag=false;
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

	private boolean validateFieldForMapperForDropDown(WebDriver driver, String label, String tooltip, String placeholder, String defaultValue, boolean enabled) {
		boolean flag = true;
		try {
			validateElement(driver, returnElement(mapperDynamicLabel1, dynamicName, label), label, labelContent);
			validateElement(driver, returnElement(mapperDynamicInputField1, dynamicName, label), label, fieldContent);

			/**checkFieldIsEnabledOrNotForMapper(label, enabled);*/

			checkFieldIsEnabledOrNotForMapper1(label, enabled);

			BaseSuite.reportLog("Veifying "+label+" tooltip content");

			checkExpectedValueWithActual(driver, flag, returnElement(mapperDynamicTooltip1, dynamicName, label), label, tooltip, true, attributeContent);

			verifyPlaceHolderValue(driver, returnElement(mapperDynamicInputField1, dynamicName, label), label, placeholder);
			verifyDefaultValue(returnElement(mapperDynamicInputField1, dynamicName, label), label, defaultValue);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " validateFieldForMapperForDropDown :: " + e.toString());
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

				BaseSuite.validationReportLog(label + " mapper field is " + (expected ? ENABLED : DISABLED));

			} else {
				BaseSuite.reportFailLog(label + " mapper field is  " + (expected ? DISABLED : ENABLED) + " not matched with expected condition", "checkFieldIsEnabledOrNotForMapper");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " checkFieldIsEnabledOrNotForMapper :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	public boolean checkFieldIsEnabledOrNotForMapper1(String label, boolean expected) {
		boolean flag = true;
		try {

			BaseSuite.reportLog("Verifying state of input is enabled or not  for field : "+label);

			String elementToCheck = expected ? mapperDynamicInputFieldEnabled1 : mapperDynamicInputFieldDisabled1;

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


	public boolean enterValuesToMapperFields(DataTestingParameters param) {
		boolean flag = true;
		String[][] fieldDetails=new String[0][];
		try {


			fieldDetails = new String[][]{
				{mapperLabelName, mapperTooltipName, mapperPlaceholderName, param.getMapperName(), TRUE,""},
				{mapperLabelType, mapperTooltipType, mapperPlaceholderType, param.getMapperType(), TRUE,""},
				{mapperLabelClaim,mapperTooltipClaim,mapperPlaceholderClaim, param.getClaim(), TRUE,""},
				{mapperLabelUserAttributeName, mapperTooltipUserAttributeName, mapperPlaceholderUserAttributeName, param.getUserAttributeName(), TRUE,""}
			};



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

			if(label.toLowerCase().trim().equalsIgnoreCase("mapper type")) {


				validateFieldForMapperForDropDown(driver, mapperLabelType, "", mapperPlaceholderType, "", true);

				selectDynamicFieldValuesOfIDP(label, inputValue);

			}else {

				flag=validatAndeEnterValueToTextField(driver, returnElement(mapperDynamicLabel, dynamicName, label), 
						returnElement(mapperDynamicInputField, dynamicName, label), 
						returnElement(mapperDynamicValidation, dynamicName, label), 
						label, placeholder, inputValue, "");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " enterMapperValues :: " + e.toString());
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

			DataTestingParameters mparam = setMappersParamUsingExcel(iDENTITYPROVIDERTESTDATASHEET, mapper,useSuffix);
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


	public boolean viewValuesToMapperFields(DataTestingParameters param) {
		boolean flag = true;
		String[][] fieldDetails=new String[0][];
		try {

			fieldDetails = new String[][]{
				{mapperLabelName, mapperTooltipName, mapperPlaceholderName, param.getMapperName(), FALSE,""},
				{mapperLabelType, mapperTooltipType, mapperPlaceholderType, defaultMapperType, FALSE,""},
				{mapperLabelClaim,mapperTooltipClaim,mapperPlaceholderClaim, param.getClaim(), TRUE,""},
				{mapperLabelUserAttributeName, mapperTooltipUserAttributeName, mapperPlaceholderUserAttributeName, param.getUserAttributeName(), TRUE,""}
			};

			// Loop through each field and validate
			for (String[] field : fieldDetails) {
				String label = field[0];
				String tooltip = field[1];
				String placeholder = field[2];
				String defaultValue = field[3];
				String enabled = field[4];

				if(label.equalsIgnoreCase(mapperLabelType)) {

					flag=validateFieldForMapperForDropDown(driver, label, tooltip, placeholder, defaultValue, Boolean.parseBoolean(enabled));

				}else {

					flag=validateFieldForMapper(driver, label, tooltip, placeholder, defaultValue, Boolean.parseBoolean(enabled));
				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " viewValuesToMapperFields :: " + e.toString());
			flag = false;
		}
		return flag;
	}


	public boolean viewMapperInExistingIDP(DataTestingParameters param, boolean useSuffix) {
		boolean flag = true;
		try {
			clickOnMappersTab();
			validateMappersListingPage();

			String[] customMappers = param.getCustomMappers().split(",");

			for (String mapper : customMappers) {

				DataTestingParameters mparam = setMappersParamUsingExcel(iDENTITYPROVIDERTESTDATASHEET, mapper,useSuffix);
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
			BaseSuite.reportErrorLog(errorLogTitle + " viewMapperInExistingIDP :: " + e.toString());
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

	public boolean updateMapperInExistingIDP(DataTestingParameters param, boolean useSuffix) {
		boolean flag = true;
		try {
			clickOnMappersTab();
			validateMappersListingPage();

			String[] customMappers = param.getUpdateMappers().split(",");

			for (String mapper : customMappers) {
				flag = processMapperUpdation(mapper,useSuffix);

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle + " updateMapperInExistingIDP :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	private boolean processMapperUpdation(String mapper, boolean useSuffix) {
		boolean flag;
		try {


			DataTestingParameters mparam = setMappersParamUsingExcel(iDENTITYPROVIDERTESTDATASHEET, mapper, useSuffix);
			DataTestingParameters umparam = setUpdateMappersParamUsingExcel(iDENTITYPROVIDERTESTDATASHEET, mapper,useSuffix);

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

			fieldDetails = new String[][]{
				{mapperLabelName, mapperTooltipName, mapperPlaceholderName, param.getMapperName(), FALSE,""},
				{mapperLabelType, mapperTooltipType, mapperPlaceholderType, defaultMapperType, FALSE,""},
				{mapperLabelClaim,mapperTooltipClaim,mapperPlaceholderClaim, param.getClaim(), TRUE,""},
				{mapperLabelUserAttributeName, mapperTooltipUserAttributeName, mapperPlaceholderUserAttributeName, param.getUserAttributeName(), TRUE,""}
			};


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

	public boolean deleteMapperInExistingIDP(DataTestingParameters param,String icedqUser, boolean useSuffix) {
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

	public boolean clickOnDeleteMapperButtonAndValidateToast(String expectedToastMessage, String icedqUser) {
		boolean tag =true;
		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, mappersDetailsButtonDelete, deleteContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(icedqUser.contains(ConstantProperty.ICEDQ_SUPERADMINUSER) || icedqUser.contains(ConstantProperty.ICEDQ_ADMINUSER)) {

				validatePopupWindowContent(driver, flag, idpDetailsDeletePoupupTitle, idpDetailsDeletePoupupContent, popuupDeleteMapperTitle, popuupDeleteMapperContent);

				verifyVisibilityOfButtons(driver, idpDetailsDeletePoupupDeleteButton, deleteContent, true);
				verifyVisibilityOfButtons(driver, idpDetailsDeletePoupupCancelButton, cancelButtonContent, true);

				flag=clickOnButton(driver, idpDetailsDeletePoupupDeleteButton, deleteContent, tag);

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

	private boolean processMapperDeletion(String mapper,String icedqUser, boolean useSuffix) {
		boolean flag;
		try {


			DataTestingParameters mparam = setMappersParamUsingExcel(iDENTITYPROVIDERTESTDATASHEET, mapper, useSuffix);

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
