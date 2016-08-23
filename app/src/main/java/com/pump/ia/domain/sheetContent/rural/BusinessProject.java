package com.pump.ia.domain.sheetContent.rural;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/21 0021.
 * 经营项目（农村居民）
 */
public class BusinessProject implements Serializable {

    private String type;
    private String businessType;
    private String scale;               //规模
    private String annualIncome;

    public BusinessProject() {
    }

    public BusinessProject(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }
}
