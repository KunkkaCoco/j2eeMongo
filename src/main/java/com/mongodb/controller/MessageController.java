package com.mongodb.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mongodb.model.Message;
import com.mongodb.service.BaseService;

@Controller
@RequestMapping("/msg")
public class MessageController {

	@Autowired
	private BaseService baseService;

	@RequestMapping("sendMsg")
	public String addItem(@RequestParam String name, @RequestParam String content) {

		Message msg = new Message();
		msg.setName(name);
		msg.setContent(content);
		msg.setTime(System.currentTimeMillis());
		baseService.save(msg, "msg");
		return "success";
	}

	@RequestMapping("queryMsg")
	public String searchUser(HttpServletResponse response, Map<String, Object> context) throws IOException,
			ParseException {
		List<Message> list = baseService.find(null, Message.class, "msg");

		context.put("list", list);
		//
		// Engine engine = Engine.getEngine();
		// Template template = engine.getTemplate("/message.httl");
		// template.render(parameters, response.getOutputStream());

		return "message";
	}
}
