package pha.com.code.queryKeyWord.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pha.com.code.queryKeyWord.dao.MedicalForDataInfoMapper;
import pha.com.code.queryKeyWord.model.MedicalForDataInfo;
import pha.com.code.queryKeyWord.service.MedicalForDataInfoService;
import pha.com.common.base.service.impl.BaseServiceImpl;

@Service("MedicalForDataInfoService")
public class MedicalForDataInfoServiceImpl extends BaseServiceImpl<MedicalForDataInfo> implements MedicalForDataInfoService {

	@Resource
	private MedicalForDataInfoMapper medicalForDataInfoMapper; 
	
	@Override
	public List<MedicalForDataInfo> selectByIdnexData() {
		return medicalForDataInfoMapper.selectByIdnexData();
	}

}
