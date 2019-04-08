package com.yp.spring_mybatis.dao;

import com.yp.spring_mybatis.dao.mapper.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yepeng on 2019/04/08.
 */
@Component
public class HelloDao {
	@Autowired
	private TestDao testDao;

	public Object getDao() {
		return testDao;
	}
}
