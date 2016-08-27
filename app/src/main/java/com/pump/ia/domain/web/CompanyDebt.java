package com.pump.ia.domain.web;

/**
 * 
 * @ClassName:     
 * @Description:公司负债
 * @author: lsy  
 * @date:   2016-8-24 下午2:01:52   
 *
 */
public class CompanyDebt extends BaseDomain {
	private static final long serialVersionUID = -4219952045780784922L;
	private Integer compId;//企业id
	private String busBank;//所属行，我行他行 dict_busofbank
	private String busBankVal;
	private String debtType;//贷款类型dict_debttype
	private String debtTypeVal;
	private float debtVal;//贷款金额

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getBusBank() {
		return busBank;
	}

	public void setBusBank(String busBank) {
		this.busBank = busBank;
	}

	public String getBusBankVal() {
		return busBankVal;
	}

	public void setBusBankVal(String busBankVal) {
		this.busBankVal = busBankVal;
	}

	public String getDebtType() {
		return debtType;
	}

	public void setDebtType(String debtType) {
		this.debtType = debtType;
	}

	public String getDebtTypeVal() {
		return debtTypeVal;
	}

	public void setDebtTypeVal(String debtTypeVal) {
		this.debtTypeVal = debtTypeVal;
	}

	public float getDebtVal() {
		return debtVal;
	}

	public void setDebtVal(float debtVal) {
		this.debtVal = debtVal;
	}

}
