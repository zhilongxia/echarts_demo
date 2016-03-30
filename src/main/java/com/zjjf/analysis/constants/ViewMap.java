package com.zjjf.analysis.constants;

import java.util.HashMap;

public class ViewMap {

	public static HashMap<String, String> orderMapView() {

		HashMap<String, String> tableKeyMap = new HashMap<String, String>();

		tableKeyMap.put("cityId", "城市");
		tableKeyMap.put("areaId", "区域");
		tableKeyMap.put("gridId", "定格");
		tableKeyMap.put("storeName", "便利店名称");
		tableKeyMap.put("orderTime", "下单时间");
		tableKeyMap.put("orderNo", "订单号");
		tableKeyMap.put("chirdOrderNo", "子订单号");
		tableKeyMap.put("productNum", "商品数量");
		tableKeyMap.put("orderSku", "订单SKU");
		tableKeyMap.put("goodsPrice", "订单商品价格");
		tableKeyMap.put("coupon", "优惠券金额");
		tableKeyMap.put("rebate", "满减");
		tableKeyMap.put("orderPrice", "订单金额");
		tableKeyMap.put("zfree", "订单费用");
		tableKeyMap.put("supportmetho", "订单支付方式");
		tableKeyMap.put("supportStatus", "支付状态");
		tableKeyMap.put("supplierName", "配送商");
		tableKeyMap.put("supplierStatus", "订单配送状态");
		return tableKeyMap;
	}
	
	public static String[] orderTitleView() {

		return new String[]{"城市", "区域", "定格", "便利店名称", "下单时间", "订单号", "子订单号", "商品数量",
				"订单SKU", "订单商品价格", "优惠券金额", "满减", "订单金额", "订单费用", "订单支付方式", "支付状态", "配送商", "订单配送状态"};
	}
	
	public static String[] orderDataView() {

		return new String[]{"深圳", "南山", "滨海", "发发便利店", "2016-3-10 12:20:30", "201509102102410450", "201509102102410450", "20",
				"5", "3.5", "20", "5", "100", "10", "微信", "已支付", "深大仓库", "已配送"};
	}
}
