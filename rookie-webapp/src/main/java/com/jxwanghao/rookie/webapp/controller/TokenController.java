package com.jxwanghao.rookie.webapp.controller;

import com.jxwanghao.rookie.webapp.interceptor.Token;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghao
 * @version V1.0
 * @date 2017/6/7
 */
@RestController
public class TokenController {

	@Token(save = true)
	@RequestMapping(value = "/saveToken")
	public String saveToken() {
		System.out.println("save token");
		return "save token";
	}

	@Token(remove = true, redirect = "/saveToken")
	@RequestMapping(value = "/checkToken")
	public String checkToken() {
		System.out.println("check token!");
		return "success";
	}
}
