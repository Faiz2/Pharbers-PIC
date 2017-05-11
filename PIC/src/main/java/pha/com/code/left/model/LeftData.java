package pha.com.code.left.model;


import pha.com.common.base.model.BaseModel;
public class LeftData extends BaseModel<LeftData>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer lid;
	
	private String lname;
	
	private String remarks;
	
	private String parentCode;

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
}
