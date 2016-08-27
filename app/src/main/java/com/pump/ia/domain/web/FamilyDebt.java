package com.pump.ia.domain.web;

/**
 * 
 * @ClassName:     
 * @Description:家庭负债
 * @author: lsy  
 * @date:   2016-8-24 下午2:01:52   
 *
 */
public class FamilyDebt extends BaseDomain{
	private static final long serialVersionUID = -2422672109626647624L;
	private String debtType;//负债类型dict_debttype
	private String debtTypeVal;
	private float debtVal;//负债金额
	private String familyCode;//家庭编码

	public String getDebtType() {
		return debtType;
	}
	public void setDebtType(String debtType) {
		this.debtType = debtType;
	}
	public float getDebtVal() {
		return debtVal;
	}
	public void setDebtVal(float debtVal) {
		this.debtVal = debtVal;
	}
	public String getFamilyCode() {
		return familyCode;
	}
	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}
	public String getDebtTypeVal() {
		return debtTypeVal;
	}
	public void setDebtTypeVal(String debtTypeVal) {
		this.debtTypeVal = debtTypeVal;
	}
	
}
