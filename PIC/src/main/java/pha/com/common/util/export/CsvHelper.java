package pha.com.common.util.export;

import java.io.FileWriter;
import java.io.IOException;

import pha.com.common.util.StringUtil;

/**
 * Csv工具静态类
 * 
 * @author liwei
 */
public abstract class CsvHelper {
	/**
	 * 写入数据到指定csv文件中
	 * 
	 * @param header
	 *            数据头部
	 * @param content
	 *            数据列表
	 * @param filepath
	 *            文件路径
	 */
	public static void writeExcel(String header,String content,String filepath,boolean append){
		try {
			FileWriter fw = new FileWriter(filepath,append);
			if(StringUtil.notEmpty(header)){
				fw.write(header);
			}
			System.out.println("写入中，请稍后...");
			fw.write(content);
		    fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
