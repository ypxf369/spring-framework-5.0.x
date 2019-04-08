package com.yp.myPostProcesser;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yepeng on 2019/04/08.
 */
public class UserServerImpl2InvocationHandler implements InvocationHandler {
	private Object target;

	public UserServerImpl2InvocationHandler(Object object) {
		this.target = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理对象执行方法");
		return method.invoke(target, args);
	}
}
