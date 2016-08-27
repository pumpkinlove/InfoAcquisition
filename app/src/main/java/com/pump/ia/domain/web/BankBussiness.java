package com.pump.ia.domain.web;

/**
 * 
 * @ClassName:     
 * @Description:银行业务
 * @author: lsy  
 * @date:   2016-8-24 下午2:01:52   
 *
 */
public class BankBussiness extends BaseDomain {
	private static final long serialVersionUID = -3078775085675129041L;
	private String cardNo;//证件号码
	private String busBank;//所属银行代码    我行，  他行dict_busofbank
	private String busBankVal;// 所属银行名称
	private String busType;//银行业务类型dict_bankbustype
	private String busTypeVal;// 存款、贷款、理财等
	private String busVal;//银行业务内容，目前填是否dict_yesno
	private String busValDisplay;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
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

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getBusTypeVal() {
		return busTypeVal;
	}

	public void setBusTypeVal(String busTypeVal) {
		this.busTypeVal = busTypeVal;
	}

	public String getBusVal() {
		return busVal;
	}

	public void setBusVal(String busVal) {
		this.busVal = busVal;
	}

	public String getBusValDisplay() {
		return busValDisplay;
	}

	public void setBusValDisplay(String busValDisplay) {
		this.busValDisplay = busValDisplay;
	}

}
