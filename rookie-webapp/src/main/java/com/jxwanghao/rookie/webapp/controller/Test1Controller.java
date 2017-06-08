package com.jxwanghao.rookie.webapp.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghao
 * @version V1.0
 * @date 2017/6/7
 */
@RestController
public class Test1Controller {

	@RequestMapping("/string")
	public String string() {
		return "index";
	}

	@RequestMapping("/json")
	public JSONObject json() {
		JSONObject object = new JSONObject();
		object.put("user", "35");
		object.put("name", "wanghao");
		return object;
	}
}
