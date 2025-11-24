package com.framework.pojo;

public class ServerConfig {

	public boolean useJDBCurl;
	public String jdbcUrl;
	public String cacheConnectionType;
	public Info info;
	public boolean isUseJDBCurl() {
		return useJDBCurl;
	}
	public void setUseJDBCurl(boolean useJDBCurl) {
		this.useJDBCurl = useJDBCurl;
	}
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	public String getCacheConnectionType() {
		return cacheConnectionType;
	}
	public void setCacheConnectionType(String cacheConnectionType) {
		this.cacheConnectionType = cacheConnectionType;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	
	
}
