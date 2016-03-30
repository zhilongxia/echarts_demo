package com.zjjf.analysis.controller.sporder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjjf.analysis.beans.vo.LoginVo;
import com.zjjf.analysis.constants.ViewMap;
import com.zjjf.analysis.controller.BaseController;

@Controller
@RequestMapping(value = "/api/sp_order")
public class SpOrderController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(SpOrderController.class);

    
	@RequestMapping(value = "/loadPage.do")
	public String orderLoaded(LoginVo loginRo,  HttpSession session,HttpServletRequest request, Model model) {
		
		HashMap<String, String> tableKeyMap = ViewMap.orderMapView();
		List<String> _vlist = new ArrayList<String>();
		for (Map.Entry<String, String> entry : tableKeyMap.entrySet()) {
			
			_vlist.add(entry.getValue());
			
		}
		request.setAttribute("key_cn", _vlist);
		return "analysis/sporder/sp_order";
	}
	
	@RequestMapping(value = "/spOrderList.do")
	@ResponseBody
	public HashMap<String, Object> querySpOrders(HttpServletRequest request) {
		
		List<String[]> dataList = new ArrayList<String[]>();
		for (int i = 0; i < 6; i++) {
			dataList.add(ViewMap.orderDataView());
		}
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		  InputStream is= null;     
	      String contentStr="";     
	      try {         
	    	  is = request.getInputStream();         
	    	  contentStr= IOUtils.toString(is, "utf-8");     
		 
          } catch (IOException e) { 
              e.printStackTrace();     
		 
          }     
        System.out.println(contentStr); ; 
		HashMap<String, String[]> tempMap = (HashMap<String, String[]>) request.getParameterMap();
		String[] titles  = ViewMap.orderTitleView();
		resultMap.put("key_cn", titles);
		resultMap.put("key_dataList", dataList);
		return resultMap;
	}
}
