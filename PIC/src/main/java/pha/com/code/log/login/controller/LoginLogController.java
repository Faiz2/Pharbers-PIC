package pha.com.code.log.login.controller;



import javax.annotation.Resource;
import javax.ws.rs.ext.ParamConverter.Lazy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pha.com.code.log.login.model.LoginLog;
import pha.com.code.log.login.service.LoginLogService;
import pha.com.common.base.controller.BaseController;
import pha.com.common.util.DateUtil;

@Controller
@Lazy
@RequestMapping("/loginLog")
public class LoginLogController extends BaseController<LoginLog> {
	@Resource
	private LoginLogService loginLogService;
	
	/**
	 * Set查询条件
	 * @param entity
	 */
	private void setPageParameter(LoginLog entity){
		this.page = getPage();
		if(entity.getFilter() != null){
			for (int i = 0; i < entity.getFilter().getFilters().size(); i++) {
				switch (entity.getFilter().getFilters().get(i).getField()) {
					case "loginname":
						this.page.put("interatc1id", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
					case "loginstart":
						this.page.put("interatc2id", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
					case "loginend":
						this.page.put("interatc3id", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
					case "timesum":
						this.page.put("dosageformid", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
					case "logintype":
						this.page.put("genericnameid", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
					case "ip":
						this.page.put("genericnameid", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
				}
			}
		}
	}
	
	/**
	 * 查询登录日志
	 * @return
	 */
	@RequestMapping(value = "query")
	public ModelAndView query(){
//		this.page = getPage();
//		this.page = loginLogService.queryByPage(page);
		this.list = loginLogService.queryAll();
		for (int i = 0; i < list.size(); i++) {
			//秒
			if(list.get(i).getLoginend() != null){
				int temp = DateUtil.getOffsetSeconds(list.get(i).getLoginstart(),list.get(i).getLoginend());
				String t = "秒";
				if(temp > 60){//大于60秒换成分钟数
					temp = DateUtil.getOffsetMinutes(list.get(i).getLoginstart(),list.get(i).getLoginend());
					t = "分";
					if(temp > 60){//大于60分换成小时数
						temp = DateUtil.getOffsetHours(list.get(i).getLoginstart(),list.get(i).getLoginend());
						t = "小时";
					}
				}
				list.get(i).setTimesum("约"+temp+t);
			}else{
				list.get(i).setTimesum("");
			}
		}
		mv.addObject("list", list);
		mv.setViewName("/admin/LoginLog");
		return mv;
	}
	
	
}
