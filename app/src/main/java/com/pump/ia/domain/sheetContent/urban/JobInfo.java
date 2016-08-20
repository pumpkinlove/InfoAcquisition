package com.pump.ia.domain.sheetContent.urban;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/21 0021.
 */
public class JobInfo implements Serializable {

    private String job;
    private String company;             //工作单位/公司
    private String post;                //职务
    private String industry;            //所属单位行业
    private String department;          //单位部门
    private String inSeries;            //正式在编

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getInSeries() {
        return inSeries;
    }

    public void setInSeries(String inSeries) {
        this.inSeries = inSeries;
    }
}
