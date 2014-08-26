package com.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mongodb.model.Demo;
import com.mongodb.service.BaseService;

@Controller
@RequestMapping("/application")
public class AppController {

	@Autowired
	private BaseService baseService;

	@RequestMapping("addItem")
	public @ResponseBody
	String addItem(@RequestParam String demoid, @RequestParam String name, @RequestParam String description) {
		Demo demo = new Demo();
		demo.setDemoid(demoid);
		demo.setName(name);
		demo.setDescription(description);
		baseService.save(demo, "Demo");
		return "success";
	}

	@RequestMapping("search")
	public @ResponseBody
	String searchUser() {
		List<Demo> list = baseService.find(null, Demo.class, "Demo");
		return JSON.toJSONString(list);
	}
}
