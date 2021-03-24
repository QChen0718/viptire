package com.example.notificationtest.entity;

import java.util.List;

public class HomeResultResponse{
    /**
     * productId : 173086
     * brandName : 固铂
     * brandCode : PB-2627
     * categoryCode : PC-1-0001
     * title : 固铂 固铂185/65R1588HC1 185 65 15 C1  H 2020 按条售卖
     * price : 192
     * warehouse : 阳泉仓
     * source : 1
     * productType : 0
     * unitName : 条
     * isTaxInclusive : 0
     * sellStrategies : []
     * maxDiscountAmount : 0
     * tyreIdentification : 0
     */
    private Integer productId;
    private String brandName;
    private String brandCode;
    private String categoryCode;
    private String title;
    private Integer price;
    private String warehouse;
    private Integer source;
    private Integer productType;
    private String unitName;
    private Integer isTaxInclusive;
    private List<Object> sellStrategies;
    private Integer maxDiscountAmount;
    private Integer tyreIdentification;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getIsTaxInclusive() {
        return isTaxInclusive;
    }

    public void setIsTaxInclusive(Integer isTaxInclusive) {
        this.isTaxInclusive = isTaxInclusive;
    }

    public List<Object> getSellStrategies() {
        return sellStrategies;
    }

    public void setSellStrategies(List<Object> sellStrategies) {
        this.sellStrategies = sellStrategies;
    }

    public Integer getMaxDiscountAmount() {
        return maxDiscountAmount;
    }

    public void setMaxDiscountAmount(Integer maxDiscountAmount) {
        this.maxDiscountAmount = maxDiscountAmount;
    }

    public Integer getTyreIdentification() {
        return tyreIdentification;
    }

    public void setTyreIdentification(Integer tyreIdentification) {
        this.tyreIdentification = tyreIdentification;
    }
}
