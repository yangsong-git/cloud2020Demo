package com.ys.springcloud.entities.core;

import java.io.Serializable;

/**
 * 
 * 
 * PageInfo:分页信息及排序实体类对象
 *
 * @author yumaochun
 * @date 2016年12月8日
 * @version jdk1.8
 *
 */
public class PageCommonInfo implements Serializable {

	private static final long serialVersionUID = 3988076872737983581L;
	
	/**
	 * 当前页码数
	 */
	private Integer currentPage;
	
	/**
	 * 每页记录数
	 */
	private Integer pageSize;

	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * 
	 * setCurrentPage:设置当前页码数
	 *
	 * @author yumaochun
	 * @date 2016年12月8日
	 *
	 * @param currentPage
	 *            当前页码数
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}


	/**
	 * 
	 * setPageSize:设置每页记录数
	 *
	 * @author yumaochun
	 * @date 2016年12月8日
	 *
	 * @param pageSize
	 *            每页记录数
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
