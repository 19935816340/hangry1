package com.company.test;

import com.company.Dao.Impl.AdminDaoImpl;
import com.company.Dao.Impl.BusinessDaoImpl;
import com.company.Dao.Impl.FoodDaoImpl;
import com.company.domain.Business;

import java.math.BigDecimal;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException {
//        AdminDaoImpl adminDao1 = new AdminDaoImpl();
//        System.out.println(adminDao1.get("王磊","123"));
//        FoodDaoImpl foodDao = new FoodDaoImpl();
//        System.out.println(foodDao.get("鲜"));
        BusinessDaoImpl businessDao = new BusinessDaoImpl();
//        Business business = new Business("456","李四家的店","葫芦岛","。。。",new BigDecimal("10"),new BigDecimal(2));
//        businessDao.add(business);


    }
}
