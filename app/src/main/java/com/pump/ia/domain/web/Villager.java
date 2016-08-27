package com.pump.ia.domain.web;

import java.util.Date;

/**
 * 
 * @ClassName:     
 * @Description:农村居民
 * @author: lsy  
 * @date:   2016-8-24 下午2:01:52   
 *
 */
public class Villager extends Person {
	private static final long serialVersionUID = 1L;
	private String village;//行政村

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public Date getCreateDate() {
		return super.getCreateDate();
	}
}
