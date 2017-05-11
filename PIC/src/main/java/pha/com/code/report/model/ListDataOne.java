package pha.com.code.report.model;

import pha.com.common.base.model.BaseModel;

public class ListDataOne extends BaseModel<ListDataOne>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int year;

	////////////////////////////////表一//////////////////////////////////////////
	/**
	 * 最后的一年（最接近当前年份如 2011-2015  这个就是2015）
	 */
	private int lastyear;
	
	/**
	 * 排名前十的制药公司
	 */
	private String manunameCh;
	
	/**
	 * 制药公司类型
	 */
	private String manuType;
	
	/**
	 * 最新（最后的一年）一年份的产品数量
	 */
	private int minimumCount;
	
	/**
	 * 最后的一年的市场份额占比
	 */
	private Double lastscfezb;
	
	/**
	 * 销售额增长率
	 */
	private Double xsezzl;
	
	/**
	 * 第一年
	 */
	private int fristyear;
	
	/**
	 * 第一年的市场份额占比
	 */
	private Double fristscfezb;
	
	/*
	 * 中间一年
	 */
	private int middleyear;
	
	/**
	 * 中间一年的市场份额占比
	 */
	private Double middlescfezb;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getLastyear() {
		return lastyear;
	}

	public void setLastyear(int lastyear) {
		this.lastyear = lastyear;
	}

	public String getManunameCh() {
		return manunameCh;
	}

	public void setManunameCh(String manunameCh) {
		this.manunameCh = manunameCh;
	}

	public String getManuType() {
		return manuType;
	}

	public void setManuType(String manuType) {
		this.manuType = manuType;
	}

	public int getMinimumCount() {
		return minimumCount;
	}

	public void setMinimumCount(int minimumCount) {
		this.minimumCount = minimumCount;
	}

	public Double getLastscfezb() {
		return lastscfezb;
	}

	public void setLastscfezb(Double lastscfezb) {
		this.lastscfezb = lastscfezb;
	}

	public Double getXsezzl() {
		return xsezzl;
	}

	public void setXsezzl(Double xsezzl) {
		this.xsezzl = xsezzl;
	}

	public int getFristyear() {
		return fristyear;
	}

	public void setFristyear(int fristyear) {
		this.fristyear = fristyear;
	}

	public Double getFristscfezb() {
		return fristscfezb;
	}

	public void setFristscfezb(Double fristscfezb) {
		this.fristscfezb = fristscfezb;
	}

	public int getMiddleyear() {
		return middleyear;
	}

	public void setMiddleyear(int middleyear) {
		this.middleyear = middleyear;
	}

	public Double getMiddlescfezb() {
		return middlescfezb;
	}

	public void setMiddlescfezb(Double middlescfezb) {
		this.middlescfezb = middlescfezb;
	}
	
}
