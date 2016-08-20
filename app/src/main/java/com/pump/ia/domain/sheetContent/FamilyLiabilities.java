package com.pump.ia.domain.sheetContent;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/21 0021.
 * 家庭总负债
 */
public class FamilyLiabilities implements Serializable {

    private String bankLoans;               //银行贷款
    private String creditCardOverdraft;     //信用卡透支
    private String nonBankLoans;            //非银行贷款
    private String other;
    private String totalLiabilities;        //负债合计

    public String getBankLoans() {
        return bankLoans;
    }

    public void setBankLoans(String bankLoans) {
        this.bankLoans = bankLoans;
    }

    public String getCreditCardOverdraft() {
        return creditCardOverdraft;
    }

    public void setCreditCardOverdraft(String creditCardOverdraft) {
        this.creditCardOverdraft = creditCardOverdraft;
    }

    public String getNonBankLoans() {
        return nonBankLoans;
    }

    public void setNonBankLoans(String nonBankLoans) {
        this.nonBankLoans = nonBankLoans;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(String totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }
}

