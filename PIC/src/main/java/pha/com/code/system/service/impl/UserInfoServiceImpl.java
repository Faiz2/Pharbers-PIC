package pha.com.code.system.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pha.com.code.system.dao.UserInfoMapper;
import pha.com.code.system.model.UserInfo;
import pha.com.code.system.service.UserInfoService;
import pha.com.common.base.service.impl.BaseServiceImpl;


@Service("userInfoService")
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo> implements UserInfoService {
	
	@Resource
	private UserInfoMapper userInfoMapper;

	@Override
	public UserInfo findUserByUsername(String username) {
		UserInfo selectByName = userInfoMapper.selectByName(username);
		if(selectByName != null){
			return selectByName;
		}
		return null;
	} 
}
