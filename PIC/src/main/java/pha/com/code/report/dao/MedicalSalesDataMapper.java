package pha.com.code.report.dao;

import java.util.List;
import java.util.Map;

import pha.com.code.report.model.ListDataOne;
import pha.com.code.report.model.ManuType;
import pha.com.code.report.model.MedicalSalesData;
import pha.com.common.base.dao.BaseDao;

public interface MedicalSalesDataMapper extends BaseDao<MedicalSalesData>{
	
	/** 
	 * 返回输入年的月份个数
	 * @param map
	 * @return Integer
	 */
	public Integer selectByQueryIsMAT(Map<String, Object> map);
	
	/**
	 * 查询用户选择年份进行搜索的时候是否使用MAT的方式
	 * @param map
	 * @return
	 */
	public Integer selectByQueryYearIsNULL(Map<String, Object> map);
	
	/** 
	 * 返回用户设置的开始年份的向前推5年的List数据
	 * @param map
	 * @return list
	 */
	public List<MedicalSalesData> selectByYear5Counts(Map<String, Object> map);
	
	/**
	 * 查询年区间的增长率（年）
	 * @param map
	 * @return
	 */
	public List<MedicalSalesData> selectByReportLjxsZzlYear(Map<String, Object> map);
	
	/**
	 * 查询各个省份的市场占比（年）
	 * @param map
	 * @return
	 */
	public List<MedicalSalesData> selectByReportSczbYear(Map<String, Object> map);
	
	/**
	 * 查询各个省份的复合增长率（年）
	 * @param map
	 * @return
	 */
	public List<MedicalSalesData> selectByReportFhzzlYear(Map<String, Object> map);
	
	/**
	 * 查询生产企业的的类型销售额的占比
	 * @param map
	 * @return
	 */
	public List<ManuType> selectByReportXsbx(Map<String, Object> map);
	
	/**
	 * ATC与通用名的销售额占比 
	 * @param map
	 * @return
	 */
	public List<ManuType> selectByAtcXsZb(Map<String, Object> map);
	
	/**
	 * 市场最小产品销售额占比 
	 * @param map
	 * @return
	 */
	public List<ManuType> selectByMinniUnitXseZb(Map<String, Object> map);

	/******开始******/
	/**
	 * 根据商品名分组查询数据（然后在算占比）
	 * @param map
	 * @return
	 */
	public List<ManuType> selectByTop10Xsze(Map<String, Object> map);
	
	/**
	 * Top10查询销售额占比和增长率
	 * @param map
	 * @return
	 */
	public List<ManuType> selectByTop10XszeZb(Map<String, Object> map);
	
	/**
	 * 求出选择的类型的销售总量 
	 * @param map
	 * @return
	 */
	public List<ManuType> selectByTop10Xszl(Map<String, Object> map);
	/******结束******/
	
	/**
	 * 根据市场（ATC）和年份查出销售额占比
	 * @param map
	 * @return
	 */
	public List<ManuType> selectByTop10XseZb(Map<String, Object> map);
	
	/**
	 * 根据用户输入的年份返回年份列表 (升序)
	 * @param map
	 * @return
	 */
	public List<ListDataOne> selectByYearGroup(Map<String, Object> map);
	
	/**
	 * 根据条件查询出Top10厂家的数据（表1）
	 * @param map
	 * @return
	 */
	public List<ListDataOne> selectTop10ListDataOne(Map<String, Object> map);
}