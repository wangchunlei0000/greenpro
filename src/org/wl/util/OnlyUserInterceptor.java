package org.wl.util;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class OnlyUserInterceptor extends MethodFilterInterceptor {


	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Map session=ActionContext.getContext().getSession();
		if("0".equals(session.get("role"))){
			return arg0.invoke();
		}else{
		return "error";
		}
	}

}
