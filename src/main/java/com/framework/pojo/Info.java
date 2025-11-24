package com.framework.pojo;

public class Info {
	
	public String host;
	public String port;
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public boolean isUseCustomCertificates() {
		return useCustomCertificates;
	}
	public void setUseCustomCertificates(boolean useCustomCertificates) {
		this.useCustomCertificates = useCustomCertificates;
	}
	public String database;
	public boolean useCustomCertificates;
}
