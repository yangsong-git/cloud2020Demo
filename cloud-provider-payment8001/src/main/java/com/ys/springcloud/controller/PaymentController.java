package com.ys.springcloud.controller;
import com.ys.springcloud.config.AopTest;
import com.ys.springcloud.core.PageCommonInfo;
import com.ys.springcloud.core.PageResult;
import com.ys.springcloud.core.ResultVo;
import com.ys.springcloud.core.ResultVoFactory;
import com.ys.springcloud.util.CommonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.ys.springcloud.service.PaymentService;
import com.ys.springcloud.model.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付表 控制层

 * @author yangsong
 * @date 2020-06-12
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final Logger logger = LoggerFactory.getLogger(PaymentController.class);
	@Value("${server.port}")
	private String serverPort;
    @Autowired
    public PaymentService paymentService;

    @Autowired
	private DiscoveryClient discoveryClient;

    /**
     * 分页查询接口
     * @author   yangsong
     * @date     2021/4/17 12:29
     * @param currentPage:
     * @param pageSize:
     * @return: com.ys.springcloud.core.ResultVo<com.ys.springcloud.core.PageResult<com.ys.springcloud.model.Payment>>
     */
	@PostMapping(value="/getPaymentPageList/{currentPage}/{pageSize}/")
	public ResultVo<PageResult<Payment>> getPaymentPageList(@PathVariable("currentPage") Integer currentPage,
															@PathVariable("pageSize") Integer pageSize) {
	   	try {
			 PageCommonInfo pageInfo = new PageCommonInfo();
			 pageInfo.setCurrentPage(currentPage);
			 pageInfo.setPageSize(pageSize);
			//条件参数
			Map<String, Object> params = CommonUtil.getPageInfoParams(pageInfo);
			//根据条件获取用户信息（分页）
			PageResult<Payment> pageResult = paymentService.selectPageList(params);
    		return ResultVoFactory.successResult(pageResult);
		} catch (Exception e) {
			logger.error("获取分页异常:",e.getMessage());
			return ResultVoFactory.errorResult("获取分页异常："+e.getMessage());
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
	@GetMapping(value = "/getPaymentById/{id}/")
	public ResultVo<Payment> getPaymentById(@PathVariable("id") Long id) {
        //返回对象
		ResultVo<Payment> resultVo = new ResultVo<>();
		if (id == null) {
			return ResultVoFactory.errorResult("参数传递错误ID");
		}
		try {
		    //根据主键id，查询对象
		    Payment payment = paymentService.selectById(id);
			resultVo = ResultVoFactory.successResult(payment,"查询成功，serverPort"+serverPort);
		    return resultVo;
		} catch (Exception e) {
		    logger.error("根据id，获取数据异常:",e.getMessage());
		    e.printStackTrace();
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
	@PostMapping(value="/insertOrUpdatePayment")
	public ResultVo<String> insertOrUpdatePayment(@RequestBody Payment payment) {
		try {
		    //新增或修改数据
		    paymentService.insertOrUpdate(payment);
		    return ResultVoFactory.successResult("操作成功,serverPort"+serverPort);
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
	@DeleteMapping(value="/deletePaymentById/{id}/")
	public ResultVo<String> deletePaymentById(@PathVariable("id") Long id) {
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
	@GetMapping(value = "/discovery/")
	public Object discovery(){
		List<String> services = discoveryClient.getServices();
		services.forEach(ser->{
			logger.info("服务名称"+ser);
		});
		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		instances.forEach(ins->{
			logger.info(ins.getServiceId()+"\t"+ins.getHost()+"\t"+ins.getPort()+"\t"+ins.getUri());
		});
		return services;
	}

	@GetMapping(value = "/getServerPort/")
	public String getServerPort(){
		return "serverPort";
	}

	@GetMapping(value = "/paymentFeign/")
	public String paymentFeign(){
		try {
			TimeUnit.SECONDS.sleep(3);
		}catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return serverPort;
	}
	@GetMapping(value = "/getTest/")
	public String getTest(){
		return paymentService.testAop();
	}
}