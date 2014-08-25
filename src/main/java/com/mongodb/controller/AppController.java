package com.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mongodb.model.Beer;
import com.mongodb.service.BaseService;

@Controller
@RequestMapping(value = "/application")
public class AppController {

	@Autowired
	private BaseService baseService;

	@RequestMapping("addItem")
	public @ResponseBody
	String addItem(@RequestParam String id, @RequestParam String name, @RequestParam String description) {
		Beer beer = new Beer();
		beer.setId(id);
		beer.setName(name);
		beer.setDescription(description);
		baseService.save(beer, "beer");
		return "success";
	}

	@RequestMapping("search")
	public @ResponseBody
	String searchUser() {
		List<Beer> list = baseService.find(null, Beer.class, "beer");
		return JSON.toJSONString(list);
	}
}
