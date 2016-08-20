package com.pump.ia.domain;

/**
 * Created by xu.nan on 2016/8/17.
 */
public class SimpleCustomer {

    private String name;
    private String type;
    private String certificate;
    private String follow;                  //是否关注

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getFollow() {
        return follow;
    }

    public void setFollow(String follow) {
        this.follow = follow;
    }
}
