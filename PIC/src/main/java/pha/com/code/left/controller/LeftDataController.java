package pha.com.code.left.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.ext.ParamConverter.Lazy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pha.com.code.left.model.LeftData;
import pha.com.code.left.service.LeftDataService;
import pha.com.common.base.controller.BaseController;

@Controller
@Lazy
@RequestMapping("/leftData")
public class LeftDataController extends BaseController<LeftData> {
	
	@Resource
	private LeftDataService leftDataService;
	
	/**
	 * 查询Left.jsp的ATC1
	 * @return list
	 */
	@RequestMapping(value="queryByATC1",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<LeftData> queryByATC1(){
		return leftDataService.queryByATC1();
	}
	
	/**
	 * @param code 父级的编码
	 * 查询Left.jsp的ATC2
	 * @return list
	 */
	@RequestMapping(value="queryByATC2",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<LeftData> queryByATC2(String code){
		Map<String, Object> map = new HashMap<String, Object>();
		if(code != null && !"".equals(code)){
			map.put("code", code);
		}
		return leftDataService.queryByATC2(map);
	}
	
	/**
	 * 查询Left.jsp的ATC3
	 * @return list
	 */
	@RequestMapping(value="queryByATC3",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<LeftData> queryByATC3(String code){
		Map<String, Object> map = new HashMap<String, Object>();
		if(code != null && !"".equals(code)){
			map.put("code", code);
		}
		return leftDataService.queryByATC3(map);
	}
	
	/**
	 * 查询Left.jsp的通用名
	 * @return list
	 */
	@RequestMapping(value="queryBygenericName",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<LeftData> queryBygenericName(String code){
		Map<String, Object> map = new HashMap<String, Object>();
		if(code != null && !"".equals(code)){
			map.put("code", code);
		}
		return leftDataService.queryByGenericName(map);
	}
	
	/**
	 * 查询Left.jsp的Province
	 * @return list
	 */
	@RequestMapping(value="queryByProvince",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<LeftData> queryByProvince() {
		return leftDataService.queryByProvince();
	}

	/**
	 * 查询Left.jsp的Product
	 * @return list
	 */
	@RequestMapping(value="queryByProduct",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<LeftData> queryByProduct() {
		return leftDataService.queryByProduct();
	}
	
	/**
	 * 查询Left.jsp的ManufactureType
	 * @return list
	 */
	@RequestMapping(value="queryByManufactureType",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<LeftData> queryByManufactureTypes() {
		return leftDataService.queryByManufactureType();
	}

	/**
	 * 查询Left.jsp的Manufacture
	 * @return list
	 */
	@RequestMapping(value="queryByManufacture",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<LeftData> queryByManufacture() {
		return leftDataService.queryByManufacture();
	}

	/**
	 * 查询Left.jsp的Dosage
	 * @return list
	 */
	@RequestMapping(value="queryByDosage",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<LeftData> queryByDosage() {
		return leftDataService.queryByDosage();
	}

	/**
	 * 查询Left.jsp的Specification
	 * @return list
	 */
	@RequestMapping(value="queryBySpecification",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<LeftData> queryBySpecification() {
		return leftDataService.queryBySpecification();
	}

	/**
	 * 查询Left.jsp的Package
	 * @return list
	 */
	@RequestMapping(value="queryByPackage",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<LeftData> queryByPackage() {
		return leftDataService.queryByPackage();
	}
	
	/**
	 * 联动查询所有
	 * leftType 确定左边是哪个选择下拉传过来的数据
	 * leftValue 下拉的值
	 * @return list
	 */
	@RequestMapping(value="queryByIDALL",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<LeftData> queryByIDALL(int leftType,int leftValue,int temp){
		Map<String, Object> map = new HashMap<String, Object>();
		if(leftType != 0){
			map.put("leftType", leftType);
		}
		if(leftValue != 0){
			map.put("leftValue", leftValue);
		}
		if(temp != 0){
			map.put("temp", temp);
		}
		return leftDataService.queryByIDALL(map);
	}
	
	/**
	 * 商品向上寻找一个上级
	 * @param map
	 * @return
	 */
	@RequestMapping(value="queryUpperloader",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<LeftData> queryUpperloader(Integer id){
		Map<String, Object> map = new HashMap<String, Object>();
		if(id != 0){
			map.put("productid", id);
		}
		return leftDataService.queryUpperloader(map);
	};
}
