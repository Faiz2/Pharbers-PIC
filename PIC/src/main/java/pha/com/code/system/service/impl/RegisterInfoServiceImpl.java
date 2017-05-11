package pha.com.code.system.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pha.com.code.system.dao.RegisterInfoMapper;
import pha.com.code.system.model.RegisterInfo;
import pha.com.code.system.service.RegisterInfoService;
import pha.com.common.base.service.impl.BaseServiceImpl;


@Service("registerInfoService")
public class RegisterInfoServiceImpl extends BaseServiceImpl<RegisterInfo> implements RegisterInfoService {

	@Resource private RegisterInfoMapper registerInfoMapper;
	
	@Override
	public RegisterInfo findUserByMobile(String mobile) {
		// TODO Auto-generated method stub
		return registerInfoMapper.findUserByMobile(mobile);
	}

}
