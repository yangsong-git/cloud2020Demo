package com.ys.springcloud.entities.core;

import java.io.Serializable;

/**
 * 
 * QueryConditon:公共分页查询条件辅助类
 *
 * @author yumaochun
 * @date  2016年4月14日
 * @version  jdk1.8
 *
 */
public class QueryConditon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8476801034019716662L;
	/**
	 * 购物中心id字符串，多个购物中心以“;”分隔
	 */
	private String mallId;
	
	/**
	 * 当前页码数
	 */
	private Integer currentPage;
	
	/**
	 * 每页显示记录数
	 */
	private Integer pageSize;
	
	/**
	 * 查询条件
	 */
	private String condition;

	/**
	 * 排序字段的名称
	 */
	private String sortName;
	/**
	 * 排序字段类型（升序或降序）
	 */
	private String sortOrder;
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	/**
	 * 
	 * setCurrentPage:设置当前页码数
	 *
	 * @author   yumaochun
	 * @date     2016年12月8日
	 *
	 * @param currentPage        当前页码数
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
     * @author   yumaochun
     * @date     2016年12月8日
     *
     * @param pageSize         每页记录数
     */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
    
	public String getSortName() {
		StringBuffer sb = new StringBuffer();  
		if(sortName!=null){
			if(sortName.equals("deductionMoney")||sortName.equals("rentFreeMoney")||sortName.equals("totalPaymentMoney")||sortName.equals("cancelMoney")||sortName.equals("totalSaleReturnMoney")||sortName.equals("nopaymentMoney")||sortName.equals("shopsCode")){
				return sortName;
			}
			int index=sortName.indexOf("Name");
			if(index>0){
				return sortName;
			}
			for(int i=0;i<sortName.length();i++){
				char c = sortName.charAt(i);  
	            if(Character.isUpperCase(c)){  
	                sb.append("_"+Character.toLowerCase(c));  
	            }else{
	            	sb.append(c);  
	            }
			}
			if(sb.indexOf("area")>0){
				return "-"+sb;
			}
			return sb.toString();
		}else{
			return sortName;
		}
		
	}
	/**
	 * 前端传递参数，不进行转换
	 * */
	public String getRealSortName(){
			return sortName;
	}
    /**
     * 
     * setSortName:设置排序字段名称
     *
     * @author   yumaochun
     * @date     2016年12月8日
     *
     * @param sortName             排序字段名称
     */
	public void setSortName(String sortName) {
		
		this.sortName = sortName;
	}

	public String getSortOrder() {
		return sortOrder;
	}
    /**
     * 
     * setSortOrder:设置排序字段排序类型（升序或降序）
     *
     * @author   yumaochun
     * @date     2016年12月8日
     *
     * @param sortOrder     排序字段排序类型（升序或降序）
     */
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getMallId() {
		return mallId;
	}

	public void setMallId(String mallId) {
		this.mallId = mallId;
	}
}
