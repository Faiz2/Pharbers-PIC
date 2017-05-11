package pha.com.code.queryKeyWord.service;

import java.util.List;

import pha.com.code.queryKeyWord.model.MedicalForDataInfo;
import pha.com.common.base.service.BaseService;

public interface MedicalForDataInfoService  extends BaseService<MedicalForDataInfo> {
	public List<MedicalForDataInfo> selectByIdnexData();
}
