package com.tangyu.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RedisService {
	/****
	 * 根据字符串模糊查询所有的key
	 * 
	 * @param pattern
	 * @return
	 */
	public Set<String> getKeys(String pattern);

	/****
	 * 根据字符串模糊查询所有的key的值
	 * 
	 * @param pattern
	 * @return
	 */
	public List<String> getValues(String pattern);

	/****
	 * 根据key查询值
	 * 
	 * @param key
	 * @return
	 */
	public String getValueByKey(String key);

	/****
	 * 设置一个value值
	 * 
	 * @param key
	 * @param value
	 */
	public void setValue(String key, String value,Long expireTime);

	/****
	 * 批量设置key value（针对字符串）
	 * 
	 * @param map
	 */
	public void setValues(Map<String, String> map);
}
