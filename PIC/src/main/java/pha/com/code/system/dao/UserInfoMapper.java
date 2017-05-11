package pha.com.code.system.dao;

import pha.com.code.system.model.UserInfo;
import pha.com.common.base.dao.BaseDao;

public interface UserInfoMapper extends BaseDao<UserInfo>{
	public UserInfo selectByName(String username);
}