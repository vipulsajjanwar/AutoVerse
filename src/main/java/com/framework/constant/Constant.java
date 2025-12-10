package com.framework.constant;


import com.framework.base.BaseClass;

import com.framework.config.ReadConfig;

public class Constant {

	private static ReadConfig readconfig = new ReadConfig(BaseClass.DIR_PATH+"/src/main/resources/config");
		
	// ---------------- Email Credentials ----------------

	public static final String MAIL_USERNAME =
	        readconfig.getProperty("Mail.UserName");

	public static final String MAIL_PASSWORD =
	        readconfig.getProperty("Mail.Password");

	public static final String MAIL_EMAIL_HOST =
	        readconfig.getProperty("EmailHost");

	public static final String MAIL_PORT =
	        readconfig.getProperty("Mail.Port");

	public static final String MAIL_FROM =
	        readconfig.getProperty("Mail.From");

	public static final String MAIL_TO =
	        readconfig.getProperty("Mail.To");

	public static final String MAIL_CC =
	        readconfig.getProperty("Mail.CC");

	public static final String MAIL_BCC =
	        readconfig.getProperty("Mail.BCC");

	public static final String MAIL_SUBJECT =
	        readconfig.getProperty("Mail.Subject");

	public static final String MAIL_SIGNATURE_NAME =
	        readconfig.getProperty("Mail.MailSignatureName");

	public static final String MAIL_EMAIL_SIGNATURE =
	        readconfig.getProperty("Mail.EMAILSIGNATURE");

	public static final boolean MAIL_SENT_FLAG =
	        Boolean.parseBoolean(readconfig.getProperty("Mail.enable"));
	
	// ---------------- Database Credentials ----------------

	public static final String DB_JDBC_URL =
	        readconfig.getProperty("database.JDBCURL");

	public static final String DB_USERNAME =
	        readconfig.getProperty("database.Username");

	public static final String DB_PASSWORD =
	        readconfig.getProperty("database.Password");

	// ---------------- ELK Credentials ----------------

	public static final String ELK_URL =
	        readconfig.getProperty("elk.URL");

	public static final String KIBANA_URL =
	        readconfig.getProperty("kibana.URL");

	public static final String ELASTIC_SEARCH_STATUS =
	        readconfig.getProperty("elasticSearchStatus");

	public static final String ELK_USERNAME =
	        readconfig.getProperty("elk.username");

	public static final String ELK_PASSWORD =
	        readconfig.getProperty("elk.password");
	
	public static final boolean ELK_ENABLE =
	        Boolean.parseBoolean(readconfig.getProperty("elk.enable"));
	
	// ---------------- Session Timeouts & Waits ----------------

	// IMPORTANT: You have 2 keys with same name (Session.pageLoadTimeout).
	// Use the first one or rename one in properties.
	public static final long SESSION_PAGELOAD_TIMEOUT =
	        Long.parseLong(readconfig.getProperty("Session.pageLoadTimeout"));

	public static final long SESSION_IMPLICIT_WAIT =
	        Long.parseLong(readconfig.getProperty("Session.implicitWait"));

	public static final long SESSION_SHORT_WAIT =
	        Long.parseLong(readconfig.getProperty("Session.shortWait"));

	public static final long SESSION_MEDIUM_WAIT =
	        Long.parseLong(readconfig.getProperty("Session.mediumWait"));

	public static final long SESSION_LONG_WAIT =
	        Long.parseLong(readconfig.getProperty("Session.longWait"));


	// ---- waits in seconds ----

	public static final long SESSION_SHORT_W =
	        Long.parseLong(readconfig.getProperty("Session.shortW"));

	public static final long SESSION_MEDIUM_W =
	        Long.parseLong(readconfig.getProperty("Session.mediumW"));

	public static final long SESSION_LONG_W =
	        Long.parseLong(readconfig.getProperty("Session.longW"));

	public static final long SESSION_RULE_WAIT =
	        Long.parseLong(readconfig.getProperty("Session.ruleWait"));

	public static final boolean REPORTDOC_FLAG =
	        Boolean.parseBoolean(readconfig.getProperty("Reportdoc.enable"));
}
