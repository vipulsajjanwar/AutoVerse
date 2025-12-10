package com.framework.enums;

public enum DateFormatType {

	UTC_TIMESTAMP("MM/dd/yyyy HH:mm:ss 'UTC'"),
    ISO_DATE("yyyy-MM-dd"),
    ISO_DATETIME("yyyy-MM-dd'T'HH:mm:ss'Z'");

    private final String format;

    DateFormatType(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
