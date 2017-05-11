package pha.com.code.report.controller;

import javax.ws.rs.ext.ParamConverter.Lazy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pha.com.code.report.model.word.WordModel;
import pha.com.common.util.export.word.TestWord;

@Controller
@Lazy
@RequestMapping("/exportWord")
public class WordController {
	
	@RequestMapping(value="downWord",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public int  downWord(WordModel wordModel){
		TestWord testWord = new TestWord();
		return testWord.creatDoc(wordModel, "TestWord.doc", "Test");
	}
}
