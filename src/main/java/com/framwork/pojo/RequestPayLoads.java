package com.framwork.pojo;

import java.util.List;

public class RequestPayLoads {

	private String name;
	private String connectorId;
	private String driverId;
	private String serviceProviderName;
	private String authTypeId;
	private String serverInstanceName;
	private String secretId;
	private String sslSecretId;
	private boolean useVault;
	private String type;
	private ServerConfig serverConfig;
	private List<ConnectionProperty> connectionProperties;
	private AuthConfig authConfig;
	private List<Object> customFields;
	private List<Object> preferences;
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
	public String getSslSecretId() {
		return sslSecretId;
	}
	public void setSslSecretId(String sslSecretId) {
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
	public List<ConnectionProperty> getConnectionProperties() {
		return connectionProperties;
	}
	public void setConnectionProperties(List<ConnectionProperty> connectionProperties) {
		this.connectionProperties = connectionProperties;
	}
	public AuthConfig getAuthConfig() {
		return authConfig;
	}
	public void setAuthConfig(AuthConfig authConfig) {
		this.authConfig = authConfig;
	}
	public List<Object> getCustomFields() {
		return customFields;
	}
	public void setCustomFields(List<Object> customFields) {
		this.customFields = customFields;
	}
	public List<Object> getPreferences() {
		return preferences;
	}
	public void setPreferences(List<Object> preferences) {
		this.preferences = preferences;
	}
	
	
}
