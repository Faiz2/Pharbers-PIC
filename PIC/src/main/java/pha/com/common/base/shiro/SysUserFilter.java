package pha.com.common.base.shiro;

import pha.com.code.system.model.UserInfo;
import pha.com.code.system.service.UserInfoService;
import pha.com.common.util.FinalUtil;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-15
 * <p>Version: 1.0
 */
public class SysUserFilter extends PathMatchingFilter {

	@Resource
	private UserInfoService userInfoService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
    	UserInfo u= (UserInfo) SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(FinalUtil.CURRENT_USER, userInfoService.findUserByUsername(u.getLoginName()));
        return true;
    }
}
