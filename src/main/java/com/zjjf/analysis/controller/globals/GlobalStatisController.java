package com.zjjf.analysis.controller.globals;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjjf.analysis.beans.analysis.GlobalStatisVo;

@Controller
@RequestMapping(value = "/analysis/statis")
public class GlobalStatisController {

	@RequestMapping(value = "/toStatisPage.do")
	public String toStatisPage(Model model, GlobalStatisVo statisVo) {

		return "analysis/globalStatisList";
	}

}
