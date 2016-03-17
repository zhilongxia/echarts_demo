package com.zjjf.analysis.mapper.analysis;

import java.util.List;

import com.zjjf.analysis.beans.analysis.SpOrderDetail;

public interface SpOrderDetailMapper {

	List<SpOrderDetail> selectOrderDetailByOrderId(String orderId);
}