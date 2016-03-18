package com.zjjf.analysis.beans.analysis;

import java.math.BigDecimal;
import java.util.Date;

public class PlantItem {
    private String id;

    private Integer itemBaseId;

    private Integer areaId;

    private String areaName;

    private BigDecimal areaPrice;

    private BigDecimal plantDisPrice;

    private BigDecimal plantMemPrice;

    private Integer ordId;

    private Date addTime;

    private Date updateTime;

    private Boolean tuijian;

    private Byte status;

    private Boolean isDelete;

    private BigDecimal maoli;

    private BigDecimal fee;

    private Integer spGroupId;

    private String spId;

    private String remark;

    private String youHui;

    private Integer restrict;

    private Integer goodsStock;

    private Integer middleStock;

    private Integer sales;

    private Integer clickRate;

    private Integer upper;

    private Integer lower;

    private BigDecimal scInPrice;

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

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public BigDecimal getAreaPrice() {
        return areaPrice;
    }

    public void setAreaPrice(BigDecimal areaPrice) {
        this.areaPrice = areaPrice;
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

    public Boolean getTuijian() {
        return tuijian;
    }

    public void setTuijian(Boolean tuijian) {
        this.tuijian = tuijian;
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

    public Integer getRestrict() {
        return restrict;
    }

    public void setRestrict(Integer restrict) {
        this.restrict = restrict;
    }

    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

    public Integer getMiddleStock() {
        return middleStock;
    }

    public void setMiddleStock(Integer middleStock) {
        this.middleStock = middleStock;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getClickRate() {
        return clickRate;
    }

    public void setClickRate(Integer clickRate) {
        this.clickRate = clickRate;
    }

    public Integer getUpper() {
        return upper;
    }

    public void setUpper(Integer upper) {
        this.upper = upper;
    }

    public Integer getLower() {
        return lower;
    }

    public void setLower(Integer lower) {
        this.lower = lower;
    }

    public BigDecimal getScInPrice() {
        return scInPrice;
    }

    public void setScInPrice(BigDecimal scInPrice) {
        this.scInPrice = scInPrice;
    }
}