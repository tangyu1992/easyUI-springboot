package com.tangyu.utils;

import java.util.Map;

/****
 * ajax向前台返回的对象信息，ajax通用
 * 
 * @author tangyu
 *
 */
public class AjaxJson {
	// 返回页面的消息内容
	private String msg = "操作成功";
	// 返回页面的是否成功标志位
	private boolean success = true;
	// 返回页面的单个实体对象
	private Object object = null;
	// 返回页面的多个实体对象，在页面通过key取得
	private Map<String, Object> objects;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Map<String, Object> getObjects() {
		return objects;
	}

	public void setObjects(Map<String, Object> objects) {
		this.objects = objects;
	}
}
