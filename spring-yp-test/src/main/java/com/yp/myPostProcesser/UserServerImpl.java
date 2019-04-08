package com.yp.myPostProcesser;

import org.springframework.stereotype.Service;

/**
 * Created by yepeng on 2019/04/08.
 */
@Service
public class UserServerImpl implements UserService {
	@Override
	public void get() {
		System.out.println("userServerImpl___");
	}
}
