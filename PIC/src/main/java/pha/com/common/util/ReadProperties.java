package pha.com.common.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	
	private static Properties prop = null;
	
	public static Properties read(String path){
		if(prop == null){
			prop = new Properties();  
		}
		InputStream in = null;
		try {
			in = new FileInputStream(path);
			prop.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        return prop;
	}
}
