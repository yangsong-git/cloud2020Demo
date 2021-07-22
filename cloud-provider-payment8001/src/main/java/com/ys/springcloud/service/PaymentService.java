package com.ys.springcloud.service;

import com.ys.springcloud.core.PageResult;
import com.ys.springcloud.model.Payment;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * 支付表 服务类
 *
 * @author yangsong
 * @since 2020-06-12
 */
public interface PaymentService extends IService<Payment> {

    /**
	 * 支付表 通用分页
	 *
	 * @author   yangsong
	 * @date     2020-06-12
	 * @param params   分页条件参数map  <br>
	 *   参数1：sortName  排序字段名称<br>
	 *   参数2：sortOrder    排序字段升降级类型 desc,asc<br>
	 * @return PageResult
	 */
	public PageResult<Payment> selectPageList(Map<String,Object> params);

	String testAop();
}
