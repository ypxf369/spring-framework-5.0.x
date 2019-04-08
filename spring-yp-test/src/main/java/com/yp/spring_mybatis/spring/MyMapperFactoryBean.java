package com.yp.spring_mybatis.spring;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * Created by yepeng on 2019/04/08.
 */
public class MyMapperFactoryBean implements FactoryBean {
	private Class mapperInterface;

	public MyMapperFactoryBean(Class mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	@Override
	public Object getObject() throws Exception {
		// 返回代理对象
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{mapperInterface}, new MyInvocationHandler());
	}

	@Override
	public Class<?> getObjectType() {
		return mapperInterface;
	}
}
