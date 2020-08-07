package com.company.domain;

import java.math.BigDecimal;

public class Business {
    private String password;
    private String name;
    private String addr;
    private String Ex;
    private BigDecimal starPrice;
    private BigDecimal sendPrice;

    public Business() {
    }

    public Business(String password, String name, String addr, String ex, BigDecimal starPrice, BigDecimal sendPrice) {
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

    @Override
    public String toString() {
        return "business{" +
                "password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", Ex='" + Ex + '\'' +
                ", starPrice=" + starPrice +
                ", sendPrice=" + sendPrice +
                '}';
    }
}
