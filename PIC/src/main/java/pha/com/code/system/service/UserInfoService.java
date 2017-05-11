package pha.com.code.system.service;

import pha.com.code.system.model.UserInfo;
import pha.com.common.base.service.BaseService;

public interface UserInfoService  extends BaseService<UserInfo>{

	/**
	 * 根据用户名，查询一个用户对象
	 */
	public UserInfo findUserByUsername(String username);
}
