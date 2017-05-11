package pha.com.code.log.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pha.com.code.log.login.dao.LoginLogMapper;
import pha.com.code.log.login.model.LoginLog;
import pha.com.code.log.login.service.LoginLogService;
import pha.com.common.base.service.impl.BaseServiceImpl;

@Service("LoginLogService")
public class LoginLogServiceImpl extends BaseServiceImpl<LoginLog> implements LoginLogService {
	@Resource
	private LoginLogMapper loginLogMapper;

	@Override
	public int updateByNameSelective(LoginLog loginLog) {
		// TODO Auto-generated method stub
		return loginLogMapper.updateByNameSelective(loginLog);
	}
}
