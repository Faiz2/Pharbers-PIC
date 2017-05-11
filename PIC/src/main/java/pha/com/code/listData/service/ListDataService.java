package pha.com.code.listData.service;


import java.util.List;
import java.util.Map;

import pha.com.code.listData.model.ListData;
import pha.com.code.listData.model.ListDataNoProvince;
import pha.com.common.base.service.BaseService;

public interface ListDataService extends BaseService<ListData> {
	
	public List<ListDataNoProvince> selectByNoProvince(Map<String, Object> excelParameterMap);
}
