package com.pump.ia.domain.web;

/**
 * 
 * @ClassName:     
 * @Description:潜在办理业务需求
 * @author: lsy  
 * @date:   2016-8-24 下午2:01:52   
 *
 */
public class UnderlyingNeed extends BaseDomain {
	private static final long serialVersionUID = 2200141084686327241L;
	private String cardNo;//客户证件号码
	private String busType;//业务类型dict_bankbustype
	private String busTypeVal;
	private String busVal;//业务价值 是否dict_yesno
	private String busValDisplay;//显示

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
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
