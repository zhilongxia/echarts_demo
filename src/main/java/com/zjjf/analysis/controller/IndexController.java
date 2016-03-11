package com.zjjf.analysis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.abel533.echarts.Option;
import com.zjjf.analysis.services.impl.EchartsOptionServiceImpl;
import com.zjjf.analysis.services.impl.PieEchartsOptionServiceImpl;
import com.zjjf.analysis.utils.ZfEcharts;

@Controller
@RequestMapping({ "/gateway" })
public class IndexController {

	@Autowired
	private EchartsOptionServiceImpl graphOptionService;
	
	@Autowired
	PieEchartsOptionServiceImpl pieOptionService;

	@RequestMapping(value = "/graph_char")
	public String graphchar() {

		return "echarts/grap_char";
	}

	@RequestMapping(value = "/graphdata")
	public String graphdata() {

		return "echarts/graph_char_data";
	}

	@RequestMapping(value = "/pie_chart")
	public String newload() {

		return "echarts/pie_chart";
	}

	@RequestMapping(value = "/piedata")
	public String pie_chart() {

		return "echarts/pie_chart_data";
	}

	@RequestMapping(value = "/getGraphJson", produces = "application/json; charset=utf-8")
	public @ResponseBody String getGraph_demo() throws JsonProcessingException {

		Option option = new Option();
		try {

			option = graphOptionService.getOption(ZfEcharts.graph);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		return mapper.writeValueAsString(option);
	}

	@RequestMapping(value = "/getPieJson", produces = "application/json; charset=utf-8")
	public @ResponseBody String getPie_demo() throws JsonProcessingException {

		Option option = new Option();
		try {

			option = pieOptionService.getOption(ZfEcharts.pie);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		return mapper.writeValueAsString(option);
	}
}
