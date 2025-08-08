package nexgen.automation.framework.connectionRepo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.atlassian.util.concurrent.TimedOutException;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.util.XLUtils;
import nextgen.automation.RuleRepo.pages.TestDataThroughApi;

public class RahulConnectionPage extends NewConnectionRepoPage {
	public RahulConnectionPage(WebDriver driver) {
		super(driver);
	}

	//////////////
	String systempropertiesSavebtn = prop.getProperty("Connection.SystempropertiesSavebtn");

	By userpropertiesSavebtn = getElementLocator(prop.getProperty("Connection.userpropertiesSavebtn"));

	By deleteIcon = getElementLocator(prop.getProperty("Connection.deleteIcon"));

	By connnameTitle = getElementLocator(prop.getProperty("Connection.connnameTitle"));

	By autheTitle = getElementLocator(prop.getProperty("Connection.autheTitle"));

	By checckboxTitle = getElementLocator(prop.getProperty("Connection.checckboxTitle"));

	By textAreaBox = getElementLocator(prop.getProperty("Connection.textAreaBox"));

	By accIdentifierTitle = getElementLocator(prop.getProperty("Connection.AccIdentifierTitle"));

	By warehouseTitle = getElementLocator(prop.getProperty("Connection.WarehouseTitle"));

	By databaseTitle = getElementLocator(prop.getProperty("Connection.DatabaseTitle"));

	By typeTitle = getElementLocator(prop.getProperty("Connection.TypeTitle"));

	By userNameTitle = getElementLocator(prop.getProperty("Connection.userNameTitle"));

	By passwordTitle = getElementLocator(prop.getProperty("Connection.PasswordTitle"));

	By duplicatebtn = getElementLocator(prop.getProperty("Connection.duplicatebtn"));

	By connPageCommonInput = getElementLocator(prop.getProperty("Connection.connPageCommonInput"));

	String systemPropertyNameSavebtn = prop.getProperty("connection.systemPropertyNameSavebtn");

	String userPropertyNameSavebtn = prop.getProperty("connection.userPropertyNameSavebtn");

	By conntypeselect = getElementLocator(prop.getProperty("Connection.conntypeselect"));

	By deleteHeader1 = getElementLocator(prop.getProperty("Connection.deleteHeader1"));

	By deleteConfirmMsg = getElementLocator(prop.getProperty("Connection.deleteConfirmMsg"));

	String deleteMsg = prop.getProperty("Connection.DeleteMessage");

	By deleteConnBtn = getElementLocator(prop.getProperty("Connection.deleteConnBtn"));

	By cancelDeleteConnBtn = getElementLocator(prop.getProperty("Connection.cancelDeleteConnBtn"));
	By chooseConnType = getElementLocator(prop.getProperty("conn.database.connectionTypeDD"));
	By connSnowflakeDriverLabel = getElementLocator(prop.getProperty("Connection.connSnowflakeDriverLabel"));

	By connSnowflakeField = getElementLocator(prop.getProperty("Connection.connSnowflakeField"));

	By connSnoeflakeDriverDDBtn = getElementLocator(prop.getProperty("Connection.connSnoeflakeDriverDDBtn"));

	By connSnowflakeDriverDDList = getElementLocator(prop.getProperty("Connection.connSnowflakeDriverDDList"));

	String connSnowflakeSelectLocation = prop.getProperty("Connection.connSnowflakeSelectLocation");

	String connSingleDeleteToastMsg = prop.getProperty("Connection.Conn.SingleDelete.ToastMsg");

	By popUpMsg = getElementLocator(prop.getProperty("Connection.popUpMsg"));

	By connsecretPasswordfeild = getElementLocator(prop.getProperty("Connection.secretPassword.feild"));
	
	By connsecretQuickAddbtn = getElementLocator(prop.getProperty("Connection.secret.QuickAddbtn"));
	By connsecretName = getElementLocator(prop.getProperty("Connection.secretName"));
	By connsecretManagebtn = getElementLocator(prop.getProperty("Connection.secret.Managebtn"));
	
	////////////////////////////

	/** Validate and select driver type of Snowflake connection **/

	public void selectDriverOfSnowflakeConnection(String driverName) {

		try {
			String authValue1 = null;

			isDisplayedInLoop(driver, 2, connSnowflakeDriverLabel);

			javascript(driver, scrollToElementArg, connSnowflakeDriverLabel);

			verifyIndividualLabel(driver, connSnowflakeDriverLabel, ConstantProperty.CONN_FIELD_LOCATION);

			if (isDisplayed(driver, connSnowflakeField)) {

				BaseSuite.validationReportLog("Driver field is visible ");

				authValue1 = getAttribute(driver, connSnowflakeField, valueAttribute);

				if (!authValue1.isEmpty()) {

					BaseSuite.reportLog("Default Driver type selected as : " + authValue1);
				} else {
					BaseSuite.reportFailLog("Default Driver Name is empty", "selectDriverOfSnowflakeConnection");
				}
				isDisplayedInLoop(driver, 2, connSnoeflakeDriverDDBtn);

				if (isDisplayed(driver, connSnoeflakeDriverDDBtn)) {

					displayAndClick(driver, connSnoeflakeDriverDDBtn);

					BaseSuite.validationReportLog(
							"Clicked on Location drop down " + ConstantProperty.SUCCESSSTRING + "");

					BaseSuite.reportLog("Checking list of location type visible");
					Thread.sleep(1000);
					List<WebElement> authList1 = getElements(driver, connSnowflakeDriverDDList);

					for (int i = 0; i < authList1.size(); i++) {

						String authName = authList1.get(i).getAttribute("data-value");

						BaseSuite.reportLog((i + 1) + ". " + authName + " is visible");

					}
				}

				isDisplayedInLoop(driver, 4, returnElement(connSnowflakeSelectLocation, dynamicName, driverName));

				if (isDisplayed(driver, returnElement(connSnowflakeSelectLocation, dynamicName, driverName))) {

					displayAndClick(driver, returnElement(connSnowflakeSelectLocation, dynamicName, driverName));

					authValue1 = getAttribute(driver, connSnowflakeField, valueAttribute);

					if (!authValue1.isEmpty()) {
						BaseSuite.validationReportLog("Driver type selected as : " + authValue1);
					}

				} else {
					BaseSuite.reportFailLog("Expected Driver type not found kindly check",
							"selectDriverOfSnowflakeConnection");
				}

			} else {
				BaseSuite.reportFailLog("Driver field not visible ", "selectDriverOfSnowflakeConnection");
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			e.getMessage();
			throw new NoSuchElementException();
		}
	}

	public boolean updateSnowflakeConnectionMethod(String connJsonEntity, SoftAssert soft, String icedqUser)
			throws InterruptedException {
		boolean flag = true;
		String str = "check";

		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);

			Thread.sleep(1000);

			String connusername = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

			String connpassword = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 2);

			// searchAndClickOnConnectionNameInConnRepo(connParam.getConnName());

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {
				
			//	String timestamp = new SimpleDateFormat(ConstantProperty.CONNECTIONNAME_TIMESTAMPFORMAT).format(new Date());

				String updatedConnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE + icedqUser;

				updateConnectionName(updatedConnectionName);

				String authName = setAuthenticationType(connParam.getAuthentication());

				selectAuthenticationOfConnection(authName);

				String actualState = getAttribute(driver, connCustomJDBCCheckbox, "class");

				if (actualState.contains(str)) {
					BaseSuite.validationReportLog("Default condition of Custom JDBC URL checkbox is checked");

					viewAndValidateConnectionField(connCustomJDBCTextbox, "Connection JDBC URL",
							connParam.getCustomJDBCURLValue(), true);

					enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());

					viewAndValidateConnectionField(accountIdentifierInput, "Account Identifire", "", false);

					viewAndValidateConnectionField(connWarehouseInput, "Warehouse", "", false);

					viewAndValidateConnectionField(connDatabaseInput, "Database", "", false);

				} else {
					viewAndValidateConnectionField(accountIdentifierInput, "Account Identifire",
							connParam.getNameAccount(), true);

					enterAccountIdentifier(connParam.getAccountIdentifire());

					viewAndValidateConnectionField(connWarehouseInput, "Warehouse", connParam.getWarehouse(), true);

					enterWarehouse(connParam.getWarehouse());

					viewAndValidateConnectionField(connDatabaseInput, "Database", connParam.getDatabaseName(), true);

					enterDatabase(connParam.getDatabaseName());

				}

				enterUsername(connusername);

				enterPassword(connpassword);

				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, "$.connectionProperties..name");

				updateSystemConnectionPropertiesToConnection(connJsonEntity, connPropertyList);

			} else if (connParam.getType().trim().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {
				clickOnUserConnectionTab();

				searchAndClickOnConnectionNameInConnRepo(connParam.getConnName());

				Thread.sleep(1000);
				enterUsername(connusername);

				enterPassword(connpassword);

				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, "$.connectionProperties..name");

				updateUserConnectionPropertiesToConnection(connJsonEntity, connPropertyList);

			}

			saveConnection();

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog("Connection Didn't Update properly due to exception kindly check " + e.toString());
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

	public void updateUserConnectionUsingInvalidRoles(String connJsonEntity) {
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			String connusername = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

			String connpassword = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 2);

			clickOnUserConnectionTab();

			searchAndClickOnConnectionNameInConnRepo(ConstantProperty.nrr9456);

			// driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

			enterUsername(connusername);

			enterPassword(connpassword);

			saveConnection(updateAndSaveClickErrorMessage);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void updateSystemConnectionProperty(String name, String value, String type) {

		try {

			NewConnectionRepoPage cp = new NewConnectionRepoPage(driver);

			cp.clickOnEditButtonfromConnProperty(name);

			enterConnPropertyName(name.trim());

			enterConnPropertyValue(value.trim());

			selectPropertyType(type.trim());

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			clickonSavePropertyIconBtnForSystemConn(name);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void updateUserConnectionProperty(String name, String value) {

		try {

			NewConnectionRepoPage cp = new NewConnectionRepoPage(driver);

			cp.clickOnEditButtonfromConnProperty(name);

			enterConnPropertyValue(value.trim());

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			clickonSavePropertyIconBtnForUserConn();

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void clickonSavePropertyIconBtnForSystemConn(String systemPropertyNameSavebtn) {
		try {

			Thread.sleep(1000);

			if (isDisplayed(driver, returnElement(systempropertiesSavebtn, "$name", systemPropertyNameSavebtn))) {
				if (isEnabled(driver, returnElement(systempropertiesSavebtn, "$name", systemPropertyNameSavebtn))) {
					BaseSuite.reportLog("Clicking on save property icon  button");

					displayAndClick(driver, returnElement(systempropertiesSavebtn, "$name", systemPropertyNameSavebtn));

					BaseSuite.validationReportLog("Save property icon button clicked successfully.");
				} else {
					BaseSuite.reportErrorLog("Save property icon button is disabled in UI , kindly check.");
				}

			} else {
				BaseSuite.reportErrorLog("Save property icon button is not displayed in UI , kindly check.");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void clickonSavePropertyIconBtnForUserConn() {
		try {
			if (isDisplayed(driver, userpropertiesSavebtn)) {
				if (isEnabled(driver, userpropertiesSavebtn)) {
					BaseSuite.reportLog("Clicking on save property icon  button");

					displayAndClick(driver, userpropertiesSavebtn);

					BaseSuite.validationReportLog("Save property icon button clicked successfully.");
				} else {
					BaseSuite.reportErrorLog("Save property icon button is disabled in UI , kindly check.");
				}

			} else {
				BaseSuite.reportErrorLog("Save property icon button is not displayed in UI , kindly check.");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to update system connection properties to connection
	public void updateSystemConnectionPropertiesToConnection(String jsonEntity, List<String> connPropertyList)
			throws Exception {
		try {
			if (connPropertyList.size() > 0) {
				clickOnPropertiesTab();

				ArrayList<String> name = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..name");

				ArrayList<String> value = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..value");

				ArrayList<String> type = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..type");

				for (int j = 0; j < name.size(); j++) {

					updateSystemConnectionProperty(name.get(j), value.get(j), type.get(j));
				}

			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();

		}
	}

	// method to update User connection properties to connection
	public void updateUserConnectionPropertiesToConnection(String jsonEntity, List<String> connPropertyList)
			throws Exception {
		try {
			if (connPropertyList.size() > 0) {
				clickOnPropertiesTab();

				ArrayList<String> name = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..name");

				ArrayList<String> value = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..value");

				ArrayList<String> type = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.connectionProperties..type");

				for (int j = 0; j < name.size(); j++) {

					String connTypename = type.get(j);
					if (connTypename.equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

						updateUserConnectionProperty(name.get(j), value.get(j));
					}
				}

			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();

		}
	}

	// Connection Delete code start's

	public boolean deleteSnowflakeConnection(String connJsonEntity, String icedqUser) {
		boolean flag = true;
		try {

			validateSnowflakeConnectionPageLabels();

			validateConnectionPageFeilds(connJsonEntity, icedqUser);

			validateDeletePopUp();

			deleteConnection(forbiddenToastMsg, icedqUser);

		} catch (Exception e) {
			e.getMessage();
		}
		return true;
	}

	public void validateConnectionPageFeilds(String connJsonEntity, String icedqUser) {

		try {

			String str = "check";

			NewConnectionRepoPage cp = new NewConnectionRepoPage(driver);

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				viewAndValidateConnectionField(connName, "Connection Name", connParam.getConnName(), true);

				String authType = setAuthenticationType(connParam.getAuthentication());

				viewAndValidateConnectionField(connAuthTypeField, "Connection Authentication", authType, true);

				String actualState = getAttribute(driver, connCustomJDBCCheckbox, "class");

				if (actualState.contains(str)) {
					BaseSuite.validationReportLog("Default condition of Custom JDBC URL checkbox is checked");

					viewAndValidateConnectionField(connCustomJDBCTextbox, "Connection JDBC URL",
							connParam.getCustomJDBCURLValue(), true);

					viewAndValidateConnectionField(accountIdentifierInput, "Account Identifire", "", false);

					viewAndValidateConnectionField(connWarehouseInput, "Warehouse", "", false);

					viewAndValidateConnectionField(connDatabaseInput, "Database", "", false);

				} else {

					viewAndValidateConnectionField(connCustomJDBCTextbox, "Connection JDBC URL",
							connParam.getCustomJDBCURLValue(), false);

					viewAndValidateConnectionField(accountIdentifierInput, "Account Identifire",
							connParam.getAccountIdentifire(), true);

					viewAndValidateConnectionField(connWarehouseInput, "Warehouse", connParam.getWarehouse(), true);

					viewAndValidateConnectionField(connDatabaseInput, "Database", connParam.getDatabaseName(), true);

				}
				inVisible(driver, spinner, Constant.ruleWait);

				viewAndValidateConnectionField(connUsernameInput, "Username", connParam.getUsername(), true);

				viewAndValidateConnectionField(connPasswordInput, "Password", connParam.getPassword(), true);

				verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", true);

				verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

				verifyVisibilityOfButtons(driver, duplicatebtn, "Duplicate Connection Create Button", true);

				verifyVisibilityOfButtons(driver, deleteIcon, "DeleteButton", true);

			} else if (connParam.getType().trim().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				cp.clickOnUserConnectionTab();

				searchAndClickOnConnectionNameInConnRepo(connParam.getConnName());

				String userNamevalue = getAttribute(driver, connUsernameInput, "value");

				String passWordValue = getAttribute(driver, connPasswordInput, "value");

				inVisible(driver, spinner, Constant.ruleWait);

				if (userNamevalue.isEmpty() && passWordValue.isEmpty()) {
					verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);
				} else {
					verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", true);
				}

				verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

				viewAndValidateConnectionField(connUsernameInput, "Username", "", true);

				viewAndValidateConnectionField(connPasswordInput, "Password", "", true);

				viewAndValidateConnectionField(connPropertiesTab, "PropertyTab", "", true);

				cp.clickOnConnectionsTab();

				searchAndClickOnConnectionNameInConnRepo(connParam.getConnName());

			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to validate Delete alert pop up window to delete connection
	public void validateDeletePopUp() {

		try {

			BaseSuite.validationReportLog("Click on Delete Icon");

			click(driver, deleteIcon);

			inVisible(driver, spinner, Constant.ruleWait);

			BaseSuite.validationReportLog("Delete Icon clicked successfully");

			isDisplayedInLoop(driver, 10, deleteHeader1);

			if (isDisplayed(driver, deleteHeader1)) {

				verifyIndividualLabel(driver, deleteHeader1, "Delete Connection");
				verifyRetrivedValues(driver, deleteConfirmMsg, "Delete Connection message", deleteMsg);
				verifyVisibilityOfButtons(driver, deleteConnBtn, "Delete", true);
				verifyVisibilityOfButtons(driver, cancelDeleteConnBtn, "Cancel", true);
			} else {
				BaseSuite.reportFailLog("Delete pop up window not visible", "validateDeletePopUp");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public boolean deleteConnection(String toastMessage, String icedqUser) {
		boolean flag = true;
		try {
			if (icedqUser.contains("owner")) {
				BaseSuite.validationReportLog("Click on Delete Button to  Delete Connection");
				click(driver, deleteConnBtn);
				inVisible(driver, spinner, Constant.ruleWait);
				BaseSuite.validationReportLog("Connection Deleted successfully");
			} else {
				click(driver, deleteConnBtn);
				inVisible(driver, spinner, Constant.ruleWait);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				flag = captureToastMsg(driver, toastMsg, popUpClose, toastMessage, "Connection Delete");
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return flag;
	}

	public void validateSnowflakeConnectionPageLabels() {
		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			verifyVisibilityOfButtons(driver, connPropertiesTab, "PropertyTab", true);

			verifyIndividualLabel(driver, connnameTitle, "Connection Name Title");

			verifyIndividualLabel(driver, autheTitle, "Authentication Title");

			verifyIndividualLabel(driver, checckboxTitle, "check box Title");

			verifyIndividualLabel(driver, accIdentifierTitle, "account Identifier Title");

			verifyIndividualLabel(driver, warehouseTitle, "warehouse Title");

			verifyIndividualLabel(driver, databaseTitle, "Database Title");

			verifyIndividualLabel(driver, typeTitle, "Connection Type Title");

			verifyIndividualLabel(driver, userNameTitle, "userName Title");

			verifyIndividualLabel(driver, passwordTitle, "password Title");

		} catch (Exception e) {
			e.getMessage();
		}
	}

	/** Duplicate Snowflake connection using API **/
	public boolean duplicateSnowflakeConnectionMethod(String connJsonEntity, String icedqUser) {
		boolean flag = false;
		String name = null;
		try {

			//viewSnowflakeConnectionMethod(connJsonEntity, icedqUser);

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				clickOnConnectionsTab();
				
				isDisplayedInLoop(driver, 0, discardButtons);
				if (isDisplayed(driver, discardButtons)) {
					displayAndClick(driver, discardButtons);
				}

				searchAndClickOnConnectionNameInConnRepo(connParam.getConnName() +  ConstantProperty.SIGN_UNDERSCORE + ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault");

				inVisible(driver, spinner, Constant.ruleWait);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			}
			if (icedqUser.contains("owner")) {

				flag = clickOnDuplicateConnection(connDupllicateToastMsg);

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				if (flag) {
					name = getAttribute(driver, connName, valueAttribute);
					
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					clickOnConnectionsTab();
					
					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}

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

	/**
	 * Enter connection name method - state is for valid / invalid connection name
	 * field if state = true then valid data else invalid data
	 **/
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

	/*************** Invalid Scenario's for Snowflake Connection Starts ****/

	

	// flag = captureToastMsg(driver, toastMsg, popUpClose, popUpMsg, "Connection
	// Popup Message");

	/** View DataBase connection details method **/

	public boolean viewDatabaseConnection(String connJsonEntity, String driverName) {
		boolean flag = true;
		NewConnectionRepoPage np = new NewConnectionRepoPage(driver);

		try {
			ConnectionPoJO connParam = np.setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);

			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

			Thread.sleep(2000);

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

	/*
	 * public boolean toCheckPropertyName(String connJsonEntity, String
	 * testScenario, String fieldName)throws Exception { boolean flag =true; boolean
	 * status=false; String newconnectionName=null; NewConnectionRepoPage np = new
	 * NewConnectionRepoPage(driver); ConnectionRepoCommonPage cp = new
	 * ConnectionRepoCommonPage(driver); try {
	 * 
	 * ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);
	 * 
	 * newconnectionName = connParam.getConnName() ;
	 * 
	 * 
	 * ArrayList<String> connPropertyList =
	 * TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity,
	 * connConnectionPropNames);
	 * 
	 * int count = connPropertyList.size();
	 * 
	 * status = cp.addConnectionPropertiesToConnection1(connJsonEntity,
	 * count,testScenario, fieldName );
	 * 
	 * clickOnOverviewTab(); } catch (Exception e) { flag=false;
	 * Thread.currentThread().interrupt(); BaseSuite.
	 * reportErrorLog("Database connection not created properly kindly check :"+e.
	 * toString()); } return flag;
	 * 
	 * }
	 */
	/** Test oracle connection using API Invalid test data **/
	public boolean testDatabaseConnectionMethodForInvalidScenario(String connJsonEntity, String testScenario,
			String fieldName, String onvalidationMessage, String onSaveValidation, String icedqUser, String tctype)
			throws NullPointerException {
		boolean flag = true;
		boolean status1 = false;
		boolean status = false;
		String newconnectionName = null;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);

		NewConnectionRepoPage np = new NewConnectionRepoPage(driver);

		XLUtils xl = new XLUtils();
		try {

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName();

			String timestamp = new SimpleDateFormat(ConstantProperty.CONNECTIONNAME_TIMESTAMPFORMAT).format(new Date());

			newconnectionName = connParam.getConnName() + "_" + BaseSuite.WorkspaceName + "_" + timestamp;

			status1 = entervalueInTextFieldWithValidation(connName, "Connection Name", newconnectionName, testScenario,
					onvalidationMessage, true);

			if (!tctype.isEmpty()) {

				np.selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

				np.selectAuthenticationOfConnection(connParam.getAuthenticationname());

				boolean cs = np.selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

				if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

					switch (fieldName.toLowerCase().trim()) {

					case "connectionname":

						if (cs) {
							entervalueInTextFieldWithValidation(connCustomJDBCTextbox, "",
									connParam.getCustomJDBCURLValue(), testScenario, onvalidationMessage, true);
						}

						entervalueInTextFieldWithValidation(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
								connParam.getHost(), testScenario, onvalidationMessage, true);
						entervalueInTextFieldWithValidation(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
								connParam.getPort(), testScenario, onvalidationMessage, true);
						entervalueInTextFieldWithValidation(connDatabaseInputField,
								ConstantProperty.CONN_FIELD_DATABASE, connParam.getDatabaseName(), testScenario,
								onvalidationMessage, true);
						entervalueInTextFieldWithValidation(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME,
								connParam.getUsername(), testScenario, onvalidationMessage, true);
						entervalueInTextFieldWithValidation(connPasswordInput, ConstantProperty.CONN_FIELD_PASSWORD,
								connParam.getPassword(), testScenario, onvalidationMessage, true);

						if (icedqUser.toLowerCase().contains("owner")) {

							status = np.saveConnection(onSaveValidation);

						} else {

							status = np.saveConnection(forbiddenToastMsg);
						}
						break;

					case "jdbcurl":
						if (cs) {
							status = entervalueInTextFieldWithValidation(connCustomJDBCTextbox, "",
									connParam.getCustomJDBCURLValue(), testScenario, onvalidationMessage, true);

						}
						break;

					case "host":
						np.selectCustomJDBCURLOfConnection("false");
						status = entervalueInTextFieldWithValidation(connHostInputField,
								ConstantProperty.CONN_FIELD_HOST, connParam.getHost(), testScenario,
								onvalidationMessage, true);

						break;

					case "port":
						np.selectCustomJDBCURLOfConnection("false");
						status = entervalueInTextFieldWithValidation(connPortInputField,
								ConstantProperty.CONN_FIELD_PORT, connParam.getPort(), testScenario,
								onvalidationMessage, true);

						break;
					case "database":
						np.selectCustomJDBCURLOfConnection("false");
						status = entervalueInTextFieldWithValidation(connDatabaseInputField,
								ConstantProperty.CONN_FIELD_DATABASE, connParam.getDatabaseName(), testScenario,
								onvalidationMessage, true);

						break;
					case "username":

						status = entervalueInTextFieldWithValidation(connUsernameInput,
								ConstantProperty.CONN_FIELD_USERNAME, connParam.getUsername(), testScenario,
								onvalidationMessage, true);

						break;
					case "password":
						status = entervalueInTextFieldWithValidation(connPasswordInput,
								ConstantProperty.CONN_FIELD_PASSWORD, connParam.getPassword(), testScenario,
								onvalidationMessage, true);

						break;

					case "propertyname":
					case "propertyvalue":
						ArrayList<String> connPropertyList = TestDataThroughApi
								.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

						int count = connPropertyList.size();

						status = cp.addConnectionPropertiesToConnection1(connJsonEntity, count, testScenario,
								fieldName);

						clickOnOverviewTab();

						break;

					default:
						BaseSuite.reportErrorLog("Field name is not found kindly check :: " + fieldName);
						break;

					}

				} else {

					entervalueInTextFieldWithValidation(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME,
							connParam.getUsername(), testScenario, onvalidationMessage, true);

					entervalueInTextFieldWithValidation(connPasswordInput, ConstantProperty.CONN_FIELD_PASSWORD,
							connParam.getPassword(), testScenario, onvalidationMessage, true);

				}

			} else if (status1) {
				status = true;

			}

			if (status || status1) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (TimedOutException e) {
			flag = false;

			BaseSuite.reportFailLog("Application spinner taking more time to invisible than stardard time",
					"testDatabaseConnectionMethodForInvalidScenario");

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

	/** testScenario = "Valid/Invalid" , ValidationMessage blank for valid name **/

	public boolean testInvalidScenarioForSnowflakeConnection(String connJsonEntity,ConnectionPoJO connParamFromExcel,
			String connectionName, String testScenario, String icedqUser,String connectionType) {
		boolean flag = false;
		boolean status = true;
		String newconnectionName = null;
		NewConnectionRepoPage np = new NewConnectionRepoPage(driver);
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {
			
			
			ConnectionPoJO connParam = np.setConnectionParametersForApi(connJsonEntity);

			newconnectionName = connParam.getConnName();

			if (!icedqUser.contains("reader") && (connParam.getType().trim().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE))) {

				cp.entervalueInTextFieldWithValidation(connParam,connName, "Connection Name", newconnectionName,
						testScenario, connParamFromExcel.getValidationMessage(), true);

				String authName = cp.setAuthenticationType(connParam.getAuthentication());

				selectAuthenticationOfConnection(authName);

				boolean cs = selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

				enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), connParam.getCustomJDBCURLValue());
				if (cs) {

					validateInputFieldVisibility(accountIdentifierInput, "Account Identifire",connAccountIdentifirePlaceHolder, false);
					validateInputFieldVisibility(connWarehouseInput, "Warehouse", connWarehousePlaceHolder, false);
					validateInputFieldVisibility(connDatabaseInput, "Database", connDatabasePlaceHolder, false);

				} else {

					enterAccountIdentifier(connParam.getAccountIdentifire());

					enterWarehouse(connParam.getWarehouse());

					enterDatabase(connParam.getDatabaseName());

				}
				selectConnectionType(connParam.getType());
				
				if (connParam.getAuthentication().equalsIgnoreCase("password")) {

					enterUsername(connParam.getUsername());

					String a1 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity, "$.secretId");
					
					cp.enterSecretName(a1);

				   String a2=  TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity, "$.authConfig.password");
					
					cp.selectVaultPassword(a2, ConstantProperty.CONN_FIELD_PASSWORD);
					
				} else if (connParam.getAuthentication().equalsIgnoreCase("key-pair")) {

					String a3 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity, "$.authConfig.username");
					
					cp.enterUsername(a3);
					
					String a1 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity, "$.secretId");
					
					cp.enterSecretName(a1);
					
					String a2 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity,
							"$.authConfig.privateKeyContentBase64Encoded");

					cp.selectVaultKeyFileContent(a2);

					String a4 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity,
							"$.authConfig.privateKeyPassphrase");

					cp.selectVaultPassword(a4, ConstantProperty.CONN_FEILD_KEYFILEPASSWORD);
				}
					

				status = cp.saveAndTestConnectionForInvalidScenario(icedqUser, status, connectionType);
				
			} else if (connParam.getType().trim().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				clickOnUserConnectionTab();

				searchAndClickOnConnectionNameInConnRepo(newconnectionName);

				Thread.sleep(1000);

				if (connParam.getAuthentication().equalsIgnoreCase("password")) {

				
					String a3 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity, "$.authConfig.username");
					
					cp.enterUsername(a3);

					String a1 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity, "$.secretId");
					
					cp.enterSecretName(a1);

				   String a2=  TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity, "$.authConfig.password");
					
					cp.selectVaultPassword(a2, ConstantProperty.CONN_FIELD_PASSWORD);
					
				} else if (connParam.getAuthentication().equalsIgnoreCase("key-pair")) {

					String a3 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity, "$.authConfig.username");
					
					cp.enterUsername(a3);
					
					String a1 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity, "$.secretId");
					
					cp.enterSecretName(a1);
					
					String a2 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity,
							"$.authConfig.privateKeyContentBase64Encoded");

					cp.selectVaultKeyFileContent(a2);

					String a4 = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(connJsonEntity,
							"$.authConfig.privateKeyPassphrase");

					cp.selectVaultPassword(a4, ConstantProperty.CONN_FEILD_KEYFILEPASSWORD);

					
				} 

				status = saveConnection();

				if (status) {

					clickOnButton(driver, connTestBtn, "Test", true);
					
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					inVisible(driver, spinner, 80);

					flag = captureToastMsgForConnection(driver, toastMsg, popUpClose, connectionTestMess,
							"Connection Test", false);
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

	public boolean createDatabaseConnectionForAllConnectors(String connJsonEntity, String testScenario,
			String validationMessage, String icedqUser) {
		boolean flag = true;
		String newconnectionName = null;
		NewConnectionRepoPage np = new NewConnectionRepoPage(driver);
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);

		try {

			String connusername = null;
			String connpassword = null;

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			String connectorName = setConnectorIdToConnectorName(connParam.getConnectorID());

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE
					+ ConstantProperty.TARGET_WORKSPACE_NAME;

			if (connectorName.contains("Oracle")) {

				connusername = cp.getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

				connpassword = cp.getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 2);

			} else if (connectorName.contains("Sybase")) {

				connusername = cp.getConnectionDetailsUsingAuthType(BaseSuite.Sybasetype, 1);

			}

			String connhostCloud = cp.getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 18);

			String connportCloud = cp.getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 19);

			String[] port = connportCloud.split("-");

			String portASE = port[0];

			String portIQ = port[1];

			String fulurlCloud = cp.getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 21);

			String[] JDBCURL = fulurlCloud.split("-");

			String JDBCURLASE = JDBCURL[0];

			String JDBCURLIQ = JDBCURL[1];

			String connhost = cp.getConnectionDetailsUsingAuthType(BaseSuite.Sybasetype, 18);

			String connport = cp.getConnectionDetailsUsingAuthType(BaseSuite.Sybasetype, 19);

			String conndb = cp.getConnectionDetailsUsingAuthType(BaseSuite.Sybasetype, 20);

			String fulurl = cp.getConnectionDetailsUsingAuthType(BaseSuite.Sybasetype, 21);

			// np.connectionRepositoryLandingPage();

			flag = cp.clickOnNewConnectionBtn(icedqUser);

			if (flag) {

				inVisible(driver, spinner, Constant.ruleWait);

				// driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				cp.chooseConnectorType(connParam.getConnectorID());

				String wizardStatus = cp.validateNewConnPageButtonsFields(connParam.getConnectorID());

				if (wizardStatus.contains("Wizard supported connector")) {

					verifyVisibilityOfButtons(driver, connCrawlIconBtn, "Crawl Icon Button", false);
				}

				verifyVisibilityOfButtons(driver, connSaveBtn, "Save Button", false);

				verifyVisibilityOfButtons(driver, connTestBtn, "Test Button", false);

				verifyVisibilityOfButtons(driver, discardButtonsDetails, "Discard Button", false);

				verifyVisibilityOfButtons(driver, connDeleteButton, "Dalete Button", false);

				verifyVisibilityOfButtons(driver, connDuplicateButton, "Duplicate Button", false);

				cp.enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

				cp.selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

				String authName = cp.setAuthenticationType(connParam.getAuthentication());

				selectAuthenticationOfConnection(authName);

				boolean cs = cp.selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());
				
				if ((BaseSuite.baseURL.contains("onprem")
						|| BaseSuite.baseURL.contains("https://192.168.100."))) {

				enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), fulurl);
				
				}else {
					
					if (BaseSuite.Sybasetype.equalsIgnoreCase("sybaseASE")) {

						enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), JDBCURLASE);

					} else {
						
						enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), JDBCURLIQ);
					}
				}

				switch (connectorName) {

				case "Sybase":
					if (cs) {

						cp.validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
								connHostPlaceholder, false);
						cp.validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
								connPortPlaceholder, false);
						cp.validateInputFieldVisibility(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
								connDatabasePlaceHolder, false);

					} else {

						if ((BaseSuite.baseURL.contains("onprem")
								|| BaseSuite.baseURL.contains("https://192.168.100."))) {

							cp.validatAndeEnterValueToTextField(connHostTitle, connHostInputField,
									ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder, connhost.trim(),
									validationHostEmpty);

							cp.validatAndeEnterValueToTextField(connPortTitle, connPortInputField,
									ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder, connport.trim(),
									validationPortEmpty);

							cp.validatAndeEnterValueToTextField(connDatabaseTitle, connDatabaseInputField,
									ConstantProperty.CONN_FIELD_DATABASE, connDatabasePlaceholder, conndb.trim(),
									validationDatabaseEmpty);

						} else {

							cp.validatAndeEnterValueToTextField(connHostTitle, connHostInputField,
									ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder, connhostCloud.trim(),
									validationHostEmpty);

							if (BaseSuite.Sybasetype.equalsIgnoreCase("sybaseASE")) {

								cp.validatAndeEnterValueToTextField(connPortTitle, connPortInputField,
										ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder, portASE.trim(),
										validationPortEmpty);

							} else {
								cp.validatAndeEnterValueToTextField(connPortTitle, connPortInputField,
										ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder, portIQ.trim(),
										validationPortEmpty);

							}

							cp.validatAndeEnterValueToTextField(connDatabaseTitle, connDatabaseInputField,
									ConstantProperty.CONN_FIELD_DATABASE, connDatabasePlaceholder, conndb.trim(),
									validationDatabaseEmpty);
						}
					}
					cp.selectConnectionType(connParam.getType());
					if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

						cp.enterUsername(connusername.trim());

						cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
								connParam.getConnectorID(), icedqUser);

					} else {

						cp.validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME,
								connUsernamePlaceholder, false);
						cp.validateInputFieldVisibility(connsecretUserPassword, ConstantProperty.CONN_FIELD_PASSWORD,
								connPasswordPlaceholder, false);

					}

					break;

				default:

					BaseSuite.reportLog("Connector not found  :: " + connectorName);
					break;
				}

				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

				int count = connPropertyList.size();

				addConnectionPropertiesToConnection(connJsonEntity, count);

				clickOnOverviewTab();

				if (icedqUser.toLowerCase().contains("owner")) {

					flag = saveConnection(connectionSaveMesssage);

					clickOnConnectionsTab();

					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}

					cp.searchConnection(newconnectionName);

					cp.getConnection(newconnectionName, update_actualValue);

					searchAndClickOnConnectionNameInConnRepo(newconnectionName);

					if (flag || isEnabled(driver, connTestBtn)) {

						flag = cp.enterUsernameAndPasswordForUserConnection(connJsonEntity, connParam,
								connParam.getType(), newconnectionName, connusername, icedqUser);
					}
				} else {

					flag = saveConnection(forbiddenToastMsg);
				}
			}
		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not created properly kindly check :" + e.toString());
		}
		return flag;
	}

	/** View Sybase connection details method **/

	public boolean viewConnectionCommonMethod(String connJsonEntity, String driverName) {
		boolean flag = true;
		NewConnectionRepoPage np = new NewConnectionRepoPage(driver);
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {
			ConnectionPoJO connParam = np.setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);

			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			
			//Cloud Data
			
			String connhostCloud = cp.getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 18);

			String connportCloud = cp.getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 19);

			String[] port = connportCloud.split("-");

			String portASE = port[0];

			String portIQ = port[1];

			String fulurlCloud = cp.getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 21);

			String[] JDBCURL = fulurlCloud.split("-");

			String JDBCURLASE = JDBCURL[0];

			String JDBCURLIQ = JDBCURL[1];	
			
			//OnPrem Data
			
			String connhost = cp.getConnectionDetailsUsingAuthType(BaseSuite.Sybasetype, 18);

			String connectorName = setConnectorIdToConnectorName(connParam.getConnectorID());

			String connport = np.getConnectionDetailsUsingAuthType(BaseSuite.Sybasetype, 19);

			String conndb = np.getConnectionDetailsUsingAuthType(BaseSuite.Sybasetype, 20);

			String sybaseJDBCURL = np.getConnectionDetailsUsingAuthType(BaseSuite.Sybasetype, 21);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				inVisible(driver, spinner, Constant.ruleWait);

				cp.viewAndValidateConnectionField(connName, "Connection Name", connParam.getConnName(), true);
				
				Thread.sleep(1000);

				np.selectDriverOfFlatFileNativeConnection(connParam.getDriverName());
				
				String authName = cp.setAuthenticationType(connParam.getAuthentication());

				np.viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
						authName, true);

				verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

				if (connParam.getCustomJdbcFullUrl().equalsIgnoreCase(booleanTrue)) {
					if (connectorName.contains("Oracle")) {

						np.viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
								connParam.getCustomJDBCURLValue(), true);

					} else {
						if((BaseSuite.baseURL.contains("onprem")
								|| BaseSuite.baseURL.contains("https://192.168.100."))) {
							np.viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box", sybaseJDBCURL,
									true);
						}else {
							
							if (BaseSuite.Sybasetype.equalsIgnoreCase("sybaseASE")) {

								np.viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box", JDBCURLASE,
										true);

							} else {
								
								np.viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box", JDBCURLIQ,
										true);
							}
						}
					}
					np.viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST, "", false);

					np.viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT, "", false);

					np.viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE, "",
							false);

				} else if (connectorName.contains("Oracle")) {

					np.viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
							connParam.getCustomJDBCURLValue(), false);

					np.viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
							connParam.getHost(), true);

					np.viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
							connParam.getPort(), true);

					np.viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
							connParam.getDatabaseName(), true);
					
				} else if (connectorName.contains("Sybase")) {

					np.viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
							connParam.getCustomJDBCURLValue(), false);
					
					if ((BaseSuite.baseURL.contains("onprem")
							|| BaseSuite.baseURL.contains("https://192.168.100."))) {

					np.viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
							connhost.trim(), true);

					np.viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT, connport,
							true);

					np.viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
							conndb, true);
					}else {
						
						np.viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
								connhostCloud.trim(), true);

					if (BaseSuite.Sybasetype.equalsIgnoreCase("sybaseASE")) {

						np.viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
								portASE.trim(), true);

					} else {
						np.viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
								portIQ.trim(), true);

					}

					np.viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
							conndb.trim(), true);
				}
				}
                cp.validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", true);
				
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				
				waitForExecution(1000);
				
			//	cp.verifyVisibilityOfButtons(driver, connsecretManagebtn, "Manage Button", true);
				
			//    cp.verifyVisibilityOfButtons(driver, connsecretQuickAddbtn, "Quick Add Button", true);

				np.validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "", true);

				np.validateInputFieldVisibility(connsecretPasswordfeild, ConstantProperty.CONN_FIELD_PASSWORD, "", true);

				ArrayList<String> connPropertyList = TestDataThroughApi
						.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

				int count = connPropertyList.size();

				flag = viewAndValidateConnectionPropertiesToConnection(connJsonEntity, count);

			} else {

				inVisible(driver, spinner, Constant.ruleWait);
				
				validateButtons(driver, cp.connDatabricksBtn, 3);

				np.viewAndValidateConnectionField(connName, "Connection Name", connParam.getConnName(), false);

				np.viewAndValidateConnectionField(connFlatFileDriverField, "Driver", connParam.getDriverName(), false);

				np.viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
						connParam.getAuthenticationname(), false);

				verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

				if (connParam.getCustomJdbcFullUrl().equalsIgnoreCase(booleanTrue)) {

					if (connectorName.contains("Oracle")) {

						np.viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box",
								connParam.getCustomJDBCURLValue(), false);

					} else {
						if((BaseSuite.baseURL.contains("onprem")
								|| BaseSuite.baseURL.contains("https://192.168.100."))) {
							np.viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box", sybaseJDBCURL,
									false);
						}else {
							
							if (BaseSuite.Sybasetype.equalsIgnoreCase("sybaseASE")) {

								np.viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box", JDBCURLASE,
										false);

							} else {
								
								np.viewAndValidateConnectionField(connCustomJDBCTextbox, "Custom JDBC Text box", JDBCURLIQ,
										false);
							}
						}
					}

				}

				else if (connectorName.contains("Oracle")) {

					np.viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
							connParam.getHost(), false);

					np.viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
							connParam.getPort(), false);

					np.viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
							connParam.getDatabaseName(), false);

				} else if (connectorName.contains("Sybase")) {
					
					if ((BaseSuite.baseURL.contains("onprem")
							|| BaseSuite.baseURL.contains("https://192.168.100."))) {

					np.viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
							connhost.trim(), false);

					np.viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT, connport,
							false);

					np.viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
							conndb, false);
					}else {
						
						np.viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
								connhostCloud.trim(), false);

					if (BaseSuite.Sybasetype.equalsIgnoreCase("sybaseASE")) {

						np.viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_PORT,
								portASE.trim(), false);

					} else {
						np.viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_PORT,
								portIQ.trim(), false);

					}

					np.viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
							conndb.trim(), false);
				}
				}
				
                validateInputFieldVisibility(connsecretName, ConstantProperty.CONN_FIELD_SECRETNAME, "", true);
				
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				
				waitForExecution(1000);
				
			//	verifyVisibilityOfButtons(driver, connsecretManagebtn, "Manage Button", true);
				
			//    verifyVisibilityOfButtons(driver, connsecretQuickAddbtn, "Quick Add Button", true);

				np.validateInputFieldVisibility(connUsernameInput, ConstantProperty.CONN_FIELD_USERNAME, "", true);

				np.validateInputFieldVisibility(connsecretPasswordfeild, ConstantProperty.CONN_FIELD_PASSWORD, "", true);

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

	/** Test Sybase connection common method **/

	@SuppressWarnings("static-access")
	public boolean testConnectionCommonMethod(String connJsonEntity, String driverName, String icedqUser) {
		boolean flag = false;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {
			
			
			
			String connusername = null;
			String connpassword = null;
			
			
			
			ConnectionPoJO connParam = cp.setConnectionParametersForApi(connJsonEntity);

			String connectorName = setConnectorIdToConnectorName(connParam.getConnectorID());

			inVisible(driver, spinner, Constant.ruleWait);
			Thread.sleep(1000);
			
			if (connectorName.contains("Oracle")) {
				
				connusername =cp.getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

				connpassword =cp.getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 2);

				
			} else if(connectorName.contains("Sybase")) {
				
				connusername = cp.getConnectionDetailsUsingAuthType(BaseSuite.Sybasetype, 1);

				//connpassword = cp.getConnectionDetailsUsingAuthType(BaseSuite.Sybasetype, 2);

			}

			
			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

				//viewConnectionCommonMethod(connJsonEntity, driverName);
				
				
				if (!icedqUser.contains("reader")) {
					Thread.sleep(1000);
					flag = cp.testConnection(connectionTestMess);

				} else {
					Thread.sleep(1000);
					flag = cp.testConnection(forbiddenToastMsg);
				}
			} else {

				if (!icedqUser.contains("reader")) {

					cp.enterUsername(connusername);

					cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),
							connParam.getConnectorID(), icedqUser);

					cp.waitForExecution(1000);

					cp.saveConnection();
					Thread.sleep(1000);
					flag = cp.testConnection(connectionTestMess);

				} else {

					flag =clickQuickAddbtn(forbiddenToastMsg);
				}
			}

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not deleted properly kindly check :" + e.toString());

		}

		return flag;
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
	
	
	
	/** Update Sybase connection common method **/

	@SuppressWarnings("static-access")
	public boolean updateConnectionCommonMethod(String connJsonEntity, String driverName, String testScenario,
			String validationMessage, String icedqUser) {
		boolean flag = true;
		boolean stop = true;
		String newconnectionName = null;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		NewConnectionRepoPage np = new NewConnectionRepoPage(driver);
		try {
			
			String connusername = null;
			String connpassword = null;

			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			String connectorName = setConnectorIdToConnectorName(connParam.getConnectorID());

			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE+ ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";

			if (connectorName.contains("Oracle")) {

				connusername = cp.getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 1);

				connpassword = cp.getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 2);
				
				String connprincipal = getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 21);

			} else if (connectorName.contains("Sybase")) {

				connusername = cp.getConnectionDetailsUsingAuthType(BaseSuite.Sybasetype, 1);

				connpassword = cp.getConnectionDetailsUsingAuthType(BaseSuite.Sybasetype, 2);

			}
			//cloud data
			String connhostCloud = cp.getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 18);

			String connportCloud = cp.getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 19);

			String[] port = connportCloud.split("-");

			String portASE = port[0];

			String portIQ = port[1];

			String fulurlCloud = cp.getConnectionDetailsUsingAuthType(connParam.getConnectorID(), 21);

			String[] JDBCURL = fulurlCloud.split("-");

			String JDBCURLASE = JDBCURL[0];

			String JDBCURLIQ = JDBCURL[1];

			//onprem data
			String connhost = cp.getConnectionDetailsUsingAuthType(BaseSuite.Sybasetype, 18);
			
			String connport = np.getConnectionDetailsUsingAuthType(BaseSuite.Sybasetype, 19);

			String conndb = np.getConnectionDetailsUsingAuthType(BaseSuite.Sybasetype, 20);
			
			String fulurl = np.getConnectionDetailsUsingAuthType(BaseSuite.Sybasetype, 21);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {

			} else {

				String connName;
				waitForExecution(3000);
				clickOnConnectionsTab();
				if ((!icedqUser.contains("owner"))) {
					connName = newconnectionName;
				} else {
					connName = connParam.getConnName() + "_" + BaseSuite.WorkspaceName;
				}
				searchAndClickOnConnectionNameInConnRepo(connName);
			}
			inVisible(driver, spinner, Constant.ruleWait);

			String wizardStatus = cp.validateExistingConnPageButtonsFields(connJsonEntity);
			
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
			
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

			cp.enterConnectionNameWithValidation(newconnectionName, testScenario, validationMessage);

			cp.selectDriverOfFlatFileNativeConnection(connParam.getDriverName());

			cp.viewAndValidateConnectionField(connAuthTypeField, ConstantProperty.CONN_FIELD_AUTHENTICATION,
					connParam.getAuthentication(), true);

			String authName = cp.setAuthenticationType(connParam.getAuthentication());

			selectAuthenticationOfConnection(authName);

			verifyCustomJDBCURLCheckboxOfConnection(connParam.getCustomJdbcFullUrl());

			selectCustomJDBCURLOfConnection(connParam.getCustomJdbcFullUrl());

			if ((BaseSuite.baseURL.contains("onprem")
					|| BaseSuite.baseURL.contains("https://192.168.100."))) {

			enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), fulurl);
			
			}else {
				
				if (BaseSuite.Sybasetype.equalsIgnoreCase("sybaseASE")) {

					enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), JDBCURLASE);

				} else {
					
					enterCustomJDBCURL(connParam.getCustomJdbcFullUrl(), JDBCURLIQ);
				}
			}

			if (connParam.getCustomJdbcFullUrl().equalsIgnoreCase(booleanTrue)) {

				cp.validateInputFieldVisibility(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
						connHostPlaceholder, false);
				cp.validateInputFieldVisibility(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
						connPortPlaceholder, false);
				cp.validateInputFieldVisibility(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE,
						connDatabasePlaceHolder, false);

			} else {

				if ((BaseSuite.baseURL.contains("onprem") || BaseSuite.baseURL.contains("https://192.168.100."))) {

					cp.viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
							connhost.trim(), true);
					cp.validatAndeEnterValueToTextField(connHostTitle, connHostInputField,
							ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder, connParam.getHost(),
							validationHostEmpty);

					cp.viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT, connport,
							true);
					cp.validatAndeEnterValueToTextField(connPortTitle, connPortInputField,
							ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder, connport, validationPortEmpty);

				} else {

					cp.viewAndValidateConnectionField(connHostInputField, ConstantProperty.CONN_FIELD_HOST,
							connhostCloud.trim(), true);
					cp.validatAndeEnterValueToTextField(connHostTitle, connHostInputField,
							ConstantProperty.CONN_FIELD_HOST, connHostPlaceholder, connhostCloud.trim(),
							validationHostEmpty);

					if (BaseSuite.Sybasetype.equalsIgnoreCase("sybaseASE")) {

						cp.viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
								portASE.trim(), true);

						cp.validatAndeEnterValueToTextField(connPortTitle, connPortInputField,
								ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder, portASE.trim(),
								validationPortEmpty);

					} else {

						cp.viewAndValidateConnectionField(connPortInputField, ConstantProperty.CONN_FIELD_PORT,
								portIQ.trim(), true);

						cp.validatAndeEnterValueToTextField(connPortTitle, connPortInputField,
								ConstantProperty.CONN_FIELD_PORT, connPortPlaceholder, portIQ.trim(),
								validationPortEmpty);

					}

				}

				cp.viewAndValidateConnectionField(connDatabaseInputField, ConstantProperty.CONN_FIELD_DATABASE, conndb,
						true);
				cp.validatAndeEnterValueToTextField(connDatabaseTitle, connDatabaseInputField,
						ConstantProperty.CONN_FIELD_DATABASE, connDatabasePlaceholder, conndb, validationDatabaseEmpty);
			}

			cp.selectConnectionType(chooseConnType, connParam.getType());

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE)) {
				
					if (isDisplayed(driver, connvaultOnOffLabel)) {

						BaseSuite.validationReportLog("Enable Vault Label shows Clearly");

						click(driver, connvaultOnOff);

						BaseSuite.validationReportLog("Enable Vault Checkbox Clicked Successfully");

						cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),connParam.getConnectorID(), icedqUser);

					} else {
						cp.entersecretPassword(connJsonEntity, connParam.getAuthenticationname(),connParam.getConnectorID(), icedqUser);

						enterUsername(connusername);

					}
				}
			 else {
				 	if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

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
			
			ArrayList<String> connPropertyList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, connConnectionPropNames);

			int count = connPropertyList.size();
			
			if ((connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_SYSTETYPE))) {
				
				updateConnectionPropertiesToConnection(connJsonEntity, count);
				
				clickOnOverviewTab();
				
				saveConnection();
				
				
			} else {
				
				saveConnection();
				
				cp.updateUserConnectionPropertiesToConnection(connJsonEntity, count,ConstantProperty.ICEDQ_WORKSPACE_OWNERUSER);
			}
			
			cp.updateUsernameAndPasswordForUserConnection(connJsonEntity, connParam,connParam.getType(), connusername, icedqUser);
		

		} catch (Exception e) {
			flag = false;
			Thread.currentThread().interrupt();
			BaseSuite.reportErrorLog("Database connection not created properly kindly check :" + e.toString());
		}
		return flag;
	}

	/** Duplicate Sybase connection using API test data **/
	public boolean duplicateConnectionCommonMethod(String connJsonEntity, String driverName, String icedqUser) {
		boolean flag = false;
		String name = null;
		String newconnectionName = null;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);

			inVisible(driver, spinner, Constant.ruleWait);
			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE + ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";
		//	viewConnectionCommonMethod(connJsonEntity, driverName);

			Thread.sleep(3000);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {

				cp.clickOnConnectionsTab();
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

				flag = clickOnDuplicateConnection(connDupllicateToastMsg);

				inVisible(driver, spinner, Constant.ruleWait);

				if (flag) {
					name = getAttribute(driver, connName, valueAttribute);
					Thread.sleep(3000);

					cp.clickOnConnectionsTab();
					isDisplayedInLoop(driver, 0, discardButtons);
					if (isDisplayed(driver, discardButtons)) {
						displayAndClick(driver, discardButtons);
					}
					Thread.sleep(2000);
					flag = cp.searchConnection(name);
				}
			} else {
				flag = cp.clickOnDuplicateConnection(forbiddenToastMsg);
			}

		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog(
					"due to exception while duplicate Database Connection kindly check " + e.toString());
			Thread.currentThread().interrupt();
		}
		return flag;
	}

	/** Delete Sybase connection common method **/

	public boolean deleteConnectionCommonMethod(String connJsonEntity, String driverName, String icedqUser) {
		boolean flag = true;
		String newconnectionName=null;
		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		try {
			
			ConnectionPoJO connParam = setConnectionParametersForApi(connJsonEntity);
				
			newconnectionName = connParam.getConnName() + ConstantProperty.SIGN_UNDERSCORE + ConstantProperty.TARGET_WORKSPACE_NAME + ConstantProperty.SIGN_UNDERSCORE + "vault";
			
			//viewConnectionCommonMethod(connJsonEntity, driverName);

			inVisible(driver, spinner, Constant.ruleWait);

			Thread.sleep(3000);

			if (connParam.getType().equalsIgnoreCase(ConstantProperty.CONN_USERTYPE)) {
				
				clickOnConnectionsTab();

				searchAndClickOnConnectionNameInConnRepo(newconnectionName);

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

	/*
	 * long start = System.currentTimeMillis();
	 * 
	 * driver.get("Some url");
	 * 
	 * WebElement ele =
	 * driver.findElement(By.id("ID of some element on the page which will load"));
	 * long finish = System.currentTimeMillis(); long totalTime = finish - start;
	 */
	
	
	

	
	
	
}