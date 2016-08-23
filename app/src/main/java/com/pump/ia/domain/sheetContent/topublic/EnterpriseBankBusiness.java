package com.pump.ia.domain.sheetContent.topublic;

import java.io.Serializable;

/**
 * Created by xu.nan on 2016/8/23.
 */
public class EnterpriseBankBusiness implements Serializable {

    private String belong;                  //所属  我行/他行
    private String deposit;                 //存款余额
    private String loan;                    //贷款余额
    private String finance;                 //理财余额
    private String eBank;                   //电子银行
    private String pos;                     //POS
    private String foreignCurrency;         //外汇
    private String salary;                  //代发工资
    private String other;                   //其他

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getLoan() {
        return loan;
    }

    public void setLoan(String loan) {
        this.loan = loan;
    }

    public String getFinance() {
        return finance;
    }

    public void setFinance(String finance) {
        this.finance = finance;
    }

    public String geteBank() {
        return eBank;
    }

    public void seteBank(String eBank) {
        this.eBank = eBank;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getForeignCurrency() {
        return foreignCurrency;
    }

    public void setForeignCurrency(String foreignCurrency) {
        this.foreignCurrency = foreignCurrency;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
