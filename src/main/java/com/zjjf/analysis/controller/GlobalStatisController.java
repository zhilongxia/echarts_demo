package com.zjjf.analysis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjjf.analysis.beans.GlobalStatisVo;

@Controller
@RequestMapping(value = "/analysis/statis")
public class GlobalStatisController {

	@RequestMapping(value = "/toStatisPage.do")
	public String toStatisPage(Model model, GlobalStatisVo statisVo) {

		return "analysis/globalStatisList";
	}

}
