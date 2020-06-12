package com.ys.springcloud.entities.dao;

import java.util.List;
import java.util.Map;
import com.ys.springcloud.entities.model.Payment;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
  * 支付表 Mapper 接口
 *
 * @author yangsong
 * @date 2020-06-12
 */
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
