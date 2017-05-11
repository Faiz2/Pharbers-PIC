package pha.com.code.queryKeyWord.dao;

import java.util.List;
import java.util.Map;

import pha.com.code.queryKeyWord.model.QueryKeyWord;
import pha.com.common.base.dao.BaseDao;

public interface QueryKeyWordMapper extends BaseDao<QueryKeyWord>{
	
	/**
	 * 根据关键字查询数据库
	 * @param map
	 * @return
	 */
	public List<QueryKeyWord> queryByKeyWord(Map<String, Object> map);
}