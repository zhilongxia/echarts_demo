package com.zjjf.analysis.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjjf.analysis.beans.analysis.SpOrderInfo;
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

		Integer addTimeIndex = this.getSpOrderInfoIndex_from_db();
		while (true) {
			List<SpOrderInfo> spOrderInfoList = orgSpOrderInfoMapper.selectByIndex(addTimeIndex);
			if (spOrderInfoList.size() == 0) {
				break;
			}
			for (SpOrderInfo spOrderInfo : spOrderInfoList) {
				this.push_orderInfo_to_analysis(spOrderInfo);
				addTimeIndex = spOrderInfo.getCreateTime();
			}
		}
	}

	private void push_orderInfo_to_analysis(SpOrderInfo spOrderInfo) {

		AnaSporderinfo record = new AnaSporderinfo();
		record.setOrg_pk_id(spOrderInfo.getId());
		record.setAcStatus(spOrderInfo.getAcStatus());
		record.setAddTime(new Date());
		record.setConsignee(spOrderInfo.getConsignee());
		record.setCoupon(spOrderInfo.getCoupon());
		record.setCouponId(spOrderInfo.getCouponId());
		record.setFreight(spOrderInfo.getFreight());
		record.setGoodsPrice(spOrderInfo.getGoodsPrice());
		record.setIsDelete(spOrderInfo.getIsDelete());
		record.setKfId(spOrderInfo.getKfId());
		record.setLevel(spOrderInfo.getLevel());
		record.setMobile(spOrderInfo.getMobile());
		record.setOrderId(spOrderInfo.getOrderId());
		record.setOrderPrice(spOrderInfo.getOrderPrice());
		record.setOrg_pk_id(spOrderInfo.getId());
		record.setpId(spOrderInfo.getpId());
		record.setRebate(spOrderInfo.getRebate());
		record.setStatus(spOrderInfo.getStatus());
		record.setSupplierId(spOrderInfo.getSupplierId());
		record.setSupportmetho(spOrderInfo.getSupportmetho());
		record.setSupportStatus(spOrderInfo.getSupportStatus());
		record.setTradeNo(spOrderInfo.getTradeNo());
		record.setZfee(spOrderInfo.getZfee());
		record.setZmaoli(spOrderInfo.getZmaoli());
		record.setCreateTime(new Date().getTime() / 1000L);
		spOrderInfoMapper.insert(record);
	}

	private Integer getSpOrderInfoIndex_from_db() {

		return 0;
	}
}
