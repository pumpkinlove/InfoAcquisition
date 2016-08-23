package com.pump.ia.domain.sheetContent;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/21 0021.
 * 银行业务
 */
public class BankBusiness implements Serializable {

    private String money;
    private String beginDate;
    private String endDate;

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
