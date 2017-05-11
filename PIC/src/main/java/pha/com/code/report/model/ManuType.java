package pha.com.code.report.model;

import java.io.Serializable;

public class ManuType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String hezi;
	
	private String neizi;
	
	private String hzwzxse;//合资+外资销售额
	
	private String nzxse;//内资销售额
	
	private String xsezb;//销售额占比
	
	private String xse;//销售额
	
	private String time;//时间（可以是年  （MAT） 月  季度）
	
	private String manuName;//生产厂家名称
	
	private String manuTypeName;//生产厂家的类型
	
	private String name;//备用字段 名称

	public String getHezi() {
		return hezi;
	}

	public void setHezi(String hezi) {
		this.hezi = hezi;
	}

	public String getNeizi() {
		return neizi;
	}

	public void setNeizi(String neizi) {
		this.neizi = neizi;
	}

	public String getHzwzxse() {
		return hzwzxse;
	}

	public void setHzwzxse(String hzwzxse) {
		this.hzwzxse = hzwzxse;
	}

	public String getNzxse() {
		return nzxse;
	}

	public void setNzxse(String nzxse) {
		this.nzxse = nzxse;
	}

	public String getXsezb() {
		return xsezb;
	}

	public void setXsezb(String xsezb) {
		this.xsezb = xsezb;
	}

	public String getXse() {
		return xse;
	}

	public void setXse(String xse) {
		this.xse = xse;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getManuName() {
		return manuName;
	}

	public void setManuName(String manuName) {
		this.manuName = manuName;
	}

	public String getManuTypeName() {
		return manuTypeName;
	}

	public void setManuTypeName(String manuTypeName) {
		this.manuTypeName = manuTypeName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
