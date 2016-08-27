package com.pump.ia.domain.web;

/**
 * 
 * @ClassName:     
 * @Description:服务日志
 * @author: lsy  
 * @date:   2016-8-24 下午2:01:52   
 *
 */
public class ServiceLog extends BaseDomain {
	private static final long serialVersionUID = -5009437180086053058L;
	private Integer workerId;//员工id
	private String workerName;//员工姓名
	private String workerMobile;//员工电话
	private String workType;//服务类型dict_worktype
	private String workTypeVal;
	private String servicetype;//服务方式dict_servicetype
	private String servicetypeVal;
	private String orgCode;
	private String orgNode;
	private String orgName;
	private String custNo;//客户编号
	private String custType;//客户类型dict_custtype
	private String custTypeVal;
	private String custName;//客户姓名
	private String serviceInfo;//服务内容
	private String serviceAddress;//服务地址 gps
	private String deviceType;//设备类型dict_devicetype
	private String deviceTypeVal;
	public Integer getWorkerId() {
		return workerId;
	}
	public void setWorkerId(Integer workerId) {
		this.workerId = workerId;
	}
	
	public String getWorkerName() {
		return workerName;
	}
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
	
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getServiceInfo() {
		return serviceInfo;
	}
	public void setServiceInfo(String serviceInfo) {
		this.serviceInfo = serviceInfo;
	}
	public String getServiceAddress() {
		return serviceAddress;
	}
	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
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
	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getWorkTypeVal() {
		return workTypeVal;
	}
	public void setWorkTypeVal(String workTypeVal) {
		this.workTypeVal = workTypeVal;
	}
	public String getServicetype() {
		return servicetype;
	}
	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}
	public String getServicetypeVal() {
		return servicetypeVal;
	}
	public void setServicetypeVal(String servicetypeVal) {
		this.servicetypeVal = servicetypeVal;
	}
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getDeviceTypeVal() {
		return deviceTypeVal;
	}
	public void setDeviceTypeVal(String deviceTypeVal) {
		this.deviceTypeVal = deviceTypeVal;
	}
	public String getCustTypeVal() {
		return custTypeVal;
	}
	public void setCustTypeVal(String custTypeVal) {
		this.custTypeVal = custTypeVal;
	}
	public String getWorkerMobile() {
		return workerMobile;
	}
	public void setWorkerMobile(String workerMobile) {
		this.workerMobile = workerMobile;
	}
	

}
