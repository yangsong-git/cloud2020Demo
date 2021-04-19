package com.ys.springcloud.util;

import com.ys.springcloud.core.PageCommonInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * 描述:公用工具类
 *
 * @author:  yumaochun
 * @date:    2019年9月25日 上午10:26:56
 * @version: jdk1.8
 *
 */
public class CommonUtil {

    /**
     * 
     * 是否是图片格式
     *
     * @author:   yumaochun
     * @date:     2019年9月25日 上午10:25:57
     *
     * @param ext
     * @return
     */
    public static boolean isImgFile(String ext) {
        if (ext == null) {
            return false;
        }
        if ("jpg".equals(ext)) {
            return true;
        }
        if ("jpeg".equals(ext)) {
            return true;
        }
        if ("gif".equals(ext)) {
            return true;
        }
        if ("bmp".equals(ext)) {
            return true;
        }
        if ("png".equals(ext)) {
            return true;
        }
        return false;
    }
    
    /**
     * @param code 从几开始
     * @param len 生成长度
     * @description 生成优惠券流水码方法
     * @return java.lang.String
     * @author huangxinyu
     * @date 2018/11/28 15:50
     */
    public static String codeAddOne(int code, int len){
        code++;
        String strHao = String.valueOf(code);
        while (strHao.length() < len) {
            strHao = "0" + strHao;
        }
        return strHao;
    }
    /**
     * getPageInfoParams:根据分页信息对象，获取分页信息map参数
     *
     * @param pageInfo 分页信息你对象
     * @return 返回：对应的分页信息参数
     * @author yumaochun
     * @date 2016年12月8日
     */
    public static Map<String, Object> getPageInfoParams(PageCommonInfo pageInfo) {
        Map<String, Object> params = new HashMap<>();
        //当前页码数
        params.put("currentPage", pageInfo.getCurrentPage());
        //每页显示记录数
        params.put("pageSize", pageInfo.getPageSize());
        return params;
    }
    
    /**
     * 
     * 将对象转换为mapper对象
     *
     * @author:   yumaochun
     * @date:     2019年10月30日 下午3:43:42
     *
     * @param obj   对象
     * @return  返回：mapper对象
     */
    @SuppressWarnings("unchecked")
	public static Map<String,Object> getRequestParams(Object obj){
    	Map<String, Object> params = new HashMap<>();
    	//先转换为json
    	String json = JacksonUtil.toJson(obj);
    	//将json转换为mapper
    	params = (Map<String, Object>) JacksonUtil.jsonToMap(json, Object.class);
    	return params;
    }
    /**
     * 生成编号公用方法
     * @param code 已经存在的编号
     * @param dateStr 8位日期字符串，格式20190901
     * @param prefix 编号前缀
     * @param start 截取字符串开始长度
     * @param end 截取字符串结束长度
     * @param length 递增编号长度
     * @return java.lang.String
     * @author huangxinyu
     * @date 2019/9/23 11:07 上午
     */
    public static String createNoByParam(String code,String dateStr,String prefix,int start,int end,int length){
        //定义返回编号
        String no;
        //如果当前日期条件对应的编号已存在，则加
        if (code != null && !"".equals(code)) {
            String num = code.substring(start, end);
            no = CommonUtil.codeAddOne(Integer.parseInt(num), length);
        } else {
            no = CommonUtil.codeAddOne(0, length);
        }
        return prefix + dateStr + no;
    }
}
