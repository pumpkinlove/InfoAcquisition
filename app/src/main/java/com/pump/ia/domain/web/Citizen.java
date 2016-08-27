package com.pump.ia.domain.web;
/**
 * 
 * @ClassName:     
 * @Description:城镇居民
 * @author: lsy  
 * @date:   2016-8-24 下午2:01:52   
 *
 */
public class Citizen extends Person {
	private static final long serialVersionUID = -5892798889988142051L;
	private String profession;//职业dict_profession
	private String professionVal;
	private String unit;//单位
	private String post;//职务dict_post
	private String postVal;
	private String unitIndustry;//行业dict_industry
	private String unitIndustryVal;
	private String dept;//部门
	private String formally;//是否在编dict_yesno
	private String formallyVal;
	private String createUserCode;
	private String updateUserCode;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getPostVal() {
		return postVal;
	}

	public void setPostVal(String postVal) {
		this.postVal = postVal;
	}

	public String getUnitIndustry() {
		return unitIndustry;
	}

	public void setUnitIndustry(String unitIndustry) {
		this.unitIndustry = unitIndustry;
	}

	public String getUnitIndustryVal() {
		return unitIndustryVal;
	}

	public void setUnitIndustryVal(String unitIndustryVal) {
		this.unitIndustryVal = unitIndustryVal;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getFormally() {
		return formally;
	}

	public void setFormally(String formally) {
		this.formally = formally;
	}

	public String getFormallyVal() {
		return formallyVal;
	}

	public void setFormallyVal(String formallyVal) {
		this.formallyVal = formallyVal;
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

}
