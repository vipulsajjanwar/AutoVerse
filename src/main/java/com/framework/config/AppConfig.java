package com.framework.config;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AppConfig {

	protected static final Properties prop = new Properties();
	public static final Logger log = LogManager.getLogger(AppConfig.class);

	// ---------------------------------------------------------
	// API Endpoints
	// ---------------------------------------------------------
	private String API_ORGID;
	private String API_TOKEN;
	private String API_USERS;
	private String API_GROUPS;
	private String API_ACCOUNTS;
	private String API_WORKSPACES;
	private String API_SECRETS;
	private String API_CONNECTIONS;
	private String API_RULES;
	private String API_WORKFLOWS;

	// API
	public String getAPI_ORGID() { return API_ORGID; }
	public void setAPI_ORGID(String aPI_ORGID) { API_ORGID = aPI_ORGID; }

	public String getAPI_TOKEN() { return API_TOKEN; }
	public void setAPI_TOKEN(String aPI_TOKEN) { API_TOKEN = aPI_TOKEN; }

	public String getAPI_USERS() { return API_USERS; }
	public void setAPI_USERS(String aPI_USERS) { API_USERS = aPI_USERS; }

	public String getAPI_GROUPS() { return API_GROUPS; }
	public void setAPI_GROUPS(String aPI_GROUPS) { API_GROUPS = aPI_GROUPS; }

	public String getAPI_ACCOUNTS() { return API_ACCOUNTS; }
	public void setAPI_ACCOUNTS(String aPI_ACCOUNTS) { API_ACCOUNTS = aPI_ACCOUNTS; }

	public String getAPI_WORKSPACES() { return API_WORKSPACES; }
	public void setAPI_WORKSPACES(String aPI_WORKSPACES) { API_WORKSPACES = aPI_WORKSPACES; }

	public String getAPI_SECRETS() { return API_SECRETS; }
	public void setAPI_SECRETS(String aPI_SECRETS) { API_SECRETS = aPI_SECRETS; }

	public String getAPI_CONNECTIONS() { return API_CONNECTIONS; }
	public void setAPI_CONNECTIONS(String aPI_CONNECTIONS) { API_CONNECTIONS = aPI_CONNECTIONS; }

	public String getAPI_RULES() { return API_RULES; }
	public void setAPI_RULES(String aPI_RULES) { API_RULES = aPI_RULES; }

	public String getAPI_WORKFLOWS() { return API_WORKFLOWS; }
	public void setAPI_WORKFLOWS(String aPI_WORKFLOWS) { API_WORKFLOWS = aPI_WORKFLOWS; }

}
