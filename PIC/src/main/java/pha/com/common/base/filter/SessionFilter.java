package pha.com.common.base.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;

import pha.com.code.system.model.UserInfo;

public class SessionFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        //HttpSession session = httpRequest.getSession();
        // 登陆url
        //String loginUrl = httpRequest.getContextPath() + "/home/index1";
        String appurl = httpRequest.getRequestURI();
//        String url = httpRequest.getRequestURI();
//        String path = url.substring(url.lastIndexOf("/"));
        // 超时处理，ajax请求超时设置超时状态，页面请求超时则返回提示并重定向
        if (httpRequest.getHeader("x-requested-with") != null && httpRequest.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
        	if(appurl.lastIndexOf("login") > -1 || appurl.lastIndexOf("VerifyLoginServlet") > -1 || appurl.lastIndexOf("StartCaptchaServlet") > -1){
        		chain.doFilter(request, response);
        	}else{
        		UserInfo userInfo = (UserInfo)httpRequest.getSession().getAttribute("user");//SecurityUtils.getSubject().getPrincipal();
        		if(userInfo==null){
        			httpResponse.addHeader("sessionstatus", "timeOut");
        			chain.doFilter(request, httpResponse);
        		}else{
        			chain.doFilter(request, response);
        		}
        	}
        }else{
        	chain.doFilter(request, response);
        }
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
