package pha.com.code.log.error.model;

import java.util.Date;

public class ErrorLog {
    private Integer logid;

    private Date errortime;

    private String objname;

    private String methodname;

    private String customerror;

    private String username;

    private String ip;

    private String spare1;

    private String spare2;

    public Integer getLogid() {
        return logid;
    }

    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    public Date getErrortime() {
        return errortime;
    }

    public void setErrortime(Date errortime) {
        this.errortime = errortime;
    }

    public String getObjname() {
        return objname;
    }

    public void setObjname(String objname) {
        this.objname = objname;
    }

    public String getMethodname() {
        return methodname;
    }

    public void setMethodname(String methodname) {
        this.methodname = methodname;
    }

    public String getCustomerror() {
        return customerror;
    }

    public void setCustomerror(String customerror) {
        this.customerror = customerror;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
}