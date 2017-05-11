package pha.com.common.base.lucene;

import java.io.IOException;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.LogDocMergePolicy;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;

/**
* 	<p>Title: LuceneUtils</p>
* 	<p>Description: Lucene索引库查询</p>
* 	<p>Company: pharbers</p>
* 	@author ylk
* 	@date 2016年7月21日
 */
public class LuceneUtils {

	private static IndexWriter indexWriter;
	static {
		try {
			// 创建索引库
			IndexWriterConfig indexWriterConfig = new IndexWriterConfig(LuceneConfiguration.getAnalyzer());
			//索引文件过多 设置合并因子提高读写效率
			LogDocMergePolicy logDocMergePolicy = new LogDocMergePolicy();
			logDocMergePolicy.setMergeFactor(3);// 设置合并索引库文件的个数
			indexWriterConfig.setMergePolicy(logDocMergePolicy);
			
			indexWriter = new IndexWriter(LuceneConfiguration.getDirectory(), indexWriterConfig);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 关闭IndexWriter
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				try {
					System.out.println("------执行关闭钩子函数------");
					indexWriter.close();
				} catch (CorruptIndexException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	// 保证indexWriter对象唯一
	public static IndexWriter getIndexWriter(Directory directory, IndexWriterConfig indexWriterConfig){
		return indexWriter;
	}
	
	// 搜索索引库
	public static IndexSearcher getIndexIndexSearcher() throws Exception{
		return new IndexSearcher(DirectoryReader.open(LuceneConfiguration.getDirectory()));
	}
}
