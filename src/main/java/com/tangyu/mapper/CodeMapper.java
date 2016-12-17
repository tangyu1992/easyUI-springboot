package com.tangyu.mapper;

import com.tangyu.model.Code;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodeMapper {

	int deleteByPrimaryKey(Long id);

	int insert(Code record);

	int insertSelective(Code record);

	Code selectByPrimaryKey(Long id);

	int updateBySelective(@Param("record") Code record);

	int updateByPrimaryKeySelective(Code record);

	int updateByPrimaryKey(Code record);
}