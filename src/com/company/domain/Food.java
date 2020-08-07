package com.company.domain;

import java.math.BigDecimal;

public class Food {
    private String foodName;
    private String foodExplain;
    private BigDecimal price;
    private Integer bId;

    public Food() {
    }

    public Food(String foodName, String foodExplain, BigDecimal price, Integer bId) {
        this.foodName = foodName;
        this.foodExplain = foodExplain;
        this.price = price;
        this.bId = bId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodExplain() {
        return foodExplain;
    }

    public void setFoodExplain(String foodExplain) {
        this.foodExplain = foodExplain;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    @Override
    public String toString() {
        return "food{" +
                "foodName='" + foodName + '\'' +
                ", foodExplain='" + foodExplain + '\'' +
                ", price=" + price +
                ", bId=" + bId +
                '}';
    }
}
