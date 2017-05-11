package pha.com.code.system.model;


import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

import pha.com.common.base.model.BaseModel;

public class UserInfo extends BaseModel<UserInfo>{
    private String loginName;

    private String name;

    private String password;

    private String companyName;

    private String address;

    private String telphone;

    private String phone;

    @JSONField(format= "yyyy-MM-dd HH:mm:ss" )
    private Timestamp  createDate;
    
    @JSONField(format= "yyyy-MM-dd HH:mm:ss" )
    private Timestamp  updateDate;

    private Integer status;

    private String spare1;

    private String spare2;
    
    private String remeberme;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Timestamp  getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp  createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp  updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSpare1() {
        return spare1;
    }

    public void setSpare1(String spare1) {
        this.spare1 = spare1;
    }

    public String getSpare2() {
        return spare2;
    }

    public void setSpare2(String spare2) {
        this.spare2 = spare2;
    }

	public String getRemeberme() {
		return remeberme;
	}

	public void setRemeberme(String remeberme) {
		this.remeberme = remeberme;
	}
}