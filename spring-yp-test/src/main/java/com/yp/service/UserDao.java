package com.yp.service;

import com.yp.util.MyComponentScan.MyComponent;

/**
 * Created by yepeng on 2019/03/20.
 */
@MyComponent("userDao")
public interface UserDao {
	void query();
}
