package pha.com.common.base.filter;

import org.apache.shiro.session.Session;

public class SessionListener implements org.apache.shiro.session.SessionListener{

	@Override
	public void onExpiration(Session arg0) {
		// TODO Auto-generated method stub
		System.out.println("Session异常啦！Session异常啦！Session异常啦！Session异常啦！");
		
	}

	@Override
	public void onStart(Session arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStop(Session arg0) {
		// TODO Auto-generated method stub
		System.out.println("Session关闭啦！Session关闭啦！Session关闭啦！Session关闭啦！");
	}

}
