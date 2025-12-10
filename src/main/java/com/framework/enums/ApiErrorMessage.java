package com.framework.enums;

public enum ApiErrorMessage {

	
	
	INVALID_BEARER_TOKEN("Invalid bearer token for user."),
    INSUFFICIENT_PRIVILEGE("You don't have sufficient privileges to perform this operation."),

	INVALID_CONTENT_TYPE("Request header 'Content-Type' is invalid. Valid value is application/json."),
	
	ENTITY_NOT_FOUND("%s with id '%s' is not found in the system."),
    INVALID_ENTITY_ID("%s id is invalid. Only the 'uuid' format is valid.");
	
	private final String message;

    ApiErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }

    public String format(Object... args) {
        return String.format(this.message, args);
    }
	
}
