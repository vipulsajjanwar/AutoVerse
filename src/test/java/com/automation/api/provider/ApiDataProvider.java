package com.automation.api.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.framework.base.BaseClass;
import com.framework.utils.XLUtil;

public class ApiDataProvider {
	
	String userExcelPath = BaseClass.DIR_PATH+"/src/test/resources/testdata/UsersAPITestData.xlsx";
	String groupExcelPath = BaseClass.DIR_PATH+"/src/test/resources/testdata/GroupsAPITestData.xlsx";
	
	String executeFlagColumn = "ExecuteFlag";
	
	String createSheet = "createAPI";
	String searchUserSheet = "searchAPI";
	String updateUserSheet = "updateAPI";
	String getSheet = "getAPI";
	String deleteUserSheet = "deleteAPI";
	
	
	@DataProvider(name = "createUserData")
	public Object[][] getCreateUserData() {

		List<Map<String, String>> excelData =
				XLUtil.readExcel(userExcelPath, createSheet);

		List<Object[]> filtered = new ArrayList<>();

		for (Map<String, String> row : excelData) {

			// skip row without logging anywhere
			if ("No".equalsIgnoreCase(row.get(executeFlagColumn))) {
				continue; 
			}

			// Add only valid rows
			filtered.add(new Object[]{row});
		}

		return filtered.toArray(new Object[0][]);
	}

	@DataProvider(name = "searchUserData")
	public Object[][] getSearchUserData() {

		List<Map<String, String>> excelData =
				XLUtil.readExcel(userExcelPath, searchUserSheet);

		List<Object[]> filtered = new ArrayList<>();

		for (Map<String, String> row : excelData) {

			
			if ("No".equalsIgnoreCase(row.get(executeFlagColumn))) {
				continue; 
			}

			// Add only valid rows
			filtered.add(new Object[]{row});
		}

		return filtered.toArray(new Object[0][]);
	}
	
	@DataProvider(name = "updateUserData")
	public Object[][] getUpdateUserData() {

		List<Map<String, String>> excelData =
				XLUtil.readExcel(userExcelPath, updateUserSheet);

		List<Object[]> filtered = new ArrayList<>();

		for (Map<String, String> row : excelData) {

			// skip row without logging anywhere
			if ("No".equalsIgnoreCase(row.get(executeFlagColumn))) {
				continue; 
			}

			// Add only valid rows
			filtered.add(new Object[]{row});
		}

		return filtered.toArray(new Object[0][]);
	}
	
	@DataProvider(name = "getUserData")
	public Object[][] getRetriveUserData() {

		List<Map<String, String>> excelData =
				XLUtil.readExcel(userExcelPath, getSheet);

		List<Object[]> filtered = new ArrayList<>();

		for (Map<String, String> row : excelData) {

			// skip row without logging anywhere
			if ("No".equalsIgnoreCase(row.get(executeFlagColumn))) {
				continue; 
			}

			// Add only valid rows
			filtered.add(new Object[]{row});
		}

		return filtered.toArray(new Object[0][]);
	}

	@DataProvider(name = "deleteUserData")
	public Object[][] getDeleteUserData() {

		List<Map<String, String>> excelData =
				XLUtil.readExcel(userExcelPath, deleteUserSheet);

		List<Object[]> filtered = new ArrayList<>();

		for (Map<String, String> row : excelData) {

			// skip row without logging anywhere
			if ("No".equalsIgnoreCase(row.get(executeFlagColumn))) {
				continue; 
			}

			// Add only valid rows
			filtered.add(new Object[]{row});
		}

		return filtered.toArray(new Object[0][]);
	}
	
	@DataProvider(name = "createGroupData")
	public Object[][] getCreateGroupData() {

		List<Map<String, String>> excelData =
				XLUtil.readExcel(groupExcelPath, createSheet);

		List<Object[]> filtered = new ArrayList<>();

		for (Map<String, String> row : excelData) {

			// skip row without logging anywhere
			if ("No".equalsIgnoreCase(row.get(executeFlagColumn))) {
				continue; 
			}

			// Add only valid rows
			filtered.add(new Object[]{row});
		}

		return filtered.toArray(new Object[0][]);
	}
	
	@DataProvider(name = "getGroupData")
	public Object[][] getRetriveGroupData() {

		List<Map<String, String>> excelData =
				XLUtil.readExcel(groupExcelPath, getSheet);

		List<Object[]> filtered = new ArrayList<>();

		for (Map<String, String> row : excelData) {

			// skip row without logging anywhere
			if ("No".equalsIgnoreCase(row.get(executeFlagColumn))) {
				continue; 
			}

			// Add only valid rows
			filtered.add(new Object[]{row});
		}

		return filtered.toArray(new Object[0][]);
	}
}
