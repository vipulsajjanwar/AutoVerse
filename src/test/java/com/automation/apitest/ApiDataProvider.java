package com.automation.apitest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.framework.base.BaseClass;
import com.framework.utils.XLUtil;

public class ApiDataProvider {
	
	String userExcelPath = BaseClass.DIR_PATH+"/src/test/resources/testdata/UsersAPITestData.xlsx";
	
	String executeFlagColumn = "ExecuteFlag";
	
	String createUserSheet = "Sheet4";
	String searchUserSheet = "Sheet3";
	
	@DataProvider(name = "createUserData")
	public Object[][] getCreateUserData() {

		List<Map<String, String>> excelData =
				XLUtil.readExcel(userExcelPath, createUserSheet);

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

}
