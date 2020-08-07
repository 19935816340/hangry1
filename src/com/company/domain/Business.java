package com.company.domain;

import java.math.BigDecimal;

public class Business {
    private Integer id;
    private String password;

    public Business(String password, String name, String addr, String ex, BigDecimal starPrice, BigDecimal sendPrice) {
        this.password = password;
        this.name = name;
        this.addr = addr;
        Ex = ex;
        this.starPrice = starPrice;
        this.sendPrice = sendPrice;
    }

    private String name;
    private String addr;
    private String Ex;
    private BigDecimal starPrice;
    private BigDecimal sendPrice;

    public Business() {
    }

    public Business(Integer id,String password, String name, String addr, String ex, BigDecimal starPrice, BigDecimal sendPrice) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.addr = addr;
        Ex = ex;
        this.starPrice = starPrice;
        this.sendPrice = sendPrice;
    }

    public String getPassword() {
        return password;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "店名叫" + name +
                ", 地址在" + addr +
                ", 简介：" + Ex +
                ",订饭 " + starPrice +
                "元起送, 配送费统一为" + sendPrice +
                "元，欢迎订餐";
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEx() {
        return Ex;
    }

    public void setEx(String ex) {
        Ex = ex;
    }

    public BigDecimal getStarPrice() {
        return starPrice;
    }

    public void setStarPrice(BigDecimal starPrice) {
        this.starPrice = starPrice;
    }

    public BigDecimal getSendPrice() {
        return sendPrice;
    }

    public void setSendPrice(BigDecimal sendPrice) {
        this.sendPrice = sendPrice;
    }

}
