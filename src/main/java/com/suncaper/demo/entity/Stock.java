package com.suncaper.demo.entity;

public class Stock {
    private Long id;

    private Long skuId;

    private Integer skuTotal;

    private Integer curStock;

    private String skuName;

    private Long batchId;

    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Integer getSkuTotal() {
        return skuTotal;
    }

    public void setSkuTotal(Integer skuTotal) {
        this.skuTotal = skuTotal;
    }

    public Integer getCurStock() {
        return curStock;
    }

    public void setCurStock(Integer curStock) {
        this.curStock = curStock;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}