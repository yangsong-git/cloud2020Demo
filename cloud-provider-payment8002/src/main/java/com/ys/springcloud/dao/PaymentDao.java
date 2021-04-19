package com.ys.springcloud.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ys.springcloud.model.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
  * 支付表 Mapper 接口
 *
 * @author yangsong
 * @date 2020-06-12
 */
@Mapper
public interface PaymentDao extends BaseMapper<Payment> {

   	/**
	 * 支付表 通用分页
	 *
	 * @author   yangsong
	 * @date     2020-06-12
	 * @param params   分页条件参数map  <br>
	 *   参数1：sortName  排序字段名称<br>
	 *   参数2：sortOrder    排序字段升降级类型 desc,asc<br>
	 * @return List<Payment>
	 */
    List<Payment> selectPageList(Map<String,Object> params);
}
