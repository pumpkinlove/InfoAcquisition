package com.pump.ia.domain.web;


public class CompanyOverview extends BaseDomain {
	private static final long serialVersionUID = 5594309852377641298L;
	private String compId;
	private float yearIncome;
	private float yearOutlay;
	private float possibleDebt;

	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
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
