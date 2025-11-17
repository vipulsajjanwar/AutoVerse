package com.framework.utils;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BaseUtil {
	
	public String getuserName() {

		return System.getProperty("user.name");

	}

	public String getFileOperator() {
		String fileOperator = null;
		switch (getOSName()) {
		case "Linux":
			fileOperator = "/";
			break;
		case "Windows":
			fileOperator = "\\";
			break;
		default:
			break;
		}
		return fileOperator;

	}
	
	public String getOSName() {
		return System.getProperty("os.name");	      
	}
	
	public String gethost() {
		String hostname = "Unknown";
		try {
			InetAddress addr;
			addr = InetAddress.getLocalHost();
			hostname = addr.getHostName();
		} catch (UnknownHostException ex) {
			ex.getMessage();
		}
		return hostname;
	}

	public String takeScreenshot(WebDriver driver, String filePath, String screenshotName, String extention, String timeStampFormat) throws IOException {
		String timeStampformail = new SimpleDateFormat(timeStampFormat).format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		File target = new File(Paths.get("").toAbsolutePath().toString() + filePath + "/"+ screenshotName + timeStampformail + extention);
		FileUtils.copyFile(source, target);
		FileUtils.forceDelete(source);
		return target.toString();

	}
	
	
	
}
