package pha.com.code.system.controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pha.com.code.system.model.RegisterInfo;
import pha.com.code.system.model.UserInfo;
import pha.com.code.system.service.RegisterInfoService;
import pha.com.code.system.service.UserInfoService;
import pha.com.common.base.controller.BaseController;
import pha.com.common.base.shiro.Encrypt;
import pha.com.common.util.DateUtil;

@Controller
@RequestMapping("/registerInfo") 
public class RegisterInfoController extends BaseController<RegisterInfo>{
	
	@Resource private RegisterInfoService registerInfoService;	
	@Resource private UserInfoService 	userInfoService;
	
	/**
	 * 注册查询类（PIC）用户
	 * @return
	 */
	@RequestMapping(value="registerPICUsers" ,method=RequestMethod.POST ,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public int registerPICUsers(String name,String mobile,String password,String company,String sixcode){
		HttpSession session = getRequest().getSession();
		if(mobile == null && "".equals(mobile)){
			return -1; //登录凭证（手机）为空
		}
		if(sixcode != null && !"".equals(sixcode)){
			//date 如果为NULL的话那就是没有申请验证码，是在生成验证码的时候存入的时间，拿这个时间对比注册时候的时间 获取时间差来判断是否过期
			Date date = session.getAttribute("sms_date"+mobile) != null ? (Date)session.getAttribute("sms_date"+mobile) : null;
			//获取验证码+手机号生成的唯一码
			String uniquecode = session.getAttribute(mobile) != null ? session.getAttribute(mobile).toString() : null;
			//验证用户输入的6位码是否正确
			String temp = new Md5Hash(sixcode,mobile,2).toString();
			if(uniquecode != null){
				String code = session.getAttribute(mobile+sixcode) != null ? session.getAttribute(mobile+sixcode).toString() : null;
				if(code == null || !sixcode.equals(code)){
					return -3;//验证码错误
				}else if(!temp.equals(uniquecode)){
					return -4;//验证码+手机号码的混合加密 错误（该类错误大部分都是因手机号码前后输入不一致导致的）
				}
			}
			if(date == null || DateUtil.getOffsetSeconds(date, new Date()) > 500){
				return -2;//验证码已过期
			}
		}
		//////////保存注册用户信息
		RegisterInfo registerInfo = new RegisterInfo();
		registerInfo.setUsername(mobile);
		registerInfo.setName(name);
		registerInfo.setMobile(mobile);
		registerInfo.setPassword(Encrypt.md5(password, mobile));
		registerInfo.setCompany(company);
		registerInfo.setRegisterdate(new Timestamp(Calendar.getInstance().getTime().getTime()));
		registerInfoService.saveOneSelective(registerInfo);
		////////////////////////////将注册成功后的用户同步生成到UserInfo（用户登录）表
		UserInfo userinfo = new UserInfo();
		userinfo.setLoginName(mobile);
		userinfo.setName(name);
		userinfo.setPassword(Encrypt.md5(password, mobile));
		userinfo.setCompanyName(company);
		userinfo.setTelphone(mobile);
		userinfo.setPhone(mobile);
		userinfo.setCreateDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
		userinfo.setStatus(1);
		userInfoService.saveOneSelective(userinfo);
		//成功插入后清除掉Attribute 防止不正当的方式获取
		session.removeAttribute(mobile);
		session.removeAttribute(mobile+sixcode);
		session.removeAttribute("sms"+mobile);
		return 0;
	}
	
	/**
	 * 核查手机号码是否被注册
	 * @return
	 */
	@RequestMapping(value="verifyMobile" ,method=RequestMethod.POST ,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public int verifyMobile(String mobile){
		//效验手机号码唯一性
		RegisterInfo registerInfo = registerInfoService.findUserByMobile(mobile);
		if(registerInfo != null){
			return -1 ;
		}
		return 0;
	}
	
}
