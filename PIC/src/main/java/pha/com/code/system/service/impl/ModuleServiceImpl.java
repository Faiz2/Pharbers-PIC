package pha.com.code.system.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pha.com.code.system.dao.ModuleMapper;
import pha.com.code.system.model.Module;
import pha.com.code.system.service.ModuleService;
import pha.com.common.base.service.impl.BaseServiceImpl;


@Service("moduleService")
public class ModuleServiceImpl extends BaseServiceImpl<Module> implements ModuleService {
	@Resource
	private ModuleMapper moduleMapper;
	
	/**
	 * 查询所有权限
	 * @return
	 */
	@Override
	public List<Module> queryAuthTree() {
		return moduleMapper.queryAuthTree();
	}

	/**
	 * 查询用户已存在的权限
	 * @param userId
	 * @return
	 */
	@Override
	public List<Map<String, Object>> queryCheckAuth(Integer userId) {
		// TODO Auto-generated method stub
		return moduleMapper.queryCheckAuth(userId);
	}

	/**
	 * 删除指定用户已存在的权限
	 * @param userId
	 */
	@Override
	public int deleteModuleAndUserAuth(Integer userId) {
		return moduleMapper.deleteModuleAndUserAuth(userId);
	}

	/**
	 * 保存指定用户的权限关系
	 * @param userId
	 * @return 
	 */
	@Override
	public int insertModuleAndUserAuth( Map<String, List<Map<String, String>>> authNodes) {
		return moduleMapper.insertModuleAndUserAuth( authNodes);
	}

	/**
	 * 查询当前用户的所有权限
	 * @param userId
	 * @return 
	 */
	@Override
	public List<Map<String, Object>> queryCurrentlyUserAuth(Integer userId) {
		return moduleMapper.queryCurrentlyUserAuth(userId);
	}

	/**
	 * 查询用户的省份权限
	 * @return
	 */
	@Override
	public List<Map<String, Object>> queryProvince() {
		return moduleMapper.queryProvince();
	}

	/**
	 * 检查模块名是否已经存在
	 * @param mname 模块名
	 * @return
	 */
	@Override
	public Integer queryByName(Map<String, Object> mname) {
		return moduleMapper.queryByName(mname);
	}
}
