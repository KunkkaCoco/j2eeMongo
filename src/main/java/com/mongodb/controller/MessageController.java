package com.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
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
		return "msg";
	}

	@RequestMapping("queryMsg")
	public @ResponseBody String searchUser() {
		List<Message> list = baseService.find(null, Message.class, "msg");
		return JSON.toJSONString(list);
	}

}
