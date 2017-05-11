package pha.com.code.system.model;

import java.util.Date;

import pha.com.common.base.model.BaseModel;

public class RegisterInfo extends BaseModel<RegisterInfo>{
	
    private Integer registerid;

    private String username;

    private String name;

    private String mobile;

    private String password;

    private String company;

    private Integer registertype;
    
    private Date registerdate;
    
    private Date updatedate;

    public Integer getRegisterid() {
        return registerid;
    }

    public void setRegisterid(Integer registerid) {
        this.registerid = registerid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getRegistertype() {
        return registertype;
    }

    public void setRegistertype(Integer registertype) {
        this.registertype = registertype;
    }

	public Date getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}