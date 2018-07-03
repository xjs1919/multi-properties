package com.github.xujsh.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年7月3日 下午2:37:20<br/>
 */
@Service
public class RedisService {

		@Autowired
		StringRedisTemplate template;
		
		public boolean set(String key, String value) {
			  ValueOperations<String, String> ops = template.opsForValue();
		      ops.set(key,value);
		      return true;
		}
		
		public String get(String key) {
			  ValueOperations<String, String> ops = template.opsForValue();
		      return ops.get(key);
		}
}
