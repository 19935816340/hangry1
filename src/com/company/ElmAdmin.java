package com.company;

import com.company.domain.Admin;
import com.company.domain.Business;
import com.company.view.Impl.AdminViewImpl;
import com.company.view.Impl.BusinessViewImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class ElmAdmin {
    public static void main(String[] args) throws SQLException {
        BusinessViewImpl businessView = new BusinessViewImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------");
        System.out.println("|\t\t\t\t饿了么控制台版后台管理系统 V1.0\t\t\t\t|");
        System.out.println("-----------------------------------------------------------");
//        AdminViewImpl adminView = new AdminViewImpl();
//        Admin admin = adminView.login();
        Business business = businessView.login();
        if (business != null){
        System.out.println("欢迎来到饿了吗后台管理系统");
        int menu = 0;
        while (menu != 5){
            System.out.println("========= 1.所有商家列表=2.搜索商家=3.新建商家=4.删除商家=5.退出系统 =========");
            System.out.println("请输入一个数选择服务");
            menu = scanner.nextInt();
            switch (menu){
                case 1:
                    System.out.println("1.所有商家列表");
                    businessView.findAll();
                    break;
                case 2:
                    System.out.println("2.搜索商家");
                    businessView.souSuo();
                    break;
                case 3:
                    System.out.println("3.新建商家");
                    businessView.add();
                    break;
                case 4:
                    System.out.println("4.删除商家");
                    businessView.drop();
                    break;
                case 5:
                    System.out.println("5.退出系统");
                    break;
                default:
                    System.out.println("没有这个菜单项");
                    break;
            }
        }
    }else {
            System.out.println("账号密码输入错误");
        }
    }
}
