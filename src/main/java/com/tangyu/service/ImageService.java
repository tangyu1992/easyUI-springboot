package com.tangyu.service;

/****
 * 图像处理service
 * 
 * @author tangyu
 *
 */
public interface ImageService {
	/****
	 * 根据源配置获取随机生成的验证码
	 * 
	 * @param sourceCodes
	 * @param length
	 * @return
	 */
	String[] getCodes(String[] sourceCodes, int length);

	/****
	 * 根据验证码字符串数组生成base64的图片字符串
	 * 
	 * @param codes
	 * @param width
	 * @param height
	 * @return
	 */
	String getBase64ByCodes(String[] codes, int width, int height);
}
