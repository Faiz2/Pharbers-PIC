package pha.com.code.left.dao;

import java.util.List;
import java.util.Map;

import pha.com.code.left.model.LeftData;
import pha.com.common.base.dao.BaseDao;

public interface LeftDataMapper extends BaseDao<LeftData>{
	/**
	 * 查询Left.jsp的ATC1下拉数据
	 * @return
	 */
	public List<LeftData> queryByATC1();
	
	/**
	 * 查询Left.jsp的ATC2下拉数据
	 * @return
	 */
	public List<LeftData> queryByATC2(Map<String, Object> map);
	
	/**
	 * 查询Left.jsp的ATC3下拉数据
	 * @return
	 */
	public List<LeftData> queryByATC3(Map<String, Object> map);
	
	/**
	 * 查询Left.jsp的通用名下拉数据
	 * @return
	 */
	public List<LeftData> queryByGenericName(Map<String, Object> map);
	
	/**
	 * 查询Left.jsp的省份下拉数据
	 * @return
	 */
	public List<LeftData> queryByProvince();
	
	/**
	 * 查询Left.jsp的产品下拉数据
	 * @return
	 */
	public List<LeftData> queryByProduct();
	
	/**
	 * 查询Left.jsp的生产厂商类型的下拉数据
	 * @return
	 */
	public List<LeftData> queryByManufactureType();
	
	/**
	 * 查询Left.jsp的生产厂商下拉数据
	 * @return
	 */
	public List<LeftData> queryByManufacture();
	
	/**
	 * 查询Left.jsp的剂型下拉数据
	 * @return
	 */
	public List<LeftData> queryByDosage();
	
	/**
	 * 查询Left.jsp的规格下拉数据
	 * @return
	 */
	public List<LeftData> queryBySpecification();
	
	/**
	 * 查询Left.jsp的包装下拉数据
	 * @return
	 */
	public List<LeftData> queryByPackage();
	
	/**
	 * 联动查询所有
	 * @param map
	 * @return
	 */
	public List<LeftData> queryByIDALL(Map<String, Object> map);
	
	/**
	 * 商品向上寻找一个上级
	 * @param map
	 * @return
	 */
	public List<LeftData> queryUpperloader(Map<String, Object> map);
}
