package com.pump.ia.domain.sheetContent.topublic;

import java.io.Serializable;

/**
 * Created by xu.nan on 2016/8/23.
 */
public class EnterpriseDemand implements Serializable{

    private String deposit;
    private String loan;
    private String finance;
    private String eBank;
    private String pos;
    private String foreignCurrency;
    private String salary;
    private String other;

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
