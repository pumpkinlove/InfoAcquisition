package com.pump.ia.domain.web;

/**
 * 
 * @ClassName:     
 * @Description:个体商户
 * @author: lsy  
 * @date:   2016-8-24 下午2:01:52   
 *
 */
public class Vendor extends Person {
	private static final long serialVersionUID = 4973987460482825977L;
	private String store;//商铺名称
	private String storeProject;//经营项目
	private String storeAddress;//	经营地址
	private String storeYears;//经营年限
	private String yearIncome;//经营年收入
	private String storePlace;//经营场所
	private String createUserCode;
	private String updateUserCode;
	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getStoreProject() {
		return storeProject;
	}

	public void setStoreProject(String storeProject) {
		this.storeProject = storeProject;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStoreYears() {
		return storeYears;
	}

	public void setStoreYears(String storeYears) {
		this.storeYears = storeYears;
	}

	public String getYearIncome() {
		return yearIncome;
	}

	public void setYearIncome(String yearIncome) {
		this.yearIncome = yearIncome;
	}

	public String getStorePlace() {
		return storePlace;
	}

	public void setStorePlace(String storePlace) {
		this.storePlace = storePlace;
	}


	public String getCreateUserCode() {
		return createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	public String getUpdateUserCode() {
		return updateUserCode;
	}

	public void setUpdateUserCode(String updateUserCode) {
		this.updateUserCode = updateUserCode;
	}

}
