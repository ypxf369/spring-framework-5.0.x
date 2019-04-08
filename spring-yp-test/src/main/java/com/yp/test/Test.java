package com.yp.test;

import com.yp.AppConfig;
import com.yp.myPostProcesser.UserService;
import com.yp.service.UserDao;
import com.yp.service.UserDaoImpl;
import com.yp.util.MyComponentScan.MyAnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by yepeng on 2019/03/20.
 */
public class Test {
	public static void main(String[] args) {
		// 把Spring所有的前提环境准备好
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = (UserService)context.getBean("userServerImpl2");
		System.out.println(userService);
		userService.get();


		//context.register(UserDaoImpl.class);
		//context.refresh();
//		context.scan("com.yp");
//
//
//		UserDao userDao = (UserDao) context.getBean("userDaoImpl");
//		userDao.query();

//		MyAnnotationConfigApplicationContext context = new MyAnnotationConfigApplicationContext();
//		context.scan("com.yp");

//		String string = "opt,max,tpo,hi,tpo,ih,pot,hide";
//		List<String> strList = Arrays.asList("opt", "max", "tpo", "hi", "tpo", "ih", "pot", "hide");
//		Map<Integer, Set<String>> map = new HashMap<>();
//		for (String s : strList) {
//			Set<String> set = new HashSet<>();
//			char[] chars=s.toCharArray();
//			int asiiSum=0;
//			for (char c : chars) {
//				asiiSum+=c;
//			}
//			set.add(s);
//			if(!map.keySet().contains(asiiSum)){
//				map.put(asiiSum,set);
//			}else{
//				map.get(asiiSum).add(s);
//			}
//		}
//		System.out.println(map.values());
	}
}
