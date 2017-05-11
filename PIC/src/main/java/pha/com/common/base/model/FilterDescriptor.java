package pha.com.common.base.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FilterDescriptor implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String logic;  
     private List<FilterDescriptor> filters = new ArrayList<FilterDescriptor>();  
     private String field;  
     private Object value;  
     private String operator;  
     private boolean ignoreCase = true;
     
	public String getLogic() {
		return logic;
	}

	public void setLogic(String logic) {
		this.logic = logic;
	}

	public List<FilterDescriptor> getFilters() {
		return filters;
	}

	public void setFilters(List<FilterDescriptor> filters) {
		this.filters = filters;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public boolean isIgnoreCase() {
		return ignoreCase;
	}

	public void setIgnoreCase(boolean ignoreCase) {
		this.ignoreCase = ignoreCase;
	}  
}
