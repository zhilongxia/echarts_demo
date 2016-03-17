package com.zjjf.analysis.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjjf.analysis.beans.analysis.SpOrderDetail;
import com.zjjf.analysis.beans.local.AanSporderdetail;
import com.zjjf.analysis.mapper.analysis.SpOrderDetailMapper;
import com.zjjf.analysis.mapper.local.AanSporderdetailMapper;

@Service
public class SpOrderDetailServiceJobImpl {

	@Autowired
	private SpOrderDetailMapper orgSpOrderdetailMappers;

	@Autowired
	private AanSporderdetailMapper spOrderDetailMapper;

	public void excuse_orderDetail() {

		long beginTime = System.currentTimeMillis();
		Integer addTimeIndex = this.getSpOrderDetailIndex_from_db();
		int i = 0;
		while (true) {
			long beginquere = System.currentTimeMillis();
			List<SpOrderDetail> spOrderDetailList = orgSpOrderdetailMappers.selectByIndex(addTimeIndex);
			i++;
			System.out.println("第" + i + "次查询，spent time：" + (System.currentTimeMillis() - beginquere) + "ms!");
			if (spOrderDetailList.size() == 0) {
				break;
			}
			for (SpOrderDetail orderDetail : spOrderDetailList) {
				this.push_orderDetail_to_analysis(orderDetail);
				addTimeIndex = orderDetail.getCreateTime();
			}
		}
		System.out.println("总共耗时，spent time：" + (System.currentTimeMillis() - beginTime) + "ms!");
	}

	private void push_orderDetail_to_analysis(SpOrderDetail orderDetail) {

		AanSporderdetail record = new AanSporderdetail();

		record.setAddTime(orderDetail.getAddTime());
		record.setFee(orderDetail.getFee());
		record.setItemId(orderDetail.getItemId());
		record.setOrderId(orderDetail.getOrderId());
		record.setOrg_pk_id(orderDetail.getId());
		record.setPlantMemPrice(orderDetail.getPlantMemPrice());
		record.setQuantity(orderDetail.getQuantity());
		record.setSpGroupId(orderDetail.getSpGroupId());
		record.setSpId(orderDetail.getSpId());
		record.setStoreId(orderDetail.getStoreId());
		record.setTotalPrice(orderDetail.getTotalPrice());
		record.setCreateTime(new Date().getTime() / 1000L);
		spOrderDetailMapper.insert(record);
	}

	private Integer getSpOrderDetailIndex_from_db() {

		return 0;
	}
}
