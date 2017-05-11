package pha.com.code.report.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.ext.ParamConverter.Lazy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pha.com.code.report.model.MedicalSalesData;
import pha.com.code.report.model.ListDataOne;
import pha.com.code.report.model.ManuType;
import pha.com.code.report.model.ScatterMedical;
import pha.com.code.report.service.MedicalSalesDataService;
import pha.com.common.base.controller.BaseController;
import pha.com.common.util.FinalUtil;
import pha.com.common.util.ListUtil;
import pha.com.common.util.RunDate;

@Controller
@Lazy
@RequestMapping("/reportMedical")
public class MedicalSalesDataController extends BaseController<MedicalSalesData> {
	
	@Resource
	private MedicalSalesDataService medicalSalesDataService;
	
	private DecimalFormat df = new DecimalFormat("######0.00");

	
	private Map<String, Object> mapIsPut(MedicalSalesData entity){
		Map<String, Object> map = new HashMap<String, Object>();
		if(entity.getAtcType() != null && !entity.getAtcType().equals("")){
			map.put("atcType", entity.getAtcType());
		}
		if(entity.getSalesYear() != null && !entity.getSalesYear().equals("")){
			map.put("year", entity.getSalesYear());
			map.put("timeEnd", entity.getSalesYear());
			map.put("timeBegin", Integer.parseInt(entity.getSalesYear())-4);
		}
		if(entity.getInteratc1id() != null && !entity.getInteratc1id().equals("")){
			map.put("interatc1id", entity.getInteratc1id());
		}
		if(entity.getInteratc2id() != null && !entity.getInteratc2id().equals("")){
			map.put("interatc2id", entity.getInteratc2id());
		}
		if(entity.getInteratc3id() != null && !entity.getInteratc3id().equals("")){
			map.put("interatc3id", entity.getInteratc3id());
		}
		if(entity.getGenericnameid() != null && !entity.getGenericnameid().equals("")){
			map.put("genericnameid", entity.getGenericnameid());
		}
		if(entity.getParentcode() != null && !entity.getParentcode().equals("") && !entity.getParentcode().equals("undefined")){
			map.put("code", entity.getParentcode());
		}
		if(entity.getCodeid() != null && !entity.getCodeid().equals("")){
			map.put("codeid", entity.getCodeid());
		}
		if(entity.getProviceid() != null && !entity.getProviceid().equals("")){
			map.put("provinceid", entity.getProviceid());
		}
		if(entity.getProductnameid() != null && !entity.getProductnameid().equals("")){
			map.put("productnameid", entity.getProductnameid());
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
	public String isQueryMAT(MedicalSalesData entity){
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
	 * 按照年份查询报告
	 * @return
	 */
	@RequestMapping(value="queryByReportLjxsZzlByYear",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String queryByReportLjxsZzlByYear( MedicalSalesData entity){
		long start = RunDate.startDate();
		Map<String, Object> map = mapIsPut(entity);
		
		String flag = isQueryMAT(entity);
		if(flag.equals(FinalUtil.DATA_ISNULL)){//无数据是返回JSON提示前台接收
			return FinalUtil.DATA_ISNULL_SHOWJSONCH;
		}else if(flag.equals(FinalUtil.DATA_ISPART)){//数据不全进行MAT计算向前按照同期推5年的时间
			return null;
		}else{
			//List<MedicalSalesData> list = medicalSalesDataService.queryByYear5Counts(map);
			List<MedicalSalesData> list2 = medicalSalesDataService.queryByReportLjxsZzlYear(map);
			if(list2.size() == 1){//如果只有一个年份的数据那么就不能做增长率的计算
				return "{\"data\": \"因只有您输入年的数据所以暂且无法做增长率计算！\"}";
			}else if(list2.size() > 1){
				StringBuffer sb = new StringBuffer("[");
				//List<MedicalSalesData> list2 = medicalSalesDataService.queryByReportLjxsZzlYear(map);
//				int num = list2.size() == 2 ? 1 : list2.size()-1;
				for (int i = 0; i < list2.size(); i++) {
					sb.append("{\"");
					sb.append("year\":");
					sb.append("\""+list2.get(i).getSalesYear()+"\"");
					if(i != 0){
						Double db = (((double)list2.get(i).getValue()-(double)list2.get(i-1).getValue())/(double)list2.get(i-1).getValue())*100;
						sb.append(",\"growthRate\":");
						sb.append("\""+df.format(db)+"\"");
					}else{
						sb.append(",\"growthRate\":");
						sb.append("\"\"");
					}
					sb.append(",\"salesValue\":");
					sb.append("\""+df.format(((double)list2.get(i).getValue()/100000000))+"\"");
					sb.append("},");
				}
				RunDate.endDate("运行时间", start);
				return sb.toString().substring(0,sb.toString().lastIndexOf(","))+"]";
			}
			return null;
		}
	}
	
	/**
	 * 查询市场占比
	 * @param entity
	 * @return
	 */
	public List<MedicalSalesData> queryByReportSczbByYear( MedicalSalesData entity){
		Map<String, Object> map = mapIsPut(entity);
		String flag = isQueryMAT(entity);
		if(flag.equals(FinalUtil.DATA_ISNULL)){//无数据是返回JSON提示前台接收
			return null;
		}else if(flag.equals(FinalUtil.DATA_ISPART)){//数据不全进行MAT计算向前按照同期查出最新的一年的时间占比
			return null;
		}else{
			return medicalSalesDataService.queryByReportSczbYear(map);
		}
	}
	
	/**
	 * 查询复合增长率
	 * @param entity
	 * @return
	 */
	@RequestMapping(value="queryByReportFhzzlByYear",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<ScatterMedical> queryByReportFhzzlByYear( MedicalSalesData entity){
		long start = RunDate.startDate();
		List<MedicalSalesData> list = null;
		List<MedicalSalesData> list2 = null;
		List<String> list3 = new ArrayList<String>();
		List<ScatterMedical> list4 = new ArrayList<ScatterMedical>();
		Map<String, Object> map = mapIsPut(entity);
		list2 = medicalSalesDataService.queryByReportFhzzlYear(map);
		for (MedicalSalesData objString : list2) {
			list3.add(objString.getSalesYear());
		}
		list = queryByReportSczbByYear(entity);
		list3 = ListUtil.removeDuplicate(list3);//过滤重复的年份
		int size = Integer.parseInt(list3.get(0))-Integer.parseInt(list3.get(list3.size()-1));
//		DecimalFormat df = new DecimalFormat("######0.0000");
		int j = 0;
		int flagNum = 0;
		if(list != null && list.size()>0){
			for (int i = 0; i < list.size() ; i++) {//数据是经过排序的所以按顺序set是没事情的
				flagNum = 0;
				ScatterMedical smList = new ScatterMedical();
				smList.setZb(list.get(i).getZb());
				for (; j< list2.size() ; j++) {
					if(flagNum > 0){
						break;
					}
					for (int k = 0; k < list2.size(); k++) {
						if(Integer.parseInt(list2.get(j).getSalesYear())-Integer.parseInt(list2.get(k).getSalesYear()) >= size && list2.get(j).getProvincename().equals(list2.get(k).getProvincename())){
							double m = 1.0/(Double.parseDouble(list3.get(0))-Double.parseDouble(list3.get(list3.size()-1)));
							double a = Math.pow((double)list2.get(j).getValue()/(double)list2.get(k).getValue(), m)-1;
							//System.out.println(list2.get(j).getProvincename()+","+list2.get(j).getSalesYear()+"，"+list2.get(k).getSalesYear()+"，"+list2.get(j).getValue()+"，"+list2.get(k).getValue()+"=========="+a);
							a = Double.isNaN(a) == true ? 0 : a;
							smList.setFfzzl(Double.parseDouble(df.format(a*100)));
							smList.setProvinceName(list2.get(j).getProvincename());
							smList.setYear(list2.get(k).getSalesYear()+"-"+list2.get(j).getSalesYear());
							flagNum = 1;
							break;
						}
					}
				}
				list4.add(smList);
			}
		}
		RunDate.endDate("运行时间", start);
		return list4;
	}
	
	/***
	 * 中国医院调脂药外资/合资和内资企业销售展示
	 * @return
	 */
	@RequestMapping(value="queryByWaiZiHeZiXsbxYear",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<ManuType> queryByWaiZiHeZiXsbx(MedicalSalesData entity){
		//entity.setSalesYear("2015");
		Map<String, Object> map = mapIsPut(entity);
		String flag = isQueryMAT(entity);
		if(flag.equals(FinalUtil.DATA_ISNULL)){//无数据是返回JSON提示前台接收
			return null;
		}else if(flag.equals(FinalUtil.DATA_ISPART)){//数据不全进行MAT计算向前按照同期查出最新的一年的时间占比
			return null;
		}else{
			List<ManuType> listPram = new ArrayList<ManuType>();
			ManuType manuType = new ManuType();
			manuType.setHezi("合资");
			manuType.setNeizi("内资");
			listPram.add(manuType);
			map.put("manutype", listPram);
			List<ManuType> list = medicalSalesDataService.queryByReportXsbx(map);
			/*for (int i = 0; i < list.size(); i++) {
				//System.out.println(list.get(i).getTime()+","+list.get(i).getXse()+","+list.get(i).getManuTypeName());
				
			}*/
			return list;
		}
	}
	
	/**
	 * ATC与通用名的销售额占比 
	 * @param entity
	 * 暂时只是模拟了选择通用名
	 * @return
	 */
	@RequestMapping(value="queryByAtcXsZbYear",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<ManuType> queryByAtcXsZb(MedicalSalesData entity){
		//entity.setParentcode("C-10-1");
		//entity.setSalesYear("2015");
		//entity.setAtcType("4");
		Map<String, Object> map = mapIsPut(entity);
		String flag = isQueryMAT(entity);
		if(flag.equals(FinalUtil.DATA_ISNULL)){//无数据是返回JSON提示前台接收
			return null;
		}else if(flag.equals(FinalUtil.DATA_ISPART)){//数据不全进行MAT计算向前按照同期查出最新的一年的时间占比
			return null;
		}else{
			List<ManuType> list = medicalSalesDataService.queryByAtcXsZb(map);
			return list;
		}
	}
	
	/**
	 * 市场最小产品销售额占比 
	 * @param entity
	 * @return
	 */
	@RequestMapping(value="queryByMinniUnitXseZb",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<ManuType> queryByMinniUnitXseZb(MedicalSalesData entity){
		/*entity.setCodeid("1");
		entity.setSalesYear("2015");
		entity.setAtcType("4");*/
		Map<String, Object> map = mapIsPut(entity);
		String flag = isQueryMAT(entity);
		if(flag.equals(FinalUtil.DATA_ISNULL)){//无数据是返回JSON提示前台接收
			return null;
		}else if(flag.equals(FinalUtil.DATA_ISPART)){//数据不全进行MAT计算向前按照同期查出最新的一年的时间占比
			return null;
		}else{
			List<ManuType> list = medicalSalesDataService.queryByMinniUnitXseZb(map);
			return list;
		}
	}
	
	/**
	 * Top10的销售总额占比与增长率
	 * @param entity
	 * @return
	 */
	@RequestMapping(value="queryByTop10XseZbZzl",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String queryByTop10XseZbZzl(MedicalSalesData entity){
//		entity.setSalesYear("2015");
		List<String> list1 = new ArrayList<String>();//存放年
		Map<String, Object> map =mapIsPut(entity);
		long startTime = RunDate.startDate();
		List<ManuType> list = medicalSalesDataService.queryByTop10Xsze(map);//原始数据 只对商品名和时间分组
		
		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				list1.add(list.get(i).getTime());
			}
		}
		list1 = ListUtil.removeDuplicate(list1);
//		map.clear();
//		entity.setInteratc3id(2);
//		map =mapIsPut(entity);
		map.put("timeList", list1);
		if("5".equals(map.get("atcType").toString())){
			map.put("atcType", 4);
		}
		List<ManuType> list2 = medicalSalesDataService.queryByTop10XszeZb(map);//根据时间来查询Top10里的销售总额
		List<ManuType> list3 = medicalSalesDataService.queryByTop10Xszl(map);//根据时间来查询类型销售总额
//		DecimalFormat df = new DecimalFormat("#################0.0000");   
		StringBuffer sb = new StringBuffer("[");
		for (int i = 0; i < list2.size(); i++) {
			for (int j = 0; j < list3.size(); j++) {
				if(list2.get(i).getTime().equals(list3.get(j).getTime())){
					sb.append("{");
					sb.append("\"time\":");
					sb.append("\""+list2.get(i).getTime()+"\",");
					sb.append("\"xsezb\":");
					sb.append("\""+Double.parseDouble(df.format((Double.parseDouble(list2.get(i).getXse())/Double.parseDouble(list3.get(j).getXse()))*100))+"\"");
					if(i != 0){
						Double db = ((Double.parseDouble(list2.get(i).getXse())/Double.parseDouble(list3.get(j).getXse())) - (Double.parseDouble(list2.get(i-1).getXse())/Double.parseDouble(list3.get(j-1).getXse())))/(Double.parseDouble(list2.get(i-1).getXse())/Double.parseDouble(list3.get(j-1).getXse()));
//						System.out.println(list2.get(i).getTime()+"=="+(Double.parseDouble(list2.get(i).getXse())/Double.parseDouble(list3.get(j).getXse()))+"，"+list2.get(i-1).getTime()+"=="+(Double.parseDouble(list2.get(i-1).getXse())/Double.parseDouble(list3.get(j-1).getXse())));
						sb.append(",\"zbzzl\":");
						sb.append("\""+Double.parseDouble(df.format(db))*100+"\"");
					}else{
						sb.append(",\"zbzzl\":");
						sb.append("\"\"");
					}
					sb.append("},");
				}
			}
		}
		sb.append("]");
		RunDate.endDate("运行时长：", startTime);
		return sb.toString().substring(0,sb.toString().lastIndexOf(","))+"]";
	}
	
	/**
	 * Top10的销售额占比
	 * @param entity
	 * @return
	 */
	@RequestMapping(value="queryByTop10XseZb",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<ManuType> queryByTop10XseZb(MedicalSalesData entity){
		long startTime = RunDate.startDate();
//		entity.setSalesYear("2015");
//		entity.setAtcType("3");
//		entity.setCodeid("2");
		Map<String, Object> map = mapIsPut(entity);
		List<ManuType> list = medicalSalesDataService.queryByTop10XseZb(map);
		RunDate.endDate("运行时长：", startTime);
		return list;
	}
	
	/**
	 * Top10厂家表格1
	 * @param entity
	 * @return
	 */
	@RequestMapping(value="queryByTop10ListDataOne",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String queryByTop10ListDataOne(MedicalSalesData entity){
		Map<String, Object> map = mapIsPut(entity);
		List<ListDataOne> list = queryByYearGroup(map);
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(list.get(0).getYear());
		if(list.size() > 3){
			temp.add(list.get(list.size()-3).getYear());
			temp.add(list.get(list.size()-1).getYear());
		}else if(list.size() == 3){
			temp.add(list.get(list.size()-2).getYear());
			temp.add(list.get(list.size()-1).getYear());
		}else if(list.size() == 2){
			temp.add(list.get(list.size()-1).getYear());
		}else if(list.size() == 1){
			temp.add(list.get(list.size()-1).getYear());
		}
		map.put("timeList", temp);
		map.put("timeListlength", temp.size()-1);
		list.clear();
		list = medicalSalesDataService.selectTop10ListDataOne(map);
		StringBuffer sb = new StringBuffer("{html:'");
		//boolean isTag = false;
		double fristScfezbSum=0;//汇总占比最前面一年
		double middleScfezbSum=0;//汇总占比中间一年
		double lastScfezbSum=0;//汇总的占比最新一年
		int hezi=0;//合资企业计数
		int neizi=0;//内资企业计数
		int chanpinnum = 0;//排名最高的产品数量
		double maxscfezb = 0;//排名最高的最新一年的市场份额占比
		//String maxManuname = "";//排名最高的最新一年的公司名字
		double maxscfezzl = 0;//排名最高的最新一年的市场份额增长率
		sb.append("<div class=\"table-responsive\"><table class=\"table table-bordered text-center\">");
		sb.append("<tr>");
		sb.append("<td rowspan=\"2\" colspan=\"2\" class=\"tableHead1\" style=\"vertical-align: middle;\">企业</td>");
		sb.append("<td rowspan=\"2\" class=\"tableHead1\" style=\"vertical-align: middle;\">("+temp.get(temp.size()-1)+")不同规格的产品个数</td>");
		if(temp.size() == 2){
			sb.append("<td colspan=\"2\" class=\"tableHead1\" style=\"vertical-align: middle;\">在医院他汀类调脂药市场份额占比</td>");
		}else if(temp.size() >= 3){
			sb.append("<td colspan=\"3\" class=\"tableHead1\" style=\"vertical-align: middle;\">在医院他汀类调脂药市场份额占比</td>");
		}
		sb.append("<td class=\"tableHead1\" style=\"vertical-align: middle;\">销售额增长率</td>");
		sb.append("</tr>");
		sb.append("<tr>");
		for (int i = 0; i < temp.size(); i++) {
			if(i == temp.size()-1){
				sb.append("<td class=\"tableHead2\">"+temp.get(i)+"↓</td>");
			}else{
				sb.append("<td class=\"tableHead2\">"+temp.get(i)+"</td>");
			}
			
		}
		sb.append("<td style=\"background-color:#ECCA95;\">"+temp.get(temp.size()-1)+"</td>");
		sb.append("</tr>");
		for (int i = 0; i < list.size(); i++) {
			sb.append(i % 2 == 0 ? "<tr class=\"treven\">" : "<tr class=\"trood\">" );
			
			sb.append("<td>"+(i+1)+"</td>");
			if(list.get(i).getManuType().equals("合资")){
				hezi++;
				sb.append("<td style=\"text-align: left;\">"+list.get(i).getManunameCh()+"&nbsp; □</td>");
			}else{
				neizi++;
				sb.append("<td style=\"text-align: left;\">"+list.get(i).getManunameCh()+"&nbsp; △</td>");
			}
//			maxManuname = i == 0 ? list.get(i).getManunameCh():maxManuname;
			sb.append("<td>"+list.get(i).getMinimumCount()+"</td>");
			chanpinnum = i == 0 ? list.get(i).getMinimumCount():chanpinnum;
			sb.append("<td>"+df.format(list.get(i).getFristscfezb())+"%</td>");
			fristScfezbSum+=list.get(i).getFristscfezb();
			if(temp.size() >= 3){
				sb.append("<td>"+df.format(list.get(i).getMiddlescfezb())+"%</td>");
				middleScfezbSum+=list.get(i).getMiddlescfezb();
			}
			sb.append("<td>"+df.format(list.get(i).getLastscfezb())+"%</td>");
			lastScfezbSum+=list.get(i).getLastscfezb();
			maxscfezb = i == 0 ? list.get(i).getLastscfezb():maxscfezb;
			sb.append("<td>"+df.format(list.get(i).getXsezzl() == null ? 0 : list.get(i).getXsezzl())+"%</td>");
			maxscfezzl = i == 0 ? list.get(i).getXsezzl() == null ? 0 : list.get(i).getXsezzl() :maxscfezzl;
			sb.append("</tr>");
		}
		sb.append("<tr>");
		sb.append("<td colspan=\"3\">Top10企业合并销售额占比</td>");
		sb.append("<td>"+df.format(fristScfezbSum)+"%</td>");
		if(temp.size() >= 3){
			sb.append("<td>"+df.format(middleScfezbSum)+"%</td>");
		}
		sb.append("<td>"+df.format(lastScfezbSum)+"%</td>");
		sb.append("<td></td>");
		sb.append("</tr>");
		sb.append("</table></div>");
		sb.append("',");
		sb.append("fristScfezbSum:'"+df.format(fristScfezbSum)+"'");
		if(temp.size() >= 3){
			sb.append(",");
			sb.append("middleScfezbSum:'"+df.format(middleScfezbSum)+"'");
		}
		sb.append(",");
		sb.append("lastScfezbSum:'"+df.format(lastScfezbSum)+"'");
		sb.append(",");
		if(neizi > hezi){
			sb.append("manuTypeTop:'内资占主导'");
		}else if(hezi > neizi){
			sb.append("manuTypeTop:'外资占主导'");
		}else{
			sb.append("manuTypeTop:'外资和内资表现平衡'");
		}
		sb.append(",");
		sb.append("chuse:'"+list.get(0).getManunameCh()+"'");
		sb.append(",");
		sb.append("hezi:'"+hezi+"'");
		sb.append(",");
		sb.append("neizi:'"+neizi+"'");
		sb.append(",");
		sb.append("chanpinnum:'"+chanpinnum+"'");
		sb.append(",");
		sb.append("maxscfezb:'"+maxscfezb+"'");
//		sb.append(",");
//		sb.append("maxmanuname:'"+maxManuname+"'");
		sb.append(",");
		sb.append("maxscfezzl:'"+maxscfezzl+"'");
		/**
		 * 都生成结束后就才可以对list进行排序
		 */
		Collections.sort(list, new Comparator<ListDataOne>() {
			@Override
			public int compare(ListDataOne o1, ListDataOne o2) {
				return o2.getXsezzl() == null ? 0 : o2.getXsezzl().compareTo(o1.getXsezzl() == null ? 0 : o1.getXsezzl());
			}
		});
		sb.append(",");
		sb.append("maxxsezzlmanuname:'"+list.get(0).getManunameCh()+"'");
		sb.append(",");
		sb.append("maxxsezzlzb:'"+list.get(0).getXsezzl()+"'");
		sb.append(",");
		sb.append("}");
		return sb.toString();
	}
	
	/**
	 * 返回年份列表
	 * @param map
	 * @return
	 */
	public List<ListDataOne> queryByYearGroup(Map<String, Object> map){
		return medicalSalesDataService.selectByYearGroup(map);
	}

}
