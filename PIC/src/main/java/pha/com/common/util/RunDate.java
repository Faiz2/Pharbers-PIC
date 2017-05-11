package pha.com.common.util;


public class RunDate {
	public static long startDate(){
		long startDate = System.currentTimeMillis();
		System.out.println();
		return startDate;
	}
	
	public static long endDate(String content,long startDate){
		System.out.println(content+"完成");
		long endDate = System.currentTimeMillis();
		System.out.println(content+"耗时："+((endDate-startDate)/1000)+"秒");
		return endDate;
	}
}
