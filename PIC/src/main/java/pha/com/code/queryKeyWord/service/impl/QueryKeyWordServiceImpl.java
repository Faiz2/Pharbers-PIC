package pha.com.code.queryKeyWord.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pha.com.code.queryKeyWord.dao.QueryKeyWordMapper;
import pha.com.code.queryKeyWord.model.QueryKeyWord;
import pha.com.code.queryKeyWord.service.QueryKeyWordService;
import pha.com.common.base.service.impl.BaseServiceImpl;

@Service("QueryKeyWordService")
public class QueryKeyWordServiceImpl extends BaseServiceImpl<QueryKeyWord> implements QueryKeyWordService {
	@Resource
	private QueryKeyWordMapper queryKeyWordMapper;

	@Override
	public List<QueryKeyWord> queryByKeyWord(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return queryKeyWordMapper.queryByKeyWord(map);
	}
}
