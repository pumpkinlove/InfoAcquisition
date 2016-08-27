package com.pump.ia.domain.web;

/**
 * 
 * @ClassName:     
 * @Description:公司资产
 * @author: lsy  
 * @date:   2016-8-24 下午2:01:52   
 *
 */
public class CompanyAsset extends BaseDomain {
	private static final long serialVersionUID = -2220816970892799935L;
	private Integer compId;//企业id
	private String assetType;//资产类型dict_assettype
	private String assetTypeVal;
	private float worth;//资产价值



	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getAssetTypeVal() {
		return assetTypeVal;
	}

	public void setAssetTypeVal(String assetTypeVal) {
		this.assetTypeVal = assetTypeVal;
	}

	public float getWorth() {
		return worth;
	}

	public void setWorth(float worth) {
		this.worth = worth;
	}

}
