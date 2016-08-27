package com.pump.ia.domain.web;


import android.text.TextUtils;

/**
 * 
 * @ClassName:     
 * @Description:客户基类，村民、商户、城镇居民
 * @author: lsy  
 * @date:   2016-8-24 下午2:01:52   
 *
 */
public class Person extends BaseDomain {
	private static final long serialVersionUID = 6117467847023693454L;
	private String name;//客户姓名
	private String sex;//客户性别
	private String sexVal;
	private String nation;//民族dict_nation
	private String nationVal;
	private String status;//状态，暂时不用
	private String statusVal;
	private String marryStatus;//婚姻状况dict_marrystatus
	private String marryStatusVal;
	private String cardType;//证件类型dict_cardtype
	private String cardTypeVal;
	private String cardNo;//证件号码
	private String birthday;//出生日期
	private String birthYear;//出生年
	private String birthMonth;//出生月
	private String birthDate;//出生日期
	private String mobile;//联系电话
	private String address;//家庭住址
	private String credit;//信用级别dict_credit
	private String creditVal;
	private String orgCode;//所属网点
	private String orgNode;
	private String orgName;
	private Integer serviceCount;//服务次数
	private float assetWorth;//总资产
	private float debtWorth;//总负债
	private String bookAddress;//登记地址
	private String familyCode;//家庭代码
	private String remark;
	private String createUserCode;
	private String updateUserCode;
	private String custType;//客户类型dict_custtype
	private String custTypeVal;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSexVal() {
		return sexVal;
	}
	public void setSexVal(String sexVal) {
		this.sexVal = sexVal;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getNationVal() {
		return nationVal;
	}
	public void setNationVal(String nationVal) {
		this.nationVal = nationVal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusVal() {
		return statusVal;
	}
	public void setStatusVal(String statusVal) {
		this.statusVal = statusVal;
	}
	
	public String getMarryStatus() {
		return marryStatus;
	}
	public void setMarryStatus(String marryStatus) {
		this.marryStatus = marryStatus;
	}
	public String getMarryStatusVal() {
		return marryStatusVal;
	}
	public void setMarryStatusVal(String marryStatusVal) {
		this.marryStatusVal = marryStatusVal;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardTypeVal() {
		return cardTypeVal;
	}
	public void setCardTypeVal(String cardTypeVal) {
		this.cardTypeVal = cardTypeVal;
	}
	public String getBirthday() {
		this.birthday=this.getBirthYear()+"-"+this.getBirthMonth()+"-"+this.getBirthDate();
		return this.birthday;
	}
	public void setBirthday(String birthday) {
		if(!TextUtils.isEmpty(birthday)){
			String[] spbirth=birthday.split("-");
			this.birthYear=spbirth[0];
			this.birthMonth=spbirth[1];
			this.birthDate=spbirth[2];
		}
		this.birthday = birthday;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getCreditVal() {
		return creditVal;
	}
	public void setCreditVal(String creditVal) {
		this.creditVal = creditVal;
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
	public String getFamilyCode() {
		return familyCode;
	}
	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getBookAddress() {
		return bookAddress;
	}
	public void setBookAddress(String bookAddress) {
		this.bookAddress = bookAddress;
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
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	public String getBirthMonth() {
		return birthMonth;
	}
	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public Integer getServiceCount() {
		return serviceCount;
	}
	public void setServiceCount(Integer serviceCount) {
		this.serviceCount = serviceCount;
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
