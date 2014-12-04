package com.mongodb.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mongodb.model.Msge;
import com.mongodb.service.BaseService;

@Controller
@RequestMapping("/msg")
public class MessageController {

	@Autowired
	private BaseService baseService;

	@RequestMapping("sendMsg")
	public String addItem(String name, String content) {

		Msge msg = new Msge();
		msg.setName(name);
		msg.setContent(content);
		msg.setTime(System.currentTimeMillis());
		baseService.save(msg, "msg");
		return "redirect:/msg/queryMsg.do?name=" + name;
	}

	@RequestMapping("queryMsg")
	public String searchUser(Map<String, Object> context, String name) throws IOException, ParseException {
		List<Msge> list = baseService.find(null, Msge.class, "msg");

		context.put("list", list);
		//
		// Engine engine = Engine.getEngine();
		// Template template = engine.getTemplate("/message.httl");
		// template.render(parameters, response.getOutputStream());
		context.put("name", name);
		return "message";
	}
}
