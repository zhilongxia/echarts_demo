package com.zjjf.analysis.beans.analysis;

import java.math.BigDecimal;
import java.util.Date;

public class SpOrderDetail {

	private String id;

	private String orderId;

	private String orderId2;

	private String itemId;

	private String barCode;

	private String brand;

	private String name;

	private String spec;

	private String img;

	private Short quantity;

	private BigDecimal price;

	private BigDecimal totalPrice;

	private BigDecimal plantDisPrice;

	private BigDecimal plantMemPrice;

	private BigDecimal maoli;

	private BigDecimal fee;

	private Integer storeId;

	private Integer spGroupId;

	private String spId;

	private String remark;

	private String youHui;

	private Date addTime;

	private Boolean isDelete;

	private Integer restrict;

	private String col1;

	private String col2;

	private String col3;

	private Integer createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId == null ? null : orderId.trim();
	}

	public String getOrderId2() {
		return orderId2;
	}

	public void setOrderId2(String orderId2) {
		this.orderId2 = orderId2 == null ? null : orderId2.trim();
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId == null ? null : itemId.trim();
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode == null ? null : barCode.trim();
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand == null ? null : brand.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec == null ? null : spec.trim();
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img == null ? null : img.trim();
	}

	public Short getQuantity() {
		return quantity;
	}

	public void setQuantity(Short quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getPlantDisPrice() {
		return plantDisPrice;
	}

	public void setPlantDisPrice(BigDecimal plantDisPrice) {
		this.plantDisPrice = plantDisPrice;
	}

	public BigDecimal getPlantMemPrice() {
		return plantMemPrice;
	}

	public void setPlantMemPrice(BigDecimal plantMemPrice) {
		this.plantMemPrice = plantMemPrice;
	}

	public BigDecimal getMaoli() {
		return maoli;
	}

	public void setMaoli(BigDecimal maoli) {
		this.maoli = maoli;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getYouHui() {
		return youHui;
	}

	public void setYouHui(String youHui) {
		this.youHui = youHui == null ? null : youHui.trim();
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getRestrict() {
		return restrict;
	}

	public void setRestrict(Integer restrict) {
		this.restrict = restrict;
	}

	public String getCol1() {
		return col1;
	}

	public void setCol1(String col1) {
		this.col1 = col1 == null ? null : col1.trim();
	}

	public String getCol2() {
		return col2;
	}

	public void setCol2(String col2) {
		this.col2 = col2 == null ? null : col2.trim();
	}

	public String getCol3() {
		return col3;
	}

	public void setCol3(String col3) {
		this.col3 = col3 == null ? null : col3.trim();
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

}