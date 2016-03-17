package com.zjjf.analysis.beans.local;

import java.math.BigDecimal;
import java.util.Date;

public class AanSporderdetail {

	private String id;

	private Integer ana_orderId;

	private String p_orderId;

	private String orderId;

	private String itemId;

	private Short quantity;

	private BigDecimal totalPrice;

	private BigDecimal plantMemPrice;

	private Integer storeId;

	private Date addTime;

	private BigDecimal fee;

	private Integer spGroupId;

	private String spId;

	private Long createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}


	public Integer getAna_orderId() {
		return ana_orderId;
	}

	public void setAna_orderId(Integer ana_orderId) {
		this.ana_orderId = ana_orderId;
	}

	public String getP_orderId() {
		return p_orderId;
	}

	public void setP_orderId(String p_orderId) {
		this.p_orderId = p_orderId == null ? null : p_orderId.trim();
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId == null ? null : orderId.trim();
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId == null ? null : itemId.trim();
	}

	public Short getQuantity() {
		return quantity;
	}

	public void setQuantity(Short quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getPlantMemPrice() {
		return plantMemPrice;
	}

	public void setPlantMemPrice(BigDecimal plantMemPrice) {
		this.plantMemPrice = plantMemPrice;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public Integer getSpGroupId() {
		return spGroupId;
	}

	public void setSpGroupId(Integer spGroupId) {
		this.spGroupId = spGroupId;
	}

	public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId == null ? null : spId.trim();
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

}