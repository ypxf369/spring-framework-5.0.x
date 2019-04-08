package com.yp.spring_mybatis.spring;

import com.yp.spring_mybatis.dao.UserDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * Created by yepeng on 2019/04/08.
 */
//@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		GenericBeanDefinition helloDao = (GenericBeanDefinition) beanFactory.getBeanDefinition("helloDao");
		helloDao.setBeanClass(UserDao.class);
	}
}
