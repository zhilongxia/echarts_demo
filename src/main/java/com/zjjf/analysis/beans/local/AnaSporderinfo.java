package com.zjjf.analysis.beans.local;

import java.math.BigDecimal;
import java.util.Date;

public class AnaSporderinfo {
	
    private Integer id;

    private String org_pk_id;

    private String orderId;

    private String tradeNo;

    private BigDecimal goodsPrice;

    private BigDecimal orderPrice;

    private String kfId;

    private String consignee;

    private String mobile;

    private Byte status;

    private Byte supportmetho;

    private String supplierId;

    private Boolean isDelete;

    private BigDecimal zmaoli;

    private BigDecimal zfee;

    private Integer acStatus;

    private BigDecimal rebate;

    private Byte supportStatus;

    private Byte level;

    private String pId;

    private BigDecimal freight;

    private BigDecimal coupon;

    private String couponId;

    private Date addTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrg_pk_id() {
        return org_pk_id;
    }

    public void setOrg_pk_id(String org_pk_id) {
        this.org_pk_id = org_pk_id == null ? null : org_pk_id.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getKfId() {
        return kfId;
    }

    public void setKfId(String kfId) {
        this.kfId = kfId == null ? null : kfId.trim();
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getSupportmetho() {
        return supportmetho;
    }

    public void setSupportmetho(Byte supportmetho) {
        this.supportmetho = supportmetho;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public BigDecimal getZmaoli() {
        return zmaoli;
    }

    public void setZmaoli(BigDecimal zmaoli) {
        this.zmaoli = zmaoli;
    }

    public BigDecimal getZfee() {
        return zfee;
    }

    public void setZfee(BigDecimal zfee) {
        this.zfee = zfee;
    }

    public Integer getAcStatus() {
        return acStatus;
    }

    public void setAcStatus(Integer acStatus) {
        this.acStatus = acStatus;
    }

    public BigDecimal getRebate() {
        return rebate;
    }

    public void setRebate(BigDecimal rebate) {
        this.rebate = rebate;
    }

    public Byte getSupportStatus() {
        return supportStatus;
    }

    public void setSupportStatus(Byte supportStatus) {
        this.supportStatus = supportStatus;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId == null ? null : pId.trim();
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public BigDecimal getCoupon() {
        return coupon;
    }

    public void setCoupon(BigDecimal coupon) {
        this.coupon = coupon;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}