package com.tangyu.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.tangyu.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService {
	@Autowired
	private StringRedisTemplate redisTemplate;

	@Override
	public Set<String> getKeys(String pattern) {
		if (StringUtils.isNotBlank(pattern)) {
			return redisTemplate.keys(pattern);
		}
		return null;
	}

	@Override
	public List<String> getValues(String pattern) {
		if (StringUtils.isNotBlank(pattern)) {
			Set<String> keys = redisTemplate.keys(pattern);
			if (keys.size() > 0) {
				return redisTemplate.opsForValue().multiGet(keys);
			}
		}
		return null;
	}

	@Override
	public String getValueByKey(String key) {
		if (StringUtils.isNotBlank(key)) {
			return redisTemplate.opsForValue().get(key);
		}
		return "";
	}

	@Override
	public void setValue(String key, String value,Long expireTime) {
		if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
			if(expireTime!=null&&expireTime>0){
				System.out.println(value);
				redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
			}else{
				redisTemplate.opsForValue().set(key, value);
			}
			
		}

	}

	@Override
	public void setValues(Map<String, String> map) {
		if (map != null && !map.isEmpty()) {
			redisTemplate.opsForValue().multiSet(map);
		}

	}

}
