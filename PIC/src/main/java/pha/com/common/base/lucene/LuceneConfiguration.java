package pha.com.common.base.lucene;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import pha.com.common.util.ReadProperties;

/**
* 	<p>Title: LuceneConfiguration</p>
* 	<p>Description: lucene抽取的公共类</p>
* 	<p>Company: pharbers</p>
* 	@author ylk
* 	@date 2016年7月21日
 */
public class LuceneConfiguration {
	private static Version version ; // 版本
	private static Directory directory ; // 索引目录
	private static Analyzer analyzer ; // 分词器
	private static Properties pro;//获取索引库的地址
	
	static{
		try {
			version = Version.LUCENE_5_2_1;
			pro = ReadProperties.read(LuceneConfiguration.class.getClassLoader().getResource("/").getPath()+"file.properties");
			File file = new File(pro.getProperty("LuceneIndexFile"));
			if(!file.exists()){
				file.mkdirs();
			}
			directory = FSDirectory.open(Paths.get(pro.getProperty("LuceneIndexFile")));
			analyzer = new IKAnalyzer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Version getVersion() {
		return version;
	}

	public static Directory getDirectory() {
		return directory;
	}

	public static Analyzer getAnalyzer() {
		return analyzer;
	}
	
}
