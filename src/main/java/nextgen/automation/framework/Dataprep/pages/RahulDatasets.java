/*
 * package nextgen.automation.framework.Dataprep.pages;
 * 
 * import java.util.Properties;
 * 
 * import org.antlr.grammar.v3.ANTLRParser.throwsSpec_return; import
 * org.openqa.selenium.By; import org.openqa.selenium.WebDriver;
 * 
 * import nexgen.automation.framework.baseclass.BaseSuite; import
 * nexgen.automation.framework.constant.Constant; import
 * nexgen.automation.framework.util.PageUtil;
 * 
 * public class RahulDatasets extends PageUtil
 * 
 * { //private static final By PropertiesBtnClick = null;
 * 
 * 
 * WebDriver driver; public RahulDatasets(WebDriver driver) { this.driver =
 * driver;
 * 
 * } //Webelement By propertiesBtn =
 * getElementLocator(prop.getProperty("Dataprep.propertiesBtn")); By
 * LocationTitle =
 * getElementLocator(prop.getProperty("Dataprep.LocationTitle")); By
 * WorkSpaceLabel =
 * getElementLocator(prop.getProperty("Dataprep.WorkSpaceLabel")); By
 * workspaceField =
 * getElementLocator(prop.getProperty("Dataprep.workspaceField")); By
 * folderLabel = getElementLocator(prop.getProperty("Dataprep.folderLabel")); By
 * folderField = getElementLocator(prop.getProperty("Dataprep.folderField")); By
 * propertiesTitle =
 * getElementLocator(prop.getProperty("Dataprep.PropertiesTitle")); By
 * namePropertiesLable =
 * getElementLocator(prop.getProperty("Datapre.NamePropertiesLable")); By
 * propertiesNameField =
 * getElementLocator(prop.getProperty("Dataprep.propertiesNameField")); By
 * propertiescodeLabel =
 * getElementLocator(prop.getProperty("Dataprep.PropertiescodeLabel")); By
 * codefieldproperties =
 * getElementLocator(prop.getProperty("Dataprep.codefieldproperties")); By
 * descriptionLabel =
 * getElementLocator(prop.getProperty("Dataprep.descriptionLabel")); By
 * descriptionField =
 * getElementLocator(prop.getProperty("Dataprep.descriptionField")); By
 * activeBtn = getElementLocator(prop.getProperty("Dataprep.ActiveBtn")); By
 * activeBtnFuction =
 * getElementLocator(prop.getProperty("Dataprep.ActiveBtnFuction")); By
 * parameter = getElementLocator(prop.getProperty("Dataprep.parameter")); By
 * parameterfield =
 * getElementLocator(prop.getProperty("Dataprep.Parameterfield")); By savebtn =
 * getElementLocator(prop.getProperty("Dataprep.savebtn")); By errormsg =
 * getElementLocator(prop.getProperty("Dataprep.errormsg")); By idlabel =
 * getElementLocator(prop.getProperty("Dataprep.idlabel")); By idfield=
 * getElementLocator(prop.getProperty("Dataprep.idfield")); By ActiveYes=
 * getElementLocator(prop.getProperty("Dataprep.ActiveYes")); By ActiveNo=
 * getElementLocator(prop.getProperty("Dataprep.ActiveNo")); By spinner =
 * getElementLocator(prop.getProperty("Dataprep.Spinner")); By toastMsgClosedBtn
 * = getElementLocator(prop.getProperty("ToastMsgClosedBtn1")); By toastMsg =
 * getElementLocator(prop.getProperty("Commontoastmsg")); String
 * updateDataset=prop.getProperty("Dataprep.updateDataset"); By runbutton =
 * getElementLocator(prop.getProperty("Dataprep.runbutton")); By
 * dataset_Connectionkey =
 * getElementLocator(prop.getProperty("Dataset.dropdownArrowKey")); By
 * dataset_WorkspaceKey =
 * getElementLocator(prop.getProperty("Dataset.WorkspaceArrowKey")); By
 * dataset_ReportKey =
 * getElementLocator(prop.getProperty("Dataset.ReportArrowKey")); By
 * dataset_ConfigureBtn=getElementLocator(prop.getProperty(
 * "Dataset.ConfigureBtn")); By
 * selectVisualBtn=getElementLocator(prop.getProperty("Dataprep.SelectVisualBtn"
 * )); By addButtonOnSelectVisual=getElementLocator(prop.getProperty(
 * "Dataprep.AddButton.SelectVisual")); By
 * DeleteButton=getElementLocator(prop.getProperty("Dataprep.DeleteButton")); By
 * mandatemsg=getElementLocator(prop.getProperty("Dataprep.mandatemsg")); By
 * breadcrumbs=getElementLocator(prop.getProperty("Dataprep.breadcrumbs"));
 * 
 * //This method is used to click on PropertyButton public void
 * clickOnPropertiesBtn() {
 * 
 * try { if (isEnabled(driver, propertiesBtn)) {
 * BaseSuite.reportLog("Properties Pane visible on Page"); } else {
 * BaseSuite.reportFailLog("Properties pane is not visible",
 * "verifyPropertiesBtn"); }
 * 
 * BaseSuite.reportLog("click on PropertiesBtn");
 * 
 * click(driver, propertiesBtn);
 * 
 * BaseSuite.validationReportLog("PropertiesBtn is clickable"); } catch
 * (Exception e) {
 * 
 * e.getMessage(); }
 * 
 * } //method to validate PropertyPane page public void
 * validatePropertyPanePage(String workspaceVal, String folderVal, String
 * button) { ClickOnLocationTitle(); WorspaceLabel();
 * workspaceField(workspaceVal); folderLabel(); folderField(folderVal);
 * propertiesTitle(); namePropertiesLable(); propertiesNameField();
 * propertiescodeLabel(); codefieldproperties(); descriptionLabel();
 * descriptionField(); activeBtn(); activeBtnFuction(button); parameter();
 * VerifyParameterFieldIsEditableOrNot(); }
 * 
 * //Method to Display the location public void ClickOnLocationTitle() {
 * 
 * if(isDisplayed(driver, LocationTitle)) {
 * BaseSuite.reportLog("Location Title is visible and nonclickable"); } else {
 * BaseSuite.reportLog("Location Title is not visble neither clickable"); }
 * 
 * } //Method to Display the Workspace label public void WorspaceLabel() {
 * if(isDisplayed(driver, WorkSpaceLabel)) {
 * BaseSuite.reportLog("WorkspaceLabel is visible and nonclickable"); } else {
 * BaseSuite.reportLog("WorkspaceLabel is not visble neither clickable"); }
 * 
 * } //Method to Display the Workspace Field
 * 
 * public void workspaceField(String workspaceVal) { if (isEnabled(driver,
 * workspaceField)) {
 * 
 * String Auth = getText(driver, workspaceField);
 * 
 * if(Auth.equalsIgnoreCase(workspaceVal)) { BaseSuite.validationReportLog(Auth
 * +"is visble");
 * 
 * } else { BaseSuite.reportFailLog("workspace Field is fail to display",
 * "workspaceField");
 * 
 * }
 * 
 * } else {
 * BaseSuite.reportLog("WorkspaceField is not visble neither clickable");
 * 
 * }
 * 
 * } //Method to Display the Workspace label public void verifyWorkspace(String
 * WorkspaceText) {
 * 
 * if (isDisplayed(driver, workspaceField)) { String loc = getText(driver,
 * workspaceField).trim();
 * 
 * if(loc.equalsIgnoreCase(WorkspaceText)) { BaseSuite.
 * validationReportLog("Actual Worksspace is  Matched with expected Workspace");
 * 
 * } else { BaseSuite.
 * reportFailLog("Actual Worksspace is not Matched with expected Workspace",
 * "WorkspaceText");
 * 
 * }
 * 
 * } else { BaseSuite.
 * reportLog("Actual Worksspace is not Matched with expected Workspace"); } }
 * 
 * //Method to Display the folder label public void folderLabel() { if
 * (isDisplayed(driver, folderLabel)) {
 * BaseSuite.reportLog("folderLabel is visible and nonclickable"); } else {
 * BaseSuite.reportLog("folderLabel is not visble neither clickable"); }
 * 
 * } //Method to verify Folder Path public void verifyFolderPath(String
 * folderPath) {
 * 
 * if (isDisplayed(driver, folderField)) { String loc = getText(driver,
 * folderField).trim();
 * 
 * if(loc.equalsIgnoreCase(folderPath)) { BaseSuite.
 * validationReportLog("Actual folderpath is  Matched with expected folderpath"
 * );
 * 
 * } else { BaseSuite.
 * reportFailLog("Actual folderpath is not Matched with expected folderpath"
 * ,"folderPath");
 * 
 * }
 * 
 * } else { BaseSuite.
 * reportLog("Actual folderpath is not Matched with expected folderpath"); } }
 * //Method to Display the folder Field public void folderField(String
 * folderVal) {
 * 
 * if (isDisplayed(driver, folderField)) { String rec = getText(driver,
 * folderField);
 * 
 * if(rec.equalsIgnoreCase(folderVal)) {
 * BaseSuite.validationReportLog(rec+"is visible");
 * 
 * } else { BaseSuite.reportFailLog("rec is failed to display", "folderField");
 * 
 * }
 * 
 * } else { BaseSuite.reportLog("folderField is not visble neither clickable");
 * }
 * 
 * } //Method for properties Title public void propertiesTitle() { if
 * (isDisplayed(driver, propertiesTitle)) {
 * BaseSuite.reportLog("propertiesTitle is visible and nonclickable"); } else {
 * BaseSuite.reportLog("propertiesTitle is not visble neither clickable"); }
 * 
 * } //Method to Display properties name label public void namePropertiesLable()
 * { if (isDisplayed(driver, namePropertiesLable)) {
 * BaseSuite.reportLog("Property Name Label is visible and nonclickable");
 * 
 * } else {
 * BaseSuite.reportLog("Property Name Label is not visible neither clickable");
 * }
 * 
 * } //Method to Display properties name field public void propertiesNameField()
 * { if (isEditable(driver, propertiesNameField , "Name")) {
 * BaseSuite.validationReportLog("Name field is Editable");
 * 
 * 
 * } else { BaseSuite.reportFailLog("properties Name Field is noneditable",
 * "propertiesNameField");
 * 
 * } }
 * 
 * //Method to Display properties code label public void propertiescodeLabel() {
 * if (isDisplayed(driver, propertiescodeLabel)) {
 * BaseSuite.reportLog("Property codeName is visible and nonclickable"); } else
 * { BaseSuite.reportLog("Property codeName  is not visible neither clickable");
 * } } //Method to Display properties code field
 * 
 * public void codefieldproperties() { if(isEditable(driver,
 * codefieldproperties, "code")) {
 * BaseSuite.validationReportLog("code field is Editable"); } else {
 * BaseSuite.reportFailLog("properties code field is noneditable",
 * "codefieldproperties");
 * 
 * } } //Method to Display Description label public void descriptionLabel() { if
 * (isDisplayed(driver, descriptionLabel)) {
 * BaseSuite.reportLog("DescriptionLabel is visible and nonclickable"); } else {
 * BaseSuite.reportLog("DescriptionLabel  is not visible neither clickable"); }
 * } //Method to Display Description field public void descriptionField() { if
 * (isEditable(driver, descriptionField, "Description")) {
 * 
 * } else { BaseSuite.reportFailLog("Description field is noneditable",
 * "descriptionField"); } } //Method for Active Button public void activeBtn() {
 * if (isDisplayed(driver, activeBtn)) {
 * BaseSuite.reportLog("ActiveBtnLabel is visible and nonclickable"); } else {
 * BaseSuite.reportLog("ActiveBtnLabel  is not visible neither clickable"); } }
 * //Method for Active Button Function public void activeBtnFuction(String
 * Button) { if (isDisplayed(driver, activeBtnFuction)) { String Abtn =
 * getText(driver, activeBtnFuction); if (Abtn.equalsIgnoreCase(Button)) {
 * BaseSuite.validationReportLog(Abtn+" Already Active"); } else {
 * BaseSuite.reportFailLog("Button is failed to display", "activeBtnFuction"); }
 * 
 * } else { BaseSuite.reportFailLog("Abtn is failed to Active",
 * " activeBtnFuction"); } } //Method for Parameter public void parameter() { if
 * (isDisplayed(driver, parameter)) {
 * BaseSuite.reportLog("ParameterLabel is visible and nonclickable"); } else {
 * BaseSuite.reportLog("ParameterLabel is not visible neither clickable"); } }
 * 
 * //Method to Display parameter Field public void
 * VerifyParameterFieldIsEditableOrNot() {
 * 
 * if(isEditable(driver, parameterfield,"Parameter Field")) {
 * BaseSuite.reportFailLog("Parameterfield is editable",
 * "VerifyParameterFieldIsEditableOrNot");
 * 
 * 
 * } else { BaseSuite.validationReportLog("Parameterfield is non-editable");
 * 
 * } } //Method to validate save button public void
 * ValidatingSaveBeforeRemovingDataset() {
 * 
 * if (isDisplayed(driver,savebtn)) {
 * 
 * BaseSuite.
 * validationReportLog("save Button is visible Before Removing Dataset Name");
 * 
 * } else { BaseSuite.
 * reportFailLog("save Button is Not visible Before Removing Dataset Name",
 * "ValidatingSaveBeforeRemovingDataset");
 * 
 * } } //Method to validate save button after removing dataset public void
 * ValidatingSaveAfterRemovingDataset() {
 * 
 * if (isEnabled(driver,savebtn)) {
 * 
 * BaseSuite.reportFailLog("save Button is visible After Removing Dataset Name",
 * "ValidatingSaveAfterRemovingDataset");
 * 
 * 
 * } else { BaseSuite.
 * validationReportLog("save Button is disable After Removing Dataset Name"); }
 * } //Method to clear Dataset public void clearDatasetName() {
 * 
 * if (isEnabled(driver, propertiesNameField)) { clear(driver,
 * propertiesNameField); String svr = getText(driver, errormsg);
 * BaseSuite.validationReportLog(svr );
 * 
 * } else { BaseSuite.reportFailLog("Dataset name is Not required", "svr"); }
 * 
 * } //Method to Display ID field
 * 
 * public void IdDisplay() { if(isDisplayed(driver, idfield)) {
 * BaseSuite.reportLog("ID Field is visible and nonclickable"); } else {
 * BaseSuite.reportLog("ID Field is not visble neither clickable"); }
 * 
 * } //Method to Edit ID field public void IdEdit() { isEditable(driver,
 * idfield, "Dataset ID");
 * 
 * 
 * } //Method to Display Description Function public void DiscriptionFuction() {
 * if (isDisplayed(driver, descriptionField )) { String discription =
 * getText(driver, descriptionField ); if (discription.equalsIgnoreCase("")) {
 * BaseSuite.
 * validationReportLog("Discription Field is Blank and it is not mandatory field for a existing dataset"
 * ); } else { BaseSuite.reportFailLog("Discription Field is Not Blank",
 * "descriptionField"); }
 * 
 * }
 * 
 * } //Method to Display Active button ON public void ButtonActive() throws
 * Exception {
 * 
 * click(driver, ActiveNo); String yesbtn = getText(driver, ActiveYes ); if
 * (yesbtn.equalsIgnoreCase("Yes")) {
 * BaseSuite.validationReportLog("yes button Active"); } else {
 * BaseSuite.reportFailLog("Yes button Not clicked", "YesButton"); }
 * BaseSuite.validationReportLog("Active button Turned to Yes");
 * 
 * DatasetsPage dsp = new DatasetsPage(driver); dsp.clickOnSaveButton();
 * click(driver, descriptionField); click(driver, ActiveYes);//Turn Active btn
 * to No click(driver, savebtn); dsp.clickOnSaveButton();
 * 
 * } //Method to Display Active button OFF public void ButtonInActive() throws
 * Exception {
 * 
 * click(driver, ActiveYes); String Nobtn = getText(driver, ActiveNo ); if
 * (Nobtn.equalsIgnoreCase("No")) { BaseSuite.
 * validationReportLog("Active button clicked to No mode successfully "); } else
 * { BaseSuite.reportFailLog("Active button not clicked to No", "NoButton"); }
 * BaseSuite.validationReportLog("Active button Turned to No");
 * 
 * clickToUpdateDataset();
 * 
 * click(driver, descriptionField);
 * 
 * isDisplayedInLoop(driver, 10, ActiveNo);
 * 
 * click(driver, ActiveNo);//Turn Active btn to Yes
 * 
 * BaseSuite.validationReportLog("Active button Turned to Yes Again");
 * 
 * clickToUpdateDataset();
 * 
 * } //Method to update Dataset
 * 
 * public void clickToUpdateDataset() throws Exception {
 * 
 * try {
 * 
 * displayAndClick(driver, savebtn);
 * 
 * BaseSuite.validationReportLog("Save button is clicked successfully");
 * 
 * inVisible(driver, spinner, Constant.ruleWait);
 * 
 * waitForElement(driver, toastMsgClosedBtn);
 * 
 * captureToastMsg(driver, toastMsg, toastMsgClosedBtn, updateDataset,
 * "Dataset update Message");
 * 
 * } catch (Exception e) { throw new Exception(); }
 * 
 * } //Method to Click Run Button public void ButtonInActive1() throws Exception
 * { try {
 * 
 * click(driver, ActiveYes); String Nobtn = getText(driver, ActiveNo );
 * Nobtn.equalsIgnoreCase("No"); DatasetsPage dsp = new DatasetsPage(driver);
 * dsp.clickOnSaveButton(); click(driver, savebtn); BaseSuite.
 * validationReportLog("Run button is Disable when Active button Turned to No");
 * } catch (Exception e) { throw new Exception(); } } //Method to check code
 * field public void CodeCheck(String codecheck) { String code = getText(driver,
 * codefieldproperties); clear_SendKeys(driver,codefieldproperties,
 * "Rahul_6423"); BaseSuite.
 * validationReportLog("Code field can contain alphabets, numbers and special characters"
 * ); } //Method to click on Delete Dataset public void
 * DataprepclickOnDeleteButton() {
 * BaseSuite.reportLog("Clicking on Dataset Delete Button");
 * 
 * displayAndClick(driver, DeleteButton);
 * 
 * BaseSuite.reportLog("Dataset Delete button clicked successfully");
 * 
 * } //Method to show the function of Active button to yes public void
 * ToggleBtn() { click(driver, ActiveNo); String yesbtn12 = getText(driver,
 * ActiveYes ); BaseSuite.validationReportLog("Active button Turned to Yes");
 * click(driver, ActiveYes); String Nobtn = getText(driver, ActiveNo );
 * BaseSuite.validationReportLog("Active button Turned to No"); click(driver,
 * ActiveNo); String yesbtn11 = getText(driver, ActiveYes );
 * BaseSuite.validationReportLog("Active button Turned to Yes"); } //Method to
 * show the function of Active button to No public void ToggleBtnChange() throws
 * Exception {
 * 
 * click(driver, ActiveYes); String Nobtn = getText(driver, ActiveNo ); if
 * (Nobtn.equalsIgnoreCase("No")) { BaseSuite.
 * validationReportLog("Active button clicked to No mode successfully "); } else
 * { BaseSuite.reportFailLog("Active button not clicked to No", "NoButton"); }
 * BaseSuite.validationReportLog("Active button Turned to No"); } //Method to
 * show the Discription scroll fuctionality public void Discriptionscroll() {
 * String Disscroll = getText(driver,descriptionField);
 * clear_SendKeys(driver,descriptionField,
 * "Everybody wants to be famous, but nobody wants to do the work. I live by that. You grind hard so you can play hard. At the end of the day, you put all the work in, and eventually it�ll pay off. It could be in a year, it could be in 30 years. Eventually, your hard work will pay off."
 * ); BaseSuite.
 * validationReportLog("scrollbar shows in the description field successfully");
 * } //Method to Verify parameter Field Is editable or Not public void
 * VerifyparameterFieldIsDisabled() {
 * 
 * if(isEditable(driver, parameterfield,"Parameter Field")) {
 * BaseSuite.reportFailLog("Parameterfield is editable",
 * "VerifyparameterFieldIsDisabled");
 * 
 * 
 * } else { BaseSuite.validationReportLog("Parameterfield is Disabled");
 * 
 * } } //Method to show fuctionality for Run button when Active button is Yes
 * public void RunButtonActive() throws Exception { try {
 * 
 * click(driver, runbutton); String Runbtn = getText(driver, runbutton );
 * Runbtn.equalsIgnoreCase("Yes"); DatasetsPage dsp = new DatasetsPage(driver);
 * BaseSuite.
 * validationReportLog("Run button is Enable when Active button Turned to Yes");
 * } catch (Exception e) { throw new Exception(); } } //Method to show
 * fuctionality for breadcrumbs public void breadcrumbs() {
 * 
 * 
 * String bread = getText(driver, breadcrumbs );
 * BaseSuite.validationReportLog("Datasets"+ ">" +
 * "Automation-WKS-NK-01"+">"+"Validation"+">"+"Test"+">"+"Dataset_Rahul6423w" +
 * "");
 * 
 * }
 * 
 * private String getText(WebDriver driver2, int i) { // TODO Auto-generated
 * method stub return null; } }
 * 
 * 
 * 
 */