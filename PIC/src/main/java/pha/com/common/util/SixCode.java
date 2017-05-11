package pha.com.common.util;

import java.util.Random;

/**
 * 随机生成6位数随机数 如果不是6位递归调用
 * @author Faiz
 *
 */
public class SixCode {
	public static String getSix(){ 
        Random rad=new Random();  
        String result  = rad.nextInt(1000000) +"";  
        if(result.length()!=6){  
            return getSix();  
        }  
        return result;  
    }
}
