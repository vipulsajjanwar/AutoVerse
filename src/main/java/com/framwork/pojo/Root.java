package com.framwork.pojo;

import java.util.ArrayList;

public class Root {

	public String name;
	public String connectorId;
	public String driverId;
	public String serviceProviderName;
	public String authTypeId;
	public String serverInstanceName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConnectorId() {
		return connectorId;
	}
	public void setConnectorId(String connectorId) {
		this.connectorId = connectorId;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getServiceProviderName() {
		return serviceProviderName;
	}
	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}
	public String getAuthTypeId() {
		return authTypeId;
	}
	public void setAuthTypeId(String authTypeId) {
		this.authTypeId = authTypeId;
	}
	public String getServerInstanceName() {
		return serverInstanceName;
	}
	public void setServerInstanceName(String serverInstanceName) {
		this.serverInstanceName = serverInstanceName;
	}
	public String getSecretId() {
		return secretId;
	}
	public void setSecretId(String secretId) {
		this.secretId = secretId;
	}
	public Object getSslSecretId() {
		return sslSecretId;
	}
	public void setSslSecretId(Object sslSecretId) {
		this.sslSecretId = sslSecretId;
	}
	public boolean isUseVault() {
		return useVault;
	}
	public void setUseVault(boolean useVault) {
		this.useVault = useVault;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ServerConfig getServerConfig() {
		return serverConfig;
	}
	public void setServerConfig(ServerConfig serverConfig) {
		this.serverConfig = serverConfig;
	}
	public ArrayList<ConnectionProperty> getConnectionProperties() {
		return connectionProperties;
	}
	public void setConnectionProperties(ArrayList<ConnectionProperty> connectionProperties) {
		this.connectionProperties = connectionProperties;
	}
	public AuthConfig getAuthConfig() {
		return authConfig;
	}
	public void setAuthConfig(AuthConfig authConfig) {
		this.authConfig = authConfig;
	}
	public ArrayList<Object> getCustomFields() {
		return customFields;
	}
	public void setCustomFields(ArrayList<Object> customFields) {
		this.customFields = customFields;
	}
	public ArrayList<Object> getPreferences() {
		return preferences;
	}
	public void setPreferences(ArrayList<Object> preferences) {
		this.preferences = preferences;
	}
	public String secretId;
	public Object sslSecretId;
	public boolean useVault;
	public String type;
	public ServerConfig serverConfig;
	public ArrayList<ConnectionProperty> connectionProperties;
	public AuthConfig authConfig;
	public ArrayList<Object> customFields;
	public ArrayList<Object> preferences;
}
