package pha.com.code.queryKeyWord.model;

import pha.com.common.base.model.BaseModel;

public class MedicalForDataInfo extends BaseModel<MedicalForDataInfo>{

    private String databasename;

    private String manutypename;

    private String interatc1name;
    
    private String interatc2name;
    
    private String interatc3name;

    private String manunameCh;

    private String provincename;

    private String productnameCh;

    private String dosageformname;

    private String specificationsname;

    private String packagingname;

    private String genericnamenameCh;

    public String getDatabasename() {
        return databasename;
    }

    public void setDatabasename(String databasename) {
        this.databasename = databasename;
    }

    public String getManutypename() {
        return manutypename;
    }

    public void setManutypename(String manutypename) {
        this.manutypename = manutypename;
    }

    public String getInteratc1name() {
		return interatc1name;
	}

	public void setInteratc1name(String interatc1name) {
		this.interatc1name = interatc1name;
	}

	public String getInteratc2name() {
		return interatc2name;
	}

	public void setInteratc2name(String interatc2name) {
		this.interatc2name = interatc2name;
	}

	public String getInteratc3name() {
		return interatc3name;
	}

	public void setInteratc3name(String interatc3name) {
		this.interatc3name = interatc3name;
	}

	public String getManunameCh() {
        return manunameCh;
    }

    public void setManunameCh(String manunameCh) {
        this.manunameCh = manunameCh;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }

    public String getProductnameCh() {
        return productnameCh;
    }

    public void setProductnameCh(String productnameCh) {
        this.productnameCh = productnameCh;
    }

    public String getDosageformname() {
        return dosageformname;
    }

    public void setDosageformname(String dosageformname) {
        this.dosageformname = dosageformname;
    }

    public String getSpecificationsname() {
        return specificationsname;
    }

    public void setSpecificationsname(String specificationsname) {
        this.specificationsname = specificationsname;
    }

    public String getPackagingname() {
        return packagingname;
    }

    public void setPackagingname(String packagingname) {
        this.packagingname = packagingname;
    }

    public String getGenericnamenameCh() {
        return genericnamenameCh;
    }

    public void setGenericnamenameCh(String genericnamenameCh) {
        this.genericnamenameCh = genericnamenameCh;
    }
}