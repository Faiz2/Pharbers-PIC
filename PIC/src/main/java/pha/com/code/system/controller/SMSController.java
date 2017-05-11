package pha.com.code.system.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.show.api.ShowApiRequest;

import pha.com.code.system.model.RegisterInfo;
import pha.com.common.base.controller.BaseController;
import pha.com.common.util.DateUtil;
import pha.com.common.util.SixCode;

@Controller
@RequestMapping("/SMS") 
public class SMSController extends BaseController<RegisterInfo>{
	
	@RequestMapping(value="SMSInfo" ,method=RequestMethod.POST ,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String SMSInfo(String mobile,String name){
//		AlibabaAliqinFcSmsNumSendResponse rsp = null;
		try {
			String code = SixCode.getSix();//获取6位数字
//			TaobaoClient client = new DefaultTaobaoClient(FinalUtil.SMS_URL, FinalUtil.SMS_APPKEY, FinalUtil.SMS_SECRET);
//			AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
//			req.setSmsType(FinalUtil.SMS_TYPE);
//			req.setSmsFreeSignName(FinalUtil.SMS_FREE_SIGNNAME);
//			req.setSmsParamString("{\"name\":\"Faiz\",\"company\":\"北京砝码科技\",\"code\":\""+code+"\"}");
//			req.setRecNum(mobile);
//			req.setSmsTemplateCode(FinalUtil.SMS_TEMPLATE_CODE);
//			rsp = client.execute(req);
			String res = new ShowApiRequest("http://route.showapi.com/28-1", "24131", "9c22067bb6814864a53e8d537d3dc21d")
					.addTextPara("mobile",mobile)
		            .addTextPara("content","{name:'"+name+"',code:'"+code+"',minute:'5'}")
		            .addTextPara("sendTime",DateUtil.format(new Date(), DateUtil.PATTERN_CLASSICAL))
		            .addTextPara("tNum","T160905000543")
					.post();
			String uniquecode = new Md5Hash(code,mobile,2).toString();//6位数验证码+手机号的加密成唯一码（参数1  原：密码，在这里为 6位的验证码，参数2 原：登录名 ，这里一样）
			HttpSession session = getRequest().getSession();
			session.setAttribute(mobile, uniquecode);
			session.setAttribute(mobile+code, code);
			session.setAttribute("sms_date"+mobile, new Date());
			System.out.println(code);
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return "no";
		}
	}
}
