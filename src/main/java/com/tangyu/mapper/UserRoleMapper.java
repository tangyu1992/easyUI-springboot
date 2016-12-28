package com.tangyu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tangyu.model.UserRole;

public interface UserRoleMapper {

	int deleteByPrimaryKey(Long id);

	int insert(UserRole record);

	int insertSelective(UserRole record);

	UserRole selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(UserRole record);

	int updateByPrimaryKey(UserRole record);

	List<UserRole> selectByUserId(@Param("userId") Long userId);
}