package com.yp.spring_mybatis.dao.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by yepeng on 2019/04/08.
 */
public interface TestDao1 {
	@Select("select * from user")
	List<Map<String, String>> query();
}
