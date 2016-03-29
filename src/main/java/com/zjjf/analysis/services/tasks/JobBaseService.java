package com.zjjf.analysis.services.tasks;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjjf.analysis.beans.analysis.SpOrderDetail;
import com.zjjf.analysis.beans.analysis.SpOrderInfo;
import com.zjjf.analysis.beans.local.AanSporderdetail;
import com.zjjf.analysis.beans.local.AnaSporderinfo;
import com.zjjf.analysis.mapper.analysis.SpOrderDetailMapper;
import com.zjjf.analysis.mapper.analysis.SpOrderInfoMapper;
import com.zjjf.analysis.mapper.local.AanSporderdetailMapper;
import com.zjjf.analysis.mapper.local.AnaSporderinfoMapper;

@Service
public class JobBaseService {

	@Autowired
	private SpOrderInfoMapper orgSpOrderInfoMapper;

	@Autowired
	private AnaSporderinfoMapper spOrderInfoMapper;

	@Autowired
	private SpOrderDetailMapper orgSpOrderdetailMappers;

	@Autowired
	private AanSporderdetailMapper spOrderDetailMapper;

	public void excuse_orderInfo() {

		long beginTime = System.currentTimeMillis();
		Integer addTimeIndex = this.getSpOrderInfoIndex_from_db();
		int i = 0;
		while (true) {
			long beginquere = System.currentTimeMillis();
			List<SpOrderInfo> spOrderInfoList = orgSpOrderInfoMapper.selectByIndex(addTimeIndex);
			i++;
			System.out.println("第" + i + "次查询，spent time：" + (System.currentTimeMillis() - beginquere) + "ms!");
			if (spOrderInfoList.size() == 0) {
				break;
			}
			for (SpOrderInfo spOrderInfo : spOrderInfoList) {
				orderInfo_process(spOrderInfo);
				// move list index
				addTimeIndex = spOrderInfo.getCreateTime();
			}
		}
		System.out.println("总共耗时，spent time：" + (System.currentTimeMillis() - beginTime) + "ms!");
	}

	private void orderInfo_process(SpOrderInfo spOrderInfo) {
		AnaSporderinfo recode = new AnaSporderinfo();
		this.push_orderInfo_to_analysis(spOrderInfo, recode);
		this.push_orderDetail_to_analysis_by_orderId(recode.getId(), spOrderInfo);
	}

	// push orderInfo to BI_analysis
	private void push_orderInfo_to_analysis(SpOrderInfo spOrderInfo, AnaSporderinfo recode) {
		addAnaSporderinfo(spOrderInfo, recode);
	}

	// push the orderDetail queryed by orderId to BI_analysis
	private void push_orderDetail_to_analysis_by_orderId(Integer anaOrderId, SpOrderInfo spOrderInfo) {

		List<SpOrderDetail> spOrderDetailList = orgSpOrderdetailMappers.selectOrderDetailByOrderId(spOrderInfo.getOrderId());
		for (SpOrderDetail spOrderDetail : spOrderDetailList) {
			this.addAanSporderdetail(spOrderDetail, anaOrderId);
		}
	}

	private void addAnaSporderinfo(SpOrderInfo spOrderInfo, AnaSporderinfo record) {

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

	private void addAanSporderdetail(SpOrderDetail orderDetail, Integer anaOrderId) {

		AanSporderdetail record = new AanSporderdetail();
		record.setAddTime(orderDetail.getAddTime());
		record.setFee(orderDetail.getFee());
		record.setItemId(orderDetail.getItemId());
		record.setOrderId(orderDetail.getOrderId());
		record.setAna_orderId(anaOrderId);
		record.setPlantMemPrice(orderDetail.getPlantMemPrice());
		record.setQuantity(orderDetail.getQuantity());
		record.setSpGroupId(orderDetail.getSpGroupId());
		record.setSpId(orderDetail.getSpId());
		record.setStoreId(orderDetail.getStoreId());
		record.setTotalPrice(orderDetail.getTotalPrice());
		record.setCreateTime(new Date().getTime() / 1000L);
		spOrderDetailMapper.insert(record);
	}

	private Integer getSpOrderInfoIndex_from_db() {

		return 0;
	}

}
