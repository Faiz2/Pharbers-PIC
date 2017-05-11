package pha.com.code.log.login.dao;

import pha.com.code.log.login.model.LoginLog;
import pha.com.common.base.dao.BaseDao;

public interface LoginLogMapper extends BaseDao<LoginLog>{
	/**
	 * 根据名字修改字段
	 * @param loginLog
	 * @return
	 */
	public int updateByNameSelective(LoginLog loginLog);
}