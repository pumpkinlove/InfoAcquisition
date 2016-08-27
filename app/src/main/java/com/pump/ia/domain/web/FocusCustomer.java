package com.pump.ia.domain.web;

/**
 * 
 * @ClassName:     
 * @Description:关注客户
 * @author: lsy  
 * @date:   2016-8-24 下午2:01:52   
 *
 */
public class FocusCustomer extends BaseDomain{
	private static final long serialVersionUID = -3059231470966499995L;
	private Integer userId;//用户id
	private String custNo;//客户代码
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	
}
