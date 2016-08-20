package com.pump.ia.domain.sheetContent;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/21 0021.
 * 潜在需求
 */
public class PotentialDemand implements Serializable {

    private String deposit;
    private String loan;
    private String finance;
    private String bankCard;
    private String eBank;
    private String pos;
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

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
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

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
