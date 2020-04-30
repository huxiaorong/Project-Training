package com.chinese.masuli.idiom.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinese.masuli.entity.Idiom;
import com.chinese.masuli.idiom.service.IdiomService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/idiom")
public class IdiomController {

	@Resource
	private IdiomService idiomService;
	
	@RequestMapping("/rand")
	@ResponseBody
	public String index() throws Exception {
		Idiom idiom = this.idiomService.findIdiomRand();
		Gson gson = new Gson();
		String idiom1 = gson.toJson(idiom);
		return idiom1;
	}
	
	@RequestMapping(value = "edit/{phrase}")
	@ResponseBody
	public void reply(@PathVariable("phrase") String phrase) throws Exception {
		Idiom idiom = this.idiomService.isIdiom(phrase);
		if (idiom.equals("")) {
			
		}else{
			this.idiomService.findIdiomByWordS(phrase);
		}
	}
	
	
}
