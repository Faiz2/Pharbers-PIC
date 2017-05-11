package pha.com.code.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pha.com.code.system.model.Module;
import pha.com.code.system.service.ModuleService;
import pha.com.common.base.controller.BaseController;
import pha.com.common.base.page.Page;

@Controller
@RequestMapping("/module") 
public class ModuleController  extends BaseController<Module>{
	@Resource
	ModuleService moduleService;
	/**
	 * 查询所有模块
	 * @return
	 */
	@RequestMapping(value="queryModuleAll" ,method=RequestMethod.POST ,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public  Page<Module> queryUserAll(){
		this.page = getPage();
		this.page = moduleService.queryByPage(this.page);
		return this.page;
	}
	
	/**
	 * 删除单个模块
	 * @param id
	 * @return
	 */
	@RequestMapping(value="deleteById" ,method=RequestMethod.POST )
	@ResponseBody
	public int deleteById(Integer id){
		 return moduleService.deleteOneByID(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="deleteByIds" ,method=RequestMethod.POST )
	@ResponseBody
	public int deleteByIds(@RequestParam(value = "ids[]") Integer[] ids){
		return moduleService.deleteArrayByID(ids);
	}
	
	/**
	 * 新增或修改模块
	 * @return
	 */
	@RequestMapping(value="saveOrUpdate" ,method=RequestMethod.POST ,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public int saveOrUpdate(@RequestBody Module entity){
		if(entity.getMid() != null){
			entity.setId(Long.parseLong(entity.getMid().toString()));
		}else{
			Map<String, Object> map = new HashMap<>();
			map.put("mname", entity.getMname());
			map.put("did", entity.getDid());
			map.put("mtype", entity.getMtype());
			Integer existName = moduleService.queryByName(map);
			if(existName > 0){
				return 6;
			}
		}
		int saveOne = moduleService.saveOneSelective(entity);
		return saveOne;
	}
	
	/**
	 * 查询权限树
	 */
	
	@RequestMapping(value="queryAuthTree" ,method=RequestMethod.POST ,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String queryAuthTree(Integer userId){
		List<Module> moduleList = moduleService.queryAuthTree();
		List<Map<String, Object>> moduleAndUser = moduleService.queryCheckAuth(userId);
		
		StringBuilder sb = new StringBuilder();
		int size = moduleList.size();
		sb.append("[{");
		if(moduleList.size() > 0){
			//所属数据库id
			Integer tempDid = moduleList.get(0).getDid();
			//所属数据库名称
			String tempDatabaseName = moduleList.get(0).getDatabaseName();
			sb.append("id:\"").append(tempDid).append("\",");
			sb.append("text:\"").append(tempDatabaseName).append("\",");
			//拼装权限树
			sb.append("items:[");
			for (int i = 0; i < moduleList.size(); i++) {
				size -- ;
				//此if在判断是否是其他的数据库
				if(tempDid != moduleList.get(i).getDid()){
					if(size > 0){
						sb.append("]},");
					}else{
						sb.append("]}");
					}
					tempDid = moduleList.get(i).getDid();
					tempDatabaseName = moduleList.get(i).getDatabaseName();
					sb.append("{");
					sb.append("id:\"").append(tempDid).append("\",");
					sb.append("text:\"").append(tempDatabaseName).append("\",");
					sb.append("items:[");
				}
				
				sb.append("{");
				sb.append("id:\"");
				sb.append(moduleList.get(i).getMid()).append("\",");
				sb.append("pid:\"").append(tempDid);
				sb.append("\",text:\"");
				if(moduleList.get(i).getMtype() == 0){ //搜索框
					sb.append(moduleList.get(i).getMname()).append("[搜索框]").append("\"");
					//获取省份
					if("区域".equals(moduleList.get(i).getMname())){
						List<Map<String, Object>> province = moduleService.queryProvince();
						//获取省份中已经存在的权限，并选中。
						int provinceSize = province.size();
						if(provinceSize > 0){
							sb.append(",items:[");
							for (int k = 0; k < province.size(); k++) {
								provinceSize -- ;
								sb.append("{id:\"");
								sb.append(province.get(k).get("provinceid")).append("\",");
								sb.append("text:\"");
								sb.append(province.get(k).get("provincename")).append("\",");
								sb.append("flag:\""+province.get(k).get("provincename")+"").append("\"");
								for (int j = 0; j < moduleAndUser.size(); j++) {
									if(moduleAndUser.get(j).get("spare1") != null){
										String pId = moduleAndUser.get(j).get("spare1").toString().split("-")[2];
										System.out.println(province.get(k).get("provinceid"));
										if(pId.equals(province.get(k).get("provinceid").toString())){
											sb.append(",checked:\"").append("true").append("\"");
										}
									}
								}
								sb.append("}");
								if(provinceSize > 0){
										sb.append(",");
								}
							}
							sb.append("]");
						}
					}
				}else{//按钮
					sb.append(moduleList.get(i).getMname()).append("[按钮]").append("\"");
				}
				
				//获取已经存在的权限，并选中。
				for (int j = 0; j < moduleAndUser.size(); j++) {
					moduleAndUser.get(j).get("mid");
					if(moduleAndUser.get(j).get("mid") == moduleList.get(i).getMid()){
						sb.append(",checked:\"").append("true").append("\"");
					}
				}
				sb.append("}");
				if(size > 0){
					if(i < moduleList.size()){
						if(moduleList.get(i).getDid() == moduleList.get(i+1).getDid()){
							sb.append(",");
						}
					}
				}
			}
		}
		sb.append("]}]");
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	/**
	 * 根据用户id分配权限
	 * @param userId  用户id
	 * @param checkedAuthNodes  需要分配的权限id
	 */
	@RequestMapping(value="saveAllotAuth" ,method=RequestMethod.POST )
	@ResponseBody
	public int saveAllotAuth(Integer userId, @RequestParam(value = "checkedAuthNodes[]") String[] checkedAuthNodes){
		moduleService.deleteModuleAndUserAuth(userId);
		List<Map<String , String>> list = new ArrayList<Map<String , String>>();  
		Map<String, List<Map<String , String>>> include = new HashMap<String, List<Map<String , String>>>();  
		int insertModuleAndUserAuth = 0;
		if(checkedAuthNodes.length > 0){
			for (int i = 0; i < checkedAuthNodes.length; i++) {
					Map<String , String> params = new HashMap<String , String>();
					params.put("userId", userId.toString());  
					if(checkedAuthNodes[i].contains("qy")){
						params.put("province", checkedAuthNodes[i] );  
					}else{
						params.put("checkedAuthNodes", checkedAuthNodes[i] );  
					}
					list.add(params);
			}
			include.put("listAuth", list);  
			insertModuleAndUserAuth = moduleService.insertModuleAndUserAuth(include);
		}
		return insertModuleAndUserAuth;
	}
}
