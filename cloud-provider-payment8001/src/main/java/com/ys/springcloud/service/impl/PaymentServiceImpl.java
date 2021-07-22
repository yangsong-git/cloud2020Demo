package com.ys.springcloud.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ys.springcloud.config.AopTest;
import com.ys.springcloud.core.PageResult;
import com.ys.springcloud.dao.PaymentDao;
import com.ys.springcloud.model.Payment;
import com.ys.springcloud.service.PaymentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

/**
 * 支付表 服务层实现类
 *
 * @author yangsong
 * @date 2020-06-12
 */
@Service
@Transactional
public class PaymentServiceImpl extends ServiceImpl<PaymentDao, Payment> implements PaymentService {


    @Autowired
    private PaymentDao paymentMapper;

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
    @Override
    public PageResult<Payment> selectPageList(Map<String,Object> params){
    	//当前页码数
    	Integer currentPage = Integer.parseInt(params.get("currentPage").toString());
    	//每页显示记录数
    	Integer pageSize = Integer.parseInt(params.get("pageSize").toString());

    	PageResult<Payment> pageResult = new PageResult<Payment>();
    	//分页插件
    	Page<Payment> page = PageHelper.startPage(currentPage, pageSize);
    	//查询分页信息集合
    	List<Payment> list = paymentMapper.selectPageList(params);
    	pageResult.setRows(list);
    	pageResult.setTotal(page.getTotal());
    	return pageResult;
    }

	@Override
	@AopTest
	public String testAop() {
		return "200";
	}

}
