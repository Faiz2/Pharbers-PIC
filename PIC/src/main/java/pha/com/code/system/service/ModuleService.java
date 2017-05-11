package pha.com.code.system.service;

import java.util.List;
import java.util.Map;

import pha.com.code.system.model.Module;
import pha.com.common.base.service.BaseService;

public interface ModuleService extends BaseService<Module>{

	/**
	 * 查询所有权限
	 * @return
	 */
	List<Module> queryAuthTree();
	
	/**
	 * 查询用户已存在的权限
	 * @param userId
	 * @return
	 */
	List<Map<String, Object>> queryCheckAuth(Integer userId);
	
	/**
	 * 查询用户的省份权限
	 * @return
	 */
	List<Map<String, Object>> queryProvince();

	/**
	 * 删除指定用户已存在的权限
	 * @param userId
	 * @return 
	 */
	public int deleteModuleAndUserAuth(Integer userId);

	/**
	 * 保存指定用户的权限关系
	 * @param userId
	 * @param include 
	 * @return 
	 */
	public int insertModuleAndUserAuth( Map<String, List<Map<String, String>>> include);

	/**
	 * 查询当前用户的所有权限
	 * @param userId
	 * @return 
	 */
	List<Map<String, Object>> queryCurrentlyUserAuth(Integer userId);

	/**
	 * 检查模块名是否已经存在
	 * @param mname 模块名 模块类型 模块所属数据库
	 * @return
	 */
	Integer queryByName(Map<String, Object> map);

}
