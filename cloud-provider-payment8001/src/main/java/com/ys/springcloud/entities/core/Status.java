package com.ys.springcloud.entities.core;

import java.io.Serializable;

/**
 * 
 * Status:请求返回状态信息类
 *
 * @author yumaochun
 * @date 2016年3月3日 下午4:25:02
 */
public class Status implements Serializable{
	
	private static final long serialVersionUID = 2133800753538506666L;
	/**
	 * 状态编码
	 */
	private String code;
	/**
	 * 提示信息
	 */
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
