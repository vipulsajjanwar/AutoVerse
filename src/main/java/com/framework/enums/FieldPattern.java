package com.framework.enums;

public enum FieldPattern {
	
	USERNAME("^[a-zA-Z0-9-_.@]+$"),
	FIRST_LAST_NAME("^[a-zA-Z]+$"),
	PASSWORD("^(?! ).*(?<! )$"),
	EMAIL("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"),
	GROUP_NAME("^[a-zA-Z0-9-_.@]+$"),
	GROUP_DESCRIPTION("^$|^[a-zA-Z0-9-_., ]+$"),
    UUID("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$"),
    GENERIC_TEXT("^[a-zA-Z0-9-_., ]+$");

    private final String regex;

    FieldPattern(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

}
