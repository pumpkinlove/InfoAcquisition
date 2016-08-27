package com.pump.ia.domain.web;


public class FamilyAsset extends BaseDomain {
	private static final long serialVersionUID = -6517835724807444510L;
	private String assetType;//资产类型dict_assettype
	private String assetTypeVal;
	private float quantity;//资产数量
	private float worth;//家庭资产
	private String familyCode;//家庭编号

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


	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getWorth() {
		return worth;
	}

	public void setWorth(float worth) {
		this.worth = worth;
	}

	public String getFamilyCode() {
		return familyCode;
	}

	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}

}
