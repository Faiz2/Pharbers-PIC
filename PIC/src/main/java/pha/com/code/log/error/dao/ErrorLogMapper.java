package pha.com.code.log.error.dao;

import pha.com.code.log.error.model.ErrorLog;

public interface ErrorLogMapper {
    int deleteByPrimaryKey(Integer logid);

    int insert(ErrorLog record);

    int insertSelective(ErrorLog record);

    ErrorLog selectByPrimaryKey(Integer logid);

    int updateByPrimaryKeySelective(ErrorLog record);

}