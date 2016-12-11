package com.tangyu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tangyu.mapper.UserMapper;
import com.tangyu.model.User;
import com.tangyu.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public int insert(User user) {
		if (user != null && StringUtils.isNotBlank(user.getEmail()) && StringUtils.isNotBlank(user.getName())
				&& StringUtils.isNotBlank(user.getPassword())) {
			return userMapper.insert(user);
		}
		return 0;
	}

	@Override
	public int update(User user) {
		if (user != null && user.getId() != null) {
			return userMapper.update(user);
		}
		return 0;
	}

	@Override
	public int deleteById(Long id) {
		if (id != null) {
			final Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("id", id);
			return deleteByMap(paramMap);
		}
		return 0;
	}

	@Override
	public User queryById(Long id) {
		if (id != null) {
			final Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("id", id);
			List<User> result = queryByMap(paramMap);
			if (result.size() > 0) {
				return result.get(0);
			}
		}
		return null;
	}

	@Override
	public List<User> queryByMap(Map<String, Object> paramMap) {
		if (paramMap != null && !paramMap.isEmpty()) {
			return userMapper.queryByMap(paramMap);
		}
		return new ArrayList<>();
	}

	@Override
	public int deleteByMap(Map<String, Object> paramMap) {
		if (paramMap != null && !paramMap.isEmpty()) {
			return userMapper.deleteByMap(paramMap);
		}
		return 0;
	}

	@Override
	public User login(User user) {
		if (user != null && StringUtils.isNotBlank(user.getEmail()) && StringUtils.isNotBlank(user.getPassword())) {
			final Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("email", user.getEmail());
			paramMap.put("password", user.getPassword());
			final List<User> users = userMapper.queryByMap(paramMap);
			if (users.size() == 1) {
				return users.get(0);
			}
		}
		return null;
	}

	@Override
	public User queryByEmail(String email) {
		if (StringUtils.isNotBlank(email)) {
			final Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("email", email);
			final List<User> users = userMapper.queryByMap(paramMap);
			if (users.size() >= 1) {
				return users.get(0);
			}
		}
		return null;
	}

}
