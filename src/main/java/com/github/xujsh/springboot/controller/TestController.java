package com.github.xujsh.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.xujsh.springboot.dao.Test;
import com.github.xujsh.springboot.dao.TestDao;
import com.github.xujsh.springboot.redis.RedisService;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年7月3日 下午2:48:33<br/>
 */
@RestController
@RequestMapping("/test")
public class TestController {

		@Autowired
		TestDao testDao;
		
		@Autowired
		RedisService redisService;
		
		@RequestMapping("/db")
		public List<Test> db(){
			return testDao.list();
		}
		
		@RequestMapping("/redis")
		public String redis(){
			redisService.set("hello", "world");
			return redisService.get("hello");
		}
		
}
