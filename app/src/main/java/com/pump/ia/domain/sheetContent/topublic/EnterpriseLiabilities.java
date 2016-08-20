package com.pump.ia.domain.sheetContent.topublic;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/21 0021.
 */
public class EnterpriseLiabilities implements Serializable {

    private String belong;                  //所属行
    private String bankLiabilities;         //银行贷款
    private String nonBankLiabilities;      //非银行贷款
    private String accountPayable;          //应付账款
    private String other;                   //其他
    private String total;                   //负债合计

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getBankLiabilities() {
        return bankLiabilities;
    }

    public void setBankLiabilities(String bankLiabilities) {
        this.bankLiabilities = bankLiabilities;
    }

    public String getNonBankLiabilities() {
        return nonBankLiabilities;
    }

    public void setNonBankLiabilities(String nonBankLiabilities) {
        this.nonBankLiabilities = nonBankLiabilities;
    }

    public String getAccountPayable() {
        return accountPayable;
    }

    public void setAccountPayable(String accountPayable) {
        this.accountPayable = accountPayable;
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
