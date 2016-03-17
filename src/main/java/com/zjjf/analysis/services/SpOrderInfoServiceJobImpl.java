package com.zjjf.analysis.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjjf.analysis.beans.local.AnaSporderinfo;
import com.zjjf.analysis.mapper.analysis.SpOrderInfoMapper;
import com.zjjf.analysis.mapper.local.AnaSporderinfoMapper;

@Service
public class SpOrderInfoServiceJobImpl {

	@Autowired
	private SpOrderInfoMapper orgSpOrderInfoMapper;

	@Autowired
	private AnaSporderinfoMapper spOrderInfoMapper;

	public void excuse() {

		com.zjjf.analysis.beans.analysis.SpOrderInfo SpOrderInfo = orgSpOrderInfoMapper.selectByPrimaryKey("000000004fb73661014fb759d2d10622");

		if (SpOrderInfo != null) {
			AnaSporderinfo record = new AnaSporderinfo();
			record.setId(1);
			record.setOrg_pk_id(SpOrderInfo.getId());
			record.setOrderId(SpOrderInfo.getOrderId());
			record.setGoodsPrice(SpOrderInfo.getGoodsPrice());
			record.setOrderPrice(SpOrderInfo.getOrderPrice());
			record.setConsignee(SpOrderInfo.getConsignee());
			record.setMobile(SpOrderInfo.getMobile());
			record.setStatus(SpOrderInfo.getStatus());
			record.setSupportmetho(SpOrderInfo.getSupportmetho());
			record.setIsDelete(SpOrderInfo.getIsDelete());
			record.setAddTime(new Date());
			spOrderInfoMapper.insert(record);
		}else{
			System.out.println("length is 0!");
		}
	}
}
