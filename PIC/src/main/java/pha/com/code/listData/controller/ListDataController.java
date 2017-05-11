package pha.com.code.listData.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ext.ParamConverter.Lazy;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pha.com.code.listData.model.ListData;
import pha.com.code.listData.model.ListDataNoProvince;
import pha.com.code.listData.service.ListDataService;
import pha.com.common.base.controller.BaseController;
import pha.com.common.base.page.Page;
import pha.com.common.util.FileUtil;
import pha.com.common.util.ReadProperties;
import pha.com.common.util.RunDate;
import pha.com.common.util.getClassPath;
import pha.com.common.util.export.BeanToExcel;

@Controller
@Lazy
@RequestMapping("/listData")
public class ListDataController extends BaseController<ListData> {
	@Resource
	private ListDataService listDataService;
	
	private Map<String, Object> excelParameterMap = new HashMap<String, Object>();
	
	/**
	 * Set查询条件
	 * @param entity
	 */
	private void setPageParameter(ListData entity){
		this.page = getPage();
		if(entity.getFilter() != null){
			for (int i = 0; i < entity.getFilter().getFilters().size(); i++) {
				switch (entity.getFilter().getFilters().get(i).getField()) {
					case "atc1Name":
						this.page.put("interatc1id", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						
						excelParameterMap.put("interatc1id", entity.getFilter().getFilters().get(i).getValue());
						excelParameterMap.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
					case "atc2Name":
						this.page.put("interatc2id", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						
						excelParameterMap.put("interatc2id", entity.getFilter().getFilters().get(i).getValue());
						excelParameterMap.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
					case "atc3Name":
						this.page.put("interatc3id", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						
						excelParameterMap.put("interatc3id", entity.getFilter().getFilters().get(i).getValue());
						excelParameterMap.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
					case "dosageformName":
						this.page.put("dosageformid", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						
						excelParameterMap.put("dosageformid", entity.getFilter().getFilters().get(i).getValue());
						excelParameterMap.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
					case "genericnameName":
						this.page.put("genericnameid", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						
						excelParameterMap.put("genericnameid", entity.getFilter().getFilters().get(i).getValue());
						excelParameterMap.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
					case "manuName":
						this.page.put("manuid", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						
						excelParameterMap.put("manuid", entity.getFilter().getFilters().get(i).getValue());
						excelParameterMap.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
					case "manuTypeName":
						this.page.put("manutypeid", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						
						excelParameterMap.put("manutypeid", entity.getFilter().getFilters().get(i).getValue());
						excelParameterMap.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
					case "minimumName":
						this.page.put("minimum_unit_id", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						
						excelParameterMap.put("minimum_unit_id", entity.getFilter().getFilters().get(i).getValue());
						excelParameterMap.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
					case "packagingName":
						this.page.put("packagingid", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						
						excelParameterMap.put("packagingid", entity.getFilter().getFilters().get(i).getValue());
						excelParameterMap.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
					case "productName":
						this.page.put("productnameid", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						
						excelParameterMap.put("productnameid", entity.getFilter().getFilters().get(i).getValue());
						excelParameterMap.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
					case "provinceName":
						this.page.put("provinceid", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						
						excelParameterMap.put("provinceid", entity.getFilter().getFilters().get(i).getValue());
						excelParameterMap.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
					case "salesDate":
						this.page.put("salesDate", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						
						excelParameterMap.put("salesDate", entity.getFilter().getFilters().get(i).getValue());
						excelParameterMap.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
					case "salesValue":
						this.page.put("salesValue", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						
						excelParameterMap.put("salesValue", entity.getFilter().getFilters().get(i).getValue());
						excelParameterMap.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
					case "unit":
						this.page.put("unit", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						
						excelParameterMap.put("unit", entity.getFilter().getFilters().get(i).getValue());
						excelParameterMap.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
					case "specificationsName":
						this.page.put("specificationsid", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						
						excelParameterMap.put("specificationsid", entity.getFilter().getFilters().get(i).getValue());
						excelParameterMap.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
					case "year":
						this.page.put("time", entity.getFilter().getFilters().get(i).getValue());
						this.page.put("timeType", "year");
						this.page.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						
						excelParameterMap.put("time", entity.getFilter().getFilters().get(i).getValue());
						excelParameterMap.put("timeType", "year");
						excelParameterMap.put("operator", entity.getFilter().getFilters().get(i).getOperator());
						break;
				}
			}
		}
	}
	
	
	@RequestMapping(value = "query",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
//	@RequestStreamController
//	@SystemControllerLog(description="query")
	public Page<ListData> query(@RequestBody ListData entity){
		setPageParameter(entity);
		this.page = listDataService.queryByPage(this.page);
		return this.page;
	}
	
	/**
	 * Excel文件指定路径
	 * @return
	 * @RequestMapping(value = "download",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	 * @RequestMapping("download")
	 */
	@RequestMapping(value = "checkData",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String checkData(@RequestBody ListData entity){
		File file = null;
		List<ListDataNoProvince> dataNoProvinces = null;
		try {
			long begin = RunDate.startDate();
			setPageParameter(entity);
			if(excelParameterMap.containsKey("provinceid") && Integer.parseInt(excelParameterMap.get("provinceid").toString()) == 32){
				dataNoProvinces = listDataService.selectByNoProvince(excelParameterMap);
			}else{
				this.list = listDataService.queryByParameters(excelParameterMap);
			}
			RunDate.endDate("查询时间", begin);
			long begin2 = RunDate.startDate();
			file=new File(ReadProperties.read(new StringBuffer().append(getClassPath.getPath()).append("/file.properties").toString()).getProperty("ExcelSource"));
			if(excelParameterMap.containsKey("provinceid") && Integer.parseInt(excelParameterMap.get("provinceid").toString()) == 32){
				BeanToExcel.writeToFile(dataNoProvinces, null, file.getPath()+"\\报告.xlsx");
			}else{
				BeanToExcel.writeToFile(this.list, null, file.getPath()+"\\报告.xlsx");
			}
			RunDate.endDate("生成文件时间", begin2);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return "报告.xlsx";
	}
	
	@RequestMapping("download")//ResponseEntity<byte[]> ModelAndView
	public ResponseEntity<byte[]> download(HttpServletRequest request,HttpServletResponse response,String name){
		StringBuffer path = new StringBuffer(ReadProperties.read(new StringBuffer().append(getClassPath.getPath()).append("/file.properties").toString()).getProperty("ExcelSource"));
		File file=new File(path.append("\\").append(name).toString());
		try {
			//FileUtil.download(request, response, file.getPath(), "测试.xlsx");
			return FileUtil.download(file.getPath(),name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null; 
	}
}
