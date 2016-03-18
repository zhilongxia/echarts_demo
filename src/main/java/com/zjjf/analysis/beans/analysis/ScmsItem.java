package com.zjjf.analysis.beans.analysis;

import java.math.BigDecimal;
import java.util.Date;

public class ScmsItem {
    private String id;

    private Integer itemBaseId;

    private String goodName;

    private String managerId;

    private String groupId;

    private Integer areaId;

    private BigDecimal areaPrice;

    private String areaName;

    private BigDecimal zjjfPrice;

    private BigDecimal marketPrice;

    private Integer year;

    private Integer month;

    private String miniumId;

    private Integer sales;

    private Integer ordId;

    private Date addTime;

    private Date updateTime;

    private String mark;

    private Byte status;

    private Boolean isDelete;
    
    private Integer createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getItemBaseId() {
        return itemBaseId;
    }

    public void setItemBaseId(Integer itemBaseId) {
        this.itemBaseId = itemBaseId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId == null ? null : managerId.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public BigDecimal getAreaPrice() {
        return areaPrice;
    }

    public void setAreaPrice(BigDecimal areaPrice) {
        this.areaPrice = areaPrice;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public BigDecimal getZjjfPrice() {
        return zjjfPrice;
    }

    public void setZjjfPrice(BigDecimal zjjfPrice) {
        this.zjjfPrice = zjjfPrice;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getMiniumId() {
        return miniumId;
    }

    public void setMiniumId(String miniumId) {
        this.miniumId = miniumId == null ? null : miniumId.trim();
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getOrdId() {
        return ordId;
    }

    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
    
}