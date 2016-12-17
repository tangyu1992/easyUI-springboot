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

	/****
	 * 根据企业uuId，key和验证码code判断输入的验证码是否正确
	 * 
	 * @param orgId
	 * @param key
	 * @param code
	 * @return 0:验证码正确 1：无此验证码或已过期 2：验证码不正确 3：参数错误
	 */
	int authCode(String orgId, String key, String code);
}
