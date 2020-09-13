package com.demo.api.dto;

/**
 * @author Gayan Samuditha
 */


public class CartonPriceCalcReq {

    private Long itemId;

    private Integer itemAmount;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(Integer itemAmount) {
        this.itemAmount = itemAmount;
    }

}
