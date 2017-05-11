package pha.com.common.base.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import pha.com.common.base.model.BaseModel;
import pha.com.common.base.page.Page;
import pha.com.common.base.service.BaseService;

@Controller
@Lazy
public class BaseController<T extends BaseModel<T>> {
	
	protected ModelAndView mv = this.getModelAndView();
	/**
	 * 得到ModelAndView
	 */
	public ModelAndView getModelAndView(){
		
		return new ModelAndView();
	}
	
	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}

	public BaseService<T> baseService;
	
	/**
	 * 得到BaseService。
	 * 
	 * @return
	 */
	public BaseService<T> getBaseService() {
		return baseService;
	}

	/**
	 * 设置BaseService。
	 * 
	 * @return
	 */
	public void setBaseService(BaseService<T> service) {
		this.baseService = service;
	}
	
	/**
	 * 
	 */
	protected Page<T> page;

	/**
	 * 
	 */
	protected List<T> list = null;
	
	/**
	 * 
	 */
	protected Map<String, Object> resultMap = null;
	
	/**
	 * 
	 */
	protected Map<String, Object> result = null;
	
	/**
	 * 当前Action所负责的主要的业务的实体类。
	 */
	protected T entity = null;
	
	/**
	 * 
	 * @return
	 */
	public T getEntity() {
		return entity;
	}

	/**
	 * 
	 * @param entity
	 */
	public void setEntity(T entity) {
		this.entity = entity;
	}
	
	public Page<T> getPage() {
		return new Page<>(getRequest());
	}


	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	/**
	 * 
	 * @param key
	 * @param value
	 */
	protected void putResult(String key, Object value) {
		if (this.result == null) {
			this.result = new HashMap<String, Object>();
		}
		this.result.put(key, value);
	}
	
	/**
	 * 该注解用于解析前台传过来的日期
	 * @param request
	 * @param binder
	 * @throws Exception
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request,ServletRequestDataBinder binder) throws Exception {
	        // DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        CustomDateEditor dateEditor = new CustomDateEditor(format, true);
	        binder.registerCustomEditor(Date.class, dateEditor);
	}
	
	@RequestMapping(value="/{parm}/{page}")
	public String returnPage(@PathVariable String page,@PathVariable String parm,HttpServletRequest req,HttpServletResponse resp){
		if(parm.indexOf("inf-") > -1){
			String str = parm.substring(parm.indexOf("inf-")+4);
			System.out.println("页面==>>"+"WEB-INF/"+str+"/"+page);
			return "WEB-INF/"+str+"/"+page;
		}
		return parm+"/"+page;
	}
	
	// 没有渲染根路劲（WebRoot加指定首页即可默认渲染）
	/*@RequestMapping("/")
	public ModelAndView turn() {
		return _turn();
	}
	
	@RequestMapping("/index")
	public ModelAndView _turn() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/error/404")
	public ModelAndView _404() {
		return new ModelAndView("common/404");
	}

	@RequestMapping("/error/500")
	public ModelAndView _500() {
		return new ModelAndView("common/500");
	}*/
}
