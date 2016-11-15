package com.tangyu.service.impl;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tangyu.model.Code;
import com.tangyu.service.CodeService;
import com.tangyu.service.ImageService;
import com.tangyu.service.RedisService;
import com.tangyu.utils.AjaxJson;
import com.tangyu.utils.PageCode;

@Service
public class CodeServiceImpl implements CodeService {
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ImageService imageService;
	@Autowired
	private RedisService redisService;

	@Override
	public int addCode(Code code) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCodeById(Code code) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteById(Long codeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PageCode createSession(String org) {
		final PageCode pageCode = new PageCode();
		final String[] sourceCodes = { "a", "b", "c", "d", "e", "f", "1", "2", "3", "4", "5", "6" };
		final String[] codes = imageService.getCodes(sourceCodes, 5);
		if (codes != null && codes.length > 0) {
			final String bs64 = imageService.getBase64ByCodes(codes, 100, 25);
			if (StringUtils.isNotBlank(bs64)) {
				final String uuid = UUID.randomUUID().toString();
				pageCode.setUuid(uuid);
				pageCode.setImgCode("data:image/gif;base64," + bs64);
				String code= StringUtils.join(codes);
				redisService.setValue("tangyu:code:" + org + ":" + uuid,code, 50L);
			}
		} else {
			pageCode.setIscreated(false);
		}
		return pageCode;
	}

}
