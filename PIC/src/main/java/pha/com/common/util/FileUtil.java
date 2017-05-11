package pha.com.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
/**
 * 文件类
 * 创建人：liwei 创建时间：2016年1月25日
 * @version
 */
public class FileUtil {
	
	/**
	 * 创建目录
	 * 
	 * @param destDirName
	 *            目标目录名
	 * @return 目录创建成功返回true，否则返回false
	 */
	public static boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {
			destDirName = destDirName + File.separator;
		}
		// 创建单个目录
		if (dir.mkdirs()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 删除文件
	 * 
	 * @param filePathAndName
	 *            String 文件路径及名称 如c:/lw.txt
	 * @param fileContent
	 *            String
	 * @return boolean
	 */
	public static void delFile(String filePathAndName) {
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			java.io.File myDelFile = new java.io.File(filePath);
			myDelFile.delete();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	/***
	 * 删除文件夹
	 * @param folderPath 文件夹完整路径
	 * @return
	 */
	public static void delFolder(String filePath) {
	   try {
		   delAllFile(filePath); // 删除完里面所有内容
		   String folderPath = filePath;
		   folderPath = folderPath.toString();
		   java.io.File myFilePath = new java.io.File(folderPath);
		   myFilePath.delete(); // 删除空文件夹
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	}
	
	/***
	 * 删除指定文件夹下所有文件
	 * @param path 文件夹完整路径
	 * @return
	 */
	public static boolean delAllFile(String filePath) {
	   boolean flag = false;
	   File file = new File(filePath);
	   if (!file.exists()) {
		   return flag;
	   }
	   if (!file.isDirectory()) {
		   return flag;
	   }
	   String[] tempList = file.list();
	   File temp = null;
	   for (int i = 0; i < tempList.length; i++) {
		   if (filePath.endsWith(File.separator)) {
			   temp = new File(filePath + tempList[i]);
		   } else {
			   temp = new File(filePath + File.separator + tempList[i]);
		   }
		   if (temp.isFile()) {
			   temp.delete();
		   }
		   if (temp.isDirectory()) {
			   delAllFile(filePath + "/" + tempList[i]);// 先删除文件夹里面的文件
			   delFolder(filePath + "/" + tempList[i]);// 再删除空文件夹
			   flag = true;
		   }
	   }
	   return flag;
	}
	
	/** 
     * response 下载 
     * @author geloin 
     * @date 2012-5-5 下午12:25:39 
     * @param request 
     * @param response 
     * @param storeName 
     * @param contentType 
     * @param realName 
     * @throws Exception 
     */  
    public static void download(HttpServletRequest request, HttpServletResponse response, String file, String realName) throws Exception {
    	response.setContentType("text/html;charset=UTF-8");  
        request.setCharacterEncoding("UTF-8");  
        BufferedInputStream bis = null;  
        BufferedOutputStream bos = null;  
        long fileLength = new File(file).length();  
        response.setContentType("application/octet-stream");  
        response.setHeader("Content-disposition", "attachment; filename="+ new String(realName.getBytes("utf-8"), "ISO8859-1"));  
        response.setHeader("Content-Length", String.valueOf(fileLength));  
  
        bis = new BufferedInputStream(new FileInputStream(file));  
        bos = new BufferedOutputStream(response.getOutputStream());  
        byte[] buff = new byte[2048];  
        int bytesRead;  
        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
            bos.write(buff, 0, bytesRead);  
        }  
        bis.close();  
        bos.close();  
    }
    
    public static ResponseEntity<byte[]> download(String filePath,String name){
    	long begin = RunDate.startDate();
		try {
			File file=new File(filePath);
			
			HttpHeaders headers = new HttpHeaders();    
	        String fileName=new String(name.getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
	        headers.setContentDispositionFormData("attachment", fileName);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); 
	        RunDate.endDate("运行时间", begin);
	        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
		} catch (Exception e) {
			return null;
		}
    }
}
