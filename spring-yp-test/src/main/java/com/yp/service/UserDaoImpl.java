package com.yp.service;

import com.yp.util.MyComponentScan.MyComponent;
import org.springframework.stereotype.Service;

/**
 * Created by yepeng on 2019/03/20.
 */
@Service
@MyComponent("userDaoImpl")
public class UserDaoImpl implements UserDao {
	@Override
	public void query() {
		System.out.println("query");
	}
}
