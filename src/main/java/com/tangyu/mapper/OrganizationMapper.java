package com.tangyu.mapper;

import com.tangyu.model.Organization;

public interface OrganizationMapper {

	int deleteByPrimaryKey(Long id);

	int insert(Organization record);

	int insertSelective(Organization record);

	Organization selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Organization record);

	int updateByPrimaryKey(Organization record);
}