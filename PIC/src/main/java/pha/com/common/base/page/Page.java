package pha.com.common.base.page;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;

import pha.com.common.base.model.FilterDescriptor;
import pha.com.common.base.util.HttpURLUtils;

public class Page<T> extends HashMap<String, Object> implements Serializable {
	private static final long serialVersionUID = -171461888820868674L;

	private Integer pageIndex = 1;// 页码，默认是第一页
	private Integer pageStart = 1;
	private Integer pageSize = 12;// 每页显示的记录数，默认设置10
	private Integer totalRecord = 0;// 总记录数
	private Integer totalPage = 0;// 总页数
	private Integer serialNum = 0;//得到序列号
	/**
	 * 分页查询后的结果集。
	 */
	private List<T> result;
	
	// private Map<String, Object> params = new HashMap<String, Object>();//
	// 其他的参数我们把它分装成一个Map对象
	
	private String requestBaseURL = null;

	private String[] requestBaseURLParams = null;
	
	public String getRequestBaseURL() {
		return requestBaseURL;
	}

	public void setRequestBaseURL(String equestBaseURL) {
		this.requestBaseURL = equestBaseURL;
	}
	

	public String[] getRequestBaseURLParams() {
		if (requestBaseURLParams == null) {
			requestBaseURLParams = new String[]{"pageIndex","pageSize"};
		}
		return requestBaseURLParams;
	}

	public void setRequestBaseURLParams(String[] requestBaseURLParams) {
		this.requestBaseURLParams = requestBaseURLParams;
	}
	
	HttpServletRequest request;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Page(HttpServletRequest request) {
		if (requestBaseURL == null) {
			requestBaseURL = HttpURLUtils.escapeParameterToURL(request,getRequestBaseURLParams() ,false);
			request.setAttribute("requestBaseURL", requestBaseURL);
		}
		this.request = request;
		Map<String, Object> parametermap =new HashMap<String, Object>();
		Map properties = request.getParameterMap();
		Iterator entries = properties.entrySet().iterator(); 
		Map.Entry entry; 
		String name = "";  
		String value = "";
		while (entries.hasNext()) {//地址栏提交的参数获取
			entry = (Map.Entry) entries.next();
			name = (String) entry.getKey(); 
			Object valueObj = entry.getValue(); 
			if(null == valueObj){ 
				value = ""; 
			}else if(valueObj instanceof String[]){ 
				String[] values = (String[])valueObj;
				for(int i=0;i<values.length;i++){ 
					 value = values[i];
				}
			}
			parametermap.put(name, value);
		}
		if(!entries.hasNext()){//Ajax的post提交的参数获取
			try {
				parametermap = (Map<String, Object>) JSON.parse(getRequestPayload(request));
			} catch (Exception e) {
				
			}
		}
		
		if(parametermap.get("pageIndex") != null){
			this.pageIndex = Integer.parseInt(parametermap.get("pageIndex").toString());
		}else if(parametermap.get("page") != null){
			this.pageIndex = Integer.parseInt(parametermap.get("page").toString());
		}
		if(parametermap.get("pageSize") != null){
			this.pageSize = Integer.parseInt(parametermap.get("pageSize").toString());
		}
	}
	
	private String getRequestPayload(HttpServletRequest req) {
        StringBuilder sb = new StringBuilder();  
        try(BufferedReader reader = req.getReader()) {  
                 char[]buff = new char[1024];  
                 int len;  
                 while((len = reader.read(buff)) != -1) {  
                          sb.append(buff,0, len);  
                 }  
        }catch (IOException e) {  
                 e.printStackTrace();  
        }  
        return sb.toString();  
}  
	
	public Page() {
	}
	
	/**
	 * 得到页码。
	 * 
	 * @return
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}

	/**
	 * 得到页码。
	 * 
	 * @return
	 */
	public Integer getPageIndex2() {
		Integer i = 1;
		Object obj = this.get("pageIndex");

		if (obj instanceof String[]) {
			String[] a = (String[]) obj;
			if (a.length > 0) {
				i = Integer.valueOf(a[0]);
			}
		} else if (obj instanceof String) {
			i = (Integer) obj;
		} else {
			i = getPageIndex() >= 0 ? getPageIndex() : i;
		}
		setPageIndex(i);

		return pageIndex;
	}

	/**
	 * <h3>设置页码。</h3>
	 * 
	 * <p>允许的值包括null和大于0的数字。</p>
	 * @return
	 */
	public void setPageIndex(Integer pageIndex) {
		if (pageIndex != null && pageIndex < 0) {
			return;
		}
		this.pageIndex = pageIndex;
		serialNum = (this.pageIndex-1)*this.pageSize;
		this.put("pageIndex", this.pageIndex);
		this.put("serialNum", this.serialNum);
	}
	
	public void setPI(Integer pageIndex) {
		this.setPageIndex(pageIndex);
	}

	/**
	 * 得到每页尺寸。
	 * 
	 * @return
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * 得到每页尺寸。
	 * 
	 * @return
	 */
	public Integer getPageSize2() {
		Integer i = 10;
		Object obj = this.get("pageSize");

		if (obj instanceof String[]) {
			String[] a = (String[]) obj;
			if (a.length > 0) {
				i = Integer.valueOf(a[0]);
			}
		} else if (obj instanceof String) {
			i = (Integer) obj;
		} else {
			i = getPageSize() > 0 ? getPageSize() : i;
		}

		setPageSize(i);
		
		return pageSize;
	}

	/**
	 * <h3>设置每页尺寸。</h3>
	 * 
	 * <p>允许的值包括null和大于0的数字。</p>
	 * @param pageSize 
	 */
	public void setPageSize(Integer pageSize) {
		if(pageSize != null && pageSize < 1){
			return;
		}
		this.pageSize = pageSize;
		this.put("pageSize",this.pageSize);
	}
	
	public void setPs(Integer pageSize) {
		this.setPageSize(pageSize);
	}

	/**
	 * 得到所有的符合条件的纪录数量。
	 * 
	 * @return
	 */
	public Integer getTotalRecord() {
		return totalRecord;
	}

	/**
	 * 设置所有的符合条件的纪录数量，同时会计算总页数。
	 * 
	 * @param totalRecord
	 */
	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
		// 在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
		int totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize
				: totalRecord / pageSize + 1;
		this.setTotalPage(totalPage);
		this.put("totalRecord", totalRecord);
		if(this.getPageIndex() > this.getTotalPage() && this.getTotalPage() > 0){
			this.setPageIndex(this.getTotalPage());
		}
	}

	/**
	 * 得到总页数。
	 * 
	 * @return
	 */
	public Integer getTotalPage() {
		return totalPage;
	}

	/**
	 * 设置总页数。
	 * 
	 * @param totalPage
	 */
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
		this.put("totalPage", totalPage);
	}

	/**
	 * 得到查询参数。
	 * 
	 * @return
	 */
	/*
	 * public Map<String, Object> getParams() { return params; }
	 */

	/**
	 * 设置查询参数。
	 * 
	 * @param params
	 */
	/*
	 * public void setParams(Map<String, Object> params) { this.params = params;
	 * }
	 */

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Page [pageNo=").append(pageIndex).append(", pageSize=")
				.append(pageSize).append(", serialNum=").append(serialNum).append(", results=").append(", totalPage=")
				.append(totalPage).append(", totalRecord=").append(totalRecord)
				.append(", otherParams=").append(super.toString()).append("]");
		return builder.toString();
	}

	/**
	 * 得到当前页第一条纪录的顺序号。
	 * 
	 * @return
	 */
	public Integer getPageStart() {
		return pageStart;
	}

	/**
	 * 设置当前页第一条纪录的顺序号。
	 * 
	 * @param pageStart
	 */
	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
		this.put("pageStart", pageStart);
	}

	/**
	 * 得到分页查询后的结果集。
	 * 
	 * @return List类型， 结果集
	 */
	public List<T> getResult() {
		return result;
	}

	/**
	 * 设置分页查询后的结果集。
	 * 
	 * @param result
	 *            List类型， 结果集
	 */
	public void setResult(List<T> result) {
		this.put("results", result);
		this.result = result;
	}

	public Integer getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(Integer serialNum) {
		this.serialNum = serialNum;
	} 
}
