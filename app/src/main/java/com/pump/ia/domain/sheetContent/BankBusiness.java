package com.pump.ia.domain.sheetContent;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/21 0021.
 * 银行业务
 */
public class BankBusiness implements Serializable {

    private String belong;                  //所属  我行/他行
    private String deposit;                 //存款余额
    private String loan;                    //贷款余额
    private String finance;                 //理财余额
    private String bankCard;                //银行卡
    private String eBank;                   //电子银行
    private String pos;                     //POS
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
