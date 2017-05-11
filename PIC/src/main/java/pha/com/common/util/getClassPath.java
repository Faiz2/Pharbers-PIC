package pha.com.common.util;

public class getClassPath {
	
	public static String getPath(){
		return Thread.currentThread().getContextClassLoader().getResource("/").getPath();
	}
}
