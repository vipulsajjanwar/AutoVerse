package nexgen.automation.framework.connectionRepo;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.antlr.grammar.v3.ANTLRParser.throwsSpec_return;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.python.modules.thread.thread;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;
import nextgen.automation.RuleRepo.pages.TestDataThroughApi;

public class ConnectionPageNeha extends PageUtil 
{
	WebDriver driver;

	public ConnectionPageNeha(WebDriver driver)
	{
		this.driver= driver;
	}
	XLUtils xlReader = new XLUtils();
	SoftAssert soft = new SoftAssert();


	/************************************************************************UI elements**************************************************************************/	

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
	By connTypeList=getElementLocator(prop.getProperty("conn.typeOfConn.dropdownlist"));
	By connTypeListpane=getElementLocator(prop.getProperty("conn.typeOfConn.dropdownlist.pane"));
	By connUsernameInput=getElementLocator(prop.getProperty("conn.Username.input"));
	By connUsernameLabel=getElementLocator(prop.getProperty("conn.Username.Label"));
	By connUsernameErrormsg=getElementLocator(prop.getProperty("conn.Username.errorMsg"));
	By connPasswordLabel=getElementLocator(prop.getProperty("conn.Password.Label"));
	By connPasswordInput=getElementLocator(prop.getProperty("conn.Password.input"));
	By connPropertiesTab=getElementLocator(prop.getProperty("conn.propetiesSection.tab"));
	By connOverviewTab=getElementLocator(prop.getProperty("conn.OverviewSection.tab"));
	By addpropertyNameInput=getElementLocator(prop.getProperty("Connection.AddPropertyName"));
	By addpropertyValueInput=getElementLocator(prop.getProperty("Connection.AddPropertyValue"));
	By addpropertyButton=getElementLocator(prop.getProperty("conn.property.addProperty.btn"));
	By removePropertyButton=getElementLocator(prop.getProperty("conn.property.removeProp.btn"));
	By clickOnPropertyTypeDropdown=getElementLocator(prop.getProperty("Connection.AddPropertyTypeClick"));
	By newPropertySaveButton=getElementLocator(prop.getProperty("conn.Add.newproperty.save.btn"));
	By newPropertyCancelButton=getElementLocator(prop.getProperty("conn.Cancel.newproperty.save.btn"));	
	By connName = getElementLocator(prop.getProperty("ConnectionB.connectionName"));



	/*********************************************** String elements ******************************************************/

	String editBtnwrtPropName=prop.getProperty("conn.property.usingname.Edit.btn");
	String connPropertyType=prop.getProperty("Connection.AddPropertyType");
	String existingPropertySaveButton=prop.getProperty("conn.existingProperty.save.btn");
	String existingPropertyCancelButton=prop.getProperty("conn.existingProperty.Cancel.btn");
	String valueAttribute=prop.getProperty("Attribute.value");
	public String strDBConnectionType=prop.getProperty("conn.testdata.dbConnectorType");
	String addPropertyType = prop.getProperty("Connection.AddPropertyType");

	//verify placeholder in input box

	public boolean verifyplaceholder(By locator,String expected) 
	{
		boolean status=false;
		if(isDisplayed(driver, locator))
		{
			String holder= getAttribute(driver, locator, "placeholder");

			if(holder.equalsIgnoreCase(expected))
			{
				status= true;
			}else
			{
				status=false;
			}
		}
		else
		{
			BaseSuite.reportErrorLog("Unable to locate locator :: "+locator);
		}

		return status;

	}

	//method to validate & enter VALID data in accesIdentifier

	public void enterAccountIdentifier(String value) throws Exception
	{
		try {

			boolean flag=false;

			javascript(driver,"arguments[0].scrollIntoView(true);", accountIdentifierInput);

			if(isDisplayed(driver, accountIdentifierInput))
			{
				BaseSuite.reportLog("Account identifier field is displayed.");

				if(isEnabled(driver, accountIdentifierInput))
				{			
					if(isEditable(driver, accountIdentifierInput,"access identifier" ))
					{
						clear(driver, accountIdentifierInput);

						BaseSuite.reportLog("Verify placeholder is present in input box.");

						flag=verifyplaceholder(accountIdentifierInput,"Enter identifier");

						if(flag)
						{
							BaseSuite.validationReportLog("correct placeholder is displayed in account identifier input box.");
						}
						else
						{
							BaseSuite.reportFailLog("Expected placeholder didnt matched with actual placeholder, kindly check.", "enterAccountIdentifier");
						}

						BaseSuite.reportLog("Entering account identifier value  :: "+value.trim());

						sendKeys(driver, accountIdentifierInput, value.trim());

						isDisplayedInLoop(driver, 1, accountIdentifierInput);

						String accountidentifier= getAttribute(driver, accountIdentifierInput,"value").trim();

						compareActualNExpectedValue(accountidentifier.trim(),value.trim());								
					}		
				}
				else
				{
					BaseSuite.reportFailLog("Account identifier input is disabled, kindly check.", "enterAccountIdentifier");					
				}
			}
			else
			{
				BaseSuite.reportFailLog("Unable to locate account identifier field on current page, kindly check.", "enterAccessIdentifier");
			}

			BaseSuite.reportLog("Verifing account identifier field title/label is displayed or not.");

			verifyIndividualLabel(driver, accountIdentifierLabel, "account identifier");


		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}


	}

	//Method to validate Warehouse field & enter VALID data in it.
	public void enterWarehouse(String value)throws Exception
	{
		boolean flag=false;
		try {
			javascript(driver,"arguments[0].scrollIntoView(true);", connWarehouseInput);

			if(isDisplayed(driver, connWarehouseInput))
			{
				BaseSuite.reportLog("Warehouse field is displayed.");

				if(isEnabled(driver, connWarehouseInput))
				{			
					if(isEditable(driver, connWarehouseInput,"warehouse" ))
					{
						clear(driver, connWarehouseInput);

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag=verifyplaceholder(connWarehouseInput,"Enter warehouse");

						if(flag)
						{
							BaseSuite.validationReportLog("correct placeholder is displayed in warehouse input box.");
						}
						else
						{
							BaseSuite.reportFailLog("Expected placeholder didnt matched with actual placeholder, kindly check.", "enterWarehouse");
						}

						BaseSuite.reportLog("Entering warehouse value  :: "+value.trim());

						sendKeys(driver, connWarehouseInput, value.trim());

						isDisplayedInLoop(driver, 1, connWarehouseInput);

						String warehouse= getAttribute(driver, connWarehouseInput,"value").trim();

						compareActualNExpectedValue(warehouse.trim(),value.trim());											
					}		
				}
				else
				{
					BaseSuite.reportFailLog("Warehouse input is disabled, kindly check.", "enterWarehouse");					
				}
			}
			else
			{
				BaseSuite.reportFailLog("Unable to locate warehouse field on current page, kindly check.", "enterWarehouse");
			}

			BaseSuite.reportLog("Verifing warehouse field title/label is displayed or not.");

			verifyIndividualLabel(driver, connWarehouseLabel, "Warehouse");


		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	//Method to validate Warehouse field & enter VALID data in it.
	public void enterDatabase(String value)throws Exception
	{
		boolean flag=false;
		try {
			javascript(driver,"arguments[0].scrollIntoView(true);", connDatabaseInput);

			if(isDisplayed(driver, connDatabaseInput))
			{
				BaseSuite.reportLog("Database field is displayed.");

				if(isEnabled(driver, connDatabaseInput))
				{			
					if(isEditable(driver, connDatabaseInput,"database" ))
					{
						clear(driver, connDatabaseInput);

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag=verifyplaceholder(connDatabaseInput,"Enter database");

						if(flag)
						{
							BaseSuite.validationReportLog("correct placeholder is displayed in database input box.");
						}
						else
						{
							BaseSuite.reportFailLog("Expected placeholder didnt matched with actual placeholder, kindly check.", "enterDatabase");
						}

						BaseSuite.reportLog("Entering database value  :: "+value.trim());

						sendKeys(driver, connDatabaseInput, value.trim());

						isDisplayedInLoop(driver, 1, connDatabaseInput);

						String database= getAttribute(driver, connDatabaseInput,"value").trim();

						compareActualNExpectedValue(database.trim(), value.trim());									
					}		
				}
				else
				{
					BaseSuite.reportFailLog("Database input is disabled, kindly check.", "enterDatabase");					
				}
			}
			else
			{
				BaseSuite.reportFailLog("Unable to locate database field on current page, kindly check.", "enterDatabase");
			}

			BaseSuite.reportLog("Verifing database field title/label is displayed or not.");

			verifyIndividualLabel(driver, connDatabaseLabel, "Database");


		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	//method to validate connection type dropdown & select one value
	public void selectConnectionType(String value) throws Exception
	{
		try {

			javascript(driver,"arguments[0].scrollIntoView(true);", connTypeSelectionDropdown);

			if(isDisplayed(driver, connTypeSelectionDropdown))
			{
				BaseSuite.reportLog("Connection type dropdown is displayed.");

				if(isClickable(driver, connTypeSelectionDropdown, "type dropdown", true))
				{
					click(driver, connTypeSelectionDropdown);

					if(isDisplayed(driver,connTypeListpane))
					{
						BaseSuite.reportLog("Type list options are displayed");

						List <WebElement> typeList = getElements(driver, connTypeList);

						BaseSuite.reportLog("List has "+typeList.size()+ "options as:");

						selectConnectionTypeForConn(typeList,value);
					}
				}
				else
				{
					BaseSuite.reportFailLog("Connection type dropdown is not clickable,kindly check.", "selectConnectionType");
				}

			}else
			{
				BaseSuite.reportFailLog("Unable to located type dropdown, kindly check.", "selectConnectionType");
			}



		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}
	
	//method to
	public void selectConnectionTypeForConn(List <WebElement> typeList,String value) throws Exception
	{
		try {
			
			int a=1;
			for(int i=0;i<typeList.size();i++)
			{
				String label= typeList.get(i).getAttribute("data-value");

				if((label.equalsIgnoreCase("System"))||(label.equalsIgnoreCase("User")))
				{
					BaseSuite.validationReportLog(a+"- "+label);
					a++;
				}

			}
			Thread.sleep(1000);
			for(int i=0;i<typeList.size();i++)
			{
				String label= typeList.get(i).getAttribute("data-value");
				if(label.equalsIgnoreCase(value))
				{
					typeList.get(i).click();
					BaseSuite.validationReportLog("Connection type : "+value+" selected successfully.");
					break;
				}
			}							

			if(typeList.size()>2)
			{
				BaseSuite.reportFailLog("Type dropdown must contains 2 values only, it has "+typeList.size()+", kindly check.", value);
			}
		
	} catch (Exception e) {
		e.getMessage();
		throw new Exception();
	}
		
		
		
	}

	//Method to validate & enter Username
	public void enterUsername(String value) throws Exception
	{
		boolean flag=false;
		try {
			javascript(driver,"arguments[0].scrollIntoView(true);", connUsernameInput);

			if(isDisplayed(driver, connUsernameInput))				
			{
				BaseSuite.reportLog("Username field is displayed.");

				if(isEnabled(driver, connUsernameInput))
				{
					if(isEditable(driver, connUsernameInput, "username"))
					{
						clear(driver, connUsernameInput);

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag=verifyplaceholder(connUsernameInput,"Enter username");

						if(flag)
						{
							BaseSuite.validationReportLog("correct placeholder is displayed in database input box.");
						}
						else
						{
							BaseSuite.reportFailLog("Expected placeholder didnt matched with actual placeholder, kindly check.", "enterUsername");
						}

						sendKeys(driver, connUsernameInput, value.trim());

						isDisplayedInLoop(driver, 1, connUsernameInput);

						String username= getAttribute(driver, connUsernameInput,"value").trim();

						compareActualNExpectedValue(username.trim(), value.trim());			

					}


				}else
				{
					BaseSuite.reportFailLog("Username input is disabled, kindly check.", "enterUsername");	
				}

			}else
			{
				BaseSuite.reportFailLog("Unable to locate username field on current page, kindly check.", "enterUsername");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}


	//Method to validate & enter Username
	public void enterPassword(String value) throws Exception
	{
		boolean flag=false;
		try {
			javascript(driver,"arguments[0].scrollIntoView(true);", connPasswordInput);

			if(isDisplayed(driver, connPasswordInput))
			{
				BaseSuite.reportLog("Password field is displayed.");

				if(isEnabled(driver, connPasswordInput))
				{
					if(isEditable(driver, connPasswordInput, "password"))
					{
						clear(driver, connPasswordInput);

						BaseSuite.reportLog("Verify placeholder is present in the input box.");

						flag=verifyplaceholder(connPasswordInput,"Enter password");

						if(flag)
						{
							BaseSuite.validationReportLog("correct placeholder is displayed in database input box.");
						}
						else
						{
							BaseSuite.reportFailLog("Expected placeholder didnt matched with actual placeholder, kindly check.", "enterPassword");
						}

						sendKeys(driver, connPasswordInput, value.trim());

						BaseSuite.validationReportLog("Entered password in password field.");							
					}


				}else
				{
					BaseSuite.reportFailLog("Password input is disabled, kindly check.", "enterPassword");
				}

			}else
			{
				BaseSuite.reportFailLog("Unable to locate password field on current page, kindly check.", "enterPassword");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// click on properties tab	 
	public void clickOnPropertiesTab() throws Exception
	{
		try {
			if(isDisplayed(driver, connPropertiesTab))
			{
				if(isClickable(driver, connPropertiesTab, "properties", true))
				{

					BaseSuite.reportLog("Clicking on properties tab on connection page.");

					click(driver, connPropertiesTab);

					BaseSuite.validationReportLog("Clicked successfully on properties tab");

				}
				else
				{
					BaseSuite.reportFailLog("Properties tab is not clickable, kindly check..", "clickOnPropertiesTab");
				}
			}else
			{
				BaseSuite.reportErrorLog("Unable to locate properties tab on connection page, kindly check.");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	// click on overview tab	
	public void clickOnOverviewTab() throws Exception
	{
		try {
			if(isDisplayed(driver, connOverviewTab))
			{
				if(isClickable(driver, connOverviewTab, "properties", true))
				{

					BaseSuite.reportLog("Clicking on overview tab on connection page.");

					click(driver, connOverviewTab);

					BaseSuite.validationReportLog("Clicked successfully on overview tab");

				}
				else
				{
					BaseSuite.reportFailLog("Overview tab is not clickable, kindly check..", "clickOnPropertiesTab");
				}
			}else
			{
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

			if(isDisplayed(driver, returnElement(editBtnwrtPropName, "$propName", propertyName.trim())))
			{
				BaseSuite.reportLog("Edit button for property :: "+propertyName+" is displayed.");

				if(isClickable(driver, returnElement(editBtnwrtPropName, "$propName", propertyName.trim()), "property edit", true))
				{
					displayAndClick(driver, returnElement(editBtnwrtPropName, "$propName", propertyName.trim()));

					BaseSuite.validationReportLog("Successfully clicked on edit button.");
				}
				else {
					BaseSuite.reportFailLog("Unable to click on property edit button :: "+propertyName, "clickOnEditButtonfromConnProperty");

				}	

			}else
			{
				BaseSuite.reportFailLog("Unable to find the property name :: "+propertyName, "clickOnEditButtonfromConnProperty");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}


	//method will enter property name
	public void addConnectionPropertyName(String name) throws Exception
	{
		try {
			if(isDisplayed(driver, addpropertyNameInput))
			{
				BaseSuite.reportLog("Property name input box is displayed.");

				if(!name.isEmpty())
				{

					clear_Click_SendKeys(driver, 1, addpropertyNameInput, name);

					BaseSuite.reportLog(name+" is entered in to property name");
				}
				else
				{
					BaseSuite.reportErrorLog("Property value parameter is empty, kindly check.");
				}

			}else
			{
				BaseSuite.reportFailLog("Unable to locate property name input field , kindly check.", "addConnectionPropertyName");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	//method will enter value 
	public void addConnectionPropertyValue(String value) throws Exception
	{
		try {
			if(isDisplayed(driver, addpropertyValueInput))
			{
				BaseSuite.reportLog("Property value input box is displayed.");

				if(!value.isEmpty())
				{
					clear_Click_SendKeys(driver, 1, addpropertyValueInput, value.trim());

					BaseSuite.reportLog(value+" is entered in to property value");
				}
				else
				{
					BaseSuite.reportErrorLog("Property value parameter is empty, kindly check.");
				}



			}else
			{
				BaseSuite.reportFailLog("Unable to locate property name input field , kindly check.", "addConnectionPropertyName");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	//method will select property type from dropdown
	public void selectConnectionPropertyType(String type) throws Exception
	{
		try {

			if(isDisplayed(driver, clickOnPropertyTypeDropdown))
			{
				BaseSuite.reportLog("Property type dropdown is displayed.");

				if(isClickable(driver, clickOnPropertyTypeDropdown, "property type", true))
				{
					click(driver, clickOnPropertyTypeDropdown);

					BaseSuite.validationReportLog("Clicked on property type dropdown.");

					isDisplayedInLoop(driver, 3, returnElement(connPropertyType, "$name", type.trim()));

					displayAndClick(driver,  returnElement(connPropertyType, "$name", type.trim()));

					BaseSuite.validationReportLog("Property Type selected successfully");
				}
				else
				{
					BaseSuite.reportFailLog("Property type dropdown is not clickable, kindly check.", "selectConnectionPropertyType");
				}

			}else
			{

			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	//method will click on remove property button
	//method will click on remove
	public void clickOnRemovePropertybutton() throws Exception
	{
		try {

			if(isDisplayed(driver,removePropertyButton))
			{
				BaseSuite.reportLog("Remove property button is displayed.");
				if(isEnabled(driver, removePropertyButton))
				{
					BaseSuite.validationReportLog("Remove button is enabled on page.");

					if(isClickable(driver, removePropertyButton, "remove property", true))
					{
						click(driver, removePropertyButton);

						BaseSuite.validationReportLog("successfully clicked on remove property button.");
					}
				}
				else
				{
					BaseSuite.reportFailLog("Remove property button is disabled, kindly check.", "clickOnRemovePropertybutton");
				}
			}
			else
			{
				BaseSuite.reportFailLog("Unable to locate remove property button, kindly check.", "clickOnRemovePropertybutton");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new AssertionError();
		}
	}


	//method will click on Add property button
	//method will click on add property button
	public void clickOnAddPropertybutton() throws Exception
	{
		try {


			if(isDisplayed(driver,addpropertyButton))
			{
				BaseSuite.reportLog("Add property button is displayed.");
				if(isEnabled(driver, addpropertyButton))
				{
					BaseSuite.validationReportLog("Add button is enabled on page.");

					if(isClickable(driver, addpropertyButton, "remove property", true))
					{
						click(driver, addpropertyButton);

						BaseSuite.validationReportLog("successfully clicked on add property button.");
					}
				}
				else
				{
					BaseSuite.reportFailLog("Add property button is disabled, kindly check.", "clickOnRemovePropertybutton");
				}
			}
			else
			{
				BaseSuite.reportFailLog("Unable to locate add property button, kindly check.", "clickOnRemovePropertybutton");
			}


		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	//method will return timestamp 
	public String returnCurrentTimestap() throws Exception
	{
		try {

			String timeS=null;

			final SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			timeS= temp.format(timestamp);

			return timeS;

		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}

	}

	public void addTimeStampToConnectionName(String connectionName) throws Throwable
	{
		String connectionNameTime;
		try {

			isDisplayedInLoop(driver, 2, connName);

			String getTextC= getAttribute(driver, connName, valueAttribute);

			String upend=returnCurrentTimestap();

			if(connectionName.equalsIgnoreCase(getTextC))
			{
				connectionNameTime= getTextC+"_"+upend;

				clear_Click_SendKeys(driver, 1, connName, connectionNameTime);
			}
			else
			{
				BaseSuite.reportFailLog("Unable to match connection name entered with expected hence skipped adding timestamp to connection name.", upend);
			}


		} catch (Exception e) {
			e.getMessage();
			throw new Exception();
		}
	}

	By addConnProperty = getElementLocator(prop.getProperty("Connection.AddConnProperty"));
	By connectionProperties = getElementLocator(prop.getProperty("ConnectionB.ConnectionProperties"));
	By addPropertyName = getElementLocator(prop.getProperty("Connection.AddPropertyName"));
	By addPropertyValue = getElementLocator(prop.getProperty("Connection.AddPropertyValue"));
	By addPropertyTypeClick = getElementLocator(prop.getProperty("Connection.AddPropertyTypeClick"));
	By addPropertyDone = getElementLocator(prop.getProperty("Connection.AddPropertyDone"));
	By addPropertyCancel = getElementLocator(prop.getProperty("Connection.AddPropertyCancel"));




	public void enterConnPropertyName(String name)
	{
		try {

			javascript(driver,"arguments[0].scrollIntoView(true);", addPropertyName);

			if(!name.isEmpty())
			{
				if(isEnabled(driver, addPropertyName))
				{
					if(isClickable(driver, addPropertyName, "property name", true))
					{
						BaseSuite.reportLog("Entering property Name as "+name);

						clear_SendKeys(driver, addPropertyName, name);

						BaseSuite.validationReportLog("Poperty Name entered successfully");
					}
				}
				else
				{
					BaseSuite.reportErrorLog("Property name field is disabled, kindly check.");
				}
			}else
			{
				BaseSuite.reportErrorLog("Unable to proceed as property name is empty , kindly check.");
			}


		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void enterConnPropertyValue(String value)
	{
		try {

			isDisplayedInLoop(driver, 2, addPropertyValue);	

			if(!value.isEmpty())
			{
				if(isEnabled(driver, addPropertyValue))
				{
					if(isClickable(driver, addPropertyValue, "property value", true))
					{
						BaseSuite.reportLog("Entering property value as "+value);

						clear_SendKeys(driver, addPropertyValue, value);

						BaseSuite.validationReportLog("Property value entered successfully");
					}
				}
				else
				{
					BaseSuite.reportErrorLog("Property value field is disabled, kindly check.");
				}
			}
			else
			{
				BaseSuite.reportErrorLog("Unable to proceed as property value is empty , kindly check.");
			}


		} catch (Exception e) {
			e.getMessage();
		}

	}
	String attributeTextContent=prop.getProperty("Atribute.textContent");
	By propTypeListPane=getElementLocator(prop.getProperty("conn.ProPType.UiList"));
	By propListOptions=getElementLocator(prop.getProperty("conn.ProPType.listOfOption"));

	public void selectPropertyType(String type) { 

		try {
			isDisplayedInLoop(driver, 2, addPropertyTypeClick);

			if(!type.isEmpty())
			{
				if(isDisplayed(driver, addPropertyTypeClick))
				{
					if(isClickable(driver, addPropertyTypeClick, "property type", true))
					{
						//javascript(driver, "arguments[0].click();", addPropertyTypeClick);

						click(driver, addPropertyTypeClick);

						BaseSuite.reportLog("Clicked on property type dropdown");

						Thread.sleep(2000);

						if(isDisplayed(driver, propTypeListPane))
						{
							BaseSuite.reportLog("System & User options are displayed.");

							List <WebElement> typeList = getElements(driver, propListOptions);

							for(int i=0;i<typeList.size();i++)
							{
								String label= typeList.get(i).getAttribute("data-value");

								if(label.equalsIgnoreCase(type.trim()))
								{
									typeList.get(i).click();

									BaseSuite.reportLog(type+" is selected from type list.");
									break;
								}
							}

							String propType=getAttribute(driver, addPropertyTypeClick, attributeTextContent);

							stringContainsOutput(propType.trim(),type.trim(),true);

						}



					}
				}
				else
				{
					BaseSuite.reportErrorLog("Unable to locate property type, kindly check.");
				}


			}else
			{
				BaseSuite.reportErrorLog("Unable to proceed as property type is empty , kindly check.");
			}


		} catch (Exception e) {
			e.getMessage();
		}

	}


	public void clickonAddPropertyIconButton()
	{
		try {
			if(isDisplayed(driver, addPropertyDone))
			{
				if(isEnabled(driver, addPropertyDone))
				{
					if(isClickable(driver, addPropertyDone, "add property icon", true))
					{
						BaseSuite.reportLog("Clicking on add property icon  button");

						displayAndClick(driver, addPropertyDone);

						BaseSuite.validationReportLog("add property icon button clicked successfully.");
					}
					else
					{
						BaseSuite.reportFailLog("Add property icon button is not clickable, kindly check.", "clickonAddPropertyIconButton");
					}
				}else
				{
					BaseSuite.reportErrorLog("Add property icon button is disabled in UI , kindly check.");
				}

			}else
			{
				BaseSuite.reportErrorLog("Add property icon button is not displayed in UI , kindly check.");
			}



		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void addConnectionProperty(String name, String value, String type) {

		try {

			clickOnPropertiesTab();

			clickOnAddPropertybutton();

			enterConnPropertyName(name.trim());

			enterConnPropertyValue(value.trim());

			selectPropertyType(type.trim());

			clickonAddPropertyIconButton();

		} catch (Exception e) {

			e.getMessage();
		}

	}

	/********************************************************************* Connection Testcases Method *************************************************************************************/
	By toastMsg = getElementLocator(prop.getProperty("Commontoastmsg"));
	By ToastMsgClosedBtn = getElementLocator(prop.getProperty("ToastMsgClosedBtn"));
	By existingPropName = getElementLocator(prop.getProperty("conn.existingProp.check.Name"));
	By existingPropValue = getElementLocator(prop.getProperty("conn.existingProp.check.value"));
	By existingPropType = getElementLocator(prop.getProperty("conn.existingProp.check.type"));
	By existingPropCheckbox = getElementLocator(prop.getProperty("conn.existingProp.check.checkBox"));

	public String adminErrorMsg=prop.getProperty("conn.adminErrorMessage");



	public boolean verifyErrorMessageForAdmin(String errorMsg)
	{
		boolean flag=false;
		try {				
			flag =captureToastMsg(driver, toastMsg, ToastMsgClosedBtn, errorMsg, "privilege error");
		} catch (Exception e) {
			e.getMessage();
		}
		return flag;
	}

	//		ArrayList<String> connPropertyList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(connJsonEntity, "$.connectionProperties..name");
	//Method to view and check details of property pane.	
	public void verifyPropertyPane(String jsonEntity)
	{
		try {
			BaseSuite.reportLog("Verifying how many properties available in this connection.");

			ArrayList<String> pname = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,"$.connectionProperties..name");

			ArrayList<String> pvalue = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,"$.connectionProperties..value");

			ArrayList<String> ptype = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,"$.connectionProperties..type");

			List <WebElement> name= getElements(driver, existingPropName);

			int pCount= name.size();
			int count= pname.size();

			if(count==pCount)
			{
				BaseSuite.validationReportLog("This connection has connection properties i.e "+count+" are added and viewed.");
			}
			else
			{
				BaseSuite.reportFailLog("This connection has connection properties , but its count didnt matched. expected::"+count+" & actual ::"+pCount+".Kindly check.","verifyPropertyPane");
			}

			if(isDisplayed(driver, existingPropCheckbox))
			{
				BaseSuite.reportLog("Property check boxes are displayed.");

				if(!isClickable(driver, existingPropCheckbox, "property checkbox", true))
				{
					BaseSuite.reportFailLog("Checkboxes are not clickable, kindly check.", "verifyPropertyPane");
				}
			}

			for(int i=0;i<count;i++)
			{
				boolean status=verifyConnectionPropertyFields(pname.get(i),pvalue.get(i),ptype.get(i));

				if(!status)
				{
					BaseSuite.reportFailLog("Unable to match connection property details, kindly check.", "verifyPropertyPane");
				}
			}




		} catch (Exception e) {
			e.getMessage();
		}
	}

	public boolean verifyConnectionPropertyFields(String name,String value,String type)
	{
		boolean flag=false;
		try {
			String pName,pValue,pType;
			//verify property name

			List<WebElement> elementN= getElements(driver, existingPropName);	

			//verify property value
			List<WebElement> elementV= getElements(driver, existingPropValue);	
			//verify property type

			List<WebElement> elementT= getElements(driver, existingPropType);

			for (int i=0;i< elementN.size();i++)
			{
				pName = elementN.get(i).getText();

				pValue= elementV.get(i).getText();

				pType= elementT.get(i).getText();

				if(name.trim().equalsIgnoreCase(pName))
				{
					BaseSuite.validationReportLog("Property name: "+name+" matched with expected.");
					flag=true;
				}
				else
				{
					flag=false;
				}
				if(value.trim().equalsIgnoreCase(pValue))
				{
					BaseSuite.validationReportLog("Property value: "+value+" matched with expected.");
					flag=true;
				}
				else
				{
					flag=false;
				}
				if(type.trim().equalsIgnoreCase(pType))
				{
					BaseSuite.validationReportLog("Property type: "+type+" matched with expected.");
					flag=true;
				}else
				{
					flag=false;
				}
			}

		} catch (Exception e) {
			e.getMessage();
		}	
		return flag;
	}

	//Method to view access modifier for connection without jdbc url
	public void viewAccessModiferWithoutJDBCURL(String value)	
	{
		try {
			//verifyConnElementNItsVisibility(accountIdentifierInput,"access modifier","el32307.us-east-1","false","system");
			//verifyConnElementNItsVisibility(accountIdentifierInput,"access modifier","el32307.us-east-1","false","user");
			
		} catch (Exception e) {
			e.getMessage();
		}

	}


	//Method to view access modifier for connection without jdbc url
	public void viewAccessModiferWithJDBCURL()	
	{
		String methodName="viewAccessModiferWithJDBCURL";

		boolean status=false;
		try {
			BaseSuite.reportLog("Verifying access modifier field.");

			javascript(driver,"arguments[0].scrollIntoView(true);", accountIdentifierInput);

			if(isDisplayed(driver, accountIdentifierInput))
			{
				BaseSuite.reportLog("Access modifier field is displayed.");

				if(!(isEnabled(driver, accountIdentifierInput)))
				{
					BaseSuite.validationReportLog("Access modifier input box is disabled.");

					BaseSuite.reportLog("Verify placeholder is present in input box.");

					status= verifyplaceholder(accountIdentifierInput,"Enter identifier");

					if(status)
					{
						BaseSuite.validationReportLog("correct placeholder is displayed in access modifier input box.");
					}
					else
					{
						BaseSuite.reportFailLog("Expected placeholder didnt matched with actual placeholder, kindly check.", methodName);
					}
				}
				else
				{
					BaseSuite.reportFailLog("Access modifier field is enabled when JDBC url is selected, kindly check.", methodName);
				}

			}
			else
			{
				BaseSuite.reportFailLog("Unable to locate Access modifier field as it not displayed, kindly check.", methodName);
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	//Method to view Warehouse for connection without jdbc url
	public void viewWarehouseWithoutJDBCURL(String value)	
	{
		String methodName="viewWarehouseWithoutJDBCURL";

		try {
			BaseSuite.reportLog("Verifying warehouse field.");

			javascript(driver,"arguments[0].scrollIntoView(true);", connWarehouseInput);

			if(isDisplayed(driver, connWarehouseInput))
			{
				BaseSuite.reportLog("Warehouser field is displayed.");

				if(isEnabled(driver, connWarehouseInput))
				{
					BaseSuite.validationReportLog("Warehouser field is enabled.");

					if(!isEditable(driver, connWarehouseInput, "warehouser"))
					{
						BaseSuite.reportFailLog("Warehouser field is not editable.Kindly check.",methodName);
					}

					BaseSuite.reportLog("Verifying warehouser field value:");

					String actualValue= getAttribute(driver, connWarehouseInput, "value");

					compareActualNExpectedValue(actualValue,value);
				}
				else
				{
					BaseSuite.reportFailLog("Warehouser field is disabled even when JDBC url is not selected, kindly check.", methodName);
				}

			}
			else
			{
				BaseSuite.reportFailLog("Unable to locate warehouser field as it not displayed, kindly check.", methodName);
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}


	//Method to view Warehouse for connection with jdbc url
	public void viewWarehouseWithJDBCURL()	
	{
		String methodName="viewWarehouseWithJDBCURL";

		boolean status=false;
		try {
			BaseSuite.reportLog("Verifying warehouse field.");

			javascript(driver,"arguments[0].scrollIntoView(true);", connWarehouseInput);

			if(isDisplayed(driver, connWarehouseInput))
			{
				BaseSuite.reportLog("Warehouse field is displayed.");

				if(!(isEnabled(driver, connWarehouseInput)))
				{
					BaseSuite.validationReportLog("Warehouse input box is disabled.");

					BaseSuite.reportLog("Verify placeholder is present in input box.");

					status= verifyplaceholder(connWarehouseInput,"Enter warehouse");

					if(status)
					{
						BaseSuite.validationReportLog("correct placeholder is displayed in warehouse input box.");
					}
					else
					{
						BaseSuite.reportFailLog("Expected placeholder didnt matched with actual placeholder, kindly check.", methodName);
					}
				}
				else
				{
					BaseSuite.reportFailLog("Warehouse field is enabled when JDBC url is selected, kindly check.", methodName);
				}

			}
			else
			{
				BaseSuite.reportFailLog("Unable to locate Access modifier field as it not displayed, kindly check.", methodName);
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	//Method to view database for connection without jdbc url
	public void viewDatabaseWithoutJDBCURL(String value)	
	{
		String methodName="viewAccessModiferWithoutJDBCURL";

		try {
			BaseSuite.reportLog("Verifying database field.");

			javascript(driver,"arguments[0].scrollIntoView(true);", connDatabaseInput);

			if(isDisplayed(driver, connDatabaseInput))
			{
				BaseSuite.reportLog("Database field is displayed.");

				if(isEnabled(driver, connDatabaseInput))
				{
					BaseSuite.validationReportLog("Database field is enabled.");

					if(!isEditable(driver, connDatabaseInput, "database"))
					{
						BaseSuite.reportFailLog("Database field is not editable.Kindly check.",methodName);
					}

					BaseSuite.reportLog("Verifying database field value:");

					String actualValue= getAttribute(driver, connDatabaseInput, "value");

					compareActualNExpectedValue(actualValue,value);
				}
				else
				{
					BaseSuite.reportFailLog("Database field is disabled even when JDBC url is not selected, kindly check.", methodName);
				}

			}
			else
			{
				BaseSuite.reportFailLog("Unable to locate database field as it not displayed, kindly check.", methodName);
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}


	//Method to view Database for connection without jdbc url
	public void viewDatabaseWithJDBCURL()	
	{
		String methodName="viewDatabaseWithJDBCURL";

		boolean status=false;
		try {
			BaseSuite.reportLog("Verifying database field.");

			javascript(driver,"arguments[0].scrollIntoView(true);", connDatabaseInput);

			if(isDisplayed(driver, connDatabaseInput))
			{
				BaseSuite.reportLog("Database field is displayed.");

				if(!(isEnabled(driver, connDatabaseInput)))
				{
					BaseSuite.validationReportLog("Database input box is disabled.");

					BaseSuite.reportLog("Verify placeholder is present in input box.");

					status= verifyplaceholder(connDatabaseInput,"Enter identifier");

					if(status)
					{
						BaseSuite.validationReportLog("correct placeholder is displayed in database input box.");
					}
					else
					{
						BaseSuite.reportFailLog("Expected placeholder didnt matched with actual placeholder, kindly check.", methodName);
					}
				}
				else
				{
					BaseSuite.reportFailLog("Database field is enabled when JDBC url is selected, kindly check.", methodName);
				}

			}
			else
			{
				BaseSuite.reportFailLog("Unable to locate database field as it not displayed, kindly check.", methodName);
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	//Method to view Username for system Connection.
	public void viewUsernameFieldWithSystemConnection(String value)
	{
		String methodName="viewUsernameFieldWithSystemConnection";
		try {

			javascript(driver,"arguments[0].scrollIntoView(true);", connUsernameInput);

			if(isDisplayed(driver, connUsernameInput))				
			{
				BaseSuite.reportLog("Username field is displayed.");

				if(isEnabled(driver, connUsernameInput))
				{
					BaseSuite.reportLog("Username field is enabled.");

					if(!(isEditable(driver, connUsernameInput, "username")))
					{
						BaseSuite.reportFailLog("Username field is not editable.Kindly check.",methodName);
					}
					BaseSuite.reportLog("Verifying username field value:");

					String actualValue= getAttribute(driver, connUsernameInput, "value");

					compareActualNExpectedValue(actualValue,value);

				}
				else
				{
					BaseSuite.reportFailLog("Username field is disabled in case of system connection., kindly check.", methodName);
				}
			}else
			{
				BaseSuite.reportFailLog("Unable to locate username field as it not displayed, kindly check.", methodName);
			}

		} catch (Exception e) {
			e.getMessage();
		}


	}
	//Method to view Username for User Connection.
	public void viewUsernameFieldWithUserConnection()
	{

		String methodName="viewUsernameFieldWithSystemConnection";
		try {

			javascript(driver,"arguments[0].scrollIntoView(true);", connUsernameInput);

			if(isDisplayed(driver, connUsernameInput))				
			{
				BaseSuite.reportLog("Username field is displayed.");

				if(isEnabled(driver, connUsernameInput))
				{
					BaseSuite.reportLog("Username field is enabled.");

					if(!(isEditable(driver, connUsernameInput, "username")))
					{
						BaseSuite.reportFailLog("Username field is not editable.Kindly check.",methodName);
					}
					boolean flag=verifyplaceholder(connUsernameInput,"Enter username");

					if(flag)
					{
						BaseSuite.validationReportLog("correct placeholder is displayed in username input box.");
					}
					else
					{
						BaseSuite.reportFailLog("Expected placeholder didnt matched with actual placeholder, kindly check.", methodName);
					}

				}
				else
				{
					BaseSuite.reportFailLog("Username field is disabled in case of user connection, kindly check.", methodName);
				}
			}else
			{
				BaseSuite.reportFailLog("Unable to locate username field as it not displayed, kindly check.", methodName);
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}
	//Method to view Connection Type for system connection
	public void viewConnectionTypeForSystemConn()	
	{
		String methodName="viewConnectionTypeWithoutJDBCURL";

		try {
			BaseSuite.reportLog("Verifying connection type field.");

			javascript(driver,"arguments[0].scrollIntoView(true);", connTypeSelectionDropdown);

			if(isDisplayed(driver, connTypeSelectionDropdown))
			{
				BaseSuite.reportLog("Connection type field is displayed.");

				if(isEnabled(driver, connTypeSelectionDropdown))
				{
					BaseSuite.validationReportLog("Connection type is enabled.");

					if(!isClickable(driver, connTypeSelectionDropdown, "connection type",true))
					{
						BaseSuite.reportFailLog("Connection type field is not clickable.Kindly check.",methodName);
					}

					BaseSuite.reportLog("Verifying connection type field selected value:");

					String actualValue= getAttribute(driver, connTypeSelectionDropdown, "aria-label");

					compareActualNExpectedValue(actualValue,"system");
				}
				else
				{
					BaseSuite.reportFailLog("Connection type is disabled even when JDBC url is not selected, kindly check.", methodName);
				}

			}
			else
			{
				BaseSuite.reportFailLog("Unable to locate connection type field as its not displayed, kindly check.", methodName);
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}


	//Method to view Connection Type for User connection
	public void viewConnectionTypeForUserConn(String value)	
	{
		String methodName="viewConnectionTypeWithoutJDBCURL";

		try {
			BaseSuite.reportLog("Verifying connection type field.");

			javascript(driver,"arguments[0].scrollIntoView(true);", connTypeSelectionDropdown);

			if(isDisplayed(driver, connTypeSelectionDropdown))
			{
				BaseSuite.reportLog("Connection type field is displayed.");

				if(!(isEnabled(driver, connTypeSelectionDropdown)))
				{
					BaseSuite.validationReportLog("Connection type in user connections is disabled.");									

					BaseSuite.reportLog("Verifying connection type field displayed value:");

					String actualValue= getAttribute(driver, connTypeSelectionDropdown, "aria-label");

					compareActualNExpectedValue(actualValue,value);
				}
				else
				{
					BaseSuite.reportFailLog("Connection type is enabled in user connection, kindly check.", methodName);
				}

			}
			else
			{
				BaseSuite.reportFailLog("Unable to locate connection type field as its not displayed, kindly check.", methodName);
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}
	//Method to view Password field for System connection
	public void viewPasswordFieldWithSystemConnection(String value)
	{
		String methodName="viewUsernameFieldWithSystemConnection";
		try {

			javascript(driver,"arguments[0].scrollIntoView(true);", connPasswordInput);

			if(isDisplayed(driver, connPasswordInput))				
			{
				BaseSuite.reportLog("Password field is displayed.");

				if(isEnabled(driver, connPasswordInput))
				{
					BaseSuite.reportLog("Password field is enabled.");

					if(!(isEditable(driver, connPasswordInput, "username")))
					{
						BaseSuite.reportFailLog("Password field is not editable.Kindly check.",methodName);
					}
					BaseSuite.reportLog("Verifying password field value:");

					String actualValue= getAttribute(driver, connPasswordInput, "value");

					if(actualValue.isEmpty())
					{
						BaseSuite.reportErrorLog("Password field on system connection page is empty,kindly check.");
					}

				}
				else
				{
					BaseSuite.reportFailLog("Password field is disabled in case of system connection., kindly check.", methodName);
				}
			}else
			{
				BaseSuite.reportFailLog("Unable to locate password field as it not displayed, kindly check.", methodName);
			}

		} catch (Exception e) {
			e.getMessage();
		}


	}		

	//Method to view Password field for User connection
	public void viewPasswordFieldWithUserConnection()
	{

		String methodName="viewUsernameFieldWithSystemConnection";
		try {

			javascript(driver,"arguments[0].scrollIntoView(true);", connPasswordInput);

			if(isDisplayed(driver, connPasswordInput))				
			{
				BaseSuite.reportLog("Password field is displayed.");

				if(isEnabled(driver, connPasswordInput))
				{
					BaseSuite.reportLog("Password field is enabled.");

					if(!(isEditable(driver, connPasswordInput, "Password")))
					{
						BaseSuite.reportFailLog("Password field is not editable.Kindly check.",methodName);
					}
					boolean flag=verifyplaceholder(connPasswordInput,"Enter password");

					if(flag)
					{
						BaseSuite.validationReportLog("correct placeholder is displayed in password input box.");
					}
					else
					{
						BaseSuite.reportFailLog("Expected placeholder didnt matched with actual placeholder, kindly check.", methodName);
					}

				}
				else
				{
					BaseSuite.reportFailLog("Username field is disabled in case of user connection, kindly check.", methodName);
				}
			}else
			{
				BaseSuite.reportFailLog("Unable to locate password field as it not displayed, kindly check.", methodName);
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	//Comman method to verify String value expected & actual
	public boolean compareActualNExpectedValue(String actualString , String expectedString) {

		boolean flag = false;

		try {
			if((!actualString.isEmpty())&(!expectedString.isEmpty())) {


				if(actualString.trim().toLowerCase().equalsIgnoreCase(expectedString.trim().toLowerCase())) {

					BaseSuite.validationReportLog("Expected value : "+expectedString.trim()+ " matched successfully with actual value : "+actualString.trim());
					flag=true;

				}else {
					BaseSuite.reportFailLog("Expected value : "+expectedString.trim()+ " didn't matched with actual value : "+actualString.trim(), "compareActualNExpectedValue");

				}
			}else {

				BaseSuite.reportErrorLog("Unable to match values as either of them is empty : Expected value="+actualString+" & Actual value="+actualString);				

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e.toString());
		}
		return flag;
	}

//verify visibility of element based on jdbc flag
	public void verifyElementVisibilityAsPerJDBCFlag(String jdbcFlag,By locator,String locatorName,String connectionType)
	{
		String strVisiblityA,strVisiblityE; boolean actual,expected=false;
		
		try {
			if(!jdbcFlag.isEmpty())
			{
				actual=isEnabledAsPerClassName(locator);
				
				if(jdbcFlag.trim().toLowerCase().equalsIgnoreCase("true"))
				{
					strVisiblityE=returnStringAsPerBooleanValue(expected);
					strVisiblityA=returnStringAsPerBooleanValue(actual);
					
					if(actual==expected)
					{
						BaseSuite.validationReportLog("Visibility of "+locatorName+" field is matched, as its "+strVisiblityA+".");	
					}
					else
					{
						BaseSuite.reportFailLog("Visibility of "+locatorName+" field doesnt matched with actual", "verifyElementVisibilityAsPerJDBCFlag");
					}
					
				}else if(jdbcFlag.trim().toLowerCase().equalsIgnoreCase("false"))
				{					
					strVisiblityA=returnStringAsPerBooleanValue(actual);
					
					if(connectionType.equalsIgnoreCase("system"))
					{
						expected=true;
					}
					else
					{
						expected=false;
					}
					strVisiblityE=returnStringAsPerBooleanValue(expected);
					
					if(actual==expected)
					{
						BaseSuite.validationReportLog("Visibility of "+locatorName+" field is matched, as its "+strVisiblityA+".");	
					}
					else
					{
						BaseSuite.reportFailLog("Visibility of "+locatorName+" field doesnt matched with actual", "verifyElementVisibilityAsPerJDBCFlag");
					}
				}
			
			}else
			{
				BaseSuite.reportErrorLog("JDBC flag is empty kindly check.");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
//comman method to check visibility of input boxes based on JDBC url condition as well
	
	public void verifyConnElementNItsVisibility(By locator,String locatorname,String valueToVerify,String jdbcFlag,String connectionType)
	{
		String methodName="verifyConnElementNItsVisibility";
		
		boolean actual=false; String strVisiblityA=null,strVisiblityE=null;
		
		javascript(driver,"arguments[0].scrollIntoView(true);",locator);		
					
		if(connectionType.equalsIgnoreCase("system"))
		{
			if(isDisplayed(driver, locator))
			{
				BaseSuite.reportLog(locatorname+" field is displayed.");
				
				verifyElementVisibilityAsPerJDBCFlag(jdbcFlag,locator,locatorname,connectionType);
				//verifying data
				
				if(!jdbcFlag.isEmpty())
				{
					if(jdbcFlag.trim().toLowerCase().equalsIgnoreCase("true"))
					{
						verifyWhenJDBCUrlIsTrue(locator,locatorname,valueToVerify,methodName);
						
					}else if(jdbcFlag.trim().toLowerCase().equalsIgnoreCase("false"))
					{
						verifyWhenJDBCUrlIsFalse(locator,locatorname,valueToVerify,methodName,connectionType);
						
					}else
					{
						BaseSuite.reportErrorLog("Unable to process given value: "+jdbcFlag+",kindly check.");
					}
				}else
				{
					BaseSuite.reportErrorLog("JDBC flag is empty kindly check.");
				}
			}else
			{
				BaseSuite.reportFailLog("Unable to locate "+locatorname+" field as it not displayed for connection type:: "+connectionType+", kindly check.", methodName);
			}
		}
		else if(connectionType.equalsIgnoreCase("user"))
		{
			if(isDisplayed(driver, locator))
			{
				BaseSuite.reportLog(locatorname+" field is displayed.");	
				
				verifyElementVisibilityAsPerJDBCFlag(jdbcFlag,locator,locatorname,connectionType);
				//verifying content of element
										
				if(!jdbcFlag.isEmpty())
					{
						if(jdbcFlag.trim().toLowerCase().equalsIgnoreCase("true"))
						{
							verifyWhenJDBCUrlIsTrue(locator,locatorname,valueToVerify,methodName);
							
						}else if(jdbcFlag.trim().toLowerCase().equalsIgnoreCase("false"))
						{
							verifyWhenJDBCUrlIsFalse(locator,locatorname,valueToVerify.trim(),methodName,connectionType);
							
						}else
						{
							BaseSuite.reportErrorLog("Unable to process given value: "+jdbcFlag+",kindly check.");
						}
					}else
					{
						BaseSuite.reportErrorLog("JDBC flag is empty kindly check.");
					}
				
			}else
			{
				BaseSuite.reportFailLog("Unable to locate "+locatorname+" field as it not displayed for connection type:: "+connectionType+", kindly check.", methodName);
			}		
		
		}
		else
		{
			BaseSuite.reportErrorLog("Unable to match value of connection type as its different from system or user. Actual received:: "+connectionType);
		}
		
		
	}	
		
		
		
		
		
		
		
		
		
		


	
	
	public void verifyWhenJDBCUrlIsTrue(By locator,String locatorname,String placeholder,String methodName)
	{
		boolean status=false;
		String placeholderValue=null;
		try {
						
			if((placeholder.isEmpty())||(placeholder==null))
			{	
				
				BaseSuite.reportLog("Verifying placeholder is present in input box.");
				
				if(locator.equals(accountIdentifierInput))
				{
					placeholderValue= ConstantProperty.placeholderAccountIdentifier;
					
				}else if(locator.equals(connWarehouseInput))
				{
					placeholderValue= ConstantProperty.placeholderWarehouse ;
				}
				else if(locator.equals(connDatabaseInput))
				{
					placeholderValue= ConstantProperty.placeholderDatabase ;
				}
				else
				{
					System.out.println("Unable to process locator value in Method :: verifyWhenJDBCUrlIsTrue");
				}
				
				status= verifyplaceholder(locator,placeholderValue);				//"Enter "+locatorname
				
				if(status)
				{
					BaseSuite.validationReportLog("correct placeholder is displayed in "+locatorname+" input box.");
				}
				else
				{
					BaseSuite.reportFailLog("Expected placeholder didnt matched with actual placeholder, kindly check.", methodName);
				}
			}
			else
			{
				BaseSuite.reportFailLog(locatorname+" field is enabled when JDBC url is selected, kindly check.", methodName);
			}
			
		} catch (Exception e) {
			e.getMessage();
			throw new AssertionError();
		}
	}
	
	public void verifyWhenJDBCUrlIsFalse(By locator,String locatorname,String data,String methodName,String connectionType)
	{
		
		try {	
				if((!isEditable(driver, locator, locatorname))&(connectionType.trim().equalsIgnoreCase("system")))
				{
					BaseSuite.reportFailLog(locatorname+" field is not editable.Kindly check.",methodName);
				}
				
				BaseSuite.reportLog("Verifying "+locatorname+" field value:");

				String actualValue= getAttribute(driver, locator, "value");

				compareActualNExpectedValue(actualValue,data);
			
			
		} catch (Exception e) {
			e.getMessage();
			throw new AssertionError();
		}
	}

	//method will check enabled or not with respect to class value
	public boolean isEnabledAsPerClassName(By locator)
	{
		boolean flag=false;
		String strState="disabled";
		try {
			String classValue=getAttribute(driver, locator, "class");
			
			if(classValue.trim().contains(strState))
			{
				flag =false;
			}
			else
			{
				flag=true;
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		return flag;
	}
	//return class flag
	public String returnStringAsPerBooleanValue(boolean state)
	{
		String tempVar=null;
		try {
			
		
			if(state)
			{
				tempVar="enabled";
			}
			else
			{
				tempVar="disabled";
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		return tempVar;
	}
	
}
