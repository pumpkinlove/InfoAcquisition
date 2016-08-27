package com.pump.ia.domain.web;


/**
 * 
 * @ClassName:     
 * @Description:我的银行业务
 * @author: lsy  
 * @date:   2016-8-24 下午2:01:52   
 *
 */
public class MyBankBussiness extends BaseDomain {
	private static final long serialVersionUID = -5448414539134705322L;
	private String cardNo;//客户证件号码
	private String custName;//客户姓名
	private String custType;//客户类型dict_custtype
	private String custTypeVal;
	private String orgCode;//网点编号
	private String orgNode;
	private String orgName;
	private String bankBusType;//银行业务类型dict_bankbustype
	private String bankBusTypeVal;
	private String beginDate;//贷款、还款日期
	private String endDate;//贷款、还款结束日期
	private float busVal;//贷款还款金额
	private String remark;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgNode() {
		return orgNode;
	}

	public void setOrgNode(String orgNode) {
		this.orgNode = orgNode;
	}

	public String getBankBusType() {
		return bankBusType;
	}

	public void setBankBusType(String bankBusType) {
		this.bankBusType = bankBusType;
	}

	public String getBankBusTypeVal() {
		return bankBusTypeVal;
	}

	public void setBankBusTypeVal(String bankBusTypeVal) {
		this.bankBusTypeVal = bankBusTypeVal;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public float getBusVal() {
		return busVal;
	}

	public void setBusVal(float busVal) {
		this.busVal = busVal;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getCustTypeVal() {
		return custTypeVal;
	}

	public void setCustTypeVal(String custTypeVal) {
		this.custTypeVal = custTypeVal;
	}

	

}
