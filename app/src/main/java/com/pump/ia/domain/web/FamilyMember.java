package com.pump.ia.domain.web;

/**
 * 
 * @ClassName:     
 * @Description:家庭成员
 * @author: lsy  
 * @date:   2016-8-24 下午2:01:52   
 *
 */
public class FamilyMember extends BaseDomain {
	private static final long serialVersionUID = -8541217698695228150L;
	private String name;//成员姓名
	private String relationship;//成员关系dict_familyrelation
	private String relationshipVal;
	private String profession;//职业dict_profession
	private String professionVal;
	private float yearIncome;//年收入
	private String marryStatus;//婚姻状况dict_marrystatus
	private String marryStatusVal;
	private String cardNo;//证件号码
	private String mobile;//联系方式
	private String familyCode;//家庭代码
	private String remark;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getRelationshipVal() {
		return relationshipVal;
	}

	public void setRelationshipVal(String relationshipVal) {
		this.relationshipVal = relationshipVal;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getProfessionVal() {
		return professionVal;
	}

	public void setProfessionVal(String professionVal) {
		this.professionVal = professionVal;
	}

	public float getYearIncome() {
		return yearIncome;
	}

	public void setYearIncome(float yearIncome) {
		this.yearIncome = yearIncome;
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

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

}
