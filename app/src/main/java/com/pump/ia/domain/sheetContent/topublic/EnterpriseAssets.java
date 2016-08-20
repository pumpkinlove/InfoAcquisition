package com.pump.ia.domain.sheetContent.topublic;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/21 0021.
 * 企业资产
 */
public class EnterpriseAssets implements Serializable {

    private String workShopArea;                //厂房面积
    private String workShopValue;               //厂房价值
    private String landArea;                    //土地面积
    private String landValue;                   //土地价值
    private String stockValue;                  //存货价值
    private String accountsReceivable;          //应收账款
    private String other;                       //其他
    private String total;                       //资产合计

    public String getWorkShopArea() {
        return workShopArea;
    }

    public void setWorkShopArea(String workShopArea) {
        this.workShopArea = workShopArea;
    }

    public String getWorkShopValue() {
        return workShopValue;
    }

    public void setWorkShopValue(String workShopValue) {
        this.workShopValue = workShopValue;
    }

    public String getLandArea() {
        return landArea;
    }

    public void setLandArea(String landArea) {
        this.landArea = landArea;
    }

    public String getLandValue() {
        return landValue;
    }

    public void setLandValue(String landValue) {
        this.landValue = landValue;
    }

    public String getStockValue() {
        return stockValue;
    }

    public void setStockValue(String stockValue) {
        this.stockValue = stockValue;
    }

    public String getAccountsReceivable() {
        return accountsReceivable;
    }

    public void setAccountsReceivable(String accountsReceivable) {
        this.accountsReceivable = accountsReceivable;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
