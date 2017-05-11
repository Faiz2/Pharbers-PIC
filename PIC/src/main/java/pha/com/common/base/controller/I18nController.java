package pha.com.common.base.controller;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;

@Controller
public class I18nController{

	@Autowired
    private LocaleResolver localeResolver;  

	
	@SuppressWarnings("finally")
	@RequestMapping(value="language/{i18nType}/{page}")
	public String ChangeI18n(@PathVariable String i18nType,@PathVariable String page,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		Locale currentLocale = null;  
		try{
			if(i18nType.equals("cn")){
				currentLocale = new Locale("zh", "CN");  
			}else if(i18nType.equals("us")){
				currentLocale = new Locale("en", "US");  
			}
			localeResolver.setLocale(req, resp,currentLocale);  
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//req.getSession().setAttribute("languagei18", i18nType);
			return "/WEB-INF/home/"+page;
		}		
	}
}
