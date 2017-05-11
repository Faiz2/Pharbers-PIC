package pha.com.common.base.lucene;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import pha.com.code.queryKeyWord.model.MedicalForDataInfo;
import pha.com.common.util.ListUtil;

/**
 * 
* 	<p>Title: LuceneIndexDAO</p>
* 	<p>Description: 索引库信息 增删改查</p>
* 	<p>Company: pharbers</p>
* 	@author ylk
* 	@date 2016年7月21日
 */

public class LuceneIndexDAO {

	// 创建字段索引
	public static void createIndex(MedicalForDataInfo dataInfo) {
		// 1 、先将数据信息，转换为Document对象
		// 字段存储 存储规则：结果是什么就对哪些数据进行索引，进行存储
		Document document = new Document();
		document.add(new TextField("databasename" , dataInfo.getDatabasename(), Field.Store.YES));
		document.add(new TextField("manutypename" , dataInfo.getManutypename(), Field.Store.YES));
		document.add(new TextField("interatc1name" , dataInfo.getInteratc1name(), Field.Store.YES));
		document.add(new TextField("interatc2name" , dataInfo.getInteratc2name(), Field.Store.YES));
		document.add(new TextField("interatc3name" , dataInfo.getInteratc3name(), Field.Store.YES));
		document.add(new TextField("manunameCh" , dataInfo.getManunameCh(), Field.Store.YES));
		document.add(new TextField("provincename" , dataInfo.getProvincename(), Field.Store.YES));
		document.add(new TextField("productnameCh" , dataInfo.getProductnameCh(), Field.Store.YES));
		document.add(new TextField("dosageformname" , dataInfo.getDosageformname(), Field.Store.YES));
		document.add(new TextField("specificationsname" , dataInfo.getSpecificationsname(), Field.Store.YES));
		document.add(new TextField("packagingname" , dataInfo.getPackagingname(), Field.Store.YES));
		document.add(new TextField("genericnamenameCh" , dataInfo.getGenericnamenameCh(), Field.Store.YES));
		
		// 2、创建索引
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(LuceneConfiguration.getAnalyzer());
		IndexWriter indexWriter = LuceneUtils.getIndexWriter(LuceneConfiguration.getDirectory(), indexWriterConfig);
		
		try {
			indexWriter.addDocument(document);
			indexWriter.commit();  
		} catch (Exception e) {
			try {
				indexWriter.rollback();
				throw new RuntimeException("索引创建失败！");
			} catch (IOException e1) {
				throw new RuntimeException("索引创建失败！");
			}
		}
	}

	// 删除索引
	public static void deleteIndex(MedicalForDataInfo dataInfo) {
		// 通过 id 的词条删除 
		Term term = new Term("id", dataInfo.getId().toString()); 
		
		// 删除索引
		try {
			IndexWriterConfig indexWriterConfig = new IndexWriterConfig(LuceneConfiguration.getAnalyzer());
			IndexWriter indexWriter = LuceneUtils.getIndexWriter(LuceneConfiguration.getDirectory(), indexWriterConfig);
			indexWriter.deleteDocuments(term);// 根据id词条删除
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("索引删除失败！");
		}
	}
	
	// 修改索引
	public static void updateIndex(MedicalForDataInfo dataInfo) {
		// 需要改后 document 数据
		Document document = new Document();
		document.add(new LongField("id", dataInfo.getId(), Store.YES));
		
		// 根据 id 修改
		Term term = new Term("id", dataInfo.getId().toString());
		
		// 修改索引
		try {
			IndexWriterConfig indexWriterConfig = new IndexWriterConfig(LuceneConfiguration.getAnalyzer());
			IndexWriter indexWriter = LuceneUtils.getIndexWriter(LuceneConfiguration.getDirectory(), indexWriterConfig);
			indexWriter.deleteDocuments(term);
			indexWriter.addDocument(document);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("索引删除失败！");
		}
	}

	// 根据关键字查询  id
	public static List<String> findByName(String name) throws Exception {
		List<String> ids = new ArrayList<String>();
		// 获得Query
		QueryParser queryParser = new QueryParser("newsContent", LuceneConfiguration.getAnalyzer());
		Query query = queryParser.parse(name);
		// 执行Query
		IndexSearcher indexSearcher = LuceneUtils.getIndexIndexSearcher();
		
		TopDocs topDocs = indexSearcher.search(query, 1000);
		if(topDocs.totalHits == 0){// 没有查询到
			return ids;
		}else{
			// 封装查询结果 
			ScoreDoc[] scoreDocs = topDocs.scoreDocs;
			for (ScoreDoc scoreDoc : scoreDocs) {
				Document document = indexSearcher.doc(scoreDoc.doc);
				ids.add(document.get("databasename"));
			}
			return ids;
		}
	}
	
	//根据检索条件 进行多字段查询 
	public static List<String> findByMultiFieldName(String name) throws Exception{
		List<String> ids = new ArrayList<String>();
		// 获得Query
		MultiFieldQueryParser multiFieldQueryParser = new MultiFieldQueryParser(new String[]{"databasename","manutypename","interatc1name","interatc2name","manunameCh","provincename","productnameCh","dosageformname","specificationsname","packagingname","genericnamenameCh"},  LuceneConfiguration.getAnalyzer());
		Query parse = multiFieldQueryParser.parse(name);
							//MultiFieldQueryParser.parse(name , new String[]{"databasename","manutypename","interatc1name","interatc2name","manunameCh","provincename","productnameCh","dosageformname","specificationsname","packagingname","genericnamenameCh"}, clauses,  LuceneConfiguration.getAnalyzer());
							//multiFieldQueryParser.parse(name);
		// 执行Query
		IndexSearcher indexSearcher = LuceneUtils.getIndexIndexSearcher();
		TopDocs topDocs = indexSearcher.search(parse,  IndexWriter.MAX_DOCS);//IndexWriter.MAX_DOCS
		if(topDocs.totalHits == 0){// 没有查询到
			return ids;
		}else{
			// 封装查询结果 
			ScoreDoc[] scoreDocs = topDocs.scoreDocs;
			for (ScoreDoc scoreDoc : scoreDocs) {
				Document document = indexSearcher.doc(scoreDoc.doc);
				ids.add(document.get("databasename"));
			}
			return ListUtil.removeDuplicate(ids);//去掉重复的值
		}
	}
}
