package pha.com.code.listData.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pha.com.code.listData.dao.ListDataMapper;
import pha.com.code.listData.model.ListData;
import pha.com.code.listData.model.ListDataNoProvince;
import pha.com.code.listData.service.ListDataService;
import pha.com.common.base.service.impl.BaseServiceImpl;

@Service("ListDataService")
public class ListDataServiceImpl extends BaseServiceImpl<ListData> implements ListDataService{
	
	@Resource
	private ListDataMapper listDataMapper;

	@Override
	public List<ListDataNoProvince> selectByNoProvince(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return listDataMapper.selectByNoProvince(map);
	}
}
