package pha.com.code.report.model;

import java.io.Serializable;

public class ScatterMedical implements Serializable{
	
	private Double zb;
	
	private String provinceName;
	
	private Double ffzzl;
	
	private String year;

	public Double getZb() {
		return zb;
	}

	public void setZb(Double zb) {
		this.zb = zb;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Double getFfzzl() {
		return ffzzl;
	}

	public void setFfzzl(Double ffzzl) {
		this.ffzzl = ffzzl;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
