package com.pump.ia.domain.web;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

import java.util.Date;

/**
 * 
 * @ClassName:     
 * @Description:银行员工类
 * @author: lsy  
 * @date:   2016-8-24 下午2:01:52   
 *
 */
@Table(name = "worker")
public class Worker{
	private static final long serialVersionUID = 1L;

	@Column(name = "id",isId = true, autoGen = true)
	private int id;
	@Column(name = "createDate")
	private Date createDate;
	@Column(name = "updateDate")
	private Date updateDate;
	@Column(name = "createUser")
	private String createUser;
	@Column(name = "updateUser")
	private String updateUser;
	@Column(name = "workerCode")
	private String workerCode;//员工编号
	@Column(name = "workerName")
	private String workerName;//员工姓名
	@Column(name = "idCard")
	private String idCard;//身份证
	@Column(name = "sex")
	private String sex;//性别
	@Column(name = "sexName")
	private String sexName;
	@Column(name = "birthday")
	private String birthday;//出生日期
	@Column(name = "workerStatus")
	private String workerStatus;//工作状态
	@Column(name = "workerStatusName")
	private String workerStatusName;
	@Column(name = "workerType")
	private String workerType;//员工类型
	@Column(name = "workerTypeName")
	private String workerTypeName;
	@Column(name = "mobile")
	private String mobile;//联系电话
	@Column(name = "password")
	private String password;//密码
	@Column(name = "workerPhoto")
	private String workerPhoto;//照片
	@Column(name = "orgCode")
	private String orgCode;//网点
	@Column(name = "orgNode")
	private String orgNode;
	@Column(name = "orgName")
	private String orgName;
	@Column(name = "remark")
	private String remark;
	@Column(name = "pageNum")
	private Integer pageNum;
	@Column(name = "pageSize")
	private Integer pageSize;
	@Column(name = "sortName")
	private String sortName;
	@Column(name = "sortType")
	private String sortType;

	public String getWorkerCode() {
		return workerCode;
	}

	public void setWorkerCode(String workerCode) {
		this.workerCode = workerCode;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getWorkerStatus() {
		return workerStatus;
	}

	public void setWorkerStatus(String workerStatus) {
		this.workerStatus = workerStatus;
	}

	public String getWorkerType() {
		return workerType;
	}

	public void setWorkerType(String workerType) {
		this.workerType = workerType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWorkerPhoto() {
		return workerPhoto;
	}

	public void setWorkerPhoto(String workerPhoto) {
		this.workerPhoto = workerPhoto;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgNode() {
		return orgNode;
	}

	public void setOrgNode(String orgNode) {
		this.orgNode = orgNode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public String getWorkerStatusName() {
		return workerStatusName;
	}

	public void setWorkerStatusName(String workerStatusName) {
		this.workerStatusName = workerStatusName;
	}

	public String getWorkerTypeName() {
		return workerTypeName;
	}

	public void setWorkerTypeName(String workerTypeName) {
		this.workerTypeName = workerTypeName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
}
