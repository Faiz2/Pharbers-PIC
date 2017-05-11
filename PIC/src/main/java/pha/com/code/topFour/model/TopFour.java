package pha.com.code.topFour.model;

import pha.com.common.base.model.BaseModel;

public class TopFour extends BaseModel<TopFour>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 规模
	 */
	private Long guim;
	
	/**
	 * 增长率
	 */
	private Double zengzl;
	
	/**
	 * 份额
	 */
	private Double fene;
	
	/**
	 * 产品数量
	 */
	private Long chanps;

	/**
	 * 生产厂家类型
	 */
    private Integer manutypeid;

    /**
     * ATC1
     */
    private Integer interatc1id;
    
    /**
     * ATC2
     */
    private Integer interatc2id;
    
    /**
     * ATC3
     */
    private Integer interatc3id;
    
    /**
     * 生产厂家
     */
    private Integer manuid;
    
    /**
     * 通用名
     */
    private Integer genericnameid;

    /**
     * 产品名称
     */
    private Integer productnameid;

    /**
     * 剂型
     */
    private Integer dosageformid;

    /**
     * 规格
     */
    private Integer specificationsid;

    /**
     * 包装
     */
    private Integer packagingid;

    /**
     * 省份
     */
    private Integer proviceid;

    /**
     * 最小产品单位
     */
    private Integer minimumunitid;

    /**
     * 时间
     */
    private String salesDate;

    /**
     * 年
     */
    private String salesYear;

    /**
     * 月
     */
    private String salesMonth;

    /**
     * 选择ATC的类型
     */
    private String atcType;
    
    /**
     * 专门接收ATC的类型ID（用于查询市场）
     */
    private String codeid;
    
    /**
     * 接收父级编号
     */
    private String parentcode;

	public Long getGuim() {
		return guim;
	}

	public void setGuim(Long guim) {
		this.guim = guim;
	}

	public Double getZengzl() {
		return zengzl;
	}

	public void setZengzl(Double zengzl) {
		this.zengzl = zengzl;
	}

	public Double getFene() {
		return fene;
	}

	public void setFene(Double fene) {
		this.fene = fene;
	}

	public Integer getManutypeid() {
		return manutypeid;
	}

	public void setManutypeid(Integer manutypeid) {
		this.manutypeid = manutypeid;
	}

	public Integer getInteratc1id() {
		return interatc1id;
	}

	public void setInteratc1id(Integer interatc1id) {
		this.interatc1id = interatc1id;
	}

	public Integer getInteratc2id() {
		return interatc2id;
	}

	public void setInteratc2id(Integer interatc2id) {
		this.interatc2id = interatc2id;
	}

	public Integer getInteratc3id() {
		return interatc3id;
	}

	public void setInteratc3id(Integer interatc3id) {
		this.interatc3id = interatc3id;
	}

	public Integer getManuid() {
		return manuid;
	}

	public void setManuid(Integer manuid) {
		this.manuid = manuid;
	}

	public Integer getGenericnameid() {
		return genericnameid;
	}

	public void setGenericnameid(Integer genericnameid) {
		this.genericnameid = genericnameid;
	}

	public Integer getProductnameid() {
		return productnameid;
	}

	public void setProductnameid(Integer productnameid) {
		this.productnameid = productnameid;
	}

	public Integer getDosageformid() {
		return dosageformid;
	}

	public void setDosageformid(Integer dosageformid) {
		this.dosageformid = dosageformid;
	}

	public Integer getSpecificationsid() {
		return specificationsid;
	}

	public void setSpecificationsid(Integer specificationsid) {
		this.specificationsid = specificationsid;
	}

	public Integer getPackagingid() {
		return packagingid;
	}

	public void setPackagingid(Integer packagingid) {
		this.packagingid = packagingid;
	}

	public Integer getProviceid() {
		return proviceid;
	}

	public void setProviceid(Integer proviceid) {
		this.proviceid = proviceid;
	}

	public Integer getMinimumunitid() {
		return minimumunitid;
	}

	public void setMinimumunitid(Integer minimumunitid) {
		this.minimumunitid = minimumunitid;
	}

	public String getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(String salesDate) {
		this.salesDate = salesDate;
	}

	public String getSalesYear() {
		return salesYear;
	}

	public void setSalesYear(String salesYear) {
		this.salesYear = salesYear;
	}

	public String getSalesMonth() {
		return salesMonth;
	}

	public void setSalesMonth(String salesMonth) {
		this.salesMonth = salesMonth;
	}

	public String getAtcType() {
		return atcType;
	}

	public void setAtcType(String atcType) {
		this.atcType = atcType;
	}

	public String getCodeid() {
		return codeid;
	}

	public void setCodeid(String codeid) {
		this.codeid = codeid;
	}

	public String getParentcode() {
		return parentcode;
	}

	public void setParentcode(String parentcode) {
		this.parentcode = parentcode;
	}

	public Long getChanps() {
		return chanps;
	}

	public void setChanps(Long chanps) {
		this.chanps = chanps;
	}
}
