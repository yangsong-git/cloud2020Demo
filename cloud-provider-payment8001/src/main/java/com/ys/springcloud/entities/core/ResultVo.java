package com.ys.springcloud.entities.core;

import java.io.Serializable;
import java.util.Map;

/**
 * Description:json返回数据基本格式
 * 
 * @author yumaochun
 *
 */
public class ResultVo<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 657131477209360917L;

	/**
	 * 结果数据
	 */
	private T data;
	/**
	 * 结果状态信息
	 */
	private Status status;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * 
	 * ResponseInfo:ajax返回提示信息
	 *
	 * @date 2016年3月7日
	 * @param code
	 *            提示代码
	 * @param msg
	 *            提示信息
	 */
	public static ResultVo<Map<String, String>> responseInfo(String code, String msg) {
		ResultVo<Map<String, String>> baseResultVo = new ResultVo<Map<String, String>>();
		Status status = new Status();
		// 提示代码
		status.setCode(code);
		// 提示信息
		status.setMsg(msg);
		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	/**
	 * 
	 * responseSuccess:返回操作成功的提示
	 *
	 * @date 2016年3月7日
	 * @param msg
	 *            提示信息
	 */
	public static ResultVo<Map<String, String>> responseSuccess(String msg) {
		ResultVo<Map<String, String>> baseResultVo = new ResultVo<Map<String, String>>();
		Status status = new Status();
		// 提示代码
		status.setCode(ResponseCode.OPR_SUCCESS);
		// 提示信息
		status.setMsg(msg);
		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	/**
	 * 
	 * responseFail:返回操作失败的提示
	 *
	 * @date 2016年3月7日
	 * @param msg
	 *            提示信息
	 */
	public static ResultVo<Map<String, String>> responseFail(String msg) {
		ResultVo<Map<String, String>> baseResultVo = new ResultVo<Map<String, String>>();
		Status status = new Status();
		// 提示代码
		status.setCode(ResponseCode.OPR_FAIL);
		// 提示信息
		status.setMsg(msg);
		baseResultVo.setStatus(status);
		return baseResultVo;
	}

}
