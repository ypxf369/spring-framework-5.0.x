package com.yp.myPostProcesser;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by yepeng on 2019/04/08.
 */
//@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
	/**
	 * 目标对象实例化之前调用
	 * 可以返回代理对象代替原有对象
	 */
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		if (beanName.equals("userServerImpl2")) {
			System.out.println("postProcessBeforeInstantiation 方法调用了");
			// 创建代理对象并返回
//			return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> {
//				System.out.println(proxy);
//				return method.invoke(beanClass.newInstance(), args);
//			});
			try {
				return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(),new UserServerImpl2InvocationHandler(beanClass.newInstance()));
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 目标对象实例化之后调用
	 * true,按照正常的流程走，false，忽略目标对象的属性值得设置
	 */
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInstantiation 方法调用了");
		return true;
	}

	/**
	 * 对目标对象的属性值进行修改
	 */
	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
		System.out.println("postProcessPropertyValues 方法调用了");
		return null;
	}

	/**
	 * 在目标对象被实例化之后，属性值设置之后进行调用
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization 方法调用了");
		return null;
	}

	/**
	 * 在目标对象被实例化之后，属性值设置之后进行调用
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization 方法调用了");
		return null;
	}
}
