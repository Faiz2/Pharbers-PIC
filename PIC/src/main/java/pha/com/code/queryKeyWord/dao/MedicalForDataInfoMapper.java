package pha.com.code.queryKeyWord.dao;

import java.util.List;

import pha.com.code.queryKeyWord.model.MedicalForDataInfo;
import pha.com.common.base.dao.BaseDao;

public interface MedicalForDataInfoMapper  extends BaseDao<MedicalForDataInfo>{
   public List<MedicalForDataInfo> selectByIdnexData();
}