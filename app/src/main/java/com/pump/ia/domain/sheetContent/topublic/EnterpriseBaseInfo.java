package com.pump.ia.domain.sheetContent.topublic;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/21 0021.
 * 企业基本信息
 */
public class EnterpriseBaseInfo implements Serializable {

    private String businessProject;             //经营项目
    private String totalAssets;                 //资产总额
    private String totalLiabilities;            //负债总额
    private String salesThisYear;               //本年销售收入
    private String mainBusinessProfit;          //主营业务利润
    private String basicAccount;                //基本户开户行

    public String getBusinessProject() {
        return businessProject;
    }

    public void setBusinessProject(String businessProject) {
        this.businessProject = businessProject;
    }

    public String getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(String totalAssets) {
        this.totalAssets = totalAssets;
    }

    public String getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(String totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }

    public String getSalesThisYear() {
        return salesThisYear;
    }

    public void setSalesThisYear(String salesThisYear) {
        this.salesThisYear = salesThisYear;
    }

    public String getMainBusinessProfit() {
        return mainBusinessProfit;
    }

    public void setMainBusinessProfit(String mainBusinessProfit) {
        this.mainBusinessProfit = mainBusinessProfit;
    }

    public String getBasicAccount() {
        return basicAccount;
    }

    public void setBasicAccount(String basicAccount) {
        this.basicAccount = basicAccount;
    }
}
