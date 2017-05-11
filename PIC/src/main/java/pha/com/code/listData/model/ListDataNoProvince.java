package pha.com.code.listData.model;

import pha.com.common.base.model.BaseModel;
import pha.com.common.base.model.FilterDescriptor;
import pha.com.common.base.page.Page;
import pha.com.common.util.export.Excel;

public class ListDataNoProvince extends BaseModel<ListDataNoProvince>{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer salesid;
	
	@Excel(name="日期",width=30)
	private String salesDate;
	
	@Excel(name="通用名",width=30)
	private String genericnameName;
	
	@Excel(name="销售额（元）",width=30)
    private Long salesValue;

	@Excel(name="销量（盒）",width=30)
    private Long unit;
	
	@Excel(name="商品名",width=30)
	private String productName;
	
	@Excel(name="厂家",width=30)
	private String manuName;
	
	@Excel(name="规格",width=30)
	private String specificationsName;
	
	@Excel(name="治疗Ⅰ类",width=30)
    private String Atc1Name;
    
	@Excel(name="治疗Ⅱ类",width=30)
    private String Atc2Name;
    
	@Excel(name="治疗III类",width=30)
    private String Atc3Name;
    
	@Excel(name="最小产品单位",width=30)
    private String minimumName;
    
	@Excel(name="厂家类型",width=30)
    private String manuTypeName;
    
	@Excel(name="剂型",width=30)
    private String dosageformName;
    
	@Excel(name="包装",width=30)
    private String packagingName;
    
    private FilterDescriptor filter;
    
	public Integer getSalesid() {
		return salesid;
	}

	public void setSalesid(Integer salesid) {
		this.salesid = salesid;
	}

	public String getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(String salesDate) {
		this.salesDate = salesDate;
	}

	public String getGenericnameName() {
		return genericnameName;
	}

	public void setGenericnameName(String genericnameName) {
		this.genericnameName = genericnameName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Long getSalesValue() {
		return salesValue;
	}

	public void setSalesValue(Long salesValue) {
		this.salesValue = salesValue;
	}

	public Long getUnit() {
		return unit;
	}

	public void setUnit(Long unit) {
		this.unit = unit;
	}

	public String getManuName() {
		return manuName;
	}

	public void setManuName(String manuName) {
		this.manuName = manuName;
	}

	public String getSpecificationsName() {
		return specificationsName;
	}

	public void setSpecificationsName(String specificationsName) {
		this.specificationsName = specificationsName;
	}


	public String getAtc1Name() {
		return Atc1Name;
	}

	public void setAtc1Name(String atc1Name) {
		Atc1Name = atc1Name;
	}

	public String getAtc2Name() {
		return Atc2Name;
	}

	public void setAtc2Name(String atc2Name) {
		Atc2Name = atc2Name;
	}

	public String getAtc3Name() {
		return Atc3Name;
	}

	public void setAtc3Name(String atc3Name) {
		Atc3Name = atc3Name;
	}

	public String getMinimumName() {
		return minimumName;
	}

	public void setMinimumName(String minimumName) {
		this.minimumName = minimumName;
	}

	public String getManuTypeName() {
		return manuTypeName;
	}

	public void setManuTypeName(String manuTypeName) {
		this.manuTypeName = manuTypeName;
	}

	public String getDosageformName() {
		return dosageformName;
	}

	public void setDosageformName(String dosageformName) {
		this.dosageformName = dosageformName;
	}

	public String getPackagingName() {
		return packagingName;
	}

	public void setPackagingName(String packagingName) {
		this.packagingName = packagingName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public FilterDescriptor getFilter() {
		return filter;
	}

	public void setFilter(FilterDescriptor filter) {
		this.filter = filter;
	}
}