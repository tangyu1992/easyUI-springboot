package com.tangyu.utils;

/****
 * 向页面返回的验证码相关信息的实体
 * 
 * @author tangyu
 *
 */
public class PageCode {
	private boolean iscreated = true;
	private String imgCode;
	private String uuid;

	public String getImgCode() {
		return imgCode;
	}

	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public boolean isIscreated() {
		return iscreated;
	}

	public void setIscreated(boolean iscreated) {
		this.iscreated = iscreated;
	}

	@Override
	public String toString() {
		return "PageCode [iscreated=" + iscreated + ", imgCode=" + imgCode + ", uuid=" + uuid + "]";
	}
}
