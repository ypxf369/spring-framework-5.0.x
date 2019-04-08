package com.yp.spring_mybatis.spring;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yepeng on 2019/04/09.
 */
public class MyInvocationHandler implements InvocationHandler {
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(method.getAnnotation(Select.class).value()[0]);
		// do query
		return null;
	}
}
