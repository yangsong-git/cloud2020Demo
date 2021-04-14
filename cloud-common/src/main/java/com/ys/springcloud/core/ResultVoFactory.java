package com.ys.springcloud.core;

/**
 * 
 * 
 * 统一返回信息工具类
 *
 * @author  yumaochun
 * @date    2018年10月26日
 * @version jdk1.8
 *
 */
public class ResultVoFactory {
	
	//操作成功
	private static String opr_success_msg = "操作成功";
	//操作失败
	private static String opr_fail_msg = "操作失败";

	/**
     * 错误返回结果
     *
     * @param msg
     * @return
     */
    public static <T> ResultVo<T> errorResult(String msg) {
    	ResultVo<T> r = new ResultVo<>();
    	Status status = new Status();
    	status.setCode(ResponseCode.OPR_FAIL);
    	status.setMsg(msg);
        r.setStatus(status);
        return r;
    }
    
    /**
     * 
     * 错误信息
     *
     * @author   yumaochun
     * @date     2018年10月26日
     *
     * @param code   错误代码
     * @param msg    提示信息
     * @return
     */
    public static <T> ResultVo<T> errorResult(String code,String msg) {
    	ResultVo<T> r = new ResultVo<>();
    	Status status = new Status();
    	status.setCode(code);
    	status.setMsg(msg);
        r.setStatus(status);
        return r;
    }

    /**
     * 
     * successResult:返回正确数据
     *
     * @author   yumaochun
     * @date     2018年10月26日
     *
     * @param data   数据
     * @param msg    提示信息
     * @return
     */
    public static <T> ResultVo<T> successResult(T data,String msg) {
    	ResultVo<T> r = new ResultVo<>();
    	Status status = new Status();
    	status.setCode(ResponseCode.OPR_SUCCESS);
    	status.setMsg(msg);
        r.setStatus(status);
        //设置数据
        r.setData(data);
        return r;
    }
    /**
     * 
     * successResult:返回正确数据
     *
     * @author   yumaochun
     * @date     2018年10月26日
     *
     * @param data   数据
     * @return
     */
    public static <T> ResultVo<T> successResult(T data) {
    	ResultVo<T> r = new ResultVo<>();
    	Status status = new Status();
    	status.setCode(ResponseCode.OPR_SUCCESS);
    	status.setMsg(opr_success_msg);
        r.setStatus(status);
        //设置数据
        r.setData(data);
        return r;
    }

    /**
     * 
     * successResult:返回正确结果
     *
     * @author   yumaochun
     * @date     2018年10月26日
     *
     * @param code   状态编码
     * @param data   返回数据
     * @param msg    提示信息
     * @return
     */
    public static <T> ResultVo<T> successResult(String code,T data, String msg) {
    	ResultVo<T> r = new ResultVo<>();
    	Status status = new Status();
    	status.setCode(code);
    	status.setMsg(msg);
        r.setStatus(status);
        //设置数据
        r.setData(data); 
        return r;
    }
}
