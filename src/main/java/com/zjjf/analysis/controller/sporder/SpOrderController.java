package com.zjjf.analysis.controller.sporder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjjf.analysis.constants.ViewMap;
import com.zjjf.analysis.controller.BaseController;

@Controller
@RequestMapping(value = "/api/sp_order")
public class SpOrderController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(SpOrderController.class);

	@RequestMapping(value = "/loadPage.do")
	public String orderLoaded(HttpServletRequest request) {

		return "analysis/sporder/sp_order";
	}

	/**
	 * 获取交易订单数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/spOrderList.do")
	@ResponseBody
	public HashMap<String, Object> querySpOrders(HttpServletRequest request) {

		List<String[]> dataList = new ArrayList<String[]>();
		for (int i = 0; i < 6; i++) {
			dataList.add(ViewMap.orderDataView());
		}
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		InputStream is = null;
		String contentStr = "";
		try {
			is = request.getInputStream();
			contentStr = IOUtils.toString(is, "utf-8");
		} catch (IOException e) {
			e.printStackTrace();

		}
		System.out.println(contentStr);
		HashMap<String, String[]> paramMap = (HashMap<String, String[]>) request.getParameterMap();
		logger.info("交易订单传入参数 paramMap:" + paramMap);
		String[] titles = ViewMap.orderTitleView();
		resultMap.put("key_cn", titles);
		resultMap.put("key_dataList", dataList);
		return resultMap;
	}
}
