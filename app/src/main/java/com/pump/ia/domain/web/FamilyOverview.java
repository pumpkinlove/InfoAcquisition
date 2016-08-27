package com.pump.ia.domain.web;

/**
 * 
 * @ClassName:     
 * @Description:家庭概况
 * @author: lsy  
 * @date:   2016-8-24 下午2:01:52   
 *
 */
public class FamilyOverview extends BaseDomain {
	private static final long serialVersionUID = 5594309852377641298L;
	private String familyCode;//家庭代码
	private float yearIncome;//家庭年收入
	private float yearOutlay;//家庭年支出
	private float possibleDebt;//家庭或有贷款

	public String getFamilyCode() {
		return familyCode;
	}

	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}

	public float getYearIncome() {
		return yearIncome;
	}

	public void setYearIncome(float yearIncome) {
		this.yearIncome = yearIncome;
	}

	public float getYearOutlay() {
		return yearOutlay;
	}

	public void setYearOutlay(float yearOutlay) {
		this.yearOutlay = yearOutlay;
	}

	public float getPossibleDebt() {
		return possibleDebt;
	}

	public void setPossibleDebt(float possibleDebt) {
		this.possibleDebt = possibleDebt;
	}


}
