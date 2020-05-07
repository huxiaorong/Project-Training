package com.chinese.masuli.idiom.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinese.entity.Idiom;
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

	@RequestMapping(value = "reply")
	@ResponseBody
	public String reply(@RequestParam("userContent") String userContent, @RequestParam("phrase") String phrase)
			throws Exception {
		Idiom idiom = this.idiomService.isIdiom(userContent);
		if (idiom == null) {
			return "{\"r\":\"fail\"}";
		} else {
			if (!idiomService.isLogical(userContent, phrase)) {
				return "{\"r\":\"false\"}";
			} else {
				List<Idiom> idioms = this.idiomService.findIdiomByWordS(userContent);
				if (idioms.isEmpty()) {
					return "{\"r\":\"defeat\"}";
				} else {
					Idiom idiom3 = idioms.get(0);
					Gson gson = new Gson();
					String idiom1 = gson.toJson(idiom3);
					return idiom1;
				}
			}
		}
	}

	@RequestMapping(value = "user")
	@ResponseBody
	public String user(@RequestParam("userContent") String userContent) throws Exception {
		Idiom idiom = this.idiomService.isIdiom(userContent);
		if (idiom == null) {
			return "{\"r\":\"fail\"}";
		} else {
			List<Idiom> idioms = this.idiomService.findIdiomByWordS(userContent);
			if (idioms.isEmpty()) {
				return "{\"r\":\"defeat\"}";
			} else {
				Idiom idiom3 = idioms.get(0);
				Gson gson = new Gson();
				String idiom1 = gson.toJson(idiom3);
				return idiom1;
			}
		}
	}
	
	
	@RequestMapping(value = "detail")
	@ResponseBody
	public String idiomDetaill(@RequestParam("content") String content) throws Exception {
		Idiom idiom = this.idiomService.isIdiom(content);
		if (idiom == null) {
			return "{\"r\":\"fail\"}";
		} else {
			Gson gson = new Gson();
			String idiom1 = gson.toJson(idiom);
			return idiom1;
		}
	}
	

}
