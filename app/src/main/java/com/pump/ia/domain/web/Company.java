package com.pump.ia.domain.web;

/**
 * 
 * @ClassName:     
 * @Description:公司
 * @author: lsy  
 * @date:   2016-8-24 下午2:01:52   
 *
 */
public class Company extends BaseDomain {
	private static final long serialVersionUID = 6760414424521948163L;
	private String compName;// 企业名称
	private String corporation;// 企业法人
	private String corpCardNo;// 法人证件号码
	private String regCapital;// 注册资本
	private String compHolder;// 实际控制人
	private String holderCardNo;// 控制人号码
	private String compADdress;// 企业地址
	private String contact;// 联系人
	private String contactMobile;// 联系人电话
	private String project;// 经营项目
	private float asset;// 公司资产
	private float debt;// 负债
	private float yearSales;// 年销售额
	private float busProfit;// 业务利润
	private String openBank;// 开户行
	private String status;// 状态 暂时不维护
	private String statusVal;// 状态
	private String credit;// 信用等级 dict_credit
	private String creditVal;// 信用
	private String orgCode;// 网点
	private String orgNode;
	private String orgName;
	private String bookAddress;// 采集地址
	private String remark;// 备注
	private String createUserCode;
	private String updateUserCode;
	private int serviceCount;
	private float assetWorth;//总资产
	private float debtWorth;//总负债
	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCorporation() {
		return corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public String getCorpCardNo() {
		return corpCardNo;
	}

	public void setCorpCardNo(String corpCardNo) {
		this.corpCardNo = corpCardNo;
	}

	public String getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(String regCapital) {
		this.regCapital = regCapital;
	}

	public String getCompHolder() {
		return compHolder;
	}

	public void setCompHolder(String compHolder) {
		this.compHolder = compHolder;
	}

	public String getHolderCardNo() {
		return holderCardNo;
	}

	public void setHolderCardNo(String holderCardNo) {
		this.holderCardNo = holderCardNo;
	}

	public String getCompADdress() {
		return compADdress;
	}

	public void setCompADdress(String compADdress) {
		this.compADdress = compADdress;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public float getAsset() {
		return asset;
	}

	public void setAsset(float asset) {
		this.asset = asset;
	}

	public float getDebt() {
		return debt;
	}

	public void setDebt(float debt) {
		this.debt = debt;
	}

	public float getYearSales() {
		return yearSales;
	}

	public void setYearSales(float yearSales) {
		this.yearSales = yearSales;
	}

	public float getBusProfit() {
		return busProfit;
	}

	public void setBusProfit(float busProfit) {
		this.busProfit = busProfit;
	}

	public String getOpenBank() {
		return openBank;
	}

	public void setOpenBank(String openBank) {
		this.openBank = openBank;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
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

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getBookAddress() {
		return bookAddress;
	}

	public void setBookAddress(String bookAddress) {
		this.bookAddress = bookAddress;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatusVal() {
		return statusVal;
	}

	public void setStatusVal(String statusVal) {
		this.statusVal = statusVal;
	}

	public String getCreditVal() {
		return creditVal;
	}

	public void setCreditVal(String creditVal) {
		this.creditVal = creditVal;
	}

	public String getCreateUserCode() {
		return createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	public String getUpdateUserCode() {
		return updateUserCode;
	}

	public void setUpdateUserCode(String updateUserCode) {
		this.updateUserCode = updateUserCode;
	}

	public int getServiceCount() {
		return serviceCount;
	}

	public void setServiceCount(int serviceCount) {
		this.serviceCount = serviceCount;
	}

	public float getAssetWorth() {
		return assetWorth;
	}

	public void setAssetWorth(float assetWorth) {
		this.assetWorth = assetWorth;
	}

	public float getDebtWorth() {
		return debtWorth;
	}

	public void setDebtWorth(float debtWorth) {
		this.debtWorth = debtWorth;
	}

}
