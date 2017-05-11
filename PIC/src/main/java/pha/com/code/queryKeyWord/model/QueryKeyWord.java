package pha.com.code.queryKeyWord.model;


import pha.com.common.base.model.BaseModel;
public class QueryKeyWord extends BaseModel<QueryKeyWord>{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String databasename;

	public String getDatabasename() {
		return databasename;
	}

	public void setDatabasename(String databasename) {
		this.databasename = databasename;
	}
}