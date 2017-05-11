package pha.com.code.queryKeyWord.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.ext.ParamConverter.Lazy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pha.com.code.queryKeyWord.model.MedicalForDataInfo;
import pha.com.code.queryKeyWord.service.MedicalForDataInfoService;
import pha.com.common.base.controller.BaseController;
import pha.com.common.base.lucene.LuceneIndexDAO;
import pha.com.common.util.RunDate;

@Controller
@Lazy
@RequestMapping("/medicalForDataInfo")
public class MedicalForDataInfoController extends BaseController<MedicalForDataInfo>{
	
	@Resource
	private MedicalForDataInfoService medicalForDataInfoService;
	
	/**
	 * 添加数据
	 */
	@RequestMapping(value="/add")
	@ResponseBody
	public int add(){
		try {
			long begin = RunDate.startDate();
			this.list = medicalForDataInfoService.selectByIdnexData();
			for (int i = 0; i < this.list.size(); i++) {
				LuceneIndexDAO.createIndex(this.list.get(i));
			}
			System.out.println(RunDate.endDate("创建索引库 ：", begin));
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}
	
	/**
	 * 根据搜过关键字 查询数据
	 * @throws Exception
	 */
	@RequestMapping(value="/searchKeyWords")
	@ResponseBody
	public List<String> searchKeyWords(String strWord) throws Exception{
		List<String> findByName = LuceneIndexDAO.findByMultiFieldName(strWord);
		return findByName;
	}
}
