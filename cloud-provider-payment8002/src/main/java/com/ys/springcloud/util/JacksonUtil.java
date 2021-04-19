package com.ys.springcloud.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 描述:Jackson字符传与对象转换工具类
 *
 * @author:  yumaochun
 * @date:    2019年9月25日 下午5:47:16
 * @version: jdk1.8
 *
 */
public final class JacksonUtil {
	 
	private static final ObjectMapper MAPPER = new ObjectMapper();
	 
    static
    {
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        MAPPER.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MAPPER.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 
     * toJson:将对象转换为json字符串
     *
     * @author   yumaochun
     * @date     2018年8月11日
     *
     * @param obj  
     * @return     json字符串
     */
    public static <T> String toJson(T obj)
    {
        String json = "";
        try
        {
            if (obj != null)
            {
                json = MAPPER.writeValueAsString(obj);
            }
        }
        catch (JsonProcessingException e)
        {
             
        }
 
        return json;
    }
    
    /**
     * 
     * toJson:将list集合转换为json字符串
     *
     * @author   yumaochun
     * @date     2018年8月11日
     *
     * @param obj
     * @return
     */
    public static <T> String toJson(List<T> obj)
    {
        String json = "";
 
        try
        {
            if (obj != null)
            {
                json = MAPPER.writeValueAsString(obj);
            }
        }
        catch (JsonProcessingException e)
        {
             
        }
 
        return json;
    }
    
    /**
     * 
     * toModel:将json转换为对象
     *
     * @author   yumaochun
     * @date     2018年8月11日
     *
     * @param json
     * @param clazz
     * @return
     */
    public static <T> T toModel(String json, Class<T> clazz)
    {
        T instance = null;
        try
        {
            instance = MAPPER.readValue(json, clazz);
        }
        catch (Exception e)
        {
        }
        return instance;
    }
    
    public static <T> T toModelNew(String json,Class<?> parametrized, Class<?>... clazz){
    	T instance = null;
    	try {
        	JavaType javaType = MAPPER.getTypeFactory().constructParametricType(parametrized, clazz);
            instance = MAPPER.readValue(json, javaType);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return instance;
    }
    
    
    @SuppressWarnings("unchecked")
	public static <T> List<T> toList(String json, Class<T> clazz)
    {
        List<T> instance = null;
        try
        {
            //List<Bean> beanList = mapper.readValue(jsonString, new TypeReference<List<Bean>>() {});
            ////如果是Map类型  mapper.getTypeFactory().constructParametricType(HashMap.class,String.class, Bean.class);
            JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, clazz);
            instance = (List<T>) MAPPER.readValue(json, javaType);
        }
        catch (Exception e)
        {

        }
        return instance;
    }
    
    /**
     * 
     * jsonToList:将复杂json转换为List
     *
     * @author   yumaochun
     * @date     2018年8月13日
     *
     * @param json   json字符串
     * @param clazz  类型
     * @return
     */
	@SuppressWarnings("unchecked")
	public static <T> List<T> jsonToList(String json, Class<T> clazz){
		  List<T> instance = null;
	        try
	        {
	        	//List<Bean> beanList = mapper.readValue(jsonString, new TypeReference<List<Bean>>() {});
	        	////如果是Map类型  mapper.getTypeFactory().constructParametricType(HashMap.class,String.class, Bean.class);
	        	JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, clazz);
	        	instance = (List<T>) MAPPER.readValue(json, javaType);
	        }
	        catch (Exception e)
	        {
	        	
	        }
	        return instance;
	 }
	public static <T> Map<?,?> jsonToMap(String json, Class<T> clazz){
		Map<?,?> instance = null;
        try
        {
        	//List<Bean> beanList = mapper.readValue(jsonString, new TypeReference<List<Bean>>() {});
        	////如果是Map类型  mapper.getTypeFactory().constructParametricType(HashMap.class,String.class, Bean.class);
        	JavaType javaType = MAPPER.getTypeFactory().constructParametricType(Map.class,String.class, clazz);
        	instance = MAPPER.readValue(json, javaType);
        }
        catch (Exception e)
        {
        	
        }
        return instance;
	}
	
	/**
	 * 
	 * 描述:将json转化成map
	 *
	 * @author:   yumaochun
	 * @date:     2020年2月24日 下午5:55:14
	 *
	 * @param jsonStr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> convertJsonStrToMap(String jsonStr){
		Map<String, Object> map = new HashMap<>();
		 try {
			map = MAPPER.readValue(jsonStr, Map.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 获取泛型的Collection Type
	 * 
	 * @param jsonStr         json字符串
	 * @param collectionClass 泛型的Collection
	 * @param elementClasses  元素类型
	 */
	public static <T> T readJson(String jsonStr, Class<?> collectionClass, Class<?> elementClasses) throws Exception {
		JavaType javaType = MAPPER.getTypeFactory().constructParametricType(collectionClass,elementClasses);
	    return MAPPER.readValue(jsonStr, javaType);
	}
	
	/**
	 * 
	 * 解析复杂json
	 *
	 * @author:   yumaochun
	 * @date:     2019年12月10日 上午10:20:19
	 *
	 * @param jsonStr          待解析的json
	 * @param collectionClass  最外层泛型
	 * @param childClass       子集泛型（如：List）
	 * @param elementClasses   内容元素
	 * @return
	 * @throws Exception
	 */
	public static <T> T readJson(String jsonStr,Class<?> collectionClass,Class<?> childClass, Class<?> elementClasses) throws Exception {
		JavaType childJavaType = MAPPER.getTypeFactory().constructParametricType(childClass,elementClasses);
		JavaType javaType = MAPPER.getTypeFactory().constructParametricType(collectionClass,childJavaType);
		return MAPPER.readValue(jsonStr,javaType);
	}
	
	/**
     * 
     * 将map转换为bean
     *
     * @author:   yumaochun
     * @date:     2019年2月13日 下午2:59:55
     *
     * @param map   map
     * @param clazz 
     * @return
     */
    public static <T> T toModel(Map<String,Object> map, Class<T> clazz)
    {
        T instance = null;
        try
        {
        	//map转换为json字符串
    		String json = toJson(map);
    		//json转换为对象
            instance = MAPPER.readValue(json, clazz);
        }
        catch (Exception e)
        {
        }
        return instance;
    }
	
}