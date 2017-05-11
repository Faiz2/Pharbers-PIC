package pha.com.code.system.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import pha.com.annotation.*;

import pha.com.code.system.model.UserInfo;
import pha.com.code.system.service.ModuleService;
import pha.com.code.system.service.UserInfoService;
import pha.com.common.base.controller.BaseController;
import pha.com.common.base.page.Page;
import pha.com.common.base.shiro.Encrypt;

@Controller
@RequestMapping("/userInfo") 
public class UserInfoController extends BaseController<UserInfo>{
	@Resource
	private UserInfoService userService;
	@Resource
	private ModuleService moduleService;

	/**
	 * 登录验证
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/login" ,method=RequestMethod.POST ,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	@SystemControllerAfterLog(description = "用户登入")
	/*@SystemServiceLog(description = "用户登录")*/
	public String login(String userName,String password){
		getRequest().setAttribute("loginName", userName);
		try {
			 String message = "";
			 UserInfo findUserByUsername = userService.findUserByUsername(userName);
			if(findUserByUsername == null){
				message = "{\"flag\":\"no\",\"messager\":\"不存在此用户\"}";
				return message;
			}else if(findUserByUsername.getStatus() == 0){
				message = "{\"flag\":\"no\",\"messager\":\"对不起，此用户未激活。\"}";
				return message;
			}else{
				//1.得到Subject
				Subject subject = SecurityUtils.getSubject();
				//2.调用login（）方法，实现登录功能,此时将自动调用 AuthRealm.doGetAuthenticationInfo()来实现登录的判断
				UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
				subject.login(token);
				token.clear();
				//3.从realm得到用户信息
				UserInfo userInfo = (UserInfo) subject.getPrincipal();
				boolean flag = true;
				//2.加载用户的权限列表
				List<String> list = new ArrayList<String>();
				List<Map<String, Object>> moduleAndUser = moduleService.queryCurrentlyUserAuth(Integer.parseInt(userInfo.getId().toString()));
				for (Map<String, Object> map : moduleAndUser) {
					if(map.containsKey("mname")){
						list.add(map.get("mname").toString());
					}else{
						String[] strArray = map.get("spare1").toString().split("-");
						if("qy".equals(strArray[1])){
							list.add(strArray[0]+"-"+strArray[1]);
							if(flag){
								list.add("qy");
							}
							flag = false;
						}
					}
				}
				subject.getSession().setAttribute("AuthList", JSON.toJSONString(list));
				subject.getSession().setAttribute("user", userInfo);
				if("admin".equals(userInfo.getLoginName())){
					return "{\"flag\":\"yes\",\"isManager\":\"true\",\"messager\":\"管理员登录\"}";
				}else{
					return "{\"flag\":\"yes\",\"isManager\":\"false\",\"messager\":\"普通用户登录\"}";
				}
			}
		} catch (Exception e) {
			return "{\"flag\":\"no\",\"messager\":\"用户名或密码错误\"}";
		}
	}
	
	/**
	 * 查询所有用户
	 * @return
	 */
	@RequestMapping(value="queryUserAll" ,method=RequestMethod.POST ,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public  Page<UserInfo> queryUserAll(){
		this.page = getPage();
		this.page = userService.queryByPage(this.page);
		return this.page;
	}
	
	/**
	 * 删除单个用户
	 * @param id
	 * @return
	 */
	@RequestMapping(value="deleteById" ,method=RequestMethod.POST )
	@ResponseBody
	public int deleteById(Integer id){
		 return userService.deleteOneByID(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="deleteByIds" ,method=RequestMethod.POST )
	@ResponseBody
	public int deleteByIds(@RequestParam(value = "ids[]") Integer[] ids){
		return userService.deleteArrayByID(ids);
	}
	
	/**
	 * 新增或修改用户
	 * @return
	 */
	@RequestMapping(value="saveOrUpdate" ,method=RequestMethod.POST ,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public int saveOrUpdate(@RequestBody UserInfo entity){
		if(entity.getId() == null){
			//校验用户名是否唯一
			UserInfo existName = userService.findUserByUsername(entity.getLoginName());
			if(existName != null){
				return 6;
			}
			//新增用户为用户添加初始密码
			entity.setCreateDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
			entity.setPassword(Encrypt.md5(Encrypt.DEFAULT_PASSWORD, entity.getLoginName()));
		}else{
			entity.setUpdateDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
		}
		
		int saveOne = userService.saveOne(entity);
		return saveOne;
	}
	
	/**
	 * 退出登陆
	 * @return
	 */
	@RequestMapping(value="logout" ,method=RequestMethod.POST )
	@ResponseBody
	@SystemControllerLog(description = "用户登出")
	@SystemServiceLog(description = "用户登出")
	public String logout() {
	    Subject subject = SecurityUtils.getSubject();
	    if (subject.isAuthenticated()) {  
	        subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
	        return "ok";
	    }
		return "no";  
	}  
}
