package com.github.xujsh.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年7月3日 下午2:10:49<br/>
 */
@Mapper
public interface TestDao {
	
	@Select("select * from test")
	public List<Test> list();
	
}
