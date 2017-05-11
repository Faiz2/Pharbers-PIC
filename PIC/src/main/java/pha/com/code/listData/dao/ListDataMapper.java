package pha.com.code.listData.dao;

import java.util.List;
import java.util.Map;

import pha.com.code.listData.model.ListData;
import pha.com.code.listData.model.ListDataNoProvince;
import pha.com.common.base.dao.BaseDao;

public interface ListDataMapper extends BaseDao<ListData>{
	
	public List<ListDataNoProvince> selectByNoProvince(Map<String, Object> map);
}