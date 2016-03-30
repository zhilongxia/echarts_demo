package com.zjjf.analysis.services;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjjf.analysis.common.excel.ExportBigData;
import com.zjjf.analysis.utils.DateUtils;

public class ExcelExportServcice {
	
	private static Logger logger = LoggerFactory.getLogger(ExcelExportServcice.class);
	
	@Autowired
	private ExportBigData exportBigData;
	
	
	/**
	 * 导出店铺信息数据
	 * @param user
	 * @param request
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
   @RequestMapping(value="/export.do")
   public void exportStoreList(HttpServletRequest request, HttpServletResponse response) {
		 OutputStream out = null;
		 
		String startTime = null;
		String endTime = null;
		try {
			 String fileName = DateUtils.getDate("yyyyMMddHHmmss");
			 response.setHeader("content-disposition", "attachment;filename=" + fileName + ".zip");  
            out = response.getOutputStream();						
            
	         String[] headers = { "区域","店铺编码", "店铺名称", "店铺老板", "店铺地址", "店铺电话", "注册时间", "商铺定格", "业务员电话", "业务员名称", "店铺状态", "营业执照"};
	         List<String>  list = new ArrayList<String>();
	         if(StringUtils.isNotBlank(startTime)){
	        	 list.add(startTime);
	         }
	         if(StringUtils.isNotBlank(endTime)){
	        	 list.add(endTime);
	         }
	         //将list转化为数组格式
	         final int size = list.size();
	         Object[] sqlParams = (Object[])list.toArray(new Object[size]);
	         StringBuffer sbSql = new StringBuffer();
			 sbSql.append(" SELECT ");
			 sbSql.append(" r.NAME AS areaName,s.id,s. NAME,s.contact,s.address,s.mobile AS shopTel, ");
			 sbSql.append(" DATE_FORMAT(s.addTime, '%Y-%m-%d') AS addTime,sp. NAME AS shopRatedName, ");
			 sbSql.append(" si.yewuRenTel,tt.userName AS yewuRenName, case when s.`status` = 0 then '关闭' ");
			 sbSql.append(" when s.`status` = 1 then '正常' when s.`status` = 2 then '审核中' ");
			 sbSql.append(" when s.`status` = 3 then '审核不通过' else '其他' end status, si.licenseNum ");
			 sbSql.append(" FROM Store s ");
			 sbSql.append(" LEFT JOIN StoreInfo si ON si.id = s.id ");
			 sbSql.append(" LEFT JOIN SpGroup sp ON s.spGroupId = sp.id ");
			 sbSql.append(" LEFT JOIN Region r ON s.areaId = r.id ");
			 sbSql.append(" LEFT JOIN Salesman tt ON tt.mobile = si.yewuRenTel ");
			 sbSql.append(" WHERE 1=1  ");
	         if(StringUtils.isNotBlank(startTime)){
	        	 sbSql.append(" and s.addTime >=DATE_FORMAT(?, '%Y-%m-%d') ");
	         }
	         if(StringUtils.isNotBlank(endTime)){
	        	 sbSql.append(" AND s.addTime <=DATE_FORMAT(DATE_ADD(?,INTERVAL 1 DAY), '%Y-%m-%d') ");
	         }
			 sbSql.append(" ORDER BY s.addTime desc ");
	         System.err.println(sbSql.toString());
	         exportBigData.exportToZip(headers, out, 50000, sbSql.toString(), sqlParams);
		} catch (Exception e) {
			logger.error("店铺信息 控制器中的exportStoreList方法异常：{}",e.getMessage());
		}finally{
			try {
				out.close();
			} catch (IOException e) {
				logger.error("店铺信息中的export方法IO关闭异常：{}",e.getMessage());
			}
		}
   }
}
