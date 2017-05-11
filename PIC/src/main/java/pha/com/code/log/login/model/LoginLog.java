package pha.com.code.log.login.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

import pha.com.common.base.model.BaseModel;
import pha.com.common.base.model.FilterDescriptor;

public class LoginLog extends BaseModel<LoginLog>{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer logid;

    private String loginname;
    
    @JSONField(format= "yyyy-MM-dd HH:mm:ss" )
    private Date loginstart;
    
    @JSONField(format= "yyyy-MM-dd HH:mm:ss" )
    private Date loginend;
    
    /**
     * 时间总和
     */
    private String timesum;

    private String logintype;

    private String ip;

    private String descinfo;
    
    private FilterDescriptor filter;

    public Integer getLogid() {
        return logid;
    }

    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public Date getLoginstart() {
		return loginstart;
	}

	public void setLoginstart(Date loginstart) {
		this.loginstart = loginstart;
	}
	
	public String getTimesum() {
		return timesum;
	}

	public void setTimesum(String timesum) {
		this.timesum = timesum;
	}

	public Date getLoginend() {
		return loginend;
	}

	public void setLoginend(Date loginend) {
		this.loginend = loginend;
	}

	public String getLogintype() {
        return logintype;
    }

    public void setLogintype(String logintype) {
        this.logintype = logintype;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDescinfo() {
        return descinfo;
    }

    public void setDescinfo(String descinfo) {
        this.descinfo = descinfo;
    }

	public FilterDescriptor getFilter() {
		return filter;
	}

	public void setFilter(FilterDescriptor filter) {
		this.filter = filter;
	}
}