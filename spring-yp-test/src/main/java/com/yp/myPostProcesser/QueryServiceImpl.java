package com.yp.myPostProcesser;

import org.springframework.stereotype.Service;

/**
 * Created by yepeng on 2019/04/08.
 */
@Service
public class QueryServiceImpl implements QueryService {
	@Override
	public void query() {
		System.out.println("query");
	}
}
