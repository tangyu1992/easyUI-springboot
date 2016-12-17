package com.tangyu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tangyu.mapper.UserRoleMapper;
import com.tangyu.model.UserRole;
import com.tangyu.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public List<UserRole> queryByUserId(Long userId) {
		if (userId != null) {
			return userRoleMapper.selectByUserId(userId);
		}
		return null;
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		if (id != null) {
			return userRoleMapper.deleteByPrimaryKey(id);
		}
		return 0;
	}

	@Override
	public int insert(UserRole record) {
		if (record != null) {
			return userRoleMapper.insert(record);
		}
		return 0;
	}

	@Override
	public int insertSelective(UserRole record) {
		if (record != null) {
			return userRoleMapper.insertSelective(record);
		}
		return 0;
	}

	@Override
	public UserRole selectByPrimaryKey(Long id) {
		if (id != null) {
			return userRoleMapper.selectByPrimaryKey(id);
		}
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(UserRole record) {
		if (record != null && record.getId() != null) {
			return userRoleMapper.updateByPrimaryKeySelective(record);
		}
		return 0;
	}

	@Override
	public int updateByPrimaryKey(UserRole record) {
		if (record != null && record.getId() != null) {
			return userRoleMapper.updateByPrimaryKey(record);
		}
		return 0;
	}

}
