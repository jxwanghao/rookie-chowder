package com.jxwanghao.rookie.webapp.controller;

import com.jxwanghao.rookie.webapp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wanghao
 * @version V1.0
 * @date 2017/6/6
 */
@Controller
public class TestController {

	@Autowired
	private TestService testService;

	@RequestMapping("/")
	public String homepage() {
		return "index";
	}

	@RequestMapping(value = "/test")
	public void test() {
		System.out.println("test, test, test");
	}
}
