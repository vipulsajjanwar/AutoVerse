package com.framework.variables;

import java.util.List;

public class ExecutionVariables {
	private ExecutionVariables() {}
	public static String reportName="";
	public static String documentTitle="";
	public static  List<String> screenShots ;
	public static   String screenshotPath = "";

	public static int failedTC;
	public static int passedTC;
	public static int testskip;
	public static int test;
	public static String suitename = "";

	public static String issueKey= "";
	
	public static String reportDocPath =null;

	public static int currentRowNum = 1;
	
	public static String components;
	
	public static String lables;
	
	public static boolean retryFlag;
	
	public static int retryFlagCount;
	
	public static int totalcount;
	
	public static String catagory= "";
	
	public static String testName= "";
	
	public static String author="";
	
	public static String icedqUser="";
	
	
	public static String testType="";
	public static String browser="";
	public static String baseURL="";
	public static String userName="";
	public static String password="";
	public static String moduleName="";
	public static String workspaceName="";
	public static String reportFilePath="";

}
