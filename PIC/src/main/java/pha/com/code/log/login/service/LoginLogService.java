package pha.com.code.log.login.service;

import pha.com.code.log.login.model.LoginLog;
import pha.com.common.base.service.BaseService;

public interface LoginLogService extends BaseService<LoginLog> {
	/**
	 * 根据名字修改字段
	 * @param loginLog
	 * @return
	 */
	public int updateByNameSelective(LoginLog loginLog);
}
