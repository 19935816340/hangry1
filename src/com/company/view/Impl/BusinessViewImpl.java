package com.company.view.Impl;

import com.company.Dao.Impl.BusinessDaoImpl;
import com.company.domain.Business;
import com.company.view.BusinessView;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

public class BusinessViewImpl implements BusinessView {
    Scanner scanner = new Scanner(System.in);
    BusinessDaoImpl businessDao = new BusinessDaoImpl();

    @Override
    public Business login() {
        System.out.println("请输入您的商户id");

        int BId = scanner.nextInt();
        System.out.println("请输入您的登录密码");
        String Password = scanner.next();

        return businessDao.login(BId,Password);
    }

    @Override
    public void drop() {
        System.out.println("请输入要删除的店家ID：");
        Integer id = scanner.nextInt();
        businessDao.drop(id);
    }

    @Override
    public void add() throws SQLException {
        System.out.println("请依次输入要添加的店家信息");
        System.out.println("商户密码：");
        String password = scanner.next();
        System.out.println("店铺名：");
        String name = scanner.next();
        System.out.println("地址：");
        String loc = scanner.next();
        System.out.println("简介：");
        String mx = scanner.next();
        System.out.println("消费多少元起送：");
        BigDecimal start = scanner.nextBigDecimal();
        System.out.println("配送费价格：");
        BigDecimal send = scanner.nextBigDecimal();
        Business business = new Business(password,name,loc,mx,start,send);
        businessDao.add(business);
    }

    @Override
    public void souSuo() {
        System.out.println("请输入Y/N，Y代表查找名称，N代表查找地址");
        String s = scanner.next();
        if (s.equalsIgnoreCase("y")||s.equalsIgnoreCase("n")){
            System.out.println("请输入关键字：");
            String name = scanner.next();
            businessDao.souSuo(name,s);
        }else
            System.out.println("请输入正确的字母");

    }

    @Override
    public void findAll() throws SQLException {
        businessDao.findAll();
    }
}
