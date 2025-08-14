package com.framework.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadConfig {
	
	Properties pro;
	final  Logger log = Logger.getLogger(ReadConfig.class);
	
	public ReadConfig(String filePath)
	{
		File src = new File(filePath);
		try(FileInputStream fis = new FileInputStream(src))
		{
			
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			log.error("Exception is " + e.getMessage());
		}
	}

	public String pageLoadTimeout() {
		// TODO Auto-generated method stub
		return null;
	}

}
