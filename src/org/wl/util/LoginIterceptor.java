package org.wl.util;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginIterceptor extends AbstractInterceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destory-interceptor");
		super.destroy();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("init-interceptor");
		super.init();
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("interceptor-interceptor");
		
		Map session=ActionContext.getContext().getSession();
		System.out.println(session.get("role"));
		if(session.get("role")==null){
			return "error";
		}else{
		return arg0.invoke();}
	}

}
