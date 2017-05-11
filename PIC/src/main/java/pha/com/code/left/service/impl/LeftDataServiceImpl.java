package pha.com.code.left.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pha.com.code.left.dao.LeftDataMapper;
import pha.com.code.left.model.LeftData;
import pha.com.code.left.service.LeftDataService;
import pha.com.common.base.service.impl.BaseServiceImpl;

@Service("LeftDataService")
public class LeftDataServiceImpl extends BaseServiceImpl<LeftData> implements LeftDataService {
	
	@Resource
	private LeftDataMapper leftDataMapper;
	
	@Override
	public List<LeftData> queryByATC1() {
		// TODO Auto-generated method stub
		return leftDataMapper.queryByATC1();
	}

	@Override
	public List<LeftData> queryByATC2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return leftDataMapper.queryByATC2(map);
	}
	
	@Override
	public List<LeftData> queryByATC3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return leftDataMapper.queryByATC3(map);
	}
	
	@Override
	public List<LeftData> queryByGenericName(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return leftDataMapper.queryByGenericName(map);
	}

	@Override
	public List<LeftData> queryByProvince() {
		// TODO Auto-generated method stub
		return leftDataMapper.queryByProvince();
	}

	@Override
	public List<LeftData> queryByProduct() {
		// TODO Auto-generated method stub
		return leftDataMapper.queryByProduct();
	}
	

	@Override
	public List<LeftData> queryByManufactureType() {
		// TODO Auto-generated method stub
		return leftDataMapper.queryByManufactureType();
	}

	@Override
	public List<LeftData> queryByManufacture() {
		// TODO Auto-generated method stub
		return leftDataMapper.queryByManufacture();
	}

	@Override
	public List<LeftData> queryByDosage() {
		// TODO Auto-generated method stub
		return leftDataMapper.queryByDosage();
	}

	@Override
	public List<LeftData> queryBySpecification() {
		// TODO Auto-generated method stub
		return leftDataMapper.queryBySpecification();
	}

	@Override
	public List<LeftData> queryByPackage() {
		// TODO Auto-generated method stub
		return leftDataMapper.queryByPackage();
	}

	@Override
	public List<LeftData> queryByIDALL(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return leftDataMapper.queryByIDALL(map);
	}

	@Override
	public List<LeftData> queryUpperloader(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return leftDataMapper.queryUpperloader(map);
	}

}
