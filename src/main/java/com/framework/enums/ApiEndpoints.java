package com.framework.enums;

public enum ApiEndpoints {
	 	ORG_ID("api.orgid"),
	    TOKEN("api.token"),
	    USERS("api.users"),
	    GROUPS("api.groups"),
	    ACCOUNTS("api.accounts"),
	    WORKSPACES("api.workspaces"),
	    SECRETS("api.secrets"),
	    CONNECTIONS("api.connections"),
	    RULES("api.rules"),
	    WORKFLOWS("api.workflows");

	    private final String key;

	    ApiEndpoints(String key) {
	        this.key = key;
	    }

	    public String key() {
	        return key;
	    }
}
