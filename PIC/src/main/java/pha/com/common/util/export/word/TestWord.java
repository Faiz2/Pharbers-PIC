package pha.com.common.util.export.word;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import pha.com.code.report.model.word.WordModel;
import pha.com.common.util.ReadProperties;

public class TestWord {
	private Configuration configuration = null;
	String wordDir = null;
	
	public TestWord() {
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
		wordDir = ReadProperties.read(this.getClass().getClassLoader().getResource("/").getPath()+"file.properties").get("WordSource").toString();
	}
	
	/**
	 * 创建Word文档
	 * @param obj 类
	 * @param fileName 生成的文件名
	 * @param TemplateName 调用的模板名
	 */
	public int creatDoc(Object obj,String fileName ,String TemplateName){
		// 要填入模本的数据文件
				Map<String, Object> dataMap = new HashMap<String, Object>();
				getData(dataMap,obj);
				configuration.setClassForTemplateLoading(this.getClass(),"/Freemark");
				Template t = null;
				try {
					// word.ftl为要装载的模板
					t = configuration.getTemplate(""+TemplateName+".xml");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				//输入出文档路径检验是否路径存在
				File outFile = new File(wordDir);
				if(!outFile.exists()){
					outFile.mkdirs();
				}
				outFile = null;
				outFile = new File(wordDir+fileName);
				Writer out = null;
				try {
					out = new BufferedWriter(new OutputStreamWriter(
							new FileOutputStream(outFile),"utf-8"));
					t.process(dataMap, out);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (TemplateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					try {
						out.close();
						return 1;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			return 0;
	}
	
	/**
	 * 检验数据并且输入到Word
	 * @param dataMap 键值对
	 * @param obj 类
	 */
	private void getData(Map<String, Object> dataMap ,  Object obj) {
		WordModel wordModel =  (WordModel) obj;
		if(wordModel.getName() != null){
			dataMap.put("name", wordModel.getName());
		}else{
			dataMap.put("name", "NULL");
		}
		if(wordModel.getImgBase64URL() != null){
			dataMap.put("imgBase64URL", wordModel.getImgBase64URL());
		}else{
			dataMap.put("imgBase64URL", "NULL");
		}
	}
}
