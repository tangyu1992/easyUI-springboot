package com.tangyu.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class HttpUtils {
	/****
	 * 通过request获取访问者的ip
	 * 
	 * @param request
	 * @return
	 */
	public static String getRequestIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (StringUtils.isNotBlank(ip)) {
			return ip;
		}
		return request.getRemoteAddr();
	}
}
