package pha.com.common.base.shiro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;

import com.alibaba.fastjson.JSON;

import pha.com.code.system.model.UserInfo;
import pha.com.code.system.service.UserInfoService;

/**
* 	<p>Title: AuthRealm</p>
* 	<p>Description: shiro登录认证和权限设置</p>
* 	<p>Company: pharbers</p>
* 	@author ylk
* 	@date 2016年7月12日
 */
public class AuthRealm extends AuthorizingRealm {
	
	@Resource
	private UserInfoService userInfoService;
	
	
	/*@Resource
	ModuleService moduleService;*/
	
	//授权 判断是否有权限     PrincipalCollection参数保存了当前的用户对象
	@SuppressWarnings("unchecked")
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//1.得到用户信息
		/*UserInfo user = (UserInfo)principals.fromRealm(getName()).iterator().next();*/
		//2.加载用户的权限列表
		List<String> list = new ArrayList<String>();
		//得到当前用户的角色
		/*List<Map<String, Object>> moduleAndUser = moduleService.queryCurrentlyUserAuth(Integer.parseInt(user.getId().toString()));
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
		}*/
		
		Subject subject = SecurityUtils.getSubject();
		list = JSON.parseArray(subject.getSession().getAttribute("AuthList").toString(), String.class);
		
		//3.分配权限列表
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(list);
		return info;
	}

	//认证-----------登录-----------根据用户名，查到相应的用户，这样就可以得到在数据库中保存密码
	//下一步交给<property name="credentialsMatcher" ref="passwordMatcher"/>所对应的加密码的类进行比较
	//程序会将登录时用户输入的明文通过加密算法加密，再与数据库中密码进行比较，这个比较工作就由CustomCredentialsMatcher.java类进行处理
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		//1.得参数token转化为它的子类，再得到用户名
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();//得到了用户在文本框输入的用户名

//		Collection<Session> sessions = sessionDAO.getActiveSessions();
//		if(sessions.size() > 0){
			//apache shiro获取所有在线用户  
	        /*for(Session session:sessions){  
	            String loginUsername = String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));//获得session中已经登录用户的名字  
	        	System.out.println(loginUsername);
	            if(username.equals(loginUsername)){  //这里的username也就是当前登录的username  
	                session.setTimeout(0);  //这里就把session清除，  
	                  
	            }  
	        } */
			/*Iterator it = sessions.iterator();
			while(it.hasNext()){
				Session session = (Session) it.next();
				if(session.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY") != null){
					String str = session.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY").toString();
					System.out.println(str);
				}
			}*/
//		}
		//2.调用业务逻辑，根据用户名查询一个用户对象
		UserInfo user = userInfoService.findUserByUsername(username);
		
		//3.判断是否成功
		if(user == null){
		    return null;
		}else{
			//得到当前这个Realm的名字
			AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());//进一步验证密码
			return info;
		}
	}
}
