package nexgen.automation.framework.connectionRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import nexgen.automation.framework.administration.GroupsServicePage;
import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.util.APIUtil;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;
import nexgen.automation.pageclasses.otherpages.HomePage;
import nextgen.automation.RuleRepo.pages.TestDataThroughApi;
import nextgen.automation.workflow.service.pages.DataTestingParameters;

public class SecretsPage extends PageUtil {

	WebDriver driver;

	public SecretsPage(WebDriver driver) {
		this.driver = driver;
	}

	protected static final Logger log = Logger.getLogger(SecretsPage.class);
	static String dirPath=System.getProperty("user.dir");

	public static final String SECRETSEXCELPATH=dirPath+ Constant.NEXTGEN_SECRETS_TESTDATA_EXCEL_PATH;

	/** ----------------------  By locators ---------------------------------- **/

	By dataTSpinner=getElementLocator(prop.getProperty("dataT.spinner"));
	By icedqLogo = getElementLocator(prop.getProperty("Home.icedq_Logo"));
	By userProfile = getElementLocator(prop.getProperty("Home.userProfile"));
	By toastMsg=getElementLocator(prop.getProperty("Workflow.Toast.Message"));
	By toastMsgClosedBtn=getElementLocator(prop.getProperty("Workflow.Toast.Close"));	

	By connectionsTab=getElementLocator(prop.getProperty("connections.submodule.connections"));
	By userConnectionsTab=getElementLocator(prop.getProperty("connections.submodule.userconnections"));
	By secretsTab=getElementLocator(prop.getProperty("connections.submodule.secrets"));
	By secretsBreadcrumbHome=getElementLocator(prop.getProperty("secrets.breadcrumb.home"));
	By secretsBreadcrumbConnectors=getElementLocator(prop.getProperty("secrets.breadcrumb.connectors"));
	By secretsBreadcrumbSecrets=getElementLocator(prop.getProperty("secrets.breadcrumb.secrets"));
	By secretsBreadcrumbSecretsLink=getElementLocator(prop.getProperty("secrets.breadcrumb.secretsLink"));
	By secretsListingPageTitle=getElementLocator(prop.getProperty("secrets.listingpage.title"));
	By secretsListingPageSearchField=getElementLocator(prop.getProperty("secrets.listingpage.search.field"));
	By secretsListingPageSearchClear=getElementLocator(prop.getProperty("secrets.listingpage.search.clear"));
	By secretsListingPageSearchButton=getElementLocator(prop.getProperty("secrets.listingpage.search.button"));
	By secretsListingPageNewSecret=getElementLocator(prop.getProperty("secrets.listingpage.button.newsecret"));
	By secretsListingPageRefreshButton=getElementLocator(prop.getProperty("secrets.listingpage.button.refresh"));
	By secretsListingPageColumnName=getElementLocator(prop.getProperty("secrets.listingpage.column.name"));
	By secretsListingPageColumnDescription=getElementLocator(prop.getProperty("secrets.listingpage.column.description"));
	By secretsListingPageColumnVault=getElementLocator(prop.getProperty("secrets.listingpage.column.vault"));
	By secretsListingPagePaginationBar=getElementLocator(prop.getProperty("secrets.listing.pagination.bar"));
	By secretsListingPagePaginationInfo=getElementLocator(prop.getProperty("secrets.listing.pagination.info"));
	By secretsListingPageNoRecordsToDisplay=getElementLocator(prop.getProperty("secrets.listing.norecordstodisplay"));
	By secretsListingPageNextPageArrow=getElementLocator(prop.getProperty("secrets.listing.nextpageArrow"));
	By secretsListingPageDescriptionList=getElementLocator(prop.getProperty("secrets.listing.secretDesc.list"));

	By secretsListingAdvancedSearchTitle=getElementLocator(prop.getProperty("secrets.advancedSearch.title"));
	By secretsListingAdvancedSearchTypeLabel=getElementLocator(prop.getProperty("secrets.advancedSearch.Type.label"));
	By secretsListingAdvancedSearchTypeExpand=getElementLocator(prop.getProperty("secrets.advancedSearch.Type.expandButton"));
	By secretsListingAdvancedSearchTypeCollapse=getElementLocator(prop.getProperty("secrets.advancedSearch.Type.collapseButton"));
	By secretsListingAdvancedSearchTypeList=getElementLocator(prop.getProperty("secrets.advancedSearch.Type.list"));
	By secretsListingAdvancedSearchUpdatedByLabel=getElementLocator(prop.getProperty("secrets.advancedSearch.UpdatedBy.label"));
	By secretsListingAdvancedSearchUpdatedByExpand=getElementLocator(prop.getProperty("secrets.advancedSearch.UpdatedBy.expandButton"));
	By secretsListingAdvancedSearchUpdatedByCollapse=getElementLocator(prop.getProperty("secrets.advancedSearch.UpdatedBy.collapseButton"));
	By secretsListingAdvancedSearchUpdatedBySearchField=getElementLocator(prop.getProperty("secrets.advancedSearch.UpdatedBy.searchbar"));
	By secretsListingAdvancedSearchUpdatedBySearchButton=getElementLocator(prop.getProperty("secrets.advancedSearch.UpdatedBy.searchBtn"));
	By secretsListingAdvancedSearchUpdatedByList=getElementLocator(prop.getProperty("secrets.advancedSearch.UpdatedBy.list"));

	By secretsListingAdvancedSearchLastUpdatedLabel=getElementLocator(prop.getProperty("secrets.advancedSearch.LastUpdated.label"));
	By secretsListingAdvancedSearchLastUpdatedExpand=getElementLocator(prop.getProperty("secrets.advancedSearch.LastUpdated.expandButton"));
	By secretsListingAdvancedSearchLastUpdatedCollapse=getElementLocator(prop.getProperty("secrets.advancedSearch.LastUpdated.collapseButton"));

	By advancedSearchLastUpdatedFrom=getElementLocator(prop.getProperty("secrets.advancedSearch.LastUpdated.fromField"));
	By advancedSearchLastUpdatedFromDateIcon=getElementLocator(prop.getProperty("secrets.advancedSearch.LastUpdated.fromField.dateicon"));
	By advancedSearchLastUpdatedTo=getElementLocator(prop.getProperty("secrets.advancedSearch.LastUpdated.toField"));
	By advancedSearchLastUpdatedToDateIcon=getElementLocator(prop.getProperty("secrets.advancedSearch.LastUpdated.toField.dateicon"));
	By advancedSearchLastUpdatedCalanderDatePopup=getElementLocator(prop.getProperty("secrets.advancedSearch.LastUpdated.calander.datePopup"));
	By advancedSearchLastUpdatedCalanderCurrentValue=getElementLocator(prop.getProperty("secrets.advancedSearch.LastUpdated.calander.currentYearMon"));
	By advancedSearchLastUpdatedCalanderPreviousBtn=getElementLocator(prop.getProperty("secrets.advancedSearch.LastUpdated.calander.previousMonBtn"));
	By advancedSearchLastUpdatedCalanderNextBtn=getElementLocator(prop.getProperty("secrets.advancedSearch.LastUpdated.calander.nextMonBtn"));
	By advancedSearchLastUpdatedCalanderTodayBtn=getElementLocator(prop.getProperty("secrets.advancedSearch.LastUpdated.calander.todayBtn"));

	By secretDetailsBreadcrumbHome=getElementLocator(prop.getProperty("secrets.details.breadcrumb.home"));
	By secretDetailsBreadcrumbConnectors=getElementLocator(prop.getProperty("secrets.details.breadcrumb.connectors"));
	By secretDetailsBreadcrumbSecrets=getElementLocator(prop.getProperty("secrets.details.breadcrumb.secrets"));
	By secretDetailsBreadcrumbCreateNewSecret=getElementLocator(prop.getProperty("secrets.details.breadcrumb.createnewsecret"));
	By secretDetailsPageTitleCreateNewSecret=getElementLocator(prop.getProperty("secrets.details.title.createnewsecret"));
	By secretDetailsPageTitleIcon=getElementLocator(prop.getProperty("secrets.details.title.icon"));
	By secretDetailsButtonSave=getElementLocator(prop.getProperty("secrets.details.button.save"));
	By secretDetailsButtonDiscard=getElementLocator(prop.getProperty("secrets.details.button.discard"));
	By secretDetailsButtonDelete=getElementLocator(prop.getProperty("secrets.details.button.delete"));
	By secretDetailsVaultTypeLabel=getElementLocator(prop.getProperty("secrets.details.field.vaulttype.label"));
	By secretDetailsVaultTypeField=getElementLocator(prop.getProperty("secrets.details.field.vaulttype.field"));
	By secretDetailsSecretNameLabel=getElementLocator(prop.getProperty("secrets.details.field.secretname.label"));
	By secretDetailsSecretNameField=getElementLocator(prop.getProperty("secrets.details.field.secretname.field"));
	By secretDetailsSecretNameValidation=getElementLocator(prop.getProperty("secrets.details.field.secretname.validation"));
	By secretDetailsSecretTypeLabel=getElementLocator(prop.getProperty("secrets.details.field.secretname.label"));
	By secretDetailsSecretTypeField=getElementLocator(prop.getProperty("secrets.details.field.secrettype.field"));
	By secretDetailsSecretTypelist=getElementLocator(prop.getProperty("secrets.details.field.secrettype.list"));
	By secretDetailsSecretDescLabel=getElementLocator(prop.getProperty("secrets.details.field.description.label"));
	By secretDetailsSecretDescField=getElementLocator(prop.getProperty("secrets.details.field.description.field"));
	By secretDetailsSecretDescValidation=getElementLocator(prop.getProperty("secrets.details.field.secretdesc.validation"));
	By secretDetailsTab=getElementLocator(prop.getProperty("secrets.details.tab.details"));
	By secretDetailsSecretKeyAddButton=getElementLocator(prop.getProperty("secrets.details.key.button.add"));
	By secretDetailsSecretKeyImportJsonButton=getElementLocator(prop.getProperty("secrets.details.key.button.importjson"));
	By secretDetailsSecretKeyDeleteButton=getElementLocator(prop.getProperty("secrets.details.key.button.delete"));
	By secretDetailsSecretSearchField=getElementLocator(prop.getProperty("secrets.details.field.search.field"));
	By secretDetailsSecretSearchButton=getElementLocator(prop.getProperty("secrets.details.field.search.button"));
	By secretDetailsSecretSearchClear=getElementLocator(prop.getProperty("secrets.details.field.search.clear"));
	By secretDetailsSecretKeysMasterCheckbox=getElementLocator(prop.getProperty("secrets.details.property.mastercheckbox"));
	By secretDetailsSecretColumnKey=getElementLocator(prop.getProperty("secrets.details.property.column.key"));
	By secretDetailsSecretColumnValue=getElementLocator(prop.getProperty("secrets.details.property.column.value"));
	By secretDetailsSecretColumnActions=getElementLocator(prop.getProperty("secrets.details.property.column.actions"));
	By secretDetailsSecretNoRecordsToDisplay=getElementLocator(prop.getProperty("secrets.details.property.norecordstodisplay"));
	By secretDetailsSecretkeyField=getElementLocator(prop.getProperty("secrets.details.property.keyfield"));
	By secretDetailsSecretValueField=getElementLocator(prop.getProperty("secrets.details.property.valuefield"));
	By secretDetailsSecretKeySaveIcon=getElementLocator(prop.getProperty("secrets.details.property.button.save"));
	By secretDetailsSecretKeyEditIcon=getElementLocator(prop.getProperty("secrets.details.property.button.edit"));
	By secretDetailsSecretKeyDeleteIcon=getElementLocator(prop.getProperty("secrets.details.property.button.delete"));
	By secretDetailsSecretKeyCancelIcon=getElementLocator(prop.getProperty("secrets.details.property.button.cancel"));

	By popupDeleteAllKeyTitle=getElementLocator(prop.getProperty("secrets.details.popup.title.deleteAllKey"));
	By popupDeleteAllKeyContent=getElementLocator(prop.getProperty("secrets.details.popup.content.deleteAllKey"));
	By popupDeleteAllKeyCancel=getElementLocator(prop.getProperty("secrets.details.popup.cancelbutton.deleteAllKey"));
	By popupDeleteAllKeyDelete=getElementLocator(prop.getProperty("secrets.details.popup.deletebutton.deleteAllKey"));

	By popupDeleteKeyTitle=getElementLocator(prop.getProperty("secrets.details.popup.title.deleteKey"));
	By popupDeleteKeyContent=getElementLocator(prop.getProperty("secrets.details.popup.content.deleteKey"));
	By popupDeleteKeyCancel=getElementLocator(prop.getProperty("secrets.details.popup.cancelbutton.deleteKey"));
	By popupDeleteKeyDelete=getElementLocator(prop.getProperty("secrets.details.popup.deletebutton.deleteKey"));

	By popupDeleteSecretTitle=getElementLocator(prop.getProperty("secrets.details.popup.title.deleteSecret"));
	By popupDeleteSecretContent=getElementLocator(prop.getProperty("secrets.details.popup.content.deleteSecret"));
	By popupDeleteSecretCancel=getElementLocator(prop.getProperty("secrets.details.popup.cancelbutton.deleteSecret"));
	By popupDeleteSecretDelete=getElementLocator(prop.getProperty("secrets.details.popup.deletebutton.deleteSecret"));

	By popupDiscardSecretTitle=getElementLocator(prop.getProperty("secrets.details.popup.title.discardSecret"));
	By popupDiscardSecretContent=getElementLocator(prop.getProperty("secrets.details.popup.content.discardSecret"));
	By popupDiscardSecretCancel=getElementLocator(prop.getProperty("secrets.details.popup.cancelbutton.discardSecret"));
	By popupDiscardSecretDiscard=getElementLocator(prop.getProperty("secrets.details.popup.discardbutton.discardSecret"));

	By discardButtons=getElementLocator(prop.getProperty("workflow.details.discard.window"));

	By secretsListingButtonsCount=getElementLocator(prop.getProperty("button.count.listing.secrets"));
	By secretsDetailsBeforeCreateButtonsCount=getElementLocator(prop.getProperty("button.count.details.secrets"));
	/** ----------------------  String variables ---------------------------------- **/

	String secretsListingPageDynamicNameAvatar=prop.getProperty("secrets.listing.dynamic.name.avatar");
	String secretsListingPageDynamicName=prop.getProperty("secrets.listing.dynamic.name");
	String secretsListingPageDynamicNameDescription=prop.getProperty("secrets.listing.dynamic.description");
	String secretsListingPageDynamicNameVaultType=prop.getProperty("secrets.listing.dynamic.vaulttype");
	String secretsListingPageDynamicUpdatedBy=prop.getProperty("secrets.listing.dynamic.updatedby");
	String secretsListingPageDynamicUpdatedDate=prop.getProperty("secrets.listing.dynamic.updateddate");
	String secretsListingAdvancedSearchTypeCheckbox=prop.getProperty("secrets.advancedSearch.Type.checkbox");
	String secretsListingAdvancedSearchUpdatedByCheckbox=prop.getProperty("secrets.advancedSearch.UpdatedBy.checkbox");
	String advanceSearchLastUpdatedCalanderSelectMon=prop.getProperty("secrets.advancedSearch.LastUpdated.calander.selectMonYear");
	String advanceSearchLastUpdatedCalanderSelectDate=prop.getProperty("secrets.advancedSearch.LastUpdated.calander.selectdate");
	String secretDetailsBreadcrumbDynamicName=prop.getProperty("secrets.details.breadcrumb.name.dynamic");

	String secretDetailsSecretNameTitleDynamic=prop.getProperty("secrets.details.title.name.dynamic");
	String secretDetailsSecretTypeDynamic=prop.getProperty("secrets.details.title.icon.dynamic");
	String secretDetailsSecretTypeSelectDynamic=prop.getProperty("secrets.details.field.secrettype.select.dynamic");
	String secretDetailsSecretKeyFieldDynamic=prop.getProperty("secrets.details.property.keyField.dynamic");
	String secretDetailsSecretValueFieldDynamic=prop.getProperty("secrets.details.property.valueField.dynamic");
	String secretDetailsSecretEditButtonDynamic=prop.getProperty("secrets.details.property.editbutton");
	String secretDetailsSecretDeleteButtonDynamic=prop.getProperty("secrets.details.property.deletebutton");
	String secretDetailsSecretSaveButtonDynamic=prop.getProperty("secrets.details.property.savebutton");
	String secretDetailsSecretCancelButtonDynamic=prop.getProperty("secrets.details.property.cancelbutton");

	String placeholderSearchSecret=prop.getProperty("secrets.details.placeholder.searchsecret");
	String placeholderSearchUser=prop.getProperty("placeholder.search.user");
	String placeholderEnterSecretName=prop.getProperty("secrets.details.placeholder.entersecretname");
	String placeholderEnterDescription=prop.getProperty("secrets.details.placeholder.enterdescription");
	String placeholderSearch=prop.getProperty("secrets.details.placeholder.search");

	String fieldValidationForEmptySecretName=prop.getProperty("secrets.field.validation.emptysecretname");

	String toastMessageSave=prop.getProperty("secrets.toast.save");
	String toastMessageDeleteSecret=prop.getProperty("secrets.toast.delete");

	String popupDeleteAllKeyContentMsg=prop.getProperty("secrets.popup.content.deleteAllKey");
	String popupDeleteKeyContentMsg=prop.getProperty("secrets.popup.content.deleteKey");
	String popupDeleteSecretContentMsg=prop.getProperty("secrets.popup.content.deleteSecret");
	String popupDiscardSecretContentMsg=prop.getProperty("secrets.popup.content.discardSecret");

	String cancelButtonContent=prop.getProperty("string.cancelButtonContent");
	String nextContent=prop.getProperty("string.nextContent");
	String refreshContent=prop.getProperty("string.refreshContent");
	String attributeClass=prop.getProperty("string.attributeClass");
	String attrcheck=prop.getProperty("string.attrcheck");
	String attrUncheck=prop.getProperty("string.attrUncheck");
	String attributeValue=prop.getProperty("string.attributeValue");
	String attributeTextContent=prop.getProperty("string.attributeTextContent");
	String attributeTitle=prop.getProperty("string.attributeTitle");
	String attributePlaceholder=prop.getProperty("string.attributePlaceholder");
	String attributeAriaLabel=prop.getProperty("string.attributeAriaLabel");
	String discardContent=prop.getProperty("string.discardContent");
	String errorLogTitle=prop.getProperty("string.Error.Log.Title");
	String hyphenContent=prop.getProperty("String.hyphenContent");
	String moduleTab=prop.getProperty("nextgen.hamberger.tab");
	String subModuleTab=prop.getProperty("nextgenmodule.submodule.tab");
	String subModuleHeadingName=prop.getProperty("nextgenmodule.submodule.headingDynamic");
	String dynamicName=prop.getProperty("DynName");
	String nextgenSubModuleDynamic=prop.getProperty("nextgenmodule.submodule.dynamic");
	String administrationContent=prop.getProperty("String.administrationContent");
	String dataTestingContent=prop.getProperty("String.dataTestingContent");
	String schedulerContent=prop.getProperty("String.schedulerContent");
	String connectionsContent=prop.getProperty("String.connectionsContent");
	String connectorsContent=prop.getProperty("String.connectorsContent");
	String moduleContent=prop.getProperty("String.moduleContent");
	String subModuleContent=prop.getProperty("String.subModuleContent");
	String columnContent=prop.getProperty("String.columnContent");
	String tabContent=prop.getProperty("String.tabContent");
	String iconContent=prop.getProperty("String.iconContent");
	String breadcrumbContent=prop.getProperty("String.breadcrumbContent");
	String homeContent=prop.getProperty("String.homeContent");
	String hyperlinkContent=prop.getProperty("String.hyperlinkContent");
	String labelContent=prop.getProperty("String.labelContent");
	String masterContent=prop.getProperty("String.masterContent");
	String checkboxContent=prop.getProperty("String.checkboxContent");
	String adminContent=prop.getProperty("String.adminContent");
	String noRecordsToDisplayContent=prop.getProperty("String.noRecordsToDisplayContent");
	String descriptionContent=prop.getProperty("string.descriptionContent");
	String saveContent=prop.getProperty("string.saveContent");
	String deleteContent=prop.getProperty("string.deleteContent");
	String executorContent=prop.getProperty("string.executorContent");
	String readerContent=prop.getProperty("string.readerContent");
	String ownerContent=prop.getProperty("string.ownerContent");
	String contributorContent=prop.getProperty("string.contributorContent");
	String avatarContent=prop.getProperty("String.avatarContent");

	String secretsContent="Secrets";
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
	String verifyButtonContent=" Verifying buttons on Secrets details page ";
	String verifyTabContent=" Verifying tabs on Secrets details page ";
	String accountListingPageContent="Secrets listing page";
	String addButtonContent="Add";
	String testingContent="Testing";
	String notVisibleContent="is not visible";
	String visibleContent=" is visible";
	String keyContent="Key";
	String valueContent="Value";
	String fieldContent="field";
	String newSecretContent="New Secret";

	String vaultTypeContent="Vault Type";
	String secretNameContent="Secret Name";
	String secretTypeContent="Secret Type";
	String deleteKeysContent="Delete Keys";
	String publicContent="public";
	String privateContent="private";
	String noRecordToDisplyContent="No records to display";
	String repeatedKeyContent="Repeated key";

	public static final boolean FLAGFORNAMEWITHUSERNAME=Boolean.parseBoolean(prop.getProperty("secrets.flag.name.with.username"));

	public static final String REFCOL="refkey";
	public static final String USERSHEET="secretKey";
	static String secretNameColumn="secretName";
	static String secretDescColumn="secretDescription";

	String sanity = "sanity";
	/** ----------------------  methods ---------------------------------- **/

	public void handleDiscardWindow() {
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if (isDisplayed(driver, discardButtons, 2)) {
				clickOnButton(driver, discardButtons, discardContent, true);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" handleDiscardWindow :: "+e.toString());

		}
	}

	public boolean clickOnSecretsTab() {

		boolean flag = false;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 0, secretsListingPageNewSecret);

			if(!isDisplayed(driver, secretsListingPageNewSecret)) {

				isDisplayedInLoop(driver, 1, secretsTab);

				if(isDisplayed(driver, secretsTab, 1)) {

					flag = isClickable(driver, secretsTab, secretsContent+" tab", true);

					if(flag) {

						BaseSuite.reportLog(" Clicking on "+secretsContent+" tab");

						displayAndClick(driver, secretsTab);

						handleDiscardWindow();

						BaseSuite.validationReportLog(" Clicked on "+secretsContent+" tab");

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

						flag=validateElement(driver, secretsListingPageTitle, secretsContent, attributeTitle);

						clickOnButton(driver, secretsListingPageRefreshButton, refreshContent, true);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					}

				}else {
					BaseSuite.reportFailLog(secretsContent+" tab not visible ", "clickOnSecretsTab");
				}
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnSecretsTab :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean validateSecretsListingPage() {
		boolean flag=true;
		HomePage hp=new HomePage(driver);
		try {

			clickOnButton(driver, secretsListingPageRefreshButton, refreshContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			hp.validateNextgenIcedqModuleAndSecretsSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Secrets listing page "+hyphenContent);

			validateElement(driver, secretsBreadcrumbHome, homeContent, hyperlinkContent);

			validateElement(driver,secretsBreadcrumbConnectors, connectorsContent, hyperlinkContent);

			validateElement(driver,secretsBreadcrumbSecrets, secretsContent, labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying Title and Search field Secrets listing page "+hyphenContent);

			verifyIndividualLabel(driver, secretsListingPageTitle, secretsContent);

			verifySearchField(driver,secretsListingPageSearchField, placeholderSearchSecret, placeholderSearchSecret);

			validateElement(driver,secretsListingPageSearchButton, placeholderSearchSecret, "button");

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Secrets listing page "+hyphenContent);

			validateButtons(driver, secretsListingButtonsCount, 3);

			verifyVisibilityOfButtons(driver, secretsListingPageNewSecret, newSecretContent, true);
			verifyVisibilityOfButtons(driver, secretsListingPageRefreshButton, refreshContent, true);

			BaseSuite.reportLog(hyphenContent+"  Verifying Columns on Secrets listing page "+hyphenContent);

			validateElement(driver,secretsListingPageColumnName, "Name",columnContent);
			validateElement(driver,secretsListingPageColumnDescription, descriptionContent, columnContent);
			validateElement(driver,secretsListingPageColumnVault, "Vault", columnContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on Secrets listing page "+hyphenContent);

			getPaginationDetails(driver,secretsListingPagePaginationInfo, secretsListingPagePaginationBar,secretsListingPageNoRecordsToDisplay, accountListingPageContent);

			validateSecretsListingSidebar();

			BaseSuite.validationReportLog(hyphenContent+" Secrets listing page validated successfully "+hyphenContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateSecretsListingPage :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public void printlist(By locator, String label , String attribute) {
		List<WebElement> types = getElements(driver, locator);

		for(int i =0;i<types.size();i++) {

			String typename = types.get(i).getAttribute(attribute);

			BaseSuite.reportLog((i+1)+". "+typename+" "+label+visibleContent);

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
	public boolean validateSecretsListingSidebar() {
		boolean flag=true;
		try {
			verifyIndividualLabel(driver, secretsListingAdvancedSearchTitle, "Advanced Search");

			verifyIndividualLabel(driver, secretsListingAdvancedSearchTypeLabel, "Type");

			if(isDisplayed(driver, secretsListingAdvancedSearchTypeExpand)) {

				displayAndClick(driver, secretsListingAdvancedSearchTypeExpand);

				waitForExecution(500);
			}

			printlist(secretsListingAdvancedSearchTypeList, "type", attributeTextContent);

			verifyIndividualLabel(driver, secretsListingAdvancedSearchUpdatedByLabel, "Updated By");

			if(isDisplayed(driver, secretsListingAdvancedSearchUpdatedByExpand)) {

				displayAndClick(driver, secretsListingAdvancedSearchUpdatedByExpand);

				waitForExecution(500);
			}

			verifySearchField(driver,secretsListingAdvancedSearchUpdatedBySearchField, placeholderSearchUser, placeholderSearchUser);

			validateElement(driver,secretsListingAdvancedSearchUpdatedBySearchButton, placeholderSearchSecret, "button");

			verifyIndividualLabel(driver, secretsListingAdvancedSearchLastUpdatedLabel, "Last Updated");

			if(isDisplayed(driver, secretsListingAdvancedSearchLastUpdatedExpand)) {

				displayAndClick(driver, secretsListingAdvancedSearchLastUpdatedExpand);

				waitForExecution(500);
			}

			BaseSuite.validationReportLog("From field is visible");

			verifyPlaceHolderValue(advancedSearchLastUpdatedFrom, "From", "From");

			isEditable(driver, advancedSearchLastUpdatedFrom, "From");

			BaseSuite.validationReportLog("To field is visible");

			verifyPlaceHolderValue(advancedSearchLastUpdatedTo, "To", "To");

			isEditable(driver, advancedSearchLastUpdatedTo, "To");


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateSecretsListingSidebar :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnNewSecretButton(String icedqUser, String vaultType, boolean validateCretePage) {
		boolean flag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=clickOnButton(driver, secretsListingPageNewSecret, newSecretContent, true);

			if(flag) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 1, toastMsg);

				if (isDisplayed(driver, toastMsg) || icedqUser.toLowerCase().contains(readerContent)) {

					flag = captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
							"New Secret authorization message");

				}else {
					if(validateCretePage) {
						flag=validateCreateNewSecretPage(vaultType);
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnNewSecretButton :: "+e.toString());
			flag=false;
		}


		return flag;
	}

	public boolean validateCreateNewSecretPage(String vaultType) {
		boolean flag=true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Secrets details page "+hyphenContent);

			validateElement(driver, secretDetailsBreadcrumbHome, homeContent, hyperlinkContent);

			validateElement(driver,secretDetailsBreadcrumbConnectors, connectorsContent, hyperlinkContent);

			validateElement(driver,secretsBreadcrumbSecretsLink, secretsContent, hyperlinkContent);

			validateElement(driver,secretDetailsBreadcrumbCreateNewSecret, "Create New Secret", labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying Title of Secrets details page "+hyphenContent);

			verifyIndividualLabel(driver, secretDetailsPageTitleCreateNewSecret, "Create New Secret");

			validateElement(driver,secretDetailsPageTitleIcon, "public secret", iconContent);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons of Secrets details page "+hyphenContent);

			validateButtons(driver, secretsDetailsBeforeCreateButtonsCount, 6);

			verifyVisibilityOfButtons(driver, secretDetailsButtonSave, saveContent, false);
			verifyVisibilityOfButtons(driver, secretDetailsButtonDiscard, discardContent, false);
			verifyVisibilityOfButtons(driver, secretDetailsButtonDelete, deleteContent, false);

			BaseSuite.reportLog(hyphenContent+" Verifying field of Secrets details page "+hyphenContent);

			validateElement(driver,secretDetailsVaultTypeLabel, vaultTypeContent, labelContent);
			validateField(driver, secretDetailsVaultTypeField, vaultTypeContent, "", fieldContent, vaultType, attributeValue,false);

			validateElement(driver,secretDetailsSecretNameLabel, secretNameContent, labelContent);
			verifyPlaceHolderValue(secretDetailsSecretNameField, secretNameContent, placeholderEnterSecretName);

			validateElement(driver,secretDetailsSecretTypeLabel, secretTypeContent, labelContent);
			validateField(driver, secretDetailsSecretTypeField, secretTypeContent, "", fieldContent, "Public", attributeTextContent,true);

			validateElement(driver,secretDetailsSecretDescLabel, descriptionContent, labelContent);
			verifyPlaceHolderValue(secretDetailsSecretDescField, descriptionContent, placeholderEnterDescription);

			BaseSuite.reportLog(hyphenContent+" Verifying Details tab on secrets details page "+hyphenContent);

			verifyVisibilityOfButtons(driver, secretDetailsSecretKeyAddButton, addButtonContent, true);

			verifyVisibilityOfButtons(driver, secretDetailsSecretKeyImportJsonButton, "Import Json", true);
			verifyVisibilityOfButtons(driver, secretDetailsSecretKeyDeleteButton, deleteKeysContent, false);

			BaseSuite.reportLog(hyphenContent+" Verifying search field on secrets details page "+hyphenContent);

			verifySearchField(driver,secretDetailsSecretSearchField, placeholderSearch, placeholderSearch);

			validateElement(driver, secretDetailsSecretSearchButton, placeholderSearch, "icon");

			BaseSuite.reportLog(hyphenContent+" Verifying columns on secrets details page "+hyphenContent);

			validateElement(driver, secretDetailsSecretKeysMasterCheckbox, masterContent, checkboxContent);
			validateElement(driver, secretDetailsSecretColumnKey, keyContent, columnContent);
			validateElement(driver, secretDetailsSecretColumnValue, valueContent, columnContent);
			validateElement(driver, secretDetailsSecretColumnActions, "Actions", columnContent);

			validateElement(driver, secretDetailsSecretNoRecordsToDisplay, noRecordToDisplyContent, labelContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateSecretsListingSidebar :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean validateAfterSecretCreated(String vaultType, String secretName, String secretDesc, String secretType) {
		boolean flag=true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Secrets details page "+hyphenContent);

			validateElement(driver, secretDetailsBreadcrumbHome, homeContent, hyperlinkContent);

			validateElement(driver,secretDetailsBreadcrumbConnectors, connectorsContent, hyperlinkContent);

			validateElement(driver,secretsBreadcrumbSecretsLink, secretsContent, hyperlinkContent);

			validateElement(driver,returnElement(secretDetailsBreadcrumbDynamicName, dynamicName, secretName), secretName, labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying Title of Secrets details page "+hyphenContent);

			validateElement(driver, returnElement(secretDetailsSecretNameTitleDynamic, dynamicName, secretName), secretName, attributeTitle);

			validateElement(driver,returnElement(secretDetailsSecretTypeDynamic, dynamicName, secretType), secretType, iconContent);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons of Secrets details page "+hyphenContent);

			validateButtons(driver, secretsDetailsBeforeCreateButtonsCount, 6);

			verifyVisibilityOfButtons(driver, secretDetailsButtonSave, saveContent, false);
			verifyVisibilityOfButtons(driver, secretDetailsButtonDiscard, discardContent, false);
			verifyVisibilityOfButtons(driver, secretDetailsButtonDelete, deleteContent, true);

			BaseSuite.reportLog(hyphenContent+" Verifying field of Secrets details page "+hyphenContent);

			validateElement(driver,secretDetailsVaultTypeLabel, vaultTypeContent, labelContent);
			validateField(driver, secretDetailsVaultTypeField, vaultTypeContent, "", fieldContent, vaultType, attributeValue,false);
			isDisabledOrNot(driver, secretDetailsVaultTypeField, vaultType, fieldContent);

			validateElement(driver,secretDetailsSecretNameLabel, secretNameContent, labelContent);
			validateValueWithActual(secretDetailsSecretNameField, secretNameContent, secretName, attributeValue);
			isDisabledOrNot(driver, secretDetailsSecretNameField, secretName, fieldContent);

			validateElement(driver,secretDetailsSecretTypeLabel, secretTypeContent, labelContent);
			validateValueWithActual(secretDetailsSecretTypeField, secretTypeContent, secretType, attributeTextContent);
			isDisabledOrNot(driver, secretDetailsSecretTypeField, secretType, fieldContent);

			validateElement(driver,secretDetailsSecretDescLabel, descriptionContent, labelContent);
			validateValueWithActual(secretDetailsSecretDescField, descriptionContent, secretDesc, attributeValue);

			BaseSuite.reportLog(hyphenContent+" Verifying Details tab on secrets details page "+hyphenContent);

			verifyVisibilityOfButtons(driver, secretDetailsSecretKeyAddButton, addButtonContent, true);

			verifyVisibilityOfButtons(driver, secretDetailsSecretKeyImportJsonButton, "Import Json", true);
			verifyVisibilityOfButtons(driver, secretDetailsSecretKeyDeleteButton, deleteKeysContent, false);

			BaseSuite.reportLog(hyphenContent+" Verifying search field on secrets details page "+hyphenContent);

			verifySearchField(driver,secretDetailsSecretSearchField, placeholderSearch, placeholderSearch);

			validateElement(driver, secretDetailsSecretSearchButton, placeholderSearch, "icon");

			BaseSuite.reportLog(hyphenContent+" Verifying columns on secrets details page "+hyphenContent);

			validateElement(driver, secretDetailsSecretKeysMasterCheckbox, masterContent, checkboxContent);
			validateElement(driver, secretDetailsSecretColumnKey, keyContent, columnContent);
			validateElement(driver, secretDetailsSecretColumnValue, valueContent, columnContent);
			validateElement(driver, secretDetailsSecretColumnActions, "Actions", columnContent);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateAfterSecretCreated :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean selectSecretType(String secretType) {
		boolean flag=true;
		try {
			isDisplayedInLoop(driver, 2, secretDetailsSecretTypeField);

			if(isDisplayed(driver, secretDetailsSecretTypeField)){

				BaseSuite.reportLog("secret type field is visible");

				BaseSuite.reportLog("Clicking on secret type field dropdown");

				displayAndClick(driver, secretDetailsSecretTypeField);

				BaseSuite.reportLog("Clicked on secret type field dropdown");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				printlist(secretDetailsSecretTypelist, "Secret Type", attributeTextContent);

				isDisplayedInLoop(driver, 2, returnElement(secretDetailsSecretTypeSelectDynamic, dynamicName, secretType));

				if(isDisplayed(driver, returnElement(secretDetailsSecretTypeSelectDynamic, dynamicName, secretType))) {

					BaseSuite.reportLog(secretType+" secret type is visible");

					BaseSuite.reportLog("Clicking on "+secretType+" secret type");

					displayAndClick(driver, returnElement(secretDetailsSecretTypeSelectDynamic, dynamicName, secretType));

					BaseSuite.reportLog("Clicked on "+secretType+" secret type");

				}else {
					BaseSuite.reportFailLog("Secret type not visible", "selectSecretType");
					flag=false;
				}

			}else {
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" selectSecretType :: "+e.toString());
			flag=false;
		}
		return flag;

	}


	public boolean enterKeyAndValueOfSecret(int i, String key, String value, String toastValidation) {
		boolean flag=true;
		try {

			BaseSuite.reportLog("----------- Adding "+(i)+"  secret "+keyContent+" : "+key+" & "+valueContent+" : "+value );

			clickOnButton(driver, secretDetailsSecretKeyAddButton, addButtonContent, true);

			waitForExecution(100);

			enterValueToTextField(driver, secretDetailsSecretkeyField,  keyContent+" "+fieldContent, key);

			enterValueToTextField(driver, secretDetailsSecretValueField,  valueContent+" "+fieldContent, value);

			verifyVisibilityOfButtons(driver, secretDetailsSecretKeyCancelIcon, cancelButtonContent, true);

			clickOnButton(driver, secretDetailsSecretKeySaveIcon, "Right tick arrow", true);

			waitForExecution(100);

			validateToastMessage(flag, repeatedKeyContent, toastValidation);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" enterKeyAndValueOfSecret "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean enterKeyInSecretForValidation(int i, String key) {
		boolean flag=true;

		try {
			BaseSuite.reportLog("---------- Adding "+(i)+" secret "+keyContent+" : "+key);

			clickOnButton(driver, secretDetailsSecretKeyAddButton, addButtonContent, true);

			waitForExecution(100);

			enterValueToTextField(driver, secretDetailsSecretkeyField,  keyContent+" "+fieldContent, key);

			waitForExecution(100);

			displayAndClick(driver, secretDetailsSecretValueField);

			flag=getCSSColorOfElement(driver, secretDetailsSecretkeyField, keyContent+" "+fieldContent, "border-top-color", "red");
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" enterKeyInSecretForValidation "+e.toString());
			flag=false;
		}
		return flag;

	}


	public boolean enterValueInSecretForValidation(int i, String value) {
		boolean flag=true;

		try {
			BaseSuite.reportLog("---------- Adding "+(i)+" secret "+valueContent+" : "+value );

			clickOnButton(driver, secretDetailsSecretKeyAddButton, addButtonContent, true);

			waitForExecution(100);

			enterValueToTextField(driver, secretDetailsSecretValueField,  valueContent+" "+fieldContent, value);

			waitForExecution(100);

			displayAndClick(driver, secretDetailsSecretkeyField);

			flag=getCSSColorOfElement(driver, secretDetailsSecretValueField, valueContent+" "+fieldContent, "border-top-color", "red");
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" enterValueInSecretForValidation "+e.toString());
			flag=false;
		}
		return flag;

	}

	public static DataTestingParameters setSecretKeyValueParamUsingExcel(String filePath, String keys) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		try {

			param.setSecretKey(xl.readUsingColNameAndCellContains(filePath, USERSHEET, REFCOL, keys,"secretkey"));
			param.setSecretValue(xl.readUsingColNameAndCellContains(filePath, USERSHEET, REFCOL, keys,"secretvalue"));
			param.setEditSecretKey(xl.readUsingColNameAndCellContains(filePath, USERSHEET, REFCOL, keys,"editkey"));
			param.setEditSecretValue(xl.readUsingColNameAndCellContains(filePath, USERSHEET, REFCOL, keys,"editvalue"));
			param.setDeleteSecretKey(xl.readUsingColNameAndCellContains(filePath, USERSHEET, REFCOL, keys,"deletekey"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setSecretKeyValueParamUsingExcel "+e.toString());
		}
		return param;

	}

	public static String[] getDynamicSuffix(boolean useSuffix, String icedqUser) {
		if (!useSuffix) return new String[]{"", ""};

		if (icedqUser.isEmpty()) {
			return new String[]{System.getProperty("foldersuffix", ""), System.getProperty("updatefoldersuffix", "")};
		}

		if (icedqUser.contains("owner") || icedqUser.contains("contributor")) {
			return new String[]{"_"+icedqUser, "_" + icedqUser};
		}

		if(icedqUser.contains("pre") || icedqUser.contains("execu") || icedqUser.contains("read")) {
			return new String[]{"", ""};
		}

		return new String[]{"_Lead", "_Lead"};
	}

	public static DataTestingParameters setSecretServiceParamUsingExcel(String filePath, String sheetName, int rowNumber, boolean useSuffix, String icedqUser) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();

		try {

			String [] sns=getDynamicSuffix(useSuffix, icedqUser);

			param.setTestScenarioName(xl.readUsingColName(filePath,sheetName, rowNumber, "testScenario"));
			param.setScenarioType(xl.readUsingColName(filePath,sheetName, rowNumber, "scenarioType"));
			param.setSecretName(xl.readUsingColName(filePath,sheetName, rowNumber, secretNameColumn)+sns[0]);
			param.setSecretDescription(xl.readUsingColName(filePath,sheetName, rowNumber, secretDescColumn));
			param.setUpdateSecretName(xl.readUsingColName(filePath,sheetName, rowNumber, secretNameColumn)+sns[1]);
			param.setUpdateSecretDescription(xl.readUsingColName(filePath,sheetName, rowNumber, secretDescColumn));
			param.setSecretType(xl.readUsingColName(filePath,sheetName, rowNumber, "secretType"));
			param.setVaultType(xl.readUsingColName(filePath,sheetName, rowNumber, "vaultType"));
			param.setSecretKeys(xl.readUsingColName(filePath,sheetName, rowNumber, "Keys"));
			param.setImportJson(xl.readUsingColName(filePath,sheetName, rowNumber, "importJson"));
			param.setEditSecretKey(xl.readUsingColName(filePath,sheetName, rowNumber, "editKeys"));
			param.setDeleteSecretKey(xl.readUsingColName(filePath,sheetName, rowNumber, "deleteKeys"));

			param.setFieldValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber, "fieldValidation"));
			param.setToastValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber, "toastValidation"));

		} catch (Exception e) {
			e.printStackTrace();
			BaseSuite.reportErrorLog("error occurs while setSecretServiceParamUsingExcel "+e.toString());
		}
		return param;

	}

	public boolean addSecretkeyAndValue(String secretKeys) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if (!secretKeys.isEmpty()) {

				if (secretKeys.contains(",")) {

					iceuserName = secretKeys.split(",");

					for (int i = 0; i < iceuserName.length; i++) {

						DataTestingParameters param = setSecretKeyValueParamUsingExcel(SECRETSEXCELPATH, iceuserName[i]);

						enterKeyAndValueOfSecret(i+1, param.getSecretKey(), param.getSecretValue(),"");
					}

				} else {

					DataTestingParameters param = setSecretKeyValueParamUsingExcel(SECRETSEXCELPATH, secretKeys);

					enterKeyAndValueOfSecret(1, param.getSecretKey(), param.getSecretValue(), "");

				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}



		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" addSecretkeyAndValue "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean addSecretkeyForInvalid(String secretKeys) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if (!secretKeys.isEmpty()) {

				if (secretKeys.contains(",")) {

					iceuserName = secretKeys.split(",");

					for (int i = 0; i < iceuserName.length; i++) {

						DataTestingParameters param = setSecretKeyValueParamUsingExcel(SECRETSEXCELPATH, iceuserName[i]);

						enterKeyInSecretForValidation(i+1, param.getSecretKey());

					}

				} else {

					DataTestingParameters param = setSecretKeyValueParamUsingExcel(SECRETSEXCELPATH, secretKeys);

					enterKeyInSecretForValidation(1, param.getSecretKey());

				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}



		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" addSecretkeyAndValueForInvalid "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean addSecretValueForInvalid(String secretKeys) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if (!secretKeys.isEmpty()) {

				if (secretKeys.contains(",")) {

					iceuserName = secretKeys.split(",");

					for (int i = 0; i < iceuserName.length; i++) {

						DataTestingParameters param = setSecretKeyValueParamUsingExcel(SECRETSEXCELPATH, iceuserName[i]);

						enterValueInSecretForValidation(i+1, param.getSecretValue());

					}

				} else {

					DataTestingParameters param = setSecretKeyValueParamUsingExcel(SECRETSEXCELPATH, secretKeys);

					enterValueInSecretForValidation(1, param.getSecretValue());

				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}



		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" addSecretkeyAndValueForInvalid "+e.toString());
			flag =false;
		}

		return flag;
	}



	public boolean clickOnSaveButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, secretDetailsButtonSave, saveContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Secret Created");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Secret Created");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnSaveButtonAndValidateToast "+e.toString());
			flag =false;
		}
		return flag;
	}

	public boolean clickOnDeleteButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(500);

			clickOnButton(driver, secretDetailsButtonDelete, deleteContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Secret delete");
				tag=false;
			}

			validateAndHandleDeleteSecretKeyPopupWindow(flag, deleteContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Secret delete");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnDeleteButtonAndValidateToast "+e.toString());
			flag =false;
		}
		return flag;
	}

	public boolean clickOnDiscardButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(500);

			clickOnButton(driver, secretDetailsButtonDiscard, discardContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Secret discard");
				tag=false;
			}

			validateAndHandleDiscardSecretPopupWindow(flag, discardContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Secret discard");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnDiscardButtonAndValidateToast "+e.toString());
			flag =false;
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

	public void validateSecretDetailsOnListingPage(String secretName, String secretDescription,String secretType, String vaultType) {

		try {

			waitForExecution(500);

			BaseSuite.reportLog(hyphenContent+" Verifying secret details on secrets listing page "+hyphenContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateElementVisibility(returnTwoElements(secretsListingPageDynamicName, dynamicName, secretName,dynamicType,secretType),secretType, avatarContent, true);

			validateElementVisibility(returnElement(secretsListingPageDynamicName, dynamicName, secretName), secretName, hyperlinkContent, true);

			validateValueWithActual(returnElement(secretsListingPageDynamicNameDescription,  dynamicName, secretName), descriptionContent, secretDescription, attributeTextContent);

			validateValueWithActual(returnElement(secretsListingPageDynamicNameVaultType,  dynamicName, secretName), vaultTypeContent, vaultType, attributeTextContent);

			String updatedby=getAttribute(driver, returnElement(secretsListingPageDynamicUpdatedBy, dynamicName, secretName), attributeTitle);

			BaseSuite.reportLog("Secret updated by : "+updatedby);

			String updateddate=getAttribute(driver, returnElement(secretsListingPageDynamicUpdatedDate, dynamicName, secretName), attributeTextContent);

			BaseSuite.reportLog("Secret updated date : "+updateddate);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateSecretDetailsOnListingPage :: "+e.toString());
		}

	}

	public boolean searchSecretNameOnEachPageAndClickOn(By locator,String name) {

		boolean flag=true;
		boolean nextpageFlag=true;
		int pn=0;

		try {

			do {

				BaseSuite.reportLog("searching secret name : "+name+" on page number :"+(pn+1));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 2, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportLog("secret name : "+name+" found on page number :"+(pn+1));

					flag=clickOnButton(driver, locator, name, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					if(!isDisplayed(driver, locator)) {
						flag=true;
					}

					break;
				}
				if(isDisplayed(driver, secretsListingPageNextPageArrow)) {

					String status = getAttribute(driver, secretsListingPageNextPageArrow, attributeClass);

					if (!status.contains("disable")) {

						BaseSuite.reportLog("searched secret name : "+name+" not found on page number :"+(pn+1));

						clickOnButton(driver, secretsListingPageNextPageArrow, "next page", true);
						pn++;
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					} else {
						BaseSuite.reportLog("Page arrow :: next page is disabled");
						nextpageFlag=false;
					}

				}

			}while(nextpageFlag);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchSecretNameOnEachPageAndClickOn :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean searchSecretAndClickOnName(String secretName) {
		boolean flag =true;

		try {

			flag=searchFunctionalityMethod(driver, flag, secretsListingPageSearchField, secretsListingPageSearchButton, placeholderSearchSecret, placeholderSearchSecret, secretName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && elementNotVisible(driver, secretsListingPageNoRecordsToDisplay)) {

				flag=searchSecretNameOnEachPageAndClickOn(returnElement(secretsListingPageDynamicName, dynamicName, secretName), secretName);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}else {
				BaseSuite.reportFailLog(noRecordsToDisplayContent+isVisibleContent,"searchSecretAndClickOnName");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchSecretAndClickOnName "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean searchSecret(String secretName) {
		boolean flag =true;

		try {

			flag=searchFunctionalityMethod(driver, flag, secretsListingPageSearchField, secretsListingPageSearchButton, placeholderSearchSecret, placeholderSearchSecret, secretName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && elementNotVisible(driver, returnElement(secretsListingPageDynamicName, dynamicName, secretName))) {

				flag =true;

			}else {

				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchSecretAndClickOnName "+e.toString());
			flag=false;
		}

		return flag;
	}

	public void validateKeyAndValueOfSecret(int i, String key, String value) {


		boolean flag=true;
		log.info(value);
		try {

			BaseSuite.reportLog(hyphenContent+"  verifying "+(i+1)+" secret key : "+key+ hyphenContent);

			flag=searchFunctionalityMethod(driver, true, secretDetailsSecretSearchField, secretDetailsSecretSearchButton, placeholderSearch, placeholderSearch, key);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && elementNotVisible(driver, secretDetailsSecretNoRecordsToDisplay)) {

				viewAndValidateField(driver, returnElement(secretDetailsSecretKeyFieldDynamic, dynamicName, key), keyContent, key, true);

				viewAndValidateField(driver, returnElement(secretDetailsSecretValueFieldDynamic, dynamicName, key), valueContent, "*****", true);

				verifyVisibilityOfButtons(driver, returnElement(secretDetailsSecretEditButtonDynamic, dynamicName, key), "Edit"+" "+keyContent, true);

				verifyVisibilityOfButtons(driver, returnElement(secretDetailsSecretDeleteButtonDynamic, dynamicName, key), deleteContent+" "+keyContent, true);

			}

			waitForExecution(500);

			searchFunctionalityMethod(driver, true, secretDetailsSecretSearchField, secretDetailsSecretSearchButton, placeholderSearch, placeholderSearch, "");


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateKeyAndValueOfSecret :: "+e.toString());

		}
	}

	public boolean viewSecretkeyAndValue(String secretKeys) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if (!secretKeys.isEmpty()) {

				if (secretKeys.contains(",")) {

					iceuserName = secretKeys.split(",");

					for (int i = 0; i < iceuserName.length; i++) {

						DataTestingParameters param = setSecretKeyValueParamUsingExcel(SECRETSEXCELPATH, iceuserName[i]);

						validateKeyAndValueOfSecret(i+1, param.getSecretKey(), param.getSecretValue());
					}

				} else {

					DataTestingParameters param = setSecretKeyValueParamUsingExcel(SECRETSEXCELPATH, secretKeys);

					validateKeyAndValueOfSecret(1, param.getSecretKey(), param.getSecretValue());

				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}



		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewSecretkeyAndValue "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean validateAndHandleRemoveAllSecretKeyPopupWindow(boolean flag,String buttonName) {

		try {
			waitForExecution(500);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			/**	validatePopupWindowContent(driver, flag, popupDeleteAllKeyTitle, popupDeleteAllKeyContent, deleteKeysContent, popupDeleteAllKeyContentMsg);
			 */
			verifyVisibilityOfButtons(driver, popupDeleteAllKeyCancel, cancelButtonContent, true);
			verifyVisibilityOfButtons(driver, popupDeleteAllKeyDelete, deleteContent, true);

			if(buttonName.equalsIgnoreCase(deleteContent)) {
				clickOnButton(driver, popupDeleteAllKeyDelete, buttonName, true);
			}else {
				clickOnButton(driver, popupDeleteAllKeyCancel, cancelButtonContent, true);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateAndHandleRemoveAllSecretKeyPopupWindow :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateAndHandleRemoveSecretKeyPopupWindow(boolean flag,String buttonName) {

		try {
			waitForExecution(500);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validatePopupWindowContent(driver, flag, popupDeleteKeyTitle, popupDeleteKeyContent, "Delete Key", popupDeleteKeyContentMsg);

			verifyVisibilityOfButtons(driver, popupDeleteKeyCancel, cancelButtonContent, true);
			verifyVisibilityOfButtons(driver, popupDeleteKeyDelete, deleteContent, true);

			if(buttonName.equalsIgnoreCase(deleteContent)) {
				clickOnButton(driver, popupDeleteKeyDelete, buttonName, true);
			}else {
				clickOnButton(driver, popupDeleteKeyCancel, cancelButtonContent, true);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateAndHandleRemoveSecretKeyPopupWindow :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateAndHandleDeleteSecretKeyPopupWindow(boolean flag,String buttonName) {

		try {
			waitForExecution(500);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validatePopupWindowContent(driver, flag, popupDeleteSecretTitle, popupDeleteSecretContent, "Delete Secret", popupDeleteSecretContentMsg);

			verifyVisibilityOfButtons(driver, popupDeleteSecretCancel, cancelButtonContent, true);
			verifyVisibilityOfButtons(driver, popupDeleteSecretDelete, deleteContent, true);

			if(buttonName.equalsIgnoreCase(deleteContent)) {
				clickOnButton(driver, popupDeleteSecretDelete, buttonName, true);
			}else {
				clickOnButton(driver, popupDeleteSecretCancel, cancelButtonContent, true);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateAndHandleDeleteSecretKeyPopupWindow :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateAndHandleDiscardSecretPopupWindow(boolean flag,String buttonName) {

		try {
			waitForExecution(500);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validatePopupWindowContent(driver, flag, popupDiscardSecretTitle, popupDiscardSecretContent, "Discard Changes", popupDiscardSecretContentMsg);

			verifyVisibilityOfButtons(driver, popupDiscardSecretCancel, cancelButtonContent, true);
			verifyVisibilityOfButtons(driver, popupDiscardSecretDiscard, discardContent, true);

			if(buttonName.equalsIgnoreCase(discardContent)) {
				clickOnButton(driver, popupDiscardSecretDiscard, buttonName, true);
			}else {
				clickOnButton(driver, popupDiscardSecretCancel, cancelButtonContent, true);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateAndHandleDiscardSecretPopupWindow :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateToastMessage(Boolean flag,String label, String toastValidation) {
		boolean tag =true;
		try {
			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, toastValidation, label);
				tag=false;

			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !toastValidation.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, toastValidation,label);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateToastMessage "+e.toString());
		}
		return flag;
	}

	public boolean searchAndEditSecretKeyValue(Boolean flag, String searchKey, String updatekey, String updateValue, String toastValidation) {

		int searchflag=1;
		try {
			BaseSuite.reportLog("----------- Updating secret key : "+searchKey);

			if (searchflag==1) {
				flag=searchFunctionalityMethod(driver, true, secretDetailsSecretSearchField, secretDetailsSecretSearchButton, placeholderSearch, placeholderSearch, searchKey);

			}
			if(elementNotVisible(driver, secretDetailsSecretNoRecordsToDisplay)) {

				flag=clickOnButton(driver, returnElement(secretDetailsSecretEditButtonDynamic, dynamicName, searchKey), "Edit", true);

				waitForExecution(500);

				if(Boolean.TRUE.equals(flag) && isDisplayed(driver, secretDetailsSecretkeyField)) {

					enterValueToTextField(driver, secretDetailsSecretkeyField, keyContent+fieldContent, updatekey);

					if(!updateValue.isEmpty()) {

						enterValueToTextField(driver, secretDetailsSecretValueField, valueContent+fieldContent, updateValue);
					}

					verifyVisibilityOfButtons(driver, secretDetailsSecretKeyCancelIcon, cancelButtonContent, true);

					clickOnButton(driver, secretDetailsSecretKeySaveIcon, "Right arrow", true);

					validateToastMessage(flag, repeatedKeyContent, toastValidation);

					searchSecretKeyFunctionality(true, updatekey, true);

					searchFunctionalityMethod(driver, true, secretDetailsSecretSearchField, secretDetailsSecretSearchButton, placeholderSearch, placeholderSearch, "");


				}else {
					BaseSuite.reportFailLog("Secret "+keyContent+fieldContent+notVisibleContent, "searchAndEditSecretKeyValue");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchAndEditSecretKeyValue "+e.toString());
		}
		return flag;

	}

	public boolean searchAndDeleteSecretKeyValue(Boolean flag, String searchKey) {

		int searchflag=1;
		try {
			BaseSuite.reportLog("----------- Deleting secret key : "+searchKey);

			if (searchflag==1) {
				flag=searchFunctionalityMethod(driver, true, secretDetailsSecretSearchField, secretDetailsSecretSearchButton, placeholderSearch, placeholderSearch, searchKey);

			}
			if(elementNotVisible(driver, secretDetailsSecretNoRecordsToDisplay)) {

				flag=clickOnButton(driver, returnElement(secretDetailsSecretDeleteButtonDynamic, dynamicName, searchKey), deleteContent, true);

				waitForExecution(500);

				if(Boolean.TRUE.equals(flag) && isDisplayed(driver, popupDeleteKeyTitle)) {

					validateAndHandleRemoveSecretKeyPopupWindow(true, deleteContent);

					searchSecretKeyFunctionality(true, searchKey, false);

					searchFunctionalityMethod(driver, true, secretDetailsSecretSearchField, secretDetailsSecretSearchButton, placeholderSearch, placeholderSearch, "");

				}else {
					BaseSuite.reportFailLog("Secret key field is not visible ", "searchAndDeleteSecretKeyValue");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchAndDeleteSecretKeyValue "+e.toString());
		}
		return flag;

	}

	public boolean editSecretkeyAndValue(String secretKeys) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if (!secretKeys.isEmpty()) {

				if (secretKeys.contains(",")) {

					iceuserName = secretKeys.split(",");

					for (int i = 0; i < iceuserName.length; i++) {

						DataTestingParameters param = setSecretKeyValueParamUsingExcel(SECRETSEXCELPATH, iceuserName[i]);

						searchAndEditSecretKeyValue(true, param.getSecretKey(), param.getEditSecretKey(), param.getEditSecretValue(), "");
					}

				} else {

					DataTestingParameters param = setSecretKeyValueParamUsingExcel(SECRETSEXCELPATH, secretKeys);

					searchAndEditSecretKeyValue(true, param.getSecretKey(), param.getEditSecretKey(), param.getEditSecretValue(), "");

				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}



		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" editSecretkeyAndValue "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean deleteSecretkeyAndValue(String secretKeys) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if (!secretKeys.isEmpty()) {

				if (secretKeys.contains(",")) {

					iceuserName = secretKeys.split(",");

					for (int i = 0; i < iceuserName.length; i++) {

						DataTestingParameters param = setSecretKeyValueParamUsingExcel(SECRETSEXCELPATH, iceuserName[i]);

						searchAndDeleteSecretKeyValue(true, param.getDeleteSecretKey());
					}

				} else {

					DataTestingParameters param = setSecretKeyValueParamUsingExcel(SECRETSEXCELPATH, secretKeys);

					searchAndDeleteSecretKeyValue(true, param.getDeleteSecretKey());

				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}



		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" editSecretkeyAndValue "+e.toString());
			flag =false;
		}

		return flag;
	}


	public boolean searchSecretFunctionality(boolean flag,String secretName, boolean expectedCondition) {


		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog(hyphenContent+" Verfying search name : "+secretName+hyphenContent);

			flag=searchFunctionalityMethod(driver, flag, secretsListingPageSearchField, secretsListingPageSearchButton, placeholderSearchSecret, placeholderSearchSecret, secretName);


			if(expectedCondition) {
				if(isDisplayed(driver, returnElement(secretsListingPageDynamicName, dynamicName, secretName))) {

					BaseSuite.validationReportLog("Secret name is displayed on listing page : "+ secretName);

				}else {
					BaseSuite.reportFailLog("Secret name is not displayed on listing page : "+ secretName,"searchSecretFunctionality");
					flag=false;
				}
			}else {
				if(elementNotVisible(driver, returnElement(secretsListingPageDynamicName, dynamicName, secretName))) {

					BaseSuite.validationReportLog("Secret name is not displayed on listing page : "+ secretName);

				}else {
					BaseSuite.reportFailLog("Secret name is displayed on listing page : "+ secretName,"searchSecretFunctionality");
					flag=false;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchSecretFunctionality :: "+e.toString());
		}
		return flag;
	}

	public boolean searchSecretKeyFunctionality(boolean flag,String secretKey, boolean expectedCondition) {


		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog(hyphenContent+" Verfying search key : "+secretKey+hyphenContent);

			flag=searchFunctionalityMethod(driver, true, secretDetailsSecretSearchField, secretDetailsSecretSearchButton, placeholderSearch, placeholderSearch, secretKey);

			if(expectedCondition) {
				if(isDisplayed(driver, returnElement(secretDetailsSecretKeyFieldDynamic, dynamicName, secretKey))) {

					BaseSuite.validationReportLog("Secret key is displayed on listing page : "+ secretKey);

				}else {
					BaseSuite.reportFailLog("Secret key is not displayed on listing page : "+ secretKey,"searchSecretKeyFunctionality");
					flag=false;
				}
			}else {
				if(elementNotVisible(driver, returnElement(secretDetailsSecretKeyFieldDynamic, dynamicName, secretKey))) {

					BaseSuite.validationReportLog("Secret key is not displayed on listing page : "+ secretKey);

				}else {
					BaseSuite.reportFailLog("Secret key is displayed on listing page : "+ secretKey,"searchSecretKeyFunctionality");
					flag=false;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchSecretKeyFunctionality :: "+e.toString());
		}
		return flag;
	}

	public boolean createSecret(DataTestingParameters param, String secretType, String secretName, String description,String secretKeys, String icedqUser) {
		boolean flag=true;

		try {
			flag=clickOnNewSecretButton(icedqUser, param.getVaultType(), true);

			if(flag && !icedqUser.contains(readerContent)) {

				validatAndeEnterValueToTextField(driver, secretDetailsSecretNameLabel, secretDetailsSecretNameField,secretDetailsSecretNameValidation, secretNameContent, placeholderEnterSecretName, secretName, fieldValidationForEmptySecretName);

				selectSecretType(secretType);

				validatAndeEnterValueToTextField(driver, secretDetailsSecretDescLabel, secretDetailsSecretDescField,secretDetailsSecretDescValidation, descriptionContent, placeholderEnterDescription, description, "");

				addSecretkeyAndValue(secretKeys);

				if(icedqUser.contains(ownerContent)) {

					clickOnSaveButtonAndValidateToast(flag, toastMessageSave);

				}else if(secretType.trim().equalsIgnoreCase(publicContent)){

					flag=clickOnSaveButtonAndValidateToast(flag, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
					return flag;

				}else {
					clickOnSaveButtonAndValidateToast(flag, toastMessageSave);
				}

				clickOnSecretsTab();

				BaseSuite.reportLog(hyphenContent+" Verifying secret details after created "+hyphenContent);

				flag=searchFunctionalityMethod(driver, flag, secretsListingPageSearchField, secretsListingPageSearchButton, placeholderSearchSecret, placeholderSearchSecret, secretName);

				if (flag) {

					validateSecretDetailsOnListingPage(secretName, description,secretType, param.getVaultType());

					searchFunctionalityMethod(driver, flag, secretsListingPageSearchField, secretsListingPageSearchButton, placeholderSearchSecret, placeholderSearchSecret, "");

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" createSecret "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean viewSecret(DataTestingParameters param, String secretType, String secretName, String description,String secretKeys, String icedqUser) {
		boolean flag=true;
		log.info(icedqUser);
		try {

			validateAfterSecretCreated(param.getVaultType(), secretName, description, secretType);

			viewSecretkeyAndValue(secretKeys);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewSecret "+e.toString());
			flag =false;
		}

		return flag;
	}


	public boolean updateSecret(DataTestingParameters param, String secretType, String secretName, String description,String secretKeys, String icedqUser) {
		boolean flag=true;
		boolean uicheck=!BaseSuite.suiteType.equalsIgnoreCase(sanity) ;
		try {
			if(uicheck) {
				validateAfterSecretCreated(param.getVaultType(), secretName, description, secretType);
			}
			selectcheckbox(driver,secretDetailsSecretKeysMasterCheckbox, masterContent+" "+checkboxContent+" "+keyContent);

			clickOnButton(driver, secretDetailsSecretKeyDeleteButton, "Remove "+keyContent, true);

			validateAndHandleRemoveAllSecretKeyPopupWindow(flag, deleteContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(500);

			validateElement(driver, secretDetailsSecretNoRecordsToDisplay, noRecordToDisplyContent, labelContent);

			verifyVisibilityOfButtons(driver, secretDetailsButtonDiscard, discardContent, true);

			verifyVisibilityOfButtons(driver, secretDetailsButtonSave, saveContent, false);

			addSecretkeyAndValue(secretKeys);

			if(icedqUser.contains(ownerContent)) {

				clickOnSaveButtonAndValidateToast(flag, "");

			}else if(secretType.trim().equalsIgnoreCase(publicContent)){

				flag=clickOnSaveButtonAndValidateToast(flag, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
				return flag;

			}else {
				clickOnSaveButtonAndValidateToast(flag, "");
			}

			clickOnSecretsTab();

			BaseSuite.reportLog(hyphenContent+" Verifying secret details after updated "+hyphenContent);

			flag=searchFunctionalityMethod(driver, flag, secretsListingPageSearchField, secretsListingPageSearchButton, placeholderSearchSecret, placeholderSearchSecret, secretName);

			if (flag) {

				validateSecretDetailsOnListingPage(secretName, description,secretType, param.getVaultType());

				searchFunctionalityMethod(driver, flag, secretsListingPageSearchField, secretsListingPageSearchButton, placeholderSearchSecret, placeholderSearchSecret, "");

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" updateSecret "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean editSecretKey(DataTestingParameters param, String secretType, String secretName, String description,String editKeys, String icedqUser) {
		boolean flag=true;

		boolean uicheck=!BaseSuite.suiteType.equalsIgnoreCase(sanity) ;
		try {
			if(uicheck) {
				validateAfterSecretCreated(param.getVaultType(), secretName, description, secretType);
			}
			editSecretkeyAndValue(editKeys);

			if(icedqUser.contains(ownerContent)) {

				clickOnSaveButtonAndValidateToast(flag, "");

			}else if(secretType.trim().equalsIgnoreCase(publicContent)){

				flag=clickOnSaveButtonAndValidateToast(flag, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
				return flag;

			}else {
				clickOnSaveButtonAndValidateToast(flag, "");
			}

			clickOnSecretsTab();

			BaseSuite.reportLog(hyphenContent+" Verifying secret details after secret keys updated "+hyphenContent);

			flag=searchFunctionalityMethod(driver, flag, secretsListingPageSearchField, secretsListingPageSearchButton, placeholderSearchSecret, placeholderSearchSecret, secretName);

			if (flag) {

				validateSecretDetailsOnListingPage(secretName, description,secretType, param.getVaultType());

				searchFunctionalityMethod(driver, flag, secretsListingPageSearchField, secretsListingPageSearchButton, placeholderSearchSecret, placeholderSearchSecret, "");

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" editSecretKey "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean deleteSecretKey(DataTestingParameters param, String secretType, String secretName, String description,String deleteKeys, String icedqUser) {
		boolean flag=true;

		boolean uicheck=!BaseSuite.suiteType.equalsIgnoreCase(sanity) ;
		try {
			if(uicheck) {
				validateAfterSecretCreated(param.getVaultType(), secretName, description, secretType);
			}
			deleteSecretkeyAndValue(deleteKeys);

			if(icedqUser.contains(ownerContent)) {

				clickOnSaveButtonAndValidateToast(flag, "");

			}else if(secretType.trim().equalsIgnoreCase(publicContent)){

				flag=clickOnSaveButtonAndValidateToast(flag, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
				return flag;

			}else {
				clickOnSaveButtonAndValidateToast(flag, "");
			}

			clickOnSecretsTab();

			BaseSuite.reportLog(hyphenContent+" Verifying secret details after secret key deleted "+hyphenContent);

			flag=searchFunctionalityMethod(driver, flag, secretsListingPageSearchField, secretsListingPageSearchButton, placeholderSearchSecret, placeholderSearchSecret, secretName);

			if (flag) {

				validateSecretDetailsOnListingPage(secretName, description,secretType, param.getVaultType());

				searchFunctionalityMethod(driver, flag, secretsListingPageSearchField, secretsListingPageSearchButton, placeholderSearchSecret, placeholderSearchSecret, "");

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" deleteSecretKey "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean deleteSecret(String secretType, String secretName, String icedqUser) {
		boolean flag=true;

		try {

			switch(secretType.toLowerCase()) {

			case "public":

				if(icedqUser.contains(ownerContent)) {

					flag=clickOnDeleteButtonAndValidateToast(flag, toastMessageDeleteSecret);

					clickOnSecretsTab();

					searchSecretFunctionality(flag, secretName, false);

				}else {

					flag=clickOnDeleteButtonAndValidateToast(flag, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);

					clickOnSecretsTab();

					searchSecretFunctionality(flag, secretName, true);
				}

				break;

			case "private":

				if(!icedqUser.contains(readerContent)) {

					flag=clickOnDeleteButtonAndValidateToast(flag, toastMessageDeleteSecret);

					clickOnSecretsTab();

					searchSecretFunctionality(flag, secretName, false);
				}


				break;

			default:
				BaseSuite.reportLog("secret type not defined kindly check.");
				break;
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" deleteSecret "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean discardSecretWhileCreating(DataTestingParameters param, String secretType, String secretName, String description,String secretKeys, String icedqUser) {
		boolean flag=true;
		GroupsServicePage gp = new GroupsServicePage(driver);

		try {
			flag=clickOnNewSecretButton(icedqUser, param.getVaultType(), false);

			if(flag && !icedqUser.contains(readerContent)) {

				gp.validatAndeEnterValueToTextField(driver, secretDetailsSecretNameLabel, secretDetailsSecretNameField,secretDetailsSecretNameValidation, secretNameContent, placeholderEnterSecretName, secretName, fieldValidationForEmptySecretName);

				selectSecretType(secretType);

				gp.validatAndeEnterValueToTextField(driver, secretDetailsSecretDescLabel, secretDetailsSecretDescField,secretDetailsSecretDescValidation, descriptionContent, placeholderEnterDescription, description, "");

				addSecretkeyAndValue(secretKeys);

				clickOnDiscardButtonAndValidateToast(true, "");

				BaseSuite.reportLog(hyphenContent+" Verifying secret details after discarded "+hyphenContent);

				validateCreateNewSecretPage(param.getVaultType());
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" discardSecretWhileCreating "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean discardSecretWhileUpdating(DataTestingParameters param, String secretType, String secretName, String description,String secretKeys, String icedqUser) {
		boolean flag=true;
		boolean uicheck=!BaseSuite.suiteType.equalsIgnoreCase(sanity) ;
		log.info(icedqUser);
		try {
			if(uicheck) {
				validateAfterSecretCreated(param.getVaultType(), secretName, description, secretType);
			}
			selectcheckbox(driver, secretDetailsSecretKeysMasterCheckbox, masterContent+" "+checkboxContent+" "+keyContent);

			clickOnButton(driver, secretDetailsSecretKeyDeleteButton, "Remove "+keyContent, true);

			validateAndHandleRemoveAllSecretKeyPopupWindow(flag, deleteContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(500);

			validateElement(driver, secretDetailsSecretNoRecordsToDisplay, noRecordToDisplyContent, labelContent);

			verifyVisibilityOfButtons(driver, secretDetailsButtonDiscard, discardContent, true);

			addSecretkeyAndValue(secretKeys);

			clickOnDiscardButtonAndValidateToast(true, "");

			BaseSuite.reportLog(hyphenContent+" Verifying secret details after discarded "+hyphenContent);

			validateAfterSecretCreated(param.getVaultType(), secretName, description, secretType);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" discardSecretWhileUpdating "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean searchFunctionalityOfSecretListingPage(String scenarioType,String secretType, String secretName,String secretDesc) {
		boolean flag =true;

		try {

			if (scenarioType.contains(secretNameColumn)) {

				flag = searchFunctionalityMethod(driver, flag, secretsListingPageSearchField, secretsListingPageSearchButton, placeholderSearchSecret, placeholderSearchSecret, secretName);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if (flag && elementNotVisible(driver, secretsListingPageNoRecordsToDisplay)) {

					validateElementVisibility(returnTwoElements(secretsListingPageDynamicNameAvatar, dynamicName, secretName, dynamicType,secretType),secretType, avatarContent, true);

					validateElementVisibility(returnElement(secretsListingPageDynamicName, dynamicName, secretName), secretName, hyperlinkContent, true);

				} else {
					BaseSuite.reportFailLog(noRecordsToDisplayContent+isVisibleContent, "searchFunctionalityOfSecretListingPage");

				} 
			}else if(scenarioType.contains(secretDescColumn)) {

				flag = searchFunctionalityMethod(driver, flag, secretsListingPageSearchField, secretsListingPageSearchButton, placeholderSearchSecret, placeholderSearchSecret, secretDesc);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if (flag && elementNotVisible(driver, secretsListingPageNoRecordsToDisplay)) {

					List<WebElement> descs= getElements(driver, secretsListingPageDescriptionList);

					BaseSuite.reportLog("# of records found :: "+descs.size());

					for(int i=0; i<descs.size();i++) {

						BaseSuite.reportLog("Verifying secret description : "+(i+1));

						String acdesc=descs.get(i).getAttribute(attributeTextContent);

						stringContainsOutput(acdesc, secretDesc, flag);
					}
				} else {
					BaseSuite.reportFailLog(noRecordsToDisplayContent+isVisibleContent, "searchFunctionalityOfSecretListingPage");

				} 
			}

			searchFunctionalityMethod(driver, flag, secretsListingPageSearchField, secretsListingPageSearchButton, placeholderSearchSecret, placeholderSearchSecret, "");

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchFunctionalityOfSecretListingPage "+e.toString());
			flag=false;
		}

		return flag;

	}

	//Invalid method

	public boolean createSecretWithInvalidConfiguration(DataTestingParameters param, String secretType,String secretName, String secretDesc, String icedqUser) {
		boolean flag =true;
		GroupsServicePage gp = new GroupsServicePage(driver);

		try {

			flag=clickOnNewSecretButton(icedqUser, param.getVaultType(), false);

			if(flag && (icedqUser.toLowerCase().contains(ownerContent))){


				switch(param.getScenarioType().toLowerCase()+1) {

				case "secretname1":

					enterValueToFieldForInvalidDetails(driver, secretDetailsSecretNameField, secretDetailsSecretNameValidation, secretNameContent, secretName, param.getFieldValidationMessage());


					verifyVisibilityOfButtons(driver, secretDetailsButtonSave, saveContent, false);

					break;

				case "secretdescription1" :

					flag=validatAndEnterValueToTextFieldForValidation(driver, secretDetailsSecretDescLabel, secretDetailsSecretDescField,secretDetailsSecretDescValidation, descriptionContent, placeholderEnterDescription, secretDesc, param.getFieldValidationMessage());
					/**	enterValueToFieldForInvalidDetails(driver, secretDetailsSecretDescField, secretDetailsSecretNameValidation, secretNameContent, secretName, param.getFieldValidationMessage());
					 */
					verifyVisibilityOfButtons(driver, secretDetailsButtonSave, saveContent, false);

					break;

				case "invalidkey1" :

					gp.validatAndeEnterValueToTextField(driver, secretDetailsSecretNameLabel, secretDetailsSecretNameField,secretDetailsSecretNameValidation, secretNameContent, placeholderEnterSecretName, secretName, fieldValidationForEmptySecretName);

					selectSecretType(secretType);

					gp.validatAndeEnterValueToTextField(driver, secretDetailsSecretDescLabel, secretDetailsSecretDescField,secretDetailsSecretDescValidation, descriptionContent, placeholderEnterDescription, secretDesc, "");

					addSecretkeyForInvalid(param.getSecretKeys());

					verifyVisibilityOfButtons(driver, secretDetailsButtonSave, saveContent, false);

					break;

				case "invalidvalue1" :

					gp.validatAndeEnterValueToTextField(driver, secretDetailsSecretNameLabel, secretDetailsSecretNameField,secretDetailsSecretNameValidation, secretNameContent, placeholderEnterSecretName, secretName, fieldValidationForEmptySecretName);

					selectSecretType(secretType);

					gp.validatAndeEnterValueToTextField(driver, secretDetailsSecretDescLabel, secretDetailsSecretDescField,secretDetailsSecretDescValidation, descriptionContent, placeholderEnterDescription, secretDesc, "");

					addSecretValueForInvalid(param.getSecretKeys());

					verifyVisibilityOfButtons(driver, secretDetailsButtonSave, saveContent, false);

					break;

				case "existing1" :

					gp.validatAndeEnterValueToTextField(driver, secretDetailsSecretNameLabel, secretDetailsSecretNameField,secretDetailsSecretNameValidation, secretNameContent, placeholderEnterSecretName, secretName, fieldValidationForEmptySecretName);

					selectSecretType(secretType);

					gp.validatAndeEnterValueToTextField(driver, secretDetailsSecretDescLabel, secretDetailsSecretDescField,secretDetailsSecretDescValidation, descriptionContent, placeholderEnterDescription, secretDesc, "");

					addSecretkeyAndValue(param.getSecretKeys());

					flag=clickOnSaveButtonAndValidateToast(flag, "Secret name '"+secretName+"' already exists.");

					break;

				case "addexistingkey1" :

					gp.validatAndeEnterValueToTextField(driver, secretDetailsSecretNameLabel, secretDetailsSecretNameField,secretDetailsSecretNameValidation, secretNameContent, placeholderEnterSecretName, secretName, fieldValidationForEmptySecretName);

					selectSecretType(secretType);

					gp.validatAndeEnterValueToTextField(driver, secretDetailsSecretDescLabel, secretDetailsSecretDescField,secretDetailsSecretDescValidation, descriptionContent, placeholderEnterDescription, secretDesc, "");

					enterKeyAndValueOfSecret(0, "key1", "value1", "");

					flag=enterKeyAndValueOfSecret(1, "key1", "value1", param.getToastValidationMessage());

					break;

				default :

					BaseSuite.reportLog("Test Scenario type not mentioned :: "+param.getScenarioType());

					break;
				}

				clickOnDiscardButtonAndValidateToast(true, "");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" createSecretWithInvalidConfiguration :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean createSecretNOUI(DataTestingParameters param, String secretType, String secretName, String description,String secretKeys, String icedqUser) {
		boolean flag=true;

		try {
			flag=clickOnNewSecretButton(icedqUser, param.getVaultType(), true);

			if(flag && !icedqUser.contains(readerContent)) {

				validatAndeEnterValueToTextField(driver, secretDetailsSecretNameLabel, secretDetailsSecretNameField,secretDetailsSecretNameValidation, secretNameContent, placeholderEnterSecretName, secretName, fieldValidationForEmptySecretName);

				selectSecretType(secretType);

				validatAndeEnterValueToTextField(driver, secretDetailsSecretDescLabel, secretDetailsSecretDescField,secretDetailsSecretDescValidation, descriptionContent, placeholderEnterDescription, description, "");

				addSecretkeyAndValue(secretKeys);

				if(icedqUser.contains(ownerContent)) {

					clickOnSaveButtonAndValidateToast(flag, toastMessageSave);

				}else if(secretType.trim().equalsIgnoreCase(publicContent)){

					flag=clickOnSaveButtonAndValidateToast(flag, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
					return flag;

				}else {
					clickOnSaveButtonAndValidateToast(flag, toastMessageSave);
				}

				clickOnSecretsTab();

				BaseSuite.reportLog(hyphenContent+" Verifying secret details after created "+hyphenContent);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" createSecretNOUI "+e.toString());
			flag =false;
		}

		return flag;
	}


	/** --------------------- Connection Service code ---------------------**/


	By connFlatFileContainerLabel = getElementLocator(prop.getProperty("conn.flatfile.native.Container.label"));
	By connFlatFileContainerField = getElementLocator(prop.getProperty("conn.flatfile.native.Container.field"));
	By connFlatFileFolderPathLabel = getElementLocator(prop.getProperty("conn.flatfile.native.FolderPath.label"));
	By connFlatFileFolderPathField = getElementLocator(prop.getProperty("conn.flatfile.native.FolderPath.field"));
	By connFlatFileFolderPathFieldValidation = getElementLocator(prop.getProperty("conn.flatfile.native.FolderPath.validation"));
	By connFlatFileRegionLabel = getElementLocator(prop.getProperty("conn.flatfile.native.Region.label"));
	By connFlatFileRegionField = getElementLocator(prop.getProperty("conn.flatfile.native.Region.field"));
	By connFlatFileRegionFieldValidation = getElementLocator(prop.getProperty("conn.flatfile.native.Region.validation"));
	By chooseConnType = getElementLocator(prop.getProperty("conn.database.connectionTypeDD"));
	By connSessionTokenLabel = getElementLocator(prop.getProperty("conn.flatfile.native.SessionToken.label"));
	By connSessionTokenField = getElementLocator(prop.getProperty("conn.flatfile.native.SessionToken.field"));
	By connFlatFileAccountNameLabel = getElementLocator(prop.getProperty("conn.flatfile.native.AccountName.label"));
	By connFlatFileAccountNameField = getElementLocator(prop.getProperty("conn.flatfile.native.AccountName.field"));
	By connFlatFileAccountKeyLabel = getElementLocator(prop.getProperty("conn.flatfile.native.AccountKey.label"));
	By connFlatFileAccountKeyField = getElementLocator(prop.getProperty("conn.flatfile.native.AccountKey.field"));
	By connFlatFileAccesskeyLabel = getElementLocator(prop.getProperty("conn.flatfile.native.Accesskey.label"));
	By connFlatFileAccesskeyField = getElementLocator(prop.getProperty("conn.flatfile.native.Accesskey.field"));
	By connFlatFileAccesskeyFieldValidation = getElementLocator(prop.getProperty("conn.flatfile.native.Accesskey.validation"));
	By connFlatFileSecretkeyLabel = getElementLocator(prop.getProperty("conn.flatfile.native.Secretkey.label"));
	By connFlatFileSecretkeyField = getElementLocator(prop.getProperty("conn.flatfile.native.Secretkey.field"));
	By connFlatFileSecretkeyFieldValidation = getElementLocator(prop.getProperty("conn.flatfile.native.Secretkey.validation"));
	By connSecurityTokenLabel = getElementLocator(prop.getProperty("conn.flatfile.native.SecurityToken.label"));
	By connSecurityTokenField = getElementLocator(prop.getProperty("conn.flatfile.native.SecurityToken.field"));
	By connsecretName = getElementLocator(prop.getProperty("Connection.secretName"));
	By flatfilesecretddb = getElementLocator(prop.getProperty("Connection.flatfile.secretkeyddb"));
	By flatfileaccessddb = getElementLocator(prop.getProperty("Connection.flatfile.accesskeyddb"));
	By flatfileSecurityTokenddb = getElementLocator(prop.getProperty("Connection.flatfile.securityTokenddb"));
	By connFlatFileDriverLabel = getElementLocator(prop.getProperty("conn.flatfile.native.Driver.label"));
	By connFlatFileDriverField = getElementLocator(prop.getProperty("conn.flatfile.native.Driver.field"));
	By connFlatFileDriverDDBtn = getElementLocator(prop.getProperty("conn.flatfile.native.Driver.dropdownbtn"));
	By connFlatFileDriverDDList = getElementLocator(prop.getProperty("conn.flatfile.native.Driver.dropdownlist"));
	By connNewConnectionButton = getElementLocator(prop.getProperty("conn.newconnection.button"));
	By connListingPageTitle = getElementLocator(prop.getProperty("conn.listingpage.title"));
	By connUserListingPageTitle = getElementLocator(prop.getProperty("conn.user.listingpage.title"));
	By connTestBtn = getElementLocator(prop.getProperty("connTestBtn"));
	By connSaveBtn = getElementLocator(prop.getProperty("connSaveBtn"));
	By connTypefield= getElementLocator(prop.getProperty("conn.type.field"));
	By warningPopupWindowYesButton = getElementLocator(prop.getProperty("conn.warning.popup.yes"));
	By connName = getElementLocator(prop.getProperty("ConnectionB.connectionName"));
	By connNameLabel = getElementLocator(prop.getProperty("Connection.Conn.Name.Label"));
	By connAuthTypeField = getElementLocator(prop.getProperty("Connection.Conn.Auth.Field"));
	By usersearchconnection = getElementLocator(prop.getProperty("connection.usersearchconnection"));
	By usersearchconnectionbtn = getElementLocator(prop.getProperty("connection.usersearchconnectionbtn"));
	By connFileDuplicateButton = getElementLocator(prop.getProperty("conn.FileDuplicateButton"));
	By moreButton = getElementLocator(prop.getProperty("conn.MoreBtn"));
	By connDeleteBtn=getElementLocator(prop.getProperty("conn.details.deletebutton"));
	By connSecretNameInput=getElementLocator(prop.getProperty("conn.secretname.input"));
	By connectionNameValidation = getElementLocator(prop.getProperty("Connection.Conn.Repo.Name.Validation"));

	By connListingPageNoRecordsToDisplay =getElementLocator(prop.getProperty("conn.listing.norecordstodisplay"));
	By connListingPageNextPageArrow = getElementLocator(prop.getProperty("conn.listing.nextarrow"));

	By popupDeleteConnTitle=getElementLocator(prop.getProperty("conn.details.popup.title.deleteConn"));
	By popupDeleteConnContent=getElementLocator(prop.getProperty("conn.details.popup.content.deleteConn"));
	By popupDeleteConnCancel=getElementLocator(prop.getProperty("conn.details.popup.cancelbutton.deleteConn"));
	By popupDeleteConnDelete=getElementLocator(prop.getProperty("conn.details.popup.deletebutton.deleteConn"));

	By popupTypeConnTitle=getElementLocator(prop.getProperty("conn.details.popup.title.type"));
	By popupTypeConnContent=getElementLocator(prop.getProperty("conn.details.popup.content.type"));
	By popupTypeConnCancel=getElementLocator(prop.getProperty("conn.details.popup.cancelbutton.type"));
	By popupTypeConnYes=getElementLocator(prop.getProperty("conn.details.popup.yesbutton.type"));

	By connPropertiesTab = getElementLocator(prop.getProperty("conn.propetiesSection.tab"));
	By connOverviewTab = getElementLocator(prop.getProperty("conn.OverviewSection.tab"));

	By popupDeletePropTitle=getElementLocator(prop.getProperty("connection.details.popup.title.deleteKey"));
	By popupDeletePropContent=getElementLocator(prop.getProperty("connection.details.popup.content.deleteKey"));
	By popupDeletePropCancel=getElementLocator(prop.getProperty("connection.details.popup.cancelbutton.deleteKey"));
	By popupDeletePropDelete=getElementLocator(prop.getProperty("connection.details.popup.deletebutton.deleteKey"));

	By connFlatFileLocationLabel = getElementLocator(prop.getProperty("conn.flatfile.native.location.label"));
	By connFlatFileLocationField = getElementLocator(prop.getProperty("conn.flatfile.native.location.field"));
	By connFlatFileLocationDDBtn = getElementLocator(prop.getProperty("conn.flatfile.native.location.dropdownbtn"));
	By connFlatFileLocationDDList = getElementLocator(prop.getProperty("conn.flatfile.native.location.dropdownlist"));

	String containerPlaceHolder = prop.getProperty("Connection.Conn.Container.placeholder");
	String folderPathEmptyValidationMsg = prop.getProperty("Connection.folderPath.empty");
	String containerEmptyValidationMsg = prop.getProperty("Connection.Container.empty");
	String folderPathPlaceHolder = prop.getProperty("Connection.Conn.FolderPath.placeholder");
	String regionPlaceHolder = prop.getProperty("Connection.Conn.Region.placeholder");
	String regionEmptyValidationMsg = prop.getProperty("Connection.Region.empty");
	String connConnectionPropNames = prop.getProperty("Connection.ConnectionProperties.Names");
	String connConnectionPropValues = prop.getProperty("Connection.ConnectionProperties.Values");
	String connConnectionPropTypes = prop.getProperty("Connection.ConnectionProperties.Types");
	String connSessionTokenPlaceholder = prop.getProperty("Conn.Placeholder.SessionToken");
	String connSecurityTokenEmpty = prop.getProperty("Conn.Empty.SecurityToken");
	String connSessionTokenEmpty = prop.getProperty("Conn.Empty.SessionToken");
	String accountNamePlaceHolder = prop.getProperty("Connection.Conn.AccountName.placeholder");
	String accountNameEmptyValidationMsg = prop.getProperty("Connection.AccountName.empty");
	String accountKeyPlaceHolder = prop.getProperty("Connection.Conn.AccountKey.placeholder");
	String accountKeyEmptyValidationMsg = prop.getProperty("Connection.AccountKey.empty");
	String accesskeyPlaceHolder = prop.getProperty("Connection.Conn.Accesskey.placeholder");
	String secretkeyPlaceHolder = prop.getProperty("Connection.Conn.Secretkey.placeholder");
	String connSecurityTokenPlaceholder = prop.getProperty("Conn.Placeholder.SecurityToken");
	String connselectPassword = prop.getProperty("Connection.secretPassword.selectPassword.feild");
	String connectionDriverDynamic=prop.getProperty("conn.driver.dynamic");
	String connectionTypeDynamic=prop.getProperty("conn.type.dynamic");
	String connCommonFieldValidation = prop.getProperty("conn.field.validation");
	String conSecretNameDynamic = prop.getProperty("conn.secretname.dynamic");

	String connListingPageDynamicName = prop.getProperty("secrets.listing.dynamic.name");
	String connFlatFileSelectLocation = prop.getProperty("conn.flatfile.native.location.selectLocation1");

	String connectionSaveMesssage = prop.getProperty("ConnectionSaveMesssage");
	String connectionTestMess = prop.getProperty("connectionTestMess");
	String connDuplicateToastMsg = prop.getProperty("Connection.Conn.Duplicate.ToastMsg");
	String connSingleDeleteToastMsg = prop.getProperty("Connection.Conn.SingleDelete.ToastMsg");
	String scrollToElementArg = prop.getProperty("ScrollToElementArgument");
	String flatFileContent="flat-file";
	String connectionNameContent="Connection Name";
	String connectionDeleteContent="Connection delete";
	String driverContent="Driver";
	String jsonJdbcContent="JSON JDBC";
	String searchConnectionContent="Search connection";

	public String getPrivateSecretNameUsingIcedqUser(String icedqUser) {

		String privateSecretKey="";

		switch(icedqUser.toLowerCase().trim()) {

		case "account_owner":
			privateSecretKey="1";
			break;
		case "account_contributor":

			privateSecretKey="2";
			break;
		case "account_executor":
			privateSecretKey="3";
			break;
		case "account_reader":
			privateSecretKey="4";
			break;
		case "workspace_owner":
			privateSecretKey="5";
			break;
		case "workspace_contributor":
			privateSecretKey="6";
			break;
		case "workspace_executor":
			privateSecretKey="7";
			break;
		case "workspace_reader":
			privateSecretKey="8";
			break;

		default:

			break;
		}


		return privateSecretKey;
	}

	public static ConnectionPoJO setSecretDetailsParamUsingExcel( String columnName, String icedqUser) {

		ConnectionPoJO param = new ConnectionPoJO();
		XLUtils xl = new XLUtils();
		String sheetName="secrets";
		String refColumn="key";
		String filePath=dirPath+Constant.NEXTGEN_TESTDATA_JSON_CONNECTION;

		try {

			param.setPublicSecret(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, "publicSecretName",columnName));
			param.setPrivateSecret(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, icedqUser.trim(), columnName));
			param.setAwsAccessKey(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, "awsAccessKey",columnName));
			param.setAwsSecretKey(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, "awsSecretKey",columnName));
			param.setAzureAccessKey(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, "azureAccessKey",columnName));
			param.setAzureAccountName(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, "azureAccountName",columnName));
			param.setSecurityToken(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, "securityToken",columnName));

		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setSecretDetailsParamUsingExcel "+e.toString());
		}
		return param;

	}

	public static String readFolderPath(String instanceName) {

		String path="";

		if(instanceName.contains("qa.onprem.icedq.com")) {
			path="folderPathOnPrem";

		}else if(instanceName.contains("52.20.42.154:32222")) {
			path="folderPath";
		}
		else if(instanceName.contains("192.168.100.35:32222")) {
			path="folderPathOnPrem";
		}


		return path;


	}

	public static ConnectionPoJO setConnectionParamUsingExcel(String filePath, String sheetName, String testCaseID) {

		ConnectionPoJO param = new ConnectionPoJO();
		XLUtils xl = new XLUtils();

		String refColumn="testCaseId";

		try {

			param.setConnName(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, testCaseID,"name"));
			param.setConnectionType(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, testCaseID,"type"));
			param.setDriverName(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, testCaseID,"driver"));
			param.setLocationname(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, testCaseID,"location"));
			param.setAuthentication(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, testCaseID,"authType"));
			param.setFolderPath(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, testCaseID,readFolderPath(BaseSuite.baseURL)));
			param.setRegion(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, testCaseID,"region"));
			param.setContainer(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, testCaseID,"container"));
			param.setAuthenticationname(setAuthenticationType(param.getAuthentication()));
			param.setConnectorID(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, testCaseID,"connectorId"));
			param.setConnectionJson(xl.readUsingColNameAndCellContains(filePath, sheetName, refColumn, testCaseID,"jsonEntity"));


		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setConnectionParamUsingExcel "+e.toString());
		}
		return param;

	}

	public static ConnectionPoJO setConnectionParam(String filePath, String sheetName, int rowNumber) {

		ConnectionPoJO param = new ConnectionPoJO();
		XLUtils xl = new XLUtils();

		try {

			param.setTestScenarioName(xl.readUsingColName(filePath,sheetName, rowNumber, "testScenario"));
			param.setScenario(xl.readUsingColName(filePath,sheetName, rowNumber, "scenario"));
			param.setScenarioType(xl.readUsingColName(filePath,sheetName, rowNumber, "scenarioType"));
			param.setConnName(xl.readUsingColName(filePath,sheetName, rowNumber,"name"));
			param.setConnectionType(xl.readUsingColName(filePath,sheetName, rowNumber,"type"));
			param.setDriverName(xl.readUsingColName(filePath,sheetName, rowNumber,"driver"));
			param.setLocationname(xl.readUsingColName(filePath,sheetName, rowNumber,"location"));
			param.setAuthentication(xl.readUsingColName(filePath,sheetName, rowNumber,"authType"));
			param.setFolderPath(xl.readUsingColName(filePath,sheetName, rowNumber,readFolderPath(BaseSuite.baseURL)));
			param.setRegion(xl.readUsingColName(filePath,sheetName, rowNumber,"region"));
			param.setContainer(xl.readUsingColName(filePath,sheetName, rowNumber,"container"));
			param.setAuthenticationname(setAuthenticationType(param.getAuthentication()));
			param.setConnectorID(xl.readUsingColName(filePath,sheetName, rowNumber,"connectorId"));
			param.setConnectionJson(xl.readUsingColName(filePath,sheetName, rowNumber,"jsonEntity"));
			param.setValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber,"fieldValidation"));
			param.setOnSaveValidation(xl.readUsingColName(filePath,sheetName, rowNumber,"onSaveValidation"));
			param.setOnTestValidation(xl.readUsingColName(filePath,sheetName, rowNumber,"onTestValidation"));
			param.setSecretsColumn(xl.readUsingColName(filePath,sheetName, rowNumber,"secretsColumn"));
			param.setType(xl.readUsingColName(filePath,sheetName, rowNumber,"refprop"));
			param.setConnProperty(xl.readUsingColName(filePath,sheetName, rowNumber,"connProp"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setConnectionParamUsingExcel "+e.toString());
		}
		return param;

	}

	/** Authentication method **/

	public static String setAuthenticationType(String jsonauthType) {

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

			case "aws-iam":
				authName = ConstantProperty.AUTH_AWS_IAM;
				break;

			case "azure-access-key":
				authName = ConstantProperty.AUTH_AZURE_ACCESSKEY;
				break;

			case "azure-shared-signature":
				authName = ConstantProperty.AUTH_AZURE_SHAREDSIGNATURE;
				break;

			case "aws-custom-credentials":
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

	public boolean enterS3FieldValues(ConnectionPoJO connParam,boolean flag) {

		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);

		try {

			if ((connParam.getConnectorID().toLowerCase().equalsIgnoreCase(flatFileContent))) {

				cp.selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());
			}

			cp.selectAuthenticationOfConnection(connParam.getAuthenticationname());

			validatAndeEnterValueToTextField(connFlatFileContainerLabel, connFlatFileContainerField,
					ConstantProperty.CONN_FIELD_CONTAINER, containerPlaceHolder, connParam.getContainer(),
					containerEmptyValidationMsg);

			validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder,
					connParam.getFolderPath(), folderPathEmptyValidationMsg);

			validatAndeEnterValueToTextField(connFlatFileRegionLabel, connFlatFileRegionField,ConstantProperty.CONN_FIELD_REGION, regionPlaceHolder, connParam.getRegion(),
					regionEmptyValidationMsg);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" enterS3FieldValues :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean enterAzureFieldValues(ConnectionPoJO connParam,boolean flag) {


		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);

		try {
			if ((connParam.getConnectorID().toLowerCase().equalsIgnoreCase(flatFileContent))) {

				cp.selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());
			}

			cp.selectAuthenticationOfConnection(connParam.getAuthenticationname());

			validatAndeEnterValueToTextField(connFlatFileContainerLabel, connFlatFileContainerField,ConstantProperty.CONN_FIELD_CONTAINER, containerPlaceHolder, connParam.getContainer(),
					containerEmptyValidationMsg);

			validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder,
					connParam.getFolderPath(), folderPathEmptyValidationMsg);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" enterAzureFieldValues :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean enterAzureFieldValues(ConnectionPoJO connParam,boolean flag, String authname) {


		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);

		try {
			if ((connParam.getConnectorID().toLowerCase().equalsIgnoreCase(flatFileContent))) {

				cp.selectFileTypeOfFlatFileNativeConnection(connParam.getFileType());
			}

			cp.selectAuthenticationOfConnection(authname);

			validatAndeEnterValueToTextField(connFlatFileContainerLabel, connFlatFileContainerField,ConstantProperty.CONN_FIELD_CONTAINER, containerPlaceHolder, connParam.getContainer(),
					containerEmptyValidationMsg);

			validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder,
					connParam.getFolderPath(), folderPathEmptyValidationMsg);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" enterAzureFieldValues :: "+e.toString());
			flag=false;
		}
		return flag;
	}


	// Method to validate & Secret Name
	public void selectConnectionType(String value) throws NullPointerException {

		String methodName = "selectConnectionType";
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {
			javascript(driver, scrollToElementArg, connTypefield);

			if (isDisplayed(driver, connTypefield)) {
				BaseSuite.reportLog("Connection type field is displayed.");

				if (isEnabled(driver, connTypefield)) {
					if (isEditable(driver, connTypefield, " Connection type")) {

						BaseSuite.reportLog("clicking on connection type field.");

						displayAndClick(driver, connTypefield);

						BaseSuite.validationReportLog("clicked on connection type field.");

						isDisplayedInLoop(driver, 0, returnElement(connectionTypeDynamic, dynamicName, value));

						if(isDisplayed(driver, returnElement(connectionTypeDynamic, dynamicName, value))) {

							BaseSuite.reportLog("clicking on connection type "+value);

							displayAndClick(driver, returnElement(connectionTypeDynamic, dynamicName, value));

							BaseSuite.validationReportLog("clicked on connection type "+value);

							cp.handleWarningPopupWindow(warningPopupWindowYesButton, "Yes");

						}else {
							BaseSuite.reportFailLog(value+" connection type not visible, kindly check.", methodName);
						}

						isDisplayedInLoop(driver, 1, connTypefield);

						String secretname = getAttribute(driver, connTypefield, attributeValue).trim();

						stringContainsOutput(secretname.trim(), value.trim(), true);

					}

				} else {
					BaseSuite.reportFailLog("Connection type input is disabled, kindly check.", methodName);
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate Connection type field on current page, kindly check.",
						methodName);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" selectConnectionType " + e.toString());

		}
	}

	public void selectConnectionType1(String connType) {

		try {
			String authValue = null;
			isDisplayedInLoop(driver, 2, connTypefield);

			javascript(driver, scrollToElementArg, connTypefield);

			verifyIndividualLabel(driver, connTypefield, "type");

			if (isDisplayed(driver, connTypefield)) {

				BaseSuite.validationReportLog("Connection type field is visible ");

				authValue = getAttribute(driver, connTypefield, attributeValue);

				BaseSuite.reportLog("Default Connection type selected as : " + authValue);

				isDisplayedInLoop(driver, 2, connTypefield);

				if (isDisplayed(driver, connTypefield)) {

					displayAndClick(driver, connTypefield);

					BaseSuite.validationReportLog(
							"Clicked on Connection type drop down  " + ConstantProperty.SUCCESSSTRING + "");

				}

				isDisplayedInLoop(driver, 4, returnElement(connectionTypeDynamic, dynamicName, connType));

				if (isDisplayed(driver, returnElement(connectionTypeDynamic, dynamicName, connType))) {

					displayAndClick(driver, returnElement(connectionTypeDynamic, dynamicName, connType));

					validateAndHandleConnectionTypePopupWindow(true, "yes");

					isDisplayedInLoop(driver, 0, connTypefield);

					authValue = getAttribute(driver, connTypefield, attributeValue);

					if (!authValue.isEmpty()) {
						BaseSuite.validationReportLog("Connection type selected as : " + authValue);

					}

				} else {
					BaseSuite.reportFailLog("Expected Connection type not found kindly check",
							"selectAuthenticationOfConnection");
				}

			} else {
				BaseSuite.reportFailLog("Connection type field not visible ", " selectAuthenticationOfConnection");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" selectConnectionType1 :: "+e.toString());

		}
	}

	public boolean verifyPlaceholderOfField(By locator, String label, String expectedValue) {
		boolean flag = false;

		BaseSuite.reportLog("Verify placeholder is present in the "+label+" input box.");

		isDisplayedInLoop(driver, 1, locator);

		if (isDisplayed(driver, locator)) {

			String holder = getAttribute(driver, locator, attributePlaceholder);

			BaseSuite.reportLog("Expected value : "+expectedValue);
			BaseSuite.reportLog("Expected value : "+holder);

			if (holder.equalsIgnoreCase(expectedValue)) {
				BaseSuite.validationReportLog("Correct placeholder is displayed in "+label+" input box.");
				flag = true;
			} else {
				flag = false;
				BaseSuite.reportFailLog(
						"Expected placeholder didnt matched with actual placeholder, kindly check.",
						"verifyPlaceholderOfField-"+label);
			}
		} else {
			BaseSuite.reportErrorLog("Unable to locate locator :: " + locator);
		}

		return flag;
	}


	// Method to validate & Secret Name
	public void enterSecretName(String value){

		String methodName = "enterSecretName";
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			javascript(driver, scrollToElementArg, connsecretName);

			if (isDisplayed(driver, connsecretName)) {
				BaseSuite.reportLog("Secret Name field is displayed.");

				if (isEnabled(driver, connsecretName)) {
					if (isEditable(driver, connsecretName, " Secret Name")) {

						verifyPlaceholderOfField(connsecretName, "Secret Name", "Select secret name");

						click(driver, connsecretName);

						sendKeys(driver, connSecretNameInput, value.trim());

						isDisplayedInLoop(driver, 1, returnElement(conSecretNameDynamic, dynamicName, value));

						if(isDisplayed(driver, returnElement(conSecretNameDynamic, dynamicName, value))) {

							displayAndClick(driver, returnElement(conSecretNameDynamic, dynamicName, value));
						}

						isDisplayedInLoop(driver, 1, connsecretName);

						String secretname = getAttribute(driver, connsecretName, attributeValue).trim();

						cp.compareActualNExpectedValue(secretname.trim(), value.trim());

					}

				} else {
					BaseSuite.reportFailLog("Secret Name input is disabled, kindly check.", methodName);
				}

			} else {
				BaseSuite.reportFailLog("Unable to locate Secret Name field on current page, kindly check.",
						methodName);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" enterSecretName :: "+e.toString());

		}
	}


	public void selectAccessKey(String locationType) {

		try {
			String authValue = null;

			inVisible(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, connFlatFileAccesskeyLabel);

			javascript(driver, scrollToElementArg, connFlatFileAccesskeyLabel);

			verifyIndividualLabel(driver, connFlatFileAccesskeyLabel, ConstantProperty.CONN_FIELD_ACCESSKEY);

			if (isEditable(driver, connFlatFileAccesskeyField, "Select access key")) {

				BaseSuite.validationReportLog("Access key field is visible ");

				authValue = getAttribute(driver, connFlatFileAccesskeyField, attributeValue);

				BaseSuite.reportLog("Default access key value selected as : " + authValue);

				isDisplayedInLoop(driver, 2, flatfileaccessddb);

				if (isDisplayed(driver, flatfileaccessddb)) {

					displayAndClick(driver, flatfileaccessddb);

					BaseSuite.validationReportLog(
							"Clicked on Access key drop down  " + ConstantProperty.SUCCESSSTRING + "");

					BaseSuite.reportLog("Checking list of Access key Value visible");
					inVisible(driver, dataTSpinner, Constant.ruleWait);

				}
				javascript(driver, scrollToElementArg,
						returnElement(connselectPassword, dynamicName, locationType));

				isDisplayedInLoop(driver, 4,
						returnElement(connselectPassword, dynamicName, locationType));

				if (isDisplayed(driver, returnElement(connselectPassword, dynamicName, locationType))) {

					displayAndClick(driver, returnElement(connselectPassword, dynamicName, locationType));

					inVisible(driver, dataTSpinner, Constant.ruleWait);

					authValue = getAttribute(driver, connFlatFileAccesskeyField, attributeValue);

					if (!authValue.isEmpty()) {
						BaseSuite.validationReportLog("Access key selected as : " + authValue);

					}

				} else {
					BaseSuite.reportFailLog("Expected Access key not found kindly check",
							"selectAccessKey");
				}

			} else {
				BaseSuite.reportFailLog("Select access key field not visible ", "selectAccessKey");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" selectAccessKey :: "+e.toString());

		}
	}

	public void selectSecretKey(String locationType) {

		try {
			String authValue = null;

			inVisible(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, connFlatFileSecretkeyLabel);

			javascript(driver, scrollToElementArg, connFlatFileSecretkeyLabel);

			verifyIndividualLabel(driver, connFlatFileSecretkeyLabel, ConstantProperty.CONN_FIELD_SECRETKEY);

			if (isEditable(driver, connFlatFileSecretkeyField, "Select secret key")) {

				BaseSuite.validationReportLog("Secret key field is visible ");

				authValue = getAttribute(driver, connFlatFileSecretkeyField, attributeValue);

				BaseSuite.reportLog("Default Secret key value selected as : " + authValue);

				isDisplayedInLoop(driver, 2, flatfilesecretddb);

				if (isDisplayed(driver, flatfilesecretddb)) {

					displayAndClick(driver, flatfilesecretddb);

					BaseSuite.validationReportLog(
							"Clicked on Secret key drop down  " + ConstantProperty.SUCCESSSTRING + "");

					BaseSuite.reportLog("Checking list of Secret key Value visible");
					inVisible(driver, dataTSpinner, Constant.ruleWait);

				}
				javascript(driver, scrollToElementArg,
						returnElement(connselectPassword, dynamicName, locationType));

				isDisplayedInLoop(driver, 4,
						returnElement(connselectPassword, dynamicName, locationType));

				if (isDisplayed(driver, returnElement(connselectPassword, dynamicName, locationType))) {

					inVisible(driver, dataTSpinner, Constant.ruleWait);

					displayAndClick(driver, returnElement(connselectPassword, dynamicName, locationType));

					authValue = getAttribute(driver, connFlatFileSecretkeyField, attributeValue);

					if (!authValue.isEmpty()) {
						BaseSuite.validationReportLog("Secret key selected as : " + authValue);

					}

				} else {
					BaseSuite.reportFailLog("Expected Secret key not found kindly check",
							"selectSecretKey");
				}

			} else {
				BaseSuite.reportFailLog("Select Secret key field not visible ", "selectSecretKey");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" selectSecretKey :: "+e.toString());

		}
	}

	public void selectSecuritytoken(String locationType) {

		try {
			String authValue = null;

			inVisible(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, connSecurityTokenLabel);

			javascript(driver, scrollToElementArg, connSecurityTokenLabel);

			verifyIndividualLabel(driver, connSecurityTokenLabel, ConstantProperty.CONN_FIELD_SECURITYTOKEN);

			if (isEditable(driver, connSecurityTokenField, "Select security token")) {

				BaseSuite.validationReportLog("Security token field is visible ");

				authValue = getAttribute(driver, connSecurityTokenField, attributeValue);

				BaseSuite.reportLog("Default Security token value selected as : " + authValue);

				isDisplayedInLoop(driver, 2, flatfileSecurityTokenddb);

				if (isDisplayed(driver, flatfileSecurityTokenddb)) {

					displayAndClick(driver, flatfileSecurityTokenddb);

					BaseSuite.validationReportLog(
							"Clicked on Access key drop down  " + ConstantProperty.SUCCESSSTRING + "");

					BaseSuite.reportLog("Checking list of Security token Value visible");
					inVisible(driver, dataTSpinner, Constant.ruleWait);

				}
				javascript(driver, scrollToElementArg,
						returnElement(connselectPassword, dynamicName, locationType));

				isDisplayedInLoop(driver, 4,
						returnElement(connselectPassword, dynamicName, locationType));

				if (isDisplayed(driver, returnElement(connselectPassword, dynamicName, locationType))) {

					displayAndClick(driver, returnElement(connselectPassword, dynamicName, locationType));

					authValue = getAttribute(driver, connSecurityTokenField, attributeValue);

					if (!authValue.isEmpty()) {
						BaseSuite.validationReportLog("Security token selected as : " + authValue);

					}

				} else {
					BaseSuite.reportFailLog("Expected Security token not found kindly check",
							"selectSecuritytoken");
				}

			} else {
				BaseSuite.reportFailLog("Select Security token field not visible ", "selectSecuritytoken");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" selectSecuritytoken :: "+e.toString());

		}
	}


	public void enterSecret(ConnectionPoJO connParam, String authType) {

		try {

			if(authType.equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

				selectAccessKey(connParam.getAwsAccessKey());
				selectSecretKey(connParam.getAwsSecretKey());

			}else if(authType.equalsIgnoreCase(ConstantProperty.AUTH_AZURE_ACCESSKEY)){

				validatAndeEnterValueToTextField( connFlatFileAccountNameLabel, connFlatFileAccountNameField,
						ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, connParam.getAzureAccountName(),
						accountNameEmptyValidationMsg);

				selectAccessKey(connParam.getAzureAccessKey());


			}else if(authType.equalsIgnoreCase(ConstantProperty.AUTH_AZURE_SHAREDSIGNATURE)){

				selectSecuritytoken(connParam.getSecurityToken());
				validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
						ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, connParam.getAzureAccountName(),
						accountNameEmptyValidationMsg);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" enterSecret :: "+e.toString());

		} 

	}

	public void validateSecretField(String authType) {
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);

		try {
			if(authType.equalsIgnoreCase(ConstantProperty.AUTH_AWS_IAM)) {

				cp.validateFieldOfConnection(connFlatFileAccesskeyLabel, connFlatFileAccesskeyField,
						ConstantProperty.CONN_FIELD_ACCESSKEY, accesskeyPlaceHolder, false);

				cp.validateFieldOfConnection(connFlatFileSecretkeyLabel, connFlatFileSecretkeyField,
						ConstantProperty.CONN_FIELD_SECRETKEY, secretkeyPlaceHolder, false);


			} else if(authType.equalsIgnoreCase(ConstantProperty.AUTH_AZURE_ACCESSKEY)){

				cp.validateFieldOfConnection(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
						ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, false);


				cp.validateFieldOfConnection(connFlatFileAccountKeyLabel, connFlatFileAccountKeyField,
						ConstantProperty.CONN_FIELD_ACCOUNTKEY, accountKeyPlaceHolder, false);

			} else if(authType.equalsIgnoreCase(ConstantProperty.AUTH_AZURE_SHAREDSIGNATURE)){

				cp.validateFieldOfConnection(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
						ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, false);

				cp.validateFieldOfConnection(connSecurityTokenLabel, connSecurityTokenField,
						ConstantProperty.CONN_FIELD_SECURITYTOKEN, connSecurityTokenPlaceholder, false);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateSecretField :: "+e.toString());

		}
	}


	public boolean clickOnSaveConnButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, connSaveBtn, saveContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Connection Save");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Connection Save");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnSaveConnButtonAndValidateToast "+e.toString());
			flag =false;
		}
		return flag;
	}

	public boolean clickOnTestConnButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, connTestBtn, "Test", true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Connection Test for valid");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Connection Test for valid");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnTestConnButtonAndValidateToast "+e.toString());
			flag =false;
		}
		return flag;
	}

	public boolean clickOnDeleteConnButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, connDeleteBtn, deleteContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Connection Delete");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Connection Delete");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnTestConnButtonAndValidateToast "+e.toString());
			flag =false;
		}
		return flag;
	}

	public boolean clickOnDuplicateConnButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, connFileDuplicateButton, "Duplicate", true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Connection duplicate");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Connection duplicate");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnDuplicateConnButtonAndValidateToast "+e.toString());
			flag =false;
		}
		return flag;
	}

	public boolean saveAndValidateConnection(String icedqUser, String message) {

		boolean flag = true;
		try {
			waitForExecution(500);
			if (icedqUser.contains(ownerContent)) {

				if(message.isEmpty()) {
					flag = clickOnSaveConnButtonAndValidateToast(flag,"");
				}else {
					flag = clickOnSaveConnButtonAndValidateToast(flag,connectionSaveMesssage);
				}
			} else {

				flag = clickOnSaveConnButtonAndValidateToast(flag,ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" saveAndValidateConnection :: "+e.toString());

		}
		return flag;
	}

	public boolean saveAndValidateUserConnection(String icedqUser, String message) {

		boolean flag = true;
		try {
			waitForExecution(500);
			if (icedqUser.contains(ownerContent)) {

				if(message.isEmpty()) {
					flag = clickOnSaveConnButtonAndValidateToast(flag,"");
				}else {
					flag = clickOnSaveConnButtonAndValidateToast(flag,connectionSaveMesssage);
				}
			} else {

				flag = clickOnSaveConnButtonAndValidateToast(flag,"");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" saveAndValidateConnection :: "+e.toString());

		}
		return flag;
	}

	public boolean testAndValidateConnection(String icedqUser) {
		boolean flag = true;
		try {

			if (!icedqUser.contains(readerContent)) {

				flag = clickOnTestConnButtonAndValidateToast(flag, connectionTestMess);

			} else {

				flag = clickOnTestConnButtonAndValidateToast(flag,ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" testAndValidateConnection :: "+e.toString());

		}
		return flag;
	}

	public boolean duplicateAndValidateConnection(String icedqUser) {
		boolean flag = true;
		try {

			if (icedqUser.contains(ownerContent)) {

				flag = clickOnDuplicateConnButtonAndValidateToast(flag, connDuplicateToastMsg);

			} else {

				flag = clickOnDuplicateConnButtonAndValidateToast(flag,ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" duplicateAndValidateConnection :: "+e.toString());

		}
		return flag;
	}

	public boolean deleteAndValidateConnection(String expectedToastMessage) {
		boolean tag =true;
		boolean flag=true;
		int retryCount = 0;
		boolean success = false;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(500);

			clickOnButton(driver, connDeleteBtn, deleteContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, connectionDeleteContent);
				tag=false;

			}
			isDisplayedInLoop(driver, 0, popupDeleteConnTitle);

			if(isDisplayed(driver, popupDeleteConnTitle)) {

				validateAndHandleDeleteConnectionPopupWindow(flag, deleteContent);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				do {
					if(isDisplayed(driver, toastMsg)) {

						flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, connectionDeleteContent);
						tag=false;
						success = true;
					}else {
						retryCount++;
						waitForExecution(2000);
					}
				}while(retryCount < 3 && !success);
			}
			if(tag && !expectedToastMessage.isEmpty()) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,connectionDeleteContent);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" deleteAndValidateConnection "+e.toString());
			flag =false;
		}
		return flag;
	}

	public boolean searchConnectionFunctionality(boolean flag,String connectionName, boolean expectedCondition) {


		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog(hyphenContent+" Verfying search name : "+connectionName+hyphenContent);

			flag=searchFunctionalityMethod(driver, flag, usersearchconnection, usersearchconnectionbtn, searchConnectionContent, searchConnectionContent, connectionName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(expectedCondition) {
				if(isDisplayed(driver, returnElement(connListingPageDynamicName, dynamicName, connectionName))) {

					BaseSuite.validationReportLog("Connection name is displayed on listing page : "+ connectionName);

				}else {
					BaseSuite.reportFailLog("Connection name is not displayed on listing page : "+ connectionName,"searchConnectionFunctionality");
					flag=false;
				}
			}else {
				if(elementNotVisible(driver, returnElement(connListingPageDynamicName, dynamicName, connectionName))) {

					BaseSuite.validationReportLog("Connection name is not displayed on listing page : "+ connectionName);

				}else {
					BaseSuite.reportFailLog("Connection name is displayed on listing page : "+ connectionName,"searchConnectionFunctionality");
					flag=false;
				}
			}

			searchFunctionalityMethod(driver, flag, usersearchconnection, usersearchconnectionbtn, searchConnectionContent, searchConnectionContent, "");

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchConnectionFunctionality :: "+e.toString());
		}
		return flag;
	}

	public boolean validateAndHandleDeleteConnectionPopupWindow(boolean flag,String buttonName) {

		try {
			waitForExecution(500);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			if(isDisplayed(driver, popupDeleteConnTitle)) {
				validatePopupWindowContent(driver, flag, popupDeleteConnTitle, popupDeleteConnContent, "Delete Connection", "Do you want to delete the connection?");

				verifyVisibilityOfButtons(driver, popupDeleteConnCancel, cancelButtonContent, true);
				verifyVisibilityOfButtons(driver, popupDeleteConnDelete, deleteContent, true);

				if(buttonName.equalsIgnoreCase(deleteContent)) {
					clickOnButton(driver, popupDeleteConnDelete, buttonName, true);
				}else {
					clickOnButton(driver, popupDeleteConnCancel, cancelButtonContent, true);
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateAndHandleDeleteConnectionPopupWindow :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateAndHandleConnectionTypePopupWindow(boolean flag,String buttonName) {

		try {
			waitForExecution(500);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, popupTypeConnTitle)) {

				validatePopupWindowContent(driver, flag, popupTypeConnTitle, popupTypeConnContent, "Warning", "Changing the connection type will delete all the stored user connection instances. Do you want to continue?");

				verifyVisibilityOfButtons(driver, popupTypeConnCancel, cancelButtonContent, true);
				verifyVisibilityOfButtons(driver, popupTypeConnYes, "Yes", true);

				if(buttonName.equalsIgnoreCase("yes")) {
					clickOnButton(driver, popupTypeConnYes, buttonName, true);
				}else {
					clickOnButton(driver, popupTypeConnCancel, cancelButtonContent, true);
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateAndHandleConnectionTypePopupWindow :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean enterSecretDetails(String connType, String connectorId,String connectionName,  String authType, String icedqUser) {

		boolean flag = true;


		try {

			if(!authType.equalsIgnoreCase(ConstantProperty.AUTH_LOCAL)) {

				ConnectionPoJO connParam = setSecretDetailsParamUsingExcel(connectorId,icedqUser);

				switch(connType.toLowerCase().trim()+1) {

				case "system1":

					enterSecretName(connParam.getPublicSecret());

					enterSecret(connParam, authType);

					saveAndValidateConnection(icedqUser, connectionSaveMesssage);

					break;

				case "user1":

					validateSecretField(authType);

					saveAndValidateConnection(icedqUser, connectionSaveMesssage);

					clickOnUserConnectionTab();

					searchConnectionAndClickOnName(connectionName);

					waitForExecution(3000);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					enterSecretName(connParam.getPrivateSecret());

					enterSecret(connParam, authType);

					saveAndValidateConnection(icedqUser, "");

					break;

				default:

					break;

				}
			}else {
				flag=saveAndValidateConnection(icedqUser, connectionSaveMesssage);
			}

			if (flag) {
				flag=testAndValidateConnection(icedqUser);
			}
		}  catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" enterSecretDetails :: "+e.toString());
			flag = false;
		}
		return flag;

	}

	public boolean enterSecretDetailsForUpdate(String connType, String connectorId,String connectionName,  String authType, String icedqUser) {

		boolean flag = true;


		try {

			if(!authType.equalsIgnoreCase(ConstantProperty.AUTH_LOCAL)) {

				ConnectionPoJO connParam = setSecretDetailsParamUsingExcel(connectorId,icedqUser);

				switch(connType.toLowerCase().trim()+1) {

				case "system1":

					enterSecretName(connParam.getPublicSecret());

					enterSecret(connParam, authType);

					saveAndValidateConnection(icedqUser, "");

					if(icedqUser.contains(ownerContent)) {
						testAndValidateConnection(icedqUser);
					}
					break;

				case "user1":

					validateSecretField(authType);

					saveAndValidateConnection(icedqUser, "");

					clickOnUserConnectionTab();

					searchConnectionAndClickOnName(connectionName);

					waitForExecution(3000);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					enterSecretName(connParam.getPrivateSecret());

					enterSecret(connParam, authType);

					if(!icedqUser.contains(readerContent)) {

						saveAndValidateConnection(icedqUser, "");

						testAndValidateConnection(icedqUser);
					}else {
						verifyVisibilityOfButtons(driver, connSaveBtn, saveContent, false);
						verifyVisibilityOfButtons(driver, connTestBtn, "Test", false);
					}

					break;

				default:

					break;

				}
			}else {

				flag=saveAndValidateConnection(icedqUser, "");
				if(icedqUser.contains(ownerContent)) {
					testAndValidateConnection(icedqUser);
				}else {
					verifyVisibilityOfButtons(driver, connTestBtn, "Test", false);
				}
			}

		}  catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" enterSecretDetails :: "+e.toString());
			flag = false;
		}
		return flag;

	}

	public void checkDefaultValue(By locator, String label, String input1) {
		log.info(input1);
		isDisplayedInLoop(driver, 2, locator);
		if (isDisplayed(driver, locator)) {

			BaseSuite.validationReportLog(label+" field is visible ");

			String input = getAttribute(driver, locator, attributeValue);
			if (!input.isEmpty()) {

				BaseSuite.reportLog("Default "+label+" type selected as : " + input);
			} else {
				BaseSuite.reportFailLog(
						"Default "+label+" Name is empty :: https://icedqsoft.atlassian.net/browse/DAT-5789",
						"checkDefaultValue-" + label);
			} 
		}
	}

	public void selectDriverOfConnection(String driverName) {

		String method="selectDriverOfConnection";
		try {
			String authValue = null;

			isDisplayedInLoop(driver, 2, connFlatFileDriverLabel);

			javascript(driver, scrollToElementArg, connFlatFileDriverLabel);

			verifyIndividualLabel(driver, connFlatFileDriverLabel, ConstantProperty.CONN_FIELD_LOCATION);

			if (isDisplayed(driver, connFlatFileDriverField)) {

				checkDefaultValue(connFlatFileLocationField, "Driver", authValue);

				isDisplayedInLoop(driver, 2, connFlatFileDriverDDBtn);

				if (isDisplayed(driver, connFlatFileDriverDDBtn)) {

					displayAndClick(driver, connFlatFileDriverDDBtn);

					BaseSuite.validationReportLog(
							"Clicked on Location drop down " + ConstantProperty.SUCCESSSTRING + "");

					BaseSuite.reportLog("Checking list of location type visible");
					waitForExecution(500);
					List<WebElement> authList = getElements(driver, connFlatFileDriverDDList);

					for (int i = 0; i < authList.size(); i++) {

						String authName = authList.get(i).getAttribute("data-value");

						BaseSuite.reportLog((i + 1) + ". " + authName + "  is visible");

					}
				}
				waitForExecution(500);
				isDisplayedInLoop(driver, 4, returnElement(connectionDriverDynamic, dynamicName, driverName));

				if (isDisplayed(driver, returnElement(connectionDriverDynamic, dynamicName, driverName))) {

					displayAndClick(driver, returnElement(connectionDriverDynamic, dynamicName, driverName));

					authValue = getAttribute(driver, connFlatFileDriverField, attributeValue);

					if (!authValue.isEmpty()) {
						BaseSuite.validationReportLog("Driver type selected as : " + authValue);
					}

				} else {
					BaseSuite.reportFailLog("Expected Driver type not found kindly check",
							method);
				}

			} else {
				BaseSuite.reportFailLog("Driver field not visible ", method);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" selectDriverOfConnection " + e.toString());
		}
	}

	public boolean clickOnConnectionTab() {

		boolean flag = false;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 0, connNewConnectionButton);

			if(elementNotVisible(driver, connNewConnectionButton)) {

				isDisplayedInLoop(driver, 2, connectionsTab);

				if(isDisplayed(driver, connectionsTab, 2)) {

					flag = isClickable(driver, connectionsTab, connectionsContent+" tab", true);

					if(flag) {

						BaseSuite.reportLog("Clicking on "+connectionsContent+" tab");

						displayAndClick(driver, connectionsTab);

						handleDiscardWindow();

						BaseSuite.validationReportLog("Clicked on "+connectionsContent+" tab");

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						flag=validateElement(driver, connListingPageTitle, connectionsContent, attributeTitle);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					}

				}else {
					BaseSuite.reportFailLog(secretsContent+" tab not visible", "clickOnConnectionTab");
				}
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnConnectionTab :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean clickOnUserConnectionTab() {

		boolean flag = false;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, connUserListingPageTitle);

			if(elementNotVisible(driver, connUserListingPageTitle)) {

				isDisplayedInLoop(driver, 2, userConnectionsTab);

				if(isDisplayed(driver, userConnectionsTab, 2)) {

					flag = isClickable(driver, userConnectionsTab, "User Connections tab", true);

					if(flag) {

						BaseSuite.reportLog("Clicking on User Connections tab");

						displayAndClick(driver, userConnectionsTab);

						handleDiscardWindow();

						BaseSuite.validationReportLog("Clicked on User Connections tab");

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						flag=validateElement(driver, connUserListingPageTitle, "User Connections", attributeTitle);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					}

				}else {
					BaseSuite.reportFailLog(secretsContent+" tab not visible", "clickOnUserConnectionTab");
				}
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnUserConnectionTab :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	/** create file connector **/

	public boolean createJsonFileConnection(ConnectionPoJO connParam, String newconnectionName,  String testScenario, String validationMessage,
			String icedqUser) {

		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);

		boolean flag = true;

		try {

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			flag = cp.clickOnNewConnectionBtn(icedqUser);

			if (flag && icedqUser.contains(ownerContent)) {

				cp.chooseConnectorType(connParam.getConnectorID());

				inVisible(driver, dataTSpinner, Constant.ruleWait);

				waitForExecution(2000);

				flag = cp.enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

				if (flag) {

					if (!(connParam.getConnectorID().toLowerCase().equalsIgnoreCase(flatFileContent))) {

						selectDriverOfConnection(connParam.getDriverName());
					}

					selectLocationOfFlatFileNativeConnection(connParam.getLocationname(), connParam);

					switch (connParam.getLocationname().trim().toLowerCase()+2) {

					case "local2":

						validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder,
								connParam.getFolderPath(), folderPathEmptyValidationMsg);

						break;

					case "s32":

						enterS3FieldValues(connParam, flag);

						selectConnectionType1( connParam.getConnectionType());

						break;

					case "azure blob2":

						enterAzureFieldValues(connParam, flag);

						selectConnectionType1( connParam.getConnectionType());

						break;

					default:

						break;

					}
					if ((!connParam.getConnectorID().toLowerCase().equalsIgnoreCase(flatFileContent))) {
						ArrayList<String> connPropertyList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(connParam.getConnectionJson(), connConnectionPropNames);

						int count = connPropertyList.size();

						cp.addConnectionPropertiesToXMLConnection(connParam.getConnectionJson(), count);
					}

					flag = enterSecretDetails(connParam.getConnectionType(), connParam.getConnectorID(), newconnectionName, connParam.getAuthenticationname(), icedqUser);

				}

			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(errorLogTitle+" create connection " + e.toString());
		}

		return flag;

	}

	public void selectLocationOfFlatFileNativeConnection(String locationType, ConnectionPoJO connParam) {
		log.info(connParam);
		try {
			String authValue = null;
			isDisplayedInLoop(driver, 2, connFlatFileLocationLabel);

			javascript(driver, scrollToElementArg, connFlatFileLocationLabel);

			verifyIndividualLabel(driver, connFlatFileLocationLabel, ConstantProperty.CONN_FIELD_LOCATION);

			if (isDisplayed(driver, connFlatFileLocationField)) {

				BaseSuite.validationReportLog("Location field is visible ");

				authValue = getAttribute(driver, connFlatFileLocationField, attributeValue);

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

				isDisplayedInLoop(driver, 4, returnElement(connFlatFileSelectLocation, dynamicName, locationType));

				if (isDisplayed(driver, returnElement(connFlatFileSelectLocation, dynamicName, locationType))) {

					displayAndClick(driver, returnElement(connFlatFileSelectLocation, dynamicName, locationType));

					isDisplayedInLoop(driver, 2, connFlatFileLocationField);

					authValue = getAttribute(driver, connFlatFileLocationField, attributeValue);

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

	public void compareTwoValues(String label, String expected, String valMsg, boolean state) {

		BaseSuite.reportLog("Expected :- " + expected);

		BaseSuite.reportLog("Actual :- " + valMsg);

		if (state) {

			if (valMsg.trim().contains(expected)) {

				BaseSuite.validationReportLog("Proper Validation message applied on " + label + "  field");
			} else {
				BaseSuite.reportFailLog("Validation message not matched for " + label + "  field",
						"compareTwoValues");
			}
		}else {
			if (!valMsg.trim().contains(expected)) {

				BaseSuite.validationReportLog("Proper Validation message applied on " + label + " field ");

			} else {
				BaseSuite.reportFailLog("Validation message not matched for " + label + " field  ",
						"validationMessageOfField");
			}
		}
	}

	public String validationMessageOfField(By locator, String label, String expected, boolean state) {

		String valMsg = null;

		if (!expected.isEmpty()) {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isDisplayedInLoop(driver, 0, locator);
			if (isDisplayed(driver, locator)) {

				valMsg = getText(driver, locator);

				if (!valMsg.isEmpty()) {

					compareTwoValues(label, expected, valMsg, state);

				}
			} 
		}
		return valMsg;
	}

	public void veriftIsEnabled(By locator, String label, boolean expectedState) {

		if (expectedState) {

			if (isEnabled(driver, locator)) {

				BaseSuite.validationReportLog(label + " is enabled as expected");
			} else {
				BaseSuite.reportFailLog(label + " is disabled and expected is enabled", "veriftIsEnabled");

			}
		} else {

			if (!isEnabled(driver, locator)) {
				BaseSuite.validationReportLog(label + " is disabled as expected");
			} else {
				BaseSuite.reportFailLog(label + " is enabled and expected is disabled", "veriftIsEnabled");

			}
		}
	}

	/** View Connection Field Data method **/

	public boolean viewAndValidateConnectionField(By locator, String label, String expectedValue, boolean state) {

		boolean flag = true;
		String methodName = "viewAndValidateConnectionField";
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, locator);
			javascript(driver, scrollToElementArg, locator);
			if (isDisplayed(driver, locator)) {

				BaseSuite.reportLog("Verifying "+label+ " is enabled or not ");

				veriftIsEnabled(locator, label, state);

				if (!expectedValue.isBlank()) {
					String ac = getAttribute(driver, locator, attributeValue);

					flag = stringContainsOutput(ac, expectedValue, true);
				}

			} else {
				BaseSuite.reportFailLog(label + notVisibleContent, methodName);
				flag = false;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e.toString());
			flag = false;
		}

		return flag;
	}

	public boolean validatAndeEnterValueToTextField(By labelLocator, By fieldLocator, String label, String placeHolder,
			String input, String fieldValidation){
		boolean flag = true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, labelLocator);

			javascript(driver, scrollToElementArg, labelLocator);

			verifyIndividualLabel(driver, labelLocator, label);

			if (isDisplayed(driver, fieldLocator)) {

				isClickable(driver, fieldLocator, label, true);

				if (!placeHolder.isEmpty()) {
					String ph = getAttribute(driver, fieldLocator, attributePlaceholder);

					if (!ph.isEmpty() && ph.equalsIgnoreCase(placeHolder)) {

						BaseSuite.reportLog(label + " field place holder : " + ph);

					} else {

						BaseSuite.reportFailLog(label + " field place holder not found : Actual :" + ph
								+ " and Expected : " + placeHolder, " validatAndeEnterValueToTextField");
					}
				}
				if (!input.isEmpty()) {
					click(driver, fieldLocator);

					clear(driver, fieldLocator);

					BaseSuite.reportLog(" Entering value : " + input);

					sendKeys(driver, fieldLocator, input);

					String ac = getAttribute(driver, fieldLocator, attributeValue);

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


	public void validateS3Field(ConnectionPoJO connParam, String type) {
		boolean flag=true;
		try {

			if(type.equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {
				flag=false;
			}

			viewAndValidateConnectionField(connName, connectionNameContent, connParam.getConnName(), flag);

			if (!connParam.getDriverName().isEmpty()) {

				viewAndValidateConnectionField(connFlatFileDriverField, driverContent, jsonJdbcContent, flag);
			}

			viewAndValidateConnectionField(connFlatFileLocationField, ConstantProperty.CONN_FIELD_LOCATION,
					connParam.getLocationname(), flag);

			viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
					connParam.getAuthenticationname(), flag);

			viewAndValidateConnectionField(connFlatFileContainerField, ConstantProperty.CONN_FIELD_CONTAINER,
					connParam.getContainer(), flag);

			viewAndValidateConnectionField(connFlatFileFolderPathField, ConstantProperty.CONN_FIELD_FOLDERPATH,
					connParam.getFolderPath(), flag);

			viewAndValidateConnectionField(connFlatFileRegionField, ConstantProperty.CONN_FIELD_REGION,
					connParam.getRegion(), flag);

			viewAndValidateConnectionField(connTypefield, "Connection type",
					type, flag);

			validatAndeEnterValueToTextField(connFlatFileAccesskeyLabel, connFlatFileAccesskeyField,
					ConstantProperty.CONN_FIELD_ACCESSKEY, accesskeyPlaceHolder, "",
					"");

			validatAndeEnterValueToTextField(connFlatFileSecretkeyLabel, connFlatFileSecretkeyField,
					ConstantProperty.CONN_FIELD_SECRETKEY, secretkeyPlaceHolder, "",
					"");


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateS3Field " + e.toString());
		}
	}

	public void validateAzureField(ConnectionPoJO connParam, String type) {
		boolean flag=true;
		try {

			if(type.equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {
				flag=false;
			}

			viewAndValidateConnectionField(connName, connectionNameContent, connParam.getConnName(), flag);

			if (!connParam.getDriverName().isEmpty()) {

				viewAndValidateConnectionField(connFlatFileDriverField, driverContent, jsonJdbcContent, flag);
			}

			viewAndValidateConnectionField(connFlatFileLocationField, ConstantProperty.CONN_FIELD_LOCATION,
					connParam.getLocationname(), flag);

			viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
					connParam.getAuthenticationname(), flag);

			viewAndValidateConnectionField(connFlatFileContainerField, ConstantProperty.CONN_FIELD_CONTAINER,
					connParam.getContainer(), flag);

			viewAndValidateConnectionField(connFlatFileFolderPathField, ConstantProperty.CONN_FIELD_FOLDERPATH,
					connParam.getFolderPath(), flag);

			viewAndValidateConnectionField(connTypefield, "Connection type",
					type, flag);

			if(connParam.getAuthenticationname().contains(ConstantProperty.AUTH_AZURE_ACCESSKEY)) {
				validatAndeEnterValueToTextField(connFlatFileAccesskeyLabel, connFlatFileAccesskeyField,
						ConstantProperty.CONN_FIELD_ACCESSKEY, accesskeyPlaceHolder, "",
						"");
			}else {
				validatAndeEnterValueToTextField(connSecurityTokenLabel, connSecurityTokenField,
						ConstantProperty.CONN_FIELD_SECURITYTOKEN, connSecurityTokenPlaceholder, "",
						"");
			}
			validatAndeEnterValueToTextField(connFlatFileAccountNameLabel, connFlatFileAccountNameField,
					ConstantProperty.CONN_FIELD_ACCOUNTNAME, accountNamePlaceHolder, "",
					"");

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateS3Field " + e.toString());
		}
	}

	public boolean searchConnNameOnEachPageAndClickOn(By locator,String name) {

		boolean flag=true;
		boolean nextpageFlag=true;
		int pn=0;

		try {

			do {

				BaseSuite.reportLog("searching connection name : "+name+" on page number :"+(pn+1));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 2, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportLog("connection name : "+name+" found on page number :"+(pn+1));

					flag=clickOnButton(driver, locator, name, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					break;
				}
				if(isDisplayed(driver, connListingPageNextPageArrow)) {

					String status = getAttribute(driver, connListingPageNextPageArrow, attributeClass);

					if (!status.contains("disable")) {

						BaseSuite.reportLog("searched connection name : "+name+" not found on page number :"+(pn+1));

						clickOnButton(driver, connListingPageNextPageArrow, "next page", true);
						pn++;
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					} else {
						BaseSuite.reportLog("Page arrow :: next page is disabled");
						nextpageFlag=false;
					}

				}

			}while(nextpageFlag);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchConnNameOnEachPageAndClickOn :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean searchConnectionAndClickOnName(String connName) {
		boolean flag =true;

		try {

			flag=searchFunctionalityMethod(driver, flag, usersearchconnection, usersearchconnectionbtn, searchConnectionContent, searchConnectionContent, connName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && elementNotVisible(driver, connListingPageNoRecordsToDisplay)) {

				flag=searchConnNameOnEachPageAndClickOn(returnElement(connListingPageDynamicName, dynamicName, connName), connName);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}else {
				BaseSuite.reportFailLog(noRecordsToDisplayContent+isVisibleContent,"searchConnectionAndClickOnName");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchConnectionAndClickOnName "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean viewJsonConnector(ConnectionPoJO connParam,String connectionName, String icedqUser) {
		boolean flag = true;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		log.info(icedqUser);
		try {
			inVisible(driver, dataTSpinner, Constant.ruleWait);

			switch (connParam.getLocationname().trim().toLowerCase()) {

			case "local":

				viewAndValidateConnectionField(connName, connectionNameContent, connectionName, true);

				if (!connParam.getDriverName().isEmpty()) {

					viewAndValidateConnectionField(connFlatFileDriverField, driverContent, jsonJdbcContent, true);
				}

				viewAndValidateConnectionField(connFlatFileLocationField, ConstantProperty.CONN_FIELD_LOCATION,
						connParam.getLocationname(), true);

				viewAndValidateConnectionField(connFlatFileFolderPathField, "Folder Path ",connParam.getFolderPath(), true);

				break;

			case "s3":

				validateS3Field(connParam, connParam.getConnectionType());


				break;

			case "azure blob":

				validateAzureField(connParam, connParam.getConnectionType());

				break;

			default:

				break;

			}
			if ((!connParam.getConnectorID().toLowerCase().equalsIgnoreCase(flatFileContent))) {
				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connParam.getConnectionJson(), connConnectionPropNames);

				int count = connPropertyList.size();

				flag = cp.viewAndValidateConnectionPropertiesToConnection(connParam.getConnectionJson(), count);
			}
		}  catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(errorLogTitle+" view connection " + e.toString());
		}



		return flag;
	}


	public boolean testJsonConnector(ConnectionPoJO param,String icedqUser) {

		boolean flag = true;

		try {
			if(!icedqUser.contains(readerContent)) {

				if(param.getConnectionType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					flag=testAndValidateConnection(icedqUser);

				}else {

					ConnectionPoJO connParam = setSecretDetailsParamUsingExcel("json-test",icedqUser);

					enterSecretName(connParam.getPrivateSecret());

					enterSecret(connParam, param.getAuthenticationname());

					saveAndValidateUserConnection(icedqUser, "");

					flag=testAndValidateConnection(icedqUser);

				}

			}else {
				if(param.getConnectionType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {
					flag=testAndValidateConnection(icedqUser);
				}else {
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					verifyVisibilityOfButtons(driver, connTestBtn, "Test", false);
				}

			}
		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(errorLogTitle+" test connection " + e.toString());
		}


		return flag;
	}


	public boolean duplicateJsonConnector(ConnectionPoJO param,String connectionName, String icedqUser) {

		boolean flag = true;
		String name = null;
		try {

			if(param.getConnectionType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				clickOnConnectionTab();

				searchConnectionAndClickOnName(connectionName);

				inVisible(driver, dataTSpinner, Constant.ruleWait);

			}

			clickOnButton(driver, moreButton, "More", true);

			if (icedqUser.contains(ownerContent)) {

				flag=duplicateAndValidateConnection(icedqUser);

				inVisible(driver, dataTSpinner, Constant.ruleWait);

				if (flag) {
					name = getAttribute(driver, connName, attributeValue);

					clickOnConnectionTab();

					flag = searchConnectionAndClickOnName(name);
				}
			}else {

				flag=duplicateAndValidateConnection(icedqUser);
			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(errorLogTitle+" duplicate connection " + e.toString());
		}


		return flag;
	}


	public boolean deleteJsonConnector(ConnectionPoJO param,String connectionName, String icedqUser) {

		boolean flag = true;

		try {

			if(param.getConnectionType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				clickOnConnectionTab();

				searchConnectionAndClickOnName(connectionName);

				inVisible(driver, dataTSpinner, Constant.ruleWait);

			}

			if (icedqUser.contains(ownerContent)) {

				deleteAndValidateConnection(connSingleDeleteToastMsg);

				flag=searchConnectionFunctionality(true, connectionName, false);

			}else {

				flag=deleteAndValidateConnection(ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);

				clickOnConnectionTab();

				flag=searchConnectionFunctionality(flag, connectionName, true);
			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(errorLogTitle+" delete connection " + e.toString());
		}


		return flag;
	}


	public boolean enterFieldDetailsForFileConnection(ConnectionPoJO param) {
		boolean flag = true;

		try {
			switch (param.getLocationname().trim().toLowerCase()+2) {

			case "local2":

				validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder,
						param.getFolderPath(), folderPathEmptyValidationMsg);

				break;

			case "s32":

				enterS3FieldValues(param, flag);

				selectConnectionType1(param.getConnectionType());

				break;

			case "azure blob2":

				enterAzureFieldValues(param, flag);

				selectConnectionType1(param.getConnectionType());

				break;

			default:

				break;

			}
		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(errorLogTitle+" enterFieldDetailsForFileConnection " + e.toString());
		}
		return flag;
	}

	public boolean enterFieldDetailsForFileConnectionForAuth(ConnectionPoJO param) {
		boolean flag = true;

		try {
			switch (param.getLocationname().trim().toLowerCase()+3) {

			case "s33":

				validatAndeEnterValueToTextField(connFlatFileContainerLabel, connFlatFileContainerField,
						ConstantProperty.CONN_FIELD_CONTAINER, containerPlaceHolder, param.getContainer(),
						containerEmptyValidationMsg);

				validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder,
						param.getFolderPath(), folderPathEmptyValidationMsg);

				validatAndeEnterValueToTextField(connFlatFileRegionLabel, connFlatFileRegionField,ConstantProperty.CONN_FIELD_REGION, regionPlaceHolder, param.getRegion(),
						regionEmptyValidationMsg);

				selectConnectionType1(param.getConnectionType());

				break;

			case "azure blob3":

				validatAndeEnterValueToTextField(connFlatFileContainerLabel, connFlatFileContainerField,ConstantProperty.CONN_FIELD_CONTAINER, containerPlaceHolder, param.getContainer(),
						containerEmptyValidationMsg);

				validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder,
						param.getFolderPath(), folderPathEmptyValidationMsg);

				selectConnectionType1(param.getConnectionType());

				break;

			default:

				break;

			}
		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(errorLogTitle+" enterFieldDetailsForFileConnectionForAuth " + e.toString());
		}
		return flag;
	}

	public boolean updateJsonConnector(String connectionName,ConnectionPoJO param,ConnectionPoJO upparam,String scenario,String icedqUser) {

		boolean flag = true;

		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);

		try {
			if(param.getConnectionType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				clickOnConnectionTab();

				searchConnectionAndClickOnName(connectionName);

				inVisible(driver, dataTSpinner, Constant.ruleWait);

			}
			switch(scenario.toLowerCase()+2) {

			case "location2":

				selectLocationOfFlatFileNativeConnection(upparam.getLocationname(), upparam);

				enterFieldDetailsForFileConnection(upparam);

				break;

			case "authentication2":

				cp.selectAuthenticationOfConnection(upparam.getAuthenticationname());

				enterFieldDetailsForFileConnectionForAuth(upparam);

				break;

			case "type2":

				selectConnectionType1(upparam.getConnectionType());

				break;


			case "updateprop2":

				if(connectionName.contains("With-Property")) {

					flag = updateConnectionPropertyScenarios(connectionName, param, upparam, scenario, icedqUser);

					enterSecretDetailsForUpdateProperty(param.getConnectionType(), param.getConnectorID(), connectionName, param.getAuthenticationname(), icedqUser);

				}
				break;


			default:

				flag = cp.enterConnectionNameWithValidation(connectionName, ConstantProperty.TEST_SCENARIO_VALID, "");

				if (!(upparam.getConnectorID().toLowerCase().equalsIgnoreCase(flatFileContent))) {

					selectDriverOfConnection(upparam.getDriverName());
				}

				selectLocationOfFlatFileNativeConnection(upparam.getLocationname(), upparam);

				switch (upparam.getLocationname().trim().toLowerCase()+3) {

				case "local3":

					validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder,
							upparam.getFolderPath(), folderPathEmptyValidationMsg);

					break;

				case "s33":

					BaseSuite.reportLog(hyphenContent+" Updating field for Amazon S3 location "+hyphenContent);

					enterS3FieldValues(upparam, flag);

					selectConnectionType1(upparam.getConnectionType());

					break;

				case "azure blob3":

					BaseSuite.reportLog(hyphenContent+" Updating field for Azure blob location "+hyphenContent);

					enterAzureFieldValues(upparam, flag);

					selectConnectionType1(upparam.getConnectionType());

					break;

				default:

					break;

				}

				break;
			}
			if(!scenario.toLowerCase().contains("updateprop")) {
				flag = enterSecretDetailsForUpdate(upparam.getConnectionType(), upparam.getConnectorID(), connectionName, upparam.getAuthenticationname(), icedqUser);
			}
		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(errorLogTitle+" update connection " + e.toString());
		}


		return flag;
	}


	public boolean enterSecretDetailsForUpdateProperty(String connType, String connectorId,String connectionName,  String authType, String icedqUser) {

		boolean flag = true;

		log.info(connectionName);
		try {

			if(!authType.equalsIgnoreCase(ConstantProperty.AUTH_LOCAL)) {

				ConnectionPoJO connParam = setSecretDetailsParamUsingExcel(connectorId,icedqUser);

				switch(connType.toLowerCase().trim()) {

				case "system":

					enterSecretName(connParam.getPublicSecret());

					enterSecret(connParam, authType);

					saveAndValidateConnection(icedqUser, "");

					if(icedqUser.contains(ownerContent)) {
						testAndValidateConnection(icedqUser);
					}
					break;

				case "user":
					/**
					validateSecretField(authType);

					saveAndValidateConnection(icedqUser, "");

					clickOnUserConnectionTab();

					searchConnectionAndClickOnName(connectionName);

					waitForExecution(3000);
					 **/
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					enterSecretName(connParam.getPrivateSecret());

					enterSecret(connParam, authType);

					if(!icedqUser.contains(readerContent)) {

						saveAndValidateConnection(icedqUser, "");

						testAndValidateConnection(icedqUser);
					}else {
						verifyVisibilityOfButtons(driver, connSaveBtn, saveContent, false);
						verifyVisibilityOfButtons(driver, connTestBtn, "Test", false);
					}

					break;

				default:

					break;

				}
			}else {

				flag=saveAndValidateConnection(icedqUser, "");
				if(icedqUser.contains(ownerContent)) {
					testAndValidateConnection(icedqUser);
				}else {
					verifyVisibilityOfButtons(driver, connTestBtn, "Test", false);
				}
			}

		}  catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" enterSecretDetailsForUpdateProperty :: "+e.toString());
			flag = false;
		}
		return flag;

	}

	By connectionDetailsSecretNoRecordsToDisplay=getElementLocator(prop.getProperty("connection.details.property.norecordstodisplay"));
	By connectionPropAddButton=getElementLocator(prop.getProperty("connection.details.property.addButton"));
	By connectionProDeleteButton=getElementLocator(prop.getProperty("connection.details.property.deleteButton"));

	By connectionDetailsSecretkeyField=getElementLocator(prop.getProperty("connection.details.property.keyfield"));
	By connectionDetailsSecretValueField=getElementLocator(prop.getProperty("connection.details.property.valuefield"));
	By connectionDetailsSecretKeySaveIcon=getElementLocator(prop.getProperty("connection.details.property.button.save"));
	By connectionDetailsSecretKeyEditIcon=getElementLocator(prop.getProperty("connection.details.property.button.edit"));
	By connectionDetailsSecretKeyDeleteIcon=getElementLocator(prop.getProperty("connection.details.property.button.delete"));
	By connectionDetailsSecretKeyCancelIcon=getElementLocator(prop.getProperty("connection.details.property.button.cancel"));
	By propConnType = getElementLocator(prop.getProperty("conn.prop.connectionTypeDD"));

	String connectionDetailsSecretKeyFieldDynamic=prop.getProperty("connection.details.property.keyField.dynamic");
	String connectionDetailsSecretValueFieldDynamic=prop.getProperty("connection.details.property.valueField.dynamic");
	String connectionDetailsSecretTypeFieldDynamic=prop.getProperty("connection.details.property.typeField.dynamic");
	String connectionDetailsSecretEditButtonDynamic=prop.getProperty("connection.details.property.editbutton");
	String connectionDetailsSecretDeleteButtonDynamic=prop.getProperty("connection.details.property.deletebutton");
	String connectionDetailsSecretSaveButtonDynamic=prop.getProperty("connection.details.property.savebutton");
	String connectionDetailsSecretCancelButtonDynamic=prop.getProperty("connection.details.property.cancelbutton");

	public static DataTestingParameters setConnectionPropertyKeyValueParamUsingExcel(String filePath, String keys) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String sheetName="jsonproperty";
		try {

			param.setSecretKey(xl.readUsingColNameAndCellContains(filePath, sheetName, REFCOL, keys,"name"));
			param.setSecretValue(xl.readUsingColNameAndCellContains(filePath, sheetName, REFCOL, keys,"value"));
			param.setType(xl.readUsingColNameAndCellContains(filePath, sheetName, REFCOL, keys,"type"));
			param.setEditSecretKey(xl.readUsingColNameAndCellContains(filePath, sheetName, REFCOL, keys,"editname"));
			param.setEditSecretValue(xl.readUsingColNameAndCellContains(filePath, sheetName, REFCOL, keys,"editvalue"));
			param.setDeleteSecretKey(xl.readUsingColNameAndCellContains(filePath, sheetName, REFCOL, keys,"deletename"));
			param.setEditype(xl.readUsingColNameAndCellContains(filePath, sheetName, REFCOL, keys,"edittype"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setConnectionPropertyKeyValueParamUsingExcel "+e.toString());
		}
		return param;

	}

	public boolean enterConnectionProp(int i, String key, String value,String type, String toastValidation) {
		boolean flag=true;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {

			BaseSuite.reportLog("----------- Adding "+(i)+"  Connection property "+keyContent+" : "+key+" & "+valueContent+" : "+value );

			clickOnButton(driver, connectionPropAddButton, addButtonContent, true);

			waitForExecution(500);

			enterValueToTextField(driver, connectionDetailsSecretkeyField,  keyContent+" "+fieldContent, key);

			enterValueToTextField(driver, connectionDetailsSecretValueField,  valueContent+" "+fieldContent, value);

			cp.selectConnectionType(propConnType, type.trim());

			verifyVisibilityOfButtons(driver, connectionDetailsSecretKeyCancelIcon, cancelButtonContent, true);

			clickOnButton(driver, connectionDetailsSecretKeySaveIcon, "Right tick arrow", true);

			waitForExecution(500);

			validateToastMessage(flag, repeatedKeyContent, toastValidation);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" enterKeyAndValueOfSecret "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean addConnectionProperty(String secretKeys) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if (!secretKeys.isEmpty()) {

				if (secretKeys.contains(",")) {

					iceuserName = secretKeys.split(",");

					for (int i = 0; i < iceuserName.length; i++) {

						DataTestingParameters param = setConnectionPropertyKeyValueParamUsingExcel(dirPath+ Constant.NEXTGEN_TESTDATA_JSON_CONNECTION, iceuserName[i]);

						enterConnectionProp(i+1, param.getSecretKey(), param.getSecretValue(),param.getType(),"");
					}

				} else {

					DataTestingParameters param = setConnectionPropertyKeyValueParamUsingExcel(dirPath+ Constant.NEXTGEN_TESTDATA_JSON_CONNECTION, secretKeys);

					enterConnectionProp(1, param.getSecretKey(), param.getSecretValue(),param.getType(), "");

				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}



		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" addConnectionProperty "+e.toString());
			flag =false;
		}

		return flag;
	}


	public void validateKeyAndValueOfSystemConnectionProperty(int i, String key, String value, String type) {


		/**boolean flag=true;*/

		try {

			BaseSuite.reportLog(hyphenContent+" verifying "+(i+1)+" connection property : "+key+ hyphenContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(elementNotVisible(driver, connectionDetailsSecretNoRecordsToDisplay)) {

				viewAndValidateField(driver, returnElement(connectionDetailsSecretKeyFieldDynamic, dynamicName, key), keyContent, key, true);

				viewAndValidateField(driver, returnElement(connectionDetailsSecretValueFieldDynamic, dynamicName, key), valueContent, value, true);

				viewAndValidateField(driver, returnElement(connectionDetailsSecretTypeFieldDynamic, dynamicName, key), valueContent, type, true);

				verifyVisibilityOfButtons(driver, returnElement(connectionDetailsSecretEditButtonDynamic, dynamicName, key), "Edit"+" "+keyContent, true);

				verifyVisibilityOfButtons(driver, returnElement(connectionDetailsSecretDeleteButtonDynamic, dynamicName, key), deleteContent+" "+keyContent, true);

			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateKeyAndValueOfSystemConnectionProperty :: "+e.toString());

		}
	}

	public void validateKeyAndValueOfUserConnectionProperty(int i, String key, String value, String type) {


		/**	boolean flag=true;*/

		try {

			BaseSuite.reportLog(hyphenContent+" verifying "+(i+1)+" connection property : "+key+ hyphenContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(elementNotVisible(driver, connectionDetailsSecretNoRecordsToDisplay)) {

				if(type.equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					viewAndValidateField(driver, returnElement(connectionDetailsSecretKeyFieldDynamic, dynamicName, key), keyContent, key, false);

					viewAndValidateField(driver, returnElement(connectionDetailsSecretValueFieldDynamic, dynamicName, key), valueContent, value, false);

					viewAndValidateField(driver, returnElement(connectionDetailsSecretTypeFieldDynamic, dynamicName, key), valueContent, type, false);

					verifyVisibilityOfButtons(driver, returnElement(connectionDetailsSecretEditButtonDynamic, dynamicName, key), "Edit"+" "+keyContent, false);

					verifyVisibilityOfButtons(driver, returnElement(connectionDetailsSecretDeleteButtonDynamic, dynamicName, key), deleteContent+" "+keyContent, false);

				}else {

					viewAndValidateField(driver, returnElement(connectionDetailsSecretKeyFieldDynamic, dynamicName, key), keyContent, key, true);

					viewAndValidateField(driver, returnElement(connectionDetailsSecretValueFieldDynamic, dynamicName, key), valueContent, value, true);

					viewAndValidateField(driver, returnElement(connectionDetailsSecretTypeFieldDynamic, dynamicName, key), valueContent, type, true);

					verifyVisibilityOfButtons(driver, returnElement(connectionDetailsSecretEditButtonDynamic, dynamicName, key), "Edit"+" "+keyContent, true);

					verifyVisibilityOfButtons(driver, returnElement(connectionDetailsSecretDeleteButtonDynamic, dynamicName, key), deleteContent+" "+keyContent, false);
				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateKeyAndValueOfUserConnectionProperty :: "+e.toString());

		}
	}

	public void validateConnectionField(String connectionType, int i, String key, String value, String type) {

		if(connectionType.equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

			verifyVisibilityOfButtons(driver, connectionPropAddButton, addButtonContent, true);

			verifyVisibilityOfButtons(driver, connectionProDeleteButton, deleteContent, false);

			validateKeyAndValueOfSystemConnectionProperty(i, key, value,type);

		}else {
			verifyVisibilityOfButtons(driver, connectionPropAddButton, addButtonContent, false);

			verifyVisibilityOfButtons(driver, connectionProDeleteButton, deleteContent, false);

			validateKeyAndValueOfUserConnectionProperty(i, key, value,type);
		}
	}

	public boolean viewConnectionPropertykeyAndValue(String connectionPropertyKey, String connectionType, String type) {
		String[] iceuserName=null;
		boolean flag =true;
		try {

			if (!connectionPropertyKey.isEmpty()) {

				/**		cp.clickOnPropertiesTab();*/

				if (connectionPropertyKey.contains(",")) {

					iceuserName = connectionPropertyKey.split(",");

					for (int i = 0; i < iceuserName.length; i++) {

						DataTestingParameters param = setConnectionPropertyKeyValueParamUsingExcel(dirPath+ Constant.NEXTGEN_TESTDATA_JSON_CONNECTION, iceuserName[i]);

						switch(type.toLowerCase()+1){

						case "addprop1":

							validateConnectionField(connectionType, i, param.getSecretKey(), param.getSecretValue(),param.getType());

							break;
						case "updateprop1":

							validateConnectionField(connectionType, i, param.getEditSecretKey(), param.getEditSecretValue(),param.getEditype());

							break;

						default:

							break;

						}
					}
				} else {

					DataTestingParameters param = setConnectionPropertyKeyValueParamUsingExcel(dirPath+ Constant.NEXTGEN_TESTDATA_JSON_CONNECTION, connectionPropertyKey);

					switch(type.toLowerCase()){

					case "addprop":

						validateConnectionField(connectionType, 0, param.getSecretKey(), param.getSecretValue(),param.getType());

						break;
					case "updateprop":

						validateConnectionField(connectionType, 0, param.getEditSecretKey(), param.getEditSecretValue(),param.getEditype());

						break;

					default:

						break;
					}

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" viewConnectionPropertykeyAndValue "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean updateConnectionProperty(Boolean flag, String searchKey, String updatekey, String updateValue, String updateType,String toastValidation) {

		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		int searchflag=2;
		try {
			BaseSuite.reportLog("----------- Updating connection property : "+searchKey);

			if (searchflag==1) {
				flag=searchFunctionalityMethod(driver, true, secretDetailsSecretSearchField, secretDetailsSecretSearchButton, placeholderSearch, placeholderSearch, searchKey);

			}
			if(elementNotVisible(driver, connectionDetailsSecretNoRecordsToDisplay)) {

				flag=clickOnButton(driver, returnElement(connectionDetailsSecretEditButtonDynamic, dynamicName, searchKey), "Edit", true);

				waitForExecution(500);

				if(Boolean.TRUE.equals(flag) && isDisplayed(driver, connectionDetailsSecretkeyField)) {

					enterValueToTextField(driver, connectionDetailsSecretkeyField, keyContent+fieldContent, updatekey);

					if(!updateValue.isEmpty()) {

						enterValueToTextField(driver, connectionDetailsSecretValueField, valueContent+fieldContent, updateValue);
					}

					cp.selectConnectionType(propConnType, updateType.trim());

					verifyVisibilityOfButtons(driver, connectionDetailsSecretKeyCancelIcon, cancelButtonContent, true);

					clickOnButton(driver, connectionDetailsSecretKeySaveIcon, "Right arrow", true);

					validateToastMessage(flag, repeatedKeyContent, toastValidation);


				}else {
					BaseSuite.reportFailLog("connection property "+keyContent+fieldContent+notVisibleContent, "updateConnectionProperty");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" updateConnectionProperty "+e.toString());
		}
		return flag;

	}

	public boolean deleteConnectionPropertyKeyValue(Boolean flag, String searchKey) {

		int searchflag=2;
		try {
			BaseSuite.reportLog("----------- Deleting connection property : "+searchKey);

			if (searchflag==1) {
				flag=searchFunctionalityMethod(driver, true, secretDetailsSecretSearchField, secretDetailsSecretSearchButton, placeholderSearch, placeholderSearch, searchKey);

			}
			if(elementNotVisible(driver, secretDetailsSecretNoRecordsToDisplay)) {

				flag=clickOnButton(driver, returnElement(connectionDetailsSecretDeleteButtonDynamic, dynamicName, searchKey), deleteContent, true);

				waitForExecution(500);

				if(Boolean.TRUE.equals(flag) && isDisplayed(driver, popupDeleteKeyTitle)) {

					validateAndHandlePropertyDeletePopupWindow(true, deleteContent);

				}else {
					BaseSuite.reportFailLog("connection property key field is not visible ", "deleteConnectionPropertyKeyValue");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" deleteConnectionPropertyKeyValue "+e.toString());
		}
		return flag;

	}

	public boolean editConnectionProperty(String secretKeys) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if (!secretKeys.isEmpty()) {

				if (secretKeys.contains(",")) {

					iceuserName = secretKeys.split(",");

					for (int i = 0; i < iceuserName.length; i++) {

						DataTestingParameters param = setConnectionPropertyKeyValueParamUsingExcel(dirPath+ Constant.NEXTGEN_TESTDATA_JSON_CONNECTION, iceuserName[i]);

						updateConnectionProperty(true, param.getSecretKey(), param.getEditSecretKey(), param.getEditSecretValue(),param.getEditype(), "");
					}

				} else {

					DataTestingParameters param = setConnectionPropertyKeyValueParamUsingExcel(dirPath+ Constant.NEXTGEN_TESTDATA_JSON_CONNECTION, secretKeys);

					updateConnectionProperty(true, param.getSecretKey(), param.getEditSecretKey(), param.getEditSecretValue(),param.getEditype(), "");

				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}



		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" editConnectionProperty "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean deleteConnectionProperty(String secretKeys) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if (!secretKeys.isEmpty()) {

				if (secretKeys.contains(",")) {

					iceuserName = secretKeys.split(",");

					for (int i = 0; i < iceuserName.length; i++) {

						DataTestingParameters param = setConnectionPropertyKeyValueParamUsingExcel(dirPath+ Constant.NEXTGEN_TESTDATA_JSON_CONNECTION, iceuserName[i]);

						deleteConnectionPropertyKeyValue(true, param.getDeleteSecretKey());
					}

				} else {

					DataTestingParameters param = setConnectionPropertyKeyValueParamUsingExcel(dirPath+ Constant.NEXTGEN_TESTDATA_JSON_CONNECTION, secretKeys);

					deleteConnectionPropertyKeyValue(true, param.getDeleteSecretKey());

				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}



		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" deleteConnectionProperty "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean validateAndHandlePropertyDeletePopupWindow(boolean flag,String buttonName) {

		try {
			waitForExecution(500);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validatePopupWindowContent(driver, flag, popupDeletePropTitle, popupDeletePropContent, "Delete Connection Property", "Do you want to delete connection property?");

			verifyVisibilityOfButtons(driver, popupDeletePropCancel, cancelButtonContent, true);
			verifyVisibilityOfButtons(driver, popupDeletePropDelete, deleteContent, true);

			if(buttonName.equalsIgnoreCase(deleteContent)) {
				clickOnButton(driver, popupDeletePropDelete, buttonName, true);
			}else {
				clickOnButton(driver, popupDeletePropCancel, cancelButtonContent, true);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" validateAndHandlePropertyDeletePopupWindow :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean updateConnectionPropertyScenarios(String connectionName,ConnectionPoJO param,ConnectionPoJO upparam,String scenario,String icedqUser) {

		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		boolean flag=true;
		log.info(scenario);
		try {

			cp.clickOnPropertiesTab();

			switch(upparam.getConnProperty().toLowerCase()+1){

			case "addprop1":

				addConnectionProperty(upparam.getType());

				break;
			case "updateprop1":

				editConnectionProperty(upparam.getType());

				break;
			case "deleteprop1":

				deleteConnectionProperty(upparam.getType());

				break;

			default:

				break;
			}
			cp.clickOnOverviewTab();	

			if(param.getConnectionType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				cp.clickOnPropertiesTab();

				flag=viewConnectionPropertykeyAndValue(upparam.getType(), param.getConnectionType(), upparam.getConnProperty());

				cp.clickOnOverviewTab();	

			}else {

				saveAndValidateConnection(icedqUser, "");

				clickOnUserConnectionTab();

				searchConnectionAndClickOnName(connectionName);

				cp.clickOnPropertiesTab();

				flag=viewConnectionPropertykeyAndValue(upparam.getType(), param.getConnectionType(), upparam.getConnProperty());

				cp.clickOnOverviewTab();	

			}



		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" updateConnectionPropertyScenarios :: "+e.toString());
			flag=false;
		}
		return flag;
	}





	//--------------------------Invalid json connector 

	public boolean enterS3FieldValuesInvalid(ConnectionPoJO connParam,boolean flag, String scenarioType) {

		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);

		try {

			switch(scenarioType.toLowerCase().trim()+1) {

			case "folderpath1":

				flag = cp.entervalueInTextFieldWithValidation(connParam, connFlatFileFolderPathField,
						ConstantProperty.CONN_FIELD_FOLDERPATH, connParam.getFolderPath(), ConstantProperty.TEST_SCENARIO_INVALID,
						connParam.getValidationMessage(), true);

				break;

			case "container1":

				flag = cp.entervalueInTextFieldWithValidation(connParam, connFlatFileContainerField,
						ConstantProperty.CONN_FIELD_CONTAINER, connParam.getContainer(), ConstantProperty.TEST_SCENARIO_INVALID,
						connParam.getValidationMessage(), true);

				break;

			case "region1":
				flag = cp.entervalueInTextFieldWithValidation(connParam, connFlatFileRegionField,
						ConstantProperty.CONN_FIELD_REGION, connParam.getRegion(), ConstantProperty.TEST_SCENARIO_INVALID,
						connParam.getValidationMessage(), true);

				break;

			default:

				break;


			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" enterS3FieldValuesInvalid :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean enterAzureFieldValuesInvalid(ConnectionPoJO connParam,boolean flag, String scenarioType) {


		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);

		try {

			switch(scenarioType.toLowerCase().trim()+1) {

			case "folderpath1":

				flag = cp.entervalueInTextFieldWithValidation(connParam, connFlatFileFolderPathField,
						ConstantProperty.CONN_FIELD_FOLDERPATH, connParam.getFolderPath(), ConstantProperty.TEST_SCENARIO_INVALID,
						connParam.getValidationMessage(), true);

				break;

			case "container1":

				flag = cp.entervalueInTextFieldWithValidation(connParam, connFlatFileContainerField,
						ConstantProperty.CONN_FIELD_CONTAINER, connParam.getContainer(), ConstantProperty.TEST_SCENARIO_INVALID,
						connParam.getValidationMessage(), true);

				break;

			default:

				break;


			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" enterAzureFieldValuesInvalid :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean updateConnectionNameWithValidation(String connectionName, String state, String validationMessage)
			throws NoSuchElementException {

		String methodName = "updateConnectionNameWithValidation";
		boolean flag = false;
		log.info(state);
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
					sendKeys(driver, connName, "");
					clear(driver, connName);
				}
				isDisplayedInLoop(driver, 4, connName);

				click(driver, connName);
				waitForExecution(500);

				String ac = getAttribute(driver, connName, attributeValue);

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

		}
		return flag;
	}

	public boolean createJsonFileConnectionForInvalidScenarios(ConnectionPoJO connParam,String testScenario,String scenarioType, String icedqUser) {

		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);

		boolean flag = true;
		String newconnectionName = null;

		try {

			newconnectionName = connParam.getConnName();

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			flag = cp.clickOnNewConnectionBtn(icedqUser);

			if (flag) {

				cp.chooseConnectorType(connParam.getConnectorID());

				inVisible(driver, dataTSpinner, Constant.ruleWait);

				waitForExecution(2000);

				flag = cp.enterConnectionNameWithValidation(newconnectionName, testScenario, connParam.getValidationMessage());

				if (!scenarioType.equalsIgnoreCase("name")) {

					if (!(connParam.getConnectorID().toLowerCase().equalsIgnoreCase(flatFileContent))) {

						selectDriverOfConnection(connParam.getDriverName());
					}

					selectLocationOfFlatFileNativeConnection(connParam.getLocationname(), connParam);

					switch (connParam.getLocationname().trim().toLowerCase()) {

					case "local":

						flag = cp.entervalueInTextFieldWithValidation(connParam, connFlatFileFolderPathField,
								ConstantProperty.CONN_FIELD_FOLDERPATH, connParam.getFolderPath(), testScenario,
								connParam.getValidationMessage(), true);

						break;

					case "s3":

						flag = enterS3FieldValuesInvalid(connParam, flag, scenarioType);

						break;

					case "azure blob":

						flag = enterAzureFieldValuesInvalid(connParam, flag, scenarioType);

						break;

					default:

						break;

					}

				}

			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(errorLogTitle+" createJsonFileConnectionForInvalidScenarios " + e.toString());
		}

		return flag;

	}


	public boolean updateJsonConnectorForInvalidScenarios(ConnectionPoJO param,ConnectionPoJO upparam,String testScenario,String scenario,String icedqUser) {

		boolean flag = true;

		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		log.info(icedqUser);
		try {
			if(param.getConnectionType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				clickOnConnectionTab();

				searchConnectionAndClickOnName(param.getConnName());

				inVisible(driver, dataTSpinner, Constant.ruleWait);

			}

			flag = updateConnectionNameWithValidation(upparam.getConnName(), testScenario, upparam.getValidationMessage());

			if (!scenario.equalsIgnoreCase("name")) {

				if (!(upparam.getConnectorID().toLowerCase().equalsIgnoreCase(flatFileContent))) {

					selectDriverOfConnection(upparam.getDriverName());
				}

				selectLocationOfFlatFileNativeConnection(upparam.getLocationname(), upparam);

				switch (upparam.getLocationname().trim().toLowerCase()+1) {

				case "local1":

					flag = cp.entervalueInTextFieldWithValidation(param, connFlatFileFolderPathField,
							ConstantProperty.CONN_FIELD_FOLDERPATH, upparam.getFolderPath(), testScenario,
							upparam.getValidationMessage(), true);

					break;

				case "s31":

					BaseSuite.reportLog(hyphenContent+" Updating field for Amazon S3 location for invalid"+hyphenContent);

					flag =enterS3FieldValuesInvalid(upparam, flag, scenario);

					break;

				case "azure blob1":

					BaseSuite.reportLog(hyphenContent+" Updating field for Azure blob location for invalid"+hyphenContent);

					flag =enterAzureFieldValuesInvalid(upparam, flag, scenario);

					break;

				default:

					break;

				}

			}
		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(errorLogTitle+" updateJsonConnectorForInvalidScenarios " + e.toString());
		}


		return flag;
	}

	public boolean clickOnTestConnButtonAndValidateToastForInvalid(boolean flag, String expectedMessage) {
		boolean tag =true;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, connTestBtn, "Test", true);

			if(isDisplayed(driver, toastMsg)) {

				flag=cp.captureToastMsgForConnection(driver, toastMsg, toastMsgClosedBtn, expectedMessage, "Connection Test for invalid",
						false);
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedMessage.isEmpty()) {
				flag=cp.captureToastMsgForConnection(driver, toastMsg, toastMsgClosedBtn, expectedMessage, "Connection Test for invalid",
						false);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" clickOnTestConnButtonAndValidateToastForInvalid "+e.toString());
			flag =false;
		}
		return flag;
	}

	public boolean enterSecretDetailsForUpdateForInvalid(String connType, String connectorId,String connectionName,  String authType, String icedqUser) {

		boolean flag = true;


		try {

			if(!authType.equalsIgnoreCase(ConstantProperty.AUTH_LOCAL)) {

				ConnectionPoJO connParam = setSecretDetailsParamUsingExcel(connectorId,icedqUser);

				switch(connType.toLowerCase().trim()) {

				case "system":

					enterSecretName(connParam.getPublicSecret());

					enterSecret(connParam, authType);

					saveAndValidateConnection(icedqUser, "");

					break;

				case "user":

					validateSecretField(authType);

					saveAndValidateConnection(icedqUser, "");

					clickOnUserConnectionTab();

					searchConnectionAndClickOnName(connectionName);

					waitForExecution(3000);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					enterSecretName(connParam.getPrivateSecret());

					enterSecret(connParam, authType);

					saveAndValidateConnection(icedqUser, "");

					break;

				default:

					break;

				}
			}else {
				flag=saveAndValidateConnection(icedqUser, "");
			}

			if (flag) {
				flag=clickOnTestConnButtonAndValidateToastForInvalid(flag, connectionTestMess);
			}
		}  catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" enterSecretDetailsForUpdateForInvalid :: "+e.toString());
			flag = false;
		}
		return flag;

	}

	public boolean testJsonConnectorWithInvalid(ConnectionPoJO param,ConnectionPoJO upparam,String connName, String scenario,String icedqUser) {

		boolean flag = true;

		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);

		try {
			if(param.getConnectionType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				clickOnConnectionTab();

				searchConnectionAndClickOnName(connName);

				inVisible(driver, dataTSpinner, Constant.ruleWait);

			}
			switch(scenario.toLowerCase()+1) {

			case "location1":

				selectLocationOfFlatFileNativeConnection(upparam.getLocationname(), upparam);

				enterFieldDetailsForFileConnection(upparam);

				break;

			case "authentication1":

				cp.selectAuthenticationOfConnection(upparam.getAuthenticationname());

				enterFieldDetailsForFileConnectionForAuth(upparam);

				break;

			case "type1":

				selectConnectionType1(upparam.getConnectionType());

				break;

			default:

				/**	flag = cp.enterConnectionNameWithValidation(param.getConnName(), ConstantProperty.TEST_SCENARIO_VALID, "");**/

				if (!(upparam.getConnectorID().toLowerCase().equalsIgnoreCase(flatFileContent))) {

					selectDriverOfConnection(upparam.getDriverName());
				}

				selectLocationOfFlatFileNativeConnection(upparam.getLocationname(), upparam);

				switch (upparam.getLocationname().trim().toLowerCase()+1) {

				case "local1":

					validatAndeEnterValueToTextField(connFlatFileFolderPathLabel, connFlatFileFolderPathField,ConstantProperty.CONN_FIELD_FOLDERPATH, folderPathPlaceHolder,
							upparam.getFolderPath(), folderPathEmptyValidationMsg);

					break;

				case "s31":

					BaseSuite.reportLog(hyphenContent+" Updating field for Amazon S3 location "+hyphenContent);

					enterS3FieldValues(upparam, flag);

					selectConnectionType1(param.getConnectionType());

					break;

				case "azure blob1":

					BaseSuite.reportLog(hyphenContent+" Updating field for Azure blob location "+hyphenContent);

					enterAzureFieldValues(upparam, flag, param.getAuthenticationname());

					selectConnectionType1(param.getConnectionType());

					break;

				default:

					break;

				}

				break;
			}

			if ((!param.getConnectorID().toLowerCase().equalsIgnoreCase(flatFileContent))) {

				ArrayList<String> connPropertyList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(upparam.getConnectionJson(), connConnectionPropNames);

				int count = connPropertyList.size();

				cp.updateConnectionPropertiesToXMLConnection(upparam.getConnectionJson(), count);

			}

			flag = enterSecretDetailsForUpdateForInvalid(param.getConnectionType(), upparam.getSecretsColumn(), connName, param.getAuthenticationname(), icedqUser);



		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(errorLogTitle+" testJsonConnectorWithInvalid " + e.toString());
		}


		return flag;
	}


	public void createSecretUsingAPI() {
		APIUtil.generateToken();
		String authToken = APIUtil.generateOAuthToken("vipuls", "Admin@123");

		Map<String, String> customHeaders = new HashMap<>();
		customHeaders.put("workspace-Id", "customValue");
		customHeaders.put("X-Another-Header", "anotherValue");

		String jsonbody = "{\r\n"
				+ "	\"vaultType\": \"internal\",\r\n"
				+ "	\"info\": {\r\n"
				+ "		\"secret\": \"Public_Secret_For_DB_VS1\",\r\n"
				+ "		\"type\": \"public\",\r\n"
				+ "		\"description\": \"For DB connectors\"\r\n"
				+ "	},\r\n"
				+ "	\"config\": {\r\n"
				+ "		\"Snowflake\": \"NgQaU$3r~!23\",\r\n"
				+ "		\"Redshift\": \"Srgmpdns~!23\",\r\n"
				+ "		\"PostgreSQL\": \"ice123\",\r\n"
				+ "		\"Oracle\": \"icedq123\",\r\n"
				+ "		\"MySQL\": \"ice123\",\r\n"
				+ "		\"MariaDB\": \"ice123\",\r\n"
				+ "		\"Greenplum\": \"pivotal\",\r\n"
				+ "		\"DB2\": \"Admin!23\",\r\n"
				+ "		\"Teradata\":\"ice123\",\r\n"
				+ "		\"SQLServer\":\"ice123\",\r\n"
				+ "        \"Hive\":\"Admin!123\",\r\n"
				+ "        \"Impala\": \"Admin!23\"\r\n"
				+ "	}\r\n"
				+ "}";


		String createSecretResponce = APIUtil.sendPostRequest("api/v1/secret", authToken, customHeaders, jsonbody);

		System.out.println(createSecretResponce);
	}


}
