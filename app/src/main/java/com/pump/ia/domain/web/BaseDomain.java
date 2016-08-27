package com.pump.ia.domain.web;
import java.io.Serializable;
import java.util.Date;

abstract public class BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date createDate;
	private Date updateDate;
	private String createUser;
	private String updateUser;
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

	private Integer pageNum;
	private Integer pageSize;
	private String sortName;
	private String sortType;
	
	@Override
	public int hashCode() {
		if (id != null) {
			final int prime = 31;
			int result = 1;
			result = prime * (prime * result + getClass().hashCode()) + id.hashCode();
			return result;
		}
		return super.hashCode();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BaseDomain)) {
			return false;
		}

		if ((getClass().isAssignableFrom(obj.getClass())) || (obj.getClass().isAssignableFrom(getClass()))) {

		} else {
			return false;
		}

		BaseDomain other = (BaseDomain) obj;
		if (other.getId() == null || getId() == null) {
			return false;
		} else {
			if (other.getId().equals(getId())) {
				return true;
			} else {
				return false;
			}
		}
	}
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	public String getSortname() {
		if(sortName == null || "".equals(sortName)){
			return "ID";
		}
		return sortName;
	}

	public void setSortname(String sortname) {
		this.sortName = sortname;
	}

	public String getSortType() {
		if(sortName == null || "".equals(sortName)){
			return "1";
		}
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

}

