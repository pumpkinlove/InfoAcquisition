package com.pump.ia.domain.sheetContent.topublic;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/21 0021.
 * 对公
 */
public class EnterpriseInfo implements Serializable {

    private String enterpriseName;                  //企业名称
    private String legalPerson;                     //法定代表人
    private String legalPersonCertificate;          //法定代表人证件号码
    private String registeredCapital;               //注册资金
    private String actualController;                //实际控制人
    private String actualControllerCertificate;     //实际控制人证件号码
    private String enterpriseAddress;               //企业地址
    private String contactor;                       //联系人
    private String phoneNumber;                     //联系电话

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getLegalPersonCertificate() {
        return legalPersonCertificate;
    }

    public void setLegalPersonCertificate(String legalPersonCertificate) {
        this.legalPersonCertificate = legalPersonCertificate;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getActualController() {
        return actualController;
    }

    public void setActualController(String actualController) {
        this.actualController = actualController;
    }

    public String getActualControllerCertificate() {
        return actualControllerCertificate;
    }

    public void setActualControllerCertificate(String actualControllerCertificate) {
        this.actualControllerCertificate = actualControllerCertificate;
    }

    public String getEnterpriseAddress() {
        return enterpriseAddress;
    }

    public void setEnterpriseAddress(String enterpriseAddress) {
        this.enterpriseAddress = enterpriseAddress;
    }

    public String getContactor() {
        return contactor;
    }

    public void setContactor(String contactor) {
        this.contactor = contactor;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
