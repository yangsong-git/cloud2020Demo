package com.ys.springcloud.entities.controller;

import com.ys.springcloud.entities.core.PageCommonInfo;
import com.ys.springcloud.entities.core.PageResult;
import com.ys.springcloud.entities.core.ResultVo;
import com.ys.springcloud.entities.core.ResultVoFactory;
import com.ys.springcloud.util.CommonUtil;
import org.springframework.stereotype.Controller;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import com.ys.springcloud.entities.service.PaymentService;
import com.ys.springcloud.entities.model.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付表 控制层

 * @author yangsong
 * @date 2020-06-12
 */
@Controller
@RequestMapping("/payment")
public class PaymentController {

    private final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    public PaymentService paymentService;

    /**
     * 
     * 分页查询接口
     * @author   yangsong
     * @date     2020-06-12
     * @param pageInfo   分页查询对象
     * @return ResultVo
     */
	@RequestMapping(value="/getPaymentPageList",method={RequestMethod.POST})
	@ResponseBody
	public ResultVo<PageResult<Payment>> getPaymentPageList(@RequestBody PageCommonInfo pageInfo) {
	   	try {
			//条件参数
			Map<String, Object> params = CommonUtil.getPageInfoParams(pageInfo);
			//根据条件获取用户信息（分页）
			PageResult<Payment> pageResult = paymentService.selectPageList(params);
    		return ResultVoFactory.successResult(pageResult);
		} catch (Exception e) {
			logger.error("获取分页异常:",e.getMessage());
			return ResultVoFactory.errorResult("获取分页异常:"+e.getMessage());
		}
	}
	
	/**
	 * 
	 * 根据id，查询对象
	 * @author   yangsong
	 * @date     2020-06-12
	 * @param id   主键ID
	 * @return ResultVo
	 */
	@RequestMapping(value="/getPaymentById",method={RequestMethod.GET})
	@ResponseBody
	public ResultVo<Payment> getPaymentById(@RequestParam("id") Long id) {
        //返回对象
		ResultVo<Payment> resultVo = new ResultVo<>();
		if (id == null) {
			return ResultVoFactory.errorResult("参数传递错误ID");
		}
		try {
		    //根据主键id，查询对象
		    Payment payment = paymentService.selectById(id);
		    resultVo = ResultVoFactory.successResult(payment);
		    return resultVo;
		} catch (Exception e) {
		    logger.error("根据id，获取数据异常:",e.getMessage());
			return ResultVoFactory.errorResult("根据id，获取数据异常:"+e.getMessage());
		}
		
	}
	
	/**
	 * 新增或更新方法
	 *
	 * @author   yangsong
	 * @date     2020-06-12
	 * @param payment
	 * @return ResultVo
	 */
	@RequestMapping(value="/insertOrUpdatePayment",method={RequestMethod.POST})
	@ResponseBody
	public ResultVo<String> insertOrUpdatePayment(@RequestBody Payment payment) {
		try {
		    //新增或修改数据
		    paymentService.insertOrUpdate(payment);
		    return ResultVoFactory.successResult("操作成功");
		} catch (Exception e) {
		    logger.error("新增或修改数据异常：",e.getMessage());
			return ResultVoFactory.errorResult("新增或修改数据异常："+e.getMessage());
		}
	}
	
	/**
	 * 删除方法
	 *
	 * @author   yangsong
	 * @date     2020-06-12
	 * @param  id  主键id
	 * @return ResultVo
	 */
	@RequestMapping(value="/deletePaymentById",method=RequestMethod.DELETE)
	@ResponseBody
	public ResultVo<String> deletePaymentById(@RequestParam("id") Long id) {
		//数据验证
		if (id == null) {
			return ResultVoFactory.errorResult("参数传递错误ID");
		}
		try {
		    //根据id,删除数据
		    paymentService.deleteById(id);
		    return ResultVoFactory.successResult("操作成功");
		} catch (Exception e) {
		    logger.error("根据id，删除数据异常：",e.getMessage());
			return ResultVoFactory.errorResult("根据id，删除数据异常："+e.getMessage());
		}
	}
}