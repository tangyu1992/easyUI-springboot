package com.tangyu.service;

import java.util.List;

import com.tangyu.model.UserRole;

public interface UserRoleService {
	/****
	 * 通过userId查询所有的角色绑定
	 * 
	 * @param userId
	 * @return
	 */
	List<UserRole> queryByUserId(Long userId);

	int deleteByPrimaryKey(Long id);

	int insert(UserRole record);

	int insertSelective(UserRole record);

	UserRole selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(UserRole record);

	int updateByPrimaryKey(UserRole record);
}
