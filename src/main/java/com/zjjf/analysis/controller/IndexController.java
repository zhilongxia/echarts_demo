package com.zjjf.analysis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.abel533.echarts.Option;
import com.zjjf.analysis.services.ExampleService;

@Controller
@RequestMapping({ "/gateway" })
public class IndexController {

	@Autowired
	private ExampleService exampleService;

	@RequestMapping(value = "/origin")
	public String load() {

		return "echarts/origin-demo";
	}

	@RequestMapping(value = "/newdata")
	public String load2() {

		return "echarts/new-data";
	}

	@RequestMapping(value = "/newonload")
	public String newload() {

		return "echarts/echarts-java";
	}

	@RequestMapping(value = "/getMessage", produces = "application/json; charset=utf-8")
	public @ResponseBody String getMessage() throws JsonProcessingException {

		Option option = new Option();
		try {

			option = exampleService.getOption();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		return mapper.writeValueAsString(option);
	}
}
