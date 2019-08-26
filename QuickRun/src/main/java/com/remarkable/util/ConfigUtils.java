package com.remarkable.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 公共过滤器
 * @author 向林俊
 *
 */
public class ConfigUtils {
	
	private static Properties prop=null;
	
	public static void load(){
		try {
			
			InputStream is=ConfigUtils.class.getClassLoader().getResourceAsStream("config.properties");
			prop=new Properties();
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getValue(String name){
		return prop.getProperty(name);
	}
	
	public static int getIntValue(String name){
		return Integer.valueOf(prop.getProperty(name));
	}
	
	public static void main(String[] args) {
		System.out.println(getValue("url"));
	}

}
