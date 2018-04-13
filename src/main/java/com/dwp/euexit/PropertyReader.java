package com.dwp.euexit;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	static String propVal = "";
	Properties prop = new Properties();
	String filePath = "./serenity.properties";
	private static PropertyReader pr;

	public String getIt(String propName){
		
		try(InputStream inputStream = new FileInputStream(filePath)){
			
			prop.load(inputStream);
			propVal =  prop.getProperty(propName);	
		}catch (IOException ex) {
			System.out.println("Problem occurs when reading file !");
			ex.printStackTrace();
		}
		return propName;

	}
	
	public static String getPropVal(String propKey)
	{
			pr = new PropertyReader();
			pr.getIt(propKey);
			return propVal;
	}
}
