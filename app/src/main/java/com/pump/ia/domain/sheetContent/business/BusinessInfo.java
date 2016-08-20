package com.pump.ia.domain.sheetContent.business;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/21 0021.
 */
public class BusinessInfo implements Serializable {

    private String businessName;
    private String businessProject;
    private String businessTime;
    private String annualIncome;
    private String businessAddress;             //经营地址
    private String businessPlace;               //经营场所

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessProject() {
        return businessProject;
    }

    public void setBusinessProject(String businessProject) {
        this.businessProject = businessProject;
    }

    public String getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessPlace() {
        return businessPlace;
    }

    public void setBusinessPlace(String businessPlace) {
        this.businessPlace = businessPlace;
    }
}
