package mang.demo.springmvc.web.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/webIndex")
public class WebIndexController {
	
	
	/**
	 * 演示一般的get请求(不查数据库)
	 * http://127.0.0.1:8080/springmvc-demo-web/webIndex/test.query/
	 * */
	@RequestMapping(value = "/test.query", method = RequestMethod.GET)
	@ResponseBody
	public Date index() {
		System.out.println("hello world");
		Date date=new Date();
		return date;
	}
	
}
