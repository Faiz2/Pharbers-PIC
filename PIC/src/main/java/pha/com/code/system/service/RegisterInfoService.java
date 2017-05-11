package pha.com.code.system.service;

import pha.com.code.system.model.RegisterInfo;
import pha.com.common.base.service.BaseService;

public interface RegisterInfoService  extends BaseService<RegisterInfo>{

	/**
	 * 查询该手机号码是否已被注册
	 */
	public RegisterInfo findUserByMobile(String mobile);
}
