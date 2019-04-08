package com.yp.myPostProcesser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yepeng on 2019/04/08.
 */
@Service
public class UserServerImpl2 implements UserService {
	@Autowired
	private QueryService queryService;

	@Override
	public void get() {
		System.out.println("get");
		System.out.println(queryService);
		queryService.query();
	}
}
