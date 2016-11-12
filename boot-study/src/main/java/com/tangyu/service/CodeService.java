package com.tangyu.service;

import com.tangyu.model.Code;
import com.tangyu.utils.PageCode;

public interface CodeService {
	int addCode(Code code);

	int updateCodeById(Code code);

	boolean deleteById(Long codeId);

	/****
	 * 根据企业唯一标识创建一次会话，其中完成的工作有：存放验证码到redis，生成返回的base64字符串
	 * 
	 * @param org
	 * @return
	 */
	PageCode createSession(String org);
}
