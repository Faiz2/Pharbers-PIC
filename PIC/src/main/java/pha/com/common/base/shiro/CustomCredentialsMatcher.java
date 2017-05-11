package pha.com.common.base.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
* 	<p>Title: CustomCredentialsMatcher</p>
* 	<p>Description: 对密码进行比较</p>
* 	<p>Company: pharbers</p>
* 	@author ylk
* 	@date 2016年7月12日
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		UsernamePasswordToken usertoken = (UsernamePasswordToken) token; 
		
		Object tokenCredentials = Encrypt.md5(String.valueOf(usertoken.getPassword()),usertoken.getUsername());  
		Object accountCredentials = getCredentials(info);  

		//将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false  
		return equals(tokenCredentials, accountCredentials);  
	}
}
