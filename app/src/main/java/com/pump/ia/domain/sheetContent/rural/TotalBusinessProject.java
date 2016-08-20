package com.pump.ia.domain.sheetContent.rural;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/7/21 0021.
 */
public class TotalBusinessProject implements Serializable {

    private List<BusinessProject> businessProjectList;
    private String totalIncome;

    public List<BusinessProject> getBusinessProjectList() {
        return businessProjectList;
    }

    public void setBusinessProjectList(List<BusinessProject> businessProjectList) {
        this.businessProjectList = businessProjectList;
    }

    public String getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(String totalIncome) {
        this.totalIncome = totalIncome;
    }
}
