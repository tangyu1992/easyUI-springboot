package com.tangyu.mapper;

import java.util.List;
import java.util.Map;

import com.tangyu.model.User;

public interface UserMapper {
	/****
	 * 插入一个用户，id会回显
	 * 
	 * @param user
	 * @return
	 */
	int insert(User user);

	/****
	 * 更新一个用户
	 * 
	 * @param user
	 * @return
	 */
	int update(User user);

	/****
	 * 通过map查询，其中传参：id 通过id查询 name name模糊查询
	 * 
	 * @param paramMap
	 * @return
	 */
	List<User> queryByMap(Map<String, Object> paramMap);

	/****
	 * 通过map实现删除，其中参数： id通过id删除
	 * 
	 * @param paramMap
	 * @return
	 */
	int deleteByMap(Map<String, Object> paramMap);
}
