package com.pump.ia.domain.sheetContent.topublic;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/21 0021.
 */
public class EnterpriseFinance implements Serializable {

    private String annualIncome;                //企业年收入
    private String annualExpenditure;           //企业年支出
    private String isDebt;                      //或有负债

    public String getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getAnnualExpenditure() {
        return annualExpenditure;
    }

    public void setAnnualExpenditure(String annualExpenditure) {
        this.annualExpenditure = annualExpenditure;
    }

    public String getIsDebt() {
        return isDebt;
    }

    public void setIsDebt(String isDebt) {
        this.isDebt = isDebt;
    }

}
