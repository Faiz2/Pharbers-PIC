package pha.com.code.topFour.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.ext.ParamConverter.Lazy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pha.com.code.report.service.MedicalSalesDataService;
import pha.com.code.topFour.model.TopFour;
import pha.com.code.topFour.service.TopFourService;
import pha.com.common.base.controller.BaseController;
import pha.com.common.util.DateUtil;
import pha.com.common.util.FinalUtil;

@Controller
@Lazy
@RequestMapping("/topFourData")
public class TopFourController extends BaseController<TopFour> {
	@Resource
	private TopFourService topFourService;
	
	@Resource
	private MedicalSalesDataService medicalSalesDataService;
	
	private Map<String, Object> mapIsPut(TopFour entity){
		Map<String, Object> map = new HashMap<String, Object>();
		if(entity.getAtcType() != null && !entity.getAtcType().equals("")){
			map.put("atcType", entity.getAtcType());
		}
		if(entity.getSalesYear() != null && !entity.getSalesYear().equals("")){
			map.put("year", entity.getSalesYear());
			/*map.put("timeEnd", entity.getSalesYear());
			map.put("timeBegin", Integer.parseInt(entity.getSalesYear())-1);*/
		}
		if(entity.getGenericnameid() != null && !entity.getGenericnameid().equals("")){
			map.put("genericnameid", entity.getGenericnameid());
		}
		if(entity.getCodeid() != null && !entity.getCodeid().equals("")){
			map.put("codeid", entity.getCodeid());
		}
		if(entity.getParentcode() != null && !entity.getParentcode().equals("")){
			map.put("code", entity.getParentcode());
		}
		if(entity.getProviceid() != null && !entity.getProviceid().equals("")){
			map.put("provinceid", entity.getProviceid());
		}
		if(entity.getProductnameid() != null && !entity.getProductnameid().equals("")){
			map.put("productnameid", entity.getProductnameid());
			map.put("productType", 5);
		}
		if(entity.getManutypeid() != null && !entity.getManutypeid().equals("")){
			map.put("manutypeid", entity.getManutypeid());
		}
		if(entity.getManuid() != null && !entity.getManuid().equals("")){
			map.put("manuid", entity.getManuid());
		}
		if(entity.getDosageformid() != null && !entity.getDosageformid().equals("")){
			map.put("dosageformid", entity.getDosageformid());
		}
		if(entity.getSpecificationsid() != null && !entity.getSpecificationsid().equals("")){
			map.put("specificationsid", entity.getSpecificationsid());
		}
		if(entity.getPackagingid() != null && !entity.getPackagingid().equals("")){
			map.put("packagingid", entity.getPackagingid());
		}
		return map;
	}
	
	/**
	 * 根据用户选择的年份查询是否是 用MAT的方式计算（只是适用于年份）
	 * @param key
	 * @return false 否 ，true 是 
	 */
	public String isQueryMAT(TopFour entity){
		Map<String, Object> map = mapIsPut(entity);
		Integer count = 0;
		if(map.size() > 0){
			count = medicalSalesDataService.queryByQueryIsMAT(map);
		}
		//根据返回的count数来确定是否有需要进行下一步查询
		if(count == 0){
			return FinalUtil.DATA_ISNULL;//无数据
		}else if(count < 12){
			return FinalUtil.DATA_ISPART;//部分数据 不全
		}
		return FinalUtil.DATA_ISFULL; //完整的数据
	}
	
	/**
	 * 查询输入的年份是否位无效年（也就是NULL）
	 * @param entity
	 * @return
	 */
	public String isYearNull(TopFour entity){
		Map<String, Object> map = new HashMap<String, Object>();
		if(entity.getSalesYear() != null && !entity.getSalesYear().equals("")){
			map.put("year", Integer.parseInt(entity.getSalesYear())-1);
		}
		Integer count = 0;
		if(map.size() > 0){
			count = medicalSalesDataService.queryByQueryIsMAT(map);
		}
		//根据返回的count数来确定是否有需要进行下一步查询
		if(count == 0){
			return FinalUtil.DATA_ISNULL;//无数据
		}else if(count < 12){
			return FinalUtil.DATA_ISPART;//部分数据 不全
		}
		return FinalUtil.DATA_ISFULL; //完整的数据
	}
	
	/**
	 * 查询顶部的四个 小结的数据
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "query",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<TopFour> query(TopFour entity){
		
		if(entity.getSalesYear() == null || "".equals(entity.getSalesYear())){//没有输入年份回去系统时间Set到model里面
			entity.setSalesYear(DateUtil.format(new Date(), DateUtil.PATTERN_YEAR));
		}
		
		List<TopFour> list = null;
		
		if(FinalUtil.DATA_ISFULL.equals(isQueryMAT(entity))){
			Map<String, Object> map = mapIsPut(entity);
			map.put("timeEnd0", entity.getSalesYear());//完整月份的年（12月）
			map.put("timeBegin0", entity.getSalesYear());
			if(FinalUtil.DATA_ISFULL.equals(isYearNull(entity))||FinalUtil.DATA_ISPART.equals(isYearNull(entity))){
				map.put("timeEnd1", Integer.parseInt(entity.getSalesYear())-1);
				map.put("timeBegin1", Integer.parseInt(entity.getSalesYear())-1);
			}else{
				map.put("timeEnd1", Integer.parseInt(entity.getSalesYear()));
				map.put("timeBegin1", Integer.parseInt(entity.getSalesYear()));
			}
			list = topFourService.queryByParameters(map);
		}else if(FinalUtil.DATA_ISPART.equals(isQueryMAT(entity))){//有部分的月份数据需要MAT
			
		}
		
		return list;
	}
}
