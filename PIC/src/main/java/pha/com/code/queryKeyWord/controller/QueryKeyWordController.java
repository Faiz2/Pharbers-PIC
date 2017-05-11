package pha.com.code.queryKeyWord.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.ext.ParamConverter.Lazy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pha.com.code.queryKeyWord.model.QueryKeyWord;
import pha.com.code.queryKeyWord.service.QueryKeyWordService;
import pha.com.common.base.controller.BaseController;
import pha.com.common.base.lucene.LuceneIndexDAO;

@Controller
@Lazy
@RequestMapping("/queryByKeyWord")
public class QueryKeyWordController extends BaseController<QueryKeyWord> {
	
	@Resource
	private QueryKeyWordService medicalsalesdataService;
	
	/**
	 * 搜索关键字返回json
	 * @param key 关键词
	 * @return json
	 */
	@RequestMapping(value="queryByKey", method=RequestMethod.POST, produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<String> queryByKey(String key){
		List<String> findByName = null;
		try {
			findByName = LuceneIndexDAO.findByMultiFieldName(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findByName;
	}
}
