package com.yp.test;

import com.yp.AppConfig;
import com.yp.spring_mybatis.dao.mapper.TestDao;
import com.yp.spring_mybatis.dao.mapper.TestDao1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yepeng on 2019/04/08.
 */
public class SpringMybatisTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		TestDao1 ypDao = (TestDao1)context.getBean("testDao1");
		ypDao.query();

//		System.out.println(context.getBean("ypDao").getClass().getSimpleName());
	}
}
