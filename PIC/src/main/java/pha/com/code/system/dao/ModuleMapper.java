package pha.com.code.system.dao;

import java.util.List;
import java.util.Map;

import pha.com.code.system.model.Module;
import pha.com.common.base.dao.BaseDao;

public interface ModuleMapper extends BaseDao<Module>{

	/**
	 * 查询全部权限
	 * @return 
	 */
	public List<Module> queryAuthTree();

	/**
	 * 查询用户已存在的权限
	 * @param userId
	 * @return
	 */
	public List<Map<String, Object>> queryCheckAuth(Integer userId);

	/**
	 * 删除指定用户已存在的权限
	 * @param userId
	 */
	public int deleteModuleAndUserAuth(Integer userId);

	/**
	 * 保存指定用户的权限关系
	 * @param userId
	 * @return 
	 */
	public int insertModuleAndUserAuth( Map<String, List<Map<String, String>>> authNodes);

	/**
	 * 查询当前用户的所有权限
	 * @param userId
	 * @return 
	 */
	public List<Map<String, Object>> queryCurrentlyUserAuth(Integer userId);

	/**
	 * 查询用户的省份权限
	 * @return
	 */
	public List<Map<String, Object>> queryProvince();

	/**
	 * 检查模块名是否已经存在
	 * @param mname 模块名 模块类型 模块所属数据库
	 * @return
	 */
	public Integer queryByName(Map<String, Object> mname);
	
}