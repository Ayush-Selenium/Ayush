package com.selenium.utlility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	File src;
	FileInputStream fis;
	Properties pro;
	
	public ConfigDataProvider() {
		
		src= new File("./Config/Config.properties");
	
		try {
			fis = new FileInputStream(src);
		    pro = new Properties();
	        pro.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
	}
	public void getDataFromConfig(String keyToSearch) {
		pro.getProperty(keyToSearch);
		
	}
	
	public String getBrowser() {
		return pro.getProperty("browser");
	}
	public String getURL() {
		
		return pro.getProperty("url");
	}

}
