package com.framework.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.framework.base.BaseClass;

public class ReadConfig {
	
	Properties pro;
	final  Logger log = LoggerFactory.getLogger(ReadConfig.class);
	

	public ReadConfig(String folderPath)
	{
		File folder = new File(BaseClass.DIR_PATH+folderPath);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				log.info("File " + listOfFiles[i].getName());

				Properties prop2 = new Properties();

				File src = new File(folderPath + listOfFiles[i].getName());

				try (FileInputStream fis = new FileInputStream(src);){

					prop2.load(fis);

					pro.putAll(prop2);
				} catch (Exception e) {
					log.info("Exception is " + e.getMessage());

				}

			} else if (listOfFiles[i].isDirectory()) {
				log.info("Directory " + listOfFiles[i].getName());
			}
		}
	}

	// Generic getter
    public String getProperty(String key) {
        String value = pro.getProperty(key);

        if (value == null) {
            log.error("Key not found in config: " + key);
            throw new RuntimeException("Missing config key: " + key);
        }
        return value.trim();
    }
    


}
