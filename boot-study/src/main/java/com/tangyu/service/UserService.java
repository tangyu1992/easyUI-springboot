package com.tangyu.service;

import java.util.List;
import java.util.Map;

import com.tangyu.model.User;

/****
 * 用户管理的service
 * 
 * @author tangyu
 *
 */
public interface UserService {
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
	 * 根据id删除
	 * 
	 * @param id
	 * @return
	 */
	int deleteById(Long id);

	/****
	 * 通过id查询
	 * 
	 * @param id
	 * @return
	 */
	User queryById(Long id);

	/****
	 * 通过map查询，其中传参：id 通过id查询 name name模糊查询 
	 * @param paramMap
	 * @return
	 */
	List<User> queryByMap(Map<String, Object> paramMap);

	/****
	 * 通过map实现删除，其中参数： id通过id删除
	 * @param paramMap
	 * @return
	 */
	int deleteByMap(Map<String, Object> paramMap);
}
