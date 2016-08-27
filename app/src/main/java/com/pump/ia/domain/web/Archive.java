package com.pump.ia.domain.web;

/**
 * 
 * @ClassName:  Archive   
 * @Description:客户档案
 * @author: Android_Robot  
 * @date:   2016-8-24 下午2:20:26   
 *
 */
public class Archive extends BaseDomain {
	private static final long serialVersionUID = 8142853560463941541L;
	private String cardNo;//证件号码
	private String conclusion;//结论
	private String remark;//备注

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
