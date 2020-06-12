package com.ys.springcloud.entities.core;
/**
 * 
 * ResponseCode:系统提示信息代码编号
 *
 * @author yumaochun
 * @date  2016年3月5日
 * @version  jdk1.8
 *
 */
public class ResponseCode {
	
	//************************操作提示代码，代码以“1”开始（参数验证，及操作是否成功）**************************
	/**
	 * 操作成功:10000
	 */
	public static String OPR_SUCCESS="10000";
	/**
	 * 操作失败：10010
	 */
	public static String OPR_FAIL="10010";
	
	/**
	 * session过期：00000
	 */
	public static String SESSION_EXPIRE="00000";
	
	/**
	 * license即将过期提醒:11000
	 */
	public static String LICENSE_WILL_EXPIRE = "11000";
	
	
	//************************系统错误及异常，错误代码以“0”开始**************************
	
	/**
	 * 系统错误0010
	 */
	public static String SYS_ERROR = "0010";
	/**
	 * 一般异常:0020
	 */
	public static String BASE_ERROR = "0020";
	/**
	 * 参数错误:0030
	 */
	public static String PARAM_ERROR = "0030";
	/**
	 * 空指针错误:0040
	 */
	public static String NULL_ERROR = "0040";
	/**
	 * 数字格式化异常
	 */
	public static String FORMAT_ERROR = "0050";
	/**
	 * 类型强制转换异常 
	 */
	public static String CONVERT_TYPE_ERROR = "0060";
	/**
	 * 参数类型不匹配:0070
	 */
	public static String PARAM_TYPE_ERROR = "0070";
	/**
	 * 接口请求方法类型不匹配（post,get）
	 */
	public static String METHOD_TYPE_ERROR = "0080";
    /**
     * 0090：系统编号重复
     */
    public static String STSTEM_CODE_REPETITION = "0090";
    
    /**
     * 0100：重复提交
     */
    public static String REPEAT_SUBMIT_CODE = "0100";
	
	
	
	//************************MIS api提示状态码**************************
	/**
	 * api认证会员不存在:10011
	 */
	public static String API_ACCOUNT_NO_EXIST = "10011";
	/**
	 * api认证会员已被禁用:10012
	 */
	public static String API_ACCOUNT_FORBIDDEN = "10012";
	/**
	 * api认证会员token过期:10013
	 */
	public static String API_TOKEN_EXPIRE = "10013";
	/**
	 * 注册会员手机号已存在:10014
	 */
	public static String API_PHONE_EXIST = "10014";
	/**
	 * 手机号不存在:10015
	 */
	public static String API_PHONE_NOEXIST = "10015";	

	
}
