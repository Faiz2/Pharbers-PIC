package pha.com.code.report.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pha.com.code.report.model.ListDataOne;
import pha.com.code.report.dao.MedicalSalesDataMapper;
import pha.com.code.report.model.ManuType;
import pha.com.code.report.model.MedicalSalesData;
import pha.com.code.report.service.MedicalSalesDataService;
import pha.com.common.base.service.impl.BaseServiceImpl;

@Service("MedicalSalesDataService")
public class MedicalSalesDataServiceImpl extends BaseServiceImpl<MedicalSalesData> implements MedicalSalesDataService {
	@Resource
	private MedicalSalesDataMapper medicalSalesDataMapper;

	@Override
	public Integer queryByQueryIsMAT(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return medicalSalesDataMapper.selectByQueryIsMAT(map);
	}

	@Override
	public Integer selectByQueryYearIsNULL(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return medicalSalesDataMapper.selectByQueryYearIsNULL(map);
	}

	@Override
	public List<MedicalSalesData> queryByYear5Counts(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return medicalSalesDataMapper.selectByYear5Counts(map);
	}

	@Override
	public List<MedicalSalesData> queryByReportLjxsZzlYear(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return medicalSalesDataMapper.selectByReportLjxsZzlYear(map);
	}

	@Override
	public List<MedicalSalesData> queryByReportSczbYear(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return medicalSalesDataMapper.selectByReportSczbYear(map);
	}

	@Override
	public List<MedicalSalesData> queryByReportFhzzlYear(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return medicalSalesDataMapper.selectByReportFhzzlYear(map);
	}

	@Override
	public List<ManuType> queryByReportXsbx(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return medicalSalesDataMapper.selectByReportXsbx(map);
	}

	@Override
	public List<ManuType> queryByAtcXsZb(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return medicalSalesDataMapper.selectByAtcXsZb(map);
	}

	@Override
	public List<ManuType> queryByMinniUnitXseZb(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return medicalSalesDataMapper.selectByMinniUnitXseZb(map);
	}

	@Override
	public List<ManuType> queryByTop10Xsze(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return medicalSalesDataMapper.selectByTop10Xsze(map);
	}

	@Override
	public List<ManuType> queryByTop10XszeZb(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return medicalSalesDataMapper.selectByTop10XszeZb(map);
	}

	@Override
	public List<ManuType> queryByTop10Xszl(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return medicalSalesDataMapper.selectByTop10Xszl(map);
	}

	@Override
	public List<ManuType> queryByTop10XseZb(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return medicalSalesDataMapper.selectByTop10XseZb(map);
	}

	@Override
	public List<ListDataOne> selectByYearGroup(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return medicalSalesDataMapper.selectByYearGroup(map);
	}

	@Override
	public List<ListDataOne> selectTop10ListDataOne(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return medicalSalesDataMapper.selectTop10ListDataOne(map);
	}
}
