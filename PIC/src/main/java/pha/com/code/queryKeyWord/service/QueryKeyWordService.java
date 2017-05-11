package pha.com.code.queryKeyWord.service;

import java.util.List;
import java.util.Map;

import pha.com.code.queryKeyWord.model.QueryKeyWord;
import pha.com.common.base.service.BaseService;

public interface QueryKeyWordService extends BaseService<QueryKeyWord> {
	
	/**
	 * 根据关键字查询数据库
	 * @param map
	 * @return
	 */
	public List<QueryKeyWord> queryByKeyWord(Map<String, Object> map);
}
