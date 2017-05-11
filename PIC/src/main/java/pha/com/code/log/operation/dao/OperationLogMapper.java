package pha.com.code.log.operation.dao;

import pha.com.code.log.operation.model.OperationLog;

public interface OperationLogMapper {
    int deleteByPrimaryKey(Integer operid);

    int insert(OperationLog record);

    int insertSelective(OperationLog record);

    OperationLog selectByPrimaryKey(Integer operid);

    int updateByPrimaryKeySelective(OperationLog record);

    int updateByPrimaryKey(OperationLog record);
}