package com.pump.ia.domain.web;

/**
 * 
 * @ClassName:     
 * @Description:村民经营项目
 * @author: lsy  
 * @date:   2016-8-24 下午2:01:52   
 *
 */
public class VillagerProject extends BaseDomain {
	private static final long serialVersionUID = 8352902940254729805L;
	private String cardNo;//证件号码
	private String projectType;//经营种类dict_vilprojecttype
	private String projectTypeVal;
	private String projectKind;//种类子类dict_planttype种植，dict_breedtype//养殖，dict_bustype经商
	private String projectKindVal;
	private String workAddress;//打工地址
	private String projectsCale;//项目规模
	private float yearIncome;//年收入

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getProjectTypeVal() {
		return projectTypeVal;
	}

	public void setProjectTypeVal(String projectTypeVal) {
		this.projectTypeVal = projectTypeVal;
	}

	public String getProjectKind() {
		return projectKind;
	}

	public void setProjectKind(String projectKind) {
		this.projectKind = projectKind;
	}

	public String getProjectKindVal() {
		return projectKindVal;
	}

	public void setProjectKindVal(String projectKindVal) {
		this.projectKindVal = projectKindVal;
	}

	public String getProjectsCale() {
		return projectsCale;
	}

	public void setProjectsCale(String projectsCale) {
		this.projectsCale = projectsCale;
	}

	public float getYearIncome() {
		return yearIncome;
	}

	public void setYearIncome(float yearIncome) {
		this.yearIncome = yearIncome;
	}

	public String getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}


}
