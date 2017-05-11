package pha.com.code.system.dao;

import pha.com.code.system.model.RegisterInfo;
import pha.com.common.base.dao.BaseDao;

public interface RegisterInfoMapper extends BaseDao<RegisterInfo>{
	/**
	 * 查询该手机号码是否已被注册
	 */
	public RegisterInfo findUserByMobile(String mobile);
	
}