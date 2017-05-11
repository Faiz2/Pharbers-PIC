package pha.com.code.report.model;



import pha.com.common.base.model.BaseModel;
public class MedicalSalesData extends BaseModel<MedicalSalesData> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer salesid;

    private Long salesValue;

    private Integer unit;

    private String descinfo;

    private Integer manutypeid;

    private Integer interatc1id;

    private Integer interatc2id;
    
    private Integer interatc3id;

    private Integer manuid;

    private Integer genericnameid;

    private Integer productnameid;

    private Integer dosageformid;

    private Integer specificationsid;

    private Integer packagingid;

    private Integer cwmedicineid;

    private Integer proviceid;

    private Integer minimumunitid;

    private String salesDate;

    private String salesYear;

    private String salesMonth;

    private String datarole;

    private Integer databaseid;
    
    /**
     * 判断是否是按照年筛选（1表示年）如果是年的话就需要查询MAT模式
     */
    private Integer typeTime;
    
    /**
     * 程序动态写语句需要确定返回的年的个数
     */
    private Integer yearCounts;
    
    
    /**
     * 接收计算的总和(用于计算)
     */
    private Long value;
    
    /**
     * 计算占比时所需要的省份名称
     */
    private String provincename;
    
    /**
     * 计算占比时所需要的接收值
     */
    private Double zb;
    
    /**
     * 接收父级编号
     */
    private String parentcode;
    
    /**
     * 选择ATC的类型
     */
    private String atcType;
    
    /**
     * 专门接收ATC的类型ID（用于查询市场）
     */
    private String codeid;
    
    public Integer getSalesid() {
        return salesid;
    }

    public void setSalesid(Integer salesid) {
        this.salesid = salesid;
    }

    public Long getSalesValue() {
        return salesValue;
    }

    public void setSalesValue(Long salesValue) {
        this.salesValue = salesValue;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public String getDescinfo() {
        return descinfo;
    }

    public void setDescinfo(String descinfo) {
        this.descinfo = descinfo;
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

    public Integer getCwmedicineid() {
        return cwmedicineid;
    }

    public void setCwmedicineid(Integer cwmedicineid) {
        this.cwmedicineid = cwmedicineid;
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

    public String getDatarole() {
        return datarole;
    }

    public void setDatarole(String datarole) {
        this.datarole = datarole;
    }

    public Integer getDatabaseid() {
        return databaseid;
    }

    public void setDatabaseid(Integer databaseid) {
        this.databaseid = databaseid;
    }

	public Integer getYearCounts() {
		return yearCounts;
	}

	public void setYearCounts(Integer yearCounts) {
		this.yearCounts = yearCounts;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public String getProvincename() {
		return provincename;
	}

	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}

	public Double getZb() {
		return zb;
	}

	public void setZb(Double zb) {
		this.zb = zb;
	}

	public Integer getTypeTime() {
		return typeTime;
	}

	public void setTypeTime(Integer typeTime) {
		this.typeTime = typeTime;
	}

	public String getParentcode() {
		return parentcode;
	}

	public void setParentcode(String parentcode) {
		this.parentcode = parentcode;
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
}