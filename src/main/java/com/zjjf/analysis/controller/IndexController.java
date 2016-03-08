package com.zjjf.analysis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/gateway" })
public class IndexController {

	@RequestMapping(value = "/onload")
	public String load() {

		return "echarts/index";
	}
}
